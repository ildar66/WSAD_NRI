<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<META http-equiv="Content-Type" content="text/html;charset=windows-1251">
<title>Календарь</title>
<script type='text/javascript'>

var gd=new Date(), gToday=[gd.getFullYear(),gd.getMonth()+1,gd.getDate()];
var ua=navigator.userAgent.toLowerCase();
var MAC=ua.indexOf('mac')!=-1;
var NN4=IE4=OP6=KO3=false, OP=!!self.opera;
var IE=ua.indexOf("msie")!=-1&&!OP&&ua.indexOf("webtv")==-1;
var IE5=IE&&!![].push;
var gTheme=self.name.split(":");
var gCurMonth=eval(gTheme[0]);
var gContainer=parent;
var fRepaint,fHoliday,fOnChange,fAfterSelected,fOnDrag,gEvent,gcOtherDayBG;
var _agenda=[], popkey=["Lite"], flatkey=["Lite"];
var gbInvertBold=gbInvertBorder=gbFlatBorder=gbShareAgenda=false;
var MILLIDAY=86400000, giInitDelay=200, giResizeDelay=50;
if (![].push) Array.prototype.push=function () {
	for (var i=0; i<arguments.length; i++)
		this[this.length]=arguments[i];
	return this.length;
}


function fCalibrate(y,m) { 
	if (m<1) { y--; m+=12; }
	else if (m>12) { y++; m-=12; }
	return [y,m];
}

function fGetById(doc, id) {
	return doc.getElementById(id);
}

function fAddEvent(y,m,d,message,action,bgcolor,fgcolor,bgimg,boxit,html) {
	_agenda[y+"-"+m+"-"+d]=[message,action,bgcolor,fgcolor,bgimg,boxit,html];
}

function fGetEvent(y,m,d) {
	var ag=_agenda[y+"-"+m+"-"+d];
	if (ag) return ag.slice(0);
	return null;
}

function fRemoveEvent(y,m,d) {
	_agenda[y+"-"+m+"-"+d]=null;
}

var gfSelf=fGetById(parent.document,self.name);
document.write("<scr"+"ipt type='text/javascript' src='/"+gTheme[1]+".js'></scr"+"ipt>");
document.write("<scr"+"ipt type='text/javascript' src='/"+(gTheme[4]?gTheme[4]:"plugins.js")+"'></scr"+"ipt>");
</script>
<script type='text/javascript'>
function fAgReady(ctxName) {
	var ctx=eval("gContainer."+ctxName);
	if (ctx) {
		clearInterval(_intStub);
		fHoliday=ctx.fHoliday;
		if (fRepaint) fRepaint();
	}
}
var _isAS=gTheme[2]&&gTheme[2].substring(0,6)=="share[";
if (gbShareAgenda==true) {
	if (!gContainer._cxp_agendas) gContainer._cxp_agendas=_agenda;
	else _agenda=gContainer._cxp_agendas;
	if (_isAS) _intStub=setInterval("fAgReady('"+gTheme[2].split('[')[1].split(']')[0]+"')",350);
}
with (document) {
	if (gTheme[2]&&!_isAS) write("<scr"+"ipt type='text/javascript' src='/"+gTheme[2]+"'></scr"+"ipt>");
	write("<lin"+"k rel='stylesheet' type='text/css' href='/"+gTheme[1]+".css'>");
}
</script>
</head>
<body leftmargin=0 topmargin=0 marginwidth=0 marginheight=0 hspace=0 vspace=0 onselectstart="return false" ondraggesture="return false" ondragstart="return false" oncontextmenu="return false" onmouseout="_mouseout=true" onmouseover="_mouseout=false" onmouseup="_lastDrag=null;self.status='';return true;">
<script type='text/javascript'>
gdSelect=gdSelect.slice(0); gBegin=gBegin.slice(0); gEnd=gEnd.slice(0);
gCurMonth=fCalibrate(gCurMonth[0],gCurMonth[1]);
var gdBegin,gdEnd,gRange,gcbMon,gcbYear,gdCtrl,gbMouse=false;
var gcTemp=gcCellBG;
var giSat=gbEuroCal?5:6;
var giSun=gbEuroCal?6:0;
if (gbEuroCal) gWeekDay=gWeekDay.slice(1).concat(gWeekDay[0]);
var _cal=[];
for (var i=0;i<6;i++) { _cal[i]=[]; for (var j=0;j<7;j++) _cal[i][j]=[]; }
var gDays=[31,31,28,31,30,31,30,31,31,30,31,30,31];

