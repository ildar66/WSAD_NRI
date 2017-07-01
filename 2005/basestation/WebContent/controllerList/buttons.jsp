<%@ page import="com.hps.july.basestation.formbean.ControllerListForm"%>
<%@ page import="com.hps.july.basestation.APPStates"%>
<%@ page import="com.hps.july.basestation.formbean.EquipmentListForm"%>
<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld" prefix="alex" %>

<%
	Object o = request.getAttribute("colspan");
	String gColSpan = "2";
	EquipmentListForm lForm = (EquipmentListForm) pageContext.findAttribute("EquipmentListForm");
	int estate=(lForm.getState()==APPStates.CONTROLLER_LIST?APPStates.CONTROLLER_EDIT:APPStates.SwitchControllerForm);
	String editFactAction="/EditFactController.do?state="+estate;
	if(o != null && o instanceof String) {
		gColSpan = (String)o;
	}
	boolean canAddDel=false;
	
	if(lForm.getState()==APPStates.CONTROLLER_LIST) {
		canAddDel = true;
	}
	String trailcomMapUrl = com.hps.july.util.AppUtils.getNamedValueString("PathMapTrailcom");
	String ruser = request.getRemoteUser();
%>

<tr class="title">
<td colspan="<%= gColSpan %>">
	<TABLE class="buttons">
	<TR class="title">
	<TD class="buttons">

<%if(canAddDel){%>
		<alex:hasAccess href="<%= editFactAction %>">
			<html:link page='<%= editFactAction+"&action=Add" %>'>
				<IMG alt='<bean:message key="controllerlist.buttons.addfact"/>' src="/images/plus.gif" border=0>
			</html:link>
		</alex:hasAccess>
		<IMG alt="" src="/images/empty.gif" width=3 border=0>
<%}%>

		<july:backbutton/>&nbsp;
		<image name="onMap" src="/images/map.gif" alt="<bean:message key="SwitchList.buttons.map"/>" onclick='determineMaps("<%=trailcomMapUrl%>","<%=ruser%>");' />
	</TD>
	<TD class="navigator"><july:navigator/></TD>
	</TR>
	</TABLE>
</td>
</tr>
