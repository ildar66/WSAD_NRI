<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>


<july:editform action="/AgreementInfo.do">


<table class="main">
    <tr class="title">
    	<td class="title" colspan="2">
          <july:closebutton page="/"/>
          <july:printerbutton/> 
        </td>
    </tr>
    
    <july:separator/>
    
    <TR class="printable">
    <TD class="printable">
    
        <table class="print" STYLE="FONT-FAMILY: Arial,Verdana; FONT-SIZE: 8pt;">
			<tr class="print">
				<td class="print"><bean:message key="label.filter.docnumber"/></td>
				<td class="print" style="font-weight: bold">
					№  <bean:write name="AgreementInfoForm" property="mainDocumentNumber"/>
					от <bean:write name="AgreementInfoForm" property="mainDocumentDateFrm"/>
				</td>
			</tr>

			<tr class="print">
				<td class="print"><bean:message key="label.filter.customer"/>:</td>
				<td class="print" style="font-weight: bold">
				   <bean:write name="AgreementInfoForm" property="mainOrgCustomerName"/>
				</td>
			</tr>

			<tr class="print">
				<td class="print"><bean:message key="label.filter.executor.arenda"/>:</td>
				<td class="print" style="font-weight: bold">
				   <bean:write name="AgreementInfoForm" property="mainOrgExecutorName"/>
				</td>
			</tr>

			<tr class="print">
				<td class="print"><bean:message key="label.filter.docperiod"/>:</td>
				<td class="print" style="font-weight: bold" nowrap>
					<bean:message key="label.from"/>
					<july:datewrite name="AgreementInfoForm" property="mainStartDate"/>&nbsp;
					<bean:message key="label.till"/>&nbsp;
					<bean:write name="AgreementInfoForm" property="endDateFrm"/>&nbsp;
				</td>
			</tr>

			<tr class="print">
				<td class="print"><bean:message key="label.mainPosition"/></td>
				<td class="print" style="font-weight: bold">
					<bean:write name="AgreementInfoForm" property="positionname"/>	
				</td>
			</tr>

			<tr class="print">
				<td class="print"><bean:message key="label.filter.docsubject"/>:</td>
				<td class="print" style="font-weight: bold">
				   <bean:write name="AgreementInfoForm" property="subject"/>
				</td>
			</tr>

			<tr class="print">
				<td class="print">НДС:</td>
				<td class="print" style="font-weight: bold">
				   <logic:equal name="AgreementInfoForm" property="chargeNds" value="true">
						без НДС
				   </logic:equal>
				   <logic:equal name="AgreementInfoForm" property="chargeNds" value="false">
						в том числе НДС
				   </logic:equal>
				</td>
			</tr>

			<july:canedit rolesProperty="arendaMoneyRoles">
			<tr class="print">
				<td class="print"><bean:message key="label.filter.costcurrency1"/>:</td>
				<td class="print" style="font-weight: bold">
					<july:sumwrite name="AgreementInfoForm" property="summ1"/>
				    <bean:write name="AgreementInfoForm" property="currency1.shortname"/>
				</td>
			</tr>

			<logic:present name="AgreementInfoForm" property="summ2">
			<logic:notEqual name="AgreementInfoForm" property="summ2Frm" value="0">
			<tr class="print">
				<td class="print"><bean:message key="label.filter.costcurrency2"/>:</td>
				<td class="print" style="font-weight: bold">
					<july:sumwrite name="AgreementInfoForm" property="summ2"/>
				    <bean:write name="AgreementInfoForm" property="currency2.shortname"/>
				</td>
			</tr>
			</logic:notEqual>
			</logic:present>
			</july:canedit>

			<tr class="print">
				<td class="print"><bean:message key="label.filter.extendtype"/>:</td>
				<td class="print" style="font-weight: bold">
				<logic:present name="AgreementInfoForm" property="extendType">
	   				<logic:equal name="AgreementInfoForm" property="extendType" value="N">
						<bean:message key="label.extendtype.not"/>
					</logic:equal>
					<logic:equal name="AgreementInfoForm" property="extendType" value="A">
						<bean:message key="label.extendtype.auto"/>
					</logic:equal>
					<logic:equal name="AgreementInfoForm" property="extendType" value="M">
						<bean:message key="label.extendtype.addagreement"/>
					</logic:equal>
				</logic:present>
				</td>
			</tr>

			<logic:equal name="AgreementInfoForm" property="extendType" value="A">
			<tr class="print">
				<td class="print"><bean:message key="label.filter.extendperiod"/>:</td>
				<td class="print" style="font-weight: bold">
					<logic:present name="AgreementInfoForm" property="extendPeriod">
						<logic:equal name="AgreementInfoForm" property="extendPeriod" value="Y">
							<bean:message key="label.extendperiod.year"/>
						</logic:equal>
						<logic:equal name="AgreementInfoForm" property="extendPeriod" value="M">
							<bean:message key="label.extendperiod.month"/>
						</logic:equal>
						<logic:equal name="AgreementInfoForm" property="extendPeriod" value="D">
							<bean:message key="label.extendperiod.day"/>
						</logic:equal>
					</logic:present>
				</td>
			</tr>
			</logic:equal>

			<tr class="print">
				<td class="print"><bean:message key="label.filter.calcelectrotype"/>:</td>
				<td class="print" style="font-weight: bold">
				<logic:present name="AgreementInfoForm" property="calcElectroType">
	    			<logic:equal name="AgreementInfoForm" property="calcElectroType" value="1">
						<bean:message key="label.calcelectrotype.contract"/>
					</logic:equal>
					<logic:equal name="AgreementInfoForm" property="calcElectroType" value="2">
						<bean:message key="label.calcelectrotype.arendapay"/>
					</logic:equal>
					<logic:equal name="AgreementInfoForm" property="calcElectroType" value="3">
						<bean:message key="label.calcelectrotype.accounts"/>	
					</logic:equal>
				</logic:present>
				</td>
			</tr>

			<logic:present name="AgreementInfoForm" property="dogelectonum">
			<logic:notEqual name="AgreementInfoForm" property="dogelectonum" value="">
			<tr class="print">
				<td class="print"><bean:message key="label.filter.isdogelectro.number"/>:</td>
				<td class="print" style="font-weight: bold">
				    №  <bean:write name="AgreementInfoForm" property="dogelectonum"/>&nbsp;
					от <bean:write name="AgreementInfoForm" property="dogelectrodateFrm"/>
				</td>
			</tr>
			</logic:notEqual>
			</logic:present>
