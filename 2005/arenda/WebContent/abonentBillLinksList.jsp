<%@ page language = "java" %>

<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>

<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>



<% java.lang.String gColSpan = "8"; %>



<july:browseform action="/ShowAbonentBillLinksList.do" styleId="AbonentBillLinksList">



<script language="javascript">

function switchItem(itemname, state) {

	if (state) {

		AbonentBillLinksList[itemname].disabled = false;

		AbonentBillLinksList[itemname].className = 'editsearch';

	} else {

		AbonentBillLinksList[itemname].disabled = true;

		AbonentBillLinksList[itemname].className = 'editdisabled';

	}

}

function switchName() {

	switchItem('name', !AbonentBillLinksList.isName[0].checked);

}

function switchCode() {

	switchItem('code', !AbonentBillLinksList.isCode[0].checked);

}

</script>



<table class="main">

<%--
<TR class="title">

		<TD class="title">

			<july:currmark><bean:message key="label.bill.link"/></july:currmark>

		</TD>

	</TR>
--%>

	

	<july:separator colspan="<%= gColSpan %>"/>

	

	<TR class="normal">

		<td>

			<table class="find" >

				<tr>

					<td class="title"><bean:message key="label.resource.byname"/>:</td>

					<td class="title">

						<july:checkbox property="isName" insertable="true" updatable="true" value="true" onclick="switchName();"/>

						<bean:message key="label.search.all"/>

						<july:string size="50" property="name" styleId="name" insertable="true" updatable="true" styleClass="search"/>

						<july:searchbutton/>

					</td>

				</tr>

				<tr>

					<td class="title"><bean:message key="label.resource.bymanucode"/>:</td>

					<td class="title">

						<july:checkbox property="isCode" insertable="true" updatable="true" value="true" onclick="switchCode();"/>

						<bean:message key="label.search.all"/>

						<july:string size="50" property="code" styleId="code" insertable="true" updatable="true" styleClass="search"/>

					</td>

				</tr>

				<tr>

					<td class="title">&nbsp;</td>

					<td class="title" nowrap colspan="2">

						<july:radio property="state" insertable="true" updatable="true" value="1"/><bean:message key="label.filter.all"/>

						<july:radio property="state" insertable="true" updatable="true" value="2"/><bean:message key="label.filter.connected"/>

						<july:radio property="state" insertable="true" updatable="true" value="3"/><bean:message key="label.filter.notconnected"/>

					</td>

				</tr>

			</table>

		</td>

	</tr>



<script language="javascript">

	switchName();

	switchCode();

</script>



	<july:separator colspan="<%= gColSpan %>"/>

	

	<tr class="title">

		<td colspan="<%= gColSpan %>">

			<TABLE class="buttons">

				<TR class="title">

					<TD class="buttons"><july:backbutton page="/main.do"/></TD>

					<TD class="navigator"><july:navigator/></TD>

				</TR>

            </TABLE>

		</TD>

	</tr>

  

	<july:separator colspan="<%= gColSpan %>"/>



	<tr>

		<td>

			<table class="main" id="brtable">



		        <!-- Table header -->

				<tr class="title">

					<td colspan="3" class="title" align="center"><B><bean:message key="label.bill.resource.billing"/></B></td>

					<td colspan="5" class="title" align="center"><B><bean:message key="label.bill.resource.nri"/></B></td>

				</tr>

				

				<july:separator colspan="<%= gColSpan %>"/>

    			

				<tr class="title">

					<july:headercolumn key="label.code" colType="string"/>

					<july:headercolumn key="label.name" colType="string"/>

					<td class="title">&nbsp;</td>

					<td class="title">&nbsp;</td>

					<july:headercolumn key="label.resource.code" colType="number"/>

					<july:headercolumn key="label.resource.model" colType="string"/>

					<july:headercolumn key="label.resource.name" colType="string"/>

					<td class="title">&nbsp;</td>

				</tr>

				

				<july:separator colspan="<%= gColSpan %>"/>

				

				<!-- Table body -->

				<logic:iterate id="rstl" name="browseList" indexId="index">

					<logic:present name="rstl">

						

						<tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">

							<td class="text"><bean:write name="rstl" property="idresbilling" filter="true"/></td>

							<td class="text"><bean:write name="rstl" property="billresname" filter="true"/></td>

							<td class="text" title="<logic:equal name="rstl" property="record_status" value="A"><bean:message key="label.bill.resource.recordstatus.active"/></logic:equal><logic:equal name="rstl" property="record_status" value="D"><bean:message key="label.bill.resource.recordstatus.delete"/></logic:equal>">

								<logic:equal name="rstl" property="record_status" value="A">A</logic:equal>

							</td>

							

							<td class="text" align="center">

								<july:canedit rolesProperty="editRoles">

									<html:link page="/EditAbonentBillLink.do?action=Edit" paramId="idrecord" paramName="rstl" paramProperty="idrecord" paramScope="page">

										<img src="/images/link.gif" border=0 alt="<bean:message key="label.edit.link"/>">

									</html:link>

								</july:canedit>

							</td>

							

							<logic:present name="rstl" property="leaseResBil">

								<td class="number"><bean:write name="rstl" property="leaseResBil.resource" filter="true"/></td>

								<td class="text"><bean:write name="rstl" property="leaseResBil.model" filter="true"/></td>

								<td class="text"><bean:write name="rstl" property="leaseResBil.name" filter="true"/></td>

								<td class="text" align="center">

									<july:canedit rolesProperty="editRoles">

										<html:link page="/EditAbonentBillLink.do?action=Delete" paramId="idrecord" paramName="rstl" paramProperty="idrecord" paramScope="page">

											<img src="/images/breaklink.gif" border=0 alt="<bean:message key="label.delete.link"/>">

										</html:link>

									</july:canedit>

								</td>

							</logic:present>

							

							<logic:notPresent name="rstl" property="leaseResBil">

								<td class="number">&nbsp;</td>

								<td class="text">&nbsp;</td>

								<td class="text">&nbsp;</td>

								<td class="text" align="center">&nbsp;</td>

							</logic:notPresent>

							

						</tr>

					

					</logic:present>

					

					<logic:notPresent name="rstl">

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

		<td colspan="<%= gColSpan %>">

			<TABLE class="buttons">

				<TR class="title">

					<TD class="buttons"><july:backbutton page="/main.do"/></TD>

					<TD class="navigator"><july:navigator/></TD>

				</TR>

            </TABLE>

		</TD>

	</tr>

	

	<july:separator colspan="<%= gColSpan %>"/>

      

<%--
<TR class="title">

		<TD class="title">

			<july:currmark><bean:message key="label.bill.link"/></july:currmark>

		</TD>

	</TR>
--%>



</TABLE>

    

</july:browseform>

