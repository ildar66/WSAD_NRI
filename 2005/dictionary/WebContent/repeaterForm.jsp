<%@ page language = "java" %>

<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.dictionary.*" %>

<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<link rel="stylesheet" type="text/css" href="/main.css">

<%   
	String action = null;
	String form = null;
	String navt = "L";
	switch (ParamsParser.getState(pageContext)) {
		case APPStates.REPEATER_RES_EDIT:
	        	action = "/ProcessRepeaterResource.do";
			form = "RepeaterResourceForm";
			navt = "R";
        	break;
		case APPStates.REPEATER_EDIT:
	        	action = "/ProcessRepeater.do";
			form = "RepeaterForm";
			navt = "L";
        	break;
	}
%>

<july:editform action="<%=action%>">

<script language="javascript">
function rwplOnSelect() {
	document.all['resourcesubtypeFrm'].value = '';
	document.all['resourcesubtypename'].value = '';
}
/*
function checkFilter() {
	if(document.all.islinear[0].checked) {
		document.all.bandwidthFrm.disabled = false;
		document.all.bandwidthFrm.className = 'edit';
		document.all.numchanalsFrm.disabled = true;
		document.all.numchanalsFrm.className = 'editdisabled';
	} else {
		document.all.bandwidthFrm.disabled = true;
		document.all.bandwidthFrm.className = 'editdisabled';
		document.all.numchanalsFrm.disabled = false;
		document.all.numchanalsFrm.className = 'edit';
	}
}
*/
</script>

<jsp:include page="formUtils.jsp" flush="true"/>

<SCRIPT language="javascript">
  // Результат обновления БД
  function onDownloadDone(s) {
    //alert(s);
  }
  
  function saveResource(argChecked, argCateg, argResource) {
    oDownload.startDownload('/dict/updateResourceCateg?create=' + argChecked +
      '&categ=' + argCateg + '&resource=' + argResource, onDownloadDone);
  }
  
</SCRIPT>

<input type="hidden" name="savedLinkband" id="savedLinkband" value="" />
<input type="hidden" name="savedWorkband" id="savedWorkband" value="" />
<input type="hidden" name="savedReptype" id="savedReptype" value="" />
<input type="hidden" name="onlyonce"/>

<SCRIPT language="javascript">
	function submitForm(){
  		var delta = 0;
  		var ok;
  		if (document.all.workbandFrm.value=="1"){
  			delta = parseInt(document.all.bandwidth900delta.value);
  		}
  		else if (document.all.workbandFrm.value=="2"){
  			delta = parseInt(document.all.bandwidth1800delta.value);
  		}
  		baddownlinkbandFrm = (parseInt(document.all.downlinkbandFrm.value)<=delta);
  		baddownlinkbandupFrm = (parseInt(document.all.downlinkbandupFrm.value)<=delta);
  		if (document.all.onlyonce.value!="true"){
	  		if (baddownlinkbandFrm || baddownlinkbandupFrm){
	  			ok = "false";
	  			alert("Некорректные значения границ полосы частот downlink!");
  				if (baddownlinkbandFrm){
	  				document.all.downlinkbandFrm.focus();
  					document.all.downlinkbandFrm.select();
  					document.all.onlyonce.value="true";
	  			}
  				else if (baddownlinkbandupFrm){
			  		document.all.downlinkbandupFrm.focus();
		  			document.all.downlinkbandupFrm.select();
		  			document.all.onlyonce.value="true";
	  			}
  			}
  			else{
  				ok = "true";
  			}
  		}
  		else{
  			document.all.onlyonce.value="false";
  		}
		if (ok=="true"){
			document.all.donotcommit.value=true;
			document.forms[0].submit();
		}
		
	}
	function workband_onchange(){
		band_onchange();
	}
	function linkband_onchange(){
		band_onchange();
	}
	function band_onchange(){
		if (document.all.repitertypeFrm.value=="2"){
			alert("Список донорных блоков будет перестроен с разрывом связей!");//answer = window.confirm
			submitForm();
		}
		else if (document.all.workbandFrm.value=="1" || document.all.workbandFrm.value=="2"){
			submitForm();
		}
	}	
	function checkSubtypeSelected() {
    	if (document.all.repitertypeFrm.value=="2") {
	    	document.all.repfreqcarry2.style.display = 'block';
	    	document.all.repfreqcarry2.style.visibility = 'visible';
		} else {
	    	document.all.repfreqcarry2.style.display = 'none';
	    	document.all.repfreqcarry2.style.visibility = 'hidden';
		}
  	}
</SCRIPT>


<html:hidden property="resource"/>
<html:hidden property="complect"/>

