<%@ page language="java" %>
<%@ page contentType="TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "12"; %>

<jsp:include page="showNfsScript.jsp" flush="true"/>

<july:browseform action="/ShowAntenaList.do" styleId="AntenaListForm">

<%@include file="resources/script.jsp" %>
<%@include file="resources/antenaScript.jsp" %>

<table class="main">

<july:separator colspan="<%= gColSpan %>"/>

<TR class="normal">
	<TD colspan="<%= gColSpan %>">
	<table class="find">
<%@include file="resources/filter.jsp"%>
	<tr>
		<td class="title"><bean:message key="label.antena.range"/></td>
		<td class="title">
			<july:checkbox styleClass="text" property="isRange[0]" insertable="true" updatable="true" onclick="switchRanges();"/>&nbsp;<bean:message key="label.all"/>&nbsp;&nbsp;&nbsp;
			<july:checkbox styleClass="text" property="isRange[1]" insertable="true" updatable="true" />&nbsp;800&nbsp;&nbsp;&nbsp;
			<july:checkbox styleClass="text" property="isRange[2]" insertable="true" updatable="true" />&nbsp;900&nbsp;&nbsp;&nbsp;
			<july:checkbox styleClass="text" property="isRange[3]" insertable="true" updatable="true" />&nbsp;1800&nbsp;&nbsp;&nbsp;
			<july:checkbox styleClass="text" property="isRange[4]" insertable="true" updatable="true" />&nbsp;2000&nbsp;&nbsp;&nbsp;
		</td>
	</tr>
	<tr>
		<td class="title"><bean:message key="label.antena.polar"/></td>
		<td class="title">
			<html:select property="polar" styleClass="search" style="width:128;">
				<html:option value="*" key="label.antena.polar.all"/>
				<html:option value="V" key="label.antena.polar.vert"/>
				<html:option value="C" key="label.antena.polar.cross"/>
			</html:select>
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
			<july:addbutton page="/EditAntena.do?action=Add"/>
			<july:backbutton page="/main.do"/>
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
	<july:sortcolumn key="label.antena.model" colType="string" ascFinder="1" descFinder="2"/>
	<july:headercolumn key="label.antena.manufacturer" colType="string"/>
	<july:headercolumn key="label.antena.range" colType="string"/>
	<july:headercolumn key="label.antena.polar" colType="string"/>
	<july:headercolumn key="label.antena.entriescount" colType="number"/>
	<july:headercolumn key="label.antena.extent" colType="string"/>
	<july:headercolumn key="label.antena.amplify" colType="string"/>
	<td>&nbsp;</td>
</tr>

<july:separator colspan="<%= gColSpan %>"/>

<logic:iterate id="it" name="browseList" type="com.hps.july.cdbc.lib.CDBCRowObject">
<logic:present name="it">
<%
	pageContext.setAttribute("resource",it.getColumn("resource").asString());

	String bands = "";
	if(it.getColumn("band0").asObject() != null) {
		bands+=it.getColumn("band0").asString();
	}
	if(it.getColumn("band1").asObject() != null) {
		if(bands.length() > 0) { bands+="/"; }
		bands+=it.getColumn("band1").asString();
	}
	if(it.getColumn("band2").asObject() != null) {
		if(bands.length() > 0) { bands+="/"; }
		bands+=it.getColumn("band2").asString();
	}
	if(it.getColumn("band3").asObject() != null) {
		if(bands.length() > 0) { bands+="/"; }
		bands+=it.getColumn("band3").asString();
	}
	pageContext.setAttribute("bands",bands);

	String amps = "";
	if(it.getColumn("amp0").asObject() != null) {
		amps+=it.getColumn("amp0").asString();
	}
	if(it.getColumn("amp1").asObject() != null) {
		if(amps.length() > 0) { amps+="/"; }
		amps+=it.getColumn("amp1").asString();
	}
	if(it.getColumn("amp2").asObject() != null) {
		if(amps.length() > 0) { amps+="/"; }
		amps+=it.getColumn("amp2").asString();
	}
	if(it.getColumn("amp3").asObject() != null) {
		if(amps.length() > 0) { amps+="/"; }
		amps+=it.getColumn("amp3").asString();
	}
	pageContext.setAttribute("amps",amps);
%>

<% if ("N".equals(it.getColumn("active").asString())) { %>
<tr class="autodoc" onMouseOver="className='select'" onMouseOut="className='autodoc'">
<% } else { %>
<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
<% } %>
	<td class="link"><july:editbutton page="/EditAntena.do" action="Edit" paramId="resource" paramName="resource" paramScope="page"/></td>
	<td class="number"><july:stringwrite name="it" property="resource"/></td>
	
	<% if (request.isUserInRole("dictResOperator") || request.isUserInRole("confResOperator")) { %> 
	<td class="text"><A HREF="#"><IMG BORDER="0" SRC="/images/bd.gif" onclick='showNFS(<july:stringwrite name="it" property="resource"/>); return false;'></A><july:stringwrite name="it" property="nfslist"/></td>
	<% } else { %> 
	<td class="text"><A HREF="#"><IMG BORDER="0" SRC="/images/bd.gif" onclick='editNFS(<july:stringwrite name="it" property="resource"/>); return false;'></A><july:stringwrite name="it" property="nfslist"/></td>
	<% } %>
	
	<td class="text"><july:stringwrite name="it" property="manucode"/></td>
	<td class="text"><july:stringwrite name="it" property="model"/></td>
	<td class="text"><july:stringwrite name="it" property="manufname"/></td>
	<td class="text"><july:stringwrite name="bands"/></td>
	<td class="text"><bean:message key='<%="label.antena.polar."+it.getColumn("polarization").asString()%>'/></td>
	<td class="text"><july:stringwrite name="it" property="entriescount"/></td><!---->
	<td class="text"><july:stringwrite name="it" property="bounds"/></td>
	<td class="text"><july:stringwrite name="amps"/></td>
	<td class="link"><july:delbutton page="/EditAntena.do?action=Delete" paramId="resource" paramName="resource" paramScope="page"/></td>
</tr>
<july:separator colspan="<%= gColSpan %>"/>
</logic:present>
</logic:iterate>

<tr class="title">
	<td colspan="<%= gColSpan %>">
	<TABLE class="buttons">
	<TR class="title">
		<TD class="buttons">
			<july:addbutton page="/EditAntena.do?action=Add"/>
			<july:backbutton page="/main.do"/>
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
switchRanges();
</script>

</july:browseform>
