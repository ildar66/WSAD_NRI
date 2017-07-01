<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.arenda.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>


<% String gColSpan = "11"; %>


<%
    String action = null;
	String form = null;
	String parent = null;
	String edit = null;
	String state = null;
	String mutActs = null;
	String temp = null;
	switch (ParamsParser.getState(pageContext)) {
		case APPStates.MUTUAL_REGLMNTS_LIST:
        	action = "/ShowMutualReglamentsList.do";
			form = "MutualReglamentsListForm";
			edit = "/ViewMainParamsMutReglmnt.do";
			state = "/EditReglamentState.do?action=";
			mutActs = "/ShowMutualActsList.do";
        	break;
		case APPStates.FROMCONTRACT_MUTUAL_REGLMNTS_LIST:
        	action = "/ShowFromContractMutualReglamentsList.do";
			form = "FromContractMutualReglamentsListForm";
			parent = "/ViewWeArenda.do";
			edit = "/ViewFromContractMainParamsMutReglmnt.do";
			state = "/EditFromContractReglamentState.do?action=";
			mutActs = "/ShowFromContractMutualActsList.do";
        	break;
		case APPStates.FROMHISTORY_MUTUAL_REGLMNTS_LIST:
        	action = "/ShowFromHistoryMutualReglamentsList.do";
			form = "FromHistoryMutualReglamentsListForm";
			parent = "/ViewHistory.do";
			edit = "/ViewFromHistoryMainParamsMutReglmnt.do";
			state = "/EditFromHistoryReglamentState.do?action=";
			mutActs = "/ShowFromHistoryMutualActsList.do";
        	break;
    }
%>


<july:browseform action="<%= action %>" styleId="<%= form %>">

<html:hidden property="selectedID" value="0" />

<script language='javascript'>
function switchLeaseContract() {
	if (document.all.isLeaseContract[0].checked) {
		<%= form %>.leaseContractcode.className = 'editkoddisabled';
		<%= form %>.leaseContractcode.disabled = true;
		document.all['lookupimg_conl'].src='/images/lookup_disabled.gif';
	} else {
		<%= form %>.leaseContractcode.className = 'editkodsearch';
		<%= form %>.leaseContractcode.disabled = false;
		document.all['lookupimg_conl'].src='/images/lookup.gif';
	}
}
function switchDocnumber() {
	if (document.all.isBlank[0].checked) {
		<%= form %>.blank.className = 'editdisabled';
		<%= form %>.blank.disabled = true;
	} else {
		<%= form %>.blank.className = 'editsearch';
		<%= form %>.blank.disabled = false;
	}
}
function switchDocdate() {
	if (document.all.isDocdate[0].checked) {
		<%= form %>.docdate_dt.enabled = false;
	} else {
		<%= form %>.docdate_dt.enabled = true;
	}
}
function switchActType() {
	if (document.all.isActType[0].checked) {
		//<%= form %>.vz.disabled = true;
		//<%= form %>.vt.disabled = true;
		//<%= form %>.sv.disabled = true;
		<%= form %>.actType.disabled = true;
	} else {
		//<%= form %>.vz.disabled = false;
		//<%= form %>.vt.disabled = false;
		//<%= form %>.sv.disabled = false;
		<%= form %>.actType.disabled = false;
	}
}

function onMouseOutRow(selectedID){
	if(document.all.selectedID.value==selectedID) {
		document.all.tableID.rows(selectedID,0).className="selected";
	}
	else {
		document.all.tableID.rows(selectedID,0).className="normal";
	}
}

function onClickRow(selectedID) {
	if(document.all.tableID.rows(document.all.selectedID.value) != null){
		document.all.tableID.rows(document.all.selectedID.value,0).className="normal";
	}
	document.all.selectedID.value=selectedID;
	document.all.tableID.rows(selectedID,0).className="selected";
	storeSelectedRow(selectedID);
}

function storeSelectedRow(selectedID) {
	document.cookie = <%= form %>.name+"=" + selectedID;
}

