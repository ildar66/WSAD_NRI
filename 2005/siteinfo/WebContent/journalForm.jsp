<%@ page language = "java" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.constants.*,org.apache.struts.util.MessageResources" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<july:editform action="/ProcessJournal.do">

<table class="main">

<tr class="title">
	<td class="title" colspan="2">
	<html:link page="/ShowJournalList.do" styleClass="navigator"><bean:message key="label.journal.list"/></html:link> 
	<july:sepmark/>
	<july:currmark><bean:message key="label.journal.form"/></july:currmark>
	</td>
</tr>
<july:separator/>

<tr class="title"><td colspan="2">
<july:backbutton page="/ShowJournalList.do"/>
</td></tr>

<tr>
	<td class="title" colspan="2"><july:actionalert/></td>
</tr>
<july:separator/>

<tr>
	<td class="text"><bean:message key="label.journal.object"/>:</td>
	<td>
		<bean:write name="JournalForm" property="objecttypename"/>
	</td>
</tr>

<july:separator/>

<tr>
	<td class="text"><bean:message key="label.journal.objectname"/>:</td>
	<td>
		<bean:write name="JournalForm" property="objectname"/>
	</td>
</tr>

<july:separator/>

<tr>
	<td class="text"><bean:message key="label.journal.user"/>:</td>
        <td>
		<bean:write name="JournalForm" property="userfullname"/><logic:present name="JournalForm" property="usertitle">&nbsp;[<bean:write name="JournalForm" property="usertitle"/>]</logic:present>
	</td>
</tr>

<july:separator/>

<tr>
	<td class="text"><bean:message key="label.journal.datetime"/>:</td>
	<td>
		<july:datewrite name="JournalForm" property="datetime" showtime="true"/>
	</td>
</tr>

<july:separator/>

<tr>
	<td class="text"><bean:message key="label.journal.eventtype"/>:</td>
	<td>
		<logic:present name="JournalForm" property="eventtypecode">
		<logic:equal name="JournalForm" property="eventtypecode" value="1">
			<bean:message key="label.journal.event.add"/>
		</logic:equal>
		<logic:equal name="JournalForm" property="eventtypecode" value="2">
			<bean:message key="label.journal.event.change"/>
		</logic:equal>
		<logic:equal name="JournalForm" property="eventtypecode" value="3">
			<bean:message key="label.journal.event.remove"/>
		</logic:equal>
		</logic:present>
	</td>
</tr>

<logic:present name="JournalForm" property="logDetails">

<july:separator/>

<tr>
	<td colspan="2">
	<table class="main">
		<!-- Table header -->
		<tr class="title" style="background-color: 'D6EBFF'">
			<july:headercolumn key="label.journal.fieldname" colType="string"/>
			<july:headercolumn key="label.journal.oldvalue" colType="string"/>
			<july:headercolumn key="label.journal.newvalue" colType="string"/>
		</tr>

		<july:separator colspan="3"/>

		<!-- Table body -->
		<logic:iterate id="it" name="JournalForm" property="logDetails">
		<logic:present name="it">
		<tr>
	            	<td class="text">
<%
	Object value = org.apache.struts.util.RequestUtils.lookup(pageContext, "it", "fieldlabel", null);
	if(value != null) {
//		MessageResources res = (MessageResources)session.getAttribute("journalResources");
//		if(res != null) {
//			String s = res.getMessage(value.toString());
		String s = "journal."+value.toString();
%>
<%--=value.toString()--%><%--=s--%>
<bean:message key='<%=s%>'/>
<%
//		}
	}
%>
	                </td>
			<td class="text">
				<bean:write name="it" property="oldvalue" filter="true"/>
			</td>
			<td class="text">
				<bean:write name="it" property="newvalue" filter="true"/>
			</td>
			<july:separator colspan="3"/>
		</tr>
		</logic:present>
		</logic:iterate>
	</table>
	</td>
</tr>
	
</logic:present>
<%--
<tr>
	<td class="text"><bean:message key="label.journal.changes"/>:</td>
	<td>
		<july:textarea property="changes" cols="50" rows="10" insertable="false" updatable="false"/>
	</td>
</tr>
<july:separator/>
--%>

<%-- <july:formbuttons/> --%>
<tr class="title"><td colspan="2">
<july:backbutton page="/ShowJournalList.do"/>
</td></tr>
<%--
<july:separator/>
--%>

</table>

</july:editform>
