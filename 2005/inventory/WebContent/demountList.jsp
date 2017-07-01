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

<july:browseform action="/ShowDemountList.do" styleId="DemountList">

<script language="javascript">
function switchLookup(itemname,lookupname,disabled) {
	if(disabled) {
		DemountList[itemname].className = 'editkoddisabled';
		DemountList[itemname].disabled = true;
		DemountList[itemname].readonly = true;
		document.all['lookupbtn_'+lookupname+'l'].disabled = true;
		document.all['lookupimg_'+lookupname+'l'].src='/images/lookup_disabled.gif';
	} else {
		DemountList[itemname].className = 'editkodsearch';
		DemountList[itemname].disabled = false;
		DemountList[itemname].readonly = false;
		document.all['lookupbtn_'+lookupname+'l'].disabled = false;
		document.all['lookupimg_'+lookupname+'l'].src='/images/lookup.gif';
	}
}

function switchFilter() {
	if(DemountList.type[0].checked) {
		switchLookup('providercode','prov',true);
		switchLookup('workercode','work',true);
		DemountList['providername'].disabled = true;
		DemountList['workername'].disabled = true;
		DemountList['workertitle'].disabled = true;
	} else if(DemountList.type[1].checked) {
		switchLookup('providercode','prov',false);
		switchLookup('workercode','work',true);
		DemountList['providername'].disabled = false;
		DemountList['workername'].disabled = true;
		DemountList['workertitle'].disabled = true;
	} else if(DemountList.type[2].checked) {
		switchLookup('providercode','prov',true);
		switchLookup('workercode','work',false);
		DemountList['providername'].disabled = true;
		DemountList['workername'].disabled = false;
		DemountList['workertitle'].disabled = false;
	} else {
		switchLookup('providercode','prov',false);
		switchLookup('workercode','work',false);
		DemountList['providername'].disabled = false;
		DemountList['workername'].disabled = false;
		DemountList['workertitle'].disabled = false;
	}
}

function switchOwner() {
	if(DemountList.isowner[0].checked) {
		DemountList.ownercode.className='editdisabled';
	} else {
		DemountList.ownercode.className='editsearch';
	}
	DemountList.ownercode.disabled=DemountList.isowner[0].checked;
}

function switchPosition() {
	switchLookup('positioncode','pos',DemountList.isposition[0].checked);
}
function printWord(prompt1){
	//Печать актов:
	window.location.href='reports/dassactp.jsp?prompt1='+prompt1;
}
</script>

<july:selectableTable modelName="list" selectable="1" paramName="selID" styleClass="main" selectedClass="selected">

<july:separator colspan="<%= gColSpan %>" />

