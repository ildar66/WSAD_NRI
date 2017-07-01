<%@ page language = "java" %>
<%@ page contentType = "application/vnd.ms-excel; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import="com.hps.july.util.*"%>
<%
	String filenumber = (String)request.getAttribute("filenumber");
%>
<html xmlns:o="urn:schemas-microsoft-com:office:office" xmlns:x="urn:schemas-microsoft-com:office:excel" xmlns="http://www.w3.org/TR/REC-html40">

<head>
<meta http-equiv=Content-Type content="text/html; charset=windows-1251">
<meta name=ProgId content=Excel.Sheet>
<meta name=Generator content="Microsoft Excel 10">
<link rel=File-List href="GetReportComlineRAndPositions.files/filelist.xml">
<style id="Дополнит отчеты по Разрешениям_12738_Styles">
<!--table
	{mso-displayed-decimal-separator:"\,";
	mso-displayed-thousand-separator:" ";}
.xl1512738
	{padding-top:1px;
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
	mso-background-source:auto;
	mso-pattern:auto;
	white-space:nowrap;}
.xl2312738
	{padding-top:1px;
	padding-right:1px;
	padding-left:1px;
	mso-ignore:padding;
	color:windowtext;
	font-size:10.0pt;
	font-weight:400;
	font-style:normal;
	text-decoration:none;
	font-family:"Arial Narrow", sans-serif;
	mso-font-charset:0;
	text-align:left;
	vertical-align:middle;
	mso-background-source:auto;
	mso-pattern:auto;
	white-space:normal;}
.xl2412738
	{padding-top:1px;
	padding-right:1px;
	padding-left:1px;
	mso-ignore:padding;
	color:black;
	font-size:10.0pt;
	font-weight:400;
	font-style:normal;
	text-decoration:none;
	font-family:"Arial Narrow", sans-serif;
	mso-font-charset:0;
	mso-number-format:General;
	text-align:center;
	vertical-align:middle;
	border:.5pt solid windowtext;
	background:silver;
	mso-pattern:auto none;
	white-space:normal;}
.xl2512738
	{padding-top:1px;
	padding-right:1px;
	padding-left:1px;
	mso-ignore:padding;
	color:black;
	font-size:10.0pt;
	font-weight:400;
	font-style:normal;
	text-decoration:none;
	font-family:"Arial Narrow", sans-serif;
	mso-font-charset:0;
	mso-number-format:General;
	text-align:center;
	vertical-align:middle;
	border:.5pt solid windowtext;
	mso-background-source:auto;
	mso-pattern:auto;
	white-space:normal;}
.xl2512738a
	{padding-top:1px;
	padding-right:1px;
	padding-left:1px;
	mso-ignore:padding;
	color:black;
	font-size:10.0pt;
	font-weight:400;
	font-style:normal;
	text-decoration:none;
	font-family:"Arial Narrow", sans-serif;
	mso-font-charset:0;
	mso-number-format:General;
	text-align:center;
	vertical-align:middle;
	border:.5pt solid windowtext;
	background:#FFFF99;
	mso-background-source:auto none;
	mso-pattern:auto none;
	white-space:normal;}
.xl2612738
	{padding-top:1px;
	padding-right:1px;
	padding-left:1px;
	mso-ignore:padding;
	color:black;
	font-size:10.0pt;
	font-weight:400;
	font-style:normal;
	text-decoration:none;
	font-family:"Arial Narrow", sans-serif;
	mso-font-charset:0;
	mso-number-format:General;
	text-align:center;
	vertical-align:middle;
	border:.5pt solid windowtext;
	mso-background-source:auto;
	mso-pattern:auto;
	white-space:normal;}
.xl2712738
	{padding-top:1px;
	padding-right:1px;
	padding-left:1px;
	mso-ignore:padding;
	color:windowtext;
	font-size:10.0pt;
	font-weight:400;
	font-style:normal;
	text-decoration:none;
	font-family:"Arial Narrow", sans-serif;
	mso-font-charset:0;
	mso-number-format:General;
	text-align:center;
	vertical-align:middle;
	border-top:none;
	border-right:none;
	border-bottom:.5pt solid windowtext;
	border-left:none;
	mso-background-source:auto;
	mso-pattern:auto;
	white-space:nowrap;}
