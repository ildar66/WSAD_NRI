<%@ page language = "java" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld" prefix="alex" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import="org.apache.struts.util.*"%>
<%@ page import="com.hps.july.basestation.valueobject.*"%>
<%@ page import="com.hps.july.basestation.formbean.*" %>
<%@ page import="com.hps.july.jdbcpersistence.lib.*" %>
<%@ page import="com.hps.july.constants.Applications" %>

<body onFocus=refreshBands()>
<%
	AntennaForm form = (AntennaForm)pageContext.findAttribute("AntennaForm");
	String formLink=null;
	if(session.getAttribute("returnFormName").equals("FactBaseStationForm")) {
		formLink="/ProcessAntenna_FBS.do";
	} else if(session.getAttribute("returnFormName").equals("AntennaSectorListForm")) {
		formLink="/ProcessAntenna_E.do";
	}
%>
<july:editform action="<%=formLink%>" styleId="af">
<table class="main">
<july:separator/>
<july:formbuttons/>
<july:separator/>

<tr>
	<td class="title" colspan="2"><july:actionalert/></td>
</tr>
<logic:equal value="Delete" name="AntennaForm" property="action">
<jsp:include page="/antennaForm/warning.jsp" flush="true"/>
</logic:equal>
<july:separator/>
<logic:equal name="AntennaForm" property="action" value="Edit">
<%
	boolean isFromSiteinfo=false;//sm.getRootState().getApp()==Applications.SITEINFO;

	String linkCopy1="/EditCopyAntenna.do";
	String journalUrl=AppConstants.BASE_POSITION+"/ShowJournalList.do?objecttype="+ObjectType.Antenna+"&objectid="+form.getIdanten();
	String onclickStr="openWindow('"+journalUrl+"');return false;";
%>

<tr>
	<td class="text"><bean:message key="label.position.actions"/>:</td>
	<td>
		<alex:hasAccess href="<%=linkCopy1%>">
			<july:link page="<%=linkCopy1%>"><bean:message key="label.basestation.copy"/></july:link>
		</alex:hasAccess>
		<%--журнал изменений--%>
		<alex:hasAccess href="/ShowJournalList.do" file="/WEB-INF/web_siteinfo.xml">
			<july:link onclick="<%=onclickStr%>" page="<%=journalUrl%>"><bean:message key="label.menu.journal"/></july:link>
		</alex:hasAccess>
	</td>
</tr>
<july:separator/>
</logic:equal>

<%@ include file="/antennaForm/baseStationFields.jsp"  %>

<july:separator/>

<input type="hidden" name="byhand" value="true"  >

<%--Номер антены--%>
<tr>
	<td class="text"><july:reqmark><bean:message key="AntennaForm.numant"/>:</july:reqmark></td>
	<td>
		<july:string property="numant" size="30" insertable="true" updatable="true" />
	</td>
</tr>
<%--Азимут--%>
<%--Диапазон регулировки по азимуту--%>
<tr>
	<td class="text"><july:reqmark><bean:message key="AntennaForm.azant"/>:</july:reqmark></td>
	<td>
		<july:string property="azantFrm" size="10" insertable="true" updatable="true" />
		&nbsp;&nbsp;&nbsp;
		<bean:message key="AntennaForm.azvariation"/>:
		<july:string property="azvariation" size="10" insertable="true" updatable="true" />
	</td>
</tr>

