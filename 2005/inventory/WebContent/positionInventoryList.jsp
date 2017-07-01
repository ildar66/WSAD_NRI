<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import="com.hps.july.cdbc.lib.*"%>

<% java.lang.String gColSpan = "11"; %>

<%
	String masterTagId = "changeSListWordEditMasterTagId";
%>
<july:wordEditMaster styleId='<%= masterTagId %>' >
</july:wordEditMaster>

<july:browseform action="/ShowPositionInventoryList.do" styleId="invlistformpos">

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
	if(document.all.showallowner[0].checked) {
		document.all.owner.className='editdisabled';
	} else {
		document.all.owner.className='editsearch';
	}
	document.all.owner.disabled=document.all.showallowner[0].checked;
}

function switchPosition() {
	switchLookup('position','pos',document.all.showallstorage[0].checked);
	if(document.all.showallstorage[0].checked) {
		document.all['lookupimg_coml'].src='/images/lookup_disabled.gif';
		document.all['lookupbtn_coml'].disabled = true;
		document.all.showallcomplect[0].disabled = true;
	} else {
		document.all['lookupimg_coml'].src='/images/lookup.gif';
		document.all['lookupbtn_coml'].disabled = false;
		document.all.showallcomplect[0].disabled = false;
	}
/*
//	switchComplect();

//	disable complect checkbox here

//	if(document.all.showallstorage[0].checked) {
//		document.all['lookupbtn_coml'].disabled = true;
//		document.all['lookupimg_coml'].src='/images/lookup_disabled.gif';
//	} else {
//		document.all['lookupbtn_coml'].disabled = false;
//		document.all['lookupimg_coml'].src='/images/lookup.gif';
//	}
*/
}

function switchComplect() {
	if(document.all.showallcomplect[0].checked) {
		document.all['lookupimg_coml'].src='/images/lookup_disabled.gif';
		document.all['lookupbtn_coml'].disabled = true;
	} else {
		document.all['lookupimg_coml'].src='/images/lookup.gif';
		document.all['lookupbtn_coml'].disabled = false;
	}
}
function printWord(prompt1, typeWord){
	if(typeWord == 1){
	//Напечатать акт инвентаризации:
	window.location.href='reports/invp.jsp?prompt1='+prompt1;
	} else if(typeWord == 2){
	//Напечатать акт инвентаризации:
	window.location.href='reports/inv.jsp?prompt1='+prompt1;	
	} else if(typeWord == 3){
	//Напечатать перечень недостач:
	window.location.href='reports/misp.jsp?prompt1='+prompt1;	
	} else if(typeWord == 4){
	//Напечатать перечень излишков:
	window.location.href='reports/extrap.jsp?prompt1='+prompt1;	
	}
}
</script>

<july:selectableTable modelName="list" selectable="1" paramName="selID" styleClass="main" selectedClass="selected">

<july:separator colspan="<%= gColSpan %>" />

<TR class="normal">
 <TD colspan="<%= gColSpan %>">
    <table class="find">
	<tr>
		<td class="title"><bean:message key="label.inventory.org"/></td>
		<td class="title"><july:checkbox property="showallowner" insertable="true" updatable="true" value="true" onclick="switchOwner();"/><bean:message key="label.all"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		<td class="title"><july:select collection="organizations" property="owner" insertable="true" updatable="true" styleClass="editsearch">
				<html:options collection="organizations" property="organization" labelProperty="name"/><july:searchbutton />
			</july:select><script language="javascript">switchOwner();</script>
		</td>
    </tr>        
    <tr>
       <td class="title"><bean:message key="label.inventory.date"/></td>
       <td class="title" colspan="2">
			<bean:message key="label.datefrom"/> &nbsp;&nbsp;&nbsp; <july:date property="datefromstr" size="25" insertable="true" updatable="true"/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<bean:message key="label.dateto"/> &nbsp;&nbsp;&nbsp; <july:date property="datetostr" size="25" insertable="true" updatable="true"/>
</td>
	</tr>
    <tr>
		<td class="title"><bean:message key="label.inventory.position"/></td>
		<td class="title"><july:checkbox property="showallstorage" insertable="true" updatable="true" value="true" onclick="switchPosition();" /><bean:message key="label.all"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		<td class="title"><july:string property="position" styleId="position" size="10" insertable="true" updatable="true" styleClass="editkodsearch"/>
			<july:lookupbutton action="/ShowPositionLookupList.do" styleId="posl" fieldNames="position;positionid;positionname;complect;complectname" insertable="true" updatable="true"/>
			<july:string size="10" property="positionid" styleId="positioid" insertable="false" updatable="false" />
			<july:string size="35" property="positionname" styleId="positionname" insertable="false" updatable="false" />
		</td>
    </tr>        
    <tr>
		<td class="title"><bean:message key="label.inventory.complect"/></td>
		<td class="title"><july:checkbox property="showallcomplect" insertable="true" updatable="true" value="true" onclick="switchComplect();" /><bean:message key="label.all"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		<td class="title">
			<html:hidden property="complect"/>
