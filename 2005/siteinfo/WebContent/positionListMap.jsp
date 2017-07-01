<%@ page language = "java" %>
<%@ page import="java.util.*,com.hps.july.siteinfo.formbean.MapForm" contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="WEB-INF/july.tld" prefix="july" %>
<% java.lang.String gColSpan = "8"; %>

<july:browseform action="/PositionListMap.do" styleId="PosForm" onsubmit="_onsubmit()">
<script language="JavaScript">
	document.body.style.cursor="wait";

function _onsubmit(){
/*	PosForm.imageFromCache.value = false;  */
	if(document.all.frommap.value == '1'){
		PosForm.buttonFind.value = false;
	} else {
		PosForm.buttonFind.value = true;
	}
	
//	alert("document.all.frommap.value="+document.all.frommap.value+"; PosForm.buttonFind.value="+PosForm.buttonFind.value);
}
function labelChange() {
		document.all.changelabel.value = 'true';
		PosForm.buttonFind.value = false;
		//PosForm.imageFromCache.value = false;		
		document.forms(0).submit();
}
function _onmouseout(){
	document.body.style.cursor='auto';
}
function _onmouseover(){
	document.body.style.cursor='hand';
}
function switchNetZoneSearch() {
	if(document.MapForm.allZone[0].checked==true) {
		PosForm.netzone.className = 'editbigdisabled';
		document.MapForm.netzone.disabled = true;
	} else {
		PosForm.netzone.className = 'editbigsearch';
		document.MapForm.netzone.disabled = false;
		}
}
function switchAllSearch() {
	if(document.MapForm.allSuite[0].checked) {
		document.MapForm.damps[0].disabled = true;
		document.MapForm.gsm[0].disabled = true;
		document.MapForm.dcs[0].disabled = true;
		document.MapForm.damps[0].checked = false;
		document.MapForm.gsm[0].checked = false;
		document.MapForm.dcs[0].checked = false;
		document.MapForm.controllers[0].disabled = true;
		document.MapForm.controllers[0].checked = false;
	} else {
		document.MapForm.damps[0].disabled = false;
		document.MapForm.gsm[0].disabled = false;
		document.MapForm.dcs[0].disabled = false;
		document.MapForm.controllers[0].disabled = false;
		document.MapForm.damps[0].checked = true;
		document.MapForm.gsm[0].checked = true;
		document.MapForm.dcs[0].checked = true;
		document.MapForm.controllers[0].checked = true;
	}
}
function switchWorkerSearch() {
	if(document.MapForm.responsibleAll[0].checked==true){
		PosForm.workerID.className = 'editkoddisabled';
		document.MapForm.workerID.disabled = true;
	} else {
			PosForm.workerID.className = 'editkodsearch';
			document.MapForm.workerID.disabled = false;
		}
}
function Button_Click(action){
		if(action=="zoomIn"){
			document.PosForm.whatToDo.value="zoomIn";
			document.all.placeForText1.innerHTML='<bean:message key="label.mode"/><bean:message key="label.menu.map.zoomIn"/>';
			document.all.placeForText2.innerHTML='<bean:message key="label.mode"/><bean:message key="label.menu.map.zoomIn"/>';
		} else if(action=="zoomOut"){
			document.all.placeForText1.innerHTML='<bean:message key="label.mode"/><bean:message key="label.menu.map.zoomOut"/>';
			document.all.placeForText2.innerHTML='<bean:message key="label.mode"/><bean:message key="label.menu.map.zoomOut"/>';
			document.PosForm.whatToDo.value="zoomOut";
		} else if(action=="recenter"){
			document.all.placeForText1.innerHTML='<bean:message key="label.mode"/><bean:message key="label.menu.map.recenter"/>';
			document.all.placeForText2.innerHTML='<bean:message key="label.mode"/><bean:message key="label.menu.map.recenter"/>';
			document.PosForm.whatToDo.value="recenter";
		} else if(action=="position"){
			document.all.placeForText1.innerHTML='<bean:message key="label.mode"/><bean:message key="label.menu.map.info"/>';
			document.all.placeForText2.innerHTML='<bean:message key="label.mode"/><bean:message key="label.menu.map.info"/>';
			document.PosForm.whatToDo.value="position";
		}
}
function switchTypes(){
		if(document.MapForm.damps[0].checked==false && document.MapForm.gsm[0].checked==false &&
		document.MapForm.dcs[0].checked==false && document.MapForm.controllers[0].checked==false){
			document.MapForm.allSuite[0].checked = true;
			switchAllSearch();
		}
}
function zoom_onchange(val){
	if(val <= 0) val = 1;
	else if(val > 100) val = 100;
	document.all.zooms.value = val;
	document.PosForm.zoom.value = val;
}
function disableAll(tt, ar){
	var check = tt.checked;
	for(i=0; i<ar.length; i++)
		for(j=0; j<document.forms[0].elements.length; j++)
			if(document.forms[0].elements[j].name == ar[i]){
				document.forms[0].elements[j].disabled=check;
				break;
			}
	document.all.comlinesRRL[0].checked = false;
	document.all.comlinesRRL[0].disabled = check;
	document.all.comlinesVOLS[0].checked = false;//!check
	document.all.comlinesVOLS[0].disabled = check;
}
</script>

