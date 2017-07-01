<%@ page language = "java" %>
<%@ page contentType = "application/msword; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import="com.hps.july.util.*"%>
<%@ page import="com.hps.july.basestation.valueobject.*"%>
<%@ page import="java.util.*"%>
<%
	ReportRadioFreqRequestVOs values = (ReportRadioFreqRequestVOs)request.getAttribute("reportList");
	Iterator iter = null;
	String line = null;
	ReportStringPair pair = null;

	String filenumber = (String)request.getAttribute("filenumber");

	response.setHeader("Cache-Control", "no-cache");
	response.setContentType("application/msword; name=RequestFrequency"+filenumber+".doc; charset=windows-1251");
	response.setHeader ("Content-Disposition", "attachment; filename=RequestFrequency"+filenumber+".doc");
%>

<html xmlns:o="urn:schemas-microsoft-com:office:office" xmlns:w="urn:schemas-microsoft-com:office:word" xmlns="http://www.w3.org/TR/REC-html40">
<head>
<meta http-equiv=Content-Type content="application/msword; charset=Windows-1251">
<meta http-equiv="Content-Disposition" content="attachment;filename=schetFactWord.rtf">
<meta name=ProgId content=Word.Document>
<title>Заявка на назначение радиочастот для радиорелейных линий связи</title>
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
p.MsoBodyText, li.MsoBodyText, div.MsoBodyText
	{margin:0cm;
	margin-bottom:.0001pt;
	text-align:center;
	mso-pagination:widow-orphan;
	font-size:14.0pt;
	mso-bidi-font-size:12.0pt;
	font-family:"Courier New";
	mso-fareast-font-family:"Times New Roman";
	font-weight:bold;}
p.MsoBodyText2, li.MsoBodyText2, div.MsoBodyText2
	{margin-top:4.3pt;
	margin-right:0cm;
	margin-bottom:0cm;
	margin-left:0cm;
	margin-bottom:.0001pt;
	mso-pagination:none;
	tab-stops:4.5pt;
	mso-layout-grid-align:none;
	text-autospace:none;
	font-size:12.0pt;
	font-family:"Courier New";
	mso-fareast-font-family:"Times New Roman";
	color:black;}
span.GramE
	{mso-style-name:"";
	mso-gram-e:yes;}
@page Section1
	{size:595.3pt 841.9pt;
	margin:2.0cm 42.5pt 2.0cm 3.0cm;
	mso-header-margin:35.4pt;
	mso-footer-margin:35.4pt;
	mso-paper-source:0;}
div.Section1
	{page:Section1;}
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
<p class=MsoBodyText><bean:message key="label.reports.radio.title"/></p>
<p class=MsoNormal style='text-indent:0cm'><o:p>&nbsp;</o:p></p>
<table class=MsoTableGrid border=1 cellspacing=0 cellpadding=0 style='border-collapse:collapse;border:none;mso-border-alt:solid windowtext .5pt;mso-padding-alt:0cm 5.4pt 0cm 5.4pt;mso-border-insideh:.5pt solid windowtext;mso-border-insidev:.5pt solid windowtext'>
<tr style='mso-yfti-irow:0'>
  <td width=324 valign=top style='width:243.0pt;border-top:none;border-left:none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;mso-border-bottom-alt:solid windowtext .5pt;mso-border-right-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
    <p class=MsoNormal align=left style='text-align:left;text-indent:0cm'><span style='font-family:"Courier New";color:black'>1. <bean:message key="label.reports.radio.declarantname"/></span></p>
  </td>
  <td width=355 valign=top style='width:266.15pt;border:none;border-bottom:solid windowtext 1.0pt;mso-border-left-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;mso-border-bottom-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
    <p class=MsoNormal align=left style='text-align:left;text-indent:0cm'><b><span style='font-family:"Courier New";color:black'>ОАО &laquo;Вымпел-Коммуникации&raquo;</span></b></p>
  </td>
</tr>
<tr style='mso-yfti-irow:1'>
  <td width=324 valign=top style='width:243.0pt;border-top:none;border-left:none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;mso-border-top-alt:solid windowtext .5pt;mso-border-top-alt:solid windowtext .5pt;mso-border-bottom-alt:solid windowtext .5pt;mso-border-right-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
    <p class=MsoNormal align=left style='text-align:left;text-indent:0cm'><span style='font-family:"Courier New";color:black'>2. <bean:message key="label.reports.radio.address"/></span></p>
  </td>
  <td width=355 valign=top style='width:266.15pt;border:none;border-bottom:solid windowtext 1.0pt;mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;mso-border-bottom-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
    <p class=MsoNormal align=left style='text-align:left;text-indent:0cm'><b><span style='font-size:11.0pt;font-family:"Courier New";color:black'>127083, Москва, ул. 8 Марта, д.10, стр.14</span></b></p>
  </td>
</tr>
<tr style='mso-yfti-irow:2'>
  <td width=324 valign=top style='width:243.0pt;border-top:none;border-left:none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;mso-border-top-alt:solid windowtext .5pt;mso-border-top-alt:solid windowtext .5pt;mso-border-bottom-alt:solid windowtext .5pt;mso-border-right-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
    <p class=MsoNormal align=left style='text-align:left;text-indent:0cm'><span style='font-family:"Courier New";color:black'>3. <bean:message key="label.reports.radio.phone"/></span></p>
  </td>
  <td width=355 valign=top style='width:266.15pt;border:none;border-bottom:solid windowtext 1.0pt;mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;mso-border-bottom-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
    <p class=MsoNormal align=left style='text-align:left;text-indent:0cm'><b><span style='font-family:"Courier New";color:black'>910-5881, факс 244-9657</span></b></p>
  </td>
