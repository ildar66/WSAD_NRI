<%@ page language = "java" %>

<%@ page contentType = "text/html; charset=windows-1251" %>

<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>



<% java.lang.String gColSpan = "4"; %>



<july:browseform action="/ShowResourceLookupList.do" styleId="resform">



<july:lookupresult tableId="brtable" resultCols="0;2"/> <!-- "0;1;2" -->



<script language="javascript">

function switchAll() {

	switchTypeSearch();

	switchModelSearch();

	switchName();

}

function switchTypeSearch() {

	if(!document.all.conditionForFind[0].checked) {

		resform.restype.className = 'editkoddisabled';

		resform.restype.disabled = true;

		resform.ressbtype.className = 'editkoddisabled';

		resform.ressbtype.disabled = true;

	} else {

		resform.restype.className = 'editkodsearch';

		resform.restype.disabled = false;

		resform.ressbtype.className = 'editkodsearch';

		resform.ressbtype.disabled = false;

	}

}

function switchModelSearch() {

	if(!document.all.conditionForFind[1].checked) {

		resform.modelFind.className = 'editdisabled';

		resform.modelFind.disabled = true;

	} else {

		resform.modelFind.className = 'editsearch';

		resform.modelFind.disabled = false;

	}

}

function switchName() {

	if(!document.all.conditionForFind[2].checked) {

		resform.nameFind.className = 'editdisabled';

		resform.nameFind.disabled = true;

	} else {

		resform.nameFind.className = 'editsearch';

		resform.nameFind.disabled = false;

	}

}

</script>



<table class="main">

<TR class="title">

 <TD class="title">

    <bean:message key="label.choose.resource"/>

 </TD>

</TR>

<TR class="normal">

 <TD>



    <table class="find">

	<tr>

		<td>

			<july:radio property="conditionForFind" insertable="true" updatable="true" value="0" onclick="switchAll()"/>

			<bean:message key="label.resource.find.classif"/>&nbsp;&nbsp;&nbsp;&nbsp;

        	<bean:message key="label.restype"/>

		</td>

        <td nowrap>

		  <july:string property="restype" styleId="restype" size="5" insertable="true" updatable="true" />

          <july:lookupbutton action="/ShowRestypeLookupList.do" styleId="rtl" fieldNames="restype;restypename" newWindowName="restypelookup" insertable="true" updatable="true"/>

          <july:string size="30" property="restypename" styleId="restypename" insertable="false" updatable="false" /><july:searchbutton />

		</td>

		<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>

	</tr>

	<tr>

		<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<bean:message key="label.subtype"/></td>

		<td nowrap>

          <july:string property="ressbtype" styleId="ressbtype" size="5" insertable="true" updatable="true" />

          <july:lookupbutton action="/ShowRessbtypeLookupList.do" styleId="rstl" fieldNames="ressbtype;ressbtypename" newWindowName="ressbtypelookup" onclick="set_opt_params_rstl('?resourcetype='+document.all.restype.value)" insertable="true" updatable="true"/>

          <july:string size="30" property="ressbtypename" styleId="ressbtypename" insertable="false" updatable="false" />

		</td>

	</tr>

	<tr>

		<td><july:radio property="conditionForFind" insertable="true" updatable="true" value="1" onclick="switchAll()"/><bean:message key="label.resource.find.model"/></td>

		<td><july:string size="50" styleId="modelFind" property="model" insertable="true" updatable="true"/></td>

	</tr>

	<tr>

		<td><july:radio property="conditionForFind" insertable="true" updatable="true" value="2" onclick="switchAll()"/><bean:message key="label.resource.find.name"/></td>

		<td><july:string size="50" styleId="nameFind" property="name" insertable="true" updatable="true"/></td>

	</tr>

    </table>

    

  </TD>

</TR>



<SCRIPT language="javascript">

	switchAll();

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

			<july:headercolumn key="label.resource.code" colType="number"/>

			<july:sortcolumn key="label.resource.model" colType="string" ascFinder="1" descFinder="2"/>

	        <july:sortcolumn key="label.resource.name" colType="string" ascFinder="3" descFinder="4"/>

			<july:headercolumn key="label.resource.unit.short" colType="string"/>

		</tr>



        <!-- Table body -->

        <logic:iterate id="rstl" name="browseList" indexId="index">

	      <logic:present name="rstl">

            <tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">

                <td class="number"><bean:write name="rstl" property="resource" filter="true"/></td>

				<td class="text"><bean:write name="rstl" property="model" filter="true"/></td>

                <td class="text"><july:lookupreturn><bean:write name="rstl" property="name" filter="true"/></july:lookupreturn></td>

				<td class="text">

					<logic:present name="rstl" property="unit">

						<bean:write name="rstl" property="unit.name" filter="true"/>

					</logic:present>

				</td>

            </tr>



	      </logic:present>

          

	      <logic:notPresent name="rstl">

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

