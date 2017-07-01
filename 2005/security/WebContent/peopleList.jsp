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
		return (" <img src='/images/up.gif'  border='0' alt='по возрастанию'> ");
	 else
		return (" <img src='/images/down.gif'  border='0' alt='по убыванию'> "); 
 }
 else return ("");      
}
%>

<%
	String gColSpan = "9";
	PeopleListForm listForm = (PeopleListForm)session.getAttribute("PeopleListForm");
	String sortBy = listForm.getOrderBy();
%>

<july:browseform action="/ShowPeopleList.do" styleId="listForm">
<html:hidden property="orderBy"/>
<html:hidden property="selectedID" value="0"/>
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
	//document.all.isName[0].checked =false;
	//listForm.name.disabled = false;
	listForm.name.value=a+'*';
	listForm.submit();
}
</script>
<table class="main">
	<tr class="title">
		<td class="title" colspan="<%= gColSpan %>"><july:currmark><bean:message key="label.people"/></july:currmark></td>
	</tr>

	<july:separator colspan="<%= gColSpan %>" />
	
	<TR class="normal">
		<TD colspan="<%= gColSpan %>">
			<table class="find">
				<tr>
					<td class="title"><bean:message key="label.people.lastname"/></td>
					<td class="title"><html:text styleClass="search" property="name" size="25"/><july:searchbutton/></td>
					<td class="title" nowrap>
					<%
						String[] a = { "А", "Б", "В", "Г", "Д", "Е", "Ё", "Ж", "З", "И", "Й", "К", "Л", "М", "Н", "О", "П", "Р", "С", "Т", "У", "Ф", "Х", "Ц", "Ч", "Ш", "Щ", "Э", "Ю", "Я" };
						for (int i = 0; i < a.length; i++) {%>
							<A href="javascript:toggleA('<%= a[i]%>')"><%= a[i]%></A>
							<%if(a[i].equals("Н")){%><BR><%}%>
					<%}%>
					</td>
				</tr>
				<tr>
					<td class="title" colspan="2">
						<july:radio property="activestate" insertable="true" updatable="true" value="ALL"/>Все
						<july:radio property="activestate" insertable="true" updatable="true" value="Y"/>Активные
						<july:radio property="activestate" insertable="true" updatable="true" value="N"/>Не активные
					</td>
				</tr>
			</table>
		</TD>
	</TR>
	
	<july:separator colspan="<%= gColSpan %>"/>

      <tr class="title">
          <td colspan="<%= gColSpan %>"><TABLE class="buttons">
            <TR class="title">
              <TD class="buttons"><july:addbutton page="/EditPeople.do?action=Add"/><july:backbutton page="/main.do"/></TD>
  			  <TD align="right">отобрано записей:<%= request.getAttribute("numberOfLines") %></TD>
              <TD class="navigator"><july:navigator/></TD>
            </TR>
            </TABLE></TD>
      </tr>
      
      <july:separator colspan="<%= gColSpan %>" />
  
    <!-- Table header -->
    <tr class="title">
		<TD class="title">
			<A title="Сортировать по полю 'man'" href="javascript:SortBy('man')">Код</A>
			<%=isUp(sortBy, "man")%>
		</TD>
		<TD class="title">
			<A title="Сортировать по полю 'lastname'" href="javascript:SortBy('lastname')">Фамилия</A>
			<%=isUp(sortBy, "lastname")%>
		</TD>
		<TD class="title">
			<A title="Сортировать по полю 'firstname'" href="javascript:SortBy('firstname')">Имя</A>
			<%=isUp(sortBy, "firstname")%>
		</TD>
		<TD class="title">
			<A title="Сортировать по полю 'middlename'" href="javascript:SortBy('middlename')">Отчество</A>
			<%=isUp(sortBy, "middlename")%>
		</TD>
		<TD class="title">
			<A title="Сортировать по полю 'passportser'" href="javascript:SortBy('passportser')">Паспорт</A>
			<%=isUp(sortBy, "passportser")%>
		</TD>
        <july:headercolumn key="label.operators" colType="link"/>
        <july:headercolumn key="label.workers" colType="link"/>
        <TD class="title"><B>НФС</B></TD>
        <TD class="title">&nbsp;</TD>
    </tr>

<july:separator colspan="<%= gColSpan %>" />


        <!-- Table body -->
    <logic:iterate id="it" name="browseList" type="com.hps.july.valueobject.People_VO">
        <logic:present name="it">
            <tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
                <td class="number">
                      <bean:write name="it" property="man" filter="true"/>
                </td>
                <td class="text">
                    <july:editlink page="/EditPeople.do" action="Edit" paramId="man" paramName="it" paramProperty="man" paramScope="page">
                    <bean:write name="it" property="lastname" filter="true"/>
                    </july:editlink>
                </td>
                <td class="text">
                    <bean:write name="it" property="firstname" filter="true"/>
                </td>
                <td class="text">
                    <bean:write name="it" property="middlename" filter="true"/>
                </td>
                <td class="text">
                    <bean:write name="it" property="passportser" filter="true"/>
                </td>
                <td class="link">
                    <july:link page="/ShowOperatorList.do" paramId="man" paramName="it" paramProperty="man" paramScope="page" alttext="msg.operators">
                        <bean:message key="label.operators"/>
                    </july:link>
                </td>
                <td class="link">
                    <july:link page="/ShowWorkerList.do" paramId="man" paramName="it" paramProperty="man" paramScope="page" alttext="msg.workers">
                        <bean:message key="label.workers"/>
                    </july:link>
                </td>
                <td class="link">
                    <july:link page="/PeopleToNfsUserList.do" paramId="man" paramName="it" paramProperty="man" paramScope="page">
                        связь
                    </july:link>
                </td>                
                <td class="link">
                    <july:delbutton page="/EditPeople.do?action=Delete" paramId="man" paramName="it" paramProperty="man" paramScope="page"/>
                </td>
            </tr>

            <july:separator colspan="<%= gColSpan %>" />

	      </logic:present>
      </logic:iterate>

      <tr class="title">
          <td colspan="<%= gColSpan %>"><TABLE class="buttons">
            <TR class="title">
              <TD class="buttons"><july:addbutton page="/EditPeople.do?action=Add"/><july:backbutton page="/main.do"/></TD>
  			  <TD align="right">отобрано записей:<%= request.getAttribute("numberOfLines") %></TD>
              <TD class="navigator"><july:navigator/></TD>
            </TR>
            </TABLE></TD>
      </tr>
      
      <july:separator colspan="<%= gColSpan %>" />
      
      <tr class="title">
    	<td class="title" colspan="<%= gColSpan %>">
           <july:currmark><bean:message key="label.people"/></july:currmark></td>
      </tr>
      
</table>

</july:browseform>
