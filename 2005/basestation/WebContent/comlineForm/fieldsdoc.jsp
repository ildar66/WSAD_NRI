<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld" prefix="alex" %>
<%@ page import="org.apache.struts.util.*"%>
<%@ page import="com.hps.july.jdbcpersistence.lib.*"%>
<%@ page import="com.hps.july.constants.Applications"%>
<%@ page import="com.hps.july.basestation.formbean.ComlineRForm"%>
<%@ page import="com.hps.july.basestation.valueobject.BaseStationObject"%>

<%
ComlineRForm dForm=(ComlineRForm)request.getAttribute("ComlineRForm");
%>

<html:hidden property="height_aFrm"/>
<html:hidden property="diam_aFrm"/>
<html:hidden property="freqa1Frm"/>
<html:hidden property="freqa2Frm"/>
<html:hidden property="poweraFrm"/>

<html:hidden property="height_bFrm"/>
<html:hidden property="diam_bFrm"/>
<html:hidden property="freqb1Frm"/>
<html:hidden property="freqb2Frm"/>
<html:hidden property="powerbFrm"/>

<html:hidden property="speed"/>
<html:hidden property="rezerv"/>
<html:hidden property="abis_number"/>
<html:hidden property="lease_info"/>
<html:hidden property="hopscomment"/>

<html:hidden property="rescodea"/>
<html:hidden property="resnamea"/>

<html:hidden property="azimutab"/>
<html:hidden property="azimutba"/>

<SCRIPT language="JavaScript">
function setComplectA(isnew) {
	if(document.all.action.value == 'Add') {
		if (isnew) {
			ComlineRForm.lookupimg_cequa.src = "/images/lookup_disabled.gif";
//			ComlineRForm.lookupimg_resla.src = "/images/lookup.gif";
//			ComlineRForm.equipnamea.readOnly = false;
//			ComlineRForm.equipnamea.className = "edit";
		} else {
			ComlineRForm.lookupimg_cequa.src = "/images/lookup.gif";
//			ComlineRForm.lookupimg_resla.src = "/images/lookup_disabled.gif";
//			ComlineRForm.equipnamea.readOnly = true;
//			ComlineRForm.equipnamea.className = "editdisabled";
		}
	}
}
function setComplectB(isnew) {
	if(document.all.action.value == 'Add') {
		if (isnew) {
			ComlineRForm.lookupimg_cequb.src = "/images/lookup_disabled.gif";
//			ComlineRForm.lookupimg_reslb.src = "/images/lookup.gif";
//			ComlineRForm.equipnameb.readOnly = false;
//			ComlineRForm.equipnameb.className = "edit";
		} else {
			ComlineRForm.lookupimg_cequb.src = "/images/lookup.gif";
//			ComlineRForm.lookupimg_reslb.src = "/images/lookup_disabled.gif";
//			ComlineRForm.equipnameb.readOnly = true;
//			ComlineRForm.equipnameb.className = "editdisabled";
		}
	}
}
function clear_equipa() {
	if(document.all.action.value == 'Add') {
		if (ComlineRForm.newcomplecta [1].checked) {
			document.all.equipmentid_enda.value='0';
			document.all.equipnamea.value='';
			document.all.resnamea.value=''
		}
	}
}
function clear_equipb() {
	if(document.all.action.value == 'Add') {
		if (ComlineRForm.newcomplectb [1].checked) {
			document.all.equipmentid_endb.value='0';
			document.all.equipnameb.value='';
			document.all.resnameb.value=''
		}
	}
}
function onSelectPositionA() {
	document.all.equipmentid_enda.value='';
	document.all.equipnamea.value='';
	document.all.rescodea.value='';
	document.all.resnamea.value='';
	document.all.commenta.value='';
}
function onSelectPositionB() {
	document.all.equipmentid_endb.value='';
	document.all.equipnameb.value='';
	document.all.rescodeb.value='';
	document.all.resnameb.value='';
	document.all.commentb.value='';
}
</SCRIPT>

<%if(dForm.isShowregions()) {%>
<tr>
	<td class="text" width="25%"><bean:message key="ComlineForm.region"/>:</td>
	<td class="text">
		<bean:write name="ComlineRForm" property="regiona" filter="true"/><%if(dForm.getRegionb() != null) {%> - <bean:write name="ComlineRForm" property="regionb" filter="true"/><%}%>
	</tr>
</tr>
<%}%>

