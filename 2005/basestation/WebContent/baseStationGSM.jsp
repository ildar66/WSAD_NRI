<html>
<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import = "com.hps.july.web.util.*, com.hps.july.basestation.formbean.*"%>
<head>
	<script src="/scripts/string_format.js"></script>
</head>
<body onkeypress="searchByEnter();">
<SCRIPT language=javascript src="/common/dialog.js" type="text/javascript"></SCRIPT>  
<%!
private String isUp(String aSort, String name) {
 if(aSort.startsWith(name)) {
	 if(aSort.endsWith("desc")) 
		return (" <img src='/images/up.gif'  border='0' alt='�� �����������'> ");
	 else
		return (" <img src='/images/down.gif'  border='0' alt='�� ��������'> "); 
 }
 else return ("");      
}
%>
<%--<jsp:include page="common/top.jsp" flush="true"/>--%>
<%
	String gColSpan = "5";
	BaseStationGSMForm aForm = (BaseStationGSMForm)session.getAttribute("BaseStationGSMForm");
	String repiterSortBy = aForm.getRepiterSortBy();
	String bsSortBy = aForm.getBsSortBy();
	String controllerSortBy = aForm.getControllerSortBy();
	String equipDetSortBy = aForm.getEquipDetSortBy();
	String equipDetDisplay = aForm.getEquipDetDisplay();
	String bsDisplay = aForm.getBsDisplay();
	String repiterDisplay  = aForm.getRepiterDisplay();
	String controllerDisplay = aForm.getControllerDisplay();
	String donorRepiterDisplay = aForm.getDonorRepiterDisplay();
	String trailcomMapUrl = com.hps.july.util.AppUtils.getNamedValueString("PathMapTrailcom");
	String ruser = request.getRemoteUser();
	String pathEquipmentEditTrailcom = com.hps.july.util.AppUtils.getNamedValueString("PathEquipmentEditTrailcom");
	// ��� ��� ��������� � �������� �������
	String pathPositionSearchTrailcom = com.hps.july.util.AppUtils.getNamedValueString("PathPositionSearchTrailcom");
	// ��� ��� ���������� �������
	// String pathPositionSearchTrailcom = "http://localhost/TS_objects_web/loginPos.jsp";
	String openFKBSViewAction = "/inventory/ShowConfigFormAction.do?navclear=1&action=View";
	String openFKBSEditAction = "/inventory/ShowConfigFormAction.do?navclear=1&action=Edit";
%>
<%
	//��� ������ help:
	int app = ParamsParser.getApplication(pageContext);
	int state = ParamsParser.getState(pageContext);
	String helpFile = "return openDialog('" + com.hps.july.util.AppUtils.getHelpFileName(app, state) + "', '_blank', 'top=40, left=100, width=830, height=630, scrollbars=yes, resizable=yes');";
%>
<OBJECT ID="dufos" WIDTH=1 HEIGHT=1 CLASSID="CLSID:C216375F-F8D6-4905-84DB-370425BCE6C0"></OBJECT>

<july:editform action="/ShowBaseStationGSM.do" styleId="BaseStationGSMForm">
<!-- hidden fields -->
<html:hidden property="operation"/>
<html:hidden property="findPositionBy"/>
<html:hidden property="searchString"/>
<html:hidden property="selectedIDrepiterID" value="0"/>
<html:hidden property="repiterSortBy"/>
<html:hidden property="selectedIDbsID" value="0"/>
<html:hidden property="bsSortBy"/>
<html:hidden property="controllerSortBy"/>
<html:hidden property="selectedIDcontrollerID" value="0"/>
<html:hidden property="equipDetSortBy"/>
<html:hidden property="selectedIDequipDetID" value="0"/>
<html:hidden property="selectedIDdocID" value="0"/>
<html:hidden property="selectedIDjobID" value="0"/>
<html:hidden property="isDocDisplay"/>
<html:hidden property="isJobDisplay"/>
<html:hidden property="position.storageplace" styleId="position.storageplace" />

<script language="javascript">

var isFirstLoadEnd = 'false';

function searchByEnter(e) {
    if (document.layers) {
        Key = e.which;
    } else {
        Key = window.event.keyCode;
    }
    // if (Key != 0)
        // alert("Key pressed! ASCII-value: " + Key);
    if (Key == 13) {
		runSearchProcess();
    }
        
}


function initPosition(by) {
	document.all.operation.value='initPosition';
	document.all.findPositionBy.value=by;
	document.body.style.cursor="wait";
}
 function alertDictionary(by) {
	if(document.all['lookupimg_posl'].src.substr(document.all['lookupimg_posl'].src.length-12,12) == 'disabled.gif') 
		{ return; }
	String.prototype.lookup = lookup_params_posl;
	opt_params_posl=opt_params_posl+'&searchString='+document.all.searchString.value;
	if(by==2)
		opt_params_posl=opt_params_posl+'&searchBy='+'B';
	else if(by==3)
		opt_params_posl=opt_params_posl+'&searchBy='+'C';
	myWindow = window.open("/basestation/ShowPositionLookupList.do?planstate=2" + opt_params_posl, "myWindow", "top=40, left=100, width=830, height=630, scrollbars=yes, resizable=yes");
	document.all.operation.value='';
	if(dialogArray)
		dialogArray[dialogArray.length]=myWindow;
	myWindow.focus();
}
function onMouseOutRow(tabid,selectedID){
	if(document.all['selectedID'+tabid].value==selectedID) {
		document.all[tabid].rows(selectedID,0).className="selectedrow";
	}
	else {
		document.all[tabid].rows(selectedID,0).className="normalrow";
	}
}
function onMouseOverRow(tabid,selectedID){
	document.all[tabid].rows(selectedID,0).className="selectrow";
}
function onClickRow(tabid,selectedID) {
	if(document.all[tabid].rows(document.all['selectedID'+tabid].value) != null){
		document.all[tabid].rows(document.all['selectedID'+tabid].value,0).className="normalrow";
	}
	document.all['selectedID'+tabid].value=selectedID;
	document.all[tabid].rows(selectedID,0).className="selectedrow";
	storeSelectedRow(tabid,selectedID);
}
function storeSelectedRow(tabid,selectedID) {
	document.cookie = "listPosID"+tabid+"=" + selectedID;
}
function loadSelectedRow(tabid) {
	var cookies = document.cookie;
	//��������� selectedID:
	var startLoc = cookies.indexOf("listPosID"+tabid+"=");
	if(startLoc == -1)
	   return;
	var sepLoc = cookies.indexOf("=", startLoc);
	var endLoc = cookies.indexOf(";", startLoc);
	if(endLoc == -1) {
		endLoc = cookies.length;
    }
	document.all['selectedID'+tabid].value = cookies.substring(sepLoc+1, endLoc);
	//������������ ������ � �������:
	if( document.all[tabid].rows(document.all['selectedID'+tabid].value) != null ) {
 		document.all[tabid].rows(document.all['selectedID'+tabid].value,0).className="selectedrow";
	}
}
function ReturnToBaseStationGSM() {
	BaseStationGSMForm.submit();
}
function SortBy(e, field) 
{
	e.value = (e.value == field)?field + ' desc':field;
    document.body.style.cursor="wait";
	BaseStationGSMForm.submit();
	return false;
}
function toggleDetail(tabid) {
	if(document.all[tabid].style.display == "none"){
		document.all[tabid].style.display = "";
	}else{
		document.all[tabid].style.display = "none";
	}
}
function submitBsGSMForm() {
	if (isFirstLoadEnd == 'true') {
		BaseStationGSMForm.submit();
	}
}
function setDetailDoc(){
	document.all['docID'].style.display = "";
	document.all['equipDetID'].style.display = "none";
	document.all['jobID'].style.display = "none";
	document.all.isDocDisplay.value='true';
	document.all.isJobDisplay.value='false';
	//alert(document.all['detailEquipLabel'].style.color);//temp
	document.all['detailEquipLabel'].style.color='';
	document.all['detailDocLabel'].style.color='red';
	document.all['detailJobLabel'].style.color='';
	submitBsGSMForm();
}
function setDetailEquip(){
	document.all['equipDetID'].style.display = "";
	document.all['docID'].style.display = "none";
	document.all['jobID'].style.display = "none";
	document.all.isDocDisplay.value='false';
	document.all.isJobDisplay.value='false';
	document.all['detailEquipLabel'].style.color='red';
	document.all['detailDocLabel'].style.color='';
	document.all['detailJobLabel'].style.color='';
	submitBsGSMForm();
}
function setDetailJob(){
	document.all['jobID'].style.display = "";
	document.all['docID'].style.display = "none";
	document.all['equipDetID'].style.display = "none";
	document.all.isDocDisplay.value='false';
	document.all.isJobDisplay.value='true';
	//alert(document.all['detailEquipLabel'].style.color);//temp
	document.all['detailEquipLabel'].style.color='';
	document.all['detailDocLabel'].style.color='';
	document.all['detailJobLabel'].style.color='red';
	submitBsGSMForm();
}

