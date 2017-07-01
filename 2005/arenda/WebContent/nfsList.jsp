<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import = "com.hps.july.arenda.formbean.*"%>
<%@ page import = "com.hps.july.arenda.valueobject.*"%>

<%!
private String isUp(String aSort, String name) {
 if(aSort.startsWith(name)) {
	 if(aSort.endsWith("desc")) 
		return (" <img src='/images/up.gif'  border='0' alt='�� �����������'> ");
	 else
		return (" <img src='/images/down.gif'  border='0' alt='�� ��������'> "); 
 }
 else return ("");      
}
%>
<jsp:include page="common/top.jsp" flush="true"/>

<%
	String gColSpan = "12";
	NFS_ListForm nfsListForm = (NFS_ListForm)session.getAttribute("NFS_ListForm");
	String sortBy = nfsListForm.getSortBy();
%>

<july:browseform action="/ShowNFS_List.do" styleId="NFS_ListForm">
<html:hidden property="leaseContract"/>
<INPUT TYPE="hidden" name="checkCode" ID="checkCode" value="0">
<INPUT TYPE="hidden" name="movePayNfsFlag" ID="movePayNfsFlag" value="-1">
<html:hidden property="sortBy"/>

<script language="javascript">
function toggleStateFilter(n){
	document.all.stateFilter[n].checked = true;
    document.body.style.cursor="wait";
	NFS_ListForm.submit();
	return false;
}
function SortBy(field) 
{
	var e = document.all.sortBy;
	e.value = (e.value == field)?field + ' desc':field;
    document.body.style.cursor="wait";
	NFS_ListForm.submit();
	return false;
}
function switchStateFilter() {
	if(NFS_ListForm.stateFilter.value == 3 || NFS_ListForm.stateFilter.value == 4) {
		filterID.style.setAttribute("display", "none");
		listZPid.style.setAttribute("display", "block");
	} else {
		filterID.style.setAttribute("display", "block");
		listZPid.style.setAttribute("display", "none");
	}
}
</script>

<table class="main">

	<july:separator colspan="<%= gColSpan %>"/>

	<TR class="normal">
		<TD colspan="<%= gColSpan %>">
			<table class="find" >
				<tr>
					<td class="text" style="font-weight: normal;" colspan="2">
						<B>� ���.:</B>
						<bean:write name="NFS_ListForm" property="agreement.mainDocumentNumber" filter="true"/>
						<B><bean:message key="label.filter.ot"/></B>
						<july:datewrite name="NFS_ListForm" property="agreement.mainDocumentDate"/>
						<B>c:</B>
						<july:datewrite name="NFS_ListForm" property="agreement.mainStartDate"/>
						<B><bean:message key="label.filter.stop"/></B>
						<july:datewrite name="NFS_ListForm" property="agreement.mainEndDate"/>
					</td>
					<td class="text" style="font-weight: normal;" colspan="2">
						<B><bean:message key="label.filter.customer"/>:</B>
						<logic:present name="NFS_ListForm" property="agreement.mainOrgCustomer">
							<bean:write name="NFS_ListForm" property="agreement.mainOrgCustomer.name" filter="true"/>
						</logic:present>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<html:link page="/ShowArendaToNfsZpList.do" paramId="leaseDocument" paramName="NFS_ListForm" 
							paramProperty="leaseContract"
							styleClass="button">��������� ������ ��</html:link>
					</td>
				</tr>
				<tr>
					<td class="text" colspan="2" style="font-weight: normal;">
						<B><bean:message key="label.mainPosition"/></B>
						<bean:write name="NFS_ListForm" property="agreement.mainPosition" filter="true"/>
					</td>
					<td class="text" colspan="2" style="font-weight: normal;">
						<B><bean:message key="label.organization.isrenter"/>:</B>
						<logic:present name="NFS_ListForm" property="agreement.mainOrgExecutor">
							<bean:write name="NFS_ListForm" property="agreement.mainOrgExecutor.name" filter="true"/>
						</logic:present>
					</td>
				</tr>
				<tr>
					<td class="text" nowrap>������ ��:</td>
					<td class="text" nowrap style="font-size:8pt;">
						<july:select styleClass="seach" property="stateFilter" insertable="true" updatable="true"  onchange="switchStateFilter()" >
							<html:option value="4">���� ������ ��</html:option>
							<html:option value="3">�� ������ ��</html:option>
							<html:option value="5">�� ���� ����������</html:option>
							<html:option value="1">�� ����. ����������</html:option>
							<html:option value="6">�� ����. ���������</html:option>
							<html:option value="0">���</html:option>
							<html:option value="2">� ��</html:option>
						</july:select>
					</td>
					<td class="text" id="filterID">������ �������:
						<july:string size="50" style="width: 300" styleClass="seach" property="filter" styleId="filter" insertable="true" updatable="true"/>
						<july:searchbutton/>
					</td>
					<td class="text" id="listZPid">������ ��:
		    			<july:select styleClass="seach" property="idZpNfs" collection="listZP" insertable="true" updatable="true">
							<html:options collection="listZP" property="idZpNfs" labelProperty="numZp"/>
					   	</july:select>
						<july:searchbutton/>
					</td>
				</tr>
