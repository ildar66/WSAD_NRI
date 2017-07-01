<%@ page language = "java" %>
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
			<input onclick="document.body.style.cursor='wait';" type=image alt='<bean:message key="SiteDocPositionList.alt.addPosition"/>' src='/images/save.gif' name='submit_add'/>
			<july:backbutton page="/EditSiteDoc.do"/>
		</td>
		<td class='navigator'>
			<july:navigator/>
		</td>
	</tr>
	</table>
</td>
</tr>




