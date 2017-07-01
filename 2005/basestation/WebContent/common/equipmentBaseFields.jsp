<%@ page import="com.hps.july.basestation.formbean.EquipmentPForm"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld"    prefix="alex" %>


<%
	EquipmentPForm eForm=(EquipmentPForm)request.getAttribute("EquipmentPForm");
%>
<tr><%--Дата монтажа--%>
	<td class="text"><bean:message key="SwitchForm.dateassemb"/>:</td>
	<td class="text">
		<july:date property="dateassembFrm" required="false" styleId="dateassembId" size="25" insertable='true' updatable='true'/>
	</td>
</tr>
<tr><%--Дата тестирования--%>
	<td class="text"><bean:message key="SwitchForm.datetest"/>:</td>
	<td class="text">
		<july:date property="datetestFrm" required="false" styleId="datetestId" size="25" insertable='true' updatable='true'/>
	</td>
</tr>
<tr>
	<td class="text"><bean:message key="SwitchForm.datepr"/>:</td>
	<td class="text">
		<july:date property="dateprFrm" required="false" styleId="dateprId" size="25" insertable='true' updatable='true'/>
	</td>
</tr>

<%--
<tr>
	<td class="text"><bean:message key="SwitchForm.pwrval"/>:</td>
	<td class="text">
		<july:string property="pwrvalFrm" styleId="pwrvalFrmId" size="10" insertable="true" updatable="true" />
	</td>
</tr>
<tr>
	<td class="text"><bean:message key="SwitchForm.pwrcat"/>:</td>
	<td class="text">
		<july:string property="pwrcat" styleId="pwrcatFrmId" size="10" insertable="true" updatable="true" />
	</td>
</tr>
<tr>
	<td class="text"><bean:message key="SwitchForm.pwrreserve"/>:</td>
	<td class="text">
		<july:checkbox property="pwrreserve" insertable="true" updatable="true" />
	</td>
</tr>
<tr>
	<td class="text"><bean:message key="SwitchForm.pwrrescat"/>:</td>
	<td class="text">
		<july:string property="pwrrescat" styleId="pwrrescatFrmId" size="10" insertable="true" updatable="true" />
	</td>
</tr>
--%>

<tr><%--SwitchForm.equipcomment=Комментарии--%>
	<td class="text"><bean:message key="SwitchForm.equipcomment"/>:</td>
	<td class="text">
		<july:textarea property="equipcomment" cols="50" rows="2" insertable='true' updatable='true' />
	</td>
</tr>

