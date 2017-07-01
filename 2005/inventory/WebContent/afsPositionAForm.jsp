<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import="com.hps.july.inventory.formbean.*,com.hps.july.inventory.actionbean.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<july:editform action="/ProcessAfsAPosition.do">

<%
	AfsForm docfrm = (AfsForm)request.getSession().getAttribute("AfsForm");
	AfsAPositionForm frm = (AfsAPositionForm)request.getAttribute("AfsAPositionForm");
	String updatable = String.valueOf("1".equals(docfrm.getDState()) && !docfrm.getIsautodoc() && ("Add".equals(frm.getAction()) || "Edit".equals(frm.getAction())));
%>
<script language="javascript">
function updateCables() {
	var bc = 0;
	if(document.all.antennaType.value == 'A') {
		var band900 = document.all.sectorE[0].checked || document.all.sectorF[0].checked || document.all.sectorG[0].checked || document.all.sectorH[0].checked || document.all.sectorO[0].checked;
		var band1800 = document.all.sectorA[0].checked || document.all.sectorB[0].checked || document.all.sectorC[0].checked || document.all.sectorD[0].checked || document.all.sectorO1800[0].checked;
		if(band900) {
			bc = bc + 1;
		}
		if(band1800) {
			bc = bc + 1;
		}
		if("V" == document.all.antpol.value) {
			document.all.cable1.style.display = 'block';
			document.all['cab1.cabletype.string'].disabled = false;
			if(bc > 1) {
				document.all.cable2.style.display = 'block';
				document.all['cab2.cabletype.string'].disabled = false;
			} else {
				document.all.cable2.style.display = 'none';
				document.all['cab2.cabletype.string'].disabled = true;
			}
			document.all.cable3.style.display = 'none';
			document.all['cab3.cabletype.string'].disabled = true;
			document.all.cable4.style.display = 'none';
			document.all['cab4.cabletype.string'].disabled = true;
		} else if("C" == document.all.antpol.value) {
			document.all.cable1.style.display = 'block';
			document.all['cab1.cabletype.string'].disabled = false;
			document.all.cable2.style.display = 'block';
			document.all['cab2.cabletype.string'].disabled = false;
			if(bc > 1) {
				document.all.cable3.style.display = 'block';
				document.all['cab3.cabletype.string'].disabled = false;
				document.all.cable4.style.display = 'block';
				document.all['cab4.cabletype.string'].disabled = false;
			} else {
				document.all.cable3.style.display = 'none';
				document.all['cab3.cabletype.string'].disabled = true;
				document.all.cable4.style.display = 'none';
				document.all['cab4.cabletype.string'].disabled = true;
			}
		}

		var cls = band900?"editkodsearch":"editkoddisabled";
		document.all['cab1.ksvn900.string'].disabled = !band900;
		document.all['cab1.ksvn900.string'].className = cls;
		document.all['cab2.ksvn900.string'].disabled = !band900;
		document.all['cab2.ksvn900.string'].className = cls;
		document.all['cab3.ksvn900.string'].disabled = !band900;
		document.all['cab3.ksvn900.string'].className = cls;
		document.all['cab4.ksvn900.string'].disabled = !band900;
		document.all['cab4.ksvn900.string'].className = cls;

		var cls2 = band1800?"editkodsearch":"editkoddisabled";
		document.all['cab1.ksvn1800.string'].disabled = !band1800;
		document.all['cab1.ksvn1800.string'].className = cls2;
		document.all['cab2.ksvn1800.string'].disabled = !band1800;
		document.all['cab2.ksvn1800.string'].className = cls2;
		document.all['cab3.ksvn1800.string'].disabled = !band1800;
		document.all['cab3.ksvn1800.string'].className = cls2;
		document.all['cab4.ksvn1800.string'].disabled = !band1800;
		document.all['cab4.ksvn1800.string'].className = cls2;
	} else if(document.all.antennaType.value == 'B') {
		var band800 = document.all.sectorA.checked || document.all.sectorB.checked || document.all.sectorC.checked || document.all.sectorD.checked || document.all.sectorE.checked || document.all.sectorO.checked;
		if(band800) { bc = 1; }
		if("V" == document.all.antpol.value) {
			document.all.cable1.style.display = 'block';
			document.all['cab1.cabletype.string'].disabled = false;
			document.all.cable2.style.display = 'none';
			document.all['cab2.cabletype.string'].disabled = true;
			document.all.cable3.style.display = 'none';
			document.all['cab3.cabletype.string'].disabled = true;
			document.all.cable4.style.display = 'none';
			document.all['cab4.cabletype.string'].disabled = true;
		} else if("C" == document.all.antpol.value) {
			document.all.cable1.style.display = 'block';
			document.all['cab1.cabletype.string'].disabled = false;
			document.all.cable2.style.display = 'block';
			document.all['cab2.cabletype.string'].disabled = false;
			document.all.cable3.style.display = 'none';
			document.all['cab3.cabletype.string'].disabled = true;
			document.all.cable4.style.display = 'none';
			document.all['cab4.cabletype.string'].disabled = true;
		}
		var cls = band800?"editkodsearch":"editkoddisabled";
		document.all['cab1.ksvn800.string'].disabled = !band800;
		document.all['cab1.ksvn800.string'].className = cls;
		document.all['cab2.ksvn800.string'].disabled = !band800;
		document.all['cab2.ksvn800.string'].className = cls;
		document.all['cab3.ksvn800.string'].disabled = !band800;
		document.all['cab3.ksvn800.string'].className = cls;
		document.all['cab4.ksvn800.string'].disabled = !band800;
		document.all['cab4.ksvn800.string'].className = cls;
	}
}

