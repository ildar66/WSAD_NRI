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

<july:editform action="/ProcessChangeS.do">
<bean:define id="docCode" name="ChangeSForm" property="document" scope="session" type="java.lang.Integer"/>
<july:inventorycalcerrors document="<%=docCode%>"/>
<script language="javascript" src="/action.js"></script>
<%
	ChangeSForm frm = (ChangeSForm)request.getSession().getAttribute("ChangeSForm");
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
	if((ChangeSForm['action'].value == 'Add') || (ChangeSForm['action'].value == 'Edit'))
	{
		if(disabled) {
			ChangeSForm[itemname].className = 'editkoddisabled';
			ChangeSForm[itemname].disabled = true;
			ChangeSForm[itemname].readonly = true;
			document.all['lookupbtn_'+lookupname+'l'].disabled = true;
			document.all['lookupimg_'+lookupname+'l'].src='/images/lookup_disabled.gif';
		} else {
			ChangeSForm[itemname].className = 'editkod';
			ChangeSForm[itemname].disabled = false;
			ChangeSForm[itemname].readonly = false;
			document.all['lookupbtn_'+lookupname+'l'].disabled = false;
			document.all['lookupimg_'+lookupname+'l'].src='/images/lookup.gif';
		}
	}
}

function switchItem(itemname,state) {
	if((ChangeSForm['action'].value == 'Add') || (ChangeSForm['action'].value == 'Edit'))
	{
		if(state) {
			ChangeSForm[itemname].disabled = true;
			ChangeSForm[itemname].className = 'editdisabled';
		} else {
			ChangeSForm[itemname].disabled = false;
			ChangeSForm[itemname].className = 'edit';
		}
	}
}
function printWord(prompt1){
	//Печать актов замены/модернизации:
	window.location.href='reports/changes.jsp?prompt1='+prompt1;
}
</script>

<html:hidden property="documentstr" />
<input type="hidden" name="processState" value="">

<table class="main">

	<july:separator/>
		
	<july:formbuttons>
	<%if(showpositions){%>
	<%--
		<A href='javascript:printWord(<%=docCode%>)'><img 
		src="/images/print.gif" border=0 alt='Напечатать акт инвентаризации'></A>
	--%>
		<july:wordEditSlave masterStyleId='<%= masterTagId %>' styleId='<%= "changeSForm_" + theDocCode %>' 
		url='<%= "reports/changes.jsp?prompt1=" + theDocCode %>' 
			uploadurl=''
			updatable='false'
		documentid='<%= theDocCode %>'><IMG SRC="/images/docword.gif" border="0" alt='Напечатать акт замены'></july:wordEditSlave>
	<%}%>
	<%if(("View".equals(frm.getAction()) || "Edit".equals(frm.getAction())) && !frm.getIsautodoc()){%>
	&nbsp;&nbsp;
		<%if("1".equals(frm.getDState())) {%>
			<input type="image" name="submit" src="/images/calculate.gif" onclick="document.all.action.value='Edit';document.all.processState.value='P';return checkPosted();" title="Обсчёт">
		<%} else {%>
			<html:link page="/ProcessChangeS.do?action=Edit&processState=C" paramId="documentstr" paramName="ChangeSForm" paramProperty="documentstr" paramScope="session" onclick="return checkPosted();"><img src="/images/calculates.gif" border=0 alt="Снять обсчёт"></html:link>
		<%}%>
	<%}%>
	</july:formbuttons>
	
	<july:separator/>

	<tr>
		<td class="title" colspan="2"><july:actionalert/></td>
	</tr>

	<july:separator/>

	<tr>
        	<td class="text"><july:reqmark><bean:message key="label.changes.owner"/>:</july:reqmark></td>
	        <td>
			<july:select collection="owners" property="ownercode" insertable="true" updatable="true">
				<html:options collection="owners" property="organization" labelProperty="name"/>
			</july:select>
		</td>
	</tr>

	<july:separator/>

	<tr>
		<td class="text"><july:reqmark><bean:message key="label.changes.num"/>:</july:reqmark></td>
		<td>
			<%-- <july:string property="blankindexFrm" size="15" insertable="true" updatable="true" /> --%>
	    	<html:hidden property="blankindexFrm" value="<%=mockIndex%>" />
			<july:string property="blanknumber" size="15" insertable="true" updatable="true" />
		</td>
	</tr>

	<july:separator/>

	<tr>
		<td class="text"><july:reqmark><bean:message key="label.changes.date"/>:</july:reqmark></td>
		<td>
			<july:date property="blankdatestr" styleId="blankdatestrctl" size="25" insertable="true" updatable="true" />
		</td>
	</tr>

	<july:separator/>

	<tr>
		<td class="text"><july:reqmark><bean:message key="label.changes.storage"/>:</july:reqmark></td>
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
		<td class="text"><bean:message key="label.changes.acttype"/></td>
		<td>
			<july:radio insertable="true" updatable="false" property="acttype" value="C" styleClass="text"/><bean:message key="label.changepos.acttype.change"/>
			<july:radio insertable="true" updatable="false" property="acttype" value="U" styleClass="text"/><bean:message key="label.changepos.acttype.upgrade"/>
		</td>
	</tr>

	<july:separator/>

	<tr>
		<td class="text"><july:reqmark><bean:message key="label.changes.storageman"/>:</july:reqmark></td>
		<td nowrap>
			<july:string property="storagemancode" styleId="storagemancode" size="5" insertable="true" updatable="true" />
			<july:lookupbutton action="/ShowWorkerLookupList.do" styleId="work" fieldNames="storagemancode;storagemanname;storagemantitle" newWindowName="workerlookup" insertable="true" updatable="true" />
			<july:string size="25" property="storagemanname" styleId="storagemanname" insertable="false" updatable="false" />
			<july:string size="20" property="storagemantitle" styleId="storagemantitle" insertable="false" updatable="false" />
		</td>
	</tr>

	<july:separator/>

	<tr>
		<td class="text"><bean:message key="label.changes.state"/>:</td>
		<td>
			<logic:equal name="ChangeSForm" property="dState" value="1"><bean:message key="label.state.entering"/></logic:equal>
			<logic:equal name="ChangeSForm" property="dState" value="2"><bean:message key="label.state.calculated"/></logic:equal>
		</td>
	</tr>

