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

<DIV STYLE="FONT-FAMILY: Arial,Verdana; FONT-SIZE: 10pt;" ALIGN="RIGHT">
	Приложение №4
</DIV>

<DIV STYLE="FONT-FAMILY: Arial,Verdana; FONT-SIZE: 16pt;" ALIGN="CENTER">
	Акт монтажа АФС<BR>
	базовой станции № <%= request.getAttribute("bsnumber") %> <%= request.getAttribute("bsname") %>
</DIV>

<P>&nbsp;</P>

<DIV style="font-size: 10pt;"><B>1. Особенности:</B> <%= request.getAttribute("originals") %></DIV>
<DIV style="font-size: 10pt;"><B>2. Состав и параметры АФС:</B></DIV>
<table border="1" width="100%">
<tr style="font-size: 10pt;">
	<th rowspan="2"><B>Маркировка антенны</B></th>
	<th colspan="3"><B>A/E</B></th>
	<th colspan="3"><B>B/F</B></th>
	<th colspan="3"><B>C/G</B></th>
	<th colspan="3"><B>D/H</B></th>
</tr>
<tr style="font-size: 10pt;">
	<th><B>A</B></th>
	<th><B>B</B></th>
	<th><B>C</B></th>
	<th><B>A</B></th>
	<th><B>B</B></th>
	<th><B>C</B></th>
	<th><B>A</B></th>
	<th><B>B</B></th>
	<th><B>C</B></th>
	<th><B>A</B></th>
	<th><B>B</B></th>
	<th><B>C</B></th>
</tr>
<tr style="font-size: 10pt;">
	<td rowspan="4"><B>Марка антенны, Серийные номера антенн:</B></td>
	<td colspan="3"><%= request.getAttribute("resA") %></td>
	<td colspan="3"><%= request.getAttribute("resB") %></td>
	<td colspan="3"><%= request.getAttribute("resC") %></td>
	<td colspan="3"><%= request.getAttribute("resD") %></td>
</tr>
<tr style="font-size: 10pt;">
	<td colspan="3"><%= request.getAttribute("serialnumberAA") %></td>
	<td colspan="3"><%= request.getAttribute("serialnumberBA") %></td>
	<td colspan="3"><%= request.getAttribute("serialnumberCA") %></td>
	<td colspan="3"><%= request.getAttribute("serialnumberDA") %></td>
</tr>
<tr style="font-size: 10pt;">
	<td colspan="3"><%= request.getAttribute("serialnumberAB") %></td>
	<td colspan="3"><%= request.getAttribute("serialnumberBB") %></td>
	<td colspan="3"><%= request.getAttribute("serialnumberCB") %></td>
	<td colspan="3"><%= request.getAttribute("serialnumberDB") %></td>
</tr>
<tr style="font-size: 10pt;">
	<td colspan="3"><%= request.getAttribute("serialnumberAC") %></td>
	<td colspan="3"><%= request.getAttribute("serialnumberBC") %></td>
	<td colspan="3"><%= request.getAttribute("serialnumberCC") %></td>
	<td colspan="3"><%= request.getAttribute("serialnumberDC") %></td>
</tr>
<tr style="font-size: 10pt;">
	<td><B>Высота установки антенн, (м)</B></td>
	<td colspan="3"><%= request.getAttribute("hsetA") %></td>
	<td colspan="3"><%= request.getAttribute("hsetB") %></td>
	<td colspan="3"><%= request.getAttribute("hsetC") %></td>
	<td colspan="3"><%= request.getAttribute("hsetD") %></td>
</tr>
<tr style="font-size: 10pt;">
	<td><B>Азимут, (град.)</B></td>
	<td colspan="3"><%= request.getAttribute("azimutA") %></td>
	<td colspan="3"><%= request.getAttribute("azimutB") %></td>
	<td colspan="3"><%= request.getAttribute("azimutC") %></td>
	<td colspan="3"><%= request.getAttribute("azimutD") %></td>
</tr>
<tr style="font-size: 10pt;">
	<td><B>Механический угол наклона, (град.)</B></td>
	<td><%= request.getAttribute("naklAA") %></td>
	<td><%= request.getAttribute("naklAB") %></td>
	<td><%= request.getAttribute("naklAC") %></td>
	<td><%= request.getAttribute("naklBA") %></td>
	<td><%= request.getAttribute("naklBB") %></td>
	<td><%= request.getAttribute("naklBC") %></td>
	<td><%= request.getAttribute("naklCA") %></td>
	<td><%= request.getAttribute("naklCB") %></td>
	<td><%= request.getAttribute("naklCC") %></td>
	<td><%= request.getAttribute("naklDA") %></td>
	<td><%= request.getAttribute("naklDB") %></td>
	<td><%= request.getAttribute("naklDC") %></td>
</tr>
<tr style="font-size: 10pt;">
	<td><B>Радиочастотный кабель 1/2" (м)</B></td>
	<td><%= request.getAttribute("cable1AA") %></td>
	<td><%= request.getAttribute("cable1AB") %></td>
	<td><%= request.getAttribute("cable1AC") %></td>
	<td><%= request.getAttribute("cable1BA") %></td>
	<td><%= request.getAttribute("cable1BB") %></td>
	<td><%= request.getAttribute("cable1BC") %></td>
	<td><%= request.getAttribute("cable1CA") %></td>
	<td><%= request.getAttribute("cable1CB") %></td>
	<td><%= request.getAttribute("cable1CC") %></td>
	<td><%= request.getAttribute("cable1DA") %></td>
	<td><%= request.getAttribute("cable1DB") %></td>
	<td><%= request.getAttribute("cable1DC") %></td>
