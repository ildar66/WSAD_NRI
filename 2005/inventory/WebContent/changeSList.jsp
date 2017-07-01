<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "9"; %>

<july:browseform action="/ShowChangeSList.do" styleId="ChangeSListForm">

<script language="javascript">
function switchLookup(itemname,lookupname,disabled) {
	if(disabled) {
		ChangeSListForm[itemname].className = 'editkoddisabled';
		ChangeSListForm[itemname].disabled = true;
		ChangeSListForm[itemname].readonly = true;
		document.all['lookupbtn_'+lookupname+'l'].disabled = true;
		document.all['lookupimg_'+lookupname+'l'].src='/images/lookup_disabled.gif';
	} else {
		ChangeSListForm[itemname].className = 'editkodsearch';
		ChangeSListForm[itemname].disabled = false;
		ChangeSListForm[itemname].readonly = false;
		document.all['lookupbtn_'+lookupname+'l'].disabled = false;
		document.all['lookupimg_'+lookupname+'l'].src='/images/lookup.gif';
	}
}

function switchOwner() {
	if(ChangeSListForm.isowner[0].checked) {
		ChangeSListForm.ownercode.className='editdisabled';
	} else {
		ChangeSListForm.ownercode.className='editsearch';
	}
	ChangeSListForm.ownercode.disabled=ChangeSListForm.isowner[0].checked;
}

function switchStorage() {
<logic:equal name="ChangeSListForm" property="useStorageCombo" value="true">
	if(document.all.isstorage[0].checked) {
		document.all.storagecode.className='editdisabled1';
	} else {
		document.all.storagecode.className='editsearch1';
	}
	document.all.storagecode.disabled=document.all.isstorage[0].checked;
</logic:equal>
<logic:notEqual name="ChangeSListForm" property="useStorageCombo" value="true">
	switchLookup('storagecode','stor',document.all.isstorage[0].checked);
</logic:notEqual>
}
function printWord(prompt1){
	//Печать актов замены/модернизации:
	window.location.href='reports/changes.jsp?prompt1='+prompt1;
}
</script>

<july:selectableTable modelName="list" selectable="1" paramName="selID" styleClass="main" selectedClass="selected">

<july:separator colspan="<%= gColSpan %>" />

<tr class="normal">
 <td colspan="<%= gColSpan %>">
    <table class="find">
	<tr>
		<td class="title"><bean:message key="label.changes.owner"/></td>
		<td class="title" colspan="2">
			<july:checkbox property="isowner" insertable="true" updatable="true" value="true" onclick="switchOwner();"/><html:hidden property="isowner" value="false"/><bean:message key="label.all"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	   		<july:select collection="owners" property="ownercode" insertable="true" updatable="true" styleClass="search">
				<html:options collection="owners" property="organization" labelProperty="name"/>
			</july:select><july:searchbutton/>
			<script language="javascript">switchOwner();</script>
		</td>
	</tr>
	<tr>
		<td class="title"><bean:message key="label.assact.storage"/></td>
		<td class="title">
			<july:checkbox property="isstorage" insertable="true" updatable="true" value="true" onclick="switchStorage();"/><bean:message key="label.all"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<logic:equal name="ChangeSListForm" property="useStorageCombo" value="true">
   		<july:select collection="storages" property="storagecode" insertable="true" updatable="true" styleClass="search" style="width:400;">
			<html:options collection="storages" property="storageplace" labelProperty="name"/>
		</july:select>
</logic:equal>
<logic:notEqual name="ChangeSListForm" property="useStorageCombo" value="true">
		<july:string property="storagecode" styleId="storagecode" size="5" insertable="true" updatable="true" styleClass="editkodsearch"/>
		<july:lookupbutton action="/ShowStorageLookupList.do" styleId="storl" fieldNames="storagecode;storagename" newWindowName="storagelookup"  insertable="true" updatable="true"/>
		<july:string size="35" property="storagename" styleId="storagename" insertable="false" updatable="false" />
</logic:notEqual>
			<script language="javascript">switchStorage();</script>
		</td>
	</tr>
	<tr>
		<td class="title"><bean:message key="label.changes.date"/></td>
		<td class="title" colspan="2">
			<bean:message key="label.datefrom"/>&nbsp;<july:date property="datefromstr" size="25" insertable="true" updatable="true"/>&nbsp;&nbsp;&nbsp;<bean:message key="label.dateto"/>&nbsp;<july:date property="datetostr" size="25" insertable="true" updatable="true"/>
		</td>
	</tr>
	<tr>
		<td class="title"><bean:message key="label.changes.acttype"/></td>
		<td class="title" colspan="2">
			<july:radio insertable="true" updatable="true" property="acttype" value="A"/><bean:message key="label.all"/>
			<july:radio insertable="true" updatable="true" property="acttype" value="C"/><bean:message key="label.changes.acttype.C"/>
			<july:radio insertable="true" updatable="true" property="acttype" value="U"/><bean:message key="label.changes.acttype.U"/>
		</td>
	</tr>
    </table>
  </td>
</tr>

<july:separator colspan="<%= gColSpan %>" />

