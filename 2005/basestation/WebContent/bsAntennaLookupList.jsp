<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import="com.hps.july.persistence.*" %>
<%@ page import="com.hps.july.basestation.valueobject.*" %>

<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% String gColSpan = "8"; %>

<july:browseform action="/ShowBSAntennaLookupList.do" styleId="BSAntennaLookupListForm">

<july:lookupresult tableId="brtable" resultCols="0;1;2"/>

<table class="main">

<tr class="title">
	<td class="title">
		<bean:message key="label.choose.bsantenna"/>
	</td>
</tr>

<july:separator/>

<%-- filter fields --%>
<tr class='normal'>
	<td>
		<table class='find'>
		<tr>
			<td class="title"><bean:message key="label.bsantennalookup.bs"/>:</td>
			<td class="title">
				<html:hidden property="bs.key"/>
				<bean:write name="BSAntennaLookupListForm" property="bs.fullname" filter="true"/>
			</td>
		</tr>
		<tr>
			<td class="title"><bean:message key="label.bsantennalookup.sector"/>:</td>
			<td class="title">
				<html:hidden property="sector.key"/>
				<bean:write name="BSAntennaLookupListForm" property="sector.fullname" filter="true"/>
			</td>
		</tr>
		</table>
	</td>
</tr>

<july:separator/>

<%-- top navigation line --%>
<tr class="title">
	<td>
		<table class="buttons">
		<tr class="title">
			<td class="buttons"><july:closebutton page="/"/></td>
			<td class="navigator"><july:navigator/></td>
		</tr>
		</table>
	</td>
</tr>

<july:separator/>

<%-- table rendering --%>
<tr>
<td>
<table class="main" id="brtable">

<tr class="title">
	<td style="visibility:hidden;display:none;"></td>
	<td style="visibility:hidden;display:none;"></td>
	<td style="visibility:hidden;display:none;"></td>
	<july:headercolumn key="label.bsantenna.num" colType="integer"/>
	<july:headercolumn key="label.bsantenna.name" colType="string"/>
	<july:headercolumn key="label.bsantenna.nakl" colType="integer"/>
	<july:headercolumn key="label.bsantenna.hset" colType="integer"/>
	<july:headercolumn key="label.bsantenna.diagnapr" colType="integer"/>
	<july:headercolumn key="label.bsantenna.ku" colType="integer"/>
	<july:headercolumn key="label.bsantenna.trr" colType="integer"/>
</tr>
<%
	int index = 0;
%>
<logic:iterate id="it" name="browseList">
<logic:present name="it">
<%
	try {
		AntennaAccessBean antenna = (AntennaAccessBean)pageContext.getAttribute("it");
		AntennaObject ao = new AntennaObject(antenna.getEJBRef());
		String model = antenna.getResource().getModel();
		if(model == null) model = "";
		pageContext.setAttribute("resourceModel",model);
		pageContext.setAttribute("index",new Integer(index));

%>
<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
	<td style="visibility:hidden;display:none;"><bean:write name="it" property="idanten" filter="true"/></td>
	<td style="visibility:hidden;display:none;"><bean:write name="resourceModel" filter="true"/></td>
	<td style="visibility:hidden;display:none;"><july:numberwrite name="it" property="azant"/></td>
	<td class="number"><bean:write name="it" property="numant" filter="true"/></td>
	<td class="text"><july:lookupreturn><bean:write name="resourceModel" filter="true"/></july:lookupreturn></td>
	<td class="number"><bean:write name="it" property="nakl" filter="true"/></td>
	<td class="number"><bean:write name="it" property="hset1" filter="true" /></td>
	<td class="number"><%= ao.getWidthDiagram() %></td>
	<td class="number"><%= ao.getAmplificationStr() %></td>
	<td class="text"><%=AntennaObject.getKindAntTitle(ao.getKindant())%></td>
</tr>

<%
		index++;
	} catch(Exception rowe) {
		System.out.println("BSANTLOOKUPLIST: Exception while processing row of class:"+rowe.getClass().getName());
	}
%>
</logic:present>
<logic:notPresent name="it">
<tr class="normal">
	<td class="text" colspan="<%= gColSpan %>">
		<bean:message key="label.norecords"/>
	</td>
</tr>
</logic:notPresent>
<july:separator colspan="<%= gColSpan %>" />
</logic:iterate>
</table>
</td>
</tr>

<%-- bottom navigation line --%>
<tr class="title">
	<td>
		<table class="buttons">
		<tr class="title">
			<td class="buttons"><july:closebutton page="/"/></td>
			<td class="navigator"><july:navigator/></td>
		</tr>
		</table>
	</td>
</tr>

</table>

</july:browseform>
