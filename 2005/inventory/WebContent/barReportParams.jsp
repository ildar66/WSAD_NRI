<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>


<july:errors/>

<july:editform action="/ProcessBarParams.do">

<html:hidden property="serid" />

<table class="main">
<tr class="title">
	<td class="title" colspan="2">
		<july:currmark><bean:message key="label.barreportparams"/></july:currmark>
	</td>
</tr>
    
<july:separator />
    
<tr>
	<td class="text"><bean:message key="label.barreport.serie"/></td>
	<td class="text">
		<july:string size="20" property="serie" insertable="false" updatable="false" />
	</td>
</tr>

<july:separator />


<tr>
	<td class="text"><bean:message key="label.barreport.start"/></td>
	<td class="text">
		<july:string size="15" property="startnum" insertable="true" updatable="true" />
	</td>
</tr>

<july:separator />

<tr>
	<td class="text"><bean:message key="label.barreport.count"/></td>
	<td class="text">
		<july:string size="5" property="printcountFrm" insertable="true" updatable="true" />
	</td>
</tr>

<july:separator />

<tr>
	<td class="text"><bean:message key="label.barreport.repeat"/></td>
	<td class="text">
		<july:string size="5" property="repeatcountFrm" insertable="true" updatable="true" />
	</td>
</tr>

<july:separator />

<tr class="title">
	<td class="title" colspan="2">
		<INPUT TYPE="IMAGE" NAME="submit" SRC="/images/refresh.gif" ALT="<bean:message key="label.report.refresh"/>">
	</td>
</tr>
    
<july:separator />

</table>

</july:editform>

