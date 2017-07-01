<%@ page import="com.hps.july.jdbcpersistence.lib.AppConstants"%>
<%@ page import="com.hps.july.constants.Applications"%>
<%@ page import="com.hps.july.siteinfo.*"%>
<%@ page import="com.hps.july.jdbcpersistence.lib.*"%>
<%--@ page contentType = "TEXT/HTML; charset=windows-1251" --%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld"    prefix="alex" %>

<%
String positionBase=AppConstants.BASE_POSITION+"/";
String act=null;
String web_siteinfo="/WEB-INF/web_siteinfo.xml";
%>

<july:menu selectedId="<%=APPStates.EDITEPOS%>">
	<%act=positionBase+"main.do";%>
	<alex:menuitem file="/WEB-INF/web_siteinfo.xml" bundle="siteinfoResources" key="label.menu.root" action="<%=act%>" stateId="<%=APPStates.MAIN%>">
		<%act=positionBase+"ShowPositionList.do";%>
		<alex:menuitem file="/WEB-INF/web_siteinfo.xml" bundle="siteinfoResources"   key="label.menu.positions" action="<%=act%>" stateId="<%=APPStates.POSLIST %>">
			<july:menuselection stateId="<%=APPStates.EDITEPOS %>"/>
			<%if(((String)session.getAttribute("mapState")) != null && ((String)session.getAttribute("mapState")).equals("0") ){%>
				<july:menuselection stateId="<%=APPStates.POSLIST %>"/>
				<july:menuselection stateId="<%=APPStates.EDITEPOS %>"/>
				<july:menuselection stateId="<%=APPStates.WRSPLIST %>"/>
				<july:menuselection stateId="<%=APPStates.EDITWRSP %>"/>
				<july:menuselection stateId="<%=APPStates.CLNLIST %>"/>
				<july:menuselection stateId="<%=APPStates.EDITCLN %>"/>
				<july:menuselection stateId="<%=APPStates.PHTLIST %>"/>
				<july:menuselection stateId="<%=APPStates.EDITPHT %>"/>
				<july:menuselection stateId="<%=APPStates.EQULIST %>"/>
				<july:menuselection stateId="<%=APPStates.EDITEQU %>"/>
				<july:menuselection stateId="<%=APPStates.POSITIONSONMAP %>"/>
				<july:menuselection stateId="<%=APPStates.EQDETLIST %>"/>
				<july:menuselection stateId="<%=APPStates.EQSDETLIST %>"/>
			<%}%>
		</alex:menuitem>
		<%act=positionBase+"PositionListMap.do?fromLeftmenu=yes";%>
		<alex:menuitem file="/WEB-INF/web_siteinfo.xml" bundle="siteinfoResources" key="label.menu.map" action="<%=act%>" stateId="<%=APPStates.MAPINFO %>">
			<july:menuselection stateId="<%=APPStates.MAPINFO %>"/>
			<july:menuselection stateId="<%=APPStates.EDITPOS %>"/>
			<july:menuselection stateId="<%=APPStates.WRSPLIST %>"/>
			<july:menuselection stateId="<%=APPStates.EDITWRSP %>"/>
			<july:menuselection stateId="<%=APPStates.CLNLIST %>"/>
			<july:menuselection stateId="<%=APPStates.EDITCLN %>"/>
			<july:menuselection stateId="<%=APPStates.PHTLIST %>"/>
			<july:menuselection stateId="<%=APPStates.EDITPHT %>"/>
			<july:menuselection stateId="<%=APPStates.EQULIST %>"/>
			<july:menuselection stateId="<%=APPStates.EDITEQU %>"/>
		</alex:menuitem>
		<%act=positionBase+"ShowSuperRegionList.do";%>
		<alex:menuitem file="/WEB-INF/web_siteinfo.xml" bundle="siteinfoResources" key="label.menu.superRegion" action="<%=act%>" stateId="<%=APPStates.SREGIONLIST%>">
			<july:menuselection stateId="<%=APPStates.SREGIONLIST %>"/>
			<july:menuselection stateId="<%=APPStates.SREGIONEDIT %>"/>
		</alex:menuitem>
		<%act=positionBase+"ShowRegionList.do";%>
		<alex:menuitem file="/WEB-INF/web_siteinfo.xml" bundle="siteinfoResources" key="label.menu.region" action="<%=act%>" stateId="<%=APPStates.REGIONLIST%>">
			<july:menuselection stateId="<%=APPStates.REGIONLIST%>"/>
			<july:menuselection stateId="<%=APPStates.REGIONEDIT%>"/>
		</alex:menuitem>
		<%act=positionBase+"ShowNetzoneList.do";%>
		<alex:menuitem file="/WEB-INF/web_siteinfo.xml" bundle="siteinfoResources" key="label.menu.netzone" action="<%=act%>" stateId="<%=APPStates.NZONELIST%>">
			<july:menuselection stateId="<%=APPStates.NZONELIST %>"/>
			<july:menuselection stateId="<%=APPStates.EDITNZONE %>"/>
		</alex:menuitem>
		<%act=positionBase+"ShowTyperesponsibilityList.do";%>
		<alex:menuitem file="/WEB-INF/web_siteinfo.xml" bundle="siteinfoResources" key="label.menu.typeresponsibility" action="<%=act%>" stateId="<%=APPStates.TRSPLIST%>">
			<july:menuselection stateId="<%=APPStates.TRSPLIST %>"/>
			<july:menuselection stateId="<%=APPStates.EDITTRSP %>"/>
		</alex:menuitem>