function initDetailDoc(){
	isFirstLoadEnd = 'false';
	if(document.all.isDocDisplay.value=='true'){
		 setDetailDoc();
	}else 
		if(document.all.isJobDisplay.value=='true'){
		 setDetailJob();
	  } else {
		setDetailEquip();
	}
	isFirstLoadEnd = 'true';
}
function determineMaps(url,user) {
	var params = '?id='+user+'&type=1&position=<bean:write name="BaseStationGSMForm" property="position.storageplace" filter="true"/>';
	var urlShortInfo = (url + params);
	return openDialog(urlShortInfo, "retVal", "top=10,left=10,width=1000,height=800,resizable=1,scrollbars=1,statusbar=1,status=0,toolbar=0");
}
function showTerrabyteFile(objectId, objectType, typeId) {
	<% String fileURL = com.hps.july.web.util.URLUtil.getTerrabyteActiveFileURL(request); %>
	var url = ("<%=fileURL%>" + "&objectId=" + objectId + "&objectType=" + objectType + "&typeId=" + typeId); 
    var result;
   	try {
		result = document.all.dufos.downloadfile(url,
    		"", "jsessionid", "ltpatoken",
           	"noreturn", "true");
		if(result != 0) {
			alert('�� ����� �������� ��������� ������ !');
		}
	} catch(e) {
		url = url + "&lang=tr";
	    return openDialog(url , "lastVer", "resizable=1,scrollbars=0,statusbar=0,status=0,toolbar=0");
	}
}

function confirmEqDel(eqType, paramName, paramVal, this_href, windowType) {
	if (confirm("�����e����� �������� ��������������� ��������� ["+eqType+"] "+paramName+" ["+paramVal+"]")) {
		// return openDialog(this_href, "window_BC", "top=100, left=100, width=650, height=600, scrollbars=yes, resizable=yes");
		return openDialog(this_href, windowType, "top=100, left=100, width=650, height=600, scrollbars=yes, resizable=yes");
	} else {
		return false;
	}
}

// var hrefPoints="<%= pathPositionSearchTrailcom%>?id=<%= ruser%>&complect=B&criterion=NR&word=2353&extEqDetails=1";
// var hrefPoints="<%= pathPositionSearchTrailcom%>?id=<%= ruser%>&complect=B&criterion=NR&word=123&extEqDetails=1";
// var hrefPoints="<%= pathPositionSearchTrailcom%>?id=<%= ruser%>&complect=P&criterion=NM&word=���������&extEqDetails=1";
// var hrefPoints="<%= pathPositionSearchTrailcom%>?id=<%= ruser%>&complect=P&criterion=NM&word='���������'&extEqDetails=1";
// var hrefPoints="<%= pathPositionSearchTrailcom%>?id=<%= ruser%>&complect=B&criterion=NR&word='2353'&extEqDetails=1";

function OpenWindowPointsJSP()
{
	// alert("open window");
	document.body.style.cursor="normal";
	openDialog("ContentPoints.jsp?typedetails=1", "window_Search", "top=100, left=100, width=950, height=600, scrollbars=yes, resizable=yes");
}

function SelectPoint(id, gsm, damps, value, address, regionid, region, netzoneid, netzone, latitude, longitude, posstate, superregionid, superregionname) {
	// alert("value = "+value);
	// alert("address = "+address);
	// alert("id = "+id);
	var srPozNameIdVar = document.getElementById("srPozNameId");
	srPozNameIdVar.value = value;
	var srPozAddrIdVar = document.getElementById("srPozAddrId");
	srPozAddrIdVar.value = address;
	var srRegionIdVar = document.getElementById("srRegionId");
	srRegionIdVar.value = superregionname;
	var srNetZonaIdVar = document.getElementById("srNetZonaId");
	srNetZonaIdVar.value = netzone;
	var srPozCondIdVar = document.getElementById("srPozCondId");
	srPozCondIdVar.value = posstate;
	var srShirotaIdVar = document.getElementById("srShirotaId");
	srShirotaIdVar.value = latitude;
	var srDolgltaIdVar = document.getElementById("srDolgltaId");
	srDolgltaIdVar.value = longitude;
	var srFilialIdVar = document.getElementById("srFilialId");
	srFilialIdVar.value = region;
	var position_storageplaceVar = document.getElementById("position.storageplace");
	position_storageplaceVar.value = id; 
	if (value != "nothing") {
		initPosition(1);
	} else {
	  	alert("�� ������ ������� ������ �� �������.");
		srPozNameIdVar.value = "";
		srPozAddrIdVar.value = "";
		srRegionIdVar.value = "";
		srNetZonaIdVar.value = "";
		srPozCondIdVar.value = "";
		srShirotaIdVar.value = "";
		srDolgltaIdVar.value = "";
		srFilialIdVar.value = "";
		initPosition(4);
	}
	submitBsGSMForm();
	document.body.style.cursor="normal";
}

function runSearchProcess() {
	// alert("runSearch()");
	document.body.style.cursor="wait";
	
	var selectVar = document.getElementById("searchParameterNameSelectId");
	var oprionsVar = selectVar.options;
	var paramComplect;
	var paramCriterion;
	for (i=0; i< oprionsVar.length; i++) {
		var curOpt = oprionsVar(i);
		var selectedVar = curOpt.selected;
		var textVar = curOpt.text;
		if (selectedVar) {
				var valueVar = curOpt.value;
		        // alert("textVar = "+textVar);
				paramComplect = valueVar.substring(0,1);
				paramCriterion = valueVar.substring(1);
		        // alert("paramComplect = "+paramComplect);
		        // alert("paramCriterion = "+paramCriterion);
			break;
		}
	} 
	var valueVar = document.getElementById("searchParameterValueId");
	var searchValue = valueVar.value; 
    // alert("searchValue = "+searchValue);
	searchValue = Trim(searchValue);
	
    // alert("Trim(searchValue) = ["+searchValue+"]");
    if (validateSearchParam(paramComplect, paramCriterion, searchValue) == false) {
		document.body.style.cursor="normal";
       	return false;
    }

	var hrefPoints="<%= pathPositionSearchTrailcom%>?id=<%= ruser%>&complect="+paramComplect+"&criterion="+paramCriterion+"&word="+searchValue+"&extEqDetails=1";
	// var hrefPoints="<%= pathPositionSearchTrailcom%>?id=<%= ruser%>&complect="+paramComplect+"&criterion="+paramCriterion+"&word="+escapedSearchValue+"&extEqDetails=1";
	// var hrefPoints="<%= pathPositionSearchTrailcom%>?id=<%= ruser%>&complect="+paramComplect+"&criterion="+paramCriterion+"&word="+escapedSearchValue2+"&extEqDetails=1";
    // alert("hrefPoints = "+hrefPoints);
	
	document.frames['callPositionForm'].location=hrefPoints;
}