</tr>
<tr style="font-size: 10pt;">
	<td><B>Радиочастотный кабель 7/8" (м)</B></td>
	<td><%= request.getAttribute("cable2AA") %></td>
	<td><%= request.getAttribute("cable2AB") %></td>
	<td><%= request.getAttribute("cable2AC") %></td>
	<td><%= request.getAttribute("cable2BA") %></td>
	<td><%= request.getAttribute("cable2BB") %></td>
	<td><%= request.getAttribute("cable2BC") %></td>
	<td><%= request.getAttribute("cable2CA") %></td>
	<td><%= request.getAttribute("cable2CB") %></td>
	<td><%= request.getAttribute("cable2CC") %></td>
	<td><%= request.getAttribute("cable2DA") %></td>
	<td><%= request.getAttribute("cable2DB") %></td>
	<td><%= request.getAttribute("cable2DC") %></td>
</tr>
<tr style="font-size: 10pt;">
	<td><B>Радиочастотный кабель 1 1/4" (м)</B></td>
	<td><%= request.getAttribute("cable3AA") %></td>
	<td><%= request.getAttribute("cable3AB") %></td>
	<td><%= request.getAttribute("cable3AC") %></td>
	<td><%= request.getAttribute("cable3BA") %></td>
	<td><%= request.getAttribute("cable3BB") %></td>
	<td><%= request.getAttribute("cable3BC") %></td>
	<td><%= request.getAttribute("cable3CA") %></td>
	<td><%= request.getAttribute("cable3CB") %></td>
	<td><%= request.getAttribute("cable3CC") %></td>
	<td><%= request.getAttribute("cable3DA") %></td>
	<td><%= request.getAttribute("cable3DB") %></td>
	<td><%= request.getAttribute("cable3DC") %></td>
</tr>
<tr style="font-size: 10pt;">
	<td><B>Комплекты заземления, (шт.)</B></td>
	<td></td>
	<td></td>
	<td></td>
	<td></td>
	<td></td>
	<td></td>
	<td></td>
	<td></td>
	<td></td>
	<td></td>
	<td></td>
	<td></td>
</tr>
<tr style="font-size: 10pt;">
	<td><B>Маркировка фидеров</B></td>
	<td><%= request.getAttribute("cableresAA") %></td>
	<td><%= request.getAttribute("cableresAB") %></td>
	<td><%= request.getAttribute("cableresAC") %></td>
	<td><%= request.getAttribute("cableresBA") %></td>
	<td><%= request.getAttribute("cableresBB") %></td>
	<td><%= request.getAttribute("cableresBC") %></td>
	<td><%= request.getAttribute("cableresCA") %></td>
	<td><%= request.getAttribute("cableresCB") %></td>
	<td><%= request.getAttribute("cableresCC") %></td>
	<td><%= request.getAttribute("cableresDA") %></td>
	<td><%= request.getAttribute("cableresDB") %></td>
	<td><%= request.getAttribute("cableresDC") %></td>
</tr>
<tr style="font-size: 10pt;">
	<td><B>МШУ (бустер) <BR> Тип, номер</B></td>
	<td colspan="12"><%= request.getAttribute("mshu") %></td>
</tr>
<tr style="font-size: 10pt;">
	<td><B>Фильтр Tx\Rx <BR> Тип, номер</B></td>
	<td colspan="12"><%= request.getAttribute("filter") %></td>
</tr>
<tr style="font-size: 10pt;">
	<td><B>Комбайнер DB <BR> Тип, номер</B></td>
	<td colspan="12"><%= request.getAttribute("combiner") %></td>
</tr>
<tr style="font-size: 10pt;">
	<td colspan="13">*Максимальное значение не более 1,7. Для реальной нагрузки с КСВН не более 1,5.
		Рекомендуется подтверждать файлом-отчетом измерений прибора в режиме <B>Fault Location</B>
	</td>
</tr>
</table>
<table border="0" width="100%">
<tr style="font-size: 10pt;">
	<TD>Монтаж произведен в соответствии с проектной документацией:</TD>
	<TD>[&nbsp;] Замечаний нет</TD>
</tr>
<tr style="font-size: 10pt;">
	<TD></TD>
	<TD>[&nbsp;] С замечаниями</TD>
</tr>
</table>

<P>&nbsp;</P>

<table border="1" width="100%">
<tr style="font-size: 10pt;">
	<TD>Замечания: (Крепеж и изоляция фидеров, радиусы изгиба и т.д.)</TD>
</tr>
<tr style="font-size: 10pt;">
	<TD></TD>
</tr>
<tr style="font-size: 10pt;">
	<TD></TD>
</tr>
</table>

<P>&nbsp;</P>

<table border="0" width="100%">
<tr style="font-size: 10pt;">
	<th><B>От _____________ Филиала ________________________________________________</B><BR>
	                                                     (должность, подпись, Ф.И.О.)</th>
</tr>
<tr style="font-size: 10pt;">
	<th><B>От ____________ Подрядчика ______________________________________________</B><BR>
	                                                     (должность, подпись, Ф.И.О.)</th>
</tr>
</table>


</DIV>
</body>
</html>
