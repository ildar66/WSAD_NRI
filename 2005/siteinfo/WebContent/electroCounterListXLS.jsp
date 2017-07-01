<%@ page language = "java" %>
<%@ page contentType = "application/vnd.ms-excel;name=electroCounterListXLS.xls;charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import="com.hps.july.util.*"%>
<%@ page import="java.text.*"%>
<%@ page import = "com.hps.july.siteinfo.formbean.*, com.hps.july.siteinfo.valueobject.*"%>

<%
	response.setHeader("Cache-Control", "no-cache");
	response.setContentType("application/vnd.ms-excel;name=electroCounterListXLS.xls;charset=windows-1251");
	response.setHeader("Content-Disposition", "attachment;filename=electroCounterListXLS.xls");
%>
<html xmlns:o="urn:schemas-microsoft-com:office:office"
xmlns:x="urn:schemas-microsoft-com:office:excel"
xmlns="http://www.w3.org/TR/REC-html40">
<head>
<meta http-equiv=Content-Type content="application/vnd.ms-excel;name=electroCounterListXLS.xls;charset=windows-1251">
<meta name=ProgId content="Excel.Sheet">
<meta http-equiv="Content-Disposition" content="attachment;filename=electroCounterListXLS.xls">
<meta name=Generator content="Microsoft Excel 9">

</head>

<body>
<table x:str border=1 cellpadding=0 cellspacing=0 style='border-collapse:collapse; border-color:  black; font-size:10pt;'>
	<tr>
	  <th>GSM DAMPS Позиция </th>
	  <th>Зона</th>
	  <th>№</th>
	  <th>Тип</th>
	  <th>Состояние</th>
	  <th>Год</th>
	  <th>Дата посл. поверки</th>
	  <th>Дата след. поверки</th>
	  <th>Энергоснабжение</th>
	</tr>
	<!-- Table body -->
	<logic:iterate id="it" name="browseList" type="ElectroCounter">
		<logic:present name="it">
          <%
            String style = "";
            ElectroCounter ec=(ElectroCounter)it;
            if(ec.getWarning().booleanValue()){
            	style = "style=\"background-color :#FFF799\"";
            }else if(ec.getError().booleanValue()){
            	style = "style=\"background-color :#FF7878\"";
            }
          %>
		<tr <%= style%>>
			<td><bean:write name="it" property="name" filter="true"/></td>
			<td><bean:write name="it" property="zoneName" filter="true"/></td>
			<td><bean:write name="it" property="vendorNumber" filter="true"/></td>					
			<td><bean:write name="it" property="code" filter="true"/></td>
			<td><bean:write name="it" property="stateStr" filter="true"/></td>
			<td><bean:write name="it" property="productionYear" filter="true" /></td>					
			<td><bean:write name="it" property="lastVerification" filter="true"/></td>
			<td><bean:write name="it" property="nextVerification" filter="true"/></td>
			<td><bean:write name="it" property="isVendorPowerSupply" filter="true"/></td>
		</tr>
		</logic:present>					
	</logic:iterate>
</table>

</body>
</html>
