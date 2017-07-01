<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.arenda.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import ="com.hps.july.jdbcpersistence.lib.*"%>

<% String gColSpan = "15"; %>

<%
	String action = null;
	String form = null;
	String parent = null;
	String edit = null;
	String parentCaption = null;
	String rate = null;
	String dnop = null;
	String factura = null;
	String temp = null;

	switch (ParamsParser.getState(pageContext)) {
		case APPStates.CHARGES_LIST:
        	action = "/ShowChargesList.do";
			form = "ChargesListForm";
			parent = "/ViewWeArenda.do";
			edit = "/EditCharge.do";
			rate = "/ShowChargeRatesList.do";
			dnop = "/ShowChargeDnopList.do";
			factura = "/EditFactura.do?action=";
			gColSpan = "15";
        	break;
		case APPStates.HISTORY_CHARGES_LIST:
        	action = "/ShowHistoryChargesList.do";
			form = "HistoryChargesListForm";
			parent = "/ViewHistory.do";
			edit = "/EditHistoryCharge.do";
			rate = "/ShowHistoryChargeRatesList.do";
			dnop = "/ShowHistoryChargeDnopList.do";
			factura = "/EditHistoryFactura.do?action=";
			gColSpan = "15";
        	break;
		case APPStates.US_CHARGES_LIST:
        	action = "/ShowUsChargesList.do";
			form = "UsChargesListForm";
			parent = "/ShowUsArendaList.do";
			edit = "/EditUsCharge.do";
			parentCaption = "label.us";
			rate = "/ShowUsChargeRatesList.do";
			dnop = "/ShowUsChargeDnopList.do";
        	break;
		case APPStates.CHANNEL_CHARGES_LIST:
        	action = "/ShowChannelChargesList.do";
			form = "ChannelChargesListForm";
			parent = "/ShowChannelArendaList.do";
			edit = "/EditChannelCharge.do";
			parentCaption = "label.channel";
			rate = "/ShowChannelChargeRatesList.do";
			dnop = "/ShowChannelChargeDnopList.do";
        	break;
		case APPStates.ABONENT_CHARGES_LIST:
        	action = "/ShowAbonentChargesList.do";
			form = "AbonentChargesListForm";
			parent = "/ViewAbonent.do";
			edit = "/EditAbonentCharge.do";
			parentCaption = "label.view";
			rate = "/ShowAbonentChargeRatesList.do";
			dnop = "/ShowAbonentChargeDnopList.do";
        	break;
	}
    //start counter:
    //TimeCounter counter = new TimeCounter("PERF.ARENDA.ShowChargesList");
    //counter.start();
%>


<july:browseform action="<%= action %>" styleId="<%= form %>">


<script language="javascript">
function switchDate() {
	if (document.all.isDate[0].checked) {
		<%= form %>.fromDate_dt.enabled = false;
		<%= form %>.toDate_dt.enabled = false;
	} else {
		<%= form %>.fromDate_dt.enabled = true;
		<%= form %>.toDate_dt.enabled = true;
	}
}
function switchResource() {
	if (document.all.isResource[0].checked) {
		<%= form %>.resources.disabled = true;
		<%= form %>.resources.className = 'editdisabled';
	} else {
		<%= form %>.resources.disabled = false;
		<%= form %>.resources.className = 'editsearch';
	}
}
</script>

<html:hidden property="leaseContract"/>
<html:hidden property="sourceContract"/>

