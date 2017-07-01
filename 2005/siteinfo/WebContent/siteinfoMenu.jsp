<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.util.*,com.hps.july.siteinfo.*"%>
<%@ page import="com.hps.july.jdbcpersistence.lib.AppConstants"%>
<%@ page import="com.hps.july.constants.Applications"%>
<%@ page import="com.hps.july.jdbcpersistence.lib.DebugSupport"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld"    prefix="alex" %>
<%
    int state = ParamsParser.getState( pageContext );
    int appHome= ParamsParser.getRootApp( pageContext ); //((Integer)session.getAttribute(AppConstants.APP_HOME)).intValue();
%>

	<july:menu selectedId="<%=state %>">

	<july:menuitem key="label.menu.root" action='<%= "main.do?navclear=1&rootapp="+Applications.SITEINFO +"&rootstate="+APPStates.MAIN %>' stateId="<%=APPStates.MAIN %>">
		<july:menuselection stateId="<%=APPStates.MAIN %>"/>
<% if(request.isUserInRole("developer")) { %>
	<july:menuitem key="label.menu.positions" action='<%= "ShowPositionList.do?navclear=1&rootapp="+Applications.SITEINFO+"&rootstate="+APPStates.POSLIST %>' stateId="<%=APPStates.POSLIST %>">
			<%if( ((String)session.getAttribute("mapState")) != null && ((String)session.getAttribute("mapState")).equals("0") ){%>
              <july:menuselection stateId="<%=APPStates.POSLIST %>"/>
              <july:menuselection stateId="<%=APPStates.EDITPOS %>"/>
              <july:menuselection stateId="<%=APPStates.EDITEPOS %>"/>
              <july:menuselection stateId="<%=APPStates.WRSPLIST %>"/>
              <july:menuselection stateId="<%=APPStates.EDITWRSP %>"/>
              <july:menuselection stateId="<%=APPStates.CLNLIST %>"/>
              <july:menuselection stateId="<%=APPStates.EDITCLN %>"/>
              <july:menuselection stateId="<%=APPStates.PHTLIST %>"/>
              <july:menuselection stateId="<%=APPStates.EDITPHT %>"/>
              <july:menuselection stateId="<%=APPStates.EQULIST %>"/>
              <july:menuselection stateId="<%=APPStates.BEENETLIST %>"/>
              <july:menuselection stateId="<%=APPStates.EDITBEENET %>"/>
              <july:menuselection stateId="<%=APPStates.EDITEQU %>"/>
			  <july:menuselection stateId="<%=APPStates.POSITIONSONMAP %>"/>
              <july:menuselection stateId="<%=APPStates.EQDETLIST %>"/>
              <july:menuselection stateId="<%=APPStates.EQDETMLIST %>"/>
              <july:menuselection stateId="<%=APPStates.EQSDETLIST %>"/>
			  <july:menuselection stateId="<%=APPStates.VIEWPOS %>"/>
			  <july:menuselection stateId="<%=APPStates.BUILDLISTPASS %>"/>
			  <%}%>
    </july:menuitem>
<%}%>
            <%
				String trailcomUrl = com.hps.july.util.AppUtils.getNamedValueString("PathPositionTableTrailcom") + "?id=" + request.getRemoteUser();
				String trailcomMapUrl = com.hps.july.util.AppUtils.getNamedValueString("PathMapTrailcom") + "?id=" + request.getRemoteUser(); 	
            %>
            <july:menuitem key="label.menu.trailcom.positions" action="<%= trailcomUrl %>" stateId="-831" target="2" windowName="TrailcomPositions">
                <july:menuselection stateId="-831"/>
            </july:menuitem>
<%--
            <july:menuitem key="label.menu.map" action='<%= "PositionListMap.do?navclear=1&imageFromCache=true&rootapp="+Applications.SITEINFO +"&rootstate="+APPStates.MAPINFO %>'
				stateId="<%=APPStates.MAPINFO %>">
                  <july:menuselection stateId="<%=APPStates.MAPINFO %>"/>
                  <july:menuselection stateId="<%=APPStates.EDITPOS %>"/>
	              <july:menuselection stateId="<%=APPStates.EDITEPOS %>"/>
		          <july:menuselection stateId="<%=APPStates.WRSPLIST %>"/>
			      <july:menuselection stateId="<%=APPStates.EDITWRSP %>"/>
				  <july:menuselection stateId="<%=APPStates.CLNLIST %>"/>
				  <july:menuselection stateId="<%=APPStates.EDITCLN %>"/>
				  <july:menuselection stateId="<%=APPStates.PHTLIST %>"/>
                  <july:menuselection stateId="<%=APPStates.EDITPHT %>"/>
				  <july:menuselection stateId="<%=APPStates.EQULIST %>"/>
				  <july:menuselection stateId="<%=APPStates.EDITEQU %>"/>
				</july:menuitem>
