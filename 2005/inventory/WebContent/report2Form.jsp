<%@ page language = "java" %>
<%@ page contentType = "application/vnd.ms-excel;name=report.xls;charset=windows-1251" %>
<%@ page import="java.util.*,java.math.*,java.text.*,com.hps.july.inventory.formbean.*,org.apache.struts.util.*" %>
<%@ page import="com.hps.july.report.word.*" %>

<%
	Report2ParamsForm rp = (Report2ParamsForm)session.getAttribute("Report2ParamsForm");

	/*String p = "";
	p += "prompt0=0"; // doc:Number
	p += "&prompt1="+rp.getResourcecode(); // type1:String
	p += "&prompt2="+java.net.URLEncoder.encode(rp.getResourcemodel()); // type2:String
	p += "&prompt3="+java.net.URLEncoder.encode(rp.getResourcename()); // name:String
	p += "&prompt4="+rp.getSearchon(); // pos:Number
	p += "&prompt5="+("C".equals(rp.getStateType())?Boolean.TRUE:Boolean.FALSE); // StateDate:Boolean
	p += "&prompt6="; // Date:Date
	java.sql.Date date = rp.getStateDate();
	if(date != null) {
		p += date.getTime()+"";
	}
	p += "&prompt7="+rp.getGroup(); // SumPosFlag:Boolean
	p += "&prompt8="+rp.getShowAgregated(); // ShowIntDev:Boolean
	p += "&prompt9="+rp.getShowOncard(); // ShowOnMap:Boolean

	String redirectURL = "./../crystalclear/report2.jsp?" + p;
	response.sendRedirect(redirectURL);*/
	
	response.setHeader("Cache-Control", "");
	response.setContentType("application/vnd.ms-excel;name=report.xls;charset=windows-1251");
	response.setHeader("Content-Disposition", "attachment;filename=report.xls");
	SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");

	Engine engine = new Engine();

	Long prompt0 = new Long(0);
	String prompt1 = rp.getResourcecode();
	String prompt2 = rp.getResourcemodel();
	String prompt3 = rp.getResourcename();
	Long prompt4 = new Long(rp.getSearchon());
	Boolean prompt5 = "C".equals(rp.getStateType())?Boolean.TRUE:Boolean.FALSE;
	java.sql.Date prompt6 = rp.getStateDate();
	Boolean prompt7 = rp.getGroup();
	Boolean prompt8 = rp.getShowAgregated();
	Boolean prompt9 = rp.getShowOncard();

	engine.setPrompt(new Object[]{prompt0,prompt1,prompt2,prompt3,prompt4,prompt5,prompt6,prompt7,prompt8,prompt9});
	new Report02().getReportData( engine, "configs" );
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
	<td colspan=7>
			<B>Ошибка выполнения см. лог</B>
	</td>
	</tr>
<%}else if(engine.getData().length == 0) {%>
	<tr class=xl27 height=50 style='mso-height-source:userset;height:50.0pt'>
	<td colspan=7>
			<B>Нет данных</B>
	</td>
	</tr>
<%}else{%>	

 <tr style='mso-height-source:userset;height:20.0pt'>
			<td colspan=7 style='text-align:left;border:0'><b>Отчет о местоположении оборудования</b></td>
 </tr>
 <tr style='mso-height-source:userset;height:20.0pt'>
			<td colspan=7 style='text-align:left;border:0'><b>Оборудование: <%=  engine.getData(0,"name") %></b></td>
 </tr>
 <tr class=xl27 height=50 style='mso-height-source:userset;height:50.0pt'>
			<td>№<br>позиции</td>
			<td>Наименование позиции</td>
			<td>Зав. N/<BR>N партии</td>
			<td>Сломано</td>
			<td>В сост.<br>устр.</td>			
			<td>Кол-во в<br>наличии</td>
			<td>Ед.<br>изм.</td>
 </tr>
	
 
		<% for (int i = 0; i < engine.getData().length; i++) { %>
			<tr>
					<td><%= engine.getData(i,"iorder") %></td>
					<td style='text-align:left'><%= engine.getData(i,"namepos") %></td>
					<td style='text-align:left'><%= engine.getData(i,"serno") %></td>
					<td><%if(((Boolean)engine.getData(i,"break")).booleanValue()){%>+<%}else{%>&nbsp;<%}%></td>
					<td><%if(((Boolean)engine.getData(i,"inc")).booleanValue()){%>+<%}else{%>&nbsp;<%}%></td>
					<td><%= engine.getData(i,"qty") %></td>
					<td><%= engine.getData(i,"unitname") %></td>
			</tr>
		<% } %>
<%--<tr style='mso-height-source:userset;height:20.0pt'>
			<td colspan=8 style='text-align:left;'>Отчет получен <%=  engine.getData(0,"reportdate") %> </td>
</tr>--%>		
		
<%}%>

</table>

</body>

</html>