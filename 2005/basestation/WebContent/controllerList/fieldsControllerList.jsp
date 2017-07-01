<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld"    prefix="alex" %>
<%@ page import="com.hps.july.basestation.formbean.ControllerListForm"%>
<%@ page import="com.hps.july.jdbcpersistence.lib.Checks"%>
<%@ page import="com.hps.july.jdbcpersistence.lib.SearchConstants"%>
<%@ page import="com.hps.july.basestation.formbean.EquipmentListForm"%>

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
function switchSwitch() {
	if (document.all.isSwitch[0].checked) {
		document.all.switchcode.className = 'editkoddisabled';
		document.all.switchcode.disabled = true;
		document.all['lookupimg_swl'].src='/images/lookup_disabled.gif';
	} else {
		document.all.switchcode.className = 'editkodsearch';
		document.all.switchcode.disabled = false;
		document.all['lookupimg_swl'].src='/images/lookup.gif';
	}
}
</script>

<%
	String gColSpan = request.getAttribute("colspan")+"";
	EquipmentListForm lForm = (EquipmentListForm) pageContext.findAttribute("EquipmentListForm");
//ControllerListForm listForm = (ControllerListForm) request.getSession().getAttribute("ControllerListForm");
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
		<%--jsp:include page="/common/multipleSelect.jsp" flush="true"/--%>
		<tr>
			<td class="title"><bean:message key="label.position.searchby"/></td>
			<td class="title" NOWRAP>
				<july:radio styleClass="editcheckbox" property="searchBy" styleId="searchById" value="<%= SearchConstants.SEARCH_ALL %>" onclick="switchAllSearch()" insertable="true" updatable="true"/>
				<bean:message key="search.all"/>&nbsp;
				<july:radio styleClass="editcheckbox" property="searchBy" styleId="searchById" value="<%= SearchConstants.SEARCHBY_NUMBER %>" onclick="switchAllSearch();document.forms(0).elements('finderMethodName').value = '5';" insertable="true" updatable="true"/>
				<bean:message key="search.byNumber"/>&nbsp;
				<july:radio styleClass="editcheckbox" property="searchBy" styleId="searchById" value="<%= SearchConstants.SEARCHBY_NAME %>" onclick="switchAllSearch()" insertable="true" updatable="true"/>
				<bean:message key="search.byName"/>&nbsp;
				<july:radio styleClass="editcheckbox" property="searchBy" styleId="searchById" value="<%= SearchConstants.SEARCHBY_ADDRESS %>" onclick="switchAllSearch()" insertable="true" updatable="true"/>
				<bean:message key="search.byAddress"/>
			</td>
		</tr>
		<tr>
			<td class="title"><bean:message key="label.position.search.text"/></td>
			<td class="title"><html:text styleClass="search" property="searchString" styleId="searchstringId" size="25"/></td>
		</tr>
		<tr>
			<td class="title"><bean:message key="controllerlist.switch"/></td>
			<td class="title">
				<html:hidden property="switchId"/>
				<july:checkbox property="isSwitch" insertable="true" updatable="true" onclick="switchSwitch()"/>
				<bean:message key="search.all"/>
				<july:string property="switchcodeFrm" styleId="switchcode" size="5" insertable="true" updatable="true"/>
				<july:lookupbutton formname="ControllerListForm" action="/ShowSwitchLookupList.do?type=2" styleId="swl" fieldNames="switchcode;switchname;switchId" insertable="true" updatable="true"/>
				<july:string size="30" property="switchname" styleId="switchname" insertable="false" updatable="false"/>
			</td>
		</tr>
		<tr>
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
	</td>
</tr>
<script language="javascript">
	switchAllSearch();
	switchSwitch();
</script>