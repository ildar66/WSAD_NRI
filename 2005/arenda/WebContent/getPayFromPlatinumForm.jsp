<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.arenda.*,com.hps.july.arenda.formbean.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>


<%
	String form = null;
	String backbutton = null;
	String message = null;
	switch (ParamsParser.getState(pageContext)) {
		case APPStates.PLATINUM_GETPAYFROMPLATINUM:
			form = "GetPayFromPlatinumForm";
			backbutton = "/ShowPaymentsList.do";
        	break;
		case APPStates.PLATINUM_HISTORY_GETPAYFROMPLATINUM:
			form = "HistoryGetPayFromPlatinumForm";
			backbutton = "/ShowHistoryPaymentsList.do";
        	break;
    }
%>


<table class="main">


	<tr class="normal">
		<td class="text">&nbsp;</td>
	</tr>


	<tr class="normal">
	
		<logic:equal name="<%= form %>" property="isSuccess" value="true">
			<% message = "label.payments.getpayfromplatinum.success"; %>
		</logic:equal>
		<logic:equal name="<%= form %>" property="isSuccess" value="false">
			<% message = "label.payments.getpayfromplatinum.error"; %>
		</logic:equal>
		
		<td class="text"><bean:message key="<%= message %>"/></td>
	</tr>
	
	<tr class="normal">
		<td class="text">&nbsp;</td>
	</tr>
	
	<july:separator/>
	
	<tr class="title">
		<td>
			<table class="buttons">
				<tr class="title"><td class="buttons"><july:backbutton page="<%= backbutton %>"/></td></tr>
			</table>
		</td>
	</tr>
	
	<july:separator/>
	
</table>

