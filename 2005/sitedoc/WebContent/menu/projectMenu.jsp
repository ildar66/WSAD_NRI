<%@ page import="com.hps.july.jdbcpersistence.lib.AppConstants"%>
<%@ page import="com.hps.july.constants.Applications"%>
<%@ page import="com.hps.july.jdbcpersistence.lib.*"%>
<%@ page import="com.hps.july.web.util.*"%>
<%@ page import="com.hps.july.project.APPStates"%>

<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<%
	String base = AppConstants.BASE_PROJECT + "/";
	int rootState = ParamsParser.getRootState( pageContext );
%>
<%--
<july:menu selectedId="<%= rootState %>">
	<july:menuitem key="label.enumproject" action='<%= base + "main.do" %>' stateId="<%= APPStates.MAIN %>">
		<july:menuselection stateId="<%=APPStates.MAIN %>"/>
		<% if (request.isUserInRole("administrator") || request.isUserInRole("planAdmin")) { %>
		<july:menuitem key="label.typeProjects" action='<%= base + "typeprojectList.do" %>' stateId="<%= APPStates.TYPEPROJECTLIST %>">
			<july:menuselection stateId="<%=APPStates.TYPEPROJECTLIST %>"/>
			<july:menuselection stateId="<%=APPStates.TYPEPROJECTFORM %>"/>
			<july:menuselection stateId="<%=APPStates.ACTIONSPROJECTLIST %>"/>
			<july:menuselection stateId="<%=APPStates.ACTIONSPROJECTFORM %>"/>
		</july:menuitem>
		<july:menuitem key="label.actiontype.dictionary" action='<%= base + "typeprojectActionList.do" %>' stateId="<%= APPStates.PROJECTACTIONTYPELIST %>">
			<july:menuselection stateId="<%=APPStates.PROJECTACTIONTYPELIST %>"/>
			<july:menuselection stateId="<%=APPStates.TYPEPROJECTACTIONFORM %>"/>
		</july:menuitem>
		<% } %>
		<july:menuitem key="label.menu.plan" action='<%= base + "projectList.do" %>' stateId="<%= APPStates.PROJECTLIST %>">
			<july:menuselection stateId="<%=APPStates.PROJECTLIST %>"/>
			<july:menuselection stateId="<%=APPStates.PROJECTFORM %>"/>
			<july:menuselection stateId="<%=APPStates.PROJECTSTATEFORM %>"/>
			<july:menuselection stateId="<%=APPStates.SETTINGSLIST %>"/>
			<july:menuselection stateId="<%=APPStates.PROJECTACTIONLIST %>"/>
			<july:menuselection stateId="<%=APPStates.PROJECTACTIONFORM %>"/>
			<july:menuselection stateId="<%=APPStates.WRSPLIST %>"/>
			<july:menuselection stateId="<%=APPStates.EDITWRSP %>"/>
			<july:menuselection stateId="<%=APPStates.EDITUSRCOL %>"/>
			<july:menuselection stateId="<%=APPStates.EDITUSRVAL %>"/>
		</july:menuitem>
	</july:menuitem>
</july:menu>
--%>
<july:menu selectedId="<%= rootState %>">
	<july:menuitem key="label.enumproject" action='<%=base+"main.do?navclear=1"%>' stateId="<%= APPStates.MAIN %>">
		<july:menuselection stateId="<%=APPStates.MAIN %>"/>
		<% if (request.isUserInRole("administrator") || request.isUserInRole("planAdmin")) { %>
		<july:menuitem key="label.typeProjects" action='<%= base+"typeprojectList.do?navclear=1&rootapp=" + Applications.PROJECT + "&rootstate=" + APPStates.TYPEPROJECTLIST %>' stateId="<%= APPStates.TYPEPROJECTLIST %>">
			<july:menuselection stateId="<%=APPStates.TYPEPROJECTLIST %>"/>
			<july:menuselection stateId="<%=APPStates.TYPEPROJECTFORM %>"/>
			<july:menuselection stateId="<%=APPStates.ACTIONSPROJECTLIST %>"/>
			<july:menuselection stateId="<%=APPStates.ACTIONSPROJECTFORM %>"/>
		</july:menuitem>
		<july:menuitem key="label.actiontype.dictionary" action='<%=base+"typeprojectActionList.do?navclear=1"%>' stateId="<%= APPStates.PROJECTACTIONTYPELIST %>">
			<july:menuselection stateId="<%=APPStates.PROJECTACTIONTYPELIST %>"/>
			<july:menuselection stateId="<%=APPStates.TYPEPROJECTACTIONFORM %>"/>
		</july:menuitem>
		<july:menuitem key="label.menu.typeresponsibility" action='<%=base+"ShowTyperesponsibilityList.do?navclear=1"%>' stateId="<%=APPStates.TRSPLIST %>">
			<july:menuselection stateId="<%=APPStates.TRSPLIST %>"/>
			<july:menuselection stateId="<%=APPStates.EDITTRSP %>"/>
		</july:menuitem>
		<july:menuitem key="menu.docType" action='<%=base+"ShowSiteDocTypeList.do?navclear=1"%>' stateId="<%=APPStates.SiteDocTypeListForm %>">
			<july:menuselection stateId="<%=APPStates.SiteDocTypeListForm %>"/>
			<july:menuselection stateId="<%=APPStates.SiteDocTypeForm %>"/>
		</july:menuitem>
		<% } %>
		<july:menuitem key="label.menu.plan" action='<%= base+"projectList.do?navclear=1&rootapp=" + Applications.PROJECT + "&rootstate=" + APPStates.PROJECTLIST %>' stateId="<%= APPStates.PROJECTLIST %>">
			<july:menuselection stateId="<%=APPStates.PROJECTLIST %>"/>
			<july:menuselection stateId="<%=APPStates.PROJECTFORM %>"/>
			<july:menuselection stateId="<%=APPStates.PROJECTSTATEFORM %>"/>
			<july:menuselection stateId="<%=APPStates.SETTINGSLIST %>"/>
			<july:menuselection stateId="<%=APPStates.PROJECTACTIONLIST %>"/>
			<july:menuselection stateId="<%=APPStates.PROJECTACTIONFORM %>"/>
			<july:menuselection stateId="<%=APPStates.WRSPLIST %>"/>
			<july:menuselection stateId="<%=APPStates.EDITWRSP %>"/>
			<july:menuselection stateId="<%=APPStates.EDITUSRCOL %>"/>
			<july:menuselection stateId="<%=APPStates.EDITUSRVAL %>"/>
		</july:menuitem>
            <%
                if(com.hps.july.util.AppUtils.isMicrostrategyAccess(request.getRemoteUser())) {
                String url = URLUtil.getMicrostrategyURL(request);
            %>
            <july:menuitem key="label.menu.microstrategy.report" action='<%=url%>' stateId="-801" target="1" windowName="Microstrategy">
                <july:menuselection stateId="-801"/>
            </july:menuitem>
            <%
                }
            %>
	</july:menuitem>
</july:menu>
