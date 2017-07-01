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
	switch (ParamsParser.getState(pageContext)) {
		case APPStates.ARENDA_POS_EDIT:
        	action = "/ProcessArendaPosition.do";
			form = "ArendaPositionForm";
			parent = "/ViewWeArenda.do";
			parent2 = "/ShowArendaPositionsList.do";
        	break;
		case APPStates.HISTORY_ARENDA_POS_EDIT:
        	action = "/ProcessHistoryArendaPosition.do";
			form = "HistoryArendaPositionForm";
			parent = "/ViewHistory.do";
			parent2 = "/ShowHistoryArendaPositionsList.do";
        	break;
    }
%>
<july:editform action="<%= action %>" styleId="<%= form %>">
<html:hidden property="leaseDocumentcode"/>
<table class="main">
<%--
<tr class="title">
		<td class="title" colspan="<%= gColSpan %>">
			<html:link page="/ShowWeArendaList.do" styleClass="navigator"><bean:message key="label.we"/></html:link>
			<july:sepmark/>
			<% if (ParamsParser.getState(pageContext) == APPStates.HISTORY_ARENDA_POS_EDIT) { %>
				<html:link page="/ShowHistoryList.do" styleClass="navigator"><bean:message key="label.history"/></html:link>
				<july:sepmark/>
			<% } %>
			<july:editlink page="<%= parent %>" action="View" styleClass="navigator"><%-- paramId="leaseDocument" paramName="<%= form %>" paramProperty="leaseDocumentcode" --%>
				<bean:message key="label.view"/>
			</july:editlink>
			<july:sepmark/>
			<html:link page="<%= parent2 %>" styleClass="navigator"><bean:message key="label.positions"/></html:link>
			<july:sepmark/> 
			<july:actionname/></td>
	</tr>
--%>
<july:separator colspan="<%= gColSpan %>"/>
    <tr>
        <td class="title" colspan="<%= gColSpan %>"><july:actionalert/></td>
    </tr>
 	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text">
			<july:reqmark><bean:message key="label.filter.position"/>:</july:reqmark>
		</td>
		<td class="text">
			<july:string property="positioncodeFrm" styleId="positioncode" size="5" insertable="true" updatable="true"/>
			<july:lookupbutton action="/ShowPositionLookupList.do" styleId="posl" fieldNames="positioncode;positionname" insertable="true" updatable="true"/>
			<july:string size="50" property="positionname" styleId="positionname" insertable="false" updatable="false"/>
		</td>
	</tr>
	<july:separator colspan="<%= gColSpan %>"/>
	<july:formbuttons/>
	<july:separator colspan="<%= gColSpan %>"/>
</table>
</july:editform>