<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "6"; %>

<july:browseform action="/ShowChangeSPositionList.do" styleId="ChangeSPositionListForm">

<bean:define id="docCode" name="ChangeSPositionListForm" property="document" scope="session" type="java.lang.Integer"/>
<july:inventorycalcerrors document="<%= docCode %>"/>

<table class="main">
<tr class="title">
	<td class="title" colspan="<%= gColSpan %>">
		<html:link page="/ShowChangeSList.do" styleClass="navigator"><bean:message key="label.changesact"/></html:link>
		<july:sepmark/> 
		<july:currmark>
			<logic:present name="ChangeSPositionListForm" property="acttype">
				<logic:equal name="ChangeSPositionListForm" property="acttype" value="C"><bean:message key="label.changepos.acttype.change"/></logic:equal>
				<logic:equal name="ChangeSPositionListForm" property="acttype" value="U"><bean:message key="label.changepos.acttype.upgrade"/></logic:equal>
			</logic:present>
			<logic:notPresent name="ChangeSPositionListForm" property="acttype">јкт</logic:notPresent>
		</july:currmark>
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>" />

<TR class="normal">
 <TD colspan="<%= gColSpan %>">
    <table class="find">
	<tr>
		<td class="title">
			<logic:present name="ChangeSPositionListForm" property="acttype">
				<logic:equal name="ChangeSPositionListForm" property="acttype" value="C"><bean:message key="label.changepos.acttype.change"/></logic:equal>
				<logic:equal name="ChangeSPositionListForm" property="acttype" value="U"><bean:message key="label.changepos.acttype.upgrade"/></logic:equal>
			</logic:present>
			<logic:notPresent name="ChangeSPositionListForm" property="acttype">јкт</logic:notPresent>
		</td>
		<td class="title">
			<bean:message key="label.num"/>&nbsp;<bean:write name="ChangeSPositionListForm" property="blankindex"/>&nbsp;<bean:write name="ChangeSPositionListForm" property="blanknumber"/>&nbsp;<bean:message key="label.from"/>&nbsp;<july:datewrite name="ChangeSPositionListForm" property="blankdate"/>
		</td>
	</tr>
	<tr>
		<td class="title"><bean:message key="label.changespos.owner"/></td>
		<td class="title">
			<bean:write name="ChangeSPositionListForm" property="ownername"/>
		</td>
	</tr>
	<tr>
		<td class="title"><bean:message key="label.changespos.storage"/></td>
		<td class="title">
			<bean:write name="ChangeSPositionListForm" property="storagename"/>
		</td>
	</tr>
	<tr>
			<td class="text">
			</td>
	</tr>
    </table>
    
  </TD>
</TR>

<july:separator colspan="<%= gColSpan %>" />

<tr class="title">
	<td colspan="<%= gColSpan %>">
		<table class="buttons">
		<tr class="title">
			<TD class="buttons">
				<logic:equal name="ChangeSPositionListForm" property="readonly" value="false"><july:addbutton page="/EditChangeSPosition.do?action=Add" alttext="label.changespos.add"/></logic:equal>
				<logic:equal name="ChangeSPositionListForm" property="readonly" value="true">&nbsp;</logic:equal>
				<july:backbutton page="/ShowChangeSList.do"/></td>
			<TD class="navigator"><july:navigator/></td>
		</tr>
		</table>
	</td>
</tr>
        
<july:separator colspan="<%= gColSpan %>" />

<!-- Table header -->
<tr class="title">
	<td class="title">&nbsp;</td>
	<july:headercolumn key="label.changespos.resource" colType="string"/>
	<july:headercolumn key="label.changespos.oldserial" colType="string"/>
	<july:headercolumn key="label.changespos.newresource" colType="string"/>
	<july:headercolumn key="label.changespos.newserial" colType="string"/>
	<td class="title">&nbsp;</td>
</tr>

<july:separator colspan="<%= gColSpan %>" />

<!-- Table body -->
<logic:iterate id="it" name="browseList">
	<logic:present name="it">
		<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
			<td class="string">
				<logic:equal name="ChangeSPositionListForm" property="readonly" value="false">
					<july:editbutton page="/EditChangeSPosition.do" action="Edit" paramId="code" paramName="it" paramProperty="so.code" paramScope="page" alttext="label.changespos.edit"/>
				</logic:equal>
				<logic:equal name="ChangeSPositionListForm" property="readonly" value="true">
					<july:editbutton page="/EditChangeSPosition.do" action="View" paramId="code" paramName="it" paramProperty="so.code" paramScope="page" alttext="label.changespos.view"/>
				</logic:equal>
			</td>
			<td class="number">
				<logic:present name="it" property="oresname">
				<bean:write name="it" property="oresname" filter="true"/><logic:present name="it" property="oresmodel">,<br><bean:write name="it" property="oresmodel" filter="true"/></logic:present>
				</logic:present>
			</td>
			<td class="text">
				<bean:write name="it" property="oldserial" filter="true"/>
			</td>
			<td class="number">
				<logic:present name="it" property="resourcename">
				<bean:write name="it" property="resourcename" filter="true"/><logic:present name="it" property="resourcemodel">,<br><bean:write name="it" property="resourcemodel" filter="true"/></logic:present>
				</logic:present>
			</td>
			<td class="text">
				<bean:write name="it" property="newserial" filter="true"/>
			</td>
			<td class="link">
				<logic:equal name="ChangeSPositionListForm" property="readonly" value="false">
					<july:delbutton page="/EditChangeSPosition.do?action=Delete" paramId="code" paramName="it" paramProperty="so.code" paramScope="page" />
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
				<logic:equal name="ChangeSPositionListForm" property="readonly" value="false"><july:addbutton page="/EditChangeSPosition.do?action=Add" alttext="label.changespos.add"/></logic:equal>
				<logic:equal name="ChangeSPositionListForm" property="readonly" value="true">&nbsp;</logic:equal>
				<july:backbutton page="/ShowChangeSList.do"/></td>
			<TD class="navigator"><july:navigator/></td>
		</tr>
		</table>
	</td>
</tr>
        
<july:separator colspan="<%= gColSpan %>" />
      
<tr class="title">
	<td class="title" colspan="<%= gColSpan %>">
		<html:link page="/ShowChangeSList.do" styleClass="navigator"><bean:message key="label.changesact"/></html:link>
		<july:sepmark/> 
		<july:currmark>
			<logic:present name="ChangeSPositionListForm" property="acttype">
				<logic:equal name="ChangeSPositionListForm" property="acttype" value="C"><bean:message key="label.changepos.acttype.change"/></logic:equal>
				<logic:equal name="ChangeSPositionListForm" property="acttype" value="U"><bean:message key="label.changepos.acttype.upgrade"/></logic:equal>
			</logic:present>
			<logic:notPresent name="ChangeSPositionListForm" property="acttype">јкт</logic:notPresent>
		</july:currmark>
	</td>
</tr>

</table>

</july:browseform>
