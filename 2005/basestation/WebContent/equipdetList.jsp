<%@ page language = "java" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.basestation.*,com.hps.july.persistence.*" %>
<%@ page import="com.hps.july.basestation.formbean.EquipdetListForm" %>
<%@ page import="com.hps.july.jdbcpersistence.lib.Checks" %>
<%@ page import="com.hps.july.jdbcpersistence.lib.AppConstants" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<%
	String gColSpan = "6";
	EquipdetListForm elForm=(EquipdetListForm)pageContext.findAttribute("EquipdetListForm");
// StateManager sm=(StateManager)session.getAttribute(AppConstants.PARAM_STATE_MANAGER); DD
%>

<july:browseform action="/ShowEquipdetList.do">

<table class="main">

<july:separator colspan="<%= gColSpan %>" />

<TR class="normal">
 <TD colspan="<%= gColSpan %>">
 
    <table class="find">
    <TR>
       <td class="title"><bean:message key="label.equipment.posname"/>:</td>
       <td class="title"><bean:write name="EquipdetListForm" property="posid" />&nbsp;&nbsp;&nbsp;<bean:write name="EquipdetListForm" property="posname" /></td>
    </TR>        
    <TR>
       <td class="title"><bean:message key="label.equipdet.complect"/>:</td>
       <td class="title">
		  <logic:equal name="EquipdetListForm" property="eqobj.equipmentType" value="A">
			  <bean:message key="label.equipment.type.basestation"/>
		  </logic:equal>
		  <logic:equal name="EquipdetListForm" property="eqobj.equipmentType" value="B">
			  <bean:message key="label.equipment.type.comequipment"/>
		  </logic:equal>
		  <logic:equal name="EquipdetListForm" property="eqobj.equipmentType" value="C">
			  <bean:message key="label.equipment.type.controller"/>
		  </logic:equal>
		  <logic:equal name="EquipdetListForm" property="eqobj.equipmentType" value="D">
			  <bean:message key="label.equipment.type.switch"/>
		  </logic:equal>
		  <logic:equal name="EquipdetListForm" property="eqobj.equipmentType" value="E">
			  <bean:message key="label.equipment.type.other"/>
		  </logic:equal>
	          <logic:equal name="EquipdetListForm" property="eqobj.equipmentType" value="R">
			  <bean:message key="label.equipment.type.repeater"/>
		  </logic:equal>
	          <logic:equal name="EquipdetListForm" property="eqobj.equipmentType" value="F">
			  <bean:message key="label.equipment.type.wlan"/>
		  </logic:equal>
		  <logic:equal name="EquipdetListForm" property="eqobj.equipmentType" value="N">
			  <bean:message key="label.equipment.type.unknown"/>
		  </logic:equal>

			&nbsp;

		  <logic:equal name="EquipdetListForm" property="eqobj.equipmentType" value="A">
			  <logic:equal name="EquipdetListForm" property="eqobj.equipmentSet.stationType" value="D">
				<bean:message key="label.equipment.stationdamps"/>
			  </logic:equal>
			  <logic:equal name="EquipdetListForm" property="eqobj.equipmentSet.stationType" value="S">
				<bean:message key="label.equipment.stationgsm"/>
			  </logic:equal>
			  <logic:equal name="EquipdetListForm" property="eqobj.equipmentSet.stationType" value="C">
				<bean:message key="label.equipment.stationdcs"/>
			  </logic:equal>
			  <logic:equal name="EquipdetListForm" property="eqobj.equipmentSet.stationType" value="G">
				<bean:message key="label.equipment.stationboth"/>
			  </logic:equal>
		  </logic:equal>
		  <logic:equal name="EquipdetListForm" property="eqobj.equipmentType" value="B">
			  <logic:equal name="EquipdetListForm" property="eqobj.equipmentSet.comEquipmentType" value="R">
				<bean:message key="label.equipment.comequipmenttype.radio"/>
			  </logic:equal>
			  <logic:equal name="EquipdetListForm" property="eqobj.equipmentSet.comEquipmentType" value="O">
				<bean:message key="label.equipment.comequipmenttype.optic"/>
			  </logic:equal>
		  </logic:equal>
		  <logic:equal name="EquipdetListForm" property="eqobj.equipmentType" value="C">
		  </logic:equal>
		  <logic:equal name="EquipdetListForm" property="eqobj.equipmentType" value="D">
			  <logic:equal name="EquipdetListForm" property="eqobj.equipmentSet.switchType" value="<%=Checks.SWITCH_TYPE_Gsm%>">
				<bean:message key="label.equipment.switchgsm"/>
			  </logic:equal>
			  <logic:equal name="EquipdetListForm" property="eqobj.equipmentSet.switchType" value="<%=Checks.SWITCH_TYPE_Damps%>">
				<bean:message key="label.equipment.switchdamps"/>

			  </logic:equal>
		  </logic:equal>
		  <logic:equal name="EquipdetListForm" property="eqobj.equipmentType" value="E">
			  <logic:equal name="EquipdetListForm" property="eqobj.equipmentSet.otherEquipmentType" value="A">
				<bean:message key="label.equipment.othertypea"/>
			  </logic:equal>
			  <logic:equal name="EquipdetListForm" property="eqobj.equipmentSet.otherEquipmentType" value="B">
				<bean:message key="label.equipment.othertypeb"/>
			  </logic:equal>
			  <logic:equal name="EquipdetListForm" property="eqobj.equipmentSet.otherEquipmentType" value="C">
				<bean:message key="label.equipment.othertypec"/>
			  </logic:equal>
			  <logic:equal name="EquipdetListForm" property="eqobj.equipmentSet.otherEquipmentType" value="D">
				<bean:message key="label.equipment.othertyped"/>
			  </logic:equal>
			  <logic:equal name="EquipdetListForm" property="eqobj.equipmentSet.otherEquipmentType" value="E">
				<bean:message key="label.equipment.othertypee"/>
			  </logic:equal>
		  </logic:equal>

			&nbsp;

		  <logic:equal name="EquipdetListForm" property="eqobj.equipmentType" value="A">
			<bean:write name="EquipdetListForm" property="eqobj.equipmentSet.number" filter="true"/>
		  </logic:equal>
		  <logic:equal name="EquipdetListForm" property="eqobj.equipmentType" value="C">
			<bean:write name="EquipdetListForm" property="eqobj.equipmentSet.number" filter="true"/>
		  </logic:equal>
		  <logic:equal name="EquipdetListForm" property="eqobj.equipmentType" value="D">
			<bean:write name="EquipdetListForm" property="eqobj.equipmentSet.number" filter="true"/>
		  </logic:equal>
		  <logic:equal name="EquipdetListForm" property="eqobj.equipmentType" value="F">
			<bean:write name="EquipdetListForm" property="eqobj.equipmentSet.number" filter="true"/>
		  </logic:equal>

			&nbsp;

		  <logic:equal name="EquipdetListForm" property="eqobj.equipmentType" value="A">
			<bean:write name="EquipdetListForm" property="eqobj.equipmentSet.stationName" filter="true"/>
		  </logic:equal>
		  <logic:equal name="EquipdetListForm" property="eqobj.equipmentType" value="B">
			<bean:write name="EquipdetListForm" property="eqobj.equipmentSet.name" filter="true"/>
		  </logic:equal>
		  <logic:equal name="EquipdetListForm" property="eqobj.equipmentType" value="C">
			<bean:write name="EquipdetListForm" property="eqobj.equipmentSet.controllerName" filter="true"/>
		  </logic:equal>
		  <logic:equal name="EquipdetListForm" property="eqobj.equipmentType" value="D">
			<bean:write name="EquipdetListForm" property="eqobj.equipmentSet.name" filter="true"/>
		  </logic:equal>
		  <logic:equal name="EquipdetListForm" property="eqobj.equipmentType" value="E">
		  </logic:equal>
		  <logic:equal name="EquipdetListForm" property="eqobj.equipmentType" value="N">
		  </logic:equal>
		  <logic:equal name="EquipdetListForm" property="eqobj.equipmentType" value="F">
			<bean:write name="EquipdetListForm" property="eqobj.equipmentSet.name" filter="true"/>
		  </logic:equal>

	   </td>
    </TR>        
    </table>
    
  </TD>
