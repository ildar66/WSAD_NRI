<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import="com.hps.july.inventory.formbean.*,com.hps.july.inventory.actionbean.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<july:editform action="/ProcessExternalPosition.do" styleId="ExternalPositionForm">
<%
	ExternalForm frm = (ExternalForm)request.getSession().getAttribute("ExternalForm");
	com.hps.july.inventory.formbean.ExternalPositionForm pfrm = (com.hps.july.inventory.formbean.ExternalPositionForm)request.getAttribute("ExternalPositionForm");
	boolean changable = "1".equals(frm.getDState()) && !frm.getIsautodoc() && ("Add".equals(pfrm.getAction()) || "Edit".equals(pfrm.getAction()));

	boolean editserial = "Add".equals(pfrm.getAction()); 
	boolean editparty = "Add".equals(pfrm.getAction());
	boolean editbulk = "Add".equals(pfrm.getAction());
	if("Edit".equals(pfrm.getAction())) {
		editserial = changable && "S".equals(pfrm.getPolicy());
		editparty = changable && "P".equals(pfrm.getPolicy());
		editbulk = changable && "B".equals(pfrm.getPolicy());
	}

	boolean browseBySerial = pfrm.isBrowseBySerial();
%>
<html:hidden property="outerDocPosition" />
<html:hidden property="storagecode" />
<html:hidden name="ExternalForm" property="document" />
<html:hidden property="ownercode" />
<html:hidden property="boxed" />

<script language="javascript">
function copyToFact() {
	if(ExternalPositionForm.qtystr.readOnly == false) {
		ExternalPositionForm.qtystr.value = ExternalPositionForm.outerQtystr.value;
	}
	if(ExternalPositionForm.sourcePricestr.readOnly == false) {
		ExternalPositionForm.sourcePricestr.value = ExternalPositionForm.outerPricestr.value;
	}
}
function switchMarkSerial(that) {
	if(document.all.action.value == 'Add') {
	if(that) { // boxed
		ExternalPositionForm.note.disabled = false;
		ExternalPositionForm.note.className = 'editbig';
		ExternalPositionForm.note.readOnly = false;
		ExternalPositionForm.serialnumber.disabled = true;
		ExternalPositionForm.serialnumber.className = 'editbigdisabled';
		ExternalPositionForm.serialnumber.readOnly = true;
		ExternalPositionForm.manufserial.disabled = true;
		ExternalPositionForm.manufserial.className = 'editbigdisabled';
		ExternalPositionForm.manufserial.readOnly = true;
	} else { // unboxed
		ExternalPositionForm.note.disabled = true;
		ExternalPositionForm.note.className = 'editbigdisabled';
		ExternalPositionForm.note.readOnly = true;
		ExternalPositionForm.serialnumber.disabled = false;
		ExternalPositionForm.serialnumber.className = 'editbig';
		ExternalPositionForm.serialnumber.readOnly = false;
		ExternalPositionForm.manufserial.disabled = false;
		ExternalPositionForm.manufserial.className = 'editbig';
		ExternalPositionForm.manufserial.readOnly = false;
	}
	}
}
function copy2manuf() {
	ExternalPositionForm.manufserial.value = ExternalPositionForm.serialnumber.value;
}
</script>
    
<table class="main">
<%--<tr class="title">
	<td class="title" colspan="2">
		<html:link page="/ShowExternalList.do" styleClass="navigator"><bean:message key="label.external"/></html:link> 
		<july:sepmark/> 
		<html:link page="/EditExternal.do" styleClass="navigator"><bean:message key="label.externalpos"/></html:link> 
		<july:sepmark/> 
		<july:currmark><bean:message key="label.externalpos.title"/></july:currmark>
	</td>
</tr>--%>
    
<july:separator/>
 
<july:formbuttons/>

<july:separator/>

<tr>
	<td class="title" colspan="2"><july:actionalert/></td>
</tr>

<july:separator/>
    
