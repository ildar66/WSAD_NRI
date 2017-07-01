<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.basestation.*,com.hps.july.persistence.*,com.hps.july.basestation.formbean.*,com.hps.july.basestation.valueobject.ChanalPowers,
                 java.util.ArrayList,
                 java.util.Iterator" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<script type="text/javascript" language="JavaScript">
<!--
    function _onblur(tt){
        var txt = tt.value;
        if(txt.length == 0)tt.value=0;
        if(txt.length > 9){
                alert("Введено слишком большое значение - '"+txt+"'");
                tt.select();
                tt.focus();
                return;
        }
        for(var i=0; i < txt.length; i++){
            achar = txt.substring(i, i+1);
            if(achar < '0' || achar > '9'){
                alert("Введено неправильное значение - '"+txt+"'");
                tt.select();
                tt.focus();
                return;
            }
        }
        changeColor(tt);
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

function changeColor(tt){
	var txt = tt.value;
	if(txt==0)tt.style.backgroundColor='#FF6347';
	else if(txt > 0 && txt < 5)tt.style.backgroundColor='Fuchsia';
	else if(txt > 4 && txt < 9)tt.style.backgroundColor='#1E90FF';
	else if(txt > 8 && txt < 13)tt.style.backgroundColor='Aqua';
	else if(txt > 12)tt.style.backgroundColor='White';
}
function styles(obj){
	for(var i=0; i < obj.length; i++){
		changeColor(obj[i]);
	}
}

function handleReset(){
	document.ShowChanalPower.reset();
	styles(ar);
}

function init()
{
	document.all.ResetButton(0).attachEvent("onclick", handleReset);
	document.all.ResetButton(1).attachEvent("onclick", handleReset);
}

    function changeDiapasonView(number) {
        var diapason900 = document.getElementById('diapason900');
        var diapason1800 = document.getElementById('diapason1800');
        var r900 = document.getElementById('r900');
        var r1800 = document.getElementById('r1800');
        var d900 = document.getElementById('d900');
        var d1800 = document.getElementById('d1800');
        if(number == '900') {
            diapason1800.style.display = 'none';
            diapason900.style.display = 'block';
            r1800.style.display = 'none';
            r900.style.display = 'block';
            d1800.style.color = 'black';
            d900.style.color = 'red';
        } else {
            if(number == '1800') {
                diapason900.style.display = 'none';
                diapason1800.style.display = 'block';
                r900.style.display = 'none';
                r1800.style.display = 'block';
                d1800.style.color = 'red';
                d900.style.color = 'black';
            }
        }
    }
    <%
        ShowChanalPowerForm tForm = (ShowChanalPowerForm)pageContext.findAttribute("ShowChanalPower");
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
        if(number == '900') document.all.ranges.deleteRow(curLine900);
        else document.all.ranges1800.deleteRow(curLine1800);
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
            newRow.cells(0).innerHTML = '<SELECT r="'+maxLine900+'" NAME="range[' + maxLine900 + '].polar" id="range'+maxLine900+'p" style="font-size:8pt; FONT-FAMILY: Verdana,Arial; background-color: D6EBFF;" onchange="_onchange(this, \'900\')"><OPTION VALUE="V">Вертикальная</OPTION><OPTION VALUE="C">Кросс</OPTION></SELECT>';
            newRow.cells(1).innerHTML = 'c <INPUT TYPE=TEXT r="'+maxLine900+'" id="range'+maxLine900+'-1" NAME="range[' + maxLine900 + '].startnumber" size="7" maxlength="3" onblur="_onblur1(this, \'900\')" style="font-size:8pt; FONT-FAMILY: Verdana,Arial; background-color: D6EBFF;">  по <INPUT TYPE=TEXT id="range'+maxLine900+'-2" r="'+maxLine900+'" end="1" NAME="range[' + maxLine900 + '].endnumber" onblur="_onblur2(this, \'900\');" maxlength="3"  size="7" style="font-size:8pt; FONT-FAMILY: Verdana,Arial; background-color: D6EBFF;">';
            newRow.cells(2).innerHTML = '<INPUT type="text" NAME="range[' + maxLine900 + '].band" value="'+number+'" style="font-size:8pt; FONT-FAMILY: Verdana,Arial; background-color: D6EBFF;" readonly="1">';
            newRow.cells(3).innerHTML = '<input type="image" src="/images/del.gif" onclick="del(\''+number+'\');return false;" name="del"/>';
        } else {
            newRow.cells(0).innerHTML = '<SELECT r="'+maxLine1800+'" NAME="range1800[' + maxLine1800 + '].polar" id="range1800'+maxLine1800+'p" style="font-size:8pt; FONT-FAMILY: Verdana,Arial; background-color: D6EBFF;" onchange="_onchange(this, \'1800\')"><OPTION VALUE="V">Вертикальная</OPTION><OPTION VALUE="C">Кросс</OPTION></SELECT>';
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

-->
</script>

<%
//FactBaseStationForm tForm=(FactBaseStationForm)pageContext.findAttribute("FactBaseStationForm");
String returnPage="/"+request.getParameter("returnPage");
String temp = request.getParameter("returnPage");
String beanName;
if(temp.equals("Edit_ViewFactBaseStation.do"))
	beanName = "FactBaseStationForm";
else
	beanName = "PlanBaseStationForm";

%>

<july:editform action="/EditChanalPower.do">

<input type="hidden" name="basestation" value="<%= request.getParameter("basestation")%>">
<input type="hidden" name="returnPage" value="<%= returnPage%>">

<table class="main">

<%-- DD
    <tr class="title">
    	<td class="title" colspan="2">
			<html:link page="/ShowBaseStationList.do" styleClass="navigator">
				Базовые станции
			</html:link>
		   <july:sepmark/>

			<html:link page="<%=returnPage%>" paramId="basestation" paramName="<%=beanName%>" paramProperty="basestation" styleClass="navigator">
				Просмотр БС
			</html:link>
			<july:sepmark/>

		   <july:currmark><bean:message key="chanalpower.edit.title.nav"/></july:currmark></td>
    </tr>
--%>

    <july:separator/>
    <tr>
        <td class="title" colspan="2"><july:currmark><bean:message key="chanalpower.edit.title"/></july:currmark></td>
    </tr>
    <july:separator/>
	<tr><%--Позиция--%>
        <td class="text"><bean:message key="chanalpower.edit.position"/></td>
        <td><bean:write name="ShowChanalPower" property="positionNum"/>&nbsp;&nbsp;
			<bean:write name="ShowChanalPower" property="positionName"/></td>
    </tr>    
    <july:separator/>
	<tr><%--Адрес--%>
        <td class="text"><bean:message key="chanalpower.edit.address"/></td>
		<td class="text"><bean:write name="ShowChanalPower" property="address"/></td>
    </tr>    
    <july:separator/>
	<tr><%--Базовая станция--%>
        <td class="text"><bean:message key="chanalpower.edit.basestation"/></td>
        <td><bean:write name="ShowChanalPower" property="basestationNum"/>&nbsp;&nbsp;
			<bean:write name="ShowChanalPower" property="basestationName"/></td>
    </tr>    
    <july:separator colspan="3"/>

</table>

<table class="main">
<july:formbuttons/>
<july:separator/>
</table>


<table class="main" border="0">
    <tr class="title">
        <td class="title" align="left">&nbsp;<B>Диапазон <a id="d900" href="#" onclick="changeDiapasonView('900')" style="color:red">900</a> / <a id="d1800" href="#" onclick="changeDiapasonView('1800')" style="color:black">1800</a></B></td>
    </tr>
    <july:separator/>
    <tr>
        <td>
            <table class="main" border="0">
                <tr class="title">
                    <td class="title" align="left">&nbsp;<B>Разрешенные диапазоны</B></td>
                </tr>
                <july:separator/>
            </table>

            <table border="0" width="60%" id="r900">
                <tr>
                    <td width="60%">
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
                                        <td class="print"><SELECT NAME="range[<%=ii%>].polar" id="range<%=ii%>p" r="<%=ii%>"  style="font-size:8pt; FONT-FAMILY: Verdana,Arial; background-color: D6EBFF;" onchange="_onchange(this, '900')"><OPTION VALUE="V" <% if(ra.getPolar().equals("V")) { %>selected<% } %>>Вертикальная</OPTION><OPTION VALUE="C" <% if(ra.getPolar().equals("C")) { %>selected<% } %>>Кросс</OPTION></SELECT></td>
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
            <table border="0" width="60%" id="r1800" style="display:none">
                <tr>
                    <td width="60%">
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
                                        <td class="print"><SELECT id="range1800<%=ii%>p" NAME="range1800[<%=ii%>].polar" r="<%=ii%>" style="font-size:8pt; FONT-FAMILY: Verdana,Arial; background-color: D6EBFF;" onchange="_onchange(this, '1800')"><OPTION VALUE="V" <% if(ra.getPolar().equals("V")) { %>selected<% } %>>Вертикальная</OPTION><OPTION VALUE="C" <% if(ra.getPolar().equals("C")) { %>selected<% } %>>Кросс</OPTION></SELECT></td>
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
                <july:separator/>
            </table>
        </td>
    </tr>
    <tr class="title">
        <td class="title" align="left">&nbsp;<B>Мощность в Ваттах</B></td>
    </tr>
    <july:separator/>
    <tr id="diapason900">
        <td>

            <table class="main" border="0">

            <tr>

            <td align="center">
            <table class="main2" border="0">
            <tr class="title">
                <td class="title" rowspan="2" align="center"><B><bean:message key="chanalpower.edit.canal"/></B></td>
                <td class="title" colspan="2" align="center"><B><bean:message key="chanalpower.edit.polar"/></B></td>
            </tr>
            <tr class="title">
                <td class="title" align="center"><B><bean:message key="chanalpower.edit.vertical"/></B></td>
                <td class="title" align="center"><B><bean:message key="chanalpower.edit.cross"/></B></td>
            </tr>
            </table>
            </td>


            <td class="probelv">
            <img src="/images/points_vert.gif" width="1" height="1" border="0" alt="">
            </td>


            <td align="center">
            <table class="main2" border="0">
            <tr class="title">
                <td class="title" rowspan="2" align="center"><B><bean:message key="chanalpower.edit.canal"/></B></td>
                <td class="title" colspan="2" align="center"><B><bean:message key="chanalpower.edit.polar"/></B></td>
            </tr>
            <tr class="title">
                <td class="title" align="center"><B><bean:message key="chanalpower.edit.vertical"/></B></td>
                <td class="title" align="center"><B><bean:message key="chanalpower.edit.cross"/></B></td>
            </tr>
            </table>
            </td>

            <td class="probelv">
            <img src="/images/points_vert.gif" width="1" height="1" border="0" alt="">
            </td>

            <td align="center">
            <table class="main2" border="0">
            <tr class="title">
                <td class="title" rowspan="2" align="center"><B><bean:message key="chanalpower.edit.canal"/></B></td>
                <td class="title" colspan="2" align="center"><B><bean:message key="chanalpower.edit.polar"/></B></td>
            </tr>
            <tr class="title">
                <td class="title" align="center"><B><bean:message key="chanalpower.edit.vertical"/></B></td>
                <td class="title" align="center"><B><bean:message key="chanalpower.edit.cross"/></B></td>
            </tr>
            </table>
            </td>

            <td class="probelv">
            <img src="/images/points_vert.gif" width="1" height="1" border="0" alt="">
            </td>

            <td align="center">
            <table class="main2" border="0">
            <tr class="title">
                <td class="title" rowspan="2" align="center"><B><bean:message key="chanalpower.edit.canal"/></B></td>
                <td class="title" colspan="2" align="center"><B><bean:message key="chanalpower.edit.polar"/></B></td>
            </tr>
            <tr class="title">
                <td class="title" align="center"><B><bean:message key="chanalpower.edit.vertical"/></B></td>
                <td class="title" align="center"><B><bean:message key="chanalpower.edit.cross"/></B></td>
            </tr>
            </table>
            </td>

            </tr>
            </table>

            <table class="main" border="0">
            <july:separator/>
            </table>


            <table class="main" border="0">
            <tr>

            <%ShowChanalPowerForm form = (ShowChanalPowerForm)request.getAttribute("ShowChanalPower");
            ChanalPowers[] chanalPower = form.getChanalPower900();
            int arLen = chanalPower.length;%>

            <td align="center">
            <table class="main2" border="0">
            <%for(int i = 0; i < arLen/4; i++){
                ChanalPowers row = chanalPower[i];
            %>

            <tr>
                <td class="text" align="center"><input type="text" name="chanal9<%=row.getChanal()%>" value="<%=row.getChanal()%>" size="4" readonly="true" style="background-color:DCDCDC; color:black"></td>
                <td class="text" align="center"><input type="text" name="vertical9<%=i+1%>" value="<%=row.getVertical()%>" size="4" onBlur="_onblur(this)" styleId="vertical<%=i+1%>"></td>
                <td class="text" align="center"><input type="text" name="cross9<%=i+1%>" value="<%=row.getCross()%>" size="4" onBlur="_onblur(this)" styleId="cross<%=i+1%>"></td>
            </tr>

            <%}%>
            </table>
            </td>

            <td class="probelv">
            <img src="/images/points_vert.gif" width="1" height="1" border="0" alt="">
            </td>

            <td align="center">
            <table class="main2" border="0">
            <%for(int i = arLen/4; i < arLen/4+31; i++){
                ChanalPowers row = chanalPower[i];
            %>
            <tr>
                <td class="text" align="center"><input type="text" name="chanal9<%=row.getChanal()%>" value="<%=row.getChanal()%>" size="4"  readonly="true" style="background-color:DCDCDC; color:black"></td>
                <td class="text" align="center"><input type="text" name="vertical9<%=i+1%>" value="<%=row.getVertical()%>" size="4" onBlur="_onblur(this)" styleId="vertical<%=i+1%>"></td>
                <td class="text" align="center"><input type="text" name="cross9<%=i+1%>" value="<%=row.getCross()%>" size="4" onBlur="_onblur(this)" styleId="cross<%=i+1%>"></td>
            </tr>
            <%}%>
            </table>
            </td>

            <td class="probelv">
            <img src="/images/points_vert.gif" width="1" height="1" border="0" alt="">
            </td>

            <td align="center">
            <table class="main2" border="0">
            <%for(int i = arLen/4+31; i < arLen/4+62; i++){
                ChanalPowers row = chanalPower[i];
            %>
            <tr>
                <td class="text" align="center"><input type="text" name="chanal9<%=row.getChanal()%>" value="<%=row.getChanal()%>" size="4" readonly="true" style="background-color:DCDCDC; color:black"></td>
                <td class="text" align="center"><input type="text" name="vertical9<%=i+1%>" value="<%=row.getVertical()%>" size="4" onBlur="_onblur(this)" styleId="vertical<%=i+1%>"></td>
                <td class="text" align="center"><input type="text" name="cross9<%=i+1%>" value="<%=row.getCross()%>" size="4" onBlur="_onblur(this)" styleId="cross<%=i+1%>"></td>
            </tr>
            <%}%>
            </table>
            </td>

            <td class="probelv">
            <img src="/images/points_vert.gif" width="1" height="1" border="0" alt="">
            </td>

            <td align="center">
            <table class="main2" border="0">
            <%for(int i = arLen/4+62; i < arLen/4+93; i++){
                ChanalPowers row = chanalPower[i];
            %>
            <tr>
                <td class="text" align="center"><input type="text" name="chanal9<%=row.getChanal()%>" value="<%=row.getChanal()%>" size="4" readonly="true" style="background-color:DCDCDC; color:black"></td>
                <td class="text" align="center"><input type="text" name="vertical9<%=i+1%>" value="<%=row.getVertical()%>" size="4" onBlur="_onblur(this)" styleId="vertical<%=i+1%>"></td>
                <td class="text" align="center"><input type="text" name="cross9<%=i+1%>" value="<%=row.getCross()%>" size="4" onBlur="_onblur(this)" styleId="cross<%=i+1%>"></td>
            </tr>
            <%}%>
            </table>
            </td>

            </tr>
            </table>
        </td>
    </tr>
    <tr id="diapason1800" style="display:none">
        <td>

            <table class="main" border="0">

            <tr>

            <td align="center">
            <table class="main2" border="0">
            <tr class="title">
                <td class="title" rowspan="2" align="center"><B><bean:message key="chanalpower.edit.canal"/></B></td>
                <td class="title" colspan="2" align="center"><B><bean:message key="chanalpower.edit.polar"/></B></td>
            </tr>
            <tr class="title">
                <td class="title" align="center"><B><bean:message key="chanalpower.edit.vertical"/></B></td>
                <td class="title" align="center"><B><bean:message key="chanalpower.edit.cross"/></B></td>
            </tr>
            </table>
            </td>


            <td class="probelv">
            <img src="/images/points_vert.gif" width="1" height="1" border="0" alt="">
            </td>


            <td align="center">
            <table class="main2" border="0">
            <tr class="title">
                <td class="title" rowspan="2" align="center"><B><bean:message key="chanalpower.edit.canal"/></B></td>
                <td class="title" colspan="2" align="center"><B><bean:message key="chanalpower.edit.polar"/></B></td>
            </tr>
            <tr class="title">
                <td class="title" align="center"><B><bean:message key="chanalpower.edit.vertical"/></B></td>
                <td class="title" align="center"><B><bean:message key="chanalpower.edit.cross"/></B></td>
            </tr>
            </table>
            </td>

            <td class="probelv">
            <img src="/images/points_vert.gif" width="1" height="1" border="0" alt="">
            </td>

            <td align="center">
            <table class="main2" border="0">
            <tr class="title">
                <td class="title" rowspan="2" align="center"><B><bean:message key="chanalpower.edit.canal"/></B></td>
                <td class="title" colspan="2" align="center"><B><bean:message key="chanalpower.edit.polar"/></B></td>
            </tr>
            <tr class="title">
                <td class="title" align="center"><B><bean:message key="chanalpower.edit.vertical"/></B></td>
                <td class="title" align="center"><B><bean:message key="chanalpower.edit.cross"/></B></td>
            </tr>
            </table>
            </td>

            <td class="probelv">
            <img src="/images/points_vert.gif" width="1" height="1" border="0" alt="">
            </td>

            <td align="center">
            <table class="main2" border="0">
            <tr class="title">
                <td class="title" rowspan="2" align="center"><B><bean:message key="chanalpower.edit.canal"/></B></td>
                <td class="title" colspan="2" align="center"><B><bean:message key="chanalpower.edit.polar"/></B></td>
            </tr>
            <tr class="title">
                <td class="title" align="center"><B><bean:message key="chanalpower.edit.vertical"/></B></td>
                <td class="title" align="center"><B><bean:message key="chanalpower.edit.cross"/></B></td>
            </tr>
            </table>
            </td>

            </tr>
            </table>

            <table class="main" border="0">
            <july:separator/>
            </table>


            <table class="main" border="0">
            <tr>

            <%
            chanalPower = form.getChanalPower1800();
            arLen = chanalPower.length;%>

            <td align="center">
            <table class="main2" border="0">
            <%for(int i = 0; i < arLen/4; i++){
                ChanalPowers row = chanalPower[i];
            %>

            <tr>
                <td class="text" align="center"><input type="text" name="chanal18<%=row.getChanal()%>" value="<%=row.getChanal()%>" size="4" readonly="true" style="background-color:DCDCDC; color:black"></td>
                <td class="text" align="center"><input type="text" name="vertical18<%=i+1%>" value="<%=row.getVertical()%>" size="4" onBlur="_onblur(this)" styleId="vertical<%=i+1%>"></td>
                <td class="text" align="center"><input type="text" name="cross18<%=i+1%>" value="<%=row.getCross()%>" size="4" onBlur="_onblur(this)" styleId="cross<%=i+1%>"></td>
            </tr>

            <%}%>
            </table>
            </td>

            <td class="probelv">
            <img src="/images/points_vert.gif" width="1" height="1" border="0" alt="">
            </td>

            <td align="center">
            <table class="main2" border="0">
            <%for(int i = arLen/4; i < arLen/4+31; i++){
                ChanalPowers row = chanalPower[i];
            %>
            <tr>
                <td class="text" align="center"><input type="text" name="chanal18<%=row.getChanal()%>" value="<%=row.getChanal()%>" size="4"  readonly="true" style="background-color:DCDCDC; color:black"></td>
                <td class="text" align="center"><input type="text" name="vertical18<%=i+1%>" value="<%=row.getVertical()%>" size="4" onBlur="_onblur(this)" styleId="vertical<%=i+1%>"></td>
                <td class="text" align="center"><input type="text" name="cross18<%=i+1%>" value="<%=row.getCross()%>" size="4" onBlur="_onblur(this)" styleId="cross<%=i+1%>"></td>
            </tr>
            <%}%>
            </table>
            </td>

            <td class="probelv">
            <img src="/images/points_vert.gif" width="1" height="1" border="0" alt="">
            </td>

            <td align="center">
            <table class="main2" border="0">
            <%for(int i = arLen/4+31; i < arLen/4+62; i++){
                ChanalPowers row = chanalPower[i];
            %>
            <tr>
                <td class="text" align="center"><input type="text" name="chanal18<%=row.getChanal()%>" value="<%=row.getChanal()%>" size="4" readonly="true" style="background-color:DCDCDC; color:black"></td>
                <td class="text" align="center"><input type="text" name="vertical18<%=i+1%>" value="<%=row.getVertical()%>" size="4" onBlur="_onblur(this)" styleId="vertical<%=i+1%>"></td>
                <td class="text" align="center"><input type="text" name="cross18<%=i+1%>" value="<%=row.getCross()%>" size="4" onBlur="_onblur(this)" styleId="cross<%=i+1%>"></td>
            </tr>
            <%}%>
            </table>
            </td>

            <td class="probelv">
            <img src="/images/points_vert.gif" width="1" height="1" border="0" alt="">
            </td>

            <td align="center">
            <table class="main2" border="0">
            <%for(int i = arLen/4+62; i < arLen/4+93; i++){
                ChanalPowers row = chanalPower[i];
            %>
            <tr>
                <td class="text" align="center"><input type="text" name="chanal18<%=row.getChanal()%>" value="<%=row.getChanal()%>" size="4" readonly="true" style="background-color:DCDCDC; color:black"></td>
                <td class="text" align="center"><input type="text" name="vertical18<%=i+1%>" value="<%=row.getVertical()%>" size="4" onBlur="_onblur(this)" styleId="vertical<%=i+1%>"></td>
                <td class="text" align="center"><input type="text" name="cross18<%=i+1%>" value="<%=row.getCross()%>" size="4" onBlur="_onblur(this)" styleId="cross<%=i+1%>"></td>
            </tr>
            <%}%>
            </table>
            </td>

            </tr>
            </table>
        </td>
    </tr>
</table>



<table class="main" border="0">
<july:separator/>
</table>


<table class="main" border="1" style="border-top: White; border-bottom: White; border-left: White; border-right: White;">
<tr class="title"><td class="title" colspan="2"><bean:message key="chanalpower.edit.symbol"/></td></tr>

<tr><td style="background: #FF6347; border-color: Black;"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td style="border-top: White; border-bottom: White; border-left: White; border-right: White;"><bean:message key="chanalpower.edit.nouse"/></td></tr>

<tr><td style="background: Fuchsia; border-color: Black;"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td style="border-top: White; border-bottom: White; border-left: White; border-right: White;"><bean:message key="chanalpower.edit.limit4"/></td></tr>

<tr><td style="background: #1E90FF; border-color: Black;"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td style="border-top: White; border-bottom: White; border-left: White; border-right: White;"><bean:message key="chanalpower.edit.limit8"/></td></tr>

<tr><td style="background: Aqua; border-color: Black;"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td style="border-top: White; border-bottom: White; border-left: White; border-right: White;"><bean:message key="chanalpower.edit.limit12"/></td></tr>

<tr><td style="background: White; border-color: Black;"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td style="border-top: White; border-bottom: White; border-left: White; border-right: White;"><bean:message key="chanalpower.edit.limit20"/></td></tr>

<tr><td style="background: White; border-color: Black;">35</td>
<td style="border-top: White; border-bottom: White; border-left: White; border-right: White;"><bean:message key="chanalpower.edit.noise"/></td></tr>

</table>

<table class="main">
<july:separator/>

<july:formbuttons/>

<july:separator/>

<%-- DD
	<tr class="title">
    	<td class="title" colspan="2">
			<html:link page="/ShowBaseStationList.do" styleClass="navigator">
				Базовые станции
			</html:link>
		   <july:sepmark/>

			<html:link page="<%=returnPage%>" paramId="basestation" paramName="<%=beanName%>" paramProperty="basestation" styleClass="navigator">
				Просмотр БС
			</html:link>
			<july:sepmark/>

		   <july:currmark><bean:message key="chanalpower.edit.title.nav"/></july:currmark></td>
    </tr>
    <july:separator/>
--%>
</table>

</july:editform>

<script type="text/javascript" language="JavaScript">
<!--
var ar9 = new Array();
var ar18 = new Array();
<%ShowChanalPowerForm form = (ShowChanalPowerForm)request.getAttribute("ShowChanalPower");
int arLen = form.getChanalPower900().length;
for(int i = 0, j=1; i < arLen*2; i++,j++){
	out.println("ar9["+i+"]=document.all.vertical9"+j+"; ");
	out.println("ar9["+(++i)+"]=document.all.cross9"+j+"; ");
}
arLen = form.getChanalPower1800().length;
for(int i = 0, j=1; i < arLen*2; i++,j++){
	out.println("ar18["+i+"]=document.all.vertical18"+j+"; ");
	out.println("ar18["+(++i)+"]=document.all.cross18"+j+"; ");
}
%>

styles(ar9);
styles(ar18);
init();

-->
</script>