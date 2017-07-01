<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*, com.hps.july.arenda.*, com.hps.july.arenda.formbean.*, com.hps.july.valueobject.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<SCRIPT language=javascript src="/common/validate.js" type="text/javascript"></SCRIPT>
<SCRIPT language=javascript src="/common/dialog.js" type="text/javascript"></SCRIPT>  

<% java.lang.String gColSpan = "6"; %>

<%
	String action = "/LeasePayOfficeMemoProcess.do";
	String form = "LeasePayOfficeMemoDialogForm";
	String src = "/images/save.gif";
	String alt = "��������� ������";
	String isEdit = "false";
	boolean isSave = true;
	//������������ ������:
	String rurStr = String.valueOf(com.hps.july.util.AppUtils.getNamedValueInt("RUR")) ;
	String rurName = "RUR";
	Currency_VO nationalCurrencyVO = ProfileAccessHelper.getNationalCurrency_VO(request);
	if (nationalCurrencyVO != null) {
		rurStr = String.valueOf(nationalCurrencyVO.getCurrency().intValue());
		rurName = nationalCurrencyVO.getShortname();
	}
%>

<july:errors property="org.apache.struts.action.GLOBAL_ERROR"/>
<%--july:errors property="org.apache.struts.action.GLOBAL_WARNING" color = "blue" headerKey="warning.header"/--%>

<july:editform action="<%= action %>" styleId="<%= form %>">
<html:hidden property="id"/>
<html:hidden property="operation" value=""/>

<logic:equal name="<%= form %>" property="action" value="Delete">
		<% src = "/images/delconf.gif"; alt = "������� ������"; %>
</logic:equal>
<logic:equal name="<%= form %>" property="to.vo.state" value="1">
		<% isEdit = "true"; %>
