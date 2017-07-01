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
	String gColSpan = "5";
	TarifPlanLookupListForm listForm = (TarifPlanLookupListForm)session.getAttribute("TarifPlanLookupListForm");
	String sortBy = listForm.getSortBy();
%>

<july:browseform action="/ShowTarifPlanLookupList" styleId="ShowTarifPlanLookupList" focus="filter">
<html:hidden property="sortBy"/>
<html:hidden property="formname"/>
<html:hidden property="fieldnames"/>

<script language="javascript">
function SortBy(field) 
{
	var e = document.all.sortBy;
	e.value = (e.value == field)?field + ' desc':field;
    document.body.style.cursor="wait";
	ShowTarifPlanLookupList.submit();
	return false;
}
function Go(strval) {
	var thisform = document.ShowTarifPlanLookupList;
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
	var thisform = document.ShowTarifPlanLookupList;
	var outform = window.opener.document.forms[thisform.formname.value];
	if(outform != null) {
		document.body.style.cursor="wait";
		window.opener.focus();
	}
	window.close();
}
</script>

<table class="main"> 

	<july:separator colspan="<%= gColSpan %>"/>

	<TR class="normal">
		<TD colspan="<%= gColSpan %>">
			<table class="find">
				<tr>
					<td class="text" nowrap>Строка запроса по наименованию:</td>
					<td class="text">
						<july:string size="25" styleClass="seach" property="filter" styleId="filter" insertable="true" updatable="true"/>
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
			<A title="Сортровать по полю 'код'" href="javascript:SortBy('codeTarifPlan')">Код-обозначение</A>
			<%=isUp(sortBy, "codeTarifPlan")%>
		</td>
		<td class="title" nowrap>
			<A title="Сортровать по полю 'наименование'" href="javascript:SortBy('nameTarifPlan')">Наименование тарифного плана</A>
			<%=isUp(sortBy, "nameTarifPlan")%>
		</td>
		<td class="title" nowrap>
			<A title="Сортровать по полю 'дата'" href="javascript:SortBy('effective_date')">Дата начала действия</A>
			<%=isUp(sortBy, "effective_date")%>
		</td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>

	<!-- Table body -->
	<logic:iterate id="it" name="browseList">
		<logic:present name="it">
		<tr class="normal" style="font-size:8pt;" onMouseOver="className='select'" onMouseOut="className='normal'">
			<td class="text">
				<bean:write name="it" property="codeTarifPlan" filter="true"/>
			</td>
			<td class="text">
				<A href='javascript:Go("<bean:write name="it" property="nameTarifPlan" filter="true"/>|<bean:write name="it" property="idTarifPlan" filter="true"/>")' title="Выберите запись">
					<bean:write name="it" property="nameTarifPlan" filter="true"/>
				</A>
			</td>
			<td class="text">
				<july:datewrite name="it" property="effective_date"/>
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

</july:browseform>
