<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%
    String num = "" + Math.round(Math.random()*100);
    String wndname = request.getParameter("wndname");
    if (wndname == null)
        wndname = "wind" + num; 
%>

<!DOCTYPE html public "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
  <META content="text/html; charset=windows-1251" http-equiv=Content-Type>
	<TITLE>NRI Система учета сетевых ресурсов</TITLE>
<script language="JavaScript">
<!--

   if (window.name!="<%= wndname %>") (opener = open("/index1.jsp?wndname=<%= wndname %>","<%= wndname %>", "top=0, left=0, height=" + (screen.availHeight-30) + ", width=" + (screen.availWidth-10) + ", fullscreen=no,location=no,menubar=no,resizable=yes,scrollbars=yes,status=yes,titlebar=yes,toolbar=no"));
   //if (window.name=="<%= wndname %>") window.location.href="/ShowTaskList.do"

//-->
</script>

<SCRIPT language="Javascript"><!-- hide    
    
   if (document.images) {

    zimg1=new Image(1,1);
    zimg1.src="images/main.gif";

    zimg2=new Image(1,1);
    zimg2.src="images/main2.gif";
}

  function showInfo(ImgIn, ImgOut) {
  if (document.images) {
  document.images[ImgIn].src = eval(ImgOut + ".src")
}
}
// -->
</SCRIPT>
</HEAD>

<MAP name="all">
<AREA href="/index1.jsp" style="filter:wave;" onMouseOver="showInfo('zimg1','zimg2')" onMouseOut="showInfo('zimg1','zimg1')" coords="300,185,550,185,550,207,300,207" shape="poly" alt="?????? ?????? ? ????????">
</MAP>
  <BODY bgcolor="D6EBFF">
<TABLE width="100%" height="100%">
	<TR>
		<TD align="center"><IMG src="images/main.gif" name="zimg1" border="0" alt="" usemap="#all"></TD>
	</TR>
</TABLE>
 <FONT face="Verdana, Arial" size=2>????? ??????????????? ??????????? ???. 42-16, 42-56<FONT>
  </BODY>
</HTML>
