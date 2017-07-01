<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.arenda.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "2"; %>

<%

    String action = null;
	String form = null;
	String labelCaption = null;
	String parent = null;
	//String editAction = null;
	//String temp = null;
	switch (ParamsParser.getState(pageContext)) {

		case APPStates.US_ARENDA_EDIT:

          action = "/ProcessUsArenda.do";

		  form = "UsArendaForm";

		  labelCaption = "label.us";

		  parent = "/ShowUsArendaList.do";

          break;

		case APPStates.CHANNEL_ARENDA_EDIT:

          action = "/ProcessChannelArenda.do";

		  form = "ChannelArendaForm";

		  labelCaption = "label.channel";

		  parent = "/ShowChannelArendaList.do";

          break;

	}

%>



<july:editform action="<%= action %>" styleId="<%= form %>">

<html:hidden property="leaseDocument"/>
<html:hidden property="custname"/>
<html:hidden property="execname"/>

<script language="javascript">

function switchSumm2() {

	if (document.all.isSumm2[0].checked) {

		<%= form %>.summ2.className = 'editsmall';

		<%= form %>.summ2.disabled = false;

		<%= form %>.curr2.className = 'edit';

		<%= form %>.curr2.disabled = false;

	} else {

		<%= form %>.summ2.className = 'editsmalldisabled';

		<%= form %>.summ2.disabled = true;

		<%= form %>.curr2.className = 'editdisabled';

		<%= form %>.curr2.disabled = true;

	}

}

</script>



<table class="main">

<%--
<tr class="title">

		<td class="title" colspan="<%= gColSpan %>">

			<html:link page="<%= parent %>" styleClass="navigator">

				<bean:message key="<%= labelCaption %>"/>

			</html:link>

			<july:sepmark/>

			<july:actionname/>

		</td>

	</tr>