function switchLookup(itemname,lookupname,disabled) {
	var dall = document.all;
	if(disabled) {
		dall[itemname].className = 'editdisabled';
		dall[itemname].disabled = true;
		dall[itemname].readonly = true;
		dall['lookupbtn_'+lookupname+'l'].disabled = true;
		dall['lookupimg_'+lookupname+'l'].src='/images/lookup_disabled.gif';
		dall['lookupbtn_'+lookupname+'l'].style.cursor = 'default';
/*		dall['lookupimg_'+lookupname+'l'].style.cursor = 'default';*/
	} else {
		dall[itemname].className = 'edit';
		dall[itemname].disabled = false;
		dall[itemname].readonly = false;
		dall['lookupbtn_'+lookupname+'l'].disabled = false;
		dall['lookupimg_'+lookupname+'l'].src='/images/lookup.gif';
		dall['lookupbtn_'+lookupname+'l'].style.cursor = 'hand';
/*		dall['lookupimg_'+lookupname+'l'].style.cursor = 'hand';*/
	}
}

</script>

<html:hidden property="docpos" />
<html:hidden property="antpol" />
<html:hidden property="owner.string" />
<html:hidden property="antennaType"/>
<html:hidden name="AfsForm" property="positioncode" />
<html:hidden name="AfsForm" property="complectcode" />
<html:hidden name="AfsForm" property="expeditionstr" />

<html:hidden name="AfsForm" property="doc"/>

<input type="hidden" name="_dummy_" value="">

<table class="main">

<july:separator/>

<july:formbuttons/>
    
<july:separator/>

<tr>
	<td class="title" colspan="2"><july:actionalert/></td>
</tr>
<july:separator/>
<tr>
	<td class="title"><bean:message key="label.afsa.document"/></td>
	<td class="title"><bean:message key="label.num"/>
		<%-- &nbsp;<bean:write name="AfsForm" property="blankindex"/> --%>
		&nbsp;<bean:write name="AfsForm" property="blanknumber"/>&nbsp;<bean:message key="label.from" />&nbsp;<bean:write name="AfsForm" property="blankdatestr"/></td>
</tr>
<july:separator/>
<tr>
	<td class="title"><bean:message key="label.afs.owner"/></td>
	<td class="title"><bean:write name="AfsForm" property="ownername"/></td>
</tr>
<july:separator/>
<tr>
	<td class="title"><bean:message key="label.afs.position"/></td>
	<td class="title"><bean:write name="AfsForm" property="positionname"/></td>
</tr>
<july:separator/>
<tr>
	<td class="title"><bean:message key="label.afs.complect"/></td>
	<td class="title"><bean:write name="AfsForm" property="complectname"/></td>
</tr>
<logic:present name="AfsForm" property="type">
<logic:equal name="AfsForm" property="type" value="P">
<july:separator/>
	<tr>
		<td class="title"><bean:message key="label.afs.provider"/>:</td>
		<td class="title">
			<bean:write name="AfsForm" property="providername"/>
		</td>
	</tr>
