<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import="com.hps.july.inventory.formbean.AssemblingPForm" %>
<%@ page import="java.util.Iterator"%>

<%
	String masterTagId = "assemblingpFormWordEditMasterTagId";
%>
<july:wordEditMaster styleId='<%= masterTagId %>' >
</july:wordEditMaster>

<july:editform action="/ProcessAssemblingP.do">
<bean:define id="docCode" name="AssemblingPForm" property="doc" scope="session" type="java.lang.Integer"/>
<july:inventorycalcerrors document="<%=docCode%>"/>
<script language="javascript" src="/action.js"></script>
<script language="javascript">
function printWord(prompt1){
	//Печать актов:
	window.location.href='reports/assactp.jsp?prompt1='+prompt1;
}
</script>
<%
	AssemblingPForm frm = (AssemblingPForm)request.getSession().getAttribute("AssemblingPForm");
	// boolean showpositions = "View".equals(frm.getAction()) || "Edit".equals(frm.getAction());
	boolean showpositions = "View".equals(frm.getAction()) || "Edit".equals(frm.getAction()) || "Delete".equals(frm.getAction());
	boolean changable = "1".equals(frm.getDState()) && !frm.getIsautodoc() && ("View".equals(frm.getAction()) || "Edit".equals(frm.getAction()));
	//для вызова справочника "EquipmentsTableTrailcom":
    String trailcomUrl = com.hps.july.util.AppUtils.getNamedValueString("PathEquipmentsTableTrailcom") + "?id=" + request.getRemoteUser();
	boolean hasErs = !(frm.getXlserrors()).isEmpty();
	boolean canuncalc = !("D".equals(frm.getReadprjstatus()));
	String theDocCode = "";
	if (showpositions) {
		theDocCode = frm.getDocumentId().toString(); 
	}
	
	String mockIndex = frm.getBlankindexFrm();
	if (mockIndex == null || mockIndex.length() == 0) {
		mockIndex = frm.MOCK_DOC_ID;
	}
%>

<script language="javascript">
function switchLookup(itemname,lookupname,disabled) {
	if((AssemblingPForm['action'].value == 'Add') || (AssemblingPForm['action'].value == 'Edit'))
	{
		if(disabled) {
			AssemblingPForm[itemname].className = 'editkoddisabled';
			AssemblingPForm[itemname].disabled = true;
			AssemblingPForm[itemname].readonly = true;
			document.all['lookupbtn_'+lookupname+'l'].disabled = true;
			document.all['lookupimg_'+lookupname+'l'].src='/images/lookup_disabled.gif';
		} else {
			AssemblingPForm[itemname].className = 'editkod';
			AssemblingPForm[itemname].disabled = false;
			AssemblingPForm[itemname].readonly = false;
			document.all['lookupbtn_'+lookupname+'l'].disabled = false;
			document.all['lookupimg_'+lookupname+'l'].src='/images/lookup.gif';
		}
	}
}

function switchItem(itemname,state) {
	if((AssemblingPForm['action'].value == 'Add') || (AssemblingPForm['action'].value == 'Edit'))
	{
		if(state) {
			AssemblingPForm[itemname].disabled = true;
			AssemblingPForm[itemname].className = 'editdisabled';
		} else {
			AssemblingPForm[itemname].disabled = false;
			AssemblingPForm[itemname].className = 'edit';
		}
	}
}

function switchFilter() {
	if(AssemblingPForm.type[0].checked) {
		switchLookup('providercode','prov',false);
		switchLookup('workercode','work1',true);
		AssemblingPForm['providername'].disabled = false;
		AssemblingPForm['workername'].disabled = true;
		AssemblingPForm['workertitle'].disabled = true;
		switchItem('insuranseMan',false);
	} else
	if(AssemblingPForm.type[1].checked) {
		switchLookup('providercode','prov',true);
		switchLookup('workercode','work1',false);
		AssemblingPForm['providername'].disabled = true;
		AssemblingPForm['workername'].disabled = false;
		AssemblingPForm['workertitle'].disabled = false;
		switchItem('insuranseMan',true);
	} else {
		switchLookup('providercode','prov',true);
		switchLookup('workercode','work1',true);
		AssemblingPForm['providername'].disabled = true;
		AssemblingPForm['workername'].disabled = true;
		AssemblingPForm['workertitle'].disabled = true;
		switchItem('insuranseMan',true);
	}
}
function getEquipment(equip_id , equip_name){
	//alert("equip_id =" + equip_id  + "; equip_name=" + equip_name);
	AssemblingPForm["complectcode"].value=equip_id ;
	AssemblingPForm["complectname"].value=equip_name ;
}
</script>

