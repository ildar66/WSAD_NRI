<%@ page language="java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import="com.hps.july.basestation.formbean.FromSectorRepeaterList"%>
<%@ page import="com.hps.july.jdbcpersistence.lib.Checks"%>
<%@ page import="com.hps.july.jdbcpersistence.lib.SearchConstants"%>
<%@ page import="com.hps.july.jdbcpersistence.lib.AppConstants"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<%
	String gColSpan = "9";
	FromSectorRepeaterList lform = (FromSectorRepeaterList)session.getAttribute("FromSectorRepeaterList");
	
	String addAction;
	String repeaterAction;

	repeaterAction = "/EditFactFromSectorRepeater.do";
	addAction = repeaterAction + 
		"?action=Add&positionIdFrm="+lform.getPositionId()+
		"&idsect="+lform.getIdsect();
%>
<july:browseform action="/ShowFromSectorRepeaterList.do" styleId="FromSectorRepeaterList">

<table class="main">
<july:separator colspan="<%= gColSpan %>"/>
	
<tr class="normal">
	<td colspan="<%= gColSpan %>">
		<table class="find">
			<tr>
				<td class="text" width="30%"><bean:message key="label.replist.position"/>:</td>
				<td class="text" width="70%" colspan="3"><bean:write name="FromSectorRepeaterList" property="position" filter="true"/></td>
			</tr>
			<tr>
				<td class="text" width="30%"><bean:message key="label.replist.zone"/>:</td>
				<td class="text" width="70%" colspan="3"><bean:write name="FromSectorRepeaterList" property="zone" filter="true"/></td>
			</tr>
			<tr>
				<td class="text" width="30%"><bean:message key="label.replist.address"/>:</td>
				<td class="text" width="70%" colspan="3"><bean:write name="FromSectorRepeaterList" property="address" filter="true"/></td>
			</tr>
			<tr>
				<td class="text" width="30%"><bean:message key="label.replist.number"/>:</td>
				<td class="text" width="20%"><bean:write name="FromSectorRepeaterList" property="number" filter="true"/></td>
				<td class="text" width="30%"><bean:message key="label.replist.donor.number"/>:</td>
				<td class="text" width="20%"><bean:write name="FromSectorRepeaterList" property="donornumber" filter="true"/></td>
			</tr>
			<tr>
				<td class="text" width="30%"><bean:message key="label.replist.name"/>:</td>
				<td class="text" width="20%"><bean:write name="FromSectorRepeaterList" property="name" filter="true"/></td>
				<td class="text" width="30%"><bean:message key="label.replist.donor.name"/>:</td>
				<td class="text" width="20%"><bean:write name="FromSectorRepeaterList" property="donorname" filter="true"/></td>
			</tr>
			<tr>
				<td class="text" width="30%"><bean:message key="label.replist.type"/>:</td>
				<td class="text" width="70%" colspan="3">
					<logic:equal name="FromSectorRepeaterList" property="type" value="D"><bean:message key="label.equipment.stationdamps"/></logic:equal>
					<logic:equal name="FromSectorRepeaterList" property="type" value="S"><bean:message key="label.equipment.stationgsm"/></logic:equal>
					<logic:equal name="FromSectorRepeaterList" property="type" value="C"><bean:message key="label.equipment.stationdcs"/></logic:equal>
					<logic:equal name="FromSectorRepeaterList" property="type" value="G"><bean:message key="label.equipment.stationboth"/></logic:equal>
				</td>
			</tr>
		</table> 
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>"/>

<tr class="title">
	<td colspan="<%= gColSpan %>">
	<table class="buttons">
	<tr class="title">
		<td class="buttons">
			<july:addbutton page='<%=addAction%>'/>
			<july:backbutton/>
		</td>
		<td class="navigator"><july:navigator/></td>
	</tr>
	</table>
	</td>
</tr>
	
<july:separator colspan="<%= gColSpan %>"/>

