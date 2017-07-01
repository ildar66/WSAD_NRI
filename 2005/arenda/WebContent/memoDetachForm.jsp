<%@ page language = "java" %> 
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "16"; %>
<july:editform action="/ProcessMemoDetach.do" styleId="listForm"  onsubmit="storeID();">

<html:hidden name="MemoDetachForm" property="idHeader"/>
<html:hidden name="MemoDetachForm" property="operation"/>
<html:hidden name="MemoDetachForm" property="numPos"/>

<script language="javascript">
function changeMemoType(){
	window.location.href='/arenda/EditMemoDetach.do?action='+MemoDetachForm.action.value+'&idHeader='+MemoDetachForm.idHeader.value+
		'&type=' +MemoDetachForm.type.value;
}
function DeleteMemoPos(numPos) {
	if(confirm('������� ������ c �������: ' + (numPos+1)+ ' ?')) {
		document.all.numPos.value = numPos;
		document.all.operation.value = "deleteMemoPos";
		document.body.style.cursor="wait";
		listForm.submit();
		return false;
	}
}
function AddMemoPos() {
	document.all.operation.value = "addMemoPos";
    document.body.style.cursor="wait";
	listForm.submit();
	return false;
}
function UpdateMemoPos() {
	document.all.operation.value = "updateMemoPos";
    document.body.style.cursor="wait";
	listForm.submit();
	return false;
}
function SetMemoPos(numPos) {
	document.all.numPos.value = numPos;
	document.all.operation.value = "setMemoPos";
    document.body.style.cursor="wait";
	listForm.submit();
	return false;
}
function toggleOperType(n){
	listForm.elements["memoPos.opertype"][n].checked = true;
}
function storeID() {
	document.cookie = "MemoListDetachForm=" + document.all.idHeader.value;
}
function UpdateListArendaContractsInfo() {
	document.all.operation.value = "updateListArendaContractsInfo";
    document.body.style.cursor="wait";
	listForm.submit();
	return false;
}
</script>
<!-- ������� �������������� MemoHeader -->
<table class="main">

    <july:separator colspan="<%= gColSpan %>"/>
    
    <tr>
        <td class="title" colspan="<%= gColSpan %>"><july:actionalert/></td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>

	<tr>
		<td class="text"><july:reqmark>��� ��������� �������:</july:reqmark></td>
		<td class="text">
			<july:select style="width: 350;" property="memo.type" styleId="type" insertable="true" updatable="true" onchange="changeMemoType();">
				<html:option value="1">������ SIM �����</html:option>
				<html:option value="2">������ ���� �� ������ ������� �����</html:option>
				<html:option value="8">������ ������������</html:option>
				<html:option value="6">��������������</html:option>
			</july:select>
		</td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>

	<tr>
		<td class="text"><july:reqmark>�����:</july:reqmark></td>
		<td class="text">
			<july:string size="25" property="memo.number" insertable="true" updatable="true"/>
		</td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>

	<tr>
		<td class="text"><july:reqmark>��:</july:reqmark></td>
		<td class="text">
			<july:date property="memoDateStr" size="25" insertable="true" updatable="true"/>
		</td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>

	<tr>
		<td class="text"><july:reqmark>�����������:</july:reqmark></td>
		<td class="text">
			<logic:present name="MemoDetachForm" property="memo.manVO">
				<html:hidden property="memo.manVO.man"/>
				<july:lookupbutton action="/../security/ShowPeopleLookupList.do" styleId="manl" fieldNames="memo.manVO.man;memo.manVO.name" newWindowName="manlookup" insertable="true" updatable="true"/>
				<july:string size="50" property="memo.manVO.name" insertable="false" updatable="false"/>
			</logic:present>
		</td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>

	<tr>
		<td class="text"><july:reqmark>����:</july:reqmark></td>
		<td class="text">
			<july:select style="width: 500;" property="memo.target" collection="memoTargets" styleId="memo.target" insertable="true" updatable="true">
				<html:options collection="memoTargets" property="idTarget" labelProperty="name"/>
			</july:select>
		</td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<td class="text"><july:reqmark><bean:message key="label.abonents.orgcustomer"/>:</july:reqmark></td>
		<td class="text">
			<html:hidden property="memo.orgCustomer.organization"/>
			<%--july:lookupbutton action="/ShowOrganizationLookupList.do" styleId="orgl" fieldNames="memo.orgCustomer.organization;memo.orgCustomer.name" newWindowName="orglookup" insertable="true" updatable="true" onselect="UpdateListArendaContractsInfo()"/--%>
			<html:link page="/../dict/VendorSiteLookupList.do?formname=MemoDetachForm&fieldnames=memo.orgCustomer.organization||memo.orgCustomer.shortname&onMySelect=UpdateListArendaContractsInfo()" onclick="return openDialog(this.href, 'VendorSitesLookupList', 'top=40, left=100, width=700, height=650, scrollbars=yes, resizable=yes');" title="���������� ���������">
				<img src='/images/lookup.gif' border='0' alt='���������� �����������' name="lookupimg_execl"></html:link>						
			<july:string size="50" property="memo.orgCustomer.shortname" styleId="memo.orgCustomer.shortname" insertable="false" updatable="false"/>
		</td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>

	<tr>
		<td class="text"><july:reqmark>�������:</july:reqmark></td>
		<td class="text">
			<html:hidden property="memo.positionVO.storageplace"/>
			<july:lookupbutton action="/../basestation/ShowPositionLookupList.do?planstate=2" styleId="posl" fieldNames="memo.positionVO.storageplace;;memo.positionVO.name" insertable="true" updatable="true" onselect="UpdateListArendaContractsInfo()"/>
			<july:string size="50" property="memo.positionVO.name" insertable="false" updatable="false"/>
		</td>
	</tr>

