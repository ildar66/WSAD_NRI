<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ page import="com.hps.july.arenda.valueobject.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import = "com.hps.july.arenda.formbean.AbonentPaysListForm"%>

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
	String gColSpan = "16";
	String emptyString = ""; 
	String message = "";
	AbonentPaysListForm listForm = (AbonentPaysListForm)session.getAttribute("AbonentPaysListForm");
	String sortBy = listForm.getSortBy();
	 java.util.ArrayList listOldFlagworknri = new java.util.ArrayList();
%>

<july:browseform action="/ShowAbonentPaysList.do" styleId="listForm">
<html:hidden property="leaseDocument"/>
<html:hidden property="selectedID" value="0"/>
<html:hidden property="sortBy"/>
<html:hidden property="group"/>

<script language="javascript">
function switchDate() {
	if (document.all.isDate[0].checked) {
		listForm.fromDate_dt.enabled = false;
		listForm.toDate_dt.enabled = false;
	} else {
		listForm.fromDate_dt.enabled = true;
		listForm.toDate_dt.enabled = true;
	}
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
//	считываем selectedID:
	var startLoc = cookies.indexOf(listForm.name+"=");
	if(startLoc == -1)
	   return;
	var sepLoc = cookies.indexOf("=", startLoc);
	var endLoc = cookies.indexOf(";", startLoc);
	if(endLoc == -1) {
		endLoc = cookies.length;
    }
    document.all.selectedID.value = cookies.substring(sepLoc+1, endLoc);
//	подчеркиваем строку в таблице:
	if( document.all.tableID.rows(document.all.selectedID.value) != null ) {
 		document.all.tableID.rows(document.all.selectedID.value,0).className="selected";
	}
}
function SortBy(field) 
{
	var e = document.all.sortBy;
	e.value = (e.value == field)?field + ' desc':field;
    document.body.style.cursor="wait";
	listForm.submit();
	return false;
}
function toggleSearchUsenri(n){
	document.all.searchUsenri[n].checked = true;
}
</script>

<table class="main" id="tableID" style="font-size: 8pt">
<%--
<tr class="title">
		<td class="title" colspan="<%= gColSpan %>">
			<html:link page="/ShowAbonentsList.do" styleClass="navigator"><bean:message key="label.abonents"/></html:link>
			<july:sepmark/>
			<july:editlink page="/ViewAbonent.do" action="View" paramId="leaseDocument" paramName="AbonentPaysListForm" paramProperty="leaseDocument" styleClass="navigator">
				<bean:message key="label.view"/>
			</july:editlink>
			<july:sepmark/>
			<july:currmark><bean:message key="label.abonent.pays"/></july:currmark>
		</td>
	</tr>
--%>

	<logic:notEqual name="AbonentPaysListForm" property="taskcode" value="0">
	  <july:separator colspan="<%= gColSpan %>"/>
		<tr class="text">
			<td class="text">&nbsp;</td>
			<td class="text" colspan="5">
				<july:link page="/ShowFromPayHandleInNRIJournalBillList.do" paramId="taskStartcode" paramName="AbonentPaysListForm" 
							paramProperty="taskcode" scope="session">
					<bean:message key="label.abonent.journal"/> 
				</july:link>
			</td>
		</tr>
	</logic:notEqual>

<july:separator colspan="<%= gColSpan %>"/>
	<TR class="normal">
		<TD colspan="<%= gColSpan %>">
			<table class="find" style="font-size: 9pt">
				<tr>
					<td class="text"><bean:message key="label.bans.ban"/>:</td>
					<td class="text" nowrap><bean:write name="AbonentPaysListForm" property="ban" filter="true"/></td>
				</tr>
				<tr>
					<td class="text"><bean:message key="label.bans.org.name"/>:</td>
					<td class="text">
						<bean:write name="AbonentPaysListForm" property="customername" filter="true"/>
						<logic:present name="AbonentPaysListForm" property="customernameBill">
							<logic:notEqual name="AbonentPaysListForm" property="customernameBill" value="<%= emptyString %>">
								&nbsp;<bean:message key="label.bans.frombilling"/>
								&nbsp;<bean:write name="AbonentPaysListForm" property="customernameBill" filter="true"/>
							</logic:notEqual>
						</logic:present>
					</td>
				</tr>
				<tr>
					<td class="text"><bean:message key="label.bans.org.inn"/>:</td>
					<td class="text" nowrap>
						<bean:write name="AbonentPaysListForm" property="customerinn" filter="true"/>
					</td>
				</tr>
