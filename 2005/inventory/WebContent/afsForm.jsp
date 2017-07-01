<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@page import="com.hps.july.inventory.formbean.*" %>
<%!
private String addSector(String sectors, String s, com.hps.july.cdbc.lib.CDBCRowObject ro) {
	String r = sectors;
	if(ro.getColumn(s).asObject() != null) {
		if(sectors != null && sectors.length() > 0) { r = sectors + "," + ro.getColumn(s).asString(); }
		else { r = ro.getColumn(s).asString(); }
	}
	return r;
}
%>

<july:editform action="/ProcessAfs.do">
<bean:define id="docCode" name="AfsForm" property="doc" scope="session" type="java.lang.Integer"/>
<july:inventorycalcerrors document="<%=docCode%>"/>
<script language="javascript" src="/action.js"></script>
<%
	AfsForm aForm = (AfsForm)request.getSession().getAttribute("AfsForm");
	java.lang.String gColSpan = "12";
	boolean showpositions = "View".equals(aForm.getAction()) || "Edit".equals(aForm.getAction());
	boolean changable = "1".equals(aForm.getDState()) && !aForm.getIsautodoc() && ("View".equals(aForm.getAction()) || "Edit".equals(aForm.getAction()));
	boolean canuncalc = !("D".equals(aForm.getReadprjstatus()));
	String mockIndex = aForm.MOCK_DOC_ID;
%>

<script language="javascript">
function switchLookup(itemname,lookupname,disabled) {
	if((AfsForm['action'].value == 'Add') || (AfsForm['action'].value == 'Edit'))
	{
		if(disabled) {
			AfsForm[itemname].className = 'editkoddisabled';
			AfsForm[itemname].disabled = true;
			AfsForm[itemname].readonly = true;
			document.all['lookupbtn_'+lookupname+'l'].disabled = true;
			document.all['lookupimg_'+lookupname+'l'].src='/images/lookup_disabled.gif';
		} else {
			AfsForm[itemname].className = 'editkod';
			AfsForm[itemname].disabled = false;
			AfsForm[itemname].readonly = false;
			document.all['lookupbtn_'+lookupname+'l'].disabled = false;
			document.all['lookupimg_'+lookupname+'l'].src='/images/lookup.gif';
		}
	}
}

function switchItem(itemname,state) {
	if((AfsForm['action'].value == 'Add') || (AfsForm['action'].value == 'Edit'))
	{
		if(state) {
			AfsForm[itemname].disabled = true;
			AfsForm[itemname].className = 'editdisabled';
		} else {
			AfsForm[itemname].disabled = false;
			AfsForm[itemname].className = 'edit';
		}
	}
}

function switchFilter() {
	if(AfsForm.type[0].checked) {
		switchLookup('providercode','prov',false);
		switchLookup('workercode','work1',true);
		AfsForm['providername'].disabled = false;
		AfsForm['workername'].disabled = true;
		AfsForm['workertitle'].disabled = true;
		switchItem('insuranseMan',false);
	} else
	if(AfsForm.type[1].checked) {
		switchLookup('providercode','prov',true);
		switchLookup('workercode','work1',false);
		AfsForm['providername'].disabled = true;
		AfsForm['workername'].disabled = false;
		AfsForm['workertitle'].disabled = false;
		switchItem('insuranseMan',true);
	} else {
		switchLookup('providercode','prov',true);
		switchLookup('workercode','work1',true);
		AfsForm['providername'].disabled = true;
		AfsForm['workername'].disabled = true;
		AfsForm['workertitle'].disabled = true;
		switchItem('insuranseMan',true);
	}
}
</script>

<html:hidden property="docstr" />
<html:hidden property="expeditionstr" />
<input type="hidden" name="processState" value="">

<table class="main">
    
<july:separator/>
    
    <july:formbuttons>