<logic:present name="MemoDetachForm" property="memo.memoType">
<logic:present name="MemoDetachForm" property="memo.memoType.useTypes">
	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text">������� �����:</td>
		<td class="text">
			<july:select property="memo.usetype" collection="useTypes" styleId="memo.usetype" insertable="true" updatable="true">
				<html:options collection="useTypes" property="value" labelProperty="label"/>
			</july:select>
		</td>
	</tr>
</logic:present>
<logic:equal name="MemoDetachForm" property="memo.memoType.isFrom" value="true">
	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text">� ����:</td>
		<td class="text">
			<july:string size="50" property="memo.from" insertable="true" updatable="true"/>
		</td>
	</tr>			
</logic:equal>
<logic:equal name="MemoDetachForm" property="memo.memoType.isTo" value="true">
	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text">�� ����:</td>
		<td class="text">
			<july:string size="50" property="memo.to" insertable="true" updatable="true"/>	
		</td>
	</tr>
</logic:equal>
<logic:equal name="MemoDetachForm" property="memo.memoType.isArendaContract" value="true">
	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text">� ���� �������� ������:</td>
		<td class="text">
			<july:select property="memo.arendaContract" collection="listArendaContractsInfo" insertable="true" updatable="true">
				<html:option value=""/>
				<html:options collection="listArendaContractsInfo" property="arendacontractID" labelProperty="info"/>
			</july:select>			
		</td>
	</tr>
</logic:equal>
<logic:equal name="MemoDetachForm" property="memo.memoType.isLeaseBill" value="true">
	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text">
			<html:link page="/ShowAbonentBillLookupList.do?formname=MemoDetachForm&fieldnames=memo.leasebill|memoAbonentBillInfo" paramId="leaseDocument" paramName="MemoDetachForm" paramProperty="memo.abonentContract" scope="session" onclick="window.open(this.href, 'pWindow', 'top=40, left=100, width=700, height=650, scrollbars=yes, resizable=yes').focus(); return false;" title="����������">		
				����������� ����:
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

