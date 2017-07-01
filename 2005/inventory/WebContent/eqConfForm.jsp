<html>
<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import = "com.hps.july.web.util.*, com.hps.july.inventory.formbean.* "%>
<head>
    <title>Equipment_Calculation</title>
</head>
<body onkeypress="searchByEnter();">

<%
	String trailcomMapUrl = com.hps.july.util.AppUtils.getNamedValueString("PathMapTrailcom");
	String ruser = request.getRemoteUser();
	String pathEquipmentEditTrailcom = com.hps.july.util.AppUtils.getNamedValueString("PathEquipmentEditTrailcom");
	// это для тестового и рабочега сервера
	// String pathPositionSearchTrailcom = com.hps.july.util.AppUtils.getNamedValueString("PathPositionSearchTrailcom");
	// это для локального сервера
	String pathPositionSearchTrailcom = "http://localhost/TS_objects_web/loginBs.jsp";
%>

<script language="javascript">

function searchByEnter(e) {
    if (document.layers) {
        Key = e.which;
    } else {
        Key = window.event.keyCode;
    }
    if (Key == 13) {
		runSearchProcess();
    }
}

function OpenWindowBSJSP()
{
	// alert("open window");
	document.body.style.cursor="normal";
	openDialog("ContentDonorBS.jsp?listBS=1", "window_Search", "top=100, left=100, width=950, height=600, scrollbars=yes, resizable=yes");
}

function SelectBSDetail(equipment, bsnumber, bsname, address) {
	document.body.style.cursor="normal";
	
	var bsNumberIdVar = document.getElementById("bsNumberId");
	bsNumberIdVar.value = bsnumber;
	var bsNameIdVar = document.getElementById("bsNameId");
	bsNameIdVar.value = bsname;
	var posAddressIdVar = document.getElementById("posAddressId");
	posAddressIdVar.value = address;
	if (bsname != "nothing") {
		// initPosition(1);
	} else {
	  	alert("По Вашему запросу ничего не найдено.");
		bsNumberIdVar.value = "";
		bsNameIdVar.value = "";
		posAddressIdVar.value = "";
		// initPosition(4);
	}
}

function runSearchProcess() {
	// alert("runSearch()");
	document.body.style.cursor="wait";
	
	var selectVar = document.getElementById("searchParameterNameSelectId");
	var oprionsVar = selectVar.options;
	var paramComplect;
	var paramCriterion;
	for (i=0; i< oprionsVar.length; i++) {
		var curOpt = oprionsVar(i);
		var selectedVar = curOpt.selected;
		var textVar = curOpt.text;
		if (selectedVar) {
				var valueVar = curOpt.value;
		        // alert("textVar = "+textVar);
				paramComplect = valueVar.substring(0,1);
				paramCriterion = valueVar.substring(1);
		        // alert("paramComplect = "+paramComplect);
		        // alert("paramCriterion = "+paramCriterion);
			break;
		}
	} 
	var valueVar = document.getElementById("searchParameterValueId");
	var searchValue = valueVar.value; 
    // alert("searchValue = "+searchValue);
	searchValue = Trim(searchValue);
	
    // alert("Trim(searchValue) = ["+searchValue+"]");
    if (validateSearchParam(paramComplect, paramCriterion, searchValue) == false) {
		document.body.style.cursor="normal";
       	return false;
    }

	var hrefPoints="<%= pathPositionSearchTrailcom%>?id=<%= ruser%>&complect="+paramComplect+"&criterion="+paramCriterion+"&word="+searchValue+"&extDetails=1";
	// var hrefPoints="<%= pathPositionSearchTrailcom%>?id=<%= ruser%>&complect="+paramComplect+"&criterion="+paramCriterion+"&word="+escapedSearchValue+"&extEqDetails=1";
	// var hrefPoints="<%= pathPositionSearchTrailcom%>?id=<%= ruser%>&complect="+paramComplect+"&criterion="+paramCriterion+"&word="+escapedSearchValue2+"&extEqDetails=1";
    // alert("hrefPoints = "+hrefPoints);
	
	document.frames['callBSForm'].location=hrefPoints;
}

