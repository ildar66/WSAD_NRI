<%@ page language = "java" %>
<%@ page import="org.apache.struts.util.*,com.hps.july.siteinfo.valueobject.*,com.hps.july.sitedoc.formbean.*"%>
<%@ page import="com.hps.july.constants.Applications"%>
<%@ page import="com.hps.july.web.util.*"%>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<%
	java.lang.String gColSpan = "6";
	request.setAttribute("colspan",gColSpan);
%>

<july:browseform action="/ProcessEquipmentList.do" styleId="EquipmentForm">
<table class="main">
<july:separator colspan="<%= gColSpan %>" />
<jsp:include page="/tittleObject.jsp" flush="true"/>
<jsp:include page="/tittleDocument.jsp" flush="true"/>
<july:separator colspan="<%= gColSpan %>" />
<jsp:include flush="true" page="/siteDocEquipmentList/fields.jsp" />
<july:separator colspan="<%= gColSpan %>" />
<jsp:include flush="true" page="/siteDocEquipmentList/buttons.jsp" />
<july:separator colspan="<%= gColSpan %>" />
<jsp:include flush="true" page="/siteDocEquipmentList/table.jsp" />
<jsp:include flush="true" page="/siteDocEquipmentList/buttons.jsp" />
<july:separator colspan="<%= gColSpan %>" />
</table>
</july:browseform>
