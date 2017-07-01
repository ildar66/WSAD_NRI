<%@ page language = "java" %>
<%@ page import="java.util.*,java.math.*,java.text.*,com.hps.july.inventory.formbean.*,org.apache.struts.util.*" %>
<%@ page import="com.hps.july.report.word.*" %>
<%
	// чтобы имя файла было уникальным
	String randIntStr = new Long(Math.round(Math.random()*1000000000)).toString();
	String dateTimeStr = new Long((new Date().getTime())).toString();
	String randStr = randIntStr + dateTimeStr;
	System.out.println("# randStr = " + randStr);
%>
<%@ page contentType = "application/vnd.ms-excel;name=report<%=randStr%>.xls;charset=windows-1251" %>

<%--
<html xmlns:v="urn:schemas-microsoft-com:vml"
xmlns:o="urn:schemas-microsoft-com:office:office"
xmlns:x="urn:schemas-microsoft-com:office:excel"
xmlns="http://www.w3.org/TR/REC-html40">
--%>
<html xmlns:o="urn:schemas-microsoft-com:office:office"
xmlns:x="urn:schemas-microsoft-com:office:excel"
xmlns="http://www.w3.org/TR/REC-html40">
<head>

<meta http-equiv=Content-Type content="application/vnd.ms-excel;name=report<%=randStr%>.xls;charset=windows-1251">
<meta name=ProgId content="Excel.Sheet">
<meta name=Generator content="Microsoft Excel 11">

<style>
<!--table
	{mso-displayed-decimal-separator:"\,";
	mso-displayed-thousand-separator:" ";}
@page
	{margin:.62in .2in .41in .35in;
	mso-header-margin:.17in;
	mso-footer-margin:0in;
	mso-page-orientation:landscape;}
.font5
	{color:windowtext;
	font-size:12.0pt;
	font-weight:400;
	font-style:normal;
	text-decoration:none;
	font-family:"Times New Roman", serif;
	mso-font-charset:204;}
.font6
	{color:windowtext;
	font-size:12.0pt;
	font-weight:700;
	font-style:normal;
	text-decoration:none;
	font-family:"Times New Roman", serif;
	mso-font-charset:204;}
.font11
	{color:black;
	font-size:10.0pt;
	font-weight:400;
	font-style:normal;
	text-decoration:none;
	font-family:"Times New Roman", serif;
	mso-font-charset:204;}
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
	padding:0px;
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
	text-align:center;}
.xl25
	{mso-style-parent:style0;
	font-size:14.0pt;
	font-weight:700;
	font-family:"Times New Roman", serif;
	mso-font-charset:204;
	text-align:center;}
.xl26
	{mso-style-parent:style0;
	font-size:14.0pt;
	font-weight:700;
	font-family:"Times New Roman", serif;
	mso-font-charset:204;
	text-align:left;}
.xl27
	{mso-style-parent:style0;
	font-size:12.0pt;
	font-weight:700;
	font-family:"Times New Roman", serif;
	mso-font-charset:204;
	text-align:center;}
.xl28
	{mso-style-parent:style0;
	color:black;
	font-size:12.0pt;
	font-weight:700;
	font-family:"Times New Roman", serif;
	mso-font-charset:204;
	text-align:center;}
.xl29
	{mso-style-parent:style0;
	color:black;
	font-size:8.0pt;
	font-weight:700;
	font-family:"Times New Roman", serif;
	mso-font-charset:204;
	text-align:center;}
.xl30
	{mso-style-parent:style0;
	font-size:12.0pt;
	font-family:"Times New Roman", serif;
	mso-font-charset:204;}
.xl31
	{mso-style-parent:style0;
	color:black;
	font-family:"Times New Roman", serif;
	mso-font-charset:204;}
.xl32
	{mso-style-parent:style0;
	color:black;
	font-weight:700;
	font-family:"Times New Roman", serif;
	mso-font-charset:204;}
.xl33
	{mso-style-parent:style0;
	font-family:"Times New Roman", serif;
	mso-font-charset:204;
	text-align:center;
	border:.5pt solid windowtext;
	white-space:normal;}
.xl34
	{mso-style-parent:style0;
	font-family:"Times New Roman", serif;
	mso-font-charset:204;
	border:.5pt solid windowtext;
	white-space:normal;}