--%>



	<july:separator colspan="<%= gColSpan %>"/>



	<tr>

		<td class="title" colspan="<%= gColSpan %>"><july:actionalert/></td>

	</tr>



	<july:separator colspan="<%= gColSpan %>"/>



	<tr>

		<td class="text">

			<july:reqmark><bean:message key="label.filter.docnumber"/>:</july:reqmark>

		</td>

		<td class="text">

			<july:string size="25" property="documentNumber" insertable="true" updatable="true"/>

		</td>

	</tr>



	<july:separator colspan="<%= gColSpan %>"/>



	<tr>

		<td class="text"><july:reqmark><bean:message key="label.filter.docdate"/>:</july:reqmark></td>

		<td class="text">

			<july:date property="documentDateFrm" size="25" insertable="true" updatable="true"/>

		</td>

	</tr>

	

	<july:separator colspan="<%= gColSpan %>"/>

	

	<tr>

		<td class="text">

			<july:reqmark><bean:message key="label.filter.customer"/>:</july:reqmark>

		</td>

		<td class="text">

			<july:string property="orgCustomercodeFrm" styleId="orgCustomer" size="5" insertable="true" updatable="true"/>

			<july:lookupbutton action="/ShowOrganizationLookupList.do" styleId="custl" fieldNames="orgCustomer;orgCustomername" newWindowName="custlookup" insertable="true" updatable="true"/>

			<july:string size="50" property="orgCustomername" styleId="orgCustomername" insertable="false" updatable="false"/>

		</td>

	</tr>

	

	<july:separator colspan="<%= gColSpan %>"/>



	<tr>

		<td class="text">

			<july:reqmark><bean:message key="label.filter.executor"/>:</july:reqmark>

		</td>

		<td class="text">

			<july:select styleId="orgExecutor" style="width: 300;" collection="executors" property="orgExecutorcode" insertable="true" updatable="true">

				<html:options collection="executors" property="organization" labelProperty="name"/>

			</july:select>

			<%--july:string property="orgExecutorcodeFrm" styleId="orgExecutor" size="5" insertable="true" updatable="true"/>

			<july:lookupbutton action="/ShowOrganizationLookupList.do" styleId="execl" fieldNames="orgExecutor;orgExecutorname" newWindowName="execlookup" insertable="true" updatable="true"/>

			<july:string size="50" property="orgExecutorname" styleId="orgExecutorname" insertable="false" updatable="false"/--%>

		</td>

	</tr>

	

	<july:separator colspan="<%= gColSpan %>"/>



	<tr>

		<td class="text"><july:reqmark><bean:message key="label.filter.docperiod"/>:</july:reqmark></td>

		<td>

			<table class="main" border="0"> <!--cellpadding=0 cellspacing=0-->

				<tr>

					<td><july:date property="startDateFrm" size="25" insertable="true" updatable="true"/></td>

					<td><bean:message key="label.filter.stop"/></td>

					<td><july:date property="endDateFrm" size="25" insertable="true" updatable="true"/></td>

				</tr>

			</table>

		</td>

	</tr>

	

	<july:separator colspan="<%= gColSpan %>"/>

	

	<tr>

		<td class="text"><july:reqmark><bean:message key="label.filter.costcurrency1"/>:</july:reqmark></td>

		<td class="text">

			<july:string size="10" property="summ1Frm" insertable="true" updatable="true"/>&nbsp;

		    <july:select style="width: 200;" collection="currencies" property="currencycode1" insertable="true" updatable="true">

				<html:options collection="currencies" property="currency" labelProperty="name"/>

		   	</july:select>

		</td>

    </tr>



	<july:separator colspan="<%= gColSpan %>"/>



	<tr>

		<td class="text"><bean:message key="label.filter.costcurrency2"/>:</td>

		<td class="text">

			<july:checkbox property="isSumm2" insertable="true" updatable="true" onclick="switchSumm2()"/>&nbsp;

			<july:string size="10" property="summ2Frm" insertable="true" updatable="true" styleId="summ2"/>&nbsp;

			<july:select style="width: 200;" collection="currencies" property="currencycode2" insertable="true" updatable="true" styleId="curr2">

				<html:options collection="currencies" property="currency" labelProperty="name"/>

		   	</july:select>

		</td>

    </tr>

	

	<july:separator colspan="<%= gColSpan %>"/>

	

	<tr>

		<td class="text"><bean:message key="label.filter.economist"/>:</td>

		<td class="text">

			<july:string property="economistcodeFrm" styleId="economist" size="5" insertable="true" updatable="true"/>

			<july:lookupbutton action="/ShowWorkerLookupList.do" styleId="economistl" fieldNames="economist;economistname" newWindowName="economistlookup" insertable="true" updatable="true"/>

			<july:string size="50" property="economistname" styleId="economistname" insertable="false" updatable="false"/>

		</td>

	</tr>

<%--	

	<july:separator colspan="<%= gColSpan %>"/>

	

	<tr>

		<td class="text"><bean:message key="label.filter.text"/>:</td>

		<td class="text">

			<html:link page="/DocumentDownload?param=text" paramId="leaseDocument" paramName="WeArendaForm" paramProperty="leaseDocument" target="_blank">

				<bean:write name="WeArendaForm" property="textFileName" filter="true"/>

			</html:link>&nbsp;

			<html:file property="formFile"/>&nbsp;

			<bean:message key="label.delete"/>&nbsp;

			<july:checkbox property="istext" insertable="true" updatable="true" value="true"/>

		</td>

	</tr>


--%>
	

	<%--platinum--%>

<logic:present name="UsArendaForm" property="SYNCNRIPLATINARENDA" >

	<july:separator colspan="<%= gColSpan %>"/>

	<tr>

       <td class="text"><bean:message key="label.platinum.dogovorcode"/>:</td>

       <td class="text">

		<july:string property="vendor" size="20" insertable="true" updatable="true" />			

	   </td>

    </tr>

</logic:present>

	<july:separator colspan="<%= gColSpan %>"/>	

	<july:formbuttons/>

	<july:separator colspan="<%= gColSpan %>"/>

</table>

<script language="javascript">

	switchSumm2();

</script>

</july:editform>