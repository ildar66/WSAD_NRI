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

<july:editform action="/ProcessDAssact.do">
<bean:define id="docCode" name="DAssactForm" property="document" scope="session" type="java.lang.Integer"/>
<july:inventorycalcerrors document="<%=docCode%>"/>
<script language="javascript" src="/action.js"></script>
<script language="javascript">
function printWord(prompt1){
	//Печать актов монтажа блоков на складе:
	window.location.href='reports/dassact.jsp?prompt1='+prompt1;
}
</script>
<%
	DAssactForm frm = (DAssactForm)request.getSession().getAttribute("DAssactForm");
	boolean showpositions = "View".equals(frm.getAction()) || "Edit".equals(frm.getAction());
	boolean changable = "1".equals(frm.getDState()) && showpositions;

	boolean browseBySerial = frm.isBrowseBySerial();
	String theDocCode = "";
	if (showpositions) {
		theDocCode = frm.getDocumentId().toString(); 
	}
	String mockIndex = frm.MOCK_DOC_ID;
%>

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
		<july:wordEditSlave masterStyleId='<%= masterTagId %>' styleId='<%= "dassactForm_" + theDocCode %>' 
		url='<%= "reports/dassact.jsp?prompt1=" + theDocCode %>' 
			uploadurl=''
			updatable='false'
		documentid='<%= theDocCode %>'><IMG SRC="/images/docword.gif" border="0" alt='Напечатать акт'></july:wordEditSlave>
	<%}%>
	<%if(("View".equals(frm.getAction()) || "Edit".equals(frm.getAction())) && !frm.getIsautodoc()){%>
	&nbsp;&nbsp;
		<%if("1".equals(frm.getDState())) {%>
			<input type="image" name="submit" src="/images/calculate.gif" onclick="document.all.action.value='Edit';document.all.processState.value='P';return checkPosted();" title="Обсчёт">
		<%} else {%>
			<html:link page="/ProcessDAssact.do?action=Edit&processState=C" paramId="document" paramName="DAssactForm" paramProperty="document" paramScope="session" onclick="return checkPosted();"><img src="/images/calculates.gif" border=0 alt="Снять обсчёт"></html:link>
		<%}%>
	<%}%>
	</july:formbuttons>

	<july:separator/>

    <tr>
        <td class="title" colspan="2"><july:actionalert/></td>
    </tr>

    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.dassact.owner"/>:</july:reqmark></td>
        <td>
			<july:select collection="owners" property="ownercode" insertable="true" updatable="true">
				<html:options collection="owners" property="organization" labelProperty="name"/>
			</july:select>
        </td>
    </tr>

    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.dassact.storage"/>:</july:reqmark></td>
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
        <td class="text"><july:reqmark><bean:message key="label.dassact.num"/>:</july:reqmark></td>
        <td>
           <%-- <july:string property="blankindexFrm" size="15" insertable="true" updatable="true" /> --%>
           <html:hidden property="blankindexFrm" value="<%=mockIndex%>" />
           <july:string property="blanknumber" size="15" insertable="true" updatable="true" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.dassact.date"/>:</july:reqmark></td>
        <td>
          <july:date property="blankdateFrm" size="25" insertable="true" updatable="true" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
	<td class="text">Оборудование:</td>
        <td>
			<july:string size="5" property="agregatcode" styleId="equipcode" insertable="true" updatable="true" />

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
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.dassact.agregate"/>:</july:reqmark></td>
        <td>
            <INPUT TYPE="HIDDEN" name="agrcode" ID="agrcode">
            <INPUT TYPE="HIDDEN" name="temp" ID="temp">
			<july:string property="agregateserial" styleId="agregateserial" size="20" insertable="true" updatable="true" />
			<july:lookupbutton action="/ShowCardLookupList.do" styleId="srl" onclick="set_opt_params_srl('?pagetype=2&storage='+document.all.storagecode.value+'&resource=&owner=&agregate=&brokentype=1&documentkey=')" fieldNames="temp;agregatname;temp;temp;agregateserial;temp;temp;temp;temp;temp;temp;temp" newWindowName="equiplookup" insertable="true" updatable="true"/>
			<%--<july:string size="25" property="agregatname" styleId="agregatname" insertable="false" updatable="false" />--%>
        </td>
    </tr>

    <july:separator/>
    
    <logic:equal name="DAssactForm" property="action" value="View">
    
        <tr>
            <td class="text"><bean:message key="label.dassact.oldconfig"/>:</td>
            <td>
               <july:string property="oldconfig" size="25" insertable="false" updatable="false" />
            </td>
        </tr>
        
        <july:separator/>
        
        <tr>
            <td class="text"><bean:message key="label.dassact.newconfig"/>:</td>
            <td>
               <july:string property="newconfig" size="25" insertable="true" updatable="true" />
            </td>
        </tr>
    
        <july:separator/>
        
    </logic:equal>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.dassact.stworker"/>:</july:reqmark></td>
        <td>
			<july:string property="workercodeFrm" styleId="workercode" size="5" insertable="true" updatable="true" />
			<july:lookupbutton action="/ShowWorkerLookupList.do" styleId="fwl" fieldNames="workercode;workername;workertitle" newWindowName="workerlookup"  insertable="true" updatable="true" />
			<html:text size="25" style="FONT-FAMILY: Verdana,Arial; FONT-SIZE: 10pt; background-color: DCDCDC;" property="workername" readonly="true"/>			
			<html:text size="25" style="FONT-FAMILY: Verdana,Arial; FONT-SIZE: 10pt; background-color: DCDCDC;" property="workertitle" readonly="true"/>			
        </td>
    </tr>

    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark/><bean:message key="label.dassact.monter"/>:</july:reqmark></td>
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
		<july:wordEditSlave masterStyleId='<%= masterTagId %>' styleId='<%= "dassactForm02_" + theDocCode %>' 
		url='<%= "reports/dassact.jsp?prompt1=" + theDocCode %>' 
			uploadurl=''
			updatable='false'
		documentid='<%= theDocCode %>'><IMG SRC="/images/docword.gif" border="0" alt='Напечатать акт'></july:wordEditSlave>
