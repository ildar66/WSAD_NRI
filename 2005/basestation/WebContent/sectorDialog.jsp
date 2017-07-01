<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.basestation.*,com.hps.july.basestation.formbean.*"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "4"; %>

<%
	String action = "/ProcessSectorDialog.do";
	String form = "SectorDialogForm";
	String src = "/images/save.gif";
	String alt = "Сохранить запись";
%>
<july:errors property="org.apache.struts.action.GLOBAL_ERROR"/>

<logic:equal name="<%= form %>" property="action" value="Delete">
		<% src = "/images/delconf.gif"; alt = "Удалить запись"; %>
</logic:equal>

<july:editform action="<%= action %>" styleId="<%= form %>">
<html:hidden property="id_sect"/>
<html:hidden property="bsName"/>
<html:hidden property="prefixCelliD"/>

<script language="javascript">
	function Close()
		{
			if(window.opener) {
				opener.storeSelectedRow('sectorsID', document.all.id_sect.value);
				//window.opener.window.location.href=window.opener.window.location.href;
				opener.document.forms(0).submit();
				if(window.opener.window.opener){
					window.opener.window.opener.window.location.href=window.opener.window.opener.window.location.href;
				}
				window.opener.focus();
			}
			window.close();
		}
var letters = new Array('', 'A','B','C','D','E','F','G','O','A','B','C','D','O','E','F','G','H','O');

function recalcLac() {
	var l = parseInt(document.all.lac.value);
	if(l > 65535) {
		alert('Номер LAC должен быть числом от 0 до 65536!');
	} else {
		if(document.all.lac.value != '') {
			document.all.lachex.value = getHexLac();
			document.all.lachdx.value = getHdxLac();
		}
	}
}
function getHexLac() {
	return ((new Number(document.all.lac.value)).toString(16)).toUpperCase();
}
function getHdxLac() {
	var l = parseInt(document.all.lac.value);
	var h = (new Number(Math.floor(l / 0x100)).toString(16)).toUpperCase();
	var dd = Math.floor(l % 0x100);
	h += (Math.floor(dd / 100) % 10);
	h += (Math.floor(dd /10)%10);
	h += Math.floor(dd%10);
	return h;
}
function changeBand() {
	if(document.all.bandId.value == '800') {
		document.all.g900.style.display = 'none';
		document.all.g900.style.visibility = 'hidden';
		document.all.g1800.style.display = 'none';
		document.all.g1800.style.visibility = 'hidden';
		document.all.d800.style.display = 'inline-block';
		document.all.d800.style.visibility = 'visible';
	} else
	if(document.all.bandId.value == '900') {
		document.all.g1800.style.display = 'none';
		document.all.g1800.style.visibility = 'hidden';
		document.all.d800.style.display = 'none';
		document.all.d800.style.visibility = 'hidden';
		document.all.g900.style.display = 'inline-block';
		document.all.g900.style.visibility = 'visible';
	} else
	if(document.all.bandId.value == '1800') {
		document.all.g900.style.display = 'none';
		document.all.g900.style.visibility = 'hidden';
		document.all.d800.style.display = 'none';
		document.all.d800.style.visibility = 'hidden';
		document.all.g1800.style.display = 'inline-block';
		document.all.g1800.style.visibility = 'visible';
	} else {
		document.all.g900.style.display = 'none';
		document.all.g900.style.visibility = 'hidden';
		document.all.d800.style.display = 'none';
		document.all.d800.style.visibility = 'hidden';
		document.all.g1800.style.display = 'none';
		document.all.g1800.style.visibility = 'hidden';
	}
}
function setSectorName() {
//	document.all.namesect.value = document.all['bsForm.stationName'].value + '_' + letter;
	if(document.all.action.value == 'Add') {
		var l = document.all.lett;
		for(var i = 1; i < 19; i++) {
			if(l[i].checked) {
				document.all["vo.name_sect"].value = document.all['bsName'].value + '_' + letters[i];
				document.all["vo.num_sect"].value = document.all['prefixCelliD'].value + document.all.lett[i].value;
				document.all["vo.cellname"].value = document.all['index'].value + document.all['prefixCelliD'].value + document.all.lett[i].value;
				document.all["lettHelp"].value = document.all.lett[i].value;
			}
		}
	}
}
function showHelp(){
	if(indexRowID.style.getAttribute("display") == "none")
		indexRowID.style.setAttribute("display", "block");
	else
		indexRowID.style.setAttribute("display", "none");
}
function setNumberID(inField){
	var C = <%= form %>.index.value;
	var RR = <%= form %>.indexRR.value;
	var XX = <%= form %>.indexXX.value;
	var L = <%= form %>.lettHelp.value;
	if( RR.length == 0 || RR.length > 2){
		//alert("Введите индекс из справочника!");
		hrefStr ='Kzl_IndexDialog.do?positionID=<bean:write name="<%= form %>" property="positionID" filter="true"/>&formname=<%= form %>&fieldnames=indexRR';
		window.open(hrefStr, "KzlindexDialog", "top=200, left=200, width=420, height=300, scrollbars=yes, resizable=yes").focus(); 
		return;
	}else if (RR.length == 1){
		RR = '0' + RR;
	}
	if (L.length == 0){
		alert("не выбрана буква!!");
		return;
	}
	if (XX.length == 0){
		alert("Нет номера БС!");
		return;
	}else if (XX.length == 1){
		XX = '0' + XX;
	}
	if(inField == "CellID")
		document.all["vo.num_sect"].value = RR+XX+L;
	else if(inField == "CellName")
		document.all["vo.cellname"].value = C+RR+XX+L;
	indexRowID.style.setAttribute("display", "none");
}
function isDigits(s)
{
	for(var i = 0; i < s.length; i++)
		if(s.charAt(i) < '0' || s.charAt(i) > '9')
			return false;
	  
	return true;
}
</script>
<%--
<logic:present name="SectorDialogForm" property="vo">
--%>
<table class="main"  style="font-size:8pt;">

	<july:separator colspan="<%= gColSpan %>"/>
    <tr class="title">
    	<td class="title" colspan="<%= gColSpan %>">
			<INPUT TYPE="IMAGE" NAME="submit" SRC="<%= src%>"  ALT="<%= alt %>" onclick="document.body.style.cursor='wait';">&nbsp;
			<july:closebutton page="/"/>
        </td>
    </tr>
	<july:separator colspan="<%= gColSpan %>"/>

    <tr>
        <td class="title" colspan="<%= gColSpan %>"><july:actionalert/></td>
    </tr>

	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<td class="text">CellID:
