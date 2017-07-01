<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>

<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% String gColSpan = "6"; %>

<july:browseform action="/ShowBSSectorLookupList.do" styleId="BSSectorLookupListForm">

<july:lookupresult tableId="brtable" resultCols="0;1"/>

<table class="main">
<tr class="title">
	<td class="title" colspan="2">
		<bean:message key="label.choose.bssector"/>
	</td>
</tr>
<july:separator />

<%-- filter fields --%>
<tr class='normal'>
	<td>
		<table class='find'>
		<tr>
			<td class="title"><bean:message key="label.bssectorlookup.bs"/>:</td>
			<td class="title">
				<html:hidden property="bs.key"/>
				<bean:write name="BSSectorLookupListForm" property="bs.fullname" filter="true"/>
			</td>
		</tr>
		</table>
	</td>
</tr>

<july:separator colspan="1"/>

<%-- top navigation line --%>
<tr class="title">
	<td>
		<table class="buttons">
		<tr class="title">
			<td class="buttons"><july:closebutton page="/"/></td>
			<td class="navigator"><july:navigator/></td>
		</tr>
		</table>
	</td>
</tr>

<july:separator colspan="1" />

<tr>
<td>
<table class="main" id="brtable">

<%-- table rendering --%>
<tr class="title">
	<td style="visibility:hidden;display:none;"></td>
	<td style="visibility:hidden;display:none;"></td>
	<july:headercolumn key="label.bssector.num" colType="integer"/>
	<july:headercolumn key="label.bssector.name" colType="string"/>
	<july:headercolumn key="label.bssector.range" colType="integer"/>
	<july:headercolumn key="label.bssector.azimut" colType="integer"/>
</tr>

<logic:iterate id="it" name="browseList" indexId="index">
<logic:present name="it">

<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
	<td style="visibility:hidden;display:none;"><bean:write name="it" property="idsect" filter="true"/></td>
	<td style="visibility:hidden;display:none;"><bean:write name="it" property="namesect" filter="true"/></td>
	<td><july:lookupreturn><bean:write name="it" property="numsect" filter="true"/></july:lookupreturn></td>
	<td><bean:write name="it" property="namesect" filter="true"/></td>
	<td><bean:write name="it" property="band" filter="true" /></td>
	<td><july:numberwrite name="it" property="azimut" /></td>
</tr>

</logic:present>
<logic:notPresent name="it">
<tr class="normal">
	<td class="text" colspan="<%= gColSpan %>">
		<bean:message key="label.norecords"/>
	</td>
</tr>
</logic:notPresent>

<july:separator colspan="<%= gColSpan %>" />

</logic:iterate>
</table>
</td>
</tr>

<%-- bottom navigation line --%>
<tr class="title">
	<td>
		<table class="buttons">
		<tr class="title">
			<td class="buttons"><july:closebutton page="/"/></td>
			<td class="navigator"><july:navigator/></td>
		</tr>
		</table>
	</td>
</tr>

</table>

</july:browseform>
