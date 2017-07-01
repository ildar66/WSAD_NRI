<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ page import = "com.hps.july.arenda.formbean.*"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>


<%!private String isUp(String aSort, String name) {
	if (aSort.startsWith(name)) {
		if (aSort.endsWith("desc"))
			return ("<img src='/images/up.gif'  border='0' alt='по возрастанию'>");
		else
			return ("<img src='/images/down.gif'  border='0' alt='по убыванию'>");
	} else
		return ("");
}
%>

<% String gColSpan = "13";
	DnopForPaymentListForm listForm =
	(DnopForPaymentListForm) session.getAttribute("DnopForPaymentListForm");
	String sortBy = listForm.getSortBy();
%>

<%
	String action = "/DnopForPaymentList.do";
	String form = "DnopForPaymentListForm";
    //start counter:
    //TimeCounter counter = new TimeCounter("PERF.ARENDA.ShowPaymentsList");
    //counter.start();
%>


<july:browseform action="<%= action %>" styleId="<%= form %>">


<script language="javascript">
function SortBy(field) 
{
	var e = document.all.sortBy;
	e.value = (e.value == field)?field + ' desc':field;
    document.body.style.cursor="wait";
	<%= form %>.submit();
	return false;
}
function onMouseOutRow(selectedID){
	if(document.all.selectedID.value==selectedID) {
		document.all.tableID.rows(selectedID,0).className="selected";
	}
	else {
		document.all.tableID.rows(selectedID,0).className="normal";
	}
}
function onClickRow(selectedID) {
	if(document.all.tableID.rows(document.all.selectedID.value) != null){
		document.all.tableID.rows(document.all.selectedID.value,0).className="normal";
	}
	document.all.selectedID.value=selectedID;
	document.all.tableID.rows(selectedID,0).className="selected";
	storeSelectedRow(selectedID);
}
function storeSelectedRow(selectedID) {
	document.cookie = <%= form %>.name+"=" + selectedID;
}
function loadSelectedRow() {
	var cookies = document.cookie;
	//считываем selectedID:
	var startLoc = cookies.indexOf(<%= form %>.name+"=");
	if(startLoc == -1)
	   return;
	var sepLoc = cookies.indexOf("=", startLoc);
	var endLoc = cookies.indexOf(";", startLoc);
	if(endLoc == -1) {
		endLoc = cookies.length;
    }
    document.all.selectedID.value = cookies.substring(sepLoc+1, endLoc);
	//подчеркиваем строку в таблице:
	if( document.all.tableID.rows(document.all.selectedID.value) != null ) {
 		document.all.tableID.rows(document.all.selectedID.value,0).className="selected";
	}
}
function CloseAndUpdate()
	{
		if(window.opener) {
			//alert(window.opener.window.location.href);//temp
			//opener.location.reload(true);
			opener.location.href=opener.location.href;
			//var f = window.opener.window.document.forms;
			//alert(f(0).name);
			//f(0).submit();
			window.opener.focus();
		}
		window.close();
	}	
</script>

<html:hidden property="leasePayment"/>
<%--html:hidden property="sourceContract"/--%>
<html:hidden property="sortBy" />
<html:hidden property="selectedID" value="0" />

