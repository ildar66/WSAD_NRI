<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld"    prefix="alex" %>

<%@ page import="com.hps.july.constants.Applications" %>
<%@ page import="com.hps.july.jdbcpersistence.lib.*" %>
<%@ page import="org.apache.struts.util.*" %>
<%@ page import="com.hps.july.basestation.valueobject.*" %>
<%@ page import="com.hps.july.basestation.formbean.*" %>
<%@ page import="com.hps.july.web.util.*" %>

<%
	String gColSpan = "2";
	String formLink=null;
	if(session.getAttribute("returnFormName").equals("FactBaseStationForm")) {
		formLink="/ProcessSector_FBS.do";
	} else if(session.getAttribute("returnFormName").equals("AntennaSectorListForm")) {
		formLink="/ProcessSector_E.do";
	}
	SectorForm dForm=(SectorForm)pageContext.findAttribute("SectorForm");
%>

<july:editform action="<%=formLink%>">
<style>
.editradio {
	FONT-FAMILY: Verdana,Arial; FONT-SIZE: 10pt;
}
</style>
<script language="javascript">
var letters = new Array('A','B','C','D','E','F','G','O','A','B','C','D','O','E','F','G','H','O');

function recalcLac() {
	var l = parseInt(document.all.lac.value);
	if(l > 65535) {
		alert('Номер LAC должен быть числом от 0 до 65536!');
	} else {
		if(document.all.lac.value != '') {
			document.all.lachex.value = getHexLac();
			document.all.lachdx.value = getHdxLac();
		}
	}
}
function getHexLac() {
	return ((new Number(document.all.lac.value)).toString(16)).toUpperCase();
}
function getHdxLac() {
	var l = parseInt(document.all.lac.value);
	var h = (new Number(Math.floor(l / 0x100)).toString(16)).toUpperCase();
	var dd = Math.floor(l % 0x100);
	h += (Math.floor(dd / 100) % 10);
	h += (Math.floor(dd /10)%10);
	h += Math.floor(dd%10);
	return h;
}
function changeBand() {
	if(document.all.bandFrm.value == '800') {
		document.all.g900.style.display = 'none';
		document.all.g900.style.visibility = 'hidden';
		document.all.g1800.style.display = 'none';
		document.all.g1800.style.visibility = 'hidden';
		document.all.d800.style.display = 'inline-block';
		document.all.d800.style.visibility = 'visible';
	} else
	if(document.all.bandFrm.value == '900') {
		document.all.g1800.style.display = 'none';
		document.all.g1800.style.visibility = 'hidden';
		document.all.d800.style.display = 'none';
		document.all.d800.style.visibility = 'hidden';
		document.all.g900.style.display = 'inline-block';
		document.all.g900.style.visibility = 'visible';
	} else
	if(document.all.bandFrm.value == '1800') {
		document.all.g900.style.display = 'none';
		document.all.g900.style.visibility = 'hidden';
		document.all.d800.style.display = 'none';
		document.all.d800.style.visibility = 'hidden';
		document.all.g1800.style.display = 'inline-block';
		document.all.g1800.style.visibility = 'visible';
	} else {
		document.all.g900.style.display = 'none';
		document.all.g900.style.visibility = 'hidden';
		document.all.d800.style.display = 'none';
		document.all.d800.style.visibility = 'hidden';
		document.all.g1800.style.display = 'none';
		document.all.g1800.style.visibility = 'hidden';
	}
}
function setSectorName(letter) {
//	document.all.namesect.value = document.all['bsForm.stationName'].value + '_' + letter;
	if(document.all.action.value == 'Add') {
		var l = document.all.lett;
		for(var i = 0; i < 18; i++) {
			if(l[i].checked) {
				document.all.namesect.value = document.all['bsForm.stationName'].value + '_' + letters[i];
			}
		}
	}
}
</script>

<table class="main">

