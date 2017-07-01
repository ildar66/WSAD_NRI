<%@ page language = "java" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.siteinfo.*,com.hps.july.siteinfo.valueobject.Position" %>
<%@ page import="com.hps.july.siteinfo.formbean.PositionForm" %>
<%@ page import="com.hps.july.persistence.*" %>
<%@ page import="com.hps.july.siteinfo.valueobject.EquipmentObject" %>
<%@ page import="org.apache.struts.util.MessageResources" %>
<%@ page import="com.hps.july.jdbcpersistence.lib.*,com.hps.july.constants.*" %>
<%@ page import="com.hps.july.siteinfo.formbean.EquipmentListForm" %>

<%@ page import="com.hps.july.cdbc.lib.CDBCRowObject" %>
<%@ page import="com.hps.july.taglib.RolesValidation" %>

<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld" prefix="alex" %>

<%
	com.hps.july.jdbcpersistence.lib.TimeCounter ts = new com.hps.july.jdbcpersistence.lib.TimeCounter("PERF.SITEINFO.EquipmentList");
	ts.start();
%>

<%
//StateManager sm=(StateManager)session.getAttribute(AppConstants.PARAM_STATE_MANAGER);
String stateParams=""; //"&"+sm.getParameterString();
if(application.getAttribute("bsResources")==null)
{
	application.setAttribute("bsResources", MessageResources.getMessageResources("com.hps.july.basestation.ApplicationResources"));
}
%>

<%
	java.lang.String gColSpan = "12";
	PositionForm posForm = (PositionForm)pageContext.findAttribute("PositionForm");
	boolean hasRegionAccess = posForm.hasRegionEditAccess(request);
	DebugSupport.println("equipmentList.jsp hasRegionAccess="+hasRegionAccess);
	String viewAction=null;
	String viewActionCheck=null;
	String web_basestation="/WEB-INF/web_basestation.xml";
	String positionkey = posForm.getStorageplaceFrm();
%>

<july:browseform action="/ShowEquipmentList.do">

<script language="javascript">
var allequipchecked = false;
function selectAllEquipment() {
	var i = 0;
	allequipchecked = !allequipchecked;
	while(document.all.equiplist[i]) {
		document.all.equiplist[i].checked = allequipchecked;
		i++;
	}
}

function updateActionForMulti() {
	var b = false;
	var i = 0;
	while(document.all.equiplist[i]) {
		if(document.all.equiplist[i].checked) b = true;
		i++;
	}
	if(b) {
		document.forms[0].action = '/siteinfo/ShowEquipdetMultiList.do?position=<%=positionkey%>';
	} else {
		alert('Для просмотра состава оборудования необходимо отметить хотя бы одну строку из списка!');
	}
	return b;
}
</script>

<table class="main">

<july:separator colspan="<%= gColSpan %>" />

<tr class="normal">
	<td colspan="<%= gColSpan %>">
	<table class="find">
	<tr>
		<td class="title"><bean:message key="label.equipment.posname"/>:</td>
		<td class="title"><bean:write name="EquipmentListForm" property="posid" />&nbsp;&nbsp;&nbsp;<bean:write name="EquipmentListForm" property="posname" /></td>
	</tr>
	</table>
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>" />

<tr class="title">
	<td colspan="<%= gColSpan %>">
	<table class="buttons">
	<tr class="title">
		<td class="buttons">
			<%if(hasRegionAccess){%>
				<july:addbutton page="/EditEquipment.do?action=Add"/>
			<%}%>
			<july:backbutton page="/EditPosition.do?action=View" paramId="storageplace" paramName="EquipmentListForm" paramProperty="storageplace"/>
			&nbsp;&nbsp;&nbsp;
			<input type=image src="/images/details.gif" name="submit" alt='Состав выбранного оборудования' onclick="return updateActionForMulti();">
		</td>
		<td class="navigator"><july:navigator/></td>
	</tr>
	</table>
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>" />

