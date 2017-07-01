<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.arenda.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<%	String gColSpan = "2"; 
	String valueForEdit = (String) request.getAttribute("valueForEdit"); %>

<html:hidden property="arendaTypeInstrOpl"/>

<html:hidden property="otvuser"/>
<html:hidden property="paystateplatinum"/>

<script language="javascript">
function switchBudjet() {
	document.all.direct.value = document.all.budjet.value;
	document.all.project.value = document.all.budjet.value;
}
function switchItem() {
	document.all.expense.value = document.all.zatrata.value;
	document.all.subexpense.value = document.all.zatrata.value;
}
function switchPercent() {
	if (document.all.arendaTypeInstrOpl.value == document.all.typeinstr.value) {
		document.all.percentavans.className = 'editkod';
		document.all.percentavans.disabled = false;
	} else {
		document.all.percentavans.className = 'editkoddisabled';
		document.all.percentavans.disabled = true;
	}
}
</script>

<tr>
	<td colspan="<%= gColSpan %>" class="text"><bean:message key="label.platinum.platezparms"/></td>
</tr>
	
<tr>
	<td class="text"><bean:message key="label.platinum.expensetype"/>:</td>
	<td class="text">
		<july:select styleClass="editbig" collection="ourRashods" property="typerashod" insertable="true" updatable="<%= valueForEdit %>">
			<html:options collection="ourRashods" property="idreference" labelProperty="name"/>
		</july:select>
	</td>
</tr>
	
<tr>
	<td class="text"><bean:message key="label.platinum.budjetcode"/>:</td>
	<td class="text">
		<july:select styleId="budjet" styleClass="editbig" collection="ourBudjets" property="idbudjet" insertable="true" updatable="<%= valueForEdit %>" onchange="switchBudjet()">
			<logic:equal name="PaymentForm" property="action" value="Add">
				<logic:present name="PaymentForm" property="idbudjet">
					<logic:equal name="PaymentForm" property="idbudjet" value="0">
						<html:option value="">&nbsp;</html:option>
					</logic:equal>
				</logic:present>
				<logic:notPresent name="PaymentForm" property="idbudjet">
					<html:option value="">&nbsp;</html:option>
				</logic:notPresent>
			</logic:equal>
			<html:options collection="ourBudjets" property="idbudjetnri" labelProperty="namebudjet"/>
		</july:select>
	</td>
</tr>
	
<tr>
	<td class="text"><bean:message key="label.platinum.directcode"/>:</td>
	<td class="text">
		<july:select styleId="direct" styleClass="editbig" collection="ourBudjets" property="iddirect" insertable="false" updatable="false" disabled="true">
			<html:options collection="ourBudjets" property="idbudjetnri" labelProperty="namedirect"/>
		</july:select>
	</td>
</tr>

<tr>
	<td class="text"><bean:message key="label.platinum.projectcode"/>:</td>
	<td class="text">
		<july:select styleId="project" styleClass="editbig" collection="ourBudjets" property="idproject" insertable="false" updatable="false" disabled="true">
			<html:options collection="ourBudjets" property="idbudjetnri" labelProperty="nameproject"/>
		</july:select>
	</td>
</tr>

<tr>
	<td class="text"><bean:message key="label.platinum.zatrata"/>:</td>
	<td class="text">
		<july:select styleId="zatrata" styleClass="editbig" collection="ourExpences" property="iditem" insertable="true" updatable="<%= valueForEdit %>" onchange="switchItem()">
			<logic:equal name="PaymentForm" property="action" value="Add">
				<logic:present name="PaymentForm" property="iditem">
					<logic:equal name="PaymentForm" property="iditem" value="0">
						<html:option value="">&nbsp;</html:option>
					</logic:equal>
				</logic:present>
				<logic:notPresent name="PaymentForm" property="iditem">
					<html:option value="">&nbsp;</html:option>
				</logic:notPresent>
			</logic:equal>
			<html:options collection="ourExpences" property="idexpencenri" labelProperty="nameitem"/>
		</july:select>
	</td>
</tr>
	
