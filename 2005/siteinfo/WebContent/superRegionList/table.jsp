<%@ page import="com.hps.july.jdbcpersistence.lib.RegionObject"%>
<%@ page import="com.hps.july.jdbcpersistence.lib.SuperRegionObject"%>
<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>

<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<%
String gColSpan = request.getAttribute("colspan")+"";
SuperRegionObject supreg=null;
%>
<!-- Table header -->
<tr class="title">
     <july:sortcolumn ascFinder='1' descFinder='2' key="label.superRegionList.code" colType="number" />
     <july:sortcolumn ascFinder='3' descFinder='4' key="label.superRegionList.name" colType="string" />
     <july:sortcolumn ascFinder='5' descFinder='6' key="label.supreglist.supregcode" colType="number" />
     <TD class="title">&nbsp;</TD>
</tr>
<july:separator colspan="<%= gColSpan %>" />
<!-- Table body -->
<logic:iterate id="sreg" name="browseList" type="com.hps.july.cdbc.lib.CDBCRowObject">
<logic:present name="sreg">
<% pageContext.setAttribute("supregid",sreg.getColumn("supregid").asString()); %>
<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
	<td class="number"><july:stringwrite name="sreg" property="supregid"/></td>
	<td class="text"><july:editlink page="/EditSuperRegion.do" action="Edit" paramId="supregid" paramName="supregid"><july:stringwrite name="sreg" property="supregname"/></july:editlink></td>
	<td class="number"><july:stringwrite name="sreg" property="supregcode"/></td>
	<td class="link"><july:delbutton page="/EditSuperRegion.do?action=Delete" paramId="supregid" paramName="supregid"/></td>
</tr>
<july:separator colspan="<%= gColSpan %>" />
</logic:present>
</logic:iterate>
