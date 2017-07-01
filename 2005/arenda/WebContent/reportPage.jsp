<%@ page language = "java" %>
<%@ page contentType = "application/vnd.ms-excel;name=report.xls;charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import="com.hps.july.util.*"%>
<%@ page import="java.text.*, com.hps.july.arenda.cdbcobjects.*"%>
<jsp:useBean id="ArendaReport3ParamsForm" class="com.hps.july.arenda.formbean.ArendaReport3ParamsForm" scope="session"/>
<%
	java.text.SimpleDateFormat formatCurDate = new java.text.SimpleDateFormat("yyMMdd_HHmmss");//"dd.MM.yyyy HH:mm:ss"
	java.util.Date curDate = new java.util.Date(System.currentTimeMillis());
	String curDateStr = formatCurDate.format(curDate);	

	response.setHeader("Cache-Control", "no-cache");
	response.setContentType("application/vnd.ms-excel;name=report"+curDateStr+".xls;charset=windows-1251");
	response.setHeader("Content-Disposition", "attachment;filename=report"+curDateStr+".xls");
	SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
	//com.hps.july.arenda.cdbcobjects.Page reportPage =  (com.hps.july.arenda.cdbcobjects.Page)request.getAttribute("reportPage");
	//System.out.println("page="+ reportPage);
%>
<html xmlns:o="urn:schemas-microsoft-com:office:office"
xmlns:x="urn:schemas-microsoft-com:office:excel"
xmlns="http://www.w3.org/TR/REC-html40">
<head>
<meta http-equiv=Content-Type content="application/vnd.ms-excel;name=report<%=curDateStr%>.xls;charset=windows-1251">
<meta name=ProgId content="Excel.Sheet">
<meta http-equiv="Content-Disposition" content="attachment;filename=report<%=curDateStr%>.xls">
<meta name=Generator content="Microsoft Excel 9">

<style>
<!--table
	{mso-displayed-decimal-separator:"\.";
	mso-displayed-thousand-separator:" ";}
@page
	{margin:.98in .79in .98in .79in;
	mso-header-margin:.5in;
	mso-footer-margin:.5in;}
tr
	{mso-height-source:auto;}
col
	{mso-width-source:auto;}
br
	{mso-data-placement:same-cell;}
.style0
	{mso-number-format:General;
	text-align:general;
	vertical-align:bottom;
	white-space:nowrap;
	mso-rotate:0;
	mso-background-source:auto;
	mso-pattern:auto;
	color:windowtext;
	font-size:10.0pt;
	font-weight:400;
	font-style:normal;
	text-decoration:none;
	font-family:"Arial Cyr";
	mso-generic-font-family:auto;
	mso-font-charset:204;
	border:none;
	mso-protection:locked visible;
	mso-style-name:Обычный;
	mso-style-id:0;}
td
	{mso-style-parent:style0;
	padding-top:1px;
	padding-right:1px;
	padding-left:1px;
	mso-ignore:padding;
	color:windowtext;
	font-size:10.0pt;
	font-weight:400;
	font-style:normal;
	text-decoration:none;
	font-family:"Arial Cyr";
	mso-generic-font-family:auto;
	mso-font-charset:204;
	mso-number-format:General;
	text-align:general;
	vertical-align:bottom;
	border:1;
	mso-background-source:auto;
	mso-pattern:auto;
	mso-protection:locked visible;
	white-space:nowrap;
	mso-rotate:0;}
.xl24
	{mso-style-parent:style0;
	mso-number-format:"Short Date";}
.xl25
	{mso-style-parent:style0;
	font-weight:700;
	font-family:"Arial Cyr", sans-serif;
	mso-font-charset:204;}
.xl26
	{mso-style-parent:style0;
	font-weight:700;
	font-family:"Arial Cyr", sans-serif;
	mso-font-charset:204;
	white-space:normal;}
.xl27
	{mso-style-parent:style0;
	mso-number-format:"\#\,\#\#0\.00_р_\.";}
.xl28
	{mso-style-parent:style0;
	font-weight:700;
	font-family:"Arial Cyr", sans-serif;
	mso-font-charset:204;
	mso-number-format:"\#\,\#\#0\.00_р_\.";
	border:.5pt solid black;
	white-space:normal;}
.xl29
	{mso-style-parent:style0;
	mso-number-format:"\#\,\#\#0\.00_р_\.";
	border:.5pt solid black;}
-->
</style>

</head>

