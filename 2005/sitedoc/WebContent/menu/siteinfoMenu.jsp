<%@ page import="com.hps.july.jdbcpersistence.lib.AppConstants,
                 com.hps.july.constants.Applications,
                 com.hps.july.siteinfo.*,
				 com.hps.july.web.util.*,
                 com.hps.july.jdbcpersistence.lib.*"%>
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
	int rootState = ParamsParser.getRootState( pageContext );
%>

<july:menu selectedId="<%= rootState %>">
<%act=positionBase+"main.do";%>

          <alex:menuitem file="/WEB-INF/web_siteinfo.xml" bundle="bsResources" key="label.menu.root" action="<%=act%>" stateId="<%=APPStates.MAIN %>">
 <%act=positionBase+"ShowPositionList.do";

 %>
<alex:menuitem file="/WEB-INF/web_siteinfo.xml" bundle="bsResources"   key="label.menu.positions" action="<%=act%>" stateId="<%=APPStates.POSLIST %>">
<july:menuselection stateId="<%=APPStates.EDITEPOS %>"/>
 <%if( ((String)session.getAttribute("mapState")) != null && ((String)session.getAttribute("mapState")).equals("0") ){%>
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

 <%act=positionBase+"PositionListMap.do?fromLeftmenu=yes";

 %>
 <alex:menuitem file="/WEB-INF/web_siteinfo.xml" bundle="bsResources" key="label.menu.map" action="<%=act%>"
				stateId="<%=APPStates.MAPINFO %>">
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

<%

    act=positionBase+"ShowSuperRegionList.do";
    //DebugSupport.printlnTest("!!!siteinfoMenu.jsp act="+act);
%>
          <alex:menuitem file="/WEB-INF/web_siteinfo.xml" bundle="bsResources" key="label.menu.superRegion" action="<%=act%>" stateId="<%=APPStates.SREGIONLIST%>">
                  <july:menuselection stateId="<%=APPStates.SREGIONLIST %>"/>
                  <july:menuselection stateId="<%=APPStates.SREGIONEDIT %>"/>
          </alex:menuitem>

<%act=positionBase+"ShowRegionList.do";

%>
 <alex:menuitem file="/WEB-INF/web_siteinfo.xml" bundle="bsResources" key="label.menu.region" action="<%=act%>" stateId="<%=APPStates.REGIONLIST%>">
                  <july:menuselection stateId="<%=APPStates.REGIONLIST%>"/>
                  <july:menuselection stateId="<%=APPStates.REGIONEDIT%>"/>
          </alex:menuitem>

<%act=positionBase+"ShowNetzoneList.do";

%>
                <alex:menuitem file="/WEB-INF/web_siteinfo.xml" bundle="bsResources" key="label.menu.netzone" action="<%=act%>" stateId="<%=APPStates.NZONELIST %>">
                  <july:menuselection stateId="<%=APPStates.NZONELIST %>"/>
                  <july:menuselection stateId="<%=APPStates.EDITNZONE %>"/>
                </alex:menuitem>


 <%act=positionBase+"ShowTyperesponsibilityList.do"; %>
 <alex:menuitem file="/WEB-INF/web_siteinfo.xml" bundle="bsResources" key="label.menu.typeresponsibility" action="<%=act%>" stateId="<%=APPStates.TRSPLIST %>">
                  <july:menuselection stateId="<%=APPStates.TRSPLIST %>"/>
                  <july:menuselection stateId="<%=APPStates.EDITTRSP %>"/>
                </alex:menuitem>


	<%if(request.isUserInRole("administrator")) { %>
		<% act=positionBase+"ShowSiteDocTypeList.do"; %>
                <alex:menuitem checkAccess="false"  key="menu.docType"  action="<%=act%>" stateId="<%=com.hps.july.siteinfo.APPStates.SiteDocTypeListForm %>">
                 <july:menuselection stateId="<%=com.hps.july.siteinfo.APPStates.SiteDocTypeListForm %>"/>
                 <july:menuselection stateId="<%=com.hps.july.siteinfo.APPStates.SiteDocTypeForm %>"/>
                </alex:menuitem>
	<%}%>

<%act=positionBase+"ShowAntennaPlacesList.do?navclear=1";%>
	<alex:menuitem key="label.menu.antennplaces" action='<%= act %>' stateId="<%=com.hps.july.siteinfo.APPStates.ANTENNAPLACESLIST %>">
		<july:menuselection stateId="<%=com.hps.july.siteinfo.APPStates.ANTENNAPLACESLIST %>"/>
		<july:menuselection stateId="<%=com.hps.july.siteinfo.APPStates.EDITANTENNAPLACE %>"/>
	</alex:menuitem>

<%act=positionBase+"ShowOporaPlacesList.do?navclear=1";%>
	<alex:menuitem key="label.menu.oporaplaces" action='<%= act %>' stateId="<%=com.hps.july.siteinfo.APPStates.OPORAPLACESLIST %>">
		<july:menuselection stateId="<%=com.hps.july.siteinfo.APPStates.OPORAPLACESLIST %>"/>
		<july:menuselection stateId="<%=com.hps.july.siteinfo.APPStates.EDITOPORAPLACE %>"/>
	</alex:menuitem>

<%act=positionBase+"ShowApparatPlaceTypesList.do?navclear=1";%>
	<alex:menuitem key="label.menu.applacetypes" action='<%= act %>' stateId="<%=com.hps.july.siteinfo.APPStates.APPARATPLACETYPESLIST %>">
		<july:menuselection stateId="<%=com.hps.july.siteinfo.APPStates.APPARATPLACETYPESLIST %>"/>
		<july:menuselection stateId="<%=com.hps.july.siteinfo.APPStates.EDITAPPARATPLACETYPE %>"/>
	</alex:menuitem>

<%act=positionBase+"ShowApparatTypesList.do?navclear=1";%>
	<alex:menuitem key="label.menu.apparattypes" action='<%= act %>' stateId="<%=com.hps.july.siteinfo.APPStates.APPARATTYPESLIST %>">
		<july:menuselection stateId="<%=com.hps.july.siteinfo.APPStates.APPARATTYPESLIST %>"/>
		<july:menuselection stateId="<%=com.hps.july.siteinfo.APPStates.EDITAPPARATTYPE %>"/>
	</alex:menuitem>

<%act=positionBase+"ShowApparatPlacesList.do?navclear=1";%>
	<alex:menuitem key="label.menu.apparatplaces" action='<%= act %>' stateId="<%=com.hps.july.siteinfo.APPStates.APPARATPLACESLIST %>">
		<july:menuselection stateId="<%=com.hps.july.siteinfo.APPStates.APPARATPLACESLIST %>"/>
		<july:menuselection stateId="<%=com.hps.july.siteinfo.APPStates.EDITAPPARATPLACE %>"/>
	</alex:menuitem>
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
</alex:menuitem>
</july:menu>

