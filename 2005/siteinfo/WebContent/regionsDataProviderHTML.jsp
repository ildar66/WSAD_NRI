<%@ page language="java" %>
<%@ page import="java.util.*" %>
<%@ page import="com.hps.july.siteinfo.valueobject.Regions" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%
	response.setHeader("Pragma", "No-cache");
	response.setHeader("Cache-Control", "no-cache");
	response.setDateHeader("Expires", 1);

	String listType = request.getParameter("lt");
	String srs = request.getParameter("sr");
	String rgs = request.getParameter("rg");
	String nzs = request.getParameter("nz");

	String ruser = request.getRemoteUser();
	boolean admin = request.isUserInRole("administrator");
%>
<html><body>
<form name="params" method="POST" action="regionsDataProviderHTML.jsp">
ListType:<input type="text" name="lt" value="<%=listType%>"><br>
Superregions:<input type="text" name="sr" value="<%=srs%>"><br>
Regions:<input type="text" name="rg" value="<%=rgs%>"><br>
Netzones:<input type="text" name="nz" value="<%=nzs%>"><br>
<input type="Submit" name="Submit" value="Submit">
</form>
<select id="content"><%=Regions.getOptionsList(listType,srs,rgs,nzs,ruser,admin)%></select>
</body>
</html>