.xl2812738
	{padding-top:1px;
	padding-right:1px;
	padding-left:1px;
	mso-ignore:padding;
	color:windowtext;
	font-size:10.0pt;
	font-weight:700;
	font-style:normal;
	text-decoration:none;
	font-family:"Arial Narrow", sans-serif;
	mso-font-charset:0;
	mso-number-format:General;
	text-align:general;
	vertical-align:middle;
	border-top:none;
	border-right:none;
	border-bottom:.5pt solid windowtext;
	border-left:none;
	mso-background-source:auto;
	mso-pattern:auto;
	white-space:nowrap;}
.xl2912738
	{padding-top:1px;
	padding-right:1px;
	padding-left:1px;
	mso-ignore:padding;
	color:windowtext;
	font-size:10.0pt;
	font-weight:700;
	font-style:normal;
	text-decoration:none;
	font-family:"Arial Narrow", sans-serif;
	mso-font-charset:0;
	mso-number-format:General;
	text-align:center;
	vertical-align:middle;
	mso-background-source:auto;
	mso-pattern:auto;
	white-space:normal;}
-->
</style>
</head>

<body>
<!--[if !excel]>&nbsp;&nbsp;<![endif]-->
<div id="Дополнит отчеты по Разрешениям_12738" align=center x:publishsource="Excel">

<table x:str border=0 cellpadding=0 cellspacing=0 width=1024 style='border-collapse: collapse;table-layout:fixed;width:768pt'>
 <col width=64 span=16 style='width:48pt'>
 <tr class=xl2312738 height=17 style='height:12.75pt'>
  <td height=17 class=xl2812738 style='height:12.75pt;'>Позиции и радиореленые линии связи</td>
 </tr>
 <tr class=xl2312738 height=17 style='height:12.75pt'>
  <td height=17 class=xl2812738 style='height:12.75pt'>Файл <%=filenumber%></td>
  <td class=xl2712738>&nbsp;</td>
  <td class=xl2712738>&nbsp;</td>
  <td class=xl2712738>&nbsp;</td>
  <td class=xl2712738>&nbsp;</td>
  <td class=xl2712738>&nbsp;</td>
  <td class=xl2712738>&nbsp;</td>
  <td class=xl2712738>&nbsp;</td>
  <td class=xl2712738>&nbsp;</td>
  <td class=xl2712738>&nbsp;</td>
  <td class=xl2712738>&nbsp;</td>
  <td class=xl2712738>&nbsp;</td>
  <td class=xl2712738>&nbsp;</td>
  <td class=xl2712738>&nbsp;</td>
  <td class=xl2712738>&nbsp;</td>
  <td class=xl2712738>&nbsp;</td>
 </tr>
 <tr class=xl2312738 height=51 style='height:38.25pt'>
  <td height=51 class=xl2412738 width=64 style='height:38.25pt;border-top:none;width:48pt'>№ файла</td>
  <td class=xl2412738 width=64 style='border-top:none;border-left:none;width:48pt'>Порядковый номер файла</td>
  <td class=xl2412738 width=64 style='border-top:none;border-left:none;width:48pt'>№</td>
  <td class=xl2412738 width=64 style='border-top:none;border-left:none;width:48pt'>Название</td>
  <td class=xl2412738 width=64 style='border-top:none;border-left:none;width:48pt'>Адрес</td>
  <td class=xl2412738 width=64 style='border-top:none;border-left:none;width:48pt'>Широта</td>
  <td class=xl2412738 width=64 style='border-top:none;border-left:none;width:48pt'>Долгота</td>
  <td class=xl2412738 width=64 style='border-top:none;border-left:none;width:48pt'>Заказ</td>
  <td class=xl2412738 width=64 style='border-top:none;border-left:none;width:48pt'>Комментарий</td>
  <td class=xl2412738 width=64 style='border-top:none;border-left:none;width:48pt'>№№</td>
  <td class=xl2412738 width=64 style='border-top:none;border-left:none;width:48pt'>Название</td>
  <td class=xl2412738 width=64 style='border-top:none;border-left:none;width:48pt'>Адрес</td>
  <td class=xl2412738 width=64 style='border-top:none;border-left:none;width:48pt'>Широта</td>
  <td class=xl2412738 width=64 style='border-top:none;border-left:none;width:48pt'>Долгота</td>
  <td class=xl2412738 width=64 style='border-top:none;border-left:none;width:48pt'>Заказ</td>
  <td class=xl2412738 width=64 style='border-top:none;border-left:none;width:48pt'>Комментарий</td>
 </tr>