<%
		act=positionBase+"ShowSiteDocTypeList.do";
		if(request.isUserInRole("administrator") || request.isUserInRole("supregAdmin") || request.isUserInRole("regionAdmin")) 
		{
%>
		<alex:menuitem checkAccess="false" key="menu.docType" action="<%=act%>" stateId="<%=com.hps.july.siteinfo.APPStates.SiteDocTypeListForm %>">
			<july:menuselection stateId="<%=com.hps.july.siteinfo.APPStates.SiteDocTypeListForm %>"/>
			<july:menuselection stateId="<%=com.hps.july.siteinfo.APPStates.SiteDocTypeForm %>"/>
		</alex:menuitem>
<%
		}
%>
		<%act=positionBase+"ShowAntennaPlacesList.do?navclear=1";%>
		<alex:menuitem file="/WEB-INF/web_siteinfo.xml" bundle="siteinfoResources" key="label.menu.antennplaces" action="<%=act%>" stateId="<%=APPStates.ANTENNAPLACESLIST%>">
			<july:menuselection stateId="<%=APPStates.ANTENNAPLACESLIST %>"/>
			<july:menuselection stateId="<%=APPStates.EDITANTENNAPLACE %>"/>
		</alex:menuitem>
		<%act=positionBase+"ShowOporaPlacesList.do?navclear=1";%>
		<alex:menuitem file="/WEB-INF/web_siteinfo.xml" bundle="siteinfoResources" key="label.menu.oporaplaces" action='<%=act%>' stateId="<%=APPStates.OPORAPLACESLIST %>">
			<july:menuselection stateId="<%=APPStates.OPORAPLACESLIST %>"/>
			<july:menuselection stateId="<%=APPStates.EDITOPORAPLACE %>"/>
		</alex:menuitem>
		<%act=positionBase+"ShowApparatPlaceTypesList.do?navclear=1";%>
		<alex:menuitem file="/WEB-INF/web_siteinfo.xml" bundle="siteinfoResources" key="label.menu.applacetypes" action='<%=act%>' stateId="<%=APPStates.APPARATPLACETYPESLIST %>">
			<july:menuselection stateId="<%=APPStates.APPARATPLACETYPESLIST %>"/>
			<july:menuselection stateId="<%=APPStates.EDITAPPARATPLACETYPE %>"/>
		</alex:menuitem>
		<%act=positionBase+"ShowApparatTypesList.do?navclear=1";%>
		<alex:menuitem file="/WEB-INF/web_siteinfo.xml" bundle="siteinfoResources" key="label.menu.apparattypes" action='<%=act%>' stateId="<%=APPStates.APPARATTYPESLIST %>">
			<july:menuselection stateId="<%=APPStates.APPARATTYPESLIST %>"/>
			<july:menuselection stateId="<%=APPStates.EDITAPPARATTYPE %>"/>
		</alex:menuitem>
		<%act=positionBase+"ShowApparatPlacesList.do?navclear=1";%>
		<alex:menuitem file="/WEB-INF/web_siteinfo.xml" bundle="siteinfoResources" key="label.menu.apparatplaces" action='<%=act%>' stateId="<%=APPStates.APPARATPLACESLIST %>">
			<july:menuselection stateId="<%=APPStates.APPARATPLACESLIST %>"/>
			<july:menuselection stateId="<%=APPStates.EDITAPPARATPLACE %>"/>
		</alex:menuitem>
	</alex:menuitem>
</july:menu>
