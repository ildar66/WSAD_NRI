<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "9"; %>

<july:browseform action="/ShowInternalRPositionList.do" styleId="InternalRPositionListForm">

<bean:define id="docCode" name="InternalRPositionListForm" property="document" scope="session" type="java.lang.Integer"/>
<july:inventorycalcerrors document="<%= docCode %>"/>

<table class="main">
<tr class="title">
	<td class="title" colspan="<%= gColSpan %>">
		<html:link page="/ShowInternalRList.do" styleClass="navigator"><bean:message key="label.internalr"/></html:link>
		<july:sepmark/> 
		<july:currmark><bean:message key="label.internalrpos"/></july:currmark>
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>" />

<TR class="normal">
 <TD colspan="<%= gColSpan %>">
    <table class="find">
	<tr>
		<td class="title"><bean:message key="label.internalrpos.document"/></td>
		<td class="title">
			<bean:message key="label.num"/>&nbsp;<bean:write name="InternalRPositionListForm" property="blankindex"/>&nbsp;<bean:write name="InternalRPositionListForm" property="blanknumber"/>&nbsp;<bean:message key="label.from"/>&nbsp;<bean:write name="InternalRPositionListForm" property="blankdatestr"/>
		</td>
	</tr>
	<tr>
		<td class="title"><bean:message key="label.internalrpos.owner"/></td>
		<td class="title">
			<bean:write name="InternalRPositionListForm" property="ownername"/>
		</td>
	</tr>
	<tr>
		<td class="title"><bean:message key="label.internalrpos.storage"/></td>
		<td class="title">
			<bean:write name="InternalRPositionListForm" property="storagename"/>
		</td>
	</tr>
<logic:present name="InternalRPositionListForm" property="type">
<logic:equal name="InternalRPositionListForm" property="type" value="P">
	<tr>
		<td class="title"><bean:message key="label.internalrpos.renter"/></td>
		<td class="title">
			<bean:write name="InternalRPositionListForm" property="rentername"/>
		</td>
	</tr>
	<tr>
		<td class="title"><bean:message key="label.internalrpos.insurance"/></td>
		<td class="title">
			<bean:write name="InternalRPositionListForm" property="insuranseMan"/>
		</td>
	</tr>
	<tr>
		<td class="title"><bean:message key="label.internalrpos.dov"/></td>
		<td class="title">
			<bean:message key="label.num"/>&nbsp;<bean:write name="InternalRPositionListForm" property="insuranceact"/>&nbsp;<bean:message key="label.from"/>&nbsp;<bean:write name="InternalRPositionListForm" property="insurancedatestr"/>
		</td>
	</tr>
</logic:equal>
<logic:equal name="InternalRPositionListForm" property="type" value="W">
	<tr>
		<td class="title"><bean:message key="label.internalrpos.worker"/></td>
		<td class="title">
			<bean:write name="InternalRPositionListForm" property="workername"/>
		</td>
	</tr>
</logic:equal>
</logic:present>
	<tr>
		<td class="title"><bean:message key="label.internalrpos.position"/></td>
		<td class="title">
			<bean:write name="InternalRPositionListForm" property="positionname"/>
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
				<logic:equal name="InternalRPositionListForm" property="readonly" value="false"><july:addbutton page="/EditInternalRPosition.do?action=Add" alttext="label.internalrpos.add" /></logic:equal>
				<logic:equal name="InternalRPositionListForm" property="readonly" value="false"><html:link page="/InternalRLoadExcel.do?action=Add" paramId="doc" paramName="InternalRPositionListForm" paramProperty="document" paramScope="session"><img src="/images/loadexcel.gif" border="0" alt="Загрузка данных из Excel"></html:link></logic:equal><IMG SRC="/images/empty.gif" BORDER='0' ALT='' WIDTH='3'>
				<july:backbutton page="/ShowInternalRList.do"/></td>
			<TD class="navigator"><july:navigator/></td>
		</tr>
		</table>
	</td>
</tr>
        
<july:separator colspan="<%= gColSpan %>" />

<!-- Table header -->
<tr class="title">
	<july:headercolumn key="label.void" colType="string"/>
	<july:headercolumn key="label.num" colType="number"/>
	<july:headercolumn key="label.internalrpos.name" colType="string"/>
	<july:headercolumn key="label.internalrpos.qty.short" colType="string"/>
	<july:headercolumn key="label.internalrpos.unit.short" colType="string"/>
	<july:headercolumn key="label.internalrpos.price" colType="string"/>
	<july:headercolumn key="label.internalrpos.sum" colType="string"/>
	<july:headercolumn key="label.internalrpos.serial" colType="string"/>
	<td class="title">&nbsp;</td>
</tr>

<july:separator colspan="<%= gColSpan %>" />

<!-- Table body -->
<logic:iterate id="it" name="browseList">
	<logic:present name="it">
		<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
			<td class="string">
				<logic:equal name="InternalRPositionListForm" property="readonly" value="false">
                    <logic:notPresent name="it" property="o.agregate">
					  <july:editbutton page="/EditInternalRPosition.do" action="Edit" paramId="docposition" paramName="it" paramProperty="o.docposition" paramScope="page" alttext="label.internalrpos.edit"/>
                    </logic:notPresent>
				</logic:equal>
				<logic:equal name="InternalRPositionListForm" property="readonly" value="true">
					<july:editbutton page="/EditInternalRPosition.do" action="View" paramId="docposition" paramName="it" paramProperty="o.docposition" paramScope="page" alttext="label.internalrpos.view"/>
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
				<bean:write name="it" property="o.price" filter="true"/>
			</td>
			<td class="text">
				<bean:write name="it" property="o.sum" filter="true"/>
			</td>
			<td class="text">
				<bean:write name="it" property="serialnumber" filter="true"/>
			</td>
			<td class="link">
				<logic:equal name="InternalRPositionListForm" property="readonly" value="false">
                    <logic:notPresent name="it" property="o.agregate">
					  <july:delbutton page="/EditInternalRPosition.do?action=Delete" paramId="docposition" paramName="it" paramProperty="o.docposition" paramScope="page" />
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
				<logic:equal name="InternalRPositionListForm" property="readonly" value="false"><july:addbutton page="/EditInternalRPosition.do?action=Add" alttext="label.internalrpos.add"/></logic:equal>
				<logic:equal name="InternalRPositionListForm" property="readonly" value="false"><html:link page="/InternalRLoadExcel.do?action=Add" paramId="doc" paramName="InternalRPositionListForm" paramProperty="document" paramScope="session"><img src="/images/loadexcel.gif" border="0" alt="Загрузка данных из Excel"></html:link></logic:equal><IMG SRC="/images/empty.gif" BORDER='0' ALT='' WIDTH='3'>
				<july:backbutton page="/ShowInternalRList.do"/></td>
			<TD class="navigator"><july:navigator/></td>
		</tr>
		</table>
	</td>
</tr>
        
<july:separator colspan="<%= gColSpan %>" />
      
<tr class="title">
	<td class="title" colspan="<%= gColSpan %>">
		<html:link page="/ShowInternalRList.do" styleClass="navigator"><bean:message key="label.internalr"/></html:link>
		<july:sepmark/> 
		<july:currmark><bean:message key="label.internalrpos"/></july:currmark>
	</td>
</tr>

</table>

</july:browseform>
