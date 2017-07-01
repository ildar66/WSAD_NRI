<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.dictionary.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<july:editform action="ProcessOrgworker.do">

<html:hidden property="worker"/>
<%--html:hidden property="man"/--%>

<table class="main">

<july:separator colspan="3"/>

<tr class="title">
	<td colspan="3"><table border="0" cellpadding="0" cellspacing="0" width="100%"><july:formbuttons/></table></td>
</tr>
    
<july:separator colspan="3"/>	

<tr>
	<td class="title" colspan="2"><july:actionalert/></td>
</tr>
    
<july:separator colspan="3"/>
    
<tr>
	<td class="text" colspan="2"><bean:message key="label.orgworker.organization"/>:</td>
	<td>
		<html:hidden property="organizationcodeFrm"/>
<%--		<july:string size="50" property="organizationname" styleId="organizationname" insertable="false" updatable="false" /> --%>
		<bean:write name="OrgworkerForm" property="organizationname" filter="true"/>
	</td>
</tr>

<july:separator colspan="3"/>
    
<tr>
	<td class="text" colspan="2"><july:reqmark><bean:message key="label.orgworker.lastname"/></july:reqmark>:</td>
	<td>
		<july:string property="lastname" size="30" insertable="true" updatable="true" />
	</td>
</tr>
    
<july:separator colspan="3"/>
    
<tr>
	<td class="text" colspan="2"><july:reqmark><bean:message key="label.orgworker.firstname"/></july:reqmark>:</td>
	<td>
		<july:string property="firstname" size="30" insertable="true" updatable="true" />
	</td>
</tr>
    
<july:separator colspan="3"/>
    
<tr>
	<td class="text" colspan="2"><july:reqmark><bean:message key="label.orgworker.middlename"/></july:reqmark>:</td>
	<td>
		<july:string property="middlename" size="30" insertable="true" updatable="true" />
	</td>
</tr>
    
<july:separator colspan="3"/>
    
<tr>
	<td class="text" width="12%"><july:reqmark><bean:message key="label.orgworker.passport"/></july:reqmark></td>
	<td class="text" width="12%"><bean:message key="label.orgworker.passportser"/>:</td>
	<td width="76%">
		<july:string property="passportser" size="30" insertable="true" updatable="true" />
	</td>
</tr>
    
<july:separator colspan="3"/>
    
<tr>
	<td class="text"></td>
	<td class="text"><bean:message key="label.orgworker.passportdate"/>:</td>
	<td>
		<july:date property="passportdateFrm" insertable="true" updatable="true" required="false"/>
	</td>
</tr>
    
<july:separator colspan="3"/>
    
<tr>
	<td class="text"></td>
	<td class="text"><bean:message key="label.orgworker.passportwhom"/>:</td>
	<td>
		<july:string property="passportwhom" size="30" insertable="true" updatable="true" />
	</td>
</tr>
    
<july:separator colspan="3"/>
    
<tr>
	<td class="text" colspan="2"><july:reqmark><bean:message key="label.orgworker.isactive"/></july:reqmark>:</td>
	<td>
		<july:radio property="active" value="true" insertable="true" updatable="true"/>&nbsp;<bean:message key="label.orgworker.isactive.Y"/><br>
		<july:radio property="active" value="false" insertable="true" updatable="true"/>&nbsp;<bean:message key="label.orgworker.isactive.N"/>
	</td>
</tr>

<%--

<july:separator/>
    
<tr>
	<td class="text"><july:reqmark><bean:message key="label.orgworker.fio"/>:</july:reqmark></td>
	<td>
		<july:string property="mancode" styleId="man" size="5" insertable="true" updatable="true" />
		<july:lookupbutton action="/../security/ShowPeopleLookupList.do" styleId="wkl" fieldNames="man;manname" insertable="true" updatable="true" />
		<july:string size="50" property="manname" styleId="manname" insertable="false" updatable="false" />
	</td>
</tr>
    
<july:separator/>
    
