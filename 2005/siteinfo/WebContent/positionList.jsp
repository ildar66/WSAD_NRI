<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import="org.apache.struts.util.*" %>
<%@ page import="com.hps.july.siteinfo.valueobject.*" %>
<%@ page import="com.hps.july.siteinfo.formbean.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<%
	com.hps.july.jdbcpersistence.lib.TimeCounter tc = new com.hps.july.jdbcpersistence.lib.TimeCounter("PERF.SITEINFO.POSLIST");
	tc.start();
		 
	String trailcomMapUrl = com.hps.july.util.AppUtils.getNamedValueString("PathMapTrailcom");
	String ruser = request.getRemoteUser();
%>


<% java.lang.String gColSpan = "10"; %>
<OBJECT ID="dufos" WIDTH=1 HEIGHT=1 CLASSID="CLSID:C216375F-F8D6-4905-84DB-370425BCE6C0"></OBJECT>

<july:browseform action="/ShowPositionList.do" styleId="PosForm">
<style>
TABLE.main {font-size:8pt;}
TABLE.find {font-size:8pt;}
INPUT {font-size:8pt;}
SELECT {font-size:8pt;}
.editcheckbox {font-size:8pt;}
.editcheckboxform {font-size:8pt;}
.editcheckboxdisabled {font-size:8pt;}
.editkod {font-size:8pt;}
.editkodsearch {font-size:8pt;}
.editkoddisabled {font-size:8pt;}
.edit {font-size:8pt;}
.editsearch {font-size:8pt;width:152pt;}
.editdisabled {font-size:8pt;width:152pt;}
.editsmall {font-size:8pt;}
.diffeditsmall {font-size:8pt;}
.editsmallsearch {font-size:8pt;}
.edittini {font-size:8pt;}
.editsmalldisabled {font-size:8pt;}
.diffeditsmalldisabled {font-size:8pt;}
.editbig {font-size:8pt;}
.editbigsearch {font-size:8pt;}
.editbigdisabled {font-size:8pt;}
.editbigest {font-size:8pt;}
.editbigestsearch {font-size:8pt;}
.editbigestdisabled {font-size:8pt;}
INPUT.search {font-size:8pt;}
</style>

<script language="javascript">
	function determineMaps(url,user) {
		var checkboxs = document.getElementsByTagName('INPUT');
		var positions = "";
		var isMany = false;
		if(checkboxs) {
			for(var i = 0; i < checkboxs.length; i++) {
				var element = checkboxs[i];
				if(element.getAttribute('type') && element.getAttribute('type') == 'checkbox') {
					if(element.getAttribute('name') && element.getAttribute('name') == 'checkEquipment') {
						if(element.getAttribute('checked') && element.getAttribute('checked') == true){
							
							<%--if(element.getAttribute('regionid') && element.getAttribute('regionid') != '') {
								if(positions != '') positions += ','
								positions += (element.getAttribute('value') + ',' + element.getAttribute('regionid'));
							}--%>

							if(isMany){
								alert('На данный момент функция отображения нескольких позиций отключена. Выберите одну позицию.');
								return false;
							}
							isMany = true;
							positions = '?id='+user+'&type=1&position=' + element.getAttribute('value');
						}
					}
				}
			}
		}

		if(positions == '') {
			alert('Не выбранно ни одной позиции ! ');
			return false;
		}        
		var urlShortInfo = (url + positions);

        retVal = window.open(urlShortInfo, "retVal", "top=10,left=10,width=1000,height=800,resizable=1,scrollbars=1,statusbar=1,status=0,toolbar=0");
        if(retVal) retVal.focus();
		return true;
	}

    function showMap(map, region, pos) {
        if(retVal) retVal.close();
        retVal = null;
        document.location.href= ('/siteinfo/spm?map=' + map + '&supregion=' + region + '&positionid=' + pos);
    }

