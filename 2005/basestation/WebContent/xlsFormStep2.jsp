<%@ page language = "java" %> 
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.basestation.*,
                 java.util.Iterator,
                 java.util.ArrayList,
com.hps.july.basestation.formbean.*,
com.hps.july.basestation.actionbean.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>




 <july:editform action="/ProcessXlsStep2.do" enctype="multipart/form-data">
<%--
<html:form method="post" action="/ProcessXlsStep2.do" enctype="multipart/form-data">

 <jsp:useBean id="loadXlsForm" class="com.hps.july.basestation.formbean.LoadXlsForm" scope="session"/> --%>

<script language="javascript">

	function beforeSubmit() {
	  	var info = document.getElementById('info');
		//var w = document.body.clientWidth;
		//var h = document.body.clientHeight;
		//info.style.top = (h / 2) - info.clientHeight; 
		//info.style.left = (w / 2) - 200; 
		info.style.display = 'block';
		document.body.style.cursor="wait";
		return true;
	}
    function _onchange(tt, number) {
        var root = document.getElementById('r' + number);
        if(number == 900) number = '';
        var _thisR = tt.getAttribute('r');
        if(_thisR) {
            var cur1 = document.getElementById('range' + number + _thisR + '-1');
            var cur2 = document.getElementById('range' + number + _thisR + '-2');
            if(cur1) cur1.value = '';
            if(cur2) cur2.value = '';
        }
    }

    function _onblur1(tt, number){
        var txt = tt.value;
        //if(txt.length == 0)tt.value=0;
        for(var i=0; i < txt.length; i++){
            achar = txt.substring(i, i+1);
            if(achar < '0' || achar > '9'){
                alert("Введено неправильное значение - '"+txt+"'");
                tt.select();
                tt.focus();
                return;
            }
        }
        if(txt.length > 3  || parseInt(txt) > 124  || parseInt(txt) <= 0){
                alert("Введено неверное значение - '"+txt+"', минимум 1, максимум 124");
                tt.select();
                tt.focus();
                return;
        }

        //check another diapasons
        var root = document.getElementById('r' + number);
        if(number == 900) number = '';
        var polar = document.getElementById('range' + number + tt.getAttribute('r') + 'p').value;
        if(root) {
            var inputs = root.getElementsByTagName('INPUT');
			for(var i=0; i < inputs.length;i++) {
                var end = inputs[i].getAttribute('end');
                if(end) continue;
                var r = inputs[i].getAttribute('r');
                if(r) {
                    if(r == tt.getAttribute('r')) continue;
                    var polarPrev = document.getElementById('range' + number + r + 'p').value;
                    if(polarPrev != polar) continue;
                    var prevEl = document.getElementById('range' + number + r + '-2');
                    if(prevEl) {
                        if(((parseInt(inputs[i].value) <= parseInt(txt)) && (parseInt(txt) <= parseInt(prevEl.value)))) {
                            alert('Ошибка, данный диапазон пересекается с одним из существующих ');
                            tt.select();
                            tt.focus();
                            return;
                        }
                    }
                }
			}
        }
    }

    function _onblur2(tt, number){
        var txt = tt.value;
        for(var i=0; i < txt.length; i++){
            var achar = txt.substring(i, i+1);
            if(achar < '0' || achar > '9'){
                alert("Введено неправильное значение - '"+txt+"'");
                tt.select();
                tt.focus();
                return;
            }
        }
        //if(txt.length == 0)tt.value=0;
        if(txt.length > 3 || parseInt(txt) > 124 || parseInt(txt) <= 0){
            alert("Введено неверное значение - '"+txt+"',минимум 1, максимум 124");
            tt.select();
            tt.focus();
            return;
        }
        var curId = tt.id;
        var prevId = curId.substring(0, curId.length - 1) + '1';
        var prev = document.getElementById(prevId);
        if(parseInt(prev.value) > parseInt(txt)) {
            alert("Предыдущее значение, не может быть больше текущего");
            tt.select();
            tt.focus();
            return;
        }
        //check another diapasons
        var root = document.getElementById('r' + number);
        if(number == 900) number = '';
        var polar = document.getElementById('range' + number + tt.getAttribute('r') + 'p').value;
        if(root) {
            var inputs = root.getElementsByTagName('INPUT');
			for(var i=0; i < inputs.length;i++) {
                var end = inputs[i].getAttribute('end');
                if(end) continue;
                var r = inputs[i].getAttribute('r');
                if(r) {
                    if(r == tt.getAttribute('r')) continue;
                    var prevEl = document.getElementById('range' + number + r + '-2');
                    //alert("("+txt+"-"+prev.value+") " +inputs[i].value + "-" + prevEl.value);
                    var polarPrev = document.getElementById('range' + number + r + 'p').value;
                    if(polarPrev != polar) continue;
                    if(prevEl) {
                        if(((parseInt(inputs[i].value) <= parseInt(txt)) && (parseInt(txt) <= parseInt(prevEl.value)))) {
                            alert('Ошибка, данный диапазон пересекается с одним из существующих ');
                            tt.select();
                            tt.focus();
                            tt.value = '';
                            return;
                        }
                        if(((parseInt(inputs[i].value) <= parseInt(txt)) && (parseInt(prev.value) <= parseInt(prevEl.value)))) {
                            alert('Ошибка, в данный диапазон входит один из существующих ');
                            tt.select();
                            tt.focus();
                            tt.value = '';
                            return;
                        }
                        if(((parseInt(inputs[i].value) <= parseInt(prev.value)) && (parseInt(txt.value) <= parseInt(prevEl.value)))) {
                            alert('Ошибка, данный диапазон входит в один из существующих ');
                            tt.select();
                            tt.focus();
                            tt.value = '';
                            return;
                        }
                    }
                }
			}
        }
    }
    <%
        com.hps.july.basestation.formbean.LoadXlsForm tForm = (com.hps.july.basestation.formbean.LoadXlsForm)session.getAttribute("LoadXlsForm");
        ArrayList r900 = tForm.getR900();
        ArrayList r1800 = tForm.getR1800();
     %>

    var curLine900 = 2;
    var maxLine900 = <%=r900.size()%>;
    var curLine1800 = 2;
    var maxLine1800 = <%=r1800.size()%>;;

    function saveIndex900() {
        if (window.event.toElement.parentElement.tagName == 'TR') {
            curLine900=window.event.toElement.parentElement.rowIndex;
        }
    }
    function saveIndex1800() {
        if (window.event.toElement.parentElement.tagName == 'TR') {
            curLine1800=window.event.toElement.parentElement.rowIndex;
        }
    }
    function del(number) {
        if(number == '900') { //alert(curLine900);
            document.all.ranges.deleteRow(curLine900);
        }
        else {
            document.all.ranges1800.deleteRow(curLine1800);
        }
    }

    function addRange(number) {
		var newRow = null;
        if(number == '900') newRow = document.all.ranges.insertRow();
        else newRow = document.all.ranges1800.insertRow();
		newRow.className = "print";
		if(number == '900') newRow.onmouseover = saveIndex900;
        else newRow.onmouseover = saveIndex1800;
		for (var i=0; i < 4; i++) {
			var newCell = newRow.insertCell();
			newCell.className = "print";
		}
        if(number == '900') {
            newRow.cells(0).innerHTML = '<SELECT r="'+maxLine900+'" NAME="range[' + maxLine900 + '].polar" id="range'+maxLine900+'p" style="font-size:8pt; FONT-FAMILY: Verdana,Arial; background-color: D6EBFF;" onchange="_onchange(this, \'900\')"><logic:equal name="LoadXlsForm" property="vertic" value="true"><OPTION VALUE="V">Вертикальная</OPTION></logic:equal><logic:equal name="LoadXlsForm" property="cross" value="true"><OPTION VALUE="C">Кросс</OPTION></logic:equal></SELECT>';
            newRow.cells(1).innerHTML = 'c <INPUT TYPE=TEXT r="'+maxLine900+'" id="range'+maxLine900+'-1" NAME="range[' + maxLine900 + '].startnumber" size="7" maxlength="3" onblur="_onblur1(this, \'900\')" style="font-size:8pt; FONT-FAMILY: Verdana,Arial; background-color: D6EBFF;">  по <INPUT TYPE=TEXT id="range'+maxLine900+'-2" r="'+maxLine900+'" end="1" NAME="range[' + maxLine900 + '].endnumber" onblur="_onblur2(this, \'900\');" maxlength="3"  size="7" style="font-size:8pt; FONT-FAMILY: Verdana,Arial; background-color: D6EBFF;">';
            newRow.cells(2).innerHTML = '<INPUT type="text" NAME="range[' + maxLine900 + '].band" value="'+number+'" style="font-size:8pt; FONT-FAMILY: Verdana,Arial; background-color: D6EBFF;" readonly="1">';
            newRow.cells(3).innerHTML = '<input type="image" src="/images/del.gif" onclick="del(\''+number+'\');return false;" name="del"/>';
        } else {
            newRow.cells(0).innerHTML = '<SELECT r="'+maxLine1800+'" NAME="range1800[' + maxLine1800 + '].polar" id="range1800'+maxLine1800+'p" style="font-size:8pt; FONT-FAMILY: Verdana,Arial; background-color: D6EBFF;" onchange="_onchange(this, \'1800\')"><logic:equal name="LoadXlsForm" property="vertic" value="true"><OPTION VALUE="V">Вертикальная</OPTION></logic:equal><logic:equal name="LoadXlsForm" property="cross" value="true"><OPTION VALUE="C">Кросс</OPTION></logic:equal></SELECT>';
            newRow.cells(1).innerHTML = 'c <INPUT TYPE=TEXT r="'+maxLine1800+'" id="range1800'+maxLine1800+'-1" NAME="range1800[' + maxLine1800 + '].startnumber" onblur="_onblur1(this, \'1800\')" size="7" maxlength="3" style="font-size:8pt; FONT-FAMILY: Verdana,Arial; background-color: D6EBFF;">  по <INPUT TYPE=TEXT id="range1800'+maxLine1800+'-2" r="'+maxLine1800+'" end="1" NAME="range1800[' + maxLine1800 + '].endnumber" onblur="_onblur2(this, \'1800\');" maxlength="3" size="7" style="font-size:8pt; FONT-FAMILY: Verdana,Arial; background-color: D6EBFF;">';
            newRow.cells(2).innerHTML = '<INPUT type="text" NAME="range1800[' + maxLine1800 + '].band" value="'+number+'" style="font-size:8pt; FONT-FAMILY: Verdana,Arial; background-color: D6EBFF;" readonly="1">';
            newRow.cells(3).innerHTML = '<input type="image" src="/images/del.gif" onclick="del(\''+number+'\');return false;" name="del"/>';
        }
        if(number == '900') {
            newRow.onmouseover=saveIndex900;
            maxLine900 = maxLine900 + 1;
        } else {
            newRow.onmouseover=saveIndex1800;
            maxLine1800 = maxLine1800 + 1;
        }
    }
