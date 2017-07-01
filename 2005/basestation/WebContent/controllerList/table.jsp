<%@ page language = "java" %>
<%@ page import="org.apache.struts.util.RequestUtils"%>
<%@ page import="com.hps.july.basestation.valueobject.ControllerObject"%>
<%@ page import="com.hps.july.jdbcpersistence.lib.Checks"%>
<%@ page import="com.hps.july.jdbcpersistence.lib.DebugSupport"%>
<%@ page import="com.hps.july.basestation.formbean.ControllerListForm"%>
<%@ page import="com.hps.july.basestation.APPStates"%>
<%@ page import="com.hps.july.basestation.formbean.EquipmentListForm"%>
<%@ page import="com.hps.july.apptags.HasAccessTag"%>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld" prefix="alex" %>

<SCRIPT language="JavaScript">

    var retVal;
    function determineMaps(url,user) {
		var checkboxs = document.getElementsByTagName('INPUT');
		var positions = "";
		var isMany = false;
		if(checkboxs) {
			for(var i = 0; i < checkboxs.length; i++) {
				var element = checkboxs[i];
				if(element.getAttribute('type') && element.getAttribute('type') == 'checkbox') {
					if(element.getAttribute('name') && element.getAttribute('name') == 'checkEquipment') {
						if(element.getAttribute('checked') && element.getAttribute('checked') == true){
							
							<%--if(element.getAttribute('regionid') && element.getAttribute('regionid') != '') {
								if(positions != '') positions += ','
								positions += (element.getAttribute('value') + ',' + element.getAttribute('regionid'));
							}--%>

							if(isMany){
								alert('На данный момент функция отображения нескольких контроллеров отключена. Выберите одну контроллер.');
								return false;
							}
							isMany = true;
							positions = '?id='+user+'&type=1&position=' + element.getAttribute('value');
						}
					}
				}
			}
		}

		if(positions == '') {
			alert('Не выбранно ни одной позиции ! ');
			return false;
		}        
		var urlShortInfo = (url + positions);

        retVal = window.open(urlShortInfo, "retVal", "top=10,left=10,width=1000,height=800,resizable=1,scrollbars=1,statusbar=1,status=0,toolbar=0");
        if(retVal) retVal.focus();
		return true;
	}

    function showMap(map, region, pos) {
        if(retVal) retVal.close();
        document.location.href= ('/siteinfo/spm?map=' + map + '&supregion=' + region + '&positionid=' + pos);
    }

function checkAll(select, groupId){
	try {
		document.all.item(groupId).checked = select;
		for(var i = 0; i < document.all.item(groupId).length; i++) {
			document.all.item(groupId)[i].checked = select;
		}
	} catch (exception) {}
}

</SCRIPT>

<%
	String gColSpan = request.getAttribute("colspan") + "";
	System.out.println("BEFORE GET EQUIPLIST");
	EquipmentListForm lForm = (EquipmentListForm)pageContext.findAttribute("EquipmentListForm");
	System.out.println("AFTER GET EQUIPLIST");
%>

<!-- Table header -->
<tr class="title">
	<td>&nbsp;</td>
	<july:headercolumn key="controllerlist.table.number" colType="string"/>
	<july:headercolumn key="controllerlist.table.type" colType="string"/>
	<july:headercolumn key="controllerlist.table.name" colType="string"/>
	<july:headercolumn key="controllerlist.table.address" colType="string"/>
	<july:headercolumn key="controllerlist.table.netzone" colType="string"/>
	<TD class="title">
		<bean:message key="controllerlist.table.map"/><br>
		<INPUT type=checkbox class=editcheckbox value='true' name='isAllEquipment' id='isAllEquipmentId' onclick='checkAll(this.checked ,"isEquipmentId" )'/>
		<input type=hidden name="checkComline" value=""/>
	</TD>
	<td>&nbsp;</td>
</tr>

<july:separator colspan="<%= gColSpan %>"/>
<!-- Table body -->
<%
	int state=(lForm.getState()==APPStates.CONTROLLER_LIST?APPStates.CONTROLLER_EDIT:APPStates.SwitchControllerForm);
	String editAction = null;
	String editViewAction="/EditController.do?state="+state;
	String editFactAction = "/EditFactController.do?state="+state;
	boolean hasRoleFactAccess = HasAccessTag.hasAccess(pageContext,"/EditFactController.do");
%>

<logic:iterate id="obj" name="browseList">
	<logic:present name="obj">
	<%
		boolean canEdit = false;
		String action = null;
		//String alttextKey = null;
		ControllerObject ob = (ControllerObject) pageContext.getAttribute("obj");
		if(lForm.getState() == APPStates.CONTROLLER_LIST) {
			canEdit = hasRoleFactAccess && ob.isEditRegion();
			if(canEdit){
				action="Edit";
				editAction=editFactAction;
			} else {
				action="View";
				editAction=editViewAction;
			}
		} else {
			canEdit = false;
			action = "View";
			editAction = editViewAction;
		}
	%>
		<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
			<td align="center">
				<july:editbutton page="<%= editAction %>" action='<%= action %>' paramId="storageplace" paramName="obj" paramProperty="id"/>
			</td>
			<td class="text">
				<bean:write name="obj" property="number" filter="true"/>
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
				<% if (canEdit&&(lForm.getState()==APPStates.CONTROLLER_LIST)) { %>
					<july:delbutton page='<%= editAction+"&action=Delete" %>' paramId="storageplace" paramName="obj" paramProperty="id"/>
				<% } %>
			</td>
		</tr>
		
		<july:separator colspan="<%= gColSpan %>"/>
		
	</logic:present>
</logic:iterate>
