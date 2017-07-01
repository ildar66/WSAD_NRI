<%@ page import="com.hps.july.basestation.formbean.FactBaseStationForm"%>
<%@ page import="com.hps.july.basestation.valueobject.BaseStationObject"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld"    prefix="alex" %>

<%
	FactBaseStationForm bForm=(FactBaseStationForm)pageContext.findAttribute("FactBaseStationForm");
	String edit=""+!(bForm.getAction().equals("Edit") && bForm.getStationType().equals(BaseStationObject.TYPE_CHECK_DAMPS_D));
%>

<tr>
	<td class="text"><bean:message key="label.equipment.controller"/>:</td>
	<td>
		<html:hidden property="controllerId"/>
		<july:string property="contrNumberFrm" styleId="contrnum" size="5" insertable="<%=edit%>" updatable="<%=edit%>" />
		<july:lookupbutton action="/ShowControllerLookupList.do" styleId="cntrl" fieldNames="contrnum;contrname;cposname;controllerId;switchId;switchnum;sposname" insertable="<%=edit%>" updatable="<%=edit%>" />
		<july:string size="25" property="contrname" styleId="contrname"  insertable="false" updatable="false" />
		<%--july:string size="25" property="contrposname" styleId="cposname"  insertable="false" updatable="false" /--%>
		<input type='hidden' name='contrposname' id='cposname'   value=''>
	</td>
</tr>
<script language="javascript">
function switchController(dis) {
	refreshLookup(dis,'contrnum','contrname','cntrl');
	document.all.controllerId.disabled = dis;
//	document.all.cposname.disabled = dis;
}
</script>
