<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
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
	String gColSpan = "12";
	LoanContractListForm listForm = (LoanContractListForm)session.getAttribute("LoanContractListForm");
	String sortBy = listForm.getSortBy();
%>

<july:browseform action="/LoanContractList.do" styleId="LoanContractListForm">
<html:hidden property="sortBy"/>
<html:hidden property="selectedID" value="0"/>

<script language="javascript">
function showTerrabyteWin(s) {
	if(!s) s = "";
	var terrabyteWin = window.open("<%=com.hps.july.util.AppUtils.getNamedValueString("TerrabyteURL")%>?type=leasedoc&uid=<%=request.getRemoteUser()%>" + s, "terrabyteWin", "top=60, left=60, height=" + (screen.availHeight-150) + ", width=" + (screen.availWidth-150) + ", fullscreen=no,location=no,menubar=no,resizable=yes,scrollbars=yes,status=no,titlebar=yes,toolbar=no");
	if(terrabyteWin) terrabyteWin.focus();
}
function switchFilter() {
	//alert(LoanContractListForm.filter.value);
	if(LoanContractListForm.filter.value == 0 || LoanContractListForm.filter.value == 8) {
		LoanContractListForm.searchstring.disabled = true;
		LoanContractListForm.searchstring.className = 'editdisabled';
	} else {
		LoanContractListForm.searchstring.disabled = false;
		LoanContractListForm.searchstring.className = 'editsearch';
		LoanContractListForm.searchstring.focus();
	}
}
function toggleSearchDogs(n){
	document.all.searchDogs[n].checked = true;
    document.body.style.cursor="wait";
	LoanContractListForm.submit();
}
function toggleFilter(n){
	document.all.filter[n].checked = true;
	switchFilter();
    document.body.style.cursor="wait";
	LoanContractListForm.submit();
}
function toggleFilter(){
    document.body.style.cursor="wait";
	LoanContractListForm.submit();
}
function SortBy(field) 
{
	var e = document.all.sortBy;
	e.value = (e.value == field)?field + ' desc':field;
    document.body.style.cursor="wait";
	LoanContractListForm.submit();
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
	document.cookie = "loanID=" + selectedID;
}
function Delete(num, id) {
	if(confirm('Удалить договор c номером: ' + num+ ' ?')) {
		//document.body.style.cursor="wait";
		//LoanContractListForm.submit();
		window.location.href='/arenda/LoanContractProcess.do?action=Delete&leaseDocument='+id;
		return false;
	}
}
function loadSelectedRow() {
	var cookies = document.cookie;
	//считываем selectedID:
	var startLoc = cookies.indexOf("loanID=");
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
function editState(idTD, id){
	hrefStr = "LoanContractState.do?action=Edit&idTD=" + idTD + "&id=" + id;
	window.open(hrefStr, "LoanContractState", "top=400, left=400, width=300, height=200, scrollbars=yes, resizable=yes, menubar=no, titlebar=no, toolbar=no, directories=no").focus();
	//alert(id);
	return false;
}
function switchCustomer() {
	if (document.all.isCustomer[0].checked) {
		LoanContractListForm.customerName.disabled = true;
		document.all['lookupimg_execl'].src='/images/lookup_disabled.gif';
		LoanContractListForm.customer_vendocSiteId.disabled = true;
		LoanContractListForm.customer_vendocSiteId.className = 'editdisabled';
	} else {
		LoanContractListForm.customerName.disabled = false;
		document.all['lookupimg_execl'].src='/images/lookup.gif';
		LoanContractListForm.customer_vendocSiteId.disabled = false;
		LoanContractListForm.customer_vendocSiteId.className = 'editsearch';
	}
}
function switchDopFilter() {
	if(LoanContractListForm.isDopFilter[0].checked) {
	/**
		for(var i = 0; i < dopFilterID.length; i++){
			dopFilterID[i].style.setAttribute("display", "block");
		}
	*/
		dopFilterID.style.setAttribute("display", "block");
		LoanContractListForm.filter.value = 0;
		document.all.isCustomer[0].checked = false;
	} else {
	/**
		for(var i = 0; i < dopFilterID.length; i++){
			dopFilterID[i].style.setAttribute("display", "none");
		}
	*/
		dopFilterID.style.setAttribute("display", "none");
		LoanContractListForm.filter.value = 6;
		document.all.isCustomer[0].checked = true;
	}
	switchFilter();
	switchCustomer();
}
function hideDopFilter() {
	if(LoanContractListForm.isDopFilter[0].checked) {
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

<table class="main" id="tableID">

	<july:separator colspan="<%= gColSpan %>"/>
	<tr class="normal">
		<td colspan="<%= gColSpan %>">
			<table class="find" style="font-size:8pt;">
				<tr>
					<td class="text" nowrap>
						Договора:
					</td>
					<td nowrap colspan="2">
						<july:radio property="searchDogs" insertable="true" updatable="true" value="0"/><A href="javascript:toggleSearchDogs(0)">
						все</A>&nbsp;
						<july:radio property="searchDogs" insertable="true" updatable="true" value="1"/><A style='color: green' href="javascript:toggleSearchDogs(1)">
						Действующие</A>&nbsp;
						<july:radio property="searchDogs" insertable="true" updatable="true" value="2"/><A style='color: red' href="javascript:toggleSearchDogs(2)">
						Редактируемые</A>&nbsp;
						<july:radio property="searchDogs" insertable="true" updatable="true" value="3"/><A style='color: gray' href="javascript:toggleSearchDogs(3)">
						Закрытые</A>					
					</td>
				</tr>
				<tr>
					<td class="text" nowrap>
						<bean:message key="label.abonents.searchstring"/> по:
					</td>
					<td class="text" nowrap>
		    			<july:select styleClass="seach" style="font-size:8pt;" onchange="switchFilter()" property="filter" insertable="true" updatable="true">
							<html:option value="0">все</html:option>
							<html:option value="1">По номеру GSM позиции</html:option>
							<html:option value="2">По номеру DAMPS позиции</html:option>
							<html:option value="3">По наименованию позиции</html:option>
							<html:option value="4">По ответственному Экономисту</html:option>
							<html:option value="5">По ответственному Менеджеру</html:option>
							<html:option value="6">По номеру Договора</html:option>
							<html:option value="7">По номеру служебки</html:option>
					   	</july:select>
					
						<july:string property="searchstring" style="font-size:8pt;" styleId="searchstring" styleClass="search" size="10" insertable="true" updatable="true"/>
					</td>
					<td class="text" nowrap>
						<july:searchbutton/>
						Доп.условия: <html:checkbox property="isDopFilter" onclick="switchDopFilter()"/>
						<html:hidden property="isDopFilter" value="false"/>						
					</td>
				</tr>
				<tr id="dopFilterID">
					<td class="text">Ссудополучатель:</td>
					<td class="text" nowrap colspan="2">
						<july:checkbox property="isCustomer" insertable="true" updatable="true" onclick="switchCustomer()"/>
						<bean:message key="label.filter.all"/>
						<july:string style="font-size: 8pt;" size="50" property="customerName" styleId="customerName" insertable="false" updatable="false"/>
						<html:link page="/../dict/VendorLookupList.do?formname=LoanContractListForm&fieldnames=customerCode||customerName&onMySelect=document.forms(0).customer_vendocSiteId.value=-1;document.forms(0).submit();" onclick="if (document.all.isCustomer[0].checked) { return false; } else { return openDialog(this.href, 'VendorLookupList', 'top=40, left=100, width=700, height=650, scrollbars=yes, resizable=yes'); }" title="справочник поставщиков">		
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
						<july:canedit rolesProperty="editRoles">
							<A href='LoanContractDialog.do?action=Add' onclick='window.open(this.href, "LoanContractDialog", "top=100, left=350, width=600, height=550, scrollbars=yes, resizable=yes").focus(); return false;'>
								<IMG SRC="/images/plus.gif" BORDER='0' ALT='Добавить запись'></A>
						</july:canedit>
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
		<td  rowspan="2" align="center" class="title">&nbsp;</td>
		<td  rowspan="2" align="center" class="title">&nbsp;</td>
		<td class="title" nowrap>
			<A title="Сортировать по полю 'Номер договора'" href="javascript:SortBy('docnumber')"><b>Номер</b></A>
			<%=isUp(sortBy, "docnumber")%>
		</td>
		<td  rowspan="2" align="center" class="title">&nbsp;</td>
		<td  rowspan="2" align="center" class="title">&nbsp;</td>
		<td rowspan="2" align="center" class="title" title="Причина"><b>!</b></td>
		<td class="title" nowrap>
			<A title="Сортировать по полю 'Дата начала'" href="javascript:SortBy('startdate')"><b>Дата нач.</b></A>
			<%=isUp(sortBy, "startdate")%>
		</td>
		<td class="title" nowrap>
			<A title="Сорт. по полю 'Дата окончания'" href="javascript:SortBy('enddate')"><b>Дата оконч.</b></A>
			<%=isUp(sortBy, "enddate")%>
		</td>
		<td colspan="1" align="center">
			<A title="Сортировать по полю 'Сумма'" href="javascript:SortBy('plansum')"><b>Сумма</b></A>
			<%=isUp(sortBy, "plansum")%>
		</td>
		<td align="center">
			<A title="Сортировать по полю 'Отв. менеджер'" href="javascript:SortBy('managername')"><b>Отв. мен.</b></A>
			<%=isUp(sortBy, "managername")%>
		</td>
		<td rowspan="2" align="center">
			<A title="Сортировать по полю 'Состояние док-та'" href="javascript:SortBy('contractstate')"><b>Состояние</b></A>
			<%=isUp(sortBy, "contractstate")%>
		</td>
		<td rowspan="2" align="center" class="title" title="Удалить"><b>!</b></td>
	</tr>
	<tr class="title" style="font-size:8pt;">
		<td class="title" nowrap>
			<A title="Сортировать по полю 'Дата договора'" href="javascript:SortBy('docdate')"><b>Дата</b></A>
			<%=isUp(sortBy, "docdate")%>
		</td>
		<td colspan="2" align="center" class="title">
			<A title="Сорт. по полю 'Ссудополучатель'" href="javascript:SortBy('orgcustomername')"><b>Ссудополучатель</b></A>
			<%=isUp(sortBy, "orgcustomername")%>
		</td>
		<td colspan="1" align="center" class="title">
			<A title="Сортировать по полю 'осн. позиция'" href="javascript:SortBy('mainpositionname')"><b>осн. позиция</b></A>
			<%=isUp(sortBy, "mainpositionname")%>
		</td>
		<td colspan="1" align="center" class="title">
			<A title="Сорт. по полю 'Отв. экономист'" href="javascript:SortBy('economistname')"><b>Отв. экон.</b></A>
			<%=isUp(sortBy, "economistname")%>
		</td>
	</tr>
	<july:separator colspan="<%= gColSpan %>"/>

	<!-- Table body -->
	<logic:iterate id="it" name="browseList">
		<logic:present name="it">
			<tr id='<bean:write name="it" property="leaseDocument" filter="true"/>' class="normal" onMouseOver="onMouseOverRow(this.id);" onMouseOut="onMouseOutRow(this.id);" style="font-size:8pt;" onclick='onClickRow(this.id);'>
				<td class="link" rowspan="2">
					<july:canedit>
						<A href='LoanContractDialog.do?action=Edit&id=<bean:write name="it" property="leaseDocument" filter="true"/>' onclick='window.open(this.href, "LoanContractDialog", "top=100, left=350, width=600, height=550, scrollbars=yes, resizable=yes").focus(); return false;'><IMG SRC="/images/izmena.gif" BORDER='0' ALT='Изменить запись'></A>
					</july:canedit>
				</td>
				<td class="link" rowspan="2">
					<html:link page="/LoanContractMemoList.do" paramId="leaseDocument" paramName="it" paramProperty="leaseDocument"><IMG SRC="/images/dochist.gif" BORDER='0' ALT='Служебки'></html:link>
				</td>
				<td class="text" title="Номер договора" align="center" >
					<bean:write name="it" property="docnumber" filter="true"/>
				</td>
				<td class="link" rowspan="2">
						<A href='LoanAktGetPutList.do?action=&loanContract=<bean:write name="it" property="leaseDocument" filter="true"/>' onclick='window.open(this.href, "LoanAktGetPutList", "top=100, left=350, width=600, height=550, scrollbars=yes, resizable=yes").focus(); return false;'><IMG SRC="/images/doc.gif" BORDER='0' ALT='Акты према-передачи'></A>
				</td>
				<td rowspan="2" title="Работа с документами">
					<a href="#" onclick='showTerrabyteWin("&id=<bean:write property="leaseDocument" name="it" />&ss=1&dv=0");return false;' class="button">Док</a>
				</td>
				<td class="text" rowspan="2" align="center" title='<bean:write name="it" property="reason" filter="true"/>'>
					<b>!</b>
				</td>
 				<td class="date">
					<july:datewrite name="it" property="startDate"/>
                </td>
 				<td class="date">
                    <july:datewrite name="it" property="endDate"/>
                </td>
				<td class="number" nowrap align="right">
					<july:numberwrite name="it" property="planSum" fractdigits="0"/>&nbsp;
					<bean:write name="it" property="planCurrVO.name" filter="true"/>
				</td>
 				<td class="text">
					<logic:present name="it" property="managerVO">
						<bean:write name="it" property="managerVO.name" filter="true"/>
					</logic:present>
		        </td>
				<td class="link" rowspan="2"  id='<bean:write name="it" property="leaseDocument" filter="true"/>t1' ondblclick='editState(this.id, <bean:write name="it" property="leaseDocument" filter="true"/>)' title="Двойной клик для смены состояния" onmouseover="document.body.style.cursor='hand';" onmouseout="document.body.style.cursor='auto';">
					<DIV style='color:<bean:write name="it" property="contractStateColor" filter="true"/>'><U><bean:write name="it" property="contractStateStr" filter="true"/></U></DIV>
				</td>
				<td class="link" rowspan="2">
					<logic:equal name="it" property="contractState" value="A">
                    <july:canedit rolesProperty="editRoles">
						<A href='LoanContractDialog.do?action=Delete&id=<bean:write name="it" property="leaseDocument" filter="true"/>' onclick='window.open(this.href, "LoanContractDialog", "top=100, left=350, width=500, height=300, scrollbars=yes, resizable=yes").focus(); return false;'>
							<img src="/images/del.gif" border="0" alt='<bean:message key="label.delete"/>'>
						</A>
                   </july:canedit>
					</logic:equal>
				</td>
			</tr>
			<tr id='<bean:write name="it" property="leaseDocument" filter="true"/>' class="normal" onMouseOver="onMouseOverRow(this.id);" onMouseOut="onMouseOutRow(this.id);" style="font-size:8pt;" onclick='onClickRow(this.id);' align="center">
 				<td class="date">
                    <july:datewrite name="it" property="docdate"/>
                </td>
				<td class="text" colspan="2">
					<logic:present name="it" property="orgCustomer">
						<bean:write name="it" property="orgCustomer.name" filter="true"/>
					</logic:present>
				</td>
				<td class="text" colspan="1">
					<logic:present name="it" property="mainpositionVO">
						<bean:write name="it" property="mainpositionVO.name" filter="true"/>
					</logic:present>
				</td>
				<td class="text">
					<logic:present name="it" property="economistVO">
						<bean:write name="it" property="economistVO.name" filter="true"/>
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
						<july:canedit rolesProperty="editRoles">
							<A href='LoanContractDialog.do?action=Add' onclick='window.open(this.href, "LoanContractDialog", "top=100, left=350, width=600, height=550, scrollbars=yes, resizable=yes").focus(); return false;'>
								<IMG SRC="/images/plus.gif" BORDER='0' ALT='Добавить запись'></A>
						</july:canedit>
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

