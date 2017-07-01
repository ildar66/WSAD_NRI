<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld"    prefix="alex" %>
<%@ page import="org.apache.struts.util.*,com.hps.july.basestation.valueobject.*,com.hps.july.basestation.formbean.*"%>

<script language="javascript">
function switchLookup(itemname,lookupname,disabled) {
//alert("itemname="+itemname+"lookupname="+lookupname+" disabled="+disabled);
if(!disabled) {
		AntennaListForm[itemname].className = 'editkodsearch';
		AntennaListForm[itemname].disabled = false;
		//ResourceLookupListForm[itemname].readonly = false;
		AntennaListForm[itemname].readonly = false;

        document.all['lookupbtn_'+lookupname+'l'].disabled = false;
		document.all['lookupimg_'+lookupname+'l'].src='/images/lookup.gif';
	} else {
		AntennaListForm[itemname].className = 'editkoddisabled';
		AntennaListForm[itemname].disabled = true;
		AntennaListForm[itemname].readonly = true;
		document.all['lookupbtn_'+lookupname+'l'].disabled = true;
		document.all['lookupimg_'+lookupname+'l'].src='/images/lookup_disabled.gif';
	}
}
function switchItem(itemname,state) {
	if(state) {
		AntennaListForm[itemname].disabled = false;
		AntennaListForm[itemname].className = 'editsearch';
	} else {
		AntennaListForm[itemname].disabled = true;
		AntennaListForm[itemname].className = 'editdisabled';
	}
}

function switchResourcetype() {
	switchLookup('resourcetype','rt',AntennaListForm.isResourcetype.checked);
}
function switchResourcesubtype() {
	switchLookup('resourcesubtype','rst',AntennaListForm.isResourcesubtype.checked);
}
function switchSearch() {
	if(AntennaListForm.searchby[0].checked) {
		AntennaListForm.searchstring.disabled = true;
		AntennaListForm.searchstring.className = 'editdisabled';
	} else {
		AntennaListForm.searchstring.disabled = false;
		AntennaListForm.searchstring.className = 'editsearch';
	}
}
function switchRanges() {

	var cc = AntennaListForm.allranges[0].checked;
    //alert("switchRanges checked="+cc);
	var sty;
	if(cc) { sty = '#DCDCDC'; } else { sty = '#D6EBFF'; }
	for(i = 0; i < 4; i++) {
		AntennaListForm['ranges['+i+']'][0].disabled = cc;
		AntennaListForm['ranges['+i+']'][0].style.backgroundColor = sty;
	}
}
</script>


<tr class='normal'>
<td>
<table class='find'>

<tr>
 <td class="title" nowrap ><bean:message bundle="dictionaryResources" key="label.restype"/></td>
 <td class="title" nowrap >
	<july:checkbox property="isAllResourcetypes" styleId="isResourcetype"  insertable="true" updatable="true"
    onclick="switchResourcetype();"/>
    <bean:message bundle="dictionaryResources" key="label.all"/>
    &nbsp;
    <july:string property="resourcetypeFrm" styleId="resourcetype" size="5" insertable="false" updatable="false"  styleClass="editkodsearch"/>
	<july:lookupbutton action="/ShowRestypeLookupList.do" styleId="rtl"
      fieldNames="resourcetype;resourcetypename" newWindowName="restypelookup" insertable="true" updatable="true"/>
	<july:string size="25" property="resourcetypename" styleId="resourcetypename" insertable="false" updatable="false" />
    &nbsp;<july:searchbutton />
 </td>
</tr>

<tr>
 <td class="title" nowrap ><bean:message bundle="dictionaryResources" key="label.restype.subtype"/></td>
 <td class="title" nowrap >
	<july:checkbox property="isAllResourcesubtypes" styleId="isResourcesubtype" insertable="true" updatable="true"
    onclick="switchResourcesubtype();"/>
    <bean:message bundle="dictionaryResources" key="label.all"/>
    &nbsp;
    <july:string property="resourcesubtypeFrm" styleId="resourcesubtype" size="5" insertable="true" updatable="true" styleClass="editkodsearch" />
	<july:lookupbutton action="/ShowRessbtypeLookupList.do" styleId="rstl"
     fieldNames="resourcesubtype;resourcesubtypename" newWindowName="ressbtypelookup"
     onclick="set_opt_params_rstl('?resourcetype='+document.all.resourcetype.value)"
     insertable="true" updatable="true"/>
	<july:string size="25" property="resourcesubtypename" styleId="resourcesubtypename" insertable="false" updatable="false" />

 </td>
</tr>
<script>
switchResourcesubtype();
switchResourcetype();
</script>

<tr>
		<td class="title"><bean:message bundle="dictionaryResources" key="label.antena.searchby"/></td>
		<td class="title">
			<july:radio property="searchby" insertable="true" updatable="true" value="0" onclick="switchSearch();"/><bean:message bundle="dictionaryResources" key="label.all"/>
			<july:radio property="searchby" insertable="true" updatable="true" value="1" onclick="switchSearch();"/><bean:message bundle="dictionaryResources" key="label.antena.searchby.model"/>&nbsp;
			<july:radio property="searchby" insertable="true" updatable="true" value="2" onclick="switchSearch();"/><bean:message bundle="dictionaryResources" key="label.antena.searchby.manufacturer"/>
			<july:string property="searchstring" insertable="true" updatable="true" styleId="searchstring" styleClass="search" size="25" />
		</td>
	</tr>
	<tr>
		<td class="title"><bean:message bundle="dictionaryResources" key="label.antena.range"/></td>
		<td class="title">
			<july:checkbox styleClass="text" property="allranges" insertable="true" updatable="true" onclick="switchRanges();"/>&nbsp;<bean:message bundle="dictionaryResources" key="label.all"/>&nbsp;&nbsp;&nbsp;
			<july:checkbox styleClass="text" property="ranges[0]" insertable="true" updatable="true" />&nbsp;800&nbsp;&nbsp;&nbsp;
			<july:checkbox styleClass="text" property="ranges[1]" insertable="true" updatable="true" />&nbsp;900&nbsp;&nbsp;&nbsp;
			<july:checkbox styleClass="text" property="ranges[2]" insertable="true" updatable="true" />&nbsp;1800&nbsp;&nbsp;&nbsp;
			<july:checkbox styleClass="text" property="ranges[3]" insertable="true" updatable="true" />&nbsp;2000&nbsp;&nbsp;&nbsp;
		</td>
<script language="javascript">
switchRanges();
</script>
    </tr>
	<tr>
		<td class="title"><bean:message bundle="dictionaryResources" key="label.antena.polar"/></td>
		<td class="title">
	   		<july:select styleClass="search" style="width:128px;" collection="polars" property="polar" insertable="true" updatable="true">
				<html:options name="polars"/>
			</july:select>
		</td>
	</tr>

</table>

  </TD>
</TR>
</table>
</td>
</tr>

<script language="javascript">
switchSearch();
switchRanges();
</script>
