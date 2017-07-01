<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import="org.apache.struts.util.*"%>
<%@ page import="com.hps.july.inventory.formbean.*"%>

<july:editform action="/ProcessFault.do">
<bean:define id="docCode" name="FaultForm" property="document" scope="session" type="java.lang.Integer"/>
<july:inventorycalcerrors document="<%= docCode %>"/>
<script language="javascript" src="/action.js"></script>
<%
	FaultForm frm = (FaultForm)request.getSession().getAttribute("FaultForm");
	boolean showpositions = "View".equals(frm.getAction()) || "Edit".equals(frm.getAction());
	boolean changable = "1".equals(frm.getDState()) && !frm.getIsautodoc() && ("View".equals(frm.getAction()) || "Edit".equals(frm.getAction()));
	boolean browseBySerialMsn = frm.isBrowseBySerialMsn();
	boolean browseBySerialRsn = frm.isBrowseBySerialRsn();
	boolean browseBySerialD = frm.isBrowseBySerialD();
	String documentId = frm.getDocumentId().toString();
	String mockIndex = frm.MOCK_DOC_ID;
%>
<script language="javascript">
function switchLookup(itemname,lookupname,disabled) {
	if(document.all['action'].value == 'Add' || document.all['action'].value == 'Edit') {
	if(disabled) {
		FaultForm[itemname].className = 'editkoddisabled';
		FaultForm[itemname].disabled = true;
		FaultForm[itemname].readonly = true;
		document.all['lookupbtn_'+lookupname+'l'].disabled = true;
		document.all['lookupimg_'+lookupname+'l'].src='/images/lookup_disabled.gif';
	} else {
		FaultForm[itemname].className = 'editkod';
		FaultForm[itemname].disabled = false;
		FaultForm[itemname].readonly = false;
		document.all['lookupbtn_'+lookupname+'l'].disabled = false;
		document.all['lookupimg_'+lookupname+'l'].src='/images/lookup.gif';
	}
	}
}
function switchSerial(itemname,lookupname,disabled) {
	if(document.all['action'].value == 'Add' || document.all['action'].value == 'Edit') {
	if(disabled) {
		FaultForm[itemname].className = 'editdisabled';
		FaultForm[itemname].disabled = true;
		FaultForm[itemname].readonly = true;
		document.all['lookupbtn_'+lookupname+'l'].disabled = true;
		document.all['lookupimg_'+lookupname+'l'].src='/images/lookup_disabled.gif';
	} else {
		FaultForm[itemname].className = 'edit';
		FaultForm[itemname].disabled = false;
		FaultForm[itemname].readonly = false;
		document.all['lookupbtn_'+lookupname+'l'].disabled = false;
		document.all['lookupimg_'+lookupname+'l'].src='/images/lookup.gif';
	}
	}
}

function printExcel(prompt1){
	// window.location.href='reports/excelAssembReport.jsp?ass='+prompt1;
	// openDialog('reports/excelAssembReport.jsp?ass='+prompt1, "excelWindow", "top=1, left=1, width=1000, height=600, scrollbars=yes, resizable=yes, menu=yes");
	/*
	window.open('reports/excelAssembReport.jsp?ass='+prompt1, 
		'excelWindow', 
		'top=1, left=1, width=1000, height=600, scrollbars=yes, resizable=yes, menubar=yes, status=yes, titlebar=yes, toolbar=yes', 
		false);
	*/	
	window.open('reports/excelAssembReport_repaired02.jsp?ass='+prompt1, 
		'excelWindow', 
		'top=1, left=1, width=1000, height=600, scrollbars=yes, resizable=yes, menubar=yes, status=yes, titlebar=yes, toolbar=yes', 
		false);
}

</script>

<html:hidden property="document" />
<html:hidden property="warnProc"/>
<html:hidden property="expedition.string" />
<input type="hidden" name="processState" value="">

