<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<july:editform action="/ProcessResourcesetClass.do">

<table class="main">

    <july:separator/>
    
	<july:formbuttons/>
    
    <july:separator/>

    <tr>
        <td class="title" colspan="2"><july:actionalert/></td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.classid"/>:</july:reqmark></td>
        <td>
           <july:string property="classid" size="5" insertable="false" updatable="false" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.classname"/>:</july:reqmark></td>
        <td>
          <july:string property="classname" size="25" insertable="true" updatable="true" />
        </td>
    </tr>
    
    <july:separator/>
    
    <july:formbuttons/>
    
    <july:separator/>
    
</table>


</july:editform>

