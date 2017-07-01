<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ page import="com.hps.july.report.word.*" %>
<%
	response.setHeader("Cache-Control", "no-cache");
	response.setContentType("application/msword;name=reportWord.doc;charset=Windows-1251");
	response.setHeader("Content-Disposition", "attachment;filename=reportWord.rtf");
%>
<html xmlns:o="urn:schemas-microsoft-com:office:office"
xmlns:w="urn:schemas-microsoft-com:office:word"
xmlns="http://www.w3.org/TR/REC-html40">
<head>
  <meta http-equiv="Content-Type" content="application/msword;name=reportWord.doc;charset=Windows-1251">
  <meta http-equiv="Content-Disposition" content="attachment;filename=reportWord.rtf">
  <meta name=ProgId content=Word.Document>
  <title>reportWord</title>
<STYLE>  
@page Section1
	{size:595.3pt 841.9pt;
	margin:1.0cm 2.5cm 1.0cm 2.5cm;
	mso-header-margin:35.45pt;
	mso-footer-margin:35.45pt;
	mso-paper-source:0;}
div.Section1
	{page:Section1;} 
p
	{mso-style-parent:"";
	margin:0cm;
	margin-top: 0cm;
	margin-bottom:.0001pt;
	mso-pagination:widow-orphan;
	}

TABLE {
	FONT-FAMILY: Arial,Verdana; FONT-SIZE: 10pt;  line-height: 100%;
}

TD.tsilver {
	border:solid silver .5pt;
	border-right:none;
	background: #EAEAEA;
	padding:0cm 5.4pt 0cm 5.4pt;
}

<!--[if gte mso 9]>
<xml>
 <w:WordDocument>
  <w:View>Print</w:View>
  <w:DoNotOptimizeForBrowser/>
 </w:WordDocument>
</xml>
<![endif]-->

</STYLE>
</head> 

<body>
<%
	Engine engine = new Engine();
	String prompt1 = request.getParameter("prompt1");//"81007"
	engine.setPrompt(new Object[]{new java.lang.Long(prompt1)});
	new InternalReport().getReportData( engine, "configs" );
%>
<%if(engine.getData().length == 0) {%>
		<B>��� ������</B>
<%}else{%>
<DIV class=Section1 STYLE="FONT-FAMILY: Arial,Verdana; FONT-SIZE: 10pt; line-height:100%">

<table border="0" width="100%">
<tr style="font-size: 10pt;">
	<td width="50%"><B>��������� �����</B></td>
	<td><B>�����</B>  <%=  engine.getData(0,3) %></td>
</tr>
</table>

<!-- Table header -->
<table border=1 style='border-collapse:collapse;border:none;mso-border-alt:solid silver .5pt;mso-padding-alt:0cm 5.4pt 0cm 5.4pt' width="100%">
	<tr>
			<th>����� ���������</th>
			<th>����</th>
			<th>�����������������<BR>����</th>
			<th colspan="2">���. ����� � �����������</th>
	</tr>
	<tr>
			<th><%= engine.getData(0, 1) %></th>
			<td><%= engine.getDateStr(0, 2) %></td>
			<td>&nbsp;</td>
			<td colspan="2"><%= engine.getData(0,6) %></td>
	</tr>
	<tr>
			<th rowspan="2">����������������<BR> ���������</th>
			<td colspan="3" rowspan="2"><%= engine.getData(0,4) %></td>
			<td width="15%">������: </td>
	</tr>
	<tr>
			<td><%= engine.getData(0,5) %></td>
	</tr>
	<tr>
			<th>���������/<BR>�������</th>
			<td colspan="4"><%= engine.getData(0,7) %></td>
	</tr>
</table>
<P>&nbsp;</P>

<!-- Table data -->
<table border=1 style='border-collapse:collapse;border:none;mso-border-alt:solid silver .5pt;mso-padding-alt:0cm 5.4pt 0cm 5.4pt' width="100%">
	<tr>
			<th rowspan="2">�</th>
			<th rowspan="2">������������</th>
			<th rowspan="2">��.<BR>���</th>
			<th colspan="2">����������</th>
			<th rowspan="2">����</th>
			<th rowspan="2">�����</th>
			<th rowspan="2">���������<BR> (�����������)<BR> �/<BR>� ������</th>
	</tr>
	<tr>
			<th>��<BR> �-��</th>
			<th>��<BR> �����</th>
	</tr>
<% for (int i = 0; i < engine.getData().length; i++) { %>
	<tr>
			<td><%= engine.getData(i,10) %></td>
			<td><%= engine.getData(i,11) %></td>
			<td><%= engine.getData(i,12) %></td>
			<td><%= engine.getData(i,13) %></td>
			<td><%= engine.getData(i,14) %></td>
			<td><%= engine.getData(i,15) %></td>
			<td><%= engine.getData(i,16) %></td>
			<td><%= engine.getData(i,17) %></td>
	</tr>
<% } %>
</table>
<P>&nbsp;</P>
<table border="0" width="100%">
<tr style="font-size: 10pt;">
	<td width="10%" nowrap><B>����</B></td>
	<td width="17%" nowrap><U><%= engine.getData(0,8) %></U></td>
	<td width="7%" nowrap>______</td>
	<td width="17%" nowrap><B style="font-size: 7pt;">�������, ������� </B></td>
	<td width="10%" nowrap><B>/  ������</B></td>
	<td width="17%" nowrap><U><%= engine.getData(0,9) %></U></td>
	<td width="7%" nowrap>______</td>
	<td width="17%" nowrap><B style="font-size: 7pt;">�������, �������</B></td>
</tr>
</table>

<%-- 
<!-- �������� ������ -->
<%@include file="aReport.jsp"%>
<!-- end �������� ������ -->
--%>

</DIV>
<% } %>
</body>
</html>
