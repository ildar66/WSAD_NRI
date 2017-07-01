<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<july:editform action="/ProcessAssactstB.do">

<html:hidden property="doc"/>
<html:hidden property="blankindex"/>
<html:hidden property="blanknumber"/>
<html:hidden property="blankdate.string"/>
<html:hidden property="oldDocumentState"/>
<html:hidden property="newDocumentState"/>

<table class="main">
    
    <july:separator/>
    
    <logic:equal name="AssactstBForm" property="oldDocumentState" value="1">
        <tr>
            <td class="title" colspan="2"><FONT class="attention"><bean:message key="label.assactb.tocalcstate"/></FONT></td>
        </tr>
    
        <july:separator/>
    </logic:equal>

    <logic:equal name="AssactstBForm" property="oldDocumentState" value="2">
        <tr>
            <td class="title" colspan="2"><FONT class="attention"><bean:message key="label.assactb.toenterstate"/></FONT></td>
        </tr>
    
        <july:separator/>
    </logic:equal>


	<tr>
		<td class="text"><bean:message key="label.assactposb.document"/></td>
		<td class="text">
			<bean:message key="label.num"/>&nbsp;<bean:write name="AssactstBForm" property="blankindex"/>&nbsp;<bean:write name="AssactstBForm" property="blanknumber"/>&nbsp;<bean:message key="label.from"/>&nbsp;<bean:write name="AssactstBForm" property="blankdate.string" filter="true"/>
		</td>
	</tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><bean:message key="label.assactb.agregate"/>:</td>
        <td>
            <INPUT TYPE="HIDDEN" name="agrcode" ID="agrcode">
            <html:hidden property="agregateserial"/>
            <html:hidden property="agregatename"/>
		<bean:write name="AssactstBForm" property="agregatename"/>&nbsp;S/N:<bean:write name="AssactstBForm" property="agregateserial"/>
<%--
			<july:string property="agregateserial" styleId="agregateserial" size="25" insertable="false" updatable="false" />
			<july:lookupbutton action="/ShowEquipmentLookupList.do" styleId="srl" fieldNames="agrcode;agregatname;agregateserial" insertable="false" updatable="false" />
			<july:string size="35" property="agregatename" styleId="agregatename" insertable="false" updatable="false" />
--%>
        </td>
    </tr>

    <july:separator/>
    
    <logic:equal name="AssactstBForm" property="oldDocumentState" value="1">
        <tr>
            <td class="text"><bean:message key="label.assactb.oldconfig"/>:</td>
            <td>
		<bean:write name="AssactstBForm" property="oldConfiguration"/>
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

    <logic:equal name="AssactstBForm" property="oldDocumentState" value="2">
        <tr>
            <td class="text"><bean:message key="label.assactb.oldconfig"/>:</td>
            <td>
		<bean:write name="AssactstBForm" property="newConfiguration"/>
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

