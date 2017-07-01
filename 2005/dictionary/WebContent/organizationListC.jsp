<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "8"; %>

<july:browseform action="/ShowOrganizationListC.do" styleId="OrgForm">

<script language="JavaScript">
function switchGroups(state) {
	if(state) {
		OrgForm.group.className = 'editkoddisabled';
		OrgForm.group.disabled = true;
		OrgForm.groupping.className = 'editkoddisabled';
		OrgForm.groupping.disabled = true;
	} else {
		OrgForm.group.className = 'editkod';
		OrgForm.group.disabled = false;
		OrgForm.groupping.className = 'editkod';
		OrgForm.groupping.disabled = false;
	}
}
</script>

<html:hidden property="company"/>

<table class="main">
<%--
<tr class="title">
	<td class="title" colspan="<%= gColSpan %>">
       <html:link page="/ShowCompanyList.do" styleClass="navigator"><bean:message key="label.companies"/></html:link> 
       <july:sepmark/> 
       <july:currmark><bean:message key="label.organizations"/></july:currmark></td>
</tr>
--%>
<july:separator colspan="<%= gColSpan %>" />

<TR class="normal">
 <TD colspan="<%= gColSpan %>">
 
    <table class="find">
    <TR>
       <td class="title"><bean:message key="label.company.name"/>:</td>
	   <td class="title">&nbsp;</td>
       <td class="title"><bean:write name="company" property="name" /><july:searchbutton/></td>
     </tr>
	<TR>
	   <td class="title"><bean:message key="label.grouppings"/></td>
	   <td class="title"><july:checkbox property="isgroup" insertable="true" updatable="true" onclick="switchGroups(document.all.isgroup[0].checked)" />&nbsp;<bean:message key="label.search.all"/></td>
	   <td class="title">
	      <july:string property="group" styleId="group" size="5" insertable="true" updatable="true" />
          <july:lookupbutton action="/ShowGroupLookupList.do" styleId="gl" fieldNames="group;groupname" insertable="true" updatable="true"/>
          <july:string size="30" property="groupname" styleId="groupname" insertable="false" updatable="false" /><br>
		  <july:string property="groupping" styleId="groupping" size="5" insertable="true" updatable="true" />
          <july:lookupbutton action="/ShowGrouppingLookupList.do" styleId="gpl" fieldNames="groupping;grouppingname" onclick="set_opt_params_gpl('?searchgroup='+document.all.group.value)" insertable="true" updatable="true"/>
          <july:string size="30" property="grouppingname" styleId="grouppingname" insertable="false" updatable="false" /></td>
	</tr>
    </table>
    
  </TD>
</TR>

<SCRIPT language="javascript">
 switchGroups(document.all.isgroup[0].checked);
</SCRIPT>

<july:separator colspan="<%= gColSpan %>" />

      <tr class="title">
          <td colspan="<%= gColSpan %>"><TABLE class="buttons">
            <TR class="title">
              <TD class="buttons"><july:addbutton page="/EditOrganizationC.do?action=Add"/><july:backbutton/></TD>
              <TD class="navigator"><july:navigator/></TD>
            </TR>
            </TABLE></TD>
      </tr>
      
      <july:separator colspan="<%= gColSpan %>" />
  
    <!-- Table header -->
    <tr class="title">
        <TD class="title">&nbsp;</TD>
<%--        <july:headercolumn key="label.code" colType="number"/>--%>
        <july:headercolumn key="label.organization.inn" colType="string"/>
        <july:headercolumn key="label.name" colType="string"/>
        <july:headercolumn key="label.organization.phone" colType="string"/>
        <july:headercolumn key="label.accounts" colType="string"/>
		<july:headercolumn key="label.orggroups" colType="string"/>
        <TD class="title">&nbsp;</TD>
    </tr>

<july:separator colspan="<%= gColSpan %>" />


        <!-- Table body -->
    <logic:iterate id="org" name="browseList">
        <logic:present name="org">
            <tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
		<td class="text">
			<july:editbutton page="/EditOrganizationC.do" action="Edit" paramId="organization" paramName="org" paramProperty="organization" paramScope="page"/>
		</td>
<%--
                <td class="number">
                      <bean:write name="org" property="organization" filter="true"/>
                </td>
--%>
                <td class="text">
<%--                    <july:editlink page="/EditOrganizationC.do" action="Edit" paramId="organization" paramName="org" paramProperty="organization" paramScope="page">--%>
                    <bean:write name="org" property="inn" filter="true"/>
<%--                    </july:editlink>--%>
                </td>
                <td class="text">
                    <bean:write name="org" property="name" filter="true"/>
                </td>
                <td class="text">
                    <bean:write name="org" property="phone" filter="true"/>
                </td>
                <td class="link">
                    <july:link page="/ShowAccountListC.do" paramId="organization" paramName="org" paramProperty="organization" paramScope="page" alttext="msg.accounts">
                      <bean:message key="label.accounts"/>
                    </july:link>
                </td>
                <td class="text">
                    <july:link page="/ShowOrggroupListC.do" paramId="organization" paramName="org" paramProperty="organization" paramScope="page" alttext="msg.orggroups">
                      <bean:message key="label.orggroups"/>
                    </july:link>
                </td>
                <td class="link"><july:delbutton page="/EditOrganizationC.do?action=Delete" paramId="organization" paramName="org" paramProperty="organization" paramScope="page"/></td>
            </tr>

            <july:separator colspan="<%= gColSpan %>" />

	      </logic:present>
      </logic:iterate>

      <tr class="title">
          <td colspan="<%= gColSpan %>"><TABLE class="buttons">
            <TR class="title">
              <TD class="buttons"><july:addbutton page="/EditOrganizationC.do?action=Add"/><july:backbutton/></TD>
              <TD class="navigator"><july:navigator/></TD>
            </TR>
            </TABLE></TD>
      </tr>
      
      <july:separator colspan="<%= gColSpan %>" />
<%--      
      <tr class="title">
    	<td class="title" colspan="<%= gColSpan %>">
           <html:link page="/ShowCompanyList.do" styleClass="navigator"><bean:message key="label.companies"/></html:link> 
           <july:sepmark/> 
           <july:currmark><bean:message key="label.organizations"/></july:currmark></td>
      </tr>
--%>      
</table>

</july:browseform>
