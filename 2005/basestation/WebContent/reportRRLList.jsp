<%@ page language = "java" %>
<%@ page contentType = "application/vnd.ms-excel; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import="com.hps.july.basestation.actionbean.*"%>
<%@ page import="com.hps.july.util.*"%>

<%System.out.println("Report RRL List show jsp");%>
<% 
	String filenumber = (String)request.getAttribute("filenumber");
%>

<html xmlns:o="urn:schemas-microsoft-com:office:office" xmlns:x="urn:schemas-microsoft-com:office:excel" xmlns="http://www.w3.org/TR/REC-html40">
<head>
<title><bean:message key="label.reports.rrllist.title"/></title>
<meta http-equiv=Content-Type content="text/html; charset=windows-1251">
<meta name=ProgId content=Excel.Sheet>
<meta name=Generator content="Microsoft Excel 10">
<style id="GetReportRRLList_31212_Styles">
<!--table
	{mso-displayed-decimal-separator:"\,";
	mso-displayed-thousand-separator:" ";}
.xl1531212 {padding-top:1px;padding-right:1px;padding-left:1px;mso-ignore:padding;color:windowtext;font-size:10.0pt;font-weight:400;font-style:normal;text-decoration:none;font-family:"Arial Cyr";mso-generic-font-family:auto;mso-font-charset:204;mso-number-format:General;text-align:general;vertical-align:bottom;mso-background-source:auto;mso-pattern:auto;white-space:nowrap;}
.xl2231212 {padding-top:1px;padding-right:1px;padding-left:1px;mso-ignore:padding;color:windowtext;font-size:10.0pt;font-weight:400;font-style:normal;text-decoration:none;font-family:"Arial Narrow", sans-serif;mso-font-charset:204;mso-number-format:General;text-align:general;vertical-align:bottom;mso-background-source:auto;mso-pattern:auto;white-space:nowrap;}
.xl2331212 {padding-top:1px;padding-right:1px;padding-left:1px;mso-ignore:padding;color:windowtext;font-size:10.0pt;font-weight:400;font-style:normal;text-decoration:none;font-family:"Arial Narrow", sans-serif;mso-font-charset:204;mso-number-format:General;text-align:general;vertical-align:bottom;border-top:2.0pt double windowtext;border-right:.5pt solid windowtext;border-bottom:.5pt solid windowtext;border-left:.5pt solid windowtext;mso-background-source:auto;mso-pattern:auto;white-space:nowrap;}
.xl2431212 {padding-top:1px;padding-right:1px;padding-left:1px;mso-ignore:padding;color:windowtext;font-size:10.0pt;font-weight:400;font-style:normal;text-decoration:none;font-family:"Arial Narrow", sans-serif;mso-font-charset:204;mso-number-format:General;text-align:general;vertical-align:bottom;border-top:.5pt solid windowtext;border-right:.5pt solid windowtext;border-bottom:2.0pt double windowtext;border-left:.5pt solid windowtext;mso-background-source:auto;mso-pattern:auto;white-space:nowrap;}
.xl2531212 {padding-top:1px;padding-right:1px;padding-left:1px;mso-ignore:padding;color:windowtext;font-size:12.0pt;font-weight:700;font-style:normal;text-decoration:none;font-family:Arial, sans-serif;mso-font-charset:204;mso-number-format:General;text-align:general;vertical-align:bottom;mso-background-source:auto;mso-pattern:auto;white-space:nowrap;}
-->
</style>
</head>

<body>
<!--[if !excel]>&nbsp;&nbsp;<![endif]-->
<div id="GetReportRRLList_31212" align=center x:publishsource="Excel">