<july:separator/>
	<tr>
		<td class="title"><bean:message key="label.afs.insuranceman"/>:</td>
		<td class="title">
			<bean:write name="AfsForm" property="insuranseMan"/>
		</td>
	</tr>
</logic:equal>
<logic:equal name="AfsForm" property="type" value="W">
<july:separator/>
	<tr>
		<td class="title"><bean:message key="label.afs.worker"/>:</td>
		<td class="title">
			<bean:write name="AfsForm" property="workername"/>
		</td>
	</tr>
</logic:equal>
</logic:present>
<july:separator/>
<tr>
	<td class="text"><july:reqmark><bean:message key="label.afsa.numpp"/></july:reqmark>:</td>
	<td>
		<july:string property="order.string" size="10" insertable="<%=updatable%>" updatable="<%=updatable%>" />
	</td>
</tr>
<july:separator/>
<tr class="title">
	<td class="title" colspan="2"><bean:message key="label.afsa.antenna"/></td>
</tr>
<july:separator/>
<tr>
	<td class="text">
		<july:reqmark><bean:message key="label.afsa.sector"/></july:reqmark>
	</td>
	<td>
<logic:equal name="AfsAPositionForm" property="antennaType" value="B">
		800:
		<july:checkbox styleClass="text" property="sectorA" insertable="true" updatable="true" value="true" onclick="updateCables();"/>A&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<july:checkbox styleClass="text" property="sectorB" insertable="true" updatable="true" value="true" onclick="updateCables();"/>B&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<july:checkbox styleClass="text" property="sectorC" insertable="true" updatable="true" value="true" onclick="updateCables();"/>C&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<july:checkbox styleClass="text" property="sectorD" insertable="true" updatable="true" value="true" onclick="updateCables();"/>D&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<july:checkbox styleClass="text" property="sectorE" insertable="true" updatable="true" value="true" onclick="updateCables();"/>E&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<july:checkbox styleClass="text" property="sectorO" insertable="true" updatable="true" value="true" onclick="updateCables();"/>O&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</logic:equal>
<logic:equal name="AfsAPositionForm" property="antennaType" value="A">
		<table class="main"><tr><td class="text">1800:</td>
		        <td>
				<july:checkbox styleClass="text" property="sectorA" insertable="true" updatable="true" value="true" onclick="updateCables();"/>&nbsp;A&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<july:checkbox styleClass="text" property="sectorB" insertable="true" updatable="true" value="true" onclick="updateCables();"/>&nbsp;B&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<july:checkbox styleClass="text" property="sectorC" insertable="true" updatable="true" value="true" onclick="updateCables();"/>&nbsp;C&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<july:checkbox styleClass="text" property="sectorD" insertable="true" updatable="true" value="true" onclick="updateCables();"/>&nbsp;D&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<july:checkbox styleClass="text" property="sectorO1800" insertable="true" updatable="true" value="true" onclick="updateCables();"/>&nbsp;O&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			</td>
		</tr><tr><td class="text">900:</td>
			<td>
				<july:checkbox styleClass="text" property="sectorE" insertable="true" updatable="true" value="true" onclick="updateCables();"/>&nbsp;E&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<july:checkbox styleClass="text" property="sectorF" insertable="true" updatable="true" value="true" onclick="updateCables();"/>&nbsp;F&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<july:checkbox styleClass="text" property="sectorG" insertable="true" updatable="true" value="true" onclick="updateCables();"/>&nbsp;G&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<july:checkbox styleClass="text" property="sectorH" insertable="true" updatable="true" value="true" onclick="updateCables();"/>&nbsp;H&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<july:checkbox styleClass="text" property="sectorO" insertable="true" updatable="true" value="true" onclick="updateCables();"/>&nbsp;O&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			</td>
		</tr></table>
</logic:equal>
	</td>
</tr>
<july:separator/>
<tr>
	<td class="text"><july:reqmark><bean:message key="label.afsa.num_ant"/></july:reqmark>:</td>
	<td>
		<july:string property="num_ant" size="15" insertable="<%=updatable%>" updatable="<%=updatable%>" />
	</td>
