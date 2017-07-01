<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<july:editform action="/ProcessOperator.do">

<table class="main">
    <tr class="title">
    	<td class="title" colspan="2">
           <html:link page="/ShowPeopleList.do" styleClass="navigator"><bean:message key="label.people"/></html:link> 
           <july:sepmark/>
           <html:link page="/ShowOperatorList.do" styleClass="navigator"><bean:message key="label.operators"/></html:link> 
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
        <td class="text"><bean:write name="people" property="fullName" /></td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.code"/>:</july:reqmark></td>
        <td>
          <july:string property="operator" size="5" insertable="false" updatable="false" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.operator.loginid"/>:</july:reqmark></td>
        <td>
          <july:string property="login" size="25" insertable="true" updatable="true" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.operator.password"/>:</july:reqmark></td>
        <td>
        	<logic:present name="OperatorForm" property="notInCipherPassword">
        	    <july:string property="notInCipherPassword" size="25" insertable="true" updatable="true"/>
        	</logic:present>
        	<logic:notPresent name="OperatorForm" property="notInCipherPassword">
        	    <july:string property="notInCipherPassword" value="********" size="25" disabled="true"/>
        	</logic:notPresent>
       	    &nbsp;&nbsp;
       	    <logic:notEqual name="OperatorForm" property="action" value="Delete">
	       	    <INPUT TYPE="IMAGE" NAME="generatePassword" SRC="/images/izmena.gif" ALT='Изменить пароль'/>        	
        	</logic:notEqual>
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text">Логин MicroStrategy:</td>
        <td>
			<july:select style="width: 240px;" collection="msUsers" property="msucode" insertable="true" updatable="true">
				<html:option value="">_________________________</html:option>
                <july:options collection="msUsers" property="msucode" labelProperty="msuser" />
			</july:select>
        </td>
    </tr>

    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.operator.isenabled"/>:</july:reqmark></td>
        <td>
          <DIV class="edit"><july:radio property="enabled" insertable="true" updatable="true" value="true"><bean:message key="label.operator.enabled"/></july:radio></DIV>
          <DIV class="edit"><july:radio property="enabled" insertable="true" updatable="true" value="false"><bean:message key="label.operator.disabled"/></july:radio></DIV>
        </td>
    </tr>
    
    <july:separator/>
    
    <july:formbuttons/>
    
    <july:separator/>
    
</table>

</july:editform>

