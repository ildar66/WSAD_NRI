<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import="com.hps.july.inventory.formbean.*,com.hps.july.inventory.actionbean.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<july:editform action="/ProcessDAssactposB.do">

<%	
	DAssactposBForm dform = (DAssactposBForm)request.getAttribute("DAssactposBForm");

	boolean browseBySerial = dform.isBrowseBySerial();
	boolean readonly = true;
%>

<logic:equal name="DAssactBForm" property="readonly" value="false">
<%
  readonly = false;
%>
</logic:equal>

<script language="javascript">
function switchLookup(itemname,lookupname,disabled) {
	var dall = document.all;
	if(disabled) {
		dall[itemname].className = 'editdisabled';
		dall[itemname].disabled = true;
		dall[itemname].readonly = true;
		dall['lookupbtn_'+lookupname+'l'].disabled = true;
		dall['lookupimg_'+lookupname+'l'].src='/images/lookup_disabled.gif';
		dall['lookupbtn_'+lookupname+'l'].style.cursor = 'default';
/*		dall['lookupimg_'+lookupname+'l'].style.cursor = 'default';*/
	} else {
		dall[itemname].className = 'edit';
		dall[itemname].disabled = false;
		dall[itemname].readonly = false;
		dall['lookupbtn_'+lookupname+'l'].disabled = false;
		dall['lookupimg_'+lookupname+'l'].src='/images/lookup.gif';
		dall['lookupbtn_'+lookupname+'l'].style.cursor = 'hand';
/*		dall['lookupimg_'+lookupname+'l'].style.cursor = 'hand';*/
	}
}
</script>

<html:hidden property="docposition"/>
<html:hidden property="positioncode"/>
<html:hidden property="complectcode"/>
<html:hidden property="ownercode"/>
<html:hidden property="oldAgregateSerial"/>

<html:hidden name="DAssactBForm" property="agregatcode"/>
<html:hidden name="DAssactBForm" property="document"/>


<input type="hidden" name="configuration" value="">
<input type="hidden" name="_dummy_" value="">

<table class="main">
    
<july:separator/>

<july:formbuttons/>
    
<july:separator/>

<tr>
	<td class="title" colspan="2"><july:actionalert/></td>
</tr>
<july:separator/>
<tr>
	<td class="title"><bean:message key="label.dassactposb.document"/>:</td>
	<td class="text"><bean:message key="label.num"/>
		<%-- &nbsp;<bean:write name="DAssactBForm" property="blankindex"/> --%>
		&nbsp;<bean:write name="DAssactBForm" property="blanknumber"/>&nbsp;<bean:message key="label.from" />&nbsp;<july:datewrite name="DAssactBForm" property="blankdate"/></td>
</tr>
<july:separator/>
<tr>
	<td class="title"><bean:message key="label.dassactposb.position"/>:</td>
	<td class="text"><bean:write name="DAssactBForm" property="positionid"/>&nbsp;<bean:write name="DAssactBForm" property="positionname"/></td>
</tr>
<july:separator/>
<tr>
	<td class="title"><bean:message key="label.dassactposb.complect"/>:</td>
	<td class="text"><bean:write name="DAssactBForm" property="complectname"/></td>
</tr>
<july:separator/>
<tr>
	<td class="title"><bean:message key="label.dassactposb.agregate"/>:</td>
	<td class="text"><bean:write name="DAssactBForm" property="agregatname"/></td>
</tr>
<july:separator/>
<tr>
	<td class="text"><july:reqmark><bean:message key="label.dassactposb.num"/>:</july:reqmark></td>
	<td>
		<logic:equal name="DAssactBForm" property="readonly" value="false">
			<july:string property="orderstr" size="10" insertable="true" updatable="true" />
		</logic:equal>
		<logic:equal name="DAssactBForm" property="readonly" value="true">
			<july:string property="orderstr" size="10" insertable="false" updatable="false" />
		</logic:equal>
	</td>
</tr>

<july:separator/>

