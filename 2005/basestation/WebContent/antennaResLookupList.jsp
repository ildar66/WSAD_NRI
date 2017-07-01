<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld"    prefix="alex" %><%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import="org.apache.struts.util.*,com.hps.july.basestation.valueobject.*,com.hps.july.basestation.formbean.*"%>
<% java.lang.String gColSpan = "9"; %>

<%
	if(application.getAttribute("dictionaryResources") == null) {
		application.setAttribute("dictionaryResources",MessageResources.getMessageResources("com.hps.july.basestation.DictionaryResources"));
	}
%>

<july:browseform action="/ShowAntennaResLookupList.do" styleId="AntennaListForm">

<july:lookupresult tableId="br_table" resultCols="0;7;3;8;9;10;11"/>

<table class="main">

<tr class="title">
	<td class="title"><bean:message bundle="dictionaryResources" key="label.choose.antenna"/></td>
</tr>

<script language="javascript">
function switchLookup(itemname,lookupname,disabled) {
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
		<july:checkbox property="isAllResourcetypes" styleId="isResourcetype"  insertable="true" updatable="true" onclick="switchResourcetype();"/>
		<bean:message bundle="dictionaryResources" key="label.all"/>
		&nbsp;
		<july:string property="resourcetypeFrm" styleId="resourcetype" size="5" insertable="false" updatable="false"  styleClass="editkodsearch"/>
		<july:lookupbutton action="/ShowRestypeLookupList.do" styleId="rtl" fieldNames="resourcetype;resourcetypename" newWindowName="restypelookup" insertable="true" updatable="true"/>
		<july:string size="25" property="resourcetypename" styleId="resourcetypename" insertable="false" updatable="false" />
		&nbsp;
		<july:searchbutton />
	</td>
</tr>

<tr>
	<td class="title" nowrap ><bean:message bundle="dictionaryResources" key="label.restype.subtype"/></td>
	<td class="title" nowrap >
		<july:checkbox property="isAllResourcesubtypes" styleId="isResourcesubtype" insertable="true" updatable="true" onclick="switchResourcesubtype();"/>
		<bean:message bundle="dictionaryResources" key="label.all"/>
		&nbsp;
		<july:string property="resourcesubtypeFrm" styleId="resourcesubtype" size="5" insertable="true" updatable="true" styleClass="editkodsearch" />
		<july:lookupbutton action="/ShowRessbtypeLookupList.do" styleId="rstl" fieldNames="resourcesubtype;resourcesubtypename" newWindowName="ressbtypelookup" onclick="set_opt_params_rstl('?resourcetype='+document.all.resourcetype.value)" insertable="true" updatable="true"/>
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

<tr class="title">
	<td><TABLE class="buttons"><TR class="title">
		<TD class="buttons"><july:closebutton page="/"/></TD>
		<TD class="navigator"><july:navigator/></TD>
	</TR></TABLE></TD>
</tr>


<TR><TD><table class="main" id="br_table">
<tr class="title">
	<july:headercolumn bundle="dictionaryResources" key="label.code" colType="number"/>
	<july:headercolumn bundle="dictionaryResources" key="label.antena.model" colType="string"/>
	<july:headercolumn bundle="dictionaryResources" key="label.antena.manufacturer" colType="string"/>
	<july:headercolumn bundle="dictionaryResources" key="label.antena.range" colType="string"/>
	<july:headercolumn bundle="dictionaryResources" key="label.antena.polar" colType="string"/>
	<july:headercolumn bundle="dictionaryResources" key="label.antena.dir" colType="string"/>
	<july:headercolumn bundle="dictionaryResources" key="label.antena.amplify" colType="string"/>
	<td style='visibility:hidden;display:none;'></td>

	<td style='visibility:hidden;display:none;'></td>
	<td style='visibility:hidden;display:none;'></td>
	<td style='visibility:hidden;display:none;'></td>
	<td style='visibility:hidden;display:none;'></td>
</tr>

<logic:iterate id="it" name="browseList" indexId="index">
<logic:present name="it">
<%--
	AntenaValue ant=(AntenaValue)pageContext.findAttribute("it");
--%>
	<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
		<td class="number"><bean:write name="it" property="o.resource" filter="true"/></td>
		<td class="text"><july:lookupreturn><bean:write name="it" property="o.model" filter="true"/></july:lookupreturn></td>
		<td class="text"><logic:present name="it" property="o.manufacturer"><bean:write name="it" property="o.manufacturer.name" filter="true"/></logic:present></td>
		<td class="text"><bean:write name="it" property="ranges" filter="true"/></td>
		<td class="text"><logic:equal name="it" property="o.polarization" value="V">Вертикальная</logic:equal><logic:equal name="it" property="o.polarization" value="C">Кросс</logic:equal></td>
		<td class="text"><bean:write name="it" property="widthStr" filter="false"/></td>
		<td class="text"><bean:write name="it" property="amps" filter="true"/></td>
		<td style='visibility:hidden;display:none;'><bean:write name="it" property="o.model" filter="true"/> <bean:write name="it" property="o.name" filter="true"/></td>

		<td style='visibility:hidden;display:none;'><bean:write name="it" property="ea800" filter="true"/></td>
		<td style='visibility:hidden;display:none;'><bean:write name="it" property="ea900" filter="true"/></td>
		<td style='visibility:hidden;display:none;'><bean:write name="it" property="ea1800" filter="true"/></td>
		<td style='visibility:hidden;display:none;'><bean:write name="it" property="o.polarization" filter="true"/></td>

	</tr>
	<july:separator colspan="<%= gColSpan %>"/>
</logic:present>
</logic:iterate>
</table></TD></TR>

<tr class="title">
	<td><TABLE class="buttons"><TR class="title">
		<TD class="buttons"><july:closebutton page="/"/></TD>
		<TD class="navigator"><july:navigator/></TD>
	</TR></TABLE></TD>
</tr>

</table>
</july:browseform>

