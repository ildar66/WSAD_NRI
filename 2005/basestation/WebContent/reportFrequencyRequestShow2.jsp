<%@ page language = "java" %>
<%@ page contentType = "application/vnd.ms-excel; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import="com.hps.july.util.*, com.hps.july.basestation.valueobject.*"%>
<%
System.out.println("report show jsp");
%>
<html xmlns:v="urn:schemas-microsoft-com:vml"
xmlns:o="urn:schemas-microsoft-com:office:office"
xmlns:x="urn:schemas-microsoft-com:office:excel"
xmlns="http://www.w3.org/TR/REC-html40">

<head>
<meta http-equiv=Content-Type content="text/html; charset=windows-1251">
<meta name=ProgId content=Excel.Sheet>
<meta name=Generator content="Microsoft Excel 9">
<link rel=File-List href="./ЗаявкаНаЧастоты%20вар2.files/filelist.xml">
<link rel=Edit-Time-Data href="./ЗаявкаНаЧастоты%20вар2.files/editdata.mso">
<link rel=OLE-Object-Data href="./ЗаявкаНаЧастоты%20вар2.files/oledata.mso">
<!--[if gte mso 9]><xml>
 <o:DocumentProperties>
  <o:Author>Gerasimov</o:Author>
  <o:LastAuthor>Gerasimov</o:LastAuthor>
  <o:Created>2004-08-19T12:51:13Z</o:Created>
  <o:LastSaved>2004-08-19T13:43:54Z</o:LastSaved>
  <o:Company>TATCO</o:Company>
  <o:Version>9.2812</o:Version>
 </o:DocumentProperties>
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
	border:.5pt solid windowtext;
	white-space:normal;}
.xl26
	{mso-style-parent:style0;
	font-weight:700;
	font-family:"Arial Narrow", sans-serif;
	mso-font-charset:204;
	text-align:center;
	vertical-align:top;
	border:.5pt solid windowtext;
	white-space:normal;}
.xl27
	{mso-style-parent:style0;
	text-align:center;
	vertical-align:middle;
	border:.5pt solid windowtext;
	white-space:normal;}
