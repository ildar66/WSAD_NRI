<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld" prefix="alex" %>

<% String gColSpan = request.getAttribute("colspan") + ""; %>

<tr class="normal">
<td colspan="<%= gColSpan %>">
	<table class="find">
	<tr>
		<td class="text"><bean:message key="SwitchForm.position"/>:</td>
		<td class="text"><bean:write name="ControllerBaseStationsList" property="positionname" filter="true"/></td>
	</tr>
	<tr>
		<td class="text" style="padding-left:16px;"><bean:message key="label.position.region"/>:</td>
		<td class="text"><bean:write name="ControllerBaseStationsList" property="regionname" filter="true"/></td>
	</tr>
	<tr>
		<td class="text" style="padding-left:16px;"><bean:message key="controllerlist.table.netzone"/>:</td>
		<td class="text"><bean:write name="ControllerBaseStationsList" property="zonename" filter="true"/></td>
	</tr>
	<tr>
		<td class="text" style="padding-left:16px;"><bean:message key="Position.address"/>:</td>
		<td class="text"><bean:write name="ControllerBaseStationsList" property="address" filter="true"/></td>
	</tr>
	<tr>
		<td class="text"><bean:message key="controller.addinfo.controller"/>:</td>
		<td class="text"><bean:write name="ControllerBaseStationsList" property="controllername" filter="true"/></td>
	</tr>
	</table>
</td>
</tr>