var _lastDrag=null,_mouseout=false;
if (fOnDrag&&!IE) {
	var _olde=gContainer.onmouseover?gContainer.onmouseover:function(){};
	gContainer.onmouseover=function(e){if(e.target.name!=self.name)_lastDrag=null;_olde(e)};
}
if (fOnDrag&&IE&&!MAC) setInterval("if(_mouseout)_lastDrag=null",100);

function fDragIt(y,m,d,aStat) {
	if (!fOnDrag||!(_lastDrag&&aStat>0||aStat==0)) return false;
	var dt=[y,m,d];
	if (aStat==1&&_lastDrag+''==dt+'') return false;
	_lastDrag=OP||IE&&MAC?null:dt;
	return fOnDrag(dt[0],dt[1],dt[2],aStat);
}

function fRepaint() {
	fSetCal(gCurMonth[0],gCurMonth[1],0,false);
}

function fPopCalendar(dateCtrl,range,posLayerId,posCtrl) {
	var dc=dateCtrl;
	var pc=posCtrl?posCtrl:dc;
	if (gdCtrl!=dc)
		gdCtrl=dc;
	else if (gfSelf.offsetLeft>0) {
		fHideCal();
		return;
	}
	var s=fParseDate(gdCtrl.value);
	if (s==null) {
		if (gdSelect[2]==0||gdCtrl.value=="") {
			s=eval(gTheme[0]);
			gdCtrl.value="";
		} else {
			s=gdSelect;
			gdCtrl.value=fFormatDate(s[0],s[1],s[2]);
		}
	} else {
		gdCtrl.value=fFormatDate(s[0],s[1],s[2]);
		gdSelect=s;
	}
	fInitRange(range);
	if (gRange[2]&&fIsOutRange(s[0],s[1])) s=gRange[2];
	if (!fSetCal(s[0],s[1],0,true)) {
		gdCtrl.value="";
		fHideCal();
		return;
	}
	var p,oh;
	if (gbFixedPos) {
		p=gPosOffset;
		oh=-1;
	} else {
		p=fGetXY(pc,gPosOffset);
		if (posLayerId) {
			var lyr=fGetById(parent.document,posLayerId);
			if (lyr&&lyr.tagName.toUpperCase()=="IFRAME") {
				var pl=fGetXY(lyr);
				var p2=fGetWinSize(parent.frames[posLayerId]).slice(2);
				p[0]+=pl[0]-p2[0];
				p[1]+=pl[1]-p2[1];
			}
		}
		var oh=pc.offsetHeight;
		var ptb=fGetById(document,"outerTable");
		var h=ptb.offsetHeight;
		var w=ptb.offsetWidth;
		h=(h?h:gfSelf.height)+oh;
		if (gbAutoPos) {
			var ws=fGetWinSize(parent);
			var tmp=ws[0]+ws[2]-(w?w:gfSelf.width);
			p[0]=p[0]<ws[2]?ws[2]+2:p[0]>tmp?tmp:p[0];
			tmp=ws[1]+ws[3]-h;
			if (p[1]>tmp&&(!gbPopDown||p[1]-ws[3]+oh>=h)) 
				p[1]-=oh>0?h+2:h+25;
		} else if (!gbPopDown) p[1]-=oh>0?h+2:h+25;
	}
	with (gfSelf.style) {
		left=p[0]+"px";
		top =p[1]+oh+1+"px";
	}
}

function fGetWinSize(w) {
	if (w.innerWidth)
		return [w.innerWidth-16,w.innerHeight,w.pageXOffset,w.pageYOffset];
	else if (w.document.compatMode=='CSS1Compat')
		with (w.document.documentElement) return [clientWidth,clientHeight,scrollLeft,scrollTop];
	else
		with (w.document.body) return [clientWidth,clientHeight,scrollLeft,scrollTop];
}

function fHideCal() {
	gfSelf.style.left="-500px";
	_lastDrag=null;
}

