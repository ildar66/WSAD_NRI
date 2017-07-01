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
<link rel=File-List href="GetReportComlineR.files/filelist.xml">
<style id="Дополнит отчеты по Разрешениям_7112_Styles">
<!--table
	{mso-displayed-decimal-separator:"\,";
	mso-displayed-thousand-separator:" ";}
.xl237112
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
	mso-background-source:auto;
	mso-pattern:auto;
	white-space:normal;}
.xl247112
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
.xl257112
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
.xl267112
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
.xl277112
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
.xl287112
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
	border-top:none;
	border-right:.5pt solid windowtext;
	border-bottom:.5pt solid windowtext;
	border-left:.5pt solid windowtext;
	background:silver;
	mso-pattern:auto none;
	white-space:normal;}
.xl297112
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
	mso-background-source:auto;
	mso-pattern:auto;
	white-space:nowrap;}
.xl307112
	{mso-style-parent:style0;
	font-weight:700;
	font-family:"Arial Narrow", sans-serif;
	mso-font-charset:0;
	text-align:left;
	vertical-align:middle;}
-->
</style>
</head>

<body>
<!--[if !excel]>&nbsp;&nbsp;<![endif]-->
<div id="Дополнит отчеты по Разрешениям_7112" align=center x:publishsource="Excel">

<table x:str border=0 cellpadding=0 cellspacing=0 width=1171 class=xl237112 style='border-collapse:collapse;table-layout:fixed;width:878pt'>
 <col class=xl237112 width=43 style='mso-width-source:userset;mso-width-alt:1572;width:32pt'>
 <col class=xl237112 width=74 style='mso-width-source:userset;mso-width-alt:2706;width:56pt'>
 <col class=xl237112 width=32 style='mso-width-source:userset;mso-width-alt:1170;width:24pt'>
 <col class=xl237112 width=152 style='mso-width-source:userset;mso-width-alt:5558;width:114pt'>
 <col class=xl237112 width=93 style='mso-width-source:userset;mso-width-alt:3401;width:70pt'>
 <col class=xl237112 width=115 style='mso-width-source:userset;mso-width-alt:4205;width:86pt'>
 <col class=xl237112 width=64 style='width:48pt'>
 <col class=xl237112 width=62 style='mso-width-source:userset;mso-width-alt:2267;width:47pt'>
 <col class=xl237112 width=64 style='width:48pt'>
 <col class=xl237112 width=60 style='mso-width-source:userset;mso-width-alt:2194;width:45pt'>
 <col class=xl237112 width=63 span=2 style='mso-width-source:userset;mso-width-alt:2304;width:47pt'>
 <col class=xl237112 width=61 style='mso-width-source:userset;mso-width-alt:2230;width:46pt'>
 <col class=xl237112 width=59 style='mso-width-source:userset;mso-width-alt:2157;width:44pt'>
 <col class=xl237112 width=63 span=2 style='mso-width-source:userset;mso-width-alt:2304;width:47pt'>
 <col class=xl237112 width=40 style='mso-width-source:userset;mso-width-alt:1462;width:30pt'>
 <tr height=17 style='height:12.75pt'>
  <td height=17 class=xl277112 style='height:12.75pt;'>Радиорелейные линии связи</td>
 </tr>
 <tr height=17 style='height:12.75pt'>
  <td height=17 class=xl277112 style='height:12.75pt'>Файл <%=filenumber%></td>
  <td class=xl267112>&nbsp;</td>
  <td class=xl267112>&nbsp;</td>
  <td class=xl267112>&nbsp;</td>
  <td class=xl267112>&nbsp;</td>
  <td class=xl267112>&nbsp;</td>
  <td class=xl267112>&nbsp;</td>
  <td class=xl267112>&nbsp;</td>
  <td class=xl267112>&nbsp;</td>
  <td class=xl267112>&nbsp;</td>
  <td class=xl267112>&nbsp;</td>
  <td class=xl267112>&nbsp;</td>
  <td class=xl267112>&nbsp;</td>
  <td class=xl267112>&nbsp;</td>
  <td class=xl267112>&nbsp;</td>
  <td class=xl267112>&nbsp;</td>
  <td class=xl267112>&nbsp;</td>
 </tr>
 <tr height=51 style='height:38.25pt'>
  <td height=51 class=xl287112 width=43 style='height:38.25pt;width:32pt'>№ файла</td>
  <td class=xl287112 width=74 style='border-left:none;width:56pt'>Порядковый номер В файле</td>
  <td class=xl287112 width=32 style='border-left:none;width:24pt'>№</td>
  <td class=xl287112 width=152 style='border-left:none;width:114pt'>Название</td>
  <td class=xl287112 width=93 style='border-left:none;width:70pt'>№№</td>
  <td class=xl287112 width=115 style='border-left:none;width:86pt'>Название</td>
  <td class=xl287112 width=64 style='border-left:none;width:48pt'>Тип апп-ры</td>
  <td class=xl287112 width=62 style='border-left:none;width:47pt'>Высота 1</td>
  <td class=xl287112 width=64 style='border-left:none;width:48pt'>Высота 2</td>
  <td class=xl287112 width=60 style='border-left:none;width:45pt'>Азимут</td>
  <td class=xl287112 width=63 style='border-left:none;width:47pt'>Расст-ие</td>
  <td class=xl287112 width=63 style='border-left:none;width:47pt'>Мощность, ДБм</td>
  <td class=xl287112 width=61 style='border-left:none;width:46pt'>Скорость</td>
  <td class=xl287112 width=59 style='border-left:none;width:44pt'>Диам. 1</td>
  <td class=xl287112 width=63 style='border-left:none;width:47pt'>Диам. 2</td>
  <td class=xl287112 width=63 style='border-left:none;width:47pt'>Передача</td>
  <td class=xl287112 width=40 style='border-left:none;width:30pt'>Прием</td>
 </tr>