function validateSearchParam(paramComplect, paramCriterion, searchValue) {
	if (searchValue.length == 0) {
		alert("Поле поиска должно быть заполнено.");
	 	return false;
	}
	if (paramCriterion == "NR") {
		if (numericStr(searchValue) == false) {
			alert("Передача нецифровых символов в номере не допускается.");
		 	return false;
		}
	}
	if ((paramCriterion == "NM") || (paramCriterion == "AD")) {
		if (searchValue.length < 3) {
			alert("Строка поиска должна содержать не менее 3-х символов.");
	 	 	return false;
	 	}
	}
	return true;
}

function notImplimented() {
	alert("Данный режим пока не реализован.");
}

function  submitForm(theObject) {
	// alert("!!!!!!!!!!!!!!!!");
	ConfigEqEditForm.submit();
}

// !!! to library !!!

function Trim(TRIM_VALUE){
if(TRIM_VALUE.length < 1){
return"";
}
TRIM_VALUE = RTrim(TRIM_VALUE);
TRIM_VALUE = LTrim(TRIM_VALUE);
if(TRIM_VALUE==""){
return "";
}
else{
return TRIM_VALUE;
}
} //End Function

function RTrim(VALUE){
var w_space = String.fromCharCode(32);
var v_length = VALUE.length;
var strTemp = "";
if(v_length < 0){
return"";
}
var iTemp = v_length -1;

while(iTemp > -1){
if(VALUE.charAt(iTemp) == w_space){
}
else{
strTemp = VALUE.substring(0,iTemp +1);
break;
}
iTemp = iTemp-1;

} //End While
return strTemp;

} //End Function

function LTrim(VALUE){
var w_space = String.fromCharCode(32);
if(v_length < 1){
return"";
}
var v_length = VALUE.length;
var strTemp = "";

var iTemp = 0;

while(iTemp < v_length){
if(VALUE.charAt(iTemp) == w_space){
}
else{
strTemp = VALUE.substring(iTemp,v_length);
break;
}
iTemp = iTemp + 1;
} //End While
return strTemp;
} //End Function

function numericStr(alphane)
{
	var numaric = alphane;
	for(var j=0; j<numaric.length; j++)
		{
		  var alphaa = numaric.charAt(j);
		  // alert("alphaa = "+alphaa);
		  var hh = alphaa.charCodeAt(0);
		  // alert("hh = "+hh);
		  // if((hh > 47 && hh<59) || (hh > 64 && hh<91) || (hh > 96 && hh<123))
		  if(hh > 47 && hh<59)
		  {
		  }
		else	{
			 return false;
		  }
		}
 return true;
}
// !!! to library !!!

</script>

<july:editform action="/ShowCfgEditForm.do" styleId="ConfigEqEditForm">

<input type="hidden" name="partForSubmit" value="<%=ConfigEqEditForm.WHOLE_PART%>"/>

<!-- Стили --> 
<style>
TD.tableCell {
	text-align: center;
}
TD {
	border-style: solid; 
	border-color: yellow; 
	border-width: 0; 
}
TABLE.construct {
	border-style: solid; 
	border-color: red; 
	border-width: 0;
}
TR.inner {
	BACKGROUND-COLOR: #B3D9FF; FONT-FAMILY: Verdana,Arial;
}
TD.whitecell {
	BACKGROUND-COLOR: #FFFFFF; FONT-FAMILY: Verdana,Arial;
	border-style: solid; 
	border-color: #B3D9FF; 
	border-width: 1;
}
</style>

<table class="main">