<TR class="normal">
<TD colspan="<%= gColSpan %>">
    <table class="find">
    <tr>
		<td class="title"><bean:message key="label.dismantlingp.owner"/></td>
		<td class="title" colspan="2">
			<july:checkbox property="isowner" insertable="true" updatable="true" value="true" onclick="switchOwner();"/><html:hidden property="isowner" value="false"/><bean:message key="label.all"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	   		<july:select collection="owners" property="ownercode" insertable="true" updatable="true" styleClass="search">
				<html:options collection="owners" property="organization" labelProperty="name"/>
			</july:select><july:searchbutton/>
			<script language="javascript">switchOwner();</script>
		</td>
    </tr>
    <tr>
		<td class="title"><bean:message key="label.dismantlingp.position"/></td>
		<td class="title" colspan="2">
			<july:checkbox property="isposition" insertable="true" updatable="true" value="true" onclick="switchPosition();"/><html:hidden property="isposition" value="false"/><bean:message key="label.all"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<july:string property="positioncode" styleId="positioncode" size="5" insertable="true" updatable="true" styleId="editkodsearch"/>
			<july:lookupbutton action="/ShowPositionLookupList.do" styleId="posl" fieldNames="positioncode;positionid;positionname" newWindowName="poslookup" insertable="true" updatable="true" />
			<july:string size="10" property="positionid" styleId="positionid" insertable="false" updatable="false" />
			<july:string size="25" property="positionname" styleId="positionname" insertable="false" updatable="false" />
			<script language="javascript">switchPosition();</script>
		</td>
	</tr>
	<tr>
		<td class="title"><bean:message key="label.dismantlingp.date"/></td>
		<td class="title" colspan="2">
			<bean:message key="label.dismantlingp.datefrom"/> &nbsp;&nbsp;&nbsp; <july:date property="datefromstr" size="25" insertable="true" updatable="true"/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<bean:message key="label.dismantlingp.dateto"/> &nbsp;&nbsp;&nbsp; <july:date property="datetostr" size="25" insertable="true" updatable="true"/>
		</td>
	</tr>
	<tr>
		<td class="title"><bean:message key="label.dismantlingp.type"/></td>
		<td class="title" colspan="2">
			<july:radio insertable="true" updatable="true" property="type" value="A" onclick="switchFilter();"/><bean:message key="label.all"/>
			<july:radio insertable="true" updatable="true" property="type" value="P" onclick="switchFilter();"/><bean:message key="label.acttype.forp"/>
			<july:radio insertable="true" updatable="true" property="type" value="W" onclick="switchFilter();"/><bean:message key="label.acttype.forw"/>
		</td>
	</tr>
    <tr>
		<td class="title"><bean:message key="label.dismantlingp.provider"/></td>
		<td class="title" colspan="2">
			<july:string property="providercode" styleId="providercode" size="5" insertable="true" updatable="true" styleClass="editkodsearch"/>
			<july:lookupbutton action="/ShowOrganizationLookupList.do" styleId="provl" fieldNames="providercode;providername" newWindowName="organizationlookup"  insertable="true" updatable="true" onclick="set_opt_params_provl('?selisprovider=true&selisrenter=false&selissupplier=false');"/>
			<july:string size="35" property="providername" styleId="providername" insertable="false" updatable="false" />
		</td>
    </tr>
    <tr>
		<td class="title"><bean:message key="label.dismantlingp.worker"/></td>
		<td class="title" colspan="2">
			<july:string property="workercode" styleId="workercode" size="5" insertable="true" updatable="true"  styleClass="editkodsearch" />
			<july:lookupbutton action="/ShowWorkerLookupList.do" styleId="workl" fieldNames="workercode;workername;workertitle" newWindowName="workerlookup" insertable="true" updatable="true" />
			<july:string size="25" property="workername" styleId="workername" insertable="false" updatable="false" />
			<july:string size="20" property="workertitle" styleId="workertitle" insertable="false" updatable="false" />
		</td>
    </tr>
    </table>
    <script language="javascript">switchFilter();</script>
  </TD>
</TR>

<july:separator colspan="<%= gColSpan %>" />

<tr class="title">
	<td colspan="<%= gColSpan %>">
		<table class="buttons">
		<tr class="title">
			<TD class="buttons"><july:addbutton page="/EditDemount.do?action=Add" alttext="label.dassact.add"/><july:backbutton page="/main.do"/></td>
			<TD class="navigator"><july:navigator/></td>
		</tr>
		</table>
	</td>
</tr>
        
<july:separator colspan="<%= gColSpan %>" />

<!-- Table header -->
<tr class="title">
	<july:headercolumn key="label.void" colType="number"/> <%-- Edit button --%>
	<july:sortcolumn key="label.internal.date" colType="string" ascFinder="3" descFinder="4"/>
	<july:sortcolumn key="label.num" colType="number" ascFinder="1" descFinder="2"/>
	<july:headercolumn key="label.dismantlingp.owner" colType="number"/> <%-- Owner --%>
	<td class="title"><bean:message key="label.dismantlingp.place"/></td> <%-- Position --%>
	<td class="title"><bean:message key="label.dismantlingp.expedition"/></td> <%-- From --%>
	<july:headercolumn key="label.dismantlingp.state" colType="string"/> <%-- documentState --%>
	<july:headercolumn key="label.void" colType="string"/> <%-- Print --%>
	<july:headercolumn key="label.void" colType="string"/> <%-- Delete --%>
