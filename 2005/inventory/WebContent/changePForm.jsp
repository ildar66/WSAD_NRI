<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import="com.hps.july.inventory.formbean.ChangePForm"%>

<%
	String masterTagId = "changePFormWordEditMasterTagId";
%>
<july:wordEditMaster styleId='<%= masterTagId %>' >
</july:wordEditMaster>

<july:editform action="/ProcessChangeP.do">
<bean:define id="docCode" name="ChangePForm" property="document" scope="session" type="java.lang.Integer"/>
<july:inventorycalcerrors document="<%=docCode%>"/>
<script language="javascript" src="/action.js"></script>
<%
	ChangePForm frm = (ChangePForm)request.getSession().getAttribute("ChangePForm");
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
	if((ChangePForm['action'].value == 'Add') || (ChangePForm['action'].value == 'Edit'))
	{
		if(disabled) {
			ChangePForm[itemname].className = 'editkoddisabled';
			ChangePForm[itemname].disabled = true;
			ChangePForm[itemname].readonly = true;
			document.all['lookupbtn_'+lookupname+'l'].disabled = true;
			document.all['lookupimg_'+lookupname+'l'].src='/images/lookup_disabled.gif';
		} else {
			ChangePForm[itemname].className = 'editkod';
			ChangePForm[itemname].disabled = false;
			ChangePForm[itemname].readonly = false;
			document.all['lookupbtn_'+lookupname+'l'].disabled = false;
			document.all['lookupimg_'+lookupname+'l'].src='/images/lookup.gif';
		}
	}
}

