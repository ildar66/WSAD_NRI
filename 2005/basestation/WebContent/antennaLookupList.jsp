<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import="org.apache.struts.util.*" %>
<%@ page import="com.hps.july.persistence.*" %>
<%@ page import="com.hps.july.basestation.valueobject.*" %>
<%@ page import="com.hps.july.siteinfo.valueobject.Position" %>

<% java.lang.String gColSpan = "11"; %>

<july:browseform action="/ShowAntennaLookupList.do" styleId="AntennaLookupList">
<july:lookupresult tableId="brtable" resultCols="0;2;3"/>
<table class="main">
	<tr class="title">
		<td class="title">
			<bean:message key="label.choose.antenna"/>
		</td>
	</tr>
	
	<tr class="normal">
		<td colspan="<%= gColSpan %>">
		<table class="find">
		<tr>
			<td class="title"><%--bean:message key="label.organization.name"/--%></td>
			<td class="title"><%--bean:write name="AccountLookupListForm" property="orgname"/--%></td>
		</tr>
		</table>
		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>

	<tr class="title">
		<td>
		<table class="buttons">
		<tr class="title">
			<td class="buttons"><july:closebutton page="/"/></TD>
			<td class="navigator"><july:navigator/></TD>
		</tr>
		</table>
		</td>
	</tr>
	<tr>
		<td>
		<table class="main" id="brtable">

        <!-- Table header -->
		<tr class="title">
			<td class="text" style="visibility:hidden;display:none;">&nbsp;</td>
			<july:headercolumn key="Antenna.number" colType="string"/>
			<july:headercolumn key="Antenna.type" colType="string"/>
			<july:headercolumn key="Antenna.asim" colType="string"/>
			<july:headercolumn key="Antenna.boand" colType="string"/>
			<july:headercolumn key="Antenna.direct" colType="string"/>
			<july:headercolumn bundle="dictionaryResources" key="label.antena.dir" colType="string"/>
			<july:headercolumn key="Antenna.ky" colType="string"/>
			<july:headercolumn key="Antenna.higth" colType="string"/>
			<july:headercolumn key="Antenna.nakl" colType="string"/>
		</tr>
		
        <!-- Table body -->
		<logic:iterate id="it" name="browseList" indexId="index">
		<logic:present name="it">
			<logic:notEqual name="it" property="antenna.locationtype" value="I">
<%
	AntennaObject bean = new AntennaObject((((Antena2sectorAccessBean) pageContext.getAttribute("it")).getAntenna()).getEJBRef());
%>
			<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
				<td class="number" style="visibility:hidden;display:none;"><bean:write name="it" property="antenna.idanten" filter="true"/></td>
				<td class="number"><bean:write name="it" property="antenna.numant" filter="true"/></td>
				<td class="text"><july:lookupreturn><bean:write name="it" property="antenna.resource.model" filter="true"/></july:lookupreturn></td>
				<td class="number"><bean:write name="it" property="antenna.azant" filter="true"/></td>
				<td class="number"><%= bean.getBandsString() %></td>
				<td class="text"><%=AntennaObject.getKindAntTitle(bean.getKindant())%></td>
				<td class="text"><%= bean.getWidthDiagram() %></td>
				<td class="text"><%= bean.getAmplificationStr() %></td>
				<td class="text"><bean:write name="it" property="antenna.hset1" filter="true"/></td>
				<td class="text"><bean:write name="it" property="antenna.nakl" filter="true"/></td>
			</tr>
			</logic:notEqual>
			<logic:equal name="it" property="antenna.locationtype" value="I">
				<tr style="visibility:hidden;display:none;"><td></td></tr>
			</logic:equal>
		</logic:present>
			
		<logic:notPresent name="it">
			<tr class="normal">
				<td class="text" colspan="<%= gColSpan %>"><bean:message key="label.norecords"/></td>
			</tr>
		</logic:notPresent>

		<july:separator colspan="<%= gColSpan %>"/>

		</logic:iterate>
		</table>
	</td>
</tr>

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
