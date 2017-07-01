<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
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
	String gColSpan = "12";
	RegistryBuchDocsListForm listForm = (RegistryBuchDocsListForm)session.getAttribute("RegistryBuchDocsListForm");
	String sortBy = listForm.getSortBy();
	boolean isWideFind = request.isUserInRole("administrator") || request.isUserInRole("ArendaMainEconomist") || request.isUserInRole("ArendaDirector");
%>

<july:browseform action="/RegistryBuchDocsList.do" styleId="listForm">
<html:hidden property="sortBy"/>
<html:hidden property="selectedID" value="0"/>
<html:hidden property="operation" value="" />
<html:hidden property="idCode" value="-1" />
<html:hidden property="toState" value="" />

<script language="javascript">
function showTerrabyteWin(s) {
	if(!s) s = "";
	var terrabyteWin = window.open("<%=com.hps.july.util.AppUtils.getNamedValueString("TerrabyteURL")%>?type=leasedoc&uid=<%=request.getRemoteUser()%>" + s, "terrabyteWin", "top=60, left=60, height=" + (screen.availHeight-150) + ", width=" + (screen.availWidth-150) + ", fullscreen=no,location=no,menubar=no,resizable=yes,scrollbars=yes,status=no,titlebar=yes,toolbar=no");
	if(terrabyteWin) terrabyteWin.focus();
}
function switchFilter() {
	//alert(listForm.filter.value);
	if(listForm.filter.value == 0 || listForm.filter.value == 2) {
		listForm.searchstring.disabled = true;
		listForm.searchstring.className = 'editdisabled';
	} else {
		listForm.searchstring.disabled = false;
		listForm.searchstring.className = 'editsearch';
		listForm.searchstring.focus();
	}
}
function toggleSearchTypeRegistry(n){
	document.all.searchTypeRegistry[n].checked = true;
    document.body.style.cursor="wait";
	listForm.submit();
}
function toggleFilter(n){
	document.all.filter[n].checked = true;
	switchFilter();
    document.body.style.cursor="wait";
	listForm.submit();
}
function toggleFilter(){
    document.body.style.cursor="wait";
	listForm.submit();
}
function SortBy(field) 
{
	var e = document.all.sortBy;
	e.value = (e.value == field)?field + ' desc':field;
    document.body.style.cursor="wait";
	listForm.submit();
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
	document.cookie = listForm.name+"=" + selectedID;
}
function loadSelectedRow() {
	var cookies = document.cookie;
	//считываем selectedID:
	var startLoc = cookies.indexOf(listForm.name+"=");
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
function Delete(num, id) {
	if(confirm('Удалить договор c номером: ' + num+ ' ?')) {
		//document.body.style.cursor="wait";
		//listForm.submit();
		window.location.href='/arenda/LoanContractProcess.do?action=Delete&leaseDocument='+id;
		return false;
	}
}
function changeState(toState){
	document.body.style.cursor="wait";
	document.all.operation.value="changeState";
	document.all.toState.value=toState;
	document.all.idCode.value=document.all.selectedID.value;
	//alert("idCode=" + document.all.idCode.value + " toState=" + toState);
	listForm.submit();
	return false;
}
</script>

<table class="main" id="tableID">

	<july:separator colspan="<%= gColSpan %>"/>
	<tr class="normal">
		<td colspan="<%= gColSpan %>">
			<table class="find" style="font-size:8pt;">
				<tr>
					<td class="text" nowrap colspan="2">
						Типы:
						<july:radio property="searchTypeRegistry" insertable="true" updatable="true" value="ALL"/><A href="javascript:toggleSearchTypeRegistry(0)" title="Запросить все описи">все</A>&nbsp;
						<july:radio property="searchTypeRegistry" insertable="true" updatable="true" value="1"/><A style='color: green' href="javascript:toggleSearchTypeRegistry(1)" title="Запросить описи счетов-фактуры">с.ф.</A>
						<july:radio property="searchTypeRegistry" insertable="true" updatable="true" value="2"/><A style='color: green' href="javascript:toggleSearchTypeRegistry(2)" title="Запросить описи актов выполненных работ">акты ВР</A>
						<july:radio property="searchTypeRegistry" insertable="true" updatable="true" value="3"/><A style='color: green' href="javascript:toggleSearchTypeRegistry(3)" title="Запросить описи договоров аренды">договора</A>
						<july:radio property="searchTypeRegistry" insertable="true" updatable="true" value="4"/><A style='color: green' href="javascript:toggleSearchTypeRegistry(4)" title="Запросить описи счетов-фактуры и актов выполненных работ">с.ф./акты ВР</A>
						<july:radio property="searchTypeRegistry" insertable="true" updatable="true" value="5"/><A style='color: green' href="javascript:toggleSearchTypeRegistry(5)" title="Запросить описи актов о зачете взаимных требований">акты ВЗ</A>												
					</td>
				</tr>
				<tr>
					<td class="text" nowrap>
						поиск по:
		    			<july:select styleClass="seach" onchange="switchFilter()" property="filter" insertable="true" updatable="true">
							<html:option value="2">пользователь</html:option>
							<html:option value="1">имя инициатора</html:option>
							<html:option value="3">№ описи</html:option>
						   <%if(isWideFind){%>
							<html:option value="0">все</html:option>
						   <%}%>
					   	</july:select>
					</td>
					<td class="text" nowrap>
						<july:string property="searchString" styleId="searchstring" styleClass="search" size="25" insertable="true" updatable="true"/>
						<july:searchbutton/>&nbsp;&nbsp;
						<july:select property="typeTransferRegistry" styleClass="seach" insertable="true" updatable="true">
							<html:option value="1">прямые описи</html:option>
							<html:option value="2">возвращенные описи</html:option>
							<html:option value="0">прямые и возвращенные</html:option>
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
					<td class="buttons" nowrap>
						<july:canedit rolesProperty="editRoles">
							<A href='RegistryBuchDocsDialog.do?action=Add' onclick='return openDialog(this.href, "RegistryBuchDocsDialog", "top=100, left=350, width=500, height=200, scrollbars=yes, resizable=yes");'>
								<IMG SRC="/images/plus.gif" BORDER='0' ALT='Добавить запись'></A>
						</july:canedit>
						<july:backbutton page="/main.do"/>&nbsp;
						<B>WORD: сорт. по:</B>
		    			<july:select styleClass="seach" property="sortByForWord"
						insertable="true" updatable="true" style="width:80pt; font-size: 9pt">
							<html:option value="numberPosition">№ позиции</html:option>
							<html:option value="namePosition">имя позиции</html:option>
							<html:option value="nameOrg">организации</html:option>
							<html:option value="docDate">дата договора</html:option>
							<html:option value="docNumber">номер договора</html:option>
						</july:select>
						<select name="sortByTo" class="seach" style="width:80pt; font-size: 9pt">
							<option value="">по возрастанию</option>
							<option value="desc">по убыванию</option>
						</select>&nbsp;
						<B>формат:</B>
						<select name="wordView" class="seach" style="width:65pt; font-size: 9pt">
							<option value="simple">обычный</option>
							<option value="complect">комплектом</option>
						</select>												
					</td>
					<td align="right">Всего:<B><%= request.getAttribute("numberOfLines") %></B></td>
					<td class="navigator"><july:navigator/></td>
				</tr>
			</table>
		</td>
	</tr>
	<july:separator colspan="<%= gColSpan %>"/>

	<!-- Table header -->
	<tr class="title" style="font-size:8pt;">
		<td class="title" nowrap></td>
		<td class="title" nowrap></td>
		<td class="title" nowrap>
			<A title="Сортировать по полю 'Номер'" href="javascript:SortBy('idRegistryDoc')"><b> № </b></A>
			<%=isUp(sortBy, "idRegistryDoc")%>
		</td>
		<td class="title" nowrap>
			<A title="Сортировать по полю 'Тип описи'" href="javascript:SortBy('typeRegistry')"><b>Тип описи</b></A>
			<%=isUp(sortBy, "typeRegistry")%>
		</td>
		<td class="title" nowrap>
			<A title="Сорт. по полю 'Состояние'" href="javascript:SortBy('state')"><b>Состояние</b></A>
			<%=isUp(sortBy, "state")%>
		</td>
		<td class="title" nowrap>
			<A title="Сорт. по полю 'Инициатор'" href="javascript:SortBy('owner')"><b>Инициатор</b></A>
			<%=isUp(sortBy, "owner")%>
		</td>
		<td class="title" nowrap>
			<A title="Сортировать по полю 'Дата создания'" href="javascript:SortBy('created')"><b>Дата</b></A>
			<%=isUp(sortBy, "created")%>
		</td>
	<td class="title" nowrap>
			<A title="Сортировать по полю 'Тип возврата'" href="javascript:SortBy('typeTransferRegistry')"><b>Возвр.</b></A>
			<%=isUp(sortBy, "typeTransferRegistry")%>
		</td>		
		<td class="title" title="Документ WORD" align="center"><b>!</b></td>
		<td class="title" title="История описи" align="center"><b>!</b></td>
		<td class="title" title="Удалить" align="center"><b>!</b></td>
	</tr>
	<july:separator colspan="<%= gColSpan %>"/>

	<!-- Table body -->
	<logic:iterate id="it" name="browseList" type="LeaseRegistryBuchDocs_TO">
		<logic:present name="it">
		<%
		    LeaseRegistryBuchDocs_TO item = (LeaseRegistryBuchDocs_TO)it;
			String editAction = (item.getVo().getState().equals("3"))?"View":"Edit";
						
			java.util.List statesList = listForm.getRegBuchDocsState().getAvailableStateList(item.getVo().getState(), AbstractRegistryBuchDocsStateFactory.IRG);
			pageContext.setAttribute("statesList", statesList);
		%>		
			<tr id='<bean:write name="it" property="vo.idRegistryDoc" filter="true"/>' class="normal" onMouseOver="className='select'" onMouseOut="onMouseOutRow(this.id);" onclick='onClickRow(this.id);' style="font-size:8pt;">
				<td class="link">
					<july:canedit>
						<A href='RegistryBuchDocsDialog.do?action=<%=editAction%>&id=<bean:write name="it" property="vo.idRegistryDoc" filter="true"/>' onclick='return openDialog(this.href, "RegistryBuchDocsDialog", "top=100, left=350, width=500, height=220, scrollbars=yes, resizable=yes");'><IMG SRC="/images/izmena.gif" BORDER='0' ALT='Изменить запись'></A>
					</july:canedit>
				</td>
				<td class="link">
					<logic:equal name="it" property="vo.typeTransferRegistry" value="<%= LeaseRegistryBuchDocs_VO.TYPE_TRANSFER_REGISTRY_REAL%>">									
						<A href='/arenda/RegistryBuchDocsCompositionList.do?isInitialGroup=true&idRegistryDoc=<bean:write name="it" property="vo.idRegistryDoc" filter="true"/>&economist=<bean:write name="it" property="vo.owner" filter="true"/>'><IMG SRC="/images/doc.gif" BORDER='0' ALT='Состав описи'></A>
					</logic:equal>
				</td>
				<td class="text" title="Номер описи" align="center">
					<bean:write name="it" property="vo.idRegistryDoc" filter="true"/>
				</td>
				<td class="text" title="Тип описи" align="center" nowrap="nowrap">
					<bean:write name="it" property="vo.typeRegistryStr" filter="true"/>
				</td>
				<td class="text" title="Состояние" align="center">
					<logic:equal name="it" property="vo.typeTransferRegistry" value="<%= LeaseRegistryBuchDocs_VO.TYPE_TRANSFER_REGISTRY_REAL%>">
						<html:select name ="it" property="vo.state" styleId="state" onchange='changeState(this.value);' style="width:120; font-size:9pt">
							<html:options collection="statesList" property="value" labelProperty="name"/>
						</html:select>
					</logic:equal>
					<logic:equal name="it" property="vo.typeTransferRegistry" value="<%= LeaseRegistryBuchDocs_VO.TYPE_TRANSFER_REGISTRY_RETURN%>">
					<html:select name ="it" property="vo.state" styleId="state" onchange='changeState(this.value);' style="width:120; font-size:9pt">
						<html:option value="1">подготовка описи</html:option>
						<html:option value="7">передан инициат.</html:option>
						<html:option value="8">принята инициат.</html:option>
					</html:select>
					</logic:equal>					
				</td>
				<td class="text" title="Инициатор" align="center" nowrap="nowrap">
					<bean:write name="it" property="ownerName" filter="true"/>
				</td>				
 				<td class="date" title="Дата создания">
					<july:datewrite name="it" property="vo.created"/>
                </td>
				<td class="text" title="Тип возврата" align="center">
					<bean:write name="it" property="vo.typeTransferRegistryStr" filter="true"/>
				</td>                
				<td class="link" align="center">
					<%String idStr = "" + ((LeaseRegistryBuchDocs_TO) it).getVo().getIdRegistryDoc();%>
					<% String beforeclick = "wrded1_" + idStr + "_addtourl('&sortBy=' + document.all.sortByForWord.value + ' ' + document.all.sortByTo.value + '&wordView=' + document.all.wordView.value);";  %>
						<logic:notEqual name="it" property="vo.state" value="1">
						<july:wordedit styleId='<%= "wrded1_" + idStr %>' url='<%= "RegistryBuchDocsWordAction.do?id=" + idStr + "&economist=" + item.getVo().getOwner()%>' 
							uploadurl="RegistryBuchDocsWordUploadAction.do" documentid="<%= idStr %>"
							beforeclick="<%= beforeclick %>">
							<IMG SRC="/images/docword.gif" border="0" alt='<bean:message key="label.mutaulacts.createword"/>'></july:wordedit>
						<july:wordedit styleId='<%= "wrded2_" + idStr %>' url='<%= "RegistryBuchDocsWordDownload?code=" + idStr %>'
							uploadurl="RegistryBuchDocsWordUploadAction.do" documentid="<%= idStr %>">
							<IMG SRC="/images/getdbword.gif" border="0" alt='<bean:message key="label.mutualacts.fromdb"/>'></july:wordedit>
						</logic:notEqual>
				</td>
				<td class="link">
					<A href='RegistryBuchDocsHistory.do?action=View&idRegistryDoc=<bean:write name="it" property="vo.idRegistryDoc"/>' onclick='return openDialog(this.href, "RegistryBuchDocsHistory", "top=200, left=330, width=450, height=300, scrollbars=yes, resizable=yes");' class='button'>История</A>
				</td>				                
				<td class="link">
					<logic:equal name="it" property="vo.typeTransferRegistry" value="<%= LeaseRegistryBuchDocs_VO.TYPE_TRANSFER_REGISTRY_REAL%>">													
					<logic:equal name="it" property="vo.state" value="1">
	                    <july:canedit rolesProperty="editRoles">
							<A href='RegistryBuchDocsDialog.do?action=Delete&id=<bean:write name="it" property="vo.idRegistryDoc" filter="true"/>' onclick='return openDialog(this.href, "RegistryBuchDocsDialog", "top=100, left=350, width=500, height=215, scrollbars=yes, resizable=yes");'>
								<img src="/images/del.gif" border="0" alt='<bean:message key="label.delete"/>'>
							</A>
	                   </july:canedit>
					</logic:equal>
					</logic:equal>
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
							<A href='RegistryBuchDocsDialog.do?action=Add' onclick='window.open(this.href, "RegistryBuchDocsDialog", "top=100, left=350, width=500, height=200, scrollbars=yes, resizable=yes").focus(); return false;'>
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
</script>

</july:browseform>