<!-- ������ ������� -->
<table class="main">

	<!-- Table header -->
	<tr class="title"><td align="center" colspan="<%= gColSpan %>"><b>������� ��������� �������:</b></td><tr>
	<tr class="title">
		<td class="title">&nbsp;</td>
		<logic:equal name="MemoDetachForm" property="memo.memoType.memoPosInfo.isPhoneNumber" value="true">
			<td class="title">������������� �����</td>
		</logic:equal>
		<logic:equal name="MemoDetachForm" property="memo.memoType.memoPosInfo.isTarifplan" value="true">
			<td class="title">�������� ����</td>
		</logic:equal>
		<logic:equal name="MemoDetachForm" property="memo.memoType.memoPosInfo.isCardname" value="true">
			<td class="title">������������ ����� ����� �����</td>
		</logic:equal>
		<logic:equal name="MemoDetachForm" property="memo.memoType.memoPosInfo.isComcardcnt" value="true">
			<td class="title">���������� ���� �����</td>
		</logic:equal>
		<logic:equal name="MemoDetachForm" property="memo.memoType.memoPosInfo.isCardamount" value="true">
			<td class="title">������� ����</td>
		</logic:equal>
		<logic:equal name="MemoDetachForm" property="memo.memoType.memoPosInfo.isSimcardcnt" value="true">
			<td class="title">���������� SIM ����</td>
		</logic:equal>
		<logic:equal name="MemoDetachForm" property="memo.memoType.memoPosInfo.isEquipname" value="true">
			<td class="title">������������ ������������</td>
		</logic:equal>
		<logic:equal name="MemoDetachForm" property="memo.memoType.memoPosInfo.isEquipcnt" value="true">
			<td class="title">���������� ������������</td>
		</logic:equal>
		<logic:equal name="MemoDetachForm" property="memo.memoType.memoPosInfo.isDefectdescr" value="true">
			<td class="title">�������� ������� ������������</td>
		</logic:equal>
		<logic:equal name="MemoDetachForm" property="memo.memoType.memoPosInfo.isService" value="true">
			<td class="title">������</td> 
		</logic:equal>
		<logic:equal name="MemoDetachForm" property="memo.memoType.memoPosInfo.isOpertype" value="true">
			<td class="title">��� �������� �����������</td>
		</logic:equal>
		<logic:equal name="MemoDetachForm" property="memo.memoType.memoPosInfo.isStartdate" value="true">
			<td class="title">���� ������</td>
		</logic:equal>
		<logic:equal name="MemoDetachForm" property="memo.memoType.memoPosInfo.isEnddate" value="true">
			<td class="title">���� ���������</td>
		</logic:equal>
		<logic:equal name="MemoDetachForm" property="memo.memoType.memoPosInfo.isGarantie" value="true">
			<td class="title">�������� ������. ������</td>
		</logic:equal>
		<td class="title">&nbsp;</td>
	</tr>

	<%String _class = "normal"; %>
	<!-- Table body  --> 
	<logic:iterate id="it" name="MemoDetachForm" property ="memo.listMemoPos" indexId="indexId"> 
		<logic:present name="it">
		<logic:present name="MemoDetachForm" property="memoPos.idPos">
			<logic:equal name="MemoDetachForm" property="numPos" value="<%=String.valueOf(indexId)%>">
				<% _class = "selected";%>
			</logic:equal>
			<logic:notEqual name="MemoDetachForm" property="numPos" value="<%=String.valueOf(indexId)%>">
				<% _class = "normal";%>
			</logic:notEqual>
		</logic:present>
		<tr class="<%=_class%>" style="font-size:8pt;" onMouseOver="className='select'" onMouseOut="className='<%=_class%>'">
			<td class="link">
				<A href='javascript:SetMemoPos(<bean:write name="indexId" filter="true"/>)' title="������������� �������">
					<bean:write name="it" property="idPos" filter="true"/>
				</A>
			</td>
			<logic:equal name="MemoDetachForm" property="memo.memoType.memoPosInfo.isPhoneNumber" value="true">
				<td class="text">
					<bean:write name="it" property="phoneNumber" filter="true"/>
				</td>
			</logic:equal>
			<logic:equal name="MemoDetachForm" property="memo.memoType.memoPosInfo.isTarifplan" value="true">
				<td class="text">
					<bean:write name="it" property="tarifplan" filter="true"/>
				</td>
			</logic:equal>
			<logic:equal name="MemoDetachForm" property="memo.memoType.memoPosInfo.isCardname" value="true">
				<td class="text">
					<bean:write name="it" property="cardname" filter="true"/>
				</td>
			</logic:equal>
			<logic:equal name="MemoDetachForm" property="memo.memoType.memoPosInfo.isComcardcnt" value="true">
				<td class="text">
					<bean:write name="it" property="comcardcnt" filter="true"/>
				</td>
			</logic:equal>
			<logic:equal name="MemoDetachForm" property="memo.memoType.memoPosInfo.isCardamount" value="true">
				<td class="text">
					<bean:write name="it" property="cardamount" filter="true"/>
				</td>
			</logic:equal>
			<logic:equal name="MemoDetachForm" property="memo.memoType.memoPosInfo.isSimcardcnt" value="true">
				<td class="text">
					<bean:write name="it" property="simcardcnt" filter="true"/>
				</td>
			</logic:equal>
			<logic:equal name="MemoDetachForm" property="memo.memoType.memoPosInfo.isEquipname" value="true">
				<td class="text">
					<bean:write name="it" property="equipname" filter="true"/>
				</td>
			</logic:equal>
			<logic:equal name="MemoDetachForm" property="memo.memoType.memoPosInfo.isEquipcnt" value="true">
				<td class="text">
					<bean:write name="it" property="equipcnt" filter="true"/>
				</td>
			</logic:equal>
			<logic:equal name="MemoDetachForm" property="memo.memoType.memoPosInfo.isDefectdescr" value="true">
				<td class="text">
					<bean:write name="it" property="defectdescr" filter="true"/>
				</td>
			</logic:equal>
			<logic:equal name="MemoDetachForm" property="memo.memoType.memoPosInfo.isService" value="true">
				<td class="text">
					<bean:write name="it" property="service" filter="true"/>
				</td>
			</logic:equal>
			<logic:equal name="MemoDetachForm" property="memo.memoType.memoPosInfo.isOpertype" value="true">
				<td class="text">
					<logic:present name="it" property="opertype">
						<logic:equal name="it" property="opertype" value="C">�����������</logic:equal>
						<logic:equal name="it" property="opertype" value="D">����������</logic:equal>
					</logic:present>
				</td>
			</logic:equal>
			<logic:equal name="MemoDetachForm" property="memo.memoType.memoPosInfo.isStartdate" value="true">
				<td class="text">
					<july:datewrite name="it" property="startdate"/>
				</td>
			</logic:equal>
			<logic:equal name="MemoDetachForm" property="memo.memoType.memoPosInfo.isEnddate" value="true">
				<td class="text">
					<july:datewrite name="it" property="enddate"/>
				</td>
			</logic:equal>
			<logic:equal name="MemoDetachForm" property="memo.memoType.memoPosInfo.isGarantie" value="true">
				<td class="text">
					<logic:present name="it" property="isgarantie">
						<logic:equal name="it" property="isgarantie" value="true">��</logic:equal>
						<logic:equal name="it" property="isgarantie" value="false">���</logic:equal>
					</logic:present>
				</td>
			</logic:equal>
			<td class="text">
				<A href='javascript:DeleteMemoPos(<bean:write name="indexId" filter="true"/>)' title="������� ������� ��������� �������">
					<IMG SRC="/images/del.gif" BORDER='0' ALT='������� ������� ��������� �������'>
				</A>
			</td>
		</tr>
		</logic:present>
	</logic:iterate>

	<july:separator colspan="<%= gColSpan %>"/>

