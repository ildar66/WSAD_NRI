<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.arenda.*,com.hps.july.arenda.formbean.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<% String gColSpan = "6"; %>

<july:browseform action="/ShowArendaToNfsZpList.do" styleId="ArendaToNfsZpListForm">
<html:hidden property="leaseDocument"/>
<html:hidden property="idZpNfs"/>
<html:hidden property="action"/>

<script language="javascript"> 

function DeleteZP(idZpNfs, numberZp) {
	if(confirm('Удалить запись c номером ЗП: ' + numberZp + ' ?')) {
		var thisform = document.ArendaToNfsZpListForm;
		thisform.idZpNfs.value = idZpNfs;
		thisform.action.value = "Delete";
		document.body.style.cursor="wait";
		thisform.submit();
		return false;
	}
}
function EditZP(idZpNfs) {
	document.all.idZpNfs.value=idZpNfs;
	document.all.action.value="Edit";
	document.body.style.cursor="wait";
	document.ArendaToNfsZpListForm.submit();
	return false;
}
</script>

<table class="main">

	<july:separator colspan="<%= gColSpan %>"/>

	<TR class="normal">
		<TD colspan="<%= gColSpan %>">
			<table class="find">
				<tr>
					<td class="text"><bean:message key="label.filter.docnumber"/>:</td>
					<td class="text" nowrap><bean:write name="ArendaToNfsZpListForm" property="agreement.mainDocumentNumber" filter="true"/></td>
				</tr>
				<tr>
					<td class="text"><bean:message key="label.filter.docperiod"/>:</td>
					<td class="text" nowrap>
						<july:datewrite name="ArendaToNfsZpListForm" property="agreement.mainStartDate"/>&nbsp;
						<bean:message key="label.filter.stop"/>&nbsp;
						<july:datewrite name="ArendaToNfsZpListForm" property="agreement.mainEndDate"/>
					</td>
				</tr>
				<tr>
					<td class="text"><bean:message key="label.filter.customer"/>:</td>
					<td class="text" nowrap>
						<logic:present name="ArendaToNfsZpListForm" property="agreement.mainOrgCustomer">
							<bean:write name="ArendaToNfsZpListForm" property="agreement.mainOrgCustomer.name" filter="true"/>
						</logic:present>
					</td>
				</tr>
				<tr>
					<td class="text"><bean:message key="label.filter.executor"/>:</td>
					<td class="text" nowrap>
						<logic:present name="ArendaToNfsZpListForm" property="agreement.mainOrgExecutor">
							<bean:write name="ArendaToNfsZpListForm" property="agreement.mainOrgExecutor.name" filter="true"/>
						</logic:present>
					</td>
				</tr>
				<tr>
					<td class="text"><bean:message key="label.filter.costcurrency"/>:</td>
					<td class="text" nowrap>
						<july:sumwrite name="ArendaToNfsZpListForm" property="agreement.o.summ1"/>&nbsp;
						<bean:write name="ArendaToNfsZpListForm" property="agreement.o.currency1.name" filter="true"/>
						<logic:present name="ArendaToNfsZpListForm" property="agreement.o.currency2">
							;&nbsp;<july:sumwrite name="ArendaToNfsZpListForm" property="agreement.o.summ2"/>
							&nbsp;<bean:write name="ArendaToNfsZpListForm" property="agreement.o.currency2.name" filter="true"/>
						</logic:present>					
					</td>
				</tr>
				<tr>
					<td class="text"><bean:message key="label.filter.economist"/>:</td>
					<td class="text" nowrap>
						<logic:present name="ArendaToNfsZpListForm" property="agreement.mainEconomist">
							<bean:write name="ArendaToNfsZpListForm" property="agreement.mainEconomist.name" filter="true"/>
						</logic:present>
					</td>
				</tr>
			</table>
		</TD>
	</TR>

	<july:separator colspan="<%= gColSpan %>"/>

		<tr class="title">
		<td colspan="<%= gColSpan %>">
			<table class="buttons">
				<tr class="title">
					<td class="buttons">
						<july:backbutton/>&nbsp;
						<html:link page="/ShowNFS_ZpLookupList.do?action=Add&formname=ArendaToNfsZpListForm&fieldnames=idZpNfs" onclick="return openDialog(this.href, 'ShowNFS_ZpLookupList', 'top=40, left=100, width=830, height=630, scrollbars=yes, resizable=yes');" styleClass="button">
							<B> Выбрать ЗП из NFS </B></html:link>						
					</td>
					<td class="navigator"><july:navigator/></td>
				</tr>
			</table>
		</td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>

	<%--tr class="normal">
	<td class="text" colspan="<%= gColSpan %>">
		<table border="0" width="100%" cellpadding="3" cellspacing="0">
			<tr>
				<td width="80%">
					<html:link page="/ShowNFS_ZpLookupList.do?action=Add&formname=ArendaToNfsZpListForm&fieldnames=idZpNfs" onclick="window.open(this.href, 'pWindow', 'top=40, left=100, width=830, height=630, scrollbars=yes, resizable=yes').focus(); return false;" styleClass="button">
						Выбрать ЗП из NFS</html:link>
				</td>
			</tr>
		</table>
	</td>
	</tr--%>

	<%--july:separator colspan="<%= gColSpan %>"/--%>

	<!-- Table header -->
	<tr class="title">
		<td class="title">номер ЗП</td>
		<td class="title">сумма ЗП</td>
		<td class="title">наименование поставщика</td>
		<td class="title"> статус NRI</td>
		<td class="title"> статус NFS</td>
		<td class="title">&nbsp;</td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>

	<!-- Table body -->
	<logic:iterate id="it" name="browseList">
		<logic:present name="it">
			<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
				<td class="text">
         	        <bean:write name="it" property="numZp" filter="true"/>
                </td>
				<td class="text">
					<july:sumwrite name="it" property="sumZp"/>&nbsp;<bean:write name="it" property="currZp" filter="true"/>
                </td>
				<td class="text">
         	        <bean:write name="it" property="vendor.name" filter="true"/>
                </td>
				<td class="text">
						<logic:equal name="it" property="isActive" value="true">
							<INPUT TYPE="image" NAME="isActive" 
								onclick='EditZP(<bean:write name="it" property="idZpNfs"/>);'
								SRC="/images/check_on.gif" BORDER=0 alt='Сбросить признак активности'>
						</logic:equal>
						<logic:notEqual name="it" property="isActive" value="true">
							<INPUT TYPE="image" NAME="isActive" 
								onclick='EditZP(<bean:write name="it" property="idZpNfs"/>);'
								SRC="/images/check_off.gif" BORDER=0 alt='Установить признак активности'>
						</logic:notEqual>
                </td>
				<td class="text">
         	        <bean:write name="it" property="stateZp" filter="true"/>
                </td>
				<td class="text">
					<A href='javascript:DeleteZP(<bean:write name="it" property="idZpNfs" filter="true"/>, "<bean:write name="it" property="numZp" filter="true"/>")' title="Удалить запись">
						<img src="/images/del.gif" border=0 alt='Удалить запись '></A>
                </td>
				<july:separator colspan="<%= gColSpan %>"/>
			</tr>
		</logic:present>
	</logic:iterate>

	<tr class="title">
		<td colspan="<%= gColSpan %>">
			<table class="buttons">
				<tr class="title">
					<td class="buttons">
						<july:backbutton/>
					</td>
					<td class="navigator"><july:navigator/></td>
				</tr>
			</table>
		</td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>

</table>

<%--P align="center"><B>Режим в процессе разработки(просьба не ругаться :)</B></P--%>

</july:browseform>

