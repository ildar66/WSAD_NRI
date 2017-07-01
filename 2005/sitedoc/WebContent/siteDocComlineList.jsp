<%@ page import="com.hps.july.basestation.formbean.ComlineListForm"%>
<%@ page language = "java" %>
<%@ page  contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% 
	String gColSpan = "12";
	request.setAttribute("colspan",gColSpan); //для использования во включенных jsp
	// ComlineListForm lForm=(ComlineListForm)pageContext.findAttribute("ComlineListForm");
%>

<july:browseform action="/ProcessComlineList.do" styleId="EquipmentForm">
<table class="main">
<july:separator colspan="<%=gColSpan%>" />
<jsp:include page="/tittleObject.jsp" flush="true"/>
<jsp:include page="/tittleDocument.jsp" flush="true"/>
<july:separator colspan="<%=gColSpan%>" />
<jsp:include flush="true" page="/siteDocComlineList/fields.jsp" />
<july:separator colspan="<%=gColSpan%>" />
<jsp:include flush="true" page="/siteDocComlineList/buttons.jsp" />
<july:separator colspan="<%=gColSpan%>" />
<jsp:include flush="true" page="/siteDocComlineList/table.jsp" />
<jsp:include flush="true" page="/siteDocComlineList/buttons.jsp" />
<july:separator colspan="<%=gColSpan%>" />
</table>
</july:browseform>
