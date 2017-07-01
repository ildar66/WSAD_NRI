<%@ page import="com.hps.july.jdbcpersistence.lib.AppConstants"%>
<%@ page import="com.hps.july.basestation.formbean.EquipmentPForm"%>
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
	int gColSpan = 7;
	boolean isFromSiteinfo=ParamsParser.getRootApp(pageContext)==Applications.SITEINFO;
	EquipmentPForm eForm = (EquipmentPForm) request.getAttribute("EquipmentPForm");
	String siteDocUrl = AppConstants.BASE_SITEDOC + "/ShowSiteDocList.do?appHome="
		+ ParamsParser.getRootApp(pageContext)+"&objectId=" + eForm.getStorageplace()
		+"&objectType=Controller&canModify="+HasAccessTag.hasAccess(pageContext,"/EditFactController.do")
		+"&searchBy=O";
%>

<tr>
	<td class="text"><bean:message key="label.position.actions"/>:</td>
	<td class="text" colspan="<%= gColSpan - 1 %>">
		<alex:hasAccess href="/EditViewFactControllerDesc.do">
			<july:link page="/EditViewFactControllerDesc.do?action=View" paramId="controllercode" paramName="EquipmentPForm" paramProperty="storageplace">
				<bean:message key="controller.expproperties"/>
			</july:link>
		</alex:hasAccess>

		
		<%	if (!isFromSiteinfo) { %>
			<alex:hasAccess href="/ShowEquipdetList.do">
				<july:link href="/siteinfo/ShowEquipdetList.do" paramId="storageplace" paramName="EquipmentPForm" paramProperty="storageplace">
					<bean:message key="link.equipment"/>
				</july:link>
			</alex:hasAccess>
		<%	} %>
		
		<%--документы--%>
		<script>
		<!--
			function showTerrabyteWin() {
				var terrabyteWin = window.open("<%=com.hps.july.util.AppUtils.getNamedValueString("TerrabyteURL")%>?type=equipment&id=<%=eForm.getStorageplace()%>&uid=<%=request.getRemoteUser()%>", "terrabyteWin", "top=60, left=60, height=" + (screen.availHeight-150) + ", width=" + (screen.availWidth-150) + ", fullscreen=no,location=no,menubar=no,resizable=yes,scrollbars=yes,status=no,titlebar=yes,toolbar=no");
				if(terrabyteWin) terrabyteWin.focus();
			}
		-->
		</script>
		<a href="#" onclick="showTerrabyteWin();"><nobr><bean:message key="link.documents"/></nobr></a>
		<%-- july:link href="<%= siteDocUrl %>"><bean:message key="link.documents"/></july:link --%><br>

		<alex:hasAccess href="/ShowControllerBaseStationsList.do">
			<july:link page="/ShowControllerBaseStationsList.do" paramId="contrNumberFrm" paramName="EquipmentPForm" paramProperty="number">
				<bean:message key="controller.bsconnected"/>
			</july:link>
		</alex:hasAccess>
	</td>
</tr>
