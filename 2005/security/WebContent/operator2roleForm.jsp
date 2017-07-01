<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<july:editform action="/ProcessOperator2role.do">

<table class="main">
    <tr class="title">
    	<td class="title" colspan="2">
           <html:link page="/ShowPeopleList.do" styleClass="navigator"><bean:message key="label.people"/></html:link> 
           <july:sepmark/>
           <html:link page="/ShowOperatorList.do" styleClass="navigator"><bean:message key="label.operators"/></html:link> 
           <july:sepmark/>
           <html:link page="/ShowOperator2roleList.do" styleClass="navigator"><bean:message key="label.operator2roles"/></html:link> 
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
        <td class="text"><bean:message key="label.people.lastname"/>:</td>
        <td class="text"><bean:write name="operator" property="man.fullName" /></td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><bean:message key="label.operator.loginid"/></td>
        <td class="text"><bean:write name="operator" property="login" /></td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.operator2role.role"/>:</july:reqmark></td>
        <td>
          <july:string property="roles_role" styleId="role" size="15" insertable="true" updatable="true" />
          <july:lookupbutton action="/ShowRoleLookupList.do" styleId="rl" fieldNames="role;rolename" insertable="true" updatable="true" />
          <july:string size="50" property="rolename" styleId="rolename" insertable="false" updatable="false" />
        </td>
    </tr>
    
    <july:separator/>
    
    <july:formbuttons/>
    
    <july:separator/>
    
</table>

</july:editform>

