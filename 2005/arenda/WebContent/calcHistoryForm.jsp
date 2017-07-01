<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<html:form action="/ShowCalcHistoryReport.do">

<html:hidden property="leaseDocument"/>

<table class="main">

<tr class="title">

		<td class="title"><bean:message key="label.calchistory.period"/></td>

	</tr>

	
	<july:separator/>

	<tr class="title">
		<td><TABLE class="buttons"><TR class="title"><TD class="buttons"><july:closebutton page="/"/></TD></TR></TABLE></TD>
	</tr>

	<july:separator/>

	<tr class="normal">
		<td class="text">
			<html:radio name="CalcHistoryForm" property="countRecord" value="1"/><bean:message key="label.calchistory.records.all"/><br>
			<html:radio name="CalcHistoryForm" property="countRecord" value="2"/><bean:message key="label.calchistory.records.currentyear"/><br>
			<html:radio name="CalcHistoryForm" property="countRecord" value="3"/><bean:message key="label.calchistory.records.lastyear"/>
		</td>
	</tr>
	

	<july:separator/>

	

	<tr class="normal">

		<td class="text">

			<html:radio name="CalcHistoryForm" property="reportType" value="1"/><bean:message key="label.calchistory.report.short"/><br>

			<html:radio name="CalcHistoryForm" property="reportType" value="2"/><bean:message key="label.calchistory.report.full"/>

		</td>

	</tr>

	

	<july:separator/>

	

	<tr class="normal">

		<td class="text">

			<INPUT TYPE="IMAGE" NAME="submit" SRC="/images/refresh.gif" ALT="<bean:message key="button.refresh"/>">

		</td>

	</tr>

	

	<july:separator/>

	

	<tr class="normal">

		<td class="text">&nbsp;</td>

	</tr>

	

	<july:separator/>

	

	<tr class="title">
		<td><TABLE class="buttons"><TR class="title"><TD class="buttons"><july:closebutton page="/"/></TD></TR></TABLE></TD>
	</tr>

	<july:separator/>
	

</table>
</html:form>
