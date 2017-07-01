<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.arenda.*,com.hps.july.arenda.formbean.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "2"; %>

<%
	String action = "/ProcessLawyearNoteDialog.do";
	String form = "LawyearNoteDialogForm";
	String src = "/images/save.gif";
	String alt = "Сохранить запись";
%>

<july:errors property="org.apache.struts.action.GLOBAL_ERROR"/>

<logic:equal name="<%= form %>" property="action" value="Delete">
		<% src = "/images/delconf.gif"; alt = "Удалить запись"; %>
</logic:equal>

<july:editform action="<%= action %>" styleId="<%= form %>">
<html:hidden property="id"/>

<script language="javascript">
	function Close()
		{
			if(window.opener) {
				//opener.location.reload(true);
				opener.storeSelectedRow('lawyearNoteID', document.all.id.value);
				window.opener.window.location.href=window.opener.window.location.href;
				window.opener.focus();
			}
			window.close();
		}
</script>

<table class="main"  style="font-size:8pt;">

	<july:separator colspan="<%= gColSpan %>"/>
    <tr class="title">
    	<td class="title" colspan="<%= gColSpan %>">
<logic:equal name="<%= form %>" property="action" value="Add">
			<INPUT TYPE="IMAGE" NAME="submit" SRC="<%= src%>"  ALT="<%= alt %>" onclick="document.body.style.cursor='wait';">&nbsp;
</logic:equal>
			<july:closebutton page="/"/>
        </td>
    </tr>
	<july:separator colspan="<%= gColSpan %>"/>

    <tr>
        <td class="title" colspan="<%= gColSpan %>"><july:actionalert/></td>
    </tr>

	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<td class="text">№ п/п:</td>
		<td class="text"><bean:write name="LawyearNoteDialogForm" property="lawyearNote.number" filter="true"/></td>
    </tr>

	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<td class="text">дата созд.</td>
		<td class="text"><bean:write name="LawyearNoteDialogForm" property="lawyearNote.created" filter="true"/></td>
    </tr>

	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<td class="text">ФИО созд.:</td>
		<td class="text"><bean:write name="LawyearNoteDialogForm" property="lawyearNote.createdName" filter="true"/></td>
    </tr>
		
	<july:separator colspan="<%= gColSpan %>"/>

<logic:notEqual name="<%= form %>" property="action" value="Add">	
	<tr>
		<td class="text">дата изм.</td>
		<td class="text"><bean:write name="LawyearNoteDialogForm" property="lawyearNote.modified" filter="true"/></td>
    </tr>
	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text">ФИО изм.:</td>
		<td class="text"><bean:write name="LawyearNoteDialogForm" property="lawyearNote.modifiedName" filter="true"/></td>
    </tr>
	<july:separator colspan="<%= gColSpan %>"/>
</logic:notEqual>

	<tr>
		<td class="text">Комментарий:</td> 
		<td class="text">
			<july:textarea style="width: 300;"cols="40" rows="6" property="lawyearNote.note" insertable="true" updatable="true" styleId="note"/>
		</td>
    </tr>

	<july:separator colspan="<%= gColSpan %>"/>
    <tr class="title">
    	<td class="title" colspan="<%= gColSpan %>">
<logic:equal name="<%= form %>" property="action" value="Add">
			<INPUT TYPE="IMAGE" NAME="submit" SRC="<%= src%>"  ALT="<%= alt %>" styleID="submitID" onclick="document.body.style.cursor='wait';">&nbsp;
</logic:equal>
			<july:closebutton page="/"/>
        </td>
    </tr>
	<july:separator colspan="<%= gColSpan %>"/>
	
</table>

<logic:equal name="LawyearNoteDialogForm" property="flagOperation" value="true">
	<script language="javascript" type="text/javascript">
		 Close();
	</script>
</logic:equal>

</july:editform>
