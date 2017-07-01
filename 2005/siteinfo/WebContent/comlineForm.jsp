<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.siteinfo.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<july:editform action="/ProcessComline.do">

<table class="main">
    <tr class="title">
    	<td class="title" colspan="2">
           <%--<html:link page="/ShowPositionList.do" styleClass="navigator"><bean:message key="label.position"/></html:link> --%>
		   <jsp:include page="/mapLinks.jsp" flush="true"></jsp:include>
           <july:sepmark/> 
           <html:link page="/EditPosition.do?action=View" paramId="storageplace" paramName="ComlineForm" paramProperty="poscode" styleClass="navigator"><bean:message key="label.workresponsibility.position"/></html:link> 
           <july:sepmark/> 
           <html:link page="/ShowComlineList.do" styleClass="navigator"><bean:message key="label.comlines"/></html:link>
           <july:sepmark/> 
           <july:actionname/></td>
    </tr>
    
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
           <july:string property="compline" size="5" insertable="false" updatable="false" />
        </td>
    </tr>
    
    <july:separator/>

    <tr>
        <td class="text"><july:reqmark><bean:message key="label.comline.type"/>:</july:reqmark></td>
        <td>
           <july:radio property="type" insertable="true" updatable="true" value="R"/><bean:message key="label.comline.typer"/>
           <july:radio property="type" insertable="true" updatable="true" value="O"/><bean:message key="label.comline.typeo"/>
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.comline.position"/>:</july:reqmark></td>
        <td>
          <july:string property="poscodeFrm" styleId="poscode" size="5" insertable="false" updatable="true" />
          <july:lookupbutton action="/ShowPositionLookupList.do" styleId="posl" fieldNames="poscode;posid;posname" insertable="false" updatable="true" />
          <july:string size="10" property="posid" styleId="posid"  insertable="false" updatable="false" />
          <july:string size="35" property="posname" styleId="posname"  insertable="false" updatable="false" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.comline.destposition"/>:</july:reqmark></td>
        <td>
          <july:string property="dposcodeFrm" styleId="dposcode" size="5" insertable="true" updatable="true" />
          <july:lookupbutton action="/ShowPositionLookupList.do" styleId="dposl" fieldNames="dposcode;dposid;dposname" insertable="true" updatable="true" />
          <july:string size="10" property="dposid" styleId="dposid"  insertable="false" updatable="false" />
          <july:string size="35" property="dposname" styleId="dposname"  insertable="false" updatable="false" />
        </td>
    </tr>
    
    <july:separator/>
        
    <july:formbuttons/>    
    <july:separator/>

	    <tr class="title">
    	<td class="title" colspan="2">
           <%--<html:link page="/ShowPositionList.do" styleClass="navigator"><bean:message key="label.position"/></html:link> --%>
		   <jsp:include page="/mapLinks.jsp" flush="true"></jsp:include>
           <july:sepmark/> 
           <html:link page="/EditPosition.do?action=View" paramId="storageplace" paramName="ComlineForm" paramProperty="poscode" styleClass="navigator"><bean:message key="label.workresponsibility.position"/></html:link> 
           <july:sepmark/> 
           <html:link page="/ShowComlineList.do" styleClass="navigator"><bean:message key="label.comlines"/></html:link>
           <july:sepmark/> 
           <july:actionname/></td>
    </tr>    
    <july:separator/>
    
</table>

</july:editform>

