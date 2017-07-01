<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import="org.apache.struts.util.*"%>
<%@ page import="com.hps.july.basestation.formbean.*"%>
<%@ page import="com.hps.july.siteinfo.valueobject.Regions"%>

<%
	java.lang.String gColSpan = "8";
	RRLDocsListForm lForm = (RRLDocsListForm)pageContext.findAttribute("RRLDocsListForm");
%>

<july:browseform action="/ShowRRLDocList.do" styleId="RRLDocsList">
<script language="javascript">
function refreshLookup(disabledstate,codeId,btnId) {
	document.all[codeId].disabled = disabledstate;
	document.all[codeId].className = (disabledstate?'editkoddisabled':'editkodsearch');
	document.all['lookupimg_'+btnId].disabled = disabledstate;
	document.all['lookupimg_'+btnId].src = (disabledstate?'/images/lookup_disabled.gif':'/images/lookup.gif');
}
function checkNumber() {
	if(document.all.bynumber[0].checked) {
		document.all['number'].className = 'editsearch';
		document.all['number'].disabled = false;
	} else {
		document.all['number'].className = 'editdisabled';
		document.all['number'].disabled = true;
	}
}
function checkResource() {
	refreshLookup(!document.all.byresource[0].checked,'resourcecode','resl');
}
function checkOrg() {
	refreshLookup(!document.all.byorg[0].checked,'orgcode','rentl');
}
function checkDate() {
	document.all.date_dt.Enabled = document.all.bydate[0].checked;
}
</script>
<table class="main">
<july:separator colspan="<%= gColSpan %>" />
<tr class="normal">
<td colspan="<%=gColSpan %>">
	<table class="find">
	</tr>
	<tr>
		<td class="title" NOWRAP>
			<july:checkbox property="byactivity" insertable="true" updatable="true"/>
			<bean:message key="label.rrldocs.filter.active"/>
		</td>
		<td class="title" align="right"><july:searchbutton/></td>
	</tr>
	<tr>
		<td class="title" colspan='2' NOWRAP>
			<july:checkbox property="bynumber" insertable="true" updatable="true" onclick="checkNumber();"/>
			<bean:message key="label.rrldocs.filter.number"/>&nbsp;
			<html:text styleClass="search" property="number" styleId="" size="25" />
		</td>
	</tr>
	<tr>
		<td class="title" colspan='2' NOWRAP>
			<july:checkbox property="byresource" insertable="true" updatable="true" onclick="checkResource();"/>
			<bean:message key="label.rrldocs.filter.resource"/>&nbsp;
			<july:string size="5" property="resource.string" styleId="resourcecode" insertable="true" updatable="false" styleClass="editkodsearch"/>
			<july:lookupbutton action="/../inventory/ShowResourceLookupList.do" styleId="resl" fieldNames="resourcecode;resourcemodel;resourcename" newWindowName="resourcelookup" insertable="true" updatable="true"/>
			<july:string size="25" property="resourcename" styleId="resourcename" insertable="false" updatable="false" />
			<july:string size="20" property="resourcemodel" styleId="resourcemodel" insertable="false" updatable="false" />
		</td>
	</tr>
	<tr>
		<td class="title" colspan='2'>
			<july:checkbox property="bydate" insertable="true" updatable="true" onclick="checkDate();"/>
			<bean:message key="label.rrldocs.filter.date"/>&nbsp;
			<july:date property="date.string" size="25" insertable="true" updatable="true" styleId="date"/>
		</td>
	</tr>
	<tr>
		<td class="text" colspan='2'>
			<july:checkbox property="byorg" insertable="true" updatable="true" onclick="checkOrg();"/>
			<bean:message key="label.rrldocs.filter.orgname"/>&nbsp;
			<july:string property="org.string" styleId="orgcode" size="5" insertable="true" updatable="true" styleClass="editkodsearch"/>
			<july:lookupbutton action="/../inventory/ShowOrganizationLookupList.do" styleId="rentl" fieldNames="orgcode;orgname" newWindowName="organizationlookup"  insertable="true" updatable="true" onclick="set_opt_params_rentl('?selisprovider=false&selisrenter=false&selissupplier=true');"/>
			<july:string size="35" property="orgname" styleId="orgname" insertable="false" updatable="false" />
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
			<td class="buttons">
				<html:link page='/EditRRLDoc.do?action=Add'><IMG alt='<bean:message key="label.rrldocs.add"/>' src="/images/plus.gif" border="0"></html:link>
        			<img alt="" src="/images/empty.gif" width=3 border=0>
				<july:backbutton page="/main.do"/>
			</td>
			<td class="navigator"><july:navigator/></td>
		</tr>
		</table>
	</td>
