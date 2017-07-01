<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "2"; %>

<july:editform action="/ProcessAbonentBillPos.do" styleId="AbonentBillPosForm">

<html:hidden property="billpos"/>
<html:hidden property="billType"/>
<html:hidden property="ndsrate"/>

<script language="JScript">
function switchByHand() {
	if (!document.all.sumbyhand[0].checked) {
		document.all.ndssummnriFrm[0].className = 'editdisabled';
		document.all.ndssummnriFrm[0].disabled = true;
		document.all.nspsummnriFrm[0].className = 'editdisabled';
		document.all.nspsummnriFrm[0].disabled = true;
		document.all.summnriFrm[0].className = 'editdisabled';
		document.all.summnriFrm[0].disabled = true;
		document.all.recalcnds.style.display="none";
		//patch SI 1
        document.all.sumchangereason.disabled = true;;
	} else {
		document.all.ndssummnriFrm[0].className = 'edit';
		document.all.ndssummnriFrm[0].disabled = false;
		document.all.nspsummnriFrm[0].className = 'edit';
		document.all.nspsummnriFrm[0].disabled = false;
		document.all.summnriFrm[0].className = 'edit';
		document.all.summnriFrm[0].disabled = false;
		document.all.recalcnds.style.display="inline";
		//patch SI 1
        document.all.sumchangereason.disabled = false;
	}
}

function updateNds() {
	document.all.ndssummnriFrm[0].value = Math.round((document.all.summnriFrm[0].value * <bean:write name="AbonentBillPosForm" property="ndsrate" />) / 
		(100.0 + <bean:write name="AbonentBillPosForm" property="ndsrate" />) * 100.0) / 100.0;
}

function updateSum() {
	document.all.summpurenriFrm.value = document.all.summnriFrm[0].value - document.all.ndssummnriFrm[0].value - document.all.nspsummnriFrm[0].value; 
}

</script>

<table class="main">

<july:separator colspan="<%= gColSpan %>"/>
    
<tr>
	<td class="title" colspan="<%= gColSpan %>"><july:actionalert/></td>
</tr>

<july:separator colspan="<%= gColSpan %>"/>
<%-- Abonent Contract Params --%>
<tr>
	<td class="text"><bean:message key="label.abonents.ban"/>:</td>
	<td class="text">
		<bean:write name="AbonentBillPosesListForm" property="ban" filter="true"/>
		(валюта: <bean:write name="AbonentBillPosesListForm" property="currencyVO.shortname" filter="true"/>)
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>"/>

<tr>
	<td class="text"><bean:message key="label.abonents.benlist"/>:</td>
	<td class="text">
		<logic:equal name="AbonentBillPosesListForm" property="useallben" value="true"><bean:message key="label.bans.allben"/></logic:equal>
		<logic:equal name="AbonentBillPosesListForm" property="useallben" value="false"><bean:write name="AbonentBillPosesListForm" property="bensList" filter="true"/></logic:equal>
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>"/>

<tr>
	<td class="text"><bean:message key="label.bans.nri.orgname"/>:</td>
	<td class="text">
		<bean:write name="AbonentBillPosesListForm" property="customername" filter="true" />
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>"/>
	
<tr>
	<td class="text"><bean:message key="label.bans.nri.orginn"/>:</td>
	<td class="text">
		<bean:write name="AbonentBillPosesListForm" property="customerinn" />
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>"/>
<%-- Bill Params --%>
<tr>
	<td class="text"><bean:message key="label.bans.bill.number"/>:</td>
	<td class="text">
		<bean:write name="AbonentBillPosesListForm" property="billNumber" filter="true"/>&nbsp;
		<bean:message key="label.bans.bill.date"/>:&nbsp;
		<july:datewrite name="AbonentBillPosesListForm" property="billDate"/>
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>"/>
	
<tr>
	<td class="text"><bean:message key="label.bans.bill.sum"/>:</td>
	<td class="text">
		<july:sumwrite name="AbonentBillPosesListForm" property="sum"/>
	</td>
</tr>
	
<july:separator colspan="<%= gColSpan %>"/>
	
<tr>
	<td class="text"><bean:message key="label.bans.bill.sumnds"/>:</td>
	<td class="text">
		<july:sumwrite name="AbonentBillPosesListForm" property="sumnds"/>
	</td>
</tr>
	
<july:separator colspan="<%= gColSpan %>"/>
	
<tr>
	<td class="text"><bean:message key="label.bans.bill.sumnsp"/>:</td>
	<td class="text">
		<july:sumwrite name="AbonentBillPosesListForm" property="sumnsp"/>
	</td>
