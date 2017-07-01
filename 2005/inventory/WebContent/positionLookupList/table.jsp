<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<%@ page import="org.apache.struts.util.*,com.hps.july.siteinfo.valueobject.*"%>
<% java.lang.String gColSpan = "7"; %>

<%--
<logic:equal name="PositionLookupListForm" property="planstate" value="<%=com.hps.july.siteinfo.valueobject.Position.PLANSTATE_CHECK_Fact%>">
<july:lookupresult tableId="brtable" resultCols="6;2;7;8;9;3;10;11;12;13;14;15;16"/>
</logic:equal>

<logic:equal name="PositionLookupListForm" property="planstate" value="<%=com.hps.july.siteinfo.valueobject.Position.PLANSTATE_CHECK_Plan%>">
<july:lookupresult tableId="brtable" resultCols="6;2;7;8;9;3;10;11;12;13;14;15;16"/>
</logic:equal>
--%>

<tr>
<td>
<table class="main" id="brtable">
<!-- Table header -->

<tr class="title">
	<july:sortcolumn key="label.position.gsmid" colType="string" ascFinder="5" descFinder="6" />
	<july:sortcolumn key="label.position.dampsid" colType="string" ascFinder="7" descFinder="8" />
	<july:sortcolumn key="label.position.name" colType="string" ascFinder="3" descFinder="4" />
	<july:headercolumn key="label.position.addr" colType="string"/>
	<july:headercolumn key="label.position.netzone" colType="string"/>
	<july:headercolumn key="label.position.inactionh" colType="string"/>
	<%for(int i=7;i<7+14;i++){%><td style='visibility:hidden;display:none'></td><%}%>
</tr>

<!-- Table body -->

<%
	int ind = 0;
%>
<logic:iterate id="pos" name="browseList" type="com.hps.july.cdbc.lib.CDBCRowObject">
<logic:present name="pos">
<%
	boolean inAction = "Y".equals(pos.getColumn("inaction").asString());
	Object dampsname = pos.getColumn("dampsname").asObject();
	pageContext.setAttribute("index",new Integer(ind));
	String posid = "";
	Object did = pos.getColumn("dampsid").asObject();
	Object gid = pos.getColumn("gsmid").asObject();
	if(gid != null) { posid += "D"+gid; }
	if(!"".equals(posid)) { posid += " "; }
	if(did != null) { posid += "A"+did; }
	pageContext.setAttribute("pos_posid",posid);
%>

<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
	<td class="number"><july:stringwrite name="pos" property="gsmid"/></td>
	<td class="number"><july:stringwrite name="pos" property="dampsid"/></td>
	<td class="text"><july:lookupreturn><july:stringwrite name="pos" property="posname"/><%if(dampsname != null){%> / <july:stringwrite name="pos" property="dampsname"/><%}%></july:lookupreturn></td>
	<td class="text"><july:stringwrite name="pos" property="posaddress"/></td>
	<td class="text"><july:stringwrite name="pos" property="zonecode"/></td>
	<td class="text"><%if(inAction){%><bean:message key="label.position.inactionh"/><%}%></td>
<%--hidden--%>
	<td class="number" style='visibility:hidden;display:none'><july:stringwrite name="pos" property="storageplace"/></td>
	<td class="text" style='visibility:hidden;display:none'><july:stringwrite name="pos" property="supregname"/></td>
	<td class="text" style='visibility:hidden;display:none'><july:stringwrite name="pos" property="regionname"/></td>
	<td class="text" style='visibility:hidden;display:none'><july:stringwrite name="pos" property="zonename"/></td>
	<td class="text" style='visibility:hidden;display:none'><july:stringwrite name="pos" property="latitude"/></td>
	<td class="text" style='visibility:hidden;display:none'><july:stringwrite name="pos" property="longitude"/></td>
	<td class="text" style='visibility:hidden;display:none'><july:datewrite name="pos" property="datebeginbuild"/></td>
	<td class="text" style='visibility:hidden;display:none'><july:stringwrite name="pos" property="dampsid"/></td>
	<td class="text" style='visibility:hidden;display:none'><july:stringwrite name="pos" property="gsmid"/></td>
	<td class="text" style='visibility:hidden;display:none'><%if(dampsname != null){%><july:stringwrite name="pos" property="dampsname"/><%}%></td>
	<td class="text" style='visibility:hidden;display:none'><july:stringwrite name="pos" property="posname"/></td>
	<td class="number" style='visibility:hidden;display:none'><bean:write name="pos_posid" filter="true"/></td>
	<td class="text" style='visibility:hidden;display:none'></td>
	<td class="text" style='visibility:hidden;display:none'></td>
	<td class="text" style='visibility:hidden;display:none'></td>
	<td class="text" style='visibility:hidden;display:none'></td>
	<td class="text" style='visibility:hidden;display:none'></td>
</tr>

<july:separator colspan="<%= gColSpan %>" />

<%
	ind++;
%>
</logic:present>
<logic:notPresent name="pos">
<tr class="normal">
	<td class="text" colspan="<%= gColSpan %>"><bean:message key="label.norecords"/></td>
</tr>
</logic:notPresent>
</logic:iterate>

</table>
</td>
</tr>