.xl35
	{mso-style-parent:style0;
	border:.5pt solid windowtext;}
.xl36
	{mso-style-parent:style0;
	text-align:center;}
.xl37
	{mso-style-parent:style0;}
.xl38
	{mso-style-parent:style0;
	vertical-align:top;}
.xl39
	{mso-style-parent:style0;
	font-weight:700;
	font-family:"Times New Roman", serif;
	mso-font-charset:204;
	text-align:center;
	vertical-align:middle;
	border:.5pt solid windowtext;
	background:#CCFFCC;
	mso-pattern:auto none;
	white-space:normal;}
.xl40
	{mso-style-parent:style0;
	font-weight:700;
	font-family:"Times New Roman", serif;
	mso-font-charset:204;
	text-align:center;
	vertical-align:middle;
	border:.5pt solid windowtext;
	background:#CCFFCC;
	mso-pattern:auto none;}
.xl41
	{mso-style-parent:style0;
	vertical-align:middle;}
.xl42
	{mso-style-parent:style0;
	text-align:center;
	border:.5pt solid windowtext;}
.xl43
	{mso-style-parent:style0;
	font-family:"Times New Roman", serif;
	mso-font-charset:204;
	mso-number-format:"\@";
	text-align:center;
	border:.5pt solid windowtext;
	white-space:normal;}
.xl44
	{mso-style-parent:style0;
	text-decoration:underline;
	text-underline-style:single;
	text-align:left;}
.xl45
	{mso-style-parent:style0;
	text-align:left;}
.xl46
	{mso-style-parent:style0;
	font-weight:700;
	text-align:left;
	vertical-align:middle;
	border-top:none;
	border-right:none;
	border-bottom:.5pt solid windowtext;
	border-left:none;}
.xl47
	{mso-style-parent:style0;
	text-align:left;
	vertical-align:middle;
	border-top:none;
	border-right:none;
	border-bottom:.5pt solid windowtext;
	border-left:none;}
-->
</style>

<%--
<![endif]><!--[if gte mso 9]><xml>
 <x:WorksheetOptions>
  <x:FitToPage/>
  <x:FitToPage/>
  <x:Print>
   <x:ValidPrinterInfo/>
   <x:PaperSizeIndex>9</x:PaperSizeIndex>
   <x:Scale>94</x:Scale>
   <x:HorizontalResolution>600</x:HorizontalResolution>
   <x:VerticalResolution>600</x:VerticalResolution>
   <x:NumberofCopies>0</x:NumberofCopies>
  </x:Print>
  <x:Selected/>
  <x:DoNotDisplayGridlines/>
  <x:ProtectContents>False</x:ProtectContents>
  <x:ProtectObjects>False</x:ProtectObjects>
  <x:ProtectScenarios>False</x:ProtectScenarios>
 </x:WorksheetOptions>
</xml><![endif]-->
--%>

<!--[if gte mso 9]><xml>
 <x:ExcelWorkbook>
  <x:ExcelWorksheets>
   <x:ExcelWorksheet>
    <x:Name>excelAssembReport</x:Name>
    <x:WorksheetOptions>
     <x:FitToPage/>
     <x:FitToPage/>
     <x:Print>
      <x:ValidPrinterInfo/>
      <x:PaperSizeIndex>9</x:PaperSizeIndex>
      <x:Scale>94</x:Scale>
      <x:HorizontalResolution>600</x:HorizontalResolution>
      <x:VerticalResolution>600</x:VerticalResolution>
      <x:NumberofCopies>0</x:NumberofCopies>
     </x:Print>
     <x:Selected/>
     <x:DoNotDisplayGridlines/>
     <x:Panes>
      <x:Pane>
       <x:Number>3</x:Number>
       <x:ActiveRow>1</x:ActiveRow>
       <x:ActiveCol>2</x:ActiveCol>
      </x:Pane>
     </x:Panes>
     <x:ProtectContents>False</x:ProtectContents>
     <x:ProtectObjects>False</x:ProtectObjects>
     <x:ProtectScenarios>False</x:ProtectScenarios>
    </x:WorksheetOptions>
   </x:ExcelWorksheet>
  </x:ExcelWorksheets>
  <x:WindowHeight>12960</x:WindowHeight>
  <x:WindowWidth>19200</x:WindowWidth>
  <x:WindowTopX>0</x:WindowTopX>
  <x:WindowTopY>1365</x:WindowTopY>
  <x:ProtectStructure>False</x:ProtectStructure>
  <x:ProtectWindows>False</x:ProtectWindows>
 </x:ExcelWorkbook>