<table class="main">
<july:separator colspan="<%= gColSpan %>" />
<TR class="normal">
 <TD colspan="<%= gColSpan %>">
<TABLE class="find">
<tr>
<td  class="title"><bean:message key="label.position.netzonename"/></td>
<td  class="title">
	<july:checkbox property="allZone" insertable="true" updatable="true"  onclick="switchNetZoneSearch()" /> &nbsp;	<bean:message key="label.position.search.all"/>&nbsp;
	<july:select collection="netzones" property="netzone" insertable="true" updatable="true" 		 styleId="netzone">
		<html:options collection="netzones" property="netzone" labelProperty="name"/>
	</july:select>&nbsp;
	<july:searchbutton/></td>
</tr>
<tr>
<td  class="title">
	<bean:message key="label.position.suiteEquipment"/></td>
<td  class="title">
	<july:checkbox property="allSuite" insertable="true" updatable="true" onclick="switchAllSearch()"/>&nbsp;
	<bean:message key="label.position.search.all" />&nbsp;
	<july:checkbox property="damps" insertable="true" updatable="true" onclick="switchTypes()"/>&nbsp;
	<bean:message key="label.position.suiteEquipment.damps"/>&nbsp;
	<july:checkbox property="gsm" insertable="true" updatable="true" onclick="switchTypes()"/>&nbsp;
	<bean:message key="label.position.suiteEquipment.gsm"/>&nbsp;
	<july:checkbox property="dcs" insertable="true" updatable="true" onclick="switchTypes()"/>&nbsp;
	<bean:message key="label.position.suiteEquipment.dcs"/>&nbsp;
	<july:checkbox property="controllers" insertable="true" updatable="true" onclick="switchTypes()"/>&nbsp;
	<bean:message key="label.position.controllers"/>
	</td>
</tr>

<script language="javascript">
if(document.MapForm.allSuite[0].checked) {
		document.MapForm.damps[0].disabled = true;
		document.MapForm.gsm[0].disabled = true;
		document.MapForm.dcs[0].disabled = true;
}
if(document.MapForm.allZone[0].checked) {document.MapForm.netzone.disabled = true;}
</script>
<tr>
<td  class="title"><%--Ответственный--%>
	<bean:message key="label.position.worker"/></td>
<td  class="title">
	<july:checkbox property="responsibleAll" insertable="true" updatable="true" onclick="switchWorkerSearch()" /> &nbsp; 
	<bean:message key="label.position.search.all"/>&nbsp;
	<july:string property="workerID" styleId="workerID" size="5" insertable="true" updatable="false" />
	<july:lookupbutton action="/ShowWorkerLookupList.do" styleId="wrkl" fieldNames="workerID;workername" insertable="true" updatable="false" />
	<july:string size="25" property="workername" styleId="workername"  insertable="false" updatable="false" /></td>
