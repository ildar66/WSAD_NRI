<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.siteinfo.*" %>
<%@ page import="com.hps.july.persistence.BaseStation" %>
<%@ page import="com.hps.july.siteinfo.valueobject.EquipmentObject" %>
<%@ page import="com.hps.july.siteinfo.valueobject.Position" %>
<%@ page import="com.hps.july.jdbcpersistence.lib.*" %>
<%@ page import="com.hps.july.constants.Applications" %>
<%@ page import="com.hps.july.siteinfo.formbean.PositionForm" %>
<%@ page import="com.hps.july.siteinfo.formbean.EquipmentForm" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<%
	String gColSpan="2";
	String action = null;
	EquipmentForm eForm=(EquipmentForm)pageContext.findAttribute("EquipmentForm");
	if("N".equals(eForm.getComplectType())) {
		action = "/EditEquipment.do";
	} else {
		action = "/ProcessEquipment.do";
	}
	StringBuffer siteDocUrl= new StringBuffer(AppConstants.BASE_SITEDOC+"/ShowSiteDocList.do?appHome="
		+ParamsParser.getRootApp(pageContext)
		+"&objectId="+eForm.getStorageplace()+"&objectType="+eForm.getType()+"&searchBy=O");
%>

<july:editform action="<%= action %>" styleId="equipForm">

<table class="main">

<july:separator/>

<tr>
	<td class="title" colspan="2"><july:actionalert/></td>
</tr>

<july:separator/>

<% if("Edit".equals(eForm.getAction()) || "View".equals(eForm.getAction())) {%>
<tr>
	<td class="text"><bean:message key="label.position.actions"/>:</td>
	<td>
		<script>
		<!--
			function showTerrabyteWin() {
				var terrabyteWin = window.open("<%=com.hps.july.util.AppUtils.getNamedValueString("TerrabyteURL")%>?type=equipment&id=<%=eForm.getStorageplace()%>&uid=<%=request.getRemoteUser()%>", "terrabyteWin", "top=60, left=60, height=" + (screen.availHeight-150) + ", width=" + (screen.availWidth-150) + ", fullscreen=no,location=no,menubar=no,resizable=yes,scrollbars=yes,status=no,titlebar=yes,toolbar=no");
				if(terrabyteWin) terrabyteWin.focus();
			}
		-->
		</script>
		<a href="#" onclick="showTerrabyteWin();"><bean:message key="link.documents"/></a>
		&nbsp;&nbsp;&nbsp;
		<july:link href='<%="ShowEquipdetList.do?storageplace="+eForm.getStorageplace()%>'><bean:message key="label.equipment"/></july:link>
	</td>
</tr>
<july:separator />
<%}%>

<logic:equal name="EquipmentForm" property="complectType" value="N">

<tr>
	<td class="text"><july:reqmark><bean:message key="label.equipment.posname"/>:</july:reqmark></td>
	<td>
		<july:string property="poscode" styleId="poscode" size="5" insertable="false" updatable="false" />
		<july:lookupbutton action="/ShowPositionLookupList.do" styleId="posl" fieldNames="poscode;posid;posname" insertable="false" updatable="false" />
		<july:string size="10" property="posid" styleId="posid"  insertable="false" updatable="false" />
		<july:string size="25" property="posname" styleId="posname"  insertable="false" updatable="false" />
	</td>
</tr>

<july:separator/>

<tr>
	<td class="text"><july:reqmark><bean:message key="label.equipment.complect"/>:</july:reqmark></td>
	<td>
		<july:canedit rolesProperty="bsRoles">
			<july:radio styleClass="text" property="complectType" insertable="true" updatable="false" value="A" /><bean:message key="label.equipment.type.basestation"/><br>
			<july:radio styleClass="text" property="complectType" insertable="true" updatable="false" value="C" /><bean:message key="label.equipment.type.controller"/><br>
			<july:radio styleClass="text" property="complectType" insertable="true" updatable="false" value="D" /><bean:message key="label.equipment.type.switch"/><br>
			<july:radio styleClass="text" property="complectType" insertable="true" updatable="false" value="R" /><bean:message key="label.equipment.type.repeater"/><br>
			<july:radio styleClass="text" property="complectType" insertable="true" updatable="false" value="F" /><bean:message key="label.equipment.type.wlan"/><br>
		</july:canedit>
		<july:canedit rolesProperty="comRoles">
			<july:radio styleClass="text" property="complectType" insertable="true" updatable="false" value="B" /><bean:message key="label.equipment.type.comequipment"/><br>
		</july:canedit>
		<july:canedit rolesProperty="otherRoles">
			<july:radio styleClass="text" property="complectType" insertable="true" updatable="false" value="E" /><bean:message key="label.equipment.type.other"/>
		</july:canedit>
	</td>
