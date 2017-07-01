<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.security.*" %>

<% String gColSpan = "4"; %>

<%
    String action = null;
	String form = null;
	String parent = null;
	String parentLabel = null;
	String edit = null;
	String temp = null;
	switch (ParamsParser.getState(pageContext)) {
		case APPStates.DIRECTION_CARS_LIST:
        	action = "/ShowDirectionCarsList.do";
			form = "DirectionCarsList";
			parent = "/ShowDirectionList.do";
			parentLabel = "label.directions";
			edit = "/EditDirectionCar.do";
        	break;
		case APPStates.SERVICE_CARS_LIST:
        	action = "/ShowServiceCarsList.do";
			form = "ServiceCarsList";
			parent = "/ShowServiceList.do";
			parentLabel = "label.services";
			edit = "/EditServiceCar.do";
        	break;
		case APPStates.DEPARTMENT_CARS_LIST:
        	action = "/ShowDepartmentCarsList.do";
			form = "DepartmentCarsList";
			parent = "/ShowDepartmentList.do";
			parentLabel = "label.departments";
			edit = "/EditDepartmentCar.do";
        	break;
		case APPStates.GROUP_CARS_LIST:
        	action = "/ShowGroupCarsList.do";
			form = "GroupCarsList";
			parent = "/ShowGroupList.do";
			parentLabel = "label.groups";
			edit = "/EditGroupCar.do";
        	break;
    }
%>

<july:browseform action="<%= action %>" styleId="<%= form %>">

<table class="main">
	<tr class="title">
		<td class="title" colspan="<%= gColSpan %>">
			<html:link page="/ShowCompanyList.do" styleClass="navigator"><bean:message key="label.companies"/></html:link>
			<july:sepmark/>
			<%	if (ParamsParser.getState(pageContext) == APPStates.SERVICE_CARS_LIST ||
					ParamsParser.getState(pageContext) == APPStates.DEPARTMENT_CARS_LIST ||
					ParamsParser.getState(pageContext) == APPStates.GROUP_CARS_LIST) { %>
					<july:link page="/ShowDirectionList.do" styleClass="navigator"><bean:message key="label.directions"/></july:link>
					<july:sepmark/>
				<%	if (ParamsParser.getState(pageContext) == APPStates.DEPARTMENT_CARS_LIST ||
						ParamsParser.getState(pageContext) == APPStates.GROUP_CARS_LIST) { %>
						<july:link page="/ShowServiceList.do" styleClass="navigator"><bean:message key="label.services"/></july:link>
						<july:sepmark/>
					<%	if (ParamsParser.getState(pageContext) == APPStates.GROUP_CARS_LIST) { %>
							<july:link page="/ShowDepartmentList.do" styleClass="navigator"><bean:message key="label.departments"/></july:link>
							<july:sepmark/>
					<%	} %>
				<%	} %>
			<%	} %>
			<july:link page="<%= parent %>" styleClass="navigator"><bean:message key="<%= parentLabel %>"/></july:link>
			<july:sepmark/>
			<july:currmark><bean:message key="label.car.full"/></july:currmark>
		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>
	
	<TR class="normal">
		<TD colspan="<%= gColSpan %>">
			<table class="find">
				<TR>
					<td class="title"><bean:message key="label.company.name"/>:</td>
					<td class="title"><bean:write name="company" property="name" /></td>
				</tr>
				<TR>
					<td class="title"><bean:message key="label.direction.name"/>:</td>
					<td class="title"><bean:write name="direction" property="name" /></td>
				</tr>
				<% if (ParamsParser.getState(pageContext) == APPStates.SERVICE_CARS_LIST ||
						ParamsParser.getState(pageContext) == APPStates.DEPARTMENT_CARS_LIST ||
						ParamsParser.getState(pageContext) == APPStates.GROUP_CARS_LIST) { %>
					<tr>
						<td class="title"><bean:message key="label.service.name"/>:</td>
						<td class="title"><bean:write name="service" property="name" /></td>
					</tr>
					<% if (ParamsParser.getState(pageContext) == APPStates.DEPARTMENT_CARS_LIST ||
							ParamsParser.getState(pageContext) == APPStates.GROUP_CARS_LIST) { %>
						<tr>
							<td class="title"><bean:message key="label.department.name"/>:</td>
							<td class="title"><bean:write name="department" property="name" /></td>
						</tr>
						<% if (ParamsParser.getState(pageContext) == APPStates.GROUP_CARS_LIST) { %>
							<tr>
								<td class="title"><bean:message key="label.group.name"/>:</td>
								<td class="title"><bean:write name="group" property="name" /></td>
							</tr>
						<% } %>
					<% } %>
				<% } %>
			</table>
		</TD>
	</TR>
	
	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr class="title">
		<td colspan="<%= gColSpan %>"><TABLE class="buttons">
			<TR class="title">
				<TD class="buttons">
					<% temp = edit + "?action=Add"; %>
					<july:addbutton page="<%= temp %>"/>
					<july:backbutton page="<%= parent %>"/>
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
					<july:editbutton page="<%= edit %>" action="Edit" paramId="car" paramName="it" paramProperty="car" paramScope="page"/>
				</td>
				<td class="text"><bean:write name="it" property="car_model" filter="true"/></td>
				<td class="text"><bean:write name="it" property="car_number" filter="true"/></td>
				<td class="link">
					<% temp = edit + "?action=Delete"; %>
					<july:delbutton page="<%= temp %>" paramId="car" paramName="it" paramProperty="car" paramScope="page"/>
				</td>
			</tr>
			
			<july:separator colspan="<%= gColSpan %>"/>
			
		</logic:present>
	</logic:iterate>

	<tr class="title">
		<td colspan="<%= gColSpan %>"><TABLE class="buttons">
			<TR class="title">
				<TD class="buttons">
					<% temp = edit + "?action=Add"; %>
					<july:addbutton page="<%= temp %>"/>
					<july:backbutton page="<%= parent %>"/>
				</TD>
				<TD class="navigator"><july:navigator/></TD>
			</TR>
		</TABLE></TD>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr class="title">
		<td class="title" colspan="<%= gColSpan %>">
			<html:link page="/ShowCompanyList.do" styleClass="navigator"><bean:message key="label.companies"/></html:link>
			<july:sepmark/>
			<% if (ParamsParser.getState(pageContext) == APPStates.SERVICE_CARS_LIST ||
					ParamsParser.getState(pageContext) == APPStates.DEPARTMENT_CARS_LIST ||
					ParamsParser.getState(pageContext) == APPStates.GROUP_CARS_LIST) { %>
					<july:link page="/ShowDirectionList.do" styleClass="navigator"><bean:message key="label.directions"/></july:link>
					<july:sepmark/>
				<% if (ParamsParser.getState(pageContext) == APPStates.DEPARTMENT_CARS_LIST ||
						ParamsParser.getState(pageContext) == APPStates.GROUP_CARS_LIST) { %>
						<july:link page="/ShowServiceList.do" styleClass="navigator"><bean:message key="label.services"/></july:link>
						<july:sepmark/>
					<% if (ParamsParser.getState(pageContext) == APPStates.GROUP_CARS_LIST) { %>
							<july:link page="/ShowDepartmentList.do" styleClass="navigator"><bean:message key="label.departments"/></july:link>
							<july:sepmark/>
					<% } %>
				<% } %>
			<% } %>
			<july:link page="<%= parent %>" styleClass="navigator"><bean:message key="<%= parentLabel %>"/></july:link>
			<july:sepmark/>
			<july:currmark><bean:message key="label.car.full"/></july:currmark>
		</td>
	</tr>
	
</table>

</july:browseform>
