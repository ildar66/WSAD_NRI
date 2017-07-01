<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import = "com.hps.july.dictionary.formbean.*"%>
<SCRIPT language=javascript src="/common/dialog.js" type="text/javascript"></SCRIPT>  
<SCRIPT language=javascript src="/common/exitFromNRI.js" type="text/javascript"></SCRIPT>  
<SCRIPT language=javascript src="/scripts/string_format.js" type="text/javascript"></SCRIPT>  

<head>
	<META HTTP-EQUIV = "Pragma" CONTENT="no-cache"> 
	<title>Комплект источника питания</title> 
	<link rel="stylesheet" type="text/css" href="/main.css">
</head>

<%
	String gColSpan = "7";
	// String shortTextLength = "12";
	String textAreaCols = "100";
	String textAreaRows = "4";
	String secondColWidth = "155";
	boolean isElAp = ConfPowerSourcesForm.getIsElAp(session); 
	String parentForm = ConfPowerSourcesForm.getFormString(session); 
	boolean isIkBs = ConfPowerSourcesForm.getIsIkBs(session); 
%>


<july:editform action="/EditConfPowerSources.do" styleId="EditConfPowerSourcesForm">

<%
	EditConfPowerSourcesForm editConfPowerSourcesForm = (EditConfPowerSourcesForm)request.getAttribute("EditConfPowerSourcesForm");
	String theAction = editConfPowerSourcesForm.getAction();
	boolean isEditable = (EditConfPowerSourcesForm.ACTION_ADD.equals(theAction)) || 
						(EditConfPowerSourcesForm.ACTION_EDIT.equals(theAction));
	boolean isDelete = (EditConfPowerSourcesForm.ACTION_DELETE.equals(theAction));						
	String saveBattonImage = "/images/save.gif";
	if (isDelete) {
		saveBattonImage = "/images/delconf.gif";
	}
%>

<html:hidden property="nfsId"/>
<html:hidden property="isSave"/>

<table class="main" id="formTableID" border="0"> 

<july:separator colspan="<%= gColSpan %>" />

<tr>
	<td class="title" colspan="<%= gColSpan %>"><july:actionalert/></td>
</tr>

<july:separator colspan="<%= gColSpan %>" />

<tr>
	<td class="title" colspan="<%= gColSpan %>"><FONT class="attention"><bean:write name="EditConfPowerSourcesForm" 
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
		Код комплекта:
   	</td>
	<td class="text" colspan="3" valign="top" nowrap> 
		<july:string property="complectCode" styleId="complectCode" size="10" insertable="false" updatable="false"/>
   	</td>
</TR>
<july:separator colspan="<%= gColSpan %>" />
<TR>
	<td class="title" valign="top" nowrap>
		<july:reqmark>Наименование комплекта:</july:reqmark>
   	</td>
	<td class="text" colspan="3" valign="top" nowrap>
		<july:string property="complectName" styleId="complectName" size="200" insertable="true" updatable="true"/>
   	</td>
</TR>
<% if (isElAp) { %>
<july:separator colspan="<%= gColSpan %>" />
<TR>
	<td class="title" valign="top" nowrap>
		<july:reqmark>Выходная мощность, кВт:</july:reqmark>
   	</td>
	<td class="text" colspan="3" valign="top" nowrap>
		<july:string property="power" styleId="power" size="10" insertable="true" updatable="true"/>
   	</td>
</TR>
<% } else { %>
<html:hidden property="power" value="0"/>
<% } %>
<july:separator colspan="<%= gColSpan %>" />
<TR>
	<td class="title" valign="top" rowspan="2" nowrap>
		<july:reqmark>Код НФС:</july:reqmark>
   	</td>
	<td class="text" valign="top" nowrap width="<%=secondColWidth%>">
		<july:string property="nfsCode" styleId="nfsCodeInput" size="10" insertable="false" updatable="false"/>
		<% if (isEditable) { %>
		<A HREF="#"><IMG BORDER="0" SRC="/images/bd.gif" onclick='nfsResLookup(); return false;'></A>
		<% } %>
   	</td>
	<td class="text" rowspan="2">
		<july:textarea property="nfsName" cols="<%=textAreaCols%>" rows="<%=textAreaRows%>" 
			styleId="nfsDescriptionInput" insertable="false" updatable="false"/>
   	</td>
</TR>
<TR>
	<td class="text" align="right" valign="top" nowrap width="<%=secondColWidth%>">
	<%  if ((isIkBs) && (! isDelete)) { %>
		<A HREF="#"><IMG BORDER="0" title="Очистить код НФС" SRC="/images/clear_field.gif" onclick='clearNFSCode(); return false;'></A>
	<%  } else { %>
		&nbsp;
	<%  } %>
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

 function nfsResLookup(argResource) {
		openDialog("NFSResLookup.do?nfsId=nfsId&nfsCode=nfsCodeInput&nfsDescr=nfsDescriptionInput",
		 "NFSResourceLookup", "top=0, left=0, width=1000, height=350, scrollbars=auto, resizable=yes");
 }
 
 function doSave() {
	<% if (isDelete) { %>
 		if (! confirm('Внимание! Удаляется комплект и оборудование, входящее в его состав.\nПосле удаления восстановить информацию будет нельзя!\nПодтверждаете удаление?')) {
 			return;
 		}
	<% } %>
 		if (validate()) {
			document.all['isSave'].value='<%=ConfPowerSourcesForm.TRUE_STR%>';
			EditConfPowerSourcesForm.submit();
 		}
 }

 function validate() {
 		// 
 		if (! <%=isIkBs%>) {
	 	 	var nfsCodeInputValue = document.all['nfsCodeInput'].value;
			if (nfsCodeInputValue.length == 0) {
				alert("Введите код НФС!");
	 			return false;
			}
 		}
 	 	var complectNameValue = document.all['complectName'].value;
		if (complectNameValue.length == 0) {
			alert("Введите наименование комплекта!");
	 		return false;
		}
		var powerValue = document.all['power'].value;
		if (powerValue.length == 0) {
			alert("Введите мощность!");
	 		return false;
		}
		if (numericStr(powerValue) == false) {
			alert("Мощность должна быть целым числом!");
		 	return false;
		}
		return true;
 }

 function clearNFSCode() {
 		document.all['nfsId'].value = '';
 		document.all['nfsCodeInput'].value = '';
 		document.all['nfsDescriptionInput'].value = '';
 }

 // код при загрузке страницы 
 if (document.all['isSave'].value=='<%=ConfPowerSourcesForm.TRUE_STR%>') {
		document.all['isSave'].value='<%=ConfPowerSourcesForm.FALSE_STR%>';
	 	opener.parent.document.all['isComplectSelectProcess'].value='<%=ConfPowerSourcesForm.TRUE_STR%>';
	 	opener.parent.<%=parentForm%>.submit();
		window.close();
 }

</script>

</july:editform>