<body link=blue vlink=purple>
<july:errors/>
<P><B><bean:write name="ArendaReport3ParamsForm" property="report.type.typeDescription" filter="true"/></B>

<logic:equal name="ArendaReport3ParamsForm" property="report.type.isDataPeriod" value="true" scope="session">
  <P><B>Отчет за период</B> с <%= ArendaReport3ParamsForm.getReport().getDataPeriod().getFromDateFrm() %> по
  <%= ArendaReport3ParamsForm.getReport().getDataPeriod().getToDateFrm() %> </P>
</logic:equal>

<logic:equal name="ArendaReport3ParamsForm" property="report.type.isData" value="true" scope="session">
	<P><B><bean:write name="ArendaReport3ParamsForm" property="report.type.dataDescription"/>:</B> <%= ArendaReport3ParamsForm.getReport().getDataFrm() %></P>
</logic:equal>

<logic:equal name="ArendaReport3ParamsForm" property="report.type.isOtv" value="true" scope="session">
	<P><B>ответственный:</B>
		<%= ArendaReport3ParamsForm.getReport().getOtv().getName() %>
	</P>
</logic:equal>	

<table x:str border=1 cellpadding=0 cellspacing=0 style='border-collapse:collapse;'>

<logic:equal name="ArendaReport3ParamsForm" property="comand" value="getContrArOnOtv" scope="session">
 <tr class=xl27 height=100 style='mso-height-source:userset;height:75.0pt'>
  <td class=xl26>Код</td>
  <td class=xl26>Дата</td>
  <td class=xl26>Номер</td>
  <td class=xl26>Начало</td>
  <td class=xl26>Окончание</td>
  <td class=xl26>Дата<br> закрытия<br> договора</td>
  <td class=xl26>Позиция</td>
  <td class=xl26>Услуги</td>
  <td class=xl26>Арендодатель</td>
  <td class=xl26>Beeline</td>
  <td class=xl26>сумма<br> договора</td>
  <td class=xl26>в т.ч. трафик</td>
  <td class=xl26>валюта договора</td>
  <td class=xl26>поисковик</td>
  <td class=xl26>экономист</td>
  <td class=xl26>состояние</td>
  <td class=xl26>сумма всего<br>из условий договора</td>
  <td class=xl26>сумма оплаты<br>из условий договора</td>
  <td class=xl26>сумма трафика<br>из условий договора</td>
  <td class=xl26>сумма<br>  фактических<br> платежей</td>
  <td class=xl26>сумма зачета трафика из подписанных актов</td>
  <td class=xl26>сумма к зачету трафика из неподписанных актов</td>
 </tr>
</logic:equal>

<logic:equal name="ArendaReport3ParamsForm" property="comand" value="repWarningProlong" scope="session">
 <tr class=xl27 height=100 style='mso-height-source:userset;height:75.0pt'>
  <td class=xl26>Дата, до которой предупреждать</td>
  <td class=xl26>Ответ user</td>
  <td class=xl26>№ БС GSM</td>
  <td class=xl26>№ БС DAMPS</td>
  <td class=xl26>наименование позиции</td>
  <td class=xl26>номер договора</td>
  <td class=xl26>дата договора</td>
  <td class=xl26>заказчик</td>
  <td class=xl26>исполнитель</td>
  <td class=xl26>начало договора</td>
  <td class=xl26>окончание договора</td>
  <td class=xl26>ответственный поисковик за договор</td>
  <td class=xl26>услуга</td>
  <td class=xl26>годовая стоимость</td>
  <td class=xl26>валюта</td>
  <td class=xl26>годовая стоимость в долларах</td>
  <td class=xl26>состояние</td>
 </tr>
</logic:equal>

<logic:equal name="ArendaReport3ParamsForm" property="comand" value="repWarningAkt" scope="session">
 <tr class=xl27 height=100 style='mso-height-source:userset;height:75.0pt'>
  <td class=xl26>Период акта</td>
  <td class=xl26>Ответственный экономист</td>
  <td class=xl26>№ БС GSM</td>
  <td class=xl26>№ БС DAMPS</td>
  <td class=xl26>наименование позиции</td>
  <td class=xl26>номер договора</td>
  <td class=xl26>дата договора</td>
  <td class=xl26>заказчик</td>
  <td class=xl26>исполнитель</td>
  <td class=xl26>номер последнего акта</td>
  <td class=xl26>Дата последнего акта</td>
  <td class=xl26>окончание договора</td>
  <td class=xl26>дата окончания периода акта</td>
  <td class=xl26>дата, когда формировать акт</td>
  <td class=xl26>отв. менеджер</td>
  <td class=xl26>тип акта</td>    
  </tr>
