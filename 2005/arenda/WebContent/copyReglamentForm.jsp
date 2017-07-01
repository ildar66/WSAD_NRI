<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.arenda.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "2"; %>

<%

    String action = null;
	String form = null;
	String parent = null;
	String parent2 = null;
	String parent3 = null;
	String parent4 = null;

	switch (ParamsParser.getState(pageContext)) {

		case APPStates.COPY_REGLAMENT:

        	action = "/ProcessCopyReglament.do";

			form = "CopyReglamentForm";

			parent2 = "/ShowMutualReglamentsList.do";

			parent3 = "/ViewMainParamsMutReglmnt.do";

			parent4 = "/ShowContractsMutReglmntList.do";

        	break;

		case APPStates.FROMCONTRACT_COPY_REGLAMENT:

        	action = "/ProcessFromContractCopyReglament.do";

			form = "FromContractCopyReglamentForm";

			parent = "/ViewWeArenda.do";

			parent2 = "/ShowFromContractMutualReglamentsList.do";

			parent3 = "/ViewFromContractMainParamsMutReglmnt.do";

			parent4 = "/ShowFromContractContractsMutReglmntList.do";

        	break;

		case APPStates.FROMHISTORY_COPY_REGLAMENT:

        	action = "/ProcessFromHistoryCopyReglament.do";

			form = "FromHistoryCopyReglamentForm";

			parent = "/ViewHistory.do";

			parent2 = "/ShowFromHistoryMutualReglamentsList.do";

			parent3 = "/ViewFromHistoryMainParamsMutReglmnt.do";

			parent4 = "/ShowFromHistoryContractsMutReglmntList.do";

        	break;

    }

%>

<july:editform action="<%= action %>" styleId="<%= form %>">

<table class="main">

<%--
<tr class="title">

		<td class="title" colspan="<%= gColSpan %>">

			<%	if (ParamsParser.getState(pageContext) == APPStates.FROMCONTRACT_COPY_REGLAMENT ||

				ParamsParser.getState(pageContext) == APPStates.FROMHISTORY_COPY_REGLAMENT) { %>

				<html:link page="/ShowWeArendaList.do" styleClass="navigator"><bean:message key="label.we"/></html:link>

				<july:sepmark/>

				<%	if (ParamsParser.getState(pageContext) == APPStates.FROMHISTORY_COPY_REGLAMENT) { %>

					<html:link page="/ShowHistoryList.do" styleClass="navigator"><bean:message key="label.history"/></html:link>

					<july:sepmark/>

	        	<% } %>

				<july:editlink page="<%= parent %>" action="View" styleClass="navigator">

					<bean:message key="label.view"/>

				</july:editlink>

				<july:sepmark/>

			<%	} %>

			<html:link page="<%= parent2 %>" styleClass="navigator"><bean:message key="label.mutualreglmnts"/></html:link>

			<july:sepmark/>

			<july:editlink page="<%= parent3 %>" action="View&isShowMessage=0" styleClass="navigator">

				<bean:message key="label.view"/>

			</july:editlink>

			<july:sepmark/>

			<july:currmark><bean:message key="label.mutualreglmnts.copy"/></july:currmark>

		</td>

	</tr>
--%>

	
    <july:separator colspan="<%= gColSpan %>"/>

    <tr>
        <td class="title" colspan="<%= gColSpan %>">
			<bean:message key="label.mutualreglmnts.copy.query"/>
		</td>
    </tr>

 	<july:separator colspan="<%= gColSpan %>"/>

	<july:formbuttons/>

	<july:separator colspan="<%= gColSpan %>"/>

</table>

</july:editform>

