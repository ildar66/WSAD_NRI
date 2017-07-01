<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "5"; %>

<july:browseform action="/ShowGrouporgList.do">

<table class="main">
<%--
<tr class="title">
	<td class="title" colspan="<%= gColSpan %>">
       <html:link page="/ShowGroupList.do" styleClass="navigator"><bean:message key="label.groups"/></html:link>
       <july:sepmark/> 
	   <html:link page="/ShowGrouppingList.do" styleClass="navigator"><bean:message key="label.groupping"/></html:link>
       <july:sepmark/> 
       <july:currmark><bean:message key="label.grouporg"/></july:currmark></td>
</tr>
--%>
<july:separator colspan="<%= gColSpan %>" />

<TR class="normal">
 <TD colspan="<%= gColSpan %>">
 
    <table class="find">
    <TR>
       <td class="title"><bean:message key="label.group"/>:</td>
       <td class="title"><bean:write name="GrouporgListForm" property="searchgroupname" /></td>
     </tr>
    <TR>
       <td class="title"><bean:message key="label.groupping"/>:</td>
       <td class="title"><bean:write name="GrouporgListForm" property="searchgrouppingname" /></td>
     </tr>
    </table>
    
  </TD>
</TR>

<july:separator colspan="<%= gColSpan %>" />

      <tr class="title">
          <td colspan="<%= gColSpan %>"><TABLE class="buttons">
            <TR class="title">
              <TD class="buttons"><july:includebutton page="/ShowOrganizationMultiList.do"/><july:backbutton/></TD>
              <TD class="navigator"><july:navigator/></TD>
            </TR>
            </TABLE></TD>
      </tr>
      
      <july:separator colspan="<%= gColSpan %>" />
  
    <!-- Table header -->
    <tr class="title">
        <july:headercolumn key="label.code" colType="number"/>
        <july:headercolumn key="label.organization.inn" colType="string"/>
        <july:headercolumn key="label.name" colType="string"/>
        <july:headercolumn key="label.organization.phone" colType="string"/>
        <TD class="title">&nbsp;</TD>
    </tr>

	<july:separator colspan="<%= gColSpan %>" />

    <!-- Table body -->
    <logic:iterate id="org" name="browseList">
        <logic:present name="org">
            <tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
                <td class="number">
                    <bean:write name="org" property="organization" filter="true"/>
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
                <td class="link"><july:excludebutton page="/ProcessGrouporg.do?action=Delete" paramId="org" paramName="org" paramProperty="organization" paramScope="page"/></td>
            </tr>
 
            <july:separator colspan="<%= gColSpan %>" />

	      </logic:present>
      </logic:iterate>

      <tr class="title">
          <td colspan="<%= gColSpan %>"><TABLE class="buttons">
            <TR class="title">
              <TD class="buttons"><july:includebutton page="/ShowOrganizationMultiList.do"/><july:backbutton/></TD>
              <TD class="navigator"><july:navigator/></TD>
            </TR>
            </TABLE></TD>
      </tr>
      
      <july:separator colspan="<%= gColSpan %>" />
<%--      
      <tr class="title">
    	<td class="title" colspan="<%= gColSpan %>">
           <html:link page="/ShowGroupList.do" styleClass="navigator"><bean:message key="label.groups"/></html:link>
           <july:sepmark/> 
    	   <html:link page="/ShowGrouppingList.do" styleClass="navigator"><bean:message key="label.groupping"/></html:link>
           <july:sepmark/> 
           <july:currmark><bean:message key="label.grouporg"/></july:currmark></td>
      </tr>
--%>      
</table>

</july:browseform>
