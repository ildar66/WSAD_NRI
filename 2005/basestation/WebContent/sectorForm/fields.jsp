<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld"    prefix="alex" %>
<%@ page import="org.apache.struts.util.*,

 com.hps.july.basestation.valueobject.*,com.hps.july.basestation.formbean.*,com.hps.july.jdbcpersistence.lib.*"%>


<%@ include file="/sectorForm/positionFields.jsp"  %>
<%@ include file="/sectorForm/baseStationFields.jsp"  %>


<%
SectorForm sectorForm=(SectorForm)session.getAttribute("SectorForm");
%>


<july:separator/>

<input type="hidden" name="byhand" value="true">
<tr>
<%--название +--%>
 <td class="text">
   <july:reqmark><bean:message key="BaseStation.stationName"/>:</july:reqmark>
 </td>
 <td>
    <july:string property="namesect" size="50" insertable="true" updatable="true" />
 </td>
</tr>

<tr>
<%--диапазон +--%>
<td class="text"><july:reqmark><bean:message key="Sector.band"/>:</july:reqmark></td>
<td>
<alex:select  property="bandFrm" styleId="bandId" insertable="true" updatable="true" styleClass="editsmall"  >
<logic:equal name="SectorForm" property="bsForm.stationType" value="<%=BaseStationObject.TYPE_CHECK_DAMPS_D%>" >
  <html:option  value="<%=String.valueOf(BaseStationObject.BAND_CHECK_DAMPS_800)%>">
     <%=String.valueOf(BaseStationObject.BAND_CHECK_DAMPS_800)%>
  </html:option>
</logic:equal>
<logic:notEqual name="SectorForm" property="bsForm.stationType" value="<%=BaseStationObject.TYPE_CHECK_DAMPS_D%>" >
  <html:option  value="<%=String.valueOf(BaseStationObject.BAND_CHECK_GSM_900)%>">
     <%=String.valueOf(BaseStationObject.BAND_CHECK_GSM_900)%>
  </html:option>
  <html:option  value="<%=String.valueOf(BaseStationObject.BAND_CHECK_GSM_1800)%>">
     <%=String.valueOf(BaseStationObject.BAND_CHECK_GSM_1800)%>
  </html:option>
</logic:notEqual>
</alex:select>

</td>
</tr>

<tr>
<%--номер String +--%>
<td class="text"><july:reqmark><bean:message key="BaseStation.number"/>:</july:reqmark></td>
 <td>
    <july:string property="numsect" size="10" insertable="true" updatable="true" />
 </td>
</tr>
<tr>

<tr>
<%--Тип сектора String +--%>
<td class="text"><bean:message key="Sector.conf"/>:</td>
<td>

<alex:select property="conf" styleId="confId" insertable="true" updatable="true" styleClass="editsmall" style="width:120pt" >
  <html:option  key="CONF_CHECK_1" value="<%=SectorObject.CONF_CHECK_1%>"/>
  <html:option  key="CONF_CHECK_2" value="<%=SectorObject.CONF_CHECK_2%>"/>
  <html:option  key="CONF_CHECK_3" value="<%=SectorObject.CONF_CHECK_3%>"/>
  <html:option  key="CONF_CHECK_4" value="<%=SectorObject.CONF_CHECK_4%>"/>
</alex:select>

</td>
</tr>

<tr>
<%--азимут-BigDecimal +--%>
<td class="text"><july:reqmark><bean:message key="Antenna.asim"/>:</july:reqmark></td>
 <td>
    <july:string property="azimutFrm" size="10" insertable="true" updatable="true" />
 </td>
</tr>
<tr>

<tr>
<%--номер BTS--%>
<td class="text"><bean:message key="Sector.btsnumber"/>:</td>
 <td>
    <july:string property="btsnumber" size="10" insertable="true" updatable="true" />
 </td>
</tr>
<tr>

<tr>
<%--Подключение к A-bis String +--%>
<%--Наличие фильтра Boolean +--%>
<td class="text"><bean:message key="Sector.conabis"/>:</td>
<td>
<alex:select property="conabis" styleId="bandId" insertable="true" updatable="true" styleClass="editsmall" >
  <html:option  key="CONABIS_CHECK_STAR_1" value="<%=SectorObject.CONABIS_CHECK_STAR_1%>"/>
  <html:option  key="CONABIS_CHECK_RING_2" value="<%=SectorObject.CONABIS_CHECK_RING_2%>"/>
  <html:option  key="CONABIS_CHECK_RING_3" value="<%=SectorObject.CONABIS_CHECK_RING_3%>"/>
</alex:select>
&nbsp;&nbsp;&nbsp;
<bean:message key="Sector.hasflt"/>
<july:checkbox property="hasflt" insertable="true" updatable="true" />
</td>
</tr>

<tr>
<%--Номер A-bis порта Integer +--%>
<%--Наличие МШУ Boolean +--%>
<td class="text"><bean:message key="Sector.portabis"/>:</td>
 <td>
    <july:string property="portabisFrm" size="10" insertable="true" updatable="true" />
    &nbsp;&nbsp;&nbsp;
    <bean:message key="Sector.haslna"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
   <july:checkbox property="haslna" insertable="true" updatable="true" />
 </td>
