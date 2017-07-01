<%@ page language = "java" %>

<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.dictionary.*" %>

<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<july:editform action="/ProcessRRLSpeedParams.do">

<script language="javascript">
function rwplOnSelect() {
	document.all['resourcesubtypeFrm'].value = '';
	document.all['resourcesubtypename'].value = '';
}

</script>


<html:hidden property="complect"/>

<% 
   com.hps.july.dictionary.formbean.RRLSpeedParamForm form =
          (com.hps.july.dictionary.formbean.RRLSpeedParamForm)pageContext.findAttribute("RRLSpeedParamForm");
%>

<html:hidden property="resourceFrm" value="<%= Integer.toString(form.getResource()) %>"/>
<html:hidden property="rrlspeedid"/>
	
<table class="main">

<july:separator/>

<july:formbuttons/>

<july:separator/>

<tr>
	<td class="title" colspan="2"><july:actionalert/></td>
</tr>

<july:separator/>

<tr>
	<td class="text"><july:reqmark><bean:message key="label.rrlresource.speedparams.streamspeed"/></july:reqmark>:</td>
	<td>
		<july:select property="streamspeed" insertable="true" updatable="true">
			<html:option key="label.rrlparams.speed.void" value=""/>
			<html:option key="label.rrlparams.speed.1X2" value="1X2"/>
			<html:option key="label.rrlparams.speed.2X2" value="2X2"/>
			<html:option key="label.rrlparams.speed.4X2" value="4X2"/>
			<html:option key="label.rrlparams.speed.8X2" value="8X2"/>
			<html:option key="label.rrlparams.speed.16X2" value="16X2"/>
			<html:option key="label.rrlparams.speed.16X22" value="16X2+2"/>
			<html:option key="label.rrlparams.speed.155" value="155"/>
		</july:select>
	</td>
</tr>
    
<july:separator/>
    
<tr>
	<td class="text"><july:reqmark><bean:message key="label.rrlresource.speedparams.radiationclass"/></july:reqmark>:</td>
	<td>
		<july:string size="35" property="radiationclass" insertable="true" updatable="true" />
	</td>
</tr>
    
<july:separator/>

<tr>
	<td class="text"><july:reqmark><bean:message key="label.rrlresource.speedparams.recvsensitivity"/></july:reqmark>:</td>
	<td>
		<july:string size="35" property="recvsensitivityFrm" insertable="true" updatable="true" />
	</td>
</tr>

<july:separator/>

<july:formbuttons/>

<july:separator/>

</table>

</july:editform>


