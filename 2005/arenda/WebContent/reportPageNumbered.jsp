<%@ page language = "java" %>
<%@ page contentType = "application/vnd.ms-excel;name=report.xls;charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import="com.hps.july.util.*"%>
<%@ page import="java.text.*, com.hps.july.arenda.cdbcobjects.*"%>
<jsp:useBean id="ArendaReport3ParamsForm" class="com.hps.july.arenda.formbean.ArendaReport3ParamsForm" scope="session"/>
<%
	java.text.SimpleDateFormat formatCurDate = new java.text.SimpleDateFormat("yyMMdd_HHmmss");//"dd.MM.yyyy HH:mm:ss"
	java.util.Date curDate = new java.util.Date(System.currentTimeMillis());
	String curDateStr = formatCurDate.format(curDate);	

	response.setHeader("Cache-Control", "no-cache");
	response.setContentType("application/vnd.ms-excel;name=report"+curDateStr+".xls;charset=windows-1251");
	response.setHeader("Content-Disposition", "attachment;filename=report"+curDateStr+".xls");
	SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
	SimpleDateFormat formatMounth = new SimpleDateFormat("MMM yyyy", new java.util.Locale("ru", "RU"));
	//com.hps.july.arenda.cdbcobjects.Page reportPage =  (com.hps.july.arenda.cdbcobjects.Page)request.getAttribute("reportPage");
	//System.out.println("page="+ reportPage);
%>
<html xmlns:o="urn:schemas-microsoft-com:office:office"
xmlns:x="urn:schemas-microsoft-com:office:excel"
xmlns="http://www.w3.org/TR/REC-html40">
<head>
<meta http-equiv=Content-Type content="application/vnd.ms-excel;name=report<%=curDateStr%>.xls;charset=windows-1251">
<meta name=ProgId content="Excel.Sheet">
<meta http-equiv="Content-Disposition" content="attachment;filename=report<%=curDateStr%>.xls">
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
	text-align:general;
	vertical-align:bottom;
	white-space:nowrap;
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
	text-align:general;
	vertical-align:bottom;
	border:1;
	mso-background-source:auto;
	mso-pattern:auto;
	mso-protection:locked visible;
	white-space:nowrap;
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
.xl44
	{mso-style-parent:style0;
	font-weight:700;
	mso-number-format:"\@";
	text-align:center;
	vertical-align:middle;
	border-top:.5pt solid windowtext;
	border-right:.5pt solid windowtext;
	border-bottom:.5pt solid windowtext;
	border-left:none;
	background:#CCFFCC;
	mso-pattern:auto none;
	white-space:normal;}
.xl48
	{mso-style-parent:style0;
	font-weight:700;
	mso-number-format:Fixed;
	text-align:center;
	vertical-align:middle;
	border:.5pt solid windowtext;
	background:#FFFF99;
	mso-pattern:auto none;
	white-space:normal;}
.xl50
	{mso-style-parent:style0;
	font-weight:700;
	mso-number-format:Fixed;
	text-align:center;
	vertical-align:middle;
	border-top:.5pt solid windowtext;
	border-right:.5pt solid windowtext;
	border-bottom:none;
	border-left:.5pt solid windowtext;
	background:#CCFFFF;
	mso-pattern:auto none;
	white-space:normal;}
	
-->
</style>

</head>

<body link=blue vlink=purple>
<july:errors/>
<P style="padding-left: 300pt">
	<B><bean:write name="ArendaReport3ParamsForm" property="report.type.typeDescription" filter="true"/></B>
		<logic:equal name="ArendaReport3ParamsForm" property="report.type.isDataPeriod" value="true" scope="session">
		    <B>за период с</B> <%= ArendaReport3ParamsForm.getReport().getDataPeriod().getFromDateFrm() %> <B>по</B> <%= ArendaReport3ParamsForm.getReport().getDataPeriod().getToDateFrm() %>
		</logic:equal>
		<logic:equal name="ArendaReport3ParamsForm" property="report.type.isData" value="true" scope="session">
			<B><bean:write name="ArendaReport3ParamsForm" property="report.type.dataDescription"/>:</B> <%= ArendaReport3ParamsForm.getReport().getDataFrm() %>
		</logic:equal>
		<logic:equal name="ArendaReport3ParamsForm" property="report.type.isOtv" value="true" scope="session">
			<BR>&nbsp;&nbsp;&nbsp;<B>ответственный:</B> <%= ArendaReport3ParamsForm.getReport().getOtv().getName() %>
		</logic:equal>					
</P>
<TABLE x:str border=1 cellpadding=0 cellspacing=0 style='border-collapse:collapse;'>