<logic:iterate id="reportLine" name="reportList" type="com.hps.july.basestation.valueobject.ReportComlinesValue">
<logic:present name="reportLine">
 <tr height=34 style='height:25.5pt'>
  <td height=34 class=xl247112 width=43 style='height:25.5pt;border-top:none;width:32pt' x:num><july:stringwrite name="reportLine" property="filenumber"/></td>
  <td class=xl247112 width=74 style='border-top:none;border-left:none;width:56pt' x:num><july:stringwrite name="reportLine" property="numberinfile"/></td>
  <td class=xl247112 width=32 style='border-top:none;border-left:none;width:24pt' x:num><july:stringwrite name="reportLine" property="posaid"/></td>
  <td class=xl247112 width=152 style='border-top:none;border-left:none;width:114pt'><july:stringwrite name="reportLine" property="posaname"/></td>
  <td class=xl247112 width=93 style='border-top:none;border-left:none;width:70pt' x:num><july:stringwrite name="reportLine" property="posbid"/></td>
  <td class=xl247112 width=115 style='border-top:none;border-left:none;width:86pt'><july:stringwrite name="reportLine" property="posbname"/></td>
  <td class=xl247112 width=64 style='border-top:none;border-left:none;width:48pt'><july:stringwrite name="reportLine" property="resmodel"/></td>
  <td class=xl247112 width=62 style='border-top:none;border-left:none;width:47pt' x:num><july:stringwrite name="reportLine" property="height_a"/></td>
  <td class=xl247112 width=64 style='border-top:none;border-left:none;width:48pt' x:num><july:stringwrite name="reportLine" property="height_b"/></td>
  <td class=xl247112 width=60 style='border-top:none;border-left:none;width:45pt' x:num><july:stringwrite name="reportLine" property="azimuthAB"/></td>
  <td class=xl247112 width=63 style='border-top:none;border-left:none;width:47pt' x:num><july:stringwrite name="reportLine" property="lengthAB"/></td>
  <td class=xl247112 width=63 style='border-top:none;border-left:none;width:47pt' x:num><july:stringwrite name="reportLine" property="power"/></td>
  <td class=xl247112 width=61 style='border-top:none;border-left:none;width:46pt'><july:stringwrite name="reportLine" property="speed"/></td>
  <td class=xl247112 width=59 style='border-top:none;border-left:none;width:44pt' x:num><july:stringwrite name="reportLine" property="diam_a"/></td>
  <td class=xl247112 width=63 style='border-top:none;border-left:none;width:47pt' x:num><july:stringwrite name="reportLine" property="diam_b"/></td>
  <td class=xl247112 width=63 style='border-top:none;border-left:none;width:47pt' x:num><july:stringwrite name="reportLine" property="frequency_a"/></td>
  <td class=xl247112 width=40 style='border-top:none;border-left:none;width:30pt' x:num><july:stringwrite name="reportLine" property="frequency_b"/></td>
 </tr>
</logic:present>
</logic:iterate>
 <![if supportMisalignedColumns]>
 <tr height=0 style='display:none'>
  <td width=43 style='width:32pt'></td>
  <td width=74 style='width:56pt'></td>
  <td width=32 style='width:24pt'></td>
  <td width=152 style='width:114pt'></td>
  <td width=93 style='width:70pt'></td>
  <td width=115 style='width:86pt'></td>
  <td width=64 style='width:48pt'></td>
  <td width=62 style='width:47pt'></td>
  <td width=64 style='width:48pt'></td>
  <td width=60 style='width:45pt'></td>
  <td width=63 style='width:47pt'></td>
  <td width=63 style='width:47pt'></td>
  <td width=61 style='width:46pt'></td>
  <td width=59 style='width:44pt'></td>
  <td width=63 style='width:47pt'></td>
  <td width=63 style='width:47pt'></td>
  <td width=40 style='width:30pt'></td>
 </tr>
 <![endif]>
</table>

</div>
</body>

</html>
