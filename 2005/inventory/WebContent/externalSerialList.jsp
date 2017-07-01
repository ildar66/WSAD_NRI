<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import="com.hps.july.inventory.formbean.*,com.hps.july.inventory.actionbean.*" %>

<% java.lang.String gColSpan = "12"; %>

<july:browseform action="/ShowExternalSerialList.do">
<%
	ExternalForm frm = (ExternalForm)request.getSession().getAttribute("ExternalForm");
	boolean changable = "1".equals(frm.getDState()) && !frm.getIsautodoc() && ("View".equals(frm.getAction()) || "Edit".equals(frm.getAction()));
%>

<table class="main">

<july:separator colspan="<%= gColSpan %>" />

<tr class="normal">
 <td colspan="<%= gColSpan %>">
 
    <table class="find">
    <tr>
		<td class="title"><bean:message key="label.externalser.position"/></td>
		<td class="title"><bean:write name="ExternalSerialListForm" property="orderstr"/></td>
	</tr>
	<tr>
		<td class="title"><bean:message key="label.externalser.resource"/></td>
		<td class="title"><bean:write name="ExternalSerialListForm" property="resourcecode"/>&nbsp;<bean:write name="ExternalSerialListForm" property="resourcename"/>&nbsp;<bean:write name="ExternalSerialListForm" property="resourcemodel"/></td>
	</tr>
	<tr>
		<td class="title"><bean:message key="label.externalser.configuration"/></td>
		<td class="title"><bean:write name="ExternalSerialListForm" property="configuration"/></td>
	</tr>
    <tr>
		<td class="title"><bean:message key="label.externalser.qty"/></td>
		<td class="title"><july:numberwrite name="ExternalSerialListForm" property="outerQty"/>/<july:numberwrite name="ExternalSerialListForm" property="qty" /></td>
    </tr>
    </table>
    
  </td>
</tr>

<july:separator colspan="<%= gColSpan %>" />

<tr class="title">
	<td colspan="<%= gColSpan %>">
		<table class="buttons">
		<tr class="title">
			<TD class="buttons">
				<%if(changable){%><july:addbutton page="/EditExternalSerial.do?action=Add" /><%}%>
				<july:backbutton page="/EditExternal.do"/>
			</td>
			<TD class="navigator"><july:navigator/></td>
		</tr>
		</table>
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>" />

<!-- Table header -->
<tr class="title">
	<td class="title">&nbsp;</td>
	<july:headercolumn key="label.externalser.boxed" colType="string"/>
	<july:headercolumn key="label.externalser.mark" colType="string"/>
	<july:headercolumn key="label.externalser.serial" colType="string"/>
	<july:headercolumn key="label.manufserial" colType="string"/>
	<td class="title">&nbsp;</td>
</tr>

<july:separator colspan="<%= gColSpan %>" />
    
<!-- Table body -->
<logic:iterate id="it" name="browseList">
	<logic:present name="it">
		<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
			<td class="text"><html:link page="/EditExternalSerial.do?action=Edit" paramId="docposition" paramName="it" paramProperty="docposition" paramScope="page"><bean:message key="label.setup" /></html:link></td>
			<td class="text"><logic:equal name="it" property="resultBoxed" value="true">+</logic:equal></td>
			<td class="text"><bean:write name="it" property="notes" filter="true"/></td>
			<td class="text"><logic:present name="it" property="serialnumber"><bean:write name="it" property="serialnumber" filter="true"/></logic:present></td>
			<td class="text"><logic:present name="it" property="manufserial"><bean:write name="it" property="manufserial" filter="true"/></logic:present></td>
			<td class="link"><%if(changable) {%><july:delbutton page="/EditExternalSerial.do?action=Delete" paramId="docposition" paramName="it" paramProperty="docposition" paramScope="page"/><%}%></td>
		</tr>
		<july:separator colspan="<%= gColSpan %>" />
		</logic:present>
	</logic:iterate>

<tr class="title">
	<td colspan="<%= gColSpan %>">
		<table class="buttons">
		<tr class="title">
			<TD class="buttons">
				<%if(changable){%><july:addbutton page="/EditExternalSerial.do?action=Add" /><%}%>
				<july:backbutton page="/EditExternal.do"/>
			</td>
			<TD class="navigator"><july:navigator/></td>
		</tr>
		</table>
	</td>
</tr>
      
	<july:separator colspan="<%= gColSpan %>" />     


</table>

</july:browseform>
