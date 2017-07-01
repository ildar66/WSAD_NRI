<%@ page language = "java" import="com.hps.july.inventory.formbean.DivisionLookupListForm" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<%

DivisionLookupListForm division = (DivisionLookupListForm)session.getAttribute("DivisionLookupListForm");
int countLevel = division.getCountLevel();
int[] history = division.getHistory();
int parent;
if(countLevel>1) parent=history[countLevel-1];
else parent=-1;

%>

<% java.lang.String gColSpan = "3"; %>

<july:browseform action="/ShowDivisionLookupList.do" styleId="OrgForm">
<july:lookupresult tableId="brtable" resultCols="0;1"/>

<table class="main">
<TR class="title">
 <TD class="title">
	 <jsp:include page="/divisionLookupHeaders.jsp" flush="true"></jsp:include>
 </TD>
</TR>
<tr class="title">
  <td><TABLE class="buttons">
    <TR class="title">
      <TD class="buttons"><july:closebutton page="/"/>&nbsp;&nbsp;
	<%if(countLevel > 0){%>
	  <a href="ShowDivisionLookupList.do?upparent=<%=parent%>&countLevel=<%=countLevel-1%>"><img src="/images/ups.gif" alt="�� ������� �����" border="0"></a>
	<%}%></TD>
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
            <july:headercolumn key="label.divisionname" colType="string"/>
            <july:headercolumn key="label.open" colType="string"/>
        </tr>

        <!-- Table body -->		
        <logic:iterate id="org" name="browseList" indexId="index">
	      <logic:present name="org">
            <tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
                <td class="number"><bean:write name="org" property="division" filter="true"/></td>
                <td class="text"><july:lookupreturn><bean:write name="org" property="name" filter="true"/></july:lookupreturn></td>
				<td class="text"><a href="ShowDivisionLookupList.do?parent=<bean:write name="org" property="division"/>"><bean:message key="label.open"/></a></td>
            </tr><%-- up=false&isRoot=<%=division.isIsRoot()%>& --%>
	      </logic:present>
		  <july:separator colspan="<%= gColSpan %>" />           
        </logic:iterate>

    </table>
</TD>
</TR>

<tr class="title">
  <td><TABLE class="buttons">
    <TR class="title">
      <TD class="buttons"><july:closebutton page="/"/>&nbsp;&nbsp;
	  <%if(countLevel > 0){%>
	  <a href="ShowDivisionLookupList.do?upparent=<%=parent%>&countLevel=<%=countLevel-1%>"><img src="/images/ups.gif" alt="�� ������� �����" border="0"></a>
	  <%}%></TD>
      <TD class="navigator"><july:navigator/></TD>
    </TR>
    </TABLE></TD>
</tr>
<july:separator colspan="<%= gColSpan %>" />
<TR class="title">
 <TD class="title">
	 <jsp:include page="/divisionLookupHeaders.jsp" flush="true"></jsp:include>
 </TD>
</TR>
<july:separator colspan="<%= gColSpan %>" />
</TABLE>

</july:browseform>
