<!-- Акт сверка -->  
<%@ page language = "java" %>
<%@ page contentType = "application/msword; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import="com.hps.july.util.*"%>
<%
    String faleName = "mutActSverka.rtf";
	String name = "Документ не может быть распечатан акт № " + request.getParameter("actcode").trim();
	com.hps.july.arenda.formbean.MutactWordPrintForm aform = (com.hps.july.arenda.formbean.MutactWordPrintForm)request.getAttribute("MutactWordPrintForm");
	if(aform.getIdTask() != -1) {
	   request.getSession().setAttribute("colontitle", aform.getSverkaHeader().getHighColontitul());
	   name = aform.getSverkaHeader().getPosition().trim() + " акт № " + aform.getSverkaHeader().getNumberAkt().trim();
    }
	else {
	   request.getSession().setAttribute("colontitle", name);
	}
	String urlName = AppUtils.filter(name);; 
	response.setHeader("Cache-Control", "no-cache");
	response.setContentType("application/msword; name="+ java.net.URLEncoder.encode(urlName+".doc") +";charset=windows-1251");        
	response.setHeader ("Content-Disposition", "attachment; filename=" + faleName);
%>
<html xmlns:o="urn:schemas-microsoft-com:office:office"
xmlns:w="urn:schemas-microsoft-com:office:word"
xmlns="http://www.w3.org/TR/REC-html40">

<head>
 <meta name=ProgId content=Word.Document>
 <meta http-equiv="Content-Type" content="application/msword; charset=Windows-1251">
 <link rel=File-List href="./<%= urlName%>.files/filelist.xml">
 <title><bean:message key="label.mutactword.doc"/> <%request.getParameter("actcode");%></title>
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
	margin-top: 0.3cm;
	margin-bottom:.0001pt;
	mso-pagination:widow-orphan;
	}

TABLE {
	FONT-FAMILY: Arial,Verdana; FONT-SIZE: 9pt;
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

<%
	if(aform.getIdTask() != -1){
%>
<P align="right"><bean:write name="MutactWordPrintForm" property="sverkaHeader.position" filter="true"/></P>
<H4 align="center"><bean:message key="label.mutactword.numbAct"/><bean:write name="MutactWordPrintForm" property="sverkaHeader.numberAkt" filter="true"/></H4>
<P align="center"><B><bean:write name="MutactWordPrintForm" property="sverkaHeader.header1" filter="true"/></B></P>

<TABLE width="100%" BORDER="0" style="border-collapse:collapse;border:none;">
		<TR>
			<TD align="left"><bean:write name="MutactWordPrintForm" property="sverkaHeader.town" filter="true"/></TD>
			<TD align="right"><july:datewrite name="MutactWordPrintForm" property="sverkaHeader.dateAkt"/></TD> 
		</TR>
</TABLE>

<P><bean:write name="MutactWordPrintForm" property="sverkaHeader.header2" filter="true"/></P>
<P>валюта акта: <bean:write name="MutactWordPrintForm" property="sverkaHeader.mainCurr" filter="true"/></P>
<P><bean:write name="MutactWordPrintForm" property="sverkaHeader.userHeader" filter="true"/></P>

<!-- AktSverkaShargesAndPay SubReport -->
<%@include file="mutActSverkaWord_ShargesAndPay_include2.jspf"%>  
<!-- AktSverkaContrRes SubReport -->
<%@include file="mutActSverkaWord_ContrRes_include.jspf"%>

<P><bean:write name="MutactWordPrintForm" property="sverkaHeader.userFooter" filter="true"/></P>
<P>&nbsp;</P>
<table border="0" width="100%">
<tr style="font-size: 10pt;">
	<td align= "center" width="50%"><b><bean:write name="MutactWordPrintForm" property="sverkaHeader.customer" filter="true"/></b></td>
	<td align= "center"><b><bean:write name="MutactWordPrintForm" property="sverkaHeader.executor" filter="true"/></b></td>
</tr>
<tr>
	<td align= "center"><bean:write name="MutactWordPrintForm" property="sverkaHeader.jobCustomer" filter="true"/></td>
	<td align= "center"><bean:write name="MutactWordPrintForm" property="sverkaHeader.jobExecutor" filter="true"/></td>
</tr>
<tr> 
    <td>&nbsp;</td>
	<td>&nbsp;</td>
</tr>
<tr style="font-size: 10pt;">
	<td align= "center"><bean:write name="MutactWordPrintForm" property="sverkaHeader.fioCustomer" filter="true"/></td>
	<td align= "center"><bean:write name="MutactWordPrintForm" property="sverkaHeader.fioExecutor" filter="true"/></td>
</tr>
</table>
<P style="font-size: 8pt;">
<bean:message key="label.mutactword.otvUser"/> &nbsp;<bean:write name="MutactWordPrintForm" property="sverkaHeader.otvUser" filter="true"/><br>
<bean:message key="label.mutactword.otvEconomist"/> &nbsp;<bean:write name="MutactWordPrintForm" property="sverkaHeader.otvEconomist" filter="true"/>
</P>
<%} else {%>
   <B>
     <bean:message key="label.mutactword.docNoPrint"/>&nbsp;<bean:message key="label.mutactword.numbAct"/> <%=request.getParameter("actcode")%>
   </B>
<%}%>
</DIV>
 
</body>
</html>
    