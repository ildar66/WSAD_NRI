<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import ="com.hps.july.jdbcpersistence.lib.*"%>
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

<%
	String gColSpan = "19"; 
	WeArendaListForm listForm = (WeArendaListForm)session.getAttribute("WeArendaListForm");
	String sortBy = listForm.getSortBy();
%>

<july:browseform action="/ShowWeArendaList.do" styleId="WeArendaListForm">
<html:hidden property="checkCode" value="0"/>
<html:hidden property="selectedID" value="0"/>
<html:hidden property="sortBy"/>

<script language="javascript">
function switchCustomer() {
	if (document.all.isCustomer[0].checked) {
		WeArendaListForm.customer.className = 'editdisabled';
		WeArendaListForm.customer.disabled = true;
	} else {
		WeArendaListForm.customer.className = 'editsearch';
		WeArendaListForm.customer.disabled = false;
	}
}
function switchExecutor() {
	if (document.all.isExecutor[0].checked) {
		WeArendaListForm.executorname.disabled = true;
		document.all['lookupimg_execl'].src='/images/lookup_disabled.gif';
		WeArendaListForm.executor_vendocSiteId.disabled = true;
		WeArendaListForm.executor_vendocSiteId.className = 'editdisabled';
	} else {
		WeArendaListForm.executorname.disabled = false;
		document.all['lookupimg_execl'].src='/images/lookup.gif';
		WeArendaListForm.executor_vendocSiteId.disabled = false;
		WeArendaListForm.executor_vendocSiteId.className = 'editsearch';
	}
}
function switchEconomist() {
	if (document.all.isEconomist[0].checked) {
		WeArendaListForm.economistname.disabled = true;
		document.all['lookupimg_economistl'].src='/images/lookup_disabled.gif';
	} else {
		WeArendaListForm.economistname.disabled = false;
		document.all['lookupimg_economistl'].src='/images/lookup.gif';
	}
}
function switchPosition() {
	if (document.all.isPosition[0].checked) {
		WeArendaListForm.positionname.disabled = true;
		document.all['lookupimg_posl'].src='/images/lookup_disabled.gif';
	} else {
		WeArendaListForm.positionname.disabled = false;
		document.all['lookupimg_posl'].src='/images/lookup.gif';
	}
}
function switchDocnumber() {
	if (document.all.isDocnumber[0].checked) {
		WeArendaListForm.docnumber.className = 'editdisabled';
		WeArendaListForm.docnumber.disabled = true;
	} else {
		WeArendaListForm.docnumber.className = 'editsearch';
		WeArendaListForm.docnumber.disabled = false;
	}
}
function warn_electro(leaseDocument, numberDoc){
	if(confirm('Согласны на создание копии договора № '+ numberDoc +'?'))
	{
		document.all.checkCode.value=leaseDocument;
	    document.body.style.cursor="wait";
		WeArendaListForm.submit();
		return true;
	}
	return false;
}
function toggleState(n){
	document.all.state[n].checked = true;
	WeArendaListForm.submit();
}
function onMouseOutRow(selectedID){
	if(document.all.selectedID.value==selectedID) {
		document.all.tableID.rows(selectedID,0).className="selected";
		document.all.tableID.rows(selectedID,1).className="selected";
	}
	else {
		document.all.tableID.rows(selectedID,0).className="normal";
		document.all.tableID.rows(selectedID,1).className="normal";
	
	}
}
function onMouseOverRow(selectedID){
	document.all.tableID.rows(selectedID,0).className="select";
	document.all.tableID.rows(selectedID,1).className="select";
}
function onClickRow(selectedID) {
	if(document.all.tableID.rows(document.all.selectedID.value) != null){
		document.all.tableID.rows(document.all.selectedID.value,0).className="normal";
		document.all.tableID.rows(document.all.selectedID.value,1).className="normal";
	}
	document.all.selectedID.value=selectedID;
	document.all.tableID.rows(selectedID,0).className="selected";
	document.all.tableID.rows(selectedID,1).className="selected";
	storeSelectedRow(selectedID);
}
function storeSelectedRow(selectedID) {
	document.cookie = "arendaID=" + selectedID;
}
function loadSelectedRow() {
	var cookies = document.cookie;
	//считываем selectedID:
	var startLoc = cookies.indexOf("arendaID=");
	if(startLoc == -1)
	   return;
	var sepLoc = cookies.indexOf("=", startLoc);
	var endLoc = cookies.indexOf(";", startLoc);
	if(endLoc == -1) {
		endLoc = cookies.length;
    }
    document.all.selectedID.value = cookies.substring(sepLoc+1, endLoc);
	//подчеркиваем строку в таблице:
	if( document.all.tableID.rows(document.all.selectedID.value) != null ) {
 		document.all.tableID.rows(document.all.selectedID.value,0).className="selected";
		document.all.tableID.rows(document.all.selectedID.value,1).className="selected";
	}
}
function switchResource(){
	if (document.all.isResource[0].checked) {
		WeArendaListForm.resource.className = 'editdisabled';
		WeArendaListForm.resource.disabled = true;
	} else {
		WeArendaListForm.resource.className = 'editsearch';
		WeArendaListForm.resource.disabled = false;
	}
}
function SortBy(field) 
{
	var e = document.all.sortBy;
	e.value = (e.value == field)?field + ' desc':field;
    document.body.style.cursor="wait";
	WeArendaListForm.submit();
	return false;
}
function switchFilter() {
	if(WeArendaListForm.filter.value == 0) {
		WeArendaListForm.searchString.disabled = true;
		WeArendaListForm.searchString.className = 'editdisabled';
	} else {
		WeArendaListForm.searchString.disabled = false;
		WeArendaListForm.searchString.className = 'editsearch';
		WeArendaListForm.searchString.focus();
	}
}
function switchDopFilter() {
	if(WeArendaListForm.isDopFilter[0].checked) {
		for(var i = 0; i < dopFilterID.length; i++){
			dopFilterID[i].style.setAttribute("display", "block");
		}
		WeArendaListForm.filter.value = 0;
		document.all.isPosition[0].checked = false;
	} else {
		for(var i = 0; i < dopFilterID.length; i++){
			dopFilterID[i].style.setAttribute("display", "none");
		}
		WeArendaListForm.filter.value = 1;
		document.all.isCustomer[0].checked = true;
		document.all.isExecutor[0].checked = true;
		document.all.isEconomist[0].checked = true;
		document.all.isPosition[0].checked = true;
		document.all.isResource[0].checked = true;		
	}
	switchFilter();
	switchCustomer();
	switchExecutor();
	switchEconomist();
	switchPosition();
	switchResource();	
}
function hideDopFilter() {
	if(WeArendaListForm.isDopFilter[0].checked) {
		for(var i = 0; i < dopFilterID.length; i++){
			dopFilterID[i].style.setAttribute("display", "block");
		}
	} else {
		for(var i = 0; i < dopFilterID.length; i++){
			dopFilterID[i].style.setAttribute("display", "none");
		}
	}
}
function showPositionsDialogList(mainLeaseContractKey){
	var hrefStr = 'PositionsDialogList.do?mainLeaseContractKey='+mainLeaseContractKey;
	return openDialog(hrefStr, 'PositionsDialogList', 'top=100,	left=150, width=650, height=310, scrollbars=yes, resizable=yes, menubar=no');
}
</script>

