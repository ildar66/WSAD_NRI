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
	java.lang.String gColSpan = "7";
	Operator2roleListForm listForm = (Operator2roleListForm)session.getAttribute("Operator2roleListForm");
	String sortBy = listForm.getOrderBy();
	//paging:
	java.util.List posList = listForm.getListAnoveRoleForOperator();
	int posListSize = posList.size();//кол-во позиций.
	int pageSize = (posListSize > 300)? 20 : 10 ;//кол-во позиций на странице.
	int pages = (posListSize%pageSize == 0) ? (posListSize/pageSize) : (posListSize/pageSize + 1);//кол-во страниц.	
%>

<july:browseform action="/ShowOperator2roleList.do" styleId="listForm">
<html:hidden property="operator"/>
<html:hidden property="orderBy"/>
<html:hidden property="selectedID" value="0"/>

<style>
TR.include {
	background-color:#A5F3C6;
}
TR.exclude {
	background-color:#F0F0F0;
}
TR.selectedrow {
	background-color:#FFF0D0;
} 
</style>

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
	//считываем selectedID:
	var startLoc = cookies.indexOf(listForm.name+"=");
	if(startLoc == -1)
	   return;
	var sepLoc = cookies.indexOf("=", startLoc);
	var endLoc = cookies.indexOf(";", startLoc);
	if(endLoc == -1) {
		endLoc = cookies.length;
    }
    document.all.selectedID.value = cookies.substring(sepLoc+1, endLoc);
	//подчеркиваем строку в таблице:
	if( document.all.tableID.rows(document.all.selectedID.value) != null ) {
 		document.all.tableID.rows(document.all.selectedID.value,0).className="selected";
	}
}
//отображение страницы позиций:
function showPage(page) {
	var posListSize = <%= posListSize%>;
	var pageSize = <%= pageSize%>;
	var end = tableID.rows.length - 3;
	var start = end - posListSize;
	for(var i = start; i < end; i++){
		if(i >= start + (page-1)*pageSize && i < start + page*pageSize){
			tableID.rows[i].style.setAttribute("display", "block");			 
	 	}else{
			tableID.rows[i].style.setAttribute("display", "none");
		}
	}
	listForm.pageNumber.value = page;
}
//отображение всех страниц позиций:
function showAllPage() {
	var posListSize = <%= posListSize%>;
	var end = tableID.rows.length - 3;
	var start = end - posListSize;
	for(var i = start; i < end; i++){
		tableID.rows[i].style.setAttribute("display", "block");			 
	}
	listForm.pageNumber.value = "все";
}
</script>

<table class="main" style="font-size: 9pt" id="tableID">
<tr class="title">
	<td class="title" colspan="<%= gColSpan %>">
       <html:link page="/ShowPeopleList.do" styleClass="navigator"><bean:message key="label.people"/></html:link> 
       <july:sepmark/>
       <html:link page="/ShowOperatorList.do" styleClass="navigator"><bean:message key="label.operators"/></html:link> 
       <july:sepmark/>
       <july:currmark><bean:message key="label.operator2roles"/></july:currmark></td>
</tr>

<july:separator colspan="<%= gColSpan %>" />

<TR class="normal">
 <TD colspan="<%= gColSpan %>">
 
    <table class="find">
    <TR>
       <td class="title"><bean:message key="label.people.fullname"/></td>
       <td class="title"><bean:write name="operator" property="man.fullName" /></td>
     </tr>        
    <tr>
        <td class="title"><bean:message key="label.operator.loginid"/></td>
        <td class="title"><bean:write name="operator" property="login" /></td>
    </tr>
     </table>
    
  </TD>
</TR>


<!--Region and SuperRegion begin -->
    <%--tr class="title">
    	<td class="title" colspan="<%= gColSpan %>">
           <html:link page="/ShowSuperRegionAccessList.do" styleClass="navigator" paramId="operator" paramName="operator" paramProperty="operator" paramScope="session"><bean:message key="label.superregion"/></html:link> 
           <html:link page="/ShowRegionAccessList.do" styleClass="navigator" paramId="operator" paramName="operator" paramProperty="operator" paramScope="session"><bean:message key="label.region"/></html:link>
       </td>
    </tr--%>
<!--Region and SuperRegion end-->

