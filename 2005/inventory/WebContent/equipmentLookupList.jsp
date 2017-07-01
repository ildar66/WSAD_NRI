<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "4"; %>

<july:browseform action="/ShowEquipmentLookupList.do" styleId="equipmentLookupListForm">

<july:lookupresult tableId="brtable" resultCols="0;1;3;2"/>

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
    <TR>
        <td><bean:message key="label.equipment.storage"/></td>
        <td colspan="2" nowrap>
			<july:select collection="storages" property="storage" insertable="true" updatable="false" styleClass="search" style="width:400;">
				<html:options collection="storages" property="storageplace" labelProperty="name"/>
			</july:select>
		  </td>
     </tr>        
    <TR>
        <td><bean:message key="label.equipment.policy.serial"/></td>
		<td colspan="2" nowrap>
			<july:string size="15" property="serialnum" insertable="true" updatable="true" styleClass="search" />
		</td>
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
            <july:headercolumn key="label.equipment.config" colType="string"/>
            <july:headercolumn key="label.equipment.spnum" colType="string"/>
        </tr>

        <!-- Table body -->
        <logic:iterate id="rtl" name="browseList" indexId="index">
	      <logic:present name="rtl">
            <tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
                <td class="number"><bean:write name="rtl" property="storagecard" filter="true"/></td>
                <td class="text"><july:lookupreturn>
				    <bean:write name="rtl" property="resource.name" filter="true"/><logic:present name="rtl" property="resource.model">,<br>
                    <bean:write name="rtl" property="resource.model" filter="true"/></logic:present>
                    </july:lookupreturn>
                </td>
		<td class="text">
			<logic:present name="rtl" property="configuration">
				<bean:write name="rtl" property="configuration" filter="true"/>
			</logic:present>
		</td>
                <td class="text"><bean:write name="rtl" property="serialnumber" filter="true"/></td>
            </tr>
	      </logic:present>
          
	      <logic:notPresent name="rtl">
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
