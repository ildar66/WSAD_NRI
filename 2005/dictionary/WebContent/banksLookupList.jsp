<%@ page language = "java" %>
<%@ page import = "com.hps.july.util.*"%>
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
	java.lang.String gColSpan = "6"; 
	BanksLookupListForm listForm = (BanksLookupListForm)session.getAttribute("BanksLookupListForm");
	String sortBy = listForm.getSortBy();
	boolean isEdit = request.isUserInRole("administrator") || request.isUserInRole("developer") || request.isUserInRole("EditBank");
%>

<july:browseform action="/BanksLookupList.do" styleId="listForm">
<html:hidden property="sortBy"/>
<html:hidden property="selectedID" value="0"/>
<html:hidden property="formname"/>
<html:hidden property="fieldnames"/>

<script language="javascript">
function switchNameSearch(state) {
	if(state) {
		listForm.name.className = 'editdisabled';
		listForm.name.disabled = true;
	} else {
		listForm.name.className = 'editsearch';
		listForm.name.disabled = false;
	}
}
function switchBikSearch(state) {
	if(state) {
		listForm.bik.className = 'editdisabled';
		listForm.bik.disabled = true;
	} else {
		listForm.bik.className = 'editsearch';
		listForm.bik.disabled = false;
	}
}
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
function toggleA(a){
	document.all.isName[0].checked =false;
	switchNameSearch(false);
	listForm.name.value=a+'*';
	listForm.submit();
}
function toggleStateNameALL(){
	if(document.all.isName[0].checked){
		document.all.isName[0].checked =false;
		switchNameSearch(false);
		listForm.name.focus();
	}else{
		document.all.isName[0].checked = true;
		switchNameSearch(true);
		listForm.submit();
	}
}
function toggleStateBikALL(){
	if(document.all.isBik[0].checked){
		document.all.isBik[0].checked =false;
		switchBikSearch(false);
		listForm.bik.focus();
	}else{
		document.all.isBik[0].checked = true;
		switchBikSearch(true);
		listForm.submit();
	}
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
		document.body.style.cursor="wait";
		window.opener.focus();
	}
	window.close();
}
</script>

<table class="main"   id="tableID">

<july:separator colspan="<%= gColSpan %>" />

<TR class="normal">
 <TD COLSPAN="<%= gColSpan %>">
 
    <table class="find">
    <TR>
        <td class="title"><bean:message key="label.organization.bik"/>:</td>
        <td class="title" colspan="2"><july:checkbox property="isBik"  onclick="switchBikSearch(document.all.isBik[0].checked)" insertable="true" updatable="true" />&nbsp;<A href="javascript:toggleStateBikALL()">все</A>&nbsp;&nbsp;&nbsp;<html:text styleClass="search" property="bik" size="25" /><july:searchbutton /></td>
     </tr>        
    <TR>
        <td class="title"><bean:message key="label.bank.name"/>:</td>
        <td class="title"><july:checkbox property="isName" onclick="switchNameSearch(document.all.isName[0].checked)" insertable="true" updatable="true" />&nbsp;<A href="javascript:toggleStateNameALL()">все</A>&nbsp;&nbsp;&nbsp;<html:text styleClass="search" property="name" size="25" /></td>
		<td class="title" nowrap>
		<%
			String[] a = { "А", "Б", "В", "Г", "Д", "Е", "Ё", "Ж", "З", "И", "Й", "К", "Л", "М", "Н", "О", "П", "Р", "С", "Т", "У", "Ф", "Х", "Ц", "Ч", "Ш", "Щ", "Э", "Ю", "Я" };
			for (int i = 0; i < a.length; i++) {%>
				<A href="javascript:toggleA('<%= a[i]%>')"><%= a[i]%></A>
				<%if(a[i].equals("Н")){%><BR><%}%>
		<%}%>
		</td>       
     </tr>        
     </table>
    
  </TD>
</TR>

<SCRIPT language="javascript">
	switchNameSearch(document.all.isName[0].checked);
	switchBikSearch(document.all.isBik[0].checked);
</SCRIPT>

    <july:separator colspan="<%= gColSpan %>" />
      <tr class="title">
          <td colspan="<%= gColSpan %>"><TABLE class="buttons">
            <TR class="title">
              <TD class="buttons">
