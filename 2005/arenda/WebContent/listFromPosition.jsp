<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import = "com.hps.july.arenda.formbean.*"%>

<%!
private String isUp(String aSort, String name) {
 if(aSort.startsWith(name)) {
	 if(aSort.endsWith("desc")) 
		return (" <img src='/images/up.gif'  border='0' alt='по возрастанию'> ");
	 else
		return (" <img src='/images/down.gif'  border='0' alt='по убыванию'> "); 
 }
 else return ("");      
}
%>

<%-- <jsp:include page="common/top.jsp" flush="true"/>--%>

<%
	String gColSpan = "17";
	ListFromPositionForm listForm = (ListFromPositionForm)session.getAttribute("ListFromPositionForm");
	String abonentSortBy = listForm.getAbonentSortBy();
	String loanSortBy = listForm.getLoanSortBy();
%>

<july:editform action="/ListFromPosition.do" styleId="ListFromPositionForm">
<html:hidden property="selectedIDarendaID" value="0"/>
<html:hidden property="selectedIDabonentID" value="0"/>
<html:hidden property="selectedIDlawyearNoteID" value="0"/>
<html:hidden property="abonentSortBy"/>
<html:hidden property="operation"/>
<html:hidden property="findPositionBy"/>
<html:hidden property="searchString"/>
<html:hidden property="loanSortBy"/>
<html:hidden property="selectedIDloanID" value="0"/>
<html:hidden property="locationHash"/>

<style>
TR.normalrow {
	background-color:#F0F0F0;
}
TR.selectrow {
	background-color:#FFFFFF;
}
TR.selectedrow {
	background-color:#FFF0D0;
} 
</style>

<script language="javascript">
function toggleStateArenda(n){
	document.all.locationHash.value="";
	if(document.all.stateArenda[n].checked)
		document.all.stateArenda[n].checked =false;
	else
		document.all.stateArenda[n].checked = true;
}
function toggleStateArendaALL(){
   	document.all.locationHash.value="";
	if(document.all.stateArenda[0].checked){
		document.all.stateArenda[0].checked =false;
		document.all.stateArenda[1].checked =false;
		document.all.stateArenda[2].checked =false;
		document.all.stateArenda[3].checked =false;
		document.all.stateArenda[4].checked =false;
	}else{
		document.all.stateArenda[0].checked = true;
		document.all.stateArenda[1].checked = true;
		document.all.stateArenda[2].checked = true;
		document.all.stateArenda[3].checked = true;
		document.all.stateArenda[4].checked = true;
	}
}
function onMouseOutRow(tabid,selectedID){
	if(document.all['selectedID'+tabid].value==selectedID) {
		document.all[tabid].rows(selectedID,0).className="selectedrow";
		if(document.all[tabid].rows(selectedID,1) != null)
			document.all[tabid].rows(selectedID,1).className="selectedrow";
	}
	else {
		document.all[tabid].rows(selectedID,0).className="normalrow";
		if(document.all[tabid].rows(selectedID,1) != null)
			document.all[tabid].rows(selectedID,1).className="normalrow";
	
	}
}
function onMouseOverRow(tabid,selectedID){
	document.all[tabid].rows(selectedID,0).className="selectrow";
	if(document.all[tabid].rows(selectedID,1) != null)
		document.all[tabid].rows(selectedID,1).className="selectrow";
}
function onClickRow(tabid,selectedID) {
	if(document.all[tabid].rows(document.all['selectedID'+tabid].value) != null){
		document.all[tabid].rows(document.all['selectedID'+tabid].value,0).className="normalrow";
		if(document.all[tabid].rows(document.all['selectedID'+tabid].value,1) != null)
			document.all[tabid].rows(document.all['selectedID'+tabid].value,1).className="normalrow";
	}
	document.all['selectedID'+tabid].value=selectedID;
	document.all[tabid].rows(selectedID,0).className="selectedrow";
	if(document.all[tabid].rows(selectedID,1) != null)
		document.all[tabid].rows(selectedID,1).className="selectedrow";
	storeSelectedRow(tabid,selectedID);
}
function storeSelectedRow(tabid,selectedID) {
	document.cookie = "listPosID"+tabid+"=" + selectedID;
}
function loadSelectedRow(tabid) {
	var cookies = document.cookie;
	//считываем selectedID:
	var startLoc = cookies.indexOf("listPosID"+tabid+"=");
	if(startLoc == -1)
	   return;
	var sepLoc = cookies.indexOf("=", startLoc);
	var endLoc = cookies.indexOf(";", startLoc);
	if(endLoc == -1) {
		endLoc = cookies.length;
    }
	document.all['selectedID'+tabid].value = cookies.substring(sepLoc+1, endLoc);
	//подчеркиваем строку в таблице:
	if( document.all[tabid].rows(document.all['selectedID'+tabid].value) != null ) {
 		document.all[tabid].rows(document.all['selectedID'+tabid].value,0).className="selectedrow";
		if(document.all[tabid].rows(document.all['selectedID'+tabid].value,1) != null)
			document.all[tabid].rows(document.all['selectedID'+tabid].value,1).className="selectedrow";
	}
}
function toggleStateAbonent(n){
	document.all.stateAbonent[n].checked = true;
    document.body.style.cursor="wait";
   	document.all.locationHash.value="abonentID";
	ListFromPositionForm.submit();
}
function toggleStateLoan(n){
	document.all.stateLoan[n].checked = true;
    document.body.style.cursor="wait";
    document.all.locationHash.value="loanID";
	ListFromPositionForm.submit();
}
function abonentSortBy(field) 
{
	var e = document.all.abonentSortBy;
	e.value = (e.value == field)?field + ' desc':field;
    document.body.style.cursor="wait";
   	document.all.locationHash.value="abonentID";
	ListFromPositionForm.submit();
	return false;
}
function loanSortBy(field) 
{
	var e = document.all.loanSortBy;
	e.value = (e.value == field)?field + ' desc':field;
    document.body.style.cursor="wait";
    document.all.locationHash.value="loanID";
	ListFromPositionForm.submit();
	return false;
}
function initPosition(by) {
	document.all.operation.value='initPosition';
	document.all.findPositionBy.value=by;
	document.body.style.cursor="wait";
	document.all.locationHash.value="";
}
function alertDictionary(by) {
	if(document.all['lookupimg_posl'].src.substr(document.all['lookupimg_posl'].src.length-12,12) == 'disabled.gif') 
		{ return; }
	String.prototype.lookup = lookup_params_posl;
	opt_params_posl=opt_params_posl+'&searchString='+document.all.searchString.value;
	if(by==2)
		opt_params_posl=opt_params_posl+'&searchBy='+'B';
	else if(by==3)
		opt_params_posl=opt_params_posl+'&searchBy='+'C';
	document.all.operation.value='';		
	myWindow = window.open("/arenda/../basestation/ShowPositionLookupList.do?planstate=2" + opt_params_posl, "myWindow", "top=40, left=100, width=830, height=630, scrollbars=yes, resizable=yes");
	if(dialogArray)
		dialogArray[dialogArray.length]=myWindow;
	myWindow.focus();
	//return openDialog("/arenda/../basestation/ShowPositionLookupList.do?planstate=2" + opt_params_posl, "myWindow", "top=40, left=100, width=830, height=630, scrollbars=yes, resizable=yes");
}
function showInfo(positionStr){
	hrefStr = 'LicenceInfo.do?positionStr='+positionStr;
	//window.open(hrefStr, 'pWindow', 'top=100,	left=150, width=650, height=310, scrollbars=yes, resizable=yes, menubar=no').focus();
	//return false;
	return openDialog(hrefStr, 'pWindow', 'top=100,	left=150, width=650, height=310, scrollbars=yes, resizable=yes, menubar=no');
}
function showNote(positionStr, typeStr){
	hrefStr = "LicenceDialog.do?action=View&position=" + positionStr + "&typelicence=" +  typeStr;
	//window.open(hrefStr, "licenceNote", "top=200, left=400, width=550, height=470, scrollbars=yes, resizable=yes, menubar=no, titlebar=no, toolbar=no, directories=no").focus();
	//return false;
	return openDialog(hrefStr, "licenceNote", "top=200, left=400, width=550, height=470, scrollbars=yes, resizable=yes, menubar=no, titlebar=no, toolbar=no, directories=no");
}
function showContractComment(contractID){
	hrefStr = "ContractCommentDialog.do?action=Edit&contractID=" + contractID;
	//window.open(hrefStr, "licenceNote", "top=100, left=200, width=500, height=250, scrollbars=yes, resizable=yes, menubar=no, titlebar=no, toolbar=no, directories=no").focus();
	//return false;
	return openDialog(hrefStr, "ContractCommentDialog", "top=100, left=200, width=500, height=250, scrollbars=yes, resizable=yes, menubar=no, titlebar=no, toolbar=no, directories=no");
}
function editLoanState(idTD, id){
	hrefStr = "LoanContractState.do?action=Edit&idTD=" + idTD + "&id=" + id;
	return openDialog(hrefStr, "LoanContractState", "top=400, left=400, width=300, height=200, scrollbars=yes, resizable=yes, menubar=no, titlebar=no, toolbar=no, directories=no");
}
</script>

