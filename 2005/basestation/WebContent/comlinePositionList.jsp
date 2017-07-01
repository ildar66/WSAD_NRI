<%@ page import="com.hps.july.basestation.formbean.ComlinePositionListForm"%>
<%@ page language = "java" %>

<%@ page  contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% 
	java.lang.String gColSpan = "14";
	request.setAttribute("colspan",gColSpan);//для использования во включенных jsp
	ComlinePositionListForm lForm=(ComlinePositionListForm)pageContext.findAttribute("ComlinePositionListForm");
	request.setAttribute("EquipmentListForm", lForm);//для использования во включенных jsp
%>

<july:browseform action="/ShowComlinePositionList.do" styleId="ComlinePositionListForm">

<table class="main">
<july:separator colspan="<%= gColSpan %>" />
<tr class="normal">
	<td colspan="<%= gColSpan %>">
	<table class="find">
	<tr>
		<td class="title"><bean:message key="label.comequ.position"/>:</td>
		<td class="title"><bean:write name="ComlinePositionListForm" property="positionFullname"/></td>
	</tr>
	</table>
	</td>
</tr>
<july:separator colspan="<%= gColSpan %>" />
<jsp:include flush="true" page="/comlineList/buttonsp.jsp" />
<july:separator colspan="<%= gColSpan %>" />
<jsp:include flush="true" page="/comlineList/table.jsp" />
<jsp:include flush="true" page="/comlineList/buttonsp.jsp" />
<july:separator colspan="<%= gColSpan %>" />
</table>
</july:browseform>
