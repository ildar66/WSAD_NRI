<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import="com.hps.july.sitedoc.formbean.SiteDocPositionListForm"%>
<%@ page import="com.hps.july.sitedoc.formbean.SiteDocEquipmentListForm"%>
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


<% String gColSpan = request.getAttribute("colspan")+"";
SiteDocEquipmentListForm eForm=(SiteDocEquipmentListForm)pageContext.findAttribute("SiteDocEquipmentListForm");
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
<%--тип объекта .. --%>
<tr>
	<td class="title"><bean:message key="SiteDocEquipmentList.objectType"/></td>
	<td class="title" nowrap>
		<july:checkbox styleClass="editcheckbox" property="isAllObjectTypes" styleId="isAllObjectTypesId" onclick="synchrInputGroup('isAllObjectTypesId', 'objectTypesId')" insertable="true" updatable="true" />
		<bean:message key="search.all"/>&nbsp;
		<july:checkbox styleClass="editcheckbox" property="objectTypes" styleId="objectTypesId" value="<%=EquipmentObject.OBJECT_BS_GSM%>" insertable="true" updatable="true" />
		<bean:message key="search.bs.gsm"/>&nbsp;
		<july:checkbox styleClass="editcheckbox" property="objectTypes" styleId="objectTypesId" value="<%=EquipmentObject.OBJECT_BS_DAMPS%>"  insertable="true" updatable="true" />
		<bean:message  key="search.bs.damps"/>&nbsp;
		<july:checkbox styleClass="editcheckbox" property="objectTypes" styleId="objectTypesId" value="<%=EquipmentObject.OBJECT_Controller%>"  insertable="true" updatable="true" />
		<bean:message  key="search.controllers"/>&nbsp;
		<july:checkbox styleClass="editcheckbox" property="objectTypes" styleId="objectTypesId" value="<%=EquipmentObject.OBJECT_Switch%>"  insertable="true" updatable="true" />
		<bean:message  key="search.switches"/>&nbsp;
		<july:checkbox styleClass="editcheckbox" property="objectTypes" styleId="objectTypesId" value="<%=EquipmentObject.OBJECT_Repeater%>"  insertable="true" updatable="true" />
		<bean:message  key="search.repeaters"/>
	</td>
</tr>
<tr>
	<td class="title">&nbsp;</td>
	<td class="title" nowrap>
		<july:checkbox styleClass="editcheckbox" property="objectTypes" styleId="objectTypesId" value="<%=EquipmentObject.OBJECT_ComEquipment_Radio%>"  insertable="true" updatable="true" />
		<bean:message  key="search.comequipment.r"/>&nbsp;
		<july:checkbox styleClass="editcheckbox" property="objectTypes" styleId="objectTypesId" value="<%=EquipmentObject.OBJECT_ComEquipment_Optic%>"  insertable="true" updatable="true" />
		<bean:message  key="search.comequipment.o"/>&nbsp;
		<july:checkbox styleClass="editcheckbox" property="objectTypes" styleId="objectTypesId" value="<%=EquipmentObject.OBJECT_ComEquipment_Other%>"  insertable="true" updatable="true" />
		<bean:message  key="search.comequipment.a"/>
	</td>
</tr>
<tr>
	<td class="title">&nbsp;</td>
	<td class="title" nowrap>
		<july:checkbox styleClass="editcheckbox" property="objectTypes" styleId="objectTypesId" value="<%=EquipmentObject.OBJECT_OtherEquipment%>" insertable="true" updatable="true" />
		<bean:message  key="search.otherequipment"/>
	</td>
</tr>
<%--искать по .. --%>
<tr>
	<td class="title"><bean:message bundle="siteinfoResources"  key="label.position.searchby"/></td>
	<td class="title" nowrap>
		<july:radio styleClass="editcheckbox" property="searchBy" value="<%=EquipmentObject.SEARCH_ALL%>" onclick="switchAllSearch()" insertable="true" updatable="true" />
		<bean:message key="search.all"/>&nbsp;
		<july:radio styleClass="editcheckbox" property="searchBy" value="<%=EquipmentObject.SEARCHBY_NUMBER%>" onclick="switchAllSearch();document.forms(0).elements('finderMethodName').value = '5';" insertable="true" updatable="true" />
		<bean:message key="search.byNumber"/>&nbsp;
		<july:radio styleClass="editcheckbox" property="searchBy" value="<%=EquipmentObject.SEARCHBY_NAME%>" onclick="switchAllSearch()" insertable="true" updatable="true" />
		<bean:message  key="search.byName"/>&nbsp;
		<july:radio styleClass="editcheckbox" property="searchBy" value="<%=EquipmentObject.SEARCHBY_ADDRESS%>" onclick="switchAllSearch()" insertable="true" updatable="true" />
		<bean:message  key="search.byAddress"/>
	</td>
</tr>
<tr>
	<td class="title"><bean:message bundle="siteinfoResources"  key="label.position.search.text"/></td>
	<td class="title">
		<html:text styleClass="search" property="searchString" styleId="searchstring" size="25" />
	</td>
</tr>
</table>
</td>
</tr>

<script language="javascript">
if(document.all.item('isAllObjectTypesId').checked){
synchrInputGroup('isAllObjectTypesId', 'objectTypesId');
 }
  switchAllSearch();
</script>