</tr>

<july:separator/>

</logic:equal>

<logic:notEqual name="EquipmentForm" property="complectType" value="N">

<html:hidden property="complectType" />
<html:hidden property="storageplace" />

<tr>
	<td class="text"><july:reqmark><bean:message key="label.equipment.posname"/>:</july:reqmark></td>
	<td>
		<july:string property="poscode" styleId="poscode" size="5" insertable="false" updatable="false" />
		<july:lookupbutton action="/ShowPositionLookupList.do" styleId="posl" fieldNames="poscode;posid;posname" insertable="false" updatable="false" />
		<july:string size="10" property="posid" styleId="posid"  insertable="false" updatable="false" />
		<july:string size="50" property="posname" styleId="posname"  insertable="false" updatable="false" />
	</td>
</tr>

<july:separator/>

<logic:equal name="EquipmentForm" property="complectType" value="B">
<script language="javascript">
function checkOsinv() {
	if(document.all.comEquipmentType[1].checked) {
		document.all.osinvname.disabled = false;
		document.all.osinvname.className = 'editbigest';
	} else {
		document.all.osinvname.disabled = true;
		document.all.osinvname.className = 'editbigestdisabled';
	}
}	
</script>

<tr>
	<td class="text"><july:reqmark><bean:message key="label.equipment.comequipmenttype"/>:</july:reqmark></td>
	<td>
		<july:radio styleClass="text" property="comEquipmentType" insertable="true" updatable="true" value="R" onclick="checkOsinv();"/><bean:message key="label.equipment.comequipmenttype.radio"/>
		<july:radio styleClass="text" property="comEquipmentType" insertable="true" updatable="true" value="O" onclick="checkOsinv();"/><bean:message key="label.equipment.comequipmenttype.optic"/>
		<july:radio styleClass="text" property="comEquipmentType" insertable="true" updatable="true" value="A" onclick="checkOsinv();"/><bean:message key="label.equipment.comequipmenttype.other"/>
	</td>
</tr>

<july:separator />

<tr>
	<td class="text"><july:reqmark><bean:message key="label.equipment.name"/>:</july:reqmark></td>
	<td>
		<july:string property="name" size="50" insertable="true" updatable="true" />
	</td>
</tr>

<july:separator />

<tr>
	<td class="text"><bean:message key="controller.resource"/>:</td>
	<td class="text">
		<july:string size="5" property="resourcecodeFrm" styleId="rescode" insertable="true" updatable="true"/>
		<july:lookupbutton href="/inventory/ShowResourceLookupList.do" styleId="resl" fieldNames="rescode;resmod;resname;resfname" newWindowName="resourcelookup" insertable="true" updatable="true"/>
		<july:string size="30" property="resourcefullname" styleId="resfname" insertable="false" updatable="false"/>
		<input type="hidden" name="resourcemodel" id="resmod">
		<input type="hidden" name="resourcename" id="resname">
	</td>
</tr>

<july:separator />

<tr>
	<td class="text"><bean:message key="label.equipment.osinvname"/>:</td>
	<td>
		<july:string property="osinvname" size="50" insertable="true" updatable="true" />
	</td>
</tr>

<july:separator/>

<script language="javascript">
function changeBeenets() {
	try {
		var selbeen = document.all.beenet.value;
		var r = beenets_arr[selbeen];
		if(r == null || r == undefined) {
			r = '';
		}
		document.all.beenetcategory.value = r;
	} catch(e) {
		document.all.beenetcategory.value = '';
	}
}
function changeBNA() {
<%if("Add".equals(eForm.getAction()) || "Edit".equals(eForm.getAction())) {%>
	if(document.all.beenet_action[0].checked) {
		document.all.beenet.disabled = false;
		document.all.beenet.className = 'edit';
		document.all.beenet_new.disabled = true;
		document.all.beenet_new.className = 'editdisabled';
		document.all.beenet_new_categidFrm.disabled = true;
		document.all.beenet_new_categidFrm.className = 'editdisabled';
	}
	if(document.all.beenet_action[1].checked) {
		document.all.beenet.disabled = true;
		document.all.beenet.className = 'editdisabled';
		document.all.beenet_new.disabled = false;
		document.all.beenet_new.className = 'edit';
		document.all.beenet_new_categidFrm.disabled = false;
		document.all.beenet_new_categidFrm.className = 'edit';
	}
<%}%>
}
</script>

