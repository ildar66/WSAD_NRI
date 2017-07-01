<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "11"; %>

<%
	String masterTagId = "changeSListWordEditMasterTagId";
%>
<july:wordEditMaster styleId='<%= masterTagId %>' >
</july:wordEditMaster>

<july:browseform action="/ShowInternalRList.do" styleId="InternalRListForm">

<script language="javascript">
function switchLookup(itemname,lookupname,disabled) {
	if(disabled) {
		InternalRListForm[itemname].className = 'editkoddisabled';
		InternalRListForm[itemname].disabled = true;
		InternalRListForm[itemname].readonly = true;
		document.all['lookupbtn_'+lookupname+'l'].disabled = true;
		document.all['lookupimg_'+lookupname+'l'].src='/images/lookup_disabled.gif';
	} else {
		InternalRListForm[itemname].className = 'editkodsearch';
		InternalRListForm[itemname].disabled = false;
		InternalRListForm[itemname].readonly = false;
		document.all['lookupbtn_'+lookupname+'l'].disabled = false;
		document.all['lookupimg_'+lookupname+'l'].src='/images/lookup.gif';
	}
}

function switchFilter() {
	if(InternalRListForm.type[0].checked) {
		switchLookup('rentercode','org',true);
		switchLookup('workercode','work',true);
		InternalRListForm['rentername'].disabled = true;
		InternalRListForm['workername'].disabled = true;
		InternalRListForm['workertitle'].disabled = true;
	} else if(InternalRListForm.type[1].checked) {
		switchLookup('rentercode','org',false);
		switchLookup('workercode','work',true);
		InternalRListForm['rentername'].disabled = false;
		InternalRListForm['workername'].disabled = true;
		InternalRListForm['workertitle'].disabled = true;
	} else if(InternalRListForm.type[2].checked) {
		switchLookup('rentercode','org',true);
		switchLookup('workercode','work',false);
		InternalRListForm['rentername'].disabled = true;
		InternalRListForm['workername'].disabled = false;
		InternalRListForm['workertitle'].disabled = false;
	} else {
		switchLookup('rentercode','org',false);
		switchLookup('workercode','work',false);
		InternalRListForm['rentername'].disabled = false;
		InternalRListForm['workername'].disabled = false;
		InternalRListForm['workertitle'].disabled = false;
	}
}

function switchOwner() {
	if(InternalRListForm.isowner[0].checked) {
		InternalRListForm.ownercode.className='editdisabled';
	} else {
		InternalRListForm.ownercode.className='editsearch';
	}
	InternalRListForm.ownercode.disabled=InternalRListForm.isowner[0].checked;
}

function switchStorage() {
<logic:equal name="InternalRListForm" property="useStorageCombo" value="true">
	if(document.all.isstorage[0].checked) {
		document.all.storagecode.className='editdisabled1';
	} else {
		document.all.storagecode.className='editsearch1';
	}
	document.all.storagecode.disabled=document.all.isstorage[0].checked;
</logic:equal>
<logic:notEqual name="InternalRListForm" property="useStorageCombo" value="true">
	switchLookup('storagecode','stor',document.all.isstorage[0].checked);
</logic:notEqual>
}
function printWord(prompt1){
	window.location.href='reports/internalR.jsp?prompt1='+prompt1;
}
</script>

<july:selectableTable modelName="list" selectable="1" paramName="selID" styleClass="main" selectedClass="selected">

<july:separator colspan="<%= gColSpan %>" />

<TR class="normal">
 <TD colspan="<%= gColSpan %>">
 
    <table class="find">
    <tr>
		<td class="title"><bean:message key="label.internalr.owner"/></td>
		<td class="title" colspan="2">
			<july:checkbox property="isowner" insertable="true" updatable="true" value="true" onclick="switchOwner();"/><html:hidden property="isowner" value="false"/><bean:message key="label.all"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	   		<july:select collection="owners" property="ownercode" insertable="true" updatable="true" styleClass="search">
				<html:options collection="owners" property="organization" labelProperty="name"/>
			</july:select><july:searchbutton/>
			<script language="javascript">switchOwner();</script>
		</td>
    </tr>
    <tr>
		<td class="title"><bean:message key="label.internalr.storage"/></td>
		<td class="title" colspan="2">
			<july:checkbox property="isstorage" insertable="true" updatable="true" value="true" onclick="switchStorage();"/><html:hidden property="isstorage" value="false"/><bean:message key="label.all"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<logic:equal name="InternalRListForm" property="useStorageCombo" value="true">
	   		<july:select collection="storages" property="storagecode" insertable="true" updatable="true" styleClass="search" style="width:400;">
				<html:options collection="storages" property="storageplace" labelProperty="name"/>
			</july:select>