</tr>

<tr>
<td  class="title">
	<bean:message key="label.streetname"/></td>
<td  class="title">
	<bean:message key="label.on"/>&nbsp;<july:checkbox property="bystreet" insertable="true" updatable="true" onclick="disableAll(this, new Array('bysybway', 'subway'))" /> &nbsp; 
	<july:string property="street" styleId="street" size="15" insertable="false" updatable="false" />
	<july:lookupbutton action="/ShowStreetLookupList.do" styleId="strs" onclick="set_opt_params_strs('?street='+document.all.street.value)" fieldNames="street" insertable="true" updatable="false" />
	</td><%--'allZone', 'netzone', 'responsibleAll', 'workerID', 'workername', 'comlinesRRL', 'comlinesVOLS', 'bysybway', 'subway'--%>
</tr>

<tr>
<td  class="title">
	<bean:message key="label.subway"/></td>
<td  class="title">
	<bean:message key="label.on"/>&nbsp;<july:checkbox property="bysybway" insertable="true" updatable="true" onclick="disableAll(this, new Array('bystreet', 'street'))" /> &nbsp; 
	<july:string property="subway" styleId="subway" size="15" insertable="false" updatable="false" 	/>
	<july:lookupbutton action="/ShowSubwayLookupList.do" styleId="subs" onclick="set_opt_params_subs('?subway='+document.all.subway.value)" fieldNames="subway" insertable="true" updatable="false" />
	</td><%--'allZone', 'netzone', 'responsibleAll', 'workerID', 'workername', 'comlinesRRL', 'comlinesVOLS', 'bystreet', 'street'--%>
</tr>

<tr>
<td  class="title"><%--Линии связи--%>
	<bean:message key="label.position.comline"/></td>


<td  class="title">


	<july:checkbox property="comlinesRRL" insertable="true" updatable="true"/>&nbsp;


	<bean:message key="label.position.comline.rrl"/>&nbsp;


	<july:checkbox property="comlinesVOLS" insertable="true" updatable="true"/>&nbsp;


	<bean:message key="label.position.comline.vols"/></td>


</tr>
<tr>
<td  class="title"><%--Способ отображения--%>
	<bean:message key="label.position.mapping"/></td>
<td  class="title">
	<july:radio property="mappingOnmap" value="mappingOnmap" insertable="true" updatable="true" />
	<bean:message key="label.position.mapping.onmap"/>&nbsp;
	<july:radio property="mappingOnmap" value="mappingSchema" insertable="true" updatable="true" />
	<bean:message key="label.position.mapping.schema"/></td>
</tr>
<td class="title" colspan="<%= gColSpan %>"><SPAN style="height: 16; font-size:8pt; vertical-align: bottom; padding-top: 0; padding-bottom: 0; margin-top: 0; margin-bottom: 0;">
<image src="/images/_g16.gif">&nbsp;<bean:message key="label.legend.gsm"/>&nbsp;&nbsp;&nbsp;
<image src="/images/_d16.gif">&nbsp;<bean:message key="label.legend.damps"/>&nbsp;&nbsp;&nbsp;
<image src="/images/_p16.gif">&nbsp;<bean:message key="label.legend.position"/>&nbsp;&nbsp;&nbsp;
<image src="/images/_c17.gif">&nbsp;<bean:message key="label.legend.controller"/>&nbsp;&nbsp;&nbsp;
<image src="/images/blue.gif">&nbsp;<bean:message key="label.legend.rrl"/>&nbsp;&nbsp;&nbsp;
<image src="/images/cyan.gif">&nbsp;<bean:message key="label.legend.vols"/>
</span>
</td></tr>
</TABLE>

<july:separator colspan="<%= gColSpan %>" />
<tr class="title">
 <td><table class="buttons">

