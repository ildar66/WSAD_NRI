<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<SCRIPT language=javascript src="/common/dialog.js" type="text/javascript"></SCRIPT>  

<% java.lang.String gColSpan = "7"; %>

<july:browseform action="/AccountsLookupList.do">

<html:hidden property="idVendorSite"/>
<html:hidden property="formname"/>
<html:hidden property="fieldnames"/>

<script language="javascript">
function Go(strval) {
	var thisform = document.forms[0];
	var outform = window.opener.document.forms[thisform.formname.value];
	
	if(outform != null)
	{
		var names = thisform.fieldnames.value.split('|'), values = strval.split('|');
		for(var i in names) {
			if(names[i].length > 0)
				outform[names[i]].value = unescape(values[i]);
		}
	}
	Close();
}
function Close()
{
	var thisform = document.forms[0];
	var outform = window.opener.document.forms[thisform.formname.value];
	if(outform != null) {
		document.body.style.cursor="wait";
		window.opener.focus();
	}
	window.close();
}
</script>

<table class="main" style="font-size: 8pt;">
<july:separator colspan="<%= gColSpan %>" />

<TR class="normal">
 <TD colspan="<%= gColSpan %>">
    <table class="find">
	    <TR>
	       <td class="title"><bean:message key="label.organization.name"/>:</td>
	       <td class="title">
		       <logic:present name="AccountsLookupListForm" property="vendorSite_VO">
		       		<bean:write name="AccountsLookupListForm" property="vendorSite_VO.name" />
		       	</logic:present>
		       	<logic:notPresent name="AccountsLookupListForm" property="vendorSite_VO">
					<B style="color: red;">Отделение поставщика не найдено !!!</B>
				</logic:notPresent>
			</td>
	     </TR>       
     </table>
  </TD>
</TR>
<july:separator colspan="<%= gColSpan %>" />

      <tr class="title">
          <td colspan="<%= gColSpan %>">
          <TABLE class="buttons">
            <TR class="title">
              <TD class="buttons">
				<%--july:backbutton/--%>
				<logic:present name="AccountsLookupListForm" property="vendorSite_VO">
				<A href='AccountsDialog.do?action=Add&idVendorSite=<bean:write name="AccountsLookupListForm" property="idVendorSite" filter="true"/>' onclick='return openDialog(this.href, "AccountDialog", "top=100, left=400, width=500, height=250, scrollbars=yes, resizable=yes");'>
					<IMG SRC="/images/plus.gif" BORDER='0' ALT='Добавить запись'></A>
				</logic:present>
			  </TD>
              <TD class="navigator"><july:navigator/></TD>
            </TR>
           </TABLE>
           </td>
      </tr>
      
    <july:separator colspan="<%= gColSpan %>" />
    <!-- Table header -->
    <tr class="title">
	<td class="title">&nbsp;</td>
	<TD class="title">&nbsp;</TD>
<%--        <july:headercolumn key="label.code" colType="number"/>--%>
        <july:headercolumn key="label.account.value" colType="string"/>
        <july:headercolumn key="label.account.bank" colType="string"/>
        <july:headercolumn key="label.bank.bik" colType="string"/>
        <july:headercolumn key="label.bank.corraccount" colType="string"/>
        <TD class="title">&nbsp;</TD>
    </tr>

    <!-- Table body -->
    <logic:iterate id="acc" name="browseList">
        <logic:present name="acc">
            <tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
                <td class="text">
					<%--july:editbutton page="/EditAccount.do" action="Edit" paramId="account" paramName="acc" paramProperty="account" paramScope="page"/--%>
					<A href='AccountsDialog.do?action=Edit&id=<bean:write name="acc" property="vo.accountId" filter="true"/>' onclick='return openDialog(this.href, "AccountDialog", "top=100, left=400, width=500, height=250, scrollbars=yes, resizable=yes");'><IMG SRC="/images/izmena.gif" BORDER='0' ALT='Изменить запись'></A>					
				</td>
				<td class="text">
                 		<A href="javascript:Go('<bean:write name="acc" property="vo.accountId" filter="true"/>|<bean:write name="acc" property="vo.account" filter="true"/>|<bean:write name="acc" property="bank_VO.name" filter="true"/>|<bean:write name="acc" property="bank_VO.bik" filter="true"/>|<bean:write name="acc" property="bank_VO.korAccount" filter="true"/>|<bean:write name="acc" property="bank_VO.legalAddress" filter="true"/>')" title="Выберите запись">
                    		выбрать</A>
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
          <td colspan="<%= gColSpan %>">
          <TABLE class="buttons">
            <TR class="title">
              <TD class="buttons">
				<%--july:backbutton/--%>
				<logic:present name="AccountsLookupListForm" property="vendorSite_VO">				
				<A href='AccountsDialog.do?action=Add&idVendorSite=<bean:write name="AccountsLookupListForm" property="idVendorSite" filter="true"/>' onclick='return openDialog(this.href, "AccountDialog", "top=100, left=400, width=500, height=250, scrollbars=yes, resizable=yes");'>
					<IMG SRC="/images/plus.gif" BORDER='0' ALT='Добавить запись'></A>
				</logic:present>
			  </TD>
              <TD class="navigator"><july:navigator/></TD>
            </TR>
           </TABLE>
           </td>
      </tr>
      <july:separator colspan="<%= gColSpan %>" />

      
</table>

</july:browseform>
