<%@ page language = "java" %>
<%@ page import="com.hps.july.inventory.formbean.PositionInventory" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import="com.hps.july.cdbc.lib.*"%>

<%
	String masterTagId = "changeSFormWordEditMasterTagId";
%>
<july:wordEditMaster styleId='<%= masterTagId %>' >
</july:wordEditMaster>

<july:editform action="/ProcessPositionInventory.do">
<script language="javascript" src="/action.js"></script>
<%
	String updt = "true";
	PositionInventory frm = (PositionInventory)session.getAttribute("PositionInventory");
	String invtype = frm.getType();
	String docstate = frm.getDState();
	if("Edit".equals(frm.getAction())) {
		if(!"A".equals(frm.getType())) {
			updt = "false";
		}
	}
	boolean editable = "Add".equals(frm.getAction()) || "Edit".equals(frm.getAction());
	boolean changable = "1".equals(frm.getDState()) && !frm.getIsautodoc();
	boolean showpositions = "View".equals(frm.getAction()) || "Edit".equals(frm.getAction());
	boolean showStateLink = ("View".equals(frm.getAction()) || "Edit".equals(frm.getAction())) && !frm.getIsautodoc();

	boolean browseBySerial = frm.isBrowseBySerial();
	String theDocCode = "";
	if (showpositions) {
		theDocCode = frm.getDocumentId().toString(); 
	}
	String mockIndex = frm.getBlankindexFrm(); 
	if (mockIndex == null || mockIndex.length() == 0) {
		mockIndex = frm.MOCK_DOC_ID;
	}
%>
<bean:define id="docCode" name="PositionInventory" property="document" scope="session" type="java.lang.Integer"/>
<july:inventorycalcerrors document="<%=docCode%>"/>

<script language="javascript">
// Эта функция может быть перенесена в looukupbutton tag для общности.
function switchEquipmentLookup(state) {
	if(document.all.action.value == "Add") {
		if(state) {
			document.all.equipserial.className = 'edit';
			document.all.equipserial.disabled = false;
			document.all.equipcode.className = 'edit';
			document.all.equipcode.disabled = false;
			document.all.lookupbtn_eql.disabled = false;
			document.all.lookupimg_eql.src='/images/lookup.gif';
			document.all.lookupbtn_resl.disabled = false;
			document.all.lookupimg_resl.src='/images/lookup.gif';
		} else {
			document.all.equipserial.className = 'editdisabled';
			document.all.equipserial.disabled = true;
			document.all.equipcode.className = 'editkoddisabled';
			document.all.equipcode.disabled = true;
			document.all.lookupbtn_eql.disabled = true;
			document.all.lookupimg_eql.src='/images/lookup_disabled.gif';
			document.all.lookupbtn_resl.disabled = true;
			document.all.lookupimg_resl.src='/images/lookup_disabled.gif';
		}
	}
}
function printWord(prompt1, typeWord){
	if(typeWord == 1){
	//Напечатать акт инвентаризации:
	window.location.href='reports/invp.jsp?prompt1='+prompt1;
	} else if(typeWord == 2){
	//Напечатать акт инвентаризации:
	window.location.href='reports/inv.jsp?prompt1='+prompt1;	
	} else if(typeWord == 3){
	//Напечатать перечень недостач:
	window.location.href='reports/misp.jsp?prompt1='+prompt1;	
	} else if(typeWord == 4){
	//Напечатать перечень излишков:
	window.location.href='reports/extrap.jsp?prompt1='+prompt1;	
	}
}
</script>


<html:hidden property="document" />
<input type="hidden" name="processState" value="">

<table class="main">

<july:separator/>

