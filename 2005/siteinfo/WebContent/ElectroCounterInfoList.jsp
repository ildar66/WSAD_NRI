<%@ page language = "java" %>
<%@ page import="com.hps.july.persistence.*, com.hps.july.cdbc.lib.*"%>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%
    java.lang.String gColSpan = "5";
    request.setAttribute("colspan", gColSpan);
%>

<july:browseform action="/ShowElectroCounterInfoList.do" styleId="eci">
<july:selectableTable styleClass="main"  modelName="list" selectable="1" selectedClass="selected" paramName="selID" >
<%--
<table class="main">
--%>
<july:separator colspan="<%= gColSpan %>" />
<jsp:include page="/electroCounter/fields.jsp" flush="true"/>
<july:separator colspan="<%= gColSpan %>" />
<jsp:include page="/electroCounter/buttons.jsp" flush="true"/>
<july:separator colspan="<%= gColSpan %>" />
<jsp:include page="/electroCounter/table.jsp" flush="true"/>
<jsp:include page="/electroCounter/buttons.jsp" flush="true"/>
<july:separator colspan="<%= gColSpan %>" />
</july:selectableTable>
<%--
</table>
--%>
</july:browseform>
