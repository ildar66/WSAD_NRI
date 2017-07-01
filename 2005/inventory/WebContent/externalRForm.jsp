<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import="org.apache.struts.util.*"%>
<%@ page import="com.hps.july.inventory.formbean.*"%>

<%
	String masterTagId = "changeSFormWordEditMasterTagId";
%>
<july:wordEditMaster styleId='<%= masterTagId %>' >
</july:wordEditMaster>

<july:editform action="/ProcessExternalR.do">
<bean:define id="docCode" name="ExternalRForm" property="document" scope="session" type="java.lang.Integer"/>
<july:inventorycalcerrors document="<%=docCode%>"/>
<script language="javascript" src="/action.js"></script>
<%
	ExternalRForm frm = (ExternalRForm)request.getSession().getAttribute("ExternalRForm");
	boolean showpositions = "View".equals(frm.getAction()) || "Edit".equals(frm.getAction());
	boolean changable = "1".equals(frm.getDState()) && !frm.getIsautodoc() && ("View".equals(frm.getAction()) || "Edit".equals(frm.getAction()));
	String theDocCode = "";
	if (showpositions) {
		theDocCode = frm.getDocumentId().toString(); 
	}
	String mockIndex = frm.MOCK_DOC_ID;
%>

<script language="javascript">
function switchLookup(itemname,lookupname,disabled) {
	if(disabled) {
		ExternalRForm[itemname].className = 'editkoddisabled';
		ExternalRForm[itemname].disabled = true;
		ExternalRForm[itemname].readonly = true;
		document.all['lookupbtn_'+lookupname+'l'].disabled = true;
		document.all['lookupimg_'+lookupname+'l'].src='/images/lookup_disabled.gif';
	} else {
		ExternalRForm[itemname].className = 'editkod';
		ExternalRForm[itemname].disabled = false;
		ExternalRForm[itemname].readonly = false;
		document.all['lookupbtn_'+lookupname+'l'].disabled = false;
		document.all['lookupimg_'+lookupname+'l'].src='/images/lookup.gif';
	}
}

function switchItem(itemname,state) {
	if(state) {
		ExternalRForm[itemname].disabled = true;
		ExternalRForm[itemname].className = 'editdisabled';
	} else {
		ExternalRForm[itemname].disabled = false;
		ExternalRForm[itemname].className = 'edit';
	}
}
function printWord(prompt1){
	window.location.href='reports/externalR.jsp?prompt1='+prompt1;
}
</script>

<html:hidden property="documentstr" />
<html:hidden property="expeditionstr" />
<html:hidden property="warnProc"/>
<input type="hidden" name="processState" value="">

<table class="main">
        
    <july:separator/>
    
	<july:formbuttons>
	<%if(showpositions){%>
	<%--
	<A href='javascript:printWord(<%=docCode%>)'><img 
	src="/images/print.gif" border=0 alt='Напечатать акт'></A>
	--%>
		<july:wordEditSlave masterStyleId='<%= masterTagId %>' styleId='<%= "externalRForm_" + theDocCode %>' 
		url='<%= "reports/externalR.jsp?prompt1=" + theDocCode %>' 
			uploadurl=''
			updatable='false'
		documentid='<%= theDocCode %>'><IMG SRC="/images/docword.gif" border="0" alt='Напечатать акт'></july:wordEditSlave>
	<%}%>
	<%if(("View".equals(frm.getAction()) || "Edit".equals(frm.getAction())) && !frm.getIsautodoc()){%>
	&nbsp;&nbsp;
		<%if("1".equals(frm.getDState())) {%>
			<input type="image" name="submit" src="/images/calculate.gif" onclick="document.all.action.value='Edit';document.all.processState.value='P';document.all.warnProc.value='false';return checkPosted();" title="Обсчёт">
	<%if(com.hps.july.util.AppUtils.isNewInventory()){%>
	<%if(frm.getWarnProc() != null && frm.getWarnProc().booleanValue()) {%>
			<input type="image" name="submit" src="/images/calculatea.gif" onclick="document.all.action.value='Edit';document.all.processState.value='P';document.all.warnProc.value='true';return checkPosted();" title="Обсчёт с автоматическим исправлением несоответствий">
	<%}%>
	<%}%>
		<%} else {%>
			<html:link page="/ProcessExternalR.do?action=Edit&processState=C" paramId="document" paramName="ExternalRForm" paramProperty="document" paramScope="session" onclick="return checkPosted();"><img src="/images/calculates.gif" border=0 alt="Снять обсчёт"></html:link>
		<%}%>
	<%}%>
	</july:formbuttons>

	<july:separator/>

    <tr>
        <td class="title" colspan="2"><july:actionalert/></td>
    </tr>

    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.externalr.owner"/>:</july:reqmark></td>
        <td>
			<july:select collection="owners" property="ownercode" insertable="true" updatable="true">
				<html:options collection="owners" property="organization" labelProperty="name"/>
			</july:select>
        </td>
    </tr>

    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.externalr.storage"/>:</july:reqmark></td>
        <td>
