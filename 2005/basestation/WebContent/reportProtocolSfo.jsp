<%@ page language = "java" %>
<%@ page contentType = "application/vnd.ms-excel; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import="com.hps.july.basestation.valueobject.*"%>
<%@ page import="com.hps.july.util.*"%>

<html xmlns:o="urn:schemas-microsoft-com:office:office" xmlns:x="urn:schemas-microsoft-com:office:excel" xmlns="http://www.w3.org/TR/REC-html40">

<head>
<meta http-equiv=Content-Type content="text/html; charset=windows-1251">
<meta name=ProgId content=Excel.Sheet>
<meta name=Generator content="Microsoft Excel 10">
<style>
<!--table
	{mso-displayed-decimal-separator:"\,";
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
	border:none;
	mso-background-source:auto;
	mso-pattern:auto;
	mso-protection:locked visible;
	white-space:nowrap;
	mso-rotate:0;}
.xl24
	{mso-style-parent:style0;
	font-family:"Arial Narrow", sans-serif;
	mso-font-charset:204;}
.xl25
	{mso-style-parent:style0;
	font-size:9.0pt;
	font-family:"Arial Narrow", sans-serif;
	mso-font-charset:204;
	text-align:left;
	white-space:normal;}
.xl26
	{mso-style-parent:style0;
	font-family:"Arial Narrow", sans-serif;
	mso-font-charset:204;
	text-align:center;
	vertical-align:middle;
	border-top:1.0pt solid windowtext;
	border-right:.5pt solid windowtext;
	border-bottom:1.0pt solid windowtext;
	border-left:1.0pt solid windowtext;
	white-space:normal;}
.xl27
	{mso-style-parent:style0;
	font-family:"Arial Narrow", sans-serif;
	mso-font-charset:204;
	text-align:center;
	vertical-align:middle;
	border-top:1.0pt solid windowtext;
	border-right:.5pt solid windowtext;
	border-bottom:1.0pt solid windowtext;
	border-left:.5pt solid windowtext;
	white-space:normal;}
.xl28
	{mso-style-parent:style0;
	font-family:"Arial Narrow", sans-serif;
	mso-font-charset:204;
	text-align:center;
	vertical-align:middle;
	border-top:1.0pt solid windowtext;
	border-right:1.0pt solid windowtext;
	border-bottom:1.0pt solid windowtext;
	border-left:.5pt solid windowtext;
	white-space:normal;}
.xl29
	{mso-style-parent:style0;
	font-size:9.0pt;
	font-family:"Arial Narrow", sans-serif;
	mso-font-charset:204;
	text-align:left;
	border-top:1.0pt solid windowtext;
	border-right:.5pt solid windowtext;
	border-bottom:.5pt solid windowtext;
	border-left:1.0pt solid windowtext;
	white-space:normal;}
.xl30
	{mso-style-parent:style0;
	font-size:9.0pt;
	font-family:"Arial Narrow", sans-serif;
	mso-font-charset:204;
	text-align:left;
	border-top:1.0pt solid windowtext;
	border-right:.5pt solid windowtext;
	border-bottom:.5pt solid windowtext;
	border-left:.5pt solid windowtext;
	white-space:normal;}
.xl31
	{mso-style-parent:style0;
	font-size:9.0pt;
	font-family:"Arial Narrow", sans-serif;
	mso-font-charset:204;
	text-align:left;
	border-top:1.0pt solid windowtext;
	border-right:1.0pt solid windowtext;
	border-bottom:.5pt solid windowtext;
	border-left:.5pt solid windowtext;
	white-space:normal;}
.xl32
	{mso-style-parent:style0;
	font-size:9.0pt;
	font-family:"Arial Narrow", sans-serif;
	mso-font-charset:204;
	text-align:left;
	border-top:.5pt solid windowtext;
	border-right:.5pt solid windowtext;
	border-bottom:1.0pt solid windowtext;
	border-left:1.0pt solid windowtext;
	white-space:normal;}
.xl33
	{mso-style-parent:style0;
	font-size:9.0pt;
	font-family:"Arial Narrow", sans-serif;
	mso-font-charset:204;
	text-align:left;
	border-top:.5pt solid windowtext;
	border-right:.5pt solid windowtext;
	border-bottom:1.0pt solid windowtext;
	border-left:.5pt solid windowtext;
	white-space:normal;}
.xl34
	{mso-style-parent:style0;
	font-size:9.0pt;
	font-family:"Arial Narrow", sans-serif;
	mso-font-charset:204;
	text-align:left;
	border-top:.5pt solid windowtext;
	border-right:1.0pt solid windowtext;
	border-bottom:1.0pt solid windowtext;
	border-left:.5pt solid windowtext;
	white-space:normal;}
-->
</style>
</head>

