<%@ page language = "java" %>

<%@ page import="java.util.*,java.math.*,com.hps.july.arenda.formbean.*,org.apache.struts.util.*" %>

<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>

<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>



<% java.lang.String gColSpan = "1"; %>



<table class="main">

<%--
<tr class="title">

		<td class="title" colspan="<%= gColSpan %>">

			<july:currmark><bean:message key="label.report2"/></july:currmark>

		</td>

	</tr>
--%>



	<tr class="normal">
		<td colspan="<%= gColSpan %>">&nbsp;</td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>

	<tr class="title">
		<td colspan="<%= gColSpan %>">
			<table class="buttons">
				<tr class="title"><td class="buttons"><july:backbutton page="/ArendaReport2Params.do"/></td></tr>
			</table>
		</td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>

	<tr class="title">
		<td>
			<%	ArendaReport2ParamsForm rp = (ArendaReport2ParamsForm) session.getAttribute("ArendaReport2ParamsForm");
				String p = "ArendaReport2.rpt?dll=pdsarenda2.dll";
				p += "&prompt0=Date(" + (rp.getDate().getYear() + 1900) + "," + (rp.getDate().getMonth() + 1) + "," + rp.getDate().getDate() + ")"; %>
			<july:report report="<%= p %>"/>
		</td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>

	<tr class="title">
		<td colspan="<%= gColSpan %>">
			<table class="buttons">
				<tr class="title"><td class="buttons"><july:backbutton page="/ArendaReport2Params.do"/></td></tr>
			</table>
		</td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>

<%--
<tr class="title">

		<td class="title" colspan="<%= gColSpan %>">

			<july:currmark><bean:message key="label.report2"/></july:currmark>

		</td>

	</tr>
--%>



</table>

