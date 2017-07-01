<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "15"; %>

<july:browseform action="/ShowFaultList.do" styleId="FaultListForm">

<script language="javascript">
function switchLookup(itemname,lookupname,disabled) {
	if(disabled) {
		FaultListForm[itemname].className = 'editkoddisabled';
		FaultListForm[itemname].disabled = true;
		FaultListForm[itemname].readonly = true;
		document.all['lookupbtn_'+lookupname+'l'].disabled = true;
		document.all['lookupimg_'+lookupname+'l'].src='/images/lookup_disabled.gif';
	} else {
		FaultListForm[itemname].className = 'editkodsearch';
		FaultListForm[itemname].disabled = false;
		FaultListForm[itemname].readonly = false;
		document.all['lookupbtn_'+lookupname+'l'].disabled = false;
		document.all['lookupimg_'+lookupname+'l'].src='/images/lookup.gif';
	}
}

function switchOwner() {
	if(FaultListForm.isowner[0].checked) {
		FaultListForm.ownercode.className='editdisabled';
	} else {
		FaultListForm.ownercode.className='editsearch';
	}
	FaultListForm.ownercode.disabled=FaultListForm.isowner[0].checked;
}

function switchStorage() {
	if(FaultListForm.isstorage[0].checked) {
		FaultListForm.storagecode.className='editdisabled';
	} else {
		FaultListForm.storagecode.className='editsearch';
	}
	FaultListForm.storagecode.disabled=FaultListForm.isstorage[0].checked;
}

function switchDivision() {
	switchLookup('divisioncode','div',FaultListForm.isdivision[0].checked);
}

function switchWorker() {
	switchLookup('workercode','work',FaultListForm.isworker[0].checked);
}

//function switchPosition() {
//	switchLookup('positioncode','pos',FaultListForm.isposition[0].checked);
//}

function switchResource() {
	switchLookup('resourcecode','res',FaultListForm.isresource[0].checked);
}
</script>

<july:selectableTable modelName="list" selectable="1" paramName="selID" styleClass="main" selectedClass="selected">

<july:separator colspan="<%= gColSpan %>" />

<TR class="normal">
   <TD colspan="<%= gColSpan %>">
	<table class="find">
	<tr>
		<td class="title"><bean:message key="label.fault.owner"/></td>
		<td class="title" colspan="2">
			<july:checkbox property="isowner" insertable="true" updatable="true" value="true" onclick="switchOwner();"/><html:hidden property="isowner" value="false"/><bean:message key="label.all"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	   		<july:select collection="owners" property="ownercode" insertable="true" updatable="true" styleClass="search">
				<html:options collection="owners" property="organization" labelProperty="name"/>
			</july:select><july:searchbutton/>
			<script language="javascript">switchOwner();</script>
		</td>
	</tr>
	<tr>
		<td class="title"><bean:message key="label.fault.division"/></td>
		<td class="title" colspan="2">
			<july:checkbox property="isdivision" insertable="true" updatable="true" value="true" onclick="switchDivision();"/><html:hidden property="isdivision" value="false"/><bean:message key="label.all"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<july:string property="divisioncode" styleId="divisioncode" size="5" insertable="true" updatable="true" styleClass="editkodsearch"/>
			<july:lookupbutton action="/ShowDivisionLookupList.do" styleId="divl" fieldNames="divisioncode;divisionname" newWindowName="organizationlookup"  insertable="true" updatable="true"/>
			<july:string size="25" property="divisionname" styleId="divisionname" insertable="false" updatable="false" />
			<script language="javascript">switchDivision();</script>
		</td>
	</tr>
	<tr>
		<td class="title"><bean:message key="label.fault.date"/></td>
		<td class="title" colspan="2">
			<bean:message key="label.datefrom"/>&nbsp;<july:date property="datefromstr" size="25" insertable="true" updatable="true"/>&nbsp;&nbsp;&nbsp;<bean:message key="label.dateto"/>&nbsp;<july:date property="datetostr" size="25" insertable="true" updatable="true"/>
		</td>
	</tr>
	<tr>
		<td class="title"><bean:message key="label.fault.worker"/></td>
		<td class="title" colspan="2">
			<july:checkbox property="isworker" insertable="true" updatable="true" value="true" onclick="switchWorker();"/><html:hidden property="isworker" value="false"/><bean:message key="label.all"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<july:string property="workercode" styleId="workercode" size="5" insertable="true" updatable="true"  styleClass="editkodsearch" />
			<july:lookupbutton action="/ShowWorkerLookupList.do" styleId="workl" fieldNames="workercode;workername;workertitle" newWindowName="workerlookup" insertable="true" updatable="true" />
			<july:string size="20" property="workername" styleId="workername" insertable="false" updatable="false" />
			<july:string size="20" property="workertitle" styleId="workertitle" insertable="false" updatable="false" />
			<script language="javascript">switchWorker();</script>
		</td>
	</tr>
