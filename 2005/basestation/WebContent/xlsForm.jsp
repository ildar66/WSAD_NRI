<%@ page language = "java" %> 
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.basestation.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<script>
<!--
	function beforeSubmit() {
		var vertic = document.getElementById('vertic').getAttribute('checked');
		var cross = document.getElementById('cross').getAttribute('checked');
		if(!vertic && !cross) {
			alert('Укажите поляризацию !');
			return false;
		}
		document.body.style.cursor="wait";
		return true;
	}
-->
</script>

<html:form method="post" action="/ProcessXls" enctype="multipart/form-data" name="loadXlsForm" type="com.hps.july.basestation.formbean.LoadXlsForm">

<%--<july:editform action="/ProcessXls.do">
<jsp:useBean id="loadXlsForm" class="com.hps.july.basestation.formbean.LoadXlsForm" scope="session"/>--%>

<script language="javascript">

var curLine = 2;
var maxLine = 0;

function saveIndex() {
	if (window.event.toElement.parentElement.tagName == 'TR') {
		curLine=window.event.toElement.parentElement.rowIndex;
	}
}

function del() {
	document.all.ranges.deleteRow(curLine);
}

function addRange() {

		var newRow = document.all.ranges.insertRow();
		newRow.className = "print";
		newRow.onmouseover = saveIndex;
		for (var i=0; i < 4; i++) {
			var newCell = newRow.insertCell();
			newCell.className = "print";
		}
		
		newRow.cells(0).innerHTML = 'c <INPUT TYPE=TEXT NAME="range[' + maxLine + '].startnumber" size="7" style="font-size:8pt; FONT-FAMILY: Verdana,Arial; background-color: D6EBFF;">  по <INPUT TYPE=TEXT NAME="range[' + maxLine + '].endnumber" size="7" style="font-size:8pt; FONT-FAMILY: Verdana,Arial; background-color: D6EBFF;">';

		newRow.cells(1).innerHTML = '<SELECT NAME="range[' + maxLine + '].polar" style="font-size:8pt; FONT-FAMILY: Verdana,Arial; background-color: D6EBFF;"><OPTION VALUE="V">Вертикальная</OPTION><OPTION VALUE="C">Кросс</OPTION></SELECT>';			
		
		newRow.cells(2).innerHTML = '<SELECT NAME="range[' + maxLine + '].band" style="font-size:8pt; FONT-FAMILY: Verdana,Arial; background-color: D6EBFF;"><OPTION VALUE="900">900</OPTION><OPTION VALUE="1800">1800</OPTION></SELECT>';		

		newRow.cells(3).innerHTML = '<input type="image" src="/images/del.gif" onclick="del();return false;" name="del"/>';

		newRow.onmouseover=saveIndex;		
		maxLine = maxLine + 1;

}
</script>

<input type="hidden" name="retpath" value="ProcessXls.do">
<input type="hidden" name="step1" value="1">
<table class="main">
<july:separator colspan="3"/>
<tr class=title>
	<td colSpan=3>
		<%-- <input type=image alt="Загрузить"  onclick='document.body.style.cursor="wait"' src="/images/loadexcel.gif" name=submit>&nbsp; --%>
		<a title="Отказ и возврат" href="main.do"><img onclick="document.body.style.cursor='wait';" alt="Отказ и возврат" src="/images/cancel.gif" border=0></a>
	</td>
</tr>

<july:separator colspan="3"/>
<tr class="title">
	<td colspan="3"><b>Шаг 1</b></td>
</tr>
<july:separator colspan="3"/>
<tr>
	<td colSpan=2 width="30%"><july:reqmark><bean:message key="xls.filename"/>:</july:reqmark></td>
	<td width="70%">
	<html:file styleClass="editbig" name="loadXlsForm" property="xslFile"></html:file>&nbsp;&nbsp;&nbsp;&nbsp;
	<html:link href="/exampleExcel.jsp">Образец файла</html:link>
	</td>
</tr>
<july:separator colspan="3"/>
<tr>
	<td colSpan=2>
		<nobr><bean:message key="xls.title.vertical"/></nobr>
	</td>
	<td>
		<july:checkbox styleClass="text" styleId="vertic" insertable="true" updatable="true" property="vertic"/>
	</td>
</tr>
<tr>
	<td colSpan=2><nobr><bean:message key="xls.title.cross"/></nobr></td>
	<td>
		<july:checkbox styleClass="text" styleId="cross" insertable="true" updatable="true" property="cross"/>
	</td>
</tr>

<july:separator colspan="3"/>
<tr>
	<td rowspan="2">
		Диапазон
	</td>
	<td align=right>900</td>
	<td>
		<INPUT class="editcheckbox" TYPE="radio" name="diapazon" value="900" checked>
	</td>
</tr>
<tr>
	<td align=right>1800</td>
	<td>
		<INPUT class="editcheckbox" TYPE="radio" name="diapazon" value="1800">
	</td>
</tr>

<july:separator colspan="3"/>
<tr>
	<td colSpan=2><bean:message key="xls.report.msg"/></td>
	<td>
		<INPUT class="editcheckbox" TYPE="checkbox" name="maxReport" value=on >
	</td>
</tr>
<july:separator colspan="3"/>

<tr>
	<td colSpan="2" align="left">
		&nbsp;&nbsp;<INPUT type=image src="/images/nextbtn.jpg" onclick='return beforeSubmit();' name=submit value="Загрузить">&nbsp;
	</td>
	<td align="center">
		<html:link page="/xlsJournal.do?task=1"><bean:message key="xls.journal"/></html:link>
	</td>
</tr>
<july:separator colspan="3"/>
<tr class=title>
	<td colSpan=3>
		<%-- <input type=image alt="Загрузить"  onclick='document.body.style.cursor="wait"' src="/images/loadexcel.gif" name=submit>&nbsp; --%>
		<a title="Отказ и возврат" href="main.do"><img onclick="document.body.style.cursor='wait';" alt="Отказ и возврат" src="/images/cancel.gif" border=0></a>
	</td>
</tr>
<july:separator colspan="3"/>
</table>
</html:form>
<%--</july:editform>--%>
