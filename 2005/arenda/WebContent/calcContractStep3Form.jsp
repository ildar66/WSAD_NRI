<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.arenda.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "2"; %>

<%

	String form = null;
	String parent = null;
	String parent2 = null;
	String parent3 = null;
	String temp = null;
	switch (ParamsParser.getState(pageContext)) {

		case APPStates.CALC_CONTRACT_STEP3:

			form = "CalcContractStep3Form";

			parent = "/ViewWeArenda.do";

			parent2 = "/EditCalcContractStep1.do";

			parent3 = "/EditCalcContractStep2.do";

        	break;

		case APPStates.HISTORY_CALC_CONTRACT_STEP3:

			form = "HistoryCalcContractStep3Form";

			parent = "/ViewHistory.do";

			parent2 = "/EditHistoryCalcContractStep1.do";

			parent3 = "/EditHistoryCalcContractStep2.do";

        	break;

	}

%>



<table class="main">

<%--
<tr class="title">

		<td class="title" colspan="<%= gColSpan %>">

			<html:link page="/ShowWeArendaList.do" styleClass="navigator"><bean:message key="label.we"/></html:link>

			<july:sepmark/>

			<% if (ParamsParser.getState(pageContext) == APPStates.HISTORY_CALC_CONTRACT_STEP3) { %>

				<html:link page="/ShowHistoryList.do" styleClass="navigator"><bean:message key="label.history"/></html:link>

				<july:sepmark/>

			<% } %>

			<july:editlink page="<%= parent %>" action="View" styleClass="navigator">

				<bean:message key="label.view"/>

			</july:editlink>

			<july:sepmark/>

			<july:editlink page="<%= parent2 %>" action="Add" styleClass="navigator"><bean:message key="label.contractcalc.step1"/></july:editlink>

			<july:sepmark/>

			<july:editlink page="<%= parent3 %>" action="Add" styleClass="navigator"><bean:message key="label.contractcalc.step2"/></july:editlink>

			<july:sepmark/>

			<july:currmark><bean:message key="label.contractcalc.step3"/></july:currmark>

		</td>

	</tr>
--%>

	
 	<july:separator colspan="<%= gColSpan %>"/>

	<tr>
		<td class="link">
			<html:link page="/../crystalclear/AccountDogovor.rpt?dll=pdsaccdog.dll" name="<%= form %>" property="prompts" paramScope="page" onclick="window.open(this.href, 'aa', 'top=100, left=100, width=700, height=500, scrollbars=yes, resizable=yes'); return false;">
				<bean:message key="label.contractcalc.report"/>
			</html:link>
		</td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>

	<tr class="title">
		<td class="title" colspan="<%= gColSpan %>">
			<html:link page="/EditCalcContractStep2.do?action=Add"><img src="/images/cancel.gif" border=0 alt=""></html:link>
		</td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>

</table>