</tr>
<tr style='mso-yfti-irow:3'>
  <td width=324 valign=top style='width:243.0pt;border-top:none;border-left:none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;mso-border-top-alt:solid windowtext .5pt;mso-border-top-alt:solid windowtext .5pt;mso-border-bottom-alt:solid windowtext .5pt;mso-border-right-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
    <p class=MsoNormal align=left style='text-align:left;text-indent:0cm'><span style='font-family:"Courier New";color:black'>4. <bean:message key="label.reports.radio.register"/></span></p>
  </td>
  <td width=355 valign=top style='width:266.15pt;border:none;border-bottom:solid windowtext 1.0pt;mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;mso-border-bottom-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
    <p class=MsoNormal align=left style='text-align:left;text-indent:0cm'>&nbsp;</p>
  </td>
</tr>
<tr style='mso-yfti-irow:4'>
  <td width=324 valign=top style='width:243.0pt;border-top:none;border-left:none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;mso-border-top-alt:solid windowtext .5pt;mso-border-top-alt:solid windowtext .5pt;mso-border-bottom-alt:solid windowtext .5pt;mso-border-right-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
    <p class=MsoNormal align=left style='text-align:left;text-indent:0cm'><span style='font-family:"Courier New";color:black'>5. <bean:message key="label.reports.radio.function"/></span></p>
  </td>
  <td width=355 valign=top style='width:266.15pt;border:none;border-bottom:solid windowtext 1.0pt;mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;mso-border-bottom-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
    <p class=MsoNormal align=left style='text-align:left;text-indent:0cm'><b><span style='font-family:"Courier New";color:black'>телефония</span></b><span style='font-family:"Courier New"'><o:p></o:p></span></p>
  </td>
</tr>
<tr style='mso-yfti-irow:5'>
  <td width=324 valign=top style='width:243.0pt;border-top:none;border-left:none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;mso-border-top-alt:solid windowtext .5pt;mso-border-top-alt:solid windowtext .5pt;mso-border-bottom-alt:solid windowtext .5pt;mso-border-right-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
    <p class=MsoNormal align=left style='text-align:left;text-indent:0cm'><span style='font-family:"Courier New";color:black'>6. <bean:message key="label.reports.radio.gkrch"/></span></p>
  </td>
  <td width=355 valign=top style='width:266.15pt;border:none;border-bottom:solid windowtext 1.0pt;mso-border-left-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;mso-border-bottom-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <table class=MsoNormalTable border=1 cellspacing=3 cellpadding=0 width=426 style='width:255.3pt;mso-cellspacing:1.5pt;border:solid white 1.0pt;mso-border-alt:solid white .5pt;mso-border-insideh:.5pt solid white;mso-border-insidev:.5pt solid white'>
<%
	line = null;
	if(values != null) {
		iter = values.getGkrchs();
		while(iter.hasNext()) {
			pair = (ReportStringPair)iter.next();
%>
    <tr style='mso-yfti-irow:0'>
      <td width=212 style='width:127.05pt;border:solid white 1.0pt;mso-border-alt:solid white .5pt;padding:.75pt .75pt .75pt .75pt'>
        <p class=MsoNormal align=left style='text-align:left;text-indent:0cm'><b><span lang=EN-US style='font-size:11.0pt;mso-bidi-font-size:12.0pt;font-family:"Courier New";color:black;mso-ansi-language:EN-US'><%= pair.getFirstString() %><o:p></o:p></span></b></p>
      </td>
      <td width=206 style='width:123.75pt;border:solid white 1.0pt;mso-border-alt:solid white .5pt;padding:.75pt .75pt .75pt .75pt'>
        <p class=MsoNormal align=left style='text-align:left;text-indent:0cm'><b><span lang=EN-US style='font-size:11.0pt;mso-bidi-font-size:12.0pt;font-family:"Courier New";color:black;mso-ansi-language:EN-US'><%= pair.getSecondString() %><o:p></o:p></span></b></p>
      </td>
    </tr>
<%
		} // end of while
	} // end of if
%>
  </table>
  </td>
</tr>
<tr style='mso-yfti-irow:6'>
  <td width=324 valign=top style='width:243.0pt;border-top:none;border-left:none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;mso-border-top-alt:solid windowtext .5pt;mso-border-top-alt:solid windowtext .5pt;mso-border-bottom-alt:solid windowtext .5pt;mso-border-right-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
    <p class=MsoNormal align=left style='text-align:left;text-indent:0cm'><span style='font-family:"Courier New";color:black'>7. <bean:message key="label.reports.radio.region"/></span></p>
    <p class=MsoNormal align=left style='text-align:left;text-indent:0cm'><span style='font-family:"Courier New";color:black'>8. <bean:message key="label.reports.radio.rrlname"/></span></p>
  </td>
  <td width=355 valign=top style='width:266.15pt;border:none;border-bottom:solid windowtext 1.0pt;mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;mso-border-bottom-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
    <p class=MsoNormal align=left style='text-align:left;text-indent:0cm'><b><span style='font-family:"Courier New";color:black'>г. Москва, Московская область</span></b></p>
    <p class=MsoNormal align=left style='text-align:left;text-indent:0cm'><b><span style='font-family:"Courier New";color:black'>РРЛ транспортной сети ОАО &laquo;ВымпелКоммуникации&raquo;</span></b></p>
  </td>
</tr>
<tr style='mso-yfti-irow:7'>
  <td width=324 valign=top style='width:243.0pt;border-top:none;border-left:none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;mso-border-top-alt:solid windowtext .5pt;mso-border-top-alt:solid windowtext .5pt;mso-border-bottom-alt:solid windowtext .5pt;mso-border-right-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
    <p class=MsoNormal align=left style='text-align:left;text-indent:0cm'><span style='font-family:"Courier New";color:black'>9. <bean:message key="label.reports.radio.quantity"/></span></p>
    <p class=MsoNormal align=left style='text-align:left;text-indent:0cm'><span style='font-family:"Courier New";color:black'>10. <bean:message key="label.reports.radio.planneddate"/></span></p>
  </td>
  <td width=355 valign=top style='width:266.15pt;border:none;border-bottom:solid windowtext 1.0pt;mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;mso-border-bottom-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
    <p class=MsoNormal align=left style='text-align:left;text-indent:0cm'><b><span style='font-family:"Courier New";color:black'>
