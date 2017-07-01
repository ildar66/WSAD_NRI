<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% String gColSpan = "4"; %>
<% String temp = null; %>

<july:browseform action="/ShowCarsList.do" styleId="CarsList">

<table class="main">
<%--SA
	<tr class="title">
		<td class="title" colspan="<%= gColSpan %>">
			<html:link page="/ShowOrganizationListM.do" styleClass="navigator"><bean:message key="label.organizations"/></html:link>
			<july:sepmark/>
			<july:currmark><bean:message key="label.car.full"/></july:currmark>
		</td>
	</tr>
--%>	
	<july:separator colspan="<%= gColSpan %>"/>
	
	<TR class="normal">
		<TD colspan="<%= gColSpan %>">
			<table class="find">
				<TR>
					<td class="title"><bean:message key="label.organization.name"/>:</td>
					<td class="title"><bean:write name="CarsList" property="organizationname"/></td>
				</tr>
			</table>
		</TD>
	</TR>
	
	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr class="title">
		<td colspan="<%= gColSpan %>"><TABLE class="buttons">
			<TR class="title">
				<TD class="buttons">
					<july:canedit rolesProperty="editRoles"><july:addbutton page="/EditCar.do?action=Add"/></july:canedit>
<%--					<july:backbutton page="/ShowOrganizationListM.do"/>--%>
					<july:backbutton/>
				</TD>
				<TD class="navigator"><july:navigator/></TD>
			</TR>
		</TABLE></TD>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>
	
	<!-- Table header -->
	<tr class="title">
		<TD class="title">&nbsp;</TD>
		<july:headercolumn key="label.car.model" colType="string"/>
		<july:headercolumn key="label.car.number" colType="string"/>
		<TD class="title">&nbsp;</TD>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>

	<!-- Table body -->
	<logic:iterate id="it" name="browseList">
		<logic:present name="it">
			<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
				<td class="link">
					<% temp = "View"; %>
					<july:canedit rolesProperty="editRoles"><% temp = "Edit"; %></july:canedit>
					<july:editbutton page="/EditCar.do" action="<%= temp %>" paramId="car" paramName="it" paramProperty="car" paramScope="page"/>
				</td>
				<td class="text"><bean:write name="it" property="car_model" filter="true"/></td>
				<td class="text"><bean:write name="it" property="car_number" filter="true"/></td>
				<td class="link">
					<july:canedit rolesProperty="editRoles">
						<july:delbutton page="/EditCar.do?action=Delete" paramId="car" paramName="it" paramProperty="car" paramScope="page"/>
					</july:canedit>
				</td>
			</tr>
			
			<july:separator colspan="<%= gColSpan %>"/>
			
		</logic:present>
	</logic:iterate>

	<tr class="title">
		<td colspan="<%= gColSpan %>"><TABLE class="buttons">
			<TR class="title">
				<TD class="buttons">
					<july:canedit rolesProperty="editRoles"><july:addbutton page="/EditCar.do?action=Add"/></july:canedit>
					<%--july:backbutton page="/ShowOrganizationListM.do"/--%>
					<july:backbutton/>
				</TD>
				<TD class="navigator"><july:navigator/></TD>
			</TR>
		</TABLE></TD>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>
<%--SA	
	<tr class="title">
		<td class="title" colspan="<%= gColSpan %>">
			<html:link page="/ShowOrganizationListM.do" styleClass="navigator"><bean:message key="label.organizations"/></html:link>
			<july:sepmark/>
			<july:currmark><bean:message key="label.car.full"/></july:currmark>
		</td>
	</tr>
--%>	
</table>

</july:browseform>
