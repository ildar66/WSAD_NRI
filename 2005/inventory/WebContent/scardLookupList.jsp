<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<july:browseform action="/ShowCardSLookupList.do" styleId="scardform">

<%	String gColSpan = "9"; %>

<july:lookupresult tableId="brtable" resultCols="2;1"/>

<table class="main">
<tr class="title">
	<td class="title">
		<bean:message key="label.choose.scard"/>
	</td>
</tr>

<tr class="normal">
	<td>
	<table class="find">
	<logic:present name="CardSLookupListForm" property="storagetype">
	<tr>
		<logic:equal name="CardSLookupListForm" property="storagetype" value="S">
        	<td class="title"><bean:message key="label.card.storage"/></td>
		</logic:equal>
		<logic:equal name="CardSLookupListForm" property="storagetype" value="E">
		<td class="title"><bean:message key="label.card.expedition"/></td>
		</logic:equal>
		<logic:equal name="CardSLookupListForm" property="storagetype" value="P">
		<td class="title"><bean:message key="label.card.position"/></td>
		</logic:equal>
		<logic:equal name="CardSLookupListForm" property="storagetype" value="Q">
		<td class="title"><bean:message key="label.card.equipment"/></td>
		</logic:equal>
		<td colspan="2" class="title"><bean:write name="CardSLookupListForm" property="storagename" filter="true" /></td>
	</tr>
	</logic:present>
	<logic:notPresent name="CardSLookupListForm" property="storagetype">
	<tr>
        	<td class="title"><bean:message key="label.card.place"/></td>
		<td colspan="2" class="title"><bean:write name="CardSLookupListForm" property="storagename" filter="true" /></td>
	</tr>
	</logic:notPresent>
	<tr>
		<td class="title"><bean:message key="label.scard.resource"/></td>
		<td colspan="2" class="title">
			<logic:present name="CardSLookupListForm" property="resource">
			<bean:write name="CardSLookupListForm" property="resourcemodel" filter="true" />
			</logic:present>
			<logic:notPresent name="CardSLookupListForm" property="resource">
			<bean:message key="error.empty.scard.resource" />
			</logic:notPresent>
		</td>
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
		<july:headercolumn key="label.scard.model" colType="string"/>
		<july:headercolumn key="label.scard.configuration" colType="string"/>
		<july:headercolumn key="label.scard.serial" colType="string"/>
		<july:headercolumn key="label.scard.owner" colType="string"/>
		<july:headercolumn key="label.scard.state" colType="string"/>
	</tr>
	<!-- Table body -->
	<logic:iterate id="rstl" name="browseList" indexId="index">
		<logic:present name="rstl">
		<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
			<td class="text"><july:lookupreturn><bean:write name="rstl" property="resource.model" filter="true"/></july:lookupreturn></td>
			<td class="text"><bean:write name="rstl" property="configuration" filter="true"/></td>
			<td class="text"><bean:write name="rstl" property="serialnumber" filter="true"/></td>
			<td class="text"><bean:write name="rstl" property="owner.name" filter="true"/></td>
			<td class="text">
				<logic:equal name="rstl" property="broken" value="Y">
					<bean:message key="label.scard.state.broken" />
				</logic:equal>
				<logic:notEqual name="rstl" property="broken" value="Y">
					<bean:message key="label.scard.state.normal" />
				</logic:notEqual>
			</td>

		</tr>
		</logic:present>
          
		<logic:notPresent name="rstl">
		<tr class="normal">
			<td class="text" colspan="<%= gColSpan %>"><bean:message key="label.norecords"/></td>
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
