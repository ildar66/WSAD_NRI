<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.constants.*,com.hps.july.arenda.*" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<html>
<head>
	<META HTTP-EQUIV = "Pragma" CONTENT="no-cache">
	<title>Лицензии</title>
	<link rel="stylesheet" type="text/css" href="/main.css">
</head>

<FRAMESET id="main" ROWS="135,20,*,20" frameborder="no" framespacing=0>
	<FRAME frameborder=0 src="top.jsp?param=1" name="top" marginwidth=0 marginheight=0 style="border-bottom: 0px #000000 solid;" scrolling=no>
	<FRAMESET id="headers" COLS="30%,*,16px" frameborder="no" framespacing=0>
		<FRAME frameborder=0 src="headers_left.jsp" name="headers_left" marginwidth=0 marginheight=0 scrolling=no>
		<FRAME frameborder=0 src="headers_right.jsp" name="headers_right" marginwidth=0 marginheight=0 scrolling=no>
		<FRAME frameborder=0 name="right" marginwidth=0 marginheight=0 style="border: 0px #000000 solid; background-color: rgb(D6EBFF)" scrolling=no> 
	</FRAMESET>
	<FRAMESET id="content" COLS="30%,*" frameborder="no" framespacing=0>
		<FRAME frameborder=0 src="scroll_left.jsp" name="scroll_left" marginwidth=0 marginheight=0 style="border: 0px #000000 solid;" scrolling="yes">
		<FRAME frameborder=0 src="scroll_right.jsp" name="scroll_right" marginwidth=0 marginheight=0 style="border: 0px #000000 solid;" scrolling="yes">
	</FRAMESET>
	<FRAME frameborder=0 src="bottom.jsp?param=1" name="bottom" marginwidth=0 marginheight=0 scrolling=no>
</FRAMESET>

</HTML>
