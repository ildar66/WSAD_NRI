<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import = "com.hps.july.dictionary.formbean.*, com.hps.july.web.util.* "%>

<head>
	<META HTTP-EQUIV = "Pragma" CONTENT="no-cache"> 
	<title>Состав комплекта источника питания (шапка)</title> 
	<link rel="stylesheet" type="text/css" href="/main.css">
</head>

<body>

<SCRIPT language=javascript src="/common/dialog.js" type="text/javascript"></SCRIPT>  
<SCRIPT language=javascript src="/common/exitFromNRI.js" type="text/javascript"></SCRIPT>  
<%
	// проверяем в каком режиме вызвана страница
	String action = ConfPowerSourcesForm.getActionString(session);
	String form = ConfPowerSourcesForm.getFormString(session); 
	boolean isElAp = ConfPowerSourcesForm.getIsElAp(session); 
	boolean isUzo = ConfPowerSourcesForm.getIsUzo(session); 
	boolean isIKBS = ConfPowerSourcesForm.getIsIkBs(session); 
	int nameWd = 256;
	if (isIKBS) {
		nameWd = nameWd + 64;
	}
%> 
<july:editform action="<%=action%>" styleId="<%=form%>" target="strucIFrame">

	<html:hidden property="curComplectSelectedID"/>
	<html:hidden property="submitMode" value="<%=ConfPowerSourcesForm.CUR_COMPLECT_SUBMIT_MODE%>"/>

	<table class="find" width="715" style='table-layout: fixed;'> 
	<tr class="title">
		<td width = "27" align="center" class="title">
		<logic:equal name="<%=form%>" property="isAdminRole" value="<%=ConfPowerSourcesForm.TRUE_STR%>">
			<logic:equal name="<%=form%>" property="isCurComplectListExist" value="<%=ConfPowerSourcesForm.TRUE_STR%>">
				<A HREF="#"><IMG BORDER="0" SRC="/images/plus.gif" onclick='addResource(); return false;'
												ALT='<bean:message key="button.add"/>'>
				</A>
			</logic:equal>
		</logic:equal>
		</td>
		<td width = "72" align="center" class="title">Код NRI</td>
		<td width = "<%=nameWd%>" align="center" class="title">Наименование ресурса</td>
		<% if (isElAp || isUzo) { %>
			<td width = "251" align="center" class="title">Модель</td>
			<td width = "67" align="center" class="title">Кол-во, шт</td>
		<% } else { %>
		<td width = "67" height="34" align="center" class="title">Кол-во</td>
		<% } %>
		<% if (isIKBS) { %>
			<td width = "72" align="center" class="title">Ед. изм.</td>
			<td width = "115" align="center" class="title">Код НФС</td>
		<% } %>
		<td width = "27" align="center" class="title">&nbsp;</td>
	</tr>

	</table>
</july:editform>
	
<script language="javascript">

function addResource(addResource) {
	// alert("addResource");
	var resourceSet = document.all['curComplectSelectedID'].value;
	openDialog("EditPowerResource.do?action=<%=EditForm.ACTION_ADD%>&resourceSet="+resourceSet+"&unitInt="+<%=(isElAp || isUzo)%>,
	"addPowerResourceForm", "top=0, left=0, width=1000, height=350, scrollbars=auto, resizable=yes");
}											

</script>	
</body>
