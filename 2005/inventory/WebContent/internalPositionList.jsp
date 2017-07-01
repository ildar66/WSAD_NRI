<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "10"; %>

<july:browseform action="/ShowInternalPositionList.do" styleId="InternalPositionListForm">

<bean:define id="docCode" name="InternalPositionListForm" property="document" scope="session" type="java.lang.Integer"/>
<july:inventorycalcerrors document="<%= docCode %>"/>

<table class="main">
<%--<tr class="title">
	<td class="title" colspan="<%= gColSpan %>">
		<html:link page="/ShowInternalList.do" styleClass="navigator"><bean:message key="label.internal"/></html:link>
		<july:sepmark/> 
		<july:currmark><bean:message key="label.internalpos"/></july:currmark>
	</td>
</tr>--%>

<july:separator colspan="<%= gColSpan %>" />

<TR class="normal">
 <TD colspan="<%= gColSpan %>">
    <table class="find">
	<tr>
		<td class="title"><bean:message key="label.internalpos.document"/></td>
		<td class="title">
			<bean:message key="label.num"/>&nbsp;<bean:write name="InternalPositionListForm" property="blankindex"/>&nbsp;<bean:write name="InternalPositionListForm" property="blanknumber"/>&nbsp;<bean:message key="label.from"/>&nbsp;<bean:write name="InternalPositionListForm" property="blankdatestr"/>
		</td>
	</tr>
	<tr>
		<td class="title"><bean:message key="label.internalpos.owner"/></td>
		<td class="title">
			<bean:write name="InternalPositionListForm" property="ownername"/>
		</td>
	</tr>
	<tr>
		<td class="title"><bean:message key="label.internalpos.storage"/></td>
		<td class="title">
			<bean:write name="InternalPositionListForm" property="storagename"/>
		</td>
	</tr>
	<tr>
		<td class="title"><bean:message key="label.internalpos.position"/></td>
		<td class="title">
			<bean:write name="InternalPositionListForm" property="positionname"/>
		</td>
	</tr>
<logic:equal name="InternalPositionListForm" property="type" value="P">
	<tr>
		<td class="title"><bean:message key="label.internalpos.renter"/></td>
		<td class="title">
			<bean:write name="InternalPositionListForm" property="rentername"/>
		</td>
	</tr>
	<tr>
		<td class="title"><bean:message key="label.internalpos.insurance"/></td>
		<td class="title">
			<bean:write name="InternalPositionListForm" property="insuranseMan"/>
		</td>
	</tr>
</logic:equal>
<logic:equal name="InternalPositionListForm" property="type" value="W">
	<tr>
		<td class="title"><bean:message key="label.internalpos.worker"/></td>
		<td class="title">
			<bean:write name="InternalPositionListForm" property="workername"/>
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
				<logic:equal name="InternalPositionListForm" property="readonly" value="false"><july:addbutton page="/EditInternalPosition.do?action=Add" alttext="label.internalpos.add"/></logic:equal>
				<logic:equal name="InternalPositionListForm" property="readonly" value="false"><html:link page="/InternalLoadExcel.do?action=Add" paramId="doc" paramName="InternalPositionListForm" paramProperty="document" paramScope="session"><img src="/images/loadexcel.gif" border="0" alt="Загрузка данных из Excel"></html:link></logic:equal><IMG SRC="/images/empty.gif" BORDER='0' ALT='' WIDTH='3'>
				<july:backbutton page="/ShowInternalList.do"/></td>
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
	<july:headercolumn key="label.internalpos.name" colType="string"/>
	<july:headercolumn key="label.internalpos.docqty.short" colType="string"/>
	<july:headercolumn key="label.internalpos.qty.short" colType="string"/>
	<july:headercolumn key="label.internalpos.unit.short" colType="string"/>
	<july:headercolumn key="label.internalpos.price" colType="string"/>
	<july:headercolumn key="label.internalpos.sum" colType="string"/>
	<july:headercolumn key="label.internalpos.serial" colType="string"/>
	<td class="title">&nbsp;</td>
</tr>

<july:separator colspan="<%= gColSpan %>" />

<!-- Table body -->
<logic:iterate id="it" name="browseList">
	<logic:present name="it">
		<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
			<td class="string">
				<logic:equal name="InternalPositionListForm" property="readonly" value="false">
                    <logic:notPresent name="it" property="o.agregate">
					  <july:editbutton page="/EditInternalPosition.do" action="Edit" paramId="docposition" paramName="it" paramProperty="o.docposition" paramScope="page" alttext="label.internalpos.edit"/>
                    </logic:notPresent>
				</logic:equal>
				<logic:equal name="InternalPositionListForm" property="readonly" value="true">
					<july:editbutton page="/EditInternalPosition.do" action="View" paramId="docposition" paramName="it" paramProperty="o.docposition" paramScope="page" alttext="label.internalpos.view"/>
				</logic:equal>
			</td>
			<td class="number">
				<bean:write name="it" property="o.order" filter="true"/>
			</td>
			<td class="text">
				<bean:write name="it" property="o.resource.name" filter="true"/><logic:present name="it" property="o.resource.model">,<br><bean:write name="it" property="o.resource.model" filter="true"/></logic:present><logic:present name="it" property="o.configuration">,<br><bean:write name="it" property="o.configuration" filter="true"/></logic:present>
			</td>
			<td class="text">
				<july:numberwrite name="it" property="o.docQty" />
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
				<logic:equal name="InternalPositionListForm" property="readonly" value="false">
                    <logic:notPresent name="it" property="o.agregate">
					  <july:delbutton page="/EditInternalPosition.do?action=Delete" paramId="docposition" paramName="it" paramProperty="o.docposition" paramScope="page" />
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
				<logic:equal name="InternalPositionListForm" property="readonly" value="false"><july:addbutton page="/EditInternalPosition.do?action=Add" alttext="label.internalpos.add"/></logic:equal>
				<logic:equal name="InternalPositionListForm" property="readonly" value="false"><html:link page="/InternalLoadExcel.do?action=Add" paramId="doc" paramName="InternalPositionListForm" paramProperty="document" paramScope="session"><img src="/images/loadexcel.gif" border="0" alt="Загрузка данных из Excel"></html:link></logic:equal><IMG SRC="/images/empty.gif" BORDER='0' ALT='' WIDTH='3'>
				<july:backbutton page="/ShowInternalList.do"/></td>
			<TD class="navigator"><july:navigator/></td>
		</tr>
		</table>
	</td>
</tr>
        
<july:separator colspan="<%= gColSpan %>" />
      
<tr class="title">
	<td class="title" colspan="<%= gColSpan %>">
		<html:link page="/ShowInternalList.do" styleClass="navigator"><bean:message key="label.internal"/></html:link>
		<july:sepmark/> 
		<july:currmark><bean:message key="label.internalpos"/></july:currmark>
	</td>
</tr>

</table>

</july:browseform>