<tr>
	<td class="text">№ Beenet:</td>
	<td>
		<july:radio property="beenet_action" insertable="true" updatable="true" value="S" styleClass="text" onclick="changeBNA();"/>Выбрать&nbsp; 
		<july:select collection="beenets" property="beenet" insertable="true" updatable="true" onchange="changeBeenets();">
			<html:option value="">&lt;Не указано&gt;</html:option>
			<july:options collection="beenets" property="beenetid" labelProperty="beenetid" addProperty="categname"/>
		</july:select>
		<input type="text" size="25" name="beenetcategory" value="" class="editdisabled" title="">
	</td>
</tr>
<tr>
	<td class="text">&nbsp;</td>
	<td>
		<july:radio property="beenet_action" insertable="true" updatable="true" value="C" styleClass="text" onclick="changeBNA();"/>Создать&nbsp;
		<july:string property="beenet_new" size="20" insertable="true" updatable="true" />
   		<july:select collection="beenetCategories" property="beenet_new_categidFrm" insertable="true" updatable="true">
			<html:option value="">&lt;Не указано&gt;</html:option>
			<july:options collection="beenetCategories" property="categid" labelProperty="categname"/>
		</july:select>
	</td>
</tr>

<july:separator/>

<script language="javascript">
	changeBeenets();
	changeBNA()
	checkOsinv();
</script>

</logic:equal>

<logic:equal name="EquipmentForm" property="complectType" value="C">

<tr>
	<td class="text"><july:reqmark><bean:message key="label.controller.number"/>:</july:reqmark></td>
	<td>
		<july:string property="numberFrm" size="10" insertable="true" updatable="true" />
	</td>
</tr>

<july:separator/>

<tr>
	<td class="text"><july:reqmark><bean:message key="label.controller.name"/>:</july:reqmark></td>
	<td>
		<july:string property="controllerName" size="50" insertable="true" updatable="true" />
	</td>
</tr>

<july:separator/>

<tr>
	<td class="text"><bean:message key="label.equipment.switch"/>:</td>
	<td>
		<july:string property="switchNumberFrm" styleId="switchnum" size="5" insertable="true" updatable="true" />
		<july:lookupbutton action="/ShowSwitchLookupList.do" styleId="switchl" fieldNames="switchnum;sposname" insertable="true" updatable="true" />
		<july:string size="25" property="switchposname" styleId="sposname"  insertable="false" updatable="false" />
	</td>
</tr>

<july:separator/>

</logic:equal>

<logic:equal name="EquipmentForm" property="complectType" value="D">

<tr>
	<td class="text"><july:reqmark><bean:message key="label.equipment.switchtype"/>:</july:reqmark></td>
	<td>
		<july:radio styleClass="text" property="switchType" insertable="true" updatable="true" value="1"/><bean:message key="label.equipment.switchdamps"/>
		<july:radio styleClass="text" property="switchType" insertable="true" updatable="true" value="2"/><bean:message key="label.equipment.switchgsm"/>
	</td>
</tr>

<july:separator/>

<tr>
	<td class="text"><july:reqmark><bean:message key="label.equipment.number"/>:</july:reqmark></td>
	<td>
		<july:string property="numberFrm" size="10" insertable="true" updatable="true" />
	</td>
</tr>

<july:separator/>

<tr>
	<td class="text"><july:reqmark><bean:message key="label.equipment.name"/>:</july:reqmark></td>
	<td>
		<july:string property="name" size="50" insertable="true" updatable="true" />
	</td>
</tr>

<july:separator />

</logic:equal>

