<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import="com.hps.july.inventory.formbean.*"%>

<july:editform action="/ProcessChangePPosition.do">
<%
	ChangePForm pform = (ChangePForm)request.getSession().getAttribute("ChangePForm");
	boolean readonly = true;
	readonly = !("1".equals(pform.getDState()) && !pform.getIsautodoc());
	String acttype = pform.getActtype();
	ChangePPositionForm dform = (ChangePPositionForm)request.getAttribute("ChangePPositionForm");
	boolean browseBySerial = dform.isBrowseBySerial();
	boolean browseBySerialNew = dform.isBrowseBySerialNew();
%>

<script language="javascript">
function copy2newmanuf() {
	ChangePPositionForm.manufserial.value = ChangePPositionForm.newSerial.value;
}

function checkFictionSerial(isUserClick) {
	if (document.all.isSerialFict[0]) {
		switchLookup('newSerialScr','serlStorageplace',document.all.isSerialFict[0].checked, isUserClick);
	}
}

function checkFictionManuf(isUserClick) {
	switchLookup('manufserialScr','',document.all.isManufSerialFict[0].checked, isUserClick);
}

function checkLocalserialManuf(isUserClick) {
	switchLookup('localserialScr','',document.all.isLocalserialFict[0].checked, isUserClick);
}

function switchLookup(itemname,lookupname,disabled, isUserClick) {
	var dall = document.all;
	if(disabled) {
		dall[itemname].className = 'editdisabled';
		dall[itemname].style.width = '100pt';
		dall[itemname].disabled = true;
		dall[itemname].readonly = true;
		dall[itemname].value = '<%= ChangePPositionForm.NUMBER_IS_NOT_KNOWN%>';
/*		
		if (dall['lookupbtn_'+lookupname+'l'])
			dall['lookupbtn_'+lookupname+'l'].disabled = true;
		if (dall['lookupimg_'+lookupname+'l'])
			dall['lookupimg_'+lookupname+'l'].disabled = true;
		if (dall['lookupimg_'+lookupname+'l'])
			dall['lookupimg_'+lookupname+'l'].src='/images/lookup_disabled.gif';
		if (dall['lookupbtn_'+lookupname+'l'])
			dall['lookupbtn_'+lookupname+'l'].style.cursor = 'default';
*/			
		if (dall['lookupbtn_'+lookupname])
			dall['lookupbtn_'+lookupname].disabled = true;
		if (dall['lookupimg_'+lookupname])
			dall['lookupimg_'+lookupname].src='/images/lookup_disabled.gif';
		if (dall['lookupbtn_'+lookupname])
			dall['lookupbtn_'+lookupname].style.cursor = 'default';
	} else {
		dall[itemname].className = 'edit';
		dall[itemname].style.width = '100pt';
		dall[itemname].disabled = false;
		dall[itemname].readonly = false;
		if (isUserClick) {
			dall[itemname].value = '';
		}
/*
		if (dall['lookupbtn_'+lookupname+'l'])
			dall['lookupbtn_'+lookupname+'l'].disabled = false;
		if (dall['lookupimg_'+lookupname+'l'])
			dall['lookupimg_'+lookupname+'l'].disabled = false;
		if (dall['lookupimg_'+lookupname+'l'])
			dall['lookupimg_'+lookupname+'l'].src='/images/lookup.gif';
		if (dall['lookupbtn_'+lookupname+'l'])
			dall['lookupbtn_'+lookupname+'l'].style.cursor = 'hand';
*/			
		if (dall['lookupbtn_'+lookupname])
			dall['lookupbtn_'+lookupname].disabled = false;
		if (dall['lookupimg_'+lookupname])
			dall['lookupimg_'+lookupname].src='/images/lookup.gif';
		if (dall['lookupbtn_'+lookupname])
			dall['lookupbtn_'+lookupname].style.cursor = 'hand';
	}
}

