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
	String edit = null;
	String parent2 = null;
	String phones = null;
	String contracts = null;
	String rules = null;
	String copyReglament = null;
	String priority = null;
	String isEdit = null;
	switch (ParamsParser.getState(pageContext)) {
		case APPStates.MAINPARAMS_MUTREGLMNT_EDIT:
        	action = "/ProcessMainParamsMutReglmnt.do";
			form = "MainParamsMutReglmntForm";
			edit = "/EditMainParamsMutReglmnt.do"; /*может ViewMainParamsMutReglmnt??? */
			parent2 = "/ShowMutualReglamentsList.do";
			phones = "/ShowPhonesMutReglmntList.do";
			contracts = "/ShowContractsMutReglmntList.do";
			rules = "/ShowMutualRulesList.do";
			copyReglament = "/EditCopyReglament.do";
			priority = "/ShowMRCntPriorsList.do";
        	break;
		case APPStates.FROMCONTRACT_MAINPARAMS_MUTREGLMNT_EDIT:
        	action = "/ProcessFromContractMainParamsMutReglmnt.do";
			form = "FromContractMainParamsMutReglmntForm";
			parent = "/ViewWeArenda.do";
			edit = "/EditFromContractMainParamsMutReglmnt.do";
			parent2 = "/ShowFromContractMutualReglamentsList.do";
			phones = "/ShowFromContractPhonesMutReglmntList.do";
			contracts = "/ShowFromContractContractsMutReglmntList.do";
			rules = "/ShowFromContractMutualRulesList.do";
			copyReglament = "/EditFromContractCopyReglament.do";
			priority = "/ShowFromContractMRCntPriorsList.do";
        	break;
		case APPStates.FROMHISTORY_MAINPARAMS_MUTREGLMNT_EDIT:
        	action = "/ProcessFromHistoryMainParamsMutReglmnt.do";
			form = "FromHistoryMainParamsMutReglmntForm";
			parent = "/ViewHistory.do";
			edit = "/EditFromHistoryMainParamsMutReglmnt.do";
			parent2 = "/ShowFromHistoryMutualReglamentsList.do";
			phones = "/ShowFromHistoryPhonesMutReglmntList.do";
			contracts = "/ShowFromHistoryContractsMutReglmntList.do";
			rules = "/ShowFromHistoryMutualRulesList.do";
			copyReglament = "/EditFromHistoryCopyReglament.do";
			priority = "/ShowFromHistoryMRCntPriorsList.do";
        	break;
    }
%>


<july:editform action="<%= action %>" styleId="<%= form %>">


<html:hidden property="leaseDocument"/>
<html:hidden property="minDateFrm"/>
<html:hidden property="maxDateFrm"/>
<html:hidden property="minDateFrmToo"/>
<html:hidden property="maxDateFrmToo"/>


<script language="javascript">
function switchCommonRate() {
	if (document.all.commonRate[0].checked) {
		<%= form %>.crt1.className = 'editkod';
		<%= form %>.crt1.disabled = false;
		<%= form %>.crt2.className = 'editkod';
		<%= form %>.crt2.disabled = false;
	} else {
		<%= form %>.crt1.className = 'editkoddisabled';
		<%= form %>.crt1.disabled = true;
		<%= form %>.crt2.className = 'editkoddisabled';
		<%= form %>.crt2.disabled = true;
	}
}
function switchAddcurrency() {
	if (document.all.isAddcurrency[0].checked) {
		<%= form %>.addCurrency.className = 'edit';
		<%= form %>.addCurrency.disabled = false;
	} else {
		<%= form %>.addCurrency.className = 'editdisabled';
		<%= form %>.addCurrency.disabled = true;
	}
}
function switchMin() {
	<%= form %>.startdate_dt.gDate = document.all.minDateFrm.value;
	<%= form %>.startdate.value = document.all.minDateFrmToo.value;
}
function switchMax() {
	<%= form %>.enddate_dt.gDate = document.all.maxDateFrm.value;
	<%= form %>.enddate.value = document.all.maxDateFrmToo.value;
}
</script>

