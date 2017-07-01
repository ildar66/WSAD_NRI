<%@ page language = "java" %> 
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<%
		String gColSpan = "16";
		String form = "LoanContractMemoForm";
%>
<july:editform action="/LoanContractMemoProcess.do" styleId="<%= form%>"  onsubmit="storeID();">

<html:hidden name="<%= form%>" property="loanContract"/>
<html:hidden name="<%= form%>" property="idHeader"/>
<html:hidden name="<%= form%>" property="operation"/>
<html:hidden name="<%= form%>" property="numPos"/>

<script language="javascript">

function changeMemoType(){
    window.location.href='/arenda/LoanContractMemo.do?action='+<%= form%>.action.value+'&idHeader='+<%= form%>.idHeader.value+'&type='+<%= form%>.type.value;
}
function DeleteMemoPos(numPos) {
	if(confirm('Удалить запись c номером: ' + (numPos+1)+ ' ?')) {
		document.all.numPos.value = numPos;
		document.all.operation.value = "deleteMemoPos";
		document.body.style.cursor="wait";
		<%= form%>.submit();
		return false;
	}
}
function AddMemoPos() {
	document.all.operation.value = "addMemoPos";
    document.body.style.cursor="wait";
	<%= form%>.submit();
	return false;
}
function UpdateMemoPos() {
	document.all.operation.value = "updateMemoPos";
    document.body.style.cursor="wait";
	<%= form%>.submit();
	return false;
}
function SetMemoPos(numPos) {
	document.all.numPos.value = numPos;
	document.all.operation.value = "setMemoPos";
    document.body.style.cursor="wait";
	<%= form%>.submit();
	return false;
}
function toggleOperType(n){
	<%= form%>.elements["memoPos.opertype"][n].checked = true;
}
function storeID() {
	document.cookie = "LoanContractMemoListForm=" + document.all.idHeader.value;
}
</script>

<!-- Таблица редактирования MemoHeader -->
<table class="main">

    <july:separator colspan="<%= gColSpan %>"/>
    <tr>
        <td class="title" colspan="<%= gColSpan %>"><july:actionalert/></td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text"><july:reqmark>Тип служебной записки:</july:reqmark></td> 
		<td class="text">
			<july:select style="width: 350;" property="memo.type" styleId="type" insertable="true" updatable="true" onchange="changeMemoType();">
				<html:option value="F">Выдать оборудование для с.д.</html:option>
				<html:option value="J">Возврат оборудования для с.д.</html:option>
				<html:option value="E">Ремонт оборудования для с.д.</html:option>				
			</july:select>
		</td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text"><july:reqmark>Номер:</july:reqmark></td>
		<td class="text">
			<july:string size="25" property="memo.number" insertable="true" updatable="true"/>
		</td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text"><july:reqmark>от:</july:reqmark></td>
		<td class="text">
			<july:date property="memoDateStr" size="25" insertable="true" updatable="true"/>
		</td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text"><july:reqmark>Исполнитель:</july:reqmark></td>
		<td class="text">
			<logic:present name="<%= form%>" property="memo.manVO">
				<html:hidden property="memo.manVO.man"/>
				<july:lookupbutton action="/../security/ShowPeopleLookupList.do" styleId="manl" fieldNames="memo.manVO.man;memo.manVO.name" newWindowName="manlookup" insertable="true" updatable="true"/>
				<july:string size="50" property="memo.manVO.name" insertable="false" updatable="false"/>
			</logic:present>
		</td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text"><july:reqmark>Кому:</july:reqmark></td>
		<td class="text">
			<july:select style="width: 500;" property="memo.target" collection="memoTargets" styleId="memo.target" insertable="true" updatable="true">
				<html:options collection="memoTargets" property="idTarget" labelProperty="name"/>
			</july:select>
		</td>
	</tr>

<logic:present name="<%= form%>" property="memo.memoType">
<logic:present name="<%= form%>" property="memo.memoType.useTypes">
	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text">Признак учета:</td>
		<td class="text">
			<july:select property="memo.usetype" collection="useTypes" styleId="memo.usetype" insertable="true" updatable="true">
				<html:options collection="useTypes" property="value" labelProperty="label"/>
			</july:select>
		</td>
	</tr>
