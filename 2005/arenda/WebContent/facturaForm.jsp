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
	String temp = null;
	switch (ParamsParser.getState(pageContext)) {
		case APPStates.FACTURA_EDIT:
        		action = "/ProcessFactura.do";
			form = "FacturaForm";
			parent = "/ViewWeArenda.do";
			parent2 = "/ShowChargesList.do";
        	break;
		case APPStates.HISTORY_FACTURA_EDIT:
			action = "/ProcessHistoryFactura.do";
			form = "HistoryFacturaForm";
			parent = "/ViewHistory.do";
			parent2 = "/ShowHistoryChargesList.do";
        	break;
    }
%>


<july:editform action="<%= action %>" styleId="<%= form %>">

<table class="main">

<july:separator colspan="<%= gColSpan %>"/>

<logic:equal name="<%=form%>" property="action" value="Add">

<html:hidden property="leaseDocPosition"/>
<html:hidden property="isInitialError"/>

<logic:present name="<%= form %>" property="isInitialError">
<logic:equal name="<%= form %>" property="isInitialError" value="true">
	<tr>
		<td class="text" colspan="<%= gColSpan %>">
			<font class="attention"><bean:write name="<%= form %>" property="errorMessage" filter="true"/></font>
		</td>
	</tr>
	<july:separator colspan="<%= gColSpan %>"/>
</logic:equal>
</logic:present>

<tr>
	<td class="text"><bean:message key="label.factura.firstcurrency"/>:</td>
	<td class="text" colspan="10">
		<july:select collection="currencies" property="currencyFrm" insertable="true" updatable="true">
			<html:options collection="currencies" property="currency" labelProperty="name"/>
	   	</july:select>
	</td>
</tr>

</logic:equal>
	
<logic:notEqual name="<%=form%>" property="action" value="Add">

<html:hidden property="idPosSchetFakt"/>
<html:hidden property="isInitialError"/>
<html:hidden property="schetFact"/>
<html:hidden property="currencyFrm"/>


<logic:present name="<%= form %>" property="isInitialError">
<logic:equal name="<%= form %>" property="isInitialError" value="true">
	<tr>
		<td class="text" colspan="<%= gColSpan %>">
			<font class="attention"><bean:write name="<%= form %>" property="errorMessage" filter="true"/></font>
		</td>
	</tr>
	<july:separator colspan="<%= gColSpan %>"/>
</logic:equal>
</logic:present>

<%--
<logic:equal name="<%= form %>" property="isInitialError" value="true">
	&nbsp;<br>&nbsp;<br>
	&nbsp;<font class="attention">Error:&nbsp;<bean:write name="<%= form %>" property="errorMessage" filter="true"/></font><br>
	&nbsp;<br>&nbsp;<br>
</logic:equal>
--%>

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
function showFacture(code){
	window.location.href='/arenda/SchetFactWordAction.do?type='+document.all.type.value+'&code='+code;
}
</script>

<tr>
	<td class="text"><bean:message key="label.factura.positions"/>:</td>
	<td class="text" colspan="10">
		<july:string size="50" property="positions" insertable="false" updatable="false"/>
	</td>
</tr>
	
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
		<july:string size="25" property="baseDocNumber" insertable="true" updatable="true"/>&nbsp;
		<bean:message key="label.filter.ot"/>&nbsp;
		<july:date size="25" property="baseDocDateFrm" insertable="true" updatable="true" required="false"/>
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
		<july:select style="width: 200;" collection="currencies" property="idCurrencycode" insertable="true" updatable="true">
			<html:options collection="currencies" property="currency" labelProperty="name"/>
	   	</july:select>
	</td>
</tr>
	
<july:separator colspan="<%= gColSpan %>"/>
	
<tr>
	<td class="text"><bean:message key="label.factura.chief"/>:</td>
	<td class="text" colspan="10">
		<july:string size="50" property="chiefName" insertable="false" updatable="false"/>
	</td>
</tr>
	
<july:separator colspan="<%= gColSpan %>"/>
	
<tr>
	<td class="text"><bean:message key="label.factura.accounter"/>:</td>
	<td class="text" colspan="10">
		<july:string size="50" property="accounterName" insertable="false" updatable="false"/>
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>"/>

<tr class="title">
	<td class="text">Вид счет-фактуры:</td>
	<td class="text" colspan="10">
		<july:select property="type" insertable="true" updatable="true">
			<html:option value="A">счет-фактура от 16.02.2004</html:option>
			<html:option value="B">счет-фактура от 15.03.2001</html:option>
		</july:select>
		<A href='javascript:showFacture(<bean:write name="<%= form %>" property="schetFact" filter="true"/>)'>
			<img src="/images/docword.gif" border=0 alt='<bean:message key="label.mutualacts.print.sf"/>'>
		</A>
	</td>
</tr>

</logic:notEqual>
	
<july:separator colspan="<%= gColSpan %>"/>

<tr class="title">
	<td colspan="<%= gColSpan %>">
		<table cellpadding="0" cellspacing="0" border="0" width="100%">
<logic:equal name="<%=form%>" property="action" value="Add">
		<july:formbuttons/>
</logic:equal>
<logic:equal name="<%=form%>" property="action" value="Edit">
					<td class="buttons">
						<july:backbutton/>
					</td>
</logic:equal>
		</table>
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>"/>

</table>

</july:editform>