<html:hidden property="docstr" />  
<html:hidden property="expeditionstr" />
<input type="hidden" name="processState" value="">

<table class="main">
      
	<%if(hasErs){
		Iterator iter = frm.getXlserrors().iterator();
		    while(iter.hasNext()){
				String error = (String)iter.next();
		%><br>
		&nbsp;<IMG SRC="/images/edot.gif" BORDER=0>&nbsp;<FONT style="color: red; font-size: 10pt;"><%=error%></FONT>
		<%  }
	}%>	

    <july:separator/>
    
	<july:formbuttons>
	<%if(showpositions){%>
	<%--
	<A href='javascript:printWord(<%=docCode%>)'><img 
	src="/images/print.gif" border=0 alt='Напечатать акт'></A>
	--%>
	<july:wordEditSlave masterStyleId='<%= masterTagId %>' styleId='<%= "assemblingpForm_" + theDocCode %>' 
		url='<%= "reports/assactp.jsp?prompt1=" + theDocCode %>' 
			uploadurl=''
			updatable='false'
		documentid='<%= theDocCode %>'><IMG SRC="/images/docword.gif" border="0" alt='Напечатать акт'></july:wordEditSlave>
	<%}%>
	<%if(("View".equals(frm.getAction()) || "Edit".equals(frm.getAction())) && !frm.getIsautodoc()){%>
	&nbsp;&nbsp;
	<%if("1".equals(frm.getDState())) {%>
		<%if(frm.getCancalc()) {%>
		<logic:equal name="AssemblingPForm" property="cancalc" value="true">
		<input type="image" name="submit" src="/images/calculate.gif" onclick="document.all.action.value='Edit';document.all.processState.value='P';document.all.warnProc.value='false';return checkPosted();" title="Обсчёт">
		</logic:equal>
		<%}%>
	<%if(com.hps.july.util.AppUtils.isNewInventory()){%>
	<%if(frm.getWarnProc() != null && frm.getWarnProc().booleanValue()) {%>
	<%if(frm.getCancalc()) {%>
		<logic:equal name="AssemblingPForm" property="cancalc" value="true">
		<input type="image" name="submit" src="/images/calculatea.gif" onclick="document.all.action.value='Edit';document.all.processState.value='P';document.all.warnProc.value='true';return checkPosted();" title="Обсчёт с автоматическим исправлением несоответствий">
		</logic:equal>
	<%}%>
	<%}%>
	<%}%>
	<%} else if (canuncalc) {%>
		<html:link page="/ProcessAssemblingP.do?action=Edit&processState=C" paramId="doc" paramName="AssemblingPForm" paramProperty="doc" paramScope="session" onclick="return checkPosted();"><img src="/images/calculates.gif" border=0 alt="Снять обсчёт"></html:link>
	<%--		<input type="image" name="submit" src="/images/calculates.gif" onclick="document.all.action.value='Edit';document.all.processState.value='C';return checkPosted();" title="Снять обсчёт"> --%>
	<%}%>
	<%}%>
	</july:formbuttons>
	
	<july:separator/>

    <tr>
        <td class="title" colspan="2"><july:actionalert/></td>
    </tr>

    <july:separator/>

    <tr>
        <td class="text"><july:reqmark><bean:message key="label.assemblingp.owner"/>:</july:reqmark></td>
        <td>
			<july:select collection="owners" property="ownercode" insertable="true" updatable="true">
				<html:options collection="owners" property="organization" labelProperty="name"/>
			</july:select>
        </td>
    </tr>

    <july:separator/>

    <tr>
        <td class="text"><july:reqmark><bean:message key="label.assemblingp.blanknumber"/>:</july:reqmark></td>
        <td>
           <%-- <july:string property="blankindexFrm" size="15" insertable="true" updatable="true" /> --%>
           <html:hidden property="blankindexFrm" value="<%=mockIndex%>" />
           <july:string property="blanknumber" size="15" insertable="true" updatable="true" />
        </td>
    </tr>
    
    <july:separator/>

    <tr>
        <td class="text"><july:reqmark><bean:message key="label.assemblingp.date"/>:</july:reqmark></td>
        <td>
			<july:date property="blankdatestr" styleId="blankdatestrctl" size="25" insertable="true" updatable="true" />
        </td>
    </tr>

    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.assemblingp.position"/>:</july:reqmark></td>
        <td>
			<july:string property="positioncode" styleId="positioncode" size="5" insertable="true" updatable="true" />
			<july:lookupbutton action="/ShowPositionLookupList.do" styleId="posl" fieldNames="positioncode;positionid;positionname;complectcode;complectname" newWindowName="poslookup" insertable="true" updatable="true" />
			<july:string size="10" property="positionid" styleId="positionid" insertable="false" updatable="false" />
			<july:string size="25" property="positionname" styleId="positionname" insertable="false" updatable="false" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.assemblingp.complect"/>:</july:reqmark></td>
        <td>
			<html:hidden property="complectcode"/>
