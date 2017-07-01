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

<%
	String gColSpan = "14";
	CompletWorkActsListForm listForm = (CompletWorkActsListForm)session.getAttribute("CompletWorkActsListForm");
	String sortBy = listForm.getSortBy();
%>

<july:browseform action="/CompletWorkActsList.do" styleId="listForm">
<html:hidden property="idContract"/>
<html:hidden property="sortBy"/>
<html:hidden property="operation" value=""/>
<html:hidden property="idcwacode" value="-1"/>
<html:hidden property="toActState" value=""/>

<html:hidden property="selectedID" value="0"/>

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
function changeActState(toActState){
	document.body.style.cursor="wait";
	document.all.operation.value="changeActState";
	document.all.toActState.value=toActState;
	document.all.idcwacode.value=document.all.selectedID.value;
	//alert("idcwacode=" + document.all.idcwacode.value + " toActState=" + toActState);
	listForm.submit();
	return false;
}
function printItemWord(idItem){
	window.location.href='/arenda/CompletWorkAktWordAction.do?idcwacode='+idItem;
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

<table class="main" id="tableID">

	<july:separator colspan="<%= gColSpan %>"/>
	<!-- Данные о договоре: -->
	<TR class="normal">
		<TD colspan="<%= gColSpan %>">
			<table class="find">
				<tr>
					<td class="text" style="font-weight: normal;">
						<B>№ дог.:</B>
						<bean:write name="CompletWorkActsListForm" property="agreement.mainDocumentNumber" filter="true"/>
						<B><bean:message key="label.filter.ot"/></B>
						<july:datewrite name="CompletWorkActsListForm" property="agreement.mainDocumentDate"/>
						<B>c:</B>
						<july:datewrite name="CompletWorkActsListForm" property="agreement.mainStartDate"/>
						<B><bean:message key="label.filter.stop"/></B>
						<july:datewrite name="CompletWorkActsListForm" property="agreement.mainEndDate"/>
						&nbsp;&nbsp;&nbsp;
						<B><bean:message key="label.filter.costcurrency"/>:</B>
						<july:sumwrite name="CompletWorkActsListForm" property="agreement.o.summ1"/>&nbsp;
						<bean:write name="CompletWorkActsListForm" property="agreement.o.currency1.shortname" filter="true"/>
						<logic:present name="CompletWorkActsListForm" property="agreement.o.summ2">
							;&nbsp;<july:sumwrite name="CompletWorkActsListForm" property="agreement.o.summ2"/>
							&nbsp;<bean:write name="CompletWorkActsListForm" property="agreement.o.currency2.shortname" filter="true"/>
						</logic:present>
					</td>
				</tr>
				<tr>
					<td class="text" colspan="2" style="font-weight: normal;">
						<B><bean:message key="label.mainPosition"/></B>
						<bean:write name="CompletWorkActsListForm" property="agreement.mainPosition" filter="true"/>
					</td>
				</tr>
				<tr>
					<td class="text" style="font-weight: normal;">
						<B><bean:message key="label.filter.customer"/>:</B>
						<logic:present name="CompletWorkActsListForm" property="agreement.mainOrgCustomer">
							<bean:write name="CompletWorkActsListForm" property="agreement.mainOrgCustomer.name" filter="true"/>
						</logic:present>
						&nbsp;&nbsp;&nbsp;
						<B><bean:message key="label.organization.isrenter"/>:</B>
						<logic:present name="CompletWorkActsListForm" property="agreement.mainOrgExecutor">
							<bean:write name="CompletWorkActsListForm" property="agreement.mainOrgExecutor.name" filter="true"/>
						</logic:present>
					</td>
				</tr>
			</table>
		</TD>
	</TR>

	<july:separator colspan="<%= gColSpan %>"/>

	<tr class="title">
		<td colspan="<%= gColSpan %>">
			<table class="buttons">
				<tr class="title">
					<td class="buttons">
						<%--html:link page="/EditCompletWorkAkt.do?action=Add" paramId="idContract" paramName="CompletWorkActsListForm" paramProperty="agreement.o.mainLeaseDocument">
							<IMG SRC="/images/plus.gif" BORDER='0' ALT='Добавить запись'>
						</html:link--%>
						<html:link page="/CompletWorkAktDialog.do?action=Add" paramId="idContract" paramName="CompletWorkActsListForm" paramProperty="agreement.o.mainLeaseDocument" onclick="return openDialog(this.href, 'CompletWorkAktDialog', 'top=150, left=470, width=550, height=350, scrollbars=yes, resizable=yes');">
							<IMG SRC="/images/plus.gif" BORDER='0' ALT='Добавление акта'>
						</html:link>						
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
		<td class="title">&nbsp;</td>
		<td class="title" nowrap>
			<A title="Сортировать по полю 'Номер документа'" href="javascript:SortBy('docnumber')">Номер</A><%=isUp(sortBy, "docnumber")%>
		</td>
		<td class="title" nowrap>
			<A title="Сортировать по полю 'Учетная дата документа'" href="javascript:SortBy('docdate')">Дата</A><%=isUp(sortBy, "docdate")%>
		</td>
		<td class="title" nowrap>
			<A title="Сортировать по полю 'Дата начала периода акта'" href="javascript:SortBy('actstartdate')">с___</A><%=isUp(sortBy, "actstartdate")%>
		</td>
		<td class="title" nowrap>
			<A title="Сортировать по полю 'Дата окончания периода акта'" href="javascript:SortBy('actenddate')">по__</A><%=isUp(sortBy, "actenddate")%>
		</td>
		<td class="title" nowrap>
			<A title="Сортировать по полю 'Наименование услуг'" href="javascript:SortBy('nameWork')">Наименование услуги</A><%=isUp(sortBy, "nameWork")%>
		</td>
		<td class="title" nowrap>
			<A title="Сортировать по полю 'Сумма акта'" href="javascript:SortBy('actSum')">Сумма</A><%=isUp(sortBy, "actSum")%>
		</td>
		<td class="title" nowrap>
			<A title="Сортировать по полю 'НДС акта'" href="javascript:SortBy('actNds')">НДС</A><%=isUp(sortBy, "actNds")%>
		</td>
		<td class="title" nowrap>
			<A title="Сортировать по полю 'Валюта'" href="javascript:SortBy('currency')">Валюта</A><%=isUp(sortBy, "currency")%>
		</td>
		<td class="title" nowrap>
			<A title="Сортировать по полю 'Состояние акта'" href="javascript:SortBy('actstate')">Состояние</A><%=isUp(sortBy, "actstate")%>
		</td>
		<td class="title">&nbsp;</td>
		<td class="title">Опись</td>
		<td class="title">&nbsp;</td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>

	<!-- Table body -->
	<logic:iterate id="it" name="browseList"> 
		<logic:present name="it">
		<tr id='<bean:write name="it" property="idcwacode" filter="true"/>' class="normal" style="font-size:8pt;" onMouseOver="className='select'" onMouseOut="onMouseOutRow(this.id);" onclick='onClickRow(this.id);'>
			<td class="link">
				<%
					String actionCWA = "View";
					CompletWorkAct_VO vo = (CompletWorkAct_VO)it;
					String state = vo.getActstate();
					if(state.equals("O") || state.equals("R") || state.equals("1") )
						actionCWA = "Edit";
				%>			
				<A href='CompletWorkAktDialog.do?action=<%= actionCWA%>&id=<bean:write name="it" property="idcwacode" filter="true"/>'
					onclick='return openDialog(this.href, "CompletWorkAktDialog", "top=150, left=470, width=550, height=350, scrollbars=yes, resizable=yes");'>
				<IMG SRC="/images/izmena.gif" BORDER='0' ALT='Изменить запись'></A>								
			</td>
			<td class="text">
				<bean:write name="it" property="docnumber" filter="true"/>
			</td>
			<td class="text">
				<july:datewrite name="it" property="docdate"/>
			</td>
			<td class="text">
				<july:datewrite name="it" property="actstartdate"/>
			</td>
			<td class="text">
				<july:datewrite name="it" property="actenddate"/>
			</td>
			<td class="text">
				<bean:write name="it" property="nameWork" filter="true"/>
			</td>
			<td class="number" align="right" nowrap>
				<july:sumwrite name="it" property="actSum"/>
			</td>
			<td class="number" align="right" nowrap>
				<july:sumwrite name="it" property="actNds"/>
			</td>
			<td class="text">
				<logic:present name="it" property="currencyVO">
					<bean:write name="it" property="currencyVO.shortname" filter="true"/>
				</logic:present>
			</td>
			<td class="text">
				<html:select name ="it" property="actstate" styleId="actstate" onchange='changeActState(this.value);'>
					<html:option value="O">редактируется</html:option>
					<html:option value="R">рассчитан</html:option>
					<html:option value="1">получен от аренд.</html:option>
					<html:option value="2">передан в бух.</html:option>
					<html:option value="3">принят бух.</html:option>
					<html:option value="4">Передан закупщику</html:option>
					<html:option value="5">Принят закупщиком</html:option>
					<html:option value="V">Возвращен</html:option>
				</html:select>
			</td>
				
			<td class="link" align="center">
				<%
					String idStr = "" + ((CompletWorkAct_VO)it).getIdcwacode();
					Integer typeDoc = com.hps.july.terrabyte.core.DocumentTypes.COMPLET_WORK_ACTS; //тип документа 
					String objectType = com.hps.july.terrabyte.core.ObjectTypes.COMPLET_WORK_ACTS; //objectType 
				%> 
<%-- 
				<A href='javascript:printItemWord(<bean:write name="it" property="idcwacode" filter="true"/>)'>
					<img src="/images/docword.gif" border=0 alt='Печать акта'>
				</A>
--%>
				<logic:notEqual name="it" property="actstate" value="O">
				<%--july:wordedit styleId='<%= "wrded1_" + idStr %>' url='<%= "CompletWorkAktWordAction.do?idcwacode=" + idStr %>' 
							uploadurl="CompletWorkAktWordUploadAction.do" documentid="<%= idStr %>">
							<IMG SRC="/images/docword.gif" border="0" alt='<bean:message key="label.mutaulacts.createword"/>'></july:wordedit>
				</logic:notEqual--%>
				<july:wordedit styleId='<%= "wrded1_" + idStr %>' url='<%= "CompletWorkAktWordAction.do?idcwacode=" + idStr %>' 
						uploadurl='<%= "DocumentUploadAction.do?typeDoc=" + typeDoc + "&objectType=" + objectType %>' documentid="<%= idStr %>">
						<IMG SRC="/images/docword.gif" border="0" alt='<bean:message key="label.mutaulacts.createword"/>'></july:wordedit>
				</logic:notEqual>
				
				<%--july:wordedit styleId='<%= "wrded2_" + idStr %>' url='<%= "CompletWorkAktWordDownload?idcwacode=" + idStr %>'
						uploadurl="CompletWorkAktWordUploadAction.do" documentid="<%= idStr %>">
						<IMG SRC="/images/getdbword.gif" border="0" alt='<bean:message key="label.mutualacts.fromdb"/>'></july:wordedit--%>
				<july:wordedit styleId='<%= "wrded2_" + idStr %>' url='<%= "DocumentWordDownloadServlet?id=" + idStr + "&objectTypes=" + objectType %>'
						uploadurl='<%= "DocumentUploadAction.do?typeDoc=" + typeDoc + "&objectType=" + objectType %>' documentid="<%= idStr %>">
						<IMG SRC="/images/getdbword.gif" border="0" alt='<bean:message key="label.mutualacts.fromdb"/>'></july:wordedit>
<%--
				<html:link page="/CompletWorkAktWordDownload" paramId="idcwacode" paramName="it" paramProperty="idcwacode" paramScope="page">
					<img src="/images/getdbword.gif" border=0 alt='<bean:message key="label.mutualacts.fromdb"/>'>
				</html:link>
--%>
            </td>
			<%--td class="link" align="center">
				<html:link page="/CWA_Charges_Print.do?action=View" paramId="idcwacode" paramName="it" paramProperty="idcwacode" 
						onclick="window.open(this.href, 'pWindow', 'top=100, left=250, width=700, height=250, scrollbars=yes, resizable=yes, menubar=yes').focus(); return false;">
						<IMG SRC="/images/kontr.gif" BORDER=0 alt='Список начислений'>
				</html:link>
			</td--%>
			<td class="text">
				<logic:present name="it" property="dateRegistryDoc">
					<bean:write name="it" property="numRegistryDoc" filter="true" />
					от <july:datewrite name="it" property="dateRegistryDoc" />
				</logic:present>
			</td>			
			<td class="text">
				<logic:equal name="it" property="actstate" value="O">
				<A href='javascript:deleteItem("<bean:write name="it" property="docnumber" filter="true"/>", <bean:write name="it" property="idcwacode" filter="true"/>)' title="Удалить акт">
					<IMG SRC="/images/del.gif" BORDER='0' ALT='Удалить'>
				</A>
				</logic:equal>
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
						<%--html:link page="/EditCompletWorkAkt.do?action=Add" paramId="idContract" paramName="CompletWorkActsListForm" paramProperty="agreement.o.mainLeaseDocument">
							<IMG SRC="/images/plus.gif" BORDER='0' ALT='Добавить запись'>
						</html:link--%>
						<html:link page="/CompletWorkAktDialog.do?action=Add" paramId="idContract" paramName="CompletWorkActsListForm" paramProperty="agreement.o.mainLeaseDocument" onclick="return openDialog(this.href, 'CompletWorkAktDialog', 'top=150, left=470, width=550, height=350, scrollbars=yes, resizable=yes');">
							<IMG SRC="/images/plus.gif" BORDER='0' ALT='Добавление акта'>
						</html:link>						
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

</july:browseform>

<script language="javascript">
	loadSelectedRow();
	//window.location.hash=document.all.selectedID.value;
	stat=1;
</script>

