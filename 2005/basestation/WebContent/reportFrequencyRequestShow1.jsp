<%@ page language = "java" %>
<%@ page contentType = "application/vnd.ms-excel; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import="com.hps.july.util.*"%>
<% 
	String filenumber = (String)request.getAttribute("filenumber");
	String slash = null;
	String name = "FreqReq" + filenumber;
	String urlName = AppUtils.filter(name);
	response.setHeader("Cache-Control", "no-cache");
	response.setContentType("application/msword; name="+ java.net.URLEncoder.encode(urlName+".xls") +";charset=windows-1251");
	response.setHeader ("Content-Disposition", "attachment; filename=freqreq.xls");
%>
<html xmlns:o="urn:schemas-microsoft-com:office:office" xmlns:x="urn:schemas-microsoft-com:office:excel" xmlns="http://www.w3.org/TR/REC-html40">

<head>
<meta http-equiv=Content-Type content="text/html; charset=windows-1251">
<meta name=ProgId content=Excel.Sheet>
<meta name=Generator content="Microsoft Excel 10">
<!--[if gte mso 9]><xml>
 <o:DocumentProperties>
  <o:Version>10.2625</o:Version>
 </o:DocumentProperties>
 <o:OfficeDocumentSettings>
  <o:DownloadComponents/>
  <o:LocationOfComponents HRef="file:///\\msowc.cab"/>
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
	font-family:"Arial Narrow";
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
	font-family:"Arial Narrow";
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
	font-weight:700;
	font-family:"Arial Narrow", sans-serif;
	mso-font-charset:204;}
.xl25
	{mso-style-parent:style0;
	font-weight:700;
	font-family:"Arial Narrow", sans-serif;
	mso-font-charset:204;
	text-align:center;
	vertical-align:middle;
	border-top:none;
	border-right:.5pt solid windowtext;
	border-bottom:none;
	border-left:none;
	white-space:normal;}
.xl26
	{mso-style-parent:style0;
	text-align:left;
	white-space:normal;}
.xl27
	{mso-style-parent:style0;
	font-weight:700;
	font-family:"Arial Narrow", sans-serif;
	mso-font-charset:204;
	text-align:center;
	vertical-align:middle;
	border-top:2.0pt double windowtext;
	border-right:.5pt solid windowtext;
	border-bottom:none;
	border-left:.5pt solid windowtext;
	white-space:normal;}
.xl28
	{mso-style-parent:style0;
	font-weight:700;
	font-family:"Arial Narrow", sans-serif;
	mso-font-charset:204;
	text-align:center;
	vertical-align:middle;
	border-top:2.0pt double windowtext;
	border-right:none;
	border-bottom:2.0pt double windowtext;
	border-left:.5pt solid windowtext;
	white-space:normal;}
.xl29
	{mso-style-parent:style0;
	font-weight:700;
	font-family:"Arial Narrow", sans-serif;
	mso-font-charset:204;
	text-align:center;
	vertical-align:middle;
	border-top:2.0pt double windowtext;
	border-right:.5pt solid windowtext;
	border-bottom:2.0pt double windowtext;
	border-left:none;
	white-space:normal;}
.xl30
	{mso-style-parent:style0;
	font-weight:700;
	font-family:"Arial Narrow", sans-serif;
	mso-font-charset:204;
	text-align:center;
	vertical-align:middle;
	border-top:none;
	border-right:.5pt solid windowtext;
	border-bottom:none;
	border-left:.5pt solid windowtext;
	white-space:normal;}
.xl31
	{mso-style-parent:style0;
	text-align:center;
	vertical-align:middle;
	border-top:none;
	border-right:.5pt solid windowtext;
	border-bottom:2.0pt double windowtext;
	border-left:.5pt solid windowtext;
	white-space:normal;}
.xl32
	{mso-style-parent:style0;
	text-align:center;
	vertical-align:middle;
	border-top:none;
	border-right:.5pt solid windowtext;
	border-bottom:2.0pt double windowtext;
	border-left:none;
	white-space:normal;}
