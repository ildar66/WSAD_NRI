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
	mso-style-name:�������;
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
	mso-number-format:"\#\,\#\#0\.00_�_\.";}
.xl28
	{mso-style-parent:style0;
	font-weight:700;
	font-family:"Arial Cyr", sans-serif;
	mso-font-charset:204;
	mso-number-format:"\#\,\#\#0\.00_�_\.";
	border:.5pt solid black;
	white-space:normal;}
.xl29
	{mso-style-parent:style0;
	mso-number-format:"\#\,\#\#0\.00_�_\.";
	border:.5pt solid black;}
-->
</style>

</head>

<body link=blue vlink=purple>
<july:errors/>
<P><B><bean:write name="ArendaReport3ParamsForm" property="report.type.typeDescription" filter="true"/></B>

<logic:equal name="ArendaReport3ParamsForm" property="report.type.isDataPeriod" value="true" scope="session">
  <P><B>����� �� ������</B> � <%= ArendaReport3ParamsForm.getReport().getDataPeriod().getFromDateFrm() %> ��
  <%= ArendaReport3ParamsForm.getReport().getDataPeriod().getToDateFrm() %> </P>
</logic:equal>

<logic:equal name="ArendaReport3ParamsForm" property="report.type.isData" value="true" scope="session">
	<P><B><bean:write name="ArendaReport3ParamsForm" property="report.type.dataDescription"/>:</B> <%= ArendaReport3ParamsForm.getReport().getDataFrm() %></P>
</logic:equal>

<logic:equal name="ArendaReport3ParamsForm" property="report.type.isOtv" value="true" scope="session">
	<P><B>�������������:</B>
		<%= ArendaReport3ParamsForm.getReport().getOtv().getName() %>
	</P>
</logic:equal>	

<table x:str border=1 cellpadding=0 cellspacing=0 style='border-collapse:collapse;'>

<logic:equal name="ArendaReport3ParamsForm" property="comand" value="getContrArOnOtv" scope="session">
 <tr class=xl27 height=100 style='mso-height-source:userset;height:75.0pt'>
  <td class=xl26>���</td>
  <td class=xl26>����</td>
  <td class=xl26>�����</td>
  <td class=xl26>������</td>
  <td class=xl26>���������</td>
  <td class=xl26>����<br> ��������<br> ��������</td>
  <td class=xl26>�������</td>
  <td class=xl26>������</td>
  <td class=xl26>������������</td>
  <td class=xl26>Beeline</td>
  <td class=xl26>�����<br> ��������</td>
  <td class=xl26>� �.�. ������</td>
  <td class=xl26>������ ��������</td>
  <td class=xl26>���������</td>
  <td class=xl26>���������</td>
  <td class=xl26>���������</td>
  <td class=xl26>����� �����<br>�� ������� ��������</td>
  <td class=xl26>����� ������<br>�� ������� ��������</td>
  <td class=xl26>����� �������<br>�� ������� ��������</td>
  <td class=xl26>�����<br>  �����������<br> ��������</td>
  <td class=xl26>����� ������ ������� �� ����������� �����</td>
  <td class=xl26>����� � ������ ������� �� ������������� �����</td>
 </tr>
</logic:equal>

<logic:equal name="ArendaReport3ParamsForm" property="comand" value="repWarningProlong" scope="session">
 <tr class=xl27 height=100 style='mso-height-source:userset;height:75.0pt'>
  <td class=xl26>����, �� ������� �������������</td>
  <td class=xl26>����� user</td>
  <td class=xl26>� �� GSM</td>
  <td class=xl26>� �� DAMPS</td>
  <td class=xl26>������������ �������</td>
  <td class=xl26>����� ��������</td>
  <td class=xl26>���� ��������</td>
  <td class=xl26>��������</td>
  <td class=xl26>�����������</td>
  <td class=xl26>������ ��������</td>
  <td class=xl26>��������� ��������</td>
  <td class=xl26>������������� ��������� �� �������</td>
  <td class=xl26>������</td>
  <td class=xl26>������� ���������</td>
  <td class=xl26>������</td>
  <td class=xl26>������� ��������� � ��������</td>
  <td class=xl26>���������</td>
 </tr>
