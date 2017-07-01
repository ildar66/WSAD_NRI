<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
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
	String edit = null;
	String state = null;
	String journal = null;
	String factura = null;
	String temp = null;
	switch (ParamsParser.getState(pageContext)) {
		case APPStates.MUTACTS_LIST:
			action = "/ShowMutualActsList.do";
			form = "MutualActsListForm";
			parent2 = "/ShowMutualReglamentsList.do";
			edit = "/EditMutualAct.do";
			state = "/EditActState.do?action=";
			journal = "/ShowStartActList.do";
			factura = "/ShowFacturaMutactList.do";
			break;
		case APPStates.FROMCONTRACT_MUTACTS_LIST:
			action = "/ShowFromContractMutualActsList.do";
			form = "FromContractMutualActsListForm";
			parent = "/ViewWeArenda.do";
			parent2 = "/ShowFromContractMutualReglamentsList.do";
			edit = "/EditFromContractMutualAct.do";
			state = "/EditFromContractActState.do?action=";
			journal = "/ShowFromContractStartActList.do";
			factura = "/ShowFromContractFacturaMutactList.do";
			break;
		case APPStates.FROMHISTORY_MUTACTS_LIST:
			action = "/ShowFromHistoryMutualActsList.do";
			form = "FromHistoryMutualActsListForm";
			parent = "/ViewHistory.do";
			parent2 = "/ShowFromHistoryMutualReglamentsList.do";
			edit = "/EditFromHistoryMutualAct.do";
			state = "/EditFromHistoryActState.do?action=";
			journal = "/ShowFromHistoryStartActList.do";
			factura = "/ShowFromHistoryFacturaMutactList.do";
			break;
	}
%>


<july:browseform action="<%= action %>" styleId="<%= form %>">
<html:hidden property="document" value="-1"/>

<script language="javascript">
function switchDate() {
	if (document.all.isDocdate[0].checked) {
		<%= form %>.fromDate_dt.enabled = false;
		<%= form %>.toDate_dt.enabled = false;
	} else {
		<%= form %>.fromDate_dt.enabled = true;
		<%= form %>.toDate_dt.enabled = true;
	}
}
</script>


<table class="main" style="font-size: 8pt">

	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr class="normal">
		<td colspan="<%= gColSpan %>">
			<table class="find" style="font-size: 8pt">
				<tr>
					<td class="text"><bean:message key="label.mutualreglmnts.docnumber"/>:</td>
					<td class="text"><bean:write name="<%= form %>" property="documentNumber" filter="true"/></td>
				</tr>
				<tr>
					<td class="text"><bean:message key="label.mutualreglmnts.docdate"/>:</td>
					<td class="text"><july:datewrite name="<%= form %>" property="documentDate"/></td>
				</tr>
				<tr>
					<td class="text"><bean:message key="label.mutualacts.acttype"/>:</td>
					<td class="text">
    	                <logic:equal name="<%= form %>" property="acttype" value="A"><bean:message key="label.mutualreglmnts.acttype.vz"/></logic:equal>
						<logic:equal name="<%= form %>" property="acttype" value="M"><bean:message key="label.mutualreglmnts.acttype.vt"/></logic:equal>
						<logic:equal name="<%= form %>" property="acttype" value="S"><bean:message key="label.mutualreglmnts.acttype.sv"/></logic:equal>
					</td>
				</tr>
				<tr>
					<td class="text"><bean:message key="label.mutualacts.period"/>:</td>
					<td class="text">
	                    <logic:equal name="<%= form %>" property="period" value="M"><bean:message key="label.mutualreglmnts.mutualperiod.month"/></logic:equal>
						<logic:equal name="<%= form %>" property="period" value="Q"><bean:message key="label.mutualreglmnts.mutualperiod.quarter"/></logic:equal>
					</td>
				</tr>
				<tr>
					<td class="text"><bean:message key="label.mutualreglmnts.maincurrency"/>:</td>
					<td class="text"><bean:write name="<%= form %>" property="mainCurrency" filter="true"/></td>
				</tr>
				
				<logic:present name="<%= form %>" property="additionalCurrency">
					<tr>
						<td class="text"><bean:message key="label.mutualreglmnts.additionalcurrency"/>:</td>
						<td class="text">
							<bean:write name="<%= form %>" property="additionalCurrency" filter="true"/>
						</td>
					</tr>
				</logic:present>
				
				<tr>
					<td class="text"><bean:message key="label.mutualreglmnts.commonrate"/>:</td>
					<td class="text"><july:checkbox property="commonRate" insertable="false" updatable="false"/></td>
				</tr>
				
				<logic:equal name="<%= form %>" property="commonRate" value="true">
					<tr>
						<td class="text"><bean:message key="label.mutualreglmnts.calcratetype.all"/>:</td>
						<td class="text">
							<logic:present name="<%= form %>" property="calcRateType">
								<logic:equal name="<%= form %>" property="calcRateType" value="B"><bean:message key="label.mutualreglmnts.calcratetype.begin"/></logic:equal>
								<logic:equal name="<%= form %>" property="calcRateType" value="E"><bean:message key="label.mutualreglmnts.calcratetype.end"/></logic:equal>
							</logic:present>
						</td>
					</tr>
				</logic:equal>
				
				<logic:equal name="<%= form %>" property="commonRate" value="false">
					<tr>
						<td class="text" colspan="2"><bean:message key="label.mutualreglmnts.calcratetype.one"/></td>
					</tr>
				</logic:equal>
				
				<tr>
					<td class="text"><bean:message key="label.filter.start"/>:</td>
					<td>
						<table class="main" border="0">
							<tr>
								<td class="text">
									<july:checkbox property="isDocdate" insertable="true" updatable="true" onclick="switchDate()"/>
									<bean:message key="label.filter.all"/>
								</td>
								<td class="text"><july:date property="fromDateFrm" size="25" insertable="true" updatable="true" styleId="fromDate"/></td>
								<td class="text"><bean:message key="label.filter.stop"/>:</td>
								<td class="text"><july:date property="toDateFrm" size="25" insertable="true" updatable="true" styleId="toDate"/></td>
								<td><july:searchbutton/></td>
							</tr>
						</table>
					</td>		
				</tr>
			</table>
		</td>
	</tr>
	
