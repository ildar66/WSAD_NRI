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
			return (" <img src='/images/up.gif'  border='0' alt='�� �����������'> ");
		else
			return (" <img src='/images/down.gif'  border='0' alt='�� ��������'> ");
	} else
		return ("");
}
%>

<%	String gColSpan = "12";
	LeaseProblemListForm listForm =
		(LeaseProblemListForm) session.getAttribute("LeaseProblemListForm");
	String sortBy = listForm.getSortBy();
	String propDialog = "top=140, left=350, width=500, height=400, scrollbars=yes, resizable=yes";
	boolean isEdit = request.isUserInRole("administrator") || request.isUserInRole("developer") || request.isUserInRole("ArendaMainEconomist") || request.isUserInRole("ArendaEconomist");
%>
<july:browseform action="/LeaseProblemList.do" styleId="listForm">
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
    listForm.operation.value = "sortBy";
	listForm.submit();
	return false;
}
function deleteItem(number, idItem) {
	if(confirm('������� ������ c �������: ' + number+ ' ?')) {
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
	//��������� selectedID:
	var startLoc = cookies.indexOf(listForm.name+"=");
	if(startLoc == -1)
	   return;
	var sepLoc = cookies.indexOf("=", startLoc);
	var endLoc = cookies.indexOf(";", startLoc);
	if(endLoc == -1) {
		endLoc = cookies.length;
    }
    document.all.selectedID.value = cookies.substring(sepLoc+1, endLoc);
	//������������ ������ � �������:
	if( document.all.tableID.rows(document.all.selectedID.value) != null ) {
 		document.all.tableID.rows(document.all.selectedID.value,0).className="selected";
	}
}
function toggleState(n){
	document.all.state[n].checked = true;
	Refresh();
}
function switchFilter() {
	if(listForm.filter.value == 0) {
		listForm.searchString.disabled = true;
		listForm.searchString.className = 'editdisabled';
	} else {
		listForm.searchString.disabled = false;
		listForm.searchString.className = 'editsearch';
		listForm.searchString.focus();
	}
}
function ShowXLS()
{ 
	listForm.operation.value = "<%= com.hps.july.arenda.actionbean.LeaseProblemListAction.PRINT_XLS%>";
	listForm.submit();
}
function Refresh()
{ 
	listForm.operation.value = "";
    document.body.style.cursor="wait";
	listForm.submit();
}
</script>

	<table class="main" id="tableID" style="font-size: 8pt"> 
	<july:separator colspan="<%= gColSpan %>"/>
	<!-- ������: -->
	<TR class="normal">
		<TD colspan="<%= gColSpan %>">
			<table class="find" style="font-size: 8pt">
				<tr>
					<td class="text" colspan="2">
						����� ��:
		    			<july:select styleClass="seach" onchange="switchFilter()" property="filter" insertable="true" updatable="true">
							<html:option value="0">���</html:option>
							<html:option value="1">������������ �����������</html:option>
							<html:option value="2">������������ ����������</html:option>
					   	</july:select>
					</td>				
					<td class="text" colspan="2">
						<july:string property="searchString" styleId="searchString" styleClass="search" size="25" insertable="true" updatable="true"/>
						<INPUT TYPE='IMAGE' SRC='/images/refresh.gif' onclick="Refresh();return false;" border='0' alt='������'>&nbsp;&nbsp;
						<INPUT TYPE='IMAGE' SRC='/images/msexcel.gif' onclick="ShowXLS();return false;" ALT="����� �LS">
					</td>
				</tr>
				<tr>
					<td class="text" colspan="1">
						<july:radio property="state" insertable="true" updatable="true" value="ALL"/><A href="javascript:toggleState(0)">���</A>
					</td>
					<td class="text" colspan="1">
						<july:radio property="state" insertable="true" updatable="true" value="1"/><A href="javascript:toggleState(1)">�������������</A>
					</td>
					<td class="text" colspan="1">						
						<july:radio property="state" insertable="true" updatable="true" value="2"/><A href="javascript:toggleState(2)">�� ����������</A>
					</td>
					<td class="text" colspan="1">						
						<july:radio property="state" insertable="true" updatable="true" value="3"/><A href="javascript:toggleState(3)">���������</A>
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
					&nbsp;<july:backbutton/></td>
					<td align="right">�������� �������:<%=request.getAttribute("numberOfLines")%>
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
			<td class="title"><A title="����������� �� ���� '�����'"
				href="javascript:SortBy('idProblem')"> � </A><%=isUp(sortBy, "idProblem")%>
			</td>
			<td class="title"><A title="����������� �� ���� '���'"
				href="javascript:SortBy('typeProblem')">���</A><%=isUp(sortBy, "typeProblem")%>
			</td>
			<td class="title"><A title="����������� �� ���� '���� �������'"
				href="javascript:SortBy('listPosContract')">�������</A><%=isUp(sortBy, "listPosContract")%>
			</td>
			<td class="title">
				<A title="����������� �� ���� '����� ��������'"	href="javascript:SortBy('docNumber')">� ���.</A><%=isUp(sortBy, "docNumber")%><BR>
				<A title="����������� �� ���� '���� ��������'"	href="javascript:SortBy('docDate')">���� ���.</A><%=isUp(sortBy, "docDate")%><BR>
			</td>						
			<td class="title"><A title="����������� �� ���� '���� ��������'"
				href="javascript:SortBy('created')">���� ��������</A><%=isUp(sortBy, "created")%>
			</td>
			<td class="title"><A title="����������� �� ���� '��������'"
				href="javascript:SortBy('note')">��������</A><%=isUp(sortBy, "note")%>
			</td>
			<td class="title">
				<A title="����������� �� ���� '�����������'" href="javascript:SortBy('executorName')">�����������</A><%=isUp(sortBy, "executorName")%><BR>
				<A title="����������� �� ���� '���������'" href="javascript:SortBy('ownerName')">���������</A><%=isUp(sortBy, "ownerName")%>
			</td>
			<td class="title"><A title="����������� �� ���� '���������'"
				href="javascript:SortBy('state')">���������</A><%=isUp(sortBy, "state")%>
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
						<IMG SRC="/images/izmena.gif" BORDER='0' ALT='�������� ������'></A>
					</td>
					<td class="text"><bean:write name="it" property="vo.idProblem" filter="true" /></td>
					<td class="text">
						<%--logic:equal name="it" property="vo.typeProblem" value="1">������ �������� ��</logic:equal>
						<logic:equal name="it" property="vo.typeProblem" value="2">������ �������� ������</logic:equal>
						<logic:equal name="it" property="vo.typeProblem" value="3">����������� ����.���.</logic:equal>
						<logic:equal name="it" property="vo.typeProblem" value="4">����������� ����������� ���� ������������</logic:equal>
						<logic:equal name="it" property="vo.typeProblem" value="5">������������� �� ������������ ��������</logic:equal--%>
						<bean:write name="it" property="vo.typeProblemStr" filter="true"/>
					</td>
					<td class="text"><bean:write name="it" property="listPosContract" filter="true" /></td>					
					<td class="text">
						<bean:write name="it" property="docNumber" filter="true" /> ��<BR>
						<july:datewrite name="it" property="docDate" />
					</td>
					<td class="text"><july:datewrite name="it" property="vo.created" /></td>
					<td class="text"><bean:write name="it" property="vo.note" filter="true" /></td>					
					<td class="text" nowrap="nowrap">			
						<bean:write name="it" property="executorName" filter="true"/><BR>
						<bean:write name="it" property="ownerName" filter="true"/>						
					</td>
					<td class="text">
<% if(isEdit) { %>						 		
						<html:select style="width: 100px;font-size: 8pt" name ="it" property="vo.state" styleId="state" onchange='changeState(this.value);'>
							<html:option value="1">�������������</html:option>
							<html:option value="2">�������� �� ����������</html:option>
							<html:option value="3">���������</html:option>
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
							    <img src="/images/del.gif" border="0" alt='������� ������'> </A>
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
					&nbsp;<july:backbutton/></td>
					<td align="right">�������� �������:<%=request.getAttribute("numberOfLines")%>
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
	switchFilter();
	loadSelectedRow();
	window.location.hash=document.all.selectedID.value;
</script>