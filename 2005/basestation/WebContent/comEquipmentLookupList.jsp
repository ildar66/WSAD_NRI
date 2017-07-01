<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "4"; %>

<july:browseform action="/ShowComEquipmentLookupList.do">

<july:lookupresult tableId="brtable" resultCols="0;1;3;4"/>

<table class="main">
<tr class="title">
	<td class="title"><bean:message key="label.choose.comequ"/></td>
</tr>
<tr class="normal">
	<TD><table class="find">
	<tr>
		<td class="title"><bean:message key="label.comequ.position"/></td>
		<td class="title"><bean:write name="ComEquipmentLookupListForm" property="posid" filter="true" />&nbsp;&nbsp;&nbsp;<bean:write name="ComEquipmentLookupListForm" property="positionname" /></td>
	</tr>
	</table></TD>
</tr>
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
		<td style="display:none;visibility:hidden;"><bean:message key="label.code"/></td>
		<td style="display:none;visibility:hidden;">Resource code</td>
		<july:headercolumn key="label.equipment.comequipmenttype" colType="string"/>
		<july:headercolumn key="label.comequ.model" colType="string"/>
		<july:headercolumn key="label.comequ.name" colType="string"/>
        </tr>

        <!-- Table body -->
        <logic:iterate id="equ" name="browseList" indexId="index">
	      <logic:present name="equ">
	<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
		<td class="number" style="display:none;visibility:hidden;"><bean:write name="equ" property="storageplace" filter="true"/></td>
                <td class="number" style="display:none;visibility:hidden;"><logic:present name="equ" property="resource"><bean:write name="equ" property="resource.resource" filter="true"/></logic:present></td>
		<td class="text">
			<logic:present name="equ" property="comEquipmentType">
				<logic:equal name="equ" property="comEquipmentType" value="R">
					<bean:message key="label.equipment.comequipmenttype.radio"/>
				</logic:equal>
				<logic:equal name="equ" property="comEquipmentType" value="O">
					<bean:message key="label.equipment.comequipmenttype.optic"/>
				</logic:equal>
				<logic:equal name="equ" property="comEquipmentType" value="A">
					<bean:message key="label.equipment.comequipmenttype.other"/>
				</logic:equal>
			</logic:present>
		</td>
		<td class="text"><logic:present name="equ" property="resource"><bean:write name="equ" property="resource.model" filter="true" /></logic:present></td>
		<td class="text"><july:lookupreturn><bean:write name="equ" property="name" filter="true"/></july:lookupreturn></td>
        </tr>
	</logic:present>

			<logic:notPresent name="equ">
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
