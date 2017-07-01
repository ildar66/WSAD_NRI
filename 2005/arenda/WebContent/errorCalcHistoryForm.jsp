<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.arenda.formbean.*,com.hps.july.arenda.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% String gColSpan = "4"; %>

<july:browseform action="/ShowErrorCalcHistoryList.do" styleId="ErrorCalcHistoryList">

<table class="main">

	<tr class="title">
		<td class="title" colspan="<%= gColSpan %>" align="right">
			<% ErrorCalcHistoryList formBean = (ErrorCalcHistoryList) request.getSession().getAttribute("ErrorCalcHistoryList"); %>
			<july:link page="<%= formBean.getReportUrl() %>"><bean:message key="label.contractcalc.report"/></july:link>
		</td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>

	<tr class="normal">
		<td colspan="<%= gColSpan %>">
			<table class="find">
				<tr>
					<td class="text"><bean:message key="label.journal.message.type"/>:</td>
					<td class="text">
						<july:checkbox property="isSuccess" insertable="true" updatable="true"/><bean:message key="label.journal.message.type.success"/>
						<july:checkbox property="isWarning" insertable="true" updatable="true"/><bean:message key="label.journal.message.type.warning"/>
						<july:checkbox property="isError" insertable="true" updatable="true"/><bean:message key="label.journal.message.type.error"/>
						<july:searchbutton/>
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
					<TD class="buttons"><july:closebutton page="/"/></TD>
					<td class="navigator"><july:navigator/></td>
				</tr>
			</table>
		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>

	<!-- Table header -->

	<tr class="title">
		<july:sortcolumn key="label.journal.reccode" colType="string" ascFinder="1" descFinder="2"/>
		<july:headercolumn key="label.journal.code" colType="string"/>
		<july:headercolumn key="label.journal.message.type" colType="string"/>
		<july:headercolumn key="label.journal.message" colType="string"/>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>

	<!-- Table body -->
	<logic:iterate id="it" name="browseList">
		<logic:present name="it">
			<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
 				<td class="number">
					<bean:write name="it" property="taskjournal" filter="true"/>
                </td>
 				<td class="text">
					<bean:write name="it" property="jrnaction" filter="true"/>
                </td>

				<td class="text">
					<logic:equal name="it" property="jrntype" value="S"><bean:message key="label.journal.message.type.success"/></logic:equal>
					<logic:equal name="it" property="jrntype" value="W"><bean:message key="label.journal.message.type.warning"/></logic:equal>
					<logic:equal name="it" property="jrntype" value="E"><bean:message key="label.journal.message.type.error"/></logic:equal>
				</td>
 				<td class="text">
					<logic:equal name="it" property="jrnaction" value="<%= Integer.toString(Errors.JOURNAL_STRMESSAGE) %>">
						<bean:write name="it" property="jrnmessage" filter="true"/>
					</logic:equal>
                </td>
			</tr>
		</logic:present>

		

		<logic:notPresent name="it">
			<tr class="normal">
				<td class="text" colspan="<%= gColSpan %>"><bean:message key="label.norecords"/></td>
			</tr>
		</logic:notPresent>

		<july:separator colspan="<%= gColSpan %>"/>

	</logic:iterate>

	

	<tr class="title">
		<td colspan="<%= gColSpan %>">
			<table class="buttons">
				<tr class="title">
					<TD class="buttons"><july:closebutton page="/"/></TD>
					<td class="navigator"><july:navigator/></td>
				</tr>
			</table>
		</td>
	</tr>

</table>

</july:browseform>

