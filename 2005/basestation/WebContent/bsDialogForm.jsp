<%@ page language = "java" %> 
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld"    prefix="alex" %>
<%@ page import="org.apache.struts.util.*" %>
<%@ page import="com.hps.july.constants.Applications" %>
<%@ page import="com.hps.july.apptags.HasAccessTag" %>
<%@ page import="com.hps.july.jdbcpersistence.lib.*" %>
<%@ page import="com.hps.july.siteinfo.valueobject.*" %>
<%@ page import="com.hps.july.basestation.formbean.*" %>
<%@ page import="com.hps.july.basestation.valueobject.*" %>
<%@ page import="com.hps.july.web.util.*" %>

<%
	boolean isFromSiteinfo = ParamsParser.getRootApp(pageContext) == Applications.SITEINFO;
	String act = "/ProcessBaseStationDialog.do";
	String gColSpan = "2";
	BaseStationDialogForm bsForm = (BaseStationDialogForm)pageContext.findAttribute("BaseStationDialogForm");
	//if("Delete".equals(bsForm.getAction())) {	act = "/Process_DeleteFactBaseStation.do";	}
	String src = "/images/save.gif";
	String alt = "��������� ��";
%>
<logic:equal name="BaseStationDialogForm" property="action" value="Delete">
		<% src = "/images/delconf.gif"; alt = "������� ��"; %>
</logic:equal>

<july:errors property="org.apache.struts.action.GLOBAL_ERROR"/>

<july:editform action="<%=act%>">
<html:hidden property="basestation"/>
<html:hidden property="positionID"/>
<html:hidden property="operation" value=""/>

<script language="javascript">
function refreshLookup(disabledstate,codeId,nameId,btnId) {
	document.all[codeId].disabled = disabledstate;
}
//�������� ���� �������:
function Close()
	{
		if(window.opener) {
			//alert(window.opener.window.location.href);//temp
			//opener.location.reload(true);
			opener.storeSelectedRow('bsID', document.all.basestation.value);
			opener.location.href = opener.location.href;
			window.opener.focus();
		}
		window.close();
	}
function setNumberFrmId(){
	var C = BaseStationDialogForm.index.value;
	var RR = BaseStationDialogForm.indexRR.value;
	var XX = BaseStationDialogForm.indexXX.value;
	var CI = BaseStationDialogForm.indexCI.value;
	if( RR.length == 0 || RR.length > 2){
		//alert("������� ������ �� �����������!");
		hrefStr ='Kzl_IndexDialog.do?positionID=<bean:write name="BaseStationDialogForm" property="position.storageplace" filter="true"/>&formname=BaseStationDialogForm&fieldnames=indexRR';
		window.open(hrefStr, "KzlindexDialog", "top=200, left=200, width=420, height=300, scrollbars=yes, resizable=yes").focus(); 
		return;
	}else if (RR.length == 1){
		RR = '0' + RR;
	}
	if(CI.length == 1){
		CI = '0' + CI;	
	}
	if(!isDigits(XX) || XX.length > 2){
		BaseStationDialogForm.indexXX.value = "";
		BaseStationDialogForm.indexXX.focus();
		return;
	}else if (XX.length == 0){
		alert("������� �����!");
		BaseStationDialogForm.indexXX.focus();
		return;
	}else if (XX.length == 1){
		XX = '0' + XX;
	}
	BaseStationDialogForm.numberFrmId.value = C+RR+XX;
	BaseStationDialogForm.prefixcellidFrm.value = CI+XX;
	indexRowID.style.setAttribute("display", "none");
}
function numberFrmIdHelp(){
	if(indexRowID.style.getAttribute("display") == "none")
		indexRowID.style.setAttribute("display", "block");
	else
		indexRowID.style.setAttribute("display", "none");
}
function isDigits(s)
{
	for(var i = 0; i < s.length; i++)
		if(s.charAt(i) < '0' || s.charAt(i) > '9')
			return false;
	  
	return true;
}
function changeRegionID(){
	document.all.operation.value = "changeRegionID";
	BaseStationDialogForm.submit();
	return false;
}
function changeRegionPrefix(obj){
	//alert(obj.value);
	BaseStationDialogForm.indexCI.value = obj.value;
	//alert(obj[obj.selectedIndex].text);
	BaseStationDialogForm.indexRR.value = obj[obj.selectedIndex].text;
	return false;
}
</script>