<july:separator/>
<july:formbuttons/>
<july:separator/>

<tr>
	<td class="title" colspan="2"><july:actionalert/></td>
</tr>
<july:separator/>
<% if("Edit".equals(dForm.getAction())) { %>

<%
	boolean isFromSiteinfo=ParamsParser.getRootApp(pageContext)==Applications.SITEINFO;//(sm.getRootState().getApp()==Applications.SITEINFO);

	String linkCopy1="/EditCopySector.do";
	String journalUrl=AppConstants.BASE_POSITION+"/ShowJournalList.do?objecttype="+ObjectType.Sector+"&objectid="+dForm.getIdsect();
	String onclickStr="openWindow('"+journalUrl+"');return false;";
	String repeaterUrl="/ShowFromSectorRepeaterList.do?idsect="+dForm.getIdsect();
%>

<tr>
	<td class="text"><bean:message key="label.position.actions"/>:</td>
	<td>
		<%if(!isFromSiteinfo){%>
			<alex:hasAccess href="<%=linkCopy1%>">
				<july:link page="<%=linkCopy1%>"><bean:message key="label.basestation.copy"/></july:link>
			</alex:hasAccess>
		<%}%>
		<%--журнал изменений--%>
		<alex:hasAccess href="/ShowJournalList.do" file="/WEB-INF/web_siteinfo.xml">
			<html:link onclick="<%=onclickStr%>" page="<%=journalUrl%>"><bean:message key="label.menu.journal"/></html:link>
		</alex:hasAccess>
		<alex:hasAccess href="/ShowFromSectorRepeaterList.do">
			<html:link page="<%=repeaterUrl%>"><bean:message key="label.repeaters"/></html:link>
		</alex:hasAccess>
	</td>
</tr>

<july:separator/>
<% } %>

<%@ include file="/sectorForm/baseStationFields.jsp"  %>

<july:separator/>

<input type="hidden" name="byhand" value="true">
<%--номер String +--%>
<tr>
	<td class="text"><july:reqmark>CellID:</july:reqmark></td>
	<td>
		<july:string property="cellid" size="10" insertable="true" updatable="true" />
<logic:notEqual name="SectorForm" property="bsForm.stationType" value="<%=BaseStationObject.TYPE_CHECK_DAMPS_D%>" >
		LAC:
		<july:string property="lac" size="5" insertable="true" updatable="true" onchange="recalcLac();"/>
		<july:string property="lachex" size="5" insertable="false" updatable="false" />
		<july:string property="lachdx" size="5" insertable="false" updatable="false" />
</logic:notEqual>
	</td>
</tr>
<logic:notEqual name="SectorForm" property="bsForm.stationType" value="<%=BaseStationObject.TYPE_CHECK_DAMPS_D%>" >
<tr>
	<td class="text">
		<july:reqmark>CellName:</july:reqmark>
	</td>
	<td>
		<july:string property="cellname" size="15" insertable="false" updatable="false" />
	</td>
</tr>
</logic:notEqual>
<%--диапазон +--%>
<tr>
	<td class="text"><july:reqmark><bean:message key="Sector.band"/>:</july:reqmark></td>
	<td>
<%
	String s = ("Add".equals(dForm.getAction()))?"true":"false";
	String stD800 = "display:none;visibility:hidden;";
	String stG1800 = "display:none;visibility:hidden;";
	String stG900 = "display:none;visibility:hidden;";
	if(dForm.getBand() == 800) {
		stD800 = "display:inline-block;visibility:visible;";
	} else if(dForm.getBand() == 1800) {
		stG1800 = "display:inline-block;visibility:visible;";
	} else if(dForm.getBand() == 900) {
		stG900 = "display:inline-block;visibility:visible;";
	}
