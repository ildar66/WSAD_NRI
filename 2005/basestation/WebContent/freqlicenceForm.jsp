<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld" prefix="alex" %>
<%@ page import="com.hps.july.jdbcpersistence.lib.Checks"%>
<%@ page import="org.apache.struts.util.*"%>
<%@ page import="com.hps.july.basestation.formbean.*"%>
<%@ page import="com.hps.july.web.util.*"%>
<%@ page import="com.hps.july.basestation.*"%>

<july:editform action="/ProcessFrequencyLicence" styleId="FrequencyLicenceForm">
<%boolean editaction = true;%>
<logic:equal name="FrequencyLicenceForm" property="action" value="Delete">
<%editaction = false;%>
</logic:equal>
<script language="javascript">
var curLine = 2;

function delComline() {
	document.all.comlinetbl.deleteRow(curLine);
}

function saveIndex() {
	if (window.event.toElement.parentElement.tagName == 'TR') {
		curLine=window.event.toElement.parentElement.rowIndex; 
	}
}

function addComline() {
	var ra = document.all.comlines;
	var comtbl = document.all.numbersinfile;
	var check = true;
	var numberinf = 1;
	var cellnum;
	if(ra) {
		if(ra.length) {
			for(var i = 0; i < ra.length; i++) {
				if(ra[i].value == document.all.hopsid.value) { check = false; }
			}
		} else {
			if(ra.value == document.all.hopsid.value) { check = false; }
		}
	}

	if(comtbl) {
		if(comtbl.length) {
			for(var i = 0; i < comtbl.length; i++) {
				if(comtbl[i]) {
					cellnum = parseInt(comtbl[i].value);
					if(!isNaN(cellnum)) { numberinf = Math.max(numberinf,cellnum+1); }
				}
			}
		} else {
			cellnum = parseInt(comtbl.value);
			if(!isNaN(cellnum)) { numberinf = Math.max(numberinf,cellnum+1); }
		}
	}

	if(check) {
		var newRow = document.all.comlinetbl.insertRow();
		newRow.className = "normal";
		newRow.onmouseover = saveIndex;
		for (var i=0; i < 12; i++) {
			var newCell = newRow.insertCell();
			newCell.className = "text";
		}
		newRow.cells(0).innerHTML = '<input type="image" name="sbm" src="/images/izmena.gif" onclick="document.all.aaction.value=editcomline;document.all.edithops.value='+document.all.hopsid.value+';"/>';
		newRow.cells(1).innerHTML = '<input type="text" class="edittini" name="numbersinfile" value='+numberinf+'>';
		newRow.cells(2).innerHTML = '<input type="hidden" name="comlines" value='+document.all.hopsid.value+'>'+document.all.comlinecode.value;
		newRow.cells(3).innerText = document.all.positiona.value;
		newRow.cells(4).innerText = document.all.resourcea.value;
		newRow.cells(5).innerText = '-';
		newRow.cells(6).innerText = document.all.positionb.value;
		newRow.cells(7).innerText = document.all.resourceb.value;
		newRow.cells(8).innerText = document.all.comlinetype.value;
		newRow.cells(9).innerText = document.all.hopstate.value;
		newRow.cells(10).innerHTML = '<input type="checkbox" name="psfo" value='+document.all.hopsid.value+'><input type="text" class="editsmallsearch" style="width:100pt;" size="10" name="sfonumber" value="">';
		newRow.cells(11).innerHTML = '<input type="image" src="/images/iskl.gif" onclick="delComline();" name="delC" title="Исключить пролёт из файла"/>';
		newRow.onmouseover=saveIndex;
	} else {
		alert("Линия связи '"+document.all.comlinecode.value+"' уже присутствует в списке!");
	}
}

function isAnySelected() {
	var l = 0;
	var b = false;
	if(document.all.psfo) {
		if(document.all.psfo.length) {
			l = document.all.psfo.length;
		} else if(document.all.psfo.value) {
			b = document.all.psfo.checked;
			l = 0;
		}
	}
	for(var i = 0; i < l; i++) {
		if(document.all.psfo[i].checked) {
			b = true;
		}
	}
	return b;
}

var checkedSfo = false;

