<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "3"; %>

<july:browseform action="/ShowSerialCardsLookupList.do" styleId="serialcardsform">

<july:lookupresult tableId="brtable" resultCols="0"/>

<table class="main">
<tr class="title">
 <td class="title">
    <bean:message key="label.choose.serialnumber"/>
 </td>
</tr>
<TR class="normal">
 <TD>
     <table class="find">
<logic:present name="SerialCardsLookupListForm" property="type">
    <TR>
		<logic:equal name="SerialCardsLookupListForm" property="type" value="S">
        <td class="title"><bean:message key="label.serialnumber.storage"/></td>
		</logic:equal>
		<logic:equal name="SerialCardsLookupListForm" property="type" value="E">
        <td class="title"><bean:message key="label.serialnumber.expedition"/></td>
		</logic:equal>
		<logic:equal name="SerialCardsLookupListForm" property="type" value="P">
        <td class="title"><bean:message key="label.serialnumber.position"/></td>
		</logic:equal>
		<logic:equal name="SerialCardsLookupListForm" property="type" value="Q">
        <td class="title"><bean:message key="label.serialnumber.equipment"/></td>
		</logic:equal>
        <td colspan="2" class="title"><bean:write name="SerialCardsLookupListForm" property="storagename" filter="true" /></td>
     </tr>
</logic:present>
    <TR>
        <td class="title"><bean:message key="label.serialnumber.resource"/></td>
        <td colspan="2" class="title"><bean:write name="SerialCardsLookupListForm" property="resourcemodel" filter="true" />&nbsp;<bean:write name="SerialCardsLookupListForm" property="resourcename" filter="true" /></td>
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
			<july:headercolumn key="label.serialnumber.model" colType="string"/>
			<july:headercolumn key="label.serialnumber.name" colType="string"/>
			<july:headercolumn key="label.serialnumber.serial" colType="string"/>
			<july:headercolumn key="label.serialnumber.owner" colType="string"/>
			<july:headercolumn key="label.serialnumber.state" colType="string"/>
		</tr>

		<!-- Table body -->
		<logic:iterate id="rstl" name="browseList" indexId="index">
			<logic:present name="rstl">
			<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
				<td class="text"><bean:write name="rstl" property="resource.model" filter="true"/></td>
				<td class="text"><bean:write name="rstl" property="resource.name" filter="true"/></td>
				<td class="text"><july:lookupreturn><bean:write name="rstl" property="serialnumber" filter="true"/></july:lookupreturn></td>
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
