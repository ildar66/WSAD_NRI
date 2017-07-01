<%@ page language = "java"%>
<%@ page import="com.hps.july.cdbc.lib.*" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<% java.lang.String gColSpan = "4"; %>
<july:browseform action="/ShowMSUsersList.do">
<july:selectableTable styleClass="main"  modelName="list" selectable="1" selectedClass="selected" paramName="selID" >
	<tr class="title">
		<td class="title" colspan="<%= gColSpan %>"><july:currmark><bean:message key="label.menu.microstrategy.user"/></july:currmark></td>
	</tr>
	<july:separator colspan="<%= gColSpan %>" />
	<TR class="normal">
		<TD colspan="<%= gColSpan %>">
			<table class="find">
				<tr>
					<td class="title">Логин</td>
					<td class="title"><html:text styleClass="search" property="name" size="25"/><july:searchbutton/></td>
				</tr>
			</table>
		</TD>
	</TR>
	<july:separator colspan="<%= gColSpan %>"/>
      <tr class="title">
          <td colspan="<%= gColSpan %>"><TABLE class="buttons">
            <TR class="title">
              <TD class="buttons"><july:addbutton page="/EditMSUsers.do?action=Add" modelName="list" selectable="1"/><july:backbutton page="/main.do"/></TD>
            </TR>
            </TABLE></TD>
      </tr>
      
      <july:separator colspan="<%= gColSpan %>" />
  
    <!-- Table header -->
    <tr class="title">
        <td class="title" align="center" valign="middle" style="width:10%"><img src="/images/empty.gif" width="1" height="1"/></td>
        <td class="title" align="center" valign="middle" style="width:80%">Логин пользователя Microstrategy</td>
        <td class="title" align="center" valign="middle" style="width:10%"><img src="/images/empty.gif" width="1" height="1"/></td>
    </tr>

<july:separator colspan="<%= gColSpan %>" />
        <!-- Table body -->
    <logic:iterate id="msu" name="browseList" type="CDBCRowObject" >
        <logic:present name="msu">
            <%
                String id = msu.getColumn("msucode").asString();
                String paramVal = "msucode=" + id;
            %>
            <july:selectableTR styleId="<%=id%>" paramName="selID" selectable="true" styleClass="normal"  onmouseover="className='select'" onmouseout="className='normal'">
                 <td class="text" style="width:10%;text-align:center;vertical-align:middle">
                   <% String editPage = "/EditMSUsers.do?" + paramVal; %>
                   <july:anchor />
                   <july:editbutton page="<%= editPage %>" action="Edit" modelName="list" selectable="1"/>
                </td>
                <td class="text" style="width:80%;text-align:left;vertical-align:middle">
                    <july:stringwrite name="msu" property="msuser" />
                </td>
                <td class="link" style="width:10%;text-align:center;vertical-align:middle">
                    <% String delPage = "/EditMSUsers.do?action=Delete&" + paramVal; %>
                    <july:delbutton page="<%= delPage %>" modelName="list" selectable="1"/>
                </td>
            </july:selectableTR>
            <july:separator colspan="<%= gColSpan %>" />
        </logic:present>
    </logic:iterate>

      <tr class="title">
          <td colspan="<%= gColSpan %>"><TABLE class="buttons">
            <TR class="title">
              <TD class="buttons"><july:addbutton page="/EditMSUsers.do?action=Add" modelName="list" selectable="1"/><july:backbutton page="/main.do"/></TD>
            </TR>
            </TABLE></TD>
      </tr>
      
      <july:separator colspan="<%= gColSpan %>" />
      
      <tr class="title">
    	<td class="title" colspan="<%= gColSpan %>">
           <july:currmark><bean:message key="label.menu.microstrategy.user"/></july:currmark></td>
      </tr>
</july:selectableTable>
</july:browseform>
