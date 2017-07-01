<%@ page import="com.hps.july.persistence.*"%>

<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "5"; %>

<july:browseform action="/ShowSwitchLookupList.do">
<july:lookupresult tableId="brtable" resultCols="0;2;4"/>
<table class="main">
<tr class="title">
	<td class="title"><bean:message key="label.choose.switch"/></td>
</tr>
<tr class="normal">
	<td>
		<table class="find">
		<logic:present name="SwitchLookupListForm" property="type">
		<tr>
			<td><bean:message key="label.switch.type"/>:</td>
			<td>
			<logic:equal name="SwitchLookupListForm" property="type" value="1">DAMPS</logic:equal>
			<logic:equal name="SwitchLookupListForm" property="type" value="2">GSM/DCS</logic:equal>
			</td>
		</tr>
		</logic:present>
		</table>
	</td>
</tr>
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
<TR>
	<TD>
		<table class="main" id="brtable">
		<!-- Table header -->
		<tr class="title">
			<july:headercolumn key="label.switch.number" colType="number"/>
			<july:headercolumn key="label.switch.name" colType="string"/>
			<july:headercolumn key="label.equipment.posname" colType="string"/>
			<july:headercolumn key="label.switch.resource" colType="string"/>
			<td style="visibility:hidden;display:none;"></td>
		</tr>
		<!-- Table body -->
		<logic:iterate id="swch" name="browseList" indexId="index">
		<logic:present name="swch">
			<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
				<td class="number"><july:lookupreturn><bean:write name="swch" property="number" filter="true"/></july:lookupreturn></td>
				<td class="text"><logic:present name="swch" property="name"><bean:write name="swch" property="name" filter="true"/></logic:present></td>
				<td class="text"><logic:present name="swch" property="position"><logic:present name="swch" property="position.gsmid">D<bean:write name="swch" property="position.gsmid" filter="true"/>&nbsp;</logic:present><logic:present name="swch" property="position.dampsid">A<bean:write name="swch" property="position.dampsid" filter="true"/>&nbsp;</logic:present><bean:write name="swch" property="position.name" filter="true"/></logic:present></td>
				<td class="text"><logic:present name="swch" property="resource"><bean:write name="swch" property="resource.name" filter="true"/> <bean:write name="swch" property="resource.model" filter="true"/></logic:present></td>
				<td style="visibility:hidden;display:none;"><bean:write name="swch" property="storageplace" filter="true"/></td>
			</tr>
		</logic:present>
		<logic:notPresent name="swch">
			<tr class="normal"><td class="text" colspan="<%= gColSpan %>"><bean:message key="label.norecords"/></td></tr>
		</logic:notPresent>
		<july:separator colspan="<%= gColSpan %>" />
		</logic:iterate>
		</table>
	</TD>
</TR>
<tr class="title">
	<td>
		<TABLE class="buttons">
		<TR class="title">
			<TD class="buttons"><july:closebutton page="/"/></TD>
			<TD class="navigator"><july:navigator/></TD>
		</TR>
		</TABLE>
	</TD>
</tr>
</TABLE>
</july:browseform>