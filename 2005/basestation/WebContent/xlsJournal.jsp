<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.basestation.*,com.hps.july.jdbcpersistence.lib.DebugSupport" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<%
	String title;
	String returnUrl;
	DebugSupport.printlnTest("task="+session.getAttribute("task"));
	if(((Integer)session.getAttribute("task")).intValue()==3){
		title="xls.report.bs.title";
		returnUrl="/ProcessXlsBs.do";
	} else {
		title="xls.report.title";
		returnUrl="/ProcessXls.do";
	}
%>

<july:browseform action="/xlsJournal.do"  styleId="PosForm">
<script language="javascript">
function switchDate() {
	if (!document.all.isRecendtime[0].checked) {
        document.all.date1_dt.enabled = true;
		document.all.date2_dt.enabled = true;
	} else {
		document.all.date1_dt.enabled = false;
		document.all.date2_dt.enabled = false;
	}	
}
function switchOperator(state) {
	if(state) {
		PosForm.operator.className = 'editkoddisabled';
		PosForm.operator.disabled = true;
	} else {
		PosForm.operator.className = 'editkodsearch';
		PosForm.operator.disabled = false;
	}
}
function switchByKey(state){
	if(state){
		document.all.isImpsesid[0].disabled = true;
		document.all.key_ses.className = 'editsmallsearch';
		document.all.key_ses.disabled = false;
	} else {
		document.all.isImpsesid[0].disabled = false;
		document.all.key_ses.className = 'editsmalldisabled';
		document.all.key_ses.disabled = true;
	}
}
function switchBySes(state){
	if(state){
		document.all.isKeyfields[0].disabled = true;
		document.all.key_ses.className = 'editsmallsearch';
		document.all.key_ses.disabled = false;
	} else {
		document.all.isKeyfields[0].disabled = false;
		document.all.key_ses.className = 'editsmalldisabled';
		document.all.key_ses.disabled = true;
	}
}
function switchKey_Ses(){
	var stateKey = document.all.isKeyfields[0].checked;
	var stateSes = document.all.isImpsesid[0].checked;
	if(stateKey)
			switchByKey(stateKey);
	else if(stateSes)
			switchBySes(stateSes);
	else {
		document.all.key_ses.className = 'editsmalldisabled';
		document.all.key_ses.disabled = true;
	}
}
</script>

<table class="main">

<july:separator colspan="6" />
<tr class="normal">
	<td colspan="6">
		<table class="find">
			<tr><%--Период--%>
				<td class="text"><bean:message key="xls.journal.period"/>:</td>
				<td class="text" nowrap>
					<july:checkbox property="isRecendtime" styleId="isRecendtime" insertable="true" updatable="true" onclick="switchDate()"/>
					<bean:message key="xls.journal.operator.all"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<bean:message key="xls.journal.period.c"/>&nbsp;
					<july:date property="begindatefrm" insertable="true" updatable="true" styleId="date1"/>&nbsp;&nbsp;&nbsp;
					<bean:message key="xls.journal.period.po"/>&nbsp;
					<july:date property="enddatefrm" insertable="true" updatable="true" styleId="date2"/>&nbsp;
					<july:searchbutton/>
				</td>
			</tr>
			<tr><%--Оператор--%>
				<td class="text"><bean:message key="xls.journal.operator"/></td>
				<td>
					<july:checkbox property="isOperator" styleId="isOperator" insertable="true" updatable="true" onclick="switchOperator(document.all.isOperator[0].checked)" />&nbsp;<bean:message key="xls.journal.operator.all"/>&nbsp;&nbsp;
								
					<july:select styleId="operator" style="width: 300;" collection="people" property="operator" insertable="true" updatable="true">
						<html:options collection="people" property="operator" labelProperty="man.fullName"/>
					</july:select>


				</td>
			</tr>
			<tr><%--Поиск по--%>
				<td class="text"><bean:message key="xls.journal.find"/></td>
				<td>
					<july:checkbox property="isKeyfields" styleId="isKeyfields" insertable="true" updatable="true" onclick="switchByKey(document.all.isKeyfields[0].checked)" />&nbsp;<bean:message key="xls.journal.find.pk"/>&nbsp;&nbsp;
					<july:checkbox property="isImpsesid" styleId="isImpsesid" insertable="true" updatable="true" onclick="switchBySes(document.all.isImpsesid[0].checked)" />&nbsp;<bean:message key="xls.journal.find.session"/>&nbsp;&nbsp;
					<july:string size="10" property="key_ses" styleId="key_ses" insertable="true" updatable="true" />
				</td>
			</tr>
		</table>
		</td>
</tr>
<july:separator colspan="6"/>
<tr class="title">
	<td colspan="6"><TABLE class="buttons">
		<TR class="title">
			<TD class="buttons"><july:backbutton page="<%=returnUrl%>"/></TD>
            <TD class="navigator"><july:navigator/></TD>
         </TR>
     </TABLE></TD>
</tr>      
<july:separator colspan="6" />
  
    <!-- Table header -->
<tr class="title">
	<july:headercolumn key="xls.journal.loaddate"	colType="string"/>
	<july:headercolumn key="xls.journal.sessionnum"	colType="string"/>
	<july:headercolumn key="xls.journal.operator"	colType="string"/>
	<july:headercolumn key="xls.journal.filename"	colType="string"/>
	<july:headercolumn key="xls.journal.filesize"	colType="string"/>
	<july:headercolumn key="xls.journal.entrycount"	colType="string"/>
</tr>
<july:separator colspan="6" />

<logic:iterate id="row" name="browseList">
<logic:present name="row">
<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
	<td class="text"><bean:write name="row" property="importstart" filter="true"/></td>
	<td class="text"><%--<bean:write name="row" property="impsesid" filter="true"/>--%>
	<july:link page="/ShowXlsLoadResults.do?action=Edit" paramId="impsesid" paramName="row" paramProperty="impsesid">
                   <bean:write name="row" property="impsesid" filter="true"/>
                </july:link></td>
	<td class="text"><bean:write name="row" property="operator.man.fullName" filter="true"/></td>
	<td class="text"><bean:write name="row" property="filename" filter="true"/></td>
	<td class="text"><bean:write name="row" property="filesize" filter="true"/></td>
	<td class="text"><bean:write name="row" property="reccount" filter="true"/></td>	
</tr>
</logic:present>
</logic:iterate>
<tr class="title">
	<td colspan="6"><TABLE class="buttons">
		<TR class="title">
			<TD class="buttons"><july:backbutton/></TD>
            <TD class="navigator"><july:navigator/></TD>
         </TR>
     </TABLE></TD>
</tr>      

<july:separator colspan="6" />

</table>

</july:browseform>

<script language="javascript">
switchDate();
switchOperator(document.all.isOperator[0].checked);
switchKey_Ses();
</script>