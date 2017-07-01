<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld" prefix="alex" %>

<%@ page import="org.apache.struts.util.*" %>
<%@ page import="com.hps.july.basestation.formbean.SwitchForm" %>
<%@ page import="com.hps.july.jdbcpersistence.lib.AppConstants"%>
<%@ page import="com.hps.july.jdbcpersistence.lib.Checks"%>
<%@ page import="com.hps.july.constants.Applications"%>
<%@ page import="com.hps.july.apptags.HasAccessTag"%>
<%@ page import="com.hps.july.web.util.*"%>


<%
	int gColSpan=7;
	request.setAttribute("colspan","2");//для использования во включенных jsp
	SwitchForm dForm=(SwitchForm)pageContext.findAttribute("SwitchForm");
	request.setAttribute("EquipmentPForm",dForm);

	boolean isFromSiteinfo = ParamsParser.getRootApp(pageContext) == Applications.SITEINFO;
	boolean showControllerLink = false;

	String siteDocUrl=AppConstants.BASE_SITEDOC
		+"/ShowSiteDocList.do?appHome="+ParamsParser.getRootApp(pageContext)
		+"&objectId="+dForm.getStorageplace()
		+"&objectType=Switch&canModify="+HasAccessTag.hasAccess(pageContext,"/EditFactSwitch.do")
		+"&searchBy=O";

	if(Checks.SWITCH_TYPE_Gsm.equals(dForm.getSwitchType())) {
		showControllerLink = true;
	}
%>

<july:editform styleId="EquipmentPForm" action="/ProcessSwitch.do">
<table class="main">
<july:separator/>
<july:formbuttons/>
<july:separator/>
<tr>
	<td class="title" colspan="2"><july:actionalert/></td>
</tr>
<july:separator/>

<%--доп. меню--%>
<%if(dForm.getAction().equals("Edit")||dForm.getAction().equals("View")) {%>

<tr>
	<td class="text"><bean:message key="label.position.actions"/>:</td>
	<td class="text" colspan="<%=gColSpan-1%>" >
		<%--экспл. х-ки--%>
		<alex:hasAccess href="/EditViewFactSwitchDesc.do" >
			<july:link page="/EditViewFactSwitchDesc.do?action=View" paramId="equipment" paramName="EquipmentPForm" paramProperty="storageplace" >
			<nobr><bean:message key="menu.switchdesc"/></nobr>
			</july:link>&nbsp;
		</alex:hasAccess>

		<%--оборудование--%>
		<% if(!isFromSiteinfo) { %>
		<alex:hasAccess href="/ShowEquipdetList.do" >
			<july:link href="/siteinfo/ShowEquipdetList.do" paramId="storageplace" paramName="EquipmentPForm" paramProperty="storageplace" >
				<nobr><bean:message key="link.equipment"/></nobr>
			</july:link>&nbsp;
		</alex:hasAccess>
		<% } %>

		<%--документы--%>
		<script>
		<!--
			function showTerrabyteWin() {
				var terrabyteWin = window.open("<%=com.hps.july.util.AppUtils.getNamedValueString("TerrabyteURL")%>?type=equipment&id=<%=dForm.getStorageplace()%>&uid=<%=request.getRemoteUser()%>", "terrabyteWin", "top=60, left=60, height=" + (screen.availHeight-150) + ", width=" + (screen.availWidth-150) + ", fullscreen=no,location=no,menubar=no,resizable=yes,scrollbars=yes,status=no,titlebar=yes,toolbar=no");
				if(terrabyteWin) terrabyteWin.focus();
			}
		-->
		</script>
		<a href="#" onclick="showTerrabyteWin();"><nobr><bean:message key="link.documents"/></nobr></a>

		<%-- july:link href="<%=siteDocUrl%>"  >
			<nobr><bean:message key="link.documents"/></nobr>
		</july:link --%>
		<br>

		<%--список контроллеров--%>
		<% if(showControllerLink) { %>
		<july:link page="/ShowSwitchControllersList.do" paramId="switchId" paramName="EquipmentPForm" paramProperty="storageplace">
			<nobr><bean:message key="menu.switchcontrollers"/></nobr>
		</july:link>&nbsp;
		<% } %>

	</td>
</tr>
<july:separator/>
<% } %>

<%--поля формы--%>
<jsp:include page="/common/positionLookupFields.jsp" flush="true"/>

<july:separator />
 
<jsp:include page="/common/equipmentStateFields.jsp" flush="true" />
<%--номер--%>
<tr>
       <td class="text"><july:reqmark><bean:message key="SwitchForm.number"/>:</july:reqmark></td>
       <td class="text">
         <july:string property="numberFrm" styleId="numberFrmId" size="10" insertable="true" updatable="true" />
       </td>
</tr>
<%--название--%>
<tr>
       <td class="text"><july:reqmark><bean:message key="SwitchForm.name"/>:</july:reqmark></td>
       <td class="text">
        <july:string property="name" styleId="nameId" size="50" insertable="true" updatable="true" />
       </td>
</tr>
<%--MSCID--%>
<tr>
       <td class="text">MSCID:</td>
       <td class="text">
         <july:string property="mscidFrm" styleId="mscidFrmId" size="10" insertable="true" updatable="true" />
       </td>
