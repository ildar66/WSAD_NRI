<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import="com.hps.july.arenda.*, com.hps.july.arenda.valueobject.*, com.hps.july.arenda.formbean.*" %>

<%!	private final String [] colorsBG = {"background-color:#981C4F", "background-color:#FDE689", "background-color:#599BC4", "background-color:#AADA97"}; %>
<%--jsp:include page="common/top.jsp" flush="true"/--%>

<%
	String gColSpan = "29";
	DogHistoryListForm listForm = (DogHistoryListForm) session.getAttribute("DogHistoryListForm");	
%> 

<july:browseform action="/ShowDogHistoryList.do" styleId="DogHistoryListForm">
<script language="javascript">
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
	document.cookie = DogHistoryListForm.name+"=" + selectedID;
}
function loadSelectedRow() {
	var cookies = document.cookie;
	//считываем selectedID:
	var startLoc = cookies.indexOf(DogHistoryListForm.name+"=");
	if(startLoc == -1)
	   return;
	var sepLoc = cookies.indexOf("=", startLoc);
	var endLoc = cookies.indexOf(";", startLoc);
	if(endLoc == -1) {
		endLoc = cookies.length;
    }
    document.all.selectedID.value = cookies.substring(sepLoc+1, endLoc);
	//подчеркиваем строку в таблице:
	if( document.all.tableID.rows(document.all.selectedID.value) != null ) {
 		document.all.tableID.rows(document.all.selectedID.value,0).className="selected";
	}
}
</script>
<%--html:hidden property="contract"/--%>
<html:hidden property="dirtyComment"/>
<html:hidden property="comment"/>
<html:hidden property="selectedID" value="0" />
<INPUT TYPE="hidden" name="checkCode" ID="checkCode" value="0">

<table class="main" id="tableID" style="font-size: 8pt">

<% 	String disabled = "disabled = 'true'"; %>
<july:canedit rolesProperty="editRoles"><% disabled = "";%></july:canedit>

<july:separator colspan="<%= gColSpan %>"/>
	<TR class="normal">
		<TD colspan="<%= gColSpan %>">
			<table class="find" style="font-size: 8pt">
				<tr>
					<td class="text"  width="10%"><bean:message key="label.dhist.position"/>:</td>
					<td class="text" style="font-weight: normal;" nowrap><bean:write name="DogHistoryListForm" property="posname" filter="true"/></td>
				</tr>
				<tr>
					<td class="text" width="10%"><bean:message key="label.dhist.contract"/>:</td>
					<td class="text" style="font-weight: normal;" nowrap>№ <bean:write name="DogHistoryListForm" property="contrnum" filter="true"/> <bean:message key="label.dhist.contrfrom"/> <july:datewrite name="DogHistoryListForm" property="contrdate"/>,<logic:present name="DogHistoryListForm" property="vendor"><bean:message key="label.dhist.vendor"/>: <bean:write name="DogHistoryListForm" property="vendor" filter="true"/></logic:present>,<br><bean:message key="label.dhist.economist"/>: <bean:write name="DogHistoryListForm" property="economist" filter="true"/>, <bean:message key="label.table.mainmanager"/>: 
					<bean:write name="DogHistoryListForm" property="manager" filter="true"/> 
					</td>
				</tr>
				<tr>
					<td class="text" width="10%"><bean:message key="label.dhist.customer"/>:</td>
					<td class="text" style="font-weight: normal;"><bean:write name="DogHistoryListForm" property="custname" filter="true"/></td>
				</tr>
				<tr>
					<td class="text" width="10%"><bean:message key="label.dhist.contructer"/>:</td>
					<td class="text" style="font-weight: normal;"><bean:write name="DogHistoryListForm" property="orgname" filter="true"/></td>
				</tr>
				<tr>
					<td class="text" width="10%"><bean:message key="label.dhist.resource"/>:</td>
					<td class="text" style="font-weight: normal;" nowrap>
<%--					
						<logic:equal name="DogHistoryListForm" property="manyresources" value="true">
							<july:select styleClass="editsearch" style="width: 450;" collection="resources" property="resource" insertable="true" updatable="true">
								<html:options collection="resources" property="resource" labelProperty="name"/>
							</july:select>
						</logic:equal>
						<logic:equal name="DogHistoryListForm" property="manyresources" value="false">
							<html:hidden property="resource" />
							<july:string property="resname" size="35" insertable="false" updatable="false" />
						</logic:equal>