<%	
	int quantity = 0;
	if(values != null) {
		quantity = values.getHopscount();
%>
    <p class=MsoNormal align=left style='text-align:left;text-indent:0cm'><b><span lang=EN-US style='font-size:11.0pt;mso-bidi-font-size:12.0pt;font-family:"Courier New";color:black;mso-ansi-language:EN-US'><%= quantity %></span></b></p>
<%
	} // enf of if
%>
  </td>
</tr>
<tr style='mso-yfti-irow:8'>
  <td width=324 valign=top style='width:243.0pt;border-top:none;border-left:none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;mso-border-top-alt:solid windowtext .5pt;mso-border-top-alt:solid windowtext .5pt;mso-border-bottom-alt:solid windowtext .5pt;mso-border-right-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
    <p class=MsoNormal align=left style='text-align:left;text-indent:0cm'><b><span style='font-family:"Courier New";color:black'><bean:message key="label.reports.radio.technical"/><o:p></o:p></span></b></p>
    <p class=MsoNormal align=left style='text-align:left;text-indent:0cm'><span style='font-family:"Courier New";color:black'><o:p>&nbsp;</o:p></span></p>
    <p class=MsoNormal align=left style='text-align:left;text-indent:0cm'><span style='font-family:"Courier New";color:black'>11. <bean:message key="label.reports.radio.rrlnametype"/><o:p></o:p></span></p>
  </td>
  <td width=355 valign=top style='width:266.15pt;border:none;border-bottom:solid windowtext 1.0pt;mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;mso-border-bottom-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
    <p class=MsoNormal align=left style='text-align:left;text-indent:0cm'><span style='font-family:"Courier New"'><o:p>&nbsp;</o:p></span></p>
    <p class=MsoNormal align=left style='text-align:left;text-indent:0cm'><span style='font-family:"Courier New"'><o:p>&nbsp;</o:p></span></p>
    <p class=MsoNormal align=left style='text-align:left;text-indent:0cm'><b><span lang=EN-US style='font-size:11.0pt;mso-bidi-font-size:12.0pt;font-family:"Courier New";color:black;mso-ansi-language:EN-US'>
<%
	if(values != null) {
		iter = values.getModels();
		while(iter.hasNext()) {
%>
<p class=MsoNormal align=left style='text-align:left;text-indent:0cm'><b><span lang=EN-US style='font-size:11.0pt;mso-bidi-font-size:12.0pt;font-family:"Courier New";color:black;mso-ansi-language:EN-US'><%= (String)iter.next() %><o:p></o:p></span></b></p>
<% 
		} // end of while
	} // end of if
%>
  </td>
</tr>
<tr style='mso-yfti-irow:9'>
  <td width=324 valign=top style='width:243.0pt;border-top:none;border-left:none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;mso-border-top-alt:solid windowtext .5pt;mso-border-top-alt:solid windowtext .5pt;mso-border-bottom-alt:solid windowtext .5pt;mso-border-right-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
    <p class=MsoNormal align=left style='text-align:left;text-indent:0cm'><span style='font-family:"Courier New";color:black'>12. <bean:message key="label.reports.radio.manufacturer"/><o:p></o:p></span></p>
  </td>
  <td width=355 valign=top style='width:266.15pt;border:none;border-bottom:solid windowtext 1.0pt;mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;mso-border-bottom-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
<%
	if(values != null) {
		iter = values.getVendors();
		while(iter.hasNext()) {
%>
  <p class=MsoNormal align=left style='text-align:left;text-indent:0cm'><b><span lang=EN-US style='font-size:11.0pt;mso-bidi-font-size:12.0pt;font-family:"Courier New";color:black;mso-ansi-language:EN-US'><%= (String)iter.next() %><o:p></o:p></span></b></p>
<%
		} // end of while
	} // end of if
%>
  </td>
</tr>
<tr style='mso-yfti-irow:10'>
  <td width=324 valign=top style='width:243.0pt;border-top:none;border-left:none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;mso-border-top-alt:solid windowtext .5pt;mso-border-top-alt:solid windowtext .5pt;mso-border-bottom-alt:solid windowtext .5pt;mso-border-right-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
    <p class=MsoNormal align=left style='text-align:left;text-indent:0cm'><span style='font-family:"Courier New";color:black'>13. <bean:message key="label.reports.radio.freqrange"/><o:p></o:p></span></p>
  </td>
  <td width=355 valign=top style='width:266.15pt;border:none;border-bottom:solid windowtext 1.0pt;mso-border-left-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;mso-border-bottom-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
    <table class=MsoNormalTable border=1 cellspacing=3 cellpadding=0 width=426 style='width:255.3pt;mso-cellspacing:1.5pt;border:solid white 1.0pt;mso-border-alt:solid white .5pt;mso-border-insideh:.5pt solid white;mso-border-insidev:.5pt solid white'>