<body link=blue vlink=purple>
<table x:str border=0 cellpadding=0 cellspacing=0 width=1787 style='border-collapse:collapse;table-layout:fixed;width:1341pt'>
 <col width=58 style='mso-width-source:userset;mso-width-alt:2121;width:44pt'>
 <col width=64 style='width:48pt'>
 <col width=97 span=2 style='mso-width-source:userset;width:75pt'>
 <col width=75 style='mso-width-source:userset;mso-width-alt:2742;width:56pt'>
 <col width=192 style='mso-width-source:userset;mso-width-alt:7021;width:144pt'>
 <col width=64 span=2 style='width:48pt'>
 <col width=69 style='mso-width-source:userset;mso-width-alt:2523;width:52pt'>
 <col width=64 span=4 style='width:48pt'>
 <col width=77 style='mso-width-source:userset;mso-width-alt:2816;width:58pt'>
 <col width=108 style='mso-width-source:userset;mso-width-alt:3949;width:81pt'>
 <col width=118 style='mso-width-source:userset;mso-width-alt:4315;width:89pt'>
<%--
 <col width=148 style='mso-width-source:userset;mso-width-alt:5412;width:111pt'>
--%>
 <col width=192 style='mso-width-source:userset;mso-width-alt:7021;width:144pt'>
 <tr class=xl24 height=59 style='mso-height-source:userset;height:44.25pt'>
  <td height=59 class=xl26 width=58 style='height:44.25pt;width:44pt'>№ файла</td>
  <td class=xl27 width=64 style='border-left:none;width:48pt'>№ GSM</td>
  <td class=xl27 width=87 style='border-left:none;width:65pt'>Название позиции</td>
  <td class=xl27 width=97 style='border-left:none;width:75pt'>Состояние пролёта</td>
  <td class=xl27 width=75 style='border-left:none;width:56pt'>Заводской №</td>
  <td class=xl27 width=192 style='border-left:none;width:144pt'>Адрес</td>
<%--
  <td class=xl27 width=64 style='border-left:none;width:48pt'>Широта</td>
  <td class=xl27 width=64 style='border-left:none;width:48pt'>Долгота</td>
--%>
  <td class=xl27 width=64 style='border-left:none;width:48pt'>Привязка к госсети, широта</td>
  <td class=xl27 width=64 style='border-left:none;width:48pt'>Привязка к госсети, долгота</td>
  <td class=xl27 width=69 style='border-left:none;width:52pt'>Тип аппаратуры</td>
  <td class=xl27 width=64 style='border-left:none;width:48pt'>Частота передачи</td>
  <td class=xl27 width=64 style='border-left:none;width:48pt'>Высота подвеса</td>
  <td class=xl27 width=64 style='border-left:none;width:48pt'>Класс излучения</td>
  <td class=xl27 width=64 style='border-left:none;width:48pt'>Мощность, Вт</td>
  <td class=xl27 width=77 style='border-left:none;width:58pt'>№ разрешения ФАС</td>
  <td class=xl27 width=108 style='border-left:none;width:81pt'>Дата выдачи разрешения ФАС</td>
  <td class=xl27 width=118 style='border-left:none;width:89pt'>Срок действия разрешения ФАС</td>
<%--
  <td class=xl27 width=148 style='border-left:none;width:111pt'>Адрес ГРЧЦ</td>
--%>
  <td class=xl28 width=192 style='border-left:none;width:144pt'>Комментарий</td>
 </tr>
<logic:iterate id="rl" name="reportList" type="com.hps.july.basestation.valueobject.ReportProtocolValue">
<logic:present name="rl">
<%
	String ahs = rl.getA().getHopsstate();
	String bhs = rl.getB().getHopsstate();
	if(ahs != null && !"".equals(ahs)) {
		ahs = "ComlineForm.state."+ahs;
	} else {
		ahs = "label.void";
	}
	if(bhs != null && !"".equals(bhs)) {
		bhs = "ComlineForm.state."+bhs;
	} else {
		bhs = "label.void";
	}
%>
 <tr class=xl25 height=18 style='mso-height-source:userset;height:13.5pt'>
  <td height=18 class=xl29 width=58 style='height:13.5pt;border-top:none;width:44pt' x:num><july:stringwrite name="rl" property="a.filenumber"/></td>
  <td class=xl30 width=64 style='border-top:none;border-left:none;width:48pt' x:num><july:stringwrite name="rl" property="a.gsmid"/></td>
  <td class=xl30 width=87 style='border-top:none;border-left:none;width:65pt'><july:stringwrite name="rl" property="a.posname"/></td>
  <td class=xl30 width=97 style='border-top:none;border-left:none;width:75pt'><bean:message key='<%=ahs%>'/></td>
  <td class=xl30 width=75 style='border-top:none;border-left:none;width:56pt'><july:stringwrite name="rl" property="a.vendorid"/></td>
  <td class=xl30 width=192 style='border-top:none;border-left:none;width:144pt'><july:stringwrite name="rl" property="a.address"/></td>
<%--
  <td class=xl30 width=64 style='border-top:none;border-left:none;width:48pt'><july:stringwrite name="rl" property="a.lat"/></td>
  <td class=xl30 width=64 style='border-top:none;border-left:none;width:48pt'><july:stringwrite name="rl" property="a.long"/></td>
