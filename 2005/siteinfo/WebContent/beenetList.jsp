<%@ page language = "java" %>
<%@ page import="org.apache.struts.util.MessageResources" %>
<%@ page import="com.hps.july.jdbcpersistence.lib.*,com.hps.july.constants.*" %>
<%@ page import="com.hps.july.cdbc.lib.CDBCRowObject" %>
<%@ page import="com.hps.july.taglib.RolesValidation" %>
<%@ page import="com.hps.july.siteinfo.formbean.BeenetListForm" %>

<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<%--
	com.hps.july.jdbcpersistence.lib.TimeCounter ts = new com.hps.july.jdbcpersistence.lib.TimeCounter("PERF.SITEINFO.BeenetList");
	ts.start();
--%>

<%
	java.lang.String gColSpan = "4";
	BeenetListForm frm = (BeenetListForm)request.getSession().getAttribute("BeenetListForm");
%>

<july:browseform action="/ShowBeenetList.do">
<table class="main">
<july:separator colspan="<%= gColSpan %>" />
<tr class="normal">
	<td colspan="<%= gColSpan %>">
	<table class="find">
	<tr>
		<td class="title"><bean:message key="label.equipment.posname"/>:</td>
		<td class="title"><bean:write name="BeenetListForm" property="posid" />&nbsp;&nbsp;&nbsp;<bean:write name="BeenetListForm" property="posname" /></td>
	</tr>
	</table>
	</td>
</tr>
<july:separator colspan="<%= gColSpan %>" />
<tr class="title">
	<td colspan="<%= gColSpan %>">
	<table class="buttons">
	<tr class="title">
		<td class="buttons">
			<july:addbutton page='<%="/EditBeenet.do?action=Add&storageplace="+frm.getStorageplace()%>'/>
			<july:backbutton/>
<%--			<july:backbutton page="/EditPosition.do?action=View" paramId="storageplace" paramName="BeenetListForm" paramProperty="storageplace"/>--%>
		</td>
		<td class="navigator"><july:navigator/></td>
	</tr>
	</table>
	</td>
</tr>
<july:separator colspan="<%= gColSpan %>" />
<!-- Table header -->
<tr class="title">
	<td class="title">&nbsp;</td>
	<july:sortcolumn ascFinder="1" descFinder="2" key="label.beenet.beenetid" colType="string"/>
	<july:headercolumn key="label.beenet.category" colType="string"/>
	<td class="title">&nbsp;</td>
</tr>
<july:separator colspan="<%= gColSpan %>" />
<!-- Table body -->
<logic:iterate id="bn" name="browseList" type="com.hps.july.cdbc.lib.CDBCRowObject">
<%if(bn != null) {%>
<%
	String beenetid = bn.getColumn("beenetid").asString();
	pageContext.setAttribute("beenetid",beenetid);
%>
<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
	<td class="text"><july:editbutton page='<%="/EditBeenet.do?storageplace="+frm.getStorageplace()%>' action="Edit" paramId="beenetid" paramName="beenetid" paramScope="page"/></td>
	<td class="text"><july:stringwrite name="beenetid"/></td>
	<td class="text"><july:stringwrite name="bn" property="categname"/></td>
	<td class="link"><july:delbutton page='<%="/EditBeenet.do?action=Delete&storageplace="+frm.getStorageplace()%>' paramId="beenetid" paramName="beenetid" paramScope="page"/></td>
</tr>
<july:separator colspan="<%= gColSpan %>" />
<%}%>
</logic:iterate>
<tr class="title">
	<td colspan="<%= gColSpan %>">
		<table class="buttons">
		<tr class="title">
			<td class="buttons">
				<july:addbutton page='<%="/EditBeenet.do?action=Add&storageplace="+frm.getStorageplace()%>'/>
				<july:backbutton /></TD>
			<td class="navigator"><july:navigator/></td>
		</tr>
		</table>
	</td>
</tr>
<july:separator colspan="<%= gColSpan %>" />
</table>
</july:browseform>
<%--
	ts.finish("JSP");
--%>