</script>

<input type="hidden" name="retpath" value="ProcessXls.do">
<table class="main">
<july:separator colspan="3"/>
<tr class="title">
	<td colspan="3"><b>Шаг 2</b></td>
</tr>
<july:separator colspan="3"/>
<tr id="info" class=title bgcolor="red" style="display:none;" align="center">
	<td colSpan=3 bgcolor="red">
		<span style="font-size: 12px"><b>&nbsp;Загрузка может занять несколько минут!&nbsp;</b></span>		
	</td>
</tr>
<tr class=title>
	<td colSpan=3>
    <a title="Отказ и возврат" href="LoadXls.do"><img onclick="document.body.style.cursor='wait';" alt="Отказ и возврат" src="/images/cancel.gif" border=0></a>
<%--
		<TABLE class="buttons">
            <TR class="title">
             <TD class="buttons"><july:formbuttons showdelete="false" showreset="false" showsave="false" /></TD>
            </TR>
        </TABLE>
--%>
		<%-- <input type=image alt="Загрузить"  onclick='document.body.style.cursor="wait"' src="/images/loadexcel.gif" name=submit>&nbsp;
		<a title="Отказ и возврат" href="main.do"><img onclick="document.body.style.cursor='wait';" alt="Отказ и возврат" src="/images/cancel.gif" border=0></a>--%>
	</td>