<input type="hidden" name="configuration" value="">
<input type="hidden" name="party" value="">
<input type="hidden" name="qtystr" value="">

<table class="main">
    
    <july:separator/>
    
<july:formbuttons>
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
		<html:link page="/ProcessFault.do?action=Edit&processState=C" paramId="document" paramName="FaultForm" paramProperty="document" paramScope="session" onclick="return checkPosted();"><img src="/images/calculates.gif" border=0 alt="Снять обсчёт"></html:link>
		<%--
		<july:exceledit styleId="excelAssembReport01" url='<%= "reports/excelAssembReport.jsp?ass=true"%>' uploadurl="" 
			documentid="<%=documentId%>" updatable="false"><img src="/images/print_plus.gif" border=0 alt="Акт монтажа"></july:exceledit>
		<july:exceledit styleId="excelDeassembReport01" url='<%= "reports/excelAssembReport.jsp?ass=false"%>' uploadurl="" 
			documentid="<%=documentId%>" updatable="false"><img src="/images/print_lose.gif" border=0 alt="Акт демонтажа"></july:exceledit>
		--%>	
		<A href='javascript:printExcel(true)'><img 
			src="/images/print_plus.gif" border=0 alt='Акт монтажа'></A>
		<A href='javascript:printExcel(false)'><img 
			src="/images/print_lose.gif" border=0 alt='Акт демонтажа'></A>
	<%}%>
<%}%>
</july:formbuttons>
    
    <july:separator/>

    <tr>
        <td class="title" colspan="2"><july:actionalert/></td>
    </tr>

    <july:separator/>

    <tr>
        <td class="text"><july:reqmark><bean:message key="label.fault.owner"/>:</july:reqmark></td>
        <td>
		<july:select collection="owners" property="owner.string" insertable="true" updatable="true">
			<html:options collection="owners" property="organization" labelProperty="name"/>
		</july:select>
        </td>
    </tr>

    <july:separator/>

    <tr>
        <td class="text"><july:reqmark><bean:message key="label.fault.num"/>:</july:reqmark></td>
        <td>
		<%-- <july:string property="blankindex.string" size="15" insertable="true" updatable="true" /> --%>
    	<html:hidden property="blankindex.string" value="<%=mockIndex%>" />
		<july:string property="blanknumber" size="15" insertable="true" updatable="true" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.fault.date"/>:</july:reqmark></td>
        <td>
		<july:date property="blankdate.string" styleId="blankdatestrctl" size="25" insertable="true" updatable="true" />
        </td>
    </tr>

    <july:separator/>

    <tr>
        <td class="text"><july:reqmark><bean:message key="label.fault.worker"/>:</july:reqmark></td>
        <td nowrap>
		<july:string property="worker.string" styleId="worker.string" size="5" insertable="true" updatable="true" />
		<july:lookupbutton action="/ShowWorkerLookupList.do?showdivision=true" styleId="work1l" fieldNames="worker.string;workername;workertitle;division.string;divisionname" newWindowName="workerlookup"  insertable="true" updatable="true" />
		<july:string size="20" property="workername" styleId="workername" insertable="false" updatable="false" />
		<july:string size="20" property="workertitle" styleId="workertitle" insertable="false" updatable="false" />
        </td>
    </tr>
    
    <july:separator/>

    <tr>
        <td class="text"><july:reqmark><bean:message key="label.fault.division"/>:</july:reqmark></td>
        <td>
		<july:string property="division.string" styleId="division.string" size="5" insertable="true" updatable="true" />
		<july:lookupbutton action="/ShowDivisionLookupList.do" styleId="divl" fieldNames="division.string;divisionname" newWindowName="divisionlookup"  insertable="true" updatable="true"/>
		<july:string size="30" property="divisionname" styleId="divisionname" insertable="false" updatable="false" />
        </td>
    </tr>
    
    <july:separator/>

    <tr>
        <td class="text" colspan="2">
		<july:reqmark><bean:message key="label.fault.where"/>:</july:reqmark>&nbsp;&nbsp;&nbsp;
		<july:radio property="placetype" value="P" insertable="true" updatable="true" styleClass="text" onclick="switchWhere();"/>&nbsp;<bean:message key="label.fault.where.p"/>
		<july:radio property="placetype" value="S" insertable="true" updatable="true" styleClass="text" onclick="switchWhere();"/>&nbsp;<bean:message key="label.fault.where.s"/>
		<july:radio property="placetype" value="W" insertable="true" updatable="true" styleClass="text" onclick="switchWhere();"/>&nbsp;<bean:message key="label.fault.where.w"/>
	</td>
    </tr>

    <tr>
        <td class="text">&nbsp;&nbsp;&nbsp;&nbsp;<july:reqmark><bean:message key="label.fault.position"/></july:reqmark>:</td>
        <td>
		<july:string property="position.string" styleId="position.string" size="5" insertable="true" updatable="true" />
		<july:lookupbutton action="/ShowPositionLookupList.do" styleId="posl" fieldNames="position.string;positionid;positionname;complect.string;complectname" newWindowName="positionlookup"  insertable="true" updatable="true" />
		<july:string size="10" property="positionid" styleId="positionid" insertable="false" updatable="false" />
		<july:string size="25" property="positionname" styleId="positionname" insertable="false" updatable="false" />
        </td>
    </tr>
    
    <tr>
	<td class="text">&nbsp;&nbsp;&nbsp;&nbsp;<july:reqmark><bean:message key="label.fault.complect"/></july:reqmark>:</td>
	<td>
		<html:hidden property="complect.string"/>