<%
	if(values != null) {
		iter = values.getFreqrange();
		while(iter.hasNext()) {
			pair = (ReportStringPair)iter.next();
%>
    <tr style='mso-yfti-irow:0'>
    <td width=212 style='width:127.05pt;border:solid white 1.0pt;mso-border-alt:solid white .5pt;padding:.75pt .75pt .75pt .75pt'>
      <p class=MsoNormal align=left style='text-align:left;text-indent:0cm'><b><span lang=EN-US style='font-size:11.0pt;mso-bidi-font-size:12.0pt;font-family:"Courier New";color:black;mso-ansi-language:EN-US'><%= pair.getFirstString() %><o:p></o:p></span></b></p>
    </td>
    <td width=206 style='width:123.75pt;border:solid white 1.0pt;mso-border-alt:solid white .5pt;padding:.75pt .75pt .75pt .75pt'>
      <p class=MsoNormal align=left style='text-align:left;text-indent:0cm'><b><span lang=EN-US style='font-size:11.0pt;mso-bidi-font-size:12.0pt;font-family:"Courier New";color:black;mso-ansi-language:EN-US'><%= pair.getSecondString() %><o:p></o:p></span></b></p>
    </td>
    </tr>
<%
		} // end of while
	} // end of if
%>
    </table>
  </td>
</tr>
<tr style='mso-yfti-irow:11'>
  <td width=324 valign=top style='width:243.0pt;border-top:none;border-left:none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;mso-border-top-alt:solid windowtext .5pt;mso-border-top-alt:solid windowtext .5pt;mso-border-bottom-alt:solid windowtext .5pt;mso-border-right-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
    <p class=MsoNormal align=left style='text-align:left;text-indent:0cm'><span style='font-family:"Courier New";color:black'>14. <bean:message key="label.reports.radio.radiationclass"/><o:p></o:p></span></p>
  </td>
  <td width=355 valign=top style='width:266.15pt;border:none;border-bottom:solid windowtext 1.0pt;mso-border-left-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;mso-border-bottom-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <table class=MsoNormalTable border=1 cellspacing=3 cellpadding=0 width=426 style='width:255.3pt;mso-cellspacing:1.5pt;border:solid white 1.0pt;mso-border-alt:solid white .5pt;mso-border-insideh:.5pt solid white;mso-border-insidev:.5pt solid white'>
<%
	if(values != null) {
		iter = values.getRadioclass();
		while(iter.hasNext()) {
			pair = (ReportStringPair)iter.next();
%>
  <tr style='mso-yfti-irow:0'>
    <td width=212 style='width:127.05pt;border:solid white 1.0pt;mso-border-alt: solid white .5pt;padding:.75pt .75pt .75pt .75pt'>
      <p class=MsoNormal align=left style='text-align:left;text-indent:0cm'><b><span lang=EN-US style='font-size:11.0pt;mso-bidi-font-size:12.0pt;font-family:"Courier New";color:black;mso-ansi-language:EN-US'><%= pair.getFirstString() %><o:p></o:p></span></b></p>
    </td>
    <td width=206 style='width:123.75pt;border:solid white 1.0pt;mso-border-alt: solid white .5pt;padding:.75pt .75pt .75pt .75pt'>
      <p class=MsoNormal align=left style='text-align:left;text-indent:0cm'><b><span lang=EN-US style='font-size:11.0pt;mso-bidi-font-size:12.0pt;font-family:"Courier New";color:black;mso-ansi-language:EN-US'><%= pair.getSecondString() %><o:p></o:p></span></b></p>
    </td>
  </tr>
<%
		} // end of while
	} // end of if
%>
  </table>
  </td>
</tr>
<tr style='mso-yfti-irow:12'>
  <td width=324 valign=top style='width:243.0pt;border-top:none;border-left:none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;mso-border-top-alt:solid windowtext .5pt;mso-border-top-alt:solid windowtext .5pt;mso-border-bottom-alt:solid windowtext .5pt;mso-border-right-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
    <p class=MsoNormal align=left style='text-align:left;text-indent:0cm'><span style='font-family:"Courier New";color:black'>15. <bean:message key="label.reports.radio.mkkrrecomm"/><o:p></o:p></span></p>
  </td>
  <td width=355 valign=top style='width:266.15pt;border:none;border-bottom:solid windowtext 1.0pt;mso-border-left-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;mso-border-bottom-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <table class=MsoNormalTable border=1 cellspacing=3 cellpadding=0 width=426 style='width:255.3pt;mso-cellspacing:1.5pt;border:solid white 1.0pt;mso-border-alt:solid white .5pt;mso-border-insideh:.5pt solid white;mso-border-insidev:.5pt solid white'>
<%
	if(values != null) {
		iter = values.getMkkrplan();
		while(iter.hasNext()) {
			pair = (ReportStringPair)iter.next();
%>
  <tr style='mso-yfti-irow:0'>
    <td width=212 style='width:127.05pt;border:solid white 1.0pt;mso-border-alt:solid white .5pt;padding:.75pt .75pt .75pt .75pt'>
      <p class=MsoNormal align=left style='text-align:left;text-indent:0cm'><b><span lang=EN-US style='font-size:11.0pt;mso-bidi-font-size:12.0pt;font-family:"Courier New";color:black;mso-ansi-language:EN-US'><%= pair.getFirstString() %><o:p></o:p></span></b></p>
    </td>
    <td width=206 style='width:123.75pt;border:solid white 1.0pt;mso-border-alt:solid white .5pt;padding:.75pt .75pt .75pt .75pt'>
      <p class=MsoNormal align=left style='text-align:left;text-indent:0cm'><b><span lang=EN-US style='font-size:11.0pt;mso-bidi-font-size:12.0pt;font-family:"Courier New";color:black;mso-ansi-language:EN-US'><%= pair.getSecondString() %><o:p></o:p></span></b></p>
    </td>
  </tr>
<%
		} // end of while
	} // end of if
%>
  </table>
  </td>
