<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import = "com.hps.july.arenda.formbean.*"%>

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
	OrganizationLookupListForm listForm = (OrganizationLookupListForm)session.getAttribute("OrganizationLookupListForm");
	String sortBy = listForm.getSortBy();
%>

<july:browseform action="/ShowOrganizationLookupList.do" styleId="listForm">
<html:hidden property="sortBy"/>
<html:hidden property="selectedID" value="0"/>

<july:lookupresult tableId="tableID" resultCols="0;4"/>
<script language="javascript">
function switchNameSearch(state) {
	if(state) {
		listForm.orgname.className = 'editdisabled';
		listForm.orgname.disabled = true;
	} else {
		listForm.orgname.className = 'editsearch';
		listForm.orgname.disabled = false;
	}
	return false;
}
function switchInnSearch(state) {
	if(state) {
		listForm.orginn.className = 'editdisabled';
		listForm.orginn.disabled = true;
	} else {
		listForm.orginn.className = 'editsearch';
		listForm.orginn.disabled = false;
	}
	return false;
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

<table class="main">

<tr class="title">
	<td class="title" colspan="<%= gColSpan %>">
		<bean:message key="label.choose.executor"/>
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>"/>

<TR class="normal">
 <TD colspan="<%= gColSpan %>">
    <table class="find">
    <TR>
       <td class="title"><bean:message key="label.organization.inn"/></td>
       <td class="title"><july:checkbox property="isinn" insertable="true" updatable="true" onclick="switchInnSearch(document.all.isinn[0].checked)"/>&nbsp;<bean:message key="label.filter.all"/></td>
	   <td class="title"><html:text styleClass="editdisabled" property="orginn" styleId="orginn" size="25" disabled="true"/><july:searchbutton/></td>
     </TR>
    <TR>
       <td class="title"><bean:message key="label.organization.name"/></td>
       <td class="title"><july:checkbox property="isorgname" styleId="isorgname" insertable="true" updatable="true" onclick="switchNameSearch(document.all.isorgname[0].checked)"/>&nbsp;<bean:message key="label.filter.all"/></td>
	   <td class="title"><html:text styleClass="search" property="orgname" styleId="orgname" size="25"/></td>
     </TR>
     </table>
  </TD>
</TR>

<tr class="title">
	<td colspan="<%= gColSpan %>">
		<TABLE class="buttons">
			<TR class="title">
				<TD class="buttons">
					<july:closebutton page="/"/>				
					<A href='/dict/OrganizationDialog.do?action=Add' onclick='window.open(this.href, "OrganizationDialog", "top=100, left=400, width=600, height=600, scrollbars=yes, resizable=yes").focus(); return false;'>
						<IMG SRC="/images/plus.gif" BORDER='0' ALT='Добавить запись'>
					</A>						
				</TD>
				<td align="right">
					отобрано записей:<%= request.getAttribute("numberOfLines") %>
				</td>
				<TD class="navigator"><july:navigator/></TD>
			</TR>
		</TABLE>
	</td>
</tr>
<tr>
		<td colspan="<%= gColSpan %>">
			<table class="main" id="tableID">
				<tr class="title">
					<td class="title" style="visibility:hidden;display:none;">&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td class="title" nowrap>
						<A title="Сортровать по полю 'инн'" href="javascript:SortBy('inn')"><bean:message key="label.organization.inn"/></A>
						<%=isUp(sortBy, "inn")%>
					</td>
					<td class="title" style="visibility:hidden;display:none;">&nbsp;</td>
					<td class="title" nowrap>
						<A title="Сортровать по полю 'Наименование'" href="javascript:SortBy('shortname')"><bean:message key="label.name"/></A>
						<%=isUp(sortBy, "shortname")%>
					</td>
					<td class="title" nowrap>
						<A title="Сортровать по полю 'Полное Наименование'" href="javascript:SortBy('name')">Полное Наименование</A>
						<%=isUp(sortBy, "name")%>
					</td>
					<td>&nbsp;</td>
				</tr>
			    <logic:iterate id="org" name="browseList" indexId="index">
			        <logic:present name="org">
			        	<%--tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'"--%>
						<tr class="normal"  id='<bean:write name="org" property="organization" filter="true"/>' onMouseOver="className='select'" onMouseOut="onMouseOutRow(this.id);"   onclick='onClickRow(this.id);' style="font-size:8pt;">
							<td class="text" style="visibility:hidden;display:none;"><bean:write name="org" property="organization" filter="true"/></td>
							<td>
								<A href='/dict/OrganizationDialog.do?action=Edit&organization=<bean:write name="org" property="organization" filter="true"/>' onclick='window.open(this.href, "OrganizationDialog", "top=100, left=400, width=600, height=600, scrollbars=yes, resizable=yes").focus(); return false;'><IMG SRC="/images/izmena.gif" BORDER='0' ALT='Изменить запись'></A>										
							</td>
							<td><july:lookupreturn>Выбрать</july:lookupreturn></td>
							<td class="text"><bean:write name="org" property="inn" filter="true"/></td>
							<td class="text" style="visibility:hidden;display:none;"><bean:write name="org" property="name" filter="true"/></td>
							<td class="text"  title='кпп=<bean:write name="org" property="kpp" filter="true"/> &#13фио=<bean:write name="org" property="directorfio" filter="true"/>&#13юр. адр.=<bean:write name="org" property="legaladdress" filter="true"/> &#13тел.=<bean:write name="org" property="phone" filter="true"/> '>
								<bean:write name="org" property="shortname" filter="true"/>
							</td>
							<td class="text"><bean:write name="org" property="realName" filter="true"/></td>
							<td>
								<A href='/dict/OrganizationDialog.do?action=Delete&organization=<bean:write name="org" property="organization" filter="true"/>' onclick='window.open(this.href, "OrganizationDialog", "top=100, left=400, width=600, height=600, scrollbars=yes, resizable=yes").focus(); return false;'>
					                <img src="/images/del.gif" border="0" alt='<bean:message key="label.delete"/>'>
								</A>							
							</td>
						</tr>
						<july:separator colspan="<%= gColSpan %>"/>
				  </logic:present>
			      <logic:notPresent name="org">
        				<tr class="normal">
							<td class="text" colspan="<%= gColSpan %>">
        		           <bean:message key="label.norecords"/>
							</td>
        				</tr>
						<july:separator colspan="<%= gColSpan %>"/>
			      </logic:notPresent>
				</logic:iterate>
			</table>
		</td>
</tr>

<%--july:separator colspan="<%= gColSpan %>"/--%>

<tr class="title">
	<td  colspan="<%= gColSpan %>">
		<TABLE class="buttons">
			<TR class="title">
				<TD class="buttons">
					<july:closebutton page="/"/>				
					<A href='/dict/OrganizationDialog.do?action=Add' onclick='window.open(this.href, "OrganizationDialog", "top=100, left=400, width=600, height=600, scrollbars=yes, resizable=yes").focus(); return false;'>
						<IMG SRC="/images/plus.gif" BORDER='0' ALT='Добавить запись'>
					</A>				
				</TD>
				<td align="right">
					отобрано записей:<%= request.getAttribute("numberOfLines") %>
				</td>
				<TD class="navigator"><july:navigator/></TD>
			</TR>
		</TABLE>
	</td>
</tr>

</table>

</july:browseform>

<SCRIPT language="javascript">
	switchNameSearch(document.all.isorgname[0].checked);
	switchInnSearch(document.all.isinn[0].checked);
</SCRIPT>
<script language="javascript">
	loadSelectedRow();
	window.location.hash=document.all.selectedID.value;
</script>