<logic:equal name="<%= form %>" property="mutState" value="A">
	<% isEdit = "true"; %>
</logic:equal>
<logic:notEqual name="<%= form %>" property="mutState" value="A">
	<% isEdit = "false"; %>
</logic:notEqual>

<table class="main" style="font-size: 8pt">

<july:separator colspan="<%= gColSpan %>"/>

<tr>
	<td class="title" colspan="<%= gColSpan %>"><july:actionalert/></td>
</tr>

<july:separator colspan="<%= gColSpan %>"/>
	
<logic:equal name="<%= form %>" property="isShowMessage" value="1">
<tr>
	<td class="title" colspan="<%= gColSpan %>"><bean:message key="label.mutualreglmnts.showmessage"/></td>
</tr>

<july:separator colspan="<%= gColSpan %>"/>
</logic:equal>

<logic:equal name="<%= form %>" property="action" value="View">
<tr>
	<td class="text" colspan="2"><bean:message key="label.actions"/>:&nbsp;&nbsp;
		<july:canedit rolesProperty="editRoles">
			<logic:notEqual name="<%= form %>" property="mutState" value="C">
				<july:editlink page="<%= edit %>" action="Edit&isShowMessage=0" paramId="leaseDocument" paramName="<%= form %>" paramProperty="leaseDocument" styleClass="button">
					<bean:message key="label.mainparams"/>
				</july:editlink>
			</logic:notEqual>
		</july:canedit>
			
		<july:link page="<%= contracts %>" paramId="mainLeaseDocument" paramName="<%= form %>" paramProperty="leaseDocument" styleClass="button">
			<bean:message key="label.mutualreglmnts.contracts"/>
		</july:link>
			
		<logic:equal name="<%= form %>" property="commonRate" value="false">
			<july:link page="<%= rules %>" paramId="leaseDocument" paramName="<%= form %>" paramProperty="leaseDocument" styleClass="button">
				<bean:message key="label.mutualreglmnts.rules"/>
			</july:link>
		</logic:equal>
<%--			
		<logic:notEqual name="<%= form %>" property="actType" value="S">
			<july:link page="<%= phones %>" paramId="leaseDocument" paramName="<%= form %>" paramProperty="leaseDocument">
				<bean:message key="label.mutualreglmnts.phones"/>
			</july:link>
			
			<logic:equal name="<%= form %>" property="isExistPriority" value="true">
				<july:link page="<%= priority %>" paramId="reglamentcode" paramName="<%= form %>" paramProperty="leaseDocument">
					<bean:message key="label.mrcntprior"/>
				</july:link>
			</logic:equal>
		</logic:notEqual>
--%>			
		<july:canedit rolesProperty="editRoles">
			<july:link page="<%= copyReglament %>" styleClass="button"><bean:message key="label.mutualreglmnts.copy"/></july:link>
		</july:canedit>
        </td>
</tr>

<july:separator/>
</logic:equal>

<logic:notEqual name="<%= form %>" property="action" value="Add">
<tr>
	<td class="text">
		<july:reqmark><bean:message key="label.mutualreglmnts.docnumber"/>:</july:reqmark>
	</td>
	<td class="text">
		<july:string size="10" property="documentNumber" insertable="false" updatable="false"/>&nbsp;от&nbsp; 
		<july:date style="vertical-align: top;" property="documentDateFrm" size="25" insertable="<%= isEdit %>" updatable="<%= isEdit %>"/>
		<%--july:date style="vertical-align: top;" property="documentDateFrm" size="25" insertable="false" updatable="false"/--%>
	</td>
</tr>
		
<july:separator colspan="<%= gColSpan %>"/>
</logic:notEqual>

