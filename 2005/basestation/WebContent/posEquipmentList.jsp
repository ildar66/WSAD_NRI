<%@ page language = "java" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.basestation.*,com.hps.july.persistence.*" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "7"; %>

<july:browseform action="/ShowPosEquipmentList.do">

<table class="main">

<%-- DD

<tr class="title">
  <td class="title" colspan="<%= gColSpan %>">
    <html:link page="/BaseStationList.do" styleClass="navigator">
Базовые станции
    </html:link>
<july:sepmark/>
    <html:link page="/EditFactBaseStation.do?action=View" paramId="basestation" paramName="FactBaseStationForm" paramProperty="basestation" styleClass="navigator">
 Просмотр БС
    </html:link>
<july:sepmark/>
<july:currmark>Оборудование</july:currmark>
 </td>
</tr>
--%>

<%--
<tr class="title">
	<td class="title" colspan="<%= gColSpan %>">

	   <jsp:include page="/mapLinks.jsp" flush="true"></jsp:include>
	   <july:sepmark/>
       <html:link page="/EditPosition.do?action=View" paramId="storageplace" paramName="AntennaSectorListForm" paramProperty="storageplace" styleClass="navigator"><bean:message key="label.workresponsibility.position"/></html:link>
       <july:sepmark/>
       <july:currmark><bean:message key="label.equipment"/></july:currmark></td>
</tr>
--%>
<july:separator colspan="<%= gColSpan %>" />

<TR class="normal">
 <TD colspan="<%= gColSpan %>">

    <table class="find">
    <TR>
       <td class="title"><bean:message key="label.equipment.posname"/>:</td>
       <td class="title"><bean:write name="PosAntennaSectorListForm" property="posid" />&nbsp;&nbsp;&nbsp;
                                         <bean:write name="PosAntennaSectorListForm" property="posname" /></td>
     </tr>
     </table>

  </TD>