<%--Вид антенны--%>
<tr>
	<td class="text">
		<july:reqmark><bean:message key="AntennaForm.kindant"/></july:reqmark> / <bean:message key="AntennaForm.locationtype"/>:
	</td>
	<td>
		<july:radio property="kindant" value="<%=AntennaObject.KINDANT_CHECK_T%>" insertable="true" updatable="true" styleClass="editcheckboxform"/>
		<%=AntennaObject.KINDANT_T_LABEL_T%>&nbsp;&nbsp;&nbsp;
		<july:radio property="kindant" value="<%=AntennaObject.KINDANT_CHECK_D%>" insertable="true" updatable="true" styleClass="editcheckboxform"/>
		<%=AntennaObject.KINDANT_D_LABEL_TR%>&nbsp;&nbsp;&nbsp;
		<july:radio property="kindant" value="<%=AntennaObject.KINDANT_CHECK_R%>" insertable="true" updatable="true" styleClass="editcheckboxform"/>
		<%=AntennaObject.KINDANT_R_LABEL_R%>

		/ 

		<july:select property="locationtype" styleId="locationtypeId" insertable='true' updatable='true' >
			<html:option key="AntennaForm.locationtype.outdoor" value="<%=Checks.ANTENNA_LOCATIONTYPE_OUTDOOR_O%>"/>
			<html:option key="AntennaForm.locationtype.indoor" value="<%=Checks.ANTENNA_LOCATIONTYPE_INDOOR_I%>"/>
		</july:select>
	</td>
</tr>

<script language="javascript">
function recalcSummnakl() {
	var m = parseFloat(document.all.naklFrm.value);
	if(m == 'NaN') { 
		document.all.sumnakl.value = document.all.naklFrm.value;
	} else {
		var ea1 = parseFloat(document.all.ea900f.value);
		var ea2 = parseFloat(document.all.ea1800f.value);
		if(isNaN(ea1)) { ea1 = 0; }
		if(isNaN(ea2)) { ea2 = 0; }
//		alert('800:'+document.all.ea800f.value+' 900:'+document.all.ea900f.value+' 1800:'+document.all.ea1800f.value);
//		alert('M:'+m+' EA1:'+ea1+' EA2:'+ea2);
		if(ea1 != ea2) {
			document.all.sumnakl.value = Math.round((m + ea1)*100) /
			100 + '/' + Math.round((m + ea2)*100) / 100;
		} else {
			document.all.sumnakl.value = '' + Math.round((m + ea1)*100)/100;
		}
	}
}

function updateCables() {
	var bc = 0;
	if(document.all.bandcodeId[0] && document.all.bandcodeId[0].checked) {
		bc += 1;
	}
	if(document.all.bandcodeId[1] && document.all.bandcodeId[1].checked) {
		bc += 1;
	}
	if(document.all.bstypeFrm.value == "D") {
		if("V" == document.all.antpol.value) {
			document.all.cable1.style.display = 'block';
			document.all.cable2.style.display = 'none';
			document.all.cable3.style.display = 'none';
			document.all.cable4.style.display = 'none';
		} else if("C" == document.all.antpol.value) {
			document.all.cable1.style.display = 'block';
			document.all.cable2.style.display = 'block';
			document.all.cable3.style.display = 'none';
			document.all.cable4.style.display = 'none';
		}
	} else {
		if("V" == document.all.antpol.value) {
			document.all.cable1.style.display = 'block';
			if(bc > 1) {
				document.all.cable2.style.display = 'block';
			} else {
				document.all.cable2.style.display = 'none';
			}
			document.all.cable3.style.display = 'none';
			document.all.cable4.style.display = 'none';
		} else if("C" == document.all.antpol.value) {
			document.all.cable1.style.display = 'block';
			document.all.cable2.style.display = 'block';
			if(bc > 1) {
				document.all.cable3.style.display = 'block';
				document.all.cable4.style.display = 'block';
			} else {
				document.all.cable3.style.display = 'none';
				document.all.cable4.style.display = 'none';
			}
		}
	}
	if(document.all.bandcodeId[0]) {
		var cls = document.all.bandcodeId[0].checked?"editkodsearch":"editkoddisabled";
		document.all['cab1.ksvn'+document.all.bandcodeId[0].value+'.string'].disabled = !document.all.bandcodeId[0].checked;
		document.all['cab1.ksvn'+document.all.bandcodeId[0].value+'.string'].className = cls;
		document.all['cab2.ksvn'+document.all.bandcodeId[0].value+'.string'].disabled = !document.all.bandcodeId[0].checked;
		document.all['cab2.ksvn'+document.all.bandcodeId[0].value+'.string'].className = cls;
		document.all['cab3.ksvn'+document.all.bandcodeId[0].value+'.string'].disabled = !document.all.bandcodeId[0].checked;
		document.all['cab3.ksvn'+document.all.bandcodeId[0].value+'.string'].className = cls;
		document.all['cab4.ksvn'+document.all.bandcodeId[0].value+'.string'].disabled = !document.all.bandcodeId[0].checked;
		document.all['cab4.ksvn'+document.all.bandcodeId[0].value+'.string'].className = cls;
	}
	if(document.all.bandcodeId[1]) {
		var cls2 = document.all.bandcodeId[1].checked?"editkodsearch":"editkoddisabled";
		document.all['cab1.ksvn'+document.all.bandcodeId[1].value+'.string'].disabled = !document.all.bandcodeId[1].checked;
		document.all['cab1.ksvn'+document.all.bandcodeId[1].value+'.string'].className = cls2;
		document.all['cab2.ksvn'+document.all.bandcodeId[1].value+'.string'].disabled = !document.all.bandcodeId[1].checked;
		document.all['cab2.ksvn'+document.all.bandcodeId[1].value+'.string'].className = cls2;
		document.all['cab3.ksvn'+document.all.bandcodeId[1].value+'.string'].disabled = !document.all.bandcodeId[1].checked;
		document.all['cab3.ksvn'+document.all.bandcodeId[1].value+'.string'].className = cls2;
		document.all['cab4.ksvn'+document.all.bandcodeId[1].value+'.string'].disabled = !document.all.bandcodeId[1].checked;
		document.all['cab4.ksvn'+document.all.bandcodeId[1].value+'.string'].className = cls2;
	}
}
</script>

