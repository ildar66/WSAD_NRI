<%@ page language = "java" %>

<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>

<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>



<% java.lang.String gColSpan = "3"; %>



<july:browseform action="/ShowComlineLookupList.do">



<july:lookupresult tableId="brtable" resultCols="0;2"/>



<table class="main">

<TR class="title">

 <TD class="title">

    <bean:message key="label.choose.comline"/>

 </TD>

</TR>

<TR class="normal">

 <TD>

 

    <table class="find">

    <TR>

        <td class="title"><bean:message key="label.comline.posname"/>:</td>

        <td class="title"><bean:write name="ComlineLookupListForm" property="posid" />&nbsp;&nbsp;&nbsp;<bean:write name="ComlineLookupListForm" property="posname" /></td>

     </TR>        

    <TR>

        <td class="title"><bean:message key="label.comline.type"/>:</td>

        <td class="title">

           <logic:equal name="ComlineLookupListForm" property="postype" value="R">

             <bean:message key="label.comline.typer"/>

           </logic:equal>

           <logic:equal name="ComlineLookupListForm" property="postype" value="O">

             <bean:message key="label.comline.typeo"/>

           </logic:equal>

     </TR>        

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

        <july:headercolumn key="label.comline.type" colType="string"/>

        <%--july:headercolumn key="label.comline.direction" colType="string"/ --%>

        <july:headercolumn key="label.comline.destination" colType="string"/>

        </tr>



        <!-- Table body -->

        <logic:iterate id="cln" name="browseList" indexId="index">

	      <logic:present name="cln">

            <% java.lang.String pcode = ((com.hps.july.siteinfo.formbean.ComlineLookupListForm)request.getSession().getAttribute( "ComlineLookupListForm" )).getPoscode().toString(); %>

            <tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">

                <td class="number"><bean:write name="cln" property="compline" filter="true"/></td>

                <td class="text">

                    <logic:equal name="cln" property="type" value="R">

                      <bean:message key="label.comline.typer"/>

                    </logic:equal>

                    <logic:equal name="cln" property="type" value="O">

                      <bean:message key="label.comline.typeo"/>

                    </logic:equal>

                </td>

                <%--td class="text">

                    

                    <logic:equal name="cln" property="destinationposition.storageplace" value="<%= pcode %>">

                      <bean:message key="label.comline.dirto"/>

                    </logic:equal>

                    <logic:equal name="cln" property="position.storageplace" value="<%= pcode %>">

                      <bean:message key="label.comline.dirfrom"/>

                    </logic:equal>

                </td --%>

                <%-- td class="text">

                    <july:lookupreturn>

                        <logic:equal name="cln" property="position.storageplace" value="<%= pcode %>">

                            <bean:write name="cln" property="destinationposition.name" filter="true"/>

                        </logic:equal>

                        <logic:equal name="cln" property="destinationposition.storageplace" value="<%= pcode %>">

                            <bean:write name="cln" property="position.name" filter="true"/>

                        </logic:equal>

                    </july:lookupreturn>

                </td --%>

                <td class="text">

                    <july:lookupreturn>

                            <bean:write name="cln" property="position.name" filter="true"/> &nbsp;&lt;--&gt;&nbsp;

                            <bean:write name="cln" property="destinationposition.name" filter="true"/>

                    </july:lookupreturn>

                </td>

            </tr>



	      </logic:present>

          

	      <logic:notPresent name="cln">

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

