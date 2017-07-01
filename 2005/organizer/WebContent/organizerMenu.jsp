<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.organizer.*,com.hps.july.organizer.valueobject.*" %>
<%@ taglib uri="WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="WEB-INF/july.tld" prefix="july" %>

<%
	int appState = ParamsParser.getState( pageContext );
%>

		<july:menu selectedId="<%=appState%>">
          <july:menuitem key="label.menu.root" action="main.do?navclear=1" stateId="<%=APPStates.MAIN %>">
            <july:menuitem key="label.menu.login" action="ShowTaskList.do?navclear=1" stateId="<%=APPStates.TASKLIST %>">
              <july:menuselection stateId="<%=APPStates.TASKLIST %>"/>
              <july:menuselection stateId="<%=APPStates.LOGIN %>"/>
            </july:menuitem>
            <july:menuitem key="label.menu.reregister" action="Reregister.do?navclear=1" stateId="<%=APPStates.REREGISTER %>">
              <july:menuselection stateId="<%=APPStates.REREGISTER %>"/>
            </july:menuitem>
            <july:menuitem key="label.menu.logout" action="Logout.do?navclear=1" stateId="<%=APPStates.LOGOUT %>">
              <july:menuselection stateId="<%=APPStates.LOGOUT %>"/>
            </july:menuitem>
          </july:menuitem>
        </july:menu>
