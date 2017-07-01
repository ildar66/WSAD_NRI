<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld" prefix="alex" %>
<%@ page import="org.apache.struts.util.*"%>
<%@ page import="com.hps.july.basestation.valueobject.*"%>
<%@ page import="com.hps.july.basestation.formbean.*"%>
<%@ page import="com.hps.july.siteinfo.valueobject.Position"%>

<%
	SectorForm sform = (SectorForm)pageContext.findAttribute("SectorForm");
%>
<%--
<tr>
	<td class="text"><bean:message key="label.equipment.posname"/></td>
	<td>
		<july:string property="bsForm.positionForm.storageplaceFrm" styleId="poscodeId" size="5" insertable='false' updatable='false'/>
		<july:string size="25" property="bsForm.positionForm.name" styleId="posnameId" insertable="false" updatable="false"/>
	</td>
</tr>
<tr>
	<td class="text"><bean:message key="Position.netzonecode"/>:</td>
	<td>
		<july:string  property="bsForm.positionForm.zonename" styleId="zonenameId" size="25" insertable="false" updatable="false"/>
	</td>
</tr>
--%>
<tr>
	<td class="text"><bean:message key="Position.address"/>:</td>
	<td>
		<july:string property="bsForm.positionForm.address" styleId="addressId" size="50" insertable="false" updatable="false"/>
	</td>
</tr>
