<%@ page language = "java" %>                                                                                                  
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import="org.apache.struts.util.*" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.dictionary.*,com.hps.july.dictionary.formbean.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<%
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
	
%>
<july:editform action="<%= action %>" styleId="">

<html:hidden property="account"/>

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
  
<logic:equal name="<%=form%>" property="action" value="Delete">
	<july:formbuttons/>
</logic:equal>
<logic:notEqual name="<%=form%>" property="action" value="Delete">
    <tr class="title">
	<td colspan="2">
		<input type="image" name="submit" src="/images/save.gif" ALT="Сохранить" onclick="if(!checkAccountLength()) { return false; } document.body.style.cursor='wait'; if (document.forms(0).elements('wasposted').value == 1) { alert('Запрос уже отправлен на сервер пожалуйста подождите'); return false; } else { document.forms(0).elements('wasposted').value=1; } ">&nbsp;<A ID="ResetButton" HREF='#'><IMG SRC="/images/restore.gif" onclick="document.forms(0).reset()" ALT="Отменить правку" border=0></A>&nbsp;<july:backbutton/>
	</td>
    </tr>
</logic:notEqual>

<tr>
	<td class="title" colspan="2"><july:actionalert/></td>
</tr>
    
<july:separator/>
    
<tr>
	<td class="text"><july:reqmark><bean:message key="label.organization.name"/>:</july:reqmark></td>
	<td>
		<html:hidden property="orgcode" />
		<july:string property="orgname" size="25" insertable="false" updatable="false" />
	</td>
</tr>
<%--    
    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.code"/>:</july:reqmark></td>
        <td>
          <july:string property="account" size="5" insertable="false" updatable="false" />
        </td>
    </tr>
--%>    
<july:separator/>
    
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
		<july:lookupbutton action="/ShowBankLookupList.do" styleId="bnkl" fieldNames="bbik;bcode;bname" insertable="true" updatable="true" />
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

<logic:equal name="<%=form%>" property="action" value="Delete">
	<july:formbuttons/>
</logic:equal>
<logic:notEqual name="<%=form%>" property="action" value="Delete">
    <tr class="title">
	<td colspan="2">
		<input type="image" name="submit" src="/images/save.gif" ALT="Сохранить" onclick="if(!checkAccountLength()) { return false; } document.body.style.cursor='wait'; if (document.forms(0).elements('wasposted').value == 1) { alert('Запрос уже отправлен на сервер пожалуйста подождите'); return false; } else { document.forms(0).elements('wasposted').value=1; } ">&nbsp;<A ID="ResetButton" HREF='#'><IMG SRC="/images/restore.gif" onclick="document.forms(0).reset()" ALT="Отменить правку" border=0></A>&nbsp;<july:backbutton/>
	</td>
    </tr>
</logic:notEqual>
    
<july:separator/>
    
</table>

</july:editform>
