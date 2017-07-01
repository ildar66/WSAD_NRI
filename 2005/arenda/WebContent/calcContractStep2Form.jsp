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
	String temp = null;

	switch (ParamsParser.getState(pageContext)) {

		case APPStates.CALC_CONTRACT_STEP2:

        	action = "/ProcessCalcContractStep2.do";

			form = "CalcContractStep2Form";

			parent = "/ViewWeArenda.do";

			parent2 = "/EditCalcContractStep1.do";

        	break;

		case APPStates.HISTORY_CALC_CONTRACT_STEP2:

        	action = "/ProcessHistoryCalcContractStep2.do";

			form = "HistoryCalcContractStep2Form";

			parent = "/ViewHistory.do";

			parent2 = "/EditHistoryCalcContractStep1.do";

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

			<% if (ParamsParser.getState(pageContext) == APPStates.HISTORY_CALC_CONTRACT_STEP2) { %>

				<html:link page="/ShowHistoryList.do" styleClass="navigator"><bean:message key="label.history"/></html:link>

				<july:sepmark/>

			<% } %>

			<july:editlink page="<%= parent %>" action="View" styleClass="navigator">

				<bean:message key="label.view"/>

			</july:editlink>

			<july:sepmark/>

			<july:editlink page="<%= parent2 %>" action="Add" styleClass="navigator">

				<bean:message key="label.contractcalc.step1"/>

			</july:editlink>

			<july:sepmark/>

			<july:currmark><bean:message key="label.contractcalc.step2"/></july:currmark>

		</td>

	</tr>
--%>

	
 	<july:separator colspan="<%= gColSpan %>"/>

	<tr>
		<td class="text">
			<july:reqmark><bean:message key="label.filter.docnumber"/>:</july:reqmark>
		</td>

		<td class="text">
			<july:string size="50" property="documentNumber" insertable="false" updatable="false" styleId="documentNumber"/>
		</td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>

	<tr>
		<td class="text"><july:reqmark><bean:message key="label.filter.docperiod"/>:</july:reqmark></td>
		<td class="text">
			<july:date property="startDateFrm" size="25" insertable="false" updatable="false" styleId="startDateFrm"/>&nbsp;
			<bean:message key="label.filter.stop"/>&nbsp;
			<july:date property="endDateFrm" size="25" insertable="false" updatable="false" styleId="endDateFrm"/>
		</td>
	</tr>

	

	<july:separator colspan="<%= gColSpan %>"/>

	

	<tr>

		<td class="text">

			<july:reqmark><bean:message key="label.filter.customer"/>:</july:reqmark>

		</td>

		<td class="text">

			<july:string size="50" property="orgCustomerContract" insertable="false" updatable="false" styleId="orgCustomerContract"/>

		</td>

	</tr>

	

	<july:separator colspan="<%= gColSpan %>"/>



	<tr>

		<td class="text">

			<july:reqmark><bean:message key="label.filter.executor"/>:</july:reqmark>

		</td>

		<td class="text">

			<july:string size="50" property="orgExecutorContract" insertable="false" updatable="false" styleId="orgExecutorContract"/>

		</td>

	</tr>

	

	<july:separator colspan="<%= gColSpan %>"/>



	<tr>

		<td class="text">

			<july:reqmark><bean:message key="label.filter.costcurrency"/>:</july:reqmark>

		</td>

		<td class="text">

			<july:string size="10" property="costcurrency1" insertable="false" updatable="false" styleId="costcurrency1"/>&nbsp;

			<bean:write name="<%= form %>" property="curr1" filter="true"/>

			<% temp = ""; %>

			<logic:notEqual name="<%= form %>" property="costcurrency2" value="<%= temp %>">

				&nbsp;<july:string size="10" property="costcurrency2" insertable="false" updatable="false" styleId="costcurrency2"/>

				&nbsp;<bean:write name="<%= form %>" property="curr2" filter="true"/>

			</logic:notEqual>

		</td>

    </tr>

	

	<july:separator colspan="<%= gColSpan %>"/>

	

	<tr>

		<td class="text"><july:reqmark><bean:message key="label.contractcalc.resource"/>:</july:reqmark></td>

		<td class="text">

		    <july:select style="width: 450;" collection="resources" property="resource" insertable="false" updatable="false" styleId="res">

				<html:options collection="resources" property="resource" labelProperty="name"/>

		   	</july:select>

		</td>

    </tr>

	

	<july:separator colspan="<%= gColSpan %>"/>

	

	<tr>

		<td class="text"><july:reqmark><bean:message key="label.contractcalc.dates"/>:</july:reqmark></td>

		<td class="text">

			<july:date property="begindateFrm" size="25" insertable="false" updatable="false" styleId="begindateFrm"/>&nbsp;

			<bean:message key="label.filter.stop"/>&nbsp;

			<july:date property="enddateFrm" size="25" insertable="false" updatable="false" styleId="enddateFrm"/>

		</td>

	</tr>

	

	<july:separator colspan="<%= gColSpan %>"/>

	

	<tr>

		<td class="text"><july:reqmark><bean:message key="label.contractcalc.userdates"/>:</july:reqmark></td>

		<td class="text">

			<july:date property="userbegindateFrm" size="25" insertable="false" updatable="false"/>&nbsp;

			<bean:message key="label.filter.stop"/>&nbsp;

			<july:date property="userenddateFrm" size="25" insertable="false" updatable="false"/>

		</td>

	</tr>

	

	<july:separator colspan="<%= gColSpan %>"/>

	

	<tr>

		<td class="text"><july:reqmark><bean:message key="label.contractcalc.lastsaldodate"/>:</july:reqmark></td>

		<td class="text">

			<july:date property="lastsaldodateFrm" size="25" insertable="false" updatable="false" styleId="lastsaldodateFrm"/>

		</td>

	</tr>

	

	<july:separator colspan="<%= gColSpan %>"/>

	

	<tr>

		<td class="text"><bean:message key="label.contractcalc.lastsaldodatetemp"/>:</td>

		<td class="text">

			<july:date property="lastsaldodatetempFrm" size="25" insertable="false" updatable="false" styleId="lastsaldodatetempFrm"/>

		</td>

	</tr>



	<july:separator colspan="<%= gColSpan %>"/>

	

	<tr>

		<td class="text"><bean:message key="label.contractcalc.lastsaldocalctemp"/>:</td>

		<td class="text">

			<logic:equal name="<%= form %>" property="isCalctemp" value="true">

				<july:date property="lastsaldocalctempFrm" size="25" insertable="false" updatable="false" styleId="lastsaldocalctempFrm"/>

			</logic:equal>

		</td>

	</tr>

	

	<july:separator colspan="<%= gColSpan %>"/>

	

	<logic:equal name="<%= form %>" property="isExistReglament" value="true">

	

		<tr>

			<td class="text"><bean:message key="label.contractcalc.calcsaldo"/>:</td>

			<td class="text">&nbsp;</td>

		</tr>

		

		<tr>

			<td class="text" colspan="2">

				<july:radio property="actionType" insertable="true" updatable="true" value="A"/>&nbsp;<bean:message key="label.contractcalc.deltempsaldo"/>&nbsp;

				<july:radio property="actionType" insertable="true" updatable="true" value="B"/>&nbsp;<bean:message key="label.contractcalc.calcfordate"/>&nbsp;

				<july:date property="calcfordateFrm" size="25" insertable="true" updatable="true"/>&nbsp;

				<july:radio property="actionType" insertable="true" updatable="true" value="C"/>&nbsp;<bean:message key="label.contractcalc.leaveasis"/>

			</td>

		</tr>

		

		<tr>

			<td class="text" colspan="2">

				<july:checkbox property="isShowdocpos" insertable="true" updatable="true"/>&nbsp;<bean:message key="label.contractcalc.isshowdocpos"/>

			</td>

		</tr>

		

		<tr>

			<td class="text" colspan="2">

				<july:radio property="actionForm" insertable="true" updatable="true" value="A"/>&nbsp;<bean:message key="label.contractcalc.form1"/>&nbsp;

				<july:radio property="actionForm" insertable="true" updatable="true" value="B"/>&nbsp;<bean:message key="label.contractcalc.form2"/>

			</td>

		</tr>

		

	</logic:equal>

	

	<logic:equal name="<%= form %>" property="isExistReglament" value="false">

	

		<tr>

			<td class="text" colsapn="2"><bean:message key="error.calccontract.noreglament"/></td>

		</tr>

	

	</logic:equal>

		

	<july:separator colspan="<%= gColSpan %>"/>

	<july:formbuttons/>

	<july:separator colspan="<%= gColSpan %>"/>

</table>

</july:editform>

