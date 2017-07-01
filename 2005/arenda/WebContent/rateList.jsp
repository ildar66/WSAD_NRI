<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.arenda.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import="com.hps.july.arenda.formbean.*"%>

<% String gColSpan = "6"; %>

<july:browseform action="/EditRateList.do" styleId="RateListForm">
<html:hidden property="docpositioncode"/>
<html:hidden property="currencycode"/>
<html:hidden property="operation"/>

<script language="javascript">
function DeleteRate(currencyName, currencyCode) {
	if(confirm('������� ����: ' + currencyName+ ' ?')) {
		document.all.currencycode.value = currencyCode;
		document.all.operation.value = "deleteRateVO";
		document.body.style.cursor="wait";
		RateListForm.submit();
		return false;
	}
}
function AddRate() {
	var cur = document.all['rateVO.currencyVO.currency'].value;
	if(document.all['rateList'].rows(cur) != null){
		alert("������ ������ ������������ � ������! ������� �� �������������.");
		return;
	}
	if(document.all['rateStr'].value == ''){
		alert("������� ����!");
		document.all['rateStr'].focus();
		return;
	}
	document.all.operation.value = "addRateVO";
    document.body.style.cursor="wait";
	RateListForm.submit();
	return false;
}
function UpdateRate() {
	if(document.all['rateStr'].value == ''){
		alert("������� ����!");
		document.all['rateStr'].focus();
		return;
	}
	document.all.operation.value = "updateRateVO";
    document.body.style.cursor="wait";
	RateListForm.submit();
	return false;
}
function SetRate(currencyCode) {
	document.all.currencycode.value = currencyCode;
	document.all.operation.value = "setRateVO";
    document.body.style.cursor="wait";
	RateListForm.submit();
	return false;
}
function CloseAndUpdate()
	{
		if(window.opener) {
			//alert(window.opener.window.location.href);//temp
			//opener.location.reload(true);
			opener.location.href=opener.location.href;
			//var f = window.opener.window.document.forms;
			//alert(f(0).name);
			//f(0).submit();
			//window.opener.focus();
		}
		window.close();
	}
</script>
<table class="main" id="rateList">

	<july:separator colspan="<%= gColSpan %>"/>
    <tr class="title">
    	<td class="title" colspan="<%= gColSpan %>">
			<july:closebutton page="/"/>&nbsp;&nbsp;
			<I><bean:write name="RateListForm" property="headerUpdLeaseRates" filter="true"/></I>
        </td>
    </tr>
	<july:separator colspan="<%= gColSpan %>"/>

	<!-- Table header -->
	<tr class="title">
		<td class="title">&nbsp;</td>
		<td class="title">������</td>
		<td class="title">���� ������ �� ���. � �����</td>
		<td class="title">�����</td>
		<td class="title">�������</td>
		<td class="title">&nbsp;</td>
	</tr>

	<%
		String _class = "normal";
		RateListForm aform =  (RateListForm)session.getAttribute("RateListForm"); 
		int currencycode = aform.getCurrencycode();
		int isCalcAct = aform.getIsCalcAct();
	%>
	<!-- Table body -->
	<logic:iterate id="it" name="browseList">
		<logic:present name="it">
		<logic:present name="it" property="currencyVO">
			<logic:equal name="it" property="currencyVO.currency" value="<%=String.valueOf(currencycode)%>">
				<% _class = "selected";%>
			</logic:equal>
			<logic:notEqual name="it" property="currencyVO.currency" value="<%=String.valueOf(currencycode)%>">
				<% _class = "normal";%>
			</logic:notEqual>
		</logic:present>
			<tr class="<%=_class%>" id = '<bean:write name="it" property="currencyVO.currency" filter="true"/>' onMouseOver="className='select'" onMouseOut="className='<%=_class%>'">
				<td class="text">
					<%if(isCalcAct == 1){%>
						<july:canedit rolesProperty="editRoles">
							<A href='javascript:SetRate(<bean:write name="it" property="currencyVO.currency" filter="true"/>)' title="������������� �������">
								<IMG SRC="/images/izmena.gif" BORDER='0' ALT='������������� ����'></A>
						</july:canedit>
					<%}%>
				</td>
				<td class="text">
						<bean:write name="it" property="currencyVO.shortname" filter="true"/>
				</td>
				<td class="number" align="right">
					<july:numberwrite name="it" property="rate"/>
				</td>
				<td class="number" align="right">
						<bean:write name="it" property="sumLeaseCalcRate" filter="true"/>
				</td>
				<td class="text" align="center">
