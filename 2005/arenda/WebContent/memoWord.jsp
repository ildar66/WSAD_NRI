<!-- Служебные записки -->
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
<logic:equal name="MemoWordForm" property="memo.memoType.type" value="1">
	<%@include file="memoWordType1_include.jspf"%>
</logic:equal>
<logic:equal name="MemoWordForm" property="memo.memoType.type" value="2">
	<%@include file="memoWordType2_include.jspf"%>
</logic:equal>
<logic:equal name="MemoWordForm" property="memo.memoType.type" value="3">
	<%@include file="memoWordType3_include.jspf"%>
</logic:equal>
<logic:equal name="MemoWordForm" property="memo.memoType.type" value="5">
	<%@include file="memoWordType5_include.jspf"%>
</logic:equal>
<logic:equal name="MemoWordForm" property="memo.memoType.type" value="6">
	<%@include file="memoWordType6_include.jspf"%>
</logic:equal>
<logic:equal name="MemoWordForm" property="memo.memoType.type" value="8">
	<%@include file="memoWordType8_include.jspf"%>
</logic:equal>
<logic:equal name="MemoWordForm" property="memo.memoType.type" value="9">
	<%@include file="memoWordType9_include.jsp"%>
</logic:equal>
<logic:equal name="MemoWordForm" property="memo.memoType.type" value="A">
	<%@include file="memoWordTypeA_include.jsp"%>
</logic:equal>
<logic:equal name="MemoWordForm" property="memo.memoType.type" value="C">
	<%@include file="memoWordTypeC_include.jsp"%>
</logic:equal>

