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
	switch (ParamsParser.getState(pageContext)) {
		case APPStates.MUTACT_EDIT:
			action = "/ProcessMutualAct.do";
			form = "MutualActForm";
			parent2 = "/ShowMutualReglamentsList.do";
			parent3 = "/ShowMutualActsList.do";
			break;
		case APPStates.FROMCONTRACT_MUTACT_EDIT:
			action = "/ProcessFromContractMutualAct.do";
			form = "FromContractMutualActForm";
			parent = "/ViewWeArenda.do";
			parent2 = "/ShowFromContractMutualReglamentsList.do";
			parent3 = "/ShowFromContractMutualActsList.do";
			break;
		case APPStates.FROMHISTORY_MUTACT_EDIT:
			action = "/ProcessFromHistoryMutualAct.do";
			form = "FromHistoryMutualActForm";
			parent = "/ViewHistory.do";
			parent2 = "/ShowFromHistoryMutualReglamentsList.do";
			parent3 = "/ShowFromHistoryMutualActsList.do";
			break;
	}
	String update = "false";
%>

<july:editform action="<%= action %>" styleId="<%= form %>" enctype="multipart/form-data">

<logic:equal name="<%=form%>" property="actState" value="O">
<% update = "true"; %>
</logic:equal>

<html:hidden property="leaseDocument"/>
<html:hidden property="leaseMutualReglamentcode"/>
<html:hidden property="reglamentState"/>
<html:hidden property="actState"/>

<table class="main" style="font-size: 8pt">

<july:separator colspan="<%= gColSpan %>"/>

<tr>
	<td class="title" colspan="<%= gColSpan %>"><july:actionalert/></td>
</tr>

<july:separator colspan="<%= gColSpan %>"/>

<tr>
	<td class="text">
		<july:reqmark>№ и дата регламента:</july:reqmark></td>
	<td class="text">
		<july:string size="25" property="documentNumberReglament" insertable="false" updatable="false"/>&nbsp;&nbsp;&nbsp;	
		<july:date property="documentDateReglamentFrm" size="10" insertable="false" updatable="false"/>
	</td>
</tr>
	
<july:separator colspan="<%= gColSpan %>"/>	
	
<tr>
	<td class="text"><july:reqmark><bean:message key="label.mutualreglmnts.acttype"/>:</july:reqmark></td>
	<td class="text">
		<july:radio property="actType" insertable="false" updatable="false" value="A"/><bean:message key="label.mutualreglmnts.acttype.vz"/><br>
		<july:radio property="actType" insertable="false" updatable="false" value="M"/><bean:message key="label.mutualreglmnts.acttype.vt"/><br>
		<july:radio property="actType" insertable="false" updatable="false" value="S"/><bean:message key="label.mutualreglmnts.acttype.sv"/>
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>"/>

<tr>
	<td class="text"><july:reqmark><bean:message key="label.mutualreglmnts.mutualperiod"/>:</july:reqmark></td>
	<td class="text">
		<july:radio property="mutualPeriod" insertable="false" updatable="false" value="M"/><bean:message key="label.mutualreglmnts.mutualperiod.month"/>
		<july:radio property="mutualPeriod" insertable="false" updatable="false" value="Q"/><bean:message key="label.mutualreglmnts.mutualperiod.quarter"/>
		<july:radio property="mutualPeriod" insertable="false" updatable="false" value="Y"/><bean:message key="label.mutualreglmnts.mutualperiod.year"/>
	</td>
</tr>
	
<july:separator colspan="<%= gColSpan %>"/>

<tr>
	<td class="text"><july:reqmark><bean:message key="label.mutualreglmnts.maincurrency"/>:</july:reqmark></td>
	<td class="text"><july:string size="50" property="mainCurrency" insertable="false" updatable="false"/></td>
</tr>
	
<july:separator colspan="<%= gColSpan %>"/>

<logic:present name="<%= form %>" property="additionalCurrency">
<tr>
	<td class="text"><bean:message key="label.mutualreglmnts.additionalcurrency"/>:</td>
	<td class="text"><july:string size="50" property="additionalCurrency" insertable="false" updatable="false"/></td>
</tr>
<july:separator colspan="<%= gColSpan %>"/>
</logic:present>	
	