<%if(("View".equals(aForm.getAction()) || "Edit".equals(aForm.getAction())) && !aForm.getIsautodoc()){%>
&nbsp;&nbsp;
	<%if("1".equals(aForm.getDState())) {%>
		<input type="image" name="submit" src="/images/calculate.gif" onclick="document.all.action.value='Edit';document.all.processState.value='P';document.all.warnProc.value='false';return checkPosted();" title="Обсчёт">
<%if(com.hps.july.util.AppUtils.isNewInventory()){%>
<%if(aForm.getWarnProc() != null && aForm.getWarnProc().booleanValue()) {%>
		<input type="image" name="submit" src="/images/calculatea.gif" onclick="document.all.action.value='Edit';document.all.processState.value='P';document.all.warnProc.value='true';return checkPosted();" title="Обсчёт с автоматическим исправлением несоответствий">
<%}%>
<%}%>
	<%} else if (canuncalc) {%>
		<html:link page="/ProcessAfs.do?action=Edit&processState=C" paramId="doc" paramName="AfsForm" paramProperty="doc" paramScope="session" onclick="return checkPosted();"><img src="/images/calculates.gif" border=0 alt="Снять обсчёт"></html:link>
	<%}%>
<%}%>
    </july:formbuttons>
   
<july:separator/>
    
<tr>
	<td class="title" colspan="2"><july:actionalert/></td>
</tr>

<july:separator/>

<tr>
	<td class="text"><july:reqmark><bean:message key="label.afs.owner"/>:</july:reqmark></td>
        <td>
			<july:select collection="owners" property="ownercode" insertable="true" updatable="true">
				<html:options collection="owners" property="organization" labelProperty="name"/>
			</july:select>
        </td>
