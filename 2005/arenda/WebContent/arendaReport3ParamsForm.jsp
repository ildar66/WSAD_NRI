<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<SCRIPT language=javascript src="/common/validate.js" type="text/javascript"></SCRIPT>
<%
	//роли:
	boolean isAdministrator = request.isUserInRole("administrator");//isVisibleResources
	boolean isArendaDirector =request.isUserInRole("ArendaDirector");
	//группы:
	boolean isVisibleResources = isAdministrator || isArendaDirector;
%>
<jsp:useBean id="ArendaReport3ParamsForm" class="com.hps.july.arenda.formbean.ArendaReport3ParamsForm" scope="session"/>

<july:editform action="/ReportPage.do"  styleId="listForm">

<script language="javascript">
function changeReport(){
	hrefStr = '/arenda/ArendaReport3Params.do?comand='+listForm.comand.value;
	if(listForm.otvName != null)
		hrefStr = hrefStr + '&report.otv.name=' + listForm.otvName.value +'&report.otv.worker=' +listForm.otvWorker.value;		
	if(listForm.fromDateFrm != null)
		hrefStr = hrefStr + '&report.dataPeriod.fromDateFrm=' + listForm.fromDateFrm.value + '&report.dataPeriod.toDateFrm=' + listForm.toDateFrm.value;
	if(listForm.dataFrm != null)
		hrefStr = hrefStr + '&report.dataFrm=' + listForm.dataFrm.value;
	window.location.href= hrefStr;
}
function isAllOtv(){
	listForm.otvWorker.value='';
	listForm.otvName.value='';
	//changeReport();
}
function showAlert(){
	var theForm = document.listForm;
	with(theForm){
		<logic:equal name="ArendaReport3ParamsForm" property="report.type.isDataPeriod" value="true">	
			if(!field_check(theForm.fromDateFrm, 'период с', 7, true)) return false;
			if(!field_check(theForm.toDateFrm, 'период по', 7, true)) return false;
		</logic:equal>
		<logic:equal name="ArendaReport3ParamsForm" property="report.type.isData" value="true">
			if(!field_check(theForm.dataFrm, 'дата', 7, true)) return false;
		</logic:equal>		
	}
	//if(listForm.comand.value == 'getContrArOnOtv' )
		alert('Внимание! Подготовка данного отчета может занять несколько минут!');
	//document.body.style.cursor="wait";		
	return true;		
}
function popCalInMainFrame(dateFrom, dateTo, isStart) {
	var w=gfPop;
	if(isStart == true) {
		w.fStartPop(dateFrom, dateTo);
	} else {
		w.fEndPop(dateFrom, dateTo);
	}
}
function popCalInFrame(dateCtrl) {
	var w=gfPop;
	//w.gbFixedPos=true;	// enable fixed positioning
	//w.gPosOffset=[70,0];	// set position
	w.fPopCalendar(dateCtrl);	// pop calendar
}
</script>

<% String gColSpan = "2"; %>

<table class="main">

	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text">тип отчета:</td>
		<td class="text">
				<july:select style="width: 550;" onchange="changeReport()" property="comand" insertable="true" updatable="true">
					<html:option value="getContrArOnOtv">Общая статистика по договорам аренды  действующие за период</html:option>
					<html:option value="repWarningProlong">Отчет о необходимости продления договоров</html:option>
					<html:option value="repWarningAkt">Отчет-предупреждение о необходимости формировать акты взаимозачета</html:option>
					<html:option value="listSfOnOtv">Платежи</html:option>
					<html:option value="listAllContractsArenda">Все договора аренды</html:option>
					<% if (isVisibleResources) { %>
						<html:option value="workTimeOnEconomist">Трудоемкость по экономистам</html:option>
					<%}%>
					<html:option value="getListNewContracts">Новые договора за период</html:option>
					<html:option value="getListBadCharges">Наличие с.ф. и актов выполненных работ</html:option>
					<html:option value="repYearPriceBS">Стоимость позиций</html:option>
					<html:option value="repArendaListOfMmOpl">Список служебных записок</html:option>
					<html:option value="repArendaListAbonent">Статистика по абонентским договорам</html:option>
					<html:option value="fillTmpListPayOnCategory">Платежи по позициям с разбивкой по категориям затрат</html:option>
					<html:option value="repTemplateListZpNextPeriod">Планирование ЗП за период</html:option>
					<html:option value="fillTmpListDocumenstOnPeriod">Отчет по первичным документам</html:option>
					<html:option value="fillTmpListContractsOnPeriod">Договора с поставщиками в валюте и рублях</html:option>
					<html:option value="repContractCustomersOnPeriod">По поставщикам за период</html:option>
					<html:option value="repListContractsForNFS">Данные по договорам аренды для НФС</html:option>
				</july:select>
		</td>
	</tr>

