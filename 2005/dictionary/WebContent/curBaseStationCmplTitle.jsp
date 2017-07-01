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
	<title>Текущие комплекты базовых станций (шапка)</title> 
	<link rel="stylesheet" type="text/css" href="/main.css">
</head>

<BODY>

	<SCRIPT language=javascript src="/common/dialog.js" type="text/javascript"></SCRIPT>  
	<SCRIPT language=javascript src="/common/exitFromNRI.js" type="text/javascript"></SCRIPT>  

<july:editform action="/ShowConfBaseStation.do" styleId="ShowConfBaseStationForm">

	<table class="find" style='width:715px; table-layout: fixed;'> 
	<tr class="title">
		<% String fixWidth = "24"; %>
		<td style='width:<%=fixWidth%>px' align="center" class="title">
		
		<logic:equal name="ShowConfBaseStationForm" property="isAdminRole" value="<%=ShowConfBaseStationForm.TRUE_STR%>">
			<logic:equal name="ShowConfBaseStationForm" property="nostand" value="<%=ShowConfBaseStationForm.FALSE_STR%>">
				<A HREF="#"><IMG BORDER="0" SRC="/images/plus.gif" onclick='addConfBaseStation(); return false;'
												ALT='<bean:message key="button.add"/>'>
				</A>
			</logic:equal>
		</logic:equal>
		
		</td>
		<td style='width:<%=fixWidth%>px' align="center" class="title">K</td>

		<td style='width:<%=fixWidth%>px' align="center" class="title">A</td>
		<td style='width:<%=fixWidth%>px' align="center" class="title">B</td>
		<td style='width:<%=fixWidth%>px' align="center" class="title">C</td>
		<td style='width:<%=fixWidth%>px' align="center" class="title">D</td>
		<td style='width:55px' align="center" class="title">O1800</td>

		<td style='width:<%=fixWidth%>px' align="center" class="title">E</td>
		<td style='width:<%=fixWidth%>px' align="center" class="title">F</td>
		<td style='width:<%=fixWidth%>px' align="center" class="title">G</td>
		<td style='width:<%=fixWidth%>px' align="center" class="title">H</td>
		<td style='width:55px' align="center" class="title">O900</td>

		<td style='width:50px' align="center" class="title">Напр, В</td>
		<td style='width:100px' align="center" class="title">Код <br>НФС</td>
		<td style='width:268px' align="center" class="title">Наименование комплекта</td>
		<td style='width:<%=fixWidth%>px' align="center" class="title">&nbsp;</td>
	</tr>
	</table>
</july:editform>

<script language="javascript">
function addConfBaseStation() {
	var codenri = '<bean:write name="ShowConfBaseStationForm" property="searchStandParameValue" filter="true"/>';
	if (codenri.length > 0) {
		openDialog("EditBaseStationConf.do?action=<%=EditForm.ACTION_ADD%>"+"&codenri="+codenri,
					"editConfPowerForm", "top=160, left=220, width=784, height=550, scrollbars=auto, resizable=yes");
	} else {
		alert("Необходимо выбрать тип шкафа БС и произвести поиск конфигураций!");
	}
}
</script>

</BODY>

</HTML>