<html:hidden property="donotcommit"/>

<html:hidden property="resourcesubtype"/>

<html:hidden property="bandwidth900delta"/>
<html:hidden property="bandwidth1800delta"/>

<%--
<input type="hidden" name="donotcommit" id="donotcommit" value="" />
--%>

<%--
<html:hidden property="workbandFrm"/>
<html:hidden property="linkbandFrm"/>
--%>

<%String cpupdate = "true";%>
<logic:equal name="<%=form%>" property="isresourceused" value="true"><%cpupdate = "false";%></logic:equal>

<table class="main">

<july:separator/>

<july:formbuttons/>

<july:separator/>
	
<tr>
	<td class="title" colspan="2"><july:actionalert/></td>
</tr>

<july:separator/>

<tr>
	<td class="text"><bean:message key="label.resource.nricodeLabel"/>:</td>
	<td>
		<july:string size="5" property="resource" insertable="false" updatable="false" />
	</td>
</tr>

<july:separator/>

<tr>
	<td class="text"><july:reqmark><bean:message key="label.name"/></july:reqmark>:</td>
	<td>
		<july:string size="35" property="name" insertable="true" updatable="true" />
	</td>
</tr>
    
<july:separator/>
    
<tr>
	<td class="text"><july:reqmark><bean:message key="label.repeater.model"/></july:reqmark>:</td>
	<td>
		<july:string size="35" property="model" insertable="true" updatable="true" />
	</td>
</tr>
    
<july:separator/>
    
<tr>
	<td class="text"><bean:message key="label.repeater.manufacturer"/>:</td>
	<td>
		<july:string property="manufidFrm" styleId="manufidFrm" size="5" insertable="true" updatable="true" />
		<%--<july:lookupbutton action="/ShowOrganizationLookupList.do" styleId="orgl" fieldNames="manufacturerFrm;manufacturername" insertable="true" updatable="true" />--%>
		<july:lookupbutton action="/ShowEquipmanufLookupList.do" styleId="orgl" fieldNames="manufidFrm;manufacturername" insertable="true" updatable="true" />
		<july:string size="35" property="manufacturername" styleId="manufacturername" insertable="false" updatable="false" />
        </td>
</tr>
    
<july:separator/>
    
<tr>
	<td class="text"><bean:message key="label.resource.manucode"/>:</td>
	<td>
		<july:string property="manucode" size="35" insertable="true" updatable="true" />
	</td>
</tr>

<july:separator/>
    
<tr>
	<td class="text"><july:reqmark><bean:message key="label.resource.unit"/></july:reqmark>:</td>
	<td>
		<july:select collection="units" property="unitFrm" insertable="true" updatable="true">
			<html:options collection="units" property="unit" labelProperty="name"/>
		</july:select>
	</td>
</tr>
    
<july:separator/>
    
<tr>
	<td class="text"><bean:message key="label.resource.notes"/>:</td>
	<td>
		<july:string property="notes" size="35" insertable="true" updatable="true" />
	</td>
</tr>
    
<july:separator/>
    
<tr>
	<td></td>
	<td colspan="2" class="text">
		<bean:message key="label.resource.active"/>:&nbsp;<july:checkbox styleClass="text" property="active" insertable="true" updatable="true" />&nbsp;&nbsp;&nbsp;
		<bean:message key="label.resource.nfsdeny"/>&nbsp;&nbsp;&nbsp;<july:checkbox styleClass="text" property="disablenfscodes" insertable="true" updatable="true" />&nbsp;
	</td>
</tr>
    
<july:separator/>

<tr>
	<td class="text"><july:reqmark><bean:message key="label.resource.countpolicy"/>:</july:reqmark></td>
	<td>
		<july:radio styleClass="text" insertable="true" updatable="<%=cpupdate%>" property="countpolicy" value="S"/><bean:message key="label.resource.countpolicys"/>&nbsp;&nbsp;&nbsp;
		<july:radio styleClass="text" insertable="true" updatable="<%=cpupdate%>" property="countpolicy" value="P"/><bean:message key="label.resource.countpolicyp"/>&nbsp;&nbsp;&nbsp;
		<july:radio styleClass="text" insertable="true" updatable="<%=cpupdate%>" property="countpolicy" value="B"/><bean:message key="label.resource.countpolicyb"/>
	</td>
</tr>

<july:separator/>

<tr class="title">
	<td class="title" colspan="2"><bean:message key="label.cable.techparams"/></td>
</tr>

<july:separator/>          

