<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.arenda.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% String gColSpan = "12"; %>

<%
    String action = null;
	String form = null;
	String parent = null;
	String edit = null;
	String parentCaption = null;
	String parent2 = null;
	String temp = null;
	switch (ParamsParser.getState(pageContext)) {
		case APPStates.CHARGE_DNOP_LIST:
			action = "/ShowChargeDnopList.do";
			form = "ChargeDnopListForm";
			parent = "/ViewWeArenda.do";
			edit = "/EditChargeDnop.do";
			parent2 = "/ShowChargesList.do";
        	break;
		case APPStates.HISTORY_CHARGE_DNOP_LIST:
        	action = "/ShowHistoryChargeDnopList.do";
			form = "HistoryChargeDnopListForm";
			parent = "/ViewHistory.do";
			edit = "/EditHistoryChargeDnop.do";
			parent2 = "/ShowHistoryChargesList.do";
        	break;
		case APPStates.US_CHARGE_DNOP_LIST:
        	action = "/ShowUsChargeDnopList.do";
			form = "UsChargeDnopListForm";
			parent = "/ShowUsArendaList.do";
			edit = "/EditUsChargeDnop.do";
			parentCaption = "label.us";
			parent2 = "/ShowUsChargesList.do";
        	break;
		case APPStates.CHANNEL_CHARGE_DNOP_LIST:
        	action = "/ShowChannelChargeDnopList.do";
			form = "ChannelChargeDnopListForm";
			parent = "/ShowChannelArendaList.do";
			edit = "/EditChannelChargeDnop.do";
			parentCaption = "label.channel";
			parent2 = "/ShowChannelChargesList.do";
        	break;
		case APPStates.ABONENT_CHARGE_DNOP_LIST:
        	action = "/ShowAbonentChargeDnopList.do";
			form = "AbonentChargeDnopListForm";
			//parent = "/ShowChannelArendaList.do";
			edit = "/EditAbonentChargeDnop.do";
			//parentCaption = "label.channel";
			parent2 = "/ShowAbonentChargesList.do";
        	break;
    }
%>

<july:browseform action="<%= action %>" styleId="<%= form %>">

<html:hidden property="leaseDocPosition"/>

<table class="main">
<%--
<tr class="title">
		<td class="title" colspan="<%= gColSpan %>">
			<%	if (ParamsParser.getState(pageContext) == APPStates.CHARGE_DNOP_LIST ||
				ParamsParser.getState(pageContext) == APPStates.HISTORY_CHARGE_DNOP_LIST) { %>
				<html:link page="/ShowWeArendaList.do" styleClass="navigator"><bean:message key="label.we"/></html:link>
				<july:sepmark/>
				<%	if (ParamsParser.getState(pageContext) == APPStates.HISTORY_CHARGE_DNOP_LIST) { %>
					<html:link page="/ShowHistoryList.do" styleClass="navigator"><bean:message key="label.history"/></html:link>
					<july:sepmark/>
	        	<%	} %>
				<july:editlink page="<%= parent %>" action="View" styleClass="navigator">
					<bean:message key="label.view"/>
				</july:editlink>
			<%	} else if (ParamsParser.getState(pageContext) == APPStates.ABONENT_CHARGE_DNOP_LIST) { %>
				<html:link page="/ShowAbonentsList.do" styleClass="navigator"><bean:message key="label.abonents"/></html:link>
				<july:sepmark/>
				<july:editlink page="/ViewAbonent.do" action="View" styleClass="navigator"><bean:message key="label.view"/></july:editlink>
			<%	} else { %>
				<html:link page="<%= parent %>" styleClass="navigator"><bean:message key="<%= parentCaption %>"/></html:link>
			<%	} %>
			<july:sepmark/>
			<html:link page="<%= parent2 %>" styleClass="navigator"><bean:message key="label.charges"/></html:link>
			<july:sepmark/>
			<july:currmark><bean:message key="label.dnop"/></july:currmark>
		</td>
	</tr>
--%>

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
						<bean:message key="label.from"/> <july:datewrite name="<%= form %>" property="startDate"/> <bean:message key="label.till"/> <july:datewrite name="<%= form %>" property="endDate"/>
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
				<tr>
					<td class="text"><bean:message key="label.dnop.notremaindersum"/>:</td>
					<td class="text" nowrap><july:sumwrite name="<%= form %>" property="notremaindersum"/></td>
				</tr>
				<tr>
					<td class="text"><bean:message key="label.dnop.remaindersum"/>:</td>
					<td class="text" nowrap><july:sumwrite name="<%= form %>" property="remaindersum"/></td>
				</tr>
				<tr>
					<td class="text"><bean:message key="label.charges.period"/>:</td>
					<td class="text" nowrap><bean:message key="label.from"/> <july:datewrite name="<%= form %>" property="chargeBeginDate"/> <bean:message key="label.till"/> <july:datewrite name="<%= form %>" property="chargeEndDate"/>
				</tr>
				<tr>
					<td class="text"><bean:message key="label.dnop.remainderratetorur"/>:</td>
					<td class="text" nowrap><july:sumwrite name="<%= form %>" property="remainderratetorur"/></td>
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
						<%--<july:canedit rolesProperty="editRoles">
							<% temp = edit + "?action=Add"; %><july:addbutton page="<%= temp %>"/>
						</july:canedit>--%>
						<july:backbutton />		<%-- page="<%= parent2 %>"   --%>
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
		<july:headercolumn key="label.dnop.paycode" colType="string"/>
		<july:headercolumn key="label.dnop.type" colType="string"/>
		<july:headercolumn key="label.dnop.paydate" colType="string"/>
		<july:headercolumn key="label.dnop.paynumber" colType="string"/>
		<july:headercolumn key="label.dnop.chargesum" colType="string"/>
		<july:headercolumn key="label.dnop.chargesumrur" colType="string"/>
		<july:headercolumn key="label.dnop.paysumrur" colType="string"/>
		<july:headercolumn key="label.dnop.byhand" colType="string"/>
		<july:headercolumn key="label.dnop.rate" colType="string"/>
		<td class="title">&nbsp;</td>
		<td class="title">&nbsp;</td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>

	<!-- Table body -->
	<logic:iterate id="it" name="browseList">
		<logic:present name="it">
			<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
				<td class="link">
					<% temp = "View"; %>
