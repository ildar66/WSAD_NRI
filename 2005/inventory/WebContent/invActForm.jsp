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

<july:editform action="/ProcessInvAct.do">
<bean:define id="docCode" name="InvActForm" property="document" scope="session" type="java.lang.Integer"/>
<july:inventorycalcerrors document="<%=docCode%>"/>
<script language="javascript" src="/action.js"></script>
<%
	InvActForm frm = (InvActForm)request.getSession().getAttribute("InvActForm");
	boolean showpositions = "View".equals(frm.getAction()) || "Edit".equals(frm.getAction());
	boolean changable = "1".equals(frm.getDState()) && !frm.getIsautodoc() && ("View".equals(frm.getAction()) || "Edit".equals(frm.getAction()));

	boolean browseBySerial = frm.isBrowseBySerial();
	String theDocCode = "";
	if (showpositions) {
		theDocCode = frm.getDocumentId().toString(); 
	}
%>

<script language="javascript">
function switchEquipmentLookup(state) {
	if(!document.all.lookupbtn_eql) return;
	if(state) {
		InvActForm.equipserial.className = 'edit';
		InvActForm.equipserial.disabled = false;
		InvActForm.equipcode.className = 'edit';
		InvActForm.equipcode.disabled = false;
		document.all.lookupbtn_eql.disabled = false;
		document.all.lookupimg_eql.src='/images/lookup.gif';
		document.all.lookupbtn_resl.disabled = false;
		document.all.lookupimg_resl.src='/images/lookup.gif';
	} else {
		InvActForm.equipserial.className = 'editdisabled';
		InvActForm.equipserial.disabled = true;
		InvActForm.equipcode.className = 'editdisabled';
		InvActForm.equipcode.disabled = true;
		document.all.lookupbtn_eql.disabled = true;
		document.all.lookupimg_eql.src='/images/lookup_disabled.gif';
		document.all.lookupbtn_resl.disabled = true;
		document.all.lookupimg_resl.src='/images/lookup_disabled.gif';
	}
}
function printWord(prompt1, typeWord){
	if(typeWord == 0){
		//Напечатать акт инвентаризации:
		window.location.href='reports/invacte.jsp?prompt1='+prompt1;
	}
	else if(typeWord == 1){
		//Напечатать перечень недостач:
		window.location.href='reports/mis.jsp?prompt1='+prompt1;
	}
	else if(typeWord == 2){
		//Напечатать перечень излишков:
		window.location.href='reports/extra.jsp?prompt1='+prompt1;
	}
}
</script>

<html:hidden property="document" />
<input type="hidden" name="processState" value="">

