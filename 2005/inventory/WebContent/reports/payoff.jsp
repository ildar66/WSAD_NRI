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
	{size:841.9pt 595.3pt;
	mso-page-orientation:landscape;
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
	String prompt1 = request.getParameter("prompt1");
	PayoffReport report = new PayoffReport(new Integer(prompt1));	
	report.processReport();
%>
<%if(report.isError()) {%>
		<B>Ошибка выполнения см. лог</B>
<%}else if(report.getDataSize() == 0) {%>
		<B>Нет данных</B>
<%}else{%>
<DIV class=Section1 STYLE="FONT-FAMILY: Arial,Verdana; FONT-SIZE: 10pt; line-height:100%">

<table border="0" width="100%">
<tr style="font-size: 10pt;">
	<th align="center">
		Приложение к акту инвентаризации №<U><%=  report.getHeader("blanknumber") %></U>
		от <U><%=  report.getHeader("blankdate") %></U> г.
	</th>
</tr>
<tr><td>&nbsp;</td></tr>
<tr style="font-size: 10pt;">
	<td align="center">
		<B>Перечень оборудования, отсутствие которого выявлено по результатам инвентаризации.</B>
	</td>
</tr>
</table>


<P>&nbsp;</P>
<!-- Table data -->
<table border=1 style='border-collapse:collapse;border:none;mso-border-alt:solid silver .5pt;mso-padding-alt:0cm 5.4pt 0cm 5.4pt' width="100%">
	<tr>
			<th>№ п/п</th>
			<th>Наименование</th>
			<th>Заводской № / № партии</th>
			<th>Кол-во</th>
			<th>Цена</th>
			<th>Сумма</th>
	</tr>
<% for (int i = 0; i < report.getDataSize(); i++) { %>
	<tr>
			<td><%= report.getData(i,"order") %></td>
			<td><%= report.getData(i,"name") %></td>
			<td><%= report.getData(i,"invnum") %></td>
			<td><%= report.getData(i,"qty") %></td>
			<td><%= report.getData(i,"price") %></td>
			<td><%= report.getData(i,"summ") %></td>
	</tr>
<% } %>
</table>
<P>&nbsp;</P>

<table width="100%">
<tr style="font-size: 10pt;">
	<td width="30%">Инвентаризацию провел:</td>
	<td width="10%">&nbsp;</td>
	<td width="25%" nowrap style="border-bottom: solid black .5pt;"><%= report.getHeader("iuser1") %></td>
	<td width="10%">&nbsp;</td>
	<td width="25%" style="border-bottom: solid black .5pt;">&nbsp;</td>
</tr>
<tr style="font-size: 8pt;">
	<td width="30%">&nbsp;</td>
	<td width="10%">&nbsp;</td>
	<td width="25%" align="center">(Ф. И. О)</td>
	<td width="10%">&nbsp;</td>
	<td width="25%" align="center">(подпись)</td>
</tr>
<tr style="font-size: 10pt;">
	<td width="30%">&nbsp;</td>
	<td width="10%" nowrap>&nbsp;</td>
	<td width="25%" nowrap style="border-bottom: solid black .5pt;"><%= report.getHeader("iuser2") %></td>
	<td width="10%">&nbsp;</td>
	<td width="25%" style="border-bottom: solid black .5pt;">&nbsp;</td>
</tr>
<tr style="font-size: 8pt;">
	<td width="30%">&nbsp;</td>
	<td width="10%">&nbsp;</td>
	<td width="25%" align="center">(Ф. И. О)</td>
	<td width="10%">&nbsp;</td>
	<td width="25%" align="center">(подпись)</td>
</tr>
</table>
  

</DIV>
<% } %>
</body>
</html>
