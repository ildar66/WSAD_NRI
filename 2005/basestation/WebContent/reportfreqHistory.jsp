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
<!--[if gte mso 9]><xml>
 <o:DocumentProperties>
  <o:Author>Anthon</o:Author>
  <o:LastAuthor>Anthon</o:LastAuthor>
  <o:Created>2004-11-11T12:29:23Z</o:Created>
  <o:LastSaved>2004-11-11T13:23:26Z</o:LastSaved>
  <o:Company>n/a</o:Company>
  <o:Version>10.2625</o:Version>
 </o:DocumentProperties>
 <o:OfficeDocumentSettings>
  <o:DownloadComponents/>
  <o:LocationOfComponents HRef="file:///\\"/>
 </o:OfficeDocumentSettings>
</xml><![endif]-->
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
	{mso-width-source:userset;}
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
	font-family:"Arial Narrow", sans-serif;
	mso-font-charset:204;
	text-align:center;
	vertical-align:middle;
	border-top:2.0pt double windowtext;
	border-right:.5pt solid windowtext;
	border-bottom:2.0pt double windowtext;
	border-left:.5pt solid windowtext;}
.xl26
	{mso-style-parent:style0;
	font-family:"Arial Narrow", sans-serif;
	mso-font-charset:204;
	border-top:.5pt solid windowtext;
	border-right:none;
	border-bottom:.5pt solid windowtext;
	border-left:.5pt solid windowtext;}
.xl27
	{mso-style-parent:style0;
	font-family:"Arial Narrow", sans-serif;
	mso-font-charset:204;
	border-top:2.0pt double windowtext;
	border-right:none;
	border-bottom:none;
	border-left:none;}
.xl28
	{mso-style-parent:style0;
	font-family:"Arial Narrow", sans-serif;
	mso-font-charset:204;
	border-top:2.0pt double windowtext;
	border-right:.5pt solid windowtext;
	border-bottom:none;
	border-left:none;}
.xl29
	{mso-style-parent:style0;
	font-family:"Arial Narrow", sans-serif;
	mso-font-charset:204;
	border-top:2.0pt double windowtext;
	border-right:.5pt solid windowtext;
	border-bottom:.5pt solid windowtext;
	border-left:.5pt solid windowtext;}
.xl30
	{mso-style-parent:style0;
	font-family:"Arial Narrow", sans-serif;
	mso-font-charset:204;
	mso-number-format:"Short Date";
	border-top:2.0pt double windowtext;
	border-right:.5pt solid windowtext;
	border-bottom:.5pt solid windowtext;
	border-left:.5pt solid windowtext;}
.xl31
	{mso-style-parent:style0;
	font-family:"Arial Narrow", sans-serif;
	mso-font-charset:204;
	border-top:.5pt solid windowtext;
	border-right:none;
	border-bottom:.5pt solid windowtext;
	border-left:.5pt solid windowtext;}
.xl32
	{mso-style-parent:style0;
	font-family:"Arial Narrow", sans-serif;
	mso-font-charset:204;
	border-top:.5pt solid windowtext;
	border-right:none;
	border-bottom:.5pt solid windowtext;
	border-left:none;}
.xl33
	{mso-style-parent:style0;
	font-family:"Arial Narrow", sans-serif;
	mso-font-charset:204;
	border-top:.5pt solid windowtext;
	border-right:.5pt solid windowtext;
	border-bottom:.5pt solid windowtext;
	border-left:none;}
.xl34
	{mso-style-parent:style0;
	font-family:"Arial Narrow", sans-serif;
	mso-font-charset:204;
	border:.5pt solid windowtext;}
.xl35
	{mso-style-parent:style0;
	font-family:"Arial Narrow", sans-serif;
	mso-font-charset:204;
	mso-number-format:"Short Date";
	border:.5pt solid windowtext;}
