<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "5"; %>

<july:browseform action="/ShowOrganizationLookupList.do" styleId="OrgLookupForm">

<july:lookupresult tableId="brtable" resultCols="0;2"/>

<script language="javascript">
function switchNameSearch(state) {
	if(state) {
		OrgLookupForm.orgname.className = 'editdisabled';
		OrgLookupForm.orgname.disabled = true;
	} else {
		OrgLookupForm.orgname.className = 'search';
		OrgLookupForm.orgname.disabled = false;
	}
}
function switchInnSearch(state) {
	if(state) {
		OrgLookupForm.orginn.className = 'editdisabled';
		OrgLookupForm.orginn.disabled = true;
	} else {
		OrgLookupForm.orginn.className = 'search';
		OrgLookupForm.orginn.disabled = false;
	}
}
</script>

<table class="main">
<TR class="title">
 <TD class="title">
	<bean:message key="label.choose.organizations"/></td>
 </TD>
</TR>

<TR class="normal">
 <TD colspan="<%= gColSpan %>">
 
    <table class="main">
    <TR>
       <td class="title"><bean:message key="label.organization.inn"/></td>
       <td class="title"><july:checkbox property="isinn" insertable="true" updatable="true" onclick="switchInnSearch(document.all.isinn[0].checked)" /><html:hidden property="isinn" value="false"/>&nbsp;<bean:message key="label.all"/></td>
	   <td class="title"><html:text styleClass="editdisabled" property="orginn" styleId="orginn" size="25" disabled="true"/><july:searchbutton/></td>
     </tr>
    <TR>
       <td class="title"><bean:message key="label.organization.name"/></td>
       <td class="title"><july:checkbox property="isorgname" styleId="isorgname" insertable="true" updatable="true" onclick="switchNameSearch(document.all.isorgname[0].checked)" /><html:hidden property="isorgname" value="false"/>&nbsp;<bean:message key="label.all"/></td>
	   <td class="title"><html:text styleClass="search" property="orgname" styleId="orgname" size="25" /></td>
     </tr>        
    <TR>
       <td class="title"><bean:message key="label.organization.type"/></td>
       <td class="title" colspan="2">
	   		<bean:message key="label.organization.issupplier"/>&nbsp;<july:checkbox property="selissupplier" insertable="true" updatable="true" /><html:hidden property="selissupplier" value="false"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	   		<bean:message key="label.organization.isrenter"/>&nbsp;<july:checkbox property="selisrenter" insertable="true" updatable="true" /><html:hidden property="selisrenter" value="false"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<bean:message key="label.organization.isprovider"/>&nbsp;<july:checkbox property="selisprovider" insertable="true" updatable="true" /><html:hidden property="selisprovider" value="false"/>
	   </td>
     </tr>        
     </table>
  </TD>
</TR>

<SCRIPT language="javascript">
 switchNameSearch(document.all.isorgname[0].checked);
 switchInnSearch(document.all.isinn[0].checked);
</SCRIPT>

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
    	    <july:headercolumn key="label.organization.inn" colType="string"/>
	        <july:headercolumn key="label.name" colType="string"/>
    	    <july:headercolumn key="label.organization.phone" colType="string"/>
        </tr>

        <!-- Table body -->
        <logic:iterate id="org" name="browseList" indexId="index">
	      <logic:present name="org">
            <tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
                <td class="number"><bean:write name="org" property="organization" filter="true"/></td>
                <td class="text"><bean:write name="org" property="inn" filter="true"/></td>
                <td class="text"><july:lookupreturn><bean:write name="org" property="name" filter="true"/></july:lookupreturn></td>
                <td class="text"><bean:write name="org" property="phone" filter="true"/></td>
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
