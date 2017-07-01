<%@ page language = "java" %>
<%@ page contentType = "application/vnd.ms-excel;name=report.xls;charset=windows-1251" %>
<%@ page import="java.util.*,java.math.*,java.text.*,com.hps.july.inventory.formbean.*,org.apache.struts.util.*" %>
<%@ page import="com.hps.july.report.word.*" %>

<%
	Report5ParamsForm rp = (Report5ParamsForm)session.getAttribute("Report5ParamsForm");

	response.setHeader("Cache-Control", "");
	response.setContentType("application/vnd.ms-excel;name=report.xls;charset=windows-1251");
	response.setHeader("Content-Disposition", "attachment;filename=report.xls");
	SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
		
	Engine engine = new Engine();

	String prompt0param = request.getParameter("prompt0");
	Long prompt0 = new Long(0);
	Long prompt1 = new Long(rp.getStoragetype());

	String posType = "";
	switch(prompt1.intValue()){
	case 1:  posType = "�� �������";break;
	case 2:  posType = "�� �����";break;
	case 3:  posType = "� �������������� ��������: ";break;
	default: posType = "";
	}

	String s2="";
	if("2".equals(rp.getStoragetype())) {
		s2= rp.getStorageFrm();
	} else if("1".equals(rp.getStoragetype())) {
		s2= rp.getPositionFrm();
	} else if("3".equals(rp.getStoragetype())) {
		s2= rp.getEquipmentFrm();
	}
	Object[] prompt2 = new Object[]{new Long(s2)};
	Boolean prompt3 = new Boolean(true);
	java.sql.Timestamp prompt4 = new java.sql.Timestamp(System.currentTimeMillis());	
	java.sql.Timestamp prompt5 = new java.sql.Timestamp(rp.getDatefrom().getTime());	
	java.sql.Timestamp prompt6 = new java.sql.Timestamp(rp.getDateto().getTime());
	Long prompt7 = new Long(rp.getResourcecode());
	Boolean prompt8 = rp.getDocAll();
	Boolean prompt9 = rp.getDocIntincome();
	Boolean prompt10 = rp.getDocExtincome();
	Boolean prompt11 = rp.getDocAssact();
	Boolean prompt12 = rp.getDocAssactb();
	Boolean prompt13 = rp.getDocInvextra();
	Boolean prompt14 = rp.getShowContract();

	String type = "";
	if(rp.getShowContract().booleanValue()) {
		type = "2";
	} else {
		type = "1";
	}
	
	engine.setPrompt(new Object[]{prompt0,prompt1,prompt2,prompt3,prompt4,prompt5,prompt6,prompt7,prompt8,
	prompt9,prompt10,prompt11,prompt12,prompt13,prompt14});
	new Report05().getReportData( engine, "configs" );
	
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
	<td colspan=9>
			<B>������ ���������� ��. ���</B>
	</td>
	</tr>
<%}else if(engine.getData().length == 0) {%>
	<tr class=xl27 height=50 style='mso-height-source:userset;height:50.0pt'>
	<td colspan=9>
			<B>��� ������</B>
	</td>
	</tr>
<%}else{%>	

 <tr style='mso-height-source:userset;height:15.0pt'>
			<td colspan=<%if(type.equals("2")){%>10<%}else{%>8<%}%> style='text-align:left;border:0'><b>��������� ����� � ������� ������������ <%=posType%> <%= engine.getData(0,"posname") %></b></td>
 </tr> 
 
 <tr style='mso-height-source:userset;height:20.0pt'>
			<%String datefrom = prompt5.getDate() + "." + (prompt5.getMonth()+1) + "." + (prompt5.getYear()+1900);
			  String dateto = prompt6.getDate() + "." + (prompt6.getMonth()+1) + "." + (prompt6.getYear()+1900);
			%>
			<td colspan=<%if(type.equals("2")){%>5<%}else{%>4<%}%> style='text-align:left;border:0'><b>�� ������ � <%=datefrom%> �� <%=dateto%></b></td>
			<td colspan=<%if(type.equals("2")){%>5<%}else{%>4<%}%> style='text-align:right;border:0'>������: <b><%=  engine.getData(0,"curname") %></b></td>
 </tr>
 <tr style='mso-height-source:userset;height:15.0pt'>
			<%
			  String datecur = prompt4.getDate() + "." + (prompt4.getMonth()+1) + "." + (prompt4.getYear()+1900);
			%>
			<td colspan=<%if(type.equals("2")){%>10<%}else{%>8<%}%> style='text-align:right;border:0'><b>����� ������� �� <%=datecur%></b></td>
 </tr>
 <tr style='mso-height-source:userset;height:15.0pt'>			
			<td colspan=<%if(type.equals("2")){%>10<%}else{%>8<%}%> style='text-align:left;border:0'><b>������������ <%=  engine.getData(0,"type") %></b></td>
 </tr>

 <tr class=xl27 height=50 style='mso-height-source:userset;height:50.0pt'>
			<td>����</td>
			<td>��� ���������</td>
			<td>� ���������</td>
			<td>���. N/<BR>N ������</td>			
			<td>���-��</td>
			<td>��.<br>���.</td>
			<td>����</td>
			<td>�����</td>
			<%if(type.equals("2")){%>
			<td>��������</td>
			<td>��������</td>
			<%}%>
 </tr>
	
 
		<% 
			double sum = 0.0;
			double count = 0.0;
			for (int i = 0; i < engine.getData().length; i++) { %>
			<tr>
					<td style='text-align:left'><%= engine.getData(i,"delivdate") %></td>
					<td style='text-align:left'><%= engine.getData(i,"doctype") %></td>
					<td style='text-align:left'><%= engine.getData(i,"numdoc") %></td>
					<td style='text-align:left'><%= engine.getData(i,"serno") %></td>					
					<td><%= engine.getData(i,"qty") %></td>
					<td><%= engine.getData(i,"unitname") %></td>
					<td><%= engine.getData(i,"price") %></td>
					<td><%= engine.getData(i,"suma") %></td>
					<%if(type.equals("2")){%>
					<td><%= engine.getData(i,"contract") %></td>
					<td><%= engine.getData(i,"postavka") %></td>
					<%}%>
			</tr>
			<%
			sum=sum+((java.math.BigDecimal)engine.getData(i,"suma")).doubleValue();
			count=count+((java.math.BigDecimal)engine.getData(i,"qty")).doubleValue();
			%>
		<% } %>
<tr>
			<td colspan=4 style='text-align:left;'><b>�����:</b></td>
			<td style='text-align:center' colspan=1 style='text-align:left;'><b><%=count%></b></td>
			<td colspan=2 style='text-align:left;'>&nbsp;</td>
			<td style='text-align:center' colspan=1 style='text-align:left;'><b><%=sum%></b></td>
			<%if(type.equals("2")){%>
			<td colspan=2 style='text-align:left;'>&nbsp;</b></td>
			<%}%>
</tr>

<tr style='mso-height-source:userset;height:20.0pt'>
			<td colspan=<%if(type.equals("2")){%>10<%}else{%>8<%}%> style='text-align:left;'>����� ������� <%=datecur%> </td>
</tr>		
		
<%}%>

</table>

</body>

</html>