</tr>

<%-- <july:separator colspan="3"/>
<tr>
	<td colSpan=2 width="30%"><july:reqmark><bean:message key="xls.filename"/>:</july:reqmark></td>
	<td width="70%">
	<html:file styleClass="editbig" name="loadXlsForm" property="xslFile"></html:file>&nbsp;&nbsp;&nbsp;&nbsp;
	<html:link href="/exampleExcel.jsp">Образец файла</html:link>
	</td>
</tr>
--%>
<logic:equal name="LoadXlsForm" property="vertic" value="true">
    <july:separator colspan="3"/>
    <tr>
        <td colSpan=2>
            <nobr><bean:message key="xls.title.vertical"/></nobr>
        </td>
        <td>YES</td>
    </tr>
</logic:equal>
<logic:equal name="LoadXlsForm" property="cross" value="true">
    <july:separator colspan="3"/>
<tr>
	<td colSpan=2>
		<nobr><bean:message key="xls.title.cross"/></nobr>
	</td>
	<td>YES</td>
</tr>
</logic:equal>

<july:separator colspan="3"/>
<tr>
	<td>
		Диапазон
	</td>
	<td colspan="2">
	<logic:equal name="LoadXlsForm" property="diapazon" value="900">
		900
	</logic:equal>
	<logic:equal name="LoadXlsForm" property="diapazon" value="1800">
		1800
	</logic:equal>
	</td>
