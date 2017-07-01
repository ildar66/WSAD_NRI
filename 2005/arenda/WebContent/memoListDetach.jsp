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
		return (" <img src='/images/up.gif'  border='0' alt='�� �����������'> ");
	 else
		return (" <img src='/images/down.gif'  border='0' alt='�� ��������'> "); 
 }
 else return ("");      
}
%>

<%
	String gColSpan = "10";
	MemoListDetachForm listForm = (MemoListDetachForm)session.getAttribute("MemoListDetachForm");
	String sortBy = listForm.getSortBy();
%>

<july:browseform action="/ShowMemoListDetach" styleId="listForm">
<html:hidden property="sortBy"/>

<html:hidden property="selectedID" value="0"/>

<html:hidden property="operation" value=""/>
<html:hidden property="abonentContract"/>
<html:hidden property="idHeader"/>
<html:hidden property="documentNumber" value=""/>

<script language="javascript">
function SortBy(field) 
{
	var e = document.all.sortBy;
	e.value = (e.value == field)?field + ' desc':field;
    document.body.style.cursor="wait";
	listForm.submit();
	return false;
}
function DeleteMemo(number, idHeader) {
	if(confirm('������� ������ c �������: ' + number+ ' ?')) {
		window.location.href='/arenda/ProcessMemoDetach.do?action=Delete&idHeader='+idHeader;
		return false;
	}
}
function printMemoWord(idHeader){
	window.location.href='/arenda/MemoWordAction.do?detach=true&idHeader='+idHeader;
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
//	��������� selectedID:
	var startLoc = cookies.indexOf(listForm.name+"=");
	if(startLoc == -1)
	   return;
	var sepLoc = cookies.indexOf("=", startLoc);
	var endLoc = cookies.indexOf(";", startLoc);
	if(endLoc == -1) {
		endLoc = cookies.length;
    }
    document.all.selectedID.value = cookies.substring(sepLoc+1, endLoc);
//	������������ ������ � �������:
	if( document.all.tableID.rows(document.all.selectedID.value) != null ) {
 		document.all.tableID.rows(document.all.selectedID.value,0).className="selected";
	}
}
function switchIS() {
	if (!document.all.isDataPeriod[0].checked) {
		listForm.fromDate_dt.enabled = false;
		listForm.toDate_dt.enabled = false;
	} else {
		listForm.fromDate_dt.enabled = true;
		listForm.toDate_dt.enabled = true;
	}
	if (!document.all.isSearchString[0].checked) {
		listForm.filter.className = 'editdisabled';
		listForm.filter.disabled = true;
		listForm.searchstring.className = 'editdisabled';
		listForm.searchstring.disabled = true;
	} else {
		listForm.filter.className = 'editsearch';
		listForm.filter.disabled = false;
		listForm.searchstring.className = 'editsearch';
		listForm.searchstring.disabled = false;
	}
}
function atachMemo(){
	if(confirm('��������� �������� ����� ����������� � �������� c �������: ' + listForm.documentNumber.value + ' ?')) {
		listForm.operation.value='atachMemo';
		listForm.idHeader.value=document.all.selectedID.value;
		document.body.style.cursor="wait";
		listForm.submit();
		return false;
	}
}
</script>