</logic:present>
<logic:equal name="<%= form%>" property="memo.memoType.isLeaseBill" value="true">
	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text">
			<html:link page="/ShowAbonentBillLookupList.do?formname=LoanContractMemoForm&fieldnames=memo.leasebill|memoAbonentBillInfo" paramId="leaseDocument" paramName="LoanContractMemoForm" paramProperty="memo.abonentContract" scope="session" onclick="window.open(this.href, 'pWindow', 'top=40, left=100, width=700, height=650, scrollbars=yes, resizable=yes').focus(); return false;" title="справочник">		
				абонентский счет:
			</html:link>
		</td>
		<td class="text">
			<html:hidden property="memo.leasebill"/>
			<july:string size="50" property="memoAbonentBillInfo" insertable="true" updatable="true"/>			
		</td>
	</tr>
</logic:equal>
</logic:present>


	<july:separator colspan="<%= gColSpan %>"/>
	
	<july:formbuttons/>

	<july:separator colspan="<%= gColSpan %>"/>

</table>

<!-- Список позиций -->
<table class="main">

	<!-- Table header -->
	<tr class="title"><td align="center" colspan="<%= gColSpan %>"><b>Позиции служебной записки:</b></td><tr>
	<tr class="title">
		<td class="title">&nbsp;</td>
		<logic:equal name="<%= form%>" property="memo.memoType.memoPosInfo.isPhoneNumber" value="true">
			<td class="title">Избирательный номер</td>
		</logic:equal>
		<logic:equal name="<%= form%>" property="memo.memoType.memoPosInfo.isTarifplan" value="true">
			<td class="title">Тарифный план</td>
		</logic:equal>
		<logic:equal name="<%= form%>" property="memo.memoType.memoPosInfo.isCardname" value="true">
			<td class="title">Наименование карты услуг связи</td>
		</logic:equal>
		<logic:equal name="<%= form%>" property="memo.memoType.memoPosInfo.isComcardcnt" value="true">
			<td class="title">Количество карт связи</td>
		</logic:equal>
		<logic:equal name="<%= form%>" property="memo.memoType.memoPosInfo.isCardamount" value="true">
			<td class="title">Номинал карт</td>
		</logic:equal>
		<logic:equal name="<%= form%>" property="memo.memoType.memoPosInfo.isSimcardcnt" value="true">
			<td class="title">Количество SIM карт</td>
		</logic:equal>
		<logic:equal name="<%= form%>" property="memo.memoType.memoPosInfo.isEquipname" value="true">
			<td class="title">Наименование оборудования</td>
		</logic:equal>
		<logic:equal name="<%= form%>" property="memo.memoType.memoPosInfo.isEquipcnt" value="true">
			<td class="title">Количество оборудования</td>
		</logic:equal>
		<logic:equal name="<%= form%>" property="memo.memoType.memoPosInfo.isDefectdescr" value="true">
			<td class="title">Описание дефекта оборудования</td>
		</logic:equal>
		<logic:equal name="<%= form%>" property="memo.memoType.memoPosInfo.isService" value="true">
			<td class="title">Услуга</td> 
		</logic:equal>
		<logic:equal name="<%= form%>" property="memo.memoType.memoPosInfo.isOpertype" value="true">
			<td class="title">Тип операции подключения</td>
		</logic:equal>
		<logic:equal name="<%= form%>" property="memo.memoType.memoPosInfo.isStartdate" value="true">
			<td class="title">Дата начала</td>
		</logic:equal>
		<logic:equal name="<%= form%>" property="memo.memoType.memoPosInfo.isEnddate" value="true">
			<td class="title">Дата окончания</td>
		</logic:equal>
		<logic:equal name="<%= form%>" property="memo.memoType.memoPosInfo.isGarantie" value="true">
			<td class="title">Взимание гарант. взноса</td>
		</logic:equal>
		<logic:equal name="<%= form%>" property="memo.memoType.memoPosInfo.isBilldelivery" value="true">
			<td class="title">Способ доставки</td>
		</logic:equal>
		<logic:equal name="<%= form%>" property="memo.memoType.memoPosInfo.isBilladdress" value="true">
			<td class="title">Адрес доставки</td>
		</logic:equal>
		<td class="title">&nbsp;</td>
	</tr>

	<%String _class = "normal"; %>
	<!-- Table body  --> 
	<logic:iterate id="it" name="<%= form%>" property ="memo.listMemoPos" indexId="indexId"> 
		<logic:present name="it">
		<logic:present name="<%= form%>" property="memoPos.idPos">
			<logic:equal name="<%= form%>" property="numPos" value="<%=String.valueOf(indexId)%>">
				<% _class = "selected";%>
			</logic:equal>
			<logic:notEqual name="<%= form%>" property="numPos" value="<%=String.valueOf(indexId)%>">
				<% _class = "normal";%>
			</logic:notEqual>
		</logic:present>
		<tr class="<%=_class%>" style="font-size:8pt;" onMouseOver="className='select'" onMouseOut="className='<%=_class%>'">
			<td class="link">
				<A href='javascript:SetMemoPos(<bean:write name="indexId" filter="true"/>)' title="Редактировать позицию">
					<bean:write name="it" property="idPos" filter="true"/>
				</A>
			</td>
			<logic:equal name="<%= form%>" property="memo.memoType.memoPosInfo.isPhoneNumber" value="true">
				<td class="text">
					<bean:write name="it" property="phoneNumber" filter="true"/>
				</td>
			</logic:equal>
			<logic:equal name="<%= form%>" property="memo.memoType.memoPosInfo.isTarifplan" value="true">
				<td class="text">
					<bean:write name="it" property="tarifplan" filter="true"/>
				</td>
			</logic:equal>
			<logic:equal name="<%= form%>" property="memo.memoType.memoPosInfo.isCardname" value="true">
				<td class="text">
					<bean:write name="it" property="cardname" filter="true"/>
				</td>
			</logic:equal>
			<logic:equal name="<%= form%>" property="memo.memoType.memoPosInfo.isComcardcnt" value="true">
				<td class="text">
					<bean:write name="it" property="comcardcnt" filter="true"/>
				</td>
			</logic:equal>
			<logic:equal name="<%= form%>" property="memo.memoType.memoPosInfo.isCardamount" value="true">
				<td class="text">
					<bean:write name="it" property="cardamount" filter="true"/>
				</td>
			</logic:equal>
			<logic:equal name="<%= form%>" property="memo.memoType.memoPosInfo.isSimcardcnt" value="true">
				<td class="text">
					<bean:write name="it" property="simcardcnt" filter="true"/>
				</td>
			</logic:equal>
			<logic:equal name="<%= form%>" property="memo.memoType.memoPosInfo.isEquipname" value="true">
				<td class="text">
					<bean:write name="it" property="equipname" filter="true"/>
				</td>
			</logic:equal>
			<logic:equal name="<%= form%>" property="memo.memoType.memoPosInfo.isEquipcnt" value="true">
				<td class="text">
					<bean:write name="it" property="equipcnt" filter="true"/>
				</td>
			</logic:equal>
			<logic:equal name="<%= form%>" property="memo.memoType.memoPosInfo.isDefectdescr" value="true">
				<td class="text">
					<bean:write name="it" property="defectdescr" filter="true"/>
				</td>
			</logic:equal>
			<logic:equal name="<%= form%>" property="memo.memoType.memoPosInfo.isService" value="true">
				<td class="text">
					<bean:write name="it" property="service" filter="true"/>
				</td>
			</logic:equal>
			<logic:equal name="<%= form%>" property="memo.memoType.memoPosInfo.isOpertype" value="true">
				<td class="text">
					<logic:present name="it" property="opertype">
						<logic:equal name="it" property="opertype" value="C">подключение</logic:equal>
						<logic:equal name="it" property="opertype" value="D">отключение</logic:equal>
					</logic:present>
				</td>
			</logic:equal>
			<logic:equal name="<%= form%>" property="memo.memoType.memoPosInfo.isStartdate" value="true">
				<td class="text">
					<july:datewrite name="it" property="startdate"/>
				</td>
			</logic:equal>
			<logic:equal name="<%= form%>" property="memo.memoType.memoPosInfo.isEnddate" value="true">
				<td class="text">
					<july:datewrite name="it" property="enddate"/>
				</td>
			</logic:equal>
			<logic:equal name="<%= form%>" property="memo.memoType.memoPosInfo.isGarantie" value="true">
				<td class="text">
					<logic:present name="it" property="isgarantie">
						<logic:equal name="it" property="isgarantie" value="true">да</logic:equal>
						<logic:equal name="it" property="isgarantie" value="false">нет</logic:equal>
					</logic:present>
				</td>
			</logic:equal>
			<logic:equal name="<%= form%>" property="memo.memoType.memoPosInfo.isBilldelivery" value="true">
				<td class="text">
					<logic:present name="it" property="billdelivery">
						<logic:equal name="it" property="billdelivery" value="1">Курьер</logic:equal>
						<logic:equal name="it" property="billdelivery" value="2">Почта</logic:equal>
						<logic:equal name="it" property="billdelivery" value="3">Электронная почта</logic:equal>
					</logic:present>
				</td>
			</logic:equal>
			<logic:equal name="<%= form%>" property="memo.memoType.memoPosInfo.isBilladdress" value="true">
				<td class="text">
					<bean:write name="it" property="billaddress" filter="true"/>
				</td>
			</logic:equal>
			<td class="text">
				<A href='javascript:DeleteMemoPos(<bean:write name="indexId" filter="true"/>)' title="Удалить позицию служебной записки">
					<IMG SRC="/images/del.gif" BORDER='0' ALT='Удалить позицию служебной записки'>
				</A>
			</td>
		</tr>
		</logic:present>
	</logic:iterate>

	<july:separator colspan="<%= gColSpan %>"/>