<logic:equal name="BaseStationDialogForm" property="flagOperation" value="true">
	<script language="javascript" type="text/javascript">
		 Close();
	</script>
</logic:equal>

<table class="main" style="font-size:8pt;">
<july:separator/>
    <tr class="title">
    	<td class="title" colspan="6">
			<INPUT TYPE="IMAGE" NAME="submit" SRC="<%= src%>"  ALT="<%= alt%>" onclick="document.body.style.cursor='wait';">&nbsp;
			<july:closebutton page="/"/>
        </td>
    </tr>
<july:separator/>
<tr>
	<td class="title" colspan="2"><july:actionalert/></td>
</tr>
<%
	if("Delete".equals(bsForm.getAction())) {
		boolean hasAntennes = bsForm.hasAntennes();
		boolean hasSectors = bsForm.hasSectors();
		boolean hasDocuments = bsForm.hasDocuments();
		boolean hasLinks = hasAntennes||hasSectors||hasDocuments;
%>
<tr>
	<td class="title" colspan="2">
		<%if(hasAntennes) {%><FONT class="attention"><B><bean:message key="BaseStationForm.warning.hasAntennes" /></B></FONT><br><%}%>
		<%if(hasSectors) {%><FONT class="attention"><B><bean:message key="BaseStationForm.warning.hasSectors" /></B></FONT><br><%}%>
		<%if(hasDocuments) {%><FONT class="attention"><B><bean:message key="BaseStationForm.warning.hasDocuments" /></B></FONT><br><%}%>
		<%if(hasLinks) {%><FONT class="attention"><B><bean:message key="confirm.delete" /></B></FONT><%}%>
	</td>
</tr>
<%
	}
%>
<july:separator/>
<%
	if("View".equals(bsForm.getAction())) {
		String journalUrl=AppConstants.BASE_POSITION+"/ShowJournalList.do?objecttype="+ObjectType.BaseStation+"&objectid="+bsForm.getBasestation();
		String onclickStr = "openWindow('"+journalUrl+"');return false;";
		String siteDocUrl=AppConstants.BASE_SITEDOC+"/ShowSiteDocList.do?appHome="+ParamsParser.getRootApp(pageContext)+"&objectId="+bsForm.getBasestation()+"&objectType=BaseStation&canModify="
			+HasAccessTag.hasAccess(pageContext,"/Edit_EditFactBaseStation.do")+"&searchBy=O";
%>
<tr>
	<td class="text"><bean:message key="label.position.actions"/>:</td>
	<td>
		<alex:hasRegionAccess position="<%=String.valueOf(bsForm.getPosition().getStorageplace())%>" >
		<alex:hasAccess href="/Edit_EditFactBaseStation.do" >
			<july:editlink page="/Edit_EditFactBaseStation.do" action="Edit" paramId="basestation" paramName="FactBaseStationForm" paramProperty="basestation"><nobr><bean:message key="label.position.edit"/></nobr></july:editlink>&nbsp;&nbsp;
		</alex:hasAccess>
		<% if(!isFromSiteinfo) { %>
		<alex:hasAccess href="/Edit_CopyFactBaseStation.do" >
			<july:editlink page="/Edit_CopyFactBaseStation.do" action="Edit" paramId="basestation" paramName="FactBaseStationForm" paramProperty="basestation"><nobr><bean:message key="label.basestation.copy"/></nobr></july:editlink>&nbsp;&nbsp;
		</alex:hasAccess>
		<% } %>
		<%--������ ���������--%>
		<alex:hasAccess href="/ShowJournalList.do" file="/WEB-INF/web_siteinfo.xml">
			<html:link onclick="<%=onclickStr%>" href="<%=journalUrl%>"><nobr><bean:message key="label.menu.journal"/></nobr></html:link>&nbsp;&nbsp;
		</alex:hasAccess>
		</alex:hasRegionAccess>

		<alex:hasAccess href="/ShowAntennaSectorList.do" >
			<july:link page="/ShowAntennaSectorList.do"><nobr><bean:message key="label.sectorsafs"/></nobr></july:link>&nbsp;&nbsp;
		</alex:hasAccess>
		<alex:hasAccess href="/ShowEquipdetList.do" >
			<july:link href="/siteinfo/ShowEquipdetList.do" paramId="storageplace" paramName="FactBaseStationForm" paramProperty="basestation"><nobr><bean:message key="link.equipment"/></nobr></july:link>&nbsp;&nbsp;
		</alex:hasAccess>
		<%if(!isFromSiteinfo){%>
			<%if(!bsForm.getStationType().equals(Checks.BS_TYPE_DAMPS_D)) {%>
				<alex:hasAccess href="/ShowChanalPower.do"><a href="ShowChanalPower.do?basestation=<%=bsForm.getBasestation()%>&returnPage=Edit_ViewFactBaseStation.do"><nobr><bean:message key="chanalpower.edit.title"/></nobr></a>&nbsp;&nbsp;</alex:hasAccess>
			<%}%>
		<%}%>
		<%--���������--%>
		<july:link  href="<%=siteDocUrl%>"><nobr><bean:message key="link.documents"/></nobr></july:link>&nbsp;&nbsp;
	</td>
</tr>
<july:separator/>
<%
	}
