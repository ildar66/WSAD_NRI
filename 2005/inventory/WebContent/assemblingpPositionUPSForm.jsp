<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import="com.hps.july.inventory.formbean.*,com.hps.july.inventory.actionbean.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<july:editform action="/ProcessAssemblingPUPS.do">
<%
	boolean readonly = true;
	AssemblingPForm frm = (AssemblingPForm)request.getSession().getAttribute("AssemblingPForm");
	if("1".equals(frm.getDState()) && !frm.getIsautodoc()) {
		readonly = false;
	}
	AssemblingPUPSForm aform = (AssemblingPUPSForm)request.getAttribute("AssemblingPUPSForm");
	if("View".equals(aform.getAction()) || "Delete".equals(aform.getAction())) {
		readonly |= true;
	}

	int bsCount = aform.getBSCount();
    int acCount = aform.getACCount();
	


%>

<script language="javascript">

var curBLine = 2;
var maxBLine = <%= bsCount %>;

var curALine = 2;
var maxALine = <%= acCount %>;

function changeVis(tarr, aspan, ares) {
	if ( (tarr [ares.value] == 'b') || (tarr [ares.value] == 'B') ) {
		aspan [0].style.cssText = "visibility:hidden; display:none;";
		aspan [1].style.cssText = "visibility:visible; display:inline;";
		if(aspan [2]) { aspan [2].style.cssText = "visibility:visible; display:inline;"; }
	} else if ( (tarr [ares.value] == 'p') || (tarr [ares.value] == 'P') ) {
		aspan [0].style.cssText = "visibility:visible; display:inline;";
		aspan [1].style.cssText = "visibility:hidden; display:none;";
		if(aspan [2]) { aspan [2].style.cssText = "visibility:visible; display:inline;"; }
	} else if ( (tarr [ares.value] == 's') || (tarr [ares.value] == 'S') ) {
		aspan [0].style.cssText = "visibility:visible; display:inline;";
		aspan [1].style.cssText = "visibility:hidden; display:none;";
		if(aspan [2]) { aspan [2].style.cssText = "visibility:visible; display:inline;"; }
	} else {
		aspan [0].style.cssText = "visibility:hidden; display:none;";
		aspan [1].style.cssText = "visibility:hidden; display:none;"; 
		if(aspan [2]) { aspan [2].style.cssText = "visibility:hidden; display:none;"; }
	}
}
function switchLookup(itemname,lookupname,disabled) {
	var dall = document.all;
	if(disabled) {
		dall[itemname].className = 'editdisabled';
		dall[itemname].disabled = true;
		dall[itemname].readonly = true;
		dall['lookupbtn_'+lookupname+'l'].disabled = true;
		dall['lookupimg_'+lookupname+'l'].src='/images/lookup_disabled.gif';
		dall['lookupbtn_'+lookupname+'l'].style.cursor = 'default';
/*		dall['lookupimg_'+lookupname+'l'].style.cursor = 'default';*/
	} else {
		dall[itemname].className = 'edit';
		dall[itemname].disabled = false;
		dall[itemname].readonly = false;
		dall['lookupbtn_'+lookupname+'l'].disabled = false;
		dall['lookupimg_'+lookupname+'l'].src='/images/lookup.gif';
		dall['lookupbtn_'+lookupname+'l'].style.cursor = 'hand';
/*		dall['lookupimg_'+lookupname+'l'].style.cursor = 'hand';*/
	}
}
function changeUPS() {
}
function changeBIS(index) {
	changeVis(BIS1ResourcesList_arr, document.all["bissp"+index], document.all["bis["+index+"].type"]);
}

function changeACC(index) {
	changeVis(ACCResourcesList_arr, document.all["accsp"+index], document.all["acc["+index+"].type"]);
}

function delBS() {
	document.all.bstable.deleteRow(curBLine);
}

function delAC() {
	document.all.actable.deleteRow(curALine);
}