<logic:present name="reportPage" scope="request">
<logic:equal name="ArendaReport3ParamsForm" property="comand" value="fillTmpListDocumenstOnPeriod" scope="session">
	<tr class=xl27 height=20 style='mso-height-source:userset;height:20.0pt'>
	  <td class=xl26 rowspan="2">п/н</td>
	  <td class=xl26 rowspan="2">Поставщик</td>
	  <td class=xl48 rowspan="2">№ д-ра</td>
	  <td class=xl48 rowspan="2">Предмет<br>договора</td>
	  <td class=xl50 rowspan="2">Ответственный<br>экономист</td>
	  <td class=xl50 rowspan="2">Ответственный<br>менеджер</td>	
	  <logic:iterate id="it" name="reportPage" scope="request" property="headers">
		<td class=xl44 style="text-align: center;" colspan="2">
			<%= formatMounth.format ((java.sql.Date)it)%>
		</td> 
 	  </logic:iterate>  
 	</tr>
	<tr class=xl27 height=20 style='mso-height-source:userset;height:20.0pt'>
	  <logic:iterate id="it" name="reportPage" scope="request" property="headers">
		 <td class=xl44 style="text-align: center;">акт № описи </td>
		 <td class=xl44 style="text-align: center;">сч-факт. № описи</td> 
 	  </logic:iterate>  
 	</tr> 	 	
</logic:equal>

<logic:equal name="ArendaReport3ParamsForm" property="comand" value="fillTmpListContractsOnPeriod" scope="session">
	<tr class=xl27 height=20 style='mso-height-source:userset;height:20.0pt'>
		<td class=xl26 rowspan="3">п/н</td>	
		<td class=xl26 rowspan="3">Ответственный</td>
		<td class=xl26 rowspan="3">Поставщик</td>
		<td class=xl48 colspan="2">Реквизиты договора</td>
		<td class=xl50 rowspan="3">Статья затрат.</td>
		<td class=xl44 colspan="8" style="text-align: left;">Примерная планируемая стоимость</td>
	</tr>
	<tr class=xl27 height=15 style='mso-height-source:userset;height:15.0pt'>
		<td class=xl48 rowspan="2">Номер</td>
		<td class=xl48 rowspan="2">Дата</td>
	  <logic:iterate id="it" name="reportPage" scope="request" property="headers">
		<td class=xl44 style="text-align: center;" colspan="4">
			<%= formatMounth.format ((java.sql.Date)it)%>
		</td> 
 	  </logic:iterate>  
 	</tr>
	<tr class=xl27 height=15 style='mso-height-source:userset;height:15.0pt'>
	  <logic:iterate id="it" name="reportPage" scope="request" property="headers">
		 <td class=xl44 style="text-align: center;">USD</td>
		 <td class=xl44 style="text-align: center;">EUR</td>
		 <td class=xl44 style="text-align: center;">RUR</td>
		 <td class=xl44 style="text-align: center;">Other</td> 
 	  </logic:iterate>  
 	</tr>
 	<%int i = 1;%>
	<tr style='mso-height-source:userset;height:12.75pt'>
		 <td class=xl26 style="text-align: center;">&nbsp;</td>
		 <td class=xl26 style="text-align: center;"><%=i++%></td>
		 <td class=xl26 style="text-align: center;"><%=i++%></td>
		 <td class=xl26 style="text-align: center;"><%=i++%></td>
		 <td class=xl26 style="text-align: center;"><%=i++%></td>
		 <td class=xl26 style="text-align: center;"><%=i++%></td>		  
	  <logic:iterate id="it" name="reportPage" scope="request" property="headers" indexId="indexId">
		 <td class=xl26 style="text-align: center;"><%=i++%></td>
		 <td class=xl26 style="text-align: center;"><%=i++%></td>
		 <td class=xl26 style="text-align: center;"><%=i++%></td>
		 <td class=xl26 style="text-align: center;"><%=i++%></td> 
 	  </logic:iterate>  
 	</tr> 	 	 	
</logic:equal>

		<!-- Table body -->
		<logic:iterate id="it" name="reportPage" scope="request" property="list" indexId="indexId">
			<% Object[] items = (Object[]) it; %>
			<tr style='height:12.75pt'>
				<td><%= indexId.intValue()+1%></td>
				<%for (int i = 0; i < items.length; i++) {%>
					<%if(items[i] == null){%>
						<td>&nbsp;</td>
					<%}else if (items[i].getClass() == java.sql.Date.class){
						String dataStr = format.format ((java.sql.Date)items[i]);
					%>
						<td><%=dataStr%></td>
					<%}else if (items[i].getClass() == java.sql.Timestamp.class){
						java.sql.Timestamp tms = (java.sql.Timestamp)items[i];
						String dataStr = format.format ( new java.sql.Date(tms.getTime()) );
					%>
						<td><%=dataStr%></td>
					<%}else if (items[i].getClass() == java.math.BigDecimal.class){%>
						<td class=xl29 align=right x:num="<%=items[i]%>"><span style="mso-spacerun: yes"></td> 
					<%}else{%>
						<td><%=items[i]%></td>
					<%}%>
				<%}%>
			</tr>
		</logic:iterate>
</logic:present>			
</TABLE>
</body>

</html>