</logic:equal>
<logic:equal name="<%= form %>" property="action" value="View">
		<% isSave = false; %>
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
				//if(!field_check(theForm.numberSchetFakt, '�� �', 0, true)) return false;
				//if(!field_check(theForm.dateSchetFaktStr, '����', 0, true)) return false;
				if(!field_check(theForm.beginDateStr, '������ �', 0, true)) return false;
				if(!field_check(theForm.endDateStr, '������ ��', 0, true)) return false;
				if(!field_check(theForm.sum,'�����',6,true)) return false;
				if(!field_check(theForm.nds,'���',4,true)) return false;
				if(!field_check(theForm['orgAccID'], '��������� ����',0,true)) return false;
				//if(!field_check(theForm.otherMan, '��� ��������', 0, true)) return false;
			}
		</logic:notEqual>		
		return true;
	}
	function updateSumNds() {
		var ndsRate = new Number(coma_replace(document.all.ndsRate.value, '.'));
	    var sum = coma_replace(document.all.sum.value, '.');
		document.all.nds.value = Math.round((sum * ndsRate) / (100.0 + ndsRate) * 100.0) / 100.0;
		changePayrate();
	}
	function updateRubNds() {
		var ndsRate = new Number(coma_replace(document.all.ndsRate.value, '.'));
	    var sumRub = coma_replace(document.all.sumRubFrm.value, '.');
		if(document.all.sumRubFrm.value == '') {
			document.all.ndsRubFrm.value = '';
		} else {
			document.all.ndsRubFrm.value = 
				Math.round(	(sumRub * ndsRate) / (100.0 + ndsRate) * 100.0) / 100.0;
		}
	}	
	function coma_replace(n, dd) {
		var a = n.toString().split(',');
		if(a[1] == null)
			return a[0]; 
		else 
			return (a[0] + dd + a[1]);
	}
	function updateRateNds() {
	    updateSumNds();
		updateRubNds();
	}
	function changeRur(){
		if(document.all.currencyID.value != <%= rurStr%>) {
			ruleRateID.style.setAttribute("display", "block");
			sumRubID.style.setAttribute("display", "block");
			changeRuleRate();
		} else {
			ruleRateID.style.setAttribute("display", "none");
			rateDateID.style.setAttribute("display", "none");
			sumRubID.style.setAttribute("display", "none");
			rateDogovorID.style.setAttribute("display", "none");
		}
	}
	function changeRuleRate(){
		if(document.all.ruleRate.value == <%=LeasePayOfficeMemo_VO.ruleRate_onHand%>) {
			//���� �������:
			document.all.rateValue.disabled = false;
			document.all.rateValue.className = 'editsmall';
			document.all.rateValue.focus();
			rateDateID.style.setAttribute("display", "none");
			rateDogovorID.style.setAttribute("display", "none");
		} else if(document.all.ruleRate.value == <%=LeasePayOfficeMemo_VO.ruleRate_onDate%>){
			//���� �� ����:
			document.all.rateValue.disabled = true;
			document.all.rateValue.className = 'editsmalldisabled';
			rateDateID.style.setAttribute("display", "block");
			rateDogovorID.style.setAttribute("display", "none");
		} else if(document.all.ruleRate.value == <%=LeasePayOfficeMemo_VO.ruleRate_onDogovor%>){
			//���� �� ��������:
			document.all.rateValue.disabled = true;
			document.all.rateValue.className = 'editsmalldisabled';
			rateDateID.style.setAttribute("display", "none");
			rateDogovorID.style.setAttribute("display", "block");
		}	
	}
	function createPayPurpose() {
		var da = document.all;
	
		document.all.payPurpose.value = '<bean:message key="label.paypurpose.payby"/> <bean:write name="<%= form %>" property="contractInfo.docNumber"/> <bean:message key="label.paypurpose.ot"/> <july:datewrite name="<%=form%>" property="contractInfo.docDate" shortformat="true"/>';
		//if(da.billNumber.value != '') {
		//	document.all.payPurpose.value += ' �� ����� �' + da.billNumber.value + ' �� ' + shortDateString(getDate_billdate());
		//}
		document.all.payPurpose.value += ' <bean:message key="label.paypurpose.za"/> <bean:write name="<%= form %>" property="contractInfo.mainResource"/>' //+ da.resourcecode.options[da.resourcecode.selectedIndex].text;
		document.all.payPurpose.value += ' <bean:message key="label.paypurpose.zaperiod"/> ' + shortDateString(getDate_beginDateStr()) + ' <bean:message key="label.paypurpose.po"/> ' + shortDateString(getDate_endDateStr());
		document.all.payPurpose.value += ' (<bean:message key="label.paypurpose.bs"/> <bean:write name="<%= form %>" property="contractInfo.positionName"/>)';
	}
	function ds(n) { n = n % 100; return (n > 9)?n:"0"+n; }
	function shortDateString(dt) {
		var d = new Date((dt-25569)*86400000);
		return "" + ds(d.getDate()) + "." + ds(d.getMonth()+1) + "." + ds(d.getYear());
	}
	function calcSumRub() {
		var payrate = coma_replace(document.all.rateValue.value, '.');
		var summ = coma_replace(document.all.sum.value, '.');
		if((payrate != '')&&(summ != '')) {
			document.all.sumRubFrm.value = fix(summ * payrate, 2);
		}else {
			document.all.sumRubFrm.value = '';
		}
	}
	function fix(fixNumber, decimalPlaces) {
		var div = Math.pow(10, decimalPlaces);
		var roundTo = new Number(10000);
		var multi = Math.round(fixNumber * div * roundTo) / roundTo;
		//alert("multi="+multi);
		return fixNumber = Math.round(multi) / div;
	}
	function changePayrate(){
		calcSumRub();
		updateRubNds();
	}			
</script>

<table class="main"  style="font-size:8pt;">

<july:separator colspan="<%= gColSpan %>"/>
    <tr class="title">
    	<td class="title" colspan="<%= gColSpan %>">
			<%if(isSave){ %>    	
			<INPUT TYPE="IMAGE" NAME="submit" SRC="<%= src%>"  ALT="<%= alt %>" onclick="return Check();">
			<%}%>
			</logic:equal>				
			&nbsp;<a href="#" title="�������" onclick="document.body.style.cursor='wait'; document.body.style.cursor='auto';"><IMG SRC="/images/cancel.gif" BORDER='0' ALT='�������' onclick="document.body.style.cursor='auto'; window.close();"></a>
        </td>
    </tr>

<july:separator colspan="<%= gColSpan %>"/>
    <tr>
        <td class="title" colspan="<%= gColSpan %>"><july:actionalert/></td>
    </tr>
    
<%--july:separator colspan="<%= gColSpan %>"/>
    <tr>
        <td class="title" colspan="<%= gColSpan %>"><bean:write name="<%= form %>" property="contractInfo.docNumber"/> �� <july:datewrite name="<%= form %>" property="contractInfo.docDate"/></td>
    </tr--%>    