</tr>
<tr style='mso-yfti-irow:13'>
  <td width=324 valign=top style='width:243.0pt;border-top:none;border-left:none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;mso-border-top-alt:solid windowtext .5pt;mso-border-top-alt:solid windowtext .5pt;mso-border-bottom-alt:solid windowtext .5pt;mso-border-right-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
    <p class=MsoNormal align=left style='text-align:left;text-indent:0cm'><span style='font-family:"Courier New";color:black'>16. <bean:message key="label.reports.radio.power"/><o:p></o:p></span></p>
  </td>
  <td width=355 valign=top style='width:266.15pt;border:none;border-bottom:solid windowtext 1.0pt;mso-border-left-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;mso-border-bottom-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <table class=MsoNormalTable border=1 cellspacing=3 cellpadding=0 width=426 style='width:255.3pt;mso-cellspacing:1.5pt;border:solid white 1.0pt;mso-border-alt:solid white .5pt;mso-border-insideh:.5pt solid white;mso-border-insidev:.5pt solid white'>
<%
	if(values != null) {
		iter = values.getPowers();
		while(iter.hasNext()) {
			pair = (ReportStringPair)iter.next();
%>
  <tr style='mso-yfti-irow:0'>
    <td width=212 style='width:127.05pt;border:solid white 1.0pt;mso-border-alt:solid white .5pt;padding:.75pt .75pt .75pt .75pt'>
      <p class=MsoNormal align=left style='text-align:left;text-indent:0cm'><b><span lang=EN-US style='font-size:11.0pt;mso-bidi-font-size:12.0pt;font-family:"Courier New";color:black;mso-ansi-language:EN-US'><%= pair.getFirstString() %><o:p></o:p></span></b></p>
    </td>
    <td width=206 style='width:123.75pt;border:solid white 1.0pt;mso-border-alt:solid white .5pt;padding:.75pt .75pt .75pt .75pt'>
      <p class=MsoNormal align=left style='text-align:left;text-indent:0cm'><b><span lang=EN-US style='font-size:11.0pt;mso-bidi-font-size:12.0pt;font-family:"Courier New";color:black;mso-ansi-language:EN-US'><%= pair.getSecondString() %><o:p></o:p></span></b></p>
    </td>
  </tr>
<%
		} // end of while
	} // end of if
%>
  </table>
  </td>
</tr>
<tr style='mso-yfti-irow:14'>
  <td width=324 valign=top style='width:243.0pt;border-top:none;border-left:none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;mso-border-top-alt:solid windowtext .5pt;mso-border-top-alt:solid windowtext .5pt;mso-border-bottom-alt:solid windowtext .5pt;mso-border-right-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
    <p class=MsoNormal align=left style='text-align:left;text-indent:0cm'><span style='font-family:"Courier New";color:black'>17. <bean:message key="label.reports.radio.freqdev"/><o:p></o:p></span></p>
  </td>
  <td width=355 valign=top style='width:266.15pt;border:none;border-bottom:solid windowtext 1.0pt;mso-border-left-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;mso-border-bottom-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <table class=MsoNormalTable border=1 cellspacing=3 cellpadding=0 width=426 style='width:255.3pt;mso-cellspacing:1.5pt;border:solid white 1.0pt;mso-border-alt:solid white .5pt;mso-border-insideh:.5pt solid white;mso-border-insidev:.5pt solid white'>
<%
	if(values != null) {
		iter = values.getFreqdevs();
		while(iter.hasNext()) {
			pair = (ReportStringPair)iter.next();
%>
  <tr style='mso-yfti-irow:0'>
    <td width=212 style='width:127.05pt;border:solid white 1.0pt;mso-border-alt:solid white .5pt;padding:.75pt .75pt .75pt .75pt'>
      <p class=MsoNormal align=left style='text-align:left;text-indent:0cm'><b><span lang=EN-US style='font-size:11.0pt;mso-bidi-font-size:12.0pt;font-family:"Courier New";color:black;mso-ansi-language:EN-US'><%= pair.getFirstString() %><o:p></o:p></span></b></p>
    </td>
    <td width=206 style='width:123.75pt;border:solid white 1.0pt;mso-border-alt:solid white .5pt;padding:.75pt .75pt .75pt .75pt'>
      <p class=MsoNormal align=left style='text-align:left;text-indent:0cm'><b><span lang=EN-US style='font-size:11.0pt;mso-bidi-font-size:12.0pt;font-family:"Courier New";color:black;mso-ansi-language:EN-US'><%= pair.getSecondString() %><o:p></o:p></span></b></p>
    </td>
  </tr>
<%
		} // end of while
	} // end of if
%>
  </table>
  </td>
</tr>
<tr style='mso-yfti-irow:15'>
  <td width=324 valign=top style='width:243.0pt;border-top:none;border-left:none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;mso-border-top-alt:solid windowtext .5pt;mso-border-top-alt:solid windowtext .5pt;mso-border-bottom-alt:solid windowtext .5pt;mso-border-right-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
    <p class=MsoBodyText2>18. <bean:message key="label.reports.radio.recvsensitivity"/><span style='font-size:13.0pt'><o:p></o:p></span></p>
  <td width=355 valign=top style='width:266.15pt;border:none;border-bottom:solid windowtext 1.0pt;mso-border-left-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;mso-border-bottom-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
