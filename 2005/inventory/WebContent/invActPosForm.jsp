<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import="com.hps.july.inventory.formbean.*,com.hps.july.inventory.actionbean.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<july:editform action="/ProcessInvActPos.do">

<%	
	InvActPosForm aform = (InvActPosForm)request.getAttribute("InvActPosForm");
	boolean browseBySerial = aform.isBrowseBySerial();
%>


<script language="javascript">
function copy2manuf() {
	InvActPosForm.manufserial.value = InvActPosForm.serialnumber.value;
}
</script>

<html:hidden property="docposition" />
<html:hidden property="document" />
<html:hidden property="utype" value="-"/>
<html:hidden property="useplace" />
<html:hidden property="storage" />

<table class="main">

<july:separator/>

<july:formbuttons/>

<july:separator/>

<tr>
	<td class="title" colspan="2"><july:actionalert/></td>
</tr>
<july:separator/>
<tr>
	<td class="title"><bean:message key="label.invpos.act"/>:</td>
        <td><bean:message key="label.num"/>
        <%-- &nbsp;<bean:write name="InvActForm" property="blankindex"/> --%>
        &nbsp;<bean:write name="InvActForm" property="blanknumber" />&nbsp;<bean:message key="label.from" />&nbsp;<bean:write name="InvActForm" property="blankdatestr" /></td>
</tr>
<july:separator/>
<tr>
        <td class="title"><bean:message key="label.invpos.org"/>:</td>
        <td><bean:write name="InvActForm" property="ownername" /></td>
</tr>
<july:separator/>
<tr>
        <td class="title"><bean:message key="label.invpos.storage"/>:</td>
        <td><bean:write name="InvActForm" property="storagename" /></td>
</tr>
<july:separator/>
<tr>
        <td class="text"><july:reqmark><bean:message key="label.invpos.num"/>:</july:reqmark></td>
        <td>
           <july:string property="order" size="5" insertable="true" updatable="true" />
        </td>
</tr>
<july:separator/>
<tr>
	<td class="text"><july:reqmark><bean:message key="label.invpos.resource"/>:</july:reqmark></td>
	<td>
		<logic:notEqual name="InvActForm" property="type" value="P">
			<july:string property="resourcecode" styleId="resourcecode" size="5" insertable="true" updatable="true" />

			<%if(!browseBySerial){%>
				<july:lookupbutton action="/ShowResourceLookupList.do" styleId="resl" fieldNames="resourcecode;resourcemodel;resourcename" newWindowName="resourcelookup" insertable="true" updatable="true"/>
			<%} else {
				String s = "/ShowResourceLookupBySerialList.do?snumber=";
				%>
				<july:lookupbutton action="<%= s + aform.getSerialnumber() %>" styleId="resl" fieldNames="resourcecode;resourcemodel;resourcename" newWindowName="resourcelookup" insertable="true" updatable="true" image="lookup_red"/>
			<%}%>
			
			<html:text size="25" style="FONT-FAMILY: Verdana,Arial; FONT-SIZE: 10pt; background-color: DCDCDC;" property="resourcemodel" readonly="true"/>			
			<html:text size="25" style="FONT-FAMILY: Verdana,Arial; FONT-SIZE: 10pt; background-color: DCDCDC;" property="resourcename" readonly="true"/>
		</logic:notEqual>
		<logic:equal name="InvActForm" property="type" value="P">
			<july:string property="resourcecode" styleId="resourcecode" size="5" insertable="true" updatable="true" />
			<july:lookupbutton action="/ShowI13nRessetLookupList.do" styleId="resl" fieldNames="resourcecode;resourcemodel;resourcename" insertable="true" updatable="true" onclick="set_opt_params_resl('?document='+document.all.document.value)"/>
			<html:text size="25" style="FONT-FAMILY: Verdana,Arial; FONT-SIZE: 10pt; background-color: DCDCDC;" property="resourcemodel" readonly="true"/>			
			<html:text size="25" style="FONT-FAMILY: Verdana,Arial; FONT-SIZE: 10pt; background-color: DCDCDC;" property="resourcename" readonly="true"/>
		</logic:equal>
	</td>
</tr>
<july:separator/>
<tr>
	<td class="text"><bean:message key="label.invpos.configuration"/>:</td>
	<td><july:string property="configuration" size="30" insertable="true" updatable="true" /></td>
</tr>
<july:separator/>
<tr>
	<td class="text"><july:reqmark><bean:message key="label.invpos.qty"/>:</july:reqmark></td>
	<td><july:string property="qtystr" size="10" insertable="true" updatable="true" /></td>
