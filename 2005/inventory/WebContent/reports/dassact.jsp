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
	String prompt1 = request.getParameter("prompt1");
	engine.setPrompt(new Object[]{new java.lang.Long(prompt1)});
	new AssactReport().getReportData( engine, "configs" );
%>
<%if(engine.getData() == null) {%>
		<B>Ошибка выполнения см. лог</B>
<%}else if(engine.getData().length == 0) {%>
		<B>Нет данных</B>
<%}else{%>
<DIV class=Section1 STYLE="FONT-FAMILY: Arial,Verdana; FONT-SIZE: 10pt; line-height:100%">
 
<table border="0" width="100%">
<tr style="font-size: 10pt;">
	<th align="center">
		АКТ N <U><%=  engine.getData(0,"blanknumber") %></U>
		от <U><%=  engine.getDateStr(0,"blankdate") %></U> г.
	</th>
</tr>
<tr style="font-size: 10pt;">
	<td align="center">
		<B>демонтажа аппаратуры на складе &quot;</B> <U><%=  engine.getData(0,"storagename") %></U> <B>&quot;</B>
	</td>
</tr>
<tr><td>&nbsp;</td></tr>
<tr style="font-size: 10pt;">
	<td align="center">
		<B>Мы, нижеподписавшиеся, произвели монтаж аппаратуры находящейся на складе, блоками, указанными в приведенной ниже таблице.</B>
	</td>
</tr>
</table>


<P>&nbsp;</P>
<!-- Table data -->
<table border=1 style='border-collapse:collapse;border:none;mso-border-alt:solid silver .5pt;mso-padding-alt:0cm 5.4pt 0cm 5.4pt' width="100%">
	<tr>
			<th>№ п/п</th>
			<th>Тип<BR>блока</th>
			<th>Заводской N</th>
			<th>Цена<BR>блока</th>
			<th>Тип монтируемой<BR>аппаратуры</th>
			<th>Заводской N</th>
			<th>Счет</th>
			<th>Примечание</th>
	</tr>
<% for (int i = 0; i < engine.getData().length; i++) { %>
	<tr>
			<td><%= engine.getData(i,"iorder") %></td>
			<td><%= engine.getData(i,"bloktype") %></td>
			<td><%= engine.getData(i,"serno") %></td>
			<td><%= engine.getData(i,"price") %></td>
			<td><%= engine.getData(i,"itemtype") %></td>
			<td><%= engine.getData(i,"iserno") %></td>
			<td><%= engine.getData(i,"schnum") %></td>
			<td><%= engine.getData(i,"describe") %></td>
	</tr>
<% } %>
</table>
<P>&nbsp;</P>

<table width="100%">
<tr style="font-size: 10pt;">
	<td width="40%"><B>Демонтаж произвели:</B></td>
	<td width="10%">&nbsp;</td>
	<td width="20%" nowrap style="border-bottom: solid black .5pt;"><%= engine.getData(0,"inuser1") %></td>
	<td width="10%">&nbsp;</td>
	<td width="20%" style="border-bottom: solid black .5pt;">&nbsp;</td>
</tr>
<tr style="font-size: 8pt;">
	<td width="40%">&nbsp;</td>
	<td width="10%">&nbsp;</td>
	<td width="20%" align="center">(Ф. И. О)</td>
	<td width="10%">&nbsp;</td>
	<td width="20%" align="center">(подпись)</td>
</tr>
<tr style="font-size: 10pt;">
	<td width="40%">&nbsp;</td>
	<td width="10%" nowrap>&nbsp;</td>
	<td width="20%" nowrap style="border-bottom: solid black .5pt;"><%= engine.getData(0,"inuser2") %></td>
	<td width="10%">&nbsp;</td>
	<td width="20%" style="border-bottom: solid black .5pt;">&nbsp;</td>
</tr>
<tr style="font-size: 8pt;">
	<td width="40%">&nbsp;</td>
	<td width="10%">&nbsp;</td>
	<td width="20%" align="center">(Ф. И. О)</td>
	<td width="10%">&nbsp;</td>
	<td width="20%" align="center">(подпись)</td>
</tr>
<tr style="font-size: 10pt;">
	<td width="40%"><B>Указанные в таблице блоки со склада</B> <U><%= engine.getData(0,"storagename") %></U></td>
	<td width="10%" nowrap><B>получил:</B></td>
	<td width="20%" nowrap style="border-bottom: solid black .5pt;"><%= engine.getData(0,"pruser") %></td>
	<td width="10%">&nbsp;</td>
	<td width="20%" style="border-bottom: solid black .5pt;">&nbsp;</td>
</tr>
<tr style="font-size: 8pt;">
	<td width="40%">&nbsp;</td>
	<td width="10%">&nbsp;</td>
	<td width="20%" align="center">(Ф. И. О)</td>
	<td width="10%">&nbsp;</td>
	<td width="20%" align="center">(подпись)&nbsp;&nbsp;&nbsp;(дата)</td>
</tr>
</table>
  <%----%>

<%-- 
<!-- Темповые данные -->
<%@include file="aReport.jsp"%>
<!-- end Темповые данные -->
 --%>

</DIV>
<% } %>
</body>
</html>