<script language="javascript">
	switchDate();
</script>


	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr class="title">
		<td colspan="<%= gColSpan %>">
			<table class="buttons">
				<tr class="title">
					<td class="buttons">
						<july:canedit rolesProperty="editRoles">
							<% temp = edit + "?action=Add"; %><july:addbutton page="<%= temp %>"/>
						</july:canedit>
						<july:backbutton/>
					</td>
					<td>
						<html:link page="/ActParamsPrint.do?action=View" paramId="reglament" 
							paramName="<%= form %>" paramProperty="mutualReglament" 
							onclick="window.open(this.href, 'pWindow', 'top=100, left=100, width=700, height=500, scrollbars=yes, resizable=yes, menubar=yes'); return false;">
							<bean:message key="label.mutualacts.actparamsprint"/>
						</html:link>
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
		<td class="title">&nbsp;</td>
		<%--july:headercolumn key="label.mutualacts.actnumber" colType="string"/--%>
		<td class="title">Номер</td>
		<july:headercolumn key="label.mutualacts.actdate" colType="string"/>
		<%--july:sortcolumn key="label.mutualacts.actstartdate" colType="string" ascFinder="3" descFinder="4"/--%>
		<td class="title">Дата начала <A href="#" onclick="setFinder('3'); return false;"><img src="/images/up.gif"  border="0" alt="Сортировать по возрастанию"></A><A href="#" onclick="setFinder('4'); return false;"><img src="/images/down.gif"  border="0" alt="Сортировать по убыванию"></A></td>
		<%--july:headercolumn key="label.mutualacts.actenddate" colType="number"/--%>
		<td class="title">Дата оконч.</td>
		<td class="title">&nbsp;</td>
		<td class="title">&nbsp;</td>
		<%--july:headercolumn key="label.mutualacts.actstate" colType="number"/--%>
		<td class="title">Состояние</td>
		<td class="title">&nbsp;</td>
