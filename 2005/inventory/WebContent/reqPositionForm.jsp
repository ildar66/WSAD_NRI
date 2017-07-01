<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import="com.hps.july.inventory.formbean.*,com.hps.july.inventory.actionbean.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<july:editform action="/ProcessReqPosition.do">

<html:hidden property="docposition" />
<html:hidden property="storagecode" />
<html:hidden property="ownercode" />

<table class="main">
    
<july:separator/>
 
<july:formbuttons/>
    
<july:separator/>	

<tr>
	<td class="title" colspan="2"><july:actionalert/></td>
</tr>

<july:separator/>
    
<tr>
	<td class="title"><bean:message key="label.reqpos.document"/></td>
	<td class="title"><bean:message key="label.num"/>
		<%-- &nbsp;<bean:write name="ReqForm" property="blankindex"/> --%>
		&nbsp;<bean:write name="ReqForm" property="blanknumber"/>&nbsp;<bean:message key="label.from" />&nbsp;<bean:write name="ReqForm" property="blankdatestr"/></td>
</tr>

<july:separator/>
    
<tr>
	<td class="text"><july:reqmark><bean:message key="label.reqpos.num"/>:</july:reqmark></td>
	<td>
		<logic:equal name="ReqForm" property="readonly" value="false">
			<july:string property="orderstr" size="10" insertable="true" updatable="true" />
		</logic:equal>
		<logic:equal name="ReqForm" property="readonly" value="true">
			<july:string property="orderstr" size="10" insertable="false" updatable="false" />
		</logic:equal>
	</td>
</tr>

<july:separator/>

<tr>
	<td class="text"><bean:message key="label.reqpos.complect"/>:</td>
	<td>
		<logic:equal name="ReqForm" property="readonly" value="false">
			<july:string size="5" property="complectcode" styleId="complectcode" insertable="true" updatable="false" />
			<july:lookupbutton action="/ShowResourceSetLookupList.do" styleId="ressetl" fieldNames="complectcode;complectname;resourcecode;resourcemodel;resourcename" newWindowName="ressetlookup" insertable="true" updatable="false"/>
			<july:string size="30" property="complectname" styleId="complectname" insertable="false" updatable="false" />
		</logic:equal>
		<logic:equal name="ReqForm" property="readonly" value="true">
			<july:string size="5" property="complectcode" styleId="complectcode" insertable="false" updatable="false" />
			<july:lookupbutton action="/ShowResourceSetLookupList.do" styleId="ressetl" fieldNames="complectcode;complectname" newWindowName="ressetlookup" insertable="false" updatable="false"/>
			<july:string size="30" property="complectname" styleId="complectname" insertable="false" updatable="false" />
		</logic:equal>
	</td>
</tr>
    
<july:separator/>

<tr>
	<td class="text"><july:reqmark><bean:message key="label.reqpos.resource"/>:</july:reqmark></td>
	<td>
		<logic:equal name="ReqForm" property="readonly" value="false">
			<july:string size="5" property="resourcecode" styleId="resourcecode" insertable="true" updatable="false" />
			<july:lookupbutton action="/ShowResourceLookupList.do" styleId="resl" fieldNames="resourcecode;resourcemodel;resourcename" newWindowName="resourcelookup" insertable="true" updatable="false"/>
			<july:string size="25" property="resourcemodel" styleId="resourcemodel" insertable="false" updatable="false" />
			<july:string size="20" property="resourcename" styleId="resourcename" insertable="false" updatable="false" />
		</logic:equal>
		<logic:equal name="ReqForm" property="readonly" value="true">
			<july:string size="5" property="resourcecode" styleId="resourcecode" insertable="false" updatable="false" />
			<july:lookupbutton action="/ShowResourceLookupList.do" styleId="resl" fieldNames="resourcecode;resourcemodel;resourcename" newWindowName="resourcelookup" insertable="false" updatable="false"/>
			<july:string size="25" property="resourcemodel" styleId="resourcemodel" insertable="false" updatable="false" />
			<july:string size="20" property="resourcename" styleId="resourcename" insertable="false" updatable="false" />
		</logic:equal>
	</td>
</tr>
    
<july:separator/>
    
<tr>
	<td class="text"><bean:message key="label.reqpos.configuration"/>:</td>
	<td>
		<logic:equal name="ReqForm" property="readonly" value="false">
			<july:string property="configuration" size="35" insertable="true" updatable="false" />
		</logic:equal>
		<logic:equal name="ReqForm" property="readonly" value="true">
			<july:string property="configuration" size="35" insertable="false" updatable="false" />
		</logic:equal>
	</td>
</tr>

<july:separator/>

<tr>
	<td class="text"><bean:message key="label.reqpos.note"/>:</td>
	<td>
		<logic:equal name="ReqForm" property="readonly" value="false">
			<july:string property="notes" size="35" insertable="true" updatable="true" />
		</logic:equal>
		<logic:equal name="ReqForm" property="readonly" value="true">
			<july:string property="notes" size="35" insertable="false" updatable="false" />
		</logic:equal>
	</td>
</tr>
<%--
<july:separator/>

<tr>
	<td class="text"><july:reqmark><bean:message key="label.reqpos.fqty"/>:</july:reqmark></td>
	<td>
		<logic:equal name="ReqForm" property="readonly" value="false">
			<july:string property="fqtystr" size="15" insertable="true" updatable="true" />
		</logic:equal>
		<logic:equal name="ReqForm" property="readonly" value="true">
			<july:string property="fqtystr" size="15" insertable="false" updatable="false" />
		</logic:equal>
	</td>
</tr>
--%>    
<july:separator/>

<tr>
	<td class="text"><july:reqmark><bean:message key="label.reqpos.qty"/>:</july:reqmark></td>
	<td>
		<logic:equal name="ReqForm" property="readonly" value="false">
			<july:string property="qtystr" size="15" insertable="true" updatable="true" />
		</logic:equal>
		<logic:equal name="ReqForm" property="readonly" value="true">
			<july:string property="qtystr" size="15" insertable="false" updatable="false" />
		</logic:equal>
	</td>
</tr>
    
<july:separator/>

<july:formbuttons/>
    
<july:separator/>
    
</table>

</july:editform>