</table>

<!-- ������� ���������� ������� -->
<table class="main">
<tr class="title">
	<td align="center" colspan="<%= gColSpan %>">
		<logic:notPresent name="MemoDetachForm" property="memoPos.idPos">
			<b>���������� ������� ��������� �������:</b>
		</logic:notPresent>
		<logic:present name="MemoDetachForm" property="memoPos.idPos">
			<b>��������� ������� ��������� ������� � � <bean:write name="MemoDetachForm" property="memoPos.idPos" filter="true"/>:</b>
		</logic:present>
	</td>
<tr>

<logic:equal name="MemoDetachForm" property="memo.memoType.memoPosInfo.isPhoneNumber" value="true">
	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text"><july:reqmark>������������� �����:</july:reqmark></td>
		<td class="text">
			<july:string size="25" property="memoPos.phoneNumber" insertable="true" updatable="true"/>
		</td>
	</tr>
</logic:equal>

<logic:equal name="MemoDetachForm" property="memo.memoType.memoPosInfo.isTarifplan" value="true">
	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text">
			<html:link page="/ShowTarifPlanLookupList.do?formname=MemoDetachForm&fieldnames=memoPos.tarifplan|memoPos.idTarifPlan" onclick="window.open(this.href, 'pWindow', 'top=40, left=100, width=600, height=650, scrollbars=yes, resizable=yes').focus(); return false;" title="����������">
				<july:reqmark>�������� ����:</july:reqmark>
			</html:link>
		</td>
		<td class="text">
			<html:hidden property="memoPos.idTarifPlan"/>
			<july:string size="25" property="memoPos.tarifplan" insertable="true" updatable="true"/>
		</td>
	</tr>
