<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.arenda.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>


<% String gColSpan = "7"; %>


<%
    String action = null;
	String form = null;
	String parent = null;
	String edit = null;
	String parentCaption = null;
	String temp = null;
	switch (ParamsParser.getState(pageContext)) {
		case APPStates.SALDO_LIST:
        	action = "/ShowSaldoList.do";
			form = "SaldoListForm";
			parent = "/ViewWeArenda.do";
			edit = "/EditSaldo.do";
        	break;
		case APPStates.HISTORY_SALDO_LIST:
        	action = "/ShowHistorySaldoList.do";
			form = "HistorySaldoListForm";
			parent = "/ViewHistory.do";
			edit = "/EditHistorySaldo.do";
        	break;
		case APPStates.US_SALDO_LIST:
        	action = "/ShowUsSaldoList.do";
			form = "UsSaldoListForm";
			parent = "/ShowUsArendaList.do";
			edit = "/EditUsSaldo.do";
			parentCaption = "label.us";
        	break;
		case APPStates.CHANNEL_SALDO_LIST:
        	action = "/ShowChannelSaldoList.do";
			form = "ChannelSaldoListForm";
			parent = "/ShowChannelArendaList.do";
			edit = "/EditChannelSaldo.do";
			parentCaption = "label.channel";
        	break;
		case APPStates.ABONENT_SALDO_LIST:
        	action = "/ShowAbonentSaldoList.do";
			form = "AbonentSaldoListForm";
			parent = "/ViewAbonent.do";
			edit = "/EditAbonentSaldo.do";
        	break;
    }
%>


<july:browseform action="<%= action %>" styleId="<%= form %>">
<html:hidden property="leaseContract"/>
<html:hidden property="selectedID" value="0" />

<script language="javascript">
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

<table class="main" id="tableID">

	<july:separator colspan="<%= gColSpan %>"/>

	<TR class="normal">
		<TD colspan="<%= gColSpan %>">
			<table class="find">
				<tr>
					<td class="text"><bean:message key="label.filter.docnumber"/>:</td>
					<td class="text" nowrap><bean:write name="<%= form %>" property="documentNumber" filter="true"/></td>
				</tr>
				<tr>
					<td class="text"><bean:message key="label.filter.docperiod"/>:</td>
					<td class="text" nowrap>
						<july:datewrite name="<%= form %>" property="startDate"/>&nbsp;
						<bean:message key="label.filter.stop"/>&nbsp;
						<july:datewrite name="<%= form %>" property="endDate"/>
					</td>
				</tr>
				<tr>
					<td class="text"><bean:message key="label.filter.customer"/>:</td>
					<td class="text"><bean:write name="<%= form %>" property="orgCustomer" filter="true"/></td>
				</tr>
				<tr>
					<td class="text"><bean:message key="label.filter.executor"/>:</td>
					<td class="text"><bean:write name="<%= form %>" property="orgExecutor" filter="true"/></td>
				</tr>
				<tr>
					<td class="text"><bean:message key="label.filter.costcurrency"/>:</td>
					<td class="text" nowrap>
						<july:sumwrite name="<%= form %>" property="currency1"/>&nbsp;
						<bean:write name="<%= form %>" property="curr1" filter="true"/>
						<logic:present name="<%= form %>" property="currency2">
							;&nbsp;<july:sumwrite name="<%= form %>" property="currency2"/>
							&nbsp;<bean:write name="<%= form %>" property="curr2" filter="true"/>
						</logic:present>
					</td>
				</tr>
			</table>
		</TD>
	</TR>
	
	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr class="title">
		<td colspan="<%= gColSpan %>">
			<table class="buttons">
				<tr class="title">
					<td class="buttons">
						<july:canedit rolesProperty="editRoles">
							<% temp = edit + "?action=Add"; %>
							<%--july:addbutton page="<%= temp %>"/--%>
						</july:canedit>

							<july:backbutton/>
					</td>
					<td class="navigator"><july:navigator/></td>
				</tr>
			</table>
		</td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>
	<!-- Table header -->
	<tr class="title">
		<td class="title">&nbsp;</td>
		<july:headercolumn key="label.saldo.date" colType="string"/>
		<%-- <july:headercolumn key="label.saldo.resource.code" colType="string"/> --%>
		<july:headercolumn key="label.saldo.resource.name" colType="string"/>
		<july:headercolumn key="label.saldo.mainsum" colType="string"/>
		<july:headercolumn key="label.saldo.addsum" colType="string"/>
		<july:headercolumn key="label.saldo.saldobyhand" colType="string"/>
		<td class="title">&nbsp;</td>
	</tr>


	<july:separator colspan="<%= gColSpan %>"/>


	<!-- Table body -->
	<logic:iterate id="it" name="browseList">
		<logic:present name="it">
			<tr id='<bean:write name="it" property="params" filter="true"/>' class="normal" onMouseOver="className='select'" onMouseOut="onMouseOutRow(this.id);" onclick='onClickRow(this.id);'>
				<td class="link">
					<% temp = "View"; %>
					<%--july:canedit rolesProperty="editRoles"><% temp = "Edit"; %></july:canedit--%>
					<july:editbutton page="<%= edit %>" action="<%= temp %>" name="it" property="params" paramScope="page"/>
				</td>
				<td class="text">
					<july:datewrite name="it" property="o.salDate"/>
				</td>
				<%-- DD - Technical field 
				<td class="text">
					<bean:write name="it" property="o.resource.resource" filter="true"/>
				</td>
				--%>
				<td class="text">
					<bean:write name="it" property="o.resource.name" filter="true"/>
				</td>
				<td class="number" align="right">
					<bean:write name="it" property="o.mainsum" filter="true"/>
					<%--july:sumwrite name="it" property="o.mainsum"/--%>&nbsp;<bean:write name="it" property="o.maincurrency.shortname" filter="true"/>
				</td>
				<td class="number" align="right">
					<bean:write name="it" property="o.additionalsum" filter="true"/>
					<%--july:sumwrite name="it" property="o.additionalsum"/--%>
					<logic:present name="it" property="o.additionalcurrency">
						&nbsp;<bean:write name="it" property="o.additionalcurrency.shortname" filter="true"/>
					</logic:present>
				</td>
				<td class="text" align="center" title='<bean:write name="it" property="o.notes" filter="true"/>'>
					<logic:present name="it" property="o.saldobyhand">
						<logic:equal name="it" property="o.saldobyhand" value="true">
							<bean:message key="label.saldo.saldobyhand.true"/>
						</logic:equal>
					</logic:present>
				</td>
				<td class="link">
					<%--july:canedit rolesProperty="editRoles">
						<% temp = edit + "?action=Delete"; %>
						<july:delbutton page="<%= temp %>" name="it" property="params" paramScope="page"/>
					</july:canedit--%>
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
							<% temp = edit + "?action=Add"; %>
							<%--july:addbutton page="<%= temp %>"/--%>
						</july:canedit>

							<july:backbutton/>
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

