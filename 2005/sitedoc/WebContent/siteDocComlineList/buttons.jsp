<%@ page language = "java" %>
<%@ page import="com.hps.july.persistence.*"%>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<%
	String gColSpan = request.getAttribute("colspan")+"";
%>
<tr class="title">
<td colspan="<%= gColSpan %>">
	<table class="buttons">
	<tr class="title">
		<td class="buttons">
			<input onclick="document.body.style.cursor='wait';" type=image alt='<bean:message key="SiteDocEquipmentList.alt.addEquipment"/>' src='/images/save.gif' name=submit_add/>
			<july:backbutton/>
		</td>
		<td class="navigator">
			<july:navigator/>
		</td>
	</tr>
	</table>
</td>
</tr>









