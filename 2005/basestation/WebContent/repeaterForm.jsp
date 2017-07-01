<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld" prefix="alex" %>
<%@ page import="com.hps.july.jdbcpersistence.lib.Checks"%>
<%@ page import="org.apache.struts.util.*"%>
<%@ page import="com.hps.july.basestation.formbean.*"%>
<%@ page import="com.hps.july.web.util.*"%>
<%@ page import="com.hps.july.basestation.*"%>

<%
	String action = null;
	String form = null;
	int formState = ParamsParser.getState(pageContext);
	String bsEditable = "false";
	switch (formState) {
		case APPStates.REPEATER_EDIT:
			action = "/ProcessRepeater.do";
			form = "RepeaterForm";
			bsEditable = "true";
			break;
		case APPStates.FROMSECTOR_REPEATER_EDIT:
			action = "/ProcessFromSectorRepeater.do";
			form = "FromSectorRepeaterForm";
			break;
	}
%>

<%
	request.setAttribute("colspan", "2");	//для использования во включенных jsp
	RepeaterForm dForm = (RepeaterForm) pageContext.findAttribute(form);
	request.setAttribute("EquipmentPForm", dForm);
%>

<july:editform action="<%= action %>" styleId="EquipmentPForm">

<html:hidden property="donor_sectCode"/>
<html:hidden property="storageplace"/>
<html:hidden property="positionIdFrm"/>
<html:hidden property="positionModel.divisionFrm"/>

<table class="main">

<july:separator/>
<july:formbuttons/>
<july:separator/>
<tr>
	<td class="title" colspan="2"><july:actionalert/></td>
</tr>

<july:separator/>

<% if("edit".equals(dForm.getAction()) || "View".equals(dForm.getAction())) { %>
<jsp:include page="/repeaterForm/actionsMenu.jsp" flush="true"/>
<% } %>

<script language='javascript'>
function changeDonorType() {
	if (document.all.donortype.value == "A") {
		document.all.antennadonorcodeFrm.className = 'editkod';
		document.all.antennadonorcodeFrm.disabled = false;
		document.all['lookupimg_antl'].src='/images/lookup.gif';
	} else {
		document.all.antennadonorcodeFrm.className = 'editkoddisabled';
		document.all.antennadonorcodeFrm.disabled = true;
		document.all['lookupimg_antl'].src='/images/lookup_disabled.gif';		
	}
}

function changeRepiterClass() {
	if (document.all.repiterclass.value == "A" || document.all.repiterclass.value == "D" || document.all.repiterclass.value == "E") {
		document.all.bandw.className = 'editsmall';
		document.all.bandw.disabled = false;
		document.all.numchan.className = 'editsmalldisabled';
		document.all.numchan.disabled = true;
	} else if (document.all.repiterclass.value == "B" || document.all.repiterclass.value == "C") {
		document.all.bandw.className = 'editsmalldisabled';
		document.all.bandw.disabled = true;
		document.all.numchan.className = 'editsmall';
		document.all.numchan.disabled = false;
	}
}

function getIsLinear() {
	return (document.all.repiterclass.value == "B" || document.all.repiterclass.value == "C") ? "false" : "true";
}

//if(document.all.dbskey.value == '') { alert('Сначала нужно выбрать донорную БС!'); return false; } else { set_opt_params_sectl('?bs.keyFrm='+document.all.dbskey.value); return true; }
function dbsonselect() {
	document.all.dskey.value = '';
	document.all.dsname.value= '';
	document.all.adcode.value= '';
	document.all.dresname.value= '';
	document.all.azimut.value= '';
}
</script>

<jsp:include page="/repeaterForm/positionLookupFields.jsp" flush="true"/>

<july:separator/>

<tr>
	<td class="text"><july:reqmark/><bean:message key="label.repeater.donorbs"/>:</td>
	<td class="text">
		<html:hidden property="donorbs.keyFrm" styleId="dbskey" />
		<july:string size="35" property="donorbs.fullname" styleId="dbsname" insertable="false" updatable="false" />
		<july:lookupbutton formname="EquipmentPForm" action="/ShowBSLookupList.do" styleId="bsl" fieldNames="dbskey;dbsname" onselect="dbsonselect();" newWindowName="bslookup" insertable="<%=bsEditable%>" updatable="<%=bsEditable%>"/>
	</td>
</tr>

<tr>
	<td class="text"><july:reqmark/><bean:message key="label.repeater.donorsector"/>:</td>
	<td class="text">
		<html:hidden property="donorsector.keyFrm" styleId="dskey"/>
		<july:string size="35" property="donorsector.fullname" styleId="dsname" insertable="false" updatable="false" />
		<july:lookupbutton formname="EquipmentPForm" action="/ShowBSSectorLookupList.do" styleId="sectl" fieldNames="dskey;dsname" onclick="if(document.all.dbskey.value == '') { alert('Сначала нужно выбрать донорную БС!'); return false; } else { set_opt_params_sectl('?bs.keyFrm='+document.all.dbskey.value); }" newWindowName="sectorlookup" insertable="<%=bsEditable%>" updatable="<%=bsEditable%>"/>
	</td>
</tr>

<tr>
	<td class="text"><july:reqmark/><bean:message key="label.repeater.donortype"/>:</td>
	<td class="text">
		<july:select property="donor_type" styleId="donortype" insertable="true" updatable="true" onchange="changeDonorType();">
			<html:option key="repeaterlist.donortype.a" value="A"/>
			<html:option key="repeaterlist.donortype.b" value="B"/>
			<html:option key="repeaterlist.donortype.c" value="C"/>
		</july:select>
	</td>