</TR>


    <july:separator colspan="<%= gColSpan %>" />

      <tr class="title">
          <td colspan="<%= gColSpan %>"><TABLE class="buttons">
            <TR class="title">
              <TD class="buttons">
<%--
 <july:backbutton page="<%=elForm.getObjectUrl()%>"/><july:printbutton href="/crystalclear/equipment.rpt?dll=pdsequip.dll&prompt1=0" paramId="prompt0" paramName="EquipdetListForm" paramProperty="eqobj.equipmentSet.storageplace" /></TD>              <TD class="navigator"><july:navigator/></TD>
--%>
<%-- <july:backbutton href="<%=sm.getReturnHref()%>"/> --%>
<july:backbutton/>
<july:printbutton href="/crystalclear/equipment.rpt?dll=pdsequip.dll&prompt1=0" paramId="prompt0" paramName="EquipdetListForm" paramProperty="eqobj.equipmentSet.storageplace" /></TD>              <TD class="navigator"><july:navigator/></TD>
            </TR>
            </TABLE></TD>
      </tr>

      <july:separator colspan="<%= gColSpan %>" />
  
    <!-- Table header -->
    <tr class="title">
        <july:headercolumn key="label.equipdet.name" colType="string"/>
        <july:headercolumn key="label.equipdet.model" colType="string"/>
        <july:headercolumn key="label.equipdet.serial" colType="string"/>
        <july:headercolumn key="label.equipdet.qty" colType="string"/>
        <july:headercolumn key="label.equipdet.contents" colType="string"/>
        <july:headercolumn key="label.equipdet.place" colType="string"/>
    </tr>

     <july:separator colspan="<%= gColSpan %>" />


        <!-- Table body -->
    <logic:iterate id="equ" name="browseList">
        <logic:present name="equ">
            <tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
                <td class="text"><bean:write name="equ" property="scard.resource.name" /></td>
                <td class="text"><bean:write name="equ" property="scard.resource.model" /></td>
                <td class="text"><bean:write name="equ" property="scard.serialnumber" /><bean:write name="equ" property="scard.party" /></td>
                <td class="number"><july:numberwrite name="equ" property="scard.qty" /></td>
                <td class="text">
				    <logic:equal name="equ" property="haveContents" value="true">
						<logic:equal name="equ" property="scard.policy" value="S">
							<html:link page="/ShowEquipsdetList.do" paramId="storagecard" paramName="equ" paramProperty="scard.storagecard"><bean:message key="label.eqipdet.cont"/></html:link>
						</logic:equal>
					</logic:equal>
					&nbsp;
				</td>
                <td class="text"><bean:write name="equ" property="scard.place" /></td>
            </tr>

            <july:separator colspan="<%= gColSpan %>" />

	      </logic:present>
      </logic:iterate>

      <tr class="title">
          <td colspan="<%= gColSpan %>"><TABLE class="buttons">
            <TR class="title">
              <TD class="buttons"><july:backbutton /> 
				<%-- DD
			  href="<%=sm.getReturnHref()%>"/>
			  --%>
			  <july:printbutton href="/crystalclear/equipment.rpt?dll=pdsequip.dll&prompt1=0" paramId="prompt0" paramName="EquipdetListForm" paramProperty="eqobj.equipmentSet.storageplace" /></TD>
              <TD class="navigator"><july:navigator/></TD>
            </TR>
            </TABLE></TD>
      </tr>
      
<july:separator colspan="<%= gColSpan %>" />

</table>

</july:browseform>
