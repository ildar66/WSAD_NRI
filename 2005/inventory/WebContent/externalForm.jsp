<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import="com.hps.july.inventory.formbean.*"%>
<%@ page import="org.apache.struts.util.*"%>
<%@ page import="java.math.*"%>

<%
	String masterTagId = "changeSFormWordEditMasterTagId";
%>
<july:wordEditMaster styleId='<%= masterTagId %>' >
</july:wordEditMaster>

<july:editform action="/ProcessExternal.do">
<script language="javascript">
function printWord(prompt1){
	window.location.href='reports/inWayBill.jsp?prompt1='+prompt1;
}
</script>
<%
	ExternalForm frm = (ExternalForm)request.getSession().getAttribute("ExternalForm");
	boolean showpositions = "View".equals(frm.getAction()) || "Edit".equals(frm.getAction());
	boolean changable = "1".equals(frm.getDState()) && !frm.getIsautodoc() && ("View".equals(frm.getAction()) || "Edit".equals(frm.getAction()));
	String theDocCode = "";
	if (showpositions) {
		theDocCode = frm.getDocumentId().toString(); 
	}
	String mockIndex = frm.MOCK_DOC_ID;
%>

<bean:define id="docCode" name="ExternalForm" property="document" scope="session" type="java.lang.Integer"/>
<july:inventorycalcerrors document="<%= docCode %>"/>
<script language="javascript" src="/action.js"></script>

<html:hidden property="documentstr" />
<html:hidden property="expeditionstr" />

<table class="main">
<%--<tr class="title">
	<td class="title" colspan="2">
		<html:link page="/ShowExternalList.do" styleClass="navigator"><bean:message key="label.external"/></html:link> 
		<july:sepmark/> 
		<july:currmark><bean:message key="label.externalpos"/></july:currmark>
	</td>
</tr>--%>
<july:separator/>


<july:formbuttons>
<%if(showpositions){%>
<%--
<A href='javascript:printWord(<%=docCode%>)'><img 
	src="/images/print.gif" border=0 alt='Напечатать акт'></A>
--%>	
		<july:wordEditSlave masterStyleId='<%= masterTagId %>' styleId='<%= "externalForm_" + theDocCode %>' 
		url='<%= "reports/inWayBill.jsp?prompt1=" + theDocCode %>' 
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
		<html:link page="/ProcessExternal.do?action=Edit&processState=C" paramId="document" paramName="ExternalForm" paramProperty="document" paramScope="session" onclick="return checkPosted();"><img src="/images/calculates.gif" border=0 alt="Снять обсчёт"></html:link>
	<%}%>
<%}%>
</july:formbuttons>


<july:separator/>
<tr>
	<td class="title" colspan="2"><july:actionalert/></td>
</tr>
<july:separator/>
<tr>
	<td class="text"><july:reqmark><bean:message key="label.external.owner"/>:</july:reqmark></td>
	<td>
		<july:select collection="owners" property="ownercode" insertable="true" updatable="true">
		<html:options collection="owners" property="organization" labelProperty="name"/>
		</july:select>
	</td>
</tr>
<july:separator/>
<tr>
	<td class="text"><july:reqmark><bean:message key="label.external.storage"/>:</july:reqmark></td>
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
	<td class="text"><july:reqmark><bean:message key="label.external.num"/>:</july:reqmark></td>
	<td> 
        <%-- <july:string property="blankindexFrm" size="15" insertable="true" updatable="true" /> --%>
    	<html:hidden property="blankindexFrm" value="<%=mockIndex%>" />
		<july:string property="blanknumber" size="15" insertable="true" updatable="true" />
	</td>
</tr>
<july:separator/>
<tr>
	<td class="text"><july:reqmark><bean:message key="label.external.date"/>:</july:reqmark></td>
	<td>
		<july:date property="blankdatestr" size="25" insertable="true" updatable="true" />
	</td>
</tr>
<july:separator/>
<tr>
	<td class="text"><bean:message key="label.external.accnum"/>:</td>
	<td>
		<july:string property="cordocnum" size="15" insertable="true" updatable="true" />
	</td>
</tr>
<july:separator/>
<tr>
	<td class="text"><bean:message key="label.external.accdate"/>:</td>
	<td>
		<july:date property="cordocdatestr" size="25" insertable="true" updatable="true" required="false" />
	</td>
</tr>
<july:separator/>
<tr>
	<td class="text"><bean:message key="label.external.gtdnum"/>:</td>
	<td>
		<july:string property="gtdnumber" size="15" insertable="true" updatable="true" />
	</td>
