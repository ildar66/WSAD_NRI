<%@ page language = "java" %>

<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>

<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>



<% java.lang.String gColSpan = "6"; %>



<july:browseform action="/ShowPositionLookupList.do" styleId="PosForm">



<july:lookupresult tableId="brtable" resultCols="5;0;1"/>



<script language="javascript">

function switchNZoneSearch(state) {

	if(state) {

		PosForm.netzone.className = 'editdisabled';

		PosForm.netzone.disabled = true;

	} else {

		PosForm.netzone.className = 'search';

		PosForm.netzone.disabled = false;

	}

}

function switchRenterSearch(state) {

	if(state) {

		PosForm.organization.className = 'editkoddisabled';

		PosForm.organization.disabled = true;

	} else {

		PosForm.organization.className = 'editkodsearch';

		PosForm.organization.disabled = false;

	}

}

function switchWorkerSearch(state) {

	if(state) {

		PosForm.worker.className = 'editkoddisabled';

		PosForm.worker.disabled = true;

	} else {

		PosForm.worker.className = 'editkodsearch';

		PosForm.worker.disabled = false;

	}

}

function switchAllSearch() {

	if(PosForm.searchmode [0].checked) {

		PosForm.searchstr.className = 'editdisabled';

		PosForm.searchstr.disabled = true;

	} else {

		PosForm.searchstr.className = 'editsearch';

		PosForm.searchstr.disabled = false;

	}

}

</script>





<table class="main">

<TR class="title">

 <TD class="title">

    <bean:message key="label.choose.position"/>

 </TD>

</TR>

<TR class="normal">

 <TD>

 

    <table class="find">

    <TR>

        <td><bean:message key="label.position.netzonename"/></td>

        <td><july:checkbox insertable="true" updatable="true" property="isnetzone" styleId="isnetzone" onclick="switchNZoneSearch(document.all.isnetzone[0].checked)"/><html:hidden property="isnetzone" value="false"/><bean:message key="label.search.all"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

			<july:select collection="netzones" property="netzone" insertable="true" updatable="true">

				<html:options collection="netzones" property="netzone" labelProperty="name"/>

			</july:select><july:searchbutton />

		</td>

     </tr>        

    <TR>

        <td><bean:message key="label.position.searchby"/></td>

        <td>

			<july:radio insertable="true" updatable="true" property="searchmode" value="0" onclick="switchAllSearch()"/><bean:message key="label.position.search.all"/><br>

			<july:radio insertable="true" updatable="true" property="searchmode" value="1" onclick="switchAllSearch()"/><bean:message key="label.position.search.gsmid"/><br>

			<july:radio insertable="true" updatable="true" property="searchmode" value="2" onclick="switchAllSearch()"/><bean:message key="label.position.search.dampsid"/><br>

			<july:radio insertable="true" updatable="true" property="searchmode" value="3" onclick="switchAllSearch()"/><bean:message key="label.position.search.name"/><br>

			<july:radio insertable="true" updatable="true" property="searchmode" value="4" onclick="switchAllSearch()"/><bean:message key="label.position.search.addr"/><br>

		</td>

     </tr> 

    <TR>

        <td><bean:message key="label.position.search.text"/></td>

        <td>

			<html:text styleClass="search" property="searchstr" size="35" />

		</td>

     </tr> 

    <TR>

       <td class="title"><bean:message key="label.position.renter"/></td>

       <td class="title"><july:checkbox property="isRenter" styleId="isRenter" insertable="true" updatable="true" onclick="switchRenterSearch(document.all.isRenter[0].checked)" />&nbsp;<bean:message key="label.search.all"/>&nbsp;&nbsp;&nbsp;

			<july:string property="organization" styleId="organization" size="5" insertable="true" updatable="true" />

			<july:lookupbutton action="/ShowRenterLookupList.do" styleId="r1l" newWindowName="wrkwnd" fieldNames="organization;orgname" insertable="true" updatable="true" />

			<july:string size="25" property="orgname" styleId="orgname" insertable="false" updatable="false" />

       </td>

     </TR>        

    <TR>

       <td class="title"><bean:message key="label.position.worker"/></td>

       <td class="title"><july:checkbox property="isWorker" styleId="isWorker" insertable="true" updatable="true" onclick="switchWorkerSearch(document.all.isWorker[0].checked)" />&nbsp;<bean:message key="label.search.all"/>&nbsp;&nbsp;&nbsp;

          <july:string property="worker" styleId="worker" size="5" insertable="true" updatable="false" />

          <july:lookupbutton action="/ShowWorkerLookupList.do" newWindowName="wrkwnd" styleId="wrkl" fieldNames="worker;workername" insertable="true" updatable="false" />

          <july:string size="25" property="workername" styleId="workername"  insertable="false" updatable="false" />

       </td>

     </TR>        

    <TR>

       <td class="title"><bean:message key="label.position.inaction"/></td>

       <td class="title"><july:radio  styleClass="editcheckbox" property="inaction" value="A" insertable="true" updatable="true" /><bean:message key="label.position.inaction.all"/>

              &nbsp;<july:radio  styleClass="editcheckbox" property="inaction" value="B" insertable="true" updatable="true" /><bean:message key="label.position.inaction.yes"/>

              &nbsp;<july:radio  styleClass="editcheckbox" property="inaction" value="C" insertable="true" updatable="true" /><bean:message key="label.position.inaction.no"/>

       </td>

     </TR>        

    </table>

    

  </TD>

