<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "13"; %>

<%
	String masterTagId = "changeSListWordEditMasterTagId";
%>
<july:wordEditMaster styleId='<%= masterTagId %>' >
</july:wordEditMaster>

<july:browseform action="/ShowExternalList.do" styleId="ExternalListForm">

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
		ExternalListForm.suppliercode.className = 'editkodsearch';
		ExternalListForm.suppliercode.disabled = false;
		ExternalListForm.suppliername.disabled = false;
		document.all.lookupbtn_orgl.disabled = false;
		document.all.lookupimg_orgl.src='/images/lookup.gif';
	} else {
		ExternalListForm.suppliercode.className = 'editkoddisabled';
		ExternalListForm.suppliercode.disabled = true;
		ExternalListForm.suppliername.disabled = true;
		document.all.lookupbtn_orgl.disabled = true;
		document.all.lookupimg_orgl.src='/images/lookup_disabled.gif';
	}
}
function switchOwner() {
	if(ExternalListForm.isowner[0].checked) {
		ExternalListForm.ownercode.disabled=true;
		ExternalListForm.ownercode.className = 'editdisabled';
	} else {
		ExternalListForm.ownercode.disabled=false;
		ExternalListForm.ownercode.className = 'editsearch';
	}
}
function switchStorage() {
<logic:equal name="ExternalListForm" property="useStorageCombo" value="true">
	if(document.all.isstorage[0].checked) {
		document.all.storagecode.className='editdisabled1';
	} else {
		document.all.storagecode.className='editsearch1';
	}
	document.all.storagecode.disabled=document.all.isstorage[0].checked;
</logic:equal>
<logic:notEqual name="ExternalListForm" property="useStorageCombo" value="true">
	switchLookup('storagecode','stor',document.all.isstorage[0].checked);
</logic:notEqual>
}
function switchCordocnum() {
	if(ExternalListForm.iscordocnum[0].checked) {
		ExternalListForm.cordocnum.disabled=true;
		ExternalListForm.cordocnum.className = 'editdisabled';
	} else {
		ExternalListForm.cordocnum.disabled=false;
		ExternalListForm.cordocnum.className = 'editsearch';
	}
}
function printWord(prompt1){
	window.location.href='reports/inWayBill.jsp?prompt1='+prompt1;
}
</script>

<july:selectableTable modelName="list" selectable="1" paramName="selID" styleClass="main" selectedClass="selected">
<%--<table class="main">--%>

<july:separator colspan="<%= gColSpan %>" />
<TR class="normal">
 <TD colspan="<%= gColSpan %>">
 
    <table class="find">
    <tr>
		<td class="title"><bean:message key="label.external.owner"/></td>
		<td class="title">
			<july:checkbox property="isowner" insertable="true" updatable="true" value="true" onclick="switchOwner();"/><html:hidden property="isowner" value="false"/><bean:message key="label.all"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	   		<july:select collection="owners" property="ownercode" insertable="true" updatable="true" styleClass="editsearch">
				<html:options collection="owners" property="organization" labelProperty="name"/>
			</july:select><july:searchbutton/>
			<script language="javascript">switchOwner();</script>
		</td>
    </tr>
    <tr>
		<td class="title"><bean:message key="label.external.storage"/></td>
		<td class="title">
			<july:checkbox property="isstorage" insertable="true" updatable="true" value="true" onclick="switchStorage();"/><html:hidden property="isstorage" value="false"/><bean:message key="label.all"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<logic:equal name="ExternalListForm" property="useStorageCombo" value="true">
	   		<july:select collection="storages" property="storagecode" insertable="true" updatable="true" styleClass="search" style="width:400;">
				<html:options collection="storages" property="storageplace" labelProperty="name"/>
			</july:select>
</logic:equal>
<logic:notEqual name="ExternalListForm" property="useStorageCombo" value="true">
			<july:string property="storagecode" styleId="storagecode" size="5" insertable="true" updatable="true" styleClass="editkodsearch"/>
			<july:lookupbutton action="/ShowStorageLookupList.do" styleId="storl" fieldNames="storagecode;storagename" newWindowName="storagelookup"  insertable="true" updatable="true"/>
			<july:string size="35" property="storagename" styleId="storagename" insertable="false" updatable="false" />
