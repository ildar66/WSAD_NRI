<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<html:html>
<HEAD>
<%@ page language="java" contentType="text/html; charset=windows-1251" %>
<META http-equiv="Content-Type" content="text/html; charset=windows-1251">
<META name="GENERATOR" content="IBM WebSphere Studio">
<link rel="stylesheet" type="text/css" href="/main.css">
<TITLE><bean:message key="label.resource.nfscodes"/></TITLE>
</HEAD>
<BODY>
<A HREF="#"><IMG BORDER="0" SRC="/images/cancel.gif" onclick='window.close();'></A>

<table class="print">
	<!-- Table header -->
    <tr valign="top" class="print">
		<td class="print"><bean:message key="label.resource.nfscode"/></td>
		<td class="print"><bean:message key="label.resource.manucode"/></td>
		<td class="print"><bean:message key="label.resource.model"/></td>
		<td class="print"><bean:message key="label.resource.manufacturer"/></td>
		<td class="print"><bean:message key="label.resource.name"/></td>
	</tr>
<logic:iterate id="it" name="showCodes" indexId="segment1">
		<logic:present name="it">
			<tr valign="top" class="print">
				<td class="print"><bean:write name="it" property="segment1" filter="true"/></td>
				<td class="print"><bean:write name="it" property="manucode" filter="true"/></td>
				<td class="print"><bean:write name="it" property="model" filter="true"/></td>
				<td class="print"><bean:write name="it" property="shortname" filter="true"/></td>
				<td class="print"><bean:write name="it" property="name" filter="true"/></td>
			</tr>
		</logic:present>
		<logic:notPresent name="it">
           	<tr valign="top" class="print">
                <td class="text" colspan="5">
                   <bean:message key="label.resource.nonfscodes"/>
                </td>
            </tr>		
		</logic:notPresent>
</logic:iterate>

</table>
</BODY>
</html:html>