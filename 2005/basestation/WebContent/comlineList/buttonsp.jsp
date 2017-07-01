<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld"    prefix="alex" %>

<% String gColSpan = request.getAttribute("colspan")+""; %>

<tr class="title">
	<td colspan="<%= gColSpan %>">
	<table class="buttons">
        <tr class="title">
		<td class="buttons">
			<% String editAction="/EditComlineR.do"; %>
			<alex:hasAccess href="<%=editAction%>" >
				<html:link page='<%=editAction+"?action=Add"%>' paramId="posidaFrm" paramName="ComlinePositionListForm" paramProperty="poscode"><IMG alt='<bean:message key="ComlineList.buttons.add"/>' src="/images/plus.gif" border=0></html:link>
			</alex:hasAccess>
			<img alt="" src="/images/empty.gif" width=3 border=0>
			<july:backbutton/>
			&nbsp;
			<image name="onMap" src="/images/map.gif" alt="<bean:message key="ComlineList.buttons.map"/>" onclick="determineMaps();"/>
		</td>
		<td class="navigator"><july:navigator/></td>
	</tr>
	</table>
	</td>
</tr>