</logic:equal>

<logic:equal name="ArendaReport3ParamsForm" property="comand" value="listSfOnOtv" scope="session">
 <tr class=xl27 height=100 style='mso-height-source:userset;height:35.0pt'>
  <td class=xl26>№ БС GSM</td>
  <td class=xl26>№ БС DAMPS</td>
  <td class=xl26>Название БС</td>
  <td class=xl26>Номер поставщика</td>
  <td class=xl26>Название поставщика</td>
  <td class=xl26>№ ЗП</td>
  <td class=xl26>Дата созданияСФ</td>
  <td class=xl26>Номер СФ</td>
  <td class=xl26>Состояние СФ</td>
  <td class=xl26>Сумма СФ</td>
  <td class=xl26>НДС</td>
  <td class=xl26>Валюта СФ</td>
  <td class=xl26>Код налога</td>
  <td class=xl26>№ п/п</td>
  <td class=xl26>Дата п/п</td>
  <td class=xl26>Сумма по п/п</td>
  <td class=xl26>Сумма по п/п в руб</td>
  <td class=xl26>курс</td>
  <td class=xl26>Курс рубля к доллару США</td>
  <td class=xl26>Сумма ПП в долларах</td>
  <td class=xl26>Состояние<BR> платежа</td>
  <td class=xl26>наш банк</td>
  <td class=xl26>Назначение платежа</td>
  <td class=xl26>№ р/с получателя</td>
  <td class=xl26>Банк получателя</td>
  <td class=xl26>БИК банка получателя</td>
  <td class=xl26>Признак<BR> учета<BR>в NRI</td>
  <td class=xl26>Номер договора</td>
  <td class=xl26>Дата договора</td>
  <td class=xl26>Ответственный</td>
  <td class=xl26>вид услуги<BR> по договору</td>
  <td class=xl26>центр затрат</td>
  <td class=xl26>категория затрат</td>
  <td class=xl26>Сумма ЗП</td>
  <td class=xl26>Валюта ЗП</td>
  <td class=xl26>Номер договора</td>
  <td class=xl26>Отделение</td>
  </tr>
</logic:equal>

<logic:equal name="ArendaReport3ParamsForm" property="comand" value="listAllContractsArenda" scope="session">
 <tr class=xl27 height=60 style='mso-height-source:userset;height:50.0pt'>
  <td class=xl26>Код</td>
  <td class=xl26>Дата</td>
  <td class=xl26>Номер</td>
  <td class=xl26>Начало<br>договора</td>
  <td class=xl26>Окончание<br>баз. дог.</td>
  <td class=xl26>Окончание<br>договора</td>
  <td class=xl26>Дата<br>закрытия<br>договора</td>
  <td class=xl26>Период<br>действия</td>
  <td class=xl26>основная позиция</td>
  <td class=xl26>список<br>услуг<br>договора</td>
  <td class=xl26>наименование<br>заказчика</td>
  <td class=xl26>наименование<br> исполнителя</td>
  <td class=xl26>сумма договора<br>в осн. валюте</td>
  <td class=xl26>в т.ч. трафик<br>в осн. валюте</td>
  <td class=xl26>осн. валюта<br>договора</td>
  <td class=xl26>ответственный<BR>поисковик</td>
  <td class=xl26>ответственный<BR>экономист</td>
  <td class=xl26>состояние<br>договора</td>
  <td class=xl26>тип продления<br>договора</td>
  <td class=xl26>период<BR>продления<BR>договора</td>
  <td class=xl26>Тип<BR>расчетов</td>
  <td class=xl26>Периодичность<BR>оплаты</td>
  <td class=xl26>График<BR>оплаты</td>
 </tr>
</logic:equal>

<logic:equal name="ArendaReport3ParamsForm" property="comand" value="workTimeOnEconomist" scope="session">
 <tr class=xl27 height=60 style='mso-height-source:userset;height:50.0pt'>
  <td class=xl26>ФИО</td>
  <td class=xl26>сумма</td>
  <td class=xl26>количество<BR> поставщиков</td>
  <td class=xl26>количество<BR> договоров</td>
  <td class=xl26>количество<BR> регламентов</td>
  <td class=xl26>количество<BR> доп. соглашений</td>
  <td class=xl26>количество <BR>платежей</td>
  <td class=xl26>кол-во актов <BR>взаимозачета</td>
  <td class=xl26>кол-во актов <BR>сверки</td>
  <td class=xl26>количество актов<BR> выполненных работ</td>
  <td class=xl26>кол-во счетов <BR>фактур по актам</td>
 </tr>