</logic:notEqual>
			<script language="javascript">switchStorage();</script>
		</td>
	</tr>
	<tr>
		<td class="title"><bean:message key="label.external.period"/></td>
		<td class="title">
			<bean:message key="label.assemblingp.datefrom"/> &nbsp;&nbsp;&nbsp; <july:date property="datefromstr" size="25" insertable="true" updatable="true"/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<bean:message key="label.assemblingp.dateto"/> &nbsp;&nbsp;&nbsp; <july:date property="datetostr" size="25" insertable="true" updatable="true"/>
		</td>
	</tr>
    <tr>
		<td class="title"><bean:message key="label.external.supplier"/></td>
		<td class="title">
			<july:checkbox property="issupplier" insertable="true" updatable="true" value="true" onclick="switchSupplierLookup(!ExternalListForm.issupplier[0].checked);"/><html:hidden property="issupplier" value="false"/><bean:message key="label.all"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<july:string property="suppliercode" styleId="suppliercode" size="5" insertable="true" updatable="true" styleClass="editkodsearch"/>
			<july:lookupbutton action="/ShowOrganizationLookupList.do" styleId="orgl" fieldNames="suppliercode;suppliername" newWindowName="organizationlookup"  insertable="true" updatable="true" onclick="set_opt_params_orgl('?selissupplier=true&selisrenter=false&selissupplier=false');" />
			<july:string size="35" property="suppliername" styleId="suppliername" insertable="false" updatable="false" />
			<script language="javascript">
				switchSupplierLookup(!ExternalListForm.issupplier[0].checked);
			</script>
		</td>
    </tr>
    <tr>
		<td class="title"><bean:message key="label.external.accnum"/></td>
		<td class="title">
			<july:checkbox property="iscordocnum" insertable="true" updatable="true" value="true" onclick="switchCordocnum();"/><html:hidden property="iscordocnum" value="false"/><bean:message key="label.all"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<july:string property="cordocnum" styleId="cordocnum" size="5" insertable="true" updatable="true" styleClass="editkodsearch"/>
			<script language="javascript">switchCordocnum();</script>
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
		<TD class="buttons"><july:addbutton page="/EditExternal.do?action=Add" alttext="label.external.add"/><july:backbutton page="/main.do"/></td>
		<TD class="navigator"><july:navigator/></td>
	</tr>
	</table>
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>" />

<!-- Table header -->
<tr class="title">
	<july:headercolumn key="label.void" colType="string"/>
	<july:sortcolumn key="label.external.date" colType="string" ascFinder="3" descFinder="4"/>
	<july:sortcolumn key="label.external.num" colType="string" ascFinder="1" descFinder="2"/>
	<july:headercolumn key="label.external.accdate.1" colType="string"/>
	<july:sortcolumn key="label.external.accnum.1" colType="string" ascFinder="5" descFinder="6"/>
	<july:headercolumn key="label.external.suppliername" colType="string"/>
	<july:headercolumn key="label.external.storage" colType="string"/>
	<july:headercolumn key="label.external.state" colType="string"/>
	<july:headercolumn key="label.void" colType="string"/>
	<july:headercolumn key="label.mismatch.short" colType="string"/>
	<td class="title">&nbsp;</td>
</tr>

<july:separator colspan="<%= gColSpan %>" />
    
<!-- Table body -->
<logic:iterate id="it" name="browseList" type="com.hps.july.cdbc.lib.CDBCRowObject">
<logic:present name="it">
<%
	String docState = it.getColumn("state").asString();
	String document = it.getColumn("document").asString();
	pageContext.setAttribute("document",document);
%>

 <july:selectableTR styleId="<%=document%>" paramName="selID" selectable="true" styleClass="normal"  onmouseover="className='select'" onmouseout="className='normal'">

