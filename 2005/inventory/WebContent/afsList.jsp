<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "11"; %>

<july:browseform action="/ShowAfsList.do" styleId="AfsListForm">

<script language="javascript">
function switchLookup(itemname,lookupname,disabled) {
	if(disabled) {
		AfsListForm[itemname].className = 'editkoddisabled';
		AfsListForm[itemname].disabled = true;
		AfsListForm[itemname].readonly = true;
		document.all['lookupbtn_'+lookupname+'l'].disabled = true;
		document.all['lookupimg_'+lookupname+'l'].src='/images/lookup_disabled.gif';
	} else {
		AfsListForm[itemname].className = 'editkodsearch';
		AfsListForm[itemname].disabled = false;
		AfsListForm[itemname].readonly = false;
		document.all['lookupbtn_'+lookupname+'l'].disabled = false;
		document.all['lookupimg_'+lookupname+'l'].src='/images/lookup.gif';
	}
}

function switchFilter() {
	if(AfsListForm.type[0].checked) {
		switchLookup('providercode','prov',true);
		switchLookup('workercode','work',true);
		AfsListForm['providername'].disabled = true;
		AfsListForm['workername'].disabled = true;
		AfsListForm['workertitle'].disabled = true;
	} else if(AfsListForm.type[1].checked) {
		switchLookup('providercode','prov',false);
		switchLookup('workercode','work',true);
		AfsListForm['providername'].disabled = false;
		AfsListForm['workername'].disabled = true;
		AfsListForm['workertitle'].disabled = true;
	} else if(AfsListForm.type[2].checked) {
		switchLookup('providercode','prov',true);
		switchLookup('workercode','work',false);
		AfsListForm['providername'].disabled = true;
		AfsListForm['workername'].disabled = false;
		AfsListForm['workertitle'].disabled = false;
	} else {
		switchLookup('providercode','prov',false);
		switchLookup('workercode','work',false);
		AfsListForm['providername'].disabled = false;
		AfsListForm['workername'].disabled = false;
		AfsListForm['workertitle'].disabled = false;
	}
}

function switchOwner() {
	if(AfsListForm.isowner[0].checked) {
		AfsListForm.ownercode.className='editdisabled';
	} else {
		AfsListForm.ownercode.className='editsearch';
	}
	AfsListForm.ownercode.disabled=AfsListForm.isowner[0].checked;
}

function switchPosition() {
	switchLookup('positioncode','pos',AfsListForm.isposition[0].checked);
}

function alertFKBSClosed(){
	alert("Для работы с конфигурацией Функционального Комплекта Базовой Станции GSM, необходимо перейти в режим 'Конфигурация оборудования ФК БС' по следующему пути: Основное меню - Задачи - Учёт оборудования - Прочие операции на позиции - Конфигурация оборудования ФК БС");
}
</script>