</logic:equal>

<logic:equal name="ArendaReport3ParamsForm" property="comand" value="getListNewContracts" scope="session">
 <tr class=xl27 height=60 style='mso-height-source:userset;height:50.0pt'>
  <td class=xl26>код договора</td>
  <td class=xl26>дата договора</td>
  <td class=xl26>номер договора</td>
  <td class=xl26>основная позиция</td>
  <td class=xl26>список услуг договора</td>
  <td class=xl26>наименование исполнителя</td>
  <td class=xl26>ответственный поисковик</td>
  <td class=xl26>ответственный экономист</td>
  <td class=xl26>филиал + зона сети</td>
  <td class=xl26>вид договора</td>
  <td class=xl26>кто добавлял</td>
  <td class=xl26>когда добавляли</td>
 </tr>
</logic:equal>

<logic:equal name="ArendaReport3ParamsForm" property="comand" value="getListBadCharges" scope="session">
 <tr class=xl27 height=60 style='mso-height-source:userset;height:50.0pt'>
  <td class=xl26>код договора</td>
  <td class=xl26>дата договора</td>
  <td class=xl26>номер договора</td>
  <td class=xl26>основная позиция</td>
  <td class=xl26>услуга</td>
  <td class=xl26>наименование исполнителя</td>
  <td class=xl26>ответственный поисковик</td>
  <td class=xl26>ответственный экономист</td>
  <td class=xl26>начало периода <BR>начисления</td>
  <td class=xl26>окончание периода <BR>начисления</td>
  <td class=xl26>наличие сф1</td>
  <td class=xl26>наличие сф2</td>
  <td class=xl26>наличие сф3</td>
  <td class=xl26>наличие акта1</td>
  <td class=xl26>наличие акта2</td>
  <td class=xl26>наличие акта3</td>
 </tr>
</logic:equal>

<logic:equal name="ArendaReport3ParamsForm" property="comand" value="repYearPriceBS" scope="session">
 <tr class=xl27 height=60 style='mso-height-source:userset;height:50.0pt'>
  <td class=xl26>GSM</td>
  <td class=xl26>DAMPS</td>
  <td class=xl26>наименование позиции</td>
  <td class=xl26>адрес позиции</td>
  <td class=xl26>состояние позиции</td>
  <td class=xl26>Ответственный поисковик</td>
  <td class=xl26>Стоимость позиции на основании договоров за период в долларах по курсу на текущую дату</td>
  <td class=xl26>Сумма платежей за период по БС в долларах по курсу на текущую дату</td>
  <td class=xl26>Сумма взаимозачетов за период по БС в долларах по курсу на текущую дату</td>
  <td class=xl26>Сумма всех действующих договоров на сегодня, со сроком действия более 1 месяца в долларах по курсу на текущую дату</td>
  <td class=xl26>количество активных договоров на одну позицию по состоянию на сегодня</td>
 </tr>
</logic:equal>

<logic:equal name="ArendaReport3ParamsForm" property="comand" value="repArendaListOfMmOpl" scope="session">
 <tr class=xl27 height=60 style='mso-height-source:userset;height:50.0pt'>
  <td class=xl26>наименование позиции</td>
  <td class=xl26>номер дог.</td>
  <td class=xl26>дата дог.</td>
  <td class=xl26>услуга договора</td>
  <td class=xl26>ИНН Арендодателя</td>
  <td class=xl26>Арендодатель</td>
  <td class=xl26>номер поставщика</td>
  <td class=xl26>наименование поставщика</td>
  <td class=xl26>номер ЗП</td>
  <td class=xl26>дата  СЗ</td>
  <td class=xl26>номер СЗ</td>
  <td class=xl26>Инициатор</td>
  <td class=xl26>оплата третьему лицу</td>
  <td class=xl26>сумма СЗ</td>
  <td class=xl26>НДС СЗ</td>
  <td class=xl26>Валюта</td>
  <td class=xl26>дата начала</td>
  <td class=xl26>дата окончания периода</td>
  <td class=xl26>назначение</td>
  <td class=xl26>состояние</td>          
 </tr>
