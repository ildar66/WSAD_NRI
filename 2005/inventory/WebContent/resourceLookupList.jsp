<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<%@ page import="com.hps.july.cdbc.lib.*"%>

<% java.lang.String gColSpan = "7"; %>

<july:browseform action="/ShowResourceLookupList.do" styleId="resform">

<script language="javascript">
function switchLookup(itemname,lookupname,disabled) {
	if(disabled) {
		ResourceLookupListForm[itemname].className = 'editkodsearch';
		ResourceLookupListForm[itemname].disabled = false;
		ResourceLookupListForm[itemname].readonly = false;
		document.all['lookupbtn_'+lookupname+'l'].disabled = false;
		document.all['lookupimg_'+lookupname+'l'].src='/images/lookup.gif';
	} else {
		ResourceLookupListForm[itemname].className = 'editkoddisabled';
		ResourceLookupListForm[itemname].disabled = true;
		ResourceLookupListForm[itemname].readonly = true;
		document.all['lookupbtn_'+lookupname+'l'].disabled = true;
		document.all['lookupimg_'+lookupname+'l'].src='/images/lookup_disabled.gif';
	}
}
function switchItem(itemname,state) {
	if(state) {
		ResourceLookupListForm[itemname].disabled = false;
		ResourceLookupListForm[itemname].className = 'editsearch';
	} else {
		ResourceLookupListForm[itemname].disabled = true;
		ResourceLookupListForm[itemname].className = 'editdisabled';
	}
}

function switchResourcetype() {
	switchLookup('resourcetype','rt',ResourceLookupListForm.isResourcetype[0].checked);
	switchLookup('resourcesubtype','rst',ResourceLookupListForm.isResourcetype[0].checked);
}
function switchSign() {
	switchItem('sign',ResourceLookupListForm.isSign[0].checked);
}
function switchName() {
	switchItem('name',ResourceLookupListForm.isName[0].checked);
}
function switchManufid() {
	switchLookup('manufid','org',ResourceLookupListForm.isManufid[0].checked);
}
function switchManucode() {
	switchItem('manucode',ResourceLookupListForm.isManucode[0].checked);
}
function switchNfsCode() {
	switchItem('nfscode',ResourceLookupListForm.isNfscode[0].checked);
}

function clearResSubType() {
	document.all.resourcesubtype.value = '';
	document.all.resourcesubtypename.value = '';
}

</script>

<july:lookupresult tableId="brtable" resultCols="0;2;3;7;6;"/>

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
			<july:string property="resourcetype" styleId="resourcetype" size="5" insertable="true" updatable="true" styleClass="editkodsearch" onchange="clearResSubType();"/>
			<july:lookupbutton action="/ShowRestypeLookupList.do" styleId="rtl" fieldNames="resourcetype;resourcetypename" newWindowName="restypelookup" insertable="true" updatable="true" onselect="clearResSubType();"/>
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
	<tr>
		<td class="title" nowrap>
			<july:checkbox property="isManufid" insertable="true" updatable="true" value="true" onclick="switchManufid();"/><html:hidden property="isManufid" value="false"/><bean:message key="label.resource.bymanufacturer"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		</td>
		<td class="title" nowrap colspan="2">
			<july:string property="manufid" styleId="manufid" size="5" insertable="true" updatable="true" styleClass="editkodsearch" />
			<july:lookupbutton action="/../dict/ShowEquipmanufLookupList.do" styleId="orgl" fieldNames="manufid;manufacturername" newWindowName="orglookup" insertable="true" updatable="true" onclick="set_opt_params_orgl('?selisprovider=false&selisrenter=false&selissupplier=false');"/>
			<july:string size="25" property="manufacturername" styleId="manufacturername" insertable="false" updatable="false" />
		</td>
	</tr>
	<tr>
		<td class="title" nowrap>
			<july:checkbox property="isManucode" insertable="true" updatable="true" value="true" onclick="switchManucode();"/><html:hidden property="isManucode" value="false"/><bean:message key="label.resource.bymanucode"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		</td>
		<td class="title" nowrap colspan="2"><july:string size="40" property="manucode" styleId="manucode" insertable="true" updatable="true" styleClass="search" /></td>
	</tr>
	<tr>
		<td class="title" nowrap>
			<july:checkbox property="isNfscode" insertable="true" updatable="true" value="true" onclick="switchNfsCode();"/><html:hidden property="isNfscode" value="false"/><bean:message key="label.resource.nfscode"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		</td>
		<td class="title" nowrap colspan="2"><july:string size="40" property="nfscode" styleId="nfscode" insertable="true" updatable="true" styleClass="search" /></td>
	</tr>
<script language="javascript">
switchResourcetype();
switchName();
switchSign();
switchManufid();
switchManucode();
switchNfsCode();
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
		<july:headercolumn key="label.resource.nfscodes" colType="string"/>
		<july:headercolumn key="label.resource.model" colType="string"/>
		<july:headercolumn key="label.resource.name" colType="string"/>
		<july:headercolumn key="label.resource.manucode" colType="string"/>
		<july:headercolumn key="label.resource.unit.short" colType="string"/>
		<july:headercolumn key="label.resource.countpolicy" colType="string"/>
		<%--july:headercolumn key="label.resource.oldcodes" colType="string"/--%>
		<td class="title" style="visibility:hidden;display:none;"><bean:message key="label.void"/></td>
        </tr>

        <!-- Table body -->
<%
	CDBCRowObject ro = null;
%>
        <logic:iterate id="rstl" name="browseList" indexId="index">
	      <logic:present name="rstl">
<%
	ro = (CDBCRowObject)rstl;
%>
            <tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
                <td class="number"><july:stringwrite name="rstl" property="resource"/></td>
                <td class="text"><july:stringwrite name="rstl" property="nfslist"/></td>
                <td class="text"><july:lookupreturn><july:stringwrite name="rstl" property="model"/></july:lookupreturn></td>
                <td class="text"><july:stringwrite name="rstl" property="name"/></td>
                <td class="text"><july:stringwrite name="rstl" property="manucode"/></td>
                <td class="text"><july:stringwrite name="rstl" property="shortname"/></td>
                <td class="text"><%
			if(ro.getColumn("countpolicy") != null) {
				String s = ro.getColumn("countpolicy").asString();
				if(s != null) {
					%><bean:message key='<%="label.resource.countpolicy" + s.toLowerCase()%>'/><%
				}
			}

		%></td>
		<td class="text" style="visibility:hidden;display:none;"><july:stringwrite name="rstl" property="name"/> <july:stringwrite name="rstl" property="model"/></td>
            </tr>
<%
	ro = null;
%>
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