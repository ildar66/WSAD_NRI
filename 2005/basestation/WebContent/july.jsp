<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld" prefix="alex" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.constants.*,com.hps.july.basestation.*" %>
<%@ page import="org.apache.struts.util.MessageResources" %>
<%@ page import="com.hps.july.jdbcpersistence.lib.DebugSupport" %>

<%@include file="initProfile.jspf"%> 

<html>
<head>
<META HTTP-EQUIV = "Pragma" CONTENT="no-cache">
<title><bean:message key="menu.root.baseStation_"/></title>
<link rel="stylesheet" type="text/css" href="/main.css">

<SCRIPT SRC='support.js'>
   document.write("errors in 'support.js' or file not found");
</SCRIPT>

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
	if(application.getAttribute("siteinfoResources")==null){
		application.setAttribute("siteinfoResources",MessageResources.getMessageResources("com.hps.july.basestation.SiteinfoResources"));
	}

	if(application.getAttribute("dictionaryResources")==null){
		application.setAttribute("dictionaryResources", MessageResources.getMessageResources("com.hps.july.basestation.DictionaryResources"));
	}

	if(application.getAttribute("MenuResources")==null) {
		application.setAttribute("MenuResources", MessageResources.getMessageResources("com.hps.july.basestation.MenuResources"));
	}



	int app = ParamsParser.getApplication( pageContext );
	int state = ParamsParser.getState( pageContext );
	switch( app ) {
	  case Applications.BASESTATION:
	switch( state )
	{
	case APPStates.RESTYPE_LOOKUP :
		%><jsp:include page="/restypeLookupList.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.RESSUBTYPE_LOOKUP :
		%><jsp:include page="/ressbtypeLookupList.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.ANT_RES_LOOKUP :
		%><jsp:include page="/antennaResLookupList.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.CNTRLOOKUP :
		%><jsp:include page="/controllerLookupList.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.SWCHLOOKUP :
		%><jsp:include page="/switchLookupList.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.POSLOOKUP :
		%><jsp:include page="/positionLookupList.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.ANTENNA_LOOKUP:
		%><jsp:include page="/antennaLookupList.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.REPEATERRES_LOOKUP:
		%><jsp:include page="/repeaterresLookupList.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.ORG_LOOKUP:
		%><jsp:include page="/organizationLookupList.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.COMEQU_LOOKUP:
		%><jsp:include page="/comEquipmentLookupList.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.BS_LOOKUP:
		%><jsp:include page="/bsLookupList.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.BSSECTOR_LOOKUP:
		%><jsp:include page="/bsSectorLookupList.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.BSANTENNA_LOOKUP:
		%><jsp:include page="/bsAntennaLookupList.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.COMLINE_LOOKUP:
		%><jsp:include page="/comlineLookupList.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.REGIONS_LOOKUP:
		%><jsp:include page="/regionsLookupList.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.BS_GSM:
		%><jsp:include page="/baseStationGSM.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.REPEATER_DIALOG:
		%><jsp:include page="/repeaterDialogForm.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.BS_DIALOG:
		%><jsp:include page="/bsDialogForm.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.CONTROLLER_DIALOG:
		%><jsp:include page="/controllerDialogForm.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.REGLAMENT_WORKS_DIALOG:
		%><jsp:include page="/reglamentWorksDialog.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.EQUIPDETLIST_DIALOG_FORM:
		%><jsp:include page="/equipsdetListDialog.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.SECTOR_LIST_DIALOG_FORM:
		%><jsp:include page="/sectorListDialog.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.SECTOR_DIALOG_FORM:
		%><jsp:include page="/sectorDialog.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.KZL_INDEX_DIALOG_FORM:
		%><jsp:include page="/kzl_IndexDialog.jsp" flush="true"></jsp:include><%
		break;

	default:
		%><jsp:include page="/baseStation.jsp" flush="true"></jsp:include><%
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
