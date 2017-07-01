<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import="com.hps.july.inventory.formbean.ChangeEForm"%>

<%
	String masterTagId = "changeEFormWordEditMasterTagId";
%>
<july:wordEditMaster styleId='<%= masterTagId %>' >
</july:wordEditMaster>

<july:editform action="/ProcessChangeE.do">
<bean:define id="docCode" name="ChangeEForm" property="document" scope="session" type="java.lang.Integer"/>
<july:inventorycalcerrors document="<%=docCode%>"/>
<script language="javascript" src="/action.js"></script>
<%
	ChangeEForm frm = (ChangeEForm)request.getSession().getAttribute("ChangeEForm");
	boolean showpositions = "View".equals(frm.getAction()) || "Edit".equals(frm.getAction());
	boolean changable = "1".equals(frm.getDState()) && showpositions;
	String theDocCode = "";
	if (showpositions) {
		theDocCode = frm.getDocumentId().toString(); 
	}
	String mockIndex = frm.MOCK_DOC_ID;
%>

<html:hidden property="type" value="P"/>

<script language="javascript">
function switchLookup(itemname,lookupname,disabled) {
	if((ChangeEForm['action'].value == 'Add') || (ChangeEForm['action'].value == 'Edit'))
	{
		if(disabled) {
			ChangeEForm[itemname].className = 'editkoddisabled';
			ChangeEForm[itemname].disabled = true;
			ChangeEForm[itemname].readonly = true;
			document.all['lookupbtn_'+lookupname+'l'].disabled = true;
			document.all['lookupimg_'+lookupname+'l'].src='/images/lookup_disabled.gif';
		} else {
			ChangeEForm[itemname].className = 'editkod';
			ChangeEForm[itemname].disabled = false;
			ChangeEForm[itemname].readonly = false;
			document.all['lookupbtn_'+lookupname+'l'].disabled = false;
			document.all['lookupimg_'+lookupname+'l'].src='/images/lookup.gif';
		}
	}
}

function switchItem(itemname,state) {
	if((ChangeEForm['action'].value == 'Add') || (ChangeEForm['action'].value == 'Edit'))
	{
		if(state) {
			ChangeEForm[itemname].disabled = true;
			ChangeEForm[itemname].className = 'editdisabled';
		} else {
			ChangeEForm[itemname].disabled = false;
			ChangeEForm[itemname].className = 'edit';
		}
	}
}

function switchFilter() {
	if(ChangeEForm.type[0].checked) {
		switchLookup('organizationcode','org',false);
		switchLookup('workercode','work',true);
		ChangeEForm['organizationname'].disabled = false;
		ChangeEForm['workername'].disabled = true;
		ChangeEForm['workertitle'].disabled = true;
	} else
	if(ChangeEForm.type[1].checked) {
		switchLookup('organizationcode','org',true);
		switchLookup('workercode','work',false);
		ChangeEForm['organizationname'].disabled = true;
		ChangeEForm['workername'].disabled = false;
		ChangeEForm['workertitle'].disabled = false;
	} else {
		switchLookup('organizationcode','org',true);
		switchLookup('workercode','work',true);
		ChangeEForm['organizationname'].disabled = true;
		ChangeEForm['workername'].disabled = true;
		ChangeEForm['workertitle'].disabled = true;
	}
}