<!-- Table header -->
<tr class="title">
	<td>&nbsp;</td>
	<july:headercolumn key="repeaterlist.pos.name" colType="string"/>
	<july:headercolumn key="repeaterlist.resource" colType="string"/>
	<july:headercolumn key="repeaterlist.repiterclass" colType="string"/>
	<july:headercolumn key="repeaterlist.reppower" colType="string"/>
	<july:headercolumn key="repeaterlist.bandwidth.numchanals" colType="string"/>
	<july:headercolumn key="repeaterlist.donortype" colType="string"/>
	<july:headercolumn key="label.baseStationList.state" colType="string"/>
	<td>&nbsp;</td>
</tr>

<july:separator colspan="<%= gColSpan %>"/>

<!-- Table body -->
<logic:iterate id="it" name="browseList">
	<logic:present name="it">
	<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
		<td align="center">
			<july:editbutton page="<%=repeaterAction%>" action='Edit' paramId="storageplace" paramName="it" paramProperty="storageplace"/>
		</td>
		<td class="text"><bean:write name="it" property="position.name" filter="true"/></td>
		<td class="text"><bean:write name="it" property="resource.name" filter="true"/></td>
		<td class="text">
			<logic:equal name="it" property="repiter_class" value="A"><bean:message key="repeaterlist.repiterclass.a"/></logic:equal>
			<logic:equal name="it" property="repiter_class" value="B"><bean:message key="repeaterlist.repiterclass.b"/></logic:equal>
			<logic:equal name="it" property="repiter_class" value="C"><bean:message key="repeaterlist.repiterclass.c"/></logic:equal>
			<logic:equal name="it" property="repiter_class" value="D"><bean:message key="repeaterlist.repiterclass.d"/></logic:equal>
			<logic:equal name="it" property="repiter_class" value="E"><bean:message key="repeaterlist.repiterclass.e"/></logic:equal>
		</td>
		<td class="text"><july:sumwrite name="it" property="reppower"/></td>
		<td class="text">
			<logic:notEqual name="it" property="repiter_class" value="B">
				<logic:notEqual name="it" property="repiter_class" value="C">
					<july:sumwrite name="it" property="bandwidth"/>
				</logic:notEqual>
			</logic:notEqual>
			<logic:notEqual name="it" property="repiter_class" value="A">
				<logic:notEqual name="it" property="repiter_class" value="D">
					<logic:notEqual name="it" property="repiter_class" value="E">
						<july:sumwrite name="it" property="numchanals"/>
					</logic:notEqual>
				</logic:notEqual>
			</logic:notEqual>
		</td>
		<td class="text">
			<logic:equal name="it" property="donor_type" value="A"><bean:message key="repeaterlist.donortype.a"/></logic:equal>
			<logic:equal name="it" property="donor_type" value="B"><bean:message key="repeaterlist.donortype.b"/></logic:equal>
			<logic:equal name="it" property="donor_type" value="C"><bean:message key="repeaterlist.donortype.c"/></logic:equal>
		</td>
		<td class="text">
			<logic:equal name="it" property="equipmentState" value="P"><bean:message key="BaseStation.equipmentState.P"/></logic:equal>
			<logic:equal name="it" property="equipmentState" value="M"><bean:message key="BaseStation.equipmentState.M"/></logic:equal>
			<logic:equal name="it" property="equipmentState" value="R"><bean:message key="BaseStation.equipmentState.R"/></logic:equal>
			<logic:equal name="it" property="equipmentState" value="T"><bean:message key="BaseStation.equipmentState.T"/></logic:equal>
			<logic:equal name="it" property="equipmentState" value="W"><bean:message key="BaseStation.equipmentState.W"/></logic:equal>
			<logic:equal name="it" property="equipmentState" value="D"><bean:message key="BaseStation.equipmentState.D"/></logic:equal>
		</td>
		<td class="link">
			<july:delbutton page='<%=repeaterAction+"?action=Delete"%>' paramId="storageplace" paramName="it" paramProperty="storageplace"/>
		</td>
	</tr>
	<july:separator colspan="<%= gColSpan %>"/>
	</logic:present>
</logic:iterate>

<tr class="title">
	<td colspan="<%= gColSpan %>">
	<table class="buttons">
	<tr class="title">
		<td class="buttons">
			<july:addbutton page='<%=addAction%>'/>
			<july:backbutton/>
		</td>
		<td class="navigator"><july:navigator/></td>
	</tr>
	</table>
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>"/>

</table>

</july:browseform>
