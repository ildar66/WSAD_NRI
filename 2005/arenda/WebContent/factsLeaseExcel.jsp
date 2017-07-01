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
//определяем цвет клетки:
final String colorRED = "background: red;";
final String colorYELLOW = "background: yellow;";
final String colorGREEN = "background: green;";
final String colorNULL = "";
private String getColorBG(String flag){
	if("R".equals(flag))
		return colorRED;
	else if("Y".equals(flag))
		return colorYELLOW;
	else if("G".equals(flag))
		return colorGREEN;				
	else
		return colorNULL;
}
%>
<%
	response.setHeader("Cache-Control", "no-cache");
	response.setContentType("application/vnd.ms-excel;name=factsLeaseExcel.xls;charset=windows-1251");
	response.setHeader("Content-Disposition", "attachment;filename=factsLeaseExcel.xls");
	//SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
	//com.hps.july.arenda.cdbcobjects.Page reportPage =  (com.hps.july.arenda.cdbcobjects.Page)request.getAttribute("reportPage");
	//System.out.println("page="+ reportPage);
%>
<html xmlns:o="urn:schemas-microsoft-com:office:office"
xmlns:x="urn:schemas-microsoft-com:office:excel"
xmlns="http://www.w3.org/TR/REC-html40">
<head>
<meta http-equiv=Content-Type content="application/vnd.ms-excel;name=factsLeaseExcel.xls;charset=windows-1251">
<meta name=ProgId content="Excel.Sheet">
<meta http-equiv="Content-Disposition" content="attachment;filename=factsLeaseExcel.xls">
<meta name=Generator content="Microsoft Excel 9">

</head>

<body>
<table x:str border=1 cellpadding=0 cellspacing=0 style='border-collapse:collapse; border-color:  black; font-size:10pt;'>
 <tr>
  	<th>номер</th>
  	<th>дата</th>
  	<th>наименование</th>
	<logic:iterate id="it" name="FactsLeasePageForm" property="page.headers" scope="session">
		<%java.sql.Date to = (java.sql.Date) it; //int pos = to.getStoragePlace();%>
		<td nowrap colspan="4" align="middle" style="width:100px; border-right-width: 1.5pt;border-right-color: black;">&nbsp;<%=dateStr(to)%></td>
	</logic:iterate>  
 </tr>
<!-- Table body -->
<logic:iterate id="it" name="FactsLeasePageForm" property="page.list" scope="session">
	<% 
		FactsLeaseTO to = (FactsLeaseTO) it;
		String docNumber = to.getDocNumber();
		java.util.ArrayList statusList = to.getStatuses();		 
	%>
		<tr>
			<td><%=to.getDocNumber()%></td>
			<td><%=dateStr(to.getDocDate())%></td>
			<td nowrap><%=to.getName()%></td>
			
			<%
				if(statusList != null){
					for (java.util.Iterator iter = statusList.iterator(); iter.hasNext();) {
					 FactsLeaseColStatusDogOnDate status = (FactsLeaseColStatusDogOnDate) iter.next();
			%>
						<td nowrap title="по договору: <%= docNumber + status.getHintCharge()%>" align="middle" style="width: 5pt;<%= getColorBG(status.getColorCharge())%>">нч</td>
						<td nowrap title="по договору: <%= docNumber + status.getHintSF()%>" align="middle" style="width: 5pt;<%= getColorBG(status.getColorSF())%>">сф</td>
						<td nowrap title="по договору: <%= docNumber + status.getHintCWA()%>" align="middle" style="width: 5pt;<%= getColorBG(status.getColorCWA())%>">ав</td>
						<td nowrap title="по договору: <%= docNumber + status.getHintPay()%>" align="middle" style="width:5pt; border-right-width:1.5pt; border-right-color:black;<%= getColorBG(status.getColorPay())%>">пл</td>
				<%  }  %>						
			<%  }  %>
			
		</tr>
</logic:iterate>
</table>

</body>
</html>
