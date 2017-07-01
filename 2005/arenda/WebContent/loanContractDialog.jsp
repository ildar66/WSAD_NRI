<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.arenda.*,com.hps.july.arenda.formbean.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<SCRIPT language=javascript src="/common/validate.js" type="text/javascript"></SCRIPT>
<SCRIPT language=javascript src="/common/dialog.js" type="text/javascript"></SCRIPT>  

<% java.lang.String gColSpan = "2"; %>

<%
	String action = "/LoanContractProcess.do";
	String form = "LoanContractDialogForm";
	String src = "/images/save.gif";
	String alt = "Сохранить запись";
	String isCertain = "true";
	String isUpdatable = "false";
	boolean isAdministrator = request.isUserInRole("administrator"); 
%>

<july:errors property="org.apache.struts.action.GLOBAL_ERROR"/>

<july:editform action="<%= action %>" styleId="<%= form %>">
<html:hidden property="id"/>

<logic:equal name="<%= form %>" property="action" value="Delete">
		<% src = "/images/delconf.gif"; alt = "Удалить запись"; %>
</logic:equal>
<logic:equal name="<%= form %>" property="action" value="Add">
	<% isCertain = "false"; %>
</logic:equal>
<logic:equal name="<%= form %>" property="vo.contractState" value="A">
	<% isUpdatable = "true"; %>
</logic:equal>
<% String isUpdatableNew = "true"; %>
<logic:equal name="<%= form %>" property="vo.contractState" value="C">
	<% isUpdatableNew = "false"; %>
</logic:equal>

<script language="javascript">
	function Close()
		{
			if(window.opener) {
				opener.storeSelectedRow(document.all.id.value);
				//opener.location.reload(true);
				window.opener.window.document.forms(0).submit();
				//window.opener.window.location.href=window.opener.window.location.href;
				window.opener.focus();
			}
			window.close();
		}
	function Check()
	{
	<logic:notEqual name="<%= form %>" property="action" value="Delete">
		var theForm = document.<%= form %>;
		with(theForm){
			if(!field_check(theForm.docnumber, 'Номер договора', 0, true)) return false;
			if(!field_check(theForm.docdateStr, 'Дата договора', 0, true)) return false;
			if(!field_check(theForm.planSumStr,'Планируемая стоимость',6,true)) return false;
			if(!field_check(theForm['vo.orgCustomer.organization'], 'Ссудополучатель(из справочника)',0,true)) return false;
			if(!field_check(theForm['orgExecutor'], 'Исполнитель',3,true)) return false;
		}
	</logic:notEqual>
		return true;
	}
</script>

<table class="main"  style="font-size:8pt;">

<july:separator colspan="<%= gColSpan %>"/>
    <tr class="title">
    	<td class="title" colspan="<%= gColSpan %>">
			<logic:notEqual name="<%= form %>" property="vo.contractState" value="C">
				<INPUT TYPE="IMAGE" NAME="submit" SRC="<%= src%>"  ALT="<%= alt %>" styleID="submitID" onclick="return Check();">
			</logic:notEqual>
			&nbsp;<july:closebutton page="/"/>
        </td>
    </tr>

<logic:notEqual name="<%= form %>" property="vo.contractState" value="C">
<july:separator colspan="<%= gColSpan %>"/>
    <tr>
        <td class="title" colspan="<%= gColSpan %>"><july:actionalert/></td>
    </tr>
</logic:notEqual>

<july:separator colspan="<%= gColSpan %>"/>	
	<tr>
		<td class="text"><july:reqmark>Договор:</july:reqmark></td> 
		<td class="text">№
			<july:string size="10" property="vo.docnumber" styleId="docnumber" insertable="true" updatable="<%=isUpdatable%>"/>&nbsp;&nbsp;&nbsp;
			Дата:<july:date property="docdateStr" size="20" insertable="true" updatable="<%=isUpdatable%>" required="<%= isCertain %>" styleId="docDate"/>
		</td>
    </tr>
<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text"><july:reqmark>Срок действия:</july:reqmark></td>
		<td>
			c   &nbsp;<july:date property="startDateStr" size="25" insertable="true" updatable="<%=isUpdatable%>"/>&nbsp;
			по&nbsp;	<july:date property="endDateStr" size="25" insertable="true" updatable="<%=isUpdatable%>"
			styleId="baseEndDate"/>
		</td>
	</tr>
<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text"><july:reqmark><bean:message key="label.filter.executor"/>:</july:reqmark></td>
		<td class="text">
			<july:select styleId="orgExecutor" style="width: 300;" collection="executors" property="vo.orgExecutor.organization" insertable="true" updatable="true">
				<html:option value="">&nbsp;</html:option>
				<html:options collection="executors" property="idOwnerContract" labelProperty="name"/>
			</july:select>
		</td>
	</tr>	
<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text"><july:reqmark>Ссудополучатель:</july:reqmark></td> 
		<td class="text">
			<html:hidden property="vo.orgCustomer.organization"/>
			<logic:equal name="<%= form %>" property="vo.contractState" value="A">
				<%--html:link page="/../dict/PersonLookupList.do?formname=LoanContractDialogForm&fieldnames=vo.orgCustomer.organization|vo.orgCustomer.name&isName=false" onclick="window.open(this.href+'&name='+document.all.voOrgCustomerName.value, 'pWindow', 'top=80, left=200, width=750, height=500, scrollbars=yes, resizable=yes').focus(); return false;" title="справочник"><IMG SRC="/images/people.gif" BORDER='0' ALT='справочник физ. лиц'></html:link--%>
					<html:link page="/../dict/VendorSiteLookupList.do?formname=LoanContractDialogForm&fieldnames=vo.orgCustomer.organization||vo.orgCustomer.name&isName=false" onclick="return openDialog(this.href, 'VendorSitesLookupList', 'top=40, left=100, width=700, height=650, scrollbars=yes, resizable=yes');" title="справочник отделений(физ.лиц)">
						<img src='/images/lookup.gif' border='0' alt='Справочник поставщиков' name="lookupimg_execl"></html:link>						
			</logic:equal>
			<%--july:lookupbutton action="/ShowOrganizationLookupList.do" styleId="orgl" fieldNames="vo.orgCustomer.organization;vo.orgCustomer.name" newWindowName="orglookup" insertable="true" updatable="<%=isUpdatable%>"/--%>
			<july:string size="30" property="vo.orgCustomer.name" styleId="voOrgCustomerName" insertable="true" updatable="<%=isUpdatable%>"/>
		</td>
    </tr>