<logic:equal name="EquipmentForm" property="complectType" value="E">
<tr>
	<td class="text"><july:reqmark><bean:message key="label.equipment.othertype"/>:</july:reqmark></td>
	<td>
		<july:radio styleClass="text" property="otherEquipmentType" insertable="true" updatable="true" value="B"/><bean:message key="label.equipment.othertypeb"/><br>
		<july:radio styleClass="text" property="otherEquipmentType" insertable="true" updatable="true" value="E"/><bean:message key="label.equipment.othertypee"/><br>
		<july:radio styleClass="text" property="otherEquipmentType" insertable="true" updatable="true" value="C"/><bean:message key="label.equipment.othertypec"/><br>
		<july:radio styleClass="text" property="otherEquipmentType" insertable="true" updatable="true" value="D"/><bean:message key="label.equipment.othertyped"/>
	</td>
</tr>

<july:separator/>

</logic:equal>

<logic:equal name="EquipmentForm" property="complectType" value="F">

<tr>
	<td class="text"><july:reqmark><bean:message key="label.equipment.number"/>:</july:reqmark></td>
	<td>
		<july:string property="numberFrm" size="10" insertable="true" updatable="true" />
	</td>
</tr>

<july:separator/>

<tr>
	<td class="text"><july:reqmark><bean:message key="label.equipment.name"/>:</july:reqmark></td>
	<td>
		<july:string property="name" size="50" insertable="true" updatable="true" />
	</td>
</tr>

<july:separator />

</logic:equal>


<tr>
	<td class="text"><july:reqmark><bean:message key="label.equipment.state"/>:</july:reqmark></td>
	<td>
		<july:radio styleClass="text" property="equipmentState" insertable="true" updatable="true" value="P"/><bean:message key="label.equipment.statep"/><br>
		<july:radio styleClass="text" property="equipmentState" insertable="true" updatable="true" value="M"/><bean:message key="label.equipment.statem"/><br>
		<july:radio styleClass="text" property="equipmentState" insertable="true" updatable="true" value="R"/><bean:message key="label.equipment.stater"/><br>
		<july:radio styleClass="text" property="equipmentState" insertable="true" updatable="true" value="T"/><bean:message key="label.equipment.statet"/><br>
		<july:radio styleClass="text" property="equipmentState" insertable="true" updatable="true" value="W"/><bean:message key="label.equipment.statew"/><br>
		<july:radio styleClass="text" property="equipmentState" insertable="true" updatable="true" value="D"/><bean:message key="label.equipment.stated"/>
	</td>
</tr>

<july:separator/>

<tr>
	<td class="text"><bean:message key="label.comment"/>:</td>
	<td>
		<july:textarea property="equipcomment" cols="50" rows="2" insertable='true' updatable='true' />
	</td>
</tr>

<%if("View".equals(eForm.getAction()) || "Edit".equals(eForm.getAction())) {%>
<july:separator/>

<tr>
	<td colspan="2">
<table class="main" id="brtable">
	<tr class="title">
		<td class="title" colspan="7">
			<bean:message key="label.equipmentform.comlines"/>
		</td>
	</tr>
	<tr class="title">
		<july:headercolumn key="label.equipmentform.comcode" colType="string"/>
		<july:headercolumn key="label.equipmentform.beenet" colType="string"/>
		<july:headercolumn key="label.equipmentform.otvpos" colType="string"/>
		<july:headercolumn key="label.equipmentform.otvequ" colType="string"/>
		<july:headercolumn key="label.comline.state" colType="string"/>
	</tr>
<logic:iterate id="it" name="EquipmentForm" property="comlines" type="com.hps.july.cdbc.lib.CDBCRowObject">
<logic:present name="it">
<%
	String hs = "label.comline.state." + it.getColumn("hopstate").asString();
%>
	<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
		<td class="text"><july:stringwrite name="it" property="hopsname"/></td>
		<td class="text"><july:stringwrite name="it" property="beenetid"/></td>
		<td class="text"><july:stringwrite name="it" property="otvposid"/> <july:stringwrite name="it" property="otvposname"/></td>
		<td class="text"><july:stringwrite name="it" property="otvresource"/></td>
		<td class="text"><bean:message key="<%=hs%>"/></td>
	</tr>
</logic:present>
</logic:iterate>
</table>
	</td>
</tr>
<%}%>

</logic:notEqual>
<july:formbuttons/>
<july:separator/>
</table>

</july:editform>
