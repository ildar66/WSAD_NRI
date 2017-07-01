<%@ page language = "java" %> 
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>


<% String gColSpan = "2"; %>


<july:editform action="/ProcessGetBanks.do" styleId="GetBanksForm">


<script language="javascript">
function switchBanks() {
	if (document.all.isAllBanks[0].checked) { // use not [0] -> styleId in checkBox
		GetBanksForm.bankCodeFrm.className = 'editkoddisabled';
		GetBanksForm.bankCodeFrm.disabled = true;
		document.all['lookupimg_bankl'].src='/images/lookup_disabled.gif';
	} else {
		GetBanksForm.bankCodeFrm.className = 'editkod';
		GetBanksForm.bankCodeFrm.disabled = false;
		document.all['lookupimg_bankl'].src='/images/lookup.gif';
	}
}
</script>


<table class="main">


<%--
<tr class="title">
		<td class="title" colspan="<%= gColSpan %>"><july:currmark><bean:message key="label.getbanks"/></july:currmark></td>
	</tr>
--%>

	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<td class="text"><bean:message key="label.getbanks.bank"/>:</td>
		<td class="text" nowrap>
			<july:checkbox property="isAllBanks" insertable="true" updatable="true" onclick="switchBanks()"/>
			<bean:message key="label.filter.all"/>
			<july:string property="bankCodeFrm" styleId="bankcode" size="5" insertable="true" updatable="true"/>
			<july:lookupbutton action="/ShowBankLookupList.do" styleId="bankl" fieldNames="bik;bankcode;name;corracount;address" insertable="true" updatable="true" onclick="if (document.all.isAllBanks[0].checked) { return false; }"/>
			<july:string size="50" property="name" styleId="name" insertable="false" updatable="false"/>
		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<td class="text"><bean:message key="label.getbanks.bik"/>:</td>
		<td class="text" nowrap>
			<july:string size="50" property="bik" styleId="bik" insertable="false" updatable="false"/>
		</td>
	</tr>


	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<td class="text"><bean:message key="label.getbanks.corraccount"/>:</td>
		<td class="text" nowrap>
			<july:string size="50" property="corracount" styleId="corracount" insertable="false" updatable="false"/>
		</td>
	</tr>


	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<td class="text"><bean:message key="label.getbanks.addr"/>:</td>
		<td class="text" nowrap>
			<july:string size="50" property="address" styleId="address" insertable="false" updatable="false"/>
		</td>
	</tr>


	<july:separator colspan="<%= gColSpan %>"/>


	<tr class="normal">
		<td class="text" colspan="<%= gColSpan %>">
			<INPUT TYPE="IMAGE" NAME="submit" SRC="/images/save.gif" ALT="<bean:message key="button.save"/>">
		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>
	
</table>


<script language="javascript">
	switchBanks();
</script>


</july:editform>