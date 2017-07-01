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
	Engine engine = new Engine();
	String prompt1 = request.getParameter("prompt1");
	engine.setPrompt(new Object[]{new java.lang.Long(prompt1)});
	new InWayBillReport().getReportData( engine, "configs" );
%>
<%if(engine.getData() == null) {%>
		<B>Ошибка выполнения см. лог</B>
<%}else if(engine.getData().length == 0) {%>
		<B>Нет данных</B>
<%}else{%>
<DIV class=Section1 STYLE="FONT-FAMILY: Arial,Verdana; FONT-SIZE: 10pt; line-height:100%">

<table border="0" width="100%">
<tr style="font-size: 10pt;">
	<td width="50%"><B>ПРИХОДНЫЙ ОРДЕР</B></td>
	<td><B>Склад</B>  <%=  engine.getData(0,"storagename") %></td>
</tr>
</table>

<!-- Table header -->
<table border=1 style='border-collapse:collapse;border:none;mso-border-alt:solid silver .5pt;mso-padding-alt:0cm 5.4pt 0cm 5.4pt' width="100%">
	<tr>
			<th>Номер документа</th>
			<th>Дата</th>
			<th>Номер сопроводительного<BR> документа</th>
			<th colspan="2" >Дата сопроводительного<BR> документа</th>
			<th>№ ГТД</th>
			<th colspan="2" >Рег. № в бухгалтерии</th>
	</tr>
	<tr>
			<th><%= engine.getData(0, "blanknumber") %></th>
			<td><%= engine.getDateStr(0, "blankdate") %></td>
			<td><%= engine.getData(0,"cordocnum") %></td>
			<td colspan="2" ><%= engine.getDateStr(0,"cordocdate") %></td>
			<td><%= engine.getData(0,"gtdnumber") %></td>
			<td colspan="2" ><%= engine.getData(0,"platinumnum") %></td>
	</tr>
	<tr>
			<th rowspan="2">Поставщик</th>
			<td colspan="2" rowspan="2"><%= engine.getData(0,"organizationname") %></td>
			<td rowspan="2" width="10%">Контракт </td>
			<td rowspan="2" colspan="3" ><%= engine.getData(0,"contrname") %></td>
			<td width="10%">Валюта: </td>
	</tr>
	<tr>
			<td  width="10%"><%= engine.getData(0,"currname") %></td>
	</tr>
</table>
<P>&nbsp;</P>

<!-- Table data -->
<table border=1 style='border-collapse:collapse;border:none;mso-border-alt:solid silver .5pt;mso-padding-alt:0cm 5.4pt 0cm 5.4pt' width="100%">
	<tr>
			<th rowspan="2">№</th>
			<th rowspan="2">Наименование</th>
			<th rowspan="2">Ед.<BR>изм</th>
			<th colspan="2">Количество</th>
			<th colspan="2">Цена</th>
			<th colspan="2">Сумма</th>
			<th rowspan="2">Заводской<BR> (инвентарный)<BR> №/<BR>№ партии</th>
	</tr>
	<tr>
			<th>По<BR> д-ту</th>
			<th>По<BR> факту</th>
			<th>По<BR> д-ту</th>
			<th>По<BR> факту</th>
			<th>По<BR> д-ту</th>
			<th>По<BR> факту</th>
	</tr>
<% for (int i = 0; i < engine.getData().length; i++) { %>
	<tr>
			<td><%= engine.getData(i, "iorder") %></td>
			<td><%= engine.getData(i, "name") %></td>
			<td><%= engine.getData(i, "unitname") %></td>
			<td><%= engine.getData(i, "docqty") %></td>
			<td><%= engine.getData(i, "factqty") %></td>
			<td><%= engine.getData(i, "docprice") %></td>
			<td><%= engine.getData(i, "factprice") %></td>
			<td><%= engine.getData(i, "docsum") %></td>
			<td><%= engine.getData(i, "factsum") %></td>
			<td><%= engine.getData(i, "serno") %></td>
	</tr>
<% } %>
</table>
<P>&nbsp;</P>

<table border="0" width="100%">
<tr style="font-size: 10pt;">
	<td width="10%" nowrap><B>Сдал</B></td>
	<td width="17%" nowrap><U><%= engine.getData(0,"ouser") %></U></td>
	<td width="7%" nowrap>_____________</td>
	<td width="17%" nowrap><B style="font-size: 7pt;">фамилия, подпись </B></td>
	<td width="10%" nowrap><B>/  Принял</B></td>
	<td width="17%" nowrap><U><%= engine.getData(0,"iuser") %></U></td>
	<td width="7%" nowrap>_____________</td>
	<td width="17%" nowrap><B style="font-size: 7pt;">фамилия, подпись</B></td>
</tr>
</table>

<%--
<!-- Темповые данные -->
<%@include file="aReport.jsp"%>
<!-- end Темповые данные -->
 --%>

</DIV>
<% } %>
</body>
</html>