<tr class="normal">
<td>
	<table width="100%" cellspacing="0" cellpadding="0" class="construct" >
	<tr class="normal">
	<td width="280" valign="top">
		<table class="construct" width="100%" cellspacing="0" cellpadding="0" style="font-family:tahoma,arial;font-size:8pt;">
			<tr class="normal">
				<td>
					<july:backbutton/> 
				</td>
				<td>
					<july:link page="/SaveBSConfig.do">
						<IMG SRC="/images/savedoc_pas.gif" BORDER='0' ALT='Сохранить документ'>
					</july:link>
				</td>
				<td> 
					<A onclick="notImplimented();">
						<IMG SRC="/images/createbs_act.gif" BORDER='0' ALT='Создание нового функционального комплекта «Базовая станция»'> 
					</A>
				</td>
			</tr>
			<tr class="normal">
				<td></td>
				<td nowrap colspan="2" align="left"> 
				Контактное лицо - Сергей Уколов.
				</td>
			</tr>
			<tr class="normal">
				<td></td>
				<td nowrap colspan="2" align="left"> 
				тел. 42-15 или 8-903-767-4215
				</td>
			</tr>
			<tr class="normal">
				<td></td>
				<td nowrap colspan="2" align="left"> 
				e-mail: SUkolov@partners.beeline.ru
				</td>
			</tr>
		</table>
	</td>	
	<td valign="top">
		<table class="construct" width="100%" cellspacing="0" cellpadding="0" style="font-family:tahoma,arial;font-size:8pt;">
			<tr class="normal">
				<td nowrap colspan="2" valign="bottom">
							<B>Поиск БС по:&nbsp;</B>
							<july:select property="searchParameterName" styleId="searchParameterNameSelectId" 
							style="font-size:8pt;width=100" insertable="true" updatable="true">
      						<html:option value="BNM">названию</html:option>
		      				<html:option value="BNR">№ GSM/DCS</html:option>
				      		</july:select>		
				</td>
				<td nowrap colspan="3" valign="bottom">
					<july:string style="font-size:8pt;background-color:#FFFFFF;" size="45" property="searchParameterValue" styleId="searchParameterValueId" insertable="true" updatable="true"/>
					<A onclick="runSearchProcess();">
						<IMG SRC="/images/refresh.gif" BORDER='0' ALT='Поиск'>
					</A>
						<iframe frameborder=0 name="callBSForm" width=0 height=0></iframe>
				</td>
			</tr>
			<tr class="normal">
				<td nowrap valign="bottom">
					<B>ТЕКУЩАЯ БС:&nbsp;</B>
				</td>
				<td nowrap align="right" valign="bottom">
					<B>Номер&nbsp;</B>
				</td>
				<td valign="bottom">
					<july:string style="font-size:8pt;background-color:#E0E0E0;" readonly="true" size="5" property="bsNumber" styleId="bsNumberId" insertable="false" updatable="false"/>&nbsp; 
				</td>
				<td nowrap align="right" valign="bottom">
					<B>Название&nbsp;</B>
				</td>
				<td valign="bottom">
					<july:string style="font-size:8pt;background-color:#E0E0E0;" readonly="true" size="30" property="bsName" styleId="bsNameId" insertable="false" updatable="false"/>&nbsp;
				</td>
			</tr>
			<tr class="normal">
				<td nowrap valign="bottom">
					<B>ТЕКУЩАЯ ПОЗИЦИЯ:&nbsp;</B>
				</td>
				<td align="right" valign="bottom">
					<B>Адрес&nbsp;</B>
				</td>
				<td colspan="3" valign="bottom">
					<july:string style="font-size:8pt;background-color:#E0E0E0;" readonly="true" size="45" property="posAddress" styleId="posAddressId" insertable="false" updatable="false"/>
				</td>
			</tr>
		</table>
	</td>	
	</tr>
	</table>
</td>	
</tr>
<tr> 
	<td class="normal">
	<table width="100%" class="construct" cellspacing="0" cellpadding="0" style="font-family:tahoma,arial;font-size:8pt;">
		<tr class="normal">
			<td nowrap valign="bottom">
				<A onclick="notImplimented();"> 
					<IMG SRC='/images/curconfig.gif' BORDER='0' ALT='Выберите базовую станцию'>
				</A>&nbsp;&nbsp;
			</td>
			<td valign="bottom">
				<A onclick="notImplimented();"> 
					<IMG SRC='/images/dochistory.gif' BORDER='0' ALT='История документов'>
				</A>
			</td>
			<td width="100%">&nbsp;</td>
		</tr>
	</table>
	</td>
</tr>
<%
	String stateBsValues[] = { "-", "P", "W", "M", "D"};
	pageContext.setAttribute("stateBsValues", stateBsValues);
	String stateBsLabels[] = { "---", "Строительство", "В эфире (тестирование)", "Коммерческая эксплуатация", "Демонтирована"};
	pageContext.setAttribute("stateBsLabels", stateBsLabels);
