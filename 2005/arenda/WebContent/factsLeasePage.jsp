<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.constants.*,com.hps.july.arenda.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%String widthTop = "81";%>
<logic:equal name="FactsLeasePageForm" property="isDopFilter" value="true">
	<%widthTop = "162";%>
</logic:equal>

<html>
<head>
	<META HTTP-EQUIV = "Pragma" CONTENT="no-cache">
	<title><html:errors />Фактические данные по договорам Аренды</title>
	<%--link rel="stylesheet" type="text/css" href="/main.css"--%>
</head>

<FRAMESET id="main" ROWS="<%=widthTop%>,20,*,20" frameborder="no" framespacing=0>
	<FRAME frameborder=0 src="factsLeasePageTop.jsp?param=1" name="top" marginwidth=0 marginheight=0 style="border-bottom: 0px #000000 solid;" scrolling=no>
	<FRAMESET id="headers" COLS="35%,*,16px" frameborder="no" framespacing=0>
		<FRAME frameborder=0 src="factsLeasePageHeaders_left.jsp" name="headers_left" marginwidth=0 marginheight=0 scrolling=no>
		<FRAME frameborder=0 src="factsLeasePageHeaders_right.jsp" name="headers_right" marginwidth=0 marginheight=0 scrolling=no>
		<FRAME frameborder=0 name="right" marginwidth=0 marginheight=0 style="border: 0px #000000 solid; background-color: rgb(D6EBFF)" scrolling=no> 
	</FRAMESET>
	<FRAMESET id="content" COLS="35%,*" frameborder="no" framespacing=0>
		<FRAME frameborder=0 src="factsLeasePageScroll_left.jsp" name="scroll_left" marginwidth=0 marginheight=0 style="border: 0px #000000 solid;" scrolling="yes">
		<FRAME frameborder=0 src="factsLeasePageScroll_right.jsp" name="scroll_right" marginwidth=0 marginheight=0 style="border: 0px #000000 solid;" scrolling="yes">
	</FRAMESET>
	<FRAME frameborder=0 src="factsLeasePageBottom.jsp?param=1" name="bottom" marginwidth=0 marginheight=0 scrolling=no>
	
</FRAMESET>

</html>
