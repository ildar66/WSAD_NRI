<%@ page language = "java" %>
<%@ page contentType = "application/vnd.ms-excel;name=report.xls;charset=windows-1251" %>
<%@ page import="java.util.*,java.math.*,java.text.*,com.hps.july.inventory.formbean.*,org.apache.struts.util.*" %>
<%@ page import="com.hps.july.report.word.*" %>

<%
	Report7ParamsForm rp = (Report7ParamsForm)session.getAttribute("Report7ParamsForm");	

	response.setHeader("Cache-Control", "");
	response.setContentType("application/vnd.ms-excel;name=report.xls;charset=windows-1251");
	response.setHeader("Content-Disposition", "attachment;filename=report.xls");
	SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");	

	Engine engine = new Engine();

	//String prompt0param = request.getParameter("prompt0");
	Long prompt0 = /*prompt0param!=null?new Long(prompt0param):*/new Long(0);
	Long prompt1 = new Long(/*request.getParameter("prompt1")*/rp.getStoragetype());

	String posType = "";
	switch(prompt1.intValue()){
	case 1:  posType = "со склада";break;
	case 2:  posType = "с позиции";break;
	case 3:  posType = "из функционального комплекта: ";break;
	default: posType = "";
	}

	String prompt2 = "";
	if("1".equals(rp.getStoragetype())) {
		prompt2= rp.getStorageFrm();
	} else if("2".equals(rp.getStoragetype())) {
		prompt2= rp.getPositionFrm();
	} else if("3".equals(rp.getStoragetype())) {
		prompt2= rp.getEquipmentFrm();
	}

	//String prompt2 = s2;
	java.sql.Date prompt3 = /*new java.sql.Date(new Long(request.getParameter("prompt3")).longValue())*/rp.getDatefrom();	
	java.sql.Date prompt4 = /*new java.sql.Date(new Long(request.getParameter("prompt4")).longValue())*/rp.getDateto();
	String prompt5 = rp.getResourcecode();
	Boolean prompt6 = rp.getDocAll();
	Boolean prompt7 = rp.getDocInwaybill();
	Boolean prompt8 = rp.getDocDeassact();
	Boolean prompt9 = rp.getDocDeassactb();
	Boolean prompt10 = rp.getDocPayoff();
	Boolean prompt11 = rp.getDocInv();
	Boolean prompt12 = new Boolean(true);

	java.sql.Date prompt13 = new java.sql.Date(System.currentTimeMillis());
	Boolean prompt14 = rp.getShowContract();
	String type = "";
	if(rp.getShowContract().booleanValue()) {
		type = "2";
	} else {
		type = "1";
	}
	
	engine.setPrompt(new Object[]{prompt0,prompt1,prompt2,prompt3,prompt4,prompt5,prompt6,prompt7,prompt8,
	prompt9,prompt10,prompt11,prompt12,prompt13,prompt14});
	new Report07().getReportData( engine, "configs" );
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
	<td colspan=9>
			<B>Ошибка выполнения см. лог</B>
	</td>
	</tr>
<%}else if(engine.getData().length == 0) {%>
	<tr class=xl27 height=50 style='mso-height-source:userset;height:50.0pt'>
	<td colspan=9>
			<B>Нет данных</B>
	</td>
	</tr>
<%}else{%>	

 <tr style='mso-height-source:userset;height:15.0pt'>
			<td colspan=<%if(type.equals("2")){%>10<%}else{%>8<%}%> style='text-align:left;border:0'><b>Подробный отчет о расходе оборудования <%=posType%> <%= engine.getData(0,"posname") %></b></td>
 </tr> 
 
 <tr style='mso-height-source:userset;height:20.0pt'>
			<%String datefrom = prompt3.getDate() + "." + (prompt3.getMonth()+1) + "." + (prompt3.getYear()+1900);
			  String dateto = prompt4.getDate() + "." + (prompt4.getMonth()+1) + "." + (prompt4.getYear()+1900);
			%>
			<td colspan=<%if(type.equals("2")){%>5<%}else{%>4<%}%> style='text-align:left;border:0'><b>за период с <%=datefrom%> по <%=dateto%></b></td>
			<td colspan=<%if(type.equals("2")){%>5<%}else{%>4<%}%> style='text-align:right;border:0'>Валюта: <b><%=  engine.getData(0,"curname") %></b></td>
 </tr>
 <tr style='mso-height-source:userset;height:15.0pt'>
			<%
			  String datecur = prompt13.getDate() + "." + (prompt13.getMonth()+1) + "." + (prompt13.getYear()+1900);
			%>
			<td colspan=<%if(type.equals("2")){%>10<%}else{%>8<%}%> style='text-align:right;border:0'><b>Отчет получен на <%=datecur%></b></td>
 </tr>
 <tr style='mso-height-source:userset;height:15.0pt'>			
			<td colspan=<%if(type.equals("2")){%>10<%}else{%>8<%}%> style='text-align:left;border:0'><b>Оборудование <%=  engine.getData(0,"itemname") %></b></td>
 </tr>

 <tr class=xl27 height=50 style='mso-height-source:userset;height:50.0pt'>
			<td>Дата</td>
			<td>Тип документа</td>
			<td>№ документа</td>
			<td>Зав. N/<BR>N партии</td>			
			<td>Кол-во</td>
			<td>Ед.<br>изм.</td>
			<td>Цена</td>
			<td>Сумма</td>
			<%if(type.equals("2")){%>
			<td>Контракт</td>
			<td>Поставка</td>
			<%}%>
 </tr>
	
 
		<% 
			double sum = 0.0;
			double count = 0.0;
			for (int i = 0; i < engine.getData().length; i++) { %>
			<tr>
					<td style='text-align:left'><%= engine.getData(i,"docdate") %></td>
					<td style='text-align:left'><%= engine.getData(i,"doctype") %></td>
					<td style='text-align:left'><%= engine.getData(i,"docnum") %></td>
					<td style='text-align:left'><%= engine.getData(i,"serno") %></td>					
					<td><%= engine.getData(i,"qty") %></td>
					<td><%= engine.getData(i,"qtytype") %></td>
					<td><%= engine.getData(i,"PRICE") %></td>
					<td><%= engine.getData(i,"Summa") %></td>
					<%if(type.equals("2")){%>
					<td><%= engine.getData(i,"kontr") %></td>
					<td><%= engine.getData(i,"post") %></td>
					<%}%>
			</tr>
			<%
			sum=sum+((java.math.BigDecimal)engine.getData(i,"Summa")).doubleValue();
			count=count+((java.math.BigDecimal)engine.getData(i,"qty")).doubleValue();
			%>
		<% } %>
		<tr>
			<td colspan=4 style='text-align:left;'><b>Итого:</b></td>
			<td style='text-align:center' colspan=1 style='text-align:left;'><b><%=count%></b></td>
			<td colspan=2 style='text-align:left;'>&nbsp;</td>
			<td style='text-align:center' colspan=1 style='text-align:left;'><b><%=sum%></b></td>
			<%if(type.equals("2")){%>
			<td colspan=2 style='text-align:left;'>&nbsp;</b></td>
			<%}%>
		</tr>
		<tr style='mso-height-source:userset;height:20.0pt'>
					<td colspan=<%if(type.equals("2")){%>10<%}else{%>8<%}%> style='text-align:left;'>Отчет получен <%=datecur%> </td>
		</tr>		
		
<%}%>

</table>

</body>

</html>
	