<%--
	<tr>
		<td class="title"><bean:message key="label.fault.position"/></td>
		<td class="title">
			<july:checkbox property="isposition" insertable="true" updatable="true" value="true" onclick="switchPosition();"/><html:hidden property="isposition" value="false"/><bean:message key="label.all"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<july:string property="positioncode" styleId="positioncode" size="5" insertable="true" updatable="true" styleClass="editkodsearch"/>
			<july:lookupbutton action="/ShowPositionLookupList.do" styleId="posl" fieldNames="positioncode;positionid;positionname" newWindowName="poslookup" insertable="true" updatable="true" />
			<july:string size="10" property="positionid" styleId="positionid" insertable="false" updatable="false" />
			<july:string size="25" property="positionname" styleId="positionname" insertable="false" updatable="false" />
			<script language="javascript">switchPosition();</script>
		</td>
	</tr>
--%>
	<tr>
		<td class="title"><bean:message key="label.fault.resource"/></td>
		<td class="title">
			<july:checkbox property="isresource" insertable="true" updatable="true" value="true" onclick="switchResource();"/><html:hidden property="isresource" value="false"/><bean:message key="label.all"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<july:string size="5" property="resourcecode" styleId="resourcecode" insertable="true" updatable="false" styleClass="editkodsearch"/>
			<july:lookupbutton action="/ShowResourceLookupList.do" styleId="resl" fieldNames="resourcecode;resourcemodel;resourcename" newWindowName="resourcelookup" insertable="true" updatable="false"/>
			<july:string size="20" property="resourcemodel" styleId="resourcemodel" insertable="false" updatable="false" />
			<july:string size="20" property="resourcename" styleId="resourcename" insertable="false" updatable="false" />
			<script language="javascript">switchResource();</script>
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
			<TD class="buttons"><july:addbutton page="/EditFault.do?action=Add" alttext="label.fault.add"/><july:backbutton page="/main.do"/></td>
			<TD class="navigator"><july:navigator/></td>
		</tr>
		</table>
	</td>
</tr>
        
<july:separator colspan="<%= gColSpan %>" />

<!-- Table header -->
<tr class="title">
	<july:headercolumn rowspan="2" key="label.void" colType="number"/>
	<july:sortcolumn rowspan="2" key="label.fault.date" colType="string" ascFinder="3" descFinder="4"/>
	<july:sortcolumn rowspan="2" key="label.num" colType="number" ascFinder="1" descFinder="2"/>
<%--
	<july:headercolumn rowspan="2" key="label.fault.date" colType="string"/>
	<july:headercolumn rowspan="2" key="label.num" colType="number"/>
--%>
	<july:headercolumn rowspan="2" key="label.fault.owner" colType="string"/>
	<july:headercolumn rowspan="2" key="label.fault.positioncomplect" colType="string"/>
	<july:headercolumn colspan="2" key="label.fault.malformresource" colType="string"/>
	<july:headercolumn rowspan="2" key="label.fault.worker" colType="string"/>
	<july:headercolumn rowspan="2" key="label.fault.state" colType="string"/>
	<july:headercolumn rowspan="2" key="label.void" colType="string"/>
	<july:headercolumn rowspan="2" key="label.void" colType="string"/>
</tr>
<tr class="title">
	<july:headercolumn key="label.fault.namemodel" colType="string"/>
	<july:headercolumn key="label.fault.spnum" colType="string"/>