function saveBIndex() {
	if (window.event.toElement.parentElement.tagName == 'TR') {
		curBLine=window.event.toElement.parentElement.rowIndex;
	}
}

function saveAIndex() {
	if (window.event.toElement.parentElement.tagName == 'TR') {
		curALine=window.event.toElement.parentElement.rowIndex;
	}
}

function addBSS() {
	var num = parseInt(document.all.bscnttmp.value);
	if(!isNaN(num)) {
    for (var i=0; i < num; i++)
      addBS();
	}
}

function addACC() {
	var num = parseInt(document.all.accnttmp.value);
	if(!isNaN(num)) {
    for (var i=0; i < num; i++)
      addAC();
	}
}

function addBS() {

		var newRow = document.all.bstable.insertRow();
		newRow.className = "print";
		newRow.onmouseover = saveBIndex;
		for (var i=0; i < 6; i++) {
			var newCell = newRow.insertCell();
			newCell.className = "print";
		}
		var bsmodval = '';
		for (var i1=0; i1 < document.all.bstypetmp.options.length; i1++) {
		  if (document.all.bstypetmp.options.item(i1).value == document.all.bstypetmp.value) {
			bsmodval = document.all.bstypetmp.options.item(i1).text;
			break;
		  }
		}
		
		newRow.cells(0).innerHTML = maxBLine+1;

		newRow.cells(1).innerHTML = '<INPUT TYPE=HIDDEN NAME="bis[' + maxBLine + '].type" VALUE="' + document.all.bstypetmp.value + '"><INPUT TYPE=TEXT VALUE="' + bsmodval + '" style="font-size:8pt; FONT-FAMILY: Verdana,Arial; WIDTH: 180pt; background-color: DCDCDC;" READONLY>';
				
		var t = document.all["bis["+maxBLine+"].type"];
		
		if ( (BIS1ResourcesList_arr[t.value] == 'b') || (BIS1ResourcesList_arr[t.value] == 'B') ) {

			newRow.cells(2).innerHTML = '&nbsp;';
			newRow.cells(3).innerHTML = '<INPUT TYPE=TEXT NAME="bis[' + maxBLine + '].count.string" size="9" style="font-size:8pt; FONT-FAMILY: Verdana,Arial; background-color: D6EBFF;"> шт.';

		} else if ( (BIS1ResourcesList_arr[t.value] == 'p') || (BIS1ResourcesList_arr[t.value] == 'P') ) {

			newRow.cells(2).innerHTML = '<INPUT TYPE=TEXT NAME="bis[' + maxBLine + '].sn" size="20" style="font-size:8pt; FONT-FAMILY: Verdana,Arial; background-color: D6EBFF;">';
			newRow.cells(3).innerHTML = '&nbsp;';

		} else if ( (BIS1ResourcesList_arr[t.value] == 's') || (BIS1ResourcesList_arr[t.value] == 'S') ) {

			newRow.cells(2).innerHTML = '<INPUT TYPE=TEXT NAME="bis[' + maxBLine + '].sn" size="20" style="font-size:8pt; FONT-FAMILY: Verdana,Arial; background-color: D6EBFF;">';
			newRow.cells(3).innerHTML = '&nbsp;';

		} else {
			newRow.cells(2).innerHTML = '&nbsp;';
			newRow.cells(3).innerHTML = '&nbsp;';
		}		

		newRow.cells(4).innerHTML = '<INPUT TYPE=TEXT NAME="bis[' + maxBLine + '].note" size="15" style="font-size:8pt;" class="edit">';

		newRow.cells(5).innerHTML = '<input type="image" src="/images/del.gif" onclick="delBS();return false;" name="delB"/>';

		newRow.onmouseover=saveBIndex;		
		maxBLine = maxBLine + 1;

}

