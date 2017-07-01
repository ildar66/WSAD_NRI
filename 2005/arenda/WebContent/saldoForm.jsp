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
	String parent2 = null;
	String parentCaption = null;
	String temp = null;
	switch (ParamsParser.getState(pageContext)) {
		case APPStates.SALDO_EDIT:
        	action = "/ProcessSaldo.do";
			form = "SaldoForm";
			parent = "/ViewWeArenda.do";
			parent2 = "/ShowSaldoList.do";
        	break;
		case APPStates.HISTORY_SALDO_EDIT:
        	action = "/ProcessHistorySaldo.do";
			form = "HistorySaldoForm";
			parent = "/ViewHistory.do";
			parent2 = "/ShowHistorySaldoList.do";
        	break;
		case APPStates.US_SALDO_EDIT:
        	action = "/ProcessUsSaldo.do";
			form = "UsSaldoForm";
			parent = "/ShowUsArendaList.do";
			parent2 = "/ShowUsSaldoList.do";
			parentCaption = "label.us";
        	break;
		case APPStates.CHANNEL_SALDO_EDIT:
        	action = "/ProcessChannelSaldo.do";
			form = "ChannelSaldoForm";
			parent = "/ShowChannelArendaList.do";
			parent2 = "/ShowChannelSaldoList.do";
			parentCaption = "label.channel";
        	break;
		case APPStates.ABONENT_SALDO_EDIT:
        	action = "/ProcessAbonentSaldo.do";
			form = "AbonentSaldoForm";
			parent = "/ViewAbonent.do";
			parent2 = "/ShowAbonentSaldoList.do";
			parentCaption = "";
        	break;
    }
%>


<july:editform action="<%= action %>" styleId="<%= form %>">


<html:hidden property="leaseContract"/>
<html:hidden property="currency2Frm"/>
<html:hidden property="curr1"/>
<html:hidden property="curr2"/>
<html:hidden property="calctype" value="-"/>
<html:hidden property="operator"/>
<html:hidden property="operatorName"/>


<script language='javascript'>
function switchAdd() {
	if (document.all.isAdd[0].checked) {
		<%= form %>.addsum.className = 'edit';
		<%= form %>.addsum.disabled = false;
		<%= form %>.addcurr.className = 'edit';
		<%= form %>.addcurr.disabled = false;
		<%= form %>.addnds.className = 'edit';
		<%= form %>.addnds.disabled = false;
	} else {
		<%= form %>.addsum.className = 'editdisabled';
		<%= form %>.addsum.disabled = true;
		<%= form %>.addcurr.className = 'editdisabled';
		<%= form %>.addcurr.disabled = true;
		<%= form %>.addnds.className = 'editdisabled';
		<%= form %>.addnds.disabled = true;
	}
}
</script>


