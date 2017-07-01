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
		<july:currmark><bean:message key="label.barsreportparams"/></july:currmark>
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
			<td class="buttons"><july:backbutton page="/BarSParams.do"/></td>
		</tr>
		</table>
	</td>
</tr>
        
<july:separator colspan="<%= gColSpan %>" />

<!-- Table header -->
<tr class="title">
	<td>
		<SCRIPT LANGUAGE="VBScript">
		   set lvapp = CreateObject("LabelVision.Application")
		   set label = lvapp.OpenLabel("C:\beeline\serial1.lbx")

			<%
				BarSParamsForm rp = (BarSParamsForm)session.getAttribute("BarSParamsForm");

				String serial = rp.getSerial();
				int crepeat = rp.getRepeatcount().intValue();
				for (int j=0; j<crepeat; j++) {

			%>

		     label.LabelFields("serno").Value = "<%= serial %>"
		     label.PrintOut(false)

			<%
				}
			%>

		   lvapp.Quit
		</SCRIPT>
		<bean:message key="label.barsreport.printed"/>
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>" />

<tr class="title">
	<td colspan="<%= gColSpan %>">
		<table class="buttons">
		<tr class="title">
			<td class="buttons"><july:backbutton page="/BarSParams.do"/></td>
		</tr>
		</table>
	</td>
</tr>
        
<july:separator colspan="<%= gColSpan %>" />
      
<tr class="title">
	<td class="title" colspan="<%= gColSpan %>">
		<july:currmark><bean:message key="label.barsreportparams"/></july:currmark>
	</td>
</tr>
        
</table>
