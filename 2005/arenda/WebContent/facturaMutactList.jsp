<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*, com.hps.july.arenda.*, com.hps.july.arenda.valueobject.*" %>
<%@ page import="com.hps.july.util.AppUtils" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% String gColSpan = "11"; %>

<%
    String action = null;
	String form = null;
	String parent = null;
	String parent2 = null;
	String parent3 = null;
	String edit = null;
	String pos = null;
	String temp = null;
	switch (ParamsParser.getState(pageContext)) {
		case APPStates.FACTURA_MUTACT_LIST:
			action = "/ShowFacturaMutactList.do";
			form = "FacturaMutactList";
			parent2 = "/ShowMutualReglamentsList.do";
			parent3 = "/ShowMutualActsList.do";
			edit = "/EditFacturaMutact.do";
			pos = "/ShowFacturaPosMutactList.do";
			break;
		case APPStates.FROMCONTRACT_FACTURA_MUTACT_LIST:
			action = "/ShowFromContractFacturaMutactList.do";
			form = "FromContractFacturaMutactList";
			parent = "/ViewWeArenda.do";
			parent2 = "/ShowFromContractMutualReglamentsList.do";
			parent3 = "/ShowFromContractMutualActsList.do";
			edit = "/EditFromContractFacturaMutact.do";
			pos = "/ShowFromContractFacturaPosMutactList.do";
			break;
		case APPStates.FROMHISTORY_FACTURA_MUTACT_LIST:
			action = "/ShowFromHistoryFacturaMutactList.do";
			form = "FromHistoryFacturaMutactList";
			parent = "/ViewHistory.do";
			parent2 = "/ShowFromHistoryMutualReglamentsList.do";
			parent3 = "/ShowFromHistoryMutualActsList.do";
			edit = "/EditFromHistoryFacturaMutact.do";
			pos = "/ShowFromHistoryFacturaPosMutactList.do";
			break;
	}
%>

<july:browseform action="<%= action %>" styleId="<%= form %>">

<html:hidden property="isAutoProcError"/>

<html:hidden property="leaseDocument"/>

<html:hidden property="selectedID" value="0"/>
<html:hidden property="sortBy" />
<html:hidden property="operation" value="" />
<html:hidden property="idCode" value="-1" />
<html:hidden property="toState" value="" />

<logic:equal name="<%= form %>" property="isAutoProcError" value="true">
	&nbsp;<br>&nbsp;<br>
	&nbsp;<font class="attention">Error:&nbsp;<bean:write name="<%= form %>" property="messageError" filter="true"/></font><br>
	&nbsp;<br>&nbsp;<br>
</logic:equal>

