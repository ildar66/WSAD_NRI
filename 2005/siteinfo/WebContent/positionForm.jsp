<%@ page language = "java" %>
<%@ page import="com.hps.july.taglib.RolesValidation,com.hps.july.jdbcpersistence.lib.DebugSupport,com.hps.july.siteinfo.*,com.hps.july.siteinfo.formbean.*,com.hps.july.siteinfo.valueobject.*" %>
<%@ page import="com.hps.july.jdbcpersistence.lib.ObjectType" %>
<%@ page import="com.hps.july.jdbcpersistence.lib.AppConstants" %>
<%@ page import="com.hps.july.apptags.HasAccessTag" %>
<%@ page import="com.hps.july.web.util.ParamsParser" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld" prefix="alex" %>

<%
	String gColSpan="2";

	PositionForm pForm=(PositionForm) pageContext.findAttribute("PositionForm");

	String journalUrl="/ShowJournalList.do?objecttype="+ObjectType.Position+"&objectid="+pForm.getStorageplace();
	String onclickStr="openWindow('/siteinfo"+journalUrl+"');return false;";

	String siteDocUrl = AppConstants.BASE_SITEDOC+
		"/ShowSiteDocList.do?appHome="+ParamsParser.getRootApp(pageContext)+ 
		"&objectId="+pForm.getStorageplace()+"&objectType=Position&canModify="+
		HasAccessTag.hasAccess(pageContext,"/EditPosition.do"); 

	String comlinesUrl = AppConstants.BASE_BASESTATION+
		"/ShowComlinePositionList.do?appHome="+ParamsParser.getRootApp(pageContext);
%>
<july:editform action="/ProcessPosition.do" >
<table class="main">
<july:separator/>
<july:formbuttons/>
<july:separator/>
<tr>
	<td class="title" colspan="2"><july:actionalert/></td>
