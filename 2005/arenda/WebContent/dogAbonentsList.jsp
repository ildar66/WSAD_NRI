<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% String gColSpan = "8"; %>
<july:browseform action="/ShowDogAbonentsList.do" styleId="DogAbonentsListForm">

<table class="main">

<july:separator colspan="<%= gColSpan %>"/>
	<tr class="normal">
		<td colspan="<%= gColSpan %>">
			<table class="find">
				<tr>
					<td class="text" nowrap>&nbsp;</td>
					<td class="text" nowrap>&nbsp;</td>
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
		<td class="title">&nbsp;</td>
		<july:sortcolumn key="label.bans.ban" colType="string" ascFinder="1" descFinder="2"/>
		<%--
		<july:headercolumn key="label.bans.bens" colType="string"/>
		--%>
		<july:headercolumn key="label.bans.balans" colType="string"/>
		<july:headercolumn key="label.bans.org.name" colType="string"/>
		<july:headercolumn key="label.bans.org.inn" colType="string"/>
		<td class="title">&nbsp;</td>
		<td class="title">&nbsp;</td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>

	<!-- Table body -->
	<logic:iterate id="it" name="browseList">
		<logic:present name="it">
			<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
				<td class="link">
					<july:editbutton page="/ViewAbonent.do" action="View" paramId="leaseDocument" paramName="it" paramProperty="o.leaseDocument" paramScope="page"/>
				</td>
				<logic:equal name="it" property="o.flagworkpie" value="true">
					<td class='text' title='<bean:message key="label.bans.flagworkpie"/>'>+</td>
				</logic:equal>
				<logic:equal name="it" property="o.flagworkpie" value="false">
					<td class='text' title='<bean:message key="label.bans.flagworkpie.no"/>'>-</td>
				</logic:equal>
				<td class="text">
					<bean:write name="it" property="o.ban" filter="true"/>
				</td>
				<%--
				<td class="text">
					<logic:equal name="it" property="o.useallben" value="false"><bean:write name="it" property="bens" filter="true"/></logic:equal>
					<logic:equal name="it" property="o.useallben" value="true"><bean:message key="label.bans.allben"/></logic:equal>
				</td>
				--%>
				<td class="text" nowrap>
					<bean:write name="it" property="balans" filter="true"/>
				</td>
 				<td class="text">
					<bean:write name="it" property="o.orgCustomer.name" filter="true"/>
		        </td>
 				<td class="text">
					<bean:write name="it" property="o.orgCustomer.inn" filter="true"/>
		        </td>
				<td class="link">
					<% String temp = "/EditAbonentState.do?action=View"; %>
					<july:canedit rolesProperty="editRoles"><% temp = "/EditAbonentState.do?action=Edit"; %></july:canedit>
					<july:link page="<%= temp %>" paramId="leaseDocument" paramName="it" paramProperty="o.leaseDocument" scope="page">
						<logic:equal name="it" property="o.contractState" value="A">
							<bean:message key="label.bans.contractstate.a"/>
						</logic:equal>
						<logic:equal name="it" property="o.contractState" value="B">
							<bean:message key="label.bans.contractstate.b"/>
						</logic:equal>
						<logic:equal name="it" property="o.contractState" value="C">
							<bean:message key="label.bans.contractstate.c"/>
						</logic:equal>
						<logic:equal name="it" property="o.contractState" value="D">
							<bean:message key="label.bans.contractstate.d"/>
						</logic:equal>
					</july:link>
				</td>
				<td class="link">
				<logic:equal name="it" property="o.contractState" value="A">
					<july:canedit rolesProperty="editRoles">
						<july:delbutton page="/EditAbonent.do?action=Delete" paramId="leaseDocument" paramName="it" paramProperty="o.leaseDocument" paramScope="page"/>
					</july:canedit>
				</logic:equal>
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