</tr>

<july:separator colspan="3"/>
<tr class="title">
	<td  colspan="3" >
		<b>Разрешенные диапазоны</b>
	</td>
</tr>
<july:separator colspan="3"/>

<tr>
	<td colSpan=3>
		
            <table border="0" width="80%" id="r900" <logic:equal name="LoadXlsForm" property="diapazon" value="1800">style="display:none"</logic:equal>>
                <tr>
                    <td width="80%">
                        <table class="print" style="font-size:8pt;" id="ranges">
                            <tr class="print">
                                <td class="print" colspan="4">
                                    <IMG SRC="/images/plus.gif" onclick="addRange('900');" BORDER="0">
                                </td>
                            </tr>
                            <tr class="print">
                                <td class="print">Поляризация</td>
                                <td class="print"> Каналы </td>
                                <td class="print">Диапазон</td>
                                <td class="print">&nbsp;</td>
                            </tr>
                            <%
                                int ii = 0;
                                for(Iterator iterator = r900.iterator(); iterator.hasNext();) {
                                    RangeAllow ra = (RangeAllow) iterator.next();
                             %>
                                    <tr class="print" onmouseover="saveIndex900()">
                                        <td class="print"><SELECT r="<%=ii%>" NAME="range[<%=ii%>].polar" id="range<%=ii%>p" style="font-size:8pt; FONT-FAMILY: Verdana,Arial; background-color: D6EBFF;" onchange="_onchange(this, '900')"><logic:equal name="LoadXlsForm" property="vertic" value="true"><OPTION VALUE="V" <% if(ra.getPolar().equals("V")) { %>selected<% } %>>Вертикальная</OPTION></logic:equal><logic:equal name="LoadXlsForm" property="cross" value="true"><OPTION VALUE="C" <% if(ra.getPolar().equals("C")) { %>selected<% } %>>Кросс</OPTION></logic:equal></SELECT></td>
                                        <td class="print"> c <INPUT TYPE=TEXT id="range<%=ii%>-1" r="<%=ii%>" NAME="range[<%=ii%>].startnumber" onblur="_onblur1(this, '900');" value="<%=ra.getStartnumber()%>" size="7" maxlength="3" style="font-size:8pt; FONT-FAMILY: Verdana,Arial; background-color: D6EBFF;">  по <INPUT TYPE=TEXT id="range<%=ii%>-2" r="<%=ii%>" end="1" NAME="range[<%=ii%>].endnumber" onblur="_onblur2(this, '900');" value="<%=ra.getEndnumber()%>" size="7" maxlength="3" style="font-size:8pt; FONT-FAMILY: Verdana,Arial; background-color: D6EBFF;"> </td>
                                        <td class="print"><INPUT type="text" NAME="range[<%=ii%>].band" value="900" style="font-size:8pt; FONT-FAMILY: Verdana,Arial; background-color: D6EBFF;" readonly="1"></td>
                                        <td class="print"><input type="image" src="/images/del.gif" onclick="del('900');return false;" name="del"/></td>
                                    </tr>
                             <% ii++; }
                                //tForm.range = new ArrayList();
                             %>
                             <script>
                             <!-- maxLine900 = <%=ii%>; -->
                             </script>
                        </table>
                    </td>
                </tr>
            </table>
            <table border="0" width="80%" id="r1800" <logic:equal name="LoadXlsForm" property="diapazon" value="900">style="display:none"</logic:equal>>
                <tr>
                    <td width="80%">
                        <table class="print" style="font-size:8pt;" id="ranges1800">
                            <tr class="print">
                                <td class="print" colspan="4">
                                    <IMG SRC="/images/plus.gif" onclick="addRange('1800');" BORDER="0">
                                </td>
                            </tr>
                            <tr class="print">
                                <td class="print">Поляризация</td>
                                <td class="print"> Каналы </td>
                                <td class="print">Диапазон</td>
                                <td class="print">&nbsp;</td>
                            </tr>
                            <%
                                ii = 0;
                                for(Iterator iterator = r1800.iterator(); iterator.hasNext();) {
                                    RangeAllow ra = (RangeAllow) iterator.next();
                             %>
                                    <tr class="print" onmouseover="saveIndex1800()">
                                        <td class="print"><SELECT r="<%=ii%>" NAME="range1800[<%=ii%>].polar" id="range1800<%=ii%>p" style="font-size:8pt; FONT-FAMILY: Verdana,Arial; background-color: D6EBFF;" onchange="_onchange(this, '1800')"><logic:equal name="LoadXlsForm" property="vertic" value="true"><OPTION VALUE="V" <% if(ra.getPolar().equals("V")) { %>selected<% } %>>Вертикальная</OPTION></logic:equal><logic:equal name="LoadXlsForm" property="cross" value="true"><OPTION VALUE="C" <% if(ra.getPolar().equals("C")) { %>selected<% } %>>Кросс</OPTION></logic:equal></SELECT></td>
                                        <td class="print"> c <INPUT TYPE=TEXT id="range1800<%=ii%>-1" r="<%=ii%>" NAME="range1800[<%=ii%>].startnumber" value="<%=ra.getStartnumber()%>" size="7" maxlength="3" onblur="_onblur1(this, '1800');" style="font-size:8pt; FONT-FAMILY: Verdana,Arial; background-color: D6EBFF;">  по <INPUT TYPE=TEXT id="range1800<%=ii%>-2" r="<%=ii%>" end="1" NAME="range1800[<%=ii%>].endnumber" value="<%=ra.getEndnumber()%>" onblur="_onblur2(this, '1800');" maxlength="3" size="7" style="font-size:8pt; FONT-FAMILY: Verdana,Arial; background-color: D6EBFF;"> </td>
                                        <td class="print"><INPUT type="text" NAME="range1800[<%=ii%>].band" value="1800" style="font-size:8pt; FONT-FAMILY: Verdana,Arial; background-color: D6EBFF;" readonly="1"></td>
                                        <td class="print"><input type="image" src="/images/del.gif" onclick="del('1800');return false;" name="del"/></td>
                                    </tr>
                             <% ii++; }
                                //tForm.range1800 = new ArrayList();
                             %>
                             <script>
                             <!-- maxLine1800 = <%=ii%>; -->
                             </script>
                        </table>
                    </td>
                </tr>
            </table>

	</td>
</tr>

<july:separator colspan="3"/>

<tr>
	<td colSpan="3" align="left">
		&nbsp;&nbsp;<INPUT type=image src="/images/loadbtn.jpg" onclick='return beforeSubmit();' name=submit value="Загрузить">&nbsp;
	</td>
	<%--td align=center>
		<html:link page="/xlsJournal.do?task=1"><bean:message key="xls.journal"/></html:link>
	</td --%>
</tr>
<july:separator colspan="3"/>
<tr class=title>
	<td colSpan=3>
		<%-- <input type=image alt="Загрузить"  onclick='document.body.style.cursor="wait"' src="/images/loadexcel.gif" name=submit>&nbsp; --%>
        <a title="Отказ и возврат" href="LoadXls.do"><img onclick="document.body.style.cursor='wait';" alt="Отказ и возврат" src="/images/cancel.gif" border=0></a>
	</td>
</tr>
<july:separator colspan="3"/>
</table>
</july:editform>
<%-- </html:form>--%>