</tr>
<july:separator/>
<%if("View".equals(pForm.getAction())) {%>
<%
	boolean hasRegionAccess=pForm.hasRegionAccess(request);
	String tempIdDoc = "" + pForm.getStorageplace();
%>
<tr>
	<td class="text"><bean:message key="label.position.actions"/>:</td>
	<td>

		<july:canedit rolesProperty="editRoles">
		<%if(hasRegionAccess){%>
			<july:editlink page="/AddDelPosition.do" action="Edit" paramId="storageplace" paramName="PositionForm" paramProperty="storageplace"><bean:message key="label.position.edit"/></july:editlink>
		<%}%>
		</july:canedit>

		<logic:equal name="PositionForm" property="WAYMAPVARIANT" value="1">
			<july:canedit rolesProperty="eposRoles">
			<%if(hasRegionAccess){%>
				<html:link page="/EditEPosition.do?action=Edit" paramId="storageplace" paramName="PositionForm" paramProperty="storageplace" ><bean:message key="label.position.map"/></html:link>
			<%}else{%>
				<html:link page="/EditEPosition.do?action=View" paramId="storageplace" paramName="PositionForm" paramProperty="storageplace" ><bean:message key="label.position.map"/></html:link>
			<%}%>
			</july:canedit>
			<july:cannotedit rolesProperty="eposRoles">
				<html:link page="/EditEPosition.do?action=View" paramId="storageplace" paramName="PositionForm" paramProperty="storageplace" ><bean:message key="label.position.map"/></html:link>
			</july:cannotedit>
			<html:link page="/PrintEPosition.do?action=View" paramId="storageplace" paramName="PositionForm" paramProperty="storageplace" onclick="window.open(this.href, 'pWindow', 'top=100, left=100, width=700, height=500, scrollbars=yes, resizable=yes, menubar=yes'); return false;"><bean:message key="label.position.mapprint"/></html:link>
		</logic:equal>

		<%
			String upd1 = "false";
			String upd2 = "false";
		%>

	  <alex:hasAccess href="/CardPassWordUploadAction.do" ><% upd1 = "true"; %></alex:hasAccess>
	  <alex:hasAccess href="/ListPassWordUploadAction.do" ><% upd2 = "true"; %></alex:hasAccess>
	    <OBJECT ID="dufos" WIDTH=1 HEIGHT=1 CLASSID="CLSID:C216375F-F8D6-4905-84DB-370425BCE6C0"></OBJECT>
			<script>
				<!--
					function showMapInfo() {
						alert('Маршрутная карта либо отсутствует или требуется указать одну из списка.');
					}
					function showListInfo() {
						alert('Список прохода либо отсутствует или требуется указать один из списка.');
					}
					function showTerrabyteWin(s) {
						if(!s) s = "";
						var terrabyteWin = window.open("<%=com.hps.july.util.AppUtils.getNamedValueString("TerrabyteURL")%>?type=pos&id=<%=tempIdDoc%>&uid=<%=request.getRemoteUser()%>" + s, "terrabyteWin", "top=60, left=60, height=" + (screen.availHeight-150) + ", width=" + (screen.availWidth-150) + ", fullscreen=no,location=no,menubar=no,resizable=yes,scrollbars=yes,status=no,titlebar=yes,toolbar=no");
						if(terrabyteWin) terrabyteWin.focus();
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
						
						//var terrabyteWin = window.open("<%=com.hps.july.util.AppUtils.getNamedValueString("TerrabyteURL")%>?type=pos&id=<%=tempIdDoc%>&uid=<%=request.getRemoteUser()%>", "terrabyteWin", "top=60, left=60, height=" + (screen.availHeight-150) + ", width=" + (screen.availWidth-150) + ", fullscreen=no,location=no,menubar=no,resizable=yes,scrollbars=yes,status=no,titlebar=yes,toolbar=no");
						//if(terrabyteWin) terrabyteWin.focus();
					}
				-->
			</script>

		<logic:equal name="PositionForm" property="WAYMAPVARIANT" value="2">
			<july:canedit rolesProperty="eposRoles">
				<%					
					if(hasRegionAccess) {
				%>
				
				<%
					Integer fileId = com.hps.july.web.util.URLUtil.isActiveFileExists("pos", new Integer(10), new Integer(tempIdDoc));
					if(fileId != null) {
				%>
					<a href="#" onclick="showTerrabyteFile('<%=tempIdDoc%>', 'pos', '10');"><bean:message key="label.position.map"/></a>
				<%
					} else {
				%>
					<a href="#" onclick="showMapInfo(); showTerrabyteWin('');"><bean:message key="label.position.map"/></a>
				<%
					}
				%>
<%--			<logic:equal name="PositionForm" property="haveWayMap" value="true">
						<july:wordedit styleId="wrded1" url='<%= "cardView?namedValue=WayMapDocType&position=" + tempIdDoc %>' uploadurl="CardPassWordUploadAction.do" documentid="<%= tempIdDoc %>" updatable="<%= upd1 %>">
							<bean:message key="label.position.map"/>
						</july:wordedit>
				</logic:equal>
				&nbsp;
				<logic:equal name="PositionForm" property="haveWayMap" value="false">
						<july:wordedit styleId="wrded3" 
							url='<%= "printCardPass.do?storageplace=" + tempIdDoc %>'
							uploadurl="CardPassWordUploadAction.do" documentid="<%= tempIdDoc %>"
							updatable="<%= upd1 %>"
							beforeclick='return confirm("Маршрутная карта отсутствует. Создать шаблон маршрутной карты в WORD?");'
							>
							<bean:message key="label.position.map"/>
						</july:wordedit>
				</logic:equal>
--%>

				<%}%>
			</july:canedit>
		</logic:equal>

		<july:canedit rolesProperty="eposRoles">
			<%if(hasRegionAccess){%>

				<%
					Integer fileId = com.hps.july.web.util.URLUtil.isActiveFileExists("pos", new Integer(9), new Integer(tempIdDoc));
					if(fileId != null) {
				%>
					<a href="#" onclick="showTerrabyteFile('<%=tempIdDoc%>', 'pos', '9');"><bean:message key="word.label.list"/></a>
				<%
					} else {
				%>
					<a href="#" onclick="showListInfo(); showTerrabyteWin('');"><bean:message key="word.label.list"/></a>
				<%
					}
				%>

<%--				<july:wordedit styleId="wrded2" 
					url='<%= "cardView?namedValue=PassListDocType&position=" + tempIdDoc %>'
					uploadurl="ListPassWordUploadAction.do" documentid="<%= tempIdDoc %>"
					updatable="<%= upd2 %>">
					<bean:message key="word.label.list"/>
				</july:wordedit>&nbsp;
--%>
			<%}%>
		</july:canedit>

		<html:link page="/ShowWorkresponsibilityList.do" paramId="storageplace" paramName="PositionForm" paramProperty="storageplace"><bean:message key="label.position.responsible"/></html:link>

			<%if("bdv".equals(request.getRemoteUser())) {%>
				<html:link page="/ShowPhotoList.do" paramId="storageplace" paramName="PositionForm" paramProperty="storageplace" onclick="return moveto();">Старые фотографии</html:link>
			<%}%>

			<a href="#" onclick="showTerrabyteWin('&ss=1&dt=1&dv=1');"><bean:message key="label.position.photos"/></a>

		<july:link page="/ShowEquipmentList.do" paramId="storageplace" paramName="PositionForm" paramProperty="storageplace" ><bean:message key="label.position.equipment"/></july:link>

		<html:link href="<%=comlinesUrl%>" paramId="poscode" paramName="PositionForm" paramProperty="storageplace" ><bean:message key="label.position.comlines"/></html:link>

		<july:link page="/ShowBeenetList.do" paramId="storageplace" paramName="PositionForm" paramProperty="storageplace" ><bean:message key="navtitle.ShowBeenetList"/></july:link>


			<%if("bdv".equals(request.getRemoteUser())) {%>
			<html:link  href="<%=siteDocUrl%>"  >
				Старые документы
			</html:link>
			<%}%>
		<%--документы--%>
			<a href="#" onclick="showTerrabyteWin();"><bean:message key="link.documents"/></a>

        <%if(hasRegionAccess){%>
          <%--журнал изменений--%>
          <alex:hasAccess href="/ShowJournalList.do" >
            <html:link onclick="<%=onclickStr%>" page="<%=journalUrl%>" >
               <bean:message key="label.menu.journal"/>
            </html:link>
          </alex:hasAccess>
        <%}%>
		<br>
<%-- на время закоментарено используется другие списки прохода из директорий vad
		<july:canedit rolesProperty="eposRoles">
			<html:link page="/buildListPass.do?showword=0" paramId="storageplace" paramName="PositionForm" paramProperty="storageplace"><bean:message key="word.label.createlistpass"/></html:link>
		</july:canedit>
--%>
			<script>
				<!--
					function showEquipInfoWin() {
						var equipinfoWin = window.open("/siteinfo/ShowOSSEquipment.do?gsmid=<%= pForm.getGsmidFrm() %>&posname=<%= pForm.getName() %>",
              "equipinfoWin", "top=60, left=60, height=" + (screen.availHeight-150) + ", width=" + (screen.availWidth-150) + ", fullscreen=no,location=no,menubar=no,resizable=yes,scrollbars=yes,status=yes,titlebar=yes,toolbar=no");
						if(equipinfoWin) equipinfoWin.focus();
					}
				-->
			</script>
			<a href="#" onclick="showEquipInfoWin();">Данные из системы OSS</a>
    	</td>
    </tr>

    <july:separator/>

<%}%>

