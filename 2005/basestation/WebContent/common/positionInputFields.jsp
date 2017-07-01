<%@ page import="com.hps.july.basestation.formbean.PlanBaseStationForm"%>
<%@ page import="com.hps.july.basestation.formbean.EquipmentPForm"%>
<%@ page import="com.hps.july.jdbcpersistence.lib.Checks"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld" prefix="alex" %>

<%
	EquipmentPForm form1=(EquipmentPForm)request.getAttribute("EquipmentPForm");
	//String editable=form1.editable("positionFields",request);
	String editable="true";
%>

<tr id='addPosition' style='visibility:visible;display:block'>
	<td class="text"><july:reqmark><bean:message key="label.position.name"/>:</july:reqmark></td>
	<td>
		<july:string property="positionForm.name" size="50" insertable='<%=editable%>' updatable='<%=editable%>' />
	</td>
</tr>
<tr id="addPosition"  style='visibility:visible;display:block'>
	<td class="text"><july:reqmark><bean:message key="label.position.regionname"/>:</july:reqmark></td>
	<td>
		<july:select collection="positionForm.regions" property="positionForm.regioncode" insertable='<%=editable%>' updatable='<%=editable%>'>
			<html:options collection="positionForm.regions" property="id" labelProperty="name"/>
		</july:select>
	</td>
</tr>
<tr id='addPosition' style='visibility:visible;display:block'>
	<td class="text"><july:reqmark><bean:message key="label.position.netzonename"/>:</july:reqmark></td>
	<td>
		<july:select collection="positionForm.netzones" property="positionForm.netzonecode" insertable='<%=editable%>' updatable='<%=editable%>'>
			<html:options collection="positionForm.netzones" property="netzone" labelProperty="name"/>
		</july:select>
	</td>
</tr>
<tr id='addPosition' style='visibility:visible;display:block'>
	<td class="text"><july:reqmark><bean:message key="label.position.addr"/>:</july:reqmark></td>
	<td>
		<july:textarea property="positionForm.address" cols="50" rows="2" insertable='<%=editable%>' updatable='<%=editable%>'/>
	</td>
</tr>