<table class="main">
    
    <july:separator/>
	
	<july:formbuttons>
	<%if(showpositions){%>
		<%--
		<%if("A".equals(frm.getType())) {%>
			<A href='javascript:printWord(<%=docCode%>, 0)'><img 
			src="/images/print.gif" border=0 alt='Напечатать акт инвентаризации'></A>
		<%} else {%>
			<A href='javascript:printWord(<%=docCode%>, 0)'><img 
			src="/images/print.gif" border=0 alt='Напечатать акт инвентаризации'></A>
		<%}%> 
		--%>
		<july:wordEditSlave masterStyleId='<%= masterTagId %>' styleId='<%= "invActFormInvAct_" + theDocCode %>' 
		url='<%= "reports/invacte.jsp?prompt1=" + theDocCode %>' 
			uploadurl=''
			updatable='false'
		documentid='<%= theDocCode %>'><IMG SRC="/images/docword.gif" border="0" alt='Напечатать акт инвентаризации'></july:wordEditSlave>
		<%if("2".equals(frm.getDState())) {%>
			<%--
			<A href='javascript:printWord(<%=docCode%>, 1)'><img 
			src="/images/print_lose.gif" border=0 alt='Напечатать перечень недостач'></A>
			<A href='javascript:printWord(<%=docCode%>, 2)'><img 
			src="/images/print_plus.gif" border=0 alt='Напечатать перечень излишков'></A>
			--%>
			<july:wordEditSlave masterStyleId='<%= masterTagId %>' styleId='<%= "invActFormShortage_" + theDocCode %>' 
			url='<%= "reports/mis.jsp?prompt1=" + theDocCode %>' 
			uploadurl=''
			updatable='false'
			documentid='<%= theDocCode %>'><IMG SRC="/images/print_lose.gif" border="0" alt='Напечатать перечень недостач'></july:wordEditSlave>
			<july:wordEditSlave masterStyleId='<%= masterTagId %>' styleId='<%= "invActFormOverplus_" + theDocCode %>' 
			url='<%= "reports/extra.jsp?prompt1=" + theDocCode %>' 
			uploadurl=''
			updatable='false'
			documentid='<%= theDocCode %>'><IMG SRC="/images/print_plus.gif" border="0" alt='Напечатать перечень излишков'></july:wordEditSlave>
		<%}%>
	<%}%>
	<%if(("View".equals(frm.getAction()) || "Edit".equals(frm.getAction())) && !frm.getIsautodoc()){%>
	&nbsp;&nbsp;
		<%if("1".equals(frm.getDState())) {%>
			<input type="image" name="submit" src="/images/calculate.gif" onclick="document.all.action.value='Edit';document.all.processState.value='P';return checkPosted();" title="Обсчёт">

			<%if(frm.getWarnProc() != null && frm.getWarnProc().booleanValue()) {%>
			<input type="image" name="submit" src="/images/calculatea.gif" onclick="document.all.action.value='Edit';document.all.processState.value='P';document.all.warnProc.value='true';return checkPosted();" title="Обсчёт с автоматическим исправлением несоответствий">
			<%}%>

		<%} else {%>
			<html:link page="/ProcessInvAct.do?action=Edit&processState=C" paramId="document" paramName="InvActForm" paramProperty="document" paramScope="session" onclick="return checkPosted();"><img src="/images/calculates.gif" border=0 alt="Снять обсчёт"></html:link>
		<%}%>
	<%}%>
	</july:formbuttons>

    <july:separator/>
    <tr>
        <td class="title" colspan="2"><july:actionalert/></td>
    </tr>

    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.inventory.org"/>:</july:reqmark></td>
        <td>
			<july:select collection="organizations" property="ownercode" insertable="true" updatable="true">
				<html:options collection="organizations" property="organization" labelProperty="name"/>
			</july:select>
        </td>
    </tr>
    
    <july:separator/>

    <tr>
        <td class="text"><july:reqmark><bean:message key="label.inventory.storage"/>:</july:reqmark></td>
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
        <td class="text"><july:reqmark><bean:message key="label.inventory.num"/>:</july:reqmark></td>
        <td>
           <%-- <july:string property="blankindexFrm" size="15" insertable="true" updatable="true" /> --%>
           <july:string property="blanknumber" size="15" insertable="true" updatable="true" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.inventory.date"/>:</july:reqmark></td>
        <td>
          <july:date property="blankdatestr" size="25" insertable="true" updatable="true" />
        </td>
    </tr>
    
    <july:separator/>
    
<tr>
	<td class="text"><bean:message key="label.inventory.type"/>:</td>
	<td>
		<july:radio insertable="true" updatable="true" property="type" value="F" onclick="switchEquipmentLookup(InvActForm.type[2].checked);"/><bean:message key="label.inventory.type.full"/>
		<july:radio insertable="true" updatable="true" property="type" value="P" onclick="switchEquipmentLookup(InvActForm.type[2].checked);"/><bean:message key="label.inventory.type.byselect"/>
		<july:radio insertable="true" updatable="true" property="type" value="A" onclick="switchEquipmentLookup(InvActForm.type[2].checked);"/><bean:message key="label.inventory.type.byunit"/>
	</td>
</tr>   
  
<july:separator/>

	<tr>
	<td class="text">Оборудование:</td>
        <td>
			<july:string size="5" property="equipcode" styleId="equipcode" insertable="true" updatable="true"/>
			
			<%if(!browseBySerial){%>
				<july:lookupbutton action="/ShowResourceLookupList.do" styleId="resl" fieldNames="equipcode;equipmodel;equipname" newWindowName="resourcelookup" insertable="true" updatable="true"/>
			<%} else {
				String s = "/ShowResourceLookupBySerialList.do?snumber=";
				%>
				<july:lookupbutton action="<%= s + frm.getEquipserial() %>" styleId="resl" fieldNames="equipcode;equipmodel;equipname" newWindowName="resourcelookup" insertable="true" updatable="true" image="lookup_red"/>
			<%}%>
			
			<html:text size="25" style="FONT-FAMILY: Verdana,Arial; FONT-SIZE: 10pt; background-color: DCDCDC;" property="equipmodel" readonly="true"/>			
			<html:text size="25" style="FONT-FAMILY: Verdana,Arial; FONT-SIZE: 10pt; background-color: DCDCDC;" property="equipname" readonly="true"/>
		</td>
	</tr>

