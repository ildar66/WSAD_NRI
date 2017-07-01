<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "6"; %>

<%
	boolean canEdit = request.isUserInRole("administrator");
%>

<july:browseform action="/ShowDirectionList.do">

<html:hidden property="company"/>

<table class="main">
<tr class="title">
	<td class="title" colspan="<%= gColSpan %>">
       <html:link page="/ShowCompanyList.do" styleClass="navigator"><bean:message key="label.companies"/></html:link>
       <july:sepmark/>
       <july:currmark><bean:message key="label.directions"/></july:currmark></td>
</tr>

<july:separator colspan="<%= gColSpan %>" />

	<TR class="normal">
		<TD colspan="<%= gColSpan %>">
			<table class="find">
				<TR>
					<td class="title"><bean:message key="label.company.name"/>:</td>
					<td class="title"><bean:write name="company" property="name" /></td>
				</tr>
				<tr>
					<td class="title"><bean:message key="label.division.filter"/>:</td>
					<td class="title">
						<july:radio property="activestate" insertable="true" updatable="true" value="1"/><bean:message key="label.filter.all"/>
						<july:radio property="activestate" insertable="true" updatable="true" value="2"/><bean:message key="label.filter.active"/>
						<july:radio property="activestate" insertable="true" updatable="true" value="3"/><bean:message key="label.filter.notactive"/>
						<july:searchbutton/>
					</td>
				</tr>
			</table>
		</TD>
	</TR>
	
	<july:separator colspan="<%= gColSpan %>" />

        <tr class="title">
          <td colspan="<%= gColSpan %>"><TABLE class="buttons">
            <TR class="title">
              <TD class="buttons"><% if(canEdit) { %><july:addbutton page="/EditDirection.do?action=Add"/><% } %><july:backbutton page="/ShowCompanyList.do"/></TD>
              <TD class="navigator"><july:navigator/></TD>
            </TR>
            </TABLE></TD>
        </tr>
        
      <july:separator colspan="<%= gColSpan %>" />

        <!-- Table header -->
        <tr class="title">
            <july:headercolumn key="label.code" colType="number"/>
            <july:sortcolumn ascFinder="1" descFinder="2" key="label.name" colType="string"/>
            <july:headercolumn key="label.services" colType="link"/>
            <july:headercolumn key="label.workers" colType="link"/>
			<TD class="title">&nbsp;</TD>
<% if(canEdit) { %>
	     <TD class="title">&nbsp;</TD>
<% } %>
        </tr>

<july:separator colspan="<%= gColSpan %>" />


        <!-- Table body -->
        <logic:iterate id="dir" name="browseList">
            <logic:present name="dir">
            <tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
                <td class="number">
                      <bean:write name="dir" property="division" filter="true"/>
                </td>
                <td class="text">
                    <july:editlink page="/EditDirection.do" action='<%=(canEdit?"Edit":"View")%>' paramId="direction" paramName="dir" paramProperty="division" paramScope="page">
                    <bean:write name="dir" property="name" filter="true"/>
                    </july:editlink>
                </td>
                <td class="link">
                    <july:link page="/ShowServiceList.do" paramId="direction" paramName="dir" paramProperty="division" paramScope="page" alttext="msg.services">
                        <bean:message key="label.services"/>
                    </july:link>
                </td>
                <td class="link">
                    <july:link page="/ShowWorkerListDr.do" paramId="direction" paramName="dir" paramProperty="division" paramScope="page" alttext="msg.workersdr">
                        <bean:message key="label.workers"/>
                    </july:link>
                </td>
                <td class="link">
                    <july:link page="/ShowDirectionCarsList.do" paramId="division" paramName="dir" paramProperty="division" paramScope="page" alttext="label.car.full">
                        <bean:message key="label.cars"/>
                    </july:link>
                </td>
<% if(canEdit) { %>
                <td class="link">
                    <july:delbutton page="/EditDirection.do?action=Delete" paramId="direction" paramName="dir" paramProperty="division" paramScope="page"/>
                </td>
<% } %>
            </tr>

            <july:separator colspan="<%= gColSpan %>" />

	        </logic:present>
        </logic:iterate>

        <tr class="title">
          <td colspan="<%= gColSpan %>"><TABLE class="buttons">
            <TR class="title">
              <TD class="buttons"><% if(canEdit) { %><july:addbutton page="/EditDirection.do?action=Add"/><% } %><july:backbutton page="/ShowCompanyList.do"/></TD>
              <TD class="navigator"><july:navigator/></TD>
            </TR>
            </TABLE></TD>
        </tr>
        
      <july:separator colspan="<%= gColSpan %>" />
      
      <tr class="title">
    	<td class="title" colspan="<%= gColSpan %>">
           <html:link page="/ShowCompanyList.do" styleClass="navigator"><bean:message key="label.companies"/></html:link>
           <july:sepmark/>
           <july:currmark><bean:message key="label.directions"/></july:currmark></td>
      </tr>
        
    </table>

</july:browseform>