<html:hidden property="storageplace"/>

<TR class="title">
	<TD class="title" colspan="2"><bean:message key="label.position.posinfo"/></TD>
</TR>

<% String canEditAll = "false"; %><july:canedit rolesProperty="allRoles"><% canEditAll = "true"; %></july:canedit>
<tr>
	<td class="text">
		<july:reqmark><bean:message key="label.position.regionname"/></july:reqmark> / <july:reqmark><bean:message key="label.position.netzonename"/></july:reqmark>:
	</td>
	<td>
<script language="javascript">
function copyOptions(ssrc,sdest) {
<% if("true".equals(canEditAll)) {%>
	sdest.innerHTML = '';
	for(i = 0; i < ssrc.options.length; i++) {
		var oOpt = document.createElement("OPTION");
		oOpt.value = ssrc.options[i].value;
		oOpt.text = ssrc.options[i].text;
		oOpt.selected = ssrc.options[i].selected;
		sdest.add(oOpt);
	}
<%}%>
}
function updateSCNetzone() {
<% if("true".equals(canEditAll)) {%>
if(document.all.action.value == 'Add' || document.all.action.value == 'Edit') {
	var frm = document.frames("downloadServiceFrameN");
	if(frm.document.all.content) {
		copyOptions(frm.document.all.content,document.all.netzonecode);
	}
}
<%}%>
}
function onRgChange() {
<% if("true".equals(canEditAll)) {%>
if(document.all.action.value == 'Add' || document.all.action.value == 'Edit') {
	var frm = document.frames("downloadServiceFrameN");
	if(!frm.document.forms[0]) {
		frm.document.write('<form name="params" method="POST" action="/siteinfo/regionsDataProviderHTML.jsp">');
		frm.document.write('<input type="text" name="lt" value="N">');
		frm.document.write('<input type="text" name="sr" value="">');
		frm.document.write('<input type="text" name="rg" value="">');
		frm.document.write('<input type="text" name="nz" value="">');
		frm.document.write('</form>');
	}
	frm.document.forms[0].lt.value='N';
	frm.document.forms[0].sr.value='*';
	frm.document.forms[0].rg.value=document.all.regioncode.value;
	frm.document.forms[0].nz.value=document.all.netzonecode.value;
	frm.document.forms[0].submit();
}
<%}%>
}
function initRegionsSelector() {
	if(document.all.action.value == 'Add' || document.all.action.value == 'Edit') {
		onRgChange();
	}
}
</script>
		<iframe id="downloadServiceFrameN" onload="updateSCNetzone();" style="display:none;visibility:hidden;" width=1 height=1></iframe>
		<july:select collection="regions" property="regioncode" onchange="onRgChange();changeRegion();" insertable="<%= canEditAll %>" updatable="<%= canEditAll %>">
			<july:options collection="regions" property="regionid" labelProperty="regname" addProperty="fullarendainfo"/>
		</july:select>
		<july:select collection="netzones" property="netzonecode" insertable="<%= canEditAll %>" updatable="<%= canEditAll %>">
