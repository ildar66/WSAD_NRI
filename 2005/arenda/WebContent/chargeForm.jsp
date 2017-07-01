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
		case APPStates.CHARGE_EDIT:
			action = "/ProcessCharge.do";
			form = "ChargeForm";
			parent = "/ViewWeArenda.do";
			parent2 = "/ShowChargesList.do";
			break;

		case APPStates.HISTORY_CHARGE_EDIT:
			action = "/ProcessHistoryCharge.do";
			form = "HistoryChargeForm";
			parent = "/ViewHistory.do";
			parent2 = "/ShowHistoryChargesList.do";
			break;

		case APPStates.US_CHARGE_EDIT:
			action = "/ProcessUsCharge.do";
			form = "UsChargeForm";
			parent = "/ShowUsArendaList.do";
			parent2 = "/ShowUsChargesList.do";
			parentCaption = "label.us";
			break;

		case APPStates.CHANNEL_CHARGE_EDIT:
			action = "/ProcessChannelCharge.do";
			form = "ChannelChargeForm";
			parent = "/ShowChannelArendaList.do";
			parent2 = "/ShowChannelChargesList.do";
			parentCaption = "label.channel";
			break;

		case APPStates.ABONENT_CHARGE_EDIT:
			action = "/ProcessAbonentCharge.do";
			form = "AbonentChargeForm";
			parent = "/ViewAbonent.do";
			parent2 = "/ShowAbonentChargesList.do";
			parentCaption = "label.channel";
			break;
	}
%>



<july:editform action="<%= action %>" styleId="<%= form %>">

<html:hidden property="leaseContractcode"/>
<html:hidden property="leaseDocPosition"/>
<html:hidden property="calctype" value="-"/>


<% String isCertain = "true"; %>
<logic:equal name="<%= form %>" property="action" value="Add">
	<% isCertain = "false"; %>
</logic:equal>

<script language="javascript">

function switchRate() {
	if (document.all.byhandraterur[0].checked) {
		<%= form %>.rate.disabled = false;
		<%= form %>.rate.className = 'edit';
	} else {
		<%= form %>.rate.disabled = true;
		<%= form %>.rate.className = 'editdisabled';
	}
}

function switchDate() {
	if (document.all.isCorrection[0].checked) {
		<%= form %>.dateFrm_dt.enabled = true;
	} else {
		<%= form %>.dateFrm_dt.enabled = false;
	}
}

function update() {
	var ndsRate = new Number(coma_replace(document.all.ndsRateFrm.value, '.'));
    var sum = coma_replace(document.all.summFrm.value, '.');
	document.all.sumndsFrm.value = Math.round((sum * ndsRate) / (100.0 + ndsRate) * 100.0) / 100.0;
}

function coma_replace(n, dd)
{
	var a = n.toString().split(',');
	if(a[1] == null)
		return a[0]; 
	else 
		return (a[0] + dd + a[1]);
}
//при услуге-электроэнергия: валюта = руб.(при добавлении)
function setCurrency(){
	if(<%= form %>.resourcecode.value == "10448")
		<%= form %>.currencycode.value="810";	
}
</script>

<table class="main">

