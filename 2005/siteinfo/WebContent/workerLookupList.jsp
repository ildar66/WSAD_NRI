<%@ page language = "java" %>

<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>

<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>



<% java.lang.String gColSpan = "3"; %>



<july:browseform action="/ShowWorkerLookupList.do">



<july:lookupresult tableId="brtable" resultCols="0;1;3"/>



<table class="main">

<TR class="title">

 <TD class="title">

    <bean:message key="label.choose.worker"/>

 </TD>

</TR>

<TR class="normal">

 <TD>

    <table class="find">

    <TR>

        <td><bean:message key="label.people.lastname"/></td>

        <td><html:text styleClass="search" property="lastname" size="25" /><july:searchbutton/></td>

     </tr>        

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



<TR>

  <TD>



    <table class="main" id="brtable">



        <!-- Table header -->

        <tr class="title">

            <july:headercolumn key="label.code" colType="number"/>

            <july:headercolumn key="label.people.fullname" colType="string"/>

            <july:headercolumn key="label.worker.workposition" colType="string"/>

			<td style="display:none">&nbsp;</td>
			
        </tr>



        <!-- Table body -->

        <logic:iterate id="wrk" name="browseList" indexId="index">

	      <logic:present name="wrk">

            <tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">

                <td class="number"><bean:write name="wrk" property="worker" filter="true"/></td>

                <td class="text"><july:lookupreturn><bean:write name="wrk" property="man.fullName" filter="true"/></july:lookupreturn></td>

                <td class="text">

                    <bean:write name="wrk" property="position.name" filter="true"/>

                </td>
				
				<td style="display:none">
					<logic:present name="wrk" property="division"><bean:write name="wrk" property="division.name" filter="true"/></logic:present>
				</td>

            </tr>



	      </logic:present>

          

	      <logic:notPresent name="wrk">

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

