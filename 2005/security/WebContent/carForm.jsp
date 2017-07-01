<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.security.*,com.hps.july.security.formbean.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "2"; %>

<%
    String action = null;
	String form = null;
	String parent = null;
	switch (ParamsParser.getState(pageContext)) {
		case APPStates.DIRECTION_CAR_EDIT:
        	action = "/ProcessDirectionCar.do";
			form = "DirectionCarForm";
			parent = "/ShowDirectionCarsList.do";
        	break;
		case APPStates.SERVICE_CAR_EDIT:
        	action = "/ProcessServiceCar.do";
			form = "ServiceCarForm";
			parent = "/ShowServiceCarsList.do";
        	break;
		case APPStates.DEPARTMENT_CAR_EDIT:
        	action = "/ProcessDepartmentCar.do";
			form = "DepartmentCarForm";
			parent = "/ShowDepartmentCarsList.do";
        	break;
		case APPStates.GROUP_CAR_EDIT:
        	action = "/ProcessGroupCar.do";
			form = "GroupCarForm";
			parent = "/ShowGroupCarsList.do";
        	break;
    }
%>

<july:editform action="<%= action %>" styleId="<%= form %>">

<html:hidden property="car"/>

<table class="main">
	<tr class="title">
		<td class="title" colspan="<%= gColSpan %>">
			<html:link page="/ShowCompanyList.do" styleClass="navigator"><bean:message key="label.companies"/></html:link>
			<july:sepmark/>
			<july:link page="/ShowDirectionList.do" styleClass="navigator"><bean:message key="label.directions"/></july:link>
			<july:sepmark/>
			<%	if (ParamsParser.getState(pageContext) == APPStates.SERVICE_CAR_EDIT ||
					ParamsParser.getState(pageContext) == APPStates.DEPARTMENT_CAR_EDIT ||
					ParamsParser.getState(pageContext) == APPStates.GROUP_CAR_EDIT) { %>
					<july:link page="/ShowServiceList.do" styleClass="navigator"><bean:message key="label.services"/></july:link>
					<july:sepmark/>
				<%	if (ParamsParser.getState(pageContext) == APPStates.DEPARTMENT_CAR_EDIT ||
						ParamsParser.getState(pageContext) == APPStates.GROUP_CAR_EDIT) { %>
						<july:link page="/ShowDepartmentList.do" styleClass="navigator"><bean:message key="label.departments"/></july:link>
						<july:sepmark/>
					<%	if (ParamsParser.getState(pageContext) == APPStates.GROUP_CAR_EDIT) { %>
							<july:link page="/ShowGroupList.do" styleClass="navigator"><bean:message key="label.groups"/></july:link>
							<july:sepmark/>
					<%	} %>
				<%	} %>
			<%	} %>
			<july:link page="<%= parent %>" styleClass="navigator"><bean:message key="label.car.full"/></july:link>
			<july:sepmark/> 
			<july:actionname/>
		</td>
	</tr>

    <july:separator colspan="<%= gColSpan %>"/>
    
	<july:formbuttons/>
	
	<july:separator colspan="<%= gColSpan %>"/>

    <tr>
        <td class="title" colspan="<%= gColSpan %>"><july:actionalert/></td>
    </tr>

 	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<td class="text"><bean:message key="label.company.name"/>:</td>
		<td class="text"><bean:write name="company" property="name" /></td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<td class="text"><bean:message key="label.direction.name"/>:</td>
		<td class="text"><bean:write name="direction" property="name" /></td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>
	
	<% if (ParamsParser.getState(pageContext) == APPStates.SERVICE_CAR_EDIT ||
			ParamsParser.getState(pageContext) == APPStates.DEPARTMENT_CAR_EDIT ||
			ParamsParser.getState(pageContext) == APPStates.GROUP_CAR_EDIT) { %>
			
		<tr>
			<td class="text"><bean:message key="label.service.name"/>:</td>
			<td class="text"><bean:write name="service" property="name"/></td>
		</tr>
		
		<july:separator colspan="<%= gColSpan %>"/>
		
		<% if (ParamsParser.getState(pageContext) == APPStates.DEPARTMENT_CAR_EDIT ||
				ParamsParser.getState(pageContext) == APPStates.GROUP_CAR_EDIT) { %>
				
			<tr>
				<td class="text"><bean:message key="label.department.name"/>:</td>
				<td class="text"><bean:write name="department" property="name"/></td>
			</tr>
			
			<july:separator colspan="<%= gColSpan %>"/>
			
			<% if (ParamsParser.getState(pageContext) == APPStates.GROUP_CAR_EDIT) { %>
			
				<tr>
					<td class="text"><bean:message key="label.group.name"/>:</td>
					<td class="text"><bean:write name="group" property="name"/></td>
				</tr>
				
				<july:separator colspan="<%= gColSpan %>"/>
				
			<% } %>
		<% } %>
	<% } %>
	
	<tr>
		<td class="text"><july:reqmark><bean:message key="label.car.model"/>:</july:reqmark></td>
		<td class="text"><july:string size="50" property="car_model" insertable="true" updatable="true"/></td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<td class="text"><july:reqmark><bean:message key="label.car.number"/>:</july:reqmark></td>
		<td class="text"><july:string size="50" property="car_number" insertable="true" updatable="true"/></td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>
	
    <july:formbuttons/>
	
	<july:separator colspan="<%= gColSpan %>"/>
	
</table>

</july:editform>