<%--collection="reptypes"--%>
	<tr>
	<td class="text"><july:reqmark><bean:message key="label.repeater.reptype"/></july:reqmark>:</td>
	<td>
		<july:select collection="reptypes" property="repitertypeFrm" insertable="true" updatable="true"
		onchange='reptypeSelected(this.value)' tabindex="">
			<html:options name="reptypes"/>
		</july:select>
	</td>
	</tr>
	<july:separator/>
	<tr>
		<td><bean:message key="label.repeater.straight.bandwidth"/>:</td>
		<td>
			<july:select collection="usedBands" property="workbandFrm" insertable="true" updatable="true"
			onchange="workband_onchange()" tabindex="">
				<july:options collection="usedBands" property="bandid" labelProperty="bandname"/>
			</july:select>
		</td>
	</tr>
	<july:separator/>
	<tr>
		<td><bean:message key="label.repeater.subtype"/>:</td>
		<td>
			<july:select collection="subtypes" property="islinear" insertable="true" updatable="true"
			onchange='subtypeSelected(this.value)' tabindex="">
				<html:options name="subtypes"/>
			</july:select>
		</td>
	</tr>
	<july:separator/>
	<tr>
		<td><bean:message key="label.repeater.straight.outpower"/>:</td>
		<td>
			<july:string size="10" property="reppowerFrm" insertable="true" updatable="true" />
		</td>
	</tr>
	<july:separator/>
	<tr>
		<td><bean:message key="label.repeater.straight.inpower"/>:</td>
		<td>
			<july:string size="10" property="usedpowerFrm" insertable="true" updatable="true" />
		</td>
	</tr>
	<july:separator/>
	<tr>
		<td><bean:message key="label.repeater.straight.voltage"/>:</td>
		<td>
			<july:select collection="voltageList" property="voltageid" insertable="true" updatable="true"
			tabindex="">
				<july:options collection="voltageList" property="voltageid" labelProperty="voltagename"/>
			</july:select>
		</td>
	</tr>
	<july:separator/>
	<tr id="bwfrm">
		<td nowrap><bean:message key="label.repeater.workfreq"/> (от) :</td>
		<td nowrap>
			<july:string size="10" property="bandwidthFrm" insertable="true" updatable="true" />
		</td>
	</tr>
		<td nowrap><bean:message key="label.repeater.workfreq"/> (до) :</td>
		<td nowrap>
			<july:string size="10" property="endbandwidthFrm" insertable="true" updatable="true" />
		</td>
	</tr>
	<july:separator/>
	<tr id="ncfrm">
		<td><bean:message key="label.repeater.numchanals"/>:</td>
		<td>
			<july:string size="10" property="numchanalsFrm" insertable="true" updatable="true" />
		</td>
	</tr>
	<july:separator/>
	<tr>
		<td><bean:message key="label.repeater.downlink.low"/>:</td>
		<td>
			<july:string size="10" property="downlinkbandFrm" insertable="true" updatable="true" 
			onblur='submitForm()'/>
		</td>
	</tr>
	<july:separator/>
	<tr>
		<td><bean:message key="label.repeater.downlink.high"/>:</td>
		<td>
			<july:string size="10" property="downlinkbandupFrm" insertable="true" updatable="true" 
			onblur='submitForm()'/>
		</td>
	</tr>
	<july:separator/>
	<tr>
		<td><bean:message key="label.repeater.uplink.low"/>:</td>
		<td>
			<july:string size="10" property="uplinkbandFrm" insertable="false" updatable="false" />
		</td>
	</tr>
	<july:separator/>
	<tr>
		<td><bean:message key="label.repeater.uplink.high"/>:</td>
		<td>
			<july:string size="10" property="uplinkbandupFrm" insertable="false" updatable="false" />
		</td>
	</tr>
	<july:separator/>
	<tr>
		<td><bean:message key="label.repeater.straight.measures"/>:</td>
		<td>
			<july:string size="10" property="dimensions" insertable="true" updatable="true" />
		</td>
	</tr>
	<july:separator/>
	<tr>
		<td><bean:message key="label.repeater.straight.weight"/>:</td>
		<td>
			<july:string size="10" property="weightFrm" insertable="true" updatable="true" />
		</td>
	</tr>	
	<july:separator/>
	<tr>
		<td><bean:message key="label.repeater.straight.amplcoef"/>:</td>
		<td>
			<july:string size="10" property="gainfactorFrm" insertable="true" updatable="true" />
		</td>
	</tr>	
	<july:separator/>
	<tr>
		<td><bean:message key="label.repeater.straight.siggroupdelay"/>:</td>
		<td>
			<july:string size="10" property="signaldelayFrm" insertable="true" updatable="true" />
		</td>
	</tr>	
	<july:separator/>
	<tr>
		<td><bean:message key="label.repeater.straight.noisecoef"/>:</td>
		<td>
			<july:string size="10" property="noisefactorFrm" insertable="true" updatable="true" />
		</td>
	</tr>
	<july:separator/>
	<tr>
		<td><bean:message key="label.repeater.freqcarry.antennaoutcount"/>:</td>
		<td>
			<july:string size="10" property="antentriescountFrm" insertable="true" updatable="true" />
		</td>
	</tr>
	<july:separator/>
	<tr>
		<td><bean:message key="label.repeater.remote"/>:&nbsp;</td>
		<td>
			<july:checkbox styleClass="text" property="remotecontrol" insertable="true" updatable="true" />&nbsp;&nbsp;&nbsp;
		</td>
	</tr>
	<july:separator/>
	<tr ID="repfreqcarry1">
		<td><bean:message key="label.repeater.freqcarry.linkfreq"/>:</td>
		<td>
			<july:select collection="usedBands" property="linkbandFrm" insertable="true" updatable="true"
			onchange="linkband_onchange()" tabindex="">
				<july:options collection="usedBands" property="bandid" labelProperty="bandname"/>
			</july:select>
		</td>
	</tr>
	<july:separator/>
