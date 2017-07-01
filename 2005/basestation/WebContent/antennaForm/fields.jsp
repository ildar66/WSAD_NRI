<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld" prefix="alex" %>
<%@ page import="org.apache.struts.util.*"%>
<%@ page import="com.hps.july.persistence.*"%>
<%@ page import="com.hps.july.basestation.valueobject.*,com.hps.july.basestation.formbean.*"%>
<%@ page import="com.hps.july.jdbcpersistence.lib.Checks"%>

<%@ include file="/antennaForm/baseStationFields.jsp"  %>

<%
	AntennaForm form=(AntennaForm)pageContext.findAttribute("AntennaForm");
%>

<july:separator/>

<input type="hidden" name="byhand" value="true"  >

<%--Номер антены--%>
<tr>
	<td class="text"><july:reqmark><bean:message key="AntennaForm.numant"/>:</july:reqmark></td>
	<td>
		<july:string property="numant" size="30" insertable="true" updatable="true" />
	</td>
</tr>
<%--Азимут--%>
<%--Диапазон регулировки по азимуту--%>
<tr>
	<td class="text"><july:reqmark><bean:message key="AntennaForm.azant"/>:</july:reqmark></td>
	<td>
		<july:string property="azantFrm" size="10" insertable="true" updatable="true" />
		&nbsp;&nbsp;&nbsp;
		<bean:message key="AntennaForm.azvariation"/>:
		<july:string property="azvariation" size="10" insertable="true" updatable="true" />
	</td>
</tr>

<%--Вид антенны--%>
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
//		alert('800:'+document.all.ea800f.value+' 900:'+document.all.ea900f.value+' 1800:'+document.all.ea1800f.value);
//		alert('M:'+m+' EA1:'+ea1+' EA2:'+ea2);
		if(ea1 != ea2) {
			document.all.sumnakl.value = Math.round((m + ea1)*100) /
			100 + '/' + Math.round((m + ea2)*100) / 100;
		} else {
			document.all.sumnakl.value = '' + Math.round((m + ea1)*100)/100;
		}
	}
}
</script>

<%--тип оборудования--%>
<tr>
	<td class="text" nowrap><july:reqmark><bean:message key="AntennaForm.restype"/></july:reqmark></td>
	<td class="text" nowrap>
		<july:string property="resourceIdFrm" styleId="resourcetype" size="5" insertable="true" updatable="true"/>
		<july:lookupbutton action="/ShowAntennaResLookupList.do" formname="af" newWindowName="antenL"  styleId="aresId" fieldNames="resourcetype;resourcetypename;resBandId;ea800f;ea900f;ea1800f;"  insertable="true" updatable="true" onselect="recalcSummnakl();"/>
		<july:string size="25" property="resourceName" styleId="resourcetypename" insertable="false" updatable="false" />
<input type='hidden' name='resBand' id='resBandId'  value='<%=form.getResBandsString()%>'/>
<html:hidden property="ea800" styleId="ea800f"/>
<html:hidden property="ea900" styleId="ea900f"/>
<html:hidden property="ea1800" styleId="ea1800f"/>
	</td>
</tr>

<tr>
	<td class="text" nowrap>Серийный номер антенны:</td>
	<td class="text" nowrap>
		<july:string size="25" property="resourceSerial" styleId="resourceSerial" insertable="true" updatable="true" />
	</td>
</tr>

<tr>
<%--диапазон +--%>
<td class="text"><bean:message key="Sector.band"/>:</td>
<td>
	<logic:equal name="AntennaForm" property="bsForm.stationType" value="<%=BaseStationObject.TYPE_CHECK_DAMPS_D%>" >
		<july:checkbox property="bandcodes" styleId="bandcodeId" insertable="true" updatable="true" value="800" />&nbsp;800&nbsp;&nbsp;&nbsp;
	</logic:equal>
	<logic:notEqual name="AntennaForm" property="bsForm.stationType" value="<%=BaseStationObject.TYPE_CHECK_DAMPS_D%>" >
		<july:checkbox property="bandcodes" styleId="bandcodeId" insertable="true" updatable="true" value="900" />&nbsp;900&nbsp;&nbsp;&nbsp;
		<july:checkbox property="bandcodes" styleId="bandcodeId" insertable="true" updatable="true" value="1800" />&nbsp;1800&nbsp;&nbsp;&nbsp;
	</logic:notEqual>

