<%@ page language = "java" %>
<%@ page contentType = "application/vnd.ms-excel; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import="com.hps.july.util.*"%>
<%
System.out.println("report show jsp");
%>
<html xmlns:v="urn:schemas-microsoft-com:vml" xmlns:o="urn:schemas-microsoft-com:office:office" xmlns:x="urn:schemas-microsoft-com:office:excel" xmlns="http://www.w3.org/TR/REC-html40">
<head>
<meta http-equiv=Content-Type content="text/html; charset=windows-1251">
<meta name=ProgId content=Excel.Sheet>
<meta name=Generator content="Microsoft Excel 9">
<style>
<!--table
	{mso-displayed-decimal-separator:"\,";mso-displayed-thousand-separator:" ";}
@page
	{margin:.98in .79in .98in .79in;mso-header-margin:.5in;mso-footer-margin:.5in;}
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
	mso-pattern:auto;
	color:windowtext;
	font-size:10.0pt;
	font-weight:400;
	font-style:normal;
	text-decoration:none;
	font-family:"Arial Narrow";
	mso-background-source:auto;
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
	mso-background-source:auto;
	mso-generic-font-family:auto;
	mso-font-charset:204;
	mso-number-format:General;
	text-align:general;
	vertical-align:bottom;
	border:none;
	mso-pattern:auto;
	mso-protection:locked visible;
	white-space:nowrap;
	mso-rotate:0;}
.xl24
	{mso-style-parent:style0;
	font-weight:700;
	font-family:"Arial Narrow", sans-serif;
	mso-font-charset:204;
	text-align:center;
	vertical-align:middle;
	border:.5pt solid windowtext;}
.xl25
	{mso-style-parent:style0;
	text-align:left;
	vertical-align:top;
	border:.5pt solid windowtext;
	white-space:normal;
	background:#FFFF99;
}
.xl26
	{mso-style-parent:style0;
	text-align:left;
	border:.5pt solid windowtext;
	padding-left:24px;
	mso-char-indent-count:2;}
.xl27
	{mso-style-parent:style0;
	font-weight:700;
	font-family:"Arial Narrow", sans-serif;
	mso-font-charset:204;
	text-align:center;
	vertical-align:middle;
	border:.5pt solid windowtext;
	white-space:normal;}
.xl28
	{mso-style-parent:style0;
	font-weight:700;
	font-family:"Arial Narrow", sans-serif;
	mso-font-charset:204;
	text-align:left;
	vertical-align:middle;
	border:.5pt  solid windowtext;
	padding-left:24px;
	mso-char-indent-count:2;}
.xl29
	{mso-style-parent:style0;
	text-align:center;
	vertical-align:middle;
	border:.5pt solid windowtext;}
.xl30
	{mso-style-parent:style0;
	text-align:center;
	vertical-align:middle;
	border:.5pt solid windowtext;
	white-space:normal;}
.xl31
	{mso-style-parent:style0;
	font-size:12.0pt;
	font-weight:700;
	font-style:italic;
	font-family:"Arial Narrow", sans-serif;
	mso-font-charset:204;}
.xl32
	{mso-style-parent:style0;
	font-weight:700;
	font-family:"Arial Narrow", sans-serif;
	mso-font-charset:204;}
.xl47
	{mso-style-parent:style0;
	text-align:left;
	vertical-align:top;
	border:.5pt solid windowtext;
	background:#FFFF99;
	mso-pattern:auto none;
	white-space:normal;}
-->
</style>
</head>

<body link=blue vlink=purple>

<table x:str border=0 cellpadding=0 cellspacing=0 width=1120 style='border-collapse:collapse;table-layout:fixed;width:1120px'>
 <tr height=20 style='height:15.0pt'>
  <td height=20 class=xl31 colspan=3 width=384 style='height:15.0pt;mso-ignore:colspan;width:384px'><bean:message key="label.reports.haveplan.title"/></td>
  <td width=64 style='width:64px'></td>
  <td width=64 style='width:64px'></td>
  <td width=128 style='width:128px'></td>
  <td width=128 style='width:128px'></td>
  <td width=128 style='width:128px'></td>
  <td width=128 style='width:128px'></td>
  <td width=64 style='width:64px'></td>
  <td width=64 style='width:64px'></td>
  <td width=128 style='width:128px'></td>
  <td width=128 style='width:128px'></td>
  <td width=128 style='width:128px'></td>
  <td width=128 style='width:128px'></td>
  <td width=128 style='width:128px'></td>
  <td width=128 style='width:128px'></td>
 </tr>