</tr>
<july:separator/>
<tr>
	<td class="text"><july:reqmark><bean:message key="label.afsa.az_ant"/></july:reqmark>:</td>
	<td>
		<july:string property="az_ant.string" size="5" insertable="<%=updatable%>" updatable="<%=updatable%>" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<bean:message key="label.afsa.az_variation"/>
		<july:string property="az_variation" size="15" insertable="<%=updatable%>" updatable="<%=updatable%>" />
	</td>
</tr>
<july:separator/>
<tr>
	<td class="text"><july:reqmark><bean:message key="label.afsa.kind_ant"/></july:reqmark>:</td>
	<td>
		<july:radio property="kind_ant" insertable="<%=updatable%>" updatable="<%=updatable%>" value="T" styleClass="text"/>&nbsp;T&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<july:radio property="kind_ant" insertable="<%=updatable%>" updatable="<%=updatable%>" value="D" styleClass="text"/>&nbsp;TR&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<july:radio property="kind_ant" insertable="<%=updatable%>" updatable="<%=updatable%>" value="R" styleClass="text"/>&nbsp;R
	</td>
</tr>
<july:separator/>
<tr>
	<td class="text"><july:reqmark><bean:message key="label.afsa.antenna"/>:</july:reqmark></td>
	<td>
		<july:string size="5" property="antenna.string" styleId="antenna.string" insertable="<%=updatable%>" updatable="<%=updatable%>" />
<july:lookupbutton action="/../basestation/ShowAntennaResLookupList.do" styleId="arl" fieldNames="antenna.string;antennaname;_dummy_;_dummy_;_dummy_;_dummy_;antpol;" newWindowName="resourcelookup" insertable="<%=updatable%>" updatable="<%=updatable%>" onselect="updateCables();"/>
<%--
		<july:lookupbutton action="/ShowResourceLookupList.do" styleId="arl" fieldNames="antenna.string;antennamodel;antennaname" newWindowName="resourcelookup" insertable="<%=updatable%>" updatable="<%=updatable%>"/>
--%>
		<july:string size="50" property="antennaname" styleId="antennaname" insertable="false" updatable="false" />
<%--
		<july:string size="15" property="antennamodel" styleId="antennamodel" insertable="false" updatable="false" />
--%>
	</td>
</tr>
    
<july:separator/>

<tr>
	<td class="text"><bean:message key="label.afsa.qty"/>:</td>
	<td>
		<july:string property="qty.string" size="5" insertable="false" updatable="false" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<bean:message key="label.afsa.price"/>
		<july:string property="price.string" size="15" insertable="false" updatable="false" />
	</td>
</tr>
    
<july:separator/>

<tr>
	<td class="text"><bean:message key="label.afsa.serialnum"/>:</td>
	<td>
<script language="javascript">
function checkFictionSerial() {
	if(document.all.action.value == 'Add' || document.all.action.value == 'Edit') {
		switchLookup('snumber','ser',document.all.fictionSerial[0].checked);
	}
}
</script>
		<july:string property="snumber" size="15" insertable="<%=updatable%>" updatable="<%=updatable%>" />
		<july:lookupbutton action="/ShowCardLookupList.do" styleId="serl" onclick="set_opt_params_serl('?pagetype=2&owner=&storage='+document.all.expeditionstr.value+'&resource='+document.all['antenna.string'].value+'&agregate=&brokentype=1&documentkey='+document.all.doc.value);" fieldNames="antenna.string;antennaname;antennamodel;_dummy_;snumber;_dummy_;_dummy_;_dummy_;_dummy_;_dummy_;owner.string;_dummy_" newWindowName="seriallookup" insertable="<%=updatable%>" updatable="<%=updatable%>"/>&nbsp;
		<july:checkbox property="fictionSerial" insertable="<%=updatable%>" updatable="<%=updatable%>" value="true" styleClass="text" onclick="checkFictionSerial();"/>с/н неизвестен
		
		<%if(updatable.equals("true")){%>
			<script language="javascript">checkFictionSerial();</script>
		<%}%>

	</td>
</tr>
    
<july:separator/>
    
<tr>
	<td class="text"><july:reqmark><bean:message key="label.fitplace"/>:</july:reqmark></td>
	<td>
		<july:string property="fitplace" size="20" insertable="<%=updatable%>" updatable="<%=updatable%>" />
	</td>