%>

<%
	String url="/ShowPositionLookupList.do";
	String poseditable = bsForm.editable("positionFields",pageContext);
	String stationTypeEditable = bsForm.editable("stationType",pageContext);
	boolean showDampsType = true;
	boolean showGsmType = true;
	if("Edit".equals(bsForm.getAction())) {
		if(bsForm.getStationType() == null) {
			stationTypeEditable = "false";
		} else if(BaseStationObject.TYPE_CHECK_DAMPS_D.equals(bsForm.getStationType())) {
			showGsmType = false;
//			stationTypeEditable = "false";
		} else {
			showDampsType = false;
			stationTypeEditable = "true";
		}
	}
%>

<tr id="lookupPosition" style='visibility:visible;display:block'>
	<td class="text"><july:reqmark><bean:message key="label.equipment.posname"/></july:reqmark></td>
	<td>
		<html:hidden property="positionForm.storageplaceFrm" styleId="poscodeId"/>
		<july:string size="25" property="positionForm.fullName" styleId="posnameId" insertable="false" updatable="false" />
<%-- --%>
		<july:lookupbutton action="<%=url%>" styleId="posl" fieldNames="poscodeId;posnameId;supregnameId;regionnameId;zonenameId;addressId;latitudeId;longitudeId;dummy1;bsDampsNumId;bsGsmNumId;bsDampsNameId;bsGsmNameId" newWindowName="poslookup" insertable='false' updatable='false'/>

		<input type='hidden' name='bsDampsNum' id='bsDampsNumId'   value=''>
		<input type='hidden' name='bsGsmNum' id='bsGsmNumId'  value=''>
		<input type='hidden' name='bsDampsName' id='bsDampsNameId'  value=''>
		<input type='hidden' name='bsGsmName' id='bsGsmNameId'  value=''>
	</td>
</tr>
<tr id="lookupPosition" style='visibility:visible;display:block'>
	<td class="text"><bean:message key="Position.supreg"/> / <bean:message key="Position.region"/> / <bean:message key="Position.netzonecode"/>:</td>
	<td>
		<july:string property="positionForm.supregname" styleId="supregnameId" size="15" insertable="false" updatable="false" />
		<july:string property="positionForm.regname" styleId="regionnameId" size="15" insertable="false" updatable="false" />
		<july:string property="positionForm.zonename" styleId="zonenameId" size="15" insertable="false" updatable="false" />
	</td>
</tr>
<tr id="lookupPosition" style='visibility:visible;display:block'>
	<td class="text"><bean:message key="Position.address"/>:</td>
	<td>
		<july:string property="positionForm.address" styleId="addressId" size="50" insertable="false" updatable="false" />
	</td>
</tr>
<tr id="lookupPosition" style='visibility:visible;display:block'>
	<td class="text"><bean:message key="Position.latitude"/>:</td>
	<td>
		<july:string property="positionForm.latitudeFrm" styleId="latitudeId" size="10" insertable="false" updatable="false" />
		&nbsp;&nbsp;<bean:message key="Position.longitude"/>:
		<july:string property="positionForm.longitudeFrm" styleId="longitudeId" size="10" insertable="false" updatable="false" />
	</td>