--%>
							<html:hidden property="resource" />
							<july:string property="resname" size="35" style="font-size: 8pt" insertable="false" updatable="false" />
						
						<july:searchbutton/>
					</td>
				</tr>
				<tr>
					<td class="text" width="10%"><bean:message key="label.dhist.searchby"/>:</td>
					<td class="text" style="font-weight: normal;" nowrap>
						<july:radio property="dateper" value="A" insertable="true" updatable="true"/><bean:message key="label.dhist.allrec"/>
						<july:radio property="dateper" value="C" insertable="true" updatable="true"/><bean:message key="label.dhist.curyear"/>
						<july:radio property="dateper" value="L" insertable="true" updatable="true"/><bean:message key="label.dhist.lastyear"/>
					</td>
				</tr>
				<%--
				<tr>
						<td class="text" width="10%"><bean:message key="label.filter.doccomment"/>:</td>
						<td class="text"><july:textarea cols="50" rows="2" property="comment" insertable="true" updatable="true" onkeyup = "DogHistoryListForm.dirtyComment.value=true;"/></td>
				</tr>
				--%>
			</table>
		</TD>
	</TR>
	<tr class="normal">
		<%-- <td class="text" width="10%"> <bean:message key="label.dhist.addons"/>:</td> --%>
		<td class="text" colspan="<%= gColSpan %>" style="font-weight: normal;">
			<html:link page="/ChargeList.do" paramId="leaseContract" paramName="DogHistoryListForm" 
					paramProperty="contract" styleClass="button">
				<bean:message key="label.dhist.lnkabcharge"/>
			</html:link>		
			<html:link page="/ShowPaymentsList.do" paramId="leaseContract" paramName="DogHistoryListForm" 
					paramProperty="contract" styleClass="button">
				<bean:message key="label.dhist.lnkabpays"/>
			</html:link>
			<july:canedit rolesProperty="editRoles">
			<html:link page="/ShowNFS_List.do" paramId="leaseContract" paramName="DogHistoryListForm" 
					paramProperty="contract" styleClass="button">
				<bean:message key="label.listNFS"/>
			</html:link>
			</july:canedit>
			<html:link page="/ShowFromContractMutualReglamentsList.do" name="DogHistoryListForm" 
					property="paramsForReglament" styleClass="button">
				<bean:message key="label.dhist.lnkregl"/>
			</html:link>
			<%if(request.isUserInRole("administrator")) {%>			
			<html:link page="/ShowSaldoList.do" paramId="leaseContract" paramName="DogHistoryListForm" 
					paramProperty="contract" styleClass="button">
				Old_<bean:message key="label.dhist.lnksaldo"/>
			</html:link>
			<%}%>
			<html:link page="/SaldoDetailList.do" paramId="idContract" paramName="DogHistoryListForm" 
					paramProperty="maincontract" styleClass="button">
				<bean:message key="label.dhist.lnksaldo"/>
			</html:link>
			
			<logic:notEqual name="DogHistoryListForm" property="journalcode" value="0">
				<html:link page="/ShowJournalChargesList.do" paramId="taskStartcode" paramName="DogHistoryListForm" 
						paramProperty="journalcode" styleClass="button">
					<bean:message key="label.dhist.lnkjournal"/>
				</html:link>
			</logic:notEqual>
			<html:link page="/ShowDogAbonentsList.do" paramId="contract" paramName="DogHistoryListForm" 
					paramProperty="maincontract" styleClass="button">
			    <bean:message key="label.dhist.lnkabdog"/>
			</html:link>
			<html:link page="/ViewWeArenda.do?action=View" paramId="leaseDocument" paramName="DogHistoryListForm" 
					paramProperty="contract" styleClass="button">
				<bean:message key="label.dhist.arendadog"/>
			</html:link>
			<html:link page="/ShowHistoryList.do" paramId="leaseDocument" paramName="DogHistoryListForm" 
					paramProperty="maincontract" styleClass="button">
				<bean:message key="label.dhist.arendadop"/>
			</html:link>
			<html:link page="/ShowArendaToNfsZpList.do" paramId="leaseDocument" paramName="DogHistoryListForm" 
					paramProperty="contract" styleClass="button">
				<bean:message key="navtitle.ShowArendaToNfsZpList"/>
			</html:link>			
			<A href='contractCommentEdit.jsp?formname=DogHistoryListForm&fieldnames=comment|dirtyComment' onclick='return openDialog(this.href, "contractCommentEdit", "top=100, left=100, width=600, height=250, scrollbars=yes, resizable=yes");' class='button' title ='<bean:write name="DogHistoryListForm" property="comment"/>' <%= disabled%>>
				<bean:message key="label.dhist.comment"/>
			</A>&nbsp;
			<html:link page="/CompletWorkActsList.do" paramId="idContract" paramName="DogHistoryListForm" 
					paramProperty="contract" styleClass="button">
				<bean:message key="label.dhist.CompletWorkActs"/>
			</html:link>
			<html:link page="/SchetFactList.do" paramId="idContract" paramName="DogHistoryListForm" 
					paramProperty="maincontract" styleClass="button">
				Счета-фактуры
			</html:link>
			<html:link page="/LeasePayOfficeMemoList.do" paramId="idContract" paramName="DogHistoryListForm" 
					paramProperty="maincontract" styleClass="button">
				Служебки на оплату
			</html:link>
			<html:link page="/LeaseZPOfficeMemoList.do" paramId="idContract" paramName="DogHistoryListForm" 
					paramProperty="maincontract" styleClass="button">
				Служебки ЗП
			</html:link>
			<html:link page="/LeaseContractProblemList.do" paramId="idContract" paramName="DogHistoryListForm" 
					paramProperty="maincontract" styleClass="button">
				Инциденты по договору
			</html:link>									
			<A href='AgreementInfo.do?action=View&leaseDocument=<bean:write name="DogHistoryListForm" property="contract"/>' onclick='return openDialog(this.href, "AgreementInfo", "top=100, left=100, width=700, height=500, scrollbars=yes, resizable=yes");' class='button'>
				<bean:message key="label.dhist.contractInfo"/>
			</A>&nbsp;
												
			<%if(request.isUserInRole("None")) {%>
			<html:link page="/ShowChargesList.do" paramId="leaseContract" paramName="DogHistoryListForm" 
					paramProperty="contract" styleClass="button">
				<bean:message key="label.dhist.lnkabcharge"/>(старый режим)
			</html:link>
			<%}%>				
								
