<%@ page language = "java" %>
<%@ page contentType = "application/vnd.ms-excel;name=nfsListDetach.xls;charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import="com.hps.july.util.*"%>
<%@ page import="java.text.*"%>
<%@ page import = "com.hps.july.arenda.formbean.*"%>
<%@ page import = "com.hps.july.arenda.valueobject.*"%>
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
	response.setContentType("application/vnd.ms-excel;name=nfsListDetach.xls;charset=windows-1251");
	response.setHeader("Content-Disposition", "attachment;filename=nfsListDetach.xls");
	//SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
	//com.hps.july.arenda.cdbcobjects.Page reportPage =  (com.hps.july.arenda.cdbcobjects.Page)request.getAttribute("reportPage");
	//System.out.println("page="+ reportPage);
%>
<html xmlns:o="urn:schemas-microsoft-com:office:office"
xmlns:x="urn:schemas-microsoft-com:office:excel"
xmlns="http://www.w3.org/TR/REC-html40">
<head>
<meta http-equiv=Content-Type content="application/vnd.ms-excel;name=nfsListDetach.xls;charset=windows-1251">
<meta name=ProgId content="Excel.Sheet">
<meta http-equiv="Content-Disposition" content="attachment;filename=nfsListDetach.xls">
<meta name=Generator content="Microsoft Excel 9">
</head>

<body>
<table x:str border=1 cellpadding=0 cellspacing=0 style='border-collapse:collapse; border-color:  black; font-size:10pt;'>
	<tr>
		<%--th>№</th--%>	
		<th>номер ЗП</th>
		<th>номер СФ</th>
		<th>сумма СФ</th>
		<th>сост. СФ</th>
		<th>номер ПП</th>
		<th>дата ПП</th>
		<th>сост. ПП</th>
		<th>сумма ПП</th>
		<th>сумма ПП(руб.)</th>
		<th>орг. Beeline</th>
		<th>поставщик</th>
		<th>назначение платежа</th>	
	</tr>
	<!-- Table body -->
	<logic:iterate id="it" name="browseList" indexId="indexId"> 
		<logic:present name="it">
		<%
		    NFS_VO nfsVO = (NFS_VO )it;
			String className = "font-size:8pt;";
			if( !nfsVO.isActiveRecord() )
				className = "font-size:8pt; background-color: gray";
		%>
		<tr id='<bean:write name="indexId"/>' style="<%= className%>">
			<%--th><bean:write name="indexId"/></th--%>
			<td class="text" title='подробно'>
				<logic:present name="it" property="zpNFS">
					<bean:write name="it" property="zpNFS.numZp" filter="true"/>
				</logic:present>
			</td>
			<td class="text">
				<logic:present name="it" property="schetFaktNFS">
					<bean:write name="it" property="schetFaktNFS.numSf" filter="true"/>
				</logic:present>
			</td>
			<td class="text" align="right">
				<logic:present name="it" property="schetFaktNFS">
					<july:sumwrite name="it" property="schetFaktNFS.sumSf"/>&nbsp;<bean:write name="it" property="schetFaktNFS.currSf" filter="true"/>
				</logic:present>
			</td>
			<td class="text">
				<logic:present name="it" property="schetFaktNFS">
					<bean:write name="it" property="schetFaktNFS.stateSf" filter="true"/>
				</logic:present>
			</td>
			<td class="text">
				<logic:present name="it" property="payNFS">
					<bean:write name="it" property="payNFS.numPay" filter="true"/>
				</logic:present>
			</td>
			<td class="text">
				<logic:present name="it" property="payNFS">
					<july:datewrite name="it" property="payNFS.datePay"/>
				</logic:present>
			</td>
			<td class="text">
				<logic:present name="it" property="payNFS">
					<bean:write name="it" property="payNFS.statePay" filter="true"/>
				</logic:present>
			</td>
			<td class="text" align="right">
				<logic:present name="it" property="payNFS">
					<july:sumwrite name="it" property="payNFS.sumPay"/>&nbsp;<bean:write name="it" property="payNFS.currPay" filter="true"/>
				</logic:present>
			</td>
			<td class="text" align="right">
				<logic:present name="it" property="payNFS">
					<july:sumwrite name="it" property="payNFS.sumRubPay"/>
				</logic:present>
			</td>
			<td class="text" align="center">
				<logic:present name="it" property="schetFaktNFS">
					<logic:equal name="it" property="schetFaktNFS.idorgnfs" value="81">
						Вымпелком
					</logic:equal>
					<logic:equal name="it" property="schetFaktNFS.idorgnfs" value="101">
						КБИ
					</logic:equal>
				</logic:present>	
				<logic:notPresent name="it" property="schetFaktNFS">
					<logic:equal name="it" property="zpNFS.idorgnfs" value="81">
						Вымпелком
					</logic:equal>
					<logic:equal name="it" property="zpNFS.idorgnfs" value="101">
						КБИ
					</logic:equal>
				</logic:notPresent>				
			</td>
			<td class="text" align="center">
				<logic:present name="it" property="schetFaktNFS">
						<logic:present name="it" property="schetFaktNFS.vendor">
							<bean:write name="it" property="schetFaktNFS.vendor.name"/>
						</logic:present>
				</logic:present>
				<logic:notPresent name="it" property="schetFaktNFS">
						<logic:present name="it" property="zpNFS.vendor">
							<bean:write name="it" property="zpNFS.vendor.name"/>
						</logic:present>
				</logic:notPresent>
			</td>
			<td class="text" align="center">
				<logic:present name="it" property="payNFS">
					<july:stringwrite name="it" property="payNFS.purpose"/>
				</logic:present>			
			</td>
		</tr>
		<%--july:separator colspan="15"/--%>		
		</logic:present>
	</logic:iterate>
</table>

</body>
</html>