</logic:equal>

<logic:equal name="ArendaReport3ParamsForm" property="comand" value="repWarningAkt" scope="session">
 <tr class=xl27 height=100 style='mso-height-source:userset;height:75.0pt'>
  <td class=xl26>������ ����</td>
  <td class=xl26>������������� ���������</td>
  <td class=xl26>� �� GSM</td>
  <td class=xl26>� �� DAMPS</td>
  <td class=xl26>������������ �������</td>
  <td class=xl26>����� ��������</td>
  <td class=xl26>���� ��������</td>
  <td class=xl26>��������</td>
  <td class=xl26>�����������</td>
  <td class=xl26>����� ���������� ����</td>
  <td class=xl26>���� ���������� ����</td>
  <td class=xl26>��������� ��������</td>
  <td class=xl26>���� ��������� ������� ����</td>
  <td class=xl26>����, ����� ����������� ���</td>
  <td class=xl26>���. ��������</td>
  <td class=xl26>��� ����</td>    
  </tr>
</logic:equal>

<logic:equal name="ArendaReport3ParamsForm" property="comand" value="listSfOnOtv" scope="session">
 <tr class=xl27 height=100 style='mso-height-source:userset;height:35.0pt'>
  <td class=xl26>� �� GSM</td>
  <td class=xl26>� �� DAMPS</td>
  <td class=xl26>�������� ��</td>
  <td class=xl26>����� ����������</td>
  <td class=xl26>�������� ����������</td>
  <td class=xl26>� ��</td>
  <td class=xl26>���� ����������</td>
  <td class=xl26>����� ��</td>
  <td class=xl26>��������� ��</td>
  <td class=xl26>����� ��</td>
  <td class=xl26>���</td>
  <td class=xl26>������ ��</td>
  <td class=xl26>��� ������</td>
  <td class=xl26>� �/�</td>
  <td class=xl26>���� �/�</td>
  <td class=xl26>����� �� �/�</td>
  <td class=xl26>����� �� �/� � ���</td>
  <td class=xl26>����</td>
  <td class=xl26>���� ����� � ������� ���</td>
  <td class=xl26>����� �� � ��������</td>
  <td class=xl26>���������<BR> �������</td>
  <td class=xl26>��� ����</td>
  <td class=xl26>���������� �������</td>
  <td class=xl26>� �/� ����������</td>
  <td class=xl26>���� ����������</td>
  <td class=xl26>��� ����� ����������</td>
  <td class=xl26>�������<BR> �����<BR>� NRI</td>
  <td class=xl26>����� ��������</td>
  <td class=xl26>���� ��������</td>
  <td class=xl26>�������������</td>
  <td class=xl26>��� ������<BR> �� ��������</td>
  <td class=xl26>����� ������</td>
  <td class=xl26>��������� ������</td>
  <td class=xl26>����� ��</td>
  <td class=xl26>������ ��</td>
  <td class=xl26>����� ��������</td>
  <td class=xl26>���������</td>
  </tr>
</logic:equal>

<logic:equal name="ArendaReport3ParamsForm" property="comand" value="listAllContractsArenda" scope="session">
 <tr class=xl27 height=60 style='mso-height-source:userset;height:50.0pt'>
  <td class=xl26>���</td>
  <td class=xl26>����</td>
  <td class=xl26>�����</td>
  <td class=xl26>������<br>��������</td>
  <td class=xl26>���������<br>���. ���.</td>
  <td class=xl26>���������<br>��������</td>
  <td class=xl26>����<br>��������<br>��������</td>
  <td class=xl26>������<br>��������</td>
  <td class=xl26>�������� �������</td>
  <td class=xl26>������<br>�����<br>��������</td>
  <td class=xl26>������������<br>���������</td>
  <td class=xl26>������������<br> �����������</td>
  <td class=xl26>����� ��������<br>� ���. ������</td>
  <td class=xl26>� �.�. ������<br>� ���. ������</td>
  <td class=xl26>���. ������<br>��������</td>
  <td class=xl26>�������������<BR>���������</td>
  <td class=xl26>�������������<BR>���������</td>
  <td class=xl26>���������<br>��������</td>
  <td class=xl26>��� ���������<br>��������</td>
  <td class=xl26>������<BR>���������<BR>��������</td>
  <td class=xl26>���<BR>��������</td>
  <td class=xl26>�������������<BR>������</td>
  <td class=xl26>������<BR>������</td>
 </tr>
