<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld" prefix="alex" %>
<%@ page import="java.util.*"%>
<%@ page import="org.apache.struts.util.*"%>
<%@ page import="com.hps.july.jdbcpersistence.lib.*"%>
<%@ page import="com.hps.july.constants.Applications"%>
<%@ page import="com.hps.july.basestation.formbean.ComlineRForm"%>
<%@ page import="com.hps.july.basestation.valueobject.BaseStationObject"%>

<%
ComlineRForm dForm=(ComlineRForm)request.getAttribute("ComlineRForm");
Enumeration en;
en = dForm.getNesteda();
request.setAttribute("ComlineRForm.NestedA",en);
en = dForm.getNestedb();
request.setAttribute("ComlineRForm.NestedB",en);
String url;
%>

<tr>
	<td class="text" colspan="2">
		<bean:message key="ComlineForm.nestedA"/>: <bean:write name="ComlineRForm" property="posnamea" filter="true"/>
	</td>
</tr>

<tr>
	<td class="text" colspan="2">
	<logic:iterate id="it" name="ComlineRForm.NestedA">
		<logic:present name="it"><logic:present name="it" property="nestedPositionName">
			<july:link page="/EditComlineR.do?action=Edit" paramId="hopsid" paramName="it" paramProperty="hopid">
				[<bean:write name="it" property="hopName" filter="true"/>] <bean:write name="it" property="nestedPositionName" filter="true"/>
			</july:link>
			&nbsp;&nbsp;&nbsp;
		</logic:present></logic:present>
	</logic:iterate>
	</td>
</tr>

<tr>
	<td class="text" colspan="2">
		<bean:message key="ComlineForm.nestedB"/>: <bean:write name="ComlineRForm" property="posnameb" filter="true"/>
	</td>
</tr>

<tr>
	<td class="text" colspan="2">
	<logic:iterate id="it" name="ComlineRForm.NestedB">
		<logic:present name="it"><logic:present name="it" property="nestedPositionName">
			<july:link page="/EditComlineR.do?action=Edit" paramId="hopsid" paramName="it" paramProperty="hopid">
				[<bean:write name="it" property="hopName" filter="true"/>] <bean:write name="it" property="nestedPositionName" filter="true"/>
			</july:link>
			&nbsp;&nbsp;&nbsp;
		</logic:present></logic:present>
	</logic:iterate>
	</td>
</tr>