<!--		<july:string property="complect.string" styleId="complect.string" size="5" insertable="true" updatable="true" /> -->
		<july:string size="35" property="complectname" styleId="complectname" insertable="false" updatable="false" />
		<july:lookupbutton action="/ShowComplectLookupList.do" styleId="coml" fieldNames="complect.string;complectname" newWindowName="poslookup" insertable="true" updatable="true" onclick="set_opt_params_coml('?position='+document.all['position.string'].value)"/>
	</td>
    </tr>
    
    <tr>
        <td class="text">&nbsp;&nbsp;&nbsp;&nbsp;<july:reqmark><bean:message key="label.fault.storage"/></july:reqmark>:</td>
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
	<td class="text"><july:reqmark>Оборудование:</july:reqmark></td>
        <td>
			<july:string size="5" property="devicecode" styleId="device" insertable="true" updatable="true" />

			<%if(!browseBySerialD){%>
				<july:lookupbutton action="/ShowResourceLookupList.do" styleId="dresl" fieldNames="devicecode;devicemodel;devicename" newWindowName="resourcelookup" insertable="true" updatable="true"/>
			<%} else {
				String s = "/ShowResourceLookupBySerialList.do?snumber=";
				%>
				<july:lookupbutton action="<%= s + frm.getDeviceserial() %>" styleId="dresl" fieldNames="devicecode;devicemodel;devicename" newWindowName="resourcelookup" insertable="true" updatable="true" image="lookup_red"/>
			<%}%>

			<july:string size="25" property="devicemodel" styleId="devicemodel" insertable="false" updatable="false" />
			<july:string size="25" property="devicename" styleId="devicename" insertable="false" updatable="false" />
		</td>
	</tr>

    <tr>
        <td class="text"><bean:message key="label.fault.equipment"/>:</td>
        <td>
		<input type="hidden" name="agrcode" id="agrcode">
		<input type="hidden" name="temp" id="temp">
		<html:hidden property="device"/>
		<july:string property="deviceserial" styleId="deviceserial" size="25" insertable="true" updatable="true" />
		<july:lookupbutton action="/ShowCardRLookupList.do" styleId="srl" onclick="if(!equipmentOnClick()) {return false; }" fieldNames="device;devicename;temp;temp;deviceserial;temp;temp;temp;temp;temp;temp;temp" newWindowName="equiplookup" insertable="true" updatable="true"/>
		<%--<july:string size="25" property="devicename" styleId="devicename" insertable="false" updatable="false" />--%>
        </td>
    </tr>

    <july:separator/>

    <tr>
	<td class="text" colspan="2"><july:reqmark><bean:message key="label.fault.malformresource"/>:</july:reqmark></td>
    </tr>

    <tr>
	<td class="text">&nbsp;&nbsp;&nbsp;&nbsp;<july:reqmark><bean:message key="label.fault.resource"/></july:reqmark>:</td>
	<td>
		<july:string size="5" property="mres.string" styleId="mres.string" insertable="true" updatable="true" />
	
			<%if(!browseBySerialMsn){%>
				<july:lookupbutton action="/ShowResourceLookupList.do" styleId="mresl" fieldNames="mres.string;mresmodel;mresname" newWindowName="resourcelookup" insertable="true" updatable="true"/>
			<%} else {
				String s2 = "/ShowResourceLookupBySerialList.do?snumber=";
				%>
				<july:lookupbutton action="<%= s2 + frm.getMsn() %>" styleId="mresl" fieldNames="mres.string;mresmodel;mresname" newWindowName="resourcelookup" insertable="true" updatable="true" image="lookup_red"/>
			<%}%>

		<july:string size="20" property="mresmodel" styleId="mresmodel" insertable="false" updatable="false" />
		<july:string size="20" property="mresname" styleId="mresname" insertable="false" updatable="false" />
	</td>
    </tr>
    
    <tr>
	<td class="text">&nbsp;&nbsp;&nbsp;&nbsp;<july:reqmark><bean:message key="label.fault.spnum"/></july:reqmark>:</td>
	<td>	
		<july:string property="msn" size="15" insertable="true" updatable="true" />
		<july:lookupbutton action="/ShowCardRLookupList.do" styleId="msrl" onclick="mresOnClick();" fieldNames="mres.string;mresname;mresmodel;configuration;msn;party;qtystr;temp;temp;mms;temp;temp" newWindowName="seriallookup" insertable="true" updatable="true"/>&nbsp;
	</td>
    </tr>

    <tr>
	<td class="text">&nbsp;&nbsp;&nbsp;&nbsp;<bean:message key="label.manufserial"/>:</td>
	<td>
		<july:string property="mms" size="15" insertable="false" updatable="false" />
	</td>
    </tr>
    
    <tr>
	<td class="text" valign="top">&nbsp;&nbsp;&nbsp;&nbsp;<bean:message key="label.fault.notes"/>:</td>
	<td>
		<july:textarea cols="50" rows="3" property="comments" insertable="true" updatable="true"/>
	</td>
    </tr>
    
    <july:separator/>

    <tr>
	<td class="text" colspan="2"><bean:message key="label.fault.replacedbyresource"/>:</td>
    </tr>

    <tr>
	<td class="text">&nbsp;&nbsp;&nbsp;&nbsp;<bean:message key="label.fault.resource"/>:</td>
	<td>
		<july:string size="5" property="rres.string" styleId="rres.string" insertable="true" updatable="true" />
			
			<%if(!browseBySerialRsn){%>
				<july:lookupbutton action="/ShowResourceLookupList.do" styleId="sresl" fieldNames="rres.string;rresmodel;rresname" newWindowName="resourcelookup" insertable="true" updatable="true"/>
			<%} else {
				String s2 = "/ShowResourceLookupBySerialList.do?snumber=";
				%>
				<july:lookupbutton action="<%= s2 + frm.getRsn() %>" styleId="sresl" fieldNames="rres.string;rresmodel;rresname" newWindowName="resourcelookup" insertable="true" updatable="true" image="lookup_red"/>
			<%}%>

		<july:string size="20" property="rresmodel" styleId="rresmodel" insertable="false" updatable="false" />
		<july:string size="20" property="rresname" styleId="rresname" insertable="false" updatable="false" />
	</td>
    </tr>
    
    <tr>
	<td class="text">&nbsp;&nbsp;&nbsp;&nbsp;<bean:message key="label.fault.spnum"/>:</td>
	<td>	
		<july:string property="rsn" size="15" insertable="true" updatable="true" />
		<july:lookupbutton action="/ShowCardLookupList.do" styleId="rsrl" onclick="rresOnClick();" fieldNames="rres.string;rresname;rresmodel;temp;rsn;temp;temp;temp;temp;rms;temp;temp" newWindowName="seriallookup" insertable="true" updatable="true"/>&nbsp;
	</td>
    </tr>

    <tr>
	<td class="text">&nbsp;&nbsp;&nbsp;&nbsp;<bean:message key="label.manufserial"/>:</td>
	<td>
		<july:string property="rms" size="15" insertable="false" updatable="false" />
	</td>
    </tr>
    
    <july:separator/>

    <%--<tr>
        <td class="text"><bean:message key="label.fault.state"/>:</td>
        <td>
	   <logic:equal name="FaultForm" property="dState" value="1">
	           <bean:message key="label.state.entering"/>
           </logic:equal>
	   <logic:equal name="FaultForm" property="dState" value="2">
	           <bean:message key="label.state.calculated"/>
           </logic:equal>
        </td>
    </tr>--%>
    
   <%-- <july:separator/>  --%>
    
