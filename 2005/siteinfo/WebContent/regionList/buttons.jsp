<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld"    prefix="alex" %>

<% String gColSpan = request.getAttribute("colspan")+"";
//SiteDocTypeListForm dForm=(SiteDocTypeListForm)pageContext.findAttribute("SiteDocTypeListForm");
%>
<tr class="title">
          <td colspan="<%= gColSpan %>">
          <TABLE class="buttons">
            <TR class="title">
              <TD class="buttons"><july:addbutton page="/EditRegion.do?action=Add"/><july:backbutton page="/main.do"/></TD>
              <TD class="navigator"><july:navigator/></TD>
            </TR>
          </TABLE></TD>
</tr>



