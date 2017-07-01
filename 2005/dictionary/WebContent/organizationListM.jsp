<%@ page language="java" %>
<%@ page contentType="text/html; charset=windows-1251" %>
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
	java.lang.String gColSpan = "10";
	OrganizationListMForm listForm = (OrganizationListMForm)session.getAttribute("OrganizationListMForm");
	String sortBy = listForm.getSortBy();
%>

<july:browseform action="/ShowOrganizationListM.do" styleId="listForm">
<html:hidden property="sortBy"/>
<html:hidden property="selectedID" value="0"/>

<script language="javascript">
function switchNameSearch(state) {
	if(state) {
		listForm.orgname.className = 'editdisabled';
		listForm.orgname.disabled = true;
	} else {
		listForm.orgname.className = 'editsearch';
		listForm.orgname.disabled = false;
	}
}
function switchInnSearch(state) {
	if(state) {
		listForm.orginn.className = 'editdisabled';
		listForm.orginn.disabled = true;
	} else {
		listForm.orginn.className = 'editsearch';
		listForm.orginn.disabled = false;
	}
}
function switchALL(chBoxALL){
	switchCheckBox(chBoxALL);
	switchIsAll(chBoxALL.checked);
}
function switchIsAll(state) {
	if(state) {
		document.all.selissupplier[0].checked = false;
		document.all.selisprovider[0].checked = false;
		document.all.selisrenter[0].checked = false;
		document.all.isChannalRenter[0].checked = false;
		
		document.all.selissupplier[0].disabled = true;
		document.all.selisprovider[0].disabled = true;
		document.all.selisrenter[0].disabled = true;
		document.all.isChannalRenter[0].disabled = true;
	}
	else{
		document.all.selissupplier[0].disabled = false;
		document.all.selisprovider[0].disabled = false;
		document.all.selisrenter[0].disabled = false;
		document.all.isChannalRenter[0].disabled = false;
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
function switchCheckBox(chBox){
	if(chBox.disabled)
		return;
	if(chBox.checked){
		chBox.checked = false;
	}else{
		chBox.checked = true;
	}
}
</script>
<table class="main"   id="tableID">

<july:separator colspan="<%= gColSpan %>"/>
<TR class="normal">
	<TD colspan="<%= gColSpan %>">
	<table class="find" style="font-size: 8pt;">
	<TR>
		<td class="title">
			<bean:message key="label.organization.inn"/>
		</td>
		<td class="title">
			<july:checkbox property="isinn" insertable="true" updatable="true" onclick="switchInnSearch(document.all.isinn[0].checked)"/>&nbsp;
			<A href="javascript:switchCheckBox(document.all.isinn[0]);switchInnSearch(document.all.isinn[0].checked);" style="text-decoration: none;"><bean:message key="label.search.all"/></A>
		</td>
		<td class="title">
			<html:text styleClass="editdisabled" property="orginn" styleId="orginn" size="25" disabled="true"/>
			<july:searchbutton/>
		</td>
	</tr>
	<TR>
		<td class="title">
			<bean:message key="label.organization.name"/>
		</td>
		<td class="title">
			<july:checkbox property="isorgname" styleId="isorgname" insertable="true" updatable="true" onclick="switchNameSearch(document.all.isorgname[0].checked)"/>&nbsp;
			<A href="javascript:switchCheckBox(document.all.isorgname[0]);switchNameSearch(document.all.isorgname[0].checked)" style="text-decoration: none;"><bean:message key="label.search.all"/></A>
		</td>
		<td class="title">
			<html:text styleClass="search" property="orgname" styleId="orgname" size="25"/>
		</td>
	</tr>
	<TR>
		<td class="title">&nbsp;</td>
		<td class="title" colspan="2">
			<A href="javascript:switchALL(document.all.isAll[0])" style="text-decoration: none;"><bean:message key="label.search.all"/></A>
			<july:checkbox property="isAll" insertable="true" updatable="true" onclick="switchIsAll(document.all.isAll[0].checked)"/>&nbsp;&nbsp;&nbsp;&nbsp;
			<A href="javascript:switchCheckBox(document.all.selissupplier[0])" style="text-decoration: none;"><bean:message key="label.organization.issupplier"/></A>
			<july:checkbox property="selissupplier" insertable="true" updatable="true"/>&nbsp;&nbsp;&nbsp;&nbsp;
			<A href="javascript:switchCheckBox(document.all.selisrenter[0])" style="text-decoration: none;"><bean:message key="label.organization.isrenter"/></A>
			<july:checkbox property="selisrenter" insertable="true" updatable="true"/>&nbsp;&nbsp;&nbsp;&nbsp;
			<A href="javascript:switchCheckBox(document.all.selisprovider[0])" style="text-decoration: none;"><bean:message key="label.organization.isprovider"/></A>
			<july:checkbox property="selisprovider" insertable="true" updatable="true"/>&nbsp;&nbsp;&nbsp;&nbsp;
			<A href="javascript:switchCheckBox(document.all.isChannalRenter[0])" style="text-decoration: none;">Аренд. канал</A>
			<july:checkbox property="isChannalRenter" insertable="true" updatable="true"/>
		</td>
	</tr>
	</table>
</TD>
</TR>
<SCRIPT language="javascript">
	switchNameSearch(document.all.isorgname[0].checked);
	switchInnSearch(document.all.isinn[0].checked);
	switchIsAll(document.all.isAll[0].checked)
</SCRIPT>
	<july:separator colspan="<%= gColSpan %>"/>
	<tr class="title">
		<td colspan="<%= gColSpan %>">
			<TABLE class="buttons">
				<TR class="title">
					<TD class="buttons">
<%--					
						<july:addbutton page="/EditOrganizationM.do?action=Add"/>
--%>						
						<july:canedit>
						<A href='OrganizationDialog.do?action=Add' onclick='window.open(this.href, "OrganizationDialog", "top=50, left=250, width=750, height=650, scrollbars=yes, resizable=yes").focus(); return false;'>
							<IMG SRC="/images/plus.gif" BORDER='0' ALT='Добавить запись'>
						</A>						
						</july:canedit>
						<july:backbutton/>
					</TD>
					<td align="right">отобрано записей:<%= request.getAttribute("numberOfLines") %></td>
					<TD class="navigator">
						<july:navigator/>
					</TD>
				</TR>
			</TABLE>
		</TD>
	</tr>
	<july:separator colspan="<%= gColSpan %>"/><!-- Table header -->
	<tr class="title">
		<TD class="title">&nbsp;</TD>
		<td class="title" nowrap>
			<A title="Сортровать по полю 'инн'" href="javascript:SortBy('inn')"><bean:message key="label.organization.inn"/></A>
			<%=isUp(sortBy, "inn")%>
		</td>
		<td class="title" nowrap>
			<A title="Сортровать по полю 'Полное имя'" href="javascript:SortBy('name')"><bean:message key="label.name"/></A>
			<%=isUp(sortBy, "name")%>
		</td>
		<td class="title" nowrap>
			<A title="Сортровать по полю 'Телефон'" href="javascript:SortBy('phone')"><bean:message key="label.organization.phone"/></A>
			<%=isUp(sortBy, "phone")%>
		</td>
<%--
		<july:headercolumn key="label.organization.inn" colType="string"/>
		<july:headercolumn key="label.name" colType="string"/>
		<july:headercolumn key="label.organization.phone" colType="string"/>
--%>
		<%--TD class="title">&nbsp;</TD--%>
		<TD class="title">&nbsp;</TD>
		<TD class="title">&nbsp;</TD>
		<TD class="title">&nbsp;</TD>
		<TD class="title">&nbsp;</TD>
	</tr>
	<july:separator colspan="<%= gColSpan %>"/><!-- Table body -->
	<logic:iterate id="org" name="browseList">
	<logic:present name="org">
    <tr class="normal"  id='<bean:write name="org" property="organization" filter="true"/>' onMouseOver="className='select'" onMouseOut="onMouseOutRow(this.id);"   onclick='onClickRow(this.id);' style="font-size:8pt;">
		<td class="text">
<%--			<july:editbutton page="/EditOrganizationM.do" action="Edit" paramId="organization" paramName="org" paramProperty="organization" paramScope="page"/>  --%>
			<july:canedit>
			<A href='OrganizationDialog.do?action=Edit&organization=<bean:write name="org" property="organization" filter="true"/>' onclick='window.open(this.href, "OrganizationDialog", "top=50, left=250, width=750, height=650, scrollbars=yes, resizable=yes").focus(); return false;'><IMG SRC="/images/izmena.gif" BORDER='0' ALT='Изменить запись'></A>			
			</july:canedit>
		</td>
		<td class="text">
			<bean:write name="org" property="inn" filter="true"/>
		</td>
		<td class="text">
			<bean:write name="org" property="name" filter="true"/>
		</td>
		<td class="text">
			<bean:write name="org" property="phone" filter="true"/>
		</td>
		<%--td class="text">
			<july:link page="/ShowAccountList.do" paramId="organization" paramName="org" paramProperty="organization" paramScope="page" alttext="msg.accounts">
			рас.счета</july:link>
		</td--%>
		<td class="text">
			<july:link page="/ShowOrgworkersList.do" paramId="organization" paramName="org" paramProperty="organization" paramScope="page" alttext="msg.orgworkers">
			<bean:message key="label.workers"/></july:link>
		</td>
		<td class="text">
			<july:link page="/ShowCarsList.do" paramId="organization" paramName="org" paramProperty="organization" paramScope="page" alttext="label.car.full">
				<bean:message key="label.cars"/>
			</july:link>
		</td>
		<td class="text">
			<july:link page="/ShowOrggroupList.do" paramId="organization" paramName="org" paramProperty="organization" paramScope="page" alttext="msg.orggroups">
			<bean:message key="label.orggroups"/></july:link>
		</td>
		<td class="link">
<%-- <july:delbutton page="/EditOrganizationM.do?action=Delete" paramId="organization" paramName="org" paramProperty="organization" paramScope="page"/> --%>
			<july:canedit>
			<A href='OrganizationDialog.do?action=Delete&organization=<bean:write name="org" property="organization" filter="true"/>' onclick='window.open(this.href, "OrganizationDialog", "top=50, left=250, width=750, height=650, scrollbars=yes, resizable=yes").focus(); return false;'>
                <img src="/images/del.gif" border="0" alt='<bean:message key="label.delete"/>'>
			</A>
			</july:canedit>
		</td>
	</tr>
	<july:separator colspan="<%= gColSpan %>"/></logic:present></logic:iterate>
	<tr class="title">
		<td colspan="<%= gColSpan %>">
			<TABLE class="buttons">
				<TR class="title">
					<TD class="buttons">
<%--					
						<july:addbutton page="/EditOrganizationM.do?action=Add"/>
--%>						
						<july:canedit>
						<A href='OrganizationDialog.do?action=Add' onclick='window.open(this.href, "OrganizationDialog", "top=100, left=400, width=600, height=600, scrollbars=yes, resizable=yes").focus(); return false;'>
							<IMG SRC="/images/plus.gif" BORDER='0' ALT='Добавить запись'>
						</A>						
						</july:canedit>
						<july:backbutton/>
					</TD>
					<td align="right">отобрано записей:<%= request.getAttribute("numberOfLines") %></td>
					<TD class="navigator">
						<july:navigator/>
					</TD>
				</TR>
			</TABLE>
		</TD>
	</tr>
<july:separator colspan="<%= gColSpan %>"/>
</table>

</july:browseform>

<script language="javascript">
	loadSelectedRow();
	window.location.hash=document.all.selectedID.value;
</script>