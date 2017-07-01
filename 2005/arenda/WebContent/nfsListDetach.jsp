<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import = "com.hps.july.arenda.formbean.*"%>
<%@ page import = "com.hps.july.arenda.valueobject.*"%>

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

<%-- <jsp:include page="/common/top.jsp" flush="true"/> --%>

<%
	String gColSpan = "12";
	NFS_ListDetachForm nfsListForm = (NFS_ListDetachForm)session.getAttribute("NFS_ListDetachForm");
	String sortBy = nfsListForm.getSortBy();
%>

<july:browseform action="/ShowNFS_ListDetach.do" styleId="listForm">
<html:hidden property="sortBy"/>

<html:hidden property="operation" value="" />

<script language="javascript">
function toggleStateFilter(n){
	document.all.stateFilter[n].checked = true;
    document.body.style.cursor="wait";
	listForm.submit();
	return false;
}

function SortBy(field) 
{
	var e = document.all.sortBy;
	e.value = (e.value == field)?field + ' desc':field;
    document.body.style.cursor="wait";
    listForm.operation.value = "sortBy";
	listForm.submit();
	return false;
}

function switchDate() {
	if (document.all.isDate_SF[0].checked) {
		listForm.fromDate_SF_dt.enabled = false;
		listForm.toDate_SF_dt.enabled = false;
	} else {
		listForm.fromDate_SF_dt.enabled = true;
		listForm.toDate_SF_dt.enabled = true;
	}
	if (document.all.isDate_ZP[0].checked) {
		listForm.fromDate_ZP_dt.enabled = false;
		listForm.toDate_ZP_dt.enabled = false;
	} else {
		listForm.fromDate_ZP_dt.enabled = true;
		listForm.toDate_ZP_dt.enabled = true;
	}
	if (document.all.isDate_Pays[0].checked) {
		listForm.fromDate_Pays_dt.enabled = false;
		listForm.toDate_Pays_dt.enabled = false;
	} else {
		listForm.fromDate_Pays_dt.enabled = true;
		listForm.toDate_Pays_dt.enabled = true;
	}
	if (document.all.isDate_PaysP[0].checked) {
		listForm.fromDate_PaysP_dt.enabled = false;
		listForm.toDate_PaysP_dt.enabled = false;
	} else {
		listForm.fromDate_PaysP_dt.enabled = true;
		listForm.toDate_PaysP_dt.enabled = true;
	}
/**	
	if (!document.all.isFilterBeeline[0].checked) {
		listForm.filterBeeline.className = 'editdisabled';
		listForm.filterBeeline.disabled = true;
	} else {
		listForm.filterBeeline.className = 'editsearch';
		listForm.filterBeeline.disabled = false;
	}
*/	
}
function switchExecutor() {
	if (document.all.isExecutor[0].checked) {
		listForm.executorname.disabled = true;
		document.all['lookupimg_execl'].src='/images/lookup_disabled.gif';
		listForm.executor_vendocSiteId.disabled = true;
		listForm.executor_vendocSiteId.className = 'editdisabled';
	} else {
		listForm.executorname.disabled = false;
		document.all['lookupimg_execl'].src='/images/lookup.gif';
		listForm.executor_vendocSiteId.disabled = false;
		listForm.executor_vendocSiteId.className = 'editsearch';
	}
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
function onMouseOverRow(selectedID, className){
	document.all.tableID.rows(selectedID,0).className=className;
	document.all.tableID.rows(selectedID,1).className=className;
}
function ShowXLS()
{ 
	listForm.operation.value = "<%= com.hps.july.arenda.actionbean.NFS_ListDetachAction.PRINT_XLS%>";
	listForm.submit();
}
function switchFilter() {
	if(listForm.stateFilter.value == 0) {
		listForm.filter.disabled = true;
		listForm.filter.className = 'editdisabled';
	} else {
		listForm.filter.disabled = false;
		listForm.filter.className = 'editsearch';
		listForm.filter.focus();
	}
}
function switchDopFilter() {
	if(listForm.isDopFilter[0].checked) {
		for(var i = 0; i < dopFilterID.length; i++){
			dopFilterID[i].style.setAttribute("display", "block");
		}
		listForm.stateFilter.value = 0;
		document.all.isExecutor[0].checked = false;
	} else {
		for(var i = 0; i < dopFilterID.length; i++){
			dopFilterID[i].style.setAttribute("display", "none");
		}
		listForm.stateFilter.value = 2;
		document.all.isExecutor[0].checked = true;
		document.all.isDate_SF[0].checked = true;
		document.all.isDate_ZP[0].checked = true;
		document.all.isDate_Pays[0].checked = true;
		document.all.isDate_PaysP[0].checked = true;
	}
	switchFilter();
	switchExecutor();
	switchDate();
}
function hideDopFilter() {
	if(listForm.isDopFilter[0].checked) {
		for(var i = 0; i < dopFilterID.length; i++){
			dopFilterID[i].style.setAttribute("display", "block");
		}
	} else {
		for(var i = 0; i < dopFilterID.length; i++){
			dopFilterID[i].style.setAttribute("display", "none");
		}
	}
}
function Refresh()
{ 
	listForm.operation.value = "";
    document.body.style.cursor="wait";
	listForm.submit();
}

</script>

<table class="main"  id="tableID">

	<july:separator colspan="<%= gColSpan %>"/>

	<TR class="normal">
		<TD colspan="<%= gColSpan %>">
			<table class="find" style="font-size: 8pt">
				<tr>
					<td class="text" nowrap style="width: 120pt">поиск по:</td>
					<td class="text">
						<july:select style="font-size: 8pt;" styleClass="seach" onchange="switchFilter()" property="stateFilter" insertable="true" updatable="true">
							<%--html:option value="0">ИНН</html:option--%>
							<%--html:option value="1">НАИМЕНОВАНИЮ</html:option--%>
							<html:option value="2">№ СФ</html:option>
							<html:option value="3">№ ЗП</html:option>
							<%--html:option value="4">ПОСТАВЩИК(код)</html:option--%>
							<html:option value="0">все</html:option>							
					   	</july:select>					
						<july:string size="50" styleClass="seach" style="font-size: 8pt" property="filter" styleId="filter" insertable="true" updatable="true"/>
						<%--july:searchbutton/--%>
						<INPUT TYPE='IMAGE' SRC='/images/refresh.gif' onclick="Refresh();return false;" border='0' alt='Искать'>&nbsp;&nbsp;&nbsp;&nbsp;
						Доп.условия: <html:checkbox property="isDopFilter" onclick="switchDopFilter()"/>
						<html:hidden property="isDopFilter" value="false"/>&nbsp;&nbsp;
						<INPUT TYPE='IMAGE' SRC='/images/msexcel.gif' onclick="ShowXLS();return false;" ALT="Отчет ХLS">						
					</td>
				</tr>
				<tr id="dopFilterID">
					<td class="text">Исполнитель:</td>
					<td class="text" nowrap>
						<july:checkbox property="isExecutor" insertable="true" updatable="true" onclick="switchExecutor()"/>
						<bean:message key="label.filter.all"/>
						<july:string style="font-size: 8pt;" size="50" property="executorname" styleId="executorname" insertable="false" updatable="false"/>
						<html:link page="/../dict/VendorLookupList.do?formname=listForm&fieldnames=executorcode||executorname&onMySelect=document.forms(0).executor_vendocSiteId.value=-1;document.forms(0).submit();" onclick="if (document.all.isExecutor[0].checked) { return false; } else { return openDialog(this.href, 'VendorLookupList', 'top=40, left=100, width=700, height=650, scrollbars=yes, resizable=yes'); }" title="справочник поставщиков">		
							<img src='/images/lookup.gif' border='0' alt='Справочник поставщиков' name="lookupimg_execl"></html:link>		
						<html:hidden property="executorcode"/>
						<BR>Отдел.:
						<july:select styleId="executor_vendocSiteId"  style="width: 450; font-size: 8pt;" collection="executor_vendorSitesList" property="executor_vendocSiteId" insertable="true" updatable="true">
							<html:option value="-1">все отделения</html:option>
							<html:options collection="executor_vendorSitesList" property="vo.idVendorSite" labelProperty="info"/>
					   	</july:select>
					</td>
				</tr>				
				<%--tr>
					<td class="text" nowrap>Условие запроса по:</td>
					<td class="text" nowrap style="font-size:8pt;">
						<july:radio property="stateFilter" insertable="true" updatable="true" value="0"/>
						<A href="javascript:toggleStateFilter(0)">ИНН</A>
						<july:radio property="stateFilter" insertable="true" updatable="true" value="1"/>
						<A href="javascript:toggleStateFilter(1)">НАИМЕНОВАНИЮ</A>
						<july:radio property="stateFilter" insertable="true" updatable="true" value="2"/>
						<A href="javascript:toggleStateFilter(2)">№ СФ</A>
						<july:radio property="stateFilter" insertable="true" updatable="true" value="3"/>
						<A href="javascript:toggleStateFilter(3)">№ ЗП</A>
						<july:radio property="stateFilter" insertable="true" updatable="true" value="4"/>
						<A href="javascript:toggleStateFilter(4)">ПОСТАВЩИК(код)</A>
					</td>
				</tr--%>
				<tr id="dopFilterID">
					<td class="text" nowrap>Период создания СФ:</td>
					<td class="text">
						<table class="find" border="0" cellpading="0" cellspacing="0" style="font-size:8pt;">
							<tr>
								<td class="text">
									<july:checkbox property="isDate_SF" insertable="true" updatable="true" onclick="switchDate()"/>
									<bean:message key="label.filter.all"/>
								</td>
								<td class="text"><july:date property="dataPeriod_SF.fromDateFrm" size="25" insertable="true" updatable="true" styleId="fromDate_SF"/></td>
								<td class="text"><B>по:</B></td>
								<td class="text"><july:date property="dataPeriod_SF.toDateFrm" size="25" insertable="true" updatable="true" styleId="toDate_SF"/></td>
							</tr>
						</table>
					</td>
				</tr>
				<tr id="dopFilterID">
					<td class="text" nowrap>Период создания ЗП:</td>
					<td class="text">
						<table class="find" border="0" cellpading="0" cellspacing="0" style="font-size:8pt;">
							<tr>
								<td class="text">
									<july:checkbox property="isDate_ZP" insertable="true" updatable="true" onclick="switchDate()"/>
									<bean:message key="label.filter.all"/>
								</td>
								<td class="text"><july:date property="dataPeriod_ZP.fromDateFrm" size="25" insertable="true" updatable="true" styleId="fromDate_ZP"/></td>
								<td class="text"><B>по:</B></td>
								<td class="text"><july:date property="dataPeriod_ZP.toDateFrm" size="25" insertable="true" updatable="true" styleId="toDate_ZP"/></td>
							</tr>
						</table>
					</td>
				</tr>
				<tr id="dopFilterID">
					<td class="text" nowrap>Период создания ПП:</td>
					<td class="text">
						<table class="find" border="0" cellpading="0" cellspacing="0" style="font-size:8pt;">
							<tr>
								<td class="text">
									<july:checkbox property="isDate_Pays" insertable="true" updatable="true" onclick="switchDate()"/>
									<bean:message key="label.filter.all"/>
								</td>
								<td class="text"><july:date property="dataPeriod_Pays.fromDateFrm" size="25" insertable="true" updatable="true" styleId="fromDate_Pays"/></td>
								<td class="text"><B>по:</B></td>
								<td class="text"><july:date property="dataPeriod_Pays.toDateFrm" size="25" insertable="true" updatable="true" styleId="toDate_Pays"/></td>
							</tr>
						</table>
					</td>
				</tr>
				<tr id="dopFilterID">
					<td class="text" nowrap>Период оплаты ПП:</td>
					<td class="text">
						<table class="find" border="0" cellpading="0" cellspacing="0" style="font-size:8pt;">
							<tr>
								<td class="text">
									<july:checkbox property="isDate_PaysP" insertable="true" updatable="true" onclick="switchDate()"/>
									<bean:message key="label.filter.all"/>
								</td>
								<td class="text"><july:date property="dataPeriod_PaysP.fromDateFrm" size="25" insertable="true" updatable="true" styleId="fromDate_PaysP"/></td>
								<td class="text"><B>по:</B></td>
								<td class="text"><july:date property="dataPeriod_PaysP.toDateFrm" size="25" insertable="true" updatable="true" styleId="toDate_PaysP"/></td>
							</tr>
						</table>
					</td>
				</tr>
				<%--tr>
					<td class="text" nowrap>По организации Beeline:</td>
					<td class="text">
						<table class="main" border="0" cellpading="0" cellspacing="0" style="font-size:8pt;">
							<tr>
								<td class="text">
									<july:checkbox property="isFilterBeeline" insertable="true" updatable="true" onclick="switchDate()"/>
								</td>
								<td class="text">
									<july:select styleClass="seach" property="filterBeeline" insertable="true" updatable="true" style="font-size:8pt; width: 100pt;">
										<html:option value="81">Вымпелком</html:option>
										<html:option value="101">КБИ</html:option>
								   	</july:select>
								</td>
							</tr>
						</table>
					</td>
				</tr--%>
			</table>
		</TD>
	</TR>

	<july:separator colspan="<%= gColSpan %>"/>

	<tr class="title">
		<td colspan="<%= gColSpan %>">
			<table class="buttons">
				<tr class="title">
					<td class="buttons">
						<july:backbutton/>
					</td>
					<td align="right">
						отобрано записей:<%= request.getAttribute("numberOfLines") %>
					</td>
					<td class="navigator"><july:navigator/></td>
				</tr>
			</table>
		</td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>
	<!-- Table header -->
	<tr class="title">
		<td class="title" rowspan="2">&nbsp;</td>
		<td class="title" nowrap>
			<A title="Сортировать по полю 'номер ЗП'" href="javascript:SortBy('numZp')">номер ЗП</A><%=isUp(sortBy, "numZp")%>
		</td>
		<td class="title" nowrap>
			<A title="Сортировать по полю 'номер СФ'" href="javascript:SortBy('numSf')">номер СФ</A><%=isUp(sortBy, "numSf")%>
		</td>
		<td class="title" nowrap>
			<A title="Сортировать по полю 'сумма СФ'" href="javascript:SortBy('sumSf')">сумма СФ<%=isUp(sortBy, "sumSf")%>
		</td>
		<td class="title" nowrap>
			<A title="Сортировать по полю 'состоянию СФ'" href="javascript:SortBy('stateSf')">сост. СФ<%=isUp(sortBy, "stateSf")%>
		</td>
		<td class="title" nowrap>
			<A title="Сортировать по полю 'номер ПП'" href="javascript:SortBy('numPay')">номер ПП<%=isUp(sortBy, "numPay")%>
		</td>
		<td class="title" nowrap>
			<A title="Сортировать по полю 'дата платежа'" href="javascript:SortBy('datePay')">дата ПП</A><%=isUp(sortBy, "datePay")%>
		</td>
		<td class="title" nowrap>
			<A title="Сортировать по полю 'сост. ПП'" href="javascript:SortBy('statePay')">сост. ПП<%=isUp(sortBy, "statePay")%>
		</td>
		<td class="title" nowrap>
			<A title="Сортировать по полю 'сумма ПП'" href="javascript:SortBy('sumPay')">сумма ПП<%=isUp(sortBy, "sumPay")%>
		</td>
		<td class="title" nowrap>
			<A title="Сортировать по полю 'сумма ПП в руб.'" href="javascript:SortBy('sumRubPay')">сумма ПП(руб.)<%=isUp(sortBy, "sumRubPay")%>
		</td>
	</tr>
	<tr class="title">
		<td class="title" colspan="1" align="center" nowrap>орг. Beeline</td>
		<td class="title" colspan="3" align="center" nowrap>поставщик</td>
		<td class="title" colspan="5" align="center" nowrap>назначение платежа</td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>

	<!-- Table body -->
	<logic:iterate id="it" name="browseList" indexId="indexId"> 
		<logic:present name="it">
		<%
		    NFS_VO nfsVO = (NFS_VO )it;
			String className = "normal";
			if( !nfsVO.isActiveRecord() )
				className = "gray";
		%>
		<tr id='<bean:write name="indexId"/>'  class="<%= className%>" style="font-size:8pt;" onMouseOver="onMouseOverRow(this.id);" onMouseOut="onMouseOverRow(this.id, '<%= className%>')">
			<td class="text" rowspan="2">
			  <html:link page="/NFS_Print.do?action=View" name="it" property="params" onclick="return openDialog(this.href, 'pWindow', 'top=100,	left=250, width=700, height=500, scrollbars=yes, resizable=yes, menubar=yes');">
				<IMG SRC="/images/izmena.gif" BORDER='0' ALT='Просмотр записи'>
			  </html:link>
			</td>
			<td class="text" title='подробно'>
				<logic:present name="it" property="zpNFS">
					<html:link page="/NFS_Print.do?action=View" name="it" property="params" onclick="return openDialog(this.href, 'pWindow', 'top=100, left=250, width=700, height=500, scrollbars=yes, resizable=yes, menubar=yes');">
						<bean:write name="it" property="zpNFS.numZp" filter="true"/>
					</html:link>
				</logic:present>
			</td>
			<td class="text">
				<logic:present name="it" property="schetFaktNFS">
					<html:link page="/NFS_Print.do?action=View" name="it" property="params" 
						onclick="return openDialog(this.href, 'pWindow', 'top=100, left=250, width=700, height=500, scrollbars=yes, resizable=yes, menubar=yes');">
						<bean:write name="it" property="schetFaktNFS.numSf" filter="true"/>
					</html:link>
				</logic:present>
			</td>
			<td class="text" align="right">
				<logic:present name="it" property="schetFaktNFS">
					<july:sumwrite name="it" property="schetFaktNFS.sumSf"/>&nbsp;<bean:write name="it" property="schetFaktNFS.currSf" filter="true"/>
				</logic:present>
			</td>
			<td class="text">
				<logic:present name="it" property="schetFaktNFS">
					<bean:write name="it" property="schetFaktNFS.stateSf" filter="true"/>
				</logic:present>
			</td>
			<td class="text">
				<logic:present name="it" property="payNFS">
					<bean:write name="it" property="payNFS.numPay" filter="true"/>
				</logic:present>
			</td>
			<td class="text">
				<logic:present name="it" property="payNFS">
					<july:datewrite name="it" property="payNFS.datePay"/>
				</logic:present>
			</td>
			<td class="text">
				<logic:present name="it" property="payNFS">
					<bean:write name="it" property="payNFS.statePay" filter="true"/>
				</logic:present>
			</td>
			<td class="text" align="right">
				<logic:present name="it" property="payNFS">
					<july:sumwrite name="it" property="payNFS.sumPay"/>&nbsp;<bean:write name="it" property="payNFS.currPay" filter="true"/>
				</logic:present>
			</td>
			<td class="text" align="right">
				<logic:present name="it" property="payNFS">
					<july:sumwrite name="it" property="payNFS.sumRubPay"/>
				</logic:present>
			</td>
		</tr>
		<tr id='<bean:write name="indexId"/>'  class="<%= className%>" style="font-size:8pt;" onMouseOver="onMouseOverRow(this.id);" onMouseOut="onMouseOverRow(this.id, '<%= className%>')">
			<td class="text" colspan="1" align="center">
				<logic:present name="it" property="schetFaktNFS">
					<logic:equal name="it" property="schetFaktNFS.idorgnfs" value="81">
						Вымпелком
					</logic:equal>
					<logic:equal name="it" property="schetFaktNFS.idorgnfs" value="101">
						КБИ
					</logic:equal>
				</logic:present>	
				<logic:notPresent name="it" property="schetFaktNFS">
					<logic:equal name="it" property="zpNFS.idorgnfs" value="81">
						Вымпелком
					</logic:equal>
					<logic:equal name="it" property="zpNFS.idorgnfs" value="101">
						КБИ
					</logic:equal>
				</logic:notPresent>				
			</td>
			<td class="text" colspan="3" align="center">
				<logic:present name="it" property="schetFaktNFS">
						<logic:present name="it" property="schetFaktNFS.vendor">
							<bean:write name="it" property="schetFaktNFS.vendor.name"/>
						</logic:present>
				</logic:present>
				<logic:notPresent name="it" property="schetFaktNFS">
						<logic:present name="it" property="zpNFS.vendor">
							<bean:write name="it" property="zpNFS.vendor.name"/>
						</logic:present>
				</logic:notPresent>
			</td>
			<td class="text" colspan="5" align="center">
				<logic:present name="it" property="payNFS">
					<july:stringwrite name="it" property="payNFS.purpose"/>
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
						<july:backbutton/>
					</td>
					<td align="right">
						отобрано записей:<%= request.getAttribute("numberOfLines") %>
					</td>
					<td class="navigator"><july:navigator/></td>
				</tr>
			</table>
		</td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>
</table>

<script language="javascript">
	switchDate();
	switchExecutor();
	stat=1;
	hideDopFilter();
	switchFilter();
</script>

</july:browseform>

<%-- <jsp:include page="/common/bottom.jsp" flush="true"/> --%>
