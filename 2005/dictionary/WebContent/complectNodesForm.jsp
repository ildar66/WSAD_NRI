<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<july:editform action="/ProcessComplectNodes.do">

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
       <html:link page="/ShowComplectNodesList.do" styleClass="navigator"><bean:message key="label.complectnodes"/></html:link> 
       <july:sepmark/> 
       <july:actionname/></td>
    </tr>
--%>    
    <july:separator/>
    
<tr>
	<td class="text"><july:reqmark><bean:message key="label.complectnodes.complect"/>:</july:reqmark></td>
	<td><bean:write name="ComplectNodesListForm" property="resourcemodel" />&nbsp;<bean:write name="ComplectNodesListForm" property="resourcename" />
<%--
		<july:string property="complectcode" styleId="complectcode" size="5" insertable="true" updatable="true" />
		<july:lookupbutton action="/ShowResourceLookupList.do" styleId="wpl" fieldNames="complectcode;complectname" />
		<july:string size="30" property="complectname" styleId="complectname" insertable="false" updatable="false" />
--%>
	</td>
</tr>
    
<july:separator/>
    
<tr>
	<td class="text"><july:reqmark><bean:message key="label.complectnodes.part"/>:</july:reqmark></td>
	<td>
		<july:string property="partcode" styleId="partcode" size="5" insertable="true" updatable="true" />
		<july:lookupbutton action="/ShowResourceLookupList.do" styleId="wpl" fieldNames="partcode;modelname;partname;izm" insertable="true" updatable="true" />
		<july:string size="10" property="partmodelname" styleId="modelname" insertable="false" updatable="false" />
		<july:string size="30" property="partname" styleId="partname" insertable="false" updatable="false" />
	        <input type="hidden" name="izm" id="izm">
	</td>
</tr>
    
<july:separator/>
    
<july:formbuttons/>
    
<july:separator/>
    
</table>


</july:editform>