</tr>
<july:separator/>
<tr>
	<td class="text"><bean:message key="label.external.gtddate"/>:</td>
	<td>
		<july:date property="gtddatestr" size="25" insertable="true" updatable="true" required="false"/>
	</td>
</tr>
<july:separator/>
<tr>
	<td class="text"><july:reqmark><bean:message key="label.external.supplier"/>:</july:reqmark></td>
	<td>
		<july:string property="suppliercode" styleId="suppliercode" size="5" insertable="true" updatable="true" />
		<july:lookupbutton action="/ShowOrganizationLookupList.do" styleId="orgl" fieldNames="suppliercode;suppliername" newWindowName="organizationlookup"  insertable="true" updatable="true" onclick="set_opt_params_orgl('?selissupplier=true&selisrenter=false&selissupplier=false');" />
		<july:string size="50" property="suppliername" styleId="suppliername" insertable="false" updatable="false" />
	</td>
</tr>
<july:separator/>
<tr>
	<td class="text"><bean:message key="label.external.contract"/>:</td>
	<td>
		<july:string property="contractcode" styleId="contractcode" size="5" insertable="true" updatable="true" />
		<july:lookupbutton action="/ShowContractLookupList.do" styleId="contl" fieldNames="contractcode;contractname" newWindowName="contractlookup" insertable="true" updatable="true" onclick="if(ExternalForm.suppliercode.value == '') { alert('Укажите поставщика!'); return false; } set_opt_params_contl('?contragent='+document.all.suppliercode.value+'&allcontragent=false'+'&owner='+document.all.ownercode.options[document.all.ownercode.selectedIndex].value+'&allowner=false');" />
		<july:string size="35" property="contractname" styleId="contractname" insertable="false" updatable="false" />
	</td>
</tr>
<july:separator/>
<tr>
	<td class="text"><july:reqmark><bean:message key="label.external.currency"/>:</july:reqmark></td>
        <td>
		<july:select collection="currencies" property="currencycode" insertable="true" updatable="true">
		<html:options collection="currencies" property="currency" labelProperty="name"/>
		</july:select>
	</td>
</tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.external.supplycond"/>:</july:reqmark></td>
        <td>
           <july:radio insertable="true" updatable="true" property="supplyCondition" value="P" styleClass="text"/><bean:message key="label.external.supplycond.p"/>
           <july:radio insertable="true" updatable="true" property="supplyCondition" value="T" styleClass="text"/><bean:message key="label.external.supplycond.t"/>
        </td>
    </tr>
    
    <july:separator/>

<script language="javascript">
function switchFromLookup(state) {
	if(document.all.action.value=='Edit' || document.all.action.value=='Add') {
	if(state) {
		ExternalForm.fromwcode.className = 'editkod';
		ExternalForm.fromwcode.disabled = false;
		document.all.lookupbtn_fwl.disabled = false;
		document.all.lookupimg_fwl.src='/images/lookup.gif';
	} else {
		ExternalForm.fromwcode.className = 'editkoddisabled';
		ExternalForm.fromwcode.disabled = true;
		document.all.lookupbtn_fwl.disabled = true;
		document.all.lookupimg_fwl.src='/images/lookup_disabled.gif';
	}
	}
}
function switchItem(itemname,state) {
	if(document.all.action.value=='Edit' || document.all.action.value=='Add') {
	if(state) {
		ExternalForm[itemname].disabled = true;
		ExternalForm[itemname].className = 'editbigdisabled';
	} else {
		ExternalForm[itemname].disabled = false;
		ExternalForm[itemname].className = 'editbig';
	}
	}
}

