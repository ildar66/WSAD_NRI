<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld" prefix="alex" %>
<%@ page import="org.apache.struts.util.*"%>
<%@ page import="com.hps.july.basestation.valueobject.BaseStationObject"%>
<%@ page import="com.hps.july.basestation.formbean.*"%>
<%@ page import="com.hps.july.jdbcpersistence.lib.SearchConstants"%>
<%@ page import="com.hps.july.siteinfo.valueobject.Regions"%>

<%
	java.lang.String gColSpan = "11";
//	request.setAttribute("colspan",gColSpan); //для использования во включенных jsp
	BaseStationListForm lForm = (BaseStationListForm)pageContext.findAttribute("BaseStationListForm");
	request.setAttribute("EquipmentListForm",lForm);
//	EquipmentListForm listForm=(EquipmentListForm)pageContext.findAttribute("EquipmentListForm");
	String editAction = "/Edit_AddDeleteFactBaseStation.do";
	String viewAction = "/Edit_ViewFactBaseStation.do";
	String delAction  = editAction + "?action=Delete";
	boolean canEdit = false;	
	String trailcomMapUrl = com.hps.july.util.AppUtils.getNamedValueString("PathMapTrailcom");
	String ruser = request.getRemoteUser();
%>

<july:browseform action="/ShowBaseStationList.do" styleId="PosForm">
<alex:hasAccess href="<%=editAction%>"><%canEdit=true;%></alex:hasAccess>
<table class="main">
<july:separator colspan="<%= gColSpan %>" />

<script language="javascript">
function refreshInputFromCheckbox(selectId,checkboxId,classEnable,classDisable)
{
	if(document.all.item(checkboxId).checked) {
		document.all.item(selectId).disabled = true;
		document.all.item(selectId).className = classDisable;
	} else {
		document.all.item(selectId).className = classEnable;
		document.all.item(selectId).disabled = false;
	}
}

function refreshLookup(disabledstate,codeId,nameId,btnId) {
	document.all[codeId].disabled = disabledstate;
	document.all[codeId].className = (disabledstate?'editkoddisabled':'editkodsearch');
	document.all[nameId].disabled = disabledstate;
	document.all['lookupimg_'+btnId].disabled = disabledstate;
	document.all['lookupimg_'+btnId].src = (disabledstate?'/images/lookup_disabled.gif':'/images/lookup.gif');
}

function switchAllSearch()
{
	if(PosForm.searchBy[0].checked)	{
		PosForm.searchstring.className = 'editdisabled';
		PosForm.searchstring.disabled = true;
	} else {
		PosForm.searchstring.className = 'editsearch';
		PosForm.searchstring.disabled = false;
	}
}

function checkController() {
	var b = document.all.stationType[1].checked || document.all.isAll_Controllers.checked;
	refreshLookup(b,'contrnum','contrname','cntrl');
	document.all.isAll_Controllers.disabled = document.all.stationType[1].checked;
}

function setSwitchLookupParams() {
	var st = '';
	if(document.all.stationType[0].checked) {
		st = '2';
	} else if(document.all.stationType[1].checked) {
		st = '1';
	}
	set_opt_params_switchl('&type='+st);
}

</script>

