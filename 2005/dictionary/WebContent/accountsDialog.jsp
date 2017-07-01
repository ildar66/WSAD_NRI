<%@ page language = "java" %>                                                                                                  
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ page import="org.apache.struts.util.*" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.dictionary.*,com.hps.july.dictionary.formbean.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<SCRIPT language=javascript src="/common/dialog.js" type="text/javascript"></SCRIPT>  
<% 
	java.lang.String gColSpan = "2";
	int account_length = 20;
%>
<%
	String action = "/AccountsProcess.do";
	String form = "AccountsDialogForm";
	String src = "/images/save.gif";
	String alt = "Сохранить запись";
%>
<july:errors property="org.apache.struts.action.GLOBAL_ERROR"/>
<logic:equal name="<%= form %>" property="action" value="Delete">
	<% src = "/images/delconf.gif"; alt = "Удалить запись"; %>
</logic:equal>

<july:editform action="<%= action %>" styleId="<%= form %>">
<html:hidden property="id" />
<html:hidden property="idVendorSite"/>

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
    
<tr>
	<td class="text"><july:reqmark><bean:message key="label.account.value"/>:</july:reqmark></td>
	<td>
		<july:string property="to.vo.account" styleId="accountvalue" size="25" insertable="true" updatable="true" />
	</td>
</tr>
    
<july:separator/>
    
<tr>
	<td class="text"><july:reqmark><bean:message key="label.account.bank"/>:</july:reqmark></td>
	<td>
		<july:string property="to.bank_VO.bik" styleId="bbik" size="10" insertable="true" updatable="true" />
		<%--july:lookupbutton action="/ShowBankLookupList.do" styleId="bnkl" fieldNames="bbik;bcode;bname" insertable="true" updatable="true" /--%>
		<html:link  page="/BanksLookupList.do?formname=AccountsDialogForm&fieldnames=bcode|bname|bbik&isBik=false&isName=true" scope="session" onclick="return openDialog(this.href+'&bik='+AccountsDialogForm.bbik.value, 'BankLookupList', 'top=40, left=100, width=700, height=650, scrollbars=yes, resizable=yes');" title="справочник Банков">
			<IMG SRC="/images/lookup.gif" BORDER='0' ALT='справочник Банков'>
		</html:link>
		<july:string property="to.vo.bank" styleId="bcode" size="5" insertable="false" updatable="false" />
		<july:string size="40" property="to.bank_VO.name" styleId="bname"  insertable="false" updatable="false" />
	</td>
</tr>
    
<july:separator/>
    
<tr>
	<td class="text"><bean:message key="label.account.isactive"/>:</td>
	<td>
		<july:checkbox property="to.vo.active" insertable="true" updatable="true" value="true" />
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