<%--тип оборудования--%>
<tr>
	<td class="text" nowrap><july:reqmark><bean:message key="AntennaForm.restype"/></july:reqmark></td>
	<td class="text" nowrap>
		<july:string property="resourceIdFrm" styleId="resourcetype" size="5" insertable="true" updatable="true"/>
		<july:lookupbutton action="/ShowAntennaResLookupList.do" formname="af" newWindowName="antenL"  styleId="aresId" fieldNames="resourcetype;resourcetypename;resBandId;ea800f;ea900f;ea1800f;antpol;"  insertable="true" updatable="true" onselect="recalcSummnakl();updateCables();"/>
		<july:string size="25" property="resourceName" styleId="resourcetypename" insertable="false" updatable="false" />
<input type='hidden' name='resBand' id='resBandId'  value='<%=form.getResBandsString()%>'/>
<html:hidden property="ea800" styleId="ea800f"/>
<html:hidden property="ea900" styleId="ea900f"/>
<html:hidden property="ea1800" styleId="ea1800f"/>
<html:hidden property="antpol" styleId="antpol"/>
<html:hidden property="bsForm.stationType" styleId="bstypeFrm"/>
	</td>
</tr>

<tr>
	<td class="text" nowrap>Серийный номер антенны:</td>
	<td class="text" nowrap>
		<july:string size="25" property="resourceSerial" styleId="resourceSerial" insertable="true" updatable="true" />
	</td>
</tr>

<tr>
<td class="text"><bean:message key="Sector.band"/>:</td>
<td>
	<%if("D".equals(form.getBsForm().getStationType())) {%>
		<july:checkbox property="bandcodes" styleId="bandcodeId" insertable="true" updatable="true" value="800" onclick="updateCables();"/>&nbsp;800&nbsp;&nbsp;&nbsp;
	<%} else {%>
		<july:checkbox property="bandcodes" styleId="bandcodeId" insertable="true" updatable="true" value="900" onclick="updateCables();"/>&nbsp;900&nbsp;&nbsp;&nbsp;
		<july:checkbox property="bandcodes" styleId="bandcodeId" insertable="true" updatable="true" value="1800" onclick="updateCables();"/>&nbsp;1800&nbsp;&nbsp;&nbsp;
	<%}%>

<SCRIPT language=javascript>
function hasElement(arr,element){
	for(var i=0; i < arr.length; i++ ) {
        	//alert("arr[" + i + " ]="+arr[i]+" element="+element);
		if(element==arr[i]) {
			//alert("true");
			return true;
		}
	}
	//alert("false");
	return false;
}