function fGetXY(a,offset) {
	var p=offset?offset.slice(0):[0,0],tn;
	while(a) {
		tn=a.tagName.toUpperCase();
		p[0]+=a.offsetLeft-(!KO3&&tn=="DIV"&&a.scrollLeft?a.scrollLeft:0);
		p[1]+=a.offsetTop-(!KO3&&tn=="DIV"&&a.scrollTop?a.scrollTop:0);
		if (tn=="BODY") break;
		a=a.offsetParent;
	}
	return p;
}

function fInitRange(r) {
	gRange=r?r:[];
	var rb=gRange[0]?r[0]:gBegin;
	gdBegin=new Date(rb[0],rb[1]-1,rb[2]);
	gRange[0]=rb;
	var re=gRange[1]?r[1]:gEnd;
	gdEnd=new Date(re[0],re[1]-1,re[2]);
	gRange[1]=re;
}

function fParseDate(ds) {
	var i,r=null;
	if (ds) {
		var pd=ds.split(gsSplit);
		if (pd.length==3) {
			var m=pd[giDatePos==1?0:1];
			for (i=0; (i<12)&&(gMonths[i].substring(0,3).toLowerCase()!=m.substring(0,3).toLowerCase())&&(i+1!=m); i++);
			if (i<12) {
				var y=parseInt(pd[giDatePos==2?0:2].substring(0,4),10);
				var pf=Math.floor(gEnd[0]/100)*100;
				r=[y<100?y>gEnd[0]%100?pf-100+y:pf+y:y,i+1,parseInt(pd[giDatePos],10)];
			} else return null;
		} else return null;
		var td=new Date(r[0],r[1]-1,r[2]);
		if (isNaN(td)||td.getMonth()!=r[1]-1) return null;
	}
	return r;
}

function fFormatDate(y,m,d){
	var M=giMonthMode==0?gbPadZero&&m<10?"0"+m:m:giMonthMode==1?gMonths[m-1]:gMonths[m-1].substring(0,giMonthMode);
	var D=gbPadZero&&d<10?"0"+d:d;
	var sy=y%100;
	var Y=gbShortYear?sy<10?"0"+sy:sy:y;
	switch (giDatePos) {
		case 0: return D+gsSplit+M+gsSplit+Y;
		case 1: return M+gsSplit+D+gsSplit+Y;
		case 2: return Y+gsSplit+M+gsSplit+D;
	}
}

function fGetAgenda(y,m,d,taint) {
	var s=fCalibrate(y,m),cm=gCurMonth,oor=false;
	var def=["",gsAction,gcCellBG,null,guCellBGImg,false,gsCellHTML];
	if (taint) if ((giShowOther&4)&&(s[0]<cm[0]||s[0]==cm[0]&&s[1]<cm[1])||(giShowOther&8)&&(s[0]>cm[0]||s[0]==cm[0]&&s[1]>cm[1]))
		return null;
	var ag=fHoliday?fHoliday(s[0],s[1],d):fGetEvent(y,m,d);
	if (ag==null) ag=def;
	else {
		for (var i=0;i<7;i++) {
			if (gAgendaMask[i]!=-1) ag[i]=gAgendaMask[i];
			if (ag[i]==null&&i!=1) ag[i]=def[i];
		}
		if (taint&&s[1]!=cm[1]&&!(giShowOther&1)) {
			def[0]=ag[0]; def[1]=ag[1]; ag=null; ag=def;
		}
	}
	if (taint&&s[1]!=cm[1]) {
		if (gcOtherDayBG&&ag[2]==gcCellBG) ag[2]=gcOtherDayBG;
		ag[3]=gcOtherDay;
	}
	for (var i=3; i<gRange.length; i++)
		if (gRange[i][2]==d&&gRange[i][1]==s[1]&&gRange[i][0]==s[0])
			{ oor=true; break; }
	if (oor||!fValidRange(s[0],s[1],d)) {
		ag[0]=gsOutOfRange; ag[1]=null;
		if (guOutOfRange) ag[4]=guOutOfRange;
	}
	return ag;
}

function fGetDOW(y,m,d) {
	var dow=new Date(y,m-1,d).getDay();
	if (gbEuroCal)
		if (--dow<0) dow=6;
	return dow;
}

