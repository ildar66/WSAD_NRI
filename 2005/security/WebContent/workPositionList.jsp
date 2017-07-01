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
	java.lang.String gColSpan = "3";
	WorkPositionListForm listForm = (WorkPositionListForm)session.getAttribute("WorkPositionListForm");
	String sortBy = listForm.getOrderBy();
%>

<july:browseform action="/ShowWorkPositionList.do" styleId="listForm">
<html:hidden property="orderBy"/>
<script language="javascript">
function toggleA(a){
	//document.all.isName[0].checked =false;
	//listForm.name.disabled = false;
	listForm.name.value=a+'*';
	listForm.submit();
}
function SortBy(field) 
{
	var e = document.all.orderBy;
	e.value = (e.value == field)?field + ' desc':field;
    document.body.style.cursor="wait";
	listForm.submit();
	return false;
}
</script>

<table class="main">
	<tr class="title">
		<td class="title" colspan="<%= gColSpan %>">
			<july:currmark><bean:message key="label.workpositions"/></july:currmark>
		</td>
	</tr>

	<july:separator colspan="<%= gColSpan %>" />
	
	<TR class="normal">
		<TD colspan="<%= gColSpan %>">
			<table class="find">
				<tr>
					<td class="title">Наименование</td>
					<td class="title"><html:text styleClass="search" property="name" size="25"/><july:searchbutton/></td>
					<td class="title" nowrap>
					<%
						String[] a = { "А", "Б", "В", "Г", "Д", "Е", "Ё", "Ж", "З", "И", "Й", "К", "Л", "М", "Н", "О", "П", "Р", "С", "Т", "У", "Ф", "Х", "Ц", "Ч", "Ш", "Щ", "Э", "Ю", "Я" };
						for (int i = 0; i < a.length; i++) {%>
							<A href="javascript:toggleA('<%= a[i]%>')"><%= a[i]%></A>
							<%if(a[i].equals("Н")){%><BR><%}%>
					<%}%>
					&nbsp;&nbsp;&nbsp;<A href="javascript:toggleA('')">Все</A>
					</td>
				</tr>
				<tr>
					<td class="title">должности:</td>
					<td class="title" colspan="2">
						<july:radio property="activestate" insertable="true" updatable="true" value="ALL"/>Все
						<july:radio property="activestate" insertable="true" updatable="true" value="Y"/>Активные
						<july:radio property="activestate" insertable="true" updatable="true" value="N"/>Не активные
					</td>
				</tr>
			</table>
		</TD>
	</TR>

	<july:separator colspan="<%= gColSpan %>" />

	<tr class="title">
		<td colspan="<%= gColSpan %>"><TABLE class="buttons">
			<TR class="title">
				<TD class="buttons"><july:addbutton page="/EditWorkPosition.do?action=Add"/><july:backbutton page="/main.do"/></TD>
				<TD align="right">отобрано записей:<%= request.getAttribute("numberOfLines") %></TD>
				<TD class="navigator"><july:navigator/></TD>
            </TR>
		</TABLE></TD>
	</tr>
      
      <july:separator colspan="<%= gColSpan %>" />
    
    <!-- Table header -->
    <tr class="title">
		<TD class="title" nowrap>
			<A title="Сортировать по полю 'workposition'" href="javascript:SortBy('workposition')">Код</A>
			<%=isUp(sortBy, "workposition")%>
		</TD>
		<TD class="title">
			<A title="Сортировать по полю 'name'" href="javascript:SortBy('name')">Наименование</A>
			<%=isUp(sortBy, "name")%>
		</TD>
        <TD class="title">&nbsp;</TD>
    </tr>

<july:separator colspan="<%= gColSpan %>" />


        <!-- Table body -->
    <logic:iterate id="wpl" name="browseList">
        <logic:present name="wpl">
            <tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
                <td class="number">
                      <bean:write name="wpl" property="workposition" filter="true"/>
                </td>
                <td class="text">
                    <july:editlink page="/EditWorkPosition.do" action="Edit" paramId="workposition" paramName="wpl" paramProperty="workposition" paramScope="page">
                    <bean:write name="wpl" property="name" filter="true"/>
                    </july:editlink>
                </td>
                <td class="link">
                    <july:delbutton page="/EditWorkPosition.do?action=Delete" paramId="workposition" paramName="wpl" paramProperty="workposition" paramScope="page"/>
                </td>
            </tr>

            <july:separator colspan="<%= gColSpan %>" />

	      </logic:present>
      </logic:iterate>

      <tr class="title">
          <td colspan="<%= gColSpan %>"><TABLE class="buttons">
            <TR class="title">
              <TD class="buttons"><july:addbutton page="/EditWorkPosition.do?action=Add"/><july:backbutton page="/main.do"/></TD>
			  <TD align="right">отобрано записей:<%= request.getAttribute("numberOfLines") %></TD>
              <TD class="navigator"><july:navigator/></TD>
            </TR>
            </TABLE></TD>
      </tr>
      
      <july:separator colspan="<%= gColSpan %>" />
      
      <tr class="title">
    	<td class="title" colspan="<%= gColSpan %>">
           <july:currmark><bean:message key="label.workpositions"/></july:currmark></td>
      </tr>
      
</table>

</july:browseform>