.xl33
	{mso-style-parent:style0;
	text-align:center;
	vertical-align:middle;
	border-top:2.0pt double windowtext;
	border-right:.5pt solid windowtext;
	border-bottom:.5pt solid windowtext;
	border-left:.5pt solid windowtext;
	white-space:normal;}
.xl34
	{mso-style-parent:style0;
	text-align:center;
	vertical-align:middle;
	border-top:2.0pt double windowtext;
	border-right:.5pt solid windowtext;
	border-bottom:2.0pt double windowtext;
	border-left:none;
	white-space:normal;}

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
       <x:ActiveRow>5</x:ActiveRow>
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
  <x:WindowHeight>8625</x:WindowHeight>
  <x:WindowWidth>15240</x:WindowWidth>
  <x:WindowTopX>0</x:WindowTopX>
  <x:WindowTopY>1770</x:WindowTopY>
  <x:ProtectStructure>False</x:ProtectStructure>
  <x:ProtectWindows>False</x:ProtectWindows>
 </x:ExcelWorkbook>
</xml><![endif]-->
</head>

<body link=blue vlink=purple>
<table x:str border=0 cellpadding=0 cellspacing=0 width=1095 style='border-collapse:
 collapse;table-layout:fixed;width:824pt'>
 <col width=224 style='mso-width-source:userset;mso-width-alt:9557;width:168pt'>
 <col width=72 style='mso-width-source:userset;mso-width-alt:3072;width:54pt'>
 <col width=70 style='mso-width-source:userset;mso-width-alt:2986;width:53pt'>
 <col width=72 style='mso-width-source:userset;mso-width-alt:3072;width:54pt'>
 <col width=70 style='mso-width-source:userset;mso-width-alt:2986;width:53pt'>
 <col width=68 style='mso-width-source:userset;mso-width-alt:2901;width:51pt'>
 <col width=98 style='mso-width-source:userset;mso-width-alt:4181;width:74pt'>
 <col width=78 style='mso-width-source:userset;mso-width-alt:3328;width:59pt'>
 <col width=69 style='mso-width-source:userset;mso-width-alt:2944;width:52pt'>
 <col width=73 style='mso-width-source:userset;mso-width-alt:3114;width:55pt'>
 <col width=56 style='width:42pt'>
 <col width=145 style='mso-width-source:userset;mso-width-alt:6186;width:109pt'>
 <col width=56 span=5 style='width:42pt'>
 <col width=187 style='mso-width-source:userset;mso-width-alt:7978;width:140pt'>
 <tr height=17 style='height:12.75pt'>
  <td height=17 class=xl24 colspan=2 width=296 style='height:12.75pt; mso-ignore:colspan;width:222pt'><bean:message key="label.reports.freqrequest.title1"/></td>
  <td class=xl24 width=70 style='width:53pt'></td>
  <td class=xl24 width=72 style='width:54pt'></td>
  <td class=xl24 width=70 style='width:53pt'></td>
  <td class=xl24 width=68 style='width:51pt'></td>
  <td class=xl24 width=98 style='width:74pt'></td>
  <td width=78 style='width:59pt'></td>
  <td width=69 style='width:52pt'></td>
  <td width=73 style='width:55pt'></td>
  <td width=56 style='width:42pt'></td>
  <td width=145 style='width:109pt'></td>
 </tr>
 <tr height=17 style='height:12.75pt'>
  <td height=17 class=xl24 colspan=2 style='height:12.75pt;mso-ignore:colspan'><bean:message key="label.reports.freqrequest.title2"/></td>
  <td class=xl24 align=right x:num><%= filenumber %></td>
  <td colspan=4 class=xl24 style='mso-ignore:colspan'></td>
  <td colspan=5 style='mso-ignore:colspan'></td>
 </tr>
 <tr height=18 style='height:13.5pt'>
  <td height=18 class=xl24 style='height:13.5pt'><bean:message key="label.reports.freqrequest.title3"/></td>
  <td colspan=2 style='mso-ignore:colspan'></td>
  <td colspan=4 class=xl24 style='mso-ignore:colspan'></td>
  <td colspan=5 style='mso-ignore:colspan'></td>
 </tr>
 <tr height=28 style='mso-height-source:userset;height:21.0pt'>
  <td rowspan=2 height=70 class=xl27 width=224 style='height:52.5pt;width:168pt'><bean:message key="label.reports.freqrequest.coordinates"/></td>
  <td rowspan=2 class=xl27 width=72 style='width:54pt'><bean:message key="label.reports.freqrequest.height"/></td>
  <td rowspan=2 class=xl27 width=70 style='width:53pt'><bean:message key="label.reports.freqrequest.azimuth"/></td>
  <td rowspan=2 class=xl27 width=72 style='width:54pt'><bean:message key="label.reports.freqrequest.distance"/></td>
  <td colspan=2 class=xl28 width=138 style='border-right:.5pt solid black;border-left:none;width:104pt'><bean:message key="label.reports.freqrequest.frequency"/></td>
  <td rowspan=2 class=xl27 width=98 style='width:74pt'><bean:message key="label.reports.freqrequest.power"/></td>
  <td rowspan=2 class=xl27 width=78 style='width:59pt'><bean:message key="label.reports.freqrequest.resource"/></td>
  <td rowspan=2 class=xl27 width=69 style='width:52pt'><bean:message key="label.reports.freqrequest.antdiam"/></td>
  <td rowspan=2 class=xl27 width=73 style='width:55pt'><bean:message key="label.reports.freqrequest.amplifkoeff"/></td>
  <td rowspan=2 class=xl27 width=56 style='width:42pt'><bean:message key="label.reports.freqrequest.dnangle"/></td>
  <td rowspan=2 class=xl27 width=145 style='width:109pt'><bean:message key="label.reports.freqrequest.docaddress"/></td>
 </tr>
 <tr height=42 style='mso-height-source:userset;height:31.5pt'>
  <td height=42 class=xl25 width=70 style='height:31.5pt;width:53pt'><bean:message key="label.reports.freqrequest.frequencyb"/></td>
  <td class=xl25 width=68 style='width:51pt'><bean:message key="label.reports.freqrequest.frequencya"/></td>
 </tr>