function fValidRange(y,m,d) {
	var dt=new Date(y,m-1,d);
	return (dt>=gdBegin)&&(dt<=gdEnd);
}

function fGetDays(y) {
	gDays[2]=y%4==0&&y%100!=0||y%400==0?29:28;
	return gDays;
}

function fBuildCal(y,m) {
	var days=fGetDays(y),iDay1=fGetDOW(y,m,1);
	var iLast=days[m-1]-iDay1+1,iDate=1,iNext=1;
	for (var d=0;d<7;d++) {
		_cal[0][d][0]=d<iDay1?m-1:m;
		_cal[0][d][1]=d<iDay1?iLast+d:iDate++;
	}
	for (var w=1;w<6;w++)
		for (var d=0;d<7;d++) {
			_cal[w][d][0]=iDate<=days[m]?m:m+1;
			_cal[w][d][1]=iDate<=days[m]?iDate++:iNext++;
		}
}

function fIsOutRange(y,m) {
	return (y>gRange[1][0]||y<gRange[0][0]||y==gRange[0][0]&&m<gRange[0][1]||y==gRange[1][0]&&m>gRange[1][1]);
}

function fCheckRange(y,m) {
	if (fIsOutRange(y,m)) {
		if (gsOutOfRange!="") alert(gsOutOfRange);
		return false;
	}
	return true;
}

function fSetCal(y,m,d,bTriggerOnChg) {
	var t=fCalibrate(parseInt(y,10),parseInt(m,10));
	y=t[0];
	m=t[1];
	if (!fCheckRange(y,m)||bTriggerOnChg&&fOnChange&&fOnChange(y,m,d)) {
		if (gcbMon) gcbMon.options[gCurMonth[1]-1].selected=true;
		if (gcbYear) gcbYear.options[gCurMonth[0]-gBegin[0]].selected=true;
		return false;
	}
	if (d>0) fUpdSelect(y,m,d);
	var iDiv=fGetById(document,"innerDiv");
	fGetById(document,"innerDiv").innerHTML=fDrawCal(y,m);
	if (gcbMon) gcbMon.options[m-1].selected=true;
	if (gcbYear) gcbYear.options[y-gBegin[0]].selected=true;
	if (!gbHideTop&&giDCStyle>0) fGetById(document,"calTitle").innerHTML=eval(gsCalTitle)+"\n";
	setTimeout("fResize()",giInitDelay>0?giInitDelay+giResizeDelay:giResizeDelay);
	return true;
}

function fResize() {
	giInitDelay=0;
	var ptb=fGetById(document,"outerTable");
	if (!ptb) return;
	var ow=ptb.offsetWidth;
	var oh=ptb.offsetHeight;
	if (ow) gfSelf.style.width=ow+"px";
	if (oh) gfSelf.style.height=oh+"px";
}

function fUpdSelect(y,m,d) {
	gdSelect[0]=y; gdSelect[1]=m; gdSelect[2]=d;
}

function fSetDate(y,m,d,taint) {
	var ag=fGetAgenda(y,m,d,taint);
	if (ag==null||ag[1]==null) return false;
	if (!fSetCal(y,m,d,true)) return false;
	gdCtrl.value=fFormatDate(y,m,d);
	if (gbAutoClose) fHideCal();
	gbMouse=true;
	eval(ag[1]);
	if (fAfterSelected) fAfterSelected(y,m,d);
	return true;
}

function fMouseOver(t) {
	if (!gbFocus) return;
	gcTemp=t.style.backgroundColor;
	t.style.backgroundColor=gcToggle;
	self.status=t.title;
	gbMouse=false;
}

function fMouseOut(t) {
	if (!gbFocus) return;
	t.style.backgroundColor=gcTemp?gcTemp:"transparent";
	gbMouse=true;
}

