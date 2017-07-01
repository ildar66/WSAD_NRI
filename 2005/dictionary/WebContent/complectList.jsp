<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "8"; %>

<july:browseform action="/ShowComplectList.do">

<script language="javascript">
function switchSearch() {
	if(document.all.type.value == '*') {
		document.all.searchstr.disabled = true;
		document.all.searchstr.className = 'editdisabled';
	} else {
		document.all.searchstr.disabled = false;
		document.all.searchstr.className = 'editsearch';
	}
}
</script>

<table class="main">

<july:separator colspan="<%= gColSpan %>" />
<%--
<tr class="normal">
	<td colspan="<%= gColSpan %>">
	<table class="find">
	<tr>
		<td class="title"><bean:message key="label.restype"/>:</td>
		<td class="title">
			<july:string property="resourcetype.string" styleId="resourcetype" size="5" insertable="true" updatable="true"  styleClass="editkodsearch"/>
			<july:lookupbutton action="/ShowRestypeLookupList.do" styleId="rtl" fieldNames="resourcetype;resourcetypename" newWindowName="restypelookup" insertable="true" updatable="true"/>
			<july:string size="35" property="resourcetypename" styleId="resourcetypename" insertable="false" updatable="false" />
			<july:searchbutton/>
		</td>
	</tr>
	<tr>
		<td class="title"><bean:message key="label.subtype"/>:</td>
		<td class="title">
			<july:string property="resourcesubtype.string" styleId="resourcesubtype" size="5" insertable="true" updatable="true" styleClass="editkodsearch" />
			<july:lookupbutton action="/ShowRessbtypeLookupList.do" styleId="rstl" fieldNames="resourcesubtype;resourcesubtypename" newWindowName="ressbtypelookup" onclick="set_opt_params_rstl('?resourcetype='+document.all['resourcetype'].value)" insertable="true" updatable="true"/>
			<july:string size="35" property="resourcesubtypename" styleId="resourcesubtypename" insertable="false" updatable="false" />
		</td>
	</tr>
	</table>
	</td>
</tr>
--%>
<tr class="normal">
	<td colspan="<%= gColSpan %>">
	<table class="find">
	<tr>
		<td class="title">Искать</td>
		<td class="title">
			<july:select property="type" styleClass="editsearch" onchange="switchSearch();" insertable="true" updatable="true">
				<html:option value="*" key="label.resourceset.search.all"/>
				<html:option value="1" key="label.resourceset.search.1"/>
				<html:option value="2" key="label.resourceset.search.2"/>
				<html:option value="3" key="label.resourceset.search.3"/>
				<html:option value="4" key="label.resourceset.search.4"/>
			</july:select>
			<july:string size="35" property="searchstr" styleId="searchstr" insertable="true" updatable="true" styleClass="search"/>
			<july:searchbutton/>
			<script language="javascript">switchSearch();</script>
		</td>
	</tr>
	</table>
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>" />

<tr class="title">
	<td colspan="<%= gColSpan %>">
	<table class="buttons">
	<tr class="title">
		<td class="buttons"><july:addbutton page="/EditComplect.do?action=Add"/><july:backbutton/></td>
		<td class="navigator"><july:navigator/></td>
	</tr>
	</table>
	</td>
</tr>
        
<july:separator colspan="<%= gColSpan %>" />
      
<!-- Table header -->
<tr class="title">
	<td class="title" width="1%">&nbsp;</td>
	<july:headercolumn key="label.complect.name" colType="string"/>
	<july:headercolumn key="label.complect.mainpart.name" colType="string"/>
	<july:headercolumn key="label.complect.qty" colType="number"/>
	<july:headercolumn key="label.content" colType="link"/>
	<td class="title" width="1%">&nbsp;</td>
</tr>

<july:separator colspan="<%= gColSpan %>" />

<!-- Table body -->
<logic:iterate id="ul" name="browseList" type="com.hps.july.cdbc.lib.CDBCRowObject">
<logic:present name="ul">
<%
	pageContext.setAttribute("resset",ul.getColumn("resourceset").asString());
%>
	<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
		<td class="link"><july:editbutton page="/EditComplect.do" action="Edit" paramId="resourceset" paramName="resset" paramScope="page"/></td>
		<td class="text"><july:stringwrite name="ul" property="name"/></td>
		<td class="text"><july:stringwrite name="ul" property="mpname"/></td>
		<td class="number"><july:numberwrite name="ul" property="mainpartqty"/> <july:stringwrite name="ul" property="shortname"/></td>
		<td class="link"><july:link page="/ShowComplectContentList.do" paramId="resourceset" paramName="resset" paramScope="page" alttext="msg.complectcontent"><bean:message key="label.content"/></july:link></td>
		<td class="link"><july:delbutton page="/EditComplect.do?action=Delete" paramId="resourceset" paramName="resset" paramScope="page"/></td>
	</tr>

<july:separator colspan="<%= gColSpan %>" />

</logic:present>
</logic:iterate>

<tr class="title">
	<td colspan="<%= gColSpan %>">
	<table class="buttons">
	<tr class="title">
		<td class="buttons"><july:addbutton page="/EditComplect.do?action=Add"/><july:backbutton/></td>
		<td class="navigator"><july:navigator/></td>
	</tr>
	</table>
	</td>
</tr>
        
<july:separator colspan="<%= gColSpan %>" />

</table>

</july:browseform>
