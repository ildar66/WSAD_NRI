<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.arenda.formbean.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<SCRIPT language=javascript src="/common/validate.js" type="text/javascript"></SCRIPT> 

<% String gColSpan = "2"; %>
<july:editform action="/ProcessWeArenda.do" styleId="WeArendaForm" enctype="multipart/form-data">

<html:hidden property="leaseDocument"/>
<html:hidden property="orgExecutorcodeFrm"/>
<html:hidden property="economistcodeFrm"/>
<html:hidden property="managercodeFrm"/>
<html:hidden property="docFileName"/>
<html:hidden property="rur"/>
<html:hidden property="isPositionSelected" value="false"/>

<script language='javascript'>
function Check(){
	with(WeArendaForm){
		if (document.all.isRateLimit[0].checked) {
			if(!field_check(WeArendaForm.rateLimitMin, 'Ограничение курса c', 8, true)) return false;
			if(!field_check(WeArendaForm.rateLimitMax, 'Ограничение курса по', 8, true)) return false;
		}
	}
	return true;
}

function showTerrabyteWin(s) {
	<logic:present name="WeArendaForm" property="mainDocument">
			s = s + '&id=<bean:write property="mainDocument" name="WeArendaForm"/>';
	</logic:present>
	<logic:notPresent name="WeArendaForm" property="mainDocument">
			s = s + '&id=<bean:write property="leaseDocument" name="WeArendaForm"/>';
	</logic:notPresent>
	if(!s) s = "";
	var terrabyteWin = window.open("<%=com.hps.july.util.AppUtils.getNamedValueString("TerrabyteURL")%>?type=leasedoc&uid=<%=request.getRemoteUser()%>" + s, "terrabyteWin", "top=60, left=60, height=" + (screen.availHeight-150) + ", width=" + (screen.availWidth-150) + ", fullscreen=no,location=no,menubar=no,resizable=yes,scrollbars=yes,status=no,titlebar=yes,toolbar=no");
	if(terrabyteWin) terrabyteWin.focus();
}

