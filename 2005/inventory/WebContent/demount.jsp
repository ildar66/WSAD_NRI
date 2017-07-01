<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import="com.hps.july.inventory.formbean.Demount" %>
<%@ page import="com.hps.july.util.AppUtils"%>

<%
	String masterTagId = "changeSFormWordEditMasterTagId";
%>
<july:wordEditMaster styleId='<%= masterTagId %>' >
</july:wordEditMaster>

<july:editform action="/ProcessDemount.do">
<bean:define id="docCode" name="Demount" property="doc" scope="session" type="java.lang.Integer"/>
<july:inventorycalcerrors document="<%=docCode%>"/>
<script language="javascript" src="/action.js"></script>
<%
	Demount frm = (Demount)request.getSession().getAttribute("Demount");
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
	if((Demount['action'].value == 'Add') || (Demount['action'].value == 'Edit'))
	{
		if(disabled) {
			if (Demount[itemname]) {
			Demount[itemname].className = 'editkoddisabled';
			Demount[itemname].disabled = true;
			Demount[itemname].readonly = true;
			}
			document.all['lookupbtn_'+lookupname+'l'].disabled = true;
			document.all['lookupimg_'+lookupname+'l'].src='/images/lookup_disabled.gif';
		} else {
			if (Demount[itemname]) {
			Demount[itemname].className = 'editkod';
			Demount[itemname].disabled = false;
			Demount[itemname].readonly = false;
			}
			document.all['lookupbtn_'+lookupname+'l'].disabled = false;
			document.all['lookupimg_'+lookupname+'l'].src='/images/lookup.gif';
		}
	}
}

<%if(AppUtils.isNewInventory()) {%>
function switchStorage() {
<%if(frm.getUseStorageCombo()) {%>
	if(document.all.transfer[0].checked) {
		document.all.storage.className='edit';
	} else {
		document.all.storage.className='editdisabled';
	}
	document.all.storage.disabled=!document.all.transfer[0].checked;
<%} else {%>
	switchLookup('storage','stor',!document.all.transfer[0].checked);
	
	// BEE00001159
	// document.all.moveToComplect[0].disabled=document.all.transfer[0].checked;
<%}%>
}
<%}%>

/*
// BEE00001159
function switchMoveToPosition() {
	document.all.transfer[0].disabled=document.all.moveToComplect[0].checked;
	switchLookup('moveToPositionCode','moveToPos',!document.all.moveToComplect[0].checked);
	switchLookup('moveToPositionCode','moveToPos',!document.all.moveToComplect[0].checked);
	switchLookup('','moveToCom',!document.all.moveToComplect[0].checked);
}
*/

function switchItem(itemname,state) {
	if((Demount['action'].value == 'Add') || (Demount['action'].value == 'Edit'))
	{
		if(state) {
			Demount[itemname].disabled = true;
			Demount[itemname].className = 'editdisabled';
		} else {
			Demount[itemname].disabled = false;
			Demount[itemname].className = 'edit';
		}
	}
}

function switchFilter() {
	if(document.all.action.value != 'View' && document.all.action.value != 'Delete') {
		if(Demount.type[0].checked) {
			switchLookup('providercode','prov',false);
			switchLookup('workercode','work1',true);
			Demount['providername'].disabled = false;
			Demount['workername'].disabled = true;
			Demount['workertitle'].disabled = true;
			switchItem('insuranseMan',false);
		} else
		if(Demount.type[1].checked) {
			switchLookup('providercode','prov',true);
			switchLookup('workercode','work1',false);
			Demount['providername'].disabled = true;
			Demount['workername'].disabled = false;
			Demount['workertitle'].disabled = false;
			switchItem('insuranseMan',true);
		} else {
			switchLookup('providercode','prov',true);
			switchLookup('workercode','work1',true);
			Demount['providername'].disabled = true;
			Demount['workername'].disabled = true;
			Demount['workertitle'].disabled = true;
			switchItem('insuranseMan',true);
		}
	}
}
function printWord(prompt1){
	//Печать актов:
	window.location.href='reports/dassactp.jsp?prompt1='+prompt1;
}
</script>

