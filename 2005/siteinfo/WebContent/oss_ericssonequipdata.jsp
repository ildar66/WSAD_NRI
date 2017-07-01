<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

 <XML id=equipment SRC='<%= "/siteinfo/GetEricssonEquipmentData?gsmid=" + request.getParameter("gsmid") %>'></XML>
 <XML id=eqhead SRC='<%= "/siteinfo/GetEricssonEquipmentData?datainfo=1&gsmid=" + request.getParameter("gsmid") %>'></XML>

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
      dataSrc=#equipment border=1>
        <THEAD>
        <TR class="print">
          <TD class="print" COLSPAN=2><B>Site Name</B></TD>
	      </TR>
	     </THEAD>
        <TBODY>
        <TR class="print">
          <TD class="print" COLSPAN=2><DIV dataFld=sitename type="text"></DIV></TD>
	     </TR>
        <TR class="print">
          <TD>&nbsp;</TD>
          <TD  class="print">
            <TABLE dataFld=equipmentdata1 id=EquipDataDet class="print"
            style="BORDER-COLLAPSE: collapse" dataSrc=#equipment width="100%"
            border=1>
              <THEAD>
              <TR class="print">
                <TD>&nbsp;</TD>
                <TD class="print"><B>Product ID</B></TD>
                <TD class="print"><B>RU Serial No</B></TD>
                <TD class="print"><B>RU Revision</B></TD>
                <TD class="print"><B>RU Position</B></TD>
	            </TR>
	            </THEAD>
              <TBODY>
              <TR class="print">
                <TD class="print" style="CURSOR: hand; BACKGROUND-REPEAT: no-repeat;
		                background-position:center center;
		                BACKGROUND-IMAGE: url('/images/expand.bmp');"
                    onclick=toggleDetail(this)>&nbsp;</TD>
                <TD class="print"><DIV dataFld=productid></DIV></TD>
                <TD class="print"><DIV dataFld=ruserialno></DIV></TD>
                <TD class="print"><DIV dataFld=rurevision></DIV></TD>
                <TD class="print"><DIV dataFld=ruposition></DIV></TD>
	           </TR>
              <TR class="print" style="DISPLAY: none">
                <TD>&nbsp;</TD>
                <TD  class="print" COLSPAN=4>
                  <TABLE dataFld=equipmentdata2 id=EquipDataDet2 class="print"
                  style="BORDER-COLLAPSE: collapse" dataSrc=#equipment width="100%"
                  border=1>
                    <THEAD>
                    <TR class="print">
                      <TD class="print"><B>Product ID</B></TD>
                      <TD class="print"><B>RU Serial No</B></TD>
                      <TD class="print"><B>RU Revision</B></TD>
                      <TD class="print"><B>RU Position</B></TD>
      	            </TR>
      	            </THEAD>
                    <TBODY>
                    <TR class="print">
                      <TD class="print"><DIV dataFld=productid></DIV></TD>
                      <TD class="print"><DIV dataFld=ruserialno></DIV></TD>
                      <TD class="print"><DIV dataFld=rurevision></DIV></TD>
                      <TD class="print"><DIV dataFld=ruposition></DIV></TD>
      	           </TR>
                   </TBODY>
      	           </TABLE>
                </TD></TR>
             </TBODY>
	           </TABLE>
          </TD></TR>
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

<SCRIPT>
function toggleDetail(e) {
  var d, ep;
  ep = e.parentElement;
  d = ep.nextSibling;
  if (d.style.display == "none") {
     d.style.display = "";
     e.style.backgroundImage = 'url(/images/collapse.bmp)';
     //e.style.backgroundColor = "red";
  } else {
     d.style.display = "none";
     //e.style.backgroundColor = "green";
     e.style.backgroundImage = 'url(/images/expand.bmp)';
  }
}

</SCRIPT>


