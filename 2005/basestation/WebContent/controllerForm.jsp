<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld" prefix="alex" %>
<%@ page import="org.apache.struts.util.*,com.hps.july.basestation.formbean.ControllerForm" %>
<%@ page import="com.hps.july.basestation.APPStates" %>
<%@ page import="com.hps.july.basestation.formbean.EquipmentPForm" %>
<%@ page import="com.hps.july.web.util.ParamsParser" %>
<%@ page import="com.hps.july.jdbcpersistence.lib.DebugSupport" %>

<%
	request.setAttribute("colspan", "2");	//для использования во включенных jsp
	EquipmentPForm lForm = (EquipmentPForm) pageContext.findAttribute("ControllerForm");
	request.setAttribute("EquipmentPForm",lForm);
%>
<july:editform action="/ProcessController.do" styleId="EquipmentPForm">
<table class="main"> 
<%	if ("Edit".equals(lForm.getAction()) || "View".equals(lForm.getAction())) { %>
<july:separator/>
<july:formbuttons/>
<july:separator/>
<jsp:include page="/controllerForm/actionsMenu.jsp" flush="true"/>
<%	} %>
<july:separator/>
<jsp:include page="/controllerForm/fields.jsp" flush="true"/>
<july:separator/>
<july:formbuttons/>
<july:separator/>
</table>
</july:editform>
