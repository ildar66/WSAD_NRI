<%@ page language = "java" %>

<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>

<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>



<% String gColSpan = "7"; %>

<% String emptyString = ""; %>

<% String message = null; %>



<july:browseform action="/ShowAbonentBilledList.do" styleId="AbonentBilledListForm">



<html:hidden property="leaseBill"/>



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

			<july:currmark><bean:message key="label.bans.billed"/></july:currmark>

		</td>

	</tr>
--%>

	

	<july:separator colspan="<%= gColSpan %>"/>

	

	<TR class="normal">

		<TD colspan="<%= gColSpan %>">

			<table class="find">

				<tr>

					<td class="text"><bean:message key="label.bans.ban"/>:</td>

					<td class="text" nowrap><bean:write name="AbonentBilledListForm" property="ban" filter="true"/></td>

				</tr>

				<tr>

					<td class="text"><bean:message key="label.bans.org.name"/>:</td>

					<td class="text">

						<bean:write name="AbonentBilledListForm" property="customername" filter="true"/>

						<logic:present name="AbonentBilledListForm" property="customernameBill">

							<logic:notEqual name="AbonentBilledListForm" property="customernameBill" value="<%= emptyString %>">

								&nbsp;<bean:message key="label.bans.frombilling"/>

								&nbsp;<bean:write name="AbonentBilledListForm" property="customernameBill" filter="true"/>

							</logic:notEqual>

						</logic:present>

					</td>

				</tr>

				<tr>

					<td class="text"><bean:message key="label.bans.org.inn"/>:</td>

					<td class="text" nowrap>

						<bean:write name="AbonentBilledListForm" property="customerinn" filter="true"/>

						<logic:present name="AbonentBilledListForm" property="customerinnBill">

							<logic:notEqual name="AbonentBilledListForm" property="customerinnBill" value="<%= emptyString %>">

								&nbsp;<bean:message key="label.bans.frombilling"/>

								&nbsp;<bean:write name="AbonentBilledListForm" property="customerinnBill" filter="true"/>

							</logic:notEqual>

						</logic:present>

					</td>

				</tr>

				<tr>

					<td class="text"><bean:message key="label.bans.bill.number"/>:</td>

					<td class="text"><bean:write name="AbonentBilledListForm" property="billNumber" filter="true"/></td>

				</tr>

				<tr>

					<td class="text"><bean:message key="label.bans.bill.date"/>:</td>

					<td class="text" nowrap><july:datewrite name="AbonentBilledListForm" property="billDate"/></td>

				</tr>

				<tr>

					<td class="text"><bean:message key="label.bans.bill.sum"/>:</td>

					<td class="text" nowrap><july:sumwrite name="AbonentBilledListForm" property="sum"/></td>

				</tr>

				<tr>

					<td class="text"><bean:message key="label.bans.bill.sumnds"/>:</td>

					<td class="text" nowrap><july:sumwrite name="AbonentBilledListForm" property="sumnds"/></td>

				</tr>

				<tr>

					<td class="text"><bean:message key="label.bans.bill.sumnsp"/>:</td>

					<td class="text" nowrap><july:sumwrite name="AbonentBilledListForm" property="sumnsp"/></td>

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

						<july:backbutton page="/ShowAbonentBillsList.do"/>

					</td>

					<td class="navigator"><july:navigator/></td>

				</tr>

			</table>

		</td>

	</tr>



	<july:separator colspan="<%= gColSpan %>"/>

	

	<!-- Table header -->

	<tr class="title">

		<td rowspan="2" align="center" class="title"><bean:message key="label.payed.sumlinkusd"/></td>

		<td colspan="4" align="center" class="title"><bean:message key="label.payed.pay"/></td>

		<td rowspan="2" class="title">&nbsp;</td>

		<td rowspan="2" class="title">&nbsp;</td>

	</tr>

	<tr class="title">

		<july:headercolumn key="label.payed.pay.date" colType="string"/>

		<july:headercolumn key="label.payed.pay.number" colType="string"/>

		<july:headercolumn key="label.payed.pay.sum" colType="string"/>

		<july:headercolumn key="label.payed.pay.type" colType="string"/>

	</tr>



	<july:separator colspan="<%= gColSpan %>"/>



	<!-- Table body -->

	<logic:iterate id="it" name="browseList">

		<logic:present name="it">

			<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">

				<td class="number" align="right">

					<july:sumwrite name="it" property="sumlinkusd"/>

				</td>

				

				<td class="date" align="center">

					<july:datewrite name="it" property="abonentpayment.paydate"/>

				</td>

				

				<td class="text">

					<bean:write name="it" property="abonentpayment.paynumber" filter="true"/>

				</td>

				

				<td class="number" align="right">

					<july:sumwrite name="it" property="abonentpayment.sumpayusd"/>

				</td>

				

				<td class="text">

					<bean:write name="it" property="abonentpayment.typename" filter="true"/>

				</td>

				

				<logic:equal name="it" property="flagworknri" value="true"><% message = "label.payed.flagworknri.yes"; %></logic:equal>

				<logic:equal name="it" property="flagworknri" value="false"><% message = "label.payed.flagworknri.no"; %></logic:equal>

				<td class='number' align='center' title='<bean:message key="<%= message %>"/>'>

					<logic:equal name="it" property="flagworknri" value="true">+</logic:equal>

					<logic:equal name="it" property="flagworknri" value="false">-</logic:equal>

				</td>

				

				<logic:equal name="it" property="recordstatus" value="A"><% message = "label.payed.recordstatus.active"; %></logic:equal>

				<logic:equal name="it" property="recordstatus" value="D"><% message = "label.payed.recordstatus.deleted"; %></logic:equal>

				<td class='number' align='center' title='<bean:message key="<%= message %>"/>'>

					<logic:equal name="it" property="recordstatus" value="A">+</logic:equal>

					<logic:equal name="it" property="recordstatus" value="D">-</logic:equal>

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

						<july:backbutton page="/ShowAbonentBillsList.do"/>

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

			<july:currmark><bean:message key="label.bans.billed"/></july:currmark>

		</td>

	</tr>
--%>



</table>



</july:browseform>