<table class="main"  id="tableID">

	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr class="normal">
		<td colspan="<%= gColSpan %>">
			<table class="find" style="font-size: 8pt;">
				<tr>
					<td class="text" width="24%"><%--bean:message key="label.filter.docnumber"/--%>поиск по:</td>
					<td class="text" nowrap="nowrap">
						<%--july:checkbox property="isDocnumber" insertable="true" updatable="true" onclick="switchDocnumber()"/--%>
						<%--bean:message key="label.filter.all"/--%>
						<%--july:string size="50" property="docnumber" styleId="docnumber" insertable="true" updatable="true"/--%>						
						<july:select style="font-size: 8pt;" styleClass="seach" onchange="switchFilter()" property="filter" insertable="true" updatable="true">
							<html:option value="1">номер договора</html:option>
							<%--html:option value="2">исполнитель(арендодатель)</html:option--%>
							<%--html:option value="3">ответственный:</html:option--%>
							<html:option value="4">ответственный менеджер</html:option>
							<html:option value="5">ответственный экономист</html:option>
							<html:option value="6">№ GSM/DCS</html:option>
							<html:option value="7">№ DAMPS</html:option>
							<html:option value="8">по названии позиции</html:option>
							<html:option value="9">по адресу позиции</html:option>
							<html:option value="0">все</html:option>							
					   	</july:select>
					   	<july:string style="font-size: 8pt;" property="searchString" styleId="searchString" styleClass="search" size="25" insertable="true" updatable="true"/>						
					   	<july:searchbutton/>&nbsp;&nbsp;
						Доп.условия: <html:checkbox property="isDopFilter" onclick="switchDopFilter()"/>
						<html:hidden property="isDopFilter" value="false"/>
					</td>
				</tr>			
				<tr id="dopFilterID">
					<td class="text"><bean:message key="label.filter.customer"/>:</td>
					<td class="text" nowrap>
						<july:checkbox property="isCustomer" insertable="true" updatable="true" onclick="switchCustomer()"/>
						<bean:message key="label.filter.all"/>
						<july:select styleId="customer" style="width: 450; font-size: 8pt;" collection="customers" property="customercode" insertable="true" updatable="true">
							<html:options collection="customers" property="idOwnerContract" labelProperty="name"/>
						</july:select>
						<%--july:searchbutton/--%>
					</td>
				</tr>
				<tr id="dopFilterID">
					<td class="text"><bean:message key="label.chargerules.resource"/>:</td>
					<td class="text">
						<july:checkbox property="isResource" insertable="true" updatable="true" onclick="switchResource()"/>
						<bean:message key="label.filter.all"/>
						<july:select styleId="resource"  style="width: 450; font-size: 8pt;" collection="resources" property="resourcecode" insertable="true" updatable="true">
							<html:options collection="resources" property="resource" labelProperty="name"/>
					   	</july:select>
					</td>
				</tr>
				<tr id="dopFilterID">
					<td class="text"><bean:message key="label.filter.executor.arenda"/>:</td>
					<td class="text" nowrap>
						<july:checkbox property="isExecutor" insertable="true" updatable="true" onclick="switchExecutor()"/>
						<bean:message key="label.filter.all"/>
						<july:string style="font-size: 8pt;" size="50" property="executorname" styleId="executorname" insertable="false" updatable="false"/>
						<%--july:lookupbutton action="/ShowOrganizationLookupList.do" styleId="execl" fieldNames="executorcode;executorname" insertable="true" updatable="true" onclick="if (document.all.isExecutor[0].checked) { return false; }"
						onselect = "document.forms(0).submit();"/--%>
						<html:link page="/../dict/VendorLookupList.do?formname=WeArendaListForm&fieldnames=executorcode||executorname&onMySelect=document.forms(0).executor_vendocSiteId.value=-1;document.forms(0).submit();" onclick="if (document.all.isExecutor[0].checked) { return false; } else { return openDialog(this.href, 'VendorLookupList', 'top=40, left=100, width=700, height=650, scrollbars=yes, resizable=yes'); }" title="справочник поставщиков">		
							<img src='/images/lookup.gif' border='0' alt='Справочник поставщиков' name="lookupimg_execl"></html:link>		
						<html:hidden property="executorcode"/>
						<BR>Отдел.:
						<july:select styleId="executor_vendocSiteId"  style="width: 450; font-size: 8pt;" collection="executor_vendorSitesList" property="executor_vendocSiteId" insertable="true" updatable="true">
							<html:option value="-1">все отделения</html:option>
							<html:options collection="executor_vendorSitesList" property="vo.idVendorSite" labelProperty="info"/>
					   	</july:select>
					</td>
				</tr>
				<tr id="dopFilterID">
					<td class="text"><bean:message key="label.filter.responsible"/>:</td>
					<td class="text" nowrap>
						<july:checkbox property="isEconomist" insertable="true" updatable="true" onclick="switchEconomist()"/>
						<bean:message key="label.filter.all"/>
						<july:string style="font-size: 8pt;" size="50" property="economistname" styleId="economistname" insertable="false" updatable="false"/>
						<july:lookupbutton action="/ShowWorkerLookupList.do" styleId="economistl" fieldNames="economistcode;economistname" insertable="true" updatable="true" onclick="if (document.all.isEconomist[0].checked) { return false; }"
						onselect = "document.forms(0).submit();"/>
						<html:hidden property="economistcode"/>
					</td>
				</tr>
				<tr id="dopFilterID">
					<td class="text"><bean:message key="label.filter.position"/>:</td>
					<td class="text" nowrap>
						<july:checkbox property="isPosition" insertable="true" updatable="true" onclick="switchPosition()"/>
						<bean:message key="label.filter.all"/>
						<july:string style="font-size: 8pt;" size="50" property="positionname" styleId="positionname" insertable="false" updatable="false"/>
						<july:lookupbutton action="/../basestation/ShowPositionLookupList.do?planstate=2" styleId="posl" fieldNames="positioncode;;positionname" insertable="true" updatable="true" onclick="if (document.all.isPosition[0].checked) { return false; }" onselect = "document.forms(0).submit();"/>
						<html:hidden property="positioncode"/>
					</td>
				</tr>
				<tr>
					<td class="text">Состояние:</td>
					<td class="text" nowrap="nowrap">
						<july:radio property="state" insertable="true" updatable="true" value="A"/>
						<A href="javascript:toggleState(0)"><bean:message key="label.filter.all"/></A>
						<july:radio property="state" insertable="true" updatable="true" value="1"/>
						<A href="javascript:toggleState(1)"><bean:message key="label.bans.contractstate.a"/></A>
						<july:radio property="state" insertable="true" updatable="true" value="2"/>
						<A href="javascript:toggleState(2)"><bean:message key="label.bans.contractstate.b"/></A>
						<july:radio property="state" insertable="true" updatable="true" value="4"/>
						<A href="javascript:toggleState(3)"><bean:message key="label.state.unclosed"/></A>
						<july:radio property="state" insertable="true" updatable="true" value="3"/>
						<A href="javascript:toggleState(4)"><bean:message key="label.bans.contractstate.c"/></A>
					</td>
				</tr>
			</table> 
		</td>
	</tr>
	