<%--logic:equal name="<%= form %>" property="action" value="Add">
<tr>
	<td class="text"><july:reqmark><bean:message key="label.mutualreglmnts.docdate"/>:</july:reqmark></td>
	<td class="text">
		<july:date property="documentDateFrm" size="25" insertable="<%= isEdit %>" updatable="<%= isEdit %>"/>
	</td>
</tr>
	<july:separator colspan="<%= gColSpan %>"/>
</logic:equal--%>	
	
	<tr>
		<td class="text">
			<july:reqmark><bean:message key="label.mutualreglmnts.acttype"/>:</july:reqmark>
		</td>
		<td class="text">
			<logic:equal name="<%= form %>" property="action" value="View">
				<logic:equal name="<%= form %>" property="actType" value="A"><bean:message key="label.mutualreglmnts.acttype.vz"/></logic:equal>
				<logic:equal name="<%= form %>" property="actType" value="M"><bean:message key="label.mutualreglmnts.acttype.vt"/></logic:equal>
				<logic:equal name="<%= form %>" property="actType" value="S"><bean:message key="label.mutualreglmnts.acttype.sv"/></logic:equal>
			</logic:equal>
			<logic:notEqual name="<%= form %>" property="action" value="View">
			    <july:select style="width: 250;" property="actType" insertable="<%= isEdit %>" updatable="<%= isEdit %>">
					<html:option value="A"><bean:message key="label.mutualreglmnts.acttype.vz"/></html:option>
					<html:option value="M"><bean:message key="label.mutualreglmnts.acttype.vt"/></html:option>
					<html:option value="S"><bean:message key="label.mutualreglmnts.acttype.sv"/></html:option>
			   	</july:select>			
			</logic:notEqual>
		</td>
	</tr>
	<july:separator colspan="<%= gColSpan %>"/>


	<tr>
		<td class="text"><july:reqmark>Основная валюта акта:</july:reqmark></td>
		<td class="text">
		    <july:select style="width: 150;" collection="currencies" property="maincurrencycode" insertable="<%= isEdit %>" updatable="<%= isEdit %>">
				<html:option value="0">&nbsp;</html:option>
				<html:options collection="currencies" property="currency" labelProperty="name"/>
		   	</july:select>&nbsp;
<%--		   	
		   	Доп.валюта:
			<july:checkbox property="isAddcurrency" insertable="<%= isEdit %>" updatable="<%= isEdit %>" onclick="switchAddcurrency()"/>&nbsp;
			<july:select style="width: 150;" collection="currencies" property="additionalCurrencycode" insertable="<%= isEdit %>" updatable="<%= isEdit %>" styleId="addCurrency">
				<html:option value="0">&nbsp;</html:option>
				<html:options collection="currencies" property="currency" labelProperty="name"/>
		   	</july:select>