<table x:str border=0 cellpadding=0 cellspacing=0 width=773 style='border-collapse:
 collapse;table-layout:fixed;width:580pt'>
 <col width=52 style='mso-width-source:userset;mso-width-alt:1901;width:39pt'>
 <col width=79 style='mso-width-source:userset;mso-width-alt:2889;width:59pt'>
 <col width=53 style='mso-width-source:userset;mso-width-alt:1938;width:40pt'>
 <col width=83 style='mso-width-source:userset;mso-width-alt:3035;width:62pt'>
 <col width=84 style='mso-width-source:userset;mso-width-alt:3072;width:63pt'>
 <col width=96 style='mso-width-source:userset;mso-width-alt:3510;width:72pt'>
 <col width=88 style='mso-width-source:userset;mso-width-alt:3218;width:66pt'>
 <col width=82 style='mso-width-source:userset;mso-width-alt:2998;width:62pt'>
 <col width=77 style='mso-width-source:userset;mso-width-alt:2816;width:58pt'>
 <col width=79 style='mso-width-source:userset;mso-width-alt:2889;width:59pt'>
 <tr height=21 style='mso-height-source:userset;height:15.75pt'>
  <td height=21 class=xl2531212 width=52 style='height:15.75pt;width:39pt'><bean:message key="label.reports.rrllist.filenumber"/> <%=filenumber%></td>
  <td class=xl2531212 align=right width=79 style='width:59pt'></td>
  <td class=xl1531212 width=53 style='width:40pt'></td>
  <td class=xl1531212 width=83 style='width:62pt'></td>
  <td class=xl1531212 width=84 style='width:63pt'></td>
  <td class=xl1531212 width=96 style='width:72pt'></td>
  <td class=xl1531212 width=88 style='width:66pt'></td>
  <td class=xl1531212 width=82 style='width:62pt'></td>
  <td class=xl1531212 width=77 style='width:58pt'></td>
  <td class=xl1531212 width=79 style='width:59pt'></td>
 </tr>
 <tr height=18 style='height:13.5pt'>
  <td height=18 class=xl2231212 style='height:13.5pt'></td>
  <td class=xl2231212></td>
  <td class=xl2231212></td>
  <td class=xl2231212></td>
  <td class=xl2231212></td>
  <td class=xl2231212></td>
  <td class=xl2231212></td>
  <td class=xl2231212></td>
  <td class=xl2231212></td>
  <td class=xl2231212></td>
 </tr>
<logic:iterate id="reportLine" name="reportList" type="com.hps.july.basestation.valueobject.ReportRRLListValue">
<logic:present name="reportLine">
 <tr height=18 style='height:13.5pt'>
  <td rowspan=2 height=36 class=xl2331212 align=right style='border-bottom: 2.0pt double black;height:27.0pt' x:num><july:stringwrite name="reportLine" property="posAgsmid"/></td>
  <td rowspan=2 class=xl2331212 style='border-bottom:2.0pt double black'><july:stringwrite name="reportLine" property="posAname"/></td>
  <td rowspan=2 class=xl2331212 align=right style='border-bottom:2.0pt double black' x:num><july:stringwrite name="reportLine" property="posBgsmid"/></td>
  <td rowspan=2 class=xl2331212 style='border-bottom:2.0pt double black'><july:stringwrite name="reportLine" property="posBname"/></td>
  <td rowspan=2 class=xl2331212 style='border-bottom:2.0pt double black'><july:stringwrite name="reportLine" property="resource"/></td>
  <td rowspan=2 class=xl2331212 style='border-bottom:2.0pt double black' x:num><july:stringwrite name="reportLine" property="etap4n"/></td>
  <td rowspan=2 class=xl2331212 style='border-bottom:2.0pt double black' x:num><july:stringwrite name="reportLine" property="etap13n"/></td>
  <td rowspan=2 class=xl2331212 style='border-bottom:2.0pt double black' x:num><july:stringwrite name="reportLine" property="etap15n"/></td>
  <td class=xl2331212 style='border-left:none' x:num><july:stringwrite name="reportLine" property="etap16na"/></td>
  <td class=xl2331212 style='border-left:none'><july:datewrite name="reportLine" property="etap16da"/></td>
 </tr>
 <tr height=18 style='height:13.5pt'>
  <td height=18 class=xl2431212 style='height:13.5pt;border-top:none; border-left:none' x:num><july:stringwrite name="reportLine" property="etap16nb"/></td>
  <td class=xl2431212 style='border-top:none;border-left:none'><july:datewrite name="reportLine" property="etap16db"/></td>
 </tr>
 </logic:present>
</logic:iterate>
 <![if supportMisalignedColumns]>
 <tr height=0 style='display:none'>
  <td width=52 style='width:39pt'></td>
  <td width=79 style='width:59pt'></td>
  <td width=53 style='width:40pt'></td>
  <td width=83 style='width:62pt'></td>
  <td width=84 style='width:63pt'></td>
  <td width=96 style='width:72pt'></td>
  <td width=88 style='width:66pt'></td>
  <td width=82 style='width:62pt'></td>
  <td width=77 style='width:58pt'></td>
  <td width=79 style='width:59pt'></td>
 </tr>
 <![endif]>
</table>
</div>
</body>
</html>
