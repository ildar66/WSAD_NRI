<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import = "com.hps.july.security.formbean.*"%>

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
	java.lang.String gColSpan = "7";
	RoleListForm listForm = (RoleListForm)session.getAttribute("RoleListForm");
	String sortBy = listForm.getOrderBy();
	//paging:
	java.util.List posList = (java.util.List)request.getAttribute("browseList");
	int posListSize = posList.size();//���-�� �������.
	int pageSize = (posListSize > 300)? 20 : 15 ;//���-�� ������� �� ��������.
	int pages = (posListSize%pageSize == 0) ? (posListSize/pageSize) : (posListSize/pageSize + 1);//���-�� �������.	
%>

<july:browseform action="/RoleList.do" styleId="listForm">
<html:hidden property="orderBy"/>
<html:hidden property="selectedID" value="0"/>

<style>
TR.include {
	background-color:#A5F3C6;
}
TR.exclude {
	background-color:#F0F0F0;
}
TR.selectedrow {
	background-color:#FFF0D0;
} 
</style>

<script language="javascript">
function SortBy(field) 
{
	var e = document.all.orderBy;
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
//����������� �������� �������:
function showPage(page) {
	var posListSize = <%= posListSize%>;
	var pageSize = <%= pageSize%>;
	var end = tableID.rows.length - 1;
	var start = end - posListSize;
	for(var i = start; i < end; i++){
		if(i >= start + (page-1)*pageSize && i < start + page*pageSize){
			tableID.rows[i].style.setAttribute("display", "block");			 
	 	}else{
			tableID.rows[i].style.setAttribute("display", "none");
		}
	}
	listForm.pageNumber.value = page;
}
//����������� ���� ������� �������:
function showAllPage() {
	var posListSize = <%= posListSize%>;
	var end = tableID.rows.length - 1;
	var start = end - posListSize;
	for(var i = start; i < end; i++){
		tableID.rows[i].style.setAttribute("display", "block");			 
	}
	listForm.pageNumber.value = "���";
}
function toggleA(a){
	//document.all.isName[0].checked =false;
	//listForm.name.disabled = false;
	listForm.searchStr.value=a+'*';
	listForm.submit();
}
</script>

<table class="main" style="font-size: 9pt" id="tableID">

<%--july:separator colspan="<%= gColSpan %>" /--%>

<TR class="normal">
 <TD colspan="<%= gColSpan %>">
 
    <table class="find">
		<tr>
			<td class="title">
				����:&nbsp;&nbsp;&nbsp;<A href="javascript:toggleA('')">���</A>
			</td>
			<td class="title"><html:text styleClass="search" style="width: 100pt" property="searchStr" size="10"/><july:searchbutton/></td>
			<td class="title" nowrap>
			<%
				String[] a = { "�", "�", "�", "�", "�", "�", "�", "�", "�", "�", "�", "�", "�", "�", "�", "�", "�", "�", "�", "�", "�", "�", "�", "�", "�", "�", "�", "�", "�", "�" };
				for (int i = 0; i < a.length; i++) {%>
					<A href="javascript:toggleA('<%= a[i]%>')"><%= a[i]%></A>
					<%if(a[i].equals("�")){%><BR><%}%>
			<%}%>&nbsp;&nbsp;&nbsp;<A href="javascript:toggleA('')">���</A>			
			</td>
		</tr>
     </table>
    
  </TD>
</TR>

<july:separator colspan="<%= gColSpan %>" />
      
        <!-- Table header -->
        <tr class="title">
			<TD class="buttons"><july:backbutton page="/main.do"/></TD>
			<TH colspan="<%= gColSpan %>">
				����:<A href='Operator2roleDialog.do?action=Add' onclick='return openDialog(this.href, "Operator2roleDialog", "top=100, left=350, width=500, height=310, scrollbars=yes, resizable=yes");'><IMG SRC="/images/plus.gif" BORDER='0' ALT='�������� ����'></A>
				�����: <%= posListSize%>.&nbsp;&nbsp; 
				<%if(posListSize > 0){%>
					��������: <INPUT TYPE="TEXT" NAME="pageNumber" VALUE="���" READONLY="readonly" class="editdisabled" style="width: 19pt; font-size: 8pt;">
					<% for(int i = 1; i <= pages; i++){ %>
						<A name="pagePos_<%=i%>" class="button" onmouseover="showPage(<%=i%>);" style="vertical-align: bottom;"><%=i%></A>
					<% } %>
					<A name="pagePos_ALL" class="button" onmouseover="showAllPage();" style="vertical-align: bottom;">���</A>
				<% } %>				
			</TH>
		</tr>
<july:separator colspan="<%= gColSpan %>" />
        <tr class="exclude">
        	<TD class="title" nowrap></TD>
			<TD class="title" align="center">
				<A title="����������� �� ���� '�'" href="javascript:SortBy('sortOrder')">�</A>
				<%=isUp(sortBy, "sortOrder")%>
			</TD>        
			<TD class="title" align="center">
				<A title="����������� �� ���� '���'" href="javascript:SortBy('role')">���</A>
				<%=isUp(sortBy, "role")%>
			</TD>
			<TD class="title" align="center">
				<A title="����������� �� ���� '����'" href="javascript:SortBy(' rolename')">����</A>
				<%=isUp(sortBy, " rolename")%>
			</TD>
			<TD class="title" align="center">
				<A title="����������� �� ���� '������'" href="javascript:SortBy('taskComment')">������</A>
				<%=isUp(sortBy, "taskComment")%>
			</TD>
			<TD class="title" title="�������� ����" align="center"><B>!</B></TD>			
            <TD class="title" title="���� ��� ���������">&nbsp;</TD>
        </tr>

<july:separator colspan="<%= gColSpan %>" />

         
        <!-- Table body -->
        <logic:iterate id="item" name="browseList">
            <logic:present name="item">
            <tr id='<bean:write name="item" property="role" filter="true"/>' class="normal" onMouseOver="className='select';" onMouseOut="onMouseOutRow(this.id);" onclick="onClickRow(this.id);">
				<td class="link" style="background-color:#F0F0F0">
					<A href='Operator2roleDialog.do?action=Edit&role=<bean:write name="item" property="role" filter="true"/>' onclick='return openDialog(this.href, "Operator2roleDialog", "top=100, left=350, width=500, height=310, scrollbars=yes, resizable=yes");'><IMG SRC="/images/izmena.gif" BORDER='0' ALT='�������� ������'></A>
				</td>            
                <td class="text">
                	<bean:write name="item" property="sortOrder" filter="true"/>
                </td>            
                <td class="number">
                	<bean:write name="item" property="role" filter="true"/>
                </td>
                <td class="text">
                	<bean:write name="item" property="rolename" filter="true"/>
                </td>
                <td class="text">
                	<bean:write name="item" property="taskComment" filter="true"/>
                </td>
                <td class="text">
                  	<IMG SRC="/images/doc.gif" BORDER='0' ALT='��������' title="<bean:write name="item" property="comment" filter="true"/>">                
                </td>
                <td class="link" style="background-color:#F0F0F0">
					<A href='Operator2roleDialog.do?action=Delete&role=<bean:write name="item" property="role" filter="true"/>' onclick='return openDialog(this.href, "Operator2roleDialog", "top=100, left=350, width=500, height=310, scrollbars=yes, resizable=yes");'><IMG SRC="/images/del.gif" BORDER='0' ALT='������� ������'></A>
                </td>
            </tr>

            <%--july:separator colspan="<%= gColSpan %>" /--%>

	        </logic:present>
        </logic:iterate>

        <TR class="title">
          <TD class="buttons"><july:backbutton page="/main.do"/></TD>
          <%--TD><A href='Operator2roleDialog.do?action=Add' onclick='return openDialog(this.href, "Operator2roleDialog", "top=100, left=350, width=500, height=310, scrollbars=yes, resizable=yes");'><IMG SRC="/images/plus.gif" BORDER='0' ALT='�������� ����'></A></TD--%>
          <TD colspan="<%= gColSpan %>"></TD>
        </TR>

      <%--july:separator colspan="<%= gColSpan %>" /--%>
      
    </table>

</july:browseform>
<script language="javascript">
	//switchFilter();
	loadSelectedRow();
	window.location.hash=document.all.selectedID.value;
</script>