</xml><![endif]-->

<meta http-equiv="Content-Disposition" content="attachment;filename=report<%=randStr%>.xls">

</head>

<body link=blue vlink=purple>
	
<%
	String ass = request.getParameter("ass");
	boolean isAss = "true".equals(ass);
%>
	
<%-- Это макет от заказчика --%>

<%-- <july:editform action="/ProcessFault.do"> --%>
<%-- <bean:define id="docCode" name="FaultForm" property="document" scope="session" type="java.lang.Integer"/> --%>

<%
	FaultForm frm = (FaultForm)request.getSession().getAttribute("FaultForm");
	String blankindexString = frm.getBlankindex().getString();
	String blankNum = frm.getBlanknumber();
	// blankdate.string
	String blankDateString = frm.getBlankdate().getString();
	String bDay = blankDateString.substring(0, 2);
	String bMn = blankDateString.substring(3, 5);
	String bYear = blankDateString.substring(6);
	// workername
	String workername = frm.getWorkername();
	// position.string
	String positionString = frm.getPosition().getString();
	// positionid
	String positionid = frm.getPositionid();
	// positionname
	String positionname = frm.getPositionname();
	// complectname
	String complectname = frm.getComplectname();
	String fullcomplectname = frm.getEqStorageName();
	
	// mres.string
	String mresString = frm.getMres().getString();
	// mresmodel
	String mresmodel = frm.getMresmodel();
	// mresname
	String mresname = frm.getMresname();
	// msn
	String msn = frm.getMsn();
	// mms
	String mms = frm.getMms();
	if (mms==null) {mms = "";}
	// comments
	String comments = frm.getComments();
	String mNfsMresCodes = frm.getNfsMresCode();
	
	// rres.string
	String rresString = frm.getRres().getString();
	// rresmodel
	String rresmodel = frm.getRresmodel();
	// rresname
	String rresname = frm.getRresname();
	// rsn
	String rsn = frm.getRsn();
	// rms
	String rms = frm.getRms();
	if (rms==null) {rms = "";}
	String mNfsResCodes = frm.getNfsResCode();
 
%>

