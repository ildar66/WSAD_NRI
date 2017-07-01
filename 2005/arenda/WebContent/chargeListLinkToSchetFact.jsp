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
			return (" <img src='/images/up.gif'  border='0' alt='по возрастанию'> ");
		else
			return (" <img src='/images/down.gif'  border='0' alt='по убыванию'> ");
	} else
		return ("");
}
%>

<% 
	String gColSpan = "15";
	ChargeListLinkToSchetFactForm listForm = (ChargeListLinkToSchetFactForm) request.getAttribute("ChargeListLinkToSchetFactForm");
	String sortBy = listForm.getSortBy();

	String action = "/ChargeListLinkToSchetFact.do";
	String form = "ChargeListLinkToSchetFactForm";
    //start counter:
    //TimeCounter counter = new TimeCounter("PERF.ARENDA.ChargeListLinkToSchetFactForm");
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
function CloseOld()
{
	if(window.opener) {
		//opener.storeSelectedRow(document.all.id.value);
		//opener.location.reload(true);
		window.opener.window.document.forms(0).operation.value="addLeaseSF2charges";
		window.opener.window.document.forms(0).submit();
		//window.opener.window.location.href=window.opener.window.location.href;
		//window.opener.focus();
	}
	window.close();
}
function Close()
{
  window.location.href="/arenda/SchetFactProcess.do?operation=addLeaseSF2charges";
}
function SetPosition(){
	<%= form %>.submit();
	return false;
}	
</script>

<html:hidden property="leaseContract"/>
<html:hidden property="sortBy" />
<html:hidden property="selectedID" value="0" />

<table class="main" id="tableID">

	<july:separator colspan="<%= gColSpan %>"/>

	<TR class="normal">
		<TD colspan="<%= gColSpan %>">
			<table class="find">

				<tr>
					<td class="text"><bean:message key="label.filter.start"/>:</td>
					<td class="text">
						<table class="main" border="0" cellpadding="0" cellspacing="0">
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
						&nbsp;<a href="#" title="Назад"><IMG SRC="/images/cancel.gif" BORDER='0' ALT='Назад' onclick="history.back();"></a>						
					</td>
					<td>
						<A href="javascript:SetPosition()" class='button'>
							Добавить начисление к счету-фактуре</A>
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
		<%--july:headercolumn key="label.charges.resource" colType="string"/--%>
		<td class="title" nowrap><A title="Сортировать по полю 'Услуга'"
			href="javascript:SortBy('resname')">Услуга</A><%=isUp(sortBy, "resname")%>
		</td>
		<%--july:headercolumn key="label.charges.sum" colspan="2" colType="string"/--%>		
		<td class="title" nowrap colspan="2"><A title="Сортировать по полю 'Сумма начисления'"
			href="javascript:SortBy('summ')">Сумма</A><%=isUp(sortBy, "summ")%>
		</td>
		<%--july:headercolumn key="label.charges.currency" colType="string"/--%>						
		<td class="title" nowrap><A title="Сортировать по полю 'Валюта'"
			href="javascript:SortBy('curname')">Валюта</A><%=isUp(sortBy, "curname")%>
		</td>		
		<%--<july:headercolumn key="label.charges.remaindersum" colType="string"/>--%>
		<%--july:headercolumn key="label.charges.begindate" colType="string"/--%>
		<td class="title" nowrap><A title="Сортировать по полю 'Дата начала'"
			href="javascript:SortBy('begindate')">Дата<BR>начала</A><%=isUp(sortBy, "begindate")%>
		</td>		
		<%--july:headercolumn key="label.charges.enddate" colType="string"/--%>
		<td class="title" nowrap><A title="Сортировать по полю 'Дата окончания'"
			href="javascript:SortBy('enddate')">Дата<BR>окончания</A><%=isUp(sortBy, "enddate")%>
		</td>		
		<%--july:headercolumn key="label.charges.accountnumber" colType="string"/--%>
		<td class="title" nowrap><A title="Сортировать по полю 'Номер счета'"
			href="javascript:SortBy('billnumber')">Номер<BR>счета</A><%=isUp(sortBy, "billnumber")%>
		</td>		
		<%--july:headercolumn key="label.charges.datecharge" colType="string"/--%>
		<td class="title" nowrap><A title="Сортировать по полю 'Дата учета в акте'"
			href="javascript:SortBy('date')">Дата учета<BR>в акте</A><%=isUp(sortBy, "date")%>
		</td>
		<td class="title">&nbsp;</td>
		<td class="title"><A title="Сортировать по полю 'Остаток для счет-фактур'"
			href="javascript:SortBy('ostSumForSF')">Остаток</A><%=isUp(sortBy, "ostSumForSF")%>
		</td>		
	</tr>


	<july:separator colspan="<%= gColSpan %>"/>

	<!-- Table body -->
	<logic:iterate id="it" name="<%=form%>"	property="chargesList" type="com.hps.july.valueobject.LeaseCharge_TO ">	
		<logic:present name="it">
			<tr
				<% String leaseDocPositionId = String.valueOf(((com.hps.july.valueobject.LeaseCharge_TO)it).getVo().getLeaseDocPosition()); %>			
				id='<bean:write name="it" property="vo.leaseDocPosition" filter="true"/>'
				class="normal" style="font-size: 8pt"
				onMouseOver="className='select'"
				onMouseOut="onMouseOutRow(this.id);" onclick='onClickRow(this.id);'>
				<td class="link">
					<html:checkbox name="<%=form%>" property="selectIds" value="<%= leaseDocPositionId %>"/>
				</td>
				<td class="text">
					<bean:write name="it" property="resName" filter="true"/>
				</td>
				<td class="number">
					<logic:equal name="it" property="vo.source" value="M">
						<IMG SRC="/images/infohint.gif" BORDER=0 ALT='<bean:message key="label.charges.byhand"/>'>
					</logic:equal>
				</td>				
				<td class="number" align="right" nowrap>
					<july:sumwrite name="it" property="vo.summ"/>
				</td>				
				<td class="text">
				<logic:present name="it" property="vo.currency">
					<bean:write name="it" property="curName" filter="true"/>
				</logic:present>
				</td>				
				<td class="text">
					<july:datewrite name="it" property="vo.beginDate"/>
				</td>
				<td class="text">
					<july:datewrite name="it" property="vo.endDate"/>
				</td>				
				<td class="text">
					<bean:write name="it" property="vo.billNumber" filter="true"/>
				</td>
				<td class="text">
					<july:datewrite name="it" property="vo.date"/>
				</td>
				<td class="text">
					<logic:equal name="it" property="vo.byHandRateRur" value="Y">
						<img src='/images/setrow.gif' border=0 alt='<bean:message key="label.charges.byhandraterur"/>'>
					</logic:equal>
				</td>
				<td class="number" align="right" nowrap>
					<july:sumwrite name="it" property="vo.ostSumForSF"/>
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
						&nbsp;<a href="#" title="Назад"><IMG SRC="/images/cancel.gif" BORDER='0' ALT='Назад' onclick="history.back();"></a>
					</td>
					<td align="right">отобрано записей:<%=request.getAttribute("numberOfLines")%></td>
				</tr>
			</table>
		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>

</table>

<logic:equal name="<%=form%>" property="flagOperation" value="true">
	<script language="javascript" type="text/javascript">
		 Close();
	</script>
</logic:equal>

<script language="javascript">
	switchDate();
	//switchResource();
</script>


</july:editform>
<script language="javascript">
	loadSelectedRow();
	//window.location.hash=document.all.selectedID.value;
</script>
<%
    //counter end
	//counter.finish("jsp");
%>
