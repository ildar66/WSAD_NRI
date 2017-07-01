<%@ page language = "java" %>
<%@ page contentType = "application/vnd.ms-excel;name=report.xls;charset=windows-1251" %>
<%@ page import="java.util.*,java.math.*,java.text.*,com.hps.july.inventory.formbean.*,org.apache.struts.util.*" %>
<%@ page import="com.hps.july.report.word.*" %>

<%
	response.setHeader("Cache-Control", "");
	response.setContentType("application/vnd.ms-excel;name=report.xls;charset=windows-1251");
	response.setHeader("Content-Disposition", "attachment;filename=report.xls");
	SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");

	Report6ParamsForm rp = (Report6ParamsForm)session.getAttribute("Report6ParamsForm");

	boolean detailed = rp.getDetailedReport().booleanValue();
	Engine engine = new Engine();
	
	Long prompt0 = new Long(0);
	Long prompt1 = new Long(rp.getStoragetype());

	String posType = "";
	switch(prompt1.intValue()){
	case 1:  posType = "на позицию";break;
	case 2:  posType = "на склад";break;
	case 3:  posType = "сотруднику";break;
	case 4:  posType = "подрядчику";break;
	case 5:  posType = "подрядчику/сотруднику";break;
	default: posType = "на место хранения";
	}

	String s2="";
	if("1".equals(rp.getStoragetype())) {
		s2 = rp.getPositionFrm();
	} else if("2".equals(rp.getStoragetype())) {
		s2 = rp.getStorageFrm();
	} else if("3".equals(rp.getStoragetype())) {
		s2 = rp.getEquipmentFrm();
	}
	Object[] prompt2 = new Object[]{new Long(s2)};
	String prompt3 = String.valueOf(rp.getStorage());
	Boolean prompt4 = new Boolean(true);
	
	java.sql.Timestamp prompt5 = new java.sql.Timestamp(System.currentTimeMillis());
	
	java.sql.Timestamp prompt6 = new java.sql.Timestamp(rp.getDatefrom().getTime());
	
	java.sql.Timestamp prompt7 = new java.sql.Timestamp(rp.getDateto().getTime());
	
	Boolean prompt8 = rp.getShowContract();

	String type = "";
	if(detailed) {
		if(rp.getShowContract().booleanValue()) {
			type="3";
		} else {
			type="2";
		}
	} else {
		type="1";
	}
	
	engine.setPrompt(new Object[]{prompt0,prompt1,prompt2,prompt3,prompt4,prompt5,prompt6,prompt7,prompt8});
	new Report062().getReportData( engine, "configs" );

	String cs = "";
	if(type.equals("1")){
		cs = "7";
	}else if(type.equals("2")){
		cs = "10";
	}else if(type.equals("3")){
		cs = "12";
	}

	int csL = new Long(cs).intValue();



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
			<td colspan=<%=cs%> style='text-align:left;border:0'><b><%if(type.equals("1")){%>Сводный<%}else{%>Подробный<%}%> отчет о расходе оборудования <%=posType%> <%=  engine.getData(0,"posname") %> </b></td>
 </tr> 
 
 <tr style='mso-height-source:userset;height:20.0pt'>
			<%String datefrom = prompt6.getDate() + "." + (prompt6.getMonth()+1) + "." + (prompt6.getYear()+1900);
			  String dateto = prompt7.getDate() + "." + (prompt7.getMonth()+1) + "." + (prompt7.getYear()+1900);
			%>
			<td colspan=<%=csL-(csL/2)%> style='text-align:left;border:0'><b>за период с <%=datefrom%> по <%=dateto%></b></td>
			<td colspan=<%=csL/2%> style='text-align:right;border:0'>Валюта: <b><%=  engine.getData(0,"curname") %></b></td>
 </tr>
 <tr style='mso-height-source:userset;height:15.0pt'>
			<%
			  String datecur = prompt5.getDate() + "." + (prompt5.getMonth()+1) + "." + (prompt5.getYear()+1900);
			%>
			<td colspan=<%=cs%> style='text-align:right;border:0'><b>Отчет получен на <%=datecur%></b></td>
 </tr>

 <tr class=xl27 height=50 style='mso-height-source:userset;height:50.0pt'>
			<td>№<br>п/п</td>
			<td>Наименование</td>
			<td>Оборудование</td>	
			<%if(!type.equals("1")){%>
			<td>Дата</td>
			<td>Тип док-та</td>
			<td>№ док-<br>та</td>
			<%}%>
			<td>Кол-во</td>
			<td>Ед.<br>изм.</td>
			<td>Цена</td>
			<td>Сумма</td>
			<%if(type.equals("3")){%>
			<td>Контракт</td>
			<td>Поставка</td>
			<%}%>
 </tr>
	
 
		<% 
		String type1p = "";
		String type2p = "";
		double sum1 = 0.0;
		double sum2 = 0.0;
		for (int i = 0; i < engine.getData().length; i++) { %>

					<%
						String type1 = (String)engine.getData(i,"type1");
						String type2 = (String)engine.getData(i,"type2");
					%>

						<%if(!(type2.equals(type2p))){
							if(!type2p.equals("")){%>
							<tr>
							<td colspan=<%=csL-1%> style='text-align:left;border:1'>Итого по типу <%=type2p%>
							</td>
							<td colspan=1><%=sum2%>
							</td>
							</tr>
						<%	}						
						}if(!(type1.equals(type1p))){
							if(!type1p.equals("")){%>
							<tr>
							<td colspan=<%=csL-1%> style='text-align:left;border:1'>Итого по виду <%=type1p%>
							</td>
							<td colspan=1><%=sum1%>
							</td>
							</tr>
						<%	}
						}%>

						<%
						if(!(type1.equals(type1p))){%>							
						<%sum1=0.0;%>
						<tr style='mso-height-source:userset;height:20.0pt'>
						<td colspan=<%=cs%> style='text-align:left;border:1'><%= engine.getData(i,"type1") %>
						</td>
						</tr>

						<%}if(!(type2.equals(type2p))){%>							
						<%sum2=0.0;%>
						<tr style='mso-height-source:userset;height:20.0pt'>
						<td colspan=<%=cs%> style='text-align:left;border:1'><%= engine.getData(i,"type2") %>
						</td>
						</tr>
						<%}%>

			<tr>
					<td><%= engine.getData(i,"iorder") %></td>
					<td style='text-align:left'><%= engine.getData(i,"type3") %></td>
					<td style='text-align:left'><%= engine.getData(i,"name") %></td>
					<%if(!type.equals("1")){%>
					<td><%= engine.getData(i,"delivdate") %></td>
					<td><%= engine.getData(i,"doctype") %></td>
					<td><%= engine.getData(i,"numdoc") %></td>
					<%}%>
					<td><%= engine.getData(i,"qty") %></td>
					<td><%= engine.getData(i,"unitname") %></td>					
					<td><%= engine.getData(i,"price") %></td>
					<td><%= engine.getData(i,"suma") %></td>
					<%if(type.equals("3")){%>
					<td><%= engine.getData(i,"contract") %></td>
					<td><%= engine.getData(i,"postavka") %></td>
					<%}%>
					
			</tr>
			<%type1p=type1;
			type2p=type2;
			sum1=sum1+((java.math.BigDecimal)engine.getData(i,"suma")).doubleValue();
			sum2=sum2+((java.math.BigDecimal)engine.getData(i,"suma")).doubleValue();
			%>

		<% } %>
<tr style='mso-height-source:userset;height:20.0pt'>
			<td colspan=7 style='text-align:left;'>Отчет получен <%=datecur%></td>
</tr>		
		
<%}%>

</table>

</body>

</html>