%>
<tr class="normal">
<td>
	<table width="100%" cellspacing="0" cellpadding="0" class="construct"  style="font-family:tahoma,arial;font-size:8pt;">
		<tr bgcolor="#CCCCCC">
			<th> Диапазон
			</th> 
			<th> Состояние БС
			</th>
			<th> Начало строит.БС
			</th>
			<th> Монтаж и тест.БС
			</th>
			<th> Монтаж и тест.АФС
			</th>
			<th> Подключение к BSC
			</th>
			<th> Включение в эфир
			</th>
		</tr>
		<logic:equal name="ConfigEqEditForm"  property="isGsm" value="true">
			<tr class="normalrow" style="font-size:8pt;">
				<td class="tableCell"> GSM
				</td>
				<td class="tableCell"> 
					<july:select property="gsmState" styleId="gsmStateId" 
						style="font-size:8pt;" insertable="true" updatable="true">
      					<html:options name="stateBsValues" labelName="stateBsLabels"/>
      				</july:select>		
				</td>
				<td nowrap class="tableCell"><july:date style="vertical-align: bottom; width:100px;" size="20" required="false" property="gsmBsConstructionBegin" insertable="true" updatable="true"/>
				</td>
				<td nowrap class="tableCell"><july:date style="vertical-align: bottom; width:100px;" required="false" property="gsmBsMountingTest" size="20" insertable="true" updatable="true"/>
				</td>
				<td nowrap class="tableCell"><july:date style="vertical-align: bottom; width:100px;" required="false" property="gsmAfsMountingTest" size="20" insertable="true" updatable="true"/>
				</td>
				<td nowrap class="tableCell"><july:date style="vertical-align: bottom; width:100px;" required="false" property="gsmBscConnection" size="20" insertable="true" updatable="true"/>
				</td>
				<td nowrap class="tableCell"><july:date style="vertical-align: bottom; width:100px;" required="false" property="gsmOnAir" size="20" insertable="true" updatable="true"/>
				</td>
			</tr>
		</logic:equal>	
		<logic:equal name="ConfigEqEditForm"  property="isDcs" value="true">
			<tr class="normalrow" style="font-size:8pt;">
				<td class="tableCell"> DCS
				</td>
				<td class="tableCell"> 
					<july:select property="dcsState" styleId="gsmStateId" 
						style="font-size:8pt;" insertable="true" updatable="true">
      					<html:options name="stateBsValues" labelName="stateBsLabels"/>
      				</july:select>		
				</td>
				<td nowrap class="tableCell"><july:date style="vertical-align: bottom; width:100px;" required="false" property="dcsBsConstructionBegin" size="20" insertable="true" updatable="true"/>
				</td>
				<td nowrap class="tableCell"><july:date style="vertical-align: bottom; width:100px;" required="false" property="dcsBsMountingTest" size="20" insertable="true" updatable="true"/>
				</td>
				<td nowrap class="tableCell"><july:date style="vertical-align: bottom; width:100px;" required="false" property="dcsAfsMountingTest" size="20" insertable="true" updatable="true"/>
				</td>
				<td nowrap class="tableCell"><july:date style="vertical-align: bottom; width:100px;" required="false" property="dcsBscConnection" size="20" insertable="true" updatable="true"/>
				</td>
				<td nowrap class="tableCell"><july:date style="vertical-align: bottom; width:100px;" required="false" property="dcsOnAir" size="20" insertable="true" updatable="true"/>
				</td>
			</tr>
		</logic:equal>	
	</table>