function loadSelectedRow() {
	var cookies = document.cookie;
	//считываем selectedID:
	var startLoc = cookies.indexOf(<%= form %>.name+"=");
	if(startLoc == -1)
	   return;
	var sepLoc = cookies.indexOf("=", startLoc);
	var endLoc = cookies.indexOf(";", startLoc);
	if(endLoc == -1) {
		endLoc = cookies.length;
    }
    document.all.selectedID.value = cookies.substring(sepLoc+1, endLoc);
	//подчеркиваем строку в таблице:
	if( document.all.tableID.rows(document.all.selectedID.value) != null ) {
 		document.all.tableID.rows(document.all.selectedID.value,0).className="selected";
	}
}
</script>


<table class="main" id="tableID" style="font-size:8pt;">

	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr class="normal">
		<td colspan="<%= gColSpan %>">
			<table class="find" style="font-size: 8pt">
				<tr>
					<td class="text" nowrap ><bean:message key="label.mutualreglmnts.number"/></td>
					<td class="text" nowrap>
						<july:checkbox property="isLeaseContract" insertable="true" updatable="true" onclick="switchLeaseContract()"/>
						<bean:message key="label.filter.all"/>
						<july:string size="5" property="leaseContract" styleId="leaseContractcode" insertable="true" updatable="true"/>
						<july:lookupbutton action="/ShowContractLookupList.do?isOnlyWe=false" styleId="conl" fieldNames="leaseContractcode;leaseContractname" insertable="true" updatable="true" onclick="if (document.all.isLeaseContract[0].checked) { return false; }"/>
						<july:string size="25" property="leaseContractname" styleId="leaseContractname" insertable="false" updatable="false"/>
						<july:searchbutton/>
					</td>
				</tr>
				
				<logic:equal name="<%= form %>" property="isLeaseContract" value="false">
				
					<tr>
						<td class="text"><bean:message key="label.filter.docperiod"/></td>
						<td class="text">
							<july:datewrite name="<%= form %>" property="startDate"/>&nbsp;
							<bean:message key="label.filter.stop"/>&nbsp;
							<july:datewrite name="<%= form %>" property="endDate"/>
						</td>
					</tr>
					<tr>
						<td class="text"><bean:message key="label.filter.customer"/></td>
						<td class="text"><bean:write name="<%= form %>" property="orgCustomer" filter="true"/></td>
					</tr>
					<tr>
						<td class="text"><bean:message key="label.filter.executor"/></td>
						<td class="text"><bean:write name="<%= form %>" property="orgExecutor" filter="true"/></td>
					</tr>
					<tr>
						<td class="text"><bean:message key="label.filter.costcurrency"/></td>
						<td class="text">
							<july:sumwrite name="<%= form %>" property="currency1"/>&nbsp;
							<bean:write name="<%= form %>" property="curr1" filter="true"/>
							<logic:present name="<%= form %>" property="currency2">
								;&nbsp;<july:sumwrite name="<%= form %>" property="currency2"/>
								&nbsp;<bean:write name="<%= form %>" property="curr2" filter="true"/>
							</logic:present>
						</td>
					</tr>
					
				</logic:equal>
				
				<tr>
					<td class="text"><bean:message key="label.mutualreglmnts.docnumber"/></td>
					<td class="text">
						<july:checkbox property="isBlank" insertable="true" updatable="true" onclick="switchDocnumber()"/>
						<bean:message key="label.filter.all"/>
						<july:string size="50" property="blank" styleId="docnumber" insertable="true" updatable="true"/>
					</td>
				</tr>
				<tr>
					<td class="text"><bean:message key="label.mutualreglmnts.docdate"/></td>				
					<td class="text">
						<july:checkbox property="isDocdate" insertable="true" updatable="true" onclick="switchDocdate()"/>
						<bean:message key="label.filter.all"/>&nbsp;
						<july:date property="docdateFrm" size="25" insertable="true" updatable="true" styleId="docdate"/>
					</td>
				</tr>
				<tr>
					<td class="text"><bean:message key="label.mutualreglmnts.acttype"/></td>
					<td class="text">
						<july:checkbox property="isActType" insertable="true" updatable="true" onclick="switchActType()"/>
						<bean:message key="label.filter.all"/>
					    <html:select style="width: 250;" property="actType">
							<html:option value="A"><bean:message key="label.mutualreglmnts.acttype.vz"/></html:option>
							<html:option value="M"><bean:message key="label.mutualreglmnts.acttype.vt"/></html:option>
							<html:option value="S"><bean:message key="label.mutualreglmnts.acttype.sv"/></html:option>
					   	</html:select>						
						<%--july:radio property="actType" styleId="vz" insertable="true" updatable="true" value="A"/><bean:message key="label.mutualreglmnts.acttype.vz"/>
						<july:radio property="actType" styleId="vt" insertable="true" updatable="true" value="M"/><bean:message key="label.mutualreglmnts.acttype.vt"/>
						<july:radio property="actType" styleId="sv" insertable="true" updatable="true" value="S"/><bean:message key="label.mutualreglmnts.acttype.sv"/--%>
					</td>
				</tr>
				<tr>
					<td class="text"><bean:message key="label.mutualreglmnts.state"/></td>
					<td class="text">
						<july:checkbox property="isMutStateEdit" insertable="true" updatable="true"/><bean:message key="label.mutualreglmnts.state.enter"/>&nbsp;
						<july:checkbox property="isMutStateRun" insertable="true" updatable="true"/><bean:message key="label.mutualreglmnts.state.run"/>&nbsp;
						<july:checkbox property="isMutStateClose" insertable="true" updatable="true"/><bean:message key="label.mutualreglmnts.state.close"/>&nbsp;
					</td>
				</tr>
			</table>
		</td>
	</tr>