<table class="main">

	<july:separator colspan="<%= gColSpan %>"/>

	<TR class="normal">
		<TD colspan="<%= gColSpan %>">
			<table class="find">
				<tr>
					<td class="text"><bean:message key="label.mainPosition"/></td>
					<td class="text"><bean:write name="<%= form %>" property="mainPosition" filter="true"/></td>
				</tr>
				<tr>
					<td class="text"><bean:message key="label.filter.docnumber"/>:</td>
					<td class="text" nowrap>
						<bean:write name="<%= form %>" property="documentNumber" filter="true"/>&nbsp;
						<bean:message key="label.filter.ot"/>&nbsp;
						<july:datewrite name="<%= form %>" property="documentDate"/>
					</td>
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
				<tr>
					<td class="text"><bean:message key="label.filter.start"/>:</td>
					<td class="text">
						<table class="main" border="0" cellpading="0" cellspacing="0">
							<tr>
								<td class="text">
									<july:checkbox property="isDate" insertable="true" updatable="true" onclick="switchDate()"/>
									<bean:message key="label.filter.all"/>
								</td>
								<td class="text"><july:date property="fromDateFrm" size="25" insertable="true" updatable="true" styleId="fromDate"/></td>
								<td class="text"><bean:message key="label.filter.stop"/>:</td>
								<td class="text"><july:date property="toDateFrm" size="25" insertable="true" updatable="true" styleId="toDate"/><july:searchbutton/></td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td class="text"><bean:message key="label.charges.resource"/>:</td>
					<td class="text">
						<table class="main" border="0" cellpading="0" cellspacing="0">
							<tr>
								<td class="text">
									<july:checkbox property="isResource" insertable="true" updatable="true" onclick="switchResource()"/>
									<bean:message key="label.filter.all"/>
					    			<july:select style="width: 450;" styleId="resources" collection="resources" property="resource" insertable="true" updatable="true">
										<html:options collection="resources" property="resource" labelProperty="name"/>
								   	</july:select>
								</td>
							</tr>
						</table>	
					</td>
				</tr>
			</table>
		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr class="title">
		<td colspan="<%= gColSpan %>">
			<table class="buttons">
				<tr class="title">
					<td class="buttons">
						 <july:canedit rolesProperty="editRoles">  
							<%	if (ParamsParser.getState(pageContext) == APPStates.ABONENT_CHARGES_LIST) { %>
							  <%--	<logic:equal name="AbonentForm" property="flagworkpie" value="false">  --%> 
									<% temp = edit + "?action=Add"; %><july:addbutton page="<%= temp %>"/>
							  <%--  </logic:equal>  --%>
							<%	} else { %>
								<logic:notEqual name="<%= form %>" property="stateOfContract" value="A">
									<logic:notEqual name="<%= form %>" property="stateOfContract" value="C">
										<% temp = edit + "?action=Add"; %><july:addbutton page="<%= temp %>"/>
									</logic:notEqual>
								</logic:notEqual>
							<%	} %>
					   	 </july:canedit> 
						
							<july:backbutton/>
					</td>
					<td>
						<%--html:link page="/EditStartCharge.do?action=Add&condition=C" paramId="leaseDocumentcodeFrm" paramName="<%= form %>" paramProperty="leaseContract">
							<bean:message key="label.dhist.lnkmakecharge"/>
						</html:link--%>
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
		<july:headercolumn key="label.charges.resource" colType="string"/>
		<july:headercolumn key="label.charges.sum" colspan="2" colType="string"/>
		<july:headercolumn key="label.charges.currency" colType="string"/>
<%--		<july:headercolumn key="label.charges.remaindersum" colType="string"/> --%>
		<july:headercolumn key="label.charges.begindate" colType="string"/>
		<july:headercolumn key="label.charges.enddate" colType="string"/>
		<july:headercolumn key="label.charges.accountnumber" colType="string"/>
		<july:headercolumn key="label.charges.datecharge" colType="string"/>
		<td class="title">&nbsp;</td>
		<td class="title">&nbsp;</td>
		<%-- /*if (ParamsParser.getState(pageContext) == APPStates.CHARGES_LIST || ParamsParser.getState(pageContext) == APPStates.HISTORY_CHARGES_LIST) {*/ --%>
			<td class="title">&nbsp;</td>
		<%-- /*}*/ --%>
		<td class="title">&nbsp;</td>
		<td class="title">&nbsp;</td>
	</tr>


	<july:separator colspan="<%= gColSpan %>"/>

	<!-- Table body -->
	<logic:iterate id="it" name="browseList" type="com.hps.july.arenda.valueobject.LeaseChargeVO">
		<logic:present name="it">
			<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
				<td class="link">
					<%	temp = "View"; %>
					<july:canedit rolesProperty="editRoles">
						<% if (ParamsParser.getState(pageContext) != APPStates.ABONENT_CHARGES_LIST) { %>
							<logic:notEqual name="<%= form %>" property="stateOfContract" value="C"><% temp = "Edit"; %></logic:notEqual>
						<% } else { %>
							<logic:notPresent name="it" property="usedInAct">
								<logic:equal name="it" property="source" value="M">
									<% temp = "Edit"; %>
								</logic:equal>
							</logic:notPresent>
						<% } %>
					</july:canedit>
					<july:editbutton page="<%= edit %>" action="<%= temp %>" paramId="leaseDocPosition" paramName="it" paramProperty="leaseDocPosition" paramScope="page"/>
				</td>
				<td class="text">
					<bean:write name="it" property="resource.name" filter="true"/>
				</td>
				<td class="number">
					<logic:equal name="it" property="source" value="M">
						<IMG SRC="/images/infohint.gif" BORDER=0 ALT='<bean:message key="label.charges.byhand"/>'>
					</logic:equal>
				</td>				
				<td class="number" align="right" nowrap>
					<july:sumwrite name="it" property="summ"/>
				</td>				
				<td class="text">
				<logic:present name="it" property="currency">
					<bean:write name="it" property="currency.shortname" filter="true"/>
				</logic:present>
				</td>				
