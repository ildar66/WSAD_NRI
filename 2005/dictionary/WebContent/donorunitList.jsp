<%@ page language="java" %>
<%@ page contentType="TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "10"; %>

<jsp:include page="showNfsScript.jsp" flush="true"/>

<july:browseform action="/ShowDonorUnitList.do" styleId="DonorUnitListForm">

<%@include file="resources/script.jsp" %>

<table class="main">

<july:separator colspan="<%= gColSpan %>"/>

<TR class="normal">
	<TD colspan="<%= gColSpan %>">
	<table class="find">
<%@include file="resources/filter.jsp"%>
	</table>
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>"/>

<tr class="title">
	<td colspan="<%= gColSpan %>">
	<TABLE class="buttons">
	<TR class="title">
		<TD class="buttons">
			<july:addbutton page="/EditDonorUnit.do?action=Add"/>
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
	<july:sortcolumn key="label.repeater.model" colType="string" ascFinder="1" descFinder="2"/>
	<july:headercolumn key="label.repeater.manufacturer" colType="string"/>
	<%--five field above are common--%>
	<july:headercolumn key="label.repeater.freqcarry.inpower" colType="string"/>
	<td>&nbsp;</td>
</tr>

<july:separator colspan="<%= gColSpan %>"/>


<logic:iterate id="it" name="browseList" type="com.hps.july.cdbc.lib.CDBCRowObject">
<logic:present name="it">
<%
	pageContext.setAttribute("resource",it.getColumn("resource").asString());
%>
<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
	<td class="link"><july:editbutton page="/EditDonorUnit.do" action="Edit" paramId="resource" paramName="resource" paramScope="page"/></td>
	<td class="number"><july:stringwrite name="it" property="resource"/></td>
	
	<% if (request.isUserInRole("dictResOperator") || request.isUserInRole("confResOperator")) { %> 
	<td class="text"><A HREF="#"><IMG BORDER="0" SRC="/images/bd.gif" onclick='showNFS(<july:stringwrite name="it" property="resource"/>); return false;'></A><july:stringwrite name="it" property="nfslist"/></td>
	<% } else { %> 
	<td class="text"><A HREF="#"><IMG BORDER="0" SRC="/images/bd.gif" onclick='editNFS(<july:stringwrite name="it" property="resource"/>); return false;'></A><july:stringwrite name="it" property="nfslist"/></td>
	<% } %>
	
	<td class="text"><july:stringwrite name="it" property="manucode"/></td>
	<td class="text"><july:stringwrite name="it" property="model"/></td>
	<td class="text"><july:stringwrite name="it" property="manufname"/></td>
	
	<%--td class="text"><bean:message key='<%="label.repeater."+it.getColumn("type").asString()%>'/></td>--%>

	<td class="text"><july:stringwrite name="it" property="power"/></td>
	<td class="link"><july:delbutton page="/EditDonorUnit.do?action=Delete" paramId="resource" paramName="resource" paramScope="page"/></td>
</tr>
<july:separator colspan="<%= gColSpan %>"/>
</logic:present>
</logic:iterate>

<tr class="title">
	<td colspan="<%= gColSpan %>">
	<TABLE class="buttons">
	<TR class="title">
		<TD class="buttons">
			<july:addbutton page="/EditDonorUnit.do?action=Add"/>
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
</script>

</july:browseform>
