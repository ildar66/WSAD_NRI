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

		case APPStates.CHARGE_DNOP_EDIT:

        	action = "/ProcessChargeDnop.do";

			form = "ChargeDnopForm";

			parent = "/ViewWeArenda.do";

			parent2 = "/ShowChargesList.do";

			parent3 = "/ShowChargeDnopList.do";

        	break;

		case APPStates.HISTORY_CHARGE_DNOP_EDIT:

        	action = "/ProcessHistoryChargeDnop.do";

			form = "HistoryChargeDnopForm";

			parent = "/ViewHistory.do";

			parent2 = "/ShowHistoryChargesList.do";

			parent3 = "/ShowHistoryChargeDnopList.do";

        	break;

		case APPStates.US_CHARGE_DNOP_EDIT:

        	action = "/ProcessUsChargeDnop.do";

			form = "UsChargeDnopForm";

			parent = "/ShowUsArendaList.do";

			parent2 = "/ShowUsChargesList.do";

			parentCaption = "label.us";

			parent3 = "/ShowUsChargeDnopList.do";

        	break;

		case APPStates.CHANNEL_CHARGE_DNOP_EDIT:

        	action = "/ProcessChannelChargeDnop.do";

			form = "ChannelChargeDnopForm";

			parent = "/ShowChannelArendaList.do";

			parent2 = "/ShowChannelChargesList.do";

			parentCaption = "label.channel";

			parent3 = "/ShowChannelChargeDnopList.do";

        	break;

		case APPStates.ABONENT_CHARGE_DNOP_EDIT:

        	action = "/ProcessAbonentChargeDnop.do";

			form = "AbonentChargeDnopForm";

			parent = "/ViewAbonent.do";

			parent2 = "/ShowAbonentChargesList.do";

			parent3 = "/ShowAbonentChargeDnopList.do";

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

	<%= form %>.chargerursumFrm.value = fix(<%= form %>.chargesumFrm.value * <%= form %>.chargerurrateFrm.value, 2);

}

function calcDisplay() {

	<%= form %>.paymentDisplayonly.value = fix(<%= form %>.payRurrem.value / <%= form %>.paymentRateFrm.value, 2);

	<%= form %>.chargesumFrm.value = Math.min(<%= form %>.sumonn.value, <%= form %>.paymentDisplayonly.value);

}

</script>



<html:hidden property="leaseChargecode"/>

<html:hidden property="leaseContract"/>

<html:hidden property="currencycode"/>



<table class="main">

