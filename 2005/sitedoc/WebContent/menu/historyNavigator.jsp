<%@ page import="com.hps.july.sitedoc.valueobject.*"%>
<%@ page import="com.hps.july.constants.Applications,com.hps.july.jdbcpersistence.lib.*"%>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld" prefix="alex" %>

<%
DocObjectDef odef = DocObjectDef.getDef(session);
DebugSupport.printlnTest("historyNavigator.jsp dForm.getObjectUrl()="+odef.getObjectUrl());
DebugSupport.printlnTest("historyNavigator.jsp getObjectMenuKey()="+odef.getObjectMenuKey());

if(odef.getAppHome().equals(Applications.SITEINFO+"")) {
	%><jsp:include page="/menu/siteinfoNavigator.jsp" flush="true" /><%
} else if(odef.getAppHome().equals(Applications.BASESTATION+"")) {
	%><jsp:include page="/menu/basestationNavigator.jsp" flush="true" /><%
} else if(odef.getAppHome().equals(Applications.PROJECT+"")) {
	%><jsp:include page="/menu/projectNavigator.jsp" flush="true" /><%
}
%>

<%
if(!odef.isProject()) {
%>
<july:sepmark/>
<html:link href="<%=odef.getObjectUrl()%>" styleClass="navigator">
    <bean:message  key="<%=odef.getObjectMenuKey()%>"/>
</html:link>
<%
}
%>