var _sDIV=" style='position:relative;height:",
_sWH="<td class='WeekHead'><div "+_sDIV+giHeadHeight+"px;width:"+giWeekWidth+"px;top:"+giHeadTop+"px;'>",
_sCH="<td class='CalHead'><div "+_sDIV+giHeadHeight+"px;width:"+giCellWidth+"px;top:"+giHeadTop+"px;'>",
_sWC="<td class='WeekCol'><div "+_sDIV+giCellHeight+"px;width:"+giWeekWidth+"px;top:"+giWeekTop+"px;'>",
_sCC="><div class='CalCell' "+_sDIV+giCellHeight+"px;width:"+giCellWidth+"px;",
_sDIVTD="</div></td>",
_reQ=/\"/g;

function fDrawCal(y,m) {
	var td,ti,htm,bo,ag,i,c,c1,dayNo,dc,cbg,isT,isS,weekNo,cd,ex,bfb,sCellDate;
	var ms=giMarkSelected,ht=giMarkToday;
	var a=["<TABLE width='100%' ",gsInnerTable,"><tr>"];
	gCurMonth[0]=y; gCurMonth[1]=m;
	fBuildCal(y,m);
	for (var wd=0,i=0; i<7; i++)
		a.push(_sCH,gWeekDay[wd++],_sDIVTD);
	a.push("</tr>");
	for (var week=0; week<6; week++) {
		ex=week>3&&_cal[week][0][1]<20;
		if (gbShrink2fit&&ex) continue;
		a.push("<tr>");
		for (var day=-1,i=0; i<7; i++) {
			day++; dayNo=_cal[week][day][1];
			cd=fCalibrate(y,_cal[week][day][0]);
			isS=gdSelect[2]==dayNo&&gdSelect[1]==cd[1]&&gdSelect[0]==cd[0];
			isT=gToday[2]==dayNo&&gToday[1]==cd[1]&&gToday[0]==cd[0];
			ag=fGetAgenda(cd[0],cd[1],dayNo,true);
			if (ag==null) {
				dc=giShowOther&16&&(week<2&&(giShowOther&4)||week>3&&(giShowOther&8))?gcOtherDay:gcOtherDayBG;
				cbg=null; bo=false; td=ti=htm=""; bfb=gbFlatBorder; c=c1=gcOtherDayBG;
			} else {
				cbg=ag[4]; dc=ag[3]==null?day==giSun?gcSun:day==giSat?gcSat:gcWorkday:ag[3];
				if (cd[1]==m||(giShowOther&2)) {
					c=isS&&(ms&2)?gcBGSelected:isT&&(ht&2)?gcBGToday:ag[2];
					c1=isS&&(ms&1)?gcBGSelected:ag[2]!=gcCellBG&&ag[5]!=true?ag[2]:isT&&(ht&1)?gcBGToday:gcCellBG;
					bo=isS&&(ms&4)||isT&&(ht&4);
					dc=isS&&(ms&8)?gcFGSelected:isT&&(ht&8)?gcFGToday:dc;
					cbg=isS&&(ms&16)?guSelectedBGImg:isT&&(ht&16)?guTodayBGImg:cbg;
				} else {
					bo=false; c=ag[2]; c1=ag[5]==true?gcCellBG:c;
				}
				bo=gbBoldAgenda&&ag[0]&&ag[0]!=gsOutOfRange||bo;
				bfb=gbFlatBorder&&c1!=gcCellBG;
				htm=ag[6]?"<BR>"+ag[6]:"";
				td=ag[1]==null?";text-decoration:line-through":"";
				ti=ag[0].replace(_reQ,"&quot;");
				if (gcSunBG&&day==giSun) { c1=c1==gcCellBG?gcSunBG:c1; c=c==gcCellBG?gcSunBG:c; }
				if (gcSatBG&&day==giSat) { c1=c1==gcCellBG?gcSatBG:c1; c=c==gcCellBG?gcSatBG:c; }
			}
			if (gbInvertBold) bo=!bo;
			if (gbInvertBorder) bfb=!bfb;
			sCellDate=cd[0]+","+cd[1]+","+dayNo;
			a.push("<td valign=top");if(c)a.push(" bgcolor='"+c+"'");a.push(_sCC);if(bfb)a.push("border-style:solid;border-color:"+c1);if(c1)a.push(";background-color:"+c1);if(cbg)a.push(";background-image:url("+cbg+")");
			a.push("' title=\"",ti,"\" onmouseover='gEvent=event;fMouseOver(this);fDragIt(",sCellDate,",1);return true;' onmouseout='gEvent=event;fMouseOut(this);' onmousedown='gEvent=event;if(!fDragIt(",sCellDate,",0))fSetDate(",sCellDate,",true);return false;' onmouseup='gEvent=event;fDragIt(",sCellDate,",2)'><A href='javascript:void(0)' title=\"",ti,"\" class='CellAnchor' style='color:",dc);
			if(bo)a.push(";font-weight:bold");a.push(td,"' onfocus='if(this.blur)this.blur();'>",eval(gsDays),"</A>",htm,_sDIVTD);
			ag=null;
		}
		a.push("</tr>");
	}
	a.push("</TABLE>\n");
	return a.join('');
}

