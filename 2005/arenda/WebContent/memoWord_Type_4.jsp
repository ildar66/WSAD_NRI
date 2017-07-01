<!-- Служебные записки - Ремонт оборудования (тип.4) -->
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
	FONT-FAMILY: Times New Roman,Arial,Verdana; FONT-SIZE: 12pt;  line-height: 150%;
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

<DIV class=Section1 STYLE="FONT-FAMILY: Times New Roman,Arial,Verdana; FONT-SIZE: 12pt; line-height:150%">

<table border="0" width="100%">
<tr style="font-size: 12pt;">
	<td width="30%">&nbsp;</td>
	<td>
			<B><bean:write name="MemoWordForm" property="memo.targetVO.name" filter="true"/></B> 
	</td>
</tr>
<tr style="font-size: 12pt;">
	<td>&nbsp;</td>
	<td>
			<B>от заместителя технического директора по проектированию и строительству<BR>
			г-на   Фишкина Ю. А. </B>
	</td>
</tr>
<tr style="font-size: 12pt;">
	<td>&nbsp;</td>
	<td>
			<B><I>от&nbsp;&nbsp;<july:datewrite name="MemoWordForm" property="memo.date"/></I></B>
	</td>
</tr>
</table>
<P>&nbsp;</P><P>&nbsp;</P>
<P align="center">
	<B STYLE="FONT-FAMILY: Arial,Verdana; FONT-SIZE: 14pt;">СЛУЖЕБНАЯ ЗАПИСКА  &nbsp;&nbsp; №&nbsp;<bean:write name="MemoWordForm" property="memo.number" filter="true"/></B>
</P>
<P>&nbsp;</P>

<!-- Текст служебки:-->
<P style='text-align:justify;text-indent:35.4pt'>Прошу Вас дать распоряжение отремонтировать абонентское оборудование, выданное арендодателю <bean:write name="MemoListForm" property="abonent.orgCustomer.name" filter="true" scope="session"/> согласно договора № <bean:write name="MemoListForm" property="abonent.ban" filter="true" scope="session"/> от <july:datewrite name="MemoListForm" property="abonent.docdate"/> (<bean:write name="MemoListForm" property="abonent.mainpositionVO.fullName" filter="true" scope="session"/>)
</P>
<P>&nbsp;</P>

<!-- Список позиций -->
<table border=1 style='border-collapse:collapse;border:none;mso-border-alt:solid silver .5pt;mso-padding-alt:0cm 5.4pt 0cm 5.4pt' width="100%">
	<!-- Table header -->
	<tr>
		<th>№</th>
		<th>Наименование и серийный номер (IMEI)</th>
		<th>Количество</th>
		<th>Проявление дефекта (выполняемая работа) </th>
	</tr>
	<!-- Table body  --> 
	<logic:iterate id="it" name="MemoWordForm" property="memo.listMemoPos" indexId="indexId"> 
	<logic:present name="it">
	<tr>
		<td><%=indexId.intValue()+1%></td>
		<td><bean:write name="it" property="equipname" filter="true"/></td>
		<td><bean:write name="it" property="equipcnt" filter="true"/></td>
		<td><bean:write name="it" property="defectdescr" filter="true"/></td>
	</tr>
	</logic:present>
	</logic:iterate>
</table>

<P>&nbsp;</P>

<table border="0" width="100%">
<tr style="font-size: 12pt;">
	<td width="50%" valign=top >Ответственный исполнитель</td>
	<td align="left"> <bean:write name="MemoWordForm" property="memo.manVO.name" filter="true"/><BR>
	тел. <bean:write name="MemoWordForm" property="memo.manVO.phone" filter="true"/></td>
</tr>
</table>

<P>&nbsp;</P>
<P STYLE=" FONT-SIZE: 14pt;"><B><I>Дирекция по проектированию</I></B></P>
<P STYLE=" FONT-SIZE: 12pt;">
 <B>и строительству сетей московского региона<BR>
 и транспортной сети:<BR>
Прошу принять к исполнению:_____________________________/ г-н Фишкин Ю. А. / </B>
<P align="right">"___" __________200_ г.</P>
<P>&nbsp;</P>

<P STYLE=" FONT-SIZE: 12pt;"><B>Дирекция абонентского оборудования:</B></P>
<B>Принять к исполнению:___________________________________/ г-н Мухин И.В</B>
<P align="right">"___" __________200_ г.</P>
<P>&nbsp;</P>

<P><B><I>Исполнено </I></B>"____"  ___________ 200__г. ______________</P>
<P><B>Внимание:</B> Служебные записки, заполненные от руки НЕ ПРИНИМАЮТСЯ!</P>
</DIV>

</body>
</html>