<SCRIPT language=javascript>
function hasElement(arr,element){
	for(var i=0; i < arr.length; i++ ) {
        	//alert("arr[" + i + " ]="+arr[i]+" element="+element);
		if(element==arr[i]) {
			//alert("true");
			return true;
		}
	}
	//alert("false");
	return false;
}

function refreshBands(){
	//alert('refreshBands started');
	var bString=document.all.item("resBandId").value;
	var kk=bString.indexOf(' ');
	//alert("kk="+kk);
	if(kk>=0) {
		bString=bString.substr(0,kk);
	}
	bString=bString+"/";
	//alert("bString="+bString);

	var arr=new Array();
	var k;

	while(bString.indexOf("/") > 0) {
		k=bString.indexOf("/");
		arr=arr.concat(bString.substr(0,k));
		bString=bString.substr(k+1);
	}

	bands=document.all.item("bandcodeId");

	for(var i=0;i < bands.length;i++) {
		if(hasElement(arr,bands[i].value)==false) {
			//alert("нет в массиве bands["+i+"].value="+bands[i].value);
			bands[i].checked=false;
			bands[i].disabled=true;
		} else {
			bands[i].disabled=false;
		}
	}
}
refreshBands();
</SCRIPT>



</td>
</tr>

<tr>
<%--Механический наклон--%>
<%--Диапазон регулировки наклона--%>
<td class="text"><july:reqmark><bean:message key="AntennaForm.nakl"/>:</july:reqmark></td>
 <td>
    <july:string property="naklFrm" size="10" insertable="true" updatable="true" onchange="recalcSummnakl();"/>
    &nbsp;&nbsp;&nbsp;
    <bean:message key="AntennaForm.naklvariation"/>:
    <july:string property="naklvariation" size="20" insertable="true" updatable="true" />
 </td>
</tr>

<tr>
<%--Суммарный наклон--%>
<td class="text"><bean:message key="AntennaForm.sumnakl"/>:</td>
 <td>
    <july:string property="sumnakl" size="10" insertable="false" updatable="false" />
 </td>
</tr>

<tr>
<%--Высота подвеса--%>
<%--Мощность на входе антены--%>
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
	<td class="text" colspan="2"><table style="font-family: Verdana,Arial;font-size:10pt;padding:0px;margin:0px;" cellspacing=0 cellpadding=0 border=0>
	<tr>
		<td rowspan=2 class="text"></td>
		<td rowspan=2 class="text" align="center">Тип кабеля</td>
		<td rowspan=2 class="text" align="center">Длина</td>
		<td rowspan=2 class="text" align="center">К-во заземлений</td>
		<td colspan=2 class="text" align="center">КСВН</td>
	</tr>
	<tr>
		<td class="text" align="center">900</td>
		<td class="text" align="center">1800</td>
	</tr>

	<tr>
		<td class="text">Кабель 1</td>
		<td class="text">
			<july:select collection="cableTypes" property="cab1.cabletype.string" insertable="true" updatable="true" style="width:200px;">
				<html:option value="0">&nbsp;</html:option>
				<html:options collection="cableTypes" property="resource" labelProperty="fullName"/>
			</july:select>
		</td>
		<td class="text"><july:string property="cab1.length.string" size="5" insertable="true" updatable="true" /></td>
		<td class="text"><july:string property="cab1.gnds.string" size="5" insertable="true" updatable="true" /></td>
		<td class="text"><july:string property="cab1.ksvn1.string" size="5" insertable="true" updatable="true" /></td>
		<td class="text"><july:string property="cab1.ksvn2.string" size="5" insertable="true" updatable="true" /></td>
	</tr>

	<tr>
		<td class="text">Кабель 2</td>
		<td class="text">
			<july:select collection="cableTypes" property="cab2.cabletype.string" insertable="true" updatable="true" style="width:200px;">
				<html:option value="0">&nbsp;</html:option>
				<html:options collection="cableTypes" property="resource" labelProperty="fullName"/>
			</july:select>
		</td>
		<td class="text"><july:string property="cab2.length.string" size="5" insertable="true" updatable="true" /></td>
		<td class="text"><july:string property="cab2.gnds.string" size="5" insertable="true" updatable="true" /></td>
		<td class="text"><july:string property="cab2.ksvn1.string" size="5" insertable="true" updatable="true" /></td>
		<td class="text"><july:string property="cab2.ksvn2.string" size="5" insertable="true" updatable="true" /></td>
	</tr>

	<tr>
		<td class="text">Кабель 3</td>
		<td class="text">
			<july:select collection="cableTypes" property="cab3.cabletype.string" insertable="true" updatable="true" style="width:200px;">
				<html:option value="0">&nbsp;</html:option>
				<html:options collection="cableTypes" property="resource" labelProperty="fullName"/>
			</july:select>
		</td>
		<td class="text"><july:string property="cab3.length.string" size="5" insertable="true" updatable="true" /></td>
		<td class="text"><july:string property="cab3.gnds.string" size="5" insertable="true" updatable="true" /></td>
		<td class="text"><july:string property="cab3.ksvn1.string" size="5" insertable="true" updatable="true" /></td>
		<td class="text"><july:string property="cab3.ksvn2.string" size="5" insertable="true" updatable="true" /></td>
	</tr>

	<tr>
		<td class="text">Кабель 4</td>
		<td class="text">
			<july:select collection="cableTypes" property="cab4.cabletype.string" insertable="true" updatable="true" style="width:200px;">
				<html:option value="0">&nbsp;</html:option>
				<html:options collection="cableTypes" property="resource" labelProperty="fullName"/>
			</july:select>
		</td>
		<td class="text"><july:string property="cab4.length.string" size="5" insertable="true" updatable="true" /></td>
		<td class="text"><july:string property="cab4.gnds.string" size="5" insertable="true" updatable="true" /></td>
		<td class="text"><july:string property="cab4.ksvn1.string" size="5" insertable="true" updatable="true" /></td>
		<td class="text"><july:string property="cab4.ksvn2.string" size="5" insertable="true" updatable="true" /></td>
	</tr>
	</table></td>
