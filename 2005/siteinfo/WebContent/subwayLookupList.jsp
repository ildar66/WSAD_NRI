<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "3"; %>

<july:browseform action="/ShowSubwayLookupList.do">

<july:lookupresult tableId="brtable" resultCols="0"/>

<table class="main">
<TR class="title">
 <TD class="title">
    <bean:message key="label.choosesubway"/>
 </TD>
</TR>
<TR class="normal">
 <TD>

    <table class="main">
    <TR>
        <td><bean:message key="label.search.byname"/></td>
	<td><html:text styleClass="search" property="subway" size="25" />	<july:searchbutton/></td>
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
            <july:headercolumn key="label.title" colType="number"/>
        </tr>

        <!-- Table body -->
        <logic:iterate id="wrk" name="browseList" indexId="index">
	      <logic:present name="wrk">
            <tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
                <td class="number"><july:lookupreturn><bean:write name="wrk" property="name" filter="true"/></july:lookupreturn></td>
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
