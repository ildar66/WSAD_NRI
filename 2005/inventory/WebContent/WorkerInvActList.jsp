<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import="com.hps.july.inventory.valueobject.*" %>

<% java.lang.String gColSpan = "11"; %>

<july:browseform action="/ShowWorkerInvActList.do">

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
	if(WorkerInvActListForm.isowner[0].checked) {
		WorkerInvActListForm.ownercode.className='editdisabled';
	} else {
		WorkerInvActListForm.ownercode.className='editsearch';
	}
	WorkerInvActListForm.ownercode.disabled=WorkerInvActListForm.isowner[0].checked;
}
function switchWorker() {
	if(WorkerInvActListForm.expedtype[0].checked) {
		switchLookup('workercode', 'wrk', false);
	} else {
		switchLookup('workercode', 'wrk', true);
	}
	if(WorkerInvActListForm.expedtype[1].checked) {
		switchLookup('orgcode', 'org', false);
	} else {
		switchLookup('orgcode', 'org', true);
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
			<script language="javascript">
        switchOwner();
      </script>
		</td>
	</tr>
	<tr>
		<td class="title"><bean:message key="label.inventory.worker"/></td>
		<td class="title"><july:radio property="expedtype"
        onclick="switchWorker();"
        insertable="true" updatable="true" value="W"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<july:string property="workercode" styleId="workercode" size="5" insertable="true" updatable="true" styleClass="editkodsearch"/>
			<july:lookupbutton action="/ShowWorkerLookupList.do" styleId="wrkl" fieldNames="workercode;workername" insertable="true" updatable="true"/>
			<july:string size="35" property="workername" styleId="workername" insertable="false" updatable="false" />
		</td>
	</tr>
	<tr>
		<td class="title"><bean:message key="label.inventory.organization"/></td>
		<td class="title"><july:radio property="expedtype"
        onclick="switchWorker();"
        insertable="true" updatable="true" value="O"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<july:string property="orgcode" styleId="orgcode" size="5" insertable="true" updatable="true" styleClass="editkodsearch"/>
			<july:lookupbutton action="/ShowOrganizationLookupList.do?selisprovider=true" styleId="orgl" fieldNames="orgcode;orgname" insertable="true" updatable="true"/>
			<july:string size="35" property="orgname" styleId="orgname" insertable="false" updatable="false" />
		</td>
	</tr>
			<script language="javascript">
        switchWorker();
      </script>
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
			<TD class="buttons"><july:addbutton page="/EditWorkerInvAct.do?action=Add" alttext="label.inventory.add"/><july:backbutton page="/main.do"/></td>
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
	<july:headercolumn key="label.inventorywrk.storageplace" colType="string"/>
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
%>
<tr selectableID='<july:stringwrite name="it" property="document"/>' classReal='<%=(isAutoDoc?"autodoc":"normal")%>' class='<%=(isAutoDoc?"autodoc":"normal")%>' id='selID<july:stringwrite name="it" property="document"/>' onMouseOver='className="select"' onMouseOut="className='<%=(isAutoDoc?"autodoc":"normal")%>'">
	<td class="link">
		<% if ("1".equals(docState) && !isAutoDoc) { %>
			<july:editbutton page="/EditWorkerInvAct.do" action="Edit" paramId="document" paramName="it" paramProperty="document" paramScope="page" alttext="label.inventory.edit"/>
		<% } else { %>
			<july:editbutton page="/EditWorkerInvAct.do" action="View" paramId="document" paramName="it" paramProperty="document" paramScope="page" alttext="label.inventory.view"/>
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
			<bean:message key="label.inventory.type.byselect"/>
		<%}%>
	</td>
	<td class="text">
		<% if ("1".equals(docState)) { %><bean:message key="label.state.entering"/><% } else { %><bean:message key="label.state.calculated"/><% } %>
	</td>
	<td class="link">
	</td>
	<td class="link">
		<% if ("1".equals(docState) && !isAutoDoc) { %>
		<july:delbutton page="/EditWorkerInvAct.do?action=Delete" paramId="document" paramName="document" paramScope="page"/>
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
				<TD class="buttons"><july:addbutton page="/EditWorkerInvAct.do?action=Add" alttext="label.inventory.add"/><july:backbutton page="/main.do"/></td>
				<TD class="navigator"><july:navigator/></td>
			</tr>
			</table>
		</td>
	</tr>
      
	<july:separator colspan="<%= gColSpan %>" />
     		
    </july:selectableTable>

</july:browseform>
