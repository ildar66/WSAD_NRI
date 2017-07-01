<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>

<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<july:browseform action="/ShowBSLookupList.do" styleId="BSLookupListForm">

<script language="javascript" src="basestation/support.js"></script>

<july:lookupresult tableId="brtable" resultCols="0;1"/>
<%--Первые две колонки (код БС и полное имя) всегда hidden--%>

<%
	String gColSpan = "8";
%>

<table class="main">

<tr class="title">
	<td class="title" colspan="<%=gColSpan%>">
		<bean:message key="label.choose.basestation"/>
	</td>
</tr>

<%-- filter fields --%>
<tr class='normal'>
	<td colspan="<%=gColSpan%>">
		<table class='find'>
<script language="javascript">
aForm = BSLookupListForm;

function switchController(state) {
	switchLookupButton('cntrl',!state);
	aForm.acontrollerKey.className = state?'editkoddisabled':'editkodsearch';
	aForm.acontrollerKey.disabled = state;
}

function switchSwitch(state) {
	switchLookupButton('swchl',!state);
	aForm.aswitchKey.className = state?'editkoddisabled':'editkodsearch';
	aForm.aswitchKey.disabled = state;
}

function switchSearchBy() {
	if(aForm.searchby[0].checked) {
		aForm.searchstring.disabled = true;
		aForm.searchstring.className = 'editdisabled';
	} else
	if(aForm.searchby[1].checked) {
		aForm.searchstring.disabled = false;
		aForm.searchstring.className = 'editsearch';
	} else
	if(aForm.searchby[2].checked) {
		aForm.searchstring.disabled = false;
		aForm.searchstring.className = 'editsearch';
	} else
	if(aForm.searchby[3].checked) {
		aForm.searchstring.disabled = false;
		aForm.searchstring.className = 'editsearch';
	} else {
		aForm.searchstring.disabled = true;
		aForm.searchstring.className = 'editdisabled';
	}
}

</script>
		<%-- multipleSelect --%>
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
			<td class="title"><bean:message key="label.bslookup.stationtype"/>:</td>
			<td class="title">
				<july:radio styleClass="editcheckbox" property="stationtype" value="D" insertable="true" updatable="true" />&nbsp;<bean:message key="label.bslookup.stationtype.d"/>
				&nbsp;&nbsp;&nbsp;&nbsp;
				<july:radio styleClass="editcheckbox" property="stationtype" value="A" insertable="true" updatable="true" />&nbsp;<bean:message key="label.bslookup.stationtype.a"/>
			</td>
		</tr>
		<tr>
			<td class="title"><bean:message key="label.bslookup.searchby"/>:</td>
			<td class="title">
				<july:radio styleClass="editcheckbox" property="searchby" value="A" insertable="true" updatable="true" onclick="switchSearchBy();"/>&nbsp;<bean:message key="label.bslookup.searchby.all"/>
				&nbsp;&nbsp;&nbsp;&nbsp;
				<july:radio styleClass="editcheckbox" property="searchby" value="1" insertable="true" updatable="true" onclick="switchSearchBy();"/>&nbsp;<bean:message key="label.bslookup.searchby.bsnum"/>
				&nbsp;&nbsp;&nbsp;&nbsp;
				<july:radio styleClass="editcheckbox" property="searchby" value="2" insertable="true" updatable="true" onclick="switchSearchBy();"/>&nbsp;<bean:message key="label.bslookup.searchby.name"/>
				&nbsp;&nbsp;&nbsp;&nbsp;
				<july:radio styleClass="editcheckbox" property="searchby" value="3" insertable="true" updatable="true" onclick="switchSearchBy();"/>&nbsp;<bean:message key="label.bslookup.searchby.address"/>
			</td>
		</tr>
		<tr>
			<td class="title"><bean:message key="label.bslookup.searchstring"/>:</td>
			<td class="title">
				<july:string styleClass="search" property="searchstring" insertable="true" updatable="true"/>
			</td>
		</tr>
		<tr>
			<td class="title"><bean:message key="label.bslookup.controller"/></td>
			<td class="title">
				<july:checkbox property="allcontroller" styleId="allcontroller" insertable="true" updatable="true" onclick="switchController(this.checked);"/>&nbsp;<bean:message key="label.all"/>
				&nbsp;&nbsp;&nbsp;&nbsp;
				<july:string property="acontroller.key" styleId="acontrollerKey" size="5" insertable="true" updatable="true" styleClass="editkodsearch"/>
				<july:lookupbutton action="/ShowControllerLookupList.do" styleId="cntrl" fieldNames="acontrollerKey;acontrollerName;acontrollerPosname;" newWindowName="contrlookup" insertable="true" updatable="true"/>
				<july:string size="35" property="acontroller.name" styleId="acontrollerName" insertable="false" updatable="false" />
				<input type="hidden" name="acontrollerPosname">
			</td>
		</tr>
		<tr>
			<td class="title"><bean:message key="label.bslookup.switch"/></td>
			<td class="title">
				<july:checkbox property="allswitch" styleId="allswitch" insertable="true" updatable="true" onclick="switchSwitch(this.checked);"/>&nbsp;<bean:message key="label.all"/>
				&nbsp;&nbsp;&nbsp;&nbsp;
				<july:string property="aswitch.key" styleId="aswitchKey" size="5" insertable="true" updatable="true" styleClass="editkodsearch"/>
				<july:lookupbutton action="/ShowSwitchLookupList.do" styleId="swchl" fieldNames="aswitchKey;aswitchName;" newWindowName="contrlookup" insertable="true" updatable="true"/>
				<july:string size="35" property="aswitch.name" styleId="aswitchName" insertable="false" updatable="false" />
			</td>
		</tr>
		</table>
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>" />

