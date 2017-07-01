<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.security.*, com.hps.july.constants.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<SCRIPT language=javascript src="/common/dialog.js" type="text/javascript"></SCRIPT>  
<SCRIPT language=javascript src="/common/exitFromNRI.js" type="text/javascript"></SCRIPT>  

<%--@include file="graphMenu.jspf"--%>
<TABLE class=includer border="0" cellpadding="0" cellspacing="0">
<TR>
	<TD colspan="3" width="100%" bgcolor="D6EBFF" height="43">
	<script>
	<!--
		<%	Profile profile = (Profile)request.getSession().getAttribute(Profile.PROFILE);
			String classButton = "ButtonEnabledArmed";
			String menuStatus = "0";
			if(profile != null) {
				menuStatus = profile.getSystemMenuStatus();
				if(menuStatus == null) menuStatus = "0"; 
				else if(menuStatus.equals("1")) classButton = "ButtonEnabledArmedPressed";
			}
		%>
		var stat = <%=menuStatus%>;
	
	-->
	</script>
	<table height="100%" width="100%">
		<tr>
			<td><div id="ctnrButton" class="<%=classButton%>" ><iframe id="updateMenu1" name="updateMenu1" src="" width="100%" height="100%" frameborder="0" style="display:none"></iframe></div><img src="/images/logo_beeline_security.gif" border="0" alt=""></td>
			<td width="10%" align="right"><a href="#" title="Помощь" onclick="window.open('/security.doc', '_blank', 'top=40, left=100, width=830, height=630, scrollbars=yes, resizable=yes'); return false;"><img src="/images/helph.gif" border="0" hspace="12"></a></td>
		</tr>
	</table>
	</TD>
</TR>
<TR>
	<td colspan="7" background="/images/points3.gif" height="1"><img src="/images/empty.gif" width="1" height="1" border="0" alt=""></td>
</TR>
<TR>
	<TD vAlign=top width="240" id="menuCntr">
<%
	int state = ParamsParser.getState( pageContext );
%>
	
<table width="240" height="110">
<tr class="select">
	<td class="menu" vAlign=top>
<%--
		<july:menu selectedId="0" styleId="orgmenu" height="100">
			<july:menuitem key="label.menu.organizer" action="/main.do" stateId="1">
				<july:menuitem key="label.menu.tasklist" action="/ShowTaskList.do" stateId="2" />
				<july:menuitem key="label.menu.reregister" action="/Reregister.do" stateId="3" />
				<july:menuitem key="label.menu.logout" action="/Logout.do" stateId="4" />
			</july:menuitem>
		</july:menu>
--%>
			<%--@include file="organizerTree.jspf"--%>
			<jsp:include page="menuTree.jsp" flush="true"></jsp:include>
	</td>
</tr>
</TABLE>
<%--
<table width="200" height="300">
<tr class="select">
	<td class="menu" vAlign=top>
		<july:menu selectedId="<%=state %>">
          <july:menuitem key="label.menu.root" action="main.do" stateId="<%=APPStates.MAIN %>">
                <july:menuselection stateId="<%=APPStates.MAIN %>"/>
