<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "9"; %>

<july:browseform action="/ShowAssactposBList.do" styleId="AssactposBListForm">

<table class="main">

<july:separator colspan="<%= gColSpan %>" />

<TR class="normal">
 <TD colspan="<%= gColSpan %>">
    <table class="find">
	<tr>
		<td class="title"><bean:message key="label.assactposb.document"/></td>
		<td class="title">
			<bean:message key="label.num"/>&nbsp;<bean:write name="AssactposBListForm" property="blankindex"/>&nbsp;<bean:write name="AssactposBListForm" property="blanknumber"/>&nbsp;<bean:message key="label.from"/>&nbsp;<july:datewrite name="AssactposBListForm" property="blankdate"/>
		</td>
	</tr>
	<tr>
		<td class="title"><bean:message key="label.assactposb.owner"/></td>
		<td class="title">
			<bean:write name="AssactposBListForm" property="ownername"/>
		</td>
	</tr>
	<tr>
		<td class="title"><bean:message key="label.assactposb.position"/></td>
		<td class="title">
			<bean:write name="AssactposBListForm" property="positionid"/>&nbsp;<bean:write name="AssactposBListForm" property="positionname"/>
		</td>
	</tr>
	<tr>
		<td class="title"><bean:message key="label.assactposb.complect"/></td>
		<td class="title">
			<bean:write name="AssactposBListForm" property="complectname"/>
		</td>
	</tr>
	<tr>
		<td class="title"><bean:message key="label.assactposb.agregate"/></td>
		<td class="title">
			<bean:write name="AssactposBListForm" property="agregatename"/>
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
				<logic:equal name="AssactposBListForm" property="readonly" value="false"><july:addbutton page="/EditAssactposB.do?action=Add"  alttext="label.assactpos.add"/></logic:equal>
				<logic:equal name="AssactposBListForm" property="readonly" value="true">&nbsp;</logic:equal>
				<july:backbutton page="/ShowAssactBList.do"/></td>
			<TD class="navigator"><july:navigator/></td>
		</tr>
		</table>
	</td>
</tr>
        
<july:separator colspan="<%= gColSpan %>" />

<!-- Table header -->
<tr class="title">
	<td class="title">&nbsp;</td>
	<july:headercolumn key="label.num" colType="number"/>
	<july:headercolumn key="label.assactposb.name" colType="string"/>
	<july:headercolumn key="label.assactposb.qty.short" colType="string"/>
	<july:headercolumn key="label.assactposb.unit.short" colType="string"/>
	<july:headercolumn key="label.assactposb.price" colType="string"/>
	<july:headercolumn key="label.assactposb.sum" colType="string"/>
	<july:headercolumn key="label.assactposb.serial" colType="string"/>
	<td class="title">&nbsp;</td>
</tr>

<july:separator colspan="<%= gColSpan %>" />

<!-- Table body -->
<logic:iterate id="it" name="browseList">
	<logic:present name="it">
		<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
			<td class="string">
				<logic:equal name="AssactposBListForm" property="readonly" value="false">
					<july:editbutton page="/EditAssactposB.do" action="Edit" paramId="docposition" paramName="it" paramProperty="docposition" paramScope="page" alttext="label.assactpos.edit"/>
				</logic:equal>
				<logic:equal name="AssactposBListForm" property="readonly" value="true">
					<july:editbutton page="/EditAssactposB.do" action="View" paramId="docposition" paramName="it" paramProperty="docposition" paramScope="page" alttext="label.assactpos.view"/>
				</logic:equal>
			</td>
			<td class="number">
				<bean:write name="it" property="order" filter="true"/>
			</td>
			<td class="text">
				<bean:write name="it" property="resource.name" filter="true"/><logic:present name="it" property="resource.model">,<br><bean:write name="it" property="resource.model" filter="true"/></logic:present><logic:present name="it" property="configuration">,<br><bean:write name="it" property="configuration" filter="true"/></logic:present>
			</td>
			<td class="text">
				<july:numberwrite name="it" property="qty" />
			</td>
			<td class="text">
				<logic:present name="it" property="resource.unit">
					<bean:write name="it" property="resource.unit.shortname" filter="true"/>
				</logic:present>
			</td>
			<td class="text">
				<bean:write name="it" property="price" filter="true"/>
			</td>
			<td class="text">
				<bean:write name="it" property="sum" filter="true"/>
			</td>
			<td class="text">
				<bean:write name="it" property="serialnumber" filter="true"/>
				<logic:present name="it" property="manufserial">
				<july:notEqual nameleft="it" propertyleft="serialnumber" nameright="it" propertyright="manufserial">
					&nbsp;(<bean:write name="it" property="manufserial" filter="true"/>)
				</july:notEqual>
				</logic:present>
			</td>
			<td class="link">
				<logic:equal name="AssactposBListForm" property="readonly" value="false">
					<july:delbutton page="/EditAssactposB.do?action=Delete" paramId="docposition" paramName="it" paramProperty="docposition" paramScope="page" />
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
				<logic:equal name="AssactposBListForm" property="readonly" value="false"><july:addbutton page="/EditAssactposB.do?action=Add" alttext="label.assactpos.add"/></logic:equal>
				<logic:equal name="AssactposBListForm" property="readonly" value="true">&nbsp;</logic:equal>
				<july:backbutton page="/ShowAssactBList.do"/></td>
			<TD class="navigator"><july:navigator/></td>
		</tr>
		</table>
	</td>
</tr>
        
<july:separator colspan="<%= gColSpan %>" />

</table>

</july:browseform>
