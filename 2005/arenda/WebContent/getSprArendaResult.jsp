<%@ page language = "java" %> 
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.arenda.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>


<%	String message = null; %>


<%
	String form = null;
	String parent = null;
	String what = null;
	switch (ParamsParser.getState(pageContext)) {
		case APPStates.GET_SPR_ARENDA_RESULT:
			form = "GetSprArendaResultForm";
			parent = "/GetSprArenda.do";
			what = "getsprarenda";
        	break;
		case APPStates.GET_BANKS_RESULT:
			form = "GetBanksResultForm";
			parent = "/GetBanks.do";
			what = "getbanks";
        	break;
		case APPStates.GET_PAYS_RESULT:
			form = "GetPaysResultForm";
			parent = "/GetPays.do";
			what = "getpays";
        	break;
    }
%>


<table class="main">


	<tr class="normal">
		<td class="text">&nbsp;</td>
	</tr>
	
	<tr class="normal">
		<logic:present name="<%= form %>" property="isSuccess">
			<logic:equal name="<%= form %>" property="isSuccess" value="true">
				<% message = "label." + what + ".success"; %>
			</logic:equal>
			<logic:equal name="<%= form %>" property="isSuccess" value="false">
				<% message = "label." + what + ".error"; %>
			</logic:equal>
		</logic:present>
		<logic:notPresent name="<%= form %>" property="isSuccess">
			<% message = "label.getfrompie.nostateconst"; %>
		</logic:notPresent>
		
		<td class="text"><bean:message key="<%= message %>"/></td>
	</tr>
	
	<tr class="normal">
		<td class="text">&nbsp;</td>
	</tr>
	
	<july:separator/>
	
	<tr class="title">
		<td>
			<table class="buttons">
				<tr class="title"><td class="buttons"><july:backbutton page="<%= parent %>"/></td></tr>
			</table>
		</td>
	</tr>
	
	<july:separator/>
	
</table>