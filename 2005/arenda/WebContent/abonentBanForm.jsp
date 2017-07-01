<%@ page language = "java" %> 
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<%
	java.lang.String gColSpan = "2";
	boolean isAdministrator = request.isUserInRole("administrator"); 
%>

<july:editform action="/ProcessAbonentBan.do" styleId="AbonentBanForm">

<html:hidden name="AbonentBanForm" property="leaseDocument"/>

<script language='javascript'>
function switchUseInActs() {
	if (AbonentBanForm.useinacts.checked) {
		AbonentBanForm.proctype.value='';
		AbonentBanForm.proctype.className = 'editdisabled';
		AbonentBanForm.proctype.disabled = true;
	} else {
		AbonentBanForm.proctype.className = 'edit';
		AbonentBanForm.proctype.disabled = false;
	}
}
</script>

<table class="main">

    <july:separator colspan="<%= gColSpan %>"/>
    
    <tr>
        <td class="title" colspan="<%= gColSpan %>"><july:actionalert/></td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>

	<tr>
		<td class="text"><july:reqmark><bean:message key="label.abonents.ban"/>:</july:reqmark></td>
		<td class="text">
			<july:string size="25" property="abonent.ban" insertable="true" updatable="true"/>&nbsp; 
			от &nbsp; <july:date style="vertical-align: bottom; font-size: 9pt" property="docdateStr" insertable="false" updatable="true"/>
		</td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<td class="text">
			<july:reqmark><bean:message key="label.abonents.orgexecutor"/>:</july:reqmark>
		</td>
		<td class="text">
			<%--html:hidden name="AbonentBanForm" property="abonent.orgExecutor.organization"/--%>
			<%--july:string size="25" property="abonent.orgExecutor.name" insertable="false" updatable="false"/--%>
			<july:select style="width: 300;" collection="customers" property="abonent.orgExecutor.organization" insertable="true" updatable="true">
				<html:options collection="customers" property="idOwnerContract" labelProperty="name"/>
			</july:select>			
		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<td class="text">
			<july:reqmark><bean:message key="label.abonents.orgcustomer"/>:</july:reqmark>
			<html:hidden property="abonent.orgCustomer.organization"/>
			<%--july:lookupbutton action="/ShowOrganizationLookupList.do" styleId="orgl" fieldNames="abonent.orgCustomer.organization;abonent.orgCustomer.name" newWindowName="orglookup" insertable="true" updatable="true"/--%>
			<html:link page="/../dict/VendorSiteLookupList.do?formname=AbonentBanForm&fieldnames=abonent.orgCustomer.organization||abonent.orgCustomer.name" onclick="return openDialog(this.href, 'VendorSitesLookupList', 'top=40, left=100, width=700, height=650, scrollbars=yes, resizable=yes');" title="справочник отделений">
				<img src='/images/lookup.gif' border='0' alt='Справочник поставщиков' name="lookupimg_execl"></html:link>						
		</td>
		<td class="text">
			<july:string size="50" property="abonent.orgCustomer.name" styleId="abonent.orgCustomer.name" insertable="false" updatable="false"/>
		</td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>

	<tr>
		<td class="text">
			<bean:message key="label.mainPosition"/>
			<html:hidden property="abonent.mainpositionVO.storageplace" styleId="mainpositionKey"/>
			<july:lookupbutton action="/../basestation/ShowPositionLookupList.do?planstate=2" styleId="posl" fieldNames="abonent.mainpositionVO.storageplace;;abonent.mainpositionVO.name" insertable="true" updatable="true"/>
		</td>
		<td class="text">
			<july:string size="35" property="abonent.mainpositionVO.name" insertable="false" updatable="false" styleId="mainpositionName"/>
			<% if(isAdministrator) {%>
			<A href='#' onclick='mainpositionName.value=""; mainpositionKey.value=""; return false;'>
				<IMG SRC="/images/iskl.gif" BORDER='0' ALT='Исключить позицию'>
			</A>
			<% } %>
		</td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<td class="text">
			<bean:message key="label.filter.economist"/>:
			<html:hidden property="abonent.economistVO.worker" styleId="economistWorker"/>
			<july:lookupbutton action="/ShowWorkerLookupList.do" styleId="economistl" fieldNames="abonent.economistVO.worker;abonent.economistVO.name" newWindowName="economistlookup" insertable="true" updatable="true"/>
		</td>
		<td class="text">
			<july:string size="35" property="abonent.economistVO.name" insertable="false" updatable="false" styleId="economistName"/>
			<% if(isAdministrator) {%>
			<A href='#' onclick='economistName.value=""; economistWorker.value=""; return false;'>
				<IMG SRC="/images/iskl.gif" BORDER='0' ALT='Исключить менеджера'>
			</A>
			<% } %>
		</td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<td class="text">
			<bean:message key="label.table.mainmanager"/>:&nbsp;
			<html:hidden property="abonent.managerVO.worker" styleId="managerWorker"/>
			<july:lookupbutton action="/ShowWorkerLookupList.do" styleId="managerl" fieldNames="abonent.managerVO.worker;abonent.managerVO.name" newWindowName="managerlookup" insertable="true" updatable="true"/>
		</td>
		<td class="text">
			<july:string size="35" property="abonent.managerVO.name" insertable="false" updatable="false" styleId="managerName"/>
			<% if(isAdministrator) {%>
			<A href='#' onclick='managerName.value=""; managerWorker.value=""; return false;'>
				<IMG SRC="/images/iskl.gif" BORDER='0' ALT='Исключить менеджера'>
			</A>
			<% } %>
		</td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>

	<tr>
		<td class="text">Признак учета во взаимозачетах:</td>
		<td class="text">
			<july:checkbox property="abonent.useinacts" onclick="switchUseInActs()" styleId="useinacts" insertable="true" updatable="false"/>
		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>

	<tr>
		<td class="text">Тип обработки:</td>
		<td class="text">
			<july:select style="width: 350;" property="abonent.proctype" styleId="proctype" insertable="true" updatable="true">
				<html:option value=""/>
				<html:option key="label.filter.proctype.a" value="A"/>
				<html:option key="label.filter.proctype.b" value="B"/>
				<html:option key="label.filter.proctype.c" value="C"/>
				<html:option key="label.filter.proctype.d" value="D"/>
				<html:option key="label.filter.proctype.e" value="E"/>
			</july:select>
		</td>
	</tr>

<july:canedit rolesProperty="editRoles">
		
	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<td class="text">Признак технического договора:</td>
		<td class="text"><july:checkbox property="abonent.techcontract" insertable="true" updatable="true"/></td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>

	<tr>
		<td class="text"><bean:message key="label.abonents.useallben"/>:</td>
		<td class="text"><july:checkbox property="abonent.useallben" insertable="true" updatable="true"/></td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<td class="text"><bean:message key="label.bans.flagworkpie"/>:</td>
		<td class="text"><july:checkbox property="abonent.flagworkpie" insertable="true" updatable="true"/></td>
	</tr>
	
	<%--july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<td class="text">Дата заключения договора:</td>
		<td class="text"><july:date property="docdateStr" insertable="false" updatable="true"/></td>
	</tr--%>	

</july:canedit>	

	<july:separator colspan="<%= gColSpan %>"/>
	
	<july:formbuttons/>

	<july:separator colspan="<%= gColSpan %>"/>
		
</table>

<script language='javascript'>
	switchUseInActs();
</script>

</july:editform>
