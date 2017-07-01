<!--Служебные записки на создание/изменение ЗП в системе НФС-->
<%@ page language = "java" %>
<%@ page contentType = "application/msword; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import="com.hps.july.valueobject.*"%>
<%
	response.setHeader("Cache-Control", "no-cache");
	response.setContentType("application/msword;name=LeaseZPOfficeMemoWord.doc;charset=Windows-1251");
	response.setHeader("Content-Disposition", "attachment;filename=LeaseZPOfficeMemoWord.rtf");
	
	String form = "LeaseZPOfficeMemoWordForm";
	com.hps.july.arenda.formbean.LeaseZPOfficeMemoWordForm aform =  (com.hps.july.arenda.formbean.LeaseZPOfficeMemoWordForm)request.getAttribute(form); 
	java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
	java.util.Date curDate = new java.util.Date(System.currentTimeMillis());
	String curDateStr = format.format(curDate);
	//String rurStr = String.valueOf(com.hps.july.util.AppUtils.getNamedValueInt("RUR"));	
%>
<html xmlns:o="urn:schemas-microsoft-com:office:office"
xmlns:w="urn:schemas-microsoft-com:office:word"
xmlns="http://www.w3.org/TR/REC-html40">
<head>
  <meta http-equiv="Content-Type" content="application/msword; charset=Windows-1251">
  <meta http-equiv="Content-Disposition" content="attachment;filename=LeaseZPOfficeMemoWord.rtf">
  <meta name=ProgId content=Word.Document>
  <title>Служебные записки на создание/изменение ЗП в системе НФС.</title>
<STYLE>  
@page Section1
	{size:595.3pt 841.9pt;
	margin:27.0pt 42.5pt 35.95pt 3.0cm;
	mso-header-margin:35.4pt;
	mso-footer-margin:35.4pt;
	mso-paper-source:0;}

div.Section1
	{page:Section1;} 
p
	{mso-style-parent:"";
	margin:0cm;
	margin-bottom:.0001pt;
	mso-pagination:widow-orphan;
	font-size:12.0pt;
	font-family:"Times New Roman";
	mso-fareast-font-family:"Times New Roman";
}

