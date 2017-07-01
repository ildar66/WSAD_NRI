<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "9"; %>

<july:browseform action="/ShowPayoffPositionList.do" styleId="PayoffPositionListForm">

<bean:define id="docCode" name="PayoffPositionListForm" property="document" scope="session" type="java.lang.Integer"/>
<july:inventorycalcerrors document="<%= docCode %>"/>

<table class="main">
<tr class="title">
	<td class="title" colspan="<%= gColSpan %>">
		<html:link page="/ShowPayoffList.do" styleClass="navigator"><bean:message key="label.payoff"/></html:link>
		<july:sepmark/> 
		<july:currmark><bean:message key="label.payoffpos"/></july:currmark>
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>" />

<TR class="normal">
 <TD colspan="<%= gColSpan %>">
    <table class="find">
	<tr>
		<td class="title"><bean:message key="label.payoff.owner"/></td>
		<td class="title">
			<bean:write name="PayoffPositionListForm" property="ownername"/>
		</td>
	</tr>
	<tr>
		<td class="title"><bean:message key="label.payoff.storage"/></td>
		<td class="title">
			<bean:write name="PayoffPositionListForm" property="storagename"/>
		</td>
	</tr>
	<tr>
		<td class="title"><bean:message key="label.payoff.document"/></td>
		<td class="title">
			<bean:message key="label.num"/>&nbsp;<bean:write name="PayoffPositionListForm" property="blankindex"/>&nbsp;<bean:write name="PayoffPositionListForm" property="blanknumber"/>&nbsp;<bean:message key="label.from"/>&nbsp;<bean:write name="PayoffPositionListForm" property="blankdatestr"/>
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
				<logic:equal name="PayoffPositionListForm" property="readonly" value="false"><july:addbutton page="/EditPayoffPosition.do?action=Add" alttext="label.payoffpos.add"/></logic:equal>
				<logic:equal name="PayoffPositionListForm" property="readonly" value="true">&nbsp;</logic:equal>
				<july:backbutton page="/ShowPayoffList.do"/></td>
			<TD class="navigator"><july:navigator/></td>
		</tr>
		</table>
	</td>
</tr>
        
<july:separator colspan="<%= gColSpan %>" />

<!-- Table header -->
<tr class="title">
	<td class="title">&nbsp;</td>
	<july:headercolumn key="label.payoff.numpp" colType="number"/>
	<july:headercolumn key="label.payoff.name" colType="string"/>
	<july:headercolumn key="label.payoff.blocktype" colType="string"/>
	<july:headercolumn key="label.payoff.policynum" colType="string"/>
	<july:headercolumn key="label.payoff.qty.short" colType="number"/>
	<july:headercolumn key="label.payoff.price" colType="string"/>
	<july:headercolumn key="label.payoff.sum" colType="string"/>
	<td class="title">&nbsp;</td>
</tr>

<july:separator colspan="<%= gColSpan %>" />

<!-- Table body -->
<logic:iterate id="it" name="browseList">
	<logic:present name="it">
		<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
			<td class="string">
				<logic:equal name="PayoffPositionListForm" property="readonly" value="false">
					<july:editbutton page="/EditPayoffPosition.do" action="Edit" paramId="docposition" paramName="it" paramProperty="docposition" paramScope="page" alttext="label.payoffpos.edit"/>
				</logic:equal>
				<logic:equal name="PayoffPositionListForm" property="readonly" value="true">
					<july:editbutton page="/EditPayoffPosition.do" action="View" paramId="docposition" paramName="it" paramProperty="docposition" paramScope="page" alttext="label.payoffpos.view"/>
				</logic:equal>
			</td>
			<td class="number">
				<bean:write name="it" property="order" filter="true"/>
			</td>
			<td class="text">
				<bean:write name="it" property="resource.name" filter="true"/>
			</td>
			<td class="text">
				<bean:write name="it" property="resource.model" filter="true"/>
			</td>
			<td class="text">
				<logic:equal name="it" property="resource.countpolicy" value="S">
					<bean:write name="it" property="serialnumber" filter="true"/>
					<july:notEqual nameleft="it" propertyleft="serialnumber" nameright="it" propertyright="manufserial">
						&nbsp;(<bean:write name="it" property="manufserial" filter="true"/>)
					</july:notEqual>
				</logic:equal>
				<logic:equal name="it" property="resource.countpolicy" value="P">
					<bean:write name="it" property="party" filter="true"/>
				</logic:equal>
			</td>
			<td class="text">
				<july:numberwrite name="it" property="qty"/>
			</td>
			<td class="text">
				<bean:write name="it" property="price" filter="true"/>
			</td>
			<td class="text">
				<bean:write name="it" property="sum" filter="true"/>
			</td>
			<td class="link">
				<logic:equal name="PayoffPositionListForm" property="readonly" value="false">
					<july:delbutton page="/EditPayoffPosition.do?action=Delete" paramId="docposition" paramName="it" paramProperty="docposition" paramScope="page" />
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
				<logic:equal name="PayoffPositionListForm" property="readonly" value="false"><july:addbutton page="/EditPayoffPosition.do?action=Add" alttext="label.payoffpos.add"/></logic:equal>
				<logic:equal name="PayoffPositionListForm" property="readonly" value="true">&nbsp;</logic:equal>
				<july:backbutton page="/ShowPayoffList.do"/></td>
			<TD class="navigator"><july:navigator/></td>
		</tr>
		</table>
	</td>
</tr>
        
<july:separator colspan="<%= gColSpan %>" />
      
<tr class="title">
	<td class="title" colspan="<%= gColSpan %>">
		<html:link page="/ShowPayoffList.do" styleClass="navigator"><bean:message key="label.payoff"/></html:link>
		<july:sepmark/> 
		<july:currmark><bean:message key="label.payoffpos"/></july:currmark>
	</td>
</tr>

</table>

</july:browseform>