<%--
						<BR>
						<html:link page="/EditStartCharge.do?action=Add&condition=C" paramId="leaseDocumentcodeFrm" 
								paramName="DogHistoryListForm" paramProperty="maincontract"styleClass="button">
							<bean:message key="label.dhist.lnkmakecharge"/>
						</html:link>
						<html:link page="/EditStartPayment.do?action=Add&condition=C" paramId="leaseDocumentcodeFrm" 
								paramName="DogHistoryListForm" paramProperty="maincontract" styleClass="button">
							<bean:message key="label.dhist.lnkmakepay"/>
						</html:link>
--%>
		</td>
	</tr>	
	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr class="title">
		<td colspan="<%= gColSpan %>">
			<table class="buttons">
				<tr class="title">
					<td class="buttons">
						<july:backbutton/>
						<INPUT TYPE="IMAGE" NAME="calchist" SRC="/images/fillfromdb.gif" ALT='<bean:message key="label.dhist.btnrecalc"/>' onclick='document.body.style.cursor="wait"'>
					</td>
					<td class="navigator"><july:navigator/></td>
				</tr>
			</table>
		</td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>
	
	<!-- Table header -->
	<tr class="title">
		<td ROWSPAN="2" class="title" style="width: 40;font-size:8pt;font-weight:bold;" VALIGN="TOP"><bean:message key="label.dhist.period"/></td>
		<td ROWSPAN="2" class="title" style="font-size:8pt;font-weight:bold;" VALIGN="TOP" COLSPAN="6"><bean:message key="label.dhist.arenda"/></td>
		<td class="title" style="font-size:8pt;font-weight:bold;" VALIGN="TOP" COLSPAN="6"><bean:message key="label.dhist.apayments"/></td>
		<td class="title" style="font-size:8pt;font-weight:bold;" VALIGN="TOP" COLSPAN="5"><bean:message key="label.dhist.traffic"/></td>
		<td ROWSPAN="2" class="title" style="font-size:8pt;font-weight:bold;" VALIGN="TOP" COLSPAN="3"><bean:message key="label.dhist.tempsld"/></td>
		<td ROWSPAN="1" class="title" style="font-size:8pt;font-weight:bold;" VALIGN="TOP" COLSPAN="5"><bean:message key="label.dhist.acts"/></td>
	</tr>

	<tr class="title">
		<td class="title" style="font-size:8pt;font-weight:bold;" VALIGN="TOP"><bean:message key="label.dhist.ppnumber"/></td>
		<td class="title" style="font-size:8pt;font-weight:bold;" VALIGN="TOP"><bean:message key="label.dhist.ppdate"/></td>
		<td class="title" style="font-size:8pt;font-weight:bold;" VALIGN="TOP"><bean:message key="label.dhist.ppsumm"/></td>
		<td class="title" style="font-size:8pt;font-weight:bold;" VALIGN="TOP"><bean:message key="label.dhist.rate"/></td>
<%--
		<td class="title" style="font-size:8pt;font-weight:bold;" VALIGN="TOP"><bean:message key="label.dhist.ppsf"/></td>
