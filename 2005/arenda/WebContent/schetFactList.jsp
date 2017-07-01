<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import = "com.hps.july.arenda.formbean.*"%>
<%@ page import = "com.hps.july.arenda.valueobject.*"%>

<%!private String isUp(String aSort, String name) {
	if (aSort.startsWith(name)) {
		if (aSort.endsWith("desc"))
			return (" <img src='/images/up.gif'  border='0' alt='�� �����������'> ");
		else
			return (" <img src='/images/down.gif'  border='0' alt='�� ��������'> ");
	} else
		return ("");
}
%>

<%String gColSpan = "14";
SchetFactListForm listForm =
	(SchetFactListForm) session.getAttribute("SchetFactListForm");
String sortBy = listForm.getSortBy();
%>
<july:browseform action="/SchetFactList.do" styleId="listForm">
	<html:hidden property="idContract" />
	<html:hidden property="sortBy" />

	<html:hidden property="operation" value="" />
	<html:hidden property="idCode" value="-1" />
	<html:hidden property="toState" value="" />
	<html:hidden property="selectedID" value="0" />

	<script language="javascript">
function SortBy(field) 
{
	var e = document.all.sortBy;
	e.value = (e.value == field)?field + ' desc':field;
    document.body.style.cursor="wait";
	listForm.submit();
	return false;
}
function deleteItem(number, idItem) {
	if(confirm('������� ������ c �������: ' + number+ ' ?')) {
		document.body.style.cursor="wait";
		document.all.operation.value="deleteItem";
		document.all.idcwacode.value=idItem;
		listForm.submit();
		return false;
	}
}
function changeState(toState){
	document.body.style.cursor="wait";
	document.all.operation.value="changeState";
	document.all.toState.value=toState;
	document.all.idCode.value=document.all.selectedID.value;
	//alert("idCode=" + document.all.idCode.value + " toState=" + toState);
	listForm.submit();
	return false;
}
function printItemWord(idItem){
	window.location.href='/arenda/CompletWorkAktWordAction.do?idcwacode='+idItem;
}
function onMouseOutRow(selectedID){
	if(document.all.selectedID.value==selectedID) {
		document.all.tableID.rows(selectedID,0).className="selected";
	}
	else {
		document.all.tableID.rows(selectedID,0).className="normal";
	}
}
function onClickRow(selectedID) {
	if(document.all.tableID.rows(document.all.selectedID.value) != null){
		document.all.tableID.rows(document.all.selectedID.value,0).className="normal";
	}
	document.all.selectedID.value=selectedID;
	document.all.tableID.rows(selectedID,0).className="selected";
	storeSelectedRow(selectedID);
}
function storeSelectedRow(selectedID) {
	document.cookie = listForm.name+"=" + selectedID;
}
function loadSelectedRow() {
	var cookies = document.cookie;
	//��������� selectedID:
	var startLoc = cookies.indexOf(listForm.name+"=");
	if(startLoc == -1)
	   return;
	var sepLoc = cookies.indexOf("=", startLoc);
	var endLoc = cookies.indexOf(";", startLoc);
	if(endLoc == -1) {
		endLoc = cookies.length;
    }
    document.all.selectedID.value = cookies.substring(sepLoc+1, endLoc);
	//������������ ������ � �������:
	if( document.all.tableID.rows(document.all.selectedID.value) != null ) {
 		document.all.tableID.rows(document.all.selectedID.value,0).className="selected";
	}
}
function showFacture(code){
	window.location.href='/arenda/SchetFactWordAction.do?type='+document.all.type.value+'&code='+code;
}
function getTypeSF(typeSF){
	var typeSFdefault = document.all.type.value;
	if(typeSFdefault == 'D')
		return typeSF;
	else
		return typeSFdefault;
}
</script>

	<table class="main" id="tableID" style="font-size: 8pt">
	<july:separator colspan="<%= gColSpan %>"/>
	<!-- ������ � ��������: -->
	<TR class="normal">
		<TD colspan="<%= gColSpan %>">
			<table class="find">
				<tr>
					<td class="text">
						<A href='AgreementInfo.do?action=View&leaseDocument=<bean:write name="SchetFactListForm" property="mainLeaseContractKey"/>' onclick='return openDialog(this.href, "AgreementInfo", "top=100, left=100, width=700, height=500, scrollbars=yes, resizable=yes");' class='button'>
							<bean:message key="label.dhist.contractInfo"/>:
						</A>
					</td>				
					<td class="text">
						<bean:write name="SchetFactListForm" property="docNumber" filter="true" />
						&nbsp;��&nbsp;<july:datewrite name="SchetFactListForm" property="docDate"/>
					</td>
					<td class="text" rowspan="3" width="15%" align="center" valign="middle">
						<july:searchbutton/>
					</td>					
				</tr>			