<!--			<july:string property="complect" styleId="complect" size="10" insertable="true" updatable="true" styleClass="editkodsearch" /> -->
			<july:string size="45" property="complectname" styleId="complectname" insertable="false" updatable="false" />
			<july:lookupbutton action="/ShowComplectLookupList.do" styleId="coml" fieldNames="complect;complectname" insertable="true" updatable="true" onclick="set_opt_params_coml('?position='+document.all.position.value)"/>
		</td>
    </tr>
<script language="javascript">
switchPosition();
switchComplect();
</script>
    </table>
  </td>
</tr>


<july:separator colspan="<%= gColSpan %>" />

<tr class="title">
	<td colspan="<%= gColSpan %>">
		<table class="buttons">
		<tr class="title">
			<TD class="buttons"><july:addbutton page="/EditPositionInventory.do?action=Add" alttext="label.inventory.add"/><july:backbutton page="/main.do"/></td>
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
	<july:headercolumn key="label.inventory.placename" colType="string"/>
	<july:headercolumn key="label.inventory.type" colType="string"/>
	<july:headercolumn key="label.inventory.state" colType="string"/>
<%--	<july:headercolumn key="label.void" colType="string"/> --%>
	<july:headercolumn key="label.print" colType="string"/>
	<td class="title">&nbsp;</td>
</tr>

<july:separator colspan="<%= gColSpan %>" />
    
<!-- Table body -->
<logic:iterate id="it" name="browseList">
	<logic:present name="it">
<%
	CDBCRowObject ro = (CDBCRowObject)it;
	String doc = ro.getColumn("document").asString();
	String docstate = ro.getColumn("state").asString();
	String invtype = ro.getColumn("type").asString();
	String invtypelabel = "label.void";
	pageContext.setAttribute("it_document",doc);
	pageContext.setAttribute("it_state",docstate);

	if("F".equals(invtype)) {
		invtypelabel = "label.inventory.type.full";
	} else if("A".equals(invtype)) {
		invtypelabel = "label.inventory.type.byunit";
	} else if("P".equals(invtype)) {
		invtypelabel = "label.inventory.type.byselect";
	}
	boolean curAutoDoc = "Y".equals(ro.getColumn("isautodoc").asString());
%>
		<tr selectableID='<july:stringwrite name="it" property="document"/>' classReal='<%=(curAutoDoc?"autodoc":"normal")%>' class='<%=(curAutoDoc?"autodoc":"normal")%>' id='selID<july:stringwrite name="it" property="document"/>' onMouseOver='className="select"' onMouseOut="className='<%=(curAutoDoc?"autodoc":"normal")%>'">
			<td class="link">
				<%if("1".equals(docstate) && !curAutoDoc) {%>
					<july:editbutton page="/EditPositionInventory.do" action="Edit" paramId="document" paramName="it_document" paramScope="page" alttext="label.inventory.edit"/>
				<%} else {%>
					<july:editbutton page="/EditPositionInventory.do" action="View" paramId="document" paramName="it_document" paramScope="page" alttext="label.inventory.view"/>
				<%}%>
				<a name="selID<july:stringwrite name="it" property="document"/>"></a>
<%--
				<july:editbutton page="/EditPositionInventory.do" action="View" paramId="document" paramName="it_document" paramScope="page" alttext="label.inventory.view"/>
--%>
			</td>
			<td class="text">
				<july:datewrite name="it" property="docdate"/>
			</td>
			<td class="number">
				<july:stringwrite name="it" property="docnumber"/>
			</td>
			<td class="text">
				<july:stringwrite name="it" property="smanname"/>
			</td>
			<td class="text">
				<july:stringwrite name="it" property="posname"/>,<br><july:stringwrite name="it" property="equname"/>
			</td>
			<td class="text">
				<bean:message key='<%=invtypelabel%>'/>
			</td>
			<td class="link">
<%--				<html:link page="/EditPositionInventoryState.do?action=Edit" paramId="doc" paramName="it_document" paramScope="page"> --%>
				<%if("1".equals(docstate)) {%>
					<bean:message key="label.state.entering"/>
				<%} else if("2".equals(docstate)) {%>
					<bean:message key="label.state.calculated"/>
				<%}%>