<table class="main">

<july:separator colspan="<%= gColSpan %>"/>

<tr class="normal">
<td colspan="<%= gColSpan %>" style="padding-left:12px;padding-right:12px;">
	<table width="100%" cellspacing="1" cellpadding="2" border="0" style="font-family:tahoma,arial;font-size:8pt;">
	<tr>
		<td rowspan="2" valign="bottom"><july:backbutton page="/main.do"/></td>
		<td><b>GSM</b>:</td>
		<td rowspan="2" valign="bottom"><INPUT TYPE='image' src='/images/refresh.gif'  onclick='initPosition(2);' border='0' alt='Искать по GSM'></td>
		<td><b>DAMPS</b>:</td>
		<td rowspan="2" valign="bottom"><INPUT TYPE='image' src='/images/refresh.gif'  onclick='initPosition(3);' border='0' alt='Искать по DAMPS'></td>
		<td><b><bean:message key="label.filter.position"/></b>:</td>
		<td><b>Адрес</b>:</td>
<logic:present name="ListFromPositionForm" property="position.dopInfoVO">
		<td rowspan="2" width="20%" align="right" valign="middle">
			<A href='positionDopInfo.jsp' onclick='return openDialog(this.href, "dopInfo", "top=100, left=100, width=600, height=300, scrollbars=yes, resizable=yes");' class='button'>
					Доп. инфо<BR>о позиции
			</A>			
		</td>
</logic:present>
		<td rowspan="2" width="50%" align="right" valign="middle"><july:searchbutton/></td>
	</tr>
	<tr>
		<td><july:string style="font-size:8pt;background-color:#FFFFFF;" size="5" property="position.gsmid" styleId="gsmid" insertable="false" updatable="false"/></td>
		<td><july:string style="font-size:8pt;background-color:#FFFFFF;" size="5" property="position.dampsid" styleId="dampsid" insertable="false" updatable="false"/></td>
		<td nowrap>
			<july:string style="font-size:8pt;background-color:#E0E0E0;" readonly="true" size="20" property="position.name" styleId="name" insertable="false" updatable="false"/>
			<july:lookupbutton action="/../basestation/ShowPositionLookupList.do?planstate=2" styleId="posl" fieldNames="position.storageplace;dummy1;dummy1;dummy1;dummy1;dummy1;dummy1;dummy1;dummy1;position.dampsid;position.gsmid;dummy1;position.name;dummy1" insertable="true" updatable="true" onselect = "initPosition(1);ListFromPositionForm.submit();"/>
			<html:hidden property="position.storageplace"/>
		</td>
		<td><july:string style="font-size:8pt;background-color:#E0E0E0;" readonly="true" size="20" property="position.address" styleId="address" insertable="false" updatable="false"/></td>
	</tr>
	</table> 
</td>
</tr>

<logic:present name="ListFromPositionForm" property="licenciesTO">
<july:separator colspan="<%= gColSpan %>"/>
<tr class="title">
	<td colspan="<%= gColSpan %>" style="padding-left:5px;">
		<table style="font-family:tahoma,arial;font-size:8pt;" border="1">
			<tr>
				<td align="center" rowspan="2" style="padding-left:5px;padding-right:5px;">
					<a href="#" title="Просмотр информации о лицензиях" onclick='showInfo(<bean:write name="ListFromPositionForm" property="position.storageplace" filter="true"/>); return false;' class='button'>
						Лицензии:
					</a>
				</td>
				<TH nowrap style="width: 60px;">Коммент.</TH>
				<TH nowrap style="width: 60px;">ФАС</TH>
				<TH nowrap style="width: 60px;">РУЦР</TH>
				<TH nowrap style="width: 60px;">А-граж</TH>
				<TH nowrap style="width: 60px;">А-воен</TH>
				<TH nowrap style="width: 60px;">ГПС</TH>
				<TH nowrap style="width: 60px;">ГАСН</TH>
				<TH nowrap style="width: 60px;">СЭС</TH>
				<TH nowrap style="width: 60px;">в\ч</TH>
				<TH nowrap style="width: 60px;">ТУ</TH>
				<TH nowrap style="width: 60px;">Акт Земл.</TH>
				<TH nowrap style="width: 60px;">Кадастр</TH>
				<TH nowrap style="width: 60px;">Дог имущ.</TH>
			</tr>
			<tr>
				<td align="center" ondblclick='showNote(<bean:write name="ListFromPositionForm" property="position.storageplace" filter="true"/>, 13)' title="Двойной клик для просмотра комментария">
					<B><bean:write name="ListFromPositionForm" property="licenciesTO.isNote"/></B>
				</td>
				<td><july:datewrite name="ListFromPositionForm" property="licenciesTO.fas"/></td>
				<td><july:datewrite name="ListFromPositionForm" property="licenciesTO.rutsr"/></td>
				<td><july:datewrite name="ListFromPositionForm" property="licenciesTO.air_gr"/></td>
				<td><july:datewrite name="ListFromPositionForm" property="licenciesTO.air_w"/></td>
				<td><july:datewrite name="ListFromPositionForm" property="licenciesTO.gps"/></td>
				<td><july:datewrite name="ListFromPositionForm" property="licenciesTO.gasn"/></td>
				<td><july:datewrite name="ListFromPositionForm" property="licenciesTO.ses"/></td>
				<td><july:datewrite name="ListFromPositionForm" property="licenciesTO.vch"/></td>
				<td><july:datewrite name="ListFromPositionForm" property="licenciesTO.tu"/></td>
				<td><july:datewrite name="ListFromPositionForm" property="licenciesTO.otvod"/></td>
				<td><july:datewrite name="ListFromPositionForm" property="licenciesTO.kadastr"/></td>
				<td><july:datewrite name="ListFromPositionForm" property="licenciesTO.property"/></td>
			</tr>
		</table>
	</td>
</tr>
</logic:present>

<july:separator colspan="<%= gColSpan %>"/>

