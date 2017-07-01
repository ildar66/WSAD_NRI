<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.arenda.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>


<% String gColSpan = "2"; %>


<%
    String action = null;
	String form = null;
	String parent = null;
	String parent2 = null;
	String parent3 = null;
	String parent4 = null;
	switch (ParamsParser.getState(pageContext)) {
		case APPStates.PHONE_MUTREGLMNT_EDIT:
        	action = "/ProcessPhoneMutReglmnt.do";
			form = "PhoneMutReglmntForm";
			parent2 = "/ShowMutualReglamentsList.do";
			parent3 = "/ViewMainParamsMutReglmnt.do";
			parent4 = "/ShowPhonesMutReglmntList.do";
        	break;
		case APPStates.FROMCONTRACT_PHONE_MUTREGLMNT_EDIT:
        	action = "/ProcessFromContractPhoneMutReglmnt.do";
			form = "FromContractPhoneMutReglmntForm";
			parent = "/ViewWeArenda.do";
			parent2 = "/ShowFromContractMutualReglamentsList.do";
			parent3 = "/ViewFromContractMainParamsMutReglmnt.do";
			parent4 = "/ShowFromContractPhonesMutReglmntList.do";
        	break;
		case APPStates.FROMHISTORY_PHONE_MUTREGLMNT_EDIT:
        	action = "/ProcessFromHistoryPhoneMutReglmnt.do";
			form = "FromHistoryPhoneMutReglmntForm";
			parent = "/ViewHistory.do";
			parent2 = "/ShowFromHistoryMutualReglamentsList.do";
			parent3 = "/ViewFromHistoryMainParamsMutReglmnt.do";
			parent4 = "/ShowFromHistoryPhonesMutReglmntList.do";
        	break;
    }
%>


<july:editform action="<%= action %>" styleId="<%= form %>">


<html:hidden property="leaseDocumentcode"/>


<table class="main">

	<july:separator colspan="<%= gColSpan %>"/>


	<tr>
		<td class="title" colspan="<%= gColSpan %>"><july:actionalert/></td>
	</tr>


	<july:separator colspan="<%= gColSpan %>"/>


	<tr>
		<td class="text">
			<july:reqmark><bean:message key="label.mutualreglmnts.docnumber"/>:</july:reqmark>
		</td>
		<td class="text">
			<july:string size="50" property="documentNumber" insertable="false" updatable="false" />
		</td>
	</tr>


	<july:separator colspan="<%= gColSpan %>"/>


	<tr>
		<td class="text"><july:reqmark><bean:message key="label.mutualreglmnts.docdate"/>:</july:reqmark></td>
		<td class="text">
			<july:date property="documentDateFrm" size="25" insertable="false" updatable="false" />
		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>	
	
	<tr>
		<td class="text">
			<july:reqmark><bean:message key="label.mutualreglmnts.acttype"/>:</july:reqmark>
		</td>
		<td class="text">
			<july:radio property="actType" insertable="false" updatable="false" value="A"/><bean:message key="label.mutualreglmnts.acttype.vz"/>
			<july:radio property="actType" insertable="false" updatable="false" value="M"/><bean:message key="label.mutualreglmnts.acttype.vt"/>
		</td>
	</tr>


	<july:separator colspan="<%= gColSpan %>"/>


	<tr>
		<td class="text"><july:reqmark><bean:message key="label.mutualreglmnts.mutualperiod"/>:</july:reqmark></td>
		<td class="text">
			<july:radio property="mutualPeriod" insertable="false" updatable="false" value="M"/><bean:message key="label.mutualreglmnts.mutualperiod.month"/>
			<july:radio property="mutualPeriod" insertable="false" updatable="false" value="Q"/><bean:message key="label.mutualreglmnts.mutualperiod.quarter"/>
		</td>
	</tr>
		
	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<td class="text"><july:reqmark><bean:message key="label.mutualreglmnts.maincurrency"/>:</july:reqmark></td>
		<td class="text">
			<july:string size="50" property="mainCurrency" insertable="false" updatable="false"/>
		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>


	<logic:present name="<%= form %>" property="additionalCurrency">
		<tr>
			<td class="text"><bean:message key="label.mutualreglmnts.additionalcurrency"/>:</td>
			<td class="text">
				<july:string size="50" property="additionalCurrency" insertable="false" updatable="false"/>
			</td>
		</tr>
		<july:separator colspan="<%= gColSpan %>"/>
	</logic:present>	
	
	<tr>
		<td class="text"><july:reqmark><bean:message key="label.mutualreglmnts.commonrate"/>:</july:reqmark></td>
		<td class="text">
			<july:checkbox property="commonRate" insertable="false" updatable="false"/>
		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>
	
	<logic:equal name="<%= form %>" property="commonRate" value="true">
		<tr>
			<td class="text"><bean:message key="label.mutualreglmnts.calcratetype.all"/>:</td>
			<td class="text">
				<logic:present name="<%= form %>" property="calcRateType">
					<july:radio property="calcRateType" insertable="false" updatable="false" value="B"/><bean:message key="label.mutualreglmnts.calcratetype.begin"/>
					<july:radio property="calcRateType" insertable="false" updatable="false" value="E"/><bean:message key="label.mutualreglmnts.calcratetype.end"/>
				</logic:present>
			</td>
		</tr>
	</logic:equal>
	
	<logic:equal name="<%= form %>" property="commonRate" value="false">


		<tr>
			<td class="text" colspan="2"><bean:message key="label.mutualreglmnts.calcratetype.one"/></td>
		</tr>
	
	</logic:equal>


	<july:separator colspan="<%= gColSpan %>"/>


	<tr>
		<td class="text"><july:reqmark><bean:message key="label.mutualreglmnts.phone"/>:</july:reqmark></td>
		<td class="text">
			<july:string size="50" property="phone" insertable="true" updatable="true"/>
		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>

	<july:formbuttons/>

	<july:separator colspan="<%= gColSpan %>"/>


</table>


</july:editform>