function validateSearchParam(paramComplect, paramCriterion, searchValue) {
	if (searchValue.length == 0) {
		alert("���� ������ ������ ���� ���������.");
	 	return false;
	}
	if (paramCriterion == "NR") {
		if (numericStr(searchValue) == false) {
			alert("�������� ���������� �������� � ������ �� �����������.");
		 	return false;
		}
	}
	if ((paramCriterion == "NM") || (paramCriterion == "AD")) {
		if (searchValue.length < 3) {
			alert("������ ������ ������ ��������� �� ����� 3-� ��������.");
	 	 	return false;
	 	}
	}
	return true;
}

</script>

<!-- ����� -->
<style>
TR.normalrow {
	background-color:#F0F0F0;
}
TR.selectrow {
	background-color:#FFFFFF;
}
TR.selectedrow {
	background-color:#FFF0D0;
} 
</style>

<table class="main">

<tr class="normal">
<td colspan="<%= gColSpan %>">
	<table width="100%" cellspacing="0" cellpadding="0" border="0" style="font-family:tahoma,arial;font-size:8pt;">
<tr class="normal">
<td colspan="<%= gColSpan %>" style="padding-left:12px;padding-right:12px;">
	<table cellspacing="1" cellpadding="2" border="0" style="font-family:tahoma,arial;font-size:8pt;">
	<tr>
		<td><july:backbutton/></td>
		<TD>
			<july:select property="searchParameterName" styleId="searchParameterNameSelectId" 
						style="font-size:8pt;" insertable="false" updatable="false">
      				<html:option value="PNM">�������: ��������</html:option>
      				<html:option value="PAD">�������: �����</html:option>
      				<html:option value="BNR">������� �������: � GSM/DCS</html:option>
      				<html:option value="BNM">������� �������: ��������</html:option>
      				<html:option value="RNR">�������: �����</html:option>
      				<html:option value="RNM">�������: �������� �������� ��</html:option>
      				<html:option value="CNR">����������: �����</html:option>
      				<html:option value="CNM">����������: ��������</html:option>
      		</july:select>		
      	</TD>
		
		<td><july:string style="font-size:8pt;background-color:#FFFFFF;" size="135" property="searchParameterValue" styleId="searchParameterValueId" insertable="true" updatable="true"/></td>
		<td>
			<A onclick="runSearchProcess();">
									<IMG SRC="/images/refresh.gif" BORDER='0' ALT='������ ����� �����'>
			</A>
		<iframe frameborder=0 name="callPositionForm" width=0 height=0></iframe>
		</td>
	</tr>
	</table> 
</td>
</tr>

<tr class="normal">
<td colspan="<%= gColSpan %>" style="padding-left:12px;padding-right:12px;">
	<table width="100%" cellspacing="1" cellpadding="2" border="0" style="font-family:tahoma,arial;font-size:8pt;">
	<tr>
		<td width="15%"><b>�������� �������</b></td>
		<td width="60%" colspan="2"><b>����� �������</b></td>
		<td width="5%"><b>������</b></td>
		<td width="5%"><b>�������</b></td>
		<td width="15%" colspan="2"><b>��������� �������</b></td>
	</tr>
	<tr>
		<td><july:string style="font-size:8pt;background-color:#E0E0E0;" size="10" readonly="true" property="srPozName" styleId="srPozNameId" insertable="false" updatable="false"/></td>
		<td colspan="2"><july:string style="font-size:8pt;background-color:#E0E0E0;width:550px" size="130" readonly="true" property="srPozAddr" styleId="srPozAddrId" insertable="false" updatable="false"/></td>
		<td><july:string style="font-size:8pt;background-color:#E0E0E0;" size="5" readonly="true" property="srShirota" styleId="srShirotaId" insertable="false" updatable="false"/></td>
		<td><july:string style="font-size:8pt;background-color:#E0E0E0;" size="5" readonly="true" property="srDolglta" styleId="srDolgltaId" insertable="false" updatable="false"/></td>
		<td colspan="2"><july:string style="font-size:8pt;background-color:#E0E0E0;" size="5" readonly="true" property="srPozCond" styleId="srPozCondId" insertable="false" updatable="false"/></td>
	</tr>
	<tr>
		<td><b>������</b></td>
		<td width="30%"><b>������</b></td>
		<td width="30%"><b>���� ����</b></td>
		<td colspan="4" rowspan="2" >
		<table width="100%" cellspacing="0" cellpadding="0" border="0" style="font-family:tahoma,arial;font-size:8pt;">
				
		<logic:present name="BaseStationGSMForm" property="position.dopInfoVO" scope="session">
		<td width="46%" valign="bottom">&nbsp;</td>
		<td width="8%" valign="bottom">
			<%--
				<image name="onMap" src="/images/map.gif" alt='�����' onclick='determineMaps("<%=trailcomMapUrl%>","<%=ruser%>");' />			
			--%>	
			&nbsp;
		</td>
		<td width="8%" valign="bottom">
			<%--
			<A HREF="#"  onclick='document.body.style.cursor="wait"; showTerrabyteFile("<bean:write name="BaseStationGSMForm" property="position.storageplace" filter="true"/>", "pos", "10");  document.body.style.cursor="normal"; return true;'>
				<IMG SRC="/images/path.gif" border=0 ALT='����� �������'>
			</A>
			--%>	
			&nbsp;
		</td>
		<td width="8%" valign="bottom">
			<%--
			<A HREF="#"  onclick='document.body.style.cursor="wait"; showTerrabyteFile("<bean:write name="BaseStationGSMForm" property="position.storageplace" filter="true"/>", "pos", "9");  document.body.style.cursor="normal"; return true;'>
				<IMG SRC="/images/accesslist.gif" border=0 ALT='������ �������'>
			</A>
			--%>	
			&nbsp;
		</td>
		<td width="30%" align="right" valign="middle">
			<A href='positionDopInfo.jsp' onclick='return openDialog(this.href, "dopInfo", "top=100, left=100, width=600, height=300, scrollbars=yes, resizable=yes");' class='button'>
					���. ����<BR>� �������
			</A>
		</td>
		</logic:present>
		</table>
		</td>
		
	</tr>
	<tr>
		<td><july:string style="font-size:8pt;background-color:#E0E0E0;" size="10" readonly="true" property="srRegion" styleId="srRegionId" insertable="false" updatable="false"/></td>
		<td><july:string style="font-size:8pt;background-color:#E0E0E0;" size="22" readonly="true" property="srFilial" styleId="srFilialId" insertable="false" updatable="false"/></td>
		<td><july:string style="font-size:8pt;background-color:#E0E0E0;" size="16" readonly="true" property="srNetZona" styleId="srNetZonaId" insertable="false" updatable="false"/></td>
	</tr>
	</table> 
</td>
</tr>
	</table>
</td>
</tr>

<july:separator colspan="<%= gColSpan %>"/>

