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
	String gColSpan = "5";
	PeopleToNfsUserListForm listForm = (PeopleToNfsUserListForm)request.getAttribute("PeopleToNfsUserListForm");
	String sortBy = listForm.getOrderBy();
%>

<july:browseform action="/PeopleToNfsUserList.do" styleId="listForm">
<html:hidden property="man"/>
<html:hidden property="orderBy"/>
<html:hidden property="selectedID"/>
<html:hidden property="operation" value=""/>
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
function toggleFilter(n){
	document.all.activestate[n].checked = true;
    document.body.style.cursor="wait";
	listForm.submit();
}
function toggleA(a){
	//document.all.isName[0].checked =false;
	//listForm.name.disabled = false;
	listForm.name.value=a+'*';
	listForm.submit();
}
function DeleteLink(id) {
	if(confirm('Удалить связь c пользователем НФС ?')) {
		document.body.style.cursor="wait";
		listForm.selectedID.value = id;
		listForm.operation.value = "deleteLink";
		listForm.submit();

		return false;
	}
}
function SetMainLink(id) {
	document.body.style.cursor="wait";
	listForm.selectedID.value = id;
	listForm.operation.value = "setMainLink";
	listForm.submit();
}
function toggleALL(){
	//document.all.isName[0].checked =false;
	//listForm.name.disabled = false;
	listForm.name.value='*';
	listForm.submit();
}
</script>
<table class="main" style="font-size: 8pt">
	<tr class="title">
		<td class="title" colspan="<%= gColSpan %>">
	       <html:link page="/ShowPeopleList.do" styleClass="navigator"><bean:message key="label.people"/></html:link> 
	       <july:sepmark/>
	       <july:currmark>Пользователи НФС</july:currmark>
       </td>
	</tr>

	<july:separator colspan="<%= gColSpan %>" />
	
	<TR class="normal">
		<TD colspan="<%= gColSpan %>">
			<table class="find">
				<tr>
					<td class="title">
						&nbsp;<bean:write name="PeopleToNfsUserListForm" property="vo.lastname" filter="true"/>
						&nbsp;<bean:write name="PeopleToNfsUserListForm" property="vo.firstname" filter="true"/>
						&nbsp;<bean:write name="PeopleToNfsUserListForm" property="vo.middlename" filter="true"/>
					</td>
				</tr>
				<%--tr>
					<td class="title"> ФИО польз. НФС: </td>
					<td class="title">
						<A href="javascript:toggleALL()">все</A>&nbsp;&nbsp;&nbsp;
						<html:text styleClass="search" property="name" size="25"/><july:searchbutton/></td>
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
						<july:radio property="activestate" insertable="true" updatable="true" value="ALL"/><A href="javascript:toggleFilter(0)">Все</A>
						<july:radio property="activestate" insertable="true" updatable="true" value="A"/><A href="javascript:toggleFilter(1)">Активные</A>
						<july:radio property="activestate" insertable="true" updatable="true" value="D"/><A href="javascript:toggleFilter(2)">Удаленные</A>
					</td>
				</tr--%>
			</table>
		</TD>
	</TR>
	
	<july:separator colspan="<%= gColSpan %>"/>

      <tr class="title">
          <td colspan="<%= gColSpan %>">
         	<TABLE class="buttons">
            <TR class="title">
              <TD class="buttons">
              	<july:backbutton page="/main.do"/>&nbsp;&nbsp;
              	<%--july:addbutton page="/EditPeople.do?action=Add"/><july:backbutton page="/main.do"/--%>
              	<html:link page="/Nfs_UsersLookupList.do?formname=PeopleToNfsUserListForm&fieldnames=selectedID" onclick="window.open(this.href, 'pWindow', 'top=80, left=200, width=750, height=500, scrollbars=yes, resizable=yes').focus(); return false;" title="справочник пользователей НФС"><IMG SRC="/images/plus.gif" BORDER='0' ALT='справочник пользователей НФС'></html:link>
              </TD>
  			  <TD align="right">отобрано записей:<%= request.getAttribute("numberOfLines") %></TD>
              <TD class="navigator"><july:navigator/></TD>
            </TR>
            </TABLE>
           </td>
      </tr>
      
      <july:separator colspan="<%= gColSpan %>" />
  
    <!-- Table header -->
    <tr class="title">
		<TD class="title">
			<A title="Сортировать по полю 'personID'" href="javascript:SortBy('personID')">код НФС</A>
			<%=isUp(sortBy, "personID")%>
		</TD>
		<TD class="title">
			<A title="Сортировать по полю 'login'" href="javascript:SortBy('login')">login НФС</A>
			<%=isUp(sortBy, "login")%>
		</TD>
		<TD class="title">
			<A title="Сортировать по полю 'fullName'" href="javascript:SortBy('fullName')">ФИО пользователя НФС</A>
			<%=isUp(sortBy, "fullName")%>
		</TD>
		<TD class="title">
			<A title="Сортировать по полю 'признак гл. пользователя(flagMain)'" href="javascript:SortBy('flagMain')">признак</A>
			<%=isUp(sortBy, "flagMain")%>
		</TD>
        <TD class="title">&nbsp;</TD>
    </tr>

