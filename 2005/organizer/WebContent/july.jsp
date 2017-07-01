<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.constants.*,com.hps.july.organizer.*" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<%@include file="initProfile.jspf"%>

<html>
<head>
 <META HTTP-EQUIV = "Pragma" CONTENT="no-cache">
 <title>¬ход в систему</title>
 <link rel="stylesheet" type="text/css" href="/main.css">
</head>

<body>
<july:licence licence="/comctl2.lpk" />
	<%
	int app = ParamsParser.getApplication( pageContext );
	int state = ParamsParser.getState( pageContext );
	switch( app ) {
	  case Applications.ORGANIZER:
          switch( state )
            {
            case APPStates.LOGIN  :
              %>
              <jsp:include page="/loginForm.jsp" flush="true"></jsp:include>
              <%
              break;
    		case APPStates.REREGISTER:
    			%>
    			<jsp:include page="/reregisterForm.jsp" flush="true"></jsp:include>
    			<%
    			break;
            default:
              %>
              <jsp:include page="/organizerGraph.jsp" flush="true"></jsp:include>
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