<july:formbuttons>
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
		<html:link page="/ProcessFault.do?action=Edit&processState=C" paramId="document" paramName="FaultForm" paramProperty="document" paramScope="session" onclick="return checkPosted();"><img src="/images/calculates.gif" border=0 alt="Снять обсчёт"></html:link>
		<%--
		<july:exceledit styleId="excelAssembReport02" url='<%= "reports/excelAssembReport.jsp?ass=true"%>' uploadurl="" 
			documentid="<%=documentId%>" updatable="false"><img src="/images/print_plus.gif" border=0 alt="Акт монтажа"></july:exceledit>
		<july:exceledit styleId="excelDeassembReport02" url='<%= "reports/excelAssembReport.jsp?ass=false"%>' uploadurl="" 
			documentid="<%=documentId%>" updatable="false"><img src="/images/print_lose.gif" border=0 alt="Акт демонтажа"></july:exceledit>
		--%>	
		<A href='javascript:printExcel(true)'><img 
			src="/images/print_plus.gif" border=0 alt='Акт монтажа'></A>
		<A href='javascript:printExcel(false)'><img 
			src="/images/print_lose.gif" border=0 alt='Акт демонтажа'></A>
	<%}%>
<%}%>
</july:formbuttons>
    
    <july:separator/>
    
