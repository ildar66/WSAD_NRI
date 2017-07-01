<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.arenda.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% String gColSpan = "13"; %>

<%
    String action = null;
	String form = null;
	String parent = null;
	String parent2 = null;
	String parent3 = null;
	String parent4 = null;
	String edit = null;
	String temp = null;
	switch (ParamsParser.getState(pageContext)) {
		case APPStates.FACTURA_POS_MUTACT_LIST:
        	action = "/ShowFacturaPosMutactList.do";
			form = "FacturaPosMutactList";
			parent2 = "/ShowMutualReglamentsList.do";
			parent3 = "/ShowMutualActsList.do";
			parent4 = "/ShowFacturaMutactList.do";
			edit = "/EditFacturaPosMutact.do";
        	break;
		case APPStates.FROMCONTRACT_FACTURA_POS_MUTACT_LIST:
        	action = "/ShowFromContractFacturaPosMutactList.do";
			form = "FromContractFacturaPosMutactList";
			parent = "/ViewWeArenda.do";
			parent2 = "/ShowFromContractMutualReglamentsList.do";
			parent3 = "/ShowFromContractMutualActsList.do";
			parent4 = "/ShowFromContractFacturaMutactList.do";
			edit = "/EditFromContractFacturaPosMutact.do";
        	break;
		case APPStates.FROMHISTORY_FACTURA_POS_MUTACT_LIST:
        	action = "/ShowFromHistoryFacturaPosMutactList.do";
			form = "FromHistoryFacturaPosMutactList";
			parent = "/ViewHistory.do";
			parent2 = "/ShowFromHistoryMutualReglamentsList.do";
			parent3 = "/ShowFromHistoryMutualActsList.do";
			parent4 = "/ShowFromHistoryFacturaMutactList.do";
			edit = "/EditFromHistoryFacturaPosMutact.do";
        	break;
	}
%>

<july:browseform action="<%= action %>" styleId="<%= form %>">

<html:hidden property="idSchetFact"/>

<table class="main">
<%--
<tr class="title">
		<td class="title" colspan="<%= gColSpan %>">
			<%	if (ParamsParser.getState(pageContext) == APPStates.FROMCONTRACT_FACTURA_POS_MUTACT_LIST ||
				ParamsParser.getState(pageContext) == APPStates.FROMHISTORY_FACTURA_POS_MUTACT_LIST) { %>
				<html:link page="/ShowWeArendaList.do" styleClass="navigator"><bean:message key="label.we"/></html:link>
				<july:sepmark/>
				<%	if (ParamsParser.getState(pageContext) == APPStates.FROMHISTORY_FACTURA_POS_MUTACT_LIST) { %>
					<html:link page="/ShowHistoryList.do" styleClass="navigator"><bean:message key="label.history"/></html:link>
					<july:sepmark/>
	        	<% } %>
				<july:editlink page="<%= parent %>" action="View" styleClass="navigator"><bean:message key="label.view"/></july:editlink>
				<july:sepmark/>
			<%	} %>
			<html:link page="<%= parent2 %>" styleClass="navigator"><bean:message key="label.mutualreglmnts"/></html:link>
			<july:sepmark/>
			<html:link page="<%= parent3 %>" styleClass="navigator"><bean:message key="label.mutualacts"/></html:link>
			<july:sepmark/>
			<html:link page="<%= parent4 %>" styleClass="navigator"><bean:message key="label.factures"/></html:link>
			<july:sepmark/>
			<july:currmark><bean:message key="label.factura.pos"/></july:currmark>
		</td>
	</tr>