function switchItem(itemname,state) {
	if((ChangePForm['action'].value == 'Add') || (ChangePForm['action'].value == 'Edit'))
	{
		if(state) {
			ChangePForm[itemname].disabled = true;
			ChangePForm[itemname].className = 'editdisabled';
		} else {
			ChangePForm[itemname].disabled = false;
			ChangePForm[itemname].className = 'edit';
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
	src="/images/print.gif" border=0 alt='Напечатать акт'></A>
--%>	
	<july:wordEditSlave masterStyleId='<%= masterTagId %>' styleId='<%= "changeEForm_" + theDocCode %>' 
		url='<%= "reports/changes.jsp?prompt1=" + theDocCode %>' 
			uploadurl=''
			updatable='false'
		documentid='<%= theDocCode %>'><IMG SRC="/images/docword.gif" border="0" alt='Напечатать акт'></july:wordEditSlave>
<%}%>
<%if(("View".equals(frm.getAction()) || "Edit".equals(frm.getAction())) && !frm.getIsautodoc()){%>
&nbsp;&nbsp;
	<%if("1".equals(frm.getDState())) {%>
		<input type="image" name="submit" src="/images/calculate.gif" onclick="document.all.action.value='Edit';document.all.processState.value='P';return checkPosted();" title="Обсчёт">
	<%} else {%>
		<html:link page="/ProcessChangeP.do?action=Edit&processState=C" paramId="documentstr" paramName="ChangePForm" paramProperty="documentstr" paramScope="session" onclick="return checkPosted();"><img src="/images/calculates.gif" border=0 alt="Снять обсчёт"></html:link>
	<%}%>
<%}%>
</july:formbuttons>

<july:separator/>

<tr>
	<td class="title" colspan="2"><july:actionalert/></td>
</tr>
<july:separator/>
<tr>
	<td class="text"><july:reqmark><bean:message key="label.changep.owner"/>:</july:reqmark></td>
	<td>
		<july:select collection="owners" property="ownercode" insertable="true" updatable="true">
		<html:options collection="owners" property="organization" labelProperty="name"/>
		</july:select>
	</td>
</tr>
<july:separator/>
<tr>
	<td class="text"><july:reqmark><bean:message key="label.changep.num"/>:</july:reqmark></td>
	<td>
		<%-- <july:string property="blankindexFrm" size="15" insertable="true" updatable="true" /> --%>
        <html:hidden property="blankindexFrm" value="<%=mockIndex%>" />
		<july:string property="blanknumber" size="15" insertable="true" updatable="true" />
        </td>
</tr>
<july:separator/>
<tr>
	<td class="text"><july:reqmark><bean:message key="label.changep.date"/>:</july:reqmark></td>
	<td>
		<july:date property="blankdatestr" styleId="blankdatestrctl" size="25" insertable="true" updatable="true" />
	</td>
</tr>
<july:separator/>
<tr>
	<td class="text"><july:reqmark><bean:message key="label.changep.position"/>:</july:reqmark></td>
	<td>
		<july:string property="positioncode" styleId="positioncode" size="5" insertable="true" updatable="true" />
		<july:lookupbutton action="/ShowPositionLookupList.do" styleId="posl" fieldNames="positioncode;positionid;positionname;complectcode;complectname" newWindowName="poslookup" insertable="true" updatable="true" />
		<july:string size="10" property="positionid" styleId="positionid" insertable="false" updatable="false" />
		<july:string size="25" property="positionname" styleId="positionname" insertable="false" updatable="false" />
	</td>
</tr>
<july:separator/>
<tr>
	<td class="text"><july:reqmark><bean:message key="label.changep.complect"/>:</july:reqmark></td>
	<td>
		<html:hidden property="complectcode"/>
		<july:string size="35" property="complectname" styleId="complectname" insertable="false" updatable="false" />
		<july:lookupbutton action="/ShowComplectLookupList.do" styleId="coml" fieldNames="complectcode;complectname" newWindowName="poslookup" insertable="true" updatable="true" onclick="set_opt_params_coml('?position='+document.all.positioncode.value)"/>
	</td>
</tr>
<july:separator/>
<tr>
	<td class="text"><bean:message key="label.changep.acttype"/></td>
	<td>
		<july:radio insertable="true" updatable="false" property="acttype" value="C" styleClass="text"/><bean:message key="label.changepos.acttype.change"/>
		<july:radio insertable="true" updatable="false" property="acttype" value="U" styleClass="text"/><bean:message key="label.changepos.acttype.upgrade"/>
	</td>
</tr>
<july:separator/>
<tr>
	<td class="text"><july:reqmark><bean:message key="label.changep.tech"/></july:reqmark>:</td>
	<td nowrap>
		<july:string property="techcode" styleId="techcode" size="5" insertable="true" updatable="true" />
		<july:lookupbutton action="/ShowWorkerLookupList.do" styleId="techl" fieldNames="techcode;techname;techtitle" newWindowName="workerlookup"  insertable="true" updatable="true" />
		<july:string size="25" property="techname" styleId="techname" insertable="false" updatable="false" />
		<july:string size="20" property="techtitle" styleId="techtitle" insertable="false" updatable="false" />
	</td>
</tr>
<july:separator/>
<tr>
	<td class="text"><bean:message key="label.changep.state"/>:</td>
	<td>
		<logic:equal name="ChangePForm" property="dState" value="1"><bean:message key="label.state.entering"/></logic:equal>
		<logic:equal name="ChangePForm" property="dState" value="2"><bean:message key="label.state.calculated"/></logic:equal>
	</td>
</tr>
<july:separator/>
<july:formbuttons>
<%if(showpositions){%>
<%--
<A href='javascript:printWord(<%=docCode%>)'><img 
	src="/images/print.gif" border=0 alt='Напечатать акт'></A>
--%>	
	<july:wordEditSlave masterStyleId='<%= masterTagId %>' styleId='<%= "changeEForm02_" + theDocCode %>' 
		url='<%= "reports/changes.jsp?prompt1=" + theDocCode %>' 
			uploadurl=''
			updatable='false'
		documentid='<%= theDocCode %>'><IMG SRC="/images/docword.gif" border="0" alt='Напечатать акт'></july:wordEditSlave>
<%}%>
<%if(("View".equals(frm.getAction()) || "Edit".equals(frm.getAction())) && !frm.getIsautodoc()){%>
&nbsp;&nbsp;
	<%if("1".equals(frm.getDState())) {%>
		<input type="image" name="submit" src="/images/calculate.gif" onclick="document.all.action.value='Edit';document.all.processState.value='P';return checkPosted();" title="Обсчёт">
	<%} else {%>
		<html:link page="/ProcessChangeP.do?action=Edit&processState=C" paramId="documentstr" paramName="ChangePForm" paramProperty="documentstr" paramScope="session" onclick="return checkPosted();"><img src="/images/calculates.gif" border=0 alt="Снять обсчёт"></html:link>
	<%}%>
<%}%>
</july:formbuttons>
<%if(showpositions) {%>
<july:separator/>
<tr class="title">
	<td colspan="2" class="title">
	<table cellpadding=0 cellspacing=0 width=100% border=0 class="main">
	<tr>
		<td><nobr><%if(changable) {%><july:addbutton page="/EditChangePPosition.do?action=Add" alttext="label.changeppos.add" onclick="return checkPosted();"/><%}%></nobr></td>
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

	<logic:iterate id="it" name="ChangePForm" property="listItems" type="com.hps.july.cdbc.lib.CDBCRowObject">
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
				<july:editbutton page="/EditChangePPosition.do" action="Edit" paramId="code" paramName="changeactpos" paramScope="page" alttext="label.changeppos.edit"/>
			<%} else {%>
				<july:editbutton page="/EditChangePPosition.do" action="View" paramId="code" paramName="changeactpos" paramScope="page" alttext="label.changeppos.view"/>
			<%}%>
		</td>
		<td class="text"><july:stringwrite name="it" property="oresname"/></td>
		<td class="text"><july:stringwrite name="oldserialnumber"/></td>
		<td class="text"><july:stringwrite name="it" property="nresname"/></td>
		<td class="text"><july:stringwrite name="serialnumber"/></td>
		<%if(changable) {%><td class="link"><july:delbutton page="/EditChangePPosition.do?action=Delete" paramId="code" paramName="changeactpos" paramScope="page" /></td><%}%>
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
		<td><nobr><%if(changable) {%><july:addbutton page="/EditChangePPosition.do?action=Add" alttext="label.changeppos.add" onclick="return checkPosted();"/><%}%></nobr></td>
		<td class="title" align="right">&nbsp;</td>
	</tr>
	</table>
	</td>
</tr>
<%}%>    
</table>
</july:editform>

