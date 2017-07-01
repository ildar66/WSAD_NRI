<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<SCRIPT language=javascript src="/common/dialog.js" type="text/javascript"></SCRIPT>

<% java.lang.String gColSpan = "10"; %>

<july:browseform action="/ShowContractLookupList.do" styleId="ContractLookupListForm">

<july:lookupresult tableId="brtable" resultCols="0;1;2;7;8;9;5;6;10"/>

<%--

	/!\ Если добавляются столбцы или удаляются то ОБЯЗАТЕЛЬНО менять здесь!

	0	- Код 
	1	- Номер договора
	2	- Дата договора
	3	- Дата начала срока
	4	- Дата окончания срока
	5	- Сумма в валюте 1
	6	- Сумма в валюте 2
	7	- Заказчик
	8	- Исполнитель
	9	- Тип договора
	10	- Код типа договора
--%>


<script language="javascript">
function switchOrg() {
	if (document.all.isOrg[0].checked) {
		ContractLookupListForm.orgcode.className = 'editkoddisabled';
		ContractLookupListForm.orgcode.disabled = true;
		document.all['lookupimg_orgl'].src='/images/lookup_disabled.gif';
	} else {
		ContractLookupListForm.orgcode.className = 'editkodsearch';
		ContractLookupListForm.orgcode.disabled = false;
		document.all['lookupimg_orgl'].src='/images/lookup.gif';
	}
}
<%--
function switchCustomer() {
	if (document.all.isCustomer[0].checked) { // use not [0] -> styleId in checkBox
		ContractLookupListForm.customercode.className = 'editkoddisabled';
		ContractLookupListForm.customercode.disabled = true;
		document.all['lookupimg_custl'].src='/images/lookup_disabled.gif';
	} else {
		ContractLookupListForm.customercode.className = 'editkodsearch';
		ContractLookupListForm.customercode.disabled = false;
		document.all['lookupimg_custl'].src='/images/lookup.gif';
	}
}

function switchExecutor() {
	if (document.all.isExecutor[0].checked) {
		ContractLookupListForm.executorcode.className = 'editkoddisabled';
		ContractLookupListForm.executorcode.disabled = true;
		document.all['lookupimg_execl'].src='/images/lookup_disabled.gif';
	} else {
		ContractLookupListForm.executorcode.className = 'editkodsearch';
		ContractLookupListForm.executorcode.disabled = false;
		document.all['lookupimg_execl'].src='/images/lookup.gif';
	}
}
--%>
function switchEconomist() {
	if (document.all.isEconomist[0].checked) {
		ContractLookupListForm.economistcode.className = 'editkoddisabled';
		ContractLookupListForm.economistcode.disabled = true;
		document.all['lookupimg_economistl'].src='/images/lookup_disabled.gif';
	} else {
		ContractLookupListForm.economistcode.className = 'editkodsearch';
		ContractLookupListForm.economistcode.disabled = false;
		document.all['lookupimg_economistl'].src='/images/lookup.gif';
	}
}

function switchDocnumber() {
	if (document.all.isDocnumber[0].checked) {
		ContractLookupListForm.docnumber.className = 'editdisabled';
		ContractLookupListForm.docnumber.disabled = true;
	} else {
		ContractLookupListForm.docnumber.className = 'editsearch';
		ContractLookupListForm.docnumber.disabled = false;
	}
}
</script>

<table class="main">
<TR class="title">
	<TD class="title">
		<bean:message key="label.choose.contract"/>
	</TD>
