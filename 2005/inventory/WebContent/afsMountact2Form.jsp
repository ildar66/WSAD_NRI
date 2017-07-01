<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.constants.*,com.hps.july.inventory.*,com.hps.july.inventory.formbean.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import="com.hps.july.inventory.formbean.*"%>

<%
	int astate = ParamsParser.getState( pageContext );
    AfsMountAct2Form form2 = (AfsMountAct2Form)request.getSession().getAttribute("AfsMountAct2Form");
    AfsMountAct3Form form3= null;
	boolean is900 = (astate == com.hps.july.inventory.APPStates.AFSEDIT22) && (form2 != null);
	if (form2 == null)
    	form2 = (AfsMountAct2Form)request.getAttribute("AfsMountAct3Form");
	int indiap = form2.getIndiap();
	String edit1800 = "true";
	String action = "/ProcessAfsMountAct2.do";
	String headerA = "label.afsmountact2.headerA";
	String headerB = "label.afsmountact2.headerB";
	String headerC = "label.afsmountact2.headerC";
	String headerD = "label.afsmountact2.headerD";
	String editCable = "true";
	if ( (indiap == 1) || (indiap == 2) || is900) {
    	action = "/ProcessAfsMountAct3.do";
  	}
	if ( (indiap == 2) || is900 ) {
	  headerA = "label.afsmountact2.headerE";
	  headerB = "label.afsmountact2.headerF";
	  headerC = "label.afsmountact2.headerG";
	  headerD = "label.afsmountact2.headerH";
  	}
	if (is900) {
    	edit1800 = "false";
    	form3 = (AfsMountAct3Form)request.getAttribute("AfsMountAct3Form");
  	}
	boolean showStateLink = ("View".equals(form2.getAction()) || "Edit".equals(form2.getAction()));
	String docstate = form2.getDState();
%>

      <SCRIPT>
        function changeVis(tarr, aspan, ares) {
          var val;
          if (ares.value)
            val = ares.value;
          else
            val = ares[0].value;
          if ( (tarr [val] == 'b') || (tarr [val] == 'B') ) {
            for (i=0; i < aspan.length-1; i=i+2) {
              aspan [i].style.cssText = "visibility:hidden; display:none;";
              aspan [i+1].style.cssText = "visibility:visible; display:inline;";
            }
          } else if ( (tarr [val] == 'p') || (tarr [val] == 'P') ) {
            for (i=0; i < aspan.length-1; i=i+2) {
              aspan [i].style.cssText = "visibility:visible; display:inline;";
              aspan [i+1].style.cssText = "visibility:hidden; display:none;";
            }
          } else if ( (tarr [val] == 's') || (tarr [val] == 'S') ) {
            for (i=0; i < aspan.length-1; i=i+2) {
              aspan [i].style.cssText = "visibility:visible; display:inline;";
              aspan [i+1].style.cssText = "visibility:hidden; display:none;";
            }
          } else {
            for (i=0; i < aspan.length-1; i=i+2) {
              aspan [i].style.cssText = "visibility:hidden; display:none;";
              aspan [i+1].style.cssText = "visibility:hidden; display:none;";
            }
          }
        }
        
        function changeDiffs(acol) {
          if (acol == 'O') {
            document.all.ahead [0].innerText = 'O';
          } else {
          <% if ( is900 || (indiap == 2) ) { %>
            document.all.ahead [0].innerText = 'E';
          <% } else { %>
            document.all.ahead [0].innerText = 'A';
          <% } %>
          }
          if ( (acol == 1) || (acol == 2) ) {
            document.all.ahead [0].style.visibility = 'hidden';
            document.all.ahead [0].style.display = 'none';
            document.all.ahead [1].style.visibility = 'visible';
            document.all.ahead [1].style.display = 'block';
            document.all.bhead [0].style.visibility = 'hidden';
            document.all.bhead [0].style.display = 'none';
            document.all.bhead [1].style.visibility = 'visible';
            document.all.bhead [1].style.display = 'block';
          } else {
            document.all.ahead [1].style.visibility = 'hidden';
            document.all.ahead [1].style.display = 'none';
            document.all.ahead [0].style.visibility = 'visible';
            document.all.ahead [0].style.display = 'block';
            document.all.bhead [1].style.visibility = 'hidden';
            document.all.bhead [1].style.display = 'none';
            document.all.bhead [0].style.visibility = 'visible';
            document.all.bhead [0].style.display = 'block';
          }
          
          if ((acol == 1) || (acol == 'O')) {
            document.styleSheets[1].rules.item(0).style.visibility = 'visible';
            document.styleSheets[1].rules.item(0).style.display = 'block';
            document.styleSheets[1].rules.item(1).style.visibility = 'hidden';
            document.styleSheets[1].rules.item(1).style.display = 'none';
            document.styleSheets[1].rules.item(2).style.visibility = 'hidden';
            document.styleSheets[1].rules.item(2).style.display = 'none';
            document.styleSheets[1].rules.item(3).style.visibility = 'hidden';
            document.styleSheets[1].rules.item(3).style.display = 'none';
          } else if (acol == 2) {
            document.styleSheets[1].rules.item(0).style.visibility = 'visible';
            document.styleSheets[1].rules.item(0).style.display = 'block';
            document.styleSheets[1].rules.item(1).style.visibility = 'visible';
            document.styleSheets[1].rules.item(1).style.display = 'block';
            document.styleSheets[1].rules.item(2).style.visibility = 'hidden';
            document.styleSheets[1].rules.item(2).style.display = 'none';
            document.styleSheets[1].rules.item(3).style.visibility = 'hidden';
            document.styleSheets[1].rules.item(3).style.display = 'none';
          } else if (acol == 3) {
            document.styleSheets[1].rules.item(0).style.visibility = 'visible';
            document.styleSheets[1].rules.item(0).style.display = 'block';
            document.styleSheets[1].rules.item(1).style.visibility = 'visible';
            document.styleSheets[1].rules.item(1).style.display = 'block';
            document.styleSheets[1].rules.item(2).style.visibility = 'visible';
            document.styleSheets[1].rules.item(2).style.display = 'block';
            document.styleSheets[1].rules.item(3).style.visibility = 'hidden';
            document.styleSheets[1].rules.item(3).style.display = 'none';
          } else if (acol == 4) {
            document.styleSheets[1].rules.item(0).style.visibility = 'visible';
            document.styleSheets[1].rules.item(0).style.display = 'block';
            document.styleSheets[1].rules.item(1).style.visibility = 'visible';
            document.styleSheets[1].rules.item(1).style.display = 'block';
            document.styleSheets[1].rules.item(2).style.visibility = 'visible';
            document.styleSheets[1].rules.item(2).style.display = 'block';
            document.styleSheets[1].rules.item(3).style.visibility = 'visible';
            document.styleSheets[1].rules.item(3).style.display = 'block';
          }
        }
      </SCRIPT>
      
