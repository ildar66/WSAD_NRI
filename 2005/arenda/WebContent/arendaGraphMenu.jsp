<%
	//���������:
	//boolean isVisibleResources = isAdministrator || isArendaMainEconomist || isArendaEconomist || isArendaDirector;
%>
<%--
<!-- ������ ������-->
<div id="ArendaMenu" onMouseOver="over = 'yes';" onMouseOut="overChecker('Arenda');">
<script language="JavaScript" type="text/javascript">
     function onMouseOver() {over = 'yes';}
     function onMouseOut() {overChecker('Arenda');}
</script>
<table border="0" cellpadding="0"  cellspacing="1" bgColor=#1B467D>
	<% if (isArendaMainEconomist || isAdministrator) { %>
	<tr class="normal" onMouseOver="className='select';AutoprocMenu.style.visibility = 'visible';" onMouseOut="className='normal';AutoprocMenu.style.visibility = 'hidden';">
		<td valign="top" align="left">
		<img src="/menu/images/CLEAR.GIF" width="10" height="18" border="0" alt="" align="absmiddle">
		<a href="#" class="menuLink">�������������� ���������&gt;&gt;</a>
		<img src="/menu/images/CLEAR.GIF" width="10" height="18" border="0" alt="" align="absmiddle"></td>
	</tr>
	<%}%>
	<% if (isVisibleResources) { %>
	<tr class="normal" onMouseOver="className='select';ArendaDictMenu.style.visibility = 'visible';" onMouseOut="className='normal';ArendaDictMenu.style.visibility = 'hidden';">
		<td valign="top" align="left">
		<img src="/menu/images/CLEAR.GIF" width="10" height="18" border="0" alt="" align="absmiddle">
		<a href="#" class="menuLink">�������� �����������&gt;&gt;</a>
		<img src="/menu/images/CLEAR.GIF" width="10" height="18" border="0" alt="" align="absmiddle"></td>
	</tr>
	<tr class="normal" onMouseOver="className='select';BillingMenu.style.visibility = 'visible';" onMouseOut="className='normal';BillingMenu.style.visibility = 'hidden';">
		<td valign="top" align="left">
		<img src="/menu/images/CLEAR.GIF" width="10" height="18" border="0" alt="" align="absmiddle">
		<a href="#" class="menuLink">������ � ���������&gt;&gt;</a>
		<img src="/menu/images/CLEAR.GIF" width="10" height="18" border="0" alt="" align="absmiddle"></td>
	</tr>
	<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
		<td valign="top" align="left">
		<img src="/menu/images/CLEAR.GIF" width="10" height="18" border="0" alt="" align="absmiddle">
		<a href="/arenda/ShowWeArendaList.do?navclear=1" class="menuLink">�������� ������(�� ��������)</a>
		<img src="/menu/images/CLEAR.GIF" width="10" height="18" border="0" alt="" align="absmiddle"></td>
	</tr>
	<%}%>
	<% if (isVisibleResources || isArendaManager || isArendaMainManager) { %>
	<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
		<td valign="top" align="left">
		<img src="/menu/images/CLEAR.GIF" width="10" height="18" border="0" alt="" align="absmiddle">
		<a href="/arenda/ListFromPosition.do?navclear=1" class="menuLink">��� �������� �� �������</a>
		<img src="/menu/images/CLEAR.GIF" width="10" height="18" border="0" alt="" align="absmiddle"></td>
	</tr>
	<%}%>
	<% if (isVisibleResources) { %>
	<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
		<td valign="top" align="left">
		<img src="/menu/images/CLEAR.GIF" width="10" height="18" border="0" alt="" align="absmiddle">
		<a href="/arenda/LoanContractList.do?navclear=1" class="menuLink">������� ��������</a>
		<img src="/menu/images/CLEAR.GIF" width="10" height="18" border="0" alt="" align="absmiddle"></td>
	</tr>
	<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
		<td valign="top" align="left">
		<img src="/menu/images/CLEAR.GIF" width="10" height="18" border="0" alt="" align="absmiddle">
		<a href="/arenda/ShowRespPaysList.do?navclear=1" class="menuLink">������� �� ��������������</a>
		<img src="/menu/images/CLEAR.GIF" width="10" height="18" border="0" alt="" align="absmiddle"></td>
	</tr>
	<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
		<td valign="top" align="left">
		<img src="/menu/images/CLEAR.GIF" width="10" height="18" border="0" alt="" align="absmiddle">
		<a href="/arenda/ShowMutualReglamentsList.do?navclear=1" class="menuLink">���������� ���������� �����</a>
		<img src="/menu/images/CLEAR.GIF" width="10" height="18" border="0" alt="" align="absmiddle"></td>
	</tr>
	<%}%>
	<% if (isVisibleResources || isArendaManager || isArendaMainManager) { %>
	<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
		<td valign="top" align="left">
		<img src="/menu/images/CLEAR.GIF" width="10" height="18" border="0" alt="" align="absmiddle">
		<a href="/arenda/ArendaReport3Params.do?navclear=1" class="menuLink">������� ������</a>
		<img src="/menu/images/CLEAR.GIF" width="10" height="18" border="0" alt="" align="absmiddle"></td>
	</tr>
	<%}%>
	<% if (isViewerPays || isAdministrator) { %>
	<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
		<td valign="top" align="left">
		<img src="/menu/images/CLEAR.GIF" width="10" height="18" border="0" alt="" align="absmiddle">
		<a href="/arenda/ShowNFS_ListDetach.do?navclear=1" class="menuLink">������� NFS</a>
		<img src="/menu/images/CLEAR.GIF" width="10" height="18" border="0" alt="" align="absmiddle"></td>
	</tr>
	<%}%>
	<% if (isLcsGroup || isAdministrator || isArendaDirector || isArendaManager) { %>
	<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
		<td valign="top" align="left">
		<img src="/menu/images/CLEAR.GIF" width="10" height="18" border="0" alt="" align="absmiddle">
		<a href="/arenda/ShowListLicence.do?navclear=1" class="menuLink">��������</a>
		<img src="/menu/images/CLEAR.GIF" width="10" height="18" border="0" alt="" align="absmiddle"></td>
	</tr>
	<%}%>
