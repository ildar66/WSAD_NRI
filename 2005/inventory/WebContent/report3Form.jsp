<%@ page language = "java" %>
<%@ page contentType = "application/vnd.ms-excel;name=report.xls;charset=windows-1251" %>
<%@ page import="java.util.*,java.math.*,java.text.*,com.hps.july.inventory.formbean.*,org.apache.struts.util.*" %>
<%@ page import="com.hps.july.report.word.*" %>

<%
	Report3ParamsForm rp = (Report3ParamsForm)session.getAttribute("Report3ParamsForm");

	//String p ="";
	/*if(rp.getShowContract().booleanValue()) {
		p = "resplacepc.rpt?dll=pdsresplacep.dll";
	} else {
		p = "resplacep.rpt?dll=pdsresplacep.dll";
	}*/
	/*p += "prompt0=0";
	p += "&prompt1="+(rp.getAlltype().booleanValue()?"true":"false");
	p += "&prompt2="+(rp.getAllsbtype().booleanValue()?"true":"false");
	p += "&prompt3="+rp.getRestypecode();
	p += "&prompt4="+rp.getRessbtypecode();
	p += "&prompt5="+rp.getBaseagreement();
	p += "&prompt6="+rp.getSupplyact();
	p += "&prompt7="+java.net.URLEncoder.encode(rp.getAccount());
	p += "&prompt8="+("C".equals(rp.getStatetype())?"true":"false");
	p += "&prompt9=";
	java.sql.Date date = new java.sql.Date((new java.util.Date()).getTime());
	if(date != null) {
		p += date.getTime() +"";
	}
	p += "&prompt10="+rp.getSearchon();
	p += "&prompt11="+rp.getGroup();
	p += "&prompt12="+rp.getShowAgregated();
	p += "&prompt13="+rp.getShowContract();
	p += "&prompt14="+rp.getShowOnmap();

	String supplyname = rp.getSupplyname();
	if(supplyname != null && !"".equals(supplyname)) { supplyname += " "+rp.getSupplynum(); }
	else { supplyname = rp.getSupplynum(); }
	if(supplyname == null) supplyname = "";
	if(rp.getBaseagreementname() != null) {
		if(supplyname != null && !"".equals(supplyname)) {
			supplyname += "; ";
		}
		supplyname += rp.getBaseagreementname();
	}
	if(rp.getAccount() != null && !"".equals(rp.getAccount().trim())) {
		if(supplyname != null && !"".equals(supplyname)) {
			supplyname += "; ";
		}
		supplyname += rp.getAccount();
	}
	
	p += "&prompt15="+java.net.URLEncoder.encode(supplyname);

	String type = "";
	if(rp.getShowContract().booleanValue()) {
		type="1";
	} else {
		type="2";
	}

	p += "&type=" + type;

	String redirectURL = "./../crystalclear/report3.jsp?" + p;
	response.sendRedirect(redirectURL);*/

	response.setHeader("Cache-Control", "");
	response.setContentType("application/vnd.ms-excel;name=report.xls;charset=windows-1251");
	response.setHeader("Content-Disposition", "attachment;filename=report.xls");
	SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
	
	Engine engine = new Engine();
	
	Long prompt0 = new Long(0);

	Boolean prompt1 = rp.getAlltype();
	Boolean prompt2 = rp.getAllsbtype();
	String prompt3 = rp.getRestypecode();
	String prompt4 = rp.getRessbtypecode();
	Long prompt5 = new Long(rp.getBaseagreement());
	Long prompt6 = new Long(rp.getSupplyact());
	String prompt7 = rp.getAccount();
	Boolean prompt8 = new Boolean("C".equals(rp.getStatetype())?"true":"false");
	java.sql.Timestamp prompt9 = new java.sql.Timestamp(System.currentTimeMillis());
	Long prompt10 = new Long(rp.getSearchon());
	Boolean prompt11 = rp.getGroup();
	Boolean prompt12 = rp.getShowAgregated();
	Boolean prompt13 = rp.getShowContract();
	Boolean prompt14 = rp.getShowOnmap();

	String supplyname = rp.getSupplyname();
	if(supplyname != null && !"".equals(supplyname)) { supplyname += " "+rp.getSupplynum(); }
	else { supplyname = rp.getSupplynum(); }
	if(supplyname == null) supplyname = "";
	if(rp.getBaseagreementname() != null) {
		if(supplyname != null && !"".equals(supplyname)) {
			supplyname += "; ";
		}
		supplyname += rp.getBaseagreementname();
	}
	if(rp.getAccount() != null && !"".equals(rp.getAccount().trim())) {
		if(supplyname != null && !"".equals(supplyname)) {
			supplyname += "; ";
		}
		supplyname += rp.getAccount();
	}
	
	String prompt15 = supplyname;
	String type = "";
	if(rp.getShowContract().booleanValue()) {
		type="1";
	} else {
		type="2";
	}
	
	engine.setPrompt(new Object[]{prompt0,prompt1,prompt2,prompt3,prompt4,prompt5,prompt6,prompt7,prompt8,
	prompt9,prompt10,prompt11,prompt12,prompt13,prompt14,prompt15});
	new Report03().getReportData( engine, "configs" );
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
			<td colspan=<%if(type.equals("2")){%>9<%}else{%>11<%}%> style='text-align:left;border:0'><b>Отчет о местоположении оборудования</b></td>
 </tr> 
 <tr style='mso-height-source:userset;height:15.0pt'>
			<td colspan=<%if(type.equals("2")){%>9<%}else{%>11<%}%> style='text-align:left;border:0'><b>По соглашению/договору поставки/счету</b></td>
 </tr> 
 <tr class=xl27 height=50 style='mso-height-source:userset;height:50.0pt'>
			<td>№<br>позиции</td>
			<td>Наименование позиции</td>
			<td>Наименование</td>
			<td>Обозначение</td>
			<td>Зав. N/<BR>N партии</td>
			<td>В сост.<br>устр.</td>
			<td>Сломано</td>						
			<td>Кол-во</td>
			<td>Ед.<br>изм.</td>
			<%if(type.equals("1")){%>
			<td>Контракт</td>
			<td>Поставка</td>
			<%}%>
 </tr>
	
 
		<% for (int i = 0; i < engine.getData().length; i++) { %>
			<tr>
					<td><%= engine.getData(i,"iorder") %></td>
					<td style='text-align:left'><%= engine.getData(i,"posname") %></td>
					<td style='text-align:left'><%= engine.getData(i,"type3") %></td>
					<td style='text-align:left'><%= engine.getData(i,"name") %></td>
					<td style='text-align:left'><%= engine.getData(i,"serno") %></td>
					<td><%if(((Boolean)engine.getData(i,"inc")).booleanValue()){%>+<%}else{%>&nbsp;<%}%></td>
					<td><%if(((Boolean)engine.getData(i,"break")).booleanValue()){%>+<%}else{%>&nbsp;<%}%></td>					
					<td><%= engine.getData(i,"qty") %></td>
					<td><%= engine.getData(i,"unitname") %></td>
					<%if(type.equals("1")){%>
					<td><%= engine.getData(i,"contract") %></td>
					<td><%= engine.getData(i,"postavka") %></td>
					<%}%>
			</tr>
		<% } %>
<%--<tr style='mso-height-source:userset;height:20.0pt'>
			<td colspan=8 style='text-align:left;'>Отчет получен <%=  engine.getData(0,"reportdate") %> </td>
</tr>--%>		
		
<%}%>

</table>

</body>

</html>