<july:selectableTable modelName="list" selectable="1" paramName="selID" styleClass="main" selectedClass="selected">
<%--<tr class="title"><td class="title" colspan="<%= gColSpan %>"><july:currmark><bean:message key="label.afs"/></july:currmark></td></tr>--%>
<july:separator colspan="<%= gColSpan %>" />
<tr class="normal">
<td colspan="<%= gColSpan %>">
	<table class="find">
	<tr>
		<td class="title"><bean:message key="label.afs.owner"/></td>
		<td class="title" colspan="2">
			<july:checkbox property="isowner" insertable="true" updatable="true" value="true" onclick="switchOwner();"/><html:hidden property="isowner" value="false"/><bean:message key="label.all"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	   		<july:select collection="owners" property="ownercode" insertable="true" updatable="true" styleClass="search">
				<html:options collection="owners" property="organization" labelProperty="name"/>
			</july:select><july:searchbutton/>
			<script language="javascript">switchOwner();</script>
		</td>
	</tr>
	<tr>
		<td class="title"><bean:message key="label.afs.position"/></td>
		<td class="title" colspan="2">
			<july:checkbox property="isposition" insertable="true" updatable="true" value="true" onclick="switchPosition();"/><html:hidden property="isposition" value="false"/><bean:message key="label.all"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<july:string property="positioncode" styleId="positioncode" size="5" insertable="true" updatable="true" styleId="editkodsearch"/>
			<july:lookupbutton action="/ShowPositionLookupList.do" styleId="posl" fieldNames="positioncode;positionid;positionname" newWindowName="poslookup" insertable="true" updatable="true" />
			<july:string size="10" property="positionid" styleId="positionid" insertable="false" updatable="false" />
			<july:string size="25" property="positionname" styleId="positionname" insertable="false" updatable="false" />
			<script language="javascript">switchPosition();</script>
		</td>
	</tr>
	<tr>
		<td class="title"><bean:message key="label.afs.date"/></td>
		<td class="title" colspan="2">
			<bean:message key="label.afs.datefrom"/> &nbsp;&nbsp;&nbsp; <july:date property="datefromstr" size="25" insertable="true" updatable="true"/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<bean:message key="label.afs.dateto"/> &nbsp;&nbsp;&nbsp; <july:date property="datetostr" size="25" insertable="true" updatable="true"/>
		</td>
	</tr>
	<tr>
		<td class="title"><bean:message key="label.afs.type"/></td>
		<td class="title" colspan="2">
			<july:radio insertable="true" updatable="true" property="type" value="A" onclick="switchFilter();"/><bean:message key="label.all"/>
			<july:radio insertable="true" updatable="true" property="type" value="P" onclick="switchFilter();"/><bean:message key="label.acttype.forp"/>
			<july:radio insertable="true" updatable="true" property="type" value="W" onclick="switchFilter();"/><bean:message key="label.acttype.forw"/>
		</td>
	</tr>
	<tr>
		<td class="title"><bean:message key="label.afs.provider"/></td>
		<td class="title" colspan="2">
			<july:string property="providercode" styleId="providercode" size="5" insertable="true" updatable="true" styleClass="editkodsearch"/>
			<july:lookupbutton action="/ShowOrganizationLookupList.do" styleId="provl" fieldNames="providercode;providername" newWindowName="organizationlookup"  insertable="true" updatable="true" onclick="set_opt_params_provl('?selisprovider=true&selisrenter=false&selissupplier=false');"/>
			<july:string size="35" property="providername" styleId="providername" insertable="false" updatable="false" />
		</td>
	</tr>
	<tr>
		<td class="title"><bean:message key="label.afs.worker"/></td>
		<td class="title" colspan="2">
			<july:string property="workercode" styleId="workercode" size="5" insertable="true" updatable="true"  styleClass="editkodsearch" />
			<july:lookupbutton action="/ShowWorkerLookupList.do" styleId="workl" fieldNames="workercode;workername;workertitle" newWindowName="workerlookup" insertable="true" updatable="true" />
			<july:string size="25" property="workername" styleId="workername" insertable="false" updatable="false" />
			<july:string size="20" property="workertitle" styleId="workertitle" insertable="false" updatable="false" />
		</td>
	</tr>
	</table>
<script language="javascript">
  switchFilter();