</tr>
    
<july:separator/>

<tr>
	<td class="text"><july:reqmark><bean:message key="label.afsa.nakl"/></july:reqmark>:</td>
	<td>
		<july:string property="nakl.string" size="5" insertable="<%=updatable%>" updatable="<%=updatable%>" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<bean:message key="label.afsa.nakl_variation"/>
		<july:string property="nakl_variation" size="15" insertable="<%=updatable%>" updatable="<%=updatable%>" />
	</td>
</tr>

<july:separator/>

<tr>
	<td class="text"><july:reqmark><bean:message key="label.afsa.h_set1"/></july:reqmark>:</td>
	<td>
		<july:string property="h_set1.string" size="5" insertable="<%=updatable%>" updatable="<%=updatable%>" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		Мощность на входе антенны:<july:string property="inputpower.string" size="15" insertable="<%=updatable%>" updatable="<%=updatable%>" />
	</td>
</tr>

<july:separator/>

<tr>
	<td class="text"><bean:message key="label.afsa.presence"/></td>
	<td>
<logic:equal name="AfsAPositionForm" property="antennaType" value="A">
		<july:checkbox styleClass="text" property="ddk" insertable="<%=updatable%>" updatable="<%=updatable%>" value="true"/>&nbsp;<bean:message key="label.afsa.ddk"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</logic:equal>
		<july:checkbox styleClass="text" property="has_flt" insertable="<%=updatable%>" updatable="<%=updatable%>" value="true"/>&nbsp;<bean:message key="label.afsa.has_flt"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<july:checkbox styleClass="text" property="has_lna" insertable="<%=updatable%>" updatable="<%=updatable%>" value="true"/>&nbsp;<bean:message key="label.afsa.has_lna"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<july:checkbox styleClass="text" property="has_buster" insertable="<%=updatable%>" updatable="<%=updatable%>" value="true"/>&nbsp;<bean:message key="label.afsa.has_buster"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	</td>
</tr>

<july:separator/>

<tr>
	<td class="text"><bean:message key="label.inventory.comment"/>:</td>
	<td>
		<july:string property="comment" size="40" insertable="<%=updatable%>" updatable="<%=updatable%>" />
	</td>
</tr>

<july:separator/>

<tr>
	<td class="text" colspan=2><table style="font-family: Verdana,Arial;font-size:10pt;margin:0px;width:100%" border=0>
	<tr class="title">
		<td class="title"></td>
		<td class="title" align="center">Тип кабеля</td>
		<td class="title" align="center">Длина</td>
		<td class="title" align="center">К-во<br>заземлений</td>
<logic:equal name="AfsAPositionForm" property="antennaType" value="A">
		<td class="title" align="center">КСВН<br>900</td>
		<td class="title" align="center">КСВН<br>1800</td>
</logic:equal>
<logic:equal name="AfsAPositionForm" property="antennaType" value="B">
		<td class="title" align="center">КСВН<br>800</td>
</logic:equal>
	</tr>

	<tr class="normal" id="cable1">
		<td class="title">Кабель 1</td>
		<td class="text">
			<july:select collection="cableTypes" property="cab1.cabletype.string" insertable="true" updatable="true" style="width:200px;" styleClass="editsearch">
				<html:option value="0">&nbsp;</html:option>
				<html:options collection="cableTypes" property="resource" labelProperty="fullName"/>
			</july:select>
		</td>
		<td class="text"><july:string property="cab1.length.string" size="5" insertable="true" updatable="true" styleClass="editkodsearch" /></td>
		<td class="text"><july:string property="cab1.gnds.string" size="10" insertable="true" updatable="true" styleClass="editsmallsearch"/></td>
<logic:equal name="AfsAPositionForm" property="antennaType" value="A">
		<td class="text"><july:string property="cab1.ksvn900.string" size="5" insertable="true" updatable="true" styleClass="editkodsearch" /></td>
		<td class="text"><july:string property="cab1.ksvn1800.string" size="5" insertable="true" updatable="true" styleClass="editkodsearch" /></td>
</logic:equal>
<logic:equal name="AfsAPositionForm" property="antennaType" value="B">
		<td class="text"><july:string property="cab1.ksvn800.string" size="5" insertable="true" updatable="true" styleClass="editkodsearch" /></td>
