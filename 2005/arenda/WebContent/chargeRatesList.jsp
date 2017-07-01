<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.arenda.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% String gColSpan = "19"; %>

<%

    String action = null;
	String form = null;
	String parent = null;
	String edit = null;
	String parentCaption = null;
	String parent2 = null;
	String temp = null;

	switch (ParamsParser.getState(pageContext)) {
		case APPStates.CHARGE_RATES_LIST:
			action = "/ShowChargeRatesList.do";
			form = "ChargeRatesListForm";
			parent = "/ViewWeArenda.do";
			edit = "/EditChargeRate.do";
			parent2 = "/ShowChargesList.do";
        	break;
		case APPStates.HISTORY_CHARGE_RATES_LIST:
        	action = "/ShowHistoryChargeRatesList.do";
			form = "HistoryChargeRatesListForm";
			parent = "/ViewHistory.do";
			edit = "/EditHistoryChargeRate.do";
			parent2 = "/ShowHistoryChargesList.do";
        	break;
		case APPStates.US_CHARGE_RATES_LIST:
        	action = "/ShowUsChargeRatesList.do";
			form = "UsChargeRatesListForm";
			parent = "/ShowUsArendaList.do";
			edit = "/EditUsChargeRate.do";
			parentCaption = "label.us";
			parent2 = "/ShowUsChargesList.do";
        	break;
		case APPStates.CHANNEL_CHARGE_RATES_LIST:
        	action = "/ShowChannelChargeRatesList.do";
			form = "ChannelChargeRatesListForm";
			parent = "/ShowChannelArendaList.do";
			edit = "/EditChannelChargeRate.do";
			parentCaption = "label.channel";
			parent2 = "/ShowChannelChargesList.do";
        	break;
		case APPStates.ABONENT_CHARGE_RATES_LIST:
        	action = "/ShowAbonentChargeRatesList.do";
			form = "AbonentChargeRatesListForm";
			edit = "/EditAbonentChargeRate.do";
			parent2 = "/ShowAbonentChargesList.do";
        	break;
    }
%>