<html:hidden property="docstr" />
<html:hidden property="expeditionstr" />
<input type="hidden" name="processState" value="">

<table class="main">    
    
    <july:separator/>
    
	<july:formbuttons>
	<%if(showpositions) {%>
	<%--
	<A href='javascript:printWord(<%=docCode%>)'><img 
	src="/images/print.gif" border=0 alt='Напечатать акт'></A>
	--%>
		<july:wordEditSlave masterStyleId='<%= masterTagId %>' styleId='<%= "demountForm_" + theDocCode %>' 
		url='<%= "reports/dassactp.jsp?prompt1=" + theDocCode %>' 
			uploadurl=''
			updatable='false'
		documentid='<%= theDocCode %>'><IMG SRC="/images/docword.gif" border="0" alt='Напечатать акт'></july:wordEditSlave>
	<%}%>
	&nbsp;&nbsp;
	<%if(("View".equals(frm.getAction()) || "Edit".equals(frm.getAction())) && !frm.getIsautodoc()){%>
		<%if("1".equals(frm.getDState())) {%>
			<input type="image" name="submit" src="/images/calculate.gif" onclick="document.all.action.value='Edit';document.all.processState.value='P';return checkPosted();" title="Обсчёт">
		<%} else {%>
			<html:link page="/ProcessDemount.do?action=Edit&processState=C" paramId="doc" paramName="Demount" paramProperty="doc" paramScope="session" onclick="return checkPosted();"><img src="/images/calculates.gif" border=0 alt="Снять обсчёт"></html:link>
		<%}%>
	<%}%>
	</july:formbuttons>

	<july:separator/>

    <tr>
        <td class="title" colspan="2"><july:actionalert/></td>
    </tr>

    <july:separator/>

    <tr>
        <td class="text"><july:reqmark><bean:message key="label.dismantlingp.owner"/>:</july:reqmark></td>
        <td>
			<july:select collection="owners" property="ownercode" insertable="true" updatable="true">
				<html:options collection="owners" property="organization" labelProperty="name"/>
			</july:select>
        </td>
    </tr>

    <july:separator/>

    <tr>
        <td class="text"><july:reqmark><bean:message key="label.dismantlingp.blanknumber"/>:</july:reqmark></td>
        <td>
           <%-- <july:string property="blankindexFrm" size="15" insertable="true" updatable="true" /> --%>
           <html:hidden property="blankindexFrm" value="<%=mockIndex%>" />
           <july:string property="blanknumber" size="15" insertable="true" updatable="true" />
        </td>
    </tr>
    
    <july:separator/>

    <tr>
        <td class="text"><july:reqmark><bean:message key="label.dismantlingp.date"/>:</july:reqmark></td>
        <td>
			<july:date property="blankdatestr" styleId="blankdatestrctl" size="25" insertable="true" updatable="true" />
        </td>
    </tr>

    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.dismantlingp.position"/>:</july:reqmark></td>
        <td>
			<july:string property="positioncode" styleId="positioncode" size="5" insertable="true" updatable="true" />
			<july:lookupbutton action="/ShowPositionLookupList.do" styleId="posl" fieldNames="positioncode;positionid;positionname;complectcode;complectname" newWindowName="poslookup" insertable="true" updatable="true" />
			<july:string size="10" property="positionid" styleId="positionid" insertable="false" updatable="false" />
			<july:string size="25" property="positionname" styleId="positionname" insertable="false" updatable="false" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.dismantlingp.complect"/>:</july:reqmark></td>
        <td>
			<html:hidden property="complectcode"/>
			<july:string size="35" property="complectname" styleId="complectname" insertable="false" updatable="false" />
			<july:lookupbutton action="/ShowComplectLookupList.do" styleId="coml" fieldNames="complectcode;complectname" newWindowName="poslookup" insertable="true" updatable="true" onclick="set_opt_params_coml('?position='+document.all.positioncode.value)"/>
        </td>
    </tr>

    <july:separator/>

	<tr>
		<td class="text"><july:reqmark><bean:message key="label.dismantlingp.disassembler"/>:</july:reqmark></td>
		<td>
			<july:radio insertable="true" updatable="true" property="type" value="P" onclick="switchFilter();" styleClass="text"/>&nbsp;<bean:message key="label.dismantlingp.provider"/>&nbsp;&nbsp;&nbsp;&nbsp;
			<july:radio insertable="true" updatable="true" property="type" value="W" onclick="switchFilter();" styleClass="text"/>&nbsp;<bean:message key="label.dismantlingp.worker"/>
		</td>
	</tr>
    
    <july:separator/>

    <tr>
        <td class="text">&nbsp;&nbsp;&nbsp;&nbsp;<july:reqmark><bean:message key="label.dismantlingp.provider"/>:</july:reqmark></td>
        <td>
			<july:string property="providercode" styleId="providercode" size="5" insertable="true" updatable="true" />
			<july:lookupbutton action="/ShowOrganizationLookupList.do" styleId="provl" fieldNames="providercode;providername" newWindowName="organizationlookup"  insertable="true" updatable="true" onclick="set_opt_params_provl('?selisprovider=true&selisrenter=false&selissupplier=false');"/>
			<july:string size="35" property="providername" styleId="providername" insertable="false" updatable="false" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text">&nbsp;&nbsp;&nbsp;&nbsp;<july:reqmark><bean:message key="label.dismantlingp.insuranceman"/></july:reqmark>:</td>
        <td>
			<july:string size="35" property="insuranseMan" insertable="true" updatable="true" />
        </td>
    </tr>

    <july:separator/>

    <tr>
        <td class="text">&nbsp;&nbsp;&nbsp;&nbsp;<july:reqmark><bean:message key="label.dismantlingp.worker"/>:</july:reqmark></td>
        <td nowrap>
			<july:string property="workercode" styleId="workercode" size="5" insertable="true" updatable="true" />
			<july:lookupbutton action="/ShowWorkerLookupList.do" styleId="work1l" fieldNames="workercode;workername;workertitle" newWindowName="workerlookup"  insertable="true" updatable="true" />
			<july:string size="25" property="workername" styleId="workername" insertable="false" updatable="false" />
			<july:string size="20" property="workertitle" styleId="workertitle" insertable="false" updatable="false" />
        </td>
    </tr>
    
    <july:separator/>
