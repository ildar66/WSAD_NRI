<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%
	response.setHeader("Cache-Control", "no-cache");
	response.setContentType("application/msword;name=reportChanges.doc;charset=Windows-1251");
	response.setHeader("Content-Disposition", "attachment;filename=reportChanges.doc");
%>
<html xmlns:o="urn:schemas-microsoft-com:office:office"
xmlns:w="urn:schemas-microsoft-com:office:word"
xmlns="http://www.w3.org/TR/REC-html40">
<head>
  <meta http-equiv="Content-Type" content="application/msword;name=reportChanges.doc;charset=Windows-1251">
  <meta http-equiv="Content-Disposition" content="attachment;filename=reportChanges.doc">
  <meta name=ProgId content=Word.Document>
  <title>reportWord</title>
<STYLE>  
@page Section1
	{size:595.3pt 841.9pt;
	margin:1.0cm 2.5cm 1.0cm 2.5cm;
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
	FONT-FAMILY: Arial,Verdana; FONT-SIZE: 10pt;  line-height: 100%;
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
<DIV class=Section1 STYLE="FONT-FAMILY: Arial,Verdana; FONT-SIZE: 10pt; line-height:100%">

<DIV STYLE="FONT-FAMILY: Arial,Verdana; FONT-SIZE: 10pt;" ALIGN="RIGHT">
	���������� �2
</DIV>

<DIV STYLE="FONT-FAMILY: Arial,Verdana; FONT-SIZE: 16pt;" ALIGN="CENTER">
	��� <BR>
	������� ������������ � ���������� �� <%= request.getAttribute("docdate") %> <BR>
	�� <%= request.getAttribute("bsnumber") %> <%= request.getAttribute("bsname") %>
</DIV>

<P>&nbsp;</P>

<DIV style="font-size: 10pt;"><B>1. ���������� ������ ������������ � ����������:</B></DIV>
<table border="1" width="100%">
<tr style="font-size: 10pt;">
	<th><B>� �/�</B></th>
	<th><B>��� ���</B></th>
	<th><B>������������ ������������ � ���������� (������������, ���)</B></th>
	<th><B>���-��</B></th>
	<th><B>��. ���</B></th>
	<th><B>�������� �</B></th>
	<th><B>�����������</B></th>
	<th><B>����������</B></th>
</tr>
<%
	java.util.List addedEquipList = (java.util.List)request.getAttribute("addedEquipList");
	java.util.Iterator it = addedEquipList.iterator();
	while (it.hasNext()) {
		com.hps.july.config.model.ReportBTSMountActVO vo = (com.hps.july.config.model.ReportBTSMountActVO)it.next();
		
%>
<tr style="font-size: 10pt;">
	<td align="right"><%= vo.getNumindex() %></td>
	<td><%= vo.getNfscode() %></td>
	<td><%= vo.getEquiptype() %></td>
	<td align="right"><%= vo.getQty() %></td>
	<td><%= vo.getUnitname() %></td>
	<td><%= vo.getSerialnumber() %></td>
	<td><%= vo.getInventserial() %></td>
	<td><%= vo.getComment() %></td>
</tr>
<%
	}
%>
</table>

<P>&nbsp;</P>

<DIV style="font-size: 10pt;"><B>2. ��������� ������������, ������������� � ��������� �������� �� ��������� �� ��������� ����������:</B></DIV>
<table border="1" width="100%">
<tr style="font-size: 10pt;">
	<th><B>� �/�</B></th>
	<th width="50%"><B>��������</B></th>
	<th><B>�����</B></th>
	<th><B>����</B></th>
	<th><B>����������</B></th>
</tr>
<tr style="font-size: 10pt;">
	<td>&nbsp;</td>
	<td>&nbsp;</td>
	<td>&nbsp;</td>
	<td>&nbsp;</td>
	<td>&nbsp;</td>
</tr>
<tr style="font-size: 10pt;">
	<td>&nbsp;</td>
	<td>&nbsp;</td>
	<td>&nbsp;</td>
	<td>&nbsp;</td>
	<td>&nbsp;</td>
</tr>
<tr style="font-size: 10pt;">
	<td>&nbsp;</td>
	<td>&nbsp;</td>
	<td>&nbsp;</td>
	<td>&nbsp;</td>
	<td>&nbsp;</td>
</tr>
<tr style="font-size: 10pt;">
	<td>&nbsp;</td>
	<td>&nbsp;</td>
	<td>&nbsp;</td>
	<td>&nbsp;</td>
	<td>&nbsp;</td>
</tr>
</table>

<P>&nbsp;</P>

<table border="0" width="100%">
<tr style="font-size: 10pt;">
	<th><B>�� _____________ ������� ________________________________________________</B><BR>
	                                        (���������, �������, �.�.�.)</th>
</tr>
<tr style="font-size: 10pt;">
	<th><B>�� ____________ ���������� ______________________________________________</B><BR>
	                                        (���������, �������, �.�.�.)</th>
</tr>
</table>


</DIV>
</body>
</html>
