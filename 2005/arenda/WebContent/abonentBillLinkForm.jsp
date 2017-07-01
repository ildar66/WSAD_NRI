<%@ page language = "java" %>

<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>

<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>



<% java.lang.String gColSpan = "2"; %>



<july:editform action="/ProcessAbonentBillLink.do" styleId="AbonentBillLinkForm">



<html:hidden property="idrecord"/>



<table class="main">

<%--
<tr class="title">

		<td class="title" colspan="<%= gColSpan %>">

			<bean:message key="label.bill.link"/>

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

		<td class="text"><bean:message key="label.code"/>:</td>

		<td class="text"><july:string size="50" property="idresbilling" insertable="false" updatable="false"/></td>

	</tr>

	

	<july:separator colspan="<%= gColSpan %>"/>

	

	<tr>

		<td class="text"><bean:message key="label.name"/>:</td>

		<td class="text"><july:string size="50" property="billresname" insertable="false" updatable="false"/></td>

	</tr>

	

	<july:separator colspan="<%= gColSpan %>"/>

	

	<tr>

		<td class="text"><bean:message key="label.bill.resource.nri"/>:</td>

		<td class="text">

	   		<july:select style="width: 450;" collection="resources" property="resourcecode" insertable="true" updatable="true">

				<html:options collection="resources" property="resource" labelProperty="name"/>

			</july:select>

		</td>

	</tr>

	

	<july:separator colspan="<%= gColSpan %>"/>

		

	<july:formbuttons/>

	

	<july:separator colspan="<%= gColSpan %>"/>

			

</table>



</july:editform>

