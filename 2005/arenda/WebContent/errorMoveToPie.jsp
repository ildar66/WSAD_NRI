<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.arenda.*,com.hps.july.arenda.formbean.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>



<%

	String backbutton = null;
	String message = null;
	String msgErrorPie = null;
	switch (ParamsParser.getState(pageContext)) {
		case APPStates.PLATINUM_ERROR_MOVECONTRACTTOPIE:
			backbutton = "/ShowWeArendaList.do";
			message = "error.invalid.platinum.movecontracttopie";
			msgErrorPie = "errorMoveContractToPie";
        	break;
		case APPStates.PLATINUM_ERROR_HISTORY_MOVECONTRACTTOPIE:
			backbutton = "/ShowHistoryList.do";
			message = "error.invalid.platinum.movecontracttopie";
			msgErrorPie = "errorHistoryMoveContractToPie";
        	break;
		case APPStates.PLATINUM_ERROR_MOVEPAYTOPIE:
			backbutton = "/ShowPaymentsList.do";
			message = "error.invalid.platinum.movepaytopie";
			msgErrorPie = "errorMovePayToPie";
        	break;
		case APPStates.PLATINUM_ERROR_HISTORY_MOVEPAYTOPIE:
			backbutton = "/ShowHistoryPaymentsList.do";
			message = "error.invalid.platinum.movepaytopie";
			msgErrorPie = "errorHistoryMovePayToPie";
        	break;
    }

%>



<table class="main">

	<tr class="normal">
		<td class="text">&nbsp;</td>
	</tr>
	
	<tr class="normal">
		<td class="text"><bean:message key="<%= message %>"/></td>
	</tr>
	
	<tr class="normal">
		<td class="text">&nbsp;</td>
	</tr>
	
	<tr class="normal">
		<td class="text"><%= (String) request.getSession().getAttribute(msgErrorPie) %></td>
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

