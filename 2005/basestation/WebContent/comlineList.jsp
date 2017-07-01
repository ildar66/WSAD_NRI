<%@ page import="com.hps.july.basestation.formbean.ComlineListForm"%>
<%@ page language = "java" %>

<%@ page  contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% 
	java.lang.String gColSpan = "14";
	request.setAttribute("colspan",gColSpan);//для использования во включенных jsp
	ComlineListForm lForm=(ComlineListForm)pageContext.findAttribute("ComlineListForm");
	request.setAttribute("EquipmentListForm", lForm);//для использования во включенных jsp
%>

<july:browseform action="/ShowComlineList.do" styleId="ComlineListForm">
<july:selectableTable styleClass="main" modelName="list" selectable="1" selectedClass="selected" paramName="comID" >
<july:separator colspan="<%= gColSpan %>" />
<jsp:include flush="true" page="/comlineList/fields.jsp" />
<july:separator colspan="<%= gColSpan %>" />
<jsp:include flush="true" page="/comlineList/buttons.jsp" />
<july:separator colspan="<%= gColSpan %>" />
<jsp:include flush="true" page="/comlineList/table.jsp" />
<jsp:include flush="true" page="/comlineList/buttons.jsp" />
<july:separator colspan="<%= gColSpan %>" />
</july:selectableTable>
</july:browseform>
