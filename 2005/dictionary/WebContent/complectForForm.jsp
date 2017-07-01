<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<july:editform action="/ProcessComplectFor.do">

<table class="main">
<%--
    <tr class="title">
    	<td class="title" colspan="2">
       <html:link page="/ShowRestypeList.do" styleClass="navigator"><bean:message key="label.restypes"/></html:link>
       <july:sepmark/> 
       <html:link page="/ShowRessbtypeList.do" styleClass="navigator"><bean:message key="label.subtypes"/></html:link>
       <july:sepmark/> 
       <html:link page="/ShowResourceList.do" styleClass="navigator"><bean:message key="label.resource"/></html:link> 
       <july:sepmark/> 
       <html:link page="/ShowComplectForList.do" styleClass="navigator"><bean:message key="label.complectfor"/></html:link> 
       <july:sepmark/> 
       <july:actionname/></td>
    </tr>
--%>    
<july:separator/>
    
<tr>
	<td class="text"><july:reqmark><bean:message key="label.complectfor.part"/>:</july:reqmark></td>
	<td><bean:write name="ComplectForListForm" property="resourcemodel" />&nbsp;<bean:write name="ComplectForListForm" property="resourcename" />
<%--
		<july:string property="complectcode" styleId="complectcode" size="5" insertable="true" updatable="true" />
		<july:lookupbutton action="/ShowResourceLookupList.do" styleId="wpl" fieldNames="complectcode;complectname" />
		<july:string size="30" property="complectname" styleId="complectname" insertable="false" updatable="false" />
--%>
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.complectfor.complect"/>:</july:reqmark></td>
        <td>
		<july:string property="complectcode" styleId="partcode" size="5" insertable="true" updatable="true" />
		<july:lookupbutton action="/ShowResourceLookupList.do" styleId="wpl" fieldNames="complectcode;modelname;complectname" insertable="true" updatable="true" />
		<july:string size="30" property="modelname" styleId="modelname" insertable="false" updatable="false" />
		<july:string size="50" property="complectname" styleId="partname" insertable="false" updatable="false" />
        </td>
    </tr>
    
    <july:separator/>
    
    <july:formbuttons/>
    
    <july:separator/>
    
</table>


</july:editform>

