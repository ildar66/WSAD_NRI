<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "9"; %>

<jsp:include page="showNfsScript.jsp" flush="true"/>

<july:browseform action="/ShowRRLResourceList.do">

<%@include file="resources/script.jsp" %>

<table class="main">

<july:separator colspan="<%= gColSpan %>" />

<tr class="normal">
	<td colspan="<%= gColSpan %>">
		<table class="find">
			<%@include file="resources/filter.jsp"%>
		</table>
	</td>
</tr>


<july:separator colspan="<%= gColSpan %>" />

<tr class="title">
	<td colspan="<%= gColSpan %>">
	<table class="buttons">
	<tr class="title">
		<td class="buttons"><july:addbutton page="/EditRRLResource.do?action=Add"/><july:backbutton/></TD>
        	<td class="navigator"><july:navigator/></TD>
	</tr>
	</table>
	</td>
</tr>
        
<july:separator colspan="<%= gColSpan %>" />

<!-- Table header -->
<tr class="title">
	<td class="title" width="1%">&nbsp;</td>
	<july:headercolumn key="label.resource.code" colType="number"/>
	<july:headercolumn key="label.resource.nfscodes" colType="string"/>
	<july:sortcolumn key="label.resource.manucode" colType="string" ascFinder="5" descFinder="6"/>
	<july:sortcolumn key="label.resource.name" colType="string" ascFinder="3" descFinder="4"/>
  <july:sortcolumn key="label.resource.model" colType="string" ascFinder="1" descFinder="2"/>
	<july:headercolumn key="label.resource.countpolicy.serial" colType="string"/>
	<july:headercolumn key="label.resource.countpolicy.partial" colType="string"/>
	<!--<july:headercolumn key="label.resource.priceable.short" colType="string"/> -->
	<td class="title" width="1%">&nbsp;</td>
</tr>

<july:separator colspan="<%= gColSpan %>" />
   
<!-- Table body -->
<logic:iterate id="rl" name="browseList" type="com.hps.july.cdbc.lib.CDBCRowObject">
<logic:present name="rl">
<%
	pageContext.setAttribute("resource",rl.getColumn("resource").asString());
%>
<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
	<td class="link">
    <july:editbutton page="/EditRRLResource.do" action="Edit" paramId="resource" paramName="resource" paramScope="page"/>
	</td>
	<td class="number"><july:stringwrite name="rl" property="resource"/></td>

	<% if (request.isUserInRole("dictResOperator") || request.isUserInRole("confResOperator")) { %> 
	<td class="text"><A HREF="#"><IMG BORDER="0" SRC="/images/bd.gif" onclick='showNFS(<july:stringwrite name="rl" property="resource"/>); return false;'></A><july:stringwrite name="rl" property="nfslist"/></td>
	<% } else { %> 
	<td class="text"><A HREF="#"><IMG BORDER="0" SRC="/images/bd.gif" onclick='editNFS(<july:stringwrite name="rl" property="resource"/>); return false;'></A><july:stringwrite name="rl" property="nfslist"/></td>
	<% } %>

	<td class="text"><july:stringwrite name="rl" property="manucode"/></td>
	<td class="text"><july:stringwrite name="rl" property="name"/></td>
	<td class="text"><july:stringwrite name="rl" property="model"/></td>
	<td class="text"><%if(rl.getColumn("countpolicy").asObject() != null && "S".equals(rl.getColumn("countpolicy").asString())) { %>+<%}%></td>
	<td class="text"><%if(rl.getColumn("countpolicy").asObject() != null && "P".equals(rl.getColumn("countpolicy").asString())) { %>+<%}%></td>
	<%--<td class="text"><%if(rl.getColumn("priceable").asObject() != null && "Y".equals(rl.getColumn("priceable").asString())) { %>+<%}%></td>--%>

	<td class="link"><july:delbutton page="/EditRRLResource.do?action=Delete" paramId="resource" paramName="resource" paramScope="page"/></td>
</tr>
<july:separator colspan="<%= gColSpan %>" />

</logic:present>
</logic:iterate>

<tr class="title">
	<td colspan="<%= gColSpan %>">
	<table class="buttons">
	<tr class="title">
		<td class="buttons"><july:addbutton page="/EditRRLResource.do?action=Add"/><july:backbutton/></td>
		<td class="navigator"><july:navigator/></td>
	</tr>
	</table>
	</td>
</tr>
        
<july:separator colspan="<%= gColSpan %>" />

</table>

<script language="javascript">
switchResourcetype();
switchResourcesubtype();
switchName();
switchModel();
switchManuf();
switchManucode();
switchNfscode();
switchNricode();
</script>

</july:browseform>
