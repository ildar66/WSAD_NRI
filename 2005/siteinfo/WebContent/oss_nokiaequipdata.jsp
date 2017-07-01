<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

 <XML id=btsdata SRC='<%= "/siteinfo/GetNokiaEquipmentData?btsinfo=1&gsmid=" + request.getParameter("gsmid") %>'></XML>
 <XML id=equipment SRC='<%= "/siteinfo/GetNokiaEquipmentData?gsmid=" + request.getParameter("gsmid") %>'></XML>
 <XML id=eqhead SRC='<%= "/siteinfo/GetNokiaEquipmentData?datainfo=1&gsmid=" + request.getParameter("gsmid") %>'></XML>

<table class="main">

	<july:separator/>

    <tr class="title">
        <td class="title">&nbsp;</td>
    </tr>
    
    <july:separator/>

    <tr>
        <td class="text">
        
        
      <H2>Данные от оборудования на позиции</H2>
      <H3>GSM ID: <%= request.getParameter("gsmid") %> <SPAN dataSrc=#eqhead dataFld=posname></SPAN><BR>
      Данные получены: <SPAN dataSrc=#eqhead dataFld=dataloaddate></SPAN><BR>
      Сеть: <SPAN dataSrc=#eqhead dataFld=name></SPAN><BR>
      <TABLE id=EquipmentDt class="print" style="WIDTH: 95%; BORDER-COLLAPSE: collapse"
      dataSrc=#btsdata border=1>
        <THEAD>
        <TR class="print">
          <TD class="print"><B>Cell ID</B></TD>
          <TD class="print"><B>Name</B></TD>
          <TD class="print"><B>Address</B></TD>
          <TD class="print"><B>LAC</B></TD>
          <TD class="print"><B>NCC</B></TD>
          <TD class="print"><B>BCC</B></TD>
	      </TR>
	     </THEAD>
        <TBODY>
        <TR class="print">
          <TD class="print"><DIV dataFld=cellid type="text"></DIV></TD>
          <TD class="print"><DIV dataFld=name type="text"></DIV></TD>
          <TD class="print"><DIV dataFld=address type="text"></DIV></TD>
          <TD class="print"><DIV dataFld=lac></DIV></TD>
          <TD class="print"><DIV dataFld=ncc></DIV></TD>
          <TD class="print"><DIV dataFld=bcc></DIV></TD>
	      </TR>
        </TBODY>
     	</TABLE>


      <BR>
    
      <TABLE id=EquipmentDt2 class="print" style="WIDTH: 95%; BORDER-COLLAPSE: collapse"
      dataSrc=#equipment border=1>
        <THEAD>
        <TR class="print">
          <TD class="print"><B>Unit Name</B></TD>
          <TD class="print"><B>Unit Nro</B></TD>
          <TD class="print"><B>Serial</B></TD>
          <TD class="print"><B>Rack</B></TD>
          <TD class="print"><B>Shelf</B></TD>
          <TD class="print"><B>Slot</B></TD>
	      </TR>
	     </THEAD>
        <TBODY>
        <TR class="print">
          <TD class="print"><DIV dataFld=unit_name type="text"></DIV></TD>
          <TD class="print"><DIV dataFld=unit_nro type="text"></DIV></TD>
          <TD class="print"><DIV dataFld=serial type="text"></DIV></TD>
          <TD class="print"><DIV dataFld=rack></DIV></TD>
          <TD class="print"><DIV dataFld=shelf></DIV></TD>
          <TD class="print"><DIV dataFld=slot></DIV></TD>
	      </TR>
        </TBODY>
     	</TABLE>

        </td>
    </tr>

    <july:separator/>
    
    <tr class="title">
        <td class="title">&nbsp;</td>
    </tr>

    <july:separator/>
    
</table>