</tr>
<july:separator/>

<tr>
	<td class="text"><july:reqmark><bean:message key="BaseStation.stationType"/>:</july:reqmark></td>
	<td>
		<july:select property="stationType" styleId="stationTypeId" insertable='<%=stationTypeEditable%>' updatable='<%=stationTypeEditable%>' onchange="initBaseStation();switch_(document.all.stationTypeId.value);checkStationType(document.all.stationTypeId.value);">
			<% if(showGsmType && showDampsType) { %>
			<html:option key="label.empty" value=""/>
			<% } %>
			<% if(showGsmType) { %>
			<html:option key="BaseStation.stationType.S" value="<%=BaseStationObject.TYPE_CHECK_GSM_S%>"/>
			<html:option key="BaseStation.stationType.C" value="<%=BaseStationObject.TYPE_CHECK_DCS_C%>"/>
			<html:option key="BaseStation.stationType.G" value="<%=BaseStationObject.TYPE_CHECK_GSM_G%>"/>
			<% } %>
			<% if(showDampsType) { %>
			<html:option key="BaseStation.stationType.D" value="<%=BaseStationObject.TYPE_CHECK_DAMPS_D%>"/>
			<% } %>
		</july:select>
		&nbsp;&nbsp;&nbsp;
		<july:checkbox property="repeater" insertable="true" updatable="true" /> &nbsp; <bean:message key="BaseStation.repeater"/>
	</td>
</tr>
<script language=javascript>
count=0;
function initBaseStation() {
	if(document.all.action.value == 'Add') {
		if(count>0) return;
		if(document.all.stationTypeId.value=="<%=BaseStationObject.TYPE_CHECK_DAMPS_D%>") {
			document.all.numberFrmId.value=document.all.bsDampsNumId.value;
			document.all.stationNameId.value=document.all.bsDampsNameId.value;
		} else if(document.all.stationTypeId.value=="<%=BaseStationObject.TYPE_CHECK_GSM_G%>" || document.all.stationTypeId.value=="<%=BaseStationObject.TYPE_CHECK_GSM_S%>" || document.all.stationTypeId.value=="<%=BaseStationObject.TYPE_CHECK_DCS_C%>") {
			document.all.numberFrmId.value=document.all.bsGsmNumId.value;
			document.all.stationNameId.value=document.all.bsGsmNameId.value;
		}
		count++;
	}
}
function checkStationType(type) {
	if(document.all.action.value == 'Add' || document.all.action.value == 'Edit') {
	if(type=="<%=BaseStationObject.TYPE_CHECK_DAMPS_D%>"){
		switchController(true);
		switchSwitch(false);
	} else if(type=="<%=BaseStationObject.TYPE_CHECK_DCS_C%>"){
		switchController(false);
		switchSwitch(true);
	} else if(type=="<%=BaseStationObject.TYPE_CHECK_GSM_S%>") {
		switchController(false);
		switchSwitch(true);
	} else if(type=="<%=BaseStationObject.TYPE_CHECK_GSM_G%>") {
		switchController(false);
		switchSwitch(true);
	} else {
		switchController(true);
		switchSwitch(true);
	}
	}
}
</script>

<july:separator/>

<tr>
	<td class="text">
		<july:reqmark><bean:message key="BaseStation.number"/>:</july:reqmark>
		<A href='#' onclick='numberFrmIdHelp(); return false;'>
			<IMG SRC="/images/lookup.gif" BORDER='0' ALT='��������/�������� ����������:'></A>
	</td>
	<td>
		<july:string property="numberFrm" styleId="numberFrmId" size="10" insertable="true" updatable="true" />
		&nbsp;&nbsp;PrefCellID:<july:string property="prefixcellidFrm" styleId="prefixcellidFrmId" size="10" insertable="false" updatable="false" />
	</td>
