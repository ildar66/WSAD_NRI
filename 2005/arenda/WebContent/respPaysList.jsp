<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import="com.hps.july.arenda.valueobject.*"%>
<%@ page import="com.hps.july.arenda.formbean.*"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<style>
OBJECT.date {
	FONT-FAMILY: Arial Cyr; FONT-SIZE: 9pt; WIDTH: 100px; background-color: D6EBFF;
}
TD.ttitle {
	font-size:7pt;font-weight:bold;
	vertical-align:center;
	text-align:center;
	word-break:break-all;
	padding-left: 3px; padding-right: 3px;
}
TD.stext {
	font-size:7pt;font-weight:normal;
	vertical-align:top;
	padding:0px;
	text-overflow:elipsis;
	word-break:break-all;
	padding-left: 3px; padding-right: 3px;
	padding-top: 3px; padding-bottom: 3px;
}
TD.mtext {
	font-size:7pt;font-weight:normal;
	padding:0px;
	text-overflow:elipsis;
	word-break:break-all;
	padding-left: 3px; padding-right: 3px;
	padding-top: 3px; padding-bottom: 3px;
	text-align:center;
	vertical-align:middle;
}
DIV.sttext {
	text-overflow:elipsis;
	overflow:hidden;
	word-break:break-all;
	height:1.5em;
	font-size:7pt;font-weight:normal;
}
TR.current {
	BACKGROUND-COLOR: #DDDDDD; FONT-FAMILY: Verdana,Arial;
}

</style>

<july:browseform action="/ShowRespPaysList.do" styleId="RespPaysListForm">

<jsp:useBean id="RespPaysListForm" class="com.hps.july.arenda.formbean.RespPaysListForm" scope="session" />

<html:hidden property="contract"/>
<html:hidden property="adAction"/>
<html:hidden property="order"/>

<script language="javascript">
	stat=1;
	function setOrder(ord) {
		document.all.order.value = ord;
		submitForm();
	}
</script>

<table class="main" height="100%">

<july:separator/>

<tr class="normal">
	<td colspan="2">
		<table class="find" width="100%">
		<tr>
			<td class="title" style="font-size:9pt;font-weight:bold;"><bean:message key="label.resppays.operator"/>:</td>
			<td class="text" style="font-weight: normal; font-size:9pt;">
				<table border=0 cellpadding=0 cellspacing=0><tr>
					<td><july:string property="operatorFrm" styleId="operator" size="5" insertable="true" updatable="true" styleClass="editkodsearch" style="font-size:9pt;"/></td>
					<td style="padding-left:4px;padding-right:4px;"><july:lookupbutton action="/ShowWorkerLookupList.do" styleId="workl" fieldNames="operator;operatorName" newWindowName="workerlookup" insertable="true" updatable="true"/></td>
					<td><july:string size="35" property="operatorName" styleId="operatorName" insertable="false" updatable="false" style="font-size:9pt;"/></td>
				</tr></table>
			</td>
			<td class="text" width="16%" style="text-align:center;" rowspan="2">
<input type='image' src='/images/recalc.gif' onclick='document.body.style.cursor="wait";document.all.adAction.value="C";' title="Пересчитать" border='0' alt=''>
			</td>
		</tr>
		<tr>
			<td class="title" style="font-size:9pt;"><bean:message key="label.resppays.date"/>:</td>
			<td class="text" style="font-weight: normal; font-size:9pt;">
				<table border=0 cellpadding=0 cellspacing=0><tr>
					<td style="font-weight: normal; font-size:9pt; padding-right:3px;">с</td>
					<td><july:date property="rdateFromFrm" size="25" insertable="true" updatable="true" styleId="rdateFromDate"/></td>
					<td style="font-weight: normal; font-size:9pt; padding-left:3px; padding-right:3px;">по</td>
					<td><july:date property="rdateTillFrm" size="25" insertable="true" updatable="true" styleId="rdateTillDate"/></td>
				</tr></table>
			</td>
		</tr>
		</table>
	</TD>
</TR>

<july:separator/>

<tr class="normal">
	<td colspan="2">
		<table class="find" width="100%">
		<tr>
			<td class="text" width="17%" style="font-size:9pt;"><bean:message key="label.resppays.period"/>:</td>
			<td class="text" width="67%" style="font-weight: normal; font-size:9pt;">
				<july:checkbox property="periodMonth" insertable="true" updatable="true"/>&nbsp;<bean:message key="label.resppays.period.M"/>
				<july:checkbox property="periodQuartal" insertable="true" updatable="true"/>&nbsp;<bean:message key="label.resppays.period.Q"/>
				<july:checkbox property="periodYear" insertable="true" updatable="true"/>&nbsp;<bean:message key="label.resppays.period.Y"/>
			</td>
			<td class="text" rowspan="3" width="16%" style="text-align:center;">
