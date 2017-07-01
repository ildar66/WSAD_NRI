<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import = "com.hps.july.arenda.formbean.*"%>

<%
	String gColSpan = "16";
%>

<july:browseform action="/ShowMemoPosList" styleId="MemoPosListForm">
<html:hidden property="idHeader"/>

<script language="javascript">
function DeleteMemoPos(idPos) {
	if(confirm('Удалить запись c номером: ' + idPos+ ' ?')) {
		window.location.href='/arenda/ProcessMemoPos.do?action=Delete&idPos='+idPos;
		return false;
	}
}
</script>

<table class="main">

	<july:separator colspan="<%= gColSpan %>"/>

	<TR class="normal">
		<TD colspan="<%= gColSpan %>">
			<table class="find">
				<tr>
					<td class="text">Тип служебной записки:</td>
					<td class="text">
						<bean:write name="MemoPosListForm" property="memo.memoType.typeDescription" filter="true"/>
					</td>
				</tr>
				<tr>
					<td class="text">Номер:</td>
					<td class="text">
						<bean:write name="MemoPosListForm" property="memo.number" filter="true"/>
					</td>
				</tr>
				<tr>
					<td class="text">от:</td>
					<td class="text">
						<july:datewrite name="MemoPosListForm" property="memo.date"/>
					</td>
				</tr>
				<tr>
					<td class="text">Исполнитель:</td>
					<td class="text">
						<logic:present name="MemoPosListForm" property="memo.manVO">
							<bean:write name="MemoPosListForm" property="memo.manVO.name" filter="true"/>
						</logic:present>
					</td>
				</tr>
				<tr>
					<td class="text">Кому:</td>
					<td class="text">
						<logic:present name="MemoPosListForm" property="memo.targetVO">
							<bean:write name="MemoPosListForm" property="memo.targetVO.name" filter="true"/>
						</logic:present>
					</td>
				</tr>
			</table>
		</TD>
	</TR>

	<july:separator colspan="<%= gColSpan %>"/>

	<!-- Table header -->
	<tr class="title">
		<td class="title">&nbsp;</td>
		<logic:equal name="MemoPosListForm" property="memo.memoType.memoPosInfo.isPhoneNumber" value="true">
			<td class="title">Избирательный номер</td>
		</logic:equal>
		<logic:equal name="MemoPosListForm" property="memo.memoType.memoPosInfo.isTarifplan" value="true">
			<td class="title">Тарифный план</td>
		</logic:equal>
		<logic:equal name="MemoPosListForm" property="memo.memoType.memoPosInfo.isComcardcnt" value="true">
			<td class="title">Количество карт связи</td>
		</logic:equal>
		<logic:equal name="MemoPosListForm" property="memo.memoType.memoPosInfo.isCardamount" value="true">
			<td class="title">Номинал карт</td>
		</logic:equal>
		<logic:equal name="MemoPosListForm" property="memo.memoType.memoPosInfo.isSimcardcnt" value="true">
			<td class="title">Количество SIM карт</td>
		</logic:equal>
		<logic:equal name="MemoPosListForm" property="memo.memoType.memoPosInfo.isEquipname" value="true">
			<td class="title">Наименование оборудования</td>
		</logic:equal>
		<logic:equal name="MemoPosListForm" property="memo.memoType.memoPosInfo.isEquipcnt" value="true">
			<td class="title">Количество оборудования</td>
		</logic:equal>
		<logic:equal name="MemoPosListForm" property="memo.memoType.memoPosInfo.isDefectdescr" value="true">
			<td class="title">Описание дефекта оборудования</td>
		</logic:equal>
		<logic:equal name="MemoPosListForm" property="memo.memoType.memoPosInfo.isService" value="true">
			<td class="title">Услуга</td>
		</logic:equal>
		<logic:equal name="MemoPosListForm" property="memo.memoType.memoPosInfo.isOpertype" value="true">
			<td class="title">Тип операции подключения</td>
		</logic:equal>
		<logic:equal name="MemoPosListForm" property="memo.memoType.memoPosInfo.isStartdate" value="true">
			<td class="title">Дата начала</td>
		</logic:equal>
		<logic:equal name="MemoPosListForm" property="memo.memoType.memoPosInfo.isEnddate" value="true">
			<td class="title">Дата окончания</td>
		</logic:equal>
		<logic:equal name="MemoPosListForm" property="memo.memoType.memoPosInfo.isGarantie" value="true">
			<td class="title">Взимание гарант. взноса</td>
		</logic:equal>
		<logic:equal name="MemoPosListForm" property="memo.memoType.memoPosInfo.isCardname" value="true">
			<td class="title">Наименование карты услуг связи</td>
		</logic:equal>
		<td class="title">&nbsp;</td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>

	<!-- Table body  --> 
	<logic:iterate id="it" name="browseList"> 
		<logic:present name="it">
		<tr class="normal" style="font-size:8pt;" onMouseOver="className='select'" onMouseOut="className='normal'">
			<td class="link">
				<html:link page="/EditMemoPos.do?action=Edit" paramId="idPos" paramName="it" paramProperty="idPos" paramScope="page">
					<IMG SRC="/images/izmena.gif" BORDER='0' ALT='Просмотр записи'>
				</html:link>
			</td>
			<logic:equal name="MemoPosListForm" property="memo.memoType.memoPosInfo.isPhoneNumber" value="true">
				<td class="text">
					<bean:write name="it" property="phoneNumber" filter="true"/>
				</td>
			</logic:equal>
			<logic:equal name="MemoPosListForm" property="memo.memoType.memoPosInfo.isTarifplan" value="true">
				<td class="text">
					<bean:write name="it" property="tarifplan" filter="true"/>
				</td>
			</logic:equal>
			<logic:equal name="MemoPosListForm" property="memo.memoType.memoPosInfo.isComcardcnt" value="true">
				<td class="text">
					<bean:write name="it" property="comcardcnt" filter="true"/>
				</td>
			</logic:equal>
			<logic:equal name="MemoPosListForm" property="memo.memoType.memoPosInfo.isCardamount" value="true">
				<td class="text">
					<bean:write name="it" property="cardamount" filter="true"/>
				</td>
			</logic:equal>
			<logic:equal name="MemoPosListForm" property="memo.memoType.memoPosInfo.isSimcardcnt" value="true">
				<td class="text">
					<bean:write name="it" property="simcardcnt" filter="true"/>
				</td>
			</logic:equal>
			<logic:equal name="MemoPosListForm" property="memo.memoType.memoPosInfo.isEquipname" value="true">
				<td class="text">
					<bean:write name="it" property="equipname" filter="true"/>
				</td>
			</logic:equal>
			<logic:equal name="MemoPosListForm" property="memo.memoType.memoPosInfo.isEquipcnt" value="true">
				<td class="text">
					<bean:write name="it" property="equipcnt" filter="true"/>
				</td>
			</logic:equal>
			<logic:equal name="MemoPosListForm" property="memo.memoType.memoPosInfo.isDefectdescr" value="true">
				<td class="text">
					<bean:write name="it" property="defectdescr" filter="true"/>
				</td>
			</logic:equal>
			<logic:equal name="MemoPosListForm" property="memo.memoType.memoPosInfo.isService" value="true">
				<td class="text">
					<bean:write name="it" property="service" filter="true"/>
				</td>
			</logic:equal>
			<logic:equal name="MemoPosListForm" property="memo.memoType.memoPosInfo.isOpertype" value="true">
				<td class="text">
					<logic:present name="it" property="opertype">
						<logic:equal name="it" property="opertype" value="C">подключение</logic:equal>
						<logic:equal name="it" property="opertype" value="D">отключение</logic:equal>
					</logic:present>
				</td>
			</logic:equal>
			<logic:equal name="MemoPosListForm" property="memo.memoType.memoPosInfo.isStartdate" value="true">
				<td class="text">
					<july:datewrite name="it" property="startdate"/>
				</td>
			</logic:equal>
			<logic:equal name="MemoPosListForm" property="memo.memoType.memoPosInfo.isEnddate" value="true">
				<td class="text">
					<july:datewrite name="it" property="enddate"/>
				</td>
			</logic:equal>
			<logic:equal name="MemoPosListForm" property="memo.memoType.memoPosInfo.isGarantie" value="true">
				<td class="text">
					<logic:equal name="it" property="isgarantie" value="true">да</logic:equal>
					<logic:equal name="it" property="isgarantie" value="false">нет</logic:equal>
				</td>
			</logic:equal>
			<logic:equal name="MemoPosListForm" property="memo.memoType.memoPosInfo.isCardname" value="true">
				<td class="text">
					<bean:write name="it" property="cardname" filter="true"/>
				</td>
			</logic:equal>
			<td class="text">
				<A href='javascript:DeleteMemoPos(<bean:write name="it" property="idPos" filter="true"/>)' title="Удалить позицию служебной записки">
					<IMG SRC="/images/del.gif" BORDER='0' ALT='Удалить позицию служебной записки'>
				</A>
			</td>
		</tr>
		<july:separator colspan="<%= gColSpan %>"/>
		</logic:present>
	</logic:iterate>

	<tr class="title">
		<td colspan="<%= gColSpan %>">
			<table class="buttons">
				<tr class="title">
					<td class="buttons">
						<html:link page="/EditMemoPos.do?action=Add" paramId="idHeader" paramName="MemoPosListForm" paramProperty="idHeader">
							<IMG SRC="/images/plus.gif" BORDER='0' ALT='Добавить запись'>
						</html:link> 
						<july:backbutton/>
					</td>
					<td align="right">
						отобрано записей:<%= request.getAttribute("numberOfLines") %>
					</td>
					<td class="navigator"><july:navigator/></td>
				</tr>
			</table>
		</td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>
</table>

<P align="center"><B>Режим в процессе разработки(просьба не ругаться :)</B></P>

</july:browseform>