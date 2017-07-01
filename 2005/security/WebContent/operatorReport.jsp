<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "1"; %>

<table class="main">
<tr class="title">
	<td class="title" colspan="<%= gColSpan %>">
       <july:currmark><bean:message key="label.operreport"/></july:currmark></td>
</tr>

<TR class="normal">
 <TD colspan="<%= gColSpan %>">
 
    <table class="find">
     <TR>
       <td class="title">&nbsp;</td>
       <td class="title">&nbsp;</td>
     </TR>        
     </table>
    
  </TD>
</TR>

<july:separator colspan="<%= gColSpan %>" />

        <tr class="title">
          <td colspan="<%= gColSpan %>"><TABLE class="buttons">
            <TR class="title">
              <TD class="buttons"><july:backbutton page="/main.do"/></TD>
            </TR>
            </TABLE></TD>
        </tr>
        
      <july:separator colspan="<%= gColSpan %>" />

        <!-- Table header -->
        <tr class="title">
            <TD>
               <july:report report="access1.rpt"/>
            </TD>
        </tr>


      <july:separator colspan="<%= gColSpan %>" />

        <tr class="title">
          <td colspan="<%= gColSpan %>"><TABLE class="buttons">
            <TR class="title">
              <TD class="buttons"><july:backbutton page="/main.do"/></TD>
            </TR>
            </TABLE></TD>
        </tr>
        
      <july:separator colspan="<%= gColSpan %>" />

    
      
    <tr class="title">
    	<td class="title" colspan="<%= gColSpan %>">
          <july:currmark><bean:message key="label.operreport"/></july:currmark></td>
    </tr>
        
    </table>