<!--			<july:string property="complectcode" styleId="complectcode" size="5" insertable="true" updatable="true" /> -->
			<july:string size="35" property="complectname" styleId="complectname" insertable="false" updatable="false" />

			<july:lookupbutton action="/ShowComplectLookupList.do" styleId="coml" fieldNames="complectcode;complectname" newWindowName="poslookup" insertable="true" updatable="true" onclick="set_opt_params_coml('?position='+document.all.positioncode.value)"/>

<!--
			<A HREF="#" name="lookupbtn_coml" onclick="myWindow = window.open('<%= trailcomUrl%>&position='+document.all.positioncode.value+'&docDomain='+document.domain, 'poslookup', 'top=40, left=100, width=830, height=630, status=1,scrollbars=yes, resizable=yes');  myWindow.focus(); return false;">
				<img name="lookupimg_coml" src="/images/lookup.gif" border="0" alt="Справочник комплекта оборудования">
			</A>
-->
        </td>
    </tr>

    <july:separator/>

	<tr>
		<td class="text"><bean:message key="label.mountact2.project"/>:</td>
		<td>
		  <html:hidden property="projectid"/>
		  <july:string size="35" style="font-size:8pt;" 
		  	property="projectname" insertable="false" updatable="false"/>
		</td>
	</tr>
    
    <july:separator/>

	<tr>
		<td class="text"><july:reqmark><bean:message key="label.assemblingp.assembler"/>:</july:reqmark></td>
		<td>
			<july:radio insertable="true" updatable="true" property="type" value="P" onclick="switchFilter();" styleClass="text"/>&nbsp;<bean:message key="label.assemblingp.provider"/>&nbsp;&nbsp;&nbsp;&nbsp;
			<july:radio insertable="true" updatable="true" property="type" value="W" onclick="switchFilter();" styleClass="text"/>&nbsp;<bean:message key="label.assemblingp.worker"/>
		</td>
	</tr>
    
    <july:separator/>

    <tr>
        <td class="text">&nbsp;&nbsp;&nbsp;&nbsp;<july:reqmark><bean:message key="label.assemblingp.provider"/>:</july:reqmark></td>
        <td>
			<july:string property="providercode" styleId="providercode" size="5" insertable="true" updatable="true" />
			<july:lookupbutton action="/ShowOrganizationLookupList.do" styleId="provl" fieldNames="providercode;providername" newWindowName="organizationlookup"  insertable="true" updatable="true" onclick="set_opt_params_provl('?selisprovider=true&selisrenter=false&selissupplier=false');"/>
			<july:string size="35" property="providername" styleId="providername" insertable="false" updatable="false" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text">&nbsp;&nbsp;&nbsp;&nbsp;<july:reqmark><bean:message key="label.assemblingp.insuranceman"/></july:reqmark>:</td>
        <td>
			<july:string size="35" property="insuranseMan" insertable="true" updatable="true" />
        </td>
    </tr>

    <july:separator/>

    <tr>
        <td class="text">&nbsp;&nbsp;&nbsp;&nbsp;<july:reqmark><bean:message key="label.assemblingp.worker"/>:</july:reqmark></td>
        <td nowrap>
			<july:string property="workercode" styleId="workercode" size="5" insertable="true" updatable="true" />
			<july:lookupbutton action="/ShowWorkerLookupList.do" styleId="work1l" fieldNames="workercode;workername;workertitle" newWindowName="workerlookup"  insertable="true" updatable="true" />
			<july:string size="25" property="workername" styleId="workername" insertable="false" updatable="false" />
			<july:string size="20" property="workertitle" styleId="workertitle" insertable="false" updatable="false" />
        </td>
    </tr>
    
    <july:separator/>

    <tr>
        <td class="text"><bean:message key="label.assemblingp.worker2"/>:</td>
        <td nowrap>
			<july:string property="worker2code" styleId="worker2code" size="5" insertable="true" updatable="true" />
			<july:lookupbutton action="/ShowWorkerLookupList.do" styleId="work2l" fieldNames="worker2code;worker2name;worker2title" newWindowName="workerlookup"  insertable="true" updatable="true" />
			<july:string size="25" property="worker2name" styleId="worker2name" insertable="false" updatable="false" />
			<july:string size="20" property="worker2title" styleId="worker2title" insertable="false" updatable="false" />
        </td>
    </tr>
    
    <july:separator/>

    <tr>
        <td class="text"><bean:message key="label.assemblingp.storageman"/>:</td>
        <td nowrap>
			<july:string property="storagemancode" styleId="storagemancode" size="5" insertable="true" updatable="true" />
			<july:lookupbutton action="/ShowWorkerLookupList.do" styleId="smanl" fieldNames="storagemancode;storagemanname;storagemantitle" newWindowName="workerlookup"  insertable="true" updatable="true" />
			<july:string size="25" property="storagemanname" styleId="storagemanname" insertable="false" updatable="false" />
			<july:string size="20" property="storagemantitle" styleId="storagemantitle" insertable="false" updatable="false" />
        </td>
    </tr>
    
    <july:separator/>
    
