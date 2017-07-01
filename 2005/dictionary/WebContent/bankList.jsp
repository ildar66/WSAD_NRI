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
	BankListForm listForm = (BankListForm)session.getAttribute("BankListForm");
	String sortBy = listForm.getSortBy();
%>

<july:browseform action="/ShowBankList.do" styleId="listForm">
<html:hidden property="sortBy"/>
<html:hidden property="selectedID" value="0"/>
<%
	//boolean nosyncnri = AppUtils.getNamedValueInt("SYNCNRIPLATINARENDA") == 0;
	//заменили темповым(если нет, то убрать вызов в напр. BankListForm.init.., чтобы не дроч... все время):
	boolean nosyncnri = true;
	String editAction = "View";
	if(nosyncnri) {
		editAction = "Edit";
	}
%>

<table class="main"   id="tableID">

<july:separator colspan="<%= gColSpan %>" />

<script language="javascript">
function switchNameSearch(state) {
	if(state) {
		listForm.bankname.className = 'editdisabled';
		listForm.bankname.disabled = true;
	} else {
		listForm.bankname.className = 'editsearch';
		listForm.bankname.disabled = false;
	}
}
function switchBikSearch(state) {
	if(state) {
		listForm.bankbik.className = 'editdisabled';
		listForm.bankbik.disabled = true;
	} else {
		listForm.bankbik.className = 'editsearch';
		listForm.bankbik.disabled = false;
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
</script>

<TR class="normal">
 <TD COLSPAN="<%= gColSpan %>">
 
    <table class="find">
    <TR>
       <td class="title">	<bean:message key="label.organization.bik"/></A>
	</td>
       <td class="title"><july:checkbox property="isbik"  onclick="switchBikSearch(document.all.isbik[0].checked)" insertable="true" updatable="true" />&nbsp;<bean:message key="label.search.all"/>&nbsp;&nbsp;&nbsp;<html:text styleClass="search" property="bankbik" size="25" /><july:searchbutton /></td>
     </tr>        
    <TR>
       <td class="title"><bean:message key="label.bank.name"/></td>
       <td class="title"><july:checkbox property="isname" onclick="switchNameSearch(document.all.isname[0].checked)" insertable="true" updatable="true" />&nbsp;<bean:message key="label.search.all"/>&nbsp;&nbsp;&nbsp;<html:text styleClass="search" property="bankname" size="25" /></td>
     </tr>        
     </table>
    
  </TD>
</TR>

<SCRIPT language="javascript">
	switchNameSearch(document.all.isname[0].checked);
	switchBikSearch(document.all.isbik[0].checked);
</SCRIPT>

    <july:separator colspan="<%= gColSpan %>" />
      <tr class="title">
          <td colspan="<%= gColSpan %>"><TABLE class="buttons">
            <TR class="title">
<% if(nosyncnri) { %>
              <TD class="buttons"><july:addbutton page="/EditBank.do?action=Add"/><july:backbutton/></TD>
<% } %>
			  <TD align="right">	отобрано записей:<%= request.getAttribute("numberOfLines") %></TD>
              <TD class="navigator"><july:navigator/></TD>
            </TR>
            </TABLE></TD>
      </tr>
    <july:separator colspan="<%= gColSpan %>" />
  
    <!-- Table header -->
    <tr class="title">
        <TD class="title">&nbsp;</TD>
		<TD class="title">
			<A title="Сортировать по полю 'organization'" href="javascript:SortBy('organization')"><bean:message key="label.code"/></A>
			<%=isUp(sortBy, "organization")%>
		</TD>
		<TD class="title">
			<A title="Сортировать по полю 'bik'" href="javascript:SortBy('bik')"><bean:message key="label.organization.bik"/></A>
			<%=isUp(sortBy, "bik")%>
		</TD>
		<TD class="title">
			<A title="Сортировать по полю 'name'" href="javascript:SortBy('name')"><bean:message key="label.name"/></A>
			<%=isUp(sortBy, "name")%>
		</TD>
		<TD class="title">
			<A title="Сортировать по полю 'koraccount'" href="javascript:SortBy('koraccount')"><bean:message key="label.bank.corraccount"/></A>
			<%=isUp(sortBy, "koraccount")%>
		</TD>

<% if(nosyncnri) { %>
        <TD class="title">&nbsp;</TD>
<% } %>
    </tr>
    
    <july:separator colspan="<%= gColSpan %>" />

        <!-- Table body -->
    <logic:iterate id="org" name="browseList">
        <logic:present name="org">
            <tr class="normal"  id='<bean:write name="org" property="organization" filter="true"/>' onMouseOver="className='select'" onMouseOut="onMouseOutRow(this.id);"   onclick='onClickRow(this.id);' style="font-size:8pt;">
                <td class="text">
					<july:editbutton page="/EditBank.do" action="<%=editAction%>" paramId="organization" paramName="org" paramProperty="organization" paramScope="page"/>
				</td>
                <td class="number">
                      <bean:write name="org" property="organization" filter="true"/>
                </td>
                <td class="text">
                    <bean:write name="org" property="bik" filter="true"/>
                </td>
                <td class="text">
                    <bean:write name="org" property="name" filter="true"/>
                </td>
                <td class="text">
                    <bean:write name="org" property="koraccount" filter="true"/>
                </td>
<% if(nosyncnri) { %>
		<td class="link">
                    <july:delbutton page="/EditBank.do?action=Delete" paramId="organization" paramName="org" paramProperty="organization" paramScope="page"/>
                </td>
<% } %>
            </tr>
            
            <july:separator colspan="<%= gColSpan %>" />
            
	      </logic:present>
      </logic:iterate>

      <tr class="title">
          <td colspan="<%= gColSpan %>"><TABLE class="buttons">
            <TR class="title">
<% if(nosyncnri) { %>
              <TD class="buttons"><july:addbutton page="/EditBank.do?action=Add"/><july:backbutton/></TD>
<% } %>
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