<script language="javascript">
function switchSearch() {
	if (document.all.isSearch[0].checked) {
		document.all.sst.disabled = true;
		document.all.ssa.disabled = true;
	} else {
		document.all.sst.disabled = false;
		document.all.ssa.disabled = false;
	}
}
function showFacture(code){
	window.location.href='/arenda/SchetFactWordAction.do?type='+document.all.type.value+'&code='+code;
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
	document.cookie =<%= form %>.name+"=" + selectedID;
}
function loadSelectedRow() {
	var cookies = document.cookie;
	//считываем selectedID:
	var startLoc = cookies.indexOf(<%= form %>.name+"=");
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
function SortBy(field) 
{
	var e = document.all.sortBy;
	e.value = (e.value == field)?field + ' desc':field;
    document.body.style.cursor="wait";
	<%= form %>.submit();
	return false;
}
function changeDocument(){
}
function changeState(toState){
	document.body.style.cursor="wait";
	document.all.operation.value="changeState";
	document.all.toState.value=toState;
	document.all.idCode.value=document.all.selectedID.value;
	//alert("idCode=" + document.all.idCode.value + " toState=" + toState);
	<%= form %>.submit();
	return false;
}
function AddSF(){
	if(confirm('Создать счет-фактуру по договору: ' + <%= form %>.idContractcode.options(<%= form %>.idContractcode.selectedIndex).text + ' ?')) {
		window.open("SchetFactDialog.do?action=Add&idAkt=<bean:write name="<%= form %>" property="leaseDocument" filter="true"/>&idContract=" + <%= form %>.idContractcode.value, "SchetFactDialog", "top=150, left=470, width=520, height=350, scrollbars=yes, resizable=yes").focus();
	}
}
function createSF(){
	var calcTypeStr = <%= form %>.calcType.value;
	if(<%= form %>.calcType[0].checked){
		calcTypeStr = "Трафик";
	}else if(<%= form %>.calcType[1].checked){
		calcTypeStr = "Аренда";
	}else{
	 	alert("Выберите трафик или аренда");
	 	return false;
	}
	if(confirm('Сформировать счет-фактуру по ' + calcTypeStr)){
		return true;
	}else{
		return false;
	}

}
function getTypeSF(typeSF){
	var typeSFdefault = document.all.type.value;
	if(typeSFdefault == 'D')
		return typeSF;
	else
		return typeSFdefault;
}
</script>

<table class="main" id="tableID">
	<july:separator colspan="<%= gColSpan %>"/>
<%--
	<tr class="title">
		<td colspan="<%= gColSpan %>" class="title">Фильтр</td>
	</tr>
--%>
	<tr class="normal">
		<td colspan="<%= gColSpan %>">
			<table class="find" width="100%">
			<tr>
				<td class="text"><bean:message key="label.factura.act.number"/>:</td>
				<td class="text">
					<bean:write name="<%= form %>" property="documentNumber" filter="true"/>&nbsp;
					<bean:message key="label.filter.ot"/>&nbsp;
					<july:datewrite name="<%= form %>" property="documentDate"/>
				</td>
				<td class="text" rowspan="3" width="15%" align="center" valign="center">
					<july:searchbutton/>
				</td>
			</tr>
			<tr>
				<td class="text" colspan="2">
					<logic:equal name="<%= form %>" property="acttype" value="A"><bean:message key="label.mutualreglmnts.acttype.vz"/></logic:equal>
					<logic:equal name="<%= form %>" property="acttype" value="M"><bean:message key="label.mutualreglmnts.acttype.vt"/></logic:equal>
					<logic:equal name="<%= form %>" property="acttype" value="S"><bean:message key="label.mutualreglmnts.acttype.sv"/></logic:equal>
					<bean:message key="label.filter.periodfrom"/> <july:datewrite name="<%= form %>" property="actstartdate"/> <bean:message key="label.filter.stop"/> <july:datewrite name="<%= form %>" property="actenddate"/>
				</td>
			</tr>
			<tr>
				<td class="text">&nbsp;</td>
				<td class="text">
					<july:checkbox property="isSearch" insertable="true" updatable="true" onclick="switchSearch()"/>
					<bean:message key="label.filter.all"/>
			   		<july:radio property="searchState" insertable="true" updatable="true" value="1" styleId="sst"/><bean:message key="label.factura.act.traffic"/>
					<july:radio property="searchState" insertable="true" updatable="true" value="2" styleId="ssa"/><bean:message key="label.factura.act.arenda"/>
				</td>
			</tr>
			</table>
			<script language="javascript">
				switchSearch();
			</script>
		</td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>
<%--
	<tr class="title">
		<td colspan="<%= gColSpan %>" class="title">Автоматические операции</td>
	</tr>
--%>
<july:canedit rolesProperty="editRoles">
	<tr class="normal">
		<td colspan="<%= gColSpan %>">
			<table class="main" width="100%">
<%
	int makeSF = AppUtils.getNamedValueInt("MakeSchetFaktRule");
	if(makeSF == 1) {
%>
			<tr>
				<td class="title"><bean:message key="label.factura.act.traffic"/>:</td>
				<td class="text">
			   		<july:radio property="calcType" insertable="true" updatable="true" value="11"/>Одна счёт-фактура
			   		<july:radio property="calcType" insertable="true" updatable="true" value="12"/>Отдельная счёт-фактура за каждый период
				</td>
				<td class="text" width="15%" align="center" valign="center" rowspan="2">
					<input type='image' name='autoProc' hspace=3 vspace=0 src='/images/obchet1.gif' alt='<bean:message key="label.factura.auto"/>'>
					<input type='image' name='autoDelete' hspace=3 vspace=0 src='/images/del.gif' alt='<bean:message key="label.factura.autodelete"/>'>
				</td>
			</tr>
			<tr>
				<td class="title"><bean:message key="label.factura.act.arenda"/>:</td>
				<td class="text">
			   		<july:radio property="calcType" insertable="true" updatable="true" value="21"/>Одна счёт-фактура
				</td>
			</tr>
<%	} else { %>
			<tr>
				<td class="title">
			   		<july:radio property="calcType" insertable="true" updatable="true" value="13"/><bean:message key="label.factura.act.traffic"/>
			   		<july:radio property="calcType" insertable="true" updatable="true" value="23"/><bean:message key="label.factura.act.arenda"/>
				</td>
				<td class="text" width="15%" align="middle" valign="center">
					<input type='image' name='autoProc' hspace=3 vspace=0 src='/images/obchet1.gif' alt='<bean:message key="label.factura.auto"/>' onclick="return createSF()">
					<%--input type='image' name='autoDelete' hspace=3 vspace=0 src='/images/del.gif' alt='<bean:message key="label.factura.autodelete"/>'--%>
				</td>
			</tr>
<%	} %>
			</table>
		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>
	</july:canedit>

	<tr class="normal">
		<td class="title" colspan="<%= gColSpan %>">
			Вид счет-фактуры для печати:&nbsp;
			<html:select property="type">
				<html:option value="C">счет-фактура от 30.05.2006</html:option>
				<html:option value="A">счет-фактура от 16.02.2004</html:option>
				<html:option value="B">счет-фактура от 15.03.2001</html:option>
				<html:option value="D">Определять по дате</html:option>
			</html:select>
		</td>
	</tr>
	
	<tr class="title">
		<td colspan="<%= gColSpan %>">
			<table class="buttons">
				<tr class="title">
					<td class="buttons">
						<july:backbutton />
						<july:canedit rolesProperty="editRoles">
							Добавить с.ф.по:
							<july:select styleId="documents" collection="documents" property="idContractcode" insertable="true" updatable="false" onchange="changeDocument();">
								<html:options collection="documents" property="leaseDocument" labelProperty="value"/>
							</july:select>&nbsp;&nbsp;
<%--							
							<A href='SchetFactDialog.do?action=Add&idAkt=<bean:write name="<%= form %>" property="leaseDocument" filter="true"/>'
								onclick='window.open(this.href + "&idContract=" + idContractcode.value, "SchetFactDialog", "top=150, left=470, width=520, height=350, scrollbars=yes, resizable=yes").focus(); return false;'>
							<IMG SRC="/images/plus.gif" BORDER='0' ALT='Добавить запись'></A>
--%>							
							<A href='javascript:AddSF()' title="Добавить с.ф.">
								<IMG SRC="/images/plus.gif" BORDER='0' ALT='Добавить с.ф.'>
							</A>							
						</july:canedit>
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
		<td class="title">
			<A title="Сортировать по полю 'Номер СФ'"
				href="javascript:SortBy('numberSchetFakt')">Номер с.ф.</A>
		</td>
		<td class="title">
			<A title="Сортировать по полю 'Дата с.ф.'"
				href="javascript:SortBy('dateSchetFakt')">Дата с.ф.</A>
		</td>
		<td class="title">
			<A title="Сортировать по полю 'Дата договора'"
				href="javascript:SortBy('docdate')">Дата дог.</A>
		</td>
		<td class="title">
			<A title="Сортировать по полю 'Номер договора'"
				href="javascript:SortBy('docNumber')">Номер дог.</A>
		</td>
		<td class="title">
			<A title="Сортировать по полю 'Продавец'"
				href="javascript:SortBy('nameOrg')">Продавец</A>
		</td>
		<td colspan="2" align="center" class="title">
			<A title="Сортировать по полю 'Сумма/НДС с.ф.'"
				href="javascript:SortBy('sumSf')">Сумма/НДС с.ф.</A>
		</td>
		<td class="title">&nbsp;</td>
<%--<td class="title">&nbsp;</td>--%>
		<td class="title">&nbsp;</td>
		<td class="title">&nbsp;</td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>

	<!-- Table body -->
	<logic:iterate id="it" name="browseList"  indexId="indexId">
		<logic:present name="it">
			<tr id='<bean:write name="it" property="vo.idSchetFakt" filter="true"/>'  class="normal" onMouseOver="className='select'" onMouseOut="onMouseOutRow(this.id);" onclick="onClickRow(this.id);">
				<td class="link">
					<%String actionSF = "View";%>
					<july:canedit rolesProperty="editRoles">
					<logic:equal name="it" property="vo.state" value="O">
						<%actionSF = "Edit";%>
					</logic:equal>
					</july:canedit>
						<A href='SchetFactDialog.do?action=<%= actionSF%>&id=<bean:write name="it" property="vo.idSchetFakt" filter="true"/>'
							onclick='window.open(this.href, "SchetFactDialog", "top=150, left=470, width=520, height=350, scrollbars=yes, resizable=yes").focus(); return false;'>
						<IMG SRC="/images/izmena.gif" BORDER='0' ALT='Изменить запись'></A>
				</td>
				
				<td class="text">
					<bean:write name="it" property="vo.numberSchetFakt" filter="true" />
				</td>
				
				<td class="text">
					<july:datewrite name="it" property="vo.dateSchetFakt" />
				</td>				
				
 				<td class="date">
					<july:datewrite name="it" property="docDate"/>
				</td>
				
 				<td class="text">
					<bean:write name="it" property="docNumber" filter="true"/>
				</td>
				
				<td class="text">
					<bean:write name="it" property="nameOrg" filter="true"/>
				</td>
				
				<td class="number" align="right">
					<july:sumwrite name="it" property="sumSf"/> 
				</td>
				
				<td class="number" align="right">
					<july:sumwrite name="it" property="ndsSf"/>					
				</td>
				<td class="text">			
					<html:select name ="it" property="vo.state" styleId="state" onchange='changeState(this.value);'>
						<html:option value="O">редактируется</html:option>
						<html:option value="R">рассчитан</html:option>
						<html:option value="1">получена от аренд.</html:option>
						<html:option value="2">передана в бух.</html:option>
						<html:option value="3">принята бух.</html:option>
					</html:select>
				</td>				
<%--				
 				<td class="link" align="center">
					<html:link page="/../crystalclear/SchetFaktHeader.rpt?dll=pdsschetfact.dll" paramId="prompt0" paramName="it" paramProperty="o.idSchetFakt" paramScope="page" onclick="window.open(this.href, 'ab', 'top=100, left=100, width=700, height=500, scrollbars=yes, resizable=yes'); return false;">
						<img src="/images/print.gif" border=0 alt="<bean:message key="label.mutualacts.print.sf"/>">
					</html:link>
                </td>
--%>
 				<td class="link" align="center">
<%-- 				
					<A href='javascript:showFacture(<bean:write name="it" property="o.idSchetFakt" filter="true"/>)'>
						<img src="/images/docword.gif" border=0 alt='<bean:message key="label.mutualacts.print.sf"/>'>
					</A>
--%>
					<%
						String idStr = "" + ((LeaseSchetFact_TO) it).getVo().getIdSchetFakt();
						String typeSF = ((LeaseSchetFact_TO) it).getTypeSF();
					%>					
						<%--logic:notEqual name="it" property="o.state" value="O"--%>
						<% String beforeclick = "wrded1_" + idStr + "_addtourl('&type=' + getTypeSF('"+typeSF+"'));";  %>
						<july:wordedit styleId='<%= "wrded1_" + idStr %>' url='<%= "SchetFactWordAction.do?code=" + idStr%>' 
									uploadurl="SchetFactWordUploadAction.do" documentid="<%= idStr %>"
									beforeclick="<%= beforeclick %>">
									<IMG SRC="/images/docword.gif" border="0" alt='<bean:message key="label.mutaulacts.createword"/>'></july:wordedit>
						<%--/logic:notEqual--%>
				
						<july:wordedit styleId='<%= "wrded2_" + idStr %>' url='<%= "SchetFactWordDownload?code=" + idStr %>'
							uploadurl="SchetFactWordUploadAction.do" documentid="<%= idStr %>">
							<IMG SRC="/images/getdbword.gif" border="0" alt='<bean:message key="label.mutualacts.fromdb"/>'></july:wordedit>					
                </td>
				
				<td class="link">
					<july:canedit rolesProperty="editRoles">
						<logic:equal name="it" property="vo.state" value="O">
							 <A href='SchetFactDialog.do?action=Delete&id=<bean:write name="it" property="vo.idSchetFakt" filter="true"/>'
								onclick='window.open(this.href, "SchetFactDialog", "top=150, left=430, width=520, height=350, scrollbars=yes, resizable=yes").focus(); return false;'>
							    <img src="/images/del.gif" border="0" alt='Удалить запись'> </A>
						</logic:equal>
					</july:canedit>
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
<%--					
						<july:canedit rolesProperty="editRoles">
							<A href='SchetFactDialog.do?action=Add&idAkt=<bean:write name="<%= form %>" property="leaseDocument" filter="true"/>'
								onclick='window.open(this.href, "SchetFactDialog", "top=150, left=470, width=520, height=350, scrollbars=yes, resizable=yes").focus(); return false;'>
							<IMG SRC="/images/plus.gif" BORDER='0' ALT='Добавить запись'></A>
						</july:canedit>
--%>						
						<july:backbutton />
					</td>
					<td class="navigator"><july:navigator/></td>
				</tr>
			</table>
		</td>
	</tr>
		
	<july:separator colspan="<%= gColSpan %>"/>
	
</table>

<script language="javascript">
	loadSelectedRow();
	//window.location.hash=document.all.selectedID.value;
</script>

</july:browseform>
