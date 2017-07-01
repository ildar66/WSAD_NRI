<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import="com.hps.july.util.AppUtils"%>
<%@ page import="org.apache.struts.util.*"%>
<%@ page import="com.hps.july.inventory.formbean.*"%>

<%
	String masterTagId = "changeSFormWordEditMasterTagId";
%>
<july:wordEditMaster styleId='<%= masterTagId %>' >
</july:wordEditMaster>

<july:editform action="/ProcessDAssactB.do">
<bean:define id="docCode" name="DAssactBForm" property="document" scope="session" type="java.lang.Integer"/>
<july:inventorycalcerrors document="<%=docCode%>"/>
<script language="javascript" src="/action.js"></script>
<%
	DAssactBForm frm = (DAssactBForm)request.getSession().getAttribute("DAssactBForm");
	boolean showpositions = "View".equals(frm.getAction()) || "Edit".equals(frm.getAction());
	boolean changable = "1".equals(frm.getDState()) && showpositions;

	boolean browseBySerial = frm.isBrowseBySerial();
	String theDocCode = "";
	if (showpositions) {
		theDocCode = frm.getDocumentId().toString(); 
	}
	String mockIndex = frm.MOCK_DOC_ID;
%>

<script language="javascript">
function switchLookup(itemname,lookupname,disabled) {
<% if(!"View".equals(frm.getAction()) && !"Delete".equals(frm.getAction())) {%>
	if(disabled) {
		document.all[itemname].className = 'editkoddisabled';
		document.all[itemname].disabled = true;
		document.all[itemname].readonly = true;
		document.all['lookupbtn_'+lookupname+'l'].disabled = true;
		document.all['lookupimg_'+lookupname+'l'].src='/images/lookup_disabled.gif';
	} else {
		document.all[itemname].className = 'editkod';
		document.all[itemname].disabled = false;
		document.all[itemname].readonly = false;
		document.all['lookupbtn_'+lookupname+'l'].disabled = false;
		document.all['lookupimg_'+lookupname+'l'].src='/images/lookup.gif';
	}
<% } %>
}
function switchStorage() {
<%if(frm.getUseStorageCombo()) {%>
	if(document.all.transfer[0].checked) {
		document.all.storagecode.className='edit';
	} else {
		document.all.storagecode.className='editdisabled';
	}
	document.all.storagecode.disabled=!document.all.transfer[0].checked;
<%} else {%>
	switchLookup('storagecode','stor',!document.all.transfer[0].checked);
<%}%>
}
function printWord(prompt1){
	//Печать актов:
	window.location.href='reports/dassactbp.jsp?prompt1='+prompt1;
}
</script>

<html:hidden property="document" />
<input type="hidden" name="processState" value="">

<table class="main">    
    
    <july:separator/>
    
	<july:formbuttons>
	<%if(showpositions){%>
	<%--
	<A href='javascript:printWord(<%=docCode%>)'><img 
	src="/images/print.gif" border=0 alt='Напечатать акт'></A>
	--%>
		<july:wordEditSlave masterStyleId='<%= masterTagId %>' styleId='<%= "dassactBForm_" + theDocCode %>' 
		url='<%= "reports/dassactbp.jsp?prompt1=" + theDocCode %>' 
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
			<html:link page="/ProcessDAssactB.do?action=Edit&processState=C" paramId="document" paramName="DAssactBForm" paramProperty="document" paramScope="session" onclick="return checkPosted();"><img src="/images/calculates.gif" border=0 alt="Снять обсчёт"></html:link>
		<%}%>
	<%}%>
	</july:formbuttons>

	<july:separator/>

    <tr>
        <td class="title" colspan="2"><july:actionalert/></td>
    </tr>

    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.dassactb.owner"/>:</july:reqmark></td>
        <td>
			<july:select collection="owners" property="ownercode" insertable="true" updatable="true">
				<html:options collection="owners" property="organization" labelProperty="name"/>
			</july:select>
        </td>
    </tr>

    <july:separator/>

    <tr>
        <td class="text"><july:reqmark><bean:message key="label.dassactb.position"/>:</july:reqmark></td>
        <td>
			<july:string property="positioncode" styleId="positioncode" size="5" insertable="true" updatable="true" />
			<july:lookupbutton action="/ShowPositionLookupList.do" styleId="posl" fieldNames="positioncode;positionid;positionname;complectcode;complectname;agrcode;agregateserial;agregatname" newWindowName="poslookup" insertable="true" updatable="true" />
			<july:string size="10" property="positionid" styleId="positionid" insertable="false" updatable="false" />
			<july:string size="25" property="positionname" styleId="positionname" insertable="false" updatable="false" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.dassactb.complect"/>:</july:reqmark></td>
        <td>
			<html:hidden property="complectcode"/>
