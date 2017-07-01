<%@ page import="com.hps.july.jdbcpersistence.lib.AppConstants"%>
<%@ page import="com.hps.july.constants.Applications"%>
<%@ page import="com.hps.july.jdbcpersistence.lib.*"%>
<%@ page import="com.hps.july.web.util.*"%>
<%@ page import="com.hps.july.basestation.APPStates"%>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld"    prefix="alex" %>
<%
	//StateManager sm=(StateManager)session.getAttribute(AppConstants.PARAM_STATE_MANAGER);
	String base=AppConstants.BASE_BASESTATION+"/";
	String act=base+"main.do";
	//String web_xml="/WEB-INF/web_basestation.xml";
	//int appState=sm.getRootState().getState();
	int state = ParamsParser.getRootState( pageContext );
	//int appState=((Integer)session.getAttribute(AppConstants.APP_STATE)).intValue();
%>

<july:menu selectedId="<%=state %>">
	<alex:menuitem key="menu.root.baseStation_" stateId="<%=APPStates.MAIN %>" action="<%=act%>" file="/WEB-INF/web_basestation.xml" bundle="bsResources">
		<july:menuselection stateId="<%=APPStates.MAIN %>"/>
		<%act = base+"ShowBaseStationList.do?navclear=1&rootapp="+Applications.BASESTATION+"&rootstate="+APPStates.BS_LIST;%>
		<alex:menuitem key="menu.baseStationList" action="<%=act%>" stateId="<%=APPStates.BS_LIST%>" file="/WEB-INF/web_basestation.xml" bundle="bsResources">
		<%if( ((String)session.getAttribute("mapState")) != null && ((String)session.getAttribute("mapState")).equals("0") ){%>
			<july:menuselection stateId="<%=APPStates.BS_LIST %>"/>
			<july:menuselection stateId="<%=APPStates.BS_PEdit %>"/>
			<july:menuselection stateId="<%=APPStates.BS_FVIEW %>"/>
			<july:menuselection stateId="<%=APPStates.BS_PVIEW %>"/>
			<july:menuselection stateId="<%=APPStates.BS_FEdit %>"/>
			<july:menuselection stateId="<%=APPStates.POSITIONSONMAP %>"/>
			<july:menuselection stateId="<%=APPStates.BS_EQ_LIST %>"/>
			<july:menuselection stateId="<%=APPStates.ANTENNES_CHOICE %>"/>
			<july:menuselection stateId="<%=APPStates.SECT_EDIT %>"/>
			<july:menuselection stateId="<%=APPStates.SECT_COPY %>"/>
			<july:menuselection stateId="<%=APPStates.ANT_EDIT %>"/>
			<july:menuselection stateId="<%=APPStates.EQDETLIST %>"/>
			<july:menuselection stateId="<%=APPStates.EQSDETLIST %>"/>
			<july:menuselection stateId="<%=APPStates.VIEWCHANALPOWERS %>"/>
			<july:menuselection stateId="<%= APPStates.FROMSECTOR_REPEATER_LIST %>"/>
			<july:menuselection stateId="<%= APPStates.FROMSECTOR_REPEATER_EDIT %>"/>
		<%}else{%>
			<july:menuselection stateId="<%=APPStates.BS_LIST %>"/>
		<%}%>
		</alex:menuitem>

		<%act = base+"ShowSwitchList.do?navclear=1&rootapp="+Applications.BASESTATION+"&rootstate="+APPStates.SwitchListForm;%>
		<alex:menuitem key="menu.switchList" action="<%=act%>" stateId="<%=APPStates.SwitchListForm%>" file="/WEB-INF/web_basestation.xml" bundle="bsResources">
			<july:menuselection stateId="<%=APPStates.SwitchListForm %>"/>
			<july:menuselection stateId="<%=APPStates.SwitchForm %>"/>
			<july:menuselection stateId="<%=APPStates.SWCH_EDIT %>"/>
			<july:menuselection stateId="<%=APPStates.SWCH_VIEW %>"/>
			<july:menuselection stateId="<%=APPStates.SWCH_PARAMS_EDIT %>"/>
			<july:menuselection stateId="<%=APPStates.SWCH_CONNECTED_CONTR %>"/>
			<july:menuselection stateId="<%=APPStates.SwitchControllerForm %>"/>
		</alex:menuitem>

		<%act = base+"ShowControllerList.do?navclear=1&rootapp="+Applications.BASESTATION+"&rootstate="+APPStates.CONTROLLER_LIST;%>
		<alex:menuitem key="menu.controllerlist" action="<%=act%>" stateId="<%= APPStates.CONTROLLER_LIST %>" file="/WEB-INF/web_basestation.xml" bundle="bsResources">
			<july:menuselection stateId="<%= APPStates.CONTROLLER_LIST %>"/>
			<july:menuselection stateId="<%= APPStates.CONTROLLER_EDIT %>"/>
			<july:menuselection stateId="<%= APPStates.CONTROLLER_DESC_EDIT %>"/>
			<july:menuselection stateId="<%= APPStates.CONTROLLER_DESC_VIEW %>"/>
			<july:menuselection stateId="<%= APPStates.CONTROLLER_PARAMS %>"/>
			<july:menuselection stateId="<%= APPStates.CONTROLLER_CONNECTED_BS %>"/>
		</alex:menuitem>

		<%act = base+"ShowRepeaterList.do?navclear=1&rootapp="+Applications.BASESTATION+"&rootstate="+APPStates.REPEATER_LIST;%>
		<alex:menuitem key="menu.repeaterlist" action="<%=act%>" stateId="<%= APPStates.REPEATER_LIST %>" file="/WEB-INF/web_basestation.xml" bundle="bsResources">
			<july:menuselection stateId="<%= APPStates.REPEATER_LIST %>"/>
			<july:menuselection stateId="<%= APPStates.REPEATER_EDIT %>"/>
		</alex:menuitem>

		<%act = base+"ShowComlineList.do?navclear=1&rootapp="+Applications.BASESTATION+"&rootstate="+APPStates.ComlineListForm;%>
		<alex:menuitem key="menu.comlineList" action="<%=act%>" stateId="<%=APPStates.ComlineListForm%>" file="/WEB-INF/web_basestation.xml" bundle="bsResources">
			<july:menuselection stateId="<%=APPStates.ComlineListForm %>"/>
			<july:menuselection stateId="<%=APPStates.ComlineRForm %>"/>
		</alex:menuitem>

		<%act = base+"LoadXls.do?navclear=1";%>
		<alex:menuitem key="xls.import" action="<%=act%>" stateId="<%=APPStates.IMPORTXLS %>" file="/WEB-INF/web_basestation.xml" bundle="bsResources">
		<%if(session.getAttribute("task")!=null&&((Integer)session.getAttribute("task")).intValue()!=3){%>
			<july:menuselection stateId="<%=APPStates.IMPORTXLS %>"/>
			<july:menuselection stateId="<%=APPStates.XLSLOADRESULT %>"/>
			<july:menuselection stateId="<%=APPStates.XLSLOADEXTENDEDRESULT %>"/>
			<july:menuselection stateId="<%=APPStates.XLSLOADJOURNAL %>"/>
			<july:menuselection stateId="<%=APPStates.LOADRESULTS %>"/>
		<%}%>
		</alex:menuitem>

		<%act = base+"LoadXlsBs.do?navclear=1";%>
		<alex:menuitem key="xls.import.bs" action="<%=act%>" stateId="<%=APPStates.IMPORTXLS_BS %>" file="/WEB-INF/web_basestation.xml" bundle="bsResources">
		<%if(session.getAttribute("task")!=null&&((Integer)session.getAttribute("task")).intValue()==3){%>
			<july:menuselection stateId="<%=APPStates.IMPORTXLS_BS %>"/>
			<july:menuselection stateId="<%=APPStates.XLSLOADRESULT %>"/>
			<july:menuselection stateId="<%=APPStates.XLSLOADEXTENDEDRESULT %>"/>
			<july:menuselection stateId="<%=APPStates.XLSLOADJOURNAL %>"/>
			<july:menuselection stateId="<%=APPStates.LOADRESULTS %>"/>
		<%}%>
		</alex:menuitem>

		<%act = base+"ShowGKRCHDocList.do?navclear=1";%>
		<alex:menuitem key="menu.gkrch" action="<%=act%>" stateId="<%=APPStates.GKRCH_LIST %>" file="/WEB-INF/web_basestation.xml" bundle="bsResources">
			<july:menuselection stateId="<%=APPStates.GKRCH_LIST %>"/>
			<july:menuselection stateId="<%=APPStates.GKRCH_FORM %>"/>
			<july:menuselection stateId="<%=APPStates.GKRCH_FILE%>"/>
			<july:menuselection stateId="<%=APPStates.DOCFILES_LIST%>"/>
			<july:menuselection stateId="<%=APPStates.SITEDOC_FILE%>"/>
		</alex:menuitem>

		<%act = base+"ShowRRLDocList.do?navclear=1";%>
		<alex:menuitem key="menu.rrl" action="<%=act%>" stateId="<%=APPStates.RRL_LIST %>" file="/WEB-INF/web_basestation.xml" bundle="bsResources">
			<july:menuselection stateId="<%=APPStates.RRL_LIST %>"/>
			<july:menuselection stateId="<%=APPStates.RRL_FORM %>"/>
		</alex:menuitem>

		<%act = base+"ShowFrequencyLicenceList.do?navclear=1&rootapp="+Applications.BASESTATION+"&rootstate="+APPStates.FREQLICENCE_LIST;%>
		<alex:menuitem key="label.menu.frequecylicence" action="<%=act%>" stateId="<%=APPStates.FREQLICENCE_LIST%>" file="/WEB-INF/web_basestation.xml" bundle="bsResources">
			<july:menuselection stateId="<%=APPStates.FREQLICENCE_LIST %>"/>
			<july:menuselection stateId="<%=APPStates.FREQLICENCE_FORM %>"/>
			<july:menuselection stateId="<%=APPStates.FREQLICENCE_HIST %>"/>
			<july:menuselection stateId="<%=APPStates.ETAP_FORM %>"/>
		</alex:menuitem>

		<%act = base+"ShowEtapTypeList.do?navclear=1";%>
		<alex:menuitem key="label.menu.etaptypes" action="<%=act%>" stateId="<%=APPStates.ETAPTYPE_LIST %>" file="/WEB-INF/web_basestation.xml" bundle="bsResources">
			<july:menuselection stateId="<%=APPStates.ETAPTYPE_LIST %>"/>
			<july:menuselection stateId="<%=APPStates.ETAPTYPE_FORM %>"/>
		</alex:menuitem>

		<%act = base+"ReportBaseStation.do?navclear=1";%>
		<alex:menuitem key="label.menu.reports" action="<%=act%>" stateId="<%=APPStates.REPORT_HAVEPLAN_LOOKUP %>" file="/WEB-INF/web_basestation.xml" bundle="bsResources">
			<july:menuselection stateId="<%=APPStates.REPORT_HAVEPLAN_LOOKUP %>"/>
			<july:menuselection stateId="<%=APPStates.REPORT_HAVEPLAN_SHOW %>"/>
		</alex:menuitem>

<%
if(com.hps.july.util.AppUtils.isMicrostrategyAccess(request.getRemoteUser())) {
String url = URLUtil.getMicrostrategyURL(request);
%>
		<july:menuitem key="label.menu.microstrategy.report" action='<%=url%>' stateId="-801" target="1" windowName="Microstrategy">
			<july:menuselection stateId="-801"/>
		</july:menuitem>
<%}%>

	</alex:menuitem>
</july:menu>
