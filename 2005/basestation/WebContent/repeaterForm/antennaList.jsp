<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld" prefix="alex" %>
<%@ page import="org.apache.struts.util.*,com.hps.july.persistence.*,com.hps.july.basestation.*" %>
<%@ page import="com.hps.july.siteinfo.valueobject.Position,com.hps.july.jdbcpersistence.lib.DebugSupport" %>
<%@ page import="com.hps.july.basestation.valueobject.AntennaObject,com.hps.july.apptags.HasRegionAccessTag,com.hps.july.apptags.HasAccessTag" %>
<%@ page import="com.hps.july.jdbcpersistence.lib.Checks,com.hps.july.web.util.*" %>

<% String colspan = "7"; %>

<%
	String edit = null;
	switch (ParamsParser.getState(pageContext)) {
		case APPStates.REPEATER_EDIT:
			edit = "/EditRepeaterAntenna.do";
        	break;
		case APPStates.FROMSECTOR_REPEATER_EDIT:
			edit = "/EditFromSectorRepeaterAntenna.do";
        	break;
	}
%>

<july:separator colspan="2"/>

<tr><td colspan="2">

<table class="main" id="brtable">
	<tr class="title">
		<td class="title" colspan="<%= colspan %>">
			<july:addbutton page='<%= edit + "?action=Add" %>'/>
			<bean:message key="label.antennes"/>
		</td>
	</tr>
	
	<tr class="title">
		<td></td>
		<july:headercolumn key="Antenna.number" colType="string"/>
		<july:headercolumn key="Antenna.type" colType="string"/>
		<july:headercolumn key="Antenna.asim" colType="string"/>
		<july:headercolumn key="Antenna.direct" colType="string"/>
		<july:headercolumn key="Antenna.plañe" colType="string"/>
		<td></td>
	</tr>
	
	<logic:iterate id="ant" name="antennes">
	<logic:present name="ant">
		<% AntennaObject bean = new AntennaObject(((AntennaAccessBean) pageContext.getAttribute("ant")).getEJBRef()); %>
		<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
			<td class="link">
				<july:editbutton page="<%= edit %>" action="Edit" paramId="idanten" paramName="ant" paramProperty="idanten"/>
			</td>
			<td class="number"><bean:write name="ant" property="numant" filter="true"/></td>
			<td class="text"><%= bean.getResource() != null && bean.getResource().getModel() != null ? bean.getResource().getModel() : "" %></td>
			<td class="number"><july:numberwrite name="ant" property="azant"/></td>
			<td class="text"><%=AntennaObject.getKindAntTitle(bean.getKindant())%></td>
			<td class="number">
				<logic:equal name="ant" property="locationtype" value="I"><bean:message key="Antenna.place.indoor"/></logic:equal>
				<logic:equal name="ant" property="locationtype" value="O"><bean:message key="Antenna.place.outdoor"/></logic:equal>
			</td>
			<td class="link">
				<july:delbutton page='<%= edit + "?action=Delete" %>' paramId="idanten" paramName="ant" paramProperty="idanten"/>
			</td>
		</tr>
	</logic:present>
	</logic:iterate>

</table>

</td></tr>

<july:separator colspan="2"/>