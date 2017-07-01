<%@ page language = "java" %>
<%@ page import="java.util.*,java.math.*,com.hps.july.inventory.formbean.*,org.apache.struts.util.*" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "1"; %>

<table class="main">
<tr class="title">
	<td class="title" colspan="<%= gColSpan %>">
		<july:currmark><bean:message key="label.report8params"/></july:currmark>
	</td>
</tr>

<tr class="normal">
	<td colspan="<%= gColSpan %>">
		<table class="find">
		<tr>
			<td class="title">&nbsp;</td>
			<td class="title">&nbsp;</td>
		</tr> 
		</table>
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>" />

<tr class="title">
	<td colspan="<%= gColSpan %>">
		<table class="buttons">
		<tr class="title">
			<td class="buttons"><july:backbutton page="/Report8Params.do"/></td>
		</tr>
		</table>
	</td>
</tr>
        
<july:separator colspan="<%= gColSpan %>" />

<!-- Table header -->
<tr class="title">
	<td>
<%
	Report8ParamsForm rp = (Report8ParamsForm)session.getAttribute("Report8ParamsForm");

	String p = "resserial";
	switch(rp.getAgregationType()) {
	case 1:
		p += "a.rpt?dll=pdsresserial.dll";
		break;
	case 2:
		p += "b.rpt?dll=pdsresserial.dll";
		break;
	default:
		p += ".rpt?dll=pdsresserial.dll";
	}
	p += "&prompt0=0";
if(rp.getSerial() != null) {
	p += "&prompt1="+java.net.URLEncoder.encode(rp.getSerial().trim());
} else {
	p += "&prompt1=";
}
	p += "&prompt2="+rp.getShowAgregated();
%>
	<july:report report="<%=p%>"/>
<%--=p--%>
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>" />

<tr class="title">
	<td colspan="<%= gColSpan %>">
		<table class="buttons">
		<tr class="title">
			<td class="buttons"><july:backbutton page="/Report8Params.do"/></td>
		</tr>
		</table>
	</td>
</tr>
        
<july:separator colspan="<%= gColSpan %>" />
      
<tr class="title">
	<td class="title" colspan="<%= gColSpan %>">
		<july:currmark><bean:message key="label.report8params"/></july:currmark>
	</td>
</tr>
        
</table>