</logic:equal>
<logic:notEqual name="InternalRListForm" property="useStorageCombo" value="true">
			<july:string property="storagecode" styleId="storagecode" size="5" insertable="true" updatable="true" styleClass="editkodsearch"/>
			<july:lookupbutton action="/ShowStorageLookupList.do" styleId="storl" fieldNames="storagecode;storagename" newWindowName="storagelookup"  insertable="true" updatable="true"/>
			<july:string size="35" property="storagename" styleId="storagename" insertable="false" updatable="false" />
</logic:notEqual>
			<script language="javascript">switchStorage();</script>
		</td>
	</tr>
	<tr>
		<td class="title"><bean:message key="label.internalr.date"/></td>
		<td class="title" colspan="2">
			<bean:message key="label.datefrom"/> &nbsp;&nbsp;&nbsp; <july:date property="datefromstr" size="25" insertable="true" updatable="true"/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<bean:message key="label.dateto"/> &nbsp;&nbsp;&nbsp; <july:date property="datetostr" size="25" insertable="true" updatable="true"/>
		</td>
	</tr>
	<tr>
		<td class="title"><bean:message key="label.internalr.type"/></td>
		<td class="title" colspan="2">
			<july:radio insertable="true" updatable="true" property="type" value="A" onclick="switchFilter();"/><bean:message key="label.all"/>
			<july:radio insertable="true" updatable="true" property="type" value="P" onclick="switchFilter();"/><bean:message key="label.internalr.type.forp"/>
			<july:radio insertable="true" updatable="true" property="type" value="W" onclick="switchFilter();"/><bean:message key="label.internalr.type.forw"/>
		</td>
	</tr>
    <tr>
		<td class="title"><bean:message key="label.internalr.renter"/></td>
		<td class="title" colspan="2">
			<july:string property="rentercode" styleId="rentercode" size="5" insertable="true" updatable="true" styleClass="editkodsearch"/>
			<july:lookupbutton action="/ShowOrganizationLookupList.do" styleId="orgl" fieldNames="rentercode;rentername" newWindowName="organizationlookup"  insertable="true" updatable="true" onclick="set_opt_params_orgl('?selisprovider=true&selisrenter=false&selissupplier=false');" />
			<july:string size="35" property="rentername" styleId="rentername" insertable="false" updatable="false" />
		</td>
    </tr>
    <tr>
		<td class="title"><bean:message key="label.internalr.worker"/></td>
		<td class="title" colspan="2">
			<july:string property="workercode" styleId="workercode" size="5" insertable="true" updatable="true"  styleClass="editkodsearch" />
			<july:lookupbutton action="/ShowWorkerLookupList.do" styleId="workl" fieldNames="workercode;workername;workertitle" newWindowName="workerlookup" insertable="true" updatable="true" />
			<july:string size="25" property="workername" styleId="workername" insertable="false" updatable="false" />
			<july:string size="20" property="workertitle" styleId="workertitle" insertable="false" updatable="false" />
		</td>
    </tr>
    </table>
	<script language="javascript">
    switchFilter();
  </script>
    
  </TD>
</TR>

<july:separator colspan="<%= gColSpan %>" />

<tr class="title">
	<td colspan="<%= gColSpan %>">
		<table class="buttons">
		<tr class="title">
			<TD class="buttons"><july:addbutton page="/EditInternalR.do?action=Add" alttext="label.internalr.add"/><july:backbutton page="/main.do"/></td>
			<TD class="navigator"><july:navigator/></td>
		</tr>
		</table>
	</td>
</tr>
        
<july:separator colspan="<%= gColSpan %>" />

<!-- Table header -->
<tr class="title">
	<july:headercolumn key="label.void" colType="number"/>
