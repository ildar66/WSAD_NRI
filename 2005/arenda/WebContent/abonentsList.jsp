<%@ page language = "java" %>
<%@ page contentType = "text/html charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import = "com.hps.july.arenda.formbean.*"%>

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
	String gColSpan = "9";
	AbonentsListForm abonentListForm = (AbonentsListForm)session.getAttribute("AbonentsListForm");
	String sortBy = abonentListForm.getSortBy();
%>

<july:browseform action="/ShowAbonentsList.do" styleId="AbonentsListForm">
<html:hidden property="sortBy"/>
<html:hidden property="selectedID" value="0"/>

<script language="javascript">
function switchFilter() {
	if(AbonentsListForm.filter.value == 0 || AbonentsListForm.filter.value == 11) {
		AbonentsListForm.searchstring.disabled = true;
		AbonentsListForm.searchstring.className = 'editdisabled';
	} else {
		AbonentsListForm.searchstring.disabled = false;
		AbonentsListForm.searchstring.className = 'editsearch';
		AbonentsListForm.searchstring.focus();
	}
}
function toggleSearchDogs(n){
	document.all.searchDogs[n].checked = true;
    document.body.style.cursor="wait";
	AbonentsListForm.submit();
}
function toggleFilter(n){
	document.all.filter[n].checked = true;
	//switchFilter();
    document.body.style.cursor="wait";
	AbonentsListForm.submit();
}
function SortBy(field) 
{
	var e = document.all.sortBy;
	e.value = (e.value == field)?field + ' desc':field;
    document.body.style.cursor="wait";
	AbonentsListForm.submit();
	return false;
}
function onMouseOutRow(selectedID){
	if(document.all.selectedID.value==selectedID) {
		document.all.tableID.rows(selectedID,0).className="selected";
		document.all.tableID.rows(selectedID,1).className="selected";
	}
	else {
		document.all.tableID.rows(selectedID,0).className="normal";
		document.all.tableID.rows(selectedID,1).className="normal";
	
	}
}
function onMouseOverRow(selectedID){
	document.all.tableID.rows(selectedID,0).className="select";
	document.all.tableID.rows(selectedID,1).className="select";
}
function onClickRow(selectedID) {
	if(document.all.tableID.rows(document.all.selectedID.value) != null){
		document.all.tableID.rows(document.all.selectedID.value,0).className="normal";
		document.all.tableID.rows(document.all.selectedID.value,1).className="normal";
	}
	document.all.selectedID.value=selectedID;
	document.all.tableID.rows(selectedID,0).className="selected";
	document.all.tableID.rows(selectedID,1).className="selected";
	storeSelectedRow(selectedID);
}
function storeSelectedRow(selectedID) {
	document.cookie = "abonentID=" + selectedID;
}
function DeleteAbonent(ban, id) {
	if(confirm('Удалить договор c номером BAN: ' + ban+ ' ?')) {
		//document.body.style.cursor="wait";
		//AbonentsListForm.submit();
		window.location.href='/arenda/ProcessAbonentBan.do?action=Delete&leaseDocument='+id;
		return false;
	}
}
function loadSelectedRow() {
	var cookies = document.cookie;
	//считываем selectedID:
	var startLoc = cookies.indexOf("abonentID=");
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
		document.all.tableID.rows(document.all.selectedID.value,1).className="selected";
	}
}
function switchCustomer() {
	if (document.all.isCustomer[0].checked) {
		AbonentsListForm.customerName.disabled = true;
		document.all['lookupimg_execl'].src='/images/lookup_disabled.gif';
		AbonentsListForm.customer_vendocSiteId.disabled = true;
		AbonentsListForm.customer_vendocSiteId.className = 'editdisabled';
	} else {
		AbonentsListForm.customerName.disabled = false;
		document.all['lookupimg_execl'].src='/images/lookup.gif';
		AbonentsListForm.customer_vendocSiteId.disabled = false;
		AbonentsListForm.customer_vendocSiteId.className = 'editsearch';
	}
}
function switchDopFilter() {
	if(AbonentsListForm.isDopFilter[0].checked) {
	/**
		for(var i = 0; i < dopFilterID.length; i++){
			dopFilterID[i].style.setAttribute("display", "block");
		}
	*/
		dopFilterID.style.setAttribute("display", "block");
		AbonentsListForm.filter.value = 0;
		document.all.isCustomer[0].checked = false;
	} else {
	/**
		for(var i = 0; i < dopFilterID.length; i++){
			dopFilterID[i].style.setAttribute("display", "none");
		}
	*/
		dopFilterID.style.setAttribute("display", "none");
		AbonentsListForm.filter.value = 1;
		document.all.isCustomer[0].checked = true;
	}
	switchFilter();
	switchCustomer();
}
function hideDopFilter() {
	if(AbonentsListForm.isDopFilter[0].checked) {
	/**
		for(var i = 0; i < dopFilterID.length; i++){
			dopFilterID[i].style.setAttribute("display", "block");
		}
	*/
		dopFilterID.style.setAttribute("display", "block");
	} else {
	/**
		for(var i = 0; i < dopFilterID.length; i++){
			dopFilterID[i].style.setAttribute("display", "none");
		}
	*/
		dopFilterID.style.setAttribute("display", "none");
	}
}
</script>
<table class="main" id="tableID" style="font-size:8pt;">