function printWord(prompt1){
	//Печать актов замены/модернизации:
	window.location.href='reports/changes.jsp?prompt1='+prompt1;
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
			<html:link page="/ProcessChangeE.do?action=Edit&processState=C" paramId="documentstr" paramName="ChangeEForm" paramProperty="documentstr" paramScope="session" onclick="return checkPosted();"><img src="/images/calculates.gif" border=0 alt="Снять обсчёт"></html:link>
		<%}%>
	<%}%>
	</july:formbuttons>

	<july:separator/>

    <tr>
        <td class="title" colspan="2"><july:actionalert/></td>
    </tr>

    <july:separator/>

    <tr>
        <td class="text"><july:reqmark><bean:message key="label.changee.num"/>:</july:reqmark></td>
        <td>
           <%-- <july:string property="blankindexFrm" size="15" insertable="true" updatable="true" /> --%>
	       <html:hidden property="blankindexFrm" value="<%=mockIndex%>" />
           <july:string property="blanknumber" size="15" insertable="true" updatable="true" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.changee.date"/>:</july:reqmark></td>
        <td>
			<july:date property="blankdatestr" styleId="blankdatestrctl" size="25" insertable="true" updatable="true" />
        </td>
    </tr>

    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.changee.owner"/>:</july:reqmark></td>
        <td>
			<july:select collection="owners" property="ownercode" insertable="true" updatable="true">
				<html:options collection="owners" property="organization" labelProperty="name"/>
			</july:select>
        </td>
    </tr>

    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.changee.organization"/>:</july:reqmark></td>
        <td>
			<july:string property="organizationcode" styleId="organizationcode" size="5" insertable="true" updatable="true" />
			<july:lookupbutton action="/ShowOrganizationLookupList.do" styleId="orgl" fieldNames="organizationcode;organizationname" newWindowName="organizationlookup"  insertable="true" updatable="true" onclick="set_opt_params_orgl('?selisprovider=true&selisrenter=false&selissupplier=false');" />
			<july:string size="35" property="organizationname" styleId="organizationname" insertable="false" updatable="false" />
        </td>
    </tr>

    <july:separator/>

    <tr>
        <td class="text">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<july:reqmark><bean:message key="label.external.insuranseman"/>:</july:reqmark></td>
        <td>
			<july:string size="35" property="insuranseMan" styleId="insuranseMan" insertable="true" updatable="true" />
        </td>
    </tr>

    <july:separator/>

    <tr>
        <td class="text"><july:reqmark><bean:message key="label.changee.worker"/>:</july:reqmark></td>
        <td nowrap>
			<july:string property="workercode" styleId="workercode" size="5" insertable="true" updatable="true" />
			<july:lookupbutton action="/ShowWorkerLookupList.do" styleId="workl" fieldNames="workercode;workername;workertitle" newWindowName="workerlookup"  insertable="true" updatable="true" />
			<july:string size="30" property="workername" styleId="workername" insertable="false" updatable="false" />
			<july:string size="20" property="workertitle" styleId="workertitle" insertable="false" updatable="false" />
        </td>
    </tr>

    <july:separator/>
    
    <tr>
        <td class="text"><bean:message key="label.changee.state"/>:</td>
        <td>
		   <logic:equal name="ChangeEForm" property="dState" value="1">
	           <bean:message key="label.state.entering"/>
           </logic:equal>
		   <logic:equal name="ChangeEForm" property="dState" value="2">
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
		<html:link page="/ProcessChangeE.do?action=Edit&processState=C" paramId="documentstr" paramName="ChangeEForm" paramProperty="documentstr" paramScope="session" onclick="return checkPosted();"><img src="/images/calculates.gif" border=0 alt="Снять обсчёт"></html:link>
	<%}%>
<%}%>
</july:formbuttons>
<%if(showpositions) {%> 
<july:separator/>
<tr class="title">
	<td colspan="2" class="title">
	<table cellpadding=0 cellspacing=0 width=100% border=0 class="main">
	<tr>
		<td><nobr><%if(changable) {%><july:addbutton page="/EditChangeEPosition.do?action=Add" alttext="label.changeepos.add" onclick="return checkPosted();"/><%}%></nobr></td>
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
		<july:headercolumn key="label.name" colType="string"/>
		<july:headercolumn key="label.changeepos.oldserial" colType="string"/>
		<july:headercolumn key="label.changeepos.newserial" colType="string"/>
		<%if(changable) {%><td class="title">&nbsp;</td><%}%>
	</tr>

	<logic:iterate id="it" name="ChangeEForm" property="listItems" type="com.hps.july.cdbc.lib.CDBCRowObject">
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
				<july:editbutton page="/EditChangeEPosition.do" action="Edit" paramId="code" paramName="changeactpos" paramScope="page" alttext="label.changeepos.edit"/>
			<%} else {%>
				<july:editbutton page="/EditChangeEPosition.do" action="View" paramId="code" paramName="changeactpos" paramScope="page" alttext="label.changeepos.view"/>
			<%}%>
		</td>
		<td class="text"><july:stringwrite name="it" property="nresname"/></td>
		<td class="text"><july:stringwrite name="oldserialnumber"/></td>
		<td class="text"><july:stringwrite name="serialnumber"/></td>
		<%if(changable) {%><td class="link"><july:delbutton page="/EditChangeEPosition.do?action=Delete" paramId="code" paramName="changeactpos" paramScope="page" /></td><%}%>
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
		<td><nobr><%if(changable) {%><july:addbutton page="/EditChangeEPosition.do?action=Add" alttext="label.changeepos.add" onclick="return checkPosted();"/><%}%></nobr></td>
		<td class="title" align="right">&nbsp;</td>
	</tr>
	</table>
	</td>
</tr>
<%}%>    
</table>

<script language="javascript">
//	switchFilter();
</script>

</july:editform>