</td>	
</tr>
<tr class="normal">
<td>
	<table width="100%" cellspacing="0" cellpadding="0" class="construct"  style="font-family:tahoma,arial;font-size:8pt;">
		<tr class="normal">
			<td rowspan="2" width="48%">
				<iframe width="100%" MARGINWIDTH="0" MARGINHEIGHT="0" ALIGN="top" frameborder="1" name="dtRepsTitleIFrame" height="36" src="dtRepsTitle.jsp" SCROLLING="no" ></iframe>
				<iframe width="100%" MARGINWIDTH="0" MARGINHEIGHT="0" ALIGN="top" frameborder="1" name="dtRepsContIFrame" height="65" src="dtRepsCont.jsp" SCROLLING="auto" ></iframe>
			</td>
			<td rowspan="2" width="1%">&nbsp;
			</td>
			<td valign="top" width="51%">
				<table width="100%" cellspacing="0" cellpadding="0" class="construct"  style="font-family:tahoma,arial;font-size:8pt;">
				<tr class="normal">
					<td width="80"><b>Контроллер</b>
					</td>
					<td width="378">
						<july:select style="width: 378;" collection="controllers" property="controllerId" insertable="true" updatable="true">
							<html:options collection="controllers" property="code" labelProperty="name"/>
						</july:select>
					</td>
					<td>&nbsp;
						<A onclick="notImplimented();"> 
							<IMG SRC='/images/izmena.gif' BORDER='0' ALT='Выбрать контроллер'>
						</A>
					</td>
				</tr>
				</table>
			</td>	
		</tr>
		<!-- секция 7 -->
		<tr>
			<td valign="top" >
				<table width="100%" cellspacing="0" cellpadding="0" class="construct"  style="font-family:tahoma,arial;font-size:8pt;">
					<tr class="inner">
						<td>&nbsp;</td>
						<th nowrap colspan="5" align="center">Сектора 900</th>
						<td>&nbsp;</td>
						<th nowrap colspan="5" align="center">Сектора 1800</th>
						<td>&nbsp;</td>
					</tr>
					<tr class="inner">
						<td>&nbsp;</td>
						<td class="whitecell" nowrap align="center">
							<july:checkbox property="sumSector_O_900" insertable="true" updatable="true" onclick="submitForm(this);"/>
						O</td>
						<td class="whitecell" nowrap align="center">
							<july:checkbox property="sumSector_E_900" insertable="true" updatable="true" onclick="submitForm(this);"/>
						E</td>
						<td class="whitecell" nowrap align="center">
							<july:checkbox property="sumSector_F_900" insertable="true" updatable="true" onclick="submitForm(this);"/>
						F</td>
						<td class="whitecell" nowrap align="center">
							<july:checkbox property="sumSector_G_900" insertable="true" updatable="true" onclick="submitForm(this);"/>
						G</td>
						<td class="whitecell" nowrap align="center">
							<july:checkbox property="sumSector_H_900" insertable="true" updatable="true" onclick="submitForm(this);"/>
						H</td>
						<td>&nbsp;</td>
						<td class="whitecell" nowrap align="center">
							<july:checkbox property="sumSector_O_1800" insertable="true" updatable="true" onclick="submitForm(this);"/>
						O</td>
						<td class="whitecell" nowrap align="center">
							<july:checkbox property="sumSector_A_1800" insertable="true" updatable="true" onclick="submitForm(this);"/>
						A</td>
						<td class="whitecell" nowrap align="center">
							<july:checkbox property="sumSector_B_1800" insertable="true" updatable="true" onclick="submitForm(this);"/>
						B</td>
						<td class="whitecell" nowrap align="center">
							<july:checkbox property="sumSector_C_1800" insertable="true" updatable="true" onclick="submitForm(this);"/>
						C</td>
						<td class="whitecell" nowrap align="center">
							<july:checkbox property="sumSector_D_1800" insertable="true" updatable="true" onclick="submitForm(this);"/>
						D</td>
						<td>&nbsp;</td>
					</tr>
					<tr class="inner">
						<th align="left">&nbsp;Трансиверы</th>
						<td class="whitecell" nowrap align="center"><bean:write name="ConfigEqEditForm" property="sumTrans_O_900_Str" filter="true"/></td>
						<td class="whitecell" nowrap align="center"><bean:write name="ConfigEqEditForm" property="sumTrans_E_900_Str" filter="true"/></td>
						<td class="whitecell" nowrap align="center"><bean:write name="ConfigEqEditForm" property="sumTrans_F_900_Str" filter="true"/></td>
						<td class="whitecell" nowrap align="center"><bean:write name="ConfigEqEditForm" property="sumTrans_G_900_Str" filter="true"/></td>
						<td class="whitecell" nowrap align="center"><bean:write name="ConfigEqEditForm" property="sumTrans_H_900_Str" filter="true"/></td>
						<td>&nbsp;</td>
						<td class="whitecell" nowrap align="center"><bean:write name="ConfigEqEditForm" property="sumTrans_O_1800_Str" filter="true"/></td>
						<td class="whitecell" nowrap align="center"><bean:write name="ConfigEqEditForm" property="sumTrans_A_1800_Str" filter="true"/></td>
						<td class="whitecell" nowrap align="center"><bean:write name="ConfigEqEditForm" property="sumTrans_B_1800_Str" filter="true"/></td>
						<td class="whitecell" nowrap align="center"><bean:write name="ConfigEqEditForm" property="sumTrans_C_1800_Str" filter="true"/></td>
						<td class="whitecell" nowrap align="center"><bean:write name="ConfigEqEditForm" property="sumTrans_D_1800_Str" filter="true"/></td>
						<td>&nbsp;</td>
					</tr>
					<tr class="inner">
						<th align="left">&nbsp;Антенны</th>
						<td class="whitecell" nowrap align="center"><bean:write name="ConfigEqEditForm" property="sumAntenn_O_900_Str" filter="true"/></td>
						<td class="whitecell" nowrap align="center"><bean:write name="ConfigEqEditForm" property="sumAntenn_E_900_Str" filter="true"/></td>
						<td class="whitecell" nowrap align="center"><bean:write name="ConfigEqEditForm" property="sumAntenn_F_900_Str" filter="true"/></td>
						<td class="whitecell" nowrap align="center"><bean:write name="ConfigEqEditForm" property="sumAntenn_G_900_Str" filter="true"/></td>
						<td class="whitecell" nowrap align="center"><bean:write name="ConfigEqEditForm" property="sumAntenn_H_900_Str" filter="true"/></td>
						<td>&nbsp;</td>
						<td class="whitecell" nowrap align="center"><bean:write name="ConfigEqEditForm" property="sumAntenn_O_1800_Str" filter="true"/></td>
						<td class="whitecell" nowrap align="center"><bean:write name="ConfigEqEditForm" property="sumAntenn_A_1800_Str" filter="true"/></td>
						<td class="whitecell" nowrap align="center"><bean:write name="ConfigEqEditForm" property="sumAntenn_B_1800_Str" filter="true"/></td>
						<td class="whitecell" nowrap align="center"><bean:write name="ConfigEqEditForm" property="sumAntenn_C_1800_Str" filter="true"/></td>
						<td class="whitecell" nowrap align="center"><bean:write name="ConfigEqEditForm" property="sumAntenn_D_1800_Str" filter="true"/></td>
						<td>&nbsp;</td>
					</tr>
					<tr class="inner">
						<td colspan="13"></td>
					</tr>
					<tr class="inner">
						<td colspan="13"></td>
					</tr>
				</table>	
			</td>
		</tr>
	</table>