</logic:equal>

<logic:equal name="MemoDetachForm" property="memo.memoType.memoPosInfo.isCardname" value="true">
	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text">
			<html:link page="/ShowLeaseResBil2nriLookupList.do?formname=MemoDetachForm&fieldnames=memoPos.cardname" onclick="window.open(this.href, 'pWindow', 'top=40, left=100, width=600, height=650, scrollbars=yes, resizable=yes').focus(); return false;" title="����������">
			<july:reqmark>������������ ����� ����� �����:</july:reqmark>
			</html:link>
		</td>
		<td class="text">
			<july:string size="25" property="memoPos.cardname" insertable="true" updatable="true"/>
		</td>
	</tr>
</logic:equal>

<logic:equal name="MemoDetachForm" property="memo.memoType.memoPosInfo.isComcardcnt" value="true">
	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text"><july:reqmark>���������� ���� �����:</july:reqmark></td>
		<td class="text">
			<july:string size="25" property="memoPos.comcardcnt" insertable="true" updatable="true"/>
		</td>
	</tr>
</logic:equal>

<logic:equal name="MemoDetachForm" property="memo.memoType.memoPosInfo.isCardamount" value="true">
	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text"><july:reqmark>������� ����:</july:reqmark></td>
		<td class="text">
			<july:string size="25" property="memoPosCardamountStr" insertable="true" updatable="true"/>
		</td>
	</tr>
</logic:equal>

<logic:equal name="MemoDetachForm" property="memo.memoType.memoPosInfo.isSimcardcnt" value="true">
	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text"><july:reqmark>���������� SIM ����:</july:reqmark></td>
		<td class="text">
			<july:string size="25" property="memoPos.simcardcnt" insertable="true" updatable="true"/>
		</td>
	</tr>
</logic:equal>

<logic:equal name="MemoDetachForm" property="memo.memoType.memoPosInfo.isEquipname" value="true">
	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text">
			<html:link page="/ShowLeaseResBil2nriLookupList.do?formname=MemoDetachForm&fieldnames=memoPos.equipname|memoPos.equipcode" onclick="window.open(this.href, 'pWindow', 'top=40, left=100, width=600, height=650, scrollbars=yes, resizable=yes').focus(); return false;" title="����������">
				<july:reqmark>������������ ������������:</july:reqmark>
			</html:link>
		</td>
		<td class="text">
			<html:hidden property="memoPos.equipcode"/>
			<july:string size="25" property="memoPos.equipname" insertable="true" updatable="true"/>
		</td>
	</tr>