<tr class="title">
	<td colspan="<%= gColSpan %>">
		<table class="buttons">
		<tr class="title">
			<td class="buttons"><july:addbutton page="/EditChangeS.do?action=Add" alttext="label.changes.add"/><july:backbutton page="/main.do"/></td>
			<td class="navigator"><july:navigator/></td>
		</tr>
		</table>
	</td>
</tr>
        
<july:separator colspan="<%= gColSpan %>" />

<!-- Table header -->
<tr class="title">
	<july:headercolumn key="label.void" colType="number"/>
	<july:sortcolumn key="label.external.date" colType="string" ascFinder="3" descFinder="4"/>
	<july:sortcolumn key="label.num" colType="number" ascFinder="1" descFinder="2"/>
	<july:headercolumn key="label.change.actt" colType="string"/>
	<july:headercolumn key="label.changes.storage" colType="string"/>
	<july:headercolumn key="label.changes.state" colType="string"/>
	<july:headercolumn key="label.void" colType="string"/>
	<july:headercolumn key="label.void" colType="string"/>
</tr>

<july:separator colspan="<%= gColSpan %>" />

<%
	String masterTagId = "changeSListWordEditMasterTagId";
%>
<july:wordEditMaster styleId='<%= masterTagId %>' >
</july:wordEditMaster>

<!-- Table body -->
<logic:iterate id="it" name="browseList" type="com.hps.july.cdbc.lib.CDBCRowObject">
<logic:present name="it">
<%
	String document = it.getColumn("document").asString();
	pageContext.setAttribute("document",document);
	String docstate = it.getColumn("state").asString();
	pageContext.setAttribute("docstate",docstate);
	String acttype = it.getColumn("acttype").asString();
	boolean isAutoDoc = "Y".equals(it.getColumn("isautodoc").asString());
	String theDocument = it.getColumn("document").asString();
%>

<tr selectableID='<july:stringwrite name="it" property="document"/>' classReal='<%=(isAutoDoc?"autodoc":"normal")%>' class='<%=(isAutoDoc?"autodoc":"normal")%>' id='selID<july:stringwrite name="it" property="document"/>' onMouseOver='className="select"' onMouseOut="className='<%=(isAutoDoc?"autodoc":"normal")%>'">

	<td class="text">
		<%if("1".equals(docstate) && !isAutoDoc) {%>
			<july:editbutton page="/EditChangeS.do" action="Edit" paramId="document" paramName="document" paramScope="page" alttext="label.changes.edit"/>
		<%} else {%>
			<july:editbutton page="/EditChangeS.do" action="View" paramId="document" paramName="document" paramScope="page" alttext="label.changes.view"/>
		<%}%>
		<a name="selID<july:stringwrite name="it" property="document"/>"></a>
	</td>
	<td class="text"><july:datewrite name="it" property="blankdate"/></td>
	<td class="text">
		<%-- <july:stringwrite name="it" property="blankindex"/>&nbsp; --%>
		<july:stringwrite name="it" property="blanknumber"/>
	</td>
	<td class="text"><%if("C".equals(acttype)){%><bean:message key="label.change.actt.C"/><%} else if("U".equals(acttype)){%><bean:message key="label.change.actt.U"/><%}%></td>
	<td class="text"><july:stringwrite name="it" property="storagename"/></td>
	<td class="text"><%if("1".equals(docstate)) {%><bean:message key="label.state.entering"/><%} else if("2".equals(docstate)) {%><bean:message key="label.state.calculated"/><%}%></td>
	<td class="link">
<%--
		<july:docprintbutton docstatebean="docstate" href="/crystalclear/changes.rpt?dll=pdschange.dll" paramId="prompt0" paramName="document" paramScope="page"/>
--%>
<%--
		<A href='javascript:printWord(<july:stringwrite name="document"/>)'>
			<img src="/images/print.gif" border=0 alt='Напечатать акт инвентаризации'>
		</A>
--%>

		<july:wordEditSlave masterStyleId='<%= masterTagId %>' styleId='<%= "changeSList_" + theDocument %>' 
			url='<%= "reports/changes.jsp?prompt1=" + theDocument %>' 
			uploadurl=''
			updatable='false'
			documentid="<%= theDocument %>">
			<IMG SRC="/images/docword.gif" border="0" alt='Напечатать акт инвентаризации'>
		</july:wordEditSlave>
		
	</td>
	<td class="link"><%if("1".equals(docstate)) {%><july:delbutton page="/EditChangeS.do?action=Delete" paramId="document" paramName="document" paramScope="page"/><%}%></td>
</tr>
<july:separator colspan="<%= gColSpan %>"/>
</logic:present>
</logic:iterate>

<tr class="title">
	<td colspan="<%= gColSpan %>">
		<table class="buttons">
		<tr class="title">
			<TD class="buttons"><july:addbutton page="/EditChangeS.do?action=Add" alttext="label.changes.add"/><july:backbutton page="/main.do"/></td>
			<TD class="navigator"><july:navigator/></td>
		</tr>
		</table>
	</td>
</tr>
      
<july:separator colspan="<%= gColSpan %>" />
 
</july:selectableTable>

</july:browseform>