--%>
		<td class="title" style="font-size:8pt;font-weight:bold;" VALIGN="TOP"></td>
		<td class="title" style="font-size:8pt;font-weight:bold;" VALIGN="TOP"></td>
		<td class="title" style="font-size:8pt;font-weight:bold;" VALIGN="TOP"></td>
		<td class="title" style="font-size:8pt;font-weight:bold;" VALIGN="TOP"><bean:message key="label.dhist.chargeabon"/></td>
		<td class="title" style="font-size:8pt;font-weight:bold;" VALIGN="TOP"></td>
		<td class="title" style="font-size:8pt;font-weight:bold;" VALIGN="TOP"><bean:message key="label.dhist.payabon"/></td>
		<td class="title" style="font-size:8pt;font-weight:bold;" VALIGN="TOP"></td>
		<td class="title" style="font-size:8pt;font-weight:bold;" VALIGN="TOP">№</td>
		<td class="title" style="font-size:8pt;font-weight:bold;" VALIGN="TOP">Сальдо по регламенту</td>
		<td class="title" style="font-size:8pt;font-weight:bold;" VALIGN="TOP"></td>
		<td class="title" style="font-size:8pt;font-weight:bold;" VALIGN="TOP"></td>
		<td class="title" style="font-size:8pt;font-weight:bold;" VALIGN="TOP"></td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>

	<!-- Table body -->
	<logic:iterate id="it" name="browseList" indexId="indexId">
		<logic:present name="it">
		<%
			DogHistoryValueObject vo =(DogHistoryValueObject)it;
			//счета-фактуры:
			int flagSF = vo.getFlagSF().intValue();
			String colorFlagSF = "";//flagSF == 3
			String hintSF = "";
			String textSF = "СФ";
			if(flagSF == 0 ){
				colorFlagSF="style='background-color:#CC6666'";//background-color
				hintSF = "Не на всю сумму сделаны СФ, остаток СФ = ";
			}else if(flagSF == 1){
				colorFlagSF="style='background-color:#FFFF00'";//#FFFF99
				hintSF = "СФ не Получены от арендодателя";
			}else if(flagSF == 2){
				colorFlagSF="style='background-color:#99CC99'";
				hintSF = "СФ получены от арендодателя, но не приняты в бухгалтерии";
			}else if(flagSF == 3){
				colorFlagSF="";
				hintSF = "СФ принята в бухгалтерии";				
			}else if(flagSF == 10){
				colorFlagSF="style='background-color:#ACAABB'";
				hintSF = "СФ по старому учету";
			}else if(flagSF == 4){
				colorFlagSF="";
				hintSF = "СФ не нужны";
				textSF = "&nbsp;&nbsp;";
			}			
			//акты выполненных работ:
			int flagCwAct = vo.getFlagCwAct().intValue();
			String colorFlagCwAct = "";//flagCwAct == 3
			String hintCwAct = "";
			String textCwAct = "АВ";
			if(flagCwAct == 0 ){
				colorFlagCwAct="style='background-color:#CC6666'";//background-color
				hintCwAct = "Не на всю сумму сделаны АВР, остаток АВР = ";
			}else if(flagCwAct == 1){
				colorFlagCwAct="style='background-color:#FFFF00'";//#FFFF99
				hintCwAct = "АВР не Получены от арендодателя";
			}else if(flagCwAct == 2){
				colorFlagCwAct="style='background-color:#99CC99'";
				hintCwAct = "АВР получены от арендодателя, но не приняты в бухгалтерии";
			}else if(flagCwAct == 3){
				colorFlagCwAct="";
				hintCwAct = "АВР принята в бухгалтерии";				
			}else if(flagCwAct == 10){
				colorFlagCwAct="style='background-color:#ACAABB'";
				hintCwAct = "АВР по старому учету";
			}else if(flagCwAct == 4){
				colorFlagCwAct="";
				hintCwAct = "АВ не нужны";
				textCwAct = "&nbsp;&nbsp;";
			}					
		%>		
		
			<%--tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'"--%>
				<tr
					id='<bean:write name="indexId" filter="true"/>'
					class="normal" style="font-size: 8pt"
					onMouseOver="className='select'"
					onMouseOut="onMouseOutRow(this.id);" onclick='onClickRow(this.id);'>
			
				<td class="text" style="font-size:8pt;" 
					title='<july:datewrite name="it" property="sdate" shortformat="true"/>-<july:datewrite name="it" property="edate" shortformat="true"/>'>
					<bean:write name="it" property="periodname" filter="true"/>
				</td>
				<td class="text" style="font-size:8pt; text-align: right;" NOWRAP
					title='<bean:write name="it" property="summ" filter="true"/>'>
					<july:numberwrite name="it" property="summ" fractdigits="0"/>
				</td>
				<td class="text" style="font-size:8pt;">
					<bean:write name="it" property="currname" filter="true"/>
				</td>
				<td class="text" style="font-size:8pt;">
					<logic:present name="it" property="idchargearenda">
<%--					
						<july:link page="/EditCharge.do?action=Edit" paramId="leaseDocPosition" paramName="it" paramProperty="idchargearenda">
							<IMG SRC="/images/izmena.gif" BORDER=0 alt='<bean:message key="label.dhist.btncharge"/>'>
						</july:link>
--%>
						<A
							href='ChargeDialog.do?action=Edit&id=<bean:write name="it" property="idchargearenda" filter="true"/>'
							onclick='return openDialog(this.href, "ChargeDialog", "top=150, left=470, width=520, height=460, scrollbars=yes, resizable=yes");'>
						<IMG SRC="/images/izmena.gif" BORDER='0' ALT='Изменить запись'></A>
						
					</logic:present>
				</td>