<logic:equal name="ArendaReport3ParamsForm" property="report.type.isData" value="true">
	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text"><bean:write name="ArendaReport3ParamsForm" property="report.type.dataDescription"/>:</td>
		<td class="text">
			<%--july:date property="report.dataFrm" size="25" insertable="true" updatable="true" styleId="dataFrm" /--%>
			<html:text property="report.dataFrm" size="11" styleId="dataFrm"/>
				<a href="javascript:void(0)" onclick="popCalInFrame(document.listForm.dataFrm);return false;" HIDEFOCUS>
					<img name="popcal" align="absbottom" src="/images/calbtn.gif" width="34" height="22" border="0" alt=""></a>			
		</td>
	</tr>
</logic:equal>

<logic:equal name="ArendaReport3ParamsForm" property="report.type.isDataPeriod" value="true">
	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text">Период:</td>
		<td class="text">
			<%--july:date property="report.dataPeriod.fromDateFrm" size="25" insertable="true" updatable="true" styleId="fromDateFrm"/--%>
			<html:text property="report.dataPeriod.fromDateFrm" size="11" styleId="fromDateFrm"/>
				<a href="javascript:void(0)" onclick="popCalInMainFrame(document.listForm.fromDateFrm, document.listForm.toDateFrm, true);return false;" HIDEFOCUS>
					<img name="popcal" align="absbottom" src="/images/calbtn.gif" width="34" height="22" border="0" alt=""></a>			
			 &nbsp;&nbsp;&nbsp;
			<%--july:date property="report.dataPeriod.toDateFrm" size="25" insertable="true" updatable="true" styleId="toDateFrm"/--%>
			<html:text property="report.dataPeriod.toDateFrm" size="11" styleId="toDateFrm"/>
				<a href="javascript:void(0)" onclick="popCalInMainFrame(document.listForm.fromDateFrm, document.listForm.toDateFrm, false);return false;" HIDEFOCUS>
					<img name="popcal" align="absbottom" src="/images/calbtn.gif" width="34" height="22" border="0" alt=""></a>			
		</td>
	</tr>
</logic:equal>

<logic:equal name="ArendaReport3ParamsForm" property="report.type.isOtv" value="true">
	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text"><bean:message key="label.filter.responsible"/>:</td>
		<td class="text">
			<july:string size="50" property="report.otv.name" styleId="otvName" insertable="false" updatable="false" />
			<july:lookupbutton action="/ShowWorkerLookupList.do" styleId="otv" fieldNames="otvWorker;otvName" insertable="true" updatable="true"/>
			<html:hidden property="report.otv.worker" styleId="otvWorker"/>
			<A href="javascript:isAllOtv()">все</A>
		</td>
	</tr>
</logic:equal>	

<%--
	<tr class="normal">
		<td>
			<july:exceledit styleId="exceled1" 	url='<%= "ReportPage.do?" + ArendaReport3ParamsForm.getParams() %>' uploadurl="" documentid="" updatable="false">
					Показать отчет ХLS
			</july:exceledit>
		</td>
	</tr>
	<tr>
		<td colspan="<%= gColSpan %>">
			<FONT class="attention"><B>Внимание! Подготовка отчета занимает несколько минут! Пожалуйста подождите.</B></FONT>
		</td>
	</tr>
--%>

	<july:separator colspan="<%= gColSpan %>"/>

	<tr class="title">
		<td class="title" colspan="<%= gColSpan %>">
			<INPUT TYPE="IMAGE" NAME="submit" SRC="/images/refresh.gif" onclick="return showAlert();" ALT="Показать отчет ХLS">
		</td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>

</table>

</july:editform>
<!-- Opera 7.0 has a z-index bug that prevents the calendar panel from floating above the centerIframe.
A workaround is to move the <iframe> calendar tag from the page bottom to page top.
-->
<iframe width=174 height=189 name="gToday:normal:agenda.js" id="gToday:normal:agenda.js" src="ipopeng.jsp" scrolling="no" frameborder="0" style="visibility:visible; z-index:999; position:absolute; left:-500px; top:0px;">
</iframe>
