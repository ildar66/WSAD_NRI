<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "6"; %>

<july:browseform action="/ShowAccountListC.do">

<html:hidden property="organization"/>

<table class="main">
<%--SA
<tr class="title">
	<td class="title" colspan="<%= gColSpan %>">
       <html:link page="/ShowCompanyList.do" styleClass="navigator"><bean:message key="label.companies"/></html:link> 
       <july:sepmark/> 
       <html:link page="/ShowOrganizationListC.do" styleClass="navigator"><bean:message key="label.organizations"/></html:link> 
       <july:sepmark/> 
       <july:currmark><bean:message key="label.accounts"/></july:currmark></td>
</tr>
--%>
<july:separator colspan="<%= gColSpan %>" />

<TR class="normal">
 <TD colspan="<%= gColSpan %>">
 
    <table class="find">
    <TR>
       <td class="title"><bean:message key="label.company.name"/>:</td>
       <td class="title"><bean:write name="AccountListCForm" property="compname" /></td>
     </TR>        
    <TR>
       <td class="title"><bean:message key="label.organization.name"/>:</td>
       <td class="title"><bean:write name="AccountListCForm" property="orgname" /></td>
     </TR>        
     </table>
    
  </TD>
</TR>


<july:separator colspan="<%= gColSpan %>" />

      <tr class="title">
          <td colspan="<%= gColSpan %>"><TABLE class="buttons">
            <TR class="title">
              <TD class="buttons"><july:addbutton page="/EditAccountC.do?action=Add"/><july:backbutton page="/ShowOrganizationListC.do"/></TD>
              <TD class="navigator"><july:navigator/></TD>
            </TR>
            </TABLE></TD>
      </tr>
      
      <july:separator colspan="<%= gColSpan %>" />
  
    <!-- Table header -->
    <tr class="title">
        <TD class="title">&nbsp;</TD>
<%--        <july:headercolumn key="label.code" colType="number"/> --%>
        <july:headercolumn key="label.account.value" colType="string"/>
        <july:headercolumn key="label.account.bank" colType="string"/>
        <july:headercolumn key="label.bank.bik" colType="string"/>
        <july:headercolumn key="label.bank.corraccount" colType="string"/>
        <TD class="title">&nbsp;</TD>
    </tr>

<july:separator colspan="<%= gColSpan %>" />

        <!-- Table body -->
    <logic:iterate id="acc" name="browseList">
        <logic:present name="acc">
            <tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
                <td class="text">
			<july:editbutton page="/EditAccountC.do" action="Edit" paramId="account" paramName="acc" paramProperty="account" paramScope="page"/>
		</td>
<%--
                <td class="number">
                      <bean:write name="acc" property="account" filter="true"/>
                </td>
--%>
                <td class="text">
                    <bean:write name="acc" property="accountvalue" filter="true"/>
                </td>
                <td class="text">
                    <bean:write name="acc" property="bank.name" filter="true"/>
                </td>
                <td class="text">
                    <bean:write name="acc" property="bank.bik" filter="true"/>
                </td>
                <td class="text">
                    <bean:write name="acc" property="bank.koraccount" filter="true"/>
                </td>
                <td class="link"><july:delbutton page="/EditAccountC.do?action=Delete" paramId="account" paramName="acc" paramProperty="account" paramScope="page"/></td>
            </tr>

            <july:separator colspan="<%= gColSpan %>" />

	      </logic:present>
      </logic:iterate>

      <tr class="title">
          <td colspan="<%= gColSpan %>"><TABLE class="buttons">
            <TR class="title">
              <TD class="buttons"><july:addbutton page="/EditAccountC.do?action=Add"/><july:backbutton page="/ShowOrganizationListC.do"/></TD>
              <TD class="navigator"><july:navigator/></TD>
            </TR>
            </TABLE></TD>
      </tr>
      
      <july:separator colspan="<%= gColSpan %>" />
<%--SA      
      <tr class="title">
    	<td class="title" colspan="<%= gColSpan %>">
           <html:link page="/ShowCompanyList.do" styleClass="navigator"><bean:message key="label.companies"/></html:link> 
           <july:sepmark/> 
           <html:link page="/ShowOrganizationListC.do" styleClass="navigator"><bean:message key="label.organizations"/></html:link> 
           <july:sepmark/> 
           <july:currmark><bean:message key="label.accounts"/></july:currmark></td>
      </tr>
--%>      
</table>

</july:browseform>