<%=Regions.getOptionsList("N","*",pForm.getRegioncode(),String.valueOf(pForm.getNetzonecode()),request.getRemoteUser(),request.isUserInRole("administrator"))%>
		</july:select>
	</td>
</tr>
<july:separator/>
<%if("Add".equals(pForm.getAction()) || "Edit".equals(pForm.getAction())) {%>
<tr>
	<td class="text">
		<bean:message key="label.position.gsmid"/> / <july:reqmark><bean:message key="label.position.name"/></july:reqmark>:
	</td>
	<td>
		<july:string property="gsmidFrm" size="5" insertable="<%= canEditAll %>" updatable="<%= canEditAll %>" />
		&nbsp;&nbsp;
		<july:string property="name" size="25" insertable="<%= canEditAll %>" updatable="<%= canEditAll %>" />
	</td>
</tr>
<july:separator/>
<tr>
	<td class="text">
		<bean:message key="label.position.dampsid"/> / <bean:message key="label.position.dampsname"/>:
	</td>
	<td>
		<july:string property="dampsidFrm" size="5" insertable="<%= canEditAll %>" updatable="<%= canEditAll %>" />
		&nbsp;&nbsp;
		<july:string property="dampsname" size="25" insertable="<%= canEditAll %>" updatable="<%= canEditAll %>" />
	</td>
</tr>
<%--
<july:separator/>
<tr>
	<td class="text">
		<bean:message key="label.position.beenetid"/>:
	</td>
	<td>
		<july:string property="beenetid" size="10" insertable="<%= canEditAll %>" updatable="<%= canEditAll %>" />
	</td>
</tr>
--%>
<%} else {%>
<tr>
	<td class="text"><bean:message key="label.position.name"/>:</td>
	<td>
		<july:string property="fullName" size="25" insertable="false" updatable="false" />
	</td>
</tr>
<july:separator/>
<tr>
	<td colspan="2">
		<table class="main">
		<tr class="title">
			<td class="title">Контроллеры</td>
			<td class="title">БС GSM</td>
			<td class="title">БС DAMPS</td>
			<td class="title">WLAN</td>
			<td class="title">№ BeeNet</td>
		</tr>
		<tr class="normal">
			<td class="title" valign="top">
<logic:iterate id="lsw" name="PositionForm" property="listControllers" type="com.hps.july.cdbc.lib.CDBCRowObject">
<logic:present name="lsw">
	<july:stringwrite name="lsw" property="number"/><br>
</logic:present>
</logic:iterate>
			</td>
			<td class="title" valign="top">
<logic:iterate id="lbg" name="PositionForm" property="listBsgsm" type="com.hps.july.cdbc.lib.CDBCRowObject">
<logic:present name="lbg">
	<july:stringwrite name="lbg" property="number"/><br>
</logic:present>
</logic:iterate>
			</td>
			<td class="title" valign="top">
<logic:iterate id="lba" name="PositionForm" property="listBsdamps" type="com.hps.july.cdbc.lib.CDBCRowObject">
<logic:present name="lba">
	<july:stringwrite name="lba" property="number"/><br>
</logic:present>
</logic:iterate>
			</td>
			<td class="title" valign="top">
<logic:iterate id="lwl" name="PositionForm" property="listWlan" type="com.hps.july.cdbc.lib.CDBCRowObject">
<logic:present name="lwl">
	<july:stringwrite name="lwl" property="number"/><br>
</logic:present>
</logic:iterate>
			</td>
			<td class="title" valign="top">
<%
	java.util.Iterator it = pForm.getListBeenets();
	while(it.hasNext()) {
		com.hps.july.cdbc.lib.CDBCRowObject bnl = (com.hps.july.cdbc.lib.CDBCRowObject)it.next();
		if(bnl != null) {
			pageContext.setAttribute("bnl_beenetid",bnl.getColumn("beenetid").asString());
			%><july:stringwrite name="bnl_beenetid"/><%
			if(it.hasNext()) {
				%>, <%
			}	
		}
	}
%>
			</td>
		</tr>
		</table>
	</td>
<%}%>
<july:separator/>
<tr>
	<td class="text">
		<july:reqmark><bean:message key="label.position.latitude"/>:</july:reqmark>
	</td>
	<td>
		<july:string property="latitudeFrm" size="10" insertable="<%= canEditAll %>" updatable="<%= canEditAll %>" />
		&nbsp;&nbsp;&nbsp;&nbsp;
		<bean:message key="label.position.longitude"/>:
		&nbsp;
		<july:string property="longitudeFrm" size="10" insertable="<%= canEditAll %>" updatable="<%= canEditAll %>" />
	</td>