<%--
<tr class="title">

		<td class="title" colspan="<%= gColSpan %>">

			<%	if (ParamsParser.getState(pageContext) == APPStates.CHARGE_DNOP_EDIT ||

				ParamsParser.getState(pageContext) == APPStates.HISTORY_CHARGE_DNOP_EDIT) { %>

				<html:link page="/ShowWeArendaList.do" styleClass="navigator"><bean:message key="label.we"/></html:link>

				<july:sepmark/>

				<%	if (ParamsParser.getState(pageContext) == APPStates.HISTORY_CHARGE_DNOP_EDIT) { %>

					<html:link page="/ShowHistoryList.do" styleClass="navigator"><bean:message key="label.history"/></html:link>

					<july:sepmark/>

	        	<%	} %>

				<july:editlink page="<%= parent %>" action="View" styleClass="navigator">

					<bean:message key="label.view"/>

				</july:editlink>

			<%	} else if (ParamsParser.getState(pageContext) == APPStates.ABONENT_CHARGE_DNOP_EDIT) { %>

				<html:link page="/ShowAbonentsList.do" styleClass="navigator"><bean:message key="label.abonents"/></html:link>

				<july:sepmark/>

				<july:editlink page="/ViewAbonent.do" action="View" styleClass="navigator"><bean:message key="label.view"/></july:editlink>

			<%	} else { %>

				<html:link page="<%= parent %>" styleClass="navigator"><bean:message key="<%= parentCaption %>"/></html:link>

			<%	} %>

			<july:sepmark/>

			<html:link page="<%= parent2 %>" styleClass="navigator"><bean:message key="label.charges"/></html:link>

			<july:sepmark/>

			<html:link page="<%= parent3 %>" styleClass="navigator"><bean:message key="label.dnop"/></html:link>

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

		<td class="text"><bean:message key="label.leasecalcrate.chargedate"/>:</td>

		<td class="text" nowrap><july:date size="25" property="chargedateFrm" insertable="false" updatable="false"/></td>

	</tr>

	

	<july:separator colspan="<%= gColSpan %>"/>



	<tr>

		<td class="text"><bean:message key="label.leasecalcrate.resource"/>:</td>

		<td class="text" nowrap><july:string size="50" property="resourcename" insertable="false" updatable="false"/></td>

	</tr>

	

	<july:separator colspan="<%= gColSpan %>"/>

	

	<tr>

		<td class="text"><bean:message key="label.leasecalcrate.sum"/>:</td>

		<td class="text" nowrap>

			<july:string property="sum" size="25" insertable="false" updatable="false"/>&nbsp;

			<bean:write name="<%= form %>" property="chargecurrency" filter="true"/>

		</td>

	</tr>

	

	<july:separator colspan="<%= gColSpan %>"/>

	

	<tr>

		<td class="text"><bean:message key="label.dnop.onn"/>:</td>

		<td class="text" nowrap>

			<july:string property="sumonn" size="25" insertable="false" updatable="false" styleId="sumonn"/>

		</td>

	</tr>

	

	<july:separator colspan="<%= gColSpan %>"/>

	

	<tr>

		<td class="text"><july:reqmark><bean:message key="label.dnop.payment"/>:</july:reqmark></td>

		<td class="text" nowrap>

			<july:string property="leasePaymentcodeFrm" styleId="payment" size="5" insertable="true" updatable="false"/>

			<logic:equal name="<%= form %>" property="action" value="Add">

				<july:lookupbutton action="/ShowPaymentLookupList.do" styleId="payl" fieldNames="payment;payDate;payNum;paySumrub;payRurrem;paymentRateFrm" newWindowName="paylookup" insertable="true" updatable="true" onclick="set_opt_params_payl('?leaseContract='+document.all.leaseContract.value+'&currencycode='+document.all.currencycode.value);"/>

			</logic:equal>

		</td>

	</tr>

	

	<tr>

		<td class="text"><bean:message key="label.dnop.payment.date"/>:</td>

		<td class="text" nowrap>

			<july:date size="25" property="paymentDateFrm" insertable="false" updatable="false" styleId="payDate"/>

		</td>

	</tr>

	

	<tr>

		<td class="text"><bean:message key="label.dnop.payment.number"/>:</td>

		<td class="text" nowrap>

			<july:string property="paymentNumber" size="50" insertable="false" updatable="false" styleId="payNum"/>

		</td>

	</tr>

	

	<tr>

		<td class="text"><bean:message key="label.dnop.payment.sumrub"/>:</td>

		<td class="text" nowrap>

			<july:string property="paymentSumrub" size="25" insertable="false" updatable="false" styleId="paySumrub"/>

		</td>

	</tr>

	

	<tr>

		<td class="text"><bean:message key="label.dnop.payment.rurremainder"/>:</td>

		<td class="text" nowrap>

			<july:string property="paymentRurremainder" size="25" insertable="false" updatable="false" styleId="payRurrem"/>

		</td>

	</tr>

	

	<tr>

		<td class="text"><july:reqmark><bean:message key="label.dnop.payment.rate"/>:</july:reqmark></td>

		<td class="text" nowrap>

			<july:string property="paymentRateFrm" size="25" insertable="true" updatable="false" onchange="calcDisplay()" styleId="paymentRateFrm"/><%-- it's --%>

		</td>

	</tr>

	

	<tr>

		<td class="text"><bean:message key="label.dnop.payment.displayonly"/>:</td>

		<td class="text" nowrap>

			<july:string property="paymentDisplayonly" size="25" insertable="false" updatable="false" styleId="paymentDisplayonly"/>

		</td>

	</tr>

	

	<july:separator colspan="<%= gColSpan %>"/>

	

	<tr>

		<td class="text"><bean:message key="label.dnop.chargesum"/>:</td>

		<td class="text" nowrap>

			<july:string property="chargesumFrm" size="25" insertable="true" updatable="false" styleId="chargesumFrm"/>

		</td>

	</tr>

	

	<july:separator colspan="<%= gColSpan %>"/>

	

	<tr>

		<td class="text"><bean:message key="label.dnop.chargerurrate"/>:</td>

		<td class="text" nowrap>

			<july:string property="chargerurrateFrm" size="25" insertable="true" updatable="true" onchange="calcSum()" styleId="chargerurrateFrm"/>

		</td>

	</tr>

	

	<july:separator colspan="<%= gColSpan %>"/>

	

	<tr>

		<td class="text"><bean:message key="label.dnop.chargerursum"/>:</td>

		<td class="text" nowrap>

			<july:string property="chargerursumFrm" size="25" insertable="false" updatable="false" styleId="chargerursumFrm"/>

		</td>

	</tr>

	

	<july:separator colspan="<%= gColSpan %>"/>

	

	<tr>

		<td class="text"><july:reqmark><bean:message key="label.dnop.source"/>:</july:reqmark></td>

		<td class="text">

			<logic:equal name="<%= form %>" property="source" value="B"><bean:message key="label.dnop.source.b"/></logic:equal>

			<logic:equal name="<%= form %>" property="source" value="H"><bean:message key="label.dnop.source.h"/></logic:equal>

			<logic:equal name="<%= form %>" property="source" value="A"><bean:message key="label.dnop.source.a"/></logic:equal>

		</td>

	</tr>

	

	<july:separator colspan="<%= gColSpan %>"/>

	

	<tr>

		<td class="text"><bean:message key="label.dnop.act"/>:</td>

		<td class="text">

			<july:string size="25" property="actcode" insertable="false" updatable="false"/>

		</td>

	</tr>

	

	<july:separator colspan="<%= gColSpan %>"/>

	

	<tr>

		<td class="text"><july:reqmark><bean:message key="label.dnop.byhand"/>:</july:reqmark></td>

		<td class="text">

			<july:checkbox property="byhandchangeraterur" insertable="false" updatable="false"/>

		</td>

	</tr>

	

	<july:separator colspan="<%= gColSpan %>"/>

	<july:formbuttons/>

	<july:separator colspan="<%= gColSpan %>"/>

</table>

</july:editform>

