<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import="com.hps.july.inventory.valueobject.*" %>

<% java.lang.String gColSpan = "11"; %>

<%
	String masterTagId = "changeSListWordEditMasterTagId";
%>
<july:wordEditMaster styleId='<%= masterTagId %>' >
</july:wordEditMaster>

<july:browseform action="/ShowInvActList.do">

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
function switchOwner() {
	if(InvActListForm.isowner[0].checked) {
		InvActListForm.ownercode.className='editdisabled';
	} else {
		InvActListForm.ownercode.className='editsearch';
	}
	InvActListForm.ownercode.disabled=InvActListForm.isowner[0].checked;
}
function switchStorage() {
<logic:equal name="InvActListForm" property="useStorageCombo" value="true">
	if(InvActListForm.isstorage[0].checked) {
		InvActListForm.storagecode.className='editdisabled1';
	} else {
		InvActListForm.storagecode.className='editsearch1';
	}
	InvActListForm.storagecode.disabled=InvActListForm.isstorage[0].checked;
</logic:equal>
<logic:notEqual name="InvActListForm" property="useStorageCombo" value="true">
	switchLookup('storagecode','stor',InvActListForm.isstorage[0].checked);
</logic:notEqual>
}
function printWord(prompt1, typeWord){
	if(typeWord == 0){
		//Напечатать акт инвентаризации:
		window.location.href='reports/invacte.jsp?prompt1='+prompt1;
	}
	else if(typeWord == 1){
		//Напечатать перечень недостач:
		window.location.href='reports/mis.jsp?prompt1='+prompt1;
	}
	else if(typeWord == 2){
		//Напечатать перечень излишков:
		window.location.href='reports/extra.jsp?prompt1='+prompt1;
	}
}
</script>

<july:selectableTable modelName="list" selectable="1" paramName="selID" styleClass="main" selectedClass="selected">

<july:separator colspan="<%= gColSpan %>" />

<tr class="normal">
<td colspan="<%= gColSpan %>">
 
	<table class="find">
	<tr>
		<td class="title"><bean:message key="label.inventory.org"/></td>
		<td class="title"><july:checkbox property="isowner" insertable="true" updatable="true" value="true" onclick="switchOwner();"/><html:hidden property="isowner" value="false"/><bean:message key="label.all"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	   		<july:select collection="owners" property="ownercode" insertable="true" updatable="true" styleClass="editsearch">
				<html:options collection="owners" property="organization" labelProperty="name"/>
			</july:select><july:searchbutton />
			<script language="javascript">switchOwner();
      </script>
		</td>
	</tr>
	<tr>
		<td class="title"><bean:message key="label.inventory.storage"/></td>
		<td class="title"><july:checkbox property="isstorage" insertable="true" updatable="true" value="true" onclick="switchStorage();"/><html:hidden property="isstorage" value="false"/><bean:message key="label.all"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<logic:equal name="InvActListForm" property="useStorageCombo" value="true">
	   		<july:select collection="storages" property="storagecode" insertable="true" updatable="true" styleClass="search" style="width:400;">
				<html:options collection="storages" property="storageplace" labelProperty="name"/>
			</july:select>
</logic:equal>
<logic:notEqual name="InvActListForm" property="useStorageCombo" value="true">
			<july:string property="storagecode" styleId="storagecode" size="5" insertable="true" updatable="true" styleClass="editkodsearch"/>
			<july:lookupbutton action="/ShowStorageLookupList.do" styleId="storl" fieldNames="storagecode;storagename" newWindowName="storagelookup"  insertable="true" updatable="true"/>
			<july:string size="35" property="storagename" styleId="storagename" insertable="false" updatable="false" />
