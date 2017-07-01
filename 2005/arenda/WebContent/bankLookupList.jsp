<%@ page language = "java" %>

<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>

<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>



<% java.lang.String gColSpan = "5"; %>



<july:browseform action="/ShowBankLookupList.do" styleId="BankForm">



<july:lookupresult tableId="brtable" resultCols="1;0;2;3;4"/>



<script language="javascript">

function switchNameSearch(state) {

	if(state) {

		BankForm.bankname.className = 'editdisabled';

		BankForm.bankname.disabled = true;

	} else {

		BankForm.bankname.className = 'editsearch';

		BankForm.bankname.disabled = false;

	}

}

function switchBikSearch(state) {

	if(state) {

		BankForm.bankbik.className = 'editdisabled';

		BankForm.bankbik.disabled = true;

	} else {

		BankForm.bankbik.className = 'editsearch';

		BankForm.bankbik.disabled = false;

	}

}

</script>





<table class="main">

	<TR class="title">

		<TD class="title"><bean:message key="label.choose.bank"/></TD>

	</TR>

	<TR class="normal">

		<TD>

			<table class="find">

				<TR>

					<td class="title"><bean:message key="label.organization.bik"/></td>

					<td class="title">

						<july:checkbox property="isbik" onclick="switchBikSearch(document.all.isbik[0].checked)" insertable="true" updatable="true"/>&nbsp;

						<bean:message key="label.search.all"/>&nbsp;

						<html:text styleClass="search" property="bankbik" size="25"/>

						<july:searchbutton/>

					</td>

				</TR>

				<TR>

					<td class="title"><bean:message key="label.bank.name"/></td>

					<td class="title">

						<july:checkbox property="isname" onclick="switchNameSearch(document.all.isname[0].checked)" insertable="true" updatable="true" />&nbsp;

						<bean:message key="label.search.all"/>&nbsp;

						<html:text styleClass="search" property="bankname" size="25"/>

					</td>

				</TR>

			</table>

		</TD>

	</TR>



<SCRIPT language="javascript">

 switchNameSearch(document.all.isname[0].checked);

 switchBikSearch(document.all.isbik[0].checked);

</SCRIPT>



<tr class="title">

  <td><TABLE class="buttons">

    <TR class="title">

      <TD class="buttons"><july:closebutton page="/"/></TD>

      <TD class="navigator"><july:navigator/></TD>

    </TR>

    </TABLE></TD>

</tr>



<TR>

  <TD>



    <table class="main" id="brtable">



        <!-- Table header -->

        <tr class="title">

            <july:headercolumn key="label.code" colType="number"/>

            <july:headercolumn key="label.organization.bik" colType="string"/>

            <july:headercolumn key="label.name" colType="string"/>

            <july:headercolumn key="label.bank.corraccount" colType="string"/>

            <july:headercolumn key="label.bank.addr" colType="string"/>

        </tr>



        <!-- Table body -->

        <logic:iterate id="org" name="browseList" indexId="index">

	      <logic:present name="org">

            <tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">

                <td class="number"><bean:write name="org" property="organization" filter="true"/></td>

                <td class="text"><bean:write name="org" property="bik" filter="true"/></td>

                <td class="text"><july:lookupreturn><bean:write name="org" property="name" filter="true"/></july:lookupreturn></td>

                <td class="text"><bean:write name="org" property="koraccount" filter="true"/></td>

                <td class="text"><bean:write name="org" property="legaladdress" filter="true"/></td>

				

            </tr>

	      </logic:present>

          

	      <logic:notPresent name="org">

            <tr class="normal">

                <td class="text" colspan="<%= gColSpan %>">

                   <bean:message key="label.norecords"/>

                </td>

            </tr>

	      </logic:notPresent>

          

          <july:separator colspan="<%= gColSpan %>" />

            

        </logic:iterate>



    </table>

</TD>

</TR>



<tr class="title">

  <td><TABLE class="buttons">

    <TR class="title">

      <TD class="buttons"><july:closebutton page="/"/></TD>

      <TD class="navigator"><july:navigator/></TD>

    </TR>

    </TABLE></TD>

</tr>



</TABLE>



</july:browseform>

