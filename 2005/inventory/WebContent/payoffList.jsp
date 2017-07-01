<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import="com.hps.july.persistence.PayOffActAccessBean" %>

<% java.lang.String gColSpan = "10"; %>

<%
	String masterTagId = "changeSListWordEditMasterTagId";
%>
<july:wordEditMaster styleId='<%= masterTagId %>' >
</july:wordEditMaster>

<july:browseform action="/ShowPayoffList.do" styleId="PayoffListForm">

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
	if(PayoffListForm.isowner[0].checked) {
		PayoffListForm.ownercode.className='editdisabled';
	} else {
		PayoffListForm.ownercode.className='editsearch';
	}
	PayoffListForm.ownercode.disabled=PayoffListForm.isowner[0].checked;
}

function switchStorage() {
<logic:equal name="PayoffListForm" property="useStorageCombo" value="true">
	if(document.all.isstorage[0].checked) {
		document.all.storagecode.className='editdisabled1';
	} else {
		document.all.storagecode.className='editsearch1';
	}
	document.all.storagecode.disabled=document.all.isstorage[0].checked;
</logic:equal>
<logic:notEqual name="PayoffListForm" property="useStorageCombo" value="true">
	switchLookup('storagecode','stor',document.all.isstorage[0].checked);
</logic:notEqual>
}
function printWord(prompt1){
	//Печать актов списания на складе:
	window.location.href='reports/payoff.jsp?prompt1='+prompt1;
}
</script>

<july:selectableTable modelName="list" selectable="1" paramName="selID" styleClass="main" selectedClass="selected">

<july:separator colspan="<%= gColSpan %>" />

<tr class="normal"><td colspan="<%= gColSpan %>">
<table class="find">
<tr>
	<td class="title"><bean:message key="label.payoff.owner"/></td>
	<td class="title" colspan="2">
		<july:checkbox property="isowner" insertable="true" updatable="true" value="true" onclick="switchOwner();"/><html:hidden property="isowner" value="false"/><bean:message key="label.all"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
   		<july:select collection="owners" property="ownercode" insertable="true" updatable="true" styleClass="search">
			<html:options collection="owners" property="organization" labelProperty="name"/>
		</july:select><july:searchbutton/>
		<script language="javascript">switchOwner();</script>
	</td>
</tr>
<tr>
	<td class="title"><bean:message key="label.payoff.storage"/></td>
	<td class="title" colspan="2">
		<july:checkbox property="isstorage" insertable="true" updatable="true" value="true" onclick="switchStorage();"/><html:hidden property="isstorage" value="false"/><bean:message key="label.all"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<logic:equal name="PayoffListForm" property="useStorageCombo" value="true">
   		<july:select collection="storages" property="storagecode" insertable="true" updatable="true" styleClass="search" style="width:400;">
			<html:options collection="storages" property="storageplace" labelProperty="name"/>
		</july:select>
</logic:equal>
<logic:notEqual name="PayoffListForm" property="useStorageCombo" value="true">
		<july:string property="storagecode" styleId="storagecode" size="5" insertable="true" updatable="true" styleClass="editkodsearch"/>
		<july:lookupbutton action="/ShowStorageLookupList.do" styleId="storl" fieldNames="storagecode;storagename" newWindowName="storagelookup"  insertable="true" updatable="true"/>
		<july:string size="35" property="storagename" styleId="storagename" insertable="false" updatable="false" />
</logic:notEqual>
		<script language="javascript">switchStorage();</script>
	</td>
</tr>
<tr>
	<td class="title"><bean:message key="label.payoff.date"/></td>
	<td class="title" colspan="2">
		<bean:message key="label.datefrom"/>&nbsp;<july:date property="datefromstr" size="25" insertable="true" updatable="true"/>&nbsp;&nbsp;&nbsp;<bean:message key="label.dateto"/>&nbsp;<july:date property="datetostr" size="25" insertable="true" updatable="true"/>
	</td>
</tr>
</table>
</td></tr>

<july:separator colspan="<%= gColSpan %>" />