<!-- <july:string property="complectcode" styleId="complectcode" size="5" insertable="false" updatable="false" /> -->
			<july:string size="35" property="complectname" styleId="complectname" insertable="false" updatable="false" />
			<july:lookupbutton action="/ShowComplectLookupList.do" styleId="coml" fieldNames="complectcode;complectname" newWindowName="poslookup" insertable="true" updatable="true" onclick="if(isEmpty(document.all.positioncode.value)) { alert('Для выбора комплекта оборудования необходимо указать позицию'); return false; } else {set_opt_params_coml('?position='+document.all.positioncode.value);}"/>
        </td>
    </tr>

    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.dassactb.num"/>:</july:reqmark></td>
        <td>
           <%-- <july:string property="blankindexFrm" size="15" insertable="true" updatable="true" /> --%>
           <html:hidden property="blankindexFrm" value="<%=mockIndex%>" />
           <july:string property="blanknumber" size="15" insertable="true" updatable="true" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.dassactb.date"/>:</july:reqmark></td>
        <td>
          <july:date property="blankdateFrm" size="25" insertable="true" updatable="true" />
        </td>
    </tr>
    
    <july:separator/>

	<tr>
	<td class="text"><july:reqmark>Оборудование:</july:reqmark></td>
        <td>
			<july:string size="5" property="agregatcode" styleId="agregatcode" insertable="true" updatable="true" />

			<%if(!browseBySerial){%>
				<july:lookupbutton action="/ShowResourceLookupList.do" styleId="resl" fieldNames="agregatcode;agregatmodel;agregatname" newWindowName="resourcelookup" insertable="true" updatable="true"/>
			<%} else {
				String s = "/ShowResourceLookupBySerialList.do?snumber=";
				%>
				<july:lookupbutton action="<%= s + frm.getAgregateserial() %>" styleId="resl" fieldNames="agregatcode;agregatmodel;agregatname" newWindowName="resourcelookup" insertable="true" updatable="true" image="lookup_red"/>
			<%}%>
			
			<html:text size="25" style="FONT-FAMILY: Verdana,Arial; FONT-SIZE: 10pt; background-color: DCDCDC;" property="agregatmodel" readonly="true"/>			
			<html:text size="25" style="FONT-FAMILY: Verdana,Arial; FONT-SIZE: 10pt; background-color: DCDCDC;" property="agregatname" readonly="true"/>
		</td>
	</tr>

    <july:separator/>

<script language="javascript" src="/wscheck.js"></script>

<tr>
	<td COLSPAN="2"><B><bean:message key="label.allserialsagr"/></B></TD>
</TR>

<tr>
	<TD>&nbsp;&nbsp;<SPAN title='<bean:message key="label.allserials.manuf.help"/>'><bean:message key="label.allserials.manuf"/>&nbsp;<IMG SRC="/images/help-little.gif" BORDER="0"></SPAN></TD>
	<td>
