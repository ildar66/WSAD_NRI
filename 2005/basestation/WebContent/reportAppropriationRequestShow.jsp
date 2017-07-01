<%@ page language = "java" %>
<%@ page contentType = "application/msword; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import="com.hps.july.util.*"%>
<%@ page import="java.util.*"%>
<html xmlns:o="urn:schemas-microsoft-com:office:office"
xmlns:w="urn:schemas-microsoft-com:office:word"
xmlns="http://www.w3.org/TR/REC-html40">
<head>
<meta http-equiv=Content-Type content="application/msword; charset=Windows-1251">
<meta http-equiv="Content-Disposition" content="attachment;filename=schetFactWord.rtf">
<meta name=ProgId content=Word.Document>
<meta name=Generator content="Microsoft Word 10">
<meta name=Originator content="Microsoft Word 10">
<link rel=File-List href="/Форма отчета1.files/filelist.xml">
<link rel=Edit-Time-Data href="/отчет8picture.files/editdata.mso">
<title> </title>
<!--[if gte mso 9]><xml>
 <o:DocumentProperties>
  <o:Author>Dneprov</o:Author>
  <o:LastAuthor>Dneprov</o:LastAuthor>
  <o:Revision>1</o:Revision>
  <o:TotalTime>1</o:TotalTime>
  <o:Created>2004-10-20T14:45:00Z</o:Created>
  <o:LastSaved>2004-10-20T14:46:00Z</o:LastSaved>
  <o:Pages>1</o:Pages>
  <o:Words>173</o:Words>
  <o:Characters>992</o:Characters>
  <o:Company>bln</o:Company>
  <o:Lines>8</o:Lines>
  <o:Paragraphs>2</o:Paragraphs>
  <o:CharactersWithSpaces>1163</o:CharactersWithSpaces>
  <o:Version>10.2625</o:Version>
 </o:DocumentProperties>
</xml><![endif]--><!--[if gte mso 9]><xml>
 <w:WordDocument>
  <w:GrammarState>Clean</w:GrammarState>
  <w:Compatibility>
   <w:BreakWrappedTables/>
   <w:SnapToGridInCell/>
   <w:WrapTextWithPunct/>
   <w:UseAsianBreakRules/>
  </w:Compatibility>
  <w:BrowserLevel>MicrosoftInternetExplorer4</w:BrowserLevel>
 </w:WordDocument>
</xml><![endif]-->
<style>
<!--
 /* Style Definitions */
 p.MsoNormal, li.MsoNormal, div.MsoNormal
	{mso-style-parent:"";
	margin:0cm;
	margin-bottom:.0001pt;
	text-align:justify;
	text-indent:35.45pt;
	mso-pagination:widow-orphan;
	font-size:12.0pt;
	font-family:"Times New Roman";
	mso-fareast-font-family:"Times New Roman";}
p.MsoBodyTextIndent3, li.MsoBodyTextIndent3, div.MsoBodyTextIndent3
	{margin-top:0cm;
	margin-right:0cm;
	margin-bottom:0cm;
	margin-left:141.65pt;
	margin-bottom:.0001pt;
	mso-pagination:widow-orphan;
	font-size:12.0pt;
	font-family:"Times New Roman";
	mso-fareast-font-family:"Times New Roman";}
p.a, li.a, div.a
	{mso-style-name:"Подпись под рисунком";
	margin-top:0cm;
	margin-right:0cm;
	margin-bottom:6.0pt;
	margin-left:0cm;
	text-align:center;
	text-indent:0cm;
	mso-pagination:widow-orphan;
	mso-list:l0 level1 lfo1;
	font-size:12.0pt;
	mso-bidi-font-size:10.0pt;
	font-family:"Times New Roman";
	mso-fareast-font-family:"Times New Roman";}
span.GramE
	{mso-style-name:"";
	mso-gram-e:yes;}
@page Section1
	{size:595.3pt 841.9pt;
	margin:62.9pt 42.5pt 35.95pt 27.0pt;
	mso-header-margin:35.4pt;
	mso-footer-margin:35.4pt;
	mso-paper-source:0;}
div.Section1
	{page:Section1;}
 /* List Definitions */
 @list l0
	{mso-list-id:1543514995;
	mso-list-template-ids:1280234664;}
@list l0:level1
	{mso-level-style-link:"Подпись под рисунком";
	mso-level-suffix:space;
	mso-level-text:"Рис\. %1\.";
	mso-level-tab-stop:none;
	mso-level-number-position:left;
	text-indent:0cm;}
@list l0:level2
	{mso-level-number-format:none;
	mso-level-suffix:none;
	mso-level-text:"";
	mso-level-tab-stop:none;
	mso-level-number-position:left;
	margin-left:36.0pt;
	text-indent:0cm;}
@list l0:level3
	{mso-level-number-format:none;
	mso-level-suffix:none;
	mso-level-text:"";
	mso-level-tab-stop:none;
	mso-level-number-position:left;
	margin-left:36.0pt;
	text-indent:0cm;}
@list l0:level4
	{mso-level-number-format:none;
	mso-level-suffix:none;
	mso-level-text:"";
	mso-level-tab-stop:none;
	mso-level-number-position:left;
	margin-left:36.0pt;
	text-indent:0cm;}
@list l0:level5
	{mso-level-number-format:none;
	mso-level-suffix:none;
	mso-level-text:"";
	mso-level-tab-stop:none;
	mso-level-number-position:left;
	margin-left:36.0pt;
	text-indent:0cm;}
@list l0:level6
	{mso-level-number-format:none;
	mso-level-suffix:none;
	mso-level-text:"";
	mso-level-tab-stop:none;
	mso-level-number-position:left;
	margin-left:36.0pt;
	text-indent:0cm;}
@list l0:level7
	{mso-level-number-format:none;
	mso-level-suffix:none;
	mso-level-text:"";
	mso-level-tab-stop:none;
	mso-level-number-position:left;
	margin-left:36.0pt;
	text-indent:0cm;}
