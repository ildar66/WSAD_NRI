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

<july:browseform action="/ShowReqList.do" styleId="ReqListForm">

<script language="javascript">
function switchLookup(itemname,lookupname,disabled) {
	if(disabled) {
		ReqListForm[itemname].className = 'editkoddisabled';
		ReqListForm[itemname].disabled = true;
		ReqListForm[itemname].readonly = true;
		document.all['lookupbtn_'+lookupname+'l'].disabled = true;
		document.all['lookupimg_'+lookupname+'l'].src='/images/lookup_disabled.gif';
	} else {
		ReqListForm[itemname].className = 'editkodsearch';
		ReqListForm[itemname].disabled = false;
		ReqListForm[itemname].readonly = false;
		document.all['lookupbtn_'+lookupname+'l'].disabled = false;
		document.all['lookupimg_'+lookupname+'l'].src='/images/lookup.gif';
	}
}

function switchFilter() {
	if(ReqListForm.type[0].checked) {
		switchLookup('organizationcode','org',true);
		switchLookup('workercode','work',true);
		ReqListForm['organizationname'].disabled = true;
		ReqListForm['workername'].disabled = true;
		ReqListForm['workertitle'].disabled = true;
		ReqListForm.isorganization[0].disabled = true;
		ReqListForm.isworker[0].disabled = true;
	} else if(ReqListForm.type[1].checked) {
		switchLookup('organizationcode','org',false);
		switchLookup('workercode','work',true);
		ReqListForm['organizationname'].disabled = false;
		ReqListForm['workername'].disabled = true;
		ReqListForm['workertitle'].disabled = true;
		ReqListForm.isorganization[0].disabled = false;
		ReqListForm.isworker[0].disabled = true;
	} else if(ReqListForm.type[2].checked) {
		switchLookup('organizationcode','org',true);
		switchLookup('workercode','work',false);
		ReqListForm['organizationname'].disabled = true;
		ReqListForm['workername'].disabled = false;
		ReqListForm['workertitle'].disabled = false;
		ReqListForm.isorganization[0].disabled = true;
		ReqListForm.isworker[0].disabled = false;
	} else {
		switchLookup('organizationcode','org',false);
		switchLookup('workercode','work',false);
		ReqListForm['organizationname'].disabled = false;
		ReqListForm['workername'].disabled = false;
		ReqListForm['workertitle'].disabled = false;
		ReqListForm.isorganization[0].disabled = false;
		ReqListForm.isworker[0].disabled = false;
	}
}

function switchDivision() {
	switchLookup('divisioncode','div',ReqListForm.isdivision[0].checked);
}

function switchPosition() {
	switchLookup('positioncode','pos',ReqListForm.isposition[0].checked);
}

function switchOrganization() {
	switchLookup('organizationcode','org',ReqListForm.isorganization[0].checked);
}

function switchWorker() {
	switchLookup('workercode','work',ReqListForm.isworker[0].checked);
}

function printWord(prompt1){
	//Печать актов требования на складе:
	window.location.href='reports/req.jsp?prompt1='+prompt1;
}
</script>

<html:hidden property="company" />

<july:selectableTable modelName="list" selectable="1" paramName="selID" styleClass="main" selectedClass="selected">

<july:separator colspan="<%= gColSpan %>" />