<tr class="normal">
	<td colspan="<%= gColSpan %>" bgcolor="#A5F3C6" style="padding-left:4px;padding-right:4px;">
<table width="100%" cellspacing="0" border="0">
<tr>
	<td style="font-family:tahoma,arial;font-size:8pt;color:#000000;font-weight:bold;padding:4px;" width="30%">Договора аренды</td>
	<td style="font-family:tahoma,arial;font-size:8pt;color:#000000;font-weight:normal;text-align:right;padding-right:12px;" valign="middle" width="70%">
		<july:checkbox styleClass="editcheckboxform" style="padding:0px;margin-left:12px;margin-right:2px;" property="stateArenda" insertable="true" updatable="true" value="ALL"/><A href="javascript:toggleStateArendaALL()"><bean:message key="label.filter.all"/></A>
		<july:checkbox styleClass="editcheckboxform" style="padding:0px;margin-left:12px;margin-right:2px;" property="stateArenda" insertable="true" updatable="true" value="A"/><A href="javascript:toggleStateArenda(1)"><bean:message key="label.bans.contractstate.a"/></A>
		<july:checkbox styleClass="editcheckboxform" style="padding:0px;margin-left:12px;margin-right:2px;" property="stateArenda" insertable="true" updatable="true" value="B"/><A href="javascript:toggleStateArenda(2)"><bean:message key="label.bans.contractstate.b"/></A>
		<july:checkbox styleClass="editcheckboxform" style="padding:0px;margin-left:12px;margin-right:2px;" property="stateArenda" insertable="true" updatable="true" value="D"/><A href="javascript:toggleStateArenda(3)"><bean:message key="label.state.unclosed"/></A>
		<july:checkbox styleClass="editcheckboxform" style="padding:0px;margin-left:12px;margin-right:2px;" property="stateArenda" insertable="true" updatable="true" value="C"/><A href="javascript:toggleStateArenda(4)"><bean:message key="label.bans.contractstate.c"/></A>
	</td>
</tr>
<tr>
	<td colspan="2">

<!-- Dogovora arendy table -->
<table width="100%" id="arendaID" cellspacing="1" cellpadding="2" border="0" bgcolor="#999999" style="font-family:tahoma,arial;font-size:8pt;">
	<tr bgcolor="#CCCCCC">
		<th width="4%">&nbsp;</th>
		<th width="1%" align="center" title="Комментарий"><b>!</b></th>
		<th width="10%" align="center"><b>Номер договора</b></th>
		<th width="6%" align="center"><b>Дата договора</b></th>
		<th width="6%" align="center"><b>Дата начала</b></th>
		<th width="6%" align="center"><b>Дата окончания</b></th>
		<th colspan="1" align="center"><b>Сумма договора</b></th>
		<th colspan="1" align="center"><b>в т.ч. траффик</b></th>
		<th width="1%" align="center" title="Признак безакцептного списания">!</th>
		<th width="2%" align="center" title="Проблемы"><b>!</b></th>
		<th width="7%" align="center"><b>Услуги договора</b></th>
		<th width="10%" align="center"><b>Ответственные</b></th>
		<th width="1%" align="center"  title='Регистрация договора в государственных органах'><b>!</b></th>
		<th width="1%" align="center"><b>!</b></th>
		<th width="7%" align="center"><b>Состояние</b></th>
		<th width="1%" align="center" title="Признак автоматического продления"><b>!</b></th>
	</tr>
	<tr bgcolor="#CCCCCC"><td colspan="15" style="font-size:0px;height0px;padding:0px;"></td></tr>
<logic:iterate id="idog" name="ListFromPositionForm" property="arendaList" type="com.hps.july.arenda.valueobject.LeaseArendaAgreementNewVO">
<logic:present name="idog">
	<tr id='<bean:write name="idog" property="o.leaseDocument" filter="true"/>' class="normalrow" onMouseOver="onMouseOverRow('arendaID',this.id);" onMouseOut="onMouseOutRow('arendaID',this.id);" style="font-size:8pt;" onclick='onClickRow("arendaID",this.id);'>
<!--	<tr bgcolor="#F0F0F0" onMouseOver="this.style.backgroundColor='#FFFFFF';this.nextSibling.style.backgroundColor='#FFFFFF';" onMouseOut="this.style.backgroundColor='#F0F0F0';this.nextSibling.style.backgroundColor='#F0F0F0';">-->
		<td rowspan="2" align="center">
			<july:editbutton page="/ViewWeArenda.do" action="View" paramId="leaseDocument" paramName="idog" paramProperty="o.leaseDocument" paramScope="page"/>
			<logic:present name="idog" property="o.mainLeaseDocument">
				<july:link page="/ShowDogHistoryList.do" paramId="contract" paramName="idog" paramProperty="o.mainLeaseDocument" >
					<img src="/images/obchet1.gif" border=0 alt='<bean:message key="label.contractcalc"/>'>
				</july:link>
			</logic:present>
			<logic:notPresent name="idog" property="o.mainLeaseDocument">
				<july:link page="/ShowDogHistoryList.do" paramId="contract" paramName="idog" paramProperty="o.leaseDocument" >
					<img src="/images/obchet1.gif" border=0 alt='<bean:message key="label.contractcalc"/>'>
				</july:link>
			</logic:notPresent>
		</td>
		<td rowspan="2" align="center" title = '<bean:write name="idog" property="o.docComment" filter="true"/>' ondblclick='showContractComment(<bean:write name="idog" property="o.leaseDocument" filter="true"/>)' >!</td>
		<td align="center" nowrap><bean:write name="idog" property="mainDocumentNumber" filter="true"/></td>
		<td align="center"><july:datewrite name="idog" property="mainDocumentDate"/></td>
		<td align="center"><july:datewrite name="idog" property="mainStartDate"/></td>
		<td align="center"><july:datewrite name="idog" property="o.endDate"/></td>
		<td align="right" nowrap title='<july:numberwrite name="idog" property="o.summ1"/>' width="12%">
			<logic:present name="idog" property="o.summ1">
			<july:numberwrite name="idog" property="o.summ1" fractdigits="0"/> <bean:write name="idog" property="o.currency1.shortname" filter="true"/>
			</logic:present>
		</td>
<%--
		<td align="right"  nowrap title='<july:numberwrite name="idog" property="o.summ2"/>' width="6%" >
			<logic:present name="idog" property="o.summ2">
			<july:numberwrite name="idog" property="o.summ2" fractdigits="0"/> <bean:write name="idog" property="o.currency2.shortname" filter="true"/>
			</logic:present>
		</td>
--%>
		<td align="right" nowrap title='<july:numberwrite name="idog" property="trafic1"/>' width="12%" >
			<logic:present name="idog" property="trafic1">
			<july:numberwrite name="idog" property="trafic1" fractdigits="0"/> <bean:write name="idog" property="o.currency1.shortname" filter="true"/>
			</logic:present>
		</td>
<%--
		<td align="right" nowrap title='<july:numberwrite name="idog" property="trafic2"/>' width="6%">
			<logic:present name="idog" property="trafic2">
			<july:numberwrite name="idog" property="trafic2" fractdigits="0"/> <bean:write name="idog" property="o.currency2.shortname" filter="true"/>
			</logic:present>
		</td>
