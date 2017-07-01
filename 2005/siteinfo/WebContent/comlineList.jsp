<%@ page import="com.hps.july.siteinfo.formbean.PositionForm"%>
<%@ page language = "java" %>

<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>

<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>



<% java.lang.String gColSpan = "4";
boolean hasRegionAccess=((PositionForm)pageContext.findAttribute("PositionForm")).hasRegionAccess(request);
%>



<july:browseform action="/ShowComlineList.do">



<table class="main">

<tr class="title">

	<td class="title" colspan="<%= gColSpan %>">

       <%--<html:link page="/ShowPositionList.do" styleClass="navigator"><bean:message key="label.position"/></html:link> --%>

	   <jsp:include page="/mapLinks.jsp" flush="true"></jsp:include>

	   <july:sepmark/> 

       <html:link page="/EditPosition.do?action=View" paramId="storageplace" paramName="ComlineListForm" paramProperty="poscode" styleClass="navigator"><bean:message key="label.workresponsibility.position"/></html:link> 

       <july:sepmark/> 

       <july:currmark><bean:message key="label.comlines"/></july:currmark></td>

</tr>



<july:separator colspan="<%= gColSpan %>" />



<TR class="normal">

 <TD colspan="<%= gColSpan %>">

 

    <table class="find">

    <TR>

       <td class="title"><bean:message key="label.comline.posname"/>:</td>

       <td class="title"><bean:write name="ComlineListForm" property="posid" />&nbsp;&nbsp;&nbsp;<bean:write name="ComlineListForm" property="posname" /></td>

     </tr>        

     </table>

    

  </TD>

</TR>





    <july:separator colspan="<%= gColSpan %>" />



      <tr class="title">

          <td colspan="<%= gColSpan %>"><TABLE class="buttons">

            <TR class="title">

              <TD class="buttons"><%if(hasRegionAccess){%><july:addbutton page="/EditComline.do?action=Add"/><%}%><july:backbutton page="/EditPosition.do?action=View" paramId="storageplace" paramName="ComlineListForm" paramProperty="poscode"/></TD>

              <TD class="navigator"><july:navigator/></TD>

            </TR>

            </TABLE></TD>

      </tr>

      

      <july:separator colspan="<%= gColSpan %>" />

  

    <!-- Table header -->

    <tr class="title">

        <july:headercolumn key="label.code" colType="number"/>

        <july:headercolumn key="label.comline.type" colType="string"/>

        <%-- july:headercolumn key="label.comline.direction" colType="string"/ --%>

        <july:headercolumn key="label.comline.destination" colType="string"/>

        <TD class="title">&nbsp;</TD>

    </tr>



     <july:separator colspan="<%= gColSpan %>" />



 

        <!-- Table body -->

    <logic:iterate id="cln" name="browseList">
        <logic:present name="cln">
            <%--<% java.lang.String pcode = ((com.hps.july.siteinfo.formbean.ComlineListForm)request.getSession().getAttribute( "ComlineListForm" )).getPoscode().toString(); %>--%>
            <tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
                <td class="number">
                    <bean:write name="cln" property="hopsid" filter="true"/>
                </td>
                <td class="text">
                    <logic:equal name="cln" property="hopstype" value="R">
                      <bean:message key="label.comline.typer"/>
                    </logic:equal>
                    <logic:equal name="cln" property="hopstype" value="O">
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
                    <html:link page="/EditComline.do?action=Edit" paramId="compline" paramName="cln" paramProperty="compline" paramScope="page">
                        <logic:equal name="cln" property="position.storageplace" value="<%= pcode %>">
                            <bean:write name="cln" property="destinationposition.name" filter="true"/>
                       </logic:equal>
                        <logic:equal name="cln" property="destinationposition.storageplace" value="<%= pcode %>">
                            <bean:write name="cln" property="position.name" filter="true"/>
                        </logic:equal>
                    </html:link>
                </td --%>
                <td class="text">
                <%if(hasRegionAccess){%>
                    <july:editlink page="/EditComline.do" action="Edit" paramId="compline" paramName="cln" paramProperty="hopsid" paramScope="page">
                          <bean:write name="cln" property="fromPosName" filter="true"/> &nbsp;&lt;--&gt;&nbsp;
                          <bean:write name="cln" property="destPosName" filter="true"/>
                    </july:editlink>
               <%}else{%>
                   <july:editlink page="/EditComline.do" action="View" paramId="compline" paramName="cln" paramProperty="hopsid" paramScope="page">
                          <bean:write name="cln" property="fromPosName" filter="true"/> &nbsp;&lt;--&gt;&nbsp;
                          <bean:write name="cln" property="destPosName" filter="true"/>
                    </july:editlink>
               <%}%>
                </td>
                <td class="link"><%if(hasRegionAccess){%><july:delbutton page="/EditComline.do?action=Delete" paramId="compline" paramName="cln" paramProperty="hopsid" paramScope="page"/><%}%></td>
            </tr>
            <july:separator colspan="<%= gColSpan %>" />
	      </logic:present>
      </logic:iterate>



      <tr class="title">

          <td colspan="<%= gColSpan %>"><TABLE class="buttons">

            <TR class="title">

              <TD class="buttons"><%if(hasRegionAccess){%><july:addbutton page="/EditComline.do?action=Add"/><%}%><july:backbutton page="/EditPosition.do?action=View" paramId="storageplace" paramName="ComlineListForm" paramProperty="poscode"/></TD>

              <TD class="navigator"><july:navigator/></TD>

            </TR>

            </TABLE></TD>

      </tr>

      

      <july:separator colspan="<%= gColSpan %>" />

      

      <tr class="title">

    	<td class="title" colspan="<%= gColSpan %>">

           <%--<html:link page="/ShowPositionList.do" styleClass="navigator"><bean:message key="label.position"/></html:link> --%>
		   <jsp:include page="/mapLinks.jsp" flush="true"></jsp:include>
           <july:sepmark/> 

           <html:link page="/EditPosition.do?action=View" paramId="storageplace" paramName="ComlineListForm" paramProperty="poscode" styleClass="navigator"><bean:message key="label.workresponsibility.position"/></html:link> 

           <july:sepmark/> 

           <july:currmark><bean:message key="label.comlines"/></july:currmark></td>

      </tr>

      

</table>



</july:browseform>

