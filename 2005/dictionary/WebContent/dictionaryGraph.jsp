<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*, com.hps.july.dictionary.*, com.hps.july.constants.*" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<SCRIPT language=javascript src="/common/dialog.js" type="text/javascript"></SCRIPT>  
<SCRIPT language=javascript src="/common/exitFromNRI.js" type="text/javascript"></SCRIPT>  

<%
	int appHome = ParamsParser.getRootApp( pageContext );
 	String imgscr="/images/logo_beeline_sprav.gif";
%>

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

<%--@include file="graphMenu.jspf"--%> 

<table class=includer border="0" cellpadding="0" cellspacing="0">
<tr>
	<td colspan="3" width="100%" bgcolor="D6EBFF" height="43">
	<table height="100%" width="100%">
		<tr>
			<td>
				<div id="ctnrButton" class="<%=classButton%>">
					<iframe id="updateMenu1" name="updateMenu1" src="" width="100%" height="100%" frameborder="0" style="display:none"></iframe>
				</div><img src="<%=imgscr%>" border="0" alt="">
			</td>
			<td width="10%" align="right">
				<a href="#" title="������" onclick="window.open('/dictionary.doc', '_blank', 'top=40, left=100, width=830, height=630, scrollbars=yes, resizable=yes'); return false;"><img src="/images/helph.gif" border="0" hspace="12"></a>
			</td>
		</tr>
<%--
		<tr id="graphMenu" >
			<td colspan="2">
				<a href="#" onMouseOver="menuOn('MainGraph'); window.status='MainGraph'; return true;"  onMouseOut="overChecker('MainGraph'); window.status=' '; return true;">
				<img src="/menu/images/main_off.gif" width=95 height=20 border=0 name="MainGraph" alt="MainGraph"></a>
				<a href="/dict/main.do?navclear=1&rootapp=0&rootstate=0" onMouseOver="menuOn('Dictionary'); window.status='Dictionary'; return true;"  onMouseOut="overChecker('Dictionary'); window.status=' '; return true;">
				<img src="/menu/images/dictionary_off.gif" width=95 height=20 border=0 name="Dictionary" alt="Dictionary"></a>
			</td>
		</tr>
--%>
		</table>
		</td>
	</tr>
<tr>
	<td colspan="7" background="/images/points3.gif" height="1"><img src="/images/empty.gif" width="1" height="1" border="0" alt=""></td>
</tr>
<tr>
	<td vAlign=top width="240" id="menuCntr">
<%
	int appState = ParamsParser.getState( pageContext );
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

	</table>

<%--
	<table width="200" height="300">
	<tr class="select">
