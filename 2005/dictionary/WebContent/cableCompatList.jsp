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
	<title>Кабели (список)</title> 
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

	<table class="find" width="715" style='table-layout: fixed;' id="cableTableId"> 

   	<logic:iterate id="cablesList" property="cablesList" 
   			name="ShowConfConnectorCableCompatForm" 
    		type="com.hps.july.dictionary.valueobject.Cable_VO">

	<tr class="normal"
		id='<bean:write name="cablesList" property="id" filter="true"/>' 
		onclick='onCableClickRow(this.id, false, false, true);' 
			>
		<td width = "70" align="right" class="title">
			<bean:write name="cablesList" property="id" filter="true"/></td>
		<td width = "160" align="left" class="title">
			<bean:write name="cablesList" property="manuf" filter="true"/></td>
		<td width = "170" align="left" class="title">
			<bean:write name="cablesList" property="model" filter="true"/></td>
		<td width = "60" align="left" class="title">
			<bean:write name="cablesList" property="diamname" filter="true"/></td> 
		<td width = "62" align="left" class="title">
			<bean:write name="cablesList" property="unit" filter="true"/></td>
		<td width = "58" align="left" class="title">
			<bean:write name="cablesList" property="active" filter="true"/></td>
		<td width = "110" align="left" class="title">
			<A HREF="#" 
				onclick="showAllNfsCode('<bean:write name="cablesList" property="id" filter="true"/>'); return false;">
				<bean:write name="cablesList" property="nfsid" filter="true"/><logic:greaterThan 
				name="cablesList" property="countnfs" value="1">...</logic:greaterThan> 
			</A>
		</td>
	</tr>
	
	</logic:iterate>
	
	</table>

<html:hidden property="curCableSelectedID"/>
<html:hidden property="curCableOldRowClassName"/>
<html:hidden property="isNeedCrossToRefresh" value="<%=ShowConfConnectorCableCompatForm.TRUE_STR%>"/>

</july:editform>

<script language="javascript">
function onCableClickRow(selectedID, isScroll, isRrequiredSet, isSubmit) {
	selectUnselectScrollToRow(selectedID, isScroll, isRrequiredSet, 
		'cableTableId', 'curCableSelectedID', 'curCableOldRowClassName', 'selectedrow',
		'<%=ShowConfConnectorCableCompatForm.BEGIN_ID_INDEX%>');
	// if ((! isScroll) && (! isRrequiredSet)) {
	if ((isSubmit)) {
		// document.all['isNeedCrossToRefresh'].value=<%=ShowConfConnectorCableCompatForm.TRUE_STR%>;
		setTimeout("ShowConfConnectorCableCompatForm.submit()", 300);
	}
}

function showAllNfsCode(id) {
    openDialog("ShowAllNfsCodes.do?resource="+id+ "&action=View", 
				"editConfPowerForm", "top=0, left=0, width=1000, height=350, scrollbars=auto, resizable=yes");
	onCableClickRow(id, false, true, false);
	onCableClickRow(id, false, false, false);			
}				

// начальные установки
onCableClickRow(document.all['curCableSelectedID'].value, true, false, false);

</script>

</BODY>
</HTML>


