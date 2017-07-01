<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "3"; %>

<july:browseform action="/ShowEquipmentPLookupList.do" styleId="equipmentPLookupListForm">

<july:lookupresult tableId="brtable" resultCols="0;1;2"/>

<table class="main">
<TR class="title">
	<TD class="title">
		<bean:message key="label.choose.equipmentp"/>
	</TD>
</TR>
<TR class="normal">
 <TD>
     <table class="find">
    <TR>
        <td><bean:message key="label.equipmentp.restype"/></td>
        <td colspan="2" nowrap><july:string property="restype" styleId="restype" size="5" insertable="true" updatable="true" styleClass="editkodsearch"/>
          <july:lookupbutton action="/ShowRestypeLookupList.do" styleId="rtl" fieldNames="restype;restypename" newWindowName="restypelookup" insertable="true" updatable="true"/>
          <july:string size="30" property="restypename" styleId="restypename" insertable="false" updatable="false" /><july:searchbutton />
		  </td>
     </tr>        
    <TR>
        <td><bean:message key="label.equipmentp.ressbtype"/></td>
        <td colspan="2" nowrap><july:string property="ressbtype" styleId="ressbtype" size="5" insertable="true" updatable="true" styleClass="editkodsearch"/>
          <july:lookupbutton action="/ShowRessbtypeLookupList.do" styleId="rstl" fieldNames="ressbtype;ressbtypename" newWindowName="ressbtypelookup" onclick="set_opt_params_rstl('?resourcetype='+document.all.restype.value)" insertable="true" updatable="true"/>
          <july:string size="30" property="ressbtypename" styleId="ressbtypename" insertable="false" updatable="false" />
		  </td>
     </tr>        
    <tr>
		<td class="title"><bean:message key="label.equipmentp.position"/></td>
		<td class="title"><july:string property="position" styleId="position" size="5" insertable="true" updatable="true" styleClass="editkodsearch"/>
			<july:lookupbutton action="/ShowPositionLookupList.do" styleId="posl" fieldNames="position;positionid;positionname" newWindowName="poslookup" insertable="true" updatable="true" />
			<july:string size="10" property="positionid" styleId="positionid" insertable="false" updatable="false" />
			<july:string size="25" property="positionname" styleId="positionname" insertable="false" updatable="false" />
		</td>
	</tr>
    <tr>
        <td><bean:message key="label.equipmentp.policy.serial"/></td>
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
            <july:headercolumn key="label.equipmentp.code" colType="number"/>
            <july:headercolumn key="label.equipmentp.name" colType="string"/>
            <july:headercolumn key="label.equipmentp.spnum" colType="string"/>
        </tr>

        <!-- Table body -->
        <logic:iterate id="rtl" name="browseList" indexId="index">
	      <logic:present name="rtl">
            <tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
                <td class="number"><bean:write name="rtl" property="storagecard" filter="true"/></td>
                <td class="text"><july:lookupreturn>
				    <bean:write name="rtl" property="resource.name" filter="true"/><logic:present name="rtl" property="resource.model">,<br>
                    <bean:write name="rtl" property="resource.model" filter="true"/></logic:present><logic:present name="rtl" property="configuration">,<br>
                    <bean:write name="rtl" property="configuration" filter="true"/>
                    </logic:present>
                    </july:lookupreturn>
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