<tr>
	<td class="text" width="25%"><july:reqmark><bean:message key="ComlineForm.prolet"/>:</july:reqmark></td>
	<td class="text">
		<july:string property="hopsname" size="50" insertable="true" updatable="false" />
	</td>
</tr>

<july:separator />

<tr>
	<td colspan="2">
	<table class="main">
	<tr>
		<td class="text" width="25%"><bean:message key="ComlineForm.beenet"/>:</td>
		<td class="text" width="25%">
			<july:string property="beenetid" size="8" insertable="true" updatable="false" />
		</td>
		<td class="text" width="25%"><bean:message key="ComlineForm.hopslength"/>:</td>
		<td class="text" width="25%">
			<july:string property="hopslength" size="10" insertable="false" updatable="false" />
			<bean:message key="ComlineForm.len_units"/>
		</td>
	</tr>
	</table>
	</td>
</tr>

<july:separator />

<tr class="title">
	<td class="title" colspan="2">
		<bean:message key="ComlineForm.equcomplecta"/>:
<logic:equal name="ComlineRForm" property="action" value="Add">
		&nbsp;
		<july:radio property="newcomplecta" value="Y" onclick="setComplectA(true)" insertable="true" updatable="true" styleClass="text">
			&nbsp;<bean:message key="ComlineForm.newcomplect"/>
		</july:radio>&nbsp;&nbsp;&nbsp;
		<july:radio property="newcomplecta" value="N" onclick="setComplectA(false)" insertable="true" updatable="true" styleClass="text">
			&nbsp;<bean:message key="ComlineForm.oldcomplect"/>
		</july:radio>
</logic:equal>
<logic:notEqual name="ComlineRForm" property="action" value="Add">
		<html:hidden property="newcomplecta" value="N"/>
</logic:notEqual>
	</td>
</tr>
<%-- Поля комплекта А --%>
<tr>
	<td colspan="2">
	<table class="main">
	<tr>
		<td class="text" width="25%"><july:reqmark><bean:message key="ComlineForm.positiona"/>:</july:reqmark></td>
		<td class="text" colspan="3">
			<july:string property="posidaFrm" size="5" insertable="true" updatable="false" />
			<july:lookupbutton  action="/ShowPositionLookupList.do" styleId="posla" formname="ComlineRForm" fieldNames="posidaFrm;posnamea;supregnamea;regionnamea;zonenamea;addra;latitudea;longitudea;datebeginbuilda;bsDampsNuma;bsGsmNuma;bsDampsNamea;bsGsmNameaa" newWindowName="poslookup" insertable="true" updatable="false" onselect="onSelectPositionA();"/>
			<july:string size="25" property="posnamea" styleId="posnamea" insertable="false" updatable="false" />
			<input type='hidden' name='supregnamea' value=''>
			<input type='hidden' name='regionnamea' value=''>
			<input type='hidden' name='zonenamea' value=''>
			<input type='hidden' name='addra' value=''>
			<input type='hidden' name='latitudea' value=''>
			<input type='hidden' name='longitudea' value=''>
			<input type='hidden' name='datebeginbuilda' value=''>
			<input type='hidden' name='bsDampsNuma' value=''>
			<input type='hidden' name='bsGsmNuma' value=''>
			<input type='hidden' name='bsDampsNamea' value=''>
			<input type='hidden' name='bsGsmNameaa' value=''>
		</td>
	</tr>
	<tr>
		<td class="text"><july:reqmark><bean:message key="ComlineForm.complecta"/>:</july:reqmark></td>
		<td class="text" colspan="3">
			<html:hidden property="equipmentid_enda" />
			<july:string size="25" property="equipnamea" styleId="equipnamea" insertable="true" updatable="false" />
			<july:lookupbutton action="/ShowComEquipmentLookupList.do" styleId="cequa" onclick="set_opt_params_cequa('?position=' + document.all.posidaFrm.value);" fieldNames="equipmentid_enda;dummy1;dummy1;equipnamea" formname="ComlineRForm" newWindowName="poslookup" insertable="true" updatable="false"/>
		</td>
	</tr>
	<tr>
		<td class="text"><bean:message key="ComlineForm.commenta"/>:</td>
		<td class="text" colspan="3">
			<july:string property="commenta" size="35" insertable="true" updatable="false" />
		</td>
	</tr>
	<tr>
		<td class="text"><bean:message key="ComlineForm.azimut"/>:</td>
		<td class="text" colspan="3">
			<july:string property="azimutabdocFrm" size="10" insertable="true" updatable="true" />
		</td>
	</tr>
	<tr>
		<td class="text" width="25%"><bean:message key="ComlineForm.heighta"/>:</td>
		<td class="text" width="25%">
			<july:string property="height_a_docFrm" size="10" insertable="true" updatable="true" styleClass='<%=dForm.getFieldClassName("height_a")%>'/>
			<bean:message key="ComlineForm.height_units"/>
		</td>
		<td class="text" width="25%"><bean:message key="ComlineForm.diama"/>:</td>
		<td class="text" width="25%">
			<july:string property="diam_a_docFrm" size="10" insertable="true" updatable="true" styleClass='<%=dForm.getFieldClassName("diam_a")%>'/>
			<bean:message key="ComlineForm.diam_units"/>
		</td>
	</tr>
	<tr>
		<td class="text"><bean:message key="ComlineForm.freqa1"/>:</td>
		<td class="text">
			<july:string property="freqadocFrm" size="10" insertable="true" updatable="true" styleClass='<%=dForm.getFieldClassName("freq_a")%>'/>
			<bean:message key="ComlineForm.freq_units"/>
		</td>
		<td class="text"></td>
		<td class="text"></td>
	</tr>