function copyToNewFields() {
	var dall = document.all;
	if ((dall['oldSerialScr'] != '') && (dall['oldSerialScr'] != '<%= ChangePPositionForm.NUMBER_IS_NOT_KNOWN%>')) {
			dall['newSerialScr'].value = dall['oldSerialScr'].value;
	}
	if ((dall['oldmanufserialScr'].value != '') && (dall['oldmanufserialScr'].value != '<%= ChangePPositionForm.NUMBER_IS_NOT_KNOWN%>')) {
			dall['manufserialScr'].value = dall['oldmanufserialScr'].value;
			dall['manufserialScr'].className = 'edit';
			dall['manufserialScr'].style.width = '100pt';
			dall['manufserialScr'].disabled = false;
			dall['manufserialScr'].readonly = false;
			document.all.isManufSerialFict[0].checked = false;
	}
	if ((dall['oldlocalserialScr'].value != '') && (dall['oldlocalserialScr'].value != '<%= ChangePPositionForm.NUMBER_IS_NOT_KNOWN%>')) {
			dall['localserialScr'].value = dall['oldlocalserialScr'].value;
			dall['localserialScr'].className = 'edit';
			dall['localserialScr'].style.width = '100pt';
			dall['localserialScr'].disabled = false;
			dall['localserialScr'].readonly = false;
			document.all.isLocalserialFict[0].checked = false;
	}
}
</script>

<html:hidden property="code" />
<html:hidden property="storageplace"/>

<input type="hidden" name="configuration" value="">
<input type="hidden" name="qtystr" value="">
<input type="hidden" name="party" value="">
<input type="hidden" name="_dummy_" value="">
<input type="hidden" name="att" value="<bean:write name="ChangePForm" property="acttype"/>">
<html:hidden name="ChangePForm" property="document"/>

<%-- Старый вариант формы --%>
<%--
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
	<td class="title"><bean:message key="label.num"/>&nbsp;<bean:write name="ChangePForm" property="blankindex"/>&nbsp;<bean:write name="ChangePForm" property="blanknumber"/>&nbsp;<bean:message key="label.from" />&nbsp;<july:datewrite name="ChangePForm" property="blankdate"/></td>
</tr>
<july:separator/>
<tr>
	<td class="text"><july:reqmark><bean:message key="label.changeppos.resource"/>:</july:reqmark></td>
	<td>
		<%if(readonly){%>
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
		<%} else {%>
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
		<%}%>
	</td>
