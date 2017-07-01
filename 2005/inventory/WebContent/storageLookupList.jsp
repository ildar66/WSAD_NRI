<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "3"; %>

<july:browseform action="/ShowStorageLookupList.do" styleId="storageLookupListForm">
<july:lookupresult tableId="brtable" resultCols="0;1"/>
<table class="main">
<tr class="title"><td colspan="<%= gColSpan %>" class="title"><bean:message key="label.choose.storageplace"/></td></tr>
<tr class="normal">
	<td colspan="<%= gColSpan %>">
	<table class="find">
	<tr>
		<td colspan="<%= gColSpan %>" align="right"><july:searchbutton /></td>
	</tr>        
	</table>
	</td>
</tr>

<tr class="title">
	<td><table class="buttons"><tr class="title"><td class="buttons"><july:closebutton page="/"/></td><td class="navigator"><july:navigator/></td></tr></table></td>
</tr>

<tr><td>
<table class="main" id="brtable">
<!-- Table header -->
<tr class="title">
	<td style="visibility:hidden;display:none;"><bean:message key="label.storplace.code"/></td>
	<july:headercolumn key="label.storplace.name" colType="string"/>
	<july:headercolumn key="label.position.region" colType="string"/>
</tr>

<!-- Table body -->
<logic:iterate id="sl" name="browseList" indexId="index" type="com.hps.july.cdbc.lib.CDBCRowObject">
<logic:present name="sl">
	<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
		<td style="visibility:hidden;display:none;"><july:stringwrite name="sl" property="storageplace"/></td>
		<td class="text"><july:lookupreturn><july:stringwrite name="sl" property="spname"/></july:lookupreturn></td>
		<td class="text"><july:stringwrite name="sl" property="regname"/></td>
	</tr>
</logic:present>
<logic:notPresent name="sl">
	<tr class="normal">
		<td class="text" colspan="<%= gColSpan %>"><bean:message key="label.norecords"/></td>
	</tr>
</logic:notPresent>
<july:separator colspan="<%= gColSpan %>" />
</logic:iterate>
</table>
</td></tr>
<tr class="title">
	<td><table class="buttons"><tr class="title"><td class="buttons"><july:closebutton page="/"/></td><td class="navigator"><july:navigator/></td></tr></table></td>
</tr>
</table>
</july:browseform>
