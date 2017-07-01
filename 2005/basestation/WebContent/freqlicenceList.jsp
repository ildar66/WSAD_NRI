<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import="org.apache.struts.util.*"%>
<%@ page import="com.hps.july.basestation.formbean.*"%>
<%@ page import="com.hps.july.siteinfo.valueobject.Regions"%>

<%
	java.lang.String gColSpan = "9";
	FrequencyLicenceListForm lForm = (FrequencyLicenceListForm)pageContext.findAttribute("FrequencyLicenceListForm");
com.hps.july.jdbcpersistence.lib.TimeCounter tc = new com.hps.july.jdbcpersistence.lib.TimeCounter("FreqList.JSP");
%>

<july:browseform action="/ShowFrequencyLicenceList.do" styleId="FrequncyLicenceListForm">
<script language="javascript">
function refreshLookup(disabledstate,codeId,btnId) {
	document.all[codeId].disabled = disabledstate;
	document.all[codeId].className = (disabledstate?'editkoddisabled':'editkodsearch');
	document.all['lookupimg_'+btnId].disabled = disabledstate;
	document.all['lookupimg_'+btnId].src = (disabledstate?'/images/lookup_disabled.gif':'/images/lookup.gif');
}
function checkNumber() {
	if(document.all.bynumber[0].checked) {
		document.all['number'].className = 'editsearch';
		document.all['number'].disabled = false;
	} else {
		document.all['number'].className = 'editdisabled';
		document.all['number'].disabled = true;
	}
}
function checkResource() {
	refreshLookup(!document.all.byresource[0].checked,'resourcecode','resl');
}
function checkDate() {
	document.all.date_dt.Enabled = document.all.bydate[0].checked;
}
function checkFilenumber() {
	var disabledstate = !document.all.byfilenumber[0].checked;
	document.all.fileNumber.disabled = disabledstate;
	document.all.fileNumber.className = (disabledstate?'editdisabled':'editsearch');
	
}
</script>
<july:selectableTable styleClass="main" modelName="list" selectable="1" selectedClass="selected" paramName="selID" >
<july:separator colspan="<%= gColSpan %>" />
<tr class="normal">
<td colspan="<%=gColSpan %>">
	<table class="find">
	<tr>
		<td class="title" width="20%"></td>
		<td class="title" width="30%"></td>
		<td class="title" width="30%"></td>
	</td>
	<tr>
		<td class="title" colspan="2">
		<jsp:include page="/common/srnr_select.jsp" flush="true" />
		</td>
		<td class="title"><july:searchbutton/></td>
	</tr>
	<tr>
		<td class="title"><bean:message key="label.freqlicence.filter.request"/></td>
		<td class="title" colspan="2">
			<july:radio styleClass="editcheckbox" property="reqFilter" value="*" insertable="true" updatable="true" />
			<bean:message key="label.all"/>&nbsp;&nbsp;&nbsp;
			<july:radio styleClass="editcheckbox" property="reqFilter" value="S" insertable="true" updatable="true" />
			<bean:message key="label.freqlicence.filter.request.send"/>&nbsp;&nbsp;&nbsp;
			<july:radio styleClass="editcheckbox" property="reqFilter" value="O" insertable="true" updatable="true" />
			<bean:message key="label.freqlicence.filter.request.unsend"/>&nbsp;&nbsp;&nbsp;
		</td>
	</tr>
	<tr>
		<td class="title"><bean:message key="label.freqlicence.filter.licence"/></td>
		<td class="title" colspan="2">
			<july:radio styleClass="editcheckbox" property="licenceFilter" value="*" insertable="true" updatable="true" />
			<bean:message key="label.all"/>&nbsp;&nbsp;&nbsp;
			<july:radio styleClass="editcheckbox" property="licenceFilter" value="Y" insertable="true" updatable="true" />
			<bean:message key="label.freqlicence.filter.licence.present"/>&nbsp;&nbsp;&nbsp;
			<july:radio styleClass="editcheckbox" property="licenceFilter" value="N" insertable="true" updatable="true" />
			<bean:message key="label.freqlicence.filter.licence.notpresent"/>&nbsp;&nbsp;&nbsp;
		</td>
	</tr>
	<tr>
		<td class="title"><bean:message key="label.freqlicence.filter.exp"/></td>
		<td class="title" colspan="2">
			<july:radio styleClass="editcheckbox" property="expFilter" value="*" insertable="true" updatable="true" />
			<bean:message key="label.all"/>&nbsp;&nbsp;&nbsp;
			<july:radio styleClass="editcheckbox" property="expFilter" value="Y" insertable="true" updatable="true" />
			<bean:message key="label.freqlicence.filter.exp.present"/>&nbsp;&nbsp;&nbsp;
			<july:radio styleClass="editcheckbox" property="expFilter" value="N" insertable="true" updatable="true" />
			<bean:message key="label.freqlicence.filter.exp.notpresent"/>&nbsp;&nbsp;&nbsp;
		</td>
	</tr>
	<tr>
		<td class="title">
			<july:checkbox styleClass="editcheckbox" property="byfilenumber" value="true" insertable="true" updatable="true" onclick="checkFilenumber();"/>
			<bean:message key="label.freqlicence.filter.byfilenumber"/>
		</td>
		<td class="title" colspan="2">
			<july:string property="fileNumber" styleId="fileNumber" size="25" insertable="true" updatable="true" styleClass="editsearch"/>
		</td>
	</tr>
	</table>