@list l0:level8
	{mso-level-number-format:none;
	mso-level-suffix:none;
	mso-level-text:"";
	mso-level-tab-stop:none;
	mso-level-number-position:left;
	margin-left:36.0pt;
	text-indent:0cm;}
@list l0:level9
	{mso-level-number-format:none;
	mso-level-suffix:none;
	mso-level-text:"";
	mso-level-tab-stop:none;
	mso-level-number-position:left;
	margin-left:36.0pt;
	text-indent:0cm;}
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
	font-family:"Times New Roman";}
</style>
<![endif]-->
</head>

<body lang=RU style='tab-interval:35.4pt'>

<div class=Section1>

<p class=MsoNormal style='margin-left:36.0pt;text-indent:0cm'><u1:shapetype id="_x0000_t75" coordsize="21600,21600" o:spt="75" o:preferrelative="t" path="m@4@5l@4@11@9@11@9@5xe" filled="f" stroked="f"><u1:stroke joinstyle="miter"/><u1:formulas><u1:f eqn="if lineDrawn pixelLineWidth 0"/><u1:f eqn="sum @0 1 0"/><u1:f eqn="sum 0 0 @1"/><u1:f eqn="prod @2 1 2"/><u1:f eqn="prod @3 21600 pixelWidth"/><u1:f eqn="prod @3 21600 pixelHeight"/><u1:f eqn="sum @0 0 1"/><u1:f eqn="prod @6 1 2"/><u1:f eqn="prod @7 21600 pixelWidth"/><u1:f eqn="sum @8 21600 0"/><u1:f eqn="prod @7 21600 pixelHeight"/><u1:f eqn="sum @10 21600 0"/></u1:formulas><u1:path o:extrusionok="f" gradientshapeok="t" o:connecttype="rect"/><o:lock u1:ext="edit" aspectratio="t"/></u1:shapetype><u1:shape id="_x0000_i1025" type="#_x0000_t75" style="width:462pt;&#13;&#10; height:168pt"><u1:imagedata src="НРВЕР6picture.files/image001.png" o:title="DocHead"/></u1:shape><!--[if gte vml 1]><v:shapetype
 id="_x0000_t75" coordsize="21600,21600" o:spt="75" o:preferrelative="t"
 path="m@4@5l@4@11@9@11@9@5xe" filled="f" stroked="f">
 <v:stroke joinstyle="miter"/>
 <v:formulas>
  <v:f eqn="if lineDrawn pixelLineWidth 0"/>
  <v:f eqn="sum @0 1 0"/>
  <v:f eqn="sum 0 0 @1"/>
  <v:f eqn="prod @2 1 2"/>
  <v:f eqn="prod @3 21600 pixelWidth"/>
  <v:f eqn="prod @3 21600 pixelHeight"/>
  <v:f eqn="sum @0 0 1"/>
  <v:f eqn="prod @6 1 2"/>
  <v:f eqn="prod @7 21600 pixelWidth"/>
  <v:f eqn="sum @8 21600 0"/>
  <v:f eqn="prod @7 21600 pixelHeight"/>
  <v:f eqn="sum @10 21600 0"/>
 </v:formulas>
 <v:path o:extrusionok="f" gradientshapeok="t" o:connecttype="rect"/>
 <o:lock v:ext="edit" aspectratio="t"/>
</v:shapetype><![endif]--><![if !vml]><img width=616 height=96
src="http://infserver.informix.ru/GetReportFiles/getshortreporthead.jpg" border="0"><![endif]><span
lang=EN-US style='mso-ansi-language:EN-US'><o:p></o:p></span></p>

<div class=Section1>

<%
  String addressee = null;
  Object addresseeObj = request.getAttribute("addressee");
  if(addresseeObj != null) {
    addressee = (String)addresseeObj;
  }
%>

<p class=MsoNormal align=right style='margin-left:36.0pt;text-align:right;
text-indent:0cm'><b>
<%
  if(addressee != null && addressee.length() != 0)
    out.print(addressee);
%>&nbsp;&nbsp;<br>
&#8209;&#8209;&#8209;&#8209;&#8209;&#8209;&#8209;&#8209;&#8209;&#8209;&#8209;&#8209;&#8209;&#8209;&#8209;&#8209;&#8209;&#8209;&#8209;&#8209;&#8209;&#8209;&#8209;&#8209;&#8209;&#8209;&#8209;&#8209;&#8209;&#8209;&#8209;&#8209;&#8209;&#8209;&#8209;&#8209;&#8209;&#8209;&#8209;&#8209;&#8209;&#8209;&#8209;&#8209;&#8209;&#8209;&#8209;&#8209;&#8209;&#8209;&#8209;&#8209;&#8209;&#8209;&#8209;&#8209;&#8209;&#8209;&#8209;&#8209;<u><br>
</u></b>125375, г. Москва, ул. Тверская, д. 7&nbsp;&nbsp;</p>

<p class=MsoNormal style='margin-left:36.0pt;text-indent:0cm'><i><span
style='font-size:10.0pt;mso-bidi-font-size:12.0pt'>Исх. №<span
style='mso-spacerun:yes'>   </span>_______________________<o:p></o:p></span></i></p>

<p class=MsoNormal style='margin-left:36.0pt;text-indent:0cm'><i><span
style='font-size:6.0pt;mso-bidi-font-size:12.0pt'><o:p>&nbsp;</o:p></span></i></p>

<p class=MsoNormal style='margin-left:36.0pt;text-indent:0cm'><i><span
style='font-size:10.0pt;mso-bidi-font-size:12.0pt'>Дата<span
style='mso-spacerun:yes'>      </span>_______________________<o:p></o:p></span></i></p>

<p class=MsoNormal style='margin-left:36.0pt;text-indent:0cm'><o:p>&nbsp;</o:p></p>