<july:separator colspan="<%= gColSpan %>"/>

	<tr class="normal">
		<td colspan="<%= gColSpan %>">
			<table class="find" style="font-size:8pt;">
				<tr>
					<td class="text" nowrap>
						<bean:message key="label.abonents.dogs"/>:
					</td>
					<td class="text" nowrap colspan="2">
						<july:radio property="searchDogs" insertable="true" updatable="true" value="0"/>
						<A href="javascript:toggleSearchDogs(0)"><bean:message key="label.all"/></A>
						<july:radio property="searchDogs" insertable="true" updatable="true" value="1"/>
						<A href="javascript:toggleSearchDogs(1)"><bean:message key="label.abonents.dogs.active"/></A>					
						<july:radio property="searchDogs" insertable="true" updatable="true" value="2"/>
						<A href="javascript:toggleSearchDogs(2)"><bean:message key="label.abonents.dogs.editing"/></A>
						<july:radio property="searchDogs" insertable="true" updatable="true" value="3"/>
						<A href="javascript:toggleSearchDogs(3)">Закрытые</A>
					</td>
				</tr>
				<tr>
					<td class="text" nowrap>
						<bean:message key="label.abonents.searchstring"/>:
					</td>
					<td class="text" nowrap>
						<july:string property="searchstring" styleId="searchstring" styleClass="search" style="font-size:8pt;" size="25" insertable="true" updatable="true"/>
		    			<july:select styleClass="seach" onchange="switchFilter()" property="filter" insertable="true" updatable="true" style="font-size:8pt;">
							<html:option value="0">все</html:option>
							<html:option key="label.abonents.filter.byban"  value="1"/>
							<html:option value="2">По номеру телефона</html:option>
							<html:option value="3">По наименованию биллинга</html:option>
							<html:option value="4">По ИНН биллинга</html:option>
							<html:option value="5">По номеру счета</html:option>
							<html:option value="6">По номеру GSM позиции</html:option>
							<html:option value="7">По номеру DAMPS позиции</html:option>
							<html:option value="12">По номеру служебки</html:option>
							<html:option value="8">По наименованию позиции</html:option>
							<html:option value="9">По ответственному Экономисту</html:option>
							<html:option value="10">По ответственному Менеджеру</html:option>
							<html:option value="11">Абонентские договора без базовых станций</html:option>
					   	</july:select>
						<july:searchbutton/>
					</td>
					<td class="text" nowrap>
						Доп.условия: <html:checkbox property="isDopFilter" onclick="switchDopFilter()"/>
						<html:hidden property="isDopFilter" value="false"/>						
					</td>					
				</tr>
				<tr id="dopFilterID">
					<td class="text">Организация:</td>
					<td class="text" nowrap colspan="2">
						<july:checkbox property="isCustomer" insertable="true" updatable="true" onclick="switchCustomer()"/>
						<bean:message key="label.filter.all"/>
						<july:string style="font-size: 8pt;" size="50" property="customerName" styleId="customerName" insertable="false" updatable="false"/>
						<html:link page="/../dict/VendorLookupList.do?formname=AbonentsListForm&fieldnames=customerCode||customerName&onMySelect=document.forms(0).customer_vendocSiteId.value=-1;document.forms(0).submit();" onclick="if (document.all.isCustomer[0].checked) { return false; } else { return openDialog(this.href, 'VendorLookupList', 'top=40, left=100, width=700, height=650, scrollbars=yes, resizable=yes'); }" title="справочник поставщиков">		
							<img src='/images/lookup.gif' border='0' alt='Справочник поставщиков' name="lookupimg_execl"></html:link>		
						<html:hidden property="customerCode"/>
						<BR>Отдел.:
						<july:select styleId="customer_vendocSiteId"  style="width: 450; font-size: 8pt;" collection="customer_vendorSitesList" property="customer_vendocSiteId" insertable="true" updatable="true">
							<html:option value="-1">все отделения</html:option>
							<html:options collection="customer_vendorSitesList" property="vo.idVendorSite" labelProperty="info"/>
					   	</july:select>
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
						<july:canedit rolesProperty="editRoles"><july:addbutton page="/EditAbonentBan.do?action=Add"/></july:canedit>
						<july:backbutton page="/main.do"/>
					</td>
					<td align="right"><bean:message key="label.numrecords"/>:<%= request.getAttribute("numberOfLines") %></td>
					<td class="navigator"><july:navigator/></td>
				</tr>
			</table>
		</td>
	</tr>
	<july:separator colspan="<%= gColSpan %>"/>
	<!-- Table header -->
	<tr class="title" style="font-size:8pt;">
		<td class="title" rowspan="2">&nbsp;</td>
		<td class="title" rowspan="2">&nbsp;</td>
		<td class="title" nowrap>
			<A title="Сортровать по полю 'ban'" href="javascript:SortBy('ban')">
				<bean:message key="label.bans.ban"/>:
			</A><%=isUp(sortBy, "ban")%>
		</td>
		<td class="title" nowrap>
			<A title="Сортровать по полю 'balans'" href="javascript:SortBy('balans')">
				<bean:message key="label.bans.balans"/>(NRI):
			</A><%=isUp(sortBy, "balans")%>
		</td>
		<td class="title" nowrap>
			<A title="Сортровать по полю 'orgCustomerName'" href="javascript:SortBy('orgCustomerName')">
				<bean:message key="label.bans.org.name"/>:
			</A><%=isUp(sortBy, "orgCustomerName")%>
		</td>
		<td class="title" nowrap>
			<A title="Сортровать по полю 'orgCustomerInn'" href="javascript:SortBy('orgCustomerInn')">
				<bean:message key="label.bans.org.inn"/>:
			</A><%=isUp(sortBy, "orgCustomerInn")%>
		</td>
		<td class="title" nowrap>
			<A title="Сортровать по полю 'mainpositionName'" href="javascript:SortBy('mainpositionName')">
				<bean:message key="label.mainPosition"/>
			</A><%=isUp(sortBy, "mainpositionName")%>
		</td>
		<td class="title" rowspan="2">&nbsp;</td>
		<td class="title" rowspan="2">&nbsp;</td>
	</tr>
	<tr class="title" style="font-size:8pt;" align="center">
		<td class="title" colspan="2">
			<A title="Сортровать по полю 'managerName'" href="javascript:SortBy('managerName')">
				отв. менеджер:
			</A><%=isUp(sortBy, "managerName")%>
		</td>
		<td class="title">
			<A title="Сортровать по полю 'economistName'" href="javascript:SortBy('economistName')">
				отв. экономист:
			</A><%=isUp(sortBy, "economistName")%>
		</td>
		<td class="title" colspan="2">
			<A title="Сортровать по полю 'proctype'" href="javascript:SortBy('proctype')">
				тип обработки:
			</A><%=isUp(sortBy, "proctype")%>
		</td>		
	</tr>
	<july:separator colspan="<%= gColSpan %>"/>
	<!-- Table body -->
	<logic:iterate id="it" name="browseList" indexId="indexId">
		<logic:present name="it">
			<tr id='<bean:write name="it" property="leaseDocument" filter="true"/>' class="normal" onMouseOver="onMouseOverRow(this.id);" onMouseOut="onMouseOutRow(this.id);" style="font-size:8pt;" onclick='onClickRow(this.id);'>
				<td class="link" rowspan="2">
					<july:editbutton page="/ViewAbonent.do" action="View" paramId="leaseDocument" paramName="it" paramProperty="leaseDocument" paramScope="page"/>
				</td>
				<td class="text" title='Признак учета во взаимозачетах' rowspan="2">
					<html:checkbox name="it" property="useinacts" disabled="true"/>
				</td>
				<td class="text">
					<bean:write name="it" property="ban" filter="true"/>
				</td>
				<td class="text" nowrap align="right">
					<%--bean:write name="it" property="balans" filter="true"/--%>
					<july:numberwrite name="it" property="balans" fractdigits="0"/>
					(<july:numberwrite name="it" property="balansNRI" fractdigits="0"/>)
					<bean:write name="it" property="currency1.shortname" filter="true"/>
				</td>
 				<td class="text">
					<bean:write name="it" property="orgCustomer.shortname" filter="true"/>/<bean:write name="it" property="bil_name" filter="true"/>
		        </td>
 				<td class="text">
					<bean:write name="it" property="orgCustomer.inn" filter="true"/>
		        </td>
 				<td class="text">
					<logic:present name="it" property="mainpositionVO">
						<bean:write name="it" property="mainpositionVO.name" filter="true"/>
					</logic:present>
		        </td>
				<td class="link" rowspan="2">
					<% String temp = "/EditAbonentState.do?action=View"; %>
					<july:canedit rolesProperty="editRoles"><% temp = "/EditAbonentState.do?action=Edit"; %></july:canedit>
					<july:link page="<%= temp %>" paramId="leaseDocument" paramName="it" paramProperty="leaseDocument" scope="page">
						<logic:equal name="it" property="contractState" value="A">
							<bean:message key="label.bans.contractstate.a"/>
						</logic:equal>
						<logic:equal name="it" property="contractState" value="B">
							<bean:message key="label.bans.contractstate.b"/>
						</logic:equal>
						<logic:equal name="it" property="contractState" value="C">
							<bean:message key="label.bans.contractstate.c"/>
						</logic:equal>
						<logic:equal name="it" property="contractState" value="D">
							<bean:message key="label.bans.contractstate.d"/>
						</logic:equal>
					</july:link>
				</td>
				<td class="link" rowspan="2">
					<logic:equal name="it" property="contractState" value="A">
					<july:canedit rolesProperty="editRoles">
						<A href='javascript:DeleteAbonent(<bean:write name="it" property="ban" filter="true"/>, "<bean:write name="it" property="leaseDocument" filter="true"/>")' title="Удалить запись">
							<IMG SRC="/images/del.gif" BORDER='0' ALT='Удалить'>
						</A>
					</july:canedit>
					</logic:equal>
				</td>
			</tr>
			<tr id='<bean:write name="it" property="leaseDocument" filter="true"/>' class="normal" onMouseOver="onMouseOverRow(this.id);" onMouseOut="onMouseOutRow(this.id);" style="font-size:8pt;" onclick='onClickRow(this.id);' align="center">
				<td class="text" colspan="2">
					<logic:present name="it" property="managerVO">
						<bean:write name="it" property="managerVO.name" filter="true"/>
					</logic:present>
				</td>
				<td class="text">
					<logic:present name="it" property="economistVO">
						<bean:write name="it" property="economistVO.name" filter="true"/>
					</logic:present>
				</td>	
				<td class="text" colspan="2">
					<logic:present name="it" property="proctype">
						<logic:equal name="it" property="proctype" value="A"><bean:message key="label.filter.proctype.a"/></logic:equal>
						<logic:equal name="it" property="proctype" value="B"><bean:message key="label.filter.proctype.b"/></logic:equal>
						<logic:equal name="it" property="proctype" value="C"><bean:message key="label.filter.proctype.c"/></logic:equal>
						<logic:equal name="it" property="proctype" value="D"><bean:message key="label.filter.proctype.d"/></logic:equal>
						<logic:equal name="it" property="proctype" value="E"><bean:message key="label.filter.proctype.e"/></logic:equal>
					</logic:present>
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
						<july:canedit rolesProperty="editRoles"><july:addbutton page="/EditAbonentBan.do?action=Add"/></july:canedit>
						<july:backbutton page="/main.do"/>
					</td>
					<td align="right"><bean:message key="label.numrecords"/>:<%= request.getAttribute("numberOfLines") %></td>
					<td class="navigator"><july:navigator/></td>
				</tr>
			</table>
		</td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>

</table>

<script language="javascript">
	switchFilter();
	loadSelectedRow();
	window.location.hash=document.all.selectedID.value;
	switchCustomer();
	hideDopFilter();
</script>

</july:browseform>

