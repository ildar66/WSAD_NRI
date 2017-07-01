<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld"    prefix="alex" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.basestation.*" %>
<%@ page import="com.hps.july.jdbcpersistence.lib.AppConstants" %>
<%@ page import="com.hps.july.constants.Applications,com.hps.july.jdbcpersistence.lib.*" %>
<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %> 
<SCRIPT language=javascript src="/common/dialog.js" type="text/javascript"></SCRIPT>  
<SCRIPT language=javascript src="/common/exitFromNRI.js" type="text/javascript"></SCRIPT>  

<%--@include file="graphMenu.jspf"--%>
<% // DD inserted
	int state = ParamsParser.getState( pageContext );
	int appHome= ParamsParser.getRootApp(pageContext); 
	int rootState=ParamsParser.getRootState(pageContext);

	String imgscr="";
	DebugSupport.printlnTest("baseStation.jsp appHome="+appHome);

	if(appHome==Applications.SITEINFO){
		imgscr="/images/logo_beeline_siteinfo.gif";
	}else{
		imgscr="/images/logo_beeline_basestation.gif";
	}
%>

<table class=includer border="0" cellpadding="0" cellspacing="0">
<tr>
	<td colspan="3" width="100%" bgcolor="D6EBFF" height="43">
	<script>
	<!--
		<%	Profile profile = (Profile)request.getSession().getAttribute(Profile.PROFILE);
			String classButton = "ButtonEnabledArmed";
			String menuStatus = "0";
			String menuItem = request.getParameter(Profile.MENU_ITEM);
			if(profile != null) {
				if(menuItem == null || menuItem.length() == 0) menuItem = profile.getSystemMenuItem();
				menuStatus = profile.getSystemMenuStatus();
				if(menuStatus == null) menuStatus = "0"; 
				else if(menuStatus.equals("1")) classButton = "ButtonEnabledArmedPressed";
			}
			if(menuItem == null) menuItem = "";
		%>
		var stat = <%=menuStatus%>;
	
	-->
	</script>
		<table height="100%" width="100%">
		<tr>
			<td><div id="ctnrButton" class="<%=classButton%>"><iframe id="updateMenu1" name="updateMenu1" src="" width="100%" height="100%" frameborder="0" style="display:none"></iframe></div><img src="<%=imgscr%>" border="0" alt=""></td>
			<td width="10%" align="right"><a href="#" title="Помощь" onclick="window.open('/equipinfo.doc', '_blank', 'top=40, left=100, width=830, height=630, scrollbars=yes, resizable=yes'); return false;"><img src="/images/helph.gif" border="0" hspace="12"></a></td>
		</tr>
		</table>
	</td>
</tr>
<tr>
	<td colspan="7" background="/images/points3.gif" height="1"><img src="/images/empty.gif" width="1" height="1" border="0" alt=""></td>
</tr>
<tr>
	<TD vAlign=top width="240px" id="menuCntr">
			<table height="100%" width="240px" style="padding:0px;margin:0px;">
				<tr class="select">
					<td class="menu" vAlign=top>
							<script>
							<!--
							   function openInLocalWin(href) {
							        if(href && href != '') document.location = href;
							    }
							
							    function openWind(url, urlOld, windowName)	{
							      var wnd = window.open(url +'&path='+urlOld, windowName ,
							      'top=0, left=0, height=' + (screen.availHeight-30) + ', width=' + (screen.availWidth-10) + ', fullscreen=no,location=no,menubar=no,resizable=yes,scrollbars=yes,status=yes,titlebar=yes,toolbar=no');
							       //закрытие дочерних окон:
							       try { dialogArrayExit[dialogArrayExit.length]=wnd; } catch(e) {}
							       wnd.focus();
							    }
							-->
							</script>
							<iframe id="menuFrm" name="menuFrm" scrolling="scroll" frameborder="0" src="http://<%=request.getServerName()%>:<%=request.getServerPort()%>/july-menu-web/showXTreeMenuIFrame.do?user=<%=request.getRemoteUser()%>&menuItem=<%=menuItem%>" style="width:240px; height:620px; padding:0px;margin:0px;"></iframe>
							<%-- <jsp:include page="menuTree.jsp" flush="true"></jsp:include> --%>
			        </td>
			    </tr>
			</table>
<%--
			<%@include file="baseStationMenu.jsp"%>
--%>
	</td>
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
	<july:errors/>
	<TR><TD vAlign=top width="100%">