</table>

<script language="javascript">

function isEmpty(v) {
	return v == null || v == '';
}

function equipmentOnClick() {
	b = true;
	if(FaultForm['placetype'][0].checked) {
		if(isEmpty(document.all['complect.string'].value)) {
			alert('Для выбора устройства нужно указать комплект оборудования!');
			b = false;
		} else {
			set_opt_params_srl(
				'?pagetype=2'+
				'&storage='+document.all['complect.string'].value+
				'&resource='+
				'&owner='+//document.all['owner.string'].value+
				'&agregate='
			);
		}
	} else if(FaultForm['placetype'][1].checked) {
		if(isEmpty(document.all['storagecode'].value)) {
			alert('Для выбора устройства нужно указать склад!');
			b = false;
		} else {
			set_opt_params_srl(
				'?pagetype=2'+
				'&storage='+document.all['storagecode'].value+
				'&resource='+
				'&owner='+//document.all['owner.string'].value+
				'&agregate='
			);
		}
	} else if(FaultForm['placetype'][2].checked) {
//		set_opt_params_srl(
//			'?pagetype=2&worker='+document.all['worker.string'].value+
//			'&resource='+
//			'&owner='+document.all['owner.string'].value+
//			'&agregate='
//		);
		b = false;
	} else {
		set_opt_params_srl(
			'?storage=&resource=&owner=&agregate='
		);
	}
	return b;
}

