<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "2"; %>

<july:editform action="/ProcessBen.do" styleId="BenForm">

<html:hidden property="leaseDocument"/>
<html:hidden property="oben"/>

<table class="main">
<%--
<tr class="title">
		<td class="title" colspan="<%= gColSpan %>">
			<html:link page="/ShowAbonentsList.do" styleClass="navigator"><bean:message key="label.abonents"/></html:link>
			<july:sepmark/>
			<html:link page="/ViewAbonent.do?action=View" styleClass="navigator"><bean:message key="label.abonents.dog"/></html:link>
			<july:sepmark/>
			<html:link page="/ShowBensList.do" styleClass="navigator"><bean:message key="label.bens.list"/></html:link>
			<july:sepmark/>
			<july:actionname/>
		</td>
	</tr>
--%>

    <july:separator colspan="<%= gColSpan %>"/>
    
    <tr>
        <td class="title" colspan="<%= gColSpan %>"><july:actionalert/></td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>

	<tr>
		<td class="text">
			<bean:message key="label.bens.abonentban"/>:
		</td>
		<td class="text">
			<bean:write name="BensListForm" property="ban" filter="true"/>
		</td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<td class="text"><july:reqmark><bean:message key="label.bens.ben"/>:</july:reqmark></td>
		<td class="text">
			<july:string size="15" property="benFrm" insertable="true" updatable="true"/>
		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>

	<july:formbuttons/>

	<july:separator colspan="<%= gColSpan %>"/>
		
</table>

</july:editform>
