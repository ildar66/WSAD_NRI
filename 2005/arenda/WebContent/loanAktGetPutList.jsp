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
		return (" <img src='/images/up.gif'  border='0' alt='�� �����������'> ");
	 else
		return (" <img src='/images/down.gif'  border='0' alt='�� ��������'> "); 
 }
 else return ("");      
}
%>

<%
	String gColSpan = "8";
	LoanAktGetPutListForm listForm = (LoanAktGetPutListForm)session.getAttribute("LoanAktGetPutListForm");
	//System.out.println("list size=" + listForm.getAktList().size());//temp
	String sortBy = listForm.getSortBy();
%>
<july:errors property="org.apache.struts.action.GLOBAL_ERROR"/>
<july:editform action="/LoanAktGetPutList.do" styleId="listForm">
<html:hidden property="loanContract"/>
<html:hidden property="sortBy"/>
<html:hidden property="selectedID" value="0"/>

<script language="javascript">
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
function printItemWord(idItem){
	window.location.href='/arenda/LoanAktGetPutWordAction.do?id='+idItem;
}
</script>
<table class="main" id="tableID">
	<tr class="title">
		<td class="title" colspan="<%= gColSpan %>">
			<july:closebutton page="/"/>&nbsp;<july:currmark>���� �����-��������</july:currmark>
		</td>
	</tr>
	<july:separator colspan="<%= gColSpan %>"/>

    <!-- Table header -->
    <tr class="title">
        <TD class="title">
			<july:canedit rolesProperty="editRoles">
				<A href='LoanAktGetPutDialog.do?action=Add&loanContract=<bean:write name="LoanAktGetPutListForm" property="loanContract" filter="true"/>' onclick='window.open(this.href, "LoanAktGetPutDialog", "top=150, left=470, width=520, height=350, scrollbars=yes, resizable=yes").focus(); return false;'>
				<IMG SRC="/images/plus.gif" BORDER='0' ALT='�������� ������'></A>
			</july:canedit>
		</TD>
		<TD class="title">
			<A title="����������� �� ���� 'numberAct'" href="javascript:SortBy('numberAct')">�����</A>
			<%=isUp(sortBy, "numberAct")%>
		</TD>
		<TD class="title">
			<A title="����������� �� ���� 'dateAct'" href="javascript:SortBy('dateAct')">����</A>
			<%=isUp(sortBy, "dateAct")%>
		</TD>
		<TD class="title">
			<A title="����������� �� ���� 'ourManName'" href="javascript:SortBy('ourManName')">��� ���������</A>
			<%=isUp(sortBy, "ourManName")%>
		</TD>
		<TD class="title">
			<A title="����������� �� ���� 'OtherMan'" href="javascript:SortBy('OtherMan')">��� ��������</A>
			<%=isUp(sortBy, "OtherMan")%>
		</TD>
        <TD class="title">&nbsp;</TD>
		<TD class="title">&nbsp;</TD>
    </tr>

<july:separator colspan="<%= gColSpan %>" />


        <!-- Table body -->
    <logic:iterate id="it" name="LoanAktGetPutListForm" property = "aktList" type="LoanAktGetPut_TO">
        <logic:present name="it">
			<tr id='<bean:write name="it" property="vo.idAct" filter="true"/>' class="normal" onMouseOver="className='select'" onMouseOut="onMouseOutRow(this.id);" style="font-size:8pt;" onclick='onClickRow(this.id);'>
                <td class="text">
						<july:canedit rolesProperty="editRoles">
						<A href='LoanAktGetPutDialog.do?action=Edit&id=<bean:write name="it" property="vo.idAct" filter="true"/>' onclick='window.open(this.href, "LoanAktGetPutDialog", "top=150, left=470, width=520, height=350, scrollbars=yes, resizable=yes").focus(); return false;'>
							<IMG SRC="/images/izmena.gif" BORDER='0' ALT='�������� ������'></A>
						</july:canedit>
                </td>
                <td class="text">
                      <bean:write name="it" property="vo.numberAct" filter="true"/>
                </td>
                <td class="text">
					<july:datewrite name="it" property="vo.dateAct"/>
                </td>
                <td class="text">
                    <bean:write name="it" property="ourManName" filter="true"/>
                </td>
                <td class="text">
                    <bean:write name="it" property="vo.otherMan" filter="true"/>
                </td>
				<td class="link" align="center">
					<% String idStr = "" + ((LoanAktGetPut_TO)it).getVo().getIdAct(); %>
<%-- 
					<A href='javascript:printItemWord(<bean:write name="it" property="vo.idAct" filter="true"/>)'>
						<img src="/images/docword.gif" border=0 alt='������ ����'></A>
--%>
<%-- --%>
					<july:wordedit styleId='<%= "wrded1_" + idStr %>' url='<%= "LoanAktGetPutWordAction.do?id=" + idStr %>' uploadurl="LoanAktGetPutWordUploadAction.do" documentid="<%= idStr %>" updatable="true">
							<IMG SRC="/images/docword.gif" border="0" alt='������������ ���� WORD'></july:wordedit>
<%-- --%>
					<july:wordedit styleId='<%= "wrded2_" + idStr %>' url='<%= "LoanAktGetPutWordDownload?id=" + idStr %>' uploadurl="LoanAktGetPutWordUploadAction.do" documentid="<%= idStr %>">
							<IMG SRC="/images/getdbword.gif" border="0" alt='��������� ����������� WORD'></july:wordedit>
 
				</td>
                <td class="link">
                    <july:canedit rolesProperty="editRoles">
						<A href='LoanAktGetPutDialog.do?action=Delete&id=<bean:write name="it" property="vo.idAct" filter="true"/>' onclick='window.open(this.href, "LoanAktGetPutDialog", "top=150, left=430, width=520, height=350, scrollbars=yes, resizable=yes").focus(); return false;'>
							<img src="/images/del.gif" border="0" alt='<bean:message key="label.delete"/>'>
						</A>
                   </july:canedit>
                </td>
            </tr>

            <july:separator colspan="<%= gColSpan %>" />
	      </logic:present>
      </logic:iterate>

	<tr class="title">
		<td class="title" colspan="<%= gColSpan %>">
		<july:closebutton page="/"/>&nbsp;<july:currmark>���� �����-��������</july:currmark>
		</td>
	</tr>
      
</table>

<script language="javascript">
	loadSelectedRow();
	window.location.hash=document.all.selectedID.value;
</script>

</july:editform>
