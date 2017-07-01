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
<%
	String gColSpan = "7";
	AbonentBillLookupListForm listForm = (AbonentBillLookupListForm)session.getAttribute("AbonentBillLookupListForm");
	String sortBy = listForm.getSortBy();
%>
<july:browseform action="/ShowAbonentBillLookupList" styleId="ShowAbonentBillLookupList">
<html:hidden property="sortBy"/>
<html:hidden property="formname"/>
<html:hidden property="fieldnames"/>

<script language="javascript">
function SortBy(field) 
{
	var e = document.all.sortBy;
	e.value = (e.value == field)?field + ' desc':field;
    document.body.style.cursor="wait";
	ShowAbonentBillLookupList.submit();
	return false;
}
function Go(strval) {
	var thisform = document.ShowAbonentBillLookupList;
	var outform = window.opener.document.forms[thisform.formname.value];
	
	if(outform != null)
	{
		var names = thisform.fieldnames.value.split('|'), values = strval.split('|');
		for(var i in names) {
			if(names[i].length > 0)
				outform[names[i]].value = unescape(values[i]);
		}
	}
	Close();
}
function Close()
{
	var thisform = document.ShowAbonentBillLookupList;
	var outform = window.opener.document.forms[thisform.formname.value];
	if(outform != null) {
		//document.body.style.cursor="wait";
		//window.opener.focus();
	}
	window.close();
}
function switchCheckbox() {
	if (document.all.isBillDate[0].checked) {
		ShowAbonentBillLookupList.fromDate_dt.enabled = true;
		ShowAbonentBillLookupList.toDate_dt.enabled = true;
	} else {
		ShowAbonentBillLookupList.fromDate_dt.enabled = false;
		ShowAbonentBillLookupList.toDate_dt.enabled = false;
	}
	if(document.all.isBillNumber[0].checked){
		ShowAbonentBillLookupList.billNumb.disabled = false;
	} else {
		ShowAbonentBillLookupList.billNumb.disabled = true;
	}
}
function toggleStateFilterBillDate(){
	if(document.all.isBillDate[0].checked)
		document.all.isBillDate[0].checked = false;
	else
		document.all.isBillDate[0].checked = true;
	switchCheckbox();
}
function toggleStateFilterBillNumber(){
	if(document.all.isBillNumber[0].checked)
		document.all.isBillNumber[0].checked = false;
	else
		document.all.isBillNumber[0].checked = true;
	switchCheckbox();
}
</script>

<table class="main"> 

	<july:separator colspan="<%= gColSpan %>"/>

	<TR class="normal">
		<TD colspan="<%= gColSpan %>">
			<table class="find">
				<tr>
					<td>
						<july:checkbox property="isBillNumber" insertable="true" updatable="true" onclick="switchCheckbox()"/>
						<A href="javascript:toggleStateFilterBillNumber()">по номеру:</A>
					</td>
					<td>
						<july:string size="50" styleClass="seach" property="billNumber" styleId="billNumb" insertable="true" updatable="true"/>
						<july:searchbutton/>
					</td>
				</tr>
				<tr>
					<td>
						<july:checkbox property="isBillDate" insertable="true" updatable="true" onclick="switchCheckbox()"/>
						<A href="javascript:toggleStateFilterBillDate()">по дате:</A>
					</td>
					<td>
						c <july:date property="fromBillDateStr" size="25" insertable="true" updatable="true" styleId="fromDate"/>
						по <july:date property="toBillDateStr" size="25" insertable="true" updatable="true" styleId="toDate"/></td>
					</td>
				</tr>
				<tr>
					<td>Тип:</td>
					<td>
						<july:select property="billType" styleId="billType" insertable="true" updatable="true" onchange="ShowAbonentBillLookupList.submit();">
							<html:option value="*">все</html:option>
							<html:option value="U">услуги</html:option>
							<html:option value="O">оборудование</html:option>
							<html:option value="S">смешанный</html:option>
						</july:select>
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
						<july:closebutton page="/"/>
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
		<td class="title" nowrap>
			<A title="Сортровать по полю 'дата'" href="javascript:SortBy('billdate')">Дата</A><%=isUp(sortBy, "billdate")%>
		</td>
		<td class="title" nowrap>
			<A title="Сортровать по полю 'номер'" href="javascript:SortBy('billnumber')">Номер</A><%=isUp(sortBy, "billnumber")%>
		</td>
		<td class="title" nowrap>
			<A title="Сортровать по полю 'сумма счета'" href="javascript:SortBy('sum ')">Сумма счета</A><%=isUp(sortBy, "sum ")%>
		</td>
		<td class="title" nowrap>
			<A title="Сортровать по полю 'НДС'" href="javascript:SortBy('sumNds')">НДС</A><%=isUp(sortBy, "sumNds")%>
		</td>
		<td class="title" nowrap>
			<A title="Сортровать по полю 'Дата начала'" href="javascript:SortBy('billperiodstart')">Дата начала</A><%=isUp(sortBy, "billperiodstart")%>
		</td>
		<td class="title" nowrap>
			<A title="Сортровать по полю 'Дата окончания'" href="javascript:SortBy('billperiodend')">Дата окончания</A><%=isUp(sortBy, "billperiodend")%>
		</td>
		<td class="title" nowrap>
			<A title="Сортровать по полю 'тип'" href="javascript:SortBy('billtype')">тип</A><%=isUp(sortBy, "billtype")%>
		</td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>

	<!-- Table body -->
	<logic:iterate id="it" name="browseList">
		<logic:present name="it">
		<tr class="normal" style="font-size:8pt;" onMouseOver="className='select'" onMouseOut="className='normal'">
			<td class="text">
				<july:datewrite name="it" property="billdate"/>
			</td>
			<td class="text">
				<A href='javascript:Go("<bean:write name="it" property="leasebill" filter="true"/>|№ <bean:write name="it" property="billnumber" filter="true"/> от <july:datewrite name="it" property="billdate"/>")' title="Выберите запись">
					<bean:write name="it" property="billnumber" filter="true"/>
				</A>
			</td>
			<td class="text">
				<bean:write name="it" property="sum" filter="true"/>
			</td>
			<td class="text">
				<bean:write name="it" property="sumNds" filter="true"/>
			</td>
			<td class="text">
				<july:datewrite name="it" property="billperiodstart"/>
			</td>
			<td class="text">
				<july:datewrite name="it" property="billperiodend"/>
			</td>
			<td class="text">
				<bean:write name="it" property="billtype" filter="true"/>
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
						<july:closebutton page="/"/>
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
	switchCheckbox();
</script>

</july:browseform>

