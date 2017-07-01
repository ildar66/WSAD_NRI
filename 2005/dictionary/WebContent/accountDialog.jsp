<%@ page language = "java" %>                                                                                                  
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ page import="org.apache.struts.util.*" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.dictionary.*,com.hps.july.dictionary.formbean.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<% 
	java.lang.String gColSpan = "2";
	int account_length = 20;
%>
<%
	String action = "/AccountDialogProcess.do";
	String form = "AccountDialogForm";
	String src = "/images/save.gif";
	String alt = "Сохранить запись";
%>
<july:errors property="org.apache.struts.action.GLOBAL_ERROR"/>
<logic:equal name="<%= form %>" property="action" value="Delete">
	<% src = "/images/delconf.gif"; alt = "Удалить запись"; %>
</logic:equal>
<%--
	int state = ParamsParser.getState( pageContext );
	String action = null;
	String form = "AccountForm";
	int account_length = 20;
	switch( state )
	{
	case APPStates.EDITACC:
		action = "/ProcessAccount.do";
		form = "AccountForm";
		try {
			account_length = ((AbstractAccountForm)request.getAttribute("AccountForm")).getAccount_length();
		} catch(Exception ec) {}
		break;
	case APPStates.EDITACCC:
		action = "/ProcessAccountC.do";
		form = "AccountFormC";
		try {
			account_length = ((AbstractAccountForm)request.getAttribute("AccountFormC")).getAccount_length();
		} catch(Exception ec) {}
		break;
	}
--%>

<july:editform action="<%= action %>" styleId="<%= form %>">
<html:hidden property="account"/>

<script language="javascript">
	function Close()
		{
			if(window.opener) {
				//opener.storeSelectedRow(document.all.accountvalue.value);
				//opener.location.reload(true);
				window.opener.window.document.forms(0).submit();
				//window.opener.window.location.href=window.opener.window.location.href;
				window.opener.focus();
			}
			window.close();
		}
</script>
<script>
var account_length = <%=account_length%>;
function checkAccountLength() {
	if(document.all.accountvalue) {
		if(!document.all.accountvalue.disabled && !document.all.accountvalue.readOnly) {
			if(document.all.accountvalue.value.length != account_length) {
				return confirm('Номер расчётного счёта должен состоять из '+account_length+' символов.\nЕсли хотите продолжить нажмите "Ок".\nЕсли хотите поправить номер счёта нажмите "Отмена".');
			}
		}
	}
	return true;
}
</script>

<table class="main">
<%--
    <tr class="title">
    	<td class="title" colspan="2">
           <jsp:useBean id="CURRENT_STATE" scope="request" type="java.lang.String" />
           <logic:equal name="CURRENT_STATE" value="<%= new java.lang.Integer(APPStates.EDITACC).toString() %>">
               <html:link page="/ShowOrganizationListM.do" styleClass="navigator"><bean:message key="label.organizations"/></html:link>
               <july:sepmark/>
               <html:link page="/ShowAccountList.do" styleClass="navigator"><bean:message key="label.accounts"/></html:link>
               <july:sepmark/>
           </logic:equal>
           <logic:equal name="CURRENT_STATE" value="<%= new java.lang.Integer(APPStates.EDITACCC).toString() %>">
               <html:link page="/ShowCompanyList.do" styleClass="navigator"><bean:message key="label.companies"/></html:link>
               <july:sepmark/>
               <html:link page="/ShowOrganizationListC.do" styleClass="navigator"><bean:message key="label.organizations"/></html:link>
               <july:sepmark/>
               <html:link page="/ShowAccountList.do" styleClass="navigator"><bean:message key="label.accounts"/></html:link>
               <july:sepmark/>
           </logic:equal>
           <july:actionname/></td>
    </tr>
--%>    
<july:separator/>
    <tr class="title">
    	<td class="title" colspan="6">
			<INPUT TYPE="IMAGE" NAME="submit" SRC="<%= src%>"  ALT="<%= alt%>" onclick="if(!checkAccountLength()) { return false; } document.body.style.cursor='wait'; if (document.forms(0).elements('wasposted').value == 1) { alert('Запрос уже отправлен на сервер пожалуйста подождите'); return false; } else { document.forms(0).elements('wasposted').value=1; } ">&nbsp;
			<july:closebutton page="/"/>
        </td>
    </tr>
<july:separator colspan="<%= gColSpan %>"/>  

<tr>
	<td class="title" colspan="2"><july:actionalert/></td>
</tr>
    
<july:separator/>
<html:hidden property="orgcode" />
<%--    
<tr>
	<td class="text"><july:reqmark><bean:message key="label.organization.name"/>:</july:reqmark></td>
	<td>
		<html:hidden property="orgcode" />
		<july:string property="orgname" size="25" insertable="false" updatable="false" />
	</td>
</tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.code"/>:</july:reqmark></td>
        <td>
          <july:string property="account" size="5" insertable="false" updatable="false" />
        </td>
    </tr>
<july:separator/>    
--%>    
    
<tr>
	<td class="text"><july:reqmark><bean:message key="label.account.value"/>:</july:reqmark></td>
	<td>
		<july:string property="accountvalue" size="25" insertable="true" updatable="true" />
	</td>
</tr>
    
<july:separator/>
    
<tr>
	<td class="text"><july:reqmark><bean:message key="label.account.bank"/>:</july:reqmark></td>
	<td>
		<july:string property="bankbik" styleId="bbik" size="10" insertable="true" updatable="true" />
		<%--july:lookupbutton action="/ShowBankLookupList.do" styleId="bnkl" fieldNames="bbik;bcode;bname" insertable="true" updatable="true" /--%>
		<html:link  page="/BanksLookupList.do?formname=AccountDialogForm&fieldnames=bankcode|bankname|bankbik&isBik=false&isName=true" scope="session" onclick="window.open(this.href+'&bik='+AccountDialogForm.bankbik.value, 'BankLookupList', 'top=40, left=100, width=700, height=650, scrollbars=yes, resizable=yes').focus(); return false;" title="справочник Банков">
			<IMG SRC="/images/lookup.gif" BORDER='0' ALT='справочник Банков'>
		</html:link>
		<july:string property="bankcode" styleId="bcode" size="5" insertable="false" updatable="false" />
		<july:string size="40" property="bankname" styleId="bname"  insertable="false" updatable="false" />
	</td>
</tr>
    
<july:separator/>
    
<tr>
	<td class="text"><bean:message key="label.account.isactive"/>:</td>
	<td>
		<july:checkbox property="active" insertable="true" updatable="true" value="true" />
	</td>
</tr>
    
<july:separator/>
    <tr class="title">
    	<td class="title" colspan="6">
			<INPUT TYPE="IMAGE" NAME="submit" SRC="<%= src%>"  ALT="<%= alt%>" onclick="if(!checkAccountLength()) { return false; } document.body.style.cursor='wait'; if (document.forms(0).elements('wasposted').value == 1) { alert('Запрос уже отправлен на сервер пожалуйста подождите'); return false; } else { document.forms(0).elements('wasposted').value=1; } ">&nbsp;
			<july:closebutton page="/"/>
        </td>
    </tr>
<july:separator/>
    
</table>
<logic:equal name="<%=form%>" property="flagOperation" value="true">
	<script language="javascript" type="text/javascript">
		 Close();
	</script>
</logic:equal>
</july:editform>
