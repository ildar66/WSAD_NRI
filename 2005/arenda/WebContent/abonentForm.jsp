<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>


<% java.lang.String gColSpan = "2"; %>


<july:editform action="/ProcessAbonent.do" styleId="AbonentForm">


<html:hidden property="leaseDocument"/>
<html:hidden property="contractState"/>
<script language='javascript'>
function showTerrabyteWin(s) {
	if(!s) s = "";
	var terrabyteWin = window.open("<%=com.hps.july.util.AppUtils.getNamedValueString("TerrabyteURL")%>?type=leasedoc&id=<bean:write property="leaseDocument" name="AbonentForm" scope="session" />&uid=<%=request.getRemoteUser()%>" + s, "terrabyteWin", "top=60, left=60, height=" + (screen.availHeight-150) + ", width=" + (screen.availWidth-150) + ", fullscreen=no,location=no,menubar=no,resizable=yes,scrollbars=yes,status=no,titlebar=yes,toolbar=no");
	if(terrabyteWin) terrabyteWin.focus();
}
</script>

<table class="main" style="font-size: 8pt">

    <july:separator colspan="<%= gColSpan %>"/>
    
    <tr>
        <td class="title" colspan="<%= gColSpan %>"><july:actionalert/></td>
	</tr>


	<july:separator colspan="<%= gColSpan %>"/>


    <tr>
        <td class="text"><bean:message key="label.actions"/>:</td>
		<td>
			<july:canedit rolesProperty="editRoles">
				<logic:equal name="AbonentForm" property="contractState" value="A">
					<july:link page="/EditAbonentBan.do?action=Edit" paramId="leaseDocument" paramName="AbonentForm" paramProperty="leaseDocument" styleClass="button">
						<bean:message key="label.abonents.edit"/>
					</july:link>
				</logic:equal>
			</july:canedit>
			<july:link page="/ShowBensList.do" paramId="leaseDocument" paramName="AbonentForm" paramProperty="leaseDocument" styleClass="button">
				<bean:message key="label.abonents.benlist"/>
			</july:link>
			<july:link page="/ShowMemoList.do" paramId="leaseDocument" paramName="AbonentForm" paramProperty="leaseDocument" styleClass="button">
				Служебные записки
			</july:link>
			<july:link page="/ShowCourierDeliveryList.do" paramId="leaseDocument" paramName="AbonentForm" paramProperty="leaseDocument" styleClass="button">
				Доставка счетов
			</july:link><br>
			<july:link page="/ShowAbonentChargesList.do" paramId="leaseContract" paramName="AbonentForm" paramProperty="leaseDocument" styleClass="button">
				<bean:message key="label.abonents.chargesnri"/>
			</july:link>
			<july:link page="/ShowAbonentPaymentsList.do" paramId="leaseContract" paramName="AbonentForm" paramProperty="leaseDocument" styleClass="button">
				<bean:message key="label.abonents.paysnri"/>
			</july:link>
			<a href="#" onclick="showTerrabyteWin('&ss=1&dv=0');" class="button">Документы аренды</a><br>
			<july:link page="/ShowAbonentBillsList.do" paramId="leaseDocument" paramName="AbonentForm" paramProperty="leaseDocument" styleClass="button">
				<bean:message key="label.abonents.paybill"/>
			</july:link>
			<july:link page="/ShowAbonentPaysList.do" paramId="leaseDocument" paramName="AbonentForm" paramProperty="leaseDocument" styleClass="button">
				<bean:message key="label.abonents.chargesbil"/>
			</july:link>
			<%if(request.isUserInRole("administrator")) {%>	
			<july:link page="/ShowAbonentSaldoList.do" paramId="leaseContract" paramName="AbonentForm" paramProperty="leaseDocument" styleClass="button">
				OLD_<bean:message key="label.saldo"/>
			</july:link>
			<%}%>
			<html:link page="/AbonentSaldoDetailList.do" paramId="idContract" paramName="AbonentForm" paramProperty="leaseDocument" styleClass="button">
				<bean:message key="label.dhist.lnksaldo"/>
			</html:link>			
        </td>
    </tr>
	
    <july:separator colspan="<%= gColSpan %>"/>
	
	<tr>
		<td class="text"><bean:message key="label.bans.ban"/>:</td>
		<td class="text">
			<july:string size="50" property="banFrm" insertable="false" updatable="false"/>
		</td>
	</tr>

	<tr>
		<td class="text"><bean:message key="label.bans.balans"/>:</td>
		<td class="text">
			<july:string size="40" style="width: 265pt" property="balans" insertable="false" updatable="false"/>&nbsp;
			<july:string size="10" style="width: 70pt" property="currencyVO.shortname" insertable="false" updatable="false"/>
		</td>
	</tr>

	<tr>
		<td class="text"><bean:message key="label.bans.nri.orginn"/></td>
		<td class="text">
			<july:string size="10" style="width: 70pt" property="orgCustomerInn" insertable="false" updatable="false"/>&nbsp;
			<%--bean:message key="label.bans.nri.orgname"/>&nbsp;--%>
			<july:string size="25" style="width: 265pt" property="orgCustomername" insertable="false" updatable="false"/>
		</td>
	</tr>
	
	<tr>
		<td class="text"><bean:message key="label.bans.billing.orginn"/></td>
		<td class="text">
			<july:string size="10" style="width: 70pt" property="bil_inn" insertable="false" updatable="false"/>&nbsp;
			<%--bean:message key="label.bans.billing.orgname"/>&nbsp;--%>
			<july:string size="25" style="width: 265pt" property="bil_name" insertable="false" updatable="false"/>
		</td>
	</tr>

	<tr>
		<td class="text"><bean:message key="label.bans.typeabonent"/>:</td>
		<td class="text"><july:string size="50" property="bil_acctypename" insertable="true" updatable="true"/></td>
    </tr>

	<tr>
		<td class="text"><bean:message key="label.bans.statusdog"/>:</td>
		<td class="text">
			<july:string size="10" property="bil_contrstname" insertable="true" updatable="true"/>&nbsp;
			<bean:message key="label.bans.statuschange"/>&nbsp;
			<july:date size="25" property="bil_contrstdateFrm" insertable="true" updatable="true"/>
		</td>
    </tr>

	<tr>
		<td class="text"><bean:message key="label.bans.date"/>:</td>
		<td class="text">
			<july:date size="25" property="documentDateFrm" insertable="true" updatable="true"/>&nbsp;
			<bean:message key="label.bans.dateactivation"/>&nbsp;
			<july:date size="25" property="startDateFrm" insertable="true" updatable="true"/>
		</td>
    </tr>
	
	<tr>
		<td class="text"><bean:message key="label.bans.datedisconnect"/>:</td>
		<td class="text"><july:date size="25" property="bil_suspdateFrm" insertable="true" updatable="true"/></td>
	</tr>
	
	<tr>
		<td class="text"><bean:message key="label.bans.addressaccount"/>:</td>
		<td class="text"><july:string size="50" property="bil_billaddress" insertable="true" updatable="true"/></td>
	</tr>
	
	<tr>
		<td class="text"><bean:message key="label.bens.list"/>:</td>
		<td class="text">
			<logic:equal name="AbonentForm" property="useallben" value="true"><bean:message key="label.bans.allben"/></logic:equal>
			<logic:equal name="AbonentForm" property="useallben" value="false">
				<july:string size="50" property="bensList" insertable="false" updatable="false"/>
			</logic:equal>
		</td>
	</tr>
	
	<tr>
		<td class="text"><july:reqmark><bean:message key="label.bans.flagworkpie"/>:</july:reqmark></td>
		<td class="text"><july:checkbox property="flagworkpie" insertable="true" updatable="true"/></td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr class="title">
		<td class="title" colspan="<%= gColSpan %>"><bean:message key="label.bans.phones"/>
			
