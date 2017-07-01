<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.siteinfo.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<july:editform action="/ProcessPhoto.do" enctype="multipart/form-data">

<table class="main">

<%-- DD
    <tr class="title">
    	<td class="title" colspan="2">
           <%--<html:link page="/ShowPositionList.do" styleClass="navigator"><bean:message key="label.position"/></html:link> --%>
		   <jsp:include page="/mapLinks.jsp" flush="true"></jsp:include>
           <july:sepmark/> 
           <html:link page="/EditPosition.do?action=View" paramId="storageplace" paramName="PhotoForm" paramProperty="poscode" styleClass="navigator"><bean:message key="label.workresponsibility.position"/></html:link> 
           <july:sepmark/> 
           <html:link page="/ShowPhotoList.do" styleClass="navigator"><bean:message key="label.photos"/></html:link>
           <july:sepmark/> 
           <july:actionname/></td>
    </tr>
-->

    <july:separator/>    
	<july:formbuttons/>   
    <july:separator/>

    <tr>
        <td class="title" colspan="2"><july:actionalert/></td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.code"/>:</july:reqmark></td>
        <td>
           <july:string property="photo" size="5" insertable="false" updatable="false" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.photo.posname"/>:</july:reqmark></td>
        <td>
          <july:string property="poscode" styleId="poscode" size="5" insertable="false" updatable="false" />
          <july:lookupbutton action="/ShowPositionLookupList.do" styleId="posl" fieldNames="poscode;posid;posname" insertable="false" updatable="false" />
          <july:string size="10" property="posid" styleId="posid"  insertable="false" updatable="false" />
          <july:string size="35" property="posname" styleId="posname"  insertable="false" updatable="false" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.photo.date"/>:</july:reqmark></td>
        <td>
           <july:date property="dateFrm" insertable="true" updatable="true" />
		   
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.photo.description"/>:</july:reqmark></td>
        <td>
           <july:textarea property="description" cols="50" rows="2" insertable="true" updatable="true" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.photo.filename"/>:</july:reqmark></td>
        <td>
           <html:file property="imageFrm" size="35" styleClass="editsmall"/>
           <july:string property="filename" size="35" insertable="false" updatable="false"/>
        </td>
    </tr>
    
    <july:separator/>
<tr>
        <td class="text"><bean:message key="label.photo.photographer"/></td>
        
		<td><july:string property="photographerId" styleId="photographerId" size="5" insertable="true" updatable="true" />
    	
		<july:lookupbutton action="/ShowWorkerLookupList.do" styleId="r1l" fieldNames="photographerId;photographerName" onclick="set_opt_params_r1l('?photographerId='+document.all.photographerId.value)" insertable="true" updatable="true" />
    	<july:string size="33" property="photographerName" styleId="photographerName" insertable="false" updatable="false" /></td>
</tr>
<july:separator/>
    <july:formbuttons/>   
    <july:separator/>

<%-- DD
	
	<tr class="title">
    	<td class="title" colspan="2">
		   <jsp:include page="/mapLinks.jsp" flush="true"></jsp:include>
           <july:sepmark/> 
           <html:link page="/EditPosition.do?action=View" paramId="storageplace" paramName="PhotoForm" paramProperty="poscode" styleClass="navigator"><bean:message key="label.workresponsibility.position"/></html:link> 
           <july:sepmark/> 
           <html:link page="/ShowPhotoList.do" styleClass="navigator"><bean:message key="label.photos"/></html:link>
           <july:sepmark/> 
           <july:actionname/></td>
    </tr>
    <july:separator/>
--%>

</table>

</july:editform>

