<%@ page language = "java" %>
<%@ page contentType = "application/msword; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import="java.util.*"%>
<%@ page import="com.hps.july.cdbc.lib.*"%>
<%@ page import="com.hps.july.web.util.*"%>
<%@ page import="com.hps.july.util.*"%>

<%
System.out.println("GET ORDER LETTER Start");
%>

<html xmlns:v="urn:schemas-microsoft-com:vml" xmlns:o="urn:schemas-microsoft-com:office:office" xmlns:w="urn:schemas-microsoft-com:office:word" xmlns="http://www.w3.org/TR/REC-html40">

<head>
	<meta http-equiv=Content-Type content="text/html; charset=windows-1251">
	<meta name=ProgId content=Word.Document>
	<meta name=Generator content="Microsoft Word 10">
	<meta name=Originator content="Microsoft Word 10">
	<title>Письмо-заказ</title>
<style>
<!--
 /* Font Definitions */
 @font-face
	{font-family:Wingdings;
	panose-1:5 0 0 0 0 0 0 0 0 0;
	mso-font-charset:2;
	mso-generic-font-family:auto;
	mso-font-pitch:variable;
	mso-font-signature:0 268435456 0 0 -2147483648 0;}
@font-face
	{font-family:"Arial Unicode MS";
	panose-1:0 0 0 0 0 0 0 0 0 0;
	mso-font-charset:0;
	mso-generic-font-family:roman;
	mso-font-format:other;
	mso-font-pitch:variable;
	mso-font-signature:3 0 0 0 1 0;}
@font-face
	{font-family:"Arial Narrow";
	panose-1:2 11 5 6 2 2 2 3 2 4;
	mso-font-charset:204;
	mso-generic-font-family:swiss;
	mso-font-pitch:variable;
	mso-font-signature:647 0 0 0 159 0;}
@font-face
	{font-family:"Arial CYR";
	panose-1:2 11 6 4 2 2 2 2 2 4;
	mso-font-charset:204;
	mso-generic-font-family:swiss;
	mso-font-pitch:variable;
	mso-font-signature:536902279 -2147483648 8 0 511 0;}
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
h1
	{mso-style-next:Обычный;
	margin-top:12.0pt;
	margin-right:0cm;
	margin-bottom:3.0pt;
	margin-left:21.6pt;
	text-align:justify;
	text-indent:-21.6pt;
	mso-pagination:widow-orphan;
	page-break-after:avoid;
	mso-outline-level:1;
	mso-list:l1 level1 lfo1;
	tab-stops:list 21.6pt;
	font-size:14.0pt;
	mso-bidi-font-size:10.0pt;
	font-family:Arial;
	mso-bidi-font-family:"Times New Roman";
	mso-font-kerning:14.0pt;
	mso-bidi-font-weight:normal;}
h2
	{mso-style-next:Обычный;
	margin-top:12.0pt;
	margin-right:0cm;
	margin-bottom:3.0pt;
	margin-left:28.8pt;
	text-align:justify;
	text-indent:-28.8pt;
	mso-pagination:widow-orphan;
	page-break-after:avoid;
	mso-outline-level:2;
	mso-list:l1 level2 lfo2;
	tab-stops:list 28.8pt;
	font-size:14.0pt;
	mso-bidi-font-size:10.0pt;
	font-family:"Times New Roman";
	mso-bidi-font-weight:normal;
	font-style:italic;
	mso-bidi-font-style:normal;}
h3
	{mso-style-next:Обычный;
	margin-top:12.0pt;
	margin-right:0cm;
	margin-bottom:3.0pt;
	margin-left:36.0pt;
	text-align:justify;
	text-indent:-36.0pt;
	mso-pagination:widow-orphan;
	page-break-after:avoid;
	mso-outline-level:3;
	mso-list:l1 level3 lfo3;
	tab-stops:list 36.0pt;
	font-size:12.0pt;
	mso-bidi-font-size:10.0pt;
	font-family:Arial;
	mso-bidi-font-family:"Times New Roman";
	mso-bidi-font-weight:normal;}