<TR class="normal">
 <TD colspan="<%= gColSpan %>">
 
    <table class="find">
    <tr>
		<td class="title"><bean:message key="label.req.division"/></td>
		<td class="title" colspan="2">
			<july:checkbox property="isdivision" insertable="true" updatable="true" value="true" onclick="switchDivision();"/><html:hidden property="isdivision" value="false"/><bean:message key="label.all"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<july:string property="divisioncode" styleId="divisioncode" size="5" insertable="true" updatable="true" styleId="editkodsearch"/>
			<july:lookupbutton action="/ShowDivisionLookupList.do" styleId="divl" fieldNames="divisioncode;divisionname" newWindowName="divisionslookup" insertable="true" updatable="true" onclick="set_opt_params_divl('?company='+document.all.company.value);"/>
			<july:string size="25" property="divisionname" styleId="divisionname" insertable="false" updatable="false" /><july:searchbutton />
			<script language="javascript">switchDivision();</script>
		</td>
    </tr>
	<tr>
		<td class="title"><bean:message key="label.req.date"/></td>
		<td class="title" colspan="2">
			<bean:message key="label.datefrom"/>&nbsp;<july:date property="datefromstr" size="25" insertable="true" updatable="true"/>&nbsp;&nbsp;&nbsp;<bean:message key="label.dateto"/>&nbsp;<july:date property="datetostr" size="25" insertable="true" updatable="true"/>
		</td>
	</tr>
	<tr>
		<td class="title"><bean:message key="label.req.position"/></td>
		<td class="title">
			<july:checkbox property="isposition" insertable="true" updatable="true" value="true" onclick="switchPosition();"/><html:hidden property="isposition" value="false"/><bean:message key="label.all"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<july:string property="positioncode" styleId="positioncode" size="5" insertable="true" updatable="true" styleId="editkodsearch"/>
			<july:lookupbutton action="/ShowPositionLookupList.do" styleId="posl" fieldNames="positioncode;positionid;positionname" newWindowName="poslookup" insertable="true" updatable="true" />
			<july:string size="10" property="positionid" styleId="positionid" insertable="false" updatable="false" />
			<july:string size="25" property="positionname" styleId="positionname" insertable="false" updatable="false" />
			<script language="javascript">switchPosition();</script>
		</td>
	</tr>
	<tr>
		<td class="title"><bean:message key="label.req.type"/></td>
		<td class="title" colspan="2">
			<july:radio insertable="true" updatable="true" property="type" value="A" onclick="switchFilter();"/><bean:message key="label.all"/>
			<july:radio insertable="true" updatable="true" property="type" value="P" onclick="switchFilter();"/><bean:message key="label.acttype.forp"/>
			<july:radio insertable="true" updatable="true" property="type" value="W" onclick="switchFilter();"/><bean:message key="label.acttype.forw"/>
		</td>
	</tr>
    <tr>
		<td class="title"><bean:message key="label.req.organization"/></td>
		<td class="title" colspan="2">
			<july:checkbox property="isorganization" insertable="true" updatable="true" value="true" onclick="switchOrganization();"/><html:hidden property="isorganization" value="false"/><bean:message key="label.all"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<july:string property="organizationcode" styleId="organizationcode" size="5" insertable="true" updatable="true" styleClass="editkodsearch"/>
			<july:lookupbutton action="/ShowOrganizationLookupList.do" styleId="orgl" fieldNames="organizationcode;organizationname" newWindowName="organizationlookup"  insertable="true" updatable="true" onclick="set_opt_params_orgl('?selisprovider=true&selisrenter=false&selissupplier=false');"/>
			<july:string size="35" property="organizationname" styleId="organizationname" insertable="false" updatable="false" />
			<script language="javascript">switchOrganization();</script>
		</td>
    </tr>
    <tr>
		<td class="title"><bean:message key="label.req.worker"/></td>
		<td class="title" colspan="2">
			<july:checkbox property="isworker" insertable="true" updatable="true" value="true" onclick="switchWorker();"/><html:hidden property="isworker" value="false"/><bean:message key="label.all"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<july:string property="workercode" styleId="workercode" size="5" insertable="true" updatable="true"  styleClass="editkodsearch" />
			<july:lookupbutton action="/ShowWorkerLookupList.do" styleId="workl" fieldNames="workercode;workername;workertitle" newWindowName="workerlookup" insertable="true" updatable="true" />
			<july:string size="25" property="workername" styleId="workername" insertable="false" updatable="false" />
			<july:string size="20" property="workertitle" styleId="workertitle" insertable="false" updatable="false" />
			<script language="javascript">switchWorker();</script>
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
			<TD class="buttons"><july:addbutton page="/EditReq.do?action=Add" alttext="label.req.add"/><july:backbutton page="/main.do"/></td>
			<TD class="navigator"><july:navigator/></td>
		</tr>
		</table>
	</td>
</tr>
        
<july:separator colspan="<%= gColSpan %>" />

