<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>


<july:editform action="/OrganizationInfo.do">


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
    
        <table class="print">

			<tr class="print">
				<td class="print"><bean:message key="label.print.org.shortname"/></td>
				<td class="print" style="font-weight: bold">
				   <bean:write name="OrganizationPrintForm" property="shortname"/>
				</td>
			</tr>

			<tr class="print">
				<td class="print"><bean:message key="label.print.org.name"/></td>
				<td class="print" style="font-weight: bold">
				   <bean:write name="OrganizationPrintForm" property="name"/>
				</td>
			</tr>

			<tr class="print">
				<td class="print"><bean:message key="label.print.org.inn"/></td>
				<td class="print" style="font-weight: bold">
				   <bean:write name="OrganizationPrintForm" property="inn"/>
				</td>
			</tr>

			<tr class="print">
				<td class="print"><bean:message key="label.print.org.kpp"/></td>
				<td class="print" style="font-weight: bold">
				   <bean:write name="OrganizationPrintForm" property="kpp"/>
				</td>
			</tr>

			<tr class="print">
				<td class="print"><bean:write name="OrganizationPrintForm" property="managerposition"/></td>
				<td class="print" style="font-weight: bold">
				   <bean:write name="OrganizationPrintForm" property="managername"/>
				</td>
			</tr>

			<tr class="print">
				<td class="print"><bean:message key="label.print.org.accounter"/></td>
				<td class="print" style="font-weight: bold">
				   <bean:write name="OrganizationPrintForm" property="accountername"/>
				</td>
			</tr>

			<tr class="print">
				<td class="print"><bean:message key="label.print.org.billaddress"/></td>
				<td class="print" style="font-weight: bold">
				   <bean:write name="OrganizationPrintForm" property="billaddress"/>
				</td>
			</tr>

			<tr class="print">
				<td class="print"><bean:message key="label.print.org.phones"/></td>
				<td class="print" style="font-weight: bold">
				   <bean:write name="OrganizationPrintForm" property="phones"/>
				</td>
			</tr>

			<tr class="print">
				<td class="print"><bean:message key="label.print.org.contactinfo"/></td>
				<td class="print" style="font-weight: bold">
				   <bean:write name="OrganizationPrintForm" property="contactinfo"/>
				</td>
			</tr>

		</TABLE>

    </TD>
    </TR>
    
    <july:separator/>
    
    <tr class="title">
    	<td class="title" colspan="2">
          <july:closebutton page="/"/>
          <july:printerbutton/> 
        </td>
    </tr>
    
    <july:separator/>
    
</table>


</july:editform>