</tr>

<july:separator colspan="<%= gColSpan %>" />

<!-- Table body -->
<%--
<logic:iterate id="it" name="browseList">
	<logic:present name="it">

		<tr selectableID='<bean:write name="it" property="so.document" filter="true"/>' classReal="normal" class="normal" id='selID<bean:write name="it" property="so.document" filter="true"/>' onMouseOver='className="select"' onMouseOut='className="normal"'>
			<td class="text">
				<logic:equal name="it" property="so.documentState" value="1">
       	            <july:editbutton page="/EditFault.do" action="Edit" paramId="document" paramName="it" paramProperty="so.document" paramScope="page" alttext="label.fault.edit"/>
				</logic:equal>
				<logic:equal name="it" property="so.documentState" value="2">
       	            <july:editbutton page="/EditFault.do" action="View" paramId="document" paramName="it" paramProperty="so.document" paramScope="page" alttext="label.fault.view"/>
				</logic:equal>
				<a name="selID<bean:write name="it" property="so.document" filter="true"/>"></a>
			</td>
			<td class="text">
				<july:datewrite name="it" property="so.blankdate"/>
			</td>
			<td class="text">
				<bean:write name="it" property="so.blanknumber" filter="true"/>
			</td>
			<td class="text">
				<logic:present name="it" property="so.owner">
				<bean:write name="it" property="so.owner.name" filter="true"/>
				</logic:present>
			</td>
			<td class="text">
				<bean:write name="it" property="positionname" filter="true"/>
			</td>
			<td class="text">
				<bean:write name="it" property="resourcename" filter="true"/>
			</td>
			<td class="text">
				<bean:write name="it" property="spnum" filter="true"/>
			</td>
			<td class="text">
				<bean:write name="it" property="workername" filter="true"/>
			</td>
			<td class="text">
					<logic:equal name="it" property="so.documentState" value="1"><bean:message key="label.state.entering"/></logic:equal>
					<logic:equal name="it" property="so.documentState" value="2"><bean:message key="label.state.calculated"/></logic:equal>
			</td>
			<td class="link">
				<logic:present name="it" property="dassdoc">
					<logic:present name="it" property="dassacttype">
					<logic:equal name="it" property="dassacttype" value="D">
					<july:docprintbutton docstatebean="it" docstateproperty="so.documentState" href="/crystalclear/dassactp.rpt?dll=pdsdmount.dll" paramId="prompt0" paramName="it" paramProperty="dassdoc" image="print_lose.gif" alt="Напечатать акт демонтажа" paramScope="page"/>
					</logic:equal>
					<logic:equal name="it" property="dassacttype" value="DB">
					<july:docprintbutton docstatebean="it" docstateproperty="so.documentState" href="/crystalclear/dassactbp.rpt?dll=pdsassact.dll" paramId="prompt0" paramName="it" paramProperty="dassdoc" image="print_lose.gif" alt="Напечатать акт демонтажа" paramScope="page"/>
					</logic:equal>
					</logic:present>
				</logic:present>
				<logic:present name="it" property="assdoc">
					<logic:present name="it" property="assacttype">
					<logic:equal name="it" property="assacttype" value="A">
					<july:docprintbutton docstatebean="it" docstateproperty="so.documentState" href="/crystalclear/assactp.rpt?dll=pdsmount.dll" paramId="prompt0" paramName="it" paramProperty="assdoc" image="print_plus.gif" alt="Напечатать акт монтажа" paramScope="page"/>
					</logic:equal>
					<logic:equal name="it" property="assacttype" value="AB">
					<july:docprintbutton docstatebean="it" docstateproperty="so.documentState" href="/crystalclear/assactbp.rpt?dll=pdsassact.dll" paramId="prompt0" paramName="it" paramProperty="assdoc" image="print_plus.gif" alt="Напечатать акт монтажа" paramScope="page"/>
					</logic:equal>
					</logic:present>
				</logic:present>
			</td>
			<td class="link">
				<logic:equal name="it" property="so.documentState" value="1">
					<july:delbutton page="/EditFault.do?action=Delete" paramId="document" paramName="it" paramProperty="so.document" paramScope="page"/>
				</logic:equal>
			</td>
		</tr>

		<july:separator colspan="<%= gColSpan %>" />

	</logic:present>