--%>	
<%--
	<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
		<td valign="top" align="left">
		<img src="/menu/images/CLEAR.GIF" width="10" height="18" border="0" alt="" align="absmiddle">
		<a href="http://websphere:9080/?id=ildar" class="menuLink" onclick="newBigWin('http://websphere:9080/?id=ildar', 'trailcom'); return false;">�������� 1</a>
		<img src="/menu/images/CLEAR.GIF" width="10" height="18" border="0" alt="" align="absmiddle"></td>
	</tr>
--%>
<%--
</table>
</div>

<% if (isArendaMainEconomist || isAdministrator) { %>
<!-- ������� ���  "�������������� ���������"-->
<div id="AutoprocMenu" onMouseOver="over = 'yes';AutoprocMenu.style.visibility = 'visible';" onMouseOut="AutoprocMenu.style.visibility = 'hidden';overChecker('Arenda');">
<script language="JavaScript" type="text/javascript">
     function onMouseOver() {over = 'yes';AutoprocMenu.style.visibility = 'visible';}
     function onMouseOut() {AutoprocMenu.style.visibility = 'hidden';overChecker('Arenda');}
</script>
<table border="0" cellpadding="0"  cellspacing="1" bgColor=#1B467D>
	<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
		<td valign="top" align="left">
		<img src="/menu/images/CLEAR.GIF" width="10" height="18" border="0" alt="" align="absmiddle">
		<a href="/arenda/ShowStartProlongationsList.do?navclear=1" class="menuLink">��������� ���������</a>
		<img src="/menu/images/CLEAR.GIF" width="10" height="18" border="0" alt="" align="absmiddle"></td>
	</tr>
	<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
		<td valign="top" align="left">
		<img src="/menu/images/CLEAR.GIF" width="10" height="18" border="0" alt="" align="absmiddle">
		<a href='/arenda/ShowStartChargesList.do?navclear=1' class="menuLink">������������ ����������</a>
		<img src="/menu/images/CLEAR.GIF" width="10" height="18" border="0" alt="" align="absmiddle"></td>
	</tr>
	<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
		<td valign="top" align="left">
		<img src="/menu/images/CLEAR.GIF" width="10" height="18" border="0" alt="" align="absmiddle">
		<a href='/arenda/ShowStartPaymentsList.do?navclear=1' class="menuLink">������������ ��������</a>
		<img src="/menu/images/CLEAR.GIF" width="10" height="18" border="0" alt="" align="absmiddle"></td>
	</tr>
</table>
</div>
<%}%>

