<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "2"; %>

<july:browseform action="/ShowOperatorLookupList.do">

<july:lookupresult tableId="opertable" resultCols="0;1"/>

<table class="main">
<TR class="title">
 <TD class="title">
    <bean:message key="label.choose.operator"/>
 </TD>
</TR>

<!-- FIO begin -->
<tr class="normal">
    <td class="title">
            <bean:message key="label.people.fullname"/>:
            <bean:write name='OperatorLookupListForm' property="fullName"/>
    </td>
</tr>
<!-- FIO end -->

<%--TR class="normal">
 <TD>
 
    <table class="find">
    <TR>
        <td><bean:message key="label.operator.loginid"/></td>
        <td><html:text styleClass="search" property="loginid" size="25" /><july:searchbutton/></td>
     </tr>        
     </table>
    
  </TD>
</TR--%>

<tr class="title">
  <td><TABLE class="buttons">
    <TR class="title">
      <TD class="buttons"><july:closebutton page="/"/></TD>
      <TD class="navigator"></TD>
    </TR>
    </TABLE></TD>
</tr>

<TR>
  <TD>

    <table class="main" id="opertable">

        <!-- Table header -->
        <tr class="title">
        <july:headercolumn key="label.operator.code" colType="string"/>
        <td class='title' style="visibility:hidden;display:none;"></td>
        <%--july:headercolumn key="label.operator.loginid" colType="string"/--%>
        </tr>

        <!-- Table body -->
        <logic:iterate id="operators" name="browseList" indexId="index">
	      <logic:present name="operators">
                <tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
                    <td class="text" style="visibility:hidden;display:none;"><july:lookupreturn><bean:write name="operators" property="operator" filter="true"/></july:lookupreturn></td>
                    <td class="text">
                      <july:lookupreturn><bean:write name="operators" property="login" filter="true"/></july:lookupreturn>
                    </td>
                </tr>

	      </logic:present>
          
	      <logic:notPresent name="operators">
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
      <TD class="navigator"></TD>
    </TR>
    </TABLE></TD>
</tr>

</TABLE>
    
</july:browseform>