<tr>
	<td class="text"><july:reqmark><bean:message key="label.mutualreglmnts.commonrate"/>:</july:reqmark></td>
	<td class="text"><july:checkbox property="commonRate" insertable="false" updatable="false"/></td>
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
	<td class="text">
		<july:reqmark>№ и дата акта:</july:reqmark>
	</td>
	<td class="text">
		<july:string size="25" property="documentNumber" insertable="true" updatable="<%=update%>"/>&nbsp;&nbsp;&nbsp;
		<july:date style="vertical-align:bottom;" property="documentDateFrm" size="25" styleId="adate" insertable="true" updatable="<%=update%>"/>
	</td>
</tr>
	
<%--july:separator colspan="<%= gColSpan %>"/>
	
<tr>
	<td class="text"><july:reqmark><bean:message key="label.mutualacts.actstartdate"/>:</july:reqmark></td>
	<td class="text"><july:date property="actstartdateFrm" size="25" insertable="true" updatable="<%=update%>"/></td>
</tr--%>

<july:separator colspan="<%= gColSpan %>"/>
	
<tr>
	<td class="text">
		<july:reqmark>Период акта:</july:reqmark>
	</td>
	<td class="text">
		<july:date property="actstartdateFrm" size="25" insertable="true" updatable="<%=update%>"/>&nbsp;&nbsp;&nbsp;
		<july:date property="actenddateFrm" size="25" styleId="edate" onchange="setDate_adate(getDate_edate() + 1);" insertable="true" updatable="<%=update%>"/>
	</td>
</tr>
	
<%--july:separator colspan="<%= gColSpan %>"/>

<tr>
	<td class="text"><july:reqmark><bean:message key="label.mutualacts.actdate"/>:</july:reqmark></td>
	<td class="text"><july:date property="documentDateFrm" size="25" styleId="adate" insertable="true" updatable="<%=update%>"/></td>
</tr--%>
	
<july:separator colspan="<%= gColSpan %>"/>
	
<tr>
	<td class="text"><bean:message key="label.mutualacts.header"/>:</td>
	<td class="text"><july:string property="header" size="50" insertable="true" updatable="<%=update%>"/></td>
</tr>
	
<july:separator colspan="<%= gColSpan %>"/>
	
<tr>
	<td class="text"><bean:message key="label.mutualacts.footer"/>:</td>
	<td class="text"><july:string property="footer" size="50" insertable="true" updatable="<%=update%>"/></td>
</tr>

<july:separator colspan="<%= gColSpan %>"/>
	
<tr>
	<td class="text"><july:reqmark><bean:message key="label.mutualacts.isschetfact"/>:</july:reqmark></td>
	<td class="text">
		<july:checkbox property="isSchetFakt" insertable="true" updatable="<%=update%>"/>
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>"/>

<tr>
	<td class="text">Учитывать НДС по взаимозачету:</july:reqmark></td>
	<td class="text">
		<july:checkbox property="mutualNDS" insertable="true" updatable="<%=update%>"/>
	</td>
</tr>

<%--logic:notEqual name="<%=form%>" property="action" value="Delete">
<logic:notEqual name="<%=form%>" property="action" value="View">

<july:separator colspan="<%= gColSpan %>"/>

<tr>
	<td class="text"><bean:message key="label.mutualacts.wordfile"/>:</td>
	<td class="text">
		<logic:notEqual name="<%=form%>" property="actState" value="C">
			<html:select name="<%=form%>" property="wordfileAction">
				<html:option key="" value=""/>
			<logic:equal name="<%=form%>" property="wordfilePresent" value="false">
				<html:option key="label.mutualacts.wordfile.attach" value="1"/>
			</logic:equal>
			<logic:equal name="<%=form%>" property="wordfilePresent" value="true">
				<html:option key="label.mutualacts.wordfile.update" value="1"/>
				<html:option key="label.mutualacts.wordfile.detach" value="2"/>
			</logic:equal>
			</html:select>
			<html:file property="wordfileFrm" size="25" />&nbsp;
		</logic:notEqual>
		<logic:equal name="<%=form%>" property="wordfilePresent" value="true">
			<html:link page="/MutualActDownload" paramId="actcode" paramName="<%=form%>" paramProperty="leaseDocument" paramScope="request">
				<bean:write name="<%=form%>" property="wordfileName" filter="true"/>
			</html:link>
		</logic:equal>
	</td>
</tr>
</logic:notEqual>
</logic:notEqual--%>
	
<july:separator colspan="<%= gColSpan %>"/>
	
<july:formbuttons/>
	
<july:separator colspan="<%= gColSpan %>"/>

</table>

</july:editform>

