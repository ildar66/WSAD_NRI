<!-- Акт взаимозачета 22.04.2007 -->
<%@ page language = "java" %>
<%@ page contentType = "application/msword; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import="com.hps.july.arenda.valueobject.*"%>
<%@ page import="com.hps.july.util.*"%>
<%
	com.hps.july.arenda.formbean.MutactWordPrintForm aform =  (com.hps.july.arenda.formbean.MutactWordPrintForm)request.getAttribute("MutactWordPrintForm");
	request.getSession().setAttribute("colontitle", aform.getHeader().getHighColontitul());
	String name = aform.getHeader().getPosition().trim() + " акт № " + aform.getHeader().getNumberAkt().trim();
	String urlName = AppUtils.filter(name);
	response.setHeader("Cache-Control", "no-cache");
	response.setContentType("application/msword; name="+ java.net.URLEncoder.encode(urlName+".doc") +";charset=windows-1251");
	response.setHeader ("Content-Disposition", "attachment; filename=mutAct.rtf");
%>
<html xmlns:o="urn:schemas-microsoft-com:office:office"
xmlns:w="urn:schemas-microsoft-com:office:word"
xmlns="http://www.w3.org/TR/REC-html40">

<head>
  <meta name=ProgId content=Word.Document>
  <meta http-equiv="Content-Type" content="application/msword; charset=Windows-1251">
  <link rel=File-List href="./<%=urlName%>.files/filelist.xml">
  <title><bean:message key="label.mutactword.doc"/><%=request.getParameter("actcode")%></title>
<STYLE>  
   
@page Section1
	{size:595.3pt 841.9pt;
	margin:1.0cm 42.55pt 1.0cm 42.55pt;
	mso-header-margin:35.45pt;
	mso-footer-margin:35.45pt;
	mso-even-header: url('./<%=urlName%>.files/header.htm') eh1;
	mso-header: url('./<%=urlName%>.files/header.htm') h1;
	mso-paper-source:0;}
div.Section1
	{page:Section1;} 
p
	{mso-style-parent:"";
	margin:0cm;
	margin-top: 0cm;
	margin-bottom:.0001pt;
	mso-pagination:widow-orphan;
	}

TABLE {
	FONT-FAMILY: Arial,Verdana; FONT-SIZE: 8.5pt;
}

TD.tsilver {
	border:solid silver .5pt;
	border-right:none;
	background: #EAEAEA;
	padding:0cm 5.4pt 0cm 5.4pt;
}

<!--[if gte mso 9]>
<xml>
 <w:WordDocument>
  <w:View>Print</w:View>
  <w:DoNotOptimizeForBrowser/>
 </w:WordDocument>
</xml>
<![endif]-->

</STYLE>
</head> 
<body>

<DIV class=Section1 STYLE="FONT-FAMILY: Arial,Verdana; FONT-SIZE: 10pt;">

<P align="right"><bean:write name="MutactWordPrintForm" property="header.position" filter="true"/></P>
<P align="center" STYLE="FONT-FAMILY: Arial,Verdana; FONT-SIZE: 12pt;">
	<B><bean:message key="label.mutactword.numbAct"/>&nbsp;<bean:write name="MutactWordPrintForm" property="header.numberAkt" filter="true"/></B>
</P>
<P align="center"><bean:write name="MutactWordPrintForm" property="header.header1" filter="true"/></P>
<TABLE width="100%" BORDER="0" style="border-collapse:collapse;border:none;">
		<TR>
			<TD align="left"><bean:write name="MutactWordPrintForm" property="header.town" filter="true"/></TD>
			<TD align="right"><july:datewrite name="MutactWordPrintForm" property="header.dateAkt"/></TD>
		</TR>
</TABLE>

<P>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<bean:write name="MutactWordPrintForm" property="header.header2" filter="true"/></P>
<P><bean:message key="label.mutactword.currencyAct"/>&nbsp;<bean:write name="MutactWordPrintForm" property="header.mainCurr" filter="true"/></P>
<P><bean:write name="MutactWordPrintForm" property="header.userHeader" filter="true"/></P>

<!-- StartDebt Table -->
<%@include file="mutActWord_StartDebt_include.jspf"%>

<!-- MutualCharges Table -->  
<%@include file="mutActWord_MutualCharges_include.jspf"%>

<!-- MutualPayments Table -->
<%@include file="mutActWord_MutualPayments_include.jspf"%>

<!-- MutTempDebt --> 
<%@include file="mutActWord_MutualTempDebt_include.jspf"%>

<P>&nbsp;</P>
<B><bean:write name="MutactWordPrintForm" property="header.header3" filter="true"/></B>
<!-- getListSumMutualForPrintAct -->
<%@include file="mutActWord_ListSumMutualForPrintAct_include.jspf"%>
<br>
<!--MutualDebtNds Table -->
<%@include file="mutActWord_MutualDebtNds_include.jspf"%>
<br>
<!--EndDebt Table -->  
<%@include file="mutActWord_EndDebt_include.jspf"%>

<P><bean:write name="MutactWordPrintForm" property="header.userFooter" filter="true"/></P>
<P>&nbsp;</P>
<table border="0" width="100%">
<tr style="font-size: 10pt;">
	<td align= "center" width="50%"><b><bean:write name="MutactWordPrintForm" property="header.customer" filter="true"/></b></td>
	<td align= "center"><b><bean:write name="MutactWordPrintForm" property="header.executor" filter="true"/></b></td>
</tr>
<tr>
	<td align= "center"><bean:write name="MutactWordPrintForm" property="header.jobCustomer" filter="true"/></td>
	<td align= "center"><bean:write name="MutactWordPrintForm" property="header.jobExecutor" filter="true"/></td>
</tr>
<tr>
    <td>&nbsp;</td>
	<td>&nbsp;</td>
</tr>
<tr>
    <td>&nbsp;</td>
	<td>&nbsp;</td>
</tr>
<tr style="font-size: 10pt;">
	<td align= "center"><bean:write name="MutactWordPrintForm" property="header.fioCustomer" filter="true"/></td>
	<td align= "center"><bean:write name="MutactWordPrintForm" property="header.fioExecutor" filter="true"/></td>
</tr>
</table>
<P style="font-size: 8pt;">
<bean:message key="label.mutactword.otvUser"/> &nbsp;<bean:write name="MutactWordPrintForm" property="header.otvUser" filter="true"/><br>
<bean:message key="label.mutactword.otvEconomist"/> &nbsp;<bean:write name="MutactWordPrintForm" property="header.otvEconomist" filter="true"/>
</P>
<!-- Реквизиты для перечисления -->
<br clear=all style='page-break-before:always'>
<jsp:include page="/mutActWord_Purpose.jsp" flush="true"/>
</DIV> 
            
</body>
</html>
   