<july:separator/>	

<tr>
	<td class="text"><bean:message key="label.inventory.unit"/>:</td>
	<td>
		<july:string size="15" property="equipserial" styleId="equipserial" insertable="true" updatable="true" />
		<july:lookupbutton action="/ShowCardLookupList.do" styleId="eql" onclick="set_opt_params_eql('?pagetype=2&storage='+document.all.storagecode.value+'&resource=&owner=&agregate=&brokentype=1&documentkey='+document.all.document.value)" fieldNames="temp;equipname;temp;temp;equipserial;temp;temp;temp;temp;temp;temp;temp;temp" newWindowName="equiplookup" insertable="true" updatable="true"/>&nbsp;
		<%--<july:string size="25" property="equipname" styleId="equipname" insertable="false" updatable="false" />--%>
		<input type=hidden name="temp">
		<script language="javascript">
			switchEquipmentLookup(InvActForm.type[2].checked);
		</script>
	</td>
</tr>
    
<july:separator/>
    
<tr>
	<td class="text"><july:reqmark><bean:message key="label.inventory.storageman"/>:</july:reqmark></td>
	<td>
		<july:string property="storagemancode" styleId="storagemancode" size="5" insertable="true" updatable="true" />
		<july:lookupbutton action="/ShowWorkerLookupList.do" styleId="w1l" fieldNames="storagemancode;storagemanname" newWindowName="storlookup"  insertable="true" updatable="true" />
		<july:string size="35" property="storagemanname" styleId="storagemanname" insertable="false" updatable="false" />
	</td>
</tr>
    
<july:separator/>
    
<tr>
	<td class="text"><bean:message key="label.inventory.technician"/>:</td>
	<td>
		<july:string property="techniciancode" styleId="techniciancode" size="5" insertable="true" updatable="true" />
		<july:lookupbutton action="/ShowWorkerLookupList.do" styleId="w2l" fieldNames="techniciancode;technicianname" newWindowName="techlookup" insertable="true" updatable="true"/>
		<july:string size="35" property="technicianname" styleId="technicianname" insertable="false" updatable="false" />
	</td>
</tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><bean:message key="label.inventory.state"/>:</td>
        <td>
	   <logic:equal name="InvActForm" property="dState" value="1"><bean:message key="label.state.entering"/></logic:equal>
	   <logic:equal name="InvActForm" property="dState" value="2"><bean:message key="label.state.calculated"/></logic:equal>
	   <a href="/inventory/EditInvAct.do?action=Edit#sel2ID363761" >test</a>
        </td>
    </tr>
	
