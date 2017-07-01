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
	new ExternalRReport().getReportData( engine, "configs" );
%>
<%if(engine.getData() == null) {%>
		<B>Ошибка выполнения см. лог</B>
<%}else if(engine.getData().length == 0) {%>
		<B>Нет данных</B>
<%}else{%>
<DIV class=Section1 STYLE="FONT-FAMILY: Arial,Verdana; FONT-SIZE: 10pt; line-height:100%">

<table border="0" width="100%">
<tr style="font-size: 10pt;">
	<td align="left"><%-- =  engine.getData(0,"organizationname") --%></td>
	<td align="right"><%=  engine.getDateStr(0,"blankdate") %></td>
</tr>
<tr style="font-size: 10pt;">
	<th colspan="2">Накладная № <U><%=  engine.getData(0,"blanknumber") %></U></th> 
</tr>
<tr style="font-size: 10pt;">
	<td align="left" colspan="2"><B>Кому</B> <%=  engine.getData(0,"ocustoner") %></td>
</tr>
<tr style="font-size: 10pt;">
	<td align="left"><B>Для монтажа на позицию</B> <%=  engine.getData(0,"position") %></td>
	<td align="right">&quot;Отпуск разрешаю&quot;</td>
</tr>
<tr style="font-size: 10pt;">
	<td align="left"><B>От кого</B>  <%=  engine.getData(0,"icustoner") %></td>
	<td align="right">/С.М.Авдеев/</td>
</tr>
<tr style="font-size: 10pt;">
	<td colspan="2"><B>Документы</B> <%=  engine.getData(0,"docs") %></td>
</tr>
<tr style="font-size: 10pt;">
	<td colspan="2"><%=  engine.getData(0,"describe") %></td>
</tr>
</table>
<P>&nbsp;</P>

<!-- Table data -->
<table border=1 style='border-collapse:collapse;border:none;mso-border-alt:solid silver .5pt;mso-padding-alt:0cm 5.4pt 0cm 5.4pt' width="100%">
	<tr>
			<th>№ п/п</th>
			<th>Наименование</th>
			<th>Кол-во</th>
			<th>Зав. N</th>
			<th>Цена за ед.</th>
			<th>Сумма</th>
	</tr>
<% for (int i = 0; i < engine.getData().length; i++) { %>
	<tr>
			<td><%= engine.getData(i,"iorder") %></td>
			<td><%= engine.getData(i,"name") %></td>
			<td><%= engine.getData(i,"qty") %></td>
			<td><%= engine.getData(i,"serno") %></td>
			<td><%= engine.getData(i,"price") %></td>
			<td><%= engine.getData(i,"suma") %></td>
	</tr>
<% } %>
</table>
<P>&nbsp;</P>
<table border="0" width="100%">
<tr style="font-size: 10pt;">
	<td width="25%" nowrap><B>Сдал</B></td>
	<td width="25%" nowrap><U><%= engine.getData(0,"outuser") %></U></td>
	<td width="25%" nowrap><B>Принял</B></td>
	<td width="25%" nowrap><U><%= engine.getData(0,"inuser") %></U></td>
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
