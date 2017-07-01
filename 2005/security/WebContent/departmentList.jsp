<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "6"; %>

<%
	boolean canEdit = request.isUserInRole("administrator");
%>

<july:browseform action="/ShowDepartmentList.do">

<html:hidden property="service"/>

<table class="main">
<tr class="title">
	<td class="title" colspan="<%= gColSpan %>">
       <html:link page="/ShowCompanyList.do" styleClass="navigator"><bean:message key="label.companies"/></html:link> 
       <july:sepmark/>
       <html:link page="/ShowDirectionList.do" styleClass="navigator"><bean:message key="label.directions"/></html:link> 
       <july:sepmark/>
       <html:link page="/ShowServiceList.do" styleClass="navigator"><bean:message key="label.services"/></html:link> 
       <july:sepmark/>
       <july:currmark><bean:message key="label.departments"/></july:currmark></td>
</tr>

	<july:separator colspan="<%= gColSpan %>" />
	
	<TR class="normal">
		<TD colspan="<%= gColSpan %>">
			<table class="find">
				<TR>
					<td class="title"><bean:message key="label.company.name"/>:</td>
					<td class="title"><bean:write name="company" property="name" /></td>
				</TR>
				<TR>
					<td class="title"><bean:message key="label.direction.name"/>:</td>
					<td class="title"><bean:write name="direction" property="name" /></td>
				</TR>
				<TR>
					<td class="title"><bean:message key="label.service.name"/>:</td>
					<td class="title"><bean:write name="service" property="name" /></td>
				</TR>
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
              <TD class="buttons"><% if(canEdit) { %><july:addbutton page="/EditDepartment.do?action=Add"/><% } %><july:backbutton page="/ShowServiceList.do"/></TD>
              <TD class="navigator"><july:navigator/></TD>
            </TR>
            </TABLE></TD>
        </tr>
        
      <july:separator colspan="<%= gColSpan %>" />

        <!-- Table header -->
        <tr class="title">
            <july:headercolumn key="label.code" colType="number"/>
            <july:sortcolumn ascFinder="1" descFinder="2" key="label.name" colType="string"/>
            <july:headercolumn key="label.groups" colType="link"/>
            <july:headercolumn key="label.workers" colType="link"/>
            <TD class="title">&nbsp;</TD>
<% if(canEdit) { %>
	    <TD class="title">&nbsp;</TD>
<% } %>
        </tr>

<july:separator colspan="<%= gColSpan %>" />


        <!-- Table body -->
        <logic:iterate id="dep" name="browseList">
            <logic:present name="dep">
            <tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
                <td class="number">
                      <bean:write name="dep" property="division" filter="true"/>
                </td>
                <td class="text">
                    <july:editlink page="/EditDepartment.do" action='<%=(canEdit?"Edit":"View")%>' paramId="department" paramName="dep" paramProperty="division" paramScope="page">
                    <bean:write name="dep" property="name" filter="true"/>
                    </july:editlink>
                </td>
                <td class="link">
                    <july:link page="/ShowGroupList.do" paramId="department" paramName="dep" paramProperty="division" paramScope="page" alttext="msg.groups">
                        <bean:message key="label.groups"/>
                    </july:link>
                </td>
                <td class="link">
                    <july:link page="/ShowWorkerListD.do" paramId="department" paramName="dep" paramProperty="division" paramScope="page" alttext="msg.workersd">
                        <bean:message key="label.workers"/>
                    </july:link>
                </td>
                <td class="link">
                    <july:link page="/ShowDepartmentCarsList.do" paramId="division" paramName="dep" paramProperty="division" paramScope="page" alttext="label.car.full">
                        <bean:message key="label.cars"/>
                    </july:link>
                </td>
<% if(canEdit) { %>
                <td class="link">
                    <july:delbutton page="/EditDepartment.do?action=Delete" paramId="department" paramName="dep" paramProperty="division" paramScope="page"/>
                </td>
<% } %>
            </tr>

            <july:separator colspan="<%= gColSpan %>" />

	        </logic:present>
        </logic:iterate>

        <tr class="title">
          <td colspan="<%= gColSpan %>"><TABLE class="buttons">
            <TR class="title">
              <TD class="buttons"><% if(canEdit) { %><july:addbutton page="/EditDepartment.do?action=Add"/><% } %><july:backbutton page="/ShowServiceList.do"/></TD>
              <TD class="navigator"><july:navigator/></TD>
            </TR>
            </TABLE></TD>
        </tr>
        
      <july:separator colspan="<%= gColSpan %>" />
      
      <tr class="title">
    	<td class="title" colspan="<%= gColSpan %>">
           <html:link page="/ShowCompanyList.do" styleClass="navigator"><bean:message key="label.companies"/></html:link> 
           <july:sepmark/>
           <html:link page="/ShowDirectionList.do" styleClass="navigator"><bean:message key="label.directions"/></html:link> 
           <july:sepmark/>
           <html:link page="/ShowServiceList.do" styleClass="navigator"><bean:message key="label.services"/></html:link> 
           <july:sepmark/>
           <july:currmark><bean:message key="label.departments"/></july:currmark></td>
      </tr>
        
    </table>

</july:browseform>
