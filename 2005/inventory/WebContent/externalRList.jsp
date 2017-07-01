<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "9"; %>

<%
	String masterTagId = "changeSListWordEditMasterTagId";
%>
<july:wordEditMaster styleId='<%= masterTagId %>' >
</july:wordEditMaster>

<july:browseform action="/ShowExternalRList.do" styleId="ExternalRListForm">

<script language="javascript">
function switchLookup(itemname,lookupname,disabled) {
	if(disabled) {
		ExternalRListForm[itemname].className = 'editkoddisabled';
		ExternalRListForm[itemname].disabled = true;
		ExternalRListForm[itemname].readonly = true;
		document.all['lookupbtn_'+lookupname+'l'].disabled = true;
		document.all['lookupimg_'+lookupname+'l'].src='/images/lookup_disabled.gif';
	} else {
		ExternalRListForm[itemname].className = 'editkodsearch';
		ExternalRListForm[itemname].disabled = false;
		ExternalRListForm[itemname].readonly = false;
		document.all['lookupbtn_'+lookupname+'l'].disabled = false;
		document.all['lookupimg_'+lookupname+'l'].src='/images/lookup.gif';
	}
}

function switchOwner() {
	if(ExternalRListForm.isowner[0].checked) {
		ExternalRListForm.ownercode.className='editdisabled';
	} else {
		ExternalRListForm.ownercode.className='editsearch';
	}
	ExternalRListForm.ownercode.disabled=ExternalRListForm.isowner[0].checked;
}

function switchStorage() {
<logic:equal name="ExternalRListForm" property="useStorageCombo" value="true">
	if(document.all.isstorage[0].checked) {
		document.all.storagecode.className='editdisabled1';
	} else {
		document.all.storagecode.className='editsearch1';
	}
	document.all.storagecode.disabled=document.all.isstorage[0].checked;
</logic:equal>
<logic:notEqual name="ExternalRListForm" property="useStorageCombo" value="true">
	switchLookup('storagecode','stor',document.all.isstorage[0].checked);
</logic:notEqual>
}

function switchRecipient() {
	if(ExternalRListForm.isrecipient[0].checked) {
		switchLookup('recipientcode','reci',true);
	} else {
		switchLookup('recipientcode','reci',false);
	}
}
function printWord(prompt1){
	window.location.href='reports/externalR.jsp?prompt1='+prompt1;
}
</script>

<july:selectableTable modelName="list" selectable="1" paramName="selID" styleClass="main" selectedClass="selected">
<%--<table class="main">--%>

<july:separator colspan="<%= gColSpan %>" />

<TR class="normal">
 <TD colspan="<%= gColSpan %>">
 
    <table class="find">
    <tr>
		<td class="title"><bean:message key="label.externalr.owner"/></td>
		<td class="title" colspan="2">
			<july:checkbox property="isowner" insertable="true" updatable="true" value="true" onclick="switchOwner();"/><html:hidden property="isowner" value="false"/><bean:message key="label.all"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	   		<july:select collection="owners" property="ownercode" insertable="true" updatable="true" styleClass="search">
				<html:options collection="owners" property="organization" labelProperty="name"/>
			</july:select><july:searchbutton/>
			<script language="javascript">switchOwner();</script>
		</td>
    </tr>
    <tr>
		<td class="title"><bean:message key="label.externalr.storage"/></td>
		<td class="title" colspan="2">
			<july:checkbox property="isstorage" insertable="true" updatable="true" value="true" onclick="switchStorage();"/><html:hidden property="isstorage" value="false"/><bean:message key="label.all"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<logic:equal name="ExternalRListForm" property="useStorageCombo" value="true">
	   		<july:select collection="storages" property="storagecode" insertable="true" updatable="true" styleClass="search" style="width:400;">
				<html:options collection="storages" property="storageplace" labelProperty="name"/>
			</july:select>
</logic:equal>
<logic:notEqual name="ExternalRListForm" property="useStorageCombo" value="true">
			<july:string property="storagecode" styleId="storagecode" size="5" insertable="true" updatable="true" styleClass="editkodsearch"/>
			<july:lookupbutton action="/ShowStorageLookupList.do" styleId="storl" fieldNames="storagecode;storagename" newWindowName="storagelookup"  insertable="true" updatable="true"/>
			<july:string size="35" property="storagename" styleId="storagename" insertable="false" updatable="false" />