<%--					<july:canedit rolesProperty="editRoles"><% temp = "Edit"; %></july:canedit>--%>
					<july:editbutton page="<%= edit %>" action="View" paramId="leasePaymentcode" paramName="it" paramProperty="o.leasePayment.leaseDocPosition" paramScope="page"/>
				</td>
				<td class="number">
					<bean:write name="it" property="o.leasePayment.leaseDocPosition" filter="true"/>
				</td>
				
				<%	String isAct = ""; %>
				<logic:equal name="it" property="o.leasePayment.docposvid" value="N"><% isAct = "false"; %></logic:equal>
				<logic:equal name="it" property="o.leasePayment.docposvid" value="C"><% isAct = "false"; %></logic:equal>
				<logic:equal name="it" property="o.leasePayment.docposvid" value="Q"><% isAct = "true"; %></logic:equal>
				<logic:equal name="it" property="o.leasePayment.docposvid" value="K"><% isAct = "true"; %></logic:equal>
				<logic:equal name="it" property="o.leasePayment.docposvid" value="Z"><% isAct = "true"; %></logic:equal>
				<td class='text'
				<%	if ("false".equals(isAct)) { %>
					title='<bean:message key="label.dnop.type.pp.full"/>'
				<%	} else if ("true".equals(isAct)) { %>
					title='<bean:message key="label.dnop.type.act.full"/>'
				<%	} %>>
					<%	if ("false".equals(isAct)) { %><bean:message key="label.dnop.type.pp"/>
					<%	} else if ("true".equals(isAct)) { %><bean:message key="label.dnop.type.act"/><% } %>
				</td>
				
				<td class="text">
					<july:datewrite name="it" property="o.leasePayment.date"/>
				</td>
				<td class="text">
					<bean:write name="it" property="o.leasePayment.docNumber"/>
				</td>
				<td class="number" align="right">
					<july:sumwrite name="it" property="o.chargesum"/>
				</td>
				<td class="number" align="right">
					<july:sumwrite name="it" property="o.chargerursum"/>
				</td>
				<td class="number" align="right">
					<july:sumwrite name="it" property="o.payrursum"/>
				</td>
				<td class="text" align="center">
					<logic:equal name="it" property="o.byhandchangeraterur" value="true">+</logic:equal>
				</td>
				<td class="number" align="right">
					<july:numberwrite name="it" property="rate"/>
				</td>
				<td class="link" style="vertical-align:middle;text-align:middle;">
					<logic:present name="it" property="payPurpose">
						<img src="/images/infohint.gif" border="0" width=16 height=16 title='<bean:message key="label.payrules.paypurpose"/>:&#13;<bean:write name="it" property="payPurpose" filter="true"/>'/>
					</logic:present>
				</td>
				<td class="link">
					<july:canedit rolesProperty="editRoles">
						<% temp = edit + "?action=Delete"; %>
						<july:delbutton page="<%= temp %>" paramId="leasePaymentcode" paramName="it" paramProperty="o.leasePayment.leaseDocPosition" paramScope="page"/>
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
						<%--<july:canedit rolesProperty="editRoles">
							<% temp = edit + "?action=Add"; %><july:addbutton page="<%= temp %>"/>
						</july:canedit>--%>
						<july:backbutton />		<%-- page="<%= parent2 %>"   --%>
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
			<%	if (ParamsParser.getState(pageContext) == APPStates.CHARGE_DNOP_LIST ||
				ParamsParser.getState(pageContext) == APPStates.HISTORY_CHARGE_DNOP_LIST) { %>
				<html:link page="/ShowWeArendaList.do" styleClass="navigator"><bean:message key="label.we"/></html:link>
				<july:sepmark/>
				<%	if (ParamsParser.getState(pageContext) == APPStates.HISTORY_CHARGE_DNOP_LIST) { %>
					<html:link page="/ShowHistoryList.do" styleClass="navigator"><bean:message key="label.history"/></html:link>
					<july:sepmark/>
	        	<%	} %>
				<july:editlink page="<%= parent %>" action="View" styleClass="navigator">
					<bean:message key="label.view"/>
				</july:editlink>
			<%	} else if (ParamsParser.getState(pageContext) == APPStates.ABONENT_CHARGE_DNOP_LIST) { %>
				<html:link page="/ShowAbonentsList.do" styleClass="navigator"><bean:message key="label.abonents"/></html:link>
				<july:sepmark/>
				<july:editlink page="/ViewAbonent.do" action="View" styleClass="navigator"><bean:message key="label.view"/></july:editlink>
			<%	} else { %>
				<html:link page="<%= parent %>" styleClass="navigator"><bean:message key="<%= parentCaption %>"/></html:link>
			<%	} %>
			<july:sepmark/>
			<html:link page="<%= parent2 %>" styleClass="navigator"><bean:message key="label.charges"/></html:link>
			<july:sepmark/>
			<july:currmark><bean:message key="label.dnop"/></july:currmark>
		</td>
	</tr>
--%>
</table>

</july:browseform>
