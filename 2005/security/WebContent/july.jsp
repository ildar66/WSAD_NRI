<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.constants.*,com.hps.july.security.*" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<%@include file="initProfile.jspf"%>

<html> 
<head>
	<META HTTP-EQUIV = "Pragma" CONTENT="no-cache"> 
	<title>Система разграничения доступа</title>
	<link rel="stylesheet" type="text/css" href="/main.css">
</head>

<body id="abody" onload="document.body.style.cursor='auto';">
<script language="JavaScript">
	document.body.style.cursor="wait";
</script>
<july:licence licence="/comctl2.lpk" />
	<%
	int app = ParamsParser.getApplication( pageContext );
	int state = ParamsParser.getState( pageContext );
	switch( app ) {
	  case Applications.SECURITY:
      switch( state )
        {
        case APPStates.COMPLOOKUP :
          %>
          <jsp:include page="/companyLookupList.jsp" flush="true"></jsp:include>
          <%
          break;
        case APPStates.DIRLOOKUP  :
          %>
          <jsp:include page="/directionLookupList.jsp" flush="true"></jsp:include>
          <%
          break;
        case APPStates.SERVLOOKUP :
          %>
          <jsp:include page="/serviceLookupList.jsp" flush="true"></jsp:include>
          <%
          break;
        case APPStates.DEPLOOKUP  :
          %>
          <jsp:include page="/departmentLookupList.jsp" flush="true"></jsp:include>
          <%
          break;
        case APPStates.GRPLOOKUP  :
          %>
          <jsp:include page="/groupLookupList.jsp" flush="true"></jsp:include>
          <%
          break;
        case APPStates.ROLELIST  :
          %>
          <jsp:include page="/roleLookupList.jsp" flush="true"></jsp:include>
          <%
          break;
        case APPStates.WRKLOOKUP  :
          %>
          <jsp:include page="/workerLookupList.jsp" flush="true"></jsp:include>
          <%
          break;
        case APPStates.WPOSLOOKUP  :
          %>
          <jsp:include page="/workPositionLookupList.jsp" flush="true"></jsp:include>
          <%
          break;
        case APPStates.PPLLOOKUP  :
          %>
          <jsp:include page="/peopleLookupList.jsp" flush="true"></jsp:include>
          <%
          break;
        case APPStates.OPERLOOKUP  :
          %>
          <jsp:include page="/operatorLookupList.jsp" flush="true"></jsp:include>
          <%
          break;
        case APPStates.DIVLOOKUP  :
          %>
          <jsp:include page="/selectDivisionLookup.jsp" flush="true"></jsp:include>
          <%
          break;
        case APPStates.NFS_USERS_LOOKUP_LIST  :
          %>
          <jsp:include page="/nfs_UsersLookupList.jsp" flush="true"></jsp:include>
          <%
          break;
        case APPStates.OPERATOR_2_ROLE_DIALOG  :
          %>
          <jsp:include page="/operator2roleDialog.jsp" flush="true"></jsp:include>
          <%
          break;          
                    
        default:
          %>
          <jsp:include page="/security.jsp" flush="true"></jsp:include>
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