<tr class="normal">
<td colspan="<%=gColSpan %>">
	<table class="find">
	<%--jsp:include page="/common/multipleSelect.jsp" flush="true" /--%>
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
	<tr>
		<td class="title"><bean:message key="label.baseStationList.type"/>:</td>
		<td class="title" NOWRAP>
			<july:radio styleClass="editcheckbox" property="stationType" value="<%=BaseStationObject.TYPE_SEARCH_GSM%>" onclick="switchAllSearch();checkController();" insertable="true" updatable="true" />
			<bean:message key="label.baseStationList.search.gsm"/>&nbsp;
			<july:radio styleClass="editcheckbox" property="stationType" value="<%=BaseStationObject.TYPE_SEARCH_DAMPS%>" onclick="switchAllSearch();checkController();" insertable="true" updatable="true" />
			<bean:message key="label.baseStationList.search.damps"/>
		</td>
	</tr>
	<tr>
		<td class="title"><bean:message key="label.position.searchby"/>:</td>
		<td class="title" NOWRAP>
			<july:radio styleClass="editcheckbox" property="searchBy" value="<%=BaseStationObject.SEARCH_ALL%>" onclick="switchAllSearch()" insertable="true" updatable="true" />
			<bean:message key="label.search.all"/>&nbsp;
			<july:radio styleClass="editcheckbox" property="searchBy" value="<%=BaseStationObject.SEARCHBY_NUMBER%>" onclick="switchAllSearch()" insertable="true" updatable="true" />
			<bean:message key="label.baseStationList.search.number"/>&nbsp;
			<july:radio styleClass="editcheckbox" property="searchBy" value="<%=BaseStationObject.SEARCHBY_NAME%>" onclick="switchAllSearch()" insertable="true" updatable="true" />
			<bean:message key="label.baseStationList.search.name"/>&nbsp;
			<july:radio styleClass="editcheckbox" property="searchBy" value="<%=BaseStationObject.SEARCHBY_ADDRESS%>" onclick="switchAllSearch()" insertable="true" updatable="true" />
			<bean:message key="label.baseStationList.search.address"/>
			<july:radio styleClass="editcheckbox" property="searchBy" value="prefcellid" onclick="switchAllSearch()" insertable="true" updatable="true" />
			<bean:message key="label.baseStationList.search.prefixcellid"/>
		</td>
	</tr>
	<tr>
		<td class="title"><bean:message key="label.position.search.text"/>:</td>
		<td class="title">
			<html:text styleClass="search" property="searchString" styleId="searchstring" size="25" />
		</td>
	</tr>
	<tr>
		<td class="title"><bean:message key="label.equipment.controller"/>:</td>
		<td class="title">
			<july:checkbox property="isAllControllers" styleId="isAll_Controllers" insertable="true" updatable="true" onclick="refreshLookup(document.all.isAll_Controllers.checked,'contrnum','contrname','cntrl');"/>
			<bean:message key="label.search.all"/>&nbsp;&nbsp;&nbsp;
			<html:hidden property="controllerId"/>
			<july:string property="contrNumberFrm" styleId="contrnum" size="5" insertable="true" updatable="true" />
			<july:lookupbutton action="/ShowControllerLookupList.do" styleId="cntrl" fieldNames="contrnum;contrname;cposname;controllerId" insertable="true" updatable="true" formname="PosForm" />
			<july:string size="25" property="contrname" styleId="contrname"  insertable="false" updatable="false" />
			<input type='hidden' name='contrposname' id='cposname'   value=''>
		</td>
	</tr>
	<tr>
		<td class="title"><bean:message key="label.equipment.switch"/>:</td>
		<td class="title">
			<july:checkbox property="isAllSwitches" styleId="isAll_Switches" insertable="true" updatable="true" onclick="refreshLookup(document.all.isAll_Switches.checked,'switchnum','sname','switchl');"/>
			<bean:message key="label.search.all"/>&nbsp;&nbsp;&nbsp;
			<html:hidden property="switchId"/>
			<july:string property="switchNumberFrm" styleId="switchnum" size="5" insertable="true" updatable="true" />
			<july:lookupbutton action="/ShowSwitchLookupList.do?" styleId="switchl" fieldNames="switchnum;sname;switchId" insertable="true" updatable="true" formname="PosForm" onclick="if(document.all.isAll_Switches.checked) return false; setSwitchLookupParams();"/>
			<july:string size="25" property="switchname" styleId="sname"  insertable="false" updatable="false" />
		</td>
	</tr>
	<tr>
		<td class="title"><bean:message key="label.position.posstate"/>:</td>
		<td class="title">
			<july:select property="equipmentState" styleId="equipmentState" insertable="true" updatable="true" styleClass="editsearch">
				<html:option key="label.all" value="*"/>
				<html:option key="BaseStation.equipmentState.P" value="<%=BaseStationObject.STATE_CHECK_PLAN_P%>"/>
				<html:option key="BaseStation.equipmentState.M" value="<%=BaseStationObject.STATE_CHECK_MOUNT_M%>"/>
				<html:option key="BaseStation.equipmentState.R" value="<%=BaseStationObject.STATE_CHECK_READY_R%>"/>
				<html:option key="BaseStation.equipmentState.T" value="<%=BaseStationObject.STATE_CHECK_TEST_T%>"/>
				<html:option key="BaseStation.equipmentState.W" value="<%=BaseStationObject.STATE_CHECK_WORK_W%>"/>
				<html:option key="BaseStation.equipmentState.D" value="<%=BaseStationObject.STATE_CHECK_DEMOUNT_D%>"/>
			</july:select>
		</td>
	</tr>
	<tr>
		<td class="title"><bean:message key="label.baseStationList.onair"/>:</td>
		<td class="title">
			<july:radio styleId="onair" property="onair" value="<%=BaseStationObject.SEARCH_ALL%>" insertable="true" updatable="true" styleClass="editcheckbox"/>
			<bean:message key="label.position.search.all"/>&nbsp;&nbsp;&nbsp;
			<july:radio styleId="onair" property="onair" value="<%=BaseStationObject.ONAIR_CHECK_Y%>" insertable="true" updatable="true" styleClass="editcheckbox"/>
			<bean:message key="label.baseStationList.onair.Y"/>&nbsp;&nbsp;&nbsp;
			<july:radio styleId="onair" property="onair" value="<%=BaseStationObject.ONAIR_CHECK_N%>" insertable="true" updatable="true" styleClass="editcheckbox"/>
			<bean:message key="label.baseStationList.onair.N"/>
		</td>
	</tr>
	</table>
	<script language="javascript">
		switchAllSearch();
		refreshLookup(document.all.isAll_Controllers.checked,'contrnum','contrname','cntrl');
		refreshLookup(document.all.isAll_Switches.checked,'switchnum','sname','switchl');
		checkController();
	</script>