<%--				</html:link>--%>
			</td><%--
			<td class="link">
				<html:link page="/ShowInvPosList.do" paramId="document" paramName="it_document" paramScope="page"><img src="/images/doc.gif" width=22 height=16 border=0></html:link>
			</td>
		--%>	<td class="link">
		
				<%if("A".equals(invtype)) {%>
<%--
					<july:docprintbutton docstatebean="it_state" href="/crystalclear/invp.rpt?dll=pdsinvents.dll" paramId="prompt0" paramName="it_document" paramScope="page" alt="Напечатать акт инвентаризации" />
--%>
<%--
					<A href='javascript:printWord(<july:stringwrite name="it_document"/>, 1)'>
						<img src="/images/print.gif" border=0 alt='Напечатать акт инвентаризации'>
					</A>
--%>					
		<july:wordEditSlave masterStyleId='<%= masterTagId %>' styleId='<%= "positionInventory01_" + doc %>' 
		url='<%= "reports/invp.jsp?prompt1=" + doc %>' 
			uploadurl=''
			updatable='false'
		documentid='<%= doc %>'><IMG SRC="/images/docword.gif" border="0" alt='Напечатать акт инвентаризации'></july:wordEditSlave>
				<%} else {%>
<%--
					<july:docprintbutton docstatebean="it_state" href="/crystalclear/inv.rpt?dll=pdsinvents.dll" paramId="prompt0" paramName="it_document" paramScope="page" alt="Напечатать акт инвентаризации" />
--%>
<%--
					<A href='javascript:printWord(<july:stringwrite name="it_document"/>, 2)'>
						<img src="/images/print.gif" border=0 alt='Напечатать акт инвентаризации'>
					</A>
--%>
		<july:wordEditSlave masterStyleId='<%= masterTagId %>' styleId='<%= "positionInventory02_" + doc %>' 
		url='<%= "reports/inv.jsp?prompt1=" + doc %>' 
			uploadurl=''
			updatable='false'
		documentid='<%= doc %>'><IMG SRC="/images/docword.gif" border="0" alt='Напечатать акт инвентаризации'></july:wordEditSlave>
				<%}%><br>
				<%if("2".equals(docstate)) {%>
<%--
					<july:docprintbutton docstatebean="it_state" href="/crystalclear/misp.rpt?dll=pdsmis.dll" paramId="prompt0" paramName="it_document" paramScope="page" image="print_lose.gif" alt="Напечатать перечень недостач" />
--%>
<%--
					<A href='javascript:printWord(<july:stringwrite name="it_document"/>, 3)'>
						<img src="/images/print_lose.gif" border=0 alt='Напечатать перечень недостач'>
					</A>
--%>					
<%--
					<july:docprintbutton docstatebean="it_state" href="/crystalclear/extrap.rpt?dll=pdsextra.dll" paramId="prompt0" paramName="it_document" paramScope="page"image="print_plus.gif" alt="Напечатать перечень излишков" />
--%>
<%--
					<A href='javascript:printWord(<july:stringwrite name="it_document"/>, 4)'>
						<img src="/images/print_plus.gif" border=0 alt='Напечатать перечень излишков'>
					</A>
--%>
			<july:wordEditSlave masterStyleId='<%= masterTagId %>' styleId='<%= "positionInventory03_" + doc %>' 
			url='<%= "reports/misp.jsp?prompt1=" + doc %>' 
			uploadurl=''
			updatable='false'
			documentid='<%= doc %>'><IMG SRC="/images/print_lose.gif" border="0" alt='Напечатать перечень недостач'></july:wordEditSlave>
			<july:wordEditSlave masterStyleId='<%= masterTagId %>' styleId='<%= "positionInventory04_" + doc %>' 
			url='<%= "reports/extrap.jsp?prompt1=" + doc %>' 
			uploadurl=''
			updatable='false'
			documentid='<%= doc %>'><IMG SRC="/images/print_plus.gif" border="0" alt='Напечатать перечень излишков'></july:wordEditSlave>
				<%}%>
			</td>
			<td class="link">
				<%if("1".equals(docstate)) {%>
					<july:delbutton page="/EditPositionInventory.do?action=Delete" paramId="document" paramName="it_document" paramScope="page"/>
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
			<TD class="buttons"><july:addbutton page="/EditPositionInventory.do?action=Add" alttext="label.inventory.add"/><july:backbutton page="/main.do"/></td>
			<TD class="navigator"><july:navigator/></td>
		</tr>
		</table>
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>" />
		
</july:selectableTable>

</july:browseform>