<script language='javascript'>
	switchLeaseContract();
	switchDocnumber();
	switchDocdate();
	switchActType();
</script>
	
	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr class="title">
		<td colspan="<%= gColSpan %>">
			<table class="buttons">
				<tr class="title">
					<td class="buttons">
						<july:canedit rolesProperty="editRoles">
							<% temp = edit + "?action=Add&isShowMessage=0"; %><july:addbutton page="<%= temp %>"/>
						</july:canedit>
						<july:backbutton/>
					</td>
					<td align="right">
						отобрано регламентов:<%= request.getAttribute("numberOfLines") %>
					</td>
					<td class="navigator"><july:navigator/></td>
				</tr>
			</table>
		</td>
	</tr>
		
	<july:separator colspan="<%= gColSpan %>"/>


	<!-- Table header -->
	<tr class="title" >
		<td class="title">&nbsp;</td>
		<td class="title">&nbsp;</td>
<%--		<july:headercolumn key="label.mutualreglmnts.docnumber" colType="string"/> --%>
		<july:headercolumn key="label.dhist.ppnumber" colType="string"/>
		<july:headercolumn key="label.mutualreglmnts.docdate" colType="string"/>
		<td class="title">Период действия</td>
		<july:headercolumn key="label.mutualreglmnts.contractlist" colType="string"/>
		<%--july:headercolumn key="label.mutualreglmnts.resourcelist" colType="string"/--%>
		<%--july:headercolumn key="label.table.mutualperiod" colType="string"/>
		<july:headercolumn key="label.table.acttype" colType="number"/--%>
		<td class="title" nowrap>Период формирования<BR><I>Тип акта</I></td>
		<july:headercolumn key="label.mutualreglmnts.state" colType="number"/>
<%--
		<july:headercolumn key="label.table.commonrate" colType="number"/>
		<july:headercolumn key="label.table.calcratetype" colType="number"/>
		<july:headercolumn key="label.mutualreglmnts.startdate" colType="number"/>
		<july:headercolumn key="label.mutualreglmnts.enddate" colType="number"/>
