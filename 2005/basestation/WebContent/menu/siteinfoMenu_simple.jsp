<%@ page language="java" buffer="1kb"%>
<%@ page import="java.util.*,org.apache.struts.util.MessageResources,org.apache.struts.action.Action"%>
<%@ page import="com.hps.july.jdbcpersistence.lib.AppConstants"%>
<%@ page import="com.hps.july.constants.Applications"%>
<%@ page import="com.hps.july.web.util.*,com.hps.july.util.*,com.hps.july.siteinfo.*"%>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<html:html>
<head>
<META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=windows-1251">
<TITLE>NRI ����</TITLE> 
<%--<jsp:include page = "browser_detection.jsp" flush="true"/>--%>
<!-- �����: -->
<%@ include file = "navtree_js.jsp" %>
</head>

<body class="navtree">
<script type="text/javascript" language="JavaScript" src="/scripts/aptree.js"></script>
<script type="text/javascript" language="JavaScript" src="/scripts/aptreeState.js"></script>
<script type="text/javascript" language="JavaScript1.2">
	setShowExpanders(true);
	setExpandDepth(1);
	setKeepState(true);
	setShowHealth(false);
	setInTable(false);
	//setTargetFrame("_top");
	openFolder = "/images/open_folder.gif";
	closedFolder = "/images/closed_folder.gif";
	plusIcon = "/images/lplus.gif";
	minusIcon = "/images/lminus.gif";
	blankIcon = "/images/blank20.gif";
</script>

<script type="text/javascript" language="JavaScript1.2">
	root_domain = addRoot('/images/Domain.gif', '�������� �������:','');
	item1 = addItem(root_domain, "/images/onepix.gif", "�������", '<%= "/siteinfo/ShowPositionList.do?navclear=1&rootapp="+Applications.SITEINFO+"&rootstate="+APPStates.POSLIST %>');
	<%
		String id = request.getRemoteUser();
		String trailcomUrl = com.hps.july.util.AppUtils.getNamedValueString("PathPositionTableTrailcom") + "?id=" + id; 
		String trailcomMapUrl = com.hps.july.util.AppUtils.getNamedValueString("PathMapTrailcom") + "?id=" + id; 
	%>
	item2 = addItem(root_domain, "/images/onepix.gif", "�������(��������� �������������)", '<%= trailcomUrl %>');
	item2.targetFrame="_blank";
	item3 = addItem(root_domain, "/images/onepix.gif", "������ � ������", '<%= trailcomMapUrl%>');
	item3.targetFrame="_blank";
	item4 = addItem(root_domain, "/images/onepix.gif", "�������", '<%= "/siteinfo/ShowSuperRegionList.do?navclear=1&rootapp="+Applications.SITEINFO +"&rootstate="+APPStates.SREGIONLIST%>');
	item5 = addItem(root_domain, "/images/onepix.gif", "�������", '<%= "/siteinfo/ShowRegionList.do?navclear=1&rootapp="+Applications.SITEINFO+"&rootstate="+APPStates.REGIONLIST%>');
	item6 = addItem(root_domain, "/images/onepix.gif", "���� ����", '<%= "/siteinfo/ShowNetzoneList.do?navclear=1&rootapp="+Applications.SITEINFO+"&rootstate=" +APPStates.NZONELIST%>');
	item7 = addItem(root_domain, "/images/onepix.gif", "���� ���������������", '<%= "/siteinfo/ShowTyperesponsibilityList.do?navclear=1&rootapp="+Applications.SITEINFO+"&rootstate=" +APPStates.TRSPLIST%>');
	item8 = addItem(root_domain, "/images/onepix.gif", "���� ����������", '<%= "/siteinfo/ShowSiteDocTypeList.do?navclear=1&rootapp="+Applications.SITEINFO+"&rootstate=" +APPStates.SiteDocTypeListForm %>');
	item9 = addItem(root_domain, "", "����� ���������� ������", '<%= "/siteinfo/ShowAntennaPlacesList.do?navclear=1"%>');
	item10 = addItem(root_domain, "", "����� ���������� ����", '<%= "/siteinfo/ShowOporaPlacesList.do?navclear=1" %>');
	item11 = addItem(root_domain, "", "���� ��������� ����������", '<%= "/siteinfo/ShowApparatPlaceTypesList.do?navclear=1" %>');
	item12 = addItem(root_domain, "", "���� ����������", '<%= "/siteinfo/ShowApparatTypesList.do?navclear=1"%>'); 
	item13 = addItem(root_domain, "", "����� ���������� ����������", '<%= "/siteinfo/ShowApparatPlacesList.do?navclear=1"%>'); 
	<%if(request.isUserInRole("administrator") || request.isUserInRole("electroCounterViewer") || request.isUserInRole("electroCounterEditor")) {%>
		item14 = addItem(root_domain, "", "���������������", ''); 
		item141 = addItem(item14, "", "���� ����������������", '<%= "/siteinfo/ShowElectroCounterInfoList.do?navclear=1"%>'); 
		item142= addItem(item14, "", "����� ����������", '<%= "/siteinfo/ShowElectroCounterList.do?navclear=1"%>'); 
	<%}%>
	<% if( com.hps.july.util.AppUtils.isMicrostrategyAccess(request.getRemoteUser()) ) {
			String url = URLUtil.getMicrostrategyURL(request);
	 %>
		item15 = addItem(root_domain, "", "������ MS", '<%=url%>'); 
		item15.targetFrame="_blank";
	<%}%>
</script>

<script type="text/javascript" language="JavaScript1.2">
	initialize()
</script>

</body>
</html:html>