<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "8"; %>

<%
	String masterTagId = "changeSListWordEditMasterTagId";
%>
<july:wordEditMaster styleId='<%= masterTagId %>' >
</july:wordEditMaster>

<july:browseform action="/ShowInternalList.do" styleId="InternalListForm">

<script language="javascript">
function switchLookup(itemname,lookupname,disabled) {
	if(disabled) {
		InternalListForm[itemname].className = 'editkoddisabled';
		InternalListForm[itemname].disabled = true;
		InternalListForm[itemname].readonly = true;
		document.all['lookupbtn_'+lookupname+'l'].disabled = true;
		document.all['lookupimg_'+lookupname+'l'].src='/images/lookup_disabled.gif';
	} else {
		InternalListForm[itemname].className = 'editkodsearch';
		InternalListForm[itemname].disabled = false;
		InternalListForm[itemname].readonly = false;
		document.all['lookupbtn_'+lookupname+'l'].disabled = false;
		document.all['lookupimg_'+lookupname+'l'].src='/images/lookup.gif';
	}
}

function switchFilter() {
	if(InternalListForm.type[0].checked) {
		switchLookup('rentercode','rent',true);
		switchLookup('workercode','work',true);
		InternalListForm['rentername'].disabled = true;
		InternalListForm['workername'].disabled = true;
		InternalListForm['workertitle'].disabled = true;
	} else if(InternalListForm.type[1].checked) {
		switchLookup('rentercode','rent',false);
		switchLookup('workercode','work',true);
		InternalListForm['rentername'].disabled = false;
		InternalListForm['workername'].disabled = true;
		InternalListForm['workertitle'].disabled = true;
	} else if(InternalListForm.type[2].checked) {
		switchLookup('rentercode','rent',true);
		switchLookup('workercode','work',false);
		InternalListForm['rentername'].disabled = true;
		InternalListForm['workername'].disabled = false;
		InternalListForm['workertitle'].disabled = false;
	} else {
		switchLookup('rentercode','rent',false);
		switchLookup('workercode','work',false);
		InternalListForm['rentername'].disabled = false;
		InternalListForm['workername'].disabled = false;
		InternalListForm['workertitle'].disabled = false;
	}
}

function switchOwner() {
	if(InternalListForm.isowner[0].checked) {
		InternalListForm.ownercode.className='editdisabled';
	} else {
		InternalListForm.ownercode.className='editsearch';
	}
	InternalListForm.ownercode.disabled=InternalListForm.isowner[0].checked;
}

function switchStorage() {
<logic:equal name="InternalListForm" property="useStorageCombo" value="true">
	if(InternalListForm.isstorage[0].checked) {
		InternalListForm.storagecode.className='editdisabled1';
	} else {
		InternalListForm.storagecode.className='editsearch1';
	}
	InternalListForm.storagecode.disabled=InternalListForm.isstorage[0].checked;
</logic:equal>
<logic:notEqual name="InternalListForm" property="useStorageCombo" value="true">
	switchLookup('storagecode','stor',InternalListForm.isstorage[0].checked);
</logic:notEqual>
}
function printWord(prompt1){
	window.location.href='reports/internal.jsp?prompt1='+prompt1;
}
</script>
<july:selectableTable modelName="list" selectable="1" paramName="selID" styleClass="main" selectedClass="selected">

<july:separator colspan="<%= gColSpan %>" />

<TR class="normal">
 <TD colspan="<%= gColSpan %>">
 
    <table class="find">
    <tr>
		<td class="title"><bean:message key="label.internal.owner"/></td>
		<td class="title" colspan="2">
			<july:checkbox property="isowner" insertable="true" updatable="true" value="true" onclick="switchOwner();"/><html:hidden property="isowner" value="false"/><bean:message key="label.all"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	   		<july:select collection="owners" property="ownercode" insertable="true" updatable="true" styleClass="search">
				<html:options collection="owners" property="organization" labelProperty="name"/>
			</july:select><july:searchbutton/>
			<script language="javascript">
				switchOwner();
			</script>
		</td>
    </tr>
    <tr>
		<td class="title"><bean:message key="label.internal.storage"/></td>
		<td class="title" colspan="2">
			<july:checkbox property="isstorage" insertable="true" updatable="true" value="true" onclick="switchStorage();"/><html:hidden property="isstorage" value="false"/><bean:message key="label.all"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<logic:equal name="InternalListForm" property="useStorageCombo" value="true">
	   		<july:select collection="storages" property="storagecode" insertable="true" updatable="true" styleClass="search" style="width:400;">
				<html:options collection="storages" property="storageplace" labelProperty="name"/>
			</july:select>
</logic:equal>
<logic:notEqual name="InternalListForm" property="useStorageCombo" value="true">
			<july:string property="storagecode" styleId="storagecode" size="5" insertable="true" updatable="true" styleClass="editkodsearch"/>
			<july:lookupbutton action="/ShowStorageLookupList.do" styleId="storl" fieldNames="storagecode;storagename" newWindowName="storagelookup"  insertable="true" updatable="true"/>
			<july:string size="35" property="storagename" styleId="storagename" insertable="false" updatable="false" />