</td>
</tr>
<july:separator colspan="<%= gColSpan %>" />
<tr class="title">
	<td colspan="<%= gColSpan %>">
		<table class="buttons">
		<tr class="title">
			<td class="buttons">
				<html:link page='/EditFrequencyLicence.do?action=Add'><img alt='<bean:message key="label.freqlicence.add"/>' src="/images/plus.gif" border=0></html:link>
        			<img alt="" src="/images/empty.gif" width=3 border=0>
				<july:backbutton/>
			</td>
			<td class="navigator"><july:navigator/></td>
		</tr>
		</table>
	</td>
</tr>
<july:separator colspan="<%= gColSpan %>" />

<%-- Table header --%>
<tr class="title">
	<td></td>
	<td></td>
	<july:headercolumn key="label.freqlicence.table.nfile" colType="string"/>
	<july:headercolumn key="label.freqlicence.table.reslist" colType="string"/>
	<july:sortcolumn key="label.freqlicence.table.beereqnum" colType="string" ascFinder="3" descFinder="4"/>
	<july:sortcolumn key="label.freqlicence.table.beereqdate" colType="string" ascFinder="5" descFinder="6"/>
	<july:sortcolumn key="label.freqlicence.table.licnum" colType="string" ascFinder="7" descFinder="8"/>
	<july:sortcolumn key="label.freqlicence.table.licdate" colType="string" ascFinder="9" descFinder="10"/>
	<td></td>
</tr>

<july:separator colspan="<%= gColSpan %>" />

<!-- Table body -->
<logic:iterate id="fl" name="browseList" type="com.hps.july.cdbc.lib.CDBCRowObject">
<logic:present name="fl">
<%
	String id = fl.getColumn("freqpermid").asString();
	pageContext.setAttribute("freqpermid",id);
//	pageContext.setAttribute("resources_list",resList);
%>
<july:selectableTR styleId="<%=id%>" paramName="selID" selectable="true" styleClass="normal"  onmouseover="className='select'" onmouseout="className='normal'">
<%--tr class="normal" onMouseOver="className='select';" onMouseOut="className='normal';"--%>
	<td class="link" align="middle">
		<july:editbutton page="/EditFrequencyLicence.do" action="Edit" paramId="freqpermid" paramName="freqpermid" alttext="label.freqlicence.edit"/>
	</td>
	<td class="link" align="middle">
		<july:link page="/ShowFreqLicenceHistoryList.do" paramId="freqpermid" paramName="freqpermid" paramScope="page">
			<img src="/images/dochist.gif" border=0 alt='<bean:message key="label.freqlicence.showhistory"/>'>
		</july:link>
	</td>
	<td class="number"><july:stringwrite name="fl" property="filenumber"/></td>
	<td class="number"><july:stringwrite name="fl" property="reslist"/></td>
	<td class="text"><july:stringwrite name="fl" property="beereqnumber"/></td>
	<td class="text"><july:datewrite name="fl" property="beereqdate"/></td>
	<td class="text"><july:stringwrite name="fl" property="freqnumber"/></td>
	<td class="text"><july:datewrite name="fl" property="freqdate"/></td>
	<td class="link"><july:delbutton page="/EditFrequencyLicence.do?action=Delete" paramId="freqpermid" paramName="freqpermid" paramScope="page"/></td>
<%--/tr--%>
</july:selectableTR>
<july:separator colspan="<%= gColSpan %>" />
</logic:present>
</logic:iterate>

<tr class="title">
	<td colspan="<%= gColSpan %>">
		<table class="buttons">
		<tr class="title">
			<td class="buttons">
				<html:link page='/EditFrequencyLicence.do?action=Add'><img alt='<bean:message key="label.freqlicence.add"/>' src="/images/plus.gif" border=0></html:link>
        			<img alt="" src="/images/empty.gif" width=3 border=0>
				<july:backbutton/>
			</td>
			<td class="navigator"><july:navigator/></td>
		</tr>
		</table>
	</td>
</tr>
<july:separator colspan="<%= gColSpan %>" />
</july:selectableTable>
<script language="javascript">
	checkFilenumber();
</script>
</july:browseform>
<%
tc.finish(" finish ");
%>
