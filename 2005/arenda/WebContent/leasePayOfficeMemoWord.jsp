<!-- ��������� ������� �� ������ -->
<%@ page language = "java" %>
<%@ page contentType = "application/msword; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import="com.hps.july.valueobject.*"%>
<%
	response.setHeader("Cache-Control", "no-cache");
	response.setContentType("application/msword;name=leasePayOfficeMemoWord.doc;charset=Windows-1251");
	response.setHeader("Content-Disposition", "attachment;filename=leasePayOfficeMemoWord.rtf");
	
	String form = "LeasePayOfficeMemoWordForm";
	com.hps.july.arenda.formbean.LeasePayOfficeMemoWordForm aform =  (com.hps.july.arenda.formbean.LeasePayOfficeMemoWordForm)request.getAttribute(form); 
	java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
	java.util.Date curDate = new java.util.Date(System.currentTimeMillis());
	String curDateStr = format.format(curDate);
	//String rurStr = String.valueOf(com.hps.july.util.AppUtils.getNamedValueInt("RUR"));	
%>
<html xmlns:o="urn:schemas-microsoft-com:office:office"
xmlns:w="urn:schemas-microsoft-com:office:word"
xmlns="http://www.w3.org/TR/REC-html40">
<head>
  <meta http-equiv="Content-Type" content="application/msword; charset=Windows-1251">
  <meta http-equiv="Content-Disposition" content="attachment;filename=leasePayOfficeMemoWord.rtf">
  <meta name=ProgId content=Word.Document>
  <title>��������� ������� �� ������.</title>
<STYLE>  
@page Section1
	{size:595.3pt 841.9pt;
	margin:27.0pt 42.5pt 35.95pt 3.0cm;
	mso-header-margin:35.4pt;
	mso-footer-margin:35.4pt;
	mso-paper-source:0;}

div.Section1
	{page:Section1;} 
p
	{mso-style-parent:"";
	margin:0cm;
	margin-bottom:.0001pt;
	mso-pagination:widow-orphan;
	font-size:12.0pt;
	font-family:"Times New Roman";
	mso-fareast-font-family:"Times New Roman";
}

TABLE {
	FONT-FAMILY: Times New Roman,Arial,Verdana; FONT-SIZE: 10pt;
}

TD.tsilver {
	border:solid silver .5pt;
	border-right:none;
	background: #EAEAEA;
	padding:0cm 5.4pt 0cm 5.4pt;
}

<!--[if gte mso 9]>
<xml>
 <w:WordDocument>
  <w:View>Print</w:View>
  <w:DoNotOptimizeForBrowser/>
 </w:WordDocument>
</xml>
<![endif]-->

</STYLE>
</head> 
<html:errors/>

<body>
<DIV class=Section1 STYLE="FONT-FAMILY: Arial,Verdana; FONT-SIZE: 10pt; line-height:100%">

	<table border="1" style="margin-left:122.4pt;border-collapse:collapse;border:none;mso-border-alt:solid silver .5pt;mso-padding-alt:0cm 5.4pt 0cm 5.4pt">
		<tr>
			<td width="244" align= "right" style='width:182.95pt;'>���. �������������</td>
			<td width="115" align= "right">&nbsp;</td>
			<td width="115" align= "right">&nbsp;</td>
		</tr>
<%--		
		<tr>
			<td align= "right">����������� �������� �������</td>
			<td align= "right">&nbsp;</td>
			<td align= "right">&nbsp;</td>
		</tr>