<tr>
	<td class="text"><july:reqmark><bean:message key="label.dassactposb.resource"/>:</july:reqmark></td>
	<td>
		<logic:equal name="DAssactBForm" property="readonly" value="false">
			<july:string size="5" property="resourcecode" styleId="resourcecode" insertable="true" updatable="true" />
			<%if(!browseBySerial){%>
				<july:lookupbutton action="/ShowResourceLookupList.do" styleId="resl" fieldNames="resourcecode;resourcemodel;resourcename" newWindowName="resourcelookup" insertable="true" updatable="true"/>
			<%} else {
				String s = "/ShowResourceLookupBySerialList.do?snumber=";
				%>
				<july:lookupbutton action="<%= s + dform.getInvnum() %>" styleId="resl" fieldNames="resourcecode;resourcemodel;resourcename" newWindowName="resourcelookup" insertable="true" updatable="true" image="lookup_red"/>
			<%}%>
			<july:string size="30" property="resourcemodel" styleId="resourcemodel"
			   insertable="false" updatable="false"/>			
			<july:string size="30" property="resourcename" styleId="resourcename" 
			   style="width: 433px;"
			   insertable="false" updatable="false"/>
		</logic:equal>
		<logic:equal name="DAssactBForm" property="readonly" value="true">
			<july:string size="5" property="resourcecode" styleId="resourcecode" insertable="false" updatable="false" />
			<%if(!browseBySerial){%>
				<july:lookupbutton action="/ShowResourceLookupList.do" styleId="resl" fieldNames="resourcecode;resourcemodel;resourcename" newWindowName="resourcelookup" insertable="false" updatable="false"/>
			<%} else {
				String s = "/ShowResourceLookupBySerialList.do?snumber=";
				%>
				<july:lookupbutton action="<%= s + dform.getInvnum() %>" styleId="resl" fieldNames="resourcecode;resourcemodel;resourcename" newWindowName="resourcelookup" insertable="false" updatable="false" image="lookup_red"/>
			<%}%>
			<july:string size="30" property="resourcemodel" styleId="resourcemodel"
			   insertable="false" updatable="false"/>			
			<july:string size="30" property="resourcename" styleId="resourcename" 
			   style="width: 433px;"
			   insertable="false" updatable="false"/>
		</logic:equal>
	</td>
</tr>
    
<july:separator/>
    
<tr>
	<td class="text"><july:reqmark><bean:message key="label.dassactposb.qty"/>:</july:reqmark></td>
	<td>
		<logic:equal name="DAssactBForm" property="readonly" value="false">
			<july:string property="qtystr" size="15" insertable="true" updatable="true" />
		</logic:equal>
		<logic:equal name="DAssactBForm" property="readonly" value="true">
			<july:string property="qtystr" size="15" insertable="false" updatable="false" />
		</logic:equal>
	</td>
</tr>
    
<july:separator/>
  
<%--  
    
<tr>
	<td class="text"><bean:message key="label.dassactposb.price"/>:</td>
	<td>
		<july:string property="pricestr" size="15" insertable="false" updatable="false" />
	</td>
</tr>
    
<july:separator/>

--%>
<html:hidden property="pricestr"/>

<script language="javascript">
function switchSetSn() {
	var dall = document.all;
    if(dall.action.value == 'Add' || dall.action.value == 'Edit') {
	if(dall.fictionSerial.value == 'true') {
		dall.invnum.className = 'edit';
		dall.invnum.readOnly = false;
		dall.snumber.className = 'edit';
		dall.snumber.disabled = false;
	} else {
		dall.invnum.className = 'edit';
		dall.invnum.readOnly = false;
		dall.snumber.className = 'edit';
		dall.snumber.disabled = false;
	}
    }
}
function onSerialselect() {
	var dal = document.all;
	if(dal.fictionSerial.value == 'true') {
		dal.snumber.style.display = 'inline';
	} else {
		dal.snumber.style.display = 'none';
	}
	switchSetSn();
}
function clearInvnum() {
	var dall = document.all;
	dall.fictionSerial.value = 'false';
	dall.snumber.style.display = 'none';
	dall.invnum.value = '';
	dall.snumber.value = '';
	dall.serialnumber.value = '';
	dall.resourcecode.value = '';
	dall.resourcemodel.value = '';
	dall.resourcename.value = '';
	dall.manufserial.value = '';
	dall.party.value = '';
	dall.fromplace.value = '';
	dall.pricestr.value = '';
	dall.qtystr.value = '';
	dall.configuration.value = '';
	switchSetSn();
}
</script>