</logic:notEqual>
			<script language="javascript">switchStorage();
      </script>
		</td>
	</tr>
	<tr>
		<td class="title"><bean:message key="label.inventory.date"/></td>
		<td class="title">
			<bean:message key="label.datefrom"/> &nbsp;&nbsp;&nbsp; <july:date property="datefromstr" size="25" insertable="true" updatable="true"/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<bean:message key="label.dateto"/> &nbsp;&nbsp;&nbsp; <july:date property="datetostr" size="25" insertable="true" updatable="true"/>
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
			<TD class="buttons"><july:addbutton page="/EditInvAct.do?action=Add" alttext="label.inventory.add"/><july:backbutton page="/main.do"/></td>
			<TD class="navigator"><july:navigator/></td>
		</tr>
		</table>
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>" />

	<!-- Table header -->
<tr class="title">
	<td class="title">&nbsp;</td>
	<july:sortcolumn key="label.inventory.date" colType="string" ascFinder="3" descFinder="4"/>
	<july:sortcolumn key="label.inventory.num" colType="number" ascFinder="1" descFinder="2"/>
	<july:headercolumn key="label.inv.tech" colType="string"/>
	<july:headercolumn key="label.inventory.storage" colType="string"/>
	<july:headercolumn key="label.inventory.type" colType="string"/>
	<july:headercolumn key="label.inventory.state" colType="string"/>
	<july:headercolumn key="label.print" colType="string"/>
	<td class="title">&nbsp;</td>
</tr>

<july:separator colspan="<%= gColSpan %>" />
    
<!-- Table body -->
<logic:iterate id="it" name="browseList" type="com.hps.july.cdbc.lib.CDBCRowObject">
<logic:present name="it">
<%
	boolean isAutoDoc = "Y".equals(it.getColumn("isautodoc").asString());
	String docState = it.getColumn("state").asString();
	String invtype = it.getColumn("type").asString();
	pageContext.setAttribute("document",it.getColumn("document").asString());
	String theDocument = it.getColumn("document").asString();
%>

<tr selectableID='<july:stringwrite name="it" property="document"/>' classReal='<%=(isAutoDoc?"autodoc":"normal")%>' class='<%=(isAutoDoc?"autodoc":"normal")%>' id='selID<july:stringwrite name="it" property="document"/>' onMouseOver='className="select"' onMouseOut="className='<%=(isAutoDoc?"autodoc":"normal")%>'">

	<td class="link">
		<% if ("1".equals(docState) && !isAutoDoc) { %>
			<july:editbutton page="/EditInvAct.do" action="Edit" paramId="document" paramName="it" paramProperty="document" paramScope="page" alttext="label.inventory.edit"/>
		<% } else { %>
			<july:editbutton page="/EditInvAct.do" action="View" paramId="document" paramName="it" paramProperty="document" paramScope="page" alttext="label.inventory.view"/>
		<% } %>
		<a name="selID<july:stringwrite name="it" property="document"/>"></a>
	</td>
	<td class="text"><july:datewrite name="it" property="blankdate"/></td>
	<td class="number"><july:stringwrite name="it" property="docnumber"/></td>
	<td class="text"><july:stringwrite name="it" property="smanname"/></td>
	<td class="text"><july:stringwrite name="it" property="spsname"/></td>
	<td class="text">
		<%if("F".equals(invtype)) {%>
			<bean:message key="label.inventory.type.full"/>
		<%} else if("A".equals(invtype)) {%>
			<bean:message key="label.inventory.type.byunit"/>
		<%} else if("P".equals(invtype)) {%>
			<html:link page="/ShowI13nActRessetList.do" paramId="document" paramName="document" paramScope="page"><bean:message key="label.inventory.type.byselect"/></html:link>
		<%}%>
	</td>
	<td class="text">
		<% if ("1".equals(docState)) { %><bean:message key="label.state.entering"/><% } else { %><bean:message key="label.state.calculated"/><% } %>
	</td>
<%--
	<td class="link">
		<html:link page="/ShowInvActPosList.do" paramId="document" paramName="document" paramScope="page"><img src="/images/doc.gif" width=22 height=16 border=0></html:link>
	</td>
--%>
	<td class="link">
