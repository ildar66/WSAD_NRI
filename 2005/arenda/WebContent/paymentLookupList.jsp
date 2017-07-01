<%@ page language = "java" %>

<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>

<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>



<% java.lang.String gColSpan = "10"; %>



<july:browseform action="/ShowPaymentLookupList.do" styleId="lform">



<july:lookupresult tableId="brtable" resultCols="0;1;2;6;7;9"/>



<script language="javascript">

function switchDate() {

	if (document.all.isDate[0].checked) {

		lform.fromDate_dt.enabled = false;

		lform.toDate_dt.enabled = false;

	} else {

		lform.fromDate_dt.enabled = true;

		lform.toDate_dt.enabled = true;

	}

}

function switchResource() {

	if (document.all.isResource[0].checked) {

		lform.resources.disabled = true;

		lform.resources.className = 'editdisabled';

	} else {

		lform.resources.disabled = false;

		lform.resources.className = 'edit';

	}

}

</script>



<table class="main">

	<TR class="title">

		<TD class="title"><bean:message key="label.choose.payment"/></TD>

	</TR>

	

	<july:separator colspan="<%= gColSpan %>"/>

	

	<TR class="normal">

		<TD>

			<table class="find">

				<TR>

					<td><bean:message key="label.choose.payment.date"/></td>

					<td>

						<july:checkbox property="isDate" insertable="true" updatable="true" onclick="switchDate()"/>&nbsp;

						<bean:message key="label.search.all"/>&nbsp;

						<july:date property="fromDateFrm" size="25" insertable="true" updatable="true" styleId="fromDate"/>&nbsp;

						<bean:message key="label.filter.stop"/>&nbsp;

						<july:date property="toDateFrm" size="25" insertable="true" updatable="true" styleId="toDate"/>&nbsp;

						<july:searchbutton/>

					</td>

					<%--td><html:text styleClass="search" property="lastname" size="25"/><july:searchbutton/></td--%>

				</tr>

				<tr>

					<td><bean:message key="label.choose.payment.resource"/></td>

					<td>

						<july:checkbox property="isResource" insertable="true" updatable="true" onclick="switchResource()"/>&nbsp;

						<bean:message key="label.search.all"/>&nbsp;

					    <july:select style="width: 450;" collection="resources" property="resourcecode" insertable="true" updatable="true" styleId="resources">

							<html:options collection="resources" property="resource" labelProperty="name"/>

					   	</july:select>

					</td>

				</tr>

			</table>

		</TD>

	</TR>



	<tr class="title"><td><TABLE class="buttons"><TR class="title"><TD class="buttons"><july:closebutton page="/"/></TD><TD class="navigator"><july:navigator/></TD></TR></TABLE></TD></tr>



	<TR>

		<TD>

			<table class="main" id="brtable">

	        <!-- Table header -->

				<tr class="title">

					<td class="title" style="visibility:hidden;display:none;">&nbsp;</td>

					<july:headercolumn key="label.choose.payment.date" colType="number"/>

					<july:headercolumn key="label.choose.payment.number" colType="string"/>

					<july:headercolumn key="label.choose.payment.receiver" colType="string"/>

					<july:headercolumn key="label.choose.payment.purpose" colType="string"/>

					<july:headercolumn key="label.choose.payment.resource" colType="string"/>

					<july:headercolumn key="label.choose.payment.sumrur" colType="string"/>

					<july:headercolumn key="label.choose.payment.remainderrur" colType="string"/>

					<july:headercolumn key="label.choose.payment.remainder" colType="string"/>

					<july:headercolumn key="label.choose.payment.rate" colType="string"/>

				</tr>

				

		        <!-- Table body -->

				<logic:iterate id="it" name="browseList" indexId="index">

					<logic:present name="it">

						<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">

							<td class="number" style="visibility:hidden;display:none;"><bean:write name="it" property="o.leaseDocPosition"/></td>

							<td class="text"><july:lookupreturn><july:datewrite name="it" property="o.date"/></july:lookupreturn></td>

							<td class="text"><bean:write name="it" property="o.docNumber" filter="true"/></td>

							<td class="text"><bean:write name="it" property="orgExecutor.name" filter="true"/></td>

							<td class="text"><bean:write name="it" property="payPurpose" filter="true"/></td>

							<td class="text"><bean:write name="it" property="o.resource.name" filter="true"/></td>

							<td class="number"><bean:write name="it" property="o.sumRub" filter="true"/></td>

							<td class="number"><bean:write name="it" property="o.rurremainder" filter="true"/></td>

							<td class="number"><%--july:sumwrite name="it" property="rurremainder"/--%></td>

							<td class="number"><bean:write name="it" property="rate" filter="true"/></td>

						</tr>

					</logic:present>

					<logic:notPresent name="it">

						<tr class="normal">

							<td class="text" colspan="<%= gColSpan %>"><bean:message key="label.norecords"/></td>

						</tr>

					</logic:notPresent>

					

					<july:separator colspan="<%= gColSpan %>"/>

				</logic:iterate>

			</table>

		</TD>

	</TR>



	<tr class="title">

		<td>

			<TABLE class="buttons">

				<TR class="title">

					<TD class="buttons"><july:closebutton page="/"/></TD>

					<TD class="navigator"><july:navigator/></TD>

				</TR>

			</TABLE>

		</TD>

	</tr>



</TABLE>



<script language="javascript">

	switchDate();

	switchResource();

</script>



</july:browseform>

