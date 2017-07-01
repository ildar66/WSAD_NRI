<%@ page language = "java" %>
<%@ page contentType = "application/msword; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import="com.hps.july.util.*"%>
<%@ page import="com.hps.july.cdbc.lib.*"%>
<%@ page import="com.hps.july.cdbc.objects.*"%>
<%@ page import="com.hps.july.logic.*"%>
<%@ page import="com.hps.july.basestation.valueobject.ReportRequestLetterValue"%>
<%@ page import="java.util.*"%>
<%
	String filenumber = (String)request.getAttribute("filenumber");

	response.setHeader("Cache-Control", "no-cache");
	response.setContentType("application/msword; name=File"+filenumber+".doc; charset=windows-1251");
	response.setHeader ("Content-Disposition", "attachment; filename=File"+filenumber+".doc");
                                
%>
<html xmlns:v="urn:schemas-microsoft-com:vml" xmlns:o="urn:schemas-microsoft-com:office:office" xmlns:w="urn:schemas-microsoft-com:office:word" xmlns="http://www.w3.org/TR/REC-html40">

<head>
<meta http-equiv=Content-Type content="text/html; charset=windows-1251">
<meta name=ProgId content=Word.Document>
<link rel=File-List href="File<%=filenumber%>.files/filelist.xml">
<!--[if !mso]>
<style>
v\:* {behavior:url(#default#VML);}
o\:* {behavior:url(#default#VML);}
w\:* {behavior:url(#default#VML);}
.shape {behavior:url(#default#VML);}
</style>
<![endif]-->
<title> </title>
<!--[if gte mso 9]><xml>
 <o:DocumentProperties>
  <o:Author>User</o:Author>
  <o:Template>Бланк письма черн-бел.dot</o:Template>
  <o:LastAuthor>Anthon</o:LastAuthor>
  <o:Revision>2</o:Revision>
  <o:TotalTime>1</o:TotalTime>
  <o:LastPrinted>2004-11-15T08:48:00Z</o:LastPrinted>
  <o:Created>2005-03-16T12:27:00Z</o:Created>
  <o:LastSaved>2005-03-16T12:27:00Z</o:LastSaved>
  <o:Pages>1</o:Pages>
  <o:Words>257</o:Words>
  <o:Characters>1471</o:Characters>
  <o:Company>SOHO</o:Company>
  <o:Lines>12</o:Lines>
  <o:Paragraphs>3</o:Paragraphs>
  <o:CharactersWithSpaces>1725</o:CharactersWithSpaces>
  <o:Version>10.2625</o:Version>
 </o:DocumentProperties>
</xml><![endif]--><!--[if gte mso 9]><xml>
 <w:WordDocument>
  <w:SpellingState>Clean</w:SpellingState>
  <w:GrammarState>Clean</w:GrammarState>
  <w:DisplayHorizontalDrawingGridEvery>0</w:DisplayHorizontalDrawingGridEvery>
  <w:DisplayVerticalDrawingGridEvery>0</w:DisplayVerticalDrawingGridEvery>
  <w:UseMarginsForDrawingGridOrigin/>
  <w:BrowserLevel>MicrosoftInternetExplorer4</w:BrowserLevel>
 </w:WordDocument>
</xml><![endif]-->
<style>
<!--
 /* Font Definitions */
 @font-face
	{font-family:Times;
	panose-1:2 2 6 3 5 4 5 2 3 4;
	mso-font-charset:204;
	mso-generic-font-family:roman;
	mso-font-pitch:variable;
	mso-font-signature:536902279 -2147483648 8 0 511 0;}
@font-face
	{font-family:HelveticaCyrillic;
	mso-font-charset:0;
	mso-generic-font-family:auto;
	mso-font-pitch:variable;
	mso-font-signature:50331648 0 0 0 1 0;}
 /* Style Definitions */
 p.MsoNormal, li.MsoNormal, div.MsoNormal
	{mso-style-parent:"";
	margin:0cm;
	margin-bottom:.0001pt;
	mso-pagination:widow-orphan;
	font-size:12.0pt;
	mso-bidi-font-size:10.0pt;
	font-family:Times;
	mso-fareast-font-family:Times;
	mso-bidi-font-family:"Times New Roman";
	mso-ansi-language:EN-US;}
h1
	{mso-style-next:Обычный;
	margin-top:29.0pt;
	margin-right:0cm;
	margin-bottom:0cm;
	margin-left:0cm;
	margin-bottom:.0001pt;
	text-indent:19.85pt;
	mso-pagination:none;
	page-break-after:avoid;
	mso-outline-level:1;
	tab-stops:4.5pt;
	mso-layout-grid-align:none;
	text-autospace:none;
	font-size:10.0pt;
	font-family:Times;
	mso-bidi-font-family:"Times New Roman";
	color:black;
	mso-font-kerning:0pt;
	font-weight:normal;
	font-style:italic;}
h4
	{mso-style-next:Обычный;
	margin:0cm;
	margin-bottom:.0001pt;
	text-align:center;
	mso-pagination:widow-orphan;
	page-break-after:avoid;
	mso-outline-level:4;
	font-size:14.0pt;
	mso-bidi-font-size:10.0pt;
	font-family:"Times New Roman";
	mso-fareast-font-family:"Times New Roman";
	font-weight:normal;}
h5
	{mso-style-next:Обычный;
	margin-top:0cm;
	margin-right:-7.1pt;
	margin-bottom:0cm;
	margin-left:0cm;
	margin-bottom:.0001pt;
	text-align:right;
	mso-pagination:widow-orphan;
	page-break-after:avoid;
	mso-outline-level:5;
	font-size:14.0pt;
	mso-bidi-font-size:10.0pt;
	font-family:"Times New Roman";
	mso-fareast-font-family:"Times New Roman";
	mso-bidi-font-weight:normal;}
h6
	{mso-style-next:Обычный;
	margin:0cm;
	margin-bottom:.0001pt;
	text-align:justify;
	text-indent:1.0cm;
	mso-pagination:widow-orphan;
	page-break-after:avoid;
	mso-outline-level:6;
	font-size:14.0pt;
	mso-bidi-font-size:10.0pt;
	font-family:"Times New Roman";
	mso-fareast-font-family:"Times New Roman";
	font-weight:normal;}
p.MsoHeader, li.MsoHeader, div.MsoHeader
	{margin:0cm;
	margin-bottom:.0001pt;
	mso-pagination:widow-orphan;
	tab-stops:center 216.0pt right 432.0pt;
	font-size:12.0pt;
	mso-bidi-font-size:10.0pt;
	font-family:Times;
	mso-fareast-font-family:Times;
	mso-bidi-font-family:"Times New Roman";
	mso-ansi-language:EN-US;}
p.MsoFooter, li.MsoFooter, div.MsoFooter
	{margin:0cm;
	margin-bottom:.0001pt;
	mso-pagination:widow-orphan;
	tab-stops:center 216.0pt right 432.0pt;
	font-size:12.0pt;
	mso-bidi-font-size:10.0pt;
	font-family:Times;
	mso-fareast-font-family:Times;
	mso-bidi-font-family:"Times New Roman";
	mso-ansi-language:EN-US;}
p.MsoBodyText, li.MsoBodyText, div.MsoBodyText
	{margin:0cm;
	margin-bottom:.0001pt;
	text-align:center;
	mso-pagination:widow-orphan;
	font-size:12.0pt;
	mso-bidi-font-size:10.0pt;
	font-family:Times;
	mso-fareast-font-family:Times;
	mso-bidi-font-family:"Times New Roman";}
p.MsoBodyTextIndent, li.MsoBodyTextIndent, div.MsoBodyTextIndent
	{margin-top:0cm;
	margin-right:0cm;
	margin-bottom:0cm;
	margin-left:28.4pt;
	margin-bottom:.0001pt;
	mso-pagination:widow-orphan;
	font-size:12.0pt;
	mso-bidi-font-size:10.0pt;
	font-family:HelveticaCyrillic;
	mso-ascii-font-family:HelveticaCyrillic;
	mso-fareast-font-family:Times;
	mso-hansi-font-family:HelveticaCyrillic;
	mso-bidi-font-family:"Times New Roman";
	mso-ansi-language:EN-US;}
p.MsoBodyText2, li.MsoBodyText2, div.MsoBodyText2
	{margin-top:18.0pt;
	margin-right:0cm;
	margin-bottom:0cm;
	margin-left:0cm;
	margin-bottom:.0001pt;
	text-align:justify;
	mso-pagination:widow-orphan;
	font-size:12.0pt;
	mso-bidi-font-size:10.0pt;
	font-family:Times;
	mso-fareast-font-family:Times;
	mso-bidi-font-family:"Times New Roman";
	color:black;}
p.MsoBodyTextIndent2, li.MsoBodyTextIndent2, div.MsoBodyTextIndent2
	{margin:0cm;
	margin-bottom:.0001pt;
	text-indent:19.85pt;
	line-height:150%;
	mso-pagination:widow-orphan;
	font-size:12.0pt;
	font-family:"Times New Roman";
	mso-fareast-font-family:"Times New Roman";}
p.MsoBodyTextIndent3, li.MsoBodyTextIndent3, div.MsoBodyTextIndent3
	{margin-top:0cm;
	margin-right:0cm;
	margin-bottom:0cm;
	margin-left:297.0pt;
	margin-bottom:.0001pt;
	mso-pagination:widow-orphan;
	font-size:12.0pt;
	mso-bidi-font-size:10.0pt;
	font-family:Times;
	mso-fareast-font-family:Times;
	mso-bidi-font-family:"Times New Roman";}
p.MsoBlockText, li.MsoBlockText, div.MsoBlockText
	{margin-top:0cm;
	margin-right:-31.55pt;
	margin-bottom:0cm;
	margin-left:78.1pt;
	margin-bottom:.0001pt;
	mso-pagination:widow-orphan;
	font-size:12.0pt;
	mso-bidi-font-size:10.0pt;
	font-family:Times;
	mso-fareast-font-family:Times;
	mso-bidi-font-family:"Times New Roman";
	mso-ansi-language:EN-US;}
span.SpellE
	{mso-style-name:"";
	mso-spl-e:yes;}
span.GramE
	{mso-style-name:"";
	mso-gram-e:yes;}
@page Section1
	{size:612.0pt 792.0pt;
	margin:1.0cm 2.0cm 0cm 2.0cm;
	mso-header-margin:39.7pt;
	mso-footer-margin:0cm;
	mso-header:url("File<%=filenumber%>.files/beeline_header.htm") h1;
	mso-paper-source:0;}
div.Section1
	{page:Section1;}
 /* List Definitions */
 @list l0
	{mso-list-id:179779590;
	mso-list-type:hybrid;
	mso-list-template-ids:-376304356 68747279 68747289 68747291 68747279 68747289 68747291 68747279 68747289 68747291;}
@list l0:level1
	{mso-level-tab-stop:36.0pt;
	mso-level-number-position:left;
	text-indent:-18.0pt;}
@list l0:level3
	{mso-level-number-format:roman-lower;
	mso-level-tab-stop:108.0pt;
	mso-level-number-position:right;
	text-indent:-9.0pt;}
@list l1
	{mso-list-id:839272646;
	mso-list-type:hybrid;
	mso-list-template-ids:975576398 68747279 68747289 68747291 68747279 68747289 68747291 68747279 68747289 68747291;}
@list l1:level1
	{mso-level-tab-stop:36.0pt;
	mso-level-number-position:left;
	text-indent:-18.0pt;}
@list l1:level3
	{mso-level-number-format:roman-lower;
	mso-level-tab-stop:108.0pt;
	mso-level-number-position:right;
	text-indent:-9.0pt;}
@list l2
	{mso-list-id:994801918;
	mso-list-type:hybrid;
	mso-list-template-ids:431549612 147195904 68747289 68747291 68747279 68747289 68747291 68747279 68747289 68747291;}
@list l2:level1
	{mso-level-tab-stop:45.35pt;
	mso-level-number-position:left;
	margin-left:45.35pt;
	text-indent:-45.35pt;}
ol
	{margin-bottom:0cm;}
ul
	{margin-bottom:0cm;}
-->
</style>
<!--[if gte mso 10]>
<style>
 /* Style Definitions */
 table.MsoNormalTable
	{mso-style-name:"Обычная таблица";
	mso-tstyle-rowband-size:0;
	mso-tstyle-colband-size:0;
	mso-style-noshow:yes;
	mso-style-parent:"";
	mso-padding-alt:0cm 5.4pt 0cm 5.4pt;
	mso-para-margin:0cm;
	mso-para-margin-bottom:.0001pt;
	mso-pagination:widow-orphan;
	font-size:10.0pt;
	font-family:Times;
	mso-bidi-font-family:"Times New Roman";}
</style>
<![endif]--><!--[if gte mso 9]><xml>
 <o:shapedefaults v:ext="edit" spidmax="3074">
  <o:colormenu v:ext="edit" fillcolor="none" strokecolor="none"/>
 </o:shapedefaults></xml><![endif]--><!--[if gte mso 9]><xml>
 <o:shapelayout v:ext="edit">
  <o:idmap v:ext="edit" data="1"/>
 </o:shapelayout></xml><![endif]-->
</head>

<body lang=RU style='tab-interval:36.0pt'>

<div class=Section1>
<%
	String addressee = null;
	Object addresseeObj = request.getAttribute("addressee");
	if(addresseeObj != null) {
		addressee = (String)addresseeObj;
	}
%>
<p class=MsoNormal align=right style='text-align:right'><b><i><span style='font-size:11.0pt;mso-bidi-font-size:10.0pt;font-family:"Times New Roman";mso-ansi-language:RU'>ЗАМЕСТИТЕЛЮ ДИРЕКТОРА ФГУП<o:p></o:p></span></i></b></p>
<p class=MsoNormal align=right style='text-align:right'><b><i><span style='font-size:11.0pt;mso-bidi-font-size:10.0pt;font-family:"Times New Roman";mso-ansi-language:RU'>&laquo;ГЛАВНЫЙ РАДИОЧАСТОТНЫЙ ЦЕНТР&raquo;<o:p></o:p></span></i></b></p>

<p class=MsoNormal align=right style='margin-top:6.0pt;margin-right:0cm;margin-bottom:6.0pt;margin-left:0cm;text-align:right'><!--[if gte vml 1]><v:line id="_x0000_s1040" style='position:absolute;left:0;text-align:left;z-index:1' from="166.35pt,23.9pt" to="499.35pt,23.9pt" strokeweight="1.25pt"/><![endif]--><![if !vml]>
<span style='mso-ignore:vglayout;position:absolute;z-index:1;left:0px;margin-left:220px;margin-top:31px;width:447px;height:2px'><img width=447 height=2 src="/GetReportFiles/underline.gif" v:shapes="_x0000_s1040"></span><![endif]><b><span style='font-size:11.0pt;mso-bidi-font-size:10.0pt;font-family:"Times New Roman"; mso-ansi-language:RU'><% if(addressee != null && addressee.length() != 0) { out.print(addressee);}%><o:p></o:p></span></b></p>

<p class=MsoHeader align=right style='margin-top:12.0pt;margin-right:0cm;margin-bottom:6.0pt;margin-left:0cm;text-align:right;tab-stops:36.0pt'><span
style='font-size:11.0pt;mso-bidi-font-size:10.0pt;font-family:"Times New Roman";mso-ansi-language:RU'>119991, ГСП-1, г. Москва, В-49, 2-й <span class=SpellE>Спасоналивковский</span> пер., 6<o:p></o:p></span></p>

<p class=MsoNormal align=right style='text-align:right'><b style='mso-bidi-font-weight:normal'><span style='mso-ansi-language:RU'><span style='mso-spacerun:yes'>                                                                </span></span></b><span style='mso-ansi-language:RU'><o:p></o:p></span></p>

<p class=MsoNormal align=right style='text-align:right'><span style='mso-ansi-language:RU'><o:p>&nbsp;</o:p></span></p>

<h4><span style='font-size:11.0pt;mso-bidi-font-size:10.0pt'>Уважаемый Юрий Анатольевич!<o:p></o:p></span></h4>

<p class=MsoNormal><span style='font-size:11.0pt;mso-bidi-font-size:10.0pt;font-family:"Times New Roman";mso-ansi-language:RU'><o:p>&nbsp;</o:p></span></p>
<%
	String models = null;
	String speeds = null;
	Object reportObj = request.getAttribute("reportList");
	ReportRequestLetterValue reportValue = null;
	if(reportObj != null) {
		reportValue = (ReportRequestLetterValue)reportObj;
		models = reportValue.getModelsString();
		speeds = reportValue.getSpeedsString();
	}

	int poscount = 0;
	CDBCSitedocsObject sdo = new CDBCSitedocsObject();
	poscount = sdo.findFrequencyLicencePositionsCnt(filenumber);
%>
<p class=MsoNormal style='text-align:justify;text-indent:19.85pt'><span style='font-size:11.0pt;mso-bidi-font-size:10.0pt;font-family:"Times New Roman";mso-ansi-language:RU'>ОАО &laquo;<span class=SpellE>Вымпел-Коммуникации</span>&raquo; планирует организовать <%=reportValue.getQuantityString()%> с целью строительства транспортной сети <span class=GramE>в</span> г. <span class=GramE>Москва</span> и Московской области с использованием РРС <% if(models != null) out.print(models); %>.</span>
<span style='font-size:11.0pt;mso-bidi-font-size:10.0pt;font-family:"Times New Roman";mso-ansi-language:RU'>Скорость<span style='mso-spacerun:yes'>  </span>цифрового потока 34 Мбит/<span class=GramE>с</span>.<o:p></o:p></span></p>

<p class=MsoNormal style='text-align:justify;text-indent:19.85pt'><span
style='font-size:11.0pt;mso-bidi-font-size:10.0pt;font-family:"Times New Roman";
mso-ansi-language:RU'>Прошу Вас выдать заключение экспертизы о возможности
использования заявленных радиоэлектронных средств с учетом их ЭМС с <span
class=GramE>действующими</span> и планируемыми РЭС различного назначения. <o:p></o:p></span></p>

<p class=MsoNormal style='text-align:justify;text-indent:19.85pt'><span
style='font-size:11.0pt;mso-bidi-font-size:10.0pt;font-family:"Times New Roman";
mso-ansi-language:RU'>Перечисленные ниже документы, а именно: Устав ОАО &laquo;<span
class=SpellE>Вымпел-Коммуникации</span>&raquo;, свидетельство<span
style='mso-spacerun:yes'>  </span>о внесении в ЕГРЮЛ, свидетельство<span
style='mso-spacerun:yes'>  </span>о постановке на учет в налоговом органе, а
также лицензии<span class=GramE> А</span> 023340 № 23785,<span
style='mso-spacerun:yes'>  </span>А 028604 № 28733<span
style='mso-spacerun:yes'>  </span>и А 019335 № 19979 были направлены в Ваш
адрес (<span class=SpellE>исх</span>. от 11.10.2004 г. №1451/04-и03).<o:p></o:p></span></p>

<p class=MsoNormal style='margin-top:6.0pt;margin-right:0cm;margin-bottom:6.0pt;
margin-left:0cm;text-align:justify;text-indent:19.85pt'><span style='font-size:
11.0pt;mso-bidi-font-size:10.0pt;font-family:"Times New Roman";mso-ansi-language:
RU'>Оплату гарантируем по срочному тарифу.<o:p></o:p></span></p>

<p class=MsoBodyTextIndent2 style='line-height:normal;tab-stops:106.35pt'><span
style='font-size:11.0pt;mso-bidi-font-size:10.0pt;mso-fareast-font-family:Times'>Наши
реквизиты: <o:p></o:p></span></p>

<p class=MsoNormal style='text-indent:127.6pt;tab-stops:106.35pt'><span
style='font-size:11.0pt;mso-bidi-font-size:10.0pt;font-family:"Times New Roman";
mso-ansi-language:RU'>127083, г. Москва, ул. Восьмого Марта, дом 10, стр.14<o:p></o:p></span></p>

<p class=MsoNormal style='text-indent:127.6pt;tab-stops:106.35pt'><span
style='font-size:11.0pt;mso-bidi-font-size:10.0pt;font-family:"Times New Roman";
mso-ansi-language:RU'>ОАО &laquo;<span class=SpellE>Вымпел-Коммуникации</span>&raquo;<o:p></o:p></span></p>

<p class=MsoNormal style='text-indent:127.6pt;tab-stops:106.35pt'><span
style='font-size:11.0pt;mso-bidi-font-size:10.0pt;font-family:"Times New Roman";
mso-ansi-language:RU'>Сбербанк России, г. Москва <span class=SpellE>Вернадское</span>
ОСБ №7970<o:p></o:p></span></p>

<p class=MsoNormal style='text-indent:127.6pt;tab-stops:106.35pt'><span
class=SpellE><span class=GramE><span style='font-size:11.0pt;mso-bidi-font-size:
10.0pt;font-family:"Times New Roman";mso-ansi-language:RU'>р</span></span></span><span
style='font-size:11.0pt;mso-bidi-font-size:10.0pt;font-family:"Times New Roman";
mso-ansi-language:RU'>/с 40702810138180121008,<o:p></o:p></span></p>

<p class=MsoNormal style='text-indent:127.6pt;tab-stops:106.35pt'><span
style='font-size:11.0pt;mso-bidi-font-size:10.0pt;font-family:"Times New Roman";
mso-ansi-language:RU'>к/с 30101810400000000225,<o:p></o:p></span></p>

<p class=MsoNormal style='text-indent:127.6pt;tab-stops:106.35pt'><span
style='font-size:11.0pt;mso-bidi-font-size:10.0pt;font-family:"Times New Roman";
mso-ansi-language:RU'>БИК 044525225, ИНН 7713076301<o:p></o:p></span></p>

<p class=MsoNormal style='margin-top:6.0pt;text-align:justify;text-indent:19.85pt'><span
style='font-size:11.0pt;mso-bidi-font-size:10.0pt;font-family:"Times New Roman";
mso-ansi-language:RU'>ПРИЛОЖЕНИЕ:<span style='mso-spacerun:yes'>  </span><o:p></o:p></span></p>

<table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 align=right
 style='border-collapse:collapse;mso-table-lspace:9.0pt;margin-left:6.75pt;
 mso-table-rspace:9.0pt;margin-right:6.75pt;mso-table-anchor-vertical:paragraph;
 mso-table-anchor-horizontal:margin;mso-table-left:right;mso-table-top:-.55pt;
 mso-padding-alt:0cm 5.4pt 0cm 5.4pt'>
 <tr style='height:14.1pt'>
  <td style='padding:0cm 5.4pt 0cm 5.4pt;height:14.1pt'>
  <h6 align=right style='margin-left:45.35pt;text-align:right;text-indent:-45.35pt;
  mso-list:l2 level1 lfo3;tab-stops:list 45.35pt;mso-element:frame;mso-element-frame-hspace:
  9.0pt;mso-element-wrap:around;mso-element-anchor-vertical:paragraph;
  mso-element-anchor-horizontal:margin;mso-element-left:right;mso-element-top:
  -.55pt;mso-height-rule:exactly'><![if !supportLists]><span style='font-size:
  11.0pt;mso-bidi-font-size:10.0pt'><span style='mso-list:Ignore'>1.<span
  style='font:7.0pt "Times New Roman"'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  </span></span></span><![endif]><span style='font-size:11.0pt;mso-bidi-font-size:
  10.0pt'><o:p>&nbsp;</o:p></span></h6>
  </td>
  <td style='padding:0cm 5.4pt 0cm 5.4pt;height:14.1pt'>
  <h6 style='text-indent:0cm;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-vertical:paragraph;mso-element-anchor-horizontal:
  margin;mso-element-left:right;mso-element-top:-.55pt;mso-height-rule:exactly'><span
  style='font-size:11.0pt;mso-bidi-font-size:10.0pt'>Решение ГКРЧ<o:p></o:p></span></h6>
  </td>
  <td style='padding:0cm 5.4pt 0cm 5.4pt;height:14.1pt'>
  <h6 align=left style='margin-right:-7.6pt;text-align:left;text-indent:0cm;
  mso-element:frame;mso-element-frame-hspace:9.0pt;mso-element-wrap:around;
  mso-element-anchor-vertical:paragraph;mso-element-anchor-horizontal:margin;
  mso-element-left:right;mso-element-top:-.55pt;mso-height-rule:exactly'><span
  style='font-size:11.0pt;mso-bidi-font-size:10.0pt'>2 листа в 1 экз.<o:p></o:p></span></h6>
  </td>
  <td style='padding:0cm 5.4pt 0cm 5.4pt;height:14.1pt'>
  <h6 style='text-indent:0cm;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-vertical:paragraph;mso-element-anchor-horizontal:
  margin;mso-element-left:right;mso-element-top:-.55pt;mso-height-rule:exactly'><span
  style='font-size:11.0pt;mso-bidi-font-size:10.0pt'>-<o:p></o:p></span></h6>
  </td>
  <td width=91 style='width:68.25pt;padding:0cm 5.4pt 0cm 5.4pt;height:14.1pt'>
  <h6 align=left style='text-align:left;text-indent:0cm;mso-element:frame;
  mso-element-frame-hspace:9.0pt;mso-element-wrap:around;mso-element-anchor-vertical:
  paragraph;mso-element-anchor-horizontal:margin;mso-element-left:right;
  mso-element-top:-.55pt;mso-height-rule:exactly'><span style='font-size:11.0pt;
  mso-bidi-font-size:10.0pt'>2 листа<o:p></o:p></span></h6>
  </td>
 </tr>
 <tr style='height:14.15pt'>
  <td style='padding:0cm 5.4pt 0cm 5.4pt;height:14.15pt'>
  <h6 align=right style='margin-left:45.35pt;text-align:right;text-indent:-45.35pt;
  mso-list:l2 level1 lfo3;tab-stops:list 45.35pt;mso-element:frame;mso-element-frame-hspace:
  9.0pt;mso-element-wrap:around;mso-element-anchor-vertical:paragraph;
  mso-element-anchor-horizontal:margin;mso-element-left:right;mso-element-top:
  -.55pt;mso-height-rule:exactly'><![if !supportLists]><span style='font-size:
  11.0pt;mso-bidi-font-size:10.0pt'><span style='mso-list:Ignore'>2.<span
  style='font:7.0pt "Times New Roman"'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  </span></span></span><![endif]><span style='font-size:11.0pt;mso-bidi-font-size:
  10.0pt'><o:p>&nbsp;</o:p></span></h6>
  </td>
  <td style='padding:0cm 5.4pt 0cm 5.4pt;height:14.15pt'>
  <h6 style='text-indent:0cm;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-vertical:paragraph;mso-element-anchor-horizontal:
  margin;mso-element-left:right;mso-element-top:-.55pt;mso-height-rule:exactly'><span
  style='font-size:11.0pt;mso-bidi-font-size:10.0pt'>Пояснительная записка<o:p></o:p></span></h6>
  </td>
  <td style='padding:0cm 5.4pt 0cm 5.4pt;height:14.15pt'>
  <h6 align=left style='text-align:left;text-indent:0cm;mso-element:frame;
  mso-element-frame-hspace:9.0pt;mso-element-wrap:around;mso-element-anchor-vertical:
  paragraph;mso-element-anchor-horizontal:margin;mso-element-left:right;
  mso-element-top:-.55pt;mso-height-rule:exactly'><span style='font-size:11.0pt;
  mso-bidi-font-size:10.0pt'>1 лист в 1 экз. <o:p></o:p></span></h6>
  </td>
  <td style='padding:0cm 5.4pt 0cm 5.4pt;height:14.15pt'>
  <h6 style='text-indent:0cm;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-vertical:paragraph;mso-element-anchor-horizontal:
  margin;mso-element-left:right;mso-element-top:-.55pt;mso-height-rule:exactly'><span
  style='font-size:11.0pt;mso-bidi-font-size:10.0pt'>-<o:p></o:p></span></h6>
  </td>
  <td width=91 style='width:68.25pt;padding:0cm 5.4pt 0cm 5.4pt;height:14.15pt'>
  <h6 align=left style='text-align:left;text-indent:0cm;mso-element:frame;
  mso-element-frame-hspace:9.0pt;mso-element-wrap:around;mso-element-anchor-vertical:
  paragraph;mso-element-anchor-horizontal:margin;mso-element-left:right;
  mso-element-top:-.55pt;mso-height-rule:exactly'><span style='font-size:11.0pt;
  mso-bidi-font-size:10.0pt'>1 лист<o:p></o:p></span></h6>
  </td>
 </tr>
 <tr style='height:14.15pt'>
  <td style='padding:0cm 5.4pt 0cm 5.4pt;height:14.15pt'>
  <h6 align=right style='margin-left:45.35pt;text-align:right;text-indent:-45.35pt;
  mso-list:l2 level1 lfo3;tab-stops:list 45.35pt;mso-element:frame;mso-element-frame-hspace:
  9.0pt;mso-element-wrap:around;mso-element-anchor-vertical:paragraph;
  mso-element-anchor-horizontal:margin;mso-element-left:right;mso-element-top:
  -.55pt;mso-height-rule:exactly'><![if !supportLists]><span style='font-size:
  11.0pt;mso-bidi-font-size:10.0pt'><span style='mso-list:Ignore'>3.<span
  style='font:7.0pt "Times New Roman"'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  </span></span></span><![endif]><span style='font-size:11.0pt;mso-bidi-font-size:
  10.0pt'><o:p>&nbsp;</o:p></span></h6>
  </td>
  <td style='padding:0cm 5.4pt 0cm 5.4pt;height:14.15pt'>
  <h6 style='text-indent:0cm;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-vertical:paragraph;mso-element-anchor-horizontal:
  margin;mso-element-left:right;mso-element-top:-.55pt;mso-height-rule:exactly'><span
  style='font-size:11.0pt;mso-bidi-font-size:10.0pt'>Исходные данные<o:p></o:p></span></h6>
  </td>
  <td style='padding:0cm 5.4pt 0cm 5.4pt;height:14.15pt'>
  <h6 align=left style='margin-right:-7.6pt;text-align:left;text-indent:0cm;
  mso-element:frame;mso-element-frame-hspace:9.0pt;mso-element-wrap:around;
  mso-element-anchor-vertical:paragraph;mso-element-anchor-horizontal:margin;
  mso-element-left:right;mso-element-top:-.55pt;mso-height-rule:exactly'><span
  style='font-size:11.0pt;mso-bidi-font-size:10.0pt'>1 лист в 2 экз.<span
  style='mso-spacerun:yes'>  </span><o:p></o:p></span></h6>
  </td>
  <td style='padding:0cm 5.4pt 0cm 5.4pt;height:14.15pt'>
  <h6 style='text-indent:0cm;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-vertical:paragraph;mso-element-anchor-horizontal:
  margin;mso-element-left:right;mso-element-top:-.55pt;mso-height-rule:exactly'><span
  style='font-size:11.0pt;mso-bidi-font-size:10.0pt'>-<o:p></o:p></span></h6>
  </td>
  <td width=91 style='width:68.25pt;padding:0cm 5.4pt 0cm 5.4pt;height:14.15pt'>
  <h6 align=left style='text-align:left;text-indent:0cm;mso-element:frame;
  mso-element-frame-hspace:9.0pt;mso-element-wrap:around;mso-element-anchor-vertical:
  paragraph;mso-element-anchor-horizontal:margin;mso-element-left:right;
  mso-element-top:-.55pt;mso-height-rule:exactly'><span style='font-size:11.0pt;
  mso-bidi-font-size:10.0pt'>2 листа<o:p></o:p></span></h6>
  </td>
 </tr>
 <tr style='height:14.15pt'>
  <td style='padding:0cm 5.4pt 0cm 5.4pt;height:14.15pt'>
  <h6 align=right style='margin-left:45.35pt;text-align:right;text-indent:-45.35pt;
  mso-list:l2 level1 lfo3;tab-stops:list 45.35pt;mso-element:frame;mso-element-frame-hspace:
  9.0pt;mso-element-wrap:around;mso-element-anchor-vertical:paragraph;
  mso-element-anchor-horizontal:margin;mso-element-left:right;mso-element-top:
  -.55pt;mso-height-rule:exactly'><![if !supportLists]><span style='font-size:
  11.0pt;mso-bidi-font-size:10.0pt'><span style='mso-list:Ignore'>4.<span
  style='font:7.0pt "Times New Roman"'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  </span></span></span><![endif]><span style='font-size:11.0pt;mso-bidi-font-size:
  10.0pt'><o:p>&nbsp;</o:p></span></h6>
  </td>
  <td style='padding:0cm 5.4pt 0cm 5.4pt;height:14.15pt'>
  <h6 style='text-indent:0cm;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-vertical:paragraph;mso-element-anchor-horizontal:
  margin;mso-element-left:right;mso-element-top:-.55pt;mso-height-rule:exactly'><span
  style='font-size:11.0pt;mso-bidi-font-size:10.0pt'>Форма №</span><span
  lang=EN-US style='font-size:11.0pt;mso-bidi-font-size:10.0pt;mso-ansi-language:
  EN-US'>I</span><span style='font-size:11.0pt;mso-bidi-font-size:10.0pt'>-РС,
  ФС, технические данные<o:p></o:p></span></h6>
  </td>
  <td style='padding:0cm 5.4pt 0cm 5.4pt;height:14.15pt'>
  <h6 align=left style='text-align:left;text-indent:0cm;mso-element:frame;
  mso-element-frame-hspace:9.0pt;mso-element-wrap:around;mso-element-anchor-vertical:
  paragraph;mso-element-anchor-horizontal:margin;mso-element-left:right;
  mso-element-top:-.55pt;mso-height-rule:exactly'><span style='font-size:11.0pt;
  mso-bidi-font-size:10.0pt'>2 листа в 10 экз.<span style='mso-spacerun:yes'> 
  </span><o:p></o:p></span></h6>
  </td>
  <td style='padding:0cm 5.4pt 0cm 5.4pt;height:14.15pt'>
  <h6 style='text-indent:0cm;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-vertical:paragraph;mso-element-anchor-horizontal:
  margin;mso-element-left:right;mso-element-top:-.55pt;mso-height-rule:exactly'><span
  style='font-size:11.0pt;mso-bidi-font-size:10.0pt'>-<o:p></o:p></span></h6>
  </td>
  <td width=91 style='width:68.25pt;padding:0cm 5.4pt 0cm 5.4pt;height:14.15pt'>
  <h6 align=left style='text-align:left;text-indent:0cm;mso-element:frame;
  mso-element-frame-hspace:9.0pt;mso-element-wrap:around;mso-element-anchor-vertical:
  paragraph;mso-element-anchor-horizontal:margin;mso-element-left:right;
  mso-element-top:-.55pt;mso-height-rule:exactly'><span style='font-size:11.0pt;
  mso-bidi-font-size:10.0pt'>20 листов<o:p></o:p></span></h6>
  </td>
 </tr>
 <tr style='height:14.15pt'>
  <td style='padding:0cm 5.4pt 0cm 5.4pt;height:14.15pt'>
  <h6 align=right style='margin-left:45.35pt;text-align:right;text-indent:-45.35pt;
  mso-list:l2 level1 lfo3;tab-stops:list 45.35pt;mso-element:frame;mso-element-frame-hspace:
  9.0pt;mso-element-wrap:around;mso-element-anchor-vertical:paragraph;
  mso-element-anchor-horizontal:margin;mso-element-left:right;mso-element-top:
  -.55pt;mso-height-rule:exactly'><![if !supportLists]><span style='font-size:
  11.0pt;mso-bidi-font-size:10.0pt'><span style='mso-list:Ignore'>5.<span
  style='font:7.0pt "Times New Roman"'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  </span></span></span><![endif]><span style='font-size:11.0pt;mso-bidi-font-size:
  10.0pt'><o:p>&nbsp;</o:p></span></h6>
  </td>
  <td style='padding:0cm 5.4pt 0cm 5.4pt;height:14.15pt'>
  <h6 style='text-indent:0cm;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-vertical:paragraph;mso-element-anchor-horizontal:
  margin;mso-element-left:right;mso-element-top:-.55pt;mso-height-rule:exactly'><span
  style='font-size:11.0pt;mso-bidi-font-size:10.0pt'>Схема размещения<o:p></o:p></span></h6>
  </td>
  <td style='padding:0cm 5.4pt 0cm 5.4pt;height:14.15pt'>
  <h6 align=left style='margin-right:-7.6pt;text-align:left;text-indent:0cm;
  mso-element:frame;mso-element-frame-hspace:9.0pt;mso-element-wrap:around;
  mso-element-anchor-vertical:paragraph;mso-element-anchor-horizontal:margin;
  mso-element-left:right;mso-element-top:-.55pt;mso-height-rule:exactly'><span
  style='font-size:11.0pt;mso-bidi-font-size:10.0pt'><%=poscount%> <%=TxtNumLogic.getSuffix(poscount,"лист")%> в 10 экз. <span
  style='mso-spacerun:yes'>  </span><o:p></o:p></span></h6>
  </td>
  <td style='padding:0cm 5.4pt 0cm 5.4pt;height:14.15pt'>
  <h6 style='text-indent:0cm;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-vertical:paragraph;mso-element-anchor-horizontal:
  margin;mso-element-left:right;mso-element-top:-.55pt;mso-height-rule:exactly'><span
  style='font-size:11.0pt;mso-bidi-font-size:10.0pt'>-<o:p></o:p></span></h6>
  </td>
  <td width=91 style='width:68.25pt;padding:0cm 5.4pt 0cm 5.4pt;height:14.15pt'>
  <h6 align=left style='margin-right:-7.1pt;text-align:left;text-indent:0cm;
  mso-element:frame;mso-element-frame-hspace:9.0pt;mso-element-wrap:around;
  mso-element-anchor-vertical:paragraph;mso-element-anchor-horizontal:margin;
  mso-element-left:right;mso-element-top:-.55pt;mso-height-rule:exactly'><span
  style='font-size:11.0pt;mso-bidi-font-size:10.0pt'><%=(poscount*10)%> <%=TxtNumLogic.getSuffix(poscount*10,"лист")%><o:p></o:p></span></h6>
  </td>
 </tr>
 <tr style='mso-yfti-lastrow:yes;height:14.15pt'>
  <td style='padding:0cm 5.4pt 0cm 5.4pt;height:14.15pt'>
  <h6 align=right style='margin-left:45.35pt;text-align:right;text-indent:-45.35pt;
  mso-list:l2 level1 lfo3;tab-stops:list 45.35pt;mso-element:frame;mso-element-frame-hspace:
  9.0pt;mso-element-wrap:around;mso-element-anchor-vertical:paragraph;
  mso-element-anchor-horizontal:margin;mso-element-left:right;mso-element-top:
  -.55pt;mso-height-rule:exactly'><![if !supportLists]><span style='font-size:
  11.0pt;mso-bidi-font-size:10.0pt'><span style='mso-list:Ignore'>6.<span
  style='font:7.0pt "Times New Roman"'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  </span></span></span><![endif]><span style='font-size:11.0pt;mso-bidi-font-size:
  10.0pt'><o:p>&nbsp;</o:p></span></h6>
  </td>
  <td style='padding:0cm 5.4pt 0cm 5.4pt;height:14.15pt'>
  <h6 style='text-indent:0cm;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-vertical:paragraph;mso-element-anchor-horizontal:
  margin;mso-element-left:right;mso-element-top:-.55pt;mso-height-rule:exactly'><span
  style='font-size:11.0pt;mso-bidi-font-size:10.0pt'>Сертификат<o:p></o:p></span></h6>
  </td>
  <td style='padding:0cm 5.4pt 0cm 5.4pt;height:14.15pt'>
  <h6 align=left style='text-align:left;text-indent:0cm;mso-element:frame;
  mso-element-frame-hspace:9.0pt;mso-element-wrap:around;mso-element-anchor-vertical:
  paragraph;mso-element-anchor-horizontal:margin;mso-element-left:right;
  mso-element-top:-.55pt;mso-height-rule:exactly'><span style='font-size:11.0pt;
  mso-bidi-font-size:10.0pt'>1 лист в 1 экз.<o:p></o:p></span></h6>
  </td>
  <td style='padding:0cm 5.4pt 0cm 5.4pt;height:14.15pt'>
  <h6 style='text-indent:0cm;mso-element:frame;mso-element-frame-hspace:9.0pt;
  mso-element-wrap:around;mso-element-anchor-vertical:paragraph;mso-element-anchor-horizontal:
  margin;mso-element-left:right;mso-element-top:-.55pt;mso-height-rule:exactly'><span
  style='font-size:11.0pt;mso-bidi-font-size:10.0pt'>-<o:p></o:p></span></h6>
  </td>
  <td width=91 style='width:68.25pt;padding:0cm 5.4pt 0cm 5.4pt;height:14.15pt'>
  <h6 align=left style='text-align:left;text-indent:0cm;mso-element:frame;
  mso-element-frame-hspace:9.0pt;mso-element-wrap:around;mso-element-anchor-vertical:
  paragraph;mso-element-anchor-horizontal:margin;mso-element-left:right;
  mso-element-top:-.55pt;mso-height-rule:exactly'><span style='font-size:11.0pt;
  mso-bidi-font-size:10.0pt'>1 лист<span style='mso-spacerun:yes'>  </span><o:p></o:p></span></h6>
  </td>
 </tr>
</table>

<p class=MsoNormal style='text-align:justify;text-indent:1.0cm'><span
style='font-size:11.0pt;mso-bidi-font-size:10.0pt;font-family:"Times New Roman";
mso-ansi-language:RU'><span style='mso-spacerun:yes'>  </span><o:p></o:p></span></p>

<p class=MsoNormal style='text-align:justify;text-indent:1.0cm'><span
style='font-size:11.0pt;mso-bidi-font-size:10.0pt;font-family:"Times New Roman";
mso-ansi-language:RU'><span style='mso-tab-count:1'>   </span><o:p></o:p></span></p>

<p class=MsoNormal><b style='mso-bidi-font-weight:normal'><span
style='font-size:11.0pt;mso-bidi-font-size:10.0pt;font-family:"Times New Roman";
mso-ansi-language:RU'><o:p>&nbsp;</o:p></span></b></p>

<p class=MsoNormal><b style='mso-bidi-font-weight:normal'><span
style='font-size:11.0pt;mso-bidi-font-size:10.0pt;font-family:"Times New Roman";
mso-ansi-language:RU'><o:p>&nbsp;</o:p></span></b></p>

<p class=MsoNormal><b style='mso-bidi-font-weight:normal'><span
style='font-size:11.0pt;mso-bidi-font-size:10.0pt;font-family:"Times New Roman";
mso-ansi-language:RU'><o:p>&nbsp;</o:p></span></b></p>

<p class=MsoNormal><b style='mso-bidi-font-weight:normal'><span
style='font-size:11.0pt;mso-bidi-font-size:10.0pt;font-family:"Times New Roman";
mso-ansi-language:RU'><o:p>&nbsp;</o:p></span></b></p>

<p class=MsoNormal><b style='mso-bidi-font-weight:normal'><span
style='font-size:11.0pt;mso-bidi-font-size:10.0pt;font-family:"Times New Roman";
mso-ansi-language:RU'><o:p>&nbsp;</o:p></span></b></p>

<p class=MsoNormal><b style='mso-bidi-font-weight:normal'><span
style='font-size:11.0pt;mso-bidi-font-size:10.0pt;font-family:"Times New Roman";
mso-ansi-language:RU'><o:p>&nbsp;</o:p></span></b></p>

<p class=MsoNormal><b style='mso-bidi-font-weight:normal'><span
style='font-size:11.0pt;mso-bidi-font-size:10.0pt;font-family:"Times New Roman";
mso-ansi-language:RU'><o:p>&nbsp;</o:p></span></b></p>

<%
  String title = null;
  String name = null;
  String performer = null;
  String performertel = null;
  Object titleObj = request.getAttribute("underlinetitle");
  if(titleObj != null) {
    title = (String)titleObj;
  }
  Object nameObj = request.getAttribute("underlinename");
  if(nameObj != null) {
    name = (String)nameObj;
  }
  Object performerObj = request.getAttribute("performer");
  if(performerObj != null) {
    performer = (String)performerObj;
  }
  Object performertelObj = request.getAttribute("performertel");
  if(performertelObj != null) {
    performertel = (String)performertelObj;
  }
%>

<p class=MsoNormal style='text-indent:19.85pt'><b style='mso-bidi-font-weight:
normal'><span style='font-size:11.0pt;mso-bidi-font-size:10.0pt;font-family:
"Times New Roman";mso-ansi-language:RU'><% if(title != null && title.length() != 0) out.print(title); %><span style='mso-tab-count:2'>             </span><span
style='mso-spacerun:yes'>                                                                                                   
</span><% if(name != null && name.length() != 0) out.print(name); %><o:p></o:p></span></b></p>

<p class=MsoNormal style='text-indent:19.85pt'><b style='mso-bidi-font-weight:
normal'><span style='mso-ansi-language:RU'><o:p>&nbsp;</o:p></span></b></p>

<p class=MsoNormal style='text-indent:19.85pt'><span style='font-size:10.0pt;
mso-ansi-language:RU'><o:p>&nbsp;</o:p></span></p>

<p class=MsoNormal style='text-indent:19.85pt'><span class=SpellE>
<span style='font-size:10.0pt;mso-ansi-language:RU'><%if(performer != null && performer.length() != 0) out.print(performer); %><o:p></o:p></span></p>

<p class=MsoNormal style='text-indent:19.85pt'><span style='font-size:10.0pt;mso-ansi-language:RU'><%if(performertel != null && performertel.length() != 0) out.print(performertel); %></span><span style='mso-ansi-language:RU'><o:p></o:p></span></p>

<p class=MsoNormal><span style='mso-ansi-language:RU'><o:p>&nbsp;</o:p></span></p>

<p class=MsoNormal align=right style='text-align:right'><span style='font-size:9.0pt;mso-bidi-font-size:10.0pt;font-family:"Times New Roman";mso-ansi-language:RU;mso-bidi-font-weight:bold'><bean:write name="filenumber" filter="true"/></span><span style='font-size:9.0pt;mso-bidi-font-size:10.0pt;font-family:"Times New Roman";mso-ansi-language:RU;mso-bidi-font-weight:bold'><o:p></o:p></span></p>
</div>

</body>

</html>