<%--
	<tr>
		<td class="text"><bean:message key="ComlineForm.resourcea"/>:</td>
		<td class="text">
			<html:hidden property="rescodea" />
			<july:string size="10" property="resnamea" styleId="resmodela" insertable="false" updatable="false" />
			<july:lookupbutton href="/inventory/ShowResourceLookupList.do" styleId="resla" fieldNames="rescodea;resmodela;res_shnamea;res_namea" formname="ComlineRForm" newWindowName="resourcelookup" insertable="true" updatable="true"/>
			<input type='hidden' name='res_namea' value=''>
			<input type='hidden' name='res_shnamea' value=''>
		</td>
		<td class="text"><bean:message key="ComlineForm.powera"/>:</td>
		<td class="text">
			<july:string property="poweraFrm" size="10" insertable="true" updatable="true" />
			<bean:message key="ComlineForm.power_units"/>
		</td>
	</tr>
--%>
	</table>
	</td>
</tr>

<july:separator />

<tr class="title">
	<td class="title" colspan="2">
		<bean:message key="ComlineForm.equcomplectb"/>:
<logic:equal name="ComlineRForm" property="action" value="Add">
		&nbsp;
		<july:radio property="newcomplectb" value="Y" onclick="setComplectB(true)" insertable="true" updatable="true" styleClass="text">
			&nbsp;<bean:message key="ComlineForm.newcomplect"/>
		</july:radio>&nbsp;&nbsp;&nbsp;
		<july:radio property="newcomplectb" value="N" onclick="setComplectB(false)" insertable="true" updatable="true" styleClass="text">
			&nbsp;<bean:message key="ComlineForm.oldcomplect"/>
		</july:radio>
</logic:equal>
<logic:notEqual name="ComlineRForm" property="action" value="Add">
		<html:hidden property="newcomplectb" value="N"/>
</logic:notEqual>
	</td>
