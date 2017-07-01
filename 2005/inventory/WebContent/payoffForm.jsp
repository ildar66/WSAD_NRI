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

<july:editform action="/ProcessPayoff.do">
<bean:define id="docCode" name="PayoffForm" property="document" scope="session" type="java.lang.Integer"/>
<july:inventorycalcerrors document="<%=docCode%>"/>
<script language="javascript" src="/action.js"></script>
<script language="javascript">
function printWord(prompt1){
	//Печать актов списания на складе:
	window.location.href='reports/payoff.jsp?prompt1='+prompt1;
}
</script>
<%
	PayoffForm frm = (PayoffForm)request.getSession().getAttribute("PayoffForm");
	boolean showpositions = "View".equals(frm.getAction()) || "Edit".equals(frm.getAction());
	boolean changable = "1".equals(frm.getDState()) && !frm.getIsautodoc() && showpositions;
	String theDocCode = "";
	if (showpositions) {
		theDocCode = frm.getDocumentId().toString(); 
	}
	String mockIndex = frm.MOCK_DOC_ID;
%>

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
		<july:wordEditSlave masterStyleId='<%= masterTagId %>' styleId='<%= "payoffForm_" + theDocCode %>' 
		url='<%= "reports/payoff.jsp?prompt1=" + theDocCode %>' 
			uploadurl=''
			updatable='false'
		documentid='<%= theDocCode %>'><IMG SRC="/images/docword.gif" border="0" alt='Напечатать акт'></july:wordEditSlave>
	<%}%>
	<%if(("View".equals(frm.getAction()) || "Edit".equals(frm.getAction())) && !frm.getIsautodoc()){%>
	&nbsp;&nbsp;
		<%if("1".equals(frm.getDState())) {%>
			<input type="image" name="submit" src="/images/calculate.gif" onclick="document.all.action.value='Edit';document.all.processState.value='P';return checkPosted();" title="Обсчёт">
		<%} else {%>
			<html:link page="/ProcessPayoff.do?action=Edit&processState=C" paramId="document" paramName="PayoffForm" paramProperty="documentstr" paramScope="session" onclick="return checkPosted();"><img src="/images/calculates.gif" border=0 alt="Снять обсчёт"></html:link>
		<%}%>
	<%}%>
	</july:formbuttons>

	<july:separator/>

    <tr>
        <td class="title" colspan="2"><july:actionalert/></td>
    </tr>

    <july:separator/>

    <tr>
        <td class="text"><july:reqmark><bean:message key="label.payoff.owner"/>:</july:reqmark></td>
        <td>
			<july:select collection="owners" property="ownercode" insertable="true" updatable="true">
				<html:options collection="owners" property="organization" labelProperty="name"/>
			</july:select>
        </td>
    </tr>

    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.payoff.storage"/>:</july:reqmark></td>
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
        <td class="text"><july:reqmark><bean:message key="label.payoff.num"/>:</july:reqmark></td>
        <td>
           <%-- <july:string property="blankindexFrm" size="15" insertable="true" updatable="true" /> --%>
		   <html:hidden property="blankindexFrm" value="<%=mockIndex%>" />
           <july:string property="blanknumber" size="15" insertable="true" updatable="true" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.payoff.date"/>:</july:reqmark></td>
        <td>
			<july:date property="blankdatestr" styleId="blankdatestrctl" size="25" insertable="true" updatable="true" />
        </td>
    </tr>

    <july:separator/>

    <tr>
        <td class="text"><july:reqmark><bean:message key="label.payoff.worker1"/>:</july:reqmark></td>
        <td nowrap>
			<july:string property="worker1code" styleId="worker1code" size="5" insertable="true" updatable="true" />
			<july:lookupbutton action="/ShowWorkerLookupList.do" styleId="work1l" fieldNames="worker1code;worker1name;worker1title" newWindowName="workerlookup"  insertable="true" updatable="true" />
			<july:string size="25" property="worker1name" styleId="worker1name" insertable="false" updatable="false" />
			<july:string size="20" property="worker1title" styleId="worker1title" insertable="false" updatable="false" />
        </td>
    </tr>

    <july:separator/>
    
    <tr>
        <td class="text"><bean:message key="label.payoff.worker2"/></td>
        <td nowrap>
			<july:string property="worker2code" styleId="worker2code" size="5" insertable="true" updatable="true" />
			<july:lookupbutton action="/ShowWorkerLookupList.do" styleId="work2l" fieldNames="worker2code;worker2name;worker2title" newWindowName="workerlookup"  insertable="true" updatable="true" />
			<july:string size="25" property="worker2name" styleId="worker2name" insertable="false" updatable="false" />
			<july:string size="20" property="worker2title" styleId="worker2title" insertable="false" updatable="false" />
        </td>
    </tr>

    <july:separator/>

    <tr>
        <td class="text"><bean:message key="label.payoff.worker3"/></td>
        <td nowrap>
			<july:string property="worker3code" styleId="worker3code" size="5" insertable="true" updatable="true" />
			<july:lookupbutton action="/ShowWorkerLookupList.do" styleId="work3l" fieldNames="worker3code;worker3name;worker3title" newWindowName="workerlookup"  insertable="true" updatable="true" />
			<july:string size="25" property="worker3name" styleId="worker3name" insertable="false" updatable="false" />
			<july:string size="20" property="worker3title" styleId="worker3title" insertable="false" updatable="false" />
        </td>
    </tr>

    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.payoff.worker4"/>:</july:reqmark></td>
        <td nowrap>
			<july:string property="worker4code" styleId="worker4code" size="5" insertable="true" updatable="true" />
			<july:lookupbutton action="/ShowWorkerLookupList.do" styleId="work4l" fieldNames="worker4code;worker4name;worker4title" newWindowName="workerlookup"  insertable="true" updatable="true" />
			<july:string size="25" property="worker4name" styleId="worker4name" insertable="false" updatable="false" />
			<july:string size="20" property="worker4title" styleId="worker4title" insertable="false" updatable="false" />
        </td>
    </tr>

    <july:separator/>

    <tr>
        <td class="text"><bean:message key="label.payoff.state"/>:</td>
        <td>
		   <logic:equal name="PayoffForm" property="dState" value="1">
	           <bean:message key="label.state.entering"/>
           </logic:equal>
		   <logic:equal name="PayoffForm" property="dState" value="2">
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
		<july:wordEditSlave masterStyleId='<%= masterTagId %>' styleId='<%= "payoffForm02_" + theDocCode %>' 
		url='<%= "reports/payoff.jsp?prompt1=" + theDocCode %>' 
			uploadurl=''
			updatable='false'
		documentid='<%= theDocCode %>'><IMG SRC="/images/docword.gif" border="0" alt='Напечатать акт'></july:wordEditSlave>
