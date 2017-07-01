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

<july:browseform action="/ShowWorkerListD.do">

<html:hidden property="department"/>

<table class="main">
<tr class="title">
	<td class="title" colspan="<%= gColSpan %>">
       <html:link page="/ShowCompanyList.do" styleClass="navigator"><bean:message key="label.companies"/></html:link> 
       <july:sepmark/>
       <html:link page="/ShowDirectionList.do" styleClass="navigator"><bean:message key="label.directions"/></html:link> 
       <july:sepmark/>
       <html:link page="/ShowServiceList.do" styleClass="navigator"><bean:message key="label.services"/></html:link> 
       <july:sepmark/>
       <html:link page="/ShowDepartmentList.do" styleClass="navigator"><bean:message key="label.departments"/></html:link> 
       <july:sepmark/>
       <july:currmark><bean:message key="label.workers"/></july:currmark></td>
</tr>

<july:separator colspan="<%= gColSpan %>" />

<TR class="normal">
 <TD colspan="<%= gColSpan %>">
 
    <table class="find">
    <TR>
       <td class="title"><bean:message key="label.department.name"/>:</td>
       <td class="title"><bean:write name="department" property="name" /></td>
     </tr>        
     </table>
    
  </TD>
</TR>

<july:separator colspan="<%= gColSpan %>" />

        <tr class="title">
          <td colspan="<%= gColSpan %>"><TABLE class="buttons">
            <TR class="title">
              <TD class="buttons"><% if(canEdit) { %><july:addbutton page="/EditWorkerD.do?action=Add"/><% } %><july:backbutton page="/ShowDepartmentList.do"/></TD>
              <TD class="navigator"><july:navigator/></TD>
            </TR>
            </TABLE></TD>
        </tr>
        
      <july:separator colspan="<%= gColSpan %>" />

        <!-- Table header -->
        <tr class="title">
            <july:headercolumn key="label.code" colType="number"/>
            <july:headercolumn key="label.people.fullname" colType="string"/>
            <july:headercolumn key="label.worker.workposition" colType="string"/>
            <july:headercolumn key="label.isservicestuff" colType="string"/>
            <july:headercolumn key="label.worker.isenabled" colType="string"/>
<% if(canEdit) { %>
            <TD class="title">&nbsp;</TD>
<% } %>
        </tr>

<july:separator colspan="<%= gColSpan %>" />


        <!-- Table body -->
        <logic:iterate id="worker" name="browseList" type="com.hps.july.persistence.WorkerAccessBean">
            <logic:present name="worker">
            <tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
                <td class="number">
                      <bean:write name="worker" property="worker" filter="true"/>
                </td>
                <td class="text">
                    <july:editlink page="/EditWorkerD.do" action="Edit" paramId="worker" paramName="worker" paramProperty="worker" paramScope="page">
                    <bean:write name="worker" property="man.fullName" filter="true"/>
                    </july:editlink>
                </td>
                <td class="text">
                    <bean:write name="worker" property="position.name" filter="true"/>
                </td>
		<td class="text" align="center">
<%
			Boolean check = worker.getIsservicestuff();
			if(check != null && check.booleanValue()) {
				%><img src="/images/yes.gif" width=16 height=16 border=0><%
			}
%>
		</td>
                <td class="text">
                    <logic:present name="worker" property="active">
                        <logic:equal name="worker" property="active" value="true">
                            <bean:message key="label.worker.enabled"/>
                        </logic:equal>
                        <logic:equal name="worker" property="active" value="false">
                            <bean:message key="label.worker.disabled"/>
                        </logic:equal>
                    </logic:present>
                    <logic:notPresent name="worker" property="active">
                        <bean:message key="label.worker.disabled"/>
                    </logic:notPresent>
                </td>
<% if(canEdit) { %>
                <td class="link">
                    <july:delbutton page="/EditWorkerD.do?action=Delete" paramId="worker" paramName="worker" paramProperty="worker" paramScope="page"/>
                </td>
<% } %>
            </tr>

            <july:separator colspan="<%= gColSpan %>" />

	        </logic:present>
        </logic:iterate>

        <tr class="title">
          <td colspan="<%= gColSpan %>"><TABLE class="buttons">
            <TR class="title">
              <TD class="buttons"><% if(canEdit) { %><july:addbutton page="/EditWorkerD.do?action=Add"/><% } %><july:backbutton page="/ShowDepartmentList.do"/></TD>
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
           <html:link page="/ShowDepartmentList.do" styleClass="navigator"><bean:message key="label.departments"/></html:link> 
           <july:sepmark/>
           <july:currmark><bean:message key="label.workers"/></july:currmark></td>
      </tr>
        
    </table>

</july:browseform>