<%--
				<td class="text" style="font-size:8pt;">
					<logic:present name="it" property="idchargearenda">
						<logic:equal name="it" property="isschetfakt1" value="true">
							<INPUT TYPE="image" NAME="isschetfakt1" <%=disabled%>
								onclick='document.all.checkCode.value=<bean:write name="it" property="idchargearenda"/>; document.body.style.cursor="wait"'
								SRC="/images/check_on.gif" BORDER=0 alt='<bean:message key="label.dhist.btnissf"/> 1'>
						</logic:equal>
						<logic:notEqual name="it" property="isschetfakt1" value="true">
							<INPUT TYPE="image" NAME="isschetfakt1" <%=disabled%>
								onclick='document.all.checkCode.value=<bean:write name="it" property="idchargearenda"/>;document.body.style.cursor="wait"'
								SRC="/images/check_off.gif" BORDER=0 alt='<bean:message key="label.dhist.btnissf"/> 1'>
						</logic:notEqual>
					</logic:present>
				</td>
				<td class="text" style="font-size:8pt;">
					<logic:present name="it" property="idchargearenda">
						<logic:equal name="it" property="isschetfakt2" value="true">
							<INPUT TYPE="image" NAME="isschetfakt2" <%=disabled%> 
								onclick='document.all.checkCode.value=<bean:write name="it" property="idchargearenda"/>;
								document.body.style.cursor="wait"'
								SRC="/images/check_on.gif" BORDER=0 alt='<bean:message key="label.dhist.btnissf"/> 2'>
						</logic:equal>
						<logic:notEqual name="it" property="isschetfakt2" value="true">
							<INPUT TYPE="image" NAME="isschetfakt2" <%=disabled%>
								onclick='document.all.checkCode.value=<bean:write name="it" property="idchargearenda"/>;
								document.body.style.cursor="wait"'
								SRC="/images/check_off.gif" BORDER=0 alt='<bean:message key="label.dhist.btnissf"/> 2'>
						</logic:notEqual>
					</logic:present>
				</td>
				<td class="text" style="font-size:8pt;">
					<logic:present name="it" property="idchargearenda">
						<logic:equal name="it" property="isschetfakt3" value="true">
							<INPUT TYPE="image" NAME="isschetfakt3" <%=disabled%> 
								onclick='document.all.checkCode.value=<bean:write name="it" property="idchargearenda"/>;
								document.body.style.cursor="wait"'
								SRC="/images/check_on.gif" BORDER=0 alt='<bean:message key="label.dhist.btnissf"/> 3'>
						</logic:equal>
						<logic:notEqual name="it" property="isschetfakt3" value="true">
							<INPUT TYPE="image" NAME="isschetfakt3" <%=disabled%> 
								onclick='document.all.checkCode.value=<bean:write name="it" property="idchargearenda"/>;
								document.body.style.cursor="wait"'
								SRC="/images/check_off.gif" BORDER=0 alt='<bean:message key="label.dhist.btnissf"/> 3'>
						</logic:notEqual>
					</logic:present>
				</td>
--%>
				<logic:notPresent name="it" property="idchargearenda">
					<td class="text" style="font-size:8pt;">&nbsp;</td>
					<td class="text" style="font-size:8pt;">&nbsp;</td>
				</logic:notPresent>
				<logic:present name="it" property="idchargearenda">
					<!-- Признак состояния СФ-->
					<td class="text" <%=colorFlagSF %> title="<%=hintSF%> (ост:<july:sumwrite name="it" property="ostSumForSF"/>)" style="text-align: center;"><A href="SchetFactForChargeList.do?chargeCode=<bean:write name="it" property="idchargearenda"/>" style="text-decoration: none; text-align: center;"><%= textSF%></A></td>
					<!-- Признак состояния Актов выполненных работ-->
					<td class="text" <%=colorFlagCwAct %>  title="<%=hintCwAct%> (ост:<july:sumwrite name="it" property="ostSumForCwAct"/>)" style="text-align: center;"><A href='CompletWorkActsForChargeList.do?chargeCode=<bean:write name="it" property="idchargearenda"/>' style="text-decoration: none; text-align: center;"><%= textCwAct%></A></td>
				</logic:present>

				<td class="link" style="font-size:8pt;">
					<logic:present name="it" property="idchargearenda">
<%--
						<july:link page="/ShowChargeRatesList.do" paramId="docpositioncode" paramName="it" paramProperty="idchargearenda" paramScope="page">
							<IMG SRC="/images/rateicon.gif" BORDER=0 alt='<bean:message key="label.dhist.btncrates"/>:&nbsp;<bean:write name="it" property="rateCharge"/>'>
						</july:link>
