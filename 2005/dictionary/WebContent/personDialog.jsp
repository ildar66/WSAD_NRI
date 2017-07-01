<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.dictionary.*,com.hps.july.dictionary.formbean.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "2"; %>

<%
	String action = "/PersonDialogProcess.do";
	String form = "PersonDialogForm";
	String src = "/images/save.gif";
	String alt = "Сохранить запись";
%>

<july:errors property="org.apache.struts.action.GLOBAL_ERROR"/>

<logic:equal name="<%= form %>" property="action" value="Delete">
		<% src = "/images/delconf.gif"; alt = "Удалить запись"; %>
</logic:equal>

<july:editform action="<%= action %>" styleId="<%= form %>" focus="person.lastname">
<html:hidden property="id"/>

<script language="javascript">
	function Close()
		{
			if(window.opener) {
				opener.storeSelectedRow(document.all.id.value);
				//opener.location.reload(true);
				window.opener.window.document.forms(0).submit();
				//window.opener.window.location.href=window.opener.window.location.href;
				window.opener.focus();
			}
			window.close();
		}
</script>

<table class="main"  style="font-size:8pt;">

	<july:separator colspan="<%= gColSpan %>"/>
    <tr class="title">
    	<td class="title" colspan="<%= gColSpan %>">
			<INPUT TYPE="IMAGE" NAME="submit" SRC="<%= src%>"  ALT="<%= alt %>" onclick="document.body.style.cursor='wait';">&nbsp;
			<july:closebutton page="/"/>
        </td>
    </tr>
	<july:separator colspan="<%= gColSpan %>"/>

    <tr>
        <td class="title" colspan="<%= gColSpan %>"><july:actionalert/></td>
    </tr>

	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<td class="text">Фамилия:</td> 
		<td class="text">
				<july:string property="person.lastname" size="25" insertable="true" updatable="true"/>
		</td>
    </tr>

	<tr>
		<td class="text">Имя:</td> 
		<td class="text">
				<july:string property="person.firstname" size="25" insertable="true" updatable="true"/>
		</td>
    </tr>

	<tr>
		<td class="text">Отчество:</td> 
		<td class="text">
				<july:string property="person.middlename" size="25" insertable="true" updatable="true" />
		</td>
    </tr>

	<tr>
		<td class="text">серия паспорта:</td> 
		<td class="text">
				<july:string property="person.passportser" size="25" insertable="true" updatable="true" />
		</td>
    </tr>

	<tr>
		<td class="text">номер паспорта:</td> 
		<td class="text">
				<july:string property="person.passportnum" size="25" insertable="true" updatable="true" />
		</td>
    </tr>

	<tr>
		<td class="text">когда выдан:</td> 
		<td class="text">
				<july:date property="passportdateStr" size="25" insertable="true" updatable="true" styleId="passportdateStr"/>
		</td>
    </tr>

	<tr>
		<td class="text">кем выдан:</td> 
		<td class="text">
				<july:string property="person.passportwhom" size="25" insertable="true" updatable="true" />
		</td>
    </tr>

	<july:separator colspan="<%= gColSpan %>"/>
    <tr class="title">
    	<td class="title" colspan="<%= gColSpan %>">
			<INPUT TYPE="IMAGE" NAME="submit" SRC="<%= src%>"  ALT="<%= alt %>" styleID="submitID" onclick="document.body.style.cursor='wait';">&nbsp;
			<july:closebutton page="/"/>
        </td>
    </tr>
	<july:separator colspan="<%= gColSpan %>"/>
	
</table>

<logic:equal name="<%=form%>" property="flagOperation" value="true">
	<script language="javascript" type="text/javascript">
		 Close();
	</script>
</logic:equal>

</july:editform>