</logic:equal>

<logic:equal name="ArendaReport3ParamsForm" property="comand" value="workTimeOnEconomist" scope="session">
 <tr class=xl27 height=60 style='mso-height-source:userset;height:50.0pt'>
  <td class=xl26>���</td>
  <td class=xl26>�����</td>
  <td class=xl26>����������<BR> �����������</td>
  <td class=xl26>����������<BR> ���������</td>
  <td class=xl26>����������<BR> �����������</td>
  <td class=xl26>����������<BR> ���. ����������</td>
  <td class=xl26>���������� <BR>��������</td>
  <td class=xl26>���-�� ����� <BR>������������</td>
  <td class=xl26>���-�� ����� <BR>������</td>
  <td class=xl26>���������� �����<BR> ����������� �����</td>
  <td class=xl26>���-�� ������ <BR>������ �� �����</td>
 </tr>
</logic:equal>

<logic:equal name="ArendaReport3ParamsForm" property="comand" value="getListNewContracts" scope="session">
 <tr class=xl27 height=60 style='mso-height-source:userset;height:50.0pt'>
  <td class=xl26>��� ��������</td>
  <td class=xl26>���� ��������</td>
  <td class=xl26>����� ��������</td>
  <td class=xl26>�������� �������</td>
  <td class=xl26>������ ����� ��������</td>
  <td class=xl26>������������ �����������</td>
  <td class=xl26>������������� ���������</td>
  <td class=xl26>������������� ���������</td>
  <td class=xl26>������ + ���� ����</td>
  <td class=xl26>��� ��������</td>
  <td class=xl26>��� ��������</td>
  <td class=xl26>����� ���������</td>
 </tr>
</logic:equal>

<logic:equal name="ArendaReport3ParamsForm" property="comand" value="getListBadCharges" scope="session">
 <tr class=xl27 height=60 style='mso-height-source:userset;height:50.0pt'>
  <td class=xl26>��� ��������</td>
  <td class=xl26>���� ��������</td>
  <td class=xl26>����� ��������</td>
  <td class=xl26>�������� �������</td>
  <td class=xl26>������</td>
  <td class=xl26>������������ �����������</td>
  <td class=xl26>������������� ���������</td>
  <td class=xl26>������������� ���������</td>
  <td class=xl26>������ ������� <BR>����������</td>
  <td class=xl26>��������� ������� <BR>����������</td>
  <td class=xl26>������� ��1</td>
  <td class=xl26>������� ��2</td>
  <td class=xl26>������� ��3</td>
  <td class=xl26>������� ����1</td>
  <td class=xl26>������� ����2</td>
  <td class=xl26>������� ����3</td>
 </tr>
</logic:equal>

<logic:equal name="ArendaReport3ParamsForm" property="comand" value="repYearPriceBS" scope="session">
 <tr class=xl27 height=60 style='mso-height-source:userset;height:50.0pt'>
  <td class=xl26>GSM</td>
  <td class=xl26>DAMPS</td>
  <td class=xl26>������������ �������</td>
  <td class=xl26>����� �������</td>
  <td class=xl26>��������� �������</td>
  <td class=xl26>������������� ���������</td>
  <td class=xl26>��������� ������� �� ��������� ��������� �� ������ � �������� �� ����� �� ������� ����</td>
  <td class=xl26>����� �������� �� ������ �� �� � �������� �� ����� �� ������� ����</td>
  <td class=xl26>����� ������������� �� ������ �� �� � �������� �� ����� �� ������� ����</td>
  <td class=xl26>����� ���� ����������� ��������� �� �������, �� ������ �������� ����� 1 ������ � �������� �� ����� �� ������� ����</td>
  <td class=xl26>���������� �������� ��������� �� ���� ������� �� ��������� �� �������</td>
 </tr>
