<%@ page language = "java" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld" prefix="alex" %>
<%@ page contentType="TEXT/HTML; charset=windows-1251" %>
<%@ page import="org.apache.struts.util.*" %>
<%@ page import="com.hps.july.basestation.*" %>
<%@ page import="com.hps.july.basestation.formbean.*" %>
<%@ page import="com.hps.july.web.util.*" %>
<%@ page import="org.apache.struts.util.*" %>
<%@ page import="com.hps.july.persistence.*" %>
<%@ page import="com.hps.july.basestation.valueobject.*" %>
<%@ page import="com.hps.july.basestation.formbean.*" %>
<%@ page import="com.hps.july.jdbcpersistence.lib.Checks" %>

<%
	String action = null; 
	String form = null;
	switch (ParamsParser.getState(pageContext)) {
	case APPStates.REPEATER_ANTENNA_EDIT:
        	action = "/ProcessRepeaterAntenna.do";
		form = "RepeaterAntennaForm";
       	break;
	case APPStates.FROMSECTOR_REPEATER_ANTENNA_EDIT:
	       	action = "/ProcessFromSectorRepeaterAntenna.do";
		form = "FromSectorRepeaterAntennaForm";
       	break;
	}
%>

<july:editform action="<%= action %>" styleId="<%= form %>">
<%
	AntennaForm aform = (AntennaForm)pageContext.findAttribute(form);
%>
<html:hidden property="storageplace"/>
<input type="hidden" name="byhand" value="true">
<table class="main">
<july:separator/>
<tr>
	<td class="title" colspan="2"><july:actionalert/></td>
</tr>
<july:separator/>
<tr>
	<td class="text"><july:reqmark><bean:message key="AntennaForm.numant"/>:</july:reqmark></td>
	<td>
		<july:string property="numant" size="30" insertable="true" updatable="true" />
	</td>
</tr>
<tr>
	<td class="text"><july:reqmark><bean:message key="AntennaForm.azant"/>:</july:reqmark></td>
	<td>
		<july:string property="azantFrm" size="10" insertable="true" updatable="true" />
		&nbsp;&nbsp;&nbsp;
		<bean:message key="AntennaForm.azvariation"/>:
		<july:string property="azvariation" size="10" insertable="true" updatable="true" />
	</td>
</tr>
<tr>
	<td class="text">
		<july:reqmark><bean:message key="AntennaForm.kindant"/></july:reqmark> / <bean:message key="AntennaForm.locationtype"/>:
	</td>
	<td>
		<july:radio property="kindant" value="<%=AntennaObject.KINDANT_CHECK_T%>" insertable="true" updatable="true" styleClass="editcheckboxform"/>
		<%=AntennaObject.KINDANT_T_LABEL_T%>&nbsp;&nbsp;&nbsp;
		<july:radio property="kindant" value="<%=AntennaObject.KINDANT_CHECK_D%>" insertable="true" updatable="true" styleClass="editcheckboxform"/>
		<%=AntennaObject.KINDANT_D_LABEL_TR%>&nbsp;&nbsp;&nbsp;
		<july:radio property="kindant" value="<%=AntennaObject.KINDANT_CHECK_R%>" insertable="true" updatable="true" styleClass="editcheckboxform"/>
		<%=AntennaObject.KINDANT_R_LABEL_R%>

		/ 

		<july:select property="locationtype" styleId="locationtypeId" insertable='true' updatable='true' >
			<html:option key="AntennaForm.locationtype.outdoor" value="<%=Checks.ANTENNA_LOCATIONTYPE_OUTDOOR_O%>"/>
			<html:option key="AntennaForm.locationtype.indoor" value="<%=Checks.ANTENNA_LOCATIONTYPE_INDOOR_I%>"/>
		</july:select>
	</td>
</tr>

<script language="javascript">
function recalcSummnakl() {
	var m = parseFloat(document.all.naklFrm.value);
	if(m == 'NaN') { 
		document.all.sumnakl.value = document.all.naklFrm.value;
	} else {
		var ea1 = parseFloat(document.all.ea900f.value);
		var ea2 = parseFloat(document.all.ea1800f.value);
		if(isNaN(ea1)) { ea1 = 0; }
		if(isNaN(ea2)) { ea2 = 0; }
		if(ea1 != ea2) {
			document.all.sumnakl.value = Math.round((m + ea1)*100) /
			100 + '/' + Math.round((m + ea2)*100) / 100;
		} else {
			document.all.sumnakl.value = '' + Math.round((m + ea1)*100)/100;
		}
	}
}
</script>