</tr>

<july:separator/>

<%--тип кабеля--%>
<tr>
    <td class="text"><bean:message key="AntennaForm.cabletype"/>:</td>
    <td>
         <july:select collection="cableTypes" property="cableTypeFrm" insertable="true" updatable="true" style="width:400px;">
                     <html:option value="0">&nbsp;</html:option>
                     <html:options collection="cableTypes" property="resource" labelProperty="fullName"/>
         </july:select>
    </td>
</tr>

<%--Длина кабеля--%>
<tr>
<td class="text"><bean:message key="AntennaForm.lencable"/>:</td>
 <td>
    <july:string property="lencableFrm" size="10" insertable="true" updatable="true" />
 </td>
</tr>


<tr>
<%--Потери в кабеле--%>
<%--КСВН--%>
<td class="text"><bean:message key="AntennaForm.losscable"/>:</td>
 <td>
    <july:string property="losscable" size="10" insertable="false" updatable="false" />
    &nbsp;&nbsp;&nbsp;
    <bean:message key="AntennaForm.kswn"/>:
	<july:string property="ksvnFrm" size="10" insertable="false" updatable="false" />
 </td>
</tr>

<%--тип заземления--%>
<tr>
	<td class="text"><bean:message key="AntennaForm.groundres"/>:</td>
	<td>
    	<july:string size="5" property="groundresourceIdFrm" styleId="resourceId" insertable="true" updatable="true" />
	    <july:lookupbutton href="/inventory/ShowResourceLookupList.do" styleId="resl" fieldNames="resourceId;resourcemodelId;resourcenameId;resourcefullnameId" newWindowName="resourcelookup" insertable="true" updatable="true"/>
        <july:string size="30" property="groundresourceName" styleId="resourcefullnameId" insertable="false" updatable="false" />

 <input type='hidden' name="resourcemodel" id="resourcemodelId"/>
		<input type='hidden' name="resourcename" id="resourcenameId" />

        </td>
</tr>

<tr>
<%--Кол-во заземлений--%>
<td class="text"><bean:message key="AntennaForm.groundctn"/>:</td>
 <td>
    <july:string property="groundctnFrm" size="10" insertable="true" updatable="true" />
 </td>
</tr>