<p class=a style='margin-top:0cm;margin-right:0cm;margin-bottom:0cm;margin-left:
36.0pt;margin-bottom:.0001pt;mso-list:none'><span style='mso-bidi-font-size:
12.0pt'>ЗАЯВЛЕНИЕ<br>
НА ПРИСВОЕНИЕ (НАЗНАЧЕНИЕ) РАДИОЧАСТОТ<o:p></o:p></span></p>

<p class=a style='margin-top:0cm;margin-right:0cm;margin-bottom:0cm;margin-left:
36.0pt;margin-bottom:.0001pt;mso-list:none'><span style='font-size:8.0pt;
mso-bidi-font-size:12.0pt'><o:p>&nbsp;</o:p></span></p>

<table class=MsoNormalTable border=1 cellspacing=0 cellpadding=0
 style='margin-left:36.0pt;border-collapse:collapse;border:none;mso-border-alt:
 solid windowtext .5pt;mso-padding-alt:0cm 5.4pt 0cm 5.4pt;mso-border-insideh:
 .5pt solid windowtext;mso-border-insidev:.5pt solid windowtext'>
 <tr style='mso-yfti-irow:0'>
  <td width=39 style='width:23.4pt;border:solid windowtext 1.0pt;mso-border-alt:
  solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=a style='margin-top:3.0pt;margin-right:0cm;margin-bottom:3.0pt;
  margin-left:0cm;mso-list:none'><span style='mso-bidi-font-size:12.0pt'>1<o:p></o:p></span></p>
  </td>
  <td width=345 style='width:207.0pt;border:solid windowtext 1.0pt;border-left:
  none;mso-border-left-alt:solid windowtext .5pt;mso-border-alt:solid windowtext .5pt;
  padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=a align=left style='margin-top:3.0pt;margin-right:0cm;margin-bottom:
  3.0pt;margin-left:0cm;text-align:left;mso-list:none'><span style='mso-bidi-font-size:
  12.0pt'>Организационно правовая форма<o:p></o:p></span></p>
  </td>
  <td width=427 style='width:256.05pt;border:solid windowtext 1.0pt;border-left:
  none;mso-border-left-alt:solid windowtext .5pt;mso-border-alt:solid windowtext .5pt;
  padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=a style='margin-top:3.0pt;margin-right:0cm;margin-bottom:3.0pt;
  margin-left:0cm;mso-list:none'><span style='mso-bidi-font-size:12.0pt'>Открытое
  акционерное общество<o:p></o:p></span></p>
  </td>
 </tr>
 <tr style='mso-yfti-irow:1'>
  <td width=39 style='width:23.4pt;border:solid windowtext 1.0pt;border-top:
  none;mso-border-top-alt:solid windowtext .5pt;mso-border-alt:solid windowtext .5pt;
  padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=a style='margin-top:3.0pt;margin-right:0cm;margin-bottom:3.0pt;
  margin-left:0cm;mso-list:none'><span style='mso-bidi-font-size:12.0pt'>2<o:p></o:p></span></p>
  </td>
  <td width=345 style='width:207.0pt;border-top:none;border-left:none;
  border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=a align=left style='margin-top:3.0pt;margin-right:0cm;margin-bottom:
  3.0pt;margin-left:0cm;text-align:left;mso-list:none'><span style='mso-bidi-font-size:
  12.0pt'>Полное наименование <br>
  юридического лица<o:p></o:p></span></p>
  </td>
  <td width=427 style='width:256.05pt;border-top:none;border-left:none;
  border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=a style='margin-top:3.0pt;margin-right:0cm;margin-bottom:3.0pt;
  margin-left:0cm;mso-list:none'><span style='mso-bidi-font-size:12.0pt'>Открытое
  акционерное общество <br>
  "Вымпел-Коммуникации"<o:p></o:p></span></p>
  </td>
 </tr>
 <tr style='mso-yfti-irow:2'>
  <td width=39 style='width:23.4pt;border:solid windowtext 1.0pt;border-top:
  none;mso-border-top-alt:solid windowtext .5pt;mso-border-alt:solid windowtext .5pt;
  padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=a style='margin-top:3.0pt;margin-right:0cm;margin-bottom:3.0pt;
  margin-left:0cm;mso-list:none'><span style='mso-bidi-font-size:12.0pt'>3<o:p></o:p></span></p>
  </td>
  <td width=345 style='width:207.0pt;border-top:none;border-left:none;
  border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=a align=left style='margin-top:3.0pt;margin-right:0cm;margin-bottom:
  3.0pt;margin-left:0cm;text-align:left;mso-list:none'><span style='mso-bidi-font-size:
  12.0pt'>Юридический адрес<o:p></o:p></span></p>
  </td>
  <td width=427 style='width:256.05pt;border-top:none;border-left:none;
  border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=a style='margin-top:3.0pt;margin-right:0cm;margin-bottom:3.0pt;
  margin-left:0cm;mso-list:none'>127083, г. Москва, ул. 8 марта, д. 10, стр. 14<span
  style='mso-bidi-font-size:12.0pt'><o:p></o:p></span></p>
  </td>
 </tr>
 <tr style='mso-yfti-irow:3'>
  <td width=39 style='width:23.4pt;border:solid windowtext 1.0pt;border-top:
  none;mso-border-top-alt:solid windowtext .5pt;mso-border-alt:solid windowtext .5pt;
  padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=a style='margin-top:3.0pt;margin-right:0cm;margin-bottom:3.0pt;
  margin-left:0cm;mso-list:none'><span style='mso-bidi-font-size:12.0pt'>4<o:p></o:p></span></p>
  </td>
  <td width=345 style='width:207.0pt;border-top:none;border-left:none;
  border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=a align=left style='margin-top:3.0pt;margin-right:0cm;margin-bottom:
  3.0pt;margin-left:0cm;text-align:left;mso-list:none'><span style='mso-bidi-font-size:
  12.0pt'>Почтовый адрес<o:p></o:p></span></p>
  </td>
  <td width=427 style='width:256.05pt;border-top:none;border-left:none;
  border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=a style='margin-top:3.0pt;margin-right:0cm;margin-bottom:3.0pt;
  margin-left:0cm;mso-list:none'>127083, г. Москва, ул. 8 марта, д. 10, стр. 14<span
  style='mso-bidi-font-size:12.0pt'><o:p></o:p></span></p>
  </td>
 </tr>
 <tr style='mso-yfti-irow:4'>
  <td width=39 style='width:23.4pt;border:solid windowtext 1.0pt;border-top:
  none;mso-border-top-alt:solid windowtext .5pt;mso-border-alt:solid windowtext .5pt;
  padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=a style='margin-top:3.0pt;margin-right:0cm;margin-bottom:3.0pt;
  margin-left:0cm;mso-list:none'><span style='mso-bidi-font-size:12.0pt'>5<o:p></o:p></span></p>
  </td>
  <td width=345 style='width:207.0pt;border-top:none;border-left:none;
  border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=a align=left style='margin-top:3.0pt;margin-right:0cm;margin-bottom:
  3.0pt;margin-left:0cm;text-align:left;mso-list:none'><span style='mso-bidi-font-size:
  12.0pt'>Номер телефона, факс, </span><span lang=EN-US style='mso-bidi-font-size:
  12.0pt;mso-ansi-language:EN-US'>E</span><span style='mso-bidi-font-size:12.0pt'>-</span><span
  lang=EN-US style='mso-bidi-font-size:12.0pt;mso-ansi-language:EN-US'>mail</span><span
  style='mso-bidi-font-size:12.0pt'><o:p></o:p></span></p>
  </td>
  <td width=427 style='width:256.05pt;border-top:none;border-left:none;
  border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=a style='margin-top:3.0pt;margin-right:0cm;margin-bottom:3.0pt;
  margin-left:0cm;mso-list:none'><span lang=EN-US style='mso-bidi-font-size:
  12.0pt;mso-ansi-language:EN-US'>910-58-81, </span><span style='mso-bidi-font-size:
  12.0pt'>факс</span><span lang=EN-US style='mso-bidi-font-size:12.0pt;
  mso-ansi-language:EN-US'>: 244-96-57<o:p></o:p></span></p>
  </td>
 </tr>
 <tr style='mso-yfti-irow:5'>
  <td width=39 style='width:23.4pt;border:solid windowtext 1.0pt;border-top:
  none;mso-border-top-alt:solid windowtext .5pt;mso-border-alt:solid windowtext .5pt;
  padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=a style='margin-top:3.0pt;margin-right:0cm;margin-bottom:3.0pt;
  margin-left:0cm;mso-list:none'><span style='mso-bidi-font-size:12.0pt'>6<o:p></o:p></span></p>
  </td>
  <td width=345 style='width:207.0pt;border-top:none;border-left:none;
  border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=a align=left style='margin-top:3.0pt;margin-right:0cm;margin-bottom:
  3.0pt;margin-left:0cm;text-align:left;mso-list:none'><span style='mso-bidi-font-size:
  12.0pt'>Основной государственный регистрационный номер (ОГРН)<o:p></o:p></span></p>
  </td>
  <td width=427 style='width:256.05pt;border-top:none;border-left:none;
  border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <div align=center>
  <table class=MsoNormalTable border=1 cellspacing=0 cellpadding=0
   style='margin-left:3.35pt;border-collapse:collapse;border:none;mso-border-alt:
   solid windowtext .5pt;mso-padding-alt:0cm 5.4pt 0cm 5.4pt;mso-border-insideh:
   .5pt solid windowtext;mso-border-insidev:.5pt solid windowtext'>
   <tr style='mso-yfti-irow:0;mso-yfti-lastrow:yes'>
    <td width=24 valign=top style='width:14.2pt;border:solid windowtext 1.0pt;
    mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
    <p class=a style='margin-top:3.0pt;margin-right:0cm;margin-bottom:3.0pt;
    margin-left:0cm;mso-list:none'><span style='mso-bidi-font-size:12.0pt'>1<o:p></o:p></span></p>
    </td>
    <td width=24 valign=top style='width:14.2pt;border:solid windowtext 1.0pt;
    border-left:none;mso-border-left-alt:solid windowtext .5pt;mso-border-alt:
    solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
    <p class=a style='margin-top:3.0pt;margin-right:0cm;margin-bottom:3.0pt;
    margin-left:0cm;mso-list:none'><span style='mso-bidi-font-size:12.0pt'>0<o:p></o:p></span></p>
    </td>
    <td width=24 valign=top style='width:14.2pt;border:solid windowtext 1.0pt;
    border-left:none;mso-border-left-alt:solid windowtext .5pt;mso-border-alt:
    solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
    <p class=a style='margin-top:3.0pt;margin-right:0cm;margin-bottom:3.0pt;
    margin-left:0cm;mso-list:none'><span style='mso-bidi-font-size:12.0pt'>2<o:p></o:p></span></p>
    </td>
    <td width=24 valign=top style='width:14.2pt;border:solid windowtext 1.0pt;
    border-left:none;mso-border-left-alt:solid windowtext .5pt;mso-border-alt:
    solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
    <p class=a style='margin-top:3.0pt;margin-right:0cm;margin-bottom:3.0pt;
    margin-left:0cm;mso-list:none'><span style='mso-bidi-font-size:12.0pt'>7<o:p></o:p></span></p>
    </td>
    <td width=24 valign=top style='width:14.2pt;border:solid windowtext 1.0pt;
    border-left:none;mso-border-left-alt:solid windowtext .5pt;mso-border-alt:
    solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
    <p class=a style='margin-top:3.0pt;margin-right:0cm;margin-bottom:3.0pt;
    margin-left:0cm;mso-list:none'><span style='mso-bidi-font-size:12.0pt'>7<o:p></o:p></span></p>
    </td>
    <td width=24 valign=top style='width:14.2pt;border:solid windowtext 1.0pt;
    border-left:none;mso-border-left-alt:solid windowtext .5pt;mso-border-alt:
    solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
    <p class=a style='margin-top:3.0pt;margin-right:0cm;margin-bottom:3.0pt;
    margin-left:0cm;mso-list:none'><span style='mso-bidi-font-size:12.0pt'>0<o:p></o:p></span></p>
    </td>
    <td width=24 valign=top style='width:14.2pt;border:solid windowtext 1.0pt;
    border-left:none;mso-border-left-alt:solid windowtext .5pt;mso-border-alt:
    solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
    <p class=a style='margin-top:3.0pt;margin-right:0cm;margin-bottom:3.0pt;
    margin-left:0cm;mso-list:none'><span style='mso-bidi-font-size:12.0pt'>0<o:p></o:p></span></p>
    </td>
    <td width=24 valign=top style='width:14.2pt;border:solid windowtext 1.0pt;
    border-left:none;mso-border-left-alt:solid windowtext .5pt;mso-border-alt:
    solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
    <p class=a style='margin-top:3.0pt;margin-right:0cm;margin-bottom:3.0pt;
    margin-left:0cm;mso-list:none'><span style='mso-bidi-font-size:12.0pt'>1<o:p></o:p></span></p>
    </td>
    <td width=24 valign=top style='width:14.2pt;border:solid windowtext 1.0pt;
    border-left:none;mso-border-left-alt:solid windowtext .5pt;mso-border-alt:
    solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
    <p class=a style='margin-top:3.0pt;margin-right:0cm;margin-bottom:3.0pt;
    margin-left:0cm;mso-list:none'><span style='mso-bidi-font-size:12.0pt'>6<o:p></o:p></span></p>
    </td>
    <td width=24 valign=top style='width:14.2pt;border:solid windowtext 1.0pt;
    border-left:none;mso-border-left-alt:solid windowtext .5pt;mso-border-alt:
    solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
    <p class=a style='margin-top:3.0pt;margin-right:0cm;margin-bottom:3.0pt;
    margin-left:0cm;mso-list:none'><span style='mso-bidi-font-size:12.0pt'>6<o:p></o:p></span></p>
    </td>
    <td width=24 valign=top style='width:14.2pt;border:solid windowtext 1.0pt;
    border-left:none;mso-border-left-alt:solid windowtext .5pt;mso-border-alt:
    solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
    <p class=a style='margin-top:3.0pt;margin-right:0cm;margin-bottom:3.0pt;
    margin-left:0cm;mso-list:none'><span style='mso-bidi-font-size:12.0pt'>6<o:p></o:p></span></p>
    </td>
    <td width=24 valign=top style='width:14.2pt;border:solid windowtext 1.0pt;
    border-left:none;mso-border-left-alt:solid windowtext .5pt;mso-border-alt:
    solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
    <p class=a style='margin-top:3.0pt;margin-right:0cm;margin-bottom:3.0pt;
    margin-left:0cm;mso-list:none'><span style='mso-bidi-font-size:12.0pt'>3<o:p></o:p></span></p>
    </td>
    <td width=24 valign=top style='width:14.2pt;border:solid windowtext 1.0pt;
    border-left:none;mso-border-left-alt:solid windowtext .5pt;mso-border-alt:
    solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
    <p class=a style='margin-top:3.0pt;margin-right:0cm;margin-bottom:3.0pt;
    margin-left:0cm;mso-list:none'><span style='mso-bidi-font-size:12.0pt'>6<o:p></o:p></span></p>
    </td>
   </tr>
  </table>
  </div>
  <p class=a style='margin-top:3.0pt;margin-right:0cm;margin-bottom:3.0pt;
  margin-left:0cm;mso-list:none'><span style='mso-bidi-font-size:12.0pt'><o:p></o:p></span></p>
  </td>
 </tr>
 <tr style='mso-yfti-irow:6'>
  <td width=39 style='width:23.4pt;border:solid windowtext 1.0pt;border-top:
  none;mso-border-top-alt:solid windowtext .5pt;mso-border-alt:solid windowtext .5pt;
  padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=a style='margin-top:3.0pt;margin-right:0cm;margin-bottom:3.0pt;
  margin-left:0cm;mso-list:none'><span style='mso-bidi-font-size:12.0pt'>7<o:p></o:p></span></p>
  </td>
  <td width=345 style='width:207.0pt;border-top:none;border-left:none;
  border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=a align=left style='margin-top:3.0pt;margin-right:0cm;margin-bottom:
  3.0pt;margin-left:0cm;text-align:left;mso-list:none'><span style='mso-bidi-font-size:
  12.0pt'>Дата присвоения ОГРН<o:p></o:p></span></p>
  </td>
  <td width=427 style='width:256.05pt;border-top:none;border-left:none;
  border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=a style='margin-top:3.0pt;margin-right:0cm;margin-bottom:3.0pt;
  margin-left:0cm;mso-list:none'><span style='mso-bidi-font-size:12.0pt'>28
  августа 2002 года<o:p></o:p></span></p>
  </td>
 </tr>
 <tr style='mso-yfti-irow:7'>
  <td width=39 style='width:23.4pt;border:solid windowtext 1.0pt;border-top:
  none;mso-border-top-alt:solid windowtext .5pt;mso-border-alt:solid windowtext .5pt;
  padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=a style='margin-top:6.0pt;mso-list:none'><span style='mso-bidi-font-size:
  12.0pt'>8<o:p></o:p></span></p>
  </td>
  <td width=345 style='width:207.0pt;border-top:none;border-left:none;
  border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=a align=left style='margin-top:6.0pt;text-align:left;mso-list:none'><span
  style='mso-bidi-font-size:12.0pt'>ИНН<o:p></o:p></span></p>
  </td>
  <td width=427 style='width:256.05pt;border-top:none;border-left:none;
  border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <div align=center>
  <table class=MsoNormalTable border=1 cellspacing=0 cellpadding=0
   style='margin-left:3.35pt;border-collapse:collapse;border:none;mso-border-alt:
   solid windowtext .5pt;mso-padding-alt:0cm 5.4pt 0cm 5.4pt;mso-border-insideh:
   .5pt solid windowtext;mso-border-insidev:.5pt solid windowtext'>
   <tr style='mso-yfti-irow:0;mso-yfti-lastrow:yes'>
    <td width=28 valign=top style='width:16.8pt;border:solid windowtext 1.0pt;
    mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
    <p class=a style='margin-top:3.0pt;margin-right:0cm;margin-bottom:3.0pt;
    margin-left:0cm;mso-list:none'><span style='mso-bidi-font-size:12.0pt'>7<o:p></o:p></span></p>
    </td>
    <td width=28 valign=top style='width:16.8pt;border:solid windowtext 1.0pt;
    border-left:none;mso-border-left-alt:solid windowtext .5pt;mso-border-alt:
    solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
    <p class=a style='margin-top:3.0pt;margin-right:0cm;margin-bottom:3.0pt;
    margin-left:0cm;mso-list:none'><span style='mso-bidi-font-size:12.0pt'>7<o:p></o:p></span></p>
    </td>
    <td width=28 valign=top style='width:16.8pt;border:solid windowtext 1.0pt;
    border-left:none;mso-border-left-alt:solid windowtext .5pt;mso-border-alt:
    solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
    <p class=a style='margin-top:3.0pt;margin-right:0cm;margin-bottom:3.0pt;
    margin-left:0cm;mso-list:none'><span style='mso-bidi-font-size:12.0pt'>1<o:p></o:p></span></p>
    </td>
    <td width=28 valign=top style='width:16.8pt;border:solid windowtext 1.0pt;
    border-left:none;mso-border-left-alt:solid windowtext .5pt;mso-border-alt:
    solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
    <p class=a style='margin-top:3.0pt;margin-right:0cm;margin-bottom:3.0pt;
    margin-left:0cm;mso-list:none'><span style='mso-bidi-font-size:12.0pt'>3<o:p></o:p></span></p>
    </td>
    <td width=28 valign=top style='width:16.8pt;border:solid windowtext 1.0pt;
    border-left:none;mso-border-left-alt:solid windowtext .5pt;mso-border-alt:
    solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
    <p class=a style='margin-top:3.0pt;margin-right:0cm;margin-bottom:3.0pt;
    margin-left:0cm;mso-list:none'><span style='mso-bidi-font-size:12.0pt'>0<o:p></o:p></span></p>
    </td>
    <td width=28 valign=top style='width:16.8pt;border:solid windowtext 1.0pt;
    border-left:none;mso-border-left-alt:solid windowtext .5pt;mso-border-alt:
    solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
    <p class=a style='margin-top:3.0pt;margin-right:0cm;margin-bottom:3.0pt;
    margin-left:0cm;mso-list:none'><span style='mso-bidi-font-size:12.0pt'>7<o:p></o:p></span></p>
    </td>
    <td width=28 valign=top style='width:16.8pt;border:solid windowtext 1.0pt;
    border-left:none;mso-border-left-alt:solid windowtext .5pt;mso-border-alt:
    solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
    <p class=a style='margin-top:3.0pt;margin-right:0cm;margin-bottom:3.0pt;
    margin-left:0cm;mso-list:none'><span style='mso-bidi-font-size:12.0pt'>6<o:p></o:p></span></p>
    </td>
    <td width=28 valign=top style='width:16.8pt;border:solid windowtext 1.0pt;
    border-left:none;mso-border-left-alt:solid windowtext .5pt;mso-border-alt:
    solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
    <p class=a style='margin-top:3.0pt;margin-right:0cm;margin-bottom:3.0pt;
    margin-left:0cm;mso-list:none'><span style='mso-bidi-font-size:12.0pt'>3<o:p></o:p></span></p>
    </td>
    <td width=28 valign=top style='width:16.8pt;border:solid windowtext 1.0pt;
    border-left:none;mso-border-left-alt:solid windowtext .5pt;mso-border-alt:
    solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
    <p class=a style='margin-top:3.0pt;margin-right:0cm;margin-bottom:3.0pt;
    margin-left:0cm;mso-list:none'><span style='mso-bidi-font-size:12.0pt'>0<o:p></o:p></span></p>
    </td>
    <td width=28 valign=top style='width:16.8pt;border:solid windowtext 1.0pt;
    border-left:none;mso-border-left-alt:solid windowtext .5pt;mso-border-alt:
    solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
    <p class=a style='margin-top:3.0pt;margin-right:0cm;margin-bottom:3.0pt;
    margin-left:0cm;mso-list:none'><span style='mso-bidi-font-size:12.0pt'>1<o:p></o:p></span></p>
    </td>
   </tr>
  </table>
  </div>
  <p class=a style='margin-top:6.0pt;mso-list:none'><span style='mso-bidi-font-size:
  12.0pt'><o:p></o:p></span></p>
  </td>
 </tr>
 <tr style='mso-yfti-irow:8'>
  <td width=39 style='width:23.4pt;border:solid windowtext 1.0pt;border-top:
  none;mso-border-top-alt:solid windowtext .5pt;mso-border-alt:solid windowtext .5pt;
  padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=a style='margin-top:3.0pt;margin-right:0cm;margin-bottom:3.0pt;
  margin-left:0cm;mso-list:none'><span style='mso-bidi-font-size:12.0pt'>9<o:p></o:p></span></p>
  </td>
  <td width=345 style='width:207.0pt;border-top:none;border-left:none;
  border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=a align=left style='margin-top:3.0pt;margin-right:0cm;margin-bottom:
  3.0pt;margin-left:0cm;text-align:left;mso-list:none'><span style='mso-bidi-font-size:
  12.0pt'>Радиослужба<o:p></o:p></span></p>
  </td>
  <td width=427 style='width:256.05pt;border-top:none;border-left:none;
  border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=a style='margin-top:3.0pt;margin-right:0cm;margin-bottom:3.0pt;
  margin-left:0cm;mso-list:none'><span style='mso-bidi-font-size:12.0pt'>Подвижная<o:p></o:p></span></p>
  </td>
 </tr>
 <tr style='mso-yfti-irow:9'>
  <td width=39 style='width:23.4pt;border:solid windowtext 1.0pt;border-top:
  none;mso-border-top-alt:solid windowtext .5pt;mso-border-alt:solid windowtext .5pt;
  padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=a style='margin-top:3.0pt;margin-right:0cm;margin-bottom:3.0pt;
  margin-left:0cm;mso-list:none'><span style='mso-bidi-font-size:12.0pt'>10<o:p></o:p></span></p>
  </td>
  <td width=345 style='width:207.0pt;border-top:none;border-left:none;
  border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=a align=left style='margin-top:3.0pt;margin-right:0cm;margin-bottom:
  3.0pt;margin-left:0cm;text-align:left;mso-list:none'><span style='mso-bidi-font-size:
  12.0pt'>Полоса радиочастот<o:p></o:p></span></p>
  </td>
  <td width=427 style='width:256.05pt;border-top:none;border-left:none;
  border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=a style='margin-top:3.0pt;margin-right:0cm;margin-bottom:3.0pt;
  margin-left:0cm;mso-list:none'><span lang=EN-US style='mso-bidi-font-size:
  12.0pt;;mso-ansi-language:EN-US'></span><span
  style='mso-bidi-font-size:12.0pt'>

  <%
    Object freqrangesObj = request.getAttribute("reportList");
    String freqrangesStr = null;
    if(freqrangesObj != null) {
       freqrangesStr = (String)freqrangesObj;
    }
    if(freqrangesStr != null && freqrangesStr.length() != 0) {
      out.print(freqrangesStr);
    }
  %>
  </span><span
  lang=EN-US style='mso-bidi-font-size:12.0pt;mso-ansi-language:
  EN-US'></span><span style='mso-bidi-font-size:12.0pt'><o:p></o:p></span></p>
  </td>
 </tr>
 <tr style='mso-yfti-irow:10'>
  <td width=39 style='width:23.4pt;border:solid windowtext 1.0pt;border-top:
  none;mso-border-top-alt:solid windowtext .5pt;mso-border-alt:solid windowtext .5pt;
  padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=a style='margin-top:3.0pt;margin-right:0cm;margin-bottom:3.0pt;
  margin-left:0cm;mso-list:none'><span style='mso-bidi-font-size:12.0pt'>11<o:p></o:p></span></p>
  </td>
  <td width=345 style='width:207.0pt;border-top:none;border-left:none;
  border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=a align=left style='margin-top:3.0pt;margin-right:0cm;margin-bottom:
  3.0pt;margin-left:0cm;text-align:left;mso-list:none'><span style='mso-bidi-font-size:
  12.0pt'>Назначение сети<o:p></o:p></span></p>
  </td>
  <td width=427 style='width:256.05pt;border-top:none;border-left:none;
  border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=a style='margin-top:3.0pt;margin-right:0cm;margin-bottom:3.0pt;
  margin-left:0cm;mso-list:none'><span style='mso-bidi-font-size:12.0pt'>Передача
  данных сети сотовой подвижной радиосвязи<o:p></o:p></span></p>
  </td>
 </tr>
 <tr style='mso-yfti-irow:11'>
  <td width=39 style='width:23.4pt;border:solid windowtext 1.0pt;border-top:
  none;mso-border-top-alt:solid windowtext .5pt;mso-border-alt:solid windowtext .5pt;
  padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=a style='margin-top:3.0pt;margin-right:0cm;margin-bottom:3.0pt;
  margin-left:0cm;mso-list:none'><span style='mso-bidi-font-size:12.0pt'>12<o:p></o:p></span></p>
  </td>
  <td width=345 style='width:207.0pt;border-top:none;border-left:none;
  border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=a align=left style='margin-top:3.0pt;margin-right:0cm;margin-bottom:
  3.0pt;margin-left:0cm;text-align:left;mso-list:none'><span style='mso-bidi-font-size:
  12.0pt'>Территория <o:p></o:p></span></p>
  </td>
  <td width=427 style='width:256.05pt;border-top:none;border-left:none;
  border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=a style='margin-top:3.0pt;margin-right:0cm;margin-bottom:3.0pt;
  margin-left:0cm;mso-list:none'><span style='mso-bidi-font-size:12.0pt'>Г.
  Москва и Московская область<o:p></o:p></span></p>
  </td>
 </tr>
 <tr style='mso-yfti-irow:12;mso-yfti-lastrow:yes'>
  <td width=39 style='width:23.4pt;border:solid windowtext 1.0pt;border-top:
  none;mso-border-top-alt:solid windowtext .5pt;mso-border-alt:solid windowtext .5pt;
  padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=a style='margin-top:3.0pt;margin-right:0cm;margin-bottom:3.0pt;
  margin-left:0cm;mso-list:none'><span style='mso-bidi-font-size:12.0pt'>13<o:p></o:p></span></p>
  </td>
  <td width=345 style='width:207.0pt;border-top:none;border-left:none;
  border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=a align=left style='margin-top:3.0pt;margin-right:0cm;margin-bottom:
  3.0pt;margin-left:0cm;text-align:left;mso-list:none'><span style='mso-bidi-font-size:
  12.0pt'>Заявляемый срок действия использования радиочастоты<o:p></o:p></span></p>
  </td>
  <td width=427 style='width:256.05pt;border-top:none;border-left:none;
  border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=a style='margin-top:3.0pt;margin-right:0cm;margin-bottom:3.0pt;
  margin-left:0cm;mso-list:none'><span style='mso-bidi-font-size:12.0pt'>10 лет<o:p></o:p></span></p>
  </td>
 </tr>