</tr>
<tr>
	<td colspan="2">
	<table class="main">
	<tr>
		<td class="text" width="25%"><july:reqmark><bean:message key="ComlineForm.positionb"/>:</july:reqmark></td>
		<td class="text" colspan="3">
			<july:string property="posidbFrm" size="5" insertable="true" updatable="false" />
			<july:lookupbutton  action="/ShowPositionLookupList.do" styleId="poslb" fieldNames="posidbFrm;posnameb;supregnameb;regionnameb;zonenameb;addrb;latitudeb;longitudeb;datebeginbuildb;bsDampsNumb;bsGsmNumb;bsDampsNameb;bsGsmNameb" formname="ComlineRForm" newWindowName="poslookup" insertable="true" updatable="false"/>
			<july:string size="25" property="posnameb" styleId="posnameb" insertable="false" updatable="false" />
			<input type='hidden' name='supregnameb' value=''>
			<input type='hidden' name='regionnameb' value=''>
			<input type='hidden' name='zonenameb' value=''>
			<input type='hidden' name='addrb' value=''>
			<input type='hidden' name='latitudeb' value=''>
			<input type='hidden' name='longitudeb' value=''>
			<input type='hidden' name='datebeginbuildb' value=''>
			<input type='hidden' name='bsDampsNumb' value=''>
			<input type='hidden' name='bsGsmNumb' value=''>
			<input type='hidden' name='bsDampsNameb' value=''>
			<input type='hidden' name='bsGsmNameb' value=''>
		</td>
	</tr>
	<tr>
		<td class="text"><july:reqmark><bean:message key="ComlineForm.complectb"/>:</july:reqmark></td>
		<td class="text" colspan="3">
			<html:hidden property="equipmentid_endb" />
			<july:string size="25" property="equipnameb" styleId="equipnameb" insertable="true" updatable="false" />
			<july:lookupbutton action="/ShowComEquipmentLookupList.do" styleId="cequb" onclick="set_opt_params_cequb('?position=' + document.all.posidbFrm.value);" fieldNames="equipmentid_endb;dummy1;dummy1;equipnameb" formname="ComlineRForm" newWindowName="poslookup" insertable="true" updatable="false"/>
		</td>
	</tr>
	<tr>
		<td class="text"><bean:message key="ComlineForm.commentb"/>:</td>
		<td class="text" colspan="3">
			<july:string property="commentb" size="35" insertable="true" updatable="false" />
		</td>
	</tr>
	<tr>
		<td class="text"><bean:message key="ComlineForm.azimut"/>:</td>
		<td class="text" colspan="3">
			<july:string property="azimutbadocFrm" size="10" insertable="true" updatable="true" />
		</td>
	</tr>
	<tr>
		<td class="text" width="25%"><bean:message key="ComlineForm.heightb"/>:</td>
		<td class="text" width="25%">
			<july:string property="height_b_docFrm" size="10" insertable="true" updatable="true" styleClass='<%=dForm.getFieldClassName("height_b")%>'/>
			<bean:message key="ComlineForm.height_units"/>
		</td>
		<td class="text" width="25%"><bean:message key="ComlineForm.diamb"/>:</td>
		<td class="text" width="25%">
			<july:string property="diam_b_docFrm" size="10" insertable="true" updatable="true" styleClass='<%=dForm.getFieldClassName("diam_b")%>'/>
			<bean:message key="ComlineForm.diam_units"/>
		</td>
	</tr>
	<tr>
		<td class="text"><bean:message key="ComlineForm.freqb1"/>:</td>
		<td class="text">
			<july:string property="freqbdocFrm" size="10" insertable="true" updatable="true" styleClass='<%=dForm.getFieldClassName("freq_b")%>'/>
			<bean:message key="ComlineForm.freq_units"/>
		</td>
		<td class="text"></td>
		<td class="text"></td>
	</tr>
<%--
	<tr>
		<td class="text"><bean:message key="ComlineForm.resourceb"/>:</td>
		<td class="text">
			<html:hidden property="rescodeb" />
			<july:string size="10" property="resnameb" styleId="resmodelb" insertable="false" updatable="false" />
			<july:lookupbutton href="/inventory/ShowResourceLookupList.do" styleId="reslb" fieldNames="rescodeb;resmodelb;res_shnameb;res_nameb" formname="ComlineRForm" newWindowName="resourcelookup" insertable="true" updatable="true"/>
			<input type='hidden' name='res_nameb' value=''>
			<input type='hidden' name='res_shnameb' value=''>
		</td>
		<td class="text"><bean:message key="ComlineForm.powerb"/>:</td>
		<td class="text">
			<july:string property="powerbFrm" size="10" insertable="true" updatable="true" />
			<bean:message key="ComlineForm.power_units"/>
		</td>
	</tr>
--%>
	</table>
	</td>
</tr>

<july:separator />

<tr class="title">
	<td class="title" colspan="2"><bean:message key="ComlineForm.hopparams"/></td>
</tr>

