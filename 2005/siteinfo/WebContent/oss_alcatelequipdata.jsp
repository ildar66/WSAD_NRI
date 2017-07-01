<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

 <XML id=equipment SRC='<%= "/siteinfo/GetAlcatelEquipmentData?gsmid=" + request.getParameter("gsmid") %>'></XML>
 <XML id=eqhead SRC='<%= "/siteinfo/GetAlcatelEquipmentData?datainfo=1&gsmid=" + request.getParameter("gsmid") %>'></XML>

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
          <TD class="print">&nbsp;</TD>
          <TD class="print"><B>BSC label</B></TD>
          <TD class="print"><B>BTS label</B></TD>
          <TD class="print"><B>BTS Generation</B></TD>
          <TD class="print"><B>Filename</B></TD>
          <TD class="print"><B>Net Element</B></TD>
          <TD class="print"><B>NetID</B></TD>
          <TD class="print"><B>Cypher</B></TD>
          <TD class="print"><B>Location</B></TD>
          <TD class="print"><B>Load Time</B></TD>
          <TD class="print"><B>First Comm Date</B></TD>
	      </TR>
	     </THEAD>
        <TBODY>
        <TR class="print">
          <TD class="print" style="CURSOR: hand; BACKGROUND-REPEAT: no-repeat;
		background-position:center center;
		BACKGROUND-IMAGE: url('/images/expand.bmp');"
                onclick=toggleDetail(this)>&nbsp;</TD>
          <TD class="print"><DIV dataFld=bsclabel type="text"></DIV></TD>
          <TD class="print"><DIV dataFld=btslabel type="text"></DIV></TD>
          <TD class="print"><DIV dataFld=btsgeneration type="text"></DIV></TD>
          <TD class="print"><DIV dataFld=filename></DIV></TD>
          <TD class="print"><DIV dataFld=netelement></DIV></TD>
          <TD class="print"><DIV dataFld=netid></DIV></TD>
          <TD class="print"><DIV dataFld=cypher></DIV></TD>
          <TD class="print"><DIV dataFld=location></DIV></TD>
          <TD class="print"><DIV dataFld=loadtime></DIV></TD>
          <TD class="print"><DIV dataFld=firstcommdate></DIV></TD>
	     </TR>
        <TR class="print" style="DISPLAY: none">
          <TD>&nbsp;</TD>
          <TD  class="print" colSpan=10>
            <TABLE dataFld=equipmentdata id=EquipDataDet class="print"
            style="BORDER-COLLAPSE: collapse" dataSrc=#equipment width="100%"
            border=1>
              <THEAD>
              <TR class="print">
                <TD class="print"><B>Level</B></TD>
                <TD class="print"><B>Mnemonic</B></TD>
                <TD class="print"><B>Rack</B></TD>
                <TD class="print"><B>Shelf</B></TD>
                <TD class="print"><B>Slot</B></TD>
                <TD class="print"><B>Serial</B></TD>
                <TD class="print"><B>Part Number</B></TD>
                <TD class="print"><B>ICS</B></TD>
                <TD class="print"><B>End of Warranty Date</B></TD>
                <TD class="print"><B>First Comm Date</B></TD>
                <TD class="print"><B>Last Repair Date</B></TD>
                <TD class="print"><B>Label Gen</B></TD>
                <TD class="print"><B>Scan Date</B></TD>
	      </TR>
	      </THEAD>
              <TBODY>
              <TR class="print">
                <TD class="print"><DIV dataFld=level></DIV></TD>
                <TD class="print"><DIV dataFld=mnemonic></DIV></TD>
                <TD class="print"><DIV dataFld=rack></DIV></TD>
                <TD class="print"><DIV dataFld=shelf></DIV></TD>
                <TD class="print"><DIV dataFld=slot></DIV></TD>
                <TD class="print"><DIV dataFld=serial></DIV></TD>
                <TD class="print"><DIV dataFld=partnumber></DIV></TD>
                <TD class="print"><DIV dataFld=ics></DIV></TD>
                <TD class="print"><DIV dataFld=endofwarrdate></DIV></TD>
                <TD class="print"><DIV dataFld=firstcommdate></DIV></TD>
                <TD class="print"><DIV dataFld=lastrepdate></DIV></TD>
                <TD class="print"><DIV dataFld=labelgen></DIV></TD>
                <TD class="print"><DIV dataFld=scandate></DIV></TD>
	           </TR>
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


