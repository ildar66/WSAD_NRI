<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<%--<july:editform action="/ProcessReport8.do">--%>
<july:editform action="/ProcessReportExcel.do">
<% String gColSpan = "2"; %>

<table class="main">
    
<july:separator colspan="<%= gColSpan %>" />
    
<tr>
	<td class="title">
		<july:checkbox styleClass="text" insertable="true" updatable="true" property="isSerial"/>
		<%--<html:radio value="S" property="type"/>--%>
		Заводской номер
		<july:checkbox styleClass="text" insertable="true" updatable="true" property="isManuf"/>
		<%--<html:radio value="M" property="type"/>--%>
		Инвентарный номер
	
	</td>
	<td class="text">
		<july:string size="20" property="serial" styleId="serial" insertable="true" updatable="true" />
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>" />

<tr>
	<td class="title">&nbsp;</td>
	<td class="text">
		<july:checkbox styleClass="text" insertable="true" updatable="true" property="showAgregated"/>&nbsp;<bean:message key="label.report8.showagregated"/>
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>" />

<tr class="title">
	<td class="title" colspan="<%= gColSpan %>">
		<INPUT TYPE="IMAGE" NAME="submit" SRC="/images/refresh.gif" ALT="<bean:message key="label.report.refresh"/>">
	</td>
</tr>
    
<july:separator colspan="<%= gColSpan %>" />

</table>

</july:editform>

