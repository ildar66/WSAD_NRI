<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld"    prefix="alex" %>
<%@ page import="com.hps.july.basestation.formbean.SwitchListForm"%>
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
	SwitchListForm listForm=(SwitchListForm)pageContext.findAttribute("SwitchListForm");
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
<%--jsp:include page="../common/multipleSelect.jsp"  flush="true" /--%>
<%--искать по .. --%>
<tr>
	<td class="title">
		<bean:message key="label.position.searchby"/>
	</td>
	<td class="title" NOWRAP>
		<july:radio styleClass="editcheckbox" property="searchBy" styleId="searchById" value="<%=listForm.SEARCH_ALL%>" onclick="switchAllSearch()" insertable="true" updatable="true" />
		<bean:message key="search.all"/>&nbsp;
		<july:radio styleClass="editcheckbox" property="searchBy" styleId="searchById" value="<%=listForm.SEARCHBY_NUMBER%>" onclick="switchAllSearch();document.forms(0).elements('finderMethodName').value = '5';" insertable="true" updatable="true" />
		<bean:message key="search.byNumber"/>&nbsp;
		<july:radio styleClass="editcheckbox" property="searchBy" styleId="searchById" value="<%=listForm.SEARCHBY_NAME%>" onclick="switchAllSearch()" insertable="true" updatable="true" />
		<bean:message  key="search.byName"/>&nbsp;
		<july:radio styleClass="editcheckbox" property="searchBy" styleId="searchById" value="<%=listForm.SEARCHBY_ADDRESS%>" onclick="switchAllSearch()" insertable="true" updatable="true" />
		<bean:message  key="search.byAddress"/>
	</td>
</tr>
<tr>
	<td class="title">
		<bean:message key="label.position.search.text"/>
	</td>
	<td class="title">
		<html:text styleClass="search" property="searchString" styleId="searchstringId" size="25"/>
	</td>
</tr>
<tr>
	<td class="title"><bean:message key="SwitchList.fields.state"/></td>
	<td class="title">
		<july:select  property="equipmentState" styleId="equipmentStateId"  insertable="true" updatable="true" styleClass="editsmallsearch" style="width:160pt">
			<html:option key="label.baseStationList.state.P" value="<%=Checks.EQUIPMENT_STATE_PLAN_P%>"/>
			<html:option key="label.baseStationList.state.M" value="<%=Checks.EQUIPMENT_STATE_MOUNT_M%>"/>
			<html:option key="label.baseStationList.state.R" value="<%=Checks.EQUIPMENT_STATE_READY_R%>"/>
			<html:option key="label.baseStationList.state.T" value="<%=Checks.EQUIPMENT_STATE_TEST_T%>"/>
			<html:option key="label.baseStationList.state.W" value="<%=Checks.EQUIPMENT_STATE_WORK_W%>"/>
		</july:select>
	</td>
</tr>
</table>
</td>
</tr>
<script language="javascript">switchAllSearch();</script>
