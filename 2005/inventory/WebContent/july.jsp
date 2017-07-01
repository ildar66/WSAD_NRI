<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.constants.*,com.hps.july.inventory.*" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<%@include file="initProfile.jspf"%>

<html> 
<head>
	<META HTTP-EQUIV = "Pragma" CONTENT="no-cache">
	<title><bean:message key="label.menu.root"/></title>
	<link rel="stylesheet" type="text/css" href="/main.css">
  <link rel="stylesheet" type="text/css" href="/cols.css">
</head>

<body id="abody" onload="document.body.style.cursor='auto';">
<script language="JavaScript">
	document.body.style.cursor="wait";
</script>
<july:licence licence="/comctl2.lpk" />
	<%
	int app = ParamsParser.getApplication( pageContext );
	int astate = ParamsParser.getState( pageContext );
	switch( app ) {
	  case Applications.INVENTORY:
      switch( astate )
        {
        case APPStates.DOCLOOKUP:
          %>
          <jsp:include page="/docLookupList.jsp" flush="true"></jsp:include>
          <%
          break;
        case APPStates.REQLOOKUP:
          %>
          <jsp:include page="/reqLookupList.jsp" flush="true"></jsp:include>
          <%
          break;
        case APPStates.STORLOOKUP:
          %>
          <jsp:include page="/storageLookupList.jsp" flush="true"></jsp:include>
          <%
          break;
        case APPStates.ORGLOOKUP:
          %>
          <jsp:include page="/organizationLookupList.jsp" flush="true"></jsp:include>
          <%
          break;
        case APPStates.WRKLOOKUP:
          %>
          <jsp:include page="/workerLookupList.jsp" flush="true"></jsp:include>
          <%
          break;
        case APPStates.EQUIPLOOKUP:
          %>
          <jsp:include page="/equipmentLookupList.jsp" flush="true"></jsp:include>
          <%
          break;
        case APPStates.EQUIPPLOOKUP:
          %>
          <jsp:include page="/equipmentPLookupList.jsp" flush="true"></jsp:include>
          <%
          break;
        case APPStates.EQUIPELOOKUP:
          %>
          <jsp:include page="/equipmentELookupList.jsp" flush="true"></jsp:include>
          <%
          break;
        case APPStates.COMPLOOKUP:
          %>
          <jsp:include page="/companyLookupList.jsp" flush="true"></jsp:include>
          <%
          break;
        case APPStates.RTPLOOKUP:
          %>
          <jsp:include page="/restypeLookupList.jsp" flush="true"></jsp:include>
          <%
          break;
        case APPStates.RSTPLOOKUP:
          %>
          <jsp:include page="/ressbtypeLookupList.jsp" flush="true"></jsp:include>
          <%
          break;
        case APPStates.DIVLOOKUP:
          %>
          <jsp:include page="/divisionLookupList.jsp" flush="true"></jsp:include>
          <%
          break;
        case APPStates.AGRLOOKUP:
          %>
          <jsp:include page="/agregateLookupList.jsp" flush="true"></jsp:include>
          <%
          break;
        case APPStates.RESLOOKUP:
          %>
          <jsp:include page="/resourceLookupList.jsp" flush="true"></jsp:include>
          <%
          break;
        case APPStates.CONTLOOKUP:
          %>
          <jsp:include page="/contractLookupList.jsp" flush="true"></jsp:include>
          <%
          break;
        case APPStates.CONTRAGLOOKUP:
          %>
          <jsp:include page="/contragentLookupList.jsp" flush="true"></jsp:include>
          <%
          break;
        case APPStates.POSLOOKUP:
          %>
          <jsp:include page="/positionLookupList.jsp" flush="true"></jsp:include>
          <%
          break;
        case APPStates.BSSETLOOKUP:
          %><jsp:include page="/complectBSLookupList.jsp" flush="true"></jsp:include><%
          break;
        case APPStates.EQSETLOOKUP:
          %><jsp:include page="/complectLookupList.jsp" flush="true"></jsp:include><%
          break;
        case APPStates.EQPOSLOOKUP:
          %>
          <jsp:include page="/equipmentPosLookupList.jsp" flush="true"></jsp:include>
          <%
          break;
        case APPStates.RENTLOOKUP:
          %>
          <jsp:include page="/renterLookupList.jsp" flush="true"></jsp:include>
          <%
          break;
        case APPStates.RESSETLOOKUP:
          %>
          <jsp:include page="/resourcesetLookupList.jsp" flush="true"></jsp:include>
          <%
          break;
        case APPStates.SERLOOKUP:
          %>
          <jsp:include page="/serialnumLookupList.jsp" flush="true"></jsp:include>
          <%
          break;
        case APPStates.PARTLOOKUP:
          %>
          <jsp:include page="/partynumLookupList.jsp" flush="true"></jsp:include>
          <%
          break;
	case APPStates.IRSLOOKUP:
          %>
          <jsp:include page="/i13nressetLookupList.jsp" flush="true"></jsp:include>
          <%
          break;
	case APPStates.IOPRINT:
          %>
          <jsp:include page="/internalPrint.jsp" flush="true"></jsp:include>
          <%
          break;
	case APPStates.IORPRINT:
          %>
          <jsp:include page="/internalRPrint.jsp" flush="true"></jsp:include>
          <%
          break;
	case APPStates.EOPRINT:
          %>
          <jsp:include page="/externalPrint.jsp" flush="true"></jsp:include>
          <%
          break;
	case APPStates.IVAPRINT:
          %>
          <jsp:include page="/invActPrint.jsp" flush="true"></jsp:include>
          <%
          break;
	case APPStates.INVPRINT:
          %>
          <jsp:include page="/invPrint.jsp" flush="true"></jsp:include>
          <%
          break;
	case APPStates.STCLOOKUP:
          %>
          <jsp:include page="/storagecardLookupList.jsp" flush="true"></jsp:include>
          <%
          break;
	case APPStates.CRDSLOOKUP:
          %>
          <jsp:include page="/scardLookupList.jsp" flush="true"></jsp:include>
          <%
          break;
	case APPStates.CRDPLOOKUP:
          %>
          <jsp:include page="/pcardLookupList.jsp" flush="true"></jsp:include>
          <%
          break;
	case APPStates.CRDRLOOKUP:
		request.setAttribute("CRDLOOKUP.action","/ShowCardRLookupList.do");
		request.setAttribute("CRDLOOKUP.form","CardRLookupListForm");
		%><jsp:include page="/cardLookupList.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.CRDLOOKUP:
		request.setAttribute("CRDLOOKUP.action","/ShowCardLookupList.do");
		request.setAttribute("CRDLOOKUP.form","CardLookupListForm");
		%><jsp:include page="/cardLookupList.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.RPT1RTLOOKUP:
          %>
          <jsp:include page="/report1rtLookupList.jsp" flush="true"></jsp:include>
          <%
          break;
	case APPStates.RPT1RSTLOOKUP:
          %>
          <jsp:include page="/report1rstLookupList.jsp" flush="true"></jsp:include>
          <%
          break;
	case APPStates.BARPARAMS:
          %>
          <jsp:include page="/barReportParams.jsp" flush="true"></jsp:include>
          <%
          break;
	case APPStates.BARPRINT:
          %>
          <jsp:include page="/barReportForm.jsp" flush="true"></jsp:include>
          <%
          break;
    case APPStates.BARLOOKUP:
          %>
          <jsp:include page="/barSerialLookupList.jsp" flush="true"></jsp:include>
          <%
          break;
	case APPStates.RPTXLS:
          %>
          <jsp:include page="/reportExcel.jsp" flush="true"></jsp:include>
          <%
          break;
	case APPStates.RESLOOKUPSER:
          %>
          <jsp:include page="/resourceLookupBySerialList.jsp" flush="true"></jsp:include>
          <%
          break;
	case APPStates.CONTR_EQ_LIST:
		  %>
		  <jsp:include page="/contractorEquipList.jsp" flush="true"></jsp:include>
		  <%
		  break;
	case APPStates.DOCSBYCOMPROJLIST:
		  %>
		  <jsp:include page="/docsbycomprojectList.jsp" flush="true"></jsp:include>
		  <%
		  break;
	case APPStates.CONF_EQ_FORM_STANDS_TITLE:	
 			%><jsp:include page="/standsTitle.jsp" flush="true"></jsp:include><%
	 		break;		
	case APPStates.CONF_EQ_FORM_STANDS_CONTENT:	
 			%><jsp:include page="/standsContent.jsp" flush="true"></jsp:include><%
	 		break;		
	case APPStates.CONF_EQ_FORM_ANTENNS_TITLE:	
 			%><jsp:include page="/antennsTitle.jsp" flush="true"></jsp:include><%
	 		break;		
	case APPStates.CONF_EQ_FORM_ANTENNS_CONTENT:	
 			%><jsp:include page="/antennsContent.jsp" flush="true"></jsp:include><%
	 		break;		
        default:
          %>
          <jsp:include page="/inventory.jsp" flush="true"></jsp:include>
          <%
          break;
        }
		  break;
		default:
			%>
			<jsp:include page="/error.jsp" flush="true"></jsp:include>
			<%
			break;
		}
	%>
</body>
</html>
