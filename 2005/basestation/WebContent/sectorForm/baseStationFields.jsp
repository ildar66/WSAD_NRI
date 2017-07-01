<%--
need to resave:
factBaseStationForm/fields.jsp ----> factBaseStationForm.jsp

--%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld" prefix="alex" %>
<%@ page import="org.apache.struts.util.*,com.hps.july.persistence.*,com.hps.july.basestation.valueobject.*,com.hps.july.basestation.formbean.*"%>

<tr>
	<td class="text"><bean:message key="BaseStation.stationType"/> / <bean:message key="BaseStation.stationNumber"/> / <bean:message key="BaseStation.stName"/></td>
	<td>
		<july:string property="bsForm.stationTypeName"  size="10" insertable='false' updatable='false'/> /
		<july:string property="bsForm.numberFrm"  size="10" insertable='false' updatable='false'/> /
		<july:string property="bsForm.stationName"  size="10" insertable='false' updatable='false'/>
	</td>
</tr>

<tr>
	<td class="text"><bean:message key="Position.address"/>:</td>
	<td>
		<july:string property="bsForm.positionForm.address" styleId="addressId" size="50" insertable="false" updatable="false"/>
	</td>
</tr>

<tr>
	<td class="text"><bean:message key="BaseStation.contrName"/> / <bean:message key="BaseStation.switchName"/></td>
	<td>
		<july:string property="bsForm.contrNumberFrm"  size="10" insertable='false' updatable='false'/> /
		<july:string property="bsForm.switchNumberFrm"  size="10" insertable='false' updatable='false'/>
	</td>
</tr>

