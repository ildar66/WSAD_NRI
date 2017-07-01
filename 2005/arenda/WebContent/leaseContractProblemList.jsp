<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import = "com.hps.july.arenda.formbean.*"%>
<%@ page import = "com.hps.july.valueobject.*"%>
<SCRIPT language=javascript src="/common/dialog.js" type="text/javascript"></SCRIPT>  

<%!private String isUp(String aSort, String name) {
	if (aSort.startsWith(name)) {
		if (aSort.endsWith("desc"))
			return (" <img src='/images/up.gif'  border='0' alt='по возрастанию'> ");
		else
			return (" <img src='/images/down.gif'  border='0' alt='по убыванию'> ");
	} else
		return ("");
}
%>

<%	String gColSpan = "12";
	LeaseContractProblemListForm listForm =
		(LeaseContractProblemListForm) session.getAttribute("LeaseContractProblemListForm");
	String sortBy = listForm.getSortBy();
	String propDialog = "top=140, left=350, width=500, height=400, scrollbars=yes, resizable=yes";
	boolean isEdit = request.isUserInRole("administrator") || request.isUserInRole("developer") || request.isUserInRole("ArendaMainEconomist") || request.isUserInRole("ArendaEconomist");
%>
<july:browseform action="/LeaseContractProblemList.do" styleId="listForm">
	<html:hidden property="idContract" />
	<html:hidden property="sortBy" />

	<html:hidden property="operation" value="" />
	<html:hidden property="idCode" value="-1" />
	<html:hidden property="toState" value="" />
	<html:hidden property="selectedID" value="0" />

	<script language="javascript">
