<%@ page language = "java" %>
<%@ page import="org.apache.struts.util.*" contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<% java.lang.String gColSpan = "8"; %>

<july:browseform action="/PositionOnmap" styleId="PosForm">
<script language="JavaScript">
	document.body.style.cursor="wait";
</script>
<script language="JavaScript">
function labelChange() {
		document.all.changelabel.value = 'true';
		document.forms(0).submit()
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
function zoom_onchange(val){
	document.PosForm.zoom.value = val;
}
</script>
<table class="main">

<%-- DD
<tr class="title">
	<td class="title">
<html:link page="/ShowBaseStationList.do" styleClass="navigator"><bean:message key="label.position"/> </html:link>&nbsp;
<july:sepmark/>
<july:currmark><bean:message key="label.menu.map"/></july:currmark></td>
</tr>
--%>

<july:separator colspan="<%= gColSpan %>" />

<TR class="normal">
<TD colspan="<%= gColSpan %>">

<table class="find">
<tr>
	<td class="title">
<bean:message key="label.position.positionAndComlines"/></td>
</tr>
<%--<tr>
<td class="title"><SPAN style="height: 16; font-size:8pt; vertical-align: bottom; padding-top: 0; padding-bottom: 0; margin-top: 0; margin-bottom: 0;">
<july:radio styleClass="editcheckbox" property="label" value="posnumber" insertable="true" updatable="true" /><bean:message key="label.map.posnumber"/>&nbsp;
<july:radio styleClass="editcheckbox" property="label" value="posname" insertable="true" updatable="true" /><bean:message key="label.map.posname"/>&nbsp;
<july:radio styleClass="editcheckbox" property="label" value="posnothing" insertable="true" updatable="true" /><bean:message key="label.map.posnothing"/></span>&nbsp;&nbsp;&nbsp;<july:searchbutton/>
</td></tr>--%>
<tr>
<td class="title"><SPAN style="height: 16; font-size:8pt; vertical-align: bottom; padding-top: 0; padding-bottom: 0; margin-top: 0; margin-bottom: 0;">
<image src="/images/_g16.gif">&nbsp;<bean:message key="label.legend.gsm"/>&nbsp;&nbsp;&nbsp;
<image src="/images/_d16.gif">&nbsp;<bean:message key="label.legend.damps"/>&nbsp;&nbsp;&nbsp;
<image src="/images/_p16.gif">&nbsp;<bean:message key="label.legend.position"/>&nbsp;&nbsp;&nbsp;
<image src="/images/_c17.gif">&nbsp;<bean:message key="label.legend.controller"/>
</span>
</td></tr>
</table>
</td></tr>

<tr class="title">
 <td><table class="buttons">
<tr class="title">
<td  class="buttons" style="width: 42%;"><SPAN style="height: 16; font-size:8pt; vertical-align: bottom; padding-top: 0; padding-bottom: 0; margin-top: 0; margin-bottom: 0;"><july:backbutton 
  page="/ShowBaseStationList.do"/></span>&nbsp;<img src="/images/uvelichit.gif" border="0" onClick="Button_Click('zoomIn')" alt="<bean:message key="label.menu.map.zoomIn"/>" style="vertical-align: middle;">&nbsp;<img
  src="/images/umensh.gif" border="0" onClick="Button_Click('zoomOut')" alt="<bean:message key="label.menu.map.zoomOut"/>" style="vertical-align: middle;">&nbsp;<img 
  src="/images/center.gif" border="0" onClick="Button_Click('recenter')" alt="<bean:message key="label.menu.map.recenter"/>" style="vertical-align: middle;">&nbsp;<img 
  src="/images/lookup.gif" border="0" onClick="Button_Click('position')" alt="<bean:message key="label.menu.map.info"/>" style="vertical-align: middle;"><SPAN style="height: 16; font-size:8pt; vertical-align: bottom; padding-top: 0; padding-bottom: 0; margin-top: 0; margin-bottom: 0;">&nbsp;<bean:message key="label.menu.map.scale"/>&nbsp;<input
  type="text" name="zooms" value="<bean:write name="PositionOnMapForm" property="zoom"/>" size="3" VSPACE=0 HEIGHT=16 style="font-size:8pt; text-align: right; height:16; padding-top: 0; padding-bottom: 0; margin-top: 0; margin-bottom: 0;" onChange="zoom_onchange(document.PosForm.zooms.value)"></SPAN></td><td id="placeForText1" style="font-size:8pt; text-align: left;">&nbsp;</td>
</tr>
<tr class="title">
<td class="buttons" colspan='2'><SPAN style="height: 16; font-size:8pt; vertical-align: bottom; padding-top: 0; padding-bottom: 0; margin-top: 0; margin-bottom: 0;">
<july:radio style="background-color: AAD1F6;" property="label" value="posnumber" insertable="true" updatable="true" onclick="labelChange()"/><bean:message key="label.map.posnumber"/>&nbsp;&nbsp;&nbsp;&nbsp;
<july:radio style="background-color: AAD1F6;" property="label" value="posname" insertable="true" updatable="true" onclick="labelChange()"/><bean:message key="label.map.posname"/>&nbsp;&nbsp;&nbsp;&nbsp;
<july:radio style="background-color: AAD1F6;" property="label" value="posnothing" insertable="true" updatable="true" onclick="labelChange()"/><bean:message key="label.map.posnothing"/></span>
</td></tr>
</table>

<input type="hidden" name="changelabel" value="false">
<html:hidden property="whatToDo"/>
<html:hidden property="zoom"/>
<%
String x = request.getParameter("mapimage.x");
String y = request.getParameter("mapimage.y");
String whatToDo = request.getParameter("whatToDo");
%>
</td></tr>
<july:separator colspan="<%= gColSpan %>" />
<tr><td>
<input type="image" src="mapByPosition?mapimage.x=<%=x%>&mapimage.y=<%=y%>&whatToDo=<%=whatToDo%>" name="mapimage" onLoad="changeCursor()">
</td></tr>
<july:separator colspan="<%= gColSpan %>" />
<tr class="title">
 <td><table class="buttons">
<tr class="title">
<td  class="buttons" style="width: 42%;"><SPAN style="height: 16; font-size:8pt; vertical-align: bottom; padding-top: 0; padding-bottom: 0; margin-top: 0; margin-bottom: 0;"><july:backbutton 
  page="/ShowBaseStationList.do"/></span>&nbsp;<img src="/images/uvelichit.gif" border="0" onClick="Button_Click('zoomIn')" alt="<bean:message key="label.menu.map.zoomIn"/>" style="vertical-align: middle;">&nbsp;<img
  src="/images/umensh.gif" border="0" onClick="Button_Click('zoomOut')" alt="<bean:message key="label.menu.map.zoomOut"/>" style="vertical-align: middle;">&nbsp;<img 
  src="/images/center.gif" border="0" onClick="Button_Click('recenter')" alt="<bean:message key="label.menu.map.recenter"/>" style="vertical-align: middle;">&nbsp;<img 
  src="/images/lookup.gif" border="0" onClick="Button_Click('position')" alt="<bean:message key="label.menu.map.info"/>" style="vertical-align: middle;"><SPAN style="height: 16; font-size:8pt; vertical-align: bottom; padding-top: 0; padding-bottom: 0; margin-top: 0; margin-bottom: 0;">&nbsp;<bean:message key="label.menu.map.scale"/>&nbsp;<input
  type="text" name="zooms2" value="<bean:write name="PositionOnMapForm" property="zoom"/>" size="3" VSPACE=0 HEIGHT=16 style="font-size:8pt; text-align: right; height:16; padding-top: 0; padding-bottom: 0; margin-top: 0; margin-bottom: 0;" onChange="zoom_onchange(document.PosForm.zooms2.value)"></SPAN></td><td  id="placeForText2" style="font-size:8pt; text-align: left;">&nbsp;</td>
</tr>
</table></td></tr>
<july:separator colspan="<%= gColSpan %>" />

<%-- DD
<tr class="title">
	<td class="title" colspan="<%= gColSpan %>">
<html:link page="/ShowBaseStationList.do" styleClass="navigator"><bean:message key="label.position"/> </html:link>&nbsp;
<bean:message key="label.position.positionAndComlines"/>
</td>
</tr>
--%>

</table>





</july:browseform>








<%--<%


com.hps.july.siteinfo.formbean.PositionOnMapForm parMap = (com.hps.july.siteinfo.formbean.PositionOnMapForm) session.getAttribute("PositionOnMapForm");


String action = parMap.getWhatToDo();


%>--%>


<script language="javascript">


var action='<bean:write name="PositionOnMapForm" property="whatToDo" scope="session"/>';


if(action == 'null' || action == 'nothing' ){


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


</script>