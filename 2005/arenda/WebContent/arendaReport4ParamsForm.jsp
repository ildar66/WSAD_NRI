<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<july:editform action="/ProcessArendaReport4Params.do">

<% String gColSpan = "2"; %>

<table class="main">

<%--
<tr class="title">

		<td class="title" colspan="<%= gColSpan %>">

			<july:currmark><bean:message key="label.report4"/></july:currmark>

		</td>

	</tr>
--%>


	<july:separator colspan="<%= gColSpan %>"/>

	<tr>
		<td class="text"><bean:message key="label.report4.startdate"/></td>
		<td class="text"><july:date property="startdateFrm" size="25" insertable="true" updatable="true"/></td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>

	<tr>
		<td class="text"><bean:message key="label.report4.finishdate"/></td>
		<td class="text"><july:date property="finishdateFrm" size="25" insertable="true" updatable="true"/></td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>

	<tr class="title">
		<td class="title" colspan="<%= gColSpan %>">
			<INPUT TYPE="IMAGE" NAME="submit" SRC="/images/refresh.gif" ALT="<bean:message key="button.refresh"/>">
		</td>
	</tr>
 
	<july:separator colspan="<%= gColSpan %>"/>

</table>

</july:editform>