<%--
			<A href='#' onclick='showHelp(); return false;'>
				<IMG SRC="/images/lookup.gif" BORDER='0' ALT='показать/спрятать справочник:'></A>
--%>
		</td>
		<td class="text">
			<july:string size="10" property="vo.num_sect" insertable="false" updatable="false"/>
		</td>
		<td class="text">CellName:
<%--
			<A href='#' onclick='showHelp(); return false;'>
				<IMG SRC="/images/lookup.gif" BORDER='0' ALT='показать/спрятать справочник:'></A>
--%>
		</td>
		<td class="text">
			<july:string size="10" property="vo.cellname" insertable="false" updatable="false"/>
		</td>
    </tr>

	<tr id="indexRowID">
		<td class="text">&nbsp;</td>
		<td colspan="3">
			<!-- Индекс региона: -->
			<july:string property="index" style="width: 20;" styleId="index" size="5" insertable="false" updatable="false" />
			<!-- Индекс области: -->
			<july:string property="indexRR" styleId="indexRR" size="5" insertable="false" updatable="false" />
<%--
			<A href='Kzl_IndexDialog.do?positionID=<bean:write name="<%= form %>" property="positionID" filter="true"/>&formname=<%= form %>&fieldnames=indexRR' onclick='window.open(this.href, "KzlindexDialog", "top=200, left=200, width=420, height=300, scrollbars=yes, resizable=yes").focus(); return false;'>
				<IMG SRC="/images/lookup.gif" BORDER='0' ALT='Список цифровых индексов областей'></A>
--%>
			<!-- № БС: -->
			<july:string property="indexXX" styleId="indexXX" size="5" insertable="false" updatable="false"/>
			<!-- lett -->
			<july:string property="lett" style="width: 20;" styleId="lettHelp" size="5" insertable="false" updatable="false" />
			<A href='#' onclick='setNumberID("CellID"); return false;'>Ввести CellID</A>
			<A href='#' onclick='setNumberID("CellName"); return false;'>Ввести CellName</A>
		</td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>

	<tr>
		<td class="text">Название:</td>
		<td class="text">
			<july:string size="20" property="vo.name_sect" insertable="false" updatable="false"/>
		</td>
		<td class="text">LAC:</td>
		<td class="text">
			<july:string size="5" property="vo.lac" insertable="true" updatable="true"/>
		</td>
    </tr>

	<july:separator colspan="<%= gColSpan %>"/>

	<tr>
		<td class="text">Диапазон:</td>
		<td class="text">
