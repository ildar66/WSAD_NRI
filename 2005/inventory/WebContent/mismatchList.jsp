<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "12"; %>

<july:browseform action="/ShowMismatchList.do" styleId="MismatchListForm">

<script language="javascript">
function switchLookup(itemname,lookupname,disabled) {
	if(disabled) {
		document.all[itemname].className = 'editkoddisabled';
		document.all[itemname].disabled = true;
		document.all[itemname].readonly = true;
		document.all['lookupbtn_'+lookupname+'l'].disabled = true;
		document.all['lookupimg_'+lookupname+'l'].src='/images/lookup_disabled.gif';
	} else {
		document.all[itemname].className = 'editkodsearch';
		document.all[itemname].disabled = false;
		document.all[itemname].readonly = false;
		document.all['lookupbtn_'+lookupname+'l'].disabled = false;
		document.all['lookupimg_'+lookupname+'l'].src='/images/lookup.gif';
	}
}

function switchSupplierLookup(state) {
	if(state) {
		MismatchListForm.suppliercode.className = 'editkodsearch';
		MismatchListForm.suppliercode.disabled = false;
		document.all.lookupbtn_suppl.disabled = false;
		document.all.lookupimg_suppl.src='/images/lookup.gif';
	} else {
		MismatchListForm.suppliercode.className = 'editkoddisabled';
		MismatchListForm.suppliercode.disabled = true;
		document.all.lookupbtn_suppl.disabled = true;
		document.all.lookupimg_suppl.src='/images/lookup_disabled.gif';
	}
}
function switchOwner() {
	var that = MismatchListForm.ownercode;
	if(MismatchListForm.isowner[0].checked) {
		that.disabled=true;
		that.className = 'editdisabled';
	} else {
		that.disabled=false;
		that.className = 'editsearch';
	}
}
function switchStorage() {
<logic:equal name="MismatchListForm" property="useStorageCombo" value="true">
	if(document.all.isstorage[0].checked) {
		document.all.storagecode.className='editdisabled1';
	} else {
		document.all.storagecode.className='editsearch1';
	}
	document.all.storagecode.disabled=document.all.isstorage[0].checked;
</logic:equal>
<logic:notEqual name="MismatchListForm" property="useStorageCombo" value="true">
	switchLookup('storagecode','stor',document.all.isstorage[0].checked);
</logic:notEqual>
}
</script>

<july:selectableTable modelName="list" selectable="1" paramName="selID" styleClass="main" selectedClass="selected">

<july:separator colspan="<%= gColSpan %>" />

<TR class="normal">
 <TD colspan="<%= gColSpan %>">
 
    <table class="main">
    <tr>
		<td class="title"><bean:message key="label.mismatch.owner"/></td>
		<td class="title">
			<july:checkbox property="isowner" insertable="true" updatable="true" value="true" onclick="switchOwner();"/><html:hidden property="isowner" value="false"/><bean:message key="label.all"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	   		<july:select collection="owners" property="ownercode" insertable="true" updatable="true" styleClass="editsearch">
				<html:options collection="owners" property="organization" labelProperty="name"/>
			</july:select><july:searchbutton/>
			<script language="javascript">switchOwner();</script>
		</td>
    </tr>
    <tr>
		<td class="title"><bean:message key="label.mismatch.storage"/></td>
		<td class="title">
			<july:checkbox property="isstorage" insertable="true" updatable="true" value="true" onclick="switchStorage();"/><html:hidden property="isstorage" value="false"/><bean:message key="label.all"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<logic:equal name="MismatchListForm" property="useStorageCombo" value="true">
	   		<july:select collection="storages" property="storagecode" insertable="true" updatable="true" styleClass="search" style="width:400;">
				<html:options collection="storages" property="storageplace" labelProperty="name"/>
			</july:select>
</logic:equal>
<logic:notEqual name="MismatchListForm" property="useStorageCombo" value="true">
			<july:string property="storagecode" styleId="storagecode" size="5" insertable="true" updatable="true" styleClass="editkodsearch"/>
			<july:lookupbutton action="/ShowStorageLookupList.do" styleId="storl" fieldNames="storagecode;storagename" newWindowName="storagelookup"  insertable="true" updatable="true"/>
			<july:string size="35" property="storagename" styleId="storagename" insertable="false" updatable="false" />