<july:separator colspan="<%= gColSpan %>"/>	
	<tr>
		<td class="text">
			�������� �:
		</td> 
		<td class="text">
			<july:string size="10" style="width: 170; font-size:8pt;" property="to.vo.idOfficeMemo" styleId="idOfficeMemo" insertable="false" updatable="false"/>&nbsp;&nbsp;&nbsp;
			 �� ���. <bean:write name="<%= form %>" property="contractInfo.docNumber"/> �� <july:datewrite name="<%= form %>" property="contractInfo.docDate"/>
			<html:hidden property="leaseRule"/>
			<%if(isSave){ %>
		 	<html:link page="/PayRuleLookupList.do?formname=LeasePayOfficeMemoDialogForm&fieldnames=leaseRule" paramId="leaseDocument" paramName="<%=form%>" paramProperty="to.vo.leaseContract" onclick="return openDialog(this.href, 'PayRuleLookupList', 'top=40, left=100, width=600, height=350, scrollbars=yes, resizable=yes')" title="������� ������">		
				<img name="lookupimg_payrule" src='/images/lookup.gif' border='0' alt='������� ������'></html:link>
			<%}%>			 
		</td>
    </tr>
    
<july:separator colspan="<%= gColSpan %>"/>	
	<tr>
		<td class="text" colspan="1">
			�� �:
			<logic:present name="<%= form %>" property="dataZP"><bean:write name="<%= form %>" property="dataZP.numZp"/></logic:present>
			<html:hidden property="to.vo.idZpNfs"/>
			<%if(isSave){ %>
		 	<html:link page="/ArendaToNfsZpLookupList.do?formname=LeasePayOfficeMemoDialogForm&fieldnames=to.vo.idZpNfs" paramId="leaseDocument" paramName="<%=form%>" paramProperty="to.vo.leaseContract" onclick="return openDialog(this.href, 'ArendaToNfsZpLookupList', 'top=40, left=100, width=600, height=350, scrollbars=yes, resizable=yes')" title="������ �� � ��������">		
				<img name="lookupimg_nfsZp" src='/images/lookup.gif' border='0' alt='������ �� � ��������'></html:link>
			<%}%>			
		</td> 
		<td class="text" style="color: graytext;">
			<logic:present name="<%= form %>" property="dataZP">
				�����:<bean:write name="<%= form %>" property="dataZP.sumZp"/><bean:write name="<%= form %>" property="dataZP.currZp"/>;
				���:<bean:write name="<%= form %>" property="dataZP.ndsZp"/>;
				���������:���=<bean:write name="<%= form %>" property="dataZP.vendor.vendorcode"/>;
				���������:<bean:write name="<%= form %>" property="dataZP.site.name"/>;
				���:<bean:write name="<%= form %>" property="dataZP.vendor.inn"/>
			</logic:present>
		</td>
    </tr>    
    
<july:separator colspan="<%= gColSpan %>"/>	
	<tr>
		<td class="text"><july:reqmark>������:</july:reqmark></td> 
		<td class="text">
			� :<july:date style="font-size:8pt;" property="to.beginDateStr" size="20" insertable="true" updatable="<%=isEdit%>" required="false" styleId="beginDateStr"/>
			��:<july:date style="font-size:8pt;" property="to.endDateStr" size="20" insertable="true" updatable="<%=isEdit%>" required="false" styleId="endDateStr"/>
		</td>
    </tr>
    
<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text"><july:reqmark>����� � ���:</july:reqmark></td> 
		<td class="text" colspan="1">
			<july:string size="10" style="font-size:8pt;" property="to.sumStr" styleId="sum" insertable="true" updatable="<%=isEdit%>"  onkeyup="updateSumNds();"/>
			<july:reqmark>� �.�.���:</july:reqmark><july:string style="font-size:8pt;" size="5" property="to.ndsStr" styleId="nds" insertable="true" updatable="<%=isEdit%>"/>
		    ������:&nbsp;<july:select style="width: 130; font-size:8pt;" collection="currencies" property="to.vo.currency" insertable="true" updatable="<%=isEdit%>" onchange="changeRur()" styleId="currencyID">
							<html:options collection="currencies" property="currency" labelProperty="name"/></july:select><BR>
			������ ���:<july:string size="5" style="font-size:8pt;" property="to.rateNdsStr" styleId="ndsRate" insertable="true" updatable="<%=isEdit%>" onkeyup="updateRateNds();"/>
		</td>
	</tr>
	
