<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import = "com.hps.july.arenda.formbean.*"%>
<%@ page import = "com.hps.july.arenda.valueobject.*"%>

<%!
private String isUp(String aSort, String name) {
 if(aSort.startsWith(name)) {
	 if(aSort.endsWith("desc")) 
		return (" <img src='/images/up.gif'  border='0' alt='по возрастанию'> ");
	 else
		return (" <img src='/images/down.gif'  border='0' alt='по убыванию'> "); 
 }
 else return ("");      
}
%>

<%
	String gColSpan = "4";
	CourierDeliveryListForm listForm = (CourierDeliveryListForm)request.getAttribute("CourierDeliveryListForm");
	String sortBy =listForm.getSortBy();
%>

<july:browseform action="/ShowCourierDeliveryList" styleId="listForm">
<html:hidden property="leaseDocument"/>
<html:hidden property="sortBy"/>

<script language="javascript">
function SortBy(field) 
{
	var e = document.all.sortBy;
	e.value = (e.value == field)?field + ' desc':field;
    document.body.style.cursor="wait";
	listForm.submit();
	return false;
}
function switchDate() {
	if (!document.all.isDate[0].checked) {
		listForm.fromDate_dt.enabled = false;
		listForm.toDate_dt.enabled = false;
	} else {
		listForm.fromDate_dt.enabled = true;
		listForm.toDate_dt.enabled = true;
	}
}
function switchDocument_No() {
	if (!document.all.isDocument_No[0].checked) {
		listForm.searchString.className = 'editdisabled';
		listForm.searchString.disabled = true;
	} else {
		listForm.searchString.className = 'editsearch';
		listForm.searchString.disabled = false;
	}
}
</script>

<table class="main" id="tableID">

<july:separator colspan="<%= gColSpan %>"/>

	<july:separator colspan="<%= gColSpan %>"/>

	<TR class="normal">
		<TD colspan="<%= gColSpan %>">
			<table class="find">
				<tr>
					<td class="text"><bean:message key="label.abonents.ban"/>:</td>
					<td class="text" colspan="2">
						<bean:write name="AbonentForm" property="banFrm" filter="true"/>
					</td>
				</tr>
				<tr>
					<td class="text"><bean:message key="label.bans.nri.orginn"/> ( ИНН / наим. ) :</td>
					<td class="text"><bean:write name="AbonentForm" property="orgCustomerInn" filter="true"/> / </td> 
					<td class="text"><bean:write name="AbonentForm" property="orgCustomername" filter="true"/></td>
				</tr>
				<tr>
					<td class="text"><bean:message key="label.bans.billing.orginn"/> ( ИНН / наим. ) :</td>
					<td class="text"><bean:write name="AbonentForm" property="bil_inn" filter="true"/> / </td>
					<td class="text"><bean:write name="AbonentForm" property="bil_name" filter="true"/>	</td>
				</tr>
			</table>
		</TD>
	</TR>

	<july:separator colspan="<%= gColSpan %>"/>

	<TR class="normal">
		<TD colspan="<%= gColSpan %>">
			<table class="find">
				<tr>
					<td class="text" nowrap><B>по номеру счета:</B></td>
					<td class="text">
						<table class="main" border="0" cellpading="0" cellspacing="0">
							<tr>
								<td class="text">
									<july:checkbox property="isDocument_No" insertable="true" updatable="true" onclick="switchDocument_No()"/>
								</td>
								<td class="text">
									<july:string size="50" property="searchString" styleId="searchString" insertable="true" updatable="true"/>
									<july:searchbutton/>
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td class="text"><bean:message key="label.filter.start"/>:</td>
					<td class="text">
						<table class="main" border="0" cellpading="0" cellspacing="0">
							<tr>
								<td class="text">
									<july:checkbox property="isDate" insertable="true" updatable="true" onclick="switchDate()"/>
								</td>
								<td class="text"><july:date property="fromDateFrm" size="25" insertable="true" updatable="true" styleId="fromDate"/></td>
								<td class="text"><B><bean:message key="label.filter.stop"/>:</B></td>
								<td class="text"><july:date property="toDateFrm" size="25" insertable="true" updatable="true" styleId="toDate"/></td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</TD>
	</TR>

	<!-- Table header -->
	<tr class="title" id="rowHeader">
		<td class="title" nowrap>
			<A title="Сортировать по полю 'номер счета'" href="javascript:SortBy('document_no')">номер счета</A><%=isUp(sortBy, "document_no")%>
		</td>
		<td class="title" nowrap>
			<A title="Сортировать по полю 'Ben'" href="javascript:SortBy('ben')">Ben</A><%=isUp(sortBy, "ben")%>
		</td>
		<td class="title" nowrap>
			<A title="Сортировать по полю 'Дата доставки'" href="javascript:SortBy('delivery_date')">Дата доставки<%=isUp(sortBy, "delivery_date")%>
		</td>
		<td class="title" nowrap>
			<A title="Сортировать по полю 'Комментарий'" href="javascript:SortBy('memo')">Комментарий<%=isUp(sortBy, "memo")%>
		</td>
	</tr>

<july:separator colspan="<%= gColSpan %>"/>

	<!-- Table body  --> 
	<logic:iterate id="it" name="browseList" indexId="indexId"> 
	<logic:present name="it">
	<tr class="normal" style="font-size:8pt;" onMouseOver="className='select'" onMouseOut="className='normal'">
		<td class="text">
			<bean:write name="it" property="document_no" filter="true"/>
		</td>
		<td class="text">
			<bean:write name="it" property="ben" filter="true"/>
		</td>
		<td class="text">
				<july:datewrite name="it" property="delivery_date"/>
		</td>
		<td class="text">
			<bean:write name="it" property="memo" filter="true"/>
		</td>
	</tr>

<july:separator colspan="<%= gColSpan %>"/>

	</logic:present>
	</logic:iterate>

	<tr class="title">
		<td colspan="<%= gColSpan %>">
			<table class="buttons">
				<tr class="title">
					<td class="buttons">
						<july:backbutton/>
					</td>
					<td align="right">
						отобрано записей:<%= request.getAttribute("numberOfLines") %>
					</td>
					<td class="navigator"><july:navigator/></td>
				</tr>
			</table>
		</td>
	</tr>

<july:separator colspan="<%= gColSpan %>"/>

</table>

<script language="javascript">
	switchDocument_No()
	switchDate();
</script>

</july:browseform>