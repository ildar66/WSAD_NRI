<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<july:editform action="/ProcessDouble.do">

<html:hidden name="ResourcesCommonListForm" property="resourcesubtype"/>

<table class="main">

    <july:separator/>
    
    <tr>
        <td class="text" COLSPAN=2><B><bean:message key="label.resource.double.description"/></B></td>
    </tr>
    
    <july:separator/>

    <tr>
        <td class="text" COLSPAN=2><FONT class="attention"><B><bean:message key="label.resource.double.message"/></B></FONT></td>
    </tr>
    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.resource.double.code"/>:</july:reqmark></td>
        <td>
            <july:string property="resource" size="15" insertable="false" updatable="false" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.resource.model"/>:</july:reqmark></td>
        <td>
           <july:string property="model" size="35" insertable="false" updatable="false" />
        </td>
    </tr>
    
    <july:separator/>
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.resource.double.name"/>:</july:reqmark></td>
        <td>
           <july:string property="name" size="50" insertable="false" updatable="false" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.resource.double.actualcode"/>:</july:reqmark></td>
        <td>
			<july:string property="actualcode" styleId="actualcode" size="5" insertable="true" updatable="true" />
			<july:lookupbutton action="/ShowResourceLookupList.do" styleId="ul"
        fieldNames="actualcode;actualmodel;actualname"
        onclick="set_opt_params_ul('?resourcesubtype='+document.all.resourcesubtype.value + '&isSign=true&sign=' + document.all.model.value)"
        insertable="true" updatable="true" />
			<july:string size="15" property="actualmodel" styleId="actualmodel" insertable="false" updatable="false" />
			<july:string size="35" property="actualname" styleId="actualname" insertable="false" updatable="false" />
        </td>
    </tr>
    
    <july:separator/>
    
    <july:formbuttons/>
    
    <july:separator/>
    
</table>


</july:editform>

