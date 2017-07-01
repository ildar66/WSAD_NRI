<%@ page contentType = "TEXT/HTML; charset=Windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import="java.util.*,com.hps.july.persistence.*,com.hps.july.siteinfo.actionbean.*,com.hps.july.siteinfo.formbean.*" %>
<%
	String colspan="3";
	BuildListPassForm form = ((BuildListPassForm)session.getAttribute("BuildListPassForm"));
	String paspDataWorkerBeelineColspan = form.isPaspDataWorkerBeeline() ? "1":"2";
	String paspDataWorkerNoBeelineColspan = form.isPaspDataWorkerNoBeeline() ? "1":"2";
	//out.print("paspDataWorkerBeelineColspan="+paspDataWorkerBeelineColspan+"<br>");
	//out.print("paspDataWorkerNoBeelineColspan="+paspDataWorkerNoBeelineColspan+"<br>");
	PositionAccessBean apos = ((PositionAccessBean)request.getAttribute("position"));
%>
<%
	String name = "СП_";
	if (apos.getDampsid() != null)
		name = name + "А" + apos.getDampsid();
	if ( (apos.getDampsid() != null) && (apos.getGsmid() != null))
		name = name + "_";
	if (apos.getGsmid() != null)
		name = name + "Д" + apos.getGsmid();

	response.setHeader("Cache-Control", "no-cache");
	response.setContentType("application/msword; name=" + java.net.URLEncoder.encode(name+".doc") +";charset=windows-1251");
	response.setHeader("Content-Disposition", "attachment; filename=listpass.doc");
%>

<html>
<head>
	<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
	<META HTTP-EQUIV="Content-Type" CONTENT="application/msword; charset=Windows-1251">
	<title><bean:message key="label.siteinfo"/></title>
</head>
<body>

	<%-- <table border=0 cellspacing=0 cellpadding=0 width=633 align=center style='width:474.9pt;margin-left:3.5pt;border-collapse:collapse;mso-padding-alt:0cm 3.5pt 0cm 3.5pt;border-style: solid;border-width:1;'> --%>
	<table border=1 cellspacing=0 cellpadding=0 width=633 align=center style='mso-padding-alt:0cm 3.5pt 0cm 3.5pt; border-style:solid;border-width:1px;font-family: Arial; font-size: 10pt;'>
        <tr>
		<td colspan="<%= colspan %>" align=center style="font-weight: bold; border-bottom-style: solid;border-bottom-width:2;">
		<bean:message key="word.label.list"/> &nbsp;&nbsp;&nbsp;
			<bean:write name="position" property="name" />&nbsp;&nbsp;&nbsp;
			<logic:present name="position" property="address">
				<logic:present name="position" property="address" />&nbsp;&nbsp;&nbsp;
			</logic:present>
			<logic:present name="position" property="gsmid">
				D<bean:write name="position" property="gsmid"/>&nbsp;&nbsp;
			</logic:present>
			<logic:present name="position" property="dampsid">
				A<bean:write name="position" property="dampsid" filter="true"/>&nbsp;&nbsp;
			</logic:present>			
		</td>
		</tr>
		<logic:equal name="BuildListPassForm" property="workerBeeline" value="true">
			<%--
			<tr>
				<td colspan="<%=colspan%>" style="font-weight: bold"><br><bean:message key="word.label.workerBee"/>
			</td></tr>
			<logic:equal name="workerBeeline" property="empty" value="true">
				<tr><td colspan="<%=colspan%>"><bean:message key="word.label.noinfo"/></td></tr>
			</logic:equal>
			--%>
			<logic:iterate id="wrk" name="workerBeeline">
			<tr>			
				<td style="border-top:none;border-bottom:none;">
					<logic:present name="wrk" property="orgname">
						<bean:write name="wrk" property="orgname" filter="true"/>
					</logic:present>
				</td>
				<td style="border-top:none;border-bottom:none;" colspan="<%= paspDataWorkerBeelineColspan %>">
					<logic:present name="wrk" property="lastname">
						<bean:write name="wrk" property="lastname" filter="true"/> <bean:write name="wrk" property="firstname" filter="true"/> <bean:write name="wrk" property="middlename" filter="true"/>
					</logic:present>
					
				</td>
				<logic:equal name="BuildListPassForm" property="paspDataWorkerBeeline" value="true">
					<td style="border-top:none;border-bottom:none;">
						<logic:present name="wrk" property="passportser">
							<%-- <bean:message key="word.label.paspser"/> &nbsp; --%>
							<bean:write name="wrk" property="passportser" filter="true"/>&nbsp;&nbsp;
						</logic:present>

						<logic:present name="wrk" property="passportdate">
							<bean:message key="word.label.give"/>&nbsp;
							<july:datewrite name="wrk" property="passportdate"/>&nbsp;&nbsp;
						</logic:present>

						<logic:present name="wrk" property="passportwhom">
							<bean:message key="word.label.who"/>&nbsp;
							<bean:write name="wrk" property="passportwhom" filter="true"/>
						</logic:present>
					</td>
				</logic:equal>			
			</tr>
			</logic:iterate>
		</logic:equal>
		<logic:equal name="BuildListPassForm" property="workerNoBeeline" value="true">			

			<%--
			<logic:equal name="workerNoBeeline" property="empty" value="true">
				<tr><td colspan="<%=colspan%>">
				<b><br><bean:message key="word.label.noinfo.org"/></b>
				</td></tr>
			</logic:equal>
			--%>
			
			<%String oldOrgname = "";%>

			<logic:iterate id="wrk" name="workerNoBeeline">


