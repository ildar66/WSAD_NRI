<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>


<july:editform action="/AbonentInfo.do">


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
				<td class="print">Номер абоненсткого договора (BAN): </td>
				<td class="print" style="font-weight: bold">
					<bean:write name="AbonentInfoForm" property="abonent.ban"/>
					от <bean:write name="AbonentInfoForm" property="docdateStr"/>
				</td>
			</tr>

			<tr class="print">
				<td class="print">Организация исполнитель:</td>
				<td class="print" style="font-weight: bold">
				   <bean:write name="AbonentInfoForm" property="abonent.orgExecutor.name"/>
				</td>
			</tr>

			<tr class="print">
				<td class="print">Организация заказчик:</td>
				<td class="print" style="font-weight: bold">
				   <bean:write name="AbonentInfoForm" property="abonent.orgCustomer.name"/>
				</td>
			</tr>

			<tr class="print">
				<td class="print">Основная позиция:</td>
				<td class="print" style="font-weight: bold" nowrap>
					<bean:write name="AbonentInfoForm" property="abonent.mainpositionVO.name"/>&nbsp;
				</td>
			</tr>

			<tr class="print">
				<td class="print">Ответственный экономист:</td>
				<td class="print" style="font-weight: bold">
					<bean:write name="AbonentInfoForm" property="abonent.economistVO.name"/>	
				</td>
			</tr>

			<tr class="print">
				<td class="print">Ответственный менеджер:</td>
				<td class="print" style="font-weight: bold">
				   <bean:write name="AbonentInfoForm" property="abonent.managerVO.name"/>
				</td>
			</tr>

			<tr class="print">
				<td class="print">Признак учета во взаимозачетах:</td>
				<td class="print" style="font-weight: bold">
				   <logic:equal name="AbonentInfoForm" property="abonent.useinacts" value="true">
						ДА
				   </logic:equal>
				   <logic:equal name="AbonentInfoForm" property="abonent.useinacts" value="false">
						НЕТ
				   </logic:equal>
				</td>
			</tr>
			
			<tr class="print">
				<td class="print">Тип обработки:</td>
				<td class="print" style="font-weight: bold">
					<%--july:select style="width: 350;" property="abonent.proctype" styleId="proctype" insertable="false" updatable="false">
						<html:option value=""/>
						<html:option key="label.filter.proctype.a" value="A"/>
						<html:option key="label.filter.proctype.b" value="B"/>
						<html:option key="label.filter.proctype.c" value="C"/>
						<html:option key="label.filter.proctype.d" value="D"/>
						<html:option key="label.filter.proctype.e" value="E"/>
					</july:select--%>
					<logic:present name="AbonentInfoForm" property="abonent.proctype">
		   				<logic:equal name="AbonentInfoForm" property="abonent.proctype" value="A">
							<bean:message key="label.filter.proctype.a"/>
						</logic:equal>
						<logic:equal name="AbonentInfoForm" property="abonent.proctype" value="B">
							<bean:message key="label.filter.proctype.b"/>
						</logic:equal>
						<logic:equal name="AbonentInfoForm" property="abonent.proctype" value="C">
							<bean:message key="label.filter.proctype.c"/>
						</logic:equal>
						<logic:equal name="AbonentInfoForm" property="abonent.proctype" value="D">
							<bean:message key="label.filter.proctype.d"/>
						</logic:equal>
						<logic:equal name="AbonentInfoForm" property="abonent.proctype" value="E">
							<bean:message key="label.filter.proctype.e"/>
						</logic:equal>
					</logic:present>							   
				</td>
			</tr>
			
			
			<tr class="print">
				<td class="print">Признак технического договора:</td>
				<td class="print" style="font-weight: bold">
				   <logic:equal name="AbonentInfoForm" property="abonent.techcontract" value="true">
						ДА
				   </logic:equal>
				   <logic:equal name="AbonentInfoForm" property="abonent.techcontract" value="false">
						НЕТ
				   </logic:equal>
				</td>
			</tr>
			
			<tr class="print">
				<td class="print">Учитывать все BEN:</td>
				<td class="print" style="font-weight: bold">
				   <logic:equal name="AbonentInfoForm" property="abonent.useallben" value="true">
						ДА
				   </logic:equal>
				   <logic:equal name="AbonentInfoForm" property="abonent.useallben" value="false">
						НЕТ
				   </logic:equal>
				</td>
			</tr>
			
			<tr class="print">
				<td class="print">Получать данные по данному BAN из Billing:</td>
				<td class="print" style="font-weight: bold">
				   <logic:equal name="AbonentInfoForm" property="abonent.flagworkpie" value="true">
						ДА
				   </logic:equal>
				   <logic:equal name="AbonentInfoForm" property="abonent.flagworkpie" value="false">
						НЕТ
				   </logic:equal>
				</td>
			</tr>									