</TR>



<script language="javascript">

  switchNZoneSearch(document.all.isnetzone[0].checked);

  switchRenterSearch(document.all.isRenter[0].checked);

  switchWorkerSearch(document.all.isWorker[0].checked);

  switchAllSearch();

</script>



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

            <july:sortcolumn key="label.position.bsid" colType="string"

                   ascFinder="5" descFinder="6" />

            <july:sortcolumn key="label.position.name" colType="string"

                   ascFinder="3" descFinder="4" />

            <july:headercolumn key="label.position.addr" colType="string"/>

            <july:headercolumn key="label.position.netzone" colType="string"/>

            <july:headercolumn key="label.position.inactionh" colType="string"/>

            <july:sortcolumn key="label.code" colType="number"

                   ascFinder="1" descFinder="2" />

        </tr>



        <!-- Table body -->

        <logic:iterate id="rtl" name="browseList" indexId="index">

	      <logic:present name="rtl">

            <tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">

                <td class="text">

                    <logic:present name="rtl" property="gsmid">

						D<bean:write name="rtl" property="gsmid" filter="true"/>

					</logic:present>

                    <logic:present name="rtl" property="dampsid">

	                    A<bean:write name="rtl" property="dampsid" filter="true"/>

					</logic:present> 

                </td>

               <td class="text"><july:lookupreturn>

                   <bean:write name="rtl" property="name" filter="true"/>

                   <logic:present name="rtl" property="dampsname">

                     <% java.lang.String s = ""; %>

                     <logic:notEqual name="rtl" property="dampsname" value="<%= s %>">

                         &nbsp;/&nbsp;<bean:write name="rtl" property="dampsname" filter="true"/>

                     </logic:notEqual>

                   </logic:present>

                   </july:lookupreturn></td>

                <td class="text">

                    <bean:write name="rtl" property="address" filter="true"/>

                </td>

                <td class="text">

                    <logic:present name="rtl" property="netZone">

	                    <bean:write name="rtl" property="netZone.zonecode" filter="true"/>

					</logic:present>

                </td>

                <td class="text">

                   <logic:equal name="rtl" property="inAction" value="true">

                       <bean:message key="label.position.inactionh"/>

                   </logic:equal>

                </td>

                <td class="number"><bean:write name="rtl" property="storageplace" filter="true"/></td>

            </tr>



	      </logic:present>

          

	      <logic:notPresent name="rtl">

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

