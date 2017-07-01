<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import = "com.hps.july.arenda.formbean.*"%>

<%	String form = "ListFromPositionForm"; %>

<html>
<head>
<META HTTP-EQUIV = "Pragma" CONTENT="no-cache">
<title>���������� ��������</title>
<link rel="stylesheet" type="text/css" href="/main.css">
</head>

<body>

<table class="main">
    <tr class="title">
    	<td class="title" colspan="2">
          <july:closebutton page="/"/>
          <july:printerbutton/> 
        </td>
    </tr>
    
    <july:separator/>
    
    <TR class="printable">
    <TD class="printable">

 <logic:present name="<%= form %>" property="position.dopInfoVO" scope="session">
 
<table class="print" STYLE="FONT-FAMILY: Arial,Verdana; FONT-SIZE: 8pt;">
	<tr class="print">
		<td colspan="2" STYLE="FONT-SIZE: 10pt;"><b>�������������� ���������� � �������</b>:</td>
		<td colspan="2" STYLE="FONT-SIZE: 10pt;"><b>����������</b>:</td>
	</tr>

	<tr class="print">
		<td align="right" width="15%" class="print"><I>����� ���������� ������:</I></td>
		<td align="left" width="35%" class="print" style="font-weight: bold">
			<bean:write name="<%= form %>" property="position.dopInfoVO.antennPlaceName"/>
		</td>
		<td align="right" width="15%" class="print"><I>��� ����������:</I></td>
		<td align="left" width="35%" class="print" style="font-weight: bold">
			<bean:write name="<%= form %>" property="position.dopInfoVO.apparatTypeName"/>
		</td>
	</tr>
	<tr class="print">
		<td colspan="2" STYLE="FONT-SIZE: 10pt;"><b>�����</b>:</td>
		<td align="right" width="15%" class="print"><I>��������������� ����������:</I></td>
		<td align="left" width="35%" class="print" style="font-weight: bold">
			<bean:write name="<%= form %>" property="position.dopInfoVO.apparatPlaceName"/>
		</td>
	</tr>
	<tr class="print">
		<td align="right" class="print"><I>����� ���������� �����:</I></td>
		<td align="left" class="print" style="font-weight: bold">
			<bean:write name="<%= form %>" property="position.dopInfoVO.oporaPlaceName"/>
		</td>
		<td align="right" class="print"><I>��� ���������:</I></td>
		<td align="left" class="print" style="font-weight: bold">
			<bean:write name="<%= form %>" property="position.dopInfoVO.applaceTypeName"/>
		</td>
	</tr>
	<tr class="print">
		<td align="right" class="print"><I>����� �����:</I></td>
		<td align="left" class="print" style="font-weight: bold">
			<bean:write name="<%= form %>" property="position.dopInfoVO.oporaour"/>
		</td>
		<td colspan="2">&nbsp;</td>
	</tr>
</table>

</logic:present>


    </TD>
    </TR>
    <july:separator/>
    
    <tr class="title">
    	<td class="title" colspan="2">
          <july:closebutton page="/"/>
          <july:printerbutton/> 
        </td>
    </tr>
    
</table>
</body>
</html>