</td>
</tr>
<july:separator colspan="<%= gColSpan %>" />
<tr class="title">
	<td colspan="<%= gColSpan %>">
		<table class="buttons">
		<tr class="title">
			<td class="buttons">
				<alex:hasAccess href="<%= editAction %>">
					<html:link page='<%= editAction+"?action=Add" %>'>
						<img alt='<bean:message key="label.baseStationList.add.fact"/>' src="/images/plus.gif" border=0>
					</html:link>
				</alex:hasAccess>
        			<img alt="" src="/images/empty.gif" width=3 border=0>
				<july:backbutton page="/main.do"/>
				<img alt="" src="/images/empty.gif" width=3 border=0>
				<image name="onMap" src="/images/map.gif" alt='<bean:message key="SwitchList.buttons.map"/>'  onclick='determineMaps("<%=trailcomMapUrl%>","<%=ruser%>");' />
			</td>
			<td class="navigator"><july:navigator/></td>
		</tr>
		</table>
	</td>
</tr>
<july:separator colspan="<%= gColSpan %>" />

<script language="JavaScript">

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
								alert('На данный момент функция отображения нескольких базовых станций отключена. Выберите одну базовую станцию.');
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


function checkAll(select, groupId) {
	//alert("document.all.item(groupId)="+document.all.item(groupId));
	if(document.all.item(groupId)!=null) {
		document.all.item(groupId).checked=select;
		for(var i=0; i< document.all.item(groupId).length; i++){
			document.all.item(groupId)[i].checked=select;
		}
	}
}

</script>