</logic:equal>

<logic:equal name="ArendaReport3ParamsForm" property="comand" value="repArendaListOfMmOpl" scope="session">
 <tr class=xl27 height=60 style='mso-height-source:userset;height:50.0pt'>
  <td class=xl26>������������ �������</td>
  <td class=xl26>����� ���.</td>
  <td class=xl26>���� ���.</td>
  <td class=xl26>������ ��������</td>
  <td class=xl26>��� ������������</td>
  <td class=xl26>������������</td>
  <td class=xl26>����� ����������</td>
  <td class=xl26>������������ ����������</td>
  <td class=xl26>����� ��</td>
  <td class=xl26>����  ��</td>
  <td class=xl26>����� ��</td>
  <td class=xl26>���������</td>
  <td class=xl26>������ �������� ����</td>
  <td class=xl26>����� ��</td>
  <td class=xl26>��� ��</td>
  <td class=xl26>������</td>
  <td class=xl26>���� ������</td>
  <td class=xl26>���� ��������� �������</td>
  <td class=xl26>����������</td>
  <td class=xl26>���������</td>          
 </tr>
</logic:equal>

<logic:equal name="ArendaReport3ParamsForm" property="comand" value="repArendaListAbonent" scope="session">
 <tr class=xl27 height=40 style='mso-height-source:userset;height:40.0pt'>
  <td class=xl26 style="text-align: center;">�/�</td>
  <td class=xl26 style="text-align: center;">�����<br>��������<br>(BAN)</td>
  <td class=xl26 style="text-align: center;">������</td>
  <td class=xl26 style="text-align: center;">���������</td>
  <td class=xl26 style="text-align: center;">���������</td>
  <td class=xl26 style="text-align: center;">�������</td>
  <td class=xl26 style="text-align: center;">������������</td>
  <td class=xl26 style="text-align: center;">��������</td>
  <td class=xl26 style="text-align: center;">���������</td>
  <td class=xl26 style="text-align: center;">�����<br>�������<br>(������������)</td>
  <td class=xl26 style="text-align: center;">����� �����������<br>����������� ��������</td>
  <td class=xl26 style="text-align: center;">����� �����������<br>�������� ��������</td>
  <td class=xl26 style="text-align: center;">����� ��������<br>�� ����� �/�</td>
  <td class=xl26 style="text-align: center;">������</td>
  <td class=xl26 style="text-align: center;">���<br>���������</td>
  <td class=xl26 style="text-align: center;">�����<br>��������<br>������</td>
  <td class=xl26 style="text-align: center;">%<br>������/�����<br>��������</td>          
  <td class=xl26 style="text-align: center;">����������<br>��������<br>�������</td>
 </tr>  
</logic:equal>

<logic:equal name="ArendaReport3ParamsForm" property="comand" value="repTemplateListZpNextPeriod" scope="session">
 <tr class=xl27 height=100 style='mso-height-source:userset;height:75.0pt'>
  <td class=xl26>����� GSM</td>
  <td class=xl26>����� DAMPS</td>
  <td class=xl26>������������ �������</td>
  <td class=xl26>�������������</td>
  <td class=xl26>����� ��������</td>
  <td class=xl26>���� ��������</td>
  <td class=xl26>����� ����������</td>
  <td class=xl26>��� ����������</td>
  <td class=xl26>������������ ����������</td>
  <td class=xl26>��������� ���� ��</td>
  <td class=xl26>�������� ���� ��</td>
  <td class=xl26>�����������</td>
  <td class=xl26>������</td>
  <td class=xl26>����� �� ��������</td>
  <td class=xl26>����� ��</td>
  <td class=xl26>���</td>
  <td class=xl26>������ ��������</td>
  <td class=xl26>����� ����������<br>�� ������ ��� ���</td>
  <td class=xl26>��� �� ����� ����������</td>
  <td class=xl26>��������� ������ ������</td>
  <td class=xl26>������ ��������</td>
  <td class=xl26>��� ���������</td>   
  </tr>
