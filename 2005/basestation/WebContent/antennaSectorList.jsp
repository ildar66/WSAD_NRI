<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld"    prefix="alex" %>
<%@ page import="org.apache.struts.util.*" %>
<%@ page import="com.hps.july.basestation.valueobject.*" %>
<%@ page import="com.hps.july.siteinfo.valueobject.*" %>
<%@ page import="com.hps.july.basestation.formbean.*" %>
<%@ page import="com.hps.july.persistence.SectorAccessBean" %>
<%@ page import="com.hps.july.apptags.HasRegionAccessTag" %>
<%@ page import="com.hps.july.jdbcpersistence.lib.AppConstants" %>

<%
	AntennaSectorListForm form=(AntennaSectorListForm)session.getAttribute("AntennaSectorListForm");
	String positionId=form.getBsForm().getPositionForm().getStorageplaceFrm();
	String gColSpan="1";
%>

<july:browseform action="/ShowAntennaSectorList.do" styleId="EqForm">
<table class="main">
<july:separator/>
<tr class="normal">
<td>
	<table class="find">
	<tr>
<%--регион--%>
		<td class="title"><b><bean:message key="label.position.regionname"/></b></td>
		<td><%=form.getBsForm().getPositionForm().getRegname()%>&nbsp;<july:searchbutton/></td>
	</tr>
	<tr>
<%--позиция--%>
		<td class="title"><b><bean:message key="label.eposition.posname"/></b></td>
		<td>
			<%=form.getBsForm().getPositionForm().getStorageplace()%>
			&nbsp;<%=form.getBsForm().getPositionForm().getName()%>
		</td>
	</tr>
	<tr>
<%--баз. ст.--%>
		<td class="title"><b><bean:message key="label.equipment.type.basestation"/></b></td>
		<td>
			<%=form.getBsForm().getStationTypeName()%>
			&nbsp;
			<%=form.getBsForm().getNumber()%>
			&nbsp;<%=form.getBsForm().getStationName()%>
		</td>
	</tr>
</table>

</td>
</tr>

<july:separator />

<%
	request.setAttribute("basestation",String.valueOf(form.getBsForm().getBasestation()));
	session.setAttribute("returnFormName","AntennaSectorListForm");
%>
<tr><td><jsp:include page="/sectorList.jsp" flush="true" /></td></tr>
<july:separator/>
<tr><td><jsp:include page="/antennaList.jsp" flush="true" /></td></tr>
<july:separator/>
<tr class='title'>
<td class='title'>
<july:backbutton />
</td>
</tr>
<july:separator/>
</table>
</july:browseform>
