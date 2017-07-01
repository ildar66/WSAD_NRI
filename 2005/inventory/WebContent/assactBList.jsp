<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "10"; %>

<july:browseform action="/ShowAssactBList.do" styleId="AssactBListForm">

<script language="javascript">
function switchLookup(itemname,lookupname,disabled) {
	if(disabled) {
		AssactBListForm[itemname].className = 'editkoddisabled';
		AssactBListForm[itemname].disabled = true;
		AssactBListForm[itemname].readonly = true;
		document.all['lookupbtn_'+lookupname+'l'].disabled = true;
		document.all['lookupimg_'+lookupname+'l'].src='/images/lookup_disabled.gif';
	} else {
		AssactBListForm[itemname].className = 'editkodsearch';
		AssactBListForm[itemname].disabled = false;
		AssactBListForm[itemname].readonly = false;
		document.all['lookupbtn_'+lookupname+'l'].disabled = false;
		document.all['lookupimg_'+lookupname+'l'].src='/images/lookup.gif';
	}
}

function switchOwner() {
	if(AssactBListForm.isowner[0].checked) {
		AssactBListForm.organization.disabled=true;
		AssactBListForm.organization.className = 'editdisabled';
	} else {
		AssactBListForm.organization.disabled=false;
		AssactBListForm.organization.className = 'editsearch';
	}
}
function switchPosition() {
	switchLookup('positionFrm','pos',AssactBListForm.isposition[0].checked);
}
function printWord(prompt1){
	//Печать актов:
	window.location.href='reports/assactbp.jsp?prompt1='+prompt1;
}
</script>

<july:selectableTable modelName="list" selectable="1" paramName="selID" styleClass="main" selectedClass="selected">

<july:separator colspan="<%= gColSpan %>" />

<TR class="normal">
 <TD colspan="<%= gColSpan %>">
 
    <table class="find">
    <tr>
		<td class="title"><bean:message key="label.assactb.owner"/></td>
		<td class="title">
			<july:checkbox property="isowner" insertable="true" updatable="true" value="true" onclick="switchOwner();"/><bean:message key="label.all"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	   		<july:select collection="owners" property="organization" insertable="true" updatable="true" styleClass="search">
				<html:options collection="owners" property="organization" labelProperty="name"/>
			</july:select><july:searchbutton/>
		</td>
    </tr>
    <tr>
		<td class="title"><bean:message key="label.assactb.position"/></td>
		<td class="title">
			<july:checkbox property="isposition" insertable="true" updatable="true" value="true" onclick="switchPosition();"/><html:hidden property="isposition" value="false"/><bean:message key="label.all"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<july:string property="positionFrm" styleId="positionFrm" size="5" insertable="true" updatable="true" styleId="editkodsearch"/>
			<july:lookupbutton action="/ShowPositionLookupList.do" styleId="posl" fieldNames="positionFrm;positionid;positionname" newWindowName="poslookup" insertable="true" updatable="true" />
			<july:string size="10" property="positionid" styleId="positionid" insertable="false" updatable="false" />
			<july:string size="25" property="positionname" styleId="positionname" insertable="false" updatable="false" />
		</td>
	</tr>
	<tr>
		<td class="title"><bean:message key="label.assactb.period"/></td>
		<td class="title" style="vertical-align: top;">
           <table class="find">
            <tr>
			<td class="title"><bean:message key="label.assactb.periodfrom"/>&nbsp;</td>
            <td class="title"><july:date property="startDateFrm" insertable="true" updatable="true"/></td>
            <td class="title">&nbsp;</td>
			<td class="title"><bean:message key="label.assactb.periodto"/>&nbsp;</td>
            <td class="title"><july:date property="endDateFrm" insertable="true" updatable="true"/></td>
            </tr>
            </table>
		</td>
	</tr>
    </table>
    
  </TD>
</TR>

<script language="javascript">
	switchPosition();
	switchOwner();
</script>

		<july:separator colspan="<%= gColSpan %>" />

		<tr class="title">
			<td colspan="<%= gColSpan %>">
				<table class="buttons">
				<tr class="title">
					<TD class="buttons"><july:addbutton page="/EditAssactB.do?action=Add" alttext="label.assact.add"/><july:backbutton page="/main.do"/></td>
					<TD class="navigator"><july:navigator/></td>
				</tr>
				</table>
			</td>
		</tr>