</logic:notEqual>
			<script language="javascript">switchStorage();</script>
		</td>
	</tr>
	<tr>
		<td class="title"><bean:message key="label.externalr.date"/></td>
		<td class="title" colspan="2">
			<bean:message key="label.datefrom"/> &nbsp;&nbsp;&nbsp; <july:date property="datefromstr" size="25" insertable="true" updatable="true"/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<bean:message key="label.dateto"/> &nbsp;&nbsp;&nbsp; <july:date property="datetostr" size="25" insertable="true" updatable="true"/>
		</td>
	</tr>
    <tr>
		<td class="title"><bean:message key="label.externalr.recipient"/></td>
		<td class="title" colspan="2">
			<july:checkbox property="isrecipient" insertable="true" updatable="true" value="true" onclick="switchRecipient();"/><html:hidden property="isrecipient" value="false"/><bean:message key="label.all"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<july:string property="recipientcode" styleId="recipientcode" size="5" insertable="true" updatable="true" styleClass="editkodsearch"/>
			<july:lookupbutton action="/ShowOrganizationLookupList.do" styleId="recil" fieldNames="recipientcode;recipientname" newWindowName="recipientlookup"  insertable="true" updatable="true" onclick="set_opt_params_recil('?selisprovider=false&selisrenter=false&selissupplier=false');"/>
			<july:string size="35" property="recipientname" styleId="recipientname" insertable="false" updatable="false" />
			<script language="javascript">switchRecipient();</script>
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
			<TD class="buttons"><july:addbutton page="/EditExternalR.do?action=Add" alttext="label.externalr.add"/><july:backbutton page="/main.do"/></td>
			<TD class="navigator"><july:navigator/></td>
		</tr>
		</table>
	</td>
</tr>
        
<july:separator colspan="<%= gColSpan %>" />

<!-- Table header -->
<tr class="title">
	<july:headercolumn key="label.void" colType="number"/>
	<july:sortcolumn key="label.externalr.date" colType="string" ascFinder="3" descFinder="4"/>
	<july:sortcolumn key="label.num" colType="number" ascFinder="1" descFinder="2"/>
	<july:headercolumn key="label.externalr.owner" colType="number"/>
	<july:headercolumn key="label.externalr.expedition" colType="string"/>
	<july:headercolumn key="label.externalr.state" colType="string"/>
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
	pageContext.setAttribute("document",it.getColumn("document").asString());
	String theDocument = it.getColumn("document").asString();
%>

<tr selectableID='<july:stringwrite name="it" property="document"/>' classReal='<%=(isAutoDoc?"autodoc":"normal")%>' class='<%=(isAutoDoc?"autodoc":"normal")%>' id='selID<july:stringwrite name="it" property="document"/>' onMouseOver='className="select"' onMouseOut="className='<%=(isAutoDoc?"autodoc":"normal")%>'">

	<td class="text">
		<% if ("1".equals(docState) && !isAutoDoc) { %>
			<july:editbutton page="/EditExternalR.do" action="Edit" paramId="document" paramName="it" paramProperty="document" paramScope="page" alttext="label.externalr.edit"/>
		<% } else { %>
			<july:editbutton page="/EditExternalR.do" action="View" paramId="document" paramName="it" paramProperty="document" paramScope="page" alttext="label.externalr.view"/>
		<% } %>
		<a name="selID<july:stringwrite name="it" property="document"/>"></a>
	</td>
	<td class="text"><july:datewrite name="it" property="blankdate"/></td>
	<td class="text">
		<%-- <july:stringwrite name="it" property="blankindex"/>&nbsp; --%>
		<july:stringwrite name="it" property="blanknumber"/></td>
	<td class="text"><july:stringwrite name="it" property="ownername"/></td>
	<td class="text"><july:stringwrite name="it" property="toname"/></td>
	<td class="text">
		<% if ("1".equals(docState)) { %><bean:message key="label.state.entering"/><% } else { %><bean:message key="label.state.calculated"/><% } %>
	</td>
	<td class="link">
<%--
		<july:docprintbutton docstatebean="it" docstateproperty="docstate" href="/crystalclear/externalr.rpt?dll=pdsexternr.dll" paramId="prompt0" paramName="it" paramProperty="document" paramScope="page"/>
--%>
<%--
		<A href='javascript:printWord(<july:stringwrite name="it" property="document"/>)'>
			<img src="/images/print.gif" border=0 alt='Печать отчета word'>
		</A>
--%>		
		<july:wordEditSlave masterStyleId='<%= masterTagId %>' styleId='<%= "externalRList_" + theDocument %>' 
			url='<%= "reports/externalR.jsp?prompt1=" + theDocument %>' 
			uploadurl=''
			updatable='false'
			documentid='<%= theDocument %>'>
			<IMG SRC="/images/docword.gif" border="0" alt='Печать отчета word'>
		</july:wordEditSlave>
	</td>
	<td class="link">
		<% if ("1".equals(docState) && !isAutoDoc) { %>
			<july:delbutton page="/EditExternalR.do?action=Delete" paramId="document" paramName="it" paramProperty="document" paramScope="page"/>
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
			<TD class="buttons"><july:addbutton page="/EditExternalR.do?action=Add"  alttext="label.externalr.add"/><july:backbutton page="/main.do"/></td>
			<TD class="navigator"><july:navigator/></td>
		</tr>
		</table>
	</td>
</tr>
      
<july:separator colspan="<%= gColSpan %>" />
      
<tr class="title">
	<td class="title" colspan="<%= gColSpan %>">
		<july:currmark><bean:message key="label.externalr"/></july:currmark>
	</td>
</tr>

</july:selectableTable>

</july:browseform>