<% String filenumber = (String)request.getAttribute("filenumber"); %>
 <tr height=21 style='height:15.75pt'>
  <td height=21 class=xl31 style='height:15.75pt'></td>
  <td class=xl32 colspan=2 style='mso-ignore:colspan'><bean:message key="label.reports.haveplan.file"/><%= filenumber %></td>
  <td colspan=12 style='mso-ignore:colspan'></td>
 </tr>
 <!--tr height=19 style='height:14.25pt'>
  <td colspan=18 height=19 class=xl28 style='height:14.25pt'><bean:message key="label.reports.haveplan.hopsname"/></td>
 </tr-->
 <tr height=19 style='height:14.25pt'>
  <td rowspan=3 height=57 class=xl24 style='height:42.75pt'><bean:message key="label.reports.haveplan.numberinfile"/></td>
  <td rowspan=3 class=xl24><bean:message key="label.reports.haveplan.position1"/></td>
  <td rowspan=3 class=xl24><bean:message key="label.reports.haveplan.address1"/></td>
  <td colspan=2 rowspan=2 class=xl27 width=128 style='width:128px'><bean:message key="label.reports.haveplan.linktogosnet1"/></td>
  <td rowspan=3 class=xl27 width=128 style='width:96pt'><bean:message key="label.reports.haveplan.haveplan1"/></td>
  <td rowspan=3 class=xl27 width=128 style='width:96pt'><bean:message key="label.reports.haveplan.waymap1"/></td>
  <td rowspan=3 class=xl24><bean:message key="label.reports.haveplan.position2"/></td>
  <td rowspan=3 class=xl24><bean:message key="label.reports.haveplan.address2"/></td>
  <td colspan=2 rowspan=2 class=xl27 width=128 style='width:128px'><bean:message key="label.reports.haveplan.linktogosnet2"/></td>
  <td rowspan=3 class=xl27 width=128 style='width:96pt'><bean:message key="label.reports.haveplan.haveplan2"/></td>
  <td rowspan=3 class=xl27 width=128 style='width:96pt'><bean:message key="label.reports.haveplan.waymap2"/></td>
 </tr>
 <tr height=19 style='height:14.25pt'>
 </tr>
 <tr height=19 style='height:14.25pt'>
  <td height=19 class=xl24 style='height:14.25pt;border-top:none;border-left:none'><bean:message key="label.reports.haveplan.linktogosnet_lat"/></td>
  <td class=xl24 style='border-top:none;border-left:none'><bean:message key="label.reports.haveplan.linktogosnet_lon"/></td>
  <td class=xl24 style='border-top:none;border-left:none'><bean:message key="label.reports.haveplan.linktogosnet_lat"/></td>
  <td class=xl24 style='border-top:none;border-left:none'><bean:message key="label.reports.haveplan.linktogosnet_lon"/></td>
 </tr>
<logic:iterate id="reportLine" name="reportList" type="com.hps.july.basestation.valueobject.ReportHavePlanValue">
<logic:present name="reportLine">
 <tr height=38 style='height:25pt;'>
  <td height=38 class=xl25 width=128 style='height:25pt;width:128px' x:num><july:stringwrite name="reportLine" property="numberinfile"/></td>
  <td class=xl25 width=128 style='width:128px'>
  <% if(reportLine.getGsmid1() != 0) {  %>
  <july:stringwrite name="reportLine" property="gsmid1"/>
  <% } %>
  <july:stringwrite name="reportLine" property="name1"/></td>
  <td class=xl25 width=128 style='width:128px'><july:stringwrite name="reportLine" property="address1"/></td>
  <td class=xl25 width=64 style='border-top:none;width:64px'><july:stringwrite name="reportLine" property="linktogosnet_lat1"/></td>
  <td class=xl25 width=64 style='border-top:none;width:64px'><july:stringwrite name="reportLine" property="linktogosnet_lon1"/></td>
  <%
	String haveplan1, haveplan2;
	String cl1 = "xl47";
	if(null != reportLine.getHaveplan1()) {
		if("A".equals(reportLine.getHaveplan1())) { cl1 = "xl25"; }
		haveplan1 = "label.reports.haveplan" + reportLine.getHaveplan1();
	}
	else {
		haveplan1 = "label.reports.haveplan";
	}
	String cl2 = "xl47";
	if(null !=  reportLine.getHaveplan2()) {
		if("A".equals(reportLine.getHaveplan2())) { cl2 = "xl25"; }
		haveplan2 = "label.reports.haveplan" + reportLine.getHaveplan2();
	}
	else  {
		haveplan2 = "label.reports.haveplan";
	}
  %>
  <td class=<%=cl1%> width=128 style=';width:128px'><bean:message key="<%= haveplan1 %>"/></td>
  <td class=xl25 width=128 style='width:128px'><% if(reportLine.getWaymap1() != null) { %><bean:message key="<%=reportLine.getWaymap1()%>"/><%}%></td>
  <td class=xl25 width=128 style='width:128px'>
  <% if(reportLine.getGsmid2() != 0) { %><july:stringwrite name="reportLine" property="gsmid2"/><% } %>
  <july:stringwrite name="reportLine" property="name2"/></td>
  <td class=xl25 width=128 style='width:128px'><july:stringwrite name="reportLine" property="address2"/></td>
  <td class=xl25 width=64 style='border-top:none;width:64px'><july:stringwrite name="reportLine" property="linktogosnet_lat2"/></td>
  <td class=xl25 width=64 style='border-top:none;width:64px'><july:stringwrite name="reportLine" property="linktogosnet_lon2"/></td>
  <td class=<%=cl2%> width=128 style='background-color:#FFFF99;width:128px'><bean:message key="<%= haveplan2 %>"/></td>
  <td class=xl25 width=128 style='width:128px'><% if(reportLine.getWaymap2() != null) { %><bean:message key="<%=reportLine.getWaymap2()%>"/><%}%></td>
 </tr>
 </logic:present>
</logic:iterate>
 <tr height=18 style='height:13.5pt'>
  <td height=18 colspan=11 style='height:13.5pt;mso-ignore:colspan'></td>
 </tr>
<![if supportMisalignedColumns]>
 <tr height=0 style='display:none'>
  <td width=128 style='width:128px'></td>
  <td width=128 style='width:128px'></td>
  <td width=128 style='width:128px'></td>
  <td width=64 style='width:64px'></td>
  <td width=64 style='width:64px'></td>
  <td width=128 style='width:128px'></td>
  <td width=128 style='width:128px'></td>
  <td width=128 style='width:128px'></td>
  <td width=64 style='width:64px'></td>
  <td width=64 style='width:64px'></td>
  <td width=128 style='width:128px'></td>
 </tr>
 <![endif]>

</table>

</body>

</html>