<%}%>
<%if(("View".equals(frm.getAction()) || "Edit".equals(frm.getAction())) && !frm.getIsautodoc()){%>
&nbsp;&nbsp;
	<%if("1".equals(frm.getDState())) {%>
		<input type="image" name="submit" src="/images/calculate.gif" onclick="document.all.action.value='Edit';document.all.processState.value='P';return checkPosted();" title="Обсчёт">
	<%} else {%>
		<html:link page="/ProcessDAssact.do?action=Edit&processState=C" paramId="document" paramName="DAssactForm" paramProperty="document" paramScope="session" onclick="return checkPosted();"><img src="/images/calculates.gif" border=0 alt="Снять обсчёт"></html:link>
	<%}%>
<%}%>
</july:formbuttons>
<%if(showpositions) {%>
<july:separator/>
<tr class="title">
	<td colspan="2" class="title">
	<table cellpadding=0 cellspacing=0 width=100% border=0 class="main">
	<tr>
		<td><nobr><%if(changable) {%><july:addbutton page="/EditDAssactpos.do?action=Add" alttext="label.dassactpos.add" onclick="return checkPosted();"/><%}%></nobr></td>
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
		<july:headercolumn key="label.dassactpos.name" colType="string"/>
		<july:headercolumn key="label.dassactpos.qty.short" colType="string"/>
		<july:headercolumn key="label.dassactpos.price" colType="string"/>
		<july:headercolumn key="label.dassactpos.sum" colType="string"/>
		<july:headercolumn key="label.dassactpos.serial" colType="string"/>
		<%if(changable) {%><td class="title">&nbsp;</td><%}%>
	</tr>

	<logic:iterate id="it" name="DAssactForm" property="listItems" type="com.hps.july.cdbc.lib.CDBCRowObject">
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
		<td class="string">
			<%if(changable) {%>
				<july:editbutton page="/EditDAssactpos.do" action="Edit" paramId="docposition" paramName="docposition" paramScope="page" alttext="label.dassactpos.edit"/>
			<%} else {%>
				<july:editbutton page="/EditDAssactpos.do" action="View" paramId="docposition" paramName="docposition" paramScope="page" alttext="label.dassactpos.view"/>
			<%}%>
		</td>
		<td class="number"><july:stringwrite name="it" property="order"/></td>
		<td class="text">
			<july:stringwrite name="it" property="name"/>
			<july:stringwrite name="it" property="model"/>
			<july:stringwrite name="it" property="configuration"/>
		</td>
		<td class="text"><july:numberwrite name="it" property="qty"/> <july:stringwrite name="it" property="unitname"/></td>
		<td class="number" align="right"><july:numberwrite name="it" property="price" fractdigits="2"/></td>
		<td class="number" align="right"><july:numberwrite name="it" property="summ" fractdigits="2"/></td>
		<td class="text"><july:stringwrite name="it" property="invnum"/></td>
		<%if(changable) {%><td class="link"><july:delbutton page="/EditDAssactpos.do?action=Delete" paramId="docposition" paramName="it" paramProperty="docposition" paramScope="page"/></td><%}%>
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
		<td><nobr><%if(changable) {%><july:addbutton page="/EditDAssactpos.do?action=Add" alttext="label.dassactpos.add" onclick="return checkPosted();"/><%}%></nobr></td>
		<td class="title" align="right">&nbsp;</td>
	</tr>
	</table>
	</td>
</tr>
<%}%>
<july:separator/>
    
</table>

</july:editform>

