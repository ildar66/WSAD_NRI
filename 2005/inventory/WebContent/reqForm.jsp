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

<july:editform action="/ProcessReq.do">
<bean:define id="docCode" name="ReqForm" property="document" scope="session" type="java.lang.Integer"/>
<july:inventorycalcerrors document="<%=docCode%>"/>
<script language="javascript" src="/action.js"></script>
<script language="javascript">
function printWord(prompt1){
	//Печать актов требования на складе:
	window.location.href='reports/req.jsp?prompt1='+prompt1;
}
</script>
<%
	ReqForm frm = (ReqForm)request.getSession().getAttribute("ReqForm");
	boolean showpositions = "View".equals(frm.getAction()) || "Edit".equals(frm.getAction());
	boolean changable = "1".equals(frm.getDState()) && showpositions;
	String theDocCode = "";
	if (showpositions) {
		theDocCode = frm.getDocumentId().toString(); 
	}
	String mockIndex = frm.MOCK_DOC_ID;
%>

<script language="javascript">
function switchLookup(itemname,lookupname,disabled) {
	if((ReqForm['action'].value == 'Add') || (ReqForm['action'].value == 'Edit'))
	{
		if(disabled) {
			ReqForm[itemname].className = 'editkoddisabled';
			ReqForm[itemname].disabled = true;
			ReqForm[itemname].readonly = true;
			document.all['lookupbtn_'+lookupname+'l'].disabled = true;
			document.all['lookupimg_'+lookupname+'l'].src='/images/lookup_disabled.gif';
		} else {
			ReqForm[itemname].className = 'editkod';
			ReqForm[itemname].disabled = false;
			ReqForm[itemname].readonly = false;
			document.all['lookupbtn_'+lookupname+'l'].disabled = false;
			document.all['lookupimg_'+lookupname+'l'].src='/images/lookup.gif';
		}
	}
}

function switchItem(itemname,state) {
	if((ReqForm['action'].value == 'Add') || (ReqForm['action'].value == 'Edit'))
	{
		if(state) {
			ReqForm[itemname].disabled = true;
			ReqForm[itemname].className = 'editdisabled';
		} else {
			ReqForm[itemname].disabled = false;
			ReqForm[itemname].className = 'edit';
		}
	}
}

function switchFilter() {
	if(ReqForm.type[0].checked) {
		switchLookup('organizationcode','org',false);
		switchLookup('workercode','work1',true);
		ReqForm['organizationname'].disabled = false;
		ReqForm['workername'].disabled = true;
		ReqForm['workertitle'].disabled = true;
		switchItem('insuranseMan',false);
		switchItem('NAvto',false);
	} else
	if(ReqForm.type[1].checked) {
		switchLookup('organizationcode','org',true);
		switchLookup('workercode','work1',false);
		ReqForm['organizationname'].disabled = true;
		ReqForm['workername'].disabled = false;
		ReqForm['workertitle'].disabled = false;
		switchItem('insuranseMan',true);
		switchItem('NAvto',true);
	} else {
		switchLookup('organizationcode','org',true);
		switchLookup('workercode','work1',true);
		ReqForm['organizationname'].disabled = true;
		ReqForm['workername'].disabled = true;
		ReqForm['workertitle'].disabled = true;
		switchItem('insuranseMan',true);
		switchItem('NAvto',true);
	}
}
</script>

<html:hidden property="documentstr" />
<html:hidden property="expeditionstr" />
<html:hidden property="company" />
<html:hidden property="copydoc" />

<input type="hidden" name="processState" value="">

