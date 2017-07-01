<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>


<% java.lang.String gColSpan = "2"; %>


<july:editform action="/ProcessAbonentBill.do" styleId="AbonentBillForm">


<html:hidden property="leasebill"/>
<html:hidden property="caneditben"/>
<html:hidden property="bensource"/>
<html:hidden property="changeuseinnri"/>
<html:hidden property="initialUseinnri"/>
<html:hidden property="recordstatus"/>
<html:hidden property="billType"/>


<table class="main">
<%-- <tr class="title">
	<td class="title" colspan="<%= gColSpan %>">
		<html:link page="/ShowAbonentsList.do" styleClass="navigator"><bean:message key="label.abonents"/></html:link>
		<july:sepmark/>
		<july:editlink page="/ViewAbonent.do" action="View" paramId="leaseDocument" paramName="AbonentBillsListForm" paramProperty="leaseDocument" styleClass="navigator"><bean:message key="label.view"/></july:editlink>
		<july:sepmark/>
		<html:link page="/ShowAbonentBillsList.do" styleClass="navigator"><bean:message key="label.abonents.paybill"/></html:link>
		<july:sepmark/>
		<july:actionname/>
	</td>
</tr> --%>


<july:separator colspan="<%= gColSpan %>"/>


<tr>
	<td class="title" colspan="<%= gColSpan %>"><july:actionalert/></td>
</tr>


<july:separator colspan="<%= gColSpan %>"/>

<tr>
	<td class="text" width="30%"><bean:message key="label.bans.bill.addons"/>:</td>
	<td class="title">
		<july:link page="/ShowAbonentBillPosesList.do" paramId="leaseBill" paramName="AbonentBillForm" paramProperty="leasebill" scope="page">
			<bean:message key="label.bans.bill.poses"/>
		</july:link>
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>"/>

<tr>
	<td class="text" width="30%"><bean:message key="label.bans.ban"/>:</td>
	<td class="text">
		<bean:write name="AbonentBillForm" property="ab_ban" filter="true"/>
		(валюта: <bean:write name="AbonentBillForm" property="currencyVO.shortname" filter="true"/>)
	</td>
</tr>


<july:separator colspan="<%= gColSpan %>"/>


<tr>
	<td class="text"><bean:message key="label.bens.list"/>:</td>
	<td class="text">
		<logic:equal name="AbonentBillForm" property="ab_useallben" value="true"><bean:message key="label.bans.allben"/></logic:equal>
		<logic:equal name="AbonentBillForm" property="ab_useallben" value="false"><bean:write name="AbonentBillForm" property="ab_benslist" filter="true"/></logic:equal>
	</td>
</tr>


<july:separator colspan="<%= gColSpan %>"/>


<tr>
	<td class="text"><bean:message key="label.bans.nri.orginn"/>:</td>
	<td class="text">
		<bean:write name="AbonentBillForm" property="ab_orgCustomerInn"/>&nbsp;
		<bean:message key="label.bans.nri.orgname"/>:&nbsp;
		<bean:write name="AbonentBillForm" property="ab_orgCustomername"/>
	</td>
</tr>


<july:separator colspan="<%= gColSpan %>"/>


<tr>
	<td class="text"><bean:message key="label.bans.billing.orginn"/>:</td>
	<td class="text">
		<bean:write name="AbonentBillForm" property="ab_bil_inn"/>&nbsp;
		<bean:message key="label.bans.billing.orgname"/>:&nbsp;
		<bean:write name="AbonentBillForm" property="ab_bil_name"/>
	</td>
</tr>


<%-- Account parameters --%>


<july:separator colspan="<%= gColSpan %>"/>


<tr>
	<td class="text"><bean:message key="label.bans.bill.number"/>:</td>
	<td class="text">
		<july:string size="25" property="num" insertable="false" updatable="false"/>&nbsp;
		<july:string size="25" property="dateFrm" insertable="false" updatable="false"/>
	</td>
</tr>


<july:separator colspan="<%= gColSpan %>"/>