</logic:notEqual>
			<script language="javascript">switchStorage();</script>
		</td>
	</tr>
	<tr>
		<td class="title"><bean:message key="label.internal.date"/></td>
		<td class="title" colspan="2">
			<bean:message key="label.datefrom"/>&nbsp;<july:date property="datefromstr" size="25" insertable="true" updatable="true"/>&nbsp;&nbsp;&nbsp;<bean:message key="label.dateto"/>&nbsp;<july:date property="datetostr" size="25" insertable="true" updatable="true"/>
		</td>
	</tr>
	<tr>
		<td class="title"><bean:message key="label.internal.type"/></td>
		<td class="title" colspan="2">
			<july:radio insertable="true" updatable="true" property="type" value="A" onclick="switchFilter();"/><bean:message key="label.all"/>
			<july:radio insertable="true" updatable="true" property="type" value="P" onclick="switchFilter();"/><bean:message key="label.internal.type.forp"/>
			<july:radio insertable="true" updatable="true" property="type" value="W" onclick="switchFilter();"/><bean:message key="label.internal.type.forw"/>
		</td>
	</tr>
    <tr>
		<td class="title"><bean:message key="label.internal.renter"/></td>
		<td class="title" colspan="2">
			<july:string property="rentercode" styleId="rentercode" size="5" insertable="true" updatable="true" styleClass="editkodsearch"/>
			<july:lookupbutton action="/ShowOrganizationLookupList.do" styleId="rentl" fieldNames="rentercode;rentername" newWindowName="organizationlookup"  insertable="true" updatable="true" onclick="set_opt_params_rentl('?selisprovider=true&selisrenter=false&selissupplier=false');"/>
			<july:string size="35" property="rentername" styleId="rentername" insertable="false" updatable="false" />
		</td>
    </tr>
    <tr>
		<td class="title"><bean:message key="label.internal.worker"/></td>
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
			<TD class="buttons"><july:addbutton page="/EditInternal.do?action=Add" alttext="label.internal.add"/><july:backbutton page="/main.do"/></td>
			<TD class="navigator"><july:navigator/></td>
		</tr>
		</table>
	</td>
</tr>
        
<july:separator colspan="<%= gColSpan %>" />

<!-- Table header -->
<tr class="title">
	<july:headercolumn key="label.void" colType="number"/>
<july:sortcolumn key="label.internal.date" colType="string" ascFinder="3" descFinder="4"/>
<july:sortcolumn key="label.num" colType="number" ascFinder="1" descFinder="2"/>
	<july:headercolumn key="label.internal.expedition" colType="string"/>
	<july:headercolumn key="label.internal.state" colType="string"/>
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

		<%--<tr class='<%=(isAutoDoc?"autodoc":"normal")%>' onMouseOver="className='select'" onMouseOut="className='<%=(isAutoDoc?"autodoc":"normal")%>'">--%>

			<td class="text">
			<% if ("1".equals(docState) && !isAutoDoc) { %>
			<july:editbutton page="/EditInternal.do" action="Edit" paramId="document" paramName="it" paramProperty="document" paramScope="page" alttext='label.internal.edit'/>
			<% } else { %>
			<july:editbutton page="/EditInternal.do" action="View" paramId="document" paramName="it" paramProperty="document" paramScope="page" alttext='label.internal.view'/>
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
				<july:stringwrite name="it" property="fromname"/>
			</td>
			<td class="text">
				<% if ("1".equals(docState)) { %><bean:message key="label.state.entering"/><% } else { %><bean:message key="label.state.calculated"/><% } %>
			</td>
			<td class="link">
<%--
				<july:docprintbutton docstatebean="it" docstateproperty="docstate" href="/crystalclear/internal.rpt?dll=pdsintern.dll" paramId="prompt0" paramName="it" paramProperty="document" paramScope="page"/>
--%>
<%--
				<A href='javascript:printWord(<july:stringwrite name="it" property="document"/>)'>
					<img src="/images/print.gif" border=0 alt='Печать отчета word'>
				</A>
--%>				
		<july:wordEditSlave masterStyleId='<%= masterTagId %>' styleId='<%= "internalList_" + theDocument %>' 
			url='<%= "reports/internal.jsp?prompt1=" + theDocument %>' 
			uploadurl=''
			updatable='false'
			documentid='<%= theDocument %>'>
			<IMG SRC="/images/docword.gif" border="0" alt='Печать отчета word'>
		</july:wordEditSlave>
			</td>
			<td class="link">
				<% if ("1".equals(docState) && !isAutoDoc) { %>
					<july:delbutton page="/EditInternal.do?action=Delete" paramId="document" paramName="it" paramProperty="document" paramScope="page"/>
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
			<TD class="buttons"><july:addbutton page="/EditInternal.do?action=Add" alttext="label.internal.add"/><july:backbutton page="/main.do"/></td>
			<TD class="navigator"><july:navigator/></td>
		</tr>
		</table>
	</td>
</tr>
      
<july:separator colspan="<%= gColSpan %>" />
      

</july:selectableTable>

</july:browseform>