<%
	if(values != null) {
%>
<table class=MsoNormalTable border=1 cellspacing=3 cellpadding=0 width=426 style='width:255.3pt;mso-cellspacing:1.5pt;border:solid white 1.0pt;mso-border-alt:solid white .5pt;mso-border-insideh:.5pt solid white;mso-border-insidev:.5pt solid white;'>
<%
		iter = values.getRsens();
		while(iter.hasNext()) {
			pair = (ReportStringPair)iter.next();
%>
<tr style='mso-yfti-irow:0'>
	<td width=212 style='width:127.05pt;border:solid white 1.0pt;mso-border-alt:solid white .5pt;padding:.75pt .75pt .75pt .75pt'>
      <p class=MsoNormal align=left style='text-align:left;text-indent:0cm'><b><span lang=EN-US style='font-size:11.0pt;mso-bidi-font-size:12.0pt;font-family:"Courier New";color:black;mso-ansi-language:EN-US'><%= pair.getFirstString() %><o:p></o:p></span></b></p>
	</td>
	<td width=206 style='width:123.75pt;border:solid white 1.0pt;mso-border-alt:solid white .5pt;padding:.75pt .75pt .75pt .75pt'>
      <p class=MsoNormal align=left style='text-align:left;text-indent:0cm'><b><span lang=EN-US style='font-size:11.0pt;mso-bidi-font-size:12.0pt;font-family:"Courier New";color:black;mso-ansi-language:EN-US'><%= pair.getSecondString() %><o:p></o:p></span></b></p>
	</td>
</tr>
<%
		} // end of while
%>
</table>
<%
	} // end of if
%>
  </td>
</tr>
<tr style='mso-yfti-irow:16;mso-yfti-lastrow:yes'>
  <td width=324 valign=top style='width:243.0pt;
border:none;
border-right:solid windowtext 1.0pt;
mso-border-top-alt:solid windowtext .5pt;
mso-border-right-alt:solid windowtext .5pt;
padding:0cm 5.4pt 0cm 5.4pt'>
    <p class=MsoNormal align=left style='margin-top:4.3pt;text-align:left;text-indent:0cm;mso-pagination:none;tab-stops:4.5pt;mso-layout-grid-align:none;text-autospace:none'><span style='font-family:"Courier New";color:black'>19. <bean:message key="label.reports.radio.antdiam"/><o:p></o:p></span></p>
  </td>
  <td width=355 valign=top style='width:266.15pt;
border:none;
mso-border-top-alt:solid windowtext .5pt;
mso-border-left-alt:solid windowtext .5pt;
padding:0cm 5.4pt 0cm 5.4pt'>
    <p class=MsoNormal align=left style='text-align:left;text-indent:0cm'><span class=GramE><b><span style='font-size:11.0pt;mso-bidi-font-size:12.0pt;font-family:"Courier New";color:black'>Параболическая, 
  </span></b></span><b><span style='font-size:11.0pt;mso-bidi-font-size:12.0pt;font-family:"Courier New";color:black'>
<%
	if(values != null) {
		iter = values.getAnttypes();
		while(iter.hasNext()) {
			out.print((String)iter.next());
			if(iter.hasNext()) {
				out.print(", ");
			}
		} // end of while
    } // end of if
  %>
  <o:p></o:p></span></b></p>
  </td>
 </tr>
<!--/table>

<p class=MsoNormal style='margin-top:4.3pt;text-indent:0cm;mso-pagination:none;
tab-stops:4.5pt;mso-layout-grid-align:none;text-autospace:none'><span
style='font-family:"Courier New";color:black'><o:p>&nbsp;</o:p></span></p-->

<!--p class=MsoNormal style='text-indent:0cm'><i>Форма отчета. Лист 2<o:p></o:p></i></p-->

<!--p class=MsoBodyText><bean:message key="label.reports.radio.title"/></p>

<p class=MsoNormal style='margin-top:4.3pt;text-indent:0cm;mso-pagination:none;
tab-stops:4.5pt;mso-layout-grid-align:none;text-autospace:none'><span
style='font-family:"Courier New";color:black'><o:p>&nbsp;</o:p></span></p>

<table class=MsoTableGrid border=1 cellspacing=0 cellpadding=0
 style='border-collapse:collapse;border:none;mso-border-alt:solid windowtext .5pt;
 mso-padding-alt:0cm 5.4pt 0cm 5.4pt;mso-border-insideh:.5pt solid windowtext;
 mso-border-insidev:.5pt solid windowtext'-->

<tr style='mso-yfti-irow:0'>
  <td width=324 valign=top style='width:243.0pt;
border-top:solid windowtext 1.0pt;
border-left:none;
border-bottom:solid windowtext 1.0pt;
border-right:solid windowtext 1.0pt;
mso-border-top-alt:solid windowtext .5pt;
mso-border-bottom-alt:solid windowtext .5pt;
mso-border-right-alt:solid windowtext .5pt;
padding:0cm 5.4pt 0cm 5.4pt'>
    <p class=MsoNormal align=left style='margin-top:4.3pt;text-align:left;text-indent:0cm;mso-pagination:none;tab-stops:4.5pt;mso-layout-grid-align:none;text-autospace:none'><span style='font-family:"Courier New";color:black'>20. <bean:message key="label.reports.radio.amplifkoeff"/><o:p></o:p></span></p>
  </td>
  <td width=355 valign=top style='width:266.15pt;
border:none;
border-top:solid windowtext 1.0pt;
border-bottom:solid windowtext 1.0pt;
mso-border-left-alt:solid windowtext .5pt;
mso-border-top-alt:solid windowtext .5pt;
mso-border-bottom-alt:solid windowtext .5pt;
padding:0cm 5.4pt 0cm 5.4pt'>
   <table class=MsoNormalTable border=1 cellspacing=3 cellpadding=0 width=426 style='width:255.3pt;mso-cellspacing:1.5pt;border:solid white 1.0pt;mso-border-alt:solid white .5pt;mso-border-insideh:.5pt solid white;mso-border-insidev:.5pt solid white'>
