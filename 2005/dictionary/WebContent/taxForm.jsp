<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<july:editform action="/ProcessTax.do">

<table class="main">
<%--
    <tr class="title">
    	<td class="title" colspan="2">
    	   <html:link page="/ShowTaxList.do" styleClass="navigator"><bean:message key="label.restax"/></html:link>
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
        <td class="text"><july:reqmark><bean:message key="label.restax.resource.code"/>:</july:reqmark></td>
        <td>
          <input type="hidden" name="ressubtype" id="ressubtype" value='<bean:write name="TaxListForm" property="resourcesubtype"/>'>
          <july:string property="resourcecodestr" styleId="resource" size="5" insertable="true" updatable="false" />
          <july:lookupbutton action="/ShowResourceLookupList.do" styleId="wlp" onclick="set_opt_params_wlp('?resourcesubtype='+document.all.ressubtype.value)" fieldNames="resource;resourcemodel;resourcename" insertable="true" updatable="false"/>
          <july:string size="10" property="resourcemodel" styleId="resourcemodel" insertable="false" updatable="false" />
          <july:string size="30" property="resourcename" styleId="resourcename" insertable="false" updatable="false" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.restax.date"/>:</july:reqmark></td>
        <td>
			<july:date property="datestr" size="14" insertable="true" updatable="false" /> 
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.restax.nds"/>:</july:reqmark></td>
        <td>
          <july:string property="ndsstr" size="5" insertable="true" updatable="true" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.restax.nsp"/>:</july:reqmark></td>
        <td>
          <july:string property="nspstr" size="5" insertable="true" updatable="true" />
        </td>
    </tr>
    
    <july:separator/>
    
    <july:formbuttons/>
    
    <july:separator/>
    
</table>

</july:editform>

