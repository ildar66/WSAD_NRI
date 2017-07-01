<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<july:editform action="/ProcessInvLoadExcel.do" enctype="multipart/form-data">

<html:hidden property="doc" />

<table class="main">
    
	<july:separator/>
	<tr class="title">
	<td colspan="2">
		<input type="image" name="submit" src="/images/loadexcel.gif" alt="Загрузить" onclick="document.body.style.cursor='wait';if (document.forms(0).elements('wasposted').value == 1) { alert('Запрос уже отправлен на сервер пожалуйста подождите'); return false; } else { document.forms(0).elements('wasposted').value=1; }">&nbsp;<a href='EditPositionInventory.do' title="Возврат"><img src="/images/cancel.gif" alt="Возврат" border=0></a>
	</td>
    </tr>
    <july:separator/>
    
    <tr>
        <td class="title" colspan="2"><FONT class="attention"><bean:message key="label.loadpsion.note" /></FONT></td>
    </tr>

    <july:separator/>

<%--
	// Insert here document information
    
    <july:separator/>

 --%>

    <tr>
        <td class="text"><bean:message key="label.loadpsion.file"/>:</td>
        <td>
		<html:file property="psiondataFrm" size="35" />&nbsp;
        </td>
    </tr>
<%--    
    <july:separator/>
    
    <tr>
        <td class="text" valign="top" rowspan="2"><bean:message key="label.loadpsion.options"/>:</td>
        <td>
		<july:radio styleClass="text" insertable="true" updatable="true" property="options" value="1"/><bean:message key="label.loadpsion.options.1"/>
        </td>
    </tr>

    <tr>
        <td>
		<july:radio styleClass="text" insertable="true" updatable="true" property="options" value="2"/><bean:message key="label.loadpsion.options.2"/>
        </td>
    </tr>
--%>    
    <july:separator/>
    
    <tr class="title">
	<td colspan="2">
		<input type="image" name="submit" src="/images/loadexcel.gif" alt="Загрузить" onclick="document.body.style.cursor='wait';if (document.forms(0).elements('wasposted').value == 1) { alert('Запрос уже отправлен на сервер пожалуйста подождите'); return false; } else { document.forms(0).elements('wasposted').value=1; }">&nbsp;<a href='EditPositionInventory.do' title="Возврат"><img src="/images/cancel.gif" alt="Возврат" border=0></a>
	</td>
    </tr>
    
    <july:separator/>
    
</table>


</july:editform>

