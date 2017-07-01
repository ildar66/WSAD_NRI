<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "4"; %>

<july:browseform action="/ShowJournalList.do">
<table class="main">

<tr class="title">
	<td class="title" colspan="<%= gColSpan %>">
	<july:currmark><bean:message key="label.journal.list"/></july:currmark>
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>" />


<tr class="normal">
	<td colspan="<%= gColSpan %>">
	<table class="find">
	<tr>
		<td class="title"><bean:message key="label.journal.object"/></td>
		<td class="title"><bean:write name="JournalListForm" property="objecttypename"/></td>
	</tr>        
	<tr>
		<td class="title"><bean:message key="label.journal.objectname"/></td>
		<td class="title"><bean:write name="JournalListForm" property="objectname"/></td>
	</tr>        
	</table>
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>" />

<tr class="title">
	<td colspan="<%= gColSpan %>">
	<table class="buttons">
	<tr class="title">
		<td class="buttons"><july:closebutton page="/"/></td>
		<td class="navigator"><july:navigator/></td>
        </tr>
	</table>
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>" />

<%-- Table header --%>
<tr class="title">
	<july:headercolumn key="label.journal.datetime" colType="string"/>
	<july:headercolumn key="label.journal.user" colType="string"/>
	<july:headercolumn key="label.journal.eventtype" colType="string"/>
<%-- 	<td class="title">&nbsp;</td>--%> 
</tr>

<july:separator colspan="<%= gColSpan %>" />

<%-- Table body --%>

<logic:iterate id="it" name="browseList">
	<logic:present name="it">
		<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
			<td class="text">
				<july:editlink page="/ViewJournal.do" action="View" paramId="logid" paramName="it" paramProperty="logid" paramScope="page">
				<july:datewrite name="it" property="recdate" showtime="true" />
				</july:editlink>
			</td>
			<td class="text">
				<bean:write name="it" property="people.lastname" filter="true"/>
				<logic:present name="it" property="people.firstname">
				&nbsp;<bean:write name="it" property="people.firstname" filter="true"/>
				</logic:present>
				<logic:present name="it" property="people.middlename">
				&nbsp;<bean:write name="it" property="people.middlename" filter="true"/>
				</logic:present>
			</td>
			<td class="text">
				<logic:equal name="it" property="eventtype" value="1">
					<bean:message key="label.journal.event.add"/>
				</logic:equal>
				<logic:equal name="it" property="eventtype" value="2">
					<bean:message key="label.journal.event.change"/>
				</logic:equal>
				<logic:equal name="it" property="eventtype" value="3">
					<bean:message key="label.journal.event.remove"/>
				</logic:equal>
			</td>
		</tr>

		<july:separator colspan="<%= gColSpan %>" />

	</logic:present>
</logic:iterate>

<tr class="title">
	<td colspan="<%= gColSpan %>">
	<table class="buttons">
	<tr class="title">
		<td class="buttons"><july:closebutton page="/"/></td>
		<td class="navigator"><july:navigator/></td>
        </tr>
	</table>
	</td>
</tr>
<%--
<july:separator colspan="<%= gColSpan %>" />

<tr class="title">
	<td class="title" colspan="<%= gColSpan %>">
	<july:currmark><bean:message key="label.journal.list"/></july:currmark>
	</td>
</tr>
--%>
</table>

</july:browseform>

