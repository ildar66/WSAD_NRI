<!-- ��� WORD ��� ������� ��������� -->
<%@ page language = "java" %>
<%@ page contentType = "application/msword; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import="com.hps.july.arenda.formbean.*, com.hps.july.arenda.valueobject.*"%>
<%@ page import="com.hps.july.arenda.cdbcobjects.*"%>
<%@ page import="java.math.*"%>

<%
	response.setHeader("Cache-Control", "no-cache");
	response.setContentType("application/msword;name=buchDocsWord.doc;charset=Windows-1251");
	response.setHeader("Content-Disposition", "attachment;filename=buchDocsWord.rtf");
	//LoanAktGetPutWordForm aform =  (LoanAktGetPutWordForm)request.getAttribute("LoanAktGetPutWordForm");
	java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
	java.util.Date curDate = new java.util.Date(System.currentTimeMillis());
	String curDateStr = format.format(curDate);
%>
<html xmlns:o="urn:schemas-microsoft-com:office:office"
xmlns:w="urn:schemas-microsoft-com:office:word"
xmlns="http://www.w3.org/TR/REC-html40">
<head>
  <meta http-equiv="Content-Type" content="application/msword;name=buchDocsWord.doc;charset=Windows-1251">
  <meta http-equiv="Content-Disposition" content="attachment;filename=buchDocsWord.rtf">
  <meta name=ProgId content=Word.Document>
  <title>WORD ��� ����� ����������.</title>
<STYLE>  
@page Section1
	{size:841.9pt 595.3pt;
	mso-page-orientation:landscape;
	margin:70.9pt 1.0cm 70.9pt 1.0cm;
	mso-header-margin:35.45pt;
	mso-footer-margin:35.45pt;
	mso-paper-source:0;}
div.Section1
	{page:Section1;} 
p
	{mso-style-parent:"";
	margin:0cm;
	margin-top: 0cm;
	margin-bottom:.0001pt;
	mso-pagination:widow-orphan;
	}

TABLE {
	FONT-FAMILY: Arial,Verdana; FONT-SIZE: 9pt;  line-height: 100%;
}

TD.tsilver {
	border:solid silver .5pt;
	border-right:none;
	background: #EAEAEA;
	padding:0cm 5.4pt 0cm 5.4pt;
}

