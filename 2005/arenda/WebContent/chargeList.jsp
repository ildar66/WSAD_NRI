<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.arenda.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import ="com.hps.july.jdbcpersistence.lib.*"%>
<%@ page import = "com.hps.july.arenda.formbean.*"%>

<%!private String isUp(String aSort, String name) {
	if (aSort.startsWith(name)) {
		if (aSort.endsWith("desc"))
			return ("<img src='/images/up.gif'  border='0' alt='по возрастанию'>");
		else
			return ("<img src='/images/down.gif'  border='0' alt='по убыванию'>");
	} else
		return ("");
}
%>

<% String gColSpan = "14";
	ChargeListForm listForm =
	(ChargeListForm) session.getAttribute("ChargeListForm");
	String sortBy = listForm.getSortBy();
%>

<%
	String action = "/ChargeList.do";
	String form = "ChargeListForm";
	String parent = "/ViewWeArenda.do";
	String edit = "/EditCharge.do";
	String parentCaption = null;
	String rate = "/ShowChargeRatesList.do";
	String dnop = "/ShowChargeDnopList.do";
	String factura = "/EditFactura.do?action=";
	String temp = null;
    //start counter:
    //TimeCounter counter = new TimeCounter("PERF.ARENDA.ShowChargesList");
    //counter.start();
%>


<july:editform action="<%= action %>" styleId="<%= form %>">