<%--july:separator colspan="<%= gColSpan %>"/--%>
	<tr id="ruleRateID">
		<td class="text">������� ���. �����:</td> 	
		<td class="text">
		    <july:select style="width: 170; font-size:8pt;" property="to.vo.ruleRate" insertable="true" updatable="<%=isEdit%>" onchange="changeRuleRate()"  styleId="ruleRate">
				<%--html:option value="">&nbsp;</html:option--%>
				<html:option value="<%=LeasePayOfficeMemo_VO.ruleRate_onDogovor%>">�� ������� ��������</html:option>
				<html:option value="<%=LeasePayOfficeMemo_VO.ruleRate_onDate%>">�� ����</html:option>
				<html:option value="<%=LeasePayOfficeMemo_VO.ruleRate_onHand%>">�������</html:option>
		   	</july:select>
		   	����:&nbsp;<july:string style="font-size:8pt;" size="5" property="to.rateValueStr" styleId="rateValue" insertable="true" updatable="<%=isEdit%>" onkeyup="changePayrate();"/>
		</td>
	</tr>
	
<%--july:separator colspan="<%= gColSpan %>"/--%>
	<tr id="rateDateID">
		<td class="text">����������. ����:</td> 	
		<td class="text">
		   	�� ����:&nbsp;<july:date style="font-size:8pt;" property="to.rateDateStr" styleId="rateDate" insertable="true" updatable="<%=isEdit%>" />
		   	<%if(isSave){ %>
		   		&nbsp;<input type='image' name='payratedateSubmit' value='4' src='/images/obchet1.gif' alt='<bean:message key="label.filter.calcrateondate"/>' onclick='operation.value = "calcRate";'>
		   	<%}%>
		</td>
	</tr>
	
<%--july:separator colspan="<%= gColSpan %>"/--%>
	<tr id="rateDogovorID">
		<td class="text">���������� ����:</td> 	
		<td class="text">
		<%if(isSave){ %>
		   	�� ��������:&nbsp;<input type='image' name='payrateSubmit' value='3' src='/images/obchet1.gif' alt='<bean:message key="label.filter.calcrate"/>' onclick='operation.value = "calcRate";'>
		<%}%>
			<logic:present name="<%= form %>" property="to.vo.rateCalcRule">
			<logic:equal name="<%= form %>" property="to.vo.rateCalcRule" value="A">
				<INPUT TYPE="TEXT"  NAME="contractStateView"  VALUE='<bean:message key="label.filter.ratecalcrule.a"/>'  READONLY="readonly"  class="editdisabled" style="font-size:8pt;" >
			</logic:equal>
			<logic:equal name="<%= form %>" property="to.vo.rateCalcRule" value="B">
				<INPUT TYPE="TEXT"  NAME="contractStateView"  VALUE='<bean:message key="label.filter.ratecalcrule.b"/>'  READONLY="readonly"  class="editdisabled" style="font-size:8pt;">						
			</logic:equal>
			<logic:equal name="<%= form %>" property="to.vo.rateCalcRule" value="C">
				<INPUT TYPE="TEXT"  NAME="contractStateView"  VALUE='<bean:message key="label.filter.ratecalcrule.c"/>'  READONLY="readonly"  class="editdisabled" style="font-size:8pt;">						
			</logic:equal>
			<logic:equal name="<%= form %>" property="to.vo.rateCalcRule" value="D">
				<INPUT TYPE="TEXT"  NAME="contractStateView"  VALUE='<bean:message key="label.filter.ratecalcrule.d"/>'  READONLY="readonly"  class="editdisabled" style="font-size:8pt;">						
			</logic:equal>
			<logic:equal name="<%= form %>" property="to.vo.rateCalcRule" value="E">
				<INPUT TYPE="TEXT"  NAME="contractStateView"  VALUE='<bean:message key="label.filter.ratecalcrule.e"/>'  READONLY="readonly"  class="editdisabled" style="font-size:8pt;">						
			</logic:equal>
			<%
				LeasePayOfficeMemoDialogForm formBean = ((LeasePayOfficeMemoDialogForm)session.getAttribute("LeasePayOfficeMemoDialogForm")); 
				String rateCalcRuleDayStr = String.valueOf( formBean.getTo().getVo().getRateCalcRuleDay() );
			%>
			<logic:equal name="<%= form %>" property="to.vo.rateCalcRule" value="F">
				<INPUT TYPE="TEXT"  NAME="contractStateView"  VALUE='<bean:message key="label.filter.ratecalcrule.f" arg0="<%= rateCalcRuleDayStr %>"/>'  READONLY="readonly"  class="editbigestdisabled" style="font-size:8pt;">
			</logic:equal>
			<logic:equal name="<%= form %>" property="to.vo.rateCalcRule" value="G">
				<INPUT TYPE="TEXT"  NAME="contractStateView"  VALUE='<bean:message key="label.filter.ratecalcrule.g" arg0="<%= rateCalcRuleDayStr %>"/>'  READONLY="readonly"  class="editbigestdisabled" style="font-size:8pt;">						
			</logic:equal>
			<logic:equal name="<%= form %>" property="to.vo.rateCalcRule" value="H">
				<INPUT TYPE="TEXT"  NAME="contractStateView"  VALUE='<bean:message key="label.filter.ratecalcrule.h"/>'  READONLY="readonly"  class="editdisabled" style="font-size:8pt;">
			</logic:equal>
			<logic:equal name="<%= form %>" property="to.vo.rateCalcRule" value="I">
				<INPUT TYPE="TEXT"  NAME="contractStateView"  VALUE='<bean:message key="label.filter.ratecalcrule.i"/>'  READONLY="readonly"  class="editdisabled" style="font-size:8pt;">						
			</logic:equal>
			</logic:present>
