<%@ page import="org.apache.struts.util.*,com.hps.july.siteinfo.valueobject.*" %>
<%@ page import="com.hps.july.basestation.formbean.*" %>

<%--@ include file="/factBaseStationForm/positionLookupFields.jsp"--%>
<%
	String url="/ShowPositionLookupList.do";
	FactBaseStationForm bsForm=(FactBaseStationForm)pageContext.findAttribute("FactBaseStationForm");
	String poseditable = bsForm.editable("positionFields",pageContext);
	String stationTypeEditable = bsForm.editable("stationType",pageContext);
	boolean showDampsType = true;
	boolean showGsmType = true;
	if("Edit".equals(bsForm.getAction())) {
		if(bsForm.getStationType() == null) {
			stationTypeEditable = "false";
		} else if(BaseStationObject.TYPE_CHECK_DAMPS_D.equals(bsForm.getStationType())) {
			showGsmType = false;
//			stationTypeEditable = "false";
		} else {
			showDampsType = false;
			stationTypeEditable = "true";
		}
	}
%>

<tr id="lookupPosition" style='visibility:visible;display:block'>
	<td class="text"><july:reqmark><bean:message key="label.equipment.posname"/></july:reqmark></td>
	<td>
		<july:string property="positionForm.storageplaceFrm" styleId="poscodeId" size="5" insertable='false' updatable='false' />
		<july:lookupbutton action="<%=url%>" styleId="posl" fieldNames="poscodeId;posnameId;supregnameId;regionnameId;zonenameId;addressId;latitudeId;longitudeId;datebeginbuildId;bsDampsNumId;bsGsmNumId;bsDampsNameId;bsGsmNameId" newWindowName="poslookup" insertable='<%=poseditable%>' updatable='<%=poseditable%>'/>
		<july:string size="25" property="positionForm.fullName" styleId="posnameId" insertable="false" updatable="false" />
		<input type='hidden' name='bsDampsNum' id='bsDampsNumId'   value=''>
		<input type='hidden' name='bsGsmNum' id='bsGsmNumId'  value=''>
		<input type='hidden' name='bsDampsName' id='bsDampsNameId'  value=''>
		<input type='hidden' name='bsGsmName' id='bsGsmNameId'  value=''>
	</td>
</tr>
<tr id="lookupPosition" style='visibility:visible;display:block'>
	<td class="text"><bean:message key="Position.supreg"/>:</td>
	<td>
		&nbsp;&nbsp;&nbsp;<july:string property="positionForm.supregname" styleId="supregnameId" size="25" insertable="false" updatable="false" />
	</td>
</tr>
<tr id="lookupPosition" style='visibility:visible;display:block'>
	<td class="text"><bean:message key="Position.region"/>:</td>
	<td>
		&nbsp;&nbsp;&nbsp;<july:string property="positionForm.regname" styleId="regionnameId" size="25" insertable="false" updatable="false" />
	</td>
</tr>
<tr id="lookupPosition" style='visibility:visible;display:block'>
	<td class="text"><bean:message key="Position.netzonecode"/>:</td>
	<td>
		&nbsp;&nbsp;&nbsp;<july:string property="positionForm.zonename" styleId="zonenameId" size="25" insertable="false" updatable="false" />
	</td>
</tr>
<tr id="lookupPosition" style='visibility:visible;display:block'>
	<td class="text"><bean:message key="Position.address"/>:</td>
	<td>
		&nbsp;&nbsp;&nbsp;<july:string property="positionForm.address" styleId="addressId" size="50" insertable="false" updatable="false" />
	</td>
</tr>
<tr id="lookupPosition" style='visibility:visible;display:block'>
	<td class="text"><bean:message key="Position.latitude"/>:</td>
	<td>
		&nbsp;&nbsp;&nbsp;<july:string property="positionForm.latitudeFrm" styleId="latitudeId" size="10" insertable="false" updatable="false" />
		&nbsp;&nbsp;<bean:message key="Position.longitude"/>:
		<july:string property="positionForm.longitudeFrm" styleId="longitudeId" size="10" insertable="false" updatable="false" />
	</td>
</tr>
<tr id="lookupPosition" style='visibility:visible;display:block'>
	<td class="text"><bean:message key="Position.datebeginbuild"/>:</td>
	<td>
		&nbsp;&nbsp;&nbsp;<july:date property="positionForm.datebeginbuildFrm" required="false" styleId="datebeginbuildId" size="25" insertable="false" updatable="false" />
	</td>