TABLE {
	FONT-FAMILY: Times New Roman,Arial,Verdana; FONT-SIZE: 10pt;
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
<html:errors/>

<body>
<DIV class=Section1 STYLE="FONT-FAMILY: Arial,Verdana; FONT-SIZE: 10pt; line-height:100%">

<logic:equal name="LeaseZPOfficeMemoWordForm" property="to.vo.typeActionZP" value="I">	
	<p align=center style='text-align:center'><b style='mso-bidi-font-weight:
	normal'><span style='font-size:14.0pt'>Служебная записка на создание ЗП </span></b><b
	style='mso-bidi-font-weight:normal'></p>
</logic:equal>
<logic:equal name="LeaseZPOfficeMemoWordForm" property="to.vo.typeActionZP" value="U">		
	<p align=center style='text-align:center'><b style='mso-bidi-font-weight:
	normal'><span style='font-size:14.0pt'>Служебная записка на изменение ЗП </span></b><b
	style='mso-bidi-font-weight:normal'></p>	
</logic:equal>	
	<p><b style='mso-bidi-font-weight:normal'><span
	style='font-size:14.0pt'><o:p>&nbsp;</o:p></span></b></p>
	
	<table border="1" style="border-collapse:collapse;border:none;mso-border-alt:solid silver .5pt;mso-padding-alt:0cm 5.4pt 0cm 5.4pt">
		<tr>
			<td width="127">Номер</td>
			<td width="517"><bean:write name="LeaseZPOfficeMemoWordForm" property="to.vo.idOfficeMemo" filter="true" /></td>
		</tr>
		<tr>
			<td>Дата</td>
			<td><july:datewrite name="LeaseZPOfficeMemoWordForm" property="to.vo.created"/></td>
		</tr>
		<tr>
			<td>Инициатор(ФИО)</td>
			<td>
				<bean:write name="LeaseZPOfficeMemoWordForm" property="people_VO.lastname" filter="true" />
			</td>
		</tr>
		<tr>
			<td width="127">№ Договора</td>
			<td width="517"> <U><bean:write name="LeaseZPOfficeMemoWordForm" property="contractInfo.docNumber" filter="true" /></U> от <july:datewrite name="LeaseZPOfficeMemoWordForm" property="contractInfo.docDate" /></td>
		</tr>
	<logic:present name="LeaseZPOfficeMemoWordForm" property="vendor_VO">		
		<tr>
			<td>Контрагент</td>
			<td><bean:write name="LeaseZPOfficeMemoWordForm" property="vendor_VO.name" filter="true" /></td>
		</tr>
	</logic:present>						
		<%--tr>
			<td>осн.Позиция</td>
			<td>№ GSM <bean:write name="LeaseZPOfficeMemoWordForm" property="contractInfo.positionGsm" filter="true" /></U> наименование <U><bean:write name="LeaseZPOfficeMemoWordForm" property="contractInfo.positionName" filter="true" /></td>			
		</tr--%>
		<tr>
			<td>Позиция</td>
			<td><bean:write name="LeaseZPOfficeMemoWordForm" property="contractInfo.allPosition" filter="true" /></td>			
		</tr>		
			
	</table>
	
	<p><b style='mso-bidi-font-weight:normal'><o:p>&nbsp;</o:p></b></p>
	
	<p><b style='mso-bidi-font-weight:normal'>Необходимо выполнить следующие действия</b><b
	style='mso-bidi-font-weight:normal'><span lang=EN-US style='mso-ansi-language:
	EN-US'>:<o:p></o:p></span></b></p>
	
	<table border="1" style="border-collapse:collapse;border:none;mso-border-alt:solid silver .5pt;mso-padding-alt:0cm 5.4pt 0cm 5.4pt">
		<tr>
			<td width="300">Завести контрагента:</td>
			<td width="50">
				<logic:equal name="LeaseZPOfficeMemoWordForm" property="to.vo.flagAddVendor" value="I">Да</logic:equal>
				<logic:equal name="LeaseZPOfficeMemoWordForm" property="to.vo.flagAddVendor" value="N">Нет</logic:equal>			
			</td>
		<tr>
			<td>Завести контракт:</td>
			<td>
				<logic:equal name="LeaseZPOfficeMemoWordForm" property="to.vo.flagAddContract" value="Y">Да</logic:equal>
				<logic:equal name="LeaseZPOfficeMemoWordForm" property="to.vo.flagAddContract" value="N">Нет</logic:equal>			
			</td>
		</tr>
		<tr>
			<td>Создать отделение:</td>
			<td>
				<logic:equal name="LeaseZPOfficeMemoWordForm" property="to.vo.flagAddVendorSite" value="Y">Да</logic:equal>
				<logic:equal name="LeaseZPOfficeMemoWordForm" property="to.vo.flagAddVendorSite" value="N">Нет</logic:equal>			
			</td>
		</tr>
	</table>
	
	<p><b style='mso-bidi-font-weight:normal'><o:p>&nbsp;</o:p></b></p>	
	
	<logic:equal name="LeaseZPOfficeMemoWordForm" property="to.vo.typeActionZP" value="U">
		<table border="1" style="border-collapse:collapse;border:none;mso-border-alt:solid silver .5pt;mso-padding-alt:0cm 5.4pt 0cm 5.4pt">
			<tr>
				<td width="300">№ ЗП:</td>
				<td width="50"><bean:write name="LeaseZPOfficeMemoWordForm" property="dataZP" filter="true" /></td>
			</tr>
			<logic:present name="LeaseZPOfficeMemoWordForm" property="vendor_VO">
			<tr>
				<td width="300">Поставщик НФС:</td>
				<td width="50">
						<bean:write name="LeaseZPOfficeMemoWordForm" property="vendor_VO.name" filter="true" />
				</td>
			</tr>			
			<tr>
				<td width="300">Номер поставщика НФС:</td>
				<td width="50">
						<bean:write name="LeaseZPOfficeMemoWordForm" property="vendor_VO.vendorCode" filter="true" />
				</td>
			</tr>
			<%--tr>
				<td width="300">Инн:</td>
				<td width="50">
						<bean:write name="LeaseZPOfficeMemoWordForm" property="vendor_VO.inn" filter="true" />
				</td>
			</tr--%>			
			</logic:present>				
			<tr>
				<td>старая сумма ЗП без НДС:</td>
				<td>
					<july:numberwrite name="LeaseZPOfficeMemoWordForm" property="to.vo.oldSumZP" />
					<bean:write name="LeaseZPOfficeMemoWordForm" property="to.curName" filter="true" />
				</td>
			</tr>
			<tr>
				<td>новая сумма без НДС:</td>
				<td>
					<july:numberwrite name="LeaseZPOfficeMemoWordForm" property="to.vo.sumZP" />			
				</td>
			</tr>
			<tr>
				<td>разница без НДС:</td>
				<td>
					<B><july:numberwrite name="LeaseZPOfficeMemoWordForm" property="sumZP_Minus_OldSumZP" /></B>
				</td>
			</tr>			
			<tr>
				<td>новая сумма НДС:</td>
				<td>
					<july:numberwrite name="LeaseZPOfficeMemoWordForm" property="to.vo.sumNdsZP" />			
				</td>
			</tr>
			<tr>
				<td>итого новая сумма с НДС:</td>
				<td>
					<july:numberwrite name="LeaseZPOfficeMemoWordForm" property="sumZP_Plus_SumNdsZP" />			
				</td>
			</tr>			
		
			<%--logic:present name="LeaseZPOfficeMemoWordForm" property="vendorSite_VO">							
			<tr>
				<td>Альтернативное имя:</td>
				<td>
					<bean:write name="LeaseZPOfficeMemoWordForm" property="vendorSite_VO.name" filter="true" />
				</td>
			</tr>
			<tr>
				<td>КПП:</td>
				<td>
					<bean:write name="LeaseZPOfficeMemoWordForm" property="vendorSite_VO.kpp" filter="true" />
				</td>
			</tr>
			</logic:present--%>

			<%--tr>
				<td>Период ЗП:</td>
				<td>
					<july:datewrite name="LeaseZPOfficeMemoWordForm" property="to.vo.dateStartZP"/> -
					<july:datewrite name="LeaseZPOfficeMemoWordForm" property="to.vo.dateEndZp"/>
				</td>
			</tr--%>
			<%--tr>
				<td>Сумма к начислению в месяц по договору:</td>
				<td>
					<july:numberwrite name="LeaseZPOfficeMemoWordForm" property="to.vo.sumCharge" />
				</td>
			</tr--%>
			<tr>
				<td>Валюта договора:</td>
				<td>
					<bean:write name="LeaseZPOfficeMemoWordForm" property="to.curName" filter="true" />
				</td>
			</tr>
			
			<logic:notEqual name="LeaseZPOfficeMemoWordForm" property="to.curName" value="РУБ">
			<tr>
				<td width="163">Правило определения курса:</td>
				<td colspan="5">
						<logic:present name="<%= form %>" property="to.vo.rateCalcRule">
							<logic:equal name="<%= form %>" property="to.vo.rateCalcRule" value="A">
								<bean:message key="label.filter.ratecalcrule.a"/>
							</logic:equal>
							<logic:equal name="<%= form %>" property="to.vo.rateCalcRule" value="B">
								<bean:message key="label.filter.ratecalcrule.b"/>						
							</logic:equal>
							<logic:equal name="<%= form %>" property="to.vo.rateCalcRule" value="C">
								<bean:message key="label.filter.ratecalcrule.c"/>						
							</logic:equal>
							<logic:equal name="<%= form %>" property="to.vo.rateCalcRule" value="D">
								<bean:message key="label.filter.ratecalcrule.d"/>						
							</logic:equal>
							<logic:equal name="<%= form %>" property="to.vo.rateCalcRule" value="E">
								<bean:message key="label.filter.ratecalcrule.e"/>						
							</logic:equal>
							<%	String rateCalcRuleDayStr = String.valueOf( aform.getTo().getVo().getRateCalcRuleDay() );	%>
							<logic:equal name="<%= form %>" property="to.vo.rateCalcRule" value="F">
								<bean:message key="label.filter.ratecalcrule.f" arg0="<%= rateCalcRuleDayStr %>"/>
							</logic:equal>
							<logic:equal name="<%= form %>" property="to.vo.rateCalcRule" value="G">
								<bean:message key="label.filter.ratecalcrule.g" arg0="<%= rateCalcRuleDayStr %>"/>						
							</logic:equal>
							<logic:equal name="<%= form %>" property="to.vo.rateCalcRule" value="H">
								<bean:message key="label.filter.ratecalcrule.h"/>
							</logic:equal>
							<logic:equal name="<%= form %>" property="to.vo.rateCalcRule" value="I">
								<bean:message key="label.filter.ratecalcrule.i"/>						
							</logic:equal>
							<logic:equal name="<%= form %>" property="to.vo.rateCalcRule" value="K">
								Фиксированный курс: <july:numberwrite name="<%= form %>" property="to.vo.rateFix"/>						
							</logic:equal>
							Наценка:
							<july:numberwrite name="LeaseZPOfficeMemoWordForm" property="to.vo.rateDelta" />
						</logic:present>				
				</td>		
			</tr>
			</logic:notEqual>
						
		</table>
	</logic:equal>
	
	<logic:equal name="LeaseZPOfficeMemoWordForm" property="to.vo.typeActionZP" value="I">
		<table border="1" style="border-collapse:collapse;border:none;mso-border-alt:solid silver .5pt;mso-padding-alt:0cm 5.4pt 0cm 5.4pt">
			<logic:present name="LeaseZPOfficeMemoWordForm" property="vendor_VO">
			<tr>
				<td width="300">Поставщик НФС:</td>
				<td width="50">
						<bean:write name="LeaseZPOfficeMemoWordForm" property="vendor_VO.name" filter="true" />
				</td>
			</tr>			
			<tr>
				<td width="300">Номер поставщика НФС:</td>
				<td width="50">
						<bean:write name="LeaseZPOfficeMemoWordForm" property="vendor_VO.vendorCode" filter="true" />
				</td>
			</tr>
			<tr>
				<td width="300">Инн:</td>
				<td width="50">
						<bean:write name="LeaseZPOfficeMemoWordForm" property="vendor_VO.inn" filter="true" />
				</td>
			</tr>			
			</logic:present>
			
			<logic:present name="LeaseZPOfficeMemoWordForm" property="vendorSite_VO">							
			<tr>
				<td>Альтернативное имя:</td>
				<td>
					<bean:write name="LeaseZPOfficeMemoWordForm" property="vendorSite_VO.name" filter="true" />
				</td>
			</tr>
			<tr>
				<td>КПП:</td>
				<td>
					<bean:write name="LeaseZPOfficeMemoWordForm" property="vendorSite_VO.kpp" filter="true" />				
				</td>
			</tr>
			</logic:present>
													
			<tr>
				<td>Период ЗП:</td>
				<td>
					<july:datewrite name="LeaseZPOfficeMemoWordForm" property="to.vo.dateStartZP"/> -
					<july:datewrite name="LeaseZPOfficeMemoWordForm" property="to.vo.dateEndZp"/>
				</td>
			</tr>
			<tr>
				<td>Сумма ЗП без НДС:</td>
				<td>
					<july:numberwrite name="LeaseZPOfficeMemoWordForm" property="to.vo.sumZP" />			
				</td>
			</tr>
			<tr>
				<td>Сумма НДС:</td>
				<td>
					<july:numberwrite name="LeaseZPOfficeMemoWordForm" property="to.vo.sumNdsZP" />			
				</td>
			</tr>
			<tr>
				<td>Итого:</td>
				<td>
					<july:numberwrite name="LeaseZPOfficeMemoWordForm" property="sumZP_Plus_SumNdsZP" />			
				</td>
			</tr>
			<tr>
				<td>Сумма к начислению в месяц по договору:</td>
				<td>
					<july:numberwrite name="LeaseZPOfficeMemoWordForm" property="to.vo.sumCharge" />
				</td>
			</tr>
			<tr>
				<td>Валюта договора:</td>
				<td>
					<bean:write name="LeaseZPOfficeMemoWordForm" property="to.curName" filter="true" />
				</td>
			</tr>
			<logic:notEqual name="LeaseZPOfficeMemoWordForm" property="to.curName" value="РУБ">
			<tr>
				<td width="163">Правило определения курса:</td>
				<td colspan="5">
						<logic:present name="<%= form %>" property="to.vo.rateCalcRule">
							<logic:equal name="<%= form %>" property="to.vo.rateCalcRule" value="A">
								<bean:message key="label.filter.ratecalcrule.a"/>
							</logic:equal>
							<logic:equal name="<%= form %>" property="to.vo.rateCalcRule" value="B">
								<bean:message key="label.filter.ratecalcrule.b"/>						
							</logic:equal>
							<logic:equal name="<%= form %>" property="to.vo.rateCalcRule" value="C">
								<bean:message key="label.filter.ratecalcrule.c"/>						
							</logic:equal>
							<logic:equal name="<%= form %>" property="to.vo.rateCalcRule" value="D">
								<bean:message key="label.filter.ratecalcrule.d"/>						
							</logic:equal>
							<logic:equal name="<%= form %>" property="to.vo.rateCalcRule" value="E">
								<bean:message key="label.filter.ratecalcrule.e"/>						
							</logic:equal>
							<%	String rateCalcRuleDayStr = String.valueOf( aform.getTo().getVo().getRateCalcRuleDay() );	%>
							<logic:equal name="<%= form %>" property="to.vo.rateCalcRule" value="F">
								<bean:message key="label.filter.ratecalcrule.f" arg0="<%= rateCalcRuleDayStr %>"/>
							</logic:equal>
							<logic:equal name="<%= form %>" property="to.vo.rateCalcRule" value="G">
								<bean:message key="label.filter.ratecalcrule.g" arg0="<%= rateCalcRuleDayStr %>"/>						
							</logic:equal>
							<logic:equal name="<%= form %>" property="to.vo.rateCalcRule" value="H">
								<bean:message key="label.filter.ratecalcrule.h"/>
							</logic:equal>
							<logic:equal name="<%= form %>" property="to.vo.rateCalcRule" value="I">
								<bean:message key="label.filter.ratecalcrule.i"/>						
							</logic:equal>
							<logic:equal name="<%= form %>" property="to.vo.rateCalcRule" value="K">
								Фиксированный курс: <july:numberwrite name="<%= form %>" property="to.vo.rateFix"/>						
							</logic:equal>
							&nbsp;Наценка:
							<july:numberwrite name="LeaseZPOfficeMemoWordForm" property="to.vo.rateDelta" />
						</logic:present>				
				</td>		
			</tr>
			</logic:notEqual>
						
		</table>
	</logic:equal>
																								

	<p><b style='mso-bidi-font-weight:normal'><o:p>&nbsp;</o:p></b></p>
	
	<p style='font-size:8.0pt'>
	 Настоящим подтверждаю, что начисления в финансовой системе за запрашиваемый период не проводились, оплата не осуществлялась.
		Электронную копию договора прилагаю
	</p>
</DIV>
</body>

</html>