<%@ page language = "java" %>

<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.dictionary.*" %>

<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<%   
	String action = null;
	String form = null;
	String navt = "L";
	switch (ParamsParser.getState(pageContext)) {
		case APPStates.REPEATER_RES_EDIT_WN:
	        	action = "/ProcessRepeaterResourceWN.do";
			form = "RepeaterResourceWNForm";
			navt = "R";
        	break;
		case APPStates.REPEATER_EDIT:
	        	action = "/ProcessRepeater.do";
			form = "RepeaterForm";
			navt = "L";
        	break;
	}
%>

<july:editform action="<%=action%>">

<script language="javascript">
function rwplOnSelect() {
	document.all['resourcesubtypeFrm'].value = '';
	document.all['resourcesubtypename'].value = '';
}
function checkFilter() {
	if(document.all.islinear[0].checked) {
		document.all.bandwidthFrm.disabled = false;
		document.all.bandwidthFrm.className = 'edit';
		document.all.numchanalsFrm.disabled = true;
		document.all.numchanalsFrm.className = 'editdisabled';
	} else {
		document.all.bandwidthFrm.disabled = true;
		document.all.bandwidthFrm.className = 'editdisabled';
		document.all.numchanalsFrm.disabled = false;
		document.all.numchanalsFrm.className = 'edit';
	}
}
</script>

<html:hidden property="resource"/>
<html:hidden property="complect"/>

<%String cpupdate = "true";%>
<logic:equal name="<%=form%>" property="isresourceused" value="true"><%cpupdate = "false";%></logic:equal>

<table class="main">

<tr><td colspan="3">
	<TABLE class="main" border="0" cellpadding="0" cellspacing="0" vAlign=top height="100%">
		<TR class="title" style="height:15">
		<TD class="title">
		<july:statenavigator/>
		</TD>
		</TR>
	</table>
	</td></tr>

<july:errors/>

<july:separator/>

<july:formbuttons/>

<july:separator/>
	
<tr>
	<td class="title" colspan="2"><july:actionalert/></td>
</tr>

<july:separator/>
    
<tr>
	<td class="text"><july:reqmark><bean:message key="label.restype"/></july:reqmark>:</td>
	<td>
		<july:string property="resourcetype" size="5" insertable="true" updatable="true" onkeypress="rwplOnSelect();"/>
		<july:lookupbutton action="/ShowRestypeLookupList.do" styleId="rwpl" fieldNames="resourcetype;resourcetypename" insertable="true" updatable="true" onselect="rwplOnSelect();"/>
		<july:string size="35" property="resourcetypename" insertable="false" updatable="false" />
	</td>
</tr>
    
<july:separator/>
    
<tr>
	<td class="text"><july:reqmark><bean:message key="label.subtype"/>:</july:reqmark></td>
	<td>
		<july:string property="resourcesubtypeFrm" styleId="ressbtype" size="5" insertable="true" updatable="true" />
		<july:lookupbutton action="/ShowRessbtypeLookupList.do" styleId="wpl" fieldNames="resourcesubtypeFrm;resourcesubtypename" onclick="set_opt_params_wpl('?resourcetype='+document.all.resourcetype.value)" insertable="true" updatable="true" />
		<july:string size="35" property="resourcesubtypename" styleId="ressbtypename" insertable="false" updatable="false" />
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
		<july:string property="manufacturerFrm" styleId="manufacturerFrm" size="5" insertable="true" updatable="true" />
		<july:lookupbutton action="/ShowOrganizationLookupList.do" styleId="orgl" fieldNames="manufacturerFrm;manufacturername" insertable="true" updatable="true" />
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
	<td colspan="2" class="text">
<bean:message key="label.resource.complectpart"/>:&nbsp;<july:checkbox styleClass="text" property="complectpart" insertable="true" updatable="true" />&nbsp;&nbsp;&nbsp;
<bean:message key="label.resource.active"/>:&nbsp;<july:checkbox styleClass="text" property="active" insertable="true" updatable="true" />&nbsp;&nbsp;&nbsp;
<bean:message key="label.resource.boxable"/>:&nbsp;<july:checkbox styleClass="text" property="boxable" insertable="true" updatable="true" />&nbsp;&nbsp;&nbsp;
<bean:message key="label.resource.priceable"/>:&nbsp;<july:checkbox styleClass="text" property="priceable" insertable="true" updatable="true" />&nbsp;
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
	<td class="text"><bean:message key="label.repeater.power"/>:</td>
	<td>
		<july:string size="10" property="reppowerFrm" insertable="true" updatable="true" />
	</td>
</tr>

<july:separator/>          

<tr>
	<td class="text"><bean:message key="label.repeater.polosovoi"/>:</td>
	<td>
		<july:checkbox styleClass="text" property="islinear" insertable="true" updatable="true" onclick="checkFilter();"/>
	</td>
</tr>

<july:separator/>          

<tr>
	<td class="text"><bean:message key="label.repeater.bandwidth"/>:</td>
	<td>
		<july:string size="10" property="bandwidthFrm" insertable="true" updatable="true" />
	</td>
</tr>

<july:separator/>          

<tr>
	<td class="text"><bean:message key="label.repeater.numchanals"/>:</td>
	<td>
                <july:string size="10" property="numchanalsFrm" insertable="true" updatable="true" />
	</td>
</tr>

<july:separator/>

<july:formbuttons/>

<july:separator/>
    
</table>

<script language="javascript">
checkFilter();
</script>

</july:editform>


