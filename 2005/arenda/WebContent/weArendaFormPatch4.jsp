<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.arenda.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% String gColSpan = "2"; %>

<%
	String form = null;
	switch (ParamsParser.getState(pageContext)) {
		case APPStates.WE_ARENDA_EDIT:
			form = "WeArendaForm";
        	break;
		case APPStates.HISTORY_FORM:
			form = "HistoryForm";
        	break;
    }
    String extPeriodStyle = "display: none;";
%>

<script language='javascript'>
function switchExtendTypeNew() {
	//alert(<%= form %>.extendType.value);//temp
	if ((<%= form %>.extendType.value=='N') || (<%= form %>.extendType.value=='M')|| (<%= form %>.extendType.value=='')) {
		//<%= form %>.extendPeriod.disabled = true;
		//<%= form %>.extendPeriod.value ='';
		extPeriod.style.setAttribute("display", "none");
	} else {
		//<%= form %>.extendPeriod.disabled = false;
		extPeriod.style.setAttribute("display", "block");
	}
}
</script>

	<% String isUpdatable = "false"; %>
	<logic:equal name="<%= form %>" property="contractState" value="A">
		<% isUpdatable = "true"; %>
	</logic:equal>
	<logic:equal name="<%= form %>" property="extendType" value="A">
		<% extPeriodStyle = "display: block;"; %>
	</logic:equal>	

	<tr>
		<td class="text"><july:reqmark>Продление:</july:reqmark></td>
		<td class="text">Способ:
				<july:select style="width: 85;" property="extendType" insertable="true" updatable="<%=isUpdatable%>" onchange="switchExtendTypeNew();" styleId="extendType">
					<html:option value=""/>
					<html:option value="N">нет</html:option>
					<html:option value="A">авто</html:option>
					<html:option value="M">доп.согл.</html:option>
				</july:select>
				по:&nbsp;<july:string size="10" property="endDateFrm" insertable="false" updatable="false" styleId="endDate" />
<%--				
	&nbsp;&nbsp;Период:
	<logic:equal name="<%= form %>" property="action" value="View">
	<logic:equal name="<%= form %>" property="extendType" value="A">
				<july:select style="width: 70;" property="extendPeriod" insertable="true" updatable="<%=isUpdatable%>" styleId="extendPeriod">
					<html:option value=""/>
					<html:option key="label.extendperiod.year" value="Y"/>
					<html:option key="label.extendperiod.month" value="M"/>
					<html:option key="label.extendperiod.day" value="D"/>
				</july:select>
	</logic:equal>
	</logic:equal>

	<logic:notEqual name="<%= form %>" property="action" value="View">
				<july:select style="width: 100;" property="extendPeriod" insertable="true" updatable="<%=isUpdatable%>" styleId="extendPeriod">
					<html:option value=""/>
					<html:option key="label.extendperiod.year" value="Y"/>
					<html:option key="label.extendperiod.month" value="M"/>
					<html:option key="label.extendperiod.day" value="D"/>
				</july:select>

	</logic:notEqual>
--%>
<DIV id="extPeriod" style="<%= extPeriodStyle%>">
				 период:&nbsp;
				<july:string size="5" style="width: 30;" property="extendyears" insertable="true" updatable="<%=isUpdatable%>"/>лет&nbsp;
				<july:string size="5" style="width: 30;" property="extendmonthes" insertable="true" updatable="<%=isUpdatable%>"/>мес.&nbsp;
				<july:string size="5" style="width: 30;"property="extenddays" insertable="true" updatable="<%=isUpdatable%>"/>дней&nbsp;
</DIV>				
		</td> 
	</tr>
	
<july:separator colspan="<%= gColSpan %>"/>

	<tr>
		<td class="text"><july:reqmark>Электроэнергия:</july:reqmark></td>
		<td class="text">
			<logic:equal name="<%= form %>" property="action" value="View">
				<logic:equal name="<%= form %>" property="calcElectroType" value="1"><bean:message key="label.calcelectrotype.contract"/></logic:equal>
				<logic:equal name="<%= form %>" property="calcElectroType" value="2"><bean:message key="label.calcelectrotype.arendapay"/></logic:equal>
				<logic:equal name="<%= form %>" property="calcElectroType" value="3"><bean:message key="label.calcelectrotype.accounts"/></logic:equal>
				<logic:equal name="<%= form %>" property="calcElectroType" value="4"><bean:message key="label.calcelectrotype.no"/></logic:equal>
			</logic:equal>
			<logic:notEqual name="<%= form %>" property="action" value="View">
				<july:select style="width: 200;" property="calcElectroType" insertable="true" updatable="<%=isUpdatable%>" styleId="calcElectroType">
					<html:option value=""/>
					<html:option key="label.calcelectrotype.contract" value="1"/>
					<html:option key="label.calcelectrotype.arendapay" value="2"/>
					<html:option key="label.calcelectrotype.accounts" value="3"/>
					<html:option key="label.calcelectrotype.no" value="4"/>
				</july:select>
			</logic:notEqual>
			<july:checkbox property="isDogElectro" insertable="true" updatable="<%=isUpdatable%>" onclick="switchLight();"/>&nbsp;№&nbsp;<july:string  size="5" style="width: 100px" property="dogelectonum" insertable="true" updatable="<%=isUpdatable%>" styleId="elnum"/>&nbsp;Дата:&nbsp;<july:date property="dogelectrodateFrm" size="25" insertable="true" updatable="<%=isUpdatable%>" styleId="eldate"/>
		</td>
	</tr>
<%--
<logic:notEqual name="<%= form %>" property="action" value="View">
	<logic:notEqual name="<%= form %>" property="action" value="Delete">
		<script language='javascript'>
			//switchPhones();
			//switchExtendType();
			switchExtendTypeNew();
		</script>
	</logic:notEqual>
</logic:notEqual>
--%>
