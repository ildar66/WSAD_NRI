<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld" prefix="alex" %>
<%@ page import="com.hps.july.siteinfo.valueobject.SuperRegionObject"%>
<%@ page import="com.hps.july.siteinfo.valueobject.RegionObject"%>
<%@ page import="com.hps.july.siteinfo.valueobject.Position"%>
<%@ page import="com.hps.july.sitedoc.formbean.SiteDocComlineListForm"%>
<%@ page import="com.hps.july.sitedoc.valueobject.EquipmentObject"%>
<%@ page import="com.hps.july.jdbcpersistence.lib.Checks"%>

<script language="javascript">
function switchAllSearch() {
	if(EquipmentForm.searchBy [0].checked ) {
		EquipmentForm.searchstring.className = 'editdisabled';
		EquipmentForm.searchstring.disabled = true;
	} else {
		EquipmentForm.searchstring.className = 'editsearch';
		EquipmentForm.searchstring.disabled = false;
	}
}

function synchrInputGroup(controlId, groupId){
if(document.all.item(controlId).checked){
   for(var i=0; i< document.all.item(groupId).length; i++){
              document.all.item(groupId)[i].checked=true;
              document.all.item(groupId)[i].disabled=true;
   }
}else{
  for(var i=0; i< document.all.item(groupId).length; i++){
              document.all.item(groupId)[i].checked=false;
              document.all.item(groupId)[i].disabled=false;
  }
}
}
</script>

<%
String gColSpan = request.getAttribute("colspan")+"";
SiteDocComlineListForm eForm=(SiteDocComlineListForm)pageContext.findAttribute("SiteDocComlineListForm");
%>

<tr class="normal">
<td colspan="<%= gColSpan %>">
<table class="find">
<tr class='normal'>
	<td colspan="2">
	<table border=0 width="100%" cellpadding=0 cellspacing=0>
	<tr>
		<td><jsp:include page="/common/regionsselect.jsp" flush="true" /></td>
		<td><july:searchbutton/></td>
	</tr>
	</table>
	</td>
</tr>
<%--искать по .. --%>
<tr>
	<td class="title"><bean:message bundle="siteinfoResources"  key="label.position.searchby"/></td>
	<td class="title">
		<july:radio styleClass="editcheckbox" property="searchBy" value="<%=EquipmentObject.SEARCH_ALL%>" onclick="switchAllSearch()" insertable="true" updatable="true" />
		<bean:message key="search.all"/>
		&nbsp;
		<july:radio styleClass="editcheckbox" property="searchBy" value="<%=EquipmentObject.SEARCHBY_NUMBER%>" onclick="switchAllSearch();document.forms(0).elements('finderMethodName').value = '5';" insertable="true" updatable="true" />
		<bean:message key="search.byNumber"/>
		&nbsp;
		<july:radio styleClass="editcheckbox" property="searchBy" value="<%=EquipmentObject.SEARCHBY_NAME%>" onclick="switchAllSearch()" insertable="true" updatable="true" />
		<bean:message  key="search.byName"/>
		&nbsp;
		<july:radio styleClass="editcheckbox" property="searchBy" value="<%=EquipmentObject.SEARCHBY_ADDRESS%>" onclick="switchAllSearch()" insertable="true" updatable="true" />
		<bean:message  key="search.byAddress"/>
	</td>
</tr>
<tr>
	<td class="title"><bean:message bundle="siteinfoResources"  key="label.position.search.text"/></td>
	<td class="title">
		<html:text styleClass="search" property="searchString" styleId="searchstring" size="25"/>
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