</tr>
<tr id="indexRowID">
	<td class="text">&nbsp;</td>
	<td>
		<!-- ������ �������: -->
		<july:string property="index" style="width: 20;" styleId="index" size="5" insertable="false" updatable="false" />
		<july:select style="width: 150;" property="regionID" collection="kzlRegionList" styleId="regionID" insertable="true" updatable="true"  onchange="changeRegionID();">
			<html:options collection="kzlRegionList" property="regionid" labelProperty="regionname"/>
		</july:select>
		<july:select style="width: 40;" property="cellid_prefix" collection="kzlRegionPrefixList" styleId="cellname_prefix" insertable="true" updatable="true"  onchange="changeRegionPrefix(this);">
			<html:options collection="kzlRegionPrefixList" property="cellid_prefix" labelProperty="cellname_prefix"/>
		</july:select>
		<!-- ������ �������: -->
<%--
		<july:string property="indexRR" styleId="indexRR" size="5" insertable="false" updatable="false" />
		<A href='Kzl_IndexDialog.do?positionID=<bean:write name="BaseStationDialogForm" property="position.storageplace" filter="true"/>&formname=BaseStationDialogForm&fieldnames=indexRR|indexCI' onclick='window.open(this.href, "KzlindexDialog", "top=200, left=200, width=420, height=300, scrollbars=yes, resizable=yes").focus(); return false;'>
			<IMG SRC="/images/lookup.gif" BORDER='0' ALT='������ �������� ��'></A>
--%>
		<!-- � ��: -->
		<july:string property="indexXX" styleId="indexXX" size="5" insertable="true" updatable="true"/>
		<A href='#' onclick='setNumberFrmId(); return false;'>������ �� �����������</A>
		<html:hidden property="indexCI"/>
		<html:hidden property="indexRR"/>
	</td>
</tr>
<july:separator/>
<tr>
	<td class="text"><july:reqmark><bean:message key="BaseStation.stationName"/>:</july:reqmark></td>
	<td>
		<july:string property="stationName" styleId="stationNameId" size="50" insertable="true" updatable="true" />
	</td>
</tr>

<july:separator/>
<%-- Controller fields --%>
<%	String edit = String.valueOf(!(bsForm.getAction().equals("Edit") && bsForm.getStationType().equals(BaseStationObject.TYPE_CHECK_DAMPS_D))); %>
<tr>
	<td class="text"><bean:message key="label.equipment.controller"/>:</td>
	<td>
		<html:hidden property="controllerId"/>
		<july:string property="contrNumberFrm" styleId="contrnum" size="5" insertable="<%=edit%>" updatable="<%=edit%>" />
		<july:lookupbutton action="/ShowControllerLookupList.do" styleId="cntrl" fieldNames="contrnum;contrname;cposname;controllerId;switchId;switchnum;sposname" insertable="<%=edit%>" updatable="<%=edit%>" />
		<july:string size="25" property="contrname" styleId="contrname"  insertable="false" updatable="false" />
		<input type='hidden' name='contrposname' id='cposname'   value=''>
	</td>
</tr>
<script language="javascript">
function switchController(dis) {
	refreshLookup(dis,'contrnum','contrname','cntrl');
	document.all.controllerId.disabled = dis;
}
</script>
<july:separator/>
<%-- Switch fields --%>
<tr>
	<td class="text"><bean:message key="label.equipment.switch"/>:</td>
	<td>
		<html:hidden property="switchId"/>
		<july:string property="switchNumberFrm" styleId="switchnum" size="5" insertable="true" updatable="true" />
		<july:lookupbutton action="/ShowSwitchLookupList.do?constructionState=2&type=1" styleId="switchl" fieldNames="switchnum;sposname;switchId" insertable="true" updatable="true" />
		<july:string size="25" property="switchname" styleId="sposname"  insertable="false" updatable="false" />
	</td>
</tr>
<script language="javascript">
function switchSwitch(dis) {
	refreshLookup(dis,'switchnum','sposname','switchl');
	document.all.switchId.disabled = dis;
}
</script>
<july:separator/>
<tr>
	<td class="text"><bean:message key="BaseStation.contype"/>:</td>
	<td>
		<alex:select property="contype" insertable="true" updatable="true" styleClass="editsmall">
			<html:option key="BaseStation.contype.R" value="<%=BaseStationObject.CONTYPE_CHECK_RADIO%>"/>
			<html:option key="BaseStation.contype.O" value="<%=BaseStationObject.CONTYPE_CHECK_OPTIC%>"/>
		</alex:select>
		&nbsp;&nbsp;&nbsp;
		<bean:message key="BaseStation.e1qty"/>:
		&nbsp;
		<july:string property="e1qtyFrm" size="5" insertable="true" updatable="true" />
	</td>
