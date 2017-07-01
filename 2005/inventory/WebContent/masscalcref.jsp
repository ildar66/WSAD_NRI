<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import="java.util.*,com.hps.july.inventory.actionbean.*,com.hps.july.inventory.formbean.*" %>
<%@ page import="org.apache.struts.action.*"%>
<%@ page import="org.apache.struts.util.*"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<logic:present name="masscalc_needrefresh">
	<META HTTP-EQUIV="REFRESH" CONTENT="4">
</logic:present>

<% int gColSpan = 6; %>

<table class="main">

<tr class="normal">
	<td colspan='<%=""+gColSpan %>'>
		<table class="find">
		<tr>
			<td class="title">
				<bean:message key="label.masscalcref.period"/>
			</td>
			<td class="title">
				<bean:message key="label.datefrom"/>&nbsp;<july:datewrite name="MassCalcParamsForm" property="datefrom" />&nbsp;
				<bean:message key="label.dateto"/>&nbsp;<july:datewrite name="MassCalcParamsForm" property="dateto" />
			</td>
		</tr> 
		<tr>
			<td class="title">
				<bean:message key="label.masscalc.owner"/>
			</td>
			<td class="title">
<logic:equal name="MassCalcParamsForm" property="isowner" value="true">
	<bean:message key="label.all"/>
</logic:equal>
<logic:equal name="MassCalcParamsForm" property="isowner" value="false">
	<bean:write name="MassCalcParamsForm" property="ownername" filter="true" />
</logic:equal>

			</td>
		</tr>
		<tr>
			<td class="title">
				<bean:message key="label.masscalc.place"/>
			</td>
			<td class="title">
<logic:equal name="MassCalcParamsForm" property="storagetype" value="0">
	<bean:message key="label.all"/>
</logic:equal>
<logic:equal name="MassCalcParamsForm" property="storagetype" value="1">
	<bean:write name="MassCalcParamsForm" property="positionid" filter="true" />
	<bean:write name="MassCalcParamsForm" property="positionname" filter="true" />
</logic:equal>
<logic:equal name="MassCalcParamsForm" property="storagetype" value="2">
	<bean:write name="MassCalcParamsForm" property="storagename" filter="true" />
</logic:equal>
<logic:equal name="MassCalcParamsForm" property="storagetype" value="3">
	<bean:write name="MassCalcParamsForm" property="workername" filter="true" />
</logic:equal>
<logic:equal name="MassCalcParamsForm" property="storagetype" value="4">
	<bean:write name="MassCalcParamsForm" property="organizationname" filter="true" />
</logic:equal>
			</td>
		</tr>
		<tr>
			<td class="title" align="top">
				<bean:message key="label.masscalcref.documents"/>
			</td>
			<td class="title">
<logic:equal name="MassCalcParamsForm" property="incAll" value="true">
	<bean:message key="label.all"/><br>
</logic:equal>
<logic:equal name="MassCalcParamsForm" property="incAll" value="false">
	<logic:equal name="MassCalcParamsForm" property="incSAll" value="true">
		<bean:message key="label.masscalc.s.all"/><br>
	</logic:equal>
	<logic:equal name="MassCalcParamsForm" property="incSAll" value="false">
		<logic:equal name="MassCalcParamsForm" property="incSExternal" value="true">
			<bean:message key="label.masscalcdoc.W"/><br>
		</logic:equal>
		<logic:equal name="MassCalcParamsForm" property="incSInternal" value="true">
			<bean:message key="label.masscalcdoc.TS"/><br>
		</logic:equal>
		<logic:equal name="MassCalcParamsForm" property="incSInternalr" value="true">
			<bean:message key="label.masscalcdoc.NS"/><br>
		</logic:equal>
		<logic:equal name="MassCalcParamsForm" property="incSExternalr" value="true">
			<bean:message key="label.masscalcdoc.O"/><br>
		</logic:equal>
		<logic:equal name="MassCalcParamsForm" property="incSInvact" value="true">
			<bean:message key="label.masscalcdoc.IS"/><br>
		</logic:equal>
		<logic:equal name="MassCalcParamsForm" property="incSAssactb" value="true">
			<bean:message key="label.masscalcdoc.AAS"/><br>
		</logic:equal>
		<logic:equal name="MassCalcParamsForm" property="incSDassactb" value="true">
			<bean:message key="label.masscalcdoc.ADS"/><br>
		</logic:equal>
		<logic:equal name="MassCalcParamsForm" property="incSPayoff" value="true">
			<bean:message key="label.masscalcdoc.P"/><br>
		</logic:equal>
		<logic:equal name="MassCalcParamsForm" property="incSChange" value="true">
			<bean:message key="label.masscalcdoc.HS"/><br>
		</logic:equal>
	</logic:equal>
	<logic:equal name="MassCalcParamsForm" property="incPAll" value="true">
		<bean:message key="label.masscalc.p.all"/><br>
	</logic:equal>
	<logic:equal name="MassCalcParamsForm" property="incPAll" value="false">
		<logic:equal name="MassCalcParamsForm" property="incPAssact" value="true">
			<bean:message key="label.masscalcdoc.TP"/><br>
		</logic:equal>
		<logic:equal name="MassCalcParamsForm" property="incPDassact" value="true">
			<bean:message key="label.masscalcdoc.NP"/><br>
		</logic:equal>
		<logic:equal name="MassCalcParamsForm" property="incPAssactb" value="true">
			<bean:message key="label.masscalcdoc.AAP"/><br>
		</logic:equal>
		<logic:equal name="MassCalcParamsForm" property="incPDassactb" value="true">
			<bean:message key="label.masscalcdoc.ADP"/><br>
		</logic:equal>
		<logic:equal name="MassCalcParamsForm" property="incPInvact" value="true">
			<bean:message key="label.masscalcdoc.IP"/><br>
		</logic:equal>
		<logic:equal name="MassCalcParamsForm" property="incPChange" value="true">
			<bean:message key="label.masscalcdoc.HP"/><br>
		</logic:equal>
	</logic:equal>
