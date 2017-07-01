<%@ page language = "java" %>
<%@ page contentType = "application/vnd.ms-excel;name=leaseProblemList.xls;charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import="com.hps.july.util.*"%>
<%@ page import="java.text.*"%>
<%@ page import = "com.hps.july.arenda.formbean.*"%>
<%@ page import = "com.hps.july.valueobject.*"%>
<%!
//����������� ����:
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
	response.setContentType("application/vnd.ms-excel;name=leaseProblemList.xls;charset=windows-1251");
	response.setHeader("Content-Disposition", "attachment;filename=leaseProblemList.xls");
	//SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
	//com.hps.july.arenda.cdbcobjects.Page reportPage =  (com.hps.july.arenda.cdbcobjects.Page)request.getAttribute("reportPage");
	//System.out.println("page="+ reportPage);
%>
<html xmlns:o="urn:schemas-microsoft-com:office:office"
xmlns:x="urn:schemas-microsoft-com:office:excel"
xmlns="http://www.w3.org/TR/REC-html40">
<head>
<meta http-equiv=Content-Type content="application/vnd.ms-excel;name=leaseProblemList.xls;charset=windows-1251">
<meta name=ProgId content="Excel.Sheet">
<meta http-equiv="Content-Disposition" content="attachment;filename=leaseProblemList.xls">
<meta name=Generator content="Microsoft Excel 9">

</head>

<body>
<table x:str border=1 cellpadding=0 cellspacing=0 style='border-collapse:collapse; border-color:  black; font-size:10pt;'>
	<tr>
	  <th>�����</th>
	  <th>���</th>
	  <th>�������</th>
	  <th>�������</th>
	  <th>���� ��������</th>
	  <th>�������� ��������</th>
	  <th>�����������</th>
	  <th>���������</th>
	  <th>���������</th>
	</tr>
	<!-- Table body -->
	<logic:iterate id="it" name="browseList" type="LeaseContractProblem_TO">
		<logic:present name="it">
		<tr>
			<td><bean:write name="it" property="vo.idProblem" filter="true" /></td>
			<td>
				<%--logic:equal name="it" property="vo.typeProblem" value="1">������ �������� ��</logic:equal>
				<logic:equal name="it" property="vo.typeProblem" value="2">������ �������� ������</logic:equal>
				<logic:equal name="it" property="vo.typeProblem" value="3">����������� ����.���.</logic:equal>
				<logic:equal name="it" property="vo.typeProblem" value="4">����������� ����������� ���� ������������</logic:equal>
				<logic:equal name="it" property="vo.typeProblem" value="5">������������� �� ������������ ��������</logic:equal--%>
				<bean:write name="it" property="vo.typeProblemStr" filter="true"/>
			</td>
			<td><bean:write name="it" property="listPosContract" filter="true" /></td>					
			<td><bean:write name="it" property="docNumber" filter="true" /> �� <july:datewrite name="it" property="docDate" /></td>
			<td><july:datewrite name="it" property="vo.created" /></td>
			<td><bean:write name="it" property="vo.note" filter="true" /></td>					
			<td><bean:write name="it" property="executorName" filter="true"/></td>
			<td><bean:write name="it" property="ownerName" filter="true"/></td>
			<td>
				<logic:equal name="it" property="vo.state" value="1">�������������</logic:equal>
				<logic:equal name="it" property="vo.state" value="2">�������� �� ������������</logic:equal>
				<logic:equal name="it" property="vo.state" value="3">���������</logic:equal>
			</td>
		</tr>
		</logic:present>					
	</logic:iterate>
</table>

</body>
</html>
