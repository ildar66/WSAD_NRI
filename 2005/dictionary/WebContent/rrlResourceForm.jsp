<%@ page language = "java" %>

<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.dictionary.*" %>

<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<july:editform action="/ProcessRRLResource.do">

<script language="javascript">
function rwplOnSelect() {
	document.all['resourcesubtypeFrm'].value = '';
	document.all['resourcesubtypename'].value = '';
}

</script>

<%String cpupdate = "true";%>
<%
	com.hps.july.dictionary.formbean.RRLAntenaForm rrlAntenaForm = (com.hps.july.dictionary.formbean.RRLAntenaForm)pageContext.findAttribute("RRLAntenaForm");
	pageContext.setAttribute("resource", new Integer(rrlAntenaForm.getResource()));
	if(rrlAntenaForm.getIsresourceused()) {
		cpupdate = "false";
	}
%>

<html:hidden property="resource"/>
<html:hidden property="complect"/>

<html:hidden property="resourcesubtype"/>

<table class="main">

<july:separator/>

<july:formbuttons/>

<july:separator/>	

<tr>
	<td class="title" colspan="2"><july:actionalert/></td>
</tr>

<july:separator/>

<tr>
	<td class="text"><bean:message key="label.resource.nricodeLabel"/>:</td>
	<td>
		<july:string size="5" property="resource" insertable="false" updatable="false" />
	</td>
</tr>

<july:separator/>

<tr>
	<td class="text"><july:reqmark><bean:message key="label.name"/></july:reqmark>:</td>
	<td>
		<july:string size="35" property="name" insertable="true" updatable="true" />
	</td>
</tr>
    
<july:separator/>
    
<tr>
	<td class="text"><july:reqmark><bean:message key="label.repeater.model"/></july:reqmark>:</td>
	<td>
		<july:string size="35" property="model" insertable="true" updatable="true" />
	</td>
</tr>
    
<july:separator/>
    
<tr>
	<td class="text"><bean:message key="label.repeater.manufacturer"/>:</td>
	<td>
		<july:string property="manufidFrm" styleId="manufidFrm" size="5" insertable="true" updatable="true" />
		<%--<july:lookupbutton action="/ShowOrganizationLookupList.do" styleId="orgl" fieldNames="manufacturerFrm;manufacturername" insertable="true" updatable="true" />--%>
		<july:lookupbutton action="/ShowEquipmanufLookupList.do" styleId="orgl" fieldNames="manufidFrm;manufacturername" insertable="true" updatable="true" />
		<july:string size="35" property="manufacturername" styleId="manufacturername" insertable="false" updatable="false" />
        </td>
</tr>
    
<july:separator/>
    
<tr>
	<td class="text"><bean:message key="label.resource.manucode"/>:</td>
	<td>
		<july:string property="manucode" size="35" insertable="true" updatable="true" />
	</td>
</tr>

<july:separator/>
    
<tr>
	<td class="text"><july:reqmark><bean:message key="label.resource.unit"/></july:reqmark>:</td>
	<td>
		<july:select collection="units" property="unitFrm" insertable="true" updatable="true">
			<html:options collection="units" property="unit" labelProperty="name"/>
		</july:select>
	</td>
</tr>
    
<july:separator/>
    
<tr>
	<td class="text"><bean:message key="label.resource.notes"/>:</td>
	<td>
		<july:string property="notes" size="35" insertable="true" updatable="true" />
	</td>
</tr>
    
<july:separator/>
    
<tr>
	<td></td>
	<td colspan="2" class="text">
		<bean:message key="label.resource.active"/>:&nbsp;<july:checkbox styleClass="text" property="active" insertable="true" updatable="true" />&nbsp;&nbsp;&nbsp;
		<bean:message key="label.resource.nfsdeny"/>&nbsp;&nbsp;&nbsp;<july:checkbox styleClass="text" property="disablenfscodes" insertable="true" updatable="true" />&nbsp;
	</td>
</tr>
    
<july:separator/>

<tr>
	<td class="text"><july:reqmark><bean:message key="label.resource.countpolicy"/>:</july:reqmark></td>
	<td>
		<july:radio styleClass="text" insertable="true" updatable="<%=cpupdate%>" property="countpolicy" value="S"/><bean:message key="label.resource.countpolicys"/>&nbsp;&nbsp;&nbsp;
		<july:radio styleClass="text" insertable="true" updatable="<%=cpupdate%>" property="countpolicy" value="P"/><bean:message key="label.resource.countpolicyp"/>&nbsp;&nbsp;&nbsp;
		<july:radio styleClass="text" insertable="true" updatable="<%=cpupdate%>" property="countpolicy" value="B"/><bean:message key="label.resource.countpolicyb"/>
	</td>
</tr>

<july:separator/>

<tr class="title">
	<td class="title" colspan="2"><bean:message key="label.cable.techparams"/></td>
</tr>

<july:separator/>          

<tr>
	<td class="text"><july:reqmark><bean:message key="label.rrlresource.freqdev"/>:</july:reqmark></td>
	<td class="text">
		<july:string size="1" property="freqdevlowkFrm" insertable="true" updatable="true" />
    <!--bean:message key="label.rrlresource.multiplybyten" /-->
	x 10<sup>-</sup>
 		<july:string size="1" property="freqdevlowlog10Frm" insertable="true" updatable="true" />
 		<!-- futher hidden properties won't bee needed later - remove them! -->
		<html:hidden property="freqdevhighkFrm" value="0"/>
		<html:hidden property="freqdevhighlog10Frm" value="0"/>
	</td>
</tr>

<july:separator/>

<tr>
	<td class="text"><july:reqmark><bean:message key="label.rrlresource.mkkrrecomm"/>:</july:reqmark></td>
	<td class="text">
		<july:string size="35" property="mkkrrecomm" insertable="true" updatable="true" />
	</td>
</tr>

<july:separator/>

<tr>
	<td class="text"><july:reqmark><bean:message key="label.rrlresource.protocolnum"/>:</july:reqmark></td>
	<td class="text">
		<july:string size="35" property="protocolnum" insertable="true" updatable="true" />
	</td>
</tr>

<july:separator/>

<tr>
	<td class="text"><july:reqmark><bean:message key="label.rrlresource.protocoldate"/>:</july:reqmark></td>
	<td class="text">
    <july:date property="protocoldateFrm" insertable="true" updatable="true"/>
	</td>
</tr>

<july:separator/>

<july:formbuttons/>

<july:separator/>

</table>

<% if("Edit".equals(rrlAntenaForm.getAction()) || "Delete".equals(rrlAntenaForm.getAction())) {
%>
<%@include file="/rrlResourceParamsList.jspf" %>
<%@include file="/rrlResourceSpeedParamsList.jspf" %>
<% } %>

</july:editform>




