<%@ page language = "java" %>
<%@ page contentType = "text/html;charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.inventory.*, com.hps.july.constants.*" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
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
<%
	int state = ParamsParser.getState( pageContext );
	int happ = ParamsParser.getApplication(pageContext);
	int hstate = ParamsParser.getState(pageContext);
	String helpFile = "window.open('" + com.hps.july.util.AppUtils.getHelpFileName(happ, hstate) + "', '_blank', 'top=40, left=100, width=830, height=630, scrollbars=yes, resizable=yes'); return false;";
%>
	<table height="100%" width="100%">
		<tr>
			<td><div id="ctnrButton" class="<%=classButton%>"><iframe id="updateMenu1" name="updateMenu1" src="" width="100%" height="100%" frameborder="0" style="display:none"></iframe></div><img src="/images/logo_beeline_resurs.gif" border="0" alt=""></td>
			<td width="10%" align="right"><a href="#" title="Помощь" onclick="<%= helpFile %>"><img src="/images/helph.gif" border="0" hspace="12"></a></td>
		</tr>
	</table>
	
	
	</td>
  </TR>
  <tr>
	<td colspan="7" background="/images/points3.gif" height="1"><img src="/images/empty.gif" width="1" height="1" border="0" alt=""></td>
  </tr>
  <TR>
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
	<july:errors property="<%= org.apache.struts.action.ActionErrors.GLOBAL_ERROR %>"/>
	<TR><TD vAlign=top width="100%">

	<%
	//int state = ParamsParser.getState( pageContext );
	switch( state )
		{
	case APPStates.MAIN:
			%>
	<jsp:include page="/invMain.jsp" flush="true"></jsp:include>
			<%
			break;
	case APPStates.LOGIN:
			%>
	<jsp:include page="/loginForm.jsp" flush="true"></jsp:include>
			<%
			break;
	case APPStates.LOGOUT:
			%>
	<jsp:include page="/logoutForm.jsp" flush="true"></jsp:include>
			<%
			break;

	case APPStates.MOUNTEDIT2:
			%>
	<jsp:include page="/mountact2Form.jsp" flush="true"></jsp:include>
			<%
			break;
	case APPStates.MOUNT_ACT2_FORM:
		%>
		<jsp:include page="/mountact2Form2.jsp" flush="true"></jsp:include>
		<%
		break;
	case APPStates.MOUNTEDIT3:
			%>
	<jsp:include page="/mountact3Form.jsp" flush="true"></jsp:include>
			<%
			break;
	case APPStates.AFSEDIT21:
	case APPStates.AFSEDIT22:
			%>
	<jsp:include page="/afsMountact2Form.jsp" flush="true"></jsp:include>
			<%
			break;
	case APPStates.AFSINDOOR:
			%>
	<jsp:include page="/afsIndoorMountactForm.jsp" flush="true"></jsp:include>
			<%
			break;

/* Bar codes */
	case APPStates.BARLIST:
			%>
	<jsp:include page="/barList.jsp" flush="true"></jsp:include>
			<%
			break;
	case APPStates.EDITBAR:
			%>
	<jsp:include page="/barForm.jsp" flush="true"></jsp:include>
			<%
			break;
	case APPStates.SERPARAMS:
          %>
          <jsp:include page="/barSReportParams.jsp" flush="true"></jsp:include>
          <%
          break;
	case APPStates.SERPRINT:
          %>
          <jsp:include page="/barSReportForm.jsp" flush="true"></jsp:include>
          <%
          break;

/* Internal Orders */
	case APPStates.IOLIST:
			%>
	<jsp:include page="/internalList.jsp" flush="true"></jsp:include>
			<%
			break;
	case APPStates.EDITIO:
			%>
	<jsp:include page="/internalForm.jsp" flush="true"></jsp:include>
			<%
			break;
	case APPStates.EDITIOST:
			%>
	<jsp:include page="/internalStateForm.jsp" flush="true"></jsp:include>
			<%
			break;
	case APPStates.IODLIST:
			%>
	<jsp:include page="/internalDocumentList.jsp" flush="true"></jsp:include>
			<%
			break;
    case APPStates.EDITIOD:
			%>
    <jsp:include page="/internalDocumentForm.jsp" flush="true"></jsp:include>
			<%
			break;
    case APPStates.IOPLIST:
			%>
    <jsp:include page="/internalPositionList.jsp" flush="true"></jsp:include>
			<%
			break;
    case APPStates.EDITIOP:
			%>
    <jsp:include page="/internalPositionForm.jsp" flush="true"></jsp:include>
			<%
			break;

/* Internal Outcome Orders */
	case APPStates.IORLIST:
			%>
	<jsp:include page="/internalRList.jsp" flush="true"></jsp:include>
			<%
			break;
	case APPStates.EDITIOR:
			%>
	<jsp:include page="/internalRForm.jsp" flush="true"></jsp:include>
			<%
			break;
	case APPStates.EDITIORST:
			%>
	<jsp:include page="/internalRStateForm.jsp" flush="true"></jsp:include>
			<%
			break;
    case APPStates.IORPLIST:
			%>
    <jsp:include page="/internalRPositionList.jsp" flush="true"></jsp:include>
			<%
			break;
    case APPStates.EDITIORP:
			%>
    <jsp:include page="/internalRPositionForm.jsp" flush="true"></jsp:include>
			<%
			break;

/* External Orders */
    case APPStates.EOLIST:
			%>
    <jsp:include page="/externalList.jsp" flush="true"></jsp:include>
			<%
			break;
    case APPStates.EDITEO:
			%>
    <jsp:include page="/externalForm.jsp" flush="true"></jsp:include>
			<%
			break;
    case APPStates.EDITEOST:
			%>
    <jsp:include page="/externalStateForm.jsp" flush="true"></jsp:include>
			<%
			break;
    case APPStates.EOPLIST:
			%>
    <jsp:include page="/externalPositionList.jsp" flush="true"></jsp:include>
			<%
			break;
    case APPStates.EDITEOP:
			%>
    <jsp:include page="/externalPositionForm.jsp" flush="true"></jsp:include>
			<%
			break;
    case APPStates.EOSLIST:
			%>
    <jsp:include page="/externalSerialList.jsp" flush="true"></jsp:include>
			<%
			break;
    case APPStates.EDITEOS:
			%>
    <jsp:include page="/externalSerialForm.jsp" flush="true"></jsp:include>
			<%
			break;
    case APPStates.EDITEOM:
			%>
    <jsp:include page="/mismatchForm.jsp" flush="true"></jsp:include>
			<%
			break;

/* External Outcome Orders */
    case APPStates.EORLIST:
			%>
    <jsp:include page="/externalRList.jsp" flush="true"></jsp:include>
			<%
			break;
    case APPStates.EDITEOR:
			%>
    <jsp:include page="/externalRForm.jsp" flush="true"></jsp:include>
			<%
			break;
    case APPStates.EDITEORST:
			%>
    <jsp:include page="/externalRStateForm.jsp" flush="true"></jsp:include>
			<%
			break;
    case APPStates.EORPLIST:
			%>
    <jsp:include page="/externalRPositionList.jsp" flush="true"></jsp:include>
			<%
			break;
    case APPStates.EDITEORP:
			%>
    <jsp:include page="/externalRPositionForm.jsp" flush="true"></jsp:include>
			<%
			break;

/* Mismatch Acts */
    case APPStates.MISLIST:
			%>
    <jsp:include page="/mismatchList.jsp" flush="true"></jsp:include>
			<%
			break;
    case APPStates.EDITMIS:
			%>
    <jsp:include page="/mismatchForm.jsp" flush="true"></jsp:include>
			<%
			break;

/* Worker Inventory Acts */
    case APPStates.WRKINVLIST:
			%>
    <jsp:include page="/WorkerInvActList.jsp" flush="true"></jsp:include>
			<%
			break;
    case APPStates.WRKINVFORM:
			%>
    <jsp:include page="/WorkerInvActForm.jsp" flush="true"></jsp:include>
			<%
			break;
    case APPStates.WRKINVPOS:
			%>
    <jsp:include page="/WorkerInvActPosForm.jsp" flush="true"></jsp:include>
			<%
			break;
    case APPStates.WRKINVFILLDB:
			%>
    <jsp:include page="/WorkerInvActFillFromDB.jsp" flush="true"></jsp:include>
			<%
			break;

/* Inventory Acts */
    case APPStates.IVALIST:
			%>
    <jsp:include page="/invActList.jsp" flush="true"></jsp:include>
			<%
			break;
    case APPStates.EDITIVA:
			%>
    <jsp:include page="/invActForm.jsp" flush="true"></jsp:include>
			<%
			break;
    case APPStates.EDITIVAS:
			%>
    <jsp:include page="/invActStateForm.jsp" flush="true"></jsp:include>
			<%
			break;
    case APPStates.IVAPLIST:
			%>
    <jsp:include page="/invActPosList.jsp" flush="true"></jsp:include>
			<%
			break;
    case APPStates.EDITIVAP:
			%>
    <jsp:include page="/invActPosForm.jsp" flush="true"></jsp:include>
			<%
			break;

/* Inventory Acts (Positions) */
	case APPStates.INVLIST:
			%><%--jsp:include page="/invList.jsp" flush="true"></jsp:include--%><%
			%><jsp:include page="/positionInventoryList.jsp" flush="true"></jsp:include><%
			break;
	case APPStates.CONTRLIST:
			%>
			<jsp:include page="/contractorInventoryList.jsp" flush="true"></jsp:include><%
			break;
	case APPStates.EDITCONTR:
			%>
			<jsp:include page="/contractorInventory.jsp" flush="true"></jsp:include><%
			break;
	case APPStates.CONTRLOADXLS:
			%>
			<jsp:include page="/contractorLoadExcel.jsp" flush="true"></jsp:include><%
			break;
	case APPStates.EDITINV:
			%><%--jsp:include page="/invForm.jsp" flush="true"></jsp:include--%><%
			%><jsp:include page="/positionInventory.jsp" flush="true"></jsp:include><%
			break;
	case APPStates.EDITINVS:
			%><jsp:include page="/invStateForm.jsp" flush="true"></jsp:include><%
			break;
	case APPStates.INVPLIST:
			%><jsp:include page="/invPosList.jsp" flush="true"></jsp:include><%
			break;
	case APPStates.EDITINVP:
			%><%--jsp:include page="/invPosForm.jsp" flush="true"></jsp:include--%><%
			%><jsp:include page="/positionInventoryItem.jsp" flush="true"></jsp:include><%
			break;
	case APPStates.IRSLIST:
	case APPStates.IRASLIST:
			%><jsp:include page="/i13nressetList.jsp" flush="true"></jsp:include><%
			break;
	case APPStates.EDITIRS:
	case APPStates.EDITIRAS:
			%><jsp:include page="/i13nressetForm.jsp" flush="true"></jsp:include><%
			break;

/* Assembling acts */
    case APPStates.ASSLIST:
			%>
    <jsp:include page="/assactList.jsp" flush="true"></jsp:include>
			<%
			break;
    case APPStates.EDITASS:
			%>
    <jsp:include page="/assactForm.jsp" flush="true"></jsp:include>
			<%
			break;
    case APPStates.EDITASSST:
			%>
    <jsp:include page="/assactStateForm.jsp" flush="true"></jsp:include>
			<%
			break;
    case APPStates.ASSPLIST:
			%>
    <jsp:include page="/assactposList.jsp" flush="true"></jsp:include>
			<%
			break;
    case APPStates.EDITASSP:
			%>
    <jsp:include page="/assactposForm.jsp" flush="true"></jsp:include>
			<%
			break;
    case APPStates.DASSLIST:
			%>
    <jsp:include page="/dassactList.jsp" flush="true"></jsp:include>
			<%
			break;
    case APPStates.EDITDASS:
			%>
    <jsp:include page="/dassactForm.jsp" flush="true"></jsp:include>
			<%
			break;
    case APPStates.EDITDASSST:
			%>
    <jsp:include page="/dassactStateForm.jsp" flush="true"></jsp:include>
			<%
			break;
    case APPStates.DASSPLIST:
			%>
    <jsp:include page="/dassactposList.jsp" flush="true"></jsp:include>
			<%
			break;
    case APPStates.EDITDASSP:
			%>
    <jsp:include page="/dassactposForm.jsp" flush="true"></jsp:include>
			<%
			break;

/* Change Acts on Expedition */
    case APPStates.CHELIST:
			%>
    <jsp:include page="/changeEList.jsp" flush="true"></jsp:include>
			<%
			break;
    case APPStates.EDITCHE:
			%>
    <jsp:include page="/changeEForm.jsp" flush="true"></jsp:include>
			<%
			break;
    case APPStates.EDITCHEST:
			%>
    <jsp:include page="/changeEStateForm.jsp" flush="true"></jsp:include>
			<%
			break;
    case APPStates.CHEPLIST:
			%>
    <jsp:include page="/changeEPositionList.jsp" flush="true"></jsp:include>
			<%
			break;
    case APPStates.EDITCHEP:
			%>
    <jsp:include page="/changeEPositionForm.jsp" flush="true"></jsp:include>
			<%
			break;

/* Change Acts on Position */
    case APPStates.CHPLIST:
			%>
    <jsp:include page="/changePList.jsp" flush="true"></jsp:include>
			<%
			break;
    case APPStates.EDITCHP:
			%>
    <jsp:include page="/changePForm.jsp" flush="true"></jsp:include>
			<%
			break;
    case APPStates.EDITCHPST:
			%>
    <jsp:include page="/changePStateForm.jsp" flush="true"></jsp:include>
			<%
			break;
    case APPStates.CHPPLIST:
			%>
    <jsp:include page="/changePPositionList.jsp" flush="true"></jsp:include>
			<%
			break;
    case APPStates.EDITCHPP:
			%>
    <jsp:include page="/changePPositionForm.jsp" flush="true"></jsp:include>
			<%
			break;

/* Change Acts on Storage */
    case APPStates.CHSLIST:
			%>
    <jsp:include page="/changeSList.jsp" flush="true"></jsp:include>
			<%
			break;
    case APPStates.EDITCHS:
			%>
    <jsp:include page="/changeSForm.jsp" flush="true"></jsp:include>
			<%
			break;
    case APPStates.EDITCHSST:
			%>
    <jsp:include page="/changeSStateForm.jsp" flush="true"></jsp:include>
			<%
			break;
    case APPStates.CHSPLIST:
			%>
    <jsp:include page="/changeSPositionList.jsp" flush="true"></jsp:include>
			<%
			break;
    case APPStates.EDITCHSP:
			%>
    <jsp:include page="/changeSPositionForm.jsp" flush="true"></jsp:include>
			<%
			break;

/* Assembling Acts on Position */
    case APPStates.ASPLIST:
			%>
    <jsp:include page="/assemblingpList.jsp" flush="true"></jsp:include>
			<%
			break;
    case APPStates.EDITASP:
			%>
    <jsp:include page="/assemblingpForm.jsp" flush="true"></jsp:include>
			<%
			break;
    case APPStates.EDITASPST:
			%>
    <jsp:include page="/assemblingpStateForm.jsp" flush="true"></jsp:include>
			<%
			break;
    case APPStates.ASPPLIST:
			%>
    <jsp:include page="/assemblingpPositionList.jsp" flush="true"></jsp:include>
			<%
			break;
    case APPStates.EDITASPP:
			%><jsp:include page="/assemblingpPositionForm.jsp" flush="true"></jsp:include><%
			break;
    case APPStates.EDITASPPU:
			%><jsp:include page="/assemblingpPositionUPSForm.jsp" flush="true"></jsp:include><%
			break;
	case APPStates.ASPLOADXLS:
			%><jsp:include page="/assemblingpLoadExcel.jsp" flush="true"></jsp:include><%
			break;

/* Dismantling Acts on Position */
    case APPStates.DIPLIST:
			%>
    <jsp:include page="/demountList.jsp" flush="true"></jsp:include>
			<%
			break;
    case APPStates.EDITDIP:
			%>
    <jsp:include page="/demount.jsp" flush="true"></jsp:include>
			<%
			break;
    case APPStates.EDITDIPST:
			%>
    <jsp:include page="/demountState.jsp" flush="true"></jsp:include>
			<%
			break;
    case APPStates.EDITDIPP:
			%>
    <jsp:include page="/demountItem.jsp" flush="true"></jsp:include>
			<%
			break;
	case APPStates.DISM_FFDB:
			%>
    <jsp:include page="/demountFFDB.jsp" flush="true"></jsp:include>
			<%
			break;

/* Block Assembling Acts on Position */
	case APPStates.ASSBLIST:
			%>
    <jsp:include page="/assactBList.jsp" flush="true"></jsp:include>
			<%
			break;
	case APPStates.EDITASSB:
			%>
    <jsp:include page="/assactBForm.jsp" flush="true"></jsp:include>
			<%
			break;
	case APPStates.EDITASSBST:
			%>
    <jsp:include page="/assactBStateForm.jsp" flush="true"></jsp:include>
			<%
			break;
    case APPStates.ASSBPLIST:
			%>
    <jsp:include page="/assactposBList.jsp" flush="true"></jsp:include>
			<%
			break;
    case APPStates.EDITASSBP:
			%>
    <jsp:include page="/assactposBForm.jsp" flush="true"></jsp:include>
			<%
			break;

/* Block Dismantling Acts on Position */
	case APPStates.DASSBLIST:
			%>
    <jsp:include page="/dassactBList.jsp" flush="true"></jsp:include>
			<%
			break;
	case APPStates.EDITDASSB:
			%>
    <jsp:include page="/dassactBForm.jsp" flush="true"></jsp:include>
			<%
			break;
	case APPStates.EDITDASSBST:
			%>
    <jsp:include page="/dassactBStateForm.jsp" flush="true"></jsp:include>
			<%
			break;
    case APPStates.DASSBPLIST:
			%>
    <jsp:include page="/dassactposBList.jsp" flush="true"></jsp:include>
			<%
			break;
    case APPStates.EDITDASSBP:
			%>
    <jsp:include page="/dassactposBForm.jsp" flush="true"></jsp:include>
			<%
			break;

/* Payoff Acts */
	case APPStates.POLIST:
			%>
    <jsp:include page="/payoffList.jsp" flush="true"></jsp:include>
			<%
			break;
	case APPStates.EDITPO:
			%>
    <jsp:include page="/payoffForm.jsp" flush="true"></jsp:include>
			<%
			break;
	case APPStates.EDITPOST:
			%>
    <jsp:include page="/payoffStateForm.jsp" flush="true"></jsp:include>
			<%
			break;
    case APPStates.POPLIST:
			%>
    <jsp:include page="/payoffPositionList.jsp" flush="true"></jsp:include>
			<%
			break;
    case APPStates.EDITPOP:
			%>
    <jsp:include page="/payoffPositionForm.jsp" flush="true"></jsp:include>
			<%
			break;

/* Request Acts */
	case APPStates.REQLIST:
			%>
    <jsp:include page="/reqList.jsp" flush="true"></jsp:include>
			<%
			break;
	case APPStates.EDITREQ:
			%>
    <jsp:include page="/reqForm.jsp" flush="true"></jsp:include>
			<%
			break;
	case APPStates.EDITREQST:
			%>
    <jsp:include page="/reqStateForm.jsp" flush="true"></jsp:include>
			<%
			break;
	case APPStates.REQPLIST:
			%>
    <jsp:include page="/reqPositionList.jsp" flush="true"></jsp:include>
			<%
			break;
	case APPStates.EDITREQP:
			%>
    <jsp:include page="/reqPositionForm.jsp" flush="true"></jsp:include>
			<%
			break;

/* Fault Report */
	case APPStates.FLTLIST:
			%>
    <jsp:include page="/faultList.jsp" flush="true"></jsp:include>
			<%
			break;
	case APPStates.EDITFLT:
			%>
    <jsp:include page="/faultForm.jsp" flush="true"></jsp:include>
			<%
			break;
	case APPStates.EDITFLTST:
			%>
    <jsp:include page="/faultStateForm.jsp" flush="true"></jsp:include>
			<%
			break;

/* Reports */
	case APPStates.RPT1PARAMS:
			%>
    <jsp:include page="/report1Params.jsp" flush="true"></jsp:include>
			<%
			break;
	case APPStates.RPT1:
			%>
    <jsp:include page="/report1Form.jsp" flush="true"></jsp:include>
			<%
			break;
	case APPStates.RPT2PARAMS:
			%>
    <jsp:include page="/report2Params.jsp" flush="true"></jsp:include>
			<%
			break;
	case APPStates.RPT2:
			%>
    <jsp:include page="/report2Form.jsp" flush="true"></jsp:include>
			<%
			break;
	case APPStates.RPT3PARAMS:
			%>
    <jsp:include page="/report3Params.jsp" flush="true"></jsp:include>
			<%
			break;
	case APPStates.RPT3:
			%>
    <jsp:include page="/report3Form.jsp" flush="true"></jsp:include>
			<%
			break;
	case APPStates.RPT4PARAMS:
			%>
    <jsp:include page="/report4Params.jsp" flush="true"></jsp:include>
			<%
			break;
	case APPStates.RPT4:
			%>
    <jsp:include page="/report4Form.jsp" flush="true"></jsp:include>
			<%
			break;
	case APPStates.RPT5PARAMS:
			%>
    <jsp:include page="/report5Params.jsp" flush="true"></jsp:include>
			<%
			break;
	case APPStates.RPT5:
			%>
    <jsp:include page="/report5Form.jsp" flush="true"></jsp:include>
			<%
			break;
	case APPStates.RPT6PARAMS:
			%>
    <jsp:include page="/report6Params.jsp" flush="true"></jsp:include>
			<%
			break;
	case APPStates.RPT6:
			%>
    <jsp:include page="/report6Form.jsp" flush="true"></jsp:include>
			<%
			break;
	case APPStates.RPT7PARAMS:
			%>
    <jsp:include page="/report7Params.jsp" flush="true"></jsp:include>
			<%
			break;
	case APPStates.RPT7:
			%>
    <jsp:include page="/report7Form.jsp" flush="true"></jsp:include>
			<%
			break;
	case APPStates.RPT8PARAMS:
			%>
    <jsp:include page="/report8Params.jsp" flush="true"></jsp:include>
			<%
			break;
	case APPStates.RPT8:
			%>
    <jsp:include page="/report8Form.jsp" flush="true"></jsp:include>
			<%
			break;
	case APPStates.RPT9PARAMS:
			%>
    <jsp:include page="/report9Params.jsp" flush="true"></jsp:include>
			<%
			break;
	case APPStates.RPT9:
			%>
    <jsp:include page="/report9Form.jsp" flush="true"></jsp:include>
			<%
			break;
	case APPStates.RPT91PARAMS:
			%>
    <jsp:include page="/report91Params.jsp" flush="true"></jsp:include>
			<%
			break;
	case APPStates.RPT91:
			%>
    <jsp:include page="/report91Form.jsp" flush="true"></jsp:include>
			<%
			break;
	case APPStates.MASSCALCPARAMS:
			%>
    <jsp:include page="/masscalc.jsp" flush="true"></jsp:include>
			<%
			break;
	case APPStates.MASSCALC:
			%>
    <jsp:include page="/masscalcref.jsp" flush="true"></jsp:include>
			<%
			break;
	case APPStates.MASSDOCPARAMS:
			%>
    <jsp:include page="/massdocparams.jsp" flush="true"></jsp:include>
			<%
			break;
	case APPStates.MASSDOC:
			%>
    <jsp:include page="/massdoc.jsp" flush="true"></jsp:include>
			<%
			break;
	case APPStates.INVACTLOADEXCEL:
			%>
    <jsp:include page="/invActLoadExcel.jsp" flush="true"></jsp:include>
			<%
			break;
	case APPStates.INVLOADEXCEL:
			%>
    <jsp:include page="/invLoadExcel.jsp" flush="true"></jsp:include>
			<%
			break;
	case APPStates.EOLOADEXCEL:
			%>
    <jsp:include page="/externalLoadExcel.jsp" flush="true"></jsp:include>
			<%
			break;
	case APPStates.IOLOADEXCEL:
			%>
    <jsp:include page="/internalLoadExcel.jsp" flush="true"></jsp:include>
			<%
			break;
	case APPStates.IORLOADEXCEL:
			%>
    <jsp:include page="/internalRLoadExcel.jsp" flush="true"></jsp:include>
			<%
			break;
	case APPStates.INVFILLFDB:
			%>
    <jsp:include page="/invFillFromDB.jsp" flush="true"></jsp:include>
			<%
			break;
	case APPStates.IVAFILLFDB:
			%>
    <jsp:include page="/invActFillFromDB.jsp" flush="true"></jsp:include>
			<%
			break;
	case APPStates.INVLOADINV:
			%>
    <jsp:include page="/invLoadInv.jsp" flush="true"></jsp:include>
			<%
			break;
	case APPStates.AFSLIST:
			%>
    <jsp:include page="/afsList.jsp" flush="true"></jsp:include>
			<%
			break;
	case APPStates.EDITAFS:
			%>
    <jsp:include page="/afsForm.jsp" flush="true"></jsp:include>
			<%
			break;
	case APPStates.AFSPOSLIST:
			%>
    <jsp:include page="/afsPositionList.jsp" flush="true"></jsp:include>
			<%
			break;
	case APPStates.EDITAFSPOSG:
			%><jsp:include page="/afsPositionGForm.jsp" flush="true"></jsp:include><%
			break;
	case APPStates.EDITAFSPOSA:
			%><jsp:include page="/afsPositionAForm.jsp" flush="true"></jsp:include><%
			break;
	case APPStates.EDITAFSDPOS:
			%><jsp:include page="/afsPositionDForm.jsp" flush="true"></jsp:include><%
			break;
	case APPStates.EDITAFSPOS:
			%><jsp:include page="/afsPositionForm.jsp" flush="true"></jsp:include><%
			break;
	case APPStates.AFSSTATE:
			%><jsp:include page="/afsStateForm.jsp" flush="true"></jsp:include><%
			break;
	case APPStates.MOUNT_ACT2:
			%><jsp:include page="/mountAct2.jsp" flush="true"></jsp:include><%
			break;			
	case APPStates.CONF_EQ_FORM:
 			%><jsp:include page="/eqConfForm.jsp" flush="true"></jsp:include><%
	 		break;	
	case APPStates.CONFIG_EQUIPMENT_FORM:
 			%><jsp:include page="/ConfigAppletPage.jsp" flush="true"></jsp:include><%
	 		break;	
		default:
			%><jsp:include page="/error.jsp" flush="true"></jsp:include><%
			break;
		}
	%>
			  	<%--</TD>
			</TR>--%>
			</TD>
					</TR>
					<tr class="title" style="height:15"><td class="title"><july:statenavigator/></td></tr>
					</table>
	</td>
</tr>
			<tr>
				<td class="probel" colspan="7" style="height:2px;background-image:/images/points.gif" ><img src="/images/empty.gif" width="1" height="1" border="0" alt=""></td>
  			</tr>
		  	<tr>
		  		<td colspan="3" align="right" class="copyright">&copy; 2002 Copyright&nbsp;&nbsp;<a href="http://www.beeline.ru" style="color:gray;" style="text-decoration:none;">BeeLine</a>&nbsp;&nbsp;</td>
			</tr>
		  </TABLE>
		  
 
<script language="javascript" src="/focus.js"></script>
 