function switchFrom() {
	if(document.all.action.value=='Edit' || document.all.action.value=='Add') {
	if(ExternalForm.representtype[0].checked) {
		switchItem('insuranseMan',false);
		switchFromLookup(false);
	} else if(ExternalForm.representtype[1].checked) {
		switchItem('insuranseMan',true);
		switchFromLookup(true);
	}
	}
}
</script>

    <tr>
        <td class="text" colspan="2"><july:reqmark><bean:message key="label.external.from"/>:</july:reqmark></td>
    </tr>

    <tr>
        <td class="text">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<bean:message key="label.external.insuranseman"/>:</td>
        <td>
			<july:radio insertable="true" updatable="true" property="representtype" value="R" onclick="switchFrom();" styleClass="text"/>
			<july:string size="40" property="insuranseMan" styleId="insuranseMan" insertable="true" updatable="true" />
        </td>
    </tr>

    <tr>
        <td class="text">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<bean:message key="label.external.man"/>:</td>
        <td>
			<july:radio insertable="true" updatable="true" property="representtype" value="W" onclick="switchFrom();" styleClass="text"/>
			<july:string property="fromwcode" styleId="fromwcode" size="5" insertable="true" updatable="true" />
			<july:lookupbutton action="/ShowWorkerLookupList.do" styleId="fwl" fieldNames="fromwcode;fromwname;fromwtitle" newWindowName="workerlookup"  insertable="true" updatable="true" />
			<july:string size="25" property="fromwname" styleId="fromwname" insertable="false" updatable="false" />
			<july:string size="15" property="fromwtitle" styleId="fromwtitle" insertable="false" updatable="false" />
        </td>
    </tr>

    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark/><bean:message key="label.external.worker"/>:</july:reqmark></td>
        <td>
			<july:string property="workercode" styleId="workercode" size="5" insertable="true" updatable="true" />
			<july:lookupbutton action="/ShowWorkerLookupList.do" styleId="workl" fieldNames="workercode;workername;workertitle" newWindowName="workerlookup"  insertable="true" updatable="true" />
			<july:string size="25" property="workername" styleId="workername" insertable="false" updatable="false" />
			<july:string size="15" property="workertitle" styleId="workertitle" insertable="false" updatable="false" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><bean:message key="label.external.state"/>:</td>
        <td>
		   <logic:equal name="ExternalForm" property="dState" value="1"><bean:message key="label.state.entering"/></logic:equal>
		   <logic:equal name="ExternalForm" property="dState" value="2"><bean:message key="label.state.calculated"/></logic:equal>
        </td>
    </tr>
    
<july:separator/>

<july:formbuttons>
<input type="hidden" name="processState" value="">
<%if(showpositions){%>
<%--
<A href='javascript:printWord(<%=docCode%>)'><img 
	src="/images/print.gif" border=0 alt='Напечатать акт'></A>
--%>
		<july:wordEditSlave masterStyleId='<%= masterTagId %>' styleId='<%= "externalForm02_" + theDocCode %>' 
		url='<%= "reports/inWayBill.jsp?prompt1=" + theDocCode %>' 
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
<html:hidden property="warnProc"/>
<%}%>
	<%} else {%>
		<html:link page="/ProcessExternal.do?action=Edit&processState=C" paramId="document" paramName="ExternalForm" paramProperty="document" paramScope="session" onclick="return checkPosted();"><img src="/images/calculates.gif" border=0 alt="Снять обсчёт"></html:link>
	<%}%>