--%>
		<td align="center" title='<logic:present name="idog" property="accept1">сумма безакцептного списания в осн. вал. = <july:numberwrite name="idog" property="accept1"/> <bean:write name="idog" property="o.currency1.shortname" filter="true"/></logic:present><logic:present name="idog" property="accept2">сумма безакцептного списания в доп. вал. = <july:numberwrite name="idog" property="accept2"/> <bean:write name="idog" property="o.currency2.shortname" filter="true"/></logic:present>'>
			<logic:present name="idog" property="accept1">!</logic:present>
			<logic:present name="idog" property="accept2">!</logic:present>
		</td>
		<td align="center" rowspan="2" title="проблемы по договору">
			<html:link page="/LeaseContractProblemList.do" paramId="idContract" paramName="idog" 
					paramProperty="o.leaseDocument" styleClass="button">
				<bean:write name="idog" property="countProblemOnContract" filter="true"/></html:link>		
		</td>
		<td align="center" rowspan="2">
			<%String styleDiv = "";%>
			<logic:equal name="idog" property="o.calcelectrotype" value="2">
				<%styleDiv = "style='color: red'";%>
			</logic:equal>
			<logic:equal name="idog" property="o.calcelectrotype" value="3">
				<%styleDiv = "style='color: red'";%>
			</logic:equal>
			
			<DIV <%=styleDiv%>><bean:write name="idog" property="resources" filter="true"/></DIV>
		</td>
		<td align="center" title='<bean:message key="label.filter.poiskovik"/>' nowrap>
			<logic:present name="idog" property="mainManager"><bean:write name="idog" property="mainManager.name" filter="true"/></logic:present>
		</td>
<%--
		<td align="center" rowspan="2" style="font-size:8pt;" title='Регистрация договора в государственных органах'>
			<logic:present name="idog" property="o.officialdoc">
				<logic:equal name="idog" property="o.officialdoc" value="Y">+</logic:equal>
				<logic:equal name="idog" property="o.officialdoc" value="N">-</logic:equal>
			</logic:present>
		</td>
--%>
		<% String color = ""; String title = ""; String value = "";%>
		<logic:equal name="idog" property="o.officialdoc" value="Y">
			<% title = "зарегистрирован в гос. органах"; value = "R"; color = "green"; %>
		</logic:equal>
		<logic:equal name="idog" property="o.officialdoc" value="N">
			<logic:present name="idog" property="o.needofficialdoc">
				<logic:equal name="idog" property="o.needofficialdoc" value="Y">
					<% title = "необходимо зарегистрировать в гос. органах"; value = "R"; color = "red"; %>
				</logic:equal>
			</logic:present>
		</logic:equal>

		<td class="center" align="center" rowspan="2" style="font-size:8pt;" title='<%= title%>'>
			<B style="color: <%= color%>;"><%= value%></B>
		</td>

		<td rowspan="2">
			<logic:present name="idog" property="o.mainLeaseDocument">
				<july:link page="/ShowHistoryList.do" paramId="leaseDocument" paramName="idog" paramProperty="o.mainLeaseDocument" paramScope="page">
				<img src='/images/dochist.gif' border=0 alt='<bean:message key="label.history"/>'>
				</july:link>
			</logic:present>
			<logic:notPresent name="idog" property="o.mainLeaseDocument">
				<july:link page="/ShowHistoryList.do" paramId="leaseDocument" paramName="idog" paramProperty="o.leaseDocument" paramScope="page">
				<img src='/images/dochist.gif' border=0 alt='<bean:message key="label.history"/>'>
				</july:link>
			</logic:notPresent>
		</td>
		<td rowspan="2" align="center">
			<% String temp = "/EditWeState.do?action=View"; %>
			<july:canedit rolesProperty="editRoles"><% temp = "/EditWeState.do?action=Edit"; %></july:canedit>
			<logic:equal name="idog" property="mainContractState" value="A"><bean:message key="label.state.prepared"/></logic:equal>
			<logic:equal name="idog" property="mainContractState" value="B"><bean:message key="label.state.continued"/></logic:equal>
			<logic:equal name="idog" property="mainContractState" value="C">
				<bean:message key="label.state.stoped"/><BR>
				<july:datewrite name="idog" property="mainDateClose"/>
			</logic:equal>
			<logic:equal name="idog" property="mainContractState" value="D"><bean:message key="label.state.unclosed"/></logic:equal>
		</td>
		<td rowspan="2" align="center" title="<bean:message key='label.extendtype.auto'/>">
			<logic:equal name="idog" property="o.extendType" value="A">+</logic:equal>
		</td>
	</tr>
	<tr id='<bean:write name="idog" property="o.leaseDocument" filter="true"/>' class="normalrow" onMouseOver="onMouseOverRow('arendaID',this.id);" onMouseOut="onMouseOutRow('arendaID',this.id);" style="font-size:8pt;" onclick='onClickRow("arendaID",this.id);'> 
<!--	<tr bgcolor="#F0F0F0" onMouseOver="this.style.backgroundColor='#FFFFFF';this.previousSibling.style.backgroundColor='#FFFFFF';" onMouseOut="this.style.backgroundColor='#F0F0F0';this.previousSibling.style.backgroundColor='#F0F0F0';"> -->
		<td align="center">
			<logic:present name="idog" property="o.orgCustomer.shortname"><bean:write name="idog" property="o.orgCustomer.shortname" filter="true"/></logic:present>
		</td>
		<td align="center" colspan="3">
			<logic:present name="idog" property="o.orgExecutor.shortname"><bean:write name="idog" property="o.orgExecutor.shortname" filter="true"/></logic:present>
		</td>
		<td align="center" colspan="3" title='<bean:write name="idog" property="allPositions" filter="true"/>'>
			<logic:present name="idog" property="mainPosition"><bean:write name="idog" property="mainPosition" filter="true"/></logic:present>
			<logic:present name="idog" property="allPositions"><logic:match name="idog" property="allPositions" value=";">&nbsp;...</logic:match></logic:present>
			<logic:present name="idog" property="allPositions"><logic:notMatch name="idog" property="allPositions" value=";"><logic:notEqual name="idog" property="allPositions" value=""><logic:equal name="idog" property="mainPosition" value="">&nbsp;...</logic:equal></logic:notEqual></logic:notMatch></logic:present>
		</td>
		<td align="center" title="<bean:message key='label.filter.economist'/>" nowrap>
			<logic:present name="idog" property="mainEconomist"><bean:write name="idog" property="mainEconomist.name" filter="true"/></logic:present>
		</td>
	</tr>
	<tr bgcolor="#CCCCCC"><td colspan="15" style="font-size:0px;height0px;padding:0px;"></td></tr>
</logic:present>
</logic:iterate>
<logic:notPresent name="idog">
	<tr>
		<td colspan="16" bgcolor="#F0F0F0" style="padding-left:6px;">Ничего не найдено</td>
	</tr>
</logic:notPresent>
</table>

	</td>
</tr>
<tr>
	<td style="font-family:tahoma,arial;font-size:8pt;color:#000000;font-weight:normal;padding:4px;" colspan="2">
		Cумма аренды: <b><july:numberwrite name="ListFromPositionForm" property="sum1OtherCurAll" fractdigits="0"/> USD</b>, в том числе трафик: <b><july:numberwrite name="ListFromPositionForm" property="trafic1OtherCurAll" fractdigits="0"/> USD</b>
	</td>
</tr>
</table>
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>"/>

<tr class="normal">
	<td colspan="<%= gColSpan %>" bgcolor="#8899FF" style="padding-left:4px;padding-right:4px;">
