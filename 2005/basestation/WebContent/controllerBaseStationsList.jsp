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

<%
	//String gColSpan = "10";
	String gColSpan = "9";
	request.setAttribute("colspan",gColSpan);
	ControllerBaseStationsList lForm = (ControllerBaseStationsList) pageContext.findAttribute("ControllerBaseStationsList");
	request.setAttribute("EquipmentListForm",lForm);
%>

<july:browseform action="/ShowControllerBaseStationsList.do" styleId="ControllerBaseStationsList">

<table class="main">

<july:separator colspan="<%= gColSpan %>"/>
<jsp:include page="/controllerBaseStationList/fields.jsp" flush="true"/>
<july:separator colspan="<%= gColSpan %>"/>
<jsp:include page="/controllerBaseStationList/buttons.jsp" flush="true"/>
<july:separator colspan="<%= gColSpan %>"/>
<jsp:include page="/controllerBaseStationList/table.jsp" flush="true"/>
<jsp:include page="/controllerBaseStationList/buttons.jsp" flush="true"/>
<july:separator colspan="<%= gColSpan %>"/>
</table>

</july:browseform>
