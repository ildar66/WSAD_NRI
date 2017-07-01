<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld"    prefix="alex" %>
<%@ page import="com.hps.july.basestation.formbean.ComlineListForm"%>
<%@ page import="com.hps.july.jdbcpersistence.lib.Checks"%>
<%@ page import="com.hps.july.jdbcpersistence.lib.SearchConstants"%>

<script language="javascript">
function switchAllSearch() {
//switchInputField('searchstringId',!document.all.item('searchBy')[0].checked);
	if(document.all.item('searchById')[0].checked ) {
		document.all.item('searchstringId').className = 'editdisabled';
		document.all.item('searchstringId').disabled = true;
	} else {
		document.all.item('searchstringId').className = 'editsearch';
		document.all.item('searchstringId').disabled = false;
	}
}

</script>

<%
	String gColSpan = request.getAttribute("colspan")+"";
	ComlineListForm listForm=(ComlineListForm)pageContext.findAttribute("EquipmentListForm");
%>

<tr class="normal">
<td colspan="<%= gColSpan %>">
<table class="find">
<tr>
	<td class="title" colspan="2">
	<table border=0 width="100%" cellpadding=0 cellspacing=0>
	<tr>
		<td><jsp:include page="/common/regionsselect.jsp" flush="true" /></td>
		<td><july:searchbutton/></td>
	</tr>
	</table>
	</td>
</tr>
<%--jsp:include page="/common/multipleSelect.jsp"  flush="true" /--%>
<%--искать по .. --%>
<tr>
	<td class="title"><bean:message key="label.position.searchby"/></td>
	<td class="title" NOWRAP>
		<july:radio styleClass="editcheckbox" property="searchBy" styleId="searchById" value="<%=listForm.SEARCH_ALL%>" onclick="switchAllSearch()" insertable="true" updatable="true" />
		<bean:message key="search.all"/>
		&nbsp;
		<july:radio styleClass="editcheckbox" property="searchBy" styleId="searchById" value="<%=listForm.SEARCHBY_HOPSNAME%>" onclick="switchAllSearch()" insertable="true" updatable="true" />
		<bean:message  key="search.byHopsName"/>
		&nbsp;
		<july:radio styleClass="editcheckbox" property="searchBy" styleId="searchById" value="<%=listForm.SEARCHBY_NAME%>" onclick="switchAllSearch()" insertable="true" updatable="true" />
		<bean:message  key="search.byName"/>
		&nbsp;
		<july:radio styleClass="editcheckbox" property="searchBy" styleId="searchById" value="<%=listForm.SEARCHBY_ADDRESS%>" onclick="switchAllSearch()" insertable="true" updatable="true" />
		<bean:message  key="search.byAddress"/>
		<br>
		<july:radio styleClass="editcheckbox" property="searchBy" styleId="searchById" value="<%=listForm.SEARCHBY_GSMNUMBER%>" onclick="switchAllSearch();document.forms(0).elements('finderMethodName').value = '5';" insertable="true" updatable="true" />
		<bean:message key="search.byGsmNumber"/>
		&nbsp;
		<july:radio styleClass="editcheckbox" property="searchBy" styleId="searchById" value="<%=listForm.SEARCHBY_DAMPSNUMBER%>" onclick="switchAllSearch();document.forms(0).elements('finderMethodName').value = '5';" insertable="true" updatable="true" />
		<bean:message key="search.byDampsNumber"/>
		&nbsp;
		<july:radio styleClass="editcheckbox" property="searchBy" styleId="searchById" value="<%=listForm.SEARCHBY_BEENETID%>" onclick="switchAllSearch();" insertable="true" updatable="true" />
		<bean:message key="ComlineList.beenetsearch"/>
	</td>
</tr>
<tr>
	<td class="title"><bean:message key="label.position.search.text"/></td>
	<td class="title" colspan='3'>
		<html:text styleClass="search" property="searchString" styleId="searchstringId" size="25" />
	</td>
</tr>
<tr>
	<td class="title"><bean:message key="ComlineList.state"/></td>
	<td class="title" colspan='3'>
		<july:select property="comlinestate" insertable="true" updatable="true" styleClass="search">
			<html:option key="ComlineList.state.all" value="*"/>
			<html:option key="ComlineForm.state.A" value="A"/>
			<html:option key="ComlineForm.state.B" value="B"/>
			<html:option key="ComlineForm.state.C" value="C"/>
			<html:option key="ComlineForm.state.D" value="D"/>
		</july:select>
	</td>
</tr>
</table>
</td>
</tr>
<script language="javascript">switchAllSearch();</script>
