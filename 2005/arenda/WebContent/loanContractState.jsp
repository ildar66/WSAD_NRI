<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.arenda.*,com.hps.july.arenda.formbean.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "2"; %>

<%
	String action = "/LoanContractStateProcess.do";
	String form = "LoanContractStateForm";
	String src = "/images/save.gif";
	String alt = "Сохранить запись";
/**
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
*/
%>
<july:errors property="org.apache.struts.action.GLOBAL_ERROR"/>

<july:editform action="<%= action %>" styleId="<%= form %>">
<html:hidden property="id"/>
<html:hidden property="idTD"/>
<html:hidden property="vo.contractStateStr"/>
<html:hidden property="vo.contractStateColor"/>

<script language="javascript">
	function Close()
		{
			if(window.opener) {
				//opener.location.reload(true);
				strVal = document.all['vo.contractStateStr'].value;
				strColor = document.all['vo.contractStateColor'].value;
				idTDval = document.all['idTD'].value;
				//alert(idTDval);
				//alert(window.opener.document.all[idTDval].innerHTML);
				window.opener.document.all[idTDval].innerHTML='<DIV style=\'color:'+strColor +' \'><U>'+strVal +'</U></DIV>';
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
		<td class="text" nowrap>
			<july:radio styleClass="text" property="vo.contractState" insertable="true" updatable="true" value="A"/>Вводится<br>
			<july:radio styleClass="text" property="vo.contractState" insertable="true" updatable="true" value="B"/>Исполняется<br>
			<july:radio styleClass="text" property="vo.contractState" insertable="true" updatable="true" value="C"/>Закрыт<br>
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

<logic:equal name="<%= form %>" property="flagOperation" value="true">
	<script language="javascript" type="text/javascript">
		 Close();
	</script>
</logic:equal>

</july:editform>