<logic:iterate id="reportLine" name="reportList" type="com.hps.july.basestation.valueobject.ReportFrequencyRequestValue">
<logic:present name="reportLine">
 <tr height=35 style='height:26.25pt'>
  <td height=35 class=xl33 width=224 style='height:26.25pt;width:168pt'><july:stringwrite name="reportLine" property="gsmid1"/> <july:stringwrite name="reportLine" property="name1"/><br><july:stringwrite name="reportLine" property="address1"/></td>
  <td class=xl33 width=72 style='border-left:none;width:54pt'><july:stringwrite name="reportLine" property="height_aFrm"/></td>
  <td class=xl33 width=70 style='border-left:none;width:53pt'><july:stringwrite name="reportLine" property="azimuth_aFrm"/></td>
  <td rowspan=2 class=xl34 width=72 style='border-left:none;width:54pt'><july:stringwrite name="reportLine" property="distanceFrm"/></td>
  <td class=xl33 width=70 style='border-left:none;width:53pt'><july:stringwrite name="reportLine" property="frequency_bFrm"/></td>
  <td class=xl33 width=68 style='border-left:none;width:51pt'><july:stringwrite name="reportLine" property="frequency_aFrm"/></td>
  <td rowspan=2 class=xl34 width=98 style='border-left:none;width:74pt'><july:stringwrite name="reportLine" property="powerFrm"/></td>
  <td rowspan=2 class=xl34 width=78 style='border-left:none;width:59pt'><july:stringwrite name="reportLine" property="model"/><br><july:stringwrite name="reportLine" property="speed"/></td>
  <td class=xl33 width=69 style='border-left:none;width:52pt'><july:stringwrite name="reportLine" property="antdiam_a"/></td>
  <td class=xl33 width=73 style='border-left:none;width:55pt'><july:stringwrite name="reportLine" property="amplifkoeff_a"/></td>
