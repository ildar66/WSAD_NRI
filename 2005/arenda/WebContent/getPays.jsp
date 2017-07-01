<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>


<% String gColSpan = "2"; %>


<july:editform action="/ProcessGetPays.do" styleId="GetPaysForm">


<script language="javascript">
function switchContracts() {
	if (document.all.isAllContracts[0].checked) {
		GetPaysForm.contractcodeFrm.className = 'editkoddisabled';
		GetPaysForm.contractcodeFrm.disabled = true;
		document.all['lookupimg_contl'].src='/images/lookup_disabled.gif';
	} else {
		GetPaysForm.contractcodeFrm.className = 'editkod';
		GetPaysForm.contractcodeFrm.disabled = false;
		document.all['lookupimg_contl'].src='/images/lookup.gif';
	}
}
</script>


<input type="hidden" name="doctype"/>


<table class="main">


<%--
<tr class="title">
		<td class="title" colspan="<%= gColSpan %>"><july:currmark><bean:message key="label.getpays"/></july:currmark></td>
	</tr>
--%>

	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<td class="text"><bean:message key="label.getpays.startdate"/>:</td>
		<td class="text" nowrap>
			<july:date property="dateFromFrm" size="25" insertable="true" updatable="true"/>&nbsp;
			<bean:message key="label.filter.stop"/>&nbsp;
			<july:date property="dateToFrm" size="25" insertable="true" updatable="true"/>
		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<td class="text"><bean:message key="label.getpays.contract"/>:</td>
		<td class="text" nowrap>
			<july:checkbox property="isAllContracts" insertable="true" updatable="true" onclick="switchContracts()"/>
			<bean:message key="label.filter.all"/>
			<july:string property="contractcodeFrm" styleId="contractcode" size="5" insertable="true" updatable="true"/>
			<july:lookupbutton action="/ShowContractLookupList.do?isOnlyWe=true" styleId="contl" fieldNames="contractcode;docnumber;docdate;orgCustomer;orgExecutor;doctype;sum1;sum2" insertable="true" updatable="true" onclick="if (document.all.isAllContracts[0].checked) { return false; }"/>
		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<td class="text"><bean:message key="label.getpays.docnumber"/>:</td>
		<td class="text" nowrap><july:string size="50" property="docnumber" styleId="docnumber" insertable="false" updatable="false"/></td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<td class="text"><bean:message key="label.getpays.docdate"/>:</td>
		<td class="text" nowrap><july:string styleId="docdate" property="docdate" size="25" insertable="false" updatable="false"/></td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<td class="text"><bean:message key="label.getpays.sum"/>:</td>
		<td class="text" nowrap>
			<july:string size="25" property="sum1" styleId="sum1" insertable="false" updatable="false"/>&nbsp;
			<july:string size="25" property="sum2" styleId="sum2" insertable="false" updatable="false"/>
		</td>
	</tr>


	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<td class="text"><bean:message key="label.getpays.orgcustomer"/>:</td>
		<td class="text" nowrap><july:string size="50" property="orgCustomer" styleId="orgCustomer" insertable="false" updatable="false"/></td>
	</tr>


	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<td class="text"><bean:message key="label.getpays.orgexecutor"/>:</td>
		<td class="text" nowrap>
			<july:string size="50" property="orgExecutor" styleId="orgExecutor" insertable="false" updatable="false"/>
		</td>
	</tr>


	<july:separator colspan="<%= gColSpan %>"/>


	<tr class="normal">
		<td class="text" colspan="<%= gColSpan %>">
			<INPUT TYPE="IMAGE" NAME="submit" SRC="/images/save.gif" ALT="<bean:message key="button.save"/>">
		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>
	
</table>


<script language="javascript">
	switchContracts();
</script>


</july:editform>