function refreshBands(){
	//alert('refreshBands started');
	var bString=document.all.item("resBandId").value;
	var kk=bString.indexOf(' ');
	//alert("kk="+kk);
	if(kk>=0) {
		bString=bString.substr(0,kk);
	}
	bString=bString+"/";
	//alert("bString="+bString);

	var arr=new Array();
	var k;

	while(bString.indexOf("/") > 0) {
		k=bString.indexOf("/");
		arr=arr.concat(bString.substr(0,k));
		bString=bString.substr(k+1);
	}

	bands=document.all.item("bandcodeId");

	for(var i=0;i < bands.length;i++) {
		if(hasElement(arr,bands[i].value)==false) {
			//alert("нет в массиве bands["+i+"].value="+bands[i].value);
			bands[i].checked=false;
			bands[i].disabled=true;
		} else {
			bands[i].disabled=false;
		}
	}
}
refreshBands();
</SCRIPT>



</td>
</tr>

<tr>
<td class="text"><july:reqmark><bean:message key="AntennaForm.nakl"/>:</july:reqmark></td>
 <td>
    <july:string property="naklFrm" size="10" insertable="true" updatable="true" onchange="recalcSummnakl();"/>
    &nbsp;&nbsp;&nbsp;
    <bean:message key="AntennaForm.naklvariation"/>:
    <july:string property="naklvariation" size="20" insertable="true" updatable="true" />
 </td>
</tr>

<tr>
	<td class="text"><bean:message key="AntennaForm.sumnakl"/>:</td>
	<td>
		<july:string property="sumnakl" size="10" insertable="false" updatable="false" />
	</td>
</tr>

<tr>
	<td class="text"><july:reqmark><bean:message key="AntennaForm.hset1"/>:</july:reqmark></td>
	<td>
		<july:string property="hset1Frm" size="10" insertable="true" updatable="true" />
		&nbsp;&nbsp;&nbsp;
		<bean:message key="AntennaForm.inputpower"/>:
		<july:string property="inputpowerFrm" size="10" insertable="true" updatable="true" />
	</td>
</tr>

<tr>
	<td class="text">Источник ввода данных<%--<bean:message key="BaseStationForm.nstoek"/>:--%></td>
	<td>
		<july:string property="datasource" size="15" insertable="false" updatable="false" />		
	</td>
</tr>

<july:separator/>

<%
	boolean showD = false;
	showD = "D".equals(form.getBsForm().getStationType());
%>

<tr>
	<td class="text" colspan=2><table style="font-family: Verdana,Arial;font-size:10pt;margin:0px;width:100%" border=0>
	<tr class="title">
		<td class="title"></td>
		<td class="title" align="center">Тип кабеля</td>
		<td class="title" align="center">Длина</td>
		<td class="title" align="center">К-во<br>заземлений</td>
<%if(showD){%>
		<td class="title" align="center">КСВН<br>800</td>
<%} else {%>
		<td class="title" align="center">КСВН<br>900</td>
		<td class="title" align="center">КСВН<br>1800</td>
<%}%>
	</tr>

	<tr class="normal" id="cable1">
		<td class="title">Кабель 1</td>
		<td class="text">
			<july:select collection="cableTypes" property="cab1.cabletype.string" insertable="true" updatable="true" style="width:200px;" styleClass="editsearch">
				<html:option value="0">&nbsp;</html:option>
				<html:options collection="cableTypes" property="resource" labelProperty="fullName"/>
			</july:select>
		</td>
		<td class="text"><july:string property="cab1.length.string" size="5" insertable="true" updatable="true" styleClass="editkodsearch" /></td>
		<td class="text"><july:string property="cab1.gnds.string" size="10" insertable="true" updatable="true" styleClass="editsmallsearch"/></td>
