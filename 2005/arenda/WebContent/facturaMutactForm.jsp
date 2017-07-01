<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.arenda.*,com.hps.july.arenda.formbean.*" %>
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
	String temp = null;
	switch (ParamsParser.getState(pageContext)) {
		case APPStates.FACTURA_MUTACT_EDIT:
        	action = "/ProcessFacturaMutact.do";
			form = "FacturaMutactForm";
			parent2 = "/ShowMutualReglamentsList.do";
			parent3 = "/ShowMutualActsList.do";
			parent4 = "/ShowFacturaMutactList.do";
        	break;
		case APPStates.FROMCONTRACT_FACTURA_MUTACT_EDIT:
			action = "/ProcessFromContractFacturaMutact.do";
			form = "FromContractFacturaMutactForm";
			parent = "/ViewWeArenda.do";
			parent2 = "/ShowFromContractMutualReglamentsList.do";
			parent3 = "/ShowFromContractMutualActsList.do";
			parent4 = "/ShowFromContractFacturaMutactList.do";
        	break;
		case APPStates.FROMHISTORY_FACTURA_MUTACT_EDIT:
			action = "/ProcessFromHistoryFacturaMutact.do";
			form = "FromHistoryFacturaMutactForm";
			parent = "/ViewHistory.do";
			parent2 = "/ShowFromHistoryMutualReglamentsList.do";
			parent3 = "/ShowFromHistoryMutualActsList.do";
			parent4 = "/ShowFromHistoryFacturaMutactList.do";
        	break;
    }
%>

<july:editform action="<%= action %>" styleId="<%= form %>">

<html:hidden property="idSchetFakt"/>
<html:hidden property="idActcode"/>
<html:hidden property="isOnePos"/>

<logic:equal name="<%= form %>" property="action" value="Add"><% gColSpan = "2"; %></logic:equal>

<logic:notEqual name="<%= form %>" property="action" value="Add">
	<logic:equal name="<%= form %>"  property="isOnePos" value="false"><% gColSpan = "2"; %></logic:equal>