function addAC() {

		var newRow = document.all.actable.insertRow();
		newRow.className = "print";
		newRow.onmouseover = saveAIndex;
		for (var i=0; i < 5; i++) {
			var newCell = newRow.insertCell();
			newCell.className = "print";
		}
		var acmodval = '';
		for (var i1=0; i1 < document.all.actypetmp.options.length; i1++) {
		  if (document.all.actypetmp.options.item(i1).value == document.all.actypetmp.value) {
			acmodval = document.all.actypetmp.options.item(i1).text;
			break;
		  }
		}
		
		newRow.cells(0).innerHTML = maxALine+1;

		newRow.cells(1).innerHTML = '<INPUT TYPE=HIDDEN NAME="acc[' + maxALine + '].type" VALUE="' + document.all.actypetmp.value + '"><INPUT TYPE=TEXT VALUE="' + acmodval + '" style="font-size:8pt; FONT-FAMILY: Verdana,Arial; WIDTH: 180pt; background-color: DCDCDC;" READONLY>';
				
		var t = document.all["acc["+maxALine+"].type"];
		
		if ( (ACCResourcesList_arr[t.value] == 'b') || (ACCResourcesList_arr[t.value] == 'B') ) {

			newRow.cells(2).innerHTML = '&nbsp;';
			newRow.cells(3).innerHTML = '<INPUT TYPE=TEXT NAME="acc[' + maxALine + '].count.string" size="9" style="font-size:8pt; FONT-FAMILY: Verdana,Arial; background-color: D6EBFF;"> шт.';

		} else if ( (ACCResourcesList_arr[t.value] == 'p') || (ACCResourcesList_arr[t.value] == 'P') ) {

			newRow.cells(2).innerHTML = '<INPUT TYPE=TEXT NAME="acc[' + maxALine + '].sn" size="20" style="font-size:8pt; FONT-FAMILY: Verdana,Arial; background-color: D6EBFF;">';
			newRow.cells(3).innerHTML = '&nbsp;';

		} else if ( (ACCResourcesList_arr[t.value] == 's') || (ACCResourcesList_arr[t.value] == 'S') ) {

			newRow.cells(2).innerHTML = '<INPUT TYPE=TEXT NAME="acc[' + maxALine + '].sn" size="20" style="font-size:8pt; FONT-FAMILY: Verdana,Arial; background-color: D6EBFF;">';
			newRow.cells(3).innerHTML = '&nbsp;';

		} else {
			newRow.cells(2).innerHTML = '&nbsp;';
			newRow.cells(3).innerHTML = '&nbsp;';
		}

		newRow.cells(4).innerHTML = '<input type="image" src="/images/del.gif" onclick="delAC();return false;" name="delA"/>';

		newRow.onmouseover=saveAIndex;		
		maxALine = maxALine + 1;

}

</script>




<html:hidden property="docFrm" />
<html:hidden property="docpos" />
<html:hidden property="positioncode" />
<html:hidden property="complectcode" />
<html:hidden property="expedition" />
<html:hidden property="ownercode" />

<html:hidden name="AssemblingPForm" property="doc"/>

<input type="hidden" name="_dummy_" value="">

<table class="main">
    
<july:separator colspan="4"/>
 
<tr><td style="padding:0px;" colspan="4">
<table cellpadding="0" cellspacing="0" width="100%" border="0"><tr><td style="padding:0px;"><july:formbuttons/></td></tr></table>
</td></tr>
<july:separator colspan="4"/>

<tr>
	<td class="title" colspan="4"><july:actionalert/></td>
</tr>

<july:separator colspan="4"/>
  
	



<tr>
<td>

<table class="main">

<tr>
	<td class="title"><bean:message key="label.assemblingp.document"/>:</td>
	<td class="title" colspan="3"><bean:message key="label.num"/>&nbsp;<bean:write name="AssemblingPForm" property="blankindex"/>&nbsp;<bean:write name="AssemblingPForm" property="blanknumber"/>&nbsp;<bean:message key="label.from" />&nbsp;<bean:write name="AssemblingPForm" property="blankdatestr"/></td>
</tr>

<july:separator colspan="4"/>
    