<% if(isEdit) { %>              
				<A href='BanksDialog.do?action=Add' onclick='window.open(this.href, "BanksDialog", "top=300, left=300, width=600, height=350, scrollbars=yes, resizable=yes").focus(); return false;'>
					<IMG SRC="/images/plus.gif" BORDER='0' ALT='Добавить запись'></A>              	
<% } %>					
              	<%--july:backbutton/--%>
              </TD>
			  <TD align="right">	отобрано записей:<%= request.getAttribute("numberOfLines") %></TD>
              <TD class="navigator"><july:navigator/></TD>
            </TR>
            </TABLE></TD>
      </tr>
    <july:separator colspan="<%= gColSpan %>" />
  
    <!-- Table header -->
    <tr class="title">
        <TD class="title">&nbsp;</TD>
        <TD class="title">&nbsp;</TD>
		<%--TD class="title">
			<A title="Сортировать по полю 'idBank'" href="javascript:SortBy('idBank')"><bean:message key="label.code"/></A>
			<%=isUp(sortBy, "idBank")%>
		</TD--%>
		<TD class="title">
			<A title="Сортировать по полю 'bik'" href="javascript:SortBy('bik')"><bean:message key="label.organization.bik"/></A>
			<%=isUp(sortBy, "bik")%>
		</TD>
		<TD class="title">
			<A title="Сортировать по полю 'name'" href="javascript:SortBy('name')"><bean:message key="label.name"/></A>
			<%=isUp(sortBy, "name")%>
		</TD>
		<TD class="title">
			<A title="Сортировать по полю 'korAccount'" href="javascript:SortBy('korAccount')"><bean:message key="label.bank.corraccount"/></A>
			<%=isUp(sortBy, "korAccount")%>
		</TD>

<% if(isEdit) { %>
        <TD class="title">&nbsp;</TD>
<% } %>
    </tr>
    
    <july:separator colspan="<%= gColSpan %>" />

        <!-- Table body -->
    <logic:iterate id="org" name="browseList">
        <logic:present name="org">
		<%
		    com.hps.july.valueobject.Banks_VO bankVO = (com.hps.july.valueobject.Banks_VO)org;
			boolean idDelete = bankVO.getRecordStatus().equals("D");
			String editAction = (isEdit && (bankVO.getSource().intValue() == 2))?"Edit":"View";
		%>        
		<%if(!idDelete){%>       
            <tr class="normal"  id='<bean:write name="org" property="idBank" filter="true"/>' onMouseOver="className='select'" onMouseOut="onMouseOutRow(this.id);" onclick='onClickRow(this.id);' style="font-size:8pt;">
        <%}else{%>
        	<tr class="gray"  id='<bean:write name="org" property="idBank" filter="true"/>' onMouseOver="className='select'" onMouseOut="className='gray';" style="font-size:8pt;">
        <%}%>
                <td class="text">
	                <%if(!idDelete){%>
						<A href='BanksDialog.do?action=<%=editAction%>&id=<bean:write name="org" property="idBank" filter="true"/>' onclick='window.open(this.href, "BanksDialog", "top=300, left=300, width=600, height=350, scrollbars=yes, resizable=yes").focus(); return false;'><IMG SRC="/images/izmena.gif" BORDER='0' ALT='Изменить запись'></A>
					<%}%>
				</td>
				<td class="text">
                	<%if(!idDelete){%>
                		<A href="javascript:Go('<bean:write name="org" property="idBank" filter="true"/>|<bean:write name="org" property="name" filter="true"/>|<bean:write name="org" property="bik" filter="true"/>')" title="Выберите запись">
                    		выбрать</A>
                    <%}else{%>
                    		&nbsp;
                    <%}%>				
				</td>
                <%--td class="number">
                      <bean:write name="org" property="idBank" filter="true"/>
                </td--%>
                <td class="text">
                    <bean:write name="org" property="bik" filter="true"/>
                </td>
                <td class="text">
                	<%if(!idDelete){%>
                		<A href="javascript:Go('<bean:write name="org" property="idBank" filter="true"/>|<bean:write name="org" property="name" filter="true"/>|<bean:write name="org" property="bik" filter="true"/>')" title="Выберите запись">
                    		<bean:write name="org" property="name" filter="true"/></A>
                    <%}else{%>
                    	<bean:write name="org" property="name" filter="true"/>
                    <%}%>
                </td>
                <td class="text">
                    <bean:write name="org" property="korAccount" filter="true"/>
                </td>
<% if(isEdit) { %>
				<td class="link">
					<%if( !idDelete && isEdit && (bankVO.getSource().intValue() == 2) ){%>
                    	<A href='BanksDialog.do?action=Delete&id=<bean:write name="org" property="idBank" filter="true"/>' onclick='window.open(this.href, "BanksDialog", "top=300, left=300, width=600, height=350, scrollbars=yes, resizable=yes").focus(); return false;'><IMG SRC="/images/del.gif" BORDER='0' ALT='Удалить запись'></A>
                    <%}%>
                </td>
<% } %>
            </tr>
            
            <july:separator colspan="<%= gColSpan %>" />
            
	      </logic:present>
      </logic:iterate>

      <tr class="title">
          <td colspan="<%= gColSpan %>"><TABLE class="buttons">
            <TR class="title">
              <TD class="buttons">
<% if(isEdit) { %> 
				<A href='BanksDialog.do?action=Add' onclick='window.open(this.href, "BanksDialog", "top=300, left=300, width=600, height=350, scrollbars=yes, resizable=yes").focus(); return false;'>
					<IMG SRC="/images/plus.gif" BORDER='0' ALT='Добавить запись'></A>              	
<% } %>					
              	<%--july:backbutton/--%>
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
	loadSelectedRow();
	window.location.hash=document.all.selectedID.value;
</script>