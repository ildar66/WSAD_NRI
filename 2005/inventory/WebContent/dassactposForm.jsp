<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import="com.hps.july.inventory.formbean.*"%>

<july:editform action="/ProcessDAssactpos.do">

<%	
	DAssactposForm dform = (DAssactposForm)request.getAttribute("DAssactposForm");

	boolean browseBySerial = dform.isBrowseBySerial();
%>

<html:hidden property="docposition" />
<html:hidden property="storagecode" />
<html:hidden property="ownercode" />
<html:hidden property="oldAgregateSerial" />

<input type="hidden" name="configuration" value="">
<input type="hidden" name="_dummy_" value="">
<html:hidden name="DAssactForm" property="agregatcode"/>
<html:hidden name="DAssactForm" property="agregateserial"/>
<html:hidden name="DAssactForm" property="document"/>

<table class="main">
    
<july:separator/>
 
<july:formbuttons/>
    
<july:separator/>	

<tr>
	<td class="title" colspan="2"><july:actionalert/></td>
</tr>

<july:separator/>
    
<tr>
	<td class="text"><bean:message key="label.dassactpos.document"/></td>
	<td class="text"><bean:message key="label.num"/>
		<%-- &nbsp;<bean:write name="DAssactForm" property="blankindex"/> --%>
		&nbsp;<bean:write name="DAssactForm" property="blanknumber"/>&nbsp;<bean:message key="label.from" />&nbsp;<july:datewrite name="DAssactForm" property="blankdate"/></td>
</tr>
<%--
<july:separator/>

<tr>
	<td class="text"><july:reqmark><bean:message key="label.internal.owner"/>:</july:reqmark></td>
	<td>
		<july:select collection="owners" property="ownercode" insertable="true" updatable="true">
			<html:options collection="owners" property="organization" labelProperty="name"/>
		</july:select>
	</td>
</tr>
--%>
<july:separator/>
    
<tr>
		<td class="text"><bean:message key="label.dassactpos.storage"/></td>
		<td class="text">
			<bean:write name="DAssactForm" property="storagename"/>
		</td>
</tr>

<july:separator/>
    
<tr>
		<td class="text"><bean:message key="label.dassactpos.agregate"/></td>
		<td class="text">
			<bean:write name="DAssactForm" property="agregatname"/>
		</td>
</tr>

<july:separator/>
    
<tr>
	<td class="text"><july:reqmark><bean:message key="label.dassactpos.num"/>:</july:reqmark></td>
	<td>
		<logic:equal name="DAssactForm" property="readonly" value="false">
			<july:string property="orderstr" size="10" insertable="true" updatable="true" />
		</logic:equal>
		<logic:equal name="DAssactForm" property="readonly" value="true">
			<july:string property="orderstr" size="10" insertable="false" updatable="false" />
		</logic:equal>
	</td>
</tr>

<july:separator/>

<tr>
	<td class="text"><july:reqmark><bean:message key="label.dassactpos.resource"/>:</july:reqmark></td>
	<td>
		<logic:equal name="DAssactForm" property="readonly" value="false">
			<july:string size="5" property="resourcecode" styleId="resourcecode" insertable="true" updatable="true" />

			<%if(!browseBySerial){%>
				<july:lookupbutton action="/ShowResourceLookupList.do" styleId="resl" fieldNames="resourcecode;resourcemodel;resourcename" newWindowName="resourcelookup" insertable="true" updatable="true"/>
			<%} else {
				String s = "/ShowResourceLookupBySerialList.do?snumber=";
				%>
				<july:lookupbutton action="<%= s + dform.getSerialnumber() %>" styleId="resl" fieldNames="resourcecode;resourcemodel;resourcename" newWindowName="resourcelookup" insertable="true" updatable="true" image="lookup_red"/>
			<%}%>
			
			<july:string size="30" property="resourcemodel" styleId="resourcemodel" insertable="false" updatable="false"/>			
			<july:string size="30" property="resourcename" 
			   style="width: 433px;"
			   styleId="resourcename" insertable="false" updatable="false"/>

		</logic:equal>
		<logic:equal name="DAssactForm" property="readonly" value="true">
			<july:string size="5" property="resourcecode" styleId="resourcecode" insertable="false" updatable="false" />
			
			<%if(!browseBySerial){%>
				<july:lookupbutton action="/ShowResourceLookupList.do" styleId="resl" fieldNames="resourcecode;resourcemodel;resourcename" newWindowName="resourcelookup" insertable="false" updatable="false"/>
			<%} else {
				String s = "/ShowResourceLookupBySerialList.do?snumber=";
				%>
				<july:lookupbutton action="<%= s + dform.getSerialnumber() %>" styleId="resl" fieldNames="resourcecode;resourcemodel;resourcename" newWindowName="resourcelookup" insertable="false" updatable="false" image="lookup_red"/>
			<%}%>

			<july:string size="30" property="resourcemodel" styleId="resourcemodel" insertable="false" updatable="false" />
			<july:string size="30" property="resourcename" 
			   style="width: 433px;"
			   styleId="resourcename" insertable="false" updatable="false" />
		</logic:equal>
	</td>