<%--
				<td class="number" align="right">
					<july:sumwrite name="it" property="remaindersum"/>
				</td>
--%>
				<td class="text">
					<july:datewrite name="it" property="begindate"/>
				</td>
				<td class="text">
					<july:datewrite name="it" property="enddate"/>
				</td>				
				<td class="text">
					<bean:write name="it" property="billnumber" filter="true"/>
				</td>
				<td class="text">
					<july:datewrite name="it" property="date"/>
				</td>
				<td class="link">
					<july:link page="<%= dnop %>" paramId="leaseDocPosition" paramName="it" paramProperty="leaseDocPosition" paramScope="page">
						<img src='/images/grafik.gif' border=0 alt='<bean:message key="label.charges.dnop"/>'>
					</july:link>
				</td>
				<td class="link">
<%--
					<july:link page="<%= rate %>" paramId="docpositioncode" paramName="it" paramProperty="leaseDocPosition" paramScope="page">
						<img src='/images/rateicon.gif' border=0 alt='<bean:message key="label.leasecalcrate.short"/>'>
					</july:link>
--%>
<!-- Вызов списка курса (диалога)-->
						<A href='EditRateList.do?action=Edit&docpositioncode=<bean:write name="it" property="leaseDocPosition"/>' onclick='window.open(this.href, "rateListDialog", "top=100, left=100, width=600, height=250, scrollbars=yes, resizable=yes").focus(); return false;'>
							<img src='/images/rateicon.gif' border=0 alt='<bean:message key="label.leasecalcrate.short"/>'>
						</A>
				</td>


					<td class="link">
				<% if (ParamsParser.getState(pageContext) == APPStates.CHARGES_LIST || ParamsParser.getState(pageContext) == APPStates.HISTORY_CHARGES_LIST) { %>
						<% temp = factura + "View"; %>
						<july:canedit rolesProperty="editRoles"><% temp = factura + "Add"; %></july:canedit>
						<july:link page="<%= temp %>" paramId="leaseDocPosition" paramName="it" paramProperty="leaseDocPosition" paramScope="page">
							<img src='/images/sf.gif' border=0 alt='<bean:message key="label.factura.create"/>'>
						</july:link>
				<% } %>
					</td>
				
				<td class="text">
					<logic:equal name="it" property="byhandraterur" value="true">
						<img src='/images/setrow.gif' border=0 alt='<bean:message key="label.charges.byhandraterur"/>'>
					</logic:equal>
				</td>
				<td class="link">
					<july:canedit rolesProperty="editRoles">
						<logic:notEqual name="<%= form %>" property="stateOfContract" value="C">
							<% temp = edit + "?action=Delete"; %>
							<july:delbutton page="<%= temp %>" paramId="leaseDocPosition" paramName="it" paramProperty="leaseDocPosition" paramScope="page"/>
						</logic:notEqual>
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
							<%	if (ParamsParser.getState(pageContext) == APPStates.ABONENT_CHARGES_LIST) { %>
								<%-- <logic:equal name="AbonentForm" property="flagworkpie" value="false">  --%>
									<% temp = edit + "?action=Add"; %><july:addbutton page="<%= temp %>"/>
								<%-- </logic:equal>  --%>
							<%	} else { %>
								<logic:notEqual name="<%= form %>" property="stateOfContract" value="A">
									<logic:notEqual name="<%= form %>" property="stateOfContract" value="C">
										<% temp = edit + "?action=Add"; %><july:addbutton page="<%= temp %>"/>
									</logic:notEqual>
								</logic:notEqual>
							<%	} %>
						</july:canedit>

							<july:backbutton/>
					</td>
					<TD>
							<%--html:link page="/EditStartCharge.do?action=Add&condition=C" paramId="leaseDocumentcodeFrm" paramName="<%= form %>" paramProperty="leaseContract">
								<bean:message key="label.dhist.lnkmakecharge"/>
							</html:link--%>
					</TD>
					<td class="navigator"><july:navigator/></td>
				</tr>
			</table>
		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>

</table>


<script language="javascript">
	switchDate();
	switchResource();
</script>


</july:browseform>
<%
    //counter end
	//counter.finish("jsp");
%>
