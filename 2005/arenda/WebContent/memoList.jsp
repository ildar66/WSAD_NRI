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
	String gColSpan = "7";
	MemoListForm memoListForm = (MemoListForm)session.getAttribute("MemoListForm");
	String sortBy = memoListForm.getSortBy();
	boolean canEdit = false;
%>

<july:browseform action="/ShowMemoList" styleId="listForm">
<html:hidden property="leaseDocument"/>
<html:hidden property="sortBy"/>

<html:hidden property="selectedID" value="0"/>

<script language="javascript">
function SortBy(field) 
{
	var e = document.all.sortBy;
	e.value = (e.value == field)?field + ' desc':field;
    document.body.style.cursor="wait";
	MemoListForm.submit();
	return false;
}
function DeleteMemo(number, idHeader) {
	if(confirm('Удалить запись c номером: ' + number+ ' ?')) {
		window.location.href='/arenda/ProcessMemo.do?action=Delete&idHeader='+idHeader;
		return false;
	}
}
function printMemoWord(idHeader){
	window.location.href='/arenda/MemoWordAction.do?idHeader='+idHeader;
}
function ShowMemoPosList(idHeader){
	window.location.href='/arenda/ShowMemoPosList.do?idHeader='+idHeader;
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
</script>

<table class="main" id="tableID">
	<july:canedit rolesProperty="editRoles">
		<% canEdit = true;%>
	</july:canedit>

	<july:separator colspan="<%= gColSpan %>"/>

	<TR class="normal">
		<TD colspan="<%= gColSpan %>">
			<table class="find">
				<tr>
					<td class="text"><bean:message key="label.abonents.ban"/>:</td>
					<td class="text">
						<bean:write name="MemoListForm" property="abonent.ban" filter="true"/>
					</td>
				</tr>
				<tr>
					<td class="text"><bean:message key="label.mainPosition"/></td>
					<td class="text">
						<logic:present name="MemoListForm" property="abonent.mainpositionVO">
							<bean:write name="MemoListForm" property="abonent.mainpositionVO.name" filter="true"/>
						</logic:present>
					</td>
				</tr>
				<tr>
					<td class="text"><bean:message key="label.abonents.orgcustomer"/>:</td>
					<td class="text">
						<logic:present name="MemoListForm" property="abonent.orgCustomer">
							<bean:write name="MemoListForm" property="abonent.orgCustomer.name" filter="true"/>
						</logic:present>
					</td>
				</tr>
			</table>
		</TD>
	</TR>

	<july:separator colspan="<%= gColSpan %>"/>

		<tr class="title">
		<td colspan="<%= gColSpan %>">
			<table class="buttons">
				<tr class="title">
					<td class="buttons">
						<%if(canEdit) {%>
						<html:link page="/EditMemo.do?action=Add" paramId="abonentContract" paramName="MemoListForm" paramProperty="leaseDocument">
							<IMG SRC="/images/plus.gif" BORDER='0' ALT='Добавить запись'>
						</html:link>
						<%}%>
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

	<!-- Table header -->
	<tr class="title" id="rowHeader">
		<td class="title">&nbsp;</td>
		<td class="title" nowrap>
			<A title="Сортировать по полю 'дата'" href="javascript:SortBy('date')">дата</A><%=isUp(sortBy, "date")%>
		</td>
		<td class="title" nowrap>
			<A title="Сортировать по полю 'номер'" href="javascript:SortBy('number')">номер</A><%=isUp(sortBy, "number")%>
		</td>
		<td class="title" nowrap>
			<A title="Сортировать по полю 'тип служебной записки'" href="javascript:SortBy('type')">тип служебной записки<%=isUp(sortBy, "type")%>
		</td>
		<td class="title" nowrap>
			<A title="Сортировать по полю 'исполнитель'" href="javascript:SortBy('namePeople')">исполнитель<%=isUp(sortBy, "namePeople")%>
		</td>
		<td class="title">&nbsp;</td>
		<td class="title">&nbsp;</td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>

	<!-- Table body  --> 
	<logic:iterate id="it" name="browseList" indexId="indexId"> 
		<logic:present name="it">
		<tr class="normal" id='<bean:write name="it" property="idHeader" filter="true"/>' style="font-size:8pt;" onMouseOver="className='select'" onMouseOut="onMouseOutRow(this.id);" onclick='onClickRow(this.id);'>
			<td class="link">
				<%if(canEdit) {%>
				<html:link page="/EditMemo.do?action=Edit" paramId="idHeader" paramName="it" paramProperty="idHeader" paramScope="page">
					<IMG SRC="/images/izmena.gif" BORDER='0' ALT='Просмотр записи'>
				</html:link>
				<%}%>
			</td>
			<td class="text">
				<july:datewrite name="it" property="date"/>
			</td>
			<td class="text">
<%--
				<A title="Список позиций" href='javascript:ShowMemoPosList(<bean:write name="it" property="idHeader" filter="true"/>)'><bean:write name="it" property="number" filter="true"/></A>
--%>
				<bean:write name="it" property="number" filter="true"/>
			</td>
			<td class="text">
				<bean:write name="it" property="memoType.typeDescription" filter="true"/>
			</td>
			<td class="text">
				<logic:present name="it" property="manVO">
					<bean:write name="it" property="manVO.name" filter="true"/>
				</logic:present>
			</td>
			<td class="link" align="center">
<%--
				<A href='javascript:printMemoWord(<bean:write name="it" property="idHeader" filter="true"/>)'>
					<img src="/images/docword.gif" border=0 alt='Печать служебной записки'>
				</A>
--%>
				<%
					 String idStr = "" + (( Memo_VO)it).getIdHeader();
					 Integer typeDoc = com.hps.july.terrabyte.core.DocumentTypes.OFFICE_MEMO_HEADERS; //тип документа 
					 String objectType = com.hps.july.terrabyte.core.ObjectTypes.OFFICE_MEMO_HEADERS; //objectType 
				%> 
				<%if(canEdit) {%>
				<%--july:wordedit styleId='<%= "wrded1_" + idStr %>' url='<%= "MemoWordAction.do?idHeader=" + idStr %>' 
							uploadurl="MemoWordUploadAction.do" documentid="<%= idStr %>">
							<IMG SRC="/images/docword.gif" border="0" alt='<bean:message key="label.mutaulacts.createword"/>'></july:wordedit--%>
				<july:wordedit styleId='<%= "wrded1_" + idStr %>' url='<%= "MemoWordAction.do?idHeader=" + idStr %>' 
						uploadurl='<%= "DocumentUploadAction.do?typeDoc=" + typeDoc + "&objectType=" + objectType %>' documentid="<%= idStr %>">
						<IMG SRC="/images/docword.gif" border="0" alt='Документ Word'></july:wordedit>
				<%}%>
				<%--july:wordedit styleId='<%= "wrded2_" + idStr %>' url='<%= "MemoWordDownload?idHeader=" + idStr %>' 
							uploadurl="MemoWordUploadAction.do" documentid="<%= idStr %>">
							<IMG SRC="/images/getdbword.gif" border="0" alt='Просмотр служебной записки, сохраненной в NRI'></july:wordedit--%>
				<july:wordedit styleId='<%= "wrded2_" + idStr %>' url='<%= "DocumentWordDownloadServlet?id=" + idStr + "&objectTypes=" + objectType %>'
						uploadurl='<%= "DocumentUploadAction.do?typeDoc=" + typeDoc + "&objectType=" + objectType %>' documentid="<%= idStr %>">
						<IMG SRC="/images/getdbword.gif" border="0" alt='Просмотр документа WORD, сохраненного в NRI'></july:wordedit>
            </td>
			<td class="text">
			<%if(canEdit) {%>
				<A href='javascript:DeleteMemo("<bean:write name="it" property="number" filter="true"/>", <bean:write name="it" property="idHeader" filter="true"/>)' title="Удалить служебную записку">
					<IMG SRC="/images/del.gif" BORDER='0' ALT='Удалить служебную записку'>
				</A>
			<%}%>
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
						<%if(canEdit) {%>
						<html:link page="/EditMemo.do?action=Add" paramId="abonentContract" paramName="MemoListForm" paramProperty="leaseDocument">
							<IMG SRC="/images/plus.gif" BORDER='0' ALT='Добавить запись'>
						</html:link>
						<%}%>
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
	loadSelectedRow();
	//window.location.hash=document.all.selectedID.value;
</script>

</july:browseform>
