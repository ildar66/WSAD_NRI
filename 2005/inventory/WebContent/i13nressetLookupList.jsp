<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "6"; %>

<july:browseform action="/ShowI13nRessetLookupList.do" styleId="ressetform">

<july:lookupresult tableId="brtable" resultCols="0;1;2"/>

<table class="main">
	<tr class="title">
		<td class="title">
			<bean:message key="label.choose.resset"/>
		</td>
	</tr>
	<tr class="normal">
	<td>
		<table class="find">
		<tr>
			<td class="title"><bean:message key="label.resset.act"/>:</td>
			<td class="title"><bean:message key="label.num"/>&nbsp;<bean:write name="I13nRessetLookupListForm" property="blankindex"/>&nbsp;<bean:write name="I13nRessetLookupListForm" property="blanknumber" />&nbsp;<bean:message key="label.from" />&nbsp;<bean:write name="I13nRessetLookupListForm" property="blankdatestr" /></td>
		</tr>
		<tr>
			<td class="title"><bean:message key="label.resset.org"/>:</td>
			<td class="title"><bean:write name="I13nRessetLookupListForm" property="ownername" /></td>
		</tr>
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

<tr>
	<td>
		<table class="main" id="brtable">

        <!-- Table header -->
		<tr class="title">
			<july:headercolumn key="label.resset.code" colType="number"/>
			<july:headercolumn key="label.resset.model" colType="string"/>
			<july:headercolumn key="label.resset.name" colType="string"/>
			<july:headercolumn key="label.resset.unit" colType="string"/>
			<july:headercolumn key="label.resset.policy" colType="string"/>
		</tr>

		<!-- Table body -->
		<logic:iterate id="rstl" name="browseList" indexId="index">
		<logic:present name="rstl">
			<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
				<td class="number"><bean:write name="rstl" property="resource.resource" filter="true"/></td>
				<td class="text"><july:lookupreturn><bean:write name="rstl" property="resource.model" filter="true"/></july:lookupreturn></td>
				<td class="text"><bean:write name="rstl" property="resource.name" filter="true"/></td>
				<td class="text"><logic:present name="rstl" property="resource.unit"><bean:write name="rstl" property="resource.unit.shortname" filter="true"/></logic:present></td>
				<td class="text">
					<logic:equal name="rstl" property="resource.countpolicy" value="S"><bean:message key="label.resource.countpolicys"/></logic:equal>
					<logic:equal name="rstl" property="resource.countpolicy" value="P"><bean:message key="label.resource.countpolicyp"/></logic:equal>
					<logic:equal name="rstl" property="resource.countpolicy" value="B"><bean:message key="label.resource.countpolicyb"/></logic:equal>
				</td>
			</tr>
		</logic:present>
          
		<logic:notPresent name="rstl">
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