</logic:equal>
			</td>
		</tr>
		</table>
	</td>
</tr>

<july:separator colspan='<%=""+gColSpan %>' />

<tr class="title">
	<td colspan='<%=""+gColSpan %>'>
		<table class="buttons">
		<tr class="title">
			<td class="buttons">
<logic:present name="masscalc_needrefresh">
	<july:backbutton page="/MassCalc.do?action=Finish"/>
</logic:present>
<logic:notPresent name="masscalc_needrefresh">
	<july:backbutton page="/MassCalcParams.do"/>
</logic:notPresent>
</td>
		</tr>
		</table>
	</td>
</tr>
<%
	int overall = 0;
	int processed = 0;
	int errors = 0;
	int proc_wo = 0;
	int percent = 0;
	int errorsp = 0;
	int p = 0;
	try {
		overall = ((Integer)request.getAttribute("masscalc_overall")).intValue();
		processed = ((Integer)request.getAttribute("masscalc_processed")).intValue();
		errors = ((Integer)request.getAttribute("masscalc_errors")).intValue();
		proc_wo = processed - errors;
		percent = processed*100/overall;
		errorsp = errors*100/overall;
	} catch(Exception e) {
	}
%>
<logic:present name="masscalc_needrefresh">
<july:separator colspan='<%=""+gColSpan %>' />

<!-- Table header -->
<tr class="normal">
	<td colspan='<%=""+gColSpan %>'>
<%
	if(overall > 0) {
%>
<br>
<center>
<div style="width:404;height:20;padding:1px;background-color:#000000;text-align:left;"><div style="width:402;height:18;padding:1px;background-color:#FFFFFF;text-align:left;">
<span style="width:<%=errorsp*4%>;height:16;background-color:#CC0033;text-align:center"></span>
<span style="width:<%=(percent-errorsp)*4%>;height:16;background-color:#336699;text-align:center"></span>
</div></div>
<%=percent%>%
<br>
<bean:message key="label.masscalcref.docoverall"/> <bean:write name="masscalc_overall" filter="true"/>, <bean:message key="label.masscalcref.docprocessed"/> <bean:write name="masscalc_processed" filter="true"/>, <bean:message key="label.masscalcref.docerrors"/> <bean:write name="masscalc_errors" filter="true"/><br>
<br>
</center>
<%
	} else {
%>
<br>
<bean:message key="label.masscalcref.nodocs"/>
<%
	}
%>
	</td>
</tr>
</logic:present>

<logic:notPresent name="masscalc_needrefresh">
<july:separator colspan='<%=""+gColSpan %>' />

<tr class="normal">
	<td colspan="<%=gColSpan %>">
<center>
<br>
<bean:message key="label.masscalcref.docoverall"/> <bean:write name="masscalc_processed" filter="true"/>, <bean:message key="label.masscalcref.docerrors"/> <bean:write name="masscalc_errors" filter="true"/><br>
<br>
</center>
	</td>
</tr>

<july:separator colspan='<%=""+gColSpan %>' />

<logic:present name="masscalc_doclist">
<!-- Table header -->
<tr class="title">
	<july:headercolumn key="label.masscalcref.docdate" colType="string"/>
	<july:headercolumn key="label.masscalcref.doctype" colType="string"/>
	<july:headercolumn key="label.masscalcref.docnum" colType="string"/>
	<july:headercolumn key="label.masscalcref.docstorage" colType="string"/>
	<july:headercolumn key="label.masscalcref.docwho" colType="string"/>
	<july:headercolumn key="label.masscalcref.docresult" colType="string"/>
</tr>

<july:separator colspan='<%=""+gColSpan %>' />
    
<!-- Table body -->
<logic:iterate id="it" name="masscalc_doclist" type="com.hps.july.inventory.actionbean.MassCalcResultItem">
	<logic:present name="it">
	<logic:notEqual name="it" property="state" value="0">
		<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
			<td class="text">
				<july:datewrite name="it" property="docDate" />
			</td>
			<td class="text">
