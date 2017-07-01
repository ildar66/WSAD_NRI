<HTML>
<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import = "com.hps.july.web.util.*, com.hps.july.basestation.formbean.*"%>
<BODY>
<july:editform action="/ShowCfgEditIFrameForm.do" styleId="ConfigEqEditForm_TrxsTitle">

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
<script>
function notImplimented() {
	alert("Данный режим пока не реализован.");
}
</script>

<table  width="985" cellspacing="0" cellpadding="0" class="construct" style="font-family:tahoma,arial;font-size:8pt;">
	<tr>
		<th colspan="5" align="left" valign="bottom">&nbsp;
			<A onclick="notImplimented();">
				<IMG SRC="/images/plus_disabled.gif" BORDER='0' ALT='Добавить строку'>
			</A>
		</th> 
		<th colspan="12"align="left">ТРАНСИВЕРЫ: общее количество - X шт</th> 
	</tr>	
	<tr>
		<th colspan="3" align="right">Р&nbsp;&nbsp;&nbsp;</th> 
		<th colspan="2" align="right">Учет</th> 
		<th colspan="1" align="center">Тип трансивера</th> 
		<th align="center">Номер шкафа</th> 
		<th colspan="5" align="center">Сектора 900</th> 
		<th colspan="5" align="center">Сектора 1800</th> 
	</tr>	
	<tr>
		<td width="30" align="left"></td> 
		<td width="30" align="left"></td> 
		<td width="30" align="left"></td> 
		<td width="30" align="left"></td> 
		<td width="30" align="left"></td> 
		<td width="295" align="left"></td> 
		<td width="90" align="center"></td> 
		<td width="44" align="center"></td> 
		<td width="43" align="center"></td> 
		<td width="43" align="center"></td> 
		<td width="43" align="center"></td> 
		<td width="43" align="center"></td> 
		<td width="44" align="center"></td> 
		<td width="43" align="center"></td> 
		<td width="43" align="center"></td> 
		<td width="43" align="center"></td> 
		<td width="43" align="center"></td> 
		<th width="18" align="left"></th> 
	</tr>	
</table>				

</july:editform>
</BODY>
</HTML>