</logic:equal>

<logic:equal name="ArendaReport3ParamsForm" property="comand" value="repArendaListAbonent" scope="session">
 <tr class=xl27 height=40 style='mso-height-source:userset;height:40.0pt'>
  <td class=xl26 style="text-align: center;">п/п</td>
  <td class=xl26 style="text-align: center;">номер<br>договора<br>(BAN)</td>
  <td class=xl26 style="text-align: center;">начало</td>
  <td class=xl26 style="text-align: center;">окончание</td>
  <td class=xl26 style="text-align: center;">состояние</td>
  <td class=xl26 style="text-align: center;">позиция</td>
  <td class=xl26 style="text-align: center;">арендодатель</td>
  <td class=xl26 style="text-align: center;">менеджер</td>
  <td class=xl26 style="text-align: center;">экономист</td>
  <td class=xl26 style="text-align: center;">сумма<br>трафика<br>(возрастающая)</td>
  <td class=xl26 style="text-align: center;">сумма фактических<br>безналичных платежей</td>
  <td class=xl26 style="text-align: center;">сумма фактических<br>наличных платежей</td>
  <td class=xl26 style="text-align: center;">сумма платежей<br>по актам в/з</td>
  <td class=xl26 style="text-align: center;">сальдо</td>
  <td class=xl26 style="text-align: center;">тип<br>обработки</td>
  <td class=xl26 style="text-align: center;">сумма<br>договора<br>аренды</td>
  <td class=xl26 style="text-align: center;">%<br>сальдо/сумма<br>договора</td>          
  <td class=xl26 style="text-align: center;">Количество<br>активных<br>номеров</td>
 </tr>  
</logic:equal>

<logic:equal name="ArendaReport3ParamsForm" property="comand" value="repTemplateListZpNextPeriod" scope="session">
 <tr class=xl27 height=100 style='mso-height-source:userset;height:75.0pt'>
  <td class=xl26>Номер GSM</td>
  <td class=xl26>Номер DAMPS</td>
  <td class=xl26>Наименование позиции</td>
  <td class=xl26>Ответственный</td>
  <td class=xl26>Номер договора</td>
  <td class=xl26>Дата договора</td>
  <td class=xl26>Номер поставщика</td>
  <td class=xl26>Инн поставщика</td>
  <td class=xl26>Наименование поставщика</td>
  <td class=xl26>начальная дата ЗП</td>
  <td class=xl26>конечная дата ЗП</td>
  <td class=xl26>Комментарий</td>
  <td class=xl26>Услуга</td>
  <td class=xl26>Сумма по договору</td>
  <td class=xl26>Сумма ЗП</td>
  <td class=xl26>НДС</td>
  <td class=xl26>Валюта договора</td>
  <td class=xl26>Сумма начислений<br>за период без НДС</td>
  <td class=xl26>НДС от суммы начислений</td>
  <td class=xl26>Категория статьи затрат</td>
  <td class=xl26>Статус договора</td>
  <td class=xl26>Тип продления</td>   
  </tr>
</logic:equal>

<logic:equal name="ArendaReport3ParamsForm" property="comand" value="repContractCustomersOnPeriod" scope="session">
 <tr class=xl27 height=40 style='mso-height-source:userset;height:40.0pt'>
  <td class=xl26>№ договора</td>
  <td class=xl26>Дата<br>начала</td>
  <td class=xl26>Дата<br>окончания</td>
  <td class=xl26>Продление</td>
  <td class=xl26>Контрагент</td>
  <td class=xl26>ИНН</td>
  <td class=xl26>КПП</td>
  <td class=xl26>Адрес</td>
  <td class=xl26>р/сч</td>
  <td class=xl26>БИК</td>
  <td class=xl26>Наименование<br>банка</td>
  <td class=xl26>Услуги<br>по договору</td>
  <td class=xl26>Сумма<br>в год</td>
  <td class=xl26>Сумма<br>в месяц</td>
  <td class=xl26>Валюта</td>
  <td class=xl26>Название позиции</td>
 </tr>
</logic:equal>

