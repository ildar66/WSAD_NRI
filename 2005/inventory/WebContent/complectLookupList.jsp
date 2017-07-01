<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import="com.hps.july.inventory.formbean.*"%>

<% java.lang.String gColSpan = "9"; %>

<july:browseform action="/ShowComplectLookupList.do">

<july:lookupresult tableId="brtable" resultCols="0;1"/>

<table class="main">
<tr class="title"><td class="title"><bean:message key="label.choose.complect"/></td></tr>
<TR class="normal">
	<td>
	<table class="find">
	<tr>
		<td class="title"><bean:message key="label.complect.position"/></td>
		<td class="title"><bean:write name="ComplectLookupListForm" property="posid" filter="true" />&nbsp;&nbsp;&nbsp;<bean:write name="ComplectLookupListForm" property="positionname" /></td>
	</tr>
	</table>
	</td>
</tr>
<tr class="title">
	<td><table class="buttons">
	<tr class="title">
		<td class="buttons"><july:closebutton page="/"/></td>
		<td class="navigator"><july:navigator/></td>
	</tr>
	</table></td>
</tr>
<tr><td>
<table class="main" id="brtable">

<!-- Table header -->
	<tr class="title">
		<td style="display:none;visibility:hidden;"><bean:message key="label.code"/></td>
		<td style="display:none;visibility:hidden;">&nbsp;</td>
		<july:headercolumn key="label.complect.equtype" colType="string"/>
		<july:headercolumn key="label.num" colType="string"/>
		<july:headercolumn key="label.name" colType="string"/>
		<july:headercolumn key="label.complect.comment" colType="string"/>
		<july:headercolumn key="label.complect.state" colType="string"/>
		<td class="title">№ Beenet Л.С.</td>
		<td class="title">Ответная часть</td>
	</tr>

<!-- Table body -->
<logic:iterate id="equ" name="browseList" indexId="index" type="com.hps.july.cdbc.lib.CDBCRowObject">
<%if(equ != null) {%>
<%
	String equipment = equ.getColumn("equipment").asString();
	String ty = equ.getColumn("type").asString();
	String equsubtype = equ.getColumn("equsubtype").asString();
	if(equ.getColumn("equsubtype").asObject() == null) {
		equsubtype = null;
	}

	String equstate = equ.getColumn("equstate").asString();
	String equtype = equ.getColumn("equtype").asString();
	if(equ.getColumn("equtype").asObject() == null) {
		equtype = "label.void";
	}
	Object equnumber = equ.getColumn("equnumber").asObject();
	String equname = equ.getColumn("equname").asString();

	String[] otv = ComplectLookupListForm.getOtv(equipment);
//System.out.println("EQTYPE:"+equtype+", EQUSUB:"+equsubtype+", STATE:"+equstate);
%>
	<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
		<td class="number" style="display:none;visibility:hidden;"><july:stringwrite name="equ" property="equipment"/></td>
		<td class="text" style="display:none;visibility:hidden;">
<%try {%>
<bean:message key="<%=equtype%>"/><%if(equsubtype!=null && !"".equals(equsubtype)) {%> <bean:message key="<%=equsubtype%>"/><%}%><%if(equnumber!=null){%> <july:stringwrite name="equ" property="equnumber"/><%}%><%if(equname != null && !"".equals(equname)) {%>, <july:stringwrite name="equ" property="equname"/><%}%>
<%}catch(Exception e) {}%>
		</td>
		<td class="text">
<%try {%>
<%if(equsubtype != null) {%><july:lookupreturn><bean:message key="<%=equtype%>"/><%if(equsubtype != null && !"".equals(equsubtype)) {%> <bean:message key="<%=equsubtype%>"/><%}%></july:lookupreturn><%} else {%><bean:message key="<%=equtype%>"/> <%if(equsubtype != null && !"".equals(equsubtype)) {%><bean:message key="<%=equsubtype%>"/><%}%><%}%>
<%}catch(Exception e) {}%>
		</td>
		<td class="text"><%if("C".equals(ty)){%><%=ComplectLookupListForm.getBeenetListString(equipment)%><%} else {%><july:stringwrite name="equ" property="equnumber"/><%}%></td>
		<td class="text"><july:stringwrite name="equ" property="equname"/></td>
		<td class="text"><july:stringwrite name="equ" property="equipcomment"/></td>
		<td class="text"><bean:message key="<%=equstate%>"/></td>
		<td class="text" style="font-size:8pt;" nowrap><%=otv[0]%></td>
		<td class="text" style="font-size:8pt;" nowrap><%=otv[1]%></td>
	</tr>
	<july:separator colspan="<%= gColSpan %>" />
<%} else {%>
	<tr class="normal">
		<td class="text" colspan="<%= gColSpan %>"><bean:message key="label.norecords"/></td>
	</tr>
	<july:separator colspan="<%= gColSpan %>" />
<%}%>
</logic:iterate>
</table>
</td>
</tr>

<tr class="title">
	<td><table class="buttons">
	<tr class="title">
		<td class="buttons"><july:closebutton page="/"/></td>
		<td class="navigator"><july:navigator/></td>
	</tr>
	</table></td>
</tr>

</table>

</july:browseform>
