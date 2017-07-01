<%@ page language = "java" %>
<%@ page contentType = "application/vnd.ms-excel;name=report.xls;charset=windows-1251" %>
<%@ page import="java.util.*,java.math.*,java.text.*,com.hps.july.inventory.formbean.*,org.apache.struts.util.*" %>
<%@ page import="com.hps.july.report.word.*" %>

<%
	Report9ParamsForm rp = (Report9ParamsForm)session.getAttribute("Report9ParamsForm");
/*
	String p = "";
	p += "prompt0="+java.net.URLEncoder.encode(rp.getSerial().trim());

	String redirectURL = "./../crystalclear/report9.jsp?" + p;
	response.sendRedirect(redirectURL);*/

	response.setHeader("Cache-Control", "");
	response.setContentType("application/vnd.ms-excel;name=report.xls;charset=windows-1251");
	response.setHeader("Content-Disposition", "attachment;filename=report.xls");
	SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
	
	Engine engine = new Engine();

	String prompt0 = rp.getSerial().trim();
	
	engine.setPrompt(new Object[]{prompt0});
	new com.hps.july.report.word.ResHistoryReport().getReportData( engine, "configs" );
%>

<html xmlns:o="urn:schemas-microsoft-com:office:office"
xmlns:x="urn:schemas-microsoft-com:office:excel"
xmlns="http://www.w3.org/TR/REC-html40">
<head>
<meta http-equiv=Content-Type content="application/vnd.ms-excel;name=report.xls;charset=windows-1251">
<meta name=ProgId content="Excel.Sheet">
<meta http-equiv="Content-Disposition" content="attachment;filename=report.xls">
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
	text-align:center;
	vertical-align:center;
	white-space:wrap;
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
	text-align:center;
	vertical-align:center;
	border:1;
	mso-background-source:auto;
	mso-pattern:auto;
	mso-protection:locked visible;
	white-space:wrap;
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
	

<table x:str border=1 cellpadding=0 cellspacing=0 style='border-collapse:collapse;'>

