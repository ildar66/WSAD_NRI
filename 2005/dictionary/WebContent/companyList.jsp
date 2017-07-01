<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "3"; %>

<july:browseform action="/ShowCompanyList.do">

<table class="main">
<%--
<tr class="title">
	<td class="title" colspan="<%= gColSpan %>">
       <july:currmark><bean:message key="label.companies"/></july:currmark></td>
</tr>
--%>
<july:separator colspan="<%= gColSpan %>" />

<TR class="normal">
 <TD colspan="<%= gColSpan %>">
 
    <table class="find">
    <TR>
       <td class="title">&nbsp;</td>
       <td class="title"></td>
     </tr>        
     </table>
    
  </TD>
</TR>


<july:separator colspan="<%= gColSpan %>" />

        <tr class="title">
            <td colspan="<%= gColSpan %>" align="left">&nbsp;</td>
        </tr>
        
      <july:separator colspan="<%= gColSpan %>" />

        <!-- Table header -->
        <tr class="title">
            <july:headercolumn key="label.code" colType="number"/>
            <july:sortcolumn ascFinder="findOrderByNameAsc" 
                             descFinder="findOrderByNameDesc" 
                             key="label.name" colType="string"/>
            <july:headercolumn key="label.organizations" colType="link"/>
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
                    <bean:write name="cl" property="name" filter="true"/>
                </td>
                <td class="link">
                    <html:link page="/ShowOrganizationListC.do" paramId="company" paramName="cl" paramProperty="company" paramScope="page">
                        <bean:message key="label.organizations"/>
                    </html:link>
                </td>
            </tr>

            <july:separator colspan="<%= gColSpan %>" />

	      </logic:present>
        </logic:iterate>

        <tr class="title">
            <td colspan="<%= gColSpan %>" align="left">&nbsp;</td>
        </tr>
        
      <july:separator colspan="<%= gColSpan %>" />
<%--      
      <tr class="title">
    	<td class="title" colspan="<%= gColSpan %>">
           <july:currmark><bean:message key="label.companies"/></july:currmark></td>
      </tr>
--%>        
    </table>

</july:browseform>
