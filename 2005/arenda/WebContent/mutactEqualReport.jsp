<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>


<table class="main">
	<tr class="normal">
		<td class="text">&nbsp;</td>
	</tr>
	<tr class="normal">
		<td class="text">
			<html:link page="/../crystalclear/AktReport.rpt?dll=pdsaktreport.dll" paramId="prompt0" paramName="MutactEqualReportForm" paramProperty="leaseDocument" paramScope="request">
				<bean:message key="label.mutualacts.print"/>
			</html:link>
		</td>
	</tr>
	<tr class="normal">
		<td class="text">
			<html:link page="/MutactCalcReport.do" paramId="leaseDocument" paramName="MutactEqualReportForm" paramProperty="leaseDocument" paramScope="request">
				<bean:message key="label.mutualacts.print.equalsact"/>
			</html:link>
		</td>
	</tr>
	<tr class="normal">
		<td class="text">
			<html:link page="/../crystalclear/AktMutual.rpt?dll=pdsactmutual.dll" paramId="prompt0" paramName="MutactEqualReportForm" paramProperty="leaseDocument" paramScope="request">
				<bean:message key="label.mutualacts.print.mutualact"/>
			</html:link>
		</td>
	</tr>
	<tr class="normal">
		<td class="text">
			<html:link page="/../crystalclear/AktAccMutual.rpt?dll=pdsactaccmutual.dll" paramId="prompt0" paramName="MutactEqualReportForm" paramProperty="leaseDocument" paramScope="request">
				<bean:message key="label.mutualacts.print.actaccmutual"/>
			</html:link>
		</td>
	</tr>
	<tr class="normal">
		<td class="text">&nbsp;</td>
	</tr>
</table>

