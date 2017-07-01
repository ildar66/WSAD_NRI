<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<july:editform action="/ProcessDAssactstB.do">

<html:hidden property="doc"/>
<html:hidden property="blankindex"/>
<html:hidden property="blanknumber"/>
<html:hidden property="blankdate.string"/>
<html:hidden property="oldDocumentState"/>
<html:hidden property="newDocumentState"/>

<bean:define id="docCode" name="DAssactstBForm" property="doc" scope="request" type="java.lang.Integer"/>
<july:inventorycalcerrors document="<%= docCode %>"/>

<table class="main">
    <tr class="title">
		<td class="title" colspan="2">
			<html:link page="/ShowDAssactBList.do" styleClass="navigator"><bean:message key="label.dassactsb"/></html:link> 
			<july:sepmark/> 
			<july:currmark><bean:message key="label.state"/></july:currmark>
		</td>
    </tr>

    <july:separator/>
    
    <logic:equal name="DAssactstBForm" property="oldDocumentState" value="1">
        <tr>
            <td class="title" colspan="2"><FONT class="attention"><bean:message key="label.dassactb.tocalcstate"/></FONT></td>
        </tr>
    
        <july:separator/>
    </logic:equal>

    <logic:equal name="DAssactstBForm" property="oldDocumentState" value="2">
        <tr>
            <td class="title" colspan="2"><FONT class="attention"><bean:message key="label.dassactb.toenterstate"/></FONT></td>
        </tr>
    
        <july:separator/>
    </logic:equal>


	<tr>
		<td class="text"><bean:message key="label.dassactposb.document"/></td>
		<td class="text">
			<bean:message key="label.num"/>&nbsp;<bean:write name="DAssactstBForm" property="blankindex"/>&nbsp;<bean:write name="DAssactstBForm" property="blanknumber"/>&nbsp;<bean:message key="label.from"/>&nbsp;<bean:write name="DAssactstBForm" property="blankdate.string" filter="true"/>
		</td>
	</tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><bean:message key="label.assactb.agregate"/>:</td>
        <td>
            <INPUT TYPE="HIDDEN" name="agrcode" ID="agrcode">
            <html:hidden property="agregateserial"/>
            <html:hidden property="agregatename"/>
		<bean:write name="DAssactstBForm" property="agregatename"/>&nbsp;S/N:<bean:write name="DAssactstBForm" property="agregateserial"/>
        </td>
    </tr>

    <july:separator/>
    
    <logic:equal name="DAssactstBForm" property="oldDocumentState" value="1">
        <tr>
            <td class="text"><bean:message key="label.assactb.oldconfig"/>:</td>
            <td>
		<bean:write name="DAssactstBForm" property="oldConfiguration"/>
            </td>
        </tr>
        
        <july:separator/>
        
        <tr>
            <td class="text"><bean:message key="label.assactb.newconfig"/>:</td>
            <td>
               <july:string property="newConfiguration" size="25" insertable="true" updatable="true" />
            </td>
        </tr>
    
        <july:separator/>
        
    </logic:equal>

    <logic:equal name="DAssactstBForm" property="oldDocumentState" value="2">
        <tr>
            <td class="text"><bean:message key="label.assactb.oldconfig"/>:</td>
            <td>
		<bean:write name="DAssactstBForm" property="newConfiguration"/>
            </td>
        </tr>
        
<july:separator/>
<tr>
	<td class="text"><bean:message key="label.assactb.newconfig"/>:</td>
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