<july:separator colspan="<%= gColSpan %>" />

        <!-- Table header -->
        <tr class="title">
			<TD><july:backbutton page="/ShowOperatorList.do"/></TD>
			<%--TD><A href='Operator2roleDialog.do?action=Add' onclick='return openDialog(this.href, "Operator2roleDialog", "top=100, left=350, width=500, height=310, scrollbars=yes, resizable=yes");'><IMG SRC="/images/plus.gif" BORDER='0' ALT='Добавить роль'></A></TD--%>
			<TH colspan="<%= gColSpan %>">Текущие роли:</TH>
		</tr>
<july:separator colspan="<%= gColSpan %>" />
        <tr class="include">
        	<TD class="title" nowrap></TD>
			<TD class="title" align="center" nowrap="nowrap">
				<A title="Сортировать по полю '№'" href="javascript:SortBy('sortOrder')">№</A>
				<%=isUp(sortBy, "sortOrder")%>
			</TD>        
			<TD class="title" align="center">
				<A title="Сортировать по полю 'Код'" href="javascript:SortBy('role')">Код</A>
				<%=isUp(sortBy, "role")%>
			</TD>
			<TD class="title" align="center">
				<A title="Сортировать по полю 'Роль'" href="javascript:SortBy(' rolename')">Роль</A>
				<%=isUp(sortBy, " rolename")%>
			</TD>
			<TD class="title" align="center" nowrap="nowrap">
				<A title="Сортировать по полю 'Модуль'" href="javascript:SortBy('taskComment')">Модуль</A>
				<%=isUp(sortBy, "taskComment")%>
			</TD>
			<TD class="title" title="Описание роли" align="center"><B>!</B></TD>			
            <TD class="title" title="Роли для включения">&nbsp;</TD>
        </tr>

<july:separator colspan="<%= gColSpan %>" />

        
        <!-- Table body -->
        <logic:iterate id="orlist" name="browseList">
            <logic:present name="orlist">
            <tr id='<bean:write name="orlist" property="role" filter="true"/>' class="normal" onMouseOver="className='select';" onMouseOut="onMouseOutRow(this.id);" onclick="onClickRow(this.id);">
				<td class="link" style="background-color:#A5F3C6">
					<A href='Operator2roleDialog.do?action=Edit&role=<bean:write name="orlist" property="role" filter="true"/>' onclick='return openDialog(this.href, "Operator2roleDialog", "top=100, left=350, width=500, height=310, scrollbars=yes, resizable=yes");'><IMG SRC="/images/izmena.gif" BORDER='0' ALT='Изменить запись'></A>
				</td>            
                <td class="text">
                	<bean:write name="orlist" property="sortOrder" filter="true"/>
                </td>            
                <td class="number">
                	<B><bean:write name="orlist" property="role" filter="true"/></B>
                </td>
                <td class="text">
                	<bean:write name="orlist" property="rolename" filter="true"/>
                </td>
                <td class="text">
                	<bean:write name="orlist" property="taskComment" filter="true"/>
                </td>
                <td class="text">
                  	<IMG SRC="/images/doc.gif" BORDER='0' ALT='Описание' title="<bean:write name="orlist" property="comment" filter="true"/>">                
                </td>
                <td class="link" style="background-color:#A5F3C6">
                    <july:excludebutton page="/ProcessOperator2role.do?action=Delete" paramId="roles_role" paramName="orlist" paramProperty="role" paramScope="page"/>
                </td>
            </tr>

            <%--july:separator colspan="<%= gColSpan %>" /--%>

	        </logic:present>
        </logic:iterate>

        <!-- Table "listAnoveRoleForOperator" header -->
        <tr class="title">
			<TD><july:backbutton page="/ShowOperatorList.do"/></TD>
			<TH colspan="<%= gColSpan %>">
				Роли для включения:
				Всего: <%= posListSize%>.&nbsp;&nbsp; 
				<%if(posListSize > 0){%>
					Страница: <INPUT TYPE="TEXT" NAME="pageNumber" VALUE="" READONLY="readonly" class="editdisabled" style="width: 19pt; font-size: 8pt;">
					<% for(int i = 1; i <= pages; i++){ %>
						<A name="pagePos_<%=i%>" class="button" onmouseover="showPage(<%=i%>);" style="vertical-align: bottom;"><%=i%></A>
					<% } %>
					<A name="pagePos_ALL" class="button" onmouseover="showAllPage();" style="vertical-align: bottom;">все</A>
				<% } %>				
			</TH>
		</tr>
