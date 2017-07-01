<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld" prefix="alex" %>
<%@ page import="org.apache.struts.util.*,com.hps.july.basestation.formbean.ControllerForm" %>
<%@ page import="com.hps.july.basestation.APPStates" %>
<%@ page import="com.hps.july.basestation.formbean.*" %>
<%@ page import="com.hps.july.web.util.ParamsParser" %>
<%@ page import="com.hps.july.jdbcpersistence.lib.DebugSupport" %>

<%
	request.setAttribute("colspan", "2");	//для использования во включенных jsp
	ControllerDialogForm lForm = (ControllerDialogForm) pageContext.findAttribute("ControllerDialogForm");
	request.setAttribute("EquipmentPForm",lForm);
	String src = "/images/save.gif";
	String alt = "Сохранить Репитера";
%>
<july:errors property="org.apache.struts.action.GLOBAL_ERROR"/>

<logic:equal name="ControllerDialogForm" property="action" value="Delete">
	<script language="javascript">
		<% src = "/images/delconf.gif"; alt = "Удалить Репитера"; %>
	</script>
</logic:equal>

<july:editform action="/ProcessControllerDialog.do" styleId="EquipmentPForm">
<html:hidden property="storageplace"/>
<script language="javascript">
//закрытие окна диалога:
function Close()
	{
		if(window.opener) {
			//alert(window.opener.window.location.href);//temp
			//opener.location.reload(true);
			opener.storeSelectedRow('controllerID', document.all.storageplace.value);
			opener.location.href = opener.location.href;
			window.opener.focus();
		}
		window.close();
	}
</script>

<logic:equal name="ControllerDialogForm" property="flagOperation" value="true">
	<script language="javascript" type="text/javascript">
		 Close();
	</script>
</logic:equal>

<table class="main"> 

<july:separator/>
    <tr class="title">
    	<td class="title" colspan="6">
			<INPUT TYPE="IMAGE" NAME="submit" SRC="<%= src%>"  ALT="<%= alt%>" onclick="document.body.style.cursor='wait';">&nbsp;
			<july:closebutton page="/"/>
        </td>
    </tr>
<july:separator/>

<jsp:include page="/common/positionLookupFields.jsp" flush="true"/>
<july:separator/>
<jsp:include page="/common/equipmentStateFields.jsp" flush="true"/>

<tr>
	<td class="text"><july:reqmark><bean:message key="controller.number"/></july:reqmark> / <july:reqmark><bean:message key="controller.name"/></july:reqmark></td>
	<td class="text"><july:string property="numberFrm" size="10" insertable="true" updatable="true"/> / <july:string property="name" size="25" insertable="true" updatable="true"/></td>
</tr>

<tr>
	<td class="text"><bean:message key="controller.switch"/>:</td>
	<td class="text">
		<html:hidden property="switchId"/>
		<july:string property="switchcodeFrm" styleId="switchcode" size="5" insertable="true" updatable="true"/>
		<july:lookupbutton formname="ControllerDialogForm" action="/ShowSwitchLookupList.do?type=2" styleId="swl" fieldNames="switchcode;switchname" insertable="true" updatable="true"/>
		<july:string size="30" property="switchname" styleId="switchname" insertable="false" updatable="false"/>
	</td>
</tr>

<tr>
	<td class="text"><bean:message key="controller.resource"/>:</td>
	<td class="text">
		<july:string size="5" property="resourcecodeFrm" styleId="crescode" insertable="true" updatable="true"/>
		<july:lookupbutton formname="ControllerDialogForm" href="/inventory/ShowResourceLookupList.do" styleId="cresl" fieldNames="crescode;cresmod;cresname;cresfname" newWindowName="resourcelookup" insertable="true" updatable="true"/>
		<july:string size="30" property="resourcefullname" styleId="cresfname" insertable="false" updatable="false"/>
	</td>
</tr>

