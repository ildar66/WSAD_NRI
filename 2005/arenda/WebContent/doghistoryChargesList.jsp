<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% String gColSpan = "15"; %>

<july:browseform action="/ShowDogHistChargeList.do" styleId="DogHistChargeListForm">

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
		<td class="title" VALIGN="TOP">&nbsp;</td>
		<td class="title" VALIGN="TOP"><bean:message key="label.dhistch.actdate"/></td>
		<td class="title" VALIGN="TOP"><bean:message key="label.dhistch.billnum"/></td>
		<td class="title" VALIGN="TOP"><bean:message key="label.dhistch.billdate"/></td>
		<td class="title" VALIGN="TOP"><bean:message key="label.dhistch.resource"/></td>
		<td class="title" VALIGN="TOP"><bean:message key="label.dhistch.summ"/></td>
		<td class="title" VALIGN="TOP"><bean:message key="label.dhistch.change"/></td>
		<td class="title" VALIGN="TOP"><bean:message key="label.dhistch.curr"/></td>
		<td class="title" VALIGN="TOP"><bean:message key="label.dhistch.rate"/></td>
		<td class="title" VALIGN="TOP">&nbsp;</td>
		<td class="title" VALIGN="TOP">&nbsp;</td>
		<td class="title" VALIGN="TOP" COLSPAN="3"><bean:message key="label.dhistch.period"/></td>
		<td class="title" VALIGN="TOP"><bean:message key="label.dhistch.type"/></td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>

	<!-- Table body -->
	<logic:iterate id="it" name="browseList">
		<logic:present name="it">
			<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
				<td class="text">
					<logic:present name="it" property="leasebill">
						<july:link page="/EditAbonentBill.do?action=View" paramId="leasebill" paramName="it" paramProperty="leasebill">
							<IMG SRC="/images/izmena.gif" BORDER=0 alt='<bean:message key="label.dhistch.lnkeditschet"/>'>
						</july:link>
					</logic:present>
				</td>
				<td class="text">
					<july:datewrite name="it" property="actdate" shortformat="true"/>
				</td>
				<td class="text">
					<bean:write name="it" property="billnumber" filter="true"/>
				</td>
				<td class="text">
					<july:datewrite name="it" property="billdate" shortformat="true"/>
				</td>
				<td class="text">
					<bean:write name="it" property="resname" filter="true"/>
				</td>
				<td class="text" style="text-align: right;" NOWRAP>
					<july:numberwrite name="it" property="summ" fractdigits="2"/>
				</td>
				<td class="text">
					<logic:equal name="it" property="sumchanged" value="true">
						<IMG SRC="/images/setrow.gif" BORDER=0>
					</logic:equal>
				</td>
				<td class="text">
					<bean:write name="it" property="currname" filter="true"/>
				</td>
				<td class="text" style="text-align: right;" NOWRAP>
					<july:numberwrite name="it" property="crate" fractdigits="4"/>
				</td>
				<td class="text">
					<july:link page="/ShowChargeDnopList.do" paramId="leaseDocPosition" paramName="it" paramProperty="idchargeabonent">
						<IMG SRC="/images/kontr.gif" BORDER=0 alt='<bean:message key="label.dhistch.lnkpayments"/>'>
					</july:link>
				</td>
				<td class="text">
					<july:link page="/ShowChargeRatesList.do" paramId="docpositioncode" paramName="it" paramProperty="idchargeabonent">
						<IMG SRC="/images/rateicon.gif" BORDER=0 alt='<bean:message key="label.dhistch.lnkrates"/>'>
					</july:link>
				</td>
				<td class="text">
					<july:datewrite name="it" property="sdate" shortformat="true"/>
				</td>
				<td class="text">
					-
				</td>
				<td class="text">
					<july:datewrite name="it" property="edate" shortformat="true"/>
				</td>
				<td class="text">
					<logic:present name="it" property="leasebill">
						<IMG SRC="/images/setrow.gif" BORDER=0>
					</logic:present>
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
				