<%--
	
		<%if("A".equals(invtype)) {%>
--%>
<%--
			<july:docprintbutton docstatebean="it" docstateproperty="state" href="/crystalclear/invacte.rpt?dll=pdsinvents.dll" paramId="prompt0" paramName="it" paramProperty="document" paramScope="page" alt="Напечатать акт инвентаризации" />
--%>
<%--
			<A href='javascript:printWord(<july:stringwrite name="it" property="document"/>, 0)'>
				<img src="/images/print.gif" border=0 alt='Напечатать акт инвентаризации'>
			</A>
		<%} else {%>
--%>
<%--
			<july:docprintbutton docstatebean="it" docstateproperty="state" href="/crystalclear/invact.rpt?dll=pdsinvents.dll" paramId="prompt0" paramName="it" paramProperty="document" paramScope="page" alt="Напечатать акт инвентаризации" />
--%>
<%--
			<A href='javascript:printWord(<july:stringwrite name="it" property="document"/>, 0)'>
				<img src="/images/print.gif" border=0 alt='Напечатать акт инвентаризации'>
			</A>
		<%}%> 
--%>
		<july:wordEditSlave masterStyleId='<%= masterTagId %>' styleId='<%= "invActList_" + theDocument %>' 
			url='<%= "reports/invacte.jsp?prompt1=" + theDocument %>' 
			uploadurl=''
			updatable='false'
			documentid='<%= theDocument %>'><IMG SRC="/images/docword.gif" border="0" alt='Напечатать акт инвентаризации'></july:wordEditSlave>
		<%if("2".equals(docState)) {%>
<%-- 
			<july:docprintbutton docstatebean="it" docstateproperty="state" href="/crystalclear/mis.rpt?dll=pdsmis.dll" paramId="prompt0" paramName="it" paramProperty="document" paramScope="page" image="print_lose.gif" alt="Напечатать перечень недостач" />
--%>
<%-- 
			<A href='javascript:printWord(<july:stringwrite name="it" property="document"/>, 1)'>
				<img src="/images/print_lose.gif" border=0 alt='Напечатать перечень недостач'>
			</A>
--%>
<%--
			<july:docprintbutton docstatebean="it" docstateproperty="state" href="/crystalclear/extra.rpt?dll=pdsextra.dll" paramId="prompt0" paramName="it" paramProperty="document" paramScope="page" image="print_plus.gif" alt="Напечатать перечень излишков" />
--%>
<%-- 
			<A href='javascript:printWord(<july:stringwrite name="it" property="document"/>, 2)'>
				<img src="/images/print_plus.gif" border=0 alt='Напечатать перечень излишков'>
			</A>
--%>
		<july:wordEditSlave masterStyleId='<%= masterTagId %>' styleId='<%= "invActListShortage_" + theDocument %>' 
			url='<%= "reports/mis.jsp?prompt1=" + theDocument %>' 
			uploadurl=''
			updatable='false'
			documentid='<%= theDocument %>'><IMG SRC="/images/print_lose.gif" border="0" alt='Напечатать перечень недостач'></july:wordEditSlave>
		<july:wordEditSlave masterStyleId='<%= masterTagId %>' styleId='<%= "invActListOverplus_" + theDocument %>' 
			url='<%= "reports/extra.jsp?prompt1=" + theDocument %>' 
			uploadurl=''
			updatable='false'
			documentid='<%= theDocument %>'><IMG SRC="/images/print_plus.gif" border="0" alt='Напечатать перечень излишков'></july:wordEditSlave>
		<%}%>
	</td>
	<td class="link">
		<% if ("1".equals(docState) && !isAutoDoc) { %>
		<july:delbutton page="/EditInvAct.do?action=Delete" paramId="document" paramName="document" paramScope="page"/>
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
				<TD class="buttons"><july:addbutton page="/EditInvAct.do?action=Add" alttext="label.inventory.add"/><july:backbutton page="/main.do"/></td>
				<TD class="navigator"><july:navigator/></td>
			</tr>
			</table>
		</td>
	</tr>
      
	<july:separator colspan="<%= gColSpan %>" />
      
    </july:selectableTable>

</july:browseform>
