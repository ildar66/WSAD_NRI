<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld" prefix="alex" %>
<%@ page import="com.hps.july.basestation.formbean.RepeaterList"%>
<%@ page import="com.hps.july.jdbcpersistence.lib.Checks"%>
<%@ page import="com.hps.july.jdbcpersistence.lib.SearchConstants"%>

<script language="javascript">
function switchAllSearch() {
	if (document.all.item('searchById')[0].checked ) {
		document.all.item('searchstringId').className = 'editdisabled';
		document.all.item('searchstringId').disabled = true;
	} else {
		document.all.item('searchstringId').className = 'editsearch';
		document.all.item('searchstringId').disabled = false;
	}
}
</script>

<%
	String gColSpan = request.getAttribute("colspan") + "";
	RepeaterList lForm = (RepeaterList)request.getAttribute("EquipmentListForm");
%>

<table class="main">
<tr class="normal">
<TD colspan="<%= gColSpan %>">
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
				
	<TR>
		<td class="title"><bean:message key="label.repeaterlist.type"/></td>
		<td class="title" NOWRAP>
			<july:radio styleClass="editcheckbox" property="stationType" value="gsm" onclick="switchAllSearch()" insertable="true" updatable="true"/>
			<bean:message key="label.repeaterlist.search.gsm"/>&nbsp;
			<july:radio styleClass="editcheckbox" property="stationType" value="damps" onclick="switchAllSearch()" insertable="true" updatable="true"/>
			<bean:message key="label.repeaterlist.search.damps"/>
		</td>
	</TR>

	<TR>
		<td class="title"><bean:message key="label.position.searchby"/></td>
		<td class="title">
			<july:radio styleClass="editcheckbox" property="searchBy" styleId="searchById" value="<%= lForm.SEARCH_ALL %>" onclick="switchAllSearch()" insertable="true" updatable="true"/>
			<bean:message key="search.all"/>&nbsp;
			<july:radio styleClass="editcheckbox" property="searchBy" styleId="searchById" value="numberbs" onclick="switchAllSearch();" insertable="true" updatable="true"/>
			<bean:message key="search.bynumberbs"/>&nbsp;
			<july:radio styleClass="editcheckbox" property="searchBy" styleId="searchById" value="namepos" onclick="switchAllSearch()" insertable="true" updatable="true"/>
			<bean:message key="search.bynamepos"/><br>
			<july:radio styleClass="editcheckbox" property="searchBy" styleId="searchById" value="addresspos" onclick="switchAllSearch()" insertable="true" updatable="true"/>
			<bean:message key="search.byaddresspos"/>&nbsp;
			<july:radio styleClass="editcheckbox" property="searchBy" styleId="searchById" value="numbersector" onclick="switchAllSearch()" insertable="true" updatable="true"/>
			<bean:message key="search.bynumbersector"/>
		</td>
	</TR>
			
	<TR>
		<td class="title"><bean:message key="label.position.search.text"/></td>
		<td class="title"><html:text styleClass="search" property="searchString" styleId="searchstringId" size="25"/></td>
	</TR>

	<TR>
		<td class="title"><bean:message key="SwitchList.fields.state"/></td>
		<td class="title">
			<july:select  property="equipmentState" styleId="equipmentStateId"  insertable="true" updatable="true" styleClass="editsmallsearch" style="width:160pt">
				<html:option key="label.all" value="*"/>
				<html:option key="label.baseStationList.state.P" value="P"/>
				<html:option key="label.baseStationList.state.M" value="M"/>
				<html:option key="label.baseStationList.state.R" value="R"/>
				<html:option key="label.baseStationList.state.T" value="T"/>
				<html:option key="label.baseStationList.state.W" value="W"/>
				<html:option key="label.baseStationList.state.D" value="D"/>
			</july:select>
		</td>
	</tr>
	</table>
</TD>
</TR>

<script language="javascript">
	switchAllSearch();
</script>