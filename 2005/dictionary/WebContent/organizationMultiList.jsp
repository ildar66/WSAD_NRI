<%@ page language = "java" %>
<%@ page import="org.apache.struts.util.*" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "5"; %>

<july:browseform action="/ShowOrganizationMultiList.do" styleId="OrgForm">

<script language="javascript">
function switchNameSearch(state) {
	if(state) {
		OrgForm.orgname.className = 'editdisabled';
		OrgForm.orgname.disabled = true;
	} else {
		OrgForm.orgname.className = 'editsearch';
		OrgForm.orgname.disabled = false;
	}
}
function switchInnSearch(state) {
	if(state) {
		OrgForm.orginn.className = 'editdisabled';
		OrgForm.orginn.disabled = true;
	} else {
		OrgForm.orginn.className = 'editsearch';
		OrgForm.orginn.disabled = false;
	}
}
function switchGroups(state) {
	if(state) {
		OrgForm.group.className = 'editkoddisabled';
		OrgForm.group.disabled = true;
		OrgForm.groupping.className = 'editkoddisabled';
		OrgForm.groupping.disabled = true;
	} else {
		OrgForm.group.className = 'editkodsearch';
		OrgForm.group.disabled = false;
		OrgForm.groupping.className = 'editkodsearch';
		OrgForm.groupping.disabled = false;
	}
}
</script>

<table class="main">
<%--
<tr class="title">
	<td class="title" colspan="<%= gColSpan %>">
       <html:link page="/ShowGroupList.do" styleClass="navigator"><bean:message key="label.groups"/></html:link>
       <july:sepmark/> 
	   <html:link page="/ShowGrouppingList.do" styleClass="navigator"><bean:message key="label.groupping"/></html:link>
       <july:sepmark/> 
       <html:link page="/ShowGrouporgList.do" styleClass="navigator"><bean:message key="label.grouporg"/></html:link>
       <july:sepmark/> 
       <july:currmark><bean:message key="label.addgrouporg"/></july:currmark></td>
</tr>
--%>
<july:separator colspan="<%= gColSpan %>" />

<TR class="normal">
 <TD colspan="<%= gColSpan %>">
 
    <table class="find">
    <TR>
       <td class="title"><bean:message key="label.organization.inn"/></td>
       <td class="title"><july:checkbox property="isinn" insertable="true" updatable="true" onclick="switchInnSearch(document.all.isinn[0].checked)" />&nbsp;<bean:message key="label.search.all"/></td>
	   <td class="title"><html:text styleClass="editdisabled" property="orginn" styleId="orginn" size="25" disabled="true" /><july:searchbutton/></td>
     </tr>
    <TR>
       <td class="title"><bean:message key="label.organization.name"/></td>
       <td class="title"><july:checkbox property="isorgname" styleId="isorgname" insertable="true" updatable="true" onclick="switchNameSearch(document.all.isorgname[0].checked)" />&nbsp;<bean:message key="label.search.all"/></td>
	   <td class="title"><html:text styleClass="search" property="orgname" styleId="orgname" size="25" /></td>
     </tr>        
    <TR>
       <td class="title"><bean:message key="label.organization.issupplier"/></td>
       <td class="title" colspan="2"><july:checkbox property="selissupplier" insertable="true" updatable="true" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
       <bean:message key="label.organization.isrenter"/>&nbsp;<july:checkbox property="selisrenter"  insertable="true" updatable="true" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
       <bean:message key="label.organization.isprovider"/>&nbsp;<july:checkbox property="selisprovider" insertable="true" updatable="true" /></td>
     </tr>        
    <%-- TR>
       <td class="title"><bean:message key="label.organization.isrenter"/></td>
       <td class="title"><july:checkbox property="selisrenter"  insertable="true" updatable="true" /></td>
     </tr>        
    <TR>
       <td class="title"><bean:message key="label.organization.isprovider"/></td>
       <td class="title"><july:checkbox property="selisprovider" insertable="true" updatable="true" /></td>
     </tr --%>        
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
 switchNameSearch(document.all.isorgname[0].checked);
 switchInnSearch(document.all.isinn[0].checked);
 switchGroups(document.all.isgroup[0].checked);
</SCRIPT>

<july:separator colspan="<%= gColSpan %>" />

      <tr class="title">
          <td colspan="<%= gColSpan %>"><TABLE class="buttons">
            <TR class="title">
              <TD class="buttons"><july:savebutton/><july:backbutton/></TD>
              <TD class="navigator"><july:navigator/></TD>
            </TR>
            </TABLE></TD>
      </tr>
      
      <july:separator colspan="<%= gColSpan %>" />
  
    <!-- Table header -->
    <tr class="title">
        <july:headercolumn key="label.code" colType="number"/>
        <july:headercolumn key="label.organization.inn" colType="string"/>
        <july:headercolumn key="label.name" colType="string"/>
        <july:headercolumn key="label.organization.phone" colType="string"/>
        <TD class="title">&nbsp;</TD>
    </tr>

<july:separator colspan="<%= gColSpan %>" />


        <!-- Table body -->
    <logic:iterate id="org" name="browseList">
        <logic:present name="org">
            <tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
                <td class="number">
                    <bean:write name="org" property="organization" filter="true"/>
                </td>
                <td class="text">
                    <bean:write name="org" property="inn" filter="true"/>
                </td>
                <td class="text">
                    <bean:write name="org" property="name" filter="true"/>
                </td>
                <td class="text">
                    <bean:write name="org" property="phone" filter="true"/>
                </td>
                <% java.lang.String s = (java.lang.String)(RequestUtils.lookup(pageContext, "org", "organization", null).toString()); %>
                <td class="link"><july:checkbox property="selectedOrg" value="<%= s %>" insertable="true" updatable="true"/></td>
            </tr>

            <july:separator colspan="<%= gColSpan %>" />

	      </logic:present>
      </logic:iterate>
      
      <INPUT TYPE="HIDDEN" NAME="selectedOrg" VALUE="0">

      <tr class="title">
          <td colspan="<%= gColSpan %>"><TABLE class="buttons">
            <TR class="title">
              <TD class="buttons"><july:savebutton/><july:backbutton/></TD>
              <TD class="navigator"><july:navigator/></TD>
            </TR>
        </TABLE></TD>
</tr>
      
<july:separator colspan="<%= gColSpan %>" />
<%--      
      <tr class="title">
    	<td class="title" colspan="<%= gColSpan %>">
           <html:link page="/ShowGroupList.do" styleClass="navigator"><bean:message key="label.groups"/></html:link>
           <july:sepmark/> 
    	   <html:link page="/ShowGrouppingList.do" styleClass="navigator"><bean:message key="label.groupping"/></html:link>
           <july:sepmark/> 
           <html:link page="/ShowGrouporgList.do" styleClass="navigator"><bean:message key="label.grouporg"/></html:link>
           <july:sepmark/> 
           <july:currmark><bean:message key="label.addgrouporg"/></july:currmark></td>
      </tr>
--%>      
</table>

</july:browseform>