%>
		<july:select property="bandFrm" styleId="bandId" insertable="true" updatable="<%=s%>" styleClass="editsmall" onchange="changeBand();">
			<logic:equal name="SectorForm" property="bsForm.stationType" value="D" >
				<html:option value="800">800</html:option>
			</logic:equal>
			<logic:notEqual name="SectorForm" property="bsForm.stationType" value="D" >
				<html:option value="900">900</html:option>
				<html:option value="1800">1800</html:option>
			</logic:notEqual>
		</july:select>
		<span id="d800" style="<%=stD800%>">
			<july:radio styleClass="editradio" property="lett" value="1" insertable="<%=s%>" updatable="<%=s%>" onclick="setSectorName();"/>A
			<july:radio styleClass="editradio" property="lett" value="2" insertable="<%=s%>" updatable="<%=s%>" onclick="setSectorName();"/>B
			<july:radio styleClass="editradio" property="lett" value="3" insertable="<%=s%>" updatable="<%=s%>" onclick="setSectorName();"/>C
			<july:radio styleClass="editradio" property="lett" value="4" insertable="<%=s%>" updatable="<%=s%>" onclick="setSectorName();"/>D
			<july:radio styleClass="editradio" property="lett" value="5" insertable="<%=s%>" updatable="<%=s%>" onclick="setSectorName();"/>E
			<july:radio styleClass="editradio" property="lett" value="6" insertable="<%=s%>" updatable="<%=s%>" onclick="setSectorName();"/>F
			<july:radio styleClass="editradio" property="lett" value="7" insertable="<%=s%>" updatable="<%=s%>" onclick="setSectorName();"/>G
			<july:radio styleClass="editradio" property="lett" value="0" insertable="<%=s%>" updatable="<%=s%>" onclick="setSectorName();"/>O
		</span>
		<span id="g1800" style="<%=stG1800%>">
			<july:radio styleClass="editradio" property="lett" value="1" insertable="<%=s%>" updatable="<%=s%>" onclick="setSectorName();"/>A
			<july:radio styleClass="editradio" property="lett" value="2" insertable="<%=s%>" updatable="<%=s%>" onclick="setSectorName();"/>B
			<july:radio styleClass="editradio" property="lett" value="3" insertable="<%=s%>" updatable="<%=s%>" onclick="setSectorName();"/>C
			<july:radio styleClass="editradio" property="lett" value="4" insertable="<%=s%>" updatable="<%=s%>" onclick="setSectorName();"/>D
			<july:radio styleClass="editradio" property="lett" value="0" insertable="<%=s%>" updatable="<%=s%>" onclick="setSectorName();"/>O
		</span>
		<span id="g900" style="<%=stG900%>">
			<july:radio styleClass="editradio" property="lett" value="5" insertable="<%=s%>" updatable="<%=s%>" onclick="setSectorName();"/>E
			<july:radio styleClass="editradio" property="lett" value="6" insertable="<%=s%>" updatable="<%=s%>" onclick="setSectorName();"/>F
			<july:radio styleClass="editradio" property="lett" value="7" insertable="<%=s%>" updatable="<%=s%>" onclick="setSectorName();"/>G
			<july:radio styleClass="editradio" property="lett" value="8" insertable="<%=s%>" updatable="<%=s%>" onclick="setSectorName();"/>H
			<july:radio styleClass="editradio" property="lett" value="9" insertable="<%=s%>" updatable="<%=s%>" onclick="setSectorName();"/>O
		</span>
	</td>
</tr>
<%--название +--%>
<tr>
	<td class="text">
		<july:reqmark><bean:message key="BaseStation.stationName"/>:</july:reqmark>
	</td>
	<td>
		<july:string property="namesect" size="50" insertable="true" updatable="true" />
	</td>
