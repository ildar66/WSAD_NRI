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
	<title>Текущие комплекты источников питания (шапка)</title> 
	<link rel="stylesheet" type="text/css" href="/main.css">
</head>

<BODY>

	<SCRIPT language=javascript src="/common/dialog.js" type="text/javascript"></SCRIPT>  
	<SCRIPT language=javascript src="/common/exitFromNRI.js" type="text/javascript"></SCRIPT>  

<%
	// проверяем в каком режиме вызвана страница
	String action = ConfPowerSourcesForm.getActionString(session);
	String form = ConfPowerSourcesForm.getFormString(session); 
	boolean isElAp = ConfPowerSourcesForm.getIsElAp(session); 
	boolean isUzo = ConfPowerSourcesForm.getIsUzo(session); 
	boolean isIKBS = ConfPowerSourcesForm.getIsIkBs(session); 
%> 
<july:editform action="<%=action%>" styleId="<%=form%>">

	<table class="find" width="715" style='table-layout: fixed;'> 
	<tr class="title">
		<td width = "27" align="center" class="title">

		<logic:equal name="<%=form%>" property="isAdminRole" value="<%=ConfPowerSourcesForm.TRUE_STR%>">
		<A HREF="#"><IMG BORDER="0" SRC="/images/plus.gif" onclick='addConfPowerSources(); return false;'
											ALT='<bean:message key="button.add"/>'>
		</A>
		</logic:equal>

		</td>
		<td width = "93" align="center" class="title">Код комплекта</td>
		<td width = "115" align="center" class="title">Код НФС</td>
		<% if (isElAp) { %>
		<td width = "345" align="center" class="title">Наименование комплекта</td>
		<td width = "93" align="center" class="title">Мощность, кВт</td>
		<% } else if (isUzo || isIKBS) { %>
		<td width = "438" align="center" class="title">Наименование комплекта</td>
		<% } %>
		<td width = "27" align="center" class="title">&nbsp;</td>
	</tr>
	</table>
</july:editform>
	
<script language="javascript">
function addConfPowerSources() {
	openDialog("EditConfPowerSources.do?action=<%=EditForm.ACTION_ADD%>",
	 "addConfPowerForm", "top=0, left=0, width=1000, height=350, scrollbars=auto, resizable=yes");
}
</script>

</BODY>

</HTML>