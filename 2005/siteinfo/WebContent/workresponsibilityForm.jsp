<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.siteinfo.*" %>
<%@ page import="com.hps.july.jdbcpersistence.lib.ObjectType" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<july:editform action="/ProcessWorkresponsibility.do">

<script language="javascript">
function switchType() {
	if (document.all.type_one.checked) {
		document.all.workercode.className = 'editkod';
		document.all.workercode.disabled = false;
		document.all['lookupimg_wrkl'].src='/images/lookup.gif';
		document.all.organizationcode.className = 'editkoddisabled';
		document.all.organizationcode.disabled = true;
		document.all['lookupimg_orgl'].src='/images/lookup_disabled.gif';
	} else {
		document.all.workercode.className = 'editkoddisabled';
		document.all.workercode.disabled = true;
		document.all['lookupimg_wrkl'].src='/images/lookup_disabled.gif';
		document.all.organizationcode.className = 'editkod';
		document.all.organizationcode.disabled = false;
		document.all['lookupimg_orgl'].src='/images/lookup.gif';
	}
}
</script>

<table class="main">

	<july:formbuttons/>
	
    <july:separator/>
    <tr>
        <td class="title" colspan="2"><july:actionalert/></td>
    </tr>

    <july:separator/>

    <tr>
        <td class="text"><july:reqmark><bean:message key="label.workresponsibility.posname"/>:</july:reqmark></td>
        <td>
          <july:string property="poscode" styleId="poscode" size="5" insertable="false" updatable="false"/>
          <july:lookupbutton action="/ShowPositionLookupList.do" styleId="posl" fieldNames="poscode;posid;posname" insertable="false" updatable="false"/>
          <july:string size="10" property="posid" styleId="posid"  insertable="false" updatable="false"/>
          <july:string size="35" property="posname" styleId="posname"  insertable="false" updatable="false"/>
        </td>
    </tr>
	
    <july:separator/>
	
	<tr>
		<td class="text"><july:reqmark><bean:message key="label.workresponsibility.typeresponsibility"/>:</july:reqmark></td>
		<td>
			<july:select collection="typeresponsibilities" property="typecodeFrm" insertable="true" updatable="false" style="width: 350pt">
				<html:options collection="typeresponsibilities" property="responsibilityType" labelProperty="name"/>
			</july:select>
        </td>
    </tr>
	
    <july:separator/>
	
	<tr>
		<td class="text"><july:reqmark><bean:message key="label.workresponsibility.type"/>:</july:reqmark></td>
		<td>
			<july:radio property="resptype" insertable="true" updatable="true" value="W" onclick="switchType()" styleId="type_one"/><bean:message key="label.workresponsibility.man"/>
			<july:radio property="resptype" insertable="true" updatable="true" value="O" onclick="switchType()"/><bean:message key="label.workresponsibility.org"/>
		</td>
	</tr>
	
	<july:separator/>
	
	<tr>
		<td class="text"><july:reqmark><bean:message key="label.workresponsibility.man"/>:</july:reqmark></td>
		<td>
			<july:string property="workercodeFrm" styleId="workercode" size="5" insertable="true" updatable="false"/>
			<july:lookupbutton action="/ShowWorkerLookupList.do" styleId="wrkl" fieldNames="workercode;workername;workerd" insertable="true" updatable="false"/>
			<july:string size="50" property="workername" styleId="workername" insertable="false" updatable="false"/>
		</td>
	</tr>
	
    <july:separator/>
	
	<tr>
		<td class="text"><bean:message key="label.workresponsibility.division"/>:</td>
		<td><july:string size="50" property="workerd" styleId="workerd" insertable="false" updatable="false"/></td>
	</tr>
	
	<july:separator/>
	
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.workresponsibility.org"/>:</july:reqmark></td>
        <td>
          <july:string property="organizationcodeFrm" styleId="organizationcode" size="5" insertable="true" updatable="false"/>
          <july:lookupbutton action="/ShowOrganizationLookupList.do?selisprovider=true&selissupplier=false&selisrenter=false" styleId="orgl" fieldNames="organizationcode;organizationname" insertable="true" updatable="false"/>
          <july:string size="50" property="organizationname" styleId="organizationname" insertable="false" updatable="false"/>
        </td>
    </tr>
	
	<july:separator/>
	
    <july:formbuttons/>
	
    <july:separator/>

</table>

<logic:notEqual name="WorkresponsibilityForm" property="action" value="Delete">
	<logic:notEqual name="WorkresponsibilityForm" property="action" value="View">
		<script language="javascript">
			switchType();
		</script>
	</logic:notEqual>
</logic:notEqual>

</july:editform>
