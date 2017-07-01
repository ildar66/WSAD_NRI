<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ page import = "com.hps.july.web.util.*,com.hps.july.arenda.*" %>
<%@ page import = "com.hps.july.arenda.formbean.*"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %> 

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

<% 
	String gColSpan = "9";
	AbonentSaldoDetailListForm listForm =
	(AbonentSaldoDetailListForm) session.getAttribute("AbonentSaldoDetailListForm");
	String sortBy = listForm.getSortBy();
%>
<%
    String action = "/AbonentSaldoDetailList.do";
	String form = "AbonentSaldoDetailListForm";
	String propertyDialog = "top=150, left=450, width=480, height=480, scrollbars=yes, resizable=yes";
%>
<july:browseform action="<%= action %>" styleId="<%= form %>">
<html:hidden property="idContract"/>
<html:hidden property="sortBy" />
<html:hidden property="selectedID" value="0" />

<script language="javascript">
function SortBy(field){
	var e = document.all.sortBy;
	e.value = (e.value == field)?field + ' desc':field;
    document.body.style.cursor="wait";
	<%= form %>.submit();
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
	document.cookie = <%= form %>.name+"=" + selectedID;
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
</script>

<table class="main" id="tableID" style="font-size: 9pt">

	<july:separator colspan="<%= gColSpan %>"/>

	<TR class="normal">
		<TD colspan="<%= gColSpan %>">
			<table class="find">
				<tr>
					<td class="text">
						<A href='AbonentInfo.do?action=View&leaseDocument=<bean:write name="<%= form %>" property="idContract"/>' onclick='return openDialog(this.href, "AgreementInfo", "top=300, left=300, width=500, height=370, scrollbars=yes, resizable=yes");' class='button'>
							<bean:message key="label.dhist.contractInfo"/>:
						</A>
					</td>				
					<td class="text">
						<bean:write name="<%= form %>" property="docNumber" filter="true" />
						&nbsp;от&nbsp;<july:datewrite name="<%= form %>" property="docDate"/>
					</td>
					<td class="text" rowspan="3" width="15%" align="center" valign="middle">
						<july:searchbutton/>
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
						<july:canedit rolesProperty="editRoles">
							<A
								href='AbonentSaldoDetailDialog.do?action=Add&idContract=<bean:write name="AbonentSaldoDetailListForm" property="idContract" filter="true"/>'
								onclick='return openDialog(this.href, "AbonentSaldoDetailDialog", "<%= propertyDialog%>");'>
							<IMG SRC="/images/plus.gif" BORDER='0' ALT='Добавить запись'></A>
						</july:canedit>
						<july:backbutton/>
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
		<td class="title"><A title="Сортировать по полю 'Дата'"
			href="javascript:SortBy('salDate')">Дата</A><%=isUp(sortBy, "salDate")%>
		</td>
		<td class="title"><A title="Сортировать по полю 'Наименование услуги'"
			href="javascript:SortBy('resourceName')">Услуга</A><%=isUp(sortBy, "resourceName")%>
		</td>
		<td class="title"><A title="Сортировать по полю 'Сумма в основной валюте'"
			href="javascript:SortBy('mainSum')">Сумма в осн. валюте</A><%=isUp(sortBy, "mainSum")%>
		</td>
		<td class="title"><A title="Сортировать по полю 'Сумма в дополнительной валюте'"
			href="javascript:SortBy('additionalSum')">Сумма в доп. валюте</A><%=isUp(sortBy, "additionalSum")%>
		</td>
		<td class="title" align="center"><A title="Сортировать по полю 'Cальдо изменено вручную'"
			href="javascript:SortBy('saldoByHand')"><B> ! </B></A><%=isUp(sortBy, "saldoByHand")%>
		</td>
		<td class="title"><A title="Сортировать по полю 'Ставка НДС'"
			href="javascript:SortBy('rateNds')">Ставка НДС</A><%=isUp(sortBy, "rateNds")%>
		</td>
		<td class="title" align="center"><A title="Сортировать по полю 'Причина изменения сальдо'"
			href="javascript:SortBy('notes')"><B> ! </B></A><%=isUp(sortBy, "notes")%>
		</td>											
		<td class="title">&nbsp;</td>
	</tr>


	<july:separator colspan="<%= gColSpan %>"/>


	<!-- Table body -->
	<logic:iterate id="it" name="browseList">
		<logic:present name="it">
			<tr id='<bean:write name="it" property="vo.idSldDetail" filter="true"/>' class="normal" onMouseOver="className='select'" onMouseOut="onMouseOutRow(this.id);" onclick='onClickRow(this.id);'>
				<td class="link">
					<july:canedit rolesProperty="editRoles">
						<A href='AbonentSaldoDetailDialog.do?action=Edit&id=<bean:write name="it" property="vo.idSldDetail" filter="true"/>'
							onclick='return openDialog(this.href, "AbonentSaldoDetailDialog", "<%= propertyDialog%>");'>
							<IMG SRC="/images/izmena.gif" BORDER='0' ALT='Изменить запись'></A>
					</july:canedit>
				</td>
				<td class="text">
					<july:datewrite name="it" property="vo.salDate"/>
				</td>
				<td class="text">
					<bean:write name="it" property="resourceName" filter="true"/>
					<logic:present name="it" property="vo.groupRec">
						<logic:equal name="it" property="vo.groupRec" value="1">(НДС по акту)</logic:equal>
					</logic:present>					
				</td>
				<td class="number" align="right">
					<%--bean:write name="it" property="vo.mainSum" filter="true"/--%>
					<july:sumwrite name="it" property="vo.mainSum"/>&nbsp;<bean:write name="it" property="mainCurrencyName" filter="true"/>
				</td>
				<td class="number" align="right">
					<%--bean:write name="it" property="vo.additionalSum" filter="true"/--%>
					<july:sumwrite name="it" property="vo.additionalSum"/>&nbsp;<bean:write name="it" property="additionalCurrencyName" filter="true"/>
				</td>
				<td class="text" align="center">
					<logic:present name="it" property="vo.saldoByHand">
						<logic:equal name="it" property="vo.saldoByHand" value="Y">
							<IMG SRC="/images/setrow.gif" BORDER='0' ALT='Cальдо изменено вручную'>
						</logic:equal>
					</logic:present>
				</td>
				<td class="number" align="right">
					<july:sumwrite name="it" property="vo.rateNds"/>
				</td>
				<td class="text" align="center" title='<bean:write name="it" property="vo.notes" filter="true"/>'>
					<IMG SRC="/images/infohint.gif" BORDER='0'>					
				</td>								
				<td class="link">
					<july:canedit rolesProperty="editRoles">
						<A href='AbonentSaldoDetailDialog.do?action=Delete&id=<bean:write name="it" property="vo.idSldDetail" filter="true"/>'
							onclick='return openDialog(this.href, "AbonentSaldoDetailDialog", "<%= propertyDialog%>");'>
							<IMG SRC="/images/del.gif" BORDER='0' ALT='Удалить запись'></A>
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
						<july:canedit rolesProperty="editRoles">
							<A
								href='AbonentSaldoDetailDialog.do?action=Add&idContract=<bean:write name="AbonentSaldoDetailListForm" property="idContract" filter="true"/>'
								onclick='return openDialog(this.href, "AbonentSaldoDetailDialog", "<%= propertyDialog%>");'>
							<IMG SRC="/images/plus.gif" BORDER='0' ALT='Добавить запись'></A>
						</july:canedit>
						<july:backbutton/>
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
</script>
</july:browseform>