</logic:notEqual>

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

    <july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<td class="text"><bean:message key="label.factura.number"/>:</td>
		<td class="text" colspan="<%= Integer.parseInt(gColSpan) - 1 %>">
			<july:string size="50" property="numberSchetFakt" insertable="true" updatable="true"/>
		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<td class="text"><bean:message key="label.factura.date"/>:</td>
		<td class="text" colspan="<%= Integer.parseInt(gColSpan) - 1 %>">
			<july:date size="25" property="dateSchetFaktFrm" insertable="true" updatable="true" required="false"/>
		</td>
	</tr>
	
	<logic:notEqual name="<%= form %>" property="action" value="Add">
	
		<july:separator colspan="<%= gColSpan %>"/>
		
		<tr>
			<td class="text"><bean:message key="label.factura.positions"/>:</td>
			<td class="text" colspan="<%= Integer.parseInt(gColSpan) - 1 %>">
				<july:string size="50" property="positions" insertable="false" updatable="false" styleId="positions"/>
			</td>
		</tr>
	
	</logic:notEqual>
	
	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<td class="text"><july:reqmark><bean:message key="label.factura.dogovor"/>:</july:reqmark></td>
		<td class="text" colspan="<%= Integer.parseInt(gColSpan) - 1 %>">
			<july:select styleId="documents" styleClass="editbigest" collection="documents" property="idContractcode" insertable="true" updatable="false" onchange="changeDocument();">
				<html:options collection="documents" property="leaseDocument" labelProperty="value"/>
			</july:select>
		</td>
	</tr>
	
	<logic:equal name="<%= form %>" property="action" value="Add">
	
		<% FacturaMutactForm fm = (FacturaMutactForm) request.getAttribute(form); %>
		<script language='javascript'>
			var executorNameValues = new Array(
				<%	java.util.Enumeration e = fm.getExecutorNameValues();
					int i = 0;
					while (e.hasMoreElements()) { %><%= i++ != 0 ? "," : "" %>"<%= (String) e.nextElement() %>"
				<%	} %>
			);
			var executorAddressValues = new Array(
				<%	e = fm.getExecutorAddressValues(); i = 0;
					while (e.hasMoreElements()) { %><%= i++ != 0 ? "," : "" %>"<%= (String) e.nextElement() %>"
				<%	} %>
			);
			var executorInnValues = new Array(
				<%	e = fm.getExecutorInnValues(); i = 0;
					while (e.hasMoreElements()) { %><%= i++ != 0 ? "," : "" %>"<%= (String) e.nextElement() %>"
				<%	} %>
			);
			var customerNameValues = new Array(
				<%	e = fm.getCustomerNameValues(); i = 0;
					while (e.hasMoreElements()) { %><%= i++ != 0 ? "," : "" %>"<%= (String) e.nextElement() %>"
				<%	} %>
			);
			var customerAddressValues = new Array(
				<%	e = fm.getCustomerAddressValues(); i = 0;
					while (e.hasMoreElements()) { %><%= i++ != 0 ? "," : "" %>"<%= (String) e.nextElement() %>"
				<%	} %>
			);
			var customerInnValues = new Array(
				<%	e = fm.getCustomerInnValues(); i = 0;
					while (e.hasMoreElements()) { %><%= i++ != 0 ? "," : "" %>"<%= (String) e.nextElement() %>"
				<%	} %>
			);
			var chiefNameValues = new Array(
				<%	e = fm.getChiefNameValues(); i = 0;
					while (e.hasMoreElements()) { %><%= i++ != 0 ? "," : "" %>"<%= (String) e.nextElement() %>"
				<%	} %>
			);
			var accounterNameValues = new Array(
				<%	e = fm.getAccounterNameValues(); i = 0;
					while (e.hasMoreElements()) { %><%= i++ != 0 ? "," : "" %>"<%= (String) e.nextElement() %>"
				<%	} %>
			);
			var positionsValues = new Array(
				<%	e = fm.getPositionsValues(); i = 0;
					while (e.hasMoreElements()) { %><%= i++ != 0 ? "," : "" %>"<%= (String) e.nextElement() %>"
				<%	} %>
			);
		</script>
	
	</logic:equal>
	
    <july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<td class="text"><bean:message key="label.factura.executor"/>:</td>
		<td class="text" colspan="<%= Integer.parseInt(gColSpan) - 1 %>">
			<july:string size="50" property="executorName" insertable="false" updatable="false" styleId="executorName"/>
		</td>
	</tr>
	
    <july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<td class="text"><bean:message key="label.factura.executor.address"/>:</td>
		<td class="text" colspan="<%= Integer.parseInt(gColSpan) - 1 %>">
			<july:string size="50" property="executorAddress" insertable="false" updatable="false" styleId="executorAddress"/>
		</td>
	</tr>
	
    <july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<td class="text"><bean:message key="label.factura.executor.inn"/>:</td>
		<td class="text" colspan="<%= Integer.parseInt(gColSpan) - 1 %>">
			<july:string size="50" property="executorInn" insertable="false" updatable="false" styleId="executorInn"/>
		</td>
	</tr>
	
    <july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<td class="text"><bean:message key="label.factura.exec"/>:</td>
		<td class="text" colspan="<%= Integer.parseInt(gColSpan) - 1 %>">
			<july:string size="50" property="exec" insertable="false" updatable="false" styleId="exec"/>
		</td>
	</tr>
	
    <july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<td class="text"><bean:message key="label.factura.cust"/>:</td>
		<td class="text" colspan="<%= Integer.parseInt(gColSpan) - 1 %>">
			<july:string size="50" property="cust" insertable="false" updatable="false" styleId="cust"/>
		</td>
	</tr>
	
    <july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<td class="text"><bean:message key="label.factura.docnumber"/>:</td>
		<td class="text" colspan="<%= Integer.parseInt(gColSpan) - 1 %>">
			<july:string size="25" property="baseDocNumber" insertable="true" updatable="true"/>&nbsp;
			<bean:message key="label.filter.ot"/>&nbsp;
			<july:date size="25" property="baseDocDateFrm" insertable="true" updatable="true" required="false"/>
		</td>
	</tr>
	
    <july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<td class="text"><bean:message key="label.factura.customer"/>:</td>
		<td class="text" colspan="<%= Integer.parseInt(gColSpan) - 1 %>">
			<july:string size="50" property="customerName" insertable="false" updatable="false" styleId="customerName"/>
		</td>
	</tr>
	
    <july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<td class="text"><bean:message key="label.factura.customer.address"/>:</td>
		<td class="text" colspan="<%= Integer.parseInt(gColSpan) - 1 %>">
			<july:string size="50" property="customerAddress" insertable="false" updatable="false" styleId="customerAddress"/>
		</td>
	</tr>
	
    <july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<td class="text"><bean:message key="label.factura.customer.inn"/>:</td>
		<td class="text" colspan="<%= Integer.parseInt(gColSpan) - 1 %>">
			<july:string size="50" property="customerInn" insertable="false" updatable="false" styleId="customerInn"/>
		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>
	
	<logic:notEqual name="<%= form %>" property="action" value="Add">
		<logic:equal name="<%= form %>"  property="isOnePos" value="true">
			
			<tr>
				<td class="text"><july:reqmark><bean:message key="label.factura.pos.resource"/>:</july:reqmark></td>
				<td class="text" colspan="<%= Integer.parseInt(gColSpan) - 1 %>">
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
		
		</logic:equal>
	</logic:notEqual>
	
	<tr>
		<td class="text"><july:reqmark><bean:message key="label.factura.sum"/>:</july:reqmark></td>
		<td class="text" colspan="<%= Integer.parseInt(gColSpan) - 1 %>">
		    <july:select style="width: 200;" collection="currencies" property="idCurrencycode" insertable="true" updatable="true">
				<html:options collection="currencies" property="currency" labelProperty="name"/>
		   	</july:select>
		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<td class="text"><bean:message key="label.factura.chief"/>:</td>
		<td class="text" colspan="<%= Integer.parseInt(gColSpan) - 1 %>">
			<july:string size="50" property="chiefName" insertable="false" updatable="false" styleId="chiefName"/>
		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<td class="text"><bean:message key="label.factura.accounter"/>:</td>
		<td class="text" colspan="<%= Integer.parseInt(gColSpan) - 1 %>">
			<july:string size="50" property="accounterName" insertable="false" updatable="false" styleId="accounterName"/>
		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>

	<tr class="title">
		<td colspan="<%= gColSpan %>">
			<table cellpadding="0" cellspacing="0" width="100%">
				<july:formbuttons/>
			</table>
		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>

</table>

<logic:equal name="<%= form %>" property="action" value="Add">

	<script language='javascript'>
	function changeDocument() {
		document.all.executorName.value = executorNameValues[document.all.documents.selectedIndex];
		document.all.executorAddress.value = executorAddressValues[document.all.documents.selectedIndex];
		document.all.executorInn.value = executorInnValues[document.all.documents.selectedIndex];
		document.all.customerName.value = customerNameValues[document.all.documents.selectedIndex];
		document.all.customerAddress.value = customerAddressValues[document.all.documents.selectedIndex];
		document.all.customerInn.value = customerInnValues[document.all.documents.selectedIndex];
		document.all.chiefName.value = chiefNameValues[document.all.documents.selectedIndex];
		document.all.accounterName.value = accounterNameValues[document.all.documents.selectedIndex];
		<logic:notEqual name="<%= form %>" property="action" value="Add">
			document.all.positions.value = positionsValues[document.all.documents.selectedIndex];
		</logic:notEqual>
		document.all.exec.value = document.all.executorName.value + " " + document.all.executorAddress.value;
		document.all.cust.value = document.all.customerName.value + " " + document.all.customerAddress.value;
	}
	changeDocument();
	</script>

</logic:equal>

</july:editform>