<tr class="normal">
	<td colspan="<%= gColSpan %>" bgcolor="#A5F3C6" style="padding-left:4px;padding-right:4px;">
		<!-- �������� �������������� �� -->
		<table width="100%" cellspacing="0" border="0">
			<tr>
				<td style="font-family:tahoma,arial;font-size:8pt;color:#000000;font-weight:bold;padding:4px;" colspan="3">
					�������� �������������� ��:
				</td>
			</tr>
			<tr>
				<td width="30%">
					<logic:present name="BaseStationGSMForm"  property="infoBsGsmOnPosition">
						<table id="infoBsID1" cellspacing="1" cellpadding="2" border="0" style="font-family:tahoma,arial;font-size:8pt;">
							<tr>
								<td><B>����������:</B></td>
								<td>
									<bean:write name="BaseStationGSMForm" property="infoBsGsmOnPosition.nameController" filter="true"/>
									<bean:write name="BaseStationGSMForm" property="infoBsGsmOnPosition.controllerStateLabel" filter="true"/>
								</td>
							</tr>
							<tr>
								<td nowrap>
									<B>���.</B>
									<html:hidden property="workerID"/>
									<july:lookupbutton action="/../inventory/ShowWorkerLookupList.do" styleId="worker" fieldNames="workerID;dummy1" newWindowName="WorkerLookup" insertable="true" updatable="true" onselect = "document.all.operation.value='changeWorker'; BaseStationGSMForm.submit();"/>
								</td>
								<td>
									<bean:write name="BaseStationGSMForm" property="infoBsGsmOnPosition.nameOtv" filter="true"/>
								</td>
							</tr>
						</table>
					</logic:present>
				</td>
				<td>
					<logic:present name="BaseStationGSMForm"  property="infoBsGsmOnPosition">
						<table id="infoBsID2" cellspacing="1" cellpadding="2" border="0" bgcolor="#999999" style="font-family:tahoma,arial;font-size:7pt;">
							<tr bgcolor="#CCCCCC">
								<th width="3%" nowrap>&nbsp;</th>
								<th width="12%" nowrap>��������� ��</th>
								<th width="5%" nowrap>������ ������������� ��</th>
								<th width="5%" nowrap>������ � ����. ���</th>
								<th width="5%" nowrap>������ � ����. ��</th>
								<%-- <th width="5%" nowrap>����.</th> --%>
								<th width="5%" nowrap>����������� � MSC</th>
								<th width="5%" nowrap>��������� � ����</th>
								<%-- <th width="5%" nowrap>�����. � ����.</th> --%>
							</tr>
							<tr class="normalrow" style="font-size:8pt;">
								<td nowrap>DCS
									<logic:equal name="BaseStationGSMForm" property="infoBsGsmOnPosition.isDCS" value="true">
										<B>+</B>
									</logic:equal>
						<%--<html:checkbox name="BaseStationGSMForm" property="infoBsGsmOnPosition.isDCS" disabled="true"/>--%>
								</td>
								<td>
									<bean:write name="BaseStationGSMForm" property="infoBsGsmOnPosition.state1800Label" filter="true"/>
								</td>
								<td><july:datewrite name="BaseStationGSMForm" property="infoBsGsmOnPosition.min_date_bldbegDCS" /></td>
								<td><july:datewrite name="BaseStationGSMForm" property="infoBsGsmOnPosition.min_date_assemb_afsDCS" /></td>
								<td><july:datewrite name="BaseStationGSMForm" property="infoBsGsmOnPosition.min_date_assembDCS" /></td>
								<%-- <td><july:datewrite name="BaseStationGSMForm" property="infoBsGsmOnPosition.min_date_testDCS" /></td> --%>
								<td><july:datewrite name="BaseStationGSMForm" property="infoBsGsmOnPosition.min_date_connectDCS" /></td>
								<td><july:datewrite name="BaseStationGSMForm" property="infoBsGsmOnPosition.min_date_onairDCS" /></td>
								<%-- <td><july:datewrite name="BaseStationGSMForm" property="infoBsGsmOnPosition.min_date_prDCS" /></td> --%>
							</tr>
							<tr class="normalrow" style="font-size:8pt;">
								<td nowrap>GSM
									<logic:equal name="BaseStationGSMForm" property="infoBsGsmOnPosition.isGSM" value="true">
										<B>+</B>
									</logic:equal>
						<%--<html:checkbox name="BaseStationGSMForm" property="infoBsGsmOnPosition.isGSM" disabled="true"/>--%>
								</td>
								<td>
									<bean:write name="BaseStationGSMForm" property="infoBsGsmOnPosition.state900Label" filter="true"/>
								</td>
								<td><july:datewrite name="BaseStationGSMForm" property="infoBsGsmOnPosition.min_date_bldbegGSM" /></td>
								<td><july:datewrite name="BaseStationGSMForm" property="infoBsGsmOnPosition.min_date_assemb_afsGSM" /></td>
								<td><july:datewrite name="BaseStationGSMForm" property="infoBsGsmOnPosition.min_date_assembGSM" /></td>
								<%-- <td><july:datewrite name="BaseStationGSMForm" property="infoBsGsmOnPosition.min_date_testGSM" /></td> --%>
								<td><july:datewrite name="BaseStationGSMForm" property="infoBsGsmOnPosition.min_date_connectGSM" /></td>
								<td><july:datewrite name="BaseStationGSMForm" property="infoBsGsmOnPosition.min_date_onairGSM" /></td>
								<%-- <td><july:datewrite name="BaseStationGSMForm" property="infoBsGsmOnPosition.min_date_prGSM" /></td> --%>
							</tr>
						</table>
					</logic:present>
				</td>
				<td>
					<logic:present name="BaseStationGSMForm"  property="infoBsGsmOnPosition">
						<table width="15%" id="infoBsID3" cellspacing="1" cellpadding="2" border="0" bgcolor="#999999" style="font-family:tahoma,arial;font-size:7pt;">
							<tr bgcolor="#CCCCCC">
								<th colspan="5">������������</th>
							</tr>
							<tr class="normalrow" style="font-size:8pt;">
								<td width="5%"><bean:write name="BaseStationGSMForm" property="infoBsGsmOnPosition.trx_num1800_A" filter="true"/></td>
								<td width="5%"><bean:write name="BaseStationGSMForm" property="infoBsGsmOnPosition.trx_num1800_B" filter="true"/></td>
								<td width="5%"><bean:write name="BaseStationGSMForm" property="infoBsGsmOnPosition.trx_num1800_C" filter="true"/></td>
								<td width="5%"><bean:write name="BaseStationGSMForm" property="infoBsGsmOnPosition.trx_num1800_D" filter="true"/></td>
								<td width="5%"><bean:write name="BaseStationGSMForm" property="infoBsGsmOnPosition.trx_num1800_O" filter="true"/></td>
							</tr>
							<tr class="normalrow" style="font-size:8pt;">
								<td width="5%"><bean:write name="BaseStationGSMForm" property="infoBsGsmOnPosition.trx_num900_E" filter="true"/></td>
								<td width="5%"><bean:write name="BaseStationGSMForm" property="infoBsGsmOnPosition.trx_num900_F" filter="true"/></td>
								<td width="5%"><bean:write name="BaseStationGSMForm" property="infoBsGsmOnPosition.trx_num900_G" filter="true"/></td>
								<td width="5%"><bean:write name="BaseStationGSMForm" property="infoBsGsmOnPosition.trx_num900_H" filter="true"/></td>
								<td width="5%"><bean:write name="BaseStationGSMForm" property="infoBsGsmOnPosition.trx_num900_O" filter="true"/></td>
							</tr>
						</table>
					</logic:present>
				</td>
			</tr>
		</table>
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>"/>

