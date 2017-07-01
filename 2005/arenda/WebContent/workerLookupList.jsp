<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import = "com.hps.july.arenda.formbean.*"%>

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
	java.lang.String gColSpan = "3";
	WorkerLookupListForm listForm = (WorkerLookupListForm)session.getAttribute("WorkerLookupListForm");
	String sortBy = listForm.getSortBy();
%>

<july:browseform action="/ShowWorkerLookupList.do" styleId="listForm" focus="lastname">
<html:hidden property="sortBy"/>
<script language="javascript">
function SortBy(field) 
{
	var e = document.all.sortBy;
	e.value = (e.value == field)?field + ' desc':field;
    document.body.style.cursor="wait";
	listForm.submit();
	return false;
}
</script>
<july:lookupresult tableId="brtable" resultCols="0;1"/>

<TABLE class="main">
<TR class="title">
 <TD class="title">
    <bean:message key="label.choose.maineconomist"/>
 </TD>
</TR>

<TR class="normal">
 <TD>
    <table class="main">
    <tr>
        <td><bean:message key="label.people.lastname"/></td>
        <td><html:text styleClass="search" property="lastname" size="25" /><july:searchbutton/></td>
     </tr>        
     </table>
  </TD>
</TR>

<tr class="title">
	<td>
		<TABLE class="buttons">
			<TR class="title">
				<TD class="buttons"><july:closebutton page="/"/></TD>
				<td align="right">
					отобрано записей:<%= request.getAttribute("numberOfLines") %>
				</td>
				<TD class="navigator"><july:navigator/></TD>
			</TR>
		</TABLE>
	</td>
</tr>

<TR>
  <TD>
    <table class="main" id="brtable">
        <!-- Table header -->
        <tr class="title">
			<td class="title" nowrap>
				<A title="Сортровать по полю 'код'" href="javascript:SortBy('worker')">Код</A>
				<%=isUp(sortBy, "worker")%>
			</td>
			<td class="title" nowrap>
				<A title="Сортровать по полю 'ФИО'" href="javascript:SortBy('lastname')">ФИО</A>
				<%=isUp(sortBy, "lastname")%>
			</td>
			<td class="title" nowrap>
				<A title="Сортровать по полю 'Должность'" href="javascript:SortBy('wpname')">Должность</A>
				<%=isUp(sortBy, "wpname")%>
			</td>
         </tr>
        <!-- Table body -->
        <logic:iterate id="wrk" name="browseList" indexId="index">
	      <logic:present name="wrk">
            <tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
                <td class="number"><bean:write name="wrk" property="worker" filter="true"/></td>
                <td class="text"><july:lookupreturn><bean:write name="wrk" property="man.name" filter="true"/></july:lookupreturn></td>
                <td class="text"><bean:write name="wrk" property="position.name" filter="true"/></td>
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
	<td>
		<TABLE class="buttons">
			<TR class="title">
				<TD class="buttons"><july:closebutton page="/"/></TD>
				<td align="right">
					отобрано записей:<%= request.getAttribute("numberOfLines") %>
				</td>
				<TD class="navigator"><july:navigator/></TD>
			</TR>
		</TABLE>
	</TD>
</tr>

</TABLE>
</july:browseform>
