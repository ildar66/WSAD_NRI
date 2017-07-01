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
		return (" <img src='/images/up.gif'  border='0' alt='по возрастанию'> ");
	 else
		return (" <img src='/images/down.gif'  border='0' alt='по убыванию'> "); 
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
//	считываем selectedID:
	var startLoc = cookies.indexOf(listForm.name+"=");
	if(startLoc == -1)
	   return;
	var sepLoc = cookies.indexOf("=", startLoc);
	var endLoc = cookies.indexOf(";", startLoc);
	if(endLoc == -1) {
		endLoc = cookies.length;
    }
    document.all.selectedID.value = cookies.substring(sepLoc+1, endLoc);
//	подчеркиваем строку в таблице:
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
			<july:closebutton page="/"/>&nbsp;<july:currmark>Акты према-передачи</july:currmark>
		</td>
	</tr>
	<july:separator colspan="<%= gColSpan %>"/>

    <!-- Table header -->
    <tr class="title">
        <TD class="title">
			<july:canedit rolesProperty="editRoles">
				<A href='LoanAktGetPutDialog.do?action=Add&loanContract=<bean:write name="LoanAktGetPutListForm" property="loanContract" filter="true"/>' onclick='window.open(this.href, "LoanAktGetPutDialog", "top=150, left=470, width=520, height=350, scrollbars=yes, resizable=yes").focus(); return false;'>
				<IMG SRC="/images/plus.gif" BORDER='0' ALT='Добавить запись'></A>
			</july:canedit>
		</TD>
		<TD class="title">
			<A title="Сортировать по полю 'numberAct'" href="javascript:SortBy('numberAct')">Номер</A>
			<%=isUp(sortBy, "numberAct")%>
		</TD>
		<TD class="title">
			<A title="Сортировать по полю 'dateAct'" href="javascript:SortBy('dateAct')">Дата</A>
			<%=isUp(sortBy, "dateAct")%>
		</TD>
		<TD class="title">
			<A title="Сортировать по полю 'ourManName'" href="javascript:SortBy('ourManName')">Кто передавал</A>
			<%=isUp(sortBy, "ourManName")%>
		</TD>
		<TD class="title">
			<A title="Сортировать по полю 'OtherMan'" href="javascript:SortBy('OtherMan')">Кто принимал</A>
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
							<IMG SRC="/images/izmena.gif" BORDER='0' ALT='Изменить запись'></A>
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
						<img src="/images/docword.gif" border=0 alt='Печать акта'></A>
--%>
<%-- --%>
					<july:wordedit styleId='<%= "wrded1_" + idStr %>' url='<%= "LoanAktGetPutWordAction.do?id=" + idStr %>' uploadurl="LoanAktGetPutWordUploadAction.do" documentid="<%= idStr %>" updatable="true">
							<IMG SRC="/images/docword.gif" border="0" alt='Сформировать файл WORD'></july:wordedit>
<%-- --%>
					<july:wordedit styleId='<%= "wrded2_" + idStr %>' url='<%= "LoanAktGetPutWordDownload?id=" + idStr %>' uploadurl="LoanAktGetPutWordUploadAction.do" documentid="<%= idStr %>">
							<IMG SRC="/images/getdbword.gif" border="0" alt='Загрузить сохраненный WORD'></july:wordedit>
 
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
		<july:closebutton page="/"/>&nbsp;<july:currmark>Акты према-передачи</july:currmark>
		</td>
	</tr>
      
</table>

<script language="javascript">
	loadSelectedRow();
	window.location.hash=document.all.selectedID.value;
</script>

</july:editform>