<tr>
	<td class="text"><bean:message key="label.platinum.expensecode"/>:</td>
	<td class="text">
		<july:select styleId="expense" styleClass="editbig" collection="ourExpences" property="idexpence" insertable="false" updatable="false" disabled="true">
			<html:options collection="ourExpences" property="idexpencenri" labelProperty="nameexpence"/>
		</july:select>
	</td>
</tr>
	
<tr>
	<td class="text"><bean:message key="label.platinum.subexpensecode"/>:</td>
	<td class="text">
		<july:select styleId="subexpense" styleClass="editbig" collection="ourExpences" property="idsubexpence" insertable="false" updatable="false" disabled="true">
			<html:options collection="ourExpences" property="idexpencenri" labelProperty="namegrpexpence"/>
		</july:select>
	</td>
</tr>
	
<tr>
	<td class="text"><bean:message key="label.platinum.doctype"/>:</td>
	<td class="text">
		<july:select styleClass="editbig" collection="ourTypebasedocs" property="typebasedoc" insertable="false" updatable="false" disabled="true">
			<html:options collection="ourTypebasedocs" property="idreference" labelProperty="name"/>
		</july:select>
	</td>
</tr>
	
<tr>
	<td class="text"><bean:message key="label.platinum.nbrdateosnovanie"/>:</td>
	<td class="text"><july:string size="25" property="numberanddatepay" insertable="false" updatable="false" /></td>
</tr>
	
<tr>
	<td class="text"><bean:message key="label.platinum.ukaztype"/>:</td>
	<td class="text">
		<july:select styleId="typeinstr" styleClass="editbig" collection="ourInstructions" property="typeinstr" insertable="true" updatable="<%= valueForEdit %>" onchange="switchPercent()">
			<html:options collection="ourInstructions" property="idreference" labelProperty="name"/>
		</july:select>&nbsp;
		<july:string size="5" property="percentavansFrm" insertable="true" updatable="<%= valueForEdit %>" styleId="percentavans"/>&nbsp;%
	</td>
</tr>
	
<tr>
	<td class="text"><bean:message key="label.platinum.buhgalterdata"/>:</td>
	<td class="text"><july:date property="datebuchstr" size="25" required="false" insertable="true" updatable="<%= valueForEdit %>"/></td>
</tr>
	
<tr>
	<td class="text"><bean:message key="label.platinum.oplatadate"/>:</td>
	<td class="text"><july:date property="datebeforepaystr" size="25" insertable="true" updatable="<%= valueForEdit %>"/></td>
</tr>
	
<tr id="trratecr">
	<td class="text"><bean:message key="label.platinum.kurserule"/>:</td>
	<td class="text">
		<july:select styleClass="editbig" collection="ourDefinerates" property="definerate" insertable="true" updatable="<%= valueForEdit %>">
			<html:option value="">&nbsp;</html:option>
			<html:options collection="ourDefinerates" property="idreference" labelProperty="name"/>
		</july:select>
	</td>
</tr>
<%--	
	<tr>
		<td class="text"><bean:message key="label.platinum.paymentmode"/>:</td>
		<td class="text">
			<july:select styleClass="editbig" collection="ourPaymentmodes" property="idpaymode" insertable="false" updatable="false" disabled="true">
				<html:option value="">&nbsp;</html:option>
				<html:options collection="ourPaymentmodes" property="idreference" labelProperty="name"/>
			</july:select>
		</td>
	</tr>
--%>
<html:hidden property="idpaymode"/>

<tr>
	<td class="text"><bean:message key="label.platinum.nakladnaya"/>:</td>
	<td class="text">
		<july:checkbox property="nakladnaya" insertable="true" updatable="<%= valueForEdit %>"/>&nbsp;
		<bean:message key="label.platinum.tovcheck"/>:
		<july:checkbox property="tovcheck" insertable="true" updatable="<%= valueForEdit %>"/>
	</td>
</tr>
	
<tr>
	<td class="text"><bean:message key="label.platinum.sf"/>:</td>
	<td class="text">
		<july:checkbox property="sf" insertable="true" updatable="<%= valueForEdit %>"/>&nbsp;
		<bean:message key="label.platinum.cascheck"/>:
		<july:checkbox property="cascheck" insertable="true" updatable="<%= valueForEdit %>"/>
	</td>
