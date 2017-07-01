<%@ page import="org.apache.struts.util.*,com.hps.july.basestation.formbean.*" %>
<script language="javascript">
function switchRenterSearch(state) {
	 if(state) {
	   	PosForm.organization.className = 'editkoddisabled';
		PosForm.organization.disabled = true;
	} else {
		 PosForm.organization.className = 'editkodsearch';
		PosForm.organization.disabled = false;
	 }
}
function switchWorkerSearch(state) {
	if(state) {
		PosForm.worker.className = 'editkoddisabled';
		PosForm.worker.disabled = true;
	} else {
		PosForm.worker.className = 'editkodsearch';
		PosForm.worker.disabled = false;
	}
}
function switchAllSearch() {
	if(PosForm.searchBy.value=="A" ||
	   PosForm.searchBy.value=="F" ||
	   PosForm.searchBy.value=="G" ||
	   PosForm.searchBy.value=="H" ||
	   PosForm.searchBy.value=="K" ||
	   PosForm.searchBy.value=="L" ||
	   PosForm.searchBy.value=="M" 
	) {
		  PosForm.searchString.className = 'editdisabled';
		  PosForm.searchString.disabled = true;
	} else {
		PosForm.searchString.className = 'editsearch';
		PosForm.searchString.disabled = false;
	}
}
</script>

<tr>
	<td class="title" colspan="2">
	<table border=0 width="100%" cellpadding=0 cellspacing=0>
	<tr>
		<td><jsp:include page="/common/regionsselect.jsp" flush="true" /></td>
		<td><july:searchbutton/></td>
	</tr>
	</table>
	</td>
</tr>
<%--@ include file="/positionLookupList/multipleSelect.jsp"--%>
<tr class='normal'>
<td>
<table class='find'>
<tr>
	<td class="title"><bean:message key="label.position.searchby"/></td>
	<td class="title" colspan='3'>
		<july:select property="searchBy" styleClass="editsearch" onchange="switchAllSearch();" insertable="true" updatable="true">
			<html:option value="A"><bean:message key="label.position.search.all"/></html:option>
			<html:option value="F"><bean:message key="label.position.search.bsgsm"/></html:option>
			<html:option value="G"><bean:message key="label.position.search.bsdamps"/></html:option>
			<html:option value="H"><bean:message key="label.position.search.nobs"/></html:option>
			<html:option value="B"><bean:message key="label.position.search.gsmid"/></html:option>
			<html:option value="C"><bean:message key="label.position.search.dampsid"/></html:option>
			<html:option value="D"><bean:message key="label.position.search.name"/></html:option>
			<html:option value="E"><bean:message key="label.position.search.addr"/></html:option>
			<html:option value="I"><bean:message key="label.position.search.trid"/></html:option>
			<html:option value="K"><bean:message key="label.position.search.trall"/></html:option>
			<html:option value="L"><bean:message key="label.position.search.trrrl"/></html:option>
			<html:option value="M"><bean:message key="label.position.search.trvot"/></html:option>
		</july:select>&nbsp;&nbsp;
		<bean:message key="label.position.search.text"/>&nbsp;<html:text styleClass="search" property="searchString" styleId="editsearch" size="25" />
	</td>
</tr>
</table>
</td>
</tr>
</table>
</td>
</tr>
<script language="javascript">switchAllSearch();</script>
