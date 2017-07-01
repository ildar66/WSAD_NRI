<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.arenda.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<% java.lang.String gColSpan = "2"; 	String src = "/images/save.gif";  String alt = "Сохранить правило начислений";%>

<july:errors property="org.apache.struts.action.GLOBAL_ERROR"/>

<logic:equal name="ChargeRuleDialogForm" property="action" value="Delete">
	<script language="javascript">
		<% src = "/images/delconf.gif"; alt = "Удалить правило начислений"; %>
	</script>
</logic:equal>

<july:editform action="/ProcessChargeRuleDialog.do" styleId="ChargeRuleDialogForm">
<html:hidden property="leaseDocumentcode"/>
<html:hidden property="leaseRule"/>

<script language='javascript'>
function Close()
	{
		if(window.opener) {
			//alert(window.opener.window.location.href);//temp
			opener.location.reload(true);
			window.opener.focus();
		}
		window.close();
	}
</script>

<table class="main">

	<july:separator colspan="<%= gColSpan %>"/>
    <tr class="title">
    	<td class="title" colspan="6">
			<INPUT TYPE="IMAGE" NAME="submit" SRC="<%= src%>"  ALT="<%= alt%>" onclick="document.body.style.cursor='wait';">&nbsp;
			<july:closebutton page="/"/>
        </td>
    </tr>
	<july:separator colspan="<%= gColSpan %>"/>

    <tr>
		<td class="title" colspan="<%= gColSpan %>"><july:actionalert/></td>
	</tr>

 	<july:separator colspan="<%= gColSpan %>"/>

	<tr>
		<td class="text"><july:reqmark><bean:message key="label.chargerules.resource"/>:</july:reqmark></td>
		<td class="text">
		    <july:select style="width: 300;" collection="resources" property="resourcecode" insertable="true" updatable="true">
				<logic:equal name="ChargeRuleDialogForm" property="action" value="Add">
					<html:option value="">&nbsp;</html:option>
				</logic:equal>
				<html:options collection="resources" property="resource" labelProperty="name"/>
		   	</july:select>
		</td>
    </tr>

	<july:separator colspan="<%= gColSpan %>"/>

	<tr>
		<td class="text"><july:reqmark><bean:message key="label.chargerules.period"/>:</july:reqmark></td>
		<td class="text">
			<july:radio property="chargePeriod" insertable="true" updatable="true" value="M"/><bean:message key="label.chargerules.period.month"/>
			<july:radio property="chargePeriod" insertable="true" updatable="true" value="Q"/><bean:message key="label.chargerules.period.quarter"/>
			<july:radio property="chargePeriod" insertable="true" updatable="true" value="Y"/><bean:message key="label.chargerules.period.year"/>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<td class="text"><july:reqmark><bean:message key="label.chargerules.sum"/>:</july:reqmark></td>
		<td class="text">
			<july:string size="10" property="sumFrm" insertable="true" updatable="true"/>&nbsp;
		    <july:select style="width: 100;" collection="currencies" property="currencycode" insertable="true" updatable="true">
				<html:options collection="currencies" property="currency" labelProperty="name"/>
		   	</july:select>
		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>

	<tr>
		<td class="text"><july:reqmark><bean:message key="label.chargerules.daterule"/>:</july:reqmark></td>
		<td class="text">
			<july:radio property="chargeDateRule" insertable="true" updatable="true" value="S"/><bean:message key="label.chargerules.daterule.startperiod"/>
			<july:radio property="chargeDateRule" insertable="true" updatable="true" value="E"/><bean:message key="label.chargerules.daterule.endperiod"/>
		</td>
    </tr>
	
	<july:separator colspan="<%= gColSpan %>"/>
    <tr class="title">
    	<td class="title" colspan="6">
			<INPUT TYPE="IMAGE" NAME="submit" SRC="<%= src%>"  ALT="<%= alt%>" onclick="document.body.style.cursor='wait';">&nbsp;
			<july:closebutton page="/"/>
        </td>
    </tr>
	<july:separator colspan="<%= gColSpan %>"/>

</table>
</july:editform>

<logic:equal name="ChargeRuleDialogForm" property="flagOperation" value="true">
	<script language="javascript" type="text/javascript">
		 Close();
	</script>
</logic:equal>