</script>
</td>
</tr>
<july:separator colspan="<%= gColSpan %>" />
<tr class="title"><td colspan="<%= gColSpan %>">
<table class="buttons"><tr class="title"><td class="buttons">
	<logic:equal name="AfsListForm" property="enableclosefkbs" value="false">	
		<july:addbutton image="Add_dcs.gif" page="/EditAfsMountAct3.do?action=Add&indiap=1&newform=true&visualtype=7" alttext="label.afsmountact2.add1800"/>
		<july:addbutton image="Add_gsm.gif" page="/EditAfsMountAct3.do?action=Add&indiap=2&newform=true&visualtype=8" alttext="label.afsmountact2.add900"/>
		<july:addbutton image="Add_dcsgsm.gif" page="/EditAfsMountAct2.do?action=Add&indiap=3&newform=false&visualtype=9" alttext="label.afsmountact2.add"/>
	</logic:equal>
	<logic:equal name="AfsListForm" property="enableclosefkbs" value="true">	
		<july:addbutton image="Add_dcs.gif" href="#" onclick="alertFKBSClosed()" alttext="label.afsmountact2.add1800"/>
		<july:addbutton image="Add_gsm.gif" href="#" onclick="alertFKBSClosed()" alttext="label.afsmountact2.add900"/>
		<july:addbutton image="Add_dcsgsm.gif" href="#" onclick="alertFKBSClosed()" alttext="label.afsmountact2.add"/>
	</logic:equal>
	<july:addbutton image="add_indoor.gif" page="/EditAfsIndoorMountAct.do?action=Add" alttext="label.afsmountact2.addindoor"/>
	<july:addbutton page="/EditAfs.do?action=Add" alttext="label.assact.add"/>
	<july:backbutton page="/main.do"/>
</td><td class="navigator"><july:navigator/></td></tr></table>
</td></tr>
        
<july:separator colspan="<%= gColSpan %>" />

<!-- Table header -->
<tr class="title">
	<july:headercolumn key="label.void" colType="number"/> <%-- Edit button --%>
<july:sortcolumn key="label.internal.date" colType="string" ascFinder="3" descFinder="4"/>
<july:sortcolumn key="label.num" colType="number" ascFinder="1" descFinder="2"/>
	<july:headercolumn key="label.afs.owner" colType="number"/> <%-- Owner --%>
	<td class="title"><bean:message key="label.afs.place"/></td> <%-- Position --%>
	<td class="title"><bean:message key="label.afs.expedition"/></td> <%-- From --%>
	<july:headercolumn key="label.afs.state" colType="string"/> <%-- documentState --%>
	<july:headercolumn key="label.void" colType="string"/> <%-- Delete --%>
</tr>

<july:separator colspan="<%= gColSpan %>" />

<!-- Table body -->
<logic:iterate id="it" name="browseList" type="com.hps.july.cdbc.lib.CDBCRowObject">
<logic:present name="it">
<%
	String docState = it.getColumn("state").asString();
	String document = it.getColumn("document").asString();
	boolean isautodoc = "Y".equals(it.getColumn("isautodoc").asString());
	pageContext.setAttribute("document",document);
	Integer visualType = (Integer)it.getColumn("visualtype").asObject();
%>
<july:selectableTR styleId="<%=document%>" paramName="selID" selectable="true" styleClass="normal"  onmouseover="className='select'" onmouseout="className='normal'">
	<td class="text">
		<% if (com.hps.july.logic.VisualDocTypes.AFS_MOUNT_ACT_1800.equals(visualType) ||
		      com.hps.july.logic.VisualDocTypes.AFS_MOUNT_ACT_900.equals(visualType)
		) { %>
			<%if("1".equals(docState) && !isautodoc) {%>
				<july:editbutton page="/EditAfsMountAct3.do" action="Edit" paramId="document" paramName="document" paramScope="page" alttext="label.assact.edit"/>
			<%} else {%>
				<july:editbutton page="/EditAfsMountAct3.do" action="View" paramId="document" paramName="document" paramScope="page" alttext="label.assact.view"/>
			<%}%>
		<%} else if (com.hps.july.logic.VisualDocTypes.AFS_MOUNT_ACT_1800_900.equals(visualType)) { %>
			<%if("1".equals(docState) && !isautodoc) {%>
				<july:editbutton page="/EditAfsMountAct2.do" action="Edit" paramId="document" paramName="document" paramScope="page" alttext="label.assact.edit"/>
			<%} else {%>
				<july:editbutton page="/EditAfsMountAct2.do" action="View" paramId="document" paramName="document" paramScope="page" alttext="label.assact.view"/>
			<%}%>
		
		<%} else {%>
			<%if("1".equals(docState) && !isautodoc) {%>
				<july:editbutton page="/EditAfs.do" action="Edit" paramId="doc" paramName="document" paramScope="page" alttext="label.assact.edit"/>
			<%} else {%>
				<july:editbutton page="/EditAfs.do" action="View" paramId="doc" paramName="document" paramScope="page" alttext="label.assact.view"/>
			<%}%>
		<%}%>
		<july:anchor />
	</td>
	<td class="text"><july:datewrite name="it" property="docdate"/></td>
	<td class="text"><july:stringwrite name="it" property="docnumber"/></td>
	<td class="text"><july:stringwrite name="it" property="ownername"/></td>
	<td class="text"><july:stringwrite name="it" property="posname"/><br><july:stringwrite name="it" property="equname"/></td>
	<td class="text"><july:stringwrite name="it" property="expeditor"/></td>
	<td class="text"><%if("1".equals(docState)){%><bean:message key="label.state.entering"/><%} else {%><bean:message key="label.state.calculated"/><%}%></td>
