<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.arenda.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>


<% String gColSpan = "2"; %>


<%
    String action = null;
	String form = null;
	String parent = null;
	String parent2 = null;
	String parent3 = null;
	String parent4 = null;
	switch (ParamsParser.getState(pageContext)) {
		case APPStates.MUTUAL_RULE_EDIT:
        	action = "/ProcessMutualRule.do";
			form = "MutualRuleForm";
			parent2 = "/ShowMutualReglamentsList.do";
			parent3 = "/ViewMainParamsMutReglmnt.do";
			parent4 = "/ShowMutualRulesList.do";
        	break;
		case APPStates.FROMCONTRACT_MUTUAL_RULE_EDIT:
        	action = "/ProcessFromContractMutualRule.do";
			form = "FromContractMutualRuleForm";
			parent = "/ViewWeArenda.do";
			parent2 = "/ShowFromContractMutualReglamentsList.do";
			parent3 = "/ViewFromContractMainParamsMutReglmnt.do";
			parent4 = "/ShowFromContractMutualRulesList.do";
        	break;
		case APPStates.FROMHISTORY_MUTUAL_RULE_EDIT:
        	action = "/ProcessFromHistoryMutualRule.do";
			form = "FromHistoryMutualRuleForm";
			parent = "/ViewHistory.do";
			parent2 = "/ShowFromHistoryMutualReglamentsList.do";
			parent3 = "/ViewFromHistoryMainParamsMutReglmnt.do";
			parent4 = "/ShowFromHistoryMutualRulesList.do";
        	break;
    }
%>


<july:editform action="<%= action %>" styleId="<%= form %>">


<html:hidden property="reglamentcode"/>