function fPrevMonth() {
	return fSetCal(gCurMonth[0],gCurMonth[1]-1,0,true);
}

function fNextMonth() {
	return fSetCal(gCurMonth[0],gCurMonth[1]+1,0,true);
}

with (document) {
	body.bgColor=gcCalBG;
	var a=["<TABLE id='outerTable' ",gsOuterTable,"><FORM name='_cxp_topForm'>"];
	if (!gbHideTop)
	if (giDCStyle==2)
		a.push("<TR><TD class='CalTop' nowrap><SPAN id='calTitle' class='CalTitle'>",eval(gsCalTitle),"</SPAN></TD></TR>");
	else if (giDCStyle==1){
		a.push("<TR><TD class='CalTop' nowrap><table border=0 cellspacing=0 cellpadding=0 width='100%'><tr><TD align='left' nowrap><A href='javascript:void(0)' class='MonthNav' onclick='gEvent=event;fPrevMonth();if(this.blur)this.blur();' onmouseover='return true;'>",gsNavPrev,"</A></TD><TD class='CalTitle' nowrap><SPAN id='calTitle'>");
		a.push(eval(gsCalTitle));
		a.push("</SPAN></TD><TD align='right' nowrap><A href='javascript:void(0)' class='MonthNav' onclick='gEvent=event;fNextMonth();if(this.blur)this.blur();' onmouseover='return true;'>",gsNavNext,"</A></TD></tr></table></TD></TR>");
	} else {
		a.push("<TR><TD class='CalTop' nowrap>",gsNavPrev," ");
		var mstr=["<SELECT id='MonSelect' class='CalTitle' onchange='gEvent=event;fSetCal(gcbYear.value, gcbMon.value,0,true)'>"];
		for (var i=0; i<12; i++) mstr.push("<OPTION value='",i+1,"'>",gMonths[i],"</OPTION>");
		mstr.push("</SELECT>"); mstr=mstr.join('');
		var ystr=["<SELECT id='YearSelect' class='CalTitle' onchange='gEvent=event;fSetCal(gcbYear.value, gcbMon.value,0,true)'>"];
		for(var i=gBegin[0];i<=gEnd[0];i++)
			ystr.push("<OPTION value='",i,"'>",i,"</OPTION>");
		ystr.push("</SELECT>"); ystr=ystr.join('');
		if (gbDCSeq) a.push(mstr,ystr);
		else a.push(ystr,mstr);
		a.push(" ",gsNavNext,"</TD></TR>");
	}
	a.push("</FORM><TR><TD class='CalMiddle'><DIV id='innerDiv' style='background:",gcCalFrame,guCalBG?" url("+guCalBG+") ":"",";'></DIV></TD></TR>");
	if (!gbHideBottom) a.push("<FORM name='_cxp_bottomForm'><TR><TD class='CalBottom' nowrap>",gsBottom,"</TD></TR></FORM>");
	a.push("</TABLE>");
	for (var i=0;i<giFreeDiv;i++)
		a.push("<DIV class='FreeDiv' id='freeDiv",i,"' style='position:absolute;visibility:hidden;z-index:500'></DIV>");
	write(a.join(''));
	close();
}
</script>
<script type='text/javascript'>
if (giDCStyle==0) {
	gcbMon=fGetById(document,"MonSelect");
	gcbYear=fGetById(document,"YearSelect");
}
if (!gTheme[3]) gTheme[3]="gfPop";
eval("parent."+gTheme[3]+"=parent.frames[self.name]");
</script>
</body>
</html>
