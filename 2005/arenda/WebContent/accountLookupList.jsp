<%@ page language = "java" %>

<%@ page contentType = "text/html; charset=windows-1251" %>

<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>



<%java.lang.String gColSpan = "7";%>



<july:browseform action="/ShowAccountLookupList.do"
	styleId="AccountLookupListForm">



	<july:lookupresult tableId="brtable" resultCols="0;1;2;3;4" />



	<table class="main">

		<TR class="title">

			<TD class="title"><bean:message key="label.choose.account" /></TD>

		</TR>



		<TR class="normal">

			<TD colspan="<%=gColSpan%>">

			<table class="find">

				<TR>

					<td class="title"><bean:message key="label.organization.name" />:</td>

					<td class="title"><bean:write name="AccountLookupListForm"
						property="orgname" /></td>

				</tr>
			</table>

			</TD>

		</TR>



		<july:separator colspan="<%=gColSpan%>" />



		<tr class="title">

			<td>

			<TABLE class="buttons">

				<TR class="title">

					<TD class="buttons">
						<july:closebutton page="/" />
						<A href='/dict/AccountDialog.do?action=Add&orgcode=<bean:write name="AccountLookupListForm" property="organization" filter="true"/>' onclick='window.open(this.href, "AccountDialog", "top=100, left=300, width=500, height=250, scrollbars=yes, resizable=yes").focus(); return false;'>
							<IMG SRC="/images/plus.gif" BORDER='0' ALT='Добавить запись'></A>			
					</TD>

					<TD class="navigator"><july:navigator /><TD>

				</TR>
			</TABLE>

			</TD>
		</tr>



		<TR>

			<TD>



			<table class="main" id="brtable">



				<!-- Table header -->

				<tr class="title">

					<july:headercolumn key="label.code" colType="number" />

					<july:headercolumn key="label.account.value" colType="string" />

					<july:headercolumn key="label.account.bank" colType="string" />

					<july:headercolumn key="label.bank.bik" colType="string" />

					<july:headercolumn key="label.bank.corraccount" colType="string" />
					<TD class="title" title="Активность" align="center">!</TD>
					<TD class="title">&nbsp;</TD>
					<TD class="title">&nbsp;</TD>
				</tr>



				<!-- Table body -->

				<logic:iterate id="it" name="browseList" indexId="index">

					<logic:present name="it">

						<tr class="normal" onMouseOver="className='select'"
							onMouseOut="className='normal'">

							<td class="number"><bean:write name="it" property="account"
								filter="true" /></td>

							<td class="text"><july:lookupreturn>
								<bean:write name="it" property="accountvalue" filter="true" />
							</july:lookupreturn></td>

							<td class="text"><bean:write name="it" property="bank.name"
								filter="true" /></td>

							<td class="text"><bean:write name="it" property="bank.bik"
								filter="true" /></td>

							<td class="text"><bean:write name="it" property="bank.koraccount"
								filter="true" /></td>

							<td class="text">
								<%--bean:write name="it" property="active" filter="true" /--%>
								<html:checkbox name="it" property="active" disabled="true"/>
							</td>
								
							<td class="text">
								<A href='/dict/AccountDialog.do?action=Edit&account=<bean:write name="it" property="account" filter="true"/>' onclick='window.open(this.href, "AccountDialog", "top=100, left=300, width=500, height=250, scrollbars=yes, resizable=yes").focus(); return false;'><IMG SRC="/images/izmena.gif" BORDER='0' ALT='Изменить запись'></A>												
							</td>
							<td class="text">
								<A href='/dict/AccountDialog.do?action=Delete&account=<bean:write name="it" property="account" filter="true"/>' onclick='window.open(this.href, "AccountDialog", "top=100, left=300, width=600, height=600, scrollbars=yes, resizable=yes").focus(); return false;'><img src="/images/del.gif" border="0" alt='Удалить запись'></A>                        
							</td>

						</tr>



					</logic:present>



					<logic:notPresent name="it">

						<tr class="normal">

							<td class="text" colspan="<%=gColSpan%>"><bean:message
								key="label.norecords" /></td>

						</tr>

					</logic:notPresent>



					<july:separator colspan="<%=gColSpan%>" />



				</logic:iterate></table>

			</TD>

		</TR>



		<tr class="title">

			<td>

			<TABLE class="buttons">

				<TR class="title">

					<TD class="buttons"><july:closebutton page="/" />
						<A href='/dict/AccountDialog.do?action=Add&orgcode=<bean:write name="AccountLookupListForm" property="organization" filter="true"/>' onclick='window.open(this.href, "AccountDialog", "top=100, left=300, width=500, height=250, scrollbars=yes, resizable=yes").focus(); return false;'>
							<IMG SRC="/images/plus.gif" BORDER='0' ALT='Добавить запись'></A>			
					</TD>

					<TD class="navigator"><july:navigator /></TD>

				</TR>
			</TABLE>

			</TD>
		</tr>
	</TABLE>
</july:browseform>