<tr>
	<td class="title"><bean:message key="label.externalpos.document"/></td>
	<td class="title"><bean:message key="label.num"/>
	<%-- &nbsp;<bean:write name="ExternalForm" property="blankindex"/> --%>
	&nbsp;<bean:write name="ExternalForm" property="blanknumber"/>&nbsp;<bean:message key="label.from" />&nbsp;<bean:write name="ExternalForm" property="blankdatestr"/></td>
</tr>

<july:separator/>
    
<tr>
	<td class="text"><july:reqmark><bean:message key="label.externalpos.num"/>:</july:reqmark></td>
	<td>
		<%if(changable){%>
			<july:string property="orderstr" size="10" insertable="true" updatable="true" />
		<%} else {%>
			<july:string property="orderstr" size="10" insertable="false" updatable="false" />
		<%}%>
	</td>
</tr>

<july:separator/>

<tr>
	<td class="text"><july:reqmark><bean:message key="label.externalpos.resource"/>:</july:reqmark></td>
	<td>
		<%if(changable){%>
			<july:string size="5" property="resourcecode" styleId="resourcecode" insertable="true" updatable="false" />
			
			<%if(!browseBySerial){%>
				<july:lookupbutton action="/ShowResourceLookupList.do" styleId="resl" fieldNames="resourcecode;resourcemodel;resourcename" newWindowName="resourcelookup" insertable="true" updatable="false"/>
			<%} else {
				String s = "/ShowResourceLookupBySerialList.do?snumber=";
				%>
				<july:lookupbutton action="<%= s + pfrm.getSerialnumber() %>" styleId="resl" fieldNames="resourcecode;resourcemodel;resourcename" newWindowName="resourcelookup" insertable="true" updatable="false" image="lookup_red"/>
			<%}%>

			<html:text size="25" style="FONT-FAMILY: Verdana,Arial; FONT-SIZE: 10pt; background-color: DCDCDC;" property="resourcemodel" readonly="true"/>			
			<html:text size="25" style="FONT-FAMILY: Verdana,Arial; FONT-SIZE: 10pt; background-color: DCDCDC;" property="resourcename" readonly="true"/>
		<%} else {%>
			<july:string size="5" property="resourcecode" styleId="resourcecode" insertable="false" updatable="false" />
			<%if(!browseBySerial){%>
				<july:lookupbutton action="/ShowResourceLookupList.do" styleId="resl" fieldNames="resourcecode;resourcemodel;resourcename" newWindowName="resourcelookup" insertable="false" updatable="false"/>
			<%} else {
				String s = "/ShowResourceLookupBySerialList.do?snumber=";
				%>
				<july:lookupbutton action="<%= s + pfrm.getSerialnumber() %>" styleId="resl" fieldNames="resourcecode;resourcemodel;resourcename" newWindowName="resourcelookup" insertable="false" updatable="false" image="lookup_red"/>
			<%}%>
			<html:text size="25" style="FONT-FAMILY: Verdana,Arial; FONT-SIZE: 10pt; background-color: DCDCDC;" property="resourcemodel" readonly="true"/>			
			<html:text size="25" style="FONT-FAMILY: Verdana,Arial; FONT-SIZE: 10pt; background-color: DCDCDC;" property="resourcename" readonly="true"/>
		<%}%>
	</td>
</tr>
    
<july:separator/>
    
<tr>
	<td class="text"><bean:message key="label.externalpos.configuration"/>:</td>
	<td>
		<%if(changable){%>
			<july:string property="configuration" size="35" insertable="true" updatable="true" />
		<%} else {%>
			<july:string property="configuration" size="35" insertable="false" updatable="false" />
		<%}%>
	</td>
</tr>

<july:separator/>

<tr>
	<td class="text"><bean:message key="label.externalpos.boxed"/></td>
	<td>
		<july:checkbox property="boxed" insertable="true" updatable="false" value="true" onclick="switchMarkSerial(ExternalPositionForm.boxed[0].checked);"/>
	</td>
</tr>
    