<script language="javascript">
	switchCustomer();
	switchExecutor();
	switchEconomist();
	switchPosition();
	//switchDocnumber();
	switchFilter();
	switchResource();
</script>

	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr class="title">
		<td colspan="<%= gColSpan %>">
			<table class="buttons">
				<tr class="title">
					<td class="buttons">
						<july:canedit rolesProperty="editRoles"><july:addbutton page="/ViewWeArenda.do?action=Add"/></july:canedit>
						<july:backbutton page="/main.do"/>
					</td>
					<td align="right">
						<bean:message key="label.numrecords"/>:<%= request.getAttribute("numberOfLines") %>
					</td>
					<td class="navigator"><july:navigator/></td>
				</tr>
			</table>
		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>

	<!-- Table header -->
	<tr class="title" style="font-size:8pt;">
		<td  rowspan="2" align="center" class="title">&nbsp;</td>
		<td class="title" align="center" nowrap>
			<A title="Сортировать по полю 'Номер договора'" href="javascript:SortBy('mainDocumentNumber')"><b>Номер</b></A>
			<%=isUp(sortBy, "mainDocumentNumber")%>
		</td>
		<td class="title" align="center" nowrap>
			<A title="Сортировать по полю 'Дата договора'" href="javascript:SortBy('maindocdate')"><b>Дата</b></A>
			<%=isUp(sortBy, "maindocdate")%>
		</td>
		<td class="title" align="center" nowrap>
			<A title="Сортировать по полю 'Дата начала'" href="javascript:SortBy('mainstartdate')"><b>Дата<BR>начала</b></A>
			<%=isUp(sortBy, "mainstartdate")%>
		</td>
		<td class="title" align="center" nowrap>
			<A title="Сортировать по полю 'Дата окончания'" href="javascript:SortBy('activeDogC.enddate')"><b>Дата<BR>окончания</b></A>
			<%=isUp(sortBy, "activeDogC.enddate")%>
		</td>
		<td colspan="2" align="center">
			<A title="Сортировать по полю ''Сумма договора" href="javascript:SortBy('activeDogC.summ1')"><b><bean:message key="label.table.sumofcontract"/></b></A>
			<%=isUp(sortBy, "activeDogC.summ1")%>
		</td>
		<td colspan="2" align="center">
			<A title="Сортировать по полю ''в т.ч. трафик" href="javascript:SortBy('trafic1')"><b><bean:message key="label.table.trafic"/></b></A>
			<%=isUp(sortBy, "trafic1")%>
		</td>
		<td align="center" class="title" title="Признак безакцептного списания">
			<A title="Сортировать по полю ''Признак безакцептного списания" href="javascript:SortBy('accept1')"><b> ! </b></A>
			<%=isUp(sortBy, "accept1")%>
		</td>
		<td rowspan="2" align="center" title="Инциденты">
			<A title="Сортировать по полю 'Инциденты'" href="javascript:SortBy('countProblemOnContract')"><b> ! </b></A>
			<%=isUp(sortBy, "countProblemOnContract")%>
		</td>		
		<td rowspan="2" align="center">
			<A title="Сортировать по полю ''Услуги договора" href="javascript:SortBy('resource')"><b><bean:message key="label.table.resources"/></b></A>
			<%=isUp(sortBy, "resource")%>
		</td>
		<td rowspan="1" align="center">
			<A title="Сортировать по полю ''Ответственный менеджер" href="javascript:SortBy('mainmanagername')"><b>Отв. менеджер</b></A>
			<%=isUp(sortBy, "mainmanagername")%>
		</td>
		<td rowspan="2" align="center" class="title" title='Регистрация договора в государственных органах'>
			<A title="Сортировать по полю 'Регистрация договора в государственных органах'" href="javascript:SortBy('activeDogA.officialdoc')"><b>!</b></A>
			<%=isUp(sortBy, "activeDogA.officialdoc")%>
		</td>
		<td rowspan="2" align="center" class="title" title='<bean:message key="label.history"/>'><b>!</b></td>
		<td rowspan="2" align="center">
			<A title="Сортировать по полю 'Состояние базового док-та'" href="javascript:SortBy('maincontractstate')"><b><bean:message key="label.table.state"/></b></A>
			<%=isUp(sortBy, "maincontractstate")%><BR>
			<A title="Сортировать по полю 'дата состояния базового док-та'" href="javascript:SortBy('maindateclose')">(Датa сост.)</A>
			<%=isUp(sortBy, "maindateclose")%>
		</td>
		<%--
		<july:headercolumn key="label.table.checkprolong" colType="string"/>
		--%>
		<td rowspan="2" align="center" class="title" title="Признак продления">
			<A title="Сортировать по полю 'Признак автоматического продления'" href="javascript:SortBy('activeDogC.extendtype')"><b>!</b></A>
			<%=isUp(sortBy, "activeDogC.extendtype")%>
		</td>
		<%--
		<td align="center" class="title" title='Текс документа'><b>!</b></td> 
		--%>
		<td rowspan="2" align="center" class="title" title="<bean:message key='label.filter.document.electro'/>"><b>!</b></td>
		<td rowspan="2" align="center" class="title" title="Удалить"><b>!</b></td>
	</tr>
	<tr class="title" style="font-size:8pt;">
		<td colspan="1" align="center" class="title">
			<A title="Сортировать по полю 'Заказчик'" href="javascript:SortBy('orgcustomername')"><b><bean:message key="label.filter.customer"/></b></A>
			<%=isUp(sortBy, "orgcustomername")%>
		</td>
		<td colspan="3" align="center" class="title">
			<A title="Сортировать по полю ''Исполнитель" href="javascript:SortBy('orgexecutorname')"><b><bean:message key="label.filter.executor.arenda"/></b></A>
			<%=isUp(sortBy, "orgexecutorname")%>
		</td>
		<td colspan="5" align="center" class="title">
			<A title="Сортировать по полю ''осн. позиция" href="javascript:SortBy('mainpositionname')"><b><bean:message key="label.filter.position"/></b></A>
			<%=isUp(sortBy, "mainpositionname")%>
		</td>
		<td colspan="1" align="center" class="title">
			<A title="Сортировать по полю ''Ответственный экономист" href="javascript:SortBy('maineconomistname')"><b>Отв. экономист</b></A>
			<%=isUp(sortBy, "maineconomistname")%>
		</td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>

	<!-- Table body -->
	<logic:iterate id="it" name="browseList">
		<logic:present name="it">
		     <tr id='<bean:write name="it" property="o.leaseDocument" filter="true"/>' class="normal" onMouseOver="onMouseOverRow(this.id);" onMouseOut="onMouseOutRow(this.id);" style="font-size:8pt;" onclick='onClickRow(this.id);'>
				<td class="link" rowspan="2">
					<july:editbutton page="/ViewWeArenda.do" action="View" paramId="leaseDocument" paramName="it" paramProperty="o.leaseDocument" paramScope="page"/>
					<logic:present name="it" property="o.mainLeaseDocument">
						<july:link page="/ShowDogHistoryList.do" paramId="contract" paramName="it" paramProperty="o.mainLeaseDocument" >
						<img src="/images/obchet1.gif" border=0 alt='<bean:message key="label.contractcalc"/>'>
					</july:link>
					</logic:present>
					<logic:notPresent name="it" property="o.mainLeaseDocument">
						<july:link page="/ShowDogHistoryList.do" paramId="contract" paramName="it" 
						paramProperty="o.leaseDocument" >
						<img src="/images/obchet1.gif" border=0 alt='<bean:message key="label.contractcalc"/>'>
					</july:link>
					</logic:notPresent>
				</td>
				<td class="text" align="center" nowrap>
					<bean:write name="it" property="mainDocumentNumber" filter="true"/>
				</td>
				
 				<td class="date">
					<july:datewrite name="it" property="mainDocumentDate"/>
                </td>
				
 				<td class="date">
					<july:datewrite name="it" property="mainStartDate"/>
                </td>
				
 				<td class="date">
                    <july:datewrite name="it" property="o.endDate"/>
                </td>
				
 				<td class="number" align="right" nowrap title='<july:numberwrite name="it" property="o.summ1"/>' colspan="2">
					<logic:present name="it" property="o.summ1">
						<july:numberwrite name="it" property="o.summ1" fractdigits="0"/> <bean:write name="it" property="o.currency1.shortname" filter="true"/>
					</logic:present>
                </td>
