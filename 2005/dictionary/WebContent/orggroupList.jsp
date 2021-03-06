<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "4"; %>

<july:browseform action="/ShowOrggroupList.do">

<table class="main">
<%--
<tr class="title">
	<td class="title" colspan="<%= gColSpan %>">
       <html:link page="/ShowOrganizationListM.do" styleClass="navigator"><bean:message key="label.organizations"/></html:link> 
       <july:sepmark/> 
       <july:currmark><bean:message key="label.orggroup"/></july:currmark>
	</td>
</tr>
--%>
<july:separator colspan="<%= gColSpan %>" />

<TR class="normal">
 <TD colspan="<%= gColSpan %>">
 
    <table class="find">
    <TR>
       <td class="text"><bean:message key="label.orggroup.organization"/>:</td>
       <td class="text"><bean:write name="OrggroupListForm" property="organizationname" /></td>
     </tr>        
     </table>
    
  </TD>
</TR>


<july:separator colspan="<%= gColSpan %>" />

        <tr class="title">
          <td colspan="<%= gColSpan %>"><TABLE class="buttons">
            <TR class="title">
              <TD class="buttons"><july:addbutton page="/EditOrggroup.do?action=Add"/><july:backbutton/></TD>
              <TD class="navigator"><july:navigator/></TD>
            </TR>
            </TABLE></TD>
        </tr>
        
      <july:separator colspan="<%= gColSpan %>" />

        <!-- Table header -->
        <tr class="title">
            <TD class="title" width="1%">&nbsp;</TD>
            <july:headercolumn key="label.orggroup.group" colType="string"/>
            <july:headercolumn key="label.orggroup.groupping" colType="string"/>
            <TD class="title" width="1%">&nbsp;</TD>
        </tr>


<july:separator colspan="<%= gColSpan %>" />

    
        <!-- Table body -->
        <logic:iterate id="rstl" name="browseList">
	      <logic:present name="rstl">
            <tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
		<td class="link">
                    <july:editbutton page="/EditOrggroup.do" action="Edit" paramId="searchgroup" paramName="rstl" paramProperty="group.searchgroup" paramScope="page"/>
		</td>
                <td class="text">
                    <bean:write name="rstl" property="group.name" filter="true"/>
                </td>
                <td class="text">
                    <bean:write name="rstl" property="groupping.name" filter="true"/>
                </td>
                <td class="link"><july:delbutton page="/EditOrggroup.do?action=Delete" paramId="searchgroup" paramName="rstl" paramProperty="group.searchgroup" paramScope="page"/></td>
            </tr>

            <july:separator colspan="<%= gColSpan %>" />

	      </logic:present>
        </logic:iterate>

        <tr class="title">
          <td colspan="<%= gColSpan %>"><TABLE class="buttons">
            <TR class="title">
              <TD class="buttons"><july:addbutton page="/EditOrggroup.do?action=Add"/><july:backbutton/></TD>
              <TD class="navigator"><july:navigator/></TD>
            </TR>
            </TABLE></TD>
        </tr>
        
      <july:separator colspan="<%= gColSpan %>" />
<%--      
      <tr class="title">
    	<td class="title" colspan="<%= gColSpan %>">
           <html:link page="/ShowOrganizationListM.do" styleClass="navigator"><bean:message key="label.organizations"/></html:link> 
           <july:sepmark/> 
           <july:currmark><bean:message key="label.orggroup"/></july:currmark></td>
      </tr>
--%>        
    </table>

</july:browseform>
