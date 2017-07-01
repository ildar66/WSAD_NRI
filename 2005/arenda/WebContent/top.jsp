<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.constants.*,com.hps.july.arenda.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<html:html>
<HEAD>
<TITLE>licencePage.jsp</TITLE>
</HEAD>
 
<BODY>
<html:errors />
<html:form action="/ShowListLicence" styleId="thisForm"  target="_top">
	<html:hidden property="school" />
	<html:hidden property="comand" value=""/>
<script>
function ShowReport()
{ 
	document.thisForm.comand.value = "licenceExcel";
	document.thisForm.submit();
}
function MoveTo(school)
{ 
	document.thisForm.comand.value = "licencePage";
	document.thisForm.school.value = school;
    document.body.style.cursor="wait";	
	document.thisForm.submit();
}
function switchFilter() {
	if(thisForm.filter.value == 0) {
		thisForm.searchstring.disabled = true;
	} else {
		thisForm.searchstring.disabled = false;
	}
}
function popCalInMainFrame(dateCtrl) {
	var w=self.top.scroll_right.gfPop;
	w.gbFixedPos=true;	// enable fixed positioning
	w.gPosOffset=[70,0];	// set position
	w.fPopCalendar(dateCtrl);	// pop calendar
}
function popCalInMainFrame(dateFrom, dateTo, isStart) {
	//alert('scrollTop=' +top.frames["scroll_right"].document.body.scrollTop);//temp
	var SR_scrollTop = top.frames["scroll_right"].document.body.scrollTop;
	var w=self.top.scroll_right.gfPop;
	w.gbFixedPos=true;	// enable fixed positioning
	if(isStart == true) {
		w.gPosOffset=[180,SR_scrollTop];	// set position
		w.fStartPop(dateFrom, dateTo);
	}
	else {
		w.gPosOffset=[380,SR_scrollTop];	// set position
		w.fEndPop(dateFrom, dateTo);
	}
}
function switchDopFilter() {
	//alert(dopInfoID.currentStyle.getAttribute("display"));//temp
	//alert(dopInfoID.style.display);
	if(thisForm.isDopFilter[0].checked) {
		//alert("Y");
		//dopInfoID.style.display = 'table-row';
		dopInfoID.style.setAttribute("display", "block");
	} else {
		//alert("N");
		//dopInfoID.style.display = 'none';
		dopInfoID.style.setAttribute("display", "none");
	}
}
</script>

<TABLE width="100%" class=includer border="0" cellpadding="0" cellspacing="0">
	<TR>
		<TD bgcolor="D6EBFF" height="30">
			<img src="/images/logo_beeline.gif" border="0" alt="">
		</TD>
	<TR>