<%--
				<tr>
					<td class="text" style="font-weight: normal;">
						<B>� ���.:</B>
						<bean:write name="CompletWorkActsListForm" property="agreement.mainDocumentNumber" filter="true"/>
						<B><bean:message key="label.filter.ot"/></B>
						<july:datewrite name="CompletWorkActsListForm" property="agreement.mainDocumentDate"/>
						<B>c:</B>
						<july:datewrite name="CompletWorkActsListForm" property="agreement.mainStartDate"/>
						<B><bean:message key="label.filter.stop"/></B>
						<july:datewrite name="CompletWorkActsListForm" property="agreement.mainEndDate"/>
						&nbsp;&nbsp;&nbsp;
						<B><bean:message key="label.filter.costcurrency"/>:</B>
						<july:sumwrite name="CompletWorkActsListForm" property="agreement.o.summ1"/>&nbsp;
						<bean:write name="CompletWorkActsListForm" property="agreement.o.currency1.shortname" filter="true"/>
						<logic:present name="CompletWorkActsListForm" property="agreement.o.summ2">
							;&nbsp;<july:sumwrite name="CompletWorkActsListForm" property="agreement.o.summ2"/>
							&nbsp;<bean:write name="CompletWorkActsListForm" property="agreement.o.currency2.shortname" filter="true"/>
						</logic:present>
					</td>
				</tr>
				<tr>
					<td class="text" colspan="2" style="font-weight: normal;">
						<B><bean:message key="label.mainPosition"/></B>
						<bean:write name="CompletWorkActsListForm" property="agreement.mainPosition" filter="true"/>
					</td>
				</tr>
				<tr>
					<td class="text" style="font-weight: normal;">
						<B><bean:message key="label.filter.customer"/>:</B>
						<logic:present name="CompletWorkActsListForm" property="agreement.mainOrgCustomer">
							<bean:write name="CompletWorkActsListForm" property="agreement.mainOrgCustomer.name" filter="true"/>
						</logic:present>
						&nbsp;&nbsp;&nbsp;
						<B><bean:message key="label.organization.isrenter"/>:</B>
						<logic:present name="CompletWorkActsListForm" property="agreement.mainOrgExecutor">
							<bean:write name="CompletWorkActsListForm" property="agreement.mainOrgExecutor.name" filter="true"/>
						</logic:present>
					</td>
				</tr>
--%>
			</table>
		</TD>
	</TR>

		<july:separator colspan="<%=gColSpan%>" /> 
		<tr class="normal">
			<td class="title" colspan="<%= gColSpan %>">
				��� ����-������� ��� ������:
				<html:select property="type">
					<html:option value="C">����-������� �� 30.05.2006</html:option>
					<html:option value="A">����-������� �� 16.02.2004</html:option>
					<html:option value="B">����-������� �� 15.03.2001</html:option>
					<html:option value="D">���������� �� ����</html:option>
				</html:select>
<%--				
				���������� �� ����:
				<july:checkbox property="isDefaultTypeSF" insertable="true" updatable="true"/>