<%--			
			&nbsp;�������:
			<july:string size="5" property="to.vo.rateDelta" insertable="false" updatable="false" styleId="ratedeltaFrm"/>
--%>			
		</td>
	</tr>		

<%--july:separator colspan="<%= gColSpan %>"/--%>
	<tr id="sumRubID">
		<td class="text">����� � <%=rurName%>:</td>
		<td class="text" nowrap>
			<july:string style="font-size:8pt;" size="10" property="to.sumRubStr" insertable="true" onkeyup="updateRubNds();" updatable='<%=isEdit%>' styleId="sumRubFrm"/>
			<%-- if(!"Delete".equals(formb.getAction()) && !"View".equals(formb.getAction()) && formb.isEditable("sumRub")) { --%>
			<%if(isSave){ %>
				&nbsp;<img src='/images/obchet1.gif' name='sumrubButton' onclick='calcSumRub(); updateRubNds();' border='0' alt='<bean:message key="label.filter.calcsumrub"/>'>
			<%}%>
			<%-- } --%>
			&nbsp;� �.�. ��� � <%=rurName%>:
			&nbsp;<july:string style="font-size:8pt;" size="5" property="to.ndsRubStr" insertable="true" updatable='<%=isEdit%>' styleId="ndsRubFrm"/>
		</td>
	</tr>	

<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text">
			�����: <july:checkbox property="to.flagAvans" insertable="true" updatable="<%= isEdit%>" />&nbsp;
		</td> 	
		<td class="text">
			������ 3 ����: <july:checkbox property="to.flag3face" insertable="true" updatable="<%= isEdit%>" />&nbsp;
		</td>
	</tr>

<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text">������ �� ����� �:</td>
		<td class="text" nowrap>
			<july:string style="font-size:8pt;" size="25" property="to.vo.billNumber" insertable="true" updatable='<%=isEdit%>' styleId="billnumber"/>&nbsp;��:&nbsp;<july:date style="font-size:8pt;" size="25" property="to.billDateStr" insertable="true" updatable='<%=isEdit%>' styleId="billdate" required="false"/>
		</td>
	</tr>
	