h4
	{mso-style-next:Обычный;
	margin-top:0cm;
	margin-right:0cm;
	margin-bottom:0cm;
	margin-left:43.2pt;
	margin-bottom:.0001pt;
	text-align:justify;
	text-indent:-43.2pt;
	mso-pagination:widow-orphan;
	page-break-after:avoid;
	mso-outline-level:4;
	mso-list:l1 level4 lfo4;
	tab-stops:list 43.2pt;
	font-size:12.0pt;
	mso-bidi-font-size:10.0pt;
	font-family:"Times New Roman";
	font-weight:normal;
	font-style:italic;
	mso-bidi-font-style:normal;}
h5
	{mso-style-next:Обычный;
	margin-top:12.0pt;
	margin-right:0cm;
	margin-bottom:3.0pt;
	margin-left:50.4pt;
	text-align:justify;
	text-indent:-50.4pt;
	mso-pagination:widow-orphan;
	mso-outline-level:5;
	mso-list:l1 level5 lfo5;
	tab-stops:list 50.4pt;
	font-size:13.0pt;
	font-family:"Times New Roman";
	font-style:italic;}
h6
	{mso-style-next:Обычный;
	margin-top:12.0pt;
	margin-right:0cm;
	margin-bottom:3.0pt;
	margin-left:57.6pt;
	text-align:justify;
	text-indent:-57.6pt;
	mso-pagination:widow-orphan;
	mso-outline-level:6;
	mso-list:l1 level6 lfo6;
	tab-stops:list 57.6pt;
	font-size:11.0pt;
	font-family:"Times New Roman";}
p.MsoHeading7, li.MsoHeading7, div.MsoHeading7
	{mso-style-next:Обычный;
	margin-top:12.0pt;
	margin-right:0cm;
	margin-bottom:3.0pt;
	margin-left:64.8pt;
	text-align:justify;
	text-indent:-64.8pt;
	mso-pagination:widow-orphan;
	mso-outline-level:7;
	mso-list:l1 level7 lfo7;
	tab-stops:list 64.8pt;
	font-size:12.0pt;
	font-family:"Times New Roman";
	mso-fareast-font-family:"Times New Roman";}
p.MsoHeading8, li.MsoHeading8, div.MsoHeading8
	{mso-style-next:Обычный;
	margin-top:12.0pt;
	margin-right:0cm;
	margin-bottom:3.0pt;
	margin-left:72.0pt;
	text-align:justify;
	text-indent:-72.0pt;
	mso-pagination:widow-orphan;
	mso-outline-level:8;
	mso-list:l1 level8 lfo8;
	tab-stops:list 72.0pt;
	font-size:12.0pt;
	font-family:"Times New Roman";
	mso-fareast-font-family:"Times New Roman";
	font-style:italic;}
p.MsoHeading9, li.MsoHeading9, div.MsoHeading9
	{mso-style-next:Обычный;
	margin-top:12.0pt;
	margin-right:0cm;
	margin-bottom:3.0pt;
	margin-left:79.2pt;
	text-align:justify;
	text-indent:-79.2pt;
	mso-pagination:widow-orphan;
	mso-outline-level:9;
	mso-list:l1 level9 lfo9;
	tab-stops:list 79.2pt;
	font-size:11.0pt;
	font-family:Arial;
	mso-fareast-font-family:"Times New Roman";}
p.MsoToc1, li.MsoToc1, div.MsoToc1
	{mso-style-update:auto;
	mso-style-noshow:yes;
	mso-style-next:Обычный;
	margin:0cm;
	margin-bottom:.0001pt;
	text-align:center;
	text-indent:35.45pt;
	mso-pagination:widow-orphan;
	font-size:12.0pt;
	font-family:"Times New Roman";
	mso-fareast-font-family:"Times New Roman";}
p.MsoToc2, li.MsoToc2, div.MsoToc2
	{mso-style-update:auto;
	mso-style-noshow:yes;
	mso-style-next:Обычный;
	margin-top:0cm;
	margin-right:0cm;
	margin-bottom:0cm;
	margin-left:12.0pt;
	margin-bottom:.0001pt;
	text-align:justify;
	text-indent:35.45pt;
	mso-pagination:widow-orphan;
	font-size:12.0pt;
	font-family:"Times New Roman";
	mso-fareast-font-family:"Times New Roman";}
p.MsoToc3, li.MsoToc3, div.MsoToc3
	{mso-style-update:auto;
	mso-style-noshow:yes;
	mso-style-next:Обычный;
	margin-top:0cm;
	margin-right:0cm;
	margin-bottom:0cm;
	margin-left:24.0pt;
	margin-bottom:.0001pt;
	text-align:justify;
	text-indent:35.45pt;
	mso-pagination:widow-orphan;
	font-size:12.0pt;
	font-family:"Times New Roman";
	mso-fareast-font-family:"Times New Roman";}