<%
	SectorDialogForm dForm=(SectorDialogForm)pageContext.findAttribute("SectorDialogForm");
	String s = ("Add".equals(dForm.getAction()))?"true":"false";
	String stD800 = "display:none;visibility:hidden;";
	String stG1800 = "display:none;visibility:hidden;";
	String stG900 = "display:none;visibility:hidden;";
	int band = dForm.getVo().getBand().intValue();
	if(band == 800) {
		stD800 = "display:inline-block;visibility:visible;";
	} else if(band == 1800) {
		stG1800 = "display:inline-block;visibility:visible;";
	} else if(band == 900) {
		stG900 = "display:inline-block;visibility:visible;";
	}
%>
			<july:select property="vo.band" styleId="bandId" insertable="true" updatable="<%=s%>" styleClass="editsmall" onchange="changeBand();" style="width:50pt;">
				<logic:equal name="<%= form %>" property="stationType" value="D" >
					<html:option value="800">800</html:option>
				</logic:equal>
				<logic:notEqual name="<%= form %>" property="stationType" value="D" >
					<html:option value="900">900</html:option>
					<html:option value="1800">1800</html:option>
				</logic:notEqual>
			</july:select>
		<span id="d800" style="<%=stD800%>">
			<july:radio styleClass="editradio" property="lett" value="1" insertable="<%=s%>" updatable="<%=s%>" onclick="setSectorName();"/>A
			<july:radio styleClass="editradio" property="lett" value="2" insertable="<%=s%>" updatable="<%=s%>" onclick="setSectorName();"/>B
			<july:radio styleClass="editradio" property="lett" value="3" insertable="<%=s%>" updatable="<%=s%>" onclick="setSectorName();"/>C
			<july:radio styleClass="editradio" property="lett" value="4" insertable="<%=s%>" updatable="<%=s%>" onclick="setSectorName();"/>D
			<july:radio styleClass="editradio" property="lett" value="5" insertable="<%=s%>" updatable="<%=s%>" onclick="setSectorName();"/>E
			<july:radio styleClass="editradio" property="lett" value="6" insertable="<%=s%>" updatable="<%=s%>" onclick="setSectorName();"/>F
			<july:radio styleClass="editradio" property="lett" value="7" insertable="<%=s%>" updatable="<%=s%>" onclick="setSectorName();"/>G
			<july:radio styleClass="editradio" property="lett" value="0" insertable="<%=s%>" updatable="<%=s%>" onclick="setSectorName();"/>O
		</span>
		<span id="g1800" style="<%=stG1800%>">
			<july:radio styleClass="editradio" property="lett" value="1" insertable="<%=s%>" updatable="<%=s%>" onclick="setSectorName();"/>A
			<july:radio styleClass="editradio" property="lett" value="2" insertable="<%=s%>" updatable="<%=s%>" onclick="setSectorName();"/>B
			<july:radio styleClass="editradio" property="lett" value="3" insertable="<%=s%>" updatable="<%=s%>" onclick="setSectorName();"/>C
			<july:radio styleClass="editradio" property="lett" value="4" insertable="<%=s%>" updatable="<%=s%>" onclick="setSectorName();"/>D
			<july:radio styleClass="editradio" property="lett" value="0" insertable="<%=s%>" updatable="<%=s%>" onclick="setSectorName();"/>O
		</span>
		<span id="g900" style="<%=stG900%>">
			<july:radio styleClass="editradio" property="lett" value="5" insertable="<%=s%>" updatable="<%=s%>" onclick="setSectorName();"/>E
			<july:radio styleClass="editradio" property="lett" value="6" insertable="<%=s%>" updatable="<%=s%>" onclick="setSectorName();"/>F
			<july:radio styleClass="editradio" property="lett" value="7" insertable="<%=s%>" updatable="<%=s%>" onclick="setSectorName();"/>G
			<july:radio styleClass="editradio" property="lett" value="8" insertable="<%=s%>" updatable="<%=s%>" onclick="setSectorName();"/>H
			<july:radio styleClass="editradio" property="lett" value="9" insertable="<%=s%>" updatable="<%=s%>" onclick="setSectorName();"/>O
		</span>			
		</td>
		<td class="text">Тип сектора:</td>
		<td class="text">
			<july:select property="vo.conf" styleId="confId" insertable="true" updatable="true" styleClass="editsmall"  style="width:120pt;">
				<html:option value=""></html:option>
				<html:option value="1">Макросота (normal)</html:option>
				<html:option value="2">Макросота (umbrella)</html:option>
				<html:option value="3">Микросота (in door)</html:option>
				<html:option value="4">Микросота (out door)</html:option>
			</july:select>			
		</td>
    </tr>

	<july:separator colspan="<%= gColSpan %>"/>

	<tr>
		<td class="text">Азимут:</td>
		<td class="text">
			<july:string property="azimutStr" size="10" insertable="true" updatable="true" />
		</td>
		<td class="text">Номер BTS:</td>
		<td class="text">
			<july:string size="5" property="vo.bts_number" insertable="true" updatable="true"/>
		</td>
    </tr>

	<july:separator colspan="<%= gColSpan %>"/>

	<tr>
		<td class="text">Подключение к A-bis:</td>
		<td class="text">
			<july:select property="vo.con_abis" styleId="con_abisId" insertable="true" updatable="true" styleClass="editsmall">
				<html:option value="1">Звезда</html:option>
				<html:option value="2">Кольцо</html:option>
				<html:option value="3">Цепь</html:option>
			</july:select>			
		</td>
		<td class="text">Наличие фильтра:</td>
		<td class="text">
			<july:checkbox property="vo.has_flt" insertable="true" updatable="true" />
		</td>
    </tr>

	<july:separator colspan="<%= gColSpan %>"/>

	<tr>
		<td class="text">Номер A-Bis порта:</td>
		<td class="text">
			<july:string property="vo.port_abis" size="10" insertable="true" updatable="true" />		
		</td>
		<td class="text">Наличие МШУ:</td>
		<td class="text">
			<july:checkbox property="vo.has_lna" insertable="true" updatable="true" />
		</td>
    </tr>

	<july:separator colspan="<%= gColSpan %>"/>

	<tr>
		<td class="text">Номер версии ПО:</td>
		<td class="text">
			<july:string property="vo.num_po" size="10" insertable="true" updatable="true" />		
		</td>
		<td class="text">Наличие бустера:</td>
		<td class="text">
			<july:checkbox property="vo.has_buster" insertable="true" updatable="true" />
		</td>
    </tr>

	<july:separator colspan="<%= gColSpan %>"/>

	<tr>
		<td class="text">Число TRX:</td>
		<td class="text">
			<july:string property="vo.trx_num" size="10" insertable="true" updatable="true" />		
		</td>
		<td class="text">Наличие HR:</td>
		<td class="text">
			<july:checkbox property="vo.is_hr" insertable="true" updatable="true" />
		</td>
    </tr>

	<july:separator colspan="<%= gColSpan %>"/>

	<tr>
		<td class="text">Мощность на вых. трансивера:</td>
		<td class="text">
			<july:string property="tx_pwrStr" size="10" insertable="true" updatable="true" />		
		</td>
		<td class="text">Наличие GPRS:</td>
		<td class="text">
			<july:checkbox property="vo.cap_gprs" insertable="true" updatable="true" />
		</td>
    </tr>

	<july:separator colspan="<%= gColSpan %>"/>

	<tr>
		<td class="text">Источник ввода данных:</td>
		<td class="text">
			<july:string property="vo.datasourceStr" size="15" insertable="false" updatable="false" />	
		</td>
		<td class="text">Наличие двухдиапазонного комбайнера:</td>
		<td class="text">
			<july:checkbox property="vo.ddk" insertable="true" updatable="true" />
		</td>
    </tr>

	<july:separator colspan="<%= gColSpan %>"/>
    <tr class="title">
    	<td class="title" colspan="<%= gColSpan %>">
			<INPUT TYPE="IMAGE" NAME="submit" SRC="<%= src%>"  ALT="<%= alt %>" styleID="submitID" onclick="document.body.style.cursor='wait';">&nbsp;
			<july:closebutton page="/"/>
        </td>
    </tr>
	<july:separator colspan="<%= gColSpan %>"/>

</table>
<%--
</logic:present>
--%>
<logic:equal name="SectorDialogForm" property="flagOperation" value="true">
	<script language="javascript" type="text/javascript">
		 Close();
	</script>
</logic:equal>
<script language="javascript">
	//changeBand();
	//setSectorName();
	indexRowID.style.setAttribute("display", "none");
</script>
</july:editform>
