<%@ page language = "java" %>
<%@ page import="com.hps.july.persistence.*"%>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% String gColSpan = "4";
    request.setAttribute("colspan",gColSpan);
%>

<july:browseform action="/ShowSiteDocTypeList.do" styleId="SiteDocTypeListForm">

<table class="main">

<%--navigator--%>
<jsp:include page="/siteDocTypeList/navigator.jsp" flush="true"/>
<july:separator colspan="<%= gColSpan %>" />

<%--objectTittle--%>
<%--
<jsp:include page="/tittleObject.jsp" flush="true"/>
<july:separator colspan="<%= gColSpan %>" />
--%>
<jsp:include page="/siteDocTypeList/buttons.jsp" flush="true"/>

<july:separator colspan="<%= gColSpan %>" />

<jsp:include page="/siteDocTypeList/table.jsp" flush="true"/>

<jsp:include page="/siteDocTypeList/buttons.jsp" flush="true"/>

<july:separator colspan="<%= gColSpan %>" />

<%--navigator--%>
<jsp:include page="/siteDocTypeList/navigator.jsp" flush="true"/>

</table>

</july:browseform>