<logic:present name="AbonentPaysListForm" property="customernameBill">
	<logic:notEqual name="AbonentPaysListForm" property="customernameBill" value="<%= emptyString %>">
				<tr>
					<td class="text"><bean:message key="label.bans.name"/>:</td>
					<td class="text">
						<bean:write name="AbonentPaysListForm" property="customernameBill" filter="true"/>
					</td>
				</tr>
	</logic:notEqual>
</logic:present>
<logic:present name="AbonentPaysListForm" property="customerinnBill">
	<logic:notEqual name="AbonentPaysListForm" property="customerinnBill" value="<%= emptyString %>">
				<tr>
					<td class="text"><bean:message key="label.bans.inn"/>:</td>
					<td class="text" nowrap>
						<bean:write name="AbonentPaysListForm" property="customerinnBill" filter="true"/>
					</td>
				</tr>
	</logic:notEqual>
</logic:present>
				<tr>
					<td class="text"><bean:message key="label.filter.start"/>:</td>
					<td class="text">
						<table class="main" border="0" cellpading="0" cellspacing="0">
							<tr>
								<td class="text">
									<july:checkbox property="isDate" insertable="true" updatable="true" onclick="switchDate()"/>
									<bean:message key="label.filter.all"/>
								</td>
								<td class="text"><july:date property="fromDateFrm" size="25" insertable="true" updatable="true" styleId="fromDate" style="height:18pt; width:80pt; font-size:9pt"/></td>
								<td class="text"><bean:message key="label.filter.stop"/>:</td>
								<td class="text"><july:date property="toDateFrm" size="25" insertable="true" updatable="true" styleId="toDate" style="height:18pt; width:80pt; font-size:9pt"/></td>
								<td><july:searchbutton/></td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td class="text">&nbsp;</td>
					<td class="text" nowrap>
				   		<july:radio property="searchUsenri" insertable="true" updatable="true" value="0"/>
							<A href="javascript:toggleSearchUsenri(0)"><bean:message key="label.search.all"/></A>
						<july:radio property="searchUsenri" insertable="true" updatable="true" value="1"/>
							<A href="javascript:toggleSearchUsenri(1)"><bean:message key="label.abonent.pays.usenri"/></A>
						<july:radio property="searchUsenri" insertable="true" updatable="true" value="2"/>
							<A href="javascript:toggleSearchUsenri(2)"><bean:message key="label.abonent.pays.unusenri"/></A>
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
						<july:backbutton page="/ViewAbonent.do?action=View" paramId="leaseDocument" paramName="AbonentPaysListForm" paramProperty="leaseDocument"/>
						<!-- <july:savebutton/> -->
					    <july:canedit rolesProperty="editRoles">
						   <logic:notEqual name="AbonentForm" property="contractState" value="A">
                              <input type='image' name='submit' src='/images/save.gif' alt='<bean:message key="label.abonent.nrifunc"/>' onclick = "document.all.group.value=true;">
						   </logic:notEqual>
					    </july:canedit>
					</td>
					<td align="right">
						Всего записей:<%= request.getAttribute("numberOfLines") %>
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
<%--
		<td class='title' rowspan='2' title='<bean:message key="label.bans.pay.needpay"/>'>
			<A title='Сортировать по полю: <bean:message key="label.bans.pay.needpay"/>' href="javascript:SortBy('needpay')">*</A><%=isUp(sortBy, "needpay")%>
		</td>
