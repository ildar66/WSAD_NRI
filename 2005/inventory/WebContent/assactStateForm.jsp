<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<july:editform action="/ProcessAssactst.do">

<html:hidden property="doc"/>
<html:hidden property="blankindex"/>
<html:hidden property="blanknumber"/>
<html:hidden property="blankdate.string"/>
<html:hidden property="oldDocumentState"/>
<html:hidden property="newDocumentState"/>

<bean:define id="docCode" name="AssactstForm" property="doc" scope="request" type="java.lang.Integer"/>
<july:inventorycalcerrors document="<%= docCode %>"/>

<table class="main">
    
    <july:separator/>
    
    <logic:equal name="AssactstForm" property="oldDocumentState" value="1">
        <tr>
            <td class="title" colspan="2"><FONT class="attention"><bean:message key="label.assact.tocalcstate"/></FONT></td>
        </tr>
    
        <july:separator/>
    </logic:equal>

    <logic:equal name="AssactstForm" property="oldDocumentState" value="2">
        <tr>
            <td class="title" colspan="2"><FONT class="attention"><bean:message key="label.assact.toenterstate"/></FONT></td>
        </tr>
    
        <july:separator/>
    </logic:equal>


	<tr>
		<td class="text"><bean:message key="label.assactpos.document"/></td>
		<td class="text">
			<bean:message key="label.num"/>&nbsp;<bean:write name="AssactstForm" property="blankindex"/>&nbsp;<bean:write name="AssactstForm" property="blanknumber"/>&nbsp;<bean:message key="label.from"/>&nbsp;<bean:write name="AssactstForm" property="blankdate.string" filter="true"/>
		</td>
	</tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.assact.agregate"/>:</july:reqmark></td>
        <td>
            <INPUT TYPE="HIDDEN" name="agrcode" ID="agrcode">
            <html:hidden property="agregateserial"/>
            <html:hidden property="agregatename"/>
		<bean:write name="AssactstForm" property="agregatename"/>&nbsp;S/N:<bean:write name="AssactstForm" property="agregateserial"/>
<%--
			<july:string property="agregateserial" styleId="agregateserial" size="25" insertable="false" updatable="false" />
			<july:lookupbutton action="/ShowEquipmentLookupList.do" styleId="srl" fieldNames="agrcode;agregatname;agregateserial" insertable="false" updatable="false" />
			<july:string size="35" property="agregatename" styleId="agregatename" insertable="false" updatable="false" />
--%>
        </td>
    </tr>

    <july:separator/>
    
    <logic:equal name="AssactstForm" property="oldDocumentState" value="1">
        <tr>
            <td class="text"><bean:message key="label.assact.oldconfig"/>:</td>
            <td>
		<bean:write name="AssactstForm" property="oldConfiguration"/>
            </td>
        </tr>
        
        <july:separator/>
        
        <tr>
            <td class="text"><bean:message key="label.assact.newconfig"/>:</td>
            <td>
               <july:string property="newConfiguration" size="25" insertable="true" updatable="true" />
            </td>
        </tr>
    
        <july:separator/>
        
    </logic:equal>

    <logic:equal name="AssactstForm" property="oldDocumentState" value="2">
        <tr>
            <td class="text"><bean:message key="label.assact.oldconfig"/>:</td>
            <td>
		<bean:write name="AssactstForm" property="newConfiguration"/>
            </td>
        </tr>
        
        <july:separator/>
        
        <tr>
            <td class="text"><bean:message key="label.assact.newconfig"/>:</td>
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

