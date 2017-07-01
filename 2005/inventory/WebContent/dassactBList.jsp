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

<july:browseform action="/ShowDAssactBList.do" styleId="DAssactBListForm">

<script language="javascript">
function switchLookup(itemname,lookupname,disabled) {
	if(disabled) {
		DAssactBListForm[itemname].className = 'editkoddisabled';
		DAssactBListForm[itemname].disabled = true;
		DAssactBListForm[itemname].readonly = true;
		document.all['lookupbtn_'+lookupname+'l'].disabled = true;
		document.all['lookupimg_'+lookupname+'l'].src='/images/lookup_disabled.gif';
	} else {
		DAssactBListForm[itemname].className = 'editkodsearch';
		DAssactBListForm[itemname].disabled = false;
		DAssactBListForm[itemname].readonly = false;
		document.all['lookupbtn_'+lookupname+'l'].disabled = false;
		document.all['lookupimg_'+lookupname+'l'].src='/images/lookup.gif';
	}
}

function switchOwner() {
	if(DAssactBListForm.isowner[0].checked) {
		DAssactBListForm.organization.disabled=true;
		DAssactBListForm.organization.className = 'editdisabled';
	} else {
		DAssactBListForm.organization.disabled=false;
		DAssactBListForm.organization.className = 'editsearch';
	}
}
function switchPosition() {
	switchLookup('position','pos',DAssactBListForm.isposition[0].checked);
}
function printWord(prompt1){
	//Печать актов:
	window.location.href='reports/dassactbp.jsp?prompt1='+prompt1;
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
			<july:string property="position" styleId="position" size="5" insertable="true" updatable="true" styleId="editkodsearch"/>
			<july:lookupbutton action="/ShowPositionLookupList.do" styleId="posl" fieldNames="position;positionid;positionname" newWindowName="poslookup" insertable="true" updatable="true" />
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
					<TD class="buttons"><july:addbutton page="/EditDAssactB.do?action=Add" alttext="label.dassact.add"/><july:backbutton page="/main.do"/></td>
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
	<td class="title"><bean:message key="label.assactb.positionname"/></td>
	<july:headercolumn key="label.assactb.state" colType="string"/>
	<td class="title">&nbsp;</td>
	<td class="title">&nbsp;</td>
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
			<july:editbutton page="/EditDAssactB.do" action="Edit" paramId="document" paramName="document" paramScope="page" alttext="label.dassact.edit"/>
		<%} else {%>
			<july:editbutton page="/EditDAssactB.do" action="View" paramId="document" paramName="document" paramScope="page" alttext="label.dassact.view"/>
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
	<td class="text">
		<%if("1".equals(docstate)) {%><bean:message key="label.state.entering"/><%}%><%if("2".equals(docstate)) {%><bean:message key="label.state.calculated"/><%}%>
<%--
		<html:link page="/EditDAssactstB.do?action=Edit" paramId="doc" paramName="document" paramScope="page">
			<%if("1".equals(docstate)) {%><bean:message key="label.state.entering"/><%}%>
			<%if("2".equals(docstate)) {%><bean:message key="label.state.calculated"/><%}%>
		</html:link>
--%>
	</td>
<%--
	<td class="link">
		<html:link page="/ShowDAssactposBList.do" paramId="document" paramName="document" paramScope="page">
			<img src="/images/doc.gif" width=22 height=16 border=0 alt="<bean:message key="label.assactb.positions"/>">
		</html:link>
	</td>
--%>
	<td class="link">
<%--
		<july:docprintbutton docstatebean="documentState" href="/crystalclear/dassactbp.rpt?dll=pdsassactb.dll" paramId="prompt0" paramName="document" paramScope="page"/>
--%>
<%--
		<A href='javascript:printWord(<july:stringwrite name="document"/>)'>
			<img src="/images/print.gif" border=0 alt='Напечатать акт'>
		</A>
--%>		
		<july:wordEditSlave masterStyleId='<%= masterTagId %>' styleId='<%= "dassactBList_" + theDocument %>' 
			url='<%= "reports/dassactbp.jsp?prompt1=" + theDocument %>' 
			uploadurl=''
			updatable='false'
			documentid='<%= theDocument %>'>
			<IMG SRC="/images/docword.gif" border="0" alt='Напечатать акт'>
		</july:wordEditSlave>
	</td>
	<td class="link">
		<%if("1".equals(docstate)) {%>
			<july:delbutton page="/EditDAssactB.do?action=Delete" paramId="document" paramName="document" paramScope="page"/>
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
		<TD class="buttons"><july:addbutton page="/EditDAssactB.do?action=Add" alttext="label.dassact.add"/><july:backbutton page="/main.do"/></td>
		<TD class="navigator"><july:navigator/></td>
	</tr>
	</table>
	</td>
</tr>
      
		<july:separator colspan="<%= gColSpan %>" />

    </july:selectableTable>

</july:browseform>
