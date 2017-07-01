<%@ page import="com.hps.july.basestation.formbean.ControllerListForm"%>
<%@ page import="com.hps.july.jdbcpersistence.lib.Checks"%>
<%@ page import="com.hps.july.jdbcpersistence.lib.SearchConstants"%>
<%@ page import="com.hps.july.web.util.ParamsParser"%>
<%@ page import="com.hps.july.basestation.APPStates"%>
<%@ page import="com.hps.july.basestation.formbean.EquipmentListForm"%>
<%@ page import="com.hps.july.jdbcpersistence.lib.DebugSupport"%>

<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<%
//	DebugSupport.printlnTest("!!!!controllerList.jsp started");
	String gColSpan = "9";
	request.setAttribute("colspan", gColSpan); // для использования во включенных jsp
	int state = ParamsParser.getState( pageContext );
	EquipmentListForm lForm = null;
	String fieldsPage = "";
	String action = "";

	if(state==APPStates.CONTROLLER_LIST){
		fieldsPage="/controllerList/fieldsControllerList.jsp";
		lForm = (EquipmentListForm) pageContext.findAttribute("ControllerListForm");
		action="/ShowControllerList.do";
	} else if(state==APPStates.SWCH_CONNECTED_CONTR) {
		fieldsPage="/controllerList/fieldsSwitchControllerList.jsp";
		lForm = (EquipmentListForm) pageContext.findAttribute("SwitchControllerListForm");
		action="/ShowSwitchControllersList.do";
	}
	request.setAttribute("EquipmentListForm",lForm);//для использования во включенных jsp
	DebugSupport.printlnTest("!!!!!controllerList.jsp lForm="+lForm);
%>

<july:browseform action="<%=action%>" styleId="ControllerListForm">
<table class="main">
<july:separator colspan="<%= gColSpan %>"/>
<jsp:include flush="true" page="<%=fieldsPage%>"/>
<july:separator colspan="<%= gColSpan %>"/>
<jsp:include flush="true" page="/controllerList/buttons.jsp"/>
<july:separator colspan="<%= gColSpan %>"/>
<jsp:include flush="true" page="/controllerList/table.jsp"/>
<jsp:include flush="true" page="/controllerList/buttons.jsp"/>
<july:separator colspan="<%= gColSpan %>"/>
</table>
</july:browseform>
