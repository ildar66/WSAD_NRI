<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import="com.hps.july.inventory.formbean.*"%>

<july:editform action="/ProcessChangeSPosition.do">
<%
	ChangeSForm pform = (ChangeSForm)request.getSession().getAttribute("ChangeSForm");
	boolean readonly = true;
	readonly = !("1".equals(pform.getDState()) && !pform.getIsautodoc());
	String acttype = pform.getActtype();
	ChangeSPositionForm dform = (ChangeSPositionForm)request.getAttribute("ChangeSPositionForm");

	boolean browseBySerial = dform.isBrowseBySerial();
	boolean browseBySerialNew = dform.isBrowseBySerialNew();
%>

<script language="javascript">
function copy2newmanuf() {
	ChangeSPositionForm.manufserial.value = ChangeSPositionForm.newSerial.value;
}
</script>

<html:hidden property="code" />
<html:hidden property="storageplace"/>

<input type="hidden" name="configuration" value="">
<input type="hidden" name="qtystr" value="">
<input type="hidden" name="party" value="">
<input type="hidden" name="_dummy_" value="">
<input type="hidden" name="att" value="<bean:write name="ChangeSForm" property="acttype"/>">

<html:hidden name="ChangeSForm" property="document"/>

<table class="main">
    
<july:separator/>
<july:formbuttons/>
<july:separator/>

<tr>
	<td class="title" colspan="2"><july:actionalert/></td>
</tr>

<july:separator/>
    
<tr>
	<td class="title">
		<%if("C".equals(acttype)) {%><bean:message key="label.changepos.acttype.change"/><%} else if("U".equals(acttype)) {%><bean:message key="label.changepos.acttype.upgrade"/><%} else {%>Акт<%}%>
	</td>
	<td class="title"><bean:message key="label.num"/>
	<%-- &nbsp;<bean:write name="ChangeSForm" property="blankindex"/> --%>
	&nbsp;<bean:write name="ChangeSForm" property="blanknumber"/>&nbsp;<bean:message key="label.from" />&nbsp;<july:datewrite name="ChangeSForm" property="blankdate"/></td>
</tr>

<july:separator/>
    
<tr>
	<td class="text"><july:reqmark>Старое оборудование:</july:reqmark></td>
	<td>
		<%if(!readonly) {%>
			<july:string size="5" property="resourcecode" styleId="resourcecode" insertable="true" updatable="false" />

			<%if(!browseBySerial){%>
				<july:lookupbutton action="/ShowResourceLookupList.do" styleId="resl" fieldNames="resourcecode;resourcemodel;resourcename" newWindowName="resourcelookup" insertable="true" updatable="false"/>
			<%} else {
				String s2 = "/ShowResourceLookupBySerialList.do?snumber=";
				%>
				<july:lookupbutton action="<%= s2 + dform.getOldSerial() %>" styleId="resl" fieldNames="resourcecode;resourcemodel;resourcename" newWindowName="resourcelookup" insertable="true" updatable="false" image="lookup_red"/>
			<%}%>

			<html:text size="25" style="FONT-FAMILY: Verdana,Arial; FONT-SIZE: 10pt; background-color: DCDCDC;" property="resourcemodel" readonly="true"/>			
			<html:text size="25" style="FONT-FAMILY: Verdana,Arial; FONT-SIZE: 10pt; background-color: DCDCDC;" property="resourcename" readonly="true"/>
		<%} else {%>
			<july:string size="5" property="resourcecode" styleId="resourcecode" insertable="false" updatable="false" />
			
			<%if(!browseBySerial){%>
				<july:lookupbutton action="/ShowResourceLookupList.do" styleId="resl" fieldNames="resourcecode;resourcemodel;resourcename" newWindowName="resourcelookup" insertable="false" updatable="false"/>
			<%} else {
				String s2 = "/ShowResourceLookupBySerialList.do?snumber=";
				%>
				<july:lookupbutton action="<%= s2 + dform.getOldSerial() %>" styleId="resl" fieldNames="resourcecode;resourcemodel;resourcename" newWindowName="resourcelookup" insertable="false" updatable="false" image="lookup_red"/>
			<%}%>

			<html:text size="25" style="FONT-FAMILY: Verdana,Arial; FONT-SIZE: 10pt; background-color: DCDCDC;" property="resourcemodel" readonly="true"/>			
			<html:text size="25" style="FONT-FAMILY: Verdana,Arial; FONT-SIZE: 10pt; background-color: DCDCDC;" property="resourcename" readonly="true"/>
		<%}%>
	</td>
</tr>
    
<july:separator/>
    