<table width="100%" cellspacing="0" border="0">
<tr>
	<td style="font-family:tahoma,arial;font-size:8pt;color:#000000;font-weight:bold;padding:4px;" width="30%">Абонентские договора</td>
	<td style="font-family:tahoma,arial;font-size:8pt;color:#000000;font-weight:normal;text-align:right;padding-right:12px;vertical-align:middle;" width="70%">
		<july:radio styleClass="editcheckboxform" style="padding:0px;margin-left:12px;margin-right:2px;" property="stateAbonent" insertable="true" updatable="true" value="ALL"/><A href="javascript:toggleStateAbonent(0)"><bean:message key="label.all"/></A>
		<july:radio styleClass="editcheckboxform" style="padding:0px;margin-left:12px;margin-right:2px;" property="stateAbonent" insertable="true" updatable="true" value="B"/><A href="javascript:toggleStateAbonent(1)"><bean:message key="label.abonents.dogs.active"/></A>
		<july:radio styleClass="editcheckboxform" style="padding:0px;margin-left:12px;margin-right:2px;" property="stateAbonent" insertable="true" updatable="true" value="A"/><A href="javascript:toggleStateAbonent(2)"><bean:message key="label.abonents.dogs.editing"/></A>
		<july:radio styleClass="editcheckboxform" style="padding:0px;margin-left:12px;margin-right:2px;" property="stateAbonent" insertable="true" updatable="true" value="C"/><A href="javascript:toggleStateAbonent(3)">Закрытые</A>
	</td>
</tr>
<tr>
	<td colspan="2">

<!-- Abonent Dogovora Table -->
<table id="abonentID" width="100%" cellspacing="1" cellpadding="2" border="0" bgcolor="#999999" style="font-family:tahoma,arial;font-size:8pt;">
	<tr bgcolor="#CCCCCC">
		<th rowspan="2">&nbsp;</th>
		<th align="center"><b><a title="Сортровать по полю 'ban'" href="javascript:abonentSortBy('ban')"><bean:message key="label.bans.ban"/></a><%=isUp(abonentSortBy, "ban")%></b></th>
		<th align="center"><b><a title="Сортровать по полю 'balans'" href="javascript:abonentSortBy('balans')"><bean:message key="label.bans.balans"/>(NRI)</a><%=isUp(abonentSortBy, "balans")%></b></th>
		<th align="center"><b><a title="Сортровать по полю 'orgCustomerName'" href="javascript:abonentSortBy('orgCustomerName')"><bean:message key="label.bans.org.name"/></a><%=isUp(abonentSortBy, "orgCustomerName")%></b></th>
		<th align="center"><b><a title="Сортровать по полю 'orgCustomerInn'" href="javascript:abonentSortBy('orgCustomerInn')"><bean:message key="label.bans.org.inn"/></A><%=isUp(abonentSortBy, "orgCustomerInn")%></b></th>
		<th align="center"><b><a title="Сортровать по полю 'mainpositionName'" href="javascript:abonentSortBy('mainpositionName')"><bean:message key="label.mainPosition"/></A><%=isUp(abonentSortBy, "mainpositionName")%></b></th>
		<th rowspan="2" align="center"><b>Состояние</b></th>
		<th rowspan="2" align="center" title="Кол-во телефонов"><b>!</b></th>
	</tr>
	<tr bgcolor="#CCCCCC">
		<td colspan="2" align="center"><b><A title="Сортровать по полю 'managerName'" href="javascript:abonentSortBy('managerName')">Отв. менеджер</A><%=isUp(abonentSortBy, "managerName")%></b></td>
		<td align="center"><b><A title="Сортровать по полю 'economistName'" href="javascript:abonentSortBy('economistName')">Отв. экономист</A><%=isUp(abonentSortBy, "economistName")%></b></td>
		<td colspan="2" align="center"><b><A title="Сортровать по полю 'proctype'" href="javascript:abonentSortBy('proctype')">Тип обработки</A><%=isUp(abonentSortBy, "proctype")%></b></td>
	</tr>
	<tr bgcolor="#CCCCCC"><td colspan="15" style="font-size:0px;height0px;padding:0px;"></td></tr>

<!-- участвующие во взаиморасчетах -->
<logic:iterate id="it" name="ListFromPositionForm" property="abonentList">
<logic:present name="it">
<logic:equal name="it" property="useinacts" value="true">
<tr id='<bean:write name="it" property="leaseDocument" filter="true"/>' class="normalrow" onMouseOver="onMouseOverRow('abonentID',this.id);" onMouseOut="onMouseOutRow('abonentID',this.id);" style="font-size:8pt;" onclick='onClickRow("abonentID",this.id);'>
<!--	<tr bgcolor="#F0F0F0" onMouseOver="this.style.backgroundColor='#FFFFFF';this.nextSibling.style.backgroundColor='#FFFFFF';" onMouseOut="this.style.backgroundColor='#F0F0F0';this.nextSibling.style.backgroundColor='#F0F0F0';"> -->
		<td align="center">
			<july:editbutton page="/ViewAbonent.do" action="View" paramId="leaseDocument" paramName="it" paramProperty="leaseDocument" paramScope="page"/>
		</td>
		<td align="center"><bean:write name="it" property="ban" filter="true"/></td>
		<td nowrap align="right">
			<july:numberwrite name="it" property="balans" fractdigits="0"/>
			(<july:numberwrite name="it" property="balansNRI" fractdigits="0"/>)
		</td>
		<td align="center"><bean:write name="it" property="orgCustomer.shortname" filter="true"/>/<bean:write name="it" property="bil_name" filter="true"/></td>
		<td align="center"><bean:write name="it" property="orgCustomer.inn" filter="true"/></td>
		<td align="center">
			<logic:present name="it" property="mainpositionVO">
				<bean:write name="it" property="mainpositionVO.name" filter="true"/>
			</logic:present>
	        </td>
		<td rowspan="2" align="center">
			<% String temp = "/EditAbonentState.do?action=View"; %>
			<july:canedit rolesProperty="editRoles"><% temp = "/EditAbonentState.do?action=Edit"; %></july:canedit>
			<july:link page="<%= temp %>" paramId="leaseDocument" paramName="it" paramProperty="leaseDocument" scope="page">
				<logic:equal name="it" property="contractState" value="A"><bean:message key="label.bans.contractstate.a"/></logic:equal>
				<logic:equal name="it" property="contractState" value="B"><bean:message key="label.bans.contractstate.b"/></logic:equal>
				<logic:equal name="it" property="contractState" value="C"><bean:message key="label.bans.contractstate.c"/></logic:equal>
				<logic:equal name="it" property="contractState" value="D"><bean:message key="label.bans.contractstate.d"/></logic:equal>
			</july:link>
		</td>
		<td rowspan="2" align="center" title="Кол-во телефонов"><bean:write name="it" property="cntPhone" filter="true"/></td>
	</tr>
<tr id='<bean:write name="it" property="leaseDocument" filter="true"/>' class="normalrow" onMouseOver="onMouseOverRow('abonentID',this.id);" onMouseOut="onMouseOutRow('abonentID',this.id);" style="font-size:8pt;" onclick='onClickRow("abonentID",this.id);'>
<!--	<tr bgcolor="#F0F0F0" onMouseOver="this.style.backgroundColor='#FFFFFF';this.previousSibling.style.backgroundColor='#FFFFFF';" onMouseOut="this.style.backgroundColor='#F0F0F0';this.previousSibling.style.backgroundColor='#F0F0F0';"> -->
		<td title='Признак учета во взаимозачетах' align="center">
			<html:checkbox style="padding:0px;margin0px;" name="it" property="useinacts" disabled="true"/>
		</td>
		<td colspan="2">
			<logic:present name="it" property="managerVO"><bean:write name="it" property="managerVO.name" filter="true"/></logic:present>
		</td>
		<td align="center">
			<logic:present name="it" property="economistVO">
				<bean:write name="it" property="economistVO.name" filter="true"/>
			</logic:present>
		</td>	
		<td colspan="2">
			<logic:present name="it" property="proctype">
				<logic:equal name="it" property="proctype" value="A"><bean:message key="label.filter.proctype.a"/></logic:equal>
				<logic:equal name="it" property="proctype" value="B"><bean:message key="label.filter.proctype.b"/></logic:equal>
				<logic:equal name="it" property="proctype" value="C"><bean:message key="label.filter.proctype.c"/></logic:equal>
				<logic:equal name="it" property="proctype" value="D"><bean:message key="label.filter.proctype.d"/></logic:equal>
			</logic:present>
		</td>	
	</tr>
	<tr bgcolor="#CCCCCC"><td colspan="15" style="font-size:0px;height0px;padding:0px;"></td></tr>