<table class="main">
    
    <july:separator/>
    
	<july:formbuttons>
	<%if(showpositions){%>
	<%--
	<A href='javascript:printWord(<%=docCode%>)'><img 
	src="/images/print.gif" border=0 alt='Напечатать акт'></A>
	--%>
		<july:wordEditSlave masterStyleId='<%= masterTagId %>' styleId='<%= "reqForm_" + theDocCode %>' 
		url='<%= "reports/req.jsp?prompt1=" + theDocCode %>' 
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
			<html:link page="/ProcessReq.do?action=Edit&processState=C" paramId="document" paramName="ReqForm" paramProperty="document" paramScope="session" onclick="return checkPosted();"><img src="/images/calculates.gif" border=0 alt="Снять обсчёт"></html:link>
		<%}%>
	<%}%>
	</july:formbuttons>

	<july:separator/>

    <tr>
        <td class="title" colspan="2"><july:actionalert/></td>
    </tr>

    <july:separator/>

    <tr>
        <td class="text"><july:reqmark><bean:message key="label.internal.owner"/>:</july:reqmark></td>
        <td>
			<july:select collection="owners" property="ownercode" insertable="true" updatable="true">
				<html:options collection="owners" property="organization" labelProperty="name"/>
			</july:select>
        </td>
    </tr>

    <july:separator/>

    <tr>
        <td class="text"><july:reqmark><bean:message key="label.req.division"/>:</july:reqmark></td>
        <td>
			<july:string property="divisioncode" styleId="divisioncode" size="5" insertable="true" updatable="true" styleId="editkodsearch"/>
			<july:lookupbutton action="/ShowDivisionLookupList.do" styleId="divl" fieldNames="divisioncode;divisionname" newWindowName="divisionslookup" insertable="true" updatable="true" onclick="set_opt_params_divl('?company='+document.all.company.value);"/>
			<july:string size="25" property="divisionname" styleId="divisionname" insertable="false" updatable="false" />
        </td>
    </tr>

    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.req.storage"/>:</july:reqmark></td>
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
        <td class="text"><july:reqmark><bean:message key="label.req.num"/>:</july:reqmark></td>
        <td>
           <%-- <july:string property="blankindexFrm" size="15" insertable="true" updatable="true" /> --%>
		   <html:hidden property="blankindexFrm" value="<%=mockIndex%>" />
           <july:string property="blanknumber" size="15" insertable="true" updatable="true" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.req.date"/>:</july:reqmark></td>
        <td>
			<july:date property="blankdatestr" styleId="blankdatestrctl" size="25" insertable="true" updatable="true" />
        </td>
    </tr>

    <july:separator/>
    
	<tr>
		<td class="text"><july:reqmark><bean:message key="label.req.type"/></july:reqmark>:</td>
		<td>
			<july:radio insertable="true" updatable="true" property="type" value="P" onclick="switchFilter();"/><bean:message key="label.acttype.forp"/>
			<july:radio insertable="true" updatable="true" property="type" value="W" onclick="switchFilter();"/><bean:message key="label.acttype.forw"/>
		</td>
	</tr>
    
    <july:separator/>

    <tr>
        <td class="text"><july:reqmark><bean:message key="label.req.organization"/></july:reqmark>:</td>
        <td>
			<july:string property="organizationcode" styleId="organizationcode" size="5" insertable="true" updatable="true" />
			<july:lookupbutton action="/ShowOrganizationLookupList.do" styleId="orgl" fieldNames="organizationcode;organizationname" newWindowName="organizationlookup"  onclick="set_opt_params_orgl('?selisprovider=true&selissupplier=false&selisrenter=false');" insertable="true" updatable="true"/>
			<july:string size="35" property="organizationname" styleId="organizationname" insertable="false" updatable="false" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text">&nbsp;&nbsp;&nbsp;<july:reqmark><bean:message key="label.req.representative"/></july:reqmark>:</td>
        <td>
			<july:string size="35" property="insuranseMan" insertable="true" updatable="true" />
        </td>
    </tr>

	<july:separator/>

	<tr>
		<td class="text">&nbsp;&nbsp;&nbsp;<bean:message key="label.req.nauto"/>:</td>
		<td>
			<july:string size="35" property="NAvto" insertable="true" updatable="true" />
		</td>
	</tr>

	<july:separator/>

	<tr>
		<td class="text"><july:reqmark><bean:message key="label.req.worker"/></july:reqmark>:</td>
		<td nowrap>
			<july:string property="workercode" styleId="workercode" size="5" insertable="true" updatable="true" />
			<july:lookupbutton action="/ShowWorkerLookupList.do" styleId="work1l" fieldNames="workercode;workername;workertitle" newWindowName="workerlookup"  insertable="true" updatable="true" />
			<july:string size="25" property="workername" styleId="workername" insertable="false" updatable="false" />
			<july:string size="20" property="workertitle" styleId="workertitle" insertable="false" updatable="false" />
		</td>
	</tr>

	<july:separator/>

	<tr>
		<td class="text"><bean:message key="label.req.position"/>:</td>
		<td>
			<july:string property="positioncode" styleId="positioncode" size="5" insertable="true" updatable="true" />
			<july:lookupbutton action="/ShowPositionLookupList.do" styleId="posl" fieldNames="positioncode;positionid;positionname" newWindowName="positionlookup"  insertable="true" updatable="true" />
			<july:string size="10" property="positionid" styleId="positionid" insertable="false" updatable="false" />
			<july:string size="25" property="positionname" styleId="positionname" insertable="false" updatable="false" />
        </td>
    </tr>
    
    <july:separator/>

    <tr>
        <td class="text"><july:reqmark><bean:message key="label.req.checker"/>:</july:reqmark></td>
        <td nowrap>
			<july:string property="checkercode" styleId="checkercode" size="5" insertable="true" updatable="true" />
			<july:lookupbutton action="/ShowWorkerLookupList.do" styleId="work2" fieldNames="checkercode;checkername;checkertitle" newWindowName="workerlookup"  insertable="true" updatable="true" />
			<july:string size="25" property="checkername" styleId="checkername" insertable="false" updatable="false" />
			<july:string size="20" property="checkertitle" styleId="checkertitle" insertable="false" updatable="false" />
        </td>
    </tr>
    
   <july:separator/>

    <tr>
        <td class="text"><bean:message key="label.req.sender"/>:</td>
        <td nowrap>
		<logic:present name="ReqForm" property="sender">
			<bean:write name="ReqForm" property="sendername" filter="true"/>,&nbsp;<bean:write name="ReqForm" property="sendertitle"/>
		</logic:present>
		<logic:notPresent name="ReqForm" property="sender">
			<bean:message key="label.req.notsend"/>
		</logic:notPresent>