var isAddRate = 0;
function fix(fixNumber, decimalPlaces) {
	var div = Math.pow(10, decimalPlaces);
	return fixNumber = Math.round(fixNumber * div) / div;
}
function r() {
	if ((document.all.datecount.value == '') || (document.all.datecount.value.charAt(0) == ' ') ||
		((document.all.datecount.value.charAt(0) != 0) && (document.all.datecount.value.charAt(0) != 1) &&
		(document.all.datecount.value.charAt(0) != 2) && (document.all.datecount.value.charAt(0) != 3) &&
		(document.all.datecount.value.charAt(0) != 4) && (document.all.datecount.value.charAt(0) != 5) &&
		(document.all.datecount.value.charAt(0) != 6) && (document.all.datecount.value.charAt(0) != 7) &&
		(document.all.datecount.value.charAt(0) != 8) && (document.all.datecount.value.charAt(0) != 9)))
	{
		return;
	}
	var i = parseInt(document.all.datecount.value);
	var tempDate = new Date();
	tempDate.setTime((WeArendaForm.startDate_dt.gDate - 25569 ) * 86400000); 
	if (document.all.periodexp[0].checked) {
		tempDate.setYear(tempDate.getYear() + i);
	} else if (document.all.periodexp[1].checked) {
		tempDate.setMonth(tempDate.getMonth() + i);
	} else if (document.all.periodexp[2].checked) {
		tempDate.setDate(tempDate.getDate() + i);
	}
	setDate_baseEndDate(fix((tempDate.getTime() / 86400000.0), 0) + 25569 - 1); 
	<%-- -1 is used due to Bortsov requests --%>
	//WeArendaForm.baseEndDate.value = (tempDate.getDate()) + '.' + (tempDate.getMonth() + 1) + '.' + tempDate.getYear();
	//тоже и для "EndDate":
	//WeArendaForm.endDate.value = (tempDate.getDate()) + '.' + (tempDate.getMonth() + 1) + '.' + tempDate.getYear();
	WeArendaForm.endDate.value = WeArendaForm.baseEndDate.value;
}
function switchLight() {
	if (WeArendaForm.eldate_dt == null)
		return;
	if (document.all.isDogElectro[0].checked) {
		WeArendaForm.eldate_dt.enabled = true;
		WeArendaForm.elnum.className = 'editsmall';
		WeArendaForm.elnum.disabled = false;
	} else {
		WeArendaForm.eldate_dt.enabled = false;
		WeArendaForm.elnum.className = 'editsmalldisabled';
		WeArendaForm.elnum.disabled = true;
	}
}
function swithRateDay() {
	if (document.all.ratecalcrule.value == 'F' || document.all.ratecalcrule.value == 'G') {
		WeArendaForm.ratecalcruleday.className = 'edit';
		WeArendaForm.ratecalcruleday.disabled = false
	} else {
		WeArendaForm.ratecalcruleday.className = 'editdisabled';
		WeArendaForm.ratecalcruleday.disabled = true;
	}
}
function copyDocDate() {
	WeArendaForm.startDate_dt.gDate = WeArendaForm.docDate_dt.gDate;
	WeArendaForm.startDate.value = WeArendaForm.docDate.value;
}
function checkRates() {
	if (WeArendaForm.currencycode1.value == document.all.rur.value) {
		document.all.ratecalcrule.disabled = true;
		document.all.ratecalcrule.className = "editdisabled";
		document.all.ratecalcrule.options[document.all.ratecalcrule.length] = new Option("", "");
		document.all.ratecalcrule.selectedIndex = document.all.ratecalcrule.length - 1;
		isAddRate = 1;
		
		document.all.ratecalcruleday.disabled = true;
		document.all.ratecalcruleday.className = "editdisabled";
		document.all.ratedeltaFrm.disabled = true;
		document.all.ratedeltaFrm.className = "editdisabled";
	} else {
		document.all.ratecalcrule.disabled = false;
		document.all.ratecalcrule.className = "edit";
		if (isAddRate == 1) {
			document.all.ratecalcrule.options[document.all.ratecalcrule.length - 1] = null;
			isAddRate = 0;
		}
		
		swithRateDay();
		document.all.ratedeltaFrm.disabled = false;
		document.all.ratedeltaFrm.className = "edit";
	}
}
function switchBaseDate(){
	//alert("switchBaseDate()");
	WeArendaForm.endDate.value = WeArendaForm.baseEndDate.value;
}
function switchHaveIoAct() {
	if (WeArendaForm.ioActDate_dt == null)
		return;
	if (document.all.haveioact[0].checked) {
		WeArendaForm.ioActDate_dt.enabled = true;
		WeArendaForm.ioActNumber.className = 'editsmall';
		WeArendaForm.ioActNumber.disabled = false;
	} else {
		WeArendaForm.ioActDate_dt.enabled = false;
		WeArendaForm.ioActNumber.className = 'editsmalldisabled';
		WeArendaForm.ioActNumber.disabled = true;
	}
}
function switchRateLimit() {
	if (document.all.isRateLimit[0].checked) {
		WeArendaForm.rateLimitMin.className = 'edit';
		WeArendaForm.rateLimitMin.disabled = false;
		WeArendaForm.rateLimitMax.className = 'edit';
		WeArendaForm.rateLimitMax.disabled = false;		
	} else {
		WeArendaForm.rateLimitMin.className = 'editdisabled';
		WeArendaForm.rateLimitMin.disabled = true;
		WeArendaForm.rateLimitMax.className = 'editdisabled';
		WeArendaForm.rateLimitMax.disabled = true;		
	}
}
</script>

<% String isNotMain = "true"; %>
<logic:present name="WeArendaForm" property="mainDocument">
	<% isNotMain = "false"; %>
</logic:present>
<% String isCertain = "true"; %>
<logic:equal name="WeArendaForm" property="action" value="Add">
	<% isCertain = "false"; %>
</logic:equal>
<% String isUpdatable = "false"; %>
<logic:equal name="WeArendaForm" property="contractState" value="A">
	<% isUpdatable = "true"; %>
</logic:equal>
<% String isUpdatableNew = "true"; %>
<logic:equal name="WeArendaForm" property="contractState" value="C">
	<% isUpdatableNew = "false"; %>
</logic:equal>