</logic:equal>
</logic:present>
</logic:iterate>
<tr>
	<td style="font-family:tahoma,arial;font-size:8pt;color:#000000;font-weight:normal;padding:4px;" colspan="<%=gColSpan%>">
		Итого баланс по взаимозачетам:  <b><july:numberwrite name="ListFromPositionForm" property="balanceAbonentUseInAct" fractdigits="0"/> USD</b>, телефонов: <b><bean:write name="ListFromPositionForm" property="cntPhoneAbContrUseInAct" filter="true"/></b>
	</td>
</tr>
<!-- не участвующие во взаиморасчетах -->
<logic:iterate id="it" name="ListFromPositionForm" property="abonentList">
<logic:present name="it">
<logic:notEqual name="it" property="useinacts" value="true">
<tr id='<bean:write name="it" property="leaseDocument" filter="true"/>' class="normalrow" onMouseOver="onMouseOverRow('abonentID',this.id);" onMouseOut="onMouseOutRow('abonentID',this.id);" style="font-size:8pt;" onclick='onClickRow("abonentID",this.id);'>
<!--	<tr bgcolor="#F0F0F0" onMouseOver="this.style.backgroundColor='#FFFFFF';this.nextSibling.style.backgroundColor='#FFFFFF';" onMouseOut="this.style.backgroundColor='#F0F0F0';this.nextSibling.style.backgroundColor='#F0F0F0';"> -->
		<td align="center">
			<july:editbutton page="/ViewAbonent.do" action="View" paramId="leaseDocument" paramName="it" paramProperty="leaseDocument" paramScope="page"/>
		</td>
		<td align="center"><bean:write name="it" property="ban" filter="true"/></td>
		<td nowrap align="right">
			<july:numberwrite name="it" property="balans" fractdigits="0"/>
			(<july:numberwrite name="it" property="balansNRI" fractdigits="0"/>)
		</td>
		<td align="center"><bean:write name="it" property="orgCustomer.shortname" filter="true"/>/<bean:write name="it" property="bil_name" filter="true"/></td>
		<td align="center"><bean:write name="it" property="orgCustomer.inn" filter="true"/></td>
		<td align="center">
			<logic:present name="it" property="mainpositionVO">
				<bean:write name="it" property="mainpositionVO.name" filter="true"/>
			</logic:present>
	        </td>
		<td rowspan="2" align="center">
			<% String temp = "/EditAbonentState.do?action=View"; %>
			<july:canedit rolesProperty="editRoles"><% temp = "/EditAbonentState.do?action=Edit"; %></july:canedit>
			<july:link page="<%= temp %>" paramId="leaseDocument" paramName="it" paramProperty="leaseDocument" scope="page">
				<logic:equal name="it" property="contractState" value="A"><bean:message key="label.bans.contractstate.a"/></logic:equal>
				<logic:equal name="it" property="contractState" value="B"><bean:message key="label.bans.contractstate.b"/></logic:equal>
				<logic:equal name="it" property="contractState" value="C"><bean:message key="label.bans.contractstate.c"/></logic:equal>
				<logic:equal name="it" property="contractState" value="D"><bean:message key="label.bans.contractstate.d"/></logic:equal>
			</july:link>
		</td>
		<td rowspan="2" align="center"><bean:write name="it" property="cntPhone" filter="true"/></td>
	</tr>
<tr id='<bean:write name="it" property="leaseDocument" filter="true"/>' class="normalrow" onMouseOver="onMouseOverRow('abonentID',this.id);" onMouseOut="onMouseOutRow('abonentID',this.id);" style="font-size:8pt;" onclick='onClickRow("abonentID",this.id);'>
<!--	<tr bgcolor="#F0F0F0" onMouseOver="this.style.backgroundColor='#FFFFFF';this.previousSibling.style.backgroundColor='#FFFFFF';" onMouseOut="this.style.backgroundColor='#F0F0F0';this.previousSibling.style.backgroundColor='#F0F0F0';"> -->
		<td title='Признак учета во взаимозачетах' align="center">
			<html:checkbox style="padding:0px;margin0px;" name="it" property="useinacts" disabled="true"/>
		</td>
		<td colspan="2">
			<logic:present name="it" property="managerVO"><bean:write name="it" property="managerVO.name" filter="true"/></logic:present>
		</td>
		<td align="center">
			<logic:present name="it" property="economistVO">
				<bean:write name="it" property="economistVO.name" filter="true"/>
			</logic:present>
		</td>	
		<td colspan="2">
			<logic:present name="it" property="proctype">
				<logic:equal name="it" property="proctype" value="A"><bean:message key="label.filter.proctype.a"/></logic:equal>
				<logic:equal name="it" property="proctype" value="B"><bean:message key="label.filter.proctype.b"/></logic:equal>
				<logic:equal name="it" property="proctype" value="C"><bean:message key="label.filter.proctype.c"/></logic:equal>
				<logic:equal name="it" property="proctype" value="D"><bean:message key="label.filter.proctype.d"/></logic:equal>
			</logic:present>
		</td>	
	</tr>
	<tr bgcolor="#CCCCCC"><td colspan="15" style="font-size:0px;height0px;padding:0px;"></td></tr>
</logic:notEqual>
</logic:present>
</logic:iterate>
<tr>
	<td style="font-family:tahoma,arial;font-size:8pt;color:#000000;font-weight:normal;padding:4px;" colspan="<%=gColSpan%>">
		Итого баланс без взаимозачетов:  <b><july:numberwrite name="ListFromPositionForm" property="balanceAbonentAll" fractdigits="0"/> USD</b>, телефонов: <b><bean:write name="ListFromPositionForm" property="cntPhoneAbContr" filter="true"/></b>
	</td>
</tr>

<logic:notPresent name="it">
	<tr>
		<td colspan="15" bgcolor="#F0F0F0" style="padding-left:6px;">Ничего не найдено</td>
	</tr>
</logic:notPresent>
</table>

	</td>
</tr>
<%--
<tr>
	<td style="font-family:tahoma,arial;font-size:8pt;color:#000000;font-weight:normal;padding:4px;" colspan="2">
		Итого баланс:  <b><july:numberwrite name="ListFromPositionForm" property="balanceAbonentAll" fractdigits="0"/> USD</b>. Итого телефонов: <b><bean:write name="ListFromPositionForm" property="cntPhoneAbContr" filter="true"/></b>
	</td>
</tr>
--%>
</table>
	</td>
</tr>

<logic:present name="ListFromPositionForm" property="position.dopInfoVO">
<july:separator colspan="<%= gColSpan %>"/>

