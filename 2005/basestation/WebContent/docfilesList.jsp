<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld" prefix="alex" %>
<%@ page import="org.apache.struts.util.*"%>
<%@ page import="com.hps.july.basestation.formbean.*"%>
<%@ page import="com.hps.july.jdbcpersistence.lib.SearchConstants"%>
<%@ page import="com.hps.july.siteinfo.valueobject.Regions"%>

<july:browseform action="/ShowDocFilesList.do" styleId="DocFilesListForm">
<%
	String gColSpan = "5";
	DocFilesListForm dForm = (DocFilesListForm)request.getSession().getAttribute("DocFilesListForm");
	String editLink = "/EditSiteDocFile.do?sitedoc="+dForm.getSitedoc();
	String addLink = "/EditSiteDocFile.do?action=Add&sitedoc="+dForm.getSitedoc();

%>
<table class="main">
<july:separator colspan="<%= gColSpan %>"/>
<tr class="normal">
<td colspan="<%=gColSpan %>">
	<table class="find">
	<tr>
		<td class="title"><bean:message key="label.docfiles.document"/>:</td>
		<td class="title">
			<bean:message key="label.num"/><bean:write name="DocFilesListForm" property="blanknumber" filter="true"/> <bean:message key="label.from"/> <bean:write name="DocFilesListForm" property="blankdate.string" filter="true"/>
		</td>
		<td class="title" rowspan="2"><july:searchbutton/></td>
	</tr>
	<tr>
		<td class="title"><bean:message key="label.docfiles.doctype"/>:</td>
		<td class="title">
			<bean:write name="DocFilesListForm" property="doctype" filter="true"/>
		</td>
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
				<html:link page='<%=addLink%>'><img alt='<bean:message key="label.docfiles.add"/>' src="/images/plus.gif" border=0></html:link>
        			<img alt="" src="/images/empty.gif" width=3 border=0>
				<july:backbutton/>
			</td>
			<td class="navigator"><july:navigator/></td>
		</tr>
		</table>
	</td>
</tr>
<july:separator colspan="<%= gColSpan %>" />
<%-- Table header --%>
<tr class="title">
	<td class="title">&nbsp;</td>
	<july:headercolumn key="label.num" colType="string"/>
	<july:headercolumn key="label.docfiles.filename" colType="string"/>
	<july:headercolumn key="label.docfiles.note" colType="string"/>
	<td class="title">&nbsp;</td>
</tr>
<july:separator colspan="<%= gColSpan %>" />
<%-- Table body --%>
<%
	int i = 1;
%>
<logic:iterate id="et" name="browseList" type="com.hps.july.cdbc.lib.CDBCRowObject">
<logic:present name="et">
<%
	pageContext.setAttribute("sitedocfile",et.getColumn("sitedocfile").asString());
%>
<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
	<td class="text"><july:editbutton page="<%=editLink%>" action="Edit" paramId="sitedocfile" paramName="sitedocfile"/></td>
	<td class="text"><%=i++%></td>
	<td class="text"><html:link page="/../sitedoc/OpenFile.do" target="_blank" paramId="sitedocfile" paramName="sitedocfile"><july:stringwrite name="et" property="sitedocfilename"/></html:link></td>
	<td class="text"><july:stringwrite name="et" property="note"/></td>
	<td class="text"><july:delbutton page='<%=editLink+"&action=Delete"%>' paramId="sitedocfile" paramName="sitedocfile"/></td>
</tr>
<july:separator colspan="<%= gColSpan %>" />
</logic:present>
</logic:iterate>
<tr class="title">
	<td colspan="<%= gColSpan %>">
		<table class="buttons">
		<tr class="title">
			<td class="buttons">
				<html:link page='<%=addLink%>'><img alt='<bean:message key="label.docfiles.add"/>' src="/images/plus.gif" border=0></html:link>
        			<img alt="" src="/images/empty.gif" width=3 border=0>
				<july:backbutton/>
			</td>
			<td class="navigator"><july:navigator/></td>
		</tr>
		</table>
	</td>
</tr>
<july:separator colspan="<%= gColSpan %>"/>
</table>
</july:browseform>
