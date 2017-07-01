<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<july:editform action="/ProcessInvActFillFromDB.do">

<html:hidden property="doc" />

<table class="main">    
    <july:separator/>
	<tr class="title">
	<td colspan="2">
		<input type="image" name="submit" src="/images/loaddb.gif" alt="���������" onclick="document.body.style.cursor='wait';if (document.forms(0).elements('wasposted').value == 1) { alert('������ ��� ��������� �� ������ ���������� ���������'); return false; } else { document.forms(0).elements('wasposted').value=1; }">&nbsp;<july:backbutton/>
	</td>
    </tr>
    <july:separator/>
    
    <tr>
        <td class="title" colspan="2"><FONT class="attention"><bean:message key="label.loadpsion.note" /></FONT></td>
    </tr>

    <july:separator/>

    <tr>
        <td class="text" width="33%"><bean:message key="label.invpos.act"/>:</td>
        <td>
		<july:stringwrite name="InvActFillFromDBForm" property="blankindex" />&nbsp;<july:stringwrite name="InvActFillFromDBForm" property="blanknumber" />
        </td>
    </tr>

    <july:separator/>
    
    <tr>
        <td class="text"><bean:message key="label.inventory.date"/>:</td>
        <td>
		<july:datewrite name="InvActFillFromDBForm" property="blankdate" />
        </td>
    </tr>

    <july:separator/>
    
    <tr>
        <td class="text"><bean:message key="label.inventory.org"/>:</td>
        <td>
		<july:stringwrite name="InvActFillFromDBForm" property="orgname" />
        </td>
    </tr>

    <july:separator/>
    
    <tr>
        <td class="text"><bean:message key="label.inventory.placename"/>:</td>
        <td>
		<july:stringwrite name="InvActFillFromDBForm" property="storagename" />
        </td>
    </tr>

    <july:separator/>
    
    <tr>
        <td class="text"><bean:message key="label.inventory.type"/>:</td>
        <td>
		<logic:equal name="InvActFillFromDBForm" property="type" value="F">
			<bean:message key="label.inventory.type.full" />
		</logic:equal>
		<logic:equal name="InvActFillFromDBForm" property="type" value="A">
			<bean:message key="label.inventory.type.byunit" />
		</logic:equal>
		<logic:equal name="InvActFillFromDBForm" property="type" value="P">
			<bean:message key="label.inventory.type.byselect" />
		</logic:equal>
        </td>
    </tr>
<logic:equal name="InvActFillFromDBForm" property="type" value="A">
    <july:separator/>
    
    <tr>
        <td class="text"><bean:message key="label.inventory.placename"/>:</td>
        <td>
		<july:stringwrite name="InvActFillFromDBForm" property="agregatename" />
        </td>
    </tr>
</logic:equal>
    <july:separator/>

    <tr class="title">
	<td colspan="2">
		<input type="image" name="submit" src="/images/loaddb.gif" alt="���������" onclick="document.body.style.cursor='wait';if (document.forms(0).elements('wasposted').value == 1) { alert('������ ��� ��������� �� ������ ���������� ���������'); return false; } else { document.forms(0).elements('wasposted').value=1; }">&nbsp;<july:backbutton/>
	</td>
    </tr>
    
    <july:separator/>
    
</table>


</july:editform>

