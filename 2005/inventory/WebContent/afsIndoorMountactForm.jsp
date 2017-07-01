<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<july:editform action="/ProcessAfsIndoorMountAct.do">

<jsp:useBean id="AfsIndoorMountActForm"
    class="com.hps.july.inventory.formbean.AfsIndoorMountActForm"
    scope="request"/>
  <%
    int antCount = AfsIndoorMountActForm.getAntcount();
    int divCount = AfsIndoorMountActForm.getDivcount();
  %>

    <html:hidden property="document" />
    <html:hidden property="oldposnumber" />
    <html:hidden property="oldeqtype" />
    <html:hidden property="manycomplects" />
    <INPUT TYPE="HIDDEN" NAME="refreshFields" ID="refreshFields" VALUE="0">



      <SCRIPT>
        function changeVis(tarr, aspan, ares) {
          if ( (tarr [ares.value] == 'b') || (tarr [ares.value] == 'B') ) {
            aspan [0].style.cssText = "visibility:hidden; display:none;"
            aspan [1].style.cssText = "visibility:visible; display:inline;"
            aspan [2].style.cssText = "visibility:visible; display:inline;"
          } else if ( (tarr [ares.value] == 'p') || (tarr [ares.value] == 'P') ) {
            aspan [0].style.cssText = "visibility:visible; display:inline;"
            aspan [1].style.cssText = "visibility:hidden; display:none;"
            aspan [2].style.cssText = "visibility:visible; display:inline;"
          } else if ( (tarr [ares.value] == 's') || (tarr [ares.value] == 'S') ) {
            aspan [0].style.cssText = "visibility:visible; display:inline;"
            aspan [1].style.cssText = "visibility:hidden; display:none;"
            aspan [2].style.cssText = "visibility:visible; display:inline;"
          } else {
            aspan [0].style.cssText = "visibility:hidden; display:none;"
            aspan [1].style.cssText = "visibility:hidden; display:none;"
            aspan [2].style.cssText = "visibility:hidden; display:none;"
          }
        }
      </SCRIPT>

<SCRIPT language="javascript">
var curALine = 2;
var curDLine = 2;
var maxALine = <%= antCount %>;
var maxDLine = <%= divCount %>;

function delAntenn() {
	document.all.antenntbl.deleteRow(curALine);
}

function saveAIndex() {
	if (window.event.toElement.parentElement.tagName == 'TR') {
		curALine=window.event.toElement.parentElement.rowIndex;
	}
}

function delDivider() {
	document.all.dividertbl.deleteRow(curDLine);
}

function saveDIndex() {
	if (window.event.toElement.parentElement.tagName == 'TR') {
		curDLine=window.event.toElement.parentElement.rowIndex;
	}
}

function addAntenns() {
	var num = parseInt(document.all.antcnttmp.value);
	if(!isNaN(num)) {
    for (var i=0; i < num; i++)
      addAntenn();
  }
}