<tr>
	<td class="text"><bean:message key="label.bans.bill.billtype"/>:</td>
	<td class="text">
		<logic:equal name="AbonentBillForm" property="billType" value="U"><bean:message key="label.bans.bill.billtype.u"/></logic:equal>
		<logic:equal name="AbonentBillForm" property="billType" value="O"><bean:message key="label.bans.bill.billtype.o"/></logic:equal>
		<logic:equal name="AbonentBillForm" property="billType" value="S"><bean:message key="label.bans.bill.billtype.s"/></logic:equal>
	</td>
</tr>


<july:separator colspan="<%= gColSpan %>"/>


<tr>
	<td class="text">&nbsp;</td>
	<td class="text">
		<table class="main"><tr>
			<td><bean:message key="label.bans.bill.billing"/></td>
			<td><bean:message key="label.bans.bill.nri"/></td>
		</tr></table>
	</td>
</tr>


<tr>
	<td class="text"><bean:message key="label.bans.bill.sum"/>:</td>
	<td class="text">
		<july:string size="25" property="sum" insertable="false" updatable="false"/>&nbsp;
		<july:string size="25" property="sumnri" insertable="false" updatable="false"/>
	</td>
</tr>


<tr>
	<td class="text"><bean:message key="label.bans.bill.sumnds"/>:</td>
	<td class="text">
		<july:string size="25" property="nds" insertable="false" updatable="false"/>&nbsp;
		<july:string size="25" property="ndsnri" insertable="false" updatable="false"/>
	</td>
</tr>


<july:separator colspan="<%= gColSpan %>"/>


<tr>
	<td class="text"><bean:message key="label.bans.bill.period"/>:</td>
	<td class="text">
		<july:string size="25" property="startDateFrm" insertable="false" updatable="false"/>&nbsp;
		<july:string size="25" property="endDateFrm" insertable="false" updatable="false"/>
	</td>
</tr>


<july:separator colspan="<%= gColSpan %>"/>


<tr>
	<td class="text"><bean:message key="label.bans.bill.ben"/>:</td>
	<td class="text">
		<logic:equal name="AbonentBillForm" property="caneditben" value="true">
			<july:string size="25" property="benFrm" insertable="true" updatable="true"/>
		</logic:equal>
		<logic:equal name="AbonentBillForm" property="caneditben" value="false">
			<july:string size="25" property="benFrm" insertable="false" updatable="false"/>
		</logic:equal>&nbsp;
		<logic:equal name="AbonentBillForm" property="bensource" value="A"><bean:message key="label.bans.bensource.auto"/></logic:equal>
		<logic:equal name="AbonentBillForm" property="bensource" value="H"><bean:message key="label.bans.bensource.hand"/></logic:equal>
	</td>
</tr>


<july:separator colspan="<%= gColSpan %>"/>


<tr>
	<td class="text"><bean:message key="label.bans.bill.usenri"/>:</td>
	<td class="text">
		<july:checkbox property="useinnri" insertable="true" updatable="true" styleClass="text"/>
		<logic:present name="AbonentBillForm" property="changeuseinnri">&nbsp;
			<logic:equal name="AbonentBillForm" property="changeuseinnri" value="A"><bean:message key="label.bans.bill.changeuseinnri.auto"/></logic:equal>
			<logic:equal name="AbonentBillForm" property="changeuseinnri" value="H"><bean:message key="label.bans.bill.changeuseinnri.hand"/></logic:equal>
		</logic:present>
	</td>
</tr>


<july:separator colspan="<%= gColSpan %>"/>


<tr>
	<td class="text"><bean:message key="label.bans.bill.status"/>:</td>
	<td class="text">
		<july:string size="25" property="billstatus" insertable="false" updatable="false"/>&nbsp;
		<july:string size="25" property="billstatusTxt" insertable="false" updatable="false"/>
	</td>
</tr>


<july:separator colspan="<%= gColSpan %>"/>


<tr>
	<td class="text"><bean:message key="label.bans.bill.recordstatus"/>:</td>
	<td class="text">
		<logic:equal name="AbonentBillForm" property="recordstatus" value="A"><bean:message key="label.bans.bill.recordstatus.active"/></logic:equal>
		<logic:equal name="AbonentBillForm" property="recordstatus" value="D"><bean:message key="label.bans.bill.recordstatus.deleted"/></logic:equal>
	</td>
</tr>


<july:separator colspan="<%= gColSpan %>"/>

<july:formbuttons/>

<july:separator colspan="<%= gColSpan %>"/>
		
</table>

</july:editform>
