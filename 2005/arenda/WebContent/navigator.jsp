<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.arenda.*" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<TABLE class=includer border="0" cellpadding="0" cellspacing="0">
	<TR>
		<TD vAlign=top width=180>
			<table width="200" height="110">
				<tr class="select">
					<td class="menu" vAlign=top>
				       <july:menu selectedId="0" styleId="orgmenu" height="120">
							<july:menuitem key="label.menu.organizer" action="/main.do?navclear=1" stateId="1">
								<july:menuitem key="label.menu.tasklist" action="/ShowTaskList.do?navclear=1" stateId="2"/>
								<july:menuitem key="label.menu.reregister" action="/Reregister.do?navclear=1" stateId="3"/>
								<july:menuitem key="label.menu.logout" action="/Logout.do?navclear=1" stateId="4"/>
							</july:menuitem>
						</july:menu>
					</td>
				</tr>
			</table>
			<table width="200" height="300">
				<tr class="select">
					<td class="menu" vAlign=top><jsp:include page="/arendaMenu.jsp" flush="true"></jsp:include></td>
				</tr>
			</table>
		</TD>
		<td style="background-image: url(/images/points_vert.gif); background-repeat: repeat-y;"><img src="/images/empty.gif" width="1" height="1" border="0" alt=""></td>
	</TR>
</TABLE>
