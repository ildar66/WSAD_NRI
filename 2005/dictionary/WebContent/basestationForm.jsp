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
		case APPStates.BASESTATION_RES_EDIT:
	        	action = "/ProcessBasestationResource.do";
			form = "BasestationResourceForm";
			navt = "R";
        	break;
		case APPStates.BASESTATION_EDIT:
	        	action = "/ProcessBasestation.do";
			form = "BasestationForm";
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
</script>

<html:hidden property="resource"/>
<html:hidden property="complect"/>
<html:hidden property="resourcesubtype"/>

<%String cpupdate = "true";%>
<logic:equal name="<%=form%>" property="isresourceused" value="true"><%cpupdate = "false";%></logic:equal>
	
<table class="main">

<tr class="title">

<july:separator/>

<july:formbuttons/>

<july:separator/>	

<tr>
	<td class="title" colspan="2"><july:actionalert/></td>
</tr>

<%--left for reference
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
		<july:string property="resourcesubtypeFrm" size="5" insertable="true" updatable="true" />
		<july:lookupbutton action="/ShowRessbtypeLookupList.do" styleId="wpl" fieldNames="resourcesubtypeFrm;resourcesubtypename" onclick="set_opt_params_wpl('?resourcetype='+document.all.resourcetype.value)" insertable="true" updatable="true" />
		<july:string size="35" property="resourcesubtypename" insertable="false" updatable="false" />
	</td>
</tr>
--%>    

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
	<td class="text"><july:reqmark><bean:message key="label.cable.model"/></july:reqmark>:</td>
	<td>
		<july:string size="35" property="model" insertable="true" updatable="true" />
	</td>
</tr>
    
<july:separator/>
    
<tr>
	<td class="text"><bean:message key="label.cable.manufacturer"/>:</td>
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
	<td class="text"><bean:message key="label.basestation.standard"/>:</td>
	<td>
		<july:select collection="standards" property="standard" insertable="true" updatable="true">
			<html:options name="standards"/>
		</july:select>
	</td>
</tr>
    
<july:separator/>

<tr>
	<td class="text"><bean:message key="label.basestation.devline"/>:</td>
	<td>
		<july:string size="35" property="devline" insertable="true" updatable="true" />
	</td>
</tr>

<july:separator/>

<tr>
	<td class="text"><bean:message key="label.basestation.generation"/>:</td>
	<td>
		<july:string size="10" property="generation" insertable="true" updatable="true"/>
	</td>
</tr>
    
<july:separator/>

<tr>
	<td class="text"><bean:message key="label.basestation.releaseyear"/>:</td>
	<td>
		<july:string size="4" property="manuyear" insertable="true" updatable="true"/>
	</td>
</tr>
    
<july:separator/>

<tr>
	<td class="text"><bean:message key="label.basestation.modification"/>:</td>
	<td>
		<july:string size="35" property="modification" insertable="true" updatable="true" />
	</td>
</tr>
    
<july:separator/>

<tr>
	<td class="text"><bean:message key="label.basestation.extent"/>:</td>
	<td valign="absmiddle">
		<july:string size="10" property="lengthFrm" insertable="true" updatable="true"/>&nbsp;x&nbsp;<july:string size="10" property="widthFrm" insertable="true" updatable="true"/>&nbsp;x&nbsp;<july:string size="10" property="heightFrm" insertable="true" updatable="true"/>
	</td>
</tr>
    
<july:separator/>

<tr>
	<td class="text"><bean:message key="label.basestation.maxsectorscount"/>:</td>
	<td valign="absmiddle">
		<july:string size="10" property="maxsectorscountFrm" insertable="true" updatable="true"/>
	</td>
</tr>
    
<july:separator/>

<tr>
	<td class="text"><bean:message key="label.basestation.maxtrxcount"/>:</td>
	<td valign="absmiddle">
		<july:string size="10" property="maxtrxcountFrm" insertable="true" updatable="true"/>
	</td>
</tr>
    
<july:separator/>

<july:formbuttons/>

<july:separator/>
    
</table>

</july:editform>


