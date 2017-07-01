<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.arenda.*" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%
	int app = ParamsParser.getApplication(pageContext);
	int state = ParamsParser.getState(pageContext);
	String helpFile = "window.open('" + com.hps.july.util.AppUtils.getHelpFileName(app, state) + "', '_blank', 'top=40, left=100, width=830, height=630, scrollbars=yes, resizable=yes'); return false;";
	Profile profile = (Profile)request.getSession().getAttribute(Profile.PROFILE);
	com.hps.july.valueobject.RegionsAccess_TO curReg = profile.getProfileAccess().getCurrRegion();		
%>
<TABLE class=includer border="0" cellpadding="0" cellspacing="0">
	<TR>
		<TD colspan="3" width="100%" bgcolor="D6EBFF" height="43">
			<table height="100%" width="100%">
				<tr>
					<td>
						<img src="/images/logo_beeline_dogovor.gif" border="0" alt="">
						<B style="color: blue; font-size: 80%"><%=curReg.getRegionName()%></B>
					</td>
                    <td width="10%" align="right"><a href="#" title="Помощь" onclick="<%= helpFile %>"><img src="/images/helph.gif" border="0" hspace="12"></a></td>
				</tr>
			</table>
		</td>
	</TR>
	<tr>
		<td colspan="3" background="/images/points3.gif" height="1"><img src="/images/empty.gif" width="1" height="1" border="0" alt=""></td>
	</tr>

	<TR>
		<TD COLSPAN="3" vAlign=top width="100%">

		  <TABLE class="main" border="0" cellpadding="0" cellspacing="0" vAlign=top height="100%">
			<TR class="title" style="height:15"><TD class="title"><july:statenavigator/></TD></TR>
			<july:errors/>
			<TR><TD vAlign=top width="100%">