<tr class="normal">
	<td colspan="<%= gColSpan %>" bgcolor="#8899FF" style="padding-left:4px;padding-right:4px;">
		<table cellspacing="0" border="0">
			<tr>
				<td style="font-family:tahoma,arial;font-size:8pt;color:#000000;font-weight:bold;padding:4px;">
						<a title="��������/�������� ��" href="javascript:toggleDetail('bsID')">
							��:
						</a>
						<logic:present name="BaseStationGSMForm" property="position.dopInfoVO" scope="session">
							<!-- ����� ������ �� ������������ �� ������� -->
							<script>
								<!--
									function showEquipInfoWin() {
										return openDialog('/basestation/../siteinfo/ShowOSSEquipment.do?gsmid=<bean:write name="BaseStationGSMForm" property="position.gsmid" filter="true"/>&posname=<bean:write name="BaseStationGSMForm" property="position.name" filter="true"/>',
										'equipinfoWin', 'top=60, left=60, height=' + (screen.availHeight-150) + ', width=' + (screen.availWidth-150) + ', fullscreen=no,location=no,menubar=no,resizable=yes,scrollbars=yes,status=yes,titlebar=yes,toolbar=no');
									}
								-->
							</script>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<a href="#" onclick="return showEquipInfoWin();" class='button'>������������ �� ������ OSS</a>
							<!-- ��������� -->
								<script>
									<!--
										function showTerrabyteWin() {
											return openDialog('<%=com.hps.july.util.AppUtils.getNamedValueString("TerrabyteURL")%>?type=pos&id=<bean:write name="BaseStationGSMForm" property="position.storageplace" filter="true"/>&uid=<%=request.getRemoteUser()%>', "terrabyteWin", "top=60, left=60, height=" + (screen.availHeight-150) + ", width=" + (screen.availWidth-150) + ", fullscreen=no,location=no,menubar=no,resizable=yes,scrollbars=yes,status=no,titlebar=yes,toolbar=no");
										}
									-->
								</script>
							<a href="#" onclick="return showTerrabyteWin();" class='button'>���������</a>
						</logic:present>
				</td>
				<td style="font-family:tahoma,arial;font-size:8pt;color:#000000;font-weight:bold;padding:4px;">&nbsp;&nbsp;
						<a title="��������/�������� �������� ��������" href="javascript:toggleDetail('donorRepiterID')">
							������������(��������) ��������:
						</a>
				</td>
			</tr>
			<tr>
				<td>
					<!-- List BaseStations table -->
					<table id="bsID" width="100%" cellspacing="1" cellpadding="2" border="0" bgcolor="#999999" style="font-family:tahoma,arial;font-size:8pt;<%=bsDisplay%>;">
						<tr bgcolor="#CCCCCC">
							<td>
							<logic:present name="BaseStationGSMForm" property="position.dopInfoVO" scope="session">
								<%--
								<A href='<%= pathEquipmentEditTrailcom%>?id=<%= ruser%>&typeoper=0&eqid=0&eqtype=B&posid=<bean:write name="BaseStationGSMForm" property="position.storageplace" filter="true"/>' onclick='return openDialog(this.href, "window_BC", "top=100, left=100, width=650, height=600, scrollbars=yes, resizable=yes");'>
									<IMG SRC="/images/plus.gif" BORDER='0' ALT='�������� ��'>
								</A>
								--%>
							</logic:present>
							</td>
							<th>&nbsp;</th>
							<th><a title="���������� �� ���� 'number'" href="javascript:SortBy(document.all.bsSortBy, 'number')">
							�����</a><%=isUp(bsSortBy, "number")%></th>
							<th><a title="���������� �� ���� 'type'" href="javascript:SortBy(document.all.bsSortBy, 'type')">
							��� �������</a><%=isUp(bsSortBy, "type")%></th>
							<th><a title="���������� �� ���� 'name'" href="javascript:SortBy(document.all.bsSortBy, 'name')">
							������������</a><%=isUp(bsSortBy, "name")%></th>
							<%--
							<th>������� ���</th>
							--%>
							<%--
							<th><a title="���������� �� ���� 'state'" href="javascript:SortBy(document.all.bsSortBy, 'state')">
							���������</a><%=isUp(bsSortBy, "state")%></th>
							--%>
							<th>&nbsp;</th>
						</tr>
						<logic:iterate id="it" name="BaseStationGSMForm" property="bsList" type="com.hps.july.basestation.valueobject.BaseStation_VO">
							<logic:present name="it">
								<logic:notEqual name="it" property="type" value="DAMPS">
								<tr id='<bean:write name="it" property="equipment" filter="true"/>' class="normalrow" style="font-size:8pt;" onMouseOver="onMouseOverRow('bsID',this.id);" onMouseOut="onMouseOutRow('bsID',this.id);"  onclick='onClickRow("bsID",this.id);'>
									<td align="middle">
										<%
										if (request.isUserInRole("editFKBS")){
										%>
										<A href='<%= openFKBSEditAction%>' onclick='return openDialog(this.href, "window_BC", "top=100, left=100, width=650, height=600, scrollbars=yes, resizable=yes");'>
											<IMG SRC="/images/izmena.gif" BORDER='0' ALT='�������� ��'>
										</A>
										<%
										}
										else if (request.isUserInRole("viewFKBS")){
										%>
										<A href='<%= openFKBSViewAction%>' onclick='return openDialog(this.href, "window_BC", "top=100, left=100, width=650, height=600, scrollbars=yes, resizable=yes");'>
											<IMG SRC="/images/izmena.gif" BORDER='0' ALT='�������� ��'>
										</A>
										<%
										}
										%>
										<%--
										<A href='<%= pathEquipmentEditTrailcom%>?id=<%= ruser%>&typeoper=1&eqid=<bean:write name="it" property="equipment" filter="true"/>&eqtype=B' onclick='return openDialog(this.href, "window_BC", "top=100, left=100, width=650, height=600, scrollbars=yes, resizable=yes");'>
											<IMG SRC="/images/izmena.gif" BORDER='0' ALT='�������� ��'>
										</A>
										--%>
									</td>
									<td align="middle">
										<logic:greaterThan name="it" property="cardCount" value="0">
											<A href='EquipsdetListDialog.do?action=&equipment=<bean:write name="it" property="equipment" filter="true"/>' onclick='return openDialog(this.href, "equipsdetListDialog", "top=100, left=100, width=650, height=600, scrollbars=yes, resizable=yes");'>
												<IMG SRC="/images/details.gif" BORDER='0' ALT='������ ������������'>
											</A>
										</logic:greaterThan>
									</td>
									<td align="middle"><bean:write name="it" property="number" filter="true"/></td>
									<td align="middle"><bean:write name="it" property="type" filter="true"/></td>
									<td align="middle"><bean:write name="it" property="name" filter="true"/></td>
									<%--
									<td align="middle">
										<A href='SectorListDialog.do?action=&equipment=<bean:write name="it" property="equipment" filter="true"/>' onclick='return openDialog(this.href, "sectorListDialog", "top=100, left=100, width=650, height=600, scrollbars=yes, resizable=yes");'>
											<IMG SRC="/images/details.gif" BORDER='0' ALT='������ �������� ��'>
										</A>
									</td>
									--%>
									<%--
									<td align="middle">
										<logic:equal name="it" property="state" value="P">�����������</logic:equal>
										<logic:equal name="it" property="state" value="M">�����������</logic:equal>
										<logic:equal name="it" property="state" value="R">������������</logic:equal>
										<logic:equal name="it" property="state" value="T">�������������</logic:equal>
										<logic:equal name="it" property="state" value="W">�������� � ������</logic:equal>
										<logic:equal name="it" property="state" value="D">�������������</logic:equal>
									</td>
									--%>
									<td align="middle">
										<%--
										<A href='<%= pathEquipmentEditTrailcom%>?id=<%= ruser%>&typeoper=2&eqid=<bean:write name="it" property="equipment" filter="true"/>&eqtype=B' 
												onclick='return confirmEqDel("������� �������", "�����", "<bean:write name="it" property="number" filter="true"/>", this.href, "window_BC");'
												>
											<IMG SRC="/images/del.gif" BORDER='0' ALT='������� ��'>
										</A>
										--%>
									</td>
								<tr>
								</logic:notEqual>
							</logic:present>
						</logic:iterate>
					</table>
				</td>

				<td valign="top">
					<!-- ������������(��������) �������� -->
					<table id="donorRepiterID" cellspacing="1" cellpadding="2" border="0" bgcolor="#999999" style="font-family:tahoma,arial;font-size:8pt;<%=donorRepiterDisplay%>;">
						<tr bgcolor="#CCCCCC">
							<th>����� GSM</th> <th>������������ �������</th>
						</tr>
						<logic:iterate id="it" name="BaseStationGSMForm" property="donorRepiterList" type="com.hps.july.basestation.valueobject.DonorRepiterVO">
							<logic:present name="it">
								<tr class="normalrow" style="font-size:8pt;">
									<td align="middle"><bean:write name="it" property="numberGSM" filter="true"/></td>
									<td align="middle"><bean:write name="it" property="namePos" filter="true"/></td>
								<tr>
							</logic:present>
						</logic:iterate>
					</table>
				</td>				
			</tr>
		</table>
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>"/>