</tr>
<july:separator/>
<tr>
	<td class="text"><july:reqmark><bean:message key="label.changeppos.oldserial"/>:</july:reqmark></td>
	<td>
		<%if(readonly){%>
			<july:string property="oldSerial" size="15" insertable="false" updatable="false" />
		<%} else {%>
			<july:string property="oldSerial" size="15" insertable="true" updatable="true" />
			<july:lookupbutton action="/ShowCardRLookupList.do" styleId="serl" onclick="set_opt_params_serl('?pagetype=2&owner=&storage='+document.all.storageplace.value+'&resource='+document.all.resourcecode.value+'&agregate=&brokentype=1&documentkey='+document.all.document.value)" fieldNames="resourcecode;resourcename;resourcemodel;configuration;oldSerial;party;qtystr;_dummy_;_dummy_;oldmanufserial;_dummy_;_dummy_" newWindowName="seriallookup" insertable="true" updatable="true"/>
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
<july:separator/>
<tr>
	<td class="text"><july:reqmark><bean:message key="label.changeppos.newresource"/>:</july:reqmark></td>
	<td>
		<%if(readonly){%>
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
		<%} else {%>
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
		<%}%>
	</td>
</tr>
<july:separator/>
<tr>
	<td class="text"><july:reqmark><bean:message key="label.changeppos.newserial"/>:</july:reqmark></td>
	<td>
		<%if(readonly){%>
			<july:string property="newSerial" size="15" insertable="false" updatable="false" />
		<%} else {%>
			<july:string property="newSerial" size="15" insertable="true" updatable="true" />&nbsp;<%if("Add".equals(dform.getAction()) || "Edit".equals(dform.getAction())) {%><input type="image" src="/images/copybtn.gif" width="16" height="16" name="copybtn" onclick="copy2newmanuf();return false;"/><%}%>
		<%}%>
	</td>
</tr>
<july:separator/>
<tr>
	<td class="text"><bean:message key="label.newmanufserial"/>:</td>
	<td>
		<%if(readonly){%>
			<july:string size="20" property="manufserial" insertable="false" updatable="false" />
		<%} else {%>
			<july:string size="20" property="manufserial" insertable="true" updatable="true" />
		<%}%>
	</td>
</tr>
<july:separator/>
</table>
--%>
<%-- Новый вариант формы --%>
<%
	String whatIsChanged = "Что меняем";
	String byWhatIsChanged = "На что меняем";
%>
<table class="main" border="0">
<july:separator colspan="5"/>
<tr>
	<td colspan="5">
		<table class="main" border="0" cellspacing="0" cellpadding="0">
			<july:formbuttons/>
		</table>
	</td>
</tr>
<%-- <july:formbuttons/> --%>
<july:separator colspan="5"/>

<tr>
	<td class="title" colspan="2"><july:actionalert/></td>
</tr>
<july:separator colspan="5"/>
<tr>
	<td class="title">
		<%if("C".equals(acttype)) {%><bean:message key="label.changepos.acttype.change"/><%} else if("U".equals(acttype)) {%><bean:message key="label.changepos.acttype.upgrade"/><%} else {%>Акт<%}%>
	</td>
	<td class="title" colspan="4"><bean:message key="label.num"/>
		<%-- &nbsp;<bean:write name="ChangePForm" property="blankindex"/> --%>
		&nbsp;<bean:write name="ChangePForm" property="blanknumber"/>&nbsp;<bean:message key="label.from" />&nbsp;<july:datewrite name="ChangePForm" property="blankdate"/></td>
</tr>
<july:separator colspan="5"/>
<%if("C".equals(acttype)) {%>
<tr>
	<td class="text" valign="top"><july:reqmark><bean:message key="label.changeppos.resource"/>:</july:reqmark></td>
	<td colspan="4" valign="top">
			<july:string size="5" property="resourcecode" styleId="resourcecode" insertable="true" updatable="true" />
			<july:lookupbutton action="/ShowCardRLookupList.do" styleId="serl" onclick="set_opt_params_serl('?pagetype=2&owner=&storage='+document.all.storageplace.value+'&resource='+document.all.resourcecode.value+'&agregate=&brokentype=1&documentkey='+document.all.document.value)" fieldNames="resourcecode;resourcename;resourcemodel;configuration;oldSerialScr;party;qtystr;_dummy_;_dummy_;oldmanufserialScr;_dummy_;_dummy_" newWindowName="seriallookup" insertable="true" updatable="true"
				onselect="copyToNewFields();"/>
			<%-- <html:text size="45" style="FONT-FAMILY: Verdana,Arial; FONT-SIZE: 10pt; background-color: DCDCDC;" property="resourcemodel" readonly="true"/>	--%>
			<july:textarea style="width: 240pt" cols="40" rows="1" property="resourcemodel" insertable="false" updatable="false"/>
	</td>
</tr>
<tr>
	<td>&nbsp;</td>
	<td colspan="4">
		<%-- <html:text size="55" style="FONT-FAMILY: Verdana,Arial; FONT-SIZE: 10pt; background-color: DCDCDC;" property="resourcename" readonly="true"/> --%>
		<july:textarea style="width: 310pt" cols="50" rows="3" property="resourcename" insertable="false" updatable="false"/>
	</td>
</tr>
<% } else if("U".equals(acttype)) { %>
<tr>
	<td>&nbsp;</td>
	<td align="center"><B><%=whatIsChanged%></B></td>
	<td align="center"><B><%=byWhatIsChanged%></B></td>
	<td colspan="3">&nbsp;</td>
</tr>
<july:separator colspan="5"/>
<tr>
	<td class="text"><july:reqmark><bean:message key="label.changeppos.resource"/>:</july:reqmark></td>
	<td>
		<july:string size="5" property="resourcecode" styleId="resourcecode" insertable="true" updatable="true" />
		<july:lookupbutton action="/ShowCardRLookupList.do" styleId="serl" onclick="set_opt_params_serl('?pagetype=2&owner=&storage='+document.all.storageplace.value+'&resource='+document.all.resourcecode.value+'&agregate=&brokentype=1&documentkey='+document.all.document.value)" fieldNames="resourcecode;resourcename;resourcemodel;configuration;oldSerialScr;party;qtystr;_dummy_;_dummy_;oldmanufserialScr;_dummy_;_dummy_" newWindowName="seriallookup" insertable="true" updatable="true"/>
	</td>
	<td>
		<july:string size="5" property="newresourcecode" styleId="newresourcecode" insertable="true" updatable="true" />
		<july:lookupbutton action="/ShowResourceLookupList.do" styleId="nresl" fieldNames="newresourcecode;newresourcemodel;newresourcename" newWindowName="resourcelookup" insertable="true" updatable="true"/>
	</td>
	<td>
		&nbsp;
	</td>
	<td colspan="2">&nbsp;</td>
</tr>
<tr>
	<td>&nbsp;</td>
	<td>
		<%-- <html:text size="20" style="FONT-FAMILY: Verdana,Arial; FONT-SIZE: 10pt; background-color: DCDCDC;" property="resourcemodel" readonly="true"/>	--%>
		<july:textarea style="width: 120pt" cols="20" rows="2" property="resourcemodel" insertable="false" updatable="false"/>
	<td>
		<%-- <html:text size="25" style="FONT-FAMILY: Verdana,Arial; FONT-SIZE: 10pt; background-color: DCDCDC;" property="newresourcemodel" readonly="true"/> --%>			
		<july:textarea style="width: 120pt" cols="20" rows="2" property="newresourcemodel" insertable="false" updatable="false"/>
	</td>
	<td>
		&nbsp;
	</td>
	<td colspan="2">&nbsp;</td>
</tr>
<tr>
	<td>&nbsp;</td>
	<td>
		<%-- <html:text size="20" style="FONT-FAMILY: Verdana,Arial; FONT-SIZE: 10pt; background-color: DCDCDC;" property="resourcename" readonly="true"/> --%>
		<july:textarea style="width: 120pt" cols="20" rows="4" property="resourcename" insertable="false" updatable="false"/>
	</td>
	<td>
		<%-- <html:text size="25" style="FONT-FAMILY: Verdana,Arial; FONT-SIZE: 10pt; background-color: DCDCDC;" property="newresourcename" readonly="true"/> --%>
		<july:textarea style="width: 120pt" cols="20" rows="4" property="newresourcename" insertable="false" updatable="false"/>
	</td>
	<td>
		&nbsp;
	</td>
	<td colspan="2">&nbsp;</td>
</tr>
<% } %>

<july:separator colspan="5"/>
<tr>
<%if("C".equals(acttype)) {%>
	<td><B><bean:message key="label.allserials"/></B></td>
	<td align="center"><B><%=whatIsChanged%></B></td>
	<td align="center"><B><%=byWhatIsChanged%></B></td>
	<td colspan="2">&nbsp;</td>
<% } else if("U".equals(acttype)) { %>
	<td colspan="5"><B><bean:message key="label.allserials"/></B></td>
<% } %>
</TR>

<tr>
	<TD><SPAN title='<bean:message key="label.allserials.manuf.help"/>'><bean:message key="label.allserials.manuf"/>&nbsp;<IMG SRC="/images/help-little.gif" BORDER="0"></SPAN></TD>
	<td>
		<july:string style="width: 100pt" property="oldSerialScr" size="10" insertable="false" updatable="false" />
	</td>
	<td>
		<july:string style="width: 100pt" property="newSerialScr" size="10" insertable="true" updatable="true" />
	</td>
	<% if("U".equals(acttype)) { %>
		<td>
			<%-- <july:lookupbutton action="/ShowCardLookupList.do" styleId="serl" onclick="if(document.all.lookupbtn_serl.disabled){return false;}set_opt_params_serl('?owner=&storage='+document.all.storageplace.value+'&resource='+document.all.resourcecode.value+'&agregate=&brokentype=1&documentkey='+document.all.document.value)" fieldNames="resourcecode;resourcename;resourcemodel;configuration;snumber;party;qtystr;_dummy_;_dummy_;manufserial;ownercode;pricestr" newWindowName="seriallookup" insertable="true" updatable="true"/> --%>		
			<july:lookupbutton action="/ShowCardLookupList.do" styleId="serlStorageplace" onclick="if(document.all.lookupbtn_serl.disabled){return false;}set_opt_params_serl('?owner=&storage='+document.all.storageplace.value+'&resource='+document.all.resourcecode.value+'&agregate=&brokentype=1&documentkey='+document.all.document.value)" fieldNames="newresourcecode;newresourcename;newresourcemodel;_dummy_;newSerialScr;_dummy_;_dummy_;_dummy_;_dummy_;manufserialScr;_dummy_;_dummy_" newWindowName="seriallookup" insertable="true" updatable="true"/>				
			<%-- <july:lookupbutton action="/ShowCardLookupList.do" styleId="serlStorageplace" onclick="if(document.all.lookupbtn_serl.disabled){return false;}set_opt_params_serl('?owner=&storage='+document.all.storageplace.value+'&resource='+document.all.resourcecode.value+'&agregate=&brokentype=1&documentkey='+document.all.document.value)" fieldNames="" newWindowName="seriallookup" insertable="true" updatable="true"/>	--%>	
		</td>
		<td>
			<july:checkbox property="isSerialFict" insertable="true" updatable='true' 
			    onclick="checkFictionSerial(true);" />
			<bean:message key="label.allserials.noserial"/>
		</td>
	<% } else { %>
		<input type="hidden" name="isSerialFict" value="false">
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	<% } %>
</tr>
<tr>
	<TD><SPAN title='<bean:message key="label.allserials.invent.help"/>'><bean:message key="label.allserials.invent"/>&nbsp;<IMG SRC="/images/help-little.gif" BORDER="0"></SPAN></TD>
	<td>
		<july:string style="width: 100pt" size="10" property="oldmanufserialScr" insertable="false" updatable="false" />
	</td>
	<td>
		<july:string style="width: 100pt" size="10" property="manufserialScr" insertable="true" updatable="true" />
	</td>
	<td>&nbsp;</td>
	<td>
		<july:checkbox property="isManufSerialFict" insertable="true" updatable='true' 
		    onclick="checkFictionManuf(true);" />
		<bean:message key="label.allserials.noserial"/>
	</td>
</tr>
<tr>
	<TD><SPAN title='<bean:message key="label.allserials.local.help"/>'><bean:message key="label.allserials.local"/>&nbsp;<IMG SRC="/images/help-little.gif" BORDER="0"></SPAN></TD>
	<td>
		<july:string style="width: 100pt" size="10" property="oldlocalserialScr" insertable="false" updatable="false" />
	</td>
	<td>
		<july:string style="width: 100pt" size="10" property="localserialScr" insertable="true" updatable="true" />
	</td>
	<td>&nbsp;</td>
	<td>
		<july:checkbox property="isLocalserialFict" insertable="true" updatable='true' 
		    onclick="checkLocalserialManuf(true);" />
		<bean:message key="label.allserials.noserial"/>
	</td>
</tr>
<july:separator colspan="5"/>
<tr>
	<td colspan="5">
		<table class="main" border="0" cellspacing="0" cellpadding="0">
			<july:formbuttons/>
		</table>
	</td>
</tr>
<july:separator colspan="5"/>
<tr>
	<td width="27%"></td>
	<td width="23%"></td>
	<td width="23%"></td>
	<td width="3%"></td>
	<td width="24%"></td>
</tr>
</table>
</july:editform>
<script language="javascript">
	checkFictionSerial(false);
	checkFictionManuf(false);
	checkLocalserialManuf(false);
</script>
