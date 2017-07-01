<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>


<% String gColSpan = "2"; %>


		<july:separator colspan="<%= gColSpan %>"/>


		<tr>
			<td class="text">
				<july:reqmark><bean:message key="label.filter.executor.name"/>:</july:reqmark>
			</td>
			<td class="text">
				<july:string size="50" property="execname" insertable="false" updatable="false"/>
			</td>
		</tr>