<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "6"; %>

<july:browseform action="/ShowRepeaterResLookupList.do" styleId="resform">

<july:lookupresult tableId="brtable" resultCols="0;2;5;6;7"/>

<script language="javascript">
function switchLookup(itemname,lookupname,disabled) {
	if(disabled) {
		resform[itemname].className = 'editkodsearch';
		resform[itemname].disabled = false;
		resform[itemname].readonly = false;
		document.all['lookupbtn_'+lookupname+'l'].disabled = false;
		document.all['lookupimg_'+lookupname+'l'].src='/images/lookup.gif';
	} else {
		resform[itemname].className = 'editkoddisabled';
		resform[itemname].disabled = true;
		resform[itemname].readonly = true;
		document.all['lookupbtn_'+lookupname+'l'].disabled = true;
		document.all['lookupimg_'+lookupname+'l'].src='/images/lookup_disabled.gif';
	}
}
function switchItem(itemname,state) {
	if(state) {
		resform[itemname].disabled = false;
		resform[itemname].className = 'editsearch';
	} else {
		resform[itemname].disabled = true;
		resform[itemname].className = 'editdisabled';
	}
}

function switchResourcetype() {
	switchLookup('resourcetype','rt',resform.isResourcetype[0].checked);
	switchLookup('resourcesubtype','rst',resform.isResourcetype[0].checked);
}
function switchSign() {
	switchItem('sign',resform.isSign[0].checked);
}
function switchName() {
	switchItem('name',resform.isName[0].checked);
}
function switchManufacturer() {
	switchLookup('manufacturer','org',resform.isManufacturer[0].checked);
}
function switchManucode() {
	switchItem('manucode',resform.isManucode[0].checked);
}

</script>


<table class="main">
<TR class="title">
 <TD class="title">
    <bean:message key="label.choose.resource"/>
 </TD>
</TR>
<TR class="normal">
<td>
	<table class="find">
	<tr>
		<td class="title" nowrap rowspan="2">
			<july:checkbox property="isResourcetype" insertable="true" updatable="true" value="true" onclick="switchResourcetype();"/><html:hidden property="isResourcetype" value="false"/><bean:message key="label.resource.byclass"/>&nbsp;
		</td>
		<td class="title" nowrap align="right"><bean:message key="label.resource.type"/></td>
		<td class="title" nowrap colspan="1">
			<july:string property="resourcetype" styleId="resourcetype" size="5" insertable="true" updatable="true"  styleClass="editkodsearch"/>
			<july:lookupbutton action="/ShowRestypeLookupList.do" styleId="rtl" fieldNames="resourcetype;resourcetypename" newWindowName="restypelookup" insertable="true" updatable="true"/>
			<july:string size="25" property="resourcetypename" styleId="resourcetypename" insertable="false" updatable="false"/>&nbsp;<july:searchbutton/>
		</td>
	</tr>        
	<tr>
		<td class="title" nowrap align="right"><bean:message key="label.resource.subtype"/></td>
		<td class="title" nowrap colspan="1">
			<july:string property="resourcesubtype" styleId="resourcesubtype" size="5" insertable="true" updatable="true" styleClass="editkodsearch"/>
			<july:lookupbutton action="/ShowRessbtypeLookupList.do" styleId="rstl" fieldNames="resourcesubtype;resourcesubtypename" newWindowName="ressbtypelookup" onclick="set_opt_params_rstl('?resourcetype='+document.all.resourcetype.value)" insertable="true" updatable="true"/>
			<july:string size="25" property="resourcesubtypename" styleId="resourcesubtypename" insertable="false" updatable="false"/>
		</td>
	</tr>
	<tr>
		<td class="title" nowrap>
			<july:checkbox property="isSign" insertable="true" updatable="true" value="true" onclick="switchSign();"/><html:hidden property="isSign" value="false"/><bean:message key="label.resource.bysign"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		</td>
		<td class="title" nowrap colspan="2"><july:string size="40" property="sign" styleId="sign" insertable="true" updatable="true"  styleClass="search"/></td>
	</tr>
	<tr>
		<td class="title" nowrap>
			<july:checkbox property="isName" insertable="true" updatable="true" value="true" onclick="switchName();"/><html:hidden property="isName" value="false"/><bean:message key="label.resource.byname"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		</td>
		<td class="title" nowrap colspan="2"><july:string size="40" property="name" styleId="name" insertable="true" updatable="true" styleClass="search"/></td>
	</tr>
	<tr>
		<td class="title" nowrap>
			<july:checkbox property="isManufacturer" insertable="true" updatable="true" value="true" onclick="switchManufacturer();"/><html:hidden property="isManufacturer" value="false"/><bean:message key="label.resource.bymanufacturer"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		</td>
		<td class="title" nowrap colspan="2">
			<july:string property="manufacturer" styleId="manufacturer" size="5" insertable="true" updatable="true" styleClass="editkodsearch"/>
			<july:lookupbutton action="/ShowOrganizationLookupList.do" styleId="orgl" fieldNames="manufacturer;manufacturername" newWindowName="orglookup" insertable="true" updatable="true"/>
			<july:string size="25" property="manufacturername" styleId="manufacturername" insertable="false" updatable="false"/>
		</td>
	</tr>
	<tr>
		<td class="title" nowrap>
			<july:checkbox property="isManucode" insertable="true" updatable="true" value="true" onclick="switchManucode();"/><html:hidden property="isManucode" value="false"/><bean:message key="label.resource.bymanucode"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		</td>
		<td class="title" nowrap colspan="2"><july:string size="40" property="manucode" styleId="manucode" insertable="true" updatable="true" styleClass="search"/></td>
	</tr>