<%--
				<tr>
					<td class="text" nowrap>������� ������� ��:</td>
					<td class="text" nowrap style="font-size:8pt;">
						<july:radio property="stateFilter" insertable="true" updatable="true" value="0"/>
						<A href="javascript:toggleStateFilter(0)">���</A>
						<july:radio property="stateFilter" insertable="true" updatable="true" value="1"/>
						<A href="javascript:toggleStateFilter(1)">������������</A>
						<july:radio property="stateFilter" insertable="true" updatable="true" value="2"/>
						<A href="javascript:toggleStateFilter(2)">� ��</A>
						<july:radio property="stateFilter" insertable="true" updatable="true" value="3"/>
						<A href="javascript:toggleStateFilter(3)">�� ������ ��</A>
						<july:radio property="stateFilter" insertable="true" updatable="true" value="4"/>
						<A href="javascript:toggleStateFilter(4)">���� ������ ��</A>
					</td>
				</tr>
--%>
			</table>
		</TD>
	</TR>

	<july:separator colspan="<%= gColSpan %>"/>

	<tr class="title">
		<td colspan="<%= gColSpan %>">
			<table class="buttons">
				<tr class="title">
					<td class="buttons">
						<july:backbutton/>
					</td>
					<td align="right">
						�������� �������:<%= request.getAttribute("numberOfLines") %>
					</td>
					<td class="navigator"><july:navigator/></td>
				</tr>
			</table>
		</td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>
	<!-- Table header -->
	<tr class="title">
		<td class="title">&nbsp;</td>
		<td class='title' title='���� ��������� � ������� NFS ��/���'>*</td>
		<td class="title" nowrap>
			<A title="����������� �� ���� '����� ��'" href="javascript:SortBy('numZp')">����� ��</A><%=isUp(sortBy, "numZp")%>
		</td>
		<td class="title" nowrap>
			<A title="����������� �� ���� '����� ��'" href="javascript:SortBy('numSf')">����� ��</A><%=isUp(sortBy, "numSf")%>
		</td>
		<td class="title" nowrap>
			<A title="����������� �� ���� '����� ��'" href="javascript:SortBy('sumSf')">����� ��<%=isUp(sortBy, "sumSf")%>
		</td>
		<td class="title" nowrap>
			<A title="����������� �� ���� '��������� ��'" href="javascript:SortBy('stateSf')">����. ��<%=isUp(sortBy, "stateSf")%>
		</td>
		<td class="title" nowrap>
			<A title="����������� �� ���� '����� ��'" href="javascript:SortBy('numPay')">����� ��<%=isUp(sortBy, "numPay")%>
		</td>
		<td class="title" nowrap>
			<A title="����������� �� ���� '���� �������'" href="javascript:SortBy('datePay')">���� ��</A><%=isUp(sortBy, "datePay")%>
		</td>
		<td class="title" nowrap>
			<A title="����������� �� ���� '����. ��'" href="javascript:SortBy('statePay')">����. ��<%=isUp(sortBy, "statePay")%>
		</td>
		<td class="title" nowrap>
			<A title="����������� �� ���� '����� ��'" href="javascript:SortBy('sumPay')">����� ��<%=isUp(sortBy, "sumPay")%>
		</td>
		<td class="title" nowrap>
			<A title="����������� �� ���� '����� �� � ���.'" href="javascript:SortBy('sumRubPay')">����� ��(���.)<%=isUp(sortBy, "sumRubPay")%>
		</td>
		<td class="title" align="center" title='<bean:message key="label.payments.paypurpose"/>'>!</td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>

	<!-- Table body -->
	<logic:iterate id="it" name="browseList"> 
		<logic:present name="it">
		<%
		    NFS_VO nfsVO = (NFS_VO )it;
			String className = "normal";
			if( !nfsVO.isActiveRecord() )
				className = "gray";
		%>
		<tr class="<%= className%>" style="font-size:8pt;" onMouseOver="className='select'" onMouseOut="className='<%= className%>'">
			<td class="text">
			  <html:link page="/NFS_Print.do?action=View" name="it" property="params" onclick="window.open(this.href, 'pWindow', 'top=100,	left=250, width=700, height=500, scrollbars=yes, resizable=yes, menubar=yes').focus(); return false;">
				<IMG SRC="/images/izmena.gif" BORDER='0' ALT='�������� ������'>
			  </html:link>
			</td>
			<td class="text">
				<logic:present name="it" property="payNFS">
					<logic:equal name="it" property="payNFS.lnkPayNfs" value="true">
						<INPUT TYPE="image" NAME="lnkPayNfs" onclick='document.all.checkCode.value=<bean:write name="it"
						property="payNFS.idPayNfs"/>; document.all.movePayNfsFlag.value = 0; document.body.style.cursor="wait"' 
						SRC="/images/check_on.gif" BORDER=0 alt='���� ��������� � ������� NFS'>
					</logic:equal>
					<logic:equal name="it" property="payNFS.lnkPayNfs" value="false">
						<INPUT TYPE="image" NAME="lnkPayNfs" onclick='document.all.checkCode.value=<bean:write name="it" property="payNFS.idPayNfs"/>; document.all.movePayNfsFlag.value = 1;document.body.style.cursor="wait"' SRC="/images/check_off.gif" BORDER=0 alt='���� �� ��������� � ������� NFS'>
					</logic:equal>
				</logic:present>
			</td>
			<td class="text" title='��������'>
				<logic:present name="it" property="zpNFS">
						<bean:write name="it" property="zpNFS.numZp" filter="true"/>
				</logic:present>
			</td>
			<td class="text">
				<logic:present name="it" property="schetFaktNFS">
					<html:link page="/NFS_Print.do?action=View" name="it" property="params" 
						onclick="window.open(this.href, 'pWindow', 'top=100, left=250, width=700, height=500, scrollbars=yes, resizable=yes, menubar=yes').focus(); return false;">
						<bean:write name="it" property="schetFaktNFS.numSf" filter="true"/>
					</html:link>
				</logic:present>
			</td>
			<td class="text">
				<logic:present name="it" property="schetFaktNFS">
					<july:sumwrite name="it" property="schetFaktNFS.sumSf"/>&nbsp;<bean:write name="it" property="schetFaktNFS.currSf" filter="true"/>
				</logic:present>
			</td>
			<td class="text">
				<logic:present name="it" property="schetFaktNFS">
					<bean:write name="it" property="schetFaktNFS.stateSf" filter="true"/>
				</logic:present>
			</td>
			<td class="text">
				<logic:present name="it" property="payNFS">
					<bean:write name="it" property="payNFS.numPay" filter="true"/>
				</logic:present>
			</td>
			<td class="text">
				<logic:present name="it" property="payNFS">
					<july:datewrite name="it" property="payNFS.datePay"/>
				</logic:present>
			</td>
			<td class="text">
				<logic:present name="it" property="payNFS">
					<bean:write name="it" property="payNFS.statePay" filter="true"/>
				</logic:present>
			</td>
			<td class="text">
				<logic:present name="it" property="payNFS">
					<july:sumwrite name="it" property="payNFS.sumPay"/>&nbsp;<bean:write name="it" property="payNFS.currPay" filter="true"/>
				</logic:present>
			</td>
			<td class="text">
				<logic:present name="it" property="payNFS">
					<july:sumwrite name="it" property="payNFS.sumRubPay"/>
				</logic:present>
			</td>
			<td class="text" align="center">
				<logic:present name="it" property="payNFS">
					<img src='/images/infohint.gif' border=0 alt='<bean:message key="label.payments.paypurpose"/>:&#10;<july:stringwrite name="it" property="payNFS.purpose"/>'>
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
					</td>
					<td align="right">
						�������� �������:<%= request.getAttribute("numberOfLines") %>
					</td>
					<td class="navigator"><july:navigator/></td>
				</tr>
			</table>
		</td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>
</table>

<script language="javascript">
	switchStateFilter();
</script>

</july:browseform>

<jsp:include page="common/bottom.jsp" flush="true"/>