</table>

<!-- Таблица добавления позиций -->
<table class="main">
<tr class="title">
	<td align="center" colspan="<%= gColSpan %>">
		<logic:notPresent name="<%= form%>" property="memoPos.idPos">
			<b>Добавление позиции служебной записки:</b>
		</logic:notPresent>
		<logic:present name="<%= form%>" property="memoPos.idPos">
			<b>Изменение позиции служебной записки с № <bean:write name="<%= form%>" property="memoPos.idPos" filter="true"/>:</b>
		</logic:present>
	</td>
<tr>
<logic:equal name="<%= form%>" property="memo.memoType.memoPosInfo.isPhoneNumber" value="true">
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

<logic:equal name="<%= form%>" property="memo.memoType.memoPosInfo.isTarifplan" value="true">
	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text">
			<html:link page="/ShowTarifPlanLookupList.do?formname=LoanContractMemoForm&fieldnames=memoPos.tarifplan|memoPos.idTarifPlan" onclick="window.open(this.href, 'pWindow', 'top=40, left=100, width=600, height=650, scrollbars=yes, resizable=yes').focus(); return false;" title="справочник">
				<july:reqmark>Тарифный план:</july:reqmark>
			</html:link>
		</td>
		<td class="text">
			<html:hidden property="memoPos.idTarifPlan"/>
			<july:string size="25" property="memoPos.tarifplan" insertable="true" updatable="true"/>
		</td>
	</tr>