</tr>
    
<july:separator/>
    
<tr>
	<td class="text"><july:reqmark><bean:message key="label.dassactpos.qty"/>:</july:reqmark></td>
	<td>
		<logic:equal name="DAssactForm" property="readonly" value="false">
			<july:string property="qtystr" size="15" insertable="true" updatable="true" />
		</logic:equal>
		<logic:equal name="DAssactForm" property="readonly" value="true">
			<july:string property="qtystr" size="15" insertable="false" updatable="false" />
		</logic:equal>
	</td>
</tr>
    
<july:separator/>
    
<%--
    
<tr>
	<td class="text"><bean:message key="label.internalrpos.price"/>:</td>
	<td>
		<july:string property="pricestr" size="15" insertable="false" updatable="false" />
	</td>
</tr>
    
<july:separator/>

--%>
<html:hidden property="pricestr"/>


<INPUT TYPE="HIDDEN" NAME="stcode" ID="stcode" VALUE='<bean:write name="DAssactForm" property="storagecode"/>'>
    
<script language="javascript" src="/wscheck.js"></script>

<tr>
	<td COLSPAN="2"><B><bean:message key="label.allserials"/></B></TD>
</TR>

<tr>
	<TD>&nbsp;&nbsp;<SPAN title='<bean:message key="label.allserials.manuf.help"/>'><bean:message key="label.allserials.manuf"/>&nbsp;<IMG SRC="/images/help-little.gif" BORDER="0"></SPAN></TD>
	<td>
		<logic:equal name="DAssactForm" property="readonly" value="false">
			<july:string property="serialnumber" size="15" insertable="true" updatable="true" />
			<july:lookupbutton action="/ShowCardLookupList.do" styleId="serl" onclick="set_opt_params_serl('?owner=&storage='+document.all.stcode.value+'&resource='+document.all.resourcecode.value+'&agregate='+document.all.agregatcode.value+'&brokentype=1&documentkey='+document.all.document.value)" fieldNames="resourcecode;resourcename;resourcemodel;configuration;serialnumber;party;qtystr;fromplace;_dummy_;manufserial;ownercode;pricestr" newWindowName="seriallookup" insertable="true" updatable="true"/>&nbsp;
		</logic:equal>
		<logic:equal name="DAssactForm" property="readonly" value="true">
			<july:string property="serialnumber" size="15" insertable="false" updatable="false" />
		</logic:equal>
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
    
    
    
<july:separator/>
    
<tr>
	<td class="text"><bean:message key="label.dassactpos.partynum"/>:</td>
	<td>
		<logic:equal name="DAssactForm" property="readonly" value="false">
			<july:string property="party" size="15" insertable="true" updatable="true" />
			<july:lookupbutton action="/ShowCardLookupList.do" styleId="partl" onclick="set_opt_params_partl('?owner=&storage='+document.all.stcode.value+'&resource='+document.all.resourcecode.value+'&agregate='+document.all.agregatcode.value+'&brokentype=1&documentkey='+document.all.document.value)" fieldNames="resourcecode;resourcename;resourcemodel;configuration;serialnumber;party;qtystr;fromplace;_dummy_;manufserial;ownercode;pricestr" newWindowName="partylookup" insertable="true" updatable="true"/>&nbsp;
		</logic:equal>
		<logic:equal name="DAssactForm" property="readonly" value="true">
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

