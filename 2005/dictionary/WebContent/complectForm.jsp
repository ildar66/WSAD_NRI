<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<july:editform action="/ProcessComplect.do">

<html:hidden property="resourcesubtype" />
<html:hidden property="resourcetype" />

<table class="main">
<%--
    <tr class="title">
    	<td class="title" colspan="2">
       <html:link page="/ShowRestypeList.do" styleClass="navigator"><bean:message key="label.restypes"/></html:link>
       <july:sepmark/> 
       <html:link page="/ShowRessbtypeList.do" styleClass="navigator"><bean:message key="label.subtypes"/></html:link>
       <july:sepmark/> 
       <html:link page="/ShowComplectList.do" styleClass="navigator"><bean:message key="label.complects"/></html:link> 
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
        <td class="text"><july:reqmark><bean:message key="label.complect.code"/>:</july:reqmark></td>
        <td>
           <july:string property="resourceset" size="5" insertable="false" updatable="false" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.complect.name"/>:</july:reqmark></td>
        <td>
          <july:string property="name" size="25" insertable="true" updatable="true" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.complect.mainpart.name"/>:</july:reqmark></td>
        <td>
			<july:string property="mainpartcode" styleId="mainpartcode" size="5" insertable="true" updatable="true" />
			<july:lookupbutton action="/ShowResourceLookupList.do" styleId="wpl" fieldNames="mainpartcode;mainpartmodel;mainpartname;mainpartunit" onclick="set_opt_params_wpl('?resourcesubtype='+document.all.resourcesubtype.value+'&resourcetype='+document.all.resourcetype.value)" insertable="true" updatable="true" />
			<july:string size="15" property="mainpartmodel" styleId="mainpartmodel" insertable="false" updatable="false" />
			<july:string size="50" property="mainpartname" styleId="mainpartname" insertable="false" updatable="false" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.complect.qty"/>:</july:reqmark></td>
        <td>
			<july:string property="mainpartqtystr" size="5" insertable="true" updatable="true" />&nbsp;
		    <july:string size="15" property="mainpartunit" styleId="mainpartunit" insertable="false" updatable="false" />
        </td>
    </tr>
    
    <july:separator/>
    
    <july:formbuttons/>
    
    <july:separator/>
    
</table>


</july:editform>