<tr class="normal">
	<td colspan="<%= gColSpan %>" bgcolor="#8899FF" style="padding-left:4px;padding-right:4px;">
	<!-- List repiters table -->
		<table width="100%" cellspacing="0" border="0">
			<tr>
					<td style="font-family:tahoma,arial;font-size:8pt;color:#000000;font-weight:bold;padding:4px;" width="30%">
						<a title="��������/�������� �������" href="javascript:toggleDetail('repiterID')">
							�������:
						</a>
					</td>
			</tr>
			<tr>
				<td>
					<table id="repiterID" width="100%" cellspacing="1" cellpadding="2" border="0" bgcolor="#999999" style="font-family:tahoma,arial;font-size:8pt;<%=repiterDisplay%>;">
						<tr bgcolor="#CCCCCC">
							<td>
							<logic:present name="BaseStationGSMForm" property="position.dopInfoVO" scope="session">
								<A href='<%= pathEquipmentEditTrailcom%>?id=<%= ruser%>&typeoper=0&eqid=0&eqtype=R&posid=<bean:write name="BaseStationGSMForm" property="position.storageplace" filter="true"/>' onclick='return openDialog(this.href, "window_R", "top=100, left=100, width=650, height=600, scrollbars=yes, resizable=yes");'>
									<IMG SRC="/images/plus.gif" BORDER='0' ALT='�������� ��������'>
								</A>
							</logic:present>
							</td>
							<th>&nbsp;</th>
							<th><a title="���������� �� ���� 'number'" href="javascript:SortBy(document.all.repiterSortBy,'number')">
							�����</a><%=isUp(repiterSortBy, "number")%></th>
							<th><a title="���������� �� ���� 'donorBS'" href="javascript:SortBy(document.all.repiterSortBy,'donorBS')">
							�������� ��</a><%=isUp(repiterSortBy, "donorBS")%></th>
							<th><a title="���������� �� ���� 'donorSector'" href="javascript:SortBy(document.all.repiterSortBy,'donorSector')">
							�������� ������</a><%=isUp(repiterSortBy, "donorSector")%></th>
							<th><a title="���������� �� ���� 'donorAntenn'" href="javascript:SortBy(document.all.repiterSortBy,'donorAntenn')">
							�������� �������</a><%=isUp(repiterSortBy, "donorAntenn")%></th>
							<th><a title="���������� �� ���� 'donor_type'" href="javascript:SortBy(document.all.repiterSortBy,'donor_type')">
							��� �����������</a><%=isUp(repiterSortBy, "donor_type")%></th>
							<th><a title="���������� �� ���� 'date_assemb'" href="javascript:SortBy(document.all.repiterSortBy,'date_assemb')">
							������</a><%=isUp(repiterSortBy, "date_assemb")%></th>
							<th><a title="���������� �� ���� 'date_test'" href="javascript:SortBy(document.all.repiterSortBy, 'date_test')">
							������������</a><%=isUp(repiterSortBy, "date_test")%></th>
							<th><a title="���������� �� ���� 'date_pr'" href="javascript:SortBy(document.all.repiterSortBy, 'date_pr')">
							�������</a><%=isUp(repiterSortBy, "date_pr")%></th>
							<th>&nbsp;</th>
						</tr>
						<logic:iterate id="it" name="BaseStationGSMForm" property="repiterList" type="com.hps.july.basestation.valueobject.Repiter_TO">
							<logic:present name="it">
								<%	String dt = it.getO().getDonor_type().toLowerCase(); %>
								<tr id='<bean:write name="it" property="o.equipment" filter="true"/>' class="normalrow" style="font-size:8pt;" onMouseOver="onMouseOverRow('repiterID',this.id);" onMouseOut="onMouseOutRow('repiterID',this.id);"  onclick='onClickRow("repiterID",this.id);'>
									<td align="middle">
										<A href='<%= pathEquipmentEditTrailcom%>?id=<%= ruser%>&typeoper=1&eqid=<bean:write name="it" property="o.equipment" filter="true"/>&eqtype=R' onclick='return openDialog(this.href, "window_R", "top=100, left=100, width=650, height=600, scrollbars=yes, resizable=yes");'>
											<IMG SRC="/images/izmena.gif" BORDER='0' ALT='�������� ��������'>
										</A>
									</td>
									<td align="middle">
										<logic:greaterThan name="it" property="o.cardCount" value="0">
											<A href='EquipsdetListDialog.do?action=&equipment=<bean:write name="it" property="o.equipment" filter="true"/>' onclick='return openDialog(this.href, "equipsdetListDialog", "top=100, left=100, width=650, height=600, scrollbars=yes, resizable=yes");'>
												<IMG SRC="/images/details.gif" BORDER='0' ALT='������ ������������'>
											</A>
										</logic:greaterThan>
									</td>
									<td align="middle"><bean:write name="it" property="o.number" filter="true"/></td>
									<td align="middle"><bean:write name="it" property="donorBS" filter="true"/></td>
									<td align="middle"><bean:write name="it" property="donorSector" filter="true"/></td>
									<td align="middle"><bean:write name="it" property="donorAntenn" filter="true"/></td>
									<td align="middle"><bean:message key='<%="repeaterlist.donortype."+dt%>'/></td>
									<td align="middle"><july:datewrite name="it" property="o.date_assemb"/></td>
									<td align="middle"><july:datewrite name="it" property="o.date_test"/></td>
									<td align="middle"><july:datewrite name="it" property="o.date_pr"/></td>
									<td align="middle">
										<A href='<%= pathEquipmentEditTrailcom%>?id=<%= ruser%>&typeoper=2&eqid=<bean:write name="it" property="o.equipment" filter="true"/>&eqtype=R' onclick='return confirmEqDel("�������", "�������� ��", "<bean:write name="it" property="donorBS" filter="true"/>", this.href, "window_BC");'>
											<IMG SRC="/images/del.gif" BORDER='0' ALT='������� ��������'>
										</A>
									</td>
								<tr>
							</logic:present>
						</logic:iterate>
					</table>
				</td>
			</tr>
		</table>
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>"/>

