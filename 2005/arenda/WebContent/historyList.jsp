<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% String gColSpan = "12"; %>

<july:browseform action="/ShowHistoryList.do" styleId="HistoryListForm">

<table class="main" style="font-size:8pt;">

	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr class="normal">
		<td colspan="<%= gColSpan %>">
			<table class="find">
				<tr>
					<td class="text"><bean:message key="label.filter.docnumber"/>:</td>
					<td class="text" nowrap><bean:write name="HistoryListForm" property="docNumber" filter="true"/></td>
				</tr>
				<tr>
					<td class="text"><bean:message key="label.filter.customer"/>:</td>
					<td class="text" nowrap><bean:write name="HistoryListForm" property="customer" filter="true"/></td>
				</tr>
				<tr>
					<td class="text"><bean:message key="label.filter.executor"/>:</td>
					<td class="text" nowrap><bean:write name="HistoryListForm" property="executor" filter="true"/></td>
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
							<logic:notEqual name="HistoryListForm" property="stateOfContract" value="C">
								<july:addbutton page="/EditHistory.do?action=Add"/>
							</logic:notEqual>
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
		<july:headercolumn key="label.history.dopdocnumber" colType="string"/>
		<july:headercolumn key="label.table.startdate" colType="string"/>
		<july:headercolumn key="label.table.finishdate" colType="string"/>
		<td colspan="2" align="center"><b><bean:message key="label.table.sumofcontract"/></b></td>
		<td class="title" align="center" title='Регистрация договора в государственных органах'><b>!</b></td>
		<july:headercolumn key="label.table.state" colType="string"/>
		<july:headercolumn key="label.table.checkprolong" colType="string"/>
		<td class="title" align="center" title='№ позиции'><b>№ позиции</b></tв>
		<td class="title" align="center" title='Номер описи'><b>!</b></tв>
		<td class="title">&nbsp;</td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>

	<!-- Table body -->
	<logic:iterate id="it" name="browseList">
		<logic:present name="it">
			<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
				<td class="link">
					<july:editbutton page="/ViewHistory.do" action="View" paramId="leaseDocument" paramName="it" paramProperty="o.leaseDocument" paramScope="page"/>
				</td>
				
				<td class="text">
					<logic:present name="it" property="o.mainLeaseDocument">
						<bean:write name="it" property="o.docnumber" filter="true"/>
					</logic:present>
					<logic:notPresent name="it" property="o.mainLeaseDocument">
						<bean:message key="label.maindocument"/>
					</logic:notPresent>
				</td>
				
 				<td class="date">
					<july:datewrite name="it" property="o.startDate"/>
                </td>
				
 				<td class="date">
                    <july:datewrite name="it" property="o.endDate"/>
                </td>
				
 				<td class="number" align="right">
					<july:sumwrite name="it" property="o.summ1"/>&nbsp;<bean:write name="it" property="o.currency1.shortname" filter="true"/>
                </td>
				
 				<td class="number" align="right">
					<july:sumwrite name="it" property="o.summ2"/>
					<logic:present name="it" property="o.summ2">
						&nbsp;<bean:write name="it" property="o.currency2.shortname" filter="true"/>
					</logic:present>
                </td>
<%--
				<td class="text" align="center" style="font-size:8pt;">
					<logic:present name="it" property="officialdoc">
						<logic:equal name="it" property="officialdoc" value="true">+</logic:equal>
						<logic:equal name="it" property="officialdoc" value="false">-</logic:equal>
					</logic:present>
					<bean:write name="it" property="needofficialdoc" filter="true"/>
				</td>