<tr>
	<td class="text"><july:reqmark><bean:message key="label.changespos.oldserial"/>:</july:reqmark></td>
	<td>
		<%if(!readonly) {%>
			<july:string property="oldSerial" size="15" insertable="true" updatable="true" />
			<july:lookupbutton action="/ShowCardRLookupList.do" styleId="serl" onclick="set_opt_params_serl('?pagetype=2&owner=&storage='+document.all.storageplace.value+'&resource='+document.all.resourcecode.value+'&agregate=&brokentype=1&documentkey='+document.all.document.value)" fieldNames="resourcecode;resourcename;resourcemodel;configuration;oldSerial;party;qtystr;_dummy_;_dummy_;oldmanufserial;_dummy_;_dummy_" newWindowName="seriallookup" insertable="true" updatable="true"/>&nbsp;
		<%} else {%>
			<july:string property="oldSerial" size="15" insertable="false" updatable="false" />
		<%}%>
	</td>
</tr>
    
<july:separator/>
    
<tr>
	<td class="text"><bean:message key="label.oldmanufserial"/>:</td>
	<td>
			<july:string size="20" property="oldmanufserial" insertable="false" updatable="false" />
	</td>
</tr>
    
<%--<logic:present name="ChangeSForm" property="acttype"><logic:equal name="ChangeSForm" property="acttype" value="U">--%>
<july:separator/>
<tr>
	<td class="text"><july:reqmark><bean:message key="label.changespos.newresource"/>:</july:reqmark></td>
	<td>
		<%if(!readonly) {%>
			<july:string size="5" property="newresourcecode" styleId="newresourcecode" insertable="true" updatable="false" />

			<%if(!browseBySerialNew){%>
				<july:lookupbutton action="/ShowResourceLookupList.do" styleId="nresl" fieldNames="newresourcecode;newresourcemodel;newresourcename" newWindowName="resourcelookup" insertable="true" updatable="false"/>
			<%} else {
				String s1 = "/ShowResourceLookupBySerialList.do?snumber=";
				%>
				<july:lookupbutton action="<%= s1 + dform.getNewSerial() %>" styleId="nresl" fieldNames="newresourcecode;newresourcemodel;newresourcename" newWindowName="resourcelookup" insertable="true" updatable="false" image="lookup_red"/>
			<%}%>

			<html:text size="25" style="FONT-FAMILY: Verdana,Arial; FONT-SIZE: 10pt; background-color: DCDCDC;" property="newresourcemodel" readonly="true"/>			
			<html:text size="25" style="FONT-FAMILY: Verdana,Arial; FONT-SIZE: 10pt; background-color: DCDCDC;" property="newresourcename" readonly="true"/>
			
		<%} else {%>
			<july:string size="5" property="newresourcecode" styleId="newresourcecode" insertable="false" updatable="false" />
			<%if(!browseBySerialNew){%>
				<july:lookupbutton action="/ShowResourceLookupList.do" styleId="nresl" fieldNames="newresourcecode;newresourcemodel;newresourcename" newWindowName="resourcelookup" insertable="false" updatable="false"/>
			<%} else {
				String s1 = "/ShowResourceLookupBySerialList.do?snumber=";
				%>
				<july:lookupbutton action="<%= s1 + dform.getNewSerial() %>" styleId="nresl" fieldNames="newresourcecode;newresourcemodel;newresourcename" newWindowName="resourcelookup" insertable="false" updatable="false" image="lookup_red"/>
			<%}%>
			<html:text size="25" style="FONT-FAMILY: Verdana,Arial; FONT-SIZE: 10pt; background-color: DCDCDC;" property="newresourcemodel" readonly="true"/>			
			<html:text size="25" style="FONT-FAMILY: Verdana,Arial; FONT-SIZE: 10pt; background-color: DCDCDC;" property="newresourcename" readonly="true"/>
		<%}%>
	</td>
</tr>
<%--</logic:equal></logic:present>--%>

<july:separator/>

<tr>
	<td class="text"><july:reqmark><bean:message key="label.changespos.newserial"/>:</july:reqmark></td>
	<td>
		<%if(!readonly) {%>
			<july:string property="newSerial" size="15" insertable="true" updatable="true" />&nbsp;<input type="image" src="/images/copybtn.gif" width="16" height="16" name="copybtn" onclick="copy2newmanuf();return false;"/>
		<%} else {%>
			<july:string property="newSerial" size="15" insertable="false" updatable="false" />
		<%}%>
	</td>
</tr>
    
<july:separator/>
    
<tr>
	<td class="text"><bean:message key="label.newmanufserial"/>:</td>
	<td>
		<%if(!readonly) {%>
			<july:string size="20" property="manufserial" insertable="true" updatable="true" />
		<%} else {%>
			<july:string size="20" property="manufserial" insertable="false" updatable="false" />
		<%}%>
	</td>
</tr>
    
<july:separator/>

<july:formbuttons/>
    
<july:separator/>
    
</table>

</july:editform>

