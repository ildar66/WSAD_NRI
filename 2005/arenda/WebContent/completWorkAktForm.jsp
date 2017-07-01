<%@ page language = "java" %> 
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "3"; %>
<july:editform action="/ProcessCompletWorkAkt.do" styleId="CompletWorkAktForm" onsubmit="storeID();">
<html:hidden name="CompletWorkAktForm" property="idcwacode"/>
<html:hidden name="CompletWorkAktForm" property="flagByHand"/>
<html:hidden property="isLoaded" value="false"/>
<script language="javascript">
function switchEditByHand() {
	if(document.all.flagByHand.value == 'false') {
		document.all.editByHand.disabled = true;
		CompletWorkAktForm.completWorkActActSumStr.disabled = true;
		CompletWorkAktForm.completWorkActActNdsStr.disabled = true;
	}
	else {
		if (!document.all.editByHand.checked) {
			if(document.all.isLoaded.value == 'true'){
				CompletWorkAktForm.completWorkActActSumStr.value = "0.00";
				CompletWorkAktForm.completWorkActActNdsStr.value = "0.00";
			}
			CompletWorkAktForm.completWorkActActSumStr.disabled = true;
			CompletWorkAktForm.completWorkActActNdsStr.disabled = true;
		} else {
			CompletWorkAktForm.completWorkActActSumStr.disabled = false;
			CompletWorkAktForm.completWorkActActNdsStr.disabled = false;
			if(document.all.isLoaded.value == 'true'){
				CompletWorkAktForm.completWorkActActSumStr.value = "";
				CompletWorkAktForm.completWorkActActNdsStr.value = "";
				CompletWorkAktForm.completWorkActActSumStr.focus();
			}
		}
	}
}
function toggleState(){
	if(document.all.flagByHand.value == 'false')
		return;
	if(!document.all.editByHand.checked)
		document.all.editByHand.checked = true;
	else
		document.all.editByHand.checked = false;
	switchEditByHand();
}
function update() {
	var ndsRate = new Number(coma_replace(document.all.ndsRate.value, '.'));
    var sum = coma_replace(document.all.completWorkActActSumStr.value, '.');
	document.all.completWorkActActNdsStr.value = Math.round((sum * ndsRate) / (100.0 + ndsRate) * 100.0) / 100.0;
}