</tr>
<%--стандарт--%>
<tr>
	<td class="text"><july:reqmark><bean:message key="SwitchForm.switchType"/>:</july:reqmark></td>
	<td class="text">
		<july:select property="switchType" styleId="switchTypeId" insertable='true' updatable='false'>'
			<html:option key="switch_type_1" value="<%=Checks.SWITCH_TYPE_Damps%>"/>
			<html:option key="switch_type_2" value="<%=Checks.SWITCH_TYPE_Gsm%>"/>
		</july:select>
	</td>
</tr>
<%--наименование оборудование--%>
<tr>
	<td class="text"><bean:message key="SwitchForm.resource"/>:</td>
	<td>
		<july:string size="5" property="resourceIdFrm" styleId="resourceId" insertable="true" updatable="true" />
		<july:lookupbutton  formname="SwitchForm" href="/inventory/ShowResourceLookupList.do" styleId="resl" fieldNames="resourceId;resourcemodelId;resourcenameId;resourcefullnameId" newWindowName="resourcelookup" insertable="true" updatable="true"/>
		<july:string size="30" property="resourcefullname" styleId="resourcefullnameId" insertable="false" updatable="false" />
		<input type='hidden' name="resourcemodel" id="resourcemodelId"/>
		<input type='hidden' name="resourcename" id="resourcenameId" />
        </td>
</tr>
<%--
<tr>
	<td class="text"><bean:message key="SwitchForm.qtyshell"/>:</td>
	<td class="text">
		<july:string property="qtyshellFrm" styleId="qtyshellFrmId" size="10" insertable="true" updatable="true" />
	</td>
</tr>
<tr>
	<td class="text"><bean:message key="SwitchForm.maxvlr"/>:</td>
	<td class="text">
		<july:string property="maxvlrFrm" styleId="maxvlrId" size="10" insertable="true" updatable="true" />
		&nbsp;&nbsp;
		<bean:message key="SwitchForm.qtyconhlr"/>:
		<july:string property="qtyconhlrFrm" styleId="qtyconhlrId" size="10" insertable="true" updatable="true" />
	</td>
</tr>
<tr>
	<td colspan='2'>
	<table class="main">
	<tr>
		<td class="text"><bean:message key="SwitchForm.contrl"/>:</td>
		<td class="text">
			<july:string property="contrl" styleId="contrlId" size="10" insertable="false" updatable="false" />
		</td>
		<td class="text"><bean:message key="SwitchForm.qty_tkgroute_nss"/>:</td>
		<td class="text">
			<july:string property="qty_tkgroute_nssFrm" styleId="qty_tkgroute_nssFrmId" size="10" insertable="true" updatable="true" />
		</td>
	</tr>
	<tr>
		<td class="text"><bean:message key="SwitchForm.e1_qty_total"/>:</td>
		<td class="text">
			<july:string property="e1_qty_totalFrm" styleId="e1_qty_totalFrmId" size="10" insertable="true" updatable="true" />
		</td>
		<td class="text"><bean:message key="SwitchForm.e1_use_percent"/>:</td>
		<td class="text">
			<july:string property="e1_use_percentFrm" styleId="e1_use_percentFrmId" size="10" insertable="true" updatable="true" />
		</td>
	</tr>
	<tr>
		<td class="text"><bean:message key="SwitchForm.e1_bss"/>:</td>
		<td class="text">
			<july:string property="e1_bssFrm" styleId="e1_bssFrmId" size="10" insertable="true" updatable="true" />
		</td>
		<td class="text"><bean:message key="SwitchForm.ss7bss"/>:</td>
		<td class="text">
			<july:string property="ss7bssFrm" styleId="ss7bssFrmId" size="10" insertable="true" updatable="true" />
		</td>
	</tr>
	<tr>
		<td class="text"><bean:message key="SwitchForm.e1_nss"/>:</td>
		<td class="text">
			<july:string property="e1_nssFrm" styleId="e1_nssFrmId" size="10" insertable="true" updatable="true" />
		</td>
		<td class="text"><bean:message key="SwitchForm.ss7nss"/>:</td>
		<td class="text">
			<july:string property="ss7nssFrm" styleId="ss7nssFrmId" size="10" insertable="true" updatable="true" />
		</td>
	</tr>
	<tr>
		<td class="text"><bean:message key="SwitchForm.e1_hlr"/>:</td>
		<td class="text">
			<july:string property="e1_hlrFrm" styleId="e1_hlrFrmId" size="10" insertable="true" updatable="true" />
		</td>
		<td class="text"><bean:message key="SwitchForm.ss7_hlrin"/>:</td>
		<td class="text">
			<july:string property="ss7_hlrinFrm" styleId="ss7_hlrinFrmId" size="10" insertable="true" updatable="true" />
		</td>
	</tr>
	</table>
	</td>
</tr>
--%>
<tr>
	<td class="text"><bean:message key="SwitchForm.capacityused"/>:</td>
	<td class="text">
		<july:string property="capacityusedFrm" styleId="capacityused" size="10" insertable="true" updatable="true" />
	</td>
</tr>
<tr>
	<td class="text"><bean:message key="SwitchForm.capacityplan"/>:</td>
	<td class="text">
		<july:string property="capacityplanFrm" styleId="capacityplan" size="10" insertable="true" updatable="true" />
	</td>
</tr>

<jsp:include page="/common/equipmentBaseFields.jsp" flush="true" />

<july:separator/>
<july:formbuttons/>
<july:separator/>
</table>
</july:editform>

