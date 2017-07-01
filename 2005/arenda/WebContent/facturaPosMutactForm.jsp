<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.arenda.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "11"; %>

<%
    String action = null;
	String form = null;
	String parent = null;
	String parent2 = null;
	String parent3 = null;
	String parent4 = null;
	String parent5 = null;
	String temp = null;
	switch (ParamsParser.getState(pageContext)) {
		case APPStates.FACTURA_POS_MUTACT_EDIT:
        	action = "/ProcessFacturaPosMutact.do";
			form = "FacturaPosMutactForm";
			parent2 = "/ShowMutualReglamentsList.do";
			parent3 = "/ShowMutualActsList.do";
			parent4 = "/ShowFacturaMutactList.do";
			parent5 = "/ShowFacturaPosMutactList.do";
        	break;
		case APPStates.FROMCONTRACT_FACTURA_POS_MUTACT_EDIT:
			action = "/ProcessFromContractFacturaPosMutact.do";
			form = "FromContractFacturaPosMutactForm";
			parent = "/ViewWeArenda.do";
			parent2 = "/ShowFromContractMutualReglamentsList.do";
			parent3 = "/ShowFromContractMutualActsList.do";
			parent4 = "/ShowFromContractFacturaMutactList.do";
			parent5 = "/ShowFromContractFacturaPosMutactList.do";
        	break;
		case APPStates.FROMHISTORY_FACTURA_POS_MUTACT_EDIT:
			action = "/ProcessFromHistoryFacturaPosMutact.do";
			form = "FromHistoryFacturaPosMutactForm";
			parent = "/ViewHistory.do";
			parent2 = "/ShowFromHistoryMutualReglamentsList.do";
			parent3 = "/ShowFromHistoryMutualActsList.do";
			parent4 = "/ShowFromHistoryFacturaMutactList.do";
			parent5 = "/ShowFromHistoryFacturaPosMutactList.do";
        	break;
    }
%>

<july:editform action="<%= action %>" styleId="<%= form %>">

<html:hidden property="idPosSchetFakt"/>
<html:hidden property="idSchetFakt"/>

<script language="javascript">
function calcSumNds() {
	<%= form %>.sumNdsFrm.value = fix((<%= form %>.sumWithTaxFrm.value * <%= form %>.rateNdsFrm.value) / (100 + <%= form %>.rateNdsFrm.value), 2);
	calcSumFreeTax();
}
function calcSumFreeTax() {
	<%= form %>.sumFreeTaxFrm.value = <%= form %>.sumWithTaxFrm.value - <%= form %>.sumNdsFrm.value;
}
function fix(fixNumber, decimalPlaces) {
	var div = Math.pow(10, decimalPlaces);
	return fixNumber = Math.round(fixNumber * div) / div;
}
</script>

<table class="main">
<%--
<tr class="title">
		<td class="title" colspan="<%= gColSpan %>">
			<%	if (ParamsParser.getState(pageContext) == APPStates.FROMCONTRACT_FACTURA_POS_MUTACT_EDIT ||
				ParamsParser.getState(pageContext) == APPStates.FROMHISTORY_FACTURA_POS_MUTACT_EDIT) { %>
				<html:link page="/ShowWeArendaList.do" styleClass="navigator"><bean:message key="label.we"/></html:link>
				<july:sepmark/>
				<%	if (ParamsParser.getState(pageContext) == APPStates.FROMHISTORY_FACTURA_POS_MUTACT_EDIT) { %>
					<html:link page="/ShowHistoryList.do" styleClass="navigator"><bean:message key="label.history"/></html:link>
					<july:sepmark/>
	        	<% } %>
				<july:editlink page="<%= parent %>" action="View" styleClass="navigator"><bean:message key="label.view"/></july:editlink>
				<july:sepmark/>
			<%	} %>
			<html:link page="<%= parent2 %>" styleClass="navigator"><bean:message key="label.mutualreglmnts"/></html:link>
			<july:sepmark/>
			<html:link page="<%= parent3 %>" styleClass="navigator"><bean:message key="label.mutualacts"/></html:link>
			<july:sepmark/>
			<html:link page="<%= parent4 %>" styleClass="navigator"><bean:message key="label.factures"/></html:link>
			<july:sepmark/>
			<html:link page="<%= parent5 %>" styleClass="navigator"><bean:message key="label.factura.pos"/></html:link>
			<july:sepmark/>
			<july:actionname/>
		</td>
	</tr>
