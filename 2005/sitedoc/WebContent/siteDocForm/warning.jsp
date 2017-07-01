<%@ page language = "java" %>
<%@ page import="com.hps.july.persistence.*"%>
<%@ page import="com.hps.july.sitedoc.formbean.SiteDocForm"%>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld"    prefix="alex" %>

<%
String gColSpan = request.getAttribute("colspan")+"";
SiteDocForm dForm=(SiteDocForm)pageContext.findAttribute("SiteDocForm");
boolean hasLinks=dForm.hasLinks();
boolean hasFiles=dForm.hasFiles();
boolean hasProjectActions=dForm.hasProjectActions();
%>

<tr>
     <td class="title" colspan="2">
 <%if(hasFiles){%>

<FONT class="attention"><B>
 <bean:message key="SiteDocForm.warning.hasFiles" />
</B></FONT>
  <br>
 <%}%>
 <%if(hasLinks){%>
 <FONT class="attention"><B>
<bean:message key="SiteDocForm.warning.hasLinks" />
</B></FONT>
<br>
 <%}%>

<%if(hasProjectActions){%>
 <FONT class="attention"><B>
<bean:message key="SiteDocForm.warning.projectActions" />
</B></FONT>
<br>
<%}%>


<%if(hasFiles||hasLinks||hasProjectActions){%>
<FONT class="attention"><B>
<bean:message key="SiteDocForm.confirm.delete" />!
 </B></FONT>

 <%}%>


     </td>
</tr>