--%>
<!-- Вызов списка курса (диалога)-->
						<A href='EditRateList.do?action=Edit&docpositioncode=<bean:write name="it" property="idchargearenda"/>' onclick='return openDialog(this.href, "rateListDialog", "top=100, left=100, width=600, height=250, scrollbars=yes, resizable=yes");'>
							<IMG SRC="/images/rateicon.gif" BORDER=0 alt='<bean:message key="label.dhist.btncrates"/>:&nbsp;<bean:write name="it" property="rateCharge"/>'>
						</A>
					</logic:present>
				</td>
				<%--td class="text" style="font-size:8pt;">
					<logic:present name="it" property="idchargearenda">
						<% 
							//String factura = "/EditFactura.do?action=";
							//String temp = factura + "View";
							String factura = "/SchetFactList.do?idContract=" + listForm.getContract();
						%>
						<july:canedit rolesProperty="editRoles"><% factura = factura + "&operation=createSF"; %></july:canedit>
						<july:link page="<%= factura %>" paramId="chargeCode" paramName="it" paramProperty="idchargearenda" paramScope="page">
							<IMG SRC="/images/sf.gif" BORDER=0 alt='<bean:message key="label.dhist.btncsf"/>'>
						</july:link>
					</logic:present>
				</td--%>
				<td class="text" style="font-size:8pt;">
					<bean:write name="it" property="ppnumber" filter="true"/>
				</td>
				<td class="text" style="font-size:8pt;">
					<july:datewrite name="it" property="ppdate" shortformat="true"/>
				</td>
				<td class="text" style="font-size:8pt; text-align: right;" NOWRAP
					title='<bean:write name="it" property="ppsumrub" filter="true"/>'>
					<july:numberwrite name="it" property="ppsumrub" fractdigits="0"/>
				</td>
				<td class="text" style="font-size:8pt; text-align: right;" NOWRAP
					title='<bean:write name="it" property="ratePay" filter="true"/>'>
					<july:numberwrite name="it" property="ratePay" fractdigits="4"/>
				</td>
<%--
				<td class="text" style="font-size:8pt;">
					<logic:present name="it" property="idpayarenda">
						<logic:equal name="it" property="isschetfact" value="true">
							<INPUT TYPE="image" NAME="ispaysf" 
								onclick='document.all.checkCode.value=<bean:write name="it" property="idpayarenda"/>'
								SRC="/images/check_on.gif" BORDER=0 alt='<bean:message key="label.dhist.btnissf"/>'>
						</logic:equal>
						<logic:notEqual name="it" property="isschetfact" value="true">
							<INPUT TYPE="image" NAME="ispaysf" 
								onclick='document.all.checkCode.value=<bean:write name="it" property="idpayarenda"/>'
								SRC="/images/check_off.gif" BORDER=0 alt='<bean:message key="label.dhist.btnissf"/>'>
						</logic:notEqual>
					</logic:present>
				</td>
--%>
				<td class="text" style="font-size:8pt;">
					<logic:present name="it" property="idpayarenda">
						<july:link page="/EditPayment.do?action=Edit" paramId="leaseDocPosition" paramName="it" paramProperty="idpayarenda">
							<IMG SRC="/images/izmena.gif" BORDER=0 alt='<bean:message key="label.dhist.btnpay"/>'>
						</july:link>
					</logic:present>
				</td>
				<td class="text" style="font-size:8pt;">
					<logic:present name="it" property="idpayarenda">
<%-- 
						<july:link page="/ShowPaymentRatesList.do" paramId="docpositioncode" paramName="it" paramProperty="idpayarenda" paramScope="page">
							<IMG SRC="/images/rateicon.gif" BORDER=0 alt='<bean:message key="label.dhist.btnprates"/>'>
						</july:link>
