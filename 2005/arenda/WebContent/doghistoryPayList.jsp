<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% String gColSpan = "11"; %>

<july:browseform action="/ShowDogHistPayList.do" styleId="DogHistPayListForm">

<html:hidden property="idhistoryarenda"/>

<table class="main">

<july:separator colspan="<%= gColSpan %>"/>
	<TR class="normal">
		<TD colspan="<%= gColSpan %>">
			<table class="find">
				<tr>
					<td class="text" width="30%">&nbsp;</td>
					<td class="text" nowrap>&nbsp;</td>
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
		<td class="title" VALIGN="TOP"><bean:message key="label.dhistpay.resource"/></td>
		<td class="title" VALIGN="TOP"><bean:message key="label.dhistpay.state"/></td>
		<td class="title" VALIGN="TOP"><bean:message key="label.dhistpay.number"/></td>
		<td class="title" VALIGN="TOP"><bean:message key="label.dhistpay.date"/></td>
		<td class="title" VALIGN="TOP"><bean:message key="label.dhistpay.summrub"/></td>
		<td class="title" VALIGN="TOP"><bean:message key="label.dhistpay.summ"/></td>
		<td class="title" VALIGN="TOP"><bean:message key="label.dhistpay.curr"/></td>
		<td class="title" VALIGN="TOP"><bean:message key="label.dhistpay.rate"/></td>
		<td class="title" VALIGN="TOP">&nbsp;</TD>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>

	<!-- Table body -->
	<logic:iterate id="it" name="browseList">
		<logic:present name="it">
			<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
				<td class="text">
					<bean:write name="it" property="resname" filter="true"/>
				</td>
				<td class="text">
					<% 
						if (((com.hps.july.arenda.valueobject.DogHistPayObject)it).getState() != null) {
							String keyStr = "label.dhistpay.paystate_" + ((com.hps.july.arenda.valueobject.DogHistPayObject)it).getState();
					%>
							<bean:message key="<%= keyStr %>"/>
					<%
						}
					%>
				</td>
				<td class="text">
					<bean:write name="it" property="number" filter="true"/>
				</td>
				<td class="text">
					<july:datewrite name="it" property="date" shortformat="true"/>
				</td>
				<td class="text" style="text-align: right;" NOWRAP>
					<july:sumwrite name="it" property="summrub"/>
				</td>
				<td class="text" style="text-align: right;" NOWRAP>
					<july:sumwrite name="it" property="summ" />
				</td>
				<td class="text">
					<bean:write name="it" property="currname" filter="true"/>
				</td>
				<td class="text">
					<bean:write name="it" property="rate" filter="true"/>
				</td>
				<td class="text">
					<july:link page="/ShowChargeRatesList.do" paramId="docpositioncode" paramName="it" paramProperty="idpayabonent">
						<IMG SRC="/images/rateicon.gif" BORDER=0 alt='<bean:message key="label.dhistch.lnkrates"/>'>
					</july:link>
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
	
	<july:separator colspan="<%= gColSpan %>" />

</table>

</july:browseform>
				
