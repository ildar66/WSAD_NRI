<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "2"; %>

<july:browseform action="/ShowGroupLookupList.do">

<html:hidden property="department"/>

<july:lookupresult tableId="brtable" resultCols="0;1"/>

<table class="main">
<TR class="title">
 <TD class="title">
    <bean:message key="label.choose.group"/>
 </TD>
</TR>
<TR class="normal">
 <TD>
 
    <table class="main">
    <TR>
       <td class="title"><bean:message key="label.department.name"/>:</td>
       <td class="title"><bean:write name="GroupLookupListForm" property="departmentname" /></td>
        <TD class="navigator" rowspan="1"><july:navigator/></TD>
     </tr>        
     </table>
    
  </TD>
</TR>


<TR>
  <TD>

    <table class="main" id="brtable">

        <!-- Table header -->
        <tr class="title">
            <july:headercolumn key="label.code" colType="number"/>
            <july:headercolumn key="label.name" colType="string"/>
        </tr>

        <!-- Table body -->
        <logic:iterate id="lkl" name="browseList" indexId="index">
	      <logic:present name="lkl">
            <tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
                <td class="number"><bean:write name="lkl" property="division" filter="true"/></td>
                <td class="text"><july:lookupreturn>
                    <bean:write name="lkl" property="name" filter="true"/></july:lookupreturn>
                </td>
            </tr>

            <july:separator colspan="<%= gColSpan %>" />

	      </logic:present>
        </logic:iterate>

        <tr class="title">
          <td colspan="<%= gColSpan %>">&nbsp;</td>
        </tr>
    </table>
</TD>
</TR>
</TABLE>

</july:browseform>