<%-- top navigation line --%>
<tr class="title">
	<td colspan="<%=gColSpan%>">
		<table class="buttons">
		<tr class="title">
			<td class="buttons"><july:closebutton page="/"/></td>
			<td class="navigator"><july:navigator/></td>
		</tr>
		</table>
	</td>
</tr>

<tr>
<td colspan="<%=gColSpan%>">
<table class="main" id="brtable">
<%-- table rendering --%>
<tr class="title">
	<td style="visibility:hidden;display:none;"></td>
	<td style="visibility:hidden;display:none;"></td>
	<july:headercolumn key="label.bslookup.bsnum" colType="integer"/>
	<july:headercolumn key="label.bslookup.type" colType="string"/>
	<july:headercolumn key="label.bslookup.name" colType="string"/>
	<july:headercolumn key="label.bslookup.address" colType="string"/>
	<july:headercolumn key="label.bslookup.netzone" colType="string"/>
	<july:headercolumn key="label.bslookup.onair" colType="string"/>
<%--
	<TD class="title">
		<bean:message key="SwitchList.table.map"/><br>
		<INPUT type=checkbox class=editcheckbox value='true' name='isAllEquipment' id='isAllEquipmentId' onclick='checkAll(this.checked ,"isEquipmentId" )' />
	</TD>
--%>
</tr>

<logic:iterate id="it" name="browseList" indexId="index">
<logic:present name="it">
<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
	<td style="visibility:hidden;display:none;"><bean:write name="it" property="key" filter="true"/></td>
	<td style="visibility:hidden;display:none;"><logic:equal name="it" property="type" value="D">DAMPS</logic:equal><logic:equal name="it" property="type" value="S">GSM 900</logic:equal><logic:equal name="it" property="type" value="C">DCS 1800</logic:equal><logic:equal name="it" property="type" value="G">GSM 900/1800</logic:equal> №<bean:write name="it" property="number" filter="true"/> <bean:write name="it" property="name" filter="true"/></td>
	<td class="number"><bean:write name="it" property="number" filter="true"/></td>
	<td class="text"><logic:equal name="it" property="type" value="D">DAMPS</logic:equal><logic:equal name="it" property="type" value="S">GSM 900</logic:equal><logic:equal name="it" property="type" value="C">DCS 1800</logic:equal><logic:equal name="it" property="type" value="G">GSM 900/1800</logic:equal></td>
	<td class="text"><july:lookupreturn><bean:write name="it" property="name" filter="true"/></july:lookupreturn></td>
	<td class="text"><bean:write name="it" property="address" filter="true"/></td>
	<td class="text"><bean:write name="it" property="netzone" filter="true"/></td>
	<td class="text"><logic:present name="it" property="onair"><logic:equal name="it" property="onair" value="true">Э</logic:equal></logic:present></td>
</tr>
</logic:present>
<logic:notPresent name="it">
<tr class="normal">
	<td class="text" colspan="<%= gColSpan %>">
		<bean:message key="label.norecords"/>
	</td>
</tr>
</logic:notPresent>
<july:separator colspan="<%= gColSpan %>"/>
</logic:iterate>
</table>
</td>
</tr>

<%-- bottom navigation line --%>
<tr class="title">
	<td colspan="<%=gColSpan%>">
		<table class="buttons">
		<tr class="title">
			<td class="buttons"><july:closebutton page="/"/></td>
			<td class="navigator"><july:navigator/></td>
		</tr>
		</table>
	</td>
</tr>

</table>

<script language="javascript">
switchController(aForm.allcontroller[0].checked);
switchSwitch(aForm.allswitch[0].checked);
switchSearchBy();
</script>

</july:browseform>
