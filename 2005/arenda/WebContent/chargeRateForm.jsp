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

		case APPStates.CHARGE_RATE_EDIT:

        	action = "/ProcessChargeRate.do";

			form = "ChargeRateForm";

			parent = "/ViewWeArenda.do";

			parent2 = "/ShowChargesList.do";

			parent3 = "/ShowChargeRatesList.do";

        	break;

		case APPStates.HISTORY_CHARGE_RATE_EDIT:

        	action = "/ProcessHistoryChargeRate.do";

			form = "HistoryChargeRateForm";

			parent = "/ViewHistory.do";

			parent2 = "/ShowHistoryChargesList.do";

			parent3 = "/ShowHistoryChargeRatesList.do";

        	break;

		case APPStates.US_CHARGE_RATE_EDIT:

        	action = "/ProcessUsChargeRate.do";

			form = "UsChargeRateForm";

			parent = "/ShowUsArendaList.do";

			parent2 = "/ShowUsChargesList.do";

			parentCaption = "label.us";

			parent3 = "/ShowUsChargeRatesList.do";

        	break;

		case APPStates.CHANNEL_CHARGE_RATE_EDIT:

        	action = "/ProcessChannelChargeRate.do";

			form = "ChannelChargeRateForm";

			parent = "/ShowChannelArendaList.do";

			parent2 = "/ShowChannelChargesList.do";

			parentCaption = "label.channel";

			parent3 = "/ShowChannelChargeRatesList.do";

        	break;

		case APPStates.ABONENT_CHARGE_RATE_EDIT:

        	action = "/ProcessAbonentChargeRate.do";

			form = "AbonentChargeRateForm";

			parent2 = "/ShowAbonentChargesList.do";

			parent3 = "/ShowAbonentChargeRatesList.do";

        	break;

    }

%>



<july:editform action="<%= action %>" styleId="<%= form %>">


<%--script language="javascript">

function fix(fixNumber, decimalPlaces) {

	var div = Math.pow(10, decimalPlaces);

	return fixNumber = Math.round(fixNumber * div) / div;

}

function calcSum() {

	<%= form %>.ressum.value = fix(<%= form %>.sumRub.value / <%= form %>.rateFrm.value, 2);

}

</script--%>



<html:hidden property="docpositioncode"/>



<table class="main">

<%--
<tr class="title">

		<td class="title" colspan="<%= gColSpan %>">

			<%	if (ParamsParser.getState(pageContext) == APPStates.CHARGE_RATE_EDIT ||

				ParamsParser.getState(pageContext) == APPStates.HISTORY_CHARGE_RATE_EDIT) { %>

				<html:link page="/ShowWeArendaList.do" styleClass="navigator"><bean:message key="label.we"/></html:link>

				<july:sepmark/>

				<%	if (ParamsParser.getState(pageContext) == APPStates.HISTORY_CHARGE_RATE_EDIT) { %>

					<html:link page="/ShowHistoryList.do" styleClass="navigator"><bean:message key="label.history"/></html:link>

					<july:sepmark/>

	        	<%	} %>

				<july:editlink page="<%= parent %>" action="View" styleClass="navigator">

					<bean:message key="label.view"/>

				</july:editlink>

			<%	} else if (ParamsParser.getState(pageContext) == APPStates.ABONENT_CHARGE_RATE_EDIT) { %>

				<html:link page="/ShowAbonentsList.do" styleClass="navigator"><bean:message key="label.abonents"/></html:link>

				<july:sepmark/>

				<html:link page="/ViewAbonent.do?action=View" styleClass="navigator"><bean:message key="label.view"/></html:link>

			<%	} else { %>

				<html:link page="<%= parent %>" styleClass="navigator"><bean:message key="<%= parentCaption %>"/></html:link>

			<%	} %>

			<july:sepmark/>

			<html:link page="<%= parent2 %>" styleClass="navigator"><bean:message key="label.charges"/></html:link>

			<july:sepmark/>

			<html:link page="<%= parent3 %>" styleClass="navigator"><bean:message key="label.leasecalcrate.charge"/></html:link>

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

	

	<%--july:separator colspan="<%= gColSpan %>"/>

	

	<tr>

		<td class="text"><bean:message key="label.leasecalcrate.sum"/>:</td>

		<td class="text" nowrap>

			<july:string property="ressum" size="25" insertable="false" updatable="false" styleId="ressum"/>&nbsp;

			<img src="/images/obchet1.gif" onclick='calcSum()' border='0' alt='<bean:message key="label.filter.calc"/>'>

		</td>

	</tr--%>

	

	<july:separator colspan="<%= gColSpan %>"/>

	<july:formbuttons/>

	<july:separator colspan="<%= gColSpan %>"/>

</table>

<%--logic:notEqual name="<%= form %>" property="action" value="Add">

	<script language="javascript">

		calcSum();

	</script>

</logic:notEqual--%>

</july:editform>

