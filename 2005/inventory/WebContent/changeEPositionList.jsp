<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "5"; %>

<july:browseform action="/ShowChangeEPositionList.do" styleId="ChangeEPositionListForm">

<bean:define id="docCode" name="ChangeEPositionListForm" property="document" scope="session" type="java.lang.Integer"/>
<july:inventorycalcerrors document="<%= docCode %>"/>

<table class="main">
<tr class="title">
	<td class="title" colspan="<%= gColSpan %>">
		<html:link page="/ShowChangeEList.do" styleClass="navigator"><bean:message key="label.changeeact"/></html:link>
		<july:sepmark/> 
		<july:currmark><bean:message key="label.changeepos"/></july:currmark>
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>" />

<TR class="normal">
 <TD colspan="<%= gColSpan %>">
    <table class="find">
	<tr>
		<td class="title"><bean:message key="label.changeepos.document"/></td>
		<td class="title">
			<bean:message key="label.num"/>&nbsp;<bean:write name="ChangeEPositionListForm" property="blankindex"/>&nbsp;<bean:write name="ChangeEPositionListForm" property="blanknumber"/>&nbsp;<bean:message key="label.from"/>&nbsp;<july:datewrite name="ChangeEPositionListForm" property="blankdate"/>
		</td>
	</tr>
	<tr>
		<td class="title"><bean:message key="label.changeepos.owner"/></td>
		<td class="title">
			<bean:write name="ChangeEPositionListForm" property="ownername"/>
		</td>
	</tr>
<logic:equal name="ChangeEPositionListForm" property="type" value="P">
	<tr>
		<td class="title"><bean:message key="label.changeepos.organization"/></td>
		<td class="title">
			<bean:write name="ChangeEPositionListForm" property="organizationname"/>
		</td>
	</tr>
</logic:equal>
<logic:equal name="ChangeEPositionListForm" property="type" value="W">
	<tr>
		<td class="title"><bean:message key="label.changeepos.worker"/></td>
		<td class="title">
			<bean:write name="ChangeEPositionListForm" property="workername"/>
		</td>
	</tr>
</logic:equal>
    </table>
    
  </TD>
</TR>

<july:separator colspan="<%= gColSpan %>" />

<tr class="title">
	<td colspan="<%= gColSpan %>">
		<table class="buttons">
		<tr class="title">
			<TD class="buttons">
				<logic:equal name="ChangeEPositionListForm" property="readonly" value="false"><july:addbutton page="/EditChangeEPosition.do?action=Add" alttext="label.changeepos.add"/></logic:equal>
				<logic:equal name="ChangeEPositionListForm" property="readonly" value="true">&nbsp;</logic:equal>
				<july:backbutton page="/ShowChangeEList.do"/></td>
			<TD class="navigator"><july:navigator/></td>
		</tr>
		</table>
	</td>
</tr>
        
<july:separator colspan="<%= gColSpan %>" />

<!-- Table header -->
<tr class="title">
	<td class="title">&nbsp;</td>
	<july:headercolumn key="label.name" colType="string"/>
	<july:headercolumn key="label.changeepos.oldserial" colType="string"/>
	<july:headercolumn key="label.changeepos.newserial" colType="string"/>
	<td class="title">&nbsp;</td>
</tr>

<july:separator colspan="<%= gColSpan %>" />

<!-- Table body -->
<logic:iterate id="it" name="browseList">
	<logic:present name="it">
		<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
			<td class="string">
				<logic:equal name="ChangeEPositionListForm" property="readonly" value="false">
					<july:editbutton page="/EditChangeEPosition.do" action="Edit" paramId="code" paramName="it" paramProperty="so.code" paramScope="page" alttext="label.changeepos.edit"/>
				</logic:equal>
				<logic:equal name="ChangeEPositionListForm" property="readonly" value="true">
					<july:editbutton page="/EditChangeEPosition.do" action="View" paramId="code" paramName="it" paramProperty="so.code" paramScope="page" alttext="label.changeepos.view"/>
				</logic:equal>
			</td>
			<td class="number">
				<bean:write name="it" property="resourcename" filter="true"/><logic:present name="it" property="resourcemodel">,<br><bean:write name="it" property="resourcemodel" filter="true"/></logic:present>
			</td>
			<td class="text">
				<bean:write name="it" property="so.oldSerial" filter="true"/>
			</td>
			<td class="text">
				<bean:write name="it" property="so.newSerial" filter="true"/>
			</td>
			<td class="link">
				<logic:equal name="ChangeEPositionListForm" property="readonly" value="false">
					<july:delbutton page="/EditChangeEPosition.do?action=Delete" paramId="code" paramName="it" paramProperty="so.code" paramScope="page" />
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
			<TD class="buttons">
				<logic:equal name="ChangeEPositionListForm" property="readonly" value="false"><july:addbutton page="/EditChangeEPosition.do?action=Add" alttext="label.changeepos.add"/></logic:equal>
				<logic:equal name="ChangeEPositionListForm" property="readonly" value="true">&nbsp;</logic:equal>
				<july:backbutton page="/ShowChangeEList.do"/></td>
			<TD class="navigator"><july:navigator/></td>
		</tr>
		</table>
	</td>
</tr>
        
<july:separator colspan="<%= gColSpan %>" />
      
<tr class="title">
	<td class="title" colspan="<%= gColSpan %>">
		<html:link page="/ShowChangeEList.do" styleClass="navigator"><bean:message key="label.changeeact"/></html:link>
		<july:sepmark/> 
		<july:currmark><bean:message key="label.changeepos"/></july:currmark>
	</td>
</tr>

</table>

</july:browseform>