<july:separator/>

<tr>
	<td class="text"><bean:message key="label.externalpos.mark"/>:</td>
	<td>
		<%if(changable && "Edit".equals(pfrm.getAction()) && pfrm.getBoxed() != null && pfrm.getBoxed().booleanValue()) {%>
			<july:string property="note" size="35" insertable="true" updatable="true" />
		<%} else {%>
			<july:string property="note" size="35" insertable="false" updatable="false" />
		<%}%>
	</td>
</tr>

<july:separator/>

<tr>
	<td class="text"><july:reqmark><bean:message key="label.externalpos.doc.cnt"/>:</july:reqmark></td>
	<td>
		<%if(changable){%>
			<july:string property="outerQtystr" size="15" insertable="true" updatable="true" />
		<%} else {%>
			<july:string property="outerQtystr" size="15" insertable="false" updatable="false" />
		<%}%>
	</td>
</tr>
    
<july:separator/>

<tr>
	<td class="text"><bean:message key="label.externalpos.doc.price"/>:</td>
	<td>
		<%if(changable){%>
			<july:string property="outerPricestr" size="15" insertable="true" updatable="true" />&nbsp;<bean:write name="ExternalForm" property="currencyname" filter="true"/>&nbsp;<html:button property="copybtn" onclick="copyToFact();return false;"><bean:message key="label.externalpos.button.copytofact"/></html:button>
		<%} else {%>
			<july:string property="outerPricestr" size="15" insertable="false" updatable="false" />
		<%}%>
	</td>
</tr>
    
<july:separator/>

<tr>
	<td class="text"><july:reqmark><bean:message key="label.externalpos.fact.cnt"/>:</july:reqmark></td>
	<td>
		<%if(changable){%>
			<%if(editserial){%>
				<july:string property="qtystr" size="15" insertable="true" updatable="false" />
			<%} else {%>
				<july:string property="qtystr" size="15" insertable="true" updatable="true" />
			<%}%>
		<%} else {%>
			<july:string property="qtystr" size="15" insertable="false" updatable="false" />
		<%}%>
	</td>
</tr>
    
<july:separator/>
    
<tr>
	<td class="text"><bean:message key="label.externalpos.fact.price"/>:</td>
	<td>
		<july:string property="sourcePricestr" size="15" insertable="true" updatable="true" />&nbsp;<bean:write name="ExternalForm" property="currencyname" filter="true"/>
	</td>
</tr>
    
<july:separator/>
    
<tr>
	<td class="text"><bean:message key="label.externalpos.serialnum"/>:</td>
	<td>
		<%if(editserial){%>
			<july:string property="serialnumber" size="15" insertable="true" updatable="false" /><%if("Add".equals(pfrm.getAction())){%>&nbsp;<input type="image" src="/images/copybtn.gif" width="16" height="16" name="copybtn" onclick="copy2manuf();return false;"/><%}%>
		<%} else {%>
			<july:string property="serialnumber" size="15" insertable="false" updatable="false" />
		<%}%>
	</td>
</tr>
    
<july:separator/>
    
<tr>
	<td class="text"><bean:message key="label.manufserial"/>:</td>
	<td>
		<%if(editserial){%>
			<july:string property="manufserial" size="15" insertable="true" updatable="false"/>
		<%} else {%>
			<july:string property="manufserial" size="15" insertable="false" updatable="false"/>
		<%}%>
	</td>
</tr>
    
<july:separator/>
    
<tr>
	<td class="text"><bean:message key="label.externalpos.partynum"/>:</td>
	<td>
		<%if(editparty){%>
			<july:string property="party" size="15" insertable="true" updatable="true" />
		<%} else {%>
			<july:string property="party" size="15" insertable="false" updatable="false" />
		<%}%>
	</td>
</tr>
<july:separator/>
<july:formbuttons/>
<july:separator/>
</table>
<script language="javascript">
switchMarkSerial(ExternalPositionForm.boxed[0].checked);
</script>
</july:editform>

