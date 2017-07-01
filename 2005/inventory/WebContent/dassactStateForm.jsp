<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<july:editform action="/ProcessDAssactst.do">

<html:hidden property="doc"/>
<html:hidden property="blankindex"/>
<html:hidden property="blanknumber"/>
<html:hidden property="blankdate.string"/>
<html:hidden property="oldDocumentState"/>
<html:hidden property="newDocumentState"/>

<bean:define id="docCode" name="DAssactstForm" property="doc" scope="request" type="java.lang.Integer"/>
<july:inventorycalcerrors document="<%= docCode %>"/>

<table class="main">
    <tr class="title">
    	<td class="title" colspan="2">
           <html:link page="/ShowDAssactList.do" styleClass="navigator"><bean:message key="label.dassacts"/></html:link> 
           <july:sepmark/> 
           <july:currmark><bean:message key="label.state"/></july:currmark></td>
    </tr>

    <july:separator/>
    
    <logic:equal name="DAssactstForm" property="oldDocumentState" value="1">
        <tr>
            <td class="title" colspan="2"><FONT class="attention"><bean:message key="label.dassact.tocalcstate"/></FONT></td>
        </tr>
    
        <july:separator/>
    </logic:equal>

    <logic:equal name="DAssactstForm" property="oldDocumentState" value="2">
        <tr>
            <td class="title" colspan="2"><FONT class="attention"><bean:message key="label.dassact.toenterstate"/></FONT></td>
        </tr>
    
        <july:separator/>
    </logic:equal>


	<tr>
		<td class="text"><bean:message key="label.dassactpos.document"/></td>
		<td class="text">
			<bean:message key="label.num"/>&nbsp;<bean:write name="DAssactstForm" property="blankindex"/>&nbsp;<bean:write name="DAssactstForm" property="blanknumber"/>&nbsp;<bean:message key="label.from"/>&nbsp;<bean:write name="DAssactstForm" property="blankdate.string" filter="true"/>
		</td>
	</tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><bean:message key="label.dassact.agregate"/>:</td>
        <td>
            <INPUT TYPE="HIDDEN" name="agrcode" ID="agrcode">
            <html:hidden property="agregateserial"/>
            <html:hidden property="agregatename"/>
		<bean:write name="DAssactstForm" property="agregatename"/>&nbsp;S/N:<bean:write name="DAssactstForm" property="agregateserial"/>
        </td>
    </tr>

    <july:separator/>
    
    <logic:equal name="DAssactstForm" property="oldDocumentState" value="1">
        <tr>
            <td class="text"><bean:message key="label.dassact.oldconfig"/>:</td>
            <td>
		<bean:write name="DAssactstForm" property="oldConfiguration"/>
            </td>
        </tr>
        
        <july:separator/>
        
        <tr>
            <td class="text"><bean:message key="label.dassact.newconfig"/>:</td>
            <td>
               <july:string property="newConfiguration" size="25" insertable="true" updatable="true" />
            </td>
        </tr>
    
        <july:separator/>
        
    </logic:equal>

    <logic:equal name="DAssactstForm" property="oldDocumentState" value="2">
        <tr>
            <td class="text"><bean:message key="label.dassact.oldconfig"/>:</td>
            <td>
		<bean:write name="DAssactstForm" property="newConfiguration"/>
            </td>
        </tr>
        
        <july:separator/>
        
        <tr>
            <td class="text"><bean:message key="label.dassact.newconfig"/>:</td>
            <td>
               <july:string property="oldConfiguration" size="25" insertable="true" updatable="true" />
            </td>
        </tr>
    
        <july:separator/>
        
</logic:equal>
<july:formbuttons/>
<july:separator />
</table>
</july:editform>
