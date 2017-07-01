<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<html:form action="/CWA_Charges_Print.do">


<table class="main">
    <tr class="title">
        <td class="title">
          <july:closebutton page="/"/>
          <july:printerbutton/>
        </td>
    </tr>

	<july:separator/>

    <tr class="printable">
	    <td class="printable" style="font-size: 10pt">
	        <TABLE class="print" style="border-color: black; border-width: 2; border-collapse:collapse;" border="1">
				<TR>
					<th>Услуга</th>
					<th>Сумма</th>
					<th>НДС</th>
					<th>Валюта</th>
					<th>Курс</th>
					<th>Дата начала</th>
					<th>Дата окончания</th>
					<th>Номер счета</th>
				</TR>
				<logic:iterate id="it" name="CWA_Charges_PrintForm" property="list" type="com.hps.july.arenda.valueobject.LeaseChargeVO">
				<logic:present name="it">
		        <TR>
		            <td><bean:write name="it" property="resource.name" filter="true"/></td>
					<td align="right"><july:sumwrite name="it" property="summ"/></td>
		            <td align="right"><july:sumwrite name="it" property="sumnds"/></td>
		            <td><bean:write name="it" property="currency.shortname" filter="true"/></td>
		            <td align="right"><july:numberwrite name="it" property="rate" fractdigits="4"/></td>
		            <td><july:datewrite name="it" property="begindate"/></td>
		            <td><july:datewrite name="it" property="enddate"/></td>
		            <td><bean:write name="it" property="billnumber" filter="true"/></td>
				</TR>
				</logic:present>
				</logic:iterate>
			</TABLE>
		</td>
	</tr>

	<july:separator/>

	<tr class="title">
    	<td class="title">
          <july:closebutton page="/"/>
          <july:printerbutton/> 
        </td>
    </tr>

</table>

</html:form>