function coma_replace(n, dd)
{
	var a = n.toString().split(',');
	if(a[1] == null)
		return a[0]; 
	else 
		return (a[0] + dd + a[1]);
}
function storeID() {
	//alert("CompletWorkActsListForm=" + document.all.idcwacode.value);//temp
	document.cookie = "CompletWorkActsListForm=" + document.all.idcwacode.value;
}
</script>
<table class="main">

    <july:separator colspan="<%= gColSpan %>"/>
    
    <tr>
        <td class="title" colspan="<%= gColSpan %>"><july:actionalert/></td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>

	<!-- Данные о договоре: -->
	<TR>
		<TD colspan="<%= gColSpan %>">
			<table class="find">
				<tr>
					<td class="text"  colspan="3" style="font-weight: normal;">
						<B>№ дог.:</B>
						<bean:write name="CompletWorkActsListForm" property="agreement.mainDocumentNumber" filter="true"/>
						<B><bean:message key="label.filter.ot"/></B>
						<july:datewrite name="CompletWorkActsListForm" property="agreement.mainDocumentDate"/>
						<B>c:</B>
						<july:datewrite name="CompletWorkActsListForm" property="agreement.mainStartDate"/>
						<B><bean:message key="label.filter.stop"/></B>
						<july:datewrite name="CompletWorkActsListForm" property="agreement.mainEndDate"/>
						&nbsp;&nbsp;&nbsp;
						<B><bean:message key="label.filter.costcurrency"/>:</B>
						<july:sumwrite name="CompletWorkActsListForm" property="agreement.o.summ1"/>&nbsp;
						<bean:write name="CompletWorkActsListForm" property="agreement.o.currency1.shortname" filter="true"/>
						<logic:present name="CompletWorkActsListForm" property="agreement.o.summ2">
							;&nbsp;<july:sumwrite name="CompletWorkActsListForm" property="agreement.o.summ2"/>
							&nbsp;<bean:write name="CompletWorkActsListForm" property="agreement.o.currency2.shortname" filter="true"/>
						</logic:present>
					</td>
				</tr>
				<tr>
					<td class="text" colspan="3" style="font-weight: normal;">
						<B><bean:message key="label.mainPosition"/></B>
						<bean:write name="CompletWorkActsListForm" property="agreement.mainPosition" filter="true"/>
					</td>
				</tr>
				<logic:present name="CompletWorkActsListForm" property="agreement.mainOrgCustomer">
				<tr>
					<td class="text" style="font-weight: normal;">
						<B><bean:message key="label.filter.customer"/>:</B>
						<bean:write name="CompletWorkActsListForm" property="agreement.mainOrgCustomer.name" filter="true"/>
					</td>
					<td class="text" style="font-weight: normal;">
						<B>адрес:</B>
						<bean:write name="CompletWorkActsListForm" property="agreement.mainOrgCustomer.legaladdress" filter="true"/>
					</td>
					<td class="text" style="font-weight: normal;">
						<B>руководитель:</B>
						<bean:write name="CompletWorkActsListForm" property="agreement.mainOrgCustomer.directorfio" filter="true"/>
					</td>
				</tr>
				</logic:present>
				<logic:present name="CompletWorkActsListForm" property="agreement.mainOrgExecutor">
				<tr>
					<td class="text" style="font-weight: normal;">
						<B><bean:message key="label.organization.isrenter"/>:</B>
						<bean:write name="CompletWorkActsListForm" property="agreement.mainOrgExecutor.name" filter="true"/>
					</td>
					<td class="text" style="font-weight: normal;">
						<B>адрес:</B>
						<bean:write name="CompletWorkActsListForm" property="agreement.mainOrgExecutor.legaladdress" filter="true"/>
					</td>
					<td class="text" style="font-weight: normal;">
						<B>руководитель:</B>
						<bean:write name="CompletWorkActsListForm" property="agreement.mainOrgExecutor.directorfio" filter="true"/>
					</td>
				</tr>
				</logic:present>
			</table>
		</TD>
	</TR>

	<july:separator colspan="<%= gColSpan %>"/>

	<tr>
		<td class="text">
			<july:reqmark>Номер документа:</july:reqmark>
		</td>
		<td>
			<july:string size="25" property="completWorkActVO.docnumber" insertable="true" updatable="true"/>
		</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td class="text">
			<july:reqmark>Учетная дата документа:</july:reqmark>
		</td>
		<td>
			<july:date property="completWorkActDocDateStr" size="25" insertable="true" updatable="true"/>
		</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td class="text">
			<july:reqmark>Дата начала периода акта:</july:reqmark>
		</td>
		<td>
			<july:date property="completWorkActActStartDateStr" size="25" insertable="true" updatable="true"/>
		</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td class="text">
			<july:reqmark>Дата окончания периода акта:</july:reqmark>
		</td>
		<td>
			<july:date property="completWorkActActEndDateStr" size="25" insertable="true" updatable="true"/>
		</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td class="text">
			<july:reqmark>Наименование работы(услуги):</july:reqmark>
		</td>
		<td colspan="2">
			<july:string size="50" property="completWorkActVO.nameWork" insertable="true" updatable="true"/>
		</td>
	</tr>
	<tr>
		<td class="text">
			<A href="javascript:toggleState()">Редактировать сумму в ручном режиме:</A>
			<july:checkbox property="completWorkActVO.editByHand" styleId="editByHand" insertable="true" updatable="true" onclick="switchEditByHand()"/>
		</td>
		<td colspan="2">
			&nbsp;
		</td>
	</tr>
	<tr>
		<td class="text">
			<july:reqmark>Валюта:</july:reqmark>
		</td>
		<td colspan="2">
			<july:select property="completWorkActVO.currency" insertable="true" updatable="true">
				<html:option value="810">RUR</html:option>
				<html:option value="840">USD</html:option>
				<html:option value="978">EUR</html:option>
			</july:select>
		</td>
	</tr>
	<tr>
		<td class="text">
			<july:reqmark>Сумма:</july:reqmark>
		</td>
		<td colspan="2">
			<july:string size="25" property="completWorkActActSumStr" insertable="true" updatable="true" onkeyup="update()"/>
			<bean:message key="label.payments.stavkaNds"/>
			<july:string size="5" property="ndsRate" insertable="true" updatable="true" onkeyup="update()"/>
		</td>
	</tr>
	<tr>
		<td class="text">
			<july:reqmark>в т.ч. НДС:</july:reqmark>
		</td>
		<td colspan="2">
			<july:string size="25" property="completWorkActActNdsStr" insertable="true" updatable="true"/>
		</td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>

	<logic:equal name="CompletWorkAktForm" property="completWorkActVO.actstate" value="O">
		<july:formbuttons/>
	</logic:equal>

	<logic:notEqual name="CompletWorkAktForm" property="completWorkActVO.actstate" value="O">
	<tr>
		<td colspan="<%= gColSpan %>">
			<table class="buttons">
				<tr class="title">
					<td class="buttons">
						<july:backbutton/>
					</td>
				</tr>
			</table>					
		</td>
	</tr>
	</logic:notEqual>

	<july:separator colspan="<%= gColSpan %>"/>

</table>

</july:editform>

<script language="javascript">
	switchEditByHand();
	document.all.isLoaded.value = 'true';
</script>