<%@ page language = "java" %>

<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>

<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>



<july:editform action="/ProcessArendaReport1Params.do">



<% String gColSpan = "2"; %>



<%--html:hidden property="calctype" value="-"/--%>



<table class="main">

<%--
<tr class="title">

		<td class="title" colspan="5">

			<july:currmark><bean:message key="label.report1"/></july:currmark>

		</td>

	</tr>
--%>



	<july:separator colspan="<%= gColSpan %>"/>



	<tr>

		<td class="text"><july:reqmark><bean:message key="label.report1.name"/>:</july:reqmark></td>

		<td class="text">

			<july:select style="width: 300;" collection="customers" property="orgCustomercode" insertable="true" updatable="true">

				<html:options collection="customers" property="organization" labelProperty="name"/>

			</july:select>

		</td>

	</tr>



	<july:separator colspan="<%= gColSpan %>"/>



	<tr>
		<td class="text"><july:reqmark><bean:message key="label.report1.date"/>:</july:reqmark></td>
		<td class="text"><july:date property="dateFrm" size="25" insertable="true" updatable="true"/></td>
	</tr>



	<%--july:separator colspan="<%= gColSpan %>"/>

	<tr>
		<td class="text"><july:reqmark><bean:message key="label.report1.rate"/>:</july:reqmark></td>
		<td class="text">
			<july:string property="rateFrm" size="25" insertable="true" updatable="true"/>&nbsp;
			<input type='image' name='submit' value='1' src='/images/obchet1.gif' alt='<bean:message key="label.filter.calcrate.short"/>' onclick='calctype.value = "R";'>
		</td>
	</tr--%>

	

	<july:separator colspan="<%= gColSpan %>"/>

	<tr class="title">
		<td class="title" colspan="<%= gColSpan %>">
			<INPUT TYPE="IMAGE" NAME="submit" SRC="/images/refresh.gif" ALT="<bean:message key="button.refresh"/>">
		</td>
	</tr>
  

	<july:separator colspan="<%= gColSpan %>"/>

</table>

</july:editform>

