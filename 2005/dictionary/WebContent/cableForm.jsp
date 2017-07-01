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
		case APPStates.CABLE_RES_EDIT:
	        	action = "/ProcessCableResource.do";
			form = "CableResourceForm";
			navt = "R";
        	break;
		case APPStates.CABLE_EDIT:
	        	action = "/ProcessCable.do";
			form = "CableForm";
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

function initAdditional(){
	document.all.unitFrm.value="2";
}
</script>

<html:hidden property="resource"/>
<html:hidden property="complect"/>

<html:hidden property="resourcesubtype"/>

<%String cpupdate = "true";%>
<logic:equal name="<%=form%>" property="isresourceused" value="true"><%cpupdate = "false";%></logic:equal>
	
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
	<td colspan="2">
		<table class="main">
		<tr class="title" style="background-color:#D6EBFF;">
			<july:headercolumn key="label.cable.band" colType="string"/>
			<july:headercolumn key="label.cable.formloss" colType="string"/>
		</tr>

		<july:separator/>

		<tr>
	            	<td class="text">800</td>
			<td class="text"><july:string size="35" property="lost800Frm" insertable="true" updatable="true" /></td>
		</tr>

		<july:separator/>

		<tr>
	            	<td class="text">900</td>
			<td class="text"><july:string size="35" property="lost900Frm" insertable="true" updatable="true" /></td>
		</tr>

		<july:separator/>

		<tr>
	            	<td class="text">1800</td>
			<td class="text"><july:string size="35" property="lost1800Frm" insertable="true" updatable="true" /></td>
		</tr>

		<july:separator/>

		<tr>
	            	<td class="text">2000</td>
			<td class="text"><july:string size="35" property="lost2000Frm" insertable="true" updatable="true" /></td>
		</tr>

		<july:separator/>
		
		<tr>
			<td class="text"><bean:message key="label.resource.cablediameter"/>:</td>
			<td>
				<july:select collection="cablediameters" property="cableDiam" insertable="true" updatable="true">
					<july:options collection="cablediameters" property="id" labelProperty="diamname"/>
				</july:select>
			</td>
		</tr>
		
		<july:separator/>

		</table>
	</td>
</tr>

<july:formbuttons/>

<july:separator/>
    
</table>

<script language="javascript">
initAdditional();
</script>

</july:editform>


