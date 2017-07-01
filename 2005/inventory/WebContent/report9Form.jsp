<%@ page language = "java" %>
<%@ page contentType = "application/vnd.ms-excel;name=report.xls;charset=windows-1251" %>
<%@ page import="java.util.*,java.math.*,java.text.*,com.hps.july.inventory.formbean.*,org.apache.struts.util.*" %>
<%@ page import="com.hps.july.report.word.*" %>

<%
	Report9ParamsForm rp = (Report9ParamsForm)session.getAttribute("Report9ParamsForm");
/*
	String p = "";
	p += "prompt0="+java.net.URLEncoder.encode(rp.getSerial().trim());

	String redirectURL = "./../crystalclear/report9.jsp?" + p;
	response.sendRedirect(redirectURL);*/

	response.setHeader("Cache-Control", "");
	response.setContentType("application/vnd.ms-excel;name=report.xls;charset=windows-1251");
	response.setHeader("Content-Disposition", "attachment;filename=report.xls");
	SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
	
	Engine engine = new Engine();

	String prompt0 = rp.getSerial().trim();
	
	engine.setPrompt(new Object[]{prompt0});
	new com.hps.july.report.word.ResHistoryReport().getReportData( engine, "configs" );
%>

<html xmlns:o="urn:schemas-microsoft-com:office:office"
xmlns:x="urn:schemas-microsoft-com:office:excel"
xmlns="http://www.w3.org/TR/REC-html40">
<head>
<meta http-equiv=Content-Type content="application/vnd.ms-excel;name=report.xls;charset=windows-1251">
<meta name=ProgId content="Excel.Sheet">
<meta http-equiv="Content-Disposition" content="attachment;filename=report.xls">
<meta name=Generator content="Microsoft Excel 9">

<style>
<!--table
	{mso-displayed-decimal-separator:"\.";
	mso-displayed-thousand-separator:" ";}
@page
	{margin:.98in .79in .98in .79in;
	mso-header-margin:.5in;
	mso-footer-margin:.5in;}
tr
	{mso-height-source:auto;}
col
	{mso-width-source:auto;}
br
	{mso-data-placement:same-cell;}
.style0
	{mso-number-format:General;
	text-align:center;
	vertical-align:center;
	white-space:wrap;
	mso-rotate:0;
	mso-background-source:auto;
	mso-pattern:auto;
	color:windowtext;
	font-size:10.0pt;
	font-weight:400;
	font-style:normal;
	text-decoration:none;
	font-family:"Arial Cyr";
	mso-generic-font-family:auto;
	mso-font-charset:204;
	border:none;
	mso-protection:locked visible;
	mso-style-name:Обычный;
	mso-style-id:0;}
td
	{mso-style-parent:style0;
	padding-top:1px;
	padding-right:1px;
	padding-left:1px;
	mso-ignore:padding;
	color:windowtext;
	font-size:10.0pt;
	font-weight:400;
	font-style:normal;
	text-decoration:none;
	font-family:"Arial Cyr";
	mso-generic-font-family:auto;
	mso-font-charset:204;
	mso-number-format:General;
	text-align:center;
	vertical-align:center;
	border:1;
	mso-background-source:auto;
	mso-pattern:auto;
	mso-protection:locked visible;
	white-space:wrap;
	mso-rotate:0;}
.xl24
	{mso-style-parent:style0;
	mso-number-format:"Short Date";}
.xl25
	{mso-style-parent:style0;
	font-weight:700;
	font-family:"Arial Cyr", sans-serif;
	mso-font-charset:204;}
.xl26
	{mso-style-parent:style0;
	font-weight:700;
	font-family:"Arial Cyr", sans-serif;
	mso-font-charset:204;
	white-space:normal;}
.xl27
	{mso-style-parent:style0;
	mso-number-format:"\#\,\#\#0\.00_р_\.";}
.xl28
	{mso-style-parent:style0;
	font-weight:700;
	font-family:"Arial Cyr", sans-serif;
	mso-font-charset:204;
	mso-number-format:"\#\,\#\#0\.00_р_\.";
	border:.5pt solid black;
	white-space:normal;}
.xl29
	{mso-style-parent:style0;
	mso-number-format:"\#\,\#\#0\.00_р_\.";
	border:.5pt solid black;}
-->
</style>

</head>

<body link=blue vlink=purple>
	

<table x:str border=1 cellpadding=0 cellspacing=0 style='border-collapse:collapse;'>