<!-- Table header -->
<tr class="title">
	<td class="title">&nbsp;</td>
	<july:sortcolumn ascFinder="1" descFinder="2" key="label.equipment.complect" colType="string"/>
	<july:headercolumn key="label.equipment.type" colType="string"/>
	<july:sortcolumn ascFinder="3" descFinder="4" key="label.equipment.number" colType="string"/>
	<july:sortcolumn ascFinder="5" descFinder="6" key="label.equipment.name" colType="string"/>
	<july:headercolumn key="label.equipment.equipcomment" colType="string"/>
	<july:headercolumn key="label.equipment.state" colType="string"/>
	<td class="title">№ Beenet Л.С.</td>
	<td class="title">Ответная часть</td>
<%-- //Позднее убрать --%>
	<july:headercolumn key="label.equipment.contents" colType="string"/>
	<td class="title"><img src="/images/setnew.gif" border="0" alt="Выбрать все" onclick="selectAllEquipment();return false;"></td>
	<td class="title">&nbsp;</td>
</tr>

<july:separator colspan="<%= gColSpan %>" />

<!-- Table body -->
<logic:iterate id="equ" name="browseList" type="com.hps.july.cdbc.lib.CDBCRowObject">
<%if(equ != null) {%>
<%
	String linkUrl = "EditEquipment.do?action=View";
	String delUrl = null;
	String linkParam = "storageplace";

	String equipment = equ.getColumn("equipment").asString();
	String type = equ.getColumn("type").asString();
	String equtype = equ.getColumn("equtype").asString();
	String equsubtype = equ.getColumn("equsubtype").asString();
	if(equ.getColumn("equsubtype").asObject() == null) {
		equsubtype = null;
	}
	String equnumber = equ.getColumn("equnumber").asString();
	String equname = equ.getColumn("equname").asString();
	String equstate = equ.getColumn("equstate").asString();
	Object haveAgregates = equ.getColumn("agrcount").asObject();
	String[] otv = { "", "" };

	pageContext.setAttribute("equ_equipment",equipment);

	// Define action url
	if("B".equals(type)) { // Basestations
		linkParam = "basestation";
		linkUrl = AppConstants.BASE_BASESTATION + "/Edit_ViewFactBaseStation.do";
		delUrl = AppConstants.BASE_BASESTATION+"/Edit_AddDeleteFactBaseStation.do?action=Delete&"+AppConstants.APP_HOME+"="+Applications.SITEINFO;
		linkUrl += "?action=View&"+AppConstants.APP_HOME+"="+Applications.SITEINFO;
	} else
	if("C".equals(type)) { // Communication equipment
		equnumber = EquipmentListForm.getBeenetListString(equipment);
System.out.println("EQU:"+equipment);
		String[] o = EquipmentListForm.getOtv(equipment);
		if(o != null) {
			if(o[0] != null) { otv[0] = o[0]; }
			if(o[1] != null) { otv[1] = o[1];  }
		}

		if(RolesValidation.canModify(pageContext,"comRoles") && hasRegionAccess) {
			linkUrl = "EditEquipment.do?action=Edit";
			delUrl = "EditEquipment.do?action=Delete";
		} else {
			linkUrl = "EditEquipment.do?action=View";
		}
	} else
	if("O".equals(type)) { // Controllers
		linkParam = "storageplace";
		linkUrl = AppConstants.BASE_BASESTATION+"/EditFactController.do";
		if(hasRegionAccess) {
			delUrl = linkUrl + "?action=Delete&"+AppConstants.APP_HOME+"="+Applications.SITEINFO;
			linkUrl += "?action=Edit&"+AppConstants.APP_HOME+"="+Applications.SITEINFO;
		} else {
			linkUrl += "?action=View&"+AppConstants.APP_HOME+"="+Applications.SITEINFO;
		}
	} else
	if("R".equals(type)) { // Repeaters
		linkParam = "storageplace";
		linkUrl = AppConstants.BASE_BASESTATION+"/EditFactRepeater.do";
		if(hasRegionAccess) {
			delUrl = linkUrl + "?action=Delete&"+AppConstants.APP_HOME+"="+Applications.SITEINFO;
			linkUrl += "?action=Edit&"+AppConstants.APP_HOME+"="+Applications.SITEINFO;
		} else {
			linkUrl += "?action=View&"+AppConstants.APP_HOME+"="+Applications.SITEINFO;
		}
	} else
	if("T".equals(type)) { // Other equipment
		if(hasRegionAccess) {
			linkUrl = "EditEquipment.do?action=Edit";
			delUrl = "EditEquipment.do?action=Delete";
		}
	} else
	if("W".equals(type)) { // Switches
		linkParam = "storageplace";
		linkUrl = AppConstants.BASE_BASESTATION+"/EditFactSwitch.do";
		if(hasRegionAccess) {
			delUrl = linkUrl + "?action=Delete&"+AppConstants.APP_HOME+"="+Applications.SITEINFO;
			linkUrl += "?action=Edit&"+AppConstants.APP_HOME+"="+Applications.SITEINFO;
		} else {
			linkUrl += "?action=View&"+AppConstants.APP_HOME+"="+Applications.SITEINFO;
		}
		// @TODO: Check if has access to this url in web.xml
	} else
	if("L".equals(type)) { // Other equipment
		if(hasRegionAccess) {
			linkUrl = "EditEquipment.do?action=Edit";
			delUrl = "EditEquipment.do?action=Delete";
		}
	} else { // Some unknown equipment
	}
	if(equsubtype != null) {
%>

<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
	<td class="text">
		<%if(haveAgregates != null) {%>
			<A href='/basestation/EquipsdetListDialog.do?action=&equipment=<%=equipment%>' onclick='window.open(this.href, "equipsdetListDialog", "top=100, left=250, width=650, height=600, scrollbars=yes, resizable=yes").focus(); return false;'>
					<IMG SRC="/images/details.gif" BORDER='0' ALT='Список оборудования'>
			</A>
		<%}%>
	</td>
	<td class="text">
		<%if(equtype!=null){%>
		<%if(equsubtype != null) {%>
		<html:link href='<%=linkUrl%>' paramId="<%=linkParam%>" paramName="equ_equipment" paramScope="page"><bean:message key="<%=equtype%>"/></html:link>
		<%} else {%>
		<bean:message key="<%=equtype%>"/>
		<%}%>
		<%}%>
	</td>
	<td class="text"><%if(equsubtype != null && !"".equals(equsubtype)) {%><bean:message key="<%=equsubtype%>"/><%}%></td>
	<td class="text"><%=equnumber%></td>
	<td class="text"><july:stringwrite name="equ" property="equname"/></td>
	<td class="text"><july:stringwrite name="equ" property="equipcomment"/></td>
	<td class="text"><%if(equstate != null && !"".equals(equstate)) {%><bean:message key="<%=equstate%>"/><%}%></td>
	<td class="text" style="font-size:8pt;" nowrap><%=otv[0]%></td>
	<td class="text" style="font-size:8pt;" nowrap><%=otv[1]%></td>
<%-- //Позднее убрать --%>
	<td class="text">
		<%if(haveAgregates != null) {%>
			<html:link page="/ShowEquipdetList.do" paramId="storageplace" paramName="equ_equipment"><bean:message key="label.equipment.contents"/></html:link>
		<%}%>
	</td>

	<td class="text">
		<input type="checkbox" class="editcheckbox" name="equiplist" value="<%=equipment%>">
	</td>
	<td class="link">
		<%if(delUrl != null && hasRegionAccess && equsubtype != null) {%><july:delbutton href="<%=delUrl%>" paramId="<%=linkParam%>" paramName="equ_equipment" paramScope="page"/><%}%>
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>" />
<%
	} else {
System.out.println("BROKEN EQUIPMENT RECORD:"+type+equipment);
	}
%>
<%}%>
</logic:iterate>

<tr class="title">
	<td colspan="<%= gColSpan %>">
		<table class="buttons">
		<tr class="title">
			<td class="buttons">
				<%if(hasRegionAccess) {%>
				<july:addbutton page="/EditEquipment.do?action=Add"/>
				<%}%>
				<july:backbutton page="/EditPosition.do?action=View" paramId="storageplace" paramName="EquipmentListForm" paramProperty="storageplace"/>
				&nbsp;&nbsp;&nbsp;
				<input type=image src="/images/details.gif" name="submit" alt='Состав выбранного оборудования' onclick="return updateActionForMulti();">
			</td>
			<td class="navigator"><july:navigator/></td>
		</tr>
		</table>
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>" />

</table>

</july:browseform>
<%
	ts.finish("JSP");
%>