--%>
				<% String color = ""; String title = ""; String value = "";%>
				<logic:equal name="it" property="o.officialdoc" value="Y">
					<% title = "зарегистрирован в гос. органах"; value = "R"; color = "green"; %>
				</logic:equal>
				<logic:equal name="it" property="o.officialdoc" value="N">
					<logic:present name="it" property="o.needofficialdoc">
						<logic:equal name="it" property="o.needofficialdoc" value="Y">
							<% title = "необходимо зарегистрировать в гос. органах"; value = "R"; color = "red"; %>
						</logic:equal>
					</logic:present>
				</logic:equal>

				<td class="text" align="center" title='<%= title%>'>
					<B style="color: <%= color%>;"><%= value%></B>
				</td>

				<td class="link" align="center">
					<% String temp = "/EditHistoryWeState.do?action=View"; %>
					<july:canedit rolesProperty="editRoles"><% temp = "/EditHistoryWeState.do?action=Edit"; %></july:canedit>
					<july:link page="<%= temp %>" paramId="leaseDocument" paramName="it" paramProperty="o.leaseDocument" paramScope="page">
                		<logic:equal name="it" property="o.contractState" value="A"><bean:message key="label.state.prepared"/></logic:equal>
						<logic:equal name="it" property="o.contractState" value="B"><bean:message key="label.state.continued"/></logic:equal>
						<logic:equal name="it" property="o.contractState" value="C">
							<bean:message key="label.state.stoped"/><BR>
							<july:datewrite name="it" property="o.dateclose"/>
						</logic:equal>
						<logic:equal name="it" property="o.contractState" value="D">
							<bean:message key="label.state.unclosed"/>
							<july:datewrite name="it" property="o.dateclose"/>
						</logic:equal>
					</july:link>
                </td>
				
				<td class="text" align="center">
					<logic:equal name="it" property="o.extendType" value="A">+</logic:equal>
                </td>
				
				<%--td class="link" align="center">
					<logic:present name="it" property="o.docFileName">
						<% String emptyString = ""; %>
						<logic:notEqual name="it" property="o.docFileName" value="<%= emptyString %>">
							<html:link page="/DocumentDownload?param=documentText" paramId="leaseDocument" paramName="it" paramProperty="leaseDocument" target="_blank">
								<img src="/images/kontr.gif" border=0 alt="<bean:write name="it" property="o.docFileName" filter="true"/>">
							</html:link>
						</logic:notEqual>
					</logic:present>
				</td--%>
				
				<td class="text" align="center" colspan="1" title='<bean:write name="it" property="allPositions" filter="true"/>'>
					<logic:present name="it" property="mainPosition">
						<bean:write name="it" property="mainPosition" filter="true"/>
					</logic:present>
					<logic:present name="it" property="allPositions">
						<logic:match name="it" property="allPositions" value=";">
							&nbsp;...
						</logic:match>
					</logic:present>
					<logic:present name="it" property="allPositions">
						<logic:notMatch name="it" property="allPositions" value=";">
							<logic:notEqual name="it" property="allPositions" value="">
								<logic:equal name="it" property="mainPosition" value="">
									&nbsp;...
								</logic:equal>
							</logic:notEqual>
						</logic:notMatch>
					</logic:present>
				</td>
								
				<td class="text" align="center" title='Номер описи'>
					<bean:write name="it" property="numRegistryDoc" filter="true" />
					<%--logic:present name="it" property="dateRegistryDoc">
						<bean:write name="it" property="numRegistryDoc" filter="true" />
						от <july:datewrite name="it" property="dateRegistryDoc" />
					</logic:present--%>
				</td>
								
				<td class="link">
					<july:canedit rolesProperty="editRoles">
						<logic:equal name="it" property="o.contractState" value="A">
							<logic:present name="it" property="o.mainLeaseDocument">
								<logic:equal name="it" property="o.isactive" value="N">
									<july:delbutton page="/ViewHistory.do?action=Delete" paramId="leaseDocument" paramName="it" paramProperty="o.leaseDocument" paramScope="page"/>
								</logic:equal>
							</logic:present>
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
							<logic:notEqual name="HistoryListForm" property="stateOfContract" value="C">
								<july:addbutton page="/EditHistory.do?action=Add"/>
							</logic:notEqual>
						</july:canedit>
						<july:backbutton />
					</td>
					<td class="navigator"><july:navigator/></td>
				</tr>
			</table>
		</td>
	</tr>
		
	<july:separator colspan="<%= gColSpan %>"/>
	
</table>

</july:browseform>
