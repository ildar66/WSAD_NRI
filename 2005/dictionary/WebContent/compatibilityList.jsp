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
	<title>Совместимость (список)</title> 
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

<july:editform action="ShowConfConnectorCableCompat" styleId="ShowConfConnectorCableCompatForm" >

<%--
<html:hidden property="isDeleteResCompat" value="<%=ShowConfConnectorCableCompatForm.FALSE_STR%>"/> 
<html:hidden property="selectedCompatRes1" value="<%=ShowConfConnectorCableCompatForm.BEGIN_ID_INDEX%>"/> 
<html:hidden property="selectedCompatRes2" value="<%=ShowConfConnectorCableCompatForm.BEGIN_ID_INDEX%>"/> 
--%>

	<table class="find" width="588" style='table-layout: fixed;' id="compatTableId"> 

   	<logic:iterate id="resourcesCompatList" property="resourcesCompatList" 
   			name="ShowConfConnectorCableCompatForm" 
    		type="com.hps.july.dictionary.valueobject.ResourceCompat_VO"> 

	<tr class="normal"
		id='<bean:write name="resourcesCompatList" property="id" filter="true"/>' 
		onclick='onCompatClickRow(this.id, false, false);' 
			>
		<td width = "270" align="left" class="title">
			<bean:write name="resourcesCompatList" property="resource1" filter="true"/></td>
		<td width = "270" align="left" class="title">
			<bean:write name="resourcesCompatList" property="resource2" filter="true"/></td>
		<td width = "30" align="center" class="title">
			<logic:equal name="ShowConfConnectorCableCompatForm" property="canDeleteCompat" 
							value="<%=ShowConfConnectorCableCompatForm.TRUE_STR%>">
				<A HREF="#"><IMG BORDER="0" SRC="/images/delconf.gif" 
					onclick="deletemResCompat( '<bean:write name="resourcesCompatList" property="resource1" filter="true"/>',
					<bean:write name="resourcesCompatList" property="resource2" filter="true"/>); return false;"
					ALT='<bean:message key="button.delete"/>'>
				</A>
			</logic:equal>	
			<logic:equal name="ShowConfConnectorCableCompatForm" property="canDeleteCompat" 
							value="<%=ShowConfConnectorCableCompatForm.FALSE_STR%>">
				&nbsp;			
			</logic:equal>	
		</td>
	</tr>

	</logic:iterate>
	
	</table>

		<!-- canNewCompatCreate -->
		<logic:equal name="ShowConfConnectorCableCompatForm" property="canNewCompatCreate" 
						value="<%=ShowConfConnectorCableCompatForm.TRUE_STR%>">
			<script language="javascript">
				if ((parent.document.all['notNewCompatDivId']) && 
					(parent.document.all['newCompatDivId'])) {
					parent.document.all['notNewCompatDivId'].style.display = 'none'; 
					parent.document.all['newCompatDivId'].style.display = 'block';
				}
			</script>
		</logic:equal>
		<logic:equal name="ShowConfConnectorCableCompatForm" property="canNewCompatCreate" 
						value="<%=ShowConfConnectorCableCompatForm.FALSE_STR%>">
			<script language="javascript">
				if ((parent.document.all['notNewCompatDivId']) && 
					(parent.document.all['newCompatDivId'])) {
					parent.document.all['notNewCompatDivId'].style.display = 'block'; 
					parent.document.all['newCompatDivId'].style.display = 'none';
				}
			</script>
		</logic:equal>

</july:editform>

<script language="javascript">
function onCompatClickRow(selectedID, isScroll, isRrequiredSet) {
}

function deletemResCompat(res1, res2) {
	if (! confirm("Внимание! Удаляется взаимосвязь разъема "+res1+" c кабелем "+res2+".\nПодтверждаете удаление?")) {
		return;
	}
	parent.document.all["isDeleteResCompat"].value=<%=ShowConfConnectorCableCompatForm.TRUE_STR%>;
	parent.document.all["selectedCompatRes1"].value=res1;
	parent.document.all["selectedCompatRes2"].value=res2;
	parent.ShowConfConnectorCableCompatForm.submit();
}
</script>

</BODY>
</HTML>