function mresOnClick() {
	if(FaultForm['placetype'][0].checked) {
		set_opt_params_msrl(
			'?pagetype=2&storage='+document.all['complect.string'].value+
			'&owner='+
			'&resource='+document.all['mres.string'].value+
			'&agregate=&agregateserial='+document.all['deviceserial'].value+
			'&brokentype=1&documentkey='+document.all.document.value
		);
	} else if(FaultForm['placetype'][1].checked) {
		set_opt_params_msrl(
			'?pagetype=2&storage='+document.all['storagecode'].value+
			'&owner='+
			'&resource='+document.all['mres.string'].value+
			'&agregate=&agregateserial='+document.all['deviceserial'].value+
			'&brokentype=1&documentkey='+document.all.document.value
		);                                             
	} else if(FaultForm['placetype'][2].checked) {
		set_opt_params_msrl(
			'?pagetype=2&worker='+document.all['worker.string'].value+
			'&owner='+
			'&resource='+document.all['mres.string'].value+
			'&agregate=&agregateserial='+
			'&brokentype=1&documentkey='+document.all.document.value
		);
	} else {
	}
}

function rresOnClick() {
	if(FaultForm['placetype'][0].checked) {
		set_opt_params_rsrl(
			'?pagetype=2&worker='+document.all['worker.string'].value+
			'&owner='+
			'&resource='+document.all['rres.string'].value+
			'&agregate=&agregateserial='+
			'&complectcode='+
			'&brokentype=1&documentkey='+document.all.document.value
		);
	} else if(FaultForm['placetype'][1].checked) {
		set_opt_params_rsrl(
//			'?pagetype=2&worker='+document.all['worker.string'].value+
			'?pagetype=2&storage='+document.all['storagecode'].value+
			'&owner='+
			'&resource='+document.all['rres.string'].value+
			'&agregate=&agregateserial='+
			'&complectcode='+
			'&brokentype=1&documentkey='+document.all.document.value
		);
	} else if(FaultForm['placetype'][2].checked) {
	} else {
	}
}

function switchWhere() {
	if(FaultForm['placetype'][0].checked) {
<%if(frm.getUseStorageCombo()) {%>
		FaultForm["storagecode"].disabled = true;
		FaultForm["storagecode"].className = 'editdisabled';
<%} else {%>
		switchLookup('storagecode','stor',true);
<%}%>
		switchLookup('position.string','pos',false);
		switchLookup('complect.string','com',false);
		switchLookup('rres.string','sres',false);
		switchSerial('rsn','rsr',false);
		switchSerial('deviceserial','sr',false);
	} else if(FaultForm['placetype'][1].checked) {
<%if(frm.getUseStorageCombo()) {%>
		FaultForm["storagecode"].disabled = false;
		FaultForm["storagecode"].className = 'edit';
<%} else {%>
		switchLookup('storagecode','stor',false);
<%}%>
		switchLookup('position.string','pos',true);
		switchLookup('complect.string','com',true);
		switchLookup('rres.string','sres',false);
		switchSerial('rsn','rsr',false);
		switchSerial('deviceserial','sr',false);
	} else {
<%if(frm.getUseStorageCombo()) {%>
		FaultForm["storagecode"].disabled = true;
		FaultForm["storagecode"].className = 'editdisabled';
<%} else {%>
		switchLookup('storagecode','stor',true);
<%}%>
		switchLookup('position.string','pos',true);
		switchLookup('complect.string','com',true);
		switchLookup('rres.string','sres',true);
		switchSerial('rsn','rsr',true);
		switchSerial('deviceserial','sr',true);
	}
}
switchWhere();
</script>

</july:editform>