<%--			<logic:equal name="it" property="byhand" value="Y">+</logic:equal>		--%>
					<logic:equal name="it" property="source" value="0">�������</logic:equal>
					<logic:equal name="it" property="source" value="1">�� ����</logic:equal>
					<logic:equal name="it" property="source" value="2">�� ������� (NFS)</logic:equal>
					<logic:equal name="it" property="source" value="3">�� ������� (Billing)</logic:equal>
				</td>
				<td class="link">
					<%if(isCalcAct == 1){%>
						<july:canedit rolesProperty="editRoles">
								<A href='javascript:DeleteRate("<bean:write name="it" property="currencyVO.shortname" filter="true"/>", <bean:write name="it" property="currencyVO.currency" filter="true"/>)' title="������� ����">
									<IMG SRC="/images/del.gif" BORDER='0' ALT='������� ����'>
								</A>
						</july:canedit>
					<%}%>
				</td>
<%--
				<td class="text">
					<logic:present name="it" property="actVO">
						<bean:write name="it" property="actVO.documentNumber" filter="true"/>
					</logic:present>
					<logic:notPresent name="it" property="actVO">
						<logic:equal name="it" property="byhand" value="true">
							<bean:message key="label.leasecalcrate.cursbyhand"/>
						</logic:equal>
					</logic:notPresent>
				</td>
				<td class="number" align="right">
					<july:sumwrite name="it" property="sum"/>
				</td>
--%>
            </tr>
	      </logic:present>
        </logic:iterate>

	<july:separator colspan="<%= gColSpan %>"/>

	</table>

	<!-- �������������� ����� -->
<%if(isCalcAct == 1){%>
<july:canedit rolesProperty="editRoles">
	<table class="main">
    <tr>
 		<logic:notPresent name="RateListForm" property="rateVO.leaseDocPosition">
			<b>���������� �����:</b>
		</logic:notPresent>
		<logic:present name="RateListForm" property="rateVO.leaseDocPosition">
			<b>��������� �����:</b>
		</logic:present>
    </tr>
	<tr>
		<td class="text"><july:reqmark>������:</july:reqmark></td>
		<td class="text">
 		<logic:notPresent name="RateListForm" property="rateVO.leaseDocPosition">
			    <july:select style="width: 300;" collection="currencies" property="rateVO.currencyVO.currency" insertable="true" updatable="true">
					<html:options collection="currencies" property="currency" labelProperty="name"/>
			   	</july:select>
		</logic:notPresent>
		<logic:present name="RateListForm" property="rateVO.leaseDocPosition">
			    <july:select style="width: 300;" collection="currencies" property="rateVO.currencyVO.currency" insertable="false" updatable="false">
					<html:options collection="currencies" property="currency" labelProperty="name"/>
			   	</july:select>
		</logic:present>
		</td>
    </tr>

	<tr>
		<td class="text"><july:reqmark>����:</july:reqmark></td>
		<td class="text" nowrap>
			<july:string property="rateStr" size="25" insertable="true" updatable="true" styleId="rate"/>&nbsp;&nbsp;
			<july:date size="25" property="ratedatecalcFrm" styleId="ratedatecalcFrm" insertable="true" updatable="true"/>&nbsp;
			<input type='image' name='ratedatecalcSubmit' value='1' src='/images/obchet1.gif' alt='<bean:message key="label.filter.calcrateondate"/>' onclick='document.all.operation.value = "calcRateOnDate";'>
		</td>
	</tr>

	<tr class="title">
		<td colspan="<%= gColSpan %>">
			<logic:present name="RateListForm" property="rateVO.leaseDocPosition">
				<A href='javascript:UpdateRate()' title="�������� ����">
					<IMG SRC="/images/save.gif" BORDER='0' ALT='�������� ����'>
				</A>
			</logic:present>
			<logic:notPresent name="RateListForm" property="rateVO.leaseDocPosition">
				<A href='javascript:AddRate()' title="�������� ����">
					<IMG SRC="/images/save.gif" BORDER='0' ALT='�������� ����'>
				</A>
			</logic:notPresent>
		</td>
	<tr>

	<july:separator colspan="<%= gColSpan %>"/>

    <tr class="title">
    	<td class="title" colspan="<%= gColSpan %>">
			<july:closebutton page="/"/>
			<A href='javascript:CloseAndUpdate()' title="������� � �������� ������������ ����">
					<IMG SRC="/images/dictrefrsh.gif " BORDER='0' ALT='������� � �������� ������������ ����'>
			</A>
        </td>
    </tr>

 	<july:separator colspan="<%= gColSpan %>"/>
	</table>
</july:canedit>
<%}%>
</july:browseform>