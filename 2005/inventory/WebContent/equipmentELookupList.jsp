<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "3"; %>

<july:browseform action="/ShowEquipmentELookupList.do" styleId="EquipmentELookupListForm">

<july:lookupresult tableId="brtable" resultCols="0;1;2"/>

<script language="javascript">
function switchLookup(itemname,lookupname,disabled) {
	if(disabled) {
		EquipmentELookupListForm[itemname].className = 'editkoddisabled';
		EquipmentELookupListForm[itemname].disabled = true;
		EquipmentELookupListForm[itemname].readonly = true;
		document.all['lookupbtn_'+lookupname+'l'].disabled = true;
		document.all['lookupimg_'+lookupname+'l'].src='/images/lookup_disabled.gif';
	} else {
		EquipmentELookupListForm[itemname].className = 'editkodsearch';
		EquipmentELookupListForm[itemname].disabled = false;
		EquipmentELookupListForm[itemname].readonly = false;
		document.all['lookupbtn_'+lookupname+'l'].disabled = false;
		document.all['lookupimg_'+lookupname+'l'].src='/images/lookup.gif';
	}
}

function switchFilter() {
	if(EquipmentELookupListForm.type[0].checked) {
		switchLookup('organization','rent',true);
		switchLookup('worker','work',true);
		EquipmentELookupListForm['organizationname'].disabled = true;
		EquipmentELookupListForm['workername'].disabled = true;
		EquipmentELookupListForm['workertitle'].disabled = true;
	} else if(EquipmentELookupListForm.type[1].checked) {
		switchLookup('organization','rent',false);
		switchLookup('worker','work',true);
		EquipmentELookupListForm['organizationname'].disabled = false;
		EquipmentELookupListForm['workername'].disabled = true;
		EquipmentELookupListForm['workertitle'].disabled = true;
	} else if(EquipmentELookupListForm.type[2].checked) {
		switchLookup('organization','rent',true);
		switchLookup('worker','work',false);
		EquipmentELookupListForm['organizationname'].disabled = true;
		EquipmentELookupListForm['workername'].disabled = false;
		EquipmentELookupListForm['workertitle'].disabled = false;
	} else {
		switchLookup('organization','rent',false);
		switchLookup('worker','work',false);
		EquipmentELookupListForm['organizationname'].disabled = false;
		EquipmentELookupListForm['workername'].disabled = false;
		EquipmentELookupListForm['workertitle'].disabled = false;
	}
}
</script>

<table class="main">
<TR class="title">
	<TD class="title">
		<bean:message key="label.choose.equipmente"/>
	</TD>
</TR>
<TR class="normal">
 <TD>
     <table class="find">
    <TR>
        <td><bean:message key="label.equipmente.restype"/></td>
        <td colspan="2" nowrap><july:string property="restype" styleId="restype" size="5" insertable="true" updatable="true" styleClass="editkodsearch"/>
          <july:lookupbutton action="/ShowRestypeLookupList.do" styleId="rtl" fieldNames="restype;restypename" newWindowName="restypelookup" insertable="true" updatable="true"/>
          <july:string size="30" property="restypename" styleId="restypename" insertable="false" updatable="false" /><july:searchbutton />
		  </td>
     </tr>
    <TR>
        <td><bean:message key="label.equipmente.ressbtype"/></td>
        <td colspan="2" nowrap><july:string property="ressbtype" styleId="ressbtype" size="5" insertable="true" updatable="true" styleClass="editkodsearch"/>
          <july:lookupbutton action="/ShowRessbtypeLookupList.do" styleId="rstl" fieldNames="ressbtype;ressbtypename" newWindowName="ressbtypelookup" onclick="set_opt_params_rstl('?resourcetype='+document.all.restype.value)" insertable="true" updatable="true"/>
          <july:string size="30" property="ressbtypename" styleId="ressbtypename" insertable="false" updatable="false" />
		  </td>
     </tr>
	<tr>
		<td class="title"><bean:message key="label.equipmente.type"/></td>
		<td class="title" colspan="2">
			<july:radio insertable="true" updatable="true" property="type" value="A" onclick="switchFilter();"/><bean:message key="label.all"/>
			<july:radio insertable="true" updatable="true" property="type" value="P" onclick="switchFilter();"/><bean:message key="label.acttype.forp"/>
			<july:radio insertable="true" updatable="true" property="type" value="W" onclick="switchFilter();"/><bean:message key="label.acttype.forw"/>
		</td>
	</tr>
    <tr>
		<td class="title"><bean:message key="label.equipmente.organization"/></td>
		<td class="title" colspan="2">
			<july:string property="organization" styleId="organization" size="5" insertable="true" updatable="true" styleClass="editkodsearch"/>
			<july:lookupbutton action="/ShowOrganizationLookupList.do" styleId="rentl" fieldNames="organization;organizationname" newWindowName="organizationlookup"  insertable="true" updatable="true" onclick="set_opt_params_rentl('?selisprovider=false&selisrenter=true&selissupplier=false');"/>
			<july:string size="35" property="organizationname" styleId="organizationname" insertable="false" updatable="false" />
		</td>
    </tr>
    <tr>
		<td class="title"><bean:message key="label.equipmente.worker"/></td>
		<td class="title" colspan="2">
			<july:string property="worker" styleId="worker" size="5" insertable="true" updatable="true"  styleClass="editkodsearch" />
			<july:lookupbutton action="/ShowWorkerLookupList.do" styleId="workl" fieldNames="worker;workername;workertitle" newWindowName="workerlookup" insertable="true" updatable="true" />
			<july:string size="20" property="workername" styleId="workername" insertable="false" updatable="false" />
			<july:string size="20" property="workertitle" styleId="workertitle" insertable="false" updatable="false" />
		</td>
    </tr>
    <TR>
        <td><bean:message key="label.equipmente.policy.serial"/></td>
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
            <july:headercolumn key="label.equipmente.code" colType="number"/>
            <july:headercolumn key="label.equipmente.name" colType="string"/>
            <july:headercolumn key="label.equipmente.spnum" colType="string"/>
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

<script language="javascript">switchFilter();</script>
</july:browseform>
