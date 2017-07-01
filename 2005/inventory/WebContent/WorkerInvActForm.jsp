<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import="org.apache.struts.util.*"%>
<%@ page import="com.hps.july.inventory.formbean.*"%>

<july:editform action="/ProcessWorkerInvAct.do">
<bean:define id="docCode" name="WorkerInvActForm" property="document" scope="session" type="java.lang.Integer"/>
<july:inventorycalcerrors document="<%=docCode%>"/>
<script language="javascript" src="/action.js"></script>
<%
	WorkerInvActForm frm = (WorkerInvActForm)request.getSession().getAttribute("WorkerInvActForm");
	boolean showpositions = "View".equals(frm.getAction()) || "Edit".equals(frm.getAction());
	boolean changable = "1".equals(frm.getDState()) && !frm.getIsautodoc() && ("View".equals(frm.getAction()) || "Edit".equals(frm.getAction()));
%>

<script language="javascript">
function switchEquipmentLookup(state) {
	if(!document.all.lookupbtn_eql) return;
	if(state) {
		WorkerInvActForm.equipserial.className = 'edit';
		WorkerInvActForm.equipserial.disabled = false;
		document.all.lookupbtn_eql.disabled = false;
		document.all.lookupimg_eql.src='/images/lookup.gif';
	} else {
		WorkerInvActForm.equipserial.className = 'editdisabled';
		WorkerInvActForm.equipserial.disabled = true;
		document.all.lookupbtn_eql.disabled = true;
		document.all.lookupimg_eql.src='/images/lookup_disabled.gif';
	}
}
function switchLookup(itemname,lookupname,disabled) {
	if(disabled) {
		document.all[itemname].className = 'editkoddisabled';
		document.all[itemname].disabled = true;
		document.all[itemname].readonly = true;
		document.all['lookupbtn_'+lookupname+'l'].disabled = true;
		document.all['lookupimg_'+lookupname+'l'].src='/images/lookup_disabled.gif';
	} else {
		document.all[itemname].className = 'editkod';
		document.all[itemname].disabled = false;
		document.all[itemname].readonly = false;
		document.all['lookupbtn_'+lookupname+'l'].disabled = false;
		document.all['lookupimg_'+lookupname+'l'].src='/images/lookup.gif';
	}
}
function switchWorker() {
	if(WorkerInvActForm.expedtype[0].checked) {
		switchLookup('workercode', 'wrk', false);
	} else {
		switchLookup('workercode', 'wrk', true);
	}
	if(WorkerInvActForm.expedtype[1].checked) {
		switchLookup('orgcode', 'org', false);
	} else {
		switchLookup('orgcode', 'org', true);
	}
}
</script>

<html:hidden property="document" />
<input type="hidden" name="processState" value="">

