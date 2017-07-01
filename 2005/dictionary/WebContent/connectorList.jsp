<HTML>
<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import = "com.hps.july.dictionary.formbean.*, com.hps.july.web.util.* "%>

<head>
	<META HTTP-EQUIV = "Pragma" CONTENT="no-cache"> 
	<title>Разъемы (список)</title> 
	<link rel="stylesheet" type="text/css" href="/main.css">
</head>

<style>
TR.normalrow {
	background-color:#F0F0F0;
}
TR.selectrow {
	background-color:#FFFFFF;
}
TR.selectedrow {
	background-color:#FFF0D0;
} 
</style>

</head>

<BODY>

	<SCRIPT language=javascript src="/common/dialog.js" type="text/javascript"></SCRIPT>  
	<SCRIPT language=javascript src="/common/exitFromNRI.js" type="text/javascript"></SCRIPT>  
	<SCRIPT language=javascript src="/common/tableUtil.js" type="text/javascript"></SCRIPT>  

<july:editform action="ShowConfConnectorCableCompat" styleId="ShowConfConnectorCableCompatForm"
				target="compatibilityIFrame">

	<table class="find" width="715" style='table-layout: fixed;' id="connectorTableId"> 

   	<logic:iterate id="connectorsList" property="connectorsList" 
   			name="ShowConfConnectorCableCompatForm" 
    		type="com.hps.july.dictionary.valueobject.Resource_VO">

	<tr class="normal"
		id='<bean:write name="connectorsList" property="id" filter="true"/>' 
		onclick='onConnectorClickRow(this.id, false, false, true);' 
			>
		<td width = "70" align="right" class="title">
			<bean:write name="connectorsList" property="id" filter="true"/></td>
		<td width = "190" align="left" class="title">
			<bean:write name="connectorsList" property="manuf" filter="true"/></td>
		<td width = "200" align="left" class="title">
			<bean:write name="connectorsList" property="model" filter="true"/></td>
		<td width = "62" align="left" class="title">
			<bean:write name="connectorsList" property="unit" filter="true"/></td>
		<td width = "58" align="left" class="title">
			<bean:write name="connectorsList" property="active" filter="true"/></td>
		<td width = "110" align="left" class="title">
			<A HREF="#" 
				onclick="showAllNfsCode('<bean:write name="connectorsList" property="id" filter="true"/>'); return false;">
				<bean:write name="connectorsList" property="nfsid" filter="true"/><logic:greaterThan 
				name="connectorsList" property="countnfs" value="1">...</logic:greaterThan> 
			</A>
		</td>
	</tr>
	
	</logic:iterate>
	
	</table>

<html:hidden property="curConnectorSelectedID"/>
<html:hidden property="curConnectorOldRowClassName"/>
<html:hidden property="isNeedCrossToRefresh" value="<%=ShowConfConnectorCableCompatForm.TRUE_STR%>"/>

</july:editform>

<script language="javascript">
function onConnectorClickRow(selectedID, isScroll, isRrequiredSet, isSubmit) {
	selectUnselectScrollToRow(selectedID, isScroll, isRrequiredSet, 
		'connectorTableId', 'curConnectorSelectedID', 'curConnectorOldRowClassName', 'selectedrow',
		'<%=ShowConfConnectorCableCompatForm.BEGIN_ID_INDEX%>');
    //	if (! isScroll) {
    //	if ((! isScroll) && (! isRrequiredSet)) {
    if (isSubmit) {
		// document.all['isNeedCrossToRefresh'].value=<%=ShowConfConnectorCableCompatForm.TRUE_STR%>;
		// alert("onConnectorClickRow 01 " + document.all['isNeedCrossToRefresh'].value);
		setTimeout("ShowConfConnectorCableCompatForm.submit()", 300);
		// alert("onConnectorClickRow 02");
	}	
}

function showAllNfsCode(id) {
    openDialog("ShowAllNfsCodes.do?resource="+id+ "&action=View", 
				"editConfPowerForm", "top=0, left=0, width=1000, height=350, scrollbars=auto, resizable=yes");
	onConnectorClickRow(id, false, true, false);
	onConnectorClickRow(id, false, false, false);			
}				

// начальные установки
onConnectorClickRow(document.all['curConnectorSelectedID'].value, true, false, false);

</script>

</BODY>
</HTML>