</TABLE>

		<TABLE width="100%" style="font-size:11pt;" bgcolor="D6EBFF" border="0" cellpadding="0" cellspacing="0">
			<TBODY>
				<TR>
					<TH align="left" bgcolor="AAD1F6" colspan="6">
						<A href="/arenda/main.do" target="_top"><img src="/images/cancel.gif" border="0" alt="Вернуться в меню"></A>&nbsp;
						<html:select name="LicenceListForm" property="currRegionID">
							<option value='0'>&nbsp;</option>
							<%--html:options collection="regionAccessList" property="vo.regionid" labelProperty="regionName"/--%>
							<logic:iterate name="LicenceListForm" property="regionAccessList" id="it">
								<logic:present name="it">
									<%String value = ((com.hps.july.valueobject.RegionsAccess_TO)it).getVo().getRegionid().toString();%>
									<%String name = ((com.hps.july.valueobject.RegionsAccess_TO)it).getRegionName();%>
									<html:option value='<%=value%>'><%=name%></html:option>
								</logic:present>
							</logic:iterate>
						</html:select>
						<%--bean:write name="LicenceListForm" property="currRegionID"/--%>
					</TH>
				</TR>
				<TR>
					<TD>
						Поиск с дополнит. условиями: <html:checkbox property="isDopFilter" onclick="switchDopFilter()"/>
						<html:hidden property="isDopFilter" value="false"/>
					</TD>
					<TD>
						<html:select  property="filter" onchange="switchFilter()" >
							<html:option value="0">Все</html:option>
							<html:option value="1">По названию</html:option>
							<html:option value="2">По № GSM/DCS</html:option>
							<html:option value="3">По № DAMPS</html:option>
						</html:select>
					</TD>
					<TD>Значение поиска: </TD>
					<TD>
						<html:text property="searchstring" size="25"/>
						<INPUT TYPE='IMAGE' SRC='/images/refresh.gif'  onclick="MoveTo('');return false;" border='0' alt='Искать'>&nbsp;
						&nbsp;<INPUT TYPE='IMAGE' SRC='/images/msexcel.gif' onclick="ShowReport();return false;" ALT="Отчет ХLS">
					</TD>
				</TR>
				<TR id="dopInfoID">
					<TD>
						<html:radio property="isDateModified" value="true"/>изменение данных в колонке<BR>
						<html:radio property="isDateModified" value="false"/>нет данных о разрешениях
					</TD>
					<TD>
					      <html:select property="types" size="3" multiple="true">
					        <html:option value="0">Все</html:option>
							<html:option value="13">Комментарий</html:option>
							<logic:equal name="LicenceListForm"	property="showColumn.isFas"	value="true" scope="session">
								<html:option value="1">ФАС</html:option>
							</logic:equal>
							<logic:equal name="LicenceListForm"	property="showColumn.isRutsr" value="true"	scope="session">
								<html:option value="2">РУЦР</html:option>
							</logic:equal>
							<logic:equal name="LicenceListForm"	property="showColumn.isAir_gr" value="true" scope="session">
								<html:option value="3">Аэро-граж</html:option>
							</logic:equal>
							<logic:equal name="LicenceListForm"	property="showColumn.isAir_w" value="true"	scope="session">
								<html:option value="4">Аэро-воен в\ч</html:option>
							</logic:equal>
							<logic:equal name="LicenceListForm"	property="showColumn.isGps"	value="true" scope="session">
								<html:option value="5">ГПС</html:option>
							</logic:equal>
							<logic:equal name="LicenceListForm"	property="showColumn.isGasn" value="true" scope="session">
								<html:option value="6">ГАСН</html:option>
							</logic:equal>
							<logic:equal name="LicenceListForm"	property="showColumn.isSes"	value="true" scope="session">
								<html:option value="7">СЭС</html:option>
							</logic:equal>
							<logic:equal name="LicenceListForm"	property="showColumn.isVch" value="true" scope="session">
								<html:option value="8">в\ч</html:option>
							</logic:equal>
							<logic:equal name="LicenceListForm"	property="showColumn.isTu" value="true" scope="session">
								<html:option value="9">ТУ</html:option>
							</logic:equal>
							<logic:equal name="LicenceListForm"	property="showColumn.isOtvod" value="true" scope="session">
								<html:option value="10">Акт Землеотвода</html:option>
							</logic:equal>
							<logic:equal name="LicenceListForm"	property="showColumn.isKadastr"	value="true" scope="session">
								<html:option value="11">Дело кадастра</html:option>
							</logic:equal>
							<logic:equal name="LicenceListForm"	property="showColumn.isProperty" value="true" scope="session">
								<html:option value="12">Договор имущества</html:option>
							</logic:equal>
						</html:select>
					</TD>
					<TD>с : <html:text property="dataPeriod.fromDateFrm" size="11" styleId="fromDateFrm"/>
						<a href="javascript:void(0)" onclick="popCalInMainFrame(document.thisForm.fromDateFrm, document.thisForm.toDateFrm, true);return false;" HIDEFOCUS>
							<img name="popcal" align="absbottom" src="/images/calbtn.gif" width="34" height="22" border="0" alt=""></a>
					</TD>
					<TD>по : <html:text property="dataPeriod.toDateFrm" size="11" styleId="toDateFrm"/>
						<a href="javascript:void(0)" onclick="popCalInMainFrame(document.thisForm.fromDateFrm, document.thisForm.toDateFrm, false);return false;" HIDEFOCUS>
							<img name="popcal" align="absbottom" src="/images/calbtn.gif" width="34" height="22" border="0" alt=""></a>
					</TD>
				</TR>
				<TR>
					<TD height="60" bgcolor="D6EBFF">&nbsp;</TD>
				</TR>
			</TBODY>
		</TABLE>

</html:form>

</BODY>
</html:html>
<script language="javascript">
	switchFilter();
	switchDopFilter();
</script>
