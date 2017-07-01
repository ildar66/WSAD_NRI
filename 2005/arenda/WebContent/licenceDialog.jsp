<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.arenda.*,com.hps.july.arenda.formbean.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "2"; %>

<%
	String action = "/ProcessLicenceDialog.do";
	String form = "LicenceDialogForm";
	String src = "/images/save.gif";
	String alt = "Сохранить запись";
	//роли:
	boolean isAdministrator = request.isUserInRole("administrator");
	boolean isArendaManager = request.isUserInRole("ArendaManager");
	boolean isArendaDirector =request.isUserInRole("ArendaDirector");
	boolean islcsEditAllLicence = request.isUserInRole("lcsEditAllLicence");
	//группы:
	boolean isSave = isAdministrator || isArendaManager || isArendaDirector || islcsEditAllLicence;
	//режим:
	boolean isView = request.getParameter("action").equals("View");
	isSave = isSave && !isView;
%>
<july:errors property="org.apache.struts.action.GLOBAL_ERROR"/>

<july:editform action="<%= action %>" styleId="<%= form %>">
<html:hidden property="position"/>
<html:hidden property="typelicence"/>
<html:hidden property="id"/>

<script language="javascript">
	function Close()
		{
			if(window.opener) {
				//opener.location.reload(true);
				strval = '+';
				id = document.all['id'].value;
				window.opener.document.all[id].innerHTML='<DIV style=\'color: red\'>'+strval+'</DIV>';
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
			<july:textarea style="width: 500;"cols="120" rows="25" property="vo.noteLicence" insertable="true" updatable="true" styleId="note"/>
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