function SortBy(field) 
{
	var e = document.all.sortBy;
	e.value = (e.value == field)?field + ' desc':field;
    document.body.style.cursor="wait";
	listForm.submit();
	return false;
}
function deleteItem(number, idItem) {
	if(confirm('Удалить запись c номером: ' + number+ ' ?')) {
		document.body.style.cursor="wait";
		document.all.operation.value="deleteItem";
		document.all.idcwacode.value=idItem;
		listForm.submit();
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
function toggleState(n){
	document.all.state[n].checked = true;
	listForm.submit();
}
</script>

	<table class="main" id="tableID" style="font-size: 8pt"> 
	<july:separator colspan="<%= gColSpan %>"/>
	<!-- Данные о договоре: -->
	<TR class="normal">
		<TD colspan="<%= gColSpan %>">
			<table class="find" style="font-size: 8pt">
				<tr>
					<td class="text" colspan="1">
						<A href='AgreementInfo.do?action=View&leaseDocument=<bean:write name="LeaseContractProblemListForm" property="mainLeaseContractKey"/>'
							 onclick='return openDialog(this.href, "AgreementInfo", "top=200, left=200, width=700, height=500, scrollbars=yes, resizable=yes");' class='button'>
							<bean:message key="label.dhist.contractInfo"/>:
						</A>
					</td>				
					<td class="text" colspan="3">
						<bean:write name="LeaseContractProblemListForm" property="docNumber" filter="true" />
						&nbsp;от&nbsp;<july:datewrite name="LeaseContractProblemListForm" property="docDate"/>
						<july:searchbutton/>
					</td>
				</tr>
				<tr>
					<td class="text" colspan="1">
						<july:radio property="state" insertable="true" updatable="true" value="ALL"/><A href="javascript:toggleState(0)">ВСЕ</A>
					</td>
					<td class="text" colspan="1">
						<july:radio property="state" insertable="true" updatable="true" value="1"/><A href="javascript:toggleState(1)">Редактируется</A>
					</td>
					<td class="text" colspan="1">						
						<july:radio property="state" insertable="true" updatable="true" value="2"/><A href="javascript:toggleState(2)">На устранении</A>
					</td>
					<td class="text" colspan="1">						
						<july:radio property="state" insertable="true" updatable="true" value="3"/><A href="javascript:toggleState(3)">Устранена</A>
					</td>
				</tr>
			</table>
		</TD>
	</TR>

		<july:separator colspan="<%=gColSpan%>" />				
		<tr class="title">
			<td colspan="<%=gColSpan%>">
			<table class="buttons">
				<tr class="title">
					<td class="buttons">
					<% if(isEdit) { %>
						<A href='LeaseContractProblemDialog.do?action=Add&idContract=<bean:write name="LeaseContractProblemListForm" property="mainLeaseContractKey" filter="true"/>'
							onclick='return openDialog(this.href, "LeaseContractProblemDialog", "<%=propDialog%>");'>
							<IMG SRC="/images/plus.gif" BORDER='0' ALT='Добавить запись'></A>
					<% } %>
					&nbsp;<july:backbutton/></td>
					<td align="right">отобрано записей:<%=request.getAttribute("numberOfLines")%>
					</td>
					<td class="navigator"><july:navigator/></td>
				</tr>
			</table>
			</td>
		</tr>

		<july:separator colspan="<%=gColSpan%>" />
		<!-- Table header -->
		<tr class="title">
			<td class="title">&nbsp;</td>
			<td class="title"><A title="Сортировать по полю 'Номер'"
				href="javascript:SortBy('idProblem')">Номер</A><%=isUp(sortBy, "idProblem")%>
			</td>
			<td class="title"><A title="Сортировать по полю 'Тип'"
				href="javascript:SortBy('typeProblem')">Тип</A><%=isUp(sortBy, "typeProblem")%>
			</td>			
			<td class="title"><A title="Сортировать по полю 'Дата создания'"
				href="javascript:SortBy('created')">Дата создания</A><%=isUp(sortBy, "created")%>
			</td>
			<td class="title"><A title="Сортировать по полю 'Описание'"
				href="javascript:SortBy('note')">Описание</A><%=isUp(sortBy, "note")%>
			</td>
			<td class="title">
				<A title="Сортировать по полю 'Исполнитель'" href="javascript:SortBy('executorName')">Исполнитель</A><%=isUp(sortBy, "executorName")%><BR>
				<A title="Сортировать по полю 'Инициатор'" href="javascript:SortBy('ownerName')">Инициатор</A><%=isUp(sortBy, "ownerName")%>
			</td>
			<td class="title"><A title="Сортировать по полю 'Состояние'"
				href="javascript:SortBy('state')">Состояние</A><%=isUp(sortBy, "state")%>
			</td>
<% if(isEdit) { %>
			<td class="title">&nbsp;</td>
<% } %>			
		</tr>

		<july:separator colspan="<%=gColSpan%>" />

		<!-- Table body -->
		<logic:iterate id="it" name="browseList" type="LeaseContractProblem_TO">
			<logic:present name="it">
				<tr
					id='<bean:write name="it" property="vo.idProblem" filter="true"/>'
					class="normal" style="font-size: 8pt"
					onMouseOver="className='select'"
					onMouseOut="onMouseOutRow(this.id);" onclick='onClickRow(this.id);'>
					<td class="link">
					<%
						String actionRecord = "View";
						LeaseContractProblem_TO to = (LeaseContractProblem_TO)it;
						Integer state = to.getVo().getState();
						if( state.equals(LeaseContractProblem_VO.stateEdit) && isEdit )
							actionRecord = "Edit";
					%>
						<A href='LeaseContractProblemDialog.do?action=<%= actionRecord%>&id=<bean:write name="it" property="vo.idProblem" filter="true"/>'
							onclick='return openDialog(this.href, "LeaseContractProblemDialog", "<%=propDialog%>");'>
						<IMG SRC="/images/izmena.gif" BORDER='0' ALT='Изменить запись'></A>
					</td>
					<td class="text"><bean:write name="it" property="vo.idProblem" filter="true" /></td>
					<td class="text">
						<%--logic:equal name="it" property="vo.typeProblem" value="1">нельзя оформить ЗП</logic:equal>
						<logic:equal name="it" property="vo.typeProblem" value="2">нельзя оформить Платеж</logic:equal>
						<logic:equal name="it" property="vo.typeProblem" value="3">отсутствуют перв.док.</logic:equal>
						<logic:equal name="it" property="vo.typeProblem" value="4">отсутствуют подписанные акты взаимозачета</logic:equal>
						<logic:equal name="it" property="vo.typeProblem" value="5">задолженность по абонентскому договору</logic:equal>
						<logic:equal name="it" property="vo.typeProblem" value="6">проблема разработчиков NRI</logic:equal--%>
						<bean:write name="it" property="vo.typeProblemStr" filter="true"/>
					</td>
					<td class="text"><july:datewrite name="it" property="vo.created" /></td>
					<td class="text"><bean:write name="it" property="vo.note" filter="true" /></td>					
					<td class="text">			
						<bean:write name="it" property="executorName" filter="true"/>
						<bean:write name="it" property="ownerName" filter="true"/>						
					</td>
					<td class="text">	 		
<% if(isEdit) { %>						 		
						<html:select style="width: 120px;" name ="it" property="vo.state" styleId="state" onchange='changeState(this.value);'>
							<html:option value="1">Редактируется</html:option>
							<html:option value="2">Передана на устранение</html:option>
							<html:option value="3">Устранена</html:option>
						</html:select>
<% }else{ %>
						<bean:write name="it" property="vo.stateStr" filter="true"/>						
<% } %>
					</td>
<% if(isEdit) { %>						
					<td class="text">
						<logic:equal name="it" property="vo.state" value="<%=String.valueOf(LeaseContractProblem_VO.stateEdit)%>">
							 <A href='LeaseContractProblemDialog.do?action=Delete&id=<bean:write name="it" property="vo.idProblem" filter="true"/>'
								onclick='return openDialog(this.href, "LeaseContractProblemDialog", "<%=propDialog%>");'>
							    <img src="/images/del.gif" border="0" alt='Удалить запись'> </A>
						</logic:equal>
					</td>
<% } %>					
				</tr>
				<july:separator colspan="<%=gColSpan%>" />
			</logic:present>
		</logic:iterate>

		<tr class="title">
			<td colspan="<%=gColSpan%>">
			<table class="buttons">
				<tr class="title">
					<td class="buttons">
					<% if(isEdit) { %>
						<A href='LeaseContractProblemDialog.do?action=Add&idContract=<bean:write name="LeaseContractProblemListForm" property="mainLeaseContractKey" filter="true"/>'
							onclick='return openDialog(this.href, "LeaseContractProblemDialog", "<%=propDialog%>");'>
						<IMG SRC="/images/plus.gif" BORDER='0' ALT='Добавить запись'></A>
					<%}%>
					&nbsp;<july:backbutton/></td>
					<td align="right">отобрано записей:<%=request.getAttribute("numberOfLines")%>
					</td>
					<td class="navigator"><july:navigator/></td>
				</tr>
			</table>
			</td>
		</tr>

		<july:separator colspan="<%=gColSpan%>" />
	</table>

</july:browseform>

<script language="javascript">
	loadSelectedRow();
	window.location.hash=document.all.selectedID.value;
</script>