function switchRenterSearch(state) {
	if(state) {
		document.all.renterSearchType.value = "<%= Position.RENTER_Any %>"
		PosForm.organization.className = 'editkoddisabled';
		PosForm.organization.disabled = true;
		document.all['lookupimg_r1l'].src='/images/lookup_disabled.gif';
	} else {
		document.all.renterSearchType.value = "<%= Position.RENTER_Specify %>"
		PosForm.organization.className = 'editkodsearch';
		PosForm.organization.disabled = false;
		document.all['lookupimg_r1l'].src='/images/lookup.gif';
	}
}
function switchWorkerSearch(state) {
	if(state) {
		PosForm.worker.className = 'editkoddisabled';
		PosForm.worker.disabled = true;
		document.all['lookupimg_wrkl'].src='/images/lookup_disabled.gif';
	} else {
		PosForm.worker.className = 'editkodsearch';
		PosForm.worker.disabled = false;
		document.all['lookupimg_wrkl'].src='/images/lookup.gif';
	}
}
function switchAllSearch() {
	if(PosForm.searchBy.value=="A" ||
	   PosForm.searchBy.value=="F" ||
	   PosForm.searchBy.value=="G" ||
	   PosForm.searchBy.value=="H" ||
	   PosForm.searchBy.value=="K" ||
	   PosForm.searchBy.value=="L" ||
	   PosForm.searchBy.value=="M" 
	) {
		  PosForm.searchString.className = 'editdisabled';
		  PosForm.searchString.disabled = true;
	} else {
		PosForm.searchString.className = 'editsearch';
		PosForm.searchString.disabled = false;
	}
}

function reporttoexcel() {
	var myWindow = window.open("PositionsDownload", "_blank" , "top=40, left=100, width=830, height=600, scrollbars=yes, resizable=yes, menubar=yes");
	myWindow.focus();
}

</script>
<script>
<!--
	function showMapInfo() {
		alert('Маршрутная карта либо отсутствует или требуется указать одну из списка.');
	}
	function showListInfo() {
		alert('Список прохода либо отсутствует или требуется указать один из списка.');
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
				alert('Во время загрузки произошла ошибка !');
			}
		} catch(e) {
			url = url + "&lang=tr";
		    var lastVer = window.open(url , "lastVer", "resizable=1,scrollbars=0,statusbar=0,status=0,toolbar=0");
		    if(lastVer) lastVer.focus();
		}
	}
-->
</script>

<table class="main">
<july:separator colspan="<%= gColSpan %>" />
<TR class="normal">
	<TD colspan="<%= gColSpan %>">
	<table class="find">
	<TR class='normal'>
		<td colspan="4">
		<table border=0 width="100%" cellpadding=0 cellspacing=0>
		<tr>
			<td><jsp:include page="/common/regionsselect.jsp" flush="true" /></td>
			<td><july:searchbutton/></td>
		</tr>
		</table>
		</td>
	</TR>
	<TR>
		<td class="title"><bean:message key="label.position.searchby"/></td>
		<td class="title" colspan='3'>
			<july:select property="searchBy" styleClass="editsearch" onchange="switchAllSearch();" insertable="true" updatable="true">
				<html:option value="A"><bean:message key="label.position.search.all"/></html:option>
				<html:option value="F"><bean:message key="label.position.search.bsgsm"/></html:option>
				<html:option value="G"><bean:message key="label.position.search.bsdamps"/></html:option>
				<html:option value="H"><bean:message key="label.position.search.nobs"/></html:option>
				<html:option value="B"><bean:message key="label.position.search.gsmid"/></html:option>
				<html:option value="C"><bean:message key="label.position.search.dampsid"/></html:option>
				<html:option value="D"><bean:message key="label.position.search.name"/></html:option>
				<html:option value="E"><bean:message key="label.position.search.addr"/></html:option>
				<html:option value="I"><bean:message key="label.position.search.trid"/></html:option>
				<html:option value="K"><bean:message key="label.position.search.trall"/></html:option>
				<html:option value="L"><bean:message key="label.position.search.trrrl"/></html:option>
				<html:option value="M"><bean:message key="label.position.search.trvot"/></html:option>
				<html:option value="N"><bean:message key="label.position.search.beenetid"/></html:option>
				<html:option value="O"><bean:message key="label.position.search.contrnum"/></html:option>
				<html:option value="R"><bean:message key="label.position.search.repeaternum"/></html:option>
				<html:option value="W"><bean:message key="label.position.search.wlannum"/></html:option>
			</july:select>&nbsp;&nbsp;
			<bean:message key="label.position.search.text"/>&nbsp;<html:text styleClass="search" property="searchString" styleId="editsearch" size="25" />
		</td>
	</TR>
	<TR>
		<td class="title"><bean:message key="label.position.renter"/></td>
		<td class="title" colspan='3'>
			<INPUT TYPE="checkbox" id="renterSearchTypeC" style="editcheckbox" value="<%= Position.RENTER_Any %>" onclick="switchRenterSearch(document.all.renterSearchTypeC.checked)" />&nbsp;<bean:message key="label.search.all"/>&nbsp;&nbsp;&nbsp;
			<july:string property="organization" styleId="organization" size="5" insertable="true" updatable="true" />
			<july:lookupbutton action="/ShowRenterLookupList.do" styleId="r1l" fieldNames="organization;orgname" insertable="true" updatable="true" onclick="if (document.all.organization.disabled) { return false; }"/>
			<july:string size="35" property="orgname" styleId="orgname" insertable="false" updatable="false" />
			<html:hidden property="renterSearchType" styleId="renterSearchType"/>
		</td>
	</tr>
	<TR>
		<td class="title"><bean:message key="label.position.worker"/></td>
		<td class="title" colspan='3'>
			<july:checkbox property="isWorker" styleId="isWorker" insertable="true" updatable="true" onclick="switchWorkerSearch(document.all.isWorker[0].checked)" />&nbsp;<bean:message key="label.search.all"/>&nbsp;&nbsp;&nbsp;
			<july:string property="workerFrm" styleId="worker" size="5" insertable="true" updatable="false" />
			<july:lookupbutton action="/ShowWorkerLookupList.do" styleId="wrkl" fieldNames="worker;workername" insertable="true" updatable="false" onclick="if (document.all.isWorker[0].checked) { return false; }"/>
			<july:string size="35" property="workername" styleId="workername"  insertable="false" updatable="false" />
		</td>
	</TR>
	<TR>
		<td class="title"><bean:message key="label.position.posstate"/></td>
		<td class="title" colspan='3'>
			<july:select property="posstate" styleClass="editsearch" 
					style="width: 450px;"
					insertable="true" updatable="true">
				<html:option value="PE"><bean:message key="posstate.pe"/></html:option>
				<html:option value="P"><bean:message key="posstate.p"/></html:option>
				<html:option value="E"><bean:message key="posstate.e"/></html:option>
				<html:option value="D"><bean:message key="posstate.d"/></html:option>
				<html:option value="*"><bean:message key="posstate.all"/></html:option>
			</july:select>
		</td>
	</TR>
	</table>
	</TD>
