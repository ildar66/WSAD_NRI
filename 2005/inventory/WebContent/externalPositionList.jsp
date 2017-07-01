<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "12"; %>

<july:browseform action="/ShowExternalPositionList.do">

<bean:define id="docCode" name="ExternalPositionListForm" property="document" scope="session" type="java.lang.Integer"/>
<july:inventorycalcerrors document="<%= docCode %>"/>

<table class="main">
<tr class="title">
	<td class="title" colspan="<%= gColSpan %>">
		<html:link page="/ShowExternalList.do" styleClass="navigator"><bean:message key="label.external"/></html:link> 
		<july:sepmark/> 
		<july:currmark><bean:message key="label.externalpos"/></july:currmark>
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>" />

<tr class="normal">
 <td colspan="<%= gColSpan %>">
 
    <table class="find">
    <tr>
		<td class="title"><bean:message key="label.externalpos.owner"/></td>
		<td class="title"><bean:write name="ExternalPositionListForm" property="ownername"/></td>
	</tr>
    <tr>
		<td class="title"><bean:message key="label.externalpos.storage"/></td>
		<td class="title"><bean:write name="ExternalPositionListForm" property="storagename"/></td>
	</tr>
    <tr>
		<td class="title"><bean:message key="label.externalpos.document"/></td>
		<td class="title"><bean:message key="label.num"/>&nbsp;<bean:write name="ExternalPositionListForm" property="blankindex"/>&nbsp;<bean:write name="ExternalPositionListForm" property="blanknumber"/>&nbsp;<bean:message key="label.from" />&nbsp;<bean:write name="ExternalPositionListForm" property="blankdatestr"/></td>
	</tr>
    <tr>
		<td class="title"><bean:message key="label.externalpos.account"/></td>
		<td class="title"><logic:present name="ExternalPositionListForm" property="cordocnum"><bean:message key="label.num"/>&nbsp;<bean:write name="ExternalPositionListForm" property="cordocnum"/>&nbsp;<bean:message key="label.from" />&nbsp;<bean:write name="ExternalPositionListForm" property="cordocdatestr"/></logic:present></td>
	</tr>
    <tr>
		<td class="title"><bean:message key="label.externalpos.gtd"/></td>
		<td class="title"><logic:present name="ExternalPositionListForm" property="gtdnumber"><bean:message key="label.num"/>&nbsp;<bean:write name="ExternalPositionListForm" property="gtdnumber"/>&nbsp;<bean:message key="label.from" />&nbsp;<bean:write name="ExternalPositionListForm" property="gtddatestr"/></logic:present></td>
	</tr>
    <tr>
		<td class="title"><bean:message key="label.externalpos.supplier"/></td>
		<td class="title"><bean:write name="ExternalPositionListForm" property="suppliername"/></td>
	</tr>
    <tr>
		<td class="title"><bean:message key="label.externalpos.sum"/></td>
		<td class="title"><bean:write name="ExternalPositionListForm" property="bydocsum"/> / <bean:write name="ExternalPositionListForm" property="byfactsum"/>&nbsp;<bean:write name="ExternalPositionListForm" property="currencyshortname" filter="true"/></td>
	</tr>
    </table>
    
  </td>
</tr>

<july:separator colspan="<%= gColSpan %>" />

	<tr class="title">
		<td colspan="<%= gColSpan %>">
			<table class="buttons">
			<tr class="title">
				<TD class="buttons">
					<logic:equal name="ExternalPositionListForm" property="readonly" value="false">
						<july:addbutton page="/EditExternalPosition.do?action=Add" alttext="label.externalpos.add"/>
					</logic:equal>
					<logic:equal name="ExternalPositionListForm" property="readonly" value="false"><html:link page="/ExternalLoadExcel.do?action=Add" paramId="doc" paramName="ExternalPositionListForm" paramProperty="document" paramScope="session"><img src="/images/loadexcel.gif" border="0" alt="Загрузка данных из Excel"></html:link></logic:equal><IMG SRC="/images/empty.gif" BORDER='0' ALT='' WIDTH='3'>
					<july:backbutton page="/ShowExternalList.do"/>
				</td>
				<TD class="navigator"><july:navigator/></td>
			</tr>
			</table>
		</td>
	</tr>

<july:separator colspan="<%= gColSpan %>" />

	<!-- Table header -->
	<tr class="title">
		<july:headercolumn key="label.void" colType="string"/>
		<july:headercolumn key="label.externalpos.num" colType="number"/>
		<july:headercolumn key="label.externalpos.name" colType="string"/>
		<july:headercolumn key="label.externalpos.unit" colType="string"/>
		<july:headercolumn key="label.externalpos.doc.cnt.short" colType="number"/>
		<july:headercolumn key="label.externalpos.fact.cnt.short" colType="number"/>
		<july:headercolumn key="label.externalpos.doc.price.short" colType="number"/>
		<july:headercolumn key="label.externalpos.fact.price.short" colType="number"/>
		<july:headercolumn key="label.externalpos.doc.sum.short" colType="number"/>
		<july:headercolumn key="label.externalpos.fact.sum.short" colType="number"/>
		<july:headercolumn key="label.externalpos.serial" colType="string"/>
		<td class="title">&nbsp;</td>
	</tr>