</table>

<p class=MsoNormal style='margin-top:6.0pt;margin-right:0cm;margin-bottom:6.0pt;
margin-left:0cm'>Прошу выдать разрешение на использование радиочастот</p>

<p class=MsoNormal style='margin-top:6.0pt;margin-right:0cm;margin-bottom:6.0pt;
margin-left:0cm'>ПРИЛОЖЕНИЕ:</p>

<p class=MsoNormal align=left style='margin-left:159.6pt;text-align:left;
text-indent:-18.0pt;mso-list:l1 level1 lfo2;tab-stops:list 159.6pt'><![if !supportLists]><span
style='mso-list:Ignore'>1.<span style='font:7.0pt "Times New Roman"'>&nbsp;&nbsp;&nbsp;&nbsp;
</span></span><![endif]>Копия сертификата соответствия РЭС (при необходимости)</p>

<p class=MsoNormal align=left style='margin-left:159.6pt;text-align:left;
text-indent:-18.0pt;mso-list:l1 level1 lfo2;tab-stops:list 159.6pt'><![if !supportLists]><span
style='mso-list:Ignore'>2.<span style='font:7.0pt "Times New Roman"'>&nbsp;&nbsp;&nbsp;&nbsp;
</span></span><![endif]>Оригинал или нотариально заверенная копия заключения
экспертизы о возможности использования заявленных радиоэлектронных средств и об
их электромагнитной совместимости с действующими и планируемыми для
использования радиоэлектронными средствами.</p>