function checkAllSfo() {
	var l = 0;
	if(document.all.psfo) {
		if(document.all.psfo.length) {
			checkedSfo = !checkedSfo;
			l = document.all.psfo.length;
			for(var i = 0; i < l; i++) {
				document.all.psfo[i].checked = checkedSfo;
			}
		} else if(document.all.psfo.value) {
			checkedSfo = !checkedSfo;
			document.all.psfo.checked = checkedSfo;
		}
	}
}

function sfoSet() {
	if(isAnySelected() == false) {
		alert('Для присвоения "№ заявки СФО" необходимо отметить хотя бы один пролёт!');
		return;
	} else {
		var v = window.showModalDialog('/basestation/freqlicenceSfonumber.html','','dialogHeight:120px;dialogWidth:500px;scroll:no;status:no;help:no;');
		if(v != null) {
			var l = 0;
			if(document.all.psfo) {
				if(document.all.psfo.length) {
					l = document.all.psfo.length;
					for(var i = 0; i < l; i++) {
						if(document.all.psfo[i].checked) {
							document.all.sfonumber[i].value = v;
						}
					}
				} else if(document.all.psfo.value) {
					document.all.sfonumber.value = v;
					l = 0;
				}
			}
		}
	}
}

</script>

<html:hidden property="freqpermid"/>

<input type="hidden" name="aaction"/>
<input type="hidden" name="edithops"/>

<table class="main">
<july:separator/>
<july:formbuttons/>
<july:separator/>
<tr>
	<td class="title" colspan="2"><july:actionalert/></td>
</tr>
<logic:notEqual name="FrequencyLicenceForm" property="action" value="Delete">
<logic:notEqual name="FrequencyLicenceForm" property="action" value="Add">
<july:separator/>
<tr>
	<td class="text"><bean:message key="label.position.actions"/>:</td>
	<td class="text">
		<alex:hasAccess href="/ShowFreqLicenceHistoryList.do" >
			<html:link href="/basestation/ShowFreqLicenceHistoryList.do" paramId="freqpermid" paramName="FrequencyLicenceForm" paramProperty="freqpermid"><nobr><bean:message key="navtitle.ShowFreqLicenceHistoryList"/></nobr></html:link>
		</alex:hasAccess>
		<alex:hasAccess href="/ShowFrequencyLicencePositionsList.do" >
			<html:link href="/basestation/ShowFrequencyLicencePositionsList.do" paramId="freqpermid" paramName="FrequencyLicenceForm" paramProperty="freqpermid"><nobr>Список позиций</nobr></html:link>
		</alex:hasAccess>
	</td>
</logic:notEqual>
</logic:notEqual>
<july:separator/>
<tr>
	<td class="text"><bean:message key="label.freqform.filenumber"/>:</td>
	<td class="text">
		<july:string size="10" property="filenumber.string" styleId="filenumberFrm" insertable="true" updatable="true" />
	</td>
</tr>
<july:separator/>
<tr>
	<td class="text"><bean:message key="label.freqform.etap"/>:</td>
	<td class="text">
		<july:string size="20" property="etap" styleId="etap" insertable="true" updatable="true" />
	</td>
</tr>
<july:separator/>
<tr>
	<td class="text"><bean:message key="label.freqform.comment"/>:</td>
	<td class="text">
		<july:textarea property="comment" cols="40" rows="3" insertable="true" updatable="true" />
	</td>
</tr>
<july:separator/>
<tr>
	<td class="text" colspan="2">
		<table width="100%" border="0" class="main" id="comlinetbl">
		<tr class="title">
			<td colspan="12" class="title">
				<bean:message key="label.freqform.comlines"/>
				&nbsp;
<logic:notEqual name="FrequencyLicenceForm" property="action" value="Delete">
				<input type="hidden" name="hopsid" value=""><input type="hidden" name="comlinecode" value=""><input type="hidden" name="positiona" value=""><input type="hidden" name="resourcea" value=""><input type="hidden" name="positionb" value=""><input type="hidden" name="resourceb" value=""><input type="hidden" name="comlinetype" value=""><input type="hidden" name="hopstate" value="">
				<july:lookupbutton action="/ShowComlineLookupList.do" image="vkl" styleId="comll" fieldNames="hopsid;comlinecode;positiona;resourcea;positionb;resourceb;comlinetype;hopstate" newWindowName="comlinelookup" insertable="true" updatable="true" onselect="addComline();" title="Включить пролёт в файл"/>
				&nbsp;&nbsp;&nbsp;
				<input type="image" name="sbm" src="/images/plus.gif" title="Добавить новый пролёт" onclick="document.all.aaction.value='addcomline';"/>