<july:separator colspan="<%= gColSpan %>" />
<!-- Table header -->
<tr class="title">
	<july:headercolumn key="label.void" colType="string"/>
	<july:sortcolumn key="label.assactb.date" colType="string" ascFinder="3" descFinder="4"/>
	<july:sortcolumn key="label.assactb.num" colType="number" ascFinder="1" descFinder="2"/>
	<july:headercolumn key="label.assactb.owner" colType="string"/>
	<july:headercolumn key="label.assactb.positionname" colType="string"/>
	<july:headercolumn key="label.assactb.state" colType="string"/>
	<td class="title">&nbsp;</td>
	<td class="title">&nbsp;</td>
</tr>
<july:separator colspan="<%= gColSpan %>" />
<!-- Table body -->

<%
	String masterTagId = "assactBListWordEditMasterTagId";
%>
<july:wordEditMaster styleId='<%= masterTagId %>' >
</july:wordEditMaster>

<logic:iterate id="it" name="browseList" type="com.hps.july.cdbc.lib.CDBCRowObject">
<logic:present name="it">
<%
	String document = it.getColumn("document").asString();
	pageContext.setAttribute("document",document);
	String docstate = it.getColumn("docstate").asString();
	pageContext.setAttribute("docstate",docstate);
	boolean isAutoDoc = "Y".equals(it.getColumn("isautodoc").asString());
	String theDocument = it.getColumn("document").asString();
%>
<tr selectableID='<july:stringwrite name="it" property="document"/>' classReal='<%=(isAutoDoc?"autodoc":"normal")%>' class='<%=(isAutoDoc?"autodoc":"normal")%>' id='selID<july:stringwrite name="it" property="document"/>' onMouseOver='className="select"' onMouseOut="className='<%=(isAutoDoc?"autodoc":"normal")%>'">
	<td class="text">
		<%if("1".equals(docstate) && !isAutoDoc) {%>
			<july:editbutton page="/EditAssactB.do" action="Edit" paramId="document" paramName="document" paramScope="page" alttext="label.assact.edit"/>
		<%} else {%>
			<july:editbutton page="/EditAssactB.do" action="View" paramId="document" paramName="document" paramScope="page" alttext="label.assact.view"/>
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
	<td class="text"><%if("1".equals(docstate)) {%><bean:message key="label.state.entering"/><%} else if("2".equals(docstate)) {%><bean:message key="label.state.calculated"/><%}%></td>
	<td class="link">
<%--
		<july:docprintbutton docstatebean="docstate" href="/crystalclear/assactbp.rpt?dll=pdsassactb.dll" paramId="prompt0" paramName="document" paramScope="page"/>
--%>
<%--
		<A href='javascript:printWord(<july:stringwrite name="document"/>)'>
			<img src="/images/print.gif" border=0 alt='Напечатать акт'>
		</A>
--%>
<july:wordEditSlave masterStyleId='<%= masterTagId %>' styleId='<%= "assactBList_" + theDocument %>' 
		url='<%= "reports/assactbp.jsp?prompt1=" + theDocument %>' 
			uploadurl=''
			updatable='false'
		documentid="<%= theDocument %>">
		<IMG SRC="/images/docword.gif" border="0" alt='Напечатать акт'>
</july:wordEditSlave>
	</td>
	<td class="link"><%if("1".equals(docstate)) {%><july:delbutton page="/EditAssactB.do?action=Delete" paramId="document" paramName="document" paramScope="page"/><%}%></td>
</tr>
<july:separator colspan="<%= gColSpan %>" />
</logic:present>
</logic:iterate>
<tr class="title">
	<td colspan="<%= gColSpan %>">
	<table class="buttons">
	<tr class="title">
		<TD class="buttons"><july:addbutton page="/EditAssactB.do?action=Add" alttext="label.assact.add"/><july:backbutton page="/main.do"/></td>
		<TD class="navigator"><july:navigator/></td>
	</tr>
	</table>
	</td>
</tr>
<july:separator colspan="<%= gColSpan %>" />

</july:selectableTable>
</july:browseform>
