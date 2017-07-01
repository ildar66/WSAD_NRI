<%@ page import="com.hps.july.jdbcpersistence.lib.*"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld"    prefix="alex" %>

<%
String gColSpan = request.getAttribute("colspan")+"";
%>

<tr class="title">
 <td class="title" colspan="<%= gColSpan %>">

<jsp:include page="/menu/historyNavigator.jsp" flush="true"/>

<july:sepmark/>



<html:link page="/ShowSiteDocList.do" styleClass="navigator">
    <bean:message  key="SiteDocList.menu"/>
</html:link>

<july:sepmark/>

<july:actionname/>
 </td>
</tr>

