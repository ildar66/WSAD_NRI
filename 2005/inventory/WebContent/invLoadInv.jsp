<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<july:editform action="/ProcessInvLoadInv.do" enctype="multipart/form-data">

<html:hidden property="doc" />

<table class="main">    
    
    <july:separator/>
    
    <tr>
        <td class="title" colspan="2"><FONT class="attention"><bean:message key="label.loadpsion.note" /></FONT></td>
    </tr>

    <july:separator/>

    <tr>
        <td class="text"><bean:message key="label.loadpsion.file"/>:</td>
        <td>
		<html:file property="dataFrm" size="35" />&nbsp;
        </td>
    </tr>

    <july:separator/>
    
    <tr class="title">
	<td colspan="2">
		<input type="image" name="submit" src="/images/loadinv.gif" alt="���������" onclick="document.body.style.cursor='wait';if (document.forms(0).elements('wasposted').value == 1) { alert('������ ��� ��������� �� ������ ���������� ���������'); return false; } else { document.forms(0).elements('wasposted').value=1; }">&nbsp;<a href='EditPositionInventory.do' title="�������"><img src="/images/cancel.gif" alt="�������" border=0></a>
	</td>
    </tr>
    
    <july:separator/>
    
</table>


</july:editform>