<%--
			<july:canedit rolesProperty="arendaMoneyRoles">
			<tr class="print">
				<td class="print"><bean:message key="label.filter.costcurrency1"/>:</td>
				<td class="print" style="font-weight: bold">
					<july:sumwrite name="AbonentInfoForm" property="summ1"/>
				    <bean:write name="AbonentInfoForm" property="currency1.shortname"/>
				</td>
			</tr>

			<logic:present name="AbonentInfoForm" property="summ2">
			<logic:notEqual name="AbonentInfoForm" property="summ2Frm" value="0">
			<tr class="print">
				<td class="print"><bean:message key="label.filter.costcurrency2"/>:</td>
				<td class="print" style="font-weight: bold">
					<july:sumwrite name="AbonentInfoForm" property="summ2"/>
				    <bean:write name="AbonentInfoForm" property="currency2.shortname"/>
				</td>
			</tr>
			</logic:notEqual>
			</logic:present>
			</july:canedit>

			<tr class="print">
				<td class="print"><bean:message key="label.filter.extendtype"/>:</td>
				<td class="print" style="font-weight: bold">
				<logic:present name="AbonentInfoForm" property="extendType">
	   				<logic:equal name="AbonentInfoForm" property="extendType" value="N">
						<bean:message key="label.extendtype.not"/>
					</logic:equal>
					<logic:equal name="AbonentInfoForm" property="extendType" value="A">
						<bean:message key="label.extendtype.auto"/>
					</logic:equal>
					<logic:equal name="AbonentInfoForm" property="extendType" value="M">
						<bean:message key="label.extendtype.addAbonent"/>
					</logic:equal>
				</logic:present>
				</td>
			</tr>

			<logic:equal name="AbonentInfoForm" property="extendType" value="A">
			<tr class="print">
				<td class="print"><bean:message key="label.filter.extendperiod"/>:</td>
				<td class="print" style="font-weight: bold">
					<logic:present name="AbonentInfoForm" property="extendPeriod">
						<logic:equal name="AbonentInfoForm" property="extendPeriod" value="Y">
							<bean:message key="label.extendperiod.year"/>
						</logic:equal>
						<logic:equal name="AbonentInfoForm" property="extendPeriod" value="M">
							<bean:message key="label.extendperiod.month"/>
						</logic:equal>
						<logic:equal name="AbonentInfoForm" property="extendPeriod" value="D">
							<bean:message key="label.extendperiod.day"/>
						</logic:equal>
					</logic:present>
				</td>
			</tr>
			</logic:equal>

			<tr class="print">
				<td class="print"><bean:message key="label.filter.calcelectrotype"/>:</td>
				<td class="print" style="font-weight: bold">
				<logic:present name="AbonentInfoForm" property="calcElectroType">
	    			<logic:equal name="AbonentInfoForm" property="calcElectroType" value="1">
						<bean:message key="label.calcelectrotype.contract"/>
					</logic:equal>
					<logic:equal name="AbonentInfoForm" property="calcElectroType" value="2">
						<bean:message key="label.calcelectrotype.arendapay"/>
					</logic:equal>
					<logic:equal name="AbonentInfoForm" property="calcElectroType" value="3">
						<bean:message key="label.calcelectrotype.accounts"/>	
					</logic:equal>
				</logic:present>
				</td>
			</tr>

			<logic:present name="AbonentInfoForm" property="dogelectonum">
			<logic:notEqual name="AbonentInfoForm" property="dogelectonum" value="">
			<tr class="print">
				<td class="print"><bean:message key="label.filter.isdogelectro.number"/>:</td>
				<td class="print" style="font-weight: bold">
				    №  <bean:write name="AbonentInfoForm" property="dogelectonum"/>&nbsp;
					от <bean:write name="AbonentInfoForm" property="dogelectrodateFrm"/>
				</td>
			</tr>
			</logic:notEqual>
			</logic:present>

			<tr class="print">
				<td class="print"><bean:message key="label.filter.economist"/>:</td>
				<td class="print" style="font-weight: bold">
				    <bean:write name="AbonentInfoForm" property="mainEconomistName"/>
				</td>
			</tr>

			<tr class="print">
				<td class="print"><bean:message key="label.table.mainmanager"/>:</td>
				<td class="print" style="font-weight: bold">
				    <bean:write name="AbonentInfoForm" property="mainManagerName"/>
				</td>
			</tr>

			<tr class="print">
				<td class="print"><bean:message key="label.filter.doccomment"/>:</td>
				<td class="print" style="font-weight: bold">
				    <bean:write name="AbonentInfoForm" property="comment"/>
				</td>
			</tr>
			
			<logic:present name="AbonentInfoForm" property="ratecalcrule">
			<tr class="print">
				<td class="print"><bean:message key="label.filter.ratecalcrule"/>:</td>
				<td class="print" style="font-weight: bold">
					<logic:equal name="AbonentInfoForm" property="ratecalcrule" value="A">
						<bean:message key="label.filter.ratecalcrule.a"/>
					</logic:equal>
					<logic:equal name="AbonentInfoForm" property="ratecalcrule" value="B">
						<bean:message key="label.filter.ratecalcrule.b"/>
					</logic:equal>
					<logic:equal name="AbonentInfoForm" property="ratecalcrule" value="C">
						<bean:message key="label.filter.ratecalcrule.c"/>
					</logic:equal>
					<logic:equal name="AbonentInfoForm" property="ratecalcrule" value="D">
						<bean:message key="label.filter.ratecalcrule.d"/>
					</logic:equal>
					<logic:equal name="AbonentInfoForm" property="ratecalcrule" value="E">
						<bean:message key="label.filter.ratecalcrule.e"/>
					</logic:equal>
					<bean:define id="day" name="AbonentInfoForm" property="ratecalcruledayFrm"/>
					<logic:equal name="AbonentInfoForm" property="ratecalcrule" value="F">
						<bean:message key="label.filter.ratecalcrule.f" arg0="<%= day.toString()%>"/>
					</logic:equal>
					<logic:equal name="AbonentInfoForm" property="ratecalcrule" value="G">
						<bean:message key="label.filter.ratecalcrule.g" arg0="<%= day.toString()%>"/>
					</logic:equal>
					<logic:equal name="AbonentInfoForm" property="ratecalcrule" value="H">
						<bean:message key="label.filter.ratecalcrule.h"/>
					</logic:equal>
					<logic:equal name="AbonentInfoForm" property="ratecalcrule" value="I">
						<bean:message key="label.filter.ratecalcrule.i"/>
					</logic:equal>
				</td>
			</tr>
			<tr class="print">
				<td class="print"><bean:message key="label.filter.ratedelta"/>:</td>
				<td class="print" style="font-weight: bold">
				    <bean:write name="AbonentInfoForm" property="ratedeltaFrm"/>
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
--%>		
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