<%--		<td class="title">&nbsp;</td>--%>
		<td class="title">&nbsp;</td>
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
					<july:canedit rolesProperty="editRoles">
						<%--<logic:equal name="it" property="actState" value="O">--%>
					<% temp = "Edit"; %>
						<%--</logic:equal>--%>
					</july:canedit>
					<july:editbutton page="<%= edit %>" action="<%= temp %>" paramId="leaseDocument" paramName="it" paramProperty="leaseDocument" paramScope="page"/>
				</td>
				
 				<td class="link" align="center" title="Приоритеты списания задолженности с договора">
					<%--html:link page="/PriorityContractForActList.do?" paramId="leaseDocument" paramName="it" paramProperty="leaseDocument" paramScope="page" onclick="window.open(this.href, 'PriorityContractForActList', 'top=100, left=350, width=600, height=250, scrollbars=yes, resizable=yes').focus(); return false;"><B>Pr</B></html:link--%>
					<a href="/arenda/PriorityContractForActList.do?leaseDocument=<bean:write name="it" property="leaseDocument"/>&numberAkt=<bean:write name="it" property="docnumber" filter="true"/>&actState=<bean:write name="it" property="actState"/>" onclick="window.open(this.href, 'PriorityContractForActList', 'top=100, left=350, width=600, height=250, scrollbars=yes, resizable=yes').focus(); return false;">
					<img src='/images/prior.gif' border=0 align="middle"></a>
                </td>

				<logic:equal name="it" property="flagOldSystem" value="1">				
					<td class="text" title="Акт из старой системы">
						<B style="color:red"><bean:write name="it" property="docnumber" filter="true"/></B>
					</td>
				</logic:equal>

				<logic:equal name="it" property="flagOldSystem" value="0">				
					<td class="text">
						<bean:write name="it" property="docnumber" filter="true"/>
					</td>
				</logic:equal>
				
 				<td class="date">
					<july:datewrite name="it" property="docdate"/>
                </td>
				
 				<td class="date">
					<july:datewrite name="it" property="actstartdate"/>
                </td>
				
 				<td class="date">
					<july:datewrite name="it" property="actenddate"/>
                </td>
				
				<td class='text' align='center'>
				<logic:notEqual name="<%= form %>" property="acttype" value="S">
					<july:canedit rolesProperty="editRoles">
<%--
						<july:link page="<%= action %>" paramId="document" paramName="it" paramProperty="leaseDocument" paramScope="page">
							<logic:equal name="it" property="isSchetFakt" value="true">
								<img src='/images/check_on.gif' border=0 alt='<bean:message key="label.mutualacts.isschetfact.yes"/>'>
							</logic:equal>
							<logic:equal name="it" property="isSchetFakt" value="false">
								<img src='/images/check_off.gif' border=0 alt='<bean:message key="label.mutualacts.isschetfact.no"/>'>
							</logic:equal>
						</july:link>
--%>
						<logic:equal name="it" property="isSchetFakt" value="true">
							<INPUT TYPE="image" NAME="isSchetFakt" 
								onclick='document.all.document.value="<bean:write name="it" property="leaseDocument" filter="true"/>"; document.body.style.cursor="wait"'
								SRC="/images/check_on.gif" BORDER=0 alt='<bean:message key="label.mutualacts.isschetfact.yes"/>'>
						</logic:equal>
						<logic:equal name="it" property="isSchetFakt" value="false">
							<INPUT TYPE="image" NAME="isSchetFakt" 
								onclick='document.all.document.value="<bean:write name="it" property="leaseDocument" filter="true"/>"; document.body.style.cursor="wait"'
								SRC="/images/check_off.gif" BORDER=0 alt='<bean:message key="label.mutualacts.isschetfact.no"/>'>
						</logic:equal>

					</july:canedit>

					<july:cannotedit rolesProperty="editRoles">
						<logic:equal name="it" property="isSchetFakt" value="true">
							<img src='/images/check_on.gif' border=0 alt='<bean:message key="label.mutualacts.isschetfact.yes"/>'>
						</logic:equal>
						<logic:equal name="it" property="isSchetFakt" value="false">
							<img src='/images/check_off.gif' border=0 alt='<bean:message key="label.mutualacts.isschetfact.no"/>'>
						</logic:equal>
					</july:cannotedit>
				</logic:notEqual>	
				</td>
				
 				<td class="link" align="center">
					<html:link page="/ShowActContentsList.do?action=Edit" paramId="actcode" paramName="it" paramProperty="leaseDocument" paramScope="page">
						<bean:message key="label.actcontents.label"/>
					</html:link>
                </td>

 				<td class="link" align="center">
					<% temp = state + "View"; %>
					<july:canedit rolesProperty="editRoles"><% temp = state + "Edit"; %></july:canedit>
					<july:link page="<%= temp %>" paramId="leaseDocument" paramName="it" paramProperty="leaseDocument" paramScope="page">
	                    <logic:equal name="it" property="actState" value="O"><bean:message key="label.mutualacts.actstate.open"/></logic:equal>
						<logic:equal name="it" property="actState" value="R"><bean:message key="label.mutualacts.actstate.calc"/></logic:equal>
						<logic:equal name="it" property="actState" value="C"><bean:message key="label.mutualacts.actstate.close"/></logic:equal>
					</july:link>
                </td>
				
 				<td class="link" align="center">
					<html:link page="<%= journal %>" paramId="document" paramName="it" paramProperty="leaseDocument" paramScope="page">
						<bean:message key="label.startact.short"/>
					</html:link>
                </td>