<tr>
	<td class="text"><july:reqmark><bean:message key="label.orgworker.workposition"/>:</july:reqmark></td>
	<td>
		<july:string property="workposition" styleId="wp" size="5" insertable="true" updatable="true" />
		<july:lookupbutton action="/../security/ShowWorkPositionLookupList.do" styleId="wpl" fieldNames="wp;wpname" insertable="true" updatable="true" />
		<july:string size="50" property="workpositionname" styleId="wpname" insertable="false" updatable="false" />
	</td>
</tr>
    
<july:separator/>
    
<tr>
	<td class="text"><bean:message key="label.orgworker.lotusaddress"/>:</td>
	<td>
		<july:string property="lotusaddress" size="50" insertable="true" updatable="true" />
	</td>
</tr>
    
<july:separator/>
    
<tr>
	<td class="text"><bean:message key="label.orgworker.email"/>:</td>
	<td>
		<july:string property="email" size="35" insertable="true" updatable="true" />
	</td>
</tr>
    
<july:separator/>
    
<tr>
	<td class="text"><bean:message key="label.orgworker.phone1"/>:</td>
	<td>
		<july:string property="phone1" size="25" insertable="true" updatable="true" />
	</td>
</tr>
    
<july:separator/>
    
<tr>
	<td class="text"><bean:message key="label.orgworker.phone2"/>:</td>
	<td>
		<july:string property="phone2" size="25" insertable="true" updatable="true" />
	</td>
</tr>
    
<july:separator/>
    
<tr>
	<td class="text"><bean:message key="label.orgworker.localphone"/>:</td>
	<td>
		<july:string property="localphone" size="25" insertable="true" updatable="true" />
	</td>
</tr>
    
<july:separator/>
    
<tr>
	<td class="text"><bean:message key="label.orgworker.fax"/>:</td>
	<td>
		<july:string property="fax" size="25" insertable="true" updatable="true" />
	</td>
</tr>
    
<july:separator/>
    
<tr>
	<td class="text"><bean:message key="label.orgworker.mobilephone"/>:</td>
	<td>
		<july:string property="mobilephone" size="25" insertable="true" updatable="true" />
	</td>
</tr>

<july:separator/>
    
<tr>
	<td class="text"><bean:message key="label.orgworker.isenabled"/>:</td>
	<td>
		<DIV class="edit"><july:radio property="active" insertable="true" updatable="true" value="true"><bean:message key="label.orgworker.enabled"/></july:radio></DIV>
		<DIV class="edit"><july:radio property="active" insertable="true" updatable="true" value="false"><bean:message key="label.orgworker.disabled"/></july:radio></DIV>
	</td>
</tr>
    
<july:separator/>
    
<tr>
	<td class="text"><bean:message key="label.orgworker.company"/>:</td>
	<td>
		<july:string property="companycodeFrm" styleId="cmp" size="5" insertable="true" updatable="true" />
		<july:lookupbutton action="/ShowCompanyLookupList.do" styleId="cmpl" fieldNames="cmp;cmpname" insertable="true" updatable="true" />
		<july:string size="50" property="companyname" styleId="cmpname" insertable="false" updatable="false" />
	</td>
</tr>
    
<july:separator/>
    
    <tr>
        <td class="text"><bean:message key="label.orgworker.division"/>:</td>
        <td>
          <july:string property="divisioncodeFrm" styleId="div" size="5" insertable="true" updatable="true" />
          <july:lookupbutton action="/divisionLookup.do" styleId="divl" fieldNames="div;divname" onclick="set_opt_params_divl('?company='+document.all.cmp.value+'&division='+document.all.div.value)" insertable="true" updatable="true" />
          <july:string size="50" property="divisionname" styleId="divname" insertable="false" updatable="false" />
        </td>
    </tr>
--%>
    
<july:separator colspan="3"/>
    
<tr class="title">
	<td colspan="3"><table border="0" cellpadding="0" cellspacing="0" width="100%"><july:formbuttons/></table></td>
</tr>
    
<july:separator colspan="3"/>
    
</table>

</july:editform>
