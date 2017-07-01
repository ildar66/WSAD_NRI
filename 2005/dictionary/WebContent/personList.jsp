<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import = "com.hps.july.dictionary.formbean.*"%>

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
	java.lang.String gColSpan = "7";
	PersonListForm listForm = (PersonListForm)session.getAttribute("PersonListForm");
	String sortBy = listForm.getSortBy();
%>

<july:browseform action="/ShowPersonList.do" styleId="listForm">
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
function switchName(state) {
	if(state) {
		listForm.name.className = 'editdisabled';
		listForm.name.disabled = true;
	} else {
		listForm.name.className = 'editsearch';
		listForm.name.disabled = false;
	}
}
function toggleStateALL(){
	if(document.all.isName[0].checked){
		document.all.isName[0].checked =false;
		switchName(false);
	}else{
		document.all.isName[0].checked = true;
		listForm.submit();
	}
}
function toggleA(a){
	document.all.isName[0].checked =false;
	listForm.name.disabled = false;
	listForm.name.value=a+'*';
	listForm.submit();
}
</script>

<table class="main"  id="tableID">

<july:separator colspan="<%= gColSpan %>" />

<TR class="normal">
 <TD colspan="<%= gColSpan %>">
 
    <table class="find">
     <TR>
       <td class="title">поиск по ФИО:</td>
		<td class="title">
			<july:checkbox property="isName"  onclick="switchName(document.all.isName[0].checked)" insertable="true" updatable="true" />	<A href="javascript:toggleStateALL()">все</A>&nbsp;&nbsp;&nbsp;
			<html:text styleClass="search" property="name" size="25" />
			<july:searchbutton />
		</td>
		<td class="title" nowrap>
		<%
			String[] a = { "А", "Б", "В", "Г", "Д", "Е", "Ё", "Ж", "З", "И", "Й", "К", "Л", "М", "Н", "О", "П", "Р", "С", "Т", "У", "Ф", "Х", "Ц", "Ч", "Ш", "Щ", "Э", "Ю", "Я" };
			for (int i = 0; i < a.length; i++) {%>
				<A href="javascript:toggleA('<%= a[i]%>')"><%= a[i]%></A>
				<%if(a[i].equals("Н")){%><BR><%}%>
		<%}%>
		</td>
     </TR>
   </table>
    
  </TD>
</TR>


<july:separator colspan="<%= gColSpan %>" />

        <tr class="title">
          <td colspan="<%= gColSpan %>"><TABLE class="buttons">
            <TR class="title">
              <TD class="buttons">
					<A href='PersonDialog.do?action=Add' onclick='window.open(this.href, "PersonDialog", "top=100, left=100, width=500, height=300, scrollbars=yes, resizable=yes").focus(); return false;'>
						<IMG SRC="/images/plus.gif" BORDER='0' ALT='Добавить запись'>
					</A>
				</TD>
			  <TD align="right">отобрано записей:<%= request.getAttribute("numberOfLines") %></TD>
              <TD class="navigator"><july:navigator/></TD>
            </TR>
            </TABLE></TD>
        </tr>
        
      <july:separator colspan="<%= gColSpan %>" />

        <!-- Table header -->
        <tr class="title">
            <TD class="title">&nbsp;</TD>
			<TD class="title" nowrap>
				<A title="Сортировать по полю 'lastname'" href="javascript:SortBy('lastname')">ФИО</A>
				<%=isUp(sortBy, "lastname")%>
			</TD>
			<TD class="title" nowrap>
				<A title="Сортировать по полю 'passportser'" href="javascript:SortBy('passportser')">серия паспорта</A>
				<%=isUp(sortBy, "passportser")%>
			</TD>
			<TD class="title" nowrap>
				<A title="Сортировать по полю 'passportnum'" href="javascript:SortBy('passportnum')">номер паспорта</A>
				<%=isUp(sortBy, "passportnum")%>
			</TD>
			<TD class="title" nowrap>
				<A title="Сортировать по полю 'passportdate'" href="javascript:SortBy('passportdate')">когда выдан</A>
				<%=isUp(sortBy, "passportdate")%>
			</TD>
			<TD class="title" nowrap>
				<A title="Сортировать по полю 'passportwhom'" href="javascript:SortBy('passportwhom')">кем выдан</A>
				<%=isUp(sortBy, "passportwhom")%>
			</TD>
            <TD class="title">&nbsp;</TD>
        </tr>

<july:separator colspan="<%= gColSpan %>" />


        <!-- Table body -->
        <logic:iterate id="person" name="browseList" type="com.hps.july.dictionary.valueobject.Person_VO">
            <logic:present name="person">
            <tr class="normal" id='<bean:write name="person" property="organization" filter="true"/>' onMouseOver="className='select'" onMouseOut="onMouseOutRow(this.id);" style="font-size:8pt;" onclick='onClickRow(this.id);'>
				<td class="link">
					<july:canedit>
					<A href='PersonDialog.do?action=Edit&id=<bean:write name="person" property="organization" filter="true"/>' onclick='window.open(this.href, "PersonDialog", "top=100, left=100, width=500, height=300, scrollbars=yes, resizable=yes").focus(); return false;'><IMG SRC="/images/izmena.gif" BORDER='0' ALT='Изменить запись'></A>
					</july:canedit>
				</td>
                <td class="text" align="right">
                    <bean:write name="person" property="name" filter="true"/>
                </td>
                <td class="text">
                      <bean:write name="person" property="passportser" filter="true"/>
                </td>
                <td class="text">
                      <bean:write name="person" property="passportnum" filter="true"/>
                </td>
                <td class="text">
                    <july:datewrite name="person" property="passportdate"/>
                </td>
                <td class="number">
                    <bean:write name="person" property="passportwhom" filter="true"/>
                </td>
                <td class="link">
                   <july:canedit>
					<A href='PersonDialog.do?action=Delete&id=<bean:write name="person" property="organization" filter="true"/>' onclick='window.open(this.href, "PersonDialog", "top=100, left=100, width=500, height=300, scrollbars=yes, resizable=yes").focus(); return false;'>
                        <img src="/images/del.gif" border="0" alt='<bean:message key="label.delete"/>'>
					</A>
                   </july:canedit>
                </td>
            </tr>

            <july:separator colspan="<%= gColSpan %>" />

	        </logic:present>
        </logic:iterate>

        <tr class="title">
          <td colspan="<%= gColSpan %>"><TABLE class="buttons">
            <TR class="title">
              <TD class="buttons">
					<A href='PersonDialog.do?action=Add' onclick='window.open(this.href, "PersonDialog", "top=100, left=100, width=500, height=300, scrollbars=yes, resizable=yes").focus(); return false;'>
						<IMG SRC="/images/plus.gif" BORDER='0' ALT='Добавить запись'>
					</A>
			 </TD>
			  <TD align="right">отобрано записей:<%= request.getAttribute("numberOfLines") %></TD>
              <TD class="navigator"><july:navigator/></TD>
            </TR>
            </TABLE></TD>
        </tr>
        
      <july:separator colspan="<%= gColSpan %>" />
    </table>

</july:browseform>

<script language="javascript">
	switchName(document.all.isName[0].checked);
	loadSelectedRow();
	window.location.hash=document.all.selectedID.value;
</script>
