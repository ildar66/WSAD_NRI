<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "8"; %>

<july:browseform action="/ShowChangeEList.do" styleId="ChangeEListForm">

<script language="javascript">
function switchLookup(itemname,lookupname,disabled) {
	if(disabled) {
		ChangeEListForm[itemname].className = 'editkoddisabled';
		ChangeEListForm[itemname].disabled = true;
		ChangeEListForm[itemname].readonly = true;
		document.all['lookupbtn_'+lookupname+'l'].disabled = true;
		document.all['lookupimg_'+lookupname+'l'].src='/images/lookup_disabled.gif';
	} else {
		ChangeEListForm[itemname].className = 'editkodsearch';
		ChangeEListForm[itemname].disabled = false;
		ChangeEListForm[itemname].readonly = false;
		document.all['lookupbtn_'+lookupname+'l'].disabled = false;
		document.all['lookupimg_'+lookupname+'l'].src='/images/lookup.gif';
	}
}

function switchFilter() {
	if(ChangeEListForm.type[0].checked) {
		switchLookup('organizationcode','rent',true);
		switchLookup('workercode','work',true);
		ChangeEListForm['organizationname'].disabled = true;
		ChangeEListForm['workername'].disabled = true;
		ChangeEListForm['workertitle'].disabled = true;
	} else if(ChangeEListForm.type[1].checked) {
		switchLookup('organizationcode','rent',false);
		switchLookup('workercode','work',true);
		ChangeEListForm['organizationname'].disabled = false;
		ChangeEListForm['workername'].disabled = true;
		ChangeEListForm['workertitle'].disabled = true;
	} else if(ChangeEListForm.type[2].checked) {
		switchLookup('organizationcode','rent',true);
		switchLookup('workercode','work',false);
		ChangeEListForm['organizationname'].disabled = true;
		ChangeEListForm['workername'].disabled = false;
		ChangeEListForm['workertitle'].disabled = false;
	} else {
		switchLookup('organizationcode','rent',false);
		switchLookup('workercode','work',false);
		ChangeEListForm['organizationname'].disabled = false;
		ChangeEListForm['workername'].disabled = false;
		ChangeEListForm['workertitle'].disabled = false;
	}
}

function switchOwner() {
	if(ChangeEListForm.isowner[0].checked) {
		ChangeEListForm.ownercode.className='editdisabled';
	} else {
		ChangeEListForm.ownercode.className='editsearch';
	}
	ChangeEListForm.ownercode.disabled=ChangeEListForm.isowner[0].checked;
}

function switchOrganization() {
	switchLookup('organizationcode','rent',ChangeEListForm.isorganization[0].checked);
	ChangeEListForm.organizationname.disabled = ChangeEListForm.isorganization[0].checked;
}

