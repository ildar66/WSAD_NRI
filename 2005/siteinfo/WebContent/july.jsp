<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.constants.*, org.apache.struts.util.MessageResources" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<%@include file="initProfile.jspf"%>

<HTML>
<HEAD>
 <META HTTP-EQUIV = "Pragma" CONTENT="no-cache">
 <title><bean:message key="label.siteinfo"/></title>
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
/*
if(application.getAttribute("journalResources")==null){
application.setAttribute("journalResources",
  MessageResources.getMessageResources("com.hps.july.siteinfo.JournalResources"));
}
*/
//for organizationLookupList.jsp
if(application.getAttribute("inventoryResources")==null){
application.setAttribute("inventoryResources",
  MessageResources.getMessageResources("com.hps.july.siteinfo.InventoryResources"));
}

if(application.getAttribute("bsResources")==null){
application.setAttribute("bsResources",
  MessageResources.getMessageResources("com.hps.july.siteinfo.BsResources"));
}

if(application.getAttribute("MenuResources")==null){
application.setAttribute("MenuResources",
  MessageResources.getMessageResources("com.hps.july.basestation.MenuResources"));
}


	int app = ParamsParser.getApplication( pageContext );
	int state = ParamsParser.getState( pageContext );
	//out.println("State='" + state + "'<BR>");
	//out.println("App='" + app + "'<BR>");
	switch( app ) {
      case com.hps.july.constants.Applications.BASESTATION:
         %>
          <jsp:include page="/siteinfo.jsp" flush="true"></jsp:include>
         <%
        break;

	  case Applications.SITEINFO:
      switch( state )
        {
          case com.hps.july.siteinfo.APPStates.OSSEQUIPABSENT:
          %>
          <jsp:include page="/oss_nodata.jsp" flush="true"></jsp:include>
          <%
          break;
          case com.hps.july.siteinfo.APPStates.OSSEQUIPALCATEL:
          %>
          <jsp:include page="/oss_alcatelequipdata.jsp" flush="true"></jsp:include>
          <%
          break;
          case com.hps.july.siteinfo.APPStates.OSSEQUIPNOKIA:
          %>
          <jsp:include page="/oss_nokiaequipdata.jsp" flush="true"></jsp:include>
          <%
          break;
          case com.hps.july.siteinfo.APPStates.OSSEQUIPERICSSON:
          %>
          <jsp:include page="/oss_ericssonequipdata.jsp" flush="true"></jsp:include>
          <%
          break;
          case com.hps.july.siteinfo.APPStates.EDITCOMMENT:
          %>
          <jsp:include page="/equipcommentForm.jsp" flush="true"></jsp:include>
          <%
          break;
          case com.hps.july.siteinfo.APPStates.ORGLOOKUP:
          %>
          <jsp:include page="/organizationLookupList.jsp" flush="true"></jsp:include>
          <%
          break;

        case com.hps.july.siteinfo.APPStates.RENTLOOKUP :
          %>
          <jsp:include page="/renterLookupList.jsp" flush="true"></jsp:include>
          <%
          break;
        case com.hps.july.siteinfo.APPStates.WRKLOOKUP :
          %>
          <jsp:include page="/workerLookupList.jsp" flush="true"></jsp:include>
          <%
          break;
        case com.hps.july.siteinfo.APPStates.CNTRLOOKUP :
          %>
          <jsp:include page="/controllerLookupList.jsp" flush="true"></jsp:include>
          <%
          break;
        case com.hps.july.siteinfo.APPStates.SWCHLOOKUP :
          %>
          <jsp:include page="/switchLookupList.jsp" flush="true"></jsp:include>
          <%
          break;
        case com.hps.july.siteinfo.APPStates.CLNLOOKUP :
          %>
          <jsp:include page="/comlineLookupList.jsp" flush="true"></jsp:include>
          <%
          break;
        case com.hps.july.siteinfo.APPStates.POSLOOKUP :
          %>
          <jsp:include page="/positionLookupList.jsp" flush="true"></jsp:include>
          <%
          break;
        case com.hps.july.siteinfo.APPStates.EPOSPRINT :
          %>
          <jsp:include page="/epositionPrint.jsp" flush="true"></jsp:include>
          <%
          break;
        case com.hps.july.siteinfo.APPStates.ORGPRINT :
          %>
          <jsp:include page="/organizationPrint.jsp" flush="true"></jsp:include>
          <%
          break;
		case com.hps.july.siteinfo.APPStates.STREET:
          %>
          <jsp:include page="/streetLookupList.jsp" flush="true"></jsp:include>
          <%
          break;
		case com.hps.july.siteinfo.APPStates.SUBWAY:
          %>
          <jsp:include page="/subwayLookupList.jsp" flush="true"></jsp:include>
          <%
          break;
		case com.hps.july.siteinfo.APPStates.JOURNAL_LIST:
		  %>
		  <jsp:include page="/journalList.jsp" flush="true"></jsp:include>
		  <%
		  break;
		case com.hps.july.siteinfo.APPStates.JOURNAL_VIEW:
		  %>
		  <jsp:include page="/journalForm.jsp" flush="true"></jsp:include>
		  <%
		  break;

        default:
          %>
          <jsp:include page="/siteinfo.jsp" flush="true"></jsp:include>
          <%
          break;
        }
		  break;



        default:
            //out.println("State='" + state + "'<BR>");
			%>
			<jsp:include page="/error.jsp" flush="true"></jsp:include>
			<%
			break;
		}

	%>
</body>
</html>