</tr>
<july:separator colspan="<%= gColSpan %>" />

<%-- Table header --%>
<tr class="title">
	<td></td>
	<july:sortcolumn key="label.rrldocs.table.number" colType="string" ascFinder="1" descFinder="2"/>
	<july:sortcolumn key="label.rrldocs.table.date" colType="string" ascFinder="3" descFinder="4"/>
	<july:headercolumn key="label.rrldocs.table.expiredate" colType="string"/>
	<july:headercolumn key="label.rrldocs.table.orgname" colType="string"/>
	<july:headercolumn key="label.rrldocs.table.resources" colType="string"/>
	<td></td>
	<td></td>
</tr>

<july:separator colspan="<%= gColSpan %>" />

<!-- Table body -->
<logic:iterate id="doc" name="browseList" type="com.hps.july.cdbc.lib.CDBCRowObject">
<logic:present name="doc">
<%
	String sitedoc = doc.getColumn("sitedoc").asString();
	pageContext.setAttribute("sitedoc",sitedoc);
	String nClass = "expired";
	Object expo = doc.getColumn("expiredate").asObject();
	if(expo != null && expo instanceof java.sql.Date) {
		if(DocForm.isExpired((java.sql.Date)expo)) {
			nClass = "normal";
		}
	}
	String res = lForm.getDocumentResources(sitedoc);
%>
<tr class="<%=nClass%>" onMouseOver="className='select';" onMouseOut="className='<%=nClass%>';">
	<td class="link" align="middle"><july:editbutton page="/EditRRLDoc.do" action="Edit" paramId="sitedoc" paramName="sitedoc" alttext="label.rrldocs.edit"/></td>
	<td class="number"><july:stringwrite name="doc" property="blanknumber"/></td>
	<td class="text"><july:datewrite name="doc" property="blankdate"/></td>
	<td class="text"><july:datewrite name="doc" property="expiredate"/></td>
	<td class="text"><july:stringwrite name="doc" property="orgname"/></td>
	<td class="text"><%=res%></td>
	<td class="link" align="middle">
		<july:link page="/ShowDocFilesList.do" paramId="sitedoc" paramName="sitedoc" paramScope="page">
			<img src="/images/dochist.gif" border=0 alt='<bean:message key="label.rrl.form.filelist"/>'>
		</july:link>
	</td>
	<td class="link"><july:delbutton page="/EditRRLDoc.do?action=Delete" paramId="sitedoc" paramName="sitedoc" paramScope="page"/></td>
</tr>
<july:separator colspan="<%= gColSpan %>"/>
</logic:present>
</logic:iterate>

<tr class="title">
	<td colspan="<%= gColSpan %>">
		<table class="buttons">
		<tr class="title">
			<td class="buttons">
				<html:link page='/EditRRLDoc.do?action=Add'><IMG alt='<bean:message key="label.rrldocs.add"/>' src="/images/plus.gif" border="0"></html:link>
				<img alt="" src="/images/empty.gif" width=3 border=0>
				<july:backbutton page="/main.do"/>
			</td>
			<td class="navigator"><july:navigator/></td>
		</tr>
		</table>
	</td>
</tr>
<july:separator colspan="<%= gColSpan %>" />
</table>
<script language="javascript">
	checkNumber();
	checkResource();
	checkDate();
	checkOrg();
</script>
</july:browseform>