<% if (isVisibleResources) { %>
<!-- ������� ���  "�������� �����������"-->
<div id="ArendaDictMenu" onMouseOver="over = 'yes';ArendaDictMenu.style.visibility = 'visible';" onMouseOut="ArendaDictMenu.style.visibility = 'hidden';overChecker('Arenda');">
<script language="JavaScript" type="text/javascript">
     function onMouseOver() {over = 'yes';ArendaDictMenu.style.visibility = 'visible';}
     function onMouseOut() {ArendaDictMenu.style.visibility = 'hidden';overChecker('Arenda');}
</script>
<table border="0" cellpadding="0"  cellspacing="1" bgColor=#1B467D>
	<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
		<td valign="top" align="left">
		<img src="/menu/images/CLEAR.GIF" width="10" height="18" border="0" alt="" align="absmiddle">
		<a href="/dict/ShowBankList.do?rootapp=7&navclear=1" class="menuLink">�����</a>
		<img src="/menu/images/CLEAR.GIF" width="10" height="18" border="0" alt="" align="absmiddle"></td>
	</tr>
	<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
		<td valign="top" align="left">
		<img src="/menu/images/CLEAR.GIF" width="10" height="18" border="0" alt="" align="absmiddle">
		<a href='/dict/ShowPersonList.do?rootapp=7&navclear=1' class="menuLink">���������� ����</a>
		<img src="/menu/images/CLEAR.GIF" width="10" height="18" border="0" alt="" align="absmiddle"></td>
	</tr>
	<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
		<td valign="top" align="left">
		<img src="/menu/images/CLEAR.GIF" width="10" height="18" border="0" alt="" align="absmiddle">
		<a href='/dict/ShowOrganizationListM.do?rootapp=7&navclear=1' class="menuLink">����������� ����</a>
		<img src="/menu/images/CLEAR.GIF" width="10" height="18" border="0" alt="" align="absmiddle"></td>
	</tr>
	<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
		<td valign="top" align="left">
		<img src="/menu/images/CLEAR.GIF" width="10" height="18" border="0" alt="" align="absmiddle">
		<a href='/dict/ShowCurrateList.do?rootapp=7&navclear=1' class="menuLink">����� �����</a>
		<img src="/menu/images/CLEAR.GIF" width="10" height="18" border="0" alt="" align="absmiddle"></td>
	</tr>
</table>
</div>

<!-- ������� ���  "������ � ��������"-->
<div id="BillingMenu" onMouseOver="over = 'yes';BillingMenu.style.visibility = 'visible';" onMouseOut="BillingMenu.style.visibility = 'hidden';overChecker('Arenda');">
<script language="JavaScript" type="text/javascript">
     function onMouseOver() {over = 'yes';BillingMenu.style.visibility = 'visible';}
     function onMouseOut() {BillingMenu.style.visibility = 'hidden';overChecker('Arenda');}
</script>
<table border="0" cellpadding="0"  cellspacing="1" bgColor=#1B467D>
	<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
		<td valign="top" align="left">
		<img src="/menu/images/CLEAR.GIF" width="10" height="18" border="0" alt="" align="absmiddle">
		<a href="/arenda/ShowAbonentsList.do?navclear=1" class="menuLink">����������� ��������</a>
		<img src="/menu/images/CLEAR.GIF" width="10" height="18" border="0" alt="" align="absmiddle"></td>
	</tr>
	<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
		<td valign="top" align="left">
		<img src="/menu/images/CLEAR.GIF" width="10" height="18" border="0" alt="" align="absmiddle">
		<a href='/arenda/ShowMemoListDetach.do?navclear=1' class="menuLink">�������� � ����� ��. ���������</a>
		<img src="/menu/images/CLEAR.GIF" width="10" height="18" border="0" alt="" align="absmiddle"></td>
	</tr>
	<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
		<td valign="top" align="left">
		<img src="/menu/images/CLEAR.GIF" width="10" height="18" border="0" alt="" align="absmiddle">
		<a href='/arenda/ShowAbonentBillLinksList.do?navclear=1' class="menuLink">����� ��������</a>
		<img src="/menu/images/CLEAR.GIF" width="10" height="18" border="0" alt="" align="absmiddle"></td>
	</tr>
	<% if (isAdministrator) { %>
	<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
		<td valign="top" align="left">
		<img src="/menu/images/CLEAR.GIF" width="10" height="18" border="0" alt="" align="absmiddle">
		<a href='/arenda/AbonentBillQuery.do?navclear=1' class="menuLink">�������������� � ��������</a>
		<img src="/menu/images/CLEAR.GIF" width="10" height="18" border="0" alt="" align="absmiddle"></td>
	</tr>
	<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
		<td valign="top" align="left">
		<img src="/menu/images/CLEAR.GIF" width="10" height="18" border="0" alt="" align="absmiddle">
		<a href='/arenda/ShowStartBillList.do?navclear=1' class="menuLink">������ ��������������</a>
		<img src="/menu/images/CLEAR.GIF" width="10" height="18" border="0" alt="" align="absmiddle"></td>
	</tr>
	<% } %>
</table>
</div>
<%}%>
--%>