p.MsoToc4, li.MsoToc4, div.MsoToc4
	{mso-style-update:auto;
	mso-style-noshow:yes;
	mso-style-next:Обычный;
	margin-top:0cm;
	margin-right:0cm;
	margin-bottom:0cm;
	margin-left:36.0pt;
	margin-bottom:.0001pt;
	text-align:justify;
	text-indent:35.45pt;
	mso-pagination:widow-orphan;
	font-size:12.0pt;
	font-family:"Times New Roman";
	mso-fareast-font-family:"Times New Roman";}
p.MsoToc5, li.MsoToc5, div.MsoToc5
	{mso-style-update:auto;
	mso-style-noshow:yes;
	mso-style-next:Обычный;
	margin-top:0cm;
	margin-right:0cm;
	margin-bottom:0cm;
	margin-left:48.0pt;
	margin-bottom:.0001pt;
	text-align:justify;
	text-indent:35.45pt;
	mso-pagination:widow-orphan;
	font-size:12.0pt;
	font-family:"Times New Roman";
	mso-fareast-font-family:"Times New Roman";}
p.MsoToc6, li.MsoToc6, div.MsoToc6
	{mso-style-update:auto;
	mso-style-noshow:yes;
	mso-style-next:Обычный;
	margin-top:0cm;
	margin-right:0cm;
	margin-bottom:0cm;
	margin-left:60.0pt;
	margin-bottom:.0001pt;
	text-align:justify;
	text-indent:35.45pt;
	mso-pagination:widow-orphan;
	font-size:12.0pt;
	font-family:"Times New Roman";
	mso-fareast-font-family:"Times New Roman";}
p.MsoToc7, li.MsoToc7, div.MsoToc7
	{mso-style-update:auto;
	mso-style-noshow:yes;
	mso-style-next:Обычный;
	margin-top:0cm;
	margin-right:0cm;
	margin-bottom:0cm;
	margin-left:72.0pt;
	margin-bottom:.0001pt;
	text-align:justify;
	text-indent:35.45pt;
	mso-pagination:widow-orphan;
	font-size:12.0pt;
	font-family:"Times New Roman";
	mso-fareast-font-family:"Times New Roman";}
p.MsoToc8, li.MsoToc8, div.MsoToc8
	{mso-style-update:auto;
	mso-style-noshow:yes;
	mso-style-next:Обычный;
	margin-top:0cm;
	margin-right:0cm;
	margin-bottom:0cm;
	margin-left:84.0pt;
	margin-bottom:.0001pt;
	text-align:justify;
	text-indent:35.45pt;
	mso-pagination:widow-orphan;
	font-size:12.0pt;
	font-family:"Times New Roman";
	mso-fareast-font-family:"Times New Roman";}
p.MsoToc9, li.MsoToc9, div.MsoToc9
	{mso-style-update:auto;
	mso-style-noshow:yes;
	mso-style-next:Обычный;
	margin-top:0cm;
	margin-right:0cm;
	margin-bottom:0cm;
	margin-left:96.0pt;
	margin-bottom:.0001pt;
	text-align:justify;
	text-indent:35.45pt;
	mso-pagination:widow-orphan;
	font-size:12.0pt;
	font-family:"Times New Roman";
	mso-fareast-font-family:"Times New Roman";}
p.MsoBodyTextIndent, li.MsoBodyTextIndent, div.MsoBodyTextIndent
	{margin-top:0cm;
	margin-right:0cm;
	margin-bottom:0cm;
	margin-left:54.0pt;
	margin-bottom:.0001pt;
	text-align:justify;
	mso-pagination:widow-orphan;
	font-size:12.0pt;
	font-family:"Times New Roman";
	mso-fareast-font-family:"Times New Roman";}
