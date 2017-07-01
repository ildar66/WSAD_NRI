<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<july:editform action="/ProcessComplectContent.do">

<html:hidden name="ComplectListForm" property="resourcesubtype" />

<table class="main">
<%--
    <tr class="title">
    	<td class="title" colspan="2">
       <html:link page="/ShowRestypeList.do" styleClass="navigator"><bean:message key="label.restypes"/></html:link>
       <july:sepmark/> 
       <html:link page="/ShowRessbtypeList.do" styleClass="navigator"><bean:message key="label.subtypes"/></html:link>
       <july:sepmark/> 
       <html:link page="/ShowComplectList.do" styleClass="navigator"><bean:message key="label.complect"/></html:link> 
       <july:sepmark/> 
       <html:link page="/ShowComplectContentList.do" styleClass="navigator"><bean:message key="label.content"/></html:link> 
       <july:sepmark/> 
       <july:actionname/></td>
    </tr>
--%>    
<july:separator/>
 
<july:formbuttons/>
    
<july:separator/>	

<tr>
	<td class="title" colspan="2"><july:actionalert/></td>
</tr>
    
<july:separator/>
    
<tr>
	<td class="text"><july:reqmark><bean:message key="label.complect"/>:</july:reqmark></td>
	<td>
		<bean:write name="ComplectContentListForm" property="resourcesetname" />
	</td>
</tr>
    
<july:separator/>
    
<tr>
	<td class="text"><july:reqmark><bean:message key="label.content.part"/>:</july:reqmark></td>
	<td>
		<july:string property="resourcepart" styleId="resourcepart" size="5" insertable="true" updatable="false" />
		<july:lookupbutton action="/ShowResourceLookupList.do" styleId="wpl" fieldNames="resourcepart;resourcepartmodel;resourcepartname;unitname" onclick="set_opt_params_wpl('?resourcesubtype='+document.all.resourcesubtype.value)" insertable="true" updatable="false" />
		<july:string size="15" property="resourcepartmodel" styleId="resourcepartmodel" insertable="false" updatable="false" />
		<july:string size="50" property="resourcepartname" styleId="resourcepartname" insertable="false" updatable="false" />
	</td>
</tr>
    
<july:separator/>
    
<tr>
	<td class="text"><july:reqmark><bean:message key="label.content.qty"/>:</july:reqmark></td>
	<td>
		<july:string property="qtystr" size="10" insertable="true" updatable="true" />&nbsp;
		<july:string size="15" property="unitname" styleId="unitname" insertable="false" updatable="false" />
	</td>
</tr>
    
<july:separator/>
    
<july:formbuttons/>
    
<july:separator/>
    
</table>

</july:editform>