<table class="main">
<%--
<tr class="title">
		<td class="title" colspan="<%= gColSpan %>">
			<%	if (ParamsParser.getState(pageContext) == APPStates.SALDO_EDIT ||
				ParamsParser.getState(pageContext) == APPStates.HISTORY_SALDO_EDIT) { %>
				<html:link page="/ShowWeArendaList.do" styleClass="navigator"><bean:message key="label.we"/></html:link>
				<july:sepmark/>
				<% if (ParamsParser.getState(pageContext) == APPStates.HISTORY_SALDO_EDIT) { %>
					<html:link page="/ShowHistoryList.do" styleClass="navigator"><bean:message key="label.history"/></html:link>
					<july:sepmark/>
				<% } %>
				<july:editlink page="<%= parent %>" action="View" styleClass="navigator">
					<bean:message key="label.view"/>
				</july:editlink>
			<%	} else if (ParamsParser.getState(pageContext) == APPStates.ABONENT_SALDO_EDIT) { %>
				<html:link page="/ShowAbonentsList.do" styleClass="navigator"><bean:message key="label.abonents"/></html:link>
				<july:sepmark/>
				<july:editlink page="/ViewAbonent.do" action="View" styleClass="navigator"><bean:message key="label.view"/></july:editlink>
			<%	} else { %>
				<html:link page="<%= parent %>" styleClass="navigator"><bean:message key="<%= parentCaption %>"/></html:link>
			<%	} %>
			<july:sepmark/>
			<html:link page="<%= parent2 %>" styleClass="navigator"><bean:message key="label.saldo"/></html:link>
			<july:sepmark/> 
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
			<july:string size="50" property="orgCustomer" insertable="false" updatable="false"/>
		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>


	<tr>
		<td class="text">
			<july:reqmark><bean:message key="label.filter.executor"/>:</july:reqmark>
		</td>
		<td class="text">
			<july:string size="50" property="orgExecutor" insertable="false" updatable="false"/>
		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>


	<tr>
		<td class="text">
			<july:reqmark><bean:message key="label.filter.costcurrency"/>:</july:reqmark>
		</td>
		<td class="text">
			<july:string size="10" property="currency1Frm" insertable="false" updatable="false"/>&nbsp;
			<bean:write name="<%= form %>" property="curr1" filter="true"/>
			<% temp = ""; %>
			<logic:notEqual name="<%= form %>" property="currency2Frm" value="<%= temp %>">
				&nbsp;<july:string size="10" property="currency2Frm" insertable="false" updatable="false"/>
				&nbsp;<bean:write name="<%= form %>" property="curr2" filter="true"/>
			</logic:notEqual>
		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<td class="text"><july:reqmark><bean:message key="label.saldo.saldate"/>:</july:reqmark></td>
		<td class="text">
			<% boolean bTemp = ParamsParser.getState(pageContext) == APPStates.ABONENT_SALDO_EDIT || ParamsParser.getState(pageContext) == APPStates.SALDO_EDIT || ParamsParser.getState(pageContext) == APPStates.HISTORY_SALDO_EDIT ? true : false; %>
			<july:date property="salDateFrm" size="25" insertable="<%= new Boolean(bTemp).toString() %>" updatable="false" required="<%= new Boolean(!bTemp).toString() %>"/>
		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<td class="text"><july:reqmark><bean:message key="label.saldo.resource"/>:</july:reqmark></td>
		<td class="text">
			<logic:equal name="<%= form %>" property="action" value="Add">
				<% temp = "true"; %>
			</logic:equal>
			<logic:notEqual name="<%= form %>" property="action" value="Add">
				<% temp = "false"; %>
			</logic:notEqual>
		    <july:select style="width: 450;" collection="resources" property="resourcecode" insertable="<%= temp %>" updatable="<%= temp %>">
				<html:options collection="resources" property="resource" labelProperty="name"/>
		   	</july:select>
		</td>
    </tr>
	
	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<td class="text"><july:reqmark><bean:message key="label.saldo.mainsum"/>:</july:reqmark></td>
		<td class="text">
			<july:string size="25" property="mainsumFrm" insertable="true" updatable="true"/>&nbsp;
		    <july:select style="width: 200;" collection="currencies" property="maincurrencycode" insertable="true" updatable="true">
				<html:options collection="currencies" property="currency" labelProperty="name"/>
		   	</july:select>
		</td>
	</tr>

	<tr>
		<td class="text"><july:reqmark><bean:message key="label.saldo.mainnds"/>:</july:reqmark></td>
		<td class="text">
			<july:string size="25" property="mainndssumFrm" insertable="true" updatable="true"/>
			<logic:notEqual name="<%= form %>" property="action" value="Delete">
				<logic:notEqual name="<%= form %>" property="action" value="View">
					&nbsp;<input type='image' name='submit' src="/images/obchet1.gif" alt='<bean:message key="label.filter.calcnds"/>' onclick='calctype.value = "N";'>
				</logic:notEqual>
			</logic:notEqual>
		</td>
	</tr>

	<tr>
		<td class="text"><bean:message key="label.saldo.msumcalc"/>:</td>
		<td class="text">
			<july:string size="25" property="msumcalcFrm" insertable="false" updatable="false"/>
		</td>
	</tr>

	<tr>
		<td class="text"><bean:message key="label.saldo.mndscalc"/>:</td>
		<td class="text">
			<july:string size="25" property="mndscalcFrm" insertable="false" updatable="false"/>
		</td>
	</tr>


	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<td class="text"><bean:message key="label.saldo.isadd"/>:</td>
		<td class="text"><july:checkbox property="isAdd" insertable="true" updatable="true" onclick="switchAdd();"/></td>
	</tr>
	
	<tr>
		<td class="text"><bean:message key="label.saldo.addsum"/>:</td>
		<td class="text">
			<july:string size="25" property="additionalsumFrm" insertable="true" updatable="true" styleId="addsum"/>&nbsp;
		    <july:select style="width: 200;" collection="currencies" property="additionalcurrencycode" insertable="true" updatable="true" styleId="addcurr">
				<html:options collection="currencies" property="currency" labelProperty="name"/>
		   	</july:select>
		</td>
	</tr>
	
	<tr>
		<td class="text"><bean:message key="label.saldo.addnds"/>:</td>
		<td class="text">
			<july:string size="25" property="additionalndssumFrm" insertable="true" updatable="true" styleId="addnds"/>
			<logic:notEqual name="<%= form %>" property="action" value="Delete">
				<logic:notEqual name="<%= form %>" property="action" value="View">
					&nbsp;<input type='image' name='submit' src="/images/obchet1.gif" alt='<bean:message key="label.filter.calcnds"/>' onclick='calctype.value = "NA";'>
				</logic:notEqual>
			</logic:notEqual>
		</td>
	</tr>

	<tr>
		<td class="text"><bean:message key="label.saldo.asumcalc"/>:</td>
		<td class="text">
			<july:string size="25" property="asumcalcFrm" insertable="false" updatable="false"/>
		</td>
	</tr>

	<tr>
		<td class="text"><bean:message key="label.saldo.andscalc"/>:</td>
		<td class="text">
			<july:string size="25" property="andscalcFrm" insertable="false" updatable="false"/>
		</td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>

	<tr>
		<td class="text"><bean:message key="label.saldo.notes"/>:</td>
		<td class="text">
			<july:textarea cols="50" rows="3" property="notes" insertable="true" updatable="true"/>
		</td>
	</tr>
	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<td class="text"><bean:message key="label.saldo.operator"/>:</td>
		<td class="text">
			<bean:write name="<%=form%>" property="operatorName" />
		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>
	
	<july:formbuttons/>
	
	<july:separator colspan="<%= gColSpan %>"/>
		
</table>


<logic:equal name="<%= form %>" property="action" value="Add">
	<script language='javascript'>
		switchAdd();
	</script>
</logic:equal>


<logic:notEqual name="<%= form %>" property="action" value="Add">
	<logic:present name="<%= form %>" property="additionalsum">
		<script language='javascript'>
			document.all.isAdd[0].checked = true;
		</script>
	</logic:present>
</logic:notEqual>


<logic:notEqual name="<%= form %>" property="action" value="Delete">
	<logic:notEqual name="<%= form %>" property="action" value="View">
		<script language='javascript'>
			switchAdd();
		</script>
	</logic:notEqual>
</logic:notEqual>


</july:editform>

