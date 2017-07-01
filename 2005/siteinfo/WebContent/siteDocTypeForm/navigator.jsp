<%@ page import="com.hps.july.jdbcpersistence.lib.*,

                 com.hps.july.siteinfo.formbean.SiteDocTypeListForm"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld"    prefix="alex" %>

<%
String gColSpan = request.getAttribute("colspan")+"";
//SiteDocTypeListForm dForm=(SiteDocTypeListForm)pageContext.findAttribute("SiteDocTypeListForm");

%>

<%--
<tr class="title">
 <td class="title" colspan="<%= gColSpan %>">

<html:link page="/ShowSiteDocTypeList.do" styleClass="navigator">
 <bean:message key="SiteDocTypeList.header"/>
</html:link>

<july:sepmark/>
<july:actionname/>
 </td>
</tr>

--%>

