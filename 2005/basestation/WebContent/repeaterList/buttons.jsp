<%@ page import="com.hps.july.basestation.formbean.RepeaterList" %>
<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld" prefix="alex" %>

<%	String gColSpan = request.getAttribute("colspan") + "";
	RepeaterList lForm = (RepeaterList) pageContext.findAttribute("RepeaterList"); %>

<tr class="title">
	<td colspan="<%= gColSpan %>">
		<table class="buttons">
			<tr class="title">
			<td class="buttons">
				<alex:hasAccess href="/EditFactRepeater.do" >
					<july:link page='/EditFactRepeater.do?action=Add'>
						<IMG alt='<bean:message key="label.repeaterlist.add.fact"/>' src="/images/plus.gif" border=0>
					</july:link>
				</alex:hasAccess>
				<IMG alt="" src="/images/empty.gif" width=3 border=0>
				<july:backbutton page="/main.do"/>
				&nbsp;
				<image name="onMap" src="/images/map.gif" alt="<bean:message key="SwitchList.buttons.map"/>"  onclick="determineMaps(); return true;"/>
			</TD>
				<TD class="navigator"><july:navigator/></TD>
			</TR>
		</TABLE>
	</TD>
</tr>