<%}%>
<%if(("View".equals(frm.getAction()) || "Edit".equals(frm.getAction())) && !frm.getIsautodoc()){%>
&nbsp;&nbsp;
	<%if("1".equals(frm.getDState())) {%>
		<input type="image" name="submit" src="/images/calculate.gif" onclick="document.all.action.value='Edit';document.all.processState.value='P';return checkPosted();" title="Обсчёт">
	<%} else {%>
		<html:link page="/ProcessPayoff.do?action=Edit&processState=C" paramId="document" paramName="PayoffForm" paramProperty="documentstr" paramScope="session" onclick="return checkPosted();"><img src="/images/calculates.gif" border=0 alt="Снять обсчёт"></html:link>
	<%}%>
<%}%>
</july:formbuttons>
<%if(showpositions) {%>
<july:separator/>
<tr class="title">
	<td colspan="2" class="title">
	<table cellpadding=0 cellspacing=0 width=100% border=0 class="main">
	<tr>
		<td><nobr><%if(changable) {%><july:addbutton page="/EditPayoffPosition.do?action=Add" alttext="label.payoffpos.add" onclick="return checkPosted();"/><%}%></nobr></td>
		<td class="title" align="right">
			<bean:message key="label.payoff.positions"/>
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
		<july:headercolumn key="label.payoff.numpp" colType="number"/>
		<july:headercolumn key="label.payoff.name" colType="string"/>
		<july:headercolumn key="label.payoff.blocktype" colType="string"/>
		<july:headercolumn key="label.payoff.policynum" colType="string"/>
		<july:headercolumn key="label.payoff.qty.short" colType="number"/>
		<july:headercolumn key="label.payoff.price" colType="string"/>
		<july:headercolumn key="label.payoff.sum" colType="string"/>
		<%if(changable) {%><td class="title">&nbsp;</td><%}%>
	</tr>

	<logic:iterate id="it" name="PayoffForm" property="listItems" type="com.hps.july.cdbc.lib.CDBCRowObject">
	<logic:present name="it">
	<%
		pageContext.setAttribute("docposition",it.getColumn("docposition").asString());
/*
		String cp = it.getColumn("countpolicy").asString();
		String serialnumber = "";
		if("S".equals(cp)) {
			serialnumber = it.getColumn("serial").asString();
			if(serialnumber != null) {
				String manufserial = it.getColumn("manufserial").asString();
				if(manufserial != null && !"".equals(manufserial) && !serialnumber.equals(manufserial) ) {
					serialnumber += " ("+manufserial+")";
				}
			}
		} else if("P".equals(cp)) {
			serialnumber = it.getColumn("party").asString();
		}
		pageContext.setAttribute("serialnumber",serialnumber);
*/
	%>
	<tr class="normal" onMouseOver="className='select';" onMouseOut="className='normal';">
		<td class="string">
			<%if(changable) {%>
				<july:editbutton page="/EditPayoffPosition.do" action="Edit" paramId="docposition" paramName="docposition" paramScope="page" alttext="label.payoffpos.edit"/>
			<%} else {%>
				<july:editbutton page="/EditPayoffPosition.do" action="View" paramId="docposition" paramName="docposition" paramScope="page" alttext="label.payoffpos.view"/>
			<%}%>
		</td>
		<td class="number"><july:stringwrite name="it" property="order"/></td>
		<td class="text"><july:stringwrite name="it" property="name"/></td>
		<td class="text"><july:stringwrite name="it" property="model"/></td>
		<td class="text"><july:stringwrite name="it" property="invnum"/></td>
		<td class="text"><july:numberwrite name="it" property="qty"/> <july:stringwrite name="it" property="unitname"/></td>
		<td class="number" align="right"><july:numberwrite name="it" property="price" fractdigits="2"/></td>
		<td class="number" align="right"><july:numberwrite name="it" property="summ" fractdigits="2"/></td>
		<%if(changable) {%><td class="link"><july:delbutton page="/EditPayoffPosition.do?action=Delete" paramId="docposition" paramName="docposition" paramScope="page" /></td><%}%>
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
		<td><nobr><%if(changable) {%><july:addbutton page="/EditPayoffPosition.do?action=Add" alttext="label.payoffpos.add" onclick="return checkPosted();"/><%}%></nobr></td>
		<td class="title" align="right">&nbsp;</td>
	</tr>
	</table>
	</td>
</tr>
<%}%>
</table>

</july:editform>