<tr class="title">
<td  class="buttons" style="width: 42%;"><SPAN style="height: 16; font-size:8pt; vertical-align: bottom; padding-top: 0; padding-bottom: 0; margin-top: 0; margin-bottom: 0;"><july:backbutton 
  page="/main.do"/></span>&nbsp;<img src="/images/uvelichit.gif" border="0" onMouseOver="_onmouseover()" onMouseOut="_onmouseout()" onClick="Button_Click('zoomIn')" alt='<bean:message key="label.menu.map.zoomIn"/>' style="vertical-align: middle;">&nbsp;<img 
  src="/images/umensh.gif" border="0" onMouseOver="_onmouseover()" onMouseOut="_onmouseout()" onClick="Button_Click('zoomOut')" alt='<bean:message key="label.menu.map.zoomOut"/>' style="vertical-align: middle;">&nbsp;<img 
  src="/images/center.gif" border="0" onMouseOver="_onmouseover()" onMouseOut="_onmouseout()" onClick="Button_Click('recenter')" alt='<bean:message key="label.menu.map.recenter"/>' style="vertical-align: middle;">&nbsp;<img 
  src="/images/lookup.gif" border="0" onMouseOver="_onmouseover()" onMouseOut="_onmouseout()" onClick="Button_Click('position')" alt='<bean:message key="label.menu.map.info"/>' style="vertical-align: middle;"><SPAN style="height: 16; font-size:8pt; vertical-align: bottom; padding-top: 0; padding-bottom: 0; margin-top: 0; margin-bottom: 0;">&nbsp;<bean:message key="label.menu.map.scale"/>&nbsp;<input
  type="text" name="zooms" value="<bean:write name="MapForm" property="zoom"/>" size="3" maxlength="3" VSPACE=0 HEIGHT=16 style="font-size:8pt; text-align: right; height:16; padding-top: 0; padding-bottom: 0; margin-top: 0; margin-bottom: 0;" onChange="zoom_onchange(document.PosForm.zooms.value)"></SPAN></td><td id="placeForText1" style="font-size:8pt; text-align: left;">&nbsp;</td>
</tr>

<tr class="title">
<td class="buttons" colspan='2'><SPAN style="height: 16; font-size:8pt; vertical-align: bottom; padding-top: 0; padding-bottom: 0; margin-top: 0; margin-bottom: 0;">
<july:radio style="background-color: AAD1F6;" property="label" value="posnumber" insertable="true" updatable="true" onclick="labelChange()"/><bean:message key="label.map.posnumber"/>&nbsp;&nbsp;&nbsp;&nbsp;
<july:radio style="background-color: AAD1F6;" property="label" value="posname" insertable="true" updatable="true" onclick="labelChange()"/><bean:message key="label.map.posname"/>&nbsp;&nbsp;&nbsp;&nbsp;
<july:radio style="background-color: AAD1F6;" property="label" value="posnothing" insertable="true" updatable="true" onclick="labelChange()"/><bean:message key="label.map.posnothing"/></span>
</td></tr>

</table></td></tr>

<input type="hidden" name="changelabel" value="false">
<input type="hidden" name="buttonFind" value="false">
<html:hidden property="whatToDo"/>
<html:hidden property="zoom"/>


<script language="javascript">
switchNetZoneSearch();
switchWorkerSearch();
</script>
<%
String x = request.getParameter("mapimage.x");
String y = request.getParameter("mapimage.y");
String whatToDo = request.getParameter("whatToDo");
%>
</td></tr>
<july:separator colspan="<%= gColSpan %>" />

<tr><td>
	<input type="image" src="mapimage?mapimage.x=<%=x%>&mapimage.y=<%=y%>&whatToDo=<%=whatToDo%>" name="mapimage"  onLoad="changeCursor()" onclick="document.all.frommap.value='1';">	
	<input type="hidden" id="frommap" value='0'>
<%--	<input type="hidden" name="imageFromCache" id="imageFromCache" value='true'>	--%>
</td></tr>

<july:separator colspan="<%= gColSpan %>" />
<tr class="title">
 <td><table class="buttons">