p.BodyText2, li.BodyText2, div.BodyText2
	{mso-style-name:"Body Text 2";
	margin:0cm;
	margin-bottom:.0001pt;
	text-align:justify;
	text-indent:35.45pt;
	mso-pagination:widow-orphan;
	mso-layout-grid-align:none;
	punctuation-wrap:simple;
	text-autospace:none;
	font-size:14.0pt;
	mso-bidi-font-size:10.0pt;
	font-family:Arial;
	mso-fareast-font-family:"Times New Roman";
	mso-bidi-font-family:"Times New Roman";
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
<body>
<html:errors/>

<DIV class=Section1 STYLE="FONT-FAMILY: Arial,Verdana; FONT-SIZE: 10pt; line-height:100%">
	<table border="0" width="100%" style="FONT-FAMILY: Arial,Verdana; font-size: 10pt;">
		<tr>
			<td width="40%">&nbsp;</td>
			<td align= "right">���� � ����� ������: <%= curDateStr %></td>
		</tr>
	</table>
	<P>&nbsp;</P><P>&nbsp;</P>
	<P align="center">
<% String title = "����������� ��� �����";%>
<logic:equal name="RegistryBuchDocsWordForm" property="to.vo.typeRegistry" value="<%= String.valueOf(CDBC_LeaseRegistryBuchDocs_Object.typeRegistry_SF)%>">
	<logic:equal name="RegistryBuchDocsWordForm" property="to.vo.typeTransferRegistry" value="<%= LeaseRegistryBuchDocs_VO.TYPE_TRANSFER_REGISTRY_REAL%>">	
	 	<% title = "������ ������-������� ��� �������� � �����������";%>
	</logic:equal>
	<logic:equal name="RegistryBuchDocsWordForm" property="to.vo.typeTransferRegistry" value="<%= LeaseRegistryBuchDocs_VO.TYPE_TRANSFER_REGISTRY_RETURN%>">	
		<% title = "������ ������������ ������-�������";%>
	</logic:equal>	
</logic:equal>

<logic:equal name="RegistryBuchDocsWordForm" property="to.vo.typeRegistry" value="<%= String.valueOf(CDBC_LeaseRegistryBuchDocs_Object.typeRegistry_CWA)%>">
	<logic:equal name="RegistryBuchDocsWordForm" property="to.vo.typeTransferRegistry" value="<%= LeaseRegistryBuchDocs_VO.TYPE_TRANSFER_REGISTRY_REAL%>">	
		<% title = "������ ����� ����������� ����� ��� �������� � �����������";%>
	</logic:equal>
	<logic:equal name="RegistryBuchDocsWordForm" property="to.vo.typeTransferRegistry" value="<%= LeaseRegistryBuchDocs_VO.TYPE_TRANSFER_REGISTRY_RETURN%>">	
		<% title = "������ ������������ ����� ����������� �����";%>
	</logic:equal>	
</logic:equal>

<logic:equal name="RegistryBuchDocsWordForm" property="to.vo.typeRegistry" value="<%= String.valueOf(CDBC_LeaseRegistryBuchDocs_Object.typeRegistry_LeaseDoc)%>">	
	<logic:equal name="RegistryBuchDocsWordForm" property="to.vo.typeTransferRegistry" value="<%= LeaseRegistryBuchDocs_VO.TYPE_TRANSFER_REGISTRY_REAL%>">	
		<% title = "������ ��������� ��� �������� � �����������";%>
	</logic:equal>
	<logic:equal name="RegistryBuchDocsWordForm" property="to.vo.typeTransferRegistry" value="<%= LeaseRegistryBuchDocs_VO.TYPE_TRANSFER_REGISTRY_RETURN%>">	
		<% title = "������ ������������ ���������";%>
	</logic:equal>
</logic:equal>

<logic:equal name="RegistryBuchDocsWordForm" property="to.vo.typeRegistry" value="<%= String.valueOf(CDBC_LeaseRegistryBuchDocs_Object.typeRegistry_SF_CWA)%>">	
	<logic:equal name="RegistryBuchDocsWordForm" property="to.vo.typeTransferRegistry" value="<%= LeaseRegistryBuchDocs_VO.TYPE_TRANSFER_REGISTRY_REAL%>">	
		<% title = "������ ���������� ��� �������� � �����������";%>
	</logic:equal>
	<logic:equal name="RegistryBuchDocsWordForm" property="to.vo.typeTransferRegistry" value="<%= LeaseRegistryBuchDocs_VO.TYPE_TRANSFER_REGISTRY_RETURN%>">	
		<% title = "������ ������������ ����������";%>
	</logic:equal>
</logic:equal>

<logic:equal name="RegistryBuchDocsWordForm" property="to.vo.typeRegistry" value="<%= String.valueOf(CDBC_LeaseRegistryBuchDocs_Object.typeRegistry_MUTUAL_ACT)%>">	
	<logic:equal name="RegistryBuchDocsWordForm" property="to.vo.typeTransferRegistry" value="<%= LeaseRegistryBuchDocs_VO.TYPE_TRANSFER_REGISTRY_REAL%>">	
		<% title = "������ ����� ������������, ������-������� � ����� �� ��� �������� � ����������� ";%>
	</logic:equal>
	<logic:equal name="RegistryBuchDocsWordForm" property="to.vo.typeTransferRegistry" value="<%= LeaseRegistryBuchDocs_VO.TYPE_TRANSFER_REGISTRY_RETURN%>">	
		<% title = "������ ������������ ����� ������������, ������-������� � ����� ��";%>
	</logic:equal>
</logic:equal>

		<B STYLE="FONT-FAMILY: Arial,Verdana; FONT-SIZE: 12pt;"><%= title%>	� <bean:write name="RegistryBuchDocsWordForm" property="to.vo.idRegistryDoc" filter="true"/></B>
	</P>
	<logic:present name="RegistryBuchDocsWordForm" property="parent_to">
		<P align="center">(������ ����� �<bean:write name="RegistryBuchDocsWordForm" property="parent_to.vo.idRegistryDoc" filter="true"/>, ���������:<bean:write name="RegistryBuchDocsWordForm" property="parent_to.ownerName" filter="true"/>)	
	</logic:present>
	<P>&nbsp;</P><P>&nbsp;</P>
	<P align="center">���������: <bean:write name="RegistryBuchDocsWordForm" property="to.ownerName" filter="true"/>
<P>&nbsp;</P>

<logic:equal name="RegistryBuchDocsWordForm" property="to.vo.typeRegistry" value="<%= String.valueOf(CDBC_LeaseRegistryBuchDocs_Object.typeRegistry_SF)%>">
<!-- ������ ������ ������ -->
<table border=1 style='border-collapse:collapse;border:none;mso-border-alt:solid silver .5pt;mso-padding-alt:0cm 5.4pt 0cm 5.4pt'>
	<!-- Table header ������ ������-->
	<tr bgcolor="#EAEAEA">
		<th>�</th>
		<th>GSM\DAMPS</th>
		<th>������������<br>�������</th>
		<th>����� � ����<br>��������</th>
		<th>������������</th>
		<th>����� ��</th>
		<th>���� ��</th>
		<th>����� ��</th>
		<th>�������</th>
		<th>������</th>
	</tr>
	<!-- Table body ������ ������ --> 
	<logic:iterate id="it" name="listAccessDocs" indexId="indexId"> 
	<logic:present name="it">
	<tr>
		<td><%= indexId.intValue() + 1%></td>
		<td><bean:write name="it" property="numberPosition" filter="true"/></td>
		<td><bean:write name="it" property="namePosition" filter="true"/></td>	
		<td><bean:write name="it" property="docNumber" filter="true"/> �� <july:datewrite name="it" property="docDate"/></td>
		<td><bean:write name="it" property="nameOrgPrint" filter="true"/></td>
		<td><bean:write name="it" property="numberSf" filter="true"/></td>
		<td><july:datewrite name="it" property="dateSf"/></td>
		<td><july:sumwrite name="it" property="sumSf"/></td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	</logic:present>
	</logic:iterate>
</table>
</logic:equal>

<logic:equal name="RegistryBuchDocsWordForm" property="to.vo.typeRegistry" value="<%= String.valueOf(CDBC_LeaseRegistryBuchDocs_Object.typeRegistry_CWA)%>">
<!--������ ����� ����������� �����-->
<table border=1 style='border-collapse:collapse;border:none;mso-border-alt:solid silver .5pt;mso-padding-alt:0cm 5.4pt 0cm 5.4pt'>
	<!-- Table header ������ ����� ����������� �����-->
	<tr bgcolor="#EAEAEA">
		<th>�</th>
		<th>�����<br>��������</th>
		<th>����<br>��������</th>
		<th>�����������</th>
		<th>� �������</th>
		<th>����.<br>�������</th>
		<th>�����<br>����</th>
		<th>����<br>����</th>
		<th>�����<br>����</th>
		<%--th>���<br>����</th--%>
		<th>������<br>����</th>
		<th>����<br>������</th>
		<th>����<br>���������</th>
		<th>�������</th>
		<th>������</th>
	</tr>
	<!-- Table body ������ ����� ����������� ����� --> 
	<logic:iterate id="it" name="listAccessDocs" indexId="indexId"> 
	<logic:present name="it">
	<tr>
		<td><%= indexId.intValue() + 1%></td>
        <td class="number">
            <bean:write name="it" property="docNumber" filter="true"/></td>
        <td class="text">
        	<july:datewrite name="it" property="docDate"/></td>
        <td class="number">
            <bean:write name="it" property="nameOrgPrint" filter="true"/></td>
        <td class="number">
            <bean:write name="it" property="numberPosition" filter="true"/></td>
        <td class="number">
            <bean:write name="it" property="namePosition" filter="true"/></td>                                                                     
        <td class="number">
            <bean:write name="it" property="docNumberCWA" filter="true"/></td>
        <td class="text">
            <july:datewrite name="it" property="docDateCWA"/></td>
        <td class="number" align="right">
            <july:sumwrite name="it" property="actSum"/></td>
        <%--td class="number" align="right">
            <july:sumwrite name="it" property="actNds"/></td--%>
        <td class="number">
            <bean:write name="it" property="nameCurrency" filter="true"/></td>
        <td class="text">
            <july:datewrite name="it" property="actStartDate"/></td>
        <td class="text">
            <july:datewrite name="it" property="actEndDate"/></td>
		<td class="text">&nbsp;</td>
		<td class="text">&nbsp;</td>                                                                
	</tr>
	</logic:present>
	</logic:iterate>
</table>
</logic:equal>

<logic:equal name="RegistryBuchDocsWordForm" property="to.vo.typeRegistry" value="<%= String.valueOf(CDBC_LeaseRegistryBuchDocs_Object.typeRegistry_LeaseDoc)%>">
<!-- ������ ��������� -->
<table border=1 style='border-collapse:collapse;border:none;mso-border-alt:solid silver .5pt;mso-padding-alt:0cm 5.4pt 0cm 5.4pt'>
	<!-- Table header ������ ���������-->
	<tr bgcolor="#EAEAEA">
		<th>�</th>
		<th>� �������</th>
		<th>����. �������</th>	
		<th>�����<br>��������</th>
		<th>����<br>��������</th>
		<th>�����������</th>
		<th>����� �.�.</th>
		<th>���� �.�.</th>
		<th>�����</th>
		<th>������</th>
		<th>��� ��������</th>
	</tr>
	<!-- Table body ������ ��������� --> 
	<logic:iterate id="it" name="listAccessDocs" indexId="indexId"> 
	<logic:present name="it">
	<tr>
		<td><%= indexId.intValue() + 1%></td>
        <td class="number">
            <bean:write name="it" property="numberPosition" filter="true"/></td>                                                                     
        <td class="number">
            <bean:write name="it" property="namePosition" filter="true"/></td>                                                                     
        <td class="number">
            <bean:write name="it" property="docNumber" filter="true"/></td>
        <td class="text">
        	<july:datewrite name="it" property="docDate"/></td>
        <td class="number">
            <bean:write name="it" property="nameOrgPrint" filter="true"/></td>
        <td class="number">
            <bean:write name="it" property="docNumberDop" filter="true"/></td>
        <td class="text">
            <july:datewrite name="it" property="docDateDop"/></td>
        <td class="number" align="right">
            <july:sumwrite name="it" property="sum"/></td>
        <td class="number">
            <bean:write name="it" property="nameCurrency" filter="true"/></td>
        <td class="number">
            <bean:write name="it" property="typeDoc" filter="true"/></td>
	</tr>
	</logic:present>
	</logic:iterate>
</table>
</logic:equal>

<logic:equal name="RegistryBuchDocsWordForm" property="to.vo.typeRegistry" value="<%= String.valueOf(CDBC_LeaseRegistryBuchDocs_Object.typeRegistry_SF_CWA)%>">
<!-- ������ ���������� SF_CWA-->
<table border=1 style='border-collapse:collapse;border:none;mso-border-alt:solid silver .5pt;mso-padding-alt:0cm 5.4pt 0cm 5.4pt'>
	<!-- Table header  ������ ���������� SF_CWA-->
	<tr bgcolor="#EAEAEA">
		<th>�</th>	
		<th>GSM\DAMPS</th>
		<th>������������<br>�������</th>
		<th>����� � ����<br>��������</th>
		<th>������������</th>
		<th>�����<br>����</th>
		<th>����� ��</th>
		<th>����</th>
		<th>�����</th>
		<th>�������</th>
		<th>������</th>
	</tr>
	<!-- Table body  ������ ���������� SF_CWA simple-->	
	<logic:equal name="RegistryBuchDocsWordForm" property="wordView" value="<%= String.valueOf(RegistryBuchDocsWordForm.wordView_SIMPLE)%>">	
	<logic:iterate id="it" name="listAccessDocs" indexId="indexId"> 
	<logic:present name="it">
	<%  
		com.hps.july.arenda.valueobject.RegistryBuchCompositionObject_TO to = (com.hps.july.arenda.valueobject.RegistryBuchCompositionObject_TO)it;
		String idStr = String.valueOf(to.getIdComposition());
		int typeComposition = to.getTypeComposition().intValue();
	%>	
	<tr>
		<td><%= indexId.intValue() + 1%></td>
        <td class="number">
            <bean:write name="it" property="numberPosition" filter="true"/></td>
        <td class="number">
            <bean:write name="it" property="namePosition" filter="true"/></td>             	
        <td class="number">
            <bean:write name="it" property="docNumber" filter="true"/> �� <july:datewrite name="it" property="docDate"/></td>
        <td class="number">
            <bean:write name="it" property="nameOrgPrint" filter="true"/></td>
                                                                    
        <%if(typeComposition == com.hps.july.arenda.valueobject.RegistryBuchCompositionObject_TO.TYPE_COMPOSITION_CWA){%>                                                                     
        <td class="number"><bean:write name="it" property="numberComposition" filter="true"/></td>
        <td class="number">&nbsp;</td>
        <%}else if(typeComposition == com.hps.july.arenda.valueobject.RegistryBuchCompositionObject_TO.TYPE_COMPOSITION_SF){%>
        <td class="number">&nbsp;</td>
        <td class="number"><bean:write name="it" property="numberComposition" filter="true"/></td>
        <%}%>                                                                    
        <td class="text">
            <july:datewrite name="it" property="dateComposition"/></td>
        <td class="number" align="right">
            <july:sumwrite name="it" property="sumComposition"/></td>
		<td class="text">&nbsp;</td>
		<td class="text">&nbsp;</td>             
	</tr>
	</logic:present>
	</logic:iterate>
	<!-- -->
	</logic:equal>
	<!-- Table body  ������ ���������� SF_CWA complect-->
	<logic:equal name="RegistryBuchDocsWordForm" property="wordView" value="<%= String.valueOf(RegistryBuchDocsWordForm.wordView_COMPLECT)%>">		
	<logic:iterate id="it" name="listAccessDocs" indexId="indexId"> 
	<logic:present name="it">
	<%  
		com.hps.july.arenda.valueobject.RegistryBuchCompositionComplect_TO to = (com.hps.july.arenda.valueobject.RegistryBuchCompositionComplect_TO)it;
	%>	
	<tr>
		<td><%= indexId.intValue() + 1%></td>
        <td class="number">
        	<logic:present name="it" property="act">
            	<bean:write name="it" property="act.numberPosition" filter="true"/>
            </logic:present>
            <logic:notPresent name="it" property="act">
            	<bean:write name="it" property="factura.numberPosition" filter="true"/>
            </logic:notPresent>
        </td>
        <td class="number">
        	<logic:present name="it" property="act">
            	<bean:write name="it" property="act.namePosition" filter="true"/>
			</logic:present>
            <logic:notPresent name="it" property="act">
            	<bean:write name="it" property="factura.namePosition" filter="true"/>
            </logic:notPresent>            	
        </td>             	
        <td class="number">
        	<logic:present name="it" property="act">
            	<bean:write name="it" property="act.docNumber" filter="true"/> �� <july:datewrite name="it" property="act.docDate"/>       	
			</logic:present>
            <logic:notPresent name="it" property="act">
                <bean:write name="it" property="factura.docNumber" filter="true"/> �� <july:datewrite name="it" property="factura.docDate"/>
            </logic:notPresent>
        </td>        
        <td class="number">
        	<logic:present name="it" property="act">
            	<bean:write name="it" property="act.nameOrgPrint" filter="true"/>
			</logic:present>
            <logic:notPresent name="it" property="act">
            	<bean:write name="it" property="factura.nameOrgPrint" filter="true"/>
            </logic:notPresent>            
        </td>
                                                                    
        <td class="number">
        	<logic:present name="it" property="act">
        		<bean:write name="it" property="act.numberComposition" filter="true"/>
        	</logic:present>
        </td>
        <td class="number">
        	<logic:present name="it" property="factura">
        		<bean:write name="it" property="factura.numberComposition" filter="true"/>
        	</logic:present>
        </td>
                                                                    
        <td class="text">
        	<logic:present name="it" property="act">
            	<july:datewrite name="it" property="act.dateComposition"/>
			</logic:present>
            <logic:notPresent name="it" property="act">
            	<july:datewrite name="it" property="factura.dateComposition"/>
            </logic:notPresent>
        </td>
        <td class="number" align="right">
			<logic:present name="it" property="act">        
            	<july:sumwrite name="it" property="act.sumComposition"/>
			</logic:present>
            <logic:notPresent name="it" property="act">
	            <july:sumwrite name="it" property="factura.sumComposition"/>
           	</logic:notPresent> 
        </td>
		<td class="text">&nbsp;</td>
		<td class="text">&nbsp;</td>             
	</tr>
	</logic:present>
	</logic:iterate>
	<!-- -->
</logic:equal>		
</table>
</logic:equal>

<logic:equal name="RegistryBuchDocsWordForm" property="to.vo.typeRegistry" value="<%= String.valueOf(CDBC_LeaseRegistryBuchDocs_Object.typeRegistry_MUTUAL_ACT)%>">
<!--������ ����� ������������, ������-������� � ����� �� -->
<table border=1 style='border-collapse:collapse;border:none;mso-border-alt:solid silver .5pt;mso-padding-alt:0cm 5.4pt 0cm 5.4pt'>
	<!-- Table header ������ ����� ������������, ������-������� � ����� ��-->
	<tr bgcolor="#EAEAEA">
		<th>�</th>
		<th>GSM<br>\DAMPS</th>
		<th>������������<br>�������</th>
		<th>����� � ����<br>��������<br></th>
		<th>������������</th>
		<th>� ���� �/�</th>
		<th>� ���� ��</th>
		<th>� ��</th>
		<th>����<br>���������</th>
		<th>�����</th>
		<th>�������</th>
		<th>������</th>
	</tr>
	<!-- Table body ������ ����� ������������, ������-������� � ����� �� --> 
	<logic:iterate id="it" name="listAccessDocs" indexId="indexId"> 
	<logic:present name="it">
	<tr>
		<td><%= indexId.intValue() + 1%></td>
        <td class="number">
            <bean:write name="it" property="numberPosition" filter="true"/></td>
        <td class="number">
            <bean:write name="it" property="namePosition" filter="true"/></td>                    
        <td class="number">
            <%--bean:write name="it" property="docNumber" filter="true"/--%>
            <%--july:datewrite name="it" property="docDate"/--%></td>
        <td class="number">
            <bean:write name="it" property="nameOrg" filter="true"/></td>
        <td class="number">
            <bean:write name="it" property="docNumber" filter="true"/></td>            
		<td class="text">&nbsp;</td>
		<td class="text">&nbsp;</td>                                                                     
        <td class="text">
            <july:datewrite name="it" property="docDate"/></td>
        <td class="number" align="right">
            <%--july:sumwrite name="it" property="actSum"/--%></td>
		<td class="text">&nbsp;</td>
		<td class="text">&nbsp;</td>                                                                
	</tr>
     <logic:present name="it" property="buchList">
			<logic:iterate id="comp" name="it" property="buchList" type="RegistryBuchComposition_TO">
			    <logic:present name="comp">
					<%  
						com.hps.july.arenda.valueobject.RegistryBuchCompositionObject_TO to = (com.hps.july.arenda.valueobject.RegistryBuchCompositionObject_TO)comp;
						String idStr = String.valueOf(to.getIdComposition());
						int typeComposition = to.getTypeComposition().intValue();
					%>			                 
					<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
		                <td class="number" nowrap>
		                    &nbsp;&nbsp;&nbsp;<bean:write name="comp" property="typeCompositionStr" filter="true"/></td>
		                <td class="number">
		                    <bean:write name="comp" property="numberPosition" filter="true"/></td> 		                    
		                <td class="number">
		                    <bean:write name="comp" property="namePosition" filter="true"/></td>
		                <td class="number">
		                    <bean:write name="comp" property="docNumber" filter="true"/> �� <july:datewrite name="comp" property="docDate"/>
		                </td>
		                <td class="number">
		                    <bean:write name="comp" property="nameOrg" filter="true"/></td>
				        <%if(typeComposition == com.hps.july.arenda.valueobject.RegistryBuchCompositionObject_TO.TYPE_COMPOSITION_CWA){%>                                                                     
					        <td class="number">&nbsp;</td>
					        <td class="number"><bean:write name="comp" property="numberComposition" filter="true"/></td>
					        <td class="number">&nbsp;</td>
				        <%}else if(typeComposition == com.hps.july.arenda.valueobject.RegistryBuchCompositionObject_TO.TYPE_COMPOSITION_SF){%>
					        <td class="number">&nbsp;</td>
					        <td class="number">&nbsp;</td>
					        <td class="number"><bean:write name="comp" property="numberComposition" filter="true"/></td>
				        <%}%>
		                <td class="text">
		                    <july:datewrite name="comp" property="dateComposition"/></td>				        		                    
		                <td class="number" align="right">
		                    <july:sumwrite name="comp" property="sumComposition"/></td>
						<td class="text">&nbsp;</td>
						<td class="text">&nbsp;</td>		                    
					</tr>
			    </logic:present>
		    </logic:iterate>						
		 </logic:present>	
	</logic:present>
	</logic:iterate>
</table>
</logic:equal>


<P>&nbsp;</P><P>&nbsp;</P>

<logic:equal name="RegistryBuchDocsWordForm" property="to.vo.typeRegistry" value="<%= String.valueOf(CDBC_LeaseRegistryBuchDocs_Object.typeRegistry_LeaseDoc)%>">
<!-- ������ ��������� -->
<table border="0" width="40%" style="font-size: 10pt;">
<tr>
	<td width="50%">����_________________</td>
</tr>
<tr><th>&nbsp;</th></tr>	
<tr>
	<td width="50%">������_______________</td>
</tr>
<%--tr>
	<th width="50%">"���������"</th>
	<th>
		<bean:write name="RegistryBuchDocsWordForm" property="loanContractVO.orgCustomer.name" filter="true"/>
	</td>
</tr>
<tr>
	<th width="50%"><B>_________________</B></th>
	<th><B>_________________</B></th>
</tr--%>
</table>
</logic:equal>
<%--
<P>&nbsp;</P><P>&nbsp;</P><P>&nbsp;</P><P>&nbsp;</P>
<P style="font-size: 8pt;"><july:datewrite name="RegistryBuchDocsWordForm" property="to.vo.dateAct"/></P>

--%>
</DIV>
</body>
</html>