--%>				
			</td>
		</tr>
		
		<july:separator colspan="<%=gColSpan%>" />				
		<tr class="title">
			<td colspan="<%=gColSpan%>">
			<table class="buttons">
				<tr class="title">
					<td class="buttons"><july:canedit rolesProperty="editRoles"></july:canedit>
					<A
						href='SchetFactDialog.do?action=Add&idAkt=null&idContract=<bean:write name="SchetFactListForm" property="mainLeaseContractKey" filter="true"/>'
						onclick='return openDialog(this.href, "SchetFactDialog", "top=150, left=470, width=520, height=350, scrollbars=yes, resizable=yes");'>
					<IMG SRC="/images/plus.gif" BORDER='0' ALT='�������� ������'></A>
					&nbsp;<july:backbutton/></td>
					<td align="right">�������� �������:<%=request.getAttribute("numberOfLines")%>
					</td>
					<td class="navigator"><july:navigator/></td>
				</tr>
			</table>
			</td>
		</tr>

		<july:separator colspan="<%=gColSpan%>" />
		<!-- Table header -->
		<tr class="title">
			<td class="title">&nbsp;</td>
			<td class="title" title="������� ������������ �� ����"><B>!</B></td>
			<td class="title"><A title="����������� �� ���� '����� ��'"
				href="javascript:SortBy('numberSchetFakt')">�����</A><%=isUp(sortBy, "numberSchetFakt")%>
			</td>
			<td class="title"><A title="����������� �� ���� '���� ��'"
				href="javascript:SortBy('dateSchetFakt')">����</A><%=isUp(sortBy, "dateSchetFakt")%>
			</td>
			<td class="title"><A
				title="����������� �� ���� '���� ������ �������'"
				href="javascript:SortBy('dateStartSf')">�___</A><%=isUp(sortBy, "dateStartSf")%>
			</td>
			<td class="title"><A
				title="����������� �� ���� '���� ��������� �������'"
				href="javascript:SortBy('dateEndSf')">��__</A><%=isUp(sortBy, "dateEndSf")%>
			</td>
			<td class="title"><A title="����������� �� ���� '����� ��'"
				href="javascript:SortBy('sumSf')">�����</A><%=isUp(sortBy, "sumSf")%>
			</td>
			<td class="title"><A title="����������� �� ���� '��� ��'"
				href="javascript:SortBy('ndsSf')">���</A><%=isUp(sortBy, "ndsSf")%>
			</td>
			<td class="title"><A title="����������� �� ���� '������'"
				href="javascript:SortBy('curName')">������</A><%=isUp(sortBy, "curName")%>
			</td>
			<td class="title"><A
				title="����������� �� ���� '��������� ��'"
				href="javascript:SortBy('state')">��������� ��</A><%=isUp(sortBy, "state")%>
			</td>
			<td class="title">&nbsp;</td>
			<td class="title">�����</td>
			<td class="title">&nbsp;</td>
			<%--td class="title">&nbsp;</td--%>
		</tr>

		<july:separator colspan="<%=gColSpan%>" />

		<!-- Table body -->
		<logic:iterate id="it" name="browseList" type="LeaseSchetFact_TO">
			<logic:present name="it">
				<tr
					id='<bean:write name="it" property="vo.idSchetFakt" filter="true"/>'
					class="normal" style="font-size: 8pt"
					onMouseOver="className='select'"
					onMouseOut="onMouseOutRow(this.id);" onclick='onClickRow(this.id);'>
					<td class="link">
					<%
						String actionSF = "View";
						LeaseSchetFact_TO to = (LeaseSchetFact_TO)it;
						String state = to.getVo().getState();
						if(state.equals("O") || state.equals("R") || state.equals("1") )
							actionSF = "Edit";
					%>
					<%--logic:notPresent name="it" property="vo.idAkt"--%>
						<A href='SchetFactDialog.do?action=<%= actionSF%>&id=<bean:write name="it" property="vo.idSchetFakt" filter="true"/>'
							onclick='return openDialog(this.href, "SchetFactDialog", "top=150, left=470, width=520, height=350, scrollbars=yes, resizable=yes");'>
						<IMG SRC="/images/izmena.gif" BORDER='0' ALT='�������� ������'></A>
					<%--/logic:notPresent--%>
					</td>
					<td class="link">
						<logic:present name="it" property="vo.idAkt">
							<IMG SRC="/images/check_on.gif" BORDER='0' ALT='����-������� ������������ �� ����: <bean:write name="it" property="vo.baseDocNumber" filter="true"/>'>
						</logic:present>
					</td>
					<td class="text"><bean:write name="it" property="vo.numberSchetFakt" filter="true" /></td>
					<td class="text"><july:datewrite name="it" property="vo.dateSchetFakt" /></td>
					<td class="text"><july:datewrite name="it" property="vo.dateStartSf" /></td>
					<td class="text"><july:datewrite name="it" property="vo.dateEndSf" /></td>
					<td class="number" align="right" nowrap><july:sumwrite name="it" property="sumSf"/></td>
					<td class="number" align="right" nowrap><july:sumwrite name="it" property="ndsSf"/></td>
					<td class="text">			
						<logic:present name="it" property="vo.idCurrency">
							<bean:write name="it" property="curName" filter="true"/>
						</logic:present>
					</td>
					<td class="text">	 		
						<html:select style="width: 120px;" name ="it" property="vo.state" styleId="state" onchange='changeState(this.value);'>
							<html:option value="O">�������������</html:option>
							<html:option value="R">����������</html:option>
							<html:option value="1">�������� �� �����.</html:option>
							<html:option value="2">�������� � ���.</html:option>
							<html:option value="3">������� ���.</html:option>
							<html:option value="4">�������� ���������</html:option>
							<html:option value="5">������� ����������</html:option>
							<html:option value="V">����������</html:option>
						</html:select>
					</td>
					<td class="link" align="center" nowrap="nowrap">
					<%
						String idStr = "" + ((LeaseSchetFact_TO) it).getVo().getIdSchetFakt();
						String typeSF = ((LeaseSchetFact_TO) it).getTypeSF();
					%>