</table>

<table class="main" ID="repstraight">
	<%@ include file="repStraight.jsp"%>
	<%--<jsp:include page="repStraight.jsp" flush="true"/>--%>
</table>

<table class="main" ID="repdigital">
	<%@ include file="repDigital.jsp"%>
	<%--<jsp:include page="repDigital.jsp" flush="true"/>--%>
</table>

<table class="main" border="0" ID="repfreqcarry2">
	<tr class="title">
		<td class="title" colspan="9">Донорные блоки</td>
	</tr>
	<july:separator colspan="9"/>
		<jsp:useBean id="repform" class="com.hps.july.dictionary.formbean.RepeaterForm"/>
			<tr>
				<td></td>
				<td> <bean:message key="label.code"/> </td> 
				<td> <bean:message key="label.resource.model"/> </td>
				<td> <bean:message key="label.repeater.power"/> </td> 
				<td> <bean:message key="label.repeater.straight.amplcoef"/> </td>
				<td> <bean:message key="label.repeater.straight.voltage"/> </td>
				<td> <bean:message key="label.repeater.freqcarry.donorincount"/> </td>
				<td> <bean:message key="label.repeater.straight.siggroupdelay"/> </td>
				<td> <bean:message key="label.repeater.straight.noisecoef"/> </td>
			</tr>
			<july:separator colspan="9"/>
		<%
			for (int i=0;i<repform.getDonorUnitCount();i++){
				String resource = repform.getDonorUnitInfo(i).getResource();
				String model = repform.getDonorUnitInfo(i).getModel();
				String power = repform.getDonorUnitInfo(i).getPower();
				String workband = repform.getDonorUnitInfo(i).getWorkband();
				String linkband = repform.getDonorUnitInfo(i).getLinkband();
				String gainfactor = repform.getDonorUnitInfo(i).getGainfactor();
				String voltageid = repform.getDonorUnitInfo(i).getVoltageid();
				String usedpower = repform.getDonorUnitInfo(i).getUsedpower();
				String entriescount = repform.getDonorUnitInfo(i).getEntriescount();
				String antgatescount = repform.getDonorUnitInfo(i).getAntgatescount();
				String signaldelay = repform.getDonorUnitInfo(i).getSignaldelay();
				String noisefactor = repform.getDonorUnitInfo(i).getNoisefactor();
		%>	
				<tr onMouseOver="className='normal'" onMouseOut="className='select'">
					<td>
						<july:checkbox styleClass="main" property='<%= "donorUnit["+i+"]"%>' insertable="true" updatable="true"/>
					</td>
					<td> <%= resource %> </td>
					<td> <%= model %> </td>
					<td> <%= power %> </td>
					<td> <%= gainfactor %> </td>
					<td> <%= voltageid %> </td>
					<td> <%= entriescount %> </td>
					<td> <%= signaldelay %> </td>
					<td> <%= noisefactor %> </td>
				</tr>
				<july:separator colspan="9"/>
	<%
			}
	%>
</table>

<table class="main" ID="repoptical">
	<%@ include file="repOptical.jsp"%>
	<%--<jsp:include page="repOptical.jsp" flush="true"/>--%>
</table> 

<table class="main">

<july:formbuttons/>

<july:separator/>
    
</table>

<script language="javascript">
getReptypeSelected();
getSubtypeSelected();
checkSubtypeSelected();
//checkBadDelta();
</script>

</july:editform>