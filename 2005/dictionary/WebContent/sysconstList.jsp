<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "7"; %>

<july:browseform action="/ShowSysconstList.do">


<table class="main">
<%--
<tr class="title">
	<td class="title" colspan="<%= gColSpan %>">
       <july:currmark><bean:message key="label.sysconst"/></july:currmark></td>
</tr>
--%>
<july:separator colspan="<%= gColSpan %>" />

<TR class="normal">
 <TD colspan="<%= gColSpan %>">
 
    <table class="find">
    <TR>
       <td class="title">&nbsp;</td>
       <td class="title"></td>
     </tr>        
     </table>
    
  </TD>
</TR>


<july:separator colspan="<%= gColSpan %>" />

        <tr class="title">
          <td colspan="<%= gColSpan %>"><TABLE class="buttons">
            <TR class="title">
              <TD class="buttons"><july:addbutton page="/EditSysconst.do?action=Add"/><july:backbutton page="/main.do"/></TD>
              <TD class="navigator"><july:navigator/></TD>
            </TR>
            </TABLE></TD>
        </tr>
        
      <july:separator colspan="<%= gColSpan %>" />

        <!-- Table header -->
        <tr class="title">
            <TD class="title" width="1%">&nbsp;</TD>
            <july:headercolumn key="label.sysconst.id" colType="string"/>
            <july:headercolumn key="label.sysconst.charvalue" colType="string"/>
            <july:headercolumn key="label.sysconst.intvalue" colType="number"/>
            <july:headercolumn key="label.sysconst.datevalue" colType="string"/>
            <july:headercolumn key="label.sysconst.decimalvalue" colType="number"/>
            <TD class="title" width="1%">&nbsp;</TD>
        </tr>


<july:separator colspan="<%= gColSpan %>" />

    
        <!-- Table body -->
        <logic:iterate id="scl" name="browseList">
	      <logic:present name="scl">
            <tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
                <td class="text">
                    <july:editbutton page="/EditSysconst.do" action="Edit" paramId="id" paramName="scl" paramProperty="id" paramScope="page"/>
		</td>
                <td class="text">
                    <bean:write name="scl" property="id" filter="true"/>
                </td>
                <td class="text">
                    <bean:write name="scl" property="charvalue" filter="true"/>
                </td>
                <td class="number">
                    <bean:write name="scl" property="intvalue" filter="true"/>
                </td>
                <td class="text">
                    <july:datewrite name="scl" property="datevalue" showtime="false"/>
                </td>
                <td class="number">
                    <bean:write name="scl" property="decimalvalue" filter="true"/>
                </td>
                <td class="link"><july:delbutton page="/EditSysconst.do?action=Delete" paramId="id" paramName="scl" paramProperty="id" paramScope="page"/></td>
            </tr>

            <july:separator colspan="<%= gColSpan %>" />

	      </logic:present>
        </logic:iterate>

        <tr class="title">
          <td colspan="<%= gColSpan %>"><TABLE class="buttons">
            <TR class="title">
              <TD class="buttons"><july:addbutton page="/EditSysconst.do?action=Add"/><july:backbutton page="/main.do"/></TD>
              <TD class="navigator"><july:navigator/></TD>
            </TR>
            </TABLE></TD>
        </tr>
        
      <july:separator colspan="<%= gColSpan %>" />
<%--      
      <tr class="title">
    	<td class="title" colspan="<%= gColSpan %>">
           <july:currmark><bean:message key="label.sysconst"/></july:currmark></td>
      </tr>
--%>        
</table>

</july:browseform>
