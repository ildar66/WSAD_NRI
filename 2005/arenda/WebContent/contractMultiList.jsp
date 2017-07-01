<%@ page language = "java" %>
<%@ page import="org.apache.struts.util.*" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "10"; %>

<july:browseform action="/ShowContractMultiList.do" styleId="ContractMultiListForm">

<script language="javascript">

function switchCustomer() {

	if (document.all.isCustomer[0].checked) { // use not [0] -> styleId in checkBox

		ContractMultiListForm.customercode.className = 'editkoddisabled';

		ContractMultiListForm.customercode.disabled = true;

		document.all['lookupimg_custl'].src='/images/lookup_disabled.gif';

	} else {

		ContractMultiListForm.customercode.className = 'editkodsearch';

		ContractMultiListForm.customercode.disabled = false;

		document.all['lookupimg_custl'].src='/images/lookup.gif';

	}

}

function switchExecutor() {

	if (document.all.isExecutor[0].checked) {

		ContractMultiListForm.executorcode.className = 'editkoddisabled';

		ContractMultiListForm.executorcode.disabled = true;

		document.all['lookupimg_execl'].src='/images/lookup_disabled.gif';

	} else {

		ContractMultiListForm.executorcode.className = 'editkodsearch';

		ContractMultiListForm.executorcode.disabled = false;

		document.all['lookupimg_execl'].src='/images/lookup.gif';

	}

}

function switchEconomist() {

	if (document.all.isEconomist[0].checked) {

		ContractMultiListForm.economistcode.className = 'editkoddisabled';

		ContractMultiListForm.economistcode.disabled = true;

		document.all['lookupimg_economistl'].src='/images/lookup_disabled.gif';

	} else {

		ContractMultiListForm.economistcode.className = 'editkodsearch';

		ContractMultiListForm.economistcode.disabled = false;

		document.all['lookupimg_economistl'].src='/images/lookup.gif';

	}

}

function switchDocnumber() {

	if (document.all.isDocnumber[0].checked) {

		ContractMultiListForm.docnumber.className = 'editdisabled';

		ContractMultiListForm.docnumber.disabled = true;

	} else {

		ContractMultiListForm.docnumber.className = 'editsearch';

		ContractMultiListForm.docnumber.disabled = false;

	}

}

</script>



<table class="main">

<%--
<tr class="title">

	<td class="title" colspan="<%= gColSpan %>">

		<html:link page="/ShowMutualReglamentsList.do" styleClass="navigator"><bean:message key="label.mutualreglmnts"/></html:link>

		<july:sepmark/>

		<july:editlink page="/ViewMainParamsMutReglmnt.do" action="View" paramId="leaseDocument" paramName="ContractMultiListForm" paramProperty="mainLeaseDocumentcode" styleClass="navigator">

			<bean:message key="label.view"/>

		</july:editlink>

		<july:sepmark/>

		<html:link page="/ShowContractsMutReglmntList.do" styleClass="navigator"><bean:message key="label.contractsmutreglmnt"/></html:link>

		<july:sepmark/>

		<july:currmark><bean:message key="label.addcontract"/></july:currmark>

	</td>

</tr>
--%>



<july:separator colspan="<%= gColSpan %>"/>



