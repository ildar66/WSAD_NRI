<%@ page language = "java" %>
<%@ page import="com.hps.july.arenda.formbean.*,org.apache.struts.util.*,com.hps.july.web.util.*,com.hps.july.arenda.*" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>


<% java.lang.String gColSpan = "1"; %>


<%
	String value = null;
	String parent = null;
	String parent2 = null;
	switch (ParamsParser.getState(pageContext)) {
		case APPStates.PRINT_FACTURA:
			value = "schetFact";
			parent = "/ViewWeArenda.do";
			parent2 = "/ShowChargesList.do";
        	break;
		case APPStates.HISTORY_PRINT_FACTURA:
			value = "historySchetFact";
			parent = "/ViewHistory.do";
			parent2 = "/ShowHistoryChargesList.do";
        	break;
    }
%>


<table class="main">
<%--
<tr class="title">
		<td class="title" colspan="<%= gColSpan %>">
			<html:link page="/ShowWeArendaList.do" styleClass="navigator"><bean:message key="label.we"/></html:link>
			<july:sepmark/>
			<% if (ParamsParser.getState(pageContext) == APPStates.HISTORY_PRINT_FACTURA) { %>
				<html:link page="/ShowHistoryList.do" styleClass="navigator"><bean:message key="label.history"/></html:link>
				<july:sepmark/>
			<% } %>
			<july:editlink page="<%= parent %>" action="View" styleClass="navigator"><bean:message key="label.view"/></july:editlink>
			<july:sepmark/>
			<html:link page="<%= parent2 %>" styleClass="navigator"><bean:message key="label.charges"/></html:link>
			<july:sepmark/>
			<july:currmark><bean:message key="label.factura.report"/></july:currmark>
		</td>
	</tr>
--%>

	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr class="title">
		<td>
			<%	String p = "SchetFaktHeader.rpt?dll=pdsschetfact.dll";
				p += "&prompt0=" + (Integer) request.getSession().getAttribute(value); 
				System.out.println(p); %>
			
			<july:report report="<%= p %>"/>
		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>
	
<%--
<tr class="title">
		<td class="title" colspan="<%= gColSpan %>">
			<html:link page="/ShowWeArendaList.do" styleClass="navigator"><bean:message key="label.we"/></html:link>
			<july:sepmark/>
			<% if (ParamsParser.getState(pageContext) == APPStates.HISTORY_PRINT_FACTURA) { %>
				<html:link page="/ShowHistoryList.do" styleClass="navigator"><bean:message key="label.history"/></html:link>
				<july:sepmark/>
			<% } %>
			<july:editlink page="<%= parent %>" action="View" styleClass="navigator"><bean:message key="label.view"/></july:editlink>
			<july:sepmark/>
			<html:link page="<%= parent2 %>" styleClass="navigator"><bean:message key="label.charges"/></html:link>
			<july:sepmark/>
			<july:currmark><bean:message key="label.factura.report"/></july:currmark>
		</td>
	</tr>
--%>


</table>

