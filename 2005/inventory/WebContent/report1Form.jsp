<%@ page language = "java" %>
<%@ page contentType = "application/vnd.ms-excel;name=report.xls;charset=windows-1251" %>
<%@ page import="java.util.*,java.math.*,java.text.*,com.hps.july.inventory.formbean.*,org.apache.struts.util.*" %>
<%@ page import="com.hps.july.report.word.*" %>
<%@ page import="com.hps.july.util.*" %>

<%
	Report1ParamsForm rp = (Report1ParamsForm)session.getAttribute("Report1ParamsForm");
	Report1rtLookupListForm rt = (Report1rtLookupListForm)session.getAttribute("Report1rtLookupListForm");
	Report1rstLookupListForm rst = (Report1rstLookupListForm)session.getAttribute("Report1rstLookupListForm");

	// Create params
	//String p = "";
	/*if(rp.getShowWithContract() != null && rp.getShowWithContract().booleanValue()) {
		if("E".equals(rp.getReporttype())) {
			p = "Report01_gc.rpt?dll=pdscontent.dll";
		} else {
			p = "Report01_sc.rpt?dll=pdscontent.dll";
		}
	} else {
		if("E".equals(rp.getReporttype())) {
			p = "Report01_g.rpt?dll=pdscontent.dll";
		} else {
			p = "Report01_s.rpt?dll=pdscontent.dll";
		}
	}*/
	/*p += "prompt0="+rp.getStCode();
	p += "&prompt1="+rp.getStoragetype();
	if("P".equals(rp.getStoragetype())) {
		p += "&prompt2="+rp.getComplectsString();
	} else {
		p += "&prompt2=*";
	}
	p += "&prompt3="+rp.getReporttype();
	p += "&prompt4="+rp.getShowAgregateContent();
	p += "&prompt5="+rp.getShowWithContract();
	p += "&prompt6="+rp.getIncvtypes();
	if(rp.getIncvtypes() != null && rp.getIncvtypes().booleanValue()) {
		try {
			p += "&prompt7=["+rt.getResultString()+"]";
		} catch(Exception e) {
			p += "&prompt7=";
		}
		try {
			p += "&prompt8=["+rst.getResultString()+"]";
		} catch(Exception e) {
			p += "&prompt8=";
		}
	} else {
		p += "&prompt7=[]";
		p += "&prompt8=[]";
	}

	String type = "";

	if(rp.getShowWithContract() != null && rp.getShowWithContract().booleanValue()) {
		if("E".equals(rp.getReporttype())) {
			type="11";
		} else {
			type="21";
		}
	} else {
		if("E".equals(rp.getReporttype())) {
			type="1";
		} else {
			type="2";
		}
	}

	p += "&type=" + type;


   String redirectURL = "./../crystalclear/report1.jsp?" + p;
   response.sendRedirect(redirectURL);*/

	response.setHeader("Cache-Control", "");
	response.setContentType("application/vnd.ms-excel;name=report.xls;charset=windows-1251");
	response.setHeader("Content-Disposition", "attachment;filename=report.xls");
	SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
	

	Engine engine = new Engine();

	String prompt0param = request.getParameter("prompt0");

	Long prompt0 = new Long(rp.getStCode());
	String prompt1 = rp.getStoragetype();

	String prompt2 = "";
	if("P".equals(rp.getStoragetype())) {
		prompt2= rp.getComplectsString();
	} else {
		prompt2= "*";
	}
	 
	String prompt3 = rp.getReporttype();
	Boolean prompt4 = rp.getShowAgregateContent();
	Boolean prompt5 = rp.getShowWithContract();
	Boolean prompt6 = rp.getIncvtypes();

	String prompt7 = request.getParameter("prompt7");
	String prompt8 = request.getParameter("prompt8");

	if(rp.getIncvtypes() != null && rp.getIncvtypes().booleanValue()) {
		try {
			prompt7="["+rt.getResultString()+"]";
		} catch(Exception e) {
			prompt7="";
		}
		try {
			prompt8="["+rst.getResultString()+"]";
		} catch(Exception e) {
			prompt8="";
		}
	} else {
		prompt7="[]";
		prompt8="[]";
	}

	String type = "";

	if(rp.getShowWithContract() != null && rp.getShowWithContract().booleanValue()) {
		if("E".equals(rp.getReporttype())) {
			type="11";
		} else {
			type="21";
		}
	} else {
		if("E".equals(rp.getReporttype())) {
			type="1";
		} else {
			type="2";
		}
	}
	
	engine.setPrompt(new Object[]{prompt0,prompt1,prompt2,prompt3,prompt4,prompt5,prompt6,prompt7,prompt8});
	new Report01().getReportData( engine, "configs" );

	String cs = "0";
	String cs2 = "0";
	String cs3 = "0";
	if(type.equals("11") || type.equals("21")){
		cs = "9";
		cs2 = "5";
		cs3 = "4";
	}else {
		cs = "8";
		cs2 = "4";
		cs3 = "4";
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
			<td colspan=<%=cs%> style='text-align:left;border:0'><b>Отчет о наличии оборудования <%=  engine.getData(0,"storagetype") %>  
			<%=  engine.getData(0,"storagename") %> по состоянию на текущий момент</b></td>
 </tr>
 <tr style='mso-height-source:userset;height:20.0pt'>
			<td colspan=<%=cs2%> style='text-align:left;border:0'><b><%=  engine.getData(0,"reporttype") %></b></td>
			<td colspan=<%=cs3%> style='text-align:right;border:0'>Валюта: <b><%=  engine.getData(0,"currency") %></b></td>
 </tr>
 <tr class=xl27 height=50 style='mso-height-source:userset;height:50.0pt'>
			<td>№ п/п</td>
			<td>Наименование, модель, конфигурация</td>
			<td>Зав. N/<BR>N партии</td>
			<td>В сост.<br>устр.</td>
			<td>Сломано</td>
			<td>Кол-во </td>
			<td>Цена<br>за единицу</td>
			<td>Сумма</td>
			<%if(type.equals("11") || type.equals("21")){%>
			<td>Контракт/Поставка</td>
			<%}%>
 </tr>
	
 
		<% 
			String type1p = "";
			String type2p = "";
			for (int i = 0; i < engine.getData().length; i++) { %>

			<%
						String type1 = (String)engine.getData(i,"type1");
						String type2 = (String)engine.getData(i,"type2");
					
						if(!(type1.equals(type1p))){%>
						<tr style='mso-height-source:userset;height:20.0pt'>
						<td colspan=<%=cs%> style='text-align:left;border:1'><%= engine.getData(i,"type1") %>
						</td>
						</tr>

						<%}if(!(type2.equals(type2p))){%>
						<tr style='mso-height-source:userset;height:20.0pt'>
						<td colspan=<%=cs%> style='text-align:left;border:1'><%= engine.getData(i,"type2") %>
						</td>
						</tr>
						<%}%>


			<tr>
					<td><%= engine.getData(i,"iorder") %></td>
					<td style='text-align:left'><%= engine.getData(i,"name") %></td>
					<td style='text-align:left'><%= engine.getData(i,"sn") %></td>
					<td><%if(engine.getData(i,"agr")!=null){%>+<%}else{%>&nbsp;<%}%></td>
					<td><%= engine.getData(i,"broken") %></td>
					<td><%= engine.getData(i,"qty") %></td>
					<td><%= engine.getData(i,"price") %></td>
					<td><%= engine.getData(i,"summ") %></td>
					<%if(type.equals("11") || type.equals("21")){%>
					<td><%= engine.getData(i,"contract") %></td>
					<%}%>
			</tr>
			<%type1p=type1;
			type2p=type2;
			%>

		<% } %>
<tr style='mso-height-source:userset;height:20.0pt'>
			<td colspan=<%=cs%> style='text-align:left;'>Отчет получен <%=  engine.getData(0,"reportdate") %> </td>
</tr>		
		
<%}%>

</table>

</body>

</html>

	