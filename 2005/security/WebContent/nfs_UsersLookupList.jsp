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
	Nfs_UsersLookupListForm listForm = (Nfs_UsersLookupListForm)session.getAttribute("Nfs_UsersLookupListForm");
	String sortBy = listForm.getOrderBy();
%>

<july:browseform action="/Nfs_UsersLookupList.do" styleId="listForm">
<html:hidden property="orderBy"/>
<html:hidden property="selectedID" value="0"/>
<html:hidden property="formname"/>
<html:hidden property="fieldnames"/>

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
function toggleA(a){
	//document.all.isName[0].checked =false;
	//listForm.name.disabled = false;
	listForm.name.value=a+'*';
	listForm.submit();
}
function toggleALL(){
	//document.all.isName[0].checked =false;
	//listForm.name.disabled = true;
	listForm.name.value='*';
	listForm.submit();
}
function toggleFilter(n){
	document.all.activestate[n].checked = true;
    document.body.style.cursor="wait";
	listForm.submit();
}
function Go(strval) {
	var thisform = document.forms[0];
	var outform = window.opener.document.forms[thisform.formname.value];
	if(outform != null)
	{
		var names = thisform.fieldnames.value.split('|'), values = strval.split('|');
		for(var i in names) {
			if(names[i].length > 0)
				outform[names[i]].value = unescape(values[i]);
		}
	}
	Close();
}
function Close()
{
	var thisform = document.forms[0];
	var outform = window.opener.document.forms[thisform.formname.value];
	if(outform != null) {
		outform.operation.value = "addLink";
		outform.submit();
		//document.body.style.cursor="wait";
		//window.opener.focus();
	}
	window.close();
}
</script>
<table class="main" style="font-size: 8pt">
	
	<TR class="normal">
		<TD colspan="<%= gColSpan %>">  
			<table class="find">
				<tr>
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
				</tr>
			</table>
		</TD>
	</TR>
	
	<july:separator colspan="<%= gColSpan %>"/>

      <tr class="title">
          <td colspan="<%= gColSpan %>">
          	<TABLE class="buttons">
	            <TR class="title">
	              <TD class="buttons"><july:closebutton page="/"/></TD>
	  			  <TD align="right">отобрано записей:<%= request.getAttribute("numberOfLines") %></TD>
	              <TD class="navigator"><july:navigator/></TD>
	            </TR>
            </TABLE>
          </td>
      </tr>
      
      <july:separator colspan="<%= gColSpan %>" />
  
    <!-- Table header -->
    <tr class="title">
    	<TD class="title">&nbsp;</TD>
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
    </tr>

<july:separator colspan="<%= gColSpan %>" />


        <!-- Table body -->
    <logic:iterate id="it" name="browseList" type="com.hps.july.valueobject.Nfs_Users_VO">
        <logic:present name="it">
		<%
		    com.hps.july.valueobject.Nfs_Users_VO nfsVO = (com.hps.july.valueobject.Nfs_Users_VO)it;
			String className = "normal";
			if( nfsVO.getRecordStatus().equals("D") )
				className = "gray";
		%>        
            <tr class="<%= className%>" onMouseOver="className='select'" onMouseOut="className='<%= className%>'">
            	<td>&nbsp;</td>
                <td class="number">
                	<%if( className == "normal" ){%>
					<A href='javascript:Go("<bean:write name="it" property="personID" filter="true"/>")' title="Выберите запись">                
                    	<bean:write name="it" property="personID" filter="true"/></A>
                    <%}else{%>
                    	<bean:write name="it" property="personID" filter="true"/>
                    <%}%>
                </td>
                <td class="text">
                    <bean:write name="it" property="login" filter="true"/>
                </td>
                <td class="text">
                    <bean:write name="it" property="fullName" filter="true"/>
                </td>
            </tr>

            <july:separator colspan="<%= gColSpan %>" />

	      </logic:present>
      </logic:iterate>

      <tr class="title">
          <td colspan="<%= gColSpan %>">
          	<TABLE class="buttons">
	            <TR class="title">
	              <TD class="buttons"><july:closebutton page="/"/></TD>
	  			  <TD align="right">отобрано записей:<%= request.getAttribute("numberOfLines") %></TD>
	              <TD class="navigator"><july:navigator/></TD>
	            </TR>
            </TABLE>
          </td>
      </tr>
      
</table>

</july:browseform>