</tr>

<july:separator colspan="<%= gColSpan %>" />

<!-- Table body -->
<logic:iterate id="it" name="browseList" type="com.hps.july.cdbc.lib.CDBCRowObject">
<logic:present name="it">
<%
	pageContext.setAttribute("document", it.getColumn("document").asString());
	String docState = it.getColumn("docstate").asString();
	pageContext.setAttribute("documentState", docState);
	if(it.getColumn("orgto").asObject() != null) {
		pageContext.setAttribute("expedition",it.getColumn("orgto").asString());
	} else if(it.getColumn("workerto").asObject() != null) {
		pageContext.setAttribute("expedition",it.getColumn("workerto").asString());
	}
	boolean curAutoDoc = "Y".equals(it.getColumn("isautodoc").asString());
	String theDocument = it.getColumn("document").asString();
%>
<tr selectableID='<july:stringwrite name="it" property="document"/>' classReal='<%=(curAutoDoc?"autodoc":"normal")%>' class='<%=(curAutoDoc?"autodoc":"normal")%>' id='selID<july:stringwrite name="it" property="document"/>' onMouseOver='className="select"' onMouseOut="className='<%=(curAutoDoc?"autodoc":"normal")%>'">
	<td class="text">
		<%if("1".equals(docState) && !curAutoDoc) {%>
			<july:editbutton page="/EditDemount.do" action="Edit" paramId="doc" paramName="document" paramScope="page" alttext="label.dassact.edit"/>
		<%} else {%>
			<july:editbutton page="/EditDemount.do" action="View" paramId="doc" paramName="document" paramScope="page" alttext="label.dassact.view"/>
		<%}%>
		<a name="selID<july:stringwrite name="it" property="document"/>"></a>
	</td>
	<td class="text"><july:datewrite name="it" property="blankdate"/></td>
	<td class="text">
		<%-- <july:stringwrite name="it" property="blankindex"/>&nbsp; --%>
		<july:stringwrite name="it" property="blanknumber"/>
	</td>
	<td class="text"><july:stringwrite name="it" property="ownername"/></td>
	<td class="text"><july:stringwrite name="it" property="posname"/><br><july:stringwrite name="it" property="equname"/></td>
	<td class="text"><bean:write name="expedition"/></td>
	<td class="text">
		<%if("1".equals(docState)) {%>
			<bean:message key="label.state.entering"/>
		<%} else if("2".equals(docState)) {%>
			<bean:message key="label.state.calculated"/>
		<%}%>
	</td>
	<td class="link">
<%--
		<july:docprintbutton docstatebean="documentState" href="/crystalclear/dassactp.rpt?dll=pdsdmount.dll" paramId="prompt0" paramName="document" paramScope="page"/>
--%>
<%--
		<A href='javascript:printWord(<july:stringwrite name="document"/>)'>
			<img src="/images/print.gif" border=0 alt='Напечатать акт'>
		</A>
--%>
		<july:wordEditSlave masterStyleId='<%= masterTagId %>' styleId='<%= "demountList_" + theDocument %>' 
			url='<%= "reports/dassactp.jsp?prompt1=" + theDocument %>' 
			uploadurl=''
			updatable='false'
			documentid='<%= theDocument %>'>
			<IMG SRC="/images/docword.gif" border="0" alt='Напечатать акт'>
		</july:wordEditSlave>
	</td>
	<td class="link">
		<%if("1".equals(docState)) {%>
			<july:delbutton page="/EditDemount.do?action=Delete" paramId="doc" paramName="document" paramScope="page"/>
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
			<TD class="buttons"><july:addbutton page="/EditDemount.do?action=Add" alttext="label.dassact.add"/><july:backbutton page="/main.do"/></td>
			<TD class="navigator"><july:navigator/></td>
		</tr>
		</table>
	</td>
</tr>
      
<july:separator colspan="<%= gColSpan %>" />
 
</july:selectableTable>

</july:browseform>