function addAntenn() {
		var newRow = document.all.antenntbl.insertRow();
		newRow.className = "print";
		newRow.onmouseover = saveAIndex;
		for (var i=0; i < 6; i++) {
			var newCell = newRow.insertCell();
			newCell.className = "print";
		}
		var antmodval = '';
		for (var i1=0; i1 < document.all.antmodeltmp.options.length; i1++) {
      if (document.all.antmodeltmp.options.item(i1).value == document.all.antmodeltmp.value) {
        antmodval = document.all.antmodeltmp.options.item(i1).text;
        break;
      }
    }
		var antcabval = '';
		for (var i2=0; i2 < document.all.antcabletmp.options.length; i2++) {
      if (document.all.antcabletmp.options.item(i2).value == document.all.antcabletmp.value) {
        antcabval = document.all.antcabletmp.options.item(i2).text;
        break;
      }
    }
		newRow.cells(0).innerHTML = '<INPUT TYPE=HIDDEN NAME="antmodel[' + maxALine + ']" VALUE="' + document.all.antmodeltmp.value + '"><INPUT TYPE=TEXT VALUE="' + antmodval + '" style="font-size:8pt;" class="editsmalldisabled" READONLY>';
		newRow.cells(1).innerHTML = '<INPUT TYPE=TEXT NAME="antserial[' + maxALine + ']" style="font-size:8pt;" class="editsmall">';
		newRow.cells(2).innerHTML = '<INPUT TYPE=HIDDEN NAME="antcable[' + maxALine + ']" VALUE="' + document.all.antcabletmp.value + '"><INPUT TYPE=TEXT VALUE="' + antcabval + '" style="font-size:8pt;" class="editsmalldisabled" READONLY>';
		newRow.cells(3).innerHTML = '<INPUT TYPE=TEXT NAME="antcablen[' + maxALine + ']" style="font-size:8pt;" class="editkod">';
		newRow.cells(4).innerHTML = '<INPUT TYPE=TEXT NAME="antcomment[' + maxALine + ']" style="font-size:8pt;" class="editsmall">';
		newRow.cells(5).innerHTML = '<input type="image" src="/images/del.gif" onclick="delAntenn();" name="delA"/>';
		newRow.onmouseover=saveAIndex;
		maxALine = maxALine + 1;
}

function addDividers() {
	var num = parseInt(document.all.divcnttmp.value);
	if(!isNaN(num)) {
    for (var i=0; i < num; i++)
      addDivider();
  }
}

function addDivider() {
		var newRow = document.all.dividertbl.insertRow();
		newRow.className = "print";
		newRow.onmouseover = saveDIndex;
		for (var i=0; i < 6; i++) {
			var newCell = newRow.insertCell();
			newCell.className = "print";
		}
		var divmodval = '';
		for (var i1=0; i1 < document.all.divmodeltmp.options.length; i1++) {
      if (document.all.divmodeltmp.options.item(i1).value == document.all.divmodeltmp.value) {
        divmodval = document.all.divmodeltmp.options.item(i1).text;
        break;
      }
    }
		var divcabval = '';
		for (var i2=0; i2 < document.all.divcabletmp.options.length; i2++) {
      if (document.all.divcabletmp.options.item(i2).value == document.all.divcabletmp.value) {
        divcabval = document.all.divcabletmp.options.item(i2).text;
        break;
      }
    }
		newRow.cells(0).innerHTML = '<INPUT TYPE=HIDDEN NAME="divmodel[' + maxDLine + ']" VALUE="' + document.all.divmodeltmp.value + '"><INPUT TYPE=TEXT VALUE="' + divmodval + '" style="font-size:8pt;" class="editsmalldisabled" READONLY>';
		newRow.cells(1).innerHTML = '<INPUT TYPE=TEXT NAME="divserial[' + maxDLine + ']" style="font-size:8pt;" class="editsmall">';
		newRow.cells(2).innerHTML = '<INPUT TYPE=HIDDEN NAME="divcable[' + maxDLine + ']" VALUE="' + document.all.divcabletmp.value + '"><INPUT TYPE=TEXT VALUE="' + divcabval + '" style="font-size:8pt;" class="editsmalldisabled" READONLY>';
		newRow.cells(3).innerHTML = '<INPUT TYPE=TEXT NAME="divcablen[' + maxDLine + ']" style="font-size:8pt;" class="editkod">';
		newRow.cells(4).innerHTML = '<INPUT TYPE=TEXT NAME="divcomment[' + maxDLine + ']" style="font-size:8pt;" class="editsmall">';
		newRow.cells(5).innerHTML = '<input type="image" src="/images/del.gif" onclick="delDivider();" name="delD"/>';
		newRow.onmouseover=saveDIndex;
		maxDLine = maxDLine + 1;
}

