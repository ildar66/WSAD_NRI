<%@ page language = "java" %>
<%@ page import="org.apache.struts.util.RequestUtils"%>
<%@ page import="com.hps.july.basestation.valueobject.SwitchObject"%>
<%@ page import="com.hps.july.jdbcpersistence.lib.Checks"%>
<%@ page import="com.hps.july.jdbcpersistence.lib.DebugSupport"%>
<%@ page import="com.hps.july.basestation.valueobject.BaseStationObject"%>
<%@ page import="com.hps.july.apptags.HasAccessTag"%>

<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld"    prefix="alex" %>

<SCRIPT language="JavaScript">
function checkAll(select, groupId) {
	//alert("document.all.item(groupId)="+document.all.item(groupId));
	if(document.all.item(groupId)!=null) {
		document.all.item(groupId).checked=select;
		for(var i=0; i< document.all.item(groupId).length; i++){
			document.all.item(groupId)[i].checked=select;
		}
	}
}
</SCRIPT>

<%
	String gColSpan = request.getAttribute("colspan")+"";
	BaseStationObject baseStation=null;
	String viewAction=null;

	String editFactAction="/Edit_AddDeleteFactBaseStation.do";

	String editAction=null;
	boolean canEditFact=false;
	boolean canEdit=false;
%>

<alex:hasAccess href="<%=editFactAction%>"><%canEditFact=true;%></alex:hasAccess>

<tr class="title">
	<td></td>
	<july:sortcolumn key="label.baseStationList.number" colType="string" ascFinder="1" descFinder="2"/>
	<july:headercolumn key="label.baseStationList.type" colType="string"/>
	<july:sortcolumn key="label.baseStationList.name" colType="string" ascFinder="3" descFinder="4"/>
	<july:headercolumn key="label.baseStationList.address" colType="string"/>
	<july:headercolumn key="label.baseStationList.netzone" colType="string"/>
	<july:headercolumn key="label.positionList.posstate" colType="string"/>
	<july:headercolumn key="label.baseStationList.onair" colType="string"/>
</tr>

<july:separator colspan="<%= gColSpan %>" />
<!-- Table body -->
<logic:iterate id="bs" name="browseList" type="com.hps.july.cdbc.lib.CDBCRowObject">
<logic:present name="bs">
<%
	String equipment = bs.getColumn("equipment").asString();
	pageContext.setAttribute("bs_equipment",equipment);
	String positionid = bs.getColumn("positionid").asString();
	canEdit = canEditFact && "Y".equals(bs.getColumn("edit").asString());
	String equstate = bs.getColumn("bsstate").asString();
	if(equstate == null || "".equals(equstate)) {
		equstate = "unknown";
	} else {
		equstate = equstate.toLowerCase();
	}

//	String delAction=null;
//	baseStation=(BaseStationObject)pageContext.getAttribute("bs");
//	if(baseStation.isView()) {
		viewAction="/Edit_ViewFactBaseStation.do";
		editAction=editFactAction;
//		delAction=editAction+"?action=Delete";
%>
<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
	<td>
		<july:editbutton page="<%=viewAction%>" action="View" paramId="basestation" paramName="bs_equipment" alttext="button.view.basestation"/>
	</td>
	<td class="number"><july:stringwrite name="bs" property="number"/></td>
	<td class="text"><july:stringwrite name="bs" property="type"/></td>
	<td class="text"><july:stringwrite name="bs" property="name"/></td>
	<td class="text"><july:stringwrite name="bs" property="address"/></td>
	<td class="text"><july:stringwrite name="bs" property="zonecode"/></td>
	<td class="text"><bean:message key='<%="label.equipment.state"+equstate%>'/></td>
	<td class="text"><%if("Y".equals(bs.getColumn("onair").asString())){%><bean:message key="BaseStation.onair.show"/><%}%></td>
</tr>
<july:separator colspan="<%= gColSpan %>" />
</logic:present>
</logic:iterate>