<script language="javascript">function isEmpty(v) { return v == null || v == ''; }</script>
            <INPUT TYPE="HIDDEN" name="agrcode" ID="agrcode">
            <INPUT TYPE="HIDDEN" name="temp" ID="temp">
			<july:string property="agregateserial" styleId="agregateserial" size="15" insertable="true" updatable="true" />
			<july:lookupbutton action="/ShowCardRLookupList.do" styleId="srl" onclick="if(isEmpty(document.all.complectcode.value)){ alert('Для выбора устройства нужно указать комплект оборудования!'); return false;} else {set_opt_params_srl('?pagetype=2&storage='+document.all.complectcode.value+'&resource=&owner=&agregate=&brokentype=1&documentkey=');}" fieldNames="temp;agregatname;temp;temp;agregateserial;temp;temp;temp;temp;temp;temp;temp" newWindowName="equiplookup" insertable="true" updatable="true"/>
			<%--<july:string size="25" property="agregatname" styleId="agregatname" insertable="false" updatable="false" />--%>
        </td>
</tr>
	</td>
</tr>
<tr>
	<TD>&nbsp;&nbsp;<SPAN title='<bean:message key="label.allserials.invent.help"/>'><bean:message key="label.allserials.invent"/>&nbsp;<IMG SRC="/images/help-little.gif" BORDER="0"></SPAN></TD>
	<td>
		    <july:string property="inventserial" size="15" insertable="false" updatable="false" />
	</td>
</tr>
<tr>
	<TD>&nbsp;&nbsp;<SPAN title='<bean:message key="label.allserials.local.help"/>'><bean:message key="label.allserials.local"/>&nbsp;<IMG SRC="/images/help-little.gif" BORDER="0"></SPAN></TD>
	<td>
		    <july:string property="localserial" size="15" insertable="false" updatable="false" />
	</td>
</tr>

    <july:separator/>
    
    <logic:equal name="DAssactBForm" property="action" value="View">
    
        <tr>
            <td class="text"><bean:message key="label.dassactb.oldconfig"/>:</td>
            <td>
               <july:string property="oldconfig" size="25" insertable="false" updatable="false" />
            </td>
        </tr>
        
        <july:separator/>
        
        <tr>
            <td class="text"><bean:message key="label.dassactb.newconfig"/>:</td>
            <td>
               <july:string property="newconfig" size="25" insertable="true" updatable="true" />
            </td>
        </tr>
    
    <july:separator/>
        
    </logic:equal>
<%if(AppUtils.isNewInventory()) {%>
    <tr>
        <td class="text"><bean:message key="label.dassactb.transferto"/>:</td>
        <td>
		<july:checkbox property="transfer" insertable="true" updatable="true" value="true" onclick="switchStorage();"/>
		&nbsp;&nbsp;&nbsp;
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
<%}%>
    <tr>
        <td class="text" colspan="2"><bean:message key="label.dassactb.mountgroup"/>:</td>
    </tr>
    <tr>
        <td class="text">&nbsp;&nbsp;&nbsp;<july:reqmark><bean:message key="label.dassactb.stworker"/>:</july:reqmark></td>
        <td>
		<july:string property="workercodeFrm" styleId="workercode" size="5" insertable="true" updatable="true" />
		<july:lookupbutton action="/ShowWorkerLookupList.do" styleId="fwl" fieldNames="workercode;workername;workertitle" newWindowName="workerlookup"  insertable="true" updatable="true" />
		
		<html:text size="25" style="FONT-FAMILY: Verdana,Arial; FONT-SIZE: 10pt; background-color: DCDCDC;" property="workername" readonly="true"/>			
		<html:text size="25" style="FONT-FAMILY: Verdana,Arial; FONT-SIZE: 10pt; background-color: DCDCDC;" property="workertitle" readonly="true"/>
        </td>
    </tr>
    <tr>
        <td class="text">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<bean:message key="label.dassactb.monter"/>:</td>
        <td>
		<july:string property="montercodeFrm" styleId="montercode" size="5" insertable="true" updatable="true" />
		<july:lookupbutton action="/ShowWorkerLookupList.do" styleId="workl" fieldNames="montercode;montername;montertitle" newWindowName="workerlookup"  insertable="true" updatable="true" />
		
		<html:text size="25" style="FONT-FAMILY: Verdana,Arial; FONT-SIZE: 10pt; background-color: DCDCDC;" property="montername" readonly="true"/>			
		<html:text size="25" style="FONT-FAMILY: Verdana,Arial; FONT-SIZE: 10pt; background-color: DCDCDC;" property="montertitle" readonly="true"/>
        </td>
    </tr>
    