<TR class="normal">

 <TD colspan="<%= gColSpan %>">

 

    <table class="find">

		<tr>

			<td><bean:message key="label.contracttype"/></td>

			<td class="text" nowrap> <!-- colspan="5" -->

		   		<july:radio styleId="state1" property="contracttype" insertable="true" updatable="true" value="A"/><bean:message key="label.contracttype.arenda"/>

				<july:radio styleId="state2" property="contracttype" insertable="true" updatable="true" value="B"/><bean:message key="label.contracttype.arendaus"/>

				<july:radio styleId="state3" property="contracttype" insertable="true" updatable="true" value="C"/><bean:message key="label.contracttype.user"/>

				<july:radio styleId="state4" property="contracttype" insertable="true" updatable="true" value="D"/><bean:message key="label.contracttype.channel"/>

				<july:searchbutton/>

			</td>

		</tr>

		

		<tr>

			<td class="text"><bean:message key="label.filter.customer"/></td>

			<td class="text" nowrap>

				<july:checkbox property="isCustomer" insertable="true" updatable="true" onclick="switchCustomer()"/>

				<bean:message key="label.filter.all"/>

				<july:string property="customercode" styleId="customercode" size="5" insertable="true" updatable="true"/>

				<july:lookupbutton action="/ShowOrganizationLookupList.do" styleId="custl" fieldNames="customercode;customername" newWindowName="CustLookup" insertable="true" updatable="true" onclick="if (document.all.isCustomer[0].checked) { return false; }"/>

				<july:string size="50" property="customername" styleId="customername" insertable="false" updatable="false"/>

			</td>

		</tr>

		

		<tr>

			<td class="text"><bean:message key="label.filter.executor"/></td>

			<td class="text" nowrap>

				<july:checkbox property="isExecutor" insertable="true" updatable="true" onclick="switchExecutor()"/>

				<bean:message key="label.filter.all"/>

				<july:string property="executorcode" styleId="executorcode" size="5" insertable="true" updatable="true"/>

				<july:lookupbutton action="/ShowOrganizationLookupList.do" styleId="execl" fieldNames="executorcode;executorname" newWindowName="ExecLookup" insertable="true" updatable="true" onclick="if (document.all.isExecutor[0].checked) { return false; }"/>

				<july:string size="50" property="executorname" styleId="executorname" insertable="false" updatable="false"/>

			</td>

		</tr>

		

		<tr>

			<td class="text"><bean:message key="label.filter.responsible"/></td>

			<td class="text" nowrap>

				<july:checkbox property="isEconomist" insertable="true" updatable="true" onclick="switchEconomist()"/>

				<bean:message key="label.filter.all"/>

				<july:string property="economistcode" styleId="economistcode" size="5" insertable="true" updatable="true"/>

				<july:lookupbutton action="/ShowWorkerLookupList.do" styleId="economistl" fieldNames="economistcode;economistname" newWindowName="EconLookup" insertable="true" updatable="true" onclick="if (document.all.isEconomist[0].checked) { return false; }"/>

				<july:string size="50" property="economistname" styleId="economistname" insertable="false" updatable="false"/>

			</td>

		</tr>

		

		<tr>

			<td class="text"><bean:message key="label.filter.docnumber"/></td>

			<td class="text">

				<july:checkbox property="isDocnumber" insertable="true" updatable="true" onclick="switchDocnumber()"/>

				<bean:message key="label.filter.all"/>

				<july:string size="50" property="docnumber" styleId="docnumber" insertable="true" updatable="true"/>

			</td>

		</tr>

	</table>

    

  </TD>

</TR>



<script language="javascript">

	switchCustomer();

	switchExecutor();

	switchEconomist();

	switchDocnumber();

</script>



