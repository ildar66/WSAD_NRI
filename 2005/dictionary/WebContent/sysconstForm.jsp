<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<july:editform action="/ProcessSysconst.do">

<table class="main">
<%--
    <tr class="title">
    	<td class="title" colspan="2">
           <html:link page="/ShowSysconstList.do" styleClass="navigator"><bean:message key="label.sysconst"/></html:link> 
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
        <td class="text"><july:reqmark><bean:message key="label.sysconst.id"/>:</july:reqmark></td>
        <td>
           <july:string property="id" size="50" insertable="true" updatable="false" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><bean:message key="label.sysconst.charvalue"/>:</td>
        <td>
          <july:string property="charvalue" size="25" insertable="true" updatable="true" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><bean:message key="label.sysconst.intvalue"/>:</td>
        <td>
          <july:string property="intvaluestr" size="25" insertable="true" updatable="true" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><bean:message key="label.sysconst.datevalue"/>:</td>
        <td>
          <july:date property="datevaluestr" size="25" insertable="true" updatable="true" required="false"/>
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><bean:message key="label.sysconst.decimalvalue"/>:</td>
        <td>
          <july:string property="decimalvaluestr" size="25" insertable="true" updatable="true" />
        </td>
    </tr>
    
    <july:separator/>
    
    <july:formbuttons/>
    
    <july:separator/>
    
</table>


</july:editform>