</TR>

<script language="javascript">
	if (document.all.renterSearchType.value == "<%= Position.RENTER_Specify %>")
		document.all.renterSearchTypeC.checked = false;
	else
		document.all.renterSearchTypeC.checked = true;
	switchRenterSearch(document.all.renterSearchTypeC.checked);
	switchWorkerSearch(document.all.isWorker[0].checked);
	switchAllSearch();
</script>

<july:separator colspan="<%= gColSpan %>"/>

<tr class="title">
	<td colspan="<%= gColSpan %>"><TABLE class="buttons"><TR class="title">
		<TD class="buttons">
			<july:canedit rolesProperty="addRoles">
				<july:addbutton page="/AddDelPosition.do?action=Add"/>
			</july:canedit>

			<july:backbutton page="/main.do"/>&nbsp;			
			<image name="onMap" src="/images/map.gif" alt="<bean:message key="label.position.show_Onmap"/>" onclick='determineMaps("<%=trailcomMapUrl%>","<%=ruser%>");' />
			<html:hidden property="showOnmap"/>&nbsp;<IMG src="/images/kontr.gif" alt='<bean:message key="label.position.toexcel"/>' onclick="reporttoexcel(); return false;">
		</TD>
		<td align="right">
						Найдено позиций:<%= request.getAttribute("numberOfLines") %>
					</td>
		<TD class="navigator"><july:navigator/></TD>
	</TR></TABLE></td>
</tr>

<july:separator colspan="<%= gColSpan %>" />

<!-- Table header -->
<tr class="title">
	<july:sortcolumn key="label.position.gsmid" colType="string" ascFinder="5" descFinder="6" />
	<july:sortcolumn key="label.position.dampsid" colType="string" ascFinder="7" descFinder="8" />
	<july:sortcolumn key="label.position.name" colType="string" ascFinder="3" descFinder="4" />
	<july:headercolumn key="label.position.addr"  colType="string"/>
	<july:headercolumn key="label.positionList.netzone" colType="string"/>
	<july:headercolumn key="label.positionList.planstate" colType="string"/>
	<july:headercolumn key="label.position.showOnmap" colType="string"/>
	<td class="title">&nbsp;</td>
	<td class="title">&nbsp;</td>
	<td class="title">&nbsp;</td>
</tr>

<july:separator colspan="<%= gColSpan %>" />

<!-- Table body -->
<%
	Position position=null;
	String upd1 = "false";
	String upd2 = "false";
	//request.removeAttribute("browseList");
