<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.util.*,com.hps.july.siteinfo.*"%>
<%@ page import="com.hps.july.jdbcpersistence.lib.AppConstants"%>
<%@ page import="com.hps.july.constants.Applications"%>
<%@ page import="com.hps.july.jdbcpersistence.lib.DebugSupport"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld"    prefix="alex" %>
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
			<td><div id="ctnrButton" class="<%=classButton%>" ><iframe id="updateMenu1" name="updateMenu1" src="" width="100%" height="100%" frameborder="0" style="display:none"></iframe></div><img src="/images/logo_beeline_siteinfo.gif" border="0" alt=""></td>
			<td width="10%" align="right"><a href="#" title="Title" onclick="window.open('/security.doc', '_blank', 'top=40, left=100, width=830, height=630, scrollbars=yes, resizable=yes'); return false;"><img src="/images/helph.gif" border="0" hspace="12"></a></td>
		</tr>
	</table>
	</td>
  </TR>
  <tr>
	<td colspan="7" background="/images/points3.gif" height="1"><img src="/images/empty.gif" width="1" height="1" border="0" alt=""></td>
  </tr>
  <TR>
    <TD vAlign="top" width="240" id="menuCntr">
<%
    int state = ParamsParser.getState( pageContext );
    int appHome= ParamsParser.getRootApp( pageContext ); //((Integer)session.getAttribute(AppConstants.APP_HOME)).intValue();
%>

<table width="240" height="110">
	<tr class="select">
		<td class="menu" vAlign=top>
<%--
        <july:menu selectedId="0" styleId="orgmenu" height="100">
          <july:menuitem key="label.menu.organizer" action="/main.do?navclear=1" stateId="1">
            <july:menuitem key="label.menu.tasklist" action="/ShowTaskList.do?navclear=1" stateId="2" />
            <july:menuitem key="label.menu.reregister" action="/Reregister.do?navclear=1" stateId="3" />
            <july:menuitem key="label.menu.logout" action="/Logout.do?navclear=1" stateId="4" />
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
<%if(appHome==Applications.BASESTATION){%>
	 <jsp:include page="menu/basestationMenu.jsp" flush="true"/>
<%}else{%>
	<jsp:include page="siteinfoMenu.jsp" flush="true"/>
<%}%>
        </td>
</tr>
</table>
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
  <TABLE class="main" border="0" cellpadding="0" cellspacing="0" vAlign=top height="100%">
    <TR class="title" style="height:15"><TD class="title"><july:statenavigator/></TD></TR>
		<july:errors property="org.apache.struts.action.GLOBAL_ERROR"/>
		<july:errors property="org.apache.struts.action.GLOBAL_WARNING" color = "blue" headerKey="warning.header" footerKey="warning.footer"/>
	<TR><TD vAlign=top width="100%">