<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text">Позиция:</td> 
		<td class="text">
			<html:hidden property="vo.mainpositionVO.storageplace" styleId="mainpositionKey"/>
			<july:lookupbutton action="/../basestation/ShowPositionLookupList.do?planstate=2" styleId="posl" fieldNames="vo.mainpositionVO.storageplace;;vo.mainpositionVO.name" insertable="true" updatable="<%=isUpdatableNew%>"/>
			<july:string size="35" property="vo.mainpositionVO.name" insertable="false" updatable="false" styleId="mainpositionName"/>
			<% if(isAdministrator && isUpdatableNew.equals("true")) {%>
			<A href='#' onclick='mainpositionName.value=""; mainpositionKey.value=""; return false;'>
				<IMG SRC="/images/iskl.gif" BORDER='0' ALT='Исключить позицию'>
			</A>
			<% } %>
		</td>
    </tr>
<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text">Отв. экономист:</td> 
		<td class="text">
			<html:hidden property="vo.economistVO.worker" styleId="economistWorker"/>
			<july:lookupbutton action="/ShowWorkerLookupList.do" styleId="economistl" fieldNames="vo.economistVO.worker;vo.economistVO.name" newWindowName="economistlookup" insertable="true" updatable="<%=isUpdatableNew%>"/>
			<july:string size="35" property="vo.economistVO.name" insertable="false" updatable="false" styleId="economistName"/>
			<% if(isAdministrator && isUpdatableNew.equals("true")) {%>
			<A href='#' onclick='economistName.value=""; economistWorker.value="0"; return false;'>
				<IMG SRC="/images/iskl.gif" BORDER='0' ALT='Исключить менеджера'>
			</A>
			<% } %>
		</td>
    </tr>
<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text">Отв. менеджер:</td> 
		<td class="text">
			<html:hidden property="vo.managerVO.worker" styleId="managerWorker"/>
			<july:lookupbutton action="/ShowWorkerLookupList.do" styleId="managerl" fieldNames="vo.managerVO.worker;vo.managerVO.name" newWindowName="managerlookup" insertable="true" updatable="<%=isUpdatableNew%>"/>
			<july:string size="35" property="vo.managerVO.name" insertable="false" updatable="false" styleId="managerName"/>
			<% if(isAdministrator && isUpdatableNew.equals("true")) {%>
			<A href='#' onclick='managerName.value=""; managerWorker.value="0"; return false;'>
				<IMG SRC="/images/iskl.gif" BORDER='0' ALT='Исключить менеджера'>
			</A>
			<% } %>
		</td>
    </tr>
<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text">Предмет договора:</td> 
		<td class="text">
				<july:textarea cols="25" rows="2" property="vo.docSubject" insertable="true" updatable="<%=isUpdatable%>"/>
		</td>
    </tr>
<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text"><july:reqmark>Планируемая<BR>стоимость:</july:reqmark></td>
		<td class="text">
			<july:string size="10" property="planSumStr" insertable="true" updatable="<%=isUpdatable%>"/>&nbsp;
		    <july:select style="width: 130;" collection="currencies" property="vo.planCurrVO.currency" insertable="true" updatable="<%=isUpdatable%>">
				<html:options collection="currencies" property="currency" labelProperty="name"/>
		   	</july:select>
			<july:select style="width: 130;" property="vo.chargeNds" insertable="true" updatable="<%=isUpdatable%>">
				<html:option value="true">без НДС</html:option>
				<html:option value="false">в том числе НДС</html:option>
			</july:select>
		</td>
	</tr>
<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text">Комментарий:</td> 
		<td class="text">
				<july:textarea cols="25" rows="4" property="vo.docComment" insertable="true" updatable="<%=isUpdatable%>"/>
		</td>
    </tr>
<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text">Причина выдачи:</td> 
		<td class="text">
				<july:textarea cols="25" rows="3" property="vo.reason" insertable="true" updatable="<%=isUpdatable%>"/>
		</td>
    </tr>
<july:separator colspan="<%= gColSpan %>"/>
    <tr class="title">
    	<td class="title" colspan="<%= gColSpan %>">
			<logic:notEqual name="<%= form %>" property="vo.contractState" value="C">
				<INPUT TYPE="IMAGE" NAME="submit" SRC="<%= src%>"  ALT="<%= alt %>" styleID="submitID" onclick="return Check();">
			</logic:notEqual>
			&nbsp;<july:closebutton page="/"/>
        </td>
    </tr>
	<july:separator colspan="<%= gColSpan %>"/>
	
</table>

<logic:equal name="<%=form%>" property="flagOperation" value="true">
	<script language="javascript" type="text/javascript">
		 Close();
	</script>
</logic:equal>

<script language="javascript" type="text/javascript">
	if(<%= form %>.docnumber != null)
		<%= form %>.docnumber.focus();
</script>

</july:editform>
