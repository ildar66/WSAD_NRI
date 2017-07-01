<!-- Служебные записки   - Подключить услугу (тип.7)-->
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
  <title>Служебная записка.</title>
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
	<B STYLE="FONT-FAMILY: Arial,Verdana; FONT-SIZE: 14pt;">Служебная записка &nbsp;&nbsp; №&nbsp;<bean:write name="MemoWordForm" property="memo.number" filter="true"/>&nbsp;&nbsp;</B>
	<B>от&nbsp;&nbsp;<july:datewrite name="MemoWordForm" property="memo.date"/></B>
</P>
<P>&nbsp;</P>

<!-- Текст служебки:-->
<P style='text-align:justify;text-indent:35.4pt'>Прошу Вас  <bean:write name="MemoWordForm" property="memo.useTypeVO.printLabel" filter="true" scope="request"/>
<logic:present name="MemoWordForm" property="arendaContractVO">
	по договору № <bean:write name="MemoWordForm" property="arendaContractVO.documentNumber" filter="true" scope="request"/>
	от <july:datewrite name="MemoWordForm" property="arendaContractVO.documentDate" scope="request"/>
</logic:present>
предоставить на телефонные номера, принадлежащие
<logic:equal name="MemoWordForm" property="detach" value="false">
	<bean:write name="MemoListForm" property="abonent.orgCustomer.name" filter="true" scope="session"/>:
</logic:equal>
<logic:equal name="MemoWordForm" property="detach" value="true">
	<bean:write name="MemoWordForm" property="memo.orgCustomer.shortname" filter="true"/>:
</logic:equal>
</P>
<P>&nbsp;</P>

<!-- Список позиций -->
<table border=1 style='border-collapse:collapse;border:none;mso-border-alt:solid silver .5pt;mso-padding-alt:0cm 5.4pt 0cm 5.4pt' width="100%">
	<!-- Table header -->
	<tr>
		<th rowspan="2">Избирательный номер</th>
		<th rowspan="2">Услуга</th>
		<th colspan="2">Период действия</th>
		<th rowspan="2">Способ<BR>доставки</th>
		<th rowspan="2">Адрес<BR>доставки</th>
	</tr>
	<tr>
		<th>с ____</th>
		<th>по ___</th>
	</tr>

	<!-- Table body  --> 
	<logic:iterate id="it" name="MemoWordForm" property="memo.listMemoPos"> 
	<logic:present name="it">
	<tr>
		<td>
			<bean:write name="it" property="phoneNumber" filter="true"/>
		</td>
		<td>
			<bean:write name="it" property="service" filter="true"/>
		</td>
		<td>
			<july:datewrite name="it" property="startdate"/>
		</td>
		<td>
			<july:datewrite name="it" property="enddate"/>
		</td>
		<td>
			<logic:present name="it" property="billdelivery">
				<logic:equal name="it" property="billdelivery" value="1">Курьер</logic:equal>
				<logic:equal name="it" property="billdelivery" value="2">Почта</logic:equal>
				<logic:equal name="it" property="billdelivery" value="3">Электронная почта</logic:equal>
			</logic:present>
		</td>
		<td>
			<bean:write name="it" property="billaddress" filter="true"/>
		</td>
	</tr>
	</logic:present>
	</logic:iterate>
</table>

<P>&nbsp;</P>
<P>Абонентский договор: &nbsp;&nbsp;<B>№ <bean:write name="MemoListForm" property="abonent.ban" filter="true" scope="session"/></B></P>
<P>Позиция: &nbsp;&nbsp;№ <bean:write name="MemoListForm" property="abonent.mainpositionVO.fullName" filter="true" scope="session"/></P>
<P>&nbsp;</P><P>&nbsp;</P><P>&nbsp;</P><P>&nbsp;</P>

<table border="0" width="100%">
<tr style="font-size: 14pt;">
	<td>Начальник отдела поиска позиций<br>и договорного обеспечения</td>
	<td align="right">Федоринов А.И.</td></tr>
</table>
<P>&nbsp;</P><P>&nbsp;</P><P>&nbsp;</P><P>&nbsp;</P>
<P STYLE="FONT-FAMILY: Arial,Verdana; FONT-SIZE: 10pt;">
<logic:present name="MemoWordForm" property="memo.manVO">
Исполнитель: <bean:write name="MemoWordForm" property="memo.manVO.name" filter="true"/><br>
Тел: <bean:write name="MemoWordForm" property="memo.manVO.phone" filter="true"/>
</logic:present>
</P>
 
</DIV>

</body>
</html>
