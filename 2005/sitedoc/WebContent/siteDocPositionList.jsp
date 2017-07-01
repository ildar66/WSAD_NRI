<%@ page language = "java" %>
<%@ page import="org.apache.struts.util.*,com.hps.july.siteinfo.valueobject.*,com.hps.july.sitedoc.formbean.*"%>
<%@ page import="com.hps.july.web.util.*"%>
<%@ page import="com.hps.july.constants.Applications"%>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<%
	com.hps.july.jdbcpersistence.lib.TimeCounter tc = new com.hps.july.jdbcpersistence.lib.TimeCounter("PERF.SITEDOC.POSLIST");
	tc.start();
%>
<%
	java.lang.String gColSpan = "5";
	request.setAttribute("colspan",gColSpan);
	int appHome = ParamsParser.getRootApp( pageContext );
%>
<july:browseform action="/ProcessPositionList.do" styleId="PosForm">
<table class="main">
<july:separator colspan="<%= gColSpan %>" />
<jsp:include page="/tittleObject.jsp" flush="true"/>
<jsp:include page="/tittleDocument.jsp" flush="true"/>
<july:separator colspan="<%= gColSpan %>" />
<jsp:include flush="true" page="/siteDocPositionList/fields.jsp" />
<july:separator colspan="<%= gColSpan %>" />
<jsp:include flush="true" page="/siteDocPositionList/buttons.jsp" />
<july:separator colspan="<%= gColSpan %>" />
<jsp:include flush="true" page="/siteDocPositionList/table.jsp" />
<jsp:include flush="true" page="/siteDocPositionList/buttons.jsp" />
<july:separator colspan="<%= gColSpan %>" />
</table>
</july:browseform>
<%
	tc.finish("jsp");
%>