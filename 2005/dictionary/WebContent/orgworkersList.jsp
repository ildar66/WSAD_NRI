<%@ page language="java" %>
<%@ page contentType="TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<% java.lang.String gColSpan = "9"; %>

<july:browseform action="/ShowOrgworkersList.do" styleId="OrgworkersListForm">

<html:hidden property="lastnamemask" value="*"/>

<table class="main">
<%--
<tr class="title">
	<td class="title" colspan="<%= gColSpan %>">
		<html:link page="/ShowOrganizationListM.do" styleClass="navigator"><bean:message key="label.organizations"/></html:link>
		<july:sepmark/>
		<july:currmark><bean:message key="label.orgworkers.list"/></july:currmark>
	</td>
</tr>
--%>
<july:separator colspan="<%= gColSpan %>"/>
<tr class="normal">
	<td colspan="<%= gColSpan %>">
		<table class="find">
		<tr>
			<td class="title"><bean:message key="label.orgworkers.org"/>:</td>
			<td class="title"><bean:write name="OrgworkersListForm" property="organizationname"/></td>
			<td class="title"><july:searchbutton/></td>
		</tr>
<%--
		<tr>
		<td class="title"><bean:message key="label.orgworkers.lastname"/>:</td>
		<td class="title">
			<july:string property="lastnamemask" styleId="lastnamemask" size="25" insertable="true" updatable="true" styleClass="editsearch"/>
			<july:searchbutton/>
		</td>
		</tr>
--%>
	</table>
	</td>
</tr>
<july:separator colspan="<%= gColSpan %>"/>
<tr class="title">
	<td colspan="<%= gColSpan %>">
		<table class="buttons">
		<tr class="title">
			<td class="buttons">
				<july:addbutton page="/EditOrgworker.do?action=Add"/>
				<july:backbutton/>
			</td>
			<td class="navigator">
				<july:navigator/>
			</td>
		</tr>
		</table>
	</td>
</tr>
<july:separator colspan="<%= gColSpan %>"/><!-- Table header -->
<tr class="title">
	<td class="title">&nbsp;</td>
		<july:headercolumn key="label.code" colType="number"/>
		<july:headercolumn key="label.orgworkers.fio" colType="string"/>
		<july:headercolumn key="label.orgworkers.passport" colType="string"/>
	<td class="title">&nbsp;</td>
</tr>
<july:separator colspan="<%= gColSpan %>"/><!-- Table body -->

<logic:iterate id="it" name="browseList">
<logic:present name="it">
<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
	<td class="text">
		<july:editbutton page="/EditOrgworker.do" action="Edit" paramId="worker" paramName="it" paramProperty="worker" paramScope="page"/>
	</td>
	<td class="number">
		<bean:write name="it" property="worker" filter="true"/>
	</td>
	<td class="text">
		<bean:write name="it" property="man.fullName" filter="true"/>
	</td>
	<td class="text">
		<bean:write name="it" property="man.passportser" filter="true"/>
	</td>
	<td class="link">
		<july:delbutton page="/EditOrgworker.do?action=Delete" paramId="worker" paramName="it" paramProperty="worker" paramScope="page"/>
	</td>
</tr>
<july:separator colspan="<%= gColSpan %>"/>
</logic:present>
</logic:iterate>
<tr class="title">
	<td colspan="<%= gColSpan %>">
		<table class="buttons">
		<tr class="title">
			<td class="buttons">
				<july:addbutton page="/EditOrgworker.do?action=Add"/>
				<july:backbutton/>
			</td>
			<td class="navigator">
				<july:navigator/>
			</td>
		</tr>
		</table>
	</td>
</tr>
<july:separator colspan="<%= gColSpan %>"/>
<%--
<tr class="title">
	<td class="title" colspan="<%= gColSpan %>">
		<html:link page="/ShowOrganizationListM.do" styleClass="navigator"><bean:message key="label.organizations"/></html:link>
		<july:sepmark/>
		<july:currmark><bean:message key="label.orgworkers.list"/></july:currmark>
	</td>
</tr>
--%>
</table>
</july:browseform>