</logic:equal>
	</tr>

	<tr class="normal" id="cable2">
		<td class="title">Кабель 2</td>
		<td class="text">
			<july:select collection="cableTypes" property="cab2.cabletype.string" insertable="true" updatable="true" style="width:200px;" styleClass="editsearch">
				<html:option value="0">&nbsp;</html:option>
				<html:options collection="cableTypes" property="resource" labelProperty="fullName"/>
			</july:select>
		</td>
		<td class="text"><july:string property="cab2.length.string" size="5" insertable="true" updatable="true" styleClass="editkodsearch" /></td>
		<td class="text"><july:string property="cab2.gnds.string" size="10" insertable="true" updatable="true" styleClass="editsmallsearch" /></td>
<logic:equal name="AfsAPositionForm" property="antennaType" value="A">
		<td class="text"><july:string property="cab2.ksvn900.string" size="5" insertable="true" updatable="true" styleClass="editkodsearch" /></td>
		<td class="text"><july:string property="cab2.ksvn1800.string" size="5" insertable="true" updatable="true" styleClass="editkodsearch" /></td>
</logic:equal>
<logic:equal name="AfsAPositionForm" property="antennaType" value="B">
		<td class="text"><july:string property="cab2.ksvn800.string" size="5" insertable="true" updatable="true" styleClass="editkodsearch" /></td>
</logic:equal>
	</tr>

	<tr class="normal" id="cable3">
		<td class="title">Кабель 3</td>
		<td class="text">
			<july:select collection="cableTypes" property="cab3.cabletype.string" insertable="true" updatable="true" style="width:200px;" styleClass="editsearch">
				<html:option value="0">&nbsp;</html:option>
				<html:options collection="cableTypes" property="resource" labelProperty="fullName"/>
			</july:select>
		</td>
		<td class="text"><july:string property="cab3.length.string" size="5" insertable="true" updatable="true" styleClass="editkodsearch" /></td>
		<td class="text"><july:string property="cab3.gnds.string" size="10" insertable="true" updatable="true" styleClass="editsmallsearch" /></td>
<logic:equal name="AfsAPositionForm" property="antennaType" value="A">
		<td class="text"><july:string property="cab3.ksvn900.string" size="5" insertable="true" updatable="true" styleClass="editkodsearch" /></td>
		<td class="text"><july:string property="cab3.ksvn1800.string" size="5" insertable="true" updatable="true" styleClass="editkodsearch" /></td>
</logic:equal>
<logic:equal name="AfsAPositionForm" property="antennaType" value="B">
		<td class="text"><july:string property="cab3.ksvn800.string" size="5" insertable="true" updatable="true" styleClass="editkodsearch" /></td>
</logic:equal>
	</tr>

	<tr class="normal" id="cable4">
		<td class="title">Кабель 4</td>
		<td class="text">
			<july:select collection="cableTypes" property="cab4.cabletype.string" insertable="true" updatable="true" style="width:200px;" styleClass="editsearch">
				<html:option value="0">&nbsp;</html:option>
				<html:options collection="cableTypes" property="resource" labelProperty="fullName"/>
			</july:select>
		</td>
		<td class="text"><july:string property="cab4.length.string" size="5" insertable="true" updatable="true" styleClass="editkodsearch" /></td>
		<td class="text"><july:string property="cab4.gnds.string" size="10" insertable="true" updatable="true" styleClass="editsmallsearch" /></td>
<logic:equal name="AfsAPositionForm" property="antennaType" value="A">
		<td class="text"><july:string property="cab4.ksvn900.string" size="5" insertable="true" updatable="true" styleClass="editkodsearch" /></td>
		<td class="text"><july:string property="cab4.ksvn1800.string" size="5" insertable="true" updatable="true" styleClass="editkodsearch" /></td>
</logic:equal>
<logic:equal name="AfsAPositionForm" property="antennaType" value="B">
		<td class="text"><july:string property="cab4.ksvn800.string" size="5" insertable="true" updatable="true" styleClass="editkodsearch" /></td>
</logic:equal>
	</tr>
	</table></td>
</tr>

<july:separator/>
	
<july:formbuttons/>
    
<july:separator/>
    
</table>
<script language="javascript">
updateCables();
</script>
</july:editform>

