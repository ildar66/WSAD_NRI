<%@ page import="com.hps.july.jdbcpersistence.lib.*"%>
<%@ page import="com.hps.july.sitedoc.valueobject.*"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld"    prefix="alex" %>

<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>

<%
DocObjectDef odef = DocObjectDef.getDef(session);

// Get colspan
String clsp;
if(request.getAttribute("colspan")==null) {
	clsp="2";
} else {
	clsp=""+request.getAttribute("colspan");
}
%>
<tr>
<td colspan="<%=clsp%>" style="padding:0px;"><table border=0 width="100%" class="main">
<%
if(odef.isComline()) {
%>
<style>
TD.tittle {
	font-family: Verdana,Arial; font-size:10pt; padding-right:4pt; padding-top: 1pt; padding-bottom: 1pt; font-weight: bold;
}
TD.texxt {
	font-family: Verdana,Arial; font-size:10pt; padding-right:4pt; padding-top: 1pt; padding-bottom: 1pt;
}

</style>
<tr>
	<td class="texxt" width="25%">&nbsp;</td>
	<td class="tittle" width="37%"><bean:message key="comline.enda"/></td>
	<td class="tittle" width="38%"><bean:message key="comline.endb"/></td>
</tr>
<tr>
	<td class="texxt" valign="top"><bean:message bundle="bsResources" key="label.equipment.posname"/></td>
	<td class="texxt" valign="top"><%=odef.getHopA().getPositionName()%></td>
	<td class="texxt" valign="top"><%=odef.getHopB().getPositionName()%></td>
</tr>
<tr>
	<td class="texxt" valign="top"><bean:message bundle="bsResources" key="Position.region"/></td>
	<td class="texxt" valign="top"><%=odef.getHopA().getRegionName()%></td>
	<td class="texxt" valign="top"><%=odef.getHopB().getRegionName()%></td>
</tr>
<tr>
	<td class="texxt" valign="top"><bean:message bundle="bsResources" key="Position.netzonecode"/></td>
	<td class="texxt" valign="top"><%=odef.getHopA().getZoneName()%></td>
	<td class="texxt" valign="top"><%=odef.getHopB().getZoneName()%></td>
</tr>
<tr>
	<td class="texxt" valign="top"><bean:message bundle="bsResources" key="label.baseStationList.address"/></td>
	<td class="texxt" valign="top"><%=odef.getHopA().getAddress()%></td>
	<td class="texxt" valign="top"><%=odef.getHopB().getAddress()%></td>
</tr>
<tr>
	<td class="texxt" valign="top"><bean:message bundle="bsResources" key="label.equipment"/></td>
	<td class="texxt" valign="top"><%=odef.getHopA().getEquipmentName()%></td>
	<td class="texxt" valign="top"><%=odef.getHopB().getEquipmentName()%></td>
</tr>
<tr>
	<td class="texxt" valign="top"><bean:message key="object"/>:</td>
	<td colspan=2 class="texxt" valign="top"><%=odef.getObjectName()%></td>
</tr>
<%
} else { //not comline
%>
<tr>
	<td class="text" width="25%"><bean:message bundle="bsResources" key="Position.region"/> / <bean:message bundle="bsResources" key="Position.netzonecode"/>:</td>
	<td class="text" colspan="2">
		<%=odef.getRegionName()+" / "+odef.getNetzoneName()%>
	</td>
</tr>
<tr>
	<td class="text"><bean:message bundle="bsResources" key="label.baseStationList.address"/>:</td>
	<td class="text" colspan="2">
		<%=odef.getAddress()%>
	</td>
</tr>
<tr>
	<td class="text"><bean:message bundle="bsResources" key="label.equipment.posname"/>:</td>
	<td class="text" colspan="2">
		<%=odef.getPositionName()%>
	</td>
</tr>
<%
if(!odef.isPosition() && !odef.isProject() && !odef.isProjectAction()) {
%>
<tr>
	<td class="text"><bean:message key="object"/>:</td>
	<td class="text" colspan="2">
		<%=odef.getObjectName()%>
	</td>
</tr>
<%
}
%>
<%--projectName--%>
<%
if(odef.isProject() || odef.isProjectAction()){
%>
<tr>
	<td class="text"><bean:message key="tittleObject.project"/>:</td>
	<td class="text" colspan="2">
		<%=odef.getProjectName()%>
	</td>
</tr>
<%
}
%>
<%--projectActionName--%>
<%
if(odef.isProjectAction()) {
%>
<tr>
	<td class="text"><bean:message key="tittleObject.projectAction"/>:</td>
	<td class="text" colspan="2">
		<%=odef.getProjectActionName()%>
	</td>
</tr>
<%
}
%>
<% // not Comline object finish
}
%>
</table></td>
</tr>