<table class="main" style="font-size: 9pt">

	<july:separator colspan="<%= gColSpan %>"/>

	<tr>
		<td class="title" colspan="<%= gColSpan %>"><july:actionalert/></td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>
	
	<logic:equal name="WeArendaForm" property="action" value="View">
		
		<jsp:include page="/weArendaFormPatch1.jsp" flush="true"></jsp:include>
		
	</logic:equal>
	
	<tr>
		<td class="text"><july:reqmark>Договор:</july:reqmark></td>
		<td class="text">
			<logic:present name="WeArendaForm" property="mainDocument">
				№ <july:string size="25" property="mainDocumentNumber" insertable="false" updatable="false"/>&nbsp;&nbsp;&nbsp;
				Дата:<july:date property="mainDocumentDateFrm" size="25" insertable="false" updatable="false" style="vertical-align: top"/>
			</logic:present>
			<logic:notPresent name="WeArendaForm" property="mainDocument">
				№ <july:string size="25" property="documentNumber" insertable="true" updatable="<%=isUpdatable%>"/>&nbsp;&nbsp;&nbsp;
				Дата:<july:date property="documentDateFrm" size="25" insertable="true" updatable="<%=isUpdatable%>" required="<%= isCertain %>" styleId="docDate" style="vertical-align: top;"/>
			</logic:notPresent>
		</td>
	</tr>
	
	<logic:equal name="WeArendaForm" property="weArandaFormView.buchdoc" value="true">	
	<tr>
		<td class="text" align="right"><bean:write name="WeArendaForm" property="weArandaFormView.nameAccounting"/>:</td>
		<td class="text">
			<logic:present name="WeArendaForm" property="mainDocument">
				№ <july:string size="25" property="mainBuchDocNumber" insertable="false" updatable="false"/>&nbsp;&nbsp;&nbsp;
				Созд:<INPUT TYPE="TEXT"  NAME="mainCreatedView" VALUE='<july:datewrite name="WeArendaForm" property="mainCreated" showtime="true" />' READONLY="true" class="editdisabled">
			</logic:present>
			<logic:notPresent name="WeArendaForm" property="mainDocument">
				№ <july:string size="25" property="buchdocnumber" insertable="true" updatable="<%=isUpdatable%>"/>&nbsp;&nbsp;&nbsp;
				Созд:<INPUT TYPE="TEXT"  NAME="createdView" VALUE='<july:datewrite name="WeArendaForm" property="created" showtime="true"/>' READONLY="true" class="editdisabled">
			</logic:notPresent>
		</td>
	</tr>	
	</logic:equal>
	
	<logic:present name="WeArendaForm" property="mainDocument">
	
		<july:separator colspan="<%= gColSpan %>"/>
	
		<tr>
			<td class="text"><july:reqmark>Доп.Соглашение:</july:reqmark></td>
			<td class="text">
				№ <july:string size="25" property="documentNumber" insertable="true" updatable="<%=isUpdatable%>"/>&nbsp;&nbsp;&nbsp;
				Дата:<july:date property="documentDateFrm" size="25" insertable="true" updatable="<%=isUpdatable%>" required="<%= isCertain %>" styleId="docDate" style="vertical-align: top"/>
			</td>
		</tr>
		<logic:equal name="WeArendaForm" property="weArandaFormView.buchdoc" value="true">
		<tr>
			<td class="text" align="right"><bean:write name="WeArendaForm" property="weArandaFormView.nameAccounting"/>:</td>
			<td class="text">
				№ <july:string size="25" property="buchdocnumber" insertable="true" updatable="<%=isUpdatable%>"/>&nbsp;&nbsp;&nbsp;
				Созд:<INPUT TYPE="TEXT"  NAME="createdView" VALUE='<july:datewrite name="WeArendaForm" property="created" showtime="true"/>' READONLY="true" class="editdisabled">
			</td>
		</tr>		
		</logic:equal>
	</logic:present>
	
	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<td class="text"><july:reqmark><bean:message key="label.filter.customer"/>:</july:reqmark></td>
		<td class="text">
			<july:select styleId="orgCustomer" style="width: 300;" collection="customers" property="orgCustomercode" insertable="<%= isNotMain %>" updatable="<%= String.valueOf(Boolean.valueOf(isNotMain).booleanValue() && Boolean.valueOf(isUpdatable).booleanValue()) %>">
				<html:option value="">&nbsp;</html:option>
				<html:options collection="customers" property="idOwnerContract" labelProperty="name"/>
			</july:select>
		</td>
	</tr>
	
	<tr>
		<td class="text"><july:reqmark>Арендодатель:</july:reqmark></td>
		<td class="text">
			<%--july:lookupbutton action="/ShowOrganizationLookupList.do" styleId="execl" fieldNames="orgExecutorcodeFrm;orgExecutorname" newWindowName="execlookup" insertable="<%= isNotMain %>" updatable="<%= String.valueOf(Boolean.valueOf(isNotMain).booleanValue() && Boolean.valueOf(isUpdatable).booleanValue()) %>"/--%>
			<logic:notEqual name="WeArendaForm" property="action" value="View">
				<% if(Boolean.valueOf(isNotMain).booleanValue() && Boolean.valueOf(isUpdatable).booleanValue()){ %>
					<html:link page="/../dict/VendorSiteLookupList.do?formname=WeArendaForm&fieldnames=orgExecutorcodeFrm||orgExecutorname" onclick="return openDialog(this.href, 'VendorSitesLookupList', 'top=40, left=100, width=700, height=650, scrollbars=yes, resizable=yes');" title="справочник отделений">
						<img src='/images/lookup.gif' border='0' alt='Справочник поставщиков' name="lookupimg_execl"></html:link>						
				<% } %>
			</logic:notEqual>
			<july:string size="50" property="orgExecutorname" styleId="orgExecutorname" insertable="false" updatable="false"/>
			<logic:equal name="WeArendaForm" property="action" value="View">
				<img src='/images/doc.gif' border=0 alt='<bean:message key="label.organization.inn"/>:&nbsp;<bean:write name="WeArendaForm" property="inn" filter="true"/>&#10;<bean:message key="label.organization.kpp"/>:&nbsp;<bean:write name="WeArendaForm" property="kpp" filter="true"/>&#10;<bean:message key="label.organization.legaladdress"/>:&nbsp;<bean:write name="WeArendaForm" property="legaladdress" filter="true"/>'>
			</logic:equal>
		</td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>

	<tr>
		<td class="text"><july:reqmark><bean:message key="label.mainPosition"/></july:reqmark></td>
		<td class="text">
			<html:hidden property="position"/>
			<logic:equal name="WeArendaForm" property="action" value="Add">
				<july:lookupbutton action="/../basestation/ShowPositionLookupList.do?planstate=2" styleId="posl" fieldNames="position;;positionname" insertable="<%= isNotMain %>" updatable="<%= String.valueOf(Boolean.valueOf(isNotMain).booleanValue() && Boolean.valueOf(isUpdatable).booleanValue()) %>" onselect="document.all.isPositionSelected.value='true';document.forms(0).submit();"/>
			</logic:equal>
			<july:string size="50" property="positionname" styleId="positionname" insertable="false" updatable="false"/>
		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<td class="text"><bean:message key="label.filter.docsubject"/>:</td>
		<td class="text"><july:textarea cols="50" rows="2" property="subject" insertable="true" updatable="<%=isUpdatable%>"/></td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<td class="text">Годовая стоимость:</td>
		<td class="text">
			<july:string size="5" style="width: 100;" property="summ1Frm" insertable="true" updatable="<%=isUpdatable%>"/>&nbsp;
			месяц: <july:string size="5" style="width: 100;" property="summ1MounthFrm" insertable="false" updatable="false"/>&nbsp;
		    <july:select style="width: 130;" collection="currencies" property="currencycode1" insertable="true" updatable="<%=isUpdatable%>" onchange="checkRates();">
				<html:options collection="currencies" property="currency" labelProperty="name"/>
		   	</july:select>
			<july:select style="width: 100;" property="chargeNds" insertable="true" updatable="<%=isUpdatable%>">
				<html:option value="true">без НДС</html:option>
				<html:option value="false">НДС в т.ч.</html:option>
			</july:select>
		</td>
	</tr>
	
	<tr>
		<td class="text">Ставка НДС:</td>
		<td class="text">
			<july:string size="10" property="rateNDSFrm" insertable="true" updatable="<%=isUpdatable%>"/>&nbsp;&nbsp;&nbsp;
			Признак "Налоговый агент"
			<july:checkbox property="nalogAgent" insertable="true" updatable="<%=isUpdatable%>"/>
		</td>
	</tr>	

	<july:separator colspan="<%= gColSpan %>"/>

		<tr>
			<td class="text">&nbsp;</td>
			<td class="text">
				Регистрация в гос.органах:
				<july:checkbox property="needofficialdoc" insertable="<%=isUpdatable%>" updatable="<%=isUpdatableNew%>"/>				
				необходима&nbsp;&nbsp;&nbsp;
				<july:checkbox property="officialdoc" insertable="<%=isUpdatable%>" updatable="<%=isUpdatableNew%>"/>
				зарегистрирован
			</td>
		</tr>

	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<td class="text"><bean:message key="label.filter.state"/>:</july:reqmark></td>
		<td class="text">
			<logic:equal name="WeArendaForm" property="contractState" value="A">
				<INPUT TYPE="TEXT"  NAME="contractStateView"  VALUE='<bean:message key="label.state.prepared"/>'  READONLY="true" class="editdisabled">
			</logic:equal>
			<logic:equal name="WeArendaForm" property="contractState" value="B">
				<INPUT TYPE="TEXT"  NAME="contractStateView"  VALUE='<bean:message key="label.state.continued"/>'  READONLY="true" class="editdisabled">
			</logic:equal>
			<logic:equal name="WeArendaForm" property="contractState" value="C">
				<INPUT TYPE="TEXT"  NAME="contractStateView"  VALUE='<bean:message key="label.state.stoped"/>&nbsp;<july:datewrite name="WeArendaForm" property="dateclose"/>'  READONLY="true"  class="editdisabled">
			</logic:equal>
			<logic:equal name="WeArendaForm" property="contractState" value="D"><bean:message key="label.state.unclosed"/></logic:equal>
		</td>
    </tr>
	
	<july:separator colspan="<%= gColSpan %>"/>

	<logic:notEqual name="WeArendaForm" property="action" value="Add">
	
		<tr>
			<td class="text"><july:reqmark>Срок действия:</july:reqmark></td>
			<td>
				<bean:message key="label.from"/>&nbsp;
				<july:date property="startDateFrm" size="25" insertable="true" updatable="<%=isUpdatable%>"/>&nbsp;
				<bean:message key="label.till"/>&nbsp;
				<july:date property="baseenddateFrm" size="25" insertable="true" updatable="<%=isUpdatable%>"
				styleId="baseEndDate"/>
			</td>
		</tr>
	
	</logic:notEqual>
	
	<logic:equal name="WeArendaForm" property="action" value="Add">
	
		<tr>
			<td class="text"><july:reqmark>Срок действия:</july:reqmark></td>
			<td class="text">
				<table border=0 class="main">
					<tr>
						<td nowrap>
							с:&nbsp; <july:date property="startDateFrm" size="25" insertable="true" updatable="true" styleId="startDate" required="false"/>
							<img src='/images/obchet1.gif' onclick='copyDocDate()' border='0' alt='<bean:message key="label.filter.calc"/>'>
							по:&nbsp;<july:date property="baseenddateFrm" size="25" insertable="true" updatable="true" required="false" styleId="baseEndDate" onchange="switchBaseDate();"/>
						</td>
						<td>
							<table border=0 class="main">
							<tr>
								<td align="left"><input type='Text' size='3' name='datecount'></td>
								<td align="left"><input type='Radio' name='periodexp' value='year' checked></td>
								<td align="left"><bean:message key="label.filter.year"/></td>
								<td align="left"><input type='Radio' name='periodexp' value='month'></td>
								<td align="left"><bean:message key="label.filter.month"/></td>
								<td align="left"><input type='Radio' name='periodexp' value='day'></td>
								<td align="left"><bean:message key="label.filter.day"/></td>
								<td align="left"><img src='/images/obchet1.gif' onclick='r()' border='0' alt='<bean:message key="label.filter.calc"/>'></td>
							</tr>
							</table>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</logic:equal>
	
	<july:separator colspan="<%= gColSpan %>"/>
	
	<jsp:include page="/weArendaFormPatch4.jsp" flush="true"></jsp:include>
	
	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<td class="text"><july:reqmark>Акт приема-передачи:</july:reqmark></td>
		<td class="text">
			<july:checkbox property="haveioact" insertable="true" updatable="<%=isNotMain%>" onclick="switchHaveIoAct();"/>&nbsp;№&nbsp;<july:string  size="5" style="width: 100px" property="ioactnumber" insertable="true" updatable="<%=isNotMain%>" styleId="ioActNumber"/>&nbsp;Дата:&nbsp;<july:date property="ioactdateFrm" size="25" insertable="true" updatable="<%=isNotMain%>" styleId="ioActDate"/>
		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>		
	
	<tr>
		<td class="text"><july:reqmark>Ответственные:</july:reqmark></td>
		<td class="text">экономист:
			<july:lookupbutton action="/ShowWorkerLookupList.do" styleId="economistl" fieldNames="economistcodeFrm;economistname" newWindowName="economistlookup" insertable="<%= isNotMain %>" updatable="<%= isNotMain %>"/>
			<july:string  size="25" style="width: 170px" property="economistname" styleId="economistname" insertable="false" updatable="false"/>
			менеджер:
			<july:lookupbutton action="/ShowWorkerLookupList.do" styleId="managerl" fieldNames="managercodeFrm;managername" newWindowName="managerlookup" insertable="<%= isNotMain %>" updatable="<%= isNotMain %>"/>
			<july:string  size="25" style="width: 170px" property="managername" styleId="managername" insertable="false" updatable="false"/>
		</td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>

	<tr>
        <td class="text">Комментарий:</td>
		<td class="text">
			<TABLE border=0 class="main" style="font-size: 8pt">
					<TR>
						<TD rowspan="2" class="text"><july:textarea style="width: 400;" cols="50" rows="4" property="comment" insertable="true" updatable="true" /></TD>
					<logic:equal name="WeArendaForm" property="weArandaFormView.buchdoc" value="true">
						<TD colspan="2" class="text">есть подписанный вариант договора:</TD>
					</logic:equal>
					</TR>
				<logic:equal name="WeArendaForm" property="weArandaFormView.buchdoc" value="true">
					<TR>
						<TD class="text"><july:checkbox property="havedocsigned" insertable="true" updatable="<%=isNotMain%>"/><br>у нас</TD>
						<TD class="text"><july:checkbox property="havedocsignedcustomer" insertable="true" updatable="<%=isNotMain%>"/><br>у арендодателя</TD>						
					</TR>
				</logic:equal>
			</TABLE>
		</td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<td class="text"><bean:message key="label.filter.text"/>:</td>
		<td class="text">
			<html:link page="/DocumentDownload?param=documentText" paramId="leaseDocument" paramName="WeArendaForm" paramProperty="leaseDocument" target="_blank">
				<bean:write name="WeArendaForm" property="docFileName" filter="true"/>
			</html:link>
			<%--logic:present name="WeArendaForm" property="docFileName">&nbsp;</logic:present--%>
			<logic:notPresent name="WeArendaForm" property="docFileName">Документы доступны в режиме Договор аренды(&uml;Документы аренды&uml;)</logic:notPresent>
			<%--logic:notEqual name="WeArendaForm" property="action" value="View">
				<html:file property="formFile"/>&nbsp;
				<bean:message key="label.delete"/>&nbsp;
				<july:checkbox property="isDocumentText" insertable="true" updatable="true" value="true"/>
			</logic:notEqual--%>
		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>
	
	<logic:notEqual name="WeArendaForm" property="action" value="View">
	
		<tr>
			<td class="text">Правило опр. курса :</td>
			<td class="text">
				<july:select style="width: 450;" property="ratecalcrule" insertable="true" updatable="<%=isUpdatable%>" onclick="swithRateDay();" styleId="ratecalcrule">
					<html:option value=""/>
					<html:option key="label.filter.ratecalcrule.a" value="A"/>
					<html:option key="label.filter.ratecalcrule.b" value="B"/>
					<html:option key="label.filter.ratecalcrule.c" value="C"/>
					<html:option key="label.filter.ratecalcrule.d" value="D"/>
					<html:option key="label.filter.ratecalcrule.e" value="E"/>
					<html:option value="F"><bean:message key="label.filter.ratecalcrule.f" arg0="?"/></html:option>
					<html:option value="G"><bean:message key="label.filter.ratecalcrule.g" arg0="?"/></html:option>
					<html:option key="label.filter.ratecalcrule.h" value="H"/>
					<html:option key="label.filter.ratecalcrule.i" value="I"/>
					<html:option value="K">По фиксированному курсу</html:option>
				</july:select><BR>
				День:<july:string size="5" style="width: 30;" property="ratecalcruledayFrm" styleId="ratecalcruleday" insertable="true" updatable="<%=isUpdatable%>"/>
				Наценка,%:<july:string size="5" style="width: 60;" property="ratedeltaFrm" insertable="true" updatable="<%=isUpdatable%>" styleId="ratedeltaFrm"/>
				<A href="#" title="Ограничение курса(минимальный и максимальный)" style="text-decoration: none; ">Огр. курса:</A><july:checkbox property="isRateLimit" insertable="true" updatable="<%=isUpdatable%>" onclick="switchRateLimit();"/>
				<A href="#" title="минимальный курс" style="text-decoration: none; ">c </A><july:string size="5" style="width: 70;" property="rateLimitMinFrm" styleId="rateLimitMin" insertable="true" updatable="<%=isUpdatable%>"/>
				<A href="#" title="максимальный курс" style="text-decoration: none; ">по </A><july:string size="5" style="width: 70;" property="rateLimitMaxFrm" styleId="rateLimitMax" insertable="true" updatable="<%=isUpdatable%>"/>
			</td>
		</tr>
		
		<july:separator colspan="<%= gColSpan %>"/>
		
	</logic:notEqual>
	
	<logic:equal name="WeArendaForm" property="action" value="View">
		<logic:present name="WeArendaForm" property="ratecalcrule">
			<tr>
				<td class="text">Правило опр. курса :</td>
				<td class="text">
					<logic:equal name="WeArendaForm" property="ratecalcrule" value="A">
						<INPUT TYPE="TEXT"  NAME="contractStateView"  VALUE='<bean:message key="label.filter.ratecalcrule.a"/>'  READONLY="true"  class="editdisabled">
					</logic:equal>
					<logic:equal name="WeArendaForm" property="ratecalcrule" value="B">
						<INPUT TYPE="TEXT"  NAME="contractStateView"  VALUE='<bean:message key="label.filter.ratecalcrule.b"/>'  READONLY="true"  class="editdisabled">						
					</logic:equal>
					<logic:equal name="WeArendaForm" property="ratecalcrule" value="C">
						<INPUT TYPE="TEXT"  NAME="contractStateView"  VALUE='<bean:message key="label.filter.ratecalcrule.c"/>'  READONLY="true"  class="editdisabled">						
					</logic:equal>
					<logic:equal name="WeArendaForm" property="ratecalcrule" value="D">
						<INPUT TYPE="TEXT"  NAME="contractStateView"  VALUE='<bean:message key="label.filter.ratecalcrule.d"/>'  READONLY="true"  class="editdisabled">						
					</logic:equal>
					<logic:equal name="WeArendaForm" property="ratecalcrule" value="E">
						<INPUT TYPE="TEXT"  NAME="contractStateView"  VALUE='<bean:message key="label.filter.ratecalcrule.e"/>'  READONLY="true"  class="editdisabled">						
					</logic:equal>
					<%	WeArendaForm formBean = ((WeArendaForm) request.getSession().getAttribute("WeArendaForm")); %>
					<logic:equal name="WeArendaForm" property="ratecalcrule" value="F">
						<INPUT TYPE="TEXT"  NAME="contractStateView"  VALUE='<bean:message key="label.filter.ratecalcrule.f" arg0="<%= formBean.getRatecalcruledayFrm() %>"/>'  READONLY="true"  class="editbigestdisabled">
					</logic:equal>
					<logic:equal name="WeArendaForm" property="ratecalcrule" value="G">
						<INPUT TYPE="TEXT"  NAME="contractStateView"  VALUE='<bean:message key="label.filter.ratecalcrule.g" arg0="<%= formBean.getRatecalcruledayFrm() %>"/>'  READONLY="true"  class="editbigestdisabled">						
					</logic:equal>
					<logic:equal name="WeArendaForm" property="ratecalcrule" value="H">
						<INPUT TYPE="TEXT"  NAME="contractStateView"  VALUE='<bean:message key="label.filter.ratecalcrule.h"/>'  READONLY="true"  class="editdisabled">
					</logic:equal>
					<logic:equal name="WeArendaForm" property="ratecalcrule" value="I">
						<INPUT TYPE="TEXT"  NAME="contractStateView"  VALUE='<bean:message key="label.filter.ratecalcrule.i"/>'  READONLY="true"  class="editdisabled">						
					</logic:equal>
					&nbsp;Наценка:
					<july:string size="5" property="ratedeltaFrm" insertable="true" updatable="true" styleId="ratedeltaFrm"/><BR>
					<A href="#" title="Ограничение курса(минимальный и максимальный)" style="text-decoration: none; ">Огр. курса:</A><july:checkbox property="isRateLimit" insertable="true" updatable="<%=isUpdatable%>" onclick="switchRateLimit();"/>
					<A href="#" title="минимальный курс" style="text-decoration: none; ">c </A><july:string size="5" style="width: 70;" property="rateLimitMinFrm" styleId="rateLimitMin" insertable="true" updatable="<%=isUpdatable%>"/>
					<A href="#" title="максимальный курс" style="text-decoration: none; ">по </A><july:string size="5" style="width: 70;" property="rateLimitMaxFrm" styleId="rateLimitMax" insertable="true" updatable="<%=isUpdatable%>"/>					
				</td>
			</tr>
		
			<july:separator colspan="<%= gColSpan %>"/>
		</logic:present>
	</logic:equal>
	
	<%-- platinum >
	<logic:present name="WeArendaForm" property="SYNCNRIPLATINARENDA">			
		<logic:notEqual name="WeArendaForm" property="action" value="Add">
			<logic:notEqual name="WeArendaForm" property="action" value="Edit">
			
				<tr>
					<td class="text"><bean:message key="label.platinum.dogovorcode"/>:</td>
					<td class="text"><july:string property="vendor" size="20" insertable="false" updatable="false"/></td>
				</tr>
				
				<july:separator colspan="<%= gColSpan %>"/>
				
			</logic:notEqual>
		</logic:notEqual>
	</logic:present>
    < platinum end --%>
	
	<logic:equal name="WeArendaForm" property="action" value="View">
	
		<jsp:include page="/weArendaBrowse1.jsp" flush="true"></jsp:include>
		<jsp:include page="/weArendaBrowse2.jsp" flush="true"></jsp:include>
		<jsp:include page="/weArendaBrowse3.jsp" flush="true"></jsp:include>

    </logic:equal>
	
    <logic:equal name="WeArendaForm" property="action" value="Add">
	
		<tr class="title">
			<td class="title" colspan="<%= gColSpan %>">
				<bean:message key="label.positions"/>&nbsp;-&nbsp;<bean:message key="label.nodata"/>
			</td>
		</tr>

		<july:separator colspan="<%= gColSpan %>"/>
		
		<tr class="title">
			<td class="title" colspan="<%= gColSpan %>">
				<bean:message key="label.chargerules"/>&nbsp;-&nbsp;<bean:message key="label.nodata"/>
			</td>
		</tr>
		
		<july:separator colspan="<%= gColSpan %>"/>
		
		<tr class="title">
			<td class="title" colspan="<%= gColSpan %>">
				<bean:message key="label.payrules"/>&nbsp;-&nbsp;<bean:message key="label.nodata"/>
			</td>
		</tr>
		
		<july:separator colspan="<%= gColSpan %>"/>
		
    </logic:equal>
	
	<july:formbuttons onsave="if(!Check())return false;">
		<logic:equal name="WeArendaForm" property="action" value="Delete">
			<july:delbutton page="/DeleteWeArenda.do?action=Delete" title="Удалить каскадно с правилами начислений и оплаты"/>
		</logic:equal>
	</july:formbuttons>

	<july:separator colspan="<%= gColSpan %>"/>

</table>

<logic:notEqual name="WeArendaForm" property="action" value="View">
	<logic:notEqual name="WeArendaForm" property="action" value="Delete">
		<script language='javascript'>
			swithRateDay();
			switchLight();
			switchHaveIoAct();
			switchRateLimit();
		</script>
	</logic:notEqual>
</logic:notEqual>

</july:editform>