<%if(AppUtils.isNewInventory()) {%>
<tr>
	<td class="text"><bean:message key="label.dismantlingp.transferto"/>:</td>
	<td>
		<july:checkbox property="transfer" insertable="true" updatable="true" value="true" onclick="switchStorage();"/>
<%if(frm.getUseStorageCombo()) {%>
   		<july:select collection="storages" property="storage" insertable="true" updatable="true" style="width:400;">
			<html:options collection="storages" property="storageplace" labelProperty="name"/>
		</july:select>
<%} else {%>
		<july:string property="storage" styleId="storage" size="5" insertable="true" updatable="true"/>
		<july:lookupbutton action="/ShowStorageLookupList.do" styleId="storl" fieldNames="storage;storagename" newWindowName="storagelookup"  insertable="true" updatable="true"/>
		<july:string size="35" property="storagename" styleId="storagename" insertable="false" updatable="false" />
<%}%>
	</td>
</tr>

<%-- 
<!-- BEE00001159 -->

<july:separator/>
<tr>
	<td class="text"><bean:message key="label.dismantlingp.move_to_complect"/>:</td>
	<td>
		<july:checkbox property="moveToComplect" insertable="true" updatable="true" value="true" onclick="switchMoveToPosition();"/>
	</td>
</tr>
<july:separator/>
<tr>
    <td class="text">&nbsp;&nbsp;&nbsp;&nbsp;<bean:message key="label.dismantlingp.position"/>:</td>
	<td>
			<july:string property="moveToPositionCode" styleId="moveToPositionCode" size="5" insertable="true" updatable="true" />
			<july:lookupbutton action="/ShowPositionLookupList.do" styleId="moveToPosl" fieldNames="moveToPositionCode;moveToPositionid;moveToPositionname;moveToComplectCode;moveToComplectname" newWindowName="poslookup" insertable="true" updatable="true" />
			<july:string size="10" property="moveToPositionid" styleId="moveToPositionid" insertable="false" updatable="false" />
			<july:string size="25" property="moveToPositionname" styleId="moveToPositionname" insertable="false" updatable="false" />
	</td>
</tr>
<july:separator/>
<tr>
    <td class="text">&nbsp;&nbsp;&nbsp;&nbsp;<bean:message key="label.dismantlingp.complect"/>:</td>
	<td>
			<html:hidden property="moveToComplectCode"/>
			<july:string size="35" property="moveToComplectname" styleId="moveToComplectname" insertable="false" updatable="false" />
			<july:lookupbutton action="/ShowComplectLookupList.do" styleId="moveToComl" fieldNames="moveToComplectCode;moveToComplectname" newWindowName="poslookup" insertable="true" updatable="true" onclick="set_opt_params_coml('?position='+document.all.moveToPositionCode.value)"/>
	</td>
</tr>

<!-- BEE00001159 -->
--%>

<july:separator/>
<tr>
	<td class="text"></td>
	<td>
		<july:checkbox property="unmountblocks" insertable="true" updatable="true" value="true" onclick="switchStorage();"/>
		<bean:message key="label.dismantlingp.unmountblocks"/>
	</td>
</tr>
<july:separator/>
<%}%>
<tr>
	<td class="text"><bean:message key="label.dismantlingp.worker2"/>:</td>
	<td nowrap>
		<july:string property="worker2code" styleId="worker2code" size="5" insertable="true" updatable="true" />
		<july:lookupbutton action="/ShowWorkerLookupList.do" styleId="work2l" fieldNames="worker2code;worker2name;worker2title" newWindowName="workerlookup"  insertable="true" updatable="true" />
		<july:string size="25" property="worker2name" styleId="worker2name" insertable="false" updatable="false" />
		<july:string size="20" property="worker2title" styleId="worker2title" insertable="false" updatable="false" />
	</td>
