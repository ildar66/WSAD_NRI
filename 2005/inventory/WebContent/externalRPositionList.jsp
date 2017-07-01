<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "10"; %>

<july:browseform action="/ShowExternalRPositionList.do" styleId="ExternalRPositionListForm">

<bean:define id="docCode" name="ExternalRPositionListForm" property="document" scope="session" type="java.lang.Integer"/>
<july:inventorycalcerrors document="<%= docCode %>"/>

<table class="main">
<tr class="title">
	<td class="title" colspan="<%= gColSpan %>">
		<html:link page="/ShowExternalRList.do" styleClass="navigator"><bean:message key="label.externalr"/></html:link>
		<july:sepmark/> 
		<july:currmark><bean:message key="label.externalrpos"/></july:currmark>
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>" />

<TR class="normal">
 <TD colspan="<%= gColSpan %>">
    <table class="find">
	<tr>
		<td class="title"><bean:message key="label.externalrpos.document"/></td>
		<td class="title">
			<bean:message key="label.num"/>&nbsp;<bean:write name="ExternalRPositionListForm" property="blankindex"/>&nbsp;<bean:write name="ExternalRPositionListForm" property="blanknumber"/>&nbsp;<bean:message key="label.from"/>&nbsp;<bean:write name="ExternalRPositionListForm" property="blankdatestr"/>
		</td>
	</tr>
	<tr>
		<td class="title"><bean:message key="label.externalrpos.owner"/></td>
		<td class="title">
			<bean:write name="ExternalRPositionListForm" property="ownername"/>
		</td>
	</tr>
	<tr>
		<td class="title"><bean:message key="label.externalrpos.storage"/></td>
		<td class="title">
			<bean:write name="ExternalRPositionListForm" property="storagename"/>
		</td>
	</tr>
	<tr>
		<td class="title"><bean:message key="label.externalrpos.recipient"/></td>
		<td class="title">
			<bean:write name="ExternalRPositionListForm" property="recipientname"/>
		</td>
	</tr>
	<tr>
		<td class="title"><bean:message key="label.externalrpos.insurance"/></td>
		<td class="title">
			<bean:write name="ExternalRPositionListForm" property="insuranseMan"/>
		</td>
	</tr>
	<tr>
		<td class="title"><bean:message key="label.externalrpos.dov"/></td>
		<td class="title">
			<bean:message key="label.num"/>&nbsp;<bean:write name="ExternalRPositionListForm" property="insuranceact"/>&nbsp;<bean:message key="label.from"/>&nbsp;<bean:write name="ExternalRPositionListForm" property="insurancedatestr"/>
		</td>
	</tr>
	<tr>
		<td class="title"><bean:message key="label.externalrpos.currency"/></td>
		<td class="title">
			<bean:write name="ExternalRPositionListForm" property="currencyshortname" filter="true"/>
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
				<logic:equal name="ExternalRPositionListForm" property="readonly" value="false"><july:addbutton page="/EditExternalRPosition.do?action=Add" alttext="label.externalrpos.add"/></logic:equal>
				<logic:equal name="ExternalRPositionListForm" property="readonly" value="true">&nbsp;</logic:equal>
				<july:backbutton page="/ShowExternalRList.do"/></td>
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
	<july:headercolumn key="label.externalrpos.name" colType="string"/>
	<july:headercolumn key="label.externalrpos.qty.short" colType="string"/>
	<july:headercolumn key="label.externalrpos.unit.short" colType="string"/>
	<july:headercolumn key="label.externalrpos.price" colType="string"/>
	<july:headercolumn key="label.externalrpos.sum" colType="string"/>
	<july:headercolumn key="label.externalrpos.serial" colType="string"/>
	<td class="title">&nbsp;</td>
</tr>

<july:separator colspan="<%= gColSpan %>" />

<!-- Table body -->
<logic:iterate id="it" name="browseList">
	<logic:present name="it">
		<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
			<td class="string">
				<logic:equal name="ExternalRPositionListForm" property="readonly" value="false">
                    <logic:notPresent name="it" property="o.agregate">
					   <july:editbutton page="/EditExternalRPosition.do" action="Edit" paramId="docposition" paramName="it" paramProperty="o.docposition" paramScope="page" alttext="label.externalrpos.edit"/>
                    </logic:notPresent>
				</logic:equal>
				<logic:equal name="ExternalRPositionListForm" property="readonly" value="true">
					<july:editbutton page="/EditExternalRPosition.do" action="View" paramId="docposition" paramName="it" paramProperty="o.docposition" paramScope="page" alttext="label.externalrpos.view"/>
				</logic:equal>
			</td>
			<td class="number">
				<bean:write name="it" property="o.order" filter="true"/>
			</td>
			<td class="text">
				<bean:write name="it" property="o.resource.name" filter="true"/><logic:present name="it" property="o.resource.model">,<br><bean:write name="it" property="o.resource.model" filter="true"/></logic:present><logic:present name="it" property="o.configuration">,<br><bean:write name="it" property="o.configuration" filter="true"/></logic:present>
			</td>
			<td class="text">
				<july:numberwrite name="it" property="o.qty" />
			</td>
			<td class="text">
				<logic:present name="it" property="o.resource.unit">
					<bean:write name="it" property="o.resource.unit.shortname" filter="true"/>
				</logic:present>
			</td>
			<td class="text">
				<july:numberwrite name="it" property="o.price"/>
			</td>
			<td class="text">
				<july:numberwrite name="it" property="o.sum"/>
			</td>
			<td class="text">
				<bean:write name="it" property="serialnumber" filter="true"/>
			</td>
			<td class="link">
				<logic:equal name="ExternalRPositionListForm" property="readonly" value="false">
                    <logic:notPresent name="it" property="o.agregate">
					  <july:delbutton page="/EditExternalRPosition.do?action=Delete" paramId="docposition" paramName="it" paramProperty="o.docposition" paramScope="page" />
                    </logic:notPresent>
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
				<logic:equal name="ExternalRPositionListForm" property="readonly" value="false"><july:addbutton page="/EditExternalRPosition.do?action=Add" alttext="label.externalrpos.add"/></logic:equal>
				<logic:equal name="ExternalRPositionListForm" property="readonly" value="true">&nbsp;</logic:equal>
				<july:backbutton page="/ShowExternalRList.do"/></td>
			<TD class="navigator"><july:navigator/></td>
		</tr>
		</table>
	</td>
</tr>
        
<july:separator colspan="<%= gColSpan %>" />
      
<tr class="title">
	<td class="title" colspan="<%= gColSpan %>">
		<html:link page="/ShowExternalRList.do" styleClass="navigator"><bean:message key="label.externalr"/></html:link>
		<july:sepmark/> 
		<july:currmark><bean:message key="label.externalrpos"/></july:currmark>
	</td>
</tr>

</table>

</july:browseform>
