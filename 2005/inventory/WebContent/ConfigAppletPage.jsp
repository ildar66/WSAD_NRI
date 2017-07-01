<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<div style="width:100%; height:100%;" id="configAppletDiv" >
<SCRIPT>
	function setBackGroundColor(color) {
		document.getElementById("configAppletDiv").style.backgroundColor = color;
	}
</SCRIPT>

<CENTER>
<APPLET code="com.hps.july.applets.config.ConfigForm.class"
	    codebase="/inventory/applets/" 
	    archive="config.jar,jcalendar-1.3.2.jar"
	    width="930" 
	    height="705">
	    <PARAM NAME="canWrite" VALUE="<%=request.isUserInRole("administrator")||
	    								 request.isUserInRole("editFKBS")||
	    								 request.isUserInRole("developer")%>" />
	    <PARAM NAME="operator" VALUE="<%=request.getRemoteUser()%>" />
</APPLET>
</CENTER>
</div>


<%
	String masterTagId = "wordid";
%>
<july:wordEditMaster styleId='<%= masterTagId %>' />

<july:wordEditSlave masterStyleId='<%= masterTagId %>' styleId='reportChanges' 
	url='<%= "ReportChanges.do?document=" %>' 
	uploadurl=''
	updatable='false'
	documentid='0'>
</july:wordEditSlave>

<july:wordEditSlave masterStyleId='<%= masterTagId %>' styleId='reportConfig1' 
	url='<%= "ReportConfig1.do?document=" %>' 
	uploadurl=''
	updatable='false'
	documentid='0'>
</july:wordEditSlave>

<july:wordEditSlave masterStyleId='<%= masterTagId %>' styleId='reportConfig2' 
	url='<%= "ReportConfig2.do?document=" %>' 
	uploadurl=''
	updatable='false'
	documentid='0'>
</july:wordEditSlave>

<july:wordEditSlave masterStyleId='<%= masterTagId %>' styleId='reportBTSMountAct' 
	url='<%= "ReportBTSMountAct.do?document=" %>' 
	uploadurl=''
	updatable='false'
	documentid='0'>
</july:wordEditSlave>

<july:wordEditSlave masterStyleId='<%= masterTagId %>' styleId='reportAFSMountAct' 
	url='<%= "ReportAFSMountAct.do?document=" %>' 
	uploadurl=''
	updatable='false'
	documentid='0'>
</july:wordEditSlave>