<!-- Список позиций -->
<table border=1 style='border-collapse:collapse;border:none;mso-border-alt:solid silver .5pt;mso-padding-alt:0cm 5.4pt 0cm 5.4pt' width="100%">
	<!-- Table header -->
	<tr>
		<logic:equal name="MemoWordForm" property="memo.memoType.memoPosInfo.isPhoneNumber" value="true">
			<th>Избирательный номер</th>
		</logic:equal>
		<logic:equal name="MemoWordForm" property="memo.memoType.memoPosInfo.isTarifplan" value="true">
			<th>Тарифный план</th>
		</logic:equal>
		<logic:equal name="MemoWordForm" property="memo.memoType.memoPosInfo.isCardname" value="true">
			<th>Наименование карты услуг связи</th>
		</logic:equal>
		<logic:equal name="MemoWordForm" property="memo.memoType.memoPosInfo.isComcardcnt" value="true">
			<th>Количество карт связи</th>
		</logic:equal>
		<logic:equal name="MemoWordForm" property="memo.memoType.memoPosInfo.isCardamount" value="true">
			<th>Номинал карт</th>
		</logic:equal>
		<logic:equal name="MemoWordForm" property="memo.memoType.memoPosInfo.isSimcardcnt" value="true">
			<th>Количество SIM карт</th>
		</logic:equal>
		<logic:equal name="MemoWordForm" property="memo.memoType.memoPosInfo.isEquipname" value="true">
			<th>Наименование</th>
		</logic:equal>
		<logic:equal name="MemoWordForm" property="memo.memoType.memoPosInfo.isEquipcnt" value="true">
			<th>Количество</th>
		</logic:equal>
		<logic:equal name="MemoWordForm" property="memo.memoType.memoPosInfo.isDefectdescr" value="true">
			<th>Описание дефекта оборудования</th>
		</logic:equal>
		<logic:equal name="MemoWordForm" property="memo.memoType.memoPosInfo.isService" value="true">
			<th>Услуга</th>
		</logic:equal>
		<logic:equal name="MemoWordForm" property="memo.memoType.memoPosInfo.isOpertype" value="true">
			<th>Тип операции подключения</th>
		</logic:equal>
		<logic:equal name="MemoWordForm" property="memo.memoType.memoPosInfo.isStartdate" value="true">
			<th>Дата начала</th>
		</logic:equal>
		<logic:equal name="MemoWordForm" property="memo.memoType.memoPosInfo.isEnddate" value="true">
			<th>Дата окончания</th>
		</logic:equal>
		<logic:equal name="MemoWordForm" property="memo.memoType.memoPosInfo.isGarantie" value="true">
			<th>Взимание гарант. взноса</th>
		</logic:equal>
	</tr>

	<!-- Table body  --> 
	<logic:iterate id="it" name="MemoWordForm" property="memo.listMemoPos"> 
	<logic:present name="it">
	<tr>
			<logic:equal name="MemoWordForm" property="memo.memoType.memoPosInfo.isPhoneNumber" value="true">
				<td>
					<bean:write name="it" property="phoneNumber" filter="true"/>
				</td>
			</logic:equal>
			<logic:equal name="MemoWordForm" property="memo.memoType.memoPosInfo.isTarifplan" value="true">
				<td>
					<bean:write name="it" property="tarifplan" filter="true"/>
				</td>
			</logic:equal>
			<logic:equal name="MemoWordForm" property="memo.memoType.memoPosInfo.isCardname" value="true">
				<td>
					<bean:write name="it" property="cardname" filter="true"/>
				</td>
			</logic:equal>
			<logic:equal name="MemoWordForm" property="memo.memoType.memoPosInfo.isComcardcnt" value="true">
				<td>
					<bean:write name="it" property="comcardcnt" filter="true"/>
				</td>
			</logic:equal>
			<logic:equal name="MemoWordForm" property="memo.memoType.memoPosInfo.isCardamount" value="true">
				<td>
					<bean:write name="it" property="cardamount" filter="true"/>
				</td>
			</logic:equal>
			<logic:equal name="MemoWordForm" property="memo.memoType.memoPosInfo.isSimcardcnt" value="true">
				<td>
					<bean:write name="it" property="simcardcnt" filter="true"/>
				</td>
			</logic:equal>
			<logic:equal name="MemoWordForm" property="memo.memoType.memoPosInfo.isEquipname" value="true">
				<td>
					<bean:write name="it" property="equipname" filter="true"/>
				</td>
			</logic:equal>
			<logic:equal name="MemoWordForm" property="memo.memoType.memoPosInfo.isEquipcnt" value="true">
				<td align="center">
					<bean:write name="it" property="equipcnt" filter="true"/>
				</td>
			</logic:equal>
			<logic:equal name="MemoWordForm" property="memo.memoType.memoPosInfo.isDefectdescr" value="true">
				<td>
					<bean:write name="it" property="defectdescr" filter="true"/>
				</td>
			</logic:equal>
			<logic:equal name="MemoWordForm" property="memo.memoType.memoPosInfo.isService" value="true">
				<td>
					<bean:write name="it" property="service" filter="true"/>
				</td>
			</logic:equal>
			<logic:equal name="MemoWordForm" property="memo.memoType.memoPosInfo.isOpertype" value="true">
				<td>
					<bean:write name="it" property="opertype" filter="true"/>
				</td>
			</logic:equal>
			<logic:equal name="MemoWordForm" property="memo.memoType.memoPosInfo.isStartdate" value="true">
				<td>
					<july:datewrite name="it" property="startdate"/>
				</td>
			</logic:equal>
			<logic:equal name="MemoWordForm" property="memo.memoType.memoPosInfo.isEnddate" value="true">
				<td>
					<july:datewrite name="it" property="enddate"/>
				</td>
			</logic:equal>
			<logic:equal name="MemoWordForm" property="memo.memoType.memoPosInfo.isGarantie" value="true">
				<td>
					<logic:present name="it" property="isgarantie">
						<logic:equal name="it" property="isgarantie" value="true">да</logic:equal>
						<logic:equal name="it" property="isgarantie" value="false">нет</logic:equal>
					</logic:present>
				</td>
			</logic:equal>
	</tr>
	</logic:present>
	</logic:iterate>
</table>

<P>&nbsp;</P>
<logic:equal name="MemoWordForm" property="detach" value="false">
	<P>Абонентский договор: &nbsp;&nbsp;<B>№ <bean:write name="MemoListForm" property="abonent.ban" filter="true" scope="session"/></B></P>
	<P>Позиция: &nbsp;&nbsp;№ <bean:write name="MemoListForm" property="abonent.mainpositionVO.fullName" filter="true" scope="session"/></P>
</logic:equal>
<logic:equal name="MemoWordForm" property="detach" value="true">
	<P>Позиция: &nbsp;&nbsp;№ <bean:write name="MemoWordForm" property="memo.positionVO.name" filter="true"/></P>
</logic:equal>
<P>&nbsp;</P><P>&nbsp;</P><P>&nbsp;</P><P>&nbsp;</P>

<table border="0" width="100%">
<tr style="font-size: 14pt;">
	<td>Начальник отдела поиска позиций<br>и договорного обеспечения</td>
	<td align="right">Федоринов А.И.</td>
</tr>
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