</tr>
<july:separator/>
<jsp:include page="/positionFMPartForm.jsp" flush="true"/>
<jsp:include page="/positionFormVC.jsp" flush="true"/>
<july:separator/>
<%
	boolean tRoles=RolesValidation.canModify(pageContext,"eposRoles");
	PositionForm pfrm = ((PositionForm)pageContext.findAttribute("PositionForm"));
	boolean isAdd=pfrm.getAction().equals("Add") | pfrm.getAction().equals("Edit");
	String edit= (tRoles&&isAdd&&!request.isUserInRole("FreqManager"))+"";
%>
<tr>
	<td class="text"><bean:message key="label.position.datebeginbuild"/>:</td>
	<td>
		<july:date property="datebeginbuildFrm" styleId="datebeginbuild" required="false" size="25" insertable='<%=edit%>' updatable='<%=edit%>'/>
		&nbsp;&nbsp;
		<bean:message key="label.position.dateendbuild"/>:
		<july:date property="date_endbuildFrm" styleId="date_endbuild" required="false" size="25" insertable='<%=edit%>' updatable='<%=edit%>'/>
	</td>
</tr>

	<july:separator/>


    <july:canedit rolesProperty="eposRoles">
        <tr>
            <td class="text"><bean:message key="label.position.posstate"/>:</td>
            <td>
              <july:select property="posstate" styleId="posstate" 
					style="width: 150px;"
					onchange="changeState();"
					insertable="true" updatable="true">
				 <html:option value="P"><bean:message key="label.position.posstate.P"/></html:option>
				 <html:option value="E"><bean:message key="label.position.posstate.E"/></html:option>
				 <html:option value="D"><bean:message key="label.position.posstate.D"/></html:option>
			  </july:select>
			  &nbsp;&nbsp;
			  <SPAN ID="cldat">
			  <bean:message key="label.position.dateposclose"/>:
              <july:date property="date_poscloseFrm" styleId="date_posclose" 
				required="false" size="25" insertable='<%=edit%>' updatable='<%=edit%>'/>
			  </SPAN>
            </td>
        </tr>

        <july:separator/>
    </july:canedit>
    <july:cannotedit rolesProperty="eposRoles">
        <tr>
            <td class="text"><bean:message key="label.position.posstate"/>:</td>
            <td>
              <july:select property="posstate" styleId="posstate"
					style="width: 150px;"
					onchange="changeState();"
					insertable="false" updatable="false">
				 <html:option value="P"><bean:message key="label.position.posstate.P"/></html:option>
				 <html:option value="E"><bean:message key="label.position.posstate.E"/></html:option>
				 <html:option value="D"><bean:message key="label.position.posstate.D"/></html:option>
			  </july:select>
			  &nbsp;&nbsp;
			  <SPAN ID="cldat">
			  <bean:message key="label.position.dateposclose"/>:
              <july:date property="date_poscloseFrm" styleId="date_posclose" 
				required="false" size="25" insertable='<%=edit%>' updatable='<%=edit%>'/>
			  </SPAN>
            </td>
        </tr>

        <july:separator/>
    </july:cannotedit>

    <july:canedit rolesProperty="addrRoles">
        <tr>
            <td class="text"><bean:message key="label.position.details"/>:</td>
            <td>
              <july:textarea property="details" cols="50" rows="2" insertable="true" updatable="true" />
            </td>
        </tr>

        <july:separator/>
    </july:canedit>

    <july:cannotedit rolesProperty="addrRoles">
        <tr>
            <td class="text"><bean:message key="label.position.details"/>:</td>
            <td>
              <july:textarea property="details" cols="50" rows="2" insertable="false" updatable="false" />
            </td>
        </tr>

        <july:separator/>
    </july:cannotedit>
