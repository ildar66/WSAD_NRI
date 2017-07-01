<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<script>
        function changeVis(proc, span) {
          if ( proc.value == 'hexagonUnloadAntens') {
              span[0].style.cssText = "visibility:visible; display:inline;";
			  span[1].style.cssText = "visibility:visible; display:inline;";
			  span[2].style.cssText = "visibility:visible; display:inline;";
			  span[3].style.cssText = "visibility:visible; display:inline;";

            }
          else {
              span[0].style.cssText = "visibility:hidden; display:none;";
			  span[1].style.cssText = "visibility:hidden; display:none;";
			  span[2].style.cssText = "visibility:hidden; display:none;";
			  span[3].style.cssText = "visibility:hidden; display:none;";
          }
        }

		function changeViss(proc){
			if ( proc.value == 'hexagonUnloadAntens') {
                document.all.merid.disabled=false;
				document.all.merid.style.backgroundColor='D6EBFF';
				document.all.recountCoord.disabled=false;
            }
			else {
				document.all.merid.disabled=true;
				document.all.merid.style.backgroundColor='DCDCDC';
				document.all.recountCoord.disabled=true;
			}
			var calcCoord = document.getElementById('calcCoord');
			var calcCoordTR = document.getElementById('calcCoordTR');
			if(calcCoord && calcCoordTR) {
				if(proc.value == 'hexagonLoadCoordinates') {
                    calcCoord.style.display = 'block';
                    calcCoordTR.style.display = 'block';
                } else {
                    calcCoord.style.display = 'none';
                    calcCoordTR.style.display = 'none';
                }
			}
			var HLC = document.getElementById('HLC');
			var HL = document.getElementById('HL');
			var HUA = document.getElementById('HUA');
			var HFC = document.getElementById('HFC');
			if(proc.value == 'hexagonLoadCoordinates') {
				HLC.style.visibility = 'visible';
				HL.style.visibility = 'hidden';
				HUA.style.visibility = 'hidden';
				HFC.style.visibility = 'hidden';
			} else {
				if(proc.value == 'hexagonloadtrx') {
                    HLC.style.visibility = 'hidden';
					HL.style.visibility = 'visible';
					HUA.style.visibility = 'hidden';
					HFC.style.visibility = 'hidden';
				} else {
					if(proc.value == 'hexagonUnloadAntens') {
						HLC.style.visibility = 'hidden';
						HL.style.visibility = 'hidden';
						HUA.style.visibility = 'visible';
						HFC.style.visibility = 'hidden';
					} else {
						if(proc.value == 'hexagonFreqConstraints') {
							HLC.style.visibility = 'hidden';
							HL.style.visibility = 'hidden';
							HUA.style.visibility = 'hidden';
							HFC.style.visibility = 'visible';
						}
					}
				}
			}

		}
</script>


<july:editform action="/ProcessExportFile.do">
<% String gColSpan = "2"; %>

<table class="main">
<%--<tr class="title">
	<td class="title" colspan="5">
		<july:currmark><bean:message key="label.export"/></july:currmark>
	</td>
</tr>--%>
  
<july:separator colspan="<%= gColSpan %>" />

<tr>
	<td class="text" width="30%">
		Процедура
	</td>
	<td class="text" width="70%">
        <table>
        <tr valign="middle" align="left" >
            <td width="20%" valign="middle" >
                <html:select property="proc" style="background-color: D6EBFF;" onchange="changeViss(document.all.proc);">
                    <html:option value="hexagonLoadCoordinates"><label title="Координаты секторов с указанием ориентации по азимуту">Coordinates</label></html:option>
                    <html:option value="hexagonloadtrx"><label title="Список используемых частот по секторам БС">Radio</label></html:option>
                    <html:option value="hexagonUnloadAntens"><label title="Информация по секторам БС">Antenna</label></html:option>
                    <html:option value="hexagonFreqConstraints"><label title="Запрещенные частоты внутри разрешенного диапазона">FreqConstraints</label></html:option>
                </html:select>
            </td>
            <td width="80%" valign="middle" >
                <div style="position:absolute;height:100%;width:100%;align:center;valign:middle">
                    <div id="HLC" style="valign:middle;align:center;height:100%;width:100%;position:absolute;top:0px;left:0px;font-size:10px;visibility:visible">Координаты секторов с указанием ориентации по азимуту<div>
                    <div id="HL" style="valign:middle;align:center;height:100%;width:100%;position:absolute;top:0px;left:0px;font-size:10px;visibility:hidden">Список используемых частот по секторам БС<div>
                    <div id="HUA" style="valign:middle;align:center;height:100%;width:100%;position:absolute;top:0px;left:0px;font-size:10px;visibility:hidden">Информация по секторам БС<div>
                    <div id="HFC" style="valign:middle;align:center;height:100%;width:100%;position:absolute;top:0px;left:0px;font-size:10px;visibility:hidden">Запрещенные частоты внутри разрешенного диапазона<div>
                <div>
            </td>
        </tr>
        </table>
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>" />
    
<tr>
	<td class="text" width="30%">
		<bean:message key="label.position.region"/>
	</td>
	<td class="text" width="70%">
		<july:select collection="regions" property="regioncode" insertable="true" updatable="true">
			<july:options collection="regions" property="regionid" labelProperty="regname" addProperty="fullarendainfo"/>
		</july:select>
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>" />


<tr>
	<td class="text" width="30%">Центральный меридиан</td>
	<td class="text" width="70%">
		<july:string property="merid" size="15" insertable="true" updatable="true" />
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>" />

<tr id="calcCoord" style="display:block">
	<td class="text" width="30%">Пересчет координат</td>
	<td class="text" width="70%">
		<july:checkbox styleClass="text" insertable="true" updatable="true" property="recountCoord"/>
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>" trid="calcCoordTR" />

<tr class="title">
	<td class="title" colspan="<%= gColSpan %>">
		<INPUT TYPE="IMAGE" NAME="submit" SRC="/images/refresh.gif" ALT="<bean:message key="button.save"/>">
	</td>
</tr>
    
<july:separator colspan="<%= gColSpan %>" />

</table>

</july:editform>

<script>
	changeViss(document.all.proc);
</script>