<%}%>
</july:formbuttons>

    
<%if(showpositions) {%>
<july:separator/>
<tr class="title">
	<td colspan="2" class="title">
	<table cellpadding=0 cellspacing=0 width=100% border=0 class="main">
	<tr>
		<td><nobr><%if(changable) {%><july:addbutton page="/EditExternalPosition.do?action=Add" alttext="label.externalpos.add"/> &nbsp; <html:link page="/ExternalLoadExcel.do?action=Add" paramId="doc" paramName="ExternalForm" paramProperty="document" paramScope="session"><img src="/images/loadexcel.gif" border="0" alt="Загрузка данных из Excel"></html:link></logic:equal><%}%></nobr></td>
		<td class="title" align="right"><bean:message key="label.external.positions"/></td>
	</tr>
	</table>
	</td>
</tr>
<july:separator/>
<tr><td colspan="2" style="padding:0px;">
	<table class="main">
	<tr class="title">
		<july:headercolumn key="label.void" colType="string"/>
		<july:headercolumn key="label.externalpos.num" colType="number"/>
		<july:headercolumn key="label.externalpos.name" colType="string"/>
		<july:headercolumn key="label.externalpos.unit" colType="string"/>
		<july:headercolumn key="label.externalpos.doc.cnt.short" colType="number"/>
		<july:headercolumn key="label.externalpos.fact.cnt.short" colType="number"/>
		<july:headercolumn key="label.externalpos.doc.price.short" colType="number"/>
		<july:headercolumn key="label.externalpos.fact.price.short" colType="number"/>
		<july:headercolumn key="label.externalpos.doc.sum.short" colType="number"/>
		<july:headercolumn key="label.externalpos.fact.sum.short" colType="number"/>
		<july:headercolumn key="label.externalpos.serial" colType="string"/>
		<td class="title">&nbsp;</td>
	</tr>
<logic:iterate id="it" name="ExternalForm" property="listItems" type="com.hps.july.cdbc.lib.CDBCRowObject">
<logic:present name="it">
<%
	pageContext.setAttribute("odpid",it.getColumn("odpid").asString());
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
	String policy = it.getColumn("policy").asString();

	String resourcename = "";
	if(nama != null) {
		resourcename = ResponseUtils.filter(nama);
		if(modela != null && !"".equals(modela)) {
			resourcename += ",<br>" + ResponseUtils.filter(modela);
		}
		if(configa != null && !"".equals(configa)) {
			resourcename += ",<br>" + ResponseUtils.filter(configa);
		}
	}
	BigDecimal dsum = new BigDecimal(0.0);
	BigDecimal fsum = new BigDecimal(0.0);
	try {
		BigDecimal dq = (BigDecimal)it.getColumn("docqty").asObject();
		BigDecimal dp = (BigDecimal)it.getColumn("docprice").asObject();
		BigDecimal fq = (BigDecimal)it.getColumn("factqty").asObject();
		BigDecimal fp = (BigDecimal)it.getColumn("factsrcprice").asObject();
		dsum = dq.multiply(dp);
		fsum = fq.multiply(fp);
	} catch(Exception e) {
	}
	pageContext.setAttribute("docsum",dsum);
	pageContext.setAttribute("factsum",fsum);
%>
<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
	<td class="text">
		<%if(changable){%>
			<july:editbutton page="/EditExternalPosition.do" action="Edit" paramId="outerDocPosition" paramName="odpid" paramScope="page" alttext="label.externalpos.edit"/>
		<%} else {%>
			<july:editbutton page="/EditExternalPosition.do" action="View" paramId="outerDocPosition" paramName="odpid" paramScope="page" alttext="label.externalpos.view"/>
		<%}%>
	</td>
	<td class="text"><july:stringwrite name="it" property="order"/></td>
	<td class="text"><%=resourcename%></td>
	<td class="text"><july:stringwrite name="it" property="shortname"/></td>
	<td class="text"><july:numberwrite name="it" property="docqty"/></td>
	<td class="text"><july:numberwrite name="it" property="factqty"/></td>
	<td class="text"><july:numberwrite name="it" property="docprice" fractdigits="2"/></td>
	<td class="text">
		<%if(changable) {%>
			<july:numberwrite name="it" property="factsrcprice" fractdigits="2"/>
		<%} else {%>
			<%if(!"B".equals(policy)) {%>
			<html:link page="/EditExternalPosition.do?action=Edit" paramId="outerDocPosition" paramName="odpid" paramScope="page">
				<july:numberwrite name="it" property="factsrcprice" fractdigits="2"/>
			</html:link>
			<%} else {%>
				<july:numberwrite name="it" property="factsrcprice" fractdigits="2"/>
			<%}%>
		<%}%>
	</td>
	<td class="text"><july:numberwrite name="docsum" fractdigits="2"/></td>
	<td class="text"><july:numberwrite name="factsum" fractdigits="2"/></td>
	<td class="link">
		<%if("S".equals(policy)) {%>
			<html:link page="/ShowExternalSerialList.do" paramId="outerDocPosition" paramName="odpid" paramScope="page">
				<bean:message key="label.externalpos.serial" />
			</html:link>
		<%}%>
	</td>
	<td class="link">
		<%if(changable) {%><july:delbutton page="/EditExternalPosition.do?action=Delete" paramId="outerDocPosition" paramName="odpid" paramScope="page"/><%}%>
	</td>
</tr>
</logic:present>
</logic:iterate>
</table>
<july:separator/>
<tr class="title">
	<td colspan="2" class="title">
	<table cellpadding=0 cellspacing=0 width=100% border=0 class="main">
	<tr>
		<td><nobr><%if(changable) {%><july:addbutton page="/EditExternalPosition.do?action=Add" alttext="label.externalpos.add"/> &nbsp; <html:link page="/ExternalLoadExcel.do?action=Add" paramId="doc" paramName="ExternalForm" paramProperty="document" paramScope="session"><img src="/images/loadexcel.gif" border="0" alt="Загрузка данных из Excel"></html:link></logic:equal><%}%></nobr></td>
		<td class="title" align="right">&nbsp;</td>
	</tr>
	</table>
	</td>
</tr>
<%}%>
</table>
<script language="javascript">
switchFrom();
</script>
</july:editform>

