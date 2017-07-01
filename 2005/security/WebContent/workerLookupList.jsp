<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "3"; %>

<july:browseform action="/ShowWorkerLookupList.do" styleId="WorkerLookupForm">

<july:lookupresult tableId="brtable" resultCols="0;1"/>

<script language="javascript">
function switchSearch(state) {
	if(state) {
		WorkerLookupForm.divcode.className = 'editkoddisabled';
		WorkerLookupForm.divcode.disabled = true;
		WorkerLookupForm.lastname.className = 'editdisabled';
		WorkerLookupForm.lastname.disabled = true;
	} else {
		WorkerLookupForm.divcode.className = 'editkoddisabled';
		WorkerLookupForm.divcode.disabled = true;
		WorkerLookupForm.lastname.className = 'editsearch';
		WorkerLookupForm.lastname.disabled = false;
	}
}
</script>

<table class="main">
<TR class="title">
 <TD class="title">
    <bean:message key="label.choose.worker"/>
 </TD>
</TR>
<TR class="normal">
 <TD>
    <table class="find">
    <logic:present name="WorkerLookupListForm" property="divcode">
    <TR>
        <td><bean:message key="label.worker.division"/></td>
        <td><july:radio property="searchby" value="D" onclick="switchSearch(document.all.searchby [0].checked);" insertable="true" updatable="true"/>
          <july:string property="divcode" size="5" insertable="true" updatable="true"/>
          <july:string property="divname" size="25" insertable="false" updatable="false"/><july:searchbutton/></td>
     </TR>        
     </logic:present>
    <TR>
        <td><bean:message key="label.people.lastname"/></td>
        <td>
          <logic:present name="WorkerLookupListForm" property="divcode">
           <july:radio property="searchby" value="N" onclick="switchSearch(document.all.searchby [0].checked);" insertable="true" updatable="true"/>
          </logic:present>
           <html:text styleClass="search" property="lastname" size="25" />
          <logic:notPresent name="WorkerLookupListForm" property="divcode">
           <july:searchbutton/></td>
          </logic:notPresent>
     </TR>        
     </table>
    
  </TD>
</TR>
<logic:present name="WorkerLookupListForm" property="divcode">
<SCRIPT language="javascript">
 switchSearch(document.all.searchby [0].checked);
</SCRIPT>
</logic:present>

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