<script language="javascript">
function switchDate() {
	if (document.all.isDate[0].checked) {
		<%= form %>.fromDate_dt.enabled = false;
		<%= form %>.toDate_dt.enabled = false;
	} else {
		<%= form %>.fromDate_dt.enabled = true;
		<%= form %>.toDate_dt.enabled = true;
	}
}
function switchResource() {
	if (document.all.isResource[0].checked) {
		<%= form %>.resources.disabled = true;
		<%= form %>.resources.className = 'editdisabled';
	} else {
		<%= form %>.resources.disabled = false;
		<%= form %>.resources.className = 'editsearch';
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
function CloseAndUpdate()
	{
		if(window.opener) {
			//alert(window.opener.window.location.href);//temp
			//opener.location.reload(true);
			opener.location.href=opener.location.href;
			//var f = window.opener.window.document.forms;
			//alert(f(0).name);
			//f(0).submit();
			window.opener.focus();
		}
		window.close();
	}	
</script>

<html:hidden property="leaseContract"/>
<%--html:hidden property="sourceContract"/--%>
<html:hidden property="sortBy" />
<html:hidden property="selectedID" value="0" />

<table class="main" id="tableID" style="font-size: 8pt;">

	<july:separator colspan="<%= gColSpan %>"/>

	<TR class="normal">
		<TD colspan="<%= gColSpan %>">
			<table class="find" style="font-size: 8pt;">
				<tr>
					<td class="text">
						<A href='AgreementInfo.do?action=View&leaseDocument=<bean:write name="<%= form %>" property="leaseContract"/>' onclick='window.open(this.href, "AgreementInfo", "top=100, left=100, width=700, height=500, scrollbars=yes, resizable=yes").focus(); return false;' class='button'>
							<bean:message key="label.dhist.contractInfo"/>:
						</A>
					</td>				
					<td class="text">
						<bean:write name="<%= form %>" property="docNumber" filter="true" />
						&nbsp;от&nbsp;<july:datewrite name="<%= form %>" property="docDate"/>
					</td>
				</tr>			
				<tr>
					<td class="text"><bean:message key="label.filter.start"/>:</td>
					<td class="text">
						<table class="main" border="0" cellpadding="0" cellspacing="0" style="font-size: 8pt;">
							<tr>
								<td class="text">
									<july:checkbox property="isDate" insertable="true" updatable="true" onclick="switchDate()"/>
									<bean:message key="label.filter.all"/>
								</td>
								<td class="text"><july:date property="fromDateFrm" size="25" insertable="true" updatable="true" styleId="fromDate"/></td>
								<td class="text"><bean:message key="label.filter.stop"/>:</td>
								<td class="text"><july:date property="toDateFrm" size="25" insertable="true" updatable="true" styleId="toDate"/><july:searchbutton/></td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr class="title">
		<td colspan="<%= gColSpan %>">
			<table class="buttons">
				<tr class="title">
					<td class="buttons">
						<july:canedit rolesProperty="editRoles">
							<A
								href='ChargeDialog.do?action=Add&idContract=<bean:write name="ChargeListForm" property="mainLeaseContractKey" filter="true"/>'
								onclick='window.open(this.href, "ChargeDialog", "top=150, left=470, width=520, height=460, scrollbars=yes, resizable=yes").focus(); return false;'>
							<IMG SRC="/images/plus.gif" BORDER='0' ALT='Добавить запись'></A>
						</july:canedit> 
						&nbsp;<july:backbutton/>
					</td>
					<td>
						<A href='ChargeAutomaticDialog.do?action=Add&&condition=C&leaseDocumentcodeFrm=<bean:write name="ChargeListForm" property="mainLeaseContractKey" filter="true"/>'
							onclick='window.open(this.href, "ChargeAutomaticDialog", "top=150, left=470, width=400, height=200, scrollbars=yes, resizable=yes").focus(); return false;' class='button'>
							Автоматическое формирование</A>
					</td>
					<td align="right">отобрано записей:<%=request.getAttribute("numberOfLines")%></td>
				</tr>
			</table>
		</td>
	</tr>


	<july:separator colspan="<%= gColSpan %>"/>
	<!-- Table header -->
	<tr class="title">
		<td class="title">&nbsp;</td>
		<td class="title"><A title="Сортировать по полю 'Услуга'"
			href="javascript:SortBy('resName')">Услуга</A><%=isUp(sortBy, "resName")%></td>
		<td class="title" colspan="2"><A title="Сортировать по полю 'Сумма начисления'"
			href="javascript:SortBy('summ')">Сумма</A><%=isUp(sortBy, "summ")%></td>
		<td class="title"><A title="Сортировать по полю 'Валюта'"
			href="javascript:SortBy('curName')">Валюта</A><%=isUp(sortBy, "curName")%></td>		
		<td class="title"><A title="Сортировать по полю 'Дата начала'"
			href="javascript:SortBy('beginDate')">Дата начала</A><%=isUp(sortBy, "beginDate")%></td>		
		<td class="title"><A title="Сортировать по полю 'Дата окончания'"
			href="javascript:SortBy('endDate')">Дата окон.</A><%=isUp(sortBy, "endDate")%></td>		
		<td class="title"><A title="Сортировать по полю 'Номер счета'"
			href="javascript:SortBy('billNumber')">Номер счета</A><%=isUp(sortBy, "billNumber")%></td>
		<td class="title" title="Вызов списка платежей(Чем оплачено начисление?)" align="center">!</td>					
		<td class="title" title="Признак учета в акте взаимозачета/сверки" align="center">!</td>
		<td class="title" title="Курсы зачета" align="center">!</td>
		<td class="title" title="Признак состояния СФ" style="text-align: center;"><B>СФ</B></td>
		<td class="title" title="Признак состояния АВ" style="text-align: center;"><B>АВ</B></td>
		<td class="title" title="Удаление начисления" align="center">!</td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>

	<!-- Table body -->
	<logic:iterate id="it" name="ChargeListForm" property="chargesList" type="com.hps.july.valueobject.LeaseCharge_TO">
		<logic:present name="it">
		<%
			com.hps.july.valueobject.LeaseCharge_TO to =(com.hps.july.valueobject.LeaseCharge_TO)it;
			//счета-фактуры:
			int flagSF = to.getVo().getFlagSF().intValue();
			String colorFlagSF = "";//flagSF == 3
			String hintSF = "";
			if(flagSF == 0 ){
				colorFlagSF="style='background-color:#CC6666'";//background-color
				hintSF = "Не на всю сумму сделаны СФ, остаток СФ = ";
			}else if(flagSF == 1){
				colorFlagSF="style='background-color:#FFFF00'";
				hintSF = "СФ не Получены от арендодателя";
			}else if(flagSF == 2){
				colorFlagSF="style='background-color:#99CC99'";
				hintSF = "СФ получены от арендодателя, но не приняты в бухгалтерии";
			}else if(flagSF == 3){
				colorFlagSF="";
				hintSF = "СФ принята в бухгалтерии";				
			}else if(flagSF == 10){
				colorFlagSF="style='background-color:#ACAABB'";
				hintSF = "СФ по старому учету";
			}else if(flagSF == 4){
				colorFlagSF="";
				hintSF = "СФ не нужны";
			}	
			//акты выполненных работ:
			int flagCwAct = to.getVo().getFlagCwAct().intValue();
			String colorFlagCwAct = "";//flagCwAct == 3
			String hintCwAct = "";
			if(flagCwAct == 0 ){
				colorFlagCwAct="style='background-color:#CC6666'";//background-color
				hintCwAct = "Не на всю сумму сделаны АВР, остаток АВР = ";
			}else if(flagCwAct == 1){
				colorFlagCwAct="style='background-color:#FFFF00'";
				hintCwAct = "АВР не Получены от арендодателя";
			}else if(flagCwAct == 2){
				colorFlagCwAct="style='background-color:#99CC99'";
				hintCwAct = "АВР получены от арендодателя, но не приняты в бухгалтерии";
			}else if(flagCwAct == 3){
				colorFlagCwAct="";
				hintCwAct = "АВР принята в бухгалтерии";				
			}else if(flagCwAct == 10){
				colorFlagCwAct="style='background-color:#ACAABB'";
				hintCwAct = "АВР по старому учету";
			}else if(flagCwAct == 4){
				colorFlagCwAct="";
				hintCwAct = "АВ не нужны";
			}					
		%>		
			<tr
				id='<bean:write name="it" property="vo.leaseDocPosition" filter="true"/>'
				class="normal" style="font-size: 8pt;"
				onMouseOver="className='select'"
				onMouseOut="onMouseOutRow(this.id);" onclick='onClickRow(this.id);'>
				<td class="link">
					<july:canedit rolesProperty="editRoles">
						<A href='ChargeDialog.do?action=Edit&id=<bean:write name="it" property="vo.leaseDocPosition" filter="true"/>'
							onclick='window.open(this.href, "ChargeDialog", "top=150, left=470, width=520, height=460, scrollbars=yes, resizable=yes").focus(); return false;'>
						<IMG SRC="/images/izmena.gif" BORDER='0' ALT='Изменить запись'></A>
					</july:canedit></td>
				<td class="text"><bean:write name="it" property="resName" filter="true"/></td>
				<td class="number">
					<logic:equal name="it" property="vo.source" value="M"><IMG SRC="/images/infohint.gif" BORDER=0 ALT='<bean:message key="label.charges.byhand"/>'></logic:equal></td>				
				<td class="number" align="right" style="border-width: ">
					<july:sumwrite name="it" property="vo.summ"/></td>				
				<td class="text">
				<logic:present name="it" property="vo.currency"><bean:write name="it" property="curName" filter="true"/></logic:present></td>				
				<td class="text">
					<july:datewrite name="it" property="vo.beginDate"/></td>
				<td class="text">
					<july:datewrite name="it" property="vo.endDate"/></td>				
				<td class="text">
					<bean:write name="it" property="vo.billNumber" filter="true"/></td>
				<td class="text" style="text-align: center;">
					<!-- Вызов списка платежей(Чем оплачено начисление?)-->
					<A href='DnopForChargeList.do?leaseCharge=<bean:write name="it" property="vo.leaseDocPosition"/>'>
						<img src='/images/dochist.gif' border=0 alt='Чем оплачено начисление?'>
					</A></td>
				<td class="text" style="text-align: center;">
					<logic:present name="it" property="vo.usedInAct"><img src='/images/setrow.gif' border=0 alt='Признак учета в Акте'></logic:present></td>				
				<td class="link" style="text-align: center;">
					<!-- Вызов списка курса (диалога)-->
					<A href='EditRateList.do?action=Edit&docpositioncode=<bean:write name="it" property="vo.leaseDocPosition"/>' onclick='window.open(this.href, "rateListDialog", "top=100, left=100, width=600, height=250, scrollbars=yes, resizable=yes").focus(); return false;'>
						<img src='/images/rateicon.gif' border=0 alt='<bean:message key="label.leasecalcrate.short"/>'>
					</A></td>
				<td class="text" <%=colorFlagSF %> title="<%=hintSF%> (ост:<july:sumwrite name="it" property="vo.ostSumForSF"/>)" style="text-align: center;">
					<A href="SchetFactForChargeList.do?chargeCode=<bean:write name="it" property="vo.leaseDocPosition"/>" style="text-decoration: none; text-align: center;">СФ</A></td>									
				<td class="text" <%=colorFlagCwAct %> title="<%=hintCwAct%> (ост:<july:sumwrite name="it" property="vo.ostSumForCwAct"/>)" style="text-align: center;">
					<A href='CompletWorkActsForChargeList.do?chargeCode=<bean:write name="it" property="vo.leaseDocPosition"/>' style="text-decoration: none; text-align: center;">АВ</A></td>					
				<td class="link" style="text-align: center;">
					<july:canedit rolesProperty="editRoles">
						<A	href='ChargeDialog.do?action=Delete&id=<bean:write name="it" property="vo.leaseDocPosition" filter="true"/>'
							onclick='window.open(this.href, "ChargeDialog", "top=150, left=470, width=520, height=460, scrollbars=yes, resizable=yes").focus(); return false;'>
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
								href='ChargeDialog.do?action=Add&idContract=<bean:write name="ChargeListForm" property="mainLeaseContractKey" filter="true"/>'
								onclick='window.open(this.href, "ChargeDialog", "top=150, left=470, width=520, height=460, scrollbars=yes, resizable=yes").focus(); return false;'>
							<IMG SRC="/images/plus.gif" BORDER='0' ALT='Добавить запись'></A>
						</july:canedit> 
						&nbsp;<july:backbutton/>
					</td>
					<td>
						<A
							href='ChargeAutomaticDialog.do?action=Add&&condition=C&leaseDocumentcodeFrm=<bean:write name="ChargeListForm" property="mainLeaseContractKey" filter="true"/>'
							onclick='window.open(this.href, "ChargeAutomaticDialog", "top=150, left=470, width=400, height=200, scrollbars=yes, resizable=yes").focus(); return false;' class='button'>
							Автоматическое формирование</A>
						
					</td>
					<td align="right">отобрано записей:<%=request.getAttribute("numberOfLines")%></td>
				</tr>
			</table>
		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>

</table>


<script language="javascript">
	switchDate();
	//switchResource();
</script>


</july:editform>
<script language="javascript">
	loadSelectedRow();
	//window.location.hash=document.all.selectedID.value;
	stat = 1;
</script>
<%
    //counter end
	//counter.finish("jsp");
%>