<tr class="normal">
	<td colspan="<%= gColSpan %>" bgcolor="#8899FF" style="padding-left:4px;padding-right:4px;">
	<!-- List controllers table -->
		<table width="100%" cellspacing="0" border="0">
			<tr>
					<td style="font-family:tahoma,arial;font-size:8pt;color:#000000;font-weight:bold;padding:4px;" width="30%">
						<a title="��������/�������� ����������" href="javascript:toggleDetail('controllerID')">
							����������:
						</a>
					</td>
			</tr>
			<tr>
				<td>
					<table id="controllerID" width="100%" cellspacing="1" cellpadding="2" border="0" bgcolor="#999999" style="font-family:tahoma,arial;font-size:8pt;<%=controllerDisplay%>;">
						<tr bgcolor="#CCCCCC">
							<td>
							<logic:present name="BaseStationGSMForm" property="position.dopInfoVO" scope="session">
								<A href='<%= pathEquipmentEditTrailcom%>?id=<%= ruser%>&typeoper=0&eqid=0&eqtype=O&posid=<bean:write name="BaseStationGSMForm" property="position.storageplace" filter="true"/>' onclick='return openDialog(this.href, "window_O", "top=100, left=100, width=750, height=600, scrollbars=yes, resizable=yes");'>
									<IMG SRC="/images/plus.gif" BORDER='0' ALT='�������� ����������'>
								</A>
							</logic:present>
							</td>
							<th>&nbsp;</th>
							<th><a title="���������� �� ���� 'number'" href="javascript:SortBy(document.all.controllerSortBy,'number')">
							�����</a><%=isUp(controllerSortBy, "number")%></th>
							<th><a title="���������� �� ���� 'name'" href="javascript:SortBy(document.all.controllerSortBy,'name')">
							������������</a><%=isUp(controllerSortBy, "name")%></th>
							<th><a title="���������� �� ���� 'state'" href="javascript:SortBy(document.all.controllerSortBy,'state')">
							������</a><%=isUp(controllerSortBy, "state")%></th>
							<th><a title="���������� �� ���� 'date_assemb'" href="javascript:SortBy(document.all.controllerSortBy,'date_assemb')">
							���� �������</a><%=isUp(controllerSortBy, "date_assemb")%></th>
							<th><a title="���������� �� ���� 'date_test'" href="javascript:SortBy(document.all.controllerSortBy, 'date_test')">
							���� ������������</a><%=isUp(controllerSortBy, "date_test")%></th>
							<th><a title="���������� �� ���� 'date_pr'" href="javascript:SortBy(document.all.controllerSortBy, 'date_pr')">
							���� �������</a><%=isUp(controllerSortBy, "date_pr")%></th>
							<th>&nbsp;</th>
						</tr>
						<logic:iterate id="it" name="BaseStationGSMForm" property="controllerList" type="com.hps.july.basestation.valueobject.Controller_VO">
							<logic:present name="it">
								<tr id='<bean:write name="it" property="equipment" filter="true"/>' class="normalrow" style="font-size:8pt;" onMouseOver="onMouseOverRow('controllerID',this.id);" onMouseOut="onMouseOutRow('controllerID',this.id);"  onclick='onClickRow("controllerID",this.id);'>
									<td align="middle">
										<A href='<%= pathEquipmentEditTrailcom%>?id=<%= ruser%>&typeoper=1&eqid=<bean:write name="it" property="equipment" filter="true"/>&eqtype=O' onclick='return openDialog(this.href, "window_O", "top=100, left=100, width=750, height=600, scrollbars=yes, resizable=yes");'>
											<IMG SRC="/images/izmena.gif" BORDER='0' ALT='�������� ����������'>
										</A>
									</td>
									<td align="middle">
										<logic:greaterThan name="it" property="cardCount" value="0">
											<A href='EquipsdetListDialog.do?action=&equipment=<bean:write name="it" property="equipment" filter="true"/>&eqtype=O' onclick='return openDialog(this.href, "equipsdetListDialog", "top=100, left=100, width=650, height=600, scrollbars=yes, resizable=yes");'>
												<IMG SRC="/images/details.gif" BORDER='0' ALT='������ ������������'>
											</A>
										</logic:greaterThan>
									</td>
									<td align="middle"><bean:write name="it" property="number" filter="true"/></td>
									<td align="middle"><bean:write name="it" property="name" filter="true"/></td>
									<td align="middle"><bean:write name="it" property="stateLabel" filter="true"/></td>
									<td align="middle"><july:datewrite name="it" property="date_assemb"/></td>
									<td align="middle"><july:datewrite name="it" property="date_test"/></td>
									<td align="middle"><july:datewrite name="it" property="date_pr"/></td>
									<td align="middle">

										<A href='<%= pathEquipmentEditTrailcom%>?id=<%= ruser%>&typeoper=2&eqid=<bean:write name="it" property="equipment" filter="true"/>&eqtype=O' 
												onclick='return confirmEqDel("����������", "�����", "<bean:write name="it" property="number" filter="true"/>", this.href, "window_O");'
												>
											<IMG SRC="/images/del.gif" BORDER='0' ALT='������� ����������'>
										</A>
										
									</td>
								<tr>
							</logic:present>
						</logic:iterate>
					</table>
				</td>
			</tr>
		</table>
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>"/>

