<!-- ����-������� -->
<%@ page language = "java" %>
<%@ page contentType = "application/msword; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%
	response.setHeader("Cache-Control", "no-cache");
	response.setContentType("application/msword;name=schetFactWord.doc;charset=Windows-1251");
	response.setHeader("Content-Disposition", "attachment;filename=schetFactWord.rtf");
	com.hps.july.arenda.formbean.SchetFactPrintForm aform =  (com.hps.july.arenda.formbean.SchetFactPrintForm)request.getAttribute("SchetFactPrintForm"); 
%>
<html xmlns:o="urn:schemas-microsoft-com:office:office"
xmlns:w="urn:schemas-microsoft-com:office:word"
xmlns="http://www.w3.org/TR/REC-html40">
<head>
  <meta http-equiv="Content-Type" content="application/msword; charset=Windows-1251">
  <meta http-equiv="Content-Disposition" content="attachment;filename=schetFactWord.rtf">
  <meta name=ProgId content=Word.Document>
  <title>����-�������.</title>
<STYLE>  
@page Section1
	{size:841.9pt 595.3pt;
	mso-page-orientation:landscape;
	margin:1.0cm 42.55pt 1.0cm 42.55pt;
	mso-header-margin:35.45pt;
	mso-footer-margin:35.45pt;
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
<%--TABLE width="100%">
	<TR>
		<TD width="75%">&nbsp;</TD>
		<TD align="center" style="FONT-SIZE: 7pt;">
		  ���������� �1<br>
		  � �������� ������� �������� �����<br>
		  ���������� � ������������ ������-������, ����<br>
		  ������� � ���� ������ ��� �������� �� ������ ��<br>	
		  ����������� ���������, ������������	<br>
		  �������������� ������������� ����������	<br>
		  ��������� �� 2 ������� 2000 �. � 914    	<br>
		  (� �������� ������������� ������������� ��	<br>
		  �� 15 ����� 2001 �. � 189, �� 27.07.2002 � 575,	<br>
		  �� 16.02.2004� � 84, �� 11.05.2006� � 283)<br>
		</TD>
	</TR>
</TABLE--%>
<P align="right"><bean:write name="SchetFactPrintForm" property="header.namePosition" filter="true"/></P>
<P align="center" STYLE="FONT-FAMILY: Arial,Verdana; FONT-SIZE: 12pt;">
	<B>����-������� �&nbsp;&nbsp;&nbsp;<bean:write name="SchetFactPrintForm" property="header.numberSchetFakt" filter="true"/>&nbsp;&nbsp;
	��&nbsp;&nbsp;<july:datewrite name="SchetFactPrintForm" property="header.dateSchetFakt"/></B>
</P>
<P>&nbsp;</P>
<TABLE width="100%" BORDER="0" style="border-collapse:collapse;border:none;">
	<TR>
		<TD><B>��������:</B></TD>
		<TD><B><bean:write name="SchetFactPrintForm" property="header.nameSeller" filter="true"/></B></TD>
	</TR>
	<TR>
		<TD>�����:</TD>
		<TD><bean:write name="SchetFactPrintForm" property="header.addressSeller" filter="true"/></TD>
	</TR>
	<TR>
		<TD nowrap>����������������� ����� �������� (���)/���:</TD>
		<TD><bean:write name="SchetFactPrintForm" property="header.innSeller" filter="true"/></TD>
	</TR>
	<TR>
		<TD>��������������� � ��� �����:</TD>
		<TD><bean:write name="SchetFactPrintForm" property="header.nameAddrSender" filter="true"/></TD>
	</TR>
	<TR>
		<TD>��������������� � ��� �����:</TD>
		<TD><bean:write name="SchetFactPrintForm" property="header.nameAddrRecipient" filter="true"/></TD>
	</TR>
	<TR>
		<TD>� ��������-���������� ��������� �:</TD>
		<TD><bean:write name="SchetFactPrintForm" property="header.baseDocNumber" filter="true"/></TD>
	</TR>
	<TR>
		<TD><B>����������:</B></TD>
		<TD><B><bean:write name="SchetFactPrintForm" property="header.nameBuyer" filter="true"/></B></TD>
	</TR>
	<TR>
		<TD>�����:</TD>
		<TD><bean:write name="SchetFactPrintForm" property="header.addressBuyer" filter="true"/></TD>
	</TR>
	<TR>
		<TD nowrap>����������������� ����� ���������� (���)/���:</TD>
		<TD><bean:write name="SchetFactPrintForm" property="header.innBuyer" filter="true"/></TD>
	</TR>
	<TR>
		<TD nowrap>������:</TD>
		<TD><bean:write name="SchetFactPrintForm" property="header.currencyName" filter="true"/></TD>
	</TR>	
</TABLE>
<!-- SchetFactPosition Table -->
<P>&nbsp;</P>

<!-- SchetFactPosition Table -->
<table width="100%" border="1" style='border-collapse:collapse;border:none;mso-border-alt:solid black .5pt;mso-padding-alt:0cm 5.4pt 0cm 5.4pt'>
<!-- header start -->
<tr align="center">
	<td>������������ ������ (�������� ����������� �����, ��������� �����),�������������� �����</td>
	<td>��. ���.</td>
	<td>����������</td>
	<td>����(����� �� ��.���.)</td>
	<td nowrap>��������� �������<br>(�����,�����),<br>������������� ����,<br>����� ��� ������</td>
	<td>� ��� ����� �����</td>
	<td>��������� ������</td>
	<td>����� ������</td>
	<td nowrap>��������� �������<br>(�����,�����),<br>������������� ����,<br>����� � ������ ������</td>
	<td>������ ���������.</td>
	<td>����� ���������� ����������</td>
</tr>
<tr align="center">
	<td>1</td><td>2</td><td>3</td><td>4</td><td>5</td><td>6</td><td>7</td><td>8</td><td>9</td><td>10</td><td>11</td>
</tr>
<!-- header end -->
<%
	java.util.Iterator table = aform.getPositionsList().iterator();
    java.math.BigDecimal sum_sumNds = new java.math.BigDecimal(0); 
	java.math.BigDecimal sum_sumWithTax = new java.math.BigDecimal(0);
	while (table.hasNext()) {
		com.hps.july.arenda.valueobject.SchetFactPositionValueObject ob
          = (com.hps.july.arenda.valueobject.SchetFactPositionValueObject)table.next();
		request.setAttribute("ob", ob);
%>
<!-- DATA start -->
<tr>
	<td><bean:write name="ob" property="nameResource" filter="true"/></td>
	<td><bean:write name="ob" property="edizm" filter="true"/></td>
	<td align="right" NOWRAP><july:numberwrite name="ob" property="qty"/> </td>
	<td align="right" NOWRAP><july:numberwrite name="ob" property="price" fractdigits="2"/> </td>
	<td align="right" NOWRAP><july:numberwrite name="ob" property="sumFreeTax" fractdigits="2"/> </td>
	<td align="right" NOWRAP><july:numberwrite name="ob" property="excise" fractdigits="2"/> </td>
	<td align="right" NOWRAP><july:numberwrite name="ob" property="rateNds" fractdigits="2"/> </td>
	<td align="right" NOWRAP><july:numberwrite name="ob" property="sumNds" fractdigits="2"/> </td>
	<td align="right" NOWRAP><july:numberwrite name="ob" property="sumWithTax" fractdigits="2"/> </td>
	<td><bean:write name="ob" property="country" filter="true"/></td>
	<td><bean:write name="ob" property="numGTD" filter="true"/></td>
</tr>
<!-- DATA end -->
<%
		if(ob.getSumNds() != null){
			sum_sumNds=sum_sumNds.add(ob.getSumNds());
			request.setAttribute("sum_sumNds", sum_sumNds);
		}
		if(ob.getSumWithTax() != null){
			sum_sumWithTax=sum_sumWithTax.add(ob.getSumWithTax());
			request.setAttribute("sum_sumWithTax", sum_sumWithTax);
		}
	}// end while
%>
<!-- footer start -->
<tr>
	<td>����� � ������:</td>
	<td align="right" colspan="6">
		<logic:present name="ob" property="idCurrency">
			<logic:equal name="ob" property="idCurrency" value="840">� �������� ���</logic:equal>
			<logic:equal name="ob" property="idCurrency" value="810">� ���������� ������</logic:equal>
			<logic:equal name="ob" property="idCurrency" value="978">� ����</logic:equal>
		</logic:present>
	</td>
	<td align="right" NOWRAP><july:numberwrite name="sum_sumNds" fractdigits="2"/></td>
	<td align="right" NOWRAP><july:numberwrite name="sum_sumWithTax" fractdigits="2"/></td>
	<td colspan="2">&nbsp;</td>
</tr>
<!-- footer end -->
</table>

<P>&nbsp;</P><P>&nbsp;</P><P>&nbsp;</P><P>&nbsp;</P>
<table border="0" width="100%">
<tr style="font-size: 10pt;">
	<td align= "center" width="50%">
		<b>������������ �����������</b>___________<bean:write name="SchetFactPrintForm" property="header.nameManager" filter="true"/>
	</td>
	<td align= "center">
		<b>������� ���������</b>___________<bean:write name="SchetFactPrintForm" property="header.nameBugalter" filter="true"/>
	</td>
</tr>
<tr>
	<td align= "center" style="font-size: 8pt;">(�������) (�.�.�.)</td>
	<td align= "center" style="font-size: 8pt;">(�������) (�.�.�.)</td>
</tr>
<tr>
    <td>&nbsp;</td>
	<td>&nbsp;</td>
</tr>
<tr style="font-size: 10pt;">
	<td align= "center">
		<b>�������������� ���������������___________
	</td>
	<td align= "center" rowspan="2">(��������� ������������� � ���������������<br>����������� ��������������� ���������������)</td>
</tr>
<tr>
	<td align= "center" style="font-size: 8pt;">(�������) (�.�.�.)</td>
</tr>
</table>
<P>&nbsp;</P><P>&nbsp;</P>
<P style="font-size: 8pt;">����������. ������ ��������� - ����������, ������ ��������� - ��������</P>
</DIV>
</body>
</html>
