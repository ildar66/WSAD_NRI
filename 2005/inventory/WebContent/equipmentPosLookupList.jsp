<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "5"; %>

<july:browseform action="/ShowEquipmentPosLookupList.do" styleId="equipmentPosLookupListForm">

<july:lookupresult tableId="brtable" resultCols="0;1"/>

<table class="main">
<TR class="title">
	<TD class="title">
		<bean:message key="label.choose.equipment"/>
	</TD>
</TR>
<TR class="normal">
 <TD>
     <table class="find">
    <TR>
        <td><bean:message key="label.equipment.restype"/></td>
        <td colspan="2" nowrap><july:string property="restype" styleId="restype" size="5" insertable="true" updatable="true" styleClass="editkodsearch"/>
          <july:lookupbutton action="/ShowRestypeLookupList.do" styleId="rtl" fieldNames="restype;restypename" newWindowName="restypelookup" insertable="true" updatable="true"/>
          <july:string size="30" property="restypename" styleId="restypename" insertable="false" updatable="false" /><july:searchbutton />
		  </td>
     </tr>        
    <TR>
        <td><bean:message key="label.equipment.ressbtype"/></td>
        <td colspan="2" nowrap><july:string property="ressbtype" styleId="ressbtype" size="5" insertable="true" updatable="true" styleClass="editkodsearch"/>
          <july:lookupbutton action="/ShowRessbtypeLookupList.do" styleId="rstl" fieldNames="ressbtype;ressbtypename" newWindowName="ressbtypelookup" onclick="set_opt_params_rstl('?resourcetype='+document.all.restype.value)" insertable="true" updatable="true"/>
          <july:string size="30" property="ressbtypename" styleId="ressbtypename" insertable="false" updatable="false" />
		  </td>
     </tr>        
    <tr>
       <td><bean:message key="label.inventory.position"/></td>
       <td colspan="2" nowrap><july:string property="position" styleId="position" size="5" insertable="true" updatable="true" styleClass="editkodsearch"/>
			<july:lookupbutton action="/ShowPositionLookupList.do" styleId="posl" fieldNames="position;positionname" insertable="true" updatable="true"/>
			<july:string size="35" property="positionname" styleId="positionname" insertable="false" updatable="false" /></td>
    </tr>        
    <tr>
       <td><bean:message key="label.inventory.complect"/></td>
       <td colspan="2" nowrap><july:string property="complect" styleId="complect" size="5" insertable="true" updatable="true" styleClass="editkodsearch"/>
			<july:lookupbutton action="/ShowComplectLookupList.do" styleId="coml" fieldNames="complect;complectname" insertable="true" updatable="true" onclick="set_opt_params_coml('?position='+document.all.position.value)"/>
			<july:string size="35" property="complectname" styleId="complectname" insertable="false" updatable="false" /></td>
    </tr>
    <TR>
        <td><bean:message key="label.equipment.policy.serial"/></td>
		<td colspan="2" nowrap><july:string size="15" property="serialnum" insertable="true" updatable="true" styleClass="editkodsearch"/></td>
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
            <july:headercolumn key="label.equipment.code" colType="number"/>
            <july:headercolumn key="label.equipment.name" colType="string"/>
            <july:headercolumn key="label.equipment.spnum" colType="string"/>
        </tr>

        <!-- Table body -->
        <logic:iterate id="rtl" name="browseList" indexId="index">
	      <logic:present name="rtl">
            <tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
                <td class="number"><july:lookupreturn><bean:write name="rtl" property="resource.resource" filter="true"/></july:lookupreturn></td>
                <td class="text">
                    <bean:write name="rtl" property="resource.name" filter="true"/>
                </td>
                <td class="text">
                    <bean:write name="rtl" property="serialnumber" filter="true"/>
                </td>
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
</TABLE>

</july:browseform>