<%if(frm.getUseStorageCombo()) {%>
   		<july:select collection="storages" property="storagecode" insertable="true" updatable="true" style="width:400;">
			<html:options collection="storages" property="storageplace" labelProperty="name"/>
		</july:select>
<%} else {%>
		<july:string property="storagecode" styleId="storagecode" size="5" insertable="true" updatable="true"/>
		<july:lookupbutton action="/ShowStorageLookupList.do" styleId="storl" fieldNames="storagecode;storagename" newWindowName="storagelookup"  insertable="true" updatable="true"/>
		<july:string size="35" property="storagename" styleId="storagename" insertable="false" updatable="false" />
<%}%>
        </td>
    </tr>

    <july:separator/>

    <tr> 
        <td class="text"><july:reqmark><bean:message key="label.externalr.num"/>:</july:reqmark></td>
        <td>
           <%-- <july:string property="blankindexFrm" size="15" insertable="true" updatable="true" /> --%>
    	   <html:hidden property="blankindexFrm" value="<%=mockIndex%>" />
           <july:string property="blanknumber" size="15" insertable="true" updatable="true" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.externalr.date"/>:</july:reqmark></td>
        <td>
			<july:date property="blankdatestr" styleId="blankdatestrctl" size="25" insertable="true" updatable="true" />
        </td>
    </tr>
    <july:separator/>

    <tr>
        <td class="text"><july:reqmark><bean:message key="label.externalr.recipient"/>:</july:reqmark></td>
        <td>
			<july:string property="recipientcode" styleId="recipientcode" size="5" insertable="true" updatable="true" />
			<july:lookupbutton action="/ShowOrganizationLookupList.do" styleId="recil" fieldNames="recipientcode;recipientname" newWindowName="organizationlookup"  insertable="true" updatable="true" onclick="set_opt_params_recil('?selisprovider=false&selisrenter=false&selissupplier=false');"/>
			<july:string size="35" property="recipientname" styleId="recipientname" insertable="false" updatable="false" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text">&nbsp;&nbsp;&nbsp;<july:reqmark><bean:message key="label.externalr.representative"/>:</july:reqmark></td>
        <td>
			<july:string size="35" property="insuranseMan" insertable="true" updatable="true" />
        </td>
    </tr>

    <july:separator/>

    <tr>
        <td class="text">&nbsp;&nbsp;&nbsp;<july:reqmark><bean:message key="label.externalr.dovnum"/>:</july:reqmark></td>
        <td>
           <july:string property="insuranceact" size="15" insertable="true" updatable="true" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text">&nbsp;&nbsp;&nbsp;<july:reqmark><bean:message key="label.externalr.dovdate"/>:</july:reqmark></td>
        <td>
			<july:date property="insurancedatestr" styleId="insurancedatectl" size="25" insertable="true" updatable="true"/>
        </td>
    </tr>

    <july:separator/>

    <tr>
        <td class="text"><july:reqmark><bean:message key="label.externalr.currency"/>:</july:reqmark></td>
        <td>
			<july:select collection="currencies" property="currencycode" insertable="true" updatable="true">
				<html:options collection="currencies" property="currency" labelProperty="name"/>
			</july:select>
        </td>
    </tr>
    
    <july:separator/>

    <tr>
        <td class="text"><july:reqmark><bean:message key="label.externalr.storageman"/>:</july:reqmark></td>
        <td nowrap>
			<july:string property="storagemancode" styleId="storagemancode" size="5" insertable="true" updatable="true" />
			<july:lookupbutton action="/ShowWorkerLookupList.do" styleId="work2" fieldNames="storagemancode;storagemanname;storagemantitle" newWindowName="workerlookup"  insertable="true" updatable="true" />
			<july:string size="25" property="storagemanname" styleId="storagemanname" insertable="false" updatable="false" />
			<july:string size="20" property="storagemantitle" styleId="storagemantitle" insertable="false" updatable="false" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><bean:message key="label.externalr.state"/>:</td>
        <td>
		   <logic:equal name="ExternalRForm" property="dState" value="1">
	           <bean:message key="label.state.entering"/>
           </logic:equal>
		   <logic:equal name="ExternalRForm" property="dState" value="2">
	           <bean:message key="label.state.calculated"/>
           </logic:equal>
        </td>
    </tr>
    