</tr>

    <july:separator/>

    <tr>
        <td class="text"><july:reqmark><bean:message key="label.afs.blanknumber"/>:</july:reqmark></td>
        <td>
           <%-- <july:string property="blankindexFrm" size="15" insertable="true" updatable="true" /> --%>
           <html:hidden property="blankindexFrm" value="<%=mockIndex%>" />
           <july:string property="blanknumber" size="15" insertable="true" updatable="true" />
        </td>
    </tr>
    
    <july:separator/>

    <tr>
        <td class="text"><july:reqmark><bean:message key="label.afs.date"/>:</july:reqmark></td>
        <td>
			<july:date property="blankdatestr" styleId="blankdatestrctl" size="25" insertable="true" updatable="true" />
        </td>
    </tr>

    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.afs.position"/></july:reqmark>:</td>
        <td>
			<july:string property="positioncode" styleId="positioncode" size="5" insertable="true" updatable="false" />
			<july:lookupbutton action="/ShowPositionLookupList.do" styleId="posl" fieldNames="positioncode;positionid;positionname;complectcode;complectname" newWindowName="poslookup" insertable="true" updatable="false" />
			<july:string size="10" property="positionid" styleId="positionid" insertable="false" updatable="false" />
			<july:string size="25" property="positionname" styleId="positionname" insertable="false" updatable="false" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.afs.complect"/></july:reqmark>:</td>
        <td>
			<html:hidden property="complectcode"/>
			<july:string size="35" property="complectname" styleId="complectname" insertable="false" updatable="false" />

			<july:lookupbutton action="/ShowComplectLookupList.do" styleId="coml" fieldNames="complectcode;complectname" newWindowName="poslookup" insertable="true" updatable="true" onclick="set_opt_params_coml('?position='+document.all.positioncode.value)"/>
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
        <td class="text"><july:reqmark><bean:message key="label.afs.afstype"/></july:reqmark>:</td>
        <td>
			<july:radio insertable="true" updatable="true" property="afstype" value="I" styleClass="text"/>&nbsp;<bean:message key="label.afs.afstype.indoor"/>&nbsp;&nbsp;&nbsp;&nbsp;
			<july:radio insertable="true" updatable="true" property="afstype" value="O" styleClass="text"/>&nbsp;<bean:message key="label.afs.afstype.outdoor"/>
        </td>
    </tr>

    <july:separator/>

	<tr>
		<td class="text"><july:reqmark><bean:message key="label.afs.assembler"/></july:reqmark>:</td>
		<td>
			<july:radio insertable="true" updatable="true" property="type" value="P" onclick="switchFilter();" styleClass="text"/>&nbsp;<bean:message key="label.afs.provider"/>&nbsp;&nbsp;&nbsp;&nbsp;
			<july:radio insertable="true" updatable="true" property="type" value="W" onclick="switchFilter();" styleClass="text"/>&nbsp;<bean:message key="label.afs.worker"/>
		</td>
	</tr>
    
    <july:separator/>

    <tr>
        <td class="text">&nbsp;&nbsp;&nbsp;&nbsp;<july:reqmark><bean:message key="label.afs.provider"/></july:reqmark>:</td>
        <td>
			<july:string property="providercode" styleId="providercode" size="5" insertable="true" updatable="true" />
			<july:lookupbutton action="/ShowOrganizationLookupList.do" styleId="provl" fieldNames="providercode;providername" newWindowName="organizationlookup"  insertable="true" updatable="true" onclick="set_opt_params_provl('?selisprovider=true&selisrenter=false&selissupplier=false');"/>
			<july:string size="35" property="providername" styleId="providername" insertable="false" updatable="false" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text">&nbsp;&nbsp;&nbsp;&nbsp;<july:reqmark><bean:message key="label.afs.insuranceman"/></july:reqmark>:</td>
        <td>
			<july:string size="35" property="insuranseMan" insertable="true" updatable="true" />
        </td>
    </tr>

    <july:separator/>

    <tr>
        <td class="text">&nbsp;&nbsp;&nbsp;&nbsp;<july:reqmark><bean:message key="label.afs.worker"/></july:reqmark>:</td>
        <td nowrap>
			<july:string property="workercode" styleId="workercode" size="5" insertable="true" updatable="true" />
			<july:lookupbutton action="/ShowWorkerLookupList.do" styleId="work1l" fieldNames="workercode;workername;workertitle" newWindowName="workerlookup"  insertable="true" updatable="true" />
			<july:string size="25" property="workername" styleId="workername" insertable="false" updatable="false" />
			<july:string size="20" property="workertitle" styleId="workertitle" insertable="false" updatable="false" />
        </td>
    </tr>
    
    <july:separator/>

    <tr>
        <td class="text"><bean:message key="label.afs.worker2"/>:</td>
        <td nowrap>
			<july:string property="worker2code" styleId="worker2code" size="5" insertable="true" updatable="true" />
			<july:lookupbutton action="/ShowWorkerLookupList.do" styleId="work2l" fieldNames="worker2code;worker2name;worker2title" newWindowName="workerlookup"  insertable="true" updatable="true" />
			<july:string size="25" property="worker2name" styleId="worker2name" insertable="false" updatable="false" />
			<july:string size="20" property="worker2title" styleId="worker2title" insertable="false" updatable="false" />
        </td>
    </tr>
    
    <july:separator/>

    <tr>
        <td class="text"><bean:message key="label.afs.storageman"/>:</td>
        <td nowrap>
			<july:string property="storagemancode" styleId="storagemancode" size="5" insertable="true" updatable="true" />
			<july:lookupbutton action="/ShowWorkerLookupList.do" styleId="smanl" fieldNames="storagemancode;storagemanname;storagemantitle" newWindowName="workerlookup"  insertable="true" updatable="true" />
			<july:string size="25" property="storagemanname" styleId="storagemanname" insertable="false" updatable="false" />
			<july:string size="20" property="storagemantitle" styleId="storagemantitle" insertable="false" updatable="false" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><bean:message key="label.afs.state"/>:</td>
        <td>
		   <logic:equal name="AfsForm" property="dState" value="1">
	           <bean:message key="label.state.entering"/>
           </logic:equal>
		   <logic:equal name="AfsForm" property="dState" value="2">
	           <bean:message key="label.state.calculated"/>
           </logic:equal>
		   <logic:equal name="AfsForm" property="needapprove" value="true">
	           &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	           <bean:message key="label.mountact2.prjstate"/>: &nbsp;
	           <bean:write name="AfsForm" property="prjstatusname" filter="true"/>
           </logic:equal>
        </td>
    </tr>
    
    <july:separator/>
    
    <july:formbuttons>
