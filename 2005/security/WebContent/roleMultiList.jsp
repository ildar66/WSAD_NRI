<%@ page language = "java" %>
<%@ page import="org.apache.struts.util.*" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "3"; %>

<july:browseform action="/ShowRoleMultiList.do" styleId="RoleForm">

<table class="main">
<tr class="title">
	<td class="title" colspan="<%= gColSpan %>">
       <html:link page="/ShowPeopleList.do" styleClass="navigator"><bean:message key="label.people"/></html:link> 
       <july:sepmark/>
       <html:link page="/ShowOperatorList.do" styleClass="navigator"><bean:message key="label.operators"/></html:link> 
       <july:sepmark/>
       <html:link page="/ShowOperator2roleList.do" styleClass="navigator"><bean:message key="label.operator2roles"/></html:link>
       <july:sepmark/> 
       <july:currmark><bean:message key="label.addrolemulti"/></july:currmark></td>
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

<july:separator colspan="<%= gColSpan %>" />

      <tr class="title">
          <td colspan="<%= gColSpan %>"><TABLE class="buttons">
            <TR class="title">
              <TD class="buttons"><july:savebutton/><july:backbutton page="/ShowOperator2roleList.do"/></TD>
<%--              <TD class="navigator"><july:navigator/></TD> --%>
            </TR>
            </TABLE></TD>
      </tr>
      
      <july:separator colspan="<%= gColSpan %>" />
  
    <!-- Table header -->
    <tr class="title">
            <july:headercolumn key="label.code" colType="number"/>
            <july:headercolumn key="label.name" colType="string"/>
            <TD class="title">&nbsp;</TD>
    </tr>

<july:separator colspan="<%= gColSpan %>" />


        <!-- Table body -->
    <logic:iterate id="role" name="browseList">
        <logic:present name="role">
            <tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
                <td class="text">
                    <bean:write name="role" property="role" filter="true"/>
                </td>
                <td class="text">
                    <bean:write name="role" property="rolename" filter="true"/>
                </td>
                <% java.lang.String s = (java.lang.String)(RequestUtils.lookup(pageContext, "role", "role", null).toString()); %>
                <td class="link"><july:checkbox property="selectedRole" value="<%= s %>" insertable="true" updatable="true"/></td>
            </tr>

            <july:separator colspan="<%= gColSpan %>" />

	      </logic:present>
      </logic:iterate>
      
      <INPUT TYPE="HIDDEN" NAME="selectedRole" VALUE="0">

      <tr class="title">
          <td colspan="<%= gColSpan %>"><TABLE class="buttons">
            <TR class="title">
              <TD class="buttons"><july:savebutton/><july:backbutton page="/ShowOperator2roleList.do"/></TD>
<%--              <TD class="navigator"><july:navigator/></TD> --%>
            </TR>
            </TABLE></TD>
      </tr>
      
      <july:separator colspan="<%= gColSpan %>" />
      
      <tr class="title">
    	<td class="title" colspan="<%= gColSpan %>">
		   <html:link page="/ShowPeopleList.do" styleClass="navigator"><bean:message key="label.people"/></html:link> 
		   <july:sepmark/>
		   <html:link page="/ShowOperatorList.do" styleClass="navigator"><bean:message key="label.operators"/></html:link> 
		   <july:sepmark/>
		   <html:link page="/ShowOperator2roleList.do" styleClass="navigator"><bean:message key="label.operator2roles"/></html:link>
		   <july:sepmark/> 
		   <july:currmark><bean:message key="label.addrolemulti"/></july:currmark></td>
      </tr>
      
</table>

</july:browseform>
