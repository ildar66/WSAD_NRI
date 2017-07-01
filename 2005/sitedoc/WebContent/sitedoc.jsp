<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld"    prefix="alex" %>
<%@ page import="com.hps.july.web.util.*" %>
<%@ page import="com.hps.july.jdbcpersistence.lib.*" %>
<%@ page import="com.hps.july.constants.Applications,com.hps.july.jdbcpersistence.lib.*" %>
<%@ page import="com.hps.july.sitedoc.APPStates" %>
<%@ page import="com.hps.july.sitedoc.valueobject.*" %>
<%@ page import="com.hps.july.apptags.HasRegionAccessTag" %>
<%@ page import="com.hps.july.apptags.HasAccessTag" %>
<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%--@include file="graphMenu.jspf"--%>
<%
// DD - inserted
	int state = ParamsParser.getState( pageContext );
	int appHome = ParamsParser.getRootApp( pageContext );
//	int appHome = 10;
	String imgscr="";
	if ( state != APPStates.LOGIN ) {
		DocObjectDef odef = DocObjectDef.getDef(session);
		//DebugSupport.printlnTest("!!!!sitedoc.jsp appHome="+appHome);
		//DebugSupport.printlnTest("!!!!sitedoc.jsp odef.getPositionId()="+odef.getPositionId());

		if(appHome==Applications.SITEINFO) {
			imgscr="/images/logo_beeline_siteinfo.gif";
		} else if(appHome==Applications.BASESTATION) {
			imgscr="/images/logo_beeline_basestation.gif";
		} else if(appHome==Applications.PROJECT) {
			imgscr="/images/plane_shapka.gif";
		} else {
			imgscr = "/images/logo_beeline.gif";
		}

		if( (odef != null) && (odef.getPositionId() != null) ) {
			boolean hasRegionAccess = HasRegionAccessTag.hasAccess(request,odef.getPositionId().intValue()+"","Edit");
			DebugSupport.printlnTest("!!!!sitedoc.jsp hasRegionAccess="+hasRegionAccess);
			boolean hasRoleAccess = HasAccessTag.hasAccess(pageContext,"/EditSiteDocFile.do");
			DebugSupport.printlnTest("!!!!sitedoc.jsp hasRoleAccess="+hasRoleAccess);
			new DebugSupport().printlnTest("hasRegionAccess="+hasRegionAccess+" hasRoleAccess="+hasRoleAccess);
			odef.setCanModify(hasRegionAccess&&hasRoleAccess&&odef.isCanModify());
			DebugSupport.printlnTest("!!!!sitedoc.jsp dForm.isCanModify()="+odef.isCanModify());
		}
	}
%>

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
			<td><div id="ctnrButton" class="<%=classButton%>" ><iframe id="updateMenu1" name="updateMenu1" src="" width="100%" height="100%" frameborder="0" style="display:none"></iframe></div><img src="<%=imgscr%>" border="0" alt=""></td>
			<td width="10%" align="right"><a href="#" title="Помощь" onclick="window.open('/equipinfo.doc', '_blank', 'top=40, left=100, width=830, height=630, scrollbars=yes, resizable=yes'); return false;"><img src="/images/helph.gif" border="0" hspace="12"></a></td>
		</tr>
	</table>


	</td>
  </TR>
  <tr>
	<td colspan="3" background="/images/points3.gif" height="1"><img src="/images/empty.gif" width="1" height="1" border="0" alt=""></td>
  </tr>
  <TR>
    <TD vAlign=top width="240" id="menuCntr">
		<table width="240" height="110">
			<tr class="select">
				<td class="menu" vAlign=top>
		<%--
		        <july:menu selectedId="0" styleId="orgmenu" height="100">
		          <july:menuitem key="label.menu.organizer" action="/main.do?navclear=1" stateId="1">
		            <july:menuitem key="label.menu.tasklist"  action="/ShowTaskList.do?navclear=1" stateId="2" />
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
<%if(appHome==Applications.SITEINFO) {%>
   <jsp:include page="menu/siteinfoMenu.jsp" flush="true"  />
<%} else if(appHome==Applications.BASESTATION) {%>
   <jsp:include page="menu/basestationMenu.jsp" flush="true"  />
<%} else if(appHome==Applications.PROJECT) {%>
   <jsp:include page="menu/projectMenu.jsp" flush="true"  />
<%} else {%>
   <%@include file="menu/sitedocMenu.jsp"%>
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

<td style="background-image: url(/images/points_vert.gif); background-repeat: repeat-y;" id="separH"><img src="/images/empty.gif" width="1" height="1" border="0" alt=""></td>

<TD vAlign="top" width="100%" height="100%">

  <TABLE class="main" border="0" cellpadding="0" cellspacing="0" vAlign="middle" style="height:100%">
    <TR class="title" style="height:15px" vAlign="middle"><TD class="title"><july:statenavigator/></TD></TR>
	<july:errors/>
	<TR style="height:100%"><TD vAlign=middle width="100%" style="height:100%">
<%
	DebugSupport.printlnTest("!!!sitedoc.jsp state="+state);
	//int state = ParamsParser.getState( pageContext );
	switch(state)
	{
	case APPStates.MAIN:
		%><jsp:include page="/sitedocMain.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.SiteDocEquipmentListForm:
		%><jsp:include page="/siteDocEquipmentList.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.LOGIN:
		%><jsp:include page="/loginForm.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.SiteDocFileForm:
		%><jsp:include page="/siteDocFileForm.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.SiteDocForm:
		%><jsp:include page="/siteDocForm.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.SiteDocListForm:
		%><jsp:include page="/siteDocList.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.SiteDocPositionListForm:
		%><jsp:include page="/siteDocPositionList.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.SiteDocComlineListForm:
		%><jsp:include page="/siteDocComlineList.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.SiteDocTypeListForm:
		%><jsp:include page="/siteDocTypeList.jsp" flush="true"></jsp:include><%
		break;
	case APPStates.SiteDocTypeForm :
		%><jsp:include page="/siteDocTypeForm.jsp" flush="true"></jsp:include><%
		break;
	case 34 :
		%><jsp:include page="/regionsDocList.jsp" flush="true"></jsp:include><%
		break;
/////// (_!_)
	default:
		%><jsp:include page="/error.jsp" flush="true"></jsp:include><%
		break;
	}
%>
					</TD>
					</TR>
					<tr class="title" style="height:15px"><td class="title"><july:statenavigator/></td></tr>
					</table>
			
			  	</TD>
			</TR>
			<tr style="height:0%">
				<td class="probel" colspan="3" style="height:2px;background-image:/images/points.gif" ><img src="/images/empty.gif" width="1" height="1" border="0" alt=""></td>
  			</tr>
		  	<tr style="height:0%">
		  		<td colspan="3" align="right" class="copyright">&copy; 2003 Copyright&nbsp;&nbsp;<a href="http://www.beeline.ru" style="color:gray;" style="text-decoration:none;">BeeLine</a>&nbsp;&nbsp;</td>
			</tr>
		  </TABLE>