<july:separator colspan="<%= gColSpan %>" />
        <tr class="exclude">
        	<TD class="title" nowrap></TD>
			<TD class="title" align="center">
				<A title="Сортировать по полю '№'" href="javascript:SortBy('sortOrder')">№</A>
				<%=isUp(sortBy, "sortOrder")%>
			</TD>        
			<TD class="title" align="center">
				<A title="Сортировать по полю 'Код'" href="javascript:SortBy('role')">Код</A>
				<%=isUp(sortBy, "role")%>
			</TD>
			<TD class="title" align="center">
				<A title="Сортировать по полю 'Роль'" href="javascript:SortBy(' rolename')">Роль</A>
				<%=isUp(sortBy, " rolename")%>
			</TD>
			<TD class="title" align="center">
				<A title="Сортировать по полю 'Модуль'" href="javascript:SortBy('taskComment')">Модуль</A>
				<%=isUp(sortBy, "taskComment")%>
			</TD>
			<TD class="title" title="Описание роли" align="center"><B>!</B></TD>			
            <TD class="title" title="Роли для включения">&nbsp;</TD>
        </tr>

<july:separator colspan="<%= gColSpan %>" />

         
        <!-- Table "listAnoveRoleForOperator"  body -->
        <logic:iterate id="item" name="Operator2roleListForm" property="listAnoveRoleForOperator">
            <logic:present name="item">
            <tr id='<bean:write name="item" property="role" filter="true"/>' class="normal" onMouseOver="className='select';" onMouseOut="onMouseOutRow(this.id);" onclick="onClickRow(this.id);">
				<td class="link" style="background-color:#F0F0F0">
					<A href='Operator2roleDialog.do?action=Edit&role=<bean:write name="item" property="role" filter="true"/>' onclick='return openDialog(this.href, "Operator2roleDialog", "top=100, left=350, width=500, height=310, scrollbars=yes, resizable=yes");'><IMG SRC="/images/izmena.gif" BORDER='0' ALT='Изменить запись'></A>
				</td>            
                <td class="text">
                	<bean:write name="item" property="sortOrder" filter="true"/>
                </td>            
                <td class="number">
                	<bean:write name="item" property="role" filter="true"/>
                </td>
                <td class="text">
                	<bean:write name="item" property="rolename" filter="true"/>
                </td>
                <td class="text">
                	<bean:write name="item" property="taskComment" filter="true"/>
                </td>
                <td class="text">
                  	<IMG SRC="/images/doc.gif" BORDER='0' ALT='Описание' title="<bean:write name="item" property="comment" filter="true"/>">                
                </td>
                <td class="link" style="background-color:#F0F0F0">
                	<july:includebutton page="/ProcessOperator2role.do?action=Add" paramId="roles_role" paramName="item" paramProperty="role" paramScope="page"/>
                </td>
            </tr>

            <%--july:separator colspan="<%= gColSpan %>" /--%>

	        </logic:present>
        </logic:iterate>

        <tr class="title">
          <td colspan="<%= gColSpan %>"><TABLE class="buttons">
            <TR class="title">
              <TD class="buttons">
<%--                <july:includebutton page="/ShowRoleMultiList.do?action=Add"/>			--%>
                <july:backbutton page="/ShowOperatorList.do"/></TD>
              <TD class="navigator"><%--july:navigator/--%></TD>
            </TR>
            </TABLE></TD>
        </tr>

 
<!--Region and SuperRegion begin -->
    <%--tr class="title">
    	<td class="title" colspan="<%= gColSpan %>">
           <html:link page="/ShowSuperRegionAccessList.do" styleClass="navigator" paramId="operator" paramName="operator" paramProperty="operator" paramScope="session"><bean:message key="label.superregion"/></html:link> 
           <html:link page="/ShowRegionAccessList.do" styleClass="navigator" paramId="operator" paramName="operator" paramProperty="operator" paramScope="session"><bean:message key="label.region"/></html:link>
       </td>
    </tr--%>
<!--Region and SuperRegion end-->
        
      <july:separator colspan="<%= gColSpan %>" />
      
      <tr class="title">
    	<td class="title" colspan="<%= gColSpan %>">
           <html:link page="/ShowPeopleList.do" styleClass="navigator"><bean:message key="label.people"/></html:link> 
           <july:sepmark/>
           <html:link page="/ShowOperatorList.do" styleClass="navigator"><bean:message key="label.operators"/></html:link> 
           <july:sepmark/>
           <july:currmark><bean:message key="label.operator2roles"/></july:currmark></td>
      </tr>
        
    </table>

</july:browseform>
<script language="javascript">
	//switchFilter();
	loadSelectedRow();
	window.location.hash=document.all.selectedID.value;
</script>