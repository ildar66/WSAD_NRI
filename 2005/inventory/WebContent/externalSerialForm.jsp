<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import="com.hps.july.inventory.formbean.*,com.hps.july.inventory.actionbean.*" %>

<july:editform action="/ProcessExternalSerial.do" styleId="ExternalSerialForm">
<%
	ExternalForm frm = (ExternalForm)request.getSession().getAttribute("ExternalForm");
	boolean changable = "1".equals(frm.getDState()) && !frm.getIsautodoc() && ("View".equals(frm.getAction()) || "Edit".equals(frm.getAction()));
%>

<%if(changable){%>
<script language="javascript">
function switchMarkSerial(that) {
	if(that) { // boxed
//		ExternalSerialForm.notes.disabled = false;
		ExternalSerialForm.notes.className = 'editbig';
		ExternalSerialForm.notes.readonly = false;
		ExternalSerialForm.serialnumber.disabled = true;
		ExternalSerialForm.serialnumber.className = 'editbigdisabled';
		ExternalSerialForm.serialnumber.readonly = true;
	} else { // unboxed
//		ExternalSerialForm.notes.disabled = true;
		ExternalSerialForm.notes.className = 'editbigdisabled';
		ExternalSerialForm.notes.readonly = true;
		ExternalSerialForm.serialnumber.disabled = false;
		ExternalSerialForm.serialnumber.className = 'editbig';
		ExternalSerialForm.serialnumber.readonly = false;
	}
}
</script>
<%}%>

<script language="javascript">
function copy2manuf() {
	ExternalSerialForm.manufserial.value = ExternalSerialForm.serialnumber.value;
}
</script>

<html:hidden property="docposition" />
<html:hidden property="oldSerial" />
<html:hidden property="oldManufserial" />

<table class="main">
<tr class="title">
	<td class="title" colspan="2">
		<html:link page="/ShowExternalList.do" styleClass="navigator"><bean:message key="label.external"/></html:link> 
		<july:sepmark/> 
		<html:link page="/EditExternal.do" styleClass="navigator"><bean:message key="label.externalpos"/></html:link> 
		<july:sepmark/> 
		<html:link page="/ShowExternalSerialList.do" styleClass="navigator"><bean:message key="label.externalser"/></html:link> 
		<july:sepmark/> 
		<july:actionname/>
	</td>
</tr>
    
<july:separator/>

<july:formbuttons/> 

<july:separator/>

<tr>
	<td class="title" colspan="2"><july:actionalert/></td>
</tr>

<july:separator/>
    
<tr>
	<td class="title"><bean:message key="label.externalpos.document"/></td>
	<td class="title"><bean:message key="label.num"/>&nbsp;<bean:write name="ExternalForm" property="blankindex"/>&nbsp;<bean:write name="ExternalForm" property="blanknumber"/>&nbsp;<bean:message key="label.from" />&nbsp;<bean:write name="ExternalForm" property="blankdatestr"/></td>
</tr>

<july:separator/>
    
<tr>
	<td class="text"><july:reqmark><bean:message key="label.externalpos.num"/>:</july:reqmark></td>
	<td>
		<july:string property="orderstr" size="10" insertable="true" updatable="false" />
	</td>
</tr>

<july:separator/>

<tr>
	<td class="text"><july:reqmark><bean:message key="label.externalpos.resource"/>:</july:reqmark></td>
	<td>
		<july:string size="5" property="resourcecode" styleId="resourcecode" insertable="false" updatable="false" />
		<july:string size="20" property="resourcemodel" styleId="resourcemodel" insertable="false" updatable="false" />
		<july:string size="25" property="resourcename" styleId="resourcename" insertable="false" updatable="false" />
	</td>
</tr>
    
<july:separator/>
    
<tr>
	<td class="text"><bean:message key="label.externalpos.configuration"/>:</td>
	<td>
		<july:string property="configuration" size="35" insertable="false" updatable="false" />
	</td>
</tr>

<july:separator/>

<%if(changable){%>
<tr>
	<td class="text"><bean:message key="label.externalpos.boxed"/></td>
	<td>
		<july:checkbox property="boxed" insertable="true" updatable="true" value="true" onclick="switchMarkSerial(ExternalSerialForm.boxed[0].checked);"/><html:hidden property="boxed" value="false"/>
	</td>
</tr>
    
<july:separator/>
<%} else {%>
<html:hidden property="boxed" value="false"/>
<%}%>

<tr>
	<td class="text"><bean:message key="label.externalpos.mark"/>:</td>
	<td>
		<%if(changable){%>
			<july:string property="notes" size="35" insertable="true" updatable="true" />
		<%} else {%>
			<july:string property="notes" size="35" insertable="false" updatable="false" />
		<%}%>
	</td>
</tr>

<july:separator/>

<tr>
	<td class="text"><july:reqmark><bean:message key="label.externalpos.fact.cnt"/>:</july:reqmark></td>
	<td>1</td>
</tr>
    
<july:separator/>
    
<tr>
	<td class="text"><july:reqmark><bean:message key="label.externalpos.fact.price"/>:</july:reqmark></td>
	<td>
		<july:string property="pricestr" size="15" insertable="false" updatable="false" />&nbsp;<bean:write name="ExternalForm" property="currencyname" filter="true"/>
	</td>
</tr>
    
<july:separator/>
    
<tr>
	<td class="text"><bean:message key="label.externalpos.serialnum"/>:</td>
	<td>
		<july:string property="serialnumber" size="15" insertable="true" updatable="true" />&nbsp;<IMG src="/images/copybtn.gif" width="16" height="16" name="copybtn" onclick="copy2manuf();return false;"/>
	</td>
</tr>
    
<july:separator/>
    
<tr>
	<td class="text"><bean:message key="label.manufserial"/>:</td>
	<td>
		<july:string property="manufserial" size="15" insertable="true" updatable="true" styleClass="editbig"/>
	</td>
</tr>
    
<july:separator/>

<july:formbuttons/>
    
<july:separator/>
    
</table>

<%if(changable){%>
<script language="javascript">
switchMarkSerial(ExternalSerialForm.boxed[0].checked);
</script>
<%}%>

</july:editform>
