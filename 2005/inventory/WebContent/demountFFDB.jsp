<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<july:editform action="/ProcessDemountFFDB.do">

<html:hidden property="document" />

<table class="main">
    
<july:separator/>
    
<tr>
	<td class="title" colspan="2"><FONT class="attention"><bean:message key="label.loadpsion.note" /></FONT></td>
</tr>

<july:separator/>
    
<tr>
	<td class="title"><bean:message key="label.dismantlingp.document"/></td>
	<td class="title"><bean:message key="label.num"/>&nbsp;<july:stringwrite name="DemountFFDB" property="blankindex"/>&nbsp;<july:stringwrite name="DemountFFDB" property="blanknumber"/>&nbsp;<bean:message key="label.from" />&nbsp;<july:datewrite name="DemountFFDB" property="blankdate"/></td>
</tr>

<july:separator/>

<tr>
	<td class="title"><bean:message key="label.dismantlingp.owner"/></td>
	<td class="title"><july:stringwrite name="DemountFFDB" property="ownername"/></td>
</tr>

<july:separator/>
    
<tr>
	<td class="title"><bean:message key="label.dismantlingp.position"/></td>
	<td class="title"><july:stringwrite name="DemountFFDB" property="positionname"/></td>
</tr>

<july:separator/>

<tr>
	<td class="title"><bean:message key="label.dismantlingp.complect"/></td>
	<td class="title"><july:stringwrite name="DemountFFDB" property="complectname"/></td>
</tr>

<july:separator/>

<logic:present name="DemountFFDB" property="totype">
<logic:equal name="DemountFFDB" property="totype" value="P">
	<tr>
		<td class="title"><bean:message key="label.dismantlingp.provider"/>:</td>
		<td class="title">
			<bean:write name="DemountFFDB" property="suppliername"/>
		</td>
	</tr>
	<tr>
		<td class="title"><bean:message key="label.dismantlingp.insuranceman"/>:</td>
		<td class="title">
			<bean:write name="DemountFFDB" property="supplierfio"/>
		</td>
	</tr>
</logic:equal>
<logic:equal name="DemountFFDB" property="totype" value="W">
	<tr>
		<td class="title"><bean:message key="label.dismantlingp.worker"/>:</td>
		<td class="title">
			<bean:write name="DemountFFDB" property="workername"/>
		</td>
	</tr>
</logic:equal>
</logic:present>

<july:separator/>
    
<tr class="title">
	<td colspan="2">
		<input type="image" name="submit" src="/images/loaddb.gif" alt="Заполнить" onclick="document.body.style.cursor='wait';if (document.forms(0).elements('wasposted').value == 1) { alert('Запрос уже отправлен на сервер пожалуйста подождите'); return false; } else { document.forms(0).elements('wasposted').value=1; }">&nbsp;<a href='EditDemount.do' title="Возврат"><img src="/images/cancel.gif" alt="Возврат" border=0></a>
	</td>
</tr>
   
<july:separator/>

</table>

</july:editform>