--%>		
		<tr>
			<td>&nbsp;</td>
			<td align= "right" valign=top style='width:86.6pt;font-size:8.0pt'>�������</td>
			<td align= "right" valign=top style='width:86.6pt;font-size:8.0pt'>����</td>
		</tr>				
	</table>
	
	<p><b style='mso-bidi-font-weight:normal'><span
	style='font-size:14.0pt'><o:p>&nbsp;</o:p></span></b></p>	
	
	<p align=center style='text-align:center'><b style='mso-bidi-font-weight:
	normal'><span style='font-size:14.0pt'>��������� ������� �� ������ </span></b><b
	style='mso-bidi-font-weight:normal'><span lang=EN-US style='font-size:14.0pt;
	mso-ansi-language:EN-US'>N</span></b><b style='mso-bidi-font-weight:normal'><span
	style='font-size:14.0pt'> <U><bean:write name="LeasePayOfficeMemoWordForm" property="to.vo.idOfficeMemo" filter="true" /></U>
	<span class=GramE>��</span> <U><july:datewrite name="LeasePayOfficeMemoWordForm" property="to.vo.created"/></U><o:p></o:p></span></b></p>
	
	<p><b style='mso-bidi-font-weight:normal'><span
	style='font-size:14.0pt'><o:p>&nbsp;</o:p></span></b></p>
	
	<p><b style='mso-bidi-font-weight:normal'>����� ��� ����
	���������� �� ������ �� ���������:<o:p></o:p></b></p>
	<table border="1" style="border-collapse:collapse;border:none;mso-border-alt:solid silver .5pt;mso-padding-alt:0cm 5.4pt 0cm 5.4pt">
		<tr>
			<td width="127">�������</td>
			<td width="517">� <U><bean:write name="LeasePayOfficeMemoWordForm" property="contractInfo.docNumber" filter="true" /></U> �� <july:datewrite name="LeasePayOfficeMemoWordForm" property="contractInfo.docDate" /></td>
		</tr>
		<logic:present name="LeasePayOfficeMemoWordForm" property="dataZP">
		<tr>
			<td width="127">��:</td>
			<td width="517">
				�:<bean:write name="<%= form %>" property="dataZP.numZp"/>;
				�����:<bean:write name="<%= form %>" property="dataZP.sumZp"/><bean:write name="<%= form %>" property="dataZP.currZp"/>;
				���:<bean:write name="<%= form %>" property="dataZP.ndsZp"/>;
				���������:���=<bean:write name="<%= form %>" property="dataZP.vendor.vendorcode"/>;
				���������:<bean:write name="<%= form %>" property="dataZP.site.name"/>;
				���:<bean:write name="<%= form %>" property="dataZP.vendor.inn"/>
			</td>
		</tr>
		</logic:present>		
		<tr>
			<td>�����������</td>
			<td>��� <U><bean:write name="LeasePayOfficeMemoWordForm" property="contractInfo.orgExecutorInn" filter="true" /></U> ������������ <U><bean:write name="LeasePayOfficeMemoWordForm" property="contractInfo.orgExecutorName" filter="true" /></U></td>
		</tr>
		<tr>
			<td>�������</td>
			<td>� GSM <U><bean:write name="LeasePayOfficeMemoWordForm" property="contractInfo.positionGsm" filter="true" /></U> ������������ <U><bean:write name="LeasePayOfficeMemoWordForm" property="contractInfo.positionName" filter="true" /></U></td>
		</tr>
		<tr>
			<td>�������</td>
			<td><bean:write name="LeasePayOfficeMemoWordForm" property="contractInfo.mainResource" filter="true" /></td>
		</tr>
		<tr>
			<td>�����</td>
			<td>
				<logic:equal name="LeasePayOfficeMemoWordForm" property="to.flagAvans" value="true">��</logic:equal>
				<logic:equal name="LeasePayOfficeMemoWordForm" property="to.flagAvans" value="false">���</logic:equal>			
			</td>
		</tr>								
		<tr>
			<td>������ ����</td>
			<td>
				<logic:equal name="LeasePayOfficeMemoWordForm" property="to.flag3face" value="true">��</logic:equal>
				<logic:equal name="LeasePayOfficeMemoWordForm" property="to.flag3face" value="false">���</logic:equal>			
			</td>
		</tr>			
	</table>
	
	<p><b style='mso-bidi-font-weight:normal'><o:p>&nbsp;</o:p></b></p>
	
	<p><b style='mso-bidi-font-weight:normal'>����� ������</b><b
	style='mso-bidi-font-weight:normal'><span lang=EN-US style='mso-ansi-language:
	EN-US'>:<o:p></o:p></span></b></p>
	<table border="1" style="border-collapse:collapse;border:none;mso-border-alt:solid silver .5pt;mso-padding-alt:0cm 5.4pt 0cm 5.4pt">
		<tr>
			<td width="163">����� (� ���):</td>
			<td width="108"><july:numberwrite name="LeasePayOfficeMemoWordForm" property="to.vo.sum" /></td>
			<td width="96">����� ���:</td>
			<td width="120"><july:numberwrite name="LeasePayOfficeMemoWordForm" property="to.vo.nds" /></td>
			<td width="87">������:</td>
			<td width="69"><bean:write name="LeasePayOfficeMemoWordForm" property="to.curName" filter="true" /></td>
		</tr>
		<logic:notEqual name="LeasePayOfficeMemoWordForm" property="to.curName" value="���">
		<tr>
			<td width="163">������� ����������� �����:</td>
			<td colspan="5">
				<logic:equal name="<%= form %>" property="to.vo.ruleRate" value="<%=LeasePayOfficeMemo_VO.ruleRate_onDogovor%>">
					�� ������� ��������:
					<logic:present name="<%= form %>" property="to.vo.rateCalcRule">
						<logic:equal name="<%= form %>" property="to.vo.rateCalcRule" value="A">
							<bean:message key="label.filter.ratecalcrule.a"/>
						</logic:equal>
						<logic:equal name="<%= form %>" property="to.vo.rateCalcRule" value="B">
							<bean:message key="label.filter.ratecalcrule.b"/>						
						</logic:equal>
						<logic:equal name="<%= form %>" property="to.vo.rateCalcRule" value="C">
							<bean:message key="label.filter.ratecalcrule.c"/>						
						</logic:equal>
						<logic:equal name="<%= form %>" property="to.vo.rateCalcRule" value="D">
							<bean:message key="label.filter.ratecalcrule.d"/>						
						</logic:equal>
						<logic:equal name="<%= form %>" property="to.vo.rateCalcRule" value="E">
							<bean:message key="label.filter.ratecalcrule.e"/>						
						</logic:equal>
						<%	String rateCalcRuleDayStr = String.valueOf( aform.getTo().getVo().getRateCalcRuleDay() );	%>
						<logic:equal name="<%= form %>" property="to.vo.rateCalcRule" value="F">
							<bean:message key="label.filter.ratecalcrule.f" arg0="<%= rateCalcRuleDayStr %>"/>
						</logic:equal>
						<logic:equal name="<%= form %>" property="to.vo.rateCalcRule" value="G">
							<bean:message key="label.filter.ratecalcrule.g" arg0="<%= rateCalcRuleDayStr %>"/>						
						</logic:equal>
						<logic:equal name="<%= form %>" property="to.vo.rateCalcRule" value="H">
							<bean:message key="label.filter.ratecalcrule.h"/>
						</logic:equal>
						<logic:equal name="<%= form %>" property="to.vo.rateCalcRule" value="I">
							<bean:message key="label.filter.ratecalcrule.i"/>						
						</logic:equal>
					</logic:present>				
				</logic:equal>
				<logic:equal name="<%= form %>" property="to.vo.ruleRate" value="<%=LeasePayOfficeMemo_VO.ruleRate_onDate%>">
					�� ����:<july:datewrite name="<%= form %>" property="to.vo.rateDate"/>
				</logic:equal>
				<logic:equal name="<%= form %>" property="to.vo.ruleRate" value="<%=LeasePayOfficeMemo_VO.ruleRate_onHand%>">
					�������
				</logic:equal>
				(����: <july:numberwrite name="<%= form %>" property="to.vo.rateValue"/>)						
			</td>		
		</tr>
		<tr>
			<td width="163">����� � ��� � ������:</td>
			<td colspan="2" align="left" ><july:numberwrite name="LeasePayOfficeMemoWordForm" property="to.vo.sumRub"/></td>
			<td>��� � ���:</td>
			<td colspan="2"><july:numberwrite name="LeasePayOfficeMemoWordForm" property="to.vo.ndsRub"/></td>
		</tr>		
		</logic:notEqual>
	</table>
	
	<p><b style='mso-bidi-font-weight:normal'><o:p>&nbsp;</o:p></b></p>
	
	<p><b style='mso-bidi-font-weight:normal'>��������� ����������
	�������:<o:p></o:p></b></p>

	<table border="1" style="border-collapse:collapse;border:none;mso-border-alt:solid silver .5pt;mso-padding-alt:0cm 5.4pt 0cm 5.4pt">
		<tr>
			<td width="115">���������</td>
			<td width="372" colspan="2"><bean:write name="LeasePayOfficeMemoWordForm" property="vendor_VO.name" filter="true" /></td>
			<td width="156">����� <U><bean:write name="LeasePayOfficeMemoWordForm" property="vendor_VO.vendorCode" filter="true" /></U></td>
		</tr>
		<tr>
			<td>���������</td>
			<td colspan="2"><bean:write name="LeasePayOfficeMemoWordForm" property="vendorSite_VO.name" filter="true" /></td>
			<td>����� <U><bean:write name="LeasePayOfficeMemoWordForm" property="vendorSite_VO.vendorSiteCode" filter="true" /></U></td>
		</tr>
		<tr>
			<td>�����</td>
			<td colspan="2"><bean:write name="LeasePayOfficeMemoWordForm" property="vendorSite_VO.address" filter="true" /></td>
			<td>&nbsp;</td>
		</tr>				
		<tr>
			<td width="300" colspan="2">���: <U><bean:write name="LeasePayOfficeMemoWordForm" property="vendor_VO.inn" filter="true" /></U></td>
			<td colspan="2">���: <U><bean:write name="LeasePayOfficeMemoWordForm" property="vendorSite_VO.kpp" filter="true" /></U></td>		
		</tr>
		<tr>
			<td>����� ���������� �����</td>
			<td colspan="2"><bean:write name="LeasePayOfficeMemoWordForm" property="orgAcc.vo.account" filter="true" /></td>
			<td>&nbsp;</td>				
		</tr>				
	</table>	

	<p><b style='mso-bidi-font-weight:normal'><o:p>&nbsp;</o:p></b></p>
	
	<p><b style='mso-bidi-font-weight:normal'>��������� �����
	����������</b><b style='mso-bidi-font-weight:normal'><span lang=EN-US
	style='mso-ansi-language:EN-US'>:<o:p></o:p></span></b></p>

	<table border="1" style="border-collapse:collapse;border:none;mso-border-alt:solid silver .5pt;mso-padding-alt:0cm 5.4pt 0cm 5.4pt">
		<tr>
			<td width="115">������������</td>
			<td width="528" colspan="3"><bean:write name="LeasePayOfficeMemoWordForm" property="orgAcc.bank_VO.name" filter="true" /></td>
		</tr>
		<tr>
			<td>�����</td>
			<td colspan="3"><bean:write name="LeasePayOfficeMemoWordForm" property="orgAcc.bank_VO.legalAddress" filter="true" /></td>
		</tr>
		<tr>
			<td>���</td>
			<td width="168"><bean:write name="LeasePayOfficeMemoWordForm" property="orgAcc.bank_VO.bik" filter="true" /></td>
			<td width="108">����.����</td>
			<td><bean:write name="LeasePayOfficeMemoWordForm" property="orgAcc.bank_VO.korAccount" filter="true" /></td>
		</tr>				
	</table>
		
	<p><b style='mso-bidi-font-weight:normal'><o:p>&nbsp;</o:p></b></p>
	
	<p><b style='mso-bidi-font-weight:normal'>��������������
	���������</b><b style='mso-bidi-font-weight:normal'><span lang=EN-US
	style='mso-ansi-language:EN-US'>:<o:p></o:p></span></b></p>
	
	<table border="1" style="border-collapse:collapse;border:none;mso-border-alt:solid silver .5pt;mso-padding-alt:0cm 5.4pt 0cm 5.4pt">
		<tr>
			<td width="175">����������</td>
			<td width="468" colspan="3"><bean:write name="LeasePayOfficeMemoWordForm" property="to.vo.purpose" filter="true" /></td>
		</tr>
		<tr>
			<td>���� 104 (���)</td>
			<td width="132"><bean:write name="LeasePayOfficeMemoWordForm" property="to.vo.pp104" filter="true" /></td>
			<td width="175">���� 105 (�����)</td>
			<td><bean:write name="LeasePayOfficeMemoWordForm" property="to.vo.pp105" filter="true" /></td>
		</tr>
		<tr>
			<td>����������� �������</td>
			<td><bean:write name="LeasePayOfficeMemoWordForm" property="to.vo.ppQueue" filter="true" /></td>
			<td>������ �����������</td>
			<td><bean:write name="LeasePayOfficeMemoWordForm" property="to.vo.ppStatus" filter="true" /></td>
		</tr>						
	</table>
	
	<p><b style='mso-bidi-font-weight:normal'><o:p>&nbsp;</o:p></b></p>
	
	<p><b style='mso-bidi-font-weight:normal'>����������:<o:p></o:p></b></p>

	<table border="1" style="border-collapse:collapse;border:none;mso-border-alt:solid silver .5pt;mso-padding-alt:0cm 5.4pt 0cm 5.4pt">
		<tr>
			<td width="139">���</td>
			<td width="499" colspan="3"><bean:write name="LeasePayOfficeMemoWordForm" property="people_VO.lastname" filter="true" /></td>
		</tr>
		<tr>
			<td>���������</td>
			<td colspan="3">
				<logic:present name="LeasePayOfficeMemoWordForm" property="people_VO.firstWorker">
					<bean:write name="LeasePayOfficeMemoWordForm" property="people_VO.firstWorker.workPositionName" filter="true" />
				</logic:present>
			</td>
		</tr>
		<tr>
			<td>���. �������</td>
			<td width="168">
				<logic:present name="LeasePayOfficeMemoWordForm" property="people_VO.firstWorker">
					<bean:write name="LeasePayOfficeMemoWordForm" property="people_VO.firstWorker.vo.mobilePhone" filter="true" />
				</logic:present>
			</td>
			<td width="108">���. �������</td>
			<td>
				<logic:present name="LeasePayOfficeMemoWordForm" property="people_VO.firstWorker">
					<bean:write name="LeasePayOfficeMemoWordForm" property="people_VO.firstWorker.vo.localPhone" filter="true" />
				</logic:present>
			</td>
		</tr>
		<tr>
			<td width="139">�������:</td>
			<td width="499" colspan="3">&nbsp;</td>
		</tr>
		<tr>
			<td>���� � ����� ������ </td>
			<td colspan="3"><%= curDateStr%></td>
		</tr>						
	</table>	
</DIV>
</body>

</html>