</logic:equal>

<logic:equal name="<%= form%>" property="memo.memoType.memoPosInfo.isCardname" value="true">
	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text">
			<html:link page="/ShowLeaseResBil2nriLookupList.do?formname=LoanContractMemoForm&fieldnames=memoPos.cardname" onclick="window.open(this.href, 'pWindow', 'top=40, left=100, width=600, height=650, scrollbars=yes, resizable=yes').focus(); return false;" title="справочник">
			<july:reqmark>Наименование карты услуг связи:</july:reqmark>
			</html:link>
		</td>
		<td class="text">
			<july:string size="25" property="memoPos.cardname" insertable="true" updatable="true"/>
		</td>
	</tr>
</logic:equal>

<logic:equal name="<%= form%>" property="memo.memoType.memoPosInfo.isComcardcnt" value="true">
	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text"><july:reqmark>Количество карт связи:</july:reqmark></td>
		<td class="text">
			<july:string size="25" property="memoPos.comcardcnt" insertable="true" updatable="true"/>
		</td>
	</tr>
</logic:equal>

<logic:equal name="<%= form%>" property="memo.memoType.memoPosInfo.isCardamount" value="true">
	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text"><july:reqmark>Номинал карт:</july:reqmark></td>
		<td class="text">
			<july:string size="25" property="memoPosCardamountStr" insertable="true" updatable="true"/>
		</td>
	</tr>
</logic:equal>

<logic:equal name="<%= form%>" property="memo.memoType.memoPosInfo.isSimcardcnt" value="true">
	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text"><july:reqmark>Количество SIM карт:</july:reqmark></td>
		<td class="text">
			<july:string size="25" property="memoPos.simcardcnt" insertable="true" updatable="true"/>
		</td>
	</tr>
</logic:equal>

<logic:equal name="<%= form%>" property="memo.memoType.memoPosInfo.isEquipname" value="true">
	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text">
			<html:link page="/ShowLeaseResBil2nriLookupList.do?formname=LoanContractMemoForm&fieldnames=memoPos.equipname|memoPos.equipcode" onclick="window.open(this.href, 'pWindow', 'top=40, left=100, width=600, height=650, scrollbars=yes, resizable=yes').focus(); return false;" title="справочник">
				<july:reqmark>Наименование оборудования:</july:reqmark>
			</html:link>
		</td>
		<td class="text">
			<html:hidden property="memoPos.equipcode"/>
			<july:string size="25" property="memoPos.equipname" insertable="true" updatable="true"/>
		</td>
	</tr>
