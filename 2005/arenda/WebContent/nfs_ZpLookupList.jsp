<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import = "com.hps.july.arenda.formbean.*"%>
<SCRIPT language=javascript src="/common/dialog.js" type="text/javascript"></SCRIPT>  

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
	NFS_ZpLookupListForm listForm = (NFS_ZpLookupListForm)session.getAttribute("NFS_ZpLookupListForm");
	String sortBy = listForm.getSortBy();
%>

<july:browseform action="/ShowNFS_ZpLookupList" styleId="NFS_ZpLookupListForm" focus="filter">
<html:hidden property="sortBy"/>
<html:hidden property="formname"/>
<html:hidden property="fieldnames"/>

<script language="javascript">
function toggleStateFilter(n){
	document.all.stateFilter[n].checked = true;
    document.body.style.cursor="wait";
	NFS_ZpLookupListForm.submit();
	return false;
}
function SortBy(field) 
{
	var e = document.all.sortBy;
	e.value = (e.value == field)?field + ' desc':field;
    document.body.style.cursor="wait";
	NFS_ZpLookupListForm.submit();
	return false;
}
function Go(strval) {
	var thisform = document.NFS_ZpLookupListForm;
	var outform = window.opener.document.forms[thisform.formname.value];
	
	if(outform != null)
	{
		var names = thisform.fieldnames.value.split('|'), values = strval.split('|');
		for(var i in names)
			if(names[i].length > 0)
				outform[names[i]].value = unescape(values[i]);
		outform.action.value = "Add"
	}
	Close();
}
function Close()
{
	var thisform = document.NFS_ZpLookupListForm;
	var outform = window.opener.document.forms[thisform.formname.value];
	if(outform != null) {
		document.body.style.cursor="wait";
		outform.submit();
		window.opener.focus();
	}
	window.close();
}
function switchFilter() {
	if(NFS_ZpLookupListForm.stateFilter.value == 0) {
		NFS_ZpLookupListForm.filter.disabled = true;
		NFS_ZpLookupListForm.filter.className = 'editdisabled';
	} else {
		NFS_ZpLookupListForm.filter.disabled = false;
		NFS_ZpLookupListForm.filter.className = 'editsearch';
		NFS_ZpLookupListForm.filter.focus();
	}
}
function switchDopFilter() {
	if(NFS_ZpLookupListForm.isDopFilter[0].checked) {
	/**
		for(var i = 0; i < dopFilterID.length; i++){
			dopFilterID[i].style.setAttribute("display", "block");
		}
	*/
		dopFilterID.style.setAttribute("display", "block");
		NFS_ZpLookupListForm.stateFilter.value = 0;
		NFS_ZpLookupListForm.isAllVendorSite[0].checked = false;
	} else {
	/**
		for(var i = 0; i < dopFilterID.length; i++){
			dopFilterID[i].style.setAttribute("display", "none");
		}
	*/
		dopFilterID.style.setAttribute("display", "none");
		NFS_ZpLookupListForm.stateFilter.value = 1;
		NFS_ZpLookupListForm.isAllVendorSite[0].checked = true;
	}
	switchFilter();
	switchVendorSite();	
}
function hideDopFilter() {
	if(NFS_ZpLookupListForm.isDopFilter[0].checked) {
		dopFilterID.style.setAttribute("display", "block");
	} else {
		dopFilterID.style.setAttribute("display", "none");
	}
}
function switchVendorSite() {
	if (document.all.isAllVendorSite[0].checked) {
		NFS_ZpLookupListForm.vendorSiteName.disabled = true;
		document.all['lookupimg_execl'].src='/images/lookup_disabled.gif';
	} else {
		NFS_ZpLookupListForm.vendorSiteName.disabled = false;
		document.all['lookupimg_execl'].src='/images/lookup.gif';
	}
}
</script>

