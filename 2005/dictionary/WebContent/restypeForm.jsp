<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<july:editform action="/ProcessRestype.do">

<table class="main">
<%--
    <tr class="title">
    	<td class="title" colspan="2">
           <html:link page="/ShowRestypeList.do" styleClass="navigator"><bean:message key="label.restypes"/></a> 
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
    
<tr><%--da 07feb2003 made field optional--%>
	<td class="text"><bean:message key="label.restype.code"/>:</td>
	<td>
		<july:string property="resourcetype" size="5" insertable="false" updatable="false" />
	</td>
</tr>
    
<july:separator/>
    
<tr>
	<td class="text"><july:reqmark><bean:message key="label.restype.name"/>:</july:reqmark></td>
	<td>
		<july:string property="name" size="35" insertable="true" updatable="true" />
	</td>
</tr>

<july:separator/>

<july:formbuttons/>

<july:separator/>

</table>

</july:editform>

