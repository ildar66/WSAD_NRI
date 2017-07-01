<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import="org.apache.struts.util.*"%>

<tr>
	<td class="text"><bean:message key="label.swd.positionname"/>:</td>
	<td class="text">
		<bean:write name="SwitchDescForm" property="positionname" filter="true"/>
	</td>
</tr>
<tr>
	<td class="text" style="padding-left:16px;"><bean:message key="label.swd.regionname"/>:</td>
	<td class="text">
		<bean:write name="SwitchDescForm" property="regionname" filter="true"/>
	</td>
</tr>
<tr>
	<td class="text" style="padding-left:16px;"><bean:message key="label.swd.zonename"/>:</td>
	<td class="text">
		<bean:write name="SwitchDescForm" property="zonename" filter="true"/>
	</td>
</tr>
<tr>
	<td class="text" style="padding-left:16px;"><bean:message key="label.swd.address"/>:</td>
	<td class="text">
		<bean:write name="SwitchDescForm" property="address" filter="true"/>
	</td>
</tr>
<tr>
	<td class="text"><bean:message key="label.swd.switchname"/>:</td>
	<td class="text">
		<bean:write name="SwitchDescForm" property="switchname" filter="true"/>
	</td>
</tr>