<tr class="title">
<td colspan="<%= gColSpan %>">
	<table class="buttons">
	<tr class="title">
		<td class="buttons"><july:addbutton page="/EditPayoff.do?action=Add" alttext="label.payoff.add"/><july:backbutton page="/main.do"/></td>
		<td class="navigator"><july:navigator/></td>
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
	<july:headercolumn key="label.internal.owner" colType="string"/>
	<july:headercolumn key="label.payoff.storage" colType="string"/>
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
	String document = it.getColumn("document").asString();
	String docState = it.getColumn("docstate").asString();
	pageContext.setAttribute("document",document);
	pageContext.setAttribute("docstate",docState);
%>
<tr selectableID='<july:stringwrite name="it" property="document"/>' classReal='<%=(isAutoDoc?"autodoc":"normal")%>' class='<%=(isAutoDoc?"autodoc":"normal")%>' id='selID<july:stringwrite name="it" property="document"/>' onMouseOver='className="select"' onMouseOut="className='<%=(isAutoDoc?"autodoc":"normal")%>'">
	<td class="text">
		<%if("1".equals(docState) && !isAutoDoc) {%>
			<july:editbutton page="/EditPayoff.do" action="Edit" paramId="document" paramName="document" paramScope="page" alttext="label.payoff.edit"/>
		<%} else {%>
			<july:editbutton page="/EditPayoff.do" action="View" paramId="document" paramName="document" paramScope="page" alttext="label.payoff.view"/>
		<%}%>
		<a name="selID<july:stringwrite name="it" property="document"/>"></a>
	</td>
	<td class="text"><july:datewrite name="it" property="blankdate"/></td>
	<td class="text">
		<%-- <july:stringwrite name="it" property="blankindex"/>&nbsp; --%>
		<july:stringwrite name="it" property="blanknumber"/>
	</td>
	<td class="text"><july:stringwrite name="it" property="ownername"/></td>
	<td class="text"><july:stringwrite name="it" property="spsname"/></td>
	<td class="text">
		<% if ("1".equals(docState)) { %><bean:message key="label.state.entering"/><% } else { %><bean:message key="label.state.calculated"/><% } %>
	</td>
<%--
	<td class="link">
		<html:link page="/ShowPayoffPositionList.do" paramId="document" paramName="document" paramScope="page">
			<img src="/images/doc.gif" width=22 height=16 border=0 alt="<bean:message key="label.payoff.positions"/>">
		</html:link>
	</td>
--%>
	<td class="link">
<%--
		<july:docprintbutton docstatebean="it" docstateproperty="docstate" href="/crystalclear/payoff.rpt?dll=pdspayoff.dll" paramId="prompt0" paramName="it" paramProperty="document" paramScope="page"/>
--%>
<%--
		<A href='javascript:printWord(<july:stringwrite name="document"/>)'>
			<img src="/images/print.gif" border=0 alt='Напечатать акт списания'>
		</A>
--%>
		<july:wordEditSlave masterStyleId='<%= masterTagId %>' styleId='<%= "internalRList_" + document %>' 
			url='<%= "reports/payoff.jsp?prompt1=" + document %>' 
			uploadurl=''
			updatable='false'
			documentid='<%= document %>'>
			<IMG SRC="/images/docword.gif" border="0" alt='Напечатать акт списания'>
		</july:wordEditSlave>
	</td>
	<td class="link">
		<%if("1".equals(docState) && !isAutoDoc) {%>
			<july:delbutton page="/EditPayoff.do?action=Delete" paramId="document" paramName="document" paramScope="page"/>
		<%}%>
	</td>
</tr>
<july:separator colspan="<%= gColSpan %>" />
</logic:present>
</logic:iterate>

<tr class="title">
	<td colspan="<%= gColSpan %>">
		<table class="buttons">
		<tr class="title">
			<td class="buttons"><july:addbutton page="/EditPayoff.do?action=Add" alttext="label.payoff.add"/><july:backbutton page="/main.do"/></td>
			<td class="navigator"><july:navigator/></td>
		</tr>
		</table>
	</td>
</tr>
      
<july:separator colspan="<%= gColSpan %>" />

</july:selectableTable>

</july:browseform>