<%
if(request.isUserInRole("administrator")) {
%>
                <july:menuitem key="label.menu.people" action="ShowPeopleList.do" stateId="<%=APPStates.PPLLIST %>">
                  <july:menuselection stateId="<%=APPStates.PPLLIST %>"/>
                  <july:menuselection stateId="<%=APPStates.EDITPPL %>"/>
                  <july:menuselection stateId="<%=APPStates.WRKLIST %>"/>
                  <july:menuselection stateId="<%=APPStates.EDITWRK %>"/>
                  <july:menuselection stateId="<%=APPStates.OPRLIST %>"/>
                  <july:menuselection stateId="<%=APPStates.EDITOPR %>"/>
                  <july:menuselection stateId="<%=APPStates.ORLLIST %>"/>
                  <july:menuselection stateId="<%=APPStates.EDITORL %>"/>
                  <july:menuselection stateId="<%=APPStates.ROLEMULTI %>"/>
                  <july:menuselection stateId="<%=APPStates.SPRREGLIST %>"/>
                  <july:menuselection stateId="<%=APPStates.REGLIST %>"/>
                  <july:menuselection stateId="<%=APPStates.ACCRIGHTCPY %>"/>
                </july:menuitem>
                <july:menuitem key="label.menu.workpositions" action="ShowWorkPositionList.do" stateId="<%=APPStates.WPOSLIST %>">
                  <july:menuselection stateId="<%=APPStates.WPOSLIST %>"/>
                  <july:menuselection stateId="<%=APPStates.EDITWPOS %>"/>
                </july:menuitem>
<%
}
if(request.isUserInRole("administrator") || request.isUserInRole("dictStaffOperator")) {
%>
                <july:menuitem key="label.menu.companies" action="ShowCompanyList.do" stateId="<%=APPStates.COMPLIST %>">
                  <july:menuselection stateId="<%=APPStates.COMPLIST %>"/>
                  <july:menuselection stateId="<%=APPStates.EDITCOMP %>"/>
                  <july:menuselection stateId="<%=APPStates.DEPLIST %>"/>
                  <july:menuselection stateId="<%=APPStates.EDITDEP %>"/>
                  <july:menuselection stateId="<%=APPStates.DIRLIST %>"/>
                  <july:menuselection stateId="<%=APPStates.EDITDIR %>"/>
                  <july:menuselection stateId="<%=APPStates.SERVLIST %>"/>
                  <july:menuselection stateId="<%=APPStates.EDITSERV %>"/>
                  <july:menuselection stateId="<%=APPStates.GRPLIST %>"/>
                  <july:menuselection stateId="<%=APPStates.EDITGRP %>"/>
                  <july:menuselection stateId="<%=APPStates.WRKLISTC %>"/>
                  <july:menuselection stateId="<%=APPStates.EDITWRKC %>"/>
                  <july:menuselection stateId="<%=APPStates.WRKLISTDR %>"/>
                  <july:menuselection stateId="<%=APPStates.EDITWRKDR %>"/>
                  <july:menuselection stateId="<%=APPStates.WRKLISTS %>"/>
                  <july:menuselection stateId="<%=APPStates.EDITWRKS %>"/>
                  <july:menuselection stateId="<%=APPStates.WRKLISTD %>"/>
                  <july:menuselection stateId="<%=APPStates.EDITWRKD %>"/>
                  <july:menuselection stateId="<%=APPStates.WRKLISTG %>"/>
                  <july:menuselection stateId="<%=APPStates.EDITWRKG %>"/>
                  <july:menuselection stateId="<%=APPStates.DIRECTION_CARS_LIST %>"/>
                  <july:menuselection stateId="<%=APPStates.DIRECTION_CAR_EDIT %>"/>
                  <july:menuselection stateId="<%=APPStates.SERVICE_CARS_LIST %>"/>
                  <july:menuselection stateId="<%=APPStates.SERVICE_CAR_EDIT %>"/>
                  <july:menuselection stateId="<%=APPStates.DEPARTMENT_CARS_LIST %>"/>
                  <july:menuselection stateId="<%=APPStates.DEPARTMENT_CAR_EDIT %>"/>
                  <july:menuselection stateId="<%=APPStates.GROUP_CARS_LIST %>"/>
                  <july:menuselection stateId="<%=APPStates.GROUP_CAR_EDIT %>"/>
                </july:menuitem>
</logic:present>
<%
}
if(request.isUserInRole("administrator") || request.isUserInRole("adminTerrabyte")) {
%>
                <july:menuitem key="label.menu.microstrategy.user" action="ShowMSUsersList.do" stateId="<%=APPStates.MSUSERS_LIST %>">
                  <july:menuselection stateId="<%=APPStates.MSUSERS_LIST %>"/>
                  <july:menuselection stateId="<%=APPStates.EDITMSU %>"/>
                </july:menuitem>
                <july:menuitem key="label.menu.operreport" action="ReportOperators.do" stateId="<%=APPStates.REPOPER %>">
                  <july:menuselection stateId="<%=APPStates.REPOPER %>"/>
	            </july:menuitem>
            <%
				String s1 = com.hps.july.util.AppUtils.getNamedValueString("TERRABYTE_PERMISSION_URL");
            %>
    	        <july:menuitem key="label.menu.tb.permission" action='<%=s1%>' stateId="-800" target="1" windowName="tb_permission">
        	        <july:menuselection stateId="-800"/>
	            </july:menuitem>
<%
}
%>
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
        </td>
</tr>
</TABLE>
--%>

</TD>
	<script>
	<!--
		var button2 = document.getElementById('ctnrButton');
		if(button2) {
			button2.onclick = function() {
				var button1 = document.getElementById('ctnrButton');
				var menuCntr = document.getElementById('menuCntr');
				var menuUpdate2 = document.getElementById('updateMenu1');
				if(button1 && menuCntr && menuUpdate2) {
					if(stat == 0) { 
						button1.className = 'ButtonEnabledArmedPressed'; 
						stat = 1; menuCntr.style.display = 'none'; 
					}
					else { 
						button1.className = 'ButtonEnabledArmed'; 
						stat = 0; menuCntr.style.display = 'block';
					}
					var url = '/organizer/updateMenu?menu_status=' + stat;
					if(menuUpdate2)	{
						menuUpdate2.src = url;
					}
					//document.frames['updateMenu1'].document.sysParams.menu_status.value = stat;
					//document.frames['updateMenu1'].document.sysParams.submit();
				}
			}
			var button1 = document.getElementById('ctnrButton');
			var menuCntr = document.getElementById('menuCntr');
			if(button1 && menuCntr) {
				if(stat == 0) { 
					button1.className = 'ButtonEnabledArmed'; 
					menuCntr.style.display = 'block'; 
				}
				else { 
					button1.className = 'ButtonEnabledArmedPressed'; 
					menuCntr.style.display = 'none';
				}
			}
			
		}
	-->
	</script>

<td style="background-image: url(/images/points_vert.gif); background-repeat: repeat-y;"><img src="/images/empty.gif" width="1" height="1" border="0" alt=""></td>