<%
	//int state = ParamsParser.getState( pageContext );
	switch( state )
	{
	case APPStates.MAIN:
		%><jsp:include page="/baseStationMain.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.LOGIN:
		%><jsp:include page="/loginForm.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.BS_LIST:
		%><jsp:include page="/baseStationList.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.BS_FEdit:
		%><jsp:include page="/factBaseStationForm.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.BS_PEdit:
		%><jsp:include page="/planBaseStationForm.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.BS_FVIEW:
		%><jsp:include page="/factBaseStationForm.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.BS_PVIEW:
		%><jsp:include page="/planBaseStationForm.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.POSITIONSONMAP:
		%><jsp:include page="/positionOnmap.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.SECT_EDIT:
		%><jsp:include page="/sectorForm.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.SECT_COPY:
		%><jsp:include page="/sectorForm.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.ANT_EDIT:
		%><jsp:include page="/antennaForm.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.ANT_COPY:
		%><jsp:include page="/antennaForm.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.BS_EQ_LIST:
		%><jsp:include page="/antennaSectorList.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.EQULIST:
		%><jsp:include page="/posEquipmentList.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.EQDETLIST:
		%><jsp:include page="/equipdetList.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.ANTENNES_CHOICE:
		%><jsp:include page="/antennaChoiceList.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.EQSDETLIST:
		%><jsp:include page="/equipsdetList.jsp" flush="true"></jsp:include><%
		break;
//////////////////
	case APPStates.IMPORTXLS_BS:
		%><jsp:include page="/xlsBsForm.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.IMPORTXLS:
		%><jsp:include page="/xlsForm.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.IMPORTXLSSTEP2:
		%><jsp:include page="/xlsFormStep2.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.XLSLOADRESULT:
		%><jsp:include page="/xlsMinReport.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.XLSLOADEXTENDEDRESULT:
		%><jsp:include page="/xlsMaxReport.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.XLSLOADJOURNAL:
		%><jsp:include page="/xlsJournal.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.VIEWCHANALPOWERS:
		%><jsp:include page="/chanalPower.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.LOADRESULTS:
		%><jsp:include page="/xlsMaxReport.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.SwitchListForm:
		%><jsp:include page="/switchList.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.SwitchForm:
		%><jsp:include page="/switchForm.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.ComlineListForm:
		%><jsp:include page="/comlineList.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.ComlinePositionListForm:
		%><jsp:include page="/comlinePositionList.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.ComlineRForm:
		%><jsp:include page="/comlineForm.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.SWCH_EDIT:
	case APPStates.SWCH_VIEW:
		%><jsp:include page="/switchDescForm.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.SWCH_PARAMS_EDIT:
		%><jsp:include page="/switchParamsForm.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.SWCH_CONNECTED_CONTR:
		%><jsp:include page="/controllerList.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.CONTROLLER_LIST:
		%><jsp:include page="/controllerList.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.CONTROLLER_EDIT:
		%><jsp:include page="/controllerForm.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.SwitchControllerForm:
		%><jsp:include page="/controllerForm.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.CONTROLLER_DESC_EDIT:
	case APPStates.CONTROLLER_DESC_VIEW:
		%><jsp:include page="/controllerDescForm.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.CONTROLLER_PARAMS:
		%><jsp:include page="/controllerParamsForm.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.CONTROLLER_CONNECTED_BS:
		%><jsp:include page="/controllerBaseStationsList.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.REPEATER_LIST:
		%><jsp:include page="/repeaterList.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.FROMSECTOR_REPEATER_LIST:
		%><jsp:include page="/repeaterFromSectorList.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.REPEATER_EDIT:
	case APPStates.FROMSECTOR_REPEATER_EDIT:
		%><jsp:include page="/repeaterForm.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.REPEATER_ANTENNA_EDIT:
	case APPStates.FROMSECTOR_REPEATER_ANTENNA_EDIT:
		%><jsp:include page="/repeaterForm/antennaForm.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.GKRCH_LIST:
		%><jsp:include page="/gkrchList.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.GKRCH_FORM:
		%><jsp:include page="/gkrchForm.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.GKRCH_FILE:
		%><jsp:include page="/gkrchFileForm.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.RRL_LIST:
		%><jsp:include page="/rrlList.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.RRL_FORM:
		%><jsp:include page="/rrlForm.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.SITEDOC_FILE:
		%><jsp:include page="/sitedocFileForm.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.ETAPTYPE_LIST:
		%><jsp:include page="/etaptypeList.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.ETAPTYPE_FORM:
		%><jsp:include page="/etaptypeForm.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.FREQLICENCE_LIST:
		%><jsp:include page="/freqlicenceList.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.FREQLICENCE_FORM:
		%><jsp:include page="/freqlicenceForm.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.FREQLICENCE_HIST:
		%><jsp:include page="/freqlicenceHistoryList.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.FREQLICENCE_POS_LIST:
		%><jsp:include page="/freqlicencePositionsList.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.ETAP_FORM:
		%><jsp:include page="/etapForm.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.DOCFILES_LIST:
		%><jsp:include page="/docfilesList.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.REPORT_HAVEPLAN_LOOKUP:
		%><jsp:include page="/reportFinderForm.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.REPORT_HAVEPLAN_SHOW:
		%><jsp:include page="/reportHavePlanShow.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.SFO_PROTOCOL:
		%><jsp:include page="/reportProtocolSfoEntry.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.EXPORTFILE:
		%><jsp:include page="/exportFileParams.jsp" flush="true"></jsp:include><%
		break;
//////////////////
	default:
		%><jsp:include page="/error.jsp" flush="true"></jsp:include><%
		break;
	}
%>
						</TD>
					</TR>
					<tr class="title" style="height:15"><td class="title"><july:statenavigator/></td></tr>
					</table>
	</td>
</tr>
<tr>
	<td class="probel" colspan="3" style="height:2px;background-image:/images/points.gif" ><img src="/images/empty.gif" width="1" height="1" border="0" alt=""></td>
</tr>
<tr>
	<td colspan="3" align="right" class="copyright">&copy; 2003 Copyright&nbsp;&nbsp;<a href="http://www.beeline.ru" style="color:gray;" style="text-decoration:none;">BeeLine</a>&nbsp;&nbsp;</td>
</tr>
</table>