</tr>
<tr>

<tr>
<%--Номер версии ПО String +--%>
<%--Наличие бустера Boolean +--%>
<td class="text"><bean:message key="Sector.numpo"/>:</td>
 <td>
    <july:string property="numpo" size="10" insertable="true" updatable="true" />
    &nbsp;&nbsp;&nbsp;
    <bean:message key="Sector.hasbuster"/>&nbsp;
   <july:checkbox property="hasbuster" insertable="true" updatable="true" />
 </td>
</tr>

<tr>
<%--Наличие ДДК +--%>
<td class="text"><bean:message key="Sector.ddk"/>:</td>
 <td>
    <july:checkbox property="ddk" insertable="true" updatable="true" />
 </td>
</tr>
<tr>


<tr>
   <td class="text">&nbsp;</td>
   <td>
<logic:equal name="SectorForm" property="baseStation.stationType"  value="<%=BaseStationObject.TYPE_CHECK_DAMPS_D%>" >
   <bean:message key="Sector.ANALOG"/>
   <%for(int i=0;i<30;i++){%>&nbsp;<%}%>
</logic:equal>

<bean:message key="Sector.DIG"/>

<logic:equal name="SectorForm" property="baseStation.stationType"  value="<%=BaseStationObject.TYPE_CHECK_DAMPS_D%>" >
  <%for(int i=0;i<30;i++){%>&nbsp;<%}%>
  <bean:message key="Sector.OVR"/>
</logic:equal>

</td>
</tr>

<tr>
<%--Число TRX +--%>
<td class="text"><bean:message key="Sector.TRX"/>:</td>
 <td>
<logic:equal name="SectorForm" property="baseStation.stationType"  value="<%=BaseStationObject.TYPE_CHECK_DAMPS_D%>" >
    <july:string property="trxnum2Frm" size="10" insertable="true" updatable="true" />
    &nbsp;&nbsp;&nbsp;
</logic:equal>
    <july:string property="trxnumFrm" size="10" insertable="true" updatable="true" />

<logic:equal name="SectorForm" property="baseStation.stationType"  value="<%=BaseStationObject.TYPE_CHECK_DAMPS_D%>" >
    &nbsp;&nbsp;&nbsp;
    <july:string property="trxovrnumFrm" size="10" insertable="true" updatable="true" />
</logic:equal>
    </td>
</tr>

<tr>
<%--мощность на выходе транс  +--%>
<td class="text"><bean:message key="Sector.label.pwr"/>:</td>
 <td>
 <logic:equal name="SectorForm" property="baseStation.stationType"  value="<%=BaseStationObject.TYPE_CHECK_DAMPS_D%>" >
    <july:string property="txpwr2Frm" size="10" insertable="true" updatable="true" />
    &nbsp;&nbsp;&nbsp;
 </logic:equal>
    <july:string property="txpwrFrm" size="10" insertable="true" updatable="true" />
<logic:equal name="SectorForm" property="baseStation.stationType"  value="<%=BaseStationObject.TYPE_CHECK_DAMPS_D%>" >
    &nbsp;&nbsp;&nbsp;
    <july:string property="txovrsetpwrFrm" size="10" insertable="true" updatable="true" />
</logic:equal>
    </td>
</tr>

<logic:notEqual name="SectorForm" property="baseStation.stationType"  value="<%=BaseStationObject.TYPE_CHECK_DAMPS_D%>" >

<tr>
<%--Наличие HR +--%>
<td class="text"><bean:message key="Sector.ishr"/>:</td>
 <td>
    <july:checkbox property="ishr" insertable="true" updatable="true" />
 </td>
</tr>

<tr>
<%--Наличие GPRS +--%>
<td class="text"><bean:message key="Sector.capgprs"/>:</td>
 <td>
     <july:checkbox property="capgprs" insertable="true" updatable="true" />
 </td>
</tr>

</logic:notEqual>
<%--
<tr>
    <td class="text"><bean:message key="label.comment"/>:</td>
    <td>
        <july:textarea property="equipcomment" cols="50" rows="2" insertable='true' updatable='true' />
    </td>
</tr>
--%>

<%
	request.setAttribute("antennes",AntennaObject.findBySector(sectorForm.getIdsect()));
	if(sectorForm.getAction().equals("Edit")) {
		String link="/EditChoiceAntennes_FBS.do?sect="+sectorForm.getIdsect();
%>
	<tr class='title'>
	<td class="title" colspan='2'>
		<july:link page="<%=link%>" >
			<bean:message key="Antenna.choice"/>:
		</july:link>
	</td>
	</tr>
<%
	} else if(sectorForm.getAction().equals("View")) {
%>
	<tr class='title'>
	<td class="title" colspan='2'>
		<bean:message key="Antenna.choice"/>:
	</td>
	</tr>
<%
	}
%>
<%
	if("Edit".equals(sectorForm.getAction()) || "View".equals(sectorForm.getAction())) {
%>
<tr>
<td colspan="2">
<%@ include file="/sectorForm/antennaList.jsp"%>
</td>
</tr>
<%
	}
%>

