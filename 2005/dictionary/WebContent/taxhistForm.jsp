<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<july:editform action="/ProcessTaxhist.do">

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
    	   <html:link page="/ShowTaxhistList.do" styleClass="navigator"><bean:message key="label.restaxhist"/></html:link>
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
        <td class="text"><july:reqmark><bean:message key="label.restaxhist.resource"/>:</july:reqmark></td>
        <td>
          <july:string property="resource" styleId="resource" size="5" insertable="true" updatable="false" />
          <july:lookupbutton action="/ShowResourceLookupList.do" styleId="wlp" fieldNames="resource;resourcemodel;resourcename" insertable="true" updatable="false" />
          <july:string size="15" property="resourcemodel" styleId="resourcemodel" insertable="false" updatable="false" />
          <july:string size="50" property="resourcename" styleId="resourcename" insertable="false" updatable="false" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.restaxhist.date"/>:</july:reqmark></td>
        <td>
          <july:date property="datestr" size="14" insertable="true" updatable="false" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.restaxhist.nds"/>:</july:reqmark></td>
        <td>
          <july:string property="ndsstr" size="5" insertable="true" updatable="true" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.restaxhist.nsp"/>:</july:reqmark></td>
        <td>
          <july:string property="nspstr" size="5" insertable="true" updatable="true" />
        </td>
    </tr>
    
    <july:separator/>
    
    <july:formbuttons/>
    
    <july:separator/>
    
</table>

</july:editform>

