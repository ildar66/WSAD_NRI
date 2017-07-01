<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "2"; %>

<july:editform action="/ProcessCar.do" styleId="CarForm">

<html:hidden property="car"/>

<table class="main">
<%--
	<tr class="title">
		<td class="title" colspan="<%= gColSpan %>">
			<html:link page="/ShowOrganizationListM.do" styleClass="navigator"><bean:message key="label.organizations"/></html:link>
			<july:sepmark/>
			<july:link page="/ShowCarsList.do" styleClass="navigator"><bean:message key="label.car.full"/></july:link>
			<july:sepmark/> 
			<july:actionname/>
		</td>
	</tr>
--%>
    <july:separator colspan="<%= gColSpan %>"/>
    
	<july:formbuttons/>
	
	<july:separator colspan="<%= gColSpan %>"/>

    <tr>
        <td class="title" colspan="<%= gColSpan %>"><july:actionalert/></td>
    </tr>

 	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<td class="text"><bean:message key="label.organization.name"/>:</td>
		<td class="text"><bean:write name="CarsList" property="organizationname"/></td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>
	
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
