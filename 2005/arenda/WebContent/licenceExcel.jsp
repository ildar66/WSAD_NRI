<%@ page language = "java" %>
<%@ page contentType = "application/vnd.ms-excel;name=report.xls;charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import="com.hps.july.util.*"%>
<%@ page import="java.text.*"%>
<%@ page import="com.hps.july.arenda.*, com.hps.july.arenda.valueobject.*, com.hps.july.arenda.formbean.*" %>
<%!
//форматируем дату:
SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
private String dateStr(java.sql.Date date) {
	if(date==null) 
		return ("&nbsp;");
	else
		return	format.format (date);
}
%>
<%
	response.setHeader("Cache-Control", "no-cache");
	response.setContentType("application/vnd.ms-excel;name=lcsReport.xls;charset=windows-1251");
	response.setHeader("Content-Disposition", "attachment;filename=lcsReport.xls");
	//SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
	//com.hps.july.arenda.cdbcobjects.Page reportPage =  (com.hps.july.arenda.cdbcobjects.Page)request.getAttribute("reportPage");
	//System.out.println("page="+ reportPage);
%>
<html xmlns:o="urn:schemas-microsoft-com:office:office"
xmlns:x="urn:schemas-microsoft-com:office:excel"
xmlns="http://www.w3.org/TR/REC-html40">
<head>
<meta http-equiv=Content-Type content="application/vnd.ms-excel;name=lcsReport.xls;charset=windows-1251">
<meta name=ProgId content="Excel.Sheet">
<meta http-equiv="Content-Disposition" content="attachment;filename=lcsReport.xls">
<meta name=Generator content="Microsoft Excel 9">

</head>

<body>
<table x:str border=1 cellpadding=0 cellspacing=0 style='border-collapse:collapse; border-color:  black; font-size:10pt;'>
 <tr>
  <th>GSM</th>
  <th>DAMPS</th>
  <th>наименование</th>
  <th>ФАС</th>
  <th>РУЦР </th>
  <th>Аэро-граж</th>
  <th>Аэро-воен</th>
  <th>ГПС</th>
  <th>ГАСН</th>
  <th>СЭС</th>
  <th>в\ч</th>
  <th>ТУ </th>
  <th>Акт Земл.</th>
  <th>Кадастр</th>
  <th>Дог имущ.</th>
 </tr>
<!-- Table body -->
<logic:iterate id="it" name="LicenceListForm" property="page.list" scope="session">
	<%LicenciesTO to = (LicenciesTO) it;%>
		<tr>
			<td><%=to.getGsmId()%></td>
			<td><%=to.getDampsId()%></td>
			<td><%=to.getName()%></td>
			<td><%=dateStr(to.getFas())%></td>
			<td><%=dateStr(to.getRutsr())%></td>
			<td><%=dateStr(to.getAir_gr())%></td>
			<td><%=dateStr(to.getAir_w())%></td>
			<td><%=dateStr(to.getGps())%></td>
			<td><%=dateStr(to.getGasn())%></td>
			<td><%=dateStr(to.getSes())%></td>
			<td><%=dateStr(to.getVch())%></td>
			<td><%=dateStr(to.getTu())%></td>
			<td><%=dateStr(to.getOtvod())%></td>
			<td><%=dateStr(to.getKadastr())%></td>
			<td><%=dateStr(to.getProperty())%></td>
		</tr>
</logic:iterate>
</table>

</body>
</html>
