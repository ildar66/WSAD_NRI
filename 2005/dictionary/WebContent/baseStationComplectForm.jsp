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
	<title>Комплект базовой станции</title> 
	<link rel="stylesheet" type="text/css" href="/main.css">
</head>

<%
	String gColSpan = "7";
	String textAreaCols = "100";
	String textAreaRows = "4";
	String secondColWidth = "155";
%>


<july:editform action="/EditBaseStationConf.do" styleId="EditBaseStationConfForm">

<%
	EditBaseStationConfForm editBaseStationConfForm = (EditBaseStationConfForm)request.getAttribute("EditBaseStationConfForm");
	String theAction = editBaseStationConfForm.getAction();
	boolean isEditable = (EditBaseStationConfForm.ACTION_ADD.equals(theAction)) || 
						(EditBaseStationConfForm.ACTION_EDIT.equals(theAction));
	boolean isDelete = (EditBaseStationConfForm.ACTION_DELETE.equals(theAction));						
	String saveBattonImage = "/images/save.gif";
	if (isDelete) {
		saveBattonImage = "/images/delconf.gif";
	}
%>

<html:hidden property="nfsId"/> 
<html:hidden property="isSave"/>
<html:hidden property="id"/>
<html:hidden property="codenri"/>

<table class="main" id="formTableID" border="0"> 

<july:separator colspan="<%= gColSpan %>" />

<tr>
	<td class="title" colspan="<%= gColSpan %>"><july:actionalert/></td>
</tr>

<july:separator colspan="<%= gColSpan %>" />

<tr>
	<td class="title" colspan="<%= gColSpan %>"><FONT class="attention"><bean:write name="EditBaseStationConfForm" 
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
		K:
   	</td>
	<td class="text" colspan="3" valign="top" nowrap> 
		<july:string property="conftype" styleId="conftype" size="10" insertable="true" updatable="true"/>
   	</td>
</TR>

<july:separator colspan="<%= gColSpan %>" />
<TR>
	<td class="title" valign="top" nowrap>
		A:
   	</td>
	<td class="text" colspan="3" valign="top" nowrap> 
		<july:string property="a" styleId="a" size="10" insertable="true" updatable="true"/>
   	</td>
</TR>

<july:separator colspan="<%= gColSpan %>" />
<TR>
	<td class="title" valign="top" nowrap>
		B:
   	</td>
	<td class="text" colspan="3" valign="top" nowrap> 
		<july:string property="b" styleId="b" size="10" insertable="true" updatable="true"/>
   	</td>
</TR>

<july:separator colspan="<%= gColSpan %>" />
<TR>
	<td class="title" valign="top" nowrap>
		C:
   	</td>
	<td class="text" colspan="3" valign="top" nowrap> 
		<july:string property="c" styleId="c" size="10" insertable="true" updatable="true"/>
   	</td>
</TR>

<july:separator colspan="<%= gColSpan %>" />
<TR>
	<td class="title" valign="top" nowrap>
		D:
   	</td>
	<td class="text" colspan="3" valign="top" nowrap> 
		<july:string property="d" styleId="d" size="10" insertable="true" updatable="true"/>
   	</td>
</TR>

<july:separator colspan="<%= gColSpan %>" />
<TR>
	<td class="title" valign="top" nowrap>
		O1800:
   	</td>
	<td class="text" colspan="3" valign="top" nowrap> 
		<july:string property="sect_o1800" styleId="sect_o1800" size="10" insertable="true" updatable="true"/>
   	</td>
</TR>

<july:separator colspan="<%= gColSpan %>" />
<TR>
	<td class="title" valign="top" nowrap>
		E:
   	</td>
	<td class="text" colspan="3" valign="top" nowrap> 
		<july:string property="e" styleId="e" size="10" insertable="true" updatable="true"/>
   	</td>
</TR>

<july:separator colspan="<%= gColSpan %>" />
<TR>
	<td class="title" valign="top" nowrap>
		F:
   	</td>
	<td class="text" colspan="3" valign="top" nowrap> 
		<july:string property="f" styleId="f" size="10" insertable="true" updatable="true"/>
   	</td>
</TR>

<july:separator colspan="<%= gColSpan %>" />
<TR>
	<td class="title" valign="top" nowrap>
		G:
   	</td>
	<td class="text" colspan="3" valign="top" nowrap> 
		<july:string property="g" styleId="g" size="10" insertable="true" updatable="true"/>
   	</td>
</TR>

<july:separator colspan="<%= gColSpan %>" />
<TR>
	<td class="title" valign="top" nowrap>
		H:
   	</td>
	<td class="text" colspan="3" valign="top" nowrap> 
		<july:string property="h" styleId="h" size="10" insertable="true" updatable="true"/>
   	</td>
</TR>

