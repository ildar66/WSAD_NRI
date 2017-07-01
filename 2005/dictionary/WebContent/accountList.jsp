<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "6"; %>

<july:browseform action="/ShowAccountList.do">

<html:hidden property="organization"/>

<table class="main">
<%--
<tr class="title">
	<td class="title" colspan="<%= gColSpan %>">
       <html:link page="/ShowOrganizationListM.do" styleClass="navigator"><bean:message key="label.organizations"/></html:link> 
       <july:sepmark/> 
       <july:currmark><bean:message key="label.accounts"/></july:currmark></td>
</tr>
--%>
<july:separator colspan="<%= gColSpan %>" />

<TR class="normal">
 <TD colspan="<%= gColSpan %>">
 
    <table class="find">
    <TR>
       <td class="title"><bean:message key="label.organization.name"/>:</td>
       <td class="title"><bean:write name="AccountListForm" property="orgname" /></td>
     </tr>        
     </table>
    
  </TD>
</TR>


    <july:separator colspan="<%= gColSpan %>" />

      <tr class="title">
          <td colspan="<%= gColSpan %>"><TABLE class="buttons">
            <TR class="title">
              <TD class="buttons">
			<%--july:addbutton page="/EditAccount.do?action=Add"/--%>
			<%--<july:backbutton page="/ShowOrganizationListM.do"/>--%>
			<july:backbutton/>
			<A href='AccountDialog.do?action=Add&orgcode=<bean:write name="AccountListForm" property="organization" filter="true"/>' onclick='window.open(this.href, "AccountDialog", "top=100, left=400, width=500, height=250, scrollbars=yes, resizable=yes").focus(); return false;'>
				<IMG SRC="/images/plus.gif" BORDER='0' ALT='Добавить запись'></A>			
			  </TD>
              <TD class="navigator"><july:navigator/></TD>
            </TR>
            </TABLE></TD>
      </tr>
      
      <july:separator colspan="<%= gColSpan %>" />
  
    <!-- Table header -->
    <tr class="title">
	<td class="title">&nbsp;</td>
<%--        <july:headercolumn key="label.code" colType="number"/>--%>
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
					<%--july:editbutton page="/EditAccount.do" action="Edit" paramId="account" paramName="acc" paramProperty="account" paramScope="page"/--%>
					<A href='AccountDialog.do?action=Edit&account=<bean:write name="acc" property="account" filter="true"/>' onclick='window.open(this.href, "AccountDialog", "top=100, left=400, width=500, height=250, scrollbars=yes, resizable=yes").focus(); return false;'><IMG SRC="/images/izmena.gif" BORDER='0' ALT='Изменить запись'></A>					
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
                    <td class="link">
                        <%--july:delbutton page="/EditAccount.do?action=Delete" paramId="account" paramName="acc" paramProperty="account" paramScope="page"/--%>
						<A href='AccountDialog.do?action=Delete&account=<bean:write name="acc" property="account" filter="true"/>' onclick='window.open(this.href, "AccountDialog", "top=100, left=400, width=600, height=600, scrollbars=yes, resizable=yes").focus(); return false;'>
                			<img src="/images/del.gif" border="0" alt='<bean:message key="label.delete"/>'></A>                        
                    </td>
            </tr>

            <july:separator colspan="<%= gColSpan %>" />

	      </logic:present>
      </logic:iterate>

      <tr class="title">
          <td colspan="<%= gColSpan %>"><TABLE class="buttons">
            <TR class="title">
              <TD class="buttons">
			<%--july:addbutton page="/EditAccount.do?action=Add"/--%>
			<%--<july:backbutton page="/ShowOrganizationListM.do"/>--%>
			<july:backbutton/>
			<A href='AccountDialog.do?action=Add&orgcode=<bean:write name="AccountListForm" property="organization" filter="true"/>' onclick='window.open(this.href, "AccountDialog", "top=100, left=400, width=500, height=250, scrollbars=yes, resizable=yes").focus(); return false;'>
				<IMG SRC="/images/plus.gif" BORDER='0' ALT='Добавить запись'></A>
			  </TD>
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
           <july:currmark><bean:message key="label.accounts"/></july:currmark></td>
      </tr>
--%>      
</table>

</july:browseform>