%>
<alex:hasAccess href="/CardPassWordUploadAction.do" ><% upd1 = "true"; %></alex:hasAccess>
<alex:hasAccess href="/ListPassWordUploadAction.do" ><% upd2 = "true"; %></alex:hasAccess>

<logic:iterate id="pos" name="browseList" type="com.hps.july.cdbc.lib.CDBCRowObject">
<logic:present name="pos">
<%                               
//	position=(Position)pageContext.getAttribute("pos");
//	if(position.isView()){
//		java.lang.String s = ""+position.getStorageplace();
	String storageplace = pos.getColumn("storageplace").asString();
	pageContext.setAttribute("pos_storageplace",storageplace);

	String posstate = pos.getColumn("posstate").asString();
	if(posstate == null) { posstate = "unknown"; }
	else { posstate = posstate.toLowerCase(); }

	Object waymap = pos.getColumn("waymap").asObject();
	String regionid = ((Integer)pos.getColumn("regionid").asObject()).toString();
	if(regionid == null) regionid = "";
	String supregid = ((Integer)pos.getColumn("supregid").asObject()).toString();
	if(supregid == null) supregid = "";
	Object passlist = pos.getColumn("passlist").asObject();
	boolean isEdit = false;
	if("Y".equals(pos.getColumn("sr_editfact").asString())) {
		isEdit = true;
	} else {
		if("Y".equals(pos.getColumn("r_editfact").asString())) {
			isEdit = true;
		}
	}
%>
<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
	<td class="number"><july:stringwrite name="pos" property="gsmid"/></td>
	<td class="number"><july:stringwrite name="pos" property="dampsid"/></td>
	<td class="text">
		<july:link page="/EditPosition.do?action=View" paramId="storageplace" paramName="pos_storageplace" paramScope="page" alttext="msg.viewposition">
			<july:stringwrite name="pos" property="posname"/>
		</july:link>
	</td>
	<td class="text"><july:stringwrite name="pos" property="posaddress"/></td>
	<td class="text"><july:stringwrite name="pos" property="zonecode"/></td>
	<td class="text"><bean:message key='<%="posstate.s."+posstate%>'/></td>
	<td>
		<input type="checkbox" name="checkEquipment" value="<%=storageplace%>" regionid="<%=supregid%>"/>
		<%-- <july:checkbox property="checkEquipment" value="<%=storageplace%>" insertable="true" updatable="true"/> --%>
	</td>
	<td>
		<%if(waymap != null) {%>
			<A HREF="#"  onclick="document.body.style.cursor='wait'; showTerrabyteFile('<%=storageplace%>', 'pos', '10');  document.body.style.cursor='normal'; return true;">
				<IMG SRC="/images/path.gif" border=0 ALT='Карта прохода'>
			</A>
		<%}%>
	</td>
	<td>
		<%if(passlist != null) {%>
			<A HREF="#"  onclick="document.body.style.cursor='wait'; showTerrabyteFile('<%=storageplace%>', 'pos', '9');  document.body.style.cursor='normal'; return true;">
				<IMG SRC="/images/accesslist.gif" border=0 ALT='Список прохода'>
			</A>
		<%}%>
	</td>
	<td class="link">
		<%if(isEdit) {%>
		<july:canedit rolesProperty="addRoles">
			<july:delbutton page="/EditPosition.do?action=Delete" paramId="storageplace" paramName="pos_storageplace" paramScope="page"/>
		</july:canedit>
		<%}%>
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>" />

<%
//}
%>
</logic:present>
</logic:iterate>

<tr class="title">
	<td colspan="<%= gColSpan %>">
	<TABLE class="buttons"><TR class="title">
	<TD class="buttons">
		<july:canedit rolesProperty="addRoles"><july:addbutton page="/AddDelPosition.do?action=Add"/></july:canedit>
		<july:backbutton page="/main.do"/>&nbsp;
		<image name="onMap" src="/images/map.gif" alt="<bean:message key="label.position.show_Onmap"/>" onclick='determineMaps("<%=trailcomMapUrl%>","<%=ruser%>");' />
		<html:hidden property="showOnmap"/>&nbsp;<IMG src="/images/kontr.gif" alt='<bean:message key="label.position.toexcel"/>' onclick="reporttoexcel(); return false;">
	</TD>
	<TD class="navigator"><july:navigator/></TD>
	</TR></TABLE>
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>" />

</table>

<%--html:hidden property="sortorder"/--%>

</july:browseform>

<%
	System.gc();
	tc.finish("jsp");
	System.out.println("MEM.SITEINFO.POSLIST EndMem=" + Runtime.getRuntime().freeMemory());
%>