</tr>
<%--Тип сектора String +--%>
<tr>
	<td class="text"><bean:message key="Sector.conf"/>:</td>
	<td>
		<alex:select property="conf" styleId="confId" insertable="true" updatable="true" styleClass="editsmall" style="width:120pt;" >
			<html:option key="label.select.undefined" value=""/>
			<html:option key="CONF_CHECK_1" value="<%=SectorObject.CONF_CHECK_1%>"/>
			<html:option key="CONF_CHECK_2" value="<%=SectorObject.CONF_CHECK_2%>"/>
			<html:option key="CONF_CHECK_3" value="<%=SectorObject.CONF_CHECK_3%>"/>
			<html:option key="CONF_CHECK_4" value="<%=SectorObject.CONF_CHECK_4%>"/>
		</alex:select>
	</td>
</tr>
<%--азимут-BigDecimal +--%>
<tr>
	<td class="text"><july:reqmark><bean:message key="Antenna.asim"/>:</july:reqmark></td>
	<td>
		<july:string property="azimutFrm" size="10" insertable="true" updatable="true" />
	</td>
</tr>
<%--номер BTS--%>
<tr>
	<td class="text"><bean:message key="Sector.btsnumber"/>:</td>
	<td>
		<july:string property="btsnumber" size="10" insertable="true" updatable="true" />
	</td>
</tr>
<%--Подключение к A-bis String +--%>
<%--Наличие фильтра Boolean +--%>
<tr>
	<td class="text"><bean:message key="Sector.conabis"/>:</td>
	<td>
		<alex:select property="conabis" styleId="bandId" insertable="true" updatable="true" styleClass="editsmall" >
			<html:option  key="CONABIS_CHECK_STAR_1" value="<%=SectorObject.CONABIS_CHECK_STAR_1%>"/>
			<html:option  key="CONABIS_CHECK_RING_2" value="<%=SectorObject.CONABIS_CHECK_RING_2%>"/>
			<html:option  key="CONABIS_CHECK_RING_3" value="<%=SectorObject.CONABIS_CHECK_RING_3%>"/>
		</alex:select>
		&nbsp;&nbsp;&nbsp;
		<bean:message key="Sector.hasflt"/>
		<july:checkbox property="hasflt" insertable="true" updatable="true" />
	</td>
</tr>

<%--Номер A-bis порта Integer +--%>
<%--Наличие МШУ Boolean +--%>
<tr>
	<td class="text"><bean:message key="Sector.portabis"/>:</td>
	<td>
		<july:string property="portabisFrm" size="10" insertable="true" updatable="true" />
		&nbsp;&nbsp;&nbsp;
		<bean:message key="Sector.haslna"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<july:checkbox property="haslna" insertable="true" updatable="true" />
	</td>
</tr>
<%--Номер версии ПО String +--%>
<%--Наличие бустера Boolean +--%>
<tr>
	<td class="text"><bean:message key="Sector.numpo"/>:</td>
	<td>
		<july:string property="numpo" size="10" insertable="true" updatable="true" />
		&nbsp;&nbsp;&nbsp;
		<bean:message key="Sector.hasbuster"/>&nbsp;
		<july:checkbox property="hasbuster" insertable="true" updatable="true" />
	</td>
</tr>

<%--Наличие ДДК +--%>
<tr>
	<td class="text"><bean:message key="Sector.ddk"/>:</td>
	<td>
		<july:checkbox property="ddk" insertable="true" updatable="true" />
	</td>
</tr>

<tr>
	<td class="text">&nbsp;</td>
	<td>
		<logic:equal name="SectorForm" property="baseStation.stationType"  value="<%=BaseStationObject.TYPE_CHECK_DAMPS_D%>" >
			<bean:message key="Sector.ANALOG"/>
			<%for(int i=0;i<30;i++){%>&nbsp;<%}%>
		</logic:equal>
		<bean:message key="Sector.DIG"/>
		<logic:equal name="SectorForm" property="baseStation.stationType"  value="<%=BaseStationObject.TYPE_CHECK_DAMPS_D%>" >
			<%for(int i=0;i<30;i++){%>&nbsp;<%}%>
			<bean:message key="Sector.OVR"/>
		</logic:equal>
	</td>
