<%@ page import="com.hps.july.jdbcpersistence.lib.Checks"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<tr>
	<td class="text"><july:reqmark><bean:message key="SwitchForm.equipmentState"/>:</july:reqmark></td>
	<td class='text'>
		<july:select property="equipmentState" styleId="equipmentStateId" insertable="true" updatable="true" >
			<html:option key="BaseStation.equipmentState.M" value="M"/>
			<html:option key="BaseStation.equipmentState.P" value="P"/>
			<html:option key="BaseStation.equipmentState.W" value="W"/>
			<html:option key="BaseStation.equipmentState.D" value="D"/>
		</july:select>
	</td>
</tr>