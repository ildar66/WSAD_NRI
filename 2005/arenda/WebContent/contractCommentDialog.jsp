<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.arenda.*,com.hps.july.arenda.formbean.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "2"; %>

<%
	String action = "/ProcessContractCommentDialog.do";
	String form = "ContractCommentDialogForm";
	String src = "/images/save.gif";
	String alt = "Сохранить запись";
	//роли:
	boolean isAdministrator = request.isUserInRole("administrator");
	boolean isArendaEconomist = request.isUserInRole("ArendaEconomist");
	boolean isArendaMainEconomist =request.isUserInRole("ArendaMainEconomist");
	//boolean islcsEditAllLicence = request.isUserInRole("lcsEditAllLicence");
	//группы:
	boolean isSave = isAdministrator || isArendaEconomist || isArendaMainEconomist;
	//режим:
	//boolean isView = request.getParameter("action").equals("View");
	//isSave = isSave && !isView;
%>
<july:errors property="org.apache.struts.action.GLOBAL_ERROR"/>

<july:editform action="<%= action %>" styleId="<%= form %>">
<html:hidden property="contractID"/>

<script language="javascript">
	function Close()
		{
			if(window.opener) {
				//opener.location.reload(true);
				window.opener.window.location.href=window.opener.window.location.href;
				/**
				strval = '+';
				id = document.all['id'].value;
				window.opener.document.all[id].innerHTML='<DIV style=\'color: red\'>'+strval+'</DIV>';
				*/
				window.opener.focus();
			}
			window.close();
		}
</script>

<table class="main"  style="font-size:8pt;">

	<july:separator colspan="<%= gColSpan %>"/>
    <tr class="title">
    	<td class="title" colspan="<%= gColSpan %>">
		<%if(isSave) {%>
			<INPUT TYPE="IMAGE" NAME="submit" SRC="<%= src%>"  ALT="<%= alt %>" onclick="document.body.style.cursor='wait';">&nbsp;
		<%}%>
			<july:closebutton page="/"/>
        </td>
    </tr>
	<july:separator colspan="<%= gColSpan %>"/>

	<%if(isSave) {%>
    <tr>
        <td class="title" colspan="<%= gColSpan %>"><july:actionalert/></td>
    </tr>
	<july:separator colspan="<%= gColSpan %>"/>
	<%}%>

	<tr>
		<td class="text" nowrap>
			<july:textarea onkeypress="if(this.value.length>=800) event.returnValue=false;" onchange="this.value=this.value.substr(0,800);" cols="80" rows="10" property="comment" insertable="true" updatable="true" styleId="comment"/>
		</td>
    </tr>

	<july:separator colspan="<%= gColSpan %>"/>

    <tr class="title">
    	<td class="title" colspan="<%= gColSpan %>">
		<%if(isSave) {%>
			<INPUT TYPE="IMAGE" NAME="submit" SRC="<%= src%>"  ALT="<%= alt %>" styleID="submitID" onclick="document.body.style.cursor='wait';">&nbsp;
		<%}%>
			<july:closebutton page="/"/>
        </td>
    </tr>
	<july:separator colspan="<%= gColSpan %>"/>
	
</table>

<logic:equal name="<%= form %>" property="flagOperation" value="true">
	<script language="javascript" type="text/javascript">
		 Close();
	</script>
</logic:equal>

</july:editform>