<script language="javascript" src="/action.js"></script>


<july:inventorycalcerrors document="<%= form2.getDocumentId() %>" />
<july:editform action="<%= action %>">

    <html:hidden property="document" />
    <html:hidden property="oldposnumber" />
    <html:hidden property="manycomplects" />
    <html:hidden property="indiap" />
    <html:hidden property="diap" />
    <html:hidden property="visualtype" />
    <html:hidden property="processState" />
    <html:hidden property="warnProc" />
    <html:hidden property="DState"/>
    <html:hidden property="user"/>
    
    <INPUT TYPE="HIDDEN" NAME="refreshFields" ID="refreshFields" VALUE="0">

<table class="main">
    
    <july:separator/>
    
	<july:formbuttons>
<%if(showStateLink){%>
	<%if("1".equals(docstate)) {%>
		<input type="image" name="submit" src="/images/calculate.gif" onclick="document.all.action.value='Edit';document.all.processState.value='P';document.all.warnProc.value='false';return checkPosted();" title="Обсчёт">
<%if(com.hps.july.util.AppUtils.isNewInventory()) {%>
<%  if(form2.getWarnProc() != null && form2.getWarnProc().booleanValue()) {%>
		<input type="image" name="submit" src="/images/calculatea.gif" onclick="document.all.action.value='Edit';document.all.processState.value='P';document.all.warnProc.value='true';return checkPosted();" title="Обсчёт с автоматическим исправлением несоответствий">
<%  }%>
<%}%>
	<%} else {
		String actUrl1 = action + "?action=Edit&processState=C&document=" + form2.getDocument() + "&visualtype=" + form2.getVisualtype();
	%>
		<html:link page="<%= actUrl1 %>" onclick="return checkPosted();"><img src="/images/calculates.gif" border=0 alt="Снять обсчёт"></html:link>
	<%}%>
<%}%>
	</july:formbuttons>

	<july:separator/>

    <tr>
        <td class="title" colspan="2"><july:actionalert/></td>
    </tr>

    <july:separator/>
    
    <TR><TD class="text" colspan="2">
    
      <TABLE class="print" style="font-size:8pt;">
      <TR class="print">
        <TD COLSPAN="14" class="print" style="margin-top: 0; margin-bottom:0; padding-top: 1; padding-bottom: 1;">
          <DIV><july:errors property="head" shortformat="true"/></DIV>
          <bean:message key="label.mountact2.actno"/>
          <bean:message key="label.mountact2.posno"/>
          <july:string property="posnumber" style="font-size:8pt;"
              size="5" insertable="<%= edit1800 %>" updatable="<%= edit1800 %>"/>
          <% if (form2.isManycomplects()) { %>
      			<july:select collection="complects" property="complectcode"
                style="font-size:8pt;"
                insertable="<%= edit1800 %>" updatable="<%= edit1800 %>">
      				<html:option value="">&nbsp;</html:option>
      				<july:options collection="complects" property="equipment" labelProperty="name"/>
      			</july:select>

          <% } else { %>
      			<html:hidden property="complectcode"/>
      			<july:string size="25"
              style="font-size:8pt;"
              property="complectname" styleId="complectname" insertable="false" updatable="false" />
          <% }  %>
          <bean:message key="label.mountact2.project"/>
		  <html:hidden property="projectid"/>
		  <july:string size="25" style="font-size:8pt;" 
		  	property="projectname" insertable="false" updatable="false"/>
          <A HREF="#" onclick="return false;">
          <IMG SRC="/images/dictrefrsh.gif" BORDER=0
            onclick="document.all.refreshFields.value=1; document.forms(0).submit();"
            alt="Обновить данные справочников">
          </A>
          <BR>
          <bean:message key="label.afsmountact2.range"/>&nbsp;<SPAN style="background-color: #D0FFD0;font-size:10pt; font-weight: bold;"><july:stringwrite property="diap"/></SPAN>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          <bean:message key="label.afsmountact2.diffs"/>
          <july:radio property="diffs" onclick="changeDiffs(this.value);" value="O"
            style="width: 20px;"
            insertable="true" updatable="true"/><bean:message key="label.afsmountact2.diffs_o"/>&nbsp;
          <july:radio property="diffs" onclick="changeDiffs(this.value);" value="1"
            style="width: 20px;"
            insertable="true" updatable="true"/><bean:message key="label.afsmountact2.diffs_1"/>&nbsp;
          <july:radio property="diffs" onclick="changeDiffs(this.value);" value="2"
            style="width: 20px;"
            insertable="true" updatable="true"/><bean:message key="label.afsmountact2.diffs_2"/>&nbsp;
          <july:radio property="diffs" onclick="changeDiffs(this.value);" value="3"
            style="width: 20px;"
            insertable="true" updatable="true"/><bean:message key="label.afsmountact2.diffs_3"/>&nbsp;
          <july:radio property="diffs" onclick="changeDiffs(this.value);" value="4"
            style="width: 20px;"
            insertable="true" updatable="true"/><bean:message key="label.afsmountact2.diffs_4"/>&nbsp;
        </TD>
      </TR>
      <TR class="print">
        <TD COLSPAN=2 ROWSPAN=2 class="print" style="margin-top: 0; margin-bottom:0; padding-top: 1; padding-bottom: 1;"><bean:message key="label.afsmountact2.header1"/></TD>
        <TD COLSPAN=3  class="printA" style="margin-top: 0; margin-bottom:0; padding-top: 1; padding-bottom: 1;"
          ALIGN=CENTER><SPAN ID="ahead"><bean:message key="<%= headerA %>"/></span><SPAN ID="ahead"><july:select property="sectorA"
              style="font-size:8pt; width: 40px;"
              insertable="true" updatable="true">
            <html:option value="A"><bean:message key="<%= headerA %>"/></html:option>
            <html:option value="B"><bean:message key="<%= headerB %>"/></html:option>
            <html:option value="C"><bean:message key="<%= headerC %>"/></html:option>
            <html:option value="D"><bean:message key="<%= headerD %>"/></html:option>
          </july:select></span>
        </TD>
        <TD COLSPAN=3 class="printB" style="margin-top: 0; margin-bottom:0; padding-top: 1; padding-bottom: 1;"
          ALIGN=CENTER><SPAN ID="bhead"><bean:message key="<%= headerB %>"/></span><SPAN ID="bhead"><july:select property="sectorB"
              style="font-size:8pt; width: 40px;"
              insertable="true" updatable="true">
            <html:option value="A"><bean:message key="<%= headerA %>"/></html:option>
            <html:option value="B"><bean:message key="<%= headerB %>"/></html:option>
            <html:option value="C"><bean:message key="<%= headerC %>"/></html:option>
            <html:option value="D"><bean:message key="<%= headerD %>"/></html:option>
          </july:select></span>
        </TD>
        <TD COLSPAN=3 class="printC" style="margin-top: 0; margin-bottom:0; padding-top: 1; padding-bottom: 1;" ALIGN=CENTER><bean:message key="<%= headerC %>"/></TD>
        <TD COLSPAN=3 class="printD" style="margin-top: 0; margin-bottom:0; padding-top: 1; padding-bottom: 1;" ALIGN=CENTER><bean:message key="<%= headerD %>"/></TD>
      </TR>
      <TR class="print">
        <TD class="printA" style="margin-top: 0; margin-bottom:0; padding-top: 1; padding-bottom: 1;" ALIGN=CENTER><bean:message key="label.afsmountact2.headerA"/></TD>
        <TD class="printA" style="margin-top: 0; margin-bottom:0; padding-top: 1; padding-bottom: 1;" ALIGN=CENTER><bean:message key="label.afsmountact2.headerB"/></TD>
        <TD class="printA" style="margin-top: 0; margin-bottom:0; padding-top: 1; padding-bottom: 1;" ALIGN=CENTER><bean:message key="label.afsmountact2.headerC"/></TD>
        <TD class="printB" style="margin-top: 0; margin-bottom:0; padding-top: 1; padding-bottom: 1;" ALIGN=CENTER><bean:message key="label.afsmountact2.headerA"/></TD>
        <TD class="printB" style="margin-top: 0; margin-bottom:0; padding-top: 1; padding-bottom: 1;" ALIGN=CENTER><bean:message key="label.afsmountact2.headerB"/></TD>
        <TD class="printB" style="margin-top: 0; margin-bottom:0; padding-top: 1; padding-bottom: 1;" ALIGN=CENTER><bean:message key="label.afsmountact2.headerC"/></TD>
        <TD class="printC" style="margin-top: 0; margin-bottom:0; padding-top: 1; padding-bottom: 1;" ALIGN=CENTER><bean:message key="label.afsmountact2.headerA"/></TD>
        <TD class="printC" style="margin-top: 0; margin-bottom:0; padding-top: 1; padding-bottom: 1;" ALIGN=CENTER><bean:message key="label.afsmountact2.headerB"/></TD>
        <TD class="printC" style="margin-top: 0; margin-bottom:0; padding-top: 1; padding-bottom: 1;" ALIGN=CENTER><bean:message key="label.afsmountact2.headerC"/></TD>
        <TD class="printD" style="margin-top: 0; margin-bottom:0; padding-top: 1; padding-bottom: 1;" ALIGN=CENTER><bean:message key="label.afsmountact2.headerA"/></TD>
        <TD class="printD" style="margin-top: 0; margin-bottom:0; padding-top: 1; padding-bottom: 1;" ALIGN=CENTER><bean:message key="label.afsmountact2.headerB"/></TD>
        <TD class="printD" style="margin-top: 0; margin-bottom:0; padding-top: 1; padding-bottom: 1;" ALIGN=CENTER><bean:message key="label.afsmountact2.headerC"/></TD>
      </TR>
      <TR class="print">
        <TD COLSPAN=2 class="print" style="margin-top: 0; margin-bottom:0; padding-top: 1; padding-bottom: 1;"><bean:message key="label.afsmountact2.header2"/></TD>
        <%
          String[] nlabels = new String [] {"10", "20", "30", "40"};
          String[] alabels = new String [] {"A", "B", "C"};
          String[] blabels = new String [] {"A", "B", "C", "D"};
          for(int i5=0; i5 < nlabels.length; i5++) {
            String nlabname = "" + nlabels [i5];
            String aresource = "resource" + nlabname;
            String aerr = "resource" + nlabname + "A";
            String acateg = "categoryResources" + nlabname;
            String bname = "print" + blabels [i5];
            String achange = "try {changeVis(categoryResources" + nlabname + "_arr, document.all.div" + nlabname + ", document.all.resource" + nlabname + ");} catch (e1) {try {changeVis(categoryResources" + nlabname + "_arr, document.all.div" + nlabname + ", document.all.resource" + nlabname + "[0]);} catch (e2) {}};";
            String canedres = "true";

			String idc = form2.getCategoryId((new Integer(nlabname)).intValue());
   	        if (is900) {
              if ( ( ("10".equals(nlabname)) && ( form3.isComcabAA() || form3.isComcabAB() || form3.isComcabAC() || ( (form3.getResource10() != null) && form3.isTwoDiapAntenn(form3.getResource10().intValue())) ) ) ||
                   ( ("20".equals(nlabname)) && ( form3.isComcabBA() || form3.isComcabBB() || form3.isComcabBC() || ( (form3.getResource20() != null) && form3.isTwoDiapAntenn(form3.getResource20().intValue())) ) ) ||
                   ( ("30".equals(nlabname)) && ( form3.isComcabCA() || form3.isComcabCB() || form3.isComcabCC() || ( (form3.getResource30() != null) && form3.isTwoDiapAntenn(form3.getResource30().intValue())) ) ) ||
                   ( ("40".equals(nlabname)) && ( form3.isComcabDA() || form3.isComcabDB() || form3.isComcabDC() || ( (form3.getResource40() != null) && form3.isTwoDiapAntenn(form3.getResource40().intValue())) ) ) )
                canedres = "false";
                //System.out.println("AFSMOU2: #1, nlabname=" + nlabname + ", comcab=" + (form3.isComcabAA() || form3.isComcabAB() || form3.isComcabAC()) + ", res=" + form3.getResource10() + ", 2diap=" + form3.isTwoDiapAntenn(form3.getResource10().intValue()));
   	        }
        %>
        <TD COLSPAN=3 class="<%= bname %>" VALIGN="bottom" style="margin-top: 0; margin-bottom:0; margin-left: 0; margin-right:0; padding-top: 1; padding-bottom: 1;padding-left: 1; padding-right: 1;" ALIGN=CENTER>
          <DIV><july:errors property="<%= aerr %>" shortformat="true"/></DIV>
    			<july:select collection="<%= acateg %>" property="<%= aresource %>"
              style="font-size:8pt; width:80%;"
              onchange="<%= achange %>"
              insertable="<%= canedres %>" updatable="<%= canedres %>">
    				<html:option value="">&nbsp;</html:option>
    				<july:options collection="<%= acateg %>" property="resource" labelProperty="model" addProperty="countpolicy"/>
    			</july:select>

				<SCRIPT language="JScript">
				function open_window<%=nlabname%>() {
					myWindow = window.open("/dict/ShowInvResourceListWN.do?category=<%=idc%>", "newWindow", "top=40, left=100, width=830, height=630, scrollbars=yes, resizable=yes");  
					myWindow.focus();
				}
				</SCRIPT>				
				
				<A HREF="#" name="lookupbtn_style" onclick="open_window<%=nlabname%>(); return false;"><img name="lookupimg_style" src="/images/lookup.gif" border="0" alt="Справочник"></A>	

        </TD>
        <% } %>
      </TR>
      <%

      for(int j1=0; j1 < alabels.length; j1++) {
      %>
      <TR class="print">
        <% if (j1==0) { %>
        <TD COLSPAN=2 ROWSPAN=3 class="print" style="margin-top: 0; margin-bottom:0; padding-top: 1; padding-bottom: 1;"><bean:message key="label.afsmountact2.header3"/></TD>
        <% } %>
   <%

      for(int i1=0; i1 < nlabels.length; i1++) {
        String nlabname = "" + nlabels [i1];
        String alabname = "" + alabels [j1];
        String alabel = "label.afsmountact2.header" + alabname;
        String aresource = "resource" + nlabname + alabname;
        String aserial = "serial" + nlabname + alabname;
        String aqty = "qty" + nlabname + alabname;
        String adiv = "div" + nlabname;
        String bname = "print" + blabels [i1];
        String canedres = "true";
   	        if (is900) {
              if ( ( ("10".equals(nlabname)) && ( form3.isComcabAA() || form3.isComcabAB() || form3.isComcabAC() || ( (form3.getResource10() != null) && form3.isTwoDiapAntenn(form3.getResource10().intValue())) ) ) ||
                   ( ("20".equals(nlabname)) && ( form3.isComcabBA() || form3.isComcabBB() || form3.isComcabBC() || ( (form3.getResource20() != null) && form3.isTwoDiapAntenn(form3.getResource20().intValue())) ) ) ||
                   ( ("30".equals(nlabname)) && ( form3.isComcabCA() || form3.isComcabCB() || form3.isComcabCC() || ( (form3.getResource30() != null) && form3.isTwoDiapAntenn(form3.getResource30().intValue())) ) ) ||
                   ( ("40".equals(nlabname)) && ( form3.isComcabDA() || form3.isComcabDB() || form3.isComcabDC() || ( (form3.getResource40() != null) && form3.isTwoDiapAntenn(form3.getResource40().intValue())) ) ) )
                canedres = "false";
   	        }
   %>
        <TD COLSPAN=3 class="<%= bname %>" VALIGN="bottom" style="height:25px; margin-top: 0; margin-bottom:0; padding-top: 1; padding-bottom: 1;" ALIGN=CENTER>

          <SPAN ID="<%= adiv %>">
            <DIV><july:errors property="<%= aserial %>" shortformat="true"/></DIV>
            <bean:message key="<%= alabel %>"/>:&nbsp;<july:string property="<%= aserial %>"
              style="font-size:8pt;"
              size="10" insertable="<%= canedres %>" updatable="<%= canedres %>"/>
          </SPAN>
          <SPAN ID="<%= adiv %>">
            <DIV><july:errors property="<%= aserial %>" shortformat="true"/></DIV>
            <bean:message key="<%= alabel %>"/>:&nbsp;<july:string property="<%= aqty %>" size="5"
              style="font-size:8pt;"
              insertable="<%= canedres %>" updatable="<%= canedres %>"/>&nbsp;<bean:message key="label.mountact2.qty"/></TD>
          </SPAN>
        </TD>
     <%
           }
     %>
      </TR>
      <%
        }
        
          for(int i6=0; i6 < nlabels.length; i6++) {
            String nlabname = "" + nlabels [i6];
            String achange = "try {changeVis(categoryResources" + nlabname + "_arr, document.all.div" + nlabname + ", document.all.resource" + nlabname + ");} catch (e1) {try {changeVis(categoryResources" + nlabname + "_arr, document.all.div" + nlabname + ", document.all.resource" + nlabname + "[0]);} catch (e2) {}};";
      %>
      <SCRIPT language="JScript">
        <%= achange %>
      </SCRIPT>
      <%
        }
      %>
      
      <TR class="print">
        <TD COLSPAN=2 class="print" style="margin-top: 0; margin-bottom:0; padding-top: 1; padding-bottom: 1;"><bean:message key="label.afsmountact2.header4"/></TD>
      <%

      for(int j7=0; j7 < blabels.length; j7++) {
        String aname = "azim" + blabels [j7];
        String bname = "print" + blabels [j7];
            String nlabname = "" + nlabels [j7];
            String canedres = "true";
   	        if (is900) {
              if ( ( ("10".equals(nlabname)) && ( form3.isComcabAA() || form3.isComcabAB() || form3.isComcabAC() || ( (form3.getResource10() != null) && form3.isTwoDiapAntenn(form3.getResource10().intValue())) ) ) ||
                   ( ("20".equals(nlabname)) && ( form3.isComcabBA() || form3.isComcabBB() || form3.isComcabBC() || ( (form3.getResource20() != null) && form3.isTwoDiapAntenn(form3.getResource20().intValue())) ) ) ||
                   ( ("30".equals(nlabname)) && ( form3.isComcabCA() || form3.isComcabCB() || form3.isComcabCC() || ( (form3.getResource30() != null) && form3.isTwoDiapAntenn(form3.getResource30().intValue())) ) ) ||
                   ( ("40".equals(nlabname)) && ( form3.isComcabDA() || form3.isComcabDB() || form3.isComcabDC() || ( (form3.getResource40() != null) && form3.isTwoDiapAntenn(form3.getResource40().intValue())) ) ) )
                canedres = "false";
   	        }
      %>
        <TD COLSPAN=3 class="<%= bname %>" VALIGN="bottom" style="margin-top: 0; margin-bottom:0; padding-top: 1; padding-bottom: 1;" ALIGN=CENTER>
              <july:string property="<%= aname %>"
              style="font-size:8pt;"
              size="10" insertable="<%= canedres %>" updatable="<%= canedres %>"/>
        </TD>
      <% } %>
      </TR>

      
      <TR class="print">
        <TD COLSPAN=2 class="print" style="margin-top: 0; margin-bottom:0; padding-top: 1; padding-bottom: 1;"><bean:message key="label.afsmountact2.header11"/></TD>
      <%

      for(int j11=0; j11 < blabels.length; j11++) {
        String aname = "hset" + blabels [j11];
        String bname = "print" + blabels [j11];
        String nlabname = "" + nlabels [j11];
        String canedres = "true";
   	    if (is900) {
              if ( ( ("10".equals(nlabname)) && ( form3.isComcabAA() || form3.isComcabAB() || form3.isComcabAC() || ( (form3.getResource10() != null) && form3.isTwoDiapAntenn(form3.getResource10().intValue())) ) ) ||
                   ( ("20".equals(nlabname)) && ( form3.isComcabBA() || form3.isComcabBB() || form3.isComcabBC() || ( (form3.getResource20() != null) && form3.isTwoDiapAntenn(form3.getResource20().intValue())) ) ) ||
                   ( ("30".equals(nlabname)) && ( form3.isComcabCA() || form3.isComcabCB() || form3.isComcabCC() || ( (form3.getResource30() != null) && form3.isTwoDiapAntenn(form3.getResource30().intValue())) ) ) ||
                   ( ("40".equals(nlabname)) && ( form3.isComcabDA() || form3.isComcabDB() || form3.isComcabDC() || ( (form3.getResource40() != null) && form3.isTwoDiapAntenn(form3.getResource40().intValue())) ) ) )
                canedres = "false";
   	    }
      %>
        <TD COLSPAN=3 class="<%= bname %>" VALIGN="bottom" style="margin-top: 0; margin-bottom:0; padding-top: 1; padding-bottom: 1;" ALIGN=CENTER>
              <july:string property="<%= aname %>"
              style="font-size:8pt;"
              size="10" insertable="<%= canedres %>" updatable="<%= canedres %>"/>
        </TD>
      <% } %>
      </TR>


      <TR class="print">
        <TD COLSPAN=2 class="print" style="margin-top: 0; margin-bottom:0; padding-top: 1; padding-bottom: 1;"><bean:message key="label.afsmountact2.header5"/></TD>
      <%

      for(int j8=0; j8 < blabels.length; j8++) {
        String aname = "nakl" + blabels [j8];
        String bname = "print" + blabels [j8];
            String nlabname = "" + nlabels [j8];
            String canedres = "true";
   	        if (is900) {
              if ( ( ("10".equals(nlabname)) && ( form3.isComcabAA() || form3.isComcabAB() || form3.isComcabAC() || ( (form3.getResource10() != null) && form3.isTwoDiapAntenn(form3.getResource10().intValue())) ) ) ||
                   ( ("20".equals(nlabname)) && ( form3.isComcabBA() || form3.isComcabBB() || form3.isComcabBC() || ( (form3.getResource20() != null) && form3.isTwoDiapAntenn(form3.getResource20().intValue())) ) ) ||
                   ( ("30".equals(nlabname)) && ( form3.isComcabCA() || form3.isComcabCB() || form3.isComcabCC() || ( (form3.getResource30() != null) && form3.isTwoDiapAntenn(form3.getResource30().intValue())) ) ) ||
                   ( ("40".equals(nlabname)) && ( form3.isComcabDA() || form3.isComcabDB() || form3.isComcabDC() || ( (form3.getResource40() != null) && form3.isTwoDiapAntenn(form3.getResource40().intValue())) ) ) )
                canedres = "false";
   	        }
      %>
        <TD COLSPAN=3 class="<%= bname %>" VALIGN="bottom" style="margin-top: 0; margin-bottom:0; padding-top: 1; padding-bottom: 1;" ALIGN=CENTER>
              <july:string property="<%= aname %>"
              style="font-size:8pt;"
              size="10" insertable="<%= canedres %>" updatable="<%= canedres %>"/>
        </TD>
      <% } %>
      </TR>
      
      <TR class="print">
        <TD COLSPAN=2 class="print" style="margin-top: 0; margin-bottom:0; padding-top: 1; padding-bottom: 1;"><bean:message key="label.afsmountact2.header10"/></TD>
        
      <%
      for(int j9=0; j9 < blabels.length; j9++) {
        String sectname = blabels [j9];
        String aname = "resource50" + blabels [j9];
        String bname = "print" + blabels [j9];
        String catname = "categoryResources50" + blabels [j9];
        String cchange = "try {changeVis(categoryResources50" + sectname + "_arr, document.all.div50" + sectname + ", document.all.resource50" + sectname + ");} catch (e1) {try {changeVis(categoryResources50" + sectname + "_arr, document.all.div50" + sectname + ", document.all.resource50" + sectname + "[0]);} catch (e2) {};};";
        editCable = "true";

		String idc = form2.getCategoryId(50);

        if (is900) {
          if ( ( ("A".equals(sectname)) && ( form3.isComcabAA() || form3.isComcabAB() || form3.isComcabAC() ) ) ||
               ( ("B".equals(sectname)) && ( form3.isComcabBA() || form3.isComcabBB() || form3.isComcabBC() ) ) ||
               ( ("C".equals(sectname)) && ( form3.isComcabCA() || form3.isComcabCB() || form3.isComcabCC() ) ) ||
               ( ("D".equals(sectname)) && ( form3.isComcabDA() || form3.isComcabDB() || form3.isComcabDC() ) ) )
            editCable = "false";
        }
      %>
        <TD COLSPAN=3 class="<%= bname %>" style="margin-top: 0; margin-bottom:0; padding-top: 1; padding-bottom: 1;" ALIGN=CENTER>
    			<july:select collection="<%= catname %>" property="<%= aname %>"
              style="font-size:8pt; width: 150px;"
              onchange="<%= cchange %>"
              insertable="<%= editCable %>" updatable="<%= editCable %>">
    				<html:option value="">&nbsp;</html:option>
    				<july:options collection="<%= catname %>" property="resource" labelProperty="model" addProperty="countpolicy"/>
    			</july:select>

				<SCRIPT language="JScript">
				function open_window50() {
					myWindow = window.open("/dict/ShowInvResourceListWN.do?category=<%=idc%>", "newWindow", "top=40, left=100, width=830, height=630, scrollbars=yes, resizable=yes");  
					myWindow.focus();
				}
				</SCRIPT>				
				
				<A HREF="#" name="lookupbtn_style" onclick="open_window50(); return false;"><img name="lookupimg_style" src="/images/lookup.gif" border="0" alt="Справочник"></A>	

        </TD>
      <% } %>
      </TR>

      <TR class="print">
        <TD class="print" COLSPAN=2 style="margin-top: 0; margin-bottom:0; padding-top: 1; padding-bottom: 1;"><bean:message key="label.afsmountact2.header10"/></TD>
        <%
      for(int i3=0; i3 < blabels.length; i3++) {
        String bname = "print" + blabels [i3];
        for(int j3=0; j3 < alabels.length; j3++) {
          String blabname = "" + blabels [i3];
          String alabname = "" + alabels [j3];
          String clabname = blabname + alabname;
          String bserial = "serial50" + clabname;
          String bdiv = "div50" + blabels [i3];
          String bqty = "qty50" + clabname;
          
          editCable = "true";
          if (is900) {
            if (
                 ( ("AA".equals(clabname)) && form3.isComcabAA() ) ||
                 ( ("AB".equals(clabname)) && form3.isComcabAB() ) ||
                 ( ("AC".equals(clabname)) && form3.isComcabAC() ) ||
                 ( ("BA".equals(clabname)) && form3.isComcabBA() ) ||
                 ( ("BB".equals(clabname)) && form3.isComcabBB() ) ||
                 ( ("BC".equals(clabname)) && form3.isComcabBC() ) ||
                 ( ("CA".equals(clabname)) && form3.isComcabCA() ) ||
                 ( ("CB".equals(clabname)) && form3.isComcabCB() ) ||
                 ( ("CC".equals(clabname)) && form3.isComcabCC() ) ||
                 ( ("DA".equals(clabname)) && form3.isComcabDA() ) ||
                 ( ("DB".equals(clabname)) && form3.isComcabDB() ) ||
                 ( ("DC".equals(clabname)) && form3.isComcabDC() )
                 )
              editCable = "false";
          }
        %>
        <TD class="<%= bname %>" style="height:25px; margin-top: 0; margin-bottom:0; margin-left: 0; margin-right:0; padding-top: 1; padding-bottom: 1;padding-left: 1; padding-right: 1;" ALIGN=CENTER>
          <SPAN ID="<%= bdiv %>">
    			   <july:string size="15" property="<%= bserial %>"
                style="font-size:8pt; width:64px;"
                styleId="<%= bserial %>" insertable="<%= editCable %>" updatable="<%= editCable %>" />
          </SPAN>
          <SPAN ID="<%= bdiv %>">
             <july:string property="<%= bqty %>" size="5"
              style="font-size:8pt; width:40px;"
              insertable="<%= editCable %>" updatable="<%= editCable %>"/>&nbsp;<bean:message key="label.afsmountact2.cablecnt"/></TD>
          </SPAN>
        </TD>
        <%
        }
      }
        %>
      </TR>
      
      <TR class="print">
        <TD COLSPAN=2 class="print" style="margin-top: 0; margin-bottom:0; padding-top: 1; padding-bottom: 1;"><bean:message key="label.afsmountact2.header6"/></TD>
        <%
      int comcnt = 0;
      for(int i3=0; i3 < blabels.length; i3++) {
        String bname = "print" + blabels [i3];
        for(int j3=0; j3 < alabels.length; j3++) {
          String blabname = "" + blabels [i3];
          String alabname = "" + alabels [j3];
          String chname = "comcab" + blabname + alabname;
        %>
        <TD class="<%= bname %>" style="margin-top: 0; margin-bottom:0; padding-top: 1; padding-bottom: 1;" ALIGN=CENTER>
          <july:checkbox property="<%= chname %>"
              style="font-size:8pt;"
          insertable="<%= edit1800 %>" updatable="<%= edit1800 %>"/>
        </TD>
        <%
          }
        }
        %>
      </TR>

      <%
      for(int j10=0; j10 < blabels.length; j10++) {
        String sectname = blabels [j10];
        String cchange = "try {changeVis(categoryResources50" + sectname + "_arr, document.all.div50" + sectname + ", document.all.resource50" + sectname + ");} catch (e1) {try {changeVis(categoryResources50" + sectname + "_arr, document.all.div50" + sectname + ", document.all.resource50" + sectname + "[0]);} catch (e2) {};};";
      %>
      <SCRIPT language="JScript">
        <%= cchange %>
      </SCRIPT>
      <% } %>

      <TR class="print">
        <TD COLSPAN=2 class="print" style="margin-top: 0; margin-bottom:0; padding-top: 1; padding-bottom: 1;"><bean:message key="label.afsmountact2.header7"/></TD>
        <%
      for(int i4=0; i4 < blabels.length; i4++) {
        String bname = "print" + blabels [i4];
        for(int j4=0; j4 < alabels.length; j4++) {
          String blabname = "" + blabels [i4];
          String alabname = "" + alabels [j4];
          String gndname = "gndcnt" + blabname + alabname;
          String clabname = blabname + alabname;
          editCable = "true";
          if (is900) {
            if (
                 ( ("AA".equals(clabname)) && form3.isComcabAA() ) ||
                 ( ("AB".equals(clabname)) && form3.isComcabAB() ) ||
                 ( ("AC".equals(clabname)) && form3.isComcabAC() ) ||
                 ( ("BA".equals(clabname)) && form3.isComcabBA() ) ||
                 ( ("BB".equals(clabname)) && form3.isComcabBB() ) ||
                 ( ("BC".equals(clabname)) && form3.isComcabBC() ) ||
                 ( ("CA".equals(clabname)) && form3.isComcabCA() ) ||
                 ( ("CB".equals(clabname)) && form3.isComcabCB() ) ||
                 ( ("CC".equals(clabname)) && form3.isComcabCC() ) ||
                 ( ("DA".equals(clabname)) && form3.isComcabDA() ) ||
                 ( ("DB".equals(clabname)) && form3.isComcabDB() ) ||
                 ( ("DC".equals(clabname)) && form3.isComcabDC() )
                 )
              editCable = "false";
          }
        %>
        <TD class="<%= bname %>" style="margin-top: 0; margin-bottom:0; margin-left: 0; margin-right:0; padding-top: 1; padding-bottom: 1;padding-left: 1; padding-right: 1;" ALIGN=CENTER>
          <july:string size="5" property="<%= gndname %>"
              style="font-size:8pt; width:40px;"
          insertable="<%= editCable %>" updatable="<%= editCable %>"/>&nbsp;<bean:message key="label.mountact2.qty"/>
        </TD>
        <%
          }
        }
        %>
      </TR>

      <TR class="print">
        <TD COLSPAN=2 class="print" style="margin-top: 0; margin-bottom:0; padding-top: 1; padding-bottom: 1;"><bean:message key="label.afsmountact2.header8"/></TD>
        <%
      for(int i8=0; i8 < blabels.length; i8++) {
        String bname = "print" + blabels [i8];
        for(int j8=0; j8 < alabels.length; j8++) {
          String blabname = "" + blabels [i8];
          String alabname = "" + alabels [j8];
          String gndname = "ksvn" + blabname + alabname;
        %>
        <TD class="<%= bname %>" style="margin-top: 0; margin-bottom:0; margin-left: 0; margin-right:0; padding-top: 1; padding-bottom: 1;padding-left: 1; padding-right: 1;" ALIGN=CENTER>
          <july:string size="5" property="<%= gndname %>"
              style="font-size:8pt; width:60px;"
          insertable="true" updatable="true"/>
        </TD>
        <%
          }
        }
        %>
      </TR>

   <%
      String[] labels = new String [] {"60",
        "80", "90", "100", "110", "120"};  // "70" - инжектор
        
      for(int j=0; j < labels.length; j++) {
        String i = "" + labels [j];
        String label = "label.afsmountact2.label" + i;
        String resource = "resource" + i;
        //String serial = "serial" + i;
        //String comment = "comment" + i;
        String categ = "categoryResources" + i;
        String bchange = "changeVis(categoryResources" + i + "_arr, document.all.div" + i + ", document.all.resource" + i + ");";

		String idc = form2.getCategoryId((new Integer(i)).intValue());
   %>
      <TR >
        <TD style="margin-top: 0; margin-bottom:0; padding-top: 0; padding-bottom: 0;border-style: solid; border-color: black; border-width: 1;">
		
		<bean:message key="<%= label %>"/>
		
		</TD>
        <TD  VALIGN="bottom" style="margin-top: 0; margin-bottom:0; padding-top: 2; padding-bottom: 2; border-style: solid; border-color: black; border-width: 1;">
          <DIV><july:errors property="<%= resource %>" shortformat="true"/></DIV>
    			<july:select collection="<%= categ %>" property="<%= resource %>"
              style="font-size:8pt; width: 100px;"
              onchange="<%= bchange %>"
              insertable="true" updatable="true">
    				<html:option value="">&nbsp;</html:option>
    				<july:options collection="<%= categ %>" property="resource" labelProperty="model" addProperty="countpolicy"/>
    			</july:select>

				<SCRIPT language="JScript">
				function open_window<%=i%>() {
					myWindow = window.open("/dict/ShowInvResourceListWN.do?category=<%=idc%>", "newWindow", "top=40, left=100, width=830, height=630, scrollbars=yes, resizable=yes");  
					myWindow.focus();
				}
				</SCRIPT>				
				
				<A HREF="#" name="lookupbtn_style" onclick="open_window<%=i%>(); return false;"><img name="lookupimg_style" src="/images/lookup.gif" border="0" alt="Справочник"></A>	
        </TD>
        <%
      for(int i2=0; i2 < blabels.length; i2++) {
        String bname = "print" + blabels [i2];
        for(int j2=0; j2 < alabels.length; j2++) {
          String blabname = "" + blabels [i2];
          String alabname = "" + alabels [j2];
          String bserial = "serial" + i + blabname + alabname;
          String bdiv = "div" + i;
          String bqty = "qty" + i + blabname + alabname;
        %>
        <TD class="<%= bname %>" style="margin-top: 0; margin-bottom:0; margin-left: 0; margin-right:0; padding-top: 1; padding-bottom: 1;padding-left: 1; padding-right: 1;" ALIGN=CENTER>
          <SPAN ID="<%= bdiv %>">
    			   <july:string size="15" property="<%= bserial %>"
                style="font-size:8pt; width:64px;"
                styleId="<%= bserial %>" insertable="true" updatable="true" />
          </SPAN>
          <SPAN ID="<%= bdiv %>">
             <july:string property="<%= bqty %>" size="5"
              style="font-size:8pt; width:40px;"
              insertable="true" updatable="true"/>&nbsp;<bean:message key="label.mountact2.qty"/></TD>
          </SPAN>
        </TD>
        <%
        }
      }
        %>
      </TR>
      <SCRIPT>
        <%= bchange %>
      </SCRIPT>
   <%
      }
   %>


      </TABLE>

      <TABLE class="print" style="font-size:8pt;">
      <TR class="print" style="margin-top: 0; margin-bottom:0; padding-top: 1; padding-bottom: 1;">
        <TD width="15%" class="print"><bean:message key="label.mountact2.organization"/></TD>
        <TD width="35%" class="print">
          <DIV><july:errors property="podr" shortformat="true"/></DIV>
    			<html:hidden property="providercode" />
    			<july:lookupbutton action="/ShowOrganizationLookupList.do" styleId="provl"
            fieldNames="providercode;providername" newWindowName="organizationlookup"
            insertable="<%= edit1800 %>" updatable="<%= edit1800 %>" onclick="set_opt_params_provl('?selisprovider=true&selisrenter=false&selissupplier=false');"/>
    			<july:string size="15" property="providername"
            style="font-size:8pt; width:200px;"
            styleId="providername" insertable="false" updatable="false" />
        </TD>
        <TD width="30%" class="print" style="margin-top: 0; margin-bottom:0; padding-top: 0; padding-bottom: 0;">
           <DIV><july:errors property="insman" shortformat="true"/></DIV>
			     <july:string size="15" property="insuranceMan"
              style="font-size:8pt; width:200px;"
              insertable="<%= edit1800 %>" updatable="<%= edit1800 %>" />
        </TD>
        <TD width="20%" class="print">&nbsp;</TD>
      </TR>
      <TR class="print">
        <TD class="print" style="margin-top: 0; margin-bottom:0; padding-top: 0; padding-bottom: 0;"><bean:message key="label.mountact2.customer"/></TD>
        <TD class="print" VALIGN="bottom" style="margin-top: 0; margin-bottom:0; padding-top: 0; padding-bottom: 0;">
    			<july:select collection="owners" property="ownercode"
              style="font-size:8pt;"
              insertable="<%= edit1800 %>" updatable="<%= edit1800 %>">
    				<html:options collection="owners" property="organization" labelProperty="name"/>
    			</july:select>
        </TD>
        <TD class="print" VALIGN="bottom" style="margin-top: 0; margin-bottom:0; padding-top: 0; padding-bottom: 0;">
          <DIV><july:errors property="worker" shortformat="true"/></DIV>
    			<html:hidden property="workercode"/>
    			<july:lookupbutton action="/ShowWorkerLookupList.do" styleId="work1l"
            fieldNames="workercode;workername;workertitle" newWindowName="workerlookup"
            insertable="<%= edit1800 %>" updatable="<%= edit1800 %>" />
    			<july:string size="15" property="workername" styleId="workername"
              style="font-size:8pt; width:200px;"
              insertable="false" updatable="false" />
    			<html:hidden property="workertitle"/>
        </TD>
        <TD class="print" VALIGN="bottom" style="margin-top: 0; margin-bottom:0; padding-top: 0; padding-bottom: 0;">
          <DIV><july:errors property="actdate" shortformat="true"/></DIV>
          <july:date property="actdate" size="25"
              style="font-size:8pt;width: 100;" required="false"
              insertable="<%= edit1800 %>" updatable="<%= edit1800 %>" />
        </TD>
      </TR>
      <TR class="print">
        <TD class="print" style="margin-top: 0; margin-bottom:0; padding-top: 0; padding-bottom: 0;">&nbsp;</TD>
        <TD class="print" style="margin-top: 0; margin-bottom:0; padding-top: 0; padding-bottom: 0;"><bean:message key="label.mountact2.header6"/></TD>
        <TD class="print" style="margin-top: 0; margin-bottom:0; padding-top: 0; padding-bottom: 0;"><bean:message key="label.mountact2.header7"/></TD>
        <TD class="print" style="margin-top: 0; margin-bottom:0; padding-top: 0; padding-bottom: 0;"><bean:message key="label.mountact2.header8"/></TD>
      </TR>
      </TABLE>