</TR>
<TR class="normal">
	<TD>
		<table class="find">
			<TR>
				<td><bean:message key="label.contracttype"/></td>
				<td class="text" nowrap> <!-- colspan="5" -->
			   		<july:radio styleId="state1" property="contracttype" insertable="true" updatable="true" value="A"/><bean:message key="label.contracttype.arenda"/>
					<logic:equal name="ContractLookupListForm" property="isOnlyWe" value="false">
						<%--july:radio styleId="state2" property="contracttype" insertable="true" updatable="true" value="B"/><bean:message key="label.contracttype.arendaus"/--%>
						<july:radio styleId="state3" property="contracttype" insertable="true" updatable="true" value="C"/><bean:message key="label.contracttype.user"/>
						<%--july:radio styleId="state4" property="contracttype" insertable="true" updatable="true" value="D"/><bean:message key="label.contracttype.channel"/--%>
					</logic:equal>
				</td>
			</tr>
			<tr>
				<td class="text"><bean:message key="label.organization.name"/></td>
				<td class="text" nowrap>
					<july:checkbox property="isOrg" insertable="true" updatable="true" onclick="switchOrg()"/>
					<bean:message key="label.filter.all"/>
					<july:string property="orgcode" styleId="orgcode" size="5" insertable="true" updatable="true"/>
					<%--july:lookupbutton action="/ShowOrganizationLookupList.do" styleId="orgl" fieldNames="orgcode;orgname" newWindowName="OrgLookup" insertable="true" updatable="true" onclick="if (document.all.isOrg[0].checked) { return false; }"/--%>
					<%--july:lookupbutton action="/ShowOrganizationLookupList.do" styleId="orgl" fieldNames="memo.orgCustomer.organization;memo.orgCustomer.name" newWindowName="orglookup" insertable="true" updatable="true" onselect="UpdateListArendaContractsInfo()"/--%>
					<html:link page="/../dict/VendorSiteLookupList.do?formname=ContractLookupListForm&fieldnames=orgcode||orgname" onclick="if (document.all.isOrg[0].checked) { return false; } else { return openDialog(this.href, 'VendorSitesLookupList', 'top=40, left=100, width=700, height=650, scrollbars=yes, resizable=yes'); }" title="справочник отделений">
						<img src='/images/lookup.gif' border='0' alt='Справочник поставщиков' name="lookupimg_orgl"></html:link>						
					<july:string size="50" property="orgname" styleId="orgname" insertable="false" updatable="false"/>
				</td>
			</tr>
<%--
			<tr>
				<td class="text"><bean:message key="label.filter.customer"/></td>
				<td class="text" nowrap>
					<july:checkbox property="isCustomer" insertable="true" updatable="true" onclick="switchCustomer()">
					<bean:message key="label.filter.all"/>
					<july:string property="customercode" styleId="customercode" size="5" insertable="true" updatable="true"/>
					<july:lookupbutton action="/ShowOrganizationLookupList.do" styleId="custl" fieldNames="customercode;customername" newWindowName="CustLookup" insertable="true" updatable="true" onclick="if (document.all.isCustomer[0].checked) { return false; }"/>
					<july:string size="50" property="customername" styleId="customername" insertable="false" updatable="false"/>
				</td>
			</tr>
			<tr>
				<td class="text"><bean:message key="label.filter.executor"/></td>
				<td class="text" nowrap>
					<july:checkbox property="isExecutor" insertable="true" updatable="true" onclick="switchExecutor()">
					<bean:message key="label.filter.all"/>
					<july:string property="executorcode" styleId="executorcode" size="5" insertable="true" updatable="true"/>
					<july:lookupbutton action="/ShowOrganizationLookupList.do" styleId="execl" fieldNames="executorcode;executorname" newWindowName="ExecLookup" insertable="true" updatable="true" onclick="if (document.all.isExecutor[0].checked) { return false; }"/>
					<july:string size="50" property="executorname" styleId="executorname" insertable="false" updatable="false"/>
				</td>
			</tr>
--%>
			<tr>
				<td class="text"><bean:message key="label.filter.responsible"/></td>
				<td class="text" nowrap>
					<july:checkbox property="isEconomist" insertable="true" updatable="true" onclick="switchEconomist()"/>
					<bean:message key="label.filter.all"/>
					<july:string property="economistcode" styleId="economistcode" size="5" insertable="true" updatable="true"/>
					<july:lookupbutton action="/ShowWorkerLookupList.do" styleId="economistl" fieldNames="economistcode;economistname" newWindowName="EconLookup" insertable="true" updatable="true" onclick="if (document.all.isEconomist[0].checked) { return false; }"/>
					<july:string size="50" property="economistname" styleId="economistname" insertable="false" updatable="false"/>
				</td>
			</tr>
			<tr>
				<td class="text"><bean:message key="label.filter.docnumber"/></td>
				<td class="text">
					<july:checkbox property="isDocnumber" insertable="true" updatable="true" onclick="switchDocnumber()"/>
					<bean:message key="label.filter.all"/>
					<july:string size="50" property="docnumber" styleId="docnumber" insertable="true" updatable="true"/>
					<july:searchbutton/>
				</td>
			</tr>
		</table>
	</TD>
