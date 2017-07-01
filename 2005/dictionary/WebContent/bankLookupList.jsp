<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import = "com.hps.july.dictionary.formbean.*"%>

<%!
private String isUp(String aSort, String name) {
 if(aSort.startsWith(name)) {
	 if(aSort.endsWith("desc")) 
		return (" <img src='/images/up.gif'  border='0' alt='по возрастанию'> ");
	 else
		return (" <img src='/images/down.gif'  border='0' alt='по убыванию'> "); 
 }
 else return ("");      
}
%>

<%
	java.lang.String gColSpan = "4";
	BankLookupListForm listForm = (BankLookupListForm)session.getAttribute("BankLookupListForm");
	String sortBy = listForm.getSortBy();
%>

<july:browseform action="/ShowBankLookupList.do" styleId="BankForm">
<html:hidden property="sortBy"/>

<july:lookupresult tableId="brtable" resultCols="1;0;2"/>

<script language="javascript">
function switchNameSearch(state) {
	if(state) {
		BankForm.bankname.className = 'editdisabled';
		BankForm.bankname.disabled = true;
	} else {
		BankForm.bankname.className = 'editsearch';
		BankForm.bankname.disabled = false;
	}
}
function switchBikSearch(state) {
	if(state) {
		BankForm.bankbik.className = 'editdisabled';
		BankForm.bankbik.disabled = true;
	} else {
		BankForm.bankbik.className = 'editsearch';
		BankForm.bankbik.disabled = false;
	}
}
function SortBy(field) 
{
	var e = document.all.sortBy;
	e.value = (e.value == field)?field + ' desc':field;
    document.body.style.cursor="wait";
	BankForm.submit();
	return false;
}
</script>


<table class="main">
<tr class="title">
 <TD class="title">
    <bean:message key="label.choose.bank"/>
 </TD>
</tr>
<TR class="normal">
 <TD>
     <table class="find">
    <TR>
       <td class="title"><bean:message key="label.organization.bik"/></td>
       <td class="title"><july:checkbox property="isbik" onclick="switchBikSearch(document.all.isbik[0].checked)" insertable="true" updatable="true" />&nbsp;<bean:message key="label.search.all"/>&nbsp;&nbsp;&nbsp;<html:text styleClass="search" property="bankbik" size="25" /><july:searchbutton/></td>
     </TR>        
    <TR>
       <td class="title"><bean:message key="label.bank.name"/></td>
       <td class="title"><july:checkbox property="isname" onclick="switchNameSearch(document.all.isname[0].checked)" insertable="true" updatable="true" />&nbsp;<bean:message key="label.search.all"/>&nbsp;&nbsp;&nbsp;<html:text styleClass="search" property="bankname" size="25" /></td>
     </TR>        
     </table>
    
  </TD>
</TR>

<SCRIPT language="javascript">
 switchNameSearch(document.all.isname[0].checked);
 switchBikSearch(document.all.isbik[0].checked);
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
		<TD class="title">
			<A title="Сортировать по полю 'organization'" href="javascript:SortBy('organization')"><bean:message key="label.code"/></A>
			<%=isUp(sortBy, "organization")%>
		</TD>
		<TD class="title">
			<A title="Сортировать по полю 'bik'" href="javascript:SortBy('bik')"><bean:message key="label.organization.bik"/></A>
			<%=isUp(sortBy, "bik")%>
		</TD>
		<TD class="title">
			<A title="Сортировать по полю 'name'" href="javascript:SortBy('name')"><bean:message key="label.name"/></A>
			<%=isUp(sortBy, "name")%>
		</TD>
		<TD class="title">
			<A title="Сортировать по полю ''" href="javascript:SortBy('koraccount')"><bean:message key="label.bank.corraccount"/></A>
			<%=isUp(sortBy, "koraccount")%>
		</TD>
       </tr>

        <!-- Table body -->
        <logic:iterate id="org" name="browseList" indexId="index">
	      <logic:present name="org">
            <tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
                <td class="number"><bean:write name="org" property="organization" filter="true"/></td>
                <td class="text"><bean:write name="org" property="bik" filter="true"/></td>
                <td class="text"><july:lookupreturn><bean:write name="org" property="name" filter="true"/></july:lookupreturn></td>
                <td class="text"><bean:write name="org" property="koraccount" filter="true"/></td>
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