<tr>
	<td colspan="2">
	<table class="main">
	<tr>
		<td class="text" width="25%"><bean:message key="ComlineForm.resourceb"/>:</td>
		<td class="text" width="25%">
			<html:hidden property="rescodedoc" />
			<july:string size="10" property="resnamedoc" styleId="resmodeldoc" insertable="false" updatable="false" styleClass='<%=dForm.getFieldClassName("rescode")%>'/>
			<july:lookupbutton href="/inventory/ShowResourceLookupList.do" styleId="resldoc" fieldNames="rescodedoc;resmodeldoc;res_shnamedoc;res_namedoc" formname="ComlineRForm" newWindowName="resourcelookup" insertable="true" updatable="true"/>
			<input type='hidden' name='res_namedoc' value=''>
			<input type='hidden' name='res_shnamedoc' value=''>
		</td>
		<td class="text" width="25%"><bean:message key="ComlineForm.powerb"/>:</td>
		<td class="text" width="25%">
			<july:string property="powerdocFrm" size="10" insertable="true" updatable="true" />
			<bean:message key="ComlineForm.power_units"/>
		</td>
	</tr>
	<tr>
		<td class="text"><bean:message key="ComlineForm.speed"/>:</td>
		<td class="text">
			<%--july:string property="speed_doc" size="5" insertable="true" updatable="true" /--%>
			<july:select property="speed_doc" insertable="true" updatable="true">
				<html:option key="ComlineForm.speed.void" value=""/>
				<html:option key="ComlineForm.speed.1X2" value="1X2"/>
				<html:option key="ComlineForm.speed.2X2" value="2X2"/>
				<html:option key="ComlineForm.speed.4X2" value="4X2"/>
				<html:option key="ComlineForm.speed.8X2" value="8X2"/>
				<html:option key="ComlineForm.speed.16X2" value="16X2"/>
				<html:option key="ComlineForm.speed.16X22" value="16X2+2"/>
				<html:option key="ComlineForm.speed.155" value="155"/>
			</july:select>
			<bean:message key="ComlineForm.speed_units"/>
		</td>
		<td class="text">&nbsp;</td>
		<td class="text">&nbsp;</td>
	</tr>
	<tr>
		<td class="text"><july:reqmark><bean:message key="ComlineForm.hopstate"/></july:reqmark>:</td>
		<td class="text" colspan="3">
			<july:select property="hopstate" styleId="hopstate" insertable="true" updatable="true">
				<html:option key="ComlineForm.state.A" value="A"/>
				<html:option key="ComlineForm.state.B" value="B"/>
				<html:option key="ComlineForm.state.C" value="C"/>
				<html:option key="ComlineForm.state.D" value="D"/>
			</july:select>
		</td>
	</tr>
	<tr>
		<td class="text"><bean:message key="label.comline.permstatus"/>:</td>
		<td class="text">
			<july:select property="permstatus" styleId="permstatus" insertable="true" updatable="true">
				<html:option key="label.comline.permstatus.0" value="0"/>
				<html:option key="label.comline.permstatus.1" value="1"/>
				<html:option key="label.comline.permstatus.2" value="2"/>
				<html:option key="label.comline.permstatus.3" value="3"/>
				<html:option key="label.comline.permstatus.4" value="4"/>
				<html:option key="label.comline.permstatus.5" value="5"/>
				<html:option key="label.comline.permstatus.6" value="6"/>
				<html:option key="label.comline.permstatus.7" value="7"/>
				<html:option key="label.comline.permstatus.8" value="8"/>
				<html:option key="label.comline.permstatus.9" value="9"/>
			</july:select>
		</td>
		<td class="text"><bean:message key="ComlineForm.comment_doc"/>:</td>
		<td class="text">
			<july:string property="comment_doc" size="15" insertable="true" updatable="true" />
		</td>
	</tr>
	</table>
	</td>
</tr>
<%if(request.isUserInRole("FreqManager")||request.isUserInRole("administrator")) {%>
<july:separator />
<tr>
	<td colspan="2">
	<table class="main">
	<tr>
		<td class="text" width="25%"><bean:message key="ComlineForm.file"/>:</td>
		<td class="text" width="25%"><july:string property="file_number" size="10" insertable="true" updatable="true" /></td>
		<td class="text" width="25%"><bean:message key="ComlineForm.numberinfile"/>:</td>
		<td class="text" width="25%"><july:string property="number_in_file" size="3" insertable="false" updatable="false" /></td>
	</tr>
	<tr>
		<td class="text"><bean:message key="ComlineForm.sfonumber"/>:</td>
		<td class="text"><july:string property="sfonumber" size="10" insertable="true" updatable="true" /></td>
		<td class="text"></td>
		<td class="text"></td>
	</tr>
	</table>
	</td>
</tr>
<%}%>
<SCRIPT>
	if(document.all.action.value == 'Add') {
		setComplectA(ComlineRForm.newcomplecta [0].checked);
		setComplectB(ComlineRForm.newcomplectb [0].checked);
	}
</SCRIPT>

