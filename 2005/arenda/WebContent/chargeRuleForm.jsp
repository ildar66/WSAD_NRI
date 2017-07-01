<%@ page language = "java" %> <%@ page contentType = "TEXT/HTML; charset=windows-1251" %> <%@ page import="com.hps.july.web.util.*,com.hps.july.arenda.*" %> <%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %> <%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %> <%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %> <%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<% java.lang.String gColSpan = "2"; %>
<%
    String action = null; 	String form = null; 	String parent = null; 	String parent2 = null; 	String temp = null;
	switch (ParamsParser.getState(pageContext)) {
		case APPStates.CHARGE_RULE_EDIT:
        	action = "/ProcessChargeRule.do";
			form = "ChargeRuleForm";
			parent = "/ViewWeArenda.do";
			parent2 = "/ShowChargeRulesList.do";
        	break;
		case APPStates.HISTORY_CHARGE_RULE_EDIT:
        	action = "/ProcessHistoryChargeRule.do";
			form = "HistoryChargeRuleForm";
			parent = "/ViewHistory.do";
			parent2 = "/ShowHistoryChargeRulesList.do";
        	break;
    }
%>


<july:editform action="<%= action %>" styleId="<%= form %>">
<html:hidden property="leaseDocumentcode"/> <html:hidden property="leaseRule"/>
<table class="main">
<%-- <tr class="title">
		<td class="title" colspan="<%= gColSpan %>">
			<html:link page="/ShowWeArendaList.do" styleClass="navigator"><bean:message key="label.we"/></html:link>
			<july:sepmark/>
			<% if (ParamsParser.getState(pageContext) == APPStates.HISTORY_CHARGE_RULE_EDIT) { %>
				<html:link page="/ShowHistoryList.do" styleClass="navigator"><bean:message key="label.history"/></html:link>
				<july:sepmark/>
			<% } %>
			<july:editlink page="<%= parent %>" action="View" paramId="leaseDocument" paramName="<%= form %>" paramProperty="leaseDocumentcode" styleClass="navigator">
				<bean:message key="label.view"/>
			</july:editlink>
			<july:sepmark/>
			<html:link page="<%= parent2 %>" styleClass="navigator"><bean:message key="label.chargerules"/></html:link>
			<july:sepmark/>
			<july:actionname/></td>
	</tr> --%>

   <july:separator colspan="<%= gColSpan %>"/>     <tr>         <td class="title" colspan="<%= gColSpan %>"><july:actionalert/></td>     </tr>
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
		<td class="text">
			<july:reqmark><bean:message key="label.filter.customer"/>:</july:reqmark>
		</td>
		<td class="text">
			<july:string size="50" property="orgCustomer" insertable="false" updatable="false"/>
		</td>
	</tr>


	<july:separator colspan="<%= gColSpan %>"/>


	<tr>
		<td class="text">
			<july:reqmark><bean:message key="label.filter.executor"/>:</july:reqmark>
		</td>
		<td class="text">
			<july:string size="50" property="orgExecutor" insertable="false" updatable="false"/>
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
		<td class="text"><july:reqmark><bean:message key="label.chargerules.resource"/>:</july:reqmark></td>
		<td class="text">
		    <july:select style="width: 450;" collection="resources" property="resourcecode" insertable="true" updatable="true">
				<logic:equal name="<%= form %>" property="action" value="Add">
					<html:option value="">&nbsp;</html:option>
				</logic:equal>
				<html:options collection="resources" property="resource" labelProperty="name"/>
		   	</july:select>
		</td>
    </tr>


	<july:separator colspan="<%= gColSpan %>"/>


	<tr>
		<td class="text"><july:reqmark><bean:message key="label.chargerules.period"/>:</july:reqmark></td>
		<td class="text">
			<july:radio property="chargePeriod" insertable="true" updatable="true" value="M"/><bean:message key="label.chargerules.period.month"/>
			<july:radio property="chargePeriod" insertable="true" updatable="true" value="Q"/><bean:message key="label.chargerules.period.quarter"/>
			<july:radio property="chargePeriod" insertable="true" updatable="true" value="Y"/><bean:message key="label.chargerules.period.year"/>
	</tr>


	<july:separator colspan="<%= gColSpan %>"/>


	<tr>
		<td class="text"><july:reqmark><bean:message key="label.chargerules.sum"/>:</july:reqmark></td>
		<td class="text">
			<july:string size="25" property="sumFrm" insertable="true" updatable="true"/>&nbsp;
		    <july:select style="width: 200;" collection="currencies" property="currencycode" insertable="true" updatable="true">
				<html:options collection="currencies" property="currency" labelProperty="name"/>
		   	</july:select>
		</td>
	</tr>


	<july:separator colspan="<%= gColSpan %>"/>


	<tr>
		<td class="text"><july:reqmark><bean:message key="label.chargerules.daterule"/>:</july:reqmark></td>
		<td class="text">
			<july:radio property="chargeDateRule" insertable="true" updatable="true" value="S"/><bean:message key="label.chargerules.daterule.startperiod"/>
			<july:radio property="chargeDateRule" insertable="true" updatable="true" value="E"/><bean:message key="label.chargerules.daterule.endperiod"/>
		</td>
    </tr>


	<july:separator colspan="<%= gColSpan %>"/>
	<july:formbuttons/>
	<july:separator colspan="<%= gColSpan %>"/>
</table>
</july:editform>

