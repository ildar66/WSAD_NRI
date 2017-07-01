<%@ page language = "java" %>

<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.dictionary.*" %>

<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<july:editform action="/ProcessDonorUnit.do">

<script language="javascript">
function rwplOnSelect() {
	document.all['resourcesubtypeFrm'].value = '';
	document.all['resourcesubtypename'].value = '';
}
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

<SCRIPT language="javascript">
	function queryResetLinks(){	
		workband_temp=document.all.workbandFrm.value;
		linkband_temp=document.all.linkbandFrm.value;
		answer = window.confirm("Перегрузить список с разрывом связей?");
		if (answer) {
			resetLinks();
		} else {
			document.all.workbandFrm.value=workband_temp;
			document.all.linkbandFrm.value=linkband_temp;
		}
	}

	function resetLinks(){
		document.all.donotcommit.value=true;
		document.forms[0].submit();
	}
</SCRIPT>

<html:hidden property="resource"/>
<html:hidden property="complect"/>

<html:hidden property="donotcommit"/>

<html:hidden property="resourcesubtype"/>

<%String cpupdate = "true";%>
<logic:equal name="DonorUnitForm" property="isresourceused" value="true"><%cpupdate = "false";%></logic:equal>

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
	<tr>
	<tr>
		<td><bean:message key="label.repeater.freqcarry.outpower"/>:</td>
		<td>
			<july:string size="10" property="powerFrm" insertable="true" updatable="true" />
		</td>
	</tr>
	<july:separator/>
	<tr>
		<td><bean:message key="label.repeater.freqcarry.workfreq"/>:</td>
		<td>
			<july:select collection="usedBands" property="workbandFrm" insertable="true" updatable="true"
			tabindex="" onchange="queryResetLinks()">
				<july:options collection="usedBands" property="bandid" labelProperty="bandname"/>
			</july:select>
		</td>
	</tr>
	<july:separator/>
	<tr>
		<td><bean:message key="label.repeater.freqcarry.linkfreq"/>:</td>
		<td>
			<july:select collection="usedBands" property="linkbandFrm" insertable="true" updatable="true"
			tabindex="" onchange="queryResetLinks()">
				<july:options collection="usedBands" property="bandid" labelProperty="bandname"/>
			</july:select>
		</td>
	</tr>
	<july:separator/>
	<tr>
		<td><bean:message key="label.repeater.freqcarry.amplcoef"/>:</td>
		<td>
			<july:string size="10" property="gainfactorFrm" insertable="true" updatable="true" />
		</td>
	</tr>
	<july:separator/>
	<tr>
		<td><bean:message key="label.repeater.freqcarry.voltage"/>:</td>
		<td>
			<july:select collection="voltageList" property="voltageid" insertable="true" updatable="true"
			tabindex="">
				<july:options collection="voltageList" property="voltageid" labelProperty="voltagename"/>
			</july:select>
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
		<td><bean:message key="label.repeater.freqcarry.bsdonorincount"/>:</td>
		<td>
			<july:string size="10" property="entriescountFrm" insertable="true" updatable="true" />
		</td>
	</tr>
	<july:separator/>
	<%--
	<tr>
		<td><bean:message key="label.repeater.freqcarry.antennaoutcount"/>:</td>
		<td>
			<july:string size="10" property="antgatescountFrm" insertable="true" updatable="true" />
		</td>
	</tr>
	<july:separator/>
	--%>
	<tr>
		<td><bean:message key="label.repeater.freqcarry.siggroupdelay"/>:</td>
		<td>
			<july:string size="10" property="signaldelayFrm" insertable="true" updatable="true" />
		</td>
	</tr>
	<july:separator/>
	<tr>
		<td><bean:message key="label.repeater.freqcarry.noisecoef"/>:</td>
		<td>
			<july:string size="10" property="noisefactorFrm" insertable="true" updatable="true" />
		</td>
	</tr>	
	<july:separator/>
	
<july:formbuttons/>

<july:separator/>
    
</table>

<script language="javascript">
//getSubtypeSelected();
</script>

</july:editform>