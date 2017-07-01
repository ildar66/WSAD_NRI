<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld"    prefix="alex" %>
<%@ page import="org.apache.struts.util.*,com.hps.july.basestation.valueobject.*,com.hps.july.basestation.formbean.*,com.hps.july.persistence.SectorAccessBean" %>
<%@ page import="com.hps.july.jdbcpersistence.lib.AppConstants" %>
<%@ page import="com.hps.july.constants.Applications" %>
<%@ page import="com.hps.july.jdbcpersistence.lib.ObjectType" %>
<%@ page import="com.hps.july.web.util.*" %>

<logic:equal name="SectorForm" property="action" value="Edit">

<%
	boolean isFromSiteinfo=ParamsParser.getRootApp(pageContext)==Applications.SITEINFO;//(sm.getRootState().getApp()==Applications.SITEINFO);

	SectorForm form1=(SectorForm)pageContext.findAttribute("SectorForm");
	String linkCopy1="/EditCopySector.do";
	String journalUrl=AppConstants.BASE_POSITION+"/ShowJournalList.do?objecttype="+ObjectType.Sector+"&objectid="+form1.getIdsect();
	String onclickStr="openWindow('"+journalUrl+"');return false;";
	String repeaterUrl="/ShowFromSectorRepeaterList.do?idsect="+form1.getIdsect();
%>

<tr>
	<td class="text"><bean:message key="label.position.actions"/>:</td>
	<td>
		<%if(!isFromSiteinfo){%>
			<alex:hasAccess href="<%=linkCopy1%>">
				<july:link page="<%=linkCopy1%>"><bean:message key="label.basestation.copy"/></july:link>
			</alex:hasAccess>
		<%}%>
		<%--журнал изменений--%>
		<alex:hasAccess href="/ShowJournalList.do" file="/WEB-INF/web_siteinfo.xml">
			<html:link onclick="<%=onclickStr%>" page="<%=journalUrl%>"><bean:message key="label.menu.journal"/></html:link>
		</alex:hasAccess>
		<alex:hasAccess href="/ShowFromSectorRepeaterList.do">
			<html:link page="<%=repeaterUrl%>"><bean:message key="label.repeaters"/></html:link>
		</alex:hasAccess>
	</td>
</tr>

</logic:equal>