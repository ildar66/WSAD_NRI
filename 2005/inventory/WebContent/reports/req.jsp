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
	new RequestReport().getReportData( engine, "configs" );
%>
<%if(engine.getData() == null) {%>
		<B>Ошибка выполнения см. лог</B>
<%}else if(engine.getData().length == 0) {%>
		<B>Нет данных</B>
<%}else{%>
<DIV class=Section1 STYLE="FONT-FAMILY: Arial,Verdana; FONT-SIZE: 10pt; line-height:100%">


<table border="0" width="100%">
<tr style="font-size: 10pt;">
	<th align="left">
		ТРЕБОВАНИЕ № <U><%=  engine.getData(0,"blanknumber") %></U>
		от <U><%=  engine.getDateStr(0,"blankdate") %></U> г.
	</th>
</tr>
<tr style="font-size: 10pt;">
	<td align="left"><B>Организция/Специалист</B> <U><%=  engine.getData(0,"orgname") %></U></td>
</tr>
<tr style="font-size: 10pt;">
	<td align="left">
		<B>ФИО получателя</B> <U><%=  engine.getData(0,"customer") %></U><B>№ автомашины</B>  <U><%=  engine.getData(0,"numauto") %></U>
	</td>
</tr>
<tr style="font-size: 10pt;">
	<td align="left">
		<B>Объект №</B>  <U><%=  engine.getData(0,"objnum") %></U> <B>&quot;</B> <U><%=  engine.getData(0,"objname") %></U> 	<B>&quot;  адрес</B> <U><%=  engine.getData(0,"address") %></U>
	</td>
</tr>
</table>
<P>&nbsp;</P>

<!-- Table data -->
<table border=1 style='border-collapse:collapse;border:none;mso-border-alt:solid silver .5pt;mso-padding-alt:0cm 5.4pt 0cm 5.4pt' width="100%">
	<tr>
			<th rowspan="2">Оборудование</th>
			<th colspan="2">Кол-во</th>
			<th rowspan="2">Примечание</th>
	</tr>
	<tr>
			<th>затребовано</th>
			<th>отпущено</th>
	</tr>
<% for (int i = 0; i < engine.getData().length; i++) { %>
	<tr>
			<td><%= engine.getData(i,"name") %></td>
			<td><%= engine.getData(i,"docqty") %></td>
			<td><%= engine.getData(i,"factqty") %></td>
			<td><%= engine.getData(i,"describe") %></td>
	</tr>
<% } %>
</table>
<P>&nbsp;</P>

<table border="0" width="100%">
<tr style="font-size: 10pt;">
	<td colspan="2" nowrap>
		<B>Требование составил</B><U><%= engine.getData(0,"pruser") %></U>
	</td>
</tr>
<tr style="font-size: 10pt;">
	<td nowrap>
		<B>Отпустил</B><U><%= engine.getData(0,"outuser") %></U>
	</td>
	<td nowrap>
		<B>Принял</B><U><%= engine.getData(0,"inuser") %></U>
	</td>
</tr>
</table>
<%-- --%>

 <%--
<!-- Темповые данные -->
<%@include file="aReport.jsp"%> 
<!-- end Темповые  данные -->
 --%>

</DIV>
<% } %>
</body>
</html>
