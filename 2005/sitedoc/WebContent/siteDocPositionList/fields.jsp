<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<%@ page import="com.hps.july.sitedoc.formbean.SiteDocPositionListForm"%>
<%@ page import="com.hps.july.jdbcpersistence.lib.Checks"%>

<script language="javascript">
function switchAllSearch() {
	if(PosForm.searchBy.value=="A" ||
	   PosForm.searchBy.value=="F" ||
	   PosForm.searchBy.value=="G" ||
	   PosForm.searchBy.value=="H" ||
	   PosForm.searchBy.value=="K" ||
	   PosForm.searchBy.value=="L" ||
	   PosForm.searchBy.value=="M" 
	) {
		  PosForm.searchString.className = 'editdisabled';
		  PosForm.searchString.disabled = true;
	} else {
		PosForm.searchString.className = 'editsearch';
		PosForm.searchString.disabled = false;
	}
}
</script>


<%
	String gColSpan = String.valueOf(request.getAttribute("colspan"));
//	SiteDocPositionListForm pForm=(SiteDocPositionListForm)pageContext.findAttribute("SiteDocPositionListForm");
%>

<tr class="normal">
<TD colspan="<%= gColSpan %>">
<table class="find">
	<TR class='normal'>
		<td colspan="2">
		<table border=0 width="100%" cellpadding=0 cellspacing=0>
		<tr>
			<td><jsp:include page="/common/regionsselect.jsp" flush="true" /></td>
			<td><july:searchbutton/></td>
		</tr>
		</table>
		</td>
	</TR>
	<TR>
		<td class="title"><bean:message key="label.position.searchby"/></td>
		<td class="title">
			<july:select property="searchBy" styleClass="editsearch" onchange="switchAllSearch();" insertable="true" updatable="true">
				<html:option value="A"><bean:message key="label.position.search.all"/></html:option>
				<html:option value="F"><bean:message key="label.position.search.bsgsm"/></html:option>
				<html:option value="G"><bean:message key="label.position.search.bsdamps"/></html:option>
				<html:option value="H"><bean:message key="label.position.search.nobs"/></html:option>
				<html:option value="B"><bean:message key="label.position.search.gsmid"/></html:option>
				<html:option value="C"><bean:message key="label.position.search.dampsid"/></html:option>
				<html:option value="D"><bean:message key="label.position.search.name"/></html:option>
				<html:option value="E"><bean:message key="label.position.search.addr"/></html:option>
				<html:option value="I"><bean:message key="label.position.search.trid"/></html:option>
				<html:option value="K"><bean:message key="label.position.search.trall"/></html:option>
				<html:option value="L"><bean:message key="label.position.search.trrrl"/></html:option>
				<html:option value="M"><bean:message key="label.position.search.trvot"/></html:option>
			</july:select>&nbsp;&nbsp;
			<bean:message key="label.position.search.text"/>&nbsp;<html:text styleClass="search" property="searchString" styleId="editsearch" size="25" />
		</td>
	</TR>
	<TR>
		<td class="title"><bean:message key="label.position.posstate"/></td>
		<td class="title" colspan='3'>
			<july:select property="posstate" styleClass="editsearch" style="width: 450px;" insertable="true" updatable="true">
				<html:option value="PE"><bean:message key="posstate.pe"/></html:option>
				<html:option value="P"><bean:message key="posstate.p"/></html:option>
				<html:option value="E"><bean:message key="posstate.e"/></html:option>
				<html:option value="D"><bean:message key="posstate.d"/></html:option>
			</july:select>
		</td>
	</TR>
</table>
</TD>
</TR>
<script language="javascript">switchAllSearch();</script>