--%>

	<july:separator colspan="<%= gColSpan %>"/>
	
	<TR class="normal">
		<TD colspan="<%= gColSpan %>">
			<table class="find">
				<tr>
					<td class="text"><bean:message key="label.factura.pos.sf.number"/>:</td>
					<td class="text" nowrap><bean:write name="<%= form %>" property="numberSchetFakt" filter="true"/></td>
				</tr>
				<tr>
					<td class="text"><bean:message key="label.factura.pos.sf.date"/>:</td>
					<td class="text" nowrap><july:datewrite name="<%= form %>" property="dateSchetFakt"/></td>
				</tr>
				<tr>
					<td class="text"><bean:message key="label.factura.pos.sf.executor"/>:</td>
					<td class="text" nowrap><bean:write name="<%= form %>" property="executor" filter="true"/></td>
				</tr>
				<tr>
					<td class="text"><bean:message key="label.factura.pos.sf.customer"/>:</td>
					<td class="text" nowrap><bean:write name="<%= form %>" property="customer" filter="true"/></td>
				</tr>
				<tr>
					<td class="text"><bean:message key="label.factura.pos.sf.sum"/>:</td>
					<td class="text" nowrap>
						<july:sumwrite name="<%= form %>" property="sum"/>&nbsp;<bean:write name="<%= form %>" property="currency" filter="true"/>
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
							<% temp = edit + "?action=Add"; %><july:addbutton page="<%= temp %>"/>
						</july:canedit>
						<july:backbutton page="<%= parent4 %>"/>
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
		<july:headercolumn key="label.factura.pos.resource" colType="string"/>
		<july:headercolumn key="label.factura.pos.edizm" colType="string"/>
		<july:headercolumn key="label.factura.pos.count" colType="string"/>
		<july:headercolumn key="label.factura.pos.edprice" colType="string"/>
		<july:headercolumn key="label.factura.pos.sumwonalog" colType="string"/>
		<july:headercolumn key="label.factura.pos.akciz" colType="string"/>
		<july:headercolumn key="label.factura.pos.ns" colType="string"/>
		<july:headercolumn key="label.factura.pos.sumnalog" colType="string"/>
		<july:headercolumn key="label.factura.pos.sumwnalog" colType="string"/>
		<july:headercolumn key="label.factura.pos.country" colType="string"/>
		<july:headercolumn key="label.factura.pos.ntd" colType="string"/>
		<td class="title">&nbsp;</td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>

	<!-- Table body -->
	<logic:iterate id="it" name="browseList">
		<logic:present name="it">
			<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
				<td class="link">
					<% temp = "View"; %>
					<july:canedit rolesProperty="editRoles"><% temp = "Edit"; %></july:canedit>
					<july:editbutton page="<%= edit %>" action="<%= temp %>" paramId="idPosSchetFakt" paramName="it" paramProperty="idPosSchetFakt" paramScope="page"/>
				</td>
				<td class="text">
					<bean:write name="it" property="resourceNri.name" filter="true"/>
				</td>
				<td class="text">
					<bean:write name="it" property="edizm" filter="true"/>
				</td>
				<td class="number" align="right">
					<july:sumwrite name="it" property="qty"/>
				</td>
				<td class="number" align="right">
					<july:sumwrite name="it" property="price"/>
				</td>
				<td class="number" align="right">
					<july:sumwrite name="it" property="sumFreeTax"/>
				</td>
				<td class="number" align="right">
					<july:sumwrite name="it" property="excise"/>
				</td>
				<td class="number" align="right">
					<july:numberwrite name="it" property="rateNds"/>
				</td>
				<td class="number" align="right">
					<july:sumwrite name="it" property="sumNds"/>
				</td>
				<td class="number" align="right">
					<july:sumwrite name="it" property="sumWithTax"/>
				</td>
				<td class="text">
					<bean:write name="it" property="country" filter="true"/>
				</td>
				<td class="text">
					<bean:write name="it" property="numGTD" filter="true"/>
				</td>
				<td class="link">
					<july:canedit rolesProperty="editRoles">
						<% temp = edit + "?action=Delete"; %>
						<july:delbutton page="<%= temp %>" paramId="idPosSchetFakt" paramName="it" paramProperty="idPosSchetFakt" paramScope="page"/>
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
							<% temp = edit + "?action=Add"; %><july:addbutton page="<%= temp %>"/>
						</july:canedit>
						<july:backbutton page="<%= parent4 %>"/>
					</td>
					<td class="navigator"><july:navigator/></td>
				</tr>
			</table>
		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>

<%--
<tr class="title">
		<td class="title" colspan="<%= gColSpan %>">
			<%	if (ParamsParser.getState(pageContext) == APPStates.FROMCONTRACT_FACTURA_POS_MUTACT_LIST ||
				ParamsParser.getState(pageContext) == APPStates.FROMHISTORY_FACTURA_POS_MUTACT_LIST) { %>
				<html:link page="/ShowWeArendaList.do" styleClass="navigator"><bean:message key="label.we"/></html:link>
				<july:sepmark/>
				<%	if (ParamsParser.getState(pageContext) == APPStates.FROMHISTORY_FACTURA_POS_MUTACT_LIST) { %>
					<html:link page="/ShowHistoryList.do" styleClass="navigator"><bean:message key="label.history"/></html:link>
					<july:sepmark/>
	        	<% } %>
				<july:editlink page="<%= parent %>" action="View" styleClass="navigator"><bean:message key="label.view"/></july:editlink>
				<july:sepmark/>
			<%	} %>
			<html:link page="<%= parent2 %>" styleClass="navigator"><bean:message key="label.mutualreglmnts"/></html:link>
			<july:sepmark/>
			<html:link page="<%= parent3 %>" styleClass="navigator"><bean:message key="label.mutualacts"/></html:link>
			<july:sepmark/>
			<html:link page="<%= parent4 %>" styleClass="navigator"><bean:message key="label.factures"/></html:link>
			<july:sepmark/>
			<july:currmark><bean:message key="label.factura.pos"/></july:currmark>
		</td>
	</tr>
--%>

</table>

</july:browseform>