<%--				
 				<td class="number" align="right"  nowrap title='<july:numberwrite name="it" property="o.summ2"/>'>
					<logic:present name="it" property="o.summ2">
						<july:numberwrite name="it" property="o.summ2" fractdigits="0"/> <bean:write name="it" property="o.currency2.shortname" filter="true"/>
					</logic:present>
                </td>
--%>
				<td class="number" align="right" nowrap title='<july:numberwrite name="it" property="trafic1"/>' colspan="2">
					<logic:present name="it" property="trafic1">
						<july:numberwrite name="it" property="trafic1" fractdigits="0"/> <bean:write name="it" property="o.currency1.shortname" filter="true"/>
					</logic:present>
				</td>
<%--
				<td class="number" align="right" nowrap title='<july:numberwrite name="it" property="trafic2"/>'>
					<logic:present name="it" property="trafic2">
						<july:numberwrite name="it" property="trafic2" fractdigits="0"/> <bean:write name="it" property="o.currency2.shortname" filter="true"/>
					</logic:present>
				</td>
--%>
				<td  align="center" title='<logic:present name="it" property="accept1">сумма безакцептного списания в осн. вал. = <july:numberwrite name="it" property="accept1"/> <bean:write name="it" property="o.currency1.shortname" filter="true"/></logic:present><logic:present name="it" property="accept2">сумма безакцептного списания в доп. вал. = <july:numberwrite name="it" property="accept2"/> <bean:write name="it" property="o.currency2.shortname" filter="true"/></logic:present>'>
					<logic:present name="it" property="accept1">!</logic:present>
