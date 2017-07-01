<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<july:editform action="/ProcessAssemblingPState.do">

<html:hidden property="doc"/>
<html:hidden property="blankindex"/>
<html:hidden property="blanknumber"/>
<html:hidden property="blankdate.string"/>
<html:hidden property="oldDocumentState"/>

<table class="main">
    <tr class="title">
    	<td class="title" colspan="2">
           <html:link page="/ShowAssemblingPList.do" styleClass="navigator"><bean:message key="label.assemblingp"/></html:link> 
           <july:sepmark/> 
           <font class="attention"><b><bean:message key="label.state"/></b></font></td>
    </tr>

    <july:separator/>
    
    <tr>
        <td class="title" colspan="2"><july:actionalert/></td>
    </tr>

    <july:separator/>

<tr>
	<td class="title" width=30%><bean:message key="label.assemblingp.document"/></td>
	<td class="text">
		<bean:message key="label.num"/>
		<bean:write name="AssemblingPStateForm" property="blankindex"/>&nbsp;<bean:write name="AssemblingPStateForm" property="blanknumber"/>
		<bean:message key="label.from"/>
		<bean:write name="AssemblingPStateForm" property="blankdate.string" />
	</td>
</tr>

    <july:separator/>

    <tr>
		<td class="text" rowspan="3"><july:reqmark><bean:message key="label.assemblingp.state"/>:</july:reqmark></td>
		<td>
			<july:radio insertable="true" updatable="true" property="newDocumentState" value="1" styleClass="text"/>&nbsp;<bean:message key="label.state.entering"/>
        </td>
    </tr>

    <july:separator colspan="1"/>

	<tr>
		<td>
			<july:radio insertable="true" updatable="true" property="newDocumentState" value="2" styleClass="text"/>&nbsp;<bean:message key="label.state.calculated"/>
		</td>
	</tr>

    <july:separator />

    <july:formbuttons/>

    <july:separator />

</table>

</july:editform>