</tr>
<july:separator/>
<tr>
	<td class="text"><july:reqmark><bean:message key="BaseStation.stationType"/>:</july:reqmark></td>
	<td>
		<july:select property="stationType" styleId="stationTypeId" insertable='<%=stationTypeEditable%>' updatable='<%=stationTypeEditable%>' onchange="initBaseStation();switch_(document.all.stationTypeId.value);checkStationType(document.all.stationTypeId.value);">
			<% if(showGsmType && showDampsType) { %>
			<html:option key="label.empty" value=""/>
			<% } %>
			<% if(showGsmType) { %>
			<html:option key="BaseStation.stationType.S" value="<%=BaseStationObject.TYPE_CHECK_GSM_S%>"/>
			<html:option key="BaseStation.stationType.C" value="<%=BaseStationObject.TYPE_CHECK_DCS_C%>"/>
			<html:option key="BaseStation.stationType.G" value="<%=BaseStationObject.TYPE_CHECK_GSM_G%>"/>
			<% } %>
			<% if(showDampsType) { %>
			<html:option key="BaseStation.stationType.D" value="<%=BaseStationObject.TYPE_CHECK_DAMPS_D%>"/>
			<% } %>
		</july:select>
	</td>
</tr>
<script language=javascript>
count=0;
function initBaseStation() {
	if(document.all.action.value == 'Add') {
		if(count>0) return;
		if(document.all.stationTypeId.value=="<%=BaseStationObject.TYPE_CHECK_DAMPS_D%>") {
			document.all.numberFrmId.value=document.all.bsDampsNumId.value;
			document.all.stationNameId.value=document.all.bsDampsNameId.value;
		} else if(document.all.stationTypeId.value=="<%=BaseStationObject.TYPE_CHECK_GSM_G%>" || document.all.stationTypeId.value=="<%=BaseStationObject.TYPE_CHECK_GSM_S%>" || document.all.stationTypeId.value=="<%=BaseStationObject.TYPE_CHECK_DCS_C%>") {
			document.all.numberFrmId.value=document.all.bsGsmNumId.value;
			document.all.stationNameId.value=document.all.bsGsmNameId.value;
		}
		count++;
	}
}
function checkStationType(type) {
	if(document.all.action.value == 'Add' || document.all.action.value == 'Edit') {
	if(type=="<%=BaseStationObject.TYPE_CHECK_DAMPS_D%>"){
		switchController(true);
		switchSwitch(false);
	} else if(type=="<%=BaseStationObject.TYPE_CHECK_DCS_C%>"){
		switchController(false);
		switchSwitch(true);
	} else if(type=="<%=BaseStationObject.TYPE_CHECK_GSM_S%>") {
		switchController(false);
		switchSwitch(true);
	} else if(type=="<%=BaseStationObject.TYPE_CHECK_GSM_G%>") {
		switchController(false);
		switchSwitch(true);
	} else {
		switchController(true);
		switchSwitch(true);
	}
	}
}
</script>

<july:separator/>

<tr>
	<td class="text"><july:reqmark><bean:message key="BaseStation.number"/>:</july:reqmark></td>
	<td>
		<july:string property="numberFrm" styleId="numberFrmId" size="10" insertable="true" updatable="true" />
	</td>
</tr>
<tr>
	<td class="text"><july:reqmark><bean:message key="BaseStation.stationName"/>:</july:reqmark></td>
	<td>
		<july:string property="stationName" styleId="stationNameId" size="50" insertable="true" updatable="true" />
	</td>
</tr>

<july:separator/>
<%@ include file="/factBaseStationForm/controllerFields.jsp"%>
<july:separator/>
<%@ include file="/factBaseStationForm/switchFields.jsp"%>
<july:separator/>
<tr>
	<td class="text"><bean:message key="BaseStation.repeater"/>:</td>
	<td>
		<july:checkbox property="repeater" insertable="true" updatable="true" />
	</td>
</tr>
<july:separator/>
<tr>
	<td class="text"><bean:message key="BaseStation.contype"/>:</td>
	<td>
		<alex:select property="contype" insertable="true" updatable="true" styleClass="editsmall">
			<html:option key="BaseStation.contype.R" value="<%=BaseStationObject.CONTYPE_CHECK_RADIO%>"/>
			<html:option key="BaseStation.contype.O" value="<%=BaseStationObject.CONTYPE_CHECK_OPTIC%>"/>
		</alex:select>
		&nbsp;&nbsp;&nbsp;
		<bean:message key="BaseStation.e1qty"/>:
		&nbsp;
		<july:string property="e1qtyFrm" size="5" insertable="true" updatable="true" />
	</td>
</tr>
<july:separator/>
<tr>
	<td class="text"><bean:message key="BaseStationForm.nstoek"/>:</td>
	<td>
		<july:string property="nstoekFrm" size="5" insertable="true" updatable="true" />
	</td>
