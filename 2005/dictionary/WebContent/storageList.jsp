<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import="com.hps.july.siteinfo.valueobject.Regions"%>

<% java.lang.String gColSpan = "7"; %>

<july:browseform action="/ShowStorageList.do">

<table class="main">

<july:separator colspan="<%= gColSpan %>" />

<tr class="normal"><td colspan="<%= gColSpan %>">
<table class="find">
<tr>
	<td class="title">
		<jsp:include page="/common/srnr_select.jsp" flush="true" />
	</td>
	<td class="title"><july:searchbutton/></td>
</tr>        
</table>
</td></tr>

<july:separator colspan="<%= gColSpan %>" />

<tr class="title">
	<td colspan="<%= gColSpan %>"><table class="buttons"><tr class="title">
		<td class="buttons"><july:addbutton page="/EditStorage.do?action=Add"/><july:backbutton/></td>
		<td class="navigator"><july:navigator/></td>
	</tr></table></td>
</tr>

<july:separator colspan="<%= gColSpan %>" />
    
<!-- Table header -->
<tr class="title">
	<td class="title" width="1%">&nbsp;</td>
	<july:headercolumn key="label.name" colType="string"/>
	<july:headercolumn key="label.storage.division" colType="string"/>
	<july:headercolumn key="label.storage.region" colType="string"/>
	<july:headercolumn key="label.storage.addr" colType="string"/>
        <td class="title" width="1%">&nbsp;</td>
</tr>

<july:separator colspan="<%= gColSpan %>" />

<!-- Table body -->
<logic:iterate id="stl" name="browseList" type="com.hps.july.cdbc.lib.CDBCRowObject">
<logic:present name="stl">
<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
	<td class="link">
		<july:editbutton page="/EditStorage.do" action="Edit" paramId="storageplace" paramName="stl" paramProperty="storageplace" paramScope="page"/>
	</td>
	<td class="text"><july:stringwrite name="stl" property="spname"/></td>
	<td class="text"><july:stringwrite name="stl" property="name"/></td>
	<td class="text"><july:stringwrite name="stl" property="regname"/></td>
	<td class="text"><july:stringwrite name="stl" property="address"/></td>
	<td class="link">
		<july:delbutton page="/EditStorage.do?action=Delete" paramId="storageplace" paramName="stl" paramProperty="storageplace" paramScope="page"/>
	</td>
</tr>
<july:separator colspan="<%= gColSpan %>" />
</logic:present>
</logic:iterate>

<tr class="title">
	<td colspan="<%= gColSpan %>"><table class="buttons"><tr class="title">
		<td class="buttons"><july:addbutton page="/EditStorage.do?action=Add"/><july:backbutton/></td>
		<td class="navigator"><july:navigator/></td>
	</tr></table></td>
</tr>

<july:separator colspan="<%= gColSpan %>" />

</table>

</july:browseform>
