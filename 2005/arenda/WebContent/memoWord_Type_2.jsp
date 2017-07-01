<!-- ��������� ������� - ������ ���� �� ������ ������� ����� (���.2) -->
<%@ page language = "java" %>
<%@ page contentType = "application/msword; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import="com.hps.july.arenda.formbean.*"%>
<%
	response.setHeader("Cache-Control", "no-cache");
	response.setContentType("application/msword;name=memoWord.doc;charset=Windows-1251");
	response.setHeader("Content-Disposition", "attachment;filename=memoWord.rtf");
	MemoWordForm aform =  (MemoWordForm)request.getAttribute("MemoWordForm"); 
%>
<html xmlns:o="urn:schemas-microsoft-com:office:office"
xmlns:w="urn:schemas-microsoft-com:office:word"
xmlns="http://www.w3.org/TR/REC-html40">
<head>
  <meta http-equiv="Content-Type" content="application/msword;name=memoWord.doc;charset=Windows-1251">
  <meta http-equiv="Content-Disposition" content="attachment;filename=memoWord.rtf">
  <meta name=ProgId content=Word.Document>
  <title>��������� �������.</title>
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
	FONT-FAMILY: Arial,Verdana; FONT-SIZE: 12pt;  line-height: 150%;
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
<html:errors/>

<DIV class=Section1 STYLE="FONT-FAMILY: Arial,Verdana; FONT-SIZE: 12pt; line-height:150%">

<table border="0" width="100%">
<tr style="font-size: 14pt;">
	<td width="50%">&nbsp;</td>
	<td align= "right"><bean:write name="MemoWordForm" property="memo.targetVO.name" filter="true"/></td>
</tr>
</table>
<P>&nbsp;</P><P>&nbsp;</P><P>&nbsp;</P><P>&nbsp;</P><P>&nbsp;</P>
<P align="center">
	<B STYLE="FONT-FAMILY: Arial,Verdana; FONT-SIZE: 14pt;">��������� ������� &nbsp;&nbsp; �&nbsp;<bean:write name="MemoWordForm" property="memo.number" filter="true"/>&nbsp;&nbsp;</B>
	<B>��&nbsp;&nbsp;<july:datewrite name="MemoWordForm" property="memo.date"/></B>
</P>
<P>&nbsp;</P>

<!-- ����� ��������:-->
<logic:equal name="MemoWordForm" property="memo.memoType.type" value="2">
	<%@include file="memoWordType2_include.jspf"%>
</logic:equal>
<!-- ������ ������� -->
<table border=1 style='border-collapse:collapse;border:none;mso-border-alt:solid silver .5pt;mso-padding-alt:0cm 5.4pt 0cm 5.4pt' width="100%">
	<!-- Table header -->
	<tr>
		<th>������������ ����� ����� �����</th>
		<th>���������� ���� �����</th>
		<th>������� ����</th>
		<th>�����</th>
	</tr>

	<!-- Table body  --> 
	<logic:iterate id="it" name="MemoWordForm" property="memo.listMemoPos"> 
	<logic:present name="it">
	<tr>
		<td>
			<bean:write name="it" property="cardname" filter="true"/>
		</td>
		<td>
			<bean:write name="it" property="comcardcnt" filter="true"/>
		</td>
		<td>
			<bean:write name="it" property="cardamount" filter="true"/>
		</td>
		<td>
			<bean:write name="it" property="cardAmountSumm" filter="true"/>
		</td>		
	</tr>
	</logic:present>
	</logic:iterate>
</table>

<P>&nbsp;</P>
<logic:equal name="MemoWordForm" property="detach" value="false">
	<P>����������� �������: &nbsp;&nbsp;<B>� <bean:write name="MemoListForm" property="abonent.ban" filter="true" scope="session"/></B></P>
	<P>�������: &nbsp;&nbsp;� <bean:write name="MemoListForm" property="abonent.mainpositionVO.fullName" filter="true" scope="session"/></P>
</logic:equal>
<logic:equal name="MemoWordForm" property="detach" value="true">
	<P>�������: &nbsp;&nbsp;� <bean:write name="MemoWordForm" property="memo.positionVO.name" filter="true"/></P>
</logic:equal>
<P>&nbsp;</P><P>&nbsp;</P><P>&nbsp;</P><P>&nbsp;</P>

<table border="0" width="100%">
<tr style="font-size: 14pt;">
	<td>��������� ������ ������ �������<br>� ����������� �����������</td>
	<td align="right">��������� �.�.</td></tr>
</table>
<P>&nbsp;</P><P>&nbsp;</P><P>&nbsp;</P><P>&nbsp;</P>
<P STYLE="FONT-FAMILY: Arial,Verdana; FONT-SIZE: 10pt;">
<logic:present name="MemoWordForm" property="memo.manVO">
�����������: <bean:write name="MemoWordForm" property="memo.manVO.name" filter="true"/><br>
���: <bean:write name="MemoWordForm" property="memo.manVO.phone" filter="true"/>
</logic:present>
</P>
 
</DIV>

</body>
</html>
