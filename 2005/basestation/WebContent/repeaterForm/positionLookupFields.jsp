<%@ page import="com.hps.july.basestation.*" %>
<%@ page import="com.hps.july.basestation.formbean.EquipmentPForm" %>
<%@ page import="com.hps.july.jdbcpersistence.lib.Checks" %>
<%@ page import="com.hps.july.jdbcpersistence.lib.DebugSupport" %>
<%@ page import="com.hps.july.web.util.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld"    prefix="alex" %>

<script language='javascript'>
function switchPosLookup(isDis){
	document.all.poscodeId.disabled=isDis;
	document.all.posnameId.disabled=isDis;
	document.all.regionnameId.disabled=isDis;
	document.all.zonenameId.disabled=isDis;
	document.all.addrId.readOnly=isDis;
	document.all.latitudeId.disabled=isDis;
	document.all.longitudeId.disabled=isDis;
}
</script>

<%
	EquipmentPForm form1=(EquipmentPForm)request.getAttribute("EquipmentPForm");

	try {
		System.out.println("Form.State:"+ParamsParser.getRootApp(pageContext));
	} catch(Throwable t) {
		t.printStackTrace(System.out);
	}

	System.out.println("Form:"+form1);
	String url="/ShowPositionLookupList.do";

///
/// Move to FromSectorRepeaterForm.java
///
	String editable=form1.editable("positionFields",request);
	if (ParamsParser.getState(pageContext) == APPStates.FROMSECTOR_REPEATER_EDIT) {
		editable = "true";
	} else if (ParamsParser.getState(pageContext) == APPStates.REPEATER_EDIT) {
		;
	}
///
/// End move
///
//System.out.println("Form.Editable:"+editable);
//	DebugSupport.printlnTest("!!positionLookupFields.jsp editable="+editable);
//	DebugSupport.printlnTest("!!positionLookupFields.jsp url="+url);
%>

<tr id="lookupPosition" style='visibility:visible;display:block'>
	<td class="text"><july:reqmark><bean:message key="label.equipment.posname"/>:</july:reqmark></td>
	<td class="text">
		<html:hidden property="positionModel.keyFrm" styleId="poscodeId" />
		<july:string size="35" property="positionModel.fullName" styleId="posnameId" insertable="false" updatable="false" />
		<july:lookupbutton formname="EquipmentPForm" action="<%=url%>" styleId="posl" fieldNames="poscodeId;posnameId;supregnameId;regionnameId;zonenameId;addrId;latitudeId;longitudeId;datebeginbuildId;bsDampsNumId;bsGsmNumId;bsDampsNameId;bsGsmNameId" newWindowName="poslookup" insertable="<%=editable%>" updatable="<%=editable%>"/>
		<input type='hidden' name='datebeginbuild' id='datebeginbuildId' value=''>
		<input type='hidden' name='supregname' id='supregnameId' value=''>
		<input type='hidden' name='bsDampsNum' id='bsDampsNumId' value=''>
		<input type='hidden' name='bsGsmNum' id='bsGsmNumId' value=''>
		<input type='hidden' name='bsDampsName' id='bsDampsNameId' value=''>
		<input type='hidden' name='bsGsmName' id='bsGsmNameId' value=''>
	</td>
</tr>

<tr id="lookupPosition" style='visibility:visible;display:block'>
	<td class="text">&nbsp;&nbsp;&nbsp;<bean:message key="label.position.region"/> / <bean:message key="label.baseStationList.netzone"/>:</td>
	<td class="text">
		<july:string property="positionModel.regionname" styleId="regionnameId" size="20" insertable="false" updatable="false" /> / 
		<july:string property="positionModel.netzonename" styleId="zonenameId" size="20" insertable="false" updatable="false" />
	</td>
</tr>

<tr id='lookupPosition' style='visibility:visible;display:block'>
	<td class="text" valign="top">&nbsp;&nbsp;&nbsp;<bean:message key="SwitchForm.address"/>:</td>
	<td class="text"><july:textarea styleId="addrId" property="positionModel.address" cols="50" rows="2" insertable='false' updatable='false'/></td>
</tr>

<tr id="lookupPosition" style='visibility:visible;display:block'>
	<td class="text">&nbsp;&nbsp;&nbsp;<bean:message key="Position.coords"/>:</td>
	<td class="text">
		<bean:message key="Position.clatitude"/>:
		<july:string property="positionModel.latitudeFrm" styleId="latitudeId" size="10" insertable="false" updatable="false" />&nbsp;
		<bean:message key="Position.longitude"/>:
		<july:string property="positionModel.longitudeFrm" styleId="longitudeId" size="10" insertable="false" updatable="false" />
	</td>
</tr>