--%>
		<td class='title' rowspan='2' title='<bean:message key="label.bans.pay.flagworknri"/>' align='center'>
			<A title='Сортировать по полю: <bean:message key="label.bans.pay.flagworknri"/>' href="javascript:SortBy('flagworknri')">*</A><%=isUp(sortBy, "flagworknri")%>
		</td>
		<td class="title" rowspan="2">
			<A title='Сортировать по полю: <bean:message key="label.abonent.pays.date"/>' href="javascript:SortBy('paydate')">
				<bean:message key="label.abonent.pays.date"/>
			</A><%=isUp(sortBy, "paydate")%>
		</td>
		<td class="title" rowspan="2">
			<A title='Сортировать по полю: <bean:message key="label.abonent.pays.number"/>' href="javascript:SortBy('paynumber')">
				Номер<br>платежа
			</A><%=isUp(sortBy, "paynumber")%>
		</td>
		<td class="title" rowspan="2">
			<A title='Сортировать по полю: <bean:message key="label.abonent.pays.rate"/>' href="javascript:SortBy('payrate')">
				Курс<br>платежа 
			</A><%=isUp(sortBy, "payrate")%>
		</td>
		<td class="title" colspan="2">
			<A title='Сортировать по полю: <bean:message key="label.abonent.pays.sum"/>' href="javascript:SortBy('sumpayusd')">
				<bean:message key="label.abonent.pays.sum"/>
			</A><%=isUp(sortBy, "sumpayusd")%>
		</td>
		<td class="title" colspan="2" nowrap>
			<A title='Сортировать по полю: <bean:message key="label.abonent.pays.sumnri"/>' href="javascript:SortBy('sumnriusd')">
				<bean:message key="label.abonent.pays.sumnri"/>
			</A><%=isUp(sortBy, "sumnriusd")%>
		</td>
		<th class="title" rowspan="2" title="<bean:message key="label.payments.paypurpose"/>">!</th>
		<td class="title" rowspan="2">
			<A title='Сортировать по полю: <bean:message key="label.abonent.pays.type"/>' href="javascript:SortBy('typename')">
				<bean:message key="label.abonent.pays.type"/>
			</A><%=isUp(sortBy, "typename")%>
		</td>
<%--
		<td class="title" colspan="2" rowspan="2" align="center"><bean:message key="label.bans.pay.paypart"/></td>
		<td class="title" rowspan="2">&nbsp;</td>
--%>
	</tr>
	<tr class="title">
		<td class="title"><bean:message key="usd"/></td>
		<td class="title"><bean:message key="rur"/></td>
		<td class="title"><bean:message key="usd"/></td>
		<td class="title"><bean:message key="rur"/></td>
<%--
		<td class="title"><bean:message key="usd"/></td>
		<td class="title"><bean:message key="rur"/></td>
--%>
	</tr>
	<july:separator colspan="<%= gColSpan %>"/>
	<!-- Table body -->
	<logic:iterate id="it" name="browseList">
		<logic:present name="it">
			<%
				AbonentPayment_VO vo = (AbonentPayment_VO)it;
			    if(vo.isFlagworknri())
					 listOldFlagworknri.add(new Integer(vo.getPaypos()));
			%>
			<tr class="normal"  id='<bean:write name="it" property="paypos" filter="true"/>' onMouseOver="className='select'" onMouseOut="onMouseOutRow(this.id)" onclick='onClickRow(this.id)'>
				<td class="text">
					<% String tmp = "View"; %>
					<july:canedit rolesProperty="editRoles">
						<logic:notEqual name="AbonentForm" property="contractState" value="A">
							<logic:notEqual name="it" property="recordstatus" value="D">
								<logic:equal name="it" property="flagworknri" value="false"><% tmp = "Edit"; %></logic:equal>
							</logic:notEqual>
						</logic:notEqual>
					</july:canedit>
					<july:editbutton page="/EditAbonentPay.do" action="<%= tmp %>" paramId="paypos" paramName="it" paramProperty="paypos" paramScope="page"/>
				</td>
<%--
				<logic:equal name="it" property="needpay" value="true"><% message = "label.bans.pay.needpay.yes"; %></logic:equal>
				<logic:equal name="it" property="needpay" value="false"><% message = "label.bans.pay.needpay.no"; %></logic:equal>
				<td class='text' align='center' title='<bean:message key="<%= message %>"/>'>
					<logic:equal name="it" property="needpay" value="true">+</logic:equal>
					<logic:equal name="it" property="needpay" value="false">-</logic:equal>
				</td>
				<logic:equal name="it" property="flagworknri" value="true"><% message = "label.bans.pay.flagworknri.yes"; %></logic:equal>
				<logic:equal name="it" property="flagworknri" value="false"><% message = "label.bans.pay.flagworknri.no"; %></logic:equal>
				<td class='text' align='center' title='<bean:message key="<%= message %>"/>'>
					<logic:equal name="it" property="flagworknri" value="true">+</logic:equal>
					<logic:equal name="it" property="flagworknri" value="false">-</logic:equal>
				</td>
