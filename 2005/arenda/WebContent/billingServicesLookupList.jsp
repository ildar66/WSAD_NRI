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
	String gColSpan = "3";
	BillingServicesLookupListForm listForm = (BillingServicesLookupListForm)session.getAttribute("BillingServicesLookupListForm");
	String sortBy = listForm.getSortBy();
%>

<july:browseform action="/ShowBillingServicesLookupList" styleId="ShowBillingServicesLookupList" focus="filter">
<html:hidden property="sortBy"/>
<html:hidden property="formname"/>
<html:hidden property="fieldnames"/>

<script language="javascript">
function SortBy(field) 
{
	var e = document.all.sortBy;
	e.value = (e.value == field)?field + ' desc':field;
    document.body.style.cursor="wait";
	ShowBillingServicesLookupList.submit();
	return false;
}
function Go(strval) {
	var thisform = document.ShowBillingServicesLookupList;
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
	var thisform = document.ShowBillingServicesLookupList;
	var outform = window.opener.document.forms[thisform.formname.value];
	if(outform != null) {
		document.body.style.cursor="wait";
		window.opener.focus();
	}
	window.close();
}
function GetNamesStatuses()
{
	var retStr;
	var e = document.ShowBillingServicesLookupList.status;
	if(e ==null) return;
	for(var i = 0, j = 0; i < e.length; i++)
		if(e[i].checked) {
		    if(j == 0)
				retStr  =  "1) " + e[i].value + "; \n" ;
			else
				retStr  =  retStr + "" + ( j+1) + ") " + e[i].value + "; \n" ;
			j++
	   }
	//alert(retStr);
	Go(retStr);
}
</script>

<table class="main"> 

	<july:separator colspan="<%= gColSpan %>"/>

	<TR class="normal">
		<TD colspan="<%= gColSpan %>">
			<table class="find">
				<tr>
					<td class="text">Запрос по наименованию:</td>
					<td class="text"  colspan="2">
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
						<july:closebutton page="/"/>&nbsp;&nbsp;
						<A style="COLOR: green;" href="javascript:GetNamesStatuses();">
							Все выбранные услуги
						</A>
					</td>
					<td class="buttons">
						отобрано записей:<%= request.getAttribute("numberOfLines") %>
					</td>
					<td class="buttons">
							<july:navigator/>
					</td>
				</tr>
			</table>
		</td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>

	<!-- Table header -->
	<tr class="title">
		<td class="title" nowrap>
			<A title="Сортровать по полю 'код'" href="javascript:SortBy('codeService')">Код-обозначение</A>
			<%=isUp(sortBy, "codeService")%>
		</td>
		<td class="title" nowrap>
			<A title="Сортровать по полю 'наименование'" href="javascript:SortBy('nameService')">Наименование услуги</A>
			<%=isUp(sortBy, "nameService")%>
		</td>
		<td  title="Выбoр услуг" align="center"><B>!</B></td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>

	<!-- Table body -->
	<logic:iterate id="it" name="browseList">
		<logic:present name="it">
		<tr class="normal" style="font-size:8pt;" onMouseOver="className='select'" onMouseOut="className='normal'">
			<td class="text">
				<bean:write name="it" property="codeService" filter="true"/>
			</td>
			<td class="text">
				<A href='javascript:Go("<bean:write name="it" property="nameService" filter="true"/>|<bean:write name="it" property="idService" filter="true"/>")' title="Выберите запись">
					<bean:write name="it" property="nameService" filter="true"/>
				</A>
			</td>
			<td class="text" title="Выбрать услугу">
				<INPUT type=checkbox  value='<bean:write name="it" property="nameService" filter="true"/>' name=status>
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
						<july:closebutton page="/"/>&nbsp;&nbsp;
						<A style="COLOR: green;" href="javascript:GetNamesStatuses();">
							Все выбранные услуги
						</A>
					</td>
					<td class="buttons">
							отобрано записей:<%= request.getAttribute("numberOfLines") %>
					</td>
					<td class="buttons">
							<july:navigator/>
					</td>
				</tr>
			</table>
		</td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>
</table>

</july:browseform>
