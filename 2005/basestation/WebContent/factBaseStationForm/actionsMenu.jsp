<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld"    prefix="alex" %>
<%@ page import="com.hps.july.basestation.formbean.FactBaseStationForm" %>
<%@ page import="com.hps.july.basestation.valueobject.BaseStationObject" %>
<%@ page import="com.hps.july.constants.Applications" %>
<%@ page import="com.hps.july.apptags.HasAccessTag" %>
<%@ page import="com.hps.july.jdbcpersistence.lib.*" %>
<%@ page import="com.hps.july.web.util.*" %>

<logic:equal name="FactBaseStationForm" property="action" value="View">
<%
	boolean isFromSiteinfo=ParamsParser.getRootApp(pageContext)==Applications.SITEINFO;//sm.getRootState().getApp()==Applications.SITEINFO;
	FactBaseStationForm baseStation = (FactBaseStationForm)session.getAttribute("FactBaseStationForm");
	String journalUrl=AppConstants.BASE_POSITION+"/ShowJournalList.do?objecttype="+ObjectType.BaseStation+"&objectid="+baseStation.getBasestation();
	String onclickStr="openWindow('"+journalUrl+"');return false;";
	String siteDocUrl=AppConstants.BASE_SITEDOC+"/ShowSiteDocList.do?appHome="+ParamsParser.getRootApp(pageContext)+"&objectId="+baseStation.getBasestation()+"&objectType=BaseStation&canModify="
		+HasAccessTag.hasAccess(pageContext,"/Edit_EditFactBaseStation.do")+"&searchBy=O";
%>

<tr>
	<td class="text"><bean:message key="label.position.actions"/>:</td>
	<td>
		<alex:hasRegionAccess position="<%=String.valueOf(baseStation.getPosition().getStorageplace())%>" >
		<alex:hasAccess href="/Edit_EditFactBaseStation.do" >
			<july:editlink page="/Edit_EditFactBaseStation.do" action="Edit" paramId="basestation" paramName="FactBaseStationForm" paramProperty="basestation">
				<nobr><bean:message key="label.position.edit"/></nobr>
			</july:editlink>&nbsp;&nbsp;
		</alex:hasAccess>
		<% if(!isFromSiteinfo) { %>
		<alex:hasAccess href="/Edit_CopyFactBaseStation.do" >
			<july:editlink page="/Edit_CopyFactBaseStation.do" action="Edit" paramId="basestation" paramName="FactBaseStationForm" paramProperty="basestation">
				<nobr><bean:message key="label.basestation.copy"/></nobr>
			</july:editlink>&nbsp;&nbsp;
		</alex:hasAccess>
		<% } %>
<%--журнал изменений--%>
<%--br--%>
		<alex:hasAccess href="/ShowJournalList.do" file="/WEB-INF/web_siteinfo.xml">
			<html:link onclick="<%=onclickStr%>" href="<%=journalUrl%>">
				<nobr><bean:message key="label.menu.journal"/></nobr>
			</html:link>&nbsp;&nbsp;
		</alex:hasAccess>
		</alex:hasRegionAccess>

		<alex:hasAccess href="/ShowAntennaSectorList.do" >
			<july:link page="/ShowAntennaSectorList.do">
				<nobr><bean:message key="label.sectorsafs"/></nobr>
			</july:link>&nbsp;&nbsp;
		</alex:hasAccess>
		<alex:hasAccess href="/ShowEquipdetList.do" >
			<july:link href="/siteinfo/ShowEquipdetList.do" paramId="storageplace" paramName="FactBaseStationForm" paramProperty="basestation" >
				<nobr><bean:message key="link.equipment"/></nobr>
			</july:link>&nbsp;&nbsp;
		</alex:hasAccess>
		<%if(!isFromSiteinfo){%>
			<%if(!baseStation.getStationType().equals(Checks.BS_TYPE_DAMPS_D)) {%>
				<alex:hasAccess href="/ShowChanalPower.do" >
					<a href="ShowChanalPower.do?basestation=<%=baseStation.getBasestation()%>&returnPage=Edit_ViewFactBaseStation.do"><nobr><bean:message key="chanalpower.edit.title"/></nobr></a>&nbsp;&nbsp;
				</alex:hasAccess>
			<%}%>
		<%}%>
<%--документы--%>
		<july:link  href="<%=siteDocUrl%>"  >
			<nobr><bean:message key="link.documents"/></nobr>
		</july:link>&nbsp;&nbsp;
	</td>
</tr>
</logic:equal>