<p class=MsoNormal><o:p>&nbsp;</o:p></p>


<%
  String title = null;
  String name = null;
  String performer = null;
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
%>

<table class=MsoNormalTable border=1 cellspacing=0 cellpadding=0
 style='margin-left:41.4pt;border-collapse:collapse;border:none;mso-border-alt:
 solid white .5pt;mso-yfti-tbllook:480;mso-padding-alt:0cm 5.4pt 0cm 5.4pt;
 mso-border-insideh:.5pt dotted white;mso-border-insidev:.5pt dotted white'>
 <tr style='mso-yfti-irow:0;height:31.35pt'>
  <td width=171 valign=top style='width:102.6pt;border:solid white 1.0pt;
  mso-border-alt:solid white .5pt;padding:0cm 5.4pt 0cm 5.4pt;height:31.35pt'>
  <p class=MsoNormal style='text-indent:0cm'><span class=SpellE><span
  class=spelle><span lang=EN-US style='mso-ansi-language:EN-US'>
<%
  if(title != null && title.length() != 0)
    out.print(title);
%>
  </span></span></span><span
  lang=EN-US style='mso-ansi-language:EN-US'><o:p></o:p></span></p>
  </td>
  <td width=414 valign=top style='width:248.4pt;border:solid white 1.0pt;
  border-left:none;mso-border-left-alt:solid white .5pt;mso-border-alt:solid white .5pt;
  padding:0cm 5.4pt 0cm 5.4pt;height:31.35pt'>
  <p class=MsoNormal style='text-indent:0cm'><span lang=EN-US style='font-size:
  10.0pt;mso-bidi-font-size:12.0pt;mso-ansi-language:EN-US'><o:p>&nbsp;</o:p></span></p>
  </td>
  <td width=144 valign=top style='width:86.15pt;border:solid white 1.0pt;
  border-left:none;mso-border-left-alt:solid white .5pt;mso-border-alt:solid white .5pt;
  padding:0cm 5.4pt 0cm 5.4pt;height:31.35pt'>
  <p class=MsoNormal style='text-indent:0cm'><span class=spelle><span
  lang=EN-US style='mso-ansi-language:EN-US'>
