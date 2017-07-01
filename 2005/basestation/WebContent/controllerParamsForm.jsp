<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld" prefix="alex" %>
<%@ page import="org.apache.struts.util.*"%>
<%@ page import="com.hps.july.basestation.formbean.ControllerDescForm" %>

<july:editform styleId="ControllerDescParamsForm" action="/ProcessControllerDescParam.do">

<html:hidden property="equipment"/>
<html:hidden property="date.string"/>
<html:hidden property="paramid"/>

<table class="main">
<%-- DD
<tr class="title">
	<td class="title" colspan="2">
		<jsp:include page="/menu/navigator.jsp" flush="true"/>
	</td>
</tr>
--%>

<%--
<tr class="title">
		<td class="title" colspan="2">
			<html:link page="/ShowControllerList.do" styleClass="navigator"><bean:message key="controllerlist.navigator.header"/></html:link>
			<july:sepmark/>
			<html:link page="/EditFactController.do" styleClass="navigator"><bean:message key="menu.controller"/></html:link>
			<july:sepmark/>
			<html:link page="/EditFactControllerDesc.do?action=View" styleClass="navigator"><bean:message key="label.view"/></html:link>
			<july:sepmark/>
			<july:currmark><bean:message key="controller.descparams"/></july:currmark>
		</td>
	</tr>
--%>
	<july:separator/>

	<july:formbuttons/>

	<july:separator/>

	<tr>
	     <td class="title" colspan="2"><july:actionalert/></td>
	</tr>

	<july:separator/>

	<tr>
		<td class="text"><bean:message key="SwitchForm.position"/>:</td>
		<td class="text"><bean:write name="ControllerDescForm" property="positionname" filter="true"/></td>
	</tr>

	<tr>
		<td class="text" style="padding-left:16px;"><bean:message key="label.position.region"/>:</td>
		<td class="text"><bean:write name="ControllerDescForm" property="regionname" filter="true"/></td>
	</tr>

	<tr>
		<td class="text" style="padding-left:16px;"><bean:message key="controllerlist.table.netzone"/>:</td>
		<td class="text"><bean:write name="ControllerDescForm" property="zonename" filter="true"/></td>
	</tr>

	<tr>
		<td class="text" style="padding-left:16px;"><bean:message key="Position.address"/>:</td>
		<td class="text"><bean:write name="ControllerDescForm" property="address" filter="true"/></td>
	</tr>

	<tr>
		<td class="text"><bean:message key="controller.addinfo.controller"/>:</td>
		<td class="text"><bean:write name="ControllerDescForm" property="controllername" filter="true"/></td>
	</tr>

	<july:separator/>

	<tr>
		<td class="text"><bean:message key="label.contdparams.date"/></td>
		<td><bean:write name="ControllerDescParamsForm" property="date.string" filter="true"/></td>
	</tr>

	<tr>
		<td class="text"><bean:message key="label.swdparams.field"/></td>
		<td>
			<logic:equal name="ControllerDescParamsForm" property="paramid" value="1">
				<bean:message key="controller.addinfo.ter"/>
			</logic:equal>
			<logic:equal name="ControllerDescParamsForm" property="paramid" value="2">
				<bean:message key="controller.addinfo.ksot"/>
			</logic:equal>
			<logic:equal name="ControllerDescParamsForm" property="paramid" value="3">
				<bean:message key="controller.addinfo.ksos"/>
			</logic:equal>
		</td>
	</tr>

	<july:separator/>

	<tr>
		<td colspan="2">
			<table border=0 cellpadding=1 cellspacing=1>
				<tr class="title" style="background-color:#D6EBFF;font-size:10pt;">
					<td class="title">¹</td>
					<td class="title"><bean:message key="label.contdparams.level"/></td>
					<td class="title"><bean:message key="label.contdparams.value"/></td>
				</tr>

				<%	for (int i = 0; i < 10; i++) { %>
				<tr>
					<td class="text" style="font-size:10pt;" align="right"><%= i + 1 %></td>
					<td class="text"><july:string size="10" property='<%= "paramLevel[" + i + "].string" %>' insertable="true" updatable="true"/></td>
					<td class="text"><july:string size="10" property='<%= "paramValue[" + i + "].string" %>' insertable="true" updatable="true"/></td>
				</tr>
				<%	} %>

			</table>
		</td>
	</tr>

	<july:separator/>

	<july:formbuttons/>

	<july:separator/>

</table>

</july:editform>
