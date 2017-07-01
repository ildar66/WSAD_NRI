<%@ page language = "java" %>
<%@ page contentType="TEXT/HTML; charset=windows-1251" %>
<%@ page import="com.hps.july.jdbcpersistence.lib.AppConstants"%>
<%@ page import="com.hps.july.jdbcpersistence.lib.Checks"%>
<%@ page import="com.hps.july.basestation.formbean.RepeaterForm"%>
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
	boolean isFromSiteinfo = ParamsParser.getRootApp(pageContext)==Applications.SITEINFO;//sm.getApp()==Applications.SITEINFO;
	RepeaterForm eForm=(RepeaterForm)request.getAttribute("EquipmentPForm");
	String siteDocUrl = AppConstants.BASE_SITEDOC+
		"/ShowSiteDocList.do?objectId="+eForm.getStorageplace()+
		"&objectType=Repiter&canModify="+HasAccessTag.hasAccess(pageContext,"/EditRepiter.do")+
		"&searchBy=O&appHome="+ParamsParser.getRootApp(pageContext);

	String donorBsUrl = "/Edit_ViewFactBaseStation.do?action=View&basestation="+eForm.getDonorbs().getKey();

%>
<tr>
	<td class="text"><bean:message key="label.position.actions"/>:</td>
	<td class="text" colspan="<%= gColSpan - 1 %>">
		<july:link page='<%="/EditFactRepeater.do?action=Edit&storageplace="+eForm.getStorageplace()%>'>Изменить</july:link>
		<% if (!isFromSiteinfo) { %>
		<alex:hasAccess href="/ShowEquipdetList.do">
			<july:link href="/siteinfo/ShowEquipdetList.do" paramId="storageplace" paramName="EquipmentPForm" paramProperty="storageplace">
				<bean:message key="link.equipment"/>
			</july:link>
		</alex:hasAccess>
		<% } %>
		<%-- ????????? --%>
		<script>
		<!--
			function showTerrabyteWin() {
				var terrabyteWin = window.open("<%=com.hps.july.util.AppUtils.getNamedValueString("TerrabyteURL")%>?type=equipment&id=<%=eForm.getStorageplace()%>&uid=<%=request.getRemoteUser()%>", "terrabyteWin", "top=60, left=60, height=" + (screen.availHeight-150) + ", width=" + (screen.availWidth-150) + ", fullscreen=no,location=no,menubar=no,resizable=yes,scrollbars=yes,status=no,titlebar=yes,toolbar=no");
				if(terrabyteWin) terrabyteWin.focus();
			}
		-->
		</script>
		<a href="#" onclick="showTerrabyteWin();"><nobr><bean:message key="link.documents"/></nobr></a>

		<%-- july:link href="<%=siteDocUrl%>"><bean:message key="link.documents"/></july:link --%>
		<july:link page="<%=donorBsUrl%>">Донорная БС</july:link>
	</td>
</tr>

<july:separator/>