<table class="main">
    
    <july:separator/>
	
	<july:formbuttons>
	<%if(("View".equals(frm.getAction()) || "Edit".equals(frm.getAction())) && !frm.getIsautodoc()){%>
	&nbsp;&nbsp;
		<%if("1".equals(frm.getDState())) {%>
			<input type="image" name="submit" src="/images/calculate.gif" onclick="document.all.action.value='Edit';document.all.processState.value='P';return checkPosted();" title="Обсчёт">
		<%} else {%>
			<html:link page="/ProcessWorkerInvAct.do?action=Edit&processState=C" paramId="document" paramName="WorkerInvActForm" paramProperty="document" paramScope="session" onclick="return checkPosted();"><img src="/images/calculates.gif" border=0 alt="Снять обсчёт"></html:link>
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
		<td class="text"><july:reqmark><bean:message key="label.inventory.worker"/> / </july:reqmark></td>
		<td class="text"><july:radio property="expedtype"
        onclick="switchWorker();"
        insertable="true" updatable="true" value="W"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<july:string property="workercode" styleId="workercode" size="5" insertable="true" updatable="true" styleClass="editkodsearch"/>
			<july:lookupbutton action="/ShowWorkerLookupList.do" styleId="wrkl" fieldNames="workercode;workername" insertable="true" updatable="true"/>
			<july:string size="35" property="workername" styleId="workername" insertable="false" updatable="false" />
		</td>
	</tr>
	<tr>
		<td class="text"><bean:message key="label.inventory.organization"/></td>
		<td class="text"><july:radio property="expedtype"
        onclick="switchWorker();"
        insertable="true" updatable="true" value="O"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<july:string property="orgcode" styleId="orgcode" size="5" insertable="true" updatable="true" styleClass="editkodsearch"/>
			<july:lookupbutton action="/ShowOrganizationLookupList.do?selisprovider=true" styleId="orgl" fieldNames="orgcode;orgname" insertable="true" updatable="true"/>
			<july:string size="35" property="orgname" styleId="orgname" insertable="false" updatable="false" />
		</td>
	</tr>
	
	<%if("1".equals(frm.getDState())) {%>
		<script language="javascript">
			switchWorker();
		</script>
	<%}%>
      
    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.inventory.num"/>:</july:reqmark></td>
        <td>
           <july:string property="blankindexFrm" size="15" insertable="true" updatable="true" />
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
		<july:radio insertable="true" updatable="true" property="type" value="F" onclick="switchEquipmentLookup(WorkerInvActForm.type[1].checked);"/><bean:message key="label.inventory.type.full"/>
		<july:radio insertable="true" updatable="true" property="type" value="A" onclick="switchEquipmentLookup(WorkerInvActForm.type[1].checked);"/><bean:message key="label.inventory.type.byunit"/>
	</td>
</tr>
    
<july:separator/>

<script language="javascript">
  function cardLookup() {
    if (document.all.expedtype[0].checked)
      return set_opt_params_eql('?pagetype=2&worker='+document.all.workercode.value+'&resource=&owner=&agregate=&brokentype=1&documentkey='+document.all.document.value);
    else
      return set_opt_params_eql('?pagetype=2&organization='+document.all.orgcode.value+'&resource=&owner=&agregate=&brokentype=1&documentkey='+document.all.document.value);
  }
</script>

    
<tr>
	<td class="text"><bean:message key="label.inventory.unit"/>:</td>
	<td>
		<july:string size="15" property="equipserial" styleId="equipserial" insertable="true" updatable="true" />
		<july:lookupbutton action="/ShowCardRLookupList.do" styleId="eql" onclick="cardLookup();" fieldNames="temp;equipname;temp;temp;equipserial;temp;temp;temp;temp;temp;temp;temp;temp" newWindowName="equiplookup" insertable="true" updatable="true"/>&nbsp;
		<july:string size="25" property="equipname" styleId="equipname" insertable="false" updatable="false" />
		<input type=hidden name="temp">
		<script language="javascript">
			switchEquipmentLookup(WorkerInvActForm.type[1].checked);
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
	   <logic:equal name="WorkerInvActForm" property="dState" value="1"><bean:message key="label.state.entering"/></logic:equal>
	   <logic:equal name="WorkerInvActForm" property="dState" value="2"><bean:message key="label.state.calculated"/></logic:equal>
        </td>
    </tr>
    
<july:separator/>
<july:formbuttons>
<%if(("View".equals(frm.getAction()) || "Edit".equals(frm.getAction())) && !frm.getIsautodoc()){%>
&nbsp;&nbsp;
	<%if("1".equals(frm.getDState())) {%>
		<input type="image" name="submit" src="/images/calculate.gif" onclick="document.all.action.value='Edit';document.all.processState.value='P';return checkPosted();" title="Обсчёт">
	<%} else {%>
		<html:link page="/ProcessWorkerInvAct.do?action=Edit&processState=C" paramId="document" paramName="WorkerInvActForm" paramProperty="document" paramScope="session" onclick="return checkPosted();"><img src="/images/calculates.gif" border=0 alt="Снять обсчёт"></html:link>
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
			<july:addbutton page="/EditWorkerInvActPos.do?action=Add"  alttext="label.invpos.add" onclick="return checkPosted();"/>
			<html:link page="/WorkerInvActFillFromDB.do?action=Add" paramId="doc" paramName="WorkerInvActForm" paramProperty="document" paramScope="session" onclick="return checkPosted();"><img src="/images/loaddb.gif" border="0" alt="Создать позиции по состоянию базы данных"></html:link>
			<july:backbutton page="/ShowWorkerInvActList.do"/>
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

	<logic:iterate id="it" name="WorkerInvActForm" property="listItems" type="com.hps.july.cdbc.lib.CDBCRowObject">
	<logic:present name="it">
	<%
		String docposition = it.getColumn("docposition").asString();
		pageContext.setAttribute("it_docposition",docposition);
		String countpolicy = it.getColumn("countpolicy").asString();
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
			<%if(changable) {%>
				<july:editbutton page="/EditWorkerInvActPos.do" action="Edit" paramId="docposition" paramName="it_docposition" paramScope="page" alttext="label.dassactpos.edit"/>
			<%} else {%>
				<july:editbutton page="/EditWorkerInvActPos.do" action="View" paramId="docposition" paramName="it_docposition" paramScope="page" alttext="label.dassactpos.view"/>
			<%}%>
		</td>
                <td class="number"><july:stringwrite name="it" property="order"/></td>
		<%if(changable){%>
		<td class="link"><%if("S".equals(countpolicy)) { %><html:link page="/EditWorkerInvActPos.do?action=Add" paramId="copydocpos" paramName="it_docposition" paramScope="page"><bean:message key="label.invpos.copy"/></html:link><%}%></td>
		<%}%>
		<td class="text"><%if(resname != null && !"".equals(resname)) {%><july:stringwrite name="it_resname"/><%if(resmodel != null && !"".equals(resmodel)) {%>,<br><july:stringwrite name="it_resmodel"/><%}%><%if(resconfig != null && !"".equals(resconfig)) {%>,<br><bean:write name="it_resconfig"/><%}%><%}%></td>
		<td class="text"><july:stringwrite name="it" property="invnum"/></td>
		<td class="text" align="right"><july:numberwrite name="it" property="qty"/> <july:stringwrite name="it" property="usn"/></td>
		<td class="text"><july:numberwrite name="it" property="price" fractdigits="2"/></td>
		<td class="text"><july:numberwrite name="it" property="sum" fractdigits="2"/></td>
		<%if(changable) {%><td class="link"><july:delbutton page="/EditWorkerInvActPos.do?action=Delete" paramId="docposition" paramName="it_docposition" paramScope="page" /></td><%}%>
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
			<july:addbutton page="/EditWorkerInvActPos.do?action=Add"  alttext="label.invpos.add" onclick="return checkPosted();"/>
			<html:link page="/WorkerInvActFillFromDB.do?action=Add" paramId="doc" paramName="WorkerInvActForm" paramProperty="document" paramScope="session" onclick="return checkPosted();"><img src="/images/loaddb.gif" border="0" alt="Создать позиции по состоянию базы данных"></html:link>
			<july:backbutton page="/ShowWorkerInvActList.do"/>
		<%}%></nobr></td>
		<td class="title" align="right">&nbsp;</td>
	</tr>
	</table>
	</td>
</tr>
<%}%>
</table>

</july:editform>