<%if(engine.getData() == null) {%>
	<tr class=xl27 height=50 style='mso-height-source:userset;height:50.0pt'>
	<td colspan=8>
			<B>������ ���������� ��. ���</B>
	</td>
	</tr>
<%}else if(engine.getData().length == 0) {%>
	<tr class=xl27 height=50 style='mso-height-source:userset;height:50.0pt'>
	<td colspan=8>
			<B>��� ������</B>
	</td>
	</tr>
<%}else{%>	

 <tr style='mso-height-source:userset;height:20.0pt'>
			<td colspan=6 style='text-align:left;border:0'><b>����� �� ������� ����������� ������������</b></td>
 </tr>
 <tr style='mso-height-source:userset;height:20.0pt'>
			<td colspan=6 style='text-align:left;border:0'><b>�������� ��������� �����: <%=  engine.getData(0,"resmanuf") %></b></td>
 </tr>
 <tr class=xl27 height=50 style='mso-height-source:userset;height:50.0pt'>
			<td>����</td>
			<td>��������</td>
			<td>N � ���� ���������<br>(����)</td>
			<td>�������� ��������������</td>
			<td>�������� ��������������</td>
			<td>�������� ����������</td>
 </tr>
	
    <% String oldStorageCard = ""; %>
 
		<% for (int i = 0; i < engine.getData().length; i++) { %>
			<tr>
					<%
						String docname = (String)engine.getData(i,"docname");
						String doc = "";
						if(docname.equals("s.external.waybill")) doc = "������� ��������� �����";
						else if(docname.equals("s.internal.waybill")) doc = "���������� ��������� �����";
						else if(docname.equals("p.assembling")) doc = "��� ������� �� �������";
						else if(docname.equals("s.internal.outbill")) doc = "���������� ��������� ���������";
						else if(docname.equals("p.dismantling")) doc = "��� ��������� �� �������";
						else if(docname.equals("s.external.outbill")) doc = "������� ��������� ���������";
						else if(docname.equals("s.payoff")) doc = "��� �������� �� ������";
						else if(docname.equals("e.payoff")) doc = "��� �������� � ����������";
						else if(docname.equals("p.payoff")) doc = "��� �������� � �������";
						else if(docname.equals("s.payoff.i")) doc = "��� �������������� �� ������ (����������)";
						else if(docname.equals("e.payoff.i")) doc = "��� �������������� � ������������ (����������)";
						else if(docname.equals("p.payoff.i")) doc = "��� �������������� �� ������� (����������)";
						else if(docname.equals("s.payoff.h")) doc = "��� ������/������������ �� ������ (��������)";
						else if(docname.equals("e.payoff.h")) doc = "��� ������ ��� ������� (��������)";
						else if(docname.equals("p.payoff.h")) doc = "��� ������/������������ �� ������� (��������)";
						else if(docname.equals("contract")) doc = "��������";
						else if(docname.equals("s.surplus")) doc = "��� � ��������� �������� �� ������";
						else if(docname.equals("p.surplus")) doc = "��� � ��������� �������� �� �������";
						else if(docname.equals("e.surplus")) doc = "��� � ��������� ��������";
						else if(docname.equals("s.surplus.i")) doc = "��� �������������� �� ������ (�����)";
						else if(docname.equals("p.surplus.i")) doc = "��� �������������� �� ������� (�����)";
						else if(docname.equals("e.surplus.i")) doc = "��� �������������� � ���������� (�����)";
						else if(docname.equals("s.surplus.h")) doc = "��� ������/������������ �� ������ (������)";
						else if(docname.equals("p.surplus.h")) doc = "��� ������/������������ �� ������� (������)";
						else if(docname.equals("e.surplus.h")) doc = "��� ������ ��� ������� (������)";
						else if(docname.equals("s.inventarization")) doc = "��� �������������� �� ������";
						else if(docname.equals("s.inventarization.s")) doc = "��� �������������� �� ������ (�����)";
						else if(docname.equals("s.inventarization.p")) doc = "��� �������������� �� ������ (����������)";
						else if(docname.equals("p.inventarization")) doc = "��� �������������� �� �������";
						else if(docname.equals("p.inventarization.s")) doc = "��� �������������� �� ������� (�����)";
						else if(docname.equals("p.inventarization.p")) doc = "��� �������������� �� ������� (����������)";
						else if(docname.equals("s.assembling.block")) doc = "��� ������� ������ �� ������";
						else if(docname.equals("p.assembling.block")) doc = "��� ������� ������ �� �������";
						else if(docname.equals("s.dismantling.block")) doc = "��� ��������� ������ �� ������";
						else if(docname.equals("p.dismantling.block")) doc = "��� ��������� ������ �� �������";
						else if(docname.equals("s.change")) doc = "��� ������/������������ �� ������";
						else if(docname.equals("s.change.payoff")) doc = "��� ������/������������ �� ������ (��������)";
						else if(docname.equals("s.change.surplus")) doc = "��� ������/������������ �� ������ (������)";
						else if(docname.equals("e.change")) doc = "��� ������ ��� �������";
						else if(docname.equals("e.change.payoff")) doc = "��� ������ ��� ������� (��������)";
						else if(docname.equals("e.change.surplus")) doc = "��� ������ ��� ������� (������)";
						else if(docname.equals("p.change")) doc = "��� ������/������������ �� �������";
						else if(docname.equals("p.change.payoff")) doc = "��� ������/������������ �� ������� (��������)";
						else if(docname.equals("p.change.surplus")) doc = "��� ������/������������ �� ������� (������)";
						else if(docname.equals("s.request")) doc = "����������";
						else if(docname.equals("fault")) doc = "Fault Report";
						else if(docname.equals("p.afsmount")) doc = "��� ������� ���";
						else doc = docname;
						String storageCard = (String)engine.getData(i,"storename");
            if (!oldStorageCard.equals(storageCard)) {
              oldStorageCard = storageCard;
					%>
					
					       <TD colspan=6 style='text-align:left;'><%= engine.getData(i,"resname") %><BR>
                      <%= engine.getData(i,"resserial") %>
                 </TD>
					   </TR>
					   <TR>
					
					
					<% } %>


					<td><%= engine.getDateStr(i,"opdate") %></td>
					<td style='text-align:left'><%= doc %></td>
					<td style='text-align:left'><%= engine.getData(i,"docnum") %></td>
					<td style='text-align:left'><%= engine.getData(i,"storesrc") %></td>
					<td style='text-align:left'><%= engine.getData(i,"storedest") %></td>
					<td style='text-align:left'><%= engine.getData(i,"headres") %></td>
					
			</tr>
		<% } %>
<%}%>

</table>

</body>

</html>