<%--
<tr class="title">
		<td class="title" colspan="<%= gColSpan %>">
			<%	if (ParamsParser.getState(pageContext) == APPStates.CHARGE_EDIT ||
				ParamsParser.getState(pageContext) == APPStates.HISTORY_CHARGE_EDIT) { %>
				<html:link page="/ShowWeArendaList.do" styleClass="navigator"><bean:message key="label.we"/></html:link>
				<july:sepmark/>
				<% if (ParamsParser.getState(pageContext) == APPStates.HISTORY_CHARGE_EDIT) { %>
					<html:link page="/ShowHistoryList.do" styleClass="navigator"><bean:message key="label.history"/></html:link>
					<july:sepmark/>
				<% } %>
				<july:editlink page="<%= parent %>" action="View" styleClass="navigator">
					<bean:message key="label.view"/>
				</july:editlink>
			<%	} else if (ParamsParser.getState(pageContext) == APPStates.ABONENT_CHARGE_EDIT) {%>
				<html:link page="/ShowAbonentsList.do" styleClass="navigator"><bean:message key="label.abonents"/></html:link>
				<july:sepmark/>
				<july:editlink page="/ViewAbonent.do" action="View" styleClass="navigator"><bean:message key="label.view"/></july:editlink>
			<%	} else {%>
				<html:link page="<%= parent %>" styleClass="navigator"><bean:message key="<%= parentCaption %>"/></html:link>
			<%	} %>
			<july:sepmark/>
			<html:link page="<%= parent2 %>" styleClass="navigator"><bean:message key="label.charges"/></html:link>
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
		<td class="text"><bean:message key="label.mainPosition"/>:</td>
		<td class="text">
			<bean:write name="<%=form%>" property="mainPosition" filter="true"/>
			<html:hidden property="mainPosition"/>
		</td>
	</tr>

	<tr>
		<td class="text"><bean:message key="label.filter.docnumber"/>:</td>
		<td class="text">
			<bean:write name="<%=form%>" property="documentNumber" filter="true"/>
			<html:hidden property="documentNumber"/>
		</td>
	</tr>

	<tr>
		<td class="text"><bean:message key="label.filter.docperiod"/>:</td>
		<td class="text">
			<july:datewrite name="<%=form%>" property="startDate"/>&nbsp;
			<bean:message key="label.filter.stop"/>&nbsp;
			<july:datewrite name="<%=form%>" property="endDate" />
			<html:hidden property="startDateFrm"/>
			<html:hidden property="endDateFrm"/>
		</td>
	</tr>

	<tr>
		<td class="text"><bean:message key="label.filter.customer"/>:</td>
		<td class="text">
			<bean:write name="<%=form%>" property="orgCustomerContract" filter="true"/>
			<html:hidden property="orgCustomerContract"/>
		</td>
	</tr>

	<tr>
		<td class="text"><bean:message key="label.filter.executor"/>:</td>
		<td class="text">
			<bean:write name="<%=form%>" property="orgExecutorContract" filter="true"/>
			<html:hidden property="orgExecutorContract"/>
		</td>
	</tr>

	<tr>
		<td class="text"><bean:message key="label.filter.costcurrency"/>:</td>
		<td class="text">
			<bean:write name="<%= form %>" property="costcurrency1" filter="true"/>&nbsp;<bean:write name="<%= form %>" property="curr1" filter="true"/>
			<html:hidden property="costcurrency1"/><html:hidden property="curr1"/>
			<% temp = ""; %>
			<logic:present name="<%= form %>" property="costcurrency2">
			<logic:notEqual name="<%= form %>" property="costcurrency2" value="<%= temp %>">
				&nbsp;<bean:write name="<%= form %>" property="costcurrency2" filter="true"/>
				&nbsp;<bean:write name="<%= form %>" property="curr2" filter="true"/>
				<html:hidden property="costcurrency2"/><html:hidden property="curr2"/>
			</logic:notEqual>
			</logic:present>
		</td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>

	<tr>
		<td class="text"><july:reqmark><bean:message key="label.charges.resource"/>:</july:reqmark></td>
		<td class="text">
			<july:select style="width: 450;" collection="resources" property="resourcecode" insertable="true" updatable="true">
				<html:options collection="resources" property="resource" labelProperty="name"/>
			</july:select>
		</td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>

	<tr>
		<td class="text"><july:reqmark><bean:message key="label.charges.period"/>:</july:reqmark></td>
		<td class="text">
			<july:date property="begindateFrm" size="25" insertable="true" updatable="true" required="<%= isCertain %>"/>&nbsp;
			<bean:message key="label.filter.stop"/>&nbsp;
			<july:date property="enddateFrm" size="25" insertable="true" updatable="true" required="<%= isCertain %>"/>
		</td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>

	<tr>
		<td class="text"><july:reqmark><bean:message key="label.charges.sum"/>:</july:reqmark></td>
		<td class="text">
			<july:string size="25" property="summFrm" insertable="true" updatable="true"  onkeyup="update()"/>&nbsp;
			<july:select style="width: 150;" collection="currencies" property="currencycode" insertable="true" updatable="true">
				<html:option value="0">&nbsp;</html:option>
				<html:options collection="currencies" property="currency" labelProperty="name"/>
			</july:select>
		</td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>

	<tr>
		<td class="text"><july:reqmark><bean:message key="label.charges.ndssum"/>:</july:reqmark></td>
		<td class="text">
			<july:string size="10" property="sumndsFrm" insertable="true" updatable="true"/>
			<logic:notEqual name="<%= form %>" property="action" value="Delete">
				<logic:notEqual name="<%= form %>" property="action" value="View">
					&nbsp;<input type='image' name='submit' value='1' src='/images/obchet1.gif' alt='<bean:message key="label.filter.calcnds"/>' onclick='calctype.value = "N";'>
				</logic:notEqual>
			</logic:notEqual>
			<bean:message key="label.payments.stavkaNds"/>
			<july:string size="5" property="ndsRateFrm" insertable="true" updatable="true" onkeyup="update()"/>
		</td>
	</tr>

	<%--july:separator colspan="<%= gColSpan %>"/>

	<tr>
		<td class="text"><july:reqmark><bean:message key="label.charges.remaindersum"/>:</july:reqmark></td>
		<td class="text">
			<july:string size="25" property="remaindersumFrm" insertable="false" updatable="false"/>
		</td>
	</tr--%>

	<july:separator colspan="<%= gColSpan %>"/>

	<tr>
		<td class="text"><bean:message key="label.charges.accountnumber"/>:</td>
		<td class="text">
			<july:string size="25" property="billnumber" insertable="true" updatable="true"/>&nbsp;
			<july:date property="billdateFrm" size="25" insertable="true" updatable="true" required="false"/>
		</td>
	</tr>
	<%String isEdit = "false";%>
	<july:canedit rolesProperty="editRoles">
		<%isEdit = "true";%>
	</july:canedit>
	<july:separator colspan="<%= gColSpan %>"/>

	<tr>
		<td class="text"><july:reqmark><bean:message key="label.charges.iscorrection"/>:</july:reqmark></td>
		<td class="text">
			<july:checkbox property="isCorrection" insertable="<%= isEdit%>" updatable="<%= isEdit%>" onclick="switchDate()"/>&nbsp;
			<bean:message key="label.charges.datecharge"/>:&nbsp;
			<july:date property="dateFrm" size="25" insertable="true" updatable="true" styleId="dateFrm"/>
		</td>
	</tr>

	<%--july:separator colspan="<%= gColSpan %>"/>

	<tr>
		<td class="text"><july:reqmark><bean:message key="label.charges.byhandraterur"/>:</july:reqmark></td>
		<td class="text">
			<july:checkbox property="byhandraterur" insertable="<%= isEdit%>" updatable="<%= isEdit%>" onclick="switchRate()"/>
		</td>
	</tr--%>

	<%--july:separator colspan="<%= gColSpan %>"/>

	<tr>
		<td class="text"><bean:message key="label.charges.billdate"/>:</td>
		<td class="text"><july:date property="billdateFrm" size="25" insertable="<%= isEdit%>" updatable="<%= isEdit%>" required="false"/></td>
	</tr--%>

	<july:separator colspan="<%= gColSpan %>"/>

	<tr>
		<td class="text"><bean:message key="label.charges.remainderratetorur"/>:</td>
		<td class="text">
			<july:checkbox property="byhandraterur" insertable="<%= isEdit%>" updatable="<%= isEdit%>" onclick="switchRate()"/>&nbsp;
			<july:string size="25" property="remainderrate2rurFrm" insertable="true" updatable="true" styleId="rate"/>
		</td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>

	<tr>
		<td class="text"><bean:message key="label.docpositions.source"/>:</td>
		<td class="text">
			<logic:equal name="<%= form %>" property="source" value="A"><bean:message key="label.docpositions.source.auto"/></logic:equal>
			<logic:equal name="<%= form %>" property="source" value="B"><bean:message key="label.docpositions.source.bill"/></logic:equal>
			<logic:equal name="<%= form %>" property="source" value="P"><bean:message key="label.docpositions.source.platinum"/></logic:equal>
			<logic:equal name="<%= form %>" property="source" value="M"><bean:message key="label.docpositions.source.manual"/></logic:equal>
		</td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>

	<tr>
		<td class="text"><bean:message key="label.docpositions.docposvid"/>:</td>
		<td class="text">
			<logic:equal name="<%= form %>" property="docposvid" value="Q"><bean:message key="label.docpositions.docposvid.q"/></logic:equal>
			<logic:equal name="<%= form %>" property="docposvid" value="K"><bean:message key="label.docpositions.docposvid.k"/></logic:equal>
			<logic:equal name="<%= form %>" property="docposvid" value="Z"><bean:message key="label.docpositions.docposvid.z"/></logic:equal>
			<logic:equal name="<%= form %>" property="docposvid" value="N"><bean:message key="label.docpositions.docposvid.n"/></logic:equal>
			<logic:equal name="<%= form %>" property="docposvid" value="C"><bean:message key="label.docpositions.docposvid.c"/></logic:equal>
		</td>
	</tr>

	<july:separator colspan="<%= gColSpan %>"/>
	<july:formbuttons/>
	<july:separator colspan="<%= gColSpan %>"/>
</table>
<script language="javascript">
	switchRate();
</script>

<logic:notEqual name="<%= form %>" property="action" value="Delete">
	<logic:notEqual name="<%= form %>" property="action" value="View">
		<script language="javascript">
			switchDate();
		</script>
	</logic:notEqual>
</logic:notEqual>

<logic:equal name="<%= form %>" property="action" value="Add">
		<script language="javascript">
			setCurrency();
		</script>
</logic:equal>

</july:editform>