<july:separator colspan="<%= gColSpan %>" />


        <!-- Table body -->
    <logic:iterate id="it" name="browseList" type="com.hps.july.valueobject.PeopleToNfsUser_TO">
        <logic:present name="it">
		<%
		    com.hps.july.valueobject.PeopleToNfsUser_TO to = (com.hps.july.valueobject.PeopleToNfsUser_TO)it;
			String className = "normal";
			boolean isFlagMain = false;
			if( to.getVo().getRecordStatus().equals("D") )
				className = "gray";
			if( to.getFlagMain().equals("Y") )
				isFlagMain = true;
		%>        
            <tr class="<%= className%>" onMouseOver="className='select'" onMouseOut="className='<%= className%>'">
                <td class="number">
                    <bean:write name="it" property="vo.personID" filter="true"/>
                </td>
                <td class="text">
                    <bean:write name="it" property="vo.login" filter="true"/>
                </td>
                <td class="text">
                    <bean:write name="it" property="vo.fullName" filter="true"/>
                </td>
                <td class="text">
                	<% if(isFlagMain){ %>
                		<IMG SRC="/images/check_on.gif" BORDER='0' ALT='Главный пользователь'>
                	<% } else if (className == "normal"){ %>
                	<A href='javascript:SetMainLink("<bean:write name="it" property="vo.personID" filter="true"/>")' title="установить Главного пользователя">
                		<IMG SRC="/images/check_off.gif" BORDER='0'></A>
                	<% } %>
                </td>
                <td class="link">
                    <%--july:delbutton page="/EditPeople.do?action=Delete" paramId="man" paramName="it" paramProperty="man" paramScope="page"/--%>
                    <%-- if(!isFlagMain){ --%>
					<A href='javascript:DeleteLink("<bean:write name="it" property="vo.personID" filter="true"/>")' title="Удалить связь с пользователем НФС">
						<IMG SRC="/images/del.gif" BORDER='0' ALT='Удалить связь с пользователем НФС'></A>                   
					<%-- } --%>
                </td>
            </tr>

            <july:separator colspan="<%= gColSpan %>" />

	      </logic:present>
      </logic:iterate>

      <tr class="title">
          <td colspan="<%= gColSpan %>">
         	<TABLE class="buttons">
            <TR class="title">
              <TD class="buttons">
              	<july:backbutton page="/main.do"/>&nbsp;&nbsp;
              	<%--july:addbutton page="/EditPeople.do?action=Add"/><july:backbutton page="/main.do"/--%>
              	<html:link page="/Nfs_UsersLookupList.do?formname=PeopleToNfsUserListForm&fieldnames=selectedID" onclick="window.open(this.href, 'pWindow', 'top=80, left=200, width=750, height=500, scrollbars=yes, resizable=yes').focus(); return false;" title="справочник пользователей НФС"><IMG SRC="/images/plus.gif" BORDER='0' ALT='справочник пользователей НФС'></html:link>
              </TD>
  			  <TD align="right">отобрано записей:<%= request.getAttribute("numberOfLines") %></TD>
              <TD class="navigator"><july:navigator/></TD>
            </TR>
            </TABLE>
           </td>
      </tr>
      
      <july:separator colspan="<%= gColSpan %>" />
      
      <tr class="title">
    	<td class="title" colspan="<%= gColSpan %>">
	       <html:link page="/ShowPeopleList.do" styleClass="navigator"><bean:message key="label.people"/></html:link> 
	       <july:sepmark/>
	       <july:currmark>Пользователи НФС</july:currmark>
	    </td>
      </tr>
      
</table>

</july:browseform>