<%if(engine.getData() == null) {%>
	<tr class=xl27 height=50 style='mso-height-source:userset;height:50.0pt'>
	<td colspan=8>
			<B>Ошибка выполнения см. лог</B>
	</td>
	</tr>
<%}else if(engine.getData().length == 0) {%>
	<tr class=xl27 height=50 style='mso-height-source:userset;height:50.0pt'>
	<td colspan=8>
			<B>Нет данных</B>
	</td>
	</tr>
<%}else{%>	

 <tr style='mso-height-source:userset;height:20.0pt'>
			<td colspan=6 style='text-align:left;border:0'><b>Отчет по истории перемещения оборудования</b></td>
 </tr>
 <tr style='mso-height-source:userset;height:20.0pt'>
			<td colspan=6 style='text-align:left;border:0'><b>Исходный заводской номер: <%=  engine.getData(0,"resmanuf") %></b></td>
 </tr>
 <tr class=xl27 height=50 style='mso-height-source:userset;height:50.0pt'>
			<td>Дата</td>
			<td>Документ</td>
			<td>N и дата документа<br>(счет)</td>
			<td>Исходное местоположение</td>
			<td>Конечное местоположение</td>
			<td>Головное устройство</td>
 </tr>
	
    <% String oldStorageCard = ""; %>
 
		<% for (int i = 0; i < engine.getData().length; i++) { %>
			<tr>
					<%
						String docname = (String)engine.getData(i,"docname");
						String doc = "";
						if(docname.equals("s.external.waybill")) doc = "Внешний приходный ордер";
						else if(docname.equals("s.internal.waybill")) doc = "Внутренний приходный ордер";
						else if(docname.equals("p.assembling")) doc = "Акт монтажа на позиции";
						else if(docname.equals("s.internal.outbill")) doc = "Внутренняя расходная накладная";
						else if(docname.equals("p.dismantling")) doc = "Акт демонтажа на позиции";
						else if(docname.equals("s.external.outbill")) doc = "Внешняя расходная накладная";
						else if(docname.equals("s.payoff")) doc = "Акт списания со склада";
						else if(docname.equals("e.payoff")) doc = "Акт списания у сотрудника";
						else if(docname.equals("p.payoff")) doc = "Акт списания с позиции";
						else if(docname.equals("s.payoff.i")) doc = "Акт инвентаризации на складе (отсутствие)";
						else if(docname.equals("e.payoff.i")) doc = "Акт инвентаризации у сотрудникана (отсутствие)";
						else if(docname.equals("p.payoff.i")) doc = "Акт инвентаризации на позиции (отсутствие)";
						else if(docname.equals("s.payoff.h")) doc = "Акт замены/модернизации на складе (списание)";
						else if(docname.equals("e.payoff.h")) doc = "Акт замены при ремонте (списание)";
						else if(docname.equals("p.payoff.h")) doc = "Акт замены/модернизации на позиции (списание)";
						else if(docname.equals("contract")) doc = "Контракт";
						else if(docname.equals("s.surplus")) doc = "Акт о появлении излишков на складе";
						else if(docname.equals("p.surplus")) doc = "Акт о появлении излишков на позиции";
						else if(docname.equals("e.surplus")) doc = "Акт о появлении излишков";
						else if(docname.equals("s.surplus.i")) doc = "Акт инвентаризации на складе (новое)";
						else if(docname.equals("p.surplus.i")) doc = "Акт инвентаризации на позиции (новое)";
						else if(docname.equals("e.surplus.i")) doc = "Акт инвентаризации у сотрудника (новое)";
						else if(docname.equals("s.surplus.h")) doc = "Акт замены/модернизации на складе (замена)";
						else if(docname.equals("p.surplus.h")) doc = "Акт замены/модернизации на позиции (замена)";
						else if(docname.equals("e.surplus.h")) doc = "Акт замены при ремонте (замена)";
						else if(docname.equals("s.inventarization")) doc = "Акт инвентаризации на складе";
						else if(docname.equals("s.inventarization.s")) doc = "Акт инвентаризации на складе (новое)";
						else if(docname.equals("s.inventarization.p")) doc = "Акт инвентаризации на складе (отсутствие)";
						else if(docname.equals("p.inventarization")) doc = "Акт инвентаризации на позиции";
						else if(docname.equals("p.inventarization.s")) doc = "Акт инвентаризации на позиции (новое)";
						else if(docname.equals("p.inventarization.p")) doc = "Акт инвентаризации на позиции (отсутствие)";
						else if(docname.equals("s.assembling.block")) doc = "Акт монтажа блоков на складе";
						else if(docname.equals("p.assembling.block")) doc = "Акт монтажа блоков на позиции";
						else if(docname.equals("s.dismantling.block")) doc = "Акт демонтажа блоков на складе";
						else if(docname.equals("p.dismantling.block")) doc = "Акт демонтажа блоков на позиции";
						else if(docname.equals("s.change")) doc = "Акт замены/модернизации на складе";
						else if(docname.equals("s.change.payoff")) doc = "Акт замены/модернизации на складе (списание)";
						else if(docname.equals("s.change.surplus")) doc = "Акт замены/модернизации на складе (замена)";
						else if(docname.equals("e.change")) doc = "Акт замены при ремонте";
						else if(docname.equals("e.change.payoff")) doc = "Акт замены при ремонте (списание)";
						else if(docname.equals("e.change.surplus")) doc = "Акт замены при ремонте (замена)";
						else if(docname.equals("p.change")) doc = "Акт замены/модернизации на позиции";
						else if(docname.equals("p.change.payoff")) doc = "Акт замены/модернизации на позиции (списание)";
						else if(docname.equals("p.change.surplus")) doc = "Акт замены/модернизации на позиции (замена)";
						else if(docname.equals("s.request")) doc = "Требование";
						else if(docname.equals("fault")) doc = "Fault Report";
						else if(docname.equals("p.afsmount")) doc = "Акт монтажа АФС";
						else doc = docname;
						String storageCard = (String)engine.getData(i,"storename");
            if (!oldStorageCard.equals(storageCard)) {
              oldStorageCard = storageCard;
					%>
					
					       <TD colspan=6 style='text-align:left;'><%= engine.getData(i,"resname") %><BR>
                      <%= engine.getData(i,"resserial") %>
                 </TD>
					   </TR>
					   <TR>
					
					
					<% } %>


					<td><%= engine.getDateStr(i,"opdate") %></td>
					<td style='text-align:left'><%= doc %></td>
					<td style='text-align:left'><%= engine.getData(i,"docnum") %></td>
					<td style='text-align:left'><%= engine.getData(i,"storesrc") %></td>
					<td style='text-align:left'><%= engine.getData(i,"storedest") %></td>
					<td style='text-align:left'><%= engine.getData(i,"headres") %></td>
					
			</tr>
		<% } %>
<%}%>

</table>

</body>

</html>
