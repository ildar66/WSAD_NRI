<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.arenda.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "2"; %>

<%
    String action = null;
	String form = null;
	String parent = null;
	String caption = null;
	switch (ParamsParser.getState(pageContext)) {
		case APPStates.STATE_WEARENDA_EDIT:
        	action = "/ProcessWeState.do";
			form = "WeStateForm";
			parent = "/ShowWeArendaList.do";
			caption = "label.we";
        	break;
		case APPStates.STATE_USARENDA_EDIT:
        	action = "/ProcessUsState.do";
			form = "UsStateForm";
			parent = "/ShowUsArendaList.do";
			caption = "label.us";
        	break;
		case APPStates.STATE_CHANNELARENDA_EDIT:
        	action = "/ProcessChannelState.do";
			form = "ChannelStateForm";
			parent = "/ShowChannelArendaList.do";
			caption = "label.channel";
        	break;
		case APPStates.HISTORY_STATE_WEARENDA_EDIT:
        	action = "/ProcessHistoryWeState.do";
			form = "HistoryWeStateForm";
			parent = "/ShowWeArendaList.do";
			caption = "label.we";
        	break;
    }
%>

<july:editform action="<%= action %>" styleId="<%= form %>">

<html:hidden property="leaseDocument"/>
<html:hidden property="initialState"/>
<html:hidden property="summ2Frm"/>
<html:hidden property="curr1"/>
<html:hidden property="curr2"/>

<script language="javascript">
function switchState() {
	//alert("document.all.contractState_C.checked=" + document.all.contractState_C.checked);
	if(<%= form %>.dateclose_dt != null) {
		if (document.all.contractState_C.checked == true || document.all.contractState_D.checked == true) {
			//<%= form %>.dateclose_dt.enabled = true;
			<%= form %>.cb_dateclose.disabled = false;
		} else {
			<%= form %>.dateclose_dt.enabled = false;
			<%= form %>.cb_dateclose.disabled = true;
		}
	}
	return false;
}
</script>

<%	if (ParamsParser.getState(pageContext) == APPStates.STATE_WEARENDA_EDIT || ParamsParser.getState(pageContext) == APPStates.HISTORY_STATE_WEARENDA_EDIT) { %>
	<html:hidden property="mainDocument"/>
<%	} %>

<table class="main">
<%--
<tr class="title">
		<td class="title" colspan="<%= gColSpan %>">
			<html:link page="<%= parent %>" styleClass="navigator"><bean:message key="<%= caption %>"/></html:link>
			<july:sepmark/>
			<% if (ParamsParser.getState(pageContext) == APPStates.HISTORY_STATE_WEARENDA_EDIT) { %>
				<html:link page="/ShowHistoryList.do" styleClass="navigator"><bean:message key="label.history"/></html:link>
				<july:sepmark/>
			<% } %>
			<july:actionname/>
		</td>
	</tr>
--%>

    <july:separator colspan="<%= gColSpan %>"/>
    
    <tr>
        <td class="title" colspan="<%= gColSpan %>"><july:actionalert/></td>
    </tr>

 	<july:separator colspan="<%= gColSpan %>"/>

	<tr>
		<td class="text">
			<july:reqmark><bean:message key="label.filter.docnumber"/>:</july:reqmark>
		</td>
		<td class="text">
			<july:string size="50" property="documentNumber" insertable="false" updatable="false"/>
		</td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<td class="text"><july:reqmark><bean:message key="label.filter.docperiod"/>:</july:reqmark></td>
		<td class="text">
			<july:date property="startDateFrm" size="25" insertable="false" updatable="false"/>&nbsp;
			<bean:message key="label.filter.stop"/>&nbsp;
			<july:date property="endDateFrm" size="25" insertable="false" updatable="false"/>
		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<td class="text">
			<july:reqmark><bean:message key="label.filter.customer"/>:</july:reqmark>
		</td>
		<td class="text">
			<july:string size="50" property="orgCustomername" insertable="false" updatable="false"/>
		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>

	<tr>
		<td class="text">
			<july:reqmark><bean:message key="label.filter.executor"/>:</july:reqmark>
		</td>
		<td class="text">
			<july:string size="50" property="orgExecutorname" insertable="false" updatable="false"/>
		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>

	<tr>
		<td class="text">
			<july:reqmark><bean:message key="label.filter.costcurrency"/>:</july:reqmark>
		</td>
		<td class="text">
			<july:string size="10" property="summ1Frm" insertable="false" updatable="false"/>&nbsp;
			<bean:write name="<%= form %>" property="curr1" filter="true"/>
			<% String temp = ""; %>
			<logic:notEqual name="<%= form %>" property="summ2Frm" value="<%= temp %>">
				&nbsp;<july:string size="10" property="summ2Frm" insertable="false" updatable="false"/>
				&nbsp;<bean:write name="<%= form %>" property="curr2" filter="true"/>
			</logic:notEqual>
		</td>
    </tr>
	
	<july:separator colspan="<%= gColSpan %>"/>

	<tr>
		<td class="text"><july:reqmark><bean:message key="label.state"/>:</july:reqmark></td>
		<td class="text">
			<july:radio property="contractState" insertable="true" updatable="true" value="A" onclick="switchState();"/><bean:message key="label.state.prepared"/><br>
			<july:radio property="contractState" insertable="true" updatable="true" value="B" onclick="switchState();"/><bean:message key="label.state.continued"/><br>
	<%	if (ParamsParser.getState(pageContext) == APPStates.STATE_WEARENDA_EDIT || ParamsParser.getState(pageContext) == APPStates.HISTORY_STATE_WEARENDA_EDIT) { %>
		<logic:notPresent name="<%= form %>" property="mainDocument">
			<july:radio property="contractState" insertable="true" updatable="true" value="D" onclick="switchState();" styleId="contractState_D"/><bean:message key="label.state.unclosed"/><br>
			<july:radio property="contractState" insertable="true" updatable="true" value="C" onclick="switchState();" styleId="contractState_C"/><bean:message key="label.state.stoped"/>
		</logic:notPresent>
	<%	} else { %>
			<july:radio property="contractState" insertable="true" updatable="true" value="C" onclick="switchState();" styleId="contractState_C"/><bean:message key="label.state.stoped"/>
	<%	} %>
		</td>
    </tr>
	
	<july:separator colspan="<%= gColSpan %>"/>

<logic:notPresent name="<%= form %>" property="mainDocument">
	<tr>
		<td class="text">Дата состояния:</july:reqmark></td>
		<td class="text"><july:date property="datecloseFrm" size="25" insertable="true" updatable="true"  styleId="dateclose" required="false"/></td> 
    </tr>
	<july:separator colspan="<%= gColSpan %>"/>
</logic:notPresent>
	
	<july:formbuttons/>

	<july:separator colspan="<%= gColSpan %>"/>
		
</table>

</july:editform>

<script language="javascript">
	switchState();
</script>