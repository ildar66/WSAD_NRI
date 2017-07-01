<%@ page language = "java" %>
<%@ page import="java.util.*,com.hps.july.siteinfo.actionbean.MapHandlingBean,
                 com.hps.july.siteinfo.manager.Constants" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<html>
<head>
<title></title>
</head>
<script language="JavaScript">
<!--
    onload = function(e) {
        <% MapHandlingBean mhb = (MapHandlingBean)session.getAttribute(Constants.MAP_HANDLING_BEAN);
            if(mhb != null) { %>
            var zoom = <%=mhb.getZoom()%>;
            parent.createScroll(zoom);
        <%} %>
    }
-->
</script>
<body>
</body>
</html>