<tr>
	<td class="text"><bean:message key="label.dismantlingp.state"/>:</td>
	<td>
		<%if("1".equals(frm.getDState())) {%><bean:message key="label.state.entering"/><%} else {%><bean:message key="label.state.calculated"/><%}%>
		<% if (frm.isNeedapprove()) { %>
           &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
           <bean:message key="label.mountact2.prjstate"/>: &nbsp;
           <%= frm.getPrjstatusname() %>
        <% } %>
	</td>
</tr>
    
<july:separator/>

<july:formbuttons>
<%if(showpositions){%>
<%--
<A href='javascript:printWord(<%=docCode%>)'><img 
	src="/images/print.gif" border=0 alt='Напечатать акт'></A>
--%>
	<july:wordEditSlave masterStyleId='<%= masterTagId %>' styleId='<%= "assemblingpForm02_" + theDocCode %>' 
		url='<%= "reports/assactp.jsp?prompt1=" + theDocCode %>' 
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
	<%} else if (canuncalc) {%>
		<html:link page="/ProcessAssemblingP.do?action=Edit&processState=C" paramId="doc" paramName="AssemblingPForm" paramProperty="doc" paramScope="session" onclick="return checkPosted();"><img src="/images/calculates.gif" border=0 alt="Снять обсчёт"></html:link>
<%--		<input type="image" name="submit" src="/images/calculates.gif" onclick="document.all.action.value='Edit';document.all.processState.value='C';return checkPosted();" title="Снять обсчёт"> --%>
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
<july:addbutton page="/EditAssemblingPPosition.do?action=Add" alttext="label.assactpos.add" onclick="return checkPosted();"/>
<july:addbutton page="/EditAssemblingPUPS.do?action=Add" alttext="label.assactups.add" onclick="return checkPosted();" image="plussplitter.gif"/>
<A HREF="AssemblingPLoadExcel.do?action=Add"><img src="/images/loadexcel.gif" border="0"></A>
<%}%></nobr></td>
		<td class="title" align="right"><bean:message key="label.assemblingp.positions"/></td>
	</tr>
	</table>
	</td>