<input type='image' src='/images/refresh.gif' onclick='document.body.style.cursor="wait";' title="Отфильтровать" border='0' alt=''>
			</td>
		</tr>
		<tr>
			<td class="text" style="font-size:9pt;"><bean:message key="label.resppays.payreq"/>:</td>
			<td class="text" style="font-weight: normal; font-size:9pt;">
				<july:radio property="payreq" value="A" insertable="true" updatable="true" styleClass="editcheckbox"/><bean:message key="label.resppays.payreq.A"/>
				<july:radio property="payreq" value="H" insertable="true" updatable="true" styleClass="editcheckbox"/><bean:message key="label.resppays.payreq.H"/>
			</td>
		</tr>
		<tr>
			<td class="text" style="font-size:9pt;"><bean:message key="label.resppays.type"/>:</td>
			<td class="text" style="font-weight: normal; font-size:9pt;">
				<july:checkbox property="typeAvans" insertable="true" updatable="true"/>&nbsp;<bean:message key="label.resppays.type.A"/>
				<july:checkbox property="typeBybill" insertable="true" updatable="true"/>&nbsp;<bean:message key="label.resppays.type.B"/>
				<july:checkbox property="typeByend" insertable="true" updatable="true"/>&nbsp;<bean:message key="label.resppays.type.C"/>
			</td>
		</tr>
		</table>
	</TD>
</TR>

<july:separator/>
	
<tr class="title" style="height:15px;">
	<td colspan="2">
		<table class="buttons">
		<tr class="title">
			<td class="buttons">
				<july:backbutton/>
			</td>
			<td class="navigator"><july:navigator/></td>
		</tr>
		</table>
	</td>
</tr>

<july:separator/>

<tr>
<td style="height:100%;padding:0px;vertical-align:top;" colspan="2">
<table cellpadding=2 cellspacing=1 border=0 width="100%">
	<tr class="title">
		<td class="ttitle" width="2%">&nbsp;</td>
		<td class="ttitle" width="6%">Beeline</td>
		<td class="ttitle" width="10%">
<table border="0" cellpadding="0" cellspacing="0">
<tr>
	<td class="ttitle"><bean:message key="label.resppays.tlb.bs"/></td>
	<td class="ttitle" align="right"><A href="#" onclick="setOrder('posname ASC'); return false;"><img src="/images/up.gif"  border="0" alt="Сортировать по возрастанию"></A><br><A href="#" onclick="setOrder('posname DESC'); return false;"><img src="/images/down.gif"  border="0" alt="Сортировать по убыванию"></A></td>
</tr>
</table>
		</td>
		<td class="ttitle" width="10%">
<table border="0" cellpadding="0" cellspacing="0">
<tr>
	<td class="ttitle"><bean:message key="label.resppays.tlb.exec"/></td>
	<td class="ttitle" align="right"><A href="#" onclick="setOrder('arendodatelname ASC'); return false;"><img src="/images/up.gif"  border="0" alt="Сортировать по возрастанию"></A><br><A href="#" onclick="setOrder('arendodatelname DESC'); return false;"><img src="/images/down.gif"  border="0" alt="Сортировать по убыванию"></A></td>
</tr>
</table>
		</td>
		<td class="ttitle" width="6%"><bean:message key="label.resppays.tlb.inn"/></td>
		<td class="ttitle" width="6%"><bean:message key="label.resppays.tlb.vendor"/></td>
		<td class="ttitle" width="6%"><bean:message key="label.resppays.tlb.number"/></td>
		<td class="ttitle" width="6%"><bean:message key="label.resppays.tlb.date"/></td>
		<td class="ttitle" width="6%"><bean:message key="label.resppays.tlb.service"/></td>
		<td class="ttitle" width="6%"><bean:message key="label.resppays.tlb.type"/></td>
		<td class="ttitle" width="6%"><bean:message key="label.resppays.tlb.sum"/></td>
		<td class="ttitle" width="6%"><bean:message key="label.resppays.tlb.period"/></td>
		<td class="ttitle" width="5%"><bean:message key="label.resppays.tlb.paydate"/></td>
		<td class="ttitle" width="5%"><bean:message key="label.resppays.tlb.raterule"/></td>
		<td class="ttitle" width="5%"><bean:message key="label.resppays.tlb.condition"/></td>
		<td class="ttitle" width="5%"><bean:message key="label.resppays.tlb.lastpaydate"/></td>
		<td class="ttitle" width="5%"><bean:message key="label.resppays.tlb.payreq"/></td>
	</tr>