<%--				
				<td class="link" align="center">
					<logic:notEqual name="it" property="actState" value="O">
						<html:link page="/MutactEqualReport.do" paramId="leaseDocument" paramName="it" paramProperty="leaseDocument" paramScope="page" onclick="window.open(this.href, 'ab', 'top=100, left=100, width=700, height=500, scrollbars=yes, resizable=yes'); return false;">
							<img src="/images/print.gif" border=0 alt="<bean:message key="label.mutualacts.print"/>">
						</html:link>
					</logic:notEqual>
                </td>
--%>
				<td class="link" align="center">
					<% 
						String tempIdCodeAct = "" + ((com.hps.july.arenda.valueobject.LeaseMutualActVO)it).getLeaseDocument();
						Integer typeDoc = com.hps.july.terrabyte.core.DocumentTypes.LEASE_MUTUAL_ACTS; //тип документа 
						String objectType = com.hps.july.terrabyte.core.ObjectTypes.LEASE_MUTUAL_ACTS; //objectType 
					%>
					<logic:notEqual name="it" property="actState" value="O">
						<july:wordedit styleId='<%= "wrded1_" + tempIdCodeAct %>' url='<%= "MutactWordAction.do?actcode=" + tempIdCodeAct %>' 
							uploadurl='<%= "DocumentUploadAction.do?typeDoc=" + typeDoc + "&objectType=" + objectType %>' documentid="<%= tempIdCodeAct %>"
							addurl='<%= "http://" + request.getServerName() + "/arenda/header.jsp?actcode=" + tempIdCodeAct %>'>
							<IMG SRC="/images/docword.gif" border="0" alt='<bean:message key="label.mutaulacts.createword"/>'></july:wordedit>
					</logic:notEqual>

						<%--july:wordedit styleId='<%= "wrded2_" + tempIdCodeAct %>' url='<%= "MutualActDownload?actcode=" + tempIdCodeAct %>'
							uploadurl="MutualActWordUploadAction.do" documentid="<%= tempIdCodeAct %>"><IMG 
							SRC="/images/getdbword.gif" border="0" alt='<bean:message key="label.mutualacts.fromdb"/>'></july:wordedit--%>

						<%--
						<html:link page="/MutualActDownload" paramId="actcode" paramName="it" paramProperty="leaseDocument" paramScope="page">
							<img src="/images/getdbword.gif" border=0 alt='<bean:message key="label.mutualacts.fromdb"/>'>
						</html:link>
						--%>
						
					<july:wordedit styleId='<%= "wrded2_" + tempIdCodeAct %>' url='<%= "DocumentWordDownloadServlet?id=" + tempIdCodeAct + "&objectTypes=" + objectType %>'
							uploadurl='<%= "DocumentUploadAction.do?typeDoc=" + typeDoc + "&objectType=" + objectType %>' documentid="<%= tempIdCodeAct %>">
							<IMG SRC="/images/getdbword.gif" border="0" alt='<bean:message key="label.mutualacts.fromdb"/>'></july:wordedit>
                </td>
				
				<td class="link">
				<logic:notEqual name="<%= form %>" property="acttype" value="S">
					<july:link page="<%= factura %>" paramId="leaseDocument" paramName="it" paramProperty="leaseDocument" paramScope="page">
						<img src='/images/sf.gif' border=0 alt='<bean:message key="label.mutualreglmnts.factura"/>'>
					</july:link>
				</logic:notEqual>
				</td>
				
				<td class="link">
					<july:canedit rolesProperty="editRoles">
						<logic:equal name="it" property="actState" value="O">
							<% temp = edit + "?action=Delete"; %>
							<july:delbutton page="<%= temp %>" paramId="leaseDocument" paramName="it" paramProperty="leaseDocument" paramScope="page"/>
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
							<% temp = edit + "?action=Add"; %><july:addbutton page="<%= temp %>"/>
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


</july:browseform>