</tr>
<july:separator/>
<tr>
	<td class="text"><bean:message key="BaseStationForm.nstoek"/>:</td>
	<td>
		<july:string property="nstoekFrm" size="5" insertable="true" updatable="true" />
		&nbsp;&nbsp;&nbsp;
		<bean:message key="BaseStation.pwrval"/>:
		&nbsp;
		<july:string property="pwrvalFrm" size="5" insertable="true" updatable="true" />
	</td>
</tr>
<july:separator/>
<tr>
	<td class="text">�������� ����� ������<%--<bean:message key="BaseStationForm.nstoek"/>:--%></td>
	<td>
		<july:string property="datasource" size="15" insertable="false" updatable="false" />		
	</td>
</tr>
<july:separator/>


<%@ include file="/factBaseStationForm/dateFields.jsp"%>

<july:separator/>

<logic:notEqual name="BaseStationDialogForm" property="action" value="View">
<tr>
	<td class="text"><july:reqmark><bean:message key="BaseStation.equipmentState"/>:</july:reqmark></td>
	<td>
		<alex:select property="equipmentState" styleId="equipmentStateId"   insertable="true" updatable="true" >
			<html:option key="BaseStation.equipmentState.M" value="<%=BaseStationObject.STATE_CHECK_MOUNT_M%>"/>
			<html:option key="BaseStation.equipmentState.P" value="<%=BaseStationObject.STATE_CHECK_PLAN_P%>"/>
			<html:option key="BaseStation.equipmentState.R" value="<%=BaseStationObject.STATE_CHECK_READY_R%>"/>
			<html:option key="BaseStation.equipmentState.T" value="<%=BaseStationObject.STATE_CHECK_TEST_T%>"/>
			<html:option key="BaseStation.equipmentState.W" value="<%=BaseStationObject.STATE_CHECK_WORK_W%>"/>
			<html:option key="BaseStation.equipmentState.D" value="<%=BaseStationObject.STATE_CHECK_DEMOUNT_D%>"/>
		</alex:select>
	</td>
</tr>
<tr>
	<td class="text"><bean:message key="BaseStation.onair"/></td>
	<td>
		<july:radio styleId="onair" property="onair" value="<%=BaseStationObject.ONAIR_CHECK_Y%>" insertable="true" updatable="true" />
		<bean:message key="BaseStation.onair.Y"/>&nbsp;
		<july:radio styleId="onair" property="onair" value="<%=BaseStationObject.ONAIR_CHECK_N%>" insertable="true" updatable="true" />
		<bean:message key="BaseStation.onair.N"/>
	</td>
</tr>
<july:separator/>
</logic:notEqual>
<logic:equal name="BaseStationDialogForm" property="action" value="View">
<tr>
	<td class="text"><july:reqmark><bean:message key="BaseStation.equipmentState"/>:</july:reqmark></td>
	<td>
		<% if(bsForm.getEquipmentState() != null && bsForm.getEquipmentState().length() == 1 && "MPRTWD".indexOf(bsForm.getEquipmentState()) >= 0) { %>
			<bean:message key='<%="BaseStation.equipmentState."+bsForm.getEquipmentState()%>' />
		<% } else { %>
			<bean:message key='BaseStation.equipmentState.unknown' />
		<% } %>
		&nbsp;&nbsp;
		<logic:equal name="BaseStationDialogForm" property="onair" value="<%=BaseStationObject.ONAIR_CHECK_Y%>"><bean:message key="BaseStation.onair.Y"/></logic:equal>
		<logic:notEqual name="BaseStationDialogForm" property="onair" value="<%=BaseStationObject.ONAIR_CHECK_Y%>"><bean:message key="BaseStation.onair.N"/></logic:notEqual>
	</td>
</tr>
<july:separator/>
</logic:equal>
<tr>
	<td class="text"><bean:message key="BaseStation.timebackup"/>:</td>
	<td>
		<july:string property="timebackup" size="5" insertable="true" updatable="true" />
		&nbsp;&nbsp;&nbsp;
		<bean:message key="BaseStation.pwrcat"/>
		&nbsp;
		<july:string property="pwrcat" size="20" insertable="true" updatable="true" />
	</td>
