<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.arenda.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>


<% String gColSpan = "2"; %>


<%
    String action = null;
	String form = null;
	String parent = null;
	String parent2 = null;
	switch (ParamsParser.getState(pageContext)) {
		case APPStates.GETPAYS_BYCONTRACT:
        	action = "/ProcessGetPaysByContract.do";
			form = "GetPaysByContractForm";
			parent = "/ViewWeArenda.do";
			parent2 = "/ShowPaymentsList.do";
        	break;
		case APPStates.HISTORY_GETPAYS_BYCONTRACT:
        	action = "/ProcessHistoryGetPaysByContract.do";
			form = "HistoryGetPaysByContractForm";
			parent = "/ViewHistory.do";
			parent2 = "/ShowHistoryPaymentsList.do";
        	break;
	}
%>


<july:editform action="<%= action %>" styleId="<%= form %>">


<html:hidden property="leaseContract"/>


<table class="main">
<%--
<tr class="title">
		<td class="title" colspan="<%= gColSpan %>">
			<html:link page="/ShowWeArendaList.do" styleClass="navigator"><bean:message key="label.we"/></html:link>
			<july:sepmark/>
			<% if (ParamsParser.getState(pageContext) == APPStates.HISTORY_GETPAYS_BYCONTRACT) { %>
				<html:link page="/ShowHistoryList.do" styleClass="navigator"><bean:message key="label.history"/></html:link>
				<july:sepmark/>
			<% } %>
			<july:editlink page="<%= parent %>" action="View" styleClass="navigator">
				<bean:message key="label.view"/>
			</july:editlink>
			<july:sepmark/>
			<html:link page="<%= parent2 %>" styleClass="navigator"><bean:message key="label.payments"/></html:link>
			<july:sepmark/>
			<july:currmark><bean:message key="label.getpays"/></july:currmark>
		</td>
	</tr>
--%>

	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<td class="text"><bean:message key="label.getpays.startdate"/>:</td>
		<td class="text" nowrap>
			<july:date property="dateStartFrm" size="25" insertable="true" updatable="true"/>&nbsp;
			<bean:message key="label.filter.stop"/>&nbsp;
			<july:date property="dateFinishFrm" size="25" insertable="true" updatable="true"/>
		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>
	
	<july:formbuttons/>
	
	<july:separator colspan="<%= gColSpan %>"/>
	
</table>


</july:editform>