<july:separator colspan="<%= gColSpan %>"/>



      <tr class="title">

          <td colspan="<%= gColSpan %>"><TABLE class="buttons">

            <TR class="title">

              <TD class="buttons"><july:savebutton/><july:backbutton page="/ShowContractsMutReglmntList.do"/></TD>

              <TD class="navigator"><july:navigator/></TD>

            </TR>

            </TABLE></TD>

      </tr>

      

      <july:separator colspan="<%= gColSpan %>"/>

  

    <!-- Table header -->

    <tr class="title">

		<july:headercolumn key="label.code" colType="number"/>

		<july:headercolumn key="label.table.docnumber" colType="string"/>

		<july:headercolumn key="label.table.docdate" colType="date"/>

		<july:headercolumn key="label.table.startdate" colType="date"/>

		<july:headercolumn key="label.table.finishdate" colType="date"/>

		<july:headercolumn key="label.filter.customer" colType="date"/>

		<july:headercolumn key="label.filter.executor" colType="date"/>

		<july:headercolumn key="label.table.sumofcontract" colType="string"/>

		<july:headercolumn key="label.table.sumofcontract" colType="string"/>

		<td class="title">&nbsp;</td>

    </tr>



	<july:separator colspan="<%= gColSpan %>"/>



        <!-- Table body -->

    <logic:iterate id="it" name="browseList">

        <logic:present name="it">

            <tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">

				<td class="number"><bean:write name="it" property="leaseDocument" filter="true"/></td>

				

				<logic:equal name="ContractMultiListForm" property="contracttype" value="A">

	                <td class="text"><bean:write name="it" property="mainDocumentNumber" filter="true"/></td>

    	            <td class="date"><july:datewrite name="it" property="mainDocumentDate"/></td>

        	        <td class="date"><july:datewrite name="it" property="mainStartDate"/></td>

					<td class="date"><july:datewrite name="it" property="o.endDate"/></td>

					<td class="text"><bean:write name="it" property="o.orgCustomer.name" filter="true"/></td>

					<td class="text"><bean:write name="it" property="o.orgExecutor.name" filter="true"/></td>

					<td class="text"><july:sumwrite name="it" property="o.summ1"/></td>

					<td class="text"><july:sumwrite name="it" property="o.summ2"/></td>

				</logic:equal>

				<logic:notEqual name="ContractMultiListForm" property="contracttype" value="A">

	                <td class="text"><bean:write name="it" property="documentNumber" filter="true"/></td>

    	            <td class="date"><july:datewrite name="it" property="documentDate"/></td>

        	        <td class="date"><july:datewrite name="it" property="startDate"/></td>

					<td class="date"><july:datewrite name="it" property="endDate"/></td>

					<td class="text"><bean:write name="it" property="orgCustomer.name" filter="true"/></td>

					<td class="text"><bean:write name="it" property="orgExecutor.name" filter="true"/></td>

					<td class="text"><july:sumwrite name="it" property="summ1"/></td>

					<td class="text"><july:sumwrite name="it" property="summ2"/></td>

				</logic:notEqual>

				

                <% String s = RequestUtils.lookup(pageContext, "it", "leaseDocument", null).toString(); %>

                <td class="link"><july:checkbox property="selectedContract" value="<%= s %>" insertable="true" updatable="true"/></td>

            </tr>

			

            <july:separator colspan="<%= gColSpan %>"/>

			

	      </logic:present>

      </logic:iterate>

      

      <INPUT TYPE="HIDDEN" NAME="selectedContract" VALUE="0">



      <tr class="title">

          <td colspan="<%= gColSpan %>"><TABLE class="buttons">

            <TR class="title">

              <TD class="buttons"><july:savebutton/><july:backbutton page="/ShowContractsMutReglmntList.do"/></TD>

              <TD class="navigator"><july:navigator/></TD>

            </TR>

            </TABLE></TD>

      </tr>

      

      <july:separator colspan="<%= gColSpan %>"/>

      

<%--
<tr class="title">

		<td class="title" colspan="<%= gColSpan %>">

			<html:link page="/ShowMutualReglamentsList.do" styleClass="navigator"><bean:message key="label.mutualreglmnts"/></html:link>

			<july:sepmark/>

			<july:editlink page="/ViewMainParamsMutReglmnt.do" action="View" paramId="leaseDocument" paramName="ContractMultiListForm" paramProperty="mainLeaseDocumentcode" styleClass="navigator">

				<bean:message key="label.view"/>

			</july:editlink>

			<july:sepmark/>

			<html:link page="/ShowContractsMutReglmntList.do" styleClass="navigator"><bean:message key="label.contractsmutreglmnt"/></html:link>

			<july:sepmark/>

			<july:currmark><bean:message key="label.addcontract"/></july:currmark>		

		</td>

	</tr>
--%>

      

</table>



</july:browseform>