<%if(("View".equals(aForm.getAction()) || "Edit".equals(aForm.getAction())) && !aForm.getIsautodoc()){%>
&nbsp;&nbsp;
	<%if("1".equals(aForm.getDState())) {%>
		<input type="image" name="submit" src="/images/calculate.gif" onclick="document.all.action.value='Edit';document.all.processState.value='P';document.all.warnProc.value='false';return checkPosted();" title="Обсчёт">
<%if(com.hps.july.util.AppUtils.isNewInventory()){%>
<%if(aForm.getWarnProc() != null && aForm.getWarnProc().booleanValue()) {%>
		<input type="image" name="submit" src="/images/calculatea.gif" onclick="document.all.action.value='Edit';document.all.processState.value='P';document.all.warnProc.value='true';return checkPosted();" title="Обсчёт с автоматическим исправлением несоответствий">
<%}%>
<html:hidden property="warnProc"/>
<%}%>
	<%} else if (canuncalc) {%>
		<html:link page="/ProcessAfs.do?action=Edit&processState=C" paramId="doc" paramName="AfsForm" paramProperty="doc" paramScope="session" onclick="return checkPosted();"><img src="/images/calculates.gif" border=0 alt="Снять обсчёт"></html:link>
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
					<july:addbutton page="/EditAfsAPosition.do?action=Add" alttext="label.afspos.addant" image="plusantenna.gif"/>
					<july:addbutton page="/EditAfsDPosition.do?action=Add" alttext="label.afspos.adddel" image="plussplitter.gif"/>
					<july:addbutton page="/EditAfsPosition.do?action=Add" alttext="label.afspos.add"/>
		<%}%></nobr></td>
		<td class="title" align="right"><bean:message key="label.assemblingp.positions"/></td>
	</tr>
	</table>
 </td>
</tr>
<july:separator colspan="<%= gColSpan %>" />
<tr>
<td colspan="2"><table class="main">
<tr class="title">
	<td class="title">&nbsp;</td>
	<july:headercolumn key="label.afs.numpp" colType="number"/>
	<july:headercolumn key="label.afsa.sector" colType="string"/>
	<july:headercolumn key="label.afs.antnum" colType="string"/>
	<july:headercolumn key="label.afs.name" colType="string"/>
	<july:headercolumn key="label.afs.qty.short" colType="string"/>
	<july:headercolumn key="label.afs.anttype" colType="string"/>
	<july:headercolumn key="label.afs.antaz" colType="string"/>
	<july:headercolumn key="label.afs.antnakl" colType="string"/>
	<july:headercolumn key="label.afs.policynum" colType="string"/>
	<td class="title">&nbsp;</td>
</tr>
<july:separator colspan="<%= gColSpan %>" />
<logic:iterate id="it" name="AfsForm" property="items" type="com.hps.july.cdbc.lib.CDBCRowObject">
<logic:present name="it">
<%
	Object o = it.getColumn("docposition").asObject();
	int docpos = 0;
	if(o instanceof Number) { docpos = ((Number)o).intValue(); }
	String docpostype = it.getColumn("docpostype").asString();
	pageContext.setAttribute("docpos",new Integer(docpos));
	String sect = "";
	String sectA = "", sectB = "";
	if("A".equals(docpostype)) {
		sectA = addSector(sectA,"s_a",it);
		sectA = addSector(sectA,"s_b",it);
		sectA = addSector(sectA,"s_c",it);
		sectA = addSector(sectA,"s_d",it);
		sectA = addSector(sectA,"s_od",it);

		sectB = addSector(sectB,"s_e",it);
		sectB = addSector(sectB,"s_f",it);
		sectB = addSector(sectB,"s_g",it);
		sectB = addSector(sectB,"s_h",it);
		sectB = addSector(sectB,"s_o",it);
		if(sectA != null && sectA.length() > 0) {
			if(sectB != null && sectB.length() > 0) {
				sect = sectA+"/"+sectB;
			} else {
				sect = sectA;
			}
		} else {
			sect = sectB;
		}

	} else if("B".equals(docpostype)) {
		sectA = addSector(sectA,"s_a",it);
		sectA = addSector(sectA,"s_b",it);
		sectA = addSector(sectA,"s_c",it);
		sectA = addSector(sectA,"s_d",it);
		sectA = addSector(sectA,"s_e",it);
		sectA = addSector(sectA,"s_o",it);
		sect = sectA;
	}
	pageContext.setAttribute("sect",sect);

	String sn = it.getColumn("invnum").asString();
/*
	String sn = it.getColumn("serialnumber").asString();
	String mf = it.getColumn("manufserial").asString();
	if(mf != null && mf.length() > 0 && !mf.equals(sn)) {
		sn += " ("+mf+")";
	}
	pageContext.setAttribute("snum",sn);
*/
	java.util.Iterator ii = aForm.listCableItems(new Integer(docpos));
	pageContext.setAttribute("cableitems",ii);
%>
	<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
		<td class="string">
<%if("A".equals(docpostype) || "B".equals(docpostype)) {%>
			<july:editbutton page="/EditAfsAPosition.do" action="Edit" paramId="docpos" paramName="docpos" paramScope="page" alttext="label.afspos.edit"/>
<%} else if ("E".equals(docpostype)) {%>
			<july:editbutton page="/EditAfsDPosition.do" action="Edit" paramId="docpos" paramName="docpos" paramScope="page" alttext="label.afspos.edit"/>
<%} else {%>
			<july:editbutton page="/EditAfsPosition.do" action="Edit" paramId="docpos" paramName="docpos" paramScope="page" alttext="label.afspos.edit"/>
<%}%>
		</td>
		<td class="number"><july:stringwrite name="it" property="order"/></td>
		<td class="text"><july:stringwrite name="sect"/></td>
		<td class="text"><july:stringwrite name="it" property="num_ant"/></td>
		<td class="text"><july:stringwrite name="it" property="antname"/></td>
		<td class="number" align=right><july:numberwrite name="it" property="qty"/> <july:stringwrite name="it" property="uname"/></td>
		<td class="text"><july:stringwrite name="it" property="kindant"/></td>
		<td class="number"><july:numberwrite name="it" property="az_ant"/></td>
		<td class="number"><july:numberwrite name="it" property="nakl"/></td>
		<td class="text"><july:stringwrite name="it" property="invnum"/></td>
		<td class="link">
<%if("A".equals(docpostype) || "B".equals(docpostype)) {%>
				<july:delbutton page="/EditAfsAPosition.do?action=Delete" paramId="docpos" paramName="docpos" paramScope="page" />
<%} else if("E".equals(docpostype)) {%>
				<july:delbutton page="/EditAfsDPosition.do?action=Delete" paramId="docpos" paramName="docpos" paramScope="page" />
<%} else { %>
				<july:delbutton page="/EditAfsPosition.do?action=Delete" paramId="docpos" paramName="docpos" paramScope="page" />
<%}%>
		</td>
	</tr>
	<logic:iterate id="cit" name="cableitems" type="com.hps.july.cdbc.lib.CDBCRowObject">
	<logic:present name="cit">
		<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
			<td class="string"></td>
			<td class="number"></td>
			<td class="text"></td>
			<td class="text"></td>
			<td class="text"><july:stringwrite name="cit" property="cablename"/></td>
			<td class="number" align=right><july:numberwrite name="cit" property="qty"/> <july:stringwrite name="cit" property="uname"/></td>
			<td class="text"></td>
			<td class="number"></td>
			<td class="number"></td>
			<td class="text"><july:stringwrite name="cit" property="invnum"/></td>
			<td class="link"></td>
		</tr>
	</logic:present>
	</logic:iterate>
	<july:separator colspan="<%= gColSpan %>" />
</logic:present>
</logic:iterate>
</table></td>
</tr>
<tr class="title">
	<td colspan="2" class="title">
	<table cellpadding=0 cellspacing=0 width=100% border=0 class="main">
	<tr>
		<td><nobr><%if(changable) {%>
					<july:addbutton page="/EditAfsAPosition.do?action=Add" alttext="label.afspos.addant" image="plusantenna.gif"/>
					<july:addbutton page="/EditAfsDPosition.do?action=Add" alttext="label.afspos.adddel" image="plussplitter.gif"/>
					<july:addbutton page="/EditAfsPosition.do?action=Add" alttext="label.afspos.add"/>
		<%}%></nobr></td>
		<td class="title" align="right">&nbsp;</td>
	</tr>
	</table>
	</td>
<%}%>
</tr>
</table>
<script language="javascript">switchFilter();</script>
</july:editform>