</tr>
	
<tr>
	<td class="text"><bean:message key="label.platinum.kvitpko"/>:</td>
	<td class="text"><july:checkbox property="kvitpko" insertable="true" updatable="<%= valueForEdit %>"/></td>
</tr>

<tr>
	<td class="text"><bean:message key="label.platinum.otvMan"/>:</td>
	<td class="text"><july:string size="50" property="otvuserFrm" insertable="false" updatable="false"/></td>
</tr>

<tr>
	<td class="text"><bean:message key="label.platinum.platezstatus"/>:</td>
	<td class="text"><july:string size="50" property="paystateplatinumFrm" insertable="false" updatable="false"/></td>
</tr>
	
	<tr>
		<td class="text"><bean:message key="label.platinum.platezcode"/>:</td>
		<td class="text"><july:string size="50" property="numpayplatinumDis" insertable="false" updatable="false"/></td>
	</tr>
	
	<tr>
		<td class="text"><bean:message key="label.platinum.datenritoplatinum"/>:</td>
		<td class="text"><july:string size="25" property="datenritoplatinumFrm" insertable="false" updatable="false"/></td>
	</tr>
	
	<tr>
		<td class="text"><bean:message key="label.platinum.dateplatinum"/>:</td>
		<td class="text"><july:string size="25" property="dateplatinumFrm" insertable="false" updatable="false"/></td>
	</tr>
	
	<tr>
		<td class="text"><july:reqmark><bean:message key="label.platinum.flagsync"/>:</july:reqmark></td>
		<td class="text">
			<logic:present name="PaymentForm" property="flagsync">
				<logic:equal name="PaymentForm" property="flagsync" value="0"><bean:message key="label.platinum.flagsync.payment.a"/></logic:equal>
				<logic:equal name="PaymentForm" property="flagsync" value="1"><bean:message key="label.platinum.flagsync.b"/></logic:equal>
				<logic:equal name="PaymentForm" property="flagsync" value="2"><bean:message key="label.platinum.flagsync.payment.c"/></logic:equal>
				<logic:equal name="PaymentForm" property="flagsync" value="3"><bean:message key="label.platinum.flagsync.d"/></logic:equal>
			</logic:present>
		</td>
	</tr>

<tr>
	<td class="text" colspan="2"><bean:message key="label.platinum.taxfields"/>:
		<TABLE class="main">
		<TR>
			<TD class="text"><bean:message key="label.platinum.fl101"/></TD>
			<TD class="text"><bean:message key="label.platinum.fl104"/></TD>
			<TD class="text"><bean:message key="label.platinum.fl105"/></TD>
			<TD class="text"><bean:message key="label.platinum.fl106"/></TD>
			<TD class="text"><bean:message key="label.platinum.fl107"/></TD>
			<TD class="text"><bean:message key="label.platinum.fl108"/></TD>
			<TD class="text"><bean:message key="label.platinum.fl109"/></TD>
			<TD class="text"><bean:message key="label.platinum.fl110"/></TD>
		</TR>
		<TR>
			<TD class="text"><july:string size="5" property="fl101" insertable="true" updatable="true"/></TD>
			<TD class="text"><july:string size="5" property="fl104" insertable="true" updatable="true"/></TD>
			<TD class="text"><july:string size="10" property="fl105" insertable="true" updatable="true"/></TD>
			<TD class="text"><july:string size="5" property="fl106" insertable="true" updatable="true"/></TD>
			<TD class="text"><july:string size="10" property="fl107" insertable="true" updatable="true"/></TD>
			<TD class="text"><july:string size="10" property="fl108" insertable="true" updatable="true"/></TD>
			<TD class="text"><july:string size="10" property="fl109" insertable="true" updatable="true"/></TD>
			<TD class="text"><july:string size="5" property="fl110" insertable="true" updatable="true"/></TD>
		</TR>
		</TABLE>
	</td>
</tr>
	
<script language='javascript'>
	switchBudjet();
	switchItem();
	switchPercent();
</script>