</TR>

<tr class="title">
	<td>
		<TABLE class="buttons">
			<TR class="title">
				<TD class="buttons"><july:closebutton page="/"/></TD>
       				<TD class="navigator"><july:navigator/></TD>
       			</TR>
       		</TABLE>
       	</TD>
</tr>

<TR>
	<TD>

	<table class="main" id="brtable">

<script language="javascript">
	switchOrg();
<%--
	switchCustomer();
	switchExecutor();
--%>
	switchEconomist();
	switchDocnumber();
</script>

<!-- Table header -->

        <tr class="title">
		<july:headercolumn key="label.code" colType="number"/>
		<july:headercolumn key="label.table.docnumber" colType="string"/>
		<july:headercolumn key="label.table.docdate" colType="date"/>
		<july:headercolumn key="label.table.startdate" colType="date"/>
		<july:headercolumn key="label.table.finishdate" colType="date"/>
		<july:headercolumn key="label.table.sumofcontract" colType="string"/>
		<july:headercolumn key="label.table.sumofcontract" colType="string"/>
		<td class="text" style="visibility:hidden;display:none;"><bean:message key="label.filter.customer"/></td>
		<td class="text" style="visibility:hidden;display:none;"><bean:message key="label.filter.executor"/></td>
		<td class="text" style="visibility:hidden;display:none;"><bean:message key="label.filter.doctype"/></td>
		<td class="text" style="visibility:hidden;display:none;">Contract type</td>
        </tr>



<!-- Table body -->

<logic:iterate id="it" name="browseList" indexId="index">
	<logic:present name="it">

	<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
		<td class="number"><bean:write name="it" property="leaseDocument" filter="true"/></td>
		<td class="text"><july:lookupreturn><bean:write name="it" property="documentNumber" filter="true"/></july:lookupreturn></td>
		<td class="date"><july:datewrite name="it" property="documentDate"/></td>
		<td class="date"><july:datewrite name="it" property="startDate"/></td>
		<td class="date"><july:datewrite name="it" property="endDate"/></td>
		<td class="text"><bean:write name="it" property="summ1" filter="true"/></td>
		<td class="text"><bean:write name="it" property="summ2" filter="true"/></td>
		<td class="text" style="visibility:hidden;display:none;"><bean:write name="it" property="orgCustomer.name" filter="true"/></td>
		<td class="text" style="visibility:hidden;display:none;"><bean:write name="it" property="orgExecutor.name" filter="true"/></td>
		<td class="text" style="visibility:hidden;display:none;"><logic:equal name="it" property="contractType" value="A"><bean:message key="label.contracttype.arenda"/></logic:equal><logic:equal name="it" property="contractType" value="B"><bean:message key="label.contracttype.arendaus"/></logic:equal><logic:equal name="it" property="contractType" value="C"><bean:message key="label.contracttype.user"/></logic:equal><logic:equal name="it" property="contractType" value="D"><bean:message key="label.contracttype.channel"/></logic:equal></td>
		<td class="text" style="visibility:hidden;display:none;"><bean:write name="it" property="contractType" filter="true"/></td>
	</tr>
	</logic:present>

	<logic:notPresent name="it">

	<tr class="normal">
		<td class="text" colspan="<%= gColSpan %>">
			<bean:message key="label.norecords"/>
		</td>
	</tr>

	</logic:notPresent>

	<july:separator colspan="<%= gColSpan %>"/>

</logic:iterate>

	</table>

	</TD>
</TR>

<tr class="title">
	<td>
		<TABLE class="buttons">
			<TR class="title">
				<TD class="buttons"><july:closebutton page="/"/></TD>
				<TD class="navigator"><july:navigator/></TD>
			</TR>
		</TABLE>
	</TD>
</tr>

</TABLE>

</july:browseform>

