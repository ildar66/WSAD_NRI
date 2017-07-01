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
		case APPStates.REGLAMENT_CONTRACT_PRIOR_EDIT:
        	action = "/ProcessMRCntPriorForm.do";
			form = "MRCntPriorForm";
			parent2 = "/ShowMutualReglamentsList.do";
			parent3 = "/ViewMainParamsMutReglmnt.do";
			parent4 = "/ShowMRCntPriorsList.do";
        	break;
		case APPStates.FROMCONTRACT_REGLAMENT_CONTRACT_PRIOR_EDIT:
        	action = "/ProcessFromContractMRCntPriorForm.do";
			form = "FromContractMRCntPriorForm";
			parent = "/ViewWeArenda.do";
			parent2 = "/ShowFromContractMutualReglamentsList.do";
			parent3 = "/ViewFromContractMainParamsMutReglmnt.do";
			parent4 = "/ShowFromContractMRCntPriorsList.do";
        	break;
		case APPStates.FROMHISTORY_REGLAMENT_CONTRACT_PRIOR_EDIT:
        	action = "/ProcessFromHistoryMRCntPriorForm.do";
			form = "FromHistoryMRCntPriorForm";
			parent = "/ViewHistory.do";
			parent2 = "/ShowFromHistoryMutualReglamentsList.do";
			parent3 = "/ViewFromHistoryMainParamsMutReglmnt.do";
			parent4 = "/ShowFromHistoryMRCntPriorsList.do";
        	break;
    }
%>


<july:editform action="<%= action %>" styleId="<%= form %>">


<html:hidden property="reglamentcode"/>


<table class="main">
<%--
<tr class="title">
		<td class="title" colspan="<%= gColSpan %>">
			<%	if (ParamsParser.getState(pageContext) == APPStates.FROMCONTRACT_REGLAMENT_CONTRACT_PRIOR_EDIT ||
				ParamsParser.getState(pageContext) == APPStates.FROMHISTORY_REGLAMENT_CONTRACT_PRIOR_EDIT) { %>
				<html:link page="/ShowWeArendaList.do" styleClass="navigator"><bean:message key="label.we"/></html:link>
				<july:sepmark/>
				<%	if (ParamsParser.getState(pageContext) == APPStates.FROMHISTORY_REGLAMENT_CONTRACT_PRIOR_EDIT) { %>
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
			<july:editlink page="<%= parent3 %>" action="View" styleClass="navigator"><bean:message key="label.view"/></july:editlink>
			<july:sepmark/>
			<html:link page="<%= parent4 %>" styleClass="navigator"><bean:message key="label.mrcntprior"/></html:link>
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
			<july:reqmark><bean:message key="label.mutualreglmnts.docnumber"/>:</july:reqmark>
		</td>
		<td class="text">
			<july:string size="50" property="documentNumber" insertable="false" updatable="false"/>
		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<td class="text"><july:reqmark><bean:message key="label.mutualreglmnts.docdate"/>:</july:reqmark></td>
		<td class="text">
			<july:date property="documentDateFrm" size="25" insertable="false" updatable="false"/>
		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>	
	
	<tr>
		<td class="text">
			<july:reqmark><bean:message key="label.mutualreglmnts.acttype"/>:</july:reqmark>
		</td>
		<td class="text">
			<july:radio property="actType" insertable="false" updatable="false" value="A"/><bean:message key="label.mutualreglmnts.acttype.vz"/>
			<july:radio property="actType" insertable="false" updatable="false" value="M"/><bean:message key="label.mutualreglmnts.acttype.vt"/>
		</td>
	</tr>


	<july:separator colspan="<%= gColSpan %>"/>


	<tr>
		<td class="text"><july:reqmark><bean:message key="label.mutualreglmnts.mutualperiod"/>:</july:reqmark></td>
		<td class="text">
			<july:radio property="mutualPeriod" insertable="false" updatable="false" value="M"/><bean:message key="label.mutualreglmnts.mutualperiod.month"/>
			<july:radio property="mutualPeriod" insertable="false" updatable="false" value="Q"/><bean:message key="label.mutualreglmnts.mutualperiod.quarter"/>
		</td>
	</tr>
		
	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<td class="text"><july:reqmark><bean:message key="label.mutualreglmnts.maincurrency"/>:</july:reqmark></td>
		<td class="text">
			<july:string size="50" property="mainCurrency" insertable="false" updatable="false"/>
		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>


	<logic:present name="<%= form %>" property="additionalCurrency">
		<tr>
			<td class="text"><bean:message key="label.mutualreglmnts.additionalcurrency"/>:</td>
			<td class="text">
				<july:string size="50" property="additionalCurrency" insertable="false" updatable="false"/>
			</td>
		</tr>
		<july:separator colspan="<%= gColSpan %>"/>
	</logic:present>	
	
	<tr>
		<td class="text"><july:reqmark><bean:message key="label.mutualreglmnts.commonrate"/>:</july:reqmark></td>
		<td class="text">
			<july:checkbox property="commonRate" insertable="false" updatable="false"/>
		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>
	
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
		<td class="text"><july:reqmark><bean:message key="label.mrcntprior.contract"/>:</july:reqmark></td>
		<td class="text">
			<%--july:string property="contractcode1Frm" styleId="leaseDocumentcode1" size="5" insertable="true" updatable="true"/>
			<july:lookupbutton action="/ShowContractLookupList.do" styleId="conl1" fieldNames="leaseDocumentcode1" insertable="true" updatable="true"/><%-- ;documentNumber;documentDateFrm;orgCustomer;orgExecutor;contractTypename --%>
			
		    <july:select style="width: 200;" collection="contracts" property="contractcode1" insertable="true" updatable="true">
				<html:options collection="contracts" property="leaseDocument" labelProperty="documentNumber"/>
		   	</july:select>
		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<td class="text"><july:reqmark><bean:message key="label.mrcntprior.contract"/>:</july:reqmark></td>
		<td class="text">
			<%--july:string property="contractcode2Frm" styleId="leaseDocumentcode2" size="5" insertable="true" updatable="true"/>
			<july:lookupbutton action="/ShowContractLookupList.do" styleId="conl2" fieldNames="leaseDocumentcode2" insertable="true" updatable="true"/><%-- ;documentNumber;documentDateFrm;orgCustomer;orgExecutor;contractTypename --%>
			
		    <july:select style="width: 200;" collection="contracts" property="contractcode2" insertable="true" updatable="true">
				<html:options collection="contracts" property="leaseDocument" labelProperty="documentNumber"/>
		   	</july:select>
		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<td class="text"><july:reqmark><bean:message key="label.mrcntprior.priority"/>:</july:reqmark></td>
		<td class="text">
			<july:string property="priorityFrm" size="25" insertable="true" updatable="true"/>
		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>
	
	<july:formbuttons/>

	<july:separator colspan="<%= gColSpan %>"/>

</table>

</july:editform>

