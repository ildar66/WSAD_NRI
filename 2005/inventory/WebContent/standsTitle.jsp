<HTML>
<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import = "com.hps.july.web.util.*, com.hps.july.inventory.formbean.*"%>
<BODY>
<july:editform action="/ShowCfgEditIFrameForm.do" styleId="ConfigEqEditForm_StandsTitle">

<input type="hidden" name="partForSubmit" value="<%=ConfigEqEditForm.STANDS_TITLE_PART%>"/>
<input type="hidden" name="isInsertNewStand" id="isInsertNewStand_inputId" value="false"/>
<input type="hidden" name="curStandId" id="curStandId_inputId" value="<bean:write name="ConfigEqEditForm" property="curStandId" filter="true"/>"/>

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
	border-color: red; 
	border-width: 0; 
}
</style>

<script>
function notImplimented() {
	alert("Данный режим пока не реализован.");
}

function addNewStand() {
	var isInsertNewStand = document.getElementById("isInsertNewStand_inputId");
	isInsertNewStand.value = "true"; 
	ConfigEqEditForm_StandsTitle.submit();
}

function  submitStandsTitleForm(theObject) {
	// alert("!!!!!!!!!!!!!!!!");
 	ConfigEqEditForm_StandsTitle.submit();
}
</script>

<table  width="738" cellspacing="0" cellpadding="0" class="construct" style="font-family:tahoma,arial;font-size:8pt;">
	<tr>
		<th nowrap colspan="3" align="left">&nbsp;
			<A onclick="addNewStand();">
				<IMG SRC="/images/plus_disabled.gif" BORDER='0' ALT='Добавить строку'>
			</A>
		</th> 
		<th colspan="3" align="left">Производитель</th> 
		<th align="left">
				<july:select style="width:280px;" collection="standsProdusers" property="standsProduserId" insertable="true" updatable="true" onchange="submitStandsTitleForm(this);">
					<html:options collection="standsProdusers" property="code" labelProperty="name"/>
				</july:select>
		</th> 
		<th colspan="2" align="left" valign="middle">&nbsp;ШКАФЫ: общее количество - 
									<%-- <bean:write name="ConfigEqEditForm" property="standsQuantity" filter="true"/> --%>
									<july:string style="width:23px;" size="2" property="standsQuantity" insertable="false" updatable="false" styleId="standsQuantity_text_id"/>
									шт</th> 
	</tr>	
	<tr>
		<th colspan="3" align="right">Р&nbsp;&nbsp;&nbsp;</th> 
		<th colspan="2" align="right">Учет</th> 
		<th colspan="2" align="center">Тип шкафа</th> 
		<th align="center">Номер шкафа</th> 
		<th align="center">Кол-во трансиверов</th> 
	</tr>	
	<tr>
		<td width="30" align="left"></td> 
		<td width="30" align="left"></td> 
		<td width="30" align="left"></td> 
		<td width="30" align="left"></td> 
		<td width="30" align="left"></td> 
		<td width="35" align="left"></td> 
		<td width="295" align="left"></td> 
		<td width="90" align="center"></td> 
		<td width="150" align="center"></td> 
		<th width="18" align="left"></th> 
	</tr>	
</table>				

</july:editform>
<script>
	if (parent.document.frames["standsContentIFrame"]) {
		var standsContForm = parent.document.frames["standsContentIFrame"].document.ConfigEqEditForm_StandsContent;
		var curStandId_input_content = parent.document.frames["standsContentIFrame"].document.getElementById("curStandId_inputId");
		var curStandId_input_title = document.getElementById("curStandId_inputId");
		curStandId_input_content.value = curStandId_input_title.value;
		if (standsContForm) {
			standsContForm.submit();
		}
	}
</script>
</BODY>
</HTML>
