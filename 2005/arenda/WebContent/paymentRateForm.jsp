<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.arenda.*" %>
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
	String parent3 = null;
	String temp = null;
	switch (ParamsParser.getState(pageContext)) {
		case APPStates.PAYMENT_RATE_EDIT:
        	action = "/ProcessPaymentRate.do";
			form = "PaymentRateForm";
			parent = "/ViewWeArenda.do";
			parent2 = "/ShowPaymentsList.do";
			parent3 = "/ShowPaymentRatesList.do";
        	break;
		case APPStates.HISTORY_PAYMENT_RATE_EDIT:
        	action = "/ProcessHistoryPaymentRate.do";
			form = "HistoryPaymentRateForm";
			parent = "/ViewHistory.do";
			parent2 = "/ShowHistoryPaymentsList.do";
			parent3 = "/ShowHistoryPaymentRatesList.do";
        	break;
		case APPStates.US_PAYMENT_RATE_EDIT:
        	action = "/ProcessUsPaymentRate.do";
			form = "UsPaymentRateForm";
			parent = "/ShowUsArendaList.do";
			parent2 = "/ShowUsPaymentsList.do";
			parentCaption = "label.us";
			parent3 = "/ShowUsPaymentRatesList.do";
        	break;
		case APPStates.CHANNEL_PAYMENT_RATE_EDIT:
        	action = "/ProcessChannelPaymentRate.do";
			form = "ChannelPaymentRateForm";
			parent = "/ShowChannelArendaList.do";
			parent2 = "/ShowChannelPaymentsList.do";
			parentCaption = "label.channel";
			parent3 = "/ShowChannelPaymentRatesList.do";
        	break;
		case APPStates.ABONENT_PAYMENT_RATE_EDIT:
        	action = "/ProcessAbonentPaymentRate.do";
			form = "AbonentPaymentRateForm";
			parent2 = "/ShowAbonentPaymentsList.do";
			parent3 = "/ShowAbonentPaymentRatesList.do";
        	break;
    }
%>
<july:editform action="<%= action %>" styleId="<%= form %>">
<script language="javascript">
function fix(fixNumber, decimalPlaces) {
	var div = Math.pow(10, decimalPlaces);
	return fixNumber = Math.round(fixNumber * div) / div;
}
function calcSum() {
	if(<%= form %>.sumRub.value == ""){
		alert('<bean:message key="error.javascript.sumrub"/>');
		return;
	}
	if(<%= form %>.rateFrm.value == ""){
		alert('<bean:message key="error.javascript.rate"/>');
		return;
	}

	var num = new Number(<%= form %>.rateFrm.value);
	if(num.valueOf().toString() == 'NaN'){
		alert('<bean:message key="error.javascript.rate.invalid"/>');
		return;
	}
	<%= form %>.ressum.value = fix(<%= form %>.sumRub.value / <%= form %>.rateFrm.value, 2);
}
</script>
<html:hidden property="docpositioncode"/>
<table class="main">
<%--
<tr class="title">
		<td class="title" colspan="<%= gColSpan %>">
			<%	if (ParamsParser.getState(pageContext) == APPStates.PAYMENT_RATE_EDIT ||
				ParamsParser.getState(pageContext) == APPStates.HISTORY_PAYMENT_RATE_EDIT) { %>
				<html:link page="/ShowWeArendaList.do" styleClass="navigator"><bean:message key="label.we"/></html:link>
				<july:sepmark/>
				<%	if (ParamsParser.getState(pageContext) == APPStates.HISTORY_PAYMENT_RATE_EDIT) { %>
					<html:link page="/ShowHistoryList.do" styleClass="navigator"><bean:message key="label.history"/></html:link>
					<july:sepmark/>
	        	<%	} %>
				<july:editlink page="<%= parent %>" action="View" styleClass="navigator">
					<bean:message key="label.view"/>
				</july:editlink>
			<%	} else if (ParamsParser.getState(pageContext) == APPStates.ABONENT_PAYMENT_RATE_EDIT) { %>
				<html:link page="/ShowAbonentsList.do" styleClass="navigator"><bean:message key="label.abonents"/></html:link>
				<july:sepmark/>
				<html:link page="/ViewAbonent.do?action=View" styleClass="navigator"><bean:message key="label.view"/></html:link>
			<%	} else { %>
				<html:link page="<%= parent %>" styleClass="navigator"><bean:message key="<%= parentCaption %>"/></html:link>
			<%	} %>
			<july:sepmark/>
			<html:link page="<%= parent2 %>" styleClass="navigator"><bean:message key="label.payments"/></html:link>
			<july:sepmark/>
			<html:link page="<%= parent3 %>" styleClass="navigator"><bean:message key="label.leasecalcrate.payment"/></html:link>
			<july:sepmark/>			
			<july:actionname/>
		</td>
	</tr>