<table class="main" id="tableID" style="font-size: 8pt;">

	<july:separator colspan="<%= gColSpan %>"/>

	<TR class="normal">
		<TD colspan="<%= gColSpan %>">
			<table class="find" style="font-size: 8pt;">
				<%--tr>
					<td class="text">
						<A href='AgreementInfo.do?action=View&leaseDocument=<bean:write name="<%= form %>" property="leaseCharge"/>' onclick='window.open(this.href, "AgreementInfo", "top=100, left=100, width=700, height=500, scrollbars=yes, resizable=yes").focus(); return false;' class='button'>
							<bean:message key="label.dhist.contractInfo"/>:
						</A>
					</td>				
					<td class="text">
						<bean:write name="<%= form %>" property="docNumber" filter="true" />
						&nbsp;от&nbsp;<july:datewrite name="<%= form %>" property="docDate"/>
					</td>
				</tr--%>			
				<tr>
					<td class="text">Платеж:</td>
					<td class="text">
						период с:&nbsp;<july:datewrite name="<%= form %>" property="leasePaymentTO.begindate"/>
						по:&nbsp;<july:datewrite name="<%= form %>" property="leasePaymentTO.enddate"/>
					</td>
					<td class="text">
						<bean:write name="<%= form %>" property="leasePaymentTO.resource.name" filter="true" />
					</td>
					<td class="text">
						Сумма:&nbsp;
						<july:sumwrite name="<%= form %>" property="leasePaymentTO.summ"/>
						<bean:write name="<%= form %>" property="leasePaymentTO.currency.shortname" filter="true"/>
					</td>
					<td class="text">
						НДС:&nbsp;
						<july:sumwrite name="<%= form %>" property="leasePaymentTO.sumnds"/>
					</td>
					<td class="text">
						курс:&nbsp;
						<bean:write name="<%= form %>" property="leasePaymentTO.payrate" filter="true" />
					</td>															
				</tr>
			</table>
		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr class="title">
		<td colspan="<%= gColSpan %>">
			<table class="buttons">
				<tr class="title">
					<td class="buttons">
						<%--july:canedit rolesProperty="editRoles">
							<A
								href='ChargeDialog.do?action=Add&idContract=<bean:write name="DnopForChargeListForm" property="mainLeaseContractKey" filter="true"/>'
								onclick='window.open(this.href, "ChargeDialog", "top=150, left=470, width=520, height=460, scrollbars=yes, resizable=yes").focus(); return false;'>
							<IMG SRC="/images/plus.gif" BORDER='0' ALT='Добавить запись'></A>
						</july:canedit--%> 
						&nbsp;<july:backbutton/>
					</td>
					<td>
						<%--A href='ChargeAutomaticDialog.do?action=Add&&condition=C&leaseDocumentcodeFrm=<bean:write name="DnopForChargeListForm" property="mainLeaseContractKey" filter="true"/>'
							onclick='window.open(this.href, "ChargeAutomaticDialog", "top=150, left=470, width=400, height=200, scrollbars=yes, resizable=yes").focus(); return false;' class='button'>
							Автоматическое формирование</A--%>
						<A href='ChargeListLinkToPayment.do?leasePayment=<bean:write name="<%=form%>" property="leasePayment" filter="true"/>&leaseContract=<bean:write name="<%=form%>" property="leasePaymentTO.leaseContract.leaseDocument" filter="true"/>' onclick='window.open(this.href, "ChargeListLinkToPayment", "top=350, left=100, width=800, height=300, scrollbars=yes, resizable=yes").focus(); return false;' class='button'>
							список доступных Начислений</A>							
					</td>
					<td align="right">отобрано записей:<%=request.getAttribute("numberOfLines")%></td>
				</tr>
			</table>
		</td>
	</tr>


	<july:separator colspan="<%= gColSpan %>"/>
	<!-- Table header -->
	<tr class="title">
		<td class="title">&nbsp;</td>
		<td class="title"><A title="Сортировать по полю 'Сумма связи'"
			href="javascript:SortBy('chargeSum')">Сумма связи</A><%=isUp(sortBy, "chargeSum")%></td>
		<td class="title"><A title="Сортировать по полю 'Валюта начисления'"
			href="javascript:SortBy('curChargeName')">Валюта начисления</A><%=isUp(sortBy, "curChargeName")%></td>		
		<td class="title"><A title="Сортировать по полю 'Курс начисления к рублю'"
			href="javascript:SortBy('chargeRurRate')">Курс начисления к рублю</A><%=isUp(sortBy, "chargeRurRate")%></td>		
		<td class="title"><A title="Сортировать по полю 'Сумма начисления'"
			href="javascript:SortBy('chargeRurSum')">Сумма начисления</A><%=isUp(sortBy, "chargeRurSum")%></td>
		<td class="title"><A title="Сортировать по полю 'НДС начисления'"
			href="javascript:SortBy('')">НДС начисления</A><%=isUp(sortBy, "")%></td>
		<td class="title"><A title="Сортировать по полю 'Услуга'"
			href="javascript:SortBy('nameResource')">Услуга</A><%=isUp(sortBy, "nameResource")%></td>
		<td class="title"><A title="Сортировать по полю 'Дата'"
			href="javascript:SortBy('dateCharge')">Дата</A><%=isUp(sortBy, "dateCharge")%></td>
		<td class="title"><A title="Сортировать по полю 'период начисления с'"
			href="javascript:SortBy('beginDateCharge')">период с</A><%=isUp(sortBy, "beginDateCharge")%></td>
		<td class="title"><A title="Сортировать по полю 'период начисления по'"
			href="javascript:SortBy('endDateCharge')"> по </A><%=isUp(sortBy, "endDateCharge")%></td>
			
		<td class="title" title="Удаление связи" align="center">!</td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>

	<!-- Table body -->
	<logic:iterate id="it" name="browseList" type="com.hps.july.arenda.valueobject.DnopForPayment_TO">
		<logic:present name="it">
			<tr
				id='<bean:write name="it" property="vo.leaseCharge" filter="true"/>'
				class="normal" style="font-size: 8pt;"
				onMouseOver="className='select'"
				onMouseOut="onMouseOutRow(this.id);" onclick='onClickRow(this.id);'>
				<td class="link">
					<july:canedit rolesProperty="editRoles">
						<A href='DnopDialog.do?action=View&leaseCharge=<bean:write name="it" property="vo.leaseCharge" filter="true"/>&leasePayment=<bean:write name="it" property="vo.leasePayment" filter="true"/>'
							onclick='return openDialog(this.href, "DnopDialog", "top=150, left=470, width=520, height=460, scrollbars=yes, resizable=yes");'>
						<IMG SRC="/images/izmena.gif" BORDER='0' ALT='Изменить запись'></A>
					</july:canedit></td>
				<td class="number"><july:sumwrite name="it" property="vo.chargeSum"/></td>
				<td class="text"><bean:write name="it" property="curChargeName" filter="true"/></td>				
				<td class="number"><july:sumwrite name="it" property="vo.chargeRurRate"/></td>
				<td class="text"><july:sumwrite name="it" property="vo.chargeRurSum"/></td>
				<td class="text">???</td>
				<td class="text"><bean:write name="it" property="nameResource" filter="true"/></td>
				<td class="text"><july:datewrite name="it" property="dateCharge"/></td>
				<td class="text"><july:datewrite name="it" property="beginDateCharge"/></td>
				<td class="text"><july:datewrite name="it" property="endDateCharge"/></td>
				<td class="link">
					<july:canedit rolesProperty="editRoles">
						<%--A	href='ChargeDialog.do?action=Delete&id=<bean:write name="it" property="vo.leaseDocPosition" filter="true"/>'
							onclick='window.open(this.href, "ChargeDialog", "top=150, left=470, width=520, height=460, scrollbars=yes, resizable=yes").focus(); return false;'>
						<IMG SRC="/images/del.gif" BORDER='0' ALT='Удалить запись'></A--%>					
					</july:canedit>				
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
						<july:canedit rolesProperty="editRoles">
							<%--A
								href='ChargeDialog.do?action=Add&idContract=<bean:write name="DnopForChargeListForm" property="mainLeaseContractKey" filter="true"/>'
								onclick='window.open(this.href, "ChargeDialog", "top=150, left=470, width=520, height=460, scrollbars=yes, resizable=yes").focus(); return false;'>
							<IMG SRC="/images/plus.gif" BORDER='0' ALT='Добавить запись'></A--%>
						</july:canedit> 
						&nbsp;<july:backbutton/>
					</td>
					<td>
						<%--A
							href='ChargeAutomaticDialog.do?action=Add&&condition=C&leaseDocumentcodeFrm=<bean:write name="DnopForChargeListForm" property="mainLeaseContractKey" filter="true"/>'
							onclick='window.open(this.href, "ChargeAutomaticDialog", "top=150, left=470, width=400, height=200, scrollbars=yes, resizable=yes").focus(); return false;' class='button'>
							Автоматическое формирование</A--%>
						
					</td>
					<td align="right">отобрано записей:<%=request.getAttribute("numberOfLines")%></td>
				</tr>
			</table>
		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>

</table>

</july:browseform>

<script language="javascript">
	loadSelectedRow();
	//window.location.hash=document.all.selectedID.value;
	stat = 1;
</script>
<%
    //counter end
	//counter.finish("jsp");
%>