<%
  if(name != null && name.length() != 0)
    out.print(name);
%>
  </span></span><span
  lang=EN-US style='mso-ansi-language:EN-US'><o:p></o:p></span></p>
  </td>
 </tr>
 <tr style='mso-yfti-irow:1;mso-yfti-lastrow:yes;height:27.6pt'>
  <td width=171 valign=top style='width:102.6pt;border:solid white 1.0pt;
  border-top:none;mso-border-top-alt:solid white .5pt;mso-border-alt:solid white .5pt;
  padding:0cm 5.4pt 0cm 5.4pt;height:27.6pt'>
  <p class=MsoNormal align=left style='text-align:left;text-indent:0cm'><span
  class=SpellE><span lang=EN-US style='font-size:10.0pt;mso-bidi-font-size:
  12.0pt;mso-ansi-language:EN-US'>
<%
  if(performer != null && performer.length() != 0)
    out.print(performer);
%>
  </span><o:p></o:p></span></p>
  </td>
  <td width=414 valign=top style='width:248.4pt;border-top:none;border-left:
  none;border-bottom:solid white 1.0pt;border-right:solid white 1.0pt;
  mso-border-top-alt:solid white .5pt;mso-border-left-alt:solid white .5pt;
  mso-border-alt:solid white .5pt;padding:0cm 5.4pt 0cm 5.4pt;height:27.6pt'>
  <p class=MsoNormal style='text-indent:0cm'><span lang=EN-US style='font-size:
  10.0pt;mso-bidi-font-size:12.0pt;mso-ansi-language:EN-US'><o:p>&nbsp;</o:p></span></p>
  </td>
  <td width=144 valign=top style='width:86.15pt;border-top:none;border-left:
  none;border-bottom:solid white 1.0pt;border-right:solid white 1.0pt;
  mso-border-top-alt:solid white .5pt;mso-border-left-alt:solid white .5pt;
  mso-border-alt:solid white .5pt;padding:0cm 5.4pt 0cm 5.4pt;height:27.6pt'>
  <p class=MsoNormal style='text-indent:0cm'><span lang=EN-US style='font-size:
  10.0pt;mso-bidi-font-size:12.0pt;mso-ansi-language:EN-US'>
  
<%
  Object filenumberObj = request.getAttribute("filenumber");
  String filenumber = null;
  if(filenumberObj != null) {
    filenumber = (String)filenumberObj;
  }
  if(filenumber != null && filenumber.length() != 0)
    out.print(filenumber);
%>

  <o:p></o:p></span></p>
  </td>
 </tr>
</table>

</div>

</body>

</html>