</tr>
<july:separator/>
<tr><td colspan="2" style="padding:0px;">
	<table class="main">
	<tr class="title">
		<td class="title">&nbsp;</td>
		<july:headercolumn key="label.assemblingp.numpp" colType="number"/>
		<july:headercolumn key="label.assemblingp.name" colType="string"/>
		<july:headercolumn key="label.assemblingp.qty.short" colType="string"/>
		<july:headercolumn key="label.assemblingp.price" colType="string"/>
		<july:headercolumn key="label.assemblingp.sum" colType="string"/>
		<july:headercolumn key="label.assemblingp.policynum" colType="string"/>
		<%if(changable) {%><td class="title">&nbsp;</td><%}%>
	</tr>

	<logic:iterate id="it" name="AssemblingPForm" property="listItems" type="com.hps.july.cdbc.lib.CDBCRowObject">
	<logic:present name="it">
	<%
		pageContext.setAttribute("docposition",it.getColumn("docposition").asString());

		String serialnumber = it.getColumn("invnum").asString();
		pageContext.setAttribute("serialnumber",serialnumber);
		String tp = it.getColumn("type").asString();
		String editURL = "/EditAssemblingPPosition.do";
		String editAction = "View";
		Object agr = it.getColumn("agregate").asObject();

		if("P".equals(tp)) { editURL = "/EditAssemblingPUPS.do"; }
		if(changable && agr == null) { editAction = "Edit"; }

System.out.println("AGR:"+agr);
	%>
	<tr class="normal" onMouseOver="className='select';" onMouseOut="className='normal';">
		<td class="link">
			<july:editbutton page="<%=editURL%>" action="<%=editAction%>" paramId="docpos" paramName="docposition" paramScope="page" alttext="label.assactpos.edit"/>
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
		<td class="text"><july:stringwrite name="serialnumber"/><%--july:stringwrite name="it" property="party"/--%></td>
		<%if(changable) {%>
		<td class="link">
			<%if(changable && agr == null) {%>
				<july:delbutton page='<%=editURL+"?action=Delete"%>' paramId="docpos" paramName="docposition" paramScope="page" />
			<%}%>
		</td>
		<%}%>
	</tr>
	<%
	pageContext.setAttribute("assmplist",frm.getListPartItems(it.getColumn("docposition").asObject()));
	%>
	<logic:iterate id="itp" name="assmplist" type="com.hps.july.cdbc.lib.CDBCRowObject">
	<logic:present name="itp">
		<tr class="normal" onMouseOver="className='select';" onMouseOut="className='normal';">
			<td class="link">&nbsp;</td>
			<td class="number" align="right">&nbsp;</td>
			<td class="text">
				<july:stringwrite name="itp" property="name"/>
				<july:stringwrite name="itp" property="model"/>
				<july:stringwrite name="itp" property="configuration"/>
			</td>
			<td class="number" align="right"><july:numberwrite name="itp" property="qty"/> <july:stringwrite name="itp" property="unitname"/></td>
			<td class="number" align="right"><july:numberwrite name="itp" property="price" fractdigits="2"/></td>
			<td class="number" align="right"><july:numberwrite name="itp" property="summ" fractdigits="2"/></td>
			<td class="text"><july:stringwrite name="itp" property="invnum"/></td>
			<%if(changable) {%>
			<td class="link">&nbsp;</td>
			<%}%>
		</tr>
	</logic:present>
	</logic:iterate>

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
<july:addbutton page="/EditAssemblingPPosition.do?action=Add" alttext="label.assactpos.add" onclick="return checkPosted();"/>
<july:addbutton page="/EditAssemblingPUPS.do?action=Add" alttext="label.assactups.add" onclick="return checkPosted();" image="plussplitter.gif"/>
<A HREF="AssemblingPLoadExcel.do?action=Add"><img src="/images/loadexcel.gif" border="0"></A>
<%}%></nobr></td>
		<td class="title" align="right">&nbsp;</td>
	</tr>
	</table>
	</td>
</tr>
<%}%>    
</table>

<script language="javascript">
	//document.domain="infserver.informix.ru";
	//alert(document.domain);
	switchFilter();
</script>

<%
  frm.getXlserrors().clear();
%>

</july:editform>