--%>

	<july:separator colspan="<%= gColSpan %>"/>
    <tr>
        <td class="title" colspan="<%= gColSpan %>"><july:actionalert/></td>
    </tr>
 	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text"><bean:message key="label.filter.docnumber"/>:</td>
		<td class="text" nowrap>
			<july:string size="50" property="documentNumber" insertable="false" updatable="false"/>
		</td>
	</tr>
	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text"><bean:message key="label.filter.docperiod"/>:</td>
		<td class="text" nowrap>
			<july:date size="25" property="startDateFrm" insertable="false" updatable="false"/>&nbsp;
			<bean:message key="label.filter.stop"/>&nbsp;
			<july:date size="25" property="endDateFrm" insertable="false" updatable="false"/>
		</td>
	</tr>
	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text"><bean:message key="label.filter.customer"/>:</td>
		<td class="text" nowrap><july:string property="orgCustomer" size="50" insertable="false" updatable="false"/></td>
	</tr>
	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text"><bean:message key="label.filter.executor"/>:</td>
		<td class="text" nowrap><july:string property="orgExecutor" size="50" insertable="false" updatable="false"/></td>
	</tr>
	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text"><bean:message key="label.filter.costcurrency"/>:</td>
		<td class="text" nowrap>
			<july:string property="currency1" size="25" insertable="false" updatable="false"/>&nbsp;
			<bean:write name="<%= form %>" property="curr1" filter="true"/>
			<logic:present name="<%= form %>" property="currency2">
				&nbsp;<july:string property="currency2" size="25" insertable="false" updatable="false"/>
				&nbsp;<bean:write name="<%= form %>" property="curr2" filter="true"/>
			</logic:present>
		</td>
	</tr>
	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text"><bean:message key="label.leasecalcrate.sumrub"/>:</td>
		<td class="text" nowrap><july:string property="sumrub" size="25" insertable="false" updatable="false" styleId="sumRub"/></td>
	</tr>
	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text"><bean:message key="label.leasecalcrate.sum"/>:</td>
		<td class="text" nowrap>
			<july:string property="sum" size="25" insertable="false" updatable="false"/>&nbsp;
			<bean:write name="<%= form %>" property="paycurrency" filter="true"/>
		</td>
	</tr>
	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text"><bean:message key="label.leasecalcrate.payrate"/>:</td>
		<td class="text" nowrap><july:string property="payrate" size="25" insertable="false" updatable="false"/></td>
	</tr>
	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text"><july:reqmark><bean:message key="label.leasecalcrate.currency"/>:</july:reqmark></td>
		<td class="text">
			<logic:equal name="<%= form %>" property="action" value="Add">
			    <july:select style="width: 300;" collection="currencies" property="currencycode" insertable="true" updatable="true">
					<html:options collection="currencies" property="currency" labelProperty="name"/>
			   	</july:select>
			</logic:equal>
			<logic:notEqual name="<%= form %>" property="action" value="Add">
			    <july:select style="width: 300;" collection="currencies" property="currencycode" insertable="false" updatable="false">
					<html:options collection="currencies" property="currency" labelProperty="name"/>
			   	</july:select>
			</logic:notEqual>
		</td>
    </tr>
	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text"><july:reqmark><bean:message key="label.leasecalcrate.payrate2"/>:</july:reqmark></td>
		<td class="text" nowrap><july:string property="rateFrm" size="25" insertable="true" updatable="true" styleId="rateFrm"/></td>
	</tr>
	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text"><bean:message key="label.leasecalcrate.sum"/>:</td>
		<td class="text" nowrap>
			<july:string property="ressum" size="25" insertable="false" updatable="false" styleId="ressum"/>
			<logic:notEqual name="<%= form %>" property="action" value="Delete">
				<logic:notEqual name="<%= form %>" property="action" value="View">
					&nbsp;<img src="/images/obchet1.gif" onclick='calcSum()' border='0' alt='<bean:message key="label.filter.calc"/>'>
				</logic:notEqual>
			</logic:notEqual>
		</td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>
	<july:formbuttons/>
	<july:separator colspan="<%= gColSpan %>"/>

</table>
<logic:notEqual name="<%= form %>" property="action" value="Add">
	<script language="javascript">
//		calcSum();
	</script>
</logic:notEqual>
</july:editform>