<%-- Table header --%>
<tr class="title">
	<td></td>
	<july:sortcolumn key="label.baseStationList.number" colType="string" ascFinder="1" descFinder="2"/>
	<td class="title">prefCI</td>
	<july:headercolumn key="label.baseStationList.type" colType="string"/>
	<july:sortcolumn key="label.baseStationList.name" colType="string"ascFinder="3" descFinder="4"/>
	<july:headercolumn key="label.baseStationList.address" colType="string"/>
	<july:headercolumn key="label.baseStationList.netzone" colType="string"/>
	<july:headercolumn key="label.positionList.posstate" colType="string"/>
	<july:headercolumn key="label.baseStationList.onair" colType="string"/>
	<td class="title"><bean:message key="SwitchList.table.map"/><br><input type=checkbox class=editcheckbox value='true' name='isAllEquipment' id='isAllEquipmentId' onclick='checkAll(this.checked ,"isEquipmentId" )' /><input type=hidden name="checkComline" value=""/></td>
	<td></td>
</tr>

<july:separator colspan="<%= gColSpan %>" />

<!-- Table body -->
<logic:iterate id="bs" name="browseList" type="com.hps.july.cdbc.lib.CDBCRowObject">
<logic:present name="bs">
<%
//	BaseStationObject baseStation=(BaseStationObject)pageContext.getAttribute("bs");
//	if(baseStation.isView()) {
//		canEdit = canEdit && baseStation.isEditFact();
	String equipment = bs.getColumn("equipment").asString();
	pageContext.setAttribute("bs_equipment",equipment);
	String positionid = bs.getColumn("positionid").asString();
	canEdit = "Y".equals(bs.getColumn("edit").asString());
	String equstate = bs.getColumn("bsstate").asString();
	if(equstate == null || "".equals(equstate)) {
		equstate = "unknown";
	} else {
		equstate = equstate.toLowerCase();
	}
	String supreg = bs.getColumn("supreg").asString();
	if(supreg == null) supreg = "";
%>
<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
	<td>
		<july:editbutton page="<%=viewAction%>" action="View" paramId="basestation" paramName="bs_equipment" alttext="button.view.basestation"/>
	</td>
	<td class="number"><july:stringwrite name="bs" property="number"/></td>
	<td class="text"><july:stringwrite name="bs" property="prefixcellid"/></td>
	<td class="text"><july:stringwrite name="bs" property="type"/></td>
	<td class="text"><july:stringwrite name="bs" property="name"/></td>
	<td class="text"><july:stringwrite name="bs" property="address"/></td>
	<td class="text"><july:stringwrite name="bs" property="zonecode"/></td>
	<td class="text"><bean:message key='<%="label.equipment.state"+equstate%>'/></td>
	<td class="text"><%if("Y".equals(bs.getColumn("onair").asString())){%><bean:message key="BaseStation.onair.show"/><%}%></td>
	<td class="link">
		<input type="checkbox" name="checkEquipment" value='<%=positionid%>' regionid='<%=supreg%>'  class="editcheckbox" id="isEquipmentId"/>
	</td>
	<td class="link"><%if(canEdit) {%><july:delbutton page="<%=delAction%>" paramId="basestation" paramName="bs_equipment" paramScope="page"/><%}%></td>
</tr>
<july:separator colspan="<%= gColSpan %>" />
<%
//	}
%>
</logic:present>
</logic:iterate>
<tr class="title">
	<td colspan="<%= gColSpan %>">
		<table class="buttons">
		<tr class="title">
			<td class="buttons">
				<alex:hasAccess href="<%= editAction %>">
					<html:link page='<%= editAction+"?action=Add" %>'>
						<img alt='<bean:message key="label.baseStationList.add.fact"/>' src="/images/plus.gif" border=0>
					</html:link>
				</alex:hasAccess>
				<img alt="" src="/images/empty.gif" width=3 border=0>
				<july:backbutton page="/main.do"/>
				<img alt="" src="/images/empty.gif" width=3 border=0>
				<image name="onMap" src="/images/map.gif" alt='<bean:message key="SwitchList.buttons.map"/>' onclick='determineMaps("<%=trailcomMapUrl%>","<%=ruser%>");' />
			</td>
			<td class="navigator"><july:navigator/></td>
		</tr>
		</table>
	</td>
</tr>
<july:separator colspan="<%= gColSpan %>" />
</table>
</july:browseform>