</logic:equal>

<logic:equal name="MemoDetachForm" property="memo.memoType.memoPosInfo.isEquipcnt" value="true">
	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text"><july:reqmark>���������� ������������:</july:reqmark></td>
		<td class="text">
			<july:string size="25" property="memoPos.equipcnt" insertable="true" updatable="true"/>
		</td>
	</tr>
</logic:equal>

<logic:equal name="MemoDetachForm" property="memo.memoType.memoPosInfo.isDefectdescr" value="true">
	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text"><july:reqmark>�������� ������� ������������:</july:reqmark></td>
		<td class="text">
			<july:string size="25" property="memoPos.defectdescr" insertable="true" updatable="true"/>
		</td>
	</tr>
</logic:equal>

<logic:equal name="MemoDetachForm" property="memo.memoType.memoPosInfo.isService" value="true">
	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text">
			<html:link page="/ShowBillingServicesLookupList.do?formname=MemoDetachForm&fieldnames=memoPos.service|memoPos.idService" onclick="window.open(this.href, 'pWindow', 'top=40, left=100, width=600, height=650, scrollbars=yes, resizable=yes').focus(); return false;" title="����������">
				<july:reqmark>������:</july:reqmark>
			</html:link>
		</td>
		<td class="text">
			<html:hidden property="memoPos.idService"/>
			<july:string size="25" property="memoPos.service" insertable="true" updatable="true"/>
		</td>
	</tr>
</logic:equal>

<logic:equal name="MemoDetachForm" property="memo.memoType.memoPosInfo.isOpertype" value="true">
	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text"><july:reqmark>��� �������� �����������:</july:reqmark></td>
		<td class="text">
			<A href="javascript:toggleOperType(0)">�����������</A>
			<july:radio property="memoPos.opertype" insertable="true" updatable="true" value="C"/><br>
			<A href="javascript:toggleOperType(1)">���������� </A> 
			<july:radio property="memoPos.opertype" insertable="true" updatable="true" value="D"/>
		</td>
	</tr>
</logic:equal>

<logic:equal name="MemoDetachForm" property="memo.memoType.memoPosInfo.isStartdate" value="true">
	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text"><july:reqmark>���� ������:</july:reqmark></td>
		<td class="text">
			<july:date property="memoPosStartdateStr" size="25" insertable="true" updatable="true" required="false"/>
		</td>
	</tr>
</logic:equal>

<logic:equal name="MemoDetachForm" property="memo.memoType.memoPosInfo.isEnddate" value="true">
	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text"><july:reqmark>���� ���������:</july:reqmark></td>
		<td class="text">
			<july:date property="memoPosEnddateStr" size="25" insertable="true" updatable="true" required="false"/>
		</td>
	</tr>
</logic:equal>

<logic:equal name="MemoDetachForm" property="memo.memoType.memoPosInfo.isGarantie" value="true">
	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text"><july:reqmark>�������� ������������ ������:</july:reqmark></td>
		<td class="text">
			<july:checkbox property="memoPos.isgarantie" insertable="true" updatable="true" />
		</td>
	</tr>
</logic:equal>

	<july:separator colspan="<%= gColSpan %>"/>
		<tr class="title">
			<td colspan="<%= gColSpan %>">
				<logic:present name="MemoDetachForm" property="memoPos.idPos">
					<A href='javascript:UpdateMemoPos()' title="�������� ������� ��������� �������">
						<B style="color:blue">�������� �������</B>
					</A>
				</logic:present>
				<logic:notPresent name="MemoDetachForm" property="memoPos.idPos">
					<A href='javascript:AddMemoPos()' title="�������� ������� ��������� �������">
						<B style="color:blue">�������� �������</B>
					</A>
				</logic:notPresent>
			</td>
		<tr>
	<july:separator colspan="<%= gColSpan %>"/>
		
</table>
</july:editform>