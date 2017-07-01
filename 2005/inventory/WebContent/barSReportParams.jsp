<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>


<july:editform action="/ProcessBarSParams.do">

<table class="main">
    
<july:separator />
    
<tr>
	<td class="text"><bean:message key="label.barsreport.serial"/></td>
	<td class="text">
		<july:string size="15" property="serial" insertable="true" updatable="true" />
        <july:lookupbutton action="/ShowBarSerialLookupList.do" styleId="serl" fieldNames="serial" insertable="true" updatable="true" />
	</td>
</tr>

<july:separator />

<tr>
	<td class="text"><bean:message key="label.barsreport.repeat"/></td>
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

