<%@ page language="java" %>
<%@ page import="org.apache.struts.util.RequestUtils"%>
<%@ page import="com.hps.july.basestation.valueobject.SwitchObject"%>
<%@ page import="com.hps.july.jdbcpersistence.lib.Checks"%>
<%@ page import="com.hps.july.jdbcpersistence.lib.DebugSupport"%>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld" prefix="alex" %>

<SCRIPT language="JavaScript">
<!--
    var retVal;
    function determineMaps() {
		var checkboxs = document.getElementsByTagName('INPUT');
		var positions = "";
		if(checkboxs) {
			for(var i = 0; i < checkboxs.length; i++) {
				var element = checkboxs[i];
				if(element.getAttribute('type') && element.getAttribute('type') == 'checkbox') {
					if(element.getAttribute('name') && element.getAttribute('name') == 'checkEquipment') {
						if(element.getAttribute('checked') && element.getAttribute('checked') == true)
							if(element.getAttribute('regionid') && element.getAttribute('regionid') != '') {
								if(positions != '') positions += ','
								positions += (element.getAttribute('value') + ',' + element.getAttribute('regionid'));
							}
					}
				}
			}
		}
		if(positions == '') {
			alert('Не выбранно ни одной позиции ! ');
			return false;
		}
        var urlShortInfo = ('/siteinfo/dpm?posAndRegs=' + positions);
        retVal = window.open(urlShortInfo, "retVal", "top=200,left=200,width=400,height=400,resizable=0,scrollbars=0,statusbar=0,status=0,toolbar=0");
        if(retVal) retVal.focus();
		return true;
	}

    function showMap(map, region, pos) {
        if(retVal) retVal.close();
        document.location.href= ('/siteinfo/spm?map=' + map + '&supregion=' + region + '&positionid=' + pos);
    }


function checkAll(select, groupId) {
//alert("document.all.item(groupId)="+document.all.item(groupId));
	if(document.all.item(groupId)!=null) {
		document.all.item(groupId).checked=select;
		for(var i=0; i< document.all.item(groupId).length; i++) {
			document.all.item(groupId)[i].checked=select;
		}
	}
}
-->
</SCRIPT>

<%
String gColSpan = request.getAttribute("colspan")+"";
%>
       <!-- Table header -->
<tr class="title">
<td></td>
<july:headercolumn  key="SwitchList.table.number" colType="string"/>
<july:headercolumn  key="SwitchList.table.standart" colType="string"/>
<july:headercolumn  key="SwitchList.table.type" colType="string"/>
<july:headercolumn  key="SwitchList.table.name" colType="string"/>
<july:headercolumn  key="SwitchList.table.address" colType="string"/>
<july:headercolumn  key="SwitchList.table.netzone" colType="string"/>
<TD class="title">
  <bean:message key="SwitchList.table.map"/><br>
  <input type=checkbox class=editcheckbox value='true' name='isAllEquipment' id='isAllEquipmentId' onclick='checkAll(this.checked ,"isEquipmentId" )' />
  <input type=hidden name="checkComline" value=""/>
</TD>
<td></td>
</tr>

<july:separator colspan="<%= gColSpan %>" />
<!-- Table body -->
<%
String editAction=null;
String editFactAction="/EditFactSwitch.do";
String editPlanAction="/EditPlanSwitch.do";
boolean hasRoleFactAccess=false;
boolean hasRolePlanAccess=false;
%>
<alex:hasAccess href="<%=editFactAction%>" >
	<%hasRoleFactAccess=true;%>
</alex:hasAccess>
<alex:hasAccess href="<%=editPlanAction%>" >
	<%hasRolePlanAccess=true;%>
</alex:hasAccess>

<logic:iterate id="obj" name="browseList">
<logic:present name="obj">
<%
boolean canEdit=false;
String action=null;
String alttextKey=null;
SwitchObject ob=(SwitchObject)pageContext.getAttribute("obj");
editAction=editFactAction;
canEdit=hasRoleFactAccess&&ob.isEditRegion();
if(canEdit){
	action="Edit";
	alttextKey="SwitchList.table.alttext.edit";
}else{
	action="View";
	alttextKey="SwitchList.table.alttext.view";
	editAction="/EditSwitch.do";
}
%>

<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
<td>
<july:editbutton page="<%=editAction%>"  action='<%=action%>' paramId="storageplace" paramName="obj" paramProperty="id"/>
</td>
<td class="text">
  <bean:write name="obj" property="number" filter="true"/>
</td>
<td class="text">
  <logic:present name="obj" property="standart">
    <logic:equal name="obj" property="standart" value="1"><bean:message key="switch_type_1"/></logic:equal>
    <logic:equal name="obj" property="standart" value="2"><bean:message key="switch_type_2"/></logic:equal>
  </logic:present>
</td>
<td class="text">
  <bean:write name="obj" property="resourceName" filter="true"/>
</td>
<td class="text">
   <bean:write name="obj" property="name" filter="true"/>
</td>
<td class="text">
   <bean:write name="obj" property="address" filter="true"/>
</td>
<td class="text">
   <bean:write name="obj" property="zonecode" filter="true"/>
</td>
<td class="link">
	<input type="checkbox" name="checkEquipment" value='<%=""+(ob.getPositionId())%>' regionid='<%=""+(ob.getSupreg())%>'  class="editcheckbox" id="isEquipmentId"/>
</td>
<td class="link">
<%if(canEdit){%><july:delbutton page='<%=editAction+"?action=Delete"%>' paramId="storageplace" paramName="obj" paramProperty="id" /><%}%>
</td>
</tr>

<july:separator colspan="<%= gColSpan %>" />
</logic:present>
</logic:iterate>


