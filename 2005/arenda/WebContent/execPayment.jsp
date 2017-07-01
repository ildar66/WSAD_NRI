<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.arenda.formbean.*,com.hps.july.arenda.sessionbean.*,com.hps.july.persistence.*" %>
<%@ page import="com.hps.july.commonbean.*,java.sql.*,java.util.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>



<table class="main">

	<july:separator/>

	<tr>
		<td class="text"><bean:message key="label.autoproc.payments.start"/></td>
	</tr>

	<july:separator/>

<%
	out.flush();
	StartPaymentForm form = ((StartPaymentForm) request.getSession().getAttribute("StartPaymentForm"));
	
	Integer economist = null;
	Integer contract = null;
	int operator = 0; // only for wte!!! set operator = 0 for ws!!!
	
	if (form.getCondition().equals("E")) {
		economist = form.getEconomistcode();
	} else if (form.getCondition().equals("C")) {
		contract = form.getLeaseDocumentcode();
	}
	
	try {
		operator = new OperatorAccessBean().findByLogin(request.getUserPrincipal().getName()).getOperator();
	} catch (Exception ex) {
		ex.printStackTrace();
	}


	try {
		String forward = "/ShowJournalPaymentsList.do?taskStartcode=" + new ArendaDocumentProcessorAccessBean().makeAutomaticPayments(
			form.getDate1(), form.getDate2(), economist, contract, new Integer(operator));
%>
	<tr>
		<td class="text"><bean:message key="label.autoproc.payments.finish"/></td>
	</tr>
	<tr>
		<td class="text">&nbsp;</td>
	</tr>

	<july:separator/>

	<tr>
		<td class="text"><july:link page="<%= forward %>"><bean:message key="label.journal.view"/></july:link></td>
	</tr>


<%	} catch (java.rmi.RemoteException e) { %>


	<tr>
		<td class="text"><bean:message key="label.autoproc.payments.error"/></td>
	</tr>
	
<%	} %>

	<july:separator/>

	<tr class="title">
		<td class="text" colspan="2"><july:backbutton/></td>
	</tr>

	<july:separator/>

</table>