<%
	String s = "label.masscalc.doctype."+it.getDocType();
	try {
%><bean:message key="<%=s%>"/><%
	} catch(Exception e) {
		e.printStackTrace(System.out);
%><%=s%><%
	}
%>
<%--
<logic:equal name="it" property="docType" value="W">
	<bean:message key="label.masscalcdoc.W"/>
</logic:equal>
<logic:equal name="it" property="docType" value="TS">
	<bean:message key="label.masscalcdoc.TS"/>
</logic:equal>
<logic:equal name="it" property="docType" value="NS">
	<bean:message key="label.masscalcdoc.NS"/>
</logic:equal>
<logic:equal name="it" property="docType" value="O">
	<bean:message key="label.masscalcdoc.O"/>
</logic:equal>
<logic:equal name="it" property="docType" value="IS">
	<bean:message key="label.masscalcdoc.IS"/>
</logic:equal>
<logic:equal name="it" property="docType" value="AAS">
	<bean:message key="label.masscalcdoc.AAS"/>
</logic:equal>
<logic:equal name="it" property="docType" value="ADS">
	<bean:message key="label.masscalcdoc.ADS"/>
</logic:equal>
<logic:equal name="it" property="docType" value="P">
	<bean:message key="label.masscalcdoc.P"/>
</logic:equal>
<logic:equal name="it" property="docType" value="HS">
	<bean:message key="label.masscalcdoc.HS"/>
</logic:equal>
<logic:equal name="it" property="docType" value="TP">
	<bean:message key="label.masscalcdoc.TP"/>
</logic:equal>
<logic:equal name="it" property="docType" value="NP">
	<bean:message key="label.masscalcdoc.NP"/>
</logic:equal>
<logic:equal name="it" property="docType" value="AAP">
	<bean:message key="label.masscalcdoc.AAP"/>
</logic:equal>
<logic:equal name="it" property="docType" value="ADP">
	<bean:message key="label.masscalcdoc.ADP"/>
</logic:equal>
<logic:equal name="it" property="docType" value="IP">
	<bean:message key="label.masscalcdoc.IP"/>
</logic:equal>
<logic:equal name="it" property="docType" value="HP">
	<bean:message key="label.masscalcdoc.HP"/>
</logic:equal>
--%>
			</td>
			<td class="text">
				<bean:write name="it" property="docNumber" filter="true"/>
			</td>
			<td class="text">
				<bean:write name="it" property="storagename" filter="true" />
			</td>
			<td class="text">
				<bean:write name="it" property="enteror" filter="true" />
			</td>
			<td class="text">
				<logic:equal name="it" property="state" value="0"><bean:message key="label.masscalcref.processed"/></logic:equal>
				<logic:equal name="it" property="state" value="1"><bean:message key="label.masscalcref.finished"/></logic:equal>
				<logic:equal name="it" property="state" value="2"><bean:message key="label.masscalcref.finisherrors"/></logic:equal>
			</td>
		</tr>
<logic:present name="masscalc_interrupted">
<tr class="normal"> 
<td colspan='<%=""+gColSpan %>' style="text-align:center;color#CC0033;">Обработка прервана пользователем.</td>
</tr>
</logic:present>

<logic:equal name="it" property="state" value="2">
<%
	MassCalcResultItem ri = (MassCalcResultItem)pageContext.getAttribute("it");
	if(ri.getErrors() != null && ri.getErrors().size() > 0) {
%>
		<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
			<td valign="top"><bean:message key="label.masscalcref.errors"/>:</td>
			<td colspan='<%= ""+(gColSpan - 1) %>'>
<%
		Iterator eit = ri.getErrors().get(ActionErrors.GLOBAL_ERROR);
		ActionError er;
		while(eit.hasNext()) {
			er = (ActionError)eit.next();
%><%=RequestUtils.message(pageContext, Action.MESSAGES_KEY, Action.LOCALE_KEY, er.getKey(), er.getValues())+"<br>"%><%
		}
%>
			</td>
		</tr>
<%
	}
%>
</logic:equal>
		<july:separator colspan='<%=""+gColSpan %>' />

	</logic:notEqual>
	</logic:present>
</logic:iterate>
</logic:present>
</logic:notPresent>

<tr class="title">
	<td colspan='<%=""+gColSpan %>'>
		<table class="buttons">
		<tr class="title">
			<td class="buttons">
<logic:present name="masscalc_needrefresh">
	<july:backbutton page="/MassCalc.do?action=Finish"/>
</logic:present>
<logic:notPresent name="masscalc_needrefresh">
	<july:backbutton page="/MassCalcParams.do"/>
</logic:notPresent>
			</td>
		</tr>
		</table>
	</td>
</tr>
        
<july:separator colspan='<%=""+gColSpan %>' />
  
</table>