</tr>
<july:separator/>
<tr>
	<td class="text"><bean:message key="BaseStation.timebackup"/>:</td>
	<td>
		<july:string property="timebackup" size="5" insertable="true" updatable="true" />
		&nbsp;&nbsp;&nbsp;
		<bean:message key="BaseStation.pwrval"/>:
		&nbsp;
		<july:string property="pwrvalFrm" size="5" insertable="true" updatable="true" />
	</td>
</tr>
<july:separator/>
<tr>
	<td class="text"><bean:message key="BaseStation.pwrcat"/>:</td>
	<td>
		<july:string property="pwrcat" size="50" insertable="true" updatable="true" />
	</td>
</tr>
<july:separator/>
<%@ include file="/factBaseStationForm/dateFields.jsp"%>
<july:separator/>

<logic:notEqual name="FactBaseStationForm" property="action" value="View">
<tr>
	<td class="text"><july:reqmark><bean:message key="BaseStation.equipmentState"/>:</july:reqmark></td>
	<td>
		<alex:select property="equipmentState" styleId="equipmentStateId"   insertable="true" updatable="true" >
			<html:option key="BaseStation.equipmentState.M" value="<%=BaseStationObject.STATE_CHECK_MOUNT_M%>"/>
			<html:option key="BaseStation.equipmentState.P" value="<%=BaseStationObject.STATE_CHECK_PLAN_P%>"/>
			<html:option key="BaseStation.equipmentState.R" value="<%=BaseStationObject.STATE_CHECK_READY_R%>"/>
			<html:option key="BaseStation.equipmentState.T" value="<%=BaseStationObject.STATE_CHECK_TEST_T%>"/>
			<html:option key="BaseStation.equipmentState.W" value="<%=BaseStationObject.STATE_CHECK_WORK_W%>"/>
			<html:option key="BaseStation.equipmentState.D" value="<%=BaseStationObject.STATE_CHECK_DEMOUNT_D%>"/>
		</alex:select>
	</td>
</tr>
<tr>
	<td class="text"><bean:message key="BaseStation.onair"/></td>
	<td>
		<july:radio styleId="onair" property="onair" value="<%=BaseStationObject.ONAIR_CHECK_Y%>" insertable="true" updatable="true" />
		<bean:message key="BaseStation.onair.Y"/>&nbsp;
		<july:radio styleId="onair" property="onair" value="<%=BaseStationObject.ONAIR_CHECK_N%>" insertable="true" updatable="true" />
		<bean:message key="BaseStation.onair.N"/>
	</td>
</tr>
</logic:notEqual>
<logic:equal name="FactBaseStationForm" property="action" value="View">
<tr>
	<td class="text"><july:reqmark><bean:message key="BaseStation.equipmentState"/>:</july:reqmark></td>
	<td>
		<logic:equal name="FactBaseStationForm" property="equipmentState" value="<%=BaseStationObject.STATE_CHECK_MOUNT_M%>">
			<bean:message key="BaseStation.equipmentState.M" />
		</logic:equal>
		<logic:equal name="FactBaseStationForm" property="equipmentState" value="<%=BaseStationObject.STATE_CHECK_PLAN_P%>">
			<bean:message key="BaseStation.equipmentState.P" />
		</logic:equal>
		<logic:equal name="FactBaseStationForm" property="equipmentState" value="<%=BaseStationObject.STATE_CHECK_READY_R%>">
			<bean:message key="BaseStation.equipmentState.R" />
		</logic:equal>
		<logic:equal name="FactBaseStationForm" property="equipmentState" value="<%=BaseStationObject.STATE_CHECK_TEST_T%>">
			<bean:message key="BaseStation.equipmentState.T" />
		</logic:equal>
		<logic:equal name="FactBaseStationForm" property="equipmentState" value="<%=BaseStationObject.STATE_CHECK_WORK_W%>">
			<bean:message key="BaseStation.equipmentState.W" />
		</logic:equal>
		<logic:equal name="FactBaseStationForm" property="equipmentState" value="<%=BaseStationObject.STATE_CHECK_DEMOUNT_D%>">
			<bean:message key="BaseStation.equipmentState.D" />
		</logic:equal>
		&nbsp;&nbsp;
		<logic:equal name="FactBaseStationForm" property="onair" value="<%=BaseStationObject.ONAIR_CHECK_Y%>">
			<bean:message key="BaseStation.onair.Y"/>
		</logic:equal>
		<logic:notEqual name="FactBaseStationForm" property="onair" value="<%=BaseStationObject.ONAIR_CHECK_Y%>">
			<bean:message key="BaseStation.onair.N"/>
		</logic:notEqual>
	</td>
</tr>
</logic:equal>
<tr>
	<td class="text"><bean:message key="label.comment"/>:</td>
	<td>
		<july:textarea property="equipcomment" cols="50" rows="2" insertable='true' updatable='true' />
	</td>
</tr>