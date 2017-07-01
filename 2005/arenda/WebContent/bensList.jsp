<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% String gColSpan = "2"; %>

<july:browseform action="/ShowBensList.do" styleId="BensListForm">

<table class="main">

<%--
<tr class="title">
		<td class="title" colspan="<%= gColSpan %>">

			<html:link page="/ShowAbonentsList.do" styleClass="navigator"><bean:message key="label.abonents"/></html:link>

			<july:sepmark/>

			<html:link page="/ViewAbonent.do?action=View" styleClass="navigator"><bean:message key="label.abonents.dog"/></html:link>

			<july:sepmark/>

			<july:currmark><bean:message key="label.bens.list"/></july:currmark>

		</td>

	</tr>
--%>

	<july:separator colspan="<%= gColSpan %>"/>

	<tr class="normal">
		<td colspan="<%= gColSpan %>">
			<table class="find">
				<tr>
					<td width="30%" nowrap><bean:message key="label.bens.abonentban"/>:</td>
					<td class="text">
						<bean:write name="AbonentForm" property="documentNumber" filter="true"/>
					</td>
					<td width="1%"><july:searchbutton/></td>
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

							<logic:equal name="AbonentForm" property="contractState" value="A">

								<july:addbutton page="/EditBen.do?action=Add"/>

							</logic:equal>

						</july:canedit>

						<july:backbutton page="/ViewAbonent.do?action=View"/>

					</td>

					<td class="navigator"><july:navigator/></td>

				</tr>

			</table>

		</td>

	</tr>

	

	<july:separator colspan="<%= gColSpan %>"/>



	<!-- Table header -->

	<tr class="title">

		<july:headercolumn key="label.bens.ben" colType="string"/>

		<td class="title" width="1%">&nbsp;</td>

	</tr>



	<july:separator colspan="<%= gColSpan %>"/>



	<!-- Table body -->

	<logic:iterate id="it" name="browseList">

		<logic:present name="it">

			<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">

				<td class="text">

					<bean:write name="it" property="ben" filter="true"/>

				</td>

 				<td class="text">

					<july:canedit rolesProperty="editRoles">

						<logic:equal name="AbonentForm" property="contractState" value="A">

							<july:delbutton page="/EditBen.do?action=Delete" paramId="ben" paramName="it" paramProperty="ben" paramScope="page"/>

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

							<logic:equal name="AbonentForm" property="contractState" value="A">

								<july:addbutton page="/EditBen.do?action=Add"/>

							</logic:equal>

						</july:canedit>

						<july:backbutton page="/ViewAbonent.do?action=View"/>

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

			<html:link page="/ViewAbonent.do?action=View" styleClass="navigator"><bean:message key="label.abonents.dog"/></html:link>

			<july:sepmark/>

			<july:currmark><bean:message key="label.bens.list"/></july:currmark>

		</td>

	</tr>
--%>



</table>



</july:browseform>