-->
</style>
<!--[if gte mso 9]><xml>
 <x:ExcelWorkbook>
  <x:ExcelWorksheets>
   <x:ExcelWorksheet>
    <x:Name>Лист1</x:Name>
    <x:WorksheetOptions>
     <x:Print>
      <x:ValidPrinterInfo/>
      <x:PaperSizeIndex>9</x:PaperSizeIndex>
      <x:HorizontalResolution>600</x:HorizontalResolution>
      <x:VerticalResolution>600</x:VerticalResolution>
     </x:Print>
     <x:Selected/>
     <x:Panes>
      <x:Pane>
       <x:Number>3</x:Number>
       <x:ActiveRow>11</x:ActiveRow>
       <x:ActiveCol>6</x:ActiveCol>
      </x:Pane>
     </x:Panes>
     <x:ProtectContents>False</x:ProtectContents>
     <x:ProtectObjects>False</x:ProtectObjects>
     <x:ProtectScenarios>False</x:ProtectScenarios>
    </x:WorksheetOptions>
   </x:ExcelWorksheet>
   <x:ExcelWorksheet>
    <x:Name>Лист2</x:Name>
    <x:WorksheetOptions>
     <x:ProtectContents>False</x:ProtectContents>
     <x:ProtectObjects>False</x:ProtectObjects>
     <x:ProtectScenarios>False</x:ProtectScenarios>
    </x:WorksheetOptions>
   </x:ExcelWorksheet>
   <x:ExcelWorksheet>
    <x:Name>Лист3</x:Name>
    <x:WorksheetOptions>
     <x:ProtectContents>False</x:ProtectContents>
     <x:ProtectObjects>False</x:ProtectObjects>
     <x:ProtectScenarios>False</x:ProtectScenarios>
    </x:WorksheetOptions>
   </x:ExcelWorksheet>
  </x:ExcelWorksheets>
  <x:WindowHeight>12405</x:WindowHeight>
  <x:WindowWidth>15180</x:WindowWidth>
  <x:WindowTopX>120</x:WindowTopX>
  <x:WindowTopY>45</x:WindowTopY>
  <x:ProtectStructure>False</x:ProtectStructure>
  <x:ProtectWindows>False</x:ProtectWindows>
 </x:ExcelWorkbook>
</xml><![endif]-->
</head>

<body link=blue vlink=purple>

<table x:str border=0 cellpadding=0 cellspacing=0 width=956 style='border-collapse:collapse;table-layout:fixed;width:717pt'>
 <col width=267 style='mso-width-source:userset;width:222pt'>
 <col width=141 style='mso-width-source:userset;width:112pt'>
 <col width=113 style='mso-width-source:userset;width:85pt'>
 <col width=141 style='mso-width-source:userset;width:112pt'>
 <col width=141 style='mso-width-source:userset;width:112pt'>
 <tr class=xl24 height=17 style='height:12.75pt'>
  <td height=17 class=xl24 colspan=2 width=267 style='height:12.75pt;mso-ignore:colspan;width:222pt'>История фйла</td>
  <td class=xl24 width=163 style='width:122pt'></td>
  <td class=xl24 width=113 style='width:85pt'></td>
  <td class=xl24 width=188 style='width:141pt'></td>
  <td class=xl24 width=241 style='width:181pt'></td>
 </tr>
 <tr class=xl24 height=17 style='height:12.75pt'>
  <td height=17 colspan=8 class=xl24 style='height:12.75pt;mso-ignore:colspan'></td>
 </tr>
 <tr class=xl24 height=17 style='height:12.75pt'>
  <td height=17 class=xl24 style='height:12.75pt'>Файл: <%=filenumber%></td>
  <td colspan=6 class=xl24 style='mso-ignore:colspan'></td>
 </tr>
 <tr class=xl24 height=17 style='height:12.75pt'>
  <td height=17 colspan=8 class=xl24 style='height:12.75pt;mso-ignore:colspan'></td>
 </tr>
 <tr class=xl24 height=18 style='height:13.5pt'>
  <td height=18 colspan=8 class=xl24 style='height:13.5pt;mso-ignore:colspan'></td>
 </tr>
 <tr class=xl24 height=32 style='mso-height-source:userset;height:24.0pt'>
  <td height=32 class=xl25 style='height:24.0pt'>Наименование документа</td>
  <td class=xl25 style='border-left:none'>Номер документа</td>
  <td class=xl25 style='border-left:none'>Дата документа</td>
  <td class=xl25 style='border-left:none'>Срок действия документа</td>
  <td class=xl25 style='border-left:none'>Комментарий к документу</td>
 </tr>
<logic:iterate id="reportLine" name="reportList" type="com.hps.july.basestation.valueobject.ReportFreqHistoryValue">
<logic:present name="reportLine">
 <tr class=xl24 height=18 style='height:13.5pt'>
  <td height=18 class=xl26 style='border-top:none;border-right:.5pt solid black; height:13.5pt'><july:stringwrite name="reportLine" property="docname"/></td>
  <td class=xl29 style='border-top:none;border-left:none'><july:stringwrite name="reportLine" property="blanknumber"/></td>
  <td class=xl30 align=right style='border-top:none;border-left:none'><july:datewrite name="reportLine" property="docdate"/></td>
  <td class=xl30 align=right style='border-top:none;border-left:none'><july:datewrite name="reportLine" property="expiredate"/></td>
  <td class=xl29 style='border-top:none;border-left:none'><july:stringwrite name="reportLine" property="comment"/></td>
 </tr>
 </logic:present>
</logic:iterate>
 <![if supportMisalignedColumns]>
 <tr height=0 style='display:none'>
  <td width=267 style='width:222pt'></td>
  <td width=141 style='width:112pt'></td>
  <td width=113 style='width:85pt'></td>
  <td width=141 style='width:112pt'></td>
  <td width=141 style='width:112pt'></td>
 </tr>
 <![endif]>
</table>

</body>

</html>