</tr>
	
<july:separator colspan="<%= gColSpan %>"/>
	
<tr>
	<td class="text"><bean:message key="label.bans.bill.period"/>:</td>
	<td class="text">
		<july:datewrite name="AbonentBillPosForm" property="startdate"/>&nbsp;
		<bean:message key="label.filter.stop"/>&nbsp;
		<july:datewrite name="AbonentBillPosForm" property="enddate"/>
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>"/>

<tr>
	<td class="text"><bean:message key="label.bans.bill.billtype"/>:</td>
	<td class="text">
		<logic:equal name="AbonentBillPosForm" property="billType" value="U"><bean:message key="label.bans.bill.billtype.u"/></logic:equal>
		<logic:equal name="AbonentBillPosForm" property="billType" value="O"><bean:message key="label.bans.bill.billtype.o"/></logic:equal>
		<logic:equal name="AbonentBillPosForm" property="billType" value="S"><bean:message key="label.bans.bill.billtype.s"/></logic:equal>
	</td>
</tr>

<%-- Bill Params --%>

<july:separator colspan="<%= gColSpan %>"/>

<tr>
	<td class="text">&nbsp;</td>
	<td class="text">
		<table class="main"><tr>
			<td><bean:message key="label.bans.bill.billing"/></td>
			<td><bean:message key="label.bans.bill.nri"/></td>
		</tr></table>
	</td>
</tr>

<tr>
	<td class="text"><bean:message key="label.bans.bill.poses.resourcename"/>:</td>
	<td class="text">
		<july:string size="20" property="servname" insertable="false" updatable="false"/>&nbsp;
   		<july:select collection="services" property="resource" insertable="true" updatable="true">
			<html:options collection="services" property="resource" labelProperty="name"/>
		</july:select>
	</td>
</tr>
	
<tr>
	<td class="text"><bean:message key="label.bans.bill.poses.summnotax"/>:</td>
	<td class="text">
		<july:string size="20" property="summpure" insertable="false" updatable="false"/>&nbsp;
		<july:string size="20" property="summpurenriFrm" insertable="false" updatable="false"/>
	</td>
</tr>
	
<tr>
	<td class="text"><bean:message key="label.bans.bill.poses.nds"/>:</td>
	<td class="text">
		<july:string size="20" property="ndssumm" insertable="false" updatable="false"/>&nbsp;
		<july:string size="20" property="ndssummnriFrm" insertable="true" updatable="true" 
			styleId="ndssummnriFrm" onkeyup="updateSum();" onchange="updateSum();"/>
		<INPUT TYPE="image" SRC="/images/obchet1.gif" BORDER=0 NAME="recalcnds" ID="recalcnds">
	</td>
</tr>
	
<tr>
	<td class="text"><bean:message key="label.bans.bill.poses.nsp"/>:</td>
	<td class="text">
		<july:string size="20" property="nspsumm" insertable="false" updatable="false"/>&nbsp;
		<july:string size="20" property="nspsummnriFrm" insertable="true" updatable="true" 
		   styleId="nspsummnriFrm" onkeyup="updateSum();" onchange="updateSum();"/>
	</td>
</tr>

<tr>
	<td class="text"><bean:message key="label.bans.bill.poses.summtax"/>:</td>
	<td class="text">
		<july:string size="20" property="summ" insertable="false" updatable="false"/>&nbsp;
		<july:string size="20" property="summnriFrm" insertable="true" updatable="true" 
			styleId="summnriFrm" onkeyup="updateNds(); updateSum();" onchange="updateNds(); updateSum();"/>
	</td>
</tr>
<!-- SI patch 1 start -->
<tr>
    <td class="text">Причина изменения<br>суммы счета :</td>
	<td>
	    <july:textarea cols="59" rows="3" property="sumchangereason" insertable="true" updatable="true"/>
    </td> 
</tr>
<!-- SI patch 1 end -->
<july:separator colspan="<%= gColSpan %>"/>
	
<tr>
	<td class="text"><bean:message key="label.bans.bill.poses.handsumm"/>:</td>
	<td class="text"><july:checkbox property="sumbyhand" insertable="true" updatable="true" styleId="sumbyhand" onclick="switchByHand()"/></td>
</tr>

<july:separator colspan="<%= gColSpan %>"/>
	
<july:formbuttons/>

<july:separator colspan="<%= gColSpan %>"/>
		
</table>

<html:hidden property="ndssummnriFrm"/>
<html:hidden property="nspsummnriFrm"/>
<html:hidden property="summnriFrm"/>

<script language="javascript">
	switchByHand();
</script>

</july:editform>
