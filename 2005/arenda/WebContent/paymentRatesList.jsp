<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.arenda.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<% String gColSpan = "19"; %>
<%
	String action = null;
	String form = null;
	String parent = null;
	String edit = null;
	String parentCaption = null;
	String parent2 = null;
	String temp = null;
	switch (ParamsParser.getState(pageContext)) {
		case APPStates.PAYMENT_RATES_LIST:
			action = "/ShowPaymentRatesList.do";
			form = "PaymentRatesListForm";
			parent = "/ViewWeArenda.do";
			edit = "/EditPaymentRate.do";
			parent2 = "/ShowPaymentsList.do";
        	break;
		case APPStates.HISTORY_PAYMENT_RATES_LIST:
        	action = "/ShowHistoryPaymentRatesList.do";
			form = "HistoryPaymentRatesListForm";
			parent = "/ViewHistory.do";
			edit = "/EditHistoryPaymentRate.do";
			parent2 = "/ShowHistoryPaymentsList.do";
        	break;
		case APPStates.US_PAYMENT_RATES_LIST:
        	action = "/ShowUsPaymentRatesList.do";
			form = "UsPaymentRatesListForm";
			parent = "/ShowUsArendaList.do";
			edit = "/EditUsPaymentRate.do";
			parentCaption = "label.us";
			parent2 = "/ShowUsPaymentsList.do";
        	break;
		case APPStates.CHANNEL_PAYMENT_RATES_LIST:
        	action = "/ShowChannelPaymentRatesList.do";
			form = "ChannelPaymentRatesListForm";
			parent = "/ShowChannelArendaList.do";
			edit = "/EditChannelPaymentRate.do";
			parentCaption = "label.channel";
			parent2 = "/ShowChannelPaymentsList.do";
        	break;
		case APPStates.ABONENT_PAYMENT_RATES_LIST:
        	action = "/ShowAbonentPaymentRatesList.do";
			form = "AbonentPaymentRatesListForm";
			edit = "/EditAbonentPaymentRate.do";
			parent2 = "/ShowAbonentPaymentsList.do";
        	break;
    }
%>
<july:browseform action="<%= action %>" styleId="<%= form %>">

<html:hidden property="docpositioncode"/>

<table class="main">

<july:separator colspan="<%= gColSpan %>"/>

<tr class="normal">
	<td colspan="<%= gColSpan %>">
	<table class="find">
	<tr>
		<td class="text"><bean:message key="label.filter.docnumber"/>:</td>
		<td class="text" nowrap><bean:write name="<%= form %>" property="documentNumber" filter="true"/></td>
	</tr>
	<tr>
		<td class="text"><bean:message key="label.filter.docperiod"/>:</td>
		<td class="text" nowrap>
			<july:datewrite name="<%= form %>" property="startDate"/>&nbsp;
			<bean:message key="label.filter.stop"/>&nbsp;
			<july:datewrite name="<%= form %>" property="endDate"/>
		</td>
	</tr>
	<tr>
		<td class="text"><bean:message key="label.filter.customer"/>:</td>
		<td class="text"><bean:write name="<%= form %>" property="orgCustomer" filter="true"/></td>
	</tr>
	<tr>
		<td class="text"><bean:message key="label.filter.executor"/>:</td>
		<td class="text"><bean:write name="<%= form %>" property="orgExecutor" filter="true"/></td>
	</tr>
	<tr>
		<td class="text"><bean:message key="label.filter.costcurrency"/>:</td>
		<td class="text" nowrap>
			<july:sumwrite name="<%= form %>" property="currency1"/>&nbsp;<bean:write name="<%= form %>" property="curr1" filter="true"/>
			<logic:present name="<%= form %>" property="currency2">;&nbsp;<july:sumwrite name="<%= form %>" property="currency2"/>&nbsp;<bean:write name="<%= form %>" property="curr2" filter="true"/></logic:present>
		</td>
	</tr>
	<tr>
		<td class="text"><bean:message key="label.leasecalcrate.sumrub"/>:</td>
		<td class="text" nowrap><july:sumwrite name="<%= form %>" property="sumrub"/></td>
	</tr>
	<tr>
		<td class="text"><bean:message key="label.leasecalcrate.sum"/>:</td>
		<td class="text" nowrap>
			<july:sumwrite name="<%= form %>" property="sum"/>&nbsp;<bean:write name="<%= form %>" property="paycurrency" filter="true"/>
		</td>
	</tr>
	<tr>
		<td class="text"><bean:message key="label.leasecalcrate.payrate"/>:</td>
		<td class="text" nowrap><july:numberwrite name="<%= form %>" property="payrate"/></td>
	</tr>
	</table>
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>"/>