<!-- Table header -->
<tr class="title">
	<july:headercolumn key="label.void" colType="number"/>
	<july:headercolumn key="label.void" colType="string"/>
	<july:sortcolumn key="label.req.date" colType="string" ascFinder="3" descFinder="4"/>
	<july:sortcolumn key="label.num" colType="number" ascFinder="1" descFinder="2"/>
	<july:headercolumn key="label.req.expedition" colType="string"/>
	<july:headercolumn key="label.req.position" colType="string"/>
	<july:headercolumn key="label.req.state" colType="string"/>
	<july:headercolumn key="label.void" colType="string"/>
	<july:headercolumn key="label.void" colType="string"/>
</tr>

<july:separator colspan="<%= gColSpan %>" />

<!-- Table body -->
<logic:iterate id="it" name="browseList" type="com.hps.july.cdbc.lib.CDBCRowObject">
<logic:present name="it">
<%
	String docstate = it.getColumn("docstate").asString();
	pageContext.setAttribute("docstate",docstate);
	boolean isautodoc = "Y".equals(it.getColumn("isautodoc").asString());
	String document = it.getColumn("document").asString();
	pageContext.setAttribute("document",document);
%>
<july:selectableTR styleId="<%=document%>" paramName="selID" selectable="true" styleClass="normal"  onmouseover="className='select'" onmouseout="className='normal'">
<td class="text">
	<%if("1".equals(docstate) && !isautodoc) {%>
		<july:editbutton page="/EditReq.do" action="Edit" paramId="document" paramName="document" paramScope="page" alttext="label.req.edit"/>
	<%} else {%>
		<july:editbutton page="/EditReq.do" action="View" paramId="document" paramName="document" paramScope="page" alttext="label.req.view"/>
	<%}%>
	<july:anchor />
</td>
<td class="text">
	<html:link page="/EditReq.do?action=Add" paramId="copydoc" paramName="document" paramScope="page"><bean:message key="label.req.copy"/></html:link>
</td>
<td class="text"><july:datewrite name="it" property="blankdate"/></td>
<td class="text">
	<%-- <july:stringwrite name="it" property="blankindex"/>&nbsp; --%>
	<july:stringwrite name="it" property="blanknumber"/>
</td>
<td class="text"><july:stringwrite name="it" property="expedition"/></td>
<td class="text"><july:stringwrite name="it" property="posname"/></td>
<td class="text"><%if("1".equals(docstate)) {%><bean:message key="label.state.entering"/><%}%><%if("2".equals(docstate)) {%><bean:message key="label.state.calculated"/><%}%></td>
<td class="link">
<%--
	<july:docprintbutton docstatebean="docstate" href="/crystalclear/req.rpt?dll=pdsreq.dll" paramId="prompt0" paramName="document" paramScope="page"/>
--%>
<%--
	<A href='javascript:printWord(<july:stringwrite name="document"/>)'>
		<img src="/images/print.gif" border=0 alt='Напечатать акт требования'>
	</A>
--%>
		<july:wordEditSlave masterStyleId='<%= masterTagId %>' styleId='<%= "reqList_" + document %>' 
			url='<%= "reports/req.jsp?prompt1=" + document %>' 
			uploadurl=''
			updatable='false'
			documentid='<%= document %>'>
			<IMG SRC="/images/docword.gif" border="0" alt='Напечатать акт требования'>
		</july:wordEditSlave>
</td>
<td class="link"><%if("1".equals(docstate)) {%><july:delbutton page="/EditReq.do?action=Delete" paramId="document" paramName="document" paramScope="page"/><%}%></td>
</july:selectableTR>
<july:separator colspan="<%= gColSpan %>" />
</logic:present>
</logic:iterate>

<tr class="title">
	<td colspan="<%= gColSpan %>">
		<table class="buttons">
		<tr class="title">
			<TD class="buttons"><july:addbutton page="/EditReq.do?action=Add" alttext="label.req.add"/><july:backbutton page="/main.do"/></td>
			<TD class="navigator"><july:navigator/></td>
		</tr>
		</table>
	</td>
</tr>
      
<july:separator colspan="<%= gColSpan %>" />
  
</july:selectableTable>

</july:browseform>