</logic:notEqual>
			</td>
		</tr>
		<tr class="title">
<%if(editaction){%><td class="title">&nbsp;</td><%}%>
			<july:headercolumn key="label.sitedoc.number" colType="string"/>
			<july:headercolumn key="label.freqform.comlinecode" colType="string"/>
			<july:headercolumn key="label.freqform.position_a" colType="string"/>
			<july:headercolumn key="label.freqform.resource_a" colType="string"/>
			<td class="title">&nbsp;</td>
			<july:headercolumn key="label.freqform.position_b" colType="string"/>
			<july:headercolumn key="label.freqform.resource_b" colType="string"/>
			<july:headercolumn key="label.freqform.comlinetype" colType="string"/>
			<july:headercolumn key="ComlineList.table.hopsate" colType="string"/>
			<td class="title" nowrap><img src="/images/yes.gif" align="middle" border=0 alt="Пометить все" style="cursor:hand;" onclick="checkAllSfo();"> № заявки на пр. изм. <img src="/images/izmena.gif" width=16 height=16 align="middle" border=0 alt="Проставить № заявки на протоколы измерений" style="cursor:hand;" onclick="sfoSet();"></td>
<%if(editaction){%><td class="title">&nbsp;</td><%}%>
		</tr>
<logic:iterate id="com" name="FrequencyLicenceForm" property="comlinesList" type="com.hps.july.cdbc.lib.CDBCRowObject">
<logic:present name="com">
<%
	String type = com.getColumn("comlinetype").asString();
	String state = "ComlineList.state.C";
	if(com.getColumn("hopstate").asObject() != null && !"".equals(com.getColumn("hopstate").asString())) {
		state = "ComlineList.state."+com.getColumn("hopstate").asString();
	}
	String hopsid = com.getColumn("hopsid").asString();
%>
		<tr class="normal" onMouseOver="saveIndex();">
<%if(editaction){%><td class="text"><input type="image" name="sbm" src="/images/izmena.gif" onclick='document.all.aaction.value="editcomline";document.all.edithops.value="<%=hopsid%>";'/></td><%}%>
			<td class="text"><%if(editaction){%><input type="text" class="edittini" name="numbersinfile" value='<july:stringwrite name="com" property="numberinfile"/>'><%} else {%><july:stringwrite name="com" property="numberinfile"/><%}%></td>
			<td class="text"><input type="hidden" name="comlines" value='<july:stringwrite name="com" property="hopsid"/>'><july:stringwrite name="com" property="comlinecode"/></td>
			<td class="text"><july:stringwrite name="com" property="positiona"/></td>
			<td class="text"><july:stringwrite name="com" property="resourcea"/></td>
			<td class="text">-</td>
			<td class="text"><july:stringwrite name="com" property="positionb"/></td>
			<td class="text"><july:stringwrite name="com" property="resourceb"/></td>
			<td class="text"><bean:message key="<%=type%>"/></td>
			<td class="text"><bean:message key="<%=state%>"/></td>
			<td class="text"><%if(editaction){%><input type="checkbox" name="psfo" value='<july:stringwrite name="com" property="hopsid"/>'><input type="text" class="editsearch" style="width:100pt;" name="sfonumber" value='<july:stringwrite name="com" property="sfonumber"/>'><%} else {%><july:stringwrite name="com" property="sfonumber"/><%}%></td>
<%if(editaction){%><td class="text"><input type="image" src="/images/iskl.gif" onclick="delComline();" name="delC" title="Исключить пролёт из файла"/></td><%}%>
		</tr>
</logic:present>
</logic:iterate>
		</table>
	</td>
</tr>
<july:separator/>
<july:formbuttons/>
<july:separator/>
</table>
</july:editform>
