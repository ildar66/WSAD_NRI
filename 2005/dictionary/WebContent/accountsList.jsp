<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "6"; %>

<july:browseform action="/AccountsList.do">

<html:hidden property="idVendorSite"/>

<table class="main">
<july:separator colspan="<%= gColSpan %>" />

<TR class="normal">
 <TD colspan="<%= gColSpan %>">
 
    <table class="find">
    <TR>
       <td class="title"><bean:message key="label.organization.name"/>:</td>
       <td class="title"><bean:write name="AccountsListForm" property="vendorSite_VO.name" /></td>
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
			<A href='AccountsDialog.do?action=Add&idVendorSite=<bean:write name="AccountsListForm" property="idVendorSite" filter="true"/>' onclick='return openDialog(this.href, "AccountDialog", "top=100, left=400, width=500, height=250, scrollbars=yes, resizable=yes");'>
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
					<A href='AccountsDialog.do?action=Edit&id=<bean:write name="acc" property="vo.accountId" filter="true"/>' onclick='return openDialog(this.href, "AccountDialog", "top=100, left=400, width=500, height=250, scrollbars=yes, resizable=yes");'><IMG SRC="/images/izmena.gif" BORDER='0' ALT='Изменить запись'></A>					
				</td>
                <td class="text">
					<bean:write name="acc" property="vo.account" filter="true"/>
                </td>
                <td class="text">
                    <bean:write name="acc" property="bank_VO.name" filter="true"/>
                </td>
                <td class="text">
                    <bean:write name="acc" property="bank_VO.bik" filter="true"/>
                </td>
                <td class="text">
                    <bean:write name="acc" property="bank_VO.korAccount" filter="true"/>
                </td>
                    <td class="link">
                        <%--july:delbutton page="/EditAccount.do?action=Delete" paramId="account" paramName="acc" paramProperty="account" paramScope="page"/--%>
						<A href='AccountsDialog.do?action=Delete&id=<bean:write name="acc" property="vo.accountId" filter="true"/>' onclick='return openDialog(this.href, "AccountDialog", "top=100, left=400, width=600, height=600, scrollbars=yes, resizable=yes");'>
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
				<july:backbutton/>
				<A href='AccountsDialog.do?action=Add&idVendorSite=<bean:write name="AccountsListForm" property="idVendorSite" filter="true"/>' onclick='return openDialog(this.href, "AccountDialog", "top=100, left=400, width=500, height=250, scrollbars=yes, resizable=yes");'>
					<IMG SRC="/images/plus.gif" BORDER='0' ALT='Добавить запись'></A>
			  </TD>
              <TD class="navigator"><july:navigator/></TD>
            </TR>
            </TABLE></TD>
      </tr>
      
      <july:separator colspan="<%= gColSpan %>" />
      
</table>

</july:browseform>