<july:separator/>
    
<july:formbuttons>
<%if(showpositions){%>
<%--
<A href='javascript:printWord(<%=docCode%>)'><img 
	src="/images/print.gif" border=0 alt='Напечатать акт'></A>
--%>	
		<july:wordEditSlave masterStyleId='<%= masterTagId %>' styleId='<%= "externalRForm02_" + theDocCode %>' 
		url='<%= "reports/externalR.jsp?prompt1=" + theDocCode %>' 
			uploadurl=''
			updatable='false'
		documentid='<%= theDocCode %>'><IMG SRC="/images/docword.gif" border="0" alt='Напечатать акт'></july:wordEditSlave>
<%}%>
<%if(("View".equals(frm.getAction()) || "Edit".equals(frm.getAction())) && !frm.getIsautodoc()){%>
&nbsp;&nbsp;
	<%if("1".equals(frm.getDState())) {%>
		<input type="image" name="submit" src="/images/calculate.gif" onclick="document.all.action.value='Edit';document.all.processState.value='P';document.all.warnProc.value='false';return checkPosted();" title="Обсчёт">
<%if(com.hps.july.util.AppUtils.isNewInventory()){%>
<%if(frm.getWarnProc() != null && frm.getWarnProc().booleanValue()) {%>
		<input type="image" name="submit" src="/images/calculatea.gif" onclick="document.all.action.value='Edit';document.all.processState.value='P';document.all.warnProc.value='true';return checkPosted();" title="Обсчёт с автоматическим исправлением несоответствий">
<%}%>
<%}%>
	<%} else {%>
		<html:link page="/ProcessExternalR.do?action=Edit&processState=C" paramId="document" paramName="ExternalRForm" paramProperty="document" paramScope="session" onclick="return checkPosted();"><img src="/images/calculates.gif" border=0 alt="Снять обсчёт"></html:link>
	<%}%>
<%}%>
</july:formbuttons>
    