<july:sortcolumn key="label.internalr.date" colType="string" ascFinder="3" descFinder="4"/>
<july:sortcolumn key="label.num" colType="number" ascFinder="1" descFinder="2"/>
	<july:headercolumn key="label.internalr.org" colType="string"/>
	<july:headercolumn key="label.internalr.expedition" colType="string"/>
	<july:headercolumn key="label.internalr.position" colType="string"/>
	<july:headercolumn key="label.internalr.state" colType="string"/>
	<july:headercolumn key="label.void" colType="string"/>
	<july:headercolumn key="label.void" colType="string"/>
</tr>

<july:separator colspan="<%= gColSpan %>" />

<!-- Table body -->
<logic:iterate id="it" name="browseList" type="com.hps.july.cdbc.lib.CDBCRowObject">
<logic:present name="it">
<%
      boolean isAutoDoc = "Y".equals(it.getColumn("isautodoc").asString());
      String docState = it.getColumn("docstate").asString();
	  String theDocument = it.getColumn("document").asString();
%>

<tr selectableID='<july:stringwrite name="it" property="document"/>' classReal='<%=(isAutoDoc?"autodoc":"normal")%>' class='<%=(isAutoDoc?"autodoc":"normal")%>' id='selID<july:stringwrite name="it" property="document"/>' onMouseOver='className="select"' onMouseOut="className='<%=(isAutoDoc?"autodoc":"normal")%>'">

			<td class="text">
				<% if ("1".equals(docState) && !isAutoDoc) { %>
					<july:editbutton page="/EditInternalR.do" action="Edit" paramId="document" paramName="it" paramProperty="document" paramScope="page" alttext="label.internalr.edit"/>
				<% } else { %>
					<july:editbutton page="/EditInternalR.do" action="View" paramId="document" paramName="it" paramProperty="document" paramScope="page" alttext="label.internalr.view"/>
				<% } %>
				<a name="selID<july:stringwrite name="it" property="document"/>"></a>
			</td>
			<td class="text">
				<july:datewrite name="it" property="blankdate"/>
			</td>
			<td class="text">
				<%-- <july:stringwrite name="it" property="blankindex"/>&nbsp; --%>
				<july:stringwrite name="it" property="blanknumber"/>
			</td>
			<td class="text">
				<july:stringwrite name="it" property="ownername"/>
			</td>
			<td class="text">
				<july:stringwrite name="it" property="toname"/>
			</td>
			<td class="text">
				<july:stringwrite name="it" property="posname"/>
			</td>
			<td class="text">
				<% if ("1".equals(docState)) { %><bean:message key="label.state.entering"/><% } else { %><bean:message key="label.state.calculated"/><% } %>
			</td>
			<td class="link">
<%--
				<july:docprintbutton docstatebean="it" docstateproperty="docstate" href="/crystalclear/internalr.rpt?dll=pdsinternr.dll" paramId="prompt0" paramName="it" paramProperty="document" paramScope="page"/>
--%>
<%--
				<A href='javascript:printWord(<july:stringwrite name="it" property="document"/>)'>
					<img src="/images/print.gif" border=0 alt='Печать отчета word'>
				</A>
--%>				
		<july:wordEditSlave masterStyleId='<%= masterTagId %>' styleId='<%= "internalRList_" + theDocument %>' 
			url='<%= "reports/internalR.jsp?prompt1=" + theDocument %>' 
			uploadurl=''
			updatable='false'
			documentid='<%= theDocument %>'>
			<IMG SRC="/images/docword.gif" border="0" alt='Печать отчета word'>
		</july:wordEditSlave>
			</td>
			<td class="link">
				<% if ("1".equals(docState) && !isAutoDoc) { %>
					<july:delbutton page="/EditInternalR.do?action=Delete" paramId="document" paramName="it" paramProperty="document" paramScope="page"/>
				<% } %>
			</td>
		</tr>

		<july:separator colspan="<%= gColSpan %>" />

	</logic:present>
</logic:iterate>

<tr class="title">
	<td colspan="<%= gColSpan %>">
		<table class="buttons">
		<tr class="title">
			<TD class="buttons"><july:addbutton page="/EditInternalR.do?action=Add" alttext="label.internalr.add"/><july:backbutton page="/main.do"/></td>
			<TD class="navigator"><july:navigator/></td>
		</tr>
		</table>
	</td>
</tr>
      
<july:separator colspan="<%= gColSpan %>" />
 
</july:selectableTable>

</july:browseform>