<tr class="normal">
	<td colspan="<%= gColSpan %>" bgcolor="#A5F3C6" style="padding-left:4px;padding-right:4px;">
		<table width="100%" cellspacing="0" border="0">
			<tr>
				<td style="font-family:tahoma,arial;font-size:8pt;color:#000000;font-weight:bold;padding:4px;">
					Комментарии юристов
					<!-- Документы -->
						<script>
							<!--
								function showTerrabyteWin() {
									//var terrabyteWin = window.open('<%=com.hps.july.util.AppUtils.getNamedValueString("TerrabyteURL")%>?type=pos&id=<bean:write name="ListFromPositionForm" property="position.storageplace" filter="true"/>&uid=<%=request.getRemoteUser()%>', "terrabyteWin", "top=60, left=60, height=" + (screen.availHeight-150) + ", width=" + (screen.availWidth-150) + ", fullscreen=no,location=no,menubar=no,resizable=yes,scrollbars=yes,status=no,titlebar=yes,toolbar=no");
									//if(terrabyteWin) terrabyteWin.focus();
									return openDialog('<%=com.hps.july.util.AppUtils.getNamedValueString("TerrabyteURL")%>?type=pos&id=<bean:write name="ListFromPositionForm" property="position.storageplace" filter="true"/>&uid=<%=request.getRemoteUser()%>', "terrabyteWin", "top=60, left=60, height=" + (screen.availHeight-150) + ", width=" + (screen.availWidth-150) + ", fullscreen=no,location=no,menubar=no,resizable=yes,scrollbars=yes,status=no,titlebar=yes,toolbar=no");
								}
							-->
						</script>
					<a href="#" onclick="return showTerrabyteWin();" class='button'>Документы</a>					
				</td>
			</tr>
			<tr>
				<td>
 					<!-- Комментарии юристов Table -->
					<table id="lawyearNoteID" width="100%" cellspacing="1" cellpadding="2" border="0" bgcolor="#999999" style="font-family:tahoma,arial;font-size:8pt;">
						<tr bgcolor="#CCCCCC">
							<th>
								<%if(request.isUserInRole("ArendaLawer") || request.isUserInRole("administrator")){%>
									<A href='LawyearNoteDialog.do?action=Add&positionId=<bean:write name="ListFromPositionForm" property="position.storageplace" filter="true"/>' onclick='return openDialog(this.href, "LawyearNoteDialog", "top=100, left=100, width=500, height=300, scrollbars=yes, resizable=yes");'>
										<IMG SRC="/images/plus.gif" BORDER='0' ALT='Добавить запись'></A>
								<%}%>
							</th>
							<th>№ п/п</th>
							<th>дата созд.</th>
							<th>ФИО созд.</th>
<%--
							<th>дата изм.</th>
							<th>ФИО изм.</th>
--%>
							<th>комментарии</th>
							<th>&nbsp;</th>
						</tr>
						<logic:iterate id="it" name="ListFromPositionForm" property="lawyearNoteList">
						<logic:present name="it">
						<tr id='<bean:write name="it" property="id" filter="true"/>' class="normalrow" onMouseOver="onMouseOverRow('lawyearNoteID', this.id);" onMouseOut="onMouseOutRow('lawyearNoteID', this.id);" style="font-size:8pt;" onclick='onClickRow("lawyearNoteID", this.id);'>
							<td align="center">
									<A href='LawyearNoteDialog.do?action=Edit&id=<bean:write name="it" property="id" filter="true"/>' onclick='return openDialog(this.href, "LawyearNoteDialog", "top=100, left=100, width=500, height=300, scrollbars=yes, resizable=yes");'>
									<IMG SRC="/images/izmena.gif" BORDER='0' ALT='Изменить запись'>
									</A>
								</td>
							<td align="center"><bean:write name="it" property="number" filter="true"/></td>
							<td align="center"><july:datewrite name="it" property="created"/></td>
							<td align="center"><bean:write name="it" property="createdName" filter="true"/></td>
<%--
							<td align="center"><july:datewrite name="it" property="modified"/></td>
							<td align="center"><bean:write name="it" property="modifiedName" filter="true"/></td>
--%>
							<td align="left"><bean:write name="it" property="note" filter="true"/></td>
							<td align="center">
<%--
									<A href='LawyearNoteDialog.do?action=Delete&id=<bean:write name="it" property="id" filter="true"/>' onclick='return openDialog(this.href, "LawyearNoteDialog", "top=100, left=100, width=500, height=300, scrollbars=yes, resizable=yes");'>
									<IMG SRC="/images/del.gif" BORDER='0' ALT='Удалить запись'>
									</A>
--%>
								</td>
						</tr>
						</logic:present>
						</logic:iterate>
					</table>
				</td>
			</tr>
		</table>
	</td>
</tr>
</logic:present>

<july:separator colspan="<%= gColSpan %>"/>