<%if(showD){%>
		<td class="text"><july:string property="cab1.ksvn800.string" size="5" insertable="true" updatable="true" styleClass="editkodsearch" /></td>
<%} else {%>
		<td class="text"><july:string property="cab1.ksvn900.string" size="5" insertable="true" updatable="true" styleClass="editkodsearch" /></td>
		<td class="text"><july:string property="cab1.ksvn1800.string" size="5" insertable="true" updatable="true" styleClass="editkodsearch" /></td>
<%}%>
	</tr>

	<tr class="normal" id="cable2">
		<td class="title">Кабель 2</td>
		<td class="text">
			<july:select collection="cableTypes" property="cab2.cabletype.string" insertable="true" updatable="true" style="width:200px;" styleClass="editsearch">
				<html:option value="0">&nbsp;</html:option>
				<html:options collection="cableTypes" property="resource" labelProperty="fullName"/>
			</july:select>
		</td>
		<td class="text"><july:string property="cab2.length.string" size="5" insertable="true" updatable="true" styleClass="editkodsearch" /></td>
		<td class="text"><july:string property="cab2.gnds.string" size="10" insertable="true" updatable="true" styleClass="editsmallsearch" /></td>
<%if(showD){%>
		<td class="text"><july:string property="cab2.ksvn800.string" size="5" insertable="true" updatable="true" styleClass="editkodsearch" /></td>
<%} else {%>
		<td class="text"><july:string property="cab2.ksvn900.string" size="5" insertable="true" updatable="true" styleClass="editkodsearch" /></td>
		<td class="text"><july:string property="cab2.ksvn1800.string" size="5" insertable="true" updatable="true" styleClass="editkodsearch" /></td>
<%}%>
	</tr>

	<tr class="normal" id="cable3">
		<td class="title">Кабель 3</td>
		<td class="text">
			<july:select collection="cableTypes" property="cab3.cabletype.string" insertable="true" updatable="true" style="width:200px;" styleClass="editsearch">
				<html:option value="0">&nbsp;</html:option>
				<html:options collection="cableTypes" property="resource" labelProperty="fullName"/>
			</july:select>
		</td>
		<td class="text"><july:string property="cab3.length.string" size="5" insertable="true" updatable="true" styleClass="editkodsearch" /></td>
		<td class="text"><july:string property="cab3.gnds.string" size="10" insertable="true" updatable="true" styleClass="editsmallsearch" /></td>
<%if(showD){%>
		<td class="text"><july:string property="cab3.ksvn800.string" size="5" insertable="true" updatable="true" styleClass="editkodsearch" /></td>
<%} else {%>
		<td class="text"><july:string property="cab3.ksvn900.string" size="5" insertable="true" updatable="true" styleClass="editkodsearch" /></td>
		<td class="text"><july:string property="cab3.ksvn1800.string" size="5" insertable="true" updatable="true" styleClass="editkodsearch" /></td>
<%}%>
	</tr>

	<tr class="normal" id="cable4">
		<td class="title">Кабель 4</td>
		<td class="text">
			<july:select collection="cableTypes" property="cab4.cabletype.string" insertable="true" updatable="true" style="width:200px;" styleClass="editsearch">
				<html:option value="0">&nbsp;</html:option>
				<html:options collection="cableTypes" property="resource" labelProperty="fullName"/>
			</july:select>
		</td>
		<td class="text"><july:string property="cab4.length.string" size="5" insertable="true" updatable="true" styleClass="editkodsearch" /></td>
		<td class="text"><july:string property="cab4.gnds.string" size="10" insertable="true" updatable="true" styleClass="editsmallsearch" /></td>
<%if(showD){%>
		<td class="text"><july:string property="cab4.ksvn800.string" size="5" insertable="true" updatable="true" styleClass="editkodsearch" /></td>
<%} else {%>
		<td class="text"><july:string property="cab4.ksvn900.string" size="5" insertable="true" updatable="true" styleClass="editkodsearch" /></td>
		<td class="text"><july:string property="cab4.ksvn1800.string" size="5" insertable="true" updatable="true" styleClass="editkodsearch" /></td>
<%}%>
	</tr>
	</table></td>
</tr>

<july:separator/>
<july:formbuttons/>
<july:separator/>

</table>
<script language="javascript">
updateCables();
</script>
</july:editform>
</body>
