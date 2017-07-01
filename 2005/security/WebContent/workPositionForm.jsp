<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<july:editform action="/ProcessWorkPosition.do">

<table class="main">
    <tr class="title">
    	<td class="title" colspan="2">
           <html:link page="/ShowWorkPositionList.do" styleClass="navigator"><bean:message key="label.workpositions"/></html:link> 
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
          <july:string property="workposition" size="5" insertable="false" updatable="false" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.name"/>:</july:reqmark></td>
        <td>
          <july:string property="name" size="35" insertable="true" updatable="true" />
        </td>
    </tr>
    
    <july:separator/>
	
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.workposition.active"/>:</july:reqmark></td>
        <td><july:checkbox property="isactive" insertable="true" updatable="true"/></td>
    </tr>
    
    <july:separator/>
    
    <july:formbuttons/>
    
    <july:separator/>
    
</table>

</july:editform>

