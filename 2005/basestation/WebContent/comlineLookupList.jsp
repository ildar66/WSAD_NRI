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

<july:browseform action="/ShowComlineLookupList.do" styleId="ComlineForm">
<july:lookupresult tableId="brtable" resultCols="0;1;2;3;5;6;7;8"/>
<table class="main">
<tr class="title"><td class="title"><bean:message key="label.choose.comline"/></td></tr>

<script language="javascript">
function switchAllSearch() {
	if(document.all.item('searchById')[0].checked ) {
		document.all.item('searchstringId').className = 'editdisabled';
		document.all.item('searchstringId').disabled = true;
	} else {
		document.all.item('searchstringId').className = 'editsearch';
		document.all.item('searchstringId').disabled = false;
	}
}

</script>

<tr class='normal'><td>
<table class='find'>
	<tr>
		<td class="title" colspan="2">
		<table border=0 width="100%" cellpadding=0 cellspacing=0>
		<tr>
			<td><jsp:include page="/common/regionsselect.jsp" flush="true" /></td>
			<td><july:searchbutton/></td>
		</tr>
		</table>
		</td>
	</tr>
	<tr>
		<td class="title"><bean:message key="label.position.searchby"/></td>
		<td class="title" NOWRAP>
			<july:radio styleClass="editcheckbox" property="searchBy" styleId="searchById" value="all" onclick="switchAllSearch()" insertable="true" updatable="true" />
			<bean:message key="search.all"/> &nbsp;
			<july:radio styleClass="editcheckbox" property="searchBy" styleId="searchById" value="hopsname" onclick="switchAllSearch()" insertable="true" updatable="true" />
			<bean:message  key="search.byHopsName"/> &nbsp;
			<july:radio styleClass="editcheckbox" property="searchBy" styleId="searchById" value="name" onclick="switchAllSearch()" insertable="true" updatable="true" />
			<bean:message  key="search.byName"/> &nbsp;
			<july:radio styleClass="editcheckbox" property="searchBy" styleId="searchById" value="address" onclick="switchAllSearch()" insertable="true" updatable="true" />
			<bean:message  key="search.byAddress"/> <br>
			<july:radio styleClass="editcheckbox" property="searchBy" styleId="searchById" value="gsmnumber" onclick="switchAllSearch();document.forms(0).elements('finderMethodName').value = '5';" insertable="true" updatable="true" />
			<bean:message key="search.byGsmNumber"/> &nbsp;
			<july:radio styleClass="editcheckbox" property="searchBy" styleId="searchById" value="dampsnumber" onclick="switchAllSearch();document.forms(0).elements('finderMethodName').value = '5';" insertable="true" updatable="true" />
			<bean:message key="search.byDampsNumber"/> &nbsp;
			<july:radio styleClass="editcheckbox" property="searchBy" styleId="searchById" value="beenet" onclick="switchAllSearch();" insertable="true" updatable="true" />
			<bean:message key="ComlineList.beenetsearch"/>
		</td>
	</tr>
	<tr>
		<td class="title"><bean:message key="label.position.search.text"/></td>
		<td class="title" colspan='3'>
			<html:text styleClass="search" property="searchString" styleId="searchstringId" size="25" />
		</td>
	</tr>
	<tr>
		<td class="title"><bean:message key="ComlineList.state"/></td>
		<td class="title" colspan='3'>
			<july:select property="comlinestate" insertable="true" updatable="true" styleClass="search">
				<html:option key="ComlineList.state.all" value="*"/>
				<html:option key="ComlineForm.state.A" value="A"/>
				<html:option key="ComlineForm.state.B" value="B"/>
				<html:option key="ComlineForm.state.C" value="C"/>
				<html:option key="ComlineForm.state.D" value="D"/>
			</july:select>
		</td>
	</tr>
</table>
</td>
</tr>
<script language="javascript">switchAllSearch();</script>

<tr class="title"><td><table class="buttons"><tr class="title">
	<td class="buttons"><july:closebutton page="/"/></td>
	<td class="navigator"><july:navigator/></td>
</tr></table></td></tr>

<% java.lang.String gColSpan = "9"; %>

<tr><td>
<table class="main" id="brtable">

<!-- Table header -->
<tr class="title">
	<td class="number" style='visibility:hidden;display:none'>hopsid</td>
	<july:headercolumn key="label.comline.comlinecode" colType="string"/>
	<july:headercolumn key="label.comline.positiona" colType="string"/>
<july:headercolumn key="ComlineList.table.resource1" colType="string"/>
	<td class="title">&nbsp;</td>
	<july:headercolumn key="label.comline.positionb" colType="string"/>
<july:headercolumn key="ComlineList.table.resource2" colType="string"/>
	<july:headercolumn key="label.comline.comlinetype" colType="string"/>
	<july:headercolumn key="ComlineList.table.hopsate" colType="string"/>
<%if(request.isUserInRole("FreqManager") || request.isUserInRole("administrator")) {%>
	<july:headercolumn key="ComlineList.table.file" colType="string"/>
<%}%>
</tr>

<!-- Table body -->
<logic:iterate id="com" name="browseList" indexId="index">
<logic:present name="com">
<%
	ComlineObject ob=(ComlineObject)pageContext.getAttribute("com");
	boolean canEdit=ob.isEditRegion();
	String state = "ComlineList.state.C";
	if(ob.getHopstate() != null && !"".equals(ob.getHopstate())) {
		state = "ComlineList.state."+ob.getHopstate();
	}

%>
<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
	<td class="number" style='visibility:hidden;display:none'><bean:write name="com" property="id" filter="true"/></td>
	<td class="text"><july:lookupreturn><bean:write name="com" property="prolet" filter="true"/></july:lookupreturn></td>
	<td class="text"><bean:write name="com" property="number" filter="true"/> <bean:write name="com" property="name" filter="true"/></td>
	<td class="text"><bean:write name="com" property="equname1" filter="true"/></td>
	<td class="text">-</td>
	<td class="text"><bean:write name="com" property="number2" filter="true"/> <bean:write name="com" property="name2" filter="true"/></td>
	<td class="text"><bean:write name="com" property="equname2" filter="true"/></td>
	<td class="text">
		<%if("R".equals(ob.getComlinetype())) {%>
			<bean:message key="label.comline.typer"/>
		<%} else if("O".equals(ob.getComlinetype())) {%>
			<bean:message key="label.comline.typeo"/>
		<%}%>
	</td>
	<td class="text"><bean:message key="<%=state%>"/></td>
<%if(request.isUserInRole("FreqManager") || request.isUserInRole("administrator")) {%>
	<td class="text"><bean:write name="com" property="filenumber" filter="true"/></td>
<%}%>
</tr>
<july:separator colspan="<%= gColSpan %>" />
</logic:present>
<logic:notPresent name="com">
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
