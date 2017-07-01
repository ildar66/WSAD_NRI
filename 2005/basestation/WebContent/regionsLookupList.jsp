<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import="org.apache.struts.util.*"%>
<%@ page import="com.hps.july.basestation.valueobject.*"%>
<%@ page import="com.hps.july.siteinfo.formbean.*"%>

<july:browseform action="/ShowRegionsLookupList.do" styleId="RegionsLookupListForm">
<july:lookupresult tableId="brtable" resultCols="0;1;2;3"/>
<table class="main">
<tr class="title"><td class="title"><bean:message key="label.choose.regions"/></td></tr>

<script language="javascript">
function switchAllSearch() {
	if(document.all.item('allSuperregions')[0].checked ) {
		document.all.item('superregionCode').className = 'editbigdisabled';
		document.all.item('superregionCode').disabled = true;
	} else {
		document.all.item('superregionCode').className = 'editbigsearch';
		document.all.item('superregionCode').disabled = false;
	}
}

</script>

<tr class='normal'><td>
<table class='find'>
	<tr>
		<td class="title"><bean:message key="label.regionslookup.superregion"/></td>
		<td class="title">
			<july:checkbox styleId="allSuperregions" property="allSuperregions" insertable="true" updatable="true" value="true" onclick="switchAllSearch();"/>&nbsp;<bean:message key="label.search.all"/>
			&nbsp;&nbsp;&nbsp;
			<july:select styleId="superregionCode" collection="superRegions" property="superregion" insertable="true" updatable="true" styleClass="editbigsearch">
				<html:options collection="superRegions" property="supregid" labelProperty="supregname"/>
			</july:select>
		</td>
		<td class="title"><july:searchbutton/></td>
	</tr>
</table>
<script language="javascript">switchAllSearch();</script>
</td>
</tr>

<tr class="title"><td><table class="buttons"><tr class="title">
	<td class="buttons"><july:closebutton page="/"/></td>
	<td class="navigator"><july:navigator/></td>
</tr></table></td></tr>

<% java.lang.String gColSpan = "7"; %>

<tr><td>
<table class="main" id="brtable">

<!-- Table header -->
<tr class="title">
	<td class="number" style='visibility:hidden;display:none'>regid</td>
	<july:headercolumn key="label.regionslookup.regionname" colType="string"/>
	<td class="number" style='visibility:hidden;display:none'>supregid</td>
	<july:headercolumn key="label.regionslookup.supregionname" colType="string"/>
</tr>

<!-- Table body -->
<logic:iterate id="reg" name="browseList" indexId="index" type="com.hps.july.cdbc.lib.CDBCRowObject">
<logic:present name="reg">
<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
	<td class="number" style='visibility:hidden;display:none;'><july:stringwrite name="reg" property="regionid"/></td>
	<td class="text"><july:lookupreturn><july:stringwrite name="reg" property="regname"/></july:lookupreturn></td>
	<td class="number" style='visibility:hidden;display:none;'><july:stringwrite name="reg" property="supregid"/></td>
	<td class="text"><july:stringwrite name="reg" property="supregname"/></td>
</tr>
<july:separator colspan="<%= gColSpan %>" />
</logic:present>
<logic:notPresent name="reg">
<tr class="normal">
	<td class="text" colspan="<%= gColSpan %>">
		<bean:message key="label.norecords"/>
	</td>
</tr>
</logic:notPresent>
</logic:iterate>
</table>
</td></tr>

<tr class="title"><td><table class="buttons"><tr class="title">
	<td class="buttons"><july:closebutton page="/"/></td>
	<td class="navigator"><july:navigator/></td>
</tr></table></td></tr>
</table>

</july:browseform>