p.MsoBodyTextIndent2, li.MsoBodyTextIndent2, div.MsoBodyTextIndent2
	{margin:0cm;
	margin-bottom:.0001pt;
	text-align:justify;
	text-indent:18.55pt;
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
a:link, span.MsoHyperlink
	{color:blue;
	text-decoration:underline;
	text-underline:single;}
a:visited, span.MsoHyperlinkFollowed
	{color:purple;
	text-decoration:underline;
	text-underline:single;}
p.a, li.a, div.a
	{mso-style-name:"Заголовок документа";
	margin:0cm;
	margin-bottom:.0001pt;
	text-align:justify;
	page-break-before:always;
	mso-pagination:widow-orphan lines-together;
	page-break-after:avoid;
	font-size:18.0pt;
	mso-bidi-font-size:10.0pt;
	font-family:Arial;
	mso-fareast-font-family:"Times New Roman";
	mso-bidi-font-family:"Times New Roman";
	font-weight:bold;
	mso-bidi-font-weight:normal;}
p.a0, li.a0, div.a0
	{mso-style-name:"Заголовок оглавления";
	mso-style-parent:"Заголовок 1";
	margin-top:12.0pt;
	margin-right:0cm;
	margin-bottom:3.0pt;
	margin-left:0cm;
	text-align:justify;
	mso-pagination:widow-orphan;
	page-break-after:avoid;
	mso-outline-level:1;
	font-size:14.0pt;
	mso-bidi-font-size:10.0pt;
	font-family:Arial;
	mso-fareast-font-family:"Times New Roman";
	mso-bidi-font-family:"Times New Roman";
	mso-font-kerning:14.0pt;
	font-weight:bold;
	mso-bidi-font-weight:normal;}
p.a1, li.a1, div.a1
	{mso-style-name:"Подпись под рисунком";
	margin-top:0cm;
	margin-right:0cm;
	margin-bottom:6.0pt;
	margin-left:0cm;
	text-align:center;
	text-indent:0cm;
	mso-pagination:widow-orphan;
	mso-list:l6 level1 lfo10;
	font-size:12.0pt;
	mso-bidi-font-size:10.0pt;
	font-family:"Times New Roman";
	mso-fareast-font-family:"Times New Roman";}
p.a2, li.a2, div.a2
	{mso-style-name:Рисунок;
	mso-style-next:"Подпись под рисунком";
	margin-top:6.0pt;
	margin-right:0cm;
	margin-bottom:0cm;
	margin-left:0cm;
	margin-bottom:.0001pt;
	text-align:center;
	mso-pagination:widow-orphan;
	font-size:12.0pt;
	font-family:"Times New Roman";
	mso-fareast-font-family:"Times New Roman";}
span.GramE
	{mso-style-name:"";
	mso-gram-e:yes;}
@page Section1
	{size:595.3pt 841.9pt;
	margin:2.0cm 28.3pt 2.0cm 54.0pt;
	mso-header-margin:35.4pt;
	mso-footer-margin:35.4pt;
	mso-paper-source:0;}
div.Section1
	{page:Section1;}
 /* List Definitions */
 @list l0
	{mso-list-id:102842867;
	mso-list-type:hybrid;
	mso-list-template-ids:-1667220976 -1662752722 68747289 68747291 68747279 68747289 68747291 68747279 68747289 68747291;}
@list l0:level1
	{mso-level-tab-stop:53.4pt;
	mso-level-number-position:left;
	margin-left:53.4pt;
	text-indent:-18.0pt;}
@list l1
	{mso-list-id:301010091;
	mso-list-template-ids:1899643612;}
@list l1:level1
	{mso-level-style-link:"Заголовок 1";
	mso-level-text:%1;
	mso-level-tab-stop:21.6pt;
	mso-level-number-position:left;
	margin-left:21.6pt;
	text-indent:-21.6pt;}
@list l1:level2
	{mso-level-style-link:"Заголовок 2";
	mso-level-text:"%1\.%2";
	mso-level-tab-stop:28.8pt;
	mso-level-number-position:left;
	margin-left:28.8pt;
	text-indent:-28.8pt;}
@list l1:level3
	{mso-level-style-link:"Заголовок 3";
	mso-level-text:"%1\.%2\.%3";
	mso-level-tab-stop:36.0pt;
	mso-level-number-position:left;
	margin-left:36.0pt;
	text-indent:-36.0pt;}
@list l1:level4
	{mso-level-style-link:"Заголовок 4";
	mso-level-text:"%1\.%2\.%3\.%4";
	mso-level-tab-stop:43.2pt;
	mso-level-number-position:left;
	margin-left:43.2pt;
	text-indent:-43.2pt;}
@list l1:level5
	{mso-level-style-link:"Заголовок 5";
	mso-level-text:"%1\.%2\.%3\.%4\.%5";
	mso-level-tab-stop:50.4pt;
	mso-level-number-position:left;
	margin-left:50.4pt;
	text-indent:-50.4pt;}
@list l1:level6
	{mso-level-style-link:"Заголовок 6";
	mso-level-text:"%1\.%2\.%3\.%4\.%5\.%6";
	mso-level-tab-stop:57.6pt;
	mso-level-number-position:left;
	margin-left:57.6pt;
	text-indent:-57.6pt;}
@list l1:level7
	{mso-level-style-link:"Заголовок 7";
	mso-level-text:"%1\.%2\.%3\.%4\.%5\.%6\.%7";
	mso-level-tab-stop:64.8pt;
	mso-level-number-position:left;
	margin-left:64.8pt;
	text-indent:-64.8pt;}
@list l1:level8
	{mso-level-style-link:"Заголовок 8";
	mso-level-text:"%1\.%2\.%3\.%4\.%5\.%6\.%7\.%8";
	mso-level-tab-stop:72.0pt;
	mso-level-number-position:left;
	margin-left:72.0pt;
	text-indent:-72.0pt;}
@list l1:level9
	{mso-level-style-link:"Заголовок 9";
	mso-level-text:"%1\.%2\.%3\.%4\.%5\.%6\.%7\.%8\.%9";
	mso-level-tab-stop:79.2pt;
	mso-level-number-position:left;
	margin-left:79.2pt;
	text-indent:-79.2pt;}
@list l2
	{mso-list-id:346443672;
	mso-list-type:hybrid;
	mso-list-template-ids:-1952927584 -1662752722 68747289 68747291 68747279 68747289 68747291 68747279 68747289 68747291;}
@list l2:level1
	{mso-level-tab-stop:53.4pt;
	mso-level-number-position:left;
	margin-left:53.4pt;
	text-indent:-18.0pt;}
@list l3
	{mso-list-id:430662891;
	mso-list-type:hybrid;
	mso-list-template-ids:-1225598062 -492160782 157826268 68747269 68747265 68747267 68747269 68747265 68747267 68747269;}
@list l3:level1
	{mso-level-number-format:bullet;
	mso-level-text:-;
	mso-level-tab-stop:53.45pt;
	mso-level-number-position:left;
	margin-left:53.45pt;
	text-indent:-18.0pt;
	font-family:"Times New Roman";
	mso-fareast-font-family:"Times New Roman";}
@list l3:level2
	{mso-level-number-format:bullet;
	mso-level-text:\F0B7;
	mso-level-tab-stop:89.45pt;
	mso-level-number-position:left;
	margin-left:89.45pt;
	text-indent:-18.0pt;
	font-family:Symbol;
	mso-fareast-font-family:"Times New Roman";
	mso-bidi-font-family:"Times New Roman";}
@list l4
	{mso-list-id:675378525;
	mso-list-type:hybrid;
	mso-list-template-ids:774676212 145028396 68747289 68747291 68747279 68747289 68747291 68747279 68747289 68747291;}
@list l4:level1
	{mso-level-text:"%1\)";
	mso-level-tab-stop:83.45pt;
	mso-level-number-position:left;
	margin-left:83.45pt;
	text-indent:-48.0pt;}
@list l5
	{mso-list-id:1514952874;
	mso-list-type:hybrid;
	mso-list-template-ids:1152947954 1517206318 68747289 68747291 68747279 68747289 68747291 68747279 68747289 68747291;}
@list l5:level1
	{mso-level-tab-stop:53.45pt;
	mso-level-number-position:left;
	margin-left:53.45pt;
	text-indent:-18.0pt;}
@list l6
	{mso-list-id:1543514995;
	mso-list-template-ids:1280234664;}
@list l6:level1
	{mso-level-style-link:"Подпись под рисунком";
	mso-level-suffix:space;
	mso-level-text:"Рис\. %1\.";
	mso-level-tab-stop:none;
	mso-level-number-position:left;
	text-indent:0cm;}
@list l6:level2
	{mso-level-number-format:none;
	mso-level-suffix:none;
	mso-level-text:"";
	mso-level-tab-stop:none;
	mso-level-number-position:left;
	margin-left:36.0pt;
	text-indent:0cm;}
@list l6:level3
	{mso-level-number-format:none;
	mso-level-suffix:none;
	mso-level-text:"";
	mso-level-tab-stop:none;
	mso-level-number-position:left;
	margin-left:36.0pt;
	text-indent:0cm;}
@list l6:level4
	{mso-level-number-format:none;
	mso-level-suffix:none;
	mso-level-text:"";
	mso-level-tab-stop:none;
	mso-level-number-position:left;
	margin-left:36.0pt;
	text-indent:0cm;}
@list l6:level5
	{mso-level-number-format:none;
	mso-level-suffix:none;
	mso-level-text:"";
	mso-level-tab-stop:none;
	mso-level-number-position:left;
	margin-left:36.0pt;
	text-indent:0cm;}
@list l6:level6
	{mso-level-number-format:none;
	mso-level-suffix:none;
	mso-level-text:"";
	mso-level-tab-stop:none;
	mso-level-number-position:left;
	margin-left:36.0pt;
	text-indent:0cm;}
@list l6:level7
	{mso-level-number-format:none;
	mso-level-suffix:none;
	mso-level-text:"";
	mso-level-tab-stop:none;
	mso-level-number-position:left;
	margin-left:36.0pt;
	text-indent:0cm;}
@list l6:level8
	{mso-level-number-format:none;
	mso-level-suffix:none;
	mso-level-text:"";
	mso-level-tab-stop:none;
	mso-level-number-position:left;
	margin-left:36.0pt;
	text-indent:0cm;}
@list l6:level9
	{mso-level-number-format:none;
	mso-level-suffix:none;
	mso-level-text:"";
	mso-level-tab-stop:none;
	mso-level-number-position:left;
	margin-left:36.0pt;
	text-indent:0cm;}
@list l7
	{mso-list-id:1686247620;
	mso-list-type:hybrid;
	mso-list-template-ids:1814698120 271615162 68747289 68747291 68747279 68747289 68747291 68747279 68747289 68747291;}
@list l7:level1
	{mso-level-tab-stop:53.45pt;
	mso-level-number-position:left;
	margin-left:53.45pt;
	text-indent:-18.0pt;}
ol
	{margin-bottom:0cm;}
ul
	{margin-bottom:0cm;}
-->
</style>
</head>

<%
	String ol_to = AppUtils.getNamedValueString("OrderLetter_TO");
	String ol_boss = AppUtils.getNamedValueString("OrderLetter_BOSS");
	String ol_man = AppUtils.getNamedValueString("OrderLetter_MAN");
	String ol_manphone = AppUtils.getNamedValueString("OrderLetter_MAN_PHONE");

	CDBCResultSet rs = (CDBCResultSet)request.getAttribute("reportList");
	int rc = rs.getRowsCount();
%>

<body lang=RU link=blue vlink=purple style='tab-interval:35.4pt'>
<div class=Section1>

<p class=MsoNormal style='text-indent:35.4pt'><span style='font-size:11.0pt;mso-bidi-font-size:12.0pt'>
<img width=613 height=211 src='<%="http://"+request.getServerName()%>/images/orderletter_title.jpg' ></span>
<span lang=EN-US style='font-size:11.0pt;mso-bidi-font-size:12.0pt;mso-ansi-language:EN-US'></span>
</p>

<p class=MsoNormal><span lang=EN-US style='font-size:11.0pt;mso-bidi-font-size:12.0pt;mso-ansi-language:EN-US'></span></p>
<p class=MsoNormal><span lang=EN-US style='font-size:11.0pt;mso-bidi-font-size:12.0pt;mso-ansi-language:EN-US'></span></p>
<p class=MsoNormal align=right style='text-align:right'><span style='font-size:11.0pt;mso-bidi-font-size:12.0pt;color:blue'><%=ol_to%></span></p>
<p class=MsoNormal><span style='font-size:11.0pt;mso-bidi-font-size:12.0pt'><o:p>&nbsp;</o:p></span></p>
<p class=MsoNormal align=center style='margin-top:18.0pt;text-align:center'><span style='font-size:11.0pt;mso-bidi-font-size:12.0pt'>Уважаемый Константин Абрамович!</span></p>
<p class=MsoNormal><span style='font-size:11.0pt;mso-bidi-font-size:12.0pt'><o:p>&nbsp;</o:p></span></p>
<p class=MsoNormal><span style='font-size:11.0pt;mso-bidi-font-size:12.0pt'><o:p>&nbsp;</o:p></span></p>
<p class=MsoNormal style='text-indent:0cm'><span style='font-size:11.0pt;mso-bidi-font-size:12.0pt'>В соответствии с договором № 40 прошу Вас провести работы по привязке к Госсети <%=rc%> БС в Москве и Московской области.</span></p>
<p class=MsoNormal><span style='font-size:11.0pt;mso-bidi-font-size:12.0pt'><o:p>&nbsp;</o:p></span></p>

<table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width=648 style='width:486.0pt;margin-left:18.75pt;border-collapse:collapse;mso-padding-alt:0cm 0cm 0cm 0cm'>

<%
	int i = 1;
	Iterator it = rs.listIterator();
	while(it.hasNext()) {
		CDBCRowObject rl = (CDBCRowObject)it.next();
		pageContext.setAttribute("rl",rl);
%>
<tr style='mso-yfti-irow:0;height:12.75pt'>
  <td width=36 nowrap valign=bottom style='width:27.0pt;border:solid windowtext 1.0pt;mso-border-alt:solid windowtext .5pt;padding:.75pt .75pt 0cm .75pt;height:12.75pt'>
	  <p class=MsoNormal align=right style='margin-left:-9.7pt;text-align:right;text-indent:0cm'><span style='font-size:10.0pt;font-family:"Arial Narrow";mso-bidi-font-family:"Arial CYR"'><%=i%></span></p>
  </td>
  <td width=36 valign=bottom style='width:27.0pt;border:solid windowtext 1.0pt;border-left:none;mso-border-top-alt:solid windowtext .5pt;mso-border-bottom-alt:solid windowtext .5pt;mso-border-right-alt:solid windowtext .5pt;padding:.75pt .75pt 0cm .75pt;height:12.75pt'>
	  <p class=MsoNormal align=right style='text-align:right;text-indent:0cm'><span style='font-size:10.0pt;font-family:"Arial Narrow";mso-bidi-font-family:"Arial CYR";color:black'><july:stringwrite name="rl" property="gsmid"/></span></p>
  </td>
  <td width=180 valign=bottom style='width:135.0pt;border:solid windowtext 1.0pt;border-left:none;mso-border-top-alt:solid windowtext .5pt;mso-border-bottom-alt:solid windowtext .5pt;mso-border-right-alt:solid windowtext .5pt;padding:.75pt .75pt 0cm .75pt;height:12.75pt'>
	  <p class=MsoNormal style='text-indent:0cm'><span style='font-size:10.0pt;font-family:"Arial Narrow";mso-bidi-font-family:"Arial CYR";color:black'><july:stringwrite name="rl" property="posname"/></span></p>
  </td>
  <td width=396 valign=bottom style='width:297.0pt;border:solid windowtext 1.0pt;border-left:none;mso-border-top-alt:solid windowtext .5pt;mso-border-bottom-alt:solid windowtext .5pt;mso-border-right-alt:solid windowtext .5pt;padding:.75pt .75pt 0cm .75pt;height:12.75pt'>
	  <p class=MsoNormal style='text-indent:0cm'><span style='font-size:10.0pt;font-family:"Arial Narrow";mso-bidi-font-family:"Arial CYR";color:black'><july:stringwrite name="rl" property="addr"/></span></p>
  </td>
</tr>
<%
		i++;
	}
%>

</table>

<p class=MsoNormal><o:p>&nbsp;</o:p></p>

<p class=MsoNormal style='margin-top:24.0pt'><span style='font-size:11.0pt;mso-bidi-font-size:12.0pt'>С уважением,</span></p>
<p class=MsoNormal><span style='font-size:11.0pt;mso-bidi-font-size:12.0pt'></span></p>
<p class=MsoNormal><span style='font-size:11.0pt;mso-bidi-font-size:12.0pt;'><%=ol_boss%></span></p>
<p class=MsoNormal style='margin-top:50.0pt;text-align:left;'><span style='font-size:11.0pt;mso-bidi-font-size:12.0pt;'><%=ol_man%></span></p>
<p class=MsoNormal style='text-align:left;'><span style='font-size:11.0pt;mso-bidi-font-size:12.0pt;'><%=ol_manphone%></span></p>
</div>
</body>
</html>
