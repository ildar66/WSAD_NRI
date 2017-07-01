<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "9"; %>

<july:browseform action="/ShowResourceSetLookupList.do" styleId="ressetform">

<july:lookupresult tableId="brtable" resultCols="0;1;2;3;4"/>

<script language="javascript">
function switchLookup(itemname,lookupname,disabled) {
	if(disabled) {
		ResourceSetLookupListForm[itemname].className = 'editkodsearch';
		ResourceSetLookupListForm[itemname].disabled = false;
		ResourceSetLookupListForm[itemname].readonly = false;
		document.all['lookupbtn_'+lookupname+'l'].disabled = false;
		document.all['lookupimg_'+lookupname+'l'].src='/images/lookup.gif';
	} else {
		ResourceSetLookupListForm[itemname].className = 'editkoddisabled';
		ResourceSetLookupListForm[itemname].disabled = true;
		ResourceSetLookupListForm[itemname].readonly = true;
		document.all['lookupbtn_'+lookupname+'l'].disabled = true;
		document.all['lookupimg_'+lookupname+'l'].src='/images/lookup_disabled.gif';
	}
}
function switchItem(itemname,state) {
	if(state) {
		ResourceSetLookupListForm[itemname].disabled = false;
		ResourceSetLookupListForm[itemname].className = 'editsearch';
	} else {
		ResourceSetLookupListForm[itemname].disabled = true;
		ResourceSetLookupListForm[itemname].className = 'editdisabled';
	}
}

function switchResourcetype() {
	switchLookup('resourcetype','rt',ResourceSetLookupListForm.isResourcetype[0].checked);
	switchLookup('resourcesubtype','rst',ResourceSetLookupListForm.isResourcetype[0].checked);
}
function switchSign() {
	switchItem('sign',ResourceSetLookupListForm.isSign[0].checked);
}
function switchName() {
	switchItem('name',ResourceSetLookupListForm.isName[0].checked);
}
</script>

<table class="main">
<TR class="title">
 <TD class="title">
    <bean:message key="label.choose.resourceset"/>
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
			<july:string size="25" property="resourcetypename" styleId="resourcetypename" insertable="false" updatable="false" />&nbsp;<july:searchbutton />
		</td>
	</tr>        
	<tr>
		<td class="title" nowrap align="right"><bean:message key="label.resource.subtype"/></td>
		<td class="title" nowrap colspan="1">
			<july:string property="resourcesubtype" styleId="resourcesubtype" size="5" insertable="true" updatable="true" styleClass="editkodsearch" />
			<july:lookupbutton action="/ShowRessbtypeLookupList.do" styleId="rstl" fieldNames="resourcesubtype;resourcesubtypename" newWindowName="ressbtypelookup" onclick="set_opt_params_rstl('?resourcetype='+document.all.resourcetype.value)" insertable="true" updatable="true"/>
			<july:string size="25" property="resourcesubtypename" styleId="resourcesubtypename" insertable="false" updatable="false" />
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
		<td class="title" nowrap colspan="2"><july:string size="40" property="name" styleId="name" insertable="true" updatable="true" styleClass="search" /></td>
	</tr>
