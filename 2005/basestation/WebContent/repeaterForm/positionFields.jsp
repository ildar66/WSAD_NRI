<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld" prefix="alex" %>
<%@ page import="org.apache.struts.util.*,com.hps.july.basestation.valueobject.*"%>
<%@ page import="com.hps.july.basestation.formbean.*,com.hps.july.jdbcpersistence.lib.DebugSupport"%>

<%
	// get EquipmentPForm and change names to it
%>

<tr>
	<td class="text"><bean:message key="label.equipment.posname"/>:</td>
	<td class="text">
		<bean:write name="EquipmentPForm" property="positionModel.keyFrm" filter="true" scope="request"/>
		<bean:write name="EquipmentPForm" property="positionModel.fullName" filter="true" scope="request"/>
	</td>
</tr>

<tr>
	<td class="text"><bean:message key="label.repeaterform.latitude"/>:</td>
	<td class="text">
		<bean:write name="EquipmentPForm" property="positionModel.latitudeFrm" filter="true" scope="request"/>&nbsp;
		<bean:message key="label.repeaterform.longitude"/>:&nbsp;
		<bean:write name="EquipmentPForm" property="positionModel.longitudeFrm" filter="true" scope="request"/>
	</td>
</tr>

<tr>
	<td class="text"><bean:message key="SwitchForm.address"/>:</td>
	<td class="text"><bean:write name="EquipmentPForm" property="positionModel.address" filter="true"/></td>
</tr>

<tr>
	<td class="text"><bean:message key="label.baseStationList.netzone"/>:</td>
	<td class="text"><bean:write name="EquipmentPForm" property="positionModel.netzonename" filter="true"/></td>
</tr>

<tr>
	<td class="text"><bean:message key="label.position.region"/>:</td>
	<td class="text"><bean:write name="EquipmentPForm" property="positionModel.regname" filter="true"/></td>
</tr>

<tr>
	<td class="text"><bean:message key="label.replist.number"/>:</td>
	<td class="text"><bean:write name="FromSectorRepeaterList" property="number" filter="true"/></td>
</tr>

<tr>
	<td class="text"><bean:message key="label.replist.name"/>:</td>
	<td class="text"><bean:write name="FromSectorRepeaterList" property="name" filter="true"/></td>
</tr>

<tr>
	<td class="text"><bean:message key="label.replist.type"/>:</td>
	<td class="text">
		<logic:equal name="FromSectorRepeaterList" property="type" value="D"><bean:message key="label.equipment.stationdamps"/></logic:equal>
		<logic:equal name="FromSectorRepeaterList" property="type" value="S"><bean:message key="label.equipment.stationgsm"/></logic:equal>
		<logic:equal name="FromSectorRepeaterList" property="type" value="C"><bean:message key="label.equipment.stationdcs"/></logic:equal>
		<logic:equal name="FromSectorRepeaterList" property="type" value="G"><bean:message key="label.equipment.stationboth"/></logic:equal>
	</td>
</tr>

<tr>
	<td class="text"><bean:message key="label.replist.donor.number"/>:</td>
	<td class="text"><bean:write name="FromSectorRepeaterList" property="donornumber" filter="true"/></td>
</tr>

<tr>
	<td class="text"><bean:message key="label.replist.donor.name"/>:</td>
	<td class="text"><bean:write name="FromSectorRepeaterList" property="donorname" filter="true"/></td>
</tr>