<tr>
	<td class="text" nowrap><july:reqmark><bean:message key="AntennaForm.restype"/></july:reqmark></td>
	<td class="text" nowrap>
		<july:string property="resourceIdFrm" styleId="resourcetype" size="5" insertable="true" updatable="true"/>
		<july:lookupbutton action="/ShowAntennaResLookupList.do" formname="<%= form %>" newWindowName="antenL"  styleId="aresId" fieldNames="resourcetype;resourcetypename;resBandId;ea800f;ea900f;ea1800f;antpol" insertable="true" updatable="true"/>
		<july:string size="25" property="resourceName" styleId="resourcetypename" insertable="false" updatable="false" />
<input type='hidden' name='resBand' id='resBandId' value='<%=aform.getResBandsString()%>'/>
<html:hidden property="ea800" styleId="ea800f"/>
<html:hidden property="ea900" styleId="ea900f"/>
<html:hidden property="ea1800" styleId="ea1800f"/>
<html:hidden property="antpol" styleId="antpol"/>
	</td>
</tr>

<tr>
	<td class="text" nowrap>Серийный номер антенны:</td>
	<td class="text" nowrap>
		<july:string size="25" property="resourceSerial" styleId="resourceSerial" insertable="true" updatable="true" />
	</td>
</tr>

<tr>
<td class="text"><july:reqmark><bean:message key="AntennaForm.nakl"/>:</july:reqmark></td>
	<td>
		<july:string property="naklFrm" size="10" insertable="true" updatable="true" onchange="recalcSummnakl();"/>
		&nbsp;&nbsp;&nbsp;
		<bean:message key="AntennaForm.naklvariation"/>:
		<july:string property="naklvariation" size="20" insertable="true" updatable="true" />
	</td>
</tr>

<tr>
	<td class="text"><bean:message key="AntennaForm.sumnakl"/>:</td>
	<td>
		<july:string property="sumnakl" size="10" insertable="false" updatable="false" />
	</td>
</tr>

<tr>
	<td class="text"><july:reqmark><bean:message key="AntennaForm.hset1"/>:</july:reqmark></td>
	<td>
		<july:string property="hset1Frm" size="10" insertable="true" updatable="true" />
		&nbsp;&nbsp;&nbsp;
		<bean:message key="AntennaForm.inputpower"/>:
		<july:string property="inputpowerFrm" size="10" insertable="true" updatable="true" />
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
<%--
		<td class="title" align="center">КСВН<br>800</td>
		<td class="title" align="center">КСВН<br>900</td>
		<td class="title" align="center">КСВН<br>1800</td>
--%>
	</tr>

	<tr class="normal" id="cable1">
		<td class="title">Кабель 1</td>
		<td class="text">
			<july:select collection="cableTypes" property="cab1.cabletype.string" insertable="true" updatable="true" style="width:400px;" styleClass="editsearch">
				<html:option value="0">&nbsp;</html:option>
				<html:options collection="cableTypes" property="resource" labelProperty="fullName"/>
			</july:select>
		</td>
		<td class="text"><july:string property="cab1.length.string" size="5" insertable="true" updatable="true" styleClass="editkodsearch" /></td>
		<td class="text"><july:string property="cab1.gnds.string" size="10" insertable="true" updatable="true" styleClass="editsmallsearch"/></td>
<%--
		<td class="text"><july:string property="cab1.ksvn800.string" size="5" insertable="true" updatable="true" styleClass="editkodsearch" /></td>
		<td class="text"><july:string property="cab1.ksvn900.string" size="5" insertable="true" updatable="true" styleClass="editkodsearch" /></td>
		<td class="text"><july:string property="cab1.ksvn1800.string" size="5" insertable="true" updatable="true" styleClass="editkodsearch" /></td>
--%>
	</tr>

	<tr class="normal" id="cable2">
		<td class="title">Кабель 2</td>
		<td class="text">
			<july:select collection="cableTypes" property="cab2.cabletype.string" insertable="true" updatable="true" style="width:400px;" styleClass="editsearch">
				<html:option value="0">&nbsp;</html:option>
				<html:options collection="cableTypes" property="resource" labelProperty="fullName"/>
			</july:select>
		</td>
		<td class="text"><july:string property="cab2.length.string" size="5" insertable="true" updatable="true" styleClass="editkodsearch" /></td>
		<td class="text"><july:string property="cab2.gnds.string" size="10" insertable="true" updatable="true" styleClass="editsmallsearch" /></td>
<%--
		<td class="text"><july:string property="cab2.ksvn800.string" size="5" insertable="true" updatable="true" styleClass="editkodsearch" /></td>
		<td class="text"><july:string property="cab2.ksvn900.string" size="5" insertable="true" updatable="true" styleClass="editkodsearch" /></td>
		<td class="text"><july:string property="cab2.ksvn1800.string" size="5" insertable="true" updatable="true" styleClass="editkodsearch" /></td>
--%>
	</tr>
	</table></td>
</tr>

<july:separator/>
<july:formbuttons/>
<july:separator/>
</table>

</july:editform>
