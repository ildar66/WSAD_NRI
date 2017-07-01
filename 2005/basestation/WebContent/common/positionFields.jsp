<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld"    prefix="alex" %>

<%@ page import="org.apache.struts.util.*" %>
<%@ page import="com.hps.july.basestation.valueobject.*" %>
<%@ page import="com.hps.july.basestation.formbean.*" %>
<%@ page import="com.hps.july.jdbcpersistence.lib.DebugSupport" %>

<%----%>
<script language='javascript'>
function refreshPositionFields() {
	var lenLookup=document.all.lookupPosition.length;
	var lenAdd=document.all.addPosition.length;
	switchPosLookup(document.all.radioPositionAddId.checked);
	if(document.all.radioPositionLookupId.checked) {
		for(var i=0;i<lenLookup;i++) {
			document.all.lookupPosition[i].style.visibility='visible';
			document.all.lookupPosition[i].style.display='block';
		}
		for(var i=0;i<lenAdd;i++) {
			document.all.addPosition[i].style.visibility='hidden';
			document.all.addPosition[i].style.display='none';
		}
	} else if(document.all.radioPositionAddId.checked) {
		for(var i=0;i<lenLookup;i++) {
			document.all.lookupPosition[i].style.visibility='hidden';
			document.all.lookupPosition[i].style.display='none';
		}
		for(var i=0;i<lenAdd;i++) {
			document.all.addPosition[i].style.visibility='visible';
			document.all.addPosition[i].style.display='block';
		}
	} else {
		for(var i=0;i<lenLookup;i++) {
			document.all.lookupPosition[i].style.visibility='hidden';
			document.all.lookupPosition[i].style.display='none';
		}
		for(var i=0;i<lenAdd;i++) {
			document.all.addPosition[i].style.visibility='hidden';
			document.all.addPosition[i].style.display='none';
		}
	}
}
</script>
<%
EquipmentPForm bForm=(EquipmentPForm)request.getAttribute("EquipmentPForm");
if(bForm.isEditable("positionFields",request) && bForm.getPositionForm().isPlan() && bForm.getAction().equals("Add")) {
%>
<tr>
	<td class="text"></td>
	<td>
		<july:radio styleId="radioPositionAddId" property="radioPosition" value="<%=EquipmentPForm.POSITION_ADD%>" insertable="true" updatable="true" onclick="refreshPositionFields();"/>
		<bean:message key="PlanBaseStationForm.radioPosition.addPosition"/>
		&nbsp;&nbsp;&nbsp;
		<july:radio styleId="radioPositionLookupId" property="radioPosition" value="<%=EquipmentPForm.POSITION_LOOKUP%>" insertable="true" updatable="true" onclick="refreshPositionFields();"/>
		<bean:message key="PlanBaseStationForm.radioPosition.lookupPosition"/>
	</td>
</tr>
<%--@ include file="/common/positionInputFields.jsp"--%>

<jsp:include page="/common/positionInputFields.jsp" flush="true"/>

<%
}
%>

<jsp:include page="/common/positionLookupFields.jsp" flush="true"/>

<%
if(bForm.getPositionForm().isPlan()&&bForm.getAction().equals("Add")&&bForm.isEditable("positionFields",request)) {
%>
<script language="javascript">refreshPositionFields();</script>
<%
}
%>





