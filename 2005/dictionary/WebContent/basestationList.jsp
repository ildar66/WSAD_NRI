<%@ page language="java" %>
<%@ page contentType="TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "11"; %>

<jsp:include page="showNfsScript.jsp" flush="true"/>

<july:browseform action="/ShowBasestationList.do" styleId="BasestationListForm">

<%@include file="resources/script.jsp" %>

<script language="javascript">
function switchGeneration() {
	switchItem('generation',document.forms[0].isGeneration[0].checked);
}
</script>

<table class="main">
 
<july:separator colspan="<%= gColSpan %>"/>

<TR class="normal">
	<TD colspan="<%= gColSpan %>">
	<table class="find">
<%@include file="resources/filter.jsp"%>
	<tr>
		<td class="title">
			<july:checkbox property="isGeneration" insertable="true" updatable="true" value="true" onclick="switchGeneration();"/><bean:message key="label.basestation.bygen"/>:
		</td>
		<td class="title">
			<july:string property="generation" styleId="generation" size="25" insertable="true" updatable="true" styleClass="editsearch"/>
		</td>
	</tr>
	</table>
	</TD>
</TR>

<july:separator colspan="<%= gColSpan %>"/>

<tr class="title">
	<td colspan="<%= gColSpan %>">
	<TABLE class="buttons">
	<TR class="title">
		<TD class="buttons">
			<july:addbutton page="/EditBasestation.do?action=Add"/>
			<july:backbutton/>
		</TD>
		<TD class="navigator">
			<july:navigator/>
		</TD>
	</TR>
	</TABLE>
	</TD>
</tr>

<july:separator colspan="<%= gColSpan %>"/>

<tr class="title">
	<td>&nbsp;</td>
	<july:headercolumn key="label.code" colType="number"/>
	<july:headercolumn key="label.resource.nfscodes" colType="string"/>
	<july:sortcolumn key="label.resource.manucode" colType="string" ascFinder="5" descFinder="6"/>
	<july:sortcolumn key="label.basestation.model" colType="string" ascFinder="1" descFinder="2"/>
	<july:headercolumn key="label.basestation.manufacturer" colType="string"/>
	<july:headercolumn key="label.basestation.standard" colType="string"/>
	<july:headercolumn key="label.basestation.generation" colType="string"/>
	<july:headercolumn key="label.basestation.extent" colType="string"/>
	<july:headercolumn key="label.basestation.devline" colType="string"/>
	<td>&nbsp;</td>
</tr>

<july:separator colspan="<%= gColSpan %>"/>

<logic:iterate id="it" name="browseList" type="com.hps.july.cdbc.lib.CDBCRowObject">
<logic:present name="it">
<%
	pageContext.setAttribute("resource",it.getColumn("resource").asString());
%>
<!-- it.getColumn("active").asString() = <%=it.getColumn("active").asString()%>-->
<% if ("N".equals(it.getColumn("active").asString())) { %>
<tr class="autodoc" onMouseOver="className='select'" onMouseOut="className='autodoc'">
<% } else { %>
<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
<% } %>
<%-- <tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'"> --%>
	<td class="link"><july:editbutton page="/EditBasestation.do" action="Edit" paramId="resource" paramName="resource" paramScope="page"/></td>
	<td class="number"><july:stringwrite name="it" property="resource"/></td>
	
	<% if (request.isUserInRole("dictResOperator") || request.isUserInRole("confResOperator")) { %> 
	<td class="text"><A HREF="#"><IMG BORDER="0" SRC="/images/bd.gif" onclick='showNFS(<july:stringwrite name="it" property="resource"/>); return false;'></A><july:stringwrite name="it" property="nfslist"/></td>
	<% } else { %> 
	<td class="text"><A HREF="#"><IMG BORDER="0" SRC="/images/bd.gif" onclick='editNFS(<july:stringwrite name="it" property="resource"/>); return false;'></A><july:stringwrite name="it" property="nfslist"/></td>
	<% } %>

	<td class="text"><july:stringwrite name="it" property="manucode"/></td>
	<td class="text"><july:stringwrite name="it" property="model"/></td>
	<td class="text"><july:stringwrite name="it" property="manufname"/></td>
	<td class="text"><bean:message key='<%="label.basestation.standard."+it.getColumn("standart").asString()%>'/></td>
	<td class="text"><july:stringwrite name="it" property="generation"/></td>
	<td class="text"><july:stringwrite name="it" property="bounds"/></td>
	<td class="text"><july:stringwrite name="it" property="productline"/></td>
	<td class="link"><july:delbutton page="/EditBasestation.do?action=Delete" paramId="resource" paramName="resource" paramScope="page"/></td>
</tr>
<july:separator colspan="<%= gColSpan %>"/>
</logic:present>
</logic:iterate>

<tr class="title">
	<td colspan="<%= gColSpan %>">
	<TABLE class="buttons">
	<TR class="title">
		<TD class="buttons">
			<july:addbutton page="/EditBasestation.do?action=Add"/>
			<july:backbutton/>
		</TD>
		<TD class="navigator">
			<july:navigator/>
		</TD>
	</TR>
	</TABLE>
	</TD>
</tr>

<july:separator colspan="<%= gColSpan %>"/>

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
switchGeneration();
</script>

</july:browseform>