<july:formbuttons>
<%if(showpositions) {%>

	<%if("A".equals(invtype)) {%>
	<%--
		<A href='javascript:printWord(<%=docCode%>, 1)'><img 
		src="/images/print.gif" border=0 alt='Напечатать акт инвентаризации'></A>
	--%>
		<july:wordEditSlave masterStyleId='<%= masterTagId %>' styleId='<%= "positionInventory01_" + theDocCode %>' 
		url='<%= "reports/invp.jsp?prompt1=" + theDocCode %>' 
			uploadurl=''
			updatable='false'
		documentid='<%= theDocCode %>'><IMG SRC="/images/docword.gif" border="0" alt='Напечатать акт инвентаризации'></july:wordEditSlave>
	<%} else {%>
	<%--
		<A href='javascript:printWord(<%=docCode%>, 2)'><img 
		src="/images/print.gif" border=0 alt='Напечатать акт инвентаризации'></A>
	--%>
		<july:wordEditSlave masterStyleId='<%= masterTagId %>' styleId='<%= "positionInventory02_" + theDocCode %>' 
		url='<%= "reports/inv.jsp?prompt1=" + theDocCode %>' 
			uploadurl=''
			updatable='false'
		documentid='<%= theDocCode %>'><IMG SRC="/images/docword.gif" border="0" alt='Напечатать акт инвентаризации'></july:wordEditSlave>
	<%}%>
	<%if("2".equals(docstate)) {%>
	<%--
		<A href='javascript:printWord(<%=docCode%>, 3)'><img 
		src="/images/print_lose.gif" border=0 alt='Напечатать перечень недостач'></A>
		<A href='javascript:printWord(<%=docCode%>, 4)'><img 
		src="/images/print_plus.gif" border=0 alt='Напечатать перечень излишков'></A>
	--%>	
			<july:wordEditSlave masterStyleId='<%= masterTagId %>' styleId='<%= "positionInventory03_" + theDocCode %>' 
			url='<%= "reports/misp.jsp?prompt1=" + theDocCode %>' 
			uploadurl=''
			updatable='false'
			documentid='<%= theDocCode %>'><IMG SRC="/images/print_lose.gif" border="0" alt='Напечатать перечень недостач'></july:wordEditSlave>
			<july:wordEditSlave masterStyleId='<%= masterTagId %>' styleId='<%= "positionInventory04_" + theDocCode %>' 
			url='<%= "reports/extrap.jsp?prompt1=" + theDocCode %>' 
			uploadurl=''
			updatable='false'
			documentid='<%= theDocCode %>'><IMG SRC="/images/print_plus.gif" border="0" alt='Напечатать перечень излишков'></july:wordEditSlave>
	<%}%>

<%}%>
&nbsp;&nbsp;
<%if(showStateLink){%>
	<%if("1".equals(docstate)) {%>
		<input type="image" name="submit" src="/images/calculate.gif" onclick="document.all.action.value='Edit';document.all.processState.value='P';document.all.warnProc.value='false';return checkPosted();" title="Обсчёт">
<%if(com.hps.july.util.AppUtils.isNewInventory()) {%>
<%  if(frm.getWarnProc() != null && frm.getWarnProc().booleanValue()) {%>
		<input type="image" name="submit" src="/images/calculatea.gif" onclick="document.all.action.value='Edit';document.all.processState.value='P';document.all.warnProc.value='true';return checkPosted();" title="Обсчёт с автоматическим исправлением несоответствий">
<%  }%>
<%}%>
	<%} else {%>
		<html:link page="/ProcessPositionInventory.do?action=Edit&processState=C" paramId="document" paramName="PositionInventory" paramProperty="document" paramScope="session" onclick="return checkPosted();"><img src="/images/calculates.gif" border=0 alt="Снять обсчёт"></html:link>
	<%}%>
<%}%>

</july:formbuttons>

<july:separator/>

<tr>
	<td class="title" colspan="2"><july:actionalert/></td>
</tr>

<july:separator/>

<tr>
	<td class="text"><july:reqmark><bean:message key="label.inventory.num"/>:</july:reqmark></td>
	<td>
		<%-- <july:string property="blankindexFrm" size="15" insertable="true" updatable="true" /> --%>
	    <html:hidden property="blankindexFrm" value="<%=mockIndex%>" />
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
	<td class="text"><july:reqmark><bean:message key="label.inventory.org"/>:</july:reqmark></td>
	<td>
		<july:select collection="organizations" property="ownercode" insertable="true" updatable="true">
			<html:options collection="organizations" property="organization" labelProperty="name"/>
		</july:select>
	</td>
</tr>

<july:separator/>

<tr>
	<td class="text"><bean:message key="label.inventory.type"/>:</td>
	<td>
		<july:radio insertable="true" updatable="false" property="type" value="F" onclick="switchEquipmentLookup(document.all.type[1].checked);"/><bean:message key="label.inventory.type.full"/>
		<july:radio insertable="true" updatable="false" property="type" value="A" onclick="switchEquipmentLookup(document.all.type[1].checked);"/><bean:message key="label.inventory.type.byunit"/>
	</td>
