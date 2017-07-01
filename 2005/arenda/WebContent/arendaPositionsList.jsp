<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.arenda.*,com.hps.july.arenda.formbean.*" %>
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
	String delete = null;
	String temp = null;
	String className = "select";
	String src = "";
	ArendaPositionsListForm aForm = null;
	switch (ParamsParser.getState(pageContext)) {
		case APPStates.ARENDA_POS_LIST:
        	action = "/ShowArendaPositionsList.do";
			form = "ArendaPositionsListForm";
			parent = "/ViewWeArenda.do";
			edit = "/ShowPositionMultiList.do";
			delete = "/ProcessArendaPosition.do?action=Delete";
        	break;
		case APPStates.HISTORY_ARENDA_POS_LIST:
        	action = "/ShowHistoryArendaPositionsList.do";
			form = "HistoryArendaPositionsListForm";
			parent = "/ViewHistory.do";
			edit = "/ShowHistoryPositionMultiList.do";
			delete = "/ProcessHistoryArendaPosition.do?action=Delete";
        	break;
    }
	aForm = (ArendaPositionsListForm)session.getAttribute(form);
	String mainPositionStr = "-1";
	if(aForm.getMainPosition() != null)
		mainPositionStr = aForm.getMainPosition().toString();
%>
<july:browseform action="<%= action %>" styleId="<%= form %>">
<html:hidden property="leaseDocument"/>
<input type="hidden" name="incpos" value="">
<html:hidden property="mainPosition"/>

<table class="main">

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
					<td class="text" nowrap><bean:write name="<%= form %>" property="orgCustomer" filter="true"/></td>
				</tr>
				<tr>
					<td class="text"><bean:message key="label.filter.executor"/>:</td>
					<td class="text" nowrap><bean:write name="<%= form %>" property="orgExecutor" filter="true"/></td>
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
				<tr>
					<td class="text"><bean:message key="label.filter.economist"/>:</td>
					<td class="text" nowrap><bean:write name="<%= form %>" property="mainEconomist" filter="true"/></td>
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
						<% temp = parent + "?action=View"; %>
						<july:backbutton page="<%= temp %>"/>
					</td>
					<td class="navigator"><july:navigator/></td>
				</tr>
			</table>
		</td>
	</tr>
<july:canedit rolesProperty="editRoles">
<%--<logic:equal name="<%= form %>" property="stateOfContract" value="A">--%>
	<july:separator colspan="<%= gColSpan %>"/>

	<tr class="normal">
	<td class="text" colspan="<%= gColSpan %>">
		<table border="0" width="100%" cellpadding="3" cellspacing="0">
		<tr>
		<td width="80%">
			<html:hidden property="position"/>
			<july:string size="50" property="positionname" styleId="positionname" insertable="false" updatable="false"/>
			<july:lookupbutton action="/../basestation/ShowPositionLookupList.do?planstate=2" styleId="posl" fieldNames="position;;positionname" insertable="true" updatable="true" onselect = "document.all.incpos.value='add'; document.forms(0).submit();"/>
<%--
			<input type="image" src="/images/vkl.gif" title="¬ключить" onclick="document.all.incpos.value='add';">
			<input type="image" name="clearposition" src="/images/clear.gif" alt="ќчистить" onclick="position.value=''; positionname.value=''; return false;">
--%>
		</td>
<%--
<a href="/arenda/ShowPositionMultiList.do?leaseDocumentcode=4317" title="¬ключить" onclick="document.body.style.cursor='wait';">
<IMG SRC="/images/vkl.gif" BORDER='0' ALT='¬ключить'></a>
			<july:includebutton page="<%= edit %>" paramId="leaseDocumentcode" paramName="<%= form %>" paramProperty="leaseDocument"/>
--%>
		</tr>
		</table>
	</td>
	</tr>
</july:canedit>
<%--</logic:equal>--%>
	<july:separator colspan="<%= gColSpan %>"/>
	<!-- Table header -->
	<tr class="title">
		<td class="title">&nbsp;</td>
		<july:headercolumn key="label.table.posname" colType="string"/>
		<july:headercolumn key="label.table.numberdamps" colType="number"/>
		<july:headercolumn key="label.table.numbergsm" colType="number"/>
		<july:headercolumn key="label.table.address" colType="string"/>
		<july:headercolumn key="label.table.mainmanager" colType="string"/>
<july:canedit rolesProperty="editRoles">
<%--<logic:equal name="<%= form %>" property="stateOfContract" value="A">--%>
		<td class="title">&nbsp;</td>
<%--</logic:equal>--%>
</july:canedit>
	</tr>
	<july:separator colspan="<%= gColSpan %>"/>
	<!-- Table body -->
	<logic:iterate id="it" name="browseList">
		<logic:present name="it">
	<logic:equal name="it" property="o.position.storageplace" value='<%=mainPositionStr%>'>
		<%className = "selected"; src = "/images/check_on.gif";%>
	</logic:equal>
	<logic:notEqual name="it" property="o.position.storageplace" value='<%=mainPositionStr%>'>
		<%className = "normal"; src="/images/check_off.gif";%>
	</logic:notEqual>
	<tr class="<%=className%>" onMouseOver="className='select'" onMouseOut="className='<%=className%>'">
				<td class="text">
					<INPUT TYPE="image" NAME="setMainPosition" 
						onclick='document.all.mainPosition.value=<bean:write name="it" property="o.position.storageplace" filter="true"/>; document.body.style.cursor="wait"'
							SRC="<%=src%>" BORDER=0 alt='<bean:message key="label.positionMain"/>'>
				</td>
				<td class="text">
         	        <bean:write name="it" property="o.position.name" filter="true"/>
                </td>
                <td class="text">
					<bean:write name="it" property="o.position.dampsid" filter="true"/>
                </td>
                <td class="text">
					<bean:write name="it" property="o.position.gsmid" filter="true"/><logic:present name="it" property="o.position.dcsid">/<bean:write name="it" property="o.position.dcsid" filter="true"/></logic:present>
                </td>
                <td class="text">
                    <bean:write name="it" property="o.position.address" filter="true"/>
                </td>
                <td class="text">
                    <bean:write name="it" property="mainManager" filter="true"/>
                </td>
<july:canedit rolesProperty="editRoles">
<%--<logic:equal name="<%= form %>" property="stateOfContract" value="A">--%>
		<td class="link">
			<july:excludebutton page="<%= delete %>" paramId="positioncode" paramName="it" paramProperty="o.position.storageplace" paramScope="page"/>
		</td>
<%--</logic:equal>--%>
</july:canedit>
		<july:separator colspan="<%= gColSpan %>"/>
	</tr>
		</logic:present>
	</logic:iterate>
<tr class="title">
	<td colspan="<%= gColSpan %>">
		<table class="buttons">
		<tr class="title">
			<td class="buttons">
				<% temp = parent + "?action=View"; %>
				<july:backbutton page="<%= temp %>"/>
			</td>
			<td class="navigator"><july:navigator/></td>
		</tr>
		</table>
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>"/>

</table>

</july:browseform>