</tr>
<july:separator/>
<tr>
	<td class="text"><bean:message key="label.dismantlingp.storageman"/>:</td>
        <td nowrap>
		<july:string property="storagemancode" styleId="storagemancode" size="5" insertable="true" updatable="true" />
		<july:lookupbutton action="/ShowWorkerLookupList.do" styleId="smanl" fieldNames="storagemancode;storagemanname;storagemantitle" newWindowName="workerlookup"  insertable="true" updatable="true" />
		<july:string size="25" property="storagemanname" styleId="storagemanname" insertable="false" updatable="false" />
		<july:string size="20" property="storagemantitle" styleId="storagemantitle" insertable="false" updatable="false" />
	</td>
</tr>
<july:separator/>
<tr>
	<td class="text"><bean:message key="label.dismantlingp.state"/>:</td>
	<td>
		<%if("1".equals(frm.getDState())) {%><bean:message key="label.state.entering"/><%} else {%><bean:message key="label.state.calculated"/><%}%>
        </td>
</tr>
<july:separator/>
<july:formbuttons>
<%if(showpositions) {%>
<%--
<A href='javascript:printWord(<%=docCode%>)'><img 
	src="/images/print.gif" border=0 alt='Напечатать акт'></A>
--%>
		<july:wordEditSlave masterStyleId='<%= masterTagId %>' styleId='<%= "demountForm02_" + theDocCode %>' 
		url='<%= "reports/dassactp.jsp?prompt1=" + theDocCode %>' 
			uploadurl=''
			updatable='false'
		documentid='<%= theDocCode %>'><IMG SRC="/images/docword.gif" border="0" alt='Напечатать акт'></july:wordEditSlave>
<%}%>
&nbsp;&nbsp;
<%if(("View".equals(frm.getAction()) || "Edit".equals(frm.getAction())) && !frm.getIsautodoc()){%>
	<%if("1".equals(frm.getDState())) {%>
		<input type="image" name="submit" src="/images/calculate.gif" onclick="document.all.action.value='Edit';document.all.processState.value='P';return checkPosted();" title="Обсчёт">
	<%} else {%>
		<html:link page="/ProcessDemount.do?action=Edit&processState=C" paramId="doc" paramName="Demount" paramProperty="doc" paramScope="session" onclick="return checkPosted();"><img src="/images/calculates.gif" border=0 alt="Снять обсчёт"></html:link>
	<%}%>
<%}%>
</july:formbuttons>
<%if(showpositions) {%>
<july:separator/>
<tr class="title">
	<td colspan="2" class="title">
	<table cellpadding=0 cellspacing=0 width=100% border=0 class="main">
	<tr>
		<td><nobr>
			<%if(changable) {%><july:addbutton page="/EditDemountItem.do?action=Add" alttext="label.dassactpos.add" onclick="return checkPosted();"/><%}%>
			<%if(changable) {%><html:link page="/DemountFFDB.do?action=Add" paramId="document" paramName="Demount" paramProperty="doc" paramScope="session" onclick="return checkPosted();"><img src="/images/loaddb.gif" border="0" alt="Создать позиции по состоянию базы данных"></html:link><%}%>
		</nobr></td>
		<td class="title" align="right"><bean:message key="label.dismantlingp.positions"/></td>
	</tr>
	</table>
	</td>
</tr>
<july:separator/>
<tr><td colspan="2" style="padding:0px;">
	<table class="main">
	<tr class="title">
		<td class="title">&nbsp;</td>
		<july:headercolumn key="label.dismantlingp.numpp" colType="number"/>
		<july:headercolumn key="label.dismantlingp.name" colType="string"/>
		<july:headercolumn key="label.dismantlingp.qty.short" colType="string"/>
		<july:headercolumn key="label.dismantlingp.price" colType="string"/>
		<july:headercolumn key="label.dismantlingp.sum" colType="string"/>
		<july:headercolumn key="label.dismantlingp.invnum" colType="string"/>
		<%if(changable) {%><td class="title">&nbsp;</td><%}%>
	</tr>

	<logic:iterate id="it" name="Demount" property="documentItems" type="com.hps.july.cdbc.lib.CDBCRowObject">
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
	%>
	<tr class="normal" onMouseOver="className='select';" onMouseOut="className='normal';">
		<td class="link">
			<%if(changable && it.getColumn("agregate").asObject() == null) {%>
				<july:editbutton page="/EditDemountItem.do" action="Edit" paramId="docpos" paramName="docposition" paramScope="page" alttext="label.dassactpos.edit"/>
			<%} else {%>
				<july:editbutton page="/EditDemountItem.do" action="View" paramId="docpos" paramName="docposition" paramScope="page" alttext="label.dassactpos.view"/>
			<%}%>
		</td>
		<td class="number" align="right"><july:stringwrite name="it" property="order"/></td>
		<td class="text">
			<july:stringwrite name="it" property="name"/>
			<july:stringwrite name="it" property="model"/>
			<july:stringwrite name="it" property="configuration"/>
		</td>
		<td class="number" align="right"><july:numberwrite name="it" property="qty"/> <july:stringwrite name="it" property="unitname"/></td>
		<td class="number" align="right"><july:numberwrite name="it" property="price" fractdigits="2"/></td>
		<td class="number" align="right"><july:numberwrite name="it" property="summ" fractdigits="2"/></td>
		<td class="text"><july:stringwrite name="it" property="invnum"/></td>
		<%if(changable) {%>
		<td class="link">
			<%if(it.getColumn("agregate").asObject() == null) {%><july:delbutton page="/EditDemountItem.do?action=Delete" paramId="docpos" paramName="docposition" paramScope="page" /><%}%>
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
		<td><nobr>
			<%if(changable) {%><july:addbutton page="/EditDemountItem.do?action=Add" alttext="label.dassactpos.add" onclick="return checkPosted();"/><%}%>
			<%if(changable) {%><html:link page="/DemountFFDB.do?action=Add" paramId="document" paramName="Demount" paramProperty="doc" paramScope="session" onclick="return checkPosted();"><img src="/images/loaddb.gif" border="0" alt="Создать позиции по состоянию базы данных"></html:link><%}%>
		</nobr></td>
		<td class="title" align="right">&nbsp;</td>
	</tr>
	</table>
	</td>
</tr>
<%}%>    
</table>

<script language="javascript">
	switchFilter();
<%if(AppUtils.isNewInventory()) {%>
	switchStorage();
<%}%>
	// BEE00001159
	// switchMoveToPosition();
</script>

</july:editform>