--%>
<%-- if(request.isUserInRole("administrator")) { --%>
	<july:menuitem key="label.menu.map" action='<%= trailcomMapUrl%>' stateId="-800"  target="2" windowName="TrailcomMaps">
		<july:menuselection stateId="-800"/>
	</july:menuitem>
<%-- } --%>

          <alex:menuitem  key="label.menu.superRegion" action='<%= "ShowSuperRegionList.do?navclear=1&rootapp="+Applications.SITEINFO +"&rootstate="+APPStates.SREGIONLIST%>' stateId="<%=APPStates.SREGIONLIST%>">
                  <july:menuselection stateId="<%=APPStates.SREGIONLIST %>"/>
                  <july:menuselection stateId="<%=APPStates.SREGIONEDIT %>"/>
          </alex:menuitem>

          <alex:menuitem key="label.menu.region" action='<%= "ShowRegionList.do?navclear=1&rootapp="+Applications.SITEINFO+"&rootstate="+APPStates.REGIONLIST%>' stateId="<%=APPStates.REGIONLIST%>">
                  <july:menuselection stateId="<%=APPStates.REGIONLIST%>"/>
                  <july:menuselection stateId="<%=APPStates.REGIONEDIT%>"/>
          </alex:menuitem>

                <alex:menuitem key="label.menu.netzone" action='<%= "ShowNetzoneList.do?navclear=1&rootapp="+Applications.SITEINFO+"&rootstate=" +APPStates.NZONELIST%>' stateId="<%=APPStates.NZONELIST %>">
                  <july:menuselection stateId="<%=APPStates.NZONELIST %>"/>
                  <july:menuselection stateId="<%=APPStates.EDITNZONE %>"/>
                </alex:menuitem>

               <alex:menuitem key="label.menu.typeresponsibility" action='<%= "ShowTyperesponsibilityList.do?navclear=1&rootapp="+Applications.SITEINFO+"&rootstate=" +APPStates.TRSPLIST%>' stateId="<%=APPStates.TRSPLIST %>">
                  <july:menuselection stateId="<%=APPStates.TRSPLIST %>"/>
                  <july:menuselection stateId="<%=APPStates.EDITTRSP %>"/>
                </alex:menuitem>

               <alex:menuitem key="label.menu.antennplaces" action='<%= "ShowAntennaPlacesList.do?navclear=1" %>' stateId="<%=APPStates.ANTENNAPLACESLIST %>">
                  <july:menuselection stateId="<%=APPStates.ANTENNAPLACESLIST %>"/>
                  <july:menuselection stateId="<%=APPStates.EDITANTENNAPLACE %>"/>
               </alex:menuitem>

               <alex:menuitem key="label.menu.oporaplaces" action='<%= "ShowOporaPlacesList.do?navclear=1" %>' stateId="<%=APPStates.OPORAPLACESLIST %>">
                  <july:menuselection stateId="<%=APPStates.OPORAPLACESLIST %>"/>
                  <july:menuselection stateId="<%=APPStates.EDITOPORAPLACE %>"/>
               </alex:menuitem>

               <alex:menuitem key="label.menu.applacetypes" action='<%= "ShowApparatPlaceTypesList.do?navclear=1" %>' stateId="<%=APPStates.APPARATPLACETYPESLIST %>">
                  <july:menuselection stateId="<%=APPStates.APPARATPLACETYPESLIST %>"/>
                  <july:menuselection stateId="<%=APPStates.EDITAPPARATPLACETYPE %>"/>
               </alex:menuitem>

               <alex:menuitem key="label.menu.apparattypes" action='<%= "ShowApparatTypesList.do?navclear=1" %>' stateId="<%=APPStates.APPARATTYPESLIST %>">
                  <july:menuselection stateId="<%=APPStates.APPARATTYPESLIST %>"/>
                  <july:menuselection stateId="<%=APPStates.EDITAPPARATTYPE %>"/>
               </alex:menuitem>

               <alex:menuitem key="label.menu.apparatplaces" action='<%= "ShowApparatPlacesList.do?navclear=1" %>' stateId="<%=APPStates.APPARATPLACESLIST %>">
                  <july:menuselection stateId="<%=APPStates.APPARATPLACESLIST %>"/>
                  <july:menuselection stateId="<%=APPStates.EDITAPPARATPLACE %>"/>
               </alex:menuitem>
            <%if(request.isUserInRole("administrator") || request.isUserInRole("electroCounterViewer") || request.isUserInRole("electroCounterEditor")) {%>
                <july:menuitem key="label.menu.electrocounter" stateId="-66">
                    <july:menuitem key="label.menu.electrocounter.info" action='<%= "ShowElectroCounterInfoList.do?navclear=1" %>' stateId="<%=APPStates.ELECTRO_COUNTER_INFO_LIST %>">
                        <july:menuselection stateId="<%=APPStates.ELECTRO_COUNTER_INFO_LIST %>"/>
                        <july:menuselection stateId="<%=APPStates.ELECTRO_COUNTER_INFO_EDIT %>"/>
                    </july:menuitem>
                    <july:menuitem key="label.menu.electrocounter.position" action='<%= "ShowElectroCounterList.do?navclear=1" %>' stateId="<%=APPStates.ELECTTRO_COUNTER_LIST %>">
                        <july:menuselection stateId="<%=APPStates.ELECTTRO_COUNTER_LIST %>"/>
                        <july:menuselection stateId="<%=APPStates.ELECTTRO_COUNTER_EDIT %>"/>
                    </july:menuitem>
                </july:menuitem>
            <%}%>
            <%if(request.isUserInRole("administrator")  || request.isUserInRole("developer") 
						|| request.isUserInRole("esnbsEditor") || request.isUserInRole("esnbsViewer")) {
				
				String cidnesUrl = com.hps.july.util.AppUtils.getNamedValueString("CIDNES_URL") + "?uid=" + request.getRemoteUser();
			%>
				
	       	    <july:menuitem key="label.menu.cidnes.title" action="<%=cidnesUrl%>" stateId="-802" target="2" windowName="Cidnes">
            	    <july:menuselection stateId="-802"/>
	       	    </july:menuitem>
            <%}%>
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