<%
	if(values != null) {
		iter = values.getCoeff();
		while(iter.hasNext()) {
			pair = (ReportStringPair)iter.next();
%>
     <tr style='mso-yfti-irow:0'>
    <td width=212 style='width:127.05pt;border:solid white 1.0pt;mso-border-alt:
    solid white .5pt;padding:.75pt .75pt .75pt .75pt'>
    <p class=MsoNormal align=left style='text-align:left;text-indent:0cm'><b><span
    lang=EN-US style='font-size:11.0pt;mso-bidi-font-size:12.0pt;font-family:
    "Courier New";color:black;mso-ansi-language:EN-US'><%= pair.getFirstString() %><o:p></o:p></span></b></p>
    </td>
    <td width=206 style='width:123.75pt;border:solid white 1.0pt;mso-border-alt:
    solid white .5pt;padding:.75pt .75pt .75pt .75pt'>
    <p class=MsoNormal align=left style='text-align:left;text-indent:0cm'><b><span
    lang=EN-US style='font-size:11.0pt;mso-bidi-font-size:12.0pt;font-family:
    "Courier New";color:black;mso-ansi-language:EN-US'><%= pair.getSecondString() %><o:p></o:p></span></b></p>
    </td>

<%
		} // end of while
	} // end of if
%>
  </table>
  </td>
</tr>
<tr style='mso-yfti-irow:1'>
  <td width=324 valign=top style='width:243.0pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-top-alt:solid windowtext .5pt;
  mso-border-bottom-alt:solid windowtext .5pt;mso-border-right-alt:solid windowtext .5pt;
  padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoNormal align=left style='margin-top:4.3pt;text-align:left;
  text-indent:0cm;mso-pagination:none;tab-stops:4.5pt;mso-layout-grid-align:
  none;text-autospace:none'><span style='font-family:"Courier New";color:black'>21.
  <bean:message key="label.reports.radio.dnangle"/><o:p></o:p></span></p>
  </td>
  <td width=355 valign=top style='width:266.15pt;border:none;border-bottom:
  solid windowtext 1.0pt;mso-border-left-alt:solid windowtext .5pt;mso-border-left-alt:
  solid windowtext .5pt;mso-border-bottom-alt:solid windowtext .5pt;padding:
  0cm 5.4pt 0cm 5.4pt'>
  
  <table class=MsoNormalTable border=1 cellspacing=3 cellpadding=0 width=426
   style='width:255.3pt;mso-cellspacing:1.5pt;border:solid white 1.0pt;
   mso-border-alt:solid white .5pt;mso-border-insideh:.5pt solid white;
   mso-border-insidev:.5pt solid white'>

<%
	if(values != null) {
		iter = values.getWidths();
		while(iter.hasNext()) {
			pair = (ReportStringPair)iter.next();
  %>
     <tr style='mso-yfti-irow:0'>
    <td width=212 style='width:127.05pt;border:solid white 1.0pt;mso-border-alt:
    solid white .5pt;padding:.75pt .75pt .75pt .75pt'>
    <p class=MsoNormal align=left style='text-align:left;text-indent:0cm'><b><span
    lang=EN-US style='font-size:11.0pt;mso-bidi-font-size:12.0pt;font-family:
    "Courier New";color:black;mso-ansi-language:EN-US'><%= pair.getFirstString() %><o:p></o:p></span></b></p>
    </td>
    <td width=206 style='width:123.75pt;border:solid white 1.0pt;mso-border-alt:
    solid white .5pt;padding:.75pt .75pt .75pt .75pt'>
    <p class=MsoNormal align=left style='text-align:left;text-indent:0cm'><b><span
    lang=EN-US style='font-size:11.0pt;mso-bidi-font-size:12.0pt;font-family:
    "Courier New";color:black;mso-ansi-language:EN-US'><%= pair.getSecondString() %><o:p></o:p></span></b></p>
    </td>

<%
		} // end of while
	} // end of if
%>
  </table>
  </td>
 </tr>
 <tr style='mso-yfti-irow:2'>
  <td width=324 valign=top style='width:243.0pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-top-alt:solid windowtext .5pt;
  mso-border-bottom-alt:solid windowtext .5pt;mso-border-right-alt:solid windowtext .5pt;
  padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoNormal align=left style='margin-top:4.3pt;text-align:left;
  text-indent:0cm;mso-pagination:none;tab-stops:4.5pt;mso-layout-grid-align:
  none;text-autospace:none'><span style='font-family:"Courier New";color:black'>22.
  <bean:message key="label.reports.radio.numberofchannels"/><o:p></o:p></span></p>
  </td>
  <td width=355 valign=top style='width:266.15pt;border:none;border-bottom:
  solid windowtext 1.0pt;mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:
  solid windowtext .5pt;mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:
  solid windowtext .5pt;mso-border-bottom-alt:solid windowtext .5pt;padding:
  0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoNormal align=left style='margin-top:4.3pt;text-align:left;
  text-indent:0cm;mso-pagination:none;tab-stops:4.5pt;mso-layout-grid-align:
  none;text-autospace:none'><span style='font-family:"Courier New";color:black'><o:p>&nbsp;</o:p></span></p>
  </td>
</tr>
<tr style='mso-yfti-irow:3'>
  <td width=324 valign=top style='width:243.0pt;border-top:none;border-left:none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;mso-border-top-alt:solid windowtext .5pt;mso-border-top-alt:solid windowtext .5pt;mso-border-bottom-alt:solid windowtext .5pt;mso-border-right-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
    <p class=MsoNormal align=left style='margin-top:4.3pt;text-align:left;text-indent:0cm;mso-pagination:none;tab-stops:4.5pt;mso-layout-grid-align:none;text-autospace:none'><span style='font-family:"Courier New";color:black'>23. <bean:message key="label.reports.radio.streamspeed"/></span><o:p></o:p></span></p>
  </td>
  <td width=355 valign=top style='width:266.15pt;border:none;border-bottom:solid windowtext 1.0pt;mso-border-left-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;mso-border-bottom-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <table class=MsoNormalTable border=1 cellspacing=3 cellpadding=0 width=426 style='width:255.3pt;mso-cellspacing:1.5pt;border:solid white 1.0pt;mso-border-alt:solid white .5pt;mso-border-insideh:.5pt solid white;mso-border-insidev:.5pt solid white'>
