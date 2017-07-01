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
		case APPStates.CONTRACT_MUTREGLMNT_EDIT:
        	action = "/ProcessContractMutReglmnt.do";
			form = "ContractMutReglmntForm";
			parent2 = "/ShowMutualReglamentsList.do";
			parent3 = "/ViewMainParamsMutReglmnt.do";
			parent4 = "/ShowContractsMutReglmntList.do";
        	break;
		case APPStates.FROMCONTRACT_CONTRACT_MUTREGLMNT_EDIT:
        	action = "/ProcessFromContractContractMutReglmnt.do";
			form = "FromContractContractMutReglmntForm";
			parent = "/ViewWeArenda.do";
			parent2 = "/ShowFromContractMutualReglamentsList.do";
			parent3 = "/ViewFromContractMainParamsMutReglmnt.do";
			parent4 = "/ShowFromContractContractsMutReglmntList.do";
        	break;
		case APPStates.FROMHISTORY_CONTRACT_MUTREGLMNT_EDIT:
        	action = "/ProcessFromHistoryContractMutReglmnt.do";
			form = "FromHistoryContractMutReglmntForm";
			parent = "/ViewHistory.do";
			parent2 = "/ShowFromHistoryMutualReglamentsList.do";
			parent3 = "/ViewFromHistoryMainParamsMutReglmnt.do";
			parent4 = "/ShowFromHistoryContractsMutReglmntList.do";
        	break;
    }
%>


<july:editform action="<%= action %>" styleId="<%= form %>">

<html:hidden property="reglamentcode"/>

<script language='javascript'>
function switchAllResources() {
	if (document.all.isAllResources[0].checked) {
		<%= form %>.res.className = 'editdisabled';
		<%= form %>.res.disabled = true;
	} else {
		<%= form %>.res.className = 'edit';
		<%= form %>.res.disabled = false;
	}
}
</script>


<table class="main">

	<july:separator colspan="<%= gColSpan %>"/>
	<tr> 		<td class="title" colspan="<%= gColSpan %>"><july:actionalert/></td> 	</tr>
	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text">
			<july:reqmark><bean:message key="label.mutualreglmnts.docnumber"/>:</july:reqmark>
		</td>
		<td class="text">
			<july:string size="50" property="mainDocumentNumber" insertable="false" updatable="false"/>
		</td>
	</tr>


	<july:separator colspan="<%= gColSpan %>"/>


	<tr>
		<td class="text"><july:reqmark><bean:message key="label.mutualreglmnts.docdate"/>:</july:reqmark></td>
		<td class="text">
			<july:date property="mainDocumentDateFrm" size="25" insertable="false" updatable="false"/>
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
			<july:radio property="mutualPeriod" insertable="false" updatable="false" value="Y"/><bean:message key="label.mutualreglmnts.mutualperiod.year"/>
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
		<td class="text"><july:reqmark><bean:message key="label.contract"/>:</july:reqmark></td>
		<td class="text">
			<input type="hidden" name="dummy" value=""/>
			<input type="hidden" name="contractType" value=""/>
			<html:hidden property="contractcodeFrm" styleId="leaseDocumentcode"/>
			<july:lookupbutton action="/ShowContractLookupList.do?isOnlyWe=false&contracttype=C" styleId="conl" fieldNames="leaseDocumentcode;documentNumber;documentDateFrm;orgCustomer;orgExecutor;contractTypename;dummy;dummy;contractType" onselect="checkContract();" insertable="true" updatable="true"/>
		</td>
	</tr>
	
	<tr>
		<td class="text"><bean:message key="label.filter.docnumber"/></td>
		<td class="text">
			<july:string size="50" property="documentNumber" styleId="documentNumber" insertable="false" updatable="false"/>
		</td>
	</tr>


	<tr>
		<td class="text"><bean:message key="label.filter.docdate"/></td>
		<td class="text">
			<july:date property="documentDateFrm" size="25" insertable="false" updatable="false"/>
		</td>
	</tr>
	
	<tr>
		<td class="text"><bean:message key="label.filter.doctype"/></td>
		<td class="text">
			<july:string property="contractTypename" size="50" insertable="false" updatable="false"/>
		</td>
	</tr>
	
	<tr>
		<td class="text"><bean:message key="label.mutualreglmnts.orgcustomer"/></td>
		<td class="text">
			<july:string size="50" property="orgCustomer" insertable="false" updatable="false"/>
		</td>
	</tr>


	<tr>
		<td class="text"><bean:message key="label.mutualreglmnts.orgexecutor"/></td>
		<td class="text">
			<july:string size="50" property="orgExecutor" insertable="false" updatable="false"/>
		</td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<td class="text"><july:reqmark><bean:message key="label.chargerules.resource"/>:</july:reqmark></td>
		<td class="text">
			<logic:equal name="<%= form %>" property="action" value="Add">
				<july:checkbox property="isAllResources" insertable="true" updatable="true" onclick="switchAllResources()"/>
				<bean:message key="label.filter.all"/>
			</logic:equal>
		    <july:select style="width: 450;" collection="resources" property="resourcecode" insertable="true" updatable="true" styleId="res">
				<html:options collection="resources" property="resource" labelProperty="name"/>
		   	</july:select>
		</td>
    </tr>
	
	<july:separator colspan="<%= gColSpan %>"/>
	<july:formbuttons/>
	<july:separator colspan="<%= gColSpan %>"/>
</table>
<logic:equal name="<%= form %>" property="action" value="Add">
	<script language='javascript'>
		switchAllResources();
	</script>
</logic:equal>

<script language="javascript">
function checkContract() {
	if(document.all.contractType.value == 'C') {
		document.all.isAllResources[0].checked = 'true';
		switchAllResources();
	}
}
</script>

</july:editform>