<tr class="normal">
	<td colspan="<%= gColSpan %>" bgcolor="#8899FF" style="padding-left:4px;padding-right:4px;">
	<!-- List EquipDetList table -->
		<table width="100%" cellspacing="0" border="0">
			<tr>
					<td style="font-family:tahoma,arial;font-size:8pt;color:#000000;font-weight:bold;padding:4px;">
						<a title="�������� ������������'" href="javascript:setDetailEquip();" id="detailEquipLabel">
							������������(��, ��������, �����������):
						</a>&nbsp;&nbsp;&nbsp;<B>|</B>&nbsp;&nbsp;&nbsp;&nbsp;
						<a title="�������� ���������'" href="javascript:setDetailDoc();" id="detailDocLabel">
							���������:
						</a>&nbsp;&nbsp;&nbsp;<B>|</B>&nbsp;&nbsp;&nbsp;&nbsp;
						<a title="�������� ������'" href="javascript:setDetailJob();" id="detailJobLabel">
							������:
						</a>
					</td>
			</tr>
			<tr>
				<td valign="top">
					<!-- ������������(��, ��������, �����������): -->
					<table id="equipDetID" width="100%" cellspacing="1" cellpadding="2" border="0" bgcolor="#999999" style="font-family:tahoma,arial;font-size:8pt;">
						<tr bgcolor="#CCCCCC">
							<th><a title="���������� �� ���� 'name'" href="javascript:SortBy(document.all.equipDetSortBy,'name')">
							��������</a><%=isUp(equipDetSortBy, "name")%></th>

							<th><a title="���������� �� ���� 'model'" href="javascript:SortBy(document.all.equipDetSortBy,'model')">
							manucode - model</a><%=isUp(equipDetSortBy, "model")%></th>

							<th><a title="���������� �� ���� 'serialnumber'" href="javascript:SortBy(document.all.equipDetSortBy,'serialnumber')">
							�������� �����</a><%=isUp(equipDetSortBy, "serialnumber")%></th>

							<th><a title="���������� �� ���� 'qty'" href="javascript:SortBy(document.all.equipDetSortBy, 'qty')">
							����������</a><%=isUp(equipDetSortBy, "qty")%></th>

							<th><a title="���������� �� ���� 'place'" href="javascript:SortBy(document.all.equipDetSortBy, 'place')">
							���������� �����</a><%=isUp(equipDetSortBy, "place")%></th>

							<th><a title="���������� �� ���� 'comment'" href="javascript:SortBy(document.all.equipDetSortBy,'comment')">
							�����������</a><%=isUp(equipDetSortBy, "comment")%></th>
						</tr>
						<logic:iterate id="it" name="BaseStationGSMForm" property="equipDetList" type="com.hps.july.basestation.valueobject.Equipdet_TO ">
							<logic:present name="it">
								<tr id='<bean:write name="it" property="scard.storagecard" filter="true"/>' class="normalrow" style="font-size:8pt;" onMouseOver="onMouseOverRow('equipDetID',this.id);" onMouseOut="onMouseOutRow('equipDetID',this.id);"  onclick='onClickRow("equipDetID",this.id);'>
									<td align="middle"><bean:write name="it" property="name" filter="true"/></td>
									<td align="middle">
										<bean:write name="it" property="manucode" filter="true"/> - <bean:write name="it" property="model" filter="true"/>
									</td>
									<td align="middle"><bean:write name="it" property="scard.serialnumber" filter="true"/></td>
									<td align="middle"><bean:write name="it" property="scard.qty" filter="true"/></td>
									<td align="middle"><bean:write name="it" property="scard.place" filter="true"/></td>
									<td align="left"><bean:write name="it" property="scard.comment" filter="true"/></td>
								<tr>
							</logic:present>
						</logic:iterate>
					</table>
					<!-- ���������: -->
					<table id="docID" width="100%" cellspacing="1" cellpadding="2" border="0" bgcolor="#999999" style="font-family:tahoma,arial;font-size:8pt;">
						<tr bgcolor="#CCCCCC">
							<th width="10%">���� ���������</th>
							<th width="20%">��������</th>
							<th width="20%">��� ���������</th>
							<th width="50%">�����������</th>
						</tr>
						<logic:iterate id="it" name="BaseStationGSMForm" property="docList" type="com.hps.july.basestation.valueobject.DocAndWorkForGSM_VO">
							<logic:present name="it">
								<tr id='<bean:write name="it" property="idDoc" filter="true"/>' class="normalrow" style="font-size:8pt;" onMouseOver="onMouseOverRow('docID',this.id);" onMouseOut="onMouseOutRow('docID',this.id);"  onclick='onClickRow("docID",this.id);'>
									<td align="middle"><july:datewrite name="it" property="dateDoc"/></td>
									<td align="middle"><bean:write name="it" property="nameEquipment" filter="true"/></td>
									<td align="middle">
										<logic:equal name="it" property="isDocTypeCodeCanBeLinked" value="true">
											<A href='ChooseDocumentForm.do?idDoc=<bean:write name="it" property="idDoc" filter="true"/>&docTypeCode=<bean:write name="it" property="docTypeCode" filter="true"/>&visualType=<bean:write name="it" property="visualType" filter="true"/>&state=<bean:write name="it" property="state" filter="true"/>&isAutoDoc=<bean:write name="it" property="isAutoDoc" filter="true"/>' >
													<bean:write name="it" property="typeDoc" filter="true"/>
											</A>
										</logic:equal>	
										<logic:equal name="it" property="isDocTypeCodeCanBeLinked" value="false">
											<bean:write name="it" property="typeDoc" filter="true"/>
										</logic:equal>	
									</td>
									<td align="left"><bean:write name="it" property="noteWork" filter="true"/></td>
								<tr>
							</logic:present>
						</logic:iterate>
					</table>

					<!-- ������: -->
					<table id="jobID" width="100%" cellspacing="1" cellpadding="2" border="0" bgcolor="#999999" style="font-family:tahoma,arial;font-size:8pt;">
						<tr bgcolor="#CCCCCC">
							<td width="3%">
							<logic:present name="BaseStationGSMForm" property="position.dopInfoVO" scope="session">
								<A href='ReglamentWorksDialog.do?action=Add&positionId=<bean:write name="BaseStationGSMForm" property="position.storageplace" filter="true"/>' onclick='return openDialog(this.href, "RegWorksDialog", "top=100, left=100, width=750, height=450, scrollbars=yes, resizable=yes");'>
									<IMG SRC="/images/plus.gif" BORDER='0' ALT='�������� ������'>
								</A>
							</logic:present>
							</td>
							<th width="10%">���� ������</th>
							<th width="32%">������������ ������</th>
							<th width="52%">���������� ������</th>
							<th width="3%">&nbsp;</th>
						</tr>
						<logic:iterate id="it" name="BaseStationGSMForm" property="jobList" type="com.hps.july.basestation.valueobject.DocAndWorkForGSM_VO">
							<logic:present name="it">
								<tr id='<bean:write name="it" property="idDoc" filter="true"/>' class="normalrow" style="font-size:8pt;" onMouseOver="onMouseOverRow('jobID',this.id);" onMouseOut="onMouseOutRow('jobID',this.id);"  onclick='onClickRow("jobID",this.id);'>
									<td align="middle">
										<logic:equal name="it" property="type" value="W">
											<A href='ReglamentWorksDialog.do?action=Edit&idWork=<bean:write name="it" property="idDoc" filter="true"/>&positionId=<bean:write name="BaseStationGSMForm" property="position.storageplace" filter="true"/>' onclick='return openDialog(this.href, "RegWorksDialog", "top=100, left=100, width=750, height=450, scrollbars=yes, resizable=yes");'>
												<IMG SRC="/images/izmena.gif" BORDER='0' ALT='�������� ������'>
											</A>
										</logic:equal>
									</td>
									<td align="middle"><july:datewrite name="it" property="dateDoc"/></td>
									<!-- <td align="middle"><bean:write name="it" property="nameEquipment" filter="true"/></td>
									<td align="middle"><bean:write name="it" property="fio" filter="true"/></td> -->
									<td align="middle"><bean:write name="it" property="typeDoc" filter="true"/></td>
									<td align="left"><bean:write name="it" property="noteWork" filter="true"/></td>
									<td align="middle">
										<logic:equal name="it" property="type" value="W">
											<A href='ReglamentWorksDialog.do?action=Delete&idWork=<bean:write name="it" property="idDoc" filter="true"/>&positionId=<bean:write name="BaseStationGSMForm" property="position.storageplace" filter="true"/>' onclick='return openDialog(this.href, "RegWorksDialog", "top=100, left=100, width=750, height=450, scrollbars=yes, resizable=yes");'>
												<IMG SRC="/images/del.gif" BORDER='0' ALT='������� ������'>
											</A>
										</logic:equal>
									</td>
								<tr>
							</logic:present>
						</logic:iterate>
					</table>

				</td>
			</tr>
		</table>
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>"/>

<tr class="title">
	<td colspan="<%= gColSpan %>">
	<table class="find">
		<tr>
			<td class="buttons"><july:backbutton/></td>
			<td>
					<A href='/basestation/../inventory/ShowAssemblingPList.do?isowner=true&positioncode=<bean:write name="BaseStationGSMForm" property="position.storageplace" filter="true"/>' class='button'>���� �������</A>
			</td>
			<td>
					<A href='/basestation/../inventory/ShowAfsList.do?isowner=true&positioncode=<bean:write name="BaseStationGSMForm" property="position.storageplace" filter="true"/>' class='button'>���� ������� ���</A>
			</td>
			<td>
					<A href='/basestation/../inventory/ShowDemountList.do?isowner=true&positioncode=<bean:write name="BaseStationGSMForm" property="position.storageplace" filter="true"/>' class='button'>���� ���������</A>
			</td>
			<td>
					<A href='/basestation/../inventory/ShowFaultList.do?isowner=true&positioncode=<bean:write name="BaseStationGSMForm" property="position.storageplace" filter="true"/>' class='button'>Fault report</A>
			</td>
			<td>
					<A href='/basestation/../inventory/ShowPositionInventoryList.do?showallstorage=false&position=<bean:write name="BaseStationGSMForm" property="position.storageplace" filter="true"/>' class='button'>�������������� �� �������</A>
			</td>
			<td>
					<A href='/basestation/../inventory/ShowContractorInventoryList.do?showallstorage=false&position=<bean:write name="BaseStationGSMForm" property="position.storageplace" filter="true"/>' class='button'>���� �������������� �� ����������</A>
			</td>
            <td>
				<a href="#" title="������" onclick="<%= helpFile %>"><img src="/images/helph.gif" border="0" hspace="12"></a>
			</td>
		</tr>
	</table>
	</td>
</tr>

</table>
<!-- ������������� ����� ������ -->
<script language="javascript">
	loadSelectedRow('repiterID');
	loadSelectedRow('bsID');
	loadSelectedRow('controllerID');
	loadSelectedRow('equipDetID');
	loadSelectedRow('docID');
	loadSelectedRow('jobID');
	initDetailDoc();	
</script>

</july:editform>

</body>
</html>