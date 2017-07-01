<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/bsapptags.tld"    prefix="jbs" %>
<%@ page import="org.apache.struts.util.*"%>
<tr>
<%-- датa --%>
	<td class="text"><bean:message key="label.swdparams.date"/></td>
	<td>
		<bean:write name="SwitchDescParamsForm" property="date.string" filter="true"/>
	</td>
</tr>

<tr>
<%-- поле --%>
	<td class="text"><bean:message key="label.swdparams.field"/></td>
	<td>
		<logic:equal name="SwitchDescParamsForm" property="paramid" value="1">
			<bean:message key="label.swd.bsscerl"/>
		</logic:equal>
		<logic:equal name="SwitchDescParamsForm" property="paramid" value="2">
			<bean:message key="label.swd.nsscerl"/>
		</logic:equal>
		<logic:equal name="SwitchDescParamsForm" property="paramid" value="3">
			<bean:message key="label.swd.aint_overload"/>
		</logic:equal>
		<logic:equal name="SwitchDescParamsForm" property="paramid" value="4">
			<bean:message key="label.swd.tkg_overload"/>
		</logic:equal>
		<logic:equal name="SwitchDescParamsForm" property="paramid" value="5">
			<bean:message key="label.swd.tkgcsr_overload"/>
		</logic:equal>
		<logic:equal name="SwitchDescParamsForm" property="paramid" value="6">
			<bean:message key="label.swd.ss7_load"/>
		</logic:equal>
	</td>
</tr>

<july:separator/>

<%-- Список полей --%>
<tr>
<td colspan="2">
	<table border=0 cellpadding=1 cellspacing=1>
	<tr class="title" style="background-color:#D6EBFF;font-size:10pt;">
		<td class="title">№</td>
		<td class="title"><bean:message key="label.swdparams.level"/></td>
		<td class="title"><bean:message key="label.swdparams.value"/></td>
	</tr>
<%
for(int i = 0; i < 10; i++) {
%>
	<tr>
		<td class="text" style="font-size:10pt;" align="right"><%=(i+1)%></td>
		<td class="text"><july:string size="10" property='<%="paramLevel["+i+"].string"%>' insertable="true" updatable="true"/></td>
		<td class="text"><july:string size="10" property='<%="paramValue["+i+"].string"%>' insertable="true" updatable="true" /></td>
	</tr>
<%
}
%>
	</table>
</td>
</tr>