function switchWorker() {
	switchLookup('workercode','work',ChangeEListForm.isworker[0].checked);
	ChangeEListForm.workername.disabled = ChangeEListForm.isworker[0].checked;
	ChangeEListForm.workertitle.disabled = ChangeEListForm.isworker[0].checked;
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
		<td class="title"><bean:message key="label.changee.owner"/></td>
		<td class="title" colspan="2">
			<july:checkbox property="isowner" insertable="true" updatable="true" value="true" onclick="switchOwner();"/><html:hidden property="isowner" value="false"/><bean:message key="label.all"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	   		<july:select collection="owners" property="ownercode" insertable="true" updatable="true" styleClass="search">
				<html:options collection="owners" property="organization" labelProperty="name"/>
			</july:select><july:searchbutton/>
			<script language="javascript">switchOwner();</script>
		</td>
    </tr>
	<tr>
		<td class="title"><bean:message key="label.changee.date"/></td>
		<td class="title" colspan="2">
			<bean:message key="label.datefrom"/>&nbsp;<july:date property="datefromstr" size="25" insertable="true" updatable="true"/>&nbsp;&nbsp;&nbsp;<bean:message key="label.dateto"/>&nbsp;<july:date property="datetostr" size="25" insertable="true" updatable="true"/>
		</td>
	</tr>
<%--	<tr>
		<td class="title"><bean:message key="label.changee.type"/></td>
		<td class="title" colspan="2">
			<july:radio insertable="true" updatable="true" property="type" value="A" onclick="switchFilter();"/><bean:message key="label.all"/>
			<july:radio insertable="true" updatable="true" property="type" value="P" onclick="switchFilter();"/><bean:message key="label.changee.type.forp"/>
			<july:radio insertable="true" updatable="true" property="type" value="W" onclick="switchFilter();"/><bean:message key="label.changee.type.forw"/>
		</td>
	</tr>--%>
	<tr>
		<td class="title"><bean:message key="label.changee.organization"/></td>
		<td class="title" colspan="2">
			<july:checkbox property="isorganization" insertable="true" updatable="true" value="true" onclick="switchOrganization();"/><html:hidden property="isorganization" value="false"/><bean:message key="label.all"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<july:string property="organizationcode" styleId="organizationcode" size="5" insertable="true" updatable="true" styleClass="editkodsearch"/>
			<july:lookupbutton action="/ShowOrganizationLookupList.do" styleId="rentl" fieldNames="organizationcode;organizationname" newWindowName="organizationlookup"  insertable="true" updatable="true" onclick="set_opt_params_rentl('?selisprovider=true&selisrenter=false&selissupplier=false');"/>
			<july:string size="35" property="organizationname" styleId="organizationname" insertable="false" updatable="false" />
	<script language="javascript">switchOrganization();</script>
		</td>
	</tr>
<%--	<tr>
		<td class="title"><bean:message key="label.changee.worker"/></td>
		<td class="title" colspan="2">
			<july:string property="workercode" styleId="workercode" size="5" insertable="true" updatable="true"  styleClass="editkodsearch" />
			<july:lookupbutton action="/ShowWorkerLookupList.do" styleId="workl" fieldNames="workercode;workername;workertitle" newWindowName="workerlookup" insertable="true" updatable="true" />
			<july:string size="25" property="workername" styleId="workername" insertable="false" updatable="false" />
			<july:string size="20" property="workertitle" styleId="workertitle" insertable="false" updatable="false" />
		</td>--%>
    </tr>
    </table>
<%--	<script language="javascript">switchFilter();</script> --%>
  </td>
</tr>

<july:separator colspan="<%= gColSpan %>" />

<tr class="title">
	<td colspan="<%= gColSpan %>">
		<table class="buttons">
		<tr class="title">
			<TD class="buttons"><july:addbutton page="/EditChangeE.do?action=Add" alttext="label.changee.add"/><july:backbutton page="/main.do"/></td>
			<TD class="navigator"><july:navigator/></td>
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
	<july:headercolumn key="label.changee.organization" colType="string"/>
	<july:headercolumn key="label.changee.state" colType="string"/>
	<july:headercolumn key="label.void" colType="string"/>
	<july:headercolumn key="label.void" colType="string"/>
</tr>

<july:separator colspan="<%= gColSpan %>" />

<%
	String masterTagId = "changeEListWordEditMasterTagId";
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
	// String theDocument = it.getColumn("document").asString();
%>

<tr selectableID='<july:stringwrite name="it" property="document"/>' classReal='<%=(isAutoDoc?"autodoc":"normal")%>' class='<%=(isAutoDoc?"autodoc":"normal")%>' id='selID<july:stringwrite name="it" property="document"/>' onMouseOver='className="select"' onMouseOut="className='<%=(isAutoDoc?"autodoc":"normal")%>'">

	<td class="text">
		<%if("1".equals(docstate) && !isAutoDoc) {%>
			<july:editbutton page="/EditChangeE.do" action="Edit" paramId="document" paramName="document" paramScope="page" alttext="label.changee.edit"/>
		<%} else {%>
			<july:editbutton page="/EditChangeE.do" action="View" paramId="document" paramName="document" paramScope="page" alttext="label.changee.view"/>
		<%}%>
		<a name="selID<july:stringwrite name="it" property="document"/>"></a>
	</td>
	<td class="text"><july:datewrite name="it" property="blankdate"/></td>
	<td class="text">
		<%-- <july:stringwrite name="it" property="blankindex"/>&nbsp; --%>
		<july:stringwrite name="it" property="blanknumber"/>
	</td>
	<td class="text"><july:stringwrite name="it" property="exporg"/></td>
	<td class="text"><%if("1".equals(docstate)) {%><bean:message key="label.state.entering"/><%} else if("2".equals(docstate)) {%><bean:message key="label.state.calculated"/><%}%></td>
<%--
	<td class="link">
		<html:link page="/ShowChangeEPositionList.do" paramId="document" paramName="document" paramScope="page">
			<img src="/images/doc.gif" width=22 height=16 border=0 alt="<bean:message key="label.changee.positions"/>">
		</html:link>
	</td>
--%>
	<td class="link">
<%--
		<july:docprintbutton docstatebean="docstate" href="/crystalclear/changes.rpt?dll=pdschange.dll" paramId="prompt0" paramName="document" paramScope="page"/>
--%>
<%--
		<A href='javascript:printWord(<july:stringwrite name="document"/>)'>
			<img src="/images/print.gif" border=0 alt='Напечатать акт'>
		</A>
--%>		

		<july:wordEditSlave masterStyleId='<%= masterTagId %>' styleId='<%= "changeEList_" + document %>' 
			url='<%= "reports/changes.jsp?prompt1=" + document %>' 
			uploadurl=''
			updatable='false'
			documentid="<%= document %>">
			<IMG SRC="/images/docword.gif" border="0" alt='Напечатать акт'>
		</july:wordEditSlave>

	</td>
	<td class="link"><%if("1".equals(docstate)) {%><july:delbutton page="/EditChangeE.do?action=Delete" paramId="document" paramName="document" paramScope="page"/><%}%></td>
</tr>
<july:separator colspan="<%= gColSpan %>" />
</logic:present>
</logic:iterate>

<tr class="title">
	<td colspan="<%= gColSpan %>">
		<table class="buttons">
		<tr class="title">
			<TD class="buttons"><july:addbutton page="/EditChangeE.do?action=Add" alttext="label.changee.add"/><july:backbutton page="/main.do"/></td>
			<TD class="navigator"><july:navigator/></td>
		</tr>
		</table>
	</td>
</tr>
      
<july:separator colspan="<%= gColSpan %>" />
 
</july:selectableTable>

</july:browseform>
