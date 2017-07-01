<%@ page language = "java" import="com.hps.july.arenda.formbean.*"%>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "2"; %>

<july:editform action="/ProcessAbonentState.do" styleId="AbonentStateForm">

<html:hidden property="leaseDocument"/>
<html:hidden property="initialState"/>
<html:hidden property="isMoveError"/>

<table class="main">

<%--
<tr class="title">
		<td class="title" colspan="<%= gColSpan %>">
			<html:link page="/ShowAbonentsList.do" styleClass="navigator"><bean:message key="label.abonents"/></html:link>
			<july:sepmark/>
			<july:currmark><bean:message key="label.abonents.changestate"/></july:currmark>
		</td>
	</tr>
--%>

	<july:separator colspan="<%= gColSpan %>"/>
	    
	<tr>
		<td class="title" colspan="<%= gColSpan %>"><july:actionalert/></td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<td class="text"><bean:message key="label.abonent.state.actions"/>:</td>
		<td>
			<% String tmp = "true"; %>
			<logic:equal name="AbonentStateForm" property="isMoveError" value="true"><% tmp = "false"; %></logic:equal>
			<july:radio styleClass="text" property="contractState" insertable="<%= tmp %>" updatable="<%= tmp %>" value="A" disabled='<%=((AbonentStateForm)request.getAttribute("AbonentStateForm")).isEditDisabled()%>' /> <bean:message key="label.abonent.state0"/><br>
			<july:radio styleClass="text" property="contractState" insertable="<%= tmp %>" updatable="<%= tmp %>" value="B"/><bean:message key="label.abonent.state1"/><br>
			<july:radio styleClass="text" property="contractState" insertable="<%= tmp %>" updatable="<%= tmp %>" value="C" disabled='<%=((AbonentStateForm)request.getAttribute("AbonentStateForm")).isClosedDisabled()%>' /> <bean:message key="label.abonent.state2"/>
		</td>
	</tr>
		
	<july:separator colspan="<%= gColSpan %>"/>
	
	<logic:equal name="AbonentStateForm" property="isMoveError" value="false">	
		<july:formbuttons/>
	</logic:equal>
	
	<logic:equal name="AbonentStateForm" property="isMoveError" value="true">	
		<tr class="title">
			<td class="buttons" colspan="<%= gColSpan %>"><july:backbutton page="/ShowAbonentsList.do"/></td>
		</tr>
	</logic:equal>
	
	<july:separator colspan="<%= gColSpan %>"/>
		
</table>

</july:editform>
