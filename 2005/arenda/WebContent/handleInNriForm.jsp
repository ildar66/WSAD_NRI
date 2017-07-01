<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.arenda.*,com.hps.july.arenda.formbean.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>


<%
	String gColSpan = "2";
	String action = null;
	String form = null;
	String parent = null;
	String parentMsg = null;
	String hiddenField = null;
	String journal = null;
	switch (ParamsParser.getState(pageContext)) {
		case APPStates.ABONENT_BILL_HANDLE_INNRI:
			action = "/ProcessBillHandleInNRI.do";
			form = "BillHandleInNRIForm";
			parent = "/ShowAbonentBillsList.do";
			parentMsg = "label.abonents.paybill";
			hiddenField = "leaseBill";
			journal = "/ShowFromBillHandleInNRIJournalBillList.do";
			break;
		case APPStates.ABONENT_PAY_HANDLE_INNRI:
			action = "/ProcessPayHandleInNRI.do";
			form = "PayHandleInNRIForm";
			parent = "/ShowAbonentPaysList.do";
			parentMsg = "label.abonent.pays";
			hiddenField = "paypos";
			journal = "/ShowFromPayHandleInNRIJournalBillList.do";
			break;
    }
%>


<july:editform action="<%= action %>" styleId="<%= form %>">


<html:hidden property="<%= hiddenField %>"/>
<html:hidden property="isA"/>
<html:hidden property="isB"/>
<html:hidden property="taskcode"/>


<table class="main">
<%--
<tr class="title">
		<td class="title" colspan="<%= gColSpan %>">
			<html:link page="/ShowAbonentsList.do" styleClass="navigator"><bean:message key="label.abonents"/></html:link>
			<july:sepmark/>
			<july:editlink page="/ViewAbonent.do" action="View" styleClass="navigator"><bean:message key="label.view"/></july:editlink>
			<july:sepmark/>
			<html:link page="<%= parent %>" styleClass="navigator"><bean:message key="<%= parentMsg %>"/></html:link>
			<july:sepmark/>
			<july:currmark><bean:message key="label.change"/></july:currmark>
		</td>
	</tr>
--%>

    <july:separator colspan="<%= gColSpan %>"/>
    
    <tr>
        <td class="title" colspan="<%= gColSpan %>"><july:currmark><bean:message key="label.change"/></july:currmark></td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>


	<logic:notEqual name="<%= form %>" property="taskcode" value="0">


		<tr>
			<td class="text">&nbsp;</td>
			<td class="text">
				<july:link page="<%= journal %>" name="<%= form %>" property="params" scope="request">
					<bean:message key="label.abonent.journal"/>
				</july:link>
			</td>
		</tr>
		
		<tr><td class="text" colspan="<%= gColSpan %>">&nbsp;</td></tr>
		
	</logic:notEqual>
	
	<tr>
		<td class="text">&nbsp;</td>
		<td class="text">
			<% String valueA = "false"; %>
			<logic:equal name="<%= form %>" property="isA" value="true"><% valueA = "true"; %></logic:equal>
			<% String valueB = "false"; %>
			<logic:equal name="<%= form %>" property="isB" value="true"><% valueB = "true"; %></logic:equal>
			
			<july:radio property="doHandle" insertable="<%= valueA %>" updatable="<%= valueA %>" value="A"/><bean:message key="label.abonent.useincalcact"/><br>
			<july:radio property="doHandle" insertable="<%= valueB %>" updatable="<%= valueB %>" value="B"/><bean:message key="label.abonent.notuseincalcact"/>
		</td>
	</tr>
	
	<july:separator/>
	
	<july:formbuttons/>
	
	<july:separator/>


</table>


</july:editform>