</tr>
<july:separator/>
<tr>
	<td class="text"><july:reqmark><bean:message key="label.invpos.price"/>:</july:reqmark></td>
	<td><july:string property="pricestr" size="10" insertable="true" updatable="true" /></td>
</tr>
<july:separator/>
<tr>
	<td class="text"><bean:message key="label.invpos.sum"/>:</td>
	<td><july:string property="sumstr" size="15" insertable="false" updatable="false" /></td>
</tr>
<july:separator/>
<tr>
	<td class="text"><bean:message key="label.invpos.serialnum"/>:</td>
        <td>
		   <july:string property="serialnumber" size="15" insertable="true" updatable="true" />&nbsp;<input type="image" src="/images/copybtn.gif" width="16" height="16" name="copybtn" onclick="copy2manuf();return false;"/>
		   <logic:equal name="InvActPosForm" property="action" value="Add"><INPUT TYPE="IMAGE" NAME="submit" VALUE="1" SRC="/images/searchsn.gif" ALT="Найти по карточке" onClick="utype.value = 'S';"></logic:equal>
		   <logic:equal name="InvActPosForm" property="action" value="Edit"><INPUT TYPE="IMAGE" NAME="submit" VALUE="1" SRC="/images/searchsn.gif" ALT="Найти по карточке" onClick="utype.value = 'S';"></logic:equal>
        </td>
</tr>
<july:separator/>
<tr>
	<td class="text"><bean:message key="label.manufserial"/>:</td>
        <td>
		   <july:string property="manufserial" size="15" insertable="true" updatable="true" />
        </td>
</tr>
<july:separator/>
<tr>
        <td class="text"><bean:message key="label.invpos.partnum"/>:</td>
        <td>
           <july:string property="party" size="15" insertable="true" updatable="true" />
		   <logic:equal name="InvActPosForm" property="action" value="Add"><INPUT TYPE="IMAGE" NAME="submit" VALUE="2" SRC="/images/searchsn.gif" ALT="Найти по карточке" onClick="utype.value = 'P';"></logic:equal>
		   <logic:equal name="InvActPosForm" property="action" value="Edit"><INPUT TYPE="IMAGE" NAME="submit" VALUE="2" SRC="/images/searchsn.gif" ALT="Найти по карточке" onClick="utype.value = 'P';"></logic:equal>
        </td>
</tr>
<july:separator/>
<tr>
       <td class="text"><bean:message key="label.invpos.boxed"/></td>
       <td>
			<july:checkbox property="boxed" insertable="true" updatable="true" value="true"/><html:hidden property="boxed" value="false" />
       </td>
</tr>
<july:separator/>
<tr>
       <td class="text"><bean:message key="label.invpos.broken"/></td>
       <td>
			<july:checkbox property="broken" insertable="true" updatable="true" value="true"/><html:hidden property="broken" value="false"/>
       </td>
</tr>
<july:separator/>
<tr>
        <td class="text"><bean:message key="label.invpos.owner"/>:</td>
        <td>
			<july:select collection="organizations" property="ownercode" insertable="true" updatable="true">
				<html:options collection="organizations" property="organization" labelProperty="name"/>
			</july:select>
        </td>
</tr>
<july:separator/>
<tr>
       <td class="text"><bean:message key="label.invpos.contract"/>:</td>
       <td>
			<july:string property="contractcode" styleId="contractcode" size="5" insertable="true" updatable="true" />
			<july:lookupbutton action="/ShowContractLookupList.do" styleId="ctl" fieldNames="contractcode;contractname" insertable="true" updatable="true" newWindowName="contractLookup" onclick="set_opt_params_ctl('?allcontragent=true'+'&owner='+document.all.ownercode.options[document.all.ownercode.selectedIndex].value+'&allowner=false');"/>
			<july:string size="35" property="contractname" styleId="contractname" insertable="false" updatable="false" />
       </td>
</tr>
<july:separator/>
<tr>
       <td class="text"><bean:message key="label.invpos.cordocnum"/>:</td>
       <td>
		<july:string size="20" property="cordocnum" styleId="cordocnum" insertable="true" updatable="true" />
       </td>
</tr>
<july:separator/>
<logic:equal name="InvActForm" property="type" value="A">
    <tr>
	<td class="text"><july:reqmark><bean:message key="label.fitplace"/>:</july:reqmark></td>
	<td>
		<july:string property="fitplace" size="20" insertable="true" updatable="true" />
	</td>
    </tr>

    <july:separator/>
</logic:equal>
<tr>
	<td class="text"><bean:message key="label.invpos.note"/>:</td>
        <td>
           <july:string property="note" size="35" insertable="true" updatable="true" />
        </td>
</tr>
<july:separator/>
<july:formbuttons/>
<july:separator/>
</table>
</july:editform>