<july:separator/>
<july:formbuttons>
<%if(showpositions){%>
<%--
		<A href='javascript:printWord(<%=docCode%>)'><img 
		src="/images/print.gif" border=0 alt='Напечатать акт инвентаризации'></A>
--%>
	<july:wordEditSlave masterStyleId='<%= masterTagId %>' styleId='<%= "changeSForm02_" + theDocCode %>' 
		url='<%= "reports/changes.jsp?prompt1=" + theDocCode %>' 
			uploadurl=''
			updatable='false'
		documentid='<%= theDocCode %>'><IMG SRC="/images/docword.gif" border="0" alt='Напечатать акт замены'></july:wordEditSlave>
<%}%>
<%if(("View".equals(frm.getAction()) || "Edit".equals(frm.getAction())) && !frm.getIsautodoc()){%>
&nbsp;&nbsp;
	<%if("1".equals(frm.getDState())) {%>
		<input type="image" name="submit" src="/images/calculate.gif" onclick="document.all.action.value='Edit';document.all.processState.value='P';return checkPosted();" title="Обсчёт">
	<%} else {%>
		<html:link page="/ProcessChangeS.do?action=Edit&processState=C" paramId="documentstr" paramName="ChangeSForm" paramProperty="documentstr" paramScope="session" onclick="return checkPosted();"><img src="/images/calculates.gif" border=0 alt="Снять обсчёт"></html:link>
	<%}%>
<%}%>
</july:formbuttons>
<%if(showpositions) {%>
<july:separator/>
<tr class="title">
	<td colspan="2" class="title">
	<table cellpadding=0 cellspacing=0 width=100% border=0 class="main">
	<tr>
		<td><nobr><%if(changable) {%><july:addbutton page="/EditChangeSPosition.do?action=Add" alttext="label.changeppos.add" onclick="return checkPosted();"/><%}%></nobr></td>
		<td class="title" align="right">
			<bean:message key="label.change.positions"/>
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
		<july:headercolumn key="label.changeppos.resource" colType="string"/>
		<july:headercolumn key="label.changeppos.oldserial" colType="string"/>
		<july:headercolumn key="label.changeppos.newresource" colType="string"/>
		<july:headercolumn key="label.changeppos.newserial" colType="string"/>
		<%if(changable) {%><td class="title">&nbsp;</td><%}%>
	</tr>

	<logic:iterate id="it" name="ChangeSForm" property="listItems" type="com.hps.july.cdbc.lib.CDBCRowObject">
	<logic:present name="it">
	<%
		pageContext.setAttribute("changeactpos",it.getColumn("changeactpos").asString());

		String serialnumber = it.getColumn("newserial").asString();
		if(serialnumber != null && !"".equals(serialnumber)) {
			String manufserial = it.getColumn("manufserial").asString();
			if(manufserial != null && !"".equals(manufserial) && !serialnumber.equals(manufserial) ) {
				serialnumber += " ("+manufserial+")";
			}
			pageContext.setAttribute("serialnumber",serialnumber);
		}
		String oldserialnumber = it.getColumn("oldserial").asString();
		if(oldserialnumber != null && !"".equals(oldserialnumber)) {
			String oldmanufserial = it.getColumn("oldmanufserial").asString();
			if(oldmanufserial != null && !"".equals(oldmanufserial) && !oldserialnumber.equals(oldmanufserial) ) {
				oldserialnumber += " ("+oldmanufserial+")";
			}
			pageContext.setAttribute("oldserialnumber",oldserialnumber);
		}
	%>
	<tr class="normal" onMouseOver="className='select';" onMouseOut="className='normal';">
		<td class="link">
			<%if(changable) {%>
				<july:editbutton page="/EditChangeSPosition.do" action="Edit" paramId="code" paramName="changeactpos" paramScope="page" alttext="label.changespos.edit"/>
			<%} else {%>
				<july:editbutton page="/EditChangeSPosition.do" action="View" paramId="code" paramName="changeactpos" paramScope="page" alttext="label.changespos.view"/>
			<%}%>
		</td>
		<td class="text"><july:stringwrite name="it" property="oresname"/></td>
		<td class="text"><july:stringwrite name="oldserialnumber"/></td>
		<td class="text"><july:stringwrite name="it" property="nresname"/></td>
		<td class="text"><july:stringwrite name="serialnumber"/></td>
		<%if(changable) {%><td class="link"><july:delbutton page="/EditChangeSPosition.do?action=Delete" paramId="code" paramName="changeactpos" paramScope="page" /></td><%}%>
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
		<td><nobr><%if(changable) {%><july:addbutton page="/EditChangeSPosition.do?action=Add" alttext="label.changespos.add" onclick="return checkPosted();"/><%}%></nobr></td>
		<td class="title" align="right">&nbsp;</td>
	</tr>
	</table>
	</td>
</tr>
<%}%>
<july:separator/>

</table>

</july:editform>

