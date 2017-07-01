<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld" prefix="alex" %>


<tr>
	<td class="text" width="30%"><bean:message key="SwitchForm.position"/>:</td>
	<td class="text" width="70%"><bean:write name="ControllerDescForm" property="positionname" filter="true"/></td>
</tr>

<tr>
	<td class="text" style="padding-left:16px;"><bean:message key="label.position.region"/> / <bean:message key="controllerlist.table.netzone"/>:</td>
	<td class="text"><bean:write name="ControllerDescForm" property="regionname" filter="true"/> / <bean:write name="ControllerDescForm" property="zonename" filter="true"/></td>
</tr>

<tr>
	<td class="text" style="padding-left:16px;"><bean:message key="Position.address"/>:</td>
	<td class="text"><bean:write name="ControllerDescForm" property="address" filter="true"/></td>
</tr>

<tr>
	<td class="text"><bean:message key="controller.addinfo.controller"/>:</td>
	<td class="text"><bean:write name="ControllerDescForm" property="controllername" filter="true"/></td>
</tr>