</logic:iterate>
--%>

<logic:iterate id="it" name="browseList" type="com.hps.july.cdbc.lib.CDBCRowObject">
	<logic:present name="it">
	<%
		String sql_so_documentState = it.getColumn("sql_so_documentState").asString();
		// pageContext.setAttribute("sql_so_documentState", sql_so_documentState);
		//
		String sql_so_owner = it.getColumn("sql_so_owner").asString();
		// pageContext.setAttribute("sql_so_owner", sql_so_owner);
		//
		String sql_dassdoc = it.getColumn("sql_dassdoc").asString();
		// pageContext.setAttribute("sql_dassdoc", sql_dassdoc);
		//
		String sql_dassacttype = it.getColumn("sql_dassacttype").asString();
		// pageContext.setAttribute("sql_dassacttype", sql_dassacttype);
		//
		String sql_assdoc = it.getColumn("sql_assdoc").asString();
		// pageContext.setAttribute("sql_assdoc", sql_assdoc);
		//
		String sql_assacttype = it.getColumn("sql_assacttype").asString();
		// pageContext.setAttribute("sql_assacttype", sql_assacttype);
	%>
	<!--
		sql_so_documentState = <%=sql_so_documentState%>
		sql_so_owner = <%=sql_so_owner%> 
		sql_dassdoc = <%=sql_dassdoc%> 
		sql_dassacttype = <%=sql_dassacttype%> 
		sql_assdoc = <%=sql_assdoc%> 
		sql_assacttype = <%=sql_assacttype%> 
	-->
		<tr selectableID='<july:stringwrite name="it" property="sql_so_document"/>' classReal="normal" class="normal" 
				id='selID<july:stringwrite name="it" property="sql_so_document"/>' 
				onMouseOver='className="select"' onMouseOut='className="normal"'>
			<td class="text">
				<% if ("1".equals(sql_so_documentState)) { %>
				<%-- <logic:equal name="it" property="sql_so_documentState" value="1"> --%>
       	            <july:editbutton page="/EditFault.do" action="Edit" paramId="document" paramName="it" 
       	            paramProperty="sql_so_document" paramScope="page" alttext="label.fault.edit"/>
				<%-- </logic:equal> --%>
				<% } %>
				<% if ("2".equals(sql_so_documentState)) { %>
				<%-- <logic:equal name="it" property="sql_so_documentState" value="2"> --%>
       	            <july:editbutton page="/EditFault.do" action="View" paramId="document" paramName="it" 
       	            paramProperty="sql_so_document" paramScope="page" alttext="label.fault.view"/>
				<%-- </logic:equal> --%>
				<% } %>
				<a name="selID<july:stringwrite name="it" property="sql_so_document"/>"></a>
			</td>
			<td class="text">
				<july:datewrite name="it" property="sql_so_blankdate"/>
			</td>
			<td class="text">
				<july:stringwrite name="it" property="sql_so_blanknumber"/>
			</td>
			<td class="text">
				<% if ((sql_so_owner != null) && (sql_so_owner.trim().length() > 0)) { %>
				<%-- <logic:present name="it" property="sql_so_owner"> --%>
					<july:stringwrite name="it" property="sql_so_owner_name"/>
				<%-- </logic:present> --%>
				<% } %>
			</td>
			<td class="text">
				<july:datewrite name="it" property="sql_positionname_from"/>
			</td>
			<td class="text">
				<july:stringwrite name="it" property="sql_resourcename_old"/>
			</td>
			<td class="text">
				<july:stringwrite name="it" property="sql_spnum"/>
			</td>
			<td class="text">
				<july:stringwrite name="it" property="sql_workername"/>
			</td>
			<td class="text">
					<% if ("1".equals(sql_so_documentState)) { %>
					<%-- <logic:equal name="it" property="sql_so_documentState" value="1"> --%>
						<bean:message key="label.state.entering"/>
					<%-- </logic:equal> --%>
					<% } %>
					<% if ("2".equals(sql_so_documentState)) { %>
					<%-- <logic:equal name="it" property="sql_so_documentState" value="2"> --%>
						<bean:message key="label.state.calculated"/>
					<%-- </logic:equal> --%>
					<% } %>
			</td>
			<td class="link">
				<% if ((sql_dassdoc != null) && (sql_dassdoc.trim().length() > 0)) { %>
				<%-- <logic:present name="it" property="sql_dassdoc"> --%>
					<% if ((sql_dassacttype != null) && (sql_dassacttype.trim().length() > 0)) { %>
					<%-- <logic:present name="it" property="sql_dassacttype"> --%>
					<% if ("N".equals(sql_dassacttype)) { %>
					<%-- <logic:equal name="it" property="sql_dassacttype" value="D"> --%>
						<july:docprintbutton docstatebean="it" docstateproperty="sql_so_documentState" 
							href="/crystalclear/dassactp.rpt?dll=pdsdmount.dll" paramId="prompt0" paramName="it" 
							paramProperty="sql_dassdoc" image="print_lose.gif" alt="Напечатать акт демонтажа" paramScope="page"/>
					<%-- </logic:equal> --%>
					<% } %>
					<% if (! "N".equals(sql_dassacttype)) { %>
					<%-- <logic:equal name="it" property="sql_dassacttype" value="DB"> --%>
						<july:docprintbutton docstatebean="it" docstateproperty="sql_so_documentState" 
							href="/crystalclear/dassactbp.rpt?dll=pdsassact.dll" paramId="prompt0" paramName="it" 
							paramProperty="sql_dassdoc" image="print_lose.gif" alt="Напечатать акт демонтажа" paramScope="page"/>
					<%-- </logic:equal> --%>
					<% } %>
					<%-- </logic:present> --%>
					<% } %>
				<%-- </logic:present> --%>
				<% } %>
				<% if ((sql_assdoc != null) && (sql_assdoc.trim().length() > 0)) { %>
				<%-- <logic:present name="it" property="sql_assdoc"> --%>
					<% if ((sql_assacttype != null) && (sql_assacttype.trim().length() > 0)) { %>
					<%-- <logic:present name="it" property="sql_assacttype"> --%>
					<% if ("T".equals(sql_assacttype)) { %>
					<%-- <logic:equal name="it" property="sql_assacttype" value="A"> --%>
						<july:docprintbutton docstatebean="it" docstateproperty="sql_so_documentState" 
							href="/crystalclear/assactp.rpt?dll=pdsmount.dll" paramId="prompt0" paramName="it" 
							paramProperty="sql_assdoc" image="print_plus.gif" alt="Напечатать акт монтажа" paramScope="page"/>
					<%-- </logic:equal> --%>
					<% } %>
					<% if (! "T".equals(sql_assacttype)) { %>
					<%-- <logic:equal name="it" property="sql_assacttype" value="AB"> --%>
						<july:docprintbutton docstatebean="it" docstateproperty="sql_so_documentState" 
							href="/crystalclear/assactbp.rpt?dll=pdsassact.dll" paramId="prompt0" paramName="it" 
							paramProperty="sql_assdoc" image="print_plus.gif" alt="Напечатать акт монтажа" paramScope="page"/>
					<%-- </logic:equal> --%>
					<% } %>
					<%-- </logic:present> --%>
					<% } %>	
				<%-- </logic:present> --%>
				<% } %>
			</td>
			<td class="link">
				<% if ("1".equals(sql_so_documentState)) { %>
				<%-- <logic:equal name="it" property="sql_so_documentState" value="1"> --%>
					<july:delbutton page="/EditFault.do?action=Delete" paramId="document" paramName="it" 
						paramProperty="sql_so_document" paramScope="page"/>
				<%-- </logic:equal> --%>
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
			<TD class="buttons"><july:addbutton page="/EditFault.do?action=Add" alttext="label.fault.add"/><july:backbutton page="/main.do"/></td>
			<TD class="navigator"><july:navigator/></td>
		</tr>
		</table>
	</td>
</tr>
      
<july:separator colspan="<%= gColSpan %>" />
  
</july:selectableTable>

</july:browseform>
