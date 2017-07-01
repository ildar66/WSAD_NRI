<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.arenda.*,com.hps.july.arenda.formbean.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<SCRIPT language=javascript src="/common/validate.js" type="text/javascript"></SCRIPT> 
<% java.lang.String gColSpan = "6"; %>

<%
	String action = "/SchetFactProcess.do";
	String form = "SchetFactDialogForm";
	String src = "/images/save.gif";
	String alt = "��������� ������";
	String isEdit = "false";
	boolean isSave = true;
%>

<july:errors property="org.apache.struts.action.GLOBAL_ERROR"/>
<%--july:errors property="org.apache.struts.action.GLOBAL_WARNING" color = "blue" headerKey="warning.header"/--%>

<july:editform action="<%= action %>" styleId="<%= form %>">
<html:hidden property="id"/>
<html:hidden property="operation" value=""/>
<html:hidden property="codeLinkToCharge" value=""/>

<logic:equal name="<%= form %>" property="action" value="Delete">
		<% src = "/images/delconf.gif"; alt = "������� ������"; %>
</logic:equal>
<logic:equal name="<%= form %>" property="vo.state" value="O">
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
		var theForm = document.<%= form %>;
		with(theForm){
			//if(!field_check(theForm.numberSchetFakt, '�� �', 0, true)) return false;
			//if(!field_check(theForm.dateSchetFaktStr, '����', 0, true)) return false;
			if(!field_check(theForm.dateStartSfStr, '�� ������ �', 0, true)) return false;
			if(!field_check(theForm.dateEndSfStr, '�� ������ ��', 0, true)) return false;
			//if(!field_check(theForm.planSumStr,'����������� ���������',6,true)) return false;
			//if(!field_check(theForm['to.vo.ourMan'], '��� ���������(�� �����������)',0,true)) return false;
			//if(!field_check(theForm.otherMan, '��� ��������', 0, true)) return false;
		}
		return true;
	}
	function DeleteLinkToCharge(idCharge) {
		if(confirm('������� ����� � �����������?')) {
			document.all.codeLinkToCharge.value = idCharge;
			document.all.operation.value = "deleteLinkToCharge";
			document.body.style.cursor="wait";
			document.<%= form %>.submit();
			return false;
		}
	}
	function computeSF(operationStr){
		document.all.operation.value = operationStr;
		return true;
	}
	function coma_replace(n, dd){
		var a = n.toString().split(',');
		if(a[1] == null)
			return a[0]; 
		else 
			return (a[0] + dd + a[1]);
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
			&nbsp;<july:closebutton page="/"/>
        </td>
    </tr>

<july:separator colspan="<%= gColSpan %>"/>
    <tr>
        <td class="title" colspan="<%= gColSpan %>"><july:actionalert/></td>
    </tr>
    
<july:separator colspan="<%= gColSpan %>"/>
    <tr>
        <td class="title" colspan="<%= gColSpan %>"><bean:write name="<%= form %>" property="contractInfo"/></td>
    </tr>    

<july:separator colspan="<%= gColSpan %>"/>	
	<tr>
		<td class="text">�� �:</td> 
		<td class="text">
			<july:string size="10" property="vo.numberSchetFakt" styleId="numberSchetFakt" insertable="true" updatable="true"/>&nbsp;&nbsp;&nbsp;
			����:<july:date property="dateSchetFaktStr" size="20" insertable="true" updatable="true" required="false" styleId="dateSchetFaktStr"/>
			<%--logic:equal name="<%= form %>" property="vo.state" value="O">    	    	
				<INPUT TYPE="IMAGE" NAME="submit" SRC="/images/obchet1.gif"  ALT="���������� ���� ��" onclick="return computeSF('computeDateSF');">
			</logic:equal--%>			
		</td>
    </tr>
<july:separator colspan="<%= gColSpan %>"/>	
	<tr>
		<td class="text"><july:reqmark>�� ������:</july:reqmark></td> 
		<td class="text">
			� :<july:date property="dateStartSfStr" size="20" insertable="true" updatable="<%=isEdit%>" required="false" styleId="dateStartSfStr"/>
			��:<july:date property="dateEndSfStr" size="20" insertable="true" updatable="<%=isEdit%>" required="false" styleId="dateEndSfStr"/>
			<logic:equal name="<%= form %>" property="vo.state" value="O">    	    	
				<%--INPUT TYPE="IMAGE" NAME="submit" SRC="/images/obchet1.gif"  ALT="���������� ������ ��" onclick="return computeSF('computePeriodSF');"--%>
				<INPUT TYPE="IMAGE" NAME="submit" SRC="/images/obchet1.gif"  ALT="������ ���� � ������ ��" onclick="return computeSF('computeDateAndPeriodSF');">
			</logic:equal>			
		</td>
    </tr>
<july:separator colspan="<%= gColSpan %>"/>
	<tr>
		<td class="text"><july:reqmark>�����:</july:reqmark></td>
		<td class="text"><%--july:string size="10" property="planSumStr" insertable="true" updatable="<%=isUpdatable%>"/--%>&nbsp;
		    <july:select style="width: 130;" collection="currencies" property="vo.idCurrency" insertable="true" updatable="<%=isEdit%>">
				<html:options collection="currencies" property="currency" labelProperty="name"/>
		   	</july:select>
		</td>
	</tr>
	       
<logic:notEqual name="<%= form %>" property="action" value="Add">
<july:separator colspan="<%= gColSpan %>"/>
    <tr>
        <td class="text">������:</td>
        <td>
			<bean:write name="<%=form%>" property="vo.createdByName"  filter="true" />(<july:datewrite name="<%=form%>" property="vo.created" showtime="true"/>)
        </td>
    </tr>
    <tr>
        <td class="text">�������:</td>
        <td>
			<bean:write name="<%=form%>" property="vo.modifiedByName"  filter="true" />(<july:datewrite name="<%=form%>" property="vo.modified" showtime="true"/>)
        </td>
    </tr>
</logic:notEqual>

<july:separator colspan="<%= gColSpan %>"/>
    <tr class="title">
    	<td class="title" colspan="<%= gColSpan %>">
			<%if(isSave){%>    	    	
			<INPUT TYPE="IMAGE" NAME="submit" SRC="<%= src%>"  ALT="<%= alt %>" onclick="return Check();">
			<%}%>				
			&nbsp;<july:closebutton page="/"/>&nbsp;
			<logic:equal name="<%= form %>" property="vo.state" value="O">    				
			<%--A href='ChargeListLinkToSchetFact.do?leaseContract=<bean:write name="<%= form %>" property="idContract"/>' onclick='window.open(this.href, "ChargeListLinkToSchetFact", "top=350, left=100, width=800, height=300, scrollbars=yes, resizable=yes").focus(); return false;' class='button'>
				������ ��������� ����������(��������)</A--%>
			<A href='ChargeListLinkToSchetFact.do?leaseContract=<bean:write name="<%= form %>" property="idContract"/>' class='button'>
				������ ��������� ����������(��������)</A>
			</logic:equal>												      
        </td>
    </tr>
<july:separator colspan="<%= gColSpan %>"/>

	
</table>

<table class="main"  style="font-size:8pt;" title="������ ���������� � �/�">
	<!-- Table header -->
	<tr class="title">
		<td class="title" nowrap>������</td>
		<td class="title" nowrap colspan="1">�����</td>
		<td class="title" nowrap>������</td>		
		<td class="title" nowrap>����<BR>������</td>		
		<td class="title" nowrap>����<BR>���������</td>
		<td class="title" nowrap>�����<BR>�����</td>
		<td class="title" nowrap>&nbsp;</td>		
	</tr>
	<logic:iterate id="it" name="<%= form %>" property="leaseSF2charges" type="com.hps.july.valueobject.LeaseSchetFakt2Charge_TO">	
		<logic:present name="it">
			<tr
				id='<bean:write name="it" property="chargeVO.leaseDocPosition" filter="true"/>'
				class="normal" style="font-size: 8pt"
				onMouseOver="className='select'"
				onMouseOut="className='normal'">
				<td class="text">
					<bean:write name="it" property="resName" filter="true"/>
				</td>
<%--				
				<td class="number">
					<logic:equal name="it" property="chargeVO.source" value="M">
						<IMG SRC="/images/infohint.gif" BORDER=0 ALT='<bean:message key="label.charges.byhand"/>'>
					</logic:equal>
				</td>
--%>								
				<td class="number" align="right" nowrap>
					<july:sumwrite name="it" property="chargeVO.summ"/>
				</td>				
				<td class="text">
				<logic:present name="it" property="chargeVO.currency">
					<bean:write name="it" property="curName" filter="true"/>
				</logic:present>
				</td>				
				<td class="text">
					<july:datewrite name="it" property="chargeVO.beginDate"/>
				</td>
				<td class="text">
					<july:datewrite name="it" property="chargeVO.endDate"/>
				</td>
				<td class="text">
				<logic:equal name="<%= form %>" property="vo.state" value="O">
					<html:text size="8" name="it" property="linkSumCharge" onchange="this.value = coma_replace(this.value, '.')"/>
				</logic:equal>
				<logic:notEqual name="<%= form %>" property="vo.state" value="O">
					<july:sumwrite name="it" property="linkSumCharge"/>
				</logic:notEqual>
				</td>
			<td class="text">
				<logic:equal name="<%= form %>" property="vo.state" value="O">    							
				<A href='javascript:DeleteLinkToCharge(<bean:write name="it" property="chargeVO.leaseDocPosition" filter="true"/>)' title="������� ����� � �����������">
					<IMG SRC="/images/del.gif" BORDER='0' ALT='������� ����� � �����������'>
				</A>
				</logic:equal>				
			</td>												
            </tr>
	      </logic:present>
        </logic:iterate>
        <july:separator colspan="7"/>     	
</table>

<logic:equal name="<%=form%>" property="flagOperation" value="true">
	<script language="javascript" type="text/javascript">
		 Close();
	</script>
</logic:equal>

<script language="javascript" type="text/javascript">
	if(<%= form %>.numberSchetFakt != null)
		<%= form %>.numberSchetFakt.focus();
</script>

</july:editform>