.xl28
	{mso-style-parent:style0;
	border:.5pt solid windowtext;
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
       <x:ActiveRow>10</x:ActiveRow>
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
  <x:WindowHeight>12660</x:WindowHeight>
  <x:WindowWidth>19020</x:WindowWidth>
  <x:WindowTopX>120</x:WindowTopX>
  <x:WindowTopY>135</x:WindowTopY>
  <x:ProtectStructure>False</x:ProtectStructure>
  <x:ProtectWindows>False</x:ProtectWindows>
 </x:ExcelWorkbook>
</xml><![endif]--><!--[if gte mso 9]><xml>
 <o:shapedefaults v:ext="edit" spidmax="1026"/>
</xml><![endif]-->
</head>

<body link=blue vlink=purple>

<%
	String regionName = null;
	Object regionObj = request.getAttribute("regionstr");
	if(regionObj != null) {
		regionName = (String)regionObj;
	}
%>

<table x:str border=0 cellpadding=0 cellspacing=0 width=1600 style='border-collapse:collapse;table-layout:fixed;width:1200pt'>
 <col width=40 span=25 style='width:40pt'>
 <tr height=17 style='height:12.75pt'>
  <td height=17 width=40 style='height:12.75pt;width:40pt'></td>
  <td width=40 style='width:40pt'></td>
  <td width=40 style='width:40pt'></td>
  <td width=40 style='width:40pt'></td>
  <td class=xl24 colspan=3 width=192 style='mso-ignore:colspan;width:144pt'><bean:message key="label.reports.freqrequest2.title"/> <%= regionName %></td>
  <td width=80 style='width:80pt'></td>
  <td width=80 style='width:80pt'></td>
  <td width=40 style='width:40pt'></td>
  <td width=40 style='width:40pt'></td>
  <td width=40 style='width:40pt'></td>
  <td width=40 style='width:40pt'></td>
  <td width=40 style='width:40pt'></td>
  <td width=40 style='width:40pt'></td>
  <td width=40 style='width:40pt'></td>
  <td width=40 style='width:40pt'></td>
  <td width=40 style='width:40pt'></td>
  <td width=40 style='width:40pt'></td>
  <td width=40 style='width:40pt'></td>
  <td width=40 style='width:40pt'></td>
  <td width=40 style='width:40pt'></td>
  <td width=40 style='width:40pt'></td>
  <td width=40 style='width:40pt'></td>
  <td width=40 style='width:40pt'></td>
  <td width=40 style='width:40pt'></td>
  <td width=40 style='width:40pt'></td>
 </tr>
 <tr height=18 style='height:13.5pt'>
  <td height=18 colspan=27 style='height:13.5pt;mso-ignore:colspan'></td>
 </tr>
 <tr height=19 style='height:14.25pt'>
  <td height=57 class=xl25 width=40 style='height:42.75pt;width:40pt;border-bottom:2.0pt double black;'><bean:message key="label.reports.freqrequest2.number"/></td>
  <td class=xl25 width=40 style='width:40pt;border-bottom:2.0pt double black;'><bean:message key="label.reports.freqrequest2.linktogosnet_lat"/></td>
  <td class=xl25 width=40 style='width:40pt;border-bottom:2.0pt double black;'><bean:message key="label.reports.freqrequest2.linktogosnet_lon"/></td>
  <td class=xl25 width=40 style='width:40pt;border-bottom:2.0pt double black;'><bean:message key="label.reports.freqrequest2.gsmid"/></td>
  <td class=xl25 width=80 style='mso-width-source:userset;width:80pt;border-bottom:2.0pt double black;'><bean:message key="label.reports.freqrequest2.name"/></td>
  <td class=xl25 width=80 style='mso-width-source:userset;width:80pt;border-bottom:2.0pt double black;'><bean:message key="label.reports.freqrequest2.address"/></td>
  <td class=xl25 width=40 style='width:40pt;border-bottom:2.0pt double black;'><bean:message key="label.reports.freqrequest2.heigh"/></td>
  <td class=xl25 width=40 style='width:40pt;border-bottom:2.0pt double black;'><bean:message key="label.reports.freqrequest2.power"/></td>
  <td class=xl25 width=40 style='width:40pt;border-bottom:2.0pt double black;'><bean:message key="label.reports.freqrequest2.azimuth"/></td>
  <td class=xl25 width=40 style='width:40pt;border-bottom:2.0pt double black;'><bean:message key="label.reports.freqrequest2.dnangle_h"/></td>
  <td class=xl25 width=40 style='width:40pt;border-bottom:2.0pt double black;'><bean:message key="label.reports.freqrequest2.angle"/></td>
  <td class=xl25 width=40 style='width:40pt;border-bottom:2.0pt double black;'><bean:message key="label.reports.freqrequest2.dnangle_w"/></td>
  <td class=xl25 width=40 style='width:40pt;border-bottom:2.0pt double black;'><bean:message key="label.reports.freqrequest2.amplifkoeff"/></td>
  <td class=xl25 width=40 style='width:40pt;border-bottom:2.0pt double black;'><bean:message key="label.reports.freqrequest2.losts"/></td>
  <td class=xl25 width=40 style='width:40pt;border-bottom:2.0pt double black;'><bean:message key="label.reports.freqrequest2.kfreq"/></td>
  <td class=xl25 width=40 style='width:40pt;border-bottom:2.0pt double black;'><bean:message key="label.reports.freqrequest2.frequency_ab"/></td>
  <td class=xl25 width=40 style='width:40pt;border-bottom:2.0pt double black;'><bean:message key="label.reports.freqrequest2.kfreq"/></td>
  <td class=xl25 width=40 style='width:40pt;border-bottom:2.0pt double black;'><bean:message key="label.reports.freqrequest2.frequency_ba"/></td>
  <td class=xl25 width=40 style='width:40pt;border-bottom:2.0pt double black;'><bean:message key="label.reports.freqrequest2.polarization"/></td>
  <td class=xl25 width=40 style='width:40pt;border-bottom:2.0pt double black;'><bean:message key="label.reports.freqrequest2.radiationclass"/></td>
  <td class=xl25 width=40 style='width:40pt;border-bottom:2.0pt double black;'><bean:message key="label.reports.freqrequest2.model"/></td>
  <td class=xl26 width=40 style='width:40pt;border-bottom:2.0pt double black;'><bean:message key="label.reports.freqrequest2.heightabovesea"/></td>
  <td class=xl25 width=40 style='width:40pt;border-bottom:2.0pt double black;'><bean:message key="label.reports.freqrequest2.antdiam"/></td>
  <td class=xl25 width=80 style='width:80pt;border-bottom:2.0pt double black;'><bean:message key="label.reports.freqrequest2.docaddress"/></td>
 </tr>
<% int number = 1; %>
 <logic:iterate id="reportLine" name="reportList" type="com.hps.july.basestation.valueobject.ReportFrequencyRequestValue">
 <logic:present name="reportLine">
 <tr height=19 style='height:14.25pt'>
  <td height=57 class=xl27 width=40 style='width:80pt;' x:num><%= number %>&nbsp;</td>
  <td class=xl27 width=40 style='width:80pt;'><july:stringwrite name="reportLine" property="linktogosnet_lat1"/></td>
  <td class=xl27 width=40 style='width:80pt;'><july:stringwrite name="reportLine" property="linktogosnet_lon1"/></td>
  <td class=xl27 width=40 style='width:80pt;' x:num><july:stringwrite name="reportLine" property="gsmid1Frm"/></td>
  <td class=xl27 width=80 style='mso-width-source:userset;width:80pt;'><july:stringwrite name="reportLine" property="name1"/></td>
  <td class=xl27 width=80 style='mso-width-source:userset;width:80pt;'><july:stringwrite name="reportLine" property="address1"/></td>
  <td class=xl27 width=40 style='width:80pt;'><july:stringwrite name="reportLine" property="height_aFrm"/></td>
  <td class=xl27 width=40 style='width:80pt;'><july:stringwrite name="reportLine" property="powerFrm"/></td>
  <td class=xl27 width=40 style='width:80pt;'><july:stringwrite name="reportLine" property="azimuth_aFrm"/></td>
  <td class=xl27 width=40 style='width:80pt;'><july:stringwrite name="reportLine" property="dnangleh_a"/></td>
  <td class=xl27 width=40 style='width:80pt;'>&nbsp;</td>
  <td class=xl27 width=40 style='width:80pt;'><july:stringwrite name="reportLine" property="dnanglew_a"/></td>
  <td class=xl27 width=40 style='width:80pt;'><july:stringwrite name="reportLine" property="amplifkoeff_a"/></td>
  <td class=xl27 width=40 style='width:80pt;'>&nbsp;</td>
  <td class=xl27 width=40 style='width:80pt;'>1&nbsp;</td>
  <td class=xl27 width=40 style='width:80pt;'><july:stringwrite name="reportLine" property="frequency_bFrm"/></td>
  <td class=xl27 width=40 style='width:80pt;'>1&nbsp;</td>
  <td class=xl27 width=40 style='width:80pt;'><july:stringwrite name="reportLine" property="frequency_aFrm"/></td>
  <td class=xl27 width=40 style='width:80pt;'>V&nbsp;</td>
  <td class=xl27 width=40 style='width:80pt;'><july:stringwrite name="reportLine" property="radiationclass_a"/></td>
  <td class=xl27 width=40 style='width:80pt;'><july:stringwrite name="reportLine" property="model"/></td>
  <td class=xl27 width=40 style='width:80pt;'>&nbsp;</td>
  <td class=xl27 width=40 style='width:80pt;'><july:stringwrite name="reportLine" property="antdiam_a"/></td>
  <td class=xl27 width=80 style='width:80pt;'><july:stringwrite name="reportLine" property="docaddress_a"/></td>
 </tr>
<% number++; %>
 <tr height=19 style='height:14.25pt'>
  <td height=57 class=xl27 width=40 style='height:42.75pt;border-top:none;width:40pt;border-bottom:2.0pt double black;' x:num><%= number %></td>
  <td class=xl27 width=40 style='border-top:none;width:40pt;border-bottom:2.0pt double black;'><july:stringwrite name="reportLine" property="linktogosnet_lat2"/></td>
  <td class=xl27 width=40 style='border-top:none;width:40pt;border-bottom:2.0pt double black;'><july:stringwrite name="reportLine" property="linktogosnet_lon2"/></td>
  <td class=xl27 width=40 style='border-top:none;width:40pt;border-bottom:2.0pt double black;' x:num><july:stringwrite name="reportLine" property="gsmid2Frm"/></td>
  <td class=xl27 width=80 style='mso-width-source:userset;width:80pt;border-bottom:2.0pt double black;'><july:stringwrite name="reportLine" property="name2"/></td>
  <td class=xl27 width=80 style='mso-width-source:userset;width:80pt;border-bottom:2.0pt double black;'><july:stringwrite name="reportLine" property="address2"/></td>
  <td class=xl27 width=40 style='border-top:none;width:40pt;border-bottom:2.0pt double black;'><july:stringwrite name="reportLine" property="height_bFrm"/></td>
  <td class=xl27 width=40 style='border-top:none;width:40pt;border-bottom:2.0pt double black;'><july:stringwrite name="reportLine" property="powerFrm"/></td>
  <td class=xl27 width=40 style='border-top:none;width:40pt;border-bottom:2.0pt double black;'><july:stringwrite name="reportLine" property="azimuth_bFrm"/></td>
  <td class=xl27 width=40 style='border-top:none;width:40pt;border-bottom:2.0pt double black;'><july:stringwrite name="reportLine" property="dnangleh_b"/></td>
  <td class=xl27 width=40 style='border-top:none;width:40pt;border-bottom:2.0pt double black;'>&nbsp;</td>
  <td class=xl27 width=40 style='border-top:none;width:40pt;border-bottom:2.0pt double black;'><july:stringwrite name="reportLine" property="dnanglew_b"/></td>
  <td class=xl27 width=40 style='border-top:none;width:40pt;border-bottom:2.0pt double black;'><july:stringwrite name="reportLine" property="amplifkoeff_b"/></td>
  <td class=xl27 width=40 style='border-top:none;width:40pt;border-bottom:2.0pt double black;'>&nbsp;</td>
  <td class=xl27 width=40 style='border-top:none;width:40pt;border-bottom:2.0pt double black;'>1&nbsp;</td>
  <td class=xl27 width=40 style='border-top:none;width:40pt;border-bottom:2.0pt double black;'><july:stringwrite name="reportLine" property="frequency_aFrm"/></td>
  <td class=xl27 width=40 style='border-top:none;width:40pt;border-bottom:2.0pt double black;'>1&nbsp;</td>
  <td class=xl27 width=40 style='border-top:none;width:40pt;border-bottom:2.0pt double black;'><july:stringwrite name="reportLine" property="frequency_bFrm"/></td>
  <td class=xl27 width=40 style='border-top:none;width:40pt;border-bottom:2.0pt double black;'>V&nbsp;</td>
  <td class=xl27 width=40 style='border-top:none;width:40pt;border-bottom:2.0pt double black;'><july:stringwrite name="reportLine" property="radiationclass_b"/></td>
  <td class=xl27 width=40 style='border-top:none;width:40pt;border-bottom:2.0pt double black;'><july:stringwrite name="reportLine" property="model"/></td>
  <td class=xl27 width=40 style='border-top:none;width:40pt;border-bottom:2.0pt double black;'>&nbsp;</td>
  <td class=xl27 width=40 style='border-top:none;width:40pt;border-bottom:2.0pt double black;'><july:stringwrite name="reportLine" property="antdiam_b"/></td>
  <td class=xl27 width=80 style='width:80pt;border-bottom:2.0pt double black;'><july:stringwrite name="reportLine" property="docaddress_b"/></td>
 </tr>
 <%
	number++;
 %>
</logic:present>
</logic:iterate>
 <tr height=18 style='height:13.5pt'>
  <td height=18 colspan=27 style='height:13.5pt;mso-ignore:colspan'></td>
 </tr>
 <![if supportMisalignedColumns]>
 <tr height=0 style='display:none'>
  <td width=40 style='width:40pt'></td>
  <td width=40 style='width:40pt'></td>
  <td width=40 style='width:40pt'></td>
  <td width=40 style='width:40pt'></td>
  <td width=40 style='width:40pt'></td>
  <td width=40 style='width:40pt'></td>
  <td width=40 style='width:40pt'></td>
  <td width=40 style='width:40pt'></td>
  <td width=40 style='width:40pt'></td>
  <td width=40 style='width:40pt'></td>
  <td width=40 style='width:40pt'></td>
  <td width=40 style='width:40pt'></td>
  <td width=40 style='width:40pt'></td>
  <td width=40 style='width:40pt'></td>
  <td width=40 style='width:40pt'></td>
  <td width=40 style='width:40pt'></td>
  <td width=40 style='width:40pt'></td>
  <td width=40 style='width:40pt'></td>
  <td width=40 style='width:40pt'></td>
  <td width=40 style='width:40pt'></td>
  <td width=40 style='width:40pt'></td>
  <td width=40 style='width:40pt'></td>
  <td width=40 style='width:40pt'></td>
  <td width=40 style='width:40pt'></td>
  <td width=40 style='width:40pt'></td>
  <td width=40 style='width:40pt'></td>
  <td width=40 style='width:40pt'></td>
 </tr>
 <![endif]>
</table>

</body>

</html>