<table class="main" style="font-size: 8pt">

	<july:separator colspan="<%= gColSpan %>"/>

	<TR class="normal">
		<TD colspan="<%= gColSpan %>">
			<table class="find" style="font-size: 9pt">
				<tr>
					<td class="text" nowrap width="23%">Строка запроса:</td>
					<td class="text">
						<july:string size="50" style="font-size:8pt;" styleClass="editsearch" property="filter" styleId="filter" insertable="true" updatable="true"/>
					</td>
					<td class="text" nowrap>по:</td>
					<td class="text" nowrap>
						<july:select styleClass="search" onchange="switchFilter()" property="stateFilter" insertable="true" updatable="true" style="font-size:8pt;vertical-align: top;">
							<html:option value="0">все</html:option>
							<html:option value="1">ИНН</html:option>
							<html:option value="2">НАИМЕНОВАНИЮ</html:option>
							<html:option value="3">№ ЗП</html:option>
							<html:option value="4">№ ДОГОВОРА</html:option>
							<html:option value="5">По коду поставщика</html:option>
						</july:select>
						<july:searchbutton/>
						Доп.условия: <html:checkbox property="isDopFilter" onclick="switchDopFilter()"/>
						<html:hidden property="isDopFilter" value="false"/>						
					</td>
				</tr>
				<tr id="dopFilterID">
					<td class="text">поиск по отделению:</td>
					<td class="text" nowrap colspan="3">
						<july:checkbox property="isAllVendorSite" insertable="true" updatable="true" onclick="switchVendorSite()"/>все					
						<html:link page="/../dict/VendorSiteLookupList.do?formname=NFS_ZpLookupListForm&fieldnames=||vendorSiteName|||||||||||idVendorSiteNfs" onclick="if (document.all.isAllVendorSite[0].checked) { return false; } else {return openDialog(this.href, 'VendorSitesLookupList', 'top=100, left=200, width=700, height=650, scrollbars=yes, resizable=yes');}" title="справочник отделений">		
							<img name="lookupimg_execl" src='/images/lookup.gif' border='0' alt='Справочник отделений'></html:link>		
						<html:hidden property="idVendorSiteNfs"/>
						<july:string style="font-size: 8pt;" size="50" property="vendorSiteName" styleId="vendorSiteName" insertable="false" updatable="false"/>						
					</td>
				</tr>				
<%--
				<tr>
					<td class="text" nowrap>Условие запроса по:</td>
					<td class="text" nowrap style="font-size:8pt;">
						<july:radio property="stateFilter" insertable="true" updatable="true" value="0"/>
						<A href="javascript:toggleStateFilter(0)">ИНН</A>
						<july:radio property="stateFilter" insertable="true" updatable="true" value="1"/>
						<A href="javascript:toggleStateFilter(1)">НАИМЕНОВАНИЮ</A>
						<july:radio property="stateFilter" insertable="true" updatable="true" value="2"/>
						<A href="javascript:toggleStateFilter(2)">№ ЗП</A>
						<july:radio property="stateFilter" insertable="true" updatable="true" value="3"/>
						<A href="javascript:toggleStateFilter(3)">№ ДОГОВОРА</A>
					</td>
				</tr>
--%>
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
		<td class="title">&nbsp;</td>
		<td class="title">
			<A title="Сортировать по полю 'номер ЗП'" href="javascript:SortBy('numZp')">номер ЗП</A><%=isUp(sortBy, "numZp")%>
		</td>
		<td class="title">
			<A title="Сортировать по полю 'сумма ЗП'" href="javascript:SortBy('sumZp')">сумма ЗП</A><%=isUp(sortBy, "sumZp")%>
		</td>
		<td class="title">
			<A title="Сортировать по полю 'ндс ЗП'" href="javascript:SortBy('ndsZp')">ндс ЗП<%=isUp(sortBy, "ndsZp")%>
		</td>
		<td class="title">
			<A title="Сортировать по полю 'номер договора'" href="javascript:SortBy('numcontract')">номер  договора<%=isUp(sortBy, "numcontract")%>
		</td>
		<td class="title">
			<A title="Сортировать по полю 'наименование поставщика'" href="javascript:SortBy('nameVendor_zp')">наименование поставщика<%=isUp(sortBy, "nameVendor_zp")%>
		</td>
		<td class="title">
			<A title="Сортировать по полю 'состояние ЗП'" href="javascript:SortBy('stateZp')">сост. ЗП<%=isUp(sortBy, "stateZp")%>
		</td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>

	<!-- Table body -->
	<logic:iterate id="it" name="browseList">
		<logic:present name="it">
		<tr class="normal" style="font-size:8pt;" onMouseOver="className='select'" onMouseOut="className='normal'">
			<td class="text">
				<A href='javascript:Go("<bean:write name="it" property="idZpNfs" filter="true"/>")' title="Выберите запись">выбрать</A>
			</td>
			<td class="text">
				<bean:write name="it" property="numZp" filter="true"/>
			</td>			
			<td class="text">
				<july:sumwrite name="it" property="sumZp"/>&nbsp;<bean:write name="it" property="currZp" filter="true"/>
			</td>
			<td class="text">
				<july:sumwrite name="it" property="ndsZp"/>&nbsp;<bean:write name="it" property="currZp" filter="true"/>
			</td>
			<td class="text">
					<bean:write name="it" property="contract.numContract" filter="true"/>
			</td>
			<td class="text">
					<bean:write name="it" property="vendor.name" filter="true"/>
			</td>
			<td class="text">
				<bean:write name="it" property="stateZp" filter="true"/>
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
<script language="javascript">
	hideDopFilter();
	switchVendorSite();
	switchFilter();
</script>

