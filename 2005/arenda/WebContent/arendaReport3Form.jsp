<%@ page language = "java" %>
<%@ page import="java.util.*,java.math.*,com.hps.july.arenda.formbean.*,org.apache.struts.util.*" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%--
<% java.lang.String gColSpan = "1"; %>

<table class="main">




	<tr class="normal">
		<td colspan="<%= gColSpan %>">&nbsp;</td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>

	<tr class="title">
		<td colspan="<%= gColSpan %>">
			<table class="buttons">
				<tr class="title"><td class="buttons"><july:backbutton page="/ArendaReport3Params.do"/></td></tr>
			</table>
		</td>
	</tr>


	<july:separator colspan="<%= gColSpan %>"/>


	<tr class="title">
		<td>
			<%	ArendaReport3ParamsForm rp = (ArendaReport3ParamsForm) session.getAttribute("ArendaReport3ParamsForm");
				String p = "ArendaReport3.rpt?dll=pdsarenda3.dll";
				p += "&prompt0=Date(" + (rp.getStartdate().getYear() + 1900) + "," + (rp.getStartdate().getMonth() + 1) + "," + rp.getStartdate().getDate() + ")"; 
				p += "&prompt1=Date(" + (rp.getFinishdate().getYear() + 1900) + "," + (rp.getFinishdate().getMonth() + 1) + "," + rp.getFinishdate().getDate() + ")"; %>
			<july:report report="<%= p %>"/>
		</td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>

	<tr class="title">
		<td colspan="<%= gColSpan %>">
			<table class="buttons">
				<tr class="title"><td class="buttons"><july:backbutton page="/ArendaReport3Params.do"/></td></tr>
			</table>
		</td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>





</table>
--%>
