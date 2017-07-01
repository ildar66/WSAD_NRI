<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "10"; %>

<%
	String masterTagId = "changeSListWordEditMasterTagId";
%>
<july:wordEditMaster styleId='<%= masterTagId %>' >
</july:wordEditMaster>

<july:browseform action="/ShowDAssactList.do" styleId="DAssactListForm">

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
	if(DAssactListForm.isowner[0].checked) {
		DAssactListForm.ownercode.disabled=true;
		DAssactListForm.ownercode.className = 'editdisabled';
	} else {
		DAssactListForm.ownercode.disabled=false;
		DAssactListForm.ownercode.className = 'editsearch';
	}
}
function switchStorage() {
<logic:equal name="DAssactListForm" property="useStorageCombo" value="true">
	if(document.all.isstorage[0].checked) {
		document.all.storagecode.className='editdisabled1';
	} else {
		document.all.storagecode.className='editsearch1';
	}
	document.all.storagecode.disabled=document.all.isstorage[0].checked;
</logic:equal>
<logic:notEqual name="DAssactListForm" property="useStorageCombo" value="true">
	switchLookup('storagecode','stor',document.all.isstorage[0].checked);
</logic:notEqual>
}
function printWord(prompt1){
	//Печать актов монтажа блоков на складе:
	window.location.href='reports/dassact.jsp?prompt1='+prompt1;
}
</script>

<july:selectableTable modelName="list" selectable="1" paramName="selID" styleClass="main" selectedClass="selected">

<july:separator colspan="<%= gColSpan %>" />
<tr class="normal"><td colspan="<%= gColSpan %>">
<table class="find">
<tr>
	<td class="title"><bean:message key="label.dassact.owner"/></td>
	<td class="title">
		<july:checkbox property="isowner" insertable="true" updatable="true" value="true" onclick="switchOwner();"/><bean:message key="label.all"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
   		<july:select collection="owners" property="ownercode" insertable="true" updatable="true" styleClass="search">
			<html:options collection="owners" property="organization" labelProperty="name"/>
		</july:select><july:searchbutton/>
	</td>
</tr>
<tr>
	<td class="title"><bean:message key="label.dassact.storage"/></td>
	<td class="title">
		<july:checkbox property="isstorage" insertable="true" updatable="true" value="true" onclick="switchStorage();"/><bean:message key="label.all"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<logic:equal name="DAssactListForm" property="useStorageCombo" value="true">
   		<july:select collection="storages" property="storagecode" insertable="true" updatable="true" styleClass="search" style="width:400;">
			<html:options collection="storages" property="storageplace" labelProperty="name"/>
		</july:select>
</logic:equal>
<logic:notEqual name="DAssactListForm" property="useStorageCombo" value="true">
		<july:string property="storagecode" styleId="storagecode" size="5" insertable="true" updatable="true" styleClass="editkodsearch"/>
		<july:lookupbutton action="/ShowStorageLookupList.do" styleId="storl" fieldNames="storagecode;storagename" newWindowName="storagelookup"  insertable="true" updatable="true"/>
		<july:string size="35" property="storagename" styleId="storagename" insertable="false" updatable="false" />
</logic:notEqual>
	</td>
</tr>
<tr>
	<td class="title"><bean:message key="label.dassact.period"/></td>
	<td class="title" style="vertical-align: top;">
	<table class="find">
	<tr>
		<td class="title"><bean:message key="label.dassact.periodfrom"/>&nbsp;</td>
		<td class="title"><july:date property="datefromstr" insertable="true" updatable="true"/></td>
		<td class="title">&nbsp;</td>
		<td class="title"><bean:message key="label.dassact.periodto"/>&nbsp;</td>
		<td class="title"><july:date property="datetostr" insertable="true" updatable="true"/></td>
	</tr>
	</table>
	</td>
</tr>
</table>
</td></tr>
<script language="javascript">
	switchStorage();
	switchOwner();
</script>
<july:separator colspan="<%= gColSpan %>" />
<tr class="title">
<td colspan="<%= gColSpan %>">
	<table class="buttons">
	<tr class="title">
		<td class="buttons"><july:addbutton page="/EditDAssact.do?action=Add" alttext="label.dassact.add"/><july:backbutton page="/main.do"/></td>
		<td class="navigator"><july:navigator/></td>
	</tr>
	</table>
