<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.arenda.*,com.hps.july.arenda.formbean.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "2"; %>

<%
	String action = "/ProcessFlagsFromLeaseChargesDialog.do";
	String form = "FlagsFromLeaseChargesDialogForm";
	String src = "/images/save.gif";
	String alt = "Сохранить запись";
%>
<july:errors property="org.apache.struts.action.GLOBAL_ERROR"/>

<july:editform action="<%= action %>" styleId="<%= form %>">
<html:hidden property="leaseDocPosition"/>

<script language="javascript">
	function Close()
		{
			if(window.opener) {
				//opener.location.reload(true);
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
			<INPUT TYPE="IMAGE" NAME="submit" SRC="<%= src%>"  ALT="<%= alt %>" onclick="document.body.style.cursor='wait';">&nbsp;
			<july:closebutton page="/"/>&nbsp;&nbsp;
			<I><bean:write name="<%= form %>" property="headerUpdLeaseRates" filter="true"/></I>
        </td>
    </tr>
	<july:separator colspan="<%= gColSpan %>"/>

    <tr>
        <td class="title" colspan="<%= gColSpan %>"><july:actionalert/></td>
    </tr>

	<july:separator colspan="<%= gColSpan %>"/>

	<tr>
		<td class="text">Наличие подписанных и сданных в бухгалтерию Актов выполненных работ:</td>
		<td class="text" nowrap>
			<july:checkbox property="vo.isworkact1" insertable="true" updatable="true"/>
			<july:checkbox property="vo.isworkact2" insertable="true" updatable="true"/>
			<july:checkbox property="vo.isworkact3" insertable="true" updatable="true"/>
		</td>
    </tr>

<%--
	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text">Признак наличия акта 3:</td>
		<td class="text">
			<july:checkbox property="vo.isworkact3" insertable="true" updatable="true"/>

				<html:select name="<%= form %>" property="vo.isworkact3">
					<html:option value="Y">да</html:option>
					<html:option value="N">нет</html:option>
				</html:select>

		</td>
    </tr>
--%>

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