<logic:equal name="ArendaReport3ParamsForm" property="comand" value="repListContractsForNFS" scope="session">
 <tr class=xl27 height=15 style='mso-height-source:userset;height:15.0pt'>
	 <td class=xl26 rowspan="3" style="text-align: center;">Состояние договора</td>
	 <td class=xl26 rowspan="3" style="text-align: center;">№ сайта</td>
	 <td class=xl26 rowspan="3" style="text-align: center;">№ БС</td>
	 <td class=xl26 rowspan="3" style="text-align: center;">№ договора</td>
	 <td class=xl26 rowspan="3" style="text-align: center;">Арендодатель</td>
	 <td class=xl26 colspan="4" style="text-align: center;">Срок действия договора</td>
	 <td class=xl26 colspan="2" style="text-align: center;">продление договора</td>
	 <td class=xl26 colspan="3" style="text-align: center;">Условия платежа</td>
	 <td class=xl26 rowspan="3" style="text-align: center;">Услуга</td>
	 <td class=xl26 rowspan="3" style="text-align: center;">Расчетная дата<br>(фактическая)<br>окончания договора</td>
 </tr>  
 <tr class=xl27 height=15 style='mso-height-source:userset;height:15.0pt'>  
	 <td class=xl26 colspan="2" style="text-align: center;">первоначальный</td>
	 <td class=xl26 colspan="2" style="text-align: center;">Действующий в настоящее время (Фактический)</td>
	 <td class=xl26 rowspan="2" style="text-align: center;">способ</td>
	 <td class=xl26 rowspan="2" style="text-align: center;">период</td>
	 <td class=xl26 rowspan="2" style="text-align: center;">период</td>
	 <td class=xl26 rowspan="2" style="text-align: center;">кол-во дней</td>
	 <td class=xl26 rowspan="2" style="text-align: center;">тип расчета</td>
 </tr>  
 <tr class=xl27 height=15 style='mso-height-source:userset;height:15.0pt'>	 
	 <td class=xl26 style="text-align: center;">с</td>
	 <td class=xl26 style="text-align: center;">по</td>
	 <td class=xl26 style="text-align: center;">с</td>
	 <td class=xl26 style="text-align: center;">по</td>	 
 </tr>
</logic:equal>


<logic:present name="reportPage" scope="request">

<logic:equal name="ArendaReport3ParamsForm" property="comand" value="fillTmpListPayOnCategory" scope="session">
	<tr class=xl27 height=40 style='mso-height-source:userset;height:40.0pt'>
	<logic:iterate id="it" name="reportPage" scope="request" property="headers">
		<td class=xl26 style="text-align: center;">
			<bean:write name="it"/>
		</td> 
 	</logic:iterate>  
 	</tr> 	
</logic:equal>

			<!-- Table body -->
			<logic:iterate id="it" name="reportPage" scope="request" property="list">
				<%Object[] items = (Object[]) it;%>
				<tr height=17 style='height:12.75pt'>
					<%for (int i = 0; i < items.length; i++) {%>
						<%if(items[i] == null){%>
							<td></td>
						<%}else if (items[i].getClass() == java.sql.Date.class){
							String dataStr = format.format ((java.sql.Date)items[i]);
						%>
							<td><%=dataStr%></td>
						<%}else if (items[i].getClass() == java.sql.Timestamp.class){
							java.sql.Timestamp tms = (java.sql.Timestamp)items[i];
							String dataStr = format.format ( new java.sql.Date(tms.getTime()) );
						%>
							<td><%=dataStr%></td>
						<%}else if (items[i].getClass() == java.math.BigDecimal.class){%>
							<td class=xl29 align=right x:num="<%=items[i]%>"><span style="mso-spacerun: yes"></td> 
						<%}else{%>
							<td><%=items[i]%></td>
						<%}%>
					<%}%>
				</tr>
			</logic:iterate>
			
<!-- Итоги для отчетов-->
<logic:equal name="ArendaReport3ParamsForm" property="comand" value="fillTmpListPayOnCategory" scope="session">
	<% 
		Page aPage = (Page)request.getAttribute("reportPage");
		java.math.BigDecimal[] listSum = PageHelper.getListSumForPage(aPage);
		//System.out.print("size=" + listSum.length);
	%>
	<%if(listSum != null && listSum.length > 0){%>
	<tr height=17 style='height:12.75pt'>
		<td class=xl26 style="text-align: center;" colspan="4">
			всего по категориям
		</td>
		<%for(int i = 4; i < listSum.length; i++) { %>
			<td class=xl29 align=right x:num="<%=listSum[i]%>" style="font-weight: bold;"><span style="mso-spacerun: yes"></td> 
		<% } %> 
 	</tr>
 	<% } %> 	
</logic:equal>
</logic:present>			
</TABLE>
</body>

</html>
