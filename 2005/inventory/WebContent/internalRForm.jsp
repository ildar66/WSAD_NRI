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

<july:editform action="/ProcessInternalR.do">
<bean:define id="docCode" name="InternalRForm" property="document" scope="session" type="java.lang.Integer"/>
<july:inventorycalcerrors document="<%=docCode%>"/>
<script language="javascript" src="/action.js"></script>
<%
	InternalRForm frm = (InternalRForm)request.getSession().getAttribute("InternalRForm");
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
	if((InternalRForm['action'].value == 'Add') || (InternalRForm['action'].value == 'Edit')) {
	if(disabled) {
		InternalRForm[itemname].className = 'editkoddisabled';
		InternalRForm[itemname].disabled = true;
		InternalRForm[itemname].readonly = true;
		document.all['lookupbtn_'+lookupname+'l'].disabled = true;
		document.all['lookupimg_'+lookupname+'l'].src='/images/lookup_disabled.gif';
	} else {
		InternalRForm[itemname].className = 'editkod';
		InternalRForm[itemname].disabled = false;
		InternalRForm[itemname].readonly = false;
		document.all['lookupbtn_'+lookupname+'l'].disabled = false;
		document.all['lookupimg_'+lookupname+'l'].src='/images/lookup.gif';
	}
	}
}

function switchItem(itemname,state) {
	if((InternalRForm['action'].value == 'Add') || (InternalRForm['action'].value == 'Edit')) {
	if(state) {
		InternalRForm[itemname].disabled = true;
		InternalRForm[itemname].className = 'editdisabled';
	} else {
		InternalRForm[itemname].disabled = false;
		InternalRForm[itemname].className = 'edit';
	}
	}
}

function switchFilter() {
	if((InternalRForm['action'].value == 'Add') || (InternalRForm['action'].value == 'Edit')) {
	if(InternalRForm.type[0].checked) {
		switchLookup('rentercode','org',false);
		switchLookup('workercode','work1',true);
		InternalRForm['rentername'].disabled = false;
		InternalRForm['workername'].disabled = true;
		InternalRForm['workertitle'].disabled = true;
		switchItem('insuranseMan',false);
		switchItem('insuranceact',false);
		InternalRForm['insurancedatectl_dt'].enabled = true;
	} else
	if(InternalRForm.type[1].checked) {
		switchLookup('rentercode','org',true);
		switchLookup('workercode','work1',false);
		InternalRForm['rentername'].disabled = true;
		InternalRForm['workername'].disabled = false;
		InternalRForm['workertitle'].disabled = false;
		switchItem('insuranseMan',true);
		switchItem('insuranceact',true);
		InternalRForm['insurancedatectl_dt'].enabled = false;
	} else {
		switchLookup('rentercode','org',true);
		switchLookup('workercode','work1',true);
		InternalRForm['rentername'].disabled = true;
		InternalRForm['workername'].disabled = true;
		InternalRForm['workertitle'].disabled = true;
		switchItem('insuranseMan',true);
		switchItem('insuranceact',true);
		InternalRForm['insurancedatectl_dt'].enabled = false;
	}
	}
}

function checkFixing() {
	switchLookup('positioncode','pos',InternalRForm['fixing'][0].checked);
}
function printWord(prompt1){
	window.location.href='reports/internalR.jsp?prompt1='+prompt1;
}
</script>

<html:hidden property="documentstr" />
<html:hidden property="expeditionstr" />
<input type="hidden" name="processState" value="">

<table class="main">
        
    <july:separator/>
    
	<july:formbuttons>
	<%if(showpositions){%>
    <%--
	<A href='javascript:printWord(<%=docCode%>)'><img 
	src="/images/print.gif" border=0 alt='Напечатать акт'></A>
	--%>
		<july:wordEditSlave masterStyleId='<%= masterTagId %>' styleId='<%= "internalRForm_" + theDocCode %>' 
		url='<%= "reports/internalR.jsp?prompt1=" + theDocCode %>' 
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
			<html:link page="/ProcessInternalR.do?action=Edit&processState=C" paramId="document" paramName="InternalRForm" paramProperty="document" paramScope="session" onclick="return checkPosted();"><img src="/images/calculates.gif" border=0 alt="Снять обсчёт"></html:link>
		<%}%>
	<%}%>
	</july:formbuttons>

	<july:separator/>

    <tr>
        <td class="title" colspan="2"><july:actionalert/></td>
    </tr>

    <july:separator/>

    <tr>
        <td class="text"><july:reqmark><bean:message key="label.internalr.owner"/>:</july:reqmark></td>
        <td>
			<july:select collection="owners" property="ownercode" insertable="true" updatable="true">
				<html:options collection="owners" property="organization" labelProperty="name"/>
			</july:select>
        </td>
    </tr>

    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.internalr.storage"/>:</july:reqmark></td>
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
        <td class="text"><july:reqmark><bean:message key="label.internalr.num"/>:</july:reqmark></td>
        <td>
           <%-- <july:string property="blankindexFrm" size="15" insertable="true" updatable="true" /> --%>
		   <html:hidden property="blankindexFrm" value="<%=mockIndex%>" />
           <july:string property="blanknumber" size="15" insertable="true" updatable="true" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.internalr.date"/>:</july:reqmark></td>
        <td>
			<july:date property="blankdatestr" styleId="blankdatestrctl" size="25" insertable="true" updatable="true" />
        </td>
    </tr>

    <july:separator/>