--%>
  <td class=xl30 width=64 style='border-top:none;border-left:none;width:48pt'><july:stringwrite name="rl" property="a.goslatitude"/></td>
  <td class=xl30 width=64 style='border-top:none;border-left:none;width:48pt'><july:stringwrite name="rl" property="a.goslongitude"/></td>
  <td class=xl30 width=69 style='border-top:none;border-left:none;width:52pt'><july:stringwrite name="rl" property="a.resmodel"/></td>
  <td class=xl30 width=64 style='border-top:none;border-left:none;width:48pt'><july:stringwrite name="rl" property="a.frequency"/></td>
  <td class=xl30 width=64 style='border-top:none;border-left:none;width:48pt'><july:stringwrite name="rl" property="a.height"/></td>
  <td class=xl30 width=64 style='border-top:none;border-left:none;width:48pt'><july:stringwrite name="rl" property="a.emclass"/></td>
  <td class=xl30 width=64 style='border-top:none;border-left:none;width:48pt'><july:numberwrite name="rl" property="a.power"/></td>
  <td class=xl30 width=77 style='border-top:none;border-left:none;width:58pt'><july:stringwrite name="rl" property="a.fasnum"/></td>
  <td class=xl30 width=108 style='border-top:none;border-left:none;width:81pt'><july:datewrite name="rl" property="a.fasdate"/></td>
  <td class=xl30 width=118 style='border-top:none;border-left:none;width:89pt'><july:datewrite name="rl" property="a.fasexpire"/></td>
<%--
  <td class=xl30 width=148 style='border-top:none;border-left:none;width:111pt'><july:stringwrite name="rl" property="a.grchaddress"/></td>
--%>
  <td class=xl31 width=192 style='border-top:none;border-left:none;width:144pt'><july:stringwrite name="rl" property="a.comment"/></td>
 </tr>
 <tr class=xl25 height=19 style='height:14.25pt'>
  <td height=19 class=xl32 width=58 style='height:14.25pt;border-top:none;width:44pt' x:num><july:stringwrite name="rl" property="b.filenumber"/></td>
  <td class=xl33 width=64 style='border-top:none;border-left:none;width:48pt' x:num><july:stringwrite name="rl" property="b.gsmid"/></td>
  <td class=xl33 width=87 style='border-top:none;border-left:none;width:65pt'><july:stringwrite name="rl" property="b.posname"/></td>
  <td class=xl33 width=97 style='border-top:none;border-left:none;width:75pt'><bean:message key='<%=bhs%>'/></td>
  <td class=xl33 width=75 style='border-top:none;border-left:none;width:56pt'><july:stringwrite name="rl" property="b.vendorid"/></td>
  <td class=xl33 width=192 style='border-top:none;border-left:none;width:144pt'><july:stringwrite name="rl" property="b.address"/></td>
<%--
  <td class=xl33 width=64 style='border-top:none;border-left:none;width:48pt'><july:stringwrite name="rl" property="b.lat"/></td>
  <td class=xl33 width=64 style='border-top:none;border-left:none;width:48pt'><july:stringwrite name="rl" property="b.long"/></td>
--%>
  <td class=xl33 width=64 style='border-top:none;border-left:none;width:48pt'><july:stringwrite name="rl" property="b.goslatitude"/></td>
  <td class=xl33 width=64 style='border-top:none;border-left:none;width:48pt'><july:stringwrite name="rl" property="b.goslongitude"/></td>
  <td class=xl33 width=69 style='border-top:none;border-left:none;width:52pt'><july:stringwrite name="rl" property="b.resmodel"/></td>
  <td class=xl33 width=64 style='border-top:none;border-left:none;width:48pt'><july:stringwrite name="rl" property="b.frequency"/></td>
  <td class=xl33 width=64 style='border-top:none;border-left:none;width:48pt'><july:stringwrite name="rl" property="b.height"/></td>
  <td class=xl33 width=64 style='border-top:none;border-left:none;width:48pt'><july:stringwrite name="rl" property="b.emclass"/></td>
  <td class=xl33 width=64 style='border-top:none;border-left:none;width:48pt'><july:numberwrite name="rl" property="b.power"/></td>
  <td class=xl33 width=77 style='border-top:none;border-left:none;width:58pt'><july:stringwrite name="rl" property="b.fasnum"/></td>
  <td class=xl33 width=108 style='border-top:none;border-left:none;width:81pt'><july:datewrite name="rl" property="b.fasdate"/></td>
  <td class=xl33 width=118 style='border-top:none;border-left:none;width:89pt'><july:datewrite name="rl" property="b.fasexpire"/></td>
<%--
  <td class=xl33 width=148 style='border-top:none;border-left:none;width:111pt'><july:stringwrite name="rl" property="b.grchaddress"/></td>
--%>
  <td class=xl34 width=192 style='border-top:none;border-left:none;width:144pt'><july:stringwrite name="rl" property="b.comment"/></td>
 </tr>
</logic:present>
</logic:iterate>
</table>
</body>
</html>
