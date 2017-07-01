<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.arenda.*,com.hps.july.arenda.formbean.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "2"; %>

<%
    String action = null;
	String form = null;
	String parent = null;
	String parent2 = null;
	String parentCaption = null;
	String temp = null;
	switch (ParamsParser.getState(pageContext)) {
		case APPStates.STATE_PAYMENT_EDIT:
			action = "/ProcessPaymentState.do";
			form = "PaymentStateForm";
			parent = "/ViewWeArenda.do";
			parent2 = "/ShowPaymentsList.do";
			break;
		case APPStates.HISTORY_STATE_PAYMENT_EDIT:
			action = "/ProcessHistoryPaymentState.do";
			form = "HistoryPaymentStateForm";
			parent = "/ViewHistory.do";
			parent2 = "/ShowHistoryPaymentsList.do";
			break;
		case APPStates.US_STATE_PAYMENT_EDIT:
			action = "/ProcessUsPaymentState.do";
			form = "UsPaymentStateForm";
			parent = "/ShowUsArendaList.do";
			parent2 = "/ShowUsPaymentsList.do";
			parentCaption = "label.us";
			break;
		case APPStates.CHANNEL_STATE_PAYMENT_EDIT:
			action = "/ProcessChannelPaymentState.do";
			form = "ChannelPaymentStateForm";
			parent = "/ShowChannelArendaList.do";
			parent2 = "/ShowChannelPaymentsList.do";
			parentCaption = "label.channel";
			break;
		case APPStates.ABONENT_STATE_PAYMENT_EDIT:
			action = "/ProcessAbonentPaymentState.do";
			form = "AbonentPaymentStateForm";
			parent2 = "/ShowAbonentPaymentsList.do";
			break;
	}
%>


<july:editform action="<%= action %>" styleId="<%= form %>">


<html:hidden property="leaseDocPosition"/>
<html:hidden property="initialState"/>
<html:hidden property="leaseContractcode"/>
<html:hidden property="costcurrency2"/>
<html:hidden property="certainValue1"/>
<html:hidden property="certainValue2"/>
<html:hidden property="usedinact"/>

<%-- Error properties --%>
<html:hidden property="isProcError"/>
<html:hidden property="procError"/>

<logic:present name="<%= form %>" property="isProcError">
<logic:equal name="<%= form %>" property="isProcError" value="true">
	&nbsp;<br>&nbsp;<br>
	&nbsp;<font class="attention">Error:&nbsp;<bean:write name="<%= form %>" property="procError" filter="true"/></font><br>
	&nbsp;<br>&nbsp;<br>
</logic:equal>
</logic:present>

<table class="main">

<july:separator colspan="<%= gColSpan %>"/>
    
<tr>
	<td class="title" colspan="<%= gColSpan %>"><july:actionalert/></td>
</tr>

<july:separator colspan="<%= gColSpan %>"/>

<tr>
	<td class="text">
		<july:reqmark><bean:message key="label.filter.docnumber"/>:</july:reqmark>
	</td>
	<td class="text">
		<july:string size="50" property="documentNumber" insertable="false" updatable="false"/>
	</td>
</tr>
	
<july:separator colspan="<%= gColSpan %>"/>
	
<tr>
	<td class="text"><july:reqmark><bean:message key="label.filter.docperiod"/>:</july:reqmark></td>
	<td class="text">
		<july:date property="startDateFrm" size="25" insertable="false" updatable="false"/>&nbsp;
		<bean:message key="label.filter.stop"/>&nbsp;
		<july:date property="endDateFrm" size="25" insertable="false" updatable="false"/>
	</td>
</tr>
	
<july:separator colspan="<%= gColSpan %>"/>
	
<tr>
	<td class="text"><july:reqmark><bean:message key="label.filter.customer"/>:</july:reqmark></td>
	<td class="text">
		<july:string size="50" property="orgCustomerContract" insertable="false" updatable="false"/>
	</td>
</tr>
	
<july:separator colspan="<%= gColSpan %>"/>

<tr>
	<td class="text"><july:reqmark><bean:message key="label.filter.executor"/>:</july:reqmark></td>
	<td class="text">
		<july:string size="50" property="orgExecutorContract" insertable="false" updatable="false"/>
	</td>
</tr>
	
<july:separator colspan="<%= gColSpan %>"/>

<tr>
	<td class="text"><july:reqmark><bean:message key="label.filter.costcurrency"/>:</july:reqmark></td>
	<td class="text">
		<july:string size="10" property="costcurrency1" insertable="false" updatable="false"/>&nbsp;
		<bean:write name="<%= form %>" property="curr1" filter="true"/>
		<% temp = ""; %>
		<logic:notEqual name="<%= form %>" property="costcurrency2" value="<%= temp %>">
			&nbsp;<july:string size="10" property="costcurrency2" insertable="false" updatable="false"/>
			&nbsp;<bean:write name="<%= form %>" property="curr2" filter="true"/>
		</logic:notEqual>
	</td>
</tr>
	
<july:separator colspan="<%= gColSpan %>"/>
	
<tr>
	<td class="text"><july:reqmark><bean:message key="label.payments.state"/>:</july:reqmark></td>
	<td class="text">

<%
	PaymentStateForm ps = (PaymentStateForm) request.getAttribute(form);
//	int formState = ps.getState();
	int formState = ParamsParser.getState(pageContext);
	boolean showCertain1 = "true".equals(ps.getCertainValue1());
	boolean showCertain2 = "true".equals(ps.getCertainValue2());
	boolean showReturnState = "P".equals(ps.getInitialState());
	if(formState == APPStates.ABONENT_STATE_PAYMENT_EDIT) {
		if(ps.getUsedinact() != null) {
			showCertain1 = false;
			showCertain2 = false;
			showReturnState = false;
		}
	}
	String stateProp = showCertain2?"paystate":"tempState";
%>
		<july:radio property="paystate" insertable='<%=""+showCertain1%>' updatable='<%=""+showCertain1%>' value="G"/> <bean:message key="label.payments.state.edit"/><br>
		<%-- if (formState != APPStates.ABONENT_STATE_PAYMENT_EDIT) { %>
			<july:radio property="<%=stateProp%>" insertable='<%=""+showCertain2%>' updatable='<%=""+showCertain2%>' value="N"/> <bean:message key="label.payments.state.n"/><br>
		<% } --%>
		<july:radio property="<%=stateProp%>" insertable='<%=""+showCertain2%>' updatable='<%=""+showCertain2%>' value="P"/> <bean:message key="label.payments.state.p"/><br>
		<% if (formState == APPStates.ABONENT_STATE_PAYMENT_EDIT) { %>
		<july:radio property="<%=stateProp%>" insertable='<%=""+showCertain2%>' updatable='<%=""+showCertain2%>' value="K"/> <bean:message key="label.payments.state.k"/><br>
		<% } %>
		<%-- if (formState != APPStates.ABONENT_STATE_PAYMENT_EDIT) { %>
			<july:radio property="paystate" insertable="<%=ps.getCertainValue1()%>" updatable="<%= ps.getCertainValue1() %>" value="M"/> <bean:message key="label.payments.state.m"/><br>
		<% } --%>
		<july:radio property="paystate" insertable='<%=""+showReturnState%>' updatable='<%=""+showReturnState%>' value="V"/> <bean:message key="label.payments.state.v"/>
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>"/>

<july:formbuttons/>

<july:separator colspan="<%= gColSpan %>"/>

</table>

</july:editform>