<TD vAlign=top width="100%">

<july:errors/>
<%
	//int state = ParamsParser.getState( pageContext );
	switch( state )
	{
	case APPStates.MAIN:
		%><jsp:include page="/secMain.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.LOGIN:
		%><jsp:include page="/loginForm.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.COMPLIST:
		%><jsp:include page="/companyList.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.EDITCOMP:
		%><jsp:include page="/companyForm.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.DEPLIST:
		%><jsp:include page="/departmentList.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.EDITDEP:
		%><jsp:include page="/departmentForm.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.PPLLIST:
		%><jsp:include page="/peopleList.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.EDITPPL:
		%><jsp:include page="/peopleForm.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.EDITWRK:
		%><jsp:include page="/workerForm.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.WRKLIST:
		%><jsp:include page="/workerList.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.EDITOPR:
		%><jsp:include page="/operatorForm.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.OPRLIST:
		%><jsp:include page="/operatorList.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.EDITORL:
		%><jsp:include page="/operator2roleForm.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.ORLLIST:
		%><jsp:include page="/operator2roleList.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.ACCRIGHTCPY:
		%><jsp:include page="/copyOperatorAccessForm.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.SPRREGLIST:
		%><jsp:include page="/superRegionAccessList.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.REGLIST:
		%><jsp:include page="/regionAccessList.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.ROLELIST:
		%><jsp:include page="/error.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.EDITWPOS:
		%><jsp:include page="/workPositionForm.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.WPOSLIST:
		%><jsp:include page="/workPositionList.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.COMPLOOKUP:
		%><jsp:include page="/error.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.EDITWRKC:
		%><jsp:include page="/workerForm.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.WRKLISTC:
		%><jsp:include page="/workerListC.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.DIRLIST:
		%><jsp:include page="/directionList.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.EDITDIR:
		%><jsp:include page="/directionForm.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.EDITWRKDR:
		%><jsp:include page="/workerForm.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.WRKLISTDR:
		%><jsp:include page="/workerListDr.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.SERVLIST:
		%><jsp:include page="/serviceList.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.EDITSERV:
		%><jsp:include page="/serviceForm.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.DIRLOOKUP:
		%><jsp:include page="/error.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.EDITWRKS:
		%><jsp:include page="/workerForm.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.WRKLISTS:
		%><jsp:include page="/workerListS.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.SERVLOOKUP:
		%><jsp:include page="/error.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.EDITWRKD:
		%><jsp:include page="/workerForm.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.WRKLISTD:
		%><jsp:include page="/workerListD.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.GRPLIST:
		%><jsp:include page="/groupList.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.EDITGRP:
		%><jsp:include page="/groupForm.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.DEPLOOKUP:
		%><jsp:include page="/error.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.GRPLOOKUP:
		%><jsp:include page="/error.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.EDITWRKG:
		%><jsp:include page="/workerForm.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.WRKLISTG:
		%><jsp:include page="/workerListG.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.REPOPER:
		%><jsp:include page="/operatorReport.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.ROLEMULTI:
		%><jsp:include page="/roleMultiList.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.DIRECTION_CARS_LIST:
	case APPStates.SERVICE_CARS_LIST:
	case APPStates.DEPARTMENT_CARS_LIST:
	case APPStates.GROUP_CARS_LIST:
		%><jsp:include page="/carsList.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.DIRECTION_CAR_EDIT:
	case APPStates.SERVICE_CAR_EDIT:
	case APPStates.DEPARTMENT_CAR_EDIT:
	case APPStates.GROUP_CAR_EDIT:
		%><jsp:include page="/carForm.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.MSUSERS_LIST:
		%><jsp:include page="/msUserList.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.EDITMSU:
		%><jsp:include page="/msUserForm.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.ACCESS_LIST:
		%><jsp:include page="/accessList.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.PEOPLE_TO_NFS_USER_LIST:
		%><jsp:include page="/peopleToNfsUserList.jsp" flush="true"></jsp:include><%
		break;		
	case APPStates.SWITCH_OPERATOR:	
		%><jsp:include page="/switchOperatorForm.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.MAIL_MASSAGE_NRI:	
		%><jsp:include page="/mailMessageNri.jsp" flush="true"></jsp:include><%
		break;
    case APPStates.ROLE_LIST  :
          %><jsp:include page="/roleList.jsp" flush="true"></jsp:include><%
          break;
          				
	default:
		%><jsp:include page="/error.jsp" flush="true"></jsp:include><%
		break;
	}
%>
				</TD>
			</TR>
			<tr>
				<td class="probel" colspan="7" style="height:2px;background-image:/images/points.gif" ><img src="/images/empty.gif" width="1" height="1" border="0" alt=""></td>
			</tr>
			<tr>
				<td colspan="3" align="right" class="copyright">&copy; 2002 Copyright&nbsp;&nbsp;<a href="http://www.beeline.ru" style="color:gray;" style="text-decoration:none;">BeeLine</a>&nbsp;&nbsp;</td>
			</tr>
		</TABLE>
