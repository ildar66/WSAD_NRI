<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<july:editform action="/ProcessReport2.do">

<% String gColSpan = "3"; %>

<script language="javascript">
function switchLookup(itemname,lookupname,disabled) {
	if(disabled) {
		Report2ParamsForm[itemname].className = 'editkoddisabled';
		Report2ParamsForm[itemname].disabled = true;
		Report2ParamsForm[itemname].readonly = true;
		document.all['lookupbtn_'+lookupname+'l'].disabled = true;
		document.all['lookupimg_'+lookupname+'l'].src='/images/lookup_disabled.gif';
	} else {
		Report2ParamsForm[itemname].className = 'editkod';
		Report2ParamsForm[itemname].disabled = false;
		Report2ParamsForm[itemname].readonly = false;
		document.all['lookupbtn_'+lookupname+'l'].disabled = false;
		document.all['lookupimg_'+lookupname+'l'].src='/images/lookup.gif';
	}
}

function switchItem(itemname,state) {
	if(state) {
		Report2ParamsForm[itemname].disabled = true;
		Report2ParamsForm[itemname].className = 'editdisabled';
	} else {
		Report2ParamsForm[itemname].disabled = false;
		Report2ParamsForm[itemname].className = 'edit';
	}
}
</script>

<table class="main">
    
<july:separator colspan="<%= gColSpan %>" />
    
<tr>
	<td class="title"><bean:message key="label.report2.resource"/>:</td>
	<td class="text" colspan="2" nowrap>
		<july:string size="5" property="resourcecode" styleId="resourcecode" insertable="true" updatable="true" />
		<july:lookupbutton action="/ShowResourceLookupList.do" styleId="resl" fieldNames="resourcecode;resourcemodel;resourcename" newWindowName="resourcelookup" insertable="true" updatable="true"/>
		<july:string size="25" property="resourcemodel" styleId="resourcemodel" insertable="false" updatable="false" />
		<july:string size="25" property="resourcename" styleId="resourcename" insertable="false" updatable="false" />
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>" />

<tr>
	<td class="title" rowspan="5"><bean:message key="label.report2.searchon"/></td>
	<td class="text" colspan="2">
		<july:radio styleClass="text" insertable="true" updatable="true" property="searchon" value="1"/><bean:message key="label.report2.anywhere"/>
	</td>
</tr>
<tr>
	<td class="text" colspan="2">
		<july:radio styleClass="text" insertable="true" updatable="true" property="searchon" value="2"/><bean:message key="label.report2.onpositions"/>
	</td>
</tr>
<tr>
	<td class="text" colspan="2">
		<july:radio styleClass="text" insertable="true" updatable="true" property="searchon" value="3"/><bean:message key="label.report2.onstorages"/>
	</td>
</tr>
<tr>
	<td class="text" colspan="2">
		<july:radio styleClass="text" insertable="true" updatable="true" property="searchon" value="4"/><bean:message key="label.report2.onorganizations"/>
	</td>
</tr>
<tr>
	<td class="text" colspan="2">
		<july:radio styleClass="text" insertable="true" updatable="true" property="searchon" value="5"/><bean:message key="label.report2.onworkers"/>
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>" />

<tr>
	<td class="title" rowspan="2"><bean:message key="label.report2.state"/></td>
	<td class="text" colspan="2">
		<july:radio styleClass="text" insertable="true" updatable="true" property="stateType" value="C"/><bean:message key="label.report2.currentdate"/>
	</td>
</tr>
<tr>
<%--
	<td class="text" colspan="2">
		<july:radio styleClass="text" insertable="true" updatable="true" property="stateType" value="D"/><bean:message key="label.report2.givendate"/>&nbsp;&nbsp;&nbsp;<july:date property="stateDateFrm" size="25" insertable="true" updatable="true"/>
	</td>
--%>
</tr>

<july:separator colspan="<%= gColSpan %>" />

<tr>
	<td class="title">&nbsp;</td>
	<td class="text" colspan="2">
		<july:checkbox styleClass="text" insertable="true" updatable="true" property="group"/>&nbsp;<bean:message key="label.report2.groupbyposition"/>
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>" />

<tr>
	<td class="title">&nbsp;</td>
	<td class="text" colspan="2">
		<july:checkbox styleClass="text" insertable="true" updatable="true" property="showAgregated"/>&nbsp;<bean:message key="label.report2.showagregated"/>
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>" />

<tr>
	<td class="title">&nbsp;</td>
	<td class="text" colspan="2">
		<july:checkbox styleClass="text" insertable="true" updatable="true" property="showOncard"/>&nbsp;<bean:message key="label.report2.showoncard"/>
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>" />

<tr class="title">
	<td class="title" colspan="<%= gColSpan %>">
		<INPUT TYPE="IMAGE" NAME="submit" SRC="/images/refresh.gif" ALT="<bean:message key="label.report.refresh"/>">
	</td>
</tr>
    
<july:separator colspan="<%= gColSpan %>" />

<script language="javascript">
Report2ParamsForm.showOncard[0].disabled = true;
</script>

</table>

</july:editform>

