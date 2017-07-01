<%@ page import="com.hps.july.jdbcpersistence.lib.AppConstants"%>
<%@ page import="com.hps.july.jdbcpersistence.lib.Checks"%>
<%@ page import="com.hps.july.basestation.formbean.EquipmentPForm"%>
<%@ page import="com.hps.july.basestation.formbean.SwitchForm"%>
<%@ page import="com.hps.july.constants.Applications"%>
<%@ page import="com.hps.july.apptags.HasAccessTag"%>
<%@ page import="com.hps.july.web.util.*"%>

<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld" prefix="alex" %>

<%
	int gColSpan=7;
	boolean isFromSiteinfo=ParamsParser.getRootApp(pageContext)==Applications.SITEINFO;
	boolean showControllerLink = false;

	EquipmentPForm eForm=(EquipmentPForm)request.getAttribute("EquipmentPForm");

	String siteDocUrl=AppConstants.BASE_SITEDOC
		+"/ShowSiteDocList.do?appHome="+ParamsParser.getRootApp(pageContext)
		+"&objectId="+eForm.getStorageplace()
		+"&objectType=Switch&canModify="+HasAccessTag.hasAccess(pageContext,"/EditFactSwitch.do")
		+"&searchBy=O";

	if(eForm instanceof SwitchForm) {
		SwitchForm sf = (SwitchForm)eForm;
		if(Checks.SWITCH_TYPE_Gsm.equals(sf.getSwitchType())) {
			showControllerLink = true;
		}
	}
%>

<tr>

<td class="text"><bean:message key="label.position.actions"/>:</td>

<td class="text" colspan="<%=gColSpan-1%>" >

<% if(!eForm.getPositionForm().isPlan()) { %>

<%--экспл. х-ки--%>
<alex:hasAccess href="/EditViewFactSwitchDesc.do" >
	<july:link page="/EditViewFactSwitchDesc.do?action=View" paramId="equipment" paramName="EquipmentPForm" paramProperty="storageplace" >
		<nobr><bean:message key="menu.switchdesc"/></nobr>
	</july:link>&nbsp;
</alex:hasAccess>

<%--оборудование--%>
<% if(!isFromSiteinfo) { %>
<alex:hasAccess href="/ShowEquipdetList.do" >
	<july:link page="/ShowEquipdetList.do" paramId="storageplace" paramName="EquipmentPForm" paramProperty="storageplace" >
		<nobr><bean:message key="link.equipment"/></nobr>
	</july:link>&nbsp;
</alex:hasAccess>
<% } %>

<%--документы--%>
<july:link href="<%=siteDocUrl%>"  >
	<nobr><bean:message key="link.documents"/></nobr>
</july:link>
<br>

<%--список контроллеров--%>
<% if(showControllerLink) { %>
<july:link page="/ShowSwitchControllersList.do" paramId="switchId" paramName="EquipmentPForm" paramProperty="storageplace">
	<nobr><bean:message key="menu.switchcontrollers"/></nobr>
</july:link>&nbsp;
<% } %>

<% } %>



</td>
</tr>