<%--
					<logic:present name="it" property="accept2">!</logic:present>
--%>
				</td>
				
				<td align="center" rowspan="2" title="Инциденты по договору">
					<html:link page="/LeaseContractProblemList.do" paramId="idContract" paramName="it" 
							paramProperty="o.leaseDocument" styleClass="button">
						<bean:write name="it" property="countProblemOnContract" filter="true"/></html:link>		
				</td>				

				<td class="text" align="center" rowspan="2" style="font-size:8pt;">
					<%String styleDiv = "";%>
					<logic:equal name="it" property="o.calcelectrotype" value="2">
						<%styleDiv = "style='color: red'";%>
					</logic:equal>
					<logic:equal name="it" property="o.calcelectrotype" value="3">
						<%styleDiv = "style='color: red'";%>
					</logic:equal>
					
					<DIV <%=styleDiv%>><bean:write name="it" property="resources" filter="true"/></DIV>
				</td>

				<td class="text" align="center"  title='<bean:message key="label.filter.poiskovik"/>' nowrap>
					<logic:present name="it" property="mainManager">
						<bean:write name="it" property="mainManager.name" filter="true"/>
					</logic:present>
				</td>

				<% String color = ""; String title = ""; String value = "";%>
				<logic:equal name="it" property="o.officialdoc" value="Y">
					<% title = "зарегистрирован в гос. органах"; value = "R"; color = "green"; %>
				</logic:equal>
				<logic:equal name="it" property="o.officialdoc" value="N">
					<logic:present name="it" property="o.needofficialdoc">
						<logic:equal name="it" property="o.needofficialdoc" value="Y">
							<% title = "необходимо зарегистрировать в гос. органах"; value = "R"; color = "red"; %>
						</logic:equal>
					</logic:present>
				</logic:equal>

				<td class="text" align="center" rowspan="2" style="font-size:8pt;" title='<%= title%>'>
					<B style="color: <%= color%>;"><%= value%></B>
				</td>

				<td class="text" rowspan="2">
				<logic:present name="it" property="o.mainLeaseDocument">
					<july:link page="/ShowHistoryList.do" paramId="leaseDocument" paramName="it" paramProperty="o.mainLeaseDocument" paramScope="page">
						<img src='/images/dochist.gif' border=0 alt='<bean:message key="label.history"/>'>
					</july:link>
				</logic:present>
				<logic:notPresent name="it" property="o.mainLeaseDocument">
					<july:link page="/ShowHistoryList.do" paramId="leaseDocument" paramName="it" paramProperty="o.leaseDocument" paramScope="page">
						<img src='/images/dochist.gif' border=0 alt='<bean:message key="label.history"/>'>
					</july:link>
				</logic:notPresent>
                </td>
				
				<td class="link" align="center" rowspan="2">
					<% String temp = "/EditWeState.do?action=View"; %>
					<july:canedit rolesProperty="editRoles"><% temp = "/EditWeState.do?action=Edit"; %></july:canedit>
					<%--july:link page="<%= temp %>" paramId="leaseDocument" paramName="it" paramProperty="o.leaseDocument" paramScope="page"--%>
                		<logic:equal name="it" property="mainContractState" value="A"><bean:message key="label.state.prepared"/></logic:equal>
						<logic:equal name="it" property="mainContractState" value="B"><bean:message key="label.state.continued"/></logic:equal>
						<logic:equal name="it" property="mainContractState" value="C">
							<bean:message key="label.state.stoped"/><BR>
							<july:datewrite name="it" property="mainDateClose"/>
						</logic:equal>
						<logic:equal name="it" property="mainContractState" value="D">
							<bean:message key="label.state.unclosed"/>
							<july:datewrite name="it" property="mainDateClose"/>
						</logic:equal>
					<%--/july:link--%>
                </td>
				
				<td class="text" align="center" rowspan="2" title="<bean:message key='label.extendtype.auto'/>"> 
					<logic:equal name="it" property="o.extendType" value="A">+</logic:equal>
                </td>
				<%--
				<td class="link" align="center" rowspan="2">
					<logic:present name="it" property="o.docFileName">
						<% String emptyString = ""; %>
						<logic:notEqual name="it" property="o.docFileName" value="<%= emptyString %>">
							<html:link page="/DocumentDownload?param=documentText" paramId="leaseDocument" paramName="it" paramProperty="o.leaseDocument" target="_blank">
								<img src="/images/kontr.gif" border=0 alt='<bean:write name="it" property="o.docFileName" filter="true"/>'>
							</html:link>
						</logic:notEqual>
					</logic:present>
				</td>
				--%>
				<%-- Old history -- Commented out
				<td class="link" align="center">
					<html:link page="/ShowCalcHistory.do" paramId="leaseDocument" paramName="it" paramProperty="o.leaseDocument" onclick="window.open(this.href, 'ab', 'top=100, left=100, width=700, height=500, scrollbars=yes, resizable=yes'); return false;">
						<img src="/images/obchet1.gif" border=0 alt="<bean:message key="label.contractcalc"/>">
					</html:link>
                </td>
				--%>

				<td class="link"  rowspan="2">
					<img src="/images/npocasca.gif" onclick="warn_electro(<bean:write name="it" property="o.leaseDocument"/>, '<bean:write name="it" property="mainDocumentNumber"/>');" border=0 alt="<bean:message key='label.filter.document.electro'/>">				
				</td>
				
				<td class="link"  rowspan="2">
					<july:canedit rolesProperty="editRoles">
						<logic:equal name="it" property="o.contractState" value="A">
							<july:delbutton page="/ViewWeArenda.do?action=Delete" paramId="leaseDocument" paramName="it" paramProperty="o.leaseDocument" paramScope="page"/>
						</logic:equal>
					</july:canedit>
				</td>
			</tr>
		     <tr id='<bean:write name="it" property="o.leaseDocument" filter="true"/>' class="normal" onMouseOver="onMouseOverRow(this.id);" onMouseOut="onMouseOutRow(this.id);" style="font-size:8pt;" onclick='onClickRow(this.id);'> 
				<td class="text" align="center" colspan="1" style="font-size:8pt;">
				  <logic:present name="it" property="o.orgCustomer.shortname">
					<bean:write name="it" property="o.orgCustomer.shortname" filter="true"/>
                  </logic:present>
				 </td>
				<td class="text" align="center" colspan="3" style="font-size:8pt;">
				  <logic:present name="it" property="o.orgExecutor.shortname">
					<bean:write name="it" property="o.orgExecutor.shortname" filter="true"/>
                  </logic:present>
				</td>
				<td class="text" align="center" colspan="5" style="font-size:8pt;" title='<bean:write name="it" property="allPositions" filter="true"/>'>
					<logic:present name="it" property="o.mainLeaseDocument">
						<img src="/images/doc.gif" onclick="showPositionsDialogList(<bean:write name="it" property="o.mainLeaseDocument"/>);" border=0 title="Позиции по договору">				
					</logic:present>
					<logic:notPresent name="it" property="o.mainLeaseDocument">
						<img src="/images/doc.gif" onclick="showPositionsDialogList(<bean:write name="it" property="o.leaseDocument"/>);" border=0 title="Позиции по договору">				
					</logic:notPresent>
					<logic:present name="it" property="mainPosition">
						<bean:write name="it" property="mainPosition" filter="true"/>
					</logic:present>
					<logic:present name="it" property="allPositions">
						<logic:match name="it" property="allPositions" value=";">
							&nbsp;...
						</logic:match>
					</logic:present>
					<logic:present name="it" property="allPositions">
						<logic:notMatch name="it" property="allPositions" value=";">
							<logic:notEqual name="it" property="allPositions" value="">
								<logic:equal name="it" property="mainPosition" value="">
									&nbsp;...
								</logic:equal>
							</logic:notEqual>
						</logic:notMatch>
					</logic:present>
				</td>
				<td class="text" align="center" title="<bean:message key='label.filter.economist'/>" nowrap>
					<logic:present name="it" property="mainEconomist">
						<bean:write name="it" property="mainEconomist.name" filter="true"/>
					</logic:present>
				</td>
			</tr>
		<july:separator colspan="<%= gColSpan %>"/>
		</logic:present>
	</logic:iterate>
	
	<tr class="title"> 
		<td colspan="<%= gColSpan %>">
			<table class="buttons">
				<tr class="title">
					<td class="buttons">
						<july:canedit rolesProperty="editRoles"><july:addbutton page="/ViewWeArenda.do?action=Add"/></july:canedit>
						<july:backbutton page="/main.do"/>
					</td>
					<td align="right">
						<bean:message key="label.numrecords"/>:<%= request.getAttribute("numberOfLines") %>
					</td>
					<td class="navigator"><july:navigator/></td>
				</tr>
			</table>
		</td>
	</tr>
		
	<july:separator colspan="<%= gColSpan %>"/>
	
</table>

</july:browseform>

<SCRIPT FOR='abody' EVENT=onkeypress language="JScript">
	//alert(window.event.keyCode);
	if (window.event.keyCode == 13) {
		window.event.cancelBubble=true; 
		submitForm();
	}
</SCRIPT>
<script language="javascript">
	loadSelectedRow();
	window.location.hash=document.all.selectedID.value;
	stat = 1;
	hideDopFilter();
</script>