<july:separator colspan="<%= gColSpan %>" />
    
	<!-- Table body -->
	<logic:iterate id="it" name="browseList">
	<logic:present name="it">
		<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
			<td class="text">
				<logic:equal name="ExternalPositionListForm" property="readonly" value="false">
					<july:editbutton page="/EditExternalPosition.do" action="Edit" paramId="outerDocPosition" paramName="it" paramProperty="o.outerDocPosition" paramScope="page" alttext="label.externalpos.edit"/>
				</logic:equal>
				<logic:equal name="ExternalPositionListForm" property="readonly" value="true">
					<july:editbutton page="/EditExternalPosition.do" action="View" paramId="outerDocPosition" paramName="it" paramProperty="o.outerDocPosition" paramScope="page" alttext="label.externalpos.view"/>
				</logic:equal>
			</td>
			<td class="text">
				<bean:write name="it" property="order" filter="true"/>
			</td>
			<td class="text">
				<bean:write name="it" property="o.resource.name" filter="true"/><logic:present name="it" property="o.resource.model">;<br><bean:write name="it" property="o.resource.model" filter="true"/></logic:present><logic:present name="it" property="o.configuration">;<br><bean:write name="it" property="o.configuration" filter="true"/></logic:present>
			</td>
			<td class="text">
				<logic:present name="it" property="o.resource.unit">
					<bean:write name="it" property="o.resource.unit.shortname" filter="true"/>
				</logic:present>
			</td>
			<td class="text">
				<july:numberwrite name="it" property="o.outerQty" />
			</td>
			<td class="text">
				<july:numberwrite name="it" property="qty" />
			</td>
			<td class="text">
				<bean:write name="it" property="o.outerPrice" filter="true"/>
			</td>
			<td class="text">
				<logic:equal name="ExternalPositionListForm" property="readonly" value="true">
					<logic:notEqual name="it" property="o.resource.countpolicy" value="B">
					<html:link page="/EditExternalPosition.do?action=Edit" paramId="outerDocPosition" paramName="it" paramProperty="o.outerDocPosition" paramScope="page">
						<logic:present name="it" property="price">
						<bean:write name="it" property="price" filter="true"/>
						</logic:present>
						<logic:notPresent name="it" property="price">
						<bean:message key="label.create"/>
						</logic:notPresent>
					</html:link>
					</logic:notEqual>
					<logic:equal name="it" property="o.resource.countpolicy" value="B">
						<bean:write name="it" property="price" filter="true"/>
					</logic:equal>
				</logic:equal>
				<logic:equal name="ExternalPositionListForm" property="readonly" value="false">
					<bean:write name="it" property="price" filter="true"/>
				</logic:equal>
			</td>
			<td class="text">
				<july:numberwrite name="it" property="outerSum"/>
			</td>
			<td class="text">
				<july:numberwrite name="it" property="sum"/>
			</td>
			<td class="link">
				<logic:equal name="it" property="o.resource.countpolicy" value="S">
				<html:link page="/ShowExternalSerialList.do" paramId="outerDocPosition" paramName="it" paramProperty="o.outerDocPosition" paramScope="page">
					<bean:message key="label.externalpos.serial" />
				</html:link>
				</logic:equal>
			</td>
			<td class="link">
				<logic:equal name="ExternalPositionListForm" property="readonly" value="false">
					<july:delbutton page="/EditExternalPosition.do?action=Delete" paramId="outerDocPosition" paramName="it" paramProperty="o.outerDocPosition" paramScope="page"/>
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
				<logic:equal name="ExternalPositionListForm" property="readonly" value="false">
					<july:addbutton page="/EditExternalPosition.do?action=Add" alttext="label.externalpos.add" />
				</logic:equal>
				<logic:equal name="ExternalPositionListForm" property="readonly" value="false"><html:link page="/ExternalLoadExcel.do?action=Add" paramId="doc" paramName="ExternalPositionListForm" paramProperty="document" paramScope="session"><img src="/images/loadexcel.gif" border="0" alt="Загрузка данных из Excel"></html:link></logic:equal><IMG SRC="/images/empty.gif" BORDER='0' ALT='' WIDTH='3'>
				<july:backbutton page="/ShowExternalList.do"/>
			</td>
			<TD class="navigator"><july:navigator/></td>
		</tr>
		</table>
	</td>
</tr>
      
<july:separator colspan="<%= gColSpan %>" />
      
<tr class="title">
	<td class="title" colspan="<%= gColSpan %>">
		<html:link page="/ShowExternalList.do" styleClass="navigator"><bean:message key="label.external"/></html:link> 
		<july:sepmark/> 
		<july:currmark><bean:message key="label.externalpos"/></july:currmark>
	</td>
</tr>

</table>

</july:browseform>