<logic:present name="abonentphonesList">


		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>
	
	<tr><td colspan="<%= gColSpan %>">
	<table class="main">
		<!-- Table header -->
		<tr class="title" style="background-color: 'D6EBFF';font-size:8pt;"></td>
			<td rowspan="2"><bean:message key="label.bans.phones.number"/></td>
			<td rowspan="2"><bean:message key="label.bans.phones.ben"/></td>
			<td rowspan="2"><bean:message key="label.bans.phones.status"/></td>
			<td rowspan="2"><bean:message key="label.bans.phones.network"/></td>
			<td colspan ="3">тарифный план</td>
			<td rowspan="2"><bean:message key="label.bans.phones.sn"/></td>
		</tr>
		<tr class="title" style="background-color: 'D6EBFF';font-size:8pt;">
			<td>код</td>
			<td>наименование</td>
			<td>дата начала</td>			
		</tr>
		<july:separator colspan="8"/>


		<!-- Table body -->
		<logic:iterate id="it" name="abonentphonesList">
			<logic:present name="it">
				<tr style="font-size:8pt;">
	            	<td class="text">
         	        	<bean:write name="it" property="phonenumber" filter="true"/>
	                </td>
	            	<td class="text">
         	        	<bean:write name="it" property="ben" filter="true"/>
	                </td>
    	            <td class="text">
						<bean:write name="it" property="phonestatus" filter="true"/> - 
						<logic:equal name="it" property="phonestatus" value="A">
							<bean:message key="label.bans.phones.status_A"/>
						</logic:equal>
						<logic:equal name="it" property="phonestatus" value="S">
							<bean:message key="label.bans.phones.status_S"/>
						</logic:equal>
						<logic:equal name="it" property="phonestatus" value="C">
							<bean:message key="label.bans.phones.status_C"/>
						</logic:equal>
            	    </td>
    	            <td class="text">
        	            <bean:write name="it" property="netstandard" filter="true"/>
            	    </td>
    	            <td class="text">
        	            <bean:write name="it" property="soc" filter="true"/>
            	    </td>
    	            <td class="text">
        	            <bean:write name="it" property="socdescription" filter="true"/>
            	    </td>
    	            <td class="text">
        	            <july:datewrite name="it" property="socstartdate"/>
            	    </td>
                	<td class="text">
                    	<bean:write name="it" property="imsi" filter="true"/>
	                </td>
					<july:separator colspan="8"/>
				</tr>
			</logic:present>
		</logic:iterate>


	</table>
	</td></tr>
	
</logic:present>
<logic:notPresent name="abonentphonesList">
		&nbsp;-&nbsp;<bean:message key="label.nodata"/>
		</td>
	</tr>
	
	<july:separator colspan="<%= gColSpan %>"/>
	
</logic:notPresent>

	<july:formbuttons/>

	<july:separator colspan="<%= gColSpan %>"/> 	
</table>
</july:editform>