<%if(appHome==Applications.ARENDA) { %>
        <td class="menu" vAlign=top>
		       <jsp:include page="/arendaMenu.jsp" flush="true"></jsp:include> 
	    </td>
<%} else {%>
		<td class="menu" vAlign=top>
			<%@include file="dictionaryMenu.jsp"%>
		</td>
<%}%>
	</tr>
	</table>
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
				//var graphMenu = document.getElementById('graphMenu');
				if(button1 && menuCntr && menuUpdate2) {
					if(stat == 0) { 
						button1.className = 'ButtonEnabledArmedPressed'; 
						stat = 1; menuCntr.style.display = 'none'; //graphMenu.style.display = 'block';
					}
					else { 
						button1.className = 'ButtonEnabledArmed'; 
						stat = 0; menuCntr.style.display = 'block'; //graphMenu.style.display = 'none';
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
			//var graphMenu = document.getElementById('graphMenu');
			if(button1 && menuCntr) {
				if(stat == 0) { 
					button1.className = 'ButtonEnabledArmed'; 
					menuCntr.style.display = 'block'; 
					//graphMenu.style.display = 'none';
				}
				else { 
					button1.className = 'ButtonEnabledArmedPressed'; 
					menuCntr.style.display = 'none';
					//graphMenu.style.display = 'block';
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
	int state = ParamsParser.getState( pageContext );
	switch( state )
	{
	case APPStates.MAIN:
		%><jsp:include page="/dictMain.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.MAIN_RES:
		%><jsp:include page="/dictDevice.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.AERLIST:
		%><jsp:include page="/ariealtypeList.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.LOGIN:
		%><jsp:include page="/loginForm.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.SYSCLIST:
		%><jsp:include page="/sysconstList.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.EDITSYSC:
		%><jsp:include page="/sysconstForm.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.TAXLIST:
		%><jsp:include page="/taxList.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.EDITTAX:
		%><jsp:include page="/taxForm.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.UNITLIST:
		%><jsp:include page="/unitList.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.EDITUNIT:
		%><jsp:include page="/unitForm.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.RTPLIST:
		%><jsp:include page="/restypeList.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.EDITRTP:
		%><jsp:include page="/restypeForm.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.RSTPLIST:
		%><jsp:include page="/ressbtypeList.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.EDITRSTP:
		%><jsp:include page="/ressbtypeForm.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.RESLIST:
		%><jsp:include page="/resourceList.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.INVRESOURCE_LIST:
		%><jsp:include page="/invResourceList.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.EDITRES:
		%><jsp:include page="/resourceForm.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.TAXHLIST:
		%><jsp:include page="/taxhistList.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.EDITTAXH:
		%><jsp:include page="/taxhistForm.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.CRNCLIST:
		%><jsp:include page="/currencyList.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.EDITCRNC:
		%><jsp:include page="/currencyForm.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.CRTHLIST:
		%><jsp:include page="/currateHList.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.EDITCRTH:
		%><jsp:include page="/currateHForm.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.RATPLIST:
		%><jsp:include page="/ratetypeList.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.EDITRATP:
		%><jsp:include page="/ratetypeForm.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.CRTLIST:
		%><jsp:include page="/currateList.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.EDITCRT:
		%><jsp:include page="/currateForm.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.EDITDBL:
		%><jsp:include page="/doubleForm.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.CPFLIST:
		%><jsp:include page="/complectForList.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.EDITCPF:
		%><jsp:include page="/complectForForm.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.CPFCLIST:
		%><jsp:include page="/complectNodesList.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.EDITCPFC:
		%><jsp:include page="/complectNodesForm.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.CPLIST:
		%><jsp:include page="/complectList.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.EDITCP:
		%><jsp:include page="/complectForm.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.CPCLIST:
		%><jsp:include page="/complectContentList.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.EDITCPC:
		%><jsp:include page="/complectContentForm.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.COMPLIST:
		%><jsp:include page="/companyList.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.ORGLISTM   :
		%><jsp:include page="/organizationListM.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.EDITORGM   :
		%><jsp:include page="/organizationForm.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.ORGLISTC   :
		%><jsp:include page="/organizationListC.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.EDITORGC   :
		%><jsp:include page="/organizationForm.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.COMPLOOKUP :
		%><jsp:include page="/error.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.BANKLIST   :
		%><jsp:include page="/bankList.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.EDITBANK   :
		%><jsp:include page="/bankForm.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.ACCLIST   :
		%><jsp:include page="/accountList.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.EDITACC   :
		%><jsp:include page="/accountForm.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.ACCLISTC   :
		%><jsp:include page="/accountListC.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.EDITACCC   :
		%><jsp:include page="/accountForm.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.GRPLIST    :
		%><jsp:include page="/groupList.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.EDITGRP    :
		%><jsp:include page="/groupForm.jsp" flush="true"></jsp:include><%
		break;
        case APPStates.GRPPLIST   :
    			%>
          <jsp:include page="/grouppingList.jsp" flush="true"></jsp:include>
    			<%
    			break;
        case APPStates.EDITGRPP   :
    			%>
          <jsp:include page="/grouppingForm.jsp" flush="true"></jsp:include>
    			<%
    			break;
        case APPStates.ORGGLIST   :
    			%>
          <jsp:include page="/orggroupList.jsp" flush="true"></jsp:include>
    			<%
    			break;
        case APPStates.EDITORGG   :
    			%>
          <jsp:include page="/orggroupForm.jsp" flush="true"></jsp:include>
    			<%
    			break;
        case APPStates.ORGGCLIST   :
    			%>
          <jsp:include page="/orggroupListC.jsp" flush="true"></jsp:include>
    			<%
    			break;
        case APPStates.EDITORGGC   :
    			%>
          <jsp:include page="/orggroupForm.jsp" flush="true"></jsp:include>
    			<%
				break;
        case APPStates.GRPOLIST   :
    			%>
         	<jsp:include page="/grouporgList.jsp" flush="true"></jsp:include>
    		<%
    		break;
        case APPStates.EDITGRPO   :
    		%>
          	<jsp:include page="/grouporgForm.jsp" flush="true"></jsp:include>
    		<%
    		break;
        case APPStates.STRGLIST:
    		%>
          <jsp:include page="/storageList.jsp" flush="true"></jsp:include>
    		<%
    		break;
        case APPStates.EDITSTRG:
    		%>
          	<jsp:include page="/storageForm.jsp" flush="true"></jsp:include>
    		<%
    		break;
        case APPStates.ORGMULTI		:
    		%>
          	<jsp:include page="/organizationMultiList.jsp" flush="true"></jsp:include>
    		<%
    		break;
        case APPStates.ANTENA_LIST:
                %>
                <jsp:include page="/antenaList.jsp" flush="true"></jsp:include>
                <%
                break;
        case APPStates.ANTENA_EDIT:
        case APPStates.ANTENA_RES_EDIT:
                %>
                <jsp:include page="/antenaForm.jsp" flush="true"></jsp:include>
                <%
    		break;
        case APPStates.REPEATER_LIST:
                %>
                <jsp:include page="/repeaterList.jsp" flush="true"></jsp:include>
                <%
                break;
        case APPStates.REPEATER_EDIT:
        case APPStates.REPEATER_RES_EDIT:
                %>
                <jsp:include page="/repeaterForm.jsp" flush="true"></jsp:include>
<%
break;
case APPStates.CABLE_LIST:
%>
<jsp:include page="/cableList.jsp" flush="true"></jsp:include>
<%
break;
case APPStates.CABLE_EDIT:
case APPStates.CABLE_RES_EDIT:
%>
<jsp:include page="/cableForm.jsp" flush="true"></jsp:include>
<%
break;
case APPStates.BASESTATION_LIST:
%>
<jsp:include page="/basestationList.jsp" flush="true"></jsp:include>
<%
break;
case APPStates.BASESTATION_EDIT:
case APPStates.BASESTATION_RES_EDIT:
%>
<jsp:include page="/basestationForm.jsp" flush="true"></jsp:include>
<%
break;
case APPStates.CHORTYPE:
%>
<jsp:include page="/choosertypeForm.jsp" flush="true"></jsp:include>
<%
break;
		case APPStates.CARS_LIST:
			%>
			<jsp:include page="/carsList.jsp" flush="true"></jsp:include>
			<%
			break;
		case APPStates.CAR_EDIT:
			%>
			<jsp:include page="/carForm.jsp" flush="true"></jsp:include>
			<%
			break;
case APPStates.ORGWLIST:
%>
<jsp:include page="/orgworkersList.jsp" flush="true"></jsp:include>
<%
break;
case APPStates.EDITORGW:
%>
<jsp:include page="/orgworkerForm.jsp" flush="true"></jsp:include>
<%
break;

case APPStates.RRLANTRESOURCE_LIST:
%>
<jsp:include page="/rrlResourceList.jsp" flush="true"></jsp:include>
<%
break;

case APPStates.RRLANTRESOURCE_EDIT:
%>
<jsp:include page="/rrlResourceForm.jsp" flush="true"></jsp:include>
<%
break;

case APPStates.RRLANTRESOURCE_PARAM_EDIT:
%>
<jsp:include page="/rrlResourceParamsForm.jsp" flush="true"></jsp:include>
<%
break;

case APPStates.RRLANTRESOURCE_SPEEDPARAM_EDIT:
%>
<jsp:include page="/rrlResourceSpeedParamsForm.jsp" flush="true"></jsp:include>
<%
break;

case APPStates.PERSON_LIST:
%>
<jsp:include page="/personList.jsp" flush="true"></jsp:include>
<%
break;

case APPStates.REGION_LIST:
%>
<jsp:include page="/regionList.jsp" flush="true"></jsp:include>
<%
break;

case APPStates.BANKS_LIST:
%>
<jsp:include page="/banksList.jsp" flush="true"></jsp:include>
<%
break;

case APPStates.VENDOR_LIST:
%>
<jsp:include page="/vendorList.jsp" flush="true"></jsp:include>
<%
break;

case APPStates.VENDOR_SITE_LIST:
%>
<jsp:include page="/vendorSiteList.jsp" flush="true"></jsp:include>
<%
break;

case APPStates.ACCOUNTS_LIST:
%>
<jsp:include page="/accountsList.jsp" flush="true"></jsp:include>
<%
break;

case APPStates.VENDOR_ADMIN_LIST:
%>
<jsp:include page="/vendorAdminList.jsp" flush="true"></jsp:include>
<%
break;

case APPStates.VENDOR_SITE_ADMIN_LIST:
%>
<jsp:include page="/vendorSiteAdminList.jsp" flush="true"></jsp:include>
<%
break;

case APPStates.DONOR_UNIT_LIST   :
%>
<jsp:include page="/donorunitList.jsp" flush="true"></jsp:include>
<%
break;

case APPStates.EDIT_DONOR_UNIT   :
case APPStates.DONORUNIT_RES_EDIT   :

%>
<jsp:include page="/donorunitForm.jsp" flush="true"></jsp:include>
<%
break;

case APPStates.EDIT_RESOURCEGROUP :

%>
<jsp:include page="/resourceGroupForm.jsp" flush="true"></jsp:include>
<%
break;

case APPStates.CONF_POWER_SOURCES_LIST:
%><jsp:include page="/confPowerSources.jsp" flush="true"></jsp:include><%
break;		
	
case APPStates.CONF_BASE_STATION_LIST:
%><jsp:include page="/confBaseStation.jsp" flush="true"></jsp:include><%
break;		

case APPStates.RESOURCEGROUP_LIST:
%><jsp:include page="/resourceGroupList.jsp" flush="true"></jsp:include><%
break;		

case APPStates.RESANTENNA_LIST:
%><jsp:include page="/resourceAntennaList.jsp" flush="true"></jsp:include><%
break;		

case APPStates.EDIT_RESANTENNA :
%><jsp:include page="/resourceAntennaForm.jsp" flush="true"></jsp:include><%
break;
		
case APPStates.CONF_CONNECTOR_CABLE_COMPAT_LIST:
%><jsp:include page="/confConnectorCableCompatList.jsp" flush="true"></jsp:include><%
break;		

case APPStates.USERREQUEST_LIST:	
	%><jsp:include page="/userRequestList.jsp" flush="true"></jsp:include><%
break;			 				

case APPStates.EDIT_USERREQUEST:	
	%><jsp:include page="/userRequestForm.jsp" flush="true"></jsp:include><%
break;			 				

case APPStates.TRANCEIVER_LIST:	
	%><jsp:include page="/tranceiverList.jsp" flush="true"></jsp:include><%
break;			 				

case APPStates.EDIT_TRANCEIVER:	
	%><jsp:include page="/tranceiverForm.jsp" flush="true"></jsp:include><%
break;			 				

case APPStates.RESCLASS_LIST:	
	%><jsp:include page="/resourceClassList.jsp" flush="true"></jsp:include><%
break;			 				

case APPStates.EDIT_RESCLASS:	
	%><jsp:include page="/resourceClassForm.jsp" flush="true"></jsp:include><%
break;			 				

case APPStates.EDIT_RESSETCLASS:	
	%><jsp:include page="/resourcesetClassForm.jsp" flush="true"></jsp:include><%
break;			 				

case APPStates.COMMONRES_LIST:	
	%><jsp:include page="/resourcesCommonList.jsp" flush="true"></jsp:include><%
break;			 				

case APPStates.EDIT_ACCUMBATTERY:	
	%><jsp:include page="/accumBatteryForm.jsp" flush="true"></jsp:include><%
break;			 				

case APPStates.AFSSCHEME_LIST:	
	%><jsp:include page="/afsSchemeList.jsp" flush="true"></jsp:include><%
break;			 				

case APPStates.EDIT_AFSSCHEME:	
	%><jsp:include page="/afsSchemeForm.jsp" flush="true"></jsp:include><%
break;			 				

case APPStates.EQUIPMANUF_LIST:	
	%><jsp:include page="/equipmanufList.jsp" flush="true"></jsp:include><%
break;			 				

case APPStates.EDIT_EQUIPMANUF:	
	%><jsp:include page="/equipmanufForm.jsp" flush="true"></jsp:include><%
break;			 				

case APPStates.RESOURCEREPORT:	
	%><jsp:include page="/resourceReport.jsp" flush="true"></jsp:include><%
break;			 				

default:
%>
<jsp:include page="/error.jsp" flush="true"></jsp:include>
<%
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
		  		<td colspan="3" align="right" class="copyright">&copy; 2002 Copyright&nbsp;&nbsp;BeeLine&nbsp;&nbsp;</td>
			</tr>
		  </TABLE>

