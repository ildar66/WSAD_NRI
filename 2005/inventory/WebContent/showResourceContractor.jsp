<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>

<%
String number = request.getParameter("number");
String compid = request.getParameter("compid");
String prefix = request.getParameter("prefix");
String compl = compid + prefix +  number;
String eq = compid + "[" + number + "]";
%>

<SCRIPT language="JScript"> 
	var opt_params_<%= compl%> = ""; 
	function set_opt_params_resl(paramStr) {  
		opt_params_<%= compl%> = paramStr;
	}
	function onselect_<%= compl%>() {}
	function lookup_params_<%= compl%>() {  
		myWindow.execScript("setParams('thefirstform', '<%= eq+".typename"%>', '<%= eq+".typename"%>')");  myWindow.execScript("setCallerId('<%= compl%>')");  return 0;
	}
	function lookup_<%= compl%>() {
		if(document.all['lookupimg_<%= compl%>'].src.substr(document.all['lookupimg_<%= compl%>'].src.length-12,12) == 'disabled.gif') { return; }   String.prototype.lookup = lookup_params_<%= compl%>;  myWindow = window.open("/inventory/ShowResourceLookupList.do" + opt_params_<%= compl%>, "resourcelookup", "top=40, left=100, width=830, height=630, scrollbars=yes, resizable=yes");  myWindow.focus();
	}
</SCRIPT>
<A HREF="#" name="lookupbtn_<%= compl%>" onclick="lookup_<%= compl%>(); return false;"><img name="lookupimg_<%= compl%>" src="/images/lookup.gif" border="0" alt="Справочник"></A>