<table class="main" id="tableID">

	<july:separator colspan="<%= gColSpan %>"/>

	<TR class="normal">
		<TD colspan="<%= gColSpan %>">
			<table class="find">
				<tr>
					<td class="text" nowrap>������ ������:</td>
					<td class="text"><july:checkbox property="isSearchString" insertable="true" updatable="true" onclick="switchIS()"/></td>
					<td class="text" nowrap style="font-size:8pt;">
						<july:string property="searchstring" styleId="searchstring" styleClass="search" size="25" insertable="true" updatable="true"/>
		    			<july:select styleClass="seach" property="filter" insertable="true" updatable="true">
							<html:option value="0">�� ������ ��������� �������</html:option>
							<html:option value="1">�� ������������ �������</html:option>
							<html:option value="2">�� ������ GSM</html:option>
							<html:option value="3">�� ������ DAMPS</html:option>
					   	</july:select>
						<july:searchbutton/>
					</td>
				</tr>
				<tr>
					<td class="text" nowrap>�� ��������� ���:</td>
					<td class="text"><july:checkbox property="isDataPeriod" insertable="true" updatable="true" onclick="switchIS()"/></td>
					<td class="text">
						<july:date property="dataPeriod.fromDateFrm" size="25" insertable="true" updatable="true" styleId="fromDate"/>
						<B>&nbsp;��&nbsp;</B>
						<july:date property="dataPeriod.toDateFrm" size="25" insertable="true" updatable="true" styleId="toDate"/>
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
						<html:link page="/EditMemoDetach.do?action=Add">
							<IMG SRC="/images/plus.gif" BORDER='0' ALT='�������� ������'>
						</html:link> 
						<july:backbutton/>
					</td>
					<td align="right">
						�������� �������:<%= request.getAttribute("numberOfLines") %>
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
			<A title="����������� �� ���� '����'" href="javascript:SortBy('date')">����</A><%=isUp(sortBy, "date")%>
		</td>
		<td  title="���������� �������� � ��������" align="center"><B>!</B></td>
		<td class="title" nowrap>
			<A title="����������� �� ���� '�����'" href="javascript:SortBy('number')">�����</A><%=isUp(sortBy, "number")%>
		</td>
		<td class="title" nowrap>
			<A title="����������� �� ���� '��� ��������� �������'" href="javascript:SortBy('type')">��� ��������� �������<%=isUp(sortBy, "type")%>
		</td>
		<td class="title" nowrap>
			<A title="����������� �� ���� '�����������'" href="javascript:SortBy('namePeople')">�����������<%=isUp(sortBy, "namePeople")%>
		</td>
		<td class="title" nowrap>
			<A title="����������� �� ���� '��� �������'" href="javascript:SortBy('positionName')">�������<%=isUp(sortBy, "positionName")%>
		</td>
		<td class="title" nowrap>
			<A title="����������� �� ���� '��� �����������'" href="javascript:SortBy('orgCustomerName')">�����������<%=isUp(sortBy, "orgCustomerName")%>
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
				<html:link page="/EditMemoDetach.do?action=Edit" paramId="idHeader" paramName="it" paramProperty="idHeader" paramScope="page">
					<IMG SRC="/images/izmena.gif" BORDER='0' ALT='�������� ������'>
				</html:link>
			</td>
			<td class="text">
				<july:datewrite name="it" property="date"/>
			</td>
			<td class="text">
					<july:lookupbutton action="/ShowContractLookupList.do?isOnlyWe=false&contracttype=C" styleId='<%= "conl" + indexId %>' fieldNames="abonentContract;documentNumber;;;;;;;;" insertable="true" updatable="true" onselect="atachMemo();" />				
			</td>
			<td class="text">
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
			<td class="text">
				<logic:present name="it" property="positionVO">
					<bean:write name="it" property="positionVO.name" filter="true"/>
				</logic:present>
			</td>
			<td class="text">
				<logic:present name="it" property="orgCustomer">
					<bean:write name="it" property="orgCustomer.name" filter="true"/>
				</logic:present>
			</td>
			<td class="link" align="center">
<%--
				<A href='javascript:printMemoWord(<bean:write name="it" property="idHeader" filter="true"/>)'>
					<img src="/images/docword.gif" border=0 alt='������ ��������� �������'>
				</A>
--%>
				<%
					String idStr = "" + (( Memo_VO)it).getIdHeader();
					Integer typeDoc = com.hps.july.terrabyte.core.DocumentTypes.OFFICE_MEMO_HEADERS; //��� ��������� 
					String objectType = com.hps.july.terrabyte.core.ObjectTypes.OFFICE_MEMO_HEADERS; //objectType 
				%> 
				<%--july:wordedit styleId='<%= "wrded1_" + idStr %>' url='<%= "MemoWordAction.do?detach=true&idHeader=" + idStr %>' 
							uploadurl="MemoWordUploadAction.do" documentid="<%= idStr %>">
							<IMG SRC="/images/docword.gif" border="0" alt='<bean:message key="label.mutaulacts.createword"/>'></july:wordedit--%>
				<july:wordedit styleId='<%= "wrded1_" + idStr %>' url='<%= "MemoWordAction.do?detach=true&idHeader=" + idStr %>' 
						uploadurl='<%= "DocumentUploadAction.do?typeDoc=" + typeDoc + "&objectType=" + objectType %>' documentid="<%= idStr %>">
						<IMG SRC="/images/docword.gif" border="0" alt='�������� Word'></july:wordedit>
							
				<%--july:wordedit styleId='<%= "wrded2_" + idStr %>' url='<%= "MemoWordDownload?idHeader=" + idStr %>' 
							uploadurl="MemoWordUploadAction.do" documentid="<%= idStr %>">
							<IMG SRC="/images/getdbword.gif" border="0" alt='�������� ��������� �������, ����������� � NRI'></july:wordedit--%>
				<july:wordedit styleId='<%= "wrded2_" + idStr %>' url='<%= "DocumentWordDownloadServlet?id=" + idStr + "&objectTypes=" + objectType %>'
						uploadurl='<%= "DocumentUploadAction.do?typeDoc=" + typeDoc + "&objectType=" + objectType %>' documentid="<%= idStr %>">
						<IMG SRC="/images/getdbword.gif" border="0" alt='�������� ���������, ������������ � NRI'></july:wordedit>
            </td>
			<td class="text">
				<A href='javascript:DeleteMemo("<bean:write name="it" property="number" filter="true"/>", <bean:write name="it" property="idHeader" filter="true"/>)' title="������� ��������� �������">
					<IMG SRC="/images/del.gif" BORDER='0' ALT='������� ��������� �������'>
				</A>
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
						<html:link page="/EditMemoDetach.do?action=Add">
							<IMG SRC="/images/plus.gif" BORDER='0' ALT='�������� ������'>
						</html:link> 
						<july:backbutton/>
					</td>
					<td align="right">
						�������� �������:<%= request.getAttribute("numberOfLines") %>
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
	switchIS();
//	window.location.hash=document.all.selectedID.value;
</script>

</july:browseform>