</TR>
--%>

    <july:separator colspan="<%= gColSpan %>" />

      <tr class="title">
          <td colspan="<%= gColSpan %>"><TABLE class="buttons">
            <TR class="title">
              <TD class="buttons"><july:addbutton page="/EditEquipment.do?action=Add"/><july:backbutton page="/EditPosition.do?action=View" paramId="storageplace" paramName="PosAntennaSectorListForm" paramProperty="storageplace"/></TD>
              <TD class="navigator"><july:navigator/></TD>
            </TR>
            </TABLE></TD>
      </tr>

      <july:separator colspan="<%= gColSpan %>" />

    <!-- Table header -->
    <tr class="title">
        <july:headercolumn key="label.equipment.complect" colType="string"/>
        <july:headercolumn key="label.equipment.type" colType="string"/>
        <july:headercolumn key="label.equipment.number" colType="string"/>
        <july:headercolumn key="label.equipment.name" colType="string"/>
        <july:headercolumn key="label.equipment.state" colType="string"/>
        <july:headercolumn key="label.equipment.contents" colType="string"/>
        <TD class="title">&nbsp;</TD>
    </tr>

     <july:separator colspan="<%= gColSpan %>" />


        <!-- Table body -->
    <logic:iterate id="equ" name="browseList">
        <logic:present name="equ">
            <tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
                <td class="text">
                      <logic:equal name="equ" property="equipmentType" value="A">
                         <july:canedit rolesProperty="bsRoles">
                             <july:editlink page="/EditEquipment.do" action="Edit" paramId="storageplace" paramName="equ" paramProperty="equipmentSet.storageplace" paramScope="page">
                                <bean:message key="label.equipment.type.basestation"/>
                             </july:editlink>
                         </july:canedit>
                         <july:cannotedit rolesProperty="bsRoles">
                             <july:editlink page="/EditEquipment.do" action="View" paramId="storageplace" paramName="equ" paramProperty="equipmentSet.storageplace" paramScope="page">
                                <bean:message key="label.equipment.type.basestation"/>
                             </july:editlink>
                         </july:cannotedit>
                      </logic:equal>
                      <logic:equal name="equ" property="equipmentType" value="B">
                         <july:canedit rolesProperty="comRoles">
                             <july:editlink page="/EditEquipment.do" action="Edit" paramId="storageplace" paramName="equ" paramProperty="equipmentSet.storageplace" paramScope="page">
                                <bean:message key="label.equipment.type.comequipment"/>
                             </july:editlink>
                         </july:canedit>
                         <july:cannotedit rolesProperty="comRoles">
                             <july:editlink page="/EditEquipment.do" action="View" paramId="storageplace" paramName="equ" paramProperty="equipmentSet.storageplace" paramScope="page">
                                <bean:message key="label.equipment.type.comequipment"/>
                             </july:editlink>
                         </july:cannotedit>
                      </logic:equal>
                      <logic:equal name="equ" property="equipmentType" value="C">
                         <july:canedit rolesProperty="bsRoles">
                             <july:editlink page="/EditEquipment.do" action="Edit" paramId="storageplace" paramName="equ" paramProperty="equipmentSet.storageplace" paramScope="page">
                                <bean:message key="label.equipment.type.controller"/>
                             </july:editlink>
                         </july:canedit>
                         <july:cannotedit rolesProperty="bsRoles">
                             <july:editlink page="/EditEquipment.do" action="View" paramId="storageplace" paramName="equ" paramProperty="equipmentSet.storageplace" paramScope="page">
                                <bean:message key="label.equipment.type.controller"/>
                             </july:editlink>
                         </july:cannotedit>
                      </logic:equal>
                      <logic:equal name="equ" property="equipmentType" value="D">
                         <july:canedit rolesProperty="bsRoles">
                             <july:editlink page="/EditEquipment.do" action="Edit" paramId="storageplace" paramName="equ" paramProperty="equipmentSet.storageplace" paramScope="page">
                                <bean:message key="label.equipment.type.switch"/>
                             </july:editlink>
                         </july:canedit>
                         <july:cannotedit rolesProperty="bsRoles">
                             <july:editlink page="/EditEquipment.do" action="View" paramId="storageplace" paramName="equ" paramProperty="equipmentSet.storageplace" paramScope="page">
                                <bean:message key="label.equipment.type.switch"/>
                             </july:editlink>
                         </july:cannotedit>
                      </logic:equal>
                      <logic:equal name="equ" property="equipmentType" value="E">
                         <july:canedit rolesProperty="otherRoles">
                             <july:editlink page="/EditEquipment.do" action="Edit" paramId="storageplace" paramName="equ" paramProperty="equipmentSet.storageplace" paramScope="page">
                                <bean:message key="label.equipment.type.other"/>
                             </july:editlink>
                         </july:canedit>
                         <july:cannotedit rolesProperty="otherRoles">
                             <july:editlink page="/EditEquipment.do" action="View" paramId="storageplace" paramName="equ" paramProperty="equipmentSet.storageplace" paramScope="page">
                                <bean:message key="label.equipment.type.other"/>
                             </july:editlink>
                         </july:cannotedit>
                      </logic:equal>
                      <logic:equal name="equ" property="equipmentType" value="N">
                         <logic:present role="administrator">
                             <july:editlink page="/EditEquipment.do" action="Edit" paramId="storageplace" paramName="equ" paramProperty="equipmentSet.storageplace" paramScope="page">
                                <bean:message key="label.equipment.type.unknown"/>
                             </july:editlink>
                         </logic:present>
                         <logic:notPresent role="administrator">
                             <july:editlink page="/EditEquipment.do" action="View" paramId="storageplace" paramName="equ" paramProperty="equipmentSet.storageplace" paramScope="page">
                                <bean:message key="label.equipment.type.unknown"/>
                             </july:editlink>
                         </logic:notPresent>
                      </logic:equal>
                </td>
                <td class="text">
                      <logic:equal name="equ" property="equipmentType" value="A">
                          <logic:equal name="equ" property="equipmentSet.stationType" value="D">
                            <bean:message key="label.equipment.stationdamps"/>
                          </logic:equal>
                          <logic:equal name="equ" property="equipmentSet.stationType" value="S">
                            <bean:message key="label.equipment.stationgsm"/>
                          </logic:equal>
                          <logic:equal name="equ" property="equipmentSet.stationType" value="C">
                            <bean:message key="label.equipment.stationdcs"/>
                          </logic:equal>
                          <logic:equal name="equ" property="equipmentSet.stationType" value="G">
                            <bean:message key="label.equipment.stationboth"/>
                          </logic:equal>
                      </logic:equal>
                      <logic:equal name="equ" property="equipmentType" value="B">
                          <logic:equal name="equ" property="equipmentSet.comEquipmentType" value="R">
                            <bean:message key="label.equipment.comequipmenttype.radio"/>
                          </logic:equal>
                          <logic:equal name="equ" property="equipmentSet.comEquipmentType" value="O">
                            <bean:message key="label.equipment.comequipmenttype.optic"/>
                          </logic:equal>
                      </logic:equal>
                      <logic:equal name="equ" property="equipmentType" value="C">
                        &nbsp;
                      </logic:equal>
                      <logic:equal name="equ" property="equipmentType" value="D">
                          <logic:equal name="equ" property="equipmentSet.switchType" value="1">
                            <bean:message key="label.equipment.switchgsm"/>
                          </logic:equal>
                          <logic:equal name="equ" property="equipmentSet.switchType" value="2">
                            <bean:message key="label.equipment.switchdamps"/>
                          </logic:equal>
                      </logic:equal>
                      <logic:equal name="equ" property="equipmentType" value="E">
                          <logic:equal name="equ" property="equipmentSet.otherEquipmentType" value="A">
                            <bean:message key="label.equipment.othertypea"/>
                          </logic:equal>
                          <logic:equal name="equ" property="equipmentSet.otherEquipmentType" value="B">
                            <bean:message key="label.equipment.othertypeb"/>
                          </logic:equal>
                          <logic:equal name="equ" property="equipmentSet.otherEquipmentType" value="C">
                            <bean:message key="label.equipment.othertypec"/>
                          </logic:equal>
                          <logic:equal name="equ" property="equipmentSet.otherEquipmentType" value="D">
                            <bean:message key="label.equipment.othertyped"/>
                          </logic:equal>
                      </logic:equal>
                </td>
                <td class="text">
                      <logic:equal name="equ" property="equipmentType" value="A">
						<bean:write name="equ" property="equipmentSet.number" filter="true"/>
                      </logic:equal>
                      <logic:equal name="equ" property="equipmentType" value="B">
						&nbsp;
                      </logic:equal>
                      <logic:equal name="equ" property="equipmentType" value="C">
						<bean:write name="equ" property="equipmentSet.number" filter="true"/>
                      </logic:equal>
                      <logic:equal name="equ" property="equipmentType" value="D">
						<bean:write name="equ" property="equipmentSet.number" filter="true"/>
                      </logic:equal>
                      <logic:equal name="equ" property="equipmentType" value="E">
						&nbsp;
                      </logic:equal>
                      <logic:equal name="equ" property="equipmentType" value="N">
						&nbsp;
                      </logic:equal>
                </td>
                <td class="text">
                      <logic:equal name="equ" property="equipmentType" value="A">
						<bean:write name="equ" property="equipmentSet.stationName" filter="true"/>
                      </logic:equal>
                      <logic:equal name="equ" property="equipmentType" value="B">
						<bean:write name="equ" property="equipmentSet.name" filter="true"/>
                      </logic:equal>
                      <logic:equal name="equ" property="equipmentType" value="C">
						<bean:write name="equ" property="equipmentSet.controllerName" filter="true"/>
                      </logic:equal>
                      <logic:equal name="equ" property="equipmentType" value="D">
						<bean:write name="equ" property="equipmentSet.name" filter="true"/>
                      </logic:equal>
                      <logic:equal name="equ" property="equipmentType" value="E">
						&nbsp;
                      </logic:equal>
                      <logic:equal name="equ" property="equipmentType" value="N">
						&nbsp;
                      </logic:equal>
                </td>
                <td class="text">
                      <logic:equal name="equ" property="equipmentSet.equipmentState" value="P">
                         <bean:message key="label.equipment.statep"/>
                      </logic:equal>
                      <logic:equal name="equ" property="equipmentSet.equipmentState" value="M">
                         <bean:message key="label.equipment.statem"/>
                      </logic:equal>
                      <logic:equal name="equ" property="equipmentSet.equipmentState" value="R">
                         <bean:message key="label.equipment.stater"/>
                      </logic:equal>
                      <logic:equal name="equ" property="equipmentSet.equipmentState" value="T">
                         <bean:message key="label.equipment.statet"/>
                      </logic:equal>
                      <logic:equal name="equ" property="equipmentSet.equipmentState" value="W">
                         <bean:message key="label.equipment.statew"/>
                      </logic:equal>
                </td>
                <td class="text">
					<logic:equal name="equ" property="haveContents" value="true">
						<html:link page="/ShowEquipdetList.do" paramId="storageplace" paramName="equ" paramProperty="equipmentSet.storageplace"><bean:message key="label.equipment.contents"/></html:link>
					</logic:equal>
					&nbsp;
                </td>
                <td class="link">
                  <logic:equal name="equ" property="equipmentType" value="A">
                     <july:canedit rolesProperty="bsRoles">
                        <july:delbutton page="/EditEquipment.do?action=Delete" paramId="storageplace" paramName="equ" paramProperty="equipmentSet.storageplace" paramScope="page"/>
                     </july:canedit>
                  </logic:equal>
                  <logic:equal name="equ" property="equipmentType" value="B">
                     <july:canedit rolesProperty="comRoles">
                        <july:delbutton page="/EditEquipment.do?action=Delete" paramId="storageplace" paramName="equ" paramProperty="equipmentSet.storageplace" paramScope="page"/>
                     </july:canedit>
                  </logic:equal>
                  <logic:equal name="equ" property="equipmentType" value="C">
                     <july:canedit rolesProperty="bsRoles">
                        <july:delbutton page="/EditEquipment.do?action=Delete" paramId="storageplace" paramName="equ" paramProperty="equipmentSet.storageplace" paramScope="page"/>
                     </july:canedit>
                  </logic:equal>
                  <logic:equal name="equ" property="equipmentType" value="D">
                     <july:canedit rolesProperty="bsRoles">
                        <july:delbutton page="/EditEquipment.do?action=Delete" paramId="storageplace" paramName="equ" paramProperty="equipmentSet.storageplace" paramScope="page"/>
                     </july:canedit>
                  </logic:equal>
                  <logic:equal name="equ" property="equipmentType" value="E">
                     <july:canedit rolesProperty="otherRoles">
                        <july:delbutton page="/EditEquipment.do?action=Delete" paramId="storageplace" paramName="equ" paramProperty="equipmentSet.storageplace" paramScope="page"/>
                     </july:canedit>
                  </logic:equal>
                </td>
            </tr>

            <july:separator colspan="<%= gColSpan %>" />

	      </logic:present>
      </logic:iterate>

      <tr class="title">
          <td colspan="<%= gColSpan %>"><TABLE class="buttons">
            <TR class="title">
              <TD class="buttons"><july:addbutton page="/EditEquipment.do?action=Add"/><july:backbutton page="/EditPosition.do?action=View" paramId="storageplace" paramName="PosAntennaSectorListForm" paramProperty="storageplace"/></TD>
              <TD class="navigator"><july:navigator/></TD>
            </TR>
            </TABLE></TD>
      </tr>

      <july:separator colspan="<%= gColSpan %>" />

<!--навигатор-->

<%-- DD
      <tr class="title">
  <td class="title" colspan="<%= gColSpan %>">
    <html:link page="/BaseStationList.do" styleClass="navigator">
Базовые станции
    </html:link>
<july:sepmark/>
    <html:link page="/EditFactBaseStation.do?action=View" paramId="basestation" paramName="FactBaseStationForm" paramProperty="basestation" styleClass="navigator">
 Просмотр БС
    </html:link>
<july:sepmark/>
<july:currmark>Оборудование</july:currmark>
 </td>
</tr>
--%>

</table>

</july:browseform>
