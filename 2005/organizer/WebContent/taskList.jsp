<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.organizer.*,com.hps.july.organizer.valueobject.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%--
<% java.lang.String gColSpan = "1"; %>

<july:browseform action="/ShowTaskList.do">

<table class="main">
<tr class="title">
	<td class="title" colspan="<%= gColSpan %>">
       <july:currmark><bean:message key="label.tasks"/></july:currmark></td>
</tr>

<july:separator colspan="<%= gColSpan %>" />

<TR class="normal">
 <TD colspan="<%= gColSpan %>">
 
    <table class="find">
    <TR>
       <td class="title">&nbsp;</td>
       <td class="title">&nbsp;</td>
     </tr>        
     </table>
    
  </TD>
</TR>


<july:separator colspan="<%= gColSpan %>" />


        <!-- Table header -->
        <tr class="title">
            <july:headercolumn key="label.tasks" colType="string"/>
        </tr>


<july:separator colspan="<%= gColSpan %>" />


        <!-- Table body -->
	 <logic:present name="tasksList">
        <logic:iterate id="task" name="tasksList" type="com.hps.july.organizer.valueobject.OperatorTask">
	      <logic:present name="task">
            <tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
                <td class="link">
					<% if ( (task.getTaskCode() == 11) ||
                  (task.getTaskCode() == 12)
          ) { %>
						<A HREF='<%= task.getContext() +"?id=" + request.getRemoteUser() %>'>
						  <bean:write name="task" property="taskName" filter="true"/>
						</A>
					<% } else if (task.getTaskCode() == 14) {
                String tcUrl = "newBigWin('" + task.getContext() +"?id=" + request.getRemoteUser() + "', 'trailcom'); return false;";
          %>
						<A onclick="<%= tcUrl %>"
               HREF='<%= task.getContext() +"?id=" + request.getRemoteUser() %>'>
						  <bean:write name="task" property="taskName" filter="true"/>
						</A>
					<% } else if(task.getTaskCode() == 15){ %>
						<A HREF="<%= task.getContext() +"/" %>ShowBaseStationGSM.do?navclear=1&rootapp=10&rootstate=13">
						  <bean:write name="task" property="taskName" filter="true"/>
						</A>
					<% } else { %>
						<A HREF="<%= task.getContext() +"/" %>main.do?navclear=1&rootapp=0&rootstate=0">
						  <bean:write name="task" property="taskName" filter="true"/>
						</A>
					<% } %>
                </td>
            </tr>

            <july:separator colspan="<%= gColSpan %>" />

	      </logic:present>
        </logic:iterate>
     </logic:present>
	 <logic:notPresent name="tasksList">
            <tr class="normal">
                <td class="link">
                    <bean:message key="error.notasks"/>
                </td>
            </tr>
            <july:separator colspan="<%= gColSpan %>" />
     </logic:notPresent>

        <tr class="title">
            <td colspan="<%= gColSpan %>" align="left">&nbsp;</td>
        </tr>
    </table>

</july:browseform>
--%>

<table class="main" height="100%">
  	<tr class="normal">
		<td align="center"><img src="/images/main3.gif" border="0" alt=""></td>
  	</tr>
</table>