<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>

<%
String number = request.getParameter("number");
String compid = request.getParameter("compid");
String compl = compid + number;
String idc = request.getParameter("idc");
%>

<SCRIPT language="JScript">
	function open_window_<%= compl%>() {
		myWindow = window.open("/dict/ShowInvResourceListWN.do?category=<%=idc%>", "newWindow", "top=40, left=100, width=830, height=630, scrollbars=yes, resizable=yes");  
		myWindow.focus();
	}
</SCRIPT>				
				
<A HREF="#" name="lookupbtn_style" onclick="open_window_<%= compl%>(); return false;"><img name="lookupimg_style" src="/images/lookup.gif" border="0" alt="Справочник"></A>