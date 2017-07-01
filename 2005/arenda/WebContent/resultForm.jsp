<%@ page language = "java" %> 
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.arenda.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>


<%	String message = null; %>


<%
	String what = null;
	switch (ParamsParser.getState(pageContext)) {
		case APPStates.ABONENT_BILL_QUERY_TO_RESULT:
			what = "to";
        	break;
		case APPStates.ABONENT_BILL_QUERY_FROM_RESULT:
			what = "from";
        	break;
    }
%>


<table class="main">


	<tr class="normal">
		<td class="text">&nbsp;</td>
	</tr>
	
	<tr class="normal">
		<logic:equal name="ResultForm" property="isSuccess" value="true">
			<% message = "error.bill.query." + what + ".success"; %>
		</logic:equal>
		<logic:equal name="ResultForm" property="isSuccess" value="false">
			<% message = "error.bill.query." + what + ".error"; %>
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
				<tr class="title"><td class="buttons"><july:backbutton page="/AbonentBillQuery.do"/></td></tr>
			</table>
		</td>
	</tr>
	
	<july:separator/>
	
</table>