<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text">����������:
			<html:hidden property="vendorSite_VO.idVendorSite" styleId="idVendorSite"/>
			<%if(isSave){ %>
			<html:link page="/../dict/VendorSiteLookupList.do?formname=LeasePayOfficeMemoDialogForm&fieldnames=idVendorSite||nameVendorSite|kppVendorSite|addressVendorSite|innVendor|orgAccID|orgAccValue|orgAccBankName|orgAccBankAddress|orgAccBankBik" onclick="return openDialog(this.href, 'VendorSitesLookupList', 'top=40, left=100, width=700, height=650, scrollbars=yes, resizable=yes');" title="���������� ���������">		
				<img name="lookupimg_execl" src='/images/lookup.gif' border='0' alt='���������� ���������'></html:link>
			<%}%>
		</td> 	
		<td class="text">
			<july:string style="font-size:8pt;" size="30" property="vendorSite_VO.name" styleId="nameVendorSite" insertable="false" updatable="false"/>
		</td>
	</tr>
	<tr>
		<td class="text">���:</td> 	
		<td class="text">			
			<july:string style="font-size:8pt;" size="10" property="vendor_VO.inn" styleId="innVendor" insertable="false" updatable="false"/>
			���: <july:string style="font-size:8pt;" size="10" property="vendorSite_VO.kpp" styleId="kppVendorSite" insertable="false" updatable="false"/>
		</td>
	</tr>
	<tr>
		<td class="text">�����:</td> 	
		<td class="text"><july:string style="font-size:8pt;" size="30" property="vendorSite_VO.address" styleId="addressVendorSite" insertable="false" updatable="false"/>
		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text">��������� ����:
			<html:hidden property="to.vo.orgAcc" styleId="orgAccID"/>
			<%if(isSave){ %>
			<html:link page="/../dict/AccountsLookupList.do?formname=LeasePayOfficeMemoDialogForm&fieldnames=orgAccID|orgAccValue|orgAccBankName|orgAccBankBik||orgAccBankAddress" onclick="return openDialog(this.href + '&amp;idVendorSite='+document.all.idVendorSite.value , 'AccountsLookupList', 'top=200, left=200, width=600, height=300, scrollbars=yes, resizable=yes');" title="���������� ������">		
				<img name="lookupimg_accl" src='/images/lookup.gif' border='0' alt='���������� ������'></html:link>		
			<%}%>
		</td>
		<td class="text">
			<july:string style="font-size:8pt;" size="30" property="orgAcc.vo.account" styleId="orgAccValue" insertable="false" updatable="false"/>
		</td> 
	</tr>
	<tr>
		<td class="text">����:</td> 	
		<td class="text">
			<july:string style="font-size:8pt;" size="30" property="orgAcc.bank_VO.name" styleId="orgAccBankName" insertable="false" updatable="false"/>
		</td>
	</tr>
	<tr>
		<td class="text">�����:</td> 	
		<td class="text"><july:string style="font-size:8pt;" size="10" property="orgAcc.bank_VO.legalAddress" styleId="orgAccBankAddress" insertable="false" updatable="false"/>
			���:
			<july:string style="font-size:8pt;" size="10" property="orgAcc.bank_VO.bik" styleId="orgAccBankBik" insertable="false" updatable="false"/>
		</td>
	</tr>							       

<july:separator colspan="<%= gColSpan %>"/>	
	<tr>
		<td class="text">���������� ��:</td> 
		<td class="text">
			<%--july:string size="30" property="to.vo.purpose" styleId="purpose" insertable="true" updatable="<%= isEdit%>"/--%>
			<july:textarea cols="30" rows="3" style="width: 250pt;font-size:8pt;" property="to.vo.purpose" styleId="payPurpose" insertable="true" updatable='<%= isEdit%>'/>
			<%if(isSave){ %>
			&nbsp;<img src='/images/obchet1.gif' name='createPaypurpose' onclick='createPayPurpose();' border='0' alt='������������ ����� ���������� �������'>
			<%}%>
		</td>
    </tr>
    
<july:separator colspan="<%= gColSpan %>"/>	
	<tr>
		<td class="text">���� 104(���):</td> 
		<td class="text" nowrap="nowrap">
			<july:string style="font-size:8pt;" size="10" property="to.vo.pp104" styleId="pp104" insertable="true" updatable="<%= isEdit%>"/>
			OKATO:
			<july:string style="font-size:8pt;" size="10" property="to.vo.pp105" styleId="pp105" insertable="true" updatable="<%= isEdit%>"/>
		</td>
    </tr>
    
<july:separator colspan="<%= gColSpan %>"/>	
	<tr>
		<td class="text">�����������:</td> 
		<td class="text">
			<july:string style="font-size:8pt;" size="10" property="to.vo.ppQueue" styleId="ppQueue" insertable="true" updatable="<%= isEdit%>"/>
			������:
			<july:string style="font-size:8pt;" size="10" property="to.vo.ppStatus" styleId="ppStatus" insertable="true" updatable="<%= isEdit%>"/>
		</td>
    </tr>        
    
    
<july:separator colspan="<%= gColSpan %>"/>
    <tr class="title">
    	<td class="title" colspan="<%= gColSpan %>">
			<%if(isSave){%>    	    	
			<INPUT TYPE="IMAGE" NAME="submit" SRC="<%= src%>"  ALT="<%= alt %>" onclick="return Check();">
			<%}%>				
			&nbsp;<a href="#" title="�������" onclick="document.body.style.cursor='wait'; document.body.style.cursor='auto';"><IMG SRC="/images/cancel.gif" BORDER='0' ALT='�������' onclick="document.body.style.cursor='auto'; window.close();"></a>
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
	changeRur();
	if(<%= form %>.sum != null)
		<%= form %>.sum.focus();
</script>

</july:editform>