--%>
<!-- Вызов списка курса (диалога)-->
						<A href='EditRateList.do?action=Edit&docpositioncode=<bean:write name="it" property="idpayarenda"/>' onclick='return openDialog(this.href, "rateListDialog", "top=100, left=100, width=600, height=250, scrollbars=yes, resizable=yes");'>
							<IMG SRC="/images/rateicon.gif" BORDER=0 alt='<bean:message key="label.dhist.btnprates"/>'>
						</A>
					</logic:present>
				</td>
				<td class="text" style="font-size:8pt;" title='<bean:write name="it" property="resabonentname" filter="true"/>'>
					<logic:equal name="it" property="arescode" value="E">
							<bean:message key="label.dhist.serv_E"/>
					</logic:equal>
					<logic:equal name="it" property="arescode" value="S">
							<bean:message key="label.dhist.serv_U"/>
					</logic:equal>
					<logic:equal name="it" property="arescode" value="N">
							<bean:message key="label.dhist.serv_N"/>
					</logic:equal>
				</td>
				<td class="text" style="font-size:8pt; text-align: right;" NOWRAP
					title='<bean:write name="it" property="sumchargeabonent" filter="true"/>'>
					<july:numberwrite name="it" property="sumchargeabonent" fractdigits="0"/>
				</td>
				<td class="text" style="font-size:8pt;">
					<logic:present name="it" property="sumchargeabonent">
						<logic:present name="it" property="idhistoryarenda">
							<july:link page="/ShowDogHistChargeList.do" paramId="idhistoryarenda" paramName="it" paramProperty="idhistoryarenda">
								<IMG SRC="/images/kontr.gif" BORDER=0 alt='<bean:message key="label.dhist.btnabscheta"/>'>
							</july:link>
						</logic:present>
					</logic:present>
				</td>
				<td class="text" style="font-size:8pt; text-align: right;" NOWRAP
					title='<bean:write name="it" property="sumpayabonent" filter="true"/>'>
					<july:numberwrite name="it" property="sumpayabonent" fractdigits="0"/>
				</td>
				<td class="text" style="font-size:8pt;">
					<logic:present name="it" property="sumpayabonent">
						<logic:present name="it" property="idhistoryarenda">
							<july:link page="/ShowDogHistPayList.do" paramId="idhistoryarenda" paramName="it" paramProperty="idhistoryarenda">
								<IMG SRC="/images/kontr.gif" BORDER=0 alt='<bean:message key="label.dhist.btnabpays"/>'>
							</july:link>
						</logic:present>
					</logic:present>
				</td>
<!-- Сальдо -->	
				<% String prefiхSldNotes = "";%>
				<logic:equal name="it" property="sldByHand" value="!">
					<% prefiхSldNotes = "Сальдо изменено вручную.\n Причина изменения:\n";%>
				</logic:equal>
				<td class="text" style="font-size:8pt;" title="<%=prefiхSldNotes%><bean:write name="it" property="sldNotes" filter="true"/>">
					<B><bean:write name="it" property="sldByHand" filter="true" /></B>
				</td>			
				<td class="text" style="font-size:8pt; text-align: right;" NOWRAP
					title='<bean:write name="it" property="tempsldsumm" filter="true"/>'>
					<july:numberwrite name="it" property="tempsldsumm" fractdigits="0"/>
				</td>
				<td class="text" style="font-size:8pt;">
					<bean:write name="it" property="tempsldcurr" filter="true"/>
				</td>
<!-- Акты -->				
					<% 
						String keyStr = "";
						if (((com.hps.july.arenda.valueobject.DogHistoryValueObject)it).getActstate() != null) {
							keyStr = "label.dhist.actstate_" + ((com.hps.july.arenda.valueobject.DogHistoryValueObject)it).getActstate();
						}
						String tempIdCodeAct = "";
						if (((com.hps.july.arenda.valueobject.DogHistoryValueObject)it).getIdcodeact() != null) {
							tempIdCodeAct = "" + ((com.hps.july.arenda.valueobject.DogHistoryValueObject)it).getIdcodeact();
						}
						Integer typeDoc = com.hps.july.terrabyte.core.DocumentTypes.LEASE_MUTUAL_ACTS; //тип документа 
						String objectType = com.hps.july.terrabyte.core.ObjectTypes.LEASE_MUTUAL_ACTS; //objectType 
					%>
				<td class="text" style="font-size:8pt;" nowrap="nowrap" title='<logic:present name="it" property="idcodeact"><bean:message 
				  key="label.dhist.actdate"/>: <july:datewrite name="it" property="actdate" 
				  shortformat="true"/>&#13<bean:message key="label.dhist.actsaldo"/>: <bean:write name="it" property="sldsumm" 
				  filter="true"/>&#13<bean:message key="label.dhist.actsaldocurr"/>: <bean:write name="it" property="sldcurr" 
				  filter="true"/>&#13<bean:message key="label.dhist.actstate"/>: <bean:message key="<%= keyStr %>"/></logic:present>'>
					<bean:write name="it" property="actnum" filter="true"/>
				</td>
				<td class="text" style="font-size:8pt;" nowrap="nowrap">
					<logic:present name="it" property="idcodeact"><july:numberwrite name="it" property="sldsumm" fractdigits="0"/> <bean:write name="it" property="sldcurr" filter="true"/></logic:present>
				</td>
				<td class="text" style="font-size:8pt;" nowrap="nowrap">
					<logic:present name="it" property="idcodeact">
						<july:canedit rolesProperty="editRoles">
						<july:wordedit styleId='<%= "wrded1_" + tempIdCodeAct %>' url='<%= "MutactWordAction.do?actcode=" + tempIdCodeAct %>' 
							uploadurl='<%= "DocumentUploadAction.do?typeDoc=" + typeDoc + "&objectType=" + objectType %>' documentid="<%= tempIdCodeAct %>"
							addurl='<%= "http://" + request.getServerName() + "/arenda/header.jsp?actcode=" + tempIdCodeAct %>'>
							<IMG SRC="/images/docword.gif" border="0" alt='<bean:message key="label.mutaulacts.createword"/>'></july:wordedit>
						<%--july:wordedit styleId='<%= "wrded1_" + tempIdCodeAct %>' url='<%= "MutactWordAction.do?actcode=" + tempIdCodeAct %>' 
							uploadurl="MutualActWordUploadAction.do" documentid="<%= tempIdCodeAct %>"
							addurl='<%= "http://" + request.getServerName() + "/arenda/header.jsp?actcode=" + tempIdCodeAct %>'>
							<IMG SRC="/images/docword.gif" border="0" alt='<bean:message key="label.mutaulacts.createword"/>' onclick='document.body.style.cursor="wait";'></july:wordedit--%>
						</july:canedit>
						<%--july:wordedit styleId='<%= "wrded2_" + tempIdCodeAct %>' url='<%= "MutualActDownload?actcode=" + tempIdCodeAct %>'
							uploadurl="MutualActWordUploadAction.do" documentid="<%= tempIdCodeAct %>">
							<IMG SRC="/images/getdbword.gif" border="0" alt='<bean:message key="label.mutualacts.fromdb"/>' onclick='document.body.style.cursor="wait";'></july:wordedit--%>
						<july:wordedit styleId='<%= "wrded2_" + tempIdCodeAct %>' url='<%= "DocumentWordDownloadServlet?id=" + tempIdCodeAct + "&objectTypes=" + objectType %>'
							uploadurl='<%= "DocumentUploadAction.do?typeDoc=" + typeDoc + "&objectType=" + objectType %>' documentid="<%= tempIdCodeAct %>">
							<IMG SRC="/images/getdbword.gif" border="0" alt='<bean:message key="label.mutualacts.fromdb"/>'></july:wordedit>
					</logic:present>