<july:separator/>
<july:formbuttons>
<%if(showpositions){%>
<%--
<A href='javascript:printWord(<%=docCode%>)'><img 
	src="/images/print.gif" border=0 alt='Напечатать акт'></A>
--%>
		<july:wordEditSlave masterStyleId='<%= masterTagId %>' styleId='<%= "dassactBForm02_" + theDocCode %>' 
		url='<%= "reports/dassactbp.jsp?prompt1=" + theDocCode %>' 
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
		<html:link page="/ProcessDAssactB.do?action=Edit&processState=C" paramId="document" paramName="DAssactBForm" paramProperty="document" paramScope="session" onclick="return checkPosted();"><img src="/images/calculates.gif" border=0 alt="Снять обсчёт"></html:link>
	<%}%>
<%}%>
</july:formbuttons>
<%if(showpositions) {%>
<july:separator/>
<tr class="title">
	<td colspan="2" class="title">
	<table cellpadding=0 cellspacing=0 width=100% border=0 class="main">
	<tr>
		<td><nobr><%if(changable) {%><july:addbutton page="/EditDAssactposB.do?action=Add" alttext="label.dassactpos.add" onclick="return checkPosted();"/><%}%></nobr></td>
		<td class="title" align="right"><bean:message key="label.dassact.positions"/></td>
	</tr>
	</table>
	</td>
</tr>
<july:separator/>
<tr><td colspan="2" style="padding:0px;">
	<table class="main">
	<tr class="title">
		<td class="title">&nbsp;</td>
		<july:headercolumn key="label.num" colType="number"/>
		<july:headercolumn key="label.dassactposb.name" colType="string"/>
		<july:headercolumn key="label.dassactposb.qty.short" colType="string"/>
		<july:headercolumn key="label.dassactposb.price" colType="string"/>
		<july:headercolumn key="label.dassactposb.sum" colType="string"/>
		<july:headercolumn key="label.dassactposb.serial" colType="string"/>
		<%if(changable) {%><td class="title">&nbsp;</td><%}%>
	</tr>

	<logic:iterate id="it" name="DAssactBForm" property="listItems" type="com.hps.july.cdbc.lib.CDBCRowObject">
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
				<july:editbutton page="/EditDAssactposB.do" action="Edit" paramId="docpositionstr" paramName="docposition" paramScope="page" alttext="label.assactpos.edit"/>
			<%} else {%>
				<july:editbutton page="/EditDAssactposB.do" action="View" paramId="docpositionstr" paramName="docposition" paramScope="page" alttext="label.assactpos.edit"/>
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
			<%if(it.getColumn("agregate").asObject() == null) {%>
				<july:delbutton page="/EditDAssactposB.do?action=Delete" paramId="docpositionstr" paramName="docposition" paramScope="page" />
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
		<td><nobr><%if(changable) {%><july:addbutton page="/EditDAssactposB.do?action=Add" alttext="label.dassactpos.add" onclick="return checkPosted();"/><%}%></nobr></td>
		<td class="title" align="right">&nbsp;</td>
	</tr>
	</table>
	</td>
</tr>
<%}%>    
</table>
<script language="javascript">switchStorage();</script>
</july:editform>