<tr class="normal">
	<td colspan="<%= gColSpan %>" bgcolor="#8899FF" style="padding-left:4px;padding-right:4px;">
		<table width="100%" cellspacing="0" border="0">
			<tr>
				<td style="font-family:tahoma,arial;font-size:8pt;color:#000000;font-weight:bold;padding:4px;" width="30%">Ссудные договора</td>
				<td style="font-family:tahoma,arial;font-size:8pt;color:#000000;font-weight:normal;text-align:right;padding-right:12px;vertical-align:middle;" width="70%">
					<july:radio styleClass="editcheckboxform" style="padding:0px;margin-left:12px;margin-right:2px;" property="stateLoan" insertable="true" updatable="true" value="0"/><A href="javascript:toggleStateLoan(0)">все</A>
					<july:radio styleClass="editcheckboxform" style="padding:0px;margin-left:12px;margin-right:2px;" property="stateLoan" insertable="true" updatable="true" value="B"/><A href="javascript:toggleStateLoan(1)">Действующие</A>
					<july:radio styleClass="editcheckboxform" style="padding:0px;margin-left:12px;margin-right:2px;" property="stateLoan" insertable="true" updatable="true" value="A"/><A href="javascript:toggleStateLoan(2)">Редактируемые</A>
					<july:radio styleClass="editcheckboxform" style="padding:0px;margin-left:12px;margin-right:2px;" property="stateLoan" insertable="true" updatable="true" value="C"/><A href="javascript:toggleStateLoan(3)">Закрытые</A>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<!-- Loan Dogovora Table -->
					<table id="loanID" width="100%" cellspacing="1" cellpadding="2" border="0" bgcolor="#999999" style="font-family:tahoma,arial;font-size:8pt;">
						<tr bgcolor="#CCCCCC">
							<th rowspan="2">&nbsp;</th>
							<th rowspan="2">&nbsp;</th>
							<th align="center"><b><a title="Сортировать по полю 'Номер договора'" href="javascript:loanSortBy('docnumber')">Номер</a><%=isUp(loanSortBy, "docnumber")%></b></th>
							<th rowspan="2">&nbsp;</th>
							<th rowspan="2">&nbsp;</th>
							<th rowspan="2" align="center" class="title" title="Причина">!</th>							
							<th align="center"><b><a title="Сортировать по полю 'Дата начала'" href="javascript:loanSortBy('startdate')">Дата нач.</a><%=isUp(loanSortBy, "startdate")%></b></th>
							<th align="center"><b><a title="Сортировать по полю 'Дата окончания'" href="javascript:loanSortBy('enddate')">Дата оконч.</A><%=isUp(loanSortBy, "enddate")%></b></th>
							<th align="center"><b><a title="Сортировать по полю 'Сумма'" href="javascript:loanSortBy('plansum')">Сумма</A><%=isUp(loanSortBy, "plansum")%></b></th>
							<th align="center"><b><a title="Сортировать по полю 'Ответственный менеджер'" href="javascript:loanSortBy('managername')">Отв. мен.</A><%=isUp(loanSortBy, "managername")%></b></th>
							<th rowspan="2" align="center"><b><a title="Сортировать по полю 'Состояние док-та'" href="javascript:loanSortBy('contractstate')">Состояние</A><%=isUp(loanSortBy, "contractstate")%></b></th>														
						</tr>
						<tr bgcolor="#CCCCCC">
							<td align="center"><b><A title="Сортировать по полю 'Дата договора'" href="javascript:loanSortBy('docdate')">Дата</A><%=isUp(loanSortBy, "docdate")%></b></td>						
							<td colspan="2" align="center"><b><A title="Сортировать по полю 'Ссудополучатель'" href="javascript:loanSortBy('orgcustomername')">Ссудополучатель</A><%=isUp(loanSortBy, "orgcustomername")%></b></td>
							<td colspan="1" align="center"><b><A title="Сортировать по полю 'осн. позиция'" href="javascript:loanSortBy('mainpositionname')">осн. позиция</A><%=isUp(loanSortBy, "mainpositionname")%></b></td>
							<td colspan="1" align="center"><b><A title="Сортировать по полю 'Отв. экон.'" href="javascript:loanSortBy('economistname')">Отв. экон.</A><%=isUp(loanSortBy, "economistname")%></b></td>
						</tr>
						<tr bgcolor="#CCCCCC"><td colspan="15" style="font-size:0px;height0px;padding:0px;"></td></tr>
					
						<logic:iterate id="il" name="ListFromPositionForm" property="loanList">
						<logic:present name="il">
						<tr id='<bean:write name="il" property="leaseDocument" filter="true"/>' class="normalrow" onMouseOver="onMouseOverRow('loanID',this.id);" onMouseOut="onMouseOutRow('loanID',this.id);" style="font-size:8pt;" onclick='onClickRow("loanID",this.id);'>
							<td class="link" rowspan="2">
								<july:canedit>
									<A href='LoanContractDialog.do?action=Edit&id=<bean:write name="il" property="leaseDocument" filter="true"/>' onclick='window.open(this.href, "LoanContractDialog", "top=100, left=350, width=600, height=550, scrollbars=yes, resizable=yes").focus(); return false;'><IMG SRC="/images/izmena.gif" BORDER='0' ALT='Изменить запись'></A>
								</july:canedit>
							</td>
							<td class="link" rowspan="2">
								<html:link page="/LoanContractMemoList.do" paramId="leaseDocument" paramName="il" paramProperty="leaseDocument"><IMG SRC="/images/dochist.gif" BORDER='0' ALT='Служебки'></html:link>
							</td>
							<td class="text" title="Номер договора" align="center" >
								<bean:write name="il" property="docnumber" filter="true"/>
							</td>
							<td class="link" rowspan="2">
									<A href='LoanAktGetPutList.do?action=&loanContract=<bean:write name="il" property="leaseDocument" filter="true"/>' onclick='return openDialog(this.href, "LoanAktGetPutList", "top=100, left=350, width=600, height=550, scrollbars=yes, resizable=yes");'><IMG SRC="/images/doc.gif" BORDER='0' ALT='Акты према-передачи'></A>
							</td>
							<td rowspan="2" title="Работа с документами">
								<a href="#" onclick='showTerrabyteWin("&id=<bean:write property="leaseDocument" name="il" />&ss=1&dv=0");return false;' class="button">Док</a>
							</td>
							<td class="text" rowspan="2" align="center" title='<bean:write name="il" property="reason" filter="true"/>'>
								<b>!</b>
							</td>
			 				<td class="date">
								<july:datewrite name="il" property="startDate"/>
			                </td>
			 				<td class="date">
			                    <july:datewrite name="il" property="endDate"/>
			                </td>
							<td class="number" nowrap align="right">
								<july:numberwrite name="il" property="planSum" fractdigits="0"/>&nbsp;
								<bean:write name="il" property="planCurrVO.name" filter="true"/>
							</td>
			 				<td class="text">
								<logic:present name="il" property="managerVO">
									<bean:write name="il" property="managerVO.name" filter="true"/>
								</logic:present>
					        </td>
							<td class="link" rowspan="2"  id='<bean:write name="il" property="leaseDocument" filter="true"/>t1' ondblclick='editLoanState(this.id, <bean:write name="il" property="leaseDocument" filter="true"/>)' title="Двойной клик для смены состояния" onmouseover="document.body.style.cursor='hand';" onmouseout="document.body.style.cursor='auto';">
								<DIV style='color:<bean:write name="il" property="contractStateColor" filter="true"/>'><U><bean:write name="il" property="contractStateStr" filter="true"/></U></DIV>
							</td>
							<%--td class="link" rowspan="2">
								<logic:equal name="il" property="contractState" value="A">
			                    <july:canedit rolesProperty="editRoles">
									<A href='LoanContractDialog.do?action=Delete&id=<bean:write name="il" property="leaseDocument" filter="true"/>' onclick='window.open(this.href, "LoanContractDialog", "top=100, left=350, width=500, height=300, scrollbars=yes, resizable=yes").focus(); return false;'>
										<img src="/images/del.gif" border="0" alt='<bean:message key="label.delete"/>'>
									</A>
			                   </july:canedit>
								</logic:equal>
							</td--%>
						</tr>
						<tr id='<bean:write name="il" property="leaseDocument" filter="true"/>' class="normalrow" onMouseOver="onMouseOverRow('loanID',this.id);" onMouseOut="onMouseOutRow('loanID',this.id);" style="font-size:8pt;" onclick='onClickRow("loanID",this.id);'>
			 				<td class="date">
			                    <july:datewrite name="il" property="docdate"/>
			                </td>
							<td class="text" colspan="2">
								<logic:present name="il" property="orgCustomer">
									<bean:write name="il" property="orgCustomer.name" filter="true"/>
								</logic:present>
							</td>
							<td class="text" colspan="1">
								<logic:present name="il" property="mainpositionVO">
									<bean:write name="il" property="mainpositionVO.name" filter="true"/>
								</logic:present>
							</td>
							<td class="text">
								<logic:present name="il" property="economistVO">
									<bean:write name="il" property="economistVO.name" filter="true"/>
								</logic:present>
							</td>	
						</tr>						
						</logic:present>
						</logic:iterate>
						
						<logic:notPresent name="il">
							<tr>
								<td colspan="15" bgcolor="#F0F0F0" style="padding-left:6px;">Ничего не найдено</td>
							</tr>
						</logic:notPresent>
					</table>	
				</td>
			</tr>
		</table>
	</td>
</tr>	

<july:separator colspan="<%= gColSpan %>"/>

<tr class="title">
	<td colspan="<%= gColSpan %>">
	<table class="find"><tr><td class="buttons"><july:backbutton page="/main.do"/></td></tr></table>
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>"/>
</table>

<logic:equal name="ListFromPositionForm" property="operation" value="alertDictionary">
<script language="javascript">
	alertDictionary(document.all.findPositionBy.value);
	//lookup_posl();
</script>
</logic:equal>

<script language="javascript">
	loadSelectedRow('arendaID');
	loadSelectedRow('abonentID');
<logic:present name="ListFromPositionForm" property="position.dopInfoVO">
	loadSelectedRow("lawyearNoteID");
</logic:present>
	loadSelectedRow('loanID');
	stat=1;
	window.location.hash=document.all.locationHash.value;
</script>

</july:editform>

<%-- <jsp:include page="common/bottom.jsp" flush="true"/> --%>