</tr>
<july:separator/>
<tr>
	<td class="text"><bean:message key="label.comment"/>:</td>
	<td>
		<july:textarea property="equipcomment" cols="50" rows="2" insertable='true' updatable='true' />
	</td>
</tr>
<%
	session.setAttribute("returnFormName","BaseStationDialogForm");
%>

<%
	if("View".equals(bsForm.getAction())) {
%>
<tr><td colspan='2'><jsp:include page="/sectorList.jsp" flush="true" /></td></tr>
<july:separator/>
<tr><td colspan='2'><jsp:include page="/antennaList.jsp" flush="true" /></td></tr>
<july:separator/>
<tr><td colspan='2'>

<!-- ������ ��������� -->
<table class="main" id="reptable">
	<tr class="title">
		<td class="title" colspan="9">
			<html:link page="/EditFactRepeater.do?action=Add"><img alt='<bean:message key="label.add"/>' src="/images/plus.gif" border=0/></html:link>&nbsp;&nbsp;��������
		</td>
	</tr>
	<tr class="title">
		<td>&nbsp;</td>
		<july:headercolumn key="repeaterlist.pos.name" colType="string"/>
		<july:headercolumn key="label.repeaterform.number" colType="string"/>
		<july:headercolumn key="repeaterlist.resource" colType="string"/>
		<july:headercolumn key="repeaterlist.repiterclass" colType="string"/>
		<july:headercolumn key="repeaterlist.reppower" colType="string"/>
		<july:headercolumn key="repeaterlist.bandwidth.numchanals" colType="string"/>
		<july:headercolumn key="repeaterlist.donortype" colType="string"/>
		<td>&nbsp;</td>
	</tr>

	<logic:iterate id="rep" name="BaseStationDialogForm" property="repeaters" type="com.hps.july.cdbc.lib.CDBCRowObject">
	<logic:present name="rep">
<%
	String equipment = rep.getColumn("equipment").asString();
	pageContext.setAttribute("repequipment",equipment);
	String rc = rep.getColumn("repiter_class").asString().toLowerCase();
	String dt = rep.getColumn("donor_type").asString().toLowerCase();
	String posid = rep.getColumn("positionid").asString();
	String supreg = rep.getColumn("supregid").asString();
%>
	<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
		<td align="center"><july:editbutton page="/ViewRepeater.do" action='View' paramId="storageplace" paramName="repequipment"/></td>
		<td class="text"><july:stringwrite name="rep" property="posname"/></td>
		<td class="text"><july:stringwrite name="rep" property="number"/></td>
		<td class="text"><july:stringwrite name="rep" property="reptype"/></td>
		<td class="text"><% try { %><bean:message key='<%="repeaterlist.repiterclass."+rc%>'/><% } catch(Exception e) { e.printStackTrace(System.out); } %></td>
		<td class="text"><july:sumwrite name="rep" property="reppower"/></td>
		<td class="text"><july:sumwrite name="rep" property="bandwidth"/></td>
		<td class="text"><% try { %><bean:message key='<%="repeaterlist.donortype."+dt%>'/><% } catch(Exception e) { e.printStackTrace(System.out); } %></td>
		<td class="link"><july:delbutton page='/EditFactRepeater.do?action=Delete' paramId="storageplace" paramName="repequipment"/></td>
	</tr>
	</logic:present>
	</logic:iterate>
</table>




</td></tr>
<%
	}
%>

<july:separator/>
    <tr class="title">
    	<td class="title" colspan="6">
			<INPUT TYPE="IMAGE" NAME="submit" SRC="<%= src%>"  ALT="<%= alt%>" onclick="document.body.style.cursor='wait';">&nbsp;
			<july:closebutton page="/"/>
        </td>
    </tr>
<july:separator/>
</table>
<script language="javascript">
	checkStationType(document.all.stationTypeId.value);
	//indexRowID.style.setAttribute("display", "none");
	changeRegionPrefix(BaseStationDialogForm.cellname_prefix);
</script>
</july:editform>

