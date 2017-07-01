<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "5"; %>

<july:browseform action="/ShowWorkerLookupList.do" styleId="WorkerLookupListForm">

<logic:present name="WorkerLookupListForm" property="showdivision">
	<logic:equal name="WorkerLookupListForm" property="showdivision" value="true">
		<july:lookupresult tableId="brtable" resultCols="0;1;2;3;4"/>
	</logic:equal>
	<logic:equal name="WorkerLookupListForm" property="showdivision" value="false">
		<july:lookupresult tableId="brtable" resultCols="0;1;2"/>
	</logic:equal>
</logic:present>
<logic:notPresent name="WorkerLookupListForm" property="showdivision">
	<july:lookupresult tableId="brtable" resultCols="0;1;2"/>
</logic:notPresent>

<table class="main">

<tr class="title">
	<td class="title"><bean:message key="label.choose.worker"/></td>
</tr>

<tr class="normal">
	<td>
	<table class="find">
	<tr>
		<td><bean:message key="label.people.lastname"/></td>
		<td><html:text styleClass="search" property="lastname" size="25" /><july:searchbutton /></td>
	</tr>        
	</table>
	</td>
</tr>

<tr class="title">
	<td>
	<table class="buttons">
	<tr class="title">
		<td class="buttons"><july:closebutton page="/"/></TD>
		<td class="navigator"><july:navigator/></TD>
	</tr>
	</table>
	</td>
</tr>

<tr>
	<td>
	<table class="main" id="brtable">

        <!-- Table header -->
        <tr class="title">
		<td style="display:none;visibility:hidden;">code</td>
		<july:headercolumn key="label.workerlookup.fullname" colType="string"/>
		<july:headercolumn key="label.workerlookup.position" colType="string"/>
		<td style="display:none;visibility:hidden;">code</td>
		<july:headercolumn key="label.workerlookup.division" colType="string"/>
        </tr>

        <!-- Table body -->
	<logic:iterate id="wrk" name="browseList" indexId="index">
	<logic:present name="wrk">
		<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
			<td style="display:none;visibility:hidden;"><july:stringwrite name="wrk" property="worker"/></td>
			<td class="text"><july:lookupreturn><july:stringwrite name="wrk" property="fullname"/></july:lookupreturn></td>
			<td class="text"><july:stringwrite name="wrk" property="wpname"/></td>
			<td style="display:none;visibility:hidden;"><july:stringwrite name="wrk" property="division"/></td>
			<td><july:stringwrite name="wrk" property="divisionname"/></td>
		</tr>
	</logic:present>
	<logic:notPresent name="wrk">
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
  <td><TABLE class="buttons">
    <TR class="title">
      <TD class="buttons"><july:closebutton page="/"/></TD>
      <TD class="navigator"><july:navigator/></TD>
    </TR>
    </TABLE></TD>
</tr>

</TABLE>
    
</july:browseform>