<%
	//int state = ParamsParser.getState( pageContext );
	switch( state ) {
	case APPStates.MAIN:
		%><jsp:include page="/siteinfoMain.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.LOGIN:
		%><jsp:include page="/loginForm.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.TRSPLIST:
		%><jsp:include page="/typeresponsibilityList.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.EDITTRSP:
		%><jsp:include page="/typeresponsibilityForm.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.NZONELIST:
		%><jsp:include page="/netzoneList.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.EDITNZONE:
		%><jsp:include page="/netzoneForm.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.POSLIST:
		%><jsp:include page="/positionList.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.VIEWPOS:
		%><jsp:include page="/positionForm.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.EDITPOS:
		%><jsp:include page="/positionForm.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.EDITPOSMAP:
		%><jsp:include page="/positionForm.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.EDITEPOS:
		%><jsp:include page="/epositionForm.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.WRSPLIST:
		%><jsp:include page="/workresponsibilityList.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.EDITWRSP:
		%><jsp:include page="/workresponsibilityForm.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.CLNLIST:
		%><jsp:include page="/comlineList.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.EDITCLN:
		%><jsp:include page="/comlineForm.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.PHTLIST:
		%><jsp:include page="/photoList.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.EDITPHT:
		%><jsp:include page="/photoForm.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.EQULIST:
		%><jsp:include page="/equipmentList.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.BEENETLIST:
		%><jsp:include page="/beenetList.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.EDITBEENET:
		%><jsp:include page="/beenetForm.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.EDITEQU:
		%><jsp:include page="/equipmentForm.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.MAPINFO:
		%><jsp:include page="/positionListMap.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.POSITIONSONMAP:
		%><jsp:include page="/positionOnmap.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.EQDETLIST:
		%><jsp:include page="/equipdetList.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.EQDETMLIST:
		%><jsp:include page="/equipdetMultiList.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.EQSDETLIST:
		%><jsp:include page="/equipsdetList.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.SREGIONLIST:
		%><jsp:include page="/superRegionList.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.SREGIONEDIT:
		%><jsp:include page="/superRegionForm.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.REGIONLIST:
		%><jsp:include page="/regionList.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.REGIONEDIT:
		%><jsp:include page="/regionForm.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.SiteDocTypeListForm:
		%><jsp:include page="/siteDocTypeList.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.SiteDocTypeForm:
		%><jsp:include page="/siteDocTypeForm.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.BUILDLISTPASS:
		%><jsp:include page="/buildListPassWord.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.OPORAPLACESLIST:
		%><jsp:include page="/oporaplacesList.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.ANTENNAPLACESLIST:
		%><jsp:include page="/antennaplacesList.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.APPARATPLACESLIST:
		%><jsp:include page="/apparatplacesList.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.APPARATTYPESLIST:
		%><jsp:include page="/apparattypesList.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.APPARATPLACETYPESLIST:
		%><jsp:include page="/applacestypesList.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.EDITANTENNAPLACE:
		%><jsp:include page="/antennaplacesForm.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.EDITAPPARATPLACE:
		%><jsp:include page="/apparatplacesForm.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.EDITAPPARATTYPE:
		%><jsp:include page="/apparattypesForm.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.EDITAPPARATPLACETYPE:
		%><jsp:include page="/applacestypesForm.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.EDITOPORAPLACE:
		%><jsp:include page="/oporaplacesForm.jsp" flush="true"></jsp:include><%
		break;
	case com.hps.july.siteinfo.APPStates.ELECTTRO_COUNTER_LIST:
		%><jsp:include page="/ElectroCounterList.jsp" flush="true"></jsp:include><%
		break;
	case com.hps.july.siteinfo.APPStates.ELECTTRO_COUNTER_EDIT:
		%><jsp:include page="/ElectroCounterForm.jsp" flush="true"></jsp:include><%
		break;
	case com.hps.july.siteinfo.APPStates.ELECTRO_COUNTER_INFO_LIST:
		%><jsp:include page="/ElectroCounterInfoList.jsp" flush="true"></jsp:include><%
		break;
	case com.hps.july.siteinfo.APPStates.ELECTRO_COUNTER_INFO_EDIT:
		%><jsp:include page="/ElectroCounterInfoForm.jsp" flush="true"></jsp:include><%
		break;
	default:
		%><jsp:include page="/error.jsp" flush="true"></jsp:include><%
		break;
	}
%>
						</TD>
					</TR>
					<tr class="title" style="height:15"><td class="title"><july:statenavigator/></td></tr>
					</table>

			  </TD>
			</TR>
			<tr>
				<td class="probel" colspan="7" style="height:2px;background-image:/images/points.gif" ><img src="/images/empty.gif" width="1" height="1" border="0" alt=""></td>
  			</tr>
		  	<tr>
		  		<td colspan="3" align="right" class="copyright">&copy; 2002 Copyright&nbsp;&nbsp;<a href="http://www.beeline.ru" style="color:gray;" style="text-decoration:none;">BeeLine</a>&nbsp;&nbsp;</td>
			</tr>
		  </TABLE>

