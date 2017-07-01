<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "2"; %>

<july:browseform action="/ShowPeopleLookupList.do">

<july:lookupresult tableId="brtable" resultCols="0;1;2;3"/>

<table class="main">
<TR class="title">
 <TD class="title">
    <bean:message key="label.choose.people"/>
 </TD>
</TR>
<TR class="normal">
 <TD>
 
    <table class="find">
    <TR>
        <td><bean:message key="label.people.lastname"/></td>
        <td><html:text styleClass="search" property="lastname" size="25" /><july:searchbutton/></td>
     </tr>        
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

<TR>
  <TD>

    <table class="main" id="brtable">

        <!-- Table header -->
        <tr class="title">
        <july:headercolumn key="label.code" colType="number"/>
        <july:sortcolumn ascFinder="1" descFinder="2" key="label.people.fullname" colType="string"/>
        <td class='title' style="visibility:hidden;display:none;"></td>
        <td class='title' style="visibility:hidden;display:none;"></td>
        <%--
        <july:headercolumn key="label.people.firstname" colType="number"/>
        <july:headercolumn key="label.people.middlename" colType="number"/>
        --%>
        </tr>

        <!-- Table body -->
        <logic:iterate id="ppl" name="browseList" indexId="index">
	      <logic:present name="ppl">
            <tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
                <td class="number"><bean:write name="ppl" property="ab.man" filter="true"/></td>
                <td class="text"><july:lookupreturn><bean:write name="ppl" property="ab.fullName" filter="true"/></july:lookupreturn></td>
                <td class="text" style="visibility:hidden;display:none;">
                    <july:lookupreturn>
                        <bean:write name="ppl" property="firstOperator" filter="true"/>
                    </july:lookupreturn>
                </td>
                <td class="text" style="visibility:hidden;display:none;"><july:lookupreturn><bean:write name="ppl" property="operatorToCopy" filter="true"/></july:lookupreturn></td>
                <%--
                <td class="text">
                    <bean:write name="ppl" property="firstname" filter="true"/>
                </td>
                <td class="text">
                    <bean:write name="ppl" property="middlename" filter="true"/>
                </td>
                --%>
            </tr>

	      </logic:present>
          
	      <logic:notPresent name="ppl">
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
