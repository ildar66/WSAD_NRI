<%@ page language = "java" %>

<%@ page import="java.util.*,java.math.*,com.hps.july.arenda.formbean.*,org.apache.struts.util.*,com.hps.july.persistence.*" %>

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

			<july:currmark><bean:message key="label.report10"/></july:currmark>

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

				<tr class="title"><td class="buttons"><july:backbutton page="/ArendaReport10Params.do"/></td></tr>

			</table>

		</td>

	</tr>



	<july:separator colspan="<%= gColSpan %>"/>



	<tr class="title">

		<td>

			<%	ArendaReport10ParamsForm rp = (ArendaReport10ParamsForm) session.getAttribute("ArendaReport10ParamsForm");

				String p = "repWarningProlong.rpt?dll=pdswarningprolong.dll";

				

				if (rp.getEconomistcode() != null) {

					WorkerAccessBean wBean = new WorkerAccessBean();

					wBean.setInitKey_worker(rp.getEconomistcode().intValue());

					wBean.refreshCopyHelper();

					p += "&prompt0=" + wBean.getManKey().man;

				} else {

					p += "&prompt0=null";

				}

				p += "&prompt1=Date(" + (rp.getDate().getYear() + 1900) + "," + (rp.getDate().getMonth() + 1) + "," + rp.getDate().getDate() + ")"; %>

			

			<july:report report="<%= p %>"/>

		</td>

	</tr>



	<july:separator colspan="<%= gColSpan %>"/>



	<tr class="title">

		<td colspan="<%= gColSpan %>">

			<table class="buttons">

				<tr class="title"><td class="buttons"><july:backbutton page="/ArendaReport10Params.do"/></td></tr>

			</table>

		</td>

	</tr>



	<july:separator colspan="<%= gColSpan %>"/>



<%--
<tr class="title">

		<td class="title" colspan="<%= gColSpan %>">

			<july:currmark><bean:message key="label.report10"/></july:currmark>

		</td>

	</tr>
--%>



</table>

