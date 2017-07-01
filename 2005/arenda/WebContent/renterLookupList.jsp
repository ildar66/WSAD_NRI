<%@ page language = "java" %>

<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>

<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>



<% java.lang.String gColSpan = "3"; %>



<july:browseform action="/ShowRenterLookupList.do" styleId="OrgForm">



<script language="javascript">

function switchNameSearch(state) {

	if(state) {

		OrgForm.orgname.className = 'editdisabled';

		OrgForm.orgname.disabled = true;

	} else {

		OrgForm.orgname.className = 'search';

		OrgForm.orgname.disabled = false;

	}

}

function switchInnSearch(state) {

	if(state) {

		OrgForm.orginn.className = 'editdisabled';

		OrgForm.orginn.disabled = true;

	} else {

		OrgForm.orginn.className = 'search';

		OrgForm.orginn.disabled = false;

	}

}

</script>



<july:lookupresult tableId="brtable" resultCols="0;2"/>



<table class="main">

<TR class="title">

 <TD class="title">

    <bean:message key="label.choose.renter"/>

 </TD>

</TR>

<TR class="normal">

 <TD>

     <table class="find">

    <TR>

       <td class="title"><bean:message key="label.renter.inn"/></td>

       <td class="title"><july:checkbox property="isinn" insertable="true" updatable="true" onclick="switchInnSearch(document.all.isinn[0].checked)" />&nbsp;<bean:message key="label.search.all"/>&nbsp;&nbsp;&nbsp;<html:text styleClass="search" property="orginn" styleId="orginn" size="25" /><july:searchbutton/></td>

    </TR>        

    <TR>

       <td class="title"><bean:message key="label.renter.name"/></td>

       <td class="title"><july:checkbox property="isorgname" styleId="isorgname" insertable="true" updatable="true" onclick="switchNameSearch(document.all.isorgname[0].checked)" />&nbsp;<bean:message key="label.search.all"/>&nbsp;&nbsp;&nbsp;<html:text styleClass="search" property="orgname" styleId="orgname" size="25" /></td>

    </TR>        

     </table>

    

  </TD>

</TR>



<script language="javascript">

  switchNameSearch(document.all.isorgname[0].checked);

  switchInnSearch(document.all.isinn[0].checked);

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

            <july:headercolumn key="label.code" colType="number"/>

            <july:headercolumn key="label.renter.inn" colType="string"/>

            <july:headercolumn key="label.renter.name" colType="string"/>

        </tr>



        <!-- Table body -->

        <logic:iterate id="org" name="browseList" indexId="index">

	      <logic:present name="org">

            <tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">

                <td class="number"><bean:write name="org" property="organization" filter="true"/></td>

                <td class="text"><bean:write name="org" property="inn" filter="true"/></td>

                <td class="text"><july:lookupreturn><bean:write name="org" property="name" filter="true"/></july:lookupreturn></td>

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