</logic:notEqual>
			<script language="javascript">switchStorage();</script>
		</td>
	</tr>
	<tr>
		<td class="title"><bean:message key="label.mismatch.period"/></td>
		<td class="title">
			<bean:message key="label.assemblingp.datefrom"/> &nbsp;&nbsp;&nbsp; <july:date property="datefromstr" size="25" insertable="true" updatable="true"/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<bean:message key="label.assemblingp.dateto"/> &nbsp;&nbsp;&nbsp; <july:date property="datetostr" size="25" insertable="true" updatable="true"/>
		</td>
	</tr>
    <tr>
		<td class="title"><bean:message key="label.mismatch.supplier"/></td>
		<td class="title">
			<july:checkbox property="issupplier" insertable="true" updatable="true" value="true" onclick="switchSupplierLookup(!MismatchListForm.issupplier[0].checked);"/><html:hidden property="issupplier" value="false"/><bean:message key="label.all"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<july:string property="suppliercode" styleId="suppliercode" size="5" insertable="true" updatable="true" styleClass="editkodsearch" />
			<july:lookupbutton action="/ShowOrganizationLookupList.do" styleId="suppl" fieldNames="suppliercode;suppliername" newWindowName="organizationlookup" insertable="true" updatable="true" onclick="set_opt_params_suppl('?selisprovider=false&selisrenter=false&selissupplier=true');"/>
			<july:string size="35" property="suppliername" styleId="suppliername" insertable="false" updatable="false" />
			<script language="javascript">
				switchSupplierLookup(!MismatchListForm.issupplier[0].checked);
			</script>
		</td>
    </tr>
    </table>
    
  </TD>
</TR>

<july:separator colspan="<%= gColSpan %>" />

<tr class="title">
	<td colspan="<%= gColSpan %>">
		<table class="buttons">
		<tr class="title">
			<td class="buttons"><july:backbutton page="/main.do"/></td>
			<td class="navigator"><july:navigator/></td>
		</tr>
		</table>
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>" />

<!-- Table header -->
<tr class="title">
	<july:headercolumn key="label.void" colType="string"/>
	<july:headercolumn key="label.mismatch.ddate" colType="string"/>
	<july:headercolumn key="label.mismatch.dnum" colType="number"/>
	<july:sortcolumn key="label.external.date" colType="string" ascFinder="3" descFinder="4"/>
	<july:sortcolumn key="label.external.num" colType="string" ascFinder="1" descFinder="2"/>
	<july:headercolumn key="label.mismatch.accdate.1" colType="string"/>
	<july:sortcolumn key="label.external.accnum.1" colType="string" ascFinder="5" descFinder="6"/>
	<july:headercolumn key="label.mismatch.suppliername" colType="string"/>
	<july:headercolumn key="label.external.storage" colType="string"/>
	<july:headercolumn key="label.mismatch.text.short" colType="string"/>
	<td class="title">&nbsp;</td>
</tr>

<july:separator colspan="<%= gColSpan %>" />
    
<!-- Table body -->
<logic:iterate id="it" name="browseList" type="com.hps.july.cdbc.lib.CDBCRowObject">
<logic:present name="it">
<%
	boolean fileflag = "Y".equals(it.getColumn("fileflag").asString());
	String document = it.getColumn("document").asString();
	pageContext.setAttribute("document",it.getColumn("document").asString());
%>

<july:selectableTR styleId="<%=document%>" paramName="selID" selectable="true" styleClass="normal"  onmouseover="className='select'" onmouseout="className='normal'">

	<td class="text">
		<july:editbutton page="/EditMismatch.do" action="Edit" paramId="documentstr" paramName="it" paramProperty="document" paramScope="page" alttext="label.mismatch.edit"/>
		<july:anchor />
	</td>
	<td class="text" nowrap><july:datewrite name="it" property="dactdate"/></td>
	<td class="text"><july:stringwrite name="it" property="dactnumber"/></td>
	<td class="text" nowrap><july:datewrite name="it" property="blankdate"/></td>
	<td class="text"><july:stringwrite name="it" property="blankindex"/>&nbsp;<july:stringwrite name="it" property="blanknumber"/></td>
	<td class="text" nowrap><july:datewrite name="it" property="cordocdate"/></td>
	<td class="text"><july:stringwrite name="it" property="cordocnum"/></td>
	<td class="text"><july:stringwrite name="it" property="contragentname"/></td>
	<td class="text"><july:stringwrite name="it" property="toname"/></td>
	<td class="text">
		<%if(fileflag) {%>
		<html:link page="/MismatchDownload" paramId="document" paramName="document" paramScope="page" target="_blank"><bean:message key="label.mismatch.text.short"/></html:link>
		<%}%>
	</td>
	<td class="link">
		<july:delbutton page="/EditMismatch.do?action=Delete" paramId="documentstr" paramName="it" paramProperty="document" paramScope="page"/>
	</td>
</july:selectableTR>
<july:separator colspan="<%= gColSpan %>" />
</logic:present>
</logic:iterate>

<tr class="title">
	<td colspan="<%= gColSpan %>">
		<table class="buttons">
		<tr class="title">
			<TD class="buttons"><july:backbutton page="/main.do"/></td>
			<TD class="navigator"><july:navigator/></td>
		</tr>
		</table>
	</td>
</tr>
      
<july:separator colspan="<%= gColSpan %>" />
      
</july:selectableTable>

</july:browseform>