</tr>

<july:separator/>

<tr>
	<td class="text"><july:reqmark><bean:message key="label.inventory.position"/>:</july:reqmark></td>
	<td>
		<july:string property="position" styleId="position" size="5" insertable="true" updatable="true" onchange="complect.value='';complectname.value='';"/>
		<july:lookupbutton action="/ShowPositionLookupList.do" styleId="pl" fieldNames="position;positionid;positionname;complect;complectname;equipserial;equipname;" newWindowName="poslookup" insertable="true" updatable="true" />
		<july:string size="10" property="positionid" styleId="positionid" insertable="false" updatable="false" />
		<july:string size="25" property="positionname" styleId="positionname" insertable="false" updatable="false" />
	</td>
</tr>

<july:separator/>

<script language="javascript">
function clearEquipment() {
	document.all.equipserial.value='';
	document.all.equipname.value='';
}
</script>

<tr>
	<td class="text"><july:reqmark><bean:message key="label.inventory.complect"/>:</july:reqmark></td>
	<td>
		<html:hidden property="complect"/>
		<july:string size="35" property="complectname" styleId="complectname" insertable="false" updatable="false" />
		<july:lookupbutton action="/ShowComplectLookupList.do" styleId="cl" fieldNames="complect;complectname" newWindowName="poslookup" insertable="true" updatable="true" onclick="set_opt_params_cl('?position='+document.all.position.value)" onselect="clearEquipment();"/>
	</td>
</tr>

<july:separator/>

	<tr>
		<td class="text">Оборудование:</td>
        <td>
			<july:string size="5" property="equipcode" styleId="equipcode" insertable="true" updatable="<%=updt%>" />

			<%if(!browseBySerial){%>
				<july:lookupbutton action="/ShowResourceLookupList.do" styleId="resl" fieldNames="equipcode;equipmodel;equipname" newWindowName="resourcelookup" insertable="true" updatable="<%=updt%>"/>
			<%} else {
				String s = "/ShowResourceLookupBySerialList.do?snumber=";
				%>
				<july:lookupbutton action="<%= s + frm.getEquipserial() %>" styleId="resl" fieldNames="equipcode;equipmodel;equipname" newWindowName="resourcelookup" insertable="true" updatable="<%=updt%>" image="lookup_red"/>
			<%}%>
			
			<html:text size="25" style="FONT-FAMILY: Verdana,Arial; FONT-SIZE: 10pt; background-color: DCDCDC;" property="equipmodel" readonly="true"/>			
			<html:text size="25" style="FONT-FAMILY: Verdana,Arial; FONT-SIZE: 10pt; background-color: DCDCDC;" property="equipname" readonly="true"/>
		</td>
	</tr>

    <july:separator/>

<tr>
	<td class="text"><bean:message key="label.inventory.unit"/>:</td>
	<td>
		<july:string size="25" property="equipserial" styleId="equipserial" insertable="true" updatable="<%=updt%>" />
		<july:lookupbutton action="/ShowCardRLookupList.do" styleId="eql" onclick="set_opt_params_eql('?pagetype=2&storage='+document.all.complect.value+'&resource=&owner=&agregate=&brokentype=1&documentkey='+document.all.document.value)" fieldNames="equipcode;equipname;equipmodel;temp;equipserial;temp;temp;temp;temp;temp;temp;temp;temp" newWindowName="equiplookup" insertable="true" updatable="<%=updt%>"/>
		<%--<july:string size="25" property="equipname" styleId="equipname" insertable="false" updatable="false" />--%>
		<input type=hidden name="temp">
		<script language="javascript">
			switchEquipmentLookup(document.all.type[1].checked);
		</script>
	</td>
</tr>

<july:separator/>
    
<tr>
	<td class="text"><july:reqmark><bean:message key="label.inventory.tech1"/>:</july:reqmark></td>
	<td>
		<july:string property="storagemancode" styleId="storagemancode" size="5" insertable="true" updatable="true" />
		<july:lookupbutton action="/ShowWorkerLookupList.do" styleId="w1l" fieldNames="storagemancode;storagemanname" newWindowName="storlookup"  insertable="true" updatable="true" />
		<july:string size="35" property="storagemanname" styleId="storagemanname" insertable="false" updatable="false" />
	</td>