<%--logic:equal name="InternalRForm" property="action" value="Add"--%>
    <tr>
        <td class="text"><bean:message key="label.internalr.requirement"/>:</td>
        <td>
			<july:string property="reqcode" styleId="reqcode" size="5" insertable="true" updatable="false" />
			<july:lookupbutton action="/ShowReqLookupList.do" styleId="reql" fieldNames="reqcode;reqnum;reqdate;type;workercode;workername;workertitle;rentercode;rentername;insuranseMan;positioncode;positionname;positionid" newWindowName="reqlookup" insertable="true" updatable="false" />
			<july:string size="5" property="reqnum" styleId="reqnum" insertable="false" updatable="false" />
			<july:string size="10" property="reqdate" styleId="reqdate" insertable="false" updatable="false" />
        </td>
    </tr>
    
    <july:separator/>
<%--/logic:equal--%>
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.internalr.fixing"/>:</july:reqmark></td>
        <td>
			<july:checkbox property="fixing" insertable="true" updatable="true" value="true" onclick="checkFixing();"/><html:hidden property="fixing" value="false"/>
        </td>
    </tr>
    
    <july:separator/>

	<tr>
		<td class="text"><july:reqmark><bean:message key="label.internalr.type"/>:</july:reqmark></td>
		<td>
			<july:radio insertable="true" updatable="true" property="type" value="P" onclick="switchFilter();"/><bean:message key="label.internalr.type.forp"/>
			<july:radio insertable="true" updatable="true" property="type" value="W" onclick="switchFilter();"/><bean:message key="label.internalr.type.forw"/>
		</td>
	</tr>
    
    <july:separator/>

    <tr>
        <td class="text"><july:reqmark><bean:message key="label.internalr.renter"/></july:reqmark>:</td>
        <td>
			<july:string property="rentercode" styleId="rentercode" size="5" insertable="true" updatable="true" />
			<july:lookupbutton action="/ShowOrganizationLookupList.do" styleId="orgl" fieldNames="rentercode;rentername" newWindowName="organizationlookup"  insertable="true" updatable="true"  onclick="set_opt_params_orgl('?selisprovider=true&selisrenter=false&selissupplier=false');" />
			<july:string size="35" property="rentername" styleId="rentername" insertable="false" updatable="false" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text">&nbsp;&nbsp;&nbsp;&nbsp;<july:reqmark><bean:message key="label.internalr.representative"/></july:reqmark>:</td>
        <td>
			<july:string size="35" property="insuranseMan" insertable="true" updatable="true" />
        </td>
    </tr>
    
    <july:separator/>

    <tr>
        <td class="text">&nbsp;&nbsp;&nbsp;&nbsp;<july:reqmark><bean:message key="label.internalr.dovnum"/></july:reqmark>:</td>
        <td>
           <july:string property="insuranceact" size="15" insertable="true" updatable="true" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text">&nbsp;&nbsp;&nbsp;&nbsp;<bean:message key="label.internalr.dovdate"/>:</td>
        <td>
			<july:date property="insurancedatestr" styleId="insurancedatectl" size="25" insertable="true" updatable="true"/>
        </td>
    </tr>

    <july:separator/>

    <tr>
        <td class="text"><july:reqmark><bean:message key="label.internalr.worker"/></july:reqmark>:</td>
        <td nowrap>
			<july:string property="workercode" styleId="workercode" size="5" insertable="true" updatable="true" />
			<july:lookupbutton action="/ShowWorkerLookupList.do" styleId="work1l" fieldNames="workercode;workername;workertitle" newWindowName="workerlookup"  insertable="true" updatable="true" />
			<july:string size="25" property="workername" styleId="workername" insertable="false" updatable="false" />
			<july:string size="20" property="workertitle" styleId="workertitle" insertable="false" updatable="false" />
        </td>
    </tr>
    
    <july:separator/>

    <tr>
        <td class="text"><bean:message key="label.internalr.position"/>:</td>
        <td>
			<july:string property="positioncode" styleId="positioncode" size="5" insertable="true" updatable="true" />
			<july:lookupbutton action="/ShowPositionLookupList.do" styleId="posl" fieldNames="positioncode;positionid;positionname" newWindowName="positionlookup"  insertable="true" updatable="true" />
			<july:string size="10" property="positionid" styleId="positionid" insertable="false" updatable="false" />
			<july:string size="20" property="positionname" styleId="positionname" insertable="false" updatable="false" />
        </td>
    </tr>
    
    <july:separator/>

    <tr>
        <td class="text"><july:reqmark><bean:message key="label.internalr.storageman"/>:</july:reqmark></td>
        <td nowrap>
			<july:string property="storagemancode" styleId="storagemancode" size="5" insertable="true" updatable="true" />
			<july:lookupbutton action="/ShowWorkerLookupList.do" styleId="work2" fieldNames="storagemancode;storagemanname;storagemantitle" newWindowName="workerlookup"  insertable="true" updatable="true" />
			<july:string size="25" property="storagemanname" styleId="storagemanname" insertable="false" updatable="false" />
			<july:string size="20" property="storagemantitle" styleId="storagemantitle" insertable="false" updatable="false" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><bean:message key="label.internalr.state"/>:</td>
        <td>
		   <logic:equal name="InternalRForm" property="dState" value="1">
	           <bean:message key="label.state.entering"/>
           </logic:equal>
		   <logic:equal name="InternalRForm" property="dState" value="2">
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
		<july:wordEditSlave masterStyleId='<%= masterTagId %>' styleId='<%= "internalRForm02_" + theDocCode %>' 
		url='<%= "reports/internalR.jsp?prompt1=" + theDocCode %>' 
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
		<html:link page="/ProcessInternalR.do?action=Edit&processState=C" paramId="document" paramName="InternalRForm" paramProperty="document" paramScope="session" onclick="return checkPosted();"><img src="/images/calculates.gif" border=0 alt="Снять обсчёт"></html:link>
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
			<july:addbutton page="/EditInternalRPosition.do?action=Add" alttext="label.internalrpos.add" />
			<img src="/images/empty.gif" border='0' alt='' width='3'>
			<html:link page="/InternalRLoadExcel.do?action=Add" paramId="doc" paramName="InternalRForm" paramProperty="document" paramScope="session"><img src="/images/loadexcel.gif" border="0" alt="Загрузка данных из Excel"></html:link>
			<img src="/images/empty.gif" border='0' alt='' width='3'>
		<%}%></nobr></td>
		<td class="title" align="right"><bean:message key="label.internalrpos"/></td>
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
		<july:headercolumn key="label.internalrpos.name" colType="string"/>
		<july:headercolumn key="label.internalrpos.qty.short" colType="string"/>
		<july:headercolumn key="label.internalrpos.unit.short" colType="string"/>
		<july:headercolumn key="label.internalrpos.price" colType="string"/>
		<july:headercolumn key="label.internalrpos.sum" colType="string"/>
		<july:headercolumn key="label.internalrpos.serial" colType="string"/>
		<%if(changable) {%><td class="title">&nbsp;</td><%}%>
	</tr>
