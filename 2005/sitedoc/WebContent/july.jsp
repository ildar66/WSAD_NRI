<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld" prefix="alex" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.constants.*,com.hps.july.sitedoc.*" %>
<%@ page import="org.apache.struts.util.MessageResources" %>
<%@ page import="com.hps.july.jdbcpersistence.lib.AppConstants" %>
<%@ page import="com.hps.july.jdbcpersistence.lib.DebugSupport" %>

<%@include file="initProfile.jspf"%>

<%
	int appHome = Applications.SITEDOC;
	appHome = ParamsParser.getRootApp( pageContext );

//	int appHome = 10;
//	DebugSupport.printlnTest("july.jsp appHome="+appHome);

	String labelKey = "label.siteinfo";

	if(appHome==Applications.SITEINFO) {
		labelKey="label.siteinfo";
	} else if(appHome==Applications.BASESTATION) {
		labelKey="label.basestation";
	} else if(appHome==Applications.PROJECT) {
		labelKey="label.project";
	}
%>

<html>
<head>
	<META HTTP-EQUIV = "Pragma" CONTENT="no-cache">
	<title><bean:message key="<%=labelKey%>"/></title>
	<link rel="stylesheet" type="text/css" href="/main.css">
	<SCRIPT language=javascript src="/common/exitFromNRI.js" type="text/javascript"></SCRIPT>  

	<script SRC='support.js'>
		document.write("errors in 'support.js' or file not found");
	</script>
	<script SRC='multipleSelect.js'>
		document.write("errors in 'multipleSelect.js' or file not found");
	</script>
	<script language="JavaScript">
		//Function below changes cursor to default, when specific image loaded into page
		function changeCursor()
		{
			document.body.style.cursor="auto";
		}
	</script>
</head>

<body id="abody" onload="document.body.style.cursor='auto';">
<script language="JavaScript">
	document.body.style.cursor="wait";
</script>
<july:licence licence="/comctl2.lpk" />
<%
/*
	String par = request.getParameter(AppConstants.APP_HOME);
	if (par != null) {
		request.getSession().setAttribute(AppConstants.APP_HOME, new Integer(par));
	}
	par = request.getParameter(AppConstants.SITEDOC_OBJECT_ID);
	if (par != null) {
		request.getSession().setAttribute(AppConstants.SITEDOC_OBJECT_ID, par);
	}
*/
%>

<%
	int app = ParamsParser.getApplication( pageContext );
	int state = ParamsParser.getState( pageContext );
	switch( app ) {
	case Applications.SITEDOC:
		switch( state )
		{
		default:
			%><jsp:include page="/sitedoc.jsp" flush="true"></jsp:include><%
			break;
		}
		break;
	default:
		//out.println("State='" + state + "'<BR>");
		%><jsp:include page="/error.jsp" flush="true"></jsp:include><%
		break;
	}
%>
</body>
</html>