</td>
</tr>
<tr class="normal">
	<td>
		<iframe width="100%" MARGINWIDTH="0" MARGINHEIGHT="0" ALIGN="top" frameborder="1" name="standsTitleIFrame" height="41" src="standsTitle.jsp" SCROLLING="no" ></iframe>
		<iframe width="100%" MARGINWIDTH="0" MARGINHEIGHT="0" ALIGN="top" frameborder="1" name="standsContentIFrame" height="52" src="standsContent.jsp" SCROLLING="auto" ></iframe>
	</td>
</tr>

<tr class="normal">
	<td>
		<iframe width="100%" MARGINWIDTH="0" MARGINHEIGHT="0" ALIGN="top" frameborder="1" name="trxsTitleIFrame" height="38" src="trxsTitle.jsp" SCROLLING="no" ></iframe>
		<iframe width="100%" MARGINWIDTH="0" MARGINHEIGHT="0" ALIGN="top" frameborder="1" name="trxsContentIFrame" height="54" src="trxsContent.jsp" SCROLLING="auto" ></iframe>
	</td>
</tr>

<tr class="normal">
	<td>
		<iframe width="100%" MARGINWIDTH="0" MARGINHEIGHT="0" ALIGN="top" frameborder="1" name="antennsTitleIFrame" height="41" src="antennsTitle.jsp" SCROLLING="no" ></iframe>
		<iframe width="100%" MARGINWIDTH="0" MARGINHEIGHT="0" ALIGN="top" frameborder="1" name="antennsContentIFrame" height="72" src="antennsContent.jsp" SCROLLING="auto" ></iframe>
	</td>
</tr>


<tr>
	<td>
	</td>
</tr>
</table>
</july:editform>
</BODY>
</HTML>
