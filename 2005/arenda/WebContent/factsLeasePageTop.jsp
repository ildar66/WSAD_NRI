<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.constants.*,com.hps.july.arenda.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%--SCRIPT language=javascript src="/common/dialog.js" type="text/javascript"></SCRIPT--%>  
<%--SCRIPT language=javascript src="/common/exitFromNRI.js" type="text/javascript"></SCRIPT--%>  
<SCRIPT language=javascript src="/common/validate.js" type="text/javascript"></SCRIPT> 
<style>
<!--
.editsearch {
	background-color: white;
}
.editdisabled {
	background-color: DCDCDC;
}
-->
</style>
<html:html>
<HEAD>
<TITLE>factsLeasePageTop.jsp</TITLE>
</HEAD>

	<%
		Profile profile = (Profile)request.getSession().getAttribute(Profile.PROFILE);
		String curRegName = "Нет текущего региона";
		if(profile != null){
			com.hps.july.valueobject.RegionsAccess_TO curReg = profile.getProfileAccess().getCurrRegion();
			if(curReg != null){
				curRegName = curReg.getRegionName();			
			}
		}
	%>
 
<BODY>
<html:errors />
<html:form action="/FactsLeasePage" styleId="thisForm" target="_top">
	<%--html:hidden property="school" /--%>
	<html:hidden property="comand" value=""/>
<script>
function switchEconomist() {
	if (document.all.isEconomist[0].checked) {
		thisForm.economistName.disabled = true;
		thisForm.economistName.className = 'editdisabled';
		document.all['lookupimg_economistl'].src='/images/lookup_disabled.gif';
	} else {
		thisForm.economistName.disabled = false;
		thisForm.economistName.className = 'editsearch';
		document.all['lookupimg_economistl'].src='/images/lookup.gif';
	}
}

function switchResource(){
	if (document.all.isResource[0].checked) {
		thisForm.resource.className = 'editdisabled';
		thisForm.resource.disabled = true;
	} else {
		thisForm.resource.className = 'editsearch';
		thisForm.resource.disabled = false;
	}
}

function switchExecutor() {
	if (document.all.isExecutor[0].checked) {
		thisForm.executorName.disabled = true;
		thisForm.executorName.className = 'editdisabled'; 
		document.all['lookupimg_execl'].src='/images/lookup_disabled.gif';
		thisForm.executor_vendocSiteId.disabled = true;
		thisForm.executor_vendocSiteId.className = 'editdisabled';
	} else {
		thisForm.executorName.disabled = false;
		thisForm.executorName.className = 'editsearch'; 
		document.all['lookupimg_execl'].src='/images/lookup.gif';
		thisForm.executor_vendocSiteId.disabled = false;
		thisForm.executor_vendocSiteId.className = 'editsearch';
	}
}

function switchPosition() {
	if (document.all.isPosition[0].checked) {
		thisForm.positionName.disabled = true;
		thisForm.positionName.className = 'editdisabled';
		document.all['lookupimg_posl'].src='/images/lookup_disabled.gif';
	} else {
		thisForm.positionName.disabled = false;
		thisForm.positionName.className = 'editsearch';
		document.all['lookupimg_posl'].src='/images/lookup.gif';
	}
}

function switchDopFilter() {
	if(thisForm.isDopFilter[0].checked) {
		for(var i = 0; i < dopFilterID.length; i++){
			dopFilterID[i].style.setAttribute("display", "block");
		}
		//thisForm.filter.value = 0;
		document.all.isEconomist[0].checked = true;		
		
		//document.all.isCustomer[0].checked = true;
		document.all.isExecutor[0].checked = true;		
		document.all.isResource[0].checked = true;
		document.all.isPosition[0].checked = false;		
	} else {
		for(var i = 0; i < dopFilterID.length; i++){
			dopFilterID[i].style.setAttribute("display", "none");
		}
		//thisForm.filter.value = 1;
		document.all.isEconomist[0].checked = false;
				
		//document.all.isCustomer[0].checked = true;
		document.all.isExecutor[0].checked = true;
		document.all.isResource[0].checked = true;		
		document.all.isPosition[0].checked = true;		
	}
	//switchGroup();
	document.thisForm.comand.value = "switchDopFilter";
	document.body.style.cursor="wait";
	document.thisForm.submit();
}

