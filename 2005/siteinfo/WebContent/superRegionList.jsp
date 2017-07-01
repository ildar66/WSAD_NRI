<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "4"; request.setAttribute("colspan",gColSpan);%>

<july:browseform action="/ShowSuperRegionList.do">
<table class="main">
<jsp:include page="/superRegionList/navigator.jsp" flush="true"/>
<july:separator colspan="<%= gColSpan %>" />
<jsp:include page="/superRegionList/buttons.jsp" flush="true"/>
<july:separator colspan="<%= gColSpan %>" />
<jsp:include page="/superRegionList/table.jsp" flush="true"/>
<jsp:include page="/superRegionList/buttons.jsp" flush="true"/>
<july:separator colspan="<%= gColSpan %>" />
<jsp:include page="/superRegionList/navigator.jsp" flush="true"/>
</table>
</july:browseform>