<july:separator/>
<july:formbuttons>
<%if(showpositions){%>
	    <%--
	    <%if("A".equals(frm.getType())) {%>
			<A href='javascript:printWord(<%=docCode%>, 0)'><img 
			src="/images/print.gif" border=0 alt='Напечатать акт инвентаризации'></A>
		<%} else {%>
			<A href='javascript:printWord(<%=docCode%>, 0)'><img 
			src="/images/print.gif" border=0 alt='Напечатать акт инвентаризации'></A>
		<%}%> 
		--%>
		<july:wordEditSlave masterStyleId='<%= masterTagId %>' styleId='<%= "invActFormInvAct02_" + theDocCode %>' 
		url='<%= "reports/invacte.jsp?prompt1=" + theDocCode %>' 
			uploadurl=''
			updatable='false'
		documentid='<%= theDocCode %>'><IMG SRC="/images/docword.gif" border="0" alt='Напечатать акт инвентаризации'></july:wordEditSlave>
		<%if("2".equals(frm.getDState())) {%>
			<%--
			<A href='javascript:printWord(<%=docCode%>, 1)'><img 
			src="/images/print_lose.gif" border=0 alt='Напечатать перечень недостач'></A>
			<A href='javascript:printWord(<%=docCode%>, 2)'><img 
			src="/images/print_plus.gif" border=0 alt='Напечатать перечень излишков'></A>
			--%>
			<july:wordEditSlave masterStyleId='<%= masterTagId %>' styleId='<%= "invActFormShortage02_" + theDocCode %>' 
			url='<%= "reports/mis.jsp?prompt1=" + theDocCode %>' 
			uploadurl=''
			updatable='false'
			documentid='<%= theDocCode %>'><IMG SRC="/images/print_lose.gif" border="0" alt='Напечатать перечень недостач'></july:wordEditSlave>
			<july:wordEditSlave masterStyleId='<%= masterTagId %>' styleId='<%= "invActFormOverplus02_" + theDocCode %>' 
			url='<%= "reports/extra.jsp?prompt1=" + theDocCode %>' 
			uploadurl=''
			updatable='false'
			documentid='<%= theDocCode %>'><IMG SRC="/images/print_plus.gif" border="0" alt='Напечатать перечень излишков'></july:wordEditSlave>
		<%}%>
<%}%>
<%if(("View".equals(frm.getAction()) || "Edit".equals(frm.getAction())) && !frm.getIsautodoc()){%>
&nbsp;&nbsp;
	<%if("1".equals(frm.getDState())) {%>
		<input type="image" name="submit" src="/images/calculate.gif" onclick="document.all.action.value='Edit';document.all.processState.value='P';return checkPosted();" title="Обсчёт">

		<%if(frm.getWarnProc() != null && frm.getWarnProc().booleanValue()) {%>
			<input type="image" name="submit" src="/images/calculatea.gif" onclick="document.all.action.value='Edit';document.all.processState.value='P';document.all.warnProc.value='true';return checkPosted();" title="Обсчёт с автоматическим исправлением несоответствий">
			<%}%>

	<%} else {%>
		<html:link page="/ProcessInvAct.do?action=Edit&processState=C" paramId="document" paramName="InvActForm" paramProperty="document" paramScope="session" onclick="return checkPosted();"><img src="/images/calculates.gif" border=0 alt="Снять обсчёт"></html:link>
	<%}%>
<%}%>
</july:formbuttons>
<%if(showpositions) {%>
<july:separator/>
<tr class="title">
	<td colspan="2" class="title">
	<table cellpadding=0 cellspacing=0 width=100% border=0 class="main">
	<tr>
		<td><nobr><%if(changable) {%>
			<july:addbutton page="/EditInvActPos.do?action=Add"  alttext="label.invpos.add" onclick="return checkPosted();"/>
			<html:link page="/InvActLoadExcel.do?action=Add" paramId="doc" paramName="InvActForm" paramProperty="document" paramScope="session" onclick="return checkPosted();"><img src="/images/loadexcel.gif" border="0" alt="Загрузка данных из Excel"></html:link>
			<html:link page="/InvActFillFromDB.do?action=Add" paramId="doc" paramName="InvActForm" paramProperty="document" paramScope="session" onclick="return checkPosted();"><img src="/images/loaddb.gif" border="0" alt="Создать позиции по состоянию базы данных"></html:link>
			<july:backbutton page="/ShowInvActList.do"/>
		<%}%></nobr></td>
		<td class="title" align="right">
			<bean:message key="label.inventory.positions"/>
		</td>
	</tr>
	</table>
	</td>
</tr>
<july:separator/>
<tr><td colspan="2" style="padding:0px;">
	<table class="main">
	<tr class="title">
		<td class="title">&nbsp;</td>
		<july:headercolumn key="label.invpos.num" colType="number"/>
		<%if(changable) {%><td class="title">&nbsp;</td><%}%>
		<july:headercolumn key="label.name" colType="string"/>
		<july:headercolumn key="label.invpos.serialnum" colType="string"/>
		<july:headercolumn key="label.invpos.qty" colType="string"/>
		<july:headercolumn key="label.invpos.price" colType="number"/>
		<july:headercolumn key="label.invpos.sum" colType="number"/>
		<%if(changable) {%><td class="title">&nbsp;</td><%}%>
	</tr>

	<logic:iterate id="it" name="InvActForm" property="listItems" type="com.hps.july.cdbc.lib.CDBCRowObject">
	<logic:present name="it">
	<%
		String docposition = it.getColumn("docposition").asString();
		pageContext.setAttribute("it_docposition",docposition);
		String countpolicy = it.getColumn("countpolicy").asString();
/*
		String serialnumber = null;
		if ("S".equals(countpolicy))
      serialnumber = it.getColumn("serialnumber").asString();
		else if ("P".equals(countpolicy))
      serialnumber = it.getColumn("party").asString();
		if(serialnumber == null) serialnumber = "";
		String manufserial = it.getColumn("manufserial").asString();
		if(manufserial != null && !"".equals(manufserial) && !serialnumber.equals(manufserial) ) {
			serialnumber += " ("+manufserial+")";
		}
		pageContext.setAttribute("it_serialnumber",serialnumber);
*/
		String resname = it.getColumn("resname").asString();
		if(resname != null && !"".equals(resname)) {
			pageContext.setAttribute("it_resname",resname);
		}
		String resmodel = it.getColumn("resmodel").asString();
		if(resmodel != null && !"".equals(resmodel)) {
			pageContext.setAttribute("it_resmodel",resmodel);
		}
		String resconfig = it.getColumn("resconfig").asString();
		if(resconfig != null && !"".equals(resconfig)) {
			pageContext.setAttribute("it_resconfig",resconfig);
		}
	%>
	
	<tr class="normal" onMouseOver="className='select';" onMouseOut="className='normal';">
		
		<td class="string">
			<a name="<july:stringwrite name="it" property="docposition"/>"></a>
			<%if(changable) {%>
				<%--<july:editbutton page="/EditInvActPos.do" action="Edit" paramId="docposition" paramName="it_docposition" paramScope="page" alttext="label.dassactpos.edit"/>--%>

				<a href="/inventory/EditInvActPos.do?action=Edit&amp;scroll=600&docposition=<july:stringwrite name="it" property="docposition"/>&retparams=(%23<july:stringwrite name="it" property="docposition"/>)" onclick="document.body.style.cursor='wait'; "><IMG SRC="/images/izmena.gif" BORDER='0'></a>

			<%} else {%>
				<july:editbutton page="/EditInvActPos.do" action="View" paramId="docposition" paramName="it_docposition" paramScope="page" alttext="label.dassactpos.view"/>
			<%}%>
			
		</td>
                <td class="number"><july:stringwrite name="it" property="order"/></td>
		<%if(changable){%>
		<td class="link"><%if("S".equals(countpolicy)) { %><html:link page="/EditInvActPos.do?action=Add" paramId="copydocpos" paramName="it_docposition" paramScope="page"><bean:message key="label.invpos.copy"/></html:link><%}%></td>
		<%}%>
		<td class="text"><%if(resname != null && !"".equals(resname)) {%><july:stringwrite name="it_resname"/><%if(resmodel != null && !"".equals(resmodel)) {%>,<br><july:stringwrite name="it_resmodel"/><%}%><%if(resconfig != null && !"".equals(resconfig)) {%>,<br><bean:write name="it_resconfig"/><%}%><%}%></td>
		<td class="text"><july:stringwrite name="it" property="invnum"/></td>
		<td class="text" align="right"><july:numberwrite name="it" property="qty"/> <july:stringwrite name="it" property="usn"/></td>
		<td class="text"><july:numberwrite name="it" property="price" fractdigits="2"/></td>
		<td class="text"><july:numberwrite name="it" property="sum" fractdigits="2"/></td>
		<%if(changable) {%><td class="link"><july:delbutton page="/EditInvActPos.do?action=Delete" paramId="docposition" paramName="it_docposition" paramScope="page" /></td><%}%>
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
			<july:addbutton page="/EditInvActPos.do?action=Add"  alttext="label.invpos.add" onclick="return checkPosted();"/>
			<html:link page="/InvActLoadExcel.do?action=Add" paramId="doc" paramName="InvActForm" paramProperty="document" paramScope="session" onclick="return checkPosted();"><img src="/images/loadexcel.gif" border="0" alt="Загрузка данных из Excel"></html:link>
			<html:link page="/InvActFillFromDB.do?action=Add" paramId="doc" paramName="InvActForm" paramProperty="document" paramScope="session" onclick="return checkPosted();"><img src="/images/loaddb.gif" border="0" alt="Создать позиции по состоянию базы данных"></html:link>
			<july:backbutton page="/ShowInvActList.do"/>
		<%}%></nobr></td>
		<td class="title" align="right">&nbsp;</td>
	</tr>
	</table>
	</td>
</tr>
<%}%>
</table>

</july:editform>

