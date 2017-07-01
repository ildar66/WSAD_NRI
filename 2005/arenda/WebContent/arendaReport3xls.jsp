<%@ page language = "java" %>
<%@ page contentType = "application/vnd.ms-excel; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%-- 
<jsp:useBean id="ArendaReport3ParamsForm" class="com.hps.july.arenda.formbean.ArendaReport3ParamsForm" scope="request"/>

<html xmlns:o="urn:schemas-microsoft-com:office:office" xmlns:x="urn:schemas-microsoft-com:office:excel" xmlns="http://www.w3.org/TR/REC-html40">

<head>
<meta http-equiv=Content-Type content="text/html; charset=windows-1251">
<meta name=ProgId content=Excel.Sheet>
<meta name=Generator content="Microsoft Excel 10">
<!--[if gte mso 9]><xml>
 <x:ExcelWorkbook>
  <x:ExcelWorksheets>
   <x:ExcelWorksheet>
    <x:Name>��������</x:Name>
    <x:WorksheetOptions>
     <x:Selected/>
     <x:DisplayGridlines/>
     <x:TopRowVisible>0</x:TopRowVisible>
     <x:LeftColumnVisible>0</x:LeftColumnVisible>
     <x:Panes>
      <x:Pane>
       <x:Number>1</x:Number>
       <x:ActiveRow>1</x:ActiveRow>
       <x:ActiveCol>1</x:ActiveCol>
      </x:Pane>
     </x:Panes>
     <x:ProtectContents>False</x:ProtectContents>
     <x:ProtectObjects>False</x:ProtectObjects>
     <x:ProtectScenarios>False</x:ProtectScenarios>
    </x:WorksheetOptions>
   </x:ExcelWorksheet>
  </x:ExcelWorksheets>
  <x:ProtectStructure>False</x:ProtectStructure>
  <x:ProtectWindows>False</x:ProtectWindows>
 </x:ExcelWorkbook>
</xml><![endif]-->
</head>

<body>
  <TABLE>
    <TR>
      <TD colspan="22"><B>����� �� ��������� �� ������ � <%= ArendaReport3ParamsForm.getStartdateFrm() %> �� <%= ArendaReport3ParamsForm.getFinishdateFrm() %></B></TD>
    </TR>
    <TR>
<%-- col1 --%>      <TD><B>���</B></TD>
<%-- col2 --%>      <TD><B>����</B></TD>
<%-- col3 --%>      <TD><B>�����</B></TD>
<%-- col4 --%>      <TD><B>������</B></TD>
<%-- col5 --%>      <TD><B>���������</B></TD>
<%-- col6 --%>      <TD><B>���� �������� ��������</B></TD>
<%-- col7 --%>      <TD><B>�������</B></TD>
<%-- col8 --%>      <TD><B>������</B></TD>
<%-- col9 --%>      <TD><B>������������</B></TD>
<%-- col10 --%>      <TD><B>Beeline</B></TD>
<%-- col11 --%>      <TD><B>����� ��������</B></TD>
<%-- col12 --%>      <TD><B>� �.�. ������</B></TD>
<%-- col13 --%>      <TD><B>������ ��������</B></TD>
<%-- col14 --%>      <TD><B>���������</B></TD>
<%-- col15 --%>      <TD><B>���������</B></TD>
<%-- col16 --%>      <TD><B>���������</B></TD>
<%-- col17 --%>      <TD><B>����� ����� �� ������� ��������</B></TD>
<%-- col18 --%>      <TD><B>����� ������ �� ������� ��������</B></TD>
<%-- col19 --%>      <TD><B>����� ������� �� ������� ��������</B></TD>
<%-- col20 --%>      <TD><B>����� ����������� ��������</B></TD>
<%-- col21 --%>      <TD><B>����� 1</B></TD>
<%-- col22 --%>      <TD><B>����� 2</B></TD>
    </TR>
    <logic:iterate id="record" name="results" scope="request">
        <logic:present name="record">
            <TR>
                <td><july:stringwrite name="record" property="col1"/></td>
                <td><july:datewrite name="record" property="col2"/></td>
                <td><july:stringwrite name="record" property="col3"/></td>
                <td><july:datewrite name="record" property="col4"/></td>
                <td><july:datewrite name="record" property="col5"/></td>
                <td><july:datewrite name="record" property="col6"/></td>
                <td><july:stringwrite name="record" property="col7"/></td>
                <td><july:stringwrite name="record" property="col8"/></td>
                <td><july:stringwrite name="record" property="col9"/></td>
                <td><july:stringwrite name="record" property="col10"/></td>
                <td x:num="<july:stringwrite name='record' property='col11'/>"><july:numberwrite name="record" property="col11" fractdigits="2"/></td>
                <td x:num="<july:stringwrite name='record' property='col12'/>"><july:sumwrite name="record" property="col12"/></td>
                <td><july:stringwrite name="record" property="col13"/></td>
                <td><july:stringwrite name="record" property="col14"/></td>
                <td><july:stringwrite name="record" property="col15"/></td>
                <td><july:stringwrite name="record" property="col16"/></td>
                <td x:num="<july:stringwrite name='record' property='col17'/>"><july:sumwrite name="record" property="col17"/></td>
                <td x:num="<july:stringwrite name='record' property='col18'/>"><july:sumwrite name="record" property="col18"/></td>
                <td x:num="<july:stringwrite name='record' property='col19'/>"><july:sumwrite name="record" property="col19"/></td>
                <td x:num="<july:stringwrite name='record' property='col20'/>"><july:sumwrite name="record" property="col20"/></td>
                <td x:num="<july:stringwrite name='record' property='col21'/>"><july:sumwrite name="record" property="col21"/></td>
                <td x:num="<july:stringwrite name='record' property='col22'/>"><july:sumwrite name="record" property="col22"/></td>
            </TR>
         </logic:present>
     </logic:iterate>

  </TABLE>
</body>

</html>

 --%>