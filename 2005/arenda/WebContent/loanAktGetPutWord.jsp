<!-- Акт WORD для ссудных договоров -->
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
	response.setContentType("application/msword;name=aktWord.doc;charset=Windows-1251");
	response.setHeader("Content-Disposition", "attachment;filename=aktWord.rtf");
	//LoanAktGetPutWordForm aform =  (LoanAktGetPutWordForm)request.getAttribute("LoanAktGetPutWordForm");
%>
<html xmlns:o="urn:schemas-microsoft-com:office:office"
xmlns:w="urn:schemas-microsoft-com:office:word"
xmlns="http://www.w3.org/TR/REC-html40">
<head>
  <meta http-equiv="Content-Type" content="application/msword;name=aktWord.doc;charset=Windows-1251">
  <meta http-equiv="Content-Disposition" content="attachment;filename=aktWord.rtf">
  <meta name=ProgId content=Word.Document>
  <title>Акт WORD для ссудных договоров.</title>
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

p.BodyText2, li.BodyText2, div.BodyText2
	{mso-style-name:"Body Text 2";
	margin:0cm;
	margin-bottom:.0001pt;
	text-align:justify;
	text-indent:35.45pt;
	mso-pagination:widow-orphan;
	mso-layout-grid-align:none;
	punctuation-wrap:simple;
	text-autospace:none;
	font-size:14.0pt;
	mso-bidi-font-size:10.0pt;
	font-family:Arial;
	mso-fareast-font-family:"Times New Roman";
	mso-bidi-font-family:"Times New Roman";
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

<DIV class=Section1 STYLE="FONT-FAMILY: Arial,Verdana; FONT-SIZE: 14pt; line-height:100%">
	<table border="0" width="100%" style="font-size: 12pt;">
		<tr>
			<td width="40%" rowspan="4">&nbsp;</td>
			<td align= "center">&quot;<B>УТВЕРЖДАЮ</B>&quot;</td>
		</tr>
		<tr>
			<td align= "left">
				&nbsp;<B>ЗАМЕСТИТЕЛЬ ТЕХНИЧЕСКОГО ДИРЕКТОРА<BR>
				ПО ПРОЕКТИРОВАНИЮ И СТРОИТЕЛЬСТВУ,<BR> 
				РУКОВОДИТЕЛЬ СЛУЖБЫ СТРОИТЕЛЬСТВА <BR>
				И ЭКСПЛУАТАЦИИ ПОЗИЦИЙ</B>
			</td>
		</tr>
		<tr><td>&nbsp;</td></tr>
		<tr>
			<td><B>__________________________Ю.А.ФИШКИН</B></td>
		</tr>
	</table>

	<P>&nbsp;</P><P>&nbsp;</P><P>&nbsp;</P><P>&nbsp;</P><P>&nbsp;</P>
	<P align="center">
		<B STYLE="FONT-FAMILY: Arial,Verdana; FONT-SIZE: 14pt;">Акт <BR> приема-передачи имущества<BR>
		от <july:datewrite name="LoanAktGetPutWordForm" property="to.vo.dateAct"/></B>
	</P>
	<P>&nbsp;</P><P>&nbsp;</P>
	<P class=BodyText2>Настоящий Акт составлен представителем "Вымпелком" <bean:write name="LoanAktGetPutWordForm" property="to.ourManName" filter="true"/> с одной стороны, и 
<logic:equal name="LoanAktGetPutWordForm" property="isFiz" value="true">господином</logic:equal>
	<bean:write name="LoanAktGetPutWordForm" property="loanContractVO.orgCustomer.name" filter="true"/>
<logic:equal name="LoanAktGetPutWordForm" property="isFiz" value="false">
	в лице <bean:write name="LoanAktGetPutWordForm" property="to.vo.otherMan" filter="true"/>
</logic:equal>
	с другой стороны в подтверждении того, что "Вымпелком" передает, а 
<logic:equal name="LoanAktGetPutWordForm" property="isFiz" value="false">
		<bean:write name="LoanAktGetPutWordForm" property="to.vo.otherMan" filter="true"/>
</logic:equal>
<logic:equal name="LoanAktGetPutWordForm" property="isFiz" value="true"> господин
	<bean:write name="LoanAktGetPutWordForm" property="loanContractVO.orgCustomer.name" filter="true"/>
</logic:equal>
	принимает во временное пользование согласно накладной <bean:write name="LoanAktGetPutWordForm" property="aktAbonentBillInfo" filter="true"/>:</P>

<P>&nbsp;</P>

<!-- Список позиций -->
<table border=1 style='FONT-FAMILY: Times New Roman,Arial,Verdana; FONT-SIZE: 14pt;' width="100%">
	<!-- Table header -->
	<tr>
		<th>Наименование</th>
		<th>Количество</th>
	</tr>
	<!-- Table body  --> 
	<logic:present name="LoanAktGetPutWordForm" property="listBillPos">
	<logic:iterate id="it" name="LoanAktGetPutWordForm" property="listBillPos" indexId="indexId"> 
	<logic:present name="it">
	<tr>
		<td><bean:write name="it" property="itemname" filter="true"/></td>
		<td><bean:write name="it" property="qty" filter="true"/></td>
	</tr>
	</logic:present>
	</logic:iterate>
	</logic:present>
</table>

<P>&nbsp;</P><P>&nbsp;</P><P>&nbsp;</P><P>&nbsp;</P>

<table border="0" width="100%" style="font-size: 14pt;">
<tr>
	<th width="50%">Сдал</th>
	<th>Принял</td>
</tr>
<tr>
	<th width="50%">"Вымпелком"</th>
	<th>
		<bean:write name="LoanAktGetPutWordForm" property="loanContractVO.orgCustomer.name" filter="true"/>
	</td>
</tr>
<tr>
	<th width="50%"><B>_________________</B></th>
	<th><B>_________________</B></th>
</tr>
</table>

<P>&nbsp;</P><P>&nbsp;</P><P>&nbsp;</P><P>&nbsp;</P>
<P style="font-size: 8pt;"><july:datewrite name="LoanAktGetPutWordForm" property="to.vo.dateAct"/></P>


</DIV>

</body>
</html>