function switchGroup(){
	//switchCustomer();
	switchExecutor();
	switchEconomist();
	switchPosition();
	switchResource();
	//switchFilter();
}

function hideDopFilter() {
	if(thisForm.isDopFilter[0].checked) {
		for(var i = 0; i < dopFilterID.length; i++){
			dopFilterID[i].style.setAttribute("display", "block");
		}
	} else {
		for(var i = 0; i < dopFilterID.length; i++){
			dopFilterID[i].style.setAttribute("display", "none");
		}
	}
}

function ShowReport()
{ 
	document.thisForm.comand.value = "factsLeaseExcel";
	document.thisForm.submit();
}
function MoveTo(school)
{ 
	document.thisForm.comand.value = "factsLeasePage";
	document.thisForm.school.value = school;
    document.body.style.cursor="wait";	
	document.thisForm.submit();
}
function switchFilter() {
	if(thisForm.filter.value == 0) {
		thisForm.searchstring.disabled = true;
	} else {
		thisForm.searchstring.disabled = false;
	}
}
function popCalInMainFrame(dateCtrl) {
	var w=self.top.scroll_right.gfPop;
	w.gbFixedPos=true;	// enable fixed positioning
	w.gPosOffset=[70,0];	// set position
	w.fPopCalendar(dateCtrl);	// pop calendar
}
function popCalInMainFrame(dateFrom, dateTo, isStart) {
	//alert('scrollTop=' +top.frames["scroll_right"].document.body.scrollTop);//temp
	var SR_scrollTop = top.frames["scroll_right"].document.body.scrollTop;
	var w=self.top.scroll_right.gfPop;
	w.gbFixedPos=true;	// enable fixed positioning
	if(isStart == true) {
		w.gPosOffset=[190,SR_scrollTop];	// set position
		w.fStartPop(dateFrom, dateTo);
	}
	else {
		w.gPosOffset=[350,SR_scrollTop];	// set position
		w.fEndPop(dateFrom, dateTo);
	}
}