<logic:iterate id="reportLine" name="reportList" type="com.hps.july.basestation.valueobject.ReportComlinesPositionsValue">
<logic:present name="reportLine">
<%
	String haveplan1, haveplan2;
	String cl1 = "xl2512738a";
	if(null != reportLine.getPahaveplan()) {
		if("A".equals(reportLine.getPahaveplan()) || (reportLine.getPaorderno() != null && !"".equals(reportLine.getPaorderno()) )) { cl1 = "xl2512738"; }
		haveplan1 = "label.reports.haveplan" + reportLine.getPahaveplan();
	}
	else {
		haveplan1 = "label.reports.haveplan";
	}
	String cl2 = "xl2512738a";
	if(null !=  reportLine.getPbhaveplan()) {
		if("A".equals(reportLine.getPbhaveplan()) || (reportLine.getPborderno() != null && !"".equals(reportLine.getPborderno()) )) { cl2 = "xl2512738"; }
		haveplan2 = "label.reports.haveplan" + reportLine.getPbhaveplan();
	}
	else  {
		haveplan2 = "label.reports.haveplan";
	}
  %>
 <tr class=xl2312738 height=68 style='height:51.0pt'>
  <td height=68 class=xl2512738 width=64 style='height:51.0pt;border-top:none;width:48pt' x:num><july:stringwrite name="reportLine" property="filenumber"/></td>
  <td class=xl2512738 width=64 style='border-top:none;border-left:none;width:48pt' x:num><july:stringwrite name="reportLine" property="numberinfile"/></td>
  <td class=xl2512738 width=64 style='border-top:none;border-left:none;width:48pt' x:num><july:stringwrite name="reportLine" property="paid"/></td>
  <td class=xl2512738 width=64 style='border-top:none;border-left:none;width:48pt'><july:stringwrite name="reportLine" property="paname"/></td>
  <td class=xl2512738 width=64 style='border-top:none;border-left:none;width:48pt'><july:stringwrite name="reportLine" property="paadress"/></td>
  <td class=xl2512738 width=64 style='border-top:none;border-left:none;width:48pt'><july:stringwrite name="reportLine" property="palatFrm"/></td>
  <td class=xl2512738 width=64 style='border-top:none;border-left:none;width:48pt'><july:stringwrite name="reportLine" property="palongFrm"/></td>
  <td class=<%=cl1%> width=64 style='border-top:none;border-left:none;width:48pt'><july:stringwrite name="reportLine" property="paorderno"/></td>
  <td class=<%=cl1%> width=64 style='border-top:none;border-left:none;width:48pt'><bean:message key="<%=haveplan1%>"/></td>
  <td class=xl2512738 width=64 style='border-top:none;border-left:none;width:48pt' x:num><july:stringwrite name="reportLine" property="pbid"/></td>
  <td class=xl2512738 width=64 style='border-top:none;border-left:none;width:48pt'><july:stringwrite name="reportLine" property="pbname"/></td>
  <td class=xl2512738 width=64 style='border-top:none;border-left:none;width:48pt'><july:stringwrite name="reportLine" property="pbadress"/></td>
  <td class=xl2512738 width=64 style='border-top:none;border-left:none;width:48pt'><july:stringwrite name="reportLine" property="pblatFrm"/></td>
  <td class=xl2512738 width=64 style='border-top:none;border-left:none;width:48pt'><july:stringwrite name="reportLine" property="pblongFrm"/></td>
  <td class=<%=cl2%> width=64 style='border-top:none;border-left:none;width:48pt'><july:stringwrite name="reportLine" property="pborderno"/></td>
  <td class=<%=cl2%> width=64 style='border-top:none;border-left:none;width:48pt'><bean:message key="<%=haveplan2%>"/></td>
 </tr>
</logic:present>
</logic:iterate>
 <![if supportMisalignedColumns]>
 <tr height=0 style='display:none'>
  <td width=64 style='width:48pt'></td>
  <td width=64 style='width:48pt'></td>
  <td width=64 style='width:48pt'></td>
  <td width=64 style='width:48pt'></td>
  <td width=64 style='width:48pt'></td>
  <td width=64 style='width:48pt'></td>
  <td width=64 style='width:48pt'></td>
  <td width=64 style='width:48pt'></td>
  <td width=64 style='width:48pt'></td>
  <td width=64 style='width:48pt'></td>
  <td width=64 style='width:48pt'></td>
  <td width=64 style='width:48pt'></td>
  <td width=64 style='width:48pt'></td>
  <td width=64 style='width:48pt'></td>
  <td width=64 style='width:48pt'></td>
  <td width=64 style='width:48pt'></td>
 </tr>
 <![endif]>
</table>
</div>
</body>
</html>