<table x:str border=0 cellpadding=0 cellspacing=0 width=1077 style='border-collapse:
 collapse;table-layout:fixed;width:808pt'>
 <col width=27 style='mso-width-source:userset;mso-width-alt:987;width:20pt'>
 <col width=109 style='mso-width-source:userset;mso-width-alt:3986;width:82pt'>
 <col width=70 style='mso-width-source:userset;mso-width-alt:2560;width:53pt'>
 <col width=139 style='mso-width-source:userset;mso-width-alt:5083;width:104pt'>
 <col width=267 style='mso-width-source:userset;mso-width-alt:9764;width:200pt'>
 <col width=37 style='mso-width-source:userset;mso-width-alt:1353;width:28pt'>
 <col width=42 style='mso-width-source:userset;mso-width-alt:1536;width:32pt'>
 <col width=152 style='mso-width-source:userset;mso-width-alt:5558;width:114pt'>
 <col width=123 style='mso-width-source:userset;mso-width-alt:4498;width:92pt'>
 <col width=111 style='mso-width-source:userset;mso-width-alt:4059;width:83pt'>
 <tr height=25 style='height:18.75pt'>
  <td height=25 width=27 style='height:18.75pt;width:20pt'></td>
  <td width=109 style='width:82pt'></td>
  <td width=70 style='width:53pt'></td>
  <td width=139 style='width:104pt'></td>
  <td class=xl25 width=267 style='width:200pt'>АКТ</td>
  <td width=37 style='width:28pt'></td>
  <td width=42 style='width:32pt'></td>
  <td width=152 style='width:114pt'></td>
  <td width=123 style='width:92pt' align=left valign=top>
  <%--
  <!--[if gte vml 1]><v:shapetype
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
  </v:shapetype><v:shape id="_x0000_s1034" type="#_x0000_t75" style='position:absolute;
   margin-left:66pt;margin-top:5.25pt;width:97.5pt;height:78.75pt;z-index:1'>
   <v:imagedata src="Акт%20монтажа%20ТМЦ.files/image001.wmz" o:title="" gain="86232f"/>
   <x:ClientData ObjectType="Pict">
    <x:CF>PictOld</x:CF>
   </x:ClientData>
  </v:shape><![if gte mso 9]><o:OLEObject Type="Embed" ProgID="Word.Picture.8"
   ShapeID="_x0000_s1034" DrawAspect="Content" ObjectID="MBD0005185B">
  </o:OLEObject>
 <![endif]><![endif]-->
 --%>
 <%--
 <![if !vml]>
 <span style='mso-ignore:vglayout;position:
  absolute;z-index:1;margin-left:88px;margin-top:7px;width:130px;height:105px'><img
  width=130 height=105 src="/images/beeline.gif" v:shapes="_x0000_s1034"></span><![endif]>
 --%> 
  <span
  style='mso-ignore:vglayout2'>
  <table cellpadding=0 cellspacing=0>
   <tr>
    <td height=25 width=123 style='height:18.75pt;width:92pt'></td>
   </tr>
  </table>
  </span></td>
  <td width=111 style='width:83pt'></td>
 </tr>
 <tr height=25 style='height:18.75pt'>
  <td height=25 style='height:18.75pt'></td>
  <td colspan=2 class=xl24 style='mso-ignore:colspan'></td>
  <td></td>
  <td align=left valign=top><!--[if gte vml 1]><v:shapetype id="_x0000_t202"
   coordsize="21600,21600" o:spt="202" path="m,l,21600r21600,l21600,xe">
   <v:stroke joinstyle="miter"/>
   <v:path gradientshapeok="t" o:connecttype="rect"/>
  </v:shapetype><v:shape id="_x0000_s1033" type="#_x0000_t202" style='position:absolute;
   margin-left:168.75pt;margin-top:2.25pt;width:102pt;height:16.5pt;z-index:2;
   mso-wrap-style:tight' fillcolor="#eaeaea" stroked="f">
   <v:textbox style='mso-next-textbox:#_x0000_s1033' inset="0,0,0,0"/>
  </v:shape><![endif]--><![if !vml]><span style='mso-ignore:vglayout;
  position:absolute;z-index:2;margin-left:225px;margin-top:3px;width:136px;
  height:22px'>
  <table cellpadding=0 cellspacing=0>
   <tr>
    <td width=136 height=22 align=left valign=top bgcolor="#EAEAEA"
    style='vertical-align:top;background:#EAEAEA'><![endif]>
    <div v:shape="_x0000_s1033" style='padding:0pt 0pt 0pt 0pt;text-align:left'
    class=shape><font class="font5">&nbsp;</font></div>
    <![if !vml]></td>
   </tr>
  </table>
  </span><![endif]><span style='mso-ignore:vglayout2'>
  <table cellpadding=0 cellspacing=0>
   <tr>
    <td height=25 class=xl25 width=267 style='height:18.75pt;width:200pt'>
    <%
    if (isAss) {
    %>
    монтажа
    <% } else { %>
    демонтажа
    <% } %>
    <span
    style='mso-spacerun:yes'>   </span>ТМЦ<span style='mso-spacerun:yes'> 
    </span>№ 
    
    <%-- <%=blankindexString%> --%>
    
    <%=blankNum%> 
    
    <%-- <july:string property="blankindex.string" size="15" insertable="true" updatable="true" /> [<%=documentId%>]--%>
    </td>
   </tr>
  </table>
  </span></td>
  <td colspan=5 style='mso-ignore:colspan'></td>
 </tr>
 <tr height=17 style='height:12.75pt'>
  <td height=17 colspan=10 style='height:12.75pt;mso-ignore:colspan'></td>
 </tr>
 <tr height=25 style='height:18.75pt'>
  <td height=25 style='height:18.75pt'></td>
  <td colspan=3 class=xl26 style='mso-ignore:colspan'></td>
  <td align=left valign=top><!--[if gte vml 1]><v:shape id="_x0000_s1032"
   type="#_x0000_t202" style='position:absolute;margin-left:38.25pt;
   margin-top:1.5pt;width:322.5pt;height:18pt;z-index:3' fillcolor="#eaeaea"
   stroked="f">
   <v:textbox inset="0,0,0,0"/>
  </v:shape><![endif]--><![if !vml]><span style='mso-ignore:vglayout;
  position:absolute;z-index:3;margin-left:51px;margin-top:2px;width:430px;
  height:24px'>
  <table cellpadding=0 cellspacing=0>
   <tr>
    <td width=430 height=24 align=left valign=top bgcolor="#EAEAEA"
    style='vertical-align:top;background:#EAEAEA'><![endif]>
    <div v:shape="_x0000_s1032" style='padding:0pt 0pt 0pt 0pt;text-align:left'
    class=shape><font class="font6">&nbsp;</font></div>
    <![if !vml]></td>
   </tr>
  </table>
  </span><![endif]><span style='mso-ignore:vglayout2'>
  <table cellpadding=0 cellspacing=0>
   <tr>
    <%-- <td align="center" height=25 width=139 style='height:18.75pt;width:104pt'>БС № --%>
    <td align="center"><%-- БС № --%>
    	<%=fullcomplectname%>
    	<%--
		<%=positionString%>
		<%=positionid%>
		<%=positionname%>
		<%=complectname%>
		--%>
    </td>
   </tr>
  </table>
  </span></td>
  <td colspan=5 style='mso-ignore:colspan'></td>
 </tr>
 <tr height=21 style='height:15.75pt'>
  <td height=21 style='height:15.75pt'></td>
  <td colspan=2 class=xl27 style='mso-ignore:colspan'></td>
  <td></td>
  <td class=xl29></td>
  <td colspan=5 style='mso-ignore:colspan'></td>
 </tr>
 <tr height=32 style='mso-height-source:userset;height:24.0pt'>
  <td height=32 style='height:24.0pt'></td>
  <td colspan=2 class=xl28 style='mso-ignore:colspan'></td>
  <td></td>
  <td height=32 width=267 style='height:24.0pt;width:200pt'>
  &nbsp;&nbsp;&nbsp;&nbsp;
  <%=bDay%>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <%=bMn%> 
  <%--
  <!--[if gte vml 1]><v:shape
   id="_x0000_s1031" type="#_x0000_t202" style='position:absolute;
   margin-left:60.75pt;margin-top:1.5pt;width:118.5pt;height:21pt;z-index:4;
   mso-wrap-style:tight' fillcolor="#eaeaea" stroked="f">
   <v:textbox inset="0,0,0,0"/>
  </v:shape><v:shape id="_x0000_s1030" type="#_x0000_t202" style='position:absolute;
   margin-left:.75pt;margin-top:1.5pt;width:48pt;height:21pt;z-index:6;
   mso-wrap-style:tight' fillcolor="#eaeaea" stroked="f">
   <v:textbox inset="0,0,0,0"/>
  </v:shape><![endif]--><![if !vml]><span style='mso-ignore:vglayout'>
  <table cellpadding=0 cellspacing=0>
   <tr>
    <td width=1 height=2></td>
    <td width=64></td>
    <td width=16></td>
    <td width=158></td>
    <td width=28></td>
   </tr>
   <tr>
    <td height=28></td>
    <td width=64 height=28 align=left valign=top bgcolor="#EAEAEA"
    style='vertical-align:top;background:#EAEAEA'><![endif]>
    <div v:shape="_x0000_s1030" style='padding:0pt 0pt 0pt 0pt;text-align:left'
    class=shape><font class="font5">&nbsp;</font></div>
    <![if !vml]></td>
    <td></td>
    <td width=158 height=28 align=left valign=top bgcolor="#EAEAEA"
    style='vertical-align:top;background:#EAEAEA'><![endif]>
    <div v:shape="_x0000_s1031" style='padding:0pt 0pt 0pt 0pt;text-align:left'
    class=shape><font class="font5">&nbsp;</font></div>
    <![if !vml]></td>
   </tr>
   <tr>
    <td height=2></td>
   </tr>
  </table>
  </span><![endif]><!--[if !mso & vml]><span style='width:200.25pt;height:24.0pt'></span><![endif]-->
  --%>
  </td>
  <td class=xl28>
  <%--<font class="font11">.</font>--%>
  </td>
  <td class=xl28><%=bYear%>г.
  <%--<span style='mso-spacerun:yes'> </span>
  --%></td>
  <td colspan=3 style='mso-ignore:colspan'></td>
 </tr>
 <tr height=32 style='mso-height-source:userset;height:24.0pt'>
  <td height=32 colspan=4 style='height:24.0pt;mso-ignore:colspan'></td>
  <td class=xl38><sup><span style='mso-spacerun:yes'>      </span>число<span
  style='mso-spacerun:yes'>                                  </span>месяц</sup></td>
  <td colspan=2 style='mso-ignore:colspan'></td>
  <td class=xl37></td>
  <td colspan=2 style='mso-ignore:colspan'></td>
 </tr>
 <tr height=17 style='height:12.75pt'>
  <td height=17 colspan=10 style='height:12.75pt;mso-ignore:colspan'></td>
 </tr>
 <tr height=25 style='mso-height-source:userset;height:18.75pt'>
  <td height=25 style='height:18.75pt'></td>
  <td colspan=4 class=xl46>Произведен 
	<%	
    if (isAss) {
    %>
  монтаж
  	<% } else { %>
  демонтаж
  	<% }%>
  <span style='mso-spacerun:yes'> 
  </span>оборудования и комплектующих:</td>
  <td colspan=5 style='mso-ignore:colspan'></td>
 </tr>
 
 <tr class=xl41 height=34 style='height:25.5pt'>
  <td height=34 class=xl39 width=27 style='height:25.5pt;width:20pt'>№<br>
    п.п.</td>
  <td class=xl40 style='border-top:none;border-left:none'>Код НФС</td>
  <td class=xl40 style='border-top:none;border-left:none'>Код NRI</td>
  <td class=xl39 width=139 style='border-top:none;border-left:none;width:104pt'>Код
  товара (маркировка)</td>
  <td class=xl40 style='border-top:none;border-left:none'>Оборудование
  (наименование, тип)</td>
  <td class=xl39 width=37 style='border-left:none;width:28pt'>Кол-во</td>
  <td class=xl39 width=42 style='border-left:none;width:32pt'>Ед. изм.</td>
  <td class=xl40 style='border-left:none'>Серийный номер</td>
  <td class=xl39 width=123 style='border-left:none;width:92pt'>Инвентарный
  номер</td>
  <td class=xl39 width=111 style='border-left:none;width:83pt'>Примечание</td>
 </tr>
	<%	
    if (isAss) {
    %>
 <tr height=17 style='height:12.75pt'>
  <td height=17 class=xl42 style='height:12.75pt;border-top:none'>1&nbsp;</td>
  <td class=xl33 width=109 style='border-top:none;border-left:none;width:82pt'><%=mNfsMresCodes%>&nbsp;</td>
  <td class=xl33 width=70 style='border-top:none;border-left:none;width:53pt'><%=rresString%>&nbsp;</td>
  <td class=xl33 width=139 style='border-top:none;border-left:none;width:104pt'><%=rresmodel%>&nbsp;</td>
  <td class=xl34 width=267 style='border-top:none;border-left:none;width:200pt'><%=rresname%>&nbsp;</td>
  <td class=xl33 width=37 style='border-top:none;border-left:none;width:28pt'>1&nbsp;</td>
  <td class=xl33 width=42 style='border-top:none;border-left:none;width:32pt'>шт.&nbsp;</td>
  <td class=xl43 width=152 style='border-top:none;border-left:none;width:114pt'><%=rsn%>&nbsp;</td>
  <td class=xl43 width=123 style='border-top:none;border-left:none;width:92pt'><%=rms%>&nbsp;</td>
  <td class=xl33 width=111 style='border-top:none;border-left:none;width:83pt'>&nbsp;</td>
 </tr>
	<% } else { %>
 <tr height=17 style='height:12.75pt'>
  <td height=17 class=xl42 style='height:12.75pt;border-top:none'>1&nbsp;</td>
  <td class=xl33 width=109 style='border-top:none;border-left:none;width:82pt'><%=mNfsResCodes%>&nbsp;</td>
  <td class=xl33 width=70 style='border-top:none;border-left:none;width:53pt'><%=mresString%>&nbsp;</td>
  <td class=xl33 width=139 style='border-top:none;border-left:none;width:104pt'><%=mresmodel%>&nbsp;</td>
  <td class=xl34 width=267 style='border-top:none;border-left:none;width:200pt'><%=mresname%>&nbsp;</td>
  <td class=xl33 width=37 style='border-top:none;border-left:none;width:28pt'>1&nbsp;</td>
  <td class=xl33 width=42 style='border-top:none;border-left:none;width:32pt'>шт.&nbsp;</td>
  <td class=xl43 width=152 style='border-top:none;border-left:none;width:114pt'><%=msn%>&nbsp;</td>
  <td class=xl43 width=123 style='border-top:none;border-left:none;width:92pt'><%=mms%>&nbsp;</td>
  <td class=xl33 width=111 style='border-top:none;border-left:none;width:83pt'><%=comments%>&nbsp;</td>
 </tr>
	<% } %>
 <tr height=17 style='mso-height-source:userset;height:12.75pt'>
  <td height=17 style='height:12.75pt'></td>
  <td colspan=2 class=xl31 style='mso-ignore:colspan'></td>
  <td></td>
  <td class=xl36><sup></sup></td>
  <td colspan=2 style='mso-ignore:colspan'></td>
  <td class=xl36><sup></sup></td>
  <td colspan=2 style='mso-ignore:colspan'></td>
 </tr>
 <tr height=28 style='mso-height-source:userset;height:21.0pt'>
  <td height=28 style='height:21.0pt'></td>
  <td colspan=2 class=xl30 style='mso-ignore:colspan'></td>
  	<%	
  	String assDemProd = "";
    if (isAss) {
  assDemProd = "Монтаж произвел:"; 
   } else { 
  assDemProd = "Демонтаж произвел:";
  } %>
  <td colspan=2 class=xl44
  x:str="<%=assDemProd%>                                                           ">
  <%=assDemProd%><span
  style='mso-spacerun:yes'>                                                           </span></td>
  <td colspan=5 style='mso-ignore:colspan'><%=workername%></td>
 </tr>
 <tr height=15 style='mso-height-source:userset;height:11.25pt'>
  <td height=15 colspan=4 style='height:11.25pt;mso-ignore:colspan'></td>
  <td class=xl36><sup>подпись</sup></td>
  <td colspan=2 style='mso-ignore:colspan'></td>
  <td class=xl36><sup>фамилия инициалы</sup></td>
  <td colspan=2 style='mso-ignore:colspan'></td>
 </tr>
 <tr height=22 style='mso-height-source:userset;height:16.5pt'>
  <td height=22 colspan=4 style='height:16.5pt;mso-ignore:colspan'></td>
  <td class=xl36><sup></sup></td>
  <td colspan=2 style='mso-ignore:colspan'></td>
  <td class=xl36><sup></sup></td>
  <td colspan=2 style='mso-ignore:colspan'></td>
 </tr>
 <tr height=27 style='mso-height-source:userset;height:20.25pt'>
  <td height=27 style='height:20.25pt'></td>
  <td colspan=2 class=xl32 style='mso-ignore:colspan'></td>
   	<%	
   	String toFromStore = "";
    if (isAss) {
  toFromStore = "Выдал со склада:";
  	 } else { 
  toFromStore = "Принял на склад:";
  	 } %>
  <td colspan=2 class=xl44
  x:str="<%=toFromStore%>                                                                ">
  <span
  style='mso-spacerun:yes'><%=toFromStore%>                                                                </span></td>
  <td colspan=5 style='mso-ignore:colspan'></td>
 </tr>
 <tr height=17 style='mso-height-source:userset;height:12.75pt'>
  <td height=17 style='height:12.75pt'></td>
  <td colspan=2 class=xl31 style='mso-ignore:colspan'></td>
  <td></td>
  <td class=xl36><sup>подпись</sup></td>
  <td colspan=2 style='mso-ignore:colspan'></td>
  <td class=xl36><sup>фамилия инициалы</sup></td>
  <td colspan=2 style='mso-ignore:colspan'></td>
 </tr>
 <![if supportMisalignedColumns]>
 <tr height=0 style='display:none'>
  <td width=27 style='width:20pt'></td>
  <td width=109 style='width:82pt'></td>
  <td width=70 style='width:53pt'></td>
  <td width=139 style='width:104pt'></td>
  <td width=267 style='width:200pt'></td>
  <td width=37 style='width:28pt'></td>
  <td width=42 style='width:32pt'></td>
  <td width=152 style='width:114pt'></td>
  <td width=123 style='width:92pt'></td>
  <td width=111 style='width:83pt'></td>
 </tr>
 <![endif]>
</table>
<%-- </july:editform> --%>
</body>

</html>