</tr>
    
<july:separator/>
    
<tr>
	<td class="text"><bean:message key="label.inventory.tech2"/>:</td>
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
		<%if("1".equals(docstate)) {%><bean:message key="label.state.entering"/><%} else {%><bean:message key="label.state.calculated"/><%}%>
	</td>
</tr>

<july:separator/>

<july:formbuttons>
<%if(showpositions) {%>
<%--
	<%if("A".equals(invtype)) {%>
		<A href='javascript:printWord(<%=docCode%>, 1)'><img 
		src="/images/print.gif" border=0 alt='Напечатать акт инвентаризации'></A>
	<%} else {%>
		<A href='javascript:printWord(<%=docCode%>, 2)'><img 
		src="/images/print.gif" border=0 alt='Напечатать акт инвентаризации'></A>
	<%}%>
	<%if("2".equals(docstate)) {%>
		<A href='javascript:printWord(<%=docCode%>, 3)'><img 
		src="/images/print_lose.gif" border=0 alt='Напечатать перечень недостач'></A>
		<A href='javascript:printWord(<%=docCode%>, 4)'><img 
		src="/images/print_plus.gif" border=0 alt='Напечатать перечень излишков'></A>
	<%}%>
--%>
	<%if("A".equals(invtype)) {%>
	<%--
		<A href='javascript:printWord(<%=docCode%>, 1)'><img 
		src="/images/print.gif" border=0 alt='Напечатать акт инвентаризации'></A>
	--%>
		<july:wordEditSlave masterStyleId='<%= masterTagId %>' styleId='<%= "positionInventory11_" + theDocCode %>' 
		url='<%= "reports/invp.jsp?prompt1=" + theDocCode %>' 
			uploadurl=''
			updatable='false'
		documentid='<%= theDocCode %>'><IMG SRC="/images/docword.gif" border="0" alt='Напечатать акт инвентаризации'></july:wordEditSlave>
	<%} else {%>
	<%--
		<A href='javascript:printWord(<%=docCode%>, 2)'><img 
		src="/images/print.gif" border=0 alt='Напечатать акт инвентаризации'></A>
	--%>
		<july:wordEditSlave masterStyleId='<%= masterTagId %>' styleId='<%= "positionInventory12_" + theDocCode %>' 
		url='<%= "reports/inv.jsp?prompt1=" + theDocCode %>' 
			uploadurl=''
			updatable='false'
		documentid='<%= theDocCode %>'><IMG SRC="/images/docword.gif" border="0" alt='Напечатать акт инвентаризации'></july:wordEditSlave>
	<%}%>
	<%if("2".equals(docstate)) {%>
	<%--
		<A href='javascript:printWord(<%=docCode%>, 3)'><img 
		src="/images/print_lose.gif" border=0 alt='Напечатать перечень недостач'></A>
		<A href='javascript:printWord(<%=docCode%>, 4)'><img 
		src="/images/print_plus.gif" border=0 alt='Напечатать перечень излишков'></A>
	--%>	
			<july:wordEditSlave masterStyleId='<%= masterTagId %>' styleId='<%= "positionInventory13_" + theDocCode %>' 
			url='<%= "reports/misp.jsp?prompt1=" + theDocCode %>' 
			uploadurl=''
			updatable='false'
			documentid='<%= theDocCode %>'><IMG SRC="/images/print_lose.gif" border="0" alt='Напечатать перечень недостач'></july:wordEditSlave>
			<july:wordEditSlave masterStyleId='<%= masterTagId %>' styleId='<%= "positionInventory14_" + theDocCode %>' 
			url='<%= "reports/extrap.jsp?prompt1=" + theDocCode %>' 
			uploadurl=''
			updatable='false'
			documentid='<%= theDocCode %>'><IMG SRC="/images/print_plus.gif" border="0" alt='Напечатать перечень излишков'></july:wordEditSlave>
	<%}%>
<%}%>
&nbsp;&nbsp;
<%if(showStateLink){%>
	<%if("1".equals(docstate)) {%>
		<input type="image" name="submit" src="/images/calculate.gif" onclick="document.all.action.value='Edit';document.all.processState.value='P';document.all.warnProc.value='false';return checkPosted();" title="Обсчёт">
<%if(com.hps.july.util.AppUtils.isNewInventory()) {%>
<%if(frm.getWarnProc() != null && frm.getWarnProc().booleanValue()) {%>
		<input type="image" name="submit" src="/images/calculatea.gif" onclick="document.all.action.value='Edit';document.all.processState.value='P';document.all.warnProc.value='true';return checkPosted();" title="Обсчёт с автоматическим исправлением несоответствий">
<%}%>
<html:hidden property="warnProc"/>
<%}%>
	<%} else {%>
		<html:link page="/ProcessPositionInventory.do?action=Edit&processState=C" paramId="document" paramName="PositionInventory" paramProperty="document" paramScope="session" onclick="return checkPosted();"><img src="/images/calculates.gif" border=0 alt="Снять обсчёт"></html:link>
	<%}%>
<%}%>

