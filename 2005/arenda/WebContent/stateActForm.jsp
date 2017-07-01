<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.arenda.*,com.hps.july.arenda.formbean.*" %>
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
	String parent3 = null;
	switch (ParamsParser.getState(pageContext)) {
		case APPStates.STATE_MUTACT_EDIT:
			action = "/ProcessActState.do";
			form = "ActStateForm";
			parent2 = "/ShowMutualReglamentsList.do";
			parent3 = "/ShowMutualActsList.do";
			break;
		case APPStates.FROMCONTRACT_STATE_MUTACT_EDIT:
			action = "/ProcessFromContractActState.do";
			form = "FromContractActStateForm";
			parent = "/ViewWeArenda.do";
			parent2 = "/ShowFromContractMutualReglamentsList.do";
			parent3 = "/ShowFromContractMutualActsList.do";
			break;
		case APPStates.FROMHISTORY_STATE_MUTACT_EDIT:
			action = "/ProcessFromHistoryActState.do";
			form = "FromHistoryActStateForm";
			parent = "/ViewHistory.do";
			parent2 = "/ShowFromHistoryMutualReglamentsList.do";
			parent3 = "/ShowFromHistoryMutualActsList.do";
			break;
	}
%>


<july:editform action="<%= action %>" styleId="<%= form %>">


<html:hidden property="leaseDocument"/>
<html:hidden property="initialState"/>
<html:hidden property="ignoreWarning"/>


<table class="main">


    <%--july:separator colspan="<%= gColSpan %>"/>
    
    <tr>
        <td class="title" colspan="<%= gColSpan %>"><july:actionalert/></td>
    </tr>


 	<july:separator colspan="<%= gColSpan %>"/>


	<tr>
		<td class="text">
			<july:reqmark><bean:message key="label.mutualreglmnts.docdate"/>:</july:reqmark>
		</td>
		<td class="text">
			<july:date property="documentDateFrm" size="25" insertable="false" updatable="false"/>
		</td>
	</tr>


	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<td class="text"><july:reqmark><bean:message key="label.mutualreglmnts.docnumber"/>:</july:reqmark></td>
		<td class="text">
			<july:string size="50" property="documentNumber" insertable="false" updatable="false"/>
		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<td class="text">
			<july:reqmark><bean:message key="label.mutualreglmnts.acttype"/>:</july:reqmark>
		</td>
		<td class="text">
			<logic:equal name="<%= form %>" property="actType" value="A"><bean:message key="label.mutualreglmnts.acttype.vz"/></logic:equal>
			<logic:equal name="<%= form %>" property="actType" value="M"><bean:message key="label.mutualreglmnts.acttype.vt"/></logic:equal>
			<logic:equal name="<%= form %>" property="actType" value="S"><bean:message key="label.mutualreglmnts.acttype.sv"/></logic:equal>
		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>


	<tr>
		<td class="text"><bean:message key="label.mutualreglmnts.contractlist"/>:</td>
		<td class="text">
			<%--july:string size="50" property="orgExecutorname" insertable="false" updatable="false"/-%>
		</td>
	</tr--%>
	
	<july:separator colspan="<%= gColSpan %>"/>


	<tr>
		<td class="text"><july:reqmark><bean:message key="label.mutualacts.actstate"/>:</july:reqmark></td>
		<td class="text">
			<july:radio property="actState" insertable="false" updatable="<%= new Boolean(((ActStateForm) request.getAttribute(form)).getIsEdit()).toString() %>" value="O"/><bean:message key="label.mutualacts.actstate.open"/><br>
			<july:radio property="actState" insertable="false" updatable="true" value="R"/><bean:message key="label.mutualacts.actstate.calc"/><br>
			<july:radio property="actState" insertable="false" updatable="<%= new Boolean(((ActStateForm) request.getAttribute(form)).getIsClosed()).toString() %>" value="C"/><bean:message key="label.mutualacts.actstate.close"/>
		</td>
    </tr>
	
	<july:separator colspan="<%= gColSpan %>"/>
	
	<july:formbuttons/>
	
	<july:separator colspan="<%= gColSpan %>"/>
	
</table>


</july:editform>