<tr>
	<td class="title"><bean:message key="label.assemblingp.position"/>:</td>
	<td class="title" colspan="3">
		<bean:write name="AssemblingPForm" property="positionid"/>
		<bean:write name="AssemblingPForm" property="positionname"/>
	</td>
</tr>

<july:separator colspan="4"/>

<tr>
	<td class="title"><bean:message key="label.assemblingp.complect"/>:</td>
	<td class="title" colspan="3"><bean:write name="AssemblingPForm" property="complectname"/></td>
</tr>

<%if(frm.getType() != null) {%>
<%if("P".equals(frm.getType())) {%>
<july:separator colspan="4"/>

<tr>
	<td class="title"><bean:message key="label.assemblingp.provider"/>:</td>
	<td class="title" colspan="3">
		<bean:write name="AssemblingPForm" property="providername"/>
	</td>
</tr>
<july:separator colspan="4"/>
<tr>
	<td class="title"><bean:message key="label.assemblingp.insuranceman"/>:</td>
	<td class="title" colspan="3">
		<bean:write name="AssemblingPForm" property="insuranseMan"/>
	</td>
</tr>
<%}%>
<%if("W".equals(frm.getType())) {%>
<july:separator colspan="4"/>
<tr>
	<td class="title"><bean:message key="label.assemblingp.worker"/>:</td>
	<td class="title" colspan="3">
		<bean:write name="AssemblingPForm" property="workername"/>
	</td>
</tr>
<%}%>
<%}%>

<july:separator colspan="4"/>
<tr>
	<td class="text"><july:reqmark><bean:message key="label.assemblingp.numpp"/>:</july:reqmark></td>
	<td colspan="3">
		<july:string property="orderstr" size="10" insertable="true" updatable="true" />
	</td>
</tr>
<july:separator colspan="4"/>

</table>

</td>
</tr>


<tr>
<td>
<table class="print" style="font-size:8pt;">

<tr class="print">
<td class="print" colspan="3">
<B>ИБП</B>
</td>
</tr>

<tr class="print">
<td class="print">
Модель
</td>
<td class="print">
Серийный №
</td>
<td class="print">
Примечание
</td>
</tr>

<tr class="print">	
	<td class="print">
    			<july:select collection="UPSResourcesList" property="upstype" onchange="changeUPS();" insertable="true" updatable="true">
    				<html:option value="">&nbsp;</html:option>
    				<july:options collection="UPSResourcesList" property="resource" labelProperty="model" addProperty="countpolicy"/>
    			</july:select>
	</td>
	<td class="print">
		С/Н:&nbsp;<july:string property="upsserial" size="10" insertable="true" updatable="true" />
	</td>
	<td class="print">
		<july:string property="upsnote" size="15" insertable="true" updatable="true" />
	</td>
</tr>

</table>
</td>
</tr>


<tr>
<td>
<table class="print" style="font-size:8pt;" id="bstable">

<tr class="print">
<td class="print" colspan="6">

<B>БИС</B>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Модель:

		<july:select collection="BIS1ResourcesList" property="bstypetmp" insertable="true" updatable="true">
    			<july:options collection="BIS1ResourcesList" property="resource" labelProperty="model" addProperty="countpolicy"/>
		</july:select>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		Кол-во:
		<july:string property="bscnttmp"
            size="5"
            style="font-size:8pt;"
            insertable="true" updatable="true"/>

        <IMG SRC="/images/plus.gif" onclick="addBSS();" BORDER=0>


</td>
</tr>

<tr class="print">
<td class="print">
№
</td>
<td class="print">
Модель
</td>
<td class="print">
Серийный №
</td>
<td class="print">
Кол-во
</td>
<td class="print">
Примечание
</td>
<td class="print">
&nbsp;
</td>
</tr>