<july:separator colspan="<%= gColSpan %>" />
<TR>
	<td class="title" valign="top" nowrap>
		O900:
   	</td>
	<td class="text" colspan="3" valign="top" nowrap> 
		<july:string property="sect_o900" styleId="sect_o900" size="10" insertable="true" updatable="true"/>
   	</td>
</TR>

<july:separator colspan="<%= gColSpan %>" />
<TR>
	<td class="title" valign="top" nowrap>
		Напряжение, В:
   	</td>
	<td class="text" colspan="3" valign="top" nowrap> 
		<july:string property="voltage" styleId="voltage" size="10" insertable="true" updatable="true"/>
   	</td>
</TR>

<july:separator colspan="<%= gColSpan %>" />
<TR>
	<td class="title" valign="top" nowrap>
		Код НФС:
   	</td>
	<td class="text" valign="top" nowrap width="<%=secondColWidth%>">
		<july:string property="nfsitem_id" styleId="nfsCodeInput" size="10" insertable="false" updatable="false"/>
		<% if (isEditable) { %>
		<A HREF="#"><IMG BORDER="0" SRC="/images/bd.gif" onclick='nfsResLookup(); return false;'></A>
		<% } %>
   	</td>
	<td class="text">
		<july:textarea property="nfsitem_Name" cols="<%=textAreaCols%>" rows="<%=textAreaRows%>" 
			styleId="nfsDescriptionInput" insertable="false" updatable="false"/>
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
		 "NFSResourceLookup", "top=160, left=0, width=1000, height=350, scrollbars=auto, resizable=yes");
 }
 
 function doSave() {
	<% if (isDelete) { %>
 		if (! confirm('Внимание! Удаляется конфигурация базовой станции.\nПосле удаления восстановить информацию будет невозможно!\nПодтверждаете удаление?')) {
 			return;
 		}
	<% } %>
 		if (validate()) {
			document.all['isSave'].value='<%=ConfPowerSourcesForm.TRUE_STR%>';
			EditBaseStationConfForm.submit();
 		}
 }

 function validate() {
		var conftypeValue = document.all['conftype'].value;
		if (conftypeValue.length == 0) {
			alert("Введите значение в поле 'K'!");
	 		return false;
		}
		if ((conftypeValue != 'A') && (conftypeValue != 'S')) {
			alert("Недопустимый символ в поле 'K'!");
		 	return false;
		}
		if (!checkReqDigit('a', 'A', true)) {
			return false;
		}
		if (!checkReqDigit('b', 'B', true)) {
			return false;
		}
		if (!checkReqDigit('c', 'C', true)) {
			return false;
		}
		if (!checkReqDigit('d', 'D', true)) {
			return false;
		}
		if (!checkReqDigit('sect_o900', 'O900', true)) {
			return false;
		}
		if (!checkReqDigit('e', 'E', true)) {
			return false;
		}
		if (!checkReqDigit('f', 'F', true)) {
			return false;
		}
		if (!checkReqDigit('g', 'G', true)) {
			return false;
		}
		if (!checkReqDigit('h', 'H', true)) {
			return false;
		}
		if (!checkReqDigit('sect_o1800', 'O1800', true)) {
			return false;
		}
		if (!checkReqDigit('voltage', 'Напряжение', false)) {
			return false;
		}
 	 	var nfsCodeInputValue = document.all['nfsCodeInput'].value;
		if (nfsCodeInputValue.length == 0) {
			alert("Введите код НФС!");
	 		return false;
		}
		return true;
 }
 
 function checkReqDigit(fieldName, fieldLabel, isReq) {
		var varValue = document.all[fieldName].value;
		if ((isReq) && (varValue.length == 0)) {
			alert("Введите значение в поле '"+fieldLabel+"'!");
	 		return false;
		}
		var isReqNumeric = "' должно содержать целое число!";
		if (! isReq) {
			isReqNumeric = "' может содержать только целое число!";
		}
		if ((varValue.length > 0) && (numericStr(varValue) == false)) {
			alert("Поле '" + fieldLabel + isReqNumeric);
		 	return false;
		}
		return true;
 }
 
 if (document.all['isSave'].value=='<%=EditBaseStationConfForm.TRUE_STR%>') {
		document.all['isSave'].value='<%=EditBaseStationConfForm.FALSE_STR%>';
		//
	 	opener.parent.document.all['isBaseStationCurComplectPrepareProcess'].value='<%=EditBaseStationConfForm.TRUE_STR%>';
	 	opener.parent.document.all['curComplectSelectedID'].value='<bean:write name="EditBaseStationConfForm" property="id" filter="true"/>';
	 	// alert('<bean:write name="EditBaseStationConfForm" property="id" filter="true"/>');
	 	// alert(opener.parent.document.all['curComplectSelectedID'].value);
	 	opener.parent.ShowConfBaseStationForm.submit();
	 	//
		window.close();
 }

</script>

</july:editform>