--%>
				<td class='text' align='center'>
				 <july:canedit rolesProperty="editRoles">
					<html:checkbox name = "it" property="flagworknri" value= "<%= String.valueOf(vo.getPaypos())%>" />
				</july:canedit>
				 <july:cannotedit rolesProperty="editRoles">
					<html:checkbox name = "it" property="flagworknri" value= "<%= String.valueOf(vo.getPaypos())%>" disabled="true" />
				</july:cannotedit>
				</td>
				<td class="text">
					<july:datewrite name="it" property="paydate"/>
				</td>
				<td class="text">
					<bean:write name="it" property="paynumber" filter="true"/>
				</td>
				<td class="number" align="right">
					<logic:present name="it" property="payrate">
						<july:numberwrite name="it" property="payrate"/>
					</logic:present>
				</td>
				<td class="number" align="right">
					<july:sumwrite name="it" property="sumpayusd"/>
				</td>
				<td class="number" align="right">
					<july:sumwrite name="it" property="sumpayrur"/>
				</td>
				<td class="number" align="right">
					<july:sumwrite name="it" property="sumnriusd"/>
				</td>
				<td class="number" align="right">
					<july:sumwrite name="it" property="sumnrirur"/>
				</td>
<%--
				<td class="number" align="right">
					<july:sumwrite name="it" property="sumfreeusd"/>
				</td>
				<td class="number" align="right">
					<july:sumwrite name="it" property="sumfreerur"/>
				</td>
--%>
				<td class="text" align="center">
					<img src='/images/infohint.gif' border=0 alt='<bean:message key="label.payments.paypurpose"/>:&#10;<july:stringwrite name="it" property="payPurpose"/>'>
				</td>
				<td class='text' title='<bean:message key="label.abonent.pays.type.full"/>:&nbsp;<bean:write name="it" property="typename"/>'>
					<% String typename = vo.getTypename(); %>
					<%= typename.length() > 10 ? typename.substring(0, 10) + "..." : typename %>
				</td>
<%--
				<td class="text" align="right">
					<bean:write name="it" property="payed"/>
				</td>
				<td class="link" align="center">
					<july:link page="/ShowAbonentPayedList.do" paramId="pay" paramName="it" paramProperty="paypos" scope="page">
						<img src="/images/kontr.gif" border=0 alt='<bean:message key="label.abonent.payed"/>'>
					</july:link>
				</td>

				<td class="link" align="center">
					<july:canedit rolesProperty="editRoles">
						<logic:notEqual name="AbonentForm" property="contractState" value="A">
							<july:link page="/EditPayHandleInNRI.do" paramId="paypos" paramName="it" paramProperty="paypos" scope="page">
								<img src="/images/doc.gif" border=0 alt='<bean:message key="label.abonent.nrifunc"/>'>
							</july:link>
						</logic:notEqual>
					</july:canedit>
				</td>
--%>
            </tr>
			<%--<july:separator colspan="<%= gColSpan %>"/>--%>
	      </logic:present>
        </logic:iterate>
		<% listForm.setOldFlagworknri(listOldFlagworknri);%>
	<tr class="title">
		<td colspan="<%= gColSpan %>">
			<table class="buttons">
				<tr class="title">
					<td class="buttons">
						<july:backbutton page="/ViewAbonent.do?action=View" paramId="leaseDocument" paramName="AbonentPaysListForm" paramProperty="leaseDocument"/>
						<!-- <july:savebutton/> -->
					    <july:canedit rolesProperty="editRoles">
						   <logic:notEqual name="AbonentForm" property="contractState" value="A">
                              <input type='image' name='submit' src='/images/save.gif' alt='<bean:message key="label.abonent.nrifunc"/>' onclick = "document.all.group.value=true;">
						   </logic:notEqual>
					    </july:canedit>
					</td>
					<td align="right">
						Всего записей:<%= request.getAttribute("numberOfLines") %>
					</td>
					<td class="navigator"><july:navigator/></td>
				</tr>
			</table>
		</td>
	</tr>

	<july:separator colspan="<%= gColSpan %>" />
<%--
<tr class="title">
		<td class="title" colspan="<%= gColSpan %>">
			<html:link page="/ShowAbonentsList.do" styleClass="navigator"><bean:message key="label.abonents"/></html:link>
			<july:sepmark/>
			<july:editlink page="/ViewAbonent.do" action="View" paramId="leaseDocument" paramName="AbonentPaysListForm" paramProperty="leaseDocument" styleClass="navigator">
				<bean:message key="label.view"/>
			</july:editlink>
			<july:sepmark/>
			<july:currmark><bean:message key="label.abonent.pays"/></july:currmark>
		</td>
	</tr>
--%>
</table>
<script language="javascript">
	switchDate();
	loadSelectedRow();
	window.location.hash=document.all.selectedID.value;
</script>
</july:browseform>