</july:formbuttons>

<%if(showpositions) {%>
<%	String gColSpan = "11"; %>
<july:separator/>
<%-- Document Items control buttons --%>
<tr class="title">
	<td colspan="2" class="title">
	<table cellpadding=0 cellspacing=0 width=100% border=0 class="main">
	<tr>
		<td width="10"><nobr>
			<%if(changable) {%><july:addbutton page="/EditPositionInventoryItem.do?action=Add" alttext="label.invpos.add" onclick="return checkPosted();"/><%}%>
			<%if(changable) {%><html:link page="/InvLoadExcel.do?action=Add" paramId="doc" paramName="PositionInventory" paramProperty="document" paramScope="session" onclick="return checkPosted();"><img src="/images/loadexcel.gif" border="0" alt="Загрузка данных из Excel"></html:link><%}%>
			<%if(changable) {%><html:link page="/InvFillFromDB.do?action=Add" paramId="doc" paramName="PositionInventory" paramProperty="document" paramScope="session" onclick="return checkPosted();"><img src="/images/loaddb.gif" border="0" alt="Создать позиции по состоянию базы данных"></html:link><%}%>
			<%if(changable) {%><logic:equal name="PositionInventory" property="type" value="A"><html:link page="/InvLoadInv.do?action=Add" paramId="doc" paramName="PositionInventory" paramProperty="document" paramScope="session" onclick="return checkPosted();"><img src="/images/loadinv.gif" border="0" alt="Создать позиции из INV файла"></html:link><IMG SRC="/images/empty.gif" BORDER='0' ALT='' WIDTH='3'></logic:equal><%}%>
		</nobr></td>
		<td class="title" align="right">
			<bean:message key="label.inventory.positions"/>
		</td>
	</tr>
	</table>
	</td>
</tr>
<tr><td colspan="2">
	<table class="main">
	<tr class="title">
		<july:headercolumn key="label.void" colType="string"/>
		<july:headercolumn key="label.invpos.num" colType="number"/>
		<%if(changable) {%><td class="title">&nbsp;</td><%}%>
		<july:headercolumn key="label.name" colType="string"/>
		<july:headercolumn key="label.invpos.serialnum" colType="string"/>
		<july:headercolumn key="label.invpos.qtys" colType="string"/>
		<july:headercolumn key="label.invpos.unit" colType="string"/>
		<july:headercolumn key="label.invpos.price" colType="number"/>
		<july:headercolumn key="label.invpos.sum" colType="number"/>
		<july:headercolumn key="label.invpos.xplace" colType="number"/>
		<%if(changable) {%><td class="title">&nbsp;</td><%}%>
	</tr>

	<logic:iterate id="it" name="PositionInventory" property="documentItems">
	<logic:present name="it">
	<%
		CDBCRowObject ro = (CDBCRowObject)it;
		String docposition = ro.getColumn("docposition").asString();
		pageContext.setAttribute("it_docposition",docposition);
		String countpolicy = ro.getColumn("countpolicy").asString();
/*
		String serialnumber = null;
		if ("S".equals(countpolicy))
      serialnumber = ro.getColumn("serialnumber").asString();
		else if ("P".equals(countpolicy))
      serialnumber = ro.getColumn("party").asString();
		if(serialnumber == null) serialnumber = "";
		String manufserial = ro.getColumn("manufserial").asString();
		if(manufserial != null && !"".equals(manufserial) && !serialnumber.equals(manufserial) ) {
			serialnumber += " ("+manufserial+")";
		}
		pageContext.setAttribute("it_serialnumber",serialnumber);
*/
		String resname = ro.getColumn("resname").asString();
		if(resname != null && !"".equals(resname)) {
			pageContext.setAttribute("it_resname",resname);
		}
		String resmodel = ro.getColumn("resmodel").asString();
		if(resmodel != null && !"".equals(resmodel)) {
			pageContext.setAttribute("it_resmodel",resmodel);
		}
		String resconfig = ro.getColumn("resconfig").asString();
		if(resconfig != null && !"".equals(resconfig)) {
			pageContext.setAttribute("it_resconfig",resconfig);
		}
	%>
	<tr class="normal" onMouseOver="className='select';" onMouseOut="className='normal';">
		<td class="link">
			<%if(changable) {%>
				<july:editbutton page="/EditPositionInventoryItem.do" action="Edit" paramId="docposition" paramName="it_docposition" paramScope="page" alttext="label.invpos.edit"/>
			<%} else {%>
				<july:editbutton page="/EditPositionInventoryItem.do" action="View" paramId="docposition" paramName="it_docposition" paramScope="page" alttext="label.invpos.view"/>
			<%}%>
		</td>
		<td class="number"><july:stringwrite name="it" property="order"/></td>
		<%if(changable) {%>
		<td class="link">
			<%if("S".equals(countpolicy)) { %>
			<html:link page="/EditPositionInventoryItem.do?action=Add" paramId="copydocpos" paramName="it_docposition" paramScope="page"><bean:message key="label.invpos.copy"/></html:link>
			<%}%>
		</td>
		<%}%>
		<td class="text">
			<%if(resname != null && !"".equals(resname)) {%>
				<july:stringwrite name="it_resname"/><%if(resmodel != null && !"".equals(resmodel)) {%>,<br><july:stringwrite name="it_resmodel"/><%}%><%if(resconfig != null && !"".equals(resconfig)) {%>,<br><bean:write name="it_resconfig"/><%}%>
			<%}%>
		</td>
		<td class="text"><july:stringwrite name="it" property="invnum"/></td>
		<td class="text"><july:numberwrite name="it" property="qty"/></td>
		<td class="text"><july:stringwrite name="it" property="usn"/></td>
		<td class="text"><july:numberwrite name="it" property="price" fractdigits="2"/></td>
		<td class="text"><july:numberwrite name="it" property="sum" fractdigits="2"/></td>
		<td class="text"><july:stringwrite name="it" property="place"/></td>
		<%if(changable) {%>
		<td class="link"><july:delbutton page="/EditPositionInventoryItem.do?action=Delete" paramId="docposition" paramName="it_docposition" paramScope="page" /></td>
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
		<td width="98%"><nobr>
			<%if(changable) {%><july:addbutton page="/EditPositionInventoryItem.do?action=Add" alttext="label.invpos.add" onclick="return checkPosted();"/><%}%>
			<%if(changable) {%><html:link page="/InvLoadExcel.do?action=Add" paramId="doc" paramName="PositionInventory" paramProperty="document" paramScope="session" onclick="return checkPosted();"><img src="/images/loadexcel.gif" border="0" alt="Загрузка данных из Excel"></html:link><%}%>
			<%if(changable) {%><html:link page="/InvFillFromDB.do?action=Add" paramId="doc" paramName="PositionInventory" paramProperty="document" paramScope="session" onclick="return checkPosted();"><img src="/images/loaddb.gif" border="0" alt="Создать позиции по состоянию базы данных"></html:link><%}%>
			<%if(changable) {%><logic:equal name="PositionInventory" property="type" value="A"><html:link page="/InvLoadInv.do?action=Add" paramId="doc" paramName="PositionInventory" paramProperty="document" paramScope="session" onclick="return checkPosted();"><img src="/images/loadinv.gif" border="0" alt="Создать позиции из INV файла"></html:link><IMG SRC="/images/empty.gif" BORDER='0' ALT='' WIDTH='3'></logic:equal><%}%>
		</nobr></td>
		<td width="2%"class="title" align="right">&nbsp;</td>
	</tr>
	</table>
	</td>
</tr>

<%}%>

</table>

</july:editform>