<%-- 
						<july:printbutton page="/MutactEqualReport.do" paramId="leaseDocument" 
							paramName="it" paramProperty="idcodeact" 
							title="label.dhist.btnprintact"/>
--%>
				</td>
				<td class="text" style="font-size:8pt;">
					<logic:present name="it" property="idcodeact">
						<logic:equal name="it" property="actstate" value="C">
							<INPUT TYPE="image" NAME="isstateact" <%=disabled%> 
								onclick='document.all.checkCode.value=<bean:write name="it" property="idcodeact"/>'
								SRC="/images/check_on.gif" BORDER=0 ALT='<logic:present name="it" property="idcodeact"><bean:message key="<%= keyStr %>"/></logic:present>'>
						</logic:equal>
						<logic:equal name="it" property="actstate" value="R">
							<INPUT TYPE="image" NAME="isstateact" <%=disabled%> 
								onclick='document.all.checkCode.value=<bean:write name="it" property="idcodeact"/>'
								SRC="/images/check_off.gif" BORDER=0 ALT='<logic:present name="it" property="idcodeact"><bean:message key="<%= keyStr %>"/></logic:present>'>
						</logic:equal>
					</logic:present>
				</td>
<%--
				<td class="text" style="font-size:8pt;">
					<logic:present name="it" property="idcodeact">
						<logic:equal name="it" property="isactschetfact" value="true">
							<INPUT TYPE="image" NAME="isactsf" 
								onclick='document.all.checkCode.value=<bean:write name="it" property="idcodeact"/>'
								SRC="/images/check_on.gif" BORDER=0 ALT='<bean:message key="label.dhist.btnissf"/>'>
						</logic:equal>
						<logic:notEqual name="it" property="isactschetfact" value="true">
							<INPUT TYPE="image" NAME="isactsf" 
								onclick='document.all.checkCode.value=<bean:write name="it" property="idcodeact"/>'
								SRC="/images/check_off.gif" BORDER=0 ALT='<bean:message key="label.dhist.btnissf"/>'>
						</logic:notEqual>
					</logic:present>
				</td>
--%>			
				<td class="text" style="font-size:8pt;">
					<logic:present name="it" property="idcodeact">
						<%
							String afactura = "/ShowFacturaMutactList.do";
						%>
						<july:link page="<%= afactura %>" paramId="leaseDocument" paramName="it" paramProperty="idcodeact" paramScope="page">
							<IMG SRC="/images/sf.gif" BORDER=0 alt='<bean:message key="label.mutualreglmnts.factura"/>'>
						</july:link>
					</logic:present>
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
						<july:backbutton/>
						<INPUT TYPE="IMAGE" NAME="calchist" SRC="/images/fillfromdb.gif" ALT='<bean:message key="label.dhist.btnrecalc"/>' onclick='document.body.style.cursor="wait"'>
					</td>
					<td class="navigator"><july:navigator/></td>
				</tr>
			</table>
		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>" />

</table>
<script language="javascript">
	loadSelectedRow();
	//window.location.hash=document.all.selectedID.value;
	stat=1;
</script>
</july:browseform>
				
<%--jsp:include page="common/bottom.jsp" flush="true"/--%>