<%--
<%				WorkerValueObject temp = (WorkerValueObject)wrk;
				String newname = null;
				if(temp.getOrgname() != null) {
					newname = temp.getOrgname();
					if(!oldOrgname.equals(newname)) {
							oldOrgname=newname;
%>
					<tr><td colspan="<%=colspan%>" style="font-weight: bold"><br>Сотрудники <%=newname%></td></tr>
<%
					}
				}
%>
--%>

			<tr>			
				<td style="border-top:none;border-bottom:none;">
					<logic:present name="wrk" property="orgname">
						<bean:write name="wrk" property="orgname" filter="true"/>
					</logic:present>
				</td>
				<td style="border-top:none;border-bottom:none;" colspan="<%= paspDataWorkerNoBeelineColspan %>">
					<logic:present name="wrk" property="lastname">
						<bean:write name="wrk" property="lastname" filter="true"/> <bean:write name="wrk" property="firstname" filter="true"/> <bean:write name="wrk" property="middlename" filter="true"/>
					</logic:present>
				</td>
				<logic:equal name="BuildListPassForm" property="paspDataWorkerNoBeeline" value="true">
					<td style="border-top:none;border-bottom:none;">
					<logic:present name="wrk" property="worker">
						<logic:present name="wrk" property="passportser">
							<%-- <bean:message key="word.label.paspser"/>:&nbsp; --%>
							<bean:write name="wrk" property="passportser" filter="true"/>&nbsp;
						</logic:present>
						<logic:present name="wrk" property="passportdate">
							<bean:message key="word.label.give"/>:&nbsp;<july:datewrite name="wrk" property="passportdate"/>&nbsp;
						</logic:present>
						<logic:present name="wrk" property="passportwhom">
							<bean:message key="word.label.who"/>:&nbsp;<bean:write name="wrk" property="passportwhom" filter="true"/>
						</logic:present>
					</logic:present>
					</td>
				</logic:equal>			
			</tr>
			</logic:iterate>
		</logic:equal>

		<logic:equal name="BuildListPassForm" property="carBeeline" value="true">

			<TR>
				<td colspan="<%=colspan%>" style="border-top-style: solid;border-top-width:2; border-bottom-style: solid;border-bottom-width:2;">
					<br><B><bean:message key="word.label.cars"/></B>
				</td>
			</TR>
			<%--
			<tr><td colspan="<%=colspan%>" style="font-weight: bold">
			<br><bean:message key="word.label.carBee"/></td></tr>
			<logic:equal name="carBeeline" property="empty" value="true">
				<tr><td colspan="<%=colspan%>">
				<bean:message key="word.label.nocarinfo"/></td></tr>
			</logic:equal>
			--%>

			<logic:iterate id="car" name="carBeeline">
			<tr>			
				<td style="border-top:none;border-bottom:none;" colspan="2">
					<logic:present name="car" property="orgname">
						<bean:write name="car" property="orgname" filter="true"/>
					</logic:present>
				</td>
				<td style="border-top:none;border-bottom:none;">
					<%-- <bean:message key="word.label.carmodel"/>&nbsp;&nbsp;&nbsp; --%>
					<bean:write name="car" property="carmodel" filter="true"/>&nbsp;&nbsp;&nbsp;
					<%-- <bean:message key="word.label.carnum"/>&nbsp;&nbsp;&nbsp; --%>
					<bean:write name="car" property="carnumber" filter="true"/>
				</td>
			</tr>
			</logic:iterate>			
		</logic:equal>

		<logic:equal name="BuildListPassForm" property="carNoBeeline" value="true">
		
			<%--
			<logic:equal name="carNoBeeline" property="empty" value="true">
				<tr><td colspan="<%=colspan%>"><b><br><bean:message key="word.label.nocarinfo.org"/></b></td></tr>
			</logic:equal>
			--%>

<%
			String oldOrgname = "";
%>
			<logic:iterate id="car" name="carNoBeeline">

<%--
<%
				CarValueObject temp = (CarValueObject)car;
				String newname = temp.getOrgname();
				if(temp.getOrgname() != null) {
					if(!oldOrgname.equals(newname)) {
						oldOrgname = newname;
%>
				<tr><td colspan="<%=colspan%>" style="font-weight: bold">
				<br><bean:message key="word.label.cars"/>&nbsp;<%=newname%></td></tr>
<%
					}
				}
%>
--%>

			<tr>			
				<td style="border-top:none;border-bottom:none;" colspan="2">
					<logic:present name="car" property="orgname">
						<bean:write name="car" property="orgname" filter="true"/>
					</logic:present>
				</td>
				<td style="border-top:none;border-bottom:none;">
					<%-- <bean:message key="word.label.carmodel"/>&nbsp;&nbsp;&nbsp; --%>
					<bean:write name="car" property="carmodel" filter="true"/>&nbsp;&nbsp;&nbsp;
					<%-- <bean:message key="word.label.carnum"/>&nbsp;&nbsp;&nbsp; --%>
					<bean:write name="car" property="carnumber" filter="true"/>
				</td>
			</tr>
			</logic:iterate>			
		</logic:equal>
	</table>