function Check()
{
	var theForm = document.thisForm;
	with(theForm){
		if(!field_check(theForm.fromDateFrm, 'период с', 7, true)) return false;
		if(!field_check(theForm.toDateFrm, 'период по', 7, true)) return false;
	}
	theForm.comand.value = "factsLeasePage";
	document.body.style.cursor="wait";		
	return true;
}
/** код для вызова отстойных :) july:lookupbutton (не пишите такие лукапы)*/
function lookup_params() {
	var s = new String("s");
	var a = s.lookup("s");
}
</script>

		<TABLE width="100%" class=includer border="0" cellpadding="0" cellspacing="0">
			<TR>
				<TD bgcolor="D6EBFF" height="30">
					<img src="/images/logo_beeline_dogovor.gif" border="0" alt="">
					<B style="color: blue; font-size: 80%"><%=curRegName%></B>					
				</TD>
			<TR>
		</TABLE>

		<TABLE width="100%" style="font-size:11pt;" bgcolor="D6EBFF" border="0" cellpadding="0" cellspacing="0">
			<TBODY>
				<TR>			
					<TH align="left" bgcolor="AAD1F6" colspan="6">
						<A href="/arenda/main.do" target="_top"><img src="/images/cancel.gif" border="0" alt="Вернуться в меню"></A>&nbsp;
				</TR>
			
				<TR>
					<td class="text">&nbsp;</td>
					<TH class="text" align="right">Ответственный:</TH>
					<td class="text" nowrap>
						<html:checkbox property="isEconomist" onclick="switchEconomist()"/>все
						<html:hidden property="isEconomist" value="false"/>
						<html:text style="font-size: 8pt;" size="50" property="economistName" styleId="economistName" readonly="true"/>
						<july:lookupbutton formname="thisForm" action="/ShowWorkerLookupList.do" styleId="economistl" fieldNames="economistCode;economistName" insertable="true" updatable="true" onclick="if (document.all.isEconomist[0].checked) { return false; }"
						onselect = "document.thisForm.comand.value = 'factsLeasePage';document.thisForm.submit();"/>
						<html:hidden property="economistCode"/>
					   	<%--july:searchbutton/--%>
					   	<INPUT TYPE='image' src='/images/refresh.gif' onclick="return Check();" border='0' alt='Искать'>
						&nbsp;&nbsp;
						с : <html:text property="dataPeriod.fromDateFrm" size="11" styleId="fromDateFrm"/>
						<a href="javascript:void(0)" onclick="popCalInMainFrame(document.thisForm.fromDateFrm, document.thisForm.toDateFrm, true);return false;" HIDEFOCUS>
							<img name="popcal" align="absbottom" src="/images/calbtn.gif" width="34" height="22" border="0" alt=""></a>
						по : <html:text property="dataPeriod.toDateFrm" size="11" styleId="toDateFrm"/>
						<a href="javascript:void(0)" onclick="popCalInMainFrame(document.thisForm.fromDateFrm, document.thisForm.toDateFrm, false);return false;" HIDEFOCUS>
							<img name="popcal" align="absbottom" src="/images/calbtn.gif" width="34" height="22" border="0" alt=""></a>
						&nbsp;&nbsp;	
						Доп.условия: <html:checkbox property="isDopFilter" onclick="switchDopFilter()"/>
						<html:hidden property="isDopFilter" value="false"/>
						&nbsp;&nbsp;
						<INPUT TYPE='IMAGE' SRC='/images/msexcel.gif' onclick="ShowReport();return false;" ALT="Отчет ХLS">
					</td>
				</TR>

				<TR id="dopFilterID">
					<td class="text">&nbsp;</td>
					<TH class="text" align="right">Услуга:</TH>
					<td class="text">
						<html:checkbox property="isResource" onclick="switchResource()"/>все
						<html:hidden property="isResource" value="false"/>
						<html:select styleId="resource"  style="width: 300; font-size: 8pt;" property="resourceCode">
							<%--html:options collection="resources" property="resource" labelProperty="name"/--%>
							<logic:iterate name="FactsLeasePageForm" property="resources" id="it">
								<logic:present name="it">
									<%String value = ((com.hps.july.arenda.valueobject.ResourceVO)it).getResource().toString();%>
									<%String name = ((com.hps.july.arenda.valueobject.ResourceVO)it).getName();%>
									<html:option value='<%=value%>'><%=name%></html:option>
								</logic:present>
							</logic:iterate>
					   	</html:select>
					</td>
				</TR>
				
				<TR id="dopFilterID">
					<td class="text">&nbsp;</td>
					<TH class="text" align="right">Арендодатель:</TH>
					<td class="text" nowrap>
						<html:checkbox property="isExecutor" onclick="switchExecutor()"/>все
						<html:hidden property="isExecutor" value="false"/>
						<html:text style="font-size: 8pt;" size="50" property="executorName" styleId="executorName" readonly="true"/>
						<%--july:lookupbutton action="/ShowOrganizationLookupList.do" styleId="execl" fieldNames="executorCode;executorname" insertable="true" updatable="true" onclick="if (document.all.isExecutor[0].checked) { return false; }"
						onselect = "document.forms(0).submit();"/--%>
						<html:link page="/../dict/VendorLookupList.do?formname=thisForm&fieldnames=executorCode||executorName&onMySelect=document.forms(0).executor_vendocSiteId.value=-1;document.thisForm.comand.value = 'factsLeasePage';document.forms(0).submit();" onclick="if (document.all.isExecutor[0].checked) { return false; } else { window.open(this.href, 'VendorLookupList', 'top=40, left=100, width=700, height=650, scrollbars=yes, resizable=yes'); return false;}" title="справочник поставщиков">		
							<img src='/images/lookup.gif' border='0' alt='Справочник поставщиков' name="lookupimg_execl"></html:link>		
						<html:hidden property="executorCode"/>
						<BR><I>отдел:</I>
						<html:select styleId="executor_vendocSiteId" style="width: 300; font-size: 8pt;" property="executor_vendocSiteId">
							<html:option value="-1">все отделения</html:option>
							<%--html:options name="FactsLeasePageForm.executor_vendorSitesList" property="vo.idVendorSite" labelProperty="info"/--%>
							<logic:iterate name="FactsLeasePageForm" property="executor_vendorSitesList" id="it">
								<logic:present name="it">
									<%String value = ((com.hps.july.valueobject.VendorSite_TO)it).getVo().getIdVendorSite().toString();%>
									<%String name = ((com.hps.july.valueobject.VendorSite_TO)it).getInfo();%>
									<html:option value='<%=value%>'><%=name%></html:option>
								</logic:present>
							</logic:iterate>
						</html:select>
					</td>
				</TR>
				
				<TR id="dopFilterID">
					<td class="text">&nbsp;</td>
					<TH class="text" align="right">Позиция:</TH>
					<td class="text" nowrap>
						<html:checkbox property="isPosition" onclick="switchPosition()"/>все
						<html:hidden property="isPosition" value="false"/>
						<html:text style="font-size: 8pt;" size="50" property="positionName" styleId="positionName" readonly="true"/>
						<july:lookupbutton formname="thisForm" action="/../basestation/ShowPositionLookupList.do?planstate=2" styleId="posl" fieldNames="positioncode;;positionname" insertable="true" updatable="true" onclick="if (document.all.isPosition[0].checked) { return false; }" onselect = "document.thisForm.comand.value = 'factsLeasePage';document.forms(0).submit();"/>
						<html:hidden property="positionCode"/>
					</td>
				</TR>								
							
				<%--TR>
					<TH align="left" bgcolor="AAD1F6" colspan="6">
						<A href="/arenda/main.do" target="_top"><img src="/images/cancel.gif" border="0" alt="Вернуться в меню"></A>&nbsp;
						<html:select name="FactsLeasePageForm" property="currRegionID">
							<option value='0'>&nbsp;</option>
							<logic:iterate name="FactsLeasePageForm" property="regionAccessList" id="it">
								<logic:present name="it">
									<%String value = ((com.hps.july.valueobject.RegionsAccess_TO)it).getVo().getRegionid().toString();%>
									<%String name = ((com.hps.july.valueobject.RegionsAccess_TO)it).getRegionName();%>
									<html:option value='<%=value%>'><%=name%></html:option>
								</logic:present>
							</logic:iterate>
						</html:select>
					</TH>
				</TR>
				<TR>
					<TD>
						Поиск с дополнит. условиями: <html:checkbox property="isDopFilter" onclick="switchDopFilter()"/>
						<html:hidden property="isDopFilter" value="false"/>
					</TD>
					<TD>
						<html:select  property="filter" onchange="switchFilter()" >
							<html:option value="0">Все</html:option>
							<html:option value="1">По названию</html:option>
							<html:option value="2">По № GSM/DCS</html:option>
							<html:option value="3">По № DAMPS</html:option>
						</html:select>
					</TD>
					<TD>Значение поиска: </TD>
					<TD>
						<html:text property="searchstring" size="25"/>
						<INPUT TYPE='IMAGE' SRC='/images/refresh.gif'  onclick="MoveTo('');return false;" border='0' alt='Искать'>&nbsp;
						&nbsp;<INPUT TYPE='IMAGE' SRC='/images/msexcel.gif' onclick="ShowReport();return false;" ALT="Отчет ХLS">
					</TD>
				</TR>
				<TR id="dopFilterID">
					<TD>
						<html:radio property="isDateModified" value="true"/>изменение данных в колонке<BR>
						<html:radio property="isDateModified" value="false"/>нет данных о разрешениях
					</TD>
					<TD>
					      <html:select property="types" size="3" multiple="true">
					        <html:option value="0">Все</html:option>
							<html:option value="13">Комментарий</html:option>
							<logic:equal name="FactsLeasePageForm"	property="showColumn.isFas"	value="true" scope="session">
								<html:option value="1">ФАС</html:option>
							</logic:equal>
							<logic:equal name="FactsLeasePageForm"	property="showColumn.isRutsr" value="true"	scope="session">
								<html:option value="2">РУЦР</html:option>
							</logic:equal>
							<logic:equal name="FactsLeasePageForm"	property="showColumn.isAir_gr" value="true" scope="session">
								<html:option value="3">Аэро-граж</html:option>
							</logic:equal>
							<logic:equal name="FactsLeasePageForm"	property="showColumn.isAir_w" value="true"	scope="session">
								<html:option value="4">Аэро-воен в\ч</html:option>
							</logic:equal>
							<logic:equal name="FactsLeasePageForm"	property="showColumn.isGps"	value="true" scope="session">
								<html:option value="5">ГПС</html:option>
							</logic:equal>
							<logic:equal name="FactsLeasePageForm"	property="showColumn.isGasn" value="true" scope="session">
								<html:option value="6">ГАСН</html:option>
							</logic:equal>
							<logic:equal name="FactsLeasePageForm"	property="showColumn.isSes"	value="true" scope="session">
								<html:option value="7">СЭС</html:option>
							</logic:equal>
							<logic:equal name="FactsLeasePageForm"	property="showColumn.isVch" value="true" scope="session">
								<html:option value="8">в\ч</html:option>
							</logic:equal>
							<logic:equal name="FactsLeasePageForm"	property="showColumn.isTu" value="true" scope="session">
								<html:option value="9">ТУ</html:option>
							</logic:equal>
							<logic:equal name="FactsLeasePageForm"	property="showColumn.isOtvod" value="true" scope="session">
								<html:option value="10">Акт Землеотвода</html:option>
							</logic:equal>
							<logic:equal name="FactsLeasePageForm"	property="showColumn.isKadastr"	value="true" scope="session">
								<html:option value="11">Дело кадастра</html:option>
							</logic:equal>
							<logic:equal name="FactsLeasePageForm"	property="showColumn.isProperty" value="true" scope="session">
								<html:option value="12">Договор имущества</html:option>
							</logic:equal>
						</html:select>
					</TD>
					<TD>с : <html:text property="dataPeriod.fromDateFrm" size="11" styleId="fromDateFrm"/>
						<a href="javascript:void(0)" onclick="popCalInMainFrame(document.thisForm.fromDateFrm, document.thisForm.toDateFrm, true);return false;" HIDEFOCUS>
							<img name="popcal" align="absbottom" src="/images/calbtn.gif" width="34" height="22" border="0" alt=""></a>
					</TD>
					<TD>по : <html:text property="dataPeriod.toDateFrm" size="11" styleId="toDateFrm"/>
						<a href="javascript:void(0)" onclick="popCalInMainFrame(document.thisForm.fromDateFrm, document.thisForm.toDateFrm, false);return false;" HIDEFOCUS>
							<img name="popcal" align="absbottom" src="/images/calbtn.gif" width="34" height="22" border="0" alt=""></a>
					</TD>
				</TR--%>
				<TR>
					<TD height="80" bgcolor="D6EBFF">&nbsp;</TD>
				</TR>
			</TBODY>
		</TABLE>

</html:form>

</BODY>
</html:html>
<script language="javascript">
	//switchFilter();
	switchGroup();
	hideDopFilter();
</script>