<%--
			<tr class="print">
				<td class="print"><bean:message key="label.filter.phones"/>:</td>
				<td class="print" style="font-weight: bold">
					<bean:message key="label.filter.phones.prop"/>:&nbsp;
				    <bean:write name="AgreementInfoForm" property="numberOfPhonesFrm"/>&nbsp;&nbsp;&nbsp;
					<bean:message key="label.filter.phones.temp"/>:&nbsp;
					<bean:write name="AgreementInfoForm" property="numberofphonestempFrm"/>
				</td>
			</tr>
--%>
			<tr class="print">
				<td class="print"><bean:message key="label.filter.economist"/>:</td>
				<td class="print" style="font-weight: bold">
				    <bean:write name="AgreementInfoForm" property="mainEconomistName"/>
				</td>
			</tr>

			<tr class="print">
				<td class="print"><bean:message key="label.table.mainmanager"/>:</td>
				<td class="print" style="font-weight: bold">
				    <bean:write name="AgreementInfoForm" property="mainManagerName"/>
				</td>
			</tr>

			<tr class="print">
				<td class="print"><bean:message key="label.filter.doccomment"/>:</td>
				<td class="print" style="font-weight: bold">
				    <bean:write name="AgreementInfoForm" property="comment"/>
				</td>
			</tr>
			
			<logic:present name="AgreementInfoForm" property="ratecalcrule">
			<tr class="print">
				<td class="print"><bean:message key="label.filter.ratecalcrule"/>:</td>
				<td class="print" style="font-weight: bold">
					<logic:equal name="AgreementInfoForm" property="ratecalcrule" value="A">
						<bean:message key="label.filter.ratecalcrule.a"/>
					</logic:equal>
					<logic:equal name="AgreementInfoForm" property="ratecalcrule" value="B">
						<bean:message key="label.filter.ratecalcrule.b"/>
					</logic:equal>
					<logic:equal name="AgreementInfoForm" property="ratecalcrule" value="C">
						<bean:message key="label.filter.ratecalcrule.c"/>
					</logic:equal>
					<logic:equal name="AgreementInfoForm" property="ratecalcrule" value="D">
						<bean:message key="label.filter.ratecalcrule.d"/>
					</logic:equal>
					<logic:equal name="AgreementInfoForm" property="ratecalcrule" value="E">
						<bean:message key="label.filter.ratecalcrule.e"/>
					</logic:equal>
					<bean:define id="day" name="AgreementInfoForm" property="ratecalcruledayFrm"/>
					<logic:equal name="AgreementInfoForm" property="ratecalcrule" value="F">
						<bean:message key="label.filter.ratecalcrule.f" arg0="<%= day.toString()%>"/>
					</logic:equal>
					<logic:equal name="AgreementInfoForm" property="ratecalcrule" value="G">
						<bean:message key="label.filter.ratecalcrule.g" arg0="<%= day.toString()%>"/>
					</logic:equal>
					<logic:equal name="AgreementInfoForm" property="ratecalcrule" value="H">
						<bean:message key="label.filter.ratecalcrule.h"/>
					</logic:equal>
					<logic:equal name="AgreementInfoForm" property="ratecalcrule" value="I">
						<bean:message key="label.filter.ratecalcrule.i"/>
					</logic:equal>
				</td>
			</tr>
			<tr class="print">
				<td class="print"><bean:message key="label.filter.ratedelta"/>:</td>
				<td class="print" style="font-weight: bold">
				    <bean:write name="AgreementInfoForm" property="ratedeltaFrm"/>
				</td>
			</tr>
			</logic:present>
		</TABLE>

    </TD>
    </TR>

	<july:separator/>

	<logic:present name="payrulesList">

    <TR class="printable">
		<TD class="printable" colspan="2">
			<table class="print" STYLE="FONT-FAMILY: Arial,Verdana; FONT-SIZE: 8pt;">

				<!-- Table header -->
				<tr class="print" style="background-color: 'D6EBFF'">
					<td class="print" style="font-weight: bold"><bean:message key="label.payrules.paytype"/></td>
					<td class="print" style="font-weight: bold"><bean:message key="label.payrules.ppaytype"/></td>
					<td class="print" style="font-weight: bold"><bean:message key="label.payrules.sum"/></td>
					<td class="print" style="font-weight: bold"><bean:message key="label.payrules.currency"/></td>
					<td class="print" style="font-weight: bold"><bean:message key="label.payrules.period"/></td>
					<td class="print" style="font-weight: bold"><bean:message key="label.payrules.payreceiver"/></td>
					<td class="print" style="font-weight: bold">&nbsp;</td>
					<td class="print" style="font-weight: bold"><bean:message key="label.payrules.paybeforedate"/></td>
				</tr>
				<!-- Table body -->
				<logic:iterate id="pr" name="payrulesList">
					<logic:present name="pr">
						<tr>
							<td class="print">
								<logic:equal name="pr" property="payType" value="P"><bean:message key="label.payrules.paytype.payorder"/></logic:equal>
								<logic:equal name="pr" property="payType" value="M"><bean:message key="label.payrules.paytype.vz"/></logic:equal>
								<logic:equal name="pr" property="payType" value="B"><bean:message key="label.payrules.paytype.acseptNo"/></logic:equal>
							</td>
							<td class="print">
								<logic:present name="pr" property="ppType">
									<logic:equal name="pr" property="ppType" value="A"><bean:message key="label.payrules.ppaytype.advpay"/></logic:equal>
									<logic:equal name="pr" property="ppType" value="B"><bean:message key="label.payrules.ppaytype.account"/></logic:equal>
									<logic:equal name="pr" property="ppType" value="C"><bean:message key="label.payrules.ppaytype.endperiod"/></logic:equal>
								</logic:present>
							</td>
							<td class="print" align="right">
								<july:sumwrite name="pr" property="sum"/>
							</td>
							<td class="print">
								<bean:write name="pr" property="currency.shortname" filter="true"/>
							</td>
							<td class="print">
								<logic:present name="pr" property="payPeriod">
									<logic:equal name="pr" property="payPeriod" value="M"><bean:message key="label.payrules.payperiod.month"/></logic:equal>
									<logic:equal name="pr" property="payPeriod" value="Q"><bean:message key="label.payrules.payperiod.quarter"/></logic:equal>
									<logic:equal name="pr" property="payPeriod" value="Y"><bean:message key="label.payrules.payperiod.year"/></logic:equal>
								</logic:present>
		    	            </td>
 							<td class="print">
								<logic:present name="pr" property="orgToPay">
									<bean:write name="pr" property="orgToPay.name" filter="true"/>
								</logic:present>
			                </td>
							<td class="print" align="right">
								<logic:present name="pr" property="payTerms">
									<img src="/images/doc.gif" border=0 alt='<bean:write name="pr" property="payTerms" filter="true"/>'>
								</logic:present>
							</td>
							<td class="print" align="right">
								<logic:present name="pr" property="payBeforeDate">
									<bean:write name="pr" property="payBeforeDate" filter="true"/>
								</logic:present>
							</td>
		    	        </tr>
			</logic:present>
		</logic:iterate>	
		
	</table>
	    </TD>
    </TR>

	</logic:present>
    
    <july:separator/>
    
    <tr class="title">
    	<td class="title" colspan="2">
          <july:closebutton page="/"/>
          <july:printerbutton/> 
        </td>
    </tr>
    
</table>


</july:editform>