<input type='hidden' name="resourcemodel" id="cresmod"/>
<input type='hidden' name="resourcename" id="cresname"/>

<tr>
	<td class="text"><bean:message key="controller.qty_shell"/>:</td>
	<td class="text"><july:string property="qtyshellFrm" size="10" insertable="true" updatable="true"/></td>
</tr>

<tr>
	<td class="text"><bean:message key="controller.mfs_num"/>:</td>
	<td class="text">
		<july:string property="mfs_numFrm" size="10" insertable="true" updatable="true"/>&nbsp;
		<bean:message key="controller.omcr_num"/>:&nbsp;
		<july:string property="omcr_numFrm" size="10" insertable="true" updatable="true"/>
	</td>
</tr>

<tr>
	<td class="text"><bean:message key="controller.con_type"/>:</td>
	<td class="text">
		<july:select style="width: 450;" property="contype" insertable="true" updatable="true">
			<html:option key="controller.con_type.radio" value="R"/>
			<html:option key="controller.con_type.optics" value="O"/>
		</july:select>
	</td>
</tr>

<tr>
	<td class="text"><bean:message key="controller.lac_numbers"/>:</td>
	<td class="text"><july:string property="lac_numbers" size="50" insertable="true" updatable="true"/></td>
</tr>

<tr>
	<td class="text"><bean:message key="controller.trxfr_qty_max"/>:</td>
	<td class="text"><july:string property="trxfr_qty_maxFrm" size="10" insertable="true" updatable="true"/></td>
</tr>

<tr>
	<td class="text"><bean:message key="controller.trx_use_percent"/>:</td>
	<td class="text"><july:string property="trx_use_percentFrm" size="10" insertable="true" updatable="true"/>&nbsp;%</td>
</tr>

<tr>
	<td class="text"><bean:message key="controller.atr_qty_max"/>:</td>
	<td class="text"><july:string property="atr_qty_maxFrm" size="10" insertable="true" updatable="true"/></td>
</tr>

<tr>
	<td class="text"><bean:message key="controller.trxfr_qty"/>:</td>
	<td class="text"><july:string property="trxfr_qtyFrm" size="10" insertable="true" updatable="true"/></td>
</tr>
	
<tr>
	<td class="text"><bean:message key="controller.trxhr_qty"/>:</td>
	<td class="text"><july:string property="trxhr_qtyFrm" size="10" insertable="true" updatable="true"/></td>
</tr>
	
<tr>
	<td class="text"><bean:message key="controller.atr_qty"/>:</td>
	<td class="text"><july:string property="atr_qtyFrm" size="10" insertable="true" updatable="true"/></td>
</tr>
	
<tr>
	<td class="text"><bean:message key="controller.aint_qty"/>:</td>
	<td class="text"><july:string property="aint_qtyFrm" size="10" insertable="true" updatable="true"/></td>
</tr>
	
<tr>
	<td class="text"><bean:message key="controller.hway_qty_voice"/>:</td>
	<td class="text">
		<july:string property="hway_qty_voiceFrm" size="10" insertable="true" updatable="true"/>&nbsp;
		<bean:message key="controller.hway_qty_grps"/>:&nbsp;
		<july:string property="hway_qty_grpsFrm" size="10" insertable="true" updatable="true"/>
	</td>
</tr>
	
<tr>
	<td class="text"><bean:message key="controller.ver_po"/>:</td>
	<td class="text"><july:string property="verpo" size="50" insertable="true" updatable="true"/></td>
</tr>

<jsp:include page="/common/equipmentBaseFields.jsp" flush="true"/>

<july:separator/>
    <tr class="title">
    	<td class="title" colspan="6">
			<INPUT TYPE="IMAGE" NAME="submit" SRC="<%= src%>"  ALT="<%= alt%>" onclick="document.body.style.cursor='wait';">&nbsp;
			<july:closebutton page="/"/>
        </td>
    </tr>
<july:separator/>

</table>
</july:editform>
