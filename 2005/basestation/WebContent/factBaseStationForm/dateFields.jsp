<%@ page import="com.hps.july.basestation.valueobject.BaseStationObject"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld"    prefix="alex" %>

<%
//	FactBaseStationForm bsForm=(FactBaseStationForm)pageContext.findAttribute("FactBaseStationForm");
	if("View".equals(bsForm.getAction())||"Delete".equals(bsForm.getAction())) {
%>
<tr>
<td colspan="2">
<table class="main" id="datetable">
<tr class="title">
	<td class="title" style="font-size:8pt;"></td>
	<td class="title" style="font-size:8pt;">Начало строит. БС</td>
	<td class="title" style="font-size:8pt;">Монтаж и тест. АФС</td>
	<td class="title" style="font-size:8pt;">Монтаж обор. БС</td>
	<td class="title" style="font-size:8pt;">Тест.</td>
	<td class="title" style="font-size:8pt;">Подкл. к MSC</td>
	<td class="title" style="font-size:8pt;">Вкл. в эфир</td>
	<td class="title" style="font-size:8pt;">Приемка в эксп.</td>
</tr>
<%if(bsForm.getStationType() != null && BaseStationObject.TYPE_CHECK_DAMPS_D.equals(bsForm.getStationType())) {%>
<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
	<td class="title" style="font-size:8pt;">DAMPS</td>

	<td class="text"><july:stringwrite property="datebldbegFrm"/></td>
	<td class="text"><july:stringwrite property="dateassembafsFrm"/></td>
	<td class="text"><july:stringwrite property="dateassembFrm"/></td>
	<td class="text"><july:stringwrite property="datetestFrm"/></td>
	<td class="text"><july:stringwrite property="dateconnectFrm"/></td>
	<td class="text"><july:stringwrite property="dateonairFrm"/></td>
	<td class="text"><july:stringwrite property="dateprFrm"/></td>
</tr>
<%}
if(bsForm.getStationType() != null && (BaseStationObject.TYPE_CHECK_GSM_S.equals(bsForm.getStationType())||BaseStationObject.TYPE_CHECK_GSM_G.equals(bsForm.getStationType()))) {%>
<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
	<td class="title" style="font-size:8pt;">GSM</td>

	<td class="text"><july:stringwrite property="datebldbegFrm"/></td>
	<td class="text"><july:stringwrite property="dateassembafsFrm"/></td>
	<td class="text"><july:stringwrite property="dateassembFrm"/></td>
	<td class="text"><july:stringwrite property="datetestFrm"/></td>
	<td class="text"><july:stringwrite property="dateconnectFrm"/></td>
	<td class="text"><july:stringwrite property="dateonairFrm"/></td>
	<td class="text"><july:stringwrite property="dateprFrm"/></td>
</tr>
<%}
if(bsForm.getStationType() != null && (BaseStationObject.TYPE_CHECK_DCS_C.equals(bsForm.getStationType())||BaseStationObject.TYPE_CHECK_GSM_G.equals(bsForm.getStationType()))) {%>
<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
	<td class="title" style="font-size:8pt;">DCS</td>

	<td class="text"><july:stringwrite property="datebldbeg2Frm"/></td>
	<td class="text"><july:stringwrite property="dateassembafs2Frm"/></td>
	<td class="text"><july:stringwrite property="dateassemb2Frm"/></td>
	<td class="text"><july:stringwrite property="datetest2Frm"/></td>
	<td class="text"><july:stringwrite property="dateconnect2Frm"/></td>
	<td class="text"><july:stringwrite property="dateonair2Frm"/></td>
	<td class="text"><july:stringwrite property="datepr2Frm"/></td>
</tr>
<%}%>
</table>
</td>
</tr>

<%
	} else {
%>

<tr>
	<td class="text">&nbsp;</td>
	<td><table class='main'><tr>
		<td class="text" id=labelGsmId style='visibility:visible;display:block'><bean:message key="FactBaseStationForm.gsm"/></td>
		<td class="text" id=labelDcsId style='visibility:visible;display:block'><bean:message key="FactBaseStationForm.dcs"/></td>
	</tr></table></td>
</tr>



<tr>
	<td class="text"><bean:message key="BaseStation.datebldbeg2"/>:</td>
	<td><table class='main'><tr>
		<td id=dateGsmId style='visibility:visible;display:block'><july:date property="datebldbegFrm" required="false" styleId="datebldbeg" size="25" insertable='true' updatable='true'/></td>
		<td id=dateDcsId style='visibility:visible;display:block'><july:date property="datebldbeg2Frm" required="false" styleId="datebldbeg2" size="25" insertable='true' updatable='true'/></td>
	</tr></table></td>
</tr>


<tr>
	<td class="text"><bean:message key="BaseStation.dateassembafs"/>:</td>
	<td><table class='main'><tr>
		<td id=dateGsmId style='visibility:visible;display:block'><july:date property="dateassembafsFrm" required="false" styleId="dateassembafs" size="25" insertable='true' updatable='true'/></td>
		<td id=dateDcsId style='visibility:visible;display:block'><july:date property="dateassembafs2Frm" required="false" styleId="dateassembafs2" size="25" insertable='true' updatable='true'/></td>
	</tr></table></td>
</tr>



<tr>
	<td class="text"><bean:message key="BaseStation.dateassemb2"/>:</td>
	<td><table class='main'><tr>
		<td id=dateGsmId style='visibility:visible;display:block'><july:date property="dateassembFrm" required="false" styleId="dateassemb" size="25" insertable='true' updatable='true'/></td>
		<td id=dateDcsId style='visibility:visible;display:block'><july:date property="dateassemb2Frm" required="false" styleId="dateassemb2" size="25" insertable='true' updatable='true'/></td>
	</tr></table></td>
</tr>



<tr>
	<td class="text"><bean:message key="BaseStation.datetest"/>:</td>
	<td><table class='main'><tr>
		<td id=dateGsmId style='visibility:visible;display:block'><july:date property="datetestFrm" required="false" styleId="datetest" size="25" insertable='true' updatable='true'/></td>
		<td id=dateDcsId style='visibility:visible;display:block'><july:date property="datetest2Frm" required="false" styleId="datetest2" size="25" insertable='true' updatable='true'/></td>
	</tr></table></td>
</tr>



<tr>
	<td class="text"><bean:message key="BaseStation.dateconnect"/>:</td>
	<td><table class='main'><tr>
		<td id=dateGsmId style='visibility:visible;display:block'><july:date property="dateconnectFrm" required="false" styleId="dateconnect" size="25" insertable='true' updatable='true'/></td>
		<td id=dateDcsId style='visibility:visible;display:block'><july:date property="dateconnect2Frm" required="false" styleId="dateconnect2" size="25" insertable='true' updatable='true'/></td>
	</tr></table></td>
</tr>



<tr>
	<td class="text"><bean:message key="BaseStation.dateonair"/>:</td>
	<td><table class='main'><tr>
		<td id=dateGsmId style='visibility:visible;display:block'><july:date property="dateonairFrm" required="false" styleId="dateonair" size="25" insertable='true' updatable='true'/></td>
		<td id=dateDcsId style='visibility:visible;display:block'><july:date property="dateonair2Frm" required="false" styleId="dateonair2" size="25" insertable='true' updatable='true'/></td>
	</tr></table></td>
</tr>



<tr>
	<td class="text"><bean:message key="BaseStation.datepr2"/>:</td>
	<td><table class='main'><tr>
		<td id=dateGsmId style='visibility:visible;display:block'><july:date property="dateprFrm" required="false" styleId="datepr" size="25" insertable='true' updatable='true'/></td>
		<td id=dateDcsId style='visibility:visible;display:block'><july:date property="datepr2Frm" required="false" styleId="datepr2" size="25" insertable='true' updatable='true'/></td>
	</tr></table></td>
</tr>

<script language='javascript'>
function switch_(type) {
	if(type=="<%=BaseStationObject.TYPE_CHECK_DAMPS_D%>"){
		hideLabel('labelGsmId');
		hideLabel('labelDcsId');
		show('dateGsmId');
		hide('dateDcsId');
	} else if(type=="<%=BaseStationObject.TYPE_CHECK_DCS_C%>"){
		hideLabel('labelGsmId');
		showLabel('labelDcsId');
		hide('dateGsmId');
		show('dateDcsId');
	} else if(type=="<%=BaseStationObject.TYPE_CHECK_GSM_S%>") {
		showLabel('labelGsmId');
		hideLabel('labelDcsId');
		show('dateGsmId');
		hide('dateDcsId');
	} else if(type=="<%=BaseStationObject.TYPE_CHECK_GSM_G%>") {
		showLabel('labelGsmId');
		showLabel('labelDcsId');
		show('dateGsmId');
		show('dateDcsId');
	}
}

function show(tdId) {
	for(var i=0;i<document.all(tdId).length;i++){
		document.all(tdId,i).style.visibility='visible';
		document.all(tdId,i).style.display='block';
	}
}
function hide(tdId) {
	for(var i=0;i<document.all(tdId).length;i++) {
		document.all(tdId,i).style.visibility='hidden';
		document.all(tdId,i).style.display='none';
	}
}
function showLabel(tdId) {
	document.all(tdId).style.visibility='visible';
	document.all(tdId).style.display='block';
}
function hideLabel(tdId) {
	document.all(tdId).style.visibility='hidden';
	document.all(tdId).style.display='none';
}
switch_(document.all.stationTypeId.value);
</script>
<%
}
%>