<%--
			<july:string property="sendercode" styleId="sendercode" size="5" insertable="false" updatable="false" />
			<july:lookupbutton action="/ShowWorkerLookupList.do" styleId="work3" fieldNames="sendercode;sendername;sendertitle" newWindowName="workerlookup"  insertable="false" updatable="false" />
			<july:string size="25" property="sendername" styleId="sendername" insertable="false" updatable="false" />
			<july:string size="20" property="sendertitle" styleId="sendertitle" insertable="false" updatable="false" />
--%>
        </td>
</tr>
<july:separator/>
<tr>
	<td class="text"><bean:message key="label.req.state"/>:</td>
	<td>
		<%if("1".equals(frm.getDState())) {%><bean:message key="label.state.entering"/><%}%>
		<%if("2".equals(frm.getDState())) {%><bean:message key="label.state.calculated"/><%}%>
	</td>
</tr>
    
<july:separator/>
<july:formbuttons>
<%if(showpositions){%>
<%--
<A href='javascript:printWord(<%=docCode%>)'><img 
	src="/images/print.gif" border=0 alt='Напечатать акт'></A>
--%>	
		<july:wordEditSlave masterStyleId='<%= masterTagId %>' styleId='<%= "reqForm02_" + theDocCode %>' 
		url='<%= "reports/req.jsp?prompt1=" + theDocCode %>' 
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
		<html:link page="/ProcessReq.do?action=Edit&processState=C" paramId="document" paramName="ReqForm" paramProperty="document" paramScope="session" onclick="return checkPosted();"><img src="/images/calculates.gif" border=0 alt="Снять обсчёт"></html:link>
	<%}%>
<%}%>
</july:formbuttons>
<%if(showpositions) {%>
<july:separator/>
<tr class="title">
	<td colspan="2" class="title">
	<table cellpadding=0 cellspacing=0 width=100% border=0 class="main">
	<tr>
		<td><nobr><%if(changable) {%><july:addbutton page="/EditReqPosition.do?action=Add" alttext="label.reqpos.add" onclick="return checkPosted();"/><%}%></nobr></td>
		<td class="title" align="right"><bean:message key="label.req.positions"/></td>
	</tr>
	</table>
	</td>
</tr>
<july:separator/>
<tr><td colspan="2" style="padding:0px;">
	<table class="main">
	<tr class="title">
		<td class="title" rowspan="2"><bean:message key="label.void"/></td>
		<td class="title" rowspan="2"><bean:message key="label.num"/></td>
		<td class="title" rowspan="2"><bean:message key="label.reqpos.resource"/></td>
		<td class="title" colspan="2"><bean:message key="label.reqpos.qtytitle"/></td>
		<td class="title" rowspan="2"><bean:message key="label.reqpos.note"/></td>
		<%if(changable) {%><td class="title" rowspan="2">&nbsp;</td><%}%>
	</tr>
	<tr class="title">
		<td class="title"><bean:message key="label.reqpos.req"/></td>
		<td class="title"><bean:message key="label.reqpos.send"/></td>
	</tr>

	<logic:iterate id="it" name="ReqForm" property="listItems" type="com.hps.july.cdbc.lib.CDBCRowObject">
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
			<%if(changable) {%>
				<july:editbutton page="/EditReqPosition.do" action="Edit" paramId="docposition" paramName="docposition" paramScope="page" alttext="label.reqpos.edit"/>
			<%}%>
		</td>
		<td class="text"><july:stringwrite name="it" property="order"/></td>
		<td class="text"><july:stringwrite name="it" property="name"/><%if(!"".equals(it.getColumn("model").asString())){%>,<br><july:stringwrite name="it" property="model"/><%}%></td>
		<td class="text"><july:numberwrite name="it" property="qty" /></td>
		<td class="text"><july:numberwrite name="it" property="sendqty" /></td>
		<td class="text"><july:stringwrite name="it" property="notes"/></td>
		<%if(changable) {%><td class="link"><july:delbutton page="/EditReqPosition.do?action=Delete" paramId="docposition" paramName="docposition" paramScope="page" /></td><%}%>
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
		<td><nobr><%if(changable) {%><july:addbutton page="/EditReqPosition.do?action=Add" alttext="label.reqpos.add" onclick="return checkPosted();"/><%}%></nobr></td>
		<td class="title" align="right">&nbsp;</td>
	</tr>
	</table>
	</td>
</tr>
<%}%>    
</table>

<script language="javascript">switchFilter();</script>

</july:editform>

