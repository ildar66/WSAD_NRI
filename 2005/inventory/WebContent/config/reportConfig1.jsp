<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%
	response.setHeader("Cache-Control", "no-cache");
	response.setContentType("application/msword;name=reportChanges.doc;charset=Windows-1251");
	response.setHeader("Content-Disposition", "attachment;filename=reportChanges.doc");
%>
<html xmlns:o="urn:schemas-microsoft-com:office:office"
xmlns:w="urn:schemas-microsoft-com:office:word"
xmlns="http://www.w3.org/TR/REC-html40">
<head>
  <meta http-equiv="Content-Type" content="application/msword;name=reportChanges.doc;charset=Windows-1251">
  <meta http-equiv="Content-Disposition" content="attachment;filename=reportChanges.doc">
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
<DIV class=Section1 STYLE="FONT-FAMILY: Arial,Verdana; FONT-SIZE: 10pt; line-height:100%">

<DIV STYLE="FONT-FAMILY: Arial,Verdana; FONT-SIZE: 16pt;" ALIGN="CENTER">
	Отчет по текущей конфигурации оборудования <BR>
	Функционального комплекта "Базовая станция" <BR>
	<%= request.getAttribute("bsnumber") %> <%= request.getAttribute("bsname") %>
</DIV>

<P>&nbsp;</P>
 
<table border="0">
<tr style="font-size: 10pt;">
	<th><B>Дата отчета:</B></th>
	<td><%= request.getAttribute("repdate") %></td>
</tr>
<tr style="font-size: 10pt;">
	<th><B>Пользователь:</B></th>
	<td><%= request.getAttribute("repuser") %></td>
</tr>
</table>

<P>&nbsp;</P>

<DIV style="font-size: 10pt;"><B>1. Оборудование в секторах</B></DIV>
<table border="1">
<tr style="font-size: 10pt;">
	<th ROWSPAN="2"></th>
	<th COLSPAN="5"><B>Сектора 900</B></th>
	<th COLSPAN="5"><B>Сектора 1800</B></th>
</tr>
<tr style="font-size: 10pt;">
	<th><B>O</B></th>
	<th><B>E</B></th>
	<th><B>F</B></th>
	<th><B>G</B></th>
	<th><B>H</B></th>
	<th><B>O</B></th>
	<th><B>A</B></th>
	<th><B>B</B></th>
	<th><B>C</B></th>
	<th><B>D</B></th>
</tr>
<tr style="font-size: 10pt;">
	<th><B>Трансиверы</B></th>
	<td><%= request.getAttribute("trxo") %></td>
	<td><%= request.getAttribute("trxe") %></td>
	<td><%= request.getAttribute("trxf") %></td>
	<td><%= request.getAttribute("trxg") %></td>
	<td><%= request.getAttribute("trxh") %></td>
	<td><%= request.getAttribute("trxo1800") %></td>
	<td><%= request.getAttribute("trxa") %></td>
	<td><%= request.getAttribute("trxb") %></td>
	<td><%= request.getAttribute("trxc") %></td>
	<td><%= request.getAttribute("trxd") %></td>
</tr>
<tr style="font-size: 10pt;">
	<th><B>Антенны</B></th>
	<td><%= request.getAttribute("anto") %></td>
	<td><%= request.getAttribute("ante") %></td>
	<td><%= request.getAttribute("antf") %></td>
	<td><%= request.getAttribute("antg") %></td>
	<td><%= request.getAttribute("anth") %></td>
	<td><%= request.getAttribute("anto1800") %></td>
	<td><%= request.getAttribute("anta") %></td>
	<td><%= request.getAttribute("antb") %></td>
	<td><%= request.getAttribute("antc") %></td>
	<td><%= request.getAttribute("antd") %></td>
</tr>
</table>

<P>&nbsp;</P>

<DIV style="font-size: 10pt;"><B>2. Оборудование по количеству</B></DIV>
<table border="1" width="100%">
<tr style="font-size: 10pt;">
	<th><B>№ п/п</B></th>
	<th><B>Категория оборудования</B></th>
	<th><B>Кол-во, шт</B></th>
</tr>
<%
	java.util.List summaryEquipList = (java.util.List)request.getAttribute("summaryEquipList");
	java.util.Iterator it = summaryEquipList.iterator();
	while (it.hasNext()) {
		com.hps.july.config.model.ReportConfig1VO vo = (com.hps.july.config.model.ReportConfig1VO)it.next();
		
%>
<tr style="font-size: 10pt;">
	<td align="right"><%= vo.getNumindex() %></td>
	<td><%= vo.getCategory() %></td>
	<td align="right"><%= vo.getQty() %></td>
</tr>
<%
	}
%>
</table>


</DIV>
</body>
</html>