<tr class="title">
	<td colspan="<%= gColSpan %>">
	<table class="buttons">
	<tr class="title">
		<td class="buttons">
			<july:canedit rolesProperty="editRoles">
				<logic:equal name="<%= form %>" property="usedinact" value="false">
					<% temp = edit + "?action=Add"; %>
					<july:addbutton page="<%= temp %>"/>
				</logic:equal>
			</july:canedit>
			<july:backbutton />
		</td>
		<td class="navigator"><july:navigator/></td>
	</tr>
	</table>
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>"/>

<!-- Table header -->
<tr class="title">
	<td class="title">&nbsp;</td>
	<july:headercolumn key="label.leasecalcrate.rate" colType="string"/>
	<july:headercolumn key="label.leasecalcrate.sum" colType="string"/>
	<july:headercolumn key="label.leasecalcrate.currency" colType="string"/>
	<july:headercolumn key="label.leasecalcrate.check" colType="string"/>
	<july:headercolumn key="label.leasecalcrate.actnumber" colType="string"/>
	<td class="title">&nbsp;</td>
</tr>

<july:separator colspan="<%= gColSpan %>"/>

<!-- Table body -->
<logic:iterate id="it" name="browseList">
	<logic:present name="it">
		<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
			<td class="link">
				<% temp = "View"; %>
				<july:canedit rolesProperty="editRoles">
					<logic:equal name="<%= form %>" property="usedinact" value="false">
						<logic:notPresent name="it" property="o.act">
							<% temp = "Edit"; %>
						</logic:notPresent>
					</logic:equal>
				</july:canedit>
				<july:editbutton page="<%= edit %>" action="<%= temp %>" paramId="currencycode" paramName="it" paramProperty="o.currency.currency" paramScope="page"/>
			</td>
			<td class="number" align="right">
				<july:numberwrite name="it" property="o.rate" fractdigits="4"/>
			</td>
			<td class="number" align="right">
				<july:numberwrite name="it" property="sum" fractdigits="2"/>
			</td>
			<td class="text">
				<bean:write name="it" property="o.currency.shortname" filter="true"/>
			</td>
			<td class="text" align="center">
				<logic:equal name="it" property="o.byhand" value="true">+</logic:equal>
			</td>
			<td class="text">
				<logic:present name="it" property="o.act">
					<bean:write name="it" property="o.act.documentNumber" filter="true"/>
				</logic:present>
			</td>
			<td class="link">
				<july:canedit rolesProperty="editRoles">
					<logic:equal name="<%= form %>" property="usedinact" value="false">
						<logic:notPresent name="it" property="o.act">
							<% temp = edit + "?action=Delete"; %>
							<july:delbutton page="<%= temp %>" paramId="currencycode" paramName="it" paramProperty="o.currency.currency" paramScope="page"/>
						</logic:notPresent>
					</logic:equal>
				</july:canedit>
			</td>
		</tr>

		<july:separator colspan="<%= gColSpan %>"/>
	</logic:present>
</logic:iterate>

<tr class="title">
	<td colspan="<%= gColSpan %>">
	<table class="buttons">
	<tr class="title">
		<td class="buttons">
			<july:canedit rolesProperty="editRoles">
				<logic:equal name="<%= form %>" property="usedinact" value="false">
					<% temp = edit + "?action=Add"; %>
					<july:addbutton page="<%= temp %>"/>
				</logic:equal>
			</july:canedit>
			<july:backbutton />
		</td>
		<td class="navigator"><july:navigator/></td>
	</tr>
	</table>
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>"/>

</table>

</july:browseform>

