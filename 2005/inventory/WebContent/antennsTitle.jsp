<HTML>
<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import = "com.hps.july.web.util.*, com.hps.july.inventory.formbean.*"%>
<BODY>
<july:editform action="/ShowCfgEditIFrameForm.do" styleId="ConfigEqEditForm_AntennsTitle">
<input type="hidden" name="partForSubmit" value="<%=ConfigEqEditForm.ANTENNS_TITLE_PART%>"/>

<script>
function notImplimented() {
	alert("Данный режим пока не реализован.");
}
function  submitAntennsTitleForm() {
 	ConfigEqEditForm_AntennsTitle.submit();
}
</script>

<style>
TD.tableCell {
	text-align: center;
}
TABLE.construct {
	border-style: solid; 
	border-color: red; 
	border-width: 0;
}
TH {
	border-style: solid; 
	border-color: yellow; 
	border-width: 0; 
}
</style>

<table  width="1928" cellspacing="0" cellpadding="0" class="construct" style="font-family:tahoma,arial;font-size:8pt;">
	<tr>
		<th nowrap colspan="3" align="left">&nbsp;
			<A onclick="notImplimented();">
				<IMG SRC="/images/plus_disabled.gif" BORDER='0' ALT='Добавить строку'>
			</A>
		</th> 
		<th nowrap colspan="4" align="center">АНТЕННЫ: общее количество - <bean:write name="ConfigEqEditForm" property="antennsQuantity" filter="true"/> шт</th> 
		<th nowrap colspan="16" align="left">&nbsp;</th> 
		<th nowrap colspan="7" align="left">ФИДЕРЫ: Производитель&nbsp;
				<july:select collection="fidersProdusers" property="fidersProduserId" insertable="true" updatable="true" 
					 onchange="submitAntennsTitleForm();">
					<html:options collection="fidersProdusers" property="code" labelProperty="name"/>
				</july:select>
		</th> 
		<th align="left"></th> 
	</tr>	
	<tr>
		<th nowrap colspan="3" align="right">Р&nbsp;&nbsp;&nbsp;</th> 
		<th nowrap colspan="2" align="right">Учет</th> 
		<th nowrap align="center">Тип антенны</th> 
		<th align="center">&nbsp;</th> 
		<th nowrap colspan="5" align="center">Сектора 900</th> 
		<th nowrap colspan="5" align="center">Сектора 1800</th> 
		<th nowrap align="center">Азимут</th> 
		<th nowrap align="center">Высота, м</th> 
		<th nowrap align="center">Мех наклон</th> 
		<th nowrap align="center">T/R 900</th> 
		<th nowrap align="center">T/R 1800</th> 
		<th nowrap align="center">Исполнение</th> 
		<th nowrap align="center">Тип фидера 1</th> 
		<th nowrap align="center">Длина, м</th> 
		<th nowrap align="center">Тип фидера 2</th> 
		<th nowrap align="center">Длина, м</th> 
		<th nowrap align="center">Общий</th> 
		<th nowrap align="center">КСВН 900</th> 
		<th nowrap align="center">КСВН 1800</th> 
		<th align="center"></th> 
	</tr>	
	<tr>
		<td width="30" align="center"></td> 
		<td width="30" align="center"></td> 
		<td width="30" align="center"></td> 
		<td width="30" align="center"></td> 
		<td width="30" align="center"></td> 
		<td width="160" align="center"></td> 
		<td width="30" align="center"></td> 
		<td width="43" align="center"></td> 
		<td width="43" align="center"></td> 
		<td width="43" align="center"></td> 
		<td width="43" align="center"></td> 
		<td width="43" align="center"></td> 
		<td width="43" align="center"></td> 
		<td width="43" align="center"></td> 
		<td width="43" align="center"></td> 
		<td width="43" align="center"></td> 
		<td width="43" align="center"></td> 
		<td width="70" align="center"></td> 
		<td width="80" align="center"></td> 
		<td width="90" align="center"></td> 
		<td width="70" align="center"></td> 
		<td width="70" align="center"></td> 
		<td width="90" align="center"></td> 
		<td width="150" align="center"></td> 
		<td width="80" align="center"></td> 
		<td width="150" align="center"></td> 
		<td width="80" align="center"></td> 
		<td width="50" align="center"></td> 
		<td width="80" align="center"></td> 
		<td width="80" align="center"></td> 
		<th width="18" align="left"></th> 
	</tr>	
	<%--
	<tr>
		<td width="30" align="center">1</td> 
		<td width="30" align="center">2</td> 
		<td width="30" align="center">3</td> 
		<td width="30" align="center">4</td> 
		<td width="150" align="center">5</td> 
		<td width="43" align="center">5'</td> 
		<td width="43" align="center">61</td> 
		<td width="43" align="center">62</td> 
		<td width="43" align="center">63</td> 
		<td width="43" align="center">64</td> 
		<td width="43" align="center">65</td> 
		<td width="43" align="center">7'</td> 
		<td width="43" align="center">71</td> 
		<td width="43" align="center">72</td> 
		<td width="43" align="center">73</td> 
		<td width="43" align="center">74</td> 
		<td width="43" align="center">75</td> 
		<td width="70" align="center">8</td> 
		<td width="80" align="center">9</td> 
		<td width="90" align="center">10</td> 
		<td width="70" align="center">11</td> 
		<td width="70" align="center">12</td> 
		<td width="90" align="center">13</td> 
		<td width="150" align="center">14</td> 
		<td width="80" align="center">15</td> 
		<td width="150" align="center">16</td> 
		<td width="80" align="center">17</td> 
		<td width="50" align="center">18</td> 
		<td width="80" align="center">19</td> 
		<td width="80" align="center">20</td> 
		<th width="18" align="left"></th> 
	</tr>	
	--%>
</table>				

</july:editform>
<script>
	if (parent.document.frames["antennsContentIFrame"]) {
		var antennsContForm = parent.document.frames["antennsContentIFrame"].document.ConfigEqEditForm_AntennsContent;
		if (antennsContForm) {
			antennsContForm.submit();
		}
	}
</script>
</BODY>
</HTML>

