<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import = "com.hps.july.arenda.formbean.*"%>
<%@ page import = "com.hps.july.valueobject.*"%>
<SCRIPT language=javascript src="/common/dialog.js" type="text/javascript"></SCRIPT>  

<%!private String isUp(String aSort, String name) {
	if (aSort.startsWith(name)) {
		if (aSort.endsWith("desc"))
			return (" <img src='/images/up.gif'  border='0' alt='по возрастанию'> ");
		else
			return (" <img src='/images/down.gif'  border='0' alt='по убыванию'> ");
	} else
		return ("");
}
%>

<%	String gColSpan = "12";
	LeaseZPOfficeMemoListForm listForm =
		(LeaseZPOfficeMemoListForm) session.getAttribute("LeaseZPOfficeMemoListForm");
	String sortBy = listForm.getSortBy();
	String propDialog = "top=140, left=350, width=650, height=550, scrollbars=yes, resizable=yes";
%>
<july:browseform action="/LeaseZPOfficeMemoList.do" styleId="listForm">
	<html:hidden property="idContract" />
	<html:hidden property="sortBy" />

	<html:hidden property="operation" value="" />
	<html:hidden property="idCode" value="-1" />
	<html:hidden property="toState" value="" />
	<html:hidden property="selectedID" value="0" />

	<script language="javascript">
function SortBy(field) 
{
	var e = document.all.sortBy;
	e.value = (e.value == field)?field + ' desc':field;
    document.body.style.cursor="wait";
	listForm.submit();
	return false;
}
function deleteItem(number, idItem) {
	if(confirm('Удалить запись c номером: ' + number+ ' ?')) {
		document.body.style.cursor="wait";
		document.all.operation.value="deleteItem";
		document.all.idcwacode.value=idItem;
		listForm.submit();
		return false;
	}
}
function changeState(toState){
	document.body.style.cursor="wait";
	document.all.operation.value="changeState";
	document.all.toState.value=toState;
	document.all.idCode.value=document.all.selectedID.value;
	//alert("idCode=" + document.all.idCode.value + " toState=" + toState);
	listForm.submit();
	return false;
}