</logic:equal>

<logic:equal name="<%= form%>" property="memo.memoType.memoPosInfo.isEquipcnt" value="true">
	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text"><july:reqmark>Количество оборудования:</july:reqmark></td>
		<td class="text">
			<july:string size="25" property="memoPos.equipcnt" insertable="true" updatable="true"/>
		</td>
	</tr>
</logic:equal>

<logic:equal name="<%= form%>" property="memo.memoType.memoPosInfo.isDefectdescr" value="true">
	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text"><july:reqmark>Описание дефекта оборудования:</july:reqmark></td>
		<td class="text">
			<july:string size="25" property="memoPos.defectdescr" insertable="true" updatable="true"/>
		</td>
	</tr>
</logic:equal>

<logic:equal name="<%= form%>" property="memo.memoType.memoPosInfo.isService" value="true">
	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text">
			<html:link page="/ShowBillingServicesLookupList.do?formname=LoanContractMemoForm&fieldnames=memoPos.service|memoPos.idService" onclick="window.open(this.href, 'pWindow', 'top=40, left=100, width=600, height=650, scrollbars=yes, resizable=yes').focus(); return false;" title="справочник">
				<july:reqmark>Услуга:</july:reqmark>
			</html:link>
		</td>
		<td class="text">
			<html:hidden property="memoPos.idService"/>
			<%--july:string size="25" property="memoPos.service" insertable="true" updatable="true"/--%>
			<july:textarea cols="15" rows="2" property="memoPos.service" insertable="true" updatable="true"/>
		</td>
	</tr>
</logic:equal>

<logic:equal name="<%= form%>" property="memo.memoType.memoPosInfo.isOpertype" value="true">
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

<logic:equal name="<%= form%>" property="memo.memoType.memoPosInfo.isStartdate" value="true">
	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text"><july:reqmark>Дата начала:</july:reqmark></td>
		<td class="text">
			<july:date property="memoPosStartdateStr" size="25" insertable="true" updatable="true" required="false"/>
		</td>
	</tr>
</logic:equal>

<logic:equal name="<%= form%>" property="memo.memoType.memoPosInfo.isEnddate" value="true">
	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text"><july:reqmark>Дата окончания:</july:reqmark></td>
		<td class="text">
			<july:date property="memoPosEnddateStr" size="25" insertable="true" updatable="true" required="false"/>
		</td>
	</tr>
</logic:equal>

<logic:equal name="<%= form%>" property="memo.memoType.memoPosInfo.isGarantie" value="true">
	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text"><july:reqmark>Взимание гарантийного взноса:</july:reqmark></td>
		<td class="text">
			<july:checkbox property="memoPos.isgarantie" insertable="true" updatable="true" />
		</td>
	</tr>
</logic:equal>

<logic:equal name="<%= form%>" property="memo.memoType.memoPosInfo.isBilldelivery" value="true">
	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text"><july:reqmark>Способ доставки:</july:reqmark></td>
		<td class="text">
			<july:select property="memoPos.billdelivery" insertable="true" updatable="true">
				<html:option value="1">Курьер</html:option>
				<html:option value="2">Почта</html:option>
				<html:option value="3">Электронная почта</html:option>
			</july:select>
		</td>
	</tr>
</logic:equal>

<logic:equal name="<%= form%>" property="memo.memoType.memoPosInfo.isBilladdress" value="true">
	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text"><july:reqmark>Адрес доставки:</july:reqmark></td>
		<td class="text">
			<july:textarea cols="15" rows="2" property="memoPos.billaddress" insertable="true" updatable="true"/>
		</td>
	</tr>
</logic:equal>

	<july:separator colspan="<%= gColSpan %>"/>
		<tr class="title">
			<td colspan="<%= gColSpan %>">
				<logic:present name="<%= form%>" property="memoPos.idPos">
					<A href='javascript:UpdateMemoPos()' title="Изменить позицию служебной записки">
						Изменить позицию
					</A>
				</logic:present>
				<logic:notPresent name="<%= form%>" property="memoPos.idPos">
					<A href='javascript:AddMemoPos()' title="Добавить позицию служебной записки">
						Добавить позицию
					</A>
				</logic:notPresent>
			</td>
		<tr>
	<july:separator colspan="<%= gColSpan %>"/>
		
</table>
</july:editform>