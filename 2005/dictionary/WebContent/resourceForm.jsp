<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<july:editform action="/ProcessResource.do">
<%String cpupdate = "true";%>
<logic:equal name="ResourceForm" property="isresourceused" value="true"><%cpupdate = "false";%></logic:equal>
<html:hidden property="resourcetype"/>
<html:hidden property="resourcetypename"/>
<html:hidden property="resource"/>

<table class="main">
<july:separator/>

<july:formbuttons/>
    
	<july:separator/>

	<tr>
		<td class="title" colspan="2"><july:actionalert/></td>
	</tr>

	<july:separator/>

	<html:hidden property="resclass2"/>
	<html:hidden property="resourcesubtype"/>
	
	<%--
	<tr>
		<td class="text"><bean:message key="label.restype"/>:</td>
		<td class="text"><bean:write name="ResourceForm" property="resourcetypename" /></td>
	</tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.subtype"/>:</july:reqmark></td>
        <td>
			<july:string property="resourcesubtypeFrm" styleId="ressbtype" size="5" insertable="true" updatable="true" />
			<july:lookupbutton action="/ShowRessbtypeLookupList.do" styleId="wpl" fieldNames="ressbtype;ressbtypename" onclick="set_opt_params_wpl('?resourcetype='+document.all.resourcetype.value)" insertable="true" updatable="true" />
			<july:string size="35" property="resourcesubtypename" styleId="ressbtypename" insertable="false" updatable="false" />
		</td>
    </tr>
    
    <july:separator/>
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
        <td class="text"><july:reqmark><bean:message key="label.resource.name"/>:</july:reqmark></td>
        <td>
          <july:string property="name" size="35" insertable="true" updatable="true" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.resource.model"/>:</july:reqmark></td>
        <td>
          <july:string property="model" size="35" insertable="true" updatable="true" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text">&nbsp;</td>
        <td>
		<july:checkbox styleClass="text" property="active" insertable="true" updatable="true" />&nbsp;<bean:message key="label.resource.active"/>&nbsp;&nbsp;&nbsp;
		<july:checkbox styleClass="text" property="disablenfscodes" insertable="true" updatable="true" />&nbsp;<bean:message key="label.resource.nfsdeny"/>&nbsp;&nbsp;&nbsp;
		<!--<july:checkbox styleClass="text" property="complectpart" insertable="true" updatable="true" />&nbsp;<bean:message key="label.resource.complectpart"/>&nbsp;&nbsp;&nbsp;
		<july:checkbox styleClass="text" property="boxable" insertable="true" updatable="true" />&nbsp;<bean:message key="label.resource.boxable"/>&nbsp;&nbsp;&nbsp;
		<july:checkbox styleClass="text" property="priceable" insertable="true" updatable="true" />&nbsp;<bean:message key="label.resource.priceable"/> -->

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
        <td class="text"><bean:message key="label.resource.unit"/>:</td>
        <td>
	   		<july:select collection="units" property="unitFrm" insertable="true" updatable="true">
				<html:options collection="units" property="unit" labelProperty="name"/>
			</july:select>
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><bean:message key="label.resource.manufacturer"/>:</td>
        <td>
			<july:string property="manufidFrm" styleId="manufid" size="5" insertable="true" updatable="true" />
			<%--<july:lookupbutton action="/ShowOrganizationLookupList.do" styleId="orgl" fieldNames="manufacturer;manufacturername" insertable="true" updatable="true" />--%>
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
        <td class="text"><july:reqmark><bean:message key="label.resource.countpolicy"/>:</july:reqmark></td>
        <td>
		<july:radio styleClass="text" insertable="true" updatable="<%=cpupdate%>" property="countpolicy" value="S"/><bean:message key="label.resource.countpolicys"/>
		<july:radio styleClass="text" insertable="true" updatable="<%=cpupdate%>" property="countpolicy" value="P"/><bean:message key="label.resource.countpolicyp"/>
		<july:radio styleClass="text" insertable="true" updatable="<%=cpupdate%>" property="countpolicy" value="B"/><bean:message key="label.resource.countpolicyb"/>
        </td>
    </tr>
    
    <july:separator/>
    
    <july:formbuttons/>
    
    <july:separator/>
    
</table>


</july:editform>