<logic:iterate id="it" name="InternalRForm" property="listItems" type="com.hps.july.cdbc.lib.CDBCRowObject">
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
			<july:editbutton page="/EditInternalRPosition.do" action="Edit" paramId="docposition" paramName="docposition" paramScope="page" alttext="label.internalrpos.edit"/>
		<%} else {%>
			<july:editbutton page="/EditInternalRPosition.do" action="View" paramId="docposition" paramName="docposition" paramScope="page" alttext="label.internalrpos.view"/>
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
			<july:delbutton page="/EditInternalRPosition.do?action=Delete" paramId="docposition" paramName="docposition" paramScope="page" />
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
			<july:addbutton page="/EditInternalRPosition.do?action=Add" alttext="label.internalrpos.add" />
			<img src="/images/empty.gif" border='0' alt='' width='3'>
			<html:link page="/InternalRLoadExcel.do?action=Add" paramId="doc" paramName="InternalRForm" paramProperty="document" paramScope="session"><img src="/images/loadexcel.gif" border="0" alt="Загрузка данных из Excel"></html:link>
			<img src="/images/empty.gif" border='0' alt='' width='3'>
		<%}%></nobr></td>
		<td class="title" align="right">&nbsp;</td>
	</tr>
	</table>
	</td>
</tr>
<%}%>    

</table>

<script language="javascript">
	switchFilter();
	checkFixing();
</script>

</july:editform>