--%>
		<td class="title">&nbsp;</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>
	
	<!-- Table body -->
	<logic:iterate id="it" name="browseList">
		<logic:present name="it">
			<tr id='<bean:write name="it" property="o.leaseDocument" filter="true"/>' class="normal" onMouseOver="className='select'" onMouseOut="onMouseOutRow(this.id);" onclick='onClickRow(this.id);'>
				<td class="link">
					<july:editbutton page="<%= edit %>" action="View&isShowMessage=0" paramId="leaseDocument" paramName="it" paramProperty="o.leaseDocument" paramScope="page"/>
				</td>
				<td class="link">
					<july:link page="<%= mutActs %>" paramId="mutualReglament" paramName="it" paramProperty="o.leaseDocument" paramScope="page">
						<img src="/images/doc.gif" border=0 alt="<bean:message key="label.mutualacts"/>">						
					</july:link>
				</td>
				<td class="text">
					<bean:write name="it" property="o.docnumber" filter="true"/>
				</td>
 				<td class="date">
					<july:datewrite name="it" property="o.docdate"/>
                </td>
 				<td class="date">
					<july:datewrite name="it" property="o.startdate"/>-<BR>
					<july:datewrite name="it" property="o.enddate"/>
                </td>
 				<td class="text">
					<bean:write name="it" property="contractList" filter="true"/>
                </td>
 				<%--td class="text">
					<bean:write name="it" property="resourceList" filter="true"/>
                </td--%>
 				<td class="text">
                    <logic:equal name="it" property="o.mutualPeriod" value="M"><bean:message key="label.mutualreglmnts.mutualperiod.month"/></logic:equal>
					<logic:equal name="it" property="o.mutualPeriod" value="Q"><bean:message key="label.mutualreglmnts.mutualperiod.quarter"/></logic:equal>
					<logic:equal name="it" property="o.mutualPeriod" value="Y"><bean:message key="label.mutualreglmnts.mutualperiod.year"/></logic:equal>
					<BR>
                    <logic:equal name="it" property="o.actType" value="A"><I><bean:message key="label.mutualreglmnts.acttype.vz"/></I></logic:equal>
					<logic:equal name="it" property="o.actType" value="M"><I><bean:message key="label.mutualreglmnts.acttype.vt"/></I></logic:equal>
					<logic:equal name="it" property="o.actType" value="S"><I><bean:message key="label.mutualreglmnts.acttype.sv"/></I></logic:equal>
                </td>
				<td class="link">
					<% temp = state + "View"; %>
					<july:canedit rolesProperty="editRoles"><% temp = state + "Edit"; %></july:canedit>
					<july:link page="<%= temp %>" paramId="leaseDocument" paramName="it" paramProperty="o.leaseDocument" paramScope="page">
	                    <logic:equal name="it" property="o.mutState" value="A"><bean:message key="label.mutualreglmnts.state.enter"/></logic:equal>
						<logic:equal name="it" property="o.mutState" value="B"><bean:message key="label.mutualreglmnts.state.run"/></logic:equal>
						<logic:equal name="it" property="o.mutState" value="C"><bean:message key="label.mutualreglmnts.state.close"/></logic:equal>
					</july:link>
				</td>
<%--
 				<td class="text" align="center">
					<logic:equal name="it" property="o.commonRate" value="true">+</logic:equal>
                </td>
				<td class="text">
					<logic:present name="it" property="o.calcRateType">
	                    <logic:equal name="it" property="o.calcRateType" value="B"><bean:message key="label.mutualreglmnts.calcratetype.begin"/></logic:equal>
						<logic:equal name="it" property="o.calcRateType" value="E"><bean:message key="label.mutualreglmnts.calcratetype.end"/></logic:equal>
					</logic:present>
                </td>
 				<td class="date">
					<july:datewrite name="it" property="o.startdate"/>
                </td>
 				<td class="date">
					<july:datewrite name="it" property="o.enddate"/>
                </td>
--%>
				<td class="link">
					<july:canedit rolesProperty="editRoles">
						<logic:equal name="it" property="o.mutState" value="A">
							<% temp = edit + "?action=Delete&isShowMessage=0"; %>
							<july:delbutton page="<%= temp %>" paramId="leaseDocument" paramName="it" paramProperty="o.leaseDocument" paramScope="page"/>
						</logic:equal>
					</july:canedit>
				</td>
			</tr>
			<july:separator colspan="<%= gColSpan %>"/>
		</logic:present>
	</logic:iterate>
	
	<tr class="title">
		<td colspan="<%= gColSpan %>">
			<table class="buttons">
				<tr class="title">
					<td class="buttons">
						<july:canedit rolesProperty="editRoles">
							<% temp = edit + "?action=Add&isShowMessage=0"; %><july:addbutton page="<%= temp %>"/>
						</july:canedit>
						<july:backbutton/>
					</td>
					<td align="right">
						отобрано регламентов:<%= request.getAttribute("numberOfLines") %>
					</td>
					<td class="navigator"><july:navigator/></td>
				</tr>
			</table>
		</td>
	</tr>
		
	<july:separator colspan="<%= gColSpan %>"/>
	
</table>

<script language="javascript">
	loadSelectedRow();
</script>
</july:browseform>