<script language="javascript" src="/wscheck.js"></script>

<tr>
	<td COLSPAN="2"><B><bean:message key="label.allserials"/></B></TD>
</TR>

<tr>
	<TD>&nbsp;&nbsp;<SPAN title='<bean:message key="label.allserials.manuf.help"/>'><bean:message key="label.allserials.manuf"/>&nbsp;<IMG SRC="/images/help-little.gif" BORDER="0"></SPAN></TD>
	<td>
		<logic:equal name="DAssactBForm" property="readonly" value="false">
			<july:string property="invnum" size="15" insertable="true" updatable="true" />
			<SPAN STYLE="width: 50px;">
			<july:lookupbutton action="/ShowCardLookupList.do" styleId="serl" onselect="onSerialselect();" onclick="set_opt_params_serl('?owner=&storage='+document.all.complectcode.value+'&resource='+document.all.resourcecode.value+'&agregate='+document.all.agregatcode.value+'&brokentype=1&documentkey='+document.all.document.value);" fieldNames="resourcecode;resourcename;resourcemodel;configuration;serialnumber;party;qtystr;fromplace;_dummy_;manufserial;ownercode;pricestr;invnum;fictionSerial" newWindowName="seriallookup" insertable="true" updatable="true"/>
			<a href="#" onclick="clearInvnum();return false;" title="—бросить"><img src="/images/clear.gif" border="0"></a>
			</SPAN>
		</logic:equal>
		<logic:equal name="DAssactBForm" property="readonly" value="true">
			<july:string property="invnum" size="15" insertable="false" updatable="false" />
		</logic:equal>
		<july:string property="snumber" size="15" insertable="true" updatable="true"/>
		<html:hidden property="serialnumber"/>
		<html:hidden property="fictionSerial"/>
	</td>
</tr>
<tr>
	<TD>&nbsp;&nbsp;<SPAN title='<bean:message key="label.allserials.invent.help"/>'><bean:message key="label.allserials.invent"/>&nbsp;<IMG SRC="/images/help-little.gif" BORDER="0"></SPAN></TD>
	<td>
		<july:string property="manufserial" size="15" insertable="false" updatable="false" />
	</td>
</tr>
<tr>
	<TD>&nbsp;&nbsp;<SPAN title='<bean:message key="label.allserials.local.help"/>'><bean:message key="label.allserials.local"/>&nbsp;<IMG SRC="/images/help-little.gif" BORDER="0"></SPAN></TD>
	<td>
		<july:string property="localserial" size="15" insertable="false" updatable="false" />
	</td>
</tr>
    
<%if(!readonly){%>
<SCRIPT language="JavaScript">
  onSerialselect();switchSetSn();
</SCRIPT>
<%}%>
    
    
<july:separator/>
    
<tr>
	<td class="text"><bean:message key="label.dassactposb.partynum"/>:</td>
	<td>
		<logic:equal name="DAssactBForm" property="readonly" value="false">
			<july:string property="party" size="15" insertable="true" updatable="true" />
			<july:lookupbutton action="/ShowCardLookupList.do" styleId="partl" onselect="onSerialselect();" onclick="set_opt_params_partl('?owner=&storage='+document.all.complectcode.value+'&resource='+document.all.resourcecode.value+'&agregate='+document.all.agregatcode.value+'&brokentype=1&documentkey='+document.all.document.value);" fieldNames="resourcecode;resourcename;resourcemodel;configuration;serialnumber;party;qtystr;fromplace;_dummy_;manufserial;ownercode;pricestr;invnum;fictionSerial" newWindowName="partylookup" insertable="true" updatable="true"/>&nbsp;
		</logic:equal>
		<logic:equal name="DAssactBForm" property="readonly" value="true">
			<july:string property="party" size="15" insertable="false" updatable="false" />
		</logic:equal>
	</td>
</tr>
    
<july:separator/>
    
<tr>
	<td class="text"><bean:message key="label.fromplace"/>:</td>
	<td>
		<july:string property="fromplace" size="20" insertable="false" updatable="false" />
	</td>
</tr>
    
<july:separator/>

<july:formbuttons/>
    
<july:separator/>
    
</table>

</july:editform>

