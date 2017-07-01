<%@ page language = "java" %>
<%@ page import="com.hps.july.persistence.*"%>
<%@ page import="com.hps.july.web.util.*"%>
<%@ page import="com.hps.july.sitedoc.valueobject.*"%>
<%@ page import="com.hps.july.jdbcpersistence.lib.DebugSupport"%>
<%@ page import="com.hps.july.constants.Applications"%>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<% 
	String gColSpan = "8";
	request.setAttribute("colspan","8");
	DocObjectDef odef = DocObjectDef.getDef(session);
	int appHome = ParamsParser.getRootApp( pageContext );
	DebugSupport.printlnTest("!!!!siteDocList.jsp lForm.isCanModify()="+odef.isCanModify());
	DebugSupport.printlnTest("!!!!siteDocList.jsp request.getParameter('canModify')="+request.getParameter("canModify"));
%>
<july:browseform action="/ShowSiteDocList.do" styleId="SiteDocListForm">
<table class="main">
<july:separator colspan="<%= gColSpan %>" />
<%--objectTittle--%>
<jsp:include page="/tittleObject.jsp" flush="true"/>
<%
	if(!odef.isProject() && !odef.isProjectAction() && !odef.isComline()) {
%>
<july:separator colspan="<%= gColSpan %>" />
<jsp:include page="/siteDocList/fields.jsp" flush="true"/>
<%
}
%>
<july:separator colspan="<%= gColSpan %>" />
<jsp:include page="/siteDocList/buttons.jsp" flush="true"/>
<july:separator colspan="<%= gColSpan %>" />
<jsp:include page="/siteDocList/table.jsp" flush="true"/>
<jsp:include page="/siteDocList/buttons.jsp" flush="true"/>
<july:separator colspan="<%= gColSpan %>" />
</table>
</july:browseform>