<table class="main" style="font-size: 8pt">
<%--
<tr class="title">
		<td class="title" colspan="<%= gColSpan %>">
			<%	if (ParamsParser.getState(pageContext) == APPStates.FROMCONTRACT_MUTUAL_RULE_EDIT ||
				ParamsParser.getState(pageContext) == APPStates.FROMHISTORY_MUTUAL_RULE_EDIT) { %>
				<html:link page="/ShowWeArendaList.do" styleClass="navigator"><bean:message key="label.we"/></html:link>
				<july:sepmark/>
				<%	if (ParamsParser.getState(pageContext) == APPStates.FROMHISTORY_MUTUAL_RULE_EDIT) { %>
					<html:link page="/ShowHistoryList.do" styleClass="navigator"><bean:message key="label.history"/></html:link>
					<july:sepmark/>
	        	<% } %>
				<july:editlink page="<%= parent %>" action="View" styleClass="navigator">
					<bean:message key="label.view"/>
				</july:editlink>
				<july:sepmark/>
			<%	} %>
			<html:link page="<%= parent2 %>" styleClass="navigator"><bean:message key="label.mutualreglmnts"/></html:link>
			<july:sepmark/>
			<july:editlink page="<%= parent3 %>" action="View" styleClass="navigator">
				<bean:message key="label.view"/>
			</july:editlink>
			<july:sepmark/>
			<html:link page="<%= parent4 %>" styleClass="navigator"><bean:message key="label.mutualrules"/></html:link>
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
		<td class="text">
			Номер и дата регламента:
		</td>
		<td class="text">
			<july:string size="20" style="font-size: 8pt" property="documentNumber" insertable="false" updatable="false"/>&nbsp;&nbsp;
			<july:date property="documentDateFrm" size="25" style="font-size: 8pt" insertable="false" updatable="false"/>
		</td>
	</tr>


	<%--july:separator colspan="<%= gColSpan %>"/>


	<tr>
		<td class="text"><july:reqmark><bean:message key="label.mutualreglmnts.docdate"/>:</july:reqmark></td>
		<td class="text">
			<july:date property="documentDateFrm" size="25" style="font-size: 8pt" insertable="false" updatable="false"/>
		</td>
	</tr--%>
	
	<july:separator colspan="<%= gColSpan %>"/>	
	
	<tr>
		<td class="text">
			<bean:message key="label.mutualreglmnts.acttype"/>:
		</td>
		<td class="text">
			<logic:present name="<%= form%>" property="actType">
				<logic:equal name="<%= form %>" property="actType" value="A"><bean:message key="label.mutualreglmnts.acttype.vz"/></logic:equal>
				<logic:equal name="<%= form %>" property="actType" value="M"><bean:message key="label.mutualreglmnts.acttype.vt"/></logic:equal>
				<logic:equal name="<%= form %>" property="actType" value="S"><bean:message key="label.mutualreglmnts.acttype.sv"/></logic:equal>
			</logic:present>
		</td>
	</tr>


	<july:separator colspan="<%= gColSpan %>"/>


	<tr>
		<td class="text"><bean:message key="label.mutualreglmnts.mutualperiod"/>:</td>
		<td class="text">
			<logic:present name="<%= form%>" property="mutualPeriod">
				<logic:equal name="<%= form %>" property="mutualPeriod" value="M"><bean:message key="label.mutualreglmnts.mutualperiod.month"/></logic:equal>
				<logic:equal name="<%= form %>" property="mutualPeriod" value="Q"><bean:message key="label.mutualreglmnts.mutualperiod.quarter"/></logic:equal>
			</logic:present>
		</td>
	</tr>
		
	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<td class="text"><bean:message key="label.mutualreglmnts.maincurrency"/>:</td>
		<td class="text">
			<july:string style="font-size: 8pt" size="20" property="mainCurrency" insertable="false" updatable="false"/>
		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>


	<%--logic:present name="<%= form %>" property="additionalCurrency">
		<tr>
			<td class="text"><bean:message key="label.mutualreglmnts.additionalcurrency"/>:</td>
			<td class="text">
				<july:string style="font-size: 8pt" size="20" property="additionalCurrency" insertable="false" updatable="false"/>
			</td>
		</tr>
		<july:separator colspan="<%= gColSpan %>"/>
	</logic:present--%>	
	
	<%--tr>
		<td class="text"><july:reqmark><bean:message key="label.mutualreglmnts.commonrate"/>:</july:reqmark></td>
		<td class="text">
			<july:checkbox property="commonRate" insertable="false" updatable="false"/>
		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/--%>
	
	<logic:equal name="<%= form %>" property="commonRate" value="true">
		<tr>
			<td class="text"><bean:message key="label.mutualreglmnts.calcratetype.all"/>:</td>
			<td class="text">
				<logic:present name="<%= form %>" property="calcRateType">
					<july:radio property="calcRateType" insertable="false" updatable="false" value="B"/><bean:message key="label.mutualreglmnts.calcratetype.begin"/>
					<july:radio property="calcRateType" insertable="false" updatable="false" value="E"/><bean:message key="label.mutualreglmnts.calcratetype.end"/>
				</logic:present>
			</td>
		</tr>
	</logic:equal>
	
	<logic:equal name="<%= form %>" property="commonRate" value="false">


		<tr>
			<td class="text" colspan="2"><bean:message key="label.mutualreglmnts.calcratetype.one"/></td>
		</tr>
	
	</logic:equal>


	<july:separator colspan="<%= gColSpan %>"/>


	<tr>
		<td class="text"><july:reqmark><bean:message key="label.mutualreglmnts.resource"/>:</july:reqmark></td>
		<td class="text">
			<logic:equal name="<%= form %>" property="action" value="Add">
			    <july:select style="width: 400; font-size: 8pt" collection="resources" property="resourcecode" insertable="true" updatable="true">
					<html:options collection="resources" property="resource" labelProperty="name"/>
			   	</july:select>
			</logic:equal>
			<logic:notEqual name="<%= form %>" property="action" value="Add">
			    <july:select style="width: 400; font-size: 8pt" collection="resources" property="resourcecode" insertable="false" updatable="false">
					<html:options collection="resources" property="resource" labelProperty="name"/>
			   	</july:select>
			</logic:notEqual>
		</td>
    </tr>


	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<td class="text"><july:reqmark><bean:message key="label.mutualrules.paydaterule"/>:</july:reqmark></td>
		<td class="text">
			<july:radio property="paydaterule" insertable="true" updatable="true" value="A"/><bean:message key="label.mutualrules.paydaterule.date"/><br>
			<july:radio property="paydaterule" insertable="true" updatable="true" value="B"/><bean:message key="label.mutualrules.paydaterule.begin"/><br>
			<july:radio property="paydaterule" insertable="true" updatable="true" value="C"/><bean:message key="label.mutualrules.paydaterule.end"/><br>
			<july:radio property="paydaterule" insertable="true" updatable="true" value="K"/>на дату акта
		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>


	<tr>
		<td class="text"><july:reqmark><bean:message key="label.mutualrules.chargedaterule"/>:</july:reqmark></td>
		<td class="text">
			<july:radio property="chargedaterule" insertable="true" updatable="true" value="A"/><bean:message key="label.mutualrules.chargedaterule.date"/><br>
			<july:radio property="chargedaterule" insertable="true" updatable="true" value="B"/><bean:message key="label.mutualrules.chargedaterule.begin"/><br>
			<july:radio property="chargedaterule" insertable="true" updatable="true" value="C"/><bean:message key="label.mutualrules.chargedaterule.end"/><br>
			<%--<july:radio property="chargedaterule" insertable="true" updatable="true" value="D"/><bean:message key="label.mutualrules.chargedaterule.d"/><br>--%>
			<july:radio property="chargedaterule" insertable="true" updatable="true" value="E"/><bean:message key="label.mutualrules.chargedaterule.e"/><br>
			<july:radio property="chargedaterule" insertable="true" updatable="true" value="F"/><bean:message key="label.mutualrules.chargedaterule.f"/><br>
			<july:radio property="chargedaterule" insertable="true" updatable="true" value="H"/><bean:message key="label.mutualrules.chargedaterule.h"/><br>
			<july:radio property="chargedaterule" insertable="true" updatable="true" value="J"/><bean:message key="label.mutualrules.chargedaterule.j"/><br>
			<july:radio property="chargedaterule" insertable="true" updatable="true" value="K"/>на дату акта
		</td>
	</tr>
	
     <TR>
        <td class="text"><july:reqmark>Тип курса:</july:reqmark></td>
        <td class="text">
 			<july:select  style="width:200; font-size: 8pt" styleClass="seach" collection="rateTypes" property="rateType" insertable="true" updatable="true">
 				<html:option value="" >&nbsp;</html:option>
				<html:options collection="rateTypes" property="ratetype" labelProperty="name"/>
			</july:select>
        </td>
     </TR>	


	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<td class="text"><july:reqmark><bean:message key="label.mutualrules.dopchargdatrul"/>:</july:reqmark></td>
		<td class="text">
			<july:checkbox property="dopchargdatrul" insertable="true" updatable="true"/>
		</td>
	</tr>


	<july:separator colspan="<%= gColSpan %>"/>
	
	<july:formbuttons/>

	<july:separator colspan="<%= gColSpan %>"/>

</table>

</july:editform>