<tr class="title">
<td  class="buttons" style="width: 42%;"><SPAN style="height: 16; font-size:8pt; vertical-align: bottom; padding-top: 0; padding-bottom: 0; margin-top: 0; margin-bottom: 0;"><july:backbutton 
  page="/main.do"/></span>&nbsp;<img src="/images/uvelichit.gif" border="0" onMouseOver="_onmouseover()" onMouseOut="_onmouseout()" onClick="Button_Click('zoomIn')" alt='<bean:message key="label.menu.map.zoomIn"/>' style="vertical-align: middle;">&nbsp;<img 
  src="/images/umensh.gif" border="0" onMouseOver="_onmouseover()" onMouseOut="_onmouseout()" onClick="Button_Click('zoomOut')" alt='<bean:message key="label.menu.map.zoomOut"/>' style="vertical-align: middle;">&nbsp;<img 
  src="/images/center.gif" border="0" onMouseOver="_onmouseover()" onMouseOut="_onmouseout()" onClick="Button_Click('recenter')" alt='<bean:message key="label.menu.map.recenter"/>' style="vertical-align: middle;">&nbsp;<img 
  src="/images/lookup.gif" border="0" onMouseOver="_onmouseover()" onMouseOut="_onmouseout()" onClick="Button_Click('position')" alt='<bean:message key="label.menu.map.info"/>' style="vertical-align: middle;"><SPAN style="height: 16; font-size:8pt; vertical-align: bottom; padding-top: 0; padding-bottom: 0; margin-top: 0; margin-bottom: 0;">&nbsp;<bean:message key="label.menu.map.scale"/>&nbsp;<input
  type="text" name="zooms2" value="<bean:write name="MapForm" property="zoom"/>" size="3" VSPACE=0 HEIGHT=16 style="font-size:8pt; text-align: right; height:16; padding-top: 0; padding-bottom: 0; margin-top: 0; margin-bottom: 0;" onChange="zoom_onchange(document.PosForm.zooms2.value)"></SPAN></td><td  id="placeForText2" style="font-size:8pt; text-align: left;">&nbsp;</td>
</tr>
</table></td></tr>

</table>
</july:browseform>

<script language="javascript">
var action='<bean:write name="MapForm" property="whatToDo" scope="session"/>';
if(action == 'null' || action == 'first' ){
		document.all.placeForText1.innerHTML='<bean:message key="label.mode"/><bean:message key="label.map.nothing"/>';
		document.all.placeForText2.innerHTML='<bean:message key="label.mode"/><bean:message key="label.map.nothing"/>';
} else if(action =='zoomIn'){
			document.all.placeForText1.innerHTML='<bean:message key="label.mode"/><bean:message key="label.menu.map.zoomIn"/>';
			document.all.placeForText2.innerHTML='<bean:message key="label.mode"/><bean:message key="label.menu.map.zoomIn"/>';
} else if(action =='zoomOut'){
			document.all.placeForText1.innerHTML='<bean:message key="label.mode"/><bean:message key="label.menu.map.zoomOut"/>';
			document.all.placeForText2.innerHTML='<bean:message key="label.mode"/><bean:message key="label.menu.map.zoomOut"/>';
} else if(action =='recenter'){
			document.all.placeForText1.innerHTML='<bean:message key="label.mode"/><bean:message key="label.menu.map.recenter"/>';
			document.all.placeForText2.innerHTML='<bean:message key="label.mode"/><bean:message key="label.menu.map.recenter"/>';
} else if(action =='position'){
			document.all.placeForText1.innerHTML='<bean:message key="label.mode"/><bean:message key="label.menu.map.info"/>';
			document.all.placeForText2.innerHTML='<bean:message key="label.mode"/><bean:message key="label.menu.map.info"/>';
}
if(document.forms[0].bystreet[0].checked)
	disableAll(document.forms[0].bystreet[0], new Array('bysybway', 'subway'));
if(document.forms[0].bysybway[0].checked)
	disableAll(document.forms[0].bysybway[0], new Array('bystreet', 'street'));
</script>