</tr>

<%--Число TRX +--%>
<tr>
	<td class="text"><bean:message key="Sector.TRX"/>:</td>
	<td>
		<logic:equal name="SectorForm" property="baseStation.stationType"  value="<%=BaseStationObject.TYPE_CHECK_DAMPS_D%>" >
			<july:string property="trxnum2Frm" size="10" insertable="true" updatable="true" />
			&nbsp;&nbsp;&nbsp;
		</logic:equal>
		<july:string property="trxnumFrm" size="10" insertable="true" updatable="true" />
		<logic:equal name="SectorForm" property="baseStation.stationType"  value="<%=BaseStationObject.TYPE_CHECK_DAMPS_D%>" >
			&nbsp;&nbsp;&nbsp;
			<july:string property="trxovrnumFrm" size="10" insertable="true" updatable="true" />
		</logic:equal>
    </td>
</tr>

<%--мощность на выходе транс  +--%>
<tr>
	<td class="text"><bean:message key="Sector.label.pwr"/>:</td>
	<td>
		<logic:equal name="SectorForm" property="baseStation.stationType"  value="<%=BaseStationObject.TYPE_CHECK_DAMPS_D%>" >
			<july:string property="txpwr2Frm" size="10" insertable="true" updatable="true" />
			&nbsp;&nbsp;&nbsp;
		</logic:equal>
		<july:string property="txpwrFrm" size="10" insertable="true" updatable="true" />
		<logic:equal name="SectorForm" property="baseStation.stationType"  value="<%=BaseStationObject.TYPE_CHECK_DAMPS_D%>" >
			&nbsp;&nbsp;&nbsp;
			<july:string property="txovrsetpwrFrm" size="10" insertable="true" updatable="true" />
		</logic:equal>
	</td>
</tr>

<logic:notEqual name="SectorForm" property="baseStation.stationType"  value="<%=BaseStationObject.TYPE_CHECK_DAMPS_D%>" >

<%--Наличие HR +--%>
<tr>
	<td class="text"><bean:message key="Sector.ishr"/>:</td>
	<td>
		<july:checkbox property="ishr" insertable="true" updatable="true" />
	</td>
</tr>

<%--Наличие GPRS +--%>
<tr>
	<td class="text"><bean:message key="Sector.capgprs"/>:</td>
	<td>
		<july:checkbox property="capgprs" insertable="true" updatable="true" />
	</td>
</tr>

</logic:notEqual>

<tr>
	<td class="text">Источник ввода данных<%--<bean:message key="BaseStationForm.nstoek"/>:--%></td>
	<td>
		<july:string property="datasource" size="15" insertable="false" updatable="false" />		
	</td>
</tr>

<%
	request.setAttribute("antennes",AntennaObject.findBySector(dForm.getIdsect()));
	if(dForm.getAction().equals("Edit")) {
		String link="/EditChoiceAntennes_FBS.do?sect="+dForm.getIdsect();
%>
	<tr class='title'>
	<td class="title" colspan='2'>
		<july:link page="<%=link%>" >
			<bean:message key="Antenna.choice"/>:
		</july:link>
	</td>
	</tr>
<%
	} else if(dForm.getAction().equals("View")) {
%>
	<tr class='title'>
	<td class="title" colspan='2'>
		<bean:message key="Antenna.choice"/>:
	</td>
	</tr>
<%
	}
%>
<%
	if("Edit".equals(dForm.getAction()) || "View".equals(dForm.getAction())) {
%>
<tr>
<td colspan="2">
<%@ include file="/sectorForm/antennaList.jsp"%>
</td>
</tr>
<%
	}
%>
<july:separator/>
<july:formbuttons/>
<july:separator/>
</table>
<script language="javascript">
//	changeBand();
	setSectorName();
</script>
</july:editform>
