<%@ page import="com.hps.july.jdbcpersistence.lib.AppConstants"%>
<%@ page import="com.hps.july.constants.Applications"%>
<%@ page import="com.hps.july.jdbcpersistence.lib.*"%>
<%@ page import="com.hps.july.sitedoc.valueobject.*"%>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld" prefix="alex" %>

<%
	DocObjectDef odef = DocObjectDef.getDef(session);

	String listLink=AppConstants.BASE_BASESTATION;
	String listKey="?";
	if(odef.isBaseStation()) {
		listLink=listLink+"/ShowBaseStationList.do";
		listKey="menu.root.baseStation";
	} else if(odef.isSwitch()) {
		listLink=listLink+"/ShowSwitchList.do";
		listKey="menu.switchList";
	} else if(odef.isController()) {
		listLink=listLink+"/ShowControllerList.do";
		listKey="menu.controllerlist";
	}
%>

<html:link href="<%=listLink%>" styleClass="navigator">
	<bean:message bundle="bsResources" key="<%=listKey%>"/>
</html:link>