</tr>

<tr>
	<td class="text"><bean:message key="label.repeaterform.donor.resource"/>:</td>
	<td class="text">
		<html:hidden property="antennadonorcodeFrm" styleId="adcode"/>
		<july:string size="20" property="donorresourcename" styleId="dresname" insertable="false" updatable="false"/>
		<july:lookupbutton formname="<%= form %>" action="/ShowBSAntennaLookupList.do" styleId="antl" 
			fieldNames="adcode;dresname;azimut" insertable="true" updatable="true" 
			onclick="if(document.all.dskey.value == '') { alert('Сначала нужно выбрать донорный сектор!'); return false; } else { set_opt_params_antl('?bs.keyFrm='+document.all.dbskey.value+'&sector.keyFrm='+document.all.dskey.value);}" newWindowName="BSAntennaLookup"/>
		<logic:notEqual name="<%=form%>" property="action" value="Delete">
		<logic:notEqual name="<%=form%>" property="action" value="View">
		<input type="image" name="clearcontract" src="/images/clear.gif" alt="Очистить" onclick="adcode.value=''; return false;">
		</logic:notEqual>
		</logic:notEqual>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <nobr>Азимут: <july:string property="azimut" styleId="azimut" size="5" insertable="false" updatable="false"/></nobr>
	</td>
</tr>
<%if("edit".equals(dForm.getAction()) || "View".equals(dForm.getAction())) {%>
	<jsp:include page="/repeaterForm/antennaList.jsp" flush="true"/>
<%}%>

<tr>
	<td class="text"><july:reqmark/><bean:message key="repeaterlist.repiterclass"/>:</td>
	<td class="text">
		<july:select style="width: 450;" property="repiter_class" styleId="repiterclass" insertable="true" updatable="true" onchange="changeRepiterClass();">
			<html:option key="repeaterlist.repiterclass.a" value="A"/>
			<html:option key="repeaterlist.repiterclass.b" value="B"/>
			<html:option key="repeaterlist.repiterclass.c" value="C"/>
			<html:option key="repeaterlist.repiterclass.d" value="D"/>
			<html:option key="repeaterlist.repiterclass.e" value="E"/>
		</july:select>
	</td>
</tr>

<tr>
	<td class="text"><july:reqmark/><bean:message key="label.repeaterform.number"/>:</td>
	<td class="text">
		<july:string size="15" property="numberFrm" styleId="numberFrm" insertable="true" updatable="true" />
	</td>
</tr>

<tr>
	<td class="text"><bean:message key="repeaterlist.resource"/>:</td>
	<td class="text">
		<july:string property="resourcecodeFrm" styleId="rescode" size="5" insertable="true" updatable="true"/>
		<july:lookupbutton formname="<%= form %>" action="/ShowRepeaterResLookupList.do" styleId="rrll" onclick="set_opt_params_rrll('?islinear='+getIsLinear())"
		fieldNames="rescode;resname;reppower;numchan;bandw" insertable="true" updatable="true" 
		 newWindowName="RepeaterRes"/>
		<july:string size="30" property="resourcename" styleId="resname" insertable="false" updatable="false"/>
	</td>
</tr>

<tr>
	<td class="text"><july:reqmark><bean:message key="repeaterlist.reppower"/>:</july:reqmark></td>
	<td class="text"><july:string property="reppowerFrm" size="10" insertable="true" updatable="true" styleId="reppower"/></td>
</tr>

<tr>
	<td class="text"><bean:message key="label.repeaterform.numchanals"/>:</td>
	<td class="text">
		<july:string property="numchanalsFrm" size="10" insertable="true" updatable="true" styleId="numchan"/>
		 &nbsp;&nbsp;&nbsp;&nbsp; 
		<bean:message key="label.repeaterform.bandwidth"/>:
		<july:string size="10" property="bandwidthFrm" insertable="true" updatable="true" styleId="bandw"/>
	</td>
</tr>

<july:separator/>

<jsp:include page="/common/equipmentBaseFields.jsp" flush="true"/>

<july:separator/>

<tr>
	<td class="text"><bean:message key="label.repeaterform.dateassembafs"/>:</td>
	<td class="text">
		<july:date property="date_assemb_afsFrm" required="false" styleId="dateassembafsId" size="25" insertable='true' updatable='true'/>
	</td>
</tr>

<july:separator/>

<tr>
	<td class="text"><bean:message key="label.repeaterform.date_connect"/>:</td>
	<td class="text">
		<july:date property="date_connectFrm" required="false" styleId="dateconnectId" size="25" insertable='true' updatable='true'/>
	</td>
</tr>

<july:separator/>

<tr>
	<td class="text"><bean:message key="label.repeaterform.date_onair"/>:</td>
	<td class="text">
		<july:date property="date_onairFrm" required="false" styleId="dateonairId" size="25" insertable='true' updatable='true'/>
	</td>
</tr>

<july:separator/>

<jsp:include page="/common/equipmentStateFields.jsp" flush="true"/>

<logic:notEqual name="<%= form %>" property="action" value="Delete">
	<logic:notEqual name="<%= form %>" property="action" value="View">
		<script language='javascript'>
			changeDonorType();
			changeRepiterClass();
		</script>
	</logic:notEqual>
</logic:notEqual>

<july:separator/>

<july:formbuttons/>

<july:separator/>

</table>

</july:editform>