--%>		   			   	
		</td>
	</tr>
	<july:separator colspan="<%= gColSpan %>"/>
	
	<%--tr>
		<td class="text"><bean:message key="label.mutualreglmnts.additionalcurrency"/>:</td>
		<td class="text">
			<july:checkbox property="isAddcurrency" insertable="<%= isEdit %>" updatable="<%= isEdit %>" onclick="switchAddcurrency()"/>&nbsp;
			<july:select style="width: 200;" collection="currencies" property="additionalCurrencycode" insertable="<%= isEdit %>" updatable="<%= isEdit %>" styleId="addCurrency">
				<html:option value="0">&nbsp;</html:option>
				<html:options collection="currencies" property="currency" labelProperty="name"/>
		   	</july:select>
		</td>
	</tr>
	<july:separator colspan="<%= gColSpan %>"/--%>
	
	<tr>
		<td class="text">Период действия регламента:</july:reqmark></td>
		<td class="text">
			<july:date property="startdateFrm" size="25" insertable="true" updatable="true" styleId="startdate"/>
			<logic:notEqual name="<%= form %>" property="action" value="View">
				<logic:notEqual name="<%= form %>" property="action" value="Delete">
					&nbsp;<img src='/images/obchet1.gif' onclick='switchMin()' border='0' alt='<bean:message key="label.mutualreglmnts.startdate.min"/>'>
				</logic:notEqual>
			</logic:notEqual> &nbsp;&nbsp; 
			<july:date property="enddateFrm" size="25" insertable="true" updatable="true" styleId="enddate"/>
			<logic:notEqual name="<%= form %>" property="action" value="View">
				<logic:notEqual name="<%= form %>" property="action" value="Delete">
					&nbsp;<img src='/images/obchet1.gif' onclick='switchMax()' border='0' alt='<bean:message key="label.mutualreglmnts.enddate.max"/>'>
				</logic:notEqual>
			</logic:notEqual>			
		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>
	
	<%--tr>
		<td class="text"><july:reqmark><bean:message key="label.mutualreglmnts.enddate"/>:</july:reqmark></td>
		<td class="text">
			<july:date property="enddateFrm" size="25" insertable="true" updatable="true" styleId="enddate"/>
			<logic:notEqual name="<%= form %>" property="action" value="View">
				<logic:notEqual name="<%= form %>" property="action" value="Delete">
					&nbsp;<img src='/images/obchet1.gif' onclick='switchMax()' border='0' alt='<bean:message key="label.mutualreglmnts.enddate.max"/>'>
				</logic:notEqual>
			</logic:notEqual>
		</td>
	</tr>
	<july:separator colspan="<%= gColSpan %>"/--%>
	
	<tr>
		<td class="text"><july:reqmark><bean:message key="label.mutualreglmnts.state"/>:</july:reqmark></td>
		<td class="text">
			<logic:equal name="<%= form %>" property="mutState" value="A"><bean:message key="label.state.prepared"/></logic:equal>
			<logic:equal name="<%= form %>" property="mutState" value="B"><bean:message key="label.state.continued"/></logic:equal>
			<logic:equal name="<%= form %>" property="mutState" value="C"><bean:message key="label.state.stoped"/></logic:equal>
		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<td class="text"><july:reqmark><bean:message key="label.mutualreglmnts.mutualperiod"/>:</july:reqmark></td>
		<td class="text">
			<logic:equal name="<%= form %>" property="action" value="View">
				<logic:equal name="<%= form %>" property="mutualPeriod" value="M"><bean:message key="label.mutualreglmnts.mutualperiod.month"/></logic:equal>
				<logic:equal name="<%= form %>" property="mutualPeriod" value="Q"><bean:message key="label.mutualreglmnts.mutualperiod.quarter"/></logic:equal>
				<logic:equal name="<%= form %>" property="mutualPeriod" value="Y"><bean:message key="label.mutualreglmnts.mutualperiod.year"/></logic:equal>
			</logic:equal>
			<logic:notEqual name="<%= form %>" property="action" value="View">
				<july:radio property="mutualPeriod" insertable="<%= isEdit %>" updatable="<%= isEdit %>" value="M"/><bean:message key="label.mutualreglmnts.mutualperiod.month"/>
				<july:radio property="mutualPeriod" insertable="<%= isEdit %>" updatable="<%= isEdit %>" value="Q"/><bean:message key="label.mutualreglmnts.mutualperiod.quarter"/>
				<july:radio property="mutualPeriod" insertable="<%= isEdit %>" updatable="<%= isEdit %>" value="Y"/><bean:message key="label.mutualreglmnts.mutualperiod.year"/>
			</logic:notEqual>
		</td>
	</tr>
		
	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<td class="text">
			<july:reqmark><bean:message key="label.mutualreglmnts.commonrate"/>:</july:reqmark>
			<july:checkbox property="commonRate" insertable="<%= isEdit %>" updatable="<%= isEdit %>" onclick="switchCommonRate()"/>&nbsp;&nbsp;
		</td>
		<td class="text">
			<logic:equal name="<%= form %>" property="action" value="View">
				<logic:present name="<%= form %>" property="calcRateType">
					<logic:equal name="<%= form %>" property="calcRateType" value="B"><bean:message key="label.mutualreglmnts.calcratetype.begin"/></logic:equal>
					<logic:equal name="<%= form %>" property="calcRateType" value="E"><bean:message key="label.mutualreglmnts.calcratetype.end"/></logic:equal>
				</logic:present>
			</logic:equal>
			<logic:notEqual name="<%= form %>" property="action" value="View">
				<july:radio styleId="crt1" property="calcRateType" insertable="<%= isEdit %>" updatable="<%= isEdit %>" value="B"/><bean:message key="label.mutualreglmnts.calcratetype.begin"/><br>
				<july:radio styleId="crt2" property="calcRateType" insertable="<%= isEdit %>" updatable="<%= isEdit %>" value="E"/><bean:message key="label.mutualreglmnts.calcratetype.end"/>
			</logic:notEqual>			
		</td>
	</tr>


	<july:separator colspan="<%= gColSpan %>"/>


	<%--tr>
		<td class="text"><bean:message key="label.mutualreglmnts.calcratetype"/>:</td>
		<td class="text">
			<logic:equal name="<%= form %>" property="action" value="View">
				<logic:present name="<%= form %>" property="calcRateType">
					<logic:equal name="<%= form %>" property="calcRateType" value="B"><bean:message key="label.mutualreglmnts.calcratetype.begin"/></logic:equal>
					<logic:equal name="<%= form %>" property="calcRateType" value="E"><bean:message key="label.mutualreglmnts.calcratetype.end"/></logic:equal>
				</logic:present>
			</logic:equal>
			<logic:notEqual name="<%= form %>" property="action" value="View">
				<july:radio styleId="crt1" property="calcRateType" insertable="<%= isEdit %>" updatable="<%= isEdit %>" value="B"/><bean:message key="label.mutualreglmnts.calcratetype.begin"/><br>
				<july:radio styleId="crt2" property="calcRateType" insertable="<%= isEdit %>" updatable="<%= isEdit %>" value="E"/><bean:message key="label.mutualreglmnts.calcratetype.end"/>
			</logic:notEqual>
		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/--%>
	
	<tr>
		<td class="text" width="200"><july:reqmark><bean:message key="label.mutualreglmnts.dutyraterule"/>:</july:reqmark></td>
		<td class="text">
			<logic:equal name="<%= form %>" property="action" value="View">
				<logic:equal name="<%= form %>" property="dutyraterule" value="A"><bean:message key="label.mutualreglmnts.dutyraterule.a"/></logic:equal>
				<logic:equal name="<%= form %>" property="dutyraterule" value="B"><bean:message key="label.mutualreglmnts.dutyraterule.b"/></logic:equal>
			</logic:equal>
			<logic:notEqual name="<%= form %>" property="action" value="View">
				<july:radio property="dutyraterule" insertable="<%= isEdit %>" updatable="<%= isEdit %>" value="A"/><bean:message key="label.mutualreglmnts.dutyraterule.a"/><br>
				<july:radio property="dutyraterule" insertable="<%= isEdit %>" updatable="<%= isEdit %>" value="B"/><bean:message key="label.mutualreglmnts.dutyraterule.b"/>
			</logic:notEqual>
		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>
	
    <logic:equal name="<%= form %>" property="action" value="View">
		<jsp:include page="/mainParamsBrowses.jsp" flush="true"></jsp:include>	
    </logic:equal>
	
	<july:formbuttons/>
	
	<july:separator colspan="<%= gColSpan %>"/>


</table>


<logic:equal name="<%= form %>" property="action" value="Add">
	<script language="javascript">
		switchCommonRate();
		//switchAddcurrency();
	</script>
</logic:equal>
<logic:equal name="<%= form %>" property="action" value="Edit">
	<% if (isEdit.equals("true")) { %>
		<script language="javascript">
			switchCommonRate();
			//switchAddcurrency();
		</script>
	<% } %>
</logic:equal>


</july:editform>