<% if((reportLine.getDnangleh_a() != null) && (reportLine.getDnangleh_a() != null)) slash = "/"; else slash = ""; %>
  <td class=xl33 width=56 style='border-left:none;width:42pt'><july:stringwrite name="reportLine" property="dnangleh_a"/><%= slash %><july:stringwrite name="reportLine" property="dnanglew_a"/></td>
  <td class=xl33 width=145 style='border-left:none;width:109pt'><july:stringwrite name="reportLine" property="docaddress_a"/></td>
 </tr>
 <tr height=35 style='height:26.25pt'>
  <td height=35 class=xl31 width=224 style='height:26.25pt;width:168pt'><july:stringwrite name="reportLine" property="gsmid2"/> <july:stringwrite name="reportLine" property="name2"/><br> <july:stringwrite name="reportLine" property="address2"/></td>
  <td class=xl32 width=72 style='width:54pt'><july:stringwrite name="reportLine" property="height_bFrm"/></td>
  <td class=xl32 width=70 style='width:53pt'><july:stringwrite name="reportLine" property="azimuth_bFrm"/></td>
  <td class=xl32 width=70 style='width:53pt'><july:stringwrite name="reportLine" property="frequency_aFrm"/></td>
  <td class=xl32 width=68 style='width:51pt'><july:stringwrite name="reportLine" property="frequency_bFrm"/></td>
  <td class=xl32 width=69 style='width:52pt'><july:stringwrite name="reportLine" property="antdiam_b"/></td>
  <td class=xl32 width=73 style='width:55pt'><july:stringwrite name="reportLine" property="amplifkoeff_b"/></td>
<% if((reportLine.getDnangleh_b() != null) && (reportLine.getDnangleh_b() != null)) slash = "/"; else slash = ""; %>
  <td class=xl32 width=56 style='width:42pt'><july:stringwrite name="reportLine" property="dnangleh_b"/><%= slash %> <july:stringwrite name="reportLine" property="dnanglew_b"/></td>
  <td class=xl32 width=145 style='width:109pt'><july:stringwrite name="reportLine" property="docaddress_b"/></td>
 </tr>
</logic:present>
</logic:iterate>
 <tr height=30 style='mso-height-source:userset;height:22.5pt'>
  <td height=30 style='height:22.5pt'></td>
  <td colspan=4 class=xl26 style='mso-ignore:colspan'></td>
  <td colspan=7 style='mso-ignore:colspan'></td>
 </tr>
<%
	String underlineTitle = null;
	String underlineName = null;
	Object underlineTitleObj = request.getAttribute("underlinetitle");
	if(null != underlineTitleObj)
		underlineTitle = (String)underlineTitleObj;
	Object underlineNameObj = request.getAttribute("underlinename");
	if(null != underlineNameObj)
		underlineName = (String)underlineNameObj;
%>
 <tr height=38 style='mso-height-source:userset;height:28.5pt'>
  <td colspan=4 height=38 class=xl26 width=438 style='height:28.5pt;width:329pt'><%= underlineTitle %></td>
  <td><%= underlineName %></td>
  <td colspan=7 style='mso-ignore:colspan'></td>
 </tr>
 <tr height=17 style='height:12.75pt'>
  <td height=17 colspan=5 class=xl26 style='height:12.75pt;mso-ignore:colspan'></td>
  <td colspan=7 style='mso-ignore:colspan'></td>
 </tr>
 <![if supportMisalignedColumns]>
 <tr height=0 style='display:none'>
  <td width=224 style='width:168pt'></td>
  <td width=72 style='width:54pt'></td>
  <td width=70 style='width:53pt'></td>
  <td width=72 style='width:54pt'></td>
  <td width=70 style='width:53pt'></td>
  <td width=68 style='width:51pt'></td>
  <td width=98 style='width:74pt'></td>
  <td width=78 style='width:59pt'></td>
  <td width=69 style='width:52pt'></td>
  <td width=73 style='width:55pt'></td>
  <td width=56 style='width:42pt'></td>
  <td width=145 style='width:109pt'></td>
 </tr>
 <![endif]>
</table>

</body>

</html>