</td>
</tr>
<july:separator colspan="<%= gColSpan %>" />
<!-- Table header -->
<tr class="title">
	<july:headercolumn key="label.void" colType="string"/>
	<july:sortcolumn key="label.dassact.date" colType="string" ascFinder="3" descFinder="4"/>
	<july:sortcolumn key="label.dassact.num" colType="number" ascFinder="1" descFinder="2"/>
	<july:headercolumn key="label.dassact.owner" colType="string"/>
	<july:headercolumn key="label.assact.storagename" colType="string"/>
	<july:headercolumn key="label.dassact.state" colType="string"/>
	<july:headercolumn key="label.void" colType="string"/>
<%--	<july:headercolumn key="label.void" colType="string"/> --%>
	<july:headercolumn key="label.void" colType="string"/>
</tr>

<july:separator colspan="<%= gColSpan %>" />

<!-- Table body -->
<logic:iterate id="it" name="browseList" type="com.hps.july.cdbc.lib.CDBCRowObject">
<logic:present name="it">
<%
	pageContext.setAttribute("document",it.getColumn("document").asString());
	String docstate = it.getColumn("docstate").asString();
	pageContext.setAttribute("documentState",docstate);
	boolean isAutoDoc = "Y".equals(it.getColumn("isautodoc").asString());
	String theDocument = it.getColumn("document").asString();
%>
<tr selectableID='<july:stringwrite name="it" property="document"/>' classReal='<%=(isAutoDoc?"autodoc":"normal")%>' class='<%=(isAutoDoc?"autodoc":"normal")%>' id='selID<july:stringwrite name="it" property="document"/>' onMouseOver='className="select"' onMouseOut="className='<%=(isAutoDoc?"autodoc":"normal")%>'">

	<td class="text">
		<%if("1".equals(docstate) && !isAutoDoc) {%>
			<july:editbutton page="/EditDAssact.do" action="Edit" paramId="document" paramName="document" paramScope="page" alttext="label.dassact.edit"/>
		<%} else {%>
			<july:editbutton page="/EditDAssact.do" action="View" paramId="document" paramName="document" paramScope="page" alttext="label.dassact.view"/>
		<%}%>
		<a name="selID<july:stringwrite name="it" property="document"/>"></a>
	</td>
	<td class="text"><july:datewrite name="it" property="blankdate"/></td>
	<td class="text">
		<%-- <july:stringwrite name="it" property="blankindex"/>&nbsp; --%>
		<july:stringwrite name="it" property="blanknumber"/></td>
	<td class="text"><july:stringwrite name="it" property="ownername"/></td>
	<td class="text"><july:stringwrite name="it" property="spsname"/></td>
	<td class="text">
<%-- if(isAutoDoc) { --%>
			<% if ("1".equals(docstate)) { %><bean:message key="label.state.entering"/><% } else { %><bean:message key="label.state.calculated"/><% } %>
<%-- } else { %>
			<html:link page="/EditDAssactst.do?action=Edit" paramId="doc" paramName="document" paramScope="page">
			<% if ("1".equals(docstate)) { %><bean:message key="label.state.entering"/><% } else { %><bean:message key="label.state.calculated"/><% } %>
			</html:link>
<% } --%>
	</td>
<%--
	<td class="link">
		<html:link page="/ShowDAssactposList.do" paramId="document" paramName="document" paramScope="page">
			<img src="/images/doc.gif" width=22 height=16 border=0 alt="<bean:message key="label.dassact.positions"/>">
		</html:link>
	</td>
--%>
	<td class="link">
<%--
		<july:docprintbutton docstatebean="documentState" href="/crystalclear/dassact.rpt?dll=pdsassact.dll" paramId="prompt0" paramName="document" paramScope="page"/>
--%>
<%--
		<A href='javascript:printWord(<july:stringwrite name="document"/>)'>
			<img src="/images/print.gif" border=0 alt='Напечатать акт'>
		</A>
--%>	
		<july:wordEditSlave masterStyleId='<%= masterTagId %>' styleId='<%= "dassactList_" + theDocument %>' 
			url='<%= "reports/dassact.jsp?prompt1=" + theDocument %>' 
			uploadurl=''
			updatable='false'
			documentid='<%= theDocument %>'>
			<IMG SRC="/images/docword.gif" border="0" alt='Напечатать акт'>
		</july:wordEditSlave>
	</td>
	<td class="link">
		<% if ("1".equals(docstate) && !isAutoDoc) { %>
			<july:delbutton page="/EditDAssact.do?action=Delete" paramId="document" paramName="document" paramScope="page"/>
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
		<td class="buttons"><july:addbutton page="/EditDAssact.do?action=Add" alttext="label.dassact.add"/><july:backbutton page="/main.do"/></td>
		<td class="navigator"><july:navigator/></td>
	</tr>
	</table>
</td>
</tr>
<july:separator colspan="<%= gColSpan %>" />

</july:selectableTable>
</july:browseform>
