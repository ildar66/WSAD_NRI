<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<july:editform action="/ProcessAfsState.do">

<html:hidden property="doc"/>
<html:hidden property="blankindex"/>
<html:hidden property="blanknumber"/>
<html:hidden property="blankdate.string"/>
<html:hidden property="oldDocumentState"/>

<bean:define id="docCode" name="AfsStateForm" property="doc" scope="request" type="java.lang.Integer"/>
<july:inventorycalcerrors document="<%= docCode %>"/>

<table class="main">    

    <july:separator/>
    <july:formbuttons/>
	<july:separator/>

    <tr>
        <td class="title" colspan="2"><july:actionalert/></td>
    </tr>
<!-- Calc: <bean:write name="AfsStateForm" property="askBeforeCalc" /> -->
<!-- Undo: <bean:write name="AfsStateForm" property="askBeforeUndo" /> -->
<logic:equal name="AfsStateForm" property="askBeforeCalc" value="true">
    <tr>
        <td class="title" colspan="2"><b style="color:#FF0000;"><bean:message key="label.afs.askforcalc"/></b></td>
    </tr>
</logic:equal>
<logic:equal name="AfsStateForm" property="askBeforeUndo" value="true">
    <tr>
        <td class="title" colspan="2"><b style="color:#FF0000;"><bean:message key="label.afs.askforundo"/></b></td>
    </tr>
</logic:equal>

<logic:equal name="AfsStateForm" property="askBeforeCalc" value="true">
    <july:separator/>
    <tr>
		<td class="text">&nbsp;</td>
		<td>
			<july:checkbox insertable="true" updatable="true" property="removeUserChanges"/><bean:message key="label.afs.checkcalc"/>
		</td>
    </tr>
</logic:equal>
<logic:equal name="AfsStateForm" property="askBeforeUndo" value="true">
<july:separator/>
<tr>
	<td class="text">&nbsp;</td>
	<td>
		<july:checkbox insertable="true" updatable="true" property="removeUserChanges"/><bean:message key="label.afs.checkundo"/>
	</td>
</tr>
</logic:equal>
<july:separator/>
<tr>
	<td class="title" width=30%><bean:message key="label.afs.document"/></td>
	<td class="text">
		<bean:message key="label.num"/>
		<bean:write name="AfsStateForm" property="blankindex"/>&nbsp;<bean:write name="AfsStateForm" property="blanknumber"/>
		<bean:message key="label.from"/>
		<bean:write name="AfsStateForm" property="blankdate.string" />
	</td>
</tr>
<july:separator/>
<tr>
	<td class="text" rowspan="3"><july:reqmark><bean:message key="label.afs.state"/>:</july:reqmark></td>
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
<july:separator/>
<%if(com.hps.july.util.AppUtils.isNewInventory()){%>
<logic:equal name="AfsStateForm" property="oldDocumentState" value="1">
<tr>
	<td class="text">&nbsp;</td>
	<td>
		<july:checkbox property="warnProc" insertable="true" updatable="true" styleClass="text" value="true"/> <bean:message key="label.autocorrect"/>
	</td>
</tr>
<july:separator/>
</logic:equal>
<%}%>
<july:formbuttons/>
<july:separator />
</table>
</july:editform>