<logic:iterate id="it" name="browseList" type="com.hps.july.arenda.valueobject.RespPaysValueObject">
	<logic:present name="it">
	<%
		String trClass= (it.isPayreq()?"selected":"normal");
		String dogimg = "dog.gif";
		if(RespPaysListForm.getContract() != null && RespPaysListForm.getContract().intValue() == it.getBasecontract()) {
			dogimg = "dog_sel.gif";
		}
	%>


	<tr class="<%=trClass%>" onMouseOver="className='select'" onMouseOut="className='<%=trClass%>'" style="height:24px;">
		<td class="mtext"><a class="sttext" href='/arenda/ShowDogHistoryList.do?contract=<bean:write name="it" property="basecontract" filter="true"/>&retparams=(contract=<bean:write name="it" property="basecontract" filter="true"/>)' title='<bean:message key="label.dhist.arendadog"/>'><img src="/images/<%=dogimg%>" border="0" hspace=0 vspace=0></a></td>
		<td class="stext"><bean:write name="it" property="beelinename" filter="true"/></td>
		<td class="stext"><bean:write name="it" property="bsname" filter="true"/></td>
		<td class="stext"><bean:write name="it" property="arendodatelname" filter="true"/></td>
		<td class="stext"><bean:write name="it" property="arendodatelinn" filter="true"/></td>
		<td class="stext"><bean:write name="it" property="vendor" filter="true"/></td>
		<td class="stext"><bean:write name="it" property="number" filter="true"/></td>
		<td class="stext"><july:datewrite name="it" property="date"/></td>
		<td class="stext"><bean:write name="it" property="servicename" filter="true"/></td>
		<td class="stext">
			<logic:present name="it" property="pptype">
				<logic:equal name="it" property="pptype" value="A">
					<bean:message key="label.resppays.type.A"/>
				</logic:equal>
				<logic:equal name="it" property="pptype" value="B">
					<bean:message key="label.resppays.type.B"/>
				</logic:equal>
				<logic:equal name="it" property="pptype" value="C">
					<bean:message key="label.resppays.type.C"/>
				</logic:equal>
			</logic:present>
		</td>
		<td class="stext"><nobr><july:numberwrite name="it" property="sum" fractdigits="2"/></nobr> <bean:write name="it" property="currencyname" filter="true"/></td>
		<td class="stext">
			<logic:present name="it" property="periodpay">
				<logic:equal name="it" property="periodpay" value="M">
					<bean:message key="label.resppays.period.M"/>
				</logic:equal>
				<logic:equal name="it" property="periodpay" value="Q">
					<bean:message key="label.resppays.period.Q"/>
				</logic:equal>
				<logic:equal name="it" property="periodpay" value="Y">
					<bean:message key="label.resppays.period.Y"/>
				</logic:equal>
			</logic:present>
		</td>
		<td class="stext"><bean:write name="it" property="paydate" filter="true"/></td>
		<td class="stext"><bean:write name="it" property="raterule" filter="true"/></td>
		<td class="stext"><bean:write name="it" property="condition" filter="true"/></td>
		<td class="mtext"><logic:present name="it" property="lastpay"><logic:present name="it" property="lastpay.pay"><img src="/images/infohint.gif" border="0" title='<logic:present name="it" property="lastpay.number">№ <bean:write name="it" property="lastpay.number" filter="true"/> от </logic:present><july:datewrite name="it" property="lastpay.date"/>&#10;Сумма в рублях: <july:numberwrite name="it" property="lastpay.sumrub" fractdigits="2"/>&#10;Назначение ПП: <bean:write name="it" property="lastpay.purpose" filter="true"/>'></logic:present></logic:present></td>
		<td class="mtext"><logic:present name="it" property="payreq"><logic:equal name="it" property="payreq" value="true"><img src="/images/money.gif" border="0" title='Требуется оплата' hspace=0 vspace=0></logic:equal></logic:present></td>
	</tr>
	</logic:present>
	<logic:notPresent name="it">
	<tr class="normal">
		<td class="stext" colspan="17"><bean:message key="label.norecords"/></td>
	</tr>
	</logic:notPresent>
</logic:iterate>
</table>
</td>
</tr>

<july:separator/>

<tr class="title" style="height:15px;">
	<td colspan="2">
		<table class="buttons">
		<tr class="title">
			<td class="buttons">
				<july:backbutton/>
			</td>
			<td class="navigator"><july:navigator/></td>
		</tr>
		</table>
	</td>
</tr>
	
<july:separator/>

</table>

</july:browseform>
			
