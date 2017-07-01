<%@ page language = "java" %>

<%@ page import="java.util.*,com.hps.july.arenda.formbean.*,org.apache.struts.util.*,com.hps.july.persistence.*" %>

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

			<july:currmark><bean:message key="label.report11"/></july:currmark>

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

				<tr class="title"><td class="buttons"><july:backbutton page="/ArendaReport11Params.do"/></td></tr>

			</table>

		</td>

	</tr>



	<july:separator colspan="<%= gColSpan %>"/>



	<tr class="title">

		<td>

			<%	ArendaReport11ParamsForm rp = (ArendaReport11ParamsForm) session.getAttribute("ArendaReport11ParamsForm");

				String p = "repWarningAkt.rpt?dll=pdsarenda11.dll";

				

				WorkerAccessBean workerBean = new WorkerAccessBean();

				workerBean.setInitKey_worker(rp.getEconomistcode().intValue());

				workerBean.refreshCopyHelper();

				p += "&prompt0=" + workerBean.getManKey().man;

				

				java.sql.Date date = rp.getDate();

				p += "&prompt1=Date(" + (date.getYear() + 1900) + "," + (date.getMonth() + 1) + "," + date.getDate() + ")"; %>

			<july:report report="<%= p %>"/>

		</td>

	</tr>



	<july:separator colspan="<%= gColSpan %>"/>



	<tr class="title">

		<td colspan="<%= gColSpan %>">

			<table class="buttons">

				<tr class="title"><td class="buttons"><july:backbutton page="/ArendaReport11Params.do"/></td></tr>

			</table>

		</td>

	</tr>



	<july:separator colspan="<%= gColSpan %>"/>



<%--
<tr class="title">

		<td class="title" colspan="<%= gColSpan %>">

			<july:currmark><bean:message key="label.report11"/></july:currmark>

		</td>

	</tr>
--%>



</table>

