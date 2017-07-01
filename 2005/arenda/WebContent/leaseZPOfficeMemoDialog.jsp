<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*, com.hps.july.arenda.*, com.hps.july.arenda.formbean.*, com.hps.july.arenda.cdbcobjects.*, com.hps.july.valueobject.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<SCRIPT language=javascript src="/common/validate.js" type="text/javascript"></SCRIPT>
<SCRIPT language=javascript src="/common/dialog.js" type="text/javascript"></SCRIPT>  

<% java.lang.String gColSpan = "6"; %>

<%
	String action = "/LeaseZPOfficeMemoProcess.do";
	String form = "LeaseZPOfficeMemoDialogForm";
	String src = "/images/save.gif";
	String alt = "��������� ������";
	String isEdit = "true";
	boolean isSave = true;
	String rurStr = String.valueOf(com.hps.july.util.AppUtils.getNamedValueInt("RUR")) ;
%>

<july:errors property="org.apache.struts.action.GLOBAL_ERROR"/>
<%--july:errors property="org.apache.struts.action.GLOBAL_WARNING" color = "blue" headerKey="warning.header"/--%>

<july:editform action="<%= action %>" styleId="<%= form %>">
<html:hidden property="id"/>
<html:hidden property="operation" value=""/>

<logic:equal name="<%= form %>" property="action" value="Delete">
		<% src = "/images/delconf.gif"; alt = "������� ������"; %>
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
				if(!field_check(theForm['to.vo.leaseDopContract'], '���. ����������', 0, true)) return false;
				if(!field_check(theForm.idVendorSite, '����� ���������� ���', 0, true)) return false;
				if(!field_check(theForm.sumZP,'����� �� ��� ���',6,true)) return false;
				if(!field_check(theForm.ndsRate, '������ ���', 4, true)) return false;				
				if(!field_check(theForm.sumNdsZP,'����� ���',6,true)) return false;
				if(document.all.typeActionZP.value == '<%=CDBC_LeaseZPOfficeMemo_Object.TypeActionZP_create%>'){
					//
				}else{
					if(!field_check(theForm['to.vo.idZP'], '� ��', 0, true)) return false;
					if(!field_check(theForm.reason,'��������� ��� ���������',0,true)) return false;
				}
				if(!field_check(theForm.rateDelta, '�������,%', 4, false)) return false;
				if (document.all.rateCalcRule.value == 'F' || document.all.rateCalcRule.value == 'G') {
					if(!field_check(theForm.rateCalcRuleDay, '����', 3, true)) return false;
				} else if (document.all.rateCalcRule.value == 'K'){
					if(!field_check(theForm.rateFix, '������������� ����', 4, true)) return false;
				}				
				//if(!field_check(theForm['orgAccID'], '��������� ����',0,true)) return false;
				//if(!field_check(theForm.otherMan, '��� ��������', 0, true)) return false;
			}
		</logic:notEqual>		
		return true;
	}
	function changeTypeActionZP(){
		if(document.all.typeActionZP.value == "<%=CDBC_LeaseZPOfficeMemo_Object.TypeActionZP_create%>") {
			/**for(var i = 0; i < typeActionZP_createID.length; i++){
					typeActionZP_createID[i].style.setAttribute("display", "block");
			}*/
			for(var i = 0; i < typeActionZP_modifyID.length; i++){
					typeActionZP_modifyID[i].style.setAttribute("display", "none");
			}			
		} else {
			/**for(var i = 0; i < typeActionZP_createID.length; i++){
					typeActionZP_createID[i].style.setAttribute("display", "none");
			}*/
			for(var i = 0; i < typeActionZP_modifyID.length; i++){
					typeActionZP_modifyID[i].style.setAttribute("display", "block");
			}		
		}
	}
	function updateSumNds() {
		var ndsRate = new Number(coma_replace(document.all.ndsRate.value, '.'));
		var sumZP = new Number(coma_replace(document.all.sumZP.value, '.'));
		//var sumNdsZP = new Number(coma_replace(document.all.sumNdsZP.value, '.'));
		var sumNdsZP = Math.round((sumZP * ndsRate) / 100.0 * 100.0) / 100.0;		
		document.all.sumNdsZP.value = sumNdsZP;
		document.all.sumZP_Plus_SumNdsZP.value = Math.round((sumZP+sumNdsZP)*100)/100;
		//document.all.sumCharge.value = Math.round(sumZP/12*100)/100;
		
		var oldSumZP = new Number(coma_replace(document.all.oldSumZP.value, '.'));
		document.all.sumZP_Minus_OldSumZP.value = Math.round((sumZP-oldSumZP)*100)/100;
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
		//updateRubNds();
	}
	function switchCalcRule() {
		if (document.all.rateCalcRule.value == 'F' || document.all.rateCalcRule.value == 'G') {
			rateCalcRuleDayID.style.setAttribute("display", "block");
			rateFixID.style.setAttribute("display", "none");
		} else if (document.all.rateCalcRule.value == 'K'){
			rateFixID.style.setAttribute("display", "block");
			rateCalcRuleDayID.style.setAttribute("display", "none");
		} else {
			rateFixID.style.setAttribute("display", "none");
			rateCalcRuleDayID.style.setAttribute("display", "none");
		}
	}
	function changeRur(){
		if(document.all.currencyID.value != <%= rurStr%>) {
			rateCalcRuleID.style.setAttribute("display", "block");
			switchCalcRule();
		} else {
			rateCalcRuleID.style.setAttribute("display", "none");
			rateCalcRuleDayID.style.setAttribute("display", "none");
			rateFixID.style.setAttribute("display", "none");
		}
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
    
<july:separator colspan="<%= gColSpan %>"/>	
	<tr>
		<td class="text"  width="30%"><B>��������:</B></td> 
		<td class="text">
			<B>�:</B> <bean:write name="<%= form %>" property="to.vo.idOfficeMemo" />&nbsp;
			<B>��:</B> <july:datewrite name="<%= form %>" property="to.vo.created" />
		</td>
   </tr>
	<tr>
		<td class="text"><B>������������:</B></td> 
		<td class="text"><bean:write name="<%= form %>" property="contractInfo.orgExecutorName"/></td>
   </tr>
	<tr>
		<td class="text"><B>�������:</B></td> 
		<td class="text">
			<B>� GSM:</B> <bean:write name="<%= form %>" property="contractInfo.positionGsm" filter="true" />&nbsp;&nbsp;&nbsp;
			<B>������������:</B> <bean:write name="<%= form %>" property="contractInfo.positionName" filter="true" />
		</td>
   </tr>
   
<july:separator colspan="<%= gColSpan %>"/>	    
	<tr>
		<td class="text">
			���. ����������:
		 	<html:link page="/HistoryLookupList.do?formname=LeaseZPOfficeMemoDialogForm&fieldnames=to.vo.leaseDopContract" paramId="leaseDocument" paramName="<%=form%>" paramProperty="to.vo.leaseContract" onclick="return openDialog(this.href, 'HistoryLookupList', 'top=40, left=100, width=600, height=350, scrollbars=yes, resizable=yes')" title="����� ���.����������">		
				<img name="lookupimg_payrule" src='/images/lookup.gif' border='0' alt='����� ���.����������'></html:link>
		</td> 
		<td class="text">
			<%--july:string size="10" style="width: 170;" property="to.vo.idOfficeMemo" styleId="idOfficeMemo" insertable="false" updatable="false"/--%>
			<html:hidden property="to.vo.leaseDopContract"/>
			<july:string size="10" style="width: 400; font-size: 8pt;" property="dataDog" styleId="dataDog" insertable="false" updatable="false"/>&nbsp;&nbsp;&nbsp;
		</td>
    </tr>   
   
<%--july:separator colspan="<%= gColSpan %>"/--%>   
	<tr id="ruleRateID">
		<td class="text">�������� ��:</td> 	
		<td class="text">
		    <july:select style="width: 170; font-size: 8pt;" property="to.vo.typeActionZP" insertable="true" updatable="<%=isEdit%>" onchange="changeTypeActionZP()"  styleId="typeActionZP">
				<%--html:option value="">&nbsp;</html:option--%>
				<html:option value="<%=CDBC_LeaseZPOfficeMemo_Object.TypeActionZP_create%>">�������</html:option>
				<html:option value="<%=CDBC_LeaseZPOfficeMemo_Object.TypeActionZP_modify%>">��������</html:option>
		   	</july:select>
		</td>
	</tr>

<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text">
			������� �����������: <july:checkbox style="font-size:8pt;" property="to.flagAddVendor" insertable="true" updatable="<%= isEdit%>" />
		</td> 	
		<td class="text">
			������� ��������: <july:checkbox style="font-size:8pt;" property="to.flagAddContract" insertable="true" updatable="<%= isEdit%>" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			������� ���������: <july:checkbox style="font-size:8pt;" property="to.flagAddVendorSite" insertable="true" updatable="<%= isEdit%>" />
		</td> 	
	</tr>
	
<july:separator colspan="<%= gColSpan %>"/>	    
	<tr id="typeActionZP_modifyID">
		<td class="text">� ��:</td> 
		<td class="text">
			<html:hidden property="to.vo.idZP"/>
			<july:string size="10" style="width: 170; font-size: 8pt;" property="dataZP" styleId="dataZP" insertable="false" updatable="false"/>&nbsp;&nbsp;&nbsp;
		 	<html:link page="/ArendaToNfsZpLookupList.do?formname=LeaseZPOfficeMemoDialogForm&fieldnames=to.vo.idZP" paramId="leaseDocument" paramName="<%=form%>" paramProperty="to.vo.leaseContract" onclick="return openDialog(this.href, 'ArendaToNfsZpLookupList', 'top=40, left=150, width=600, height=350, scrollbars=yes, resizable=yes')" title="������ ��">		
				<img name="lookupimg_payrule" src='/images/lookup.gif' border='0' alt='������ ��'></html:link>
		</td>
    </tr>
    
	<tr id="typeActionZP_modifyID">
		<td class="text">������ ����� �� ��� ���:</td> 
		<td class="text">
			<july:string size="10" style="width: 170; font-size: 8pt;" property="to.oldSumZP" styleId="oldSumZP" insertable="false" updatable="false"/>
		</td>
    </tr>
   
	<%--tr id="typeActionZP_modifyID">
		<td class="text">���������� ����� ��:</td> 
		<td class="text">
			<july:string size="10" style="width: 170;" property="to.sumZP" styleId="sumZP" insertable="false" updatable="false"/>
		</td>
    </tr--%>
   
	<tr id="typeActionZP_modifyID">
		<td class="text">������� � ���������� ��� ���:</td> 
		<td class="text">
			<%--july:sumwrite  name="<%= form %>" property="sumZP_Minus_OldSumZP" /--%>
			<july:string size="10" style="width: 170; font-size: 8pt;" property="sumZP_Minus_OldSumZP" styleId="sumZP_Minus_OldSumZP" insertable="false" updatable="false"/>
		</td>
    </tr>
	<tr id="typeActionZP_modifyID">
		<td class="text">��������� ��� ���������:</td>
		<td class="text"><july:string size="10" style="width: 400; font-size: 8pt;" property="to.vo.reason" styleId="reason" insertable="true" updatable="<%= isEdit%>"/></td>
	</tr>    
    
<%--july:separator colspan="<%= gColSpan %>"/--%>
	    
	<tr>
		<td class="text">
			��������� ���:
			<html:link page="/../dict/VendorSiteLookupList.do?formname=LeaseZPOfficeMemoDialogForm&fieldnames=idVendorSite||nameVendorSite|kppVendorSite||innVendor||||||vendorCode|vendorName" onclick="return openDialog(this.href, 'VendorSitesLookupList', 'top=40, left=100, width=700, height=650, scrollbars=yes, resizable=yes');" title="���������� ���������">		
				<img name="lookupimg_execl" src='/images/lookup.gif' border='0' alt='���������� ���������'></html:link>		
		</td> 
		<td class="text" nowrap="nowrap">
			<july:string size="10" style="width: 300; font-size: 8pt;" property="vendor_VO.name" styleId="vendorName" insertable="false" updatable="false"/>
			�:<july:string size="10" style="width: 75; font-size: 8pt;" property="vendor_VO.vendorCode" styleId="vendorCode" insertable="false" updatable="false"/>
			<html:hidden property="to.vo.idVendorSite" styleId="idVendorSite"/>
		</td>
    </tr>
    
	<tr>
		<td class="text">���:</td> 	
		<td class="text">			
			<july:string size="10" property="vendor_VO.inn" styleId="innVendor" insertable="false" updatable="false"/>
			���:<july:string size="10" property="vendorSite_VO.kpp" styleId="kppVendorSite" insertable="false" updatable="false"/>
		</td>
	</tr>    
    
	<tr>
		<td class="text">�������������� ���:</td> 
		<td class="text">
			<july:string size="10" style="width: 300; font-size: 8pt;" property="vendorSite_VO.name" styleId="nameVendorSite" insertable="false" updatable="false"/>
		</td>
    </tr>
    
	<tr>
		<td class="text">������ ��:</td> 
		<td class="text">
			� :<july:date style="font-size: 8pt" property="to.dateStartZP" insertable="true" updatable="<%=isEdit%>"/>
			��:<july:date style="font-size: 8pt" property="to.dateEndZp" insertable="true" updatable="<%=isEdit%>"/>			
		</td>
    </tr>    
  
	<tr>
		<td class="text">������� ��������:</td> 
		<td class="text">
			<july:string size="10" style="width: 170; font-size: 8pt;" property="contractInfo.mainResource" styleId="mainResource" insertable="false" updatable="false"/>
		</td>
    </tr>
	    
	<tr>
		<td class="text">������ ��������:</td> 
		<td class="text">
			<%--july:string size="10" style="width: 170;" property="to.curName" styleId="curName" insertable="false" updatable="false"/--%>
		    <july:select style="width: 130; font-size: 8pt;" collection="currencies" property="to.vo.idCurrCharge" insertable="true" updatable="<%=isEdit%>" styleId="currencyID" onchange="changeRur()">
				<html:options collection="currencies" property="currency" labelProperty="name"/></july:select><BR>
		</td>
    </tr>
    
	<tr id="rateCalcRuleID">
		<td class="text">������� ���. ����� :</td>
		<td class="text">
			<july:select style="width: 280;font-size: 8pt" property="to.vo.rateCalcRule" insertable="true" updatable="<%=isEdit%>" onchange="switchCalcRule();" styleId="rateCalcRule">
				<html:option value=""/>
				<html:option key="label.filter.ratecalcrule.a" value="A"/>
				<html:option key="label.filter.ratecalcrule.b" value="B"/>
				<html:option key="label.filter.ratecalcrule.c" value="C"/>
				<html:option key="label.filter.ratecalcrule.d" value="D"/>
				<html:option key="label.filter.ratecalcrule.e" value="E"/>
				<html:option value="F"><bean:message key="label.filter.ratecalcrule.f" arg0="?"/></html:option>
				<html:option value="G"><bean:message key="label.filter.ratecalcrule.g" arg0="?"/></html:option>
				<html:option key="label.filter.ratecalcrule.h" value="H"/>
				<html:option key="label.filter.ratecalcrule.i" value="I"/>
				<html:option value="K">�������������� �����</html:option>
			</july:select> �������,%:<july:string size="5" style="width: 70; font-size: 8pt;" property="to.rateDelta" insertable="true" updatable="<%=isEdit%>" styleId="rateDelta"/>			
		</td>
	</tr>
	
	<tr id="rateCalcRuleDayID">
		<td class="text">����:</td> 
		<td class="text">
			<july:string size="5" style="width: 70; font-size: 8pt;" property="to.vo.rateCalcRuleDay" styleId="rateCalcRuleDay" insertable="true" updatable="<%=isEdit%>"/>
		</td>
    </tr>
    
	<tr id="rateFixID">
		<td class="text">������������� ����:</td> 
		<td class="text">
			<july:string size="5" style="width: 70; font-size: 8pt;" property="to.rateFix" insertable="true" updatable="<%=isEdit%>" styleId="rateFix"/>
		</td>
    </tr>    	    
	    
	<tr>
		<td class="text">
			����� �� ��� ���:
			<input type='image' name='fillSumNds' value='1' src='/images/obchet1.gif' alt='��������� �����,������ � ���' onclick='operation.value = "<%= LeaseZPOfficeMemoDialogForm.OPERATION_fillSumZpOnArendaContract %>";'>
		</td> 
		<td class="text">
			<july:string size="10" style="width: 170; font-size: 8pt;" property="to.sumZP" styleId="sumZP" insertable="true" updatable="<%=isEdit%>" onkeyup="updateSumNds();"/>
		</td>
    </tr>
	    
	<tr>
		<td class="text">
			����� ���:
		</td> 
		<td class="text">
			<july:string size="10" style="width: 170; font-size: 8pt;" property="to.sumNdsZP" styleId="sumNdsZP" insertable="false" updatable="false"/>
			<%--july:string size="10" style="width: 170;" property="to.sumNdsZP" styleId="sumNdsZP" insertable="false" updatable="false"/--%>
			������ ���:<july:string size="5" style="font-size: 8pt;" property="to.rateNds" styleId="ndsRate" insertable="true" updatable="<%=isEdit%>" onkeyup="updateRateNds();"/>			
		</td>
    </tr>
	    
	<tr>
		<td class="text">�����:</td> 
		<td class="text">
			<july:string size="10" style="width: 170; font-size: 8pt;" property="sumZP_Plus_SumNdsZP" styleId="sumZP_Plus_SumNdsZP" insertable="false" updatable="false" onkeyup="updateSumNds();"/>			
		</td>
    </tr> 

	<tr>
		<td class="text">����� � ���������� � ����� �� ��������(��� ���):</td> 
		<td class="text">
			<july:string size="10" style="width: 170; font-size: 8pt;" property="to.sumCharge" styleId="sumCharge" insertable="true" updatable="true"/>
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
	changeTypeActionZP();
	changeRur();
	//if(<%= form %>.sum != null)
		//<%= form %>.sum.focus();
</script>

</july:editform>