</logic:equal>

<logic:equal name="ArendaReport3ParamsForm" property="comand" value="repContractCustomersOnPeriod" scope="session">
 <tr class=xl27 height=40 style='mso-height-source:userset;height:40.0pt'>
  <td class=xl26>� ��������</td>
  <td class=xl26>����<br>������</td>
  <td class=xl26>����<br>���������</td>
  <td class=xl26>���������</td>
  <td class=xl26>����������</td>
  <td class=xl26>���</td>
  <td class=xl26>���</td>
  <td class=xl26>�����</td>
  <td class=xl26>�/��</td>
  <td class=xl26>���</td>
  <td class=xl26>������������<br>�����</td>
  <td class=xl26>������<br>�� ��������</td>
  <td class=xl26>�����<br>� ���</td>
  <td class=xl26>�����<br>� �����</td>
  <td class=xl26>������</td>
  <td class=xl26>�������� �������</td>
 </tr>
</logic:equal>

<logic:equal name="ArendaReport3ParamsForm" property="comand" value="repListContractsForNFS" scope="session">
 <tr class=xl27 height=15 style='mso-height-source:userset;height:15.0pt'>
	 <td class=xl26 rowspan="3" style="text-align: center;">��������� ��������</td>
	 <td class=xl26 rowspan="3" style="text-align: center;">� �����</td>
	 <td class=xl26 rowspan="3" style="text-align: center;">� ��</td>
	 <td class=xl26 rowspan="3" style="text-align: center;">� ��������</td>
	 <td class=xl26 rowspan="3" style="text-align: center;">������������</td>
	 <td class=xl26 colspan="4" style="text-align: center;">���� �������� ��������</td>
	 <td class=xl26 colspan="2" style="text-align: center;">��������� ��������</td>
	 <td class=xl26 colspan="3" style="text-align: center;">������� �������</td>
	 <td class=xl26 rowspan="3" style="text-align: center;">������</td>
	 <td class=xl26 rowspan="3" style="text-align: center;">��������� ����<br>(�����������)<br>��������� ��������</td>
 </tr>  
 <tr class=xl27 height=15 style='mso-height-source:userset;height:15.0pt'>  
	 <td class=xl26 colspan="2" style="text-align: center;">��������������</td>
	 <td class=xl26 colspan="2" style="text-align: center;">����������� � ��������� ����� (�����������)</td>
	 <td class=xl26 rowspan="2" style="text-align: center;">������</td>
	 <td class=xl26 rowspan="2" style="text-align: center;">������</td>
	 <td class=xl26 rowspan="2" style="text-align: center;">������</td>
	 <td class=xl26 rowspan="2" style="text-align: center;">���-�� ����</td>
	 <td class=xl26 rowspan="2" style="text-align: center;">��� �������</td>
 </tr>  
 <tr class=xl27 height=15 style='mso-height-source:userset;height:15.0pt'>	 
	 <td class=xl26 style="text-align: center;">�</td>
	 <td class=xl26 style="text-align: center;">��</td>
	 <td class=xl26 style="text-align: center;">�</td>
	 <td class=xl26 style="text-align: center;">��</td>	 
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
			
<!-- ����� ��� �������-->
<logic:equal name="ArendaReport3ParamsForm" property="comand" value="fillTmpListPayOnCategory" scope="session">
	<% 
		Page aPage = (Page)request.getAttribute("reportPage");
		java.math.BigDecimal[] listSum = PageHelper.getListSumForPage(aPage);
		//System.out.print("size=" + listSum.length);
	%>
	<%if(listSum != null && listSum.length > 0){%>
	<tr height=17 style='height:12.75pt'>
		<td class=xl26 style="text-align: center;" colspan="4">
			����� �� ����������
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
