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
	{size:841.9pt 595.3pt;
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
	Отчет по изменениям конфигурации оборудования <BR>
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
<tr style="font-size: 10pt;">
	<th><B>Статус изменений</B></th>
	<td><%= request.getAttribute("changesstatus") %></td>
</tr>
<tr style="font-size: 10pt;">
	<th><B>Документ:</B></th>
	<td><%= request.getAttribute("docnumber") %> от <%= request.getAttribute("docdate") %></td>
</tr>
</table>

<P>&nbsp;</P>

<DIV style="font-size: 10pt;"><B>1. Добавлено оборудование</B></DIV>
<table border="1" width="100%">
<tr style="font-size: 10pt;">
	<th><B>№ п/п</B></th>
	<th><B>Категория оборудования</B></th>
	<th><B>Тип оборудования</B></th>
	<th><B>Учет</B></th>
	<th><B>Кол-во, шт</B></th>
	<th><B>Заводской</B></th>
	<th><B>Инвентарный</B></th>
	<th><B>Инв. подразделения</B></th>
	<th><B>Номер шкафа</B></th>
	<th><B>Сектора 900</B></th>
	<th><B>Сектора 1800</B></th>
</tr>
<%
	java.util.List addedEquipList = (java.util.List)request.getAttribute("addedEquipList");
	java.util.Iterator it = addedEquipList.iterator();
	while (it.hasNext()) {
		com.hps.july.config.model.ReportChangesVO vo = (com.hps.july.config.model.ReportChangesVO)it.next();
		
%>
<tr style="font-size: 10pt;">
	<td><%= vo.getNumindex() %></td>
	<td><%= vo.getCategory() %></td>
	<td><%= vo.getEquiptype() %></td>
	<td><%= vo.getPolicy() %></td>
	<td><%= vo.getQty() %></td>
	<td><%= vo.getSerialnumber() %></td>
	<td><%= vo.getInventserial() %></td>
	<td><%= vo.getLocalserial() %></td>
	<td><%= vo.getStandno() %></td>
	<td><%= vo.getSectors900() %></td>
	<td><%= vo.getSectors1800() %></td>
</tr>
<%
	}
%>
</table>

<P>&nbsp;</P>

<DIV style="font-size: 10pt;"><B>2. Удалено оборудование</B></DIV>
<table border="1" width="100%">
<tr style="font-size: 10pt;">
	<th><B>№ п/п</B></th>
	<th><B>Категория оборудования</B></th>
	<th><B>Тип оборудования</B></th>
	<th><B>Учет</B></th>
	<th><B>Кол-во, шт</B></th>
	<th><B>Заводской</B></th>
	<th><B>Инвентарный</B></th>
	<th><B>Инв. подразделения</B></th>
	<th><B>Номер шкафа</B></th>
	<th><B>Сектора 900</B></th>
	<th><B>Сектора 1800</B></th>
</tr>
<%
	java.util.List deletedEquipList = (java.util.List)request.getAttribute("deletedEquipList");
	java.util.Iterator it2 = deletedEquipList.iterator();
	while (it2.hasNext()) {
		com.hps.july.config.model.ReportChangesVO vo = (com.hps.july.config.model.ReportChangesVO)it2.next();
		
%>
<tr style="font-size: 10pt;">
	<td><%= vo.getNumindex() %></td>
	<td><%= vo.getCategory() %></td>
	<td><%= vo.getEquiptype() %></td>
	<td><%= vo.getPolicy() %></td>
	<td><%= vo.getQty() %></td>
	<td><%= vo.getSerialnumber() %></td>
	<td><%= vo.getInventserial() %></td>
	<td><%= vo.getLocalserial() %></td>
	<td><%= vo.getStandno() %></td>
	<td><%= vo.getSectors900() %></td>
	<td><%= vo.getSectors1800() %></td>
</tr>
<%
	}
%>
</table>

<P>&nbsp;</P>

<DIV style="font-size: 10pt;"><B>3. Изменены характеристики</B></DIV>
<table border="1" width="100%">
<tr style="font-size: 10pt;">
	<th><B>№ п/п</B></th>
	<th><B>Секция</B></th>
	<th><B>№ строки</B></th>
	<th><B>Категория оборудования</B></th>
	<th><B>Тип оборудования</B></th>
	<th><B>Наименование характеристики</B></th>
	<th><B>Старое значение</B></th>
	<th><B>Новое значение</B></th>
</tr>
<%
	java.util.List updatedEquipList = (java.util.List)request.getAttribute("updatedEquipList");
	java.util.Iterator it3 = updatedEquipList.iterator();
	while (it3.hasNext()) {
		com.hps.july.config.model.ReportChangesVO vo = (com.hps.july.config.model.ReportChangesVO)it3.next();
		
%>
<tr style="font-size: 10pt;">
	<td><%= vo.getNumindex() %></td>
	<td><%= vo.getSection() %></td>
	<td><%= vo.getLine() %></td>
	<td><%= vo.getCategory() %></td>
	<td><%= vo.getEquiptype() %></td>
	<td><%= vo.getAttribute() %></td>
	<td><%= vo.getOldvalue() %></td>
	<td><%= vo.getNewvalue() %></td>
</tr>
<%
	}
%>
</table>


</DIV>
</body>
</html>
