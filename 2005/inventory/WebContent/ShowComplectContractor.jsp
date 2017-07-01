<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>

<%
String number = request.getParameter("number");
String compid = request.getParameter("compid");
String compl = compid + number;
String eq = compid + "[" + number + "]";
%>

<SCRIPT language="JScript"> 
	var opt_params_<%= compl%> = ""; 
	function set_opt_params_<%= compl%>(paramStr) {  
		opt_params_<%= compl%> = paramStr;
	}
	function onselect_<%= compl%>() {}
	function lookup_params_<%= compl%>() { 
		myWindow.execScript("setParams('thefirstform', '<%= eq+".complect"%>', '<%= eq+".complectname"%>')");  myWindow.execScript("setCallerId('<%= compl%>')");  return 0;
	}
	function lookup_<%= compl%>() {
		if(document.all['lookupimg_<%= compl%>'].src.substr(document.all['lookupimg_<%= compl%>'].src.length-12,12) == 'disabled.gif') { return; }   
		String.prototype.lookup = lookup_params_<%= compl%>;  
		myWindow = window.open("/inventory/ShowComplectLookupList.do" + opt_params_<%= compl%>, "poslookup", "top=40, left=100, width=830, height=630, scrollbars=yes, resizable=yes"); 
		myWindow.focus();
}
</SCRIPT>
<A HREF="#" name="lookupbtn_<%= compl%>" onclick="set_opt_params_<%= compl%>('?position='+document.all.positioncode.value);lookup_<%= compl%>(); return false;">
<img name="lookupimg_<%= compl%>" src="/images/lookup.gif" border="0" alt="Справочник"></A>