<%
	if(values != null) {
		iter = values.getSpeeds();
		while(iter.hasNext()) {
			pair = (ReportStringPair)iter.next();
%>
    <tr style='mso-yfti-irow:0'>
      <td width=212 style='width:127.05pt;border:solid white 1.0pt;mso-border-alt:solid white .5pt;padding:.75pt .75pt .75pt .75pt'>
        <p class=MsoNormal align=left style='text-align:left;text-indent:0cm'><b><span lang=EN-US style='font-size:11.0pt;mso-bidi-font-size:12.0pt;font-family:"Courier New";color:black;mso-ansi-language:EN-US'><%= pair.getFirstString() %><o:p></o:p></span></b></p>
      </td>
      <td width=206 style='width:123.75pt;border:solid white 1.0pt;mso-border-alt:solid white .5pt;padding:.75pt .75pt .75pt .75pt'>
        <p class=MsoNormal align=left style='text-align:left;text-indent:0cm'><b><span lang=EN-US style='font-size:11.0pt;mso-bidi-font-size:12.0pt;font-family:"Courier New";color:black;mso-ansi-language:EN-US'><%= pair.getSecondString() %><o:p></o:p></span></b></p>
      </td>

<%
		} // end of while
	} // end of if
%>
  </table>
  </td>
 </tr>
 <tr style='mso-yfti-irow:4;mso-yfti-lastrow:yes'>
  <td width=324 valign=top style='width:243.0pt;border-top:none;border-left:none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;mso-border-top-alt:solid windowtext .5pt;mso-border-top-alt:solid windowtext .5pt;mso-border-bottom-alt:solid windowtext .5pt;mso-border-right-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoNormal align=left style='margin-top:4.3pt;text-align:left;text-indent:0cm;mso-pagination:none;tab-stops:4.5pt;mso-layout-grid-align:none;text-autospace:none'><span style='font-family:"Courier New";color:black'>24. <bean:message key="label.reports.radio.rrlnumber"/><o:p></o:p></span></p>
  </td>
  <td width=355 valign=top style='width:266.15pt;border:none;border-bottom:solid windowtext 1.0pt;mso-border-left-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;mso-border-bottom-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
 
  <table class=MsoNormalTable border=1 cellspacing=3 cellpadding=0 width=426 style='width:255.3pt;mso-cellspacing:1.5pt;border:solid white 1.0pt; mso-border-alt:solid white .5pt;mso-border-insideh:.5pt solid white;mso-border-insidev:.5pt solid white'>
<%
	if(values != null) {
		iter = values.getRrls();
		while(iter.hasNext()) {
			pair = (ReportStringPair)iter.next();
%>
     <tr style='mso-yfti-irow:0'>
    <td width=212 style='width:127.05pt;border:solid white 1.0pt;mso-border-alt:
    solid white .5pt;padding:.75pt .75pt .75pt .75pt'>
    <p class=MsoNormal align=left style='text-align:left;text-indent:0cm'><b><span
    lang=EN-US style='font-size:11.0pt;mso-bidi-font-size:12.0pt;font-family:
    "Courier New";color:black;mso-ansi-language:EN-US'><%= pair.getFirstString() %></span></b></p>
    </td>
    <td width=206 style='width:123.75pt;border:solid white 1.0pt;mso-border-alt:solid white .5pt;padding:.75pt .75pt .75pt .75pt'> <p class=MsoNormal align=left style='text-align:left;text-indent:0cm'><b><span lang=EN-US style='font-size:11.0pt;mso-bidi-font-size:12.0pt;font-family:"Courier New";color:black;mso-ansi-language:EN-US'><%= pair.getSecondString() %></span></b></p>
    </td>

<%
		} // end of while
	} // end of if
%>
  </table>
  </td>
 </tr>
</table>

<p class=MsoNormal style='text-indent:0cm'><o:p>&nbsp;</o:p></p>
<%
	String underlineTitle = null;
	String underlineName = null;
	Object underlineTitleObj = request.getAttribute("underlinetitle");
	if(null != underlineTitleObj) {
		underlineTitle = (String)underlineTitleObj;
	}
	Object underlineNameObj = request.getAttribute("underlinename");
	if(null != underlineNameObj) {
		underlineName = (String)underlineNameObj;
	}
// mso-border-alt:solid windowtext .5pt;mso-padding-alt:0cm 5.4pt 0cm 5.4pt;
// mso-border-insideh:.5pt solid windowtext;mso-border-insidev:.5pt solid windowtext
%>
<table class=MsoTableGrid border=0 cellspacing=0 cellpadding=0 style='border-collapse:collapse;border:none;'>
 <tr style='mso-yfti-irow:0;mso-yfti-lastrow:yes'>
  <td width=432 valign=top style='width:324.0pt;padding:0cm 5.4pt 0cm 5.4pt'>
    <p class=MsoNormal align=left style='text-align:left;text-indent:0cm'><span style='font-family:"Courier New";color:black'><%= underlineTitle %></span><span style='color:blue'><o:p></o:p></span></p>
  </td>
  <td width=240 valign=top style='width:180.0pt;padding:0cm 5.4pt 0cm 5.4pt'>
    <p class=MsoNormal style='text-indent:0cm'><span style='font-family:"Courier New";color:blue'><o:p>&nbsp;</o:p></span></p>
    <p class=MsoNormal style='text-indent:0cm'><span style='font-family:"Courier New";color:blue'><o:p>&nbsp;</o:p></span></p>
    <p class=MsoNormal align=right style='text-align:right;text-indent:0cm'><span style='font-family:"Courier New";color:black'><%= underlineName %></span></p>
  </td>
 </tr>
</table>

</div>

</body>

</html>