<%
	if(request.isUserInRole("FreqManager") || request.isUserInRole("administrator")) {
%>
	<tr>
		<td class="text"><bean:message key="label.position.haveplan"/>:</td>
		<td>
			<july:select property="haveplan" styleId="haveplan" style="width: 250px;" insertable="true" updatable="true">
				<html:option value=""><bean:message key="label.position.haveplan.null"/></html:option>
				<html:option value="A"><bean:message key="label.position.haveplan.A"/></html:option>
				<html:option value="B"><bean:message key="label.position.haveplan.B"/></html:option>
				<html:option value="C"><bean:message key="label.position.haveplan.C"/></html:option>
				<html:option value="D"><bean:message key="label.position.haveplan.D"/></html:option>
			</july:select>
		</td>
	</tr>
<%
	} else if(request.isUserInRole("siteTransport")) {
%>
	<tr>
		<td class="text"><bean:message key="label.position.haveplan"/>:</td>
		<td>
			<july:select property="haveplan" styleId="haveplan" style="width: 250px;" insertable="false" updatable="false">
				<html:option value=""><bean:message key="label.position.haveplan.null"/></html:option>
				<html:option value="A"><bean:message key="label.position.haveplan.A"/></html:option>
				<html:option value="B"><bean:message key="label.position.haveplan.B"/></html:option>
				<html:option value="C"><bean:message key="label.position.haveplan.C"/></html:option>
				<html:option value="D"><bean:message key="label.position.haveplan.D"/></html:option>
			</july:select>
		</td>
	</tr>
<%
	} else {
%>
		<html:hidden property="haveplan"/>
<%
	}
%>


	<%@include file="/positionFormArendaFields.jspf"%>

	<july:formbuttons/> 

<july:separator/>
    
</table>


</july:editform>


<script>

function moveto(){
	window.location.href='ShowPhotoList.do?storageplace=<bean:write name="PositionForm" property="storageplace"/>&javaVer=';//+document.all.ver.getVersion();
	return false;
}

function changeState() {
	if (document.all.posstate.value == "D") {
		document.all.cldat.style.visibility="visible";
	} else {
		document.all.cldat.style.visibility="hidden";
	}
}

function changeRegion() {
  var doccode;
  if (document.all.regioncode.value == undefined) {
    doccode = document.all.regioncode [0].value;
    //alert("1=" + doccode);
  } else {
    doccode = document.all.regioncode.value;
    //alert("2=" + doccode);
  }
  //alert(regions_arr [doccode]);
	if (regions_arr [doccode] == "N") {
		document.all.arenda1.style.display='block';
		document.all.arenda1.style.visibility='visible';
		document.all.arenda2.style.display='block';
		document.all.arenda2.style.visibility='visible';
		document.all.arenda3.style.display='block';
		document.all.arenda3.style.visibility='visible';
		document.all.arenda4.style.display='block';
		document.all.arenda4.style.visibility='visible';
		document.all.arenda5.style.display='block';
		document.all.arenda5.style.visibility='visible';
	} else {
		document.all.arenda1.style.display='none';
		document.all.arenda1.style.visibility='hidden';
		document.all.arenda2.style.display='none';
		document.all.arenda2.style.visibility='hidden';
		document.all.arenda3.style.display='none';
		document.all.arenda3.style.visibility='hidden';
		document.all.arenda4.style.display='none';
		document.all.arenda4.style.visibility='hidden';
		document.all.arenda5.style.display='none';
		document.all.arenda5.style.visibility='hidden';
	}
};

initRegionsSelector();
changeRegion();
changeState();

</script>
<%--
<applet
	code="com/hps/july/siteinfo/applets/JavaVersion.class"
	ARCHIVE="/applets/JavaVersion.jar"
	name="ver"
	width=0
	height=0 >
</applet>
--%>
