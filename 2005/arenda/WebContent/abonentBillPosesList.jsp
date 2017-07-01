<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% String gColSpan = "11"; %>
<% String emptyString = ""; %>

<july:browseform action="/ShowAbonentBillPosesList.do" styleId="AbonentBillPosesListForm">

<html:hidden property="leaseBill"/>

<% String tmp = "View"; %>
<july:canedit rolesProperty="editRoles">
	<logic:notEqual name="AbonentBillPosesListForm" property="contractState" value="A">
		<logic:equal name="AbonentBillPosesListForm" property="flagworknri" value="false"><% tmp = "Edit"; %></logic:equal>
	</logic:notEqual>
</july:canedit>

<table class="main">
<%--
<tr class="title">
		<td class="title" colspan="<%= gColSpan %>">
			<html:link page="/ShowAbonentsList.do" styleClass="navigator"><bean:message key="label.abonents"/></html:link>
			<july:sepmark/>
			<july:editlink page="/ViewAbonent.do" action="View" styleClass="navigator">
				<bean:message key="label.view"/>
			</july:editlink>
			<july:sepmark/>
			<html:link page="/ShowAbonentBillsList.do" styleClass="navigator"><bean:message key="label.abonents.paybill"/></html:link>
			<july:sepmark/>
			<july:currmark><bean:message key="label.bans.bill.poses"/></july:currmark>
		</td>
	</tr>
--%>

	<july:separator colspan="<%= gColSpan %>"/>

	<TR class="normal">
		<TD colspan="<%= gColSpan %>">
			<table class="find">
				<tr>
					<td class="text"><bean:message key="label.bans.ban"/>:</td>
					<td class="text" nowrap>
						<bean:write name="AbonentBillPosesListForm" property="ban" filter="true"/>
						(валюта: <bean:write name="AbonentBillPosesListForm" property="currencyVO.shortname" filter="true"/>)
					</td>
				</tr>
				<tr>
					<td class="text"><bean:message key="label.bans.org.name"/>:</td>
					<td class="text">
						<bean:write name="AbonentBillPosesListForm" property="customername" filter="true"/>
						<logic:present name="AbonentBillPosesListForm" property="customernameBill">
							<logic:notEqual name="AbonentBillPosesListForm" property="customernameBill" value="<%= emptyString %>">
								&nbsp;<bean:message key="label.bans.frombilling"/>
								&nbsp;<bean:write name="AbonentBillPosesListForm" property="customernameBill" filter="true"/>
							</logic:notEqual>
						</logic:present>
					</td>
				</tr>
				<tr>
					<td class="text"><bean:message key="label.bans.org.inn"/>:</td>
					<td class="text" nowrap>
						<bean:write name="AbonentBillPosesListForm" property="customerinn" filter="true"/>
						<logic:present name="AbonentBillPosesListForm" property="customerinnBill">
							<logic:notEqual name="AbonentBillPosesListForm" property="customerinnBill" value="<%= emptyString %>">
								&nbsp;<bean:message key="label.bans.frombilling"/>
								&nbsp;<bean:write name="AbonentBillPosesListForm" property="customerinnBill" filter="true"/>
							</logic:notEqual>
						</logic:present>
					</td>
				</tr>
				<tr>
					<td class="text"><bean:message key="label.bans.bill.number"/>:</td>
					<td class="text"><bean:write name="AbonentBillPosesListForm" property="billNumber" filter="true"/></td>
				</tr>
				<tr>
					<td class="text"><bean:message key="label.bans.bill.date"/>:</td>
					<td class="text" nowrap><july:datewrite name="AbonentBillPosesListForm" property="billDate"/></td>
				</tr>
				<tr>
					<td class="text"><bean:message key="label.bans.bill.sum"/>:</td>
					<td class="text" nowrap><july:sumwrite name="AbonentBillPosesListForm" property="sum"/></td>
				</tr>
				<tr>
					<td class="text"><bean:message key="label.bans.bill.sumnds"/>:</td>
					<td class="text" nowrap><july:sumwrite name="AbonentBillPosesListForm" property="sumnds"/></td>
				</tr>
				<tr>
					<td class="text"><bean:message key="label.bans.bill.sumnsp"/>:</td>
					<td class="text" nowrap><july:sumwrite name="AbonentBillPosesListForm" property="sumnsp"/></td>
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
		<july:headercolumn key="label.bans.bill.poses.resource" colType="string"/>
		<july:headercolumn key="label.bans.bill.poses.qty" colType="string"/>
		<july:headercolumn key="label.bans.bill.poses.sum" colType="string"/>
		<july:headercolumn key="label.bans.bill.poses.sumpure" colType="string"/>
		<july:headercolumn key="label.bans.bill.poses.ndsrate" colType="string"/>
		<july:headercolumn key="label.bans.bill.poses.nds" colType="string"/>
		<july:headercolumn key="label.bans.bill.poses.nsprate" colType="string"/>
		<july:headercolumn key="label.bans.bill.poses.nsp" colType="string"/>
		<july:headercolumn key="label.bans.bill.poses.currency" colType="string"/>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>

	<!-- Table body -->
	<logic:iterate id="it" name="browseList">
		<logic:present name="it">
			<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
				<td class="text">
					<july:editbutton page="/EditAbonentBillPos.do" action="<%= tmp %>" paramId="billpos" paramName="it" paramProperty="billpos" paramScope="page"/>
				</td>
				<td class="text">
					<bean:write name="it" property="itemname" filter="true"/>
				</td>
				<td class="number" align="right">
					<bean:write name="it" property="qty" filter="true"/>
				</td>
				<td class="number" align="right">
					<july:sumwrite name="it" property="summnri"/>
				</td>
				<td class="number" align="right">
					<july:sumwrite name="it" property="summpurenri"/>
				</td>
				<td class="number" align="right">
					<july:numberwrite name="it" property="ndsrate"/>
				</td>
				<td class="number" align="right">
					<july:sumwrite name="it" property="ndssummnri"/>
				</td>
				<td class="number" align="right">
					<july:numberwrite name="it" property="nsprate"/>
				</td>
				<td class="number" align="right">
					<july:sumwrite name="it" property="nspsummnri"/>
				</td>
				<td class="text">
					<bean:write name="it" property="pos2currency.shortname" filter="true"/>
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
						<july:backbutton />
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
			<html:link page="/ShowAbonentsList.do" styleClass="navigator"><bean:message key="label.abonents"/></html:link>
			<july:sepmark/>
			<july:editlink page="/ViewAbonent.do" action="View" styleClass="navigator">
				<bean:message key="label.view"/>
			</july:editlink>
			<july:sepmark/>
			<html:link page="/ShowAbonentBillsList.do" styleClass="navigator"><bean:message key="label.abonents.paybill"/></html:link>
			<july:sepmark/>
			<july:currmark><bean:message key="label.bans.bill.poses"/></july:currmark>
		</td>
	</tr>
--%>

</table>

</july:browseform>