<script language="javascript">
switchResourcetype();
switchName();
switchSign();
switchManufacturer();
switchManucode();
</script>
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

<tr>
  <td>
    <table class="main" id="brtable">

        <!-- Table header -->
        <tr class="title">
	        <july:headercolumn key="label.resource.code" colType="number"/>
			<july:headercolumn key="label.resource.model" colType="string"/>
	        <july:headercolumn key="label.resource.name" colType="string"/>
	        <july:headercolumn key="label.resource.manucode" colType="string"/>
			<july:headercolumn key="label.resource.unit.short" colType="string"/>
	        <july:headercolumn key="repeaterlist.reppower" colType="string"/>
			<td style="visibility:hidden;display:none;">&nbsp;</td>
			<td style="visibility:hidden;display:none;">&nbsp;</td>
        </tr>

        <!-- Table body -->
        <logic:iterate id="rstl" name="browseList" indexId="index">
	      <logic:present name="rstl">
            <tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
                <td class="number"><bean:write name="rstl" property="resource" filter="true"/></td>
                <td class="text"><july:lookupreturn><bean:write name="rstl" property="model" filter="true"/></july:lookupreturn></td>
                <td class="text"><bean:write name="rstl" property="name" filter="true"/></td>
                <td class="text"><bean:write name="rstl" property="manucode" filter="true"/></td>
                <td class="text"><logic:present name="rstl" property="unit"><bean:write name="rstl" property="unit.shortname" filter="true"/></logic:present></td>
                <td class="text"><bean:write name="rstl" property="reppower" filter="true"/></td>
				<td style="visibility:hidden;display:none;"><bean:write name="rstl" property="numchanals" filter="true"/></td>
				<td style="visibility:hidden;display:none;"><bean:write name="rstl" property="bandwidth" filter="true"/></td>
            </tr>
	      </logic:present>
          
	      <logic:notPresent name="rstl">
            <tr class="normal">
                <td class="text" colspan="<%= gColSpan %>">
                   <bean:message key="label.norecords"/>
                </td>
            </tr>
	      </logic:notPresent>
          
          <july:separator colspan="<%= gColSpan %>"/>
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