<% for (int i2=0; i2 < bsCount; i2++) { %>

<tr>
	<td class="print"><%=i2+1%></td>
	<td class="print">
		<july:select collection="BIS1ResourcesList" property='<%= "bis["+i2+"].type"%>' onchange='<%= "changeBIS("+i2+");"%>' insertable="true" updatable="true" style="font-size:8pt;">
    			<html:option value="-1">&nbsp;</html:option>
    			<july:options collection="BIS1ResourcesList" property="resource" labelProperty="model" addProperty="countpolicy"/>
		</july:select>
	</td>
	<td class="print">
		<span id="bissp<%=i2%>"><july:string property='<%= "bis["+i2+"].sn"%>' size="10" style="font-size:8pt;" insertable="true" updatable="true" /></span>
	</td>
	<td class="print">
		<span id="bissp<%=i2%>"><july:string property='<%= "bis["+i2+"].count.string"%>' size="5" style="font-size:8pt;" insertable="true" updatable="true" />&nbsp;шт.</span>
	</td>
	<td class="print">
		<span id="bissp<%=i2%>"><july:string property='<%= "bis["+i2+"].note"%>' style="font-size:8pt;" size="15" insertable="true" updatable="true" /></span>
	</td>
	<td class="print">
		<input type="image" src="/images/del.gif" onclick="delBS();return false;" name="delB"/>
	</td>
</tr>


<%}%>


</table>
</td>
</tr>

<tr>
<td>
<table class="print" style="font-size:8pt;"  id="actable">

<tr class="print">
<td class="print" colspan="5">
<B>Аккумуляторы</B>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Модель:

		<july:select collection="ACCResourcesList" property="actypetmp" insertable="true" updatable="true">
    			<july:options collection="ACCResourcesList" property="resource" labelProperty="model" addProperty="countpolicy"/>
		</july:select>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		Кол-во:
		<july:string property="accnttmp"
            size="5"
            style="font-size:8pt;"
            insertable="true" updatable="true"/>

        <IMG SRC="/images/plus.gif" onclick="addACC();return false;" BORDER=0>
</td>
</tr>

<tr class="print">
<td class="print">
№
</td>
<td class="print">
Модель
</td>
<td class="print">
Серийный №
</td>
<td class="print">
Кол-во
</td>
</tr>


<% for (int i3=0; i3 < acCount; i3++) { %>

<tr class="print">
	<td class="print" ><%=i3+1%></td>
	<td class="print" >
    			<july:select collection="ACCResourcesList" property='<%= "acc["+i3+"].type"%>' onchange='<%="changeACC("+i3+");"%>' insertable="true" updatable="true" style="font-size:8pt;">
    				<html:option value="-1">&nbsp;</html:option>
    				<july:options collection="ACCResourcesList" property="resource" labelProperty="model" addProperty="countpolicy"/>
    			</july:select>
	</td>
	<td class="print" >
		<span id="accsp<%=i3%>"><july:string property='<%= "acc["+i3+"].sn"%>' size="10" style="font-size:8pt;" insertable="true" updatable="true" /></span>
	</td>
	<td class="print" >
		<span id="accsp<%=i3%>"><july:string property='<%= "acc["+i3+"].count.string"%>' size="5" style="font-size:8pt;" insertable="true" updatable="true" />&nbsp;шт.</span>
	</td>
	<td class="print">
		<input type="image" src="/images/del.gif" onclick="delAC();return false;" name="delA"/>
	</td>
</tr>

<%}%>

</table>
</td>
</tr>


<html:hidden property="fitplace" value="-"/>

<july:separator colspan="4"/>
<tr><td style="padding:0px;" colspan="4">
<table cellpadding="0" cellspacing="0" width="100%" border="0"><tr><td style="padding:0px;"><july:formbuttons/></td></tr></table>
</td></tr>
<july:separator colspan="4"/>
</table>



<script language="javascript">
changeUPS();

var bc = <%= bsCount %>;
for (var i=0; i < bc; i++){
      changeBIS(i);
}

var ac = <%= acCount %>;
for (var i=0; i < ac; i++){
      changeACC(i);
}
</script>
</july:editform>

