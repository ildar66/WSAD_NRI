<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.arenda.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<SCRIPT language=javascript src="/common/validate.js" type="text/javascript"></SCRIPT> 

<% java.lang.String gColSpan = "2"; %>

<%
	String action = "/DnopProcess.do";
	String form = "DnopDialogForm";
	String temp = null;
	String src = "/images/save.gif";
	String alt = "Сохранить запись";	
%>
<july:errors property="org.apache.struts.action.GLOBAL_ERROR"/>

<july:editform action="<%= action %>" styleId="<%= form %>">

<html:hidden property="leaseCharge"/>
<html:hidden property="leasePayment"/>

<logic:equal name="<%= form %>" property="action" value="Delete">
		<% src = "/images/delconf.gif"; alt = "Удалить запись"; %>
</logic:equal>

<script language="javascript">
function Close(){
		if(window.opener) {
			opener.storeSelectedRow(document.all.id.value);
			//opener.location.reload(true);
			window.opener.window.document.forms(0).submit();
			//window.opener.window.location.href=window.opener.window.location.href;
			window.opener.focus();
		}
		window.close();
}
function Check(){
	var theForm = document.<%= form %>;
	with(theForm){
<logic:notEqual name="<%= form %>" property="action" value="Delete">	
		//if(!field_check(theForm.summStr, 'Сумма начисления', 6, true)) return false;
		//if(!field_check(theForm.beginDateStr, 'период c', 0, true)) return false;
		//if(!field_check(theForm.endDateStr, 'период по', 0, true)) return false;
		//if(!field_check(theForm.dateEndSfStr, 'СФ период по', 0, true)) return false;
		//if(!field_check(theForm.sumNdsStr,'В т.ч. НДС',6,true)) return false;
		//if(!field_check(theForm['vo.currency'], 'Валюта начисления',4,true)) return false;
		//if(!field_check(theForm.otherMan, 'Кто принимал', 0, true)) return false;
</logic:notEqual>		
	}
	return true;
}
</script>
<% String isCertain = "true"; %>
<logic:equal name="<%= form %>" property="action" value="Add">
	<% isCertain = "false"; %>
</logic:equal>

<script language="javascript">

function switchRate() {
	if (document.all.byhandraterur[0].checked) {
		<%= form %>.rate.disabled = false;
		<%= form %>.rate.className = 'edit';
	} else {
		<%= form %>.rate.disabled = true;
		<%= form %>.rate.className = 'editdisabled';
	}
}

function switchDate() {
	if (document.all.isCorrection[0].checked) {
		<%= form %>.dateFrm.enabled = true;
	} else {
		<%= form %>.dateFrm.enabled = false;
	}
}

function update() {
	var ndsRate = new Number(coma_replace(document.all.ndsRateFrm.value, '.'));
    var sum = coma_replace(document.all.summFrm.value, '.');
	document.all.sumndsFrm.value = Math.round((sum * ndsRate) / (100.0 + ndsRate) * 100.0) / 100.0;
}

function coma_replace(n, dd){
	var a = n.toString().split(',');
	if(a[1] == null)
		return a[0]; 
	else 
		return (a[0] + dd + a[1]);
}
//при услуге-электроэнергия: валюта = руб.(при добавлении)
function setCurrency(){
	if(<%= form %>.resourcecode.value == "10448")
		<%= form %>.currencycode.value="810";	
}
</script>

<table class="main">

	<july:separator colspan="<%= gColSpan %>"/>
    <tr class="title">
    	<td class="title" colspan="<%= gColSpan %>">
			<%--INPUT TYPE="IMAGE" NAME="submit" SRC="<%= src%>"  ALT="<%= alt %>" onclick="return Check();"--%>
			<a href="#" title="Закрыть" onclick="document.body.style.cursor='wait'; document.body.style.cursor='auto';"><IMG SRC="/images/cancel.gif" BORDER='0' ALT='Закрыть' onclick="document.body.style.cursor='auto'; window.close();"></a>
        </td>
    </tr>
    <july:separator colspan="<%= gColSpan %>"/>	
	<tr>
		<td class="title" colspan="<%= gColSpan %>"><july:actionalert/></td>
	</tr>
	
	<%--tr>
		<td class="text"><july:reqmark>Услуга:</july:reqmark></td>
		<td class="text">
			<july:select style="width: 300;" collection="resources" property="vo.resource" insertable="true" updatable="true" styleId="resourcecode">
				<html:options collection="resources" property="resource" labelProperty="name"/>
			</july:select>
		</td>
	</tr--%>

	<july:separator colspan="<%= gColSpan %>"/>

	<tr>
		<td class="text">Тип документа:</td>
		<td class="text">
			<bean:write name="<%=form%>" property="to.docPosVidStr" filter="true"/>
		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>

	<tr>
		<td class="text">Номер:</td>
		<td class="text">
			<bean:write name="<%=form%>" property="to.docNumber" filter="true"/>
		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>

	<tr>
		<td class="text">Дата:</td>
		<td class="text">
			<july:datewrite name="<%=form%>" property="to.docDate"/>
		</td>
	</tr>		

	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text">Оплаченная часть начисления, валюта:</td>
		<td class="text">
			<july:sumwrite name="<%=form%>" property="to.vo.chargeSum"/>
			<bean:write name="<%=form%>" property="to.curChargeName" filter="true"/>
		</td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text">Cумма начисления в рублях:</td>
		<td class="text">
			<july:sumwrite name="<%=form%>" property="to.vo.chargeRurSum"/>
		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text">Курс оплаченной части начисления к руб:</td>
		<td class="text">
			<july:sumwrite name="<%=form%>" property="to.vo.chargeRurRate"/>
		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text">Сумма документа оплаты в руб:</td>
		<td class="text">
			<july:sumwrite name="<%=form%>" property="to.docSummRub"/>
		</td>
	</tr>	

	<%
		String isEdit = "false";	
		if(request.isUserInRole("administrator")) {
	%>
	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text">Источник:</td>
		<td class="text">
			<bean:write name="<%=form%>" property="to.vo.sourceStr" filter="true"/>
		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text">Используется в акте:</td>
		<td class="text">
			<bean:write name="<%=form%>" property="to.docNumberUsedInAct" filter="true"/>
			от <july:datewrite name="<%=form%>" property="to.docDateUsedInAct"/>
		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text">При расчете акта:</td>
		<td class="text">
			<bean:write name="<%=form%>" property="to.docNumberAct" filter="true"/>
			от <july:datewrite name="<%=form%>" property="to.docDateAct"/>
		</td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text">Курс установлен:</td>
		<td class="text">	
			<logic:equal name="<%= form %>" property="to.vo.byHandChrgRateRur" value="Y">в ручном режиме</logic:equal>
			<logic:equal name="<%= form %>" property="to.vo.byHandChrgRateRur" value="N">автоматически</logic:equal>
		</td>
	</tr>
			
	<%}%>
	<july:separator colspan="<%= gColSpan %>"/>
    <tr class="title">
    	<td class="title" colspan="<%= gColSpan %>">
			<%--INPUT TYPE="IMAGE" NAME="submit" SRC="<%= src%>"  ALT="<%= alt %>" onclick="return Check();"--%>
			<a href="#" title="Закрыть" onclick="document.body.style.cursor='wait'; document.body.style.cursor='auto';"><IMG SRC="/images/cancel.gif" BORDER='0' ALT='Закрыть' onclick="document.body.style.cursor='auto'; window.close();"></a>
        </td>
    </tr>

</table>

</july:editform>