<%-- 					
	 					<logic:notEqual name="it" property="vo.state" value="O">
							<A href='javascript:showFacture(<bean:write name="it" property="vo.idSchetFakt" filter="true"/>)'>
								<img src="/images/docword.gif" border=0 alt='<bean:message key="label.mutualacts.print.sf"/>'></A>
						</logic:notEqual>
--%>						
						<logic:notEqual name="it" property="vo.state" value="O">
						<% String beforeclick = "wrded1_" + idStr + "_addtourl('&type=' + getTypeSF('"+typeSF+"'));";  %>
						<july:wordedit styleId='<%= "wrded1_" + idStr %>' url='<%= "SchetFactWordAction.do?code=" + idStr%>' 
									uploadurl="SchetFactWordUploadAction.do" documentid="<%= idStr %>"
									beforeclick="<%= beforeclick %>">
									<IMG SRC="/images/docword.gif" border="0" alt='<bean:message key="label.mutaulacts.createword"/>'></july:wordedit>
						</logic:notEqual>
						<july:wordedit styleId='<%= "wrded2_" + idStr %>' url='<%= "SchetFactWordDownload?code=" + idStr %>'
							uploadurl="SchetFactWordUploadAction.do" documentid="<%= idStr %>">
							<IMG SRC="/images/getdbword.gif" border="0" alt='<bean:message key="label.mutualacts.fromdb"/>'></july:wordedit>
<%--
				<html:link page="/CompletWorkAktWordDownload" paramId="idcwacode" paramName="it" paramProperty="idcwacode" paramScope="page">
					<img src="/images/getdbword.gif" border=0 alt='<bean:message key="label.mutualacts.fromdb"/>'>
				</html:link>
--%>
					</td>
<%--					
					<td class="link" align="center">
						<html:link
							page="/CWA_Charges_Print.do?action=View" paramId="idcwacode"
							paramName="it" paramProperty="idSchetFakt"
							onclick="return openDialog(this.href, 'pWindow', 'top=280, left=250, width=700, height=250, scrollbars=yes, resizable=yes, menubar=yes');">
							<IMG SRC="/images/kontr.gif" BORDER=0 alt='������ ����������'>
						</html:link>
					</td>
--%>
					<td class="text">
						<logic:present name="it" property="dateRegistryDoc">
							<bean:write name="it" property="numRegistryDoc" filter="true" />
							�� <july:datewrite name="it" property="dateRegistryDoc" />
						</logic:present>
					</td>					
					<td class="text"><july:canedit rolesProperty="editRoles"></july:canedit>
						<logic:equal name="it" property="vo.state" value="O">
						<%--logic:notPresent name="it" property="vo.idAkt"--%>
							 <A href='SchetFactDialog.do?action=Delete&id=<bean:write name="it" property="vo.idSchetFakt" filter="true"/>'
								onclick='return openDialog(this.href, "SchetFactDialog", "top=150, left=430, width=520, height=350, scrollbars=yes, resizable=yes");'>
							    <img src="/images/del.gif" border="0" alt='������� ������'> </A>
						<%--/logic:notPresent--%>
						</logic:equal>
					</td>
				</tr>
				<july:separator colspan="<%=gColSpan%>" />
			</logic:present>
		</logic:iterate>

		<tr class="title">
			<td colspan="<%=gColSpan%>">
			<table class="buttons">
				<tr class="title">
					<td class="buttons"><july:canedit rolesProperty="editRoles"></july:canedit>
					<A
						href='SchetFactDialog.do?action=Add&idAkt=null&idContract=<bean:write name="SchetFactListForm" property="mainLeaseContractKey" filter="true"/>'
						onclick='return openDialog(this.href, "SchetFactDialog", "top=150, left=470, width=520, height=350, scrollbars=yes, resizable=yes");'>
					<IMG SRC="/images/plus.gif" BORDER='0' ALT='�������� ������'></A>
					&nbsp;<july:backbutton/></td>
					<td align="right">�������� �������:<%=request.getAttribute("numberOfLines")%>
					</td>
					<td class="navigator"><july:navigator/></td>
				</tr>
			</table>
			</td>
		</tr>

		<july:separator colspan="<%=gColSpan%>" />
	</table>

</july:browseform>

<script language="javascript">
	<%	
		String operation = listForm.getOperation();
		Integer idPosSchetFakt = listForm.getIdPosSchetFakt(); 
		if(operation.equals("createSF") && idPosSchetFakt != null){
	%>
		storeSelectedRow("<%=idPosSchetFakt%>");
		openDialog('SchetFactDialog.do?action=Edit&id=<%=idPosSchetFakt%>', "SchetFactDialog", "top=150, left=470, width=520, height=350, scrollbars=yes, resizable=yes");
	<%}%>
	loadSelectedRow();
	window.location.hash=document.all.selectedID.value;
</script>