<SCRIPT>
  changeDiffs('<july:stringwrite property="diffs"/>');
</SCRIPT>
    </TD></TR>
    
    <july:separator/>
    
	<july:formbuttons>
<%if(showStateLink){%>
	<%if("1".equals(docstate)) {%>
		<input type="image" name="submit" src="/images/calculate.gif" onclick="document.all.action.value='Edit';document.all.processState.value='P';document.all.warnProc.value='false';return checkPosted();" title="Обсчёт">
<%if(com.hps.july.util.AppUtils.isNewInventory()) {%>
<%  if(form2.getWarnProc() != null && form2.getWarnProc().booleanValue()) {%>
		<input type="image" name="submit" src="/images/calculatea.gif" onclick="document.all.action.value='Edit';document.all.processState.value='P';document.all.warnProc.value='true';return checkPosted();" title="Обсчёт с автоматическим исправлением несоответствий">
<%  }%>
<%}%>
	<%} else {
		String actUrl2 = action + "?action=Edit&processState=C&document=" + form2.getDocument();
	%>
		<html:link page="<%= actUrl2 %>" paramScope="request" onclick="return checkPosted();"><img src="/images/calculates.gif" border=0 alt="Снять обсчёт"></html:link>
	<%}%>
<%}%>
	</july:formbuttons>
    
    <july:separator/>
    
</table>

</july:editform>


