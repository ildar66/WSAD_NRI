<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import = "com.hps.july.dictionary.formbean.*"%>
<SCRIPT language=javascript src="/common/dialog.js" type="text/javascript"></SCRIPT>  
<SCRIPT language=javascript src="/common/exitFromNRI.js" type="text/javascript"></SCRIPT>  
<SCRIPT language=javascript src="/common/validate.js" type="text/javascript"></SCRIPT>  
<SCRIPT language=javascript src="/scripts/string_format.js" type="text/javascript"></SCRIPT>  

<head>
	<META HTTP-EQUIV = "Pragma" CONTENT="no-cache"> 
	<title>Ресурс источника питания</title> 
	<link rel="stylesheet" type="text/css" href="/main.css">
</head>

<%
	String gColSpan = "7";
	// String shortTextLength = "12";
	String textAreaCols = "50";
	String textAreaRows = "3";
	String secondColWidth = "155";
	// String textAreaWidth = "100";
	String openerForm = ConfPowerSourcesForm.getFormString(session); 
%>


<july:editform action="/EditPowerResource.do" styleId="EditPowerResourceForm">

<html:hidden property="isSave"/>
<html:hidden property="resourceSet"/>

<%
	EditPowerResourceForm editPowerResourceForm = (EditPowerResourceForm)request.getAttribute("EditPowerResourceForm");
	String theAction = editPowerResourceForm.getAction();
	boolean isAdd = (editPowerResourceForm.ACTION_ADD.equals(theAction));
	boolean isEditable = (editPowerResourceForm.ACTION_ADD.equals(theAction)) || 
						(editPowerResourceForm.ACTION_EDIT.equals(theAction));
	boolean isDelete = (editPowerResourceForm.ACTION_DELETE.equals(theAction));						
	String saveBattonImage = "/images/save.gif";
	if (isDelete) {
		saveBattonImage = "/images/delconf.gif";
	}
	boolean isUnitInt = editPowerResourceForm.isUnitInt();
%>

<table class="main" id="formTableID" border="0"> 

<july:separator colspan="<%= gColSpan %>" />

<tr>
	<td class="title" colspan="<%= gColSpan %>"><july:actionalert/></td>
</tr>

<july:separator colspan="<%= gColSpan %>" />

<tr>
	<td class="title" colspan="<%= gColSpan %>"><FONT class="attention"><bean:write name="EditPowerResourceForm" 
											property="errorMsg" filter="true"/></FONT></td>
</tr>

<tr>
	<td class="title" colspan="<%= gColSpan %>">
		<july:errors shortformat="true"/>
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>" />

	<TR class="title">
		<TD class="title" colspan="<%= gColSpan %>" >
			<A HREF="#"><IMG SRC="<%=saveBattonImage%>" BORDER="0" onclick="doSave();"/></A>
			<july:closebutton page="/"/>
		</TD>
	</TR>
     
<july:separator colspan="<%= gColSpan %>" />

<TR>
	<td class="title" valign="top" nowrap>
		Ресурс:
   	</td>
	<td class="text" valign="top" nowrap width="<%=secondColWidth%>">
		<july:string property="nriCode" styleId="nriCode" size="10" insertable="false" updatable="false"/>
		<% if (isAdd) { %>
			<A HREF="#"><IMG BORDER="0" SRC="/images/bd.gif" onclick='nriResLookup(); return false;'></A>
		<% } %>
   	</td>
	<td>
		<july:textarea property="resourceName" cols="<%=textAreaCols%>" rows="<%=textAreaRows%>" 
			styleId="resourceName" insertable="false" updatable="false"/>
   	</td>
</TR>
<TR>
	<td class="title" valign="top" nowrap>
   	</td>
	<td class="title" valign="top" nowrap>
   	</td>
	<td>
		<july:textarea property="model" cols="<%=textAreaCols%>" rows="<%=textAreaRows%>" 
			styleId="model" insertable="false" updatable="false"/>
   	</td>
</TR>
<july:separator colspan="<%= gColSpan %>" />
<TR>
	<td class="title" valign="top" nowrap>
		Количество, 
			<july:string property="unit_name" styleId="unit_name" size="5" insertable="false" updatable="false"/>
		<%--	
		<% if (isAdd) { %>
			<july:string property="unit_name" styleId="unit_name" size="1" insertable="false" updatable="false"/>
		<% } else { %>
			<bean:write name="EditPowerResourceForm" property="unit_name" filter="true"/>
		<% } %>
		--%>
		:
   	</td>
	<td class="text" colspan="3" valign="top" nowrap>
		<july:string property="quantity" styleId="quantity" size="10" insertable="true" updatable="true"/>
   	</td>
</TR>
<july:separator colspan="<%= gColSpan %>" />

	<TR class="title">
		<TD class="title" colspan="<%= gColSpan %>" >
			<A HREF="#"><IMG SRC="<%=saveBattonImage%>" BORDER="0" onclick="doSave();"/></A>
			<july:closebutton page="/"/>
		</TD>
	</TR>
    
<july:separator colspan="<%= gColSpan %>" />

</table> 


<script language="javascript">

 function nriResLookup(argResource) {
		openDialog("NRIResLookup.do?nriCode=nriCode&nriName=resourceName&nriModel=model&nriUnit=unit_name",
		 "NRIResourceLookup", "top=0, left=0, width=1000, height=350, scrollbars=auto, resizable=yes");
 }
 function doSave() {
	<% if (isDelete) { %>
 		if (! confirm('Внимание! Удаляется оборудование.\nПосле удаления восстановить информацию будет нельзя!\nПодтверждаете удаление?')) {
 			return;
 		}
	<% } %>
 		if (validate()) {
			document.all['isSave'].value='<%=ConfPowerSourcesForm.TRUE_STR%>';
			EditPowerResourceForm.submit();
 		}
 }

 function validate() {
 		// 
 	 	var nriCodeValue = document.all['nriCode'].value;
		if (nriCodeValue.length == 0) {
			alert("Введите ресурс!");
	 		return false;
		}
 	 	var quantityValue = document.all['quantity'].value;
		if (quantityValue.length == 0) {
			alert("Введите количество!");
	 		return false;
		}
		if (<%=isUnitInt%>) {
			if (numericStr(quantityValue) == false) {
				alert("Количество должно быть целым числом!");
			 	return false;
			}
		} else {
			if (isDecimal(quantityValue) == false) {
				alert("Количество должно быть числом!");
			 	return false;
			}
		}
		
		if (quantityValue <= 0) {
			alert("Количество должно быть больше нуля!");
		 	return false;
		}
		return true;
 }

 // alert("resourceSet = " + document.all['resourceSet'].value);
 if (document.all['isSave'].value=='<%=ConfPowerSourcesForm.TRUE_STR%>') {
		document.all['isSave'].value='<%=ConfPowerSourcesForm.FALSE_STR%>';
		// ??????????????
		// opener.document.all[''].value
		opener.<%=openerForm%>.submit();
		window.close();
 }

</script>

</july:editform>
