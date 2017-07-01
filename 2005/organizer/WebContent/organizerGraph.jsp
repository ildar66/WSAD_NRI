<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.organizer.*,com.hps.july.organizer.valueobject.*" %>
<%@ page import="com.hps.july.constants.Applications,com.hps.july.valueobject.*"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<SCRIPT language=javascript src="/common/exitFromNRI.js" type="text/javascript"></SCRIPT>  

	<%
	    int appState = ParamsParser.getState( pageContext );
    %>
	<script>
	<!--
		<%	Profile profile = (Profile)request.getSession().getAttribute(Profile.PROFILE);
			String lastUrl = null;
			String classButton = "ButtonEnabledArmed";
			String menuStatus = "0";
			if(profile != null) {
				lastUrl = profile.getSystemLastURL();
				menuStatus = profile.getSystemMenuStatus();
				if(menuStatus == null) menuStatus = "0"; 
				else if(menuStatus.equals("1")) classButton = "ButtonEnabledArmedPressed";
			}
			if(lastUrl != null && appState != APPStates.LOGOUT) { 
				%> document.location.href = '<%=lastUrl%>'; <%
			}
		%>
		var stat = <%=menuStatus%>;
	-->
	</script>

<%--@include file="graphMenu.jspf"--%>
<TABLE class=includer border="0" cellpadding="0" cellspacing="0">
  <TR>
    <TD colspan="3" width="100%" bgcolor="D6EBFF" height="43">
	<table height="100%" width="100%">
		<tr>
			<td>
				<div id="ctnrButton" class="<%=classButton%>">
					<iframe id="updateMenu1" name="updateMenu1" src="" width="100%" height="100%" frameborder="0" style="display:none"></iframe>
				</div>
				<img src="/images/logo_beeline.gif" border="0" alt="">
			</td>
			<td width="10%" align="right">
				<a href="#" title="Помощь" onclick="window.open('/organizer.doc', '_blank', 'top=40, left=100, width=830, height=630, scrollbars=yes, resizable=yes'); return false;"><img src="/images/helph.gif" border="0" hspace="12"></a>
			</td>
		</tr>
<%--
		<tr id="graphMenu" >
			<td colspan="2">
				<a href="#" onMouseOver="menuOn('MainGraph'); window.status='MainGraph'; return true;"  onMouseOut="overChecker('MainGraph'); window.status=' '; return true;">
				<img src="/menu/images/main_off.gif" width=95 height=20 border=0 name="MainGraph" alt="MainGraph"></a>
				<a href="#" onMouseOver="menuOn('Dictionary'); window.status='Dictionary'; return true;"  onMouseOut="overChecker('Dictionary'); window.status=' '; return true;">
				<img src="/menu/images/dictionary_off.gif" width=95 height=20 border=0 name="Dictionary" alt="Dictionary"></a>
			</td>
		</tr>
--%>
	</table>
	</td>
  </TR>
  <tr>
	<td colspan="7" background="/images/points3.gif" height="1"><img src="/images/empty.gif" width="1" height="1" border="0" alt=""></td>
  </tr>
  <TR>
    <TD vAlign=top width="240" >
<table width="240" height="100%" id="menuCntr">
	<tr class="select">
		<td class="menu" vAlign=top>
			<%--
				<jsp:include page="/organizerMenu.jsp" flush="true"/>
			--%>
			<%--@include file="organizerTree.jspf"--%>
			<jsp:include page="menuTree.jsp" flush="true"></jsp:include>
		</td>
    </tr>
</TABLE>
</TD>
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

	<july:errors/>
	<%
	switch( appState )
		{
		case APPStates.MAIN:
			%>
			<jsp:include page="/orgMain.jsp" flush="true"></jsp:include>
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
		case APPStates.REREGISTER:
			%>
			<jsp:include page="/reregisterForm.jsp" flush="true"></jsp:include>
			<%
			break;
		case APPStates.TASKLIST:
			%>
			<jsp:include page="/taskList.jsp" flush="true"></jsp:include>
			<%
			break;
		case APPStates.ERROR:
			%>
			<jsp:include page="/error.jsp" flush="true"></jsp:include>
			<%
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
			<tr>
				<td class="probel" colspan="7" style="height:2px;background-image:/images/points.gif" ><img src="/images/empty.gif" width="1" height="1" border="0" alt=""></td>
  			</tr>
		  	<tr>
		  		<td colspan="3" align="right" class="copyright">&copy; 2002 Copyright&nbsp;&nbsp;<a href="http://www.beeline.ru" style="color:gray;" style="text-decoration:none;">BeeLine</a>&nbsp;&nbsp;</td>
			</tr>
		  </TABLE>
          