function showHideRepiter(atype) {
  if (atype == 'A') {
    document.all.repitertable.style.visibility = 'hidden';
    document.all.repitertable.style.display='none';
    document.all.sectordiv.style.visibility = 'visible';
  } else {
    document.all.repitertable.style.visibility = 'visible';
    document.all.repitertable.style.display='block';
    document.all.sectordiv.style.visibility = 'hidden';
  }
}

</SCRIPT>


<table class="main">

    <july:separator/>
    
	<july:formbuttons/>
    
    <july:separator/>

    <tr>
        <td class="title" colspan="2"><july:actionalert/></td>
    </tr>

    <july:separator/>
    
    <TR><TD class="text" colspan="2">
    
      <TABLE class="print" style="font-size:8pt;">
      <TR class="print">
        <TD COLSPAN=4>
          <DIV><july:errors property="head" shortformat="true"/></DIV>
        </TD>
      </TR>
      <TR class="print">
        <TD>
          <bean:message key="label.afsindoormountact.title"/> на
        </TD>
        <TD>
          <logic:equal name="AfsIndoorMountActForm" property="enableclosefkbs" value="false">	
          <july:radio property="eqtype" value="A"
            style="width: 30px;"
            onclick="showHideRepiter('A');"
            insertable="true" updatable="false"><bean:message key="label.afsindoormountact.eqtype.A"/></july:radio>
          </logic:equal>
          <july:radio property="eqtype" value="B"
            style="width: 30px;"
            onclick="showHideRepiter('B');"
            insertable="true" updatable="false"><bean:message key="label.afsindoormountact.eqtype.B"/></july:radio>
        </TD>
        <TD NOWRAP>
          <july:string property="posnumber" style="font-size:8pt;"
              size="5" insertable="true" updatable="true"/>
          <logic:equal name="AfsIndoorMountActForm" property="manycomplects" value="true">
      			<july:select collection="complects" property="complectcode"
                style="font-size:8pt;"
                insertable="true" updatable="true">
      				<html:option value="">&nbsp;</html:option>
      				<july:options collection="complects" property="equipment" labelProperty="name"/>
      			</july:select>
          </logic:equal>
          <logic:equal name="AfsIndoorMountActForm" property="manycomplects" value="false">
      			<html:hidden property="complectcode"/>
      			<july:string size="25"
              style="font-size:8pt;"
              property="complectname" styleId="complectname" insertable="false" updatable="false" />
          </logic:equal>
          <A HREF="#" onclick="return false;">
          <IMG SRC="/images/dictrefrsh.gif" BORDER=0
            onclick="document.all.refreshFields.value=1; document.forms(0).submit();"
            alt="Обновить данные справочников"></A>
        </TD>
        <TD ALIGN="RIGHT">
          <DIV ID="sectordiv">
          <bean:message key="label.afsindoormountact.sector"/>
           <july:select property="sector"
                style="font-size:8pt; width: 100px;"
                insertable="true" updatable="false">
            <html:option value="A">A</html:option>
            <html:option value="B">B</html:option>
            <html:option value="C">C</html:option>
            <html:option value="D">D</html:option>
            <html:option value="E">E</html:option>
            <html:option value="F">F</html:option>
            <html:option value="G">G</html:option>
            <html:option value="H">H</html:option>
            <html:option value="O">O/O1800</html:option>
           </july:select>
           </DIV>
        </TD>
      </TR>
      <TR class="print">
        <TD>
          <bean:message key="label.mountact2.project"/>
        </TD>
        <TD COLSPAN="3">
		  <html:hidden property="projectid"/>
		  <july:string size="35" style="font-size:8pt;" 
		  	property="projectname" insertable="false" updatable="false"/>
        </TD>
      </TR>

      </TABLE>

      <TABLE class="print" style="font-size:8pt;">
      <TR class="print" style="margin-top: 0; margin-bottom:0; padding-top: 1; padding-bottom: 1;">
        <TD width="20%" class="print"><bean:message key="label.mountact2.organization"/></TD>
        <TD width="35%" class="print">
          <DIV><july:errors property="podr" shortformat="true"/></DIV>
    			<html:hidden property="providercode" />
    			<july:lookupbutton action="/ShowOrganizationLookupList.do" styleId="provl" fieldNames="providercode;providername" newWindowName="organizationlookup"  insertable="true" updatable="true" onclick="set_opt_params_provl('?selisprovider=true&selisrenter=false&selissupplier=false');"/>
    			<july:string size="15" property="providername"
            style="font-size:8pt; width:200px;"
            styleId="providername" insertable="false" updatable="false" />
        </TD>
        <TD width="35%" class="print" style="margin-top: 0; margin-bottom:0; padding-top: 0; padding-bottom: 0;">
           <DIV><july:errors property="insman" shortformat="true"/></DIV>
			     <july:string size="15" property="insuranceMan"
              style="font-size:8pt; width:200px;"
              insertable="true" updatable="true" />
        </TD>
        <TD width="10%" class="print">&nbsp;</TD>
      </TR>
      <TR class="print">
        <TD class="print" style="margin-top: 0; margin-bottom:0; padding-top: 0; padding-bottom: 0;"><bean:message key="label.mountact2.customer"/></TD>
        <TD class="print" VALIGN="bottom" style="margin-top: 0; margin-bottom:0; padding-top: 0; padding-bottom: 0;">
    			<july:select collection="owners" property="ownercode"
              style="font-size:8pt;"
              insertable="true" updatable="true">
    				<html:options collection="owners" property="organization" labelProperty="name"/>
    			</july:select>
        </TD>
        <TD class="print" VALIGN="bottom" style="margin-top: 0; margin-bottom:0; padding-top: 0; padding-bottom: 0;">
          <DIV><july:errors property="worker" shortformat="true"/></DIV>
    			<html:hidden property="workercode"/>
    			<july:lookupbutton action="/ShowWorkerLookupList.do" styleId="work1l" fieldNames="workercode;workername;workertitle" newWindowName="workerlookup"  insertable="true" updatable="true" />
    			<july:string size="15" property="workername" styleId="workername"
              style="font-size:8pt; width:200px;"
              insertable="false" updatable="false" />
    			<html:hidden property="workertitle"/>
        </TD>
        <TD class="print" VALIGN="bottom" style="margin-top: 0; margin-bottom:0; padding-top: 0; padding-bottom: 0;">
          <july:date property="actdate" size="25"
              style="font-size:8pt;" required="false"
              insertable="true" updatable="true" />
        </TD>
      </TR>
      <TR class="print">
        <TD class="print" style="margin-top: 0; margin-bottom:0; padding-top: 0; padding-bottom: 0;">&nbsp;</TD>
        <TD class="print" style="margin-top: 0; margin-bottom:0; padding-top: 0; padding-bottom: 0;"><bean:message key="label.mountact2.header6"/></TD>
        <TD class="print" style="margin-top: 0; margin-bottom:0; padding-top: 0; padding-bottom: 0;"><bean:message key="label.mountact2.header7"/></TD>
        <TD class="print" style="margin-top: 0; margin-bottom:0; padding-top: 0; padding-bottom: 0;"><bean:message key="label.mountact2.header8"/></TD>
      </TR>
      </TABLE>
      
      <TABLE class="print" ID="repitertable" style="font-size:8pt;">
      <TR class="print" style="margin-top: 0; margin-bottom:0; padding-top: 1; padding-bottom: 1;">
        <TD ROWSPAN=3 class="print"><B><bean:message key="label.afsindoormountact.repiter"/></B></TD>
        <TD class="print"><bean:message key="label.afsindoormountact.model"/></TD>
        <TD class="print"><bean:message key="label.afsindoormountact.serial"/></TD>
        <TD class="print"><bean:message key="label.afsindoormountact.notes"/></TD>
      </TR>
      <% for (int i1=0; i1 < 2; i1++) { %>
      <TR class="print" style="margin-top: 0; margin-bottom:0; padding-top: 1; padding-bottom: 1;">
        <TD class="print">
    			<july:select collection="repiterModels" property='<%= "repmodel[" + i1 + "]" %>'
              style="font-size:8pt;"
              insertable="true" updatable="true">
            <html:option value="">&nbsp;</html:option>
    				<july:options collection="repiterModels" property="resource" labelProperty="model"/>
    			</july:select>

				<SCRIPT language="JScript">
				function open_window_repeater() {
					myWindow = window.open("/dict/ShowInvResourceListWN.do?category=39", "newWindow", "top=40, left=100, width=830, height=630, scrollbars=yes, resizable=yes");  
					myWindow.focus();
				}
				</SCRIPT>				
				
				<A HREF="#" name="lookupbtn_style" onclick="open_window_repeater(); return false;"><img name="lookupimg_style" src="/images/lookup.gif" border="0" alt="Справочник"></A>	

        </TD>
        <TD class="print"><july:string property='<%= "repserial[" + i1 + "]" %>' size="10"
            style="font-size:8pt;"
            insertable="true" updatable="true"/></TD>
        <TD class="print"><july:string property='<%= "repcomment[" + i1 + "]" %>' size="25"
            style="font-size:8pt;"
            insertable="true" updatable="true"/></TD>
      </TR>
      <% } %>
      </TABLE>

      <TABLE class="print" style="font-size:8pt;">
      <TR class="print" style="margin-top: 0; margin-bottom:0; padding-top: 1; padding-bottom: 1;">
        <TD class="print"><B><bean:message key="label.afsindoormountact.antennes"/></B>
          &nbsp;
          <bean:message key="label.afsindoormountact.model"/>
    			<july:select collection="antennaModels" property="antmodeltmp"
              style="font-size:8pt; width:200px;"
              insertable="true" updatable="true">
    				<july:options collection="antennaModels" property="resource" labelProperty="model"/>
    			</july:select>

				<SCRIPT language="JScript">
				function open_window_antenna() {
					myWindow = window.open("/dict/ShowInvResourceListWN.do?category=40", "newWindow", "top=40, left=100, width=830, height=630, scrollbars=yes, resizable=yes");  
					myWindow.focus();
				}
				</SCRIPT>				
				
				<A HREF="#" name="lookupbtn_style" onclick="open_window_antenna(); return false;"><img name="lookupimg_style" src="/images/lookup.gif" border="0" alt="Справочник"></A>

          &nbsp;
    			<bean:message key="label.afsindoormountact.cable"/>
    			<july:select collection="cableModels" property="antcabletmp"
              style="font-size:8pt; width:200px;"
              insertable="true" updatable="true">
    				<july:options collection="cableModels" property="resource" labelProperty="model"/>
    			</july:select>

				<SCRIPT language="JScript">
				function open_window_cable1() {
					myWindow = window.open("/dict/ShowInvResourceListWN.do?category=42", "newWindow", "top=40, left=100, width=830, height=630, scrollbars=yes, resizable=yes");  
					myWindow.focus();
				}
				</SCRIPT>				
				
				<A HREF="#" name="lookupbtn_style" onclick="open_window_cable1(); return false;"><img name="lookupimg_style" src="/images/lookup.gif" border="0" alt="Справочник"></A>

          &nbsp;
    			<bean:message key="label.afsindoormountact.count"/>
          <july:string property="antcnttmp"
            size="5"
            style="font-size:8pt;"
            insertable="true" updatable="true"/>
          <IMG SRC="/images/plus.gif" onclick="addAntenns();" BORDER=0>
        </TD>
      </TR>
      <TR class="print" style="margin-top: 0; margin-bottom:0; padding-top: 0; padding-bottom: 0;">
      <TD class="print" style="margin-top: 0; margin-bottom:0; margin-left: 0; margin-right:0; padding-left: 0; padding-right: 0; padding-top: 0; padding-bottom: 0;">
    		<table width="100%" class="print"
          style="font-size:8pt;border-width: 0;"
          id="antenntbl">
    		<tr class="title">
          <TR class="print" style="margin-top: 0; margin-bottom:0; padding-top: 1; padding-bottom: 1;">
            <TD class="print"><bean:message key="label.afsindoormountact.model"/></TD>
            <TD class="print"><bean:message key="label.afsindoormountact.serial"/></TD>
            <TD class="print"><bean:message key="label.afsindoormountact.cable"/></TD>
            <TD class="print"><bean:message key="label.afsindoormountact.length"/></TD>
            <TD class="print"><bean:message key="label.afsindoormountact.notes"/></TD>
            <TD class="print">&nbsp;</TD>
          </TR>
          <% for (int i2=0; i2 < antCount; i2++) { %>
          <TR class="print"
              onMouseOver="saveAIndex();"
              style="margin-top: 0; margin-bottom:0; padding-top: 1; padding-bottom: 1;">
            <TD class="print">
        			<july:select collection="antennaModels" property='<%= "antmodel[" + i2 + "]" %>'
                  style="font-size:8pt; width:150px;"
                  insertable="true" updatable="true">
        				<july:options collection="antennaModels" property="resource" labelProperty="model"/>
        			</july:select>
            </TD>

            <TD class="print"><july:string property='<%= "antserial[" + i2 + "]" %>' size="10"
                style="font-size:8pt;"
                insertable="true" updatable="true"/></TD>
            <TD class="print">
        			<july:select collection="cableModels" property='<%= "antcable[" + i2 + "]" %>'
                  style="font-size:8pt; width:150px;"
                  insertable="true" updatable="true">
        				<july:options collection="cableModels" property="resource" labelProperty="model"/>
        			</july:select>
            </TD>
            <TD class="print"><july:string property='<%= "antcablen[" + i2 + "]" %>' size="5"
                style="font-size:8pt;"
                insertable="true" updatable="true"/></TD>
            <TD class="print"><july:string property='<%= "antcomment[" + i2 + "]" %>' size="10"
                style="font-size:8pt;"
                insertable="true" updatable="true"/></TD>
            <TD class="print"><IMG SRC="/images/del.gif" onclick="delAntenn();" BORDER=0></TD>
          </TR>
          <% } %>
          </TABLE>
      </TD></TR>
      </TABLE>

      <TABLE class="print" style="font-size:8pt;">
      <TR class="print" style="margin-top: 0; margin-bottom:0; padding-top: 1; padding-bottom: 1;">
        <TD class="print"><B><bean:message key="label.afsindoormountact.dividers"/></B>
          &nbsp;
          <bean:message key="label.afsindoormountact.model"/>
    			<july:select collection="dividerModels" property="divmodeltmp"
              style="font-size:8pt; width:200px;"
              insertable="true" updatable="true">
    				<july:options collection="dividerModels" property="resource" labelProperty="model"/>
    			</july:select>

				<SCRIPT language="JScript">
				function open_window_divider() {
					myWindow = window.open("/dict/ShowInvResourceListWN.do?category=41", "newWindow", "top=40, left=100, width=830, height=630, scrollbars=yes, resizable=yes");  
					myWindow.focus();
				}
				</SCRIPT>				
				
				<A HREF="#" name="lookupbtn_style" onclick="open_window_divider(); return false;"><img name="lookupimg_style" src="/images/lookup.gif" border="0" alt="Справочник"></A>

          &nbsp;
    			<bean:message key="label.afsindoormountact.cable"/>
    			<july:select collection="cableModels" property="divcabletmp"
              style="font-size:8pt; width:200px;"
              insertable="true" updatable="true">
    				<july:options collection="cableModels" property="resource" labelProperty="model"/>
    			</july:select>

				<SCRIPT language="JScript">
				function open_window_cable2() {
					myWindow = window.open("/dict/ShowInvResourceListWN.do?category=42", "newWindow", "top=40, left=100, width=830, height=630, scrollbars=yes, resizable=yes");  
					myWindow.focus();
				}
				</SCRIPT>				
				
				<A HREF="#" name="lookupbtn_style" onclick="open_window_cable2(); return false;"><img name="lookupimg_style" src="/images/lookup.gif" border="0" alt="Справочник"></A>

          &nbsp;
    			<bean:message key="label.afsindoormountact.count"/>
          <july:string property="divcnttmp"
            size="5"
            style="font-size:8pt;"
            insertable="true" updatable="true"/>
          <IMG SRC="/images/plus.gif" onclick="addDividers();" BORDER=0>
        </TD>
      </TR>
      <TR class="print" style="margin-top: 0; margin-bottom:0; padding-top: 0; padding-bottom: 0;">
      <TD class="print" style="margin-top: 0; margin-bottom:0; margin-left: 0; margin-right:0; padding-left: 0; padding-right: 0; padding-top: 0; padding-bottom: 0;">
    		<table width="100%" class="print"
          style="font-size:8pt;border-width: 0;"
          id="dividertbl">
            <TR class="print" style="margin-top: 0; margin-bottom:0; padding-top: 1; padding-bottom: 1;">
              <TD class="print"><bean:message key="label.afsindoormountact.model"/></TD>
              <TD class="print"><bean:message key="label.afsindoormountact.serial"/></TD>
              <TD class="print"><bean:message key="label.afsindoormountact.cable"/></TD>
              <TD class="print"><bean:message key="label.afsindoormountact.length"/></TD>
              <TD class="print"><bean:message key="label.afsindoormountact.notes"/></TD>
              <TD class="print">&nbsp;</TD>
            </TR>
            <% for (int i3=0; i3 < divCount; i3++) { %>
            <TR class="print" onMouseOver="saveDIndex();"
                style="margin-top: 0; margin-bottom:0; padding-top: 1; padding-bottom: 1;">
              <TD class="print">
          			<july:select collection="dividerModels" property='<%= "divmodel[" + i3 + "]" %>'
                    style="font-size:8pt; width:150px;"
                    insertable="true" updatable="true">
          				<july:options collection="dividerModels" property="resource" labelProperty="model"/>
          			</july:select>
              </TD>

              <TD class="print"><july:string property='<%= "divserial[" + i3 + "]" %>' size="10"
                  style="font-size:8pt;"
                  insertable="true" updatable="true"/></TD>
              <TD class="print">
          			<july:select collection="cableModels" property='<%= "divcable[" + i3 + "]" %>'
                    style="font-size:8pt; width:150px;"
                    insertable="true" updatable="true">
          				<july:options collection="cableModels" property="resource" labelProperty="model"/>
          			</july:select>
              </TD>
              <TD class="print"><july:string property='<%= "divcablen[" + i3 + "]" %>' size="5"
                  style="font-size:8pt;"
                  insertable="true" updatable="true"/></TD>
              <TD class="print"><july:string property='<%= "divcomment[" + i3 + "]" %>' size="10"
                  style="font-size:8pt;"
                  insertable="true" updatable="true"/></TD>
              <TD class="print"><IMG SRC="/images/del.gif" onclick="delDivider();" BORDER=0></TD>
            </TR>
            <% } %>
          </TABLE>
      </TD></TR>
      </TABLE>

    </TD></TR>
    
    <july:separator/>
    
    <july:formbuttons/>
    
    <july:separator/>
    
</table>

</july:editform>

<SCRIPT language="JavaScript">
	if (document.all.eqtype[0]!=null)
		if (document.all.eqtype[0].checked)
			showHideRepiter('A');
		else
			showHideRepiter('B');
	else 
		showHideRepiter('B');
</SCRIPT>