function onMouseOutRow(selectedID){
	if(document.all.selectedID.value==selectedID) {
		document.all.tableID.rows(selectedID,0).className="selected";
	}
	else {
		document.all.tableID.rows(selectedID,0).className="normal";
	}
}
function onClickRow(selectedID) {
	if(document.all.tableID.rows(document.all.selectedID.value) != null){
		document.all.tableID.rows(document.all.selectedID.value,0).className="normal";
	}
	document.all.selectedID.value=selectedID;
	document.all.tableID.rows(selectedID,0).className="selected";
	storeSelectedRow(selectedID);
}
function storeSelectedRow(selectedID) {
	document.cookie = listForm.name+"=" + selectedID;
}
function loadSelectedRow() {
	var cookies = document.cookie;
	//считываем selectedID:
	var startLoc = cookies.indexOf(listForm.name+"=");
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
	}
}
</script>

	<table class="main" id="tableID" style="font-size: 8pt"> 
	<july:separator colspan="<%= gColSpan %>"/>
	<!-- Данные о договоре: -->
	<TR class="normal">
		<TD colspan="<%= gColSpan %>">
			<table class="find">
				<tr>
					<td class="text">
						<A href='AgreementInfo.do?action=View&leaseDocument=<bean:write name="LeaseZPOfficeMemoListForm" property="mainLeaseContractKey"/>'
							 onclick='return openDialog(this.href, "AgreementInfo", "top=200, left=200, width=700, height=500, scrollbars=yes, resizable=yes");' class='button'>
							<bean:message key="label.dhist.contractInfo"/>:
						</A>
					</td>				
					<td class="text">
						<bean:write name="LeaseZPOfficeMemoListForm" property="docNumber" filter="true" />
						&nbsp;от&nbsp;<july:datewrite name="LeaseZPOfficeMemoListForm" property="docDate"/>
					</td>
					<td class="text" rowspan="3" width="15%" align="center" valign="middle">
						<july:searchbutton/>
					</td>					
				</tr>			
			</table>
		</TD>
	</TR>

		<july:separator colspan="<%=gColSpan%>" />				
		<tr class="title">
			<td colspan="<%=gColSpan%>">
			<table class="buttons">
				<tr class="title">
					<td class="buttons"><july:canedit rolesProperty="editRoles"></july:canedit>
					<A
						href='LeaseZPOfficeMemoDialog.do?action=Add&idContract=<bean:write name="LeaseZPOfficeMemoListForm" property="mainLeaseContractKey" filter="true"/>'
						onclick='return openDialog(this.href, "LeaseZPOfficeMemoDialog", "<%=propDialog%>");'>
					<IMG SRC="/images/plus.gif" BORDER='0' ALT='Добавить запись'></A>
					&nbsp;<july:backbutton/></td>
					<td align="right">отобрано записей:<%=request.getAttribute("numberOfLines")%>
					</td>
					<td class="navigator"><july:navigator/></td>
				</tr>
			</table>
			</td>
		</tr>

		<july:separator colspan="<%=gColSpan%>" />
		<!-- Table header -->
		<tr class="title">
			<td class="title">&nbsp;</td>
			<td class="title"><A title="Сортировать по полю 'Номер служ.'"
				href="javascript:SortBy('idOfficeMemo')">Номер</A><%=isUp(sortBy, "idOfficeMemo")%>
			</td>
			<td class="title"><A title="Сортировать по полю 'Тип служ.'"
				href="javascript:SortBy('typeActionZP')">Тип</A><%=isUp(sortBy, "typeActionZP")%>
			</td>			
			<%--td class="title">&nbsp;</td--%>
			<%--td class="title">&nbsp;</td--%>
			<td class="title"><A
				title="Сортировать по полю 'Дата начала периода'"
				href="javascript:SortBy('dateStartZP')">с___</A><%=isUp(sortBy, "dateStartZP")%>
			</td>
			<td class="title"><A
				title="Сортировать по полю 'Дата окончания периода'"
				href="javascript:SortBy('dateEndZp')">по__</A><%=isUp(sortBy, "dateEndZp")%>
			</td>
			<td class="title"><A title="Сортировать по полю 'Сумма служ.'"
				href="javascript:SortBy('sumZP')">Сумма</A><%=isUp(sortBy, "sumZP")%>
			</td>
			<td class="title"><A title="Сортировать по полю 'НДС служ.'"
				href="javascript:SortBy('sumNdsZP')">НДС</A><%=isUp(sortBy, "sumNdsZP")%>
			</td>
			<td class="title"><A title="Сортировать по полю 'Валюта'"
				href="javascript:SortBy('curName')">Валюта</A><%=isUp(sortBy, "curName")%>
			</td>
			<%--td class="title"><A
				title="Сортировать по полю 'Состояние служ.'"
				href="javascript:SortBy('state')">Состояние служ.</A><%=isUp(sortBy, "state")%>
			</td--%>
			<td class="title">&nbsp;</td>
			<td class="title">&nbsp;</td>
		</tr>

		<july:separator colspan="<%=gColSpan%>" />

		<!-- Table body -->
		<logic:iterate id="it" name="browseList" type="LeaseZPOfficeMemo_TO">
			<logic:present name="it">
				<tr
					id='<bean:write name="it" property="vo.idOfficeMemo" filter="true"/>'
					class="normal" style="font-size: 8pt"
					onMouseOver="className='select'"
					onMouseOut="onMouseOutRow(this.id);" onclick='onClickRow(this.id);'>
					<td class="link">
					<%
						String actionMemo = "View";
						LeaseZPOfficeMemo_TO to = (LeaseZPOfficeMemo_TO)it;
						//String state = to.getVo().getState();
						//ввести константы состояния в CDBC_Object !!!
						//if( state.equals("1") )
							actionMemo = "Edit";
					%>
					<%--logic:notPresent name="it" property="vo.idAkt"--%>
						<A href='LeaseZPOfficeMemoDialog.do?action=<%= actionMemo%>&id=<bean:write name="it" property="vo.idOfficeMemo" filter="true"/>'
							onclick='return openDialog(this.href, "LeaseZPOfficeMemoDialog", "<%=propDialog%>");'>
						<IMG SRC="/images/izmena.gif" BORDER='0' ALT='Изменить запись'></A>
					<%--/logic:notPresent--%>
					</td>
					<td class="text"><bean:write name="it" property="vo.idOfficeMemo" filter="true" /></td>
					<td class="text">
						<logic:equal name="it" property="vo.typeActionZP" value="I">созд.</logic:equal>
						<logic:equal name="it" property="vo.typeActionZP" value="U">изм.</logic:equal>
					</td>
					<%--td class="text" align="center">
						<img src='/images/infohint.gif' border=0 alt='Получатель платежа:&nbsp;<july:stringwrite name="it" property="vendorSiteName"/>&#10;<bean:message key="label.payments.executor.account"/>:&nbsp;<july:stringwrite name="it" property="account"/>&#10;<bean:message key="label.payments.executor.bik"/>:&nbsp;<july:stringwrite name="it" property="bankBik"/>&#10;<bean:message key="label.payments.executor.bank"/>:&nbsp;<july:stringwrite name="it" property="bankName"/>'>
					</td--%>
					<%--td class="text" align="center">
						<img src='/images/infohint.gif' border=0 alt='<bean:message key="label.payments.paypurpose"/>:&#10;<july:stringwrite name="it" property="vo.purpose"/>'>
					</td--%>					
					<td class="text"><july:datewrite name="it" property="vo.dateStartZP" /></td>
					<td class="text"><july:datewrite name="it" property="vo.dateEndZp" /></td>
					<td class="number" align="right" nowrap><july:sumwrite name="it" property="vo.sumZP"/></td>
					<td class="number" align="right" nowrap><july:sumwrite name="it" property="vo.sumNdsZP"/></td>
					<td class="text">			
						<logic:present name="it" property="vo.idCurrCharge">
							<bean:write name="it" property="curName" filter="true"/>
						</logic:present>
					</td>
					<%--td class="text">	 		
						<html:select style="width: 120px;" name ="it" property="vo.state" styleId="state" onchange='changeState(this.value);'>
							<html:option value="1">Оформляется</html:option>
							<html:option value="2">Оплачена</html:option>
							<html:option value="3">Отклонена</html:option>
						</html:select>
					</td--%>
					<td class="link" align="center" nowrap="nowrap">
					<%
						String idStr = "" + ((LeaseZPOfficeMemo_TO) it).getVo().getIdOfficeMemo();
						Integer typeDoc = com.hps.july.terrabyte.core.DocumentTypes.LEASE_ZP_OFFICE_MEMO; //тип документа 
						String objectType = com.hps.july.terrabyte.core.ObjectTypes.LEASE_ZP_OFFICE_MEMO; //objectType 
					%>
						<%--logic:notEqual name="it" property="vo.state" value="1"--%>
						<july:wordedit styleId='<%= "wrded1_" + idStr %>' url='<%= "LeaseZPOfficeMemoWordAction.do?id=" + idStr%>' 
							uploadurl='<%= "DocumentUploadAction.do?typeDoc=" + typeDoc + "&objectType=" + objectType %>' documentid="<%= idStr %>">
							<IMG SRC="/images/docword.gif" border="0" alt='<bean:message key="label.mutaulacts.createword"/>'></july:wordedit>
						<%--/logic:notEqual--%>
						<july:wordedit styleId='<%= "wrded2_" + idStr %>' url='<%= "DocumentWordDownloadServlet?id=" + idStr + "&objectTypes=" + objectType %>'
							uploadurl='<%= "DocumentUploadAction.do?typeDoc=" + typeDoc + "&objectType=" + objectType %>' documentid="<%= idStr %>">
							<IMG SRC="/images/getdbword.gif" border="0" alt='<bean:message key="label.mutualacts.fromdb"/>'></july:wordedit>
					</td>
					<td class="text"><july:canedit rolesProperty="editRoles"></july:canedit>
						<%--logic:equal name="it" property="vo.state" value="1"--%>
						<%--logic:notPresent name="it" property="vo.idAkt"--%>
							 <A href='LeaseZPOfficeMemoDialog.do?action=Delete&id=<bean:write name="it" property="vo.idOfficeMemo" filter="true"/>'
								onclick='return openDialog(this.href, "LeaseZPOfficeMemoDialog", "<%=propDialog%>");'>
							    <img src="/images/del.gif" border="0" alt='Удалить запись'> </A>
						<%--/logic:notPresent--%>
						<%--/logic:equal--%>
					</td>
				</tr>
				<july:separator colspan="<%=gColSpan%>" />
			</logic:present>
		</logic:iterate>

		<tr class="title">
			<td colspan="<%=gColSpan%>">
			<table class="buttons">
				<tr class="title">
					<td class="buttons"><july:canedit rolesProperty="editRoles"></july:canedit>
					<A
						href='LeaseZPOfficeMemoDialog.do?action=Add&idContract=<bean:write name="LeaseZPOfficeMemoListForm" property="mainLeaseContractKey" filter="true"/>'
						onclick='return openDialog(this.href, "LeaseZPOfficeMemoDialog", "<%=propDialog%>");'>
					<IMG SRC="/images/plus.gif" BORDER='0' ALT='Добавить запись'></A>
					&nbsp;<july:backbutton/></td>
					<td align="right">отобрано записей:<%=request.getAttribute("numberOfLines")%>
					</td>
					<td class="navigator"><july:navigator/></td>
				</tr>
			</table>
			</td>
		</tr>

		<july:separator colspan="<%=gColSpan%>" />
	</table>

</july:browseform>

<script language="javascript">
	loadSelectedRow();
	window.location.hash=document.all.selectedID.value;
</script>
