<!-- Акт выполненных работ -->
<%@ page language = "java" %>
<%@ page contentType = "application/msword; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import="com.hps.july.arenda.formbean.*"%>
<%@ page import="com.hps.july.logic.TxtSumLogic"%>
<%@ page import="java.math.*"%>
<%
	response.setHeader("Cache-Control", "no-cache");
	response.setContentType("application/msword;name=cwaWord.doc;charset=Windows-1251");
	response.setHeader("Content-Disposition", "attachment;filename=cwaWord.rtf");
	CompletWorkAktWordForm aform =  (CompletWorkAktWordForm)request.getAttribute("CompletWorkAktWordForm");
	int cur = aform.getCompletWorkActVO().getCurrency().intValue();
	BigDecimal actSum = aform.getCompletWorkActVO().getActSum();
	BigDecimal actNds = aform.getCompletWorkActVO().getActNds();
	BigDecimal sum = null;
	if(actSum != null && actNds != null) {
		sum = actSum.subtract(actNds);
		request.setAttribute("sum", sum);
	}
%>
<html xmlns:o="urn:schemas-microsoft-com:office:office"
xmlns:w="urn:schemas-microsoft-com:office:word"
xmlns="http://www.w3.org/TR/REC-html40">
<head>
  <meta http-equiv="Content-Type" content="application/msword;name=cwaWord.doc;charset=Windows-1251">
  <meta http-equiv="Content-Disposition" content="attachment;filename=cwaWord.rtf">
  <meta name=ProgId content=Word.Document>
  <title>Акт выполненных работ.</title>
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
	FONT-FAMILY: Arial,Verdana; FONT-SIZE: 9pt;  line-height: 100%;
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

<DIV class=Section1 STYLE="FONT-FAMILY: Arial,Verdana; FONT-SIZE: 12pt; line-height:100%">

<table border="0" width="100%" style="font-size: 10pt; line-height: 100%;">
<tr align="right">
	<td><bean:write name="CompletWorkAktWordForm" property="printComplectAct_TO.positionName" filter="true"/></td>
</tr>
<tr>
	<td><bean:write name="CompletWorkAktWordForm" property="printComplectAct_TO.executorName" filter="true"/></td>
</tr>
<tr>
	<td>адрес:<bean:write name="CompletWorkAktWordForm" property="printComplectAct_TO.executorAddress" filter="true"/></td>
</tr>
</table>

<P>&nbsp;</P>
<P align="center">
	<B STYLE="FONT-FAMILY: Arial,Verdana; FONT-SIZE: 14pt;">АКТ &nbsp;&nbsp; №&nbsp;<bean:write name="CompletWorkAktWordForm" property="completWorkActVO.docnumber" filter="true"/>&nbsp;&nbsp;</B>
	<B>от&nbsp;&nbsp;<july:datewrite name="CompletWorkAktWordForm" property="completWorkActVO.docdate"/></B>
</P>
<P>&nbsp;</P>

<P style="font-size: 10pt;">
	<bean:message key="label.filter.customer"/>:
	<bean:write name="CompletWorkAktWordForm" property="orgCustomer.name" filter="true"/>
</P>
<P>&nbsp;</P>

<!-- Список услуг -->
<table border=1 style='border-collapse:collapse;border:none;mso-border-alt:solid silver .5pt;mso-padding-alt:0cm 5.4pt 0cm 5.4pt' width="100%">
	<!-- Table header -->
	<tr>
		<th>№</th>
		<th>Наименование работы (услуги)</th>
		<th>Ед. изм.</th>
		<th>Количество</th>
		<th>Цена</th>
		<th>Сумма</th>
	</tr>
	<tr>
		<td>1</td>
		<td><bean:write name="CompletWorkAktWordForm" property="completWorkActVO.nameWork" filter="true"/></td>
		<td>усл.</td>
		<td align="right">1</td>
		<td align="right"><july:sumwrite name="sum"/></td>
		<td align="right"><july:sumwrite name="sum"/></td>
	</tr>
	<tr>
		<td colspan="5" align="right" style='border:none;'><B>Итого:</B></td>
		<td align="right"><july:sumwrite name="sum"/></td>
	</tr>
		<tr>
		<td colspan="5" align="right" style='border:none;'><B>Итого НДС:</B></td>
		<td align="right"><july:sumwrite name="CompletWorkAktWordForm" property="completWorkActVO.actNds"/></td>
	</tr>
	</tr>
	<tr>
		<td colspan="5" align="right" style='border:none;'><B>Всего (с учетом НДС):</B></td>
		<td align="right"><july:sumwrite name="CompletWorkAktWordForm" property="completWorkActVO.actSum"/></td>
	</tr>
</table>

<P>&nbsp;</P>
<P style="font-size: 11pt;">
	<I>Всего оказано услуг на сумму:  <%= TxtSumLogic.txtSum(actSum, cur)%></I>,<br>
	<I>в т.ч.НДС:  <%= TxtSumLogic.txtSum(actNds, cur)%>.</I>
</P>
<P>&nbsp;</P>

<P>&nbsp;</P>
<P style="font-size: 10pt;">
	Вышеперечисленные услуги выполнены полностью и в срок. Заказчик претензий по объему , качеству и срокам оказания услуг не имеет.
</P>
<P>&nbsp;</P><P>&nbsp;</P><P>&nbsp;</P>

<table border="0" width="100%" style="font-size: 10pt; line-height: 100%;">
<tr>
	<td>
		Исполнитель: _______________/<bean:write name="CompletWorkAktWordForm" property="printComplectAct_TO.executorFio" filter="true"/>
	</td>
	<td>
		Заказчик:    _______________/<bean:write name="CompletWorkAktWordForm" property="leader.name" filter="true"/>
	</td>
</tr>
<tr><td>&nbsp;</td><td>&nbsp;</td></tr>
<tr><td>&nbsp;</td><td>&nbsp;</td></tr>
<tr><td>&nbsp;</td><td>&nbsp;</td></tr>
<tr>
	<td align="center">м.п.</td>
	<td align="center">м.п.</td>
</tr>
</table>

</DIV>

</body>
</html>