<%--<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">--%>
	<td class="text">
		<%if("1".equals(docState)) {%>
			<july:editbutton page="/EditExternal.do" action="Edit" paramId="document" paramName="it" paramProperty="document" paramScope="page" alttext="label.external.edit"/>
		<%} else {%>
			<july:editbutton page="/EditExternal.do" action="View" paramId="document" paramName="it" paramProperty="document" paramScope="page" alttext="label.external.view"/>
		<%}%>
		<july:anchor />
	</td>
	<td class="text"><july:datewrite name="it" property="blankdate"/></td>
	<td class="text">
		<%-- <july:stringwrite name="it" property="blankindex"/>&nbsp; --%>
		<july:stringwrite name="it" property="blanknumber"/>
	</td>
	<td class="text"><july:datewrite name="it" property="cordocdate"/></td>
	<td class="text"><july:stringwrite name="it" property="cordocnum" wrapat="12"/></td>
	<td class="text"><july:stringwrite name="it" property="contragentname"/></td>
	<td class="text"><july:stringwrite name="it" property="toname"/></td>
	<td class="text">
<% if ("1".equals(docState)) { %><bean:message key="label.state.entering"/><% } else { %><bean:message key="label.state.calculated"/><% } %>
<%--
		<html:link page="/EditExternalState.do?action=Edit" paramId="doc" paramName="document" paramScope="page">
			<% if ("1".equals(docState)) { %><bean:message key="label.state.entering"/><% } else { %><bean:message key="label.state.calculated"/><% } %>
		</html:link>
--%>
	</td>
<%--
	<td class="link">
		<html:link page="/ShowExternalPositionList.do" paramId="document" paramName="document" paramScope="page"><img src="/images/doc.gif" width=22 height=16 border=0 alt="<bean:message key="label.external.positions"/>"></html:link>
	</td>
--%>
	<td class="link">
<%--
		<july:docprintbutton docstatebean="it" docstateproperty="state" href="/crystalclear/external.rpt?dll=pdsinwaybill.dll" paramId="prompt0" paramName="it" paramProperty="document" paramScope="page"/>
--%>
<%--
		<A href='javascript:printWord(<july:stringwrite name="it" property="document"/>)'>
			<img src="/images/print.gif" border=0 alt='Печать отчета word'>
		</A>
--%>
		<july:wordEditSlave masterStyleId='<%= masterTagId %>' styleId='<%= "demountList_" + document %>' 
			url='<%= "reports/inWayBill.jsp?prompt1=" + document %>' 
			uploadurl=''
			updatable='false'
			documentid='<%= document %>'>
			<IMG SRC="/images/docword.gif" border="0" alt='Печать отчета word'>
		</july:wordEditSlave>
	</td>
	<td class="link">
		<%if("2".equals(docState)) {%>
			<%if(it.getColumn("dactnumber").asObject() == null) {%>
			<html:link page="/EditExternalMismatch.do?action=Add" paramId="documentstr" paramName="document" paramScope="page"><bean:message key="label.create"/></html:link>
			<%} else {%>
			<html:link page="/EditExternalMismatch.do?action=View" paramId="documentstr" paramName="document" paramScope="page">№<july:stringwrite name="it" property="dactnumber"/></html:link>
			<%}%>
		<%} else {%>
			<%if(it.getColumn("dactnumber").asObject() != null) {%>
			<html:link page="/EditExternalMismatch.do?action=View" paramId="documentstr" paramName="document" paramScope="page">№<july:stringwrite name="it" property="dactnumber"/></html:link>
			<%}%>
		<%}%>
	</td>
	<td class="link">
		<%if ("1".equals(docState)) {%>
			<july:delbutton page="/EditExternal.do?action=Delete" paramId="document" paramName="it" paramProperty="document" paramScope="page"/>
		<%}%>
	</td>
</july:selectableTR>
<july:separator colspan="<%= gColSpan %>" />
</logic:present>
</logic:iterate>

<tr class="title">
	<td colspan="<%= gColSpan %>">
		<table class="buttons">
		<tr class="title">
			<TD class="buttons"><july:addbutton page="/EditExternal.do?action=Add" alttext="label.external.add"/><july:backbutton page="/main.do"/></td>
			<TD class="navigator"><july:navigator/></td>
		</tr>
		</table>
	</td>
</tr>
      
<july:separator colspan="<%= gColSpan %>" />
      

</july:selectableTable>

</july:browseform>