<script language="javascript">
switchResourcetype();
switchName();
switchSign();
</script>
<%--
	<tr>
		<td class="title" nowrap colspan="2"><july:radio insertable="true" updatable="true" property="searchtype" value="C"/><bean:message key="label.resource.byclass"/>&nbsp;<july:searchbutton /></td>
	</tr>
    <tr>
        <td class="title" nowrap align="right"><bean:message key="label.restype"/></td>
		<td class="title" nowrap>
			<july:string property="resourcetype" styleId="resourcetype" size="5" insertable="true" updatable="true" styleClass="editkodsearch" />
			<july:lookupbutton action="/ShowRestypeLookupList.do" styleId="rtl" fieldNames="resourcetype;resourcetypename" newWindowName="restypelookup" insertable="true" updatable="true"/>
			<july:string size="25" property="resourcetypename" styleId="resourcetypename" insertable="false" updatable="false" />
		</td>
    </tr>        
    <tr>
		<td class="title" nowrap align="right"><bean:message key="label.subtype"/></td>
		<td class="title" nowrap>
			<july:string property="resourcesubtype" styleId="resourcesubtype" size="5" insertable="true" updatable="true"  styleClass="editkodsearch"/>
			<july:lookupbutton action="/ShowRessbtypeLookupList.do" styleId="rstl" fieldNames="resourcesubtype;resourcesubtypename" newWindowName="ressbtypelookup" onclick="set_opt_params_rstl('?resourcetype='+document.all.resourcetype.value)" insertable="true" updatable="true"/>
			<july:string size="25" property="resourcesubtypename" styleId="resourcesubtypename" insertable="false" updatable="false" />
		</td>
    </tr>
	<tr>
		<td class="title" nowrap><july:radio insertable="true" updatable="true" property="searchtype" value="S"/><bean:message key="label.resource.bysign"/></td>
		<td class="title" nowrap><july:string size="40" property="sign" styleId="sign" insertable="true" updatable="true"  styleClass="editkodsearch"/></td>
	</tr>
	<tr>
		<td class="title" nowrap><july:radio insertable="true" updatable="true" property="searchtype" value="N"/><bean:message key="label.resource.byname"/></td>
		<td class="title" nowrap><july:string size="40" property="name" styleId="name" insertable="true" updatable="true"  styleClass="editkodsearch"/></td>
	</tr>
--%>
    </table>
  </td>
</tr>

<tr class="title">
  <td><table class="buttons">
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
        <july:headercolumn key="label.resourceset.code" colType="number"/>
		<july:headercolumn key="label.resourceset.name" colType="string"/>
        <july:headercolumn key="label.resourceset.code" colType="number"/>
        <july:headercolumn key="label.resourceset.resmodel" colType="string"/>
		<july:headercolumn key="label.resourceset.resname" colType="string"/>
		<july:headercolumn key="label.resourceset.unit.short" colType="string"/>
        <july:headercolumn key="label.resourceset.countpolicy" colType="string"/>
        </tr>

        <!-- Table body -->
        <logic:iterate id="rstl" name="browseList" indexId="index">
	      <logic:present name="rstl">
            <tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
                <td class="number"><bean:write name="rstl" property="resourceset" filter="true"/></td>
                <td class="text"><july:lookupreturn><bean:write name="rstl" property="name" filter="true"/></july:lookupreturn></td>
                <td class="text"><bean:write name="rstl" property="mainpart.resource" filter="true"/></td>
                <td class="text"><bean:write name="rstl" property="mainpart.model" filter="true"/></td>
                <td class="text"><bean:write name="rstl" property="mainpart.name" filter="true"/></td>
                <td class="text"><logic:present name="rstl" property="mainpart.unit"><bean:write name="rstl" property="mainpart.unit.shortname" filter="true"/></logic:present></td>
                <td class="text">
					<logic:equal name="rstl" property="mainpart.countpolicy" value="S"><bean:message key="label.resource.countpolicys"/></logic:equal>
					<logic:equal name="rstl" property="mainpart.countpolicy" value="P"><bean:message key="label.resource.countpolicyp"/></logic:equal>
					<logic:equal name="rstl" property="mainpart.countpolicy" value="B"><bean:message key="label.resource.countpolicyb"/></logic:equal>
				</td>
            </tr>

            <july:separator colspan="<%= gColSpan %>" />

	      </logic:present>
        </logic:iterate>
    
    </table>
</TD>
</TR>

<tr class="title">
  <td><table class="buttons">
    <tr class="title">
      <td class="buttons"><july:closebutton page="/"/></TD>
      <td class="navigator"><july:navigator/></TD>
    </tr>
    </table>
  </td>
</tr>

</TABLE>
    
</july:browseform>
