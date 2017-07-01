<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld" prefix="alex" %>
<%@ page import="org.apache.struts.util.*"%>
<%@ page import="com.hps.july.jdbcpersistence.lib.*"%>
<%@ page import="com.hps.july.web.util.*"%>
<%@ page import="com.hps.july.constants.Applications"%>
<%@ page import="com.hps.july.basestation.formbean.RepeaterForm"%>
<%@ page import="com.hps.july.basestation.*"%>

<%
	String action = null;
	String form = null;
	switch (ParamsParser.getState(pageContext)) {
		case APPStates.REPEATER_EDIT:
			action = "/ProcessRepeater.do";
			form = "RepeaterForm";
			break;
		case APPStates.FROMSECTOR_REPEATER_EDIT:
			action = "/ProcessFromSectorRepeater.do";
			form = "FromSectorRepeaterForm";
			break;
	}
%>

<%	RepeaterForm dForm = (RepeaterForm)session.getAttribute(form); %>

<script language='javascript'>
function changeDonorType() {
	if (document.all.donortype.value == "A") {
		document.all.adcode.className = 'editkod';
		document.all.adcode.disabled = false;
		document.all['lookupimg_all'].src='/images/lookup.gif';
	} else {
		document.all.adcode.className = 'editkoddisabled';
		document.all.adcode.disabled = true;
		document.all['lookupimg_all'].src='/images/lookup_disabled.gif';		
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
</script>

<html:hidden property="positionIdFrm"/>
<%	if (ParamsParser.getState(pageContext) == APPStates.FROMSECTOR_REPEATER_EDIT) { %>
	<jsp:include page="/repeaterForm/positionFields.jsp" flush="true"/>
	<july:separator/>
<%	} else if (ParamsParser.getState(pageContext) == APPStates.REPEATER_EDIT) { %>
	<jsp:include page="/common/positionLookupFields.jsp" flush="true"/>
	<july:separator/>
<%	} %>

<tr>
	<td class="text"><july:reqmark/><bean:message key="label.repeater.donorbs"/>:</td>
	<td class="text">
		<july:string property="donorbs.keyFrm" styleId="dbskey" size="5" insertable='true' updatable='true' />
		<july:lookupbutton formname="EquipmentPForm" action="/ShowBSLookupList.do" styleId="bsl" fieldNames="dbskey;dbsname" newWindowName="bslookup" insertable="true" updatable="true"/>
		<july:string size="35" property="donorbs.fullname" styleId="dbsname" insertable="false" updatable="false" />
	</td>
</tr>

<tr>
	<td class="text"><july:reqmark/><bean:message key="label.repeater.donorsector"/>:</td>
	<td class="text">
		<july:string property="donorsector.keyFrm" styleId="dskey" size="5" insertable='true' updatable='true' />
		<july:lookupbutton formname="EquipmentPForm" action="/ShowBSSectorLookupList.do" styleId="sectl" fieldNames="dskey;dsname" onclick="if(document.all.dbskey.value == '') { alert('Сначала нужно выбрать донорную БС!'); return false; } else { set_opt_params_sectl('?bs.keyFrm='+document.all.dbskey.value); }" newWindowName="sectorlookup" insertable="true" updatable="true"/>
		<july:string size="35" property="donorsector.fullname" styleId="dsname" insertable="false" updatable="false" />
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
	<td class="text"><july:reqmark/><bean:message key="label.repeaterform.number"/>:</td>
		<july:string property="number" styleId="number" size="15" insertable='true' updatable='true' />
	</td>
</tr>

<tr>
	<td class="text"><bean:message key="label.repeaterform.donor.resource"/>:</td>
	<td class="text">
		<july:string property="antennadonorcodeFrm" styleId="adcode" size="5" insertable="true" updatable="true"/>
		<july:lookupbutton formname="<%= form %>" action="/ShowBSAntennaLookupList.do" styleId="antl" 
			fieldNames="adcode;dresname;azimut" insertable="true" updatable="true" 
			onclick="set_opt_params_antl('?bs.keyFrm='+document.all.dbskey.value+'&sector.keyFrm='+document.all.dskey.value)" newWindowName="BSAntennaLookup"/>
		<july:string size="20" property="donorresourcename" styleId="dresname" insertable="false" updatable="false"/>
		 &nbsp;&nbsp;&nbsp;&nbsp; 
		<nowrap><bean:message key="label.repeaterform.donor.az"/>:
		<july:string property="azimut" styleId="azimut" size="5" insertable="false" updatable="false"/></nowrap>
	</td>
</tr>
<%--
<tr>
	<td class="text"><bean:message key="label.repeaterform.donor.az"/>:</td>
	<td class="text"><july:string property="azimut" styleId="azimut" size="10" insertable="false" updatable="false"/></td>
</tr>
--%>
<logic:equal name="<%= form %>" property="action" value="Edit">
	<jsp:include page="/repeaterForm/antennaList.jsp" flush="true"/>
</logic:equal>

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
	<td class="text"><july:reqmark/><bean:message key="repeaterlist.resource"/>:</td>
	<td class="text">
		<july:string property="resourcecodeFrm" styleId="rescode" size="5" insertable="true" updatable="true"/>
		<july:lookupbutton formname="<%= form %>" action="/ShowRepeaterResLookupList.do" styleId="rrll"
		onclick="set_opt_params_rrll('?islinear='+getIsLinear())"
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

<jsp:include page="/common/equipmentStateFields.jsp" flush="true"/>

<logic:notEqual name="<%= form %>" property="action" value="Delete">
	<logic:notEqual name="<%= form %>" property="action" value="View">
		<script language='javascript'>
			changeDonorType();
			changeRepiterClass();
		</script>
	</logic:notEqual>
</logic:notEqual>