<%--
	<td class="link">
		<html:link page="/ShowAfsPositionList.do" paramId="document" paramName="it" paramProperty="so.document" paramScope="page">
			<img src="/images/doc.gif" width=22 height=16 border=0 alt="<bean:message key="label.afs.positions"/>">
		</html:link>
	</td>
--%>
	<td class="link"><%if("1".equals(docState)) {%><july:delbutton page="/EditAfs.do?action=Delete" paramId="doc" paramName="document" paramScope="page"/><%}%></td>
</july:selectableTR>
<july:separator colspan="<%= gColSpan %>" />
</logic:present>
</logic:iterate>

<tr class="title">
<td colspan="<%= gColSpan %>">
	<table class="buttons"><tr class="title">
		<td class="buttons">
			<logic:equal name="AfsListForm" property="enableclosefkbs" value="false">	
				<july:addbutton image="Add_dcs.gif" page="/EditAfsMountAct3.do?action=Add&indiap=1&newform=true&visualtype=7" alttext="label.afsmountact2.add1800"/>
				<july:addbutton image="Add_gsm.gif" page="/EditAfsMountAct3.do?action=Add&indiap=2&newform=true&visualtype=8" alttext="label.afsmountact2.add900"/>
				<july:addbutton image="Add_dcsgsm.gif" page="/EditAfsMountAct2.do?action=Add&indiap=3&newform=false&visualtype=9" alttext="label.afsmountact2.add"/>
			</logic:equal>
			<logic:equal name="AfsListForm" property="enableclosefkbs" value="true">	
				<july:addbutton image="Add_dcs.gif" href="#" onclick="alertFKBSClosed()" alttext="label.afsmountact2.add1800"/>
				<july:addbutton image="Add_gsm.gif" href="#" onclick="alertFKBSClosed()" alttext="label.afsmountact2.add900"/>
				<july:addbutton image="Add_dcsgsm.gif" href="#" onclick="alertFKBSClosed()" alttext="label.afsmountact2.add"/>
			</logic:equal>
			<july:addbutton image="add_indoor.gif" page="/EditAfsIndoorMountAct.do?action=Add" alttext="label.afsmountact2.addindoor"/>
			<july:addbutton page="/EditAfs.do?action=Add" alttext="label.assact.add"/>
			<july:backbutton page="/main.do"/>
		</td>
		<td class="navigator"><july:navigator/></td>
	</tr></table>
</td>
</tr>
<july:separator colspan="<%= gColSpan %>" />
<%--<tr class="title"><td class="title" colspan="<%= gColSpan %>"><july:currmark><bean:message key="label.afs"/></july:currmark></td></tr>--%>
</july:selectableTable>
</july:browseform>