<july:browseform action="<%= action %>" styleId="<%= form %>">
<html:hidden property="docpositioncode"/>
<table class="main">
<%-- <tr class="title">
		<td class="title" colspan="<%= gColSpan %>">
			<%	if (ParamsParser.getState(pageContext) == APPStates.CHARGE_RATES_LIST ||
				ParamsParser.getState(pageContext) == APPStates.HISTORY_CHARGE_RATES_LIST) { %>
				<html:link page="/ShowWeArendaList.do" styleClass="navigator"><bean:message key="label.we"/></html:link>
				<july:sepmark/>
				<%	if (ParamsParser.getState(pageContext) == APPStates.HISTORY_CHARGE_RATES_LIST) { %>
					<html:link page="/ShowHistoryList.do" styleClass="navigator"><bean:message key="label.history"/></html:link>
					<july:sepmark/>
	        	<%	} %>
				<july:editlink page="<%= parent %>" action="View" styleClass="navigator">
					<bean:message key="label.view"/>
				</july:editlink>
			<%	} else if (ParamsParser.getState(pageContext) == APPStates.ABONENT_CHARGE_RATES_LIST) { %>
				<html:link page="/ShowAbonentsList.do" styleClass="navigator"><bean:message key="label.abonents"/></html:link>
				<july:sepmark/>
				<html:link page="/ViewAbonent.do?action=View" styleClass="navigator"><bean:message key="label.view"/></html:link>
			<%	} else { %>
				<html:link page="<%= parent %>" styleClass="navigator"><bean:message key="<%= parentCaption %>"/></html:link>
			<%	} %>
			<july:sepmark/>
			<html:link page="<%= parent2 %>" styleClass="navigator"><bean:message key="label.charges"/></html:link>
			<july:sepmark/>
			<july:currmark><bean:message key="label.leasecalcrate.charge"/></july:currmark>
		</td>
	</tr> --%>
	
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
					<td class="text"><bean:message key="label.leasecalcrate.chargedate"/>:</td>
					<td class="text" nowrap><july:datewrite name="<%= form %>" property="chargedate"/></td>
				</tr>
				<tr>
					<td class="text"><bean:message key="label.leasecalcrate.resource"/>:</td>
					<td class="text" nowrap><bean:write name="<%= form %>" property="resourcename"/></td>
				</tr>
				<tr>
					<td class="text"><bean:message key="label.leasecalcrate.sum"/>:</td>
					<td class="text" nowrap>
						<july:sumwrite name="<%= form %>" property="sum"/>&nbsp;
						<bean:write name="<%= form %>" property="chargecurrency" filter="true"/>
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
						<july:backbutton />
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
		<july:headercolumn key="label.leasecalcrate.rate" colType="string"/>
		<july:headercolumn key="label.leasecalcrate.sumrub" colType="string"/>
		<july:headercolumn key="label.leasecalcrate.currency" colType="string"/>
		<july:headercolumn key="label.leasecalcrate.check" colType="string"/>
		<july:headercolumn key="label.leasecalcrate.actnumber" colType="string"/>
		<td class="title">&nbsp;</td>
	</tr>


	<july:separator colspan="<%= gColSpan %>"/>


	<!-- Table body -->
	<logic:iterate id="it" name="browseList">
		<logic:present name="it">
			<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
				<td class="link">
					<% temp = "View"; %>
					<july:canedit rolesProperty="editRoles">
							<logic:notPresent name="it" property="o.act">
								<% temp = "Edit"; %>
							</logic:notPresent>
					</july:canedit>
					<july:editbutton page="<%= edit %>" action="<%= temp %>" paramId="currencycode" paramName="it" paramProperty="o.currency.currency" paramScope="page"/>
				</td>
				<td class="number" align="right">
					<july:numberwrite name="it" property="o.rate"/>
				</td>
				<td class="number" align="right">
					<july:sumwrite name="it" property="sum"/>
				</td>
				<td class="text">
					<bean:write name="it" property="o.currency.shortname" filter="true"/>
				</td>
				<td class="text" align="center">
					<logic:equal name="it" property="o.byhand" value="true">+</logic:equal>
				</td>
				<td class="text">
					<logic:present name="it" property="o.act">
						<bean:write name="it" property="o.act.documentNumber" filter="true"/>
					</logic:present>
					<logic:notPresent name="it" property="o.act">
						<logic:equal name="it" property="o.byhand" value="true">
							<bean:message key="label.leasecalcrate.cursbyhand"/>
						</logic:equal>
					</logic:notPresent>
				</td>
				<td class="link">
					<july:canedit rolesProperty="editRoles">
							<logic:notPresent name="it" property="o.act">
								<% temp = edit + "?action=Delete"; %>
								<july:delbutton page="<%= temp %>" paramId="currencycode" paramName="it" paramProperty="o.currency.currency" paramScope="page"/>
							</logic:notPresent>
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
						<july:backbutton />
					</td>
					<td class="navigator"><july:navigator/></td>
				</tr>
			</table>
		</td>
	</tr>
	<july:separator colspan="<%= gColSpan %>"/>

<%-- <tr class="title">
		<td class="title" colspan="<%= gColSpan %>">
			<%	if (ParamsParser.getState(pageContext) == APPStates.CHARGE_RATES_LIST ||
				ParamsParser.getState(pageContext) == APPStates.HISTORY_CHARGE_RATES_LIST) { %>
				<html:link page="/ShowWeArendaList.do" styleClass="navigator"><bean:message key="label.we"/></html:link>
				<july:sepmark/>
				<%	if (ParamsParser.getState(pageContext) == APPStates.HISTORY_CHARGE_RATES_LIST) { %>
					<html:link page="/ShowHistoryList.do" styleClass="navigator"><bean:message key="label.history"/></html:link>
					<july:sepmark/>
	        	<%	} %>
				<july:editlink page="<%= parent %>" action="View" styleClass="navigator">
					<bean:message key="label.view"/>
				</july:editlink>
			<%	} else if (ParamsParser.getState(pageContext) == APPStates.ABONENT_CHARGE_RATES_LIST) { %>
				<html:link page="/ShowAbonentsList.do" styleClass="navigator"><bean:message key="label.abonents"/></html:link>
				<july:sepmark/>
				<html:link page="/ViewAbonent.do?action=View" styleClass="navigator"><bean:message key="label.view"/></html:link>
			<%	} else { %>
				<html:link page="<%= parent %>" styleClass="navigator"><bean:message key="<%= parentCaption %>"/></html:link>
			<%	} %>
			<july:sepmark/>
			<html:link page="<%= parent2 %>" styleClass="navigator"><bean:message key="label.charges"/></html:link>
			<july:sepmark/>
			<july:currmark><bean:message key="label.leasecalcrate.charge"/></july:currmark>
		</td>
	</tr> --%>


</table>


</july:browseform>

