<%@ page language = "java" %> 
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "2"; %>
<july:editform action="/ProcessMemoPos.do" styleId="MemoPosForm">

<html:hidden name="MemoPosForm" property="idPos"/>
<html:hidden name="MemoPosForm" property="idHeader"/>

<script language="javascript">
function toggleOperType(n){
	MemoPosForm.elements["memoPos.opertype"][n].checked = true;
}
</script>

<table class="main">

    <july:separator colspan="<%= gColSpan %>"/>
    <tr>
        <td class="title" colspan="<%= gColSpan %>"><july:actionalert/></td>
	</tr>

<logic:equal name="MemoPosForm" property="memoPosInfo.isPhoneNumber" value="true">
	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text"><july:reqmark>Избирательный номер:</july:reqmark></td>
		<td class="text">
			<july:select property="memoPos.phoneNumber" collection="phones" styleId="memoPos.phoneNumber" insertable="true" updatable="true">
				<html:options collection="phones" property="phonenumber" labelProperty="phonenumber"/>
			</july:select>
		</td>
	</tr>
</logic:equal>

<logic:equal name="MemoPosForm" property="memoPosInfo.isTarifplan" value="true">
	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text"><july:reqmark>Тарифный план:</july:reqmark></td>
		<td class="text">
			<july:string size="25" property="memoPos.tarifplan" insertable="true" updatable="true"/>
		</td>
	</tr>
</logic:equal>

<logic:equal name="MemoPosForm" property="memoPosInfo.isComcardcnt" value="true">
	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text"><july:reqmark>Количество карт связи:</july:reqmark></td>
		<td class="text">
			<july:string size="25" property="memoPos.comcardcnt" insertable="true" updatable="true"/>
		</td>
	</tr>
</logic:equal>

<logic:equal name="MemoPosForm" property="memoPosInfo.isCardamount" value="true">
	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text"><july:reqmark>Номинал карт:</july:reqmark></td>
		<td class="text">
			<july:string size="25" property="memoPosCardamountStr" insertable="true" updatable="true"/>
		</td>
	</tr>
</logic:equal>

<logic:equal name="MemoPosForm" property="memoPosInfo.isSimcardcnt" value="true">
	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text"><july:reqmark>Количество SIM карт:</july:reqmark></td>
		<td class="text">
			<july:string size="25" property="memoPos.simcardcnt" insertable="true" updatable="true"/>
		</td>
	</tr>
</logic:equal>

<logic:equal name="MemoPosForm" property="memoPosInfo.isEquipname" value="true">
	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text">
			<html:link page="/ShowLeaseResBil2nriLookupList.do?formname=MemoPosForm&fieldnames=memoPos.equipname|memoPos.equipcode" onclick="window.open(this.href, 'pWindow', 'top=40, left=100, width=600, height=650, scrollbars=yes, resizable=yes').focus(); return false;" title="справочник">
				<july:reqmark>Наименование оборудования:</july:reqmark>
			</html:link>
		</td>
		<td class="text">
			<html:hidden property="memoPos.equipcode"/>
			<july:string size="25" property="memoPos.equipname" insertable="true" updatable="true"/>
		</td>
	</tr>
</logic:equal>

<logic:equal name="MemoPosForm" property="memoPosInfo.isEquipcnt" value="true">
	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text"><july:reqmark>Количество оборудования:</july:reqmark></td>
		<td class="text">
			<july:string size="25" property="memoPos.equipcnt" insertable="true" updatable="true"/>
		</td>
	</tr>
</logic:equal>

<logic:equal name="MemoPosForm" property="memoPosInfo.isDefectdescr" value="true">
	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text"><july:reqmark>Описание дефекта оборудования:</july:reqmark></td>
		<td class="text">
			<july:string size="25" property="memoPos.defectdescr" insertable="true" updatable="true"/>
		</td>
	</tr>
</logic:equal>

<logic:equal name="MemoPosForm" property="memoPosInfo.isService" value="true">
	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text"><july:reqmark>Услуга:</july:reqmark></td>
		<td class="text">
			<july:string size="25" property="memoPos.service" insertable="true" updatable="true"/>
		</td>
	</tr>
</logic:equal>

<logic:equal name="MemoPosForm" property="memoPosInfo.isOpertype" value="true">
	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text"><july:reqmark>Тип операции подключения:</july:reqmark></td>
		<td class="text">
			<A href="javascript:toggleOperType(0)">Подключение</A>
			<july:radio property="memoPos.opertype" insertable="true" updatable="true" value="C"/><br>
			<A href="javascript:toggleOperType(1)">Отключение </A>  
			<july:radio property="memoPos.opertype" insertable="true" updatable="true" value="D"/>
		</td>
	</tr>
</logic:equal>

<logic:equal name="MemoPosForm" property="memoPosInfo.isStartdate" value="true">
	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text"><july:reqmark>Дата начала:</july:reqmark></td>
		<td class="text">
			<july:date property="memoPosStartdateStr" size="25" insertable="true" updatable="true" required="false"/>
		</td>
	</tr>
</logic:equal>

<logic:equal name="MemoPosForm" property="memoPosInfo.isEnddate" value="true">
	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text"><july:reqmark>Дата окончания:</july:reqmark></td>
		<td class="text">
			<july:date property="memoPosEnddateStr" size="25" insertable="true" updatable="true" required="false"/>
		</td>
	</tr>
</logic:equal>

<logic:equal name="MemoPosForm" property="memoPosInfo.isGarantie" value="true">
	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text"><july:reqmark>Взимание гарантийного взноса:</july:reqmark></td>
		<td class="text">
			<july:checkbox property="memoPos.isgarantie" insertable="true" updatable="true" />
		</td>
	</tr>
</logic:equal>

<logic:equal name="MemoPosForm" property="memoPosInfo.isCardname" value="true">
	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text"><july:reqmark>Наименование карты услуг связи:</july:reqmark></td>
		<td class="text">
			<july:string size="25" property="memoPos.cardname" insertable="true" updatable="true"/>
		</td>
	</tr>
</logic:equal>

	<july:separator colspan="<%= gColSpan %>"/>

	<july:formbuttons/>

	<july:separator colspan="<%= gColSpan %>"/>
		
</table>

</july:editform>