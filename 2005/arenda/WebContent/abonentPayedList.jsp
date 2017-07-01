<%@ page language = "java" %>

<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>

<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>



<% String gColSpan = "14"; %>

<% String emptyString = ""; %>

<% String message = null; %>



<july:browseform action="/ShowAbonentPayedList.do" styleId="AbonentPayedListForm">



<html:hidden property="pay"/>



<table class="main">

<%--
<tr class="title">

		<td class="title" colspan="<%= gColSpan %>">

			<html:link page="/ShowAbonentsList.do" styleClass="navigator"><bean:message key="label.abonents"/></html:link>

			<july:sepmark/>

			<july:editlink page="/ViewAbonent.do" action="View" paramId="leaseDocument" paramName="AbonentPaysListForm" paramProperty="leaseDocument" styleClass="navigator"><bean:message key="label.view"/></july:editlink>

			<july:sepmark/>

			<html:link page="/ShowAbonentPaysList.do" styleClass="navigator"><bean:message key="label.abonent.pays"/></html:link>

			<july:sepmark/>

			<july:currmark><bean:message key="label.abonent.payed"/></july:currmark>

		</td>

	</tr>
--%>



	<july:separator colspan="<%= gColSpan %>"/>



	<TR class="normal">

		<TD colspan="<%= gColSpan %>">

			<table class="find">

				<tr>

					<td class="text"><bean:message key="label.bans.ban"/>:</td>

					<td class="text" nowrap><bean:write name="AbonentPayedListForm" property="ban" filter="true"/></td>

				</tr>

				<tr>

					<td class="text"><bean:message key="label.bans.org.name"/>:</td>

					<td class="text">

						<bean:write name="AbonentPayedListForm" property="customername" filter="true"/>

						<logic:present name="AbonentPayedListForm" property="customernameBill">

							<logic:notEqual name="AbonentPayedListForm" property="customernameBill" value="<%= emptyString %>">

								&nbsp;<bean:message key="label.bans.frombilling"/>

								&nbsp;<bean:write name="AbonentPayedListForm" property="customernameBill" filter="true"/>

							</logic:notEqual>

						</logic:present>

				</tr>

				<tr>

					<td class="text"><bean:message key="label.bans.org.inn"/>:</td>

					<td class="text" nowrap>

						<bean:write name="AbonentPayedListForm" property="customerinn" filter="true"/>

						<logic:present name="AbonentPayedListForm" property="customerinnBill">

							<logic:notEqual name="AbonentPayedListForm" property="customerinnBill" value="<%= emptyString %>">

								&nbsp;<bean:message key="label.bans.frombilling"/>

								&nbsp;<bean:write name="AbonentPayedListForm" property="customerinnBill" filter="true"/>

							</logic:notEqual>

						</logic:present>

					</td>

				</tr>

				<tr>

					<td class="text"><bean:message key="label.abonent.pays.number"/>:</td>

					<td class="text">

						<bean:write name="AbonentPayedListForm" property="paynumber" filter="true"/>

					</td>

				</tr>

				<tr>

					<td class="text"><bean:message key="label.abonent.pays.date"/>:</td>

					<td class="text">

						<july:datewrite name="AbonentPayedListForm" property="paydate"/>

					</td>

				</tr>

				<tr>

					<td class="text"><bean:message key="label.abonent.pays.sum"/>:</td>

					<td class="text">

						<july:numberwrite name="AbonentPayedListForm" property="paysumm"/>&nbsp;<bean:message key="usd"/>

					</td>

				</tr>

				<tr>

					<td class="text"><bean:message key="label.abonent.pays.type"/>:</td>

					<td class="text">

						<bean:write name="AbonentPayedListForm" property="paytype" filter="true"/>

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

						<july:backbutton page="/ShowAbonentPaysList.do"/>

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

		<td colspan="3" align="center" class="title"><bean:message key="label.payed.bill"/></td>

		<td rowspan="2" class="title">&nbsp;</td>

		<td rowspan="2" class="title">&nbsp;</td>

	</tr>

	<tr class="title">

		<july:headercolumn key="label.payed.bill.date" colType="string"/>

		<july:headercolumn key="label.payed.bill.number" colType="string"/>

		<july:headercolumn key="label.payed.bill.sum" colType="string"/>

	</tr>

	

	<july:separator colspan="<%= gColSpan %>"/>



	<!-- Table body -->

	<logic:iterate id="it" name="browseList">

		<logic:present name="it">

			<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">

				<td class="number" align="right">

					<july:sumwrite name="it" property="o.sumlinkusd"/>

				</td>

				

				<td class="date">

					<july:datewrite name="it" property="o.abonentbill.billdate"/>

				</td>

				

				<td class="text">

					<bean:write name="it" property="o.abonentbill.billnumber" filter="true"/>

				</td>

				

				<td class="number" align="right">

					<july:sumwrite name="it" property="billsumm"/>

				</td>

				

				<logic:equal name="it" property="o.flagworknri" value="true"><% message = "label.payed.flagworknri.yes"; %></logic:equal>

				<logic:equal name="it" property="o.flagworknri" value="false"><% message = "label.payed.flagworknri.no"; %></logic:equal>

				<td class='number' align='center' title='<bean:message key="<%= message %>"/>'>

					<logic:equal name="it" property="o.flagworknri" value="true">+</logic:equal>

					<logic:equal name="it" property="o.flagworknri" value="false">-</logic:equal>

				</td>

				

				<logic:equal name="it" property="o.recordstatus" value="A"><% message = "label.payed.recordstatus.active"; %></logic:equal>

				<logic:equal name="it" property="o.recordstatus" value="D"><% message = "label.payed.recordstatus.deleted"; %></logic:equal>

				<td class='number' align='center' title='<bean:message key="<%= message %>"/>'>

					<logic:equal name="it" property="o.recordstatus" value="A">+</logic:equal>

					<logic:equal name="it" property="o.recordstatus" value="D">-</logic:equal>

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

						<july:backbutton page="/ShowAbonentPaysList.do"/>

					</td>

					<td class="navigator"><july:navigator/></td>

				</tr>

			</table>

		</td>

	</tr>

	

	<july:separator colspan="<%= gColSpan %>" />



<%--
<tr class="title">

		<td class="title" colspan="<%= gColSpan %>">

			<html:link page="/ShowAbonentsList.do" styleClass="navigator"><bean:message key="label.abonents"/></html:link>

			<july:sepmark/>

			<july:editlink page="/ViewAbonent.do" action="View" paramId="leaseDocument" paramName="AbonentPaysListForm" paramProperty="leaseDocument" styleClass="navigator"><bean:message key="label.view"/></july:editlink>

			<july:sepmark/>

			<html:link page="/ShowAbonentPaysList.do" styleClass="navigator"><bean:message key="label.abonent.pays"/></html:link>

			<july:sepmark/>

			<july:currmark><bean:message key="label.abonent.payed"/></july:currmark>

		</td>

	</tr>
--%>



</table>



</july:browseform>

