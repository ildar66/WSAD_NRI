<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "6"; %>

<%
	boolean canEdit = request.isUserInRole("administrator");
%>

<july:browseform action="/ShowCompanyList.do">

<table class="main">
<tr class="title">
	<td class="title" colspan="<%= gColSpan %>">
       <july:currmark><bean:message key="label.companies"/></july:currmark></td>
</tr>

<TR class="normal">
 <TD colspan="<%= gColSpan %>">
 
    <table class="find">
     <TR>
       <td class="title">&nbsp;</td>
       <td class="title">&nbsp;</td>
     </TR>        
     </table>
    
  </TD>
</TR>

<july:separator colspan="<%= gColSpan %>" />

        <tr class="title">
          <td colspan="<%= gColSpan %>"><TABLE class="buttons">
            <TR class="title">
              <TD class="buttons"><% if(canEdit) { %><july:addbutton page="/EditCompany.do?action=Add"/><% } %><july:backbutton page="/main.do"/></TD>
              <TD class="navigator"><july:navigator/></TD>
            </TR>
            </TABLE></TD>
        </tr>
        
      <july:separator colspan="<%= gColSpan %>" />

        <!-- Table header -->
        <tr class="title">
            <july:headercolumn key="label.code" colType="number"/>
            <july:sortcolumn ascFinder="findOrderByNameAsc" 
                             descFinder="findOrderByNameDesc" 
                             key="label.name" colType="string"/>
            <july:headercolumn key="label.directions" colType="link"/>
            <july:headercolumn key="label.workers" colType="link"/>
<% if(canEdit) { %>
            <TD class="title">&nbsp;</TD>
<% } %>
        </tr>


<july:separator colspan="<%= gColSpan %>" />

    
        <!-- Table body -->
        <logic:iterate id="cl" name="browseList">
	      <logic:present name="cl">
            <tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
                <td class="number">
                      <bean:write name="cl" property="company" filter="true"/>
                </td>
                <td class="text">
                    <july:editlink page="/EditCompany.do" action='<%=(canEdit?"Edit":"View")%>' paramId="company" paramName="cl" paramProperty="company" paramScope="page">
             		<bean:write name="cl" property="name" filter="true"/>
                    </july:editlink>
                </td>
                <td class="link">
                    <july:link page="/ShowDirectionList.do" paramId="company" paramName="cl" paramProperty="company" paramScope="page" alttext="msg.directions">
                        <bean:message key="label.directions"/>
                    </july:link>
                </td>
                <td class="link">
                    <july:link page="/ShowWorkerListC.do" paramId="company" paramName="cl" paramProperty="company" paramScope="page" alttext="msg.workersc">
                        <bean:message key="label.workers"/>
                    </july:link>
                </td>
<% if(canEdit) { %>
                <td class="link">
                   <july:delbutton page="/EditCompany.do?action=Delete" paramId="company" paramName="cl" paramProperty="company" paramScope="page"/>
                </td>
<% } %>
            </tr>

            <july:separator colspan="<%= gColSpan %>" />

	      </logic:present>
        </logic:iterate>

        <tr class="title">
          <td colspan="<%= gColSpan %>"><TABLE class="buttons">
            <TR class="title">
		<TD class="buttons"><% if(canEdit) { %><july:addbutton page="/EditCompany.do?action=Add"/><% } %><july:backbutton page="/main.do"/></TD>
              <TD class="navigator"><july:navigator/></TD>
            </TR>
            </TABLE></TD>
        </tr>
        
      <july:separator colspan="<%= gColSpan %>" />
      
    <tr class="title">
    	<td class="title" colspan="<%= gColSpan %>">
           <july:currmark><bean:message key="label.companies"/></july:currmark></td>
    </tr>
        
    </table>

</july:browseform>