--%>

	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<td class="text"><bean:message key="label.factura.executor"/>:</td>
		<td class="text" colspan="10">
			<july:string size="50" property="executorName" insertable="false" updatable="false"/>
		</td>
	</tr>
	
    <july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<td class="text"><bean:message key="label.factura.executor.address"/>:</td>
		<td class="text" colspan="10">
			<july:string size="50" property="executorAddress" insertable="false" updatable="false"/>
		</td>
	</tr>
	
    <july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<td class="text"><bean:message key="label.factura.executor.inn"/>:</td>
		<td class="text" colspan="10">
			<july:string size="50" property="executorInn" insertable="false" updatable="false"/>
		</td>
	</tr>
	
    <july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<td class="text"><bean:message key="label.factura.exec"/>:</td>
		<td class="text" colspan="10">
			<july:string size="50" property="exec" insertable="false" updatable="false"/>
		</td>
	</tr>
	
    <july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<td class="text"><bean:message key="label.factura.cust"/>:</td>
		<td class="text" colspan="10">
			<july:string size="50" property="cust" insertable="false" updatable="false"/>
		</td>
	</tr>
	
    <july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<td class="text"><bean:message key="label.factura.docnumber"/>:</td>
		<td class="text" colspan="10">
			<july:string size="25" property="baseDocNumber" insertable="false" updatable="false"/>&nbsp;
			<bean:message key="label.filter.ot"/>&nbsp;
			<july:date size="25" property="baseDocDateFrm" insertable="false" updatable="false"/>
		</td>
	</tr>
	
    <july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<td class="text"><bean:message key="label.factura.customer"/>:</td>
		<td class="text" colspan="10">
			<july:string size="50" property="customerName" insertable="false" updatable="false"/>
		</td>
	</tr>
	
    <july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<td class="text"><bean:message key="label.factura.customer.address"/>:</td>
		<td class="text" colspan="10">
			<july:string size="50" property="customerAddress" insertable="false" updatable="false"/>
		</td>
	</tr>
	
    <july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<td class="text"><bean:message key="label.factura.customer.inn"/>:</td>
		<td class="text" colspan="10">
			<july:string size="50" property="customerInn" insertable="false" updatable="false"/>
		</td>
	</tr>
	
    <july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<td class="text"><july:reqmark><bean:message key="label.factura.pos.resource"/>:</july:reqmark></td>
		<td class="text" colspan="10">
		    <july:select style="width: 450;" collection="resources" property="resourceNricode" insertable="true" updatable="true">
				<html:options collection="resources" property="resource" labelProperty="name"/>
		   	</july:select>
		</td>
	</tr>
	
    <july:separator colspan="<%= gColSpan %>"/>
	
	<tr class="title">
		<td class="text"><bean:message key="label.factura.tovar"/></td>
		<td class="text"><bean:message key="label.factura.ed"/></td>
		<td class="text"><bean:message key="label.factura.count"/></td>
		<td class="text"><bean:message key="label.factura.edprice"/></td>
		<td class="text"><bean:message key="label.factura.price"/></td>
		<td class="text"><bean:message key="label.factura.akciz"/></td>
		<td class="text"><bean:message key="label.factura.ns"/></td>
		<td class="text"><bean:message key="label.factura.sumnalog"/></td>
		<td class="text"><bean:message key="label.factura.allprice"/></td>
		<td class="text"><bean:message key="label.factura.country"/></td>
		<td class="text"><bean:message key="label.factura.gtdnumber"/></td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<td class="text"><july:textarea styleClass="edit" cols="2" rows="4" property="nameResource" insertable="true" updatable="true"/></td>
		<td class="text">&nbsp;</td>
		<td class="text">&nbsp;</td>
		<td class="text">&nbsp;</td>
		<td class="text"><july:string size="8" property="sumFreeTaxFrm" insertable="true" updatable="true"/></td>
		<td class="text">&nbsp;</td>
		<td class="text"><july:string size="8" property="rateNdsFrm" insertable="true" updatable="true" onkeyup="calcSumNds();"/></td>
		<td class="text"><july:string size="8" property="sumNdsFrm" insertable="true" updatable="true" onkeyup="calcSumFreeTax();"/></td>
		<td class="text"><july:string size="8" property="sumWithTaxFrm" insertable="true" updatable="true"/></td>
		<td class="text">&nbsp;</td>
		<td class="text">&nbsp;</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<td class="text"><bean:message key="label.factura.sum"/>:</td>
		<td class="text" colspan="6">
		    <july:select style="width: 200;" collection="currencies" property="idCurrencycode" insertable="false" updatable="false">
				<html:options collection="currencies" property="currency" labelProperty="name"/>
		   	</july:select>
		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>
	
	<july:formbuttons/>
	
	<july:separator colspan="<%= gColSpan %>"/>

</table>

</july:editform>