<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.arenda.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<SCRIPT language=javascript src="/common/validate.js" type="text/javascript"></SCRIPT> 

<% java.lang.String gColSpan = "2"; %>

<%
	String action = "/DnopProcess.do";
	String form = "DnopDialogForm";
	String temp = null;
	String src = "/images/save.gif";
	String alt = "��������� ������";	
%>
<july:errors property="org.apache.struts.action.GLOBAL_ERROR"/>

<july:editform action="<%= action %>" styleId="<%= form %>">

<html:hidden property="leaseCharge"/>
<html:hidden property="leasePayment"/>

<logic:equal name="<%= form %>" property="action" value="Delete">
		<% src = "/images/delconf.gif"; alt = "������� ������"; %>
</logic:equal>

<script language="javascript">
function Close(){
		if(window.opener) {
			opener.storeSelectedRow(document.all.id.value);
			//opener.location.reload(true);
			window.opener.window.document.forms(0).submit();
			//window.opener.window.location.href=window.opener.window.location.href;
			window.opener.focus();
		}
		window.close();
}
function Check(){
	var theForm = document.<%= form %>;
	with(theForm){
<logic:notEqual name="<%= form %>" property="action" value="Delete">	
		//if(!field_check(theForm.summStr, '����� ����������', 6, true)) return false;
		//if(!field_check(theForm.beginDateStr, '������ c', 0, true)) return false;
		//if(!field_check(theForm.endDateStr, '������ ��', 0, true)) return false;
		//if(!field_check(theForm.dateEndSfStr, '�� ������ ��', 0, true)) return false;
		//if(!field_check(theForm.sumNdsStr,'� �.�. ���',6,true)) return false;
		//if(!field_check(theForm['vo.currency'], '������ ����������',4,true)) return false;
		//if(!field_check(theForm.otherMan, '��� ��������', 0, true)) return false;
</logic:notEqual>		
	}
	return true;
}
</script>
<% String isCertain = "true"; %>
<logic:equal name="<%= form %>" property="action" value="Add">
	<% isCertain = "false"; %>
</logic:equal>

<script language="javascript">

function switchRate() {
	if (document.all.byhandraterur[0].checked) {
		<%= form %>.rate.disabled = false;
		<%= form %>.rate.className = 'edit';
	} else {
		<%= form %>.rate.disabled = true;
		<%= form %>.rate.className = 'editdisabled';
	}
}

function switchDate() {
	if (document.all.isCorrection[0].checked) {
		<%= form %>.dateFrm.enabled = true;
	} else {
		<%= form %>.dateFrm.enabled = false;
	}
}

function update() {
	var ndsRate = new Number(coma_replace(document.all.ndsRateFrm.value, '.'));
    var sum = coma_replace(document.all.summFrm.value, '.');
	document.all.sumndsFrm.value = Math.round((sum * ndsRate) / (100.0 + ndsRate) * 100.0) / 100.0;
}

function coma_replace(n, dd){
	var a = n.toString().split(',');
	if(a[1] == null)
		return a[0]; 
	else 
		return (a[0] + dd + a[1]);
}
//��� ������-��������������: ������ = ���.(��� ����������)
function setCurrency(){
	if(<%= form %>.resourcecode.value == "10448")
		<%= form %>.currencycode.value="810";	
}
</script>

<table class="main">

	<july:separator colspan="<%= gColSpan %>"/>
    <tr class="title">
    	<td class="title" colspan="<%= gColSpan %>">
			<%--INPUT TYPE="IMAGE" NAME="submit" SRC="<%= src%>"  ALT="<%= alt %>" onclick="return Check();"--%>
			<a href="#" title="�������" onclick="document.body.style.cursor='wait'; document.body.style.cursor='auto';"><IMG SRC="/images/cancel.gif" BORDER='0' ALT='�������' onclick="document.body.style.cursor='auto'; window.close();"></a>
        </td>
    </tr>
    <july:separator colspan="<%= gColSpan %>"/>	
	<tr>
		<td class="title" colspan="<%= gColSpan %>"><july:actionalert/></td>
	</tr>
	
	<%--tr>
		<td class="text"><july:reqmark>������:</july:reqmark></td>
		<td class="text">
			<july:select style="width: 300;" collection="resources" property="vo.resource" insertable="true" updatable="true" styleId="resourcecode">
				<html:options collection="resources" property="resource" labelProperty="name"/>
			</july:select>
		</td>
	</tr--%>

	<july:separator colspan="<%= gColSpan %>"/>

	<tr>
		<td class="text">��� ���������:</td>
		<td class="text">
			<bean:write name="<%=form%>" property="to.docPosVidStr" filter="true"/>
		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>

	<tr>
		<td class="text">�����:</td>
		<td class="text">
			<bean:write name="<%=form%>" property="to.docNumber" filter="true"/>
		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>

	<tr>
		<td class="text">����:</td>
		<td class="text">
			<july:datewrite name="<%=form%>" property="to.docDate"/>
		</td>
	</tr>		

	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text">���������� ����� ����������, ������:</td>
		<td class="text">
			<july:sumwrite name="<%=form%>" property="to.vo.chargeSum"/>
			<bean:write name="<%=form%>" property="to.curChargeName" filter="true"/>
		</td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text">C���� ���������� � ������:</td>
		<td class="text">
			<july:sumwrite name="<%=form%>" property="to.vo.chargeRurSum"/>
		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text">���� ���������� ����� ���������� � ���:</td>
		<td class="text">
			<july:sumwrite name="<%=form%>" property="to.vo.chargeRurRate"/>
		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text">����� ��������� ������ � ���:</td>
		<td class="text">
			<july:sumwrite name="<%=form%>" property="to.docSummRub"/>
		</td>
	</tr>	

	<%
		String isEdit = "false";	
		if(request.isUserInRole("administrator")) {
	%>
	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text">��������:</td>
		<td class="text">
			<bean:write name="<%=form%>" property="to.vo.sourceStr" filter="true"/>
		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text">������������ � ����:</td>
		<td class="text">
			<bean:write name="<%=form%>" property="to.docNumberUsedInAct" filter="true"/>
			�� <july:datewrite name="<%=form%>" property="to.docDateUsedInAct"/>
		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text">��� ������� ����:</td>
		<td class="text">
			<bean:write name="<%=form%>" property="to.docNumberAct" filter="true"/>
			�� <july:datewrite name="<%=form%>" property="to.docDateAct"/>
		</td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text">���� ����������:</td>
		<td class="text">	
			<logic:equal name="<%= form %>" property="to.vo.byHandChrgRateRur" value="Y">� ������ ������</logic:equal>
			<logic:equal name="<%= form %>" property="to.vo.byHandChrgRateRur" value="N">�������������</logic:equal>
		</td>
	</tr>
			
	<%}%>
	<july:separator colspan="<%= gColSpan %>"/>
    <tr class="title">
    	<td class="title" colspan="<%= gColSpan %>">
			<%--INPUT TYPE="IMAGE" NAME="submit" SRC="<%= src%>"  ALT="<%= alt %>" onclick="return Check();"--%>
			<a href="#" title="�������" onclick="document.body.style.cursor='wait'; document.body.style.cursor='auto';"><IMG SRC="/images/cancel.gif" BORDER='0' ALT='�������' onclick="document.body.style.cursor='auto'; window.close();"></a>
        </td>
    </tr>

</table>

</july:editform>
