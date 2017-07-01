<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "3"; %>

<july:browseform action="/ShowPartyCardsLookupList.do" styleId="partycardsform">

<july:lookupresult tableId="brtable" resultCols="0"/>

<table class="main">
<tr class="title">
 <td class="title">
    <bean:message key="label.choose.partynumber"/>
 </td>
</tr>
<TR class="normal">
 <TD>
     <table class="find">
<logic:present name="PartyCardsLookupListForm" property="type">
    <TR>
		<logic:equal name="PartyCardsLookupListForm" property="type" value="S">
        <td class="title"><bean:message key="label.party.storage"/></td>
		</logic:equal>
		<logic:equal name="PartyCardsLookupListForm" property="type" value="E">
        <td class="title"><bean:message key="label.party.expedition"/></td>
		</logic:equal>
		<logic:equal name="PartyCardsLookupListForm" property="type" value="P">
        <td class="title"><bean:message key="label.party.position"/></td>
		</logic:equal>
		<logic:equal name="PartyCardsLookupListForm" property="type" value="Q">
        <td class="title"><bean:message key="label.party.equipment"/></td>
		</logic:equal>
        <td colspan="2" class="title"><bean:write name="PartyCardsLookupListForm" property="storagename" filter="true" /></td>
     </tr>
</logic:present>
    <TR>
        <td class="title"><bean:message key="label.party.resource"/></td>
        <td colspan="2" class="title"><bean:write name="PartyCardsLookupListForm" property="resourcemodel" filter="true" />&nbsp;<bean:write name="PartyCardsLookupListForm" property="resourcename" filter="true" /></td>
     </tr>        
     </table>
  </TD>
</TR>

<tr class="title">
  <td><TABLE class="buttons">
    <TR class="title">
      <TD class="buttons"><july:closebutton page="/"/></TD>
      <TD class="navigator"><july:navigator/></TD>
    </TR>
    </TABLE></TD>
</tr>

<TR>
  <TD>
    <table class="main" id="brtable">
        <!-- Table header -->
		<tr class="title">
			<july:headercolumn key="label.party.serial" colType="string"/>
			<july:headercolumn key="label.party.model" colType="string"/>
			<july:headercolumn key="label.party.name" colType="string"/>
		</tr>

		<!-- Table body -->
		<logic:iterate id="rstl" name="browseList" indexId="index">
			<logic:present name="rstl">
			<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
				<td class="text"><july:lookupreturn><bean:write name="rstl" property="party" filter="true"/></july:lookupreturn></td>
				<td class="text"><bean:write name="rstl" property="resource.model" filter="true"/></td>
				<td class="text"><bean:write name="rstl" property="resource.name" filter="true"/></td>
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
</TD>
</TR>

<tr class="title">
  <td><TABLE class="buttons">
    <TR class="title">
      <TD class="buttons"><july:closebutton page="/"/></TD>
      <TD class="navigator"><july:navigator/></TD>
    </TR>
    </TABLE></TD>
</tr>

</TABLE>
    
</july:browseform>