<july:separator/>
<%if(showpositions) {%>
<tr class="title">
	<td colspan="2" class="title">
	<table cellpadding=0 cellspacing=0 width=100% border=0 class="main">
	<tr>
		<td><nobr><%if(changable) {%>
			<july:addbutton page="/EditExternalRPosition.do?action=Add" alttext="label.externalrpos.add"/>
			<img src="/images/empty.gif" border='0' alt='' width='3'>
		<%}%></nobr></td>
		<td class="title" align="right"><bean:message key="label.externalrpos"/></td>
	</tr>
	</table>
	</td>
</tr>
<july:separator/>
<tr><td colspan="2" style="padding:0px;">
	<table class="main">
	<tr class="title">
		<july:headercolumn key="label.void" colType="string"/>
		<july:headercolumn key="label.num" colType="number"/>
		<july:headercolumn key="label.externalrpos.name" colType="string"/>
		<july:headercolumn key="label.externalrpos.qty.short" colType="string"/>
		<july:headercolumn key="label.externalrpos.unit.short" colType="string"/>
		<july:headercolumn key="label.externalrpos.price" colType="string"/>
		<july:headercolumn key="label.externalrpos.sum" colType="string"/>
		<july:headercolumn key="label.externalrpos.serial" colType="string"/>
		<%if(changable) {%><td class="title">&nbsp;</td><%}%>
	</tr>
<logic:iterate id="it" name="ExternalRForm" property="listItems" type="com.hps.july.cdbc.lib.CDBCRowObject">
<logic:present name="it">
<%
	pageContext.setAttribute("docposition",it.getColumn("docposition").asString());
/*
	String serialnumber = it.getColumn("serial").asString();
	if(serialnumber != null) {
		String manufserial = it.getColumn("manufserial").asString();
		if(manufserial != null && !"".equals(manufserial) && !serialnumber.equals(manufserial) ) {
			serialnumber += " ("+manufserial+")";
		}
		pageContext.setAttribute("serialnumber",serialnumber);
	}
*/
	String nama = it.getColumn("name").asString();
	String modela = (it.getColumn("model").asObject() != null)?it.getColumn("model").asString():null;
	String configa = (it.getColumn("configuration").asObject() != null)?it.getColumn("configuration").asString():null;

%>
<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
	<td class="string">
		<%if(changable && it.getColumn("agregate").asObject() == null) {%>
			<july:editbutton page="/EditExternalRPosition.do" action="Edit" paramId="docposition" paramName="docposition" paramScope="page" alttext="label.externalrpos.edit"/>
		<%} else {%>
			<july:editbutton page="/EditExternalRPosition.do" action="View" paramId="docposition" paramName="docposition" paramScope="page" alttext="label.externalrpos.view"/>
		<%}%>
	</td>
	<td class="number"><july:stringwrite name="it" property="order"/></td>
	<td class="text"><%if(nama != null) {%><%=ResponseUtils.filter(nama)%><% if(modela != null && !"".equals(modela)) {%>,<br><%=ResponseUtils.filter(modela)%><%}%><% if(configa != null && !"".equals(configa)) {%>,<br><%=ResponseUtils.filter(configa)%><%}%><%}%></td>
	<td class="text"><july:numberwrite name="it" property="qty" /></td>
	<td class="text"><july:stringwrite name="it" property="uname"/></td>
	<td class="text"><july:numberwrite name="it" property="price" fractdigits="2"/></td>
	<td class="text"><july:numberwrite name="it" property="summ" fractdigits="2"/></td>
	<td class="text"><july:stringwrite name="it" property="invnum"/></td>
	<%if(changable) {%>
	<td class="link">
		<%if(it.getColumn("agregate").asObject() == null) {%>
			<july:delbutton page="/EditExternalRPosition.do?action=Delete" paramId="docposition" paramName="docposition" paramScope="page" />
		<%}%>
	</td>
	<%}%>
</tr>
</logic:present>
</logic:iterate>
	</table>
</td></tr>    
<july:separator/>
<tr class="title">
	<td colspan="2" class="title">
	<table cellpadding=0 cellspacing=0 width=100% border=0 class="main">
	<tr>
		<td><nobr><%if(changable) {%>
			<july:addbutton page="/EditExternalRPosition.do?action=Add" alttext="label.externalrpos.add"/>
			<img src="/images/empty.gif" border='0' alt='' width='3'>
		<%}%></nobr></td>
		<td class="title" align="right"><bean:message key="label.externalrpos"/></td>
	</tr>
	</table>